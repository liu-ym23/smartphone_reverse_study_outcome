package com.ss.android.lark.widget.photo.preview.image;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larksuite.framework.utils.NetworkUtils;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.DiskCacheStrategy;
import com.ss.android.lark.image.api.IRequestCreator;
import com.ss.android.lark.image.entity.EncryptImage;
import com.ss.android.lark.image.utils.ChatImageSettings;
import com.ss.android.lark.imagewidget.largeimage.LargeImageView;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.rxjava.RxScheduledExecutor;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.vfs.VFSPath;
import com.ss.android.lark.widget.photo.preview.utils.PhotoUtilsNew;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import com.ss.android.lark.widget.photopicker.entity.PhotoState;
import com.ss.android.lark.widget.photopicker.statistics.PerfPhotoViewMonitor;
import java.io.File;
import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: classes38.dex */
public final class n {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f446676f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f446677a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f446678b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public IRequestCreator f446679c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LargeImageView f446680d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LargeImageView.c f446681e;

    public static final class a {
    }

    public interface b {
        void a(PhotoItem r100);

        LargeImageFragment getLifecycleOwner();

        boolean isSecret();
    }

    public static final class c<T> implements RxScheduledExecutor.Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n f446682a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PhotoState f446683b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ PhotoItem f446684c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Serializable f446685d;

        public c(n r100, PhotoState r101, PhotoItem r102, Serializable r103) {
            this.f446682a = r100;
            this.f446683b = r101;
            this.f446684c = r102;
            this.f446685d = r103;
        }

        @Override // com.ss.android.lark.utils.rxjava.RxScheduledExecutor.Consumer
        public final void consume(Object r100) {
            File r101 = (File) r100;
            if (this.f446682a.f446678b == null) goto L23;
            this.f446683b.setOriginFile(r101);
            if (r101 == null) goto L8;
            StringBuilder r102 = new StringBuilder();
            n r103 = this.f446682a;
            PhotoItem r104 = this.f446684c;
            r103.getClass();
            r102.append(n.d(r104));
            r102.append("has downloaded origin success");
            Log.i("LargeImageLoadController", r102.toString());
            n r105 = this.f446682a;
            PhotoItem r106 = this.f446684c;
            PhotoState.UIState r107 = PhotoState.UIState.DONE;
            r105.getClass();
            n.i(r106, r107);
            this.f446682a.g(this.f446684c, r101, new PerfPhotoViewMonitor.b(PerfPhotoViewMonitor.LoadType.NET.getValue(), 0));
            return;
        L8:
            StringBuilder r108 = new StringBuilder();
            n r109 = this.f446682a;
            PhotoItem r110 = this.f446684c;
            r109.getClass();
            r108.append(n.d(r110));
            r108.append("has downloaded origin failed");
            Log.i("LargeImageLoadController", r108.toString());
            n r111 = this.f446682a;
            PhotoItem r112 = this.f446684c;
            PhotoState.UIState r113 = PhotoState.UIState.SHOW_LOOK;
            r111.getClass();
            n.i(r112, r113);
            Serializable r114 = this.f446685d;
            if ((r114 instanceof EncryptImage) == false) goto L11;
            EncryptImage r115 = (EncryptImage) r114;
        L12:
            if (r115 == null) goto L20;
            PhotoItem r116 = this.f446684c;
            n r117 = this.f446682a;
            ErrorResult r118 = r115.getErrorResult();
            if (r118 == null) goto L20;
            int r119 = com.ss.android.lark.widget.utils.e.f449080a;
            if (com.ss.android.lark.widget.utils.e.a(r118.getCode()) == false) goto L20;
            r116.resourceIsCleaned = true;
            b r120 = r117.f446678b;
            if (r120 == null) goto L20;
            r120.a(r116);
        L20:
            n r121 = this.f446682a;
            PhotoItem r122 = this.f446684c;
            RxScheduledExecutor.execInIO(new r(r121, r122), new s(r121, r122, this.f446685d));
            return;
        L11:
            r115 = null;
            goto L12
        }
    }

    static {
    }

    public static String d(PhotoItem r100) {
        return "photo item: " + r100.getLoadModel() + ", ";
    }

    public static void f(Runnable r100) {
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()) == false) goto L5;
        r100.run();
        return;
    L5:
        UICallbackExecutor.execute(r100);
    }

    public final void c(PhotoItem r100) {
        Log.i("LargeImageLoadController", d(r100) + "download origin file");
        PhotoState r101 = r100.getPhotoState();
        i(r100, PhotoState.UIState.LOADING);
        if (r100.getOriginPicInfo().loadModel == null) goto L5;
        Serializable r102 = r100.getOriginPicInfo().loadModel;
    L6:
        RxScheduledExecutor.execInIO(new p(this, r102, r100), new c(this, r101, r100, r102));
        return;
    L5:
        r102 = r100.getLoadModel();
        goto L6
    }

    public final boolean e(PhotoItem r110) {
        PhotoState r100 = r110.getPhotoState();
        Serializable r101 = r110.getOriginPicInfo().loadModel;
        Serializable r102 = r110.getMiddlePicInfo().loadModel;
        ChatImageSettings.LargeImageRemoteTarget r103 = ChatImageSettings.getLargeImageRemote().getTarget();
        long r104 = ((long) r103.getAutoOriginMax()) * 1024;
        boolean r105 = r100.isLoadOrigin();
        boolean r106 = Intrinsics.areEqual(PlayerResolution.SDKKEY.ORIGIN, r103.getDefaultTarget());
        boolean r107 = false;
        if (r100.getOriginFile() == null) goto L5;
        boolean r108 = true;
    L6:
        boolean r111 = !r110.isOriginSource();
        boolean r109 = Intrinsics.areEqual(r101, r102);
        if (NetworkUtils.d(this.f446677a) == true) goto L9;
    L11:
        boolean r112 = false;
    L12:
        boolean r113 = r100.isFromMe();
        if (r110.getOriginSize() > r104) goto L15;
        boolean r114 = true;
    L16:
        if (r105 == true) goto L24;
        if (r106 == true) goto L24;
        if (r108 == true) goto L24;
        if (r111 == true) goto L24;
        if (r109 == true) goto L24;
        if (r112 == false) goto L25;
        if (r113 == true) goto L24;
        if (r114 == true) goto L24;
    L25:
        Log.i("LargeImageLoadController", d(r110) + "needShowOrigin:" + r107 + " --> isLoadOrigin:" + r105 + ", remoteConfigOrigin:" + r106 + ", hasOriginCache:" + r108 + ", isSendCommonMode:" + r111 + ", origin and middle is same key:" + r109 + ", isNetGood:" + r112 + ", isFromMe:" + r113 + ", is small icon:" + r114);
        return r107;
    L24:
        r107 = true;
        goto L25
    L15:
        r114 = false;
        goto L16
    L9:
        if (pac.a.a() == true) goto L11;
        r112 = true;
        goto L12
    L5:
        r108 = false;
        goto L6
    }

    public n(Context r100, i r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "dependency");
        this.f446677a = r100;
        this.f446678b = r101;
        this.f446679c = r101.b();
        this.f446680d = r101.c();
    }

    public static final boolean b(n r110, PhotoItem r111) {
        if (r110.f446678b != null) goto L5;
        return false;
    L5:
        if (com.ss.android.lark.image.utils.a.b() == true) goto L78;
        PhotoState r100 = r111.getPhotoState();
        PerfPhotoViewMonitor.b r101 = new PerfPhotoViewMonitor.b(PerfPhotoViewMonitor.LoadType.DISK.getValue(), 0);
        Serializable r102 = r111.getLoadModel();
        Serializable r103 = r111.getOriginPicInfo().loadModel;
        Serializable r104 = r111.getMiddlePicInfo().loadModel;
        Serializable r105 = r111.getThumbnailPicInfo().loadModel;
        if (com.ss.android.lark.image.utils.a.f426446c == true) goto L10;
    L12:
        File r106 = r100.getOriginFile();
        if (r106 == null) goto L15;
    L24:
        boolean r107 = false;
    L25:
        BitmapDrawable r112 = null;
        if (r106 == null) goto L28;
    L32:
        r100.setOriginFile(r106);
        if (r106 == null) goto L38;
        if (r106.exists() == false) goto L38;
        Log.i("LargeImageLoadController", d(r111) + "has origin cache, isLocalFile: " + r107 + ", show it");
        f(new x(r110, r111, r100, r101));
    L60:
        return true;
    L38:
        if (com.ss.android.lark.image.utils.a.f426446c == false) goto L40;
        Log.i("LargeImageLoadController", "Cipher on, stop find cache");
        return false;
    L40:
        File r108 = r100.getMiddleFile();
        if (r108 == null) goto L43;
    L47:
        r100.setMiddleFile(r108);
        if (r108 == null) goto L50;
        Log.i("LargeImageLoadController", d(r111) + "has middle cache, show it");
        r110.e(r111);
        f(new y(r110, r111, r100, r101));
        goto L60
    L50:
        File r109 = r100.getThumbnailFile();
        if (r109 == null) goto L53;
    L57:
        r100.setThumbnailFile(r109);
        if (r109 == null) goto L61;
        Log.i("LargeImageLoadController", d(r111) + "has thumbnail cache, show it");
        f(new z(r110, r111, r100));
        goto L60
    L61:
        Drawable r113 = r100.getInlinePreviewDrawable();
        if (r113 != null) goto L69;
        ByteString r114 = r111.getInlinePreview();
        if (r114 == null) goto L68;
        byte[] r115 = r114.toByteArray();
        if (r115 == null) goto L68;
        Log.i("LargeImageLoadController", d(r111) + "getInlinePreviewDrawable, size:" + r115.length);
        r112 = new BitmapDrawable(LarkContext.getApplication().getResources(), BitmapFactory.decodeByteArray(r115, 0, r115.length));
    L68:
        r113 = r112;
    L69:
        r100.setInlinePreviewDrawable(r113);
        if (r113 == null) goto L77;
        Log.i("LargeImageLoadController", d(r111) + "has inline preview cache, show it");
        f(new a0(r110, r111, r100));
        return false;
    L77:
        return false;
    L53:
        if ((r105 instanceof EncryptImage) == false) goto L55;
        com.ss.android.lark.image.entity.g r116 = new com.ss.android.lark.image.entity.g(((EncryptImage) r105).getEncryptKey());
    L56:
        PhotoUtilsNew r117 = PhotoUtilsNew.f447142a;
        r109 = PhotoUtilsNew.f(r110.f446677a, r105, r110.f446679c, r116);
        goto L57
    L55:
        r116 = null;
        goto L56
    L43:
        if ((r104 instanceof EncryptImage) == false) goto L45;
        com.ss.android.lark.image.entity.e r118 = new com.ss.android.lark.image.entity.e(((EncryptImage) r104).getEncryptKey());
    L46:
        PhotoUtilsNew r119 = PhotoUtilsNew.f447142a;
        r108 = PhotoUtilsNew.f(r110.f446677a, r104, r110.f446679c, r118);
        goto L47
    L45:
        r118 = null;
        goto L46
    L28:
        if ((r103 instanceof EncryptImage) == false) goto L30;
        com.ss.android.lark.image.entity.f r120 = new com.ss.android.lark.image.entity.f(((EncryptImage) r103).getEncryptKey());
    L31:
        PhotoUtilsNew r121 = PhotoUtilsNew.f447142a;
        r106 = PhotoUtilsNew.f(r110.f446677a, r103, r110.f446679c, r120);
        goto L32
    L30:
        r120 = null;
        goto L31
    L15:
        if ((r102 instanceof String) == true) goto L17;
    L21:
        boolean r122 = false;
    L22:
        if (r122 == false) goto L24;
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.String");
        r106 = new PolarisFileWrapper((String) r102);
        r107 = true;
        goto L25
    L17:
        if (TextUtils.isEmpty((CharSequence) r102) == true) goto L21;
        if (new PolarisFileWrapper((String) r102).exists() == false) goto L21;
        r122 = true;
        goto L22
    L10:
        if (Intrinsics.areEqual(r102, r103) == true) goto L12;
        Log.i("LargeImageLoadController", "Cipher on && loadModel not origin, stop find cache");
        return false;
    L78:
        return false;
    }

    public static void i(PhotoItem r100, PhotoState.UIState r101) {
        Log.i("LargeImageLoadController", d(r100) + "switch ui state from " + r100.getPhotoState().getUIState().getValue() + " to " + r101);
        r100.getPhotoState().getUIState().setValue(r101);
    }

    public final void h(PhotoItem r100, Drawable r101) {
        Log.i("LargeImageLoadController", d(r100) + "drawable is not null, show inline preview");
        LargeImageView r102 = this.f446680d;
        if (r102 == null) goto L8;
        ImageView r103 = r102.getImageView();
        if (r103 == null) goto L9;
        Log.i("LargeImageLoadController", d(r100) + "width:" + r103.getWidth() + ",height:" + r103.getHeight());
        IRequestCreator r104 = ImageLoader.with(r103.getContext()).load(r101);
        DiskCacheStrategy r105 = DiskCacheStrategy.NONE;
        r104.diskCacheStrategy(r105).override(r103.getWidth(), r103.getHeight()).skipMemoryCache(true).diskCacheStrategy(r105).into(r103);
        return;
    L9:
        return;
    }

    public final void g(PhotoItem r100, File r101, PerfPhotoViewMonitor.b r102) {
        Intrinsics.checkNotNullParameter(r100, "photoItem");
        Intrinsics.checkNotNullParameter(r101, "file");
        Intrinsics.checkNotNullParameter(r102, "reportEvent");
        if (this.f446678b != null) goto L5;
        return;
    L5:
        PerfPhotoViewMonitor.f447616a.getClass();
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        PerfPhotoViewMonitor.f447618c = r102;
        PhotoState r103 = r100.getPhotoState();
        r103.getShowFile().setValue(r101);
        Drawable r104 = r103.getInlinePreviewDrawable();
        if (r104 != null) goto L8;
        r104 = r100.getThumbnail();
    L8:
        Log.i("LargeImageLoadController", d(r100) + "showFile:" + r101.getPath());
        VFSPath r105 = VFSFiles.f444819b.t(r101);
        b r106 = this.f446678b;
        boolean r107 = false;
        if (r106 == null) goto L11;
        boolean r108 = r106.isSecret();
    L13:
        if (r100.getType() != 4) goto L15;
        r107 = true;
    L15:
        LargeImageView r109 = this.f446680d;
        if (r109 == null) goto L19;
        nlb.g r110 = new nlb.g();
        r110.f519575a = r105;
        r110.f519576b = r104;
        r110.f519577c = r108;
        r110.f519583i = r107;
        r109.o(r110);
        return;
    L19:
        return;
    L11:
        r108 = false;
        goto L13
    }

    public static final void a(n r100, PhotoItem r101, int r102, ErrorResult r103) {
        r100.getClass();
        Drawable r104 = r101.getPhotoState().getInlinePreviewDrawable();
        boolean r105 = false;
        if (r104 == null) goto L5;
        r100.h(r101, r104);
    L9:
        if (r103 != null) goto L11;
    L13:
        boolean r106 = false;
    L14:
        if (r106 == false) goto L23;
        String r107 = r103.getDisplayMsg();
        if (r107 != null) goto L18;
    L19:
        r105 = true;
    L20:
        if (r105 == true) goto L24;
        UICallbackExecutor.execute(new b0(r100, r103));
        return;
    L24:
        return;
    L18:
        if (r107.length() != 0) goto L20;
    L23:
        return;
    L11:
        if (r103.getCode() != 5607) goto L13;
        r106 = true;
        goto L14
    L5:
        PerfPhotoViewMonitor r108 = PerfPhotoViewMonitor.f447616a;
        PerfPhotoViewMonitor.b r109 = new PerfPhotoViewMonitor.b(PerfPhotoViewMonitor.LoadType.NET.getValue(), 0);
        r108.getClass();
        Intrinsics.checkNotNullParameter(r109, "<set-?>");
        PerfPhotoViewMonitor.f447618c = r109;
        LargeImageView.c r110 = r100.f446681e;
        if (r110 == null) goto L9;
        r110.c(r102, r103);
        goto L9
    }
}
