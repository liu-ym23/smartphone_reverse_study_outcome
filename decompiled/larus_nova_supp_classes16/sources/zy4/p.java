package zy4;

import android.graphics.RectF;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.document.onboarding.OnBoardingData;
import com.bytedance.ee.bear.onboarding.export.Direction;
import com.bytedance.ee.bear.onboarding.export.OnBoardingColorStyle;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class p extends com.bytedance.ee.bear.document.onboarding.b {
    public final String getBiz() {
        return "doc";
    }

    public final String getId() {
        return "mobile_doc_smartCompose_intro";
    }

    public p() {
    }

    @Override // com.bytedance.ee.bear.document.onboarding.b
    public final boolean c(com.bytedance.ee.bear.document.onboarding.c r12, OnBoardingData r13) {
        if (r13.position != null) goto L5;
        return false;
    L5:
        tt5.a.h("SmartComposeTapTimerMission", "DocBlockMenuMission " + r13.toString());
        tt5.a.h("SmartComposeTapTimerMission", "screen width " + com.bytedance.ee.util.ui.n.v() + " screen height " + com.bytedance.ee.util.ui.n.t());
        FragmentActivity r0 = r12.getActivity();
        String r3 = com.bytedance.ee.util.ui.n.x(r0, 2131887868);
        tt5.a.h("SmartComposeTapTimerMission", "heightP: " + (r13.position.height / ((float) com.bytedance.ee.util.ui.n.t())) + "; topP: " + (r13.position.y / ((float) com.bytedance.ee.util.ui.n.t())));
        RectF r2 = new RectF();
        OnBoardingData.Position r14 = r13.position;
        float r4 = r14.x;
        r2.left = r4;
        float r5 = r14.y;
        r2.top = r5;
        r2.right = r4 + r14.width;
        r2.bottom = r5 + r14.height;
        String r16 = com.bytedance.ee.util.ui.n.x(r0, 2131887869);
        Direction r6 = Direction.UP;
        Window r1 = r0.getWindow();
        vk5.b r8 = new vk5.b(((vk5.a) r12).c, ((vk5.a) r12).a, null, ((vk5.a) r12).e);
        if (((vk5.a) r12).f == null) goto L31;
        FragmentActivity r7 = ((vk5.a) r12).b;
        OnBoardingColorStyle r17 = ((vk5.a) r12).d;
        yk5.p r9 = new yk5.p(r7, r1);
        ((yk5.b) r9).j = r8;
        ((yk5.b) r9).h = null;
        Intrinsics.checkNotNullParameter("sc_tap.json", "lottieFileName");
        if (TextUtils.isEmpty(r3) == false) goto L10;
    L12:
        r9.l.setVisibility(8);
        ViewGroup.LayoutParams r10 = r9.m.getLayoutParams();
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r11 = (ViewGroup.MarginLayoutParams) r10;
        r11.topMargin = r9.getContext().getResources().getDimensionPixelOffset(2131166203);
        r9.m.setLayoutParams(r11);
        if (r3 != null) goto L17;
        if (r16 != null) goto L16;
        r3 = "";
    L16:
        r3 = r16;
    L17:
        r9.m.setText(r3);
        r9.m.getPaint().setFakeBoldText(true);
        r9.m.setVisibility(0);
        r9.d(r17);
        r9.p.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        List r18 = new yk5.m(r9.k, r9.p.getMeasuredWidth(), r9.p.getMeasuredHeight(), Integer.valueOf(r9.q)).b(null, null, r2, r6);
        if (r18 == null) goto L26;
        float r19 = ((Number) ListProtector.get(r18, 0)).floatValue();
        float r20 = ((Number) ListProtector.get(r18, 1)).floatValue();
        r9.s = ((Number) ListProtector.get(r18, 2)).floatValue();
        r9.r = ((Number) ListProtector.get(r18, 3)).floatValue();
        r9.n.setX(r19);
        View r110 = r9.n;
        if (r20 <= r9.r) goto L22;
        float r21 = 0.0f;
    L23:
        r110.setY(r21);
        r9.o.setX(r19 - cu5.c.b(24));
        Window r111 = r9.getWindow();
        if (r111 == null) goto L26;
        WindowManager.LayoutParams r112 = r111.getAttributes();
        r112.x = (int) r9.s;
        r112.y = (int) r9.r;
        r111.setAttributes(r112);
        goto L26
    L22:
        r21 = (r9.q / 2) - r9.p.getMeasuredHeight();
    L26:
        r9.o.setAnimation("sc_tap.json");
        if (DialogLancet.shouldBlockDialogShow(r9) == false) goto L33;
        DialogLancet.handleBlockedDialogShow(r9);
        goto L31
    L33:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L32
    L30:
        DialogLancet.beforeDialogShow(r9);
        r9.show();
        DialogLancet.afterDialogShow(r9);
        goto L31
    L10:
        if (TextUtils.isEmpty(r16) == true) goto L12;
        r9.l.setText(r3);
    L31:
        return true;
    }
}
