package com.ss.android.lark.reaction.widget.panel;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.window.layout.WindowMetricsCalculator;
import com.larksuite.component.universe_design.dimension.UDDimension;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.framework.ui.BasePopupWindow;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildPopupWindowBoundsAdapter;
import com.obric.miniapp.alarm.AlarmSessionType;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.newemoji.emoji_list.EmojiListView;
import com.ss.android.lark.newemoji.emoji_list.adapter.view.RecentUsedEmojiView;
import com.ss.android.lark.newemoji.emoji_panel.DefaultEmojiPanelData;
import com.ss.android.lark.statistics.Statistics;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import s2c.f;
import s2c.h;
import z5c.o;
import z5c.z0;
import z5c.z2;

/* JADX INFO: loaded from: classes37.dex */
public final class ReactionPanelFacade {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f439450a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f439451b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<e> f439452c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f439453d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f439454e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f439455f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f439456g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f439457h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<String> f439458i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public BasePopupWindow f439459j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View f439460k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public RecyclerView f439461l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public EmojiListView f439462m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View f439463n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public RecentUsedEmojiView f439464o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ImageView f439465p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f439466q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public PopupWindow.OnDismissListener f439467r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f439468s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int f439469t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f439470u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f439471v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final boolean f439472w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final ReactionScene f439473x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final String f439474y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final DefaultEmojiPanelData f439475z;

    public static final enum ReactionScene extends Enum<ReactionScene> {
        public static final ReactionScene CCM = null;
        public static final ReactionScene IM = null;
        public static final ReactionScene MOMENTS = null;
        public static final ReactionScene TODO = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ReactionScene[] f439476a = null;
        public s5c.d value;

        static {
            ReactionScene r100 = new ReactionScene("IM", 0, z2.f570430c);
            IM = r100;
            ReactionScene r101 = new ReactionScene("CCM", 1, z2.f570431d);
            CCM = r101;
            ReactionScene r102 = new ReactionScene("MOMENTS", 2, z2.f570432e);
            MOMENTS = r102;
            ReactionScene r103 = new ReactionScene(AlarmSessionType.TODO, 3, z2.f570433f);
            TODO = r103;
            f439476a = new ReactionScene[]{r100, r101, r102, r103};
        }

        public static ReactionScene[] values() {
            return (ReactionScene[]) f439476a.clone();
        }

        public static ReactionScene valueOf(String r100) {
            return (ReactionScene) r27.a.a(ReactionScene.class, r100);
        }

        public ReactionScene(String r100, int r101, s5c.a r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ReactionSource {
        public static final int REACTION_DETAIL = 2;
        public static final int REACTION_LKP_HOVER = 3;
        public static final int REACTION_QUICK_APPEND = 5;
        public static final int REACTION_RECENT_USED = 0;
        public static final int REACTION_THREAD_LIKE = 4;
        public static final int REACTION_UNKNOWN = -1;
        public static final int REACTION_WHOLE = 1;
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f439477a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View f439478b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f439479c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List<e> f439480d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public b f439481e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f439482f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f439483g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f439484h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final int f439485i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f439486j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f439487k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public ReactionScene f439488l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final String f439489m;

        public final ReactionPanelFacade a() {
            return new ReactionPanelFacade(this.f439477a, this.f439478b, this.f439480d, this.f439479c, this.f439481e, this.f439482f, this.f439483g, this.f439484h, this.f439485i, this.f439486j, this.f439487k, this.f439488l, this.f439489m);
        }

        public a(View r100) {
            this.f439479c = true;
            this.f439480d = new ArrayList();
            this.f439483g = true;
            this.f439484h = R.style.ReactionPanelAnimation;
            this.f439485i = -1;
            this.f439486j = -1;
            this.f439487k = false;
            this.f439488l = ReactionScene.IM;
            this.f439489m = "";
            this.f439477a = r100.getContext();
            this.f439478b = r100;
        }
    }

    public interface b {
        void a(String r100, int r101);

        void b();
    }

    public final void c() {
        BasePopupWindow r100 = this.f439459j;
        if (r100 == null) goto L6;
        PopupWindowLancet.handleDismissBeforeOrigin(r100);
        r100.dismiss();
        return;
    }

    public final int d() {
        Activity r100 = UIUtils.getActivityFromContext(this.f439453d.getContext());
        if (Build.VERSION.SDK_INT < 29) goto L8;
        if (r100 == null) goto L8;
        int r101 = WindowMetricsCalculator.CC.getOrCreate().computeCurrentWindowMetrics(r100).getBounds().height();
        if (r101 <= 0) goto L8;
    L9:
        if (r101 <= 0) goto L12;
        return r101;
    L12:
        return v2c.a.d(this.f439450a);
    L8:
        r101 = -1;
        goto L9
    }

    public final void e() {
        if (this.f439457h == false) goto L5;
        this.f439460k = LayoutInflater.from(this.f439450a).inflate(R.layout.layout_reaction_panel_bottom, null);
    L6:
        this.f439460k.setOnHoverListener(new s2c.b(this));
        this.f439463n = this.f439460k.findViewById(R.id.first_line_reaction);
        this.f439464o = (RecentUsedEmojiView) this.f439460k.findViewById(R.id.recent_emoji_container);
        this.f439465p = (ImageView) this.f439460k.findViewById(R.id.more_icon_iv);
        this.f439462m = (EmojiListView) this.f439460k.findViewById(R.id.emoji_panel);
        this.f439461l = (RecyclerView) this.f439460k.findViewById(R.id.operation_list);
        this.f439460k.setOnClickListener(new s2c.c(this));
        View r100 = this.f439460k.findViewById(R.id.fake_view);
        if (r100 == null) goto L9;
        float r101 = v2c.a.getResources(this.f439450a).getDimensionPixelSize(R.dimen.reaction_panel_bottom_holder_height_new);
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        r102.height = (int) r101;
        r100.setLayoutParams(r102);
    L9:
        ViewGroup.LayoutParams r103 = this.f439462m.getLayoutParams();
        r103.height = v2c.a.getResources(this.f439450a).getDimensionPixelSize(R.dimen.reaction_panel_all_height_new);
        this.f439462m.setLayoutParams(r103);
        int r104 = 6;
        if (this.f439468s == true) goto L12;
        Log.i("ReactionPanelFacade", "Not init PopupWindow");
    L19:
        if (this.f439471v == (-1)) goto L22;
        this.f439460k.findViewById(R.id.root).setBackgroundResource(this.f439471v);
    L22:
        if (this.f439454e == true) goto L24;
        this.f439463n.setVisibility(8);
    L32:
        boolean r105 = this.f439455f;
        if (r105 == false) goto L41;
        if (r105 == true) goto L36;
        this.f439461l.setVisibility(8);
        goto L41
    L36:
        this.f439461l.setVisibility(0);
        ReactionOperationMenuAdapter r106 = new ReactionOperationMenuAdapter(this.f439450a, this.f439452c);
        r106.f439443a = new s2c.d(this);
        r106.f439444b = new s2c.e(this);
        this.f439461l.setAdapter(r106);
        Context r107 = this.f439450a;
        if (this.f439454e == true) goto L40;
        r104 = Math.min(6, this.f439452c.size());
    L40:
        this.f439461l.setLayoutManager(new GridLayoutManager(r107, r104));
        this.f439461l.setOverScrollMode(2);
        this.f439461l.setHasFixedSize(true);
    L41:
        int r108 = com.ss.android.lark.reaction.widget.panel.a.f439490a;
        ReactionScene r109 = this.f439473x;
        Intrinsics.checkNotNullParameter(r109, "scene");
        Statistics.sendEvent("public_reaction_panel_popup_view", r109.value.toJson());
        return;
    L24:
        this.f439463n.setVisibility(0);
        ImageView r110 = this.f439465p;
        if (this.f439455f == false) goto L27;
        int r111 = 0;
    L28:
        r110.setVisibility(r111);
        Context r112 = this.f439450a;
        int r113 = this.f439470u;
        if (r113 != (-1)) goto L31;
        r113 = R.color.icon_n1;
    L31:
        this.f439465p.setImageDrawable(UDIconUtils.getIconDrawable(this.f439450a, R.drawable.ud_icon_more_add_outlined, v2c.a.b(r112, r113), new UDDimension.Dp(22)));
        this.f439465p.setOnClickListener(new c(this));
        this.f439463n.getViewTreeObserver().addOnGlobalLayoutListener(new h(this, new d(this)));
        goto L32
    L27:
        r111 = 8;
        goto L28
    L12:
        this.f439456g = Math.min((int) (((double) d()) * 0.92d), v2c.a.a(this.f439450a, 338.0f));
        if (this.f439452c.size() < 6) goto L15;
    L17:
        BasePopupWindow r114 = new BasePopupWindow(this.f439460k, this.f439456g, -2, true);
        this.f439459j = r114;
        r114.setBackgroundDrawable(new ColorDrawable(0));
        this.f439459j.setOutsideTouchable(true);
        this.f439459j.setTouchable(true);
        this.f439459j.setFocusable(this.f439466q);
        this.f439459j.setAnimationStyle(this.f439469t);
        this.f439459j.setOnDismissListener(new f(this));
        goto L19
    L15:
        if (this.f439454e == true) goto L17;
        this.f439456g = (((this.f439456g - v2c.a.a(this.f439450a, 20.0f)) / 6) * this.f439452c.size()) + v2c.a.a(this.f439450a, 20.0f);
        goto L17
    L5:
        this.f439460k = LayoutInflater.from(this.f439450a).inflate(R.layout.layout_reaction_panel_top, null);
        goto L6
    }

    public final void f(View r100) {
        int[] r101 = new int[2];
        r100.getLocationOnScreen(r101);
        int r102 = d();
        if (r101[1] <= (r102 >> 1)) goto L5;
        boolean r103 = true;
    L6:
        this.f439457h = r103;
        e();
        if (this.f439457h == false) goto L9;
        int r104 = r102 - r101[1];
        a(this.f439459j, r100, 81, 0, r104);
        return;
    L9:
        a(this.f439459j, r100, 49, 0, r101[1]);
        return;
    L5:
        r103 = false;
        goto L6
    }

    public static void b(ReactionPanelFacade r100, s5c.d r101) {
        if (TextUtils.isEmpty(r100.f439474y) == true) goto L5;
        r101 = r101.plus(o.f570267c.a(r100.f439474y));
    L5:
        s5c.d r102 = r101.plus(r100.f439473x.value);
        int r103 = com.ss.android.lark.reaction.widget.panel.a.f439490a;
        DefaultEmojiPanelData r104 = r100.f439475z;
        if (r104 != null) goto L8;
    L10:
        s5c.a r105 = z0.f570428d;
    L11:
        s5c.d r106 = r102.plus(r105);
        Intrinsics.checkNotNullParameter(r106, "extraParams");
        Statistics.sendEvent("public_reaction_panel_select_click", r106.toJson());
        return;
    L8:
        if (r104.c() == false) goto L10;
        r105 = z0.f570427c;
        goto L11
    }

    public final BasePopupWindow g(boolean r100, int r101, int r102, int r103) {
        this.f439457h = r100;
        e();
        a(this.f439459j, this.f439453d, r101, r102, r103);
        return this.f439459j;
    }

    public static void a(BasePopupWindow r100, View r101, int r102, int r110, int r111) {
        if (PopupWindowLancet.hasSubWindowToken(r101) == false) goto L6;
        return;
    L6:
        if ((r100 instanceof PopupWindow) == true) goto L8;
    L11:
        OverlaySource r103 = PopupWindowLancet.resolveSource(r101);
        if (PopupWindowLancet.rewriteDirectShowAtLocationIfNeeded(r100, r101, r103, r102, r110, r111) == false) goto L14;
        return;
    L14:
        r100.showAtLocation(r101, r102, r110, r111);
        PopupWindowLancet.trackAfterShow(r100, r103, r101);
        return;
    L8:
        if (LandscapeChildPopupWindowBoundsAdapter.isShowAtLocationBypassTarget(r100) == false) goto L11;
        r100.showAtLocation(r101, r102, r110, r111);
    }

    public ReactionPanelFacade(Context r100, View r101, List r102, boolean r103, b r104, boolean r105, boolean r106, int r110, int r111, int r112, boolean r113, ReactionScene r114, String r115) {
        boolean r107 = false;
        this.f439457h = false;
        this.f439468s = true;
        this.f439450a = r100;
        this.f439453d = r101;
        this.f439452c = r102;
        if (r102 != null) goto L5;
    L8:
        this.f439455f = r107;
        this.f439454e = r103;
        this.f439458i = new ArrayList(k2c.a.a().h());
        this.f439475z = k2c.a.a().a();
        this.f439451b = r104;
        this.f439466q = r105;
        this.f439469t = r110;
        this.f439470u = r111;
        this.f439471v = r112;
        this.f439472w = r113;
        this.f439473x = r114;
        this.f439474y = r115;
        return;
    L5:
        if (((ArrayList) r102).size() == 0) goto L8;
        if (r106 == false) goto L8;
        r107 = true;
        goto L8
    }
}
