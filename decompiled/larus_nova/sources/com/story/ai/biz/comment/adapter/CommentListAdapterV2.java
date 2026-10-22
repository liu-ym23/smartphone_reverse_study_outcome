package com.story.ai.biz.comment.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;
import com.larus.platform.api.s3;
import com.larus.platform.model.comment.api.CommentItemCustomType;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.i3;
import com.larus.utils.e1;
import com.story.ai.base.component.list.BaseProviderMultiAdapter;
import com.story.ai.biz.comment.CommentComponent;
import com.story.ai.biz.comment.model.BaseComment;
import com.story.ai.biz.comment.model.CommentPublishState;
import com.story.ai.biz.comment.model.CommentSection;
import com.story.ai.biz.comment.viewmodel.CommentViewModel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BG\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u001b\u001a\u00020\u0017H\u0002J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u0017H\u0002J\u0010\u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u001fH\u0002J\b\u0010#\u001a\u00020\u0017H\u0002J\u0010\u0010$\u001a\u00020\u00172\b\u0010%\u001a\u0004\u0018\u00010\u0019J\u0010\u0010&\u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020\u001fH\u0016J\u0012\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00020(*\u00020\u000eH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R)\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00170\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/story/ai/biz/comment/adapter/CommentListAdapterV2;", "Lcom/story/ai/base/component/list/BaseProviderMultiAdapter;", "Lcom/story/ai/biz/comment/model/CommentSection;", "activity", "Landroid/app/Activity;", "viewModel", "Lcom/story/ai/biz/comment/viewmodel/CommentViewModel;", "commentAdapterCallback", "Lcom/story/ai/biz/comment/adapter/ICommentAdapterCallback;", "holderCreator", "Lcom/larus/platform/model/comment/api/ICustomItemCreator;", "itemCustoms", "", "Lcom/larus/platform/model/comment/api/CommentItemCustomType;", "Lcom/larus/platform/model/comment/api/ICommentItemCustom;", "<init>", "(Landroid/app/Activity;Lcom/story/ai/biz/comment/viewmodel/CommentViewModel;Lcom/story/ai/biz/comment/adapter/ICommentAdapterCallback;Lcom/larus/platform/model/comment/api/ICustomItemCreator;Ljava/util/Map;)V", "footerDelegate", "Lkotlin/Function1;", "Landroid/view/ViewGroup;", "Lkotlin/ParameterName;", "name", "parent", "", "footView", "Landroid/view/View;", "boundFootParent", "addStatusItemProvider", "onCreateViewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewType", "", "initLongClickAction", "doItemLongClick", "position", "initItemClickActions", "setFooterView", "view", "getItemViewType", "toItemProvider", "Lcom/story/ai/base/component/list/BaseItemProvider;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommentListAdapterV2 extends BaseProviderMultiAdapter<CommentSection> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Activity f459782j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final CommentViewModel f459783k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final w f459784l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Map<CommentItemCustomType, rq9.e> f459785m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final h f459786n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View f459787o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ViewGroup f459788p;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int r100) {
        return getItem(r100).getCommentItemType().ordinal();
    }

    public final void z2(final int r100) {
        final BaseComment r101 = null;
        if (i3.f365750a.f() == false) goto L5;
    L17:
        s3.a.a(null, 3);
        return;
    L5:
        if (AccountService.f365697a.isLogin().booleanValue() == false) goto L17;
        CommentSection r102 = getItem(r100);
        if ((r102 instanceof BaseComment) == false) goto L10;
        r101 = (BaseComment) r102;
    L10:
        if (r101 != null) goto L13;
        return;
    L13:
        if (r101.getSendState() != CommentPublishState.SENDING) goto L15;
        return;
    L15:
        notifyItemChanged(r100);
        this.f459783k.sendEvent(new n(this, r101, r100));
    }

    @Override // com.story.ai.base.component.list.BaseProviderMultiAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        dnc.a r102 = (dnc.a) this.f459730a.get(Integer.valueOf(r101));
        if (r102 != null) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == false) goto L12;
        RecyclerView.ViewHolder r104 = r102.d(r100);
        if (r104 == null) goto L12;
        return r104;
    L12:
        dnc.a r105 = (dnc.a) this.f459730a.get(Integer.valueOf(r101));
        if (r105 == null) goto L15;
        int r106 = r105.c();
    L16:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        final View r107 = e1.m(r100).inflate(r106, r100, false);
        return new AnonymousClass1(r107);
    L15:
        r106 = 0;
        goto L16
    L5:
        if (r102.c() != 0) goto L7;
        r103 = true;
        goto L8
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.story.ai.biz.comment.adapter.k] */
    public CommentListAdapterV2(FragmentActivity r100, CommentViewModel r101, CommentComponent.b r102, rq9.g r103, Map r104) {
        Intrinsics.checkNotNullParameter(r101, "viewModel");
        super(CommentItemDiffCallback.f459780a);
        this.f459782j = r100;
        this.f459783k = r101;
        this.f459784l = r102;
        this.f459785m = r104;
        h r105 = new h(this);
        this.f459786n = r105;
        y2(new h0(r101, r102));
        y2(new ChildCommentItemProvider(r101, r102));
        y2(new s(r102));
        y2(new v(r105));
        if (r104 == null) goto L7;
        rq9.e r106 = (rq9.e) r104.get(CommentItemCustomType.EMPTY);
        if (r106 == null) goto L7;
        dnc.a r107 = new o(r106);
    L8:
        if (r104 == null) goto L12;
        rq9.e r108 = (rq9.e) r104.get(CommentItemCustomType.LOADING);
        if (r108 == null) goto L12;
        dnc.a r109 = new o(r108);
    L13:
        if (r104 == null) goto L17;
        rq9.e r110 = (rq9.e) r104.get(CommentItemCustomType.FAIL);
        if (r110 == null) goto L17;
        dnc.a r111 = new o(r110);
    L18:
        y2(r107);
        y2(r109);
        y2(r111);
        if (r103 == null) goto L21;
        y2(new p(r103));
    L21:
        int[] r112 = {R.id.img_header, R.id.view_like_wapper, R.id.tv_content, R.id.tv_send_time, R.id.tv_send_failed_label, R.id.tv_name};
        Intrinsics.checkNotNullParameter(r112, "viewIds");
        this.f459731b = ArraysKt.toList(r112);
        Function3<? super RecyclerView.Adapter<RecyclerView.ViewHolder>, ? super View, ? super Integer, Boolean> r113 = new i(this);
        Intrinsics.checkNotNullParameter(r113, "listener");
        this.f459734e = r113;
        Function3<? super RecyclerView.Adapter<RecyclerView.ViewHolder>, ? super View, ? super Integer, Boolean> r114 = new j(this);
        Intrinsics.checkNotNullParameter(r114, "listener");
        this.f459733d = r114;
        int[] r115 = {R.id.img_header, R.id.view_like_wapper, R.id.tv_send_time, R.id.tv_send_failed_label, R.id.expand_collapse_root, R.id.ll_expand, R.id.ll_collapse, R.id.tv_content, R.id.tv_name};
        Intrinsics.checkNotNullParameter(r115, "viewIds");
        this.f459732c = ArraysKt.toList(r115);
        Function3<? super RecyclerView.Adapter<RecyclerView.ViewHolder>, ? super View, ? super Integer, Unit> r116 = new l(this);
        Intrinsics.checkNotNullParameter(r116, "listener");
        this.f459735f = r116;
        Function3<? super RecyclerView.Adapter<RecyclerView.ViewHolder>, ? super View, ? super Integer, Unit> r117 = new m(this);
        Intrinsics.checkNotNullParameter(r117, "listener");
        this.f459736g = r117;
        return;
    L17:
        r111 = new u(new k(this));
    L12:
        r109 = new c0();
    L7:
        r107 = new q();
        goto L8
    }
}
