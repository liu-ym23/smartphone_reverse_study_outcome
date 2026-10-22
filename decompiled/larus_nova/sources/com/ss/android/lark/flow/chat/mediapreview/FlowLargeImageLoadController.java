package com.ss.android.lark.flow.chat.mediapreview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.larksuite.framework.utils.NetworkUtils;
import com.ss.android.lark.biz.officesdk.im.mediapreview.GallerySource;
import com.ss.android.lark.chat.preview.entity.component.property.DocImageProperty;
import com.ss.android.lark.flow.chat.message.image.FlowYunPanFileUtils;
import com.ss.android.lark.flow.chat.message.image.f;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.IRequestCreator;
import com.ss.android.lark.image.utils.ChatImageSettings;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.vfs.VFSPath;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import com.ss.android.lark.widget.photopicker.entity.PhotoState;
import java.io.File;
import java.io.Serializable;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kza.j;
import nlb.g;

/* JADX INFO: loaded from: classes36.dex */
public final class FlowLargeImageLoadController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f422193a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FlowLargeImageView f422194b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final GallerySource f422195c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f422196d;

    public static final class a {
    }

    public static final class b implements com.ss.android.lark.widget.photo.preview.utils.b {
        public b() {
        }

        @Override // com.ss.android.lark.widget.photo.preview.utils.b
        public final File a(IRequestCreator r100, com.ss.android.lark.image.entity.b r101) {
            Intrinsics.checkNotNullParameter(r100, "requestCreator");
            Intrinsics.checkNotNullParameter(r101, "imageKey");
            f r102 = f.f422584a;
            return f.d(r101);
        }
    }

    public static final class c implements FlowLargeImageView.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f422197a;

        @Override // com.ss.android.lark.flow.chat.mediapreview.FlowLargeImageView.b
        public final void onLoadFailed() {
            j r100 = this.f422197a;
            if (r100 == null) goto L6;
            r100.a("");
            return;
        }

        @Override // com.ss.android.lark.flow.chat.mediapreview.FlowLargeImageView.b
        public final void onLoadSuccess() {
            j r100 = this.f422197a;
            if (r100 == null) goto L6;
            r100.onLoadSuccess();
            return;
        }

        public c(j r100) {
            this.f422197a = r100;
        }
    }

    static {
    }

    public static String d(PhotoItem r100) {
        return "photoItem:" + r100.getMessageId() + ", ";
    }

    public FlowLargeImageLoadController(Context r100, FlowLargeImageView r101, GallerySource r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "largeImageView");
        Intrinsics.checkNotNullParameter(r102, "source");
        this.f422193a = r100;
        this.f422194b = r101;
        this.f422195c = r102;
        this.f422196d = new b();
    }

    public final Object c(PhotoItem r100, FlowLargeImageView.b r110, Continuation<? super Unit> r111) {
        if ((r111 instanceof FlowLargeImageLoadController$downloadOrigin$1) == false) goto L7;
        FlowLargeImageLoadController$downloadOrigin$1 r101 = (FlowLargeImageLoadController$downloadOrigin$1) r111;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r112 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        if (r104 == 0) goto L18;
        if (r104 == 1) goto L17;
        if (r104 == 2) goto L16;
        if (r104 != 3) goto L15;
        FlowLargeImageView.b r105 = (FlowLargeImageView.b) r101.L$0;
        ResultKt.throwOnFailure(r112);
    L33:
        if (((Boolean) r112).booleanValue() == true) goto L37;
        if (r105 == null) goto L37;
        r105.onLoadFailed();
    L37:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r112);
    L27:
        return Unit.INSTANCE;
    L17:
        r110 = (FlowLargeImageView.b) r101.L$1;
        r100 = (PhotoItem) r101.L$0;
        ResultKt.throwOnFailure(r112);
    L21:
        File r113 = (File) r112;
        r100.getPhotoState().setOriginFile(r113);
        if (r113 == null) goto L28;
        Log.i("FlowLargeImageLoadController", d(r100) + "has downloaded origin success");
        r101.L$0 = null;
        r101.L$1 = null;
        r101.label = 2;
        if (g(r100, r113, r110, r101) != r103) goto L27;
        return r103;
    L28:
        Log.i("FlowLargeImageLoadController", d(r100) + "has downloaded origin failed");
        CoroutineDispatcher r114 = Dispatchers.getIO();
        FlowLargeImageLoadController$downloadOrigin$hasCache$1 r106 = new FlowLargeImageLoadController$downloadOrigin$hasCache$1(this, r100, null);
        r101.L$0 = r110;
        r101.L$1 = null;
        r101.label = 3;
        r112 = BuildersKt.withContext(r114, r106, r101);
        if (r112 != r103) goto L31;
        return r103;
    L31:
        r105 = r110;
        goto L33
    L18:
        ResultKt.throwOnFailure(r112);
        Log.i("FlowLargeImageLoadController", d(r100) + "download origin file");
        CoroutineDispatcher r115 = Dispatchers.getIO();
        FlowLargeImageLoadController$downloadOrigin$originFile$1 r107 = new FlowLargeImageLoadController$downloadOrigin$originFile$1(this, r100, null);
        r101.L$0 = r100;
        r101.L$1 = r110;
        r101.label = 1;
        r112 = BuildersKt.withContext(r115, r107, r101);
        if (r112 != r103) goto L21;
        return r103;
    L7:
        r101 = new FlowLargeImageLoadController$downloadOrigin$1(this, r111);
        goto L8
    }

    public final Object e(PhotoItem r210, FlowLargeImageView$loadDefault$1.AnonymousClass1.a r211, Continuation r212) {
        PhotoItem r100 = r210;
        FlowLargeImageView.b r101 = r211;
        if ((r212 instanceof FlowLargeImageLoadController$loadPhoto$1) == false) goto L7;
        FlowLargeImageLoadController$loadPhoto$1 r102 = (FlowLargeImageLoadController$loadPhoto$1) r212;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L22;
        if (r106 == 1) goto L21;
        if (r106 == 2) goto L20;
        if (r106 == 3) goto L19;
        if (r106 == 4) goto L18;
        if (r106 != 5) goto L17;
        ResultKt.throwOnFailure(r104);
    L81:
        return Unit.INSTANCE;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r104);
    L86:
        return Unit.INSTANCE;
    L19:
        FlowLargeImageView.b r107 = (FlowLargeImageView.b) r102.L$1;
        PhotoItem r108 = (PhotoItem) r102.L$0;
        ResultKt.throwOnFailure(r104);
        Object r109 = r105;
    L72:
        File r110 = (File) r104;
        if (r110 != null) goto L75;
    L82:
        r102.L$0 = null;
        r102.L$1 = null;
        r102.label = 4;
        if (c(r108, r107, r102) != r109) goto L86;
        return r109;
    L75:
        if (r110.exists() == false) goto L82;
        r108.getPhotoState().setMiddleFile(r110);
        r102.L$0 = null;
        r102.L$1 = null;
        r102.label = 5;
        if (g(r108, r110, r107, r102) != r109) goto L81;
        return r109;
    L20:
        ResultKt.throwOnFailure(r104);
    L96:
        return Unit.INSTANCE;
    L21:
        FlowLargeImageView.b r111 = (FlowLargeImageView.b) r102.L$1;
        PhotoItem r112 = (PhotoItem) r102.L$0;
        ResultKt.throwOnFailure(r104);
        r101 = r111;
        r100 = r112;
    L25:
        boolean r113 = ((Boolean) r104).booleanValue();
        if (r100.getPhotoState().getOriginFile() == null) goto L28;
        boolean r114 = true;
    L29:
        Context r115 = this.f422193a;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r115, PerfLog.PARAM_KEY_CONTEXT_ID);
        PhotoState r116 = r100.getPhotoState();
        PhotoItem.PicInfo r117 = r100.getOriginPicInfo();
        if (r117 == null) goto L32;
        Serializable r118 = r117.loadModel;
    L33:
        PhotoItem.PicInfo r119 = r100.getMiddlePicInfo();
        if (r119 == null) goto L36;
        Serializable r120 = r119.loadModel;
    L37:
        ChatImageSettings.LargeImageRemoteTarget r121 = ChatImageSettings.getLargeImageRemote().getTarget();
        long r122 = ((long) r121.getAutoOriginMax()) * 1024;
        boolean r123 = r116.isLoadOrigin();
        boolean r124 = Intrinsics.areEqual(PlayerResolution.SDKKEY.ORIGIN, r121.getDefaultTarget());
        if (r116.getOriginFile() == null) goto L40;
        boolean r125 = true;
    L41:
        boolean r213 = r114;
        boolean r126 = !r100.isOriginSource();
        boolean r127 = Intrinsics.areEqual(r118, r120);
        if (NetworkUtils.d(r115) == true) goto L44;
    L46:
        boolean r128 = false;
    L47:
        boolean r129 = r116.isFromMe();
        if (r100.getOriginSize() > r122) goto L50;
        boolean r130 = true;
    L51:
        if (r123 == true) goto L61;
        if (r124 == true) goto L61;
        if (r125 == true) goto L61;
        if (r126 == true) goto L61;
        if (r127 == true) goto L61;
        if (r128 == false) goto L60;
        if (r129 == true) goto L61;
        if (r130 == true) goto L61;
    L60:
        boolean r131 = false;
    L62:
        Log.i("needAutoLoadOrigin", r100.getMessageId() + ":  needShowOrigin:" + r131 + " --> isLoadOrigin:" + r123 + ", remoteConfigOrigin:" + r124 + ", hasOriginCache:" + r125 + ", isSendCommonMode:" + r126 + ", origin and middle is same key:" + r127 + ", isNetGood:" + r128 + ", isFromMe:" + r129 + ", is small icon:" + r130);
        if (r131 == true) goto L88;
        if (this.f422195c == GallerySource.ReplayThread) goto L88;
        if (r113 == true) goto L98;
        Log.i("FlowLargeImageLoadController", d(r100) + "no any cache, auto download middle file");
        CoroutineDispatcher r132 = Dispatchers.getIO();
        FlowLargeImageLoadController$loadPhoto$middleFile$1 r133 = new FlowLargeImageLoadController$loadPhoto$middleFile$1(this, r100, null);
        r102.L$0 = r100;
        r102.L$1 = r101;
        r102.label = 3;
        r104 = BuildersKt.withContext(r132, r133, r102);
        r109 = r105;
        if (r104 != r109) goto L71;
        return r109;
    L71:
        FlowLargeImageView.b r214 = r101;
        r108 = r100;
        r107 = r214;
    L98:
        return Unit.INSTANCE;
    L88:
        if (r213 == true) goto L98;
        Log.i("FlowLargeImageLoadController", d(r100) + "no origin cache, auto download origin file");
        if (r113 == false) goto L92;
        r101 = null;
    L92:
        r102.L$0 = null;
        r102.L$1 = null;
        r102.label = 2;
        if (b(r113, r100, r101, r102) != r105) goto L96;
        return r105;
    L61:
        r131 = true;
        goto L62
    L50:
        r130 = false;
        goto L51
    L44:
        if (pac.a.a() == true) goto L46;
        r128 = true;
        goto L47
    L40:
        r125 = false;
        goto L41
    L36:
        r120 = null;
        goto L37
    L32:
        r118 = null;
        goto L33
    L28:
        r114 = false;
        goto L29
    L22:
        ResultKt.throwOnFailure(r104);
        CoroutineDispatcher r134 = Dispatchers.getIO();
        FlowLargeImageLoadController$loadPhoto$hasCache$1 r135 = new FlowLargeImageLoadController$loadPhoto$hasCache$1(this, r100, r101, null);
        r102.L$0 = r100;
        r102.L$1 = r101;
        r102.label = 1;
        r104 = BuildersKt.withContext(r134, r135, r102);
        if (r104 != r105) goto L25;
        return r105;
    L7:
        r102 = new FlowLargeImageLoadController$loadPhoto$1(this, r212);
        goto L8
    }

    public final Object f(ogb.a r100, j r101, Continuation<? super Unit> r102) {
        if ((r102 instanceof FlowLargeImageLoadController$loadYunPanPhoto$1) == false) goto L7;
        FlowLargeImageLoadController$loadYunPanPhoto$1 r103 = (FlowLargeImageLoadController$loadYunPanPhoto$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L16;
        if (r107 == 1) goto L15;
        if (r107 != 2) goto L14;
        File r108 = (File) r103.L$1;
        ogb.a r109 = (ogb.a) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L33:
        r109.f523231b = r108;
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r101 = (j) r103.L$1;
        r100 = (ogb.a) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L24:
        File r110 = (File) r105;
        if (r110 != null) goto L27;
    L35:
        if (r101 == null) goto L38;
        r101.a("loadYunPanPhoto failed");
    L38:
        return Unit.INSTANCE;
    L27:
        if (r110.exists() == false) goto L35;
        VFSPath r111 = VFSFiles.f444819b.t(r110);
        FlowLargeImageView r112 = this.f422194b;
        g r113 = new g();
        r113.f519575a = r111;
        c r114 = new c(r101);
        r103.L$0 = r100;
        r103.L$1 = r110;
        r103.label = 2;
        if (r112.x(r113, r114, r103) != r106) goto L32;
        return r106;
    L32:
        r109 = r100;
        r108 = r110;
        goto L33
    L16:
        ResultKt.throwOnFailure(r105);
        FlowYunPanFileUtils r115 = FlowYunPanFileUtils.f422568a;
        Context r116 = this.f422193a;
        DocImageProperty r117 = r100.f523230a;
        if (r117 == null) goto L20;
        String r118 = r117.getToken();
        if (r118 == null) goto L20;
    L21:
        r103.L$0 = r100;
        r103.L$1 = r101;
        r103.label = 1;
        r105 = r115.e(r116, r118, false, r103);
        if (r105 != r106) goto L24;
        return r106;
    L20:
        r118 = "";
    L7:
        r103 = new FlowLargeImageLoadController$loadYunPanPhoto$1(this, r102);
        goto L8
    }

    public static final Object a(FlowLargeImageLoadController r110, PhotoItem r111, FlowLargeImageView.b r112, Continuation r113) {
        r110.getClass();
        if ((r113 instanceof FlowLargeImageLoadController$showPhotoCache$1) == false) goto L7;
        FlowLargeImageLoadController$showPhotoCache$1 r100 = (FlowLargeImageLoadController$showPhotoCache$1) r113;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        FlowLargeImageLoadController$showPhotoCache$1 r102 = r100;
        Object r103 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(r102.label) {
            case 0: goto L18;
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            default: goto L11;
        };
    L12:
        ResultKt.throwOnFailure(r103);
    L70:
        return Boxing.boxBoolean(true);
    L13:
        PhotoState r105 = (PhotoState) r102.L$2;
        FlowLargeImageView.b r106 = (FlowLargeImageView.b) r102.L$1;
        PhotoItem r107 = (PhotoItem) r102.L$0;
        ResultKt.throwOnFailure(r103);
        FlowLargeImageView.b r114 = r106;
    L57:
        File r108 = (File) r103;
        r105.setThumbnailFile(r108);
        if (r108 == null) goto L64;
        MainCoroutineDispatcher r115 = Dispatchers.getMain().getImmediate();
        FlowLargeImageLoadController$showPhotoCache$4 r116 = new FlowLargeImageLoadController$showPhotoCache$4(r110, r107, r108, r114, null);
        r102.L$0 = null;
        r102.L$1 = null;
        r102.L$2 = null;
        r102.label = 6;
        if (BuildersKt.withContext(r115, r116, r102) != r104) goto L70;
        return r104;
    L64:
        return Boxing.boxBoolean(false);
    L14:
        ResultKt.throwOnFailure(r103);
    L69:
        return Boxing.boxBoolean(true);
    L15:
        IRequestCreator r109 = (IRequestCreator) r102.L$3;
        PhotoState r117 = (PhotoState) r102.L$2;
        FlowLargeImageView.b r118 = (FlowLargeImageView.b) r102.L$1;
        PhotoItem r119 = (PhotoItem) r102.L$0;
        ResultKt.throwOnFailure(r103);
    L45:
        File r120 = (File) r103;
        r117.setMiddleFile(r120);
        if (r120 != null) goto L48;
    L53:
        CoroutineDispatcher r121 = Dispatchers.getIO();
        FlowLargeImageLoadController$showPhotoCache$thumbnailFile$1 r122 = new FlowLargeImageLoadController$showPhotoCache$thumbnailFile$1(r110, r109, r119, null);
        r102.L$0 = r119;
        r102.L$1 = r118;
        r102.L$2 = r117;
        r102.L$3 = null;
        r102.label = 5;
        r103 = BuildersKt.withContext(r121, r122, r102);
        if (r103 == r104) goto L75;
        r105 = r117;
        PhotoItem r123 = r119;
        r114 = r118;
        r107 = r123;
        goto L57
    L75:
        return r104;
    L48:
        if (r120.exists() == false) goto L53;
        MainCoroutineDispatcher r124 = Dispatchers.getMain().getImmediate();
        FlowLargeImageLoadController$showPhotoCache$3 r125 = new FlowLargeImageLoadController$showPhotoCache$3(r110, r119, r120, r118, null);
        r102.L$0 = null;
        r102.L$1 = null;
        r102.L$2 = null;
        r102.L$3 = null;
        r102.label = 4;
        if (BuildersKt.withContext(r124, r125, r102) != r104) goto L69;
        return r104;
    L16:
        ResultKt.throwOnFailure(r103);
    L67:
        return Boxing.boxBoolean(true);
    L17:
        r109 = (IRequestCreator) r102.L$3;
        r117 = (PhotoState) r102.L$2;
        FlowLargeImageView.b r126 = (FlowLargeImageView.b) r102.L$1;
        PhotoItem r127 = (PhotoItem) r102.L$0;
        ResultKt.throwOnFailure(r103);
        FlowLargeImageView.b r128 = r126;
    L30:
        File r129 = (File) r103;
        r117.setOriginFile(r129);
        if (r129 == null) goto L39;
        if (r129.exists() == false) goto L39;
        MainCoroutineDispatcher r130 = Dispatchers.getMain().getImmediate();
        FlowLargeImageLoadController$showPhotoCache$2 r131 = new FlowLargeImageLoadController$showPhotoCache$2(r110, r127, r129, r128, null);
        r102.L$0 = null;
        r102.L$1 = null;
        r102.L$2 = null;
        r102.L$3 = null;
        r102.label = 2;
        if (BuildersKt.withContext(r130, r131, r102) != r104) goto L67;
        return r104;
    L39:
        if (com.ss.android.lark.image.utils.a.f426446c == false) goto L41;
        Log.i("FlowLargeImageLoadController", "Cipher on, stop find cache");
        return Boxing.boxBoolean(false);
    L41:
        CoroutineDispatcher r132 = Dispatchers.getIO();
        FlowLargeImageLoadController$showPhotoCache$middleFile$1 r133 = new FlowLargeImageLoadController$showPhotoCache$middleFile$1(r110, r109, r127, null);
        r102.L$0 = r127;
        r102.L$1 = r128;
        r102.L$2 = r117;
        r102.L$3 = r109;
        r102.label = 3;
        r103 = BuildersKt.withContext(r132, r133, r102);
        if (r103 == r104) goto L73;
        r119 = r127;
        r118 = r128;
        goto L45
    L73:
        return r104;
    L18:
        ResultKt.throwOnFailure(r103);
        if (com.ss.android.lark.image.utils.a.b() == true) goto L65;
        r117 = r111.getPhotoState();
        Serializable r134 = r111.getLoadModel();
        Serializable r135 = r111.getOriginPicInfo().loadModel;
        if (com.ss.android.lark.image.utils.a.f426446c == true) goto L24;
    L26:
        IRequestCreator r136 = ImageLoader.with(r110.f422193a);
        CoroutineDispatcher r137 = Dispatchers.getIO();
        FlowLargeImageLoadController$showPhotoCache$originFile$1 r138 = new FlowLargeImageLoadController$showPhotoCache$originFile$1(r110, r136, r111, null);
        r102.L$0 = r111;
        r128 = r112;
        r102.L$1 = r128;
        r102.L$2 = r117;
        r102.L$3 = r136;
        r102.label = 1;
        Object r139 = BuildersKt.withContext(r137, r138, r102);
        if (r139 == r104) goto L71;
        r127 = r111;
        r109 = r136;
        r103 = r139;
        goto L30
    L71:
        return r104;
    L24:
        if (Intrinsics.areEqual(r134, r135) == true) goto L26;
        Log.i("FlowLargeImageLoadController", "Cipher on && loadModel not origin, stop find cache");
        return Boxing.boxBoolean(false);
    L65:
        return Boxing.boxBoolean(false);
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r100 = new FlowLargeImageLoadController$showPhotoCache$1(r110, r113);
        goto L8
    }

    public final Object b(boolean r110, PhotoItem r111, FlowLargeImageView.b r210, Continuation<? super Unit> r211) {
        PhotoItem r100 = r111;
        FlowLargeImageView.b r101 = r210;
        if ((r211 instanceof FlowLargeImageLoadController$autoDownloadOrigin$1) == false) goto L7;
        FlowLargeImageLoadController$autoDownloadOrigin$1 r102 = (FlowLargeImageLoadController$autoDownloadOrigin$1) r211;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L20;
        if (r106 == 1) goto L19;
        if (r106 == 2) goto L18;
        if (r106 == 3) goto L17;
        if (r106 != 4) goto L16;
        ResultKt.throwOnFailure(r104);
    L53:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r104);
    L48:
        return Unit.INSTANCE;
    L18:
        File r107 = (File) r102.L$2;
        r101 = (FlowLargeImageView.b) r102.L$1;
        PhotoItem r108 = (PhotoItem) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L40:
        PhotoItem r112 = r108;
        File r109 = r107;
        r100 = r112;
    L41:
        if (r109 == null) goto L44;
        r101 = null;
    L44:
        r102.L$0 = null;
        r102.L$1 = null;
        r102.L$2 = null;
        r102.label = 3;
        if (c(r100, r101, r102) != r105) goto L48;
        return r105;
    L19:
        PhotoState r113 = (PhotoState) r102.L$2;
        r101 = (FlowLargeImageView.b) r102.L$1;
        PhotoItem r114 = (PhotoItem) r102.L$0;
        ResultKt.throwOnFailure(r104);
        PhotoState r115 = r113;
        r100 = r114;
        Object r116 = r104;
    L34:
        r109 = (File) r116;
        Log.i("FlowLargeImageLoadController", d(r100) + "first download thumb file success");
        r115.setThumbnailFile(r109);
        if (r109 == null) goto L41;
        r102.L$0 = r100;
        r102.L$1 = r101;
        r102.L$2 = r109;
        r102.label = 2;
        if (g(r100, r109, r101, r102) != r105) goto L39;
        return r105;
    L39:
        r108 = r100;
        r107 = r109;
        goto L40
    L20:
        ResultKt.throwOnFailure(r104);
        r115 = r111.getPhotoState();
        if (r110 == true) goto L49;
        long r117 = r111.getOriginSize();
        ChatImageSettings.LargeImageRemoteFirstThumb r118 = ChatImageSettings.getLargeImageRemote().getFirstThumb();
        if (pac.a.a() == false) goto L25;
        float r119 = r118.getAutoOriginWeakMax();
    L26:
        float r120 = 1024;
        if (r117 <= ((long) ((r119 * r120) * r120))) goto L29;
        boolean r121 = true;
    L30:
        if (r121 == false) goto L49;
        CoroutineDispatcher r122 = Dispatchers.getIO();
        FlowLargeImageLoadController$autoDownloadOrigin$thumbFile$1 r123 = new FlowLargeImageLoadController$autoDownloadOrigin$thumbFile$1(this, r100, null);
        r102.L$0 = r100;
        r102.L$1 = r101;
        r102.L$2 = r115;
        r102.label = 1;
        r116 = BuildersKt.withContext(r122, r123, r102);
        if (r116 != r105) goto L34;
        return r105;
    L29:
        r121 = false;
        goto L30
    L25:
        r119 = r118.getAutoOriginMax();
    L49:
        r102.label = 4;
        if (c(r100, r101, r102) != r105) goto L53;
        return r105;
    L7:
        r102 = new FlowLargeImageLoadController$autoDownloadOrigin$1(this, r211);
        goto L8
    }

    public final Object g(PhotoItem r100, File r101, FlowLargeImageView.b r102, Continuation<? super Unit> r103) {
        PhotoState r104 = r100.getPhotoState();
        r104.getShowFile().setValue(r101);
        Drawable r105 = r104.getInlinePreviewDrawable();
        if (r105 != null) goto L5;
        r105 = r100.getThumbnail();
    L5:
        Log.i("FlowLargeImageLoadController", d(r100) + "showFile:" + r101.getPath());
        VFSPath r106 = VFSFiles.f444819b.t(r101);
        if (r100.getType() != 4) goto L8;
        boolean r107 = true;
    L9:
        FlowLargeImageView r108 = this.f422194b;
        g r109 = new g();
        r109.f519575a = r106;
        r109.f519576b = r105;
        r109.f519583i = r107;
        Object r110 = r108.x(r109, r102, r103);
        if (r110 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L13;
        return r110;
    L13:
        return Unit.INSTANCE;
    L8:
        r107 = false;
        goto L9
    }
}
