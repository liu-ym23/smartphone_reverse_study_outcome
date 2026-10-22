package com.ss.lark.android.avatar.ui;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.larksuite.framework.utils.DeviceUtils;
import com.larus.nova.R;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.image.api.SimpleTarget;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import io.reactivex.disposables.CompositeDisposable;
import java.io.InputStream;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 =2\u00020\u0001:\u0002=>B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ$\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u001a\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00102\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010#\u001a\u00020!H\u0016J\u0012\u0010$\u001a\u00020!2\b\u0010%\u001a\u0004\u0018\u00010&H\u0002J\u000e\u0010'\u001a\u00020!2\u0006\u0010(\u001a\u00020\fJ\u000e\u0010)\u001a\u00020!2\u0006\u0010*\u001a\u00020\u0012J\u0006\u0010+\u001a\u00020!J\u0012\u0010,\u001a\u00020!2\b\u0010*\u001a\u0004\u0018\u00010\u0012H\u0002J\u0014\u0010-\u001a\u0004\u0018\u00010.2\b\u0010*\u001a\u0004\u0018\u00010\u0012H\u0002J(\u0010/\u001a\u00020\u00032\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002012\u0006\u00103\u001a\u00020\u00052\u0006\u00104\u001a\u000205H\u0002J\u0018\u00106\u001a\u0002012\u0006\u00107\u001a\u0002012\u0006\u00108\u001a\u00020\u0005H\u0002J\u0018\u00109\u001a\u00020!2\u0006\u0010:\u001a\u00020&2\u0006\u0010*\u001a\u00020;H\u0002J\b\u0010<\u001a\u00020!H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016¨\u0006?"}, d2 = {"Lcom/ss/lark/android/avatar/ui/AvatarCropFragment;", "Landroidx/fragment/app/Fragment;", "needProportionalCrop", "", "maxSize", "", "clipRatio", "<init>", "(ZFF)V", "mPhotoEditor", "Lcom/ss/android/photoeditor/base/IPhotoEditor;", "mCropCallback", "Lcom/ss/lark/android/avatar/ui/AvatarCropFragment$ICropAvatarCallback;", "mEditorContainer", "Landroid/widget/FrameLayout;", "mLoadingView", "Landroid/view/View;", "mAvatarPath", "", "mCompositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "getMCompositeDisposable", "()Lio/reactivex/disposables/CompositeDisposable;", "mCompositeDisposable$delegate", "Lkotlin/Lazy;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onDestroyView", "handleResultBmp", "resultBmp", "Landroid/graphics/Bitmap;", "setCropCallback", "cropCallback", "setAvatarPath", "path", "refreshImage", "loadBitmap", "getPreviewBounds", "", "checkBoundsIsValid", "bitmapBounds", "", "viewBounds", "threshold", "deviation", "", "roundShortSize", "bounds", PickerReporterConstants.KEY.TARGET, "saveToFile", SimplayerImageStrategy.RESULT_BITMAP, "Lcom/ss/android/lark/vfs/VFSPath;", LiveCommonConstants.REASON_ON_DEDTROY, "Companion", "ICropAvatarCallback", "avatar_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AvatarCropFragment extends Fragment {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f456667m = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f456668d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f456669e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f456670f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public pfc.j f456671g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public b f456672h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public FrameLayout f456673i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f456674j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f456675k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f456676l;

    public static final class a {
    }

    public interface b {
        void a();

        void b();

        void c(String r100);

        void d(String r100);
    }

    public static final class c extends SimpleTarget<Bitmap> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AvatarCropFragment f456677a;

        public c(AvatarCropFragment r100) {
            this.f456677a = r100;
        }

        @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
        public final void onResourceReady(Object r100) {
            Bitmap r101 = (Bitmap) r100;
            FragmentActivity r102 = this.f456677a.getActivity();
            if (r102 == null) goto L14;
            View r103 = this.f456677a.f456674j;
            FrameLayout r104 = null;
            if (r103 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("mLoadingView");
            r103 = null;
        L8:
            r103.setVisibility(8);
            AvatarCropFragment r105 = this.f456677a;
            ofc.b.a r106 = new ofc.b.a();
            r106.f523155a = r102;
            FrameLayout r107 = this.f456677a.f456673i;
            if (r107 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("mEditorContainer");
        L12:
            r106.f523159e = r104;
            r106.f523156b = r101;
            AvatarCropFragment r108 = this.f456677a;
            r106.f523162h = r108.f456668d;
            r106.f523163i = r108.f456670f;
            r106.f523157c = new String[]{"crop_and_rotate_plugin"};
            ofc.b r109 = r106.a();
            r109.b(new com.ss.lark.android.avatar.ui.a(this.f456677a));
            r105.f456671g = r109;
            return;
        L11:
            r104 = r107;
            goto L12
        }
    }

    static {
    }

    public AvatarCropFragment() {
        this(false, 1080.0f, -1.0f);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        ((CompositeDisposable) this.f456676l.getValue()).dispose();
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        pfc.j r100 = this.f456671g;
        if (r100 == null) goto L6;
        ((ofc.b) r100).a();
        return;
    }

    public final void S90(String r210) {
        if (r210 != null) goto L5;
    L8:
        boolean r100 = true;
    L9:
        if (r100 == false) goto L12;
        return;
    L12:
        if (r210 == null) goto L16;
        FrameLayout r101 = this.f456673i;
        if (r101 == null) goto L16;
        float r102 = DeviceUtils.getScreenWidth(r101.getContext());
        if (r101.getWidth() <= 0) goto L21;
        r102 = r101.getWidth();
    L21:
        float r103 = DeviceUtils.getScreenHeight(r101.getContext());
        if (r101.getHeight() <= 0) goto L25;
        r103 = r101.getHeight();
    L25:
        BitmapFactory.Options r104 = new BitmapFactory.Options();
        r104.inJustDecodeBounds = true;
        InputStream r110 = com.ss.android.lark.core.storage.a.c().i(r210).newInputStream();     // Catch: Throwable -> L86
        BitmapFactory.decodeStream(r110, null, r104);     // Catch: Throwable -> L86
        r110.close();     // Catch: Throwable -> L86
    L27:
        float r111 = r104.outWidth;
        float r105 = r104.outHeight;
        Log.i("AvatarCropFragment", "bitmapWidth:" + r111 + ", bitmapHeight:" + r105);
        int r112 = 2;
        float[] r113 = {r111, r105};
        float[] r114 = {r102, r103};
        float r106 = (float) 100;
        float r115 = (r103 * 1.5f) + r106;
        if (r113[0] <= ((r102 * 1.5f) + r106)) goto L30;
    L32:
        boolean r116 = false;
    L33:
        if (r116 == false) goto L35;
        float[] r107 = {r111, r105};
    L62:
        int r108 = r107.length;
        int r109 = 0;
    L63:
        if (r109 >= r108) goto L71;
        if (r107[r109] > 0.0f) goto L67;
        boolean r117 = true;
    L68:
        if (r117 == true) goto L69;
        r109 = r109 + 1;
        goto L63
    L69:
        boolean r118 = true;
    L72:
        if (r118 == false) goto L74;
        int[] r119 = null;
    L75:
        if (r119 != null) goto L80;
        b r120 = this.f456672h;
        if (r120 == null) goto L94;
        r120.a();
        return;
    L94:
        return;
    L80:
        Log.i("AvatarCropFragment", "resizeWidth:" + r119[0] + ", bitmapHeight:" + r119[1]);
        View r121 = this.f456674j;
        if (r121 != null) goto L83;
        Intrinsics.throwUninitializedPropertyAccessException("mLoadingView");
        int r122 = 0;
        View r123 = null;
    L84:
        r123.setVisibility(r122);
        ImageLoader.with(this).load(com.ss.android.lark.core.storage.a.c().i(r210)).asBitmap().override(r119[r122], r119[1]).into(new c(this));
        return;
    L83:
        r123 = r121;
        r122 = 0;
        goto L84
    L74:
        r119 = new int[]{(int) r107[0], (int) r107[1]};
        goto L75
    L67:
        r117 = false;
        goto L68
    L71:
        r118 = false;
        goto L72
    L35:
        float r124 = this.f456669e;
        int r125 = 0;
    L36:
        if (r125 >= 2) goto L44;
        if (r113[r125] <= r124) goto L40;
        boolean r126 = true;
    L41:
        if (r126 == false) goto L42;
        r125 = r125 + 1;
        goto L36
    L42:
        boolean r127 = false;
    L45:
        if (r127 == false) goto L50;
        float r128 = RangesKt.coerceAtMost(r113[0], r113[1]);
        ArrayList r129 = new ArrayList(2);
        int r130 = 0;
    L47:
        if (r130 >= r112) goto L49;
        r129.add(Float.valueOf((r113[r130] * r124) / r128));
        r130 = r130 + 1;
        r112 = 2;
        goto L47
    L49:
        r113 = CollectionsKt.toFloatArray(r129);
    L50:
        float r131 = (r114[0] * 1.5f) + r106;
        float r132 = (r114[1] * 1.5f) + r106;
        if (r113[0] <= r131) goto L53;
    L55:
        boolean r133 = false;
    L56:
        if (r133 == false) goto L58;
        r107 = r113;
        goto L62
    L58:
        float r134 = r111 / r105;
        if (r134 <= 1.0f) goto L61;
        float r135 = Math.max(r102 * 1.5f, this.f456669e);
        r107 = new float[]{r135, r135 / r134};
        goto L62
    L61:
        float r136 = Math.max(r103 * 1.5f, this.f456669e);
        r107 = new float[]{r134 * r136, r136};
        goto L62
    L53:
        if (r113[1] > r132) goto L55;
        r133 = true;
        goto L56
    L40:
        r126 = false;
        goto L41
    L44:
        r127 = true;
        goto L45
    L30:
        if (r113[1] > r115) goto L32;
        r116 = true;
    L16:
        r119 = null;
        goto L75
    L5:
        if (r210.length() == 0) goto L8;
        r100 = false;
        goto L9
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        this.f456673i = (FrameLayout) r100.findViewById(R.id.fl_container);
        this.f456674j = r100.findViewById(R.id.loading);
        S90(this.f456675k);
    }

    public AvatarCropFragment(boolean r100, float r101, float r102) {
        this.f456668d = r100;
        this.f456669e = r101;
        this.f456670f = r102;
        this.f456676l = LazyKt.lazy(AvatarCropFragment$mCompositeDisposable$2.INSTANCE);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.avatar_fragment_crop, r101, false);
    }
}
