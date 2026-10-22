package gg5;

import android.R;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.contract.AccountService$Account;
import com.bytedance.ee.bear.facade.common.empty.EmptyView;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.LoadMoreFooter;
import com.bytedance.ee.bear.middleground.feed.export.bean.DocFeed$Value$ResultCode;
import com.bytedance.ee.bear.middleground.feed.export.bean.MultiBean;
import com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.Notice;
import com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.content.normal.NormalContent;
import com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.content.reaction.ReactionContent;
import com.bytedance.ee.bear.middleground.feed.multi.MultiAdapter;
import com.bytedance.ee.bear.middleground.feed.view.empty.FeedPanelStatusConfig;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEmptyState;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.CollectionUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes18.dex */
public final class i0 {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f481147y = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FragmentActivity f481148a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LifecycleOwner f481149b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ViewGroup f481150c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f481151d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f481152e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f481153f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final View f481154g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final RecyclerView f481155h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final View f481156i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final SpaceEmptyState f481157j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final com.bytedance.ee.bear.facade.common.widget.d f481158k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final MultiAdapter f481159l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final m f481160m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.bytedance.ee.bear.facade.common.empty.c f481161n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final uu5.d<List<Notice<?>>> f481162o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ImageView f481163p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f481164q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f481165r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final v f481166s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public r0 f481167t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final SmartRefreshLayout f481168u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f481169v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final List<b> f481170w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final boolean f481171x;

    public class a implements View.OnGenericMotionListener {
        @Override // android.view.View.OnGenericMotionListener
        public final boolean onGenericMotion(View r100, MotionEvent r101) {
            return true;
        }

        public a() {
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<String> f481172a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ i0 f481173b;

        @Override // java.lang.Runnable
        public final void run() {
            tt5.a.h("PanelViewV2", "read message: Comment");     // Catch: Throwable -> L4
            this.f481173b.f481160m.g(this.f481172a);     // Catch: Throwable -> L4
            this.f481173b.f481170w.remove(this);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(i0 r100, List<String> r101) {
            this.f481173b = r100;
            this.f481172a = r101;
        }
    }

    static {
        f481147y = com.bytedance.ee.util.ui.n.d(16);
    }

    public final void e() {
        if (this.f481148a.getResources().getConfiguration().orientation != 2) goto L5;
        this.f481158k.getClass();
        com.bytedance.ee.bear.facade.common.widget.d.f226583p = 0.2f;
        com.bytedance.ee.bear.facade.common.widget.d.f226584q = 0.6928f;
        com.bytedance.ee.bear.facade.common.widget.d.f226585r = 1.0f;
        return;
    L5:
        this.f481158k.getClass();
        com.bytedance.ee.bear.facade.common.widget.d.h();
    }

    public final boolean f() {
        boolean r100 = this.f481160m.d().isSupportMute();
        if (this.f481160m.f481187g.getValue() == null) goto L5;
        boolean r101 = true;
    L6:
        if (r100 == false) goto L11;
        if (r101 == false) goto L11;
        if (this.f481164q == false) goto L11;
        return true;
    L11:
        return false;
    L5:
        r101 = false;
        goto L6
    }

    public final sa5.b c() {
        if (ForsetiHelper.p() == false) goto L7;
        FragmentActivity r100 = this.f481148a;
        ViewGroup r101 = this.f481150c;
        int r102 = sa5.n.f541175a;
        sa5.o.f541176q2.getClass();
        return (sa5.b) sa5.o.a.a(sa5.b.class, r100, r101);
    L7:
        return (sa5.b) sa5.m.a.a(this.f481148a, sa5.b.class);
    }

    public final void b(Configuration r100) {
        ConstraintLayout.LayoutParams r101 = (ConstraintLayout.LayoutParams) this.f481152e.getLayoutParams();
        ConstraintLayout.LayoutParams r102 = (ConstraintLayout.LayoutParams) this.f481153f.getLayoutParams();
        ViewGroup.MarginLayoutParams r103 = (ViewGroup.MarginLayoutParams) this.f481154g.getLayoutParams();
        if (r100.orientation == 2) goto L5;
    L7:
        ((ViewGroup.MarginLayoutParams) r101).width = -1;
        ((ViewGroup.MarginLayoutParams) r102).width = -1;
        r103.leftMargin = 0;
        r103.rightMargin = 0;
    L8:
        this.f481152e.setLayoutParams(r101);
        this.f481153f.setLayoutParams(r102);
        this.f481154g.setLayoutParams(r103);
        return;
    L5:
        if (ku5.c.k(this.f481148a) == true) goto L7;
        int r104 = (int) (com.bytedance.ee.util.ui.n.q(this.f481154g.getContext()) * 0.7f);
        ((ViewGroup.MarginLayoutParams) r101).width = r104;
        ((ViewGroup.MarginLayoutParams) r102).width = r104;
        int r105 = f481147y;
        r103.leftMargin = r105;
        r103.rightMargin = r105;
        goto L8
    }

    public final void d(boolean r100) {
        tt5.a.h("PanelViewV2", "hide message");
        ((l15.l) this.f481160m.f481183c).b(false, r100);
        m r101 = this.f481160m;
        FragmentActivity r102 = this.f481148a;
        r101.getClass();
        bg5.a.k("cancel", DocFeed$Value$ResultCode.RESULT_CODE_CANCEL);
        bg5.a.p();
        r101.f481184d.removeObservers(r102);
        r101.f481186f.removeObservers(r102);
        r101.d().setAuto(false);
        ((ConcurrentHashMap) r101.f481191k.f549919a).clear();
        m r103 = this.f481160m;
        List<Notice<?>> r104 = r103.f481184d.getValue();
        if (r104 == null) goto L5;
        r103.f481184d.setValue(r104);
    L5:
        Iterator r105 = new ArrayList(this.f481170w).iterator();
    L7:
        if (r105.hasNext() == false) goto L9;
        b r106 = (b) r105.next();
        this.f481155h.removeCallbacks(r106);
        r106.run();
        goto L7
    L9:
        ((ArrayList) this.f481159l.f232617c).clear();
        this.f481159l.notifyDataSetChanged();
        this.f481158k.getClass();
        com.bytedance.ee.bear.facade.common.widget.d.h();
        this.f481158k.f();
        this.f481151d.setTranslationX(0.0f);
        this.f481151d.setTranslationY(0.0f);
        sa5.b r107 = c();
        if (r107 == null) goto L13;
        r107.d(this.f481166s);
    L13:
        if (this.f481151d.getParent() == null) goto L18;
        ViewGroup r108 = this.f481150c;
        if (r108 == null) goto L17;
        r108.removeView(this.f481151d);
        goto L18
    L17:
        ((ViewGroup) this.f481148a.findViewById(R.id.content)).removeView(this.f481151d);
    L18:
        bg5.a.o();
    }

    public static void a(i0 r100, r0 r101) {
        r100.getClass();
        int r102 = r101.findFirstVisibleItemPosition();
        int r103 = r101.findLastVisibleItemPosition();
        ArrayList r104 = new ArrayList();
        ArrayList r105 = new ArrayList();
        int r106 = r102;
    L4:
        if (r106 >= (r103 + 1)) goto L17;
        if (r101.findViewByPosition(r106) == null) goto L16;
        if (r106 < 0) goto L16;
        if (r106 >= r100.f481159l.getItemCount()) goto L16;
        MultiBean r107 = (MultiBean) ListProtector.get(r100.f481159l.f232617c, r106);
        if ((r107 instanceof Notice) == false) goto L16;
        Notice r108 = (Notice) r107;
        r105.add(r108.getNoticeId());
        if (r108.getReadStatus() != 0) goto L16;
        r104.add(r108.getNoticeId());
    L16:
        r106 = r106 + 1;
        goto L4
    L17:
        tt5.a.h("PanelViewV2", "emitVisibleItems firstPosition:" + r102 + " lastPosition:" + r103 + " visibleIds:" + r105 + " unreadIds:" + r104);
        if (CollectionUtils.isEmpty(r104) == true) goto L28;
        b r109 = new b(r100, r104);
        ((ArrayList) r100.f481170w).add(r109);
        r100.f481155h.postDelayed(r109, 2000);
        return;
    }

    /* JADX WARN: Type inference failed for: r14v10, types: [gg5.d0] */
    /* JADX WARN: Type inference failed for: r14v11, types: [gg5.o] */
    /* JADX WARN: Type inference failed for: r15v10, types: [gg5.p] */
    /* JADX WARN: Type inference failed for: r5v5, types: [gg5.v] */
    /* JADX WARN: Type inference failed for: r5v8, types: [gg5.c0] */
    /* JADX WARN: Type inference failed for: r8v8, types: [gg5.q] */
    public i0(FragmentActivity r310, LifecycleOwner r311, ViewGroup r312, final m r313) {
        MultiAdapter r100 = new MultiAdapter();
        this.f481159l = r100;
        this.f481162o = new uu5.d(200, new n(this));
        com.bytedance.ee.bear.appsetting.c r101 = com.bytedance.ee.bear.appsetting.c.a.f206237a;
        this.f481164q = r101.g("ccm.message.mute");
        this.f481165r = r101.g("ccm.message.allread");
        this.f481166s = new v(this);
        this.f481169v = false;
        this.f481170w = new ArrayList();
        this.f481148a = r310;
        this.f481149b = r311;
        this.f481150c = r312;
        boolean r102 = r101.g("ccm.mobile.feed.notification_optimization");
        this.f481171x = r102;
        this.f481160m = r313;
        View r103 = LayoutInflater.from(r310).inflate(com.larus.nova.R.layout.midele_feed_panel_layout, null);
        this.f481151d = r103;
        r103.setOnGenericMotionListener(new a());
        View r104 = r103.findViewById(com.larus.nova.R.id.v_bg);
        this.f481152e = r104;
        this.f481153f = r103.findViewById(com.larus.nova.R.id.shadow_layout);
        this.f481154g = r103.findViewById(com.larus.nova.R.id.layout_content);
        RecyclerView r105 = (RecyclerView) r103.findViewById(com.larus.nova.R.id.rl_content);
        this.f481155h = r105;
        r105.setNestedScrollingEnabled(false);
        EmptyView r106 = (EmptyView) r103.findViewById(com.larus.nova.R.id.list_no_data_tip);
        View r110 = r103.findViewById(com.larus.nova.R.id.mask_view);
        this.f481156i = r110;
        ImageView r111 = (ImageView) r103.findViewById(com.larus.nova.R.id.more_btn);
        this.f481163p = r111;
        SmartRefreshLayout r112 = (SmartRefreshLayout) r103.findViewById(com.larus.nova.R.id.sidebar_smart_refresh_layout);
        this.f481168u = r112;
        com.bytedance.ee.bear.facade.common.widget.d r113 = new com.bytedance.ee.bear.facade.common.widget.d(r310, r104);
        this.f481158k = r113;
        this.f481161n = new com.bytedance.ee.bear.facade.common.empty.c(r106, r105);
        this.f481157j = (SpaceEmptyState) r103.findViewById(com.larus.nova.R.id.no_auth_view);
        r113.f();
        r113.i(r103.findViewById(com.larus.nova.R.id.rl_title));
        if (r102 == false) goto L6;
        r110.setVisibility(8);
    L9:
        r112.F(new LoadMoreFooter(r310), -2);
        r112.g(true);
        r112.A = false;
        r0 r114 = new r0(this, r310);
        this.f481167t = r114;
        r105.setLayoutManager(r114);
        r105.setAdapter(r100);
        r105.setOverScrollMode(2);
        if ((r105.getItemAnimator() instanceof SimpleItemAnimator) == false) goto L12;
        ((SimpleItemAnimator) r105.getItemAnimator()).setSupportsChangeAnimations(false);
    L12:
        com.bytedance.ee.bear.middleground.comment.export.n r115 = (com.bytedance.ee.bear.middleground.comment.export.n) org.koin.java.a.a(com.bytedance.ee.bear.middleground.comment.export.n.class);
        r313.d().getDocumentType();
        com.bytedance.ee.bear.middleground.comment.cell.i r210 = r115.b(r310, new e0(this), new f0(this), new g0(this));
        ?? r107 = new c0(this);
        gg5.b r116 = new gg5.b(r107, new d0(this));
        ?? r117 = new o(this);
        ?? r118 = new p(this);
        ?? r108 = new q(r313);
        if (r313.d().getDocumentType() == sbb.e.f541301l) goto L15;
        boolean r109 = true;
    L16:
        AccountService$Account r119 = ((com.bytedance.ee.bear.contract.h0) org.koin.java.a.a(com.bytedance.ee.bear.contract.h0.class)).G2();
        if (r119 == null) goto L21;
        String r120 = r119.uid;
        if (r120 == null) goto L21;
    L22:
        r100.y2(NormalContent.class, new fg5.a(r120, r108, r210, r116, r107, r117, r118, r109));
        r100.y2(ReactionContent.class, new fg5.c(r117, r118, r109));
        r106.setConfig(new FeedPanelStatusConfig(r310, ((com.bytedance.ee.bear.contract.i0) org.koin.java.a.a(com.bytedance.ee.bear.contract.i0.class)).a()).f232708c.invoke());
        r112.i(new k0(this));
        if (r102 == true) goto L25;
        r110.setOnClickListener(new l0(this));
    L25:
        r113.f226593h = new a0(this);
        r103.setOnClickListener(new m0(this));
        r104.setOnClickListener(new b0());
        r105.addOnScrollListener(new n0(this));
        r105.addItemDecoration(new o0());
        r111.setOnClickListener(new p0(this));
        return;
    L21:
        r120 = "";
        goto L22
    L15:
        r109 = false;
        goto L16
    L6:
        if (r313.d().isLoadingSuccess() == false) goto L8;
        r110.setVisibility(8);
        goto L9
    L8:
        r110.setVisibility(0);
        goto L9
    }
}
