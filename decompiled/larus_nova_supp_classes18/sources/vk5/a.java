package vk5;

import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.onboarding.export.Direction;
import com.bytedance.ee.bear.onboarding.export.OnBoardingColorStyle;
import com.bytedance.ee.bear.onboarding.export.ui.FlowStyleHollowShape;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import tk5.d;
import uk5.e;
import yk5.f;
import yk5.g;
import yk5.h;
import yk5.i;
import yk5.j;
import yk5.k;
import yk5.m;
import yk5.n;
import yk5.o;
import yk5.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class a implements c {
    public final tk5.b a;
    public final FragmentActivity b;
    public d<? extends c> c;
    public OnBoardingColorStyle d;
    public sk5.d.a e;
    public sk5.d f;

    public boolean a() {
        return true;
    }

    public FragmentActivity getActivity() {
        return this.b;
    }

    public a(FragmentActivity r1, tk5.b r2) {
        this.a = r2;
        this.b = r1;
    }

    public final void e(Window r11, e r12) {
        b r3 = new b(this.c, this.a, null, this.e);
        if (this.f == null) goto L40;
        FragmentActivity r0 = this.b;
        OnBoardingColorStyle r1 = this.d;
        q r2 = new q(r0, r11);
        r2.j = r3;
        r2.h = r12.a;
        String r13 = r12.b;
        String r4 = r12.c;
        View r5 = r12.d;
        int[] r6 = r12.e;
        RectF r7 = r12.f;
        Direction r8 = r12.g;
        Integer r14 = Integer.valueOf(r12.h);
        if (TextUtils.isEmpty(r13) == false) goto L7;
    L9:
        r2.l.setVisibility(8);
        ViewGroup.LayoutParams r9 = r2.m.getLayoutParams();
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r10 = (ViewGroup.MarginLayoutParams) r9;
        r10.topMargin = r2.getContext().getResources().getDimensionPixelOffset(2131166203);
        r2.m.setLayoutParams(r10);
        if (r13 != null) goto L14;
        if (r4 != null) goto L13;
        r13 = "";
    L13:
        r13 = r4;
    L14:
        r2.m.setText(r13);
        r2.m.getPaint().setFakeBoldText(true);
        r2.m.setVisibility(0);
        r2.d(r1);
        r2.o.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        if (r14 == null) goto L17;
        int r15 = r14.intValue();
    L18:
        r2.q = r15;
        List<Float> r16 = new m(r2.k, r2.o.getMeasuredWidth(), r2.o.getMeasuredHeight(), Integer.valueOf(r2.r)).b(r5, r6, r7, r8);
        if (r16 == null) goto L32;
        float r17 = ((Number) ListProtector.get(r16, 0)).floatValue();
        float r18 = ((Number) ListProtector.get(r16, 1)).floatValue();
        float r19 = ((Number) ListProtector.get(r16, 2)).floatValue();
        float r110 = ((Number) ListProtector.get(r16, 3)).floatValue();
        r2.n.setX(r17 - r19);
        View r111 = r2.n;
        float r20 = 0.0f;
        if (r18 <= r110) goto L23;
        float r21 = r2.o.getMeasuredHeight() - (r2.r / 2);
    L24:
        r111.setY(r21);
        r2.o.setX(0.0f);
        View r112 = r2.o;
        if (r18 > r110) goto L28;
        r20 = r2.r / 2;
    L28:
        r112.setY(r20);
        Window r113 = r2.getWindow();
        if (r113 == null) goto L32;
        WindowManager.LayoutParams r22 = r113.getAttributes();
        r22.x = (int) r19;
        r22.y = (int) r110;
        r113.setAttributes(r22);
        goto L32
    L23:
        r21 = 0.0f;
    L32:
        if (DialogLancet.shouldBlockDialogShow(r2) == false) goto L38;
        DialogLancet.handleBlockedDialogShow(r2);
        return;
    L38:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L37
    L35:
        DialogLancet.beforeDialogShow(r2);
        r2.show();
        DialogLancet.afterDialogShow(r2);
        return;
    L17:
        r15 = 2000;
        goto L18
    L7:
        if (TextUtils.isEmpty(r4) == true) goto L9;
        r2.l.setText(r13);
        goto L13
    }

    public final void b(Window r7, uk5.b r8, tk5.c r9) {
        b r3 = new b(this.c, this.a, r9, this.e);
        if (this.f == null) goto L38;
        FragmentActivity r10 = this.b;
        OnBoardingColorStyle r0 = this.d;
        yk5.c r1 = new yk5.c(r10, r7);
        r1.j = r3;
        r1.h = r8.a;
        Integer r11 = r8.d;
        String r12 = r8.b;
        String r2 = r8.c;
        String r4 = r8.e;
        if (TextUtils.isEmpty(r12) == false) goto L7;
    L9:
        r1.l.setVisibility(8);
        if (r12 != null) goto L14;
        if (r2 != null) goto L13;
        r12 = "";
    L13:
        r12 = r2;
    L14:
        r1.m.setText(r12);
        r1.m.getPaint().setFakeBoldText(true);
        r1.m.setVisibility(0);
        r1.d(r0);
        if (r11 != null) goto L17;
        tt5.a.d(yk5.c.t, "No ImageRes or AnimFile is set!!");
    L17:
        if (r11 == null) goto L19;
        r1.s.setImageResource(r11.intValue());
        r1.s.setVisibility(0);
    L21:
        if (TextUtils.isEmpty(r4) == true) goto L23;
        r1.n.setText(r4);
    L24:
        r1.n.setOnClickListener(new yk5.d(r1));
        r1.o.setOnClickListener(new yk5.e(r1));
        r1.a.setOnClickListener(f.a);
        if (r8.f == false) goto L30;
        if (r1.getWindow() == null) goto L30;
        r1.getWindow().setStatusBarColor(0);
    L30:
        if (DialogLancet.shouldBlockDialogShow(r1) == false) goto L36;
        DialogLancet.handleBlockedDialogShow(r1);
        return;
    L36:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L35
    L33:
        DialogLancet.beforeDialogShow(r1);
        r1.show();
        DialogLancet.afterDialogShow(r1);
        return;
    L23:
        r1.n.setText(r1.k.getText(2131887835));
        goto L24
    L19:
        r1.s.setImageResource(2131232549);
        r1.s.setVisibility(0);
        goto L21
    L7:
        if (TextUtils.isEmpty(r2) == true) goto L9;
        r1.l.setText(r12);
        goto L13
    }

    public final g c(Window r20, uk5.c r21, tk5.c r22) {
        b r5 = new b(this.c, this.a, r22, this.e);
        if (this.f == null) goto L57;
        FragmentActivity r2 = this.b;
        OnBoardingColorStyle r3 = this.d;
        g r4 = new g(r2, r20);
        r4.j = r5;
        r4.v = r21.k;
        r4.h = r21.a;
        String r6 = r21.b;
        String r7 = r21.c;
        Integer r8 = Integer.valueOf(r21.d);
        Integer r9 = Integer.valueOf(r21.e);
        boolean r10 = r21.h;
        View r11 = r21.f;
        RectF r12 = r21.g;
        FlowStyleHollowShape r13 = r21.i;
        int r14 = r21.j;
        String r15 = r21.l;
        String r16 = r21.m;
        boolean r17 = r21.n;
        boolean r0 = r21.o;
        r4.u = r17;
        r4.z = r0;
        boolean r18 = true;
        TextView[] r1 = {r4.l, r4.m, r4.q, r4.p};
        int r19 = 0;
    L6:
        if (r19 >= 4) goto L9;
        TextView r110 = r1[r19];
        r110.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
        r110.getPaint().setStrokeWidth(1.0f);
        r19 = r19 + 1;
        r1 = r1;
        goto L6
    L9:
        if (TextUtils.isEmpty(r6) == false) goto L11;
    L13:
        r4.l.setVisibility(8);
        ViewGroup.LayoutParams r23 = r4.m.getLayoutParams();
        Intrinsics.checkNotNull(r23, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r24 = (ViewGroup.MarginLayoutParams) r23;
        r24.topMargin = r4.getContext().getResources().getDimensionPixelOffset(2131166203);
        r4.m.setLayoutParams(r24);
        if (r6 != null) goto L18;
        if (r7 != null) goto L17;
        r6 = "";
    L17:
        r6 = r7;
    L18:
        r4.m.setText(r6);
        r4.m.setVisibility(0);
        boolean r25 = !r10;
        if (r8 == null) goto L30;
        if (r9 == null) goto L30;
        if (r8.intValue() <= 0) goto L30;
        if (r9.intValue() <= 0) goto L30;
        r4.r.setText(r8 + " / " + r9);
        r4.r.setVisibility(0);
        if (r8.intValue() < r9.intValue()) goto L29;
        r18 = false;
    L29:
        r25 = r18;
    L30:
        if (r25 == false) goto L32;
    L35:
        r4.p.setVisibility(0);
        if (TextUtils.isEmpty(r15) == false) goto L38;
        r4.p.setText(r4.k.getText(2131887834));
    L39:
        r4.p.setOnClickListener(new h(r4));
        r4.q.setText(r4.k.getText(2131887783));
    L41:
        if (TextUtils.isEmpty(r16) == true) goto L43;
        r4.q.setText(r16);
    L43:
        r4.q.setOnClickListener(new i(r4));
        if (r13 != FlowStyleHollowShape.None) goto L46;
        r4.s.setVisibility(8);
    L46:
        r4.d(r3);
        r4.o.measure(View.MeasureSpec.makeMeasureSpec(r4.k.getResources().getDimensionPixelSize(2131167889), 1073741824), View.MeasureSpec.makeMeasureSpec(1073741823, Integer.MIN_VALUE));
        r4.g(r11, r13, r12);
        r4.s.setOnClickListener(new j(r4, r0));
        r4.s.setOnTouchListener(new k(r4));
        r4.y = r14;
        if (r21.p == false) goto L52;
        if (r4.getWindow() == null) goto L52;
        r4.getWindow().setStatusBarColor(0);
    L52:
        if (DialogLancet.shouldBlockDialogShow(r4) == false) goto L60;
        DialogLancet.handleBlockedDialogShow(r4);
    L56:
        return r4;
    L60:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L59
    L55:
        DialogLancet.beforeDialogShow(r4);
        r4.show();
        DialogLancet.afterDialogShow(r4);
        goto L56
    L38:
        r4.p.setText(r15);
        goto L39
    L32:
        if (TextUtils.isEmpty(r15) == false) goto L35;
        r4.q.setText(r4.k.getText(2131887794));
        goto L41
    L11:
        if (TextUtils.isEmpty(r7) == true) goto L13;
        r4.l.setText(r6);
        goto L17
    L57:
        return null;
    }

    public final void d(Window r12, e r13, tk5.c r14) {
        b r3 = new b(this.c, this.a, r14, this.e);
        if (this.f == null) goto L40;
        FragmentActivity r15 = this.b;
        OnBoardingColorStyle r0 = this.d;
        n r1 = new n(r15, r12);
        r1.j = r3;
        r1.h = r13.a;
        String r16 = r13.b;
        String r17 = r13.c;
        View r2 = r13.d;
        int[] r4 = r13.e;
        RectF r5 = r13.f;
        Direction r6 = r13.g;
        Integer r7 = Integer.valueOf(r13.i);
        Boolean r8 = Boolean.valueOf(r13.k);
        Boolean r9 = Boolean.valueOf(r13.l);
        Boolean r10 = Boolean.TRUE;
        if (Intrinsics.areEqual(r8, r10) == false) goto L8;
        r1.l.setGravity(17);
        r1.m.setGravity(17);
    L8:
        if (Intrinsics.areEqual(r9, r10) == false) goto L11;
        r1.n.setVisibility(8);
    L11:
        if (TextUtils.isEmpty(r16) == false) goto L13;
    L15:
        r1.l.setVisibility(8);
        ViewGroup.LayoutParams r11 = r1.m.getLayoutParams();
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r18 = (ViewGroup.MarginLayoutParams) r11;
        r18.topMargin = r1.getContext().getResources().getDimensionPixelOffset(2131166203);
        r1.m.setLayoutParams(r18);
        if (r16 != null) goto L20;
        if (r17 != null) goto L19;
        r16 = "";
    L19:
        r16 = r17;
    L20:
        r1.m.setText(r16);
        r1.m.getPaint().setFakeBoldText(true);
        r1.m.setVisibility(0);
        r1.d(r0);
        int r19 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int r20 = View.MeasureSpec.makeMeasureSpec(0, 0);
        r1.o.measure(r19, r20);
        List<Float> r110 = new m(r1.k, r1.o.getMeasuredWidth(), r1.o.getMeasuredHeight(), Integer.valueOf(r1.p)).b(r2, r4, r5, r6);
        if (r110 == null) goto L23;
        r1.n.setX(((Number) ListProtector.get(r110, 0)).floatValue());
        r1.n.setY(((Number) ListProtector.get(r110, 1)).floatValue());
        r1.o.setX(((Number) ListProtector.get(r110, 2)).floatValue());
        r1.o.setY(((Number) ListProtector.get(r110, 3)).floatValue());
    L23:
        r1.a.setOnClickListener(new o(r1));
        if (r7 == null) goto L27;
        r1.q = r7.intValue();
    L27:
        if (r13.j == false) goto L32;
        if (r1.getWindow() == null) goto L32;
        r1.getWindow().setStatusBarColor(0);
    L32:
        if (DialogLancet.shouldBlockDialogShow(r1) == false) goto L38;
        DialogLancet.handleBlockedDialogShow(r1);
        return;
    L38:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L37
    L35:
        DialogLancet.beforeDialogShow(r1);
        r1.show();
        DialogLancet.afterDialogShow(r1);
        return;
    L13:
        if (TextUtils.isEmpty(r17) == true) goto L15;
        r1.l.setText(r16);
        goto L19
    }
}
