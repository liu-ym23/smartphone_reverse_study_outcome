package com.bytedance.awemeopen.apps.framework.comment.write;

import android.R;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.bytedance.awemeopen.apps.framework.comment.api.statistics.CommentMobParameters;
import com.bytedance.awemeopen.apps.framework.comment.util.CommentKeyboardUtils;
import com.bytedance.awemeopen.apps.framework.comment.write.utils.KeyBoardHeightSp;
import com.bytedance.awemeopen.apps.framework.comment.write.utils.KeyboardUtils;
import com.bytedance.awemeopen.apps.framework.utils.n0;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class n implements d {
    public final com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b a;
    public int b;
    public boolean c;
    public ViewGroup d;
    public View e;
    public View f;
    public final com.bytedance.awemeopen.apps.framework.comment.write.refactor.s g;
    public View h;
    public int i;
    public int j;
    public com.bytedance.awemeopen.apps.framework.comment.write.utils.d k;
    public ValueAnimator l;
    public ViewGroup m;
    public g n;

    public static final class a {
    }

    public static final class b implements com.bytedance.awemeopen.apps.framework.comment.write.utils.d.a {
        public final /* synthetic */ n a;

        @Override // com.bytedance.awemeopen.apps.framework.comment.write.utils.d.a
        public final void onClosed() {
            com.bytedance.awemeopen.apps.framework.comment.write.refactor.s r0 = this.a.g;
            if (r0 == null) goto L6;
            List<KeyboardUtils.ClearCursorDecorator> r1 = KeyboardUtils.a;
            r0.A(false, ((SharedPreferences) KeyBoardHeightSp.a.getValue()).getInt("height", 800));
            return;
        }

        public b(n r1) {
            this.a = r1;
        }

        @Override // com.bytedance.awemeopen.apps.framework.comment.write.utils.d.a
        public final void onOpened(int r6) {
            com.bytedance.awemeopen.apps.framework.comment.write.refactor.s r0 = this.a.g;
            boolean r1 = true;
            if (r0 == null) goto L5;
            r0.A(true, r6);
        L5:
            int r2 = CommentKeyboardUtils.b(false, true);
            AoLogger.b("write_comment", new Object[]{"KeyboardFragment#onOpened: panelHeight=" + r2});
            ViewGroup r3 = this.a.m;
            if (r3 != null) goto L8;
        L10:
            r1 = false;
        L11:
            if (r1 == true) goto L23;
            ViewGroup r7 = this.a.m;
            if (r7 == null) goto L15;
            ViewGroup.LayoutParams r8 = r7.getLayoutParams();
        L16:
            if (r8 == null) goto L19;
            r8.height = r2;
        L19:
            ViewGroup r9 = this.a.m;
            if (r9 == null) goto L24;
            r9.requestLayout();
            return;
        L24:
            return;
        L15:
            r8 = null;
            goto L16
        L23:
            return;
        L8:
            if (r3.getHeight() != r2) goto L10;
            goto L10
        }
    }

    public static final class c implements ViewTreeObserver.OnPreDrawListener {
        public final /* synthetic */ ViewTreeObserver a;

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            if (this.a.isAlive() == false) goto L7;
            this.a.removeOnPreDrawListener(this);
            return true;
        L7:
            return true;
        }

        public c(ViewTreeObserver r1) {
            this.a = r1;
        }
    }

    static {
    }

    @Override // com.bytedance.awemeopen.apps.framework.comment.write.d
    public final void T0() {
        boolean r0 = true;
        AoLogger.b("write_comment", new Object[]{"Fragment#hideFragment"});
        com.bytedance.awemeopen.apps.framework.comment.write.utils.d r1 = this.k;
        if (r1 == null) goto L15;
        AoLogger.b("write_comment", new Object[]{"KeyboardPopupWindow: release"});
        r1.f = 0;
        r1.e = false;
        r1.h.removeMessages(r1.j);
        r1.b.removeCallbacks(r1.k);
        r1.getContentView().getViewTreeObserver().removeOnGlobalLayoutListener(r1);
        Context r3 = r1.a;
        if ((r3 instanceof Activity) == false) goto L7;
        Activity r4 = (Activity) r3;
    L8:
        if (r4 != null) goto L10;
    L12:
        r0 = false;
    L13:
        if (r0 == false) goto L15;
        PopupWindowLancet.handleDismissBeforeOrigin(r1);
        r1.dismiss();
        goto L15
    L10:
        if (r4.isFinishing() == true) goto L12;
    L7:
        r4 = null;
    L15:
        View r2 = this.e;
        if (r2 == null) goto L19;
        r2.post(new l(this));
        return;
    }

    public final void a() {
        AoLogger.b("write_comment", new Object[]{"#onCreate begin"});
        ViewTreeObserver r5 = null;
        this.e = View.inflate(this.a.getActivity(), 2131558598, null);
        this.d = (ViewGroup) this.a.getActivity().findViewById(R.id.content);
        com.bytedance.awemeopen.apps.framework.comment.write.refactor.s r1 = this.g;
        if (r1 == null) goto L5;
        View r4 = this.e;
        Intrinsics.checkNotNull(r4);
        Intrinsics.checkNotNullParameter(r4, "view");
        r1.g = r4;
    L5:
        com.bytedance.awemeopen.apps.framework.comment.write.refactor.s r2 = this.g;
        if (r2 == null) goto L17;
        g r6 = this.n;
        r2.q = r6;
        if (r2.k != null) goto L10;
        r2.C();
    L10:
        com.bytedance.awemeopen.apps.framework.comment.write.refactor.g r3 = r2.k;
        if (r3 == null) goto L17;
        if (r6 == null) goto L15;
        CommentMobParameters r7 = r6.c;
    L16:
        r3.k = r7;
        goto L17
    L15:
        r7 = null;
    L17:
        final com.bytedance.awemeopen.apps.framework.comment.write.refactor.s r8 = this.g;
        if (r8 == null) goto L45;
        Intrinsics.checkNotNullParameter((wy3.a) r8.c.getValue(), "cmtContext");
        com.bytedance.awemeopen.apps.framework.comment.write.refactor.g r9 = r8.k;
        if (r9 != null) goto L22;
        com.bytedance.awemeopen.apps.framework.comment.write.refactor.p r10 = null;
    L23:
        r8.b = r10;
        if (r10 == null) goto L26;
        View r11 = r8.g;
        Intrinsics.checkNotNull(r11);
        r10.d(r11);
    L26:
        AoLogger.b("write_comment", new Object[]{"onViewCreated"});
        View r12 = r8.g;
        Intrinsics.checkNotNull(r12);
        r8.g = r12;
        if (r12 == null) goto L29;
        LinearLayout r13 = (LinearLayout) r12.findViewById(2131381747);
    L29:
        View r14 = r8.g;
        if (r14 == null) goto L32;
        View r15 = r14.findViewById(2131381746);
    L33:
        r8.i = r15;
        View r16 = r8.g;
        if (r16 == null) goto L36;
        View r17 = r16.findViewById(2131381874);
    L37:
        r8.j = r17;
        View r18 = r8.i;
        if (r18 == null) goto L40;
        r18.setOnClickListener(new com.bytedance.awemeopen.apps.framework.comment.write.refactor.d(r8));
    L40:
        View r19 = r8.g;
        if (r19 == null) goto L43;
        ViewGroup r20 = (ViewGroup) r19.findViewById(2131380142);
    L44:
        r8.r = r20;
        r8.r();
        r8.B();
        goto L45
    L43:
        r20 = null;
        goto L44
    L36:
        r17 = null;
        goto L37
    L32:
        r15 = null;
        goto L33
    L22:
        Intrinsics.checkNotNull(r9);
        r10 = new com.bytedance.awemeopen.apps.framework.comment.write.refactor.p(r9);
    L45:
        View r21 = this.e;
        if (r21 == null) goto L48;
        ViewGroup r22 = (ViewGroup) r21.findViewById(2131381874);
    L49:
        this.m = r22;
        View r23 = this.e;
        if (r23 == null) goto L52;
        View r24 = r23.findViewById(2131377472);
    L53:
        this.h = r24;
        this.i = this.a.getActivity().getResources().getColor(2131100345);
        this.j = this.a.getActivity().getResources().getColor(2131100326);
        View r25 = this.e;
        if (r25 == null) goto L122;
        Intrinsics.checkNotNull(r25);
        boolean r26 = n0.c(r25.getContext());
        View r27 = this.e;
        if (r27 == null) goto L59;
        EditText r28 = (EditText) r27.findViewById(2131367335);
    L61:
        if (r26 == false) goto L92;
        int r29 = this.a.getActivity().getResources().getColor(2131100248);
        View r110 = this.e;
        if (r110 == null) goto L67;
        View r111 = r110.findViewById(2131377522);
        if (r111 == null) goto L67;
        r111.setBackgroundColor(r29);
    L67:
        View r112 = this.e;
        if (r112 == null) goto L72;
        View r30 = r112.findViewById(2131367728);
        if (r30 == null) goto L72;
        r30.setBackgroundColor(r29);
    L72:
        View r31 = this.e;
        if (r31 == null) goto L77;
        View r32 = r31.findViewById(2131381874);
        if (r32 == null) goto L77;
        r32.setBackgroundColor(r29);
    L77:
        View r33 = this.e;
        if (r33 == null) goto L82;
        View r34 = r33.findViewById(2131371539);
        if (r34 == null) goto L82;
        r34.setBackgroundColor(r29);
    L82:
        View r35 = this.e;
        if (r35 == null) goto L87;
        View r36 = r35.findViewById(2131367330);
        if (r36 == null) goto L87;
        r36.setBackgroundResource(2131231371);
    L87:
        int r37 = this.a.getActivity().getResources().getColor(2131100362);
        int r38 = this.a.getActivity().getResources().getColor(2131100254);
        if (r28 == null) goto L90;
        r28.setTextColor(r37);
    L90:
        if (r28 == null) goto L122;
        r28.setHintTextColor(r38);
        goto L122
    L92:
        int r39 = this.a.getActivity().getResources().getColor(2131100249);
        View r113 = this.e;
        if (r113 == null) goto L97;
        View r114 = r113.findViewById(2131377522);
        if (r114 == null) goto L97;
        r114.setBackgroundColor(r39);
    L97:
        View r115 = this.e;
        if (r115 == null) goto L102;
        View r40 = r115.findViewById(2131367728);
        if (r40 == null) goto L102;
        r40.setBackgroundColor(r39);
    L102:
        View r41 = this.e;
        if (r41 == null) goto L107;
        View r42 = r41.findViewById(2131381874);
        if (r42 == null) goto L107;
        r42.setBackgroundColor(r39);
    L107:
        View r43 = this.e;
        if (r43 == null) goto L112;
        View r44 = r43.findViewById(2131371539);
        if (r44 == null) goto L112;
        r44.setBackgroundColor(r39);
    L112:
        View r45 = this.e;
        if (r45 == null) goto L117;
        View r46 = r45.findViewById(2131367330);
        if (r46 == null) goto L117;
        r46.setBackgroundResource(2131231372);
    L117:
        int r47 = this.a.getActivity().getResources().getColor(2131100036);
        int r48 = this.a.getActivity().getResources().getColor(2131100255);
        if (r28 == null) goto L120;
        r28.setTextColor(r47);
    L120:
        if (r28 == null) goto L122;
        r28.setHintTextColor(r48);
        goto L122
    L59:
        r28 = null;
    L122:
        Activity r49 = this.a.getActivity();
        View r50 = this.e;
        Intrinsics.checkNotNull(r50);
        com.bytedance.awemeopen.apps.framework.comment.write.utils.d r51 = new com.bytedance.awemeopen.apps.framework.comment.write.utils.d(r49, r50);
        this.k = r51;
        r51.i = new b(this);
        r51.getContentView().getViewTreeObserver().addOnGlobalLayoutListener(r51);
        r51.b.post(r51.k);
        View r52 = this.e;
        if (r52 == null) goto L125;
        r5 = r52.getViewTreeObserver();
    L125:
        if (r5 == null) goto L127;
        r5.addOnPreDrawListener(new c(r5));
    L127:
        this.f = new View(this.a.getActivity());
        ViewGroup.LayoutParams r53 = new ViewGroup.LayoutParams(-1, -1);
        View r54 = this.f;
        if (r54 == null) goto L131;
        r54.setLayoutParams(r53);
    L131:
        View r55 = this.f;
        if (r55 == null) goto L134;
        r55.setBackgroundColor(this.i);
    L134:
        AoLogger.b("write_comment", new Object[]{"#onCreate finish"});
        return;
    L52:
        r24 = null;
        goto L53
    L48:
        r22 = null;
        goto L49
    }

    @Override // com.bytedance.awemeopen.apps.framework.comment.write.d
    public final com.bytedance.awemeopen.apps.framework.comment.write.refactor.s getPanel() {
        com.bytedance.awemeopen.apps.framework.comment.write.refactor.s r0 = this.g;
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    @Override // com.bytedance.awemeopen.apps.framework.comment.write.d
    public final boolean isShowing() {
        if (this.b == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public n(com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b r3) {
        Intrinsics.checkNotNullParameter(r3, "pageOwner");
        this.a = r3;
        this.b = -1;
        this.g = new com.bytedance.awemeopen.apps.framework.comment.write.refactor.s(r3.getActivity(), this, this.a);
    }

    @Override // com.bytedance.awemeopen.apps.framework.comment.write.d
    public final void U0(String r4) {
        Intrinsics.checkNotNullParameter(r4, "tag");
        boolean r1 = false;
        AoLogger.b("write_comment", new Object[]{"#showDialog:"});
        if (this.a.getActivity().isFinishing() == false) goto L5;
        return;
    L5:
        com.bytedance.awemeopen.apps.framework.comment.write.utils.d r0 = this.k;
        if (r0 == null) goto L8;
        r0.getContentView().getViewTreeObserver().addOnGlobalLayoutListener(r0);
        r0.b.post(r0.k);
    L8:
        ViewGroup r2 = this.d;
        if (r2 == null) goto L16;
        View r3 = this.e;
        Intrinsics.checkNotNull(r3);
        if (r2.indexOfChild(r3) == (-1)) goto L13;
        boolean r5 = true;
    L14:
        if (r5 == true) goto L16;
        r1 = true;
        goto L16
    L13:
        r5 = false;
    L16:
        if (r1 == false) goto L27;
        View r6 = this.e;
        if (r6 == null) goto L20;
        x54.b.b(r6);
    L20:
        ViewGroup r7 = this.d;
        if (r7 == null) goto L23;
        r7.addView(this.f);
    L23:
        ViewGroup r8 = this.d;
        if (r8 == null) goto L27;
        r8.addView(this.e);
    L27:
        if (this.b == 1) goto L32;
        View r9 = this.e;
        if (r9 == null) goto L33;
        r9.post(new k(this));
        return;
    L33:
        return;
    }

    public final void b(boolean r5) {
        ValueAnimator r0 = this.l;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        View r1 = this.f;
        if (r1 == null) goto L11;
        if (r5 == false) goto L9;
        int r2 = this.i;
    L10:
        r1.setBackgroundColor(r2);
        goto L11
    L9:
        r2 = this.j;
    L11:
        ArgbEvaluator r3 = new ArgbEvaluator();
        Object[] r4 = new Object[2];
        if (r5 == false) goto L14;
        int r6 = this.i;
    L15:
        r4[0] = Integer.valueOf(r6);
        if (r5 == false) goto L18;
        int r7 = this.j;
    L19:
        r4[1] = Integer.valueOf(r7);
        ValueAnimator r8 = ValueAnimator.ofObject(r3, r4);
        this.l = r8;
        if (r8 == null) goto L26;
        if (r5 == false) goto L24;
        long r9 = 200;
    L25:
        r8.setDuration(r9);
        goto L26
    L24:
        r9 = 300;
    L26:
        ValueAnimator r10 = this.l;
        if (r10 == null) goto L29;
        r10.addUpdateListener(new m(this));
    L29:
        ValueAnimator r11 = this.l;
        if (r11 == null) goto L33;
        r11.start();
        return;
    L33:
        return;
    L18:
        r7 = this.i;
        goto L19
    L14:
        r6 = this.j;
        goto L15
    }
}
