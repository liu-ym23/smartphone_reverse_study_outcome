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
import com.larus.nova.R;
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

/* JADX INFO: loaded from: classes18.dex */
public class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final tk5.b f555502a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FragmentActivity f555503b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d<? extends c> f555504c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public OnBoardingColorStyle f555505d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public sk5.d.a f555506e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public sk5.d f555507f;

    public boolean a() {
        return true;
    }

    public FragmentActivity getActivity() {
        return this.f555503b;
    }

    public a(FragmentActivity r100, tk5.b r101) {
        this.f555502a = r101;
        this.f555503b = r100;
    }

    public final void e(Window r110, e r111) {
        b r100 = new b(this.f555504c, this.f555502a, null, this.f555506e);
        if (this.f555507f == null) goto L40;
        FragmentActivity r101 = this.f555503b;
        OnBoardingColorStyle r102 = this.f555505d;
        q r103 = new q(r101, r110);
        r103.f568137j = r100;
        r103.f568135h = r111.f550495a;
        String r112 = r111.f550516b;
        String r104 = r111.f550517c;
        View r105 = r111.f550518d;
        int[] r106 = r111.f550519e;
        RectF r107 = r111.f550520f;
        Direction r108 = r111.f550521g;
        Integer r113 = Integer.valueOf(r111.f550522h);
        if (TextUtils.isEmpty(r112) == false) goto L7;
    L9:
        r103.f568211l.setVisibility(8);
        ViewGroup.LayoutParams r109 = r103.f568212m.getLayoutParams();
        Intrinsics.checkNotNull(r109, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r114 = (ViewGroup.MarginLayoutParams) r109;
        r114.topMargin = r103.getContext().getResources().getDimensionPixelOffset(R.dimen.dp_4);
        r103.f568212m.setLayoutParams(r114);
        if (r112 != null) goto L14;
        if (r104 != null) goto L13;
        r112 = "";
    L13:
        r112 = r104;
    L14:
        r103.f568212m.setText(r112);
        r103.f568212m.getPaint().setFakeBoldText(true);
        r103.f568212m.setVisibility(0);
        r103.d(r102);
        r103.f568214o.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        if (r113 == null) goto L17;
        int r115 = r113.intValue();
    L18:
        r103.f568216q = r115;
        List<Float> r116 = new m(r103.f568210k, r103.f568214o.getMeasuredWidth(), r103.f568214o.getMeasuredHeight(), Integer.valueOf(r103.f568217r)).b(r105, r106, r107, r108);
        if (r116 == null) goto L32;
        float r117 = ((Number) ListProtector.get(r116, 0)).floatValue();
        float r118 = ((Number) ListProtector.get(r116, 1)).floatValue();
        float r119 = ((Number) ListProtector.get(r116, 2)).floatValue();
        float r120 = ((Number) ListProtector.get(r116, 3)).floatValue();
        r103.f568213n.setX(r117 - r119);
        View r121 = r103.f568213n;
        float r122 = 0.0f;
        if (r118 <= r120) goto L23;
        float r123 = r103.f568214o.getMeasuredHeight() - (r103.f568217r / 2);
    L24:
        r121.setY(r123);
        r103.f568214o.setX(0.0f);
        View r124 = r103.f568214o;
        if (r118 > r120) goto L28;
        r122 = r103.f568217r / 2;
    L28:
        r124.setY(r122);
        Window r125 = r103.getWindow();
        if (r125 == null) goto L32;
        WindowManager.LayoutParams r126 = r125.getAttributes();
        r126.x = (int) r119;
        r126.y = (int) r120;
        r125.setAttributes(r126);
        goto L32
    L23:
        r123 = 0.0f;
    L32:
        if (DialogLancet.shouldBlockDialogShow(r103) == false) goto L38;
        DialogLancet.handleBlockedDialogShow(r103);
        return;
    L38:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L37
    L35:
        DialogLancet.beforeDialogShow(r103);
        r103.show();
        DialogLancet.afterDialogShow(r103);
        return;
    L17:
        r115 = 2000;
        goto L18
    L7:
        if (TextUtils.isEmpty(r104) == true) goto L9;
        r103.f568211l.setText(r112);
        goto L13
    }

    public final void b(Window r100, uk5.b r101, tk5.c r102) {
        b r103 = new b(this.f555504c, this.f555502a, r102, this.f555506e);
        if (this.f555507f == null) goto L38;
        FragmentActivity r104 = this.f555503b;
        OnBoardingColorStyle r105 = this.f555505d;
        yk5.c r106 = new yk5.c(r104, r100);
        r106.f568137j = r103;
        r106.f568135h = r101.f550495a;
        Integer r107 = r101.f550498d;
        String r108 = r101.f550496b;
        String r109 = r101.f550497c;
        String r110 = r101.f550499e;
        if (TextUtils.isEmpty(r108) == false) goto L7;
    L9:
        r106.f568143l.setVisibility(8);
        if (r108 != null) goto L14;
        if (r109 != null) goto L13;
        r108 = "";
    L13:
        r108 = r109;
    L14:
        r106.f568144m.setText(r108);
        r106.f568144m.getPaint().setFakeBoldText(true);
        r106.f568144m.setVisibility(0);
        r106.d(r105);
        if (r107 != null) goto L17;
        tt5.a.d(yk5.c.f568141t, "No ImageRes or AnimFile is set!!");
    L17:
        if (r107 == null) goto L19;
        r106.f568150s.setImageResource(r107.intValue());
        r106.f568150s.setVisibility(0);
    L21:
        if (TextUtils.isEmpty(r110) == true) goto L23;
        r106.f568145n.setText(r110);
    L24:
        r106.f568145n.setOnClickListener(new yk5.d(r106));
        r106.f568146o.setOnClickListener(new yk5.e(r106));
        r106.f568128a.setOnClickListener(f.f568153a);
        if (r101.f550500f == false) goto L30;
        if (r106.getWindow() == null) goto L30;
        r106.getWindow().setStatusBarColor(0);
    L30:
        if (DialogLancet.shouldBlockDialogShow(r106) == false) goto L36;
        DialogLancet.handleBlockedDialogShow(r106);
        return;
    L36:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L35
    L33:
        DialogLancet.beforeDialogShow(r106);
        r106.show();
        DialogLancet.afterDialogShow(r106);
        return;
    L23:
        r106.f568145n.setText(r106.f568142k.getText(R.string.Doc_Facade_StartTour));
        goto L24
    L19:
        r106.f568150s.setImageResource(R.drawable.ccm_empty_neutral_no_content);
        r106.f568150s.setVisibility(0);
        goto L21
    L7:
        if (TextUtils.isEmpty(r109) == true) goto L9;
        r106.f568143l.setText(r108);
        goto L13
    }

    public final g c(Window r210, uk5.c r211, tk5.c r212) {
        b r100 = new b(this.f555504c, this.f555502a, r212, this.f555506e);
        if (this.f555507f == null) goto L57;
        FragmentActivity r101 = this.f555503b;
        OnBoardingColorStyle r102 = this.f555505d;
        g r103 = new g(r101, r210);
        r103.f568137j = r100;
        r103.f568165v = r211.f550510k;
        r103.f568135h = r211.f550495a;
        String r104 = r211.f550501b;
        String r105 = r211.f550502c;
        Integer r106 = Integer.valueOf(r211.f550503d);
        Integer r107 = Integer.valueOf(r211.f550504e);
        boolean r108 = r211.f550507h;
        View r109 = r211.f550505f;
        RectF r110 = r211.f550506g;
        FlowStyleHollowShape r111 = r211.f550508i;
        int r112 = r211.f550509j;
        String r113 = r211.f550511l;
        String r114 = r211.f550512m;
        boolean r115 = r211.f550513n;
        boolean r116 = r211.f550514o;
        r103.f568164u = r115;
        r103.f568169z = r116;
        boolean r117 = true;
        TextView[] r118 = {r103.f568155l, r103.f568156m, r103.f568160q, r103.f568159p};
        int r119 = 0;
    L6:
        if (r119 >= 4) goto L9;
        TextView r120 = r118[r119];
        r120.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
        r120.getPaint().setStrokeWidth(1.0f);
        r119 = r119 + 1;
        r118 = r118;
        goto L6
    L9:
        if (TextUtils.isEmpty(r104) == false) goto L11;
    L13:
        r103.f568155l.setVisibility(8);
        ViewGroup.LayoutParams r121 = r103.f568156m.getLayoutParams();
        Intrinsics.checkNotNull(r121, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r122 = (ViewGroup.MarginLayoutParams) r121;
        r122.topMargin = r103.getContext().getResources().getDimensionPixelOffset(R.dimen.dp_4);
        r103.f568156m.setLayoutParams(r122);
        if (r104 != null) goto L18;
        if (r105 != null) goto L17;
        r104 = "";
    L17:
        r104 = r105;
    L18:
        r103.f568156m.setText(r104);
        r103.f568156m.setVisibility(0);
        boolean r123 = !r108;
        if (r106 == null) goto L30;
        if (r107 == null) goto L30;
        if (r106.intValue() <= 0) goto L30;
        if (r107.intValue() <= 0) goto L30;
        r103.f568161r.setText(r106 + " / " + r107);
        r103.f568161r.setVisibility(0);
        if (r106.intValue() < r107.intValue()) goto L29;
        r117 = false;
    L29:
        r123 = r117;
    L30:
        if (r123 == false) goto L32;
    L35:
        r103.f568159p.setVisibility(0);
        if (TextUtils.isEmpty(r113) == false) goto L38;
        r103.f568159p.setText(r103.f568154k.getText(R.string.Doc_Facade_Skip));
    L39:
        r103.f568159p.setOnClickListener(new h(r103));
        r103.f568160q.setText(r103.f568154k.getText(R.string.Doc_Facade_Next));
    L41:
        if (TextUtils.isEmpty(r114) == true) goto L43;
        r103.f568160q.setText(r114);
    L43:
        r103.f568160q.setOnClickListener(new i(r103));
        if (r111 != FlowStyleHollowShape.None) goto L46;
        r103.f568162s.setVisibility(8);
    L46:
        r103.d(r102);
        r103.f568158o.measure(View.MeasureSpec.makeMeasureSpec(r103.f568154k.getResources().getDimensionPixelSize(R.dimen.onBoarding_tips_width), 1073741824), View.MeasureSpec.makeMeasureSpec(1073741823, Integer.MIN_VALUE));
        r103.g(r109, r111, r110);
        r103.f568162s.setOnClickListener(new j(r103, r116));
        r103.f568162s.setOnTouchListener(new k(r103));
        r103.f568168y = r112;
        if (r211.f550515p == false) goto L52;
        if (r103.getWindow() == null) goto L52;
        r103.getWindow().setStatusBarColor(0);
    L52:
        if (DialogLancet.shouldBlockDialogShow(r103) == false) goto L60;
        DialogLancet.handleBlockedDialogShow(r103);
    L56:
        return r103;
    L60:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L59
    L55:
        DialogLancet.beforeDialogShow(r103);
        r103.show();
        DialogLancet.afterDialogShow(r103);
        goto L56
    L38:
        r103.f568159p.setText(r113);
        goto L39
    L32:
        if (TextUtils.isEmpty(r113) == false) goto L35;
        r103.f568160q.setText(r103.f568154k.getText(R.string.Doc_Facade_OfflineKnow));
        goto L41
    L11:
        if (TextUtils.isEmpty(r105) == true) goto L13;
        r103.f568155l.setText(r104);
        goto L17
    L57:
        return null;
    }

    public final void d(Window r110, e r111, tk5.c r112) {
        b r100 = new b(this.f555504c, this.f555502a, r112, this.f555506e);
        if (this.f555507f == null) goto L40;
        FragmentActivity r113 = this.f555503b;
        OnBoardingColorStyle r101 = this.f555505d;
        n r102 = new n(r113, r110);
        r102.f568137j = r100;
        r102.f568135h = r111.f550495a;
        String r114 = r111.f550516b;
        String r115 = r111.f550517c;
        View r103 = r111.f550518d;
        int[] r104 = r111.f550519e;
        RectF r105 = r111.f550520f;
        Direction r106 = r111.f550521g;
        Integer r107 = Integer.valueOf(r111.f550523i);
        Boolean r108 = Boolean.valueOf(r111.f550525k);
        Boolean r109 = Boolean.valueOf(r111.f550526l);
        Boolean r116 = Boolean.TRUE;
        if (Intrinsics.areEqual(r108, r116) == false) goto L8;
        r102.f568185l.setGravity(17);
        r102.f568186m.setGravity(17);
    L8:
        if (Intrinsics.areEqual(r109, r116) == false) goto L11;
        r102.f568187n.setVisibility(8);
    L11:
        if (TextUtils.isEmpty(r114) == false) goto L13;
    L15:
        r102.f568185l.setVisibility(8);
        ViewGroup.LayoutParams r117 = r102.f568186m.getLayoutParams();
        Intrinsics.checkNotNull(r117, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r118 = (ViewGroup.MarginLayoutParams) r117;
        r118.topMargin = r102.getContext().getResources().getDimensionPixelOffset(R.dimen.dp_4);
        r102.f568186m.setLayoutParams(r118);
        if (r114 != null) goto L20;
        if (r115 != null) goto L19;
        r114 = "";
    L19:
        r114 = r115;
    L20:
        r102.f568186m.setText(r114);
        r102.f568186m.getPaint().setFakeBoldText(true);
        r102.f568186m.setVisibility(0);
        r102.d(r101);
        int r119 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int r120 = View.MeasureSpec.makeMeasureSpec(0, 0);
        r102.f568188o.measure(r119, r120);
        List<Float> r121 = new m(r102.f568184k, r102.f568188o.getMeasuredWidth(), r102.f568188o.getMeasuredHeight(), Integer.valueOf(r102.f568189p)).b(r103, r104, r105, r106);
        if (r121 == null) goto L23;
        r102.f568187n.setX(((Number) ListProtector.get(r121, 0)).floatValue());
        r102.f568187n.setY(((Number) ListProtector.get(r121, 1)).floatValue());
        r102.f568188o.setX(((Number) ListProtector.get(r121, 2)).floatValue());
        r102.f568188o.setY(((Number) ListProtector.get(r121, 3)).floatValue());
    L23:
        r102.f568128a.setOnClickListener(new o(r102));
        if (r107 == null) goto L27;
        r102.f568190q = r107.intValue();
    L27:
        if (r111.f550524j == false) goto L32;
        if (r102.getWindow() == null) goto L32;
        r102.getWindow().setStatusBarColor(0);
    L32:
        if (DialogLancet.shouldBlockDialogShow(r102) == false) goto L38;
        DialogLancet.handleBlockedDialogShow(r102);
        return;
    L38:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L37
    L35:
        DialogLancet.beforeDialogShow(r102);
        r102.show();
        DialogLancet.afterDialogShow(r102);
        return;
    L13:
        if (TextUtils.isEmpty(r115) == true) goto L15;
        r102.f568185l.setText(r114);
        goto L19
    }
}
