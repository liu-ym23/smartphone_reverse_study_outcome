package com.ss.android.lark.flow.chat.mediapreview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.larkfeed.impl.gallery.h;
import com.ss.android.lark.biz.officesdk.im.mediapreview.GallerySource;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.message.MessageIdentity;
import com.ss.android.lark.flow.chat.message.image.model.FlowPhotoItem;
import com.ss.android.lark.flow.photoeditor.FlowPhotoEditorActivity;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.DiskCacheStrategy;
import com.ss.android.lark.image.api.IRequestCreator;
import com.ss.android.lark.imagewidget.largeimage.LargeImageView;
import com.ss.android.lark.imagewidget.subsampling.SubsamplingScaleImageView;
import com.ss.android.lark.imagewidget.subsampling.decoder.custom.MSkiaImageDecoder;
import com.ss.android.lark.imagewidget.subsampling.decoder.custom.MSkiaImageRegionDecoder;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ImageUtils;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.vfs.VFSPath;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.j;
import kza.e;
import kza.g;
import kza.i;
import kza.l;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u00ad\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001-\b\u0007\u0018\u0000 M2\u00020\u00012\u00020\u0002:\u0003MNOB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u001c\u001a\u00020\u001dH\u0016JF\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\"\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u0017H\u0016J>\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\"\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0012\u0010$\u001a\u00020\u001f2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u001a\u0010'\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+H\u0014J \u0010/\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u00100\u001a\u00020\u0014H\u0016J\u0018\u00101\u001a\u00020\u001f2\u0006\u00102\u001a\u0002032\u0006\u0010(\u001a\u00020)H\u0002J\u0012\u00104\u001a\u00020\u001f2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u0012\u00105\u001a\u00020\u001f2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u00106\u001a\u00020\u0014H\u0016J \u00107\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020)2\b\u0010%\u001a\u0004\u0018\u000108H\u0086@¢\u0006\u0002\u00109J\b\u0010:\u001a\u00020\u001fH\u0002J\u0016\u0010;\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020)H\u0082@¢\u0006\u0002\u0010<J\u0018\u0010=\u001a\u0004\u0018\u00010+2\u0006\u0010(\u001a\u00020)H\u0082@¢\u0006\u0002\u0010<J\b\u0010>\u001a\u00020\u001fH\u0002J\u0010\u0010?\u001a\u00020@2\u0006\u0010\u0003\u001a\u00020\u0004H\u0014J\n\u0010A\u001a\u0004\u0018\u00010BH\u0014J\u0010\u0010C\u001a\u00020\u001f2\u0006\u0010D\u001a\u00020EH\u0016J\u0010\u0010F\u001a\u00020\u001f2\u0006\u0010G\u001a\u00020HH\u0002J\u0010\u0010I\u001a\u0004\u0018\u00010JH\u0096@¢\u0006\u0002\u0010KJ\u000e\u0010L\u001a\u00020\u0014H\u0096@¢\u0006\u0002\u0010KR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0010\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0004\n\u0002\u0010.¨\u0006P"}, d2 = {"Lcom/ss/android/lark/flow/chat/mediapreview/FlowLargeImageView;", "Lcom/ss/android/lark/imagewidget/largeimage/LargeImageView;", "Lcom/ss/android/lark/biz/officesdk/im/mediapreview/IOpenFeishuPreviewViewDelegate;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defaultAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "largeImageLoadController", "Lcom/ss/android/lark/flow/chat/mediapreview/FlowLargeImageLoadController;", "imageItem", "Lcom/ss/android/lark/biz/officesdk/im/mediapreview/OpenFeishuGalleryImageItem;", "callback", "Lcom/ss/android/lark/biz/officesdk/im/mediapreview/IOpenFeishuMediaPreviewCallback;", "isEnterFullScreen", "", "isShowOtherView", "mSource", "Lcom/ss/android/lark/biz/officesdk/im/mediapreview/GallerySource;", "getMSource", "()Lcom/ss/android/lark/biz/officesdk/im/mediapreview/GallerySource;", "setMSource", "(Lcom/ss/android/lark/biz/officesdk/im/mediapreview/GallerySource;)V", "getView", "Landroid/view/View;", "setData", "", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "isFullScreenMode", "source", "loadDefault", "listener", "Lcom/ss/android/lark/biz/officesdk/im/mediapreview/IOpenFeishuPreviewViewListener;", "loadLargeImage", "info", "Lcom/ss/android/lark/imagewidget/largeimage/LocalLoadInfo;", "resource", "Landroid/graphics/Bitmap;", "flowLargeImageAbility", "com/ss/android/lark/flow/chat/mediapreview/FlowLargeImageView$flowLargeImageAbility$1", "Lcom/ss/android/lark/flow/chat/mediapreview/FlowLargeImageView$flowLargeImageAbility$1;", "refreshView", "forceToDefault", "setScaleForLargeImage", "view", "Lcom/ss/android/lark/flow/chat/mediapreview/FlowSubsamplingScaleImageView;", "loadOrigin", "loadThumbnail", "isNeedShowOrigin", "loadInner", "Lcom/ss/android/lark/flow/chat/mediapreview/FlowLargeImageView$IFlowPreviewViewListener;", "(Lcom/ss/android/lark/imagewidget/largeimage/LocalLoadInfo;Lcom/ss/android/lark/flow/chat/mediapreview/FlowLargeImageView$IFlowPreviewViewListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setUpListener", "loadLargeImageFlow", "(Lcom/ss/android/lark/imagewidget/largeimage/LocalLoadInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadLargeImageInner", BasicTestActionHandler.TEST_ACTION_RESET, "createScaleImageView", "Lcom/ss/android/lark/imagewidget/subsampling/SubsamplingScaleImageView;", "getSizeChangedStrategy", "Lcom/ss/android/lark/imagewidget/subsampling/SubsamplingScaleImageView$OnSizeChangedStrategy;", "startPhotoEdit", "activity", "Landroidx/fragment/app/FragmentActivity;", "reportEditImageAudit", "photoItem", "Lcom/ss/android/lark/widget/photopicker/entity/PhotoItem;", "getShowFile", "Ljava/io/File;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isAnimatedImage", "Companion", "IFlowPreviewViewListener", "IFlowLargeImageAbility", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowLargeImageView extends LargeImageView implements i {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f422198o = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public CoroutineScope f422199g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public FlowLargeImageLoadController f422200h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public l f422201i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public g f422202j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f422203k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f422204l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public GallerySource f422205m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final c f422206n;

    public static final class a {
    }

    public interface b {
        void onLoadFailed();

        void onLoadSuccess();
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FlowLargeImageView f422207a;

        public c(FlowLargeImageView r100) {
            this.f422207a = r100;
        }

        public final void a(boolean r100) {
            g r101 = this.f422207a.f422202j;
            if (r101 == null) goto L5;
            r101.a(r100);
        L5:
            this.f422207a.f422204l = r100;
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FlowLargeImageView f422208a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f422209b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ FlowSubsamplingScaleImageView f422210c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Ref.FloatRef f422211d;

        public d(FlowLargeImageView r100, Object r101, FlowSubsamplingScaleImageView r102, Ref.FloatRef r103) {
            this.f422208a = r100;
            this.f422209b = r101;
            this.f422210c = r102;
            this.f422211d = r103;
        }

        public final void a() {
            l r100 = this.f422208a.f422201i;
            Integer r101 = null;
            if (r100 == null) goto L5;
            Object r102 = r100.f506773e;
        L7:
            if (Intrinsics.areEqual(r102, this.f422209b) == true) goto L19;
            StringBuilder r103 = new StringBuilder("setScaleForLargeImage, item is not same, return, before: ");
            Object r104 = this.f422209b;
            if (r104 == null) goto L11;
            Integer r105 = Integer.valueOf(r104.hashCode());
        L12:
            r103.append(r105);
            r103.append(", now: ");
            l r106 = this.f422208a.f422201i;
            if (r106 == null) goto L17;
            Object r107 = r106.f506773e;
            if (r107 == null) goto L17;
            r101 = Integer.valueOf(r107.hashCode());
        L17:
            r103.append(r101);
            Log.i("FlowPreviewImageView", r103.toString());
            return;
        L11:
            r105 = null;
            goto L12
        L19:
            int[] r108 = new int[2];
            this.f422208a.getLocationOnScreen(r108);
            int r109 = UIHelper.getWindowWidth(this.f422208a.getContext());
            int r110 = UIUtils.getScreenHeight(this.f422208a.getContext());
            float r111 = this.f422210c.getWidth() / 2.0f;
            float r112 = this.f422210c.getHeight() / 2.0f;
            float r113 = r110;
            if ((this.f422210c.H() * this.f422211d.element) >= r113) goto L22;
            float r114 = this.f422210c.I() / 2.0f;
            float r115 = this.f422210c.H() / 2.0f;
            float r116 = (r111 - (r109 / 2.0f)) + r108[0];
            float r117 = this.f422211d.element;
            PointF r118 = new PointF(r114 + (r116 / r117), r115 + (((r112 - (r113 / 2.0f)) + r108[1]) / r117));
        L23:
            this.f422210c.M(this.f422211d.element, r118);
            FlowLargeImageView r119 = this.f422208a;
            if (r119.f422203k == false) goto L32;
            g r120 = r119.f422202j;
            if (r120 == null) goto L28;
            r120.b(true);
        L28:
            g r121 = this.f422208a.f422202j;
            if (r121 == null) goto L31;
            r121.a(false);
        L31:
            this.f422208a.f422204l = false;
        L32:
            FlowLargeImageView r122 = this.f422208a;
            if (r122.f422204l == true) goto L38;
            g r123 = r122.f422202j;
            if (r123 == null) goto L39;
            r123.a(false);
            return;
        L39:
            return;
        L38:
            return;
        L22:
            float r124 = r111 + r108[0];
            float r125 = this.f422211d.element;
            r118 = new PointF(r124 / r125, (r112 + r108[1]) / r125);
            goto L23
        L5:
            r102 = null;
            goto L7
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public FlowLargeImageView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public FlowLargeImageView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // kza.i
    public View getView() {
        return this;
    }

    @Override // kza.i
    public final boolean b() {
        l r100 = this.f422201i;
        if (r100 == null) goto L5;
        Object r101 = r100.f506773e;
    L7:
        if (r101 != null) goto L9;
        return false;
    L9:
        if ((r101 instanceof FlowPhotoItem) == false) goto L12;
        return false;
    L12:
        if ((r101 instanceof PhotoItem) == true) goto L14;
        return false;
    L14:
        if (this.f422200h != null) goto L16;
        return false;
    L16:
        if (((PhotoItem) r101).getPhotoState().getOriginFile() != null) goto L18;
        Log.i("FlowLargeImageLoadController", "originFile is null, need show originFile");
        boolean r102 = true;
    L19:
        if (r102 != true) goto L25;
        return true;
    L25:
        return false;
    L18:
        r102 = false;
        goto L19
    L5:
        r101 = null;
        goto L7
    }

    @Override // kza.i
    public final Object c() {
        l r100 = this.f422201i;
        if (r100 == null) goto L5;
        Object r101 = r100.f506773e;
    L7:
        if (r100 == null) goto L23;
        if (r101 == null) goto L23;
        if ((r101 instanceof PhotoItem) == false) goto L17;
        File r102 = ((PhotoItem) r101).getPhotoState().getShowFile().getValue();
        if (r102 == null) goto L15;
        return r102;
    L15:
        Log.e("FlowPreviewImageView", "getShowFile PhotoItem, curShowFile is null");
    L22:
        return null;
    L17:
        if ((r101 instanceof ogb.a) == false) goto L22;
        File r103 = ((ogb.a) r101).f523231b;
        if (r103 != null) goto L21;
        Log.e("FlowPreviewImageView", "getShowFile FlowYunPanImagePhotoItem, file is null");
    L21:
        return r103;
    L23:
        Log.e("FlowPreviewImageView", "getShowFile, photoItem is null");
        return null;
    L5:
        r101 = null;
        goto L7
    }

    @Override // com.ss.android.lark.imagewidget.largeimage.LargeImageView
    public SubsamplingScaleImageView.j getSizeChangedStrategy() {
        SubsamplingScaleImageView r100 = this.f426675b;
        if ((r100 instanceof FlowSubsamplingScaleImageView) == false) goto L5;
        FlowSubsamplingScaleImageView r101 = (FlowSubsamplingScaleImageView) r100;
    L6:
        if (r101 != null) goto L10;
        return super.getSizeChangedStrategy();
    L10:
        return r101.M2;
    L5:
        r101 = null;
        goto L6
    }

    public final GallerySource getMSource() {
        return this.f422205m;
    }

    @Override // kza.i
    public final void d(FragmentActivity r110) {
        Intrinsics.checkNotNullParameter(r110, "activity");
        l r100 = this.f422201i;
        String r101 = null;
        if (r100 == null) goto L5;
        Object r102 = r100.f506773e;
    L7:
        if (r100 == null) goto L40;
        if (r102 == null) goto L40;
        e r103 = r100.f506774f;
        boolean r104 = true;
        if (r103 == null) goto L13;
        r103.c();
        boolean r105 = true;
    L14:
        if (r105 == true) goto L18;
        Log.e("FlowPreviewImageView", "startPhotoEdit, not support edit");
        return;
    L18:
        if ((r102 instanceof PhotoItem) == false) goto L34;
        PhotoItem r106 = (PhotoItem) r102;
        File r107 = r106.getPhotoState().getShowFile().getValue();
        if (r107 != null) goto L23;
        Log.e("FlowPreviewImageView", "startPhotoEdit, curShowFile is null");
        return;
    L23:
        String r108 = com.ss.android.photoeditor.util.b.b(r110);
        int r109 = FlowPhotoEditorActivity.f423925b;
        String r111 = r107.getAbsolutePath();
        Intrinsics.checkNotNull(r108);
        FlowPhotoEditorActivity.a.b(r110, r111, r108, com.ss.android.lark.widget.photopicker.utils.l.a(r106));
        MessageIdentity r112 = r106.getMessageIdentity();
        if (r112 == null) goto L26;
        r101 = r112.getChatId();
    L26:
        String r113 = com.ss.android.lark.widget.photopicker.utils.l.a(r106);
        if (r113.length() == 0) goto L30;
        r104 = false;
    L30:
        if (r104 == false) goto L32;
        Log.e("FlowPreviewImageView", "reportEditImageAudit, imageKey is empty");
        return;
    L32:
        ChatCoreModule.a().getAuditDependency().f(r101, r113);
        return;
    L34:
        if ((r102 instanceof ogb.a) == false) goto L38;
        CoroutineScope r114 = this.f422199g;
        if (r114 == null) goto L44;
        BuildersKt.launch$default(r114, Dispatchers.getMain(), null, new FlowLargeImageView$startPhotoEdit$1(r110, r102, null), 2, null);
        return;
    L44:
        return;
    L38:
        Log.e("FlowPreviewImageView", "startPhotoEdit, item is error");
        return;
    L13:
        r105 = false;
    L40:
        Log.e("FlowPreviewImageView", "startPhotoEdit, imageItem is null");
        return;
    L5:
        r102 = null;
        goto L7
    }

    @Override // kza.i
    public final Object g(Continuation<? super Boolean> r100) {
        if ((r100 instanceof FlowLargeImageView$isAnimatedImage$1) == false) goto L7;
        FlowLargeImageView$isAnimatedImage$1 r101 = (FlowLargeImageView$isAnimatedImage$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        boolean r106 = false;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        ResultKt.throwOnFailure(r103);
    L38:
        nlb.g r107 = (nlb.g) r103;
        if (r107 == null) goto L44;
        if (r107.f519582h != true) goto L44;
        r106 = true;
    L44:
        return Boxing.boxBoolean(r106);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        l r108 = this.f422201i;
        if (r108 == null) goto L17;
        Object r109 = r108.f506773e;
    L18:
        if (r108 == null) goto L45;
        if (r109 == null) goto L45;
        if ((r109 instanceof PhotoItem) == false) goto L29;
        nlb.g r110 = this.f426677d;
        if (r110 != null) goto L26;
        File r111 = ((PhotoItem) r109).getPhotoState().getShowFile().getValue();
    L32:
        if (r111 == null) goto L34;
        VFSPath r112 = VFSFiles.f444819b.t(r111);
        nlb.g r113 = new nlb.g();
        r113.f519575a = r112;
        CoroutineDispatcher r114 = Dispatchers.getIO();
        FlowLargeImageView$isAnimatedImage$data$1 r115 = new FlowLargeImageView$isAnimatedImage$data$1(this, r113, null);
        r101.label = 1;
        r103 = BuildersKt.withContext(r114, r115, r101);
        if (r103 != r104) goto L38;
        return r104;
    L34:
        return Boxing.boxBoolean(false);
    L26:
        return Boxing.boxBoolean(r110.f519582h);
    L29:
        if ((r109 instanceof ogb.a) == false) goto L31;
        r111 = ((ogb.a) r109).f523231b;
        goto L32
    L31:
        r111 = null;
    L45:
        Log.e("FlowPreviewImageView", "isLoadFinished, photoItem is null");
        return Boxing.boxBoolean(false);
    L17:
        r109 = null;
    L7:
        r101 = new FlowLargeImageView$isAnimatedImage$1(this, r100);
        goto L8
    }

    @Override // kza.i
    public final void i(final com.larus.larkfeed.impl.gallery.g r100) {
        l r101 = this.f422201i;
        if (r101 == null) goto L5;
        final Object r102 = r101.f506773e;
    L6:
        if (r102 != null) goto L8;
        return;
    L8:
        post(new FlowLargeImageView$loadDefault$1(this, r102, r100));
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // kza.i
    public final void j(h r100) {
        l r101 = this.f422201i;
        if (r101 == null) goto L12;
        Object r102 = r101.f506773e;
        if (r102 != null) goto L7;
        return;
    L7:
        if ((r102 instanceof PhotoItem) == false) goto L14;
        CoroutineScope r103 = this.f422199g;
        if (r103 == null) goto L15;
        BuildersKt.launch$default(r103, null, null, new FlowLargeImageView$loadOrigin$1$1(this, r102, r100, null), 3, null);
        return;
    L15:
        return;
    L14:
        return;
    }

    @Override // com.ss.android.lark.imagewidget.largeimage.LargeImageView
    public final SubsamplingScaleImageView l(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new FlowSubsamplingScaleImageView(getContext());
    }

    public final void setMSource(GallerySource r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f422205m = r100;
    }

    @Override // kza.i
    public final void a(boolean r100, boolean r101) {
        SubsamplingScaleImageView r102 = this.f426675b;
        if (r102 == null) goto L46;
        boolean r103 = false;
        if (r102.getVisibility() != 0) goto L7;
        boolean r104 = true;
    L8:
        if (r104 == false) goto L50;
        ImageView r105 = this.f426674a;
        if (r105 != null) goto L13;
    L15:
        boolean r106 = false;
    L16:
        if (r106 == true) goto L18;
        SubsamplingScaleImageView r107 = this.f426675b;
        if (r107 != null) goto L26;
    L28:
        if (r103 == false) goto L48;
        SubsamplingScaleImageView r108 = this.f426675b;
        if ((r108 instanceof FlowSubsamplingScaleImageView) == false) goto L32;
        FlowSubsamplingScaleImageView r109 = (FlowSubsamplingScaleImageView) r108;
    L33:
        if (r109 != null) goto L36;
        return;
    L36:
        if (this.f422203k == r100) goto L38;
    L41:
        nlb.g r110 = r109.K2;
        if (r110 == null) goto L44;
        Log.i("FlowPreviewImageView", "refreshView, setScaleForLargeImage");
        this.f422204l = r101;
        this.f422203k = r100;
        z(r109, r110);
        return;
    L44:
        Log.e("FlowPreviewImageView", "refreshView, info is null");
        return;
    L38:
        if (this.f422204l != r101) goto L41;
        Log.i("FlowPreviewImageView", "refreshView, isEnterFullScreen and isShowOtherView same");
        return;
    L32:
        r109 = null;
        goto L33
    L48:
        return;
    L26:
        if (r107.getVisibility() != 0) goto L28;
        r103 = true;
        goto L28
    L18:
        if (this.f422203k == r100) goto L20;
    L22:
        this.f422203k = r100;
        this.f422204l = r101;
        return;
    L20:
        if (this.f422204l != r101) goto L22;
        return;
    L13:
        if (r105.getVisibility() != 0) goto L15;
        r106 = true;
        goto L16
    L50:
        return;
    L7:
        r104 = false;
        goto L8
    }

    @Override // com.ss.android.lark.imagewidget.largeimage.LargeImageView
    public final void q(nlb.g r100, Bitmap r101) {
        Intrinsics.checkNotNullParameter(r100, "info");
        Log.i("FlowPreviewImageView", "start load large image");
        SubsamplingScaleImageView r102 = this.f426675b;
        if ((r102 instanceof FlowSubsamplingScaleImageView) == false) goto L5;
        FlowSubsamplingScaleImageView r103 = (FlowSubsamplingScaleImageView) r102;
    L6:
        if (r103 != null) goto L8;
        return;
    L8:
        r103.K2 = r100;
        r103.L2 = this.f422206n;
        boolean r104 = r100.f519577c;
        r103.setBitmapDecoderFactory(new nlb.a(MSkiaImageDecoder.class, r100, r104));
        r103.setRegionDecoderFactory(new nlb.b(MSkiaImageRegionDecoder.class, r100, r104));
        nlb.c.i(r103, r100, r101);
        z(r103, r100);
        t(r100);
        return;
    L5:
        r103 = null;
        goto L6
    }

    public final Object y(nlb.g r110, Continuation<? super Unit> r111) {
        if ((r111 instanceof FlowLargeImageView$loadLargeImageFlow$1) == false) goto L7;
        FlowLargeImageView$loadLargeImageFlow$1 r100 = (FlowLargeImageView$loadLargeImageFlow$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        r110 = (nlb.g) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L29:
        Bitmap r113 = (Bitmap) r112;
        if (n(r110) == true) goto L33;
        q(r110, r113);
    L33:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r112);
        r100.L$0 = r110;
        r100.label = 1;
        j r114 = new j(IntrinsicsKt.intercepted(r100), 1);
        r114.C();
        long r104 = System.currentTimeMillis();
        this.f426674a.setVisibility(8);
        this.f426675b.setVisibility(0);
        setScaleImageViewInfo(r110);
        int[] r105 = nlb.c.e(this.f426675b, r110);
        Log.i("FlowPreviewImageView", "loadLargeImage, previewWidth:" + r105[0] + ", previewHeight:" + r105[1]);
        IRequestCreator r106 = ImageLoader.with(getContext()).load(r110.f519575a.toFile());
        if (ImageUtils.f(r110.f519581g) == true) goto L17;
    L19:
        DiskCacheStrategy r107 = DiskCacheStrategy.NONE;
    L20:
        IRequestCreator r108 = r106.diskCacheStrategy(r107).skipMemoryCache(true).placeholder(r110.f519576b).error(null).asBitmap().override(r105[0], r105[1]);
        Iterator r109 = ((ArrayList) m(r110)).iterator();
    L22:
        if (r109.hasNext() == false) goto L24;
        r108.transform((BitmapTransformation) r109.next());
        goto L22
    L24:
        r108.into(new com.ss.android.lark.flow.chat.mediapreview.a(r104, r114));
        r112 = r114.B();
        if (r112 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L27;
        DebugProbesKt.probeCoroutineSuspended(r100);
    L27:
        if (r112 != r102) goto L29;
        return r102;
    L17:
        if (r110.f519583i == true) goto L19;
        r107 = DiskCacheStrategy.RESULT;
    L7:
        r100 = new FlowLargeImageView$loadLargeImageFlow$1(this, r111);
        goto L8
    }

    public final void z(FlowSubsamplingScaleImageView r110, nlb.g r111) {
        int r100 = r111.f519579e;
        int r112 = r111.f519580f;
        int r101 = nlb.c.g(r110);
        int r102 = nlb.c.f(r110);
        float r103 = nlb.c.b(r101, r102, r100, r112);
        float r104 = nlb.c.c(r101, r102, r100, r112);
        float r105 = r101;
        float r106 = r100;
        float r107 = (r105 * 1.0f) / r106;
        float r113 = r112;
        float r108 = (r102 * 1.0f) / r113;
        float r114 = Math.min(r107, r108);
        r110.setDoubleTapZoomScale(r103);
        r110.setMaxScale(r104);
        r110.setMinimumScaleType(3);
        r110.setMinScale(r114);
        Ref.FloatRef r115 = new Ref.FloatRef();
        r115.element = r114;
        if (((r113 * 1.0f) / r106) <= 1.8777778f) goto L5;
        boolean r109 = true;
    L6:
        r110.I2 = r109;
        if (r109 == false) goto L9;
    L10:
        r115.element = Math.max(r107, r108);
    L11:
        r110.setDefaultScale(r115.element);
        if (this.f422203k == false) goto L14;
    L17:
        l r116 = this.f422201i;
        if (r116 == null) goto L20;
        Object r117 = r116.f506773e;
    L21:
        r110.post(new d(this, r117, r110, r115));
    L22:
        Log.i("FlowPreviewImageView", "setScaleForLargeImage, bitmapWidth: " + r100 + ", bitmapHeight: " + r112 + ", viewWidth: " + r101 + ", viewHeight: " + r102 + ", doubleTabScale: " + r103 + ", maxScale: " + r104 + ", minScale: " + r114 + ", defaultScale: " + r115.element + ", isLong: " + r109);
        return;
    L20:
        r117 = null;
        goto L21
    L14:
        if (this.f422204l == false) goto L17;
        r110.M(r114, new PointF(0.0f, 0.0f));
        goto L22
    L9:
        if ((r106 * r114) >= r105) goto L11;
    L5:
        r109 = false;
        goto L6
    }

    public FlowLargeImageView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f422204l = true;
        this.f422205m = GallerySource.DEFAULT;
        this.f422206n = new c(this);
    }

    public final Object x(nlb.g r100, b r101, Continuation<? super Unit> r102) {
        if ((r102 instanceof FlowLargeImageView$loadInner$1) == false) goto L7;
        FlowLargeImageView$loadInner$1 r103 = (FlowLargeImageView$loadInner$1) r102;
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
        b r108 = (b) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L46:
        if (r108 == null) goto L51;
        r108.onLoadSuccess();
    L51:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r101 = (b) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L28:
        nlb.g r109 = (nlb.g) r105;
        int r110 = r109.f519579e;
        if (r110 <= 0) goto L48;
        int r111 = r109.f519580f;
        if (r111 <= 0) goto L48;
        if (r109.f519582h == true) goto L36;
    L42:
        Intrinsics.checkNotNull(r109);
        r103.L$0 = r101;
        r103.label = 2;
        if (y(r109, r103) != r106) goto L45;
        return r106;
    L45:
        r108 = r101;
        goto L46
    L36:
        if (nlb.c.h(this, r110, r111) == true) goto L42;
        p(r109);
        ImageView r112 = this.f426674a;
        if (r112 == null) goto L40;
        r112.setOnClickListener(new com.ss.android.lark.flow.chat.mediapreview.b(this));
    L40:
        if (r101 == null) goto L51;
        r101.onLoadSuccess();
    L48:
        if (r101 == null) goto L51;
        r101.onLoadFailed();
        goto L51
    L16:
        ResultKt.throwOnFailure(r105);
        String r113 = null;
        if (r100.f519575a.toFile().canRead() == true) goto L25;
        if (r101 == null) goto L20;
        r101.onLoadFailed();
    L20:
        StringBuilder r114 = new StringBuilder("file can not read, info: + ");
        VFSPath r115 = r100.f519575a;
        if (r115 == null) goto L23;
        r113 = r115.getRealPath();
    L23:
        r114.append(r113);
        Log.i("FlowPreviewImageView", r114.toString());
        return Unit.INSTANCE;
    L25:
        this.f426677d = r100;
        CoroutineDispatcher r116 = Dispatchers.getIO();
        FlowLargeImageView$loadInner$data$1 r117 = new FlowLargeImageView$loadInner$data$1(this, r100, null);
        r103.L$0 = r101;
        r103.label = 1;
        r105 = BuildersKt.withContext(r116, r117, r103);
        if (r105 != r106) goto L28;
        return r106;
    L7:
        r103 = new FlowLargeImageView$loadInner$1(this, r102);
        goto L8
    }

    public /* synthetic */ FlowLargeImageView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // kza.i
    public final void f(Context r100, l r101, com.larus.larkfeed.impl.gallery.e r102, boolean r103, boolean r110, GallerySource r111) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "source");
        if (r101 != null) goto L6;
        Log.i("FlowPreviewImageView", "imageItem is null");
        return;
    L6:
        Log.i("FlowPreviewImageView", BasicTestActionHandler.TEST_ACTION_RESET);
        CoroutineScope r104 = this.f422199g;
        if (r104 == null) goto L9;
        CoroutineScopeKt.cancel$default(r104, null, 1, null);
    L9:
        SubsamplingScaleImageView r105 = this.f426675b;
        if ((r105 instanceof FlowSubsamplingScaleImageView) == false) goto L12;
        FlowSubsamplingScaleImageView r106 = (FlowSubsamplingScaleImageView) r105;
    L14:
        if (r106 == null) goto L17;
        r106.K2 = null;
        r106.L2 = null;
        r106.I2 = false;
    L17:
        if (r105 == null) goto L19;
        setLoadPreviewListener(null);
        r105.setVisibility(8);
        r105.G(true);
        r105.G1 = null;
        r105.H1 = null;
        r105.L1 = null;
        r105.M1 = null;
    L19:
        ImageView r107 = this.f426674a;
        if (r107 == null) goto L22;
        r107.setVisibility(8);
    L22:
        this.f422203k = false;
        this.f422204l = true;
        this.f422199g = null;
        this.f422205m = GallerySource.DEFAULT;
        l r108 = this.f422201i;
        if (r108 == null) goto L25;
        Object r109 = r108.f506773e;
    L27:
        if ((r109 instanceof ogb.a) == false) goto L29;
        ((ogb.a) r109).f523231b = null;
    L29:
        this.f422201i = null;
        this.f422202j = null;
        this.f426677d = null;
        this.f422205m = r111;
        this.f422199g = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        this.f422200h = new FlowLargeImageLoadController(r100, this, r111);
        this.f422201i = r101;
        this.f422204l = r110;
        this.f422203k = r103;
        this.f422202j = r102;
        return;
    L25:
        r109 = null;
        goto L27
    L12:
        r106 = null;
        goto L14
    }
}
