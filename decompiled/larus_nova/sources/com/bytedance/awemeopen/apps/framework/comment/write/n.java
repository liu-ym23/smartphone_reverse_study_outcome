package com.bytedance.awemeopen.apps.framework.comment.write;

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
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class n implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b f194469a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f194470b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f194471c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ViewGroup f194472d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f194473e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f194474f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.bytedance.awemeopen.apps.framework.comment.write.refactor.s f194475g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f194476h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f194477i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f194478j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public com.bytedance.awemeopen.apps.framework.comment.write.utils.d f194479k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ValueAnimator f194480l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ViewGroup f194481m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public g f194482n;

    public static final class a {
    }

    public static final class b implements com.bytedance.awemeopen.apps.framework.comment.write.utils.d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n f194483a;

        @Override // com.bytedance.awemeopen.apps.framework.comment.write.utils.d.a
        public final void onClosed() {
            com.bytedance.awemeopen.apps.framework.comment.write.refactor.s r100 = this.f194483a.f194475g;
            if (r100 == null) goto L6;
            List<KeyboardUtils.ClearCursorDecorator> r101 = KeyboardUtils.f194574a;
            r100.A(false, ((SharedPreferences) KeyBoardHeightSp.f194573a.getValue()).getInt("height", 800));
            return;
        }

        public b(n r100) {
            this.f194483a = r100;
        }

        @Override // com.bytedance.awemeopen.apps.framework.comment.write.utils.d.a
        public final void onOpened(int r100) {
            com.bytedance.awemeopen.apps.framework.comment.write.refactor.s r101 = this.f194483a.f194475g;
            boolean r102 = true;
            if (r101 == null) goto L5;
            r101.A(true, r100);
        L5:
            int r103 = CommentKeyboardUtils.b(false, true);
            AoLogger.b("write_comment", new Object[]{"KeyboardFragment#onOpened: panelHeight=" + r103});
            ViewGroup r104 = this.f194483a.f194481m;
            if (r104 != null) goto L8;
        L10:
            r102 = false;
        L11:
            if (r102 == true) goto L23;
            ViewGroup r105 = this.f194483a.f194481m;
            if (r105 == null) goto L15;
            ViewGroup.LayoutParams r106 = r105.getLayoutParams();
        L16:
            if (r106 == null) goto L19;
            r106.height = r103;
        L19:
            ViewGroup r107 = this.f194483a.f194481m;
            if (r107 == null) goto L24;
            r107.requestLayout();
            return;
        L24:
            return;
        L15:
            r106 = null;
            goto L16
        L23:
            return;
        L8:
            if (r104.getHeight() != r103) goto L10;
            goto L10
        }
    }

    public static final class c implements ViewTreeObserver.OnPreDrawListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewTreeObserver f194484a;

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            if (this.f194484a.isAlive() == false) goto L7;
            this.f194484a.removeOnPreDrawListener(this);
            return true;
        L7:
            return true;
        }

        public c(ViewTreeObserver r100) {
            this.f194484a = r100;
        }
    }

    static {
    }

    @Override // com.bytedance.awemeopen.apps.framework.comment.write.d
    public final void T0() {
        boolean r100 = true;
        AoLogger.b("write_comment", new Object[]{"Fragment#hideFragment"});
        com.bytedance.awemeopen.apps.framework.comment.write.utils.d r101 = this.f194479k;
        if (r101 == null) goto L15;
        AoLogger.b("write_comment", new Object[]{"KeyboardPopupWindow: release"});
        r101.f194586f = 0;
        r101.f194585e = false;
        r101.f194588h.removeMessages(r101.f194590j);
        r101.f194582b.removeCallbacks(r101.f194591k);
        r101.getContentView().getViewTreeObserver().removeOnGlobalLayoutListener(r101);
        Context r102 = r101.f194581a;
        if ((r102 instanceof Activity) == false) goto L7;
        Activity r103 = (Activity) r102;
    L8:
        if (r103 != null) goto L10;
    L12:
        r100 = false;
    L13:
        if (r100 == false) goto L15;
        PopupWindowLancet.handleDismissBeforeOrigin(r101);
        r101.dismiss();
        goto L15
    L10:
        if (r103.isFinishing() == true) goto L12;
    L7:
        r103 = null;
    L15:
        View r104 = this.f194473e;
        if (r104 == null) goto L19;
        r104.post(new l(this));
        return;
    }

    public final void a() {
        AoLogger.b("write_comment", new Object[]{"#onCreate begin"});
        ViewTreeObserver r100 = null;
        this.f194473e = View.inflate(this.f194469a.getActivity(), R.layout.aos_comment_keyboard_portrait_view, null);
        this.f194472d = (ViewGroup) this.f194469a.getActivity().findViewById(android.R.id.content);
        com.bytedance.awemeopen.apps.framework.comment.write.refactor.s r101 = this.f194475g;
        if (r101 == null) goto L5;
        View r102 = this.f194473e;
        Intrinsics.checkNotNull(r102);
        Intrinsics.checkNotNullParameter(r102, "view");
        r101.f194496g = r102;
    L5:
        com.bytedance.awemeopen.apps.framework.comment.write.refactor.s r103 = this.f194475g;
        if (r103 == null) goto L17;
        g r104 = this.f194482n;
        r103.f194506q = r104;
        if (r103.f194500k != null) goto L10;
        r103.C();
    L10:
        com.bytedance.awemeopen.apps.framework.comment.write.refactor.g r105 = r103.f194500k;
        if (r105 == null) goto L17;
        if (r104 == null) goto L15;
        CommentMobParameters r106 = r104.f194461c;
    L16:
        r105.f194543k = r106;
        goto L17
    L15:
        r106 = null;
    L17:
        final com.bytedance.awemeopen.apps.framework.comment.write.refactor.s r107 = this.f194475g;
        if (r107 == null) goto L45;
        Intrinsics.checkNotNullParameter((wy3.a) r107.f194393c.getValue(), "cmtContext");
        com.bytedance.awemeopen.apps.framework.comment.write.refactor.g r108 = r107.f194500k;
        if (r108 != null) goto L22;
        com.bytedance.awemeopen.apps.framework.comment.write.refactor.p r109 = null;
    L23:
        r107.f194392b = r109;
        if (r109 == null) goto L26;
        View r110 = r107.f194496g;
        Intrinsics.checkNotNull(r110);
        r109.d(r110);
    L26:
        AoLogger.b("write_comment", new Object[]{"onViewCreated"});
        View r111 = r107.f194496g;
        Intrinsics.checkNotNull(r111);
        r107.f194496g = r111;
        if (r111 == null) goto L29;
        LinearLayout r112 = (LinearLayout) r111.findViewById(R.id.out_wrapper);
    L29:
        View r113 = r107.f194496g;
        if (r113 == null) goto L32;
        View r114 = r113.findViewById(R.id.out_view);
    L33:
        r107.f194498i = r114;
        View r115 = r107.f194496g;
        if (r115 == null) goto L36;
        View r116 = r115.findViewById(R.id.panel_holder);
    L37:
        r107.f194499j = r116;
        View r117 = r107.f194498i;
        if (r117 == null) goto L40;
        r117.setOnClickListener(new com.bytedance.awemeopen.apps.framework.comment.write.refactor.d(r107));
    L40:
        View r118 = r107.f194496g;
        if (r118 == null) goto L43;
        ViewGroup r119 = (ViewGroup) r118.findViewById(R.id.mini_emoji_panel_container);
    L44:
        r107.f194566r = r119;
        r107.r();
        r107.B();
        goto L45
    L43:
        r119 = null;
        goto L44
    L36:
        r116 = null;
        goto L37
    L32:
        r114 = null;
        goto L33
    L22:
        Intrinsics.checkNotNull(r108);
        r109 = new com.bytedance.awemeopen.apps.framework.comment.write.refactor.p(r108);
    L45:
        View r120 = this.f194473e;
        if (r120 == null) goto L48;
        ViewGroup r121 = (ViewGroup) r120.findViewById(R.id.panel_holder);
    L49:
        this.f194481m = r121;
        View r122 = this.f194473e;
        if (r122 == null) goto L52;
        View r123 = r122.findViewById(R.id.layout_content);
    L53:
        this.f194476h = r123;
        this.f194477i = this.f194469a.getActivity().getResources().getColor(R.color.aos_transparent);
        this.f194478j = this.f194469a.getActivity().getResources().getColor(R.color.aos_sd_tertiary);
        View r124 = this.f194473e;
        if (r124 == null) goto L122;
        Intrinsics.checkNotNull(r124);
        boolean r125 = n0.c(r124.getContext());
        View r126 = this.f194473e;
        if (r126 == null) goto L59;
        EditText r127 = (EditText) r126.findViewById(R.id.comment_edit);
    L61:
        if (r125 == false) goto L92;
        int r128 = this.f194469a.getActivity().getResources().getColor(R.color.aos_comment_layout_bg_color_dark);
        View r129 = this.f194473e;
        if (r129 == null) goto L67;
        View r130 = r129.findViewById(R.id.layout_input);
        if (r130 == null) goto L67;
        r130.setBackgroundColor(r128);
    L67:
        View r131 = this.f194473e;
        if (r131 == null) goto L72;
        View r132 = r131.findViewById(R.id.container);
        if (r132 == null) goto L72;
        r132.setBackgroundColor(r128);
    L72:
        View r133 = this.f194473e;
        if (r133 == null) goto L77;
        View r134 = r133.findViewById(R.id.panel_holder);
        if (r134 == null) goto L77;
        r134.setBackgroundColor(r128);
    L77:
        View r135 = this.f194473e;
        if (r135 == null) goto L82;
        View r136 = r135.findViewById(R.id.emoji_panel_container);
        if (r136 == null) goto L82;
        r136.setBackgroundColor(r128);
    L82:
        View r137 = this.f194473e;
        if (r137 == null) goto L87;
        View r138 = r137.findViewById(R.id.comment_content_container);
        if (r138 == null) goto L87;
        r138.setBackgroundResource(R.drawable.aos_aweme_comment_bg_input_comment_dark);
    L87:
        int r139 = this.f194469a.getActivity().getResources().getColor(R.color.aos_white);
        int r140 = this.f194469a.getActivity().getResources().getColor(R.color.aos_comment_text_hint_color_dark);
        if (r127 == null) goto L90;
        r127.setTextColor(r139);
    L90:
        if (r127 == null) goto L122;
        r127.setHintTextColor(r140);
        goto L122
    L92:
        int r141 = this.f194469a.getActivity().getResources().getColor(R.color.aos_comment_layout_bg_color_light);
        View r142 = this.f194473e;
        if (r142 == null) goto L97;
        View r143 = r142.findViewById(R.id.layout_input);
        if (r143 == null) goto L97;
        r143.setBackgroundColor(r141);
    L97:
        View r144 = this.f194473e;
        if (r144 == null) goto L102;
        View r145 = r144.findViewById(R.id.container);
        if (r145 == null) goto L102;
        r145.setBackgroundColor(r141);
    L102:
        View r146 = this.f194473e;
        if (r146 == null) goto L107;
        View r147 = r146.findViewById(R.id.panel_holder);
        if (r147 == null) goto L107;
        r147.setBackgroundColor(r141);
    L107:
        View r148 = this.f194473e;
        if (r148 == null) goto L112;
        View r149 = r148.findViewById(R.id.emoji_panel_container);
        if (r149 == null) goto L112;
        r149.setBackgroundColor(r141);
    L112:
        View r150 = this.f194473e;
        if (r150 == null) goto L117;
        View r151 = r150.findViewById(R.id.comment_content_container);
        if (r151 == null) goto L117;
        r151.setBackgroundResource(R.drawable.aos_aweme_comment_bg_input_comment_light);
    L117:
        int r152 = this.f194469a.getActivity().getResources().getColor(R.color.TextPrimary);
        int r153 = this.f194469a.getActivity().getResources().getColor(R.color.aos_comment_text_hint_color_light);
        if (r127 == null) goto L120;
        r127.setTextColor(r152);
    L120:
        if (r127 == null) goto L122;
        r127.setHintTextColor(r153);
        goto L122
    L59:
        r127 = null;
    L122:
        Activity r154 = this.f194469a.getActivity();
        View r155 = this.f194473e;
        Intrinsics.checkNotNull(r155);
        com.bytedance.awemeopen.apps.framework.comment.write.utils.d r156 = new com.bytedance.awemeopen.apps.framework.comment.write.utils.d(r154, r155);
        this.f194479k = r156;
        r156.f194589i = new b(this);
        r156.getContentView().getViewTreeObserver().addOnGlobalLayoutListener(r156);
        r156.f194582b.post(r156.f194591k);
        View r157 = this.f194473e;
        if (r157 == null) goto L125;
        r100 = r157.getViewTreeObserver();
    L125:
        if (r100 == null) goto L127;
        r100.addOnPreDrawListener(new c(r100));
    L127:
        this.f194474f = new View(this.f194469a.getActivity());
        ViewGroup.LayoutParams r158 = new ViewGroup.LayoutParams(-1, -1);
        View r159 = this.f194474f;
        if (r159 == null) goto L131;
        r159.setLayoutParams(r158);
    L131:
        View r160 = this.f194474f;
        if (r160 == null) goto L134;
        r160.setBackgroundColor(this.f194477i);
    L134:
        AoLogger.b("write_comment", new Object[]{"#onCreate finish"});
        return;
    L52:
        r123 = null;
        goto L53
    L48:
        r121 = null;
        goto L49
    }

    @Override // com.bytedance.awemeopen.apps.framework.comment.write.d
    public final com.bytedance.awemeopen.apps.framework.comment.write.refactor.s getPanel() {
        com.bytedance.awemeopen.apps.framework.comment.write.refactor.s r100 = this.f194475g;
        Intrinsics.checkNotNull(r100);
        return r100;
    }

    @Override // com.bytedance.awemeopen.apps.framework.comment.write.d
    public final boolean isShowing() {
        if (this.f194470b == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public n(com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b r100) {
        Intrinsics.checkNotNullParameter(r100, "pageOwner");
        this.f194469a = r100;
        this.f194470b = -1;
        this.f194475g = new com.bytedance.awemeopen.apps.framework.comment.write.refactor.s(r100.getActivity(), this, this.f194469a);
    }

    @Override // com.bytedance.awemeopen.apps.framework.comment.write.d
    public final void U0(String r100) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        boolean r101 = false;
        AoLogger.b("write_comment", new Object[]{"#showDialog:"});
        if (this.f194469a.getActivity().isFinishing() == false) goto L5;
        return;
    L5:
        com.bytedance.awemeopen.apps.framework.comment.write.utils.d r102 = this.f194479k;
        if (r102 == null) goto L8;
        r102.getContentView().getViewTreeObserver().addOnGlobalLayoutListener(r102);
        r102.f194582b.post(r102.f194591k);
    L8:
        ViewGroup r103 = this.f194472d;
        if (r103 == null) goto L16;
        View r104 = this.f194473e;
        Intrinsics.checkNotNull(r104);
        if (r103.indexOfChild(r104) == (-1)) goto L13;
        boolean r105 = true;
    L14:
        if (r105 == true) goto L16;
        r101 = true;
        goto L16
    L13:
        r105 = false;
    L16:
        if (r101 == false) goto L27;
        View r106 = this.f194473e;
        if (r106 == null) goto L20;
        x54.b.b(r106);
    L20:
        ViewGroup r107 = this.f194472d;
        if (r107 == null) goto L23;
        r107.addView(this.f194474f);
    L23:
        ViewGroup r108 = this.f194472d;
        if (r108 == null) goto L27;
        r108.addView(this.f194473e);
    L27:
        if (this.f194470b == 1) goto L32;
        View r109 = this.f194473e;
        if (r109 == null) goto L33;
        r109.post(new k(this));
        return;
    L33:
        return;
    }

    public final void b(boolean r100) {
        ValueAnimator r101 = this.f194480l;
        if (r101 == null) goto L5;
        r101.cancel();
    L5:
        View r102 = this.f194474f;
        if (r102 == null) goto L11;
        if (r100 == false) goto L9;
        int r103 = this.f194477i;
    L10:
        r102.setBackgroundColor(r103);
        goto L11
    L9:
        r103 = this.f194478j;
    L11:
        ArgbEvaluator r104 = new ArgbEvaluator();
        Object[] r105 = new Object[2];
        if (r100 == false) goto L14;
        int r106 = this.f194477i;
    L15:
        r105[0] = Integer.valueOf(r106);
        if (r100 == false) goto L18;
        int r107 = this.f194478j;
    L19:
        r105[1] = Integer.valueOf(r107);
        ValueAnimator r108 = ValueAnimator.ofObject(r104, r105);
        this.f194480l = r108;
        if (r108 == null) goto L26;
        if (r100 == false) goto L24;
        long r109 = 200;
    L25:
        r108.setDuration(r109);
        goto L26
    L24:
        r109 = 300;
    L26:
        ValueAnimator r110 = this.f194480l;
        if (r110 == null) goto L29;
        r110.addUpdateListener(new m(this));
    L29:
        ValueAnimator r111 = this.f194480l;
        if (r111 == null) goto L33;
        r111.start();
        return;
    L33:
        return;
    L18:
        r107 = this.f194477i;
        goto L19
    L14:
        r106 = this.f194478j;
        goto L15
    }
}
