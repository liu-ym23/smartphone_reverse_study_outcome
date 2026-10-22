package dg5;

import android.R;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.facade.common.empty.Config;
import com.bytedance.ee.bear.facade.common.empty.EmptyView;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.comment.export.CommentStyle;
import com.bytedance.ee.bear.middleground.comment.export.bean.TranslateConfig;
import com.bytedance.ee.bear.middleground.feed.export.bean.AtBean;
import com.bytedance.ee.bear.middleground.feed.export.bean.DeleteBean;
import com.bytedance.ee.bear.middleground.feed.export.bean.DocFeed$Value$Result;
import com.bytedance.ee.bear.middleground.feed.export.bean.DocFeed$Value$ResultCode;
import com.bytedance.ee.bear.middleground.feed.export.bean.FeedCommentDetailBean;
import com.bytedance.ee.bear.middleground.feed.export.bean.MessageBean;
import com.bytedance.ee.bear.middleground.feed.export.bean.MessageConfig;
import com.bytedance.ee.bear.middleground.feed.export.bean.MultiBean;
import com.bytedance.ee.bear.middleground.feed.export.bean.ShareBean;
import com.bytedance.ee.bear.middleground.feed.export.bean.UnknownBean;
import com.bytedance.ee.bear.middleground.feed.multi.MultiAdapter;
import com.bytedance.ee.bear.middleground.feed.view.adapter.FeedItemComment;
import com.bytedance.ee.bear.middleground.feed.view.adapter.FeedItemDelete;
import com.bytedance.ee.bear.middleground.feed.view.adapter.FeedItemMention;
import com.bytedance.ee.bear.middleground.feed.view.adapter.FeedItemShare;
import com.bytedance.ee.bear.middleground.feed.view.adapter.FeedItemUnknown;
import com.bytedance.ee.bear.middleground.feed.view.adapter.FeedTipsModel;
import com.bytedance.ee.bear.middleground.feed.view.empty.FeedPanelStatusConfig;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BaseEntity;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionRequest;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEmptyState;
import com.bytedance.ee.docsdk.impl.utils.keyboard.producer.BaseKeyboardHeightProducer;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Triple;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a0 {
    public final FragmentActivity a;
    public final ViewGroup b;
    public final View c;
    public final View d;
    public final View e;
    public final View f;
    public final RecyclerView g;
    public final View h;
    public final SpaceEmptyState i;
    public final com.bytedance.ee.bear.facade.common.widget.d j;
    public final MultiAdapter k;
    public final d1 l;
    public final com.bytedance.ee.bear.facade.common.empty.c m;
    public final uu5.d<Triple<List<MultiBean>, String, Boolean>> n;
    public final ImageView o;
    public final boolean p;
    public final boolean q;
    public final q r;
    public h0 s;
    public final int t;
    public boolean u;
    public final List<b> v;
    public final boolean w;

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
        public final /* synthetic */ a0 b;

        @Override // java.lang.Runnable
        public final void run() {
            tt5.a.h("PanelView", "read message: Comment");     // Catch: Throwable -> L4
            this.b.l.i(this.a);     // Catch: Throwable -> L4
            ((ArrayList) this.b.v).remove(this);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(a0 r1, List<String> r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public final boolean f() {
        if (this.c.getParent() == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final void g() {
        if (this.a.getResources().getConfiguration().orientation != 2) goto L5;
        this.j.getClass();
        com.bytedance.ee.bear.facade.common.widget.d.p = 0.2f;
        com.bytedance.ee.bear.facade.common.widget.d.q = 0.6928f;
        com.bytedance.ee.bear.facade.common.widget.d.r = 1.0f;
        return;
    L5:
        this.j.getClass();
        com.bytedance.ee.bear.facade.common.widget.d.h();
    }

    public final boolean h() {
        boolean r0 = this.l.e.isSupportMute();
        if (this.l.h.getValue() == null) goto L5;
        boolean r1 = true;
    L6:
        boolean r4 = this.l.k();
        if (r0 == false) goto L13;
        if (r1 == false) goto L13;
        if (this.p == false) goto L13;
        if (r4 == true) goto L13;
        return true;
    L13:
        return false;
    L5:
        r1 = false;
        goto L6
    }

    public final sa5.b c() {
        if (ForsetiHelper.p() == false) goto L7;
        FragmentActivity r1 = this.a;
        ViewGroup r2 = this.b;
        int r3 = sa5.n.a;
        sa5.o.q2.getClass();
        return (sa5.b) sa5.o.a.a(sa5.b.class, r1, r2);
    L7:
        return (sa5.b) sa5.m.a.a(this.a, sa5.b.class);
    }

    public static PermissionResponse d(MessageConfig r4) {
        BaseEntity r0 = new BaseEntity(r4.getToken(), r4.getDocumentType(), BizDomain.FileBizDomainCCM, "");
        return ((ph5.b) org.koin.java.a.a(ph5.b.class)).f(new PermissionRequest(r0, "CONTENT_COPY"), null);
    }

    public final void b(Configuration r5) {
        ConstraintLayout.LayoutParams r0 = this.d.getLayoutParams();
        ConstraintLayout.LayoutParams r1 = this.e.getLayoutParams();
        ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) this.f.getLayoutParams();
        if (r5.orientation == 2) goto L5;
    L7:
        ((ViewGroup.MarginLayoutParams) r0).width = -1;
        ((ViewGroup.MarginLayoutParams) r1).width = -1;
        r2.leftMargin = 0;
        r2.rightMargin = 0;
    L8:
        this.d.setLayoutParams(r0);
        this.e.setLayoutParams(r1);
        this.f.setLayoutParams(r2);
        return;
    L5:
        if (ku5.c.k(this.a) == true) goto L7;
        int r6 = (int) (com.bytedance.ee.util.ui.n.q(this.f.getContext()) * 0.7f);
        ((ViewGroup.MarginLayoutParams) r0).width = r6;
        ((ViewGroup.MarginLayoutParams) r1).width = r6;
        int r7 = this.t;
        r2.leftMargin = r7;
        r2.rightMargin = r7;
        goto L8
    }

    public final void e(boolean r5) {
        tt5.a.h("PanelView", "hide message");
        this.l.d.b(false, r5);
        d1 r6 = this.l;
        FragmentActivity r0 = this.a;
        r6.getClass();
        bg5.a.k(DocFeed$Value$Result.CANCEL, DocFeed$Value$ResultCode.RESULT_CODE_CANCEL);
        bg5.a.p();
        r6.f.removeObservers(r0);
        r6.g.removeObservers(r0);
        r6.e.setAuto(false);
        ((ConcurrentHashMap) r6.o.a).clear();
        r6.g(r6.e.isOwner(), "");
        d1 r7 = this.l;
        Triple r1 = (Triple) r7.f.getValue();
        if (r1 == null) goto L5;
        r7.f.setValue(new Triple((List) r1.getFirst(), (String) r1.getSecond(), Boolean.TRUE));
    L5:
        Iterator r8 = new ArrayList(this.v).iterator();
    L7:
        if (r8.hasNext() == false) goto L9;
        b r2 = (b) r8.next();
        this.g.removeCallbacks(r2);
        r2.run();
        goto L7
    L9:
        ((ArrayList) this.k.c).clear();
        this.k.notifyDataSetChanged();
        this.j.getClass();
        com.bytedance.ee.bear.facade.common.widget.d.h();
        this.j.f();
        this.c.setTranslationX(0.0f);
        this.c.setTranslationY(0.0f);
        sa5.b r9 = c();
        if (r9 == null) goto L13;
        r9.d(this.r);
    L13:
        if (this.c.getParent() == null) goto L18;
        ViewGroup r10 = this.b;
        if (r10 == null) goto L17;
        r10.removeView(this.c);
        goto L18
    L17:
        ((ViewGroup) this.a.findViewById(R.id.content)).removeView(this.c);
    L18:
        bg5.a.o();
    }

    public final boolean i(String r18) {
        d1 r2 = this.l;
        FragmentActivity r3 = this.a;
        r2.getClass();
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.feed.notification_optimization") == true) goto L89;
        Iterator<MessageBean> r4 = r2.l.getData().getMessage().iterator();     // Catch: Exception -> L80
    L34:
        if (r4.hasNext() == false) goto L39;
        MessageBean r8 = r4.next();     // Catch: Exception -> L80
        if (r18.equals(r8.getMessageId()) == false) goto L34;
    L40:
        if (r8 != null) goto L43;
        tt5.a.d("PanelViewModel", "can't found messageId:" + r18);     // Catch: Exception -> L80
    L95:
        return false;
    L43:
        tt5.a.h("PanelViewModel", "at:" + r8.getType() + " messageId:" + r18 + " isWhole:" + r8.getIs_whole() + " commentId:" + r8.getComment_id() + " replyId:" + r8.getReply_id());     // Catch: Exception -> L80
        if (MessageBean.MESSAGE_DOC_COMMENT.equals(r8.getType()) == false) goto L70;
        r8.getComment_id();     // Catch: Exception -> L80
        if (r8.isHasCommentPermission() == true) goto L49;
        Toast.showText(r3, 2131888971);     // Catch: Exception -> L80
    L74:
        boolean r9 = false;
    L84:
        return r9;
    L49:
        if (r8.getDelete() != 1) goto L52;
        Toast.showText(r3, 2131887853);     // Catch: Exception -> L80
        goto L74
    L52:
        if (r8.getFinish() != 1) goto L55;
        Toast.showText(r3, 2131887855);     // Catch: Exception -> L80
        goto L74
    L55:
        if (r8.isOriginContentDelete() == false) goto L57;
        Toast.showText(r3, 2131887854);     // Catch: Exception -> L80
        goto L74
    L57:
        ((com.bytedance.ee.bear.middleground.comment.export.n) org.koin.java.a.a(com.bytedance.ee.bear.middleground.comment.export.n.class)).f().getClass();     // Catch: Exception -> L80
        if (com.bytedance.ee.bear.middleground.comment.card.a.c != CommentStyle.FLOAT) goto L60;
        boolean r0 = true;
    L61:
        if (r0 == true) goto L63;
    L66:
        r2.d.e(r8);     // Catch: Exception -> L78
    L86:
    L77:
        r9 = true;
        goto L84
    L63:
        if (r8.getIs_whole() != 0) goto L66;
        r2.d.e(r8);     // Catch: Exception -> L80
        goto L77
    L60:
        r0 = false;
        goto L61
    L70:
        if (MessageBean.MESSAGE_DOC_MENTION.equals(r8.getType()) == true) goto L72;
        r2.d.e(r8);     // Catch: Exception -> L78
        goto L86
    L72:
        if (r8.isOriginContentDelete() == false) goto L75;
        Toast.showText(r3, 2131887852);     // Catch: Exception -> L80
        goto L74
    L75:
        r2.d.e(r8);     // Catch: Exception -> L78
    L78:
        e = e;
        boolean r5 = false;
        r9 = true;
    L82:
        tt5.a.f("PanelViewModel", e, r5);
        goto L84
    L39:
        r8 = null;
    L80:
        e = e;
        r5 = false;
        r9 = false;
        goto L82
    L89:
        Iterator<MessageBean> r6 = r2.l.getData().getMessage().iterator();     // Catch: Exception -> L30
    L6:
        if (r6.hasNext() == false) goto L10;
        MessageBean r16 = r6.next();     // Catch: Exception -> L30
        if (TextUtils.equals(r18, r16.getMessageId()) == false) goto L6;
        MessageBean r7 = r16;
    L11:
        if (r7 != null) goto L13;
        tt5.a.d("PanelViewModel", "can't found messageId:" + r18);     // Catch: Exception -> L30
        goto L95
    L13:
        r2.d.k();     // Catch: Exception -> L30
        tt5.a.h("PanelViewModel", "at:" + r7.getType() + " messageId:" + r18 + " isWhole:" + r7.getIs_whole() + " commentId:" + r7.getComment_id() + " replyId:" + r7.getReply_id());     // Catch: Exception -> L30
        if (MessageBean.MESSAGE_DOC_COMMENT.equals(r7.getType()) == false) goto L26;
        if (r7.isHasCommentPermission() == true) goto L19;
        Toast.showText(r3, 2131888971);     // Catch: Exception -> L30
        goto L95
    L19:
        if (r7.getDelete() != 1) goto L22;
        Toast.showText(r3, 2131887853);     // Catch: Exception -> L30
        goto L95
    L22:
        if (r7.getFinish() != 1) goto L24;
        Toast.showText(r3, 2131887855);     // Catch: Exception -> L30
        goto L95
    L24:
        r2.d.e(r7);     // Catch: Exception -> L30
        goto L95
    L26:
        if (MessageBean.MESSAGE_DOC_MENTION.equals(r7.getType()) == false) goto L28;
        r2.d.e(r7);     // Catch: Exception -> L30
        goto L95
    L28:
        r2.d.e(r7);     // Catch: Exception -> L30
        goto L95
    L10:
        r7 = null;
    L30:
        e = move-exception;
        tt5.a.e("PanelViewModel", "toMessageV2 error!", e, false);
        goto L95
    }

    public static void a(a0 r8, h0 r9) {
        r8.getClass();
        int r0 = r9.findFirstVisibleItemPosition();
        int r1 = r9.findLastVisibleItemPosition();
        ArrayList r2 = new ArrayList();
        ArrayList r3 = new ArrayList();
        int r4 = r0;
    L4:
        if (r4 >= (r1 + 1)) goto L17;
        if (r9.findViewByPosition(r4) == null) goto L16;
        if (r4 < 0) goto L16;
        if (r4 >= r8.k.getItemCount()) goto L16;
        MultiBean r5 = (MultiBean) ListProtector.get(r8.k.c, r4);
        if ((r5 instanceof com.bytedance.ee.bear.middleground.feed.export.bean.c) == false) goto L16;
        com.bytedance.ee.bear.middleground.feed.export.bean.c r6 = (com.bytedance.ee.bear.middleground.feed.export.bean.c) r5;
        r3.add(r6.getMessageId());
        if (r6.getReadStatus() != 1) goto L16;
        r2.add(r6.getMessageId());
    L16:
        r4 = r4 + 1;
        goto L4
    L17:
        tt5.a.h("PanelView", "emitVisibleItems firstPosition:" + r0 + " lastPosition:" + r1 + " visibleIds:" + r3 + " unreadIds:" + r2);
        if (r2.isEmpty() == true) goto L28;
        b r10 = new b(r8, r2);
        ((ArrayList) r8.v).add(r10);
        r8.g.postDelayed(r10, BaseKeyboardHeightProducer.CONFIGURATION_CHANGED_WAIT_MAX_INTERVAL);
        return;
    }

    /* JADX WARN: Type inference failed for: r13v3, types: [dg5.f] */
    /* JADX WARN: Type inference failed for: r13v6, types: [dg5.h] */
    /* JADX WARN: Type inference failed for: r15v11, types: [dg5.i] */
    /* JADX WARN: Type inference failed for: r4v5, types: [dg5.q] */
    /* JADX WARN: Type inference failed for: r7v5, types: [dg5.j] */
    /* JADX WARN: Type inference failed for: r7v6, types: [dg5.k] */
    /* JADX WARN: Type inference failed for: r7v7, types: [dg5.n] */
    /* JADX WARN: Type inference failed for: r9v10, types: [dg5.m] */
    /* JADX WARN: Type inference failed for: r9v5, types: [dg5.g] */
    public a0(FragmentActivity r27, ViewGroup r28, com.bytedance.ee.bear.middleground.feed.export.bean.g r29, com.bytedance.ee.bear.middleground.feed.export.bean.i r30, MessageConfig r31) {
        MultiAdapter r2 = new MultiAdapter();
        this.k = r2;
        this.n = new uu5.d(200, new l(this));
        com.bytedance.ee.bear.appsetting.c r3 = com.bytedance.ee.bear.appsetting.c.a.a;
        this.p = r3.g("ccm.message.mute");
        this.q = r3.g("ccm.message.allread");
        this.r = new q(this);
        this.u = false;
        this.v = new ArrayList();
        this.a = r27;
        this.b = r28;
        boolean r4 = r3.g("ccm.mobile.feed.notification_optimization");
        this.w = r4;
        d1 r5 = new d1(r29, r30, r31, r27);
        this.l = r5;
        View r6 = LayoutInflater.from(r27).inflate(2131563646, null);
        this.c = r6;
        r6.setOnGenericMotionListener(new a());
        View r7 = r6.findViewById(2131392100);
        this.d = r7;
        this.e = r6.findViewById(2131386038);
        TextView r8 = (TextView) r6.findViewById(2131391057);
        this.f = r6.findViewById(2131377472);
        RecyclerView r9 = r6.findViewById(2131384678);
        this.g = r9;
        r9.setNestedScrollingEnabled(false);
        EmptyView r10 = r6.findViewById(2131378162);
        View r11 = r6.findViewById(2131379672);
        this.h = r11;
        ImageView r12 = (ImageView) r6.findViewById(2131366984);
        ImageView r13 = (ImageView) r6.findViewById(2131380298);
        this.o = r13;
        com.bytedance.ee.bear.facade.common.widget.d r14 = new com.bytedance.ee.bear.facade.common.widget.d(r27, r7);
        this.j = r14;
        this.m = new com.bytedance.ee.bear.facade.common.empty.c(r10, r9);
        this.i = (SpaceEmptyState) r6.findViewById(2131380918);
        this.t = com.bytedance.ee.util.ui.n.d(16);
        r14.f();
        r14.i(r6.findViewById(2131384717));
        if (r4 == false) goto L6;
        r11.setVisibility(8);
    L9:
        h0 r15 = new h0(this, r27);
        this.s = r15;
        r9.setLayoutManager(r15);
        r9.setAdapter(r2);
        r9.setOverScrollMode(2);
        if ((r9.getItemAnimator() instanceof SimpleItemAnimator) == false) goto L12;
        r9.getItemAnimator().setSupportsChangeAnimations(false);
    L12:
        r2.y2(DeleteBean.class, new FeedItemDelete(new f(this), new g(this)));
        r2.y2(FeedTipsModel.class, new eg5.b());
        com.bytedance.ee.bear.middleground.comment.export.n r16 = (com.bytedance.ee.bear.middleground.comment.export.n) org.koin.java.a.a(com.bytedance.ee.bear.middleground.comment.export.n.class);
        r5.e.getDocumentType();
        com.bytedance.ee.bear.middleground.comment.cell.i r19 = r16.b(r27, new i0(this), new j0(this), new y(this));
        String r17 = r5.e();
        TranslateConfig r18 = r5.e.getTranslateConfig();
        ?? r110 = new h(this);
        ?? r111 = new i(this);
        ?? r20 = new j(this);
        if (r5.e.getDocumentType() == sbb.e.l) goto L15;
        boolean r23 = true;
    L16:
        r2.y2(FeedCommentDetailBean.class, new FeedItemComment(r17, r18, r19, r110, r111, r20, r23));
        r2.y2(AtBean.class, new FeedItemMention(new k(this), new m(this)));
        r2.y2(ShareBean.class, new FeedItemShare(new n(this)));
        r2.y2(UnknownBean.class, new FeedItemUnknown());
        r10.setConfig((Config) new FeedPanelStatusConfig(r27, ((com.bytedance.ee.bear.contract.i0) org.koin.java.a.a(com.bytedance.ee.bear.contract.i0.class)).a()).c.invoke());
        if (r5.k() == false) goto L19;
        r8.setText(2131886420);
        r12.setVisibility(0);
        r12.setOnClickListener(new e(this));
    L20:
        if (r4 == true) goto L22;
        r11.setOnClickListener(new c0(this));
    L22:
        r14.h = new dg5.b(this);
        r10.setOnRetryListener(new c(this));
        r6.setOnClickListener(new d0(this));
        r7.setOnClickListener(new d());
        r9.addOnScrollListener(new e0(this));
        r13.setOnClickListener(new f0(this));
        return;
    L19:
        r8.setText(2131887856);
        r12.setVisibility(8);
        goto L20
    L15:
        r23 = false;
        goto L16
    L6:
        if (r5.e.isLoadingSuccess() == false) goto L8;
        r11.setVisibility(8);
        goto L9
    L8:
        r11.setVisibility(0);
        goto L9
    }
}
