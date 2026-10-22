package com.larus.common_ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.common_res.common_ui.databinding.LarusDialogCommonBinding;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.common.spi.IObricEnvService;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;
import v19.i5;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001`B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010@\u001a\u00020A2\b\u0010B\u001a\u0004\u0018\u00010CH\u0016J\b\u0010D\u001a\u00020AH\u0016J$\u0010E\u001a\u00020\u00072\u0006\u0010F\u001a\u00020G2\b\u0010H\u001a\u0004\u0018\u00010I2\b\u0010B\u001a\u0004\u0018\u00010CH\u0016J\u0010\u0010J\u001a\u00020\u00052\u0006\u0010K\u001a\u00020\u0007H\u0002J\u001a\u0010L\u001a\u00020A2\u0006\u0010M\u001a\u00020\u00072\b\u0010B\u001a\u0004\u0018\u00010CH\u0016J\b\u0010N\u001a\u00020AH\u0002J\u0018\u0010O\u001a\u00020A2\u0006\u0010P\u001a\u00020Q2\b\u0010R\u001a\u0004\u0018\u00010\u0012J\b\u0010S\u001a\u00020AH\u0002J\b\u0010T\u001a\u00020AH\u0002J\u0010\u0010U\u001a\u00020A2\u0006\u0010V\u001a\u00020WH\u0016J\u0010\u0010X\u001a\u00020A2\u0006\u0010V\u001a\u00020WH\u0016J\b\u0010Y\u001a\u00020AH\u0002J\u0018\u0010Z\u001a\u00020A2\u0006\u0010M\u001a\u00020\u00072\u0006\u0010[\u001a\u00020\u000eH\u0002J\b\u0010\\\u001a\u00020AH\u0002J\u0010\u0010]\u001a\u00020A2\u0006\u0010^\u001a\u00020\u000eH\u0002J\b\u0010_\u001a\u00020AH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000fR\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000fR\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR\u0010\u0010 \u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010*\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u00106\u001a\u0004\u0018\u000107X\u0082\u000e¢\u0006\u0004\n\u0002\u00108R\u000e\u00109\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006a"}, d2 = {"Lcom/larus/common_ui/dialog/CommonDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "binding", "Lcom/larus/common_res/common_ui/databinding/LarusDialogCommonBinding;", "closeButtonView", "Landroid/view/View;", "mTitle", "", "mShowMessage", "", "mMessage", "mMessageColor", "", "Ljava/lang/Integer;", "mMessageGravity", "mConfirmText", "", "mConfirmTextColor", "mCancelTextColor", "mConfirmBold", "mCancelBold", "mConfirmClickListener", "Lcom/larus/common_ui/dialog/ConfirmClickListener;", "getMConfirmClickListener", "()Lcom/larus/common_ui/dialog/ConfirmClickListener;", "setMConfirmClickListener", "(Lcom/larus/common_ui/dialog/ConfirmClickListener;)V", "mEarlyConfirmClickListener", "getMEarlyConfirmClickListener", "setMEarlyConfirmClickListener", "mCancelText", "mCancelClickListener", "Lcom/larus/common_ui/dialog/CancelClickListener;", "mWhiteClickListener", "Lcom/larus/common_ui/dialog/WhiteClickListener;", "mOnDismissListener", "Landroid/content/DialogInterface$OnDismissListener;", "mButtonTrim", "mCanceledOnTouchOutside", "mCancelable", "backListener", "Lkotlin/Function0;", "mMessageTestStyle", "Lcom/larus/common_ui/dialog/CommonDialogTextStyleConfig;", "mConfirmTextStyle", "mCancelTextStyle", "needSetWindowTransparent", "useShadow", "mTopImageUrl", "Landroid/net/Uri;", "mTopImageSize", "Landroid/util/Size;", "mTopImageRadius", "", "Ljava/lang/Float;", "needResumeVisible", "mDismissWhenConfirm", "mDismissWhenCancel", "mShowCloseButton", "mCloseClickListener", "Landroid/view/View$OnClickListener;", "dialogView", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "bindDialogContent", "rootView", "onViewCreated", "view", "setUpMessageTextStyle", "showAllowingStateLoss", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "tag", "setUpConfirmTextStyle", "setUpCancelTextStyle", "onCancel", "dialog", "Landroid/content/DialogInterface;", "onDismiss", "setupView", "updateBottomButtonVisibility", RemoteMessageConst.Notification.VISIBILITY, "setupCloseButton", "updateTitleHorizontalMargin", "horizontalMargin", "setTopImage", "Builder", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommonDialog extends DialogFragment {
    public static final /* synthetic */ int N = 0;
    public f0 A;
    public f0 B;
    public boolean C;
    public boolean D;
    public Uri E;
    public Size F;
    public Float G;
    public boolean H;
    public boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f327148J;
    public boolean K;
    public View.OnClickListener L;
    public View M;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LarusDialogCommonBinding f327149d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f327150e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CharSequence f327151f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f327152g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public CharSequence f327153h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Integer f327154i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Integer f327155j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f327156k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f327157l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f327158m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f327159n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f327160o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public p0 f327161p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public p0 f327162q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f327163r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public u f327164s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public l1 f327165t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public DialogInterface.OnDismissListener f327166u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f327167v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f327168w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f327169x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Function0<Boolean> f327170y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public f0 f327171z;

    public static final class a {
        public boolean A;
        public Function0<Boolean> B;
        public f0 C;
        public f0 D;
        public f0 E;
        public boolean F;
        public boolean G;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CharSequence f327172a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f327173b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Float f327174c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f327175d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Uri f327176e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Size f327177f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f327178g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public View.OnClickListener f327179h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public CharSequence f327180i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Integer f327181j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Integer f327182k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public String f327183l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f327184m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public p0 f327185n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public p0 f327186o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public boolean f327187p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f327188q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f327189r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public String f327190s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public boolean f327191t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public u f327192u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public l1 f327193v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public boolean f327194w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public DialogInterface.OnDismissListener f327195x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public boolean f327196y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public boolean f327197z;

        public final CommonDialog a() {
            CommonDialog r100 = new CommonDialog();
            r100.f327151f = this.f327172a;
            r100.f327153h = this.f327180i;
            r100.f327154i = this.f327181j;
            r100.f327155j = this.f327182k;
            r100.f327156k = this.f327183l;
            r100.f327161p = this.f327185n;
            r100.f327162q = this.f327186o;
            r100.f327159n = this.f327184m;
            r100.f327160o = this.f327191t;
            r100.f327157l = this.f327188q;
            r100.f327158m = this.f327189r;
            r100.f327163r = this.f327190s;
            r100.f327164s = this.f327192u;
            r100.f327165t = this.f327193v;
            r100.f327167v = this.f327194w;
            r100.f327166u = this.f327195x;
            r100.f327168w = this.f327197z;
            r100.f327169x = this.A;
            r100.f327170y = this.B;
            r100.f327171z = this.C;
            r100.A = this.D;
            r100.B = this.E;
            r100.C = this.F;
            r100.D = this.G;
            r100.E = this.f327176e;
            r100.F = this.f327177f;
            r100.G = this.f327174c;
            r100.H = this.f327175d;
            r100.f327152g = this.f327173b;
            r100.I = this.f327187p;
            r100.f327148J = this.f327196y;
            r100.K = this.f327178g;
            r100.L = this.f327179h;
            return r100;
        }

        public a() {
            this.f327173b = true;
            this.f327187p = true;
            this.f327196y = true;
            this.f327197z = true;
            this.A = true;
            this.F = true;
        }

        public final CommonDialog c() {
            CommonDialog r100 = a();
            r100.f327152g = false;
            return r100;
        }

        public final CommonDialog b(int r100) {
            CommonDialog r101 = a();
            r101.f327157l = r100;
            return r101;
        }

        public final CommonDialog d(int r100) {
            CommonDialog r101 = a();
            r101.f327157l = r100;
            r101.f327152g = false;
            return r101;
        }

        public final void g(CharSequence r100) {
            Intrinsics.checkNotNullParameter(r100, "message");
            this.f327180i = r100;
        }

        public final void h(int r100) {
            this.f327181j = Integer.valueOf(r100);
        }

        public final void i(CharSequence r100) {
            Intrinsics.checkNotNullParameter(r100, "title");
            this.f327172a = r100;
        }

        public static void e(a r100, u r101, String r102, int r103) {
            if ((r103 & 2) == 0) goto L6;
            r102 = null;
        L6:
            if ((r103 & 4) == 0) goto L8;
            boolean r104 = true;
        L9:
            Intrinsics.checkNotNullParameter(r101, "listener");
            r100.f327190s = r102;
            r100.f327192u = r101;
            r100.f327196y = r104;
            return;
        L8:
            r104 = false;
            goto L9
        }

        public static void f(a r100, p0 r101, String r102, boolean r103, int r104) {
            if ((r104 & 2) == 0) goto L5;
            r102 = null;
        L5:
            boolean r105 = false;
            if ((r104 & 4) == 0) goto L9;
            r103 = false;
        L9:
            if ((r104 & 8) == 0) goto L11;
            r105 = true;
        L11:
            Intrinsics.checkNotNullParameter(r101, "listener");
            r100.f327183l = r102;
            if (r103 == false) goto L14;
            r100.f327186o = r101;
        L15:
            r100.f327187p = r105;
            return;
        L14:
            r100.f327185n = r101;
            goto L15
        }
    }

    public CommonDialog() {
        this.f327151f = "";
        this.f327152g = true;
        this.f327153h = "";
        this.f327168w = true;
        this.f327169x = true;
        this.C = true;
        this.I = true;
        this.f327148J = true;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        Dialog r100 = getDialog();
        if (r100 == null) goto L11;
        Window r101 = r100.getWindow();
        if (r101 == null) goto L11;
        r101.setLayout(-1, -2);
        WindowManager.LayoutParams r102 = r101.getAttributes();
        Resources r103 = r101.getWindowStyle().getResources();
        int r104 = WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics()).widthPixels - (i5.d0() * 2);
        r102.width = r104;
        if (r104 <= i5.L()) goto L9;
        r102.width = i5.L();
    L9:
        r101.setAttributes(r102);
    L11:
        if (this.H == false) goto L15;
        View r105 = this.M;
        if (r105 == null) goto L15;
        com.larus.utils.e1.x(r105);
    L15:
        final Function0<Boolean> r106 = this.f327170y;
        if (r106 == null) goto L21;
        Dialog r107 = getDialog();
        if (r107 == null) goto L22;
        r107.setOnKeyListener(new z(r106));
        return;
    L22:
        return;
    }

    public static void S90(CommonDialog r100) {
        r100.dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r101 = DialogFragmentLancet.sLastShowStack;
        if (r101 == null) goto L11;
        com.bytedance.crash.d.d(r101, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final void U90(View r100) {
        r100.setVisibility(8);
        LarusDialogCommonBinding r101 = this.f327149d;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r101 = null;
    L6:
        if (r101.f326661c.getVisibility() != 8) goto L11;
        r101.f326665g.setVisibility(8);
        TextView r102 = r101.f326660b;
        if (r102 == null) goto L22;
        r102.setBackgroundResource(v19.c.b(R.attr.larus_bg_down_selector, r102.getContext(), R.drawable.larus_bg_down_selector));
        return;
    L22:
        return;
    L11:
        if (r101.f326660b.getVisibility() != 8) goto L15;
        r101.f326665g.setVisibility(8);
        TextView r103 = r101.f326661c;
        if (r103 == null) goto L24;
        r103.setBackgroundResource(v19.c.b(R.attr.larus_bg_down_selector, r103.getContext(), R.drawable.larus_bg_down_selector));
        return;
    L24:
        return;
    L15:
        r101.f326665g.setVisibility(0);
        TextView r104 = r101.f326661c;
        if (r104 == null) goto L18;
        r104.setBackgroundResource(v19.c.b(R.attr.larus_bg_leftdown_selector, r104.getContext(), R.drawable.larus_bg_leftdown_selector));
    L18:
        TextView r105 = r101.f326660b;
        if (r105 == null) goto L26;
        r105.setBackgroundResource(v19.c.b(R.attr.larus_bg_rightdown_selector, r105.getContext(), R.drawable.larus_bg_rightdown_selector));
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        super.onCancel(r100);
        S90(this);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        IObricEnvService r101 = (IObricEnvService) ServiceManager.get().getService(IObricEnvService.class);
        if (r101 == null) goto L6;
        r101.b(new a0(this));
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");     // Catch: Throwable -> L7
        super.onDismiss(r100);     // Catch: Throwable -> L7
        DialogInterface.OnDismissListener r101 = this.f327166u;     // Catch: Throwable -> L7
        if (r101 == null) goto L5;
        r101.onDismiss(r100);     // Catch: Throwable -> L7
    L5:
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L7:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public final void T90(FragmentManager r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "fragmentManager");
        FragmentTransaction r102 = r100.beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r102, this, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r101, 0) == true) goto L6;
        r102.add(this, r101);
    L6:
        r102.commitAllowingStateLoss();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        LarusDialogCommonBinding r102 = this.f327149d;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r102 = null;
    L5:
        r102.f326663e.setText(this.f327151f);
        View r103 = this.f327150e;
        boolean r104 = false;
        if (r103 != null) goto L9;
    L24:
        LarusDialogCommonBinding r105 = this.f327149d;
        if (r105 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r105 = null;
    L27:
        TextView r106 = r105.f326662d;
        if (this.f327152g == false) goto L30;
        int r107 = 0;
    L31:
        r106.setVisibility(r107);
        LarusDialogCommonBinding r108 = this.f327149d;
        if (r108 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r108 = null;
    L34:
        r108.f326662d.setText(this.f327153h);
        CharSequence r109 = this.f327151f;
        if (r109 != null) goto L37;
    L40:
        boolean r110 = true;
    L42:
        if (r110 == false) goto L51;
        LarusDialogCommonBinding r111 = this.f327149d;
        if (r111 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r111 = null;
    L46:
        r111.f326663e.setVisibility(8);
        LinearLayout.LayoutParams r112 = new LinearLayout.LayoutParams(-1, -2);
        r112.topMargin = i5.E();
        r112.leftMargin = i5.A();
        r112.rightMargin = i5.A();
        LarusDialogCommonBinding r113 = this.f327149d;
        if (r113 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r113 = null;
    L49:
        r113.f326662d.setLayoutParams(r112);
    L51:
        if ((this.f327153h instanceof SpannableString) == false) goto L59;
        LarusDialogCommonBinding r114 = this.f327149d;
        if (r114 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r114 = null;
    L55:
        r114.f326662d.setMovementMethod(LinkMovementMethod.getInstance());
        LarusDialogCommonBinding r115 = this.f327149d;
        if (r115 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r115 = null;
    L58:
        r115.f326662d.setHighlightColor(0);
    L59:
        Integer r116 = this.f327154i;
        if (r116 == null) goto L65;
        int r117 = r116.intValue();
        LarusDialogCommonBinding r118 = this.f327149d;
        if (r118 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r118 = null;
    L64:
        r118.f326662d.setTextColor(r117);
    L65:
        Integer r119 = this.f327155j;
        if (r119 == null) goto L71;
        int r120 = r119.intValue();
        LarusDialogCommonBinding r121 = this.f327149d;
        if (r121 != null) goto L70;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r121 = null;
    L70:
        r121.f326662d.setGravity(r120);
    L71:
        String r122 = this.f327156k;
        if (r122 != null) goto L74;
    L77:
        boolean r123 = true;
    L78:
        if (r123 == true) goto L84;
        LarusDialogCommonBinding r124 = this.f327149d;
        if (r124 != null) goto L82;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r124 = null;
    L82:
        r124.f326661c.setText(this.f327156k);
    L84:
        if (this.f327157l != 0) goto L91;
        Context r125 = getContext();
        if (r125 == null) goto L96;
        LarusDialogCommonBinding r126 = this.f327149d;
        if (r126 != null) goto L90;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r126 = null;
    L90:
        r126.f326661c.setTextColor(ContextCompat.getColor(r125, R.color.larus_danger_50));
    L96:
        if (this.f327159n == false) goto L102;
        LarusDialogCommonBinding r127 = this.f327149d;
        if (r127 != null) goto L100;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r127 = null;
    L100:
        r127.f326661c.setTypeface(Typeface.DEFAULT_BOLD);
    L102:
        if (this.f327158m != 0) goto L109;
        Context r128 = getContext();
        if (r128 == null) goto L114;
        LarusDialogCommonBinding r129 = this.f327149d;
        if (r129 != null) goto L108;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r129 = null;
    L108:
        r129.f326660b.setTextColor(ContextCompat.getColor(r128, v19.c.b(R.attr.larus_neutral_100, r128, R.color.larus_neutral_100)));
    L114:
        if (this.f327160o == false) goto L119;
        LarusDialogCommonBinding r130 = this.f327149d;
        if (r130 != null) goto L118;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r130 = null;
    L118:
        r130.f326660b.setTypeface(Typeface.DEFAULT_BOLD);
    L119:
        LarusDialogCommonBinding r131 = this.f327149d;
        if (r131 != null) goto L122;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r131 = null;
    L122:
        r131.f326661c.setOnClickListener(new b0(this));
        if (this.f327164s != null) goto L128;
        LarusDialogCommonBinding r132 = this.f327149d;
        if (r132 != null) goto L127;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r132 = null;
    L127:
        U90(r132.f326660b);
    L145:
        if (this.f327167v == false) goto L184;
        String r133 = this.f327156k;
        if (r133 != null) goto L149;
    L152:
        boolean r134 = true;
    L153:
        if (r134 == true) goto L162;
        String r135 = this.f327163r;
        if (r135 != null) goto L157;
    L160:
        boolean r136 = true;
    L161:
        if (r136 == false) goto L184;
    L157:
        if (r135.length() == 0) goto L160;
        r136 = false;
    L162:
        String r137 = this.f327156k;
        if (r137 != null) goto L165;
    L168:
        boolean r138 = true;
    L169:
        if (r138 == false) goto L174;
        LarusDialogCommonBinding r139 = this.f327149d;
        if (r139 != null) goto L173;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r139 = null;
    L173:
        U90(r139.f326661c);
    L174:
        String r140 = this.f327163r;
        if (r140 != null) goto L177;
    L178:
        r104 = true;
    L179:
        if (r104 == false) goto L184;
        LarusDialogCommonBinding r141 = this.f327149d;
        if (r141 != null) goto L183;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r141 = null;
    L183:
        U90(r141.f326660b);
        goto L184
    L177:
        if (r140.length() != 0) goto L179;
    L165:
        if (r137.length() == 0) goto L168;
        r138 = false;
        goto L169
    L149:
        if (r133.length() == 0) goto L152;
        r134 = false;
    L184:
        f0 r142 = this.f327171z;
        if (r142 == null) goto L204;
        Integer r143 = r142.f327305a;
        if (r143 == null) goto L192;
        int r144 = r143.intValue();
        LarusDialogCommonBinding r145 = this.f327149d;
        if (r145 != null) goto L191;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r145 = null;
    L191:
        r145.f326662d.setTextSize(r144);
    L192:
        Integer r146 = r142.f327306b;
        if (r146 == null) goto L198;
        int r147 = r146.intValue();
        LarusDialogCommonBinding r148 = this.f327149d;
        if (r148 != null) goto L197;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r148 = null;
    L197:
        r148.f326662d.setTextColor(r147);
    L198:
        Typeface r149 = r142.f327307c;
        if (r149 == null) goto L204;
        LarusDialogCommonBinding r150 = this.f327149d;
        if (r150 != null) goto L203;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r150 = null;
    L203:
        r150.f326662d.setTypeface(r149);
    L204:
        f0 r151 = this.A;
        if (r151 == null) goto L224;
        Integer r152 = r151.f327305a;
        if (r152 == null) goto L212;
        int r153 = r152.intValue();
        LarusDialogCommonBinding r154 = this.f327149d;
        if (r154 != null) goto L211;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r154 = null;
    L211:
        r154.f326661c.setTextSize(r153);
    L212:
        Integer r155 = r151.f327306b;
        if (r155 == null) goto L218;
        int r156 = r155.intValue();
        LarusDialogCommonBinding r157 = this.f327149d;
        if (r157 != null) goto L217;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r157 = null;
    L217:
        r157.f326661c.setTextColor(r156);
    L218:
        Typeface r158 = r151.f327307c;
        if (r158 == null) goto L224;
        LarusDialogCommonBinding r159 = this.f327149d;
        if (r159 != null) goto L223;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r159 = null;
    L223:
        r159.f326661c.setTypeface(r158);
    L224:
        f0 r160 = this.B;
        if (r160 == null) goto L245;
        Integer r161 = r160.f327305a;
        if (r161 == null) goto L232;
        int r162 = r161.intValue();
        LarusDialogCommonBinding r163 = this.f327149d;
        if (r163 != null) goto L231;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r163 = null;
    L231:
        r163.f326660b.setTextSize(r162);
    L232:
        Integer r164 = r160.f327306b;
        if (r164 == null) goto L238;
        int r165 = r164.intValue();
        LarusDialogCommonBinding r166 = this.f327149d;
        if (r166 != null) goto L237;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r166 = null;
    L237:
        r166.f326660b.setTextColor(r165);
    L238:
        Typeface r167 = r160.f327307c;
        if (r167 == null) goto L245;
        LarusDialogCommonBinding r168 = this.f327149d;
        if (r168 != null) goto L243;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r168 = null;
    L243:
        r168.f326660b.setTypeface(r167);
    L245:
        if (this.E == null) goto L274;
        LarusDialogCommonBinding r169 = this.f327149d;
        if (r169 != null) goto L249;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r169 = null;
    L249:
        com.larus.utils.e1.x(r169.f326664f);
        LarusDialogCommonBinding r170 = this.f327149d;
        if (r170 != null) goto L252;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r170 = null;
    L252:
        SimpleDraweeView r171 = r170.f326664f;
        if (this.F != null) goto L255;
        LinearLayout.LayoutParams r172 = new LinearLayout.LayoutParams(-2, -2);
    L264:
        r172.topMargin = c7.b(25);
        r171.setLayoutParams(r172);
        if (this.E == null) goto L274;
        LarusDialogCommonBinding r173 = this.f327149d;
        if (r173 != null) goto L269;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r173 = null;
    L269:
        ImageLoaderKt.s(r173.f326664f, this.E, null);
        Float r174 = this.G;
        if (r174 == null) goto L272;
        float r175 = r174.floatValue();
    L273:
        ((GenericDraweeHierarchy) r171.getHierarchy()).setRoundingParams(RoundingParams.fromCornersRadius(r175));
        goto L274
    L272:
        r175 = 0.0f;
        goto L273
    L255:
        Size r176 = this.F;
        if (r176 == null) goto L258;
        Integer r177 = Integer.valueOf(r176.getWidth());
    L259:
        Intrinsics.checkNotNull(r177);
        int r178 = r177.intValue();
        Size r179 = this.F;
        if (r179 == null) goto L262;
        Integer r180 = Integer.valueOf(r179.getHeight());
    L263:
        Intrinsics.checkNotNull(r180);
        r172 = new LinearLayout.LayoutParams(r178, r180.intValue());
        goto L264
    L262:
        r180 = null;
        goto L263
    L258:
        r177 = null;
    L274:
        Dialog r181 = getDialog();
        if (r181 == null) goto L277;
        r181.setCanceledOnTouchOutside(this.f327168w);
        r181.setCancelable(this.f327169x);
    L277:
        Dialog r182 = getDialog();
        if (r182 == null) goto L289;
        Window r183 = r182.getWindow();
        if (r183 == null) goto L290;
        View r184 = r183.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L286;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r185 = ThreadMethodProxy.currentThread();
        if (r185 == com.larus.home.impl.utils.c.f346341a) goto L286;
        com.larus.home.impl.utils.c.a(r185, "getDecorView");
    L286:
        if (r184 == null) goto L291;
        r184.setOnTouchListener(new y(this));
        return;
    L291:
        return;
    L290:
        return;
    L289:
        return;
    L128:
        String r186 = this.f327163r;
        if (r186 != null) goto L131;
    L134:
        boolean r187 = true;
    L135:
        if (r187 == true) goto L140;
        LarusDialogCommonBinding r188 = this.f327149d;
        if (r188 != null) goto L139;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r188 = null;
    L139:
        r188.f326660b.setText(this.f327163r);
    L140:
        LarusDialogCommonBinding r189 = this.f327149d;
        if (r189 != null) goto L143;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r189 = null;
    L143:
        r189.f326660b.setOnClickListener(new c0(this));
        goto L145
    L131:
        if (r186.length() == 0) goto L134;
        r187 = false;
        goto L135
    L109:
        LarusDialogCommonBinding r190 = this.f327149d;
        if (r190 != null) goto L112;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r190 = null;
    L112:
        r190.f326660b.setTextColor(this.f327158m);
        goto L114
    L91:
        LarusDialogCommonBinding r191 = this.f327149d;
        if (r191 != null) goto L94;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r191 = null;
    L94:
        r191.f326661c.setTextColor(this.f327157l);
        goto L96
    L74:
        if (r122.length() == 0) goto L77;
        r123 = false;
        goto L78
    L37:
        if (r109.length() == 0) goto L40;
        r110 = false;
        goto L42
    L30:
        r107 = 8;
        goto L31
    L9:
        if (this.K == true) goto L11;
        r103.setVisibility(8);
        r103.setOnClickListener(null);
        goto L24
    L11:
        r103.setVisibility(0);
        int r192 = i5.d0();
        LarusDialogCommonBinding r193 = this.f327149d;
        if (r193 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r193 = null;
    L14:
        ViewGroup.LayoutParams r194 = r193.f326663e.getLayoutParams();
        if ((r194 instanceof ViewGroup.MarginLayoutParams) == false) goto L17;
        ViewGroup.MarginLayoutParams r195 = (ViewGroup.MarginLayoutParams) r194;
    L18:
        if (r195 == null) goto L23;
        r195.setMarginStart(r192);
        r195.setMarginEnd(r192);
        LarusDialogCommonBinding r196 = this.f327149d;
        if (r196 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r196 = null;
    L22:
        r196.f326663e.setLayoutParams(r195);
    L23:
        r103.setOnClickListener(new d0(this));
        int r197 = c7.b(8);
        com.larus.utils.e1.g(r103, r197, r197, r197, r197);
        goto L24
    L17:
        r195 = null;
        goto L18
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        if (this.D == false) goto L17;
        if (this.K == false) goto L11;
        View r103 = r100.inflate(R.layout.larus_dialog_common_shadow_with_close, r101, false);
        View r104 = r103.findViewById(R.id.dialog_common_content);
        if (r104 == null) goto L10;
        this.f327149d = LarusDialogCommonBinding.a(r104);
        View r105 = r103;
    L24:
        this.f327150e = r105.findViewById(R.id.dialog_close);
        if (this.C == false) goto L31;
        Dialog r106 = getDialog();
        if (r106 == null) goto L38;
        Window r107 = r106.getWindow();
        if (r107 == null) goto L38;
        r107.setBackgroundDrawable(new ColorDrawable(0));
    L38:
        this.M = r105;
        if (this.H == false) goto L41;
        com.larus.utils.e1.o(r105);
    L41:
        return r105;
    L31:
        Context r108 = getContext();
        if (r108 == null) goto L38;
        Dialog r109 = getDialog();
        if (r109 == null) goto L38;
        Window r110 = r109.getWindow();
        if (r110 == null) goto L38;
        r110.setBackgroundDrawable(ContextCompat.getDrawable(r108, v19.c.b(R.attr.larus_bg_round_full, getContext(), R.drawable.larus_bg_round_full)));
        goto L38
    L10:
        throw new IllegalArgumentException("Missing dialog content view for CommonDialog".toString());
    L11:
        View r111 = r100.inflate(R.layout.larus_dialog_common_shadow, r101, false);
        if (r111 == null) goto L15;
        CardView r112 = (CardView) r111;
        this.f327149d = LarusDialogCommonBinding.a(r112.getChildAt(0));
        r105 = r112;
        goto L24
    L15:
        throw new NullPointerException("rootView");
    L17:
        if (this.K == false) goto L23;
        View r113 = r100.inflate(R.layout.larus_dialog_common_with_close, r101, false);
        View r114 = r113.findViewById(R.id.dialog_common_content);
        if (r114 == null) goto L22;
        this.f327149d = LarusDialogCommonBinding.a(r114);
        r105 = r113;
        goto L24
    L22:
        throw new IllegalArgumentException("Missing dialog content view for CommonDialog".toString());
    L23:
        LarusDialogCommonBinding r115 = LarusDialogCommonBinding.a(r100.inflate(R.layout.larus_dialog_common, r101, false));
        this.f327149d = r115;
        r105 = r115.f326659a;
        goto L24
    }
}
