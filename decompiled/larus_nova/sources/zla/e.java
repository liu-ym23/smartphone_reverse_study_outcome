package zla;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import com.larus.nova.R;
import com.obric.oui.button.OButton;
import com.obric.oui.dialog.base.AbstractDialog;
import com.obric.oui.dialog.v2.alert.style.ButtonStyleController;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public class e extends ButtonStyleController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f572812a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f572813b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public OButton f572814c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public OButton f572815d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public OButton f572816e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public zla.a f572817f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f572818g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public FrameLayout f572819h;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f572820a = null;

        static {
            int[] r100 = new int[ButtonStyleController.TextColorType.values().length];
            r100[ButtonStyleController.TextColorType.Negative.ordinal()] = 1;
            r100[ButtonStyleController.TextColorType.TextReverse.ordinal()] = 2;
            r100[ButtonStyleController.TextColorType.TextReverse2.ordinal()] = 3;
            f572820a = r100;
        }
    }

    @Override // com.obric.oui.dialog.v2.alert.style.ButtonStyleController, zla.h
    public final void b(AbstractDialog r100) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
    }

    public final void l() {
        zla.a r100 = this.f572817f;
        boolean r101 = false;
        if (r100 != null) goto L6;
    L8:
        if (r101 == false) goto L10;
        return;
    L10:
        zla.a r102 = this.f572817f;
        if (r102 == null) goto L15;
        r102.dismiss();
        return;
    L15:
        return;
    L6:
        if (r100.r0() == true) goto L8;
        r101 = true;
        goto L8
    }

    @Override // com.obric.oui.dialog.v2.alert.style.ButtonStyleController
    public final OButton d() {
        return this.f572815d;
    }

    @Override // com.obric.oui.dialog.v2.alert.style.ButtonStyleController
    public final OButton e() {
        return this.f572816e;
    }

    @Override // com.obric.oui.dialog.v2.alert.style.ButtonStyleController
    public final OButton f() {
        return this.f572814c;
    }

    public final Context getContext() {
        return this.f572812a;
    }

    @Override // com.obric.oui.dialog.v2.alert.style.ButtonStyleController, zla.h
    public final void c(zla.a r100) {
        Intrinsics.checkNotNullParameter(r100, "host");
        this.f572817f = r100;
        if ((r100 instanceof com.obric.oui.dialog.v2.alert.c) == false) goto L6;
        b((AbstractDialog) r100);
        return;
    }

    public int g(int r100) {
        if (r100 == 0) goto L8;
        if (r100 == 1) goto L12;
        return R.layout.o_dialog_button_primary;
    L12:
        return R.layout.o_dialog_button_vertical;
    L8:
        if (vma.h.b(this.f572812a.getResources().getConfiguration().fontScale) == true) goto L14;
        return R.layout.o_dialog_button_horizontal;
    L14:
        return R.layout.o_dialog_button_vertical;
    }

    public e(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f572812a = r100;
        this.f572813b = r101;
    }

    public static void k(OButton r100, ButtonStyleController.TextColorType r101) {
        if (r101 == null) goto L16;
        int r102 = a.f572820a[r101.ordinal()];
        if (r102 != 1) goto L6;
        int r103 = R.color.Negative;
    L14:
        r100.setTextColor(ContextCompat.getColor(r100.getContext(), r103));
        return;
    L6:
        if (r102 != 2) goto L8;
        r103 = R.color.TextReverse;
        goto L14
    L8:
        if (r102 != 3) goto L11;
        r103 = R.color.TextReverse2;
        goto L14
    L11:
        throw new NoWhenBranchMatchedException();
    }

    @Override // zla.h
    public final void a(Context r100, f r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "dialogContainer");
        FrameLayout r102 = r101.getButtonSlot();
        FrameLayout.LayoutParams r103 = new FrameLayout.LayoutParams(-1, -2);
        int r104 = g(this.f572813b);
        View r105 = LayoutInflater.from(r100).inflate(r104, r102, false);
        r102.addView(r105, r103);
        this.f572818g = r105;
        if (r105 == null) goto L6;
        r105.setVisibility(8);
    L6:
        this.f572814c = (OButton) r105.findViewById(R.id.actionPositive);
        this.f572815d = (OButton) r105.findViewById(R.id.actionNegative);
        this.f572816e = (OButton) r105.findViewById(R.id.actionNeutral);
        this.f572819h = (FrameLayout) r105.findViewById(R.id.custom_container);
    }

    public final void i(CharSequence r100, final com.obric.oui.dialog.v2.alert.f r101) {
        OButton r102 = this.f572816e;
        if (r102 != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r100) == false) goto L9;
        r102.setVisibility(8);
        return;
    L9:
        View r103 = this.f572818g;
        if (r103 == null) goto L13;
        r103.setVisibility(0);
    L13:
        r102.setText(r100);
        r102.setVisibility(0);
        r102.setOnClickListener(new d(this, r101));
    }

    public final void h(CharSequence r100, final DialogInterface.OnClickListener r101, ButtonStyleController.TextColorType r102) {
        OButton r103 = this.f572815d;
        if (r103 != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r100) == false) goto L9;
        r103.setVisibility(8);
        return;
    L9:
        View r104 = this.f572818g;
        if (r104 == null) goto L13;
        r104.setVisibility(0);
    L13:
        r103.setText(r100);
        k(r103, r102);
        r103.setVisibility(0);
        r103.setOnClickListener(new b(this, r101));
    }

    public final void j(CharSequence r100, final DialogInterface.OnClickListener r101, ButtonStyleController.TextColorType r102, boolean r103) {
        OButton r104 = this.f572814c;
        if (r104 != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r100) == false) goto L9;
        r104.setVisibility(8);
        return;
    L9:
        View r105 = this.f572818g;
        if (r105 == null) goto L13;
        r105.setVisibility(0);
    L13:
        if (r103 == false) goto L15;
        r104.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.oui_basic_fill_element_2));
        r104.setTextColor(ContextCompat.getColor(getContext(), R.color.oui_functional_red_6));
    L15:
        r104.setText(r100);
        k(r104, r102);
        r104.setVisibility(0);
        r104.setOnClickListener(new c(this, r101));
    }
}
