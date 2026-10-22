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
import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.facade.common.empty.Config;
import com.bytedance.ee.bear.facade.common.empty.EmptyView;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.LoadMoreFooter;
import com.bytedance.ee.bear.middleground.feed.export.bean.DocFeed$Value$Result;
import com.bytedance.ee.bear.middleground.feed.export.bean.DocFeed$Value$ResultCode;
import com.bytedance.ee.bear.middleground.feed.export.bean.MultiBean;
import com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.Notice;
import com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.content.normal.NormalContent;
import com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.content.reaction.ReactionContent;
import com.bytedance.ee.bear.middleground.feed.multi.MultiAdapter;
import com.bytedance.ee.bear.middleground.feed.view.empty.FeedPanelStatusConfig;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEmptyState;
import com.bytedance.ee.docsdk.impl.utils.keyboard.producer.BaseKeyboardHeightProducer;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.CollectionUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i0 {
    public static final int y = 0;
    public final FragmentActivity a;
    public final LifecycleOwner b;
    public final ViewGroup c;
    public final View d;
    public final View e;
    public final View f;
    public final View g;
    public final RecyclerView h;
    public final View i;
    public final SpaceEmptyState j;
    public final com.bytedance.ee.bear.facade.common.widget.d k;
    public final MultiAdapter l;
    public final m m;
    public final com.bytedance.ee.bear.facade.common.empty.c n;
    public final uu5.d<List<Notice<?>>> o;
    public final ImageView p;
    public final boolean q;
    public final boolean r;
    public final v s;
    public r0 t;
    public final SmartRefreshLayout u;
    public boolean v;
    public final List<b> w;
    public final boolean x;

    public class a implements View.OnGenericMotionListener {
        @Override // android.view.View.OnGenericMotionListener
        public final boolean onGenericMotion(View r1, MotionEvent r2) {
            return true;
        }

        public a() {
        }
    }

    public class b implements Runnable {
        public final List<String> a;
        public final /* synthetic */ i0 b;

        @Override // java.lang.Runnable
        public final void run() {
            tt5.a.h("PanelViewV2", "read message: Comment");     // Catch: Throwable -> L4
            this.b.m.g(this.a);     // Catch: Throwable -> L4
            this.b.w.remove(this);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(i0 r1, List<String> r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    static {
        y = com.bytedance.ee.util.ui.n.d(16);
    }

    public final void e() {
        if (this.a.getResources().getConfiguration().orientation != 2) goto L5;
        this.k.getClass();
        com.bytedance.ee.bear.facade.common.widget.d.p = 0.2f;
        com.bytedance.ee.bear.facade.common.widget.d.q = 0.6928f;
        com.bytedance.ee.bear.facade.common.widget.d.r = 1.0f;
        return;
    L5:
        this.k.getClass();
        com.bytedance.ee.bear.facade.common.widget.d.h();
    }

    public final boolean f() {
        boolean r0 = this.m.d().isSupportMute();
        if (this.m.g.getValue() == null) goto L5;
        boolean r1 = true;
    L6:
        if (r0 == false) goto L11;
        if (r1 == false) goto L11;
        if (this.q == false) goto L11;
        return true;
    L11:
        return false;
    L5:
        r1 = false;
        goto L6
    }

    public final sa5.b c() {
        if (ForsetiHelper.p() == false) goto L7;
        FragmentActivity r1 = this.a;
        ViewGroup r2 = this.c;
        int r3 = sa5.n.a;
        sa5.o.q2.getClass();
        return (sa5.b) sa5.o.a.a(sa5.b.class, r1, r2);
    L7:
        return (sa5.b) sa5.m.a.a(this.a, sa5.b.class);
    }

    public final void b(Configuration r5) {
        ConstraintLayout.LayoutParams r0 = this.e.getLayoutParams();
        ConstraintLayout.LayoutParams r1 = this.f.getLayoutParams();
        ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) this.g.getLayoutParams();
        if (r5.orientation == 2) goto L5;
    L7:
        ((ViewGroup.MarginLayoutParams) r0).width = -1;
        ((ViewGroup.MarginLayoutParams) r1).width = -1;
        r2.leftMargin = 0;
        r2.rightMargin = 0;
    L8:
        this.e.setLayoutParams(r0);
        this.f.setLayoutParams(r1);
        this.g.setLayoutParams(r2);
        return;
    L5:
        if (ku5.c.k(this.a) == true) goto L7;
        int r6 = (int) (com.bytedance.ee.util.ui.n.q(this.g.getContext()) * 0.7f);
        ((ViewGroup.MarginLayoutParams) r0).width = r6;
        ((ViewGroup.MarginLayoutParams) r1).width = r6;
        int r7 = y;
        r2.leftMargin = r7;
        r2.rightMargin = r7;
        goto L8
    }

    public final void d(boolean r5) {
        tt5.a.h("PanelViewV2", "hide message");
        this.m.c.b(false, r5);
        m r6 = this.m;
        FragmentActivity r0 = this.a;
        r6.getClass();
        bg5.a.k(DocFeed$Value$Result.CANCEL, DocFeed$Value$ResultCode.RESULT_CODE_CANCEL);
        bg5.a.p();
        r6.d.removeObservers(r0);
        r6.f.removeObservers(r0);
        r6.d().setAuto(false);
        ((ConcurrentHashMap) r6.k.a).clear();
        m r7 = this.m;
        List r1 = (List) r7.d.getValue();
        if (r1 == null) goto L5;
        r7.d.setValue(r1);
    L5:
        Iterator r8 = new ArrayList(this.w).iterator();
    L7:
        if (r8.hasNext() == false) goto L9;
        b r2 = (b) r8.next();
        this.h.removeCallbacks(r2);
        r2.run();
        goto L7
    L9:
        ((ArrayList) this.l.c).clear();
        this.l.notifyDataSetChanged();
        this.k.getClass();
        com.bytedance.ee.bear.facade.common.widget.d.h();
        this.k.f();
        this.d.setTranslationX(0.0f);
        this.d.setTranslationY(0.0f);
        sa5.b r9 = c();
        if (r9 == null) goto L13;
        r9.d(this.s);
    L13:
        if (this.d.getParent() == null) goto L18;
        ViewGroup r10 = this.c;
        if (r10 == null) goto L17;
        r10.removeView(this.d);
        goto L18
    L17:
        ((ViewGroup) this.a.findViewById(R.id.content)).removeView(this.d);
    L18:
        bg5.a.o();
    }

    public static void a(i0 r7, r0 r8) {
        r7.getClass();
        int r0 = r8.findFirstVisibleItemPosition();
        int r1 = r8.findLastVisibleItemPosition();
        ArrayList r2 = new ArrayList();
        ArrayList r3 = new ArrayList();
        int r4 = r0;
    L4:
        if (r4 >= (r1 + 1)) goto L17;
        if (r8.findViewByPosition(r4) == null) goto L16;
        if (r4 < 0) goto L16;
        if (r4 >= r7.l.getItemCount()) goto L16;
        MultiBean r5 = (MultiBean) ListProtector.get(r7.l.c, r4);
        if ((r5 instanceof Notice) == false) goto L16;
        Notice r6 = (Notice) r5;
        r3.add(r6.getNoticeId());
        if (r6.getReadStatus() != 0) goto L16;
        r2.add(r6.getNoticeId());
    L16:
        r4 = r4 + 1;
        goto L4
    L17:
        tt5.a.h("PanelViewV2", "emitVisibleItems firstPosition:" + r0 + " lastPosition:" + r1 + " visibleIds:" + r3 + " unreadIds:" + r2);
        if (CollectionUtils.isEmpty(r2) == true) goto L28;
        b r9 = new b(r7, r2);
        ((ArrayList) r7.w).add(r9);
        r7.h.postDelayed(r9, BaseKeyboardHeightProducer.CONFIGURATION_CHANGED_WAIT_MAX_INTERVAL);
        return;
    }

    /* JADX WARN: Type inference failed for: r14v10, types: [gg5.d0] */
    /* JADX WARN: Type inference failed for: r14v11, types: [gg5.o] */
    /* JADX WARN: Type inference failed for: r15v10, types: [gg5.p] */
    /* JADX WARN: Type inference failed for: r5v5, types: [gg5.v] */
    /* JADX WARN: Type inference failed for: r5v8, types: [gg5.c0] */
    /* JADX WARN: Type inference failed for: r8v8, types: [gg5.q] */
    public i0(FragmentActivity r30, LifecycleOwner r31, ViewGroup r32, final m r33) {
        MultiAdapter r3 = new MultiAdapter();
        this.l = r3;
        this.o = new uu5.d(200, new n(this));
        com.bytedance.ee.bear.appsetting.c r4 = com.bytedance.ee.bear.appsetting.c.a.a;
        this.q = r4.g("ccm.message.mute");
        this.r = r4.g("ccm.message.allread");
        this.s = new v(this);
        this.v = false;
        this.w = new ArrayList();
        this.a = r30;
        this.b = r31;
        this.c = r32;
        boolean r5 = r4.g("ccm.mobile.feed.notification_optimization");
        this.x = r5;
        this.m = r33;
        View r6 = LayoutInflater.from(r30).inflate(2131563646, null);
        this.d = r6;
        r6.setOnGenericMotionListener(new a());
        View r7 = r6.findViewById(2131392100);
        this.e = r7;
        this.f = r6.findViewById(2131386038);
        this.g = r6.findViewById(2131377472);
        RecyclerView r8 = r6.findViewById(2131384678);
        this.h = r8;
        r8.setNestedScrollingEnabled(false);
        EmptyView r9 = r6.findViewById(2131378162);
        View r10 = r6.findViewById(2131379672);
        this.i = r10;
        ImageView r11 = (ImageView) r6.findViewById(2131380298);
        this.p = r11;
        SmartRefreshLayout r12 = r6.findViewById(2131386421);
        this.u = r12;
        com.bytedance.ee.bear.facade.common.widget.d r13 = new com.bytedance.ee.bear.facade.common.widget.d(r30, r7);
        this.k = r13;
        this.n = new com.bytedance.ee.bear.facade.common.empty.c(r9, r8);
        this.j = (SpaceEmptyState) r6.findViewById(2131380918);
        r13.f();
        r13.i(r6.findViewById(2131384717));
        if (r5 == false) goto L6;
        r10.setVisibility(8);
    L9:
        r12.F(new LoadMoreFooter(r30), -2);
        r12.g(true);
        r12.A = false;
        r0 r15 = new r0(this, r30);
        this.t = r15;
        r8.setLayoutManager(r15);
        r8.setAdapter(r3);
        r8.setOverScrollMode(2);
        if ((r8.getItemAnimator() instanceof SimpleItemAnimator) == false) goto L12;
        r8.getItemAnimator().setSupportsChangeAnimations(false);
    L12:
        com.bytedance.ee.bear.middleground.comment.export.n r16 = (com.bytedance.ee.bear.middleground.comment.export.n) org.koin.java.a.a(com.bytedance.ee.bear.middleground.comment.export.n.class);
        r33.d().getDocumentType();
        com.bytedance.ee.bear.middleground.comment.cell.i r20 = r16.b(r30, new e0(this), new f0(this), new g0(this));
        ?? r14 = new c0(this);
        gg5.b r17 = new gg5.b(r14, new d0(this));
        ?? r18 = new o(this);
        ?? r19 = new p(this);
        ?? r21 = new q(r33);
        if (r33.d().getDocumentType() == sbb.e.l) goto L15;
        boolean r2 = true;
    L16:
        AccountService.Account r110 = ((com.bytedance.ee.bear.contract.h0) org.koin.java.a.a(com.bytedance.ee.bear.contract.h0.class)).G2();
        if (r110 == null) goto L21;
        String r111 = r110.uid;
        if (r111 == null) goto L21;
    L22:
        r3.y2(NormalContent.class, new fg5.a(r111, r21, r20, r17, r14, r18, r19, r2));
        r3.y2(ReactionContent.class, new fg5.c(r18, r19, r2));
        r9.setConfig((Config) new FeedPanelStatusConfig(r30, ((com.bytedance.ee.bear.contract.i0) org.koin.java.a.a(com.bytedance.ee.bear.contract.i0.class)).a()).c.invoke());
        r12.i(new k0(this));
        if (r5 == true) goto L25;
        r10.setOnClickListener(new l0(this));
    L25:
        r13.h = new a0(this);
        r6.setOnClickListener(new m0(this));
        r7.setOnClickListener(new b0());
        r8.addOnScrollListener(new n0(this));
        r8.addItemDecoration(new o0());
        r11.setOnClickListener(new p0(this));
        return;
    L21:
        r111 = "";
        goto L22
    L15:
        r2 = false;
        goto L16
    L6:
        if (r33.d().isLoadingSuccess() == false) goto L8;
        r10.setVisibility(8);
        goto L9
    L8:
        r10.setVisibility(0);
        goto L9
    }
}
