package com.bytedance.locallife.poi.poidetail.screenshot.ui;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.app.LifeAccessibilityUtil;
import androidx.core.content.ContextCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.dux.panel.DuxBasicPanelFragment;
import com.bytedance.dux.widget.DuxRadiusImageView;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import em4.i;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/locallife/poi/poidetail/screenshot/ui/PoiScreenshotPanelFragment;", "Lcom/bytedance/dux/panel/DuxBasicPanelFragment;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final class PoiScreenshotPanelFragment extends DuxBasicPanelFragment {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ int f264193s = 0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Disposable f264194q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final b f264195r;

    public static final class a {
    }

    public static final class b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PoiScreenshotPanelFragment f264196a;

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            if (r100.what == 1) goto L12;
            return;
        L12:
            this.f264196a.dismissAllowingStateLoss();     // Catch: Exception -> L7
            return;
        L7:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r101 = DialogFragmentLancet.sLastShowStack;
            if (r101 == null) goto L15;
            com.bytedance.crash.d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }

        public b(PoiScreenshotPanelFragment r100, Looper r101) {
            this.f264196a = r100;
            super(r101);
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PoiScreenshotPanelFragment f264197a;

        public c(PoiScreenshotPanelFragment r100) {
            this.f264197a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f264197a.dismiss();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
            Throwable r101 = DialogFragmentLancet.sLastShowStack;
            if (r101 == null) goto L12;
            com.bytedance.crash.d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        }
    }

    public static final class d implements LifeAccessibilityUtil.AccessibilityDelegateCallBack {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f264198a = null;

        static {
            f264198a = new d();
        }

        public d() {
        }

        @Override // androidx.core.app.LifeAccessibilityUtil.AccessibilityDelegateCallBack
        public final void onInitializeAccessibilityNodeInfo(View r100, AccessibilityNodeInfoCompat r101) {
            r101.setContentDescription("关闭");
        }
    }

    public static final class e<T> implements SingleOnSubscribe {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PoiScreenshotPanelFragment f264199a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f264200b;

        public e(PoiScreenshotPanelFragment r100, String r101) {
            this.f264199a = r100;
            this.f264200b = r101;
        }

        @Override // io.reactivex.SingleOnSubscribe
        public final void subscribe(SingleEmitter<Bitmap> r100) {
            Intrinsics.checkNotNullParameter(r100, "emitter");
            PoiScreenshotPanelFragment r101 = this.f264199a;
            String r102 = this.f264200b;
            int r103 = PoiScreenshotPanelFragment.f264193s;
            r101.getClass();
            HostServiceUtilsKt.d0().a(HostServiceUtilsKt.E().getApplicationContext());
            PolarisFileWrapper r104 = new PolarisFileWrapper(r102);
            Bitmap r105 = null;
            r105 = null;
            r105 = null;
            PolarisFileInputStreamWrapper r106 = null;
            if (r104.exists() == true) goto L24;
        L18:
            if (r105 != null) goto L20;
            r100.onError(new Throwable("bitmap null"));
            return;
        L20:
            r100.onSuccess(r105);
            return;
        L24:
            PolarisFileInputStreamWrapper r107 = new PolarisFileInputStreamWrapper(r104);     // Catch: Throwable -> L11 Exception -> L15
            BitmapFactory.Options r108 = new BitmapFactory.Options();     // Catch: Throwable -> L8 Exception -> L10
            r108.inPreferredConfig = Bitmap.Config.RGB_565;     // Catch: Throwable -> L8 Exception -> L10
            Unit r109 = Unit.INSTANCE;     // Catch: Throwable -> L8 Exception -> L10
            r105 = BitmapFactory.decodeStream(r107, null, r108);     // Catch: Throwable -> L8 Exception -> L10
        L17:
            r107.close();
            goto L18
        L8:
            th = th;
            r106 = r107;
        L12:
            if (r106 == null) goto L14;
            r106.close();
        L14:
            throw th;
        L16:
            if (r107 == null) goto L18;
        L15:
            r107 = null;
        L11:
            th = th;
            goto L12
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DuxRadiusImageView f264201a;

        public f(DuxRadiusImageView r100) {
            this.f264201a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            DuxRadiusImageView r101 = this.f264201a;
            r101.setImageBitmap((Bitmap) r100);
        }
    }

    public static final class g<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g<T> f264202a = null;

        static {
            f264202a = new g();
        }

        public g() {
        }

        @Override // io.reactivex.functions.Consumer
        public final /* bridge */ /* synthetic */ void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
        }
    }

    static {
    }

    public PoiScreenshotPanelFragment() {
        this.f264195r = new b(this, Looper.getMainLooper());
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.f264195r.removeMessages(1);
        Disposable r100 = this.f264194q;
        if (r100 == null) goto L6;
        r100.dispose();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        this.f205331k = true;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        com.bytedance.dux.panel.header.b r102 = new com.bytedance.dux.panel.header.b(requireContext());     // Catch: Throwable -> L5
        ImageView r103 = r102.f205385h;     // Catch: Throwable -> L5
        Intrinsics.checkNotNullParameter(r103, "<this>");     // Catch: Throwable -> L5
        r103.setVisibility(4);     // Catch: Throwable -> L5
        r102.f205385h.setOnClickListener(null);     // Catch: Throwable -> L5
        i r104 = new i(ContextCompat.getColor(r102.b(), R.color.TextReverse));     // Catch: Throwable -> L5
        Drawable r105 = ContextCompat.getDrawable(r102.b(), R.drawable.dux_basic_panel_normal_header_close_bg_dark);     // Catch: Throwable -> L5
        r102.f205385h.setColorFilter(r104);     // Catch: Throwable -> L5
        r102.f205383f.setColorFilter(r104);     // Catch: Throwable -> L5
        r102.f205385h.setBackground(r105);     // Catch: Throwable -> L5
        r102.f205383f.setBackground(r105);     // Catch: Throwable -> L5
        Intrinsics.checkNotNullParameter("截屏成功，你可能想要", "charSequence");     // Catch: Throwable -> L5
        com.bytedance.dux.panel.header.b.e(r102, "截屏成功，你可能想要");     // Catch: Throwable -> L5
        r102.f205384g.setGravity(17);     // Catch: Throwable -> L5
        r102.f205384g.setTextSize(1, 17.0f);     // Catch: Throwable -> L5
        r102.d(new c(this));     // Catch: Throwable -> L5
        this.f205326f = r102;     // Catch: Throwable -> L5
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        com.bytedance.dux.panel.header.d r106 = this.f205326f;
        if (r106 == null) goto L14;
        View r107 = r106.c();
        if (r107 == null) goto L14;
        AppCompatImageView r108 = (AppCompatImageView) r107.findViewById(R.id.iv_close);
        if (r108 == null) goto L14;
        LifeAccessibilityUtil.setAccessibilityDelegate(r108, d.f264198a);
    L14:
        this.f205327g = AnonymousClass3.INSTANCE;
        this.f264195r.sendEmptyMessageDelayed(1, 5000);
        return;
    L5:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // com.bytedance.dux.panel.DuxBasicPanelFragment, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");     // Catch: Throwable -> L5
        super.onDismiss(r100);     // Catch: Throwable -> L5
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L5:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    @Override // com.bytedance.dux.panel.DuxBasicPanelFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        if (r101 != null) goto L15;
        DuxRadiusImageView r102 = (DuxRadiusImageView) r100.findViewById(R.id.iv_screenshot);
        RecyclerView r103 = (RecyclerView) r100.findViewById(R.id.rv_share_channel);
        if (r103 == null) goto L19;
        r103.setLayoutManager(new LinearLayoutManager(r103.getContext(), 0, false));
        return;
    L19:
        return;
    L15:
        dismissAllowingStateLoss();     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r104 = DialogFragmentLancet.sLastShowStack;
        if (r104 == null) goto L17;
        com.bytedance.crash.d.d(r104, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.saas_poi_fragment_screenshot_share, r101);
    }
}
