package com.bytedance.ee.bear.bitable.common.imagecrop;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.larksuite.framework.utils.DeviceUtils;
import com.larus.nova.R;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.StatusBarUtil;
import io.reactivex.disposables.CompositeDisposable;
import java.io.InputStream;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import pfc.j;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 =2\u00020\u0001:\u0002=>B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ$\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u001a\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00102\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010#\u001a\u00020!H\u0016J\u0012\u0010$\u001a\u00020!2\b\u0010%\u001a\u0004\u0018\u00010&H\u0002J\u000e\u0010'\u001a\u00020!2\u0006\u0010(\u001a\u00020\fJ\u000e\u0010)\u001a\u00020!2\u0006\u0010*\u001a\u00020\u0012J\u0006\u0010+\u001a\u00020!J\u0012\u0010,\u001a\u00020!2\b\u0010*\u001a\u0004\u0018\u00010\u0012H\u0002J\u0014\u0010-\u001a\u0004\u0018\u00010.2\b\u0010*\u001a\u0004\u0018\u00010\u0012H\u0002J(\u0010/\u001a\u00020\u00032\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002012\u0006\u00103\u001a\u00020\u00052\u0006\u00104\u001a\u000205H\u0002J\u0018\u00106\u001a\u0002012\u0006\u00107\u001a\u0002012\u0006\u00108\u001a\u00020\u0005H\u0002J\u0018\u00109\u001a\u00020!2\u0006\u0010:\u001a\u00020&2\u0006\u0010*\u001a\u00020;H\u0002J\b\u0010<\u001a\u00020!H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016¨\u0006?"}, d2 = {"Lcom/bytedance/ee/bear/bitable/common/imagecrop/ImageCropFragment;", "Landroidx/fragment/app/Fragment;", "needProportionalCrop", "", "maxSize", "", "clipRatio", "<init>", "(ZFF)V", "mPhotoEditor", "Lcom/ss/android/photoeditor/base/IPhotoEditor;", "mCropCallback", "Lcom/bytedance/ee/bear/bitable/common/imagecrop/ImageCropFragment$ICropImageCallback;", "mEditorContainer", "Landroid/widget/FrameLayout;", "mLoadingView", "Landroid/view/View;", "mOriginPath", "", "mCompositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "getMCompositeDisposable", "()Lio/reactivex/disposables/CompositeDisposable;", "mCompositeDisposable$delegate", "Lkotlin/Lazy;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onDestroyView", "handleResultBmp", "resultBmp", "Landroid/graphics/Bitmap;", "setCropCallback", "cropCallback", "setImagePath", "path", "refreshImage", "loadBitmap", "getPreviewBounds", "", "checkBoundsIsValid", "bitmapBounds", "", "viewBounds", "threshold", "deviation", "", "roundShortSize", "bounds", PickerReporterConstants.KEY.TARGET, "saveToFile", SimplayerImageStrategy.RESULT_BITMAP, "Lcom/ss/android/lark/vfs/VFSPath;", LiveCommonConstants.REASON_ON_DEDTROY, "Companion", "ICropImageCallback", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImageCropFragment extends Fragment {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f209835m = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f209836d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f209837e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f209838f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public j f209839g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public b f209840h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public FrameLayout f209841i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f209842j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f209843k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f209844l;

    public static final class a {
    }

    public interface b {
        void a();

        void b();

        void c(String r100);

        void d(String r100);
    }

    static {
    }

    public ImageCropFragment() {
        this(false, 0.0f, 7);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        ((CompositeDisposable) this.f209844l.getValue()).dispose();
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        j r100 = this.f209839g;
        if (r100 == null) goto L6;
        ((ofc.b) r100).a();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r210, Bundle r211) {
        Intrinsics.checkNotNullParameter(r210, "view");
        super.onViewCreated(r210, r211);
        StatusBarUtil.hideStatusBar(getActivity());
        this.f209841i = (FrameLayout) r210.findViewById(R.id.fl_container);
        this.f209842j = r210.findViewById(R.id.loading);
        String r100 = this.f209843k;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L12;
        return;
    L12:
        if (r100 == null) goto L16;
        FrameLayout r102 = this.f209841i;
        if (r102 == null) goto L16;
        float r103 = DeviceUtils.getScreenWidth(r102.getContext());
        if (r102.getWidth() <= 0) goto L21;
        r103 = r102.getWidth();
    L21:
        float r104 = DeviceUtils.getScreenHeight(r102.getContext());
        if (r102.getHeight() <= 0) goto L25;
        r104 = r102.getHeight();
    L25:
        BitmapFactory.Options r105 = new BitmapFactory.Options();
        r105.inJustDecodeBounds = true;
        InputStream r110 = com.ss.android.lark.core.storage.a.c().i(r100).newInputStream();     // Catch: Throwable -> L85
        BitmapFactory.decodeStream(r110, null, r105);     // Catch: Throwable -> L85
        r110.close();     // Catch: Throwable -> L85
    L27:
        float r111 = r105.outWidth;
        float r106 = r105.outHeight;
        Log.i("ImageCropFragment", "bitmapWidth:" + r111 + ", bitmapHeight:" + r106);
        int r112 = 2;
        float[] r113 = {r111, r106};
        float[] r114 = {r103, r104};
        float r107 = (float) 100;
        float r115 = (r104 * 1.5f) + r107;
        if (r113[0] <= ((r103 * 1.5f) + r107)) goto L30;
    L32:
        boolean r116 = false;
    L33:
        if (r116 == false) goto L35;
        float[] r108 = {r111, r106};
    L62:
        int r109 = r108.length;
        int r117 = 0;
    L63:
        if (r117 >= r109) goto L71;
        if (r108[r117] > 0.0f) goto L67;
        boolean r118 = true;
    L68:
        if (r118 == true) goto L69;
        r117 = r117 + 1;
        goto L63
    L69:
        boolean r119 = true;
    L72:
        if (r119 == false) goto L74;
        int[] r120 = null;
    L75:
        if (r120 != null) goto L79;
        b r121 = this.f209840h;
        if (r121 == null) goto L93;
        r121.a();
        return;
    L93:
        return;
    L79:
        Log.i("ImageCropFragment", "resizeWidth:" + r120[0] + ", bitmapHeight:" + r120[1]);
        View r122 = this.f209842j;
        if (r122 != null) goto L82;
        Intrinsics.throwUninitializedPropertyAccessException("mLoadingView");
        int r123 = 0;
        View r124 = null;
    L83:
        r124.setVisibility(r123);
        ImageLoader.with(this).load(com.ss.android.lark.core.storage.a.c().i(r100)).asBitmap().override(r120[r123], r120[1]).into(new com.bytedance.ee.bear.bitable.common.imagecrop.b(this));
        return;
    L82:
        r124 = r122;
        r123 = 0;
        goto L83
    L74:
        r120 = new int[]{(int) r108[0], (int) r108[1]};
        goto L75
    L67:
        r118 = false;
        goto L68
    L71:
        r119 = false;
        goto L72
    L35:
        float r125 = this.f209837e;
        int r126 = 0;
    L36:
        if (r126 >= 2) goto L44;
        if (r113[r126] <= r125) goto L40;
        boolean r127 = true;
    L41:
        if (r127 == false) goto L42;
        r126 = r126 + 1;
        goto L36
    L42:
        boolean r128 = false;
    L45:
        if (r128 == false) goto L50;
        float r129 = RangesKt.coerceAtMost(r113[0], r113[1]);
        ArrayList r130 = new ArrayList(2);
        int r131 = 0;
    L47:
        if (r131 >= r112) goto L49;
        r130.add(Float.valueOf((r113[r131] * r125) / r129));
        r131 = r131 + 1;
        r112 = 2;
        goto L47
    L49:
        r113 = CollectionsKt.toFloatArray(r130);
    L50:
        float r132 = (r114[0] * 1.5f) + r107;
        float r133 = (r114[1] * 1.5f) + r107;
        if (r113[0] <= r132) goto L53;
    L55:
        boolean r134 = false;
    L56:
        if (r134 == false) goto L58;
        r108 = r113;
        goto L62
    L58:
        float r135 = r111 / r106;
        if (r135 <= 1.0f) goto L61;
        float r136 = Math.max(r103 * 1.5f, this.f209837e);
        r108 = new float[]{r136, r136 / r135};
        goto L62
    L61:
        float r137 = Math.max(r104 * 1.5f, this.f209837e);
        r108 = new float[]{r135 * r137, r137};
        goto L62
    L53:
        if (r113[1] > r133) goto L55;
        r134 = true;
        goto L56
    L40:
        r127 = false;
        goto L41
    L44:
        r128 = true;
        goto L45
    L30:
        if (r113[1] > r115) goto L32;
        r116 = true;
    L16:
        r120 = null;
        goto L75
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public ImageCropFragment(boolean r100, float r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r102 & 2) == 0) goto L8;
        float r103 = 1080.0f;
    L10:
        if ((r102 & 4) == 0) goto L12;
        r101 = -1.0f;
    L12:
        this.f209836d = r100;
        this.f209837e = r103;
        this.f209838f = r101;
        this.f209844l = LazyKt.lazy(ImageCropFragment$mCompositeDisposable$2.INSTANCE);
        return;
    L8:
        r103 = 0.0f;
        goto L10
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.base_forms_image_crop, r101, false);
    }
}
