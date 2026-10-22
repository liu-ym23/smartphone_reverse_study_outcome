package c35;

import android.graphics.RectF;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.document.onboarding.OnBoardingData;
import com.bytedance.ee.bear.document.onboarding.c;
import com.bytedance.ee.bear.onboarding.export.Direction;
import com.bytedance.ee.bear.onboarding.export.ui.FlowStyleHollowShape;
import com.bytedance.ee.util.ui.n;
import kotlin.jvm.internal.Intrinsics;
import tb5.m;
import uk5.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a extends com.bytedance.ee.bear.document.onboarding.b {
    public final String c;
    public final m d;

    /* JADX INFO: renamed from: c35.a$a, reason: collision with other inner class name */
    public static final class C0011a {
    }

    static {
    }

    public final String getId() {
        return this.a.getAction();
    }

    public final String getBiz() {
        return this.c;
    }

    @Override // com.bytedance.ee.bear.document.onboarding.b
    public final boolean c(c r7, OnBoardingData r8) {
        Intrinsics.checkNotNullParameter(r7, "ui");
        Intrinsics.checkNotNullParameter(r8, "data");
        StringBuilder r0 = new StringBuilder("show, type is ");
        OnBoardingData.CustomData r1 = r8.customData;
        OnBoardingData.OnBoardingType r2 = null;
        if (r1 == null) goto L5;
        OnBoardingData.OnBoardingType r3 = r1.type;
    L6:
        r0.append(r3);
        r0.append(", id = ");
        r0.append(getId());
        tt5.a.h("CustomOnBoardingMission", r0.toString());
        OnBoardingData.CustomData r4 = r8.customData;     // Catch: Exception -> L30
        if (r4 == null) goto L10;
        OnBoardingData.OnBoardingType r5 = r4.type;     // Catch: Exception -> L30
    L12:
        if (r5 == OnBoardingData.OnBoardingType.TEXT) goto L14;
        if (r4 == null) goto L17;
        OnBoardingData.OnBoardingType r6 = r4.type;     // Catch: Exception -> L30
    L19:
        if (r6 == OnBoardingData.OnBoardingType.FLOW) goto L21;
        if (r4 == null) goto L25;
        r2 = r4.type;     // Catch: Exception -> L30
    L25:
        if (r2 == OnBoardingData.OnBoardingType.CARD) goto L27;
        tt5.a.h("CustomOnBoardingMission", "show is false");     // Catch: Exception -> L30
        return false;
    L27:
        return d(r7, r8);
    L21:
        return e(r7, r8);
    L17:
        r6 = null;
        goto L19
    L14:
        return f(r7, r8);
    L10:
        r5 = null;
    L30:
        e = move-exception;
        tt5.a.e("CustomOnBoardingMission", "show error", e, false);
        return false;
    L5:
        r3 = null;
        goto L6
    }

    public final boolean d(c r6, OnBoardingData r7) {
        OnBoardingData.CustomData r8 = r7.customData;
        if (r8 != null) goto L5;
        return false;
    L5:
        FragmentActivity r1 = r6.getActivity();
        if (r1 != null) goto L8;
        return false;
    L8:
        String r0 = r8.title;
        String r2 = "";
        if (r0 != null) goto L11;
        r0 = "";
    L11:
        String r3 = r8.body;
        if (r3 != null) goto L14;
        r3 = "";
    L14:
        String r4 = r8.confirmText;
        if (r4 == null) goto L18;
        r2 = r4;
    L18:
        uk5.b r5 = new uk5.b(r0, Integer.valueOf(n.n(r1, r8.imgRes)));
        r5.c = r3;
        r5.e = r2;
        r5.f = true;
        r6.b(r1.getWindow(), r5, new b(this, this.d));
        return true;
    }

    public final boolean e(c r9, OnBoardingData r10) {
        OnBoardingData.CustomData r11 = r10.customData;
        if (r11 != null) goto L5;
        return false;
    L5:
        String r1 = r11.onboardingViewTag;
        if (r1 != null) goto L8;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == false) goto L14;
        String r3 = r11.title;
        RectF r4 = new RectF();
        OnBoardingData.Position r5 = this.a.position;
        float r6 = r5.x;
        r4.left = r6;
        float r7 = r5.y;
        r4.top = r7;
        r4.right = r6 + r5.width;
        r4.bottom = r7 + r5.height;
        uk5.c r0 = new uk5.c(r3, true, r4);
    L21:
        r0.m = r11.confirmText;
        r0.i = FlowStyleHollowShape.None;
        r0.c = r11.body;
        r9.c(r9.getActivity().getWindow(), r0, new b(this, null));
        return true;
    L14:
        View r8 = r9.g.findMenuView(r11.onboardingViewTag);
        if (r8 != null) goto L20;
        r8 = r9.h.findViewWithTag(r11.onboardingViewTag);
        if (r8 != null) goto L20;
        tt5.a.k("CustomOnBoardingMission", "showFlow... view is null");
        return false;
    L20:
        r0 = new uk5.c(r11.title, r8);
        goto L21
    L8:
        if (r1.length() == 0) goto L11;
        r2 = false;
        goto L12
    }

    public final boolean f(c r9, OnBoardingData r10) {
        OnBoardingData.CustomData r11 = r10.customData;
        if (r11 != null) goto L5;
        return false;
    L5:
        String r1 = r11.onboardingViewTag;
        if (r1 != null) goto L8;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == false) goto L14;
        String r3 = r11.title;
        RectF r4 = new RectF();
        OnBoardingData.Position r5 = this.a.position;
        float r6 = r5.x;
        r4.left = r6;
        float r7 = r5.y;
        r4.top = r7;
        r4.right = r6 + r5.width;
        r4.bottom = r7 + r5.height;
        e r0 = new e(r3, r4);
    L21:
        r0.c = r11.body;
        r0.k = r11.makeTextCenter;
        r0.l = r11.hideArrow;
        OnBoardingData.Direction r12 = r11.suggestedDirection;
        if (r12 != OnBoardingData.Direction.DOWN) goto L25;
        Direction r13 = Direction.DOWN;
    L28:
        r0.g = r13;
        r9.d(r9.getActivity().getWindow(), r0, new b(this, null));
        return true;
    L25:
        if (r12 != OnBoardingData.Direction.UP) goto L27;
        r13 = Direction.UP;
        goto L28
    L27:
        r13 = Direction.NONE;
        goto L28
    L14:
        View r8 = r9.g.findMenuView(r11.onboardingViewTag);
        if (r8 != null) goto L20;
        r8 = r9.h.findViewWithTag(r11.onboardingViewTag);
        if (r8 != null) goto L20;
        tt5.a.k("CustomOnBoardingMission", "showText... view is null");
        return false;
    L20:
        r0 = new e(r11.title, r8);
        goto L21
    L8:
        if (r1.length() == 0) goto L11;
        r2 = false;
        goto L12
    }

    public a(OnBoardingData r2, String r3, m r4) {
        Intrinsics.checkNotNullParameter(r2, "data");
        Intrinsics.checkNotNullParameter(r3, "biz");
        super(r2);
        this.c = r3;
        this.d = r4;
    }
}
