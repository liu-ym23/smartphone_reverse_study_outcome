package com.bytedance.ee.bear.middleground.comment.card.aside;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter2;
import com.bytedance.ee.bear.middleground.comment.adapter.aside.AsideCommentCardAdapter;
import com.bytedance.ee.bear.middleground.comment.card.q1;
import com.bytedance.ee.bear.middleground.comment.control.t;
import com.bytedance.ee.bear.middleground.comment.control.y;
import com.bytedance.ee.bear.middleground.comment.control.z;
import com.bytedance.ee.bear.middleground.comment.export.CommentDiffUtils;
import com.bytedance.ee.bear.middleground.comment.export.ICardAdapter;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentAction;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentInputRequest;
import com.bytedance.ee.bear.middleground.comment.export.bean.ErrorBean;
import com.bytedance.ee.bear.middleground.comment.export.w;
import com.bytedance.ee.bear.middleground.comment.input.AsideInputComment;
import com.bytedance.ee.bear.middleground.comment.share.SharePermissionViewModel;
import com.bytedance.ee.bear.middleground.comment.uitls.p;
import com.bytedance.ee.bear.middleground.comment.widget.NoTopFadingEdgeRecyclerView;
import com.bytedance.ee.bear.widgets.universedesign.SpaceShadowLayout;
import com.bytedance.ee.util.ui.n;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.edittext.UDEditText;
import com.ss.android.lark.widget.recyclerview.CommonRecyclerView;
import ef5.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0007\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 p2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u00012\u00020\u0003:\u0002pqB\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJT\u0010>\u001a\u00020%2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010?\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$J\u000e\u0010@\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fJ\u0016\u0010A\u001a\u00020%2\u0006\u0010B\u001a\u00020\u00182\u0006\u0010C\u001a\u00020*J\u000e\u0010D\u001a\u00020%2\u0006\u0010E\u001a\u00020FJ\u000e\u0010G\u001a\u00020%2\u0006\u0010E\u001a\u00020FJ\u0006\u0010H\u001a\u00020%J\u0006\u0010I\u001a\u00020%J,\u0010A\u001a\u00020%2\b\u0010J\u001a\u0004\u0018\u00010(2\u0006\u0010C\u001a\u00020*2\n\b\u0002\u0010K\u001a\u0004\u0018\u00010(H\u0086@¢\u0006\u0002\u0010LJ\u0006\u0010M\u001a\u00020%J\u0006\u00104\u001a\u00020*J\u0010\u0010N\u001a\u00020%2\u0006\u00104\u001a\u00020*H\u0002J\u000e\u0010O\u001a\u00020%2\u0006\u0010P\u001a\u00020(J*\u0010Q\u001a\u00020%2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u001a2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0086@¢\u0006\u0002\u0010RJ&\u0010S\u001a\u00020%2\u0006\u0010T\u001a\u00020(2\u0006\u0010U\u001a\u00020(2\u0006\u0010V\u001a\u00020WH\u0086@¢\u0006\u0002\u0010XJ\u0019\u0010Y\u001a\u0004\u0018\u00010\u00052\b\u0010P\u001a\u0004\u0018\u00010(H\u0016¢\u0006\u0002\u0010ZJ\u0006\u0010[\u001a\u00020*J\u0006\u0010\\\u001a\u00020%J\u0015\u0010]\u001a\u00020%2\b\u0010P\u001a\u0004\u0018\u00010(¢\u0006\u0002\u0010^J\u0016\u0010_\u001a\u00020%2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fJ\u000e\u0010`\u001a\u00020(2\u0006\u0010+\u001a\u00020(J\u0010\u0010a\u001a\u00020%2\u0006\u0010b\u001a\u00020*H\u0016J\u0010\u0010c\u001a\u00020%2\u0006\u0010b\u001a\u00020*H\u0016J\u000f\u0010d\u001a\u0004\u0018\u00010(H\u0016¢\u0006\u0002\u0010eJ\"\u0010f\u001a\u00020%2\u0006\u0010g\u001a\u00020\u00052\u0006\u0010P\u001a\u00020(2\b\b\u0002\u0010b\u001a\u00020*H\u0002J\u001c\u0010h\u001a\u00060\u0002R\u00020\u00002\u0006\u0010i\u001a\u00020j2\u0006\u0010k\u001a\u00020(H\u0017J\b\u0010l\u001a\u00020(H\u0016J\u0010\u0010m\u001a\u00020.2\u0006\u0010P\u001a\u00020(H\u0016J\u001c\u0010n\u001a\u00020%2\n\u0010o\u001a\u00060\u0002R\u00020\u00002\u0006\u0010P\u001a\u00020(H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u001aX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$X\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010&\u001a\u0012\u0012\u0004\u0012\u00020(\u0012\b\u0012\u00060\u0002R\u00020\u00000'X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010+\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0004\n\u0002\u0010,R\u001a\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020.0'X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010/\u001a\u00020.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u000e\u00104\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000108X\u0082\u000e¢\u0006\u0002\n\u0000R)\u00109\u001a\u001d\u0012\u0013\u0012\u00110(¢\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b(=\u0012\u0004\u0012\u00020%0:X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006r"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/card/aside/AsidePageAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/ee/bear/middleground/comment/card/aside/AsidePageAdapter$ViewHolder;", "Lcom/bytedance/ee/bear/middleground/comment/card/ICommentPagerAdapter;", "commentCardRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "commentHandler", "Lcom/bytedance/ee/bear/middleground/comment/card/aside/AsideComment$CommentHandler;", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;Lcom/bytedance/ee/bear/middleground/comment/card/aside/AsideComment$CommentHandler;)V", "getCommentCardRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "getCommentHandler", "()Lcom/bytedance/ee/bear/middleground/comment/card/aside/AsideComment$CommentHandler;", "cards", "", "Lcom/bytedance/ee/bear/middleground/comment/export/bean/CommentBean;", "config", "Lcom/bytedance/ee/bear/middleground/comment/uitls/Config;", "activity", "Landroid/app/Activity;", "per", "Lcom/bytedance/ee/bear/middleground/comment/export/ICommentPermission;", "language", "", "userIds", "", "mIListeners", "Lcom/bytedance/ee/bear/middleground/comment/control/ICommentListeners;", "actionControl", "Lcom/bytedance/ee/bear/middleground/comment/control/ICommentFunction;", "cardDataViewModel", "Lcom/bytedance/ee/bear/middleground/comment/card/CardDataViewModel;", "sharePermissionViewModel", "Lcom/bytedance/ee/bear/middleground/comment/share/SharePermissionViewModel;", "clickLink", "Lkotlin/Function0;", "", "currentPagers", "", "", "isPortrait", "", "currentIndex", "Ljava/lang/Integer;", "commentIdToItemIdMap", "", "itemIdCounter", "getItemIdCounter", "()J", "setItemIdCounter", "(J)V", "canReplay", "mAlignAndScrollManager", "Lcom/bytedance/ee/bear/middleground/comment/card/aside/AlignAndScrollManager;", "switchJob", "Lkotlinx/coroutines/Job;", "avoidKeyboard", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "height", "initPage", "listeners", "getCards", "switchCurrentItem", "commentId", "smooth", "editReply", "input", "Lcom/bytedance/ee/bear/middleground/comment/export/bean/CommentInputRequest;", "addReplay", "cancelHighLight", "resetHighLight", "targetItem", "highLightHeight", "(Ljava/lang/Integer;ZLjava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setInputViewVisibility", "setCanReplay", "clickItem", "position", "updateData", "(Ljava/util/List;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scrollToPosition", "outPosition", "innerPosition", "percentage", "", "(IIFLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getView", "(Ljava/lang/Integer;)Landroidx/recyclerview/widget/RecyclerView;", "onEditStatus", "exitCurrentEditStatus", "exitEditStatus", "(Ljava/lang/Integer;)V", "reSetEditStatus", "findEditViewPosition", "notifyDataChange", "forceContentDiff", "notifyCurrentPosDataChange", "getCurrentPos", "()Ljava/lang/Integer;", "notifyItemPageDataChanged", "recyclerView", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "getItemCount", "getItemId", "onBindViewHolder", "holder", "Companion", "ViewHolder", "middleground-comment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AsidePageAdapter extends RecyclerView.Adapter<ViewHolder> implements q1 {
    public static final int u = 0;
    public final RecyclerView a;
    public final AsideComment.a b;
    public List<CommentBean> c;
    public p d;
    public Activity e;
    public String f;
    public List<String> g;
    public z h;
    public y i;
    public com.bytedance.ee.bear.middleground.comment.card.d j;
    public SharePermissionViewModel k;
    public Function0<Unit> l;
    public final Map<Integer, ViewHolder> m;
    public boolean n;
    public Integer o;
    public final Map<String, Long> p;
    public long q;
    public boolean r;
    public AlignAndScrollManager s;
    public final Function1<? super Integer, Unit> t;

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0006\u0010 \u001a\u00020!J\u000e\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020$J\u0006\u0010%\u001a\u00020!J\b\u0010&\u001a\u00020!H\u0002J\b\u0010'\u001a\u0004\u0018\u00010\u0019R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006("}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/card/aside/AsidePageAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "card", "inputContainer", "Landroid/widget/FrameLayout;", "shadowLayout", "Lcom/bytedance/ee/bear/widgets/universedesign/SpaceShadowLayout;", "topBar", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "<init>", "(Lcom/bytedance/ee/bear/middleground/comment/card/aside/AsidePageAdapter;Landroid/view/View;Landroid/view/View;Landroid/widget/FrameLayout;Lcom/bytedance/ee/bear/widgets/universedesign/SpaceShadowLayout;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;)V", "getView", "()Landroid/view/View;", "getCard", "getInputContainer", "()Landroid/widget/FrameLayout;", "getShadowLayout", "()Lcom/bytedance/ee/bear/widgets/universedesign/SpaceShadowLayout;", "getTopBar", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "inputComment", "Lcom/bytedance/ee/bear/middleground/comment/input/api/ICommentInput;", "replayInputRequest", "Lcom/bytedance/ee/bear/middleground/comment/export/bean/CommentInputRequest;", "getReplayInputRequest", "()Lcom/bytedance/ee/bear/middleground/comment/export/bean/CommentInputRequest;", "setReplayInputRequest", "(Lcom/bytedance/ee/bear/middleground/comment/export/bean/CommentInputRequest;)V", "clearFocus", "", "showInput", "commentBean", "Lcom/bytedance/ee/bear/middleground/comment/export/bean/CommentBean;", "hideInput", "initInputComment", "getInputComment", "middleground-comment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder {
        public final View a;
        public final View b;
        public final FrameLayout c;
        public final SpaceShadowLayout d;
        public final View e;
        public final RecyclerView f;
        public AsideInputComment g;
        public CommentInputRequest h;
        public final /* synthetic */ AsidePageAdapter i;

        public final void T3() {
            this.c.setVisibility(8);
            AsideInputComment r0 = this.g;
            if (r0 != null) goto L5;
        L7:
            boolean r1 = false;
        L8:
            if (r1 == false) goto L35;
            tt5.a.h("Comment#CommentPagerAdapter2", "hideInput, so dismiss inputComment");
            AsideInputComment r2 = this.g;
            if (r2 == null) goto L36;
            p r3 = this.i.d;
            p r5 = null;
            if (r3 != null) goto L15;
            Intrinsics.throwUninitializedPropertyAccessException("config");
            r3 = null;
        L15:
            if (r3.r.isKeyboardShowing() == false) goto L32;
            p r4 = this.i.d;
            if (r4 != null) goto L19;
            Intrinsics.throwUninitializedPropertyAccessException("config");
        L21:
            if (r5.getActivity().getCurrentFocus() == null) goto L31;
            AsideInputComment r6 = this.g;
            if (r6 == null) goto L29;
            UDEditText r7 = r6.e();
            if (r7 == null) goto L29;
            if (r7.hasFocus() != true) goto L29;
            boolean r8 = true;
        L30:
            if (r8 == false) goto L32;
        L29:
            r8 = false;
        L31:
            boolean r9 = true;
        L33:
            kf5.a.a(r2, false, r9, 1);
            return;
        L19:
            r5 = r4;
        L32:
            r9 = false;
            goto L33
        L36:
            return;
        L35:
            return;
        L5:
            if (r0.isShowing() != true) goto L7;
            r1 = true;
            goto L8
        }

        public ViewHolder(AsidePageAdapter r2, View r3, View r4, FrameLayout r5, SpaceShadowLayout r6, View r7, NoTopFadingEdgeRecyclerView r8) {
            Intrinsics.checkNotNullParameter(r3, "view");
            Intrinsics.checkNotNullParameter(r4, "card");
            Intrinsics.checkNotNullParameter(r5, "inputContainer");
            Intrinsics.checkNotNullParameter(r6, "shadowLayout");
            Intrinsics.checkNotNullParameter(r7, "topBar");
            Intrinsics.checkNotNullParameter(r8, "recyclerView");
            this.i = r2;
            super(r3);
            this.a = r3;
            this.b = r4;
            this.c = r5;
            this.d = r6;
            this.e = r7;
            this.f = r8;
        }
    }

    public static final class a {
    }

    static {
        u = n.d(7);
    }

    public final void A2() {
        this.b.b("cancelHighLight", new AsidePageAdapter$cancelHighLight$1(this, null));
    }

    public final void B2() {
        Integer r0 = this.o;
        ICardAdapter r1 = null;
        if (Intrinsics.areEqual(r0, null) == true) goto L56;
        RecyclerView r2 = P0(r0);
        if (r2 == null) goto L8;
        RecyclerView.Adapter r3 = r2.getAdapter();
    L10:
        if ((r3 instanceof ICardAdapter) == false) goto L12;
        ICardAdapter r4 = (ICardAdapter) r3;
    L13:
        if (r4 == null) goto L16;
        CommentBean r5 = r4.getData();
        if (r5 == null) goto L16;
    L20:
        if (r5 == null) goto L57;
        int r6 = com.bytedance.ee.bear.middleground.comment.card.e.a;
        int r7 = com.bytedance.ee.bear.middleground.comment.card.e.a(0, CollectionsKt.mutableListOf(new CommentBean[]{r5}));
        if (r7 == (-2)) goto L55;
        List<CommentBean> r8 = this.c;
        if (r8 == null) goto L40;
        CommentBean r9 = (CommentBean) CollectionsKt.getOrNull(r8, r0.intValue());
        if (r9 == null) goto L40;
        List<CommentBean.CommentDetail> r10 = r9.getComment_list();
        if (r10 == null) goto L40;
        Iterator<T> r11 = r10.iterator();
    L32:
        if (r11.hasNext() == false) goto L36;
        Object r12 = r11.next();
        if (((CommentBean.CommentDetail) r12).isEditStatus() == false) goto L32;
    L37:
        CommentBean.CommentDetail r13 = (CommentBean.CommentDetail) r12;
        if (r13 == null) goto L40;
        r13.setEditStatus(false);
        goto L40
    L36:
        r12 = null;
    L40:
        CommentBean.CommentDetail r14 = (CommentBean.CommentDetail) CollectionsKt.getOrNull(r5.getComment_list(), r7);
        if (r14 == null) goto L43;
        r14.setEditStatus(false);
    L43:
        int r15 = CommentDiffUtils.a;
        RecyclerView r16 = P0(r0);
        if (r16 == null) goto L46;
        RecyclerView.Adapter r17 = r16.getAdapter();
    L48:
        if ((r17 instanceof ICardAdapter) == false) goto L50;
        r1 = (ICardAdapter) r17;
    L50:
        CommentDiffUtils.b(r1, Integer.valueOf(r7));
        F2();
        return;
    L46:
        r17 = null;
        goto L48
    L55:
        return;
    L57:
        return;
    L16:
        List<CommentBean> r18 = this.c;
        if (r18 == null) goto L19;
        r5 = (CommentBean) CollectionsKt.getOrNull(r18, r0.intValue());
        goto L20
    L19:
        r5 = null;
        goto L20
    L12:
        r4 = null;
        goto L13
    L8:
        r3 = null;
        goto L10
    }

    public final int getItemCount() {
        List<CommentBean> r0 = this.c;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.size();
    }

    public final boolean z2() {
        Integer r0 = this.o;
        if (r0 == null) goto L38;
        int r1 = r0.intValue();
        com.bytedance.ee.bear.middleground.comment.card.d r2 = this.j;
        com.bytedance.ee.bear.middleground.comment.card.d r3 = null;
        if (r2 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("cardDataViewModel");
        r2 = null;
    L7:
        boolean r4 = r2.r(r1);
        p r5 = this.d;
        if (r5 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("config");
        r5 = null;
    L10:
        boolean r6 = r5.q.getComment();
        int r7 = com.bytedance.ee.bear.middleground.comment.card.e.a;
        com.bytedance.ee.bear.middleground.comment.card.d r8 = this.j;
        if (r8 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("cardDataViewModel");
        r8 = null;
    L13:
        MutableLiveData<List<CommentBean>> r9 = r8.f;
        if (r9 == null) goto L16;
        List r10 = (List) r9.getValue();
    L17:
        boolean r11 = !com.bytedance.ee.bear.middleground.comment.card.e.c(r10);
        tt5.a.h("Comment#CommentPagerAdapter2", "canReplay visiable = " + r11 + ", isUnSubmitComment = " + r4 + ", hasPerReply = " + r6);
        if (r11 == false) goto L38;
        com.bytedance.ee.bear.middleground.comment.card.d r12 = this.j;
        if (r12 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("cardDataViewModel");
        r12 = null;
    L23:
        if (r12.m(r1) == false) goto L38;
        com.bytedance.ee.bear.middleground.comment.card.d r13 = this.j;
        if (r13 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("cardDataViewModel");
        r13 = null;
    L28:
        if (r13.n(r1) == true) goto L38;
        com.bytedance.ee.bear.middleground.comment.card.d r14 = this.j;
        if (r14 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("cardDataViewModel");
    L34:
        if (r3.l(r1, CommentAction.INPUT) == true) goto L38;
        if (r4 == false) goto L38;
        if (r6 == false) goto L38;
        return true;
    L32:
        r3 = r14;
        goto L34
    L16:
        r10 = null;
    L38:
        return false;
    }

    public final void F2() {
        if (z2() == false) goto L5;
        E2(true);
        return;
    L5:
        E2(false);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.q1
    public final Integer E() {
        return this.o;
    }

    public final void D2(List<CommentBean> r13) {
        Integer r1 = this.o;     // Catch: Exception -> L63
        if (r1 == null) goto L65;
        int r2 = r1.intValue();     // Catch: Exception -> L63
        int r3 = com.bytedance.ee.bear.middleground.comment.card.e.a;     // Catch: Exception -> L63
        if (com.bytedance.ee.bear.middleground.comment.card.e.c(this.c) == false) goto L77;
        List<CommentBean> r4 = this.c;     // Catch: Exception -> L63
        if (r4 == null) goto L12;
        CommentBean r5 = (CommentBean) ListProtector.get(r4, r2);     // Catch: Exception -> L63
        if (r5 == null) goto L12;
        String r6 = r5.getComment_id();     // Catch: Exception -> L63
    L13:
        int r7 = com.bytedance.ee.bear.middleground.comment.card.e.a(r2, this.c);     // Catch: Exception -> L63
        List<CommentBean> r8 = this.c;     // Catch: Exception -> L63
        if (r8 == null) goto L24;
        CommentBean r9 = (CommentBean) ListProtector.get(r8, r2);     // Catch: Exception -> L63
        if (r9 == null) goto L24;
        List<CommentBean.CommentDetail> r10 = r9.getComment_list();     // Catch: Exception -> L63
        if (r10 == null) goto L24;
        CommentBean.CommentDetail r11 = (CommentBean.CommentDetail) ListProtector.get(r10, r7);     // Catch: Exception -> L63
        if (r11 == null) goto L24;
        String r12 = r11.getReply_id();     // Catch: Exception -> L63
        if (r12 == null) goto L24;
    L26:
        if (r12.length() <= 0) goto L28;
        boolean r14 = true;
    L29:
        if (r14 == false) goto L61;
        if (r13 == null) goto L61;
        Iterator<T> r15 = r13.iterator();     // Catch: Exception -> L63
        int r16 = 0;
    L33:
        if (r15.hasNext() == false) goto L61;
        Object r17 = r15.next();     // Catch: Exception -> L63
        int r18 = r16 + 1;     // Catch: Exception -> L63
        if (r16 >= 0) goto L37;
        CollectionsKt.throwIndexOverflow();     // Catch: Exception -> L63
    L37:
        CommentBean r19 = (CommentBean) r17;     // Catch: Exception -> L63
        if (Intrinsics.areEqual(r19.getComment_id(), r6) == false) goto L60;
        List<CommentBean.CommentDetail> r20 = r19.getComment_list();     // Catch: Exception -> L63
        if (r20 == null) goto L60;
        Iterator<T> r21 = r20.iterator();     // Catch: Exception -> L63
        int r22 = 0;
    L43:
        if (r21.hasNext() == false) goto L60;
        Object r23 = r21.next();     // Catch: Exception -> L63
        int r24 = r22 + 1;     // Catch: Exception -> L63
        if (r22 >= 0) goto L47;
        CollectionsKt.throwIndexOverflow();     // Catch: Exception -> L63
    L47:
        CommentBean.CommentDetail r25 = (CommentBean.CommentDetail) r23;     // Catch: Exception -> L63
        boolean r110 = r25.isEditStatus();     // Catch: Exception -> L63
        r25.setEditStatus(Intrinsics.areEqual(r25.getReply_id(), r12));     // Catch: Exception -> L63
        if (r110 == r25.isEditStatus()) goto L59;
        RecyclerView r26 = P0(Integer.valueOf(r16));     // Catch: Exception -> L63
        if (r26 == null) goto L52;
        RecyclerView.Adapter r27 = r26.getAdapter();     // Catch: Exception -> L63
    L54:
        if ((r27 instanceof ICardAdapter) == false) goto L56;
        ICardAdapter r28 = (ICardAdapter) r27;     // Catch: Exception -> L63
    L57:
        if (r28 == null) goto L59;
        int r111 = CommentDiffUtils.a;     // Catch: Exception -> L63
        CommentDiffUtils.b(r28, Integer.valueOf(r22));     // Catch: Exception -> L63
        goto L59
    L56:
        r28 = null;
        goto L57
    L52:
        r27 = null;
    L59:
        r22 = r24;
    L60:
        r16 = r18;
    L61:
        F2();     // Catch: Exception -> L63
        return;
    L28:
        r14 = false;
    L24:
        r12 = "";
    L12:
        r6 = null;
        goto L13
    L77:
        return;
    L65:
        return;
    L63:
        e = move-exception;
        tt5.a.f("Comment#CommentPagerAdapter2", e, false);
    }

    public final void E2(boolean r2) {
        if (r2 == this.r) goto L10;
        this.r = r2;
        if (this.a.isComputingLayout() == true) goto L11;
        Integer r3 = this.o;
        if (r3 == null) goto L12;
        notifyItemChanged(r3.intValue(), new Object());
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.q1
    public final RecyclerView P0(Integer r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        ViewHolder r4 = (ViewHolder) ((LinkedHashMap) this.m).get(r3);
        if (r4 != null) goto L8;
        return null;
    L8:
        return r4.f;
    }

    public final long getItemId(int r7) {
        List<CommentBean> r0 = this.c;
        if (r0 == null) goto L7;
        CommentBean r8 = (CommentBean) ListProtector.get(r0, r7);
        if (r8 == null) goto L7;
        String r9 = r8.getComment_id();
    L9:
        if (r9 != null) goto L11;
    L23:
        tt5.a.d("Comment#CommentPagerAdapter2", "commentId is empty!");
        return -1;
    L11:
        if (r9.length() != 0) goto L13;
        boolean r2 = true;
    L14:
        if (r2 == true) goto L23;
        if (this.p.containsKey(r9) == false) goto L19;
        Long r10 = (Long) ((LinkedHashMap) this.p).get(r9);
    L20:
        if (r10 != null) goto L22;
        return -1;
    L22:
        return r10.longValue();
    L19:
        long r3 = this.q;
        this.q = 1 + r3;
        Long r4 = Long.valueOf(r3);
        this.p.put(r9, r4);
        r10 = Long.valueOf(r3);
        goto L20
    L13:
        r2 = false;
    L7:
        r9 = null;
        goto L9
    }

    public final void y2(CommentInputRequest r4) {
        Intrinsics.checkNotNullParameter(r4, "input");
        this.b.b("addReplay", new AsidePageAdapter$addReplay$1(this, r4, null));
    }

    public AsidePageAdapter(CommonRecyclerView r2, AsideComment.a r3) {
        Intrinsics.checkNotNullParameter(r2, "commentCardRecyclerView");
        Intrinsics.checkNotNullParameter(r3, "commentHandler");
        this.a = r2;
        this.b = r3;
        this.m = new LinkedHashMap();
        this.n = true;
        this.p = new LinkedHashMap();
        this.t = new AsidePageAdapter$avoidKeyboard$1(this);
        setHasStableIds(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1, types: [com.bytedance.ee.bear.middleground.comment.uitls.p] */
    /* JADX WARN: Type inference failed for: r5v24 */
    /* JADX WARN: Type inference failed for: r5v3 */
    public final void onBindViewHolder(RecyclerView.ViewHolder r21, final int r22) {
        final ViewHolder r2 = (ViewHolder) r21;
        Intrinsics.checkNotNullParameter(r2, "holder");
        ((LinkedHashMap) this.m).values().remove(r2);
        Integer r3 = Integer.valueOf(r22);
        this.m.put(r3, r2);
        View r4 = r2.e;
        Integer r5 = this.o;
        if (r5 != null) goto L6;
    L8:
        boolean r6 = false;
    L9:
        if (r6 == false) goto L11;
        int r7 = 0;
    L12:
        r4.setVisibility(r7);
        C2(r2.f, r22, false);
        Integer r8 = this.o;
        if (r8 != null) goto L16;
    L115:
        AsideCommentCardAdapter r9 = null;
        r2.T3();
        r2.d.setShadowColor(0);
    L116:
        RecyclerView.Adapter r10 = r2.f.getAdapter();
        if ((r10 instanceof AsideCommentCardAdapter) == false) goto L119;
        AsideCommentCardAdapter r11 = (AsideCommentCardAdapter) r10;
    L120:
        if (r11 == null) goto L123;
        r11.setOnClickEmpty(new AsidePageAdapter$onBindViewHolder$1$1(r2, this, r22));
        r11.setCommentControlCallback(new g(r2));
        return;
    L123:
        return;
    L119:
        r11 = r9;
        goto L120
    L16:
        if (r8.intValue() != r22) goto L115;
        F2();
        boolean r12 = z2();
        this.r = r12;
        if (r12 == false) goto L110;
        List<CommentBean> r13 = this.c;
        if (r13 == null) goto L23;
        CommentBean r14 = (CommentBean) ListProtector.get(r13, r22);
        if (r14 == null) goto L23;
    L24:
        Intrinsics.checkNotNullParameter(r14, "commentBean");
        if (r2.g != null) goto L47;
        p r15 = r2.i.d;
        if (r15 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("config");
        p r16 = null;
    L31:
        z r17 = r2.i.h;
        if (r17 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("mIListeners");
        z r18 = null;
    L35:
        com.bytedance.ee.bear.middleground.comment.card.d r19 = r2.i.j;
        if (r19 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("cardDataViewModel");
        r19 = null;
    L38:
        t r20 = r19.c;
        if (r20 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("dataControl");
        t r110 = null;
    L42:
        CommentInputRequest r111 = new CommentInputRequest();
        f r112 = new f();
        SharePermissionViewModel r23 = r2.i.k;
        if (r23 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("sharePermissionViewModel");
        SharePermissionViewModel r113 = null;
    L46:
        Function1<? super Integer, Unit> r24 = r2.i.t;
        final AsidePageAdapter r25 = r2.i;
        Function1<String, Unit> r114 = new AsidePageAdapter$ViewHolder$initInputComment$2(r25);
        final AsidePageAdapter r26 = r2.i;
        Function5<String, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity>, Boolean, String, Boolean, Unit> r27 = new AsidePageAdapter$ViewHolder$initInputComment$3(r2, r26);
        final AsidePageAdapter r28 = r2.i;
        r2.g = new AsideInputComment(r16, r18, r110, r114, r111, r27, new AsidePageAdapter$ViewHolder$initInputComment$4(r28), r113, r112, r24);
        goto L47
    L45:
        r113 = r23;
        goto L46
    L41:
        r110 = r20;
        goto L42
    L34:
        r18 = r17;
        goto L35
    L30:
        r16 = r15;
    L47:
        r2.c.setVisibility(0);
        CommentInputRequest r29 = r2.h;
        r2.h = null;
        if (r29 != null) goto L63;
        int r30 = com.bytedance.ee.bear.middleground.comment.input.utils.b.a;
        List<CommentBean> r31 = r2.i.c;
        if (r31 == null) goto L53;
        CommentBean r32 = (CommentBean) ListProtector.get(r31, r2.getPosition());
        if (r32 == null) goto L53;
    L54:
        CommentBean r33 = r32;
        p r34 = r2.i.d;
        if (r34 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("config");
        p r35 = null;
    L59:
        if (r14.isNewInput() == false) goto L61;
        int r115 = 0;
    L62:
        CommentInputRequest r36 = com.bytedance.ee.bear.middleground.comment.input.utils.b.a(r33, r35, r115, null, null, MapsKt.emptyMap(), null, null, 472);
    L65:
        if (r14.isNewInput() == false) goto L67;
        r9 = null;
        r36.comment_id = null;
    L68:
        AsideInputComment r37 = r2.g;
        if (r37 == null) goto L71;
        Object r38 = r37.j;
    L72:
        if (r37 == null) goto L74;
        r37.p(r36);
    L74:
        AsideInputComment r39 = r2.g;
        if (r39 == null) goto L79;
        boolean r116 = true;
        if (r39.isShowing() != true) goto L80;
        boolean r40 = true;
    L81:
        if (r40 == false) goto L101;
        AsideInputComment r41 = r2.g;
        if (r41 == null) goto L89;
        View r42 = r41.k;
        if (r42 == null) goto L89;
        if (r42.isAttachedToWindow() != r116) goto L89;
        boolean r43 = true;
    L90:
        if (r43 == false) goto L101;
        if (Objects.equals(r38, r36) == true) goto L111;
        AsideInputComment r44 = r2.g;
        if (r44 == null) goto L111;
        if (r14.isNewInput() == true) goto L100;
        if (r29 != null) goto L100;
        r116 = false;
    L100:
        r44.update(r116);
    L111:
        SpaceShadowLayout r45 = r2.d;
        p r46 = this.d;
        ?? r47 = r46;
        if (r46 != null) goto L114;
        Intrinsics.throwUninitializedPropertyAccessException("config");
        r47 = r9;
    L114:
        r45.setShadowColor(ContextCompat.getColor(r47.getActivity(), 2131108966));
    L89:
        r43 = false;
    L101:
        AsideInputComment r117 = r2.g;
        if (r117 == null) goto L111;
        if (r14.isNewInput() == true) goto L108;
        if (r29 != null) goto L108;
        boolean r118 = false;
    L109:
        kf5.a.b(r117, false, false, r118, false, false, 27);
    L108:
        r118 = true;
    L80:
        r40 = false;
        goto L81
    L79:
        r116 = true;
        goto L80
    L71:
        r38 = r9;
        goto L72
    L67:
        r9 = null;
        goto L68
    L61:
        r115 = 2;
        goto L62
    L57:
        r35 = r34;
    L53:
        r32 = new CommentBean();
        goto L54
    L63:
        r36 = r29;
    L23:
        r14 = new CommentBean();
        goto L24
    L110:
        r9 = null;
        r2.T3();
        goto L111
    L11:
        r7 = 8;
        goto L12
    L6:
        if (r5.intValue() != r22) goto L8;
        r6 = true;
        goto L9
    }

    /* JADX WARN: Type inference failed for: r5v1, types: [android.view.ViewGroup, com.bytedance.ee.bear.widgets.universedesign.SpaceShadowLayout, java.lang.Object] */
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r22, int r23) {
        Intrinsics.checkNotNullParameter(r22, "parent");
        View r2 = LayoutInflater.from(r22.getContext()).inflate(2131558724, r22, false);
        View r4 = r2.findViewById(2131367315);
        CommonRecyclerView r7 = (NoTopFadingEdgeRecyclerView) r2.findViewById(2131363250);
        ?? r5 = (SpaceShadowLayout) r2.findViewById(2131363248);
        r5.setOnClickListener(new h(this));
        FrameLayout r6 = (FrameLayout) r2.findViewById(2131375355);
        View r9 = r2.findViewById(2131389181);
        r9.setOnClickListener(new i(this));
        r7.h = false;
        final Activity r0 = this.e;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("activity");
        r0 = null;
    L5:
        r7.setLayoutManager(new AnonymousClass3(r0));
        r7.setOverScrollMode(2);
        p r10 = this.d;
        if (r10 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("config");
        p r11 = null;
    L9:
        List<String> r12 = this.g;
        if (r12 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("userIds");
        List<String> r13 = null;
    L13:
        z r14 = this.h;
        if (r14 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("mIListeners");
        z r15 = null;
    L17:
        y r16 = this.i;
        if (r16 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("actionControl");
        y r17 = null;
    L21:
        SharePermissionViewModel r18 = this.k;
        if (r18 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("sharePermissionViewModel");
        SharePermissionViewModel r19 = null;
    L25:
        com.bytedance.ee.bear.middleground.comment.card.d r110 = this.j;
        if (r110 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("cardDataViewModel");
        com.bytedance.ee.bear.middleground.comment.card.d r111 = null;
    L29:
        String r112 = this.f;
        if (r112 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("language");
        String r113 = null;
    L33:
        Function1<? super Integer, Unit> r114 = this.t;
        Function0<Unit> r1 = this.l;
        if (r1 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("clickLink");
        Function0<Unit> r115 = null;
    L37:
        r7.setAdapter(new AsideCommentCardAdapter(r11, r13, r15, r17, r19, r111, r113, r114, r115));
        r7.setTouchViewListener(new j(this));
        r7.setVerticalFadingEdgeEnabled(true);
        r7.setFadingEdgeLength(n.d(16));
        if ((r7.getItemAnimator() instanceof SimpleItemAnimator) == false) goto L40;
        SimpleItemAnimator r3 = r7.getItemAnimator();
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type androidx.recyclerview.widget.SimpleItemAnimator");
        r3.setSupportsChangeAnimations(false);
    L40:
        r7.setItemAnimator(null);
        p r8 = this.d;
        if (r8 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("config");
        r8 = null;
    L43:
        gf5.d r20 = r8.N;
        Intrinsics.checkNotNull(r7);
        r20.a(new ef5.z(r7));
        Intrinsics.checkNotNull(r2);
        Intrinsics.checkNotNull(r4);
        Intrinsics.checkNotNull(r6);
        Intrinsics.checkNotNull(r5);
        Intrinsics.checkNotNull(r9);
        return new ViewHolder(this, r2, r4, r6, r5, r9, r7);
    L36:
        r115 = r1;
        goto L37
    L32:
        r113 = r112;
        goto L33
    L28:
        r111 = r110;
        goto L29
    L24:
        r19 = r18;
        goto L25
    L20:
        r17 = r16;
        goto L21
    L16:
        r15 = r14;
        goto L17
    L12:
        r13 = r12;
        goto L13
    L8:
        r11 = r10;
        goto L9
    }

    public final void C2(RecyclerView r18, int r19, boolean r20) {
        tt5.a.b("Comment#CommentPagerAdapter2", "notifyItemPageDataChanged: position = " + r19);
        RecyclerView.Adapter r2 = r18.getAdapter();
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter2");
        CardAdapter2 r3 = (CardAdapter2) r2;
        List<CommentBean> r4 = this.c;
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlin.collections.List<com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean>");
        CommentBean r5 = (CommentBean) ListProtector.get(r4, r19);
        List<CommentBean.CommentDetail> r6 = r5.getComment_list();
        if (r6 != null) goto L5;
        r6 = new ArrayList();
    L5:
        p r7 = this.d;
        if (r7 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("config");
        r7 = null;
    L8:
        r7.N.a(new ef5.a(r5));
        int r8 = k.a;
        p r9 = this.d;
        if (r9 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("config");
        r9 = null;
    L11:
        Intrinsics.checkNotNullParameter(r9, "config");
        Intrinsics.checkNotNullParameter(r5, "commentBean");
        Intrinsics.checkNotNullParameter(r6, "commentList");
        boolean r13 = true;
        if ((!r6.isEmpty()) == false) goto L17;
        if (((CommentBean.CommentDetail) ListProtector.get(r6, 0)).getReplyType() < 0) goto L17;
        k.a(r6, ((CommentBean.CommentDetail) ListProtector.get(r6, 0)).getComment_id(), ((CommentBean.CommentDetail) ListProtector.get(r6, 0)).getCommentType(), r5);
    L30:
        List<CommentBean.CommentDetail> r10 = r3.getCommentDetails();
        r3.setQuote(r5.getQuote());
        r3.setParentToken(r5.getParentToken());
        r3.setParentType(r5.getParentType());
        r3.setPosition(r5.getPosition());
        r3.setBizParams(r5.getBizParams());
        if (TextUtils.isEmpty(r5.getCurrentReplyId()) == true) goto L36;
        com.bytedance.ee.bear.middleground.comment.card.d r11 = this.j;
        if (r11 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("cardDataViewModel");
        r11 = null;
    L35:
        r11.i = r5.getCurrentReplyId();
    L36:
        p r12 = this.d;
        if (r12 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("config");
        r12 = null;
    L40:
        if (r12.getActivity().getResources().getConfiguration().orientation == 2) goto L42;
        boolean r14 = true;
    L43:
        ICardAdapter r15 = r18.getAdapter();
        if ((r15 instanceof ICardAdapter) == false) goto L46;
        ICardAdapter r16 = r15;
    L47:
        if (r16 == null) goto L49;
        w r17 = r16.getUiState();
    L50:
        Integer r21 = this.o;
        if (r21 != null) goto L54;
    L55:
        if (r17 == null) goto L57;
        String r22 = r17.a;
    L58:
        if (r22 == null) goto L64;
        int r23 = CommentDiffUtils.a;
        ICardAdapter r24 = r18.getAdapter();
        if ((r24 instanceof ICardAdapter) == false) goto L62;
        ICardAdapter r25 = r24;
    L63:
        CommentDiffUtils.b(r25, r17.b);
        goto L64
    L62:
        r25 = null;
    L64:
        int r26 = CommentDiffUtils.a;
        p r27 = this.d;
        if (r27 != null) goto L68;
        Intrinsics.throwUninitializedPropertyAccessException("config");
        r27 = null;
    L68:
        if (this.n == r14) goto L70;
        boolean r28 = true;
    L71:
        String r29 = r5.getCurrentReplyId();
        if (r29 != null) goto L74;
        String r30 = "";
    L75:
        p r31 = this.d;
        if (r31 != null) goto L78;
        Intrinsics.throwUninitializedPropertyAccessException("config");
        r31 = null;
    L78:
        CommentDiffUtils.a(r3, r27, r5, r20, r28, r30, r31.e0);
        r3.setCardPos(r19);
        p r1 = this.d;
        if (r1 != null) goto L82;
        Intrinsics.throwUninitializedPropertyAccessException("config");
        r1 = null;
    L82:
        if (r1.getActivity().getResources().getConfiguration().orientation != 2) goto L85;
        r13 = false;
    L85:
        this.n = r13;
        p r32 = this.d;
        if (r32 != null) goto L88;
        Intrinsics.throwUninitializedPropertyAccessException("config");
        r32 = null;
    L88:
        r32.N.a(new x(r18, r5, r10));
        return;
    L74:
        r30 = r29;
        goto L75
    L70:
        r28 = false;
        goto L71
    L57:
        r22 = null;
        goto L58
    L54:
        if (r21.intValue() == r19) goto L64;
    L49:
        r17 = null;
        goto L50
    L46:
        r16 = null;
        goto L47
    L42:
        r14 = false;
    L17:
        if (r6.size() <= 2) goto L22;
        if (((CommentBean.CommentDetail) ListProtector.get(r6, 0)).getReplyType() >= 0) goto L22;
        ((CommentBean.CommentDetail) ListProtector.get(r6, 0)).setComment_id(((CommentBean.CommentDetail) ListProtector.get(r6, 0)).getComment_id());
        ((CommentBean.CommentDetail) ListProtector.get(r6, 0)).setReply_id(r5.getQuote() + r5.isUnSubmitComment());
        ((CommentBean.CommentDetail) ListProtector.get(r6, 0)).setContent(r5.getQuote());
        ((CommentBean.CommentDetail) ListProtector.get(r6, 0)).setCommentType(((CommentBean.CommentDetail) ListProtector.get(r6, 0)).getCommentType());
        ((CommentBean.CommentDetail) ListProtector.get(r6, 0)).setUser_id(r5.getUserId());
        ((CommentBean.CommentDetail) ListProtector.get(r6, 0)).setReplyType(-1);
    L22:
        if (r6.isEmpty() == false) goto L30;
        if (r5.isNewInput() == false) goto L30;
        k.a(r6, r5.getComment_id(), r5.getCommentType(), r5);
        CommentBean.CommentDetail r33 = new CommentBean.CommentDetail();
        r33.setReplyType(3);
        r9.h.getClass();
        r33.setName(com.bytedance.ee.bear.middleground.comment.p.b());
        r33.setComment_id(r5.getComment_id());
        r33.setCommentType(r5.getCommentType());
        r33.setUser_id(r5.getUserId());
        r9.h.getClass();
        AccountService.Account r34 = ((h0) org.koin.java.a.a(h0.class)).G2();
        if (r34 == null) goto L28;
        String r35 = r34.avatarUrl;
    L29:
        r33.setAvatar_url(r35);
        r33.setReply_id(r5.getComment_id());
        r33.setError(new ErrorBean());
        r6.add(r33);
        goto L30
    L28:
        r35 = "";
        goto L29
    }

    public final Object H2(List<String> r11, List<CommentBean> r12, Continuation<? super Unit> r13) {
        D2(r12);
        this.g = r11;
        List<CommentBean> r14 = this.c;
        this.c = r12;
        AlignAndScrollManager r0 = this.s;
        if (r0 == null) goto L81;
        Integer r1 = this.o;
        tt5.a.h("Comment#AlignAndScrollManager", "lockAnchorPoint currentIndex = " + r1);
        List<CommentBean> r2 = r14;
        boolean r4 = true;
        if (r2 != null) goto L7;
    L10:
        boolean r3 = true;
    L11:
        if (r3 == true) goto L74;
        List<CommentBean> r5 = r12;
        if (r5 != null) goto L15;
    L18:
        if (r4 == true) goto L74;
        if (r1 == null) goto L39;
        Iterator<CommentBean> r6 = r12.iterator();
        int r7 = 0;
    L24:
        if (r6.hasNext() == false) goto L33;
        String r8 = r6.next().getComment_id();
        CommentBean r9 = (CommentBean) CollectionsKt.getOrNull(r14, r1.intValue());
        if (r9 == null) goto L28;
        String r10 = r9.getComment_id();
    L30:
        if (Intrinsics.areEqual(r8, r10) == true) goto L34;
        r7 = r7 + 1;
    L34:
        if (r7 < 0) goto L39;
        Object r15 = r0.d(r1.intValue(), r7, r13);
        if (r15 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L76;
        r15 = Unit.INSTANCE;
    L76:
        if (r15 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L79;
        return r15;
    L79:
        return Unit.INSTANCE;
    L28:
        r10 = null;
        goto L30
    L33:
        r7 = -1;
    L39:
        LinearLayoutManager r16 = r0.b.getLayoutManager();
        if ((r16 instanceof LinearLayoutManager) == false) goto L42;
        LinearLayoutManager r17 = r16;
    L43:
        if (r17 == null) goto L45;
        int r18 = r17.findFirstVisibleItemPosition();
    L46:
        if (r17 == null) goto L48;
        int r19 = r17.findLastVisibleItemPosition();
    L49:
        if (r18 < 0) goto L73;
        if (r19 < 0) goto L73;
        if (r18 > r19) goto L72;
    L53:
        Iterator<CommentBean> r20 = r12.iterator();
        int r21 = 0;
    L55:
        if (r20.hasNext() == false) goto L64;
        String r22 = r20.next().getComment_id();
        CommentBean r23 = (CommentBean) CollectionsKt.getOrNull(r14, r18);
        if (r23 == null) goto L59;
        String r24 = r23.getComment_id();
    L61:
        if (Intrinsics.areEqual(r22, r24) == true) goto L65;
        r21 = r21 + 1;
    L65:
        if (r21 >= 0) goto L66;
        if (r18 == r19) goto L72;
        r18 = r18 + 1;
        goto L53
    L66:
        r15 = r0.d(r18, r21, r13);
        if (r15 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L76;
        r15 = Unit.INSTANCE;
        goto L76
    L59:
        r24 = null;
        goto L61
    L64:
        r21 = -1;
    L72:
        r15 = Unit.INSTANCE;
    L73:
        r15 = Unit.INSTANCE;
        goto L76
    L48:
        r19 = -1;
        goto L49
    L45:
        r18 = -1;
        goto L46
    L42:
        r17 = null;
        goto L43
    L15:
        if (r5.isEmpty() == true) goto L18;
        r4 = false;
    L74:
        r15 = Unit.INSTANCE;
        goto L76
    L7:
        if (r2.isEmpty() == true) goto L10;
        r3 = false;
        goto L11
    L81:
        return Unit.INSTANCE;
    }

    public final Object G2(Integer r25, boolean r26, Integer r27, Continuation<? super Unit> r28) {
        Integer r2 = r25;
        if ((r28 instanceof AsidePageAdapter$switchCurrentItem$2) == false) goto L7;
        AsidePageAdapter$switchCurrentItem$2 r3 = (AsidePageAdapter$switchCurrentItem$2) r28;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        Object r1 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        p r13 = null;
        if (r6 == 0) goto L22;
        if (r6 == 1) goto L21;
        if (r6 == 2) goto L20;
        if (r6 == 3) goto L19;
        if (r6 == 4) goto L18;
        if (r6 != 5) goto L17;
        ResultKt.throwOnFailure(r1);
    L158:
        return Unit.INSTANCE;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        int r7 = r3.I$0;
        String r8 = (String) r3.L$3;
        String r9 = (String) r3.L$2;
        String r10 = (String) r3.L$1;
        Integer r11 = (Integer) r3.L$0;
        ResultKt.throwOnFailure(r1);
    L138:
        Boolean r12 = (Boolean) r1;
        int r16 = r7;
        String r18 = r8;
        r2 = r11;
    L140:
        AlignAndScrollManager r14 = this.s;
        if (r14 == null) goto L143;
        Integer r15 = r14.a(r2.intValue());
    L144:
        if (r15 == null) goto L146;
        r15 = Boxing.boxInt(n.E(r15.intValue()));
    L146:
        Integer r20 = r15;
        if (Intrinsics.areEqual(r10, r9) == true) goto L152;
        p r17 = this.d;
        if (r17 != null) goto L151;
        Intrinsics.throwUninitializedPropertyAccessException("config");
        r17 = null;
    L151:
        r17.N.a(new ef5.j(r2, r16, r9, r18, r10, r20));
    L152:
        AlignAndScrollManager r19 = this.s;
        if (r19 == null) goto L160;
        int r21 = r2.intValue();
        r3.L$0 = null;
        r3.L$1 = null;
        r3.L$2 = null;
        r3.L$3 = null;
        r3.label = 5;
        if (r19.f(r21, r3) != r5) goto L158;
        return r5;
    L160:
        return Unit.INSTANCE;
    L143:
        r15 = null;
        goto L144
    L19:
        int r22 = r3.I$0;
        r8 = (String) r3.L$3;
        r9 = (String) r3.L$2;
        r10 = (String) r3.L$1;
        Integer r110 = (Integer) r3.L$0;
        ResultKt.throwOnFailure(r1);
        int r111 = r22;
        r2 = r110;
    L130:
        Boolean r23 = (Boolean) r1;
    L132:
        AlignAndScrollManager r24 = this.s;
        if (r24 == null) goto L139;
        int r112 = r2.intValue();
        r3.L$0 = r2;
        r3.L$1 = r10;
        r3.L$2 = r9;
        r3.L$3 = r8;
        r3.I$0 = r111;
        r3.label = 4;
        r1 = r24.b(r112, r3);
        if (r1 != r5) goto L137;
        return r5;
    L137:
        r11 = r2;
        r7 = r111;
        goto L138
    L139:
        r18 = r8;
        r16 = r111;
        goto L140
    L20:
        ResultKt.throwOnFailure(r1);
    L56:
        return Unit.INSTANCE;
    L21:
        r2 = (Integer) r3.L$0;
        ResultKt.throwOnFailure(r1);
    L46:
        if (((Boolean) r1).booleanValue() != true) goto L48;
        boolean r29 = true;
    L49:
        if (r29 == false) goto L56;
        AlignAndScrollManager r30 = this.s;
        if (r30 == null) goto L56;
        int r31 = r2.intValue();
        r3.L$0 = null;
        r3.label = 2;
        if (r30.f(r31, r3) != r5) goto L56;
        return r5;
    L48:
        r29 = false;
        goto L49
    L22:
        ResultKt.throwOnFailure(r1);
        tt5.a.h("Comment#CommentPagerAdapter2", "switchCurrentItem targetItem = " + r2 + " smooth = " + r26);
        com.bytedance.ee.bear.middleground.comment.card.d r32 = this.j;
        if (r32 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("cardDataViewModel");
        r32 = null;
    L25:
        String r113 = r32.k;
        com.bytedance.ee.bear.middleground.comment.card.d r33 = this.j;
        if (r33 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("cardDataViewModel");
        r33 = null;
    L28:
        com.bytedance.ee.bear.middleground.comment.card.d r114 = this.j;
        if (r114 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("cardDataViewModel");
        r114 = null;
    L31:
        String r115 = r114.f(r2);
        r33.getClass();
        Intrinsics.checkNotNullParameter(r115, "<set-?>");
        r33.k = r115;
        if (Intrinsics.areEqual(r2, this.o) == false) goto L57;
        com.bytedance.ee.bear.middleground.comment.card.d r34 = this.j;
        if (r34 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("cardDataViewModel");
        r34 = null;
    L37:
        if (Intrinsics.areEqual(r113, r34.k) == false) goto L57;
        if (r27 == null) goto L56;
        if (r2 == null) goto L56;
        AlignAndScrollManager r35 = this.s;
        if (r35 == null) goto L48;
        int r36 = r25.intValue();
        int r37 = r27.intValue();
        r3.L$0 = r2;
        r3.label = 1;
        r1 = r35.e(r36, r37, r3);
        if (r1 != r5) goto L46;
        return r5;
    L57:
        B2();
        Integer r38 = this.o;
        if (r2 != null) goto L60;
    L63:
        Integer r116 = null;
    L64:
        this.o = r116;
        D2(this.c);
        F2();
        if (Intrinsics.areEqual(r2, null) == true) goto L68;
        notifyItemChanged(r25.intValue(), new Object());
    L68:
        if (Intrinsics.areEqual(r38, null) == true) goto L70;
        notifyItemChanged(r38.intValue(), new Object());
    L70:
        com.bytedance.ee.bear.middleground.comment.card.d r39 = this.j;
        if (r39 != null) goto L73;
        Intrinsics.throwUninitializedPropertyAccessException("cardDataViewModel");
        r39 = null;
    L73:
        String r117 = r39.f(r2);
        com.bytedance.ee.bear.middleground.comment.card.d r40 = this.j;
        if (r40 != null) goto L76;
        Intrinsics.throwUninitializedPropertyAccessException("cardDataViewModel");
        r40 = null;
    L76:
        CommentBean r41 = r40.e(r2);
        if (r41 == null) goto L79;
        r111 = r41.getCommentType();
    L80:
        if (r41 == null) goto L82;
        String r42 = r41.getCommentUUID();
    L84:
        if (r42 != null) goto L86;
        r42 = "";
    L86:
        p r43 = this.d;
        if (r43 != null) goto L89;
        Intrinsics.throwUninitializedPropertyAccessException("config");
        r43 = null;
    L89:
        r43.getClass();
        Intrinsics.checkNotNullParameter(r117, "<set-?>");
        r43.y = r117;
        p r44 = this.d;
        if (r44 != null) goto L92;
        Intrinsics.throwUninitializedPropertyAccessException("config");
        r44 = null;
    L92:
        com.bytedance.ee.bear.middleground.comment.uitls.h r45 = r44.d0;
        com.bytedance.ee.bear.middleground.comment.card.d r46 = this.j;
        if (r46 != null) goto L95;
        Intrinsics.throwUninitializedPropertyAccessException("cardDataViewModel");
        r46 = null;
    L95:
        CommentBean r47 = r46.e(r2);
        if (r47 == null) goto L101;
        CommentBean.Extra r48 = r47.getExtra();
        if (r48 == null) goto L101;
        String r49 = r48.getReportVisibility();
        if (r49 == null) goto L101;
    L102:
        r45.e(r117, r49);
        p r50 = this.d;
        if (r50 != null) goto L105;
        Intrinsics.throwUninitializedPropertyAccessException("config");
        r50 = null;
    L105:
        com.bytedance.ee.bear.middleground.comment.uitls.h r51 = r50.d0;
        com.bytedance.ee.bear.middleground.comment.card.d r52 = this.j;
        if (r52 != null) goto L108;
        Intrinsics.throwUninitializedPropertyAccessException("cardDataViewModel");
        r52 = null;
    L108:
        String r210 = r52.f(r2);
        if (r2 != null) goto L112;
    L114:
        boolean r211 = false;
    L115:
        r51.d("bubble_comment_page_slide", null, r210, "", r211);
        if (r2 != null) goto L122;
        p r53 = this.d;
        if (r53 != null) goto L120;
        Intrinsics.throwUninitializedPropertyAccessException("config");
    L121:
        r13.N.a(new ef5.j(r25, r111, r117, r42, r113, null));
        goto L160
    L120:
        r13 = r53;
        goto L121
    L122:
        r8 = r42;
        if (r27 == null) goto L131;
        AlignAndScrollManager r54 = this.s;
        if (r54 == null) goto L131;
        int r55 = r25.intValue();
        int r56 = r27.intValue();
        r3.L$0 = r2;
        r3.L$1 = r113;
        r3.L$2 = r117;
        r3.L$3 = r8;
        r3.I$0 = r111;
        r3.label = 3;
        r1 = r54.e(r55, r56, r3);
        if (r1 != r5) goto L129;
        return r5;
    L129:
        r9 = r117;
        r10 = r113;
    L131:
        r9 = r117;
        r10 = r113;
        goto L132
    L112:
        if (r25.intValue() != 0) goto L114;
        r211 = true;
    L101:
        r49 = "";
        goto L102
    L82:
        r42 = null;
        goto L84
    L79:
        r111 = 0;
        goto L80
    L60:
        if (r25.intValue() < 0) goto L63;
        r116 = r2;
    L7:
        r3 = new AsidePageAdapter$switchCurrentItem$2(this, r28);
        goto L8
    }
}
