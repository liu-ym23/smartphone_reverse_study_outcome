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
import com.bytedance.android.livesdk.livecommerce.largemode.model.LayoutSizeLargeModeConfig;
import com.bytedance.ee.bear.contract.AccountService$Account;
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
import com.bytedance.ee.bear.middleground.comment.widget.CommentEditText;
import com.bytedance.ee.bear.middleground.comment.widget.NoTopFadingEdgeRecyclerView;
import com.bytedance.ee.bear.widgets.universedesign.SpaceShadowLayout;
import com.bytedance.ee.util.ui.n;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
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

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0007\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 p2\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u00012\u00020\u0003:\u0002pqB\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJT\u0010>\u001a\u00020%2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010?\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$J\u000e\u0010@\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fJ\u0016\u0010A\u001a\u00020%2\u0006\u0010B\u001a\u00020\u00182\u0006\u0010C\u001a\u00020*J\u000e\u0010D\u001a\u00020%2\u0006\u0010E\u001a\u00020FJ\u000e\u0010G\u001a\u00020%2\u0006\u0010E\u001a\u00020FJ\u0006\u0010H\u001a\u00020%J\u0006\u0010I\u001a\u00020%J,\u0010A\u001a\u00020%2\b\u0010J\u001a\u0004\u0018\u00010(2\u0006\u0010C\u001a\u00020*2\n\b\u0002\u0010K\u001a\u0004\u0018\u00010(H\u0086@¢\u0006\u0002\u0010LJ\u0006\u0010M\u001a\u00020%J\u0006\u00104\u001a\u00020*J\u0010\u0010N\u001a\u00020%2\u0006\u00104\u001a\u00020*H\u0002J\u000e\u0010O\u001a\u00020%2\u0006\u0010P\u001a\u00020(J*\u0010Q\u001a\u00020%2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u001a2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0086@¢\u0006\u0002\u0010RJ&\u0010S\u001a\u00020%2\u0006\u0010T\u001a\u00020(2\u0006\u0010U\u001a\u00020(2\u0006\u0010V\u001a\u00020WH\u0086@¢\u0006\u0002\u0010XJ\u0019\u0010Y\u001a\u0004\u0018\u00010\u00052\b\u0010P\u001a\u0004\u0018\u00010(H\u0016¢\u0006\u0002\u0010ZJ\u0006\u0010[\u001a\u00020*J\u0006\u0010\\\u001a\u00020%J\u0015\u0010]\u001a\u00020%2\b\u0010P\u001a\u0004\u0018\u00010(¢\u0006\u0002\u0010^J\u0016\u0010_\u001a\u00020%2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fJ\u000e\u0010`\u001a\u00020(2\u0006\u0010+\u001a\u00020(J\u0010\u0010a\u001a\u00020%2\u0006\u0010b\u001a\u00020*H\u0016J\u0010\u0010c\u001a\u00020%2\u0006\u0010b\u001a\u00020*H\u0016J\u000f\u0010d\u001a\u0004\u0018\u00010(H\u0016¢\u0006\u0002\u0010eJ\"\u0010f\u001a\u00020%2\u0006\u0010g\u001a\u00020\u00052\u0006\u0010P\u001a\u00020(2\b\b\u0002\u0010b\u001a\u00020*H\u0002J\u001c\u0010h\u001a\u00060\u0002R\u00020\u00002\u0006\u0010i\u001a\u00020j2\u0006\u0010k\u001a\u00020(H\u0017J\b\u0010l\u001a\u00020(H\u0016J\u0010\u0010m\u001a\u00020.2\u0006\u0010P\u001a\u00020(H\u0016J\u001c\u0010n\u001a\u00020%2\n\u0010o\u001a\u00060\u0002R\u00020\u00002\u0006\u0010P\u001a\u00020(H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u001aX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$X\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010&\u001a\u0012\u0012\u0004\u0012\u00020(\u0012\b\u0012\u00060\u0002R\u00020\u00000'X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010+\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0004\n\u0002\u0010,R\u001a\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020.0'X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010/\u001a\u00020.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u000e\u00104\u001a\u00020*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u0004\u0018\u000108X\u0082\u000e¢\u0006\u0002\n\u0000R)\u00109\u001a\u001d\u0012\u0013\u0012\u00110(¢\u0006\f\b;\u0012\b\b<\u0012\u0004\b\b(=\u0012\u0004\u0012\u00020%0:X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006r"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/card/aside/AsidePageAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/ee/bear/middleground/comment/card/aside/AsidePageAdapter$ViewHolder;", "Lcom/bytedance/ee/bear/middleground/comment/card/ICommentPagerAdapter;", "commentCardRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "commentHandler", "Lcom/bytedance/ee/bear/middleground/comment/card/aside/AsideComment$CommentHandler;", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;Lcom/bytedance/ee/bear/middleground/comment/card/aside/AsideComment$CommentHandler;)V", "getCommentCardRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "getCommentHandler", "()Lcom/bytedance/ee/bear/middleground/comment/card/aside/AsideComment$CommentHandler;", "cards", "", "Lcom/bytedance/ee/bear/middleground/comment/export/bean/CommentBean;", "config", "Lcom/bytedance/ee/bear/middleground/comment/uitls/Config;", "activity", "Landroid/app/Activity;", "per", "Lcom/bytedance/ee/bear/middleground/comment/export/ICommentPermission;", "language", "", "userIds", "", "mIListeners", "Lcom/bytedance/ee/bear/middleground/comment/control/ICommentListeners;", "actionControl", "Lcom/bytedance/ee/bear/middleground/comment/control/ICommentFunction;", "cardDataViewModel", "Lcom/bytedance/ee/bear/middleground/comment/card/CardDataViewModel;", "sharePermissionViewModel", "Lcom/bytedance/ee/bear/middleground/comment/share/SharePermissionViewModel;", "clickLink", "Lkotlin/Function0;", "", "currentPagers", "", "", "isPortrait", "", "currentIndex", "Ljava/lang/Integer;", "commentIdToItemIdMap", "", "itemIdCounter", "getItemIdCounter", "()J", "setItemIdCounter", "(J)V", "canReplay", "mAlignAndScrollManager", "Lcom/bytedance/ee/bear/middleground/comment/card/aside/AlignAndScrollManager;", "switchJob", "Lkotlinx/coroutines/Job;", "avoidKeyboard", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "height", "initPage", "listeners", "getCards", "switchCurrentItem", "commentId", "smooth", "editReply", "input", "Lcom/bytedance/ee/bear/middleground/comment/export/bean/CommentInputRequest;", "addReplay", "cancelHighLight", "resetHighLight", "targetItem", "highLightHeight", "(Ljava/lang/Integer;ZLjava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setInputViewVisibility", "setCanReplay", "clickItem", "position", "updateData", "(Ljava/util/List;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scrollToPosition", "outPosition", "innerPosition", LayoutSizeLargeModeConfig.TYPE_PERCENTAGE, "", "(IIFLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getView", "(Ljava/lang/Integer;)Landroidx/recyclerview/widget/RecyclerView;", "onEditStatus", "exitCurrentEditStatus", "exitEditStatus", "(Ljava/lang/Integer;)V", "reSetEditStatus", "findEditViewPosition", "notifyDataChange", "forceContentDiff", "notifyCurrentPosDataChange", "getCurrentPos", "()Ljava/lang/Integer;", "notifyItemPageDataChanged", "recyclerView", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "getItemCount", "getItemId", "onBindViewHolder", "holder", "Companion", "ViewHolder", "middleground-comment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AsidePageAdapter extends RecyclerView.Adapter<ViewHolder> implements q1 {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f230912u = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f230913a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AsideComment.a f230914b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<CommentBean> f230915c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public p f230916d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Activity f230917e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f230918f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List<String> f230919g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public z f230920h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public y f230921i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public com.bytedance.ee.bear.middleground.comment.card.d f230922j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public SharePermissionViewModel f230923k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Function0<Unit> f230924l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Map<Integer, ViewHolder> f230925m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f230926n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Integer f230927o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Map<String, Long> f230928p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f230929q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f230930r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public AlignAndScrollManager f230931s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Function1<? super Integer, Unit> f230932t;

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0006\u0010 \u001a\u00020!J\u000e\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020$J\u0006\u0010%\u001a\u00020!J\b\u0010&\u001a\u00020!H\u0002J\b\u0010'\u001a\u0004\u0018\u00010\u0019R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006("}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/card/aside/AsidePageAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", BrowserDependency.UrlClickType.CARD, "inputContainer", "Landroid/widget/FrameLayout;", "shadowLayout", "Lcom/bytedance/ee/bear/widgets/universedesign/SpaceShadowLayout;", "topBar", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "<init>", "(Lcom/bytedance/ee/bear/middleground/comment/card/aside/AsidePageAdapter;Landroid/view/View;Landroid/view/View;Landroid/widget/FrameLayout;Lcom/bytedance/ee/bear/widgets/universedesign/SpaceShadowLayout;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;)V", "getView", "()Landroid/view/View;", "getCard", "getInputContainer", "()Landroid/widget/FrameLayout;", "getShadowLayout", "()Lcom/bytedance/ee/bear/widgets/universedesign/SpaceShadowLayout;", "getTopBar", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "inputComment", "Lcom/bytedance/ee/bear/middleground/comment/input/api/ICommentInput;", "replayInputRequest", "Lcom/bytedance/ee/bear/middleground/comment/export/bean/CommentInputRequest;", "getReplayInputRequest", "()Lcom/bytedance/ee/bear/middleground/comment/export/bean/CommentInputRequest;", "setReplayInputRequest", "(Lcom/bytedance/ee/bear/middleground/comment/export/bean/CommentInputRequest;)V", "clearFocus", "", "showInput", "commentBean", "Lcom/bytedance/ee/bear/middleground/comment/export/bean/CommentBean;", "hideInput", "initInputComment", "getInputComment", "middleground-comment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f230933a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View f230934b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final FrameLayout f230935c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final SpaceShadowLayout f230936d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final View f230937e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final RecyclerView f230938f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public AsideInputComment f230939g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public CommentInputRequest f230940h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ AsidePageAdapter f230941i;

        public final void T3() {
            this.f230935c.setVisibility(8);
            AsideInputComment r100 = this.f230939g;
            if (r100 != null) goto L5;
        L7:
            boolean r101 = false;
        L8:
            if (r101 == false) goto L35;
            tt5.a.h("Comment#CommentPagerAdapter2", "hideInput, so dismiss inputComment");
            AsideInputComment r102 = this.f230939g;
            if (r102 == null) goto L36;
            p r103 = this.f230941i.f230916d;
            p r104 = null;
            if (r103 != null) goto L15;
            Intrinsics.throwUninitializedPropertyAccessException("config");
            r103 = null;
        L15:
            if (r103.f232242r.isKeyboardShowing() == false) goto L32;
            p r105 = this.f230941i.f230916d;
            if (r105 != null) goto L19;
            Intrinsics.throwUninitializedPropertyAccessException("config");
        L21:
            if (r104.getActivity().getCurrentFocus() == null) goto L31;
            AsideInputComment r106 = this.f230939g;
            if (r106 == null) goto L29;
            CommentEditText r107 = r106.e();
            if (r107 == null) goto L29;
            if (r107.hasFocus() != true) goto L29;
            boolean r108 = true;
        L30:
            if (r108 == false) goto L32;
        L29:
            r108 = false;
        L31:
            boolean r109 = true;
        L33:
            kf5.a.a(r102, false, r109, 1);
            return;
        L19:
            r104 = r105;
        L32:
            r109 = false;
            goto L33
        L36:
            return;
        L35:
            return;
        L5:
            if (r100.isShowing() != true) goto L7;
            r101 = true;
            goto L8
        }

        public ViewHolder(AsidePageAdapter r100, View r101, View r102, FrameLayout r103, SpaceShadowLayout r104, View r105, NoTopFadingEdgeRecyclerView r106) {
            Intrinsics.checkNotNullParameter(r101, "view");
            Intrinsics.checkNotNullParameter(r102, BrowserDependency.UrlClickType.CARD);
            Intrinsics.checkNotNullParameter(r103, "inputContainer");
            Intrinsics.checkNotNullParameter(r104, "shadowLayout");
            Intrinsics.checkNotNullParameter(r105, "topBar");
            Intrinsics.checkNotNullParameter(r106, "recyclerView");
            this.f230941i = r100;
            super(r101);
            this.f230933a = r101;
            this.f230934b = r102;
            this.f230935c = r103;
            this.f230936d = r104;
            this.f230937e = r105;
            this.f230938f = r106;
        }
    }

    public static final class a {
    }

    static {
        f230912u = n.d(7);
    }

    public final void A2() {
        this.f230914b.b("cancelHighLight", new AsidePageAdapter$cancelHighLight$1(this, null));
    }

    public final void B2() {
        Integer r100 = this.f230927o;
        ICardAdapter r101 = null;
        if (Intrinsics.areEqual(r100, null) == true) goto L56;
        RecyclerView r102 = P0(r100);
        if (r102 == null) goto L8;
        Object r103 = r102.getAdapter();
    L10:
        if ((r103 instanceof ICardAdapter) == false) goto L12;
        ICardAdapter r104 = (ICardAdapter) r103;
    L13:
        if (r104 == null) goto L16;
        CommentBean r105 = r104.getData();
        if (r105 == null) goto L16;
    L20:
        if (r105 == null) goto L57;
        int r106 = com.bytedance.ee.bear.middleground.comment.card.e.f230973a;
        int r107 = com.bytedance.ee.bear.middleground.comment.card.e.a(0, CollectionsKt.mutableListOf(new CommentBean[]{r105}));
        if (r107 == (-2)) goto L55;
        List<CommentBean> r108 = this.f230915c;
        if (r108 == null) goto L40;
        CommentBean r109 = (CommentBean) CollectionsKt.getOrNull(r108, r100.intValue());
        if (r109 == null) goto L40;
        List<CommentBean.CommentDetail> r110 = r109.getComment_list();
        if (r110 == null) goto L40;
        Iterator<T> r111 = r110.iterator();
    L32:
        if (r111.hasNext() == false) goto L36;
        Object r112 = r111.next();
        if (((CommentBean.CommentDetail) r112).isEditStatus() == false) goto L32;
    L37:
        CommentBean.CommentDetail r113 = (CommentBean.CommentDetail) r112;
        if (r113 == null) goto L40;
        r113.setEditStatus(false);
        goto L40
    L36:
        r112 = null;
    L40:
        CommentBean.CommentDetail r114 = (CommentBean.CommentDetail) CollectionsKt.getOrNull(r105.getComment_list(), r107);
        if (r114 == null) goto L43;
        r114.setEditStatus(false);
    L43:
        int r115 = CommentDiffUtils.f231330a;
        RecyclerView r116 = P0(r100);
        if (r116 == null) goto L46;
        RecyclerView.Adapter r117 = r116.getAdapter();
    L48:
        if ((r117 instanceof ICardAdapter) == false) goto L50;
        r101 = (ICardAdapter) r117;
    L50:
        CommentDiffUtils.b(r101, Integer.valueOf(r107));
        F2();
        return;
    L46:
        r117 = null;
        goto L48
    L55:
        return;
    L57:
        return;
    L16:
        List<CommentBean> r118 = this.f230915c;
        if (r118 == null) goto L19;
        r105 = (CommentBean) CollectionsKt.getOrNull(r118, r100.intValue());
        goto L20
    L19:
        r105 = null;
        goto L20
    L12:
        r104 = null;
        goto L13
    L8:
        r103 = null;
        goto L10
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        List<CommentBean> r100 = this.f230915c;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.size();
    }

    public final boolean z2() {
        Integer r100 = this.f230927o;
        if (r100 == null) goto L38;
        int r101 = r100.intValue();
        com.bytedance.ee.bear.middleground.comment.card.d r102 = this.f230922j;
        com.bytedance.ee.bear.middleground.comment.card.d r103 = null;
        if (r102 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("cardDataViewModel");
        r102 = null;
    L7:
        boolean r104 = r102.r(r101);
        p r105 = this.f230916d;
        if (r105 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("config");
        r105 = null;
    L10:
        boolean r106 = r105.f232241q.getComment();
        int r107 = com.bytedance.ee.bear.middleground.comment.card.e.f230973a;
        com.bytedance.ee.bear.middleground.comment.card.d r108 = this.f230922j;
        if (r108 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("cardDataViewModel");
        r108 = null;
    L13:
        MutableLiveData<List<CommentBean>> r109 = r108.f230964f;
        if (r109 == null) goto L16;
        List<CommentBean> r110 = r109.getValue();
    L17:
        boolean r111 = !com.bytedance.ee.bear.middleground.comment.card.e.c(r110);
        tt5.a.h("Comment#CommentPagerAdapter2", "canReplay visiable = " + r111 + ", isUnSubmitComment = " + r104 + ", hasPerReply = " + r106);
        if (r111 == false) goto L38;
        com.bytedance.ee.bear.middleground.comment.card.d r112 = this.f230922j;
        if (r112 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("cardDataViewModel");
        r112 = null;
    L23:
        if (r112.m(r101) == false) goto L38;
        com.bytedance.ee.bear.middleground.comment.card.d r113 = this.f230922j;
        if (r113 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("cardDataViewModel");
        r113 = null;
    L28:
        if (r113.n(r101) == true) goto L38;
        com.bytedance.ee.bear.middleground.comment.card.d r114 = this.f230922j;
        if (r114 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("cardDataViewModel");
    L34:
        if (r103.l(r101, CommentAction.INPUT) == true) goto L38;
        if (r104 == false) goto L38;
        if (r106 == false) goto L38;
        return true;
    L32:
        r103 = r114;
        goto L34
    L16:
        r110 = null;
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
        return this.f230927o;
    }

    public final void D2(List<CommentBean> r110) {
        Integer r100 = this.f230927o;     // Catch: Exception -> L63
        if (r100 == null) goto L65;
        int r101 = r100.intValue();     // Catch: Exception -> L63
        int r102 = com.bytedance.ee.bear.middleground.comment.card.e.f230973a;     // Catch: Exception -> L63
        if (com.bytedance.ee.bear.middleground.comment.card.e.c(this.f230915c) == false) goto L77;
        List<CommentBean> r103 = this.f230915c;     // Catch: Exception -> L63
        if (r103 == null) goto L12;
        CommentBean r104 = (CommentBean) ListProtector.get(r103, r101);     // Catch: Exception -> L63
        if (r104 == null) goto L12;
        String r105 = r104.getComment_id();     // Catch: Exception -> L63
    L13:
        int r106 = com.bytedance.ee.bear.middleground.comment.card.e.a(r101, this.f230915c);     // Catch: Exception -> L63
        List<CommentBean> r107 = this.f230915c;     // Catch: Exception -> L63
        if (r107 == null) goto L24;
        CommentBean r108 = (CommentBean) ListProtector.get(r107, r101);     // Catch: Exception -> L63
        if (r108 == null) goto L24;
        List<CommentBean.CommentDetail> r109 = r108.getComment_list();     // Catch: Exception -> L63
        if (r109 == null) goto L24;
        CommentBean.CommentDetail r111 = (CommentBean.CommentDetail) ListProtector.get(r109, r106);     // Catch: Exception -> L63
        if (r111 == null) goto L24;
        String r112 = r111.getReply_id();     // Catch: Exception -> L63
        if (r112 == null) goto L24;
    L26:
        if (r112.length() <= 0) goto L28;
        boolean r113 = true;
    L29:
        if (r113 == false) goto L61;
        if (r110 == null) goto L61;
        Iterator<T> r114 = r110.iterator();     // Catch: Exception -> L63
        int r115 = 0;
    L33:
        if (r114.hasNext() == false) goto L61;
        Object r116 = r114.next();     // Catch: Exception -> L63
        int r117 = r115 + 1;     // Catch: Exception -> L63
        if (r115 >= 0) goto L37;
        CollectionsKt.throwIndexOverflow();     // Catch: Exception -> L63
    L37:
        CommentBean r118 = (CommentBean) r116;     // Catch: Exception -> L63
        if (Intrinsics.areEqual(r118.getComment_id(), r105) == false) goto L60;
        List<CommentBean.CommentDetail> r119 = r118.getComment_list();     // Catch: Exception -> L63
        if (r119 == null) goto L60;
        Iterator<T> r120 = r119.iterator();     // Catch: Exception -> L63
        int r121 = 0;
    L43:
        if (r120.hasNext() == false) goto L60;
        Object r122 = r120.next();     // Catch: Exception -> L63
        int r123 = r121 + 1;     // Catch: Exception -> L63
        if (r121 >= 0) goto L47;
        CollectionsKt.throwIndexOverflow();     // Catch: Exception -> L63
    L47:
        CommentBean.CommentDetail r124 = (CommentBean.CommentDetail) r122;     // Catch: Exception -> L63
        boolean r125 = r124.isEditStatus();     // Catch: Exception -> L63
        r124.setEditStatus(Intrinsics.areEqual(r124.getReply_id(), r112));     // Catch: Exception -> L63
        if (r125 == r124.isEditStatus()) goto L59;
        RecyclerView r126 = P0(Integer.valueOf(r115));     // Catch: Exception -> L63
        if (r126 == null) goto L52;
        Object r127 = r126.getAdapter();     // Catch: Exception -> L63
    L54:
        if ((r127 instanceof ICardAdapter) == false) goto L56;
        ICardAdapter r128 = (ICardAdapter) r127;     // Catch: Exception -> L63
    L57:
        if (r128 == null) goto L59;
        int r129 = CommentDiffUtils.f231330a;     // Catch: Exception -> L63
        CommentDiffUtils.b(r128, Integer.valueOf(r121));     // Catch: Exception -> L63
        goto L59
    L56:
        r128 = null;
        goto L57
    L52:
        r127 = null;
    L59:
        r121 = r123;
    L60:
        r115 = r117;
    L61:
        F2();     // Catch: Exception -> L63
        return;
    L28:
        r113 = false;
    L24:
        r112 = "";
    L12:
        r105 = null;
        goto L13
    L77:
        return;
    L65:
        return;
    L63:
        e = move-exception;
        tt5.a.f("Comment#CommentPagerAdapter2", e, false);
    }

    public final void E2(boolean r100) {
        if (r100 == this.f230930r) goto L10;
        this.f230930r = r100;
        if (this.f230913a.isComputingLayout() == true) goto L11;
        Integer r101 = this.f230927o;
        if (r101 == null) goto L12;
        notifyItemChanged(r101.intValue(), new Object());
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.card.q1
    public final RecyclerView P0(Integer r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        ViewHolder r101 = (ViewHolder) ((LinkedHashMap) this.f230925m).get(r100);
        if (r101 != null) goto L8;
        return null;
    L8:
        return r101.f230938f;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final long getItemId(int r100) {
        List<CommentBean> r101 = this.f230915c;
        if (r101 == null) goto L7;
        CommentBean r102 = (CommentBean) ListProtector.get(r101, r100);
        if (r102 == null) goto L7;
        String r103 = r102.getComment_id();
    L9:
        if (r103 != null) goto L11;
    L23:
        tt5.a.d("Comment#CommentPagerAdapter2", "commentId is empty!");
        return -1;
    L11:
        if (r103.length() != 0) goto L13;
        boolean r104 = true;
    L14:
        if (r104 == true) goto L23;
        if (this.f230928p.containsKey(r103) == false) goto L19;
        Long r105 = (Long) ((LinkedHashMap) this.f230928p).get(r103);
    L20:
        if (r105 != null) goto L22;
        return -1;
    L22:
        return r105.longValue();
    L19:
        long r106 = this.f230929q;
        this.f230929q = 1 + r106;
        Long r107 = Long.valueOf(r106);
        this.f230928p.put(r103, r107);
        r105 = Long.valueOf(r106);
        goto L20
    L13:
        r104 = false;
    L7:
        r103 = null;
        goto L9
    }

    public final void y2(CommentInputRequest r100) {
        Intrinsics.checkNotNullParameter(r100, "input");
        this.f230914b.b("addReplay", new AsidePageAdapter$addReplay$1(this, r100, null));
    }

    public AsidePageAdapter(CommonRecyclerView r100, AsideComment.a r101) {
        Intrinsics.checkNotNullParameter(r100, "commentCardRecyclerView");
        Intrinsics.checkNotNullParameter(r101, "commentHandler");
        this.f230913a = r100;
        this.f230914b = r101;
        this.f230925m = new LinkedHashMap();
        this.f230926n = true;
        this.f230928p = new LinkedHashMap();
        this.f230932t = new AsidePageAdapter$avoidKeyboard$1(this);
        setHasStableIds(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1, types: [com.bytedance.ee.bear.middleground.comment.uitls.p] */
    /* JADX WARN: Type inference failed for: r5v24 */
    /* JADX WARN: Type inference failed for: r5v3 */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder r210, final int r211) {
        final ViewHolder r100 = (ViewHolder) r210;
        Intrinsics.checkNotNullParameter(r100, "holder");
        ((LinkedHashMap) this.f230925m).values().remove(r100);
        Integer r101 = Integer.valueOf(r211);
        this.f230925m.put(r101, r100);
        View r102 = r100.f230937e;
        Integer r103 = this.f230927o;
        if (r103 != null) goto L6;
    L8:
        boolean r104 = false;
    L9:
        if (r104 == false) goto L11;
        int r105 = 0;
    L12:
        r102.setVisibility(r105);
        C2(r100.f230938f, r211, false);
        Integer r106 = this.f230927o;
        if (r106 != null) goto L16;
    L115:
        AsideCommentCardAdapter r107 = null;
        r100.T3();
        r100.f230936d.setShadowColor(0);
    L116:
        RecyclerView.Adapter r108 = r100.f230938f.getAdapter();
        if ((r108 instanceof AsideCommentCardAdapter) == false) goto L119;
        AsideCommentCardAdapter r109 = (AsideCommentCardAdapter) r108;
    L120:
        if (r109 == null) goto L123;
        r109.setOnClickEmpty(new AsidePageAdapter$onBindViewHolder$1$1(r100, this, r211));
        r109.setCommentControlCallback(new g(r100));
        return;
    L123:
        return;
    L119:
        r109 = r107;
        goto L120
    L16:
        if (r106.intValue() != r211) goto L115;
        F2();
        boolean r110 = z2();
        this.f230930r = r110;
        if (r110 == false) goto L110;
        List<CommentBean> r111 = this.f230915c;
        if (r111 == null) goto L23;
        CommentBean r112 = (CommentBean) ListProtector.get(r111, r211);
        if (r112 == null) goto L23;
    L24:
        Intrinsics.checkNotNullParameter(r112, "commentBean");
        if (r100.f230939g != null) goto L47;
        p r113 = r100.f230941i.f230916d;
        if (r113 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("config");
        p r114 = null;
    L31:
        z r115 = r100.f230941i.f230920h;
        if (r115 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("mIListeners");
        z r116 = null;
    L35:
        com.bytedance.ee.bear.middleground.comment.card.d r117 = r100.f230941i.f230922j;
        if (r117 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("cardDataViewModel");
        r117 = null;
    L38:
        t r118 = r117.f230961c;
        if (r118 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("dataControl");
        t r119 = null;
    L42:
        CommentInputRequest r120 = new CommentInputRequest();
        f r121 = new f();
        SharePermissionViewModel r122 = r100.f230941i.f230923k;
        if (r122 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("sharePermissionViewModel");
        SharePermissionViewModel r123 = null;
    L46:
        Function1<? super Integer, Unit> r124 = r100.f230941i.f230932t;
        final AsidePageAdapter r125 = r100.f230941i;
        Function1<String, Unit> r126 = new AsidePageAdapter$ViewHolder$initInputComment$2(r125);
        final AsidePageAdapter r127 = r100.f230941i;
        Function5<String, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity>, Boolean, String, Boolean, Unit> r128 = new AsidePageAdapter$ViewHolder$initInputComment$3(r100, r127);
        final AsidePageAdapter r129 = r100.f230941i;
        r100.f230939g = new AsideInputComment(r114, r116, r119, r126, r120, r128, new AsidePageAdapter$ViewHolder$initInputComment$4(r129), r123, r121, r124);
        goto L47
    L45:
        r123 = r122;
        goto L46
    L41:
        r119 = r118;
        goto L42
    L34:
        r116 = r115;
        goto L35
    L30:
        r114 = r113;
    L47:
        r100.f230935c.setVisibility(0);
        CommentInputRequest r130 = r100.f230940h;
        r100.f230940h = null;
        if (r130 != null) goto L63;
        int r131 = com.bytedance.ee.bear.middleground.comment.input.utils.b.f232006a;
        List<CommentBean> r132 = r100.f230941i.f230915c;
        if (r132 == null) goto L53;
        CommentBean r133 = (CommentBean) ListProtector.get(r132, r100.getPosition());
        if (r133 == null) goto L53;
    L54:
        CommentBean r134 = r133;
        p r135 = r100.f230941i.f230916d;
        if (r135 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("config");
        p r136 = null;
    L59:
        if (r112.isNewInput() == false) goto L61;
        int r137 = 0;
    L62:
        CommentInputRequest r138 = com.bytedance.ee.bear.middleground.comment.input.utils.b.a(r134, r136, r137, null, null, MapsKt.emptyMap(), null, null, 472);
    L65:
        if (r112.isNewInput() == false) goto L67;
        r107 = null;
        r138.comment_id = null;
    L68:
        AsideInputComment r139 = r100.f230939g;
        if (r139 == null) goto L71;
        Object r140 = r139.f231726j;
    L72:
        if (r139 == null) goto L74;
        r139.p(r138);
    L74:
        AsideInputComment r141 = r100.f230939g;
        if (r141 == null) goto L79;
        boolean r142 = true;
        if (r141.isShowing() != true) goto L80;
        boolean r143 = true;
    L81:
        if (r143 == false) goto L101;
        AsideInputComment r144 = r100.f230939g;
        if (r144 == null) goto L89;
        View r145 = r144.f231727k;
        if (r145 == null) goto L89;
        if (r145.isAttachedToWindow() != r142) goto L89;
        boolean r146 = true;
    L90:
        if (r146 == false) goto L101;
        if (Objects.equals(r140, r138) == true) goto L111;
        AsideInputComment r147 = r100.f230939g;
        if (r147 == null) goto L111;
        if (r112.isNewInput() == true) goto L100;
        if (r130 != null) goto L100;
        r142 = false;
    L100:
        r147.update(r142);
    L111:
        SpaceShadowLayout r148 = r100.f230936d;
        p r149 = this.f230916d;
        ?? r150 = r149;
        if (r149 != null) goto L114;
        Intrinsics.throwUninitializedPropertyAccessException("config");
        r150 = r107;
    L114:
        r148.setShadowColor(ContextCompat.getColor(r150.getActivity(), R.color.ud_shadow_s3));
    L89:
        r146 = false;
    L101:
        AsideInputComment r151 = r100.f230939g;
        if (r151 == null) goto L111;
        if (r112.isNewInput() == true) goto L108;
        if (r130 != null) goto L108;
        boolean r152 = false;
    L109:
        kf5.a.b(r151, false, false, r152, false, false, 27);
    L108:
        r152 = true;
    L80:
        r143 = false;
        goto L81
    L79:
        r142 = true;
        goto L80
    L71:
        r140 = r107;
        goto L72
    L67:
        r107 = null;
        goto L68
    L61:
        r137 = 2;
        goto L62
    L57:
        r136 = r135;
    L53:
        r133 = new CommentBean();
        goto L54
    L63:
        r138 = r130;
    L23:
        r112 = new CommentBean();
        goto L24
    L110:
        r107 = null;
        r100.T3();
        goto L111
    L11:
        r105 = 8;
        goto L12
    L6:
        if (r103.intValue() != r211) goto L8;
        r104 = true;
        goto L9
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r210, int r211) {
        Intrinsics.checkNotNullParameter(r210, "parent");
        View r100 = LayoutInflater.from(r210.getContext()).inflate(R.layout.aside_comment_card_layout, r210, false);
        View r101 = r100.findViewById(R.id.comment_card);
        NoTopFadingEdgeRecyclerView r102 = (NoTopFadingEdgeRecyclerView) r100.findViewById(R.id.aside_comment_rv);
        SpaceShadowLayout r103 = (SpaceShadowLayout) r100.findViewById(R.id.aside_comment_card_shadow);
        r103.setOnClickListener(new h(this));
        FrameLayout r104 = (FrameLayout) r100.findViewById(R.id.input_container);
        View r105 = r100.findViewById(R.id.top_line);
        r105.setOnClickListener(new i(this));
        r102.f448123h = false;
        final Activity r106 = this.f230917e;
        if (r106 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("activity");
        r106 = null;
    L5:
        r102.setLayoutManager(new AnonymousClass3(r106));
        r102.setOverScrollMode(2);
        p r110 = this.f230916d;
        if (r110 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("config");
        p r111 = null;
    L9:
        List<String> r112 = this.f230919g;
        if (r112 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("userIds");
        List<String> r113 = null;
    L13:
        z r114 = this.f230920h;
        if (r114 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("mIListeners");
        z r115 = null;
    L17:
        y r116 = this.f230921i;
        if (r116 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("actionControl");
        y r117 = null;
    L21:
        SharePermissionViewModel r118 = this.f230923k;
        if (r118 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("sharePermissionViewModel");
        SharePermissionViewModel r119 = null;
    L25:
        com.bytedance.ee.bear.middleground.comment.card.d r120 = this.f230922j;
        if (r120 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("cardDataViewModel");
        com.bytedance.ee.bear.middleground.comment.card.d r121 = null;
    L29:
        String r122 = this.f230918f;
        if (r122 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("language");
        String r123 = null;
    L33:
        Function1<? super Integer, Unit> r124 = this.f230932t;
        Function0<Unit> r107 = this.f230924l;
        if (r107 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("clickLink");
        Function0<Unit> r125 = null;
    L37:
        r102.setAdapter(new AsideCommentCardAdapter(r111, r113, r115, r117, r119, r121, r123, r124, r125));
        r102.setTouchViewListener(new j(this));
        r102.setVerticalFadingEdgeEnabled(true);
        r102.setFadingEdgeLength(n.d(16));
        if ((r102.getItemAnimator() instanceof SimpleItemAnimator) == false) goto L40;
        RecyclerView.ItemAnimator r108 = r102.getItemAnimator();
        Intrinsics.checkNotNull(r108, "null cannot be cast to non-null type androidx.recyclerview.widget.SimpleItemAnimator");
        ((SimpleItemAnimator) r108).setSupportsChangeAnimations(false);
    L40:
        r102.setItemAnimator(null);
        p r109 = this.f230916d;
        if (r109 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("config");
        r109 = null;
    L43:
        gf5.d r126 = r109.N;
        Intrinsics.checkNotNull(r102);
        r126.a(new ef5.z(r102));
        Intrinsics.checkNotNull(r100);
        Intrinsics.checkNotNull(r101);
        Intrinsics.checkNotNull(r104);
        Intrinsics.checkNotNull(r103);
        Intrinsics.checkNotNull(r105);
        return new ViewHolder(this, r100, r101, r104, r103, r105, r102);
    L36:
        r125 = r107;
        goto L37
    L32:
        r123 = r122;
        goto L33
    L28:
        r121 = r120;
        goto L29
    L24:
        r119 = r118;
        goto L25
    L20:
        r117 = r116;
        goto L21
    L16:
        r115 = r114;
        goto L17
    L12:
        r113 = r112;
        goto L13
    L8:
        r111 = r110;
        goto L9
    }

    public final void C2(RecyclerView r110, int r111, boolean r210) {
        tt5.a.b("Comment#CommentPagerAdapter2", "notifyItemPageDataChanged: position = " + r111);
        RecyclerView.Adapter r100 = r110.getAdapter();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter2");
        CardAdapter2 r101 = (CardAdapter2) r100;
        List<CommentBean> r102 = this.f230915c;
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.collections.List<com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean>");
        CommentBean r103 = (CommentBean) ListProtector.get(r102, r111);
        List<CommentBean.CommentDetail> r104 = r103.getComment_list();
        if (r104 != null) goto L5;
        r104 = new ArrayList();
    L5:
        p r105 = this.f230916d;
        if (r105 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("config");
        r105 = null;
    L8:
        r105.N.a(new ef5.a(r103));
        int r106 = k.f230950a;
        p r107 = this.f230916d;
        if (r107 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("config");
        r107 = null;
    L11:
        Intrinsics.checkNotNullParameter(r107, "config");
        Intrinsics.checkNotNullParameter(r103, "commentBean");
        Intrinsics.checkNotNullParameter(r104, "commentList");
        boolean r112 = true;
        if ((!r104.isEmpty()) == false) goto L17;
        if (((CommentBean.CommentDetail) ListProtector.get(r104, 0)).getReplyType() < 0) goto L17;
        k.a(r104, ((CommentBean.CommentDetail) ListProtector.get(r104, 0)).getComment_id(), ((CommentBean.CommentDetail) ListProtector.get(r104, 0)).getCommentType(), r103);
    L30:
        List<CommentBean.CommentDetail> r113 = r101.getCommentDetails();
        r101.setQuote(r103.getQuote());
        r101.setParentToken(r103.getParentToken());
        r101.setParentType(r103.getParentType());
        r101.setPosition(r103.getPosition());
        r101.setBizParams(r103.getBizParams());
        if (TextUtils.isEmpty(r103.getCurrentReplyId()) == true) goto L36;
        com.bytedance.ee.bear.middleground.comment.card.d r108 = this.f230922j;
        if (r108 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("cardDataViewModel");
        r108 = null;
    L35:
        r108.f230967i = r103.getCurrentReplyId();
    L36:
        p r109 = this.f230916d;
        if (r109 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("config");
        r109 = null;
    L40:
        if (r109.getActivity().getResources().getConfiguration().orientation == 2) goto L42;
        boolean r114 = true;
    L43:
        Object r115 = r110.getAdapter();
        if ((r115 instanceof ICardAdapter) == false) goto L46;
        ICardAdapter r116 = (ICardAdapter) r115;
    L47:
        if (r116 == null) goto L49;
        w r117 = r116.getUiState();
    L50:
        Integer r118 = this.f230927o;
        if (r118 != null) goto L54;
    L55:
        if (r117 == null) goto L57;
        String r119 = r117.f231400a;
    L58:
        if (r119 == null) goto L64;
        int r120 = CommentDiffUtils.f231330a;
        Object r121 = r110.getAdapter();
        if ((r121 instanceof ICardAdapter) == false) goto L62;
        ICardAdapter r122 = (ICardAdapter) r121;
    L63:
        CommentDiffUtils.b(r122, r117.f231401b);
        goto L64
    L62:
        r122 = null;
    L64:
        int r123 = CommentDiffUtils.f231330a;
        p r124 = this.f230916d;
        if (r124 != null) goto L68;
        Intrinsics.throwUninitializedPropertyAccessException("config");
        r124 = null;
    L68:
        if (this.f230926n == r114) goto L70;
        boolean r125 = true;
    L71:
        String r126 = r103.getCurrentReplyId();
        if (r126 != null) goto L74;
        String r127 = "";
    L75:
        p r128 = this.f230916d;
        if (r128 != null) goto L78;
        Intrinsics.throwUninitializedPropertyAccessException("config");
        r128 = null;
    L78:
        CommentDiffUtils.a(r101, r124, r103, r210, r125, r127, r128.f232227e0);
        r101.setCardPos(r111);
        p r129 = this.f230916d;
        if (r129 != null) goto L82;
        Intrinsics.throwUninitializedPropertyAccessException("config");
        r129 = null;
    L82:
        if (r129.getActivity().getResources().getConfiguration().orientation != 2) goto L85;
        r112 = false;
    L85:
        this.f230926n = r112;
        p r130 = this.f230916d;
        if (r130 != null) goto L88;
        Intrinsics.throwUninitializedPropertyAccessException("config");
        r130 = null;
    L88:
        r130.N.a(new x(r110, r103, r113));
        return;
    L74:
        r127 = r126;
        goto L75
    L70:
        r125 = false;
        goto L71
    L57:
        r119 = null;
        goto L58
    L54:
        if (r118.intValue() == r111) goto L64;
    L49:
        r117 = null;
        goto L50
    L46:
        r116 = null;
        goto L47
    L42:
        r114 = false;
    L17:
        if (r104.size() <= 2) goto L22;
        if (((CommentBean.CommentDetail) ListProtector.get(r104, 0)).getReplyType() >= 0) goto L22;
        ((CommentBean.CommentDetail) ListProtector.get(r104, 0)).setComment_id(((CommentBean.CommentDetail) ListProtector.get(r104, 0)).getComment_id());
        ((CommentBean.CommentDetail) ListProtector.get(r104, 0)).setReply_id(r103.getQuote() + r103.isUnSubmitComment());
        ((CommentBean.CommentDetail) ListProtector.get(r104, 0)).setContent(r103.getQuote());
        ((CommentBean.CommentDetail) ListProtector.get(r104, 0)).setCommentType(((CommentBean.CommentDetail) ListProtector.get(r104, 0)).getCommentType());
        ((CommentBean.CommentDetail) ListProtector.get(r104, 0)).setUser_id(r103.getUserId());
        ((CommentBean.CommentDetail) ListProtector.get(r104, 0)).setReplyType(-1);
    L22:
        if (r104.isEmpty() == false) goto L30;
        if (r103.isNewInput() == false) goto L30;
        k.a(r104, r103.getComment_id(), r103.getCommentType(), r103);
        CommentBean.CommentDetail r131 = new CommentBean.CommentDetail();
        r131.setReplyType(3);
        r107.f232232h.getClass();
        r131.setName(com.bytedance.ee.bear.middleground.comment.p.b());
        r131.setComment_id(r103.getComment_id());
        r131.setCommentType(r103.getCommentType());
        r131.setUser_id(r103.getUserId());
        r107.f232232h.getClass();
        AccountService$Account r132 = ((h0) org.koin.java.a.a(h0.class)).G2();
        if (r132 == null) goto L28;
        String r133 = r132.avatarUrl;
    L29:
        r131.setAvatar_url(r133);
        r131.setReply_id(r103.getComment_id());
        r131.setError(new ErrorBean());
        r104.add(r131);
        goto L30
    L28:
        r133 = "";
        goto L29
    }

    public final Object H2(List<String> r110, List<CommentBean> r111, Continuation<? super Unit> r112) {
        D2(r111);
        this.f230919g = r110;
        List<CommentBean> r113 = this.f230915c;
        this.f230915c = r111;
        AlignAndScrollManager r100 = this.f230931s;
        if (r100 == null) goto L81;
        Integer r101 = this.f230927o;
        tt5.a.h("Comment#AlignAndScrollManager", "lockAnchorPoint currentIndex = " + r101);
        List<CommentBean> r102 = r113;
        boolean r103 = true;
        if (r102 != null) goto L7;
    L10:
        boolean r104 = true;
    L11:
        if (r104 == true) goto L74;
        List<CommentBean> r105 = r111;
        if (r105 != null) goto L15;
    L18:
        if (r103 == true) goto L74;
        if (r101 == null) goto L39;
        Iterator<CommentBean> r106 = r111.iterator();
        int r107 = 0;
    L24:
        if (r106.hasNext() == false) goto L33;
        String r108 = r106.next().getComment_id();
        CommentBean r109 = (CommentBean) CollectionsKt.getOrNull(r113, r101.intValue());
        if (r109 == null) goto L28;
        String r114 = r109.getComment_id();
    L30:
        if (Intrinsics.areEqual(r108, r114) == true) goto L34;
        r107 = r107 + 1;
    L34:
        if (r107 < 0) goto L39;
        Object r115 = r100.d(r101.intValue(), r107, r112);
        if (r115 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L76;
        r115 = Unit.INSTANCE;
    L76:
        if (r115 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L79;
        return r115;
    L79:
        return Unit.INSTANCE;
    L28:
        r114 = null;
        goto L30
    L33:
        r107 = -1;
    L39:
        RecyclerView.LayoutManager r116 = r100.f230878b.getLayoutManager();
        if ((r116 instanceof LinearLayoutManager) == false) goto L42;
        LinearLayoutManager r117 = (LinearLayoutManager) r116;
    L43:
        if (r117 == null) goto L45;
        int r118 = r117.findFirstVisibleItemPosition();
    L46:
        if (r117 == null) goto L48;
        int r119 = r117.findLastVisibleItemPosition();
    L49:
        if (r118 < 0) goto L73;
        if (r119 < 0) goto L73;
        if (r118 > r119) goto L72;
    L53:
        Iterator<CommentBean> r120 = r111.iterator();
        int r121 = 0;
    L55:
        if (r120.hasNext() == false) goto L64;
        String r122 = r120.next().getComment_id();
        CommentBean r123 = (CommentBean) CollectionsKt.getOrNull(r113, r118);
        if (r123 == null) goto L59;
        String r124 = r123.getComment_id();
    L61:
        if (Intrinsics.areEqual(r122, r124) == true) goto L65;
        r121 = r121 + 1;
    L65:
        if (r121 >= 0) goto L66;
        if (r118 == r119) goto L72;
        r118 = r118 + 1;
        goto L53
    L66:
        r115 = r100.d(r118, r121, r112);
        if (r115 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L76;
        r115 = Unit.INSTANCE;
        goto L76
    L59:
        r124 = null;
        goto L61
    L64:
        r121 = -1;
    L72:
        r115 = Unit.INSTANCE;
    L73:
        r115 = Unit.INSTANCE;
        goto L76
    L48:
        r119 = -1;
        goto L49
    L45:
        r118 = -1;
        goto L46
    L42:
        r117 = null;
        goto L43
    L15:
        if (r105.isEmpty() == true) goto L18;
        r103 = false;
    L74:
        r115 = Unit.INSTANCE;
        goto L76
    L7:
        if (r102.isEmpty() == true) goto L10;
        r104 = false;
        goto L11
    L81:
        return Unit.INSTANCE;
    }

    public final Object G2(Integer r210, boolean r211, Integer r212, Continuation<? super Unit> r213) {
        Integer r100 = r210;
        if ((r213 instanceof AsidePageAdapter$switchCurrentItem$2) == false) goto L7;
        AsidePageAdapter$switchCurrentItem$2 r101 = (AsidePageAdapter$switchCurrentItem$2) r213;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        p r110 = null;
        if (r105 == 0) goto L22;
        if (r105 == 1) goto L21;
        if (r105 == 2) goto L20;
        if (r105 == 3) goto L19;
        if (r105 == 4) goto L18;
        if (r105 != 5) goto L17;
        ResultKt.throwOnFailure(r103);
    L158:
        return Unit.INSTANCE;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        int r106 = r101.I$0;
        String r107 = (String) r101.L$3;
        String r108 = (String) r101.L$2;
        String r109 = (String) r101.L$1;
        Integer r111 = (Integer) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L138:
        Boolean r112 = (Boolean) r103;
        int r113 = r106;
        String r114 = r107;
        r100 = r111;
    L140:
        AlignAndScrollManager r115 = this.f230931s;
        if (r115 == null) goto L143;
        Integer r116 = r115.a(r100.intValue());
    L144:
        if (r116 == null) goto L146;
        r116 = Boxing.boxInt(n.E(r116.intValue()));
    L146:
        Integer r214 = r116;
        if (Intrinsics.areEqual(r109, r108) == true) goto L152;
        p r117 = this.f230916d;
        if (r117 != null) goto L151;
        Intrinsics.throwUninitializedPropertyAccessException("config");
        r117 = null;
    L151:
        r117.N.a(new ef5.j(r100, r113, r108, r114, r109, r214));
    L152:
        AlignAndScrollManager r118 = this.f230931s;
        if (r118 == null) goto L160;
        int r119 = r100.intValue();
        r101.L$0 = null;
        r101.L$1 = null;
        r101.L$2 = null;
        r101.L$3 = null;
        r101.label = 5;
        if (r118.f(r119, r101) != r104) goto L158;
        return r104;
    L160:
        return Unit.INSTANCE;
    L143:
        r116 = null;
        goto L144
    L19:
        int r120 = r101.I$0;
        r107 = (String) r101.L$3;
        r108 = (String) r101.L$2;
        r109 = (String) r101.L$1;
        Integer r121 = (Integer) r101.L$0;
        ResultKt.throwOnFailure(r103);
        int r122 = r120;
        r100 = r121;
    L130:
        Boolean r123 = (Boolean) r103;
    L132:
        AlignAndScrollManager r124 = this.f230931s;
        if (r124 == null) goto L139;
        int r125 = r100.intValue();
        r101.L$0 = r100;
        r101.L$1 = r109;
        r101.L$2 = r108;
        r101.L$3 = r107;
        r101.I$0 = r122;
        r101.label = 4;
        r103 = r124.b(r125, r101);
        if (r103 != r104) goto L137;
        return r104;
    L137:
        r111 = r100;
        r106 = r122;
        goto L138
    L139:
        r114 = r107;
        r113 = r122;
        goto L140
    L20:
        ResultKt.throwOnFailure(r103);
    L56:
        return Unit.INSTANCE;
    L21:
        r100 = (Integer) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L46:
        if (((Boolean) r103).booleanValue() != true) goto L48;
        boolean r126 = true;
    L49:
        if (r126 == false) goto L56;
        AlignAndScrollManager r127 = this.f230931s;
        if (r127 == null) goto L56;
        int r128 = r100.intValue();
        r101.L$0 = null;
        r101.label = 2;
        if (r127.f(r128, r101) != r104) goto L56;
        return r104;
    L48:
        r126 = false;
        goto L49
    L22:
        ResultKt.throwOnFailure(r103);
        tt5.a.h("Comment#CommentPagerAdapter2", "switchCurrentItem targetItem = " + r100 + " smooth = " + r211);
        com.bytedance.ee.bear.middleground.comment.card.d r129 = this.f230922j;
        if (r129 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("cardDataViewModel");
        r129 = null;
    L25:
        String r130 = r129.f230969k;
        com.bytedance.ee.bear.middleground.comment.card.d r131 = this.f230922j;
        if (r131 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("cardDataViewModel");
        r131 = null;
    L28:
        com.bytedance.ee.bear.middleground.comment.card.d r132 = this.f230922j;
        if (r132 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("cardDataViewModel");
        r132 = null;
    L31:
        String r133 = r132.f(r100);
        r131.getClass();
        Intrinsics.checkNotNullParameter(r133, "<set-?>");
        r131.f230969k = r133;
        if (Intrinsics.areEqual(r100, this.f230927o) == false) goto L57;
        com.bytedance.ee.bear.middleground.comment.card.d r134 = this.f230922j;
        if (r134 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("cardDataViewModel");
        r134 = null;
    L37:
        if (Intrinsics.areEqual(r130, r134.f230969k) == false) goto L57;
        if (r212 == null) goto L56;
        if (r100 == null) goto L56;
        AlignAndScrollManager r135 = this.f230931s;
        if (r135 == null) goto L48;
        int r136 = r210.intValue();
        int r137 = r212.intValue();
        r101.L$0 = r100;
        r101.label = 1;
        r103 = r135.e(r136, r137, r101);
        if (r103 != r104) goto L46;
        return r104;
    L57:
        B2();
        Integer r138 = this.f230927o;
        if (r100 != null) goto L60;
    L63:
        Integer r139 = null;
    L64:
        this.f230927o = r139;
        D2(this.f230915c);
        F2();
        if (Intrinsics.areEqual(r100, null) == true) goto L68;
        notifyItemChanged(r210.intValue(), new Object());
    L68:
        if (Intrinsics.areEqual(r138, null) == true) goto L70;
        notifyItemChanged(r138.intValue(), new Object());
    L70:
        com.bytedance.ee.bear.middleground.comment.card.d r140 = this.f230922j;
        if (r140 != null) goto L73;
        Intrinsics.throwUninitializedPropertyAccessException("cardDataViewModel");
        r140 = null;
    L73:
        String r141 = r140.f(r100);
        com.bytedance.ee.bear.middleground.comment.card.d r142 = this.f230922j;
        if (r142 != null) goto L76;
        Intrinsics.throwUninitializedPropertyAccessException("cardDataViewModel");
        r142 = null;
    L76:
        CommentBean r143 = r142.e(r100);
        if (r143 == null) goto L79;
        r122 = r143.getCommentType();
    L80:
        if (r143 == null) goto L82;
        String r144 = r143.getCommentUUID();
    L84:
        if (r144 != null) goto L86;
        r144 = "";
    L86:
        p r145 = this.f230916d;
        if (r145 != null) goto L89;
        Intrinsics.throwUninitializedPropertyAccessException("config");
        r145 = null;
    L89:
        r145.getClass();
        Intrinsics.checkNotNullParameter(r141, "<set-?>");
        r145.f232249y = r141;
        p r146 = this.f230916d;
        if (r146 != null) goto L92;
        Intrinsics.throwUninitializedPropertyAccessException("config");
        r146 = null;
    L92:
        com.bytedance.ee.bear.middleground.comment.uitls.h r147 = r146.f232225d0;
        com.bytedance.ee.bear.middleground.comment.card.d r148 = this.f230922j;
        if (r148 != null) goto L95;
        Intrinsics.throwUninitializedPropertyAccessException("cardDataViewModel");
        r148 = null;
    L95:
        CommentBean r149 = r148.e(r100);
        if (r149 == null) goto L101;
        CommentBean.Extra r150 = r149.getExtra();
        if (r150 == null) goto L101;
        String r151 = r150.getReportVisibility();
        if (r151 == null) goto L101;
    L102:
        r147.e(r141, r151);
        p r152 = this.f230916d;
        if (r152 != null) goto L105;
        Intrinsics.throwUninitializedPropertyAccessException("config");
        r152 = null;
    L105:
        com.bytedance.ee.bear.middleground.comment.uitls.h r153 = r152.f232225d0;
        com.bytedance.ee.bear.middleground.comment.card.d r154 = this.f230922j;
        if (r154 != null) goto L108;
        Intrinsics.throwUninitializedPropertyAccessException("cardDataViewModel");
        r154 = null;
    L108:
        String r215 = r154.f(r100);
        if (r100 != null) goto L112;
    L114:
        boolean r216 = false;
    L115:
        r153.d("bubble_comment_page_slide", null, r215, "", r216);
        if (r100 != null) goto L122;
        p r155 = this.f230916d;
        if (r155 != null) goto L120;
        Intrinsics.throwUninitializedPropertyAccessException("config");
    L121:
        r110.N.a(new ef5.j(r210, r122, r141, r144, r130, null));
        goto L160
    L120:
        r110 = r155;
        goto L121
    L122:
        r107 = r144;
        if (r212 == null) goto L131;
        AlignAndScrollManager r156 = this.f230931s;
        if (r156 == null) goto L131;
        int r157 = r210.intValue();
        int r158 = r212.intValue();
        r101.L$0 = r100;
        r101.L$1 = r130;
        r101.L$2 = r141;
        r101.L$3 = r107;
        r101.I$0 = r122;
        r101.label = 3;
        r103 = r156.e(r157, r158, r101);
        if (r103 != r104) goto L129;
        return r104;
    L129:
        r108 = r141;
        r109 = r130;
    L131:
        r108 = r141;
        r109 = r130;
        goto L132
    L112:
        if (r210.intValue() != 0) goto L114;
        r216 = true;
    L101:
        r151 = "";
        goto L102
    L82:
        r144 = null;
        goto L84
    L79:
        r122 = 0;
        goto L80
    L60:
        if (r210.intValue() < 0) goto L63;
        r139 = r100;
    L7:
        r101 = new AsidePageAdapter$switchCurrentItem$2(this, r213);
        goto L8
    }
}
