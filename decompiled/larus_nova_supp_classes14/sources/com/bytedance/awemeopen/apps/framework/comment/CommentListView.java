package com.bytedance.awemeopen.apps.framework.comment;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialog;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.store.mall.follows.basic.BaseFollowStoreViewModel;
import com.bytedance.awemeopen.apps.framework.AosExtConfig;
import com.bytedance.awemeopen.apps.framework.AosPhotoRefactorService;
import com.bytedance.awemeopen.apps.framework.base.view.AbstractLoadingLayout;
import com.bytedance.awemeopen.apps.framework.base.view.refresh.DmtStatusView;
import com.bytedance.awemeopen.apps.framework.base.view.verticalviewPager.VerticalViewPager;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.bytedance.awemeopen.apps.framework.comment.report.AosCommentPassDialog;
import com.bytedance.awemeopen.apps.framework.comment.view.CommentListAdapter;
import com.bytedance.awemeopen.apps.framework.comment.view.commentimage.AosCommentImageContainer;
import com.bytedance.awemeopen.apps.framework.comment.view.commentimage.CommentImageView;
import com.bytedance.awemeopen.apps.framework.comment.view.commentimage.SlidesImagePageAdapter;
import com.bytedance.awemeopen.apps.framework.comment.view.holder.CommentReplyButtonViewHolder;
import com.bytedance.awemeopen.apps.framework.comment.view.widget.CommentLoadingLayout;
import com.bytedance.awemeopen.apps.framework.comment.write.WriteCommentEntranceView;
import com.bytedance.awemeopen.apps.framework.comment.write.viewmodel.CommentInputContentViewModel;
import com.bytedance.awemeopen.apps.framework.feed.AosEventReporter;
import com.bytedance.awemeopen.apps.framework.framework.eventbus.LiveDataBus;
import com.bytedance.awemeopen.apps.framework.framework.loadmoreadapter.HeaderAndFooterWrapper;
import com.bytedance.awemeopen.apps.framework.framework.loadmoreadapter.LoadMoreRecyclerViewAdapter;
import com.bytedance.awemeopen.apps.framework.framework.loadmoreadapter.WrapLinearLayoutManager;
import com.bytedance.awemeopen.apps.framework.utils.t;
import com.bytedance.awemeopen.apps.framework.utils.v;
import com.bytedance.awemeopen.bizmodels.profile.User;
import com.bytedance.awemeopen.infra.base.settings.AoSettings;
import com.bytedance.awemeopen.infra.util.NetworkUtils;
import com.bytedance.awemeopen.infra.util.ToastUtils;
import com.bytedance.awemeopen.search.serviceapi.AoSearchService;
import com.bytedance.bdp.bdpbase.manager.BdpManager;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0001zB\u0011\b\u0016\u0012\u0006\u0010t\u001a\u00020s¢\u0006\u0004\bu\u0010vB\u001b\b\u0016\u0012\u0006\u0010t\u001a\u00020s\u0012\b\u0010x\u001a\u0004\u0018\u00010w¢\u0006\u0004\bu\u0010yJ\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u000e\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\u000f\u001a\u00020\u000eJ\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0014\u0010\u0016\u001a\u00020\b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u0014R$\u0010\u001e\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010&\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R$\u0010.\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R$\u00106\u001a\u0004\u0018\u00010/8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R$\u0010=\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R$\u0010E\u001a\u0004\u0018\u00010>8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR$\u0010I\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bF\u00108\u001a\u0004\bG\u0010:\"\u0004\bH\u0010<R$\u0010P\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR$\u0010T\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bQ\u0010\u0019\u001a\u0004\bR\u0010\u001b\"\u0004\bS\u0010\u001dR$\u0010X\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bU\u00108\u001a\u0004\bV\u0010:\"\u0004\bW\u0010<R$\u0010\\\u001a\u0004\u0018\u00010/8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bY\u00101\u001a\u0004\bZ\u00103\"\u0004\b[\u00105R$\u0010d\u001a\u0004\u0018\u00010]8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b^\u0010_\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR$\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\be\u0010f\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR$\u0010r\u001a\u0004\u0018\u00010k8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bl\u0010m\u001a\u0004\bn\u0010o\"\u0004\bp\u0010q¨\u0006{"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/comment/CommentListView;", "Landroid/widget/FrameLayout;", "", "Lcom/bytedance/awemeopen/apps/framework/comment/view/d;", "Lcom/bytedance/awemeopen/apps/framework/comment/view/c;", "Lcom/bytedance/awemeopen/apps/framework/comment/j;", "Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/model/b;", "mPageOwner", "", "setWriteCommentView", "setPageOwner", "Landroid/view/View;", "view", "setupOpenSearch", "", "getMaxConsumeMainCommentCount", "Lcom/bytedance/awemeopen/apps/framework/comment/CommentPageParam;", "getPageParam", "Lcom/bytedance/awemeopen/apps/framework/comment/view/CommentListAdapter;", "getAdapter", "Lkotlin/Function0;", "closeAction", "setCloseCommentButton", "Landroid/widget/TextView;", "c", "Landroid/widget/TextView;", "getMTitleView", "()Landroid/widget/TextView;", "setMTitleView", "(Landroid/widget/TextView;)V", "mTitleView", "Lcom/bytedance/awemeopen/apps/framework/comment/view/widget/CommentLoadingLayout;", "d", "Lcom/bytedance/awemeopen/apps/framework/comment/view/widget/CommentLoadingLayout;", "getMLoadingLayout", "()Lcom/bytedance/awemeopen/apps/framework/comment/view/widget/CommentLoadingLayout;", "setMLoadingLayout", "(Lcom/bytedance/awemeopen/apps/framework/comment/view/widget/CommentLoadingLayout;)V", "mLoadingLayout", "Landroidx/recyclerview/widget/RecyclerView;", "e", "Landroidx/recyclerview/widget/RecyclerView;", "getMRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setMRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "mRecyclerView", "Landroid/view/ViewGroup;", "f", "Landroid/view/ViewGroup;", "getMCommentConstraintWrap", "()Landroid/view/ViewGroup;", "setMCommentConstraintWrap", "(Landroid/view/ViewGroup;)V", "mCommentConstraintWrap", "g", "Landroid/view/View;", "getMForbidCommentView", "()Landroid/view/View;", "setMForbidCommentView", "(Landroid/view/View;)V", "mForbidCommentView", "Landroid/view/ViewStub;", "h", "Landroid/view/ViewStub;", "getMForbidViewStub", "()Landroid/view/ViewStub;", "setMForbidViewStub", "(Landroid/view/ViewStub;)V", "mForbidViewStub", "i", "getMCloseCommentButton", "setMCloseCommentButton", "mCloseCommentButton", "j", "Landroid/widget/FrameLayout;", "getMTvCommentSuctionWordContainer", "()Landroid/widget/FrameLayout;", "setMTvCommentSuctionWordContainer", "(Landroid/widget/FrameLayout;)V", "mTvCommentSuctionWordContainer", "k", "getMTvCommentSuctionWordTitle", "setMTvCommentSuctionWordTitle", "mTvCommentSuctionWordTitle", "l", "getMIvCommentSuctionClose", "setMIvCommentSuctionClose", "mIvCommentSuctionClose", "m", "getMWriteComment", "setMWriteComment", "mWriteComment", "Landroid/app/Activity;", "C", "Landroid/app/Activity;", "getHostActivity", "()Landroid/app/Activity;", "setHostActivity", "(Landroid/app/Activity;)V", "hostActivity", "D", "Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/model/b;", "getMPageOwner", "()Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/model/b;", "setMPageOwner", "(Lcom/bytedance/awemeopen/apps/framework/feed/pages/recommend/model/b;)V", "Lcom/bytedance/awemeopen/apps/framework/comment/write/viewmodel/CommentInputContentViewModel;", "E", "Lcom/bytedance/awemeopen/apps/framework/comment/write/viewmodel/CommentInputContentViewModel;", "getInputContentViewModel", "()Lcom/bytedance/awemeopen/apps/framework/comment/write/viewmodel/CommentInputContentViewModel;", "setInputContentViewModel", "(Lcom/bytedance/awemeopen/apps/framework/comment/write/viewmodel/CommentInputContentViewModel;)V", "inputContentViewModel", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class CommentListView extends FrameLayout implements ux3.b, com.bytedance.awemeopen.apps.framework.comment.view.d, com.bytedance.awemeopen.apps.framework.comment.view.c, j {
    public static final /* synthetic */ int H = 0;
    public int A;
    public final Observer<ny3.a> B;
    public Activity C;
    public com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b D;
    public CommentInputContentViewModel E;
    public AosCommentImageContainer F;
    public final my3.d G;
    public CommentPageParam a;
    public zz3.h b;
    public TextView c;
    public CommentLoadingLayout d;
    public RecyclerView e;
    public ViewGroup f;
    public View g;
    public ViewStub h;
    public View i;
    public FrameLayout j;
    public TextView k;
    public View l;
    public ViewGroup m;
    public boolean n;
    public CommentListAdapter o;
    public com.bytedance.awemeopen.apps.framework.comment.write.b p;
    public final boolean q;
    public int r;
    public int s;
    public int t;
    public boolean u;
    public final ky3.a v;
    public ny3.d w;
    public ny3.c x;
    public ny3.h y;
    public AosCommentPassDialog z;

    public static final class a {
    }

    public static final class b implements AbstractLoadingLayout.a {
        public final /* synthetic */ CommentListView a;

        @Override // com.bytedance.awemeopen.apps.framework.base.view.AbstractLoadingLayout.a
        public final void b(CommentLoadingLayout r2) {
            Intrinsics.checkNotNullParameter(r2, "layout");
        }

        public b(CommentListView r1) {
            this.a = r1;
        }

        @Override // com.bytedance.awemeopen.apps.framework.base.view.AbstractLoadingLayout.a
        public final void a(CommentLoadingLayout r2) {
            Intrinsics.checkNotNullParameter(r2, "layout");
            CommentListView r3 = this.a;
            ny3.d r0 = r3.w;
            if (r0 == null) goto L6;
            r0.b(r3.a.a);
            return;
        }
    }

    public static final class c implements AosCommentPassDialog.a {
        public final /* synthetic */ CommentListView a;
        public final /* synthetic */ o14.a b;

        public static final class a implements p24.a {
            public final /* synthetic */ CommentListView a;
            public final /* synthetic */ o14.a b;

            public final void onFail(Exception r2) {
                ToastUtils.c(y54.a.a(), "删除评论失败");
            }

            public final void onSuccess(Object r15) {
                Intrinsics.checkNotNullParameter((o14.d) r15, "data");
                ToastUtils.c(y54.a.a(), "删除成功");
                ky3.a r16 = this.a.v;
                o14.a r0 = this.b;
                r16.getClass();
                Intrinsics.checkNotNullParameter(r0, "comment");
                List<o14.a> r1 = r16.b;
                Pair r5 = null;
                if (r1 == null) goto L62;
                ArrayList r6 = (ArrayList) r1;
                Iterator r7 = r6.iterator();
                int r8 = 0;
                int r9 = 0;
            L7:
                if (r7.hasNext() == false) goto L12;
                if (Intrinsics.areEqual(((o14.a) r7.next()).cid, r0.cid) == true) goto L13;
                r9 = r9 + 1;
            L13:
                if (r9 < 0) goto L62;
                if (r9 >= r6.size()) goto L62;
                int r10 = r0.a;
                if (r10 != 2) goto L41;
                int r17 = r9;
            L20:
                r17 = r17 - 1;
                if (r17 < 0) goto L25;
                o14.a r11 = (o14.a) ListProtector.get(r1, r17);
                if (r11.a != 1) goto L20;
            L26:
                if (r11 == null) goto L31;
                List r18 = r11.replyComments;
                if (r18 == null) goto L30;
                r18.remove(r0);
            L30:
                r11.replyCommentTotal--;
            L31:
                int r19 = r9;
            L32:
                r19 = r19 + 1;
                if (r19 >= r6.size()) goto L38;
                Pair r2 = (o14.a) ListProtector.get(r1, r19);
                if (((o14.a) r2).a == 2) goto L32;
                r5 = r2;
            L38:
                if ((r5 instanceof ky3.b) == false) goto L40;
                ((o14.a) ((ky3.b) r5)).replyCommentTotal--;
            L40:
                ListProtector.remove(r1, r9);
            L61:
                r5 = new Pair(Integer.valueOf(r9), -1);
                goto L62
            L25:
                r11 = null;
                goto L26
            L41:
                if (r10 != 1) goto L61;
                CopyOnWriteArrayList<o14.a> r110 = r16.a;
                Intrinsics.checkNotNull(r110);
                Iterator<o14.a> r12 = r110.iterator();
            L44:
                if (r12.hasNext() == false) goto L49;
                if (Intrinsics.areEqual(r12.next().cid, r0.cid) == true) goto L50;
                r8 = r8 + 1;
            L50:
                if (r8 >= 0) goto L52;
            L54:
                int r111 = r9;
            L55:
                r111 = r111 + 1;
                if (r111 >= r6.size()) goto L59;
                if (((o14.a) ListProtector.get(r1, r111)).a != 1) goto L55;
            L59:
                if (r111 <= r9) goto L61;
                r6.subList(r9, r111).clear();
                r5 = new Pair(Integer.valueOf(r9), Integer.valueOf(r111));
                goto L62
            L52:
                if (r8 >= r110.size()) goto L54;
                r110.remove(r8);
                goto L54
            L49:
                r8 = -1;
                goto L50
            L12:
                r9 = -1;
            L62:
                if (r5 == null) goto L86;
                o14.a r112 = this.b;
                if (r112.a != 1) goto L68;
                zz3.h r3 = this.a.b;
                if (r3 == null) goto L71;
                r3.b((r3.a() - r112.replyCommentTotal) - 1);
            L71:
                CommentListView r113 = this.a;
                CommentListAdapter r4 = r113.o;
                List<o14.a> r114 = r113.v.b;
                if (r4 == null) goto L86;
                if (r114 == null) goto L86;
                if ((!((ArrayList) r114).isEmpty()) == false) goto L82;
                int r115 = ((Number) r5.getFirst()).intValue();
                int r13 = ((Number) r5.getSecond()).intValue();
                if (this.b.a != 1) goto L81;
                if (r13 <= r115) goto L80;
                r4.notifyItemRangeRemoved(r115, r13 - r115);
                goto L86
            L80:
                r4.notifyItemRemoved(r115);
                goto L86
            L81:
                r4.notifyItemRemoved(r115);
                goto L86
            L82:
                List<T> r116 = r4.l;
                if (r116 == 0) goto L85;
                r116.clear();
                r4.notifyDataSetChanged();
            L85:
                this.a.r6();
                goto L86
            L68:
                zz3.h r117 = this.a.b;
                if (r117 == null) goto L71;
                r117.b(r117.a() - 1);
            L86:
                LinkedHashMap r14 = new LinkedHashMap();
                r14.put("enter_from", this.a.a.g);
                r14.put("enter_method", "long_press");
                r14.put("author_openid", this.a.a.b);
                r14.put("group_id", this.a.a.a);
                r14.put("comment_id", this.b.cid);
                int r118 = o14.a.c;
                r14.put("comment_category", o14.a.a.a(this.b));
                AosEventReporter.s(AosEventReporter.a, "delete_comment", r14, null, null, null, 28);
            }

            public a(CommentListView r1, o14.a r2) {
                this.a = r1;
                this.b = r2;
            }
        }

        @Override // com.bytedance.awemeopen.apps.framework.comment.report.AosCommentPassDialog.a
        public final void a() {
            CommentListView r0 = this.a;
            my3.d r1 = r0.G;
            o14.a r2 = this.b;
            String r3 = r2.cid;
            a r4 = new a(r0, r2);
            r1.getClass();
            Intrinsics.checkNotNullParameter(r3, "commentId");
            Intrinsics.checkNotNullParameter(r4, "callback");
            d14.a r5 = b14.a.a;
            b14.a.a(p24.e.class).J1(y54.a.a(), r3, r4);
        }

        public c(CommentListView r1, o14.a r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class d extends com.bytedance.awemeopen.apps.framework.comment.write.a {
        public final /* synthetic */ CommentListView a;

        public d(CommentListView r1) {
            this.a = r1;
        }

        @Override // com.bytedance.awemeopen.apps.framework.comment.write.e
        public final void c(o14.b r4) {
            Intrinsics.checkNotNullParameter(r4, "result");
            CommentInputContentViewModel r0 = this.a.getInputContentViewModel();
            o14.a r1 = null;
            if (r0 == null) goto L5;
            MutableLiveData<Integer> r2 = r0.getPublishSuccessLiveData();
        L6:
            if (r2 == null) goto L17;
            CommentInputContentViewModel r3 = this.a.getInputContentViewModel();
            if (r3 == null) goto L15;
            MutableLiveData<Integer> r5 = r3.getPublishSuccessLiveData();
            if (r5 == null) goto L15;
            Integer r6 = (Integer) r5.getValue();
            if (r6 == null) goto L15;
            Integer r7 = Integer.valueOf(r6.intValue() + 1);
        L16:
            r2.setValue(r7);
        L15:
            r7 = null;
        L17:
            CommentListView r8 = this.a;
            o14.c r9 = r4.e();
            if (r9 == null) goto L20;
            r1 = r9.a();
        L20:
            r8.q(r1);
            return;
        L5:
            r2 = null;
            goto L6
        }
    }

    public static final class e extends com.bytedance.awemeopen.apps.framework.comment.write.a {
        public final /* synthetic */ CommentListView a;

        public e(CommentListView r1) {
            this.a = r1;
        }

        @Override // com.bytedance.awemeopen.apps.framework.comment.write.e
        public final void c(o14.b r4) {
            Intrinsics.checkNotNullParameter(r4, "result");
            CommentInputContentViewModel r0 = this.a.getInputContentViewModel();
            o14.a r1 = null;
            if (r0 == null) goto L5;
            MutableLiveData<Integer> r2 = r0.getPublishSuccessLiveData();
        L6:
            if (r2 == null) goto L17;
            CommentInputContentViewModel r3 = this.a.getInputContentViewModel();
            if (r3 == null) goto L15;
            MutableLiveData<Integer> r5 = r3.getPublishSuccessLiveData();
            if (r5 == null) goto L15;
            Integer r6 = (Integer) r5.getValue();
            if (r6 == null) goto L15;
            Integer r7 = Integer.valueOf(r6.intValue() + 1);
        L16:
            r2.setValue(r7);
        L15:
            r7 = null;
        L17:
            CommentListView r8 = this.a;
            o14.c r9 = r4.e();
            if (r9 == null) goto L20;
            r1 = r9.a();
        L20:
            r8.q(r1);
            return;
        L5:
            r2 = null;
            goto L6
        }
    }

    static {
    }

    @Override // ux3.b
    public final void f() {
        this.n = false;
        CommentListAdapter r0 = getAdapter();
        LoadMoreRecyclerViewAdapter.LoadMoreViewHolder r1 = r0.g;
        if (r1 == null) goto L5;
        int r2 = LoadMoreRecyclerViewAdapter.LoadMoreViewHolder.d;
        ((DmtStatusView) ((RecyclerView.ViewHolder) r1).itemView).d();
    L5:
        r0.b = 2;
    }

    @Override // ux3.b
    public final void g() {
        CommentLoadingLayout r0 = this.d;
        if (r0 == null) goto L6;
        r0.setState(0);
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.comment.j
    public CommentListAdapter getAdapter() {
        CommentListAdapter r0 = this.o;
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    public final int getMaxConsumeMainCommentCount() {
        RecyclerView r0 = this.e;
        RecyclerView.LayoutManager r1 = null;
        if (r0 == null) goto L5;
        RecyclerView.LayoutManager r2 = r0.getLayoutManager();
    L7:
        if ((r2 instanceof LinearLayoutManager) == false) goto L36;
        RecyclerView r3 = this.e;
        if (r3 == null) goto L11;
        r1 = r3.getLayoutManager();
    L11:
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        int r4 = ((LinearLayoutManager) r1).findLastVisibleItemPosition();
        if (this.A >= r4) goto L14;
        this.A = r4;
    L14:
        CommentListAdapter r5 = this.o;
        if (r5 == null) goto L34;
        int r6 = this.A;
        if (r6 <= 0) goto L37;
        if (r6 < 0) goto L38;
        int r7 = 0;
        int r8 = 0;
    L21:
        if (r7 >= r5.l.size()) goto L30;
        o14.a r9 = (o14.a) ListProtector.get(r5.l, r7);
        if (r9 == null) goto L27;
        boolean r10 = true;
        if (r9.a != 1) goto L27;
    L28:
        if (r10 == false) goto L30;
        r8 = r8 + 1;
    L27:
        r10 = false;
    L30:
        if (r7 == r6) goto L39;
        r7 = r7 + 1;
        goto L21
    L39:
        return r8;
    L38:
        return 0;
    L37:
        return 0;
    L34:
        return this.A;
    L36:
        return 0;
    L5:
        r2 = null;
        goto L7
    }

    public final void o() {
        CommentLoadingLayout r0 = this.d;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == true) goto L62;
        CommentLoadingLayout r2 = this.d;
        if (r2 != null) goto L12;
    L14:
        boolean r3 = false;
    L15:
        if (r3 == true) goto L63;
        CommentLoadingLayout r4 = this.d;
        if (r4 != null) goto L19;
    L21:
        boolean r5 = false;
    L22:
        if (r5 == true) goto L67;
        CommentInputContentViewModel r6 = this.E;
        if (r6 == null) goto L47;
        MutableLiveData<List<o14.a>> r7 = r6.getPublishContentLiveData();
        if (r7 == null) goto L47;
        List r8 = (List) r7.getValue();
        if (r8 == null) goto L47;
        Iterator r9 = r8.iterator();
    L32:
        if (r9.hasNext() == false) goto L47;
        o14.a r10 = (o14.a) r9.next();
        CommentListAdapter r11 = this.o;
        if (r11 == null) goto L44;
        Iterable r12 = r11.l;
        if (r12 == null) goto L44;
        Iterable r13 = r12;
        ArrayList r14 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
        Iterator r15 = r13.iterator();
    L39:
        if (r15.hasNext() == false) goto L44;
        o14.a r16 = (o14.a) r15.next();
        if (Intrinsics.areEqual(r10.cid, r16.cid) == true) goto L42;
        r14.add(Unit.INSTANCE);
        goto L39
    L42:
        boolean r17 = true;
    L45:
        if (r17 == true) goto L32;
        q(r10);
    L44:
        r17 = false;
    L47:
        CommentInputContentViewModel r18 = this.E;
        if (r18 == null) goto L64;
        MutableLiveData<List<o14.a>> r19 = r18.getPublishContentLiveData();
        if (r19 == null) goto L65;
        List r20 = (List) r19.getValue();
        if (r20 == null) goto L66;
        r20.clear();
        return;
    L66:
        return;
    L65:
        return;
    L64:
        return;
    L67:
        return;
    L19:
        if (r4.getState() != 2) goto L21;
        r5 = true;
        goto L22
    L63:
        return;
    L12:
        if (r2.getState() != 1) goto L14;
        r3 = true;
        goto L15
    L62:
        return;
    L5:
        if (r0.getState() != (-1)) goto L7;
        r1 = true;
        goto L8
    }

    public final void s() {
        if (this.n == false) goto L5;
        return;
    L5:
        if (this.u == false) goto L16;
        this.n = true;
        ny3.d r0 = this.w;
        if (r0 == null) goto L17;
        String r4 = this.a.a;
        Intrinsics.checkNotNullParameter(r4, "awemeId");
        ux3.b r2 = (ux3.b) r0.b;
        if (r2 == null) goto L12;
        r2.k7();
    L12:
        if (((my3.b) r0.a) == null) goto L18;
        long r5 = r0.c;
        ny3.e r7 = new ny3.e(r0);
        Intrinsics.checkNotNullParameter(r4, "awemeId");
        Intrinsics.checkNotNullParameter(r7, "callback");
        d14.a r1 = b14.a.a;
        b14.a.a(p24.e.class).k2(y54.a.a(), r4, r5, r7);
        return;
    L18:
        return;
    L17:
        return;
    }

    @Override // ux3.b
    public final void showLoading() {
        CommentLoadingLayout r0 = this.d;
        if (r0 == null) goto L6;
        r0.setState(1);
        return;
    }

    public final void u() {
        ny3.d r0 = this.w;
        if (r0 == null) goto L5;
        r0.b = null;
        r0.a = null;
    L5:
        if (r0 == null) goto L7;
        r0.a = null;
    L7:
        this.w = null;
        ny3.c r1 = this.x;
        if (r1 == null) goto L10;
        r1.b = null;
        r1.a = null;
    L10:
        if (r1 == null) goto L12;
        r1.a = null;
    L12:
        if (r1 == null) goto L14;
        Observer<ny3.a> r2 = this.B;
        Intrinsics.checkNotNullParameter(r2, "observer");
        LiveDataBus r3 = LiveDataBus.c;
        LiveDataBus.a.a(ny3.a.class).removeObserver(r2);
    L14:
        this.x = null;
        ny3.h r4 = this.y;
        if (r4 == null) goto L17;
        r4.b = null;
        r4.a = null;
    L17:
        if (r4 == null) goto L19;
        r4.a = null;
    L19:
        this.y = null;
    }

    @Override // ux3.b
    public final void a() {
        CommentListAdapter r0 = getAdapter();
        boolean r1 = r0.a;
        if (r1 == false) goto L7;
        if (r1 == false) goto L6;
        r0.a = false;
        r0.B2(false);
    L6:
        r0.notifyDataSetChanged();
    L7:
        CommentLoadingLayout r2 = this.d;
        if (r2 == null) goto L11;
        r2.setState(2);
        return;
    }

    @Override // ux3.b
    public final void k7() {
        getAdapter().showLoadMoreLoading();
    }

    public final boolean p() {
        if (NetworkUtils.b(getContext()) == false) goto L5;
        return true;
    L5:
        ToastUtils.b(getContext(), 2131894241);
        return false;
    }

    public final void r() {
        FrameLayout.inflate(getContext(), 2131558600, this);
        this.f = (ViewGroup) findViewById(2131367327);
        this.c = (TextView) findViewById(2131388772);
        this.h = (ViewStub) findViewById(2131373157);
        this.i = findViewById(2131366989);
        this.k = (TextView) findViewById(2131390373);
        this.j = (FrameLayout) findViewById(2131367445);
        this.l = findViewById(2131376697);
        this.m = (ViewGroup) findViewById(2131377675);
        CommentLoadingLayout r0 = (CommentLoadingLayout) findViewById(2131367393);
        this.d = r0;
        if (r0 == null) goto L5;
        r0.setListener(new b(this));
    L5:
        RecyclerView r1 = findViewById(2131384076);
        this.e = r1;
        if (r1 == null) goto L8;
        r1.setItemViewCacheSize(10);
    L8:
        RecyclerView r2 = this.e;
        if (r2 == null) goto L11;
        r2.addOnScrollListener(new CommentListView$init$2(this));
    L11:
        WrapLinearLayoutManager r3 = new WrapLinearLayoutManager(getContext());
        r3.setInitialPrefetchItemCount(5);
        RecyclerView r4 = this.e;
        if (r4 == null) goto L15;
        r4.setLayoutManager(r3);
    L15:
        CommentPageParam r5 = this.a;
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b r6 = this.D;
        boolean r7 = false;
        if (r6 == null) goto L22;
        Map<String, Object> r8 = r6.g;
        if (r8 == null) goto L22;
        if (r8.containsKey("is_card_mode") != true) goto L22;
        boolean r9 = true;
    L23:
        if (r9 == false) goto L33;
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b r10 = this.D;
        if (r10 == null) goto L29;
        Map<String, Object> r11 = r10.g;
        if (r11 == null) goto L29;
        Object r12 = r11.get("is_card_mode");
    L31:
        if (Intrinsics.areEqual(r12, CommentScene.COMMENTSCENE_NO_AWEME) == false) goto L33;
        r7 = true;
    L29:
        r12 = null;
    L33:
        CommentListAdapter r13 = new CommentListAdapter(this, r5, r7);
        r13.j = new h(this);
        RecyclerView r14 = this.e;
        if (r14 == null) goto L37;
        r14.setAdapter(new HeaderAndFooterWrapper(r13));
    L37:
        this.o = r13;
        return;
    L22:
        r9 = false;
        goto L23
    }

    @Override // ux3.b
    public final void r6() {
        CommentListAdapter r0 = getAdapter();
        boolean r1 = r0.a;
        if (r1 == false) goto L7;
        if (r1 == false) goto L6;
        r0.a = false;
        r0.B2(false);
    L6:
        r0.notifyDataSetChanged();
    L7:
        CommentLoadingLayout r2 = this.d;
        if (r2 == null) goto L11;
        r2.setState(3);
        return;
    }

    public final Activity getHostActivity() {
        return this.C;
    }

    public final CommentInputContentViewModel getInputContentViewModel() {
        return this.E;
    }

    public final View getMCloseCommentButton() {
        return this.i;
    }

    public final ViewGroup getMCommentConstraintWrap() {
        return this.f;
    }

    public final View getMForbidCommentView() {
        return this.g;
    }

    public final ViewStub getMForbidViewStub() {
        return this.h;
    }

    public final View getMIvCommentSuctionClose() {
        return this.l;
    }

    public final CommentLoadingLayout getMLoadingLayout() {
        return this.d;
    }

    public final com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b getMPageOwner() {
        return this.D;
    }

    public final RecyclerView getMRecyclerView() {
        return this.e;
    }

    public final TextView getMTitleView() {
        return this.c;
    }

    public final FrameLayout getMTvCommentSuctionWordContainer() {
        return this.j;
    }

    public final TextView getMTvCommentSuctionWordTitle() {
        return this.k;
    }

    public final ViewGroup getMWriteComment() {
        return this.m;
    }

    public CommentPageParam getPageParam() {
        return this.a;
    }

    public CommentListView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        new LinkedHashMap();
        super(r2);
        this.a = new CommentPageParam();
        this.q = true;
        this.s = -1;
        this.u = true;
        this.v = new ky3.a();
        this.B = new com.bytedance.awemeopen.apps.framework.comment.a(this);
        this.G = new my3.d();
        r();
    }

    private final void setWriteCommentView(com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b r4) {
        if (AosExtConfig.b.getCommentConfig().c == false) goto L24;
        if (this.a.n == false) goto L10;
        AosPhotoRefactorService r0 = BdpManager.getInst().getService(AosPhotoRefactorService.class);
        if (r0 == null) goto L9;
        com.bytedance.awemeopen.apps.framework.comment.write.b r1 = r0.d2(r4.b, new d(this));
    L11:
        this.p = r1;
        if (r1 == null) goto L14;
        r1.d();
    L14:
        com.bytedance.awemeopen.apps.framework.comment.write.b r2 = this.p;
        if (r2 == null) goto L17;
        r2.f(r4, false);
    L17:
        com.bytedance.awemeopen.apps.framework.comment.write.b r5 = this.p;
        if (r5 == null) goto L21;
        r5.a = this.a.a;
    L21:
        if (r5 == null) goto L24;
        r5.e();
        goto L24
    L9:
        r1 = null;
        goto L11
    L10:
        r1 = new WriteCommentEntranceView(this, new e(this));
    L24:
        if (this.a.n == false) goto L33;
        TextView r6 = this.c;
        if (r6 == null) goto L29;
        r6.setVisibility(8);
    L29:
        View r7 = this.i;
        if (r7 == null) goto L33;
        r7.setVisibility(8);
    L33:
        CommentPageParam r8 = this.a;
        if (r8.o == false) goto L36;
    L37:
        ViewGroup r9 = this.m;
        if (r9 == null) goto L43;
        r9.setVisibility(8);
        return;
    L43:
        return;
    L36:
        if (r8.n == true) goto L37;
    }

    @Override // com.bytedance.awemeopen.apps.framework.comment.j
    public final void c(o14.a r7) {
        Intrinsics.checkNotNullParameter(r7, "comment");
        JSONObject r1 = AoSettings.a("ao_comment_config");
        boolean r3 = true;
        if (r1 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L18;
        JSONObject r0 = AoSettings.a("ao_comment_config");
        if (r0 != null) goto L12;
    L14:
        boolean r4 = false;
    L15:
        if (r4 == true) goto L18;
        return;
    L12:
        if (JSONObjectProtectorUtils.getBoolean(r0, "allow_comment_image_feed") != true) goto L14;
        r4 = true;
    L18:
        if (this.F != null) goto L20;
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b r5 = this.D;
        Intrinsics.checkNotNull(r5);
        AosCommentImageContainer r6 = new AosCommentImageContainer(r5, this.a);
        this.F = r6;
        r6.c();
    L20:
        AosCommentImageContainer r8 = this.F;
        if (r8 != null) goto L23;
    L25:
        boolean r9 = false;
    L26:
        if (r9 == true) goto L98;
        List<o14.a> r10 = this.v.b;
        if (r10 != null) goto L30;
    L32:
        boolean r11 = false;
    L33:
        if (r11 == true) goto L100;
        List<o14.a> r12 = this.v.b;
        if (r12 == null) goto L49;
        ArrayList r13 = new ArrayList();
        Iterator r14 = ((ArrayList) r12).iterator();
    L39:
        if (r14.hasNext() == false) goto L50;
        Object r15 = r14.next();
        List r16 = ((o14.a) r15).f();
        if (r16 == null) goto L43;
        int r17 = r16.size();
    L44:
        if (r17 < 1) goto L46;
        boolean r18 = true;
    L47:
        if (r18 == false) goto L39;
        r13.add(r15);
        goto L39
    L46:
        r18 = false;
        goto L47
    L43:
        r17 = 0;
    L50:
        int r19 = r13.indexOf(r7);
        AosCommentImageContainer r20 = this.F;
        if (r20 == null) goto L63;
        Intrinsics.checkNotNullParameter(r13, "comments");
        CommentImageView r21 = r20.c;
        if (r21 == null) goto L63;
        Intrinsics.checkNotNullParameter(r13, "comments");
        SlidesImagePageAdapter r22 = r21.e;
        if (r22 == null) goto L57;
        ((ArrayList) r22.d).clear();
        ((ArrayList) r22.d).addAll(r13);
        r22.notifyDataSetChanged();
    L57:
        VerticalViewPager r23 = r21.d;
        if (r23 == null) goto L60;
        r23.y(r19, false);
    L60:
        SlidesImagePageAdapter r24 = r21.e;
        if (r24 == null) goto L63;
        r24.notifyDataSetChanged();
    L63:
        AosCommentImageContainer r25 = this.F;
        if (r25 != null) goto L91;
    L87:
        AosCommentImageContainer r26 = this.F;
        if (r26 == null) goto L99;
        r26.d();
        return;
    L99:
        return;
    L91:
        Result.Companion r27 = Result.Companion;     // Catch: Throwable -> L85
        ViewGroup r28 = r25.b;     // Catch: Throwable -> L85
        if (r28 == null) goto L73;
        View r29 = r25.f;     // Catch: Throwable -> L85
        Intrinsics.checkNotNull(r29);     // Catch: Throwable -> L85
        if (r28.indexOfChild(r29) == (-1)) goto L70;
        boolean r30 = true;
    L71:
        if (r30 == true) goto L73;
    L74:
        if (r3 == false) goto L83;
        FrameLayout.LayoutParams r31 = new FrameLayout.LayoutParams(-1, -1);     // Catch: Throwable -> L85
        int r32 = w04.a.a;     // Catch: Throwable -> L85
        if (w04.a.b(r25.d.getActivity()) == true) goto L78;
    L80:
        ViewGroup r33 = r25.b;     // Catch: Throwable -> L85
        if (r33 == null) goto L83;
        r33.addView(r25.f, r31);     // Catch: Throwable -> L85
        goto L83
    L78:
        if (r25.a.o == true) goto L80;
        r31.topMargin = r25.g;     // Catch: Throwable -> L85
    L83:
        SystemClock.elapsedRealtime();     // Catch: Throwable -> L85
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L85
        goto L87
    L70:
        r30 = false;
    L73:
        r3 = false;
    L85:
        th = move-exception;
        Result.Companion r34 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L87
    L49:
        r13 = new ArrayList();
        goto L50
    L100:
        return;
    L30:
        if (((ArrayList) r10).size() != 0) goto L32;
        r11 = true;
        goto L33
    L98:
        return;
    L23:
        if (r8.d() != true) goto L25;
        r9 = true;
        goto L26
    L5:
        if (r1.has("allow_comment_image_feed") != true) goto L7;
        r2 = true;
        goto L8
    }

    @Override // com.bytedance.awemeopen.apps.framework.comment.j
    public final void e(final o14.a r10) {
        Intrinsics.checkNotNullParameter(r10, "comment");
        if (p() == true) goto L5;
        return;
    L5:
        LinkedHashMap r4 = new LinkedHashMap();
        r4.put("current_action", "cell_reply_tap");
        r4.put("comment_id", r10.cid);
        User r1 = r10.o();
        if (r1 == null) goto L9;
        String r2 = r1.u();
        if (r2 == null) goto L9;
    L10:
        r4.put("comment_user_id", r2);
        r4.put("author_openid", this.a.b);
        r4.put("group_id", this.a.a);
        r4.put("enter_from_cmt", this.a.g);
        if (r10.a != 1) goto L13;
        String r3 = "reply";
    L14:
        r4.put("comment_category", r3);
        AosEventReporter.s(AosEventReporter.a, "comment_action", r4, null, this.a.l, null, 20);
        Context r5 = getContext();
        int r6 = com.bytedance.awemeopen.bizmodels.user.a.a;
        com.bytedance.awemeopen.apps.framework.comment.util.e.a(r5, "comment", new CommentListView$onItemClicked$1(this, r10), "CommentListView");
        return;
    L13:
        r3 = "reply_to_reply";
    L9:
        r2 = "";
        goto L10
    }

    @Override // com.bytedance.awemeopen.apps.framework.comment.j
    public final void i(final o14.a r22) {
        Intrinsics.checkNotNullParameter(r22, "comment");
        if (p() == true) goto L5;
        return;
    L5:
        User r2 = r22.o();
        String r3 = null;
        if (r2 == null) goto L8;
        String r4 = r2.u();
    L10:
        if (TextUtils.isEmpty(r4) == true) goto L41;
        d14.a r5 = b14.a.a;
        com.bytedance.awemeopen.bizmodels.user.c r6 = b14.a.a(k34.b.class).getAccessToken();
        if (r6 == null) goto L15;
        r3 = r6.b;
    L15:
        if (Intrinsics.areEqual(r4, r3) == false) goto L41;
        LinkedHashMap r7 = new LinkedHashMap();
        r7.put("enter_from", this.a.g);
        r7.put("enter_method", "long_press");
        r7.put("author_openid", this.a.b);
        r7.put("group_id", this.a.a);
        r7.put("comment_id", r22.cid);
        int r8 = o14.a.c;
        r7.put("comment_category", o14.a.a.a(r22));
        AosEventReporter.s(AosEventReporter.a, "tap_comment", r7, null, null, null, 28);
        if (this.z != null) goto L19;
        this.z = new AosCommentPassDialog(getContext());
    L19:
        AppCompatDialog r9 = this.z;
        if (r9 != null) goto L22;
    L24:
        boolean r10 = false;
    L25:
        if (r10 == false) goto L27;
        return;
    L27:
        AosCommentPassDialog r11 = this.z;
        if (r11 == null) goto L30;
        c r12 = new c(this, r22);
        Intrinsics.checkNotNullParameter(r12, "clickDeleteListener");
        r11.g = r12;
    L30:
        AosCommentPassDialog r1 = this.z;
        if (r1 == null) goto L33;
        r1.i = true;
        r1.j = false;
        r1.L0();
    L33:
        AosCommentPassDialog r13 = this.z;
        if (r13 != null) goto L36;
        return;
    L36:
        if (DialogLancet.shouldBlockDialogShow(r13) == false) goto L77;
        DialogLancet.handleBlockedDialogShow(r13);
        return;
    L77:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L75
    L39:
        DialogLancet.beforeDialogShow(r13);
        r13.show();
        DialogLancet.afterDialogShow(r13);
        return;
    L22:
        if (r9.isShowing() != true) goto L24;
        r10 = true;
    L41:
        int r14 = v.a;
        final Activity r15 = v.a(getContext());
        if (r15 == null) goto L83;
        LinkedHashMap r16 = new LinkedHashMap();
        r16.put("enter_from", this.a.g);
        r16.put("enter_method", "long_press");
        r16.put("author_openid", this.a.b);
        r16.put("group_id", this.a.a);
        r16.put("comment_id", r22.cid);
        int r17 = o14.a.c;
        r16.put("comment_category", o14.a.a.a(r22));
        String r18 = this.a.i;
        String r19 = "";
        if (r18 != null) goto L46;
        r18 = "";
    L46:
        r16.put("group_source", r18);
        String r20 = this.a.j;
        if (r20 == null) goto L50;
        r19 = r20;
    L50:
        r16.put(BaseFollowStoreViewModel.KEY_PREVIOUS_PAGE, r19);
        AosEventReporter.s(AosEventReporter.a, "tap_comment", r16, null, null, null, 28);
        if (this.z != null) goto L53;
        this.z = new AosCommentPassDialog(getContext());
    L53:
        AppCompatDialog r21 = this.z;
        if (r21 != null) goto L56;
    L58:
        boolean r23 = false;
    L59:
        if (r23 == false) goto L61;
        return;
    L61:
        AosCommentPassDialog r24 = this.z;
        if (r24 == null) goto L64;
        AosCommentPassDialog.b r25 = new CommentListView$onItemLongClicked$2$1(this, r22, r15);
        Intrinsics.checkNotNullParameter(r25, "clickReportListener");
        r24.h = r25;
    L64:
        AosCommentPassDialog r26 = this.z;
        if (r26 == null) goto L67;
        r26.i = false;
        r26.j = true;
        r26.L0();
    L67:
        AosCommentPassDialog r27 = this.z;
        if (r27 != null) goto L70;
        return;
    L70:
        if (DialogLancet.shouldBlockDialogShow(r27) == false) goto L79;
        DialogLancet.handleBlockedDialogShow(r27);
        return;
    L79:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L76
    L73:
        DialogLancet.beforeDialogShow(r27);
        r27.show();
        DialogLancet.afterDialogShow(r27);
        return;
    L56:
        if (r21.isShowing() != true) goto L58;
        r23 = true;
        goto L59
    L83:
        return;
    L8:
        r4 = null;
        goto L10
    }

    @Override // com.bytedance.awemeopen.apps.framework.comment.view.d
    public final void j(ky3.b r4) {
        Intrinsics.checkNotNullParameter(r4, "commentReplyButton");
        ky3.a r1 = this.v;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r4, "commentReplyButton");
        Pair<Integer, Integer> r0 = r1.d(r4);
        if (r0 == null) goto L8;
        int r2 = (((Number) r0.getFirst()).intValue() + r4.j) + 1;
        int r5 = ((Number) r0.getSecond()).intValue();
        if (r5 <= r2) goto L8;
        List<o14.a> r3 = r1.b;
        Intrinsics.checkNotNull(r3);
        ((ArrayList) r3).subList(r2, r5).clear();
        Pair r6 = new Pair(Integer.valueOf(r2), Integer.valueOf(r5 - r2));
    L9:
        if (r6 == null) goto L12;
        getAdapter().notifyItemRangeRemoved(((Number) r6.getFirst()).intValue(), ((Number) r6.getSecond()).intValue());
        return;
    L12:
        return;
    L8:
        r6 = null;
        goto L9
    }

    public final void q(o14.a r14) {
        if (r14 != null) goto L4;
        return;
    L4:
        String r0 = r14.g();
        if (r0 != null) goto L7;
    L10:
        boolean r1 = true;
    L11:
        if (r1 == false) goto L13;
        r14.t();
    L13:
        g();
        CommentListAdapter r2 = this.o;
        if (r2 != null) goto L17;
        return;
    L17:
        if (r14.a != 2) goto L50;
        ky3.a r3 = this.v;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r14, "replyComment");
        List<o14.a> r4 = r3.b;
        final int r5 = -1;
        if (r4 == null) goto L46;
        int r6 = -1;
    L22:
        r6 = r6 + 1;
        ArrayList r7 = (ArrayList) r4;
        o14.a r8 = null;
        if (r6 >= r7.size()) goto L27;
        o14.a r9 = (o14.a) ListProtector.get(r4, r6);
        if (Intrinsics.areEqual(r9.cid, r14.i()) == false) goto L22;
    L28:
        if (r9 == null) goto L46;
        List r10 = r9.replyComments;
        if (r10 != null) goto L33;
        r10 = new ArrayList();
        r9.replyComments = r10;
    L33:
        r10.add(r14);
        r9.replyCommentTotal++;
    L34:
        r6 = r6 + 1;
        if (r6 >= r7.size()) goto L40;
        o14.a r11 = (o14.a) ListProtector.get(r4, r6);
        if (r11.a == 2) goto L34;
        r8 = r11;
    L40:
        if (r6 < r7.size()) goto L42;
        r7.add(r14);
    L45:
        r5 = r6;
        goto L46
    L42:
        ListProtector.add(r4, r6, r14);
        if ((r8 instanceof ky3.b) == false) goto L45;
        ((o14.a) ((ky3.b) r8)).replyCommentTotal++;
        goto L45
    L27:
        r9 = null;
    L46:
        if (r5 <= 0) goto L72;
        r2.notifyItemInserted(r5);
        RecyclerView r15 = this.e;
        if (r15 == null) goto L73;
        r15.post(new com.bytedance.awemeopen.apps.framework.comment.e(this, r5));
        return;
    L73:
        return;
    L72:
        return;
    L50:
        ky3.a r12 = this.v;
        r12.getClass();
        Intrinsics.checkNotNullParameter(r14, "comment");
        if (r12.b != null) goto L53;
        r12.c();
        CopyOnWriteArrayList<o14.a> r13 = r12.a;
        Intrinsics.checkNotNull(r13);
        r13.add(r14);
        List<o14.a> r16 = r12.b;
        Intrinsics.checkNotNull(r16);
        ((ArrayList) r16).add(r14);
    L54:
        List r17 = this.v.b;
        if (r17 != null) goto L57;
    L62:
        r2.notifyItemInserted(0);
        RecyclerView r18 = this.e;
        if (r18 == null) goto L76;
        r18.post(new f(this));
        return;
    L76:
        return;
    L57:
        if (((ArrayList) r17).size() != 1) goto L62;
        r2.l = r17;
        r2.notifyDataSetChanged();
        if (true == r2.a) goto L61;
        r2.a = true;
        r2.B2(true);
    L61:
        r2.A2();
        return;
    L53:
        CopyOnWriteArrayList<o14.a> r19 = r12.a;
        Intrinsics.checkNotNull(r19);
        r19.add(0, r14);
        List<o14.a> r20 = r12.b;
        Intrinsics.checkNotNull(r20);
        ListProtector.add(r20, 0, r14);
        goto L54
    L7:
        if (r0.length() == 0) goto L10;
        r1 = false;
        goto L11
    }

    public final void setCloseCommentButton(final Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "closeAction");
        View r0 = this.i;
        if (r0 == null) goto L5;
        r0.setOnClickListener(new com.bytedance.awemeopen.apps.framework.comment.b(r3));
    L5:
        View r1 = this.l;
        if (r1 == null) goto L9;
        r1.setOnClickListener(new com.bytedance.awemeopen.apps.framework.comment.c(r3));
        return;
    }

    public final void setHostActivity(Activity r1) {
        this.C = r1;
    }

    public final void setInputContentViewModel(CommentInputContentViewModel r1) {
        this.E = r1;
    }

    public final void setMCloseCommentButton(View r1) {
        this.i = r1;
    }

    public final void setMCommentConstraintWrap(ViewGroup r1) {
        this.f = r1;
    }

    public final void setMForbidCommentView(View r1) {
        this.g = r1;
    }

    public final void setMForbidViewStub(ViewStub r1) {
        this.h = r1;
    }

    public final void setMIvCommentSuctionClose(View r1) {
        this.l = r1;
    }

    public final void setMLoadingLayout(CommentLoadingLayout r1) {
        this.d = r1;
    }

    public final void setMPageOwner(com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b r1) {
        this.D = r1;
    }

    public final void setMRecyclerView(RecyclerView r1) {
        this.e = r1;
    }

    public final void setMTitleView(TextView r1) {
        this.c = r1;
    }

    public final void setMTvCommentSuctionWordContainer(FrameLayout r1) {
        this.j = r1;
    }

    public final void setMTvCommentSuctionWordTitle(TextView r1) {
        this.k = r1;
    }

    public final void setMWriteComment(ViewGroup r1) {
        this.m = r1;
    }

    public final void setPageOwner(com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b r2) {
        Intrinsics.checkNotNullParameter(r2, "mPageOwner");
        this.C = r2.getActivity();
        this.D = r2;
        setWriteCommentView(r2);
        CommentInputContentViewModel.a r0 = CommentInputContentViewModel.Companion;
        ViewModelStoreOwner r3 = r2.e;
        r0.getClass();
        this.E = CommentInputContentViewModel.a.a(r3);
    }

    public final void setupOpenSearch(View r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        final Function0<Unit> r0 = new CommentListView$setupOpenSearch$block$1(this);
        r3.setOnClickListener(new com.bytedance.awemeopen.apps.framework.comment.d(r0));
    }

    public final void v(long r5) {
        TextView r0 = this.c;
        if (r0 == null) goto L7;
        r0.setText(getContext().getString(2131894168, new Object[]{t.a(r5)}));
        return;
    }

    public CommentListView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        new LinkedHashMap();
        super(r2, r3);
        this.a = new CommentPageParam();
        this.q = true;
        this.s = -1;
        this.u = true;
        this.v = new ky3.a();
        this.B = new com.bytedance.awemeopen.apps.framework.comment.a(this);
        this.G = new my3.d();
        r();
    }

    public static void n(CommentListView r2, ny3.a r3) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        if (Intrinsics.areEqual(r3.a, r2.a.a) == true) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r3.d, String.valueOf(r2.hashCode())) == true) goto L10;
        r2.getAdapter().C2(r3.b, r3.c, true);
        return;
    }

    @Override // ux3.b
    public final void C6(List<o14.a> r3, boolean r4) {
        this.u = r4;
        this.n = false;
        CommentListAdapter r0 = getAdapter();
        if (r4 == true) goto L5;
        r0.A2();
    L6:
        ky3.a r5 = this.v;
        r5.c();
        if (r3 == null) goto L9;
        r5.b(r3);
    L9:
        r0.l = this.v.b;
        if (r0.a == false) goto L12;
        r0.notifyItemRangeInserted(r0.m - 1, r0.getItemCount() - r0.m);
        r0.notifyItemChanged(r0.getItemCount() - 1);
        return;
    L12:
        r0.notifyItemRangeInserted(r0.m, r0.getItemCount() - r0.m);
        return;
    L5:
        r0.resetLoadMoreState();
        goto L6
    }

    @Override // com.bytedance.awemeopen.apps.framework.comment.view.c
    public final void b(String r12, int r13) {
        Intrinsics.checkNotNullParameter(r12, "cid");
        getAdapter().C2(r12, r13, true);
        if (this.x == null) goto L5;
        ny3.a r1 = new ny3.a(this.a.a, r12, r13, String.valueOf(hashCode()));
        Intrinsics.checkNotNullParameter(r1, "event");
        LiveDataBus r3 = LiveDataBus.c;
        LiveDataBus.a.a(ny3.a.class).postValue(r1);
    L5:
        CommentListAdapter r2 = getAdapter();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r12, "cid");
        Object r4 = null;
        if (r2.getBasicItemCount() != 0) goto L8;
        o14.a r5 = null;
    L16:
        if (r5 == null) goto L69;
        if (r13 != 1) goto L20;
        String r14 = "like_comment";
    L30:
        String r6 = r14;
        LinkedHashMap r7 = new LinkedHashMap();
        Map<String, Object> r15 = this.a.v;
        if (r15 == null) goto L36;
        Iterator<Map.Entry<String, Object>> r16 = r15.entrySet().iterator();
    L34:
        if (r16.hasNext() == false) goto L36;
        Map.Entry<String, Object> r0 = r16.next();
        r7.put(r0.getKey(), r0.getValue());
    L36:
        r7.put("author_openid", this.a.b);
        r7.put("group_id", this.a.a);
        r7.put("impr_id", this.a.h);
        User r17 = r5.o();
        if (r17 == null) goto L40;
        String r18 = r17.u();
        if (r18 == null) goto L40;
    L41:
        r7.put("comment_user_id", r18);
        r7.put("comment_id", r12);
        r7.put("content", r5.l());
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b r19 = this.D;
        if (r19 == null) goto L48;
        Map<String, Object> r110 = r19.g;
        if (r110 == null) goto L48;
        if (r110.containsKey("is_card_mode") != true) goto L48;
        boolean r111 = true;
    L49:
        if (r111 == false) goto L58;
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b r112 = this.D;
        if (r112 == null) goto L55;
        Map<String, Object> r113 = r112.g;
        if (r113 == null) goto L55;
        r4 = r113.get("is_card_mode");
    L55:
        String r114 = CommentScene.COMMENTSCENE_NO_AWEME;
        if (Intrinsics.areEqual(r4, CommentScene.COMMENTSCENE_NO_AWEME) == false) goto L58;
    L59:
        r7.put("is_card_sdk", r114);
        r7.put("enter_from_cmt", this.a.g);
        if (r5.a != 1) goto L62;
        String r115 = "reply";
    L63:
        r7.put("comment_category", r115);
        AosEventReporter.s(AosEventReporter.a, r6, r7, null, null, null, 28);
        return;
    L62:
        r115 = "reply_to_reply";
    L58:
        r114 = "0";
    L48:
        r111 = false;
    L40:
        r18 = "";
        goto L41
    L20:
        if (r13 != 2) goto L22;
        r14 = "cancel_like_comment";
        goto L30
    L22:
        if (r13 != 3) goto L24;
        r14 = "dislike_comment";
        goto L30
    L24:
        if (r13 != 4) goto L70;
        r14 = "cancel_dislike_comment";
        goto L30
    L70:
        return;
    L69:
        return;
    L8:
        Iterator r8 = r2.l.iterator();
    L10:
        if (r8.hasNext() == false) goto L14;
        Object r9 = r8.next();
        if (Intrinsics.areEqual(((o14.a) r9).cid, r12) == false) goto L10;
    L15:
        r5 = (o14.a) r9;
        goto L16
    L14:
        r9 = null;
        goto L15
    }

    @Override // com.bytedance.awemeopen.apps.framework.comment.j
    public final void d(ky3.b r25, CommentReplyButtonViewHolder r26) {
        Intrinsics.checkNotNullParameter(r25, "replyButton");
        Intrinsics.checkNotNullParameter(r26, "viewHolder");
        if (this.y != null) goto L5;
        CommentPageParam r6 = this.a;
        ky3.a r7 = this.v;
        Intrinsics.checkNotNull(r7);
        ny3.h r5 = new ny3.h(r6, r7);
        my3.c r8 = new my3.c();
        Intrinsics.checkNotNullParameter(r8, "model");
        r5.a = r8;
        Intrinsics.checkNotNullParameter(this, "view");
        r5.b = this;
        this.y = r5;
    L5:
        ny3.h r9 = this.y;
        if (r9 == null) goto L61;
        Intrinsics.checkNotNullParameter(r25, "replyButton");
        Intrinsics.checkNotNullParameter(r26, "viewHolder");
        ny3.h.a r3 = new ny3.h.a(r9, r25, r26);
        ky3.b r1 = r3.a;
        int r2 = r1.e;
        if (r2 != 3) goto L11;
        return;
    L11:
        if (r2 != 0) goto L33;
        if (r3.b() == false) goto L62;
        r3.b.O1(r3.a, 3);
        ny3.h r4 = r3.c;
        if (((my3.c) r4.a) == null) goto L63;
        ky3.b r10 = r3.a;
        String r15 = r10.d;
        String r11 = r10.f;
        long r12 = r10.g;
        CommentPageParam r13 = r4.c;
        String r14 = r13.a;
        String r16 = r13.g;
        if (TextUtils.isEmpty(r16) == false) goto L19;
    L18:
        int r20 = -1;
    L23:
        Integer r17 = r3.c.c.e;
        if (r17 == null) goto L26;
        int r21 = r17.intValue();
    L27:
        Integer r18 = r3.c.c.f;
        if (r18 == null) goto L30;
        int r22 = r18.intValue();
    L31:
        ny3.f r19 = new ny3.f(r3);
        Intrinsics.checkNotNullParameter(r15, "commentId");
        Intrinsics.checkNotNullParameter(r11, "topIds");
        Intrinsics.checkNotNullParameter(r14, "itemId");
        Intrinsics.checkNotNullParameter("", "insertCids");
        Intrinsics.checkNotNullParameter("", "city");
        Intrinsics.checkNotNullParameter(r19, "callback");
        my3.c.a(r15, r12, r11, r14, r20, r21, r22, r19);
        return;
    L30:
        r22 = 0;
        goto L31
    L26:
        r21 = 0;
        goto L27
    L19:
        r16.getClass();
        if (r16.equals("homepage_hot") == false) goto L18;
        r20 = 0;
        goto L23
    L63:
        return;
    L62:
        return;
    L33:
        if (r2 != 1) goto L55;
        if (r3.b() == false) goto L65;
        r3.b.O1(r3.a, 3);
        ny3.h r23 = r3.c;
        if (((my3.c) r23.a) == null) goto L66;
        ky3.b r24 = r3.a;
        String r110 = r24.d;
        String r27 = r24.f;
        long r28 = r24.g;
        CommentPageParam r29 = r23.c;
        String r30 = r29.a;
        String r31 = r29.g;
        if (TextUtils.isEmpty(r31) == false) goto L41;
    L40:
        int r210 = -1;
    L45:
        Integer r32 = r3.c.c.e;
        if (r32 == null) goto L48;
        int r211 = r32.intValue();
    L49:
        Integer r33 = r3.c.c.f;
        if (r33 == null) goto L52;
        int r212 = r33.intValue();
    L53:
        ny3.g r34 = new ny3.g(r3);
        Intrinsics.checkNotNullParameter(r110, "commentId");
        Intrinsics.checkNotNullParameter(r27, "topIds");
        Intrinsics.checkNotNullParameter(r30, "itemId");
        Intrinsics.checkNotNullParameter("", "insertCids");
        Intrinsics.checkNotNullParameter("", "city");
        Intrinsics.checkNotNullParameter(r34, "callback");
        my3.c.a(r110, r28, r27, r30, r210, r211, r212, r34);
        return;
    L52:
        r212 = 0;
        goto L53
    L48:
        r211 = 0;
        goto L49
    L41:
        r31.getClass();
        if (r31.equals("homepage_hot") == false) goto L40;
        r210 = 0;
        goto L45
    L66:
        return;
    L65:
        return;
    L55:
        if (r2 != 2) goto L68;
        com.bytedance.awemeopen.apps.framework.comment.view.d r35 = (com.bytedance.awemeopen.apps.framework.comment.view.d) r3.c.b;
        if (r35 == null) goto L59;
        r35.j(r1);
    L59:
        ky3.b r36 = r3.a;
        r36.i = Math.max(r36.j, 0);
        r3.b.O1(r3.a, 0);
        return;
    L68:
        return;
    }

    @Override // com.bytedance.awemeopen.apps.framework.comment.view.c
    public final void h(String r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "cid");
        ToastUtils.b(y54.a.a(), 2131894275);
        getAdapter().C2(r3, r4, false);
    }

    @Override // com.bytedance.awemeopen.apps.framework.comment.j
    public final void k(final o14.a r3, final int r4) {
        Intrinsics.checkNotNullParameter(r3, "comment");
        if (p() == true) goto L5;
        return;
    L5:
        Context r0 = getContext();
        int r1 = com.bytedance.awemeopen.bizmodels.user.a.a;
        com.bytedance.awemeopen.apps.framework.comment.util.e.a(r0, "like_comment", new CommentListView$onClickDigg$1(this, r3, r4), "CommentListView");
    }

    @Override // com.bytedance.awemeopen.apps.framework.comment.view.d
    public final void l(ky3.b r6, List<? extends o14.a> r7) {
        Intrinsics.checkNotNullParameter(r6, "commentReplyButton");
        Intrinsics.checkNotNullParameter(r7, "expandList");
        if (r7.isEmpty() == false) goto L5;
        return;
    L5:
        ky3.a r1 = this.v;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r6, "commentReplyButton");
        Intrinsics.checkNotNullParameter(r7, "replyComments");
        List<o14.a> r0 = r1.b;
        Pair r2 = null;
        if (r0 == null) goto L24;
        Pair<Integer, Integer> r8 = r1.d(r6);
        if (r8 == null) goto L24;
        int r3 = ((Number) r8.getFirst()).intValue();
        int r9 = ((Number) r8.getSecond()).intValue();
        o14.a r4 = (o14.a) ListProtector.get(r0, r3);
        if ((ListProtector.get(r0, r9) instanceof ky3.b) == false) goto L24;
        List r5 = r4.replyComments;
        if (r5 != null) goto L17;
        r5 = new ArrayList();
        r4.replyComments = r5;
    L17:
        Iterator<? extends o14.a> r10 = r7.iterator();
    L19:
        if (r10.hasNext() == false) goto L23;
        o14.a r11 = r10.next();
        r11.a = 2;
        if (r5.contains(r11) == true) goto L19;
        r5.add(r11);
        goto L19
    L23:
        ArrayList r12 = (ArrayList) r0;
        r12.addAll(r9, r7);
        r2 = new Pair(Integer.valueOf(r9), Integer.valueOf(r7.size()));
    L24:
        if (r2 == null) goto L32;
        getAdapter().notifyItemRangeInserted(((Number) r2.getFirst()).intValue(), ((Number) r2.getSecond()).intValue());
        return;
    }

    @Override // ux3.b
    public final void m(List<o14.a> r4, boolean r5) {
        this.u = r5;
        CommentListAdapter r0 = getAdapter();
        if (true == r0.a) goto L5;
        r0.a = true;
        r0.B2(true);
    L5:
        if (r5 == true) goto L7;
        r0.A2();
    L8:
        ky3.a r6 = this.v;
        r6.c();
        CopyOnWriteArrayList<o14.a> r1 = r6.a;
        if (r1 == null) goto L11;
        r1.clear();
    L11:
        List<o14.a> r2 = r6.b;
        if (r2 == null) goto L14;
        ((ArrayList) r2).clear();
    L14:
        if (r4 == null) goto L16;
        r6.b(r4);
    L16:
        r0.l = this.v.b;
        r0.notifyDataSetChanged();
        CommentLoadingLayout r7 = this.d;
        if (r7 == null) goto L19;
        r7.setState(0);
    L19:
        o();
        return;
    L7:
        r0.resetLoadMoreState();
        goto L8
    }

    public final void t(CommentPageParam r11, zz3.h r12) {
        Intrinsics.checkNotNullParameter(r11, "pageParam");
        boolean r2 = true;
        boolean r1 = !TextUtils.equals(r11.a, this.a.a);
        this.a = r11;
        this.b = r12;
        if (r12 == null) goto L5;
        Observer<Long> r4 = new g(this);
        Intrinsics.checkNotNullParameter(r4, "observer");
        r12.a.a(r4);
    L5:
        ViewGroup.LayoutParams r5 = null;
        if (r1 == false) goto L56;
        u();
        ny3.d r3 = new ny3.d();
        this.w = r3;
        my3.b r7 = new my3.b();
        Intrinsics.checkNotNullParameter(r7, "model");
        r3.a = r7;
        ny3.d r6 = this.w;
        if (r6 == null) goto L10;
        Intrinsics.checkNotNullParameter(this, "view");
        r6.b = this;
    L10:
        ny3.c r8 = new ny3.c();
        this.x = r8;
        my3.a r9 = new my3.a();
        Intrinsics.checkNotNullParameter(r9, "model");
        r8.a = r9;
        ny3.c r10 = this.x;
        if (r10 == null) goto L14;
        Intrinsics.checkNotNullParameter(this, "view");
        r10.b = this;
    L14:
        if (this.x == null) goto L16;
        Observer<ny3.a> r13 = this.B;
        Intrinsics.checkNotNullParameter(r13, "observer");
        LiveDataBus r14 = LiveDataBus.c;
        LiveDataBus.a.a(ny3.a.class).observeForever(r13);
    L16:
        this.n = false;
        this.A = 0;
        CommentListAdapter r15 = this.o;
        if (r15 == null) goto L20;
        r15.l = new ArrayList();
        r15.notifyDataSetChanged();
    L20:
        CommentListAdapter r16 = this.o;
        if (r16 == null) goto L23;
        CommentPageParam r17 = this.a;
        Intrinsics.checkNotNullParameter(r17, "pageParam");
        r16.p = r17;
    L23:
        CommentPageParam r0 = this.a;
        if (r0.c == false) goto L36;
        v(r0.d);
        View r18 = this.g;
        if (r18 == null) goto L29;
        r18.setVisibility(8);
    L29:
        CommentLoadingLayout r19 = this.d;
        if (r19 == null) goto L33;
        r19.setVisibility(0);
    L33:
        ny3.d r20 = this.w;
        if (r20 == null) goto L56;
        r20.b(this.a.a);
        goto L56
    L36:
        TextView r21 = this.c;
        if (r21 == null) goto L41;
        r21.setText(getContext().getString(2131894138));
    L41:
        if (this.g != null) goto L47;
        ViewStub r22 = this.h;
        if (r22 == null) goto L45;
        View r23 = r22.inflate();
    L46:
        this.g = r23;
        goto L47
    L45:
        r23 = null;
    L47:
        View r24 = this.g;
        if (r24 == null) goto L51;
        r24.setVisibility(0);
    L51:
        CommentLoadingLayout r25 = this.d;
        if (r25 == null) goto L56;
        r25.setVisibility(8);
    L56:
        if (r11.n == false) goto L90;
        ViewGroup r110 = this.f;
        if (r110 == null) goto L61;
        r110.setBackground(getContext().getDrawable(2131231453));
    L61:
        CommentLoadingLayout r111 = this.d;
        if (r111 == null) goto L69;
        View r112 = r111.c;
        if ((r112 instanceof TextView) == false) goto L66;
        ((TextView) r112).setTextColor(ContextCompat.getColor(r112.getContext(), 2131100257));
        ((TextView) r111.c).setText(2131894251);
        r111.c.setPadding(0, x54.a.a(44), 0, x54.a.a(48));
    L66:
        View r113 = r111.d;
        if ((r113 instanceof TextView) == false) goto L69;
        ((TextView) r113).setTextColor(ContextCompat.getColor(r113.getContext(), 2131100257));
    L69:
        CommentLoadingLayout r114 = this.d;
        if (r114 == null) goto L72;
        r5 = r114.getLayoutParams();
    L72:
        if (r5 == null) goto L75;
        r5.height = -2;
    L75:
        CommentListAdapter r115 = this.o;
        if (r115 == null) goto L78;
        r115.c = getContext().getResources().getColor(2131100344);
    L78:
        TextView r116 = this.k;
        if (r116 == null) goto L82;
        r116.setVisibility(8);
    L82:
        FrameLayout r117 = this.j;
        if (r117 == null) goto L86;
        r117.setVisibility(8);
    L86:
        View r118 = this.l;
        if (r118 == null) goto L118;
        r118.setVisibility(8);
        return;
    L118:
        return;
    L90:
        AoSearchService r119 = j64.a.a(AoSearchService.class);
        if (r119 != null) goto L93;
    L95:
        r2 = false;
    L96:
        if (r2 == false) goto L116;
        if (r12 == null) goto L117;
        TextView r120 = this.k;
        if (r120 == null) goto L102;
        r120.setVisibility(8);
    L102:
        FrameLayout r121 = this.j;
        if (r121 == null) goto L106;
        r121.setVisibility(8);
    L106:
        View r122 = this.l;
        if (r122 == null) goto L110;
        r122.setVisibility(8);
    L110:
        View r123 = this.i;
        if (r123 == null) goto L119;
        r123.setVisibility(0);
        return;
    L119:
        return;
    L117:
        return;
    L116:
        return;
    L93:
        if (r119.isAvailable() != true) goto L95;
        goto L95
    }
}
