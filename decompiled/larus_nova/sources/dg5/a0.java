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
import com.bytedance.ee.bear.facade.common.empty.EmptyView;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.comment.export.CommentStyle;
import com.bytedance.ee.bear.middleground.comment.export.bean.TranslateConfig;
import com.bytedance.ee.bear.middleground.feed.export.bean.AtBean;
import com.bytedance.ee.bear.middleground.feed.export.bean.DeleteBean;
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
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Triple;

/* JADX INFO: loaded from: classes18.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FragmentActivity f468394a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewGroup f468395b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f468396c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f468397d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f468398e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f468399f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final RecyclerView f468400g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final View f468401h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final SpaceEmptyState f468402i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final com.bytedance.ee.bear.facade.common.widget.d f468403j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final MultiAdapter f468404k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final d1 f468405l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final com.bytedance.ee.bear.facade.common.empty.c f468406m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final uu5.d<Triple<List<MultiBean>, String, Boolean>> f468407n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ImageView f468408o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f468409p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f468410q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final q f468411r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public h0 f468412s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int f468413t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f468414u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final List<b> f468415v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final boolean f468416w;

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
        public final List<String> f468417a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a0 f468418b;

        @Override // java.lang.Runnable
        public final void run() {
            tt5.a.h("PanelView", "read message: Comment");     // Catch: Throwable -> L4
            this.f468418b.f468405l.i(this.f468417a);     // Catch: Throwable -> L4
            ((ArrayList) this.f468418b.f468415v).remove(this);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(a0 r100, List<String> r101) {
            this.f468418b = r100;
            this.f468417a = r101;
        }
    }

    public final boolean f() {
        if (this.f468396c.getParent() == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final void g() {
        if (this.f468394a.getResources().getConfiguration().orientation != 2) goto L5;
        this.f468403j.getClass();
        com.bytedance.ee.bear.facade.common.widget.d.f226583p = 0.2f;
        com.bytedance.ee.bear.facade.common.widget.d.f226584q = 0.6928f;
        com.bytedance.ee.bear.facade.common.widget.d.f226585r = 1.0f;
        return;
    L5:
        this.f468403j.getClass();
        com.bytedance.ee.bear.facade.common.widget.d.h();
    }

    public final boolean h() {
        boolean r100 = this.f468405l.f468432e.isSupportMute();
        if (this.f468405l.f468435h.getValue() == null) goto L5;
        boolean r101 = true;
    L6:
        boolean r102 = this.f468405l.k();
        if (r100 == false) goto L13;
        if (r101 == false) goto L13;
        if (this.f468409p == false) goto L13;
        if (r102 == true) goto L13;
        return true;
    L13:
        return false;
    L5:
        r101 = false;
        goto L6
    }

    public final sa5.b c() {
        if (ForsetiHelper.p() == false) goto L7;
        FragmentActivity r100 = this.f468394a;
        ViewGroup r101 = this.f468395b;
        int r102 = sa5.n.f541175a;
        sa5.o.f541176q2.getClass();
        return (sa5.b) sa5.o.a.a(sa5.b.class, r100, r101);
    L7:
        return (sa5.b) sa5.m.a.a(this.f468394a, sa5.b.class);
    }

    public static PermissionResponse d(MessageConfig r100) {
        BaseEntity r101 = new BaseEntity(r100.getToken(), r100.getDocumentType(), BizDomain.FileBizDomainCCM, "");
        return ((ph5.b) org.koin.java.a.a(ph5.b.class)).f(new PermissionRequest(r101, "CONTENT_COPY"), null);
    }

    public final void b(Configuration r100) {
        ConstraintLayout.LayoutParams r101 = (ConstraintLayout.LayoutParams) this.f468397d.getLayoutParams();
        ConstraintLayout.LayoutParams r102 = (ConstraintLayout.LayoutParams) this.f468398e.getLayoutParams();
        ViewGroup.MarginLayoutParams r103 = (ViewGroup.MarginLayoutParams) this.f468399f.getLayoutParams();
        if (r100.orientation == 2) goto L5;
    L7:
        ((ViewGroup.MarginLayoutParams) r101).width = -1;
        ((ViewGroup.MarginLayoutParams) r102).width = -1;
        r103.leftMargin = 0;
        r103.rightMargin = 0;
    L8:
        this.f468397d.setLayoutParams(r101);
        this.f468398e.setLayoutParams(r102);
        this.f468399f.setLayoutParams(r103);
        return;
    L5:
        if (ku5.c.k(this.f468394a) == true) goto L7;
        int r104 = (int) (com.bytedance.ee.util.ui.n.q(this.f468399f.getContext()) * 0.7f);
        ((ViewGroup.MarginLayoutParams) r101).width = r104;
        ((ViewGroup.MarginLayoutParams) r102).width = r104;
        int r105 = this.f468413t;
        r103.leftMargin = r105;
        r103.rightMargin = r105;
        goto L8
    }

    public final void e(boolean r100) {
        tt5.a.h("PanelView", "hide message");
        this.f468405l.f468431d.b(false, r100);
        d1 r101 = this.f468405l;
        FragmentActivity r102 = this.f468394a;
        r101.getClass();
        bg5.a.k("cancel", DocFeed$Value$ResultCode.RESULT_CODE_CANCEL);
        bg5.a.p();
        r101.f468433f.removeObservers(r102);
        r101.f468434g.removeObservers(r102);
        r101.f468432e.setAuto(false);
        ((ConcurrentHashMap) r101.f468442o.f549919a).clear();
        r101.g(r101.f468432e.isOwner(), "");
        d1 r103 = this.f468405l;
        Triple<List<MultiBean>, String, Boolean> r104 = r103.f468433f.getValue();
        if (r104 == null) goto L5;
        r103.f468433f.setValue(new Triple(r104.getFirst(), r104.getSecond(), Boolean.TRUE));
    L5:
        Iterator r105 = new ArrayList(this.f468415v).iterator();
    L7:
        if (r105.hasNext() == false) goto L9;
        b r106 = (b) r105.next();
        this.f468400g.removeCallbacks(r106);
        r106.run();
        goto L7
    L9:
        ((ArrayList) this.f468404k.f232617c).clear();
        this.f468404k.notifyDataSetChanged();
        this.f468403j.getClass();
        com.bytedance.ee.bear.facade.common.widget.d.h();
        this.f468403j.f();
        this.f468396c.setTranslationX(0.0f);
        this.f468396c.setTranslationY(0.0f);
        sa5.b r107 = c();
        if (r107 == null) goto L13;
        r107.d(this.f468411r);
    L13:
        if (this.f468396c.getParent() == null) goto L18;
        ViewGroup r108 = this.f468395b;
        if (r108 == null) goto L17;
        r108.removeView(this.f468396c);
        goto L18
    L17:
        ((ViewGroup) this.f468394a.findViewById(R.id.content)).removeView(this.f468396c);
    L18:
        bg5.a.o();
    }

    public final boolean i(String r110) {
        d1 r100 = this.f468405l;
        FragmentActivity r101 = this.f468394a;
        r100.getClass();
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.mobile.feed.notification_optimization") == true) goto L89;
        Iterator<MessageBean> r102 = r100.f468439l.getData().getMessage().iterator();     // Catch: Exception -> L80
    L34:
        if (r102.hasNext() == false) goto L39;
        MessageBean r103 = r102.next();     // Catch: Exception -> L80
        if (r110.equals(r103.getMessageId()) == false) goto L34;
    L40:
        if (r103 != null) goto L43;
        tt5.a.d("PanelViewModel", "can't found messageId:" + r110);     // Catch: Exception -> L80
    L95:
        return false;
    L43:
        tt5.a.h("PanelViewModel", "at:" + r103.getType() + " messageId:" + r110 + " isWhole:" + r103.getIs_whole() + " commentId:" + r103.getComment_id() + " replyId:" + r103.getReply_id());     // Catch: Exception -> L80
        if (MessageBean.MESSAGE_DOC_COMMENT.equals(r103.getType()) == false) goto L70;
        r103.getComment_id();     // Catch: Exception -> L80
        if (r103.isHasCommentPermission() == true) goto L49;
        Toast.showText(r101, com.larus.nova.R.string.LarkCCM_Docs_CommentPerm_AccessRemoved_Toast);     // Catch: Exception -> L80
    L74:
        boolean r104 = false;
    L84:
        return r104;
    L49:
        if (r103.getDelete() != 1) goto L52;
        Toast.showText(r101, com.larus.nova.R.string.Doc_Feed_Comment_Delete);     // Catch: Exception -> L80
        goto L74
    L52:
        if (r103.getFinish() != 1) goto L55;
        Toast.showText(r101, com.larus.nova.R.string.Doc_Feed_Comment_Resolve);     // Catch: Exception -> L80
        goto L74
    L55:
        if (r103.isOriginContentDelete() == false) goto L57;
        Toast.showText(r101, com.larus.nova.R.string.Doc_Feed_Comment_OriginText_Deleted);     // Catch: Exception -> L80
        goto L74
    L57:
        ((com.bytedance.ee.bear.middleground.comment.export.n) org.koin.java.a.a(com.bytedance.ee.bear.middleground.comment.export.n.class)).f().getClass();     // Catch: Exception -> L80
        if (com.bytedance.ee.bear.middleground.comment.card.a.f230870c != CommentStyle.FLOAT) goto L60;
        boolean r105 = true;
    L61:
        if (r105 == true) goto L63;
    L66:
        r100.f468431d.e(r103);     // Catch: Exception -> L78
    L86:
    L77:
        r104 = true;
        goto L84
    L63:
        if (r103.getIs_whole() != 0) goto L66;
        r100.f468431d.e(r103);     // Catch: Exception -> L80
        goto L77
    L60:
        r105 = false;
        goto L61
    L70:
        if (MessageBean.MESSAGE_DOC_MENTION.equals(r103.getType()) == true) goto L72;
        r100.f468431d.e(r103);     // Catch: Exception -> L78
        goto L86
    L72:
        if (r103.isOriginContentDelete() == false) goto L75;
        Toast.showText(r101, com.larus.nova.R.string.Doc_Feed_At_OriginText_Deleted);     // Catch: Exception -> L80
        goto L74
    L75:
        r100.f468431d.e(r103);     // Catch: Exception -> L78
    L78:
        e = e;
        boolean r106 = false;
        r104 = true;
    L82:
        tt5.a.f("PanelViewModel", e, r106);
        goto L84
    L39:
        r103 = null;
    L80:
        e = e;
        r106 = false;
        r104 = false;
        goto L82
    L89:
        Iterator<MessageBean> r107 = r100.f468439l.getData().getMessage().iterator();     // Catch: Exception -> L30
    L6:
        if (r107.hasNext() == false) goto L10;
        MessageBean r111 = r107.next();     // Catch: Exception -> L30
        if (TextUtils.equals(r110, r111.getMessageId()) == false) goto L6;
        MessageBean r108 = r111;
    L11:
        if (r108 != null) goto L13;
        tt5.a.d("PanelViewModel", "can't found messageId:" + r110);     // Catch: Exception -> L30
        goto L95
    L13:
        r100.f468431d.k();     // Catch: Exception -> L30
        tt5.a.h("PanelViewModel", "at:" + r108.getType() + " messageId:" + r110 + " isWhole:" + r108.getIs_whole() + " commentId:" + r108.getComment_id() + " replyId:" + r108.getReply_id());     // Catch: Exception -> L30
        if (MessageBean.MESSAGE_DOC_COMMENT.equals(r108.getType()) == false) goto L26;
        if (r108.isHasCommentPermission() == true) goto L19;
        Toast.showText(r101, com.larus.nova.R.string.LarkCCM_Docs_CommentPerm_AccessRemoved_Toast);     // Catch: Exception -> L30
        goto L95
    L19:
        if (r108.getDelete() != 1) goto L22;
        Toast.showText(r101, com.larus.nova.R.string.Doc_Feed_Comment_Delete);     // Catch: Exception -> L30
        goto L95
    L22:
        if (r108.getFinish() != 1) goto L24;
        Toast.showText(r101, com.larus.nova.R.string.Doc_Feed_Comment_Resolve);     // Catch: Exception -> L30
        goto L95
    L24:
        r100.f468431d.e(r108);     // Catch: Exception -> L30
        goto L95
    L26:
        if (MessageBean.MESSAGE_DOC_MENTION.equals(r108.getType()) == false) goto L28;
        r100.f468431d.e(r108);     // Catch: Exception -> L30
        goto L95
    L28:
        r100.f468431d.e(r108);     // Catch: Exception -> L30
        goto L95
    L10:
        r108 = null;
    L30:
        e = move-exception;
        tt5.a.e("PanelViewModel", "toMessageV2 error!", e, false);
        goto L95
    }

    public static void a(a0 r100, h0 r101) {
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
        if (r106 >= r100.f468404k.getItemCount()) goto L16;
        MultiBean r107 = (MultiBean) ListProtector.get(r100.f468404k.f232617c, r106);
        if ((r107 instanceof com.bytedance.ee.bear.middleground.feed.export.bean.c) == false) goto L16;
        com.bytedance.ee.bear.middleground.feed.export.bean.c r108 = (com.bytedance.ee.bear.middleground.feed.export.bean.c) r107;
        r105.add(r108.getMessageId());
        if (r108.getReadStatus() != 1) goto L16;
        r104.add(r108.getMessageId());
    L16:
        r106 = r106 + 1;
        goto L4
    L17:
        tt5.a.h("PanelView", "emitVisibleItems firstPosition:" + r102 + " lastPosition:" + r103 + " visibleIds:" + r105 + " unreadIds:" + r104);
        if (r104.isEmpty() == true) goto L28;
        b r109 = new b(r100, r104);
        ((ArrayList) r100.f468415v).add(r109);
        r100.f468400g.postDelayed(r109, 2000);
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
    public a0(FragmentActivity r210, ViewGroup r211, com.bytedance.ee.bear.middleground.feed.export.bean.g r212, com.bytedance.ee.bear.middleground.feed.export.bean.i r310, MessageConfig r311) {
        MultiAdapter r100 = new MultiAdapter();
        this.f468404k = r100;
        this.f468407n = new uu5.d(200, new l(this));
        com.bytedance.ee.bear.appsetting.c r101 = com.bytedance.ee.bear.appsetting.c.a.f206237a;
        this.f468409p = r101.g("ccm.message.mute");
        this.f468410q = r101.g("ccm.message.allread");
        this.f468411r = new q(this);
        this.f468414u = false;
        this.f468415v = new ArrayList();
        this.f468394a = r210;
        this.f468395b = r211;
        boolean r102 = r101.g("ccm.mobile.feed.notification_optimization");
        this.f468416w = r102;
        d1 r103 = new d1(r212, r310, r311, r210);
        this.f468405l = r103;
        View r104 = LayoutInflater.from(r210).inflate(com.larus.nova.R.layout.midele_feed_panel_layout, null);
        this.f468396c = r104;
        r104.setOnGenericMotionListener(new a());
        View r105 = r104.findViewById(com.larus.nova.R.id.v_bg);
        this.f468397d = r105;
        this.f468398e = r104.findViewById(com.larus.nova.R.id.shadow_layout);
        TextView r106 = (TextView) r104.findViewById(com.larus.nova.R.id.tv_page_title);
        this.f468399f = r104.findViewById(com.larus.nova.R.id.layout_content);
        RecyclerView r107 = (RecyclerView) r104.findViewById(com.larus.nova.R.id.rl_content);
        this.f468400g = r107;
        r107.setNestedScrollingEnabled(false);
        EmptyView r110 = (EmptyView) r104.findViewById(com.larus.nova.R.id.list_no_data_tip);
        View r111 = r104.findViewById(com.larus.nova.R.id.mask_view);
        this.f468401h = r111;
        ImageView r112 = (ImageView) r104.findViewById(com.larus.nova.R.id.close_btn);
        ImageView r113 = (ImageView) r104.findViewById(com.larus.nova.R.id.more_btn);
        this.f468408o = r113;
        com.bytedance.ee.bear.facade.common.widget.d r114 = new com.bytedance.ee.bear.facade.common.widget.d(r210, r105);
        this.f468403j = r114;
        this.f468406m = new com.bytedance.ee.bear.facade.common.empty.c(r110, r107);
        this.f468402i = (SpaceEmptyState) r104.findViewById(com.larus.nova.R.id.no_auth_view);
        this.f468413t = com.bytedance.ee.util.ui.n.d(16);
        r114.f();
        r114.i(r104.findViewById(com.larus.nova.R.id.rl_title));
        if (r102 == false) goto L6;
        r111.setVisibility(8);
    L9:
        h0 r108 = new h0(this, r210);
        this.f468412s = r108;
        r107.setLayoutManager(r108);
        r107.setAdapter(r100);
        r107.setOverScrollMode(2);
        if ((r107.getItemAnimator() instanceof SimpleItemAnimator) == false) goto L12;
        ((SimpleItemAnimator) r107.getItemAnimator()).setSupportsChangeAnimations(false);
    L12:
        r100.y2(DeleteBean.class, new FeedItemDelete(new f(this), new g(this)));
        r100.y2(FeedTipsModel.class, new eg5.b());
        com.bytedance.ee.bear.middleground.comment.export.n r109 = (com.bytedance.ee.bear.middleground.comment.export.n) org.koin.java.a.a(com.bytedance.ee.bear.middleground.comment.export.n.class);
        r103.f468432e.getDocumentType();
        com.bytedance.ee.bear.middleground.comment.cell.i r115 = r109.b(r210, new i0(this), new j0(this), new y(this));
        String r116 = r103.e();
        TranslateConfig r117 = r103.f468432e.getTranslateConfig();
        ?? r118 = new h(this);
        ?? r119 = new i(this);
        ?? r120 = new j(this);
        if (r103.f468432e.getDocumentType() == sbb.e.f541301l) goto L15;
        boolean r213 = true;
    L16:
        r100.y2(FeedCommentDetailBean.class, new FeedItemComment(r116, r117, r115, r118, r119, r120, r213));
        r100.y2(AtBean.class, new FeedItemMention(new k(this), new m(this)));
        r100.y2(ShareBean.class, new FeedItemShare(new n(this)));
        r100.y2(UnknownBean.class, new FeedItemUnknown());
        r110.setConfig(new FeedPanelStatusConfig(r210, ((com.bytedance.ee.bear.contract.i0) org.koin.java.a.a(com.bytedance.ee.bear.contract.i0.class)).a()).f232708c.invoke());
        if (r103.k() == false) goto L19;
        r106.setText(com.larus.nova.R.string.Bitable_FeedCenter_InBase_EarlierNotifcations_Title);
        r112.setVisibility(0);
        r112.setOnClickListener(new e(this));
    L20:
        if (r102 == true) goto L22;
        r111.setOnClickListener(new c0(this));
    L22:
        r114.f226593h = new dg5.b(this);
        r110.setOnRetryListener(new c(this));
        r104.setOnClickListener(new d0(this));
        r105.setOnClickListener(new d());
        r107.addOnScrollListener(new e0(this));
        r113.setOnClickListener(new f0(this));
        return;
    L19:
        r106.setText(com.larus.nova.R.string.Doc_Feed_FeedTitle);
        r112.setVisibility(8);
        goto L20
    L15:
        r213 = false;
        goto L16
    L6:
        if (r103.f468432e.isLoadingSuccess() == false) goto L8;
        r111.setVisibility(8);
        goto L9
    L8:
        r111.setVisibility(0);
        goto L9
    }
}
