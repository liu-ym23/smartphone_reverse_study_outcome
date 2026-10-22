package com.ss.android.lark.feed.shared.page.binder2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewGroupKt;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.bytedance.lark.pb.feed.v1.AppFeedCardType;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larus.nova.R;
import com.ss.android.lark.biz.im.api.FeedCard;
import com.ss.android.lark.biz.im.api.extension.ImExtensionType;
import com.ss.android.lark.feed.app.entity.UIFeedCard;
import com.ss.android.lark.feed.export.feedcard.action.FeedActionEvent;
import com.ss.android.lark.feed.export.feedcard.action.FeedActionType;
import com.ss.android.lark.feed.shared.page.swipe.BaseFeedSwipeActionView;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000è\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\f\u0018\u0000 \u0087\u00012\u00020\u0001:\u0002\u0087\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010P\u001a\u00020Q2\b\u0010R\u001a\u0004\u0018\u00010!H\u0002J&\u0010S\u001a\u00020Q2\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020Y2\u0006\u0010\u0004\u001a\u00020\u0005J\u0016\u0010Z\u001a\u00020Q2\u0006\u0010T\u001a\u00020U2\u0006\u0010X\u001a\u00020YJ\u0010\u0010[\u001a\u00020Q2\u0006\u0010\\\u001a\u00020\u001dH\u0002J(\u0010e\u001a\u00020Q2\u0006\u0010T\u001a\u00020U2\b\u0010a\u001a\u0004\u0018\u00010b2\u0006\u0010X\u001a\u00020Y2\u0006\u0010\u0004\u001a\u00020\u0005J\u0018\u0010f\u001a\u00020Q2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010T\u001a\u00020UH\u0002J\u0018\u0010g\u001a\u00020Q2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010T\u001a\u00020UH\u0002J(\u0010h\u001a\u00020Q2\u0006\u0010T\u001a\u00020U2\u0006\u0010a\u001a\u00020b2\u0006\u0010X\u001a\u00020Y2\u0006\u0010c\u001a\u00020dH\u0002J\u0010\u0010i\u001a\u00020Q2\u0006\u0010T\u001a\u00020UH\u0002J(\u0010j\u001a\u00020Q2\u0006\u0010T\u001a\u00020U2\u0006\u0010a\u001a\u00020b2\u0006\u0010X\u001a\u00020Y2\u0006\u0010c\u001a\u00020dH\u0002J\u0010\u0010k\u001a\u00020\u001a2\u0006\u0010T\u001a\u00020UH\u0002J\u0010\u0010l\u001a\u00020Q2\u0006\u0010T\u001a\u00020UH\u0002J*\u0010m\u001a\u00020Q2\u0006\u0010T\u001a\u00020U2\b\u0010a\u001a\u0004\u0018\u00010b2\u0006\u0010X\u001a\u00020Y2\u0006\u0010c\u001a\u00020dH\u0002JD\u0010n\u001a\u00020Q2\u0006\u0010T\u001a\u00020U2\u0006\u0010X\u001a\u00020Y2\"\u0010o\u001a\u001e\u0012\u0004\u0012\u00020q\u0012\u0004\u0012\u00020r0pj\u000e\u0012\u0004\u0012\u00020q\u0012\u0004\u0012\u00020r`s2\u0006\u0010c\u001a\u00020dH\u0002J\b\u0010t\u001a\u00020QH\u0016J\u0010\u0010u\u001a\u00020Q2\u0006\u0010v\u001a\u00020UH\u0016J\b\u0010w\u001a\u00020\u001dH\u0016J \u0010z\u001a\u00020Q2\u0006\u0010{\u001a\u00020|2\u0006\u0010}\u001a\u00020|2\u0006\u0010~\u001a\u00020\u001aH\u0016J\b\u0010\u007f\u001a\u00020QH\u0002J\u0011\u0010\u0080\u0001\u001a\u00020Q2\u0006\u0010{\u001a\u00020|H\u0002J\u0011\u0010\u0081\u0001\u001a\u00020Q2\u0006\u0010{\u001a\u00020|H\u0003J\t\u0010\u0082\u0001\u001a\u00020QH\u0002J\t\u0010\u0083\u0001\u001a\u00020QH\u0002J\u0014\u0010\u0084\u0001\u001a\u00020Q2\t\b\u0001\u0010\u0085\u0001\u001a\u00020\u001dH\u0002J\t\u0010\u0086\u0001\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\u00020\u001d8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR(\u0010\"\u001a\u0004\u0018\u00010!2\b\u0010 \u001a\u0004\u0018\u00010!@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010'\u001a\u0004\u0018\u00010(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u00103\u001a\u000204X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u0010\u00109\u001a\u0004\u0018\u00010:X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010;\u001a\u00020<8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\b=\u0010>R\u001c\u0010A\u001a\u0004\u0018\u00010BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u000e\u0010G\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010I\u001a\b\u0012\u0004\u0012\u00020K0JX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010L\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bO\u0010@\u001a\u0004\bM\u0010NR\u001c\u0010T\u001a\u0004\u0018\u00010UX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R\u0010\u0010a\u001a\u0004\u0018\u00010bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010X\u001a\u0004\u0018\u00010YX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010c\u001a\u0004\u0018\u00010dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010x\u001a\u0004\u0018\u00010yX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0088\u0001"}, d2 = {"Lcom/ss/android/lark/feed/shared/page/binder2/FeedCommonViewHolder;", "Lcom/ss/android/lark/feed/shared/page/binder2/BaseFeedSwipeableViewHolder;", "itemView", "Landroid/view/View;", "feedCardContext", "Lcom/ss/android/lark/feed/export/feedcard/IFeedCardContext;", "<init>", "(Landroid/view/View;Lcom/ss/android/lark/feed/export/feedcard/IFeedCardContext;)V", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "kotlin.jvm.PlatformType", "mLastClickTime", "", "mInterval", "rightActionContainer", "Landroid/widget/LinearLayout;", "leftActionContainer", "contentView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "priorityMessageView", "Landroid/widget/RelativeLayout;", "displayRightActionViews", "", "Lcom/ss/android/lark/feed/shared/page/swipe/BaseFeedSwipeActionView;", "leftView", "bindLeftActionState", "", "forceRightActionFresh", "doneWidth", "", "getDoneWidth", "()I", "value", "Lcom/ss/android/lark/feed/export/feedcard/IOpenFeedCell;", "openFeedCell", "getOpenFeedCell", "()Lcom/ss/android/lark/feed/export/feedcard/IOpenFeedCell;", "setOpenFeedCell", "(Lcom/ss/android/lark/feed/export/feedcard/IOpenFeedCell;)V", "openFeedAction", "Lcom/ss/android/lark/feed/export/feedcard/action/IOpenFeedAction;", "getOpenFeedAction", "()Lcom/ss/android/lark/feed/export/feedcard/action/IOpenFeedAction;", "setOpenFeedAction", "(Lcom/ss/android/lark/feed/export/feedcard/action/IOpenFeedAction;)V", "feedType", "Lcom/ss/android/lark/biz/im/api/FeedCard$Type;", "getFeedType", "()Lcom/ss/android/lark/biz/im/api/FeedCard$Type;", "setFeedType", "(Lcom/ss/android/lark/biz/im/api/FeedCard$Type;)V", "bizType", "Lcom/bytedance/lark/pb/feed/v1/AppFeedCardType;", "getBizType", "()Lcom/bytedance/lark/pb/feed/v1/AppFeedCardType;", "setBizType", "(Lcom/bytedance/lark/pb/feed/v1/AppFeedCardType;)V", "clickDelayJob", "Lkotlinx/coroutines/Job;", "swipeViewBinder", "Lcom/ss/android/lark/feed/shared/page/binder2/SwipeViewBinder;", "getSwipeViewBinder", "()Lcom/ss/android/lark/feed/shared/page/binder2/SwipeViewBinder;", "swipeViewBinder$delegate", "Lkotlin/Lazy;", "currentLongClickDialog", "Lcom/larksuite/component/universe_design/dialog/UDDialog;", "getCurrentLongClickDialog", "()Lcom/larksuite/component/universe_design/dialog/UDDialog;", "setCurrentLongClickDialog", "(Lcom/larksuite/component/universe_design/dialog/UDDialog;)V", "avatarSize", "teamHeight", "observer", "Landroidx/lifecycle/Observer;", "Lcom/bytedance/lark/pb/feed/v1/FeedSlideActionSetting;", "disableDialogNoDismiss", "getDisableDialogNoDismiss", "()Z", "disableDialogNoDismiss$delegate", "fillContainer", "", LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL, "onBindViewHolder", "uiFeedCard", "Lcom/ss/android/lark/feed/app/entity/UIFeedCard;", "paramsFactory", "Lcom/ss/android/lark/feed/export/feedcard/IComponentParamsFactory;", "itemContainer", "Lcom/ss/android/lark/feed/shared/page/adapter/listener/IItemContainer;", "setBackground", "setLeftAndRightViewTopMargins", "topMargin", "getUiFeedCard", "()Lcom/ss/android/lark/feed/app/entity/UIFeedCard;", "setUiFeedCard", "(Lcom/ss/android/lark/feed/app/entity/UIFeedCard;)V", "manager", "Lcom/ss/android/lark/feed/shared/page/action/FeedActionManager;", "actionStatusListener", "Lcom/ss/android/lark/feed/export/feedcard/action/ActionStatusListener;", "bindAction", "delayUpdate", "addPriorityInfo", "delayBindLeftActionView", "bindSwipeAction", "delayBindRightActionView", "resetSwipeIfNeeded", "resetSwipeAction", "bindLongClick", "handleItemLongClick", "feedActionMap", "Ljava/util/LinkedHashMap;", "Lcom/ss/android/lark/feed/export/feedcard/action/FeedActionType;", "Lcom/ss/android/lark/feed/export/feedcard/action/IFeedActionFactory;", "Lkotlin/collections/LinkedHashMap;", "onViewRecycled", "onRightRemoveAction", "data", "getSwipeReactionType", "cachedSwipeListener", "Lcom/h6ah4i/android/widget/advrecyclerview/swipeable/RecyclerViewSwipeManager$OnItemSwipeEventListener;", "onSlideAmountUpdated", "horizontalAmount", "", "verticalAmount", "isSwiping", "setCachedSwipeListener", "onSwipingToLeft", "onSwipingToRight", "updateSwipeLeftAmount", "updateSwipeRightAmount", "updateLeftContainerBackground", "bgColor", "getSwipeableContainerView", "Companion", "feed-shared_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeedCommonViewHolder extends BaseFeedSwipeableViewHolder {
    public static final n M = null;
    public static final o N = null;
    public static final int O = 0;
    public FeedCard.Type A;
    public AppFeedCardType B;
    public Job C;
    public final Lazy D;
    public UDDialog E;
    public final i F;
    public final Lazy G;
    public UIFeedCard H;
    public seb.b I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public ueb.a f421318J;
    public e K;
    public k L;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final com.ss.android.lark.feed.export.feedcard.d f421319m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Context f421320n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f421321o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final long f421322p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final LinearLayout f421323q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final LinearLayout f421324r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final ConstraintLayout f421325s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final RelativeLayout f421326t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final List<BaseFeedSwipeActionView> f421327u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public BaseFeedSwipeActionView f421328v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f421329w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f421330x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public com.ss.android.lark.feed.export.feedcard.h f421331y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public aeb.f f421332z;

    public static final class a {
    }

    static {
        int r100 = com.ss.android.lark.feed.shared.data.utils.c.f421166a;
        Map<ImExtensionType, List<Class<?>>> r101 = com.ss.android.lark.im.base.d.f425883a;
        M = (n) CollectionsKt.firstOrNull(com.ss.android.lark.im.base.d.c(ImExtensionType.FEED_ITEM_LAYOUT_STRATEGY, n.class));
        N = (o) CollectionsKt.firstOrNull(com.ss.android.lark.im.base.d.c(ImExtensionType.FEED_ITEM_LONG_CLICK_DIALOG, o.class));
        O = UIHelper.dp2px(32.0f);
    }

    @Override // com.ss.android.lark.feed.shared.page.binder2.BaseFeedSwipeableViewHolder
    public final int T3() {
        UIFeedCard r100 = this.H;
        if (r100 == null) goto L26;
        aeb.f r101 = this.f421332z;
        Integer r102 = null;
        if (r101 == null) goto L23;
        ueb.a r103 = this.f421318J;
        if (r103 == null) goto L23;
        seb.b r104 = this.I;
        if (r104 == null) goto L23;
        Intrinsics.checkNotNullParameter(r100, "uiFeedCard");
        Intrinsics.checkNotNullParameter(r101, "feedAction");
        Intrinsics.checkNotNullParameter(r103, "itemContainer");
        List<FeedActionType> r105 = r104.c(r100, r101, r103);
        List<FeedActionType> r106 = r104.d(r100, r101, r103);
        List<FeedActionType> r107 = r105;
        if ((!r107.isEmpty()) == false) goto L16;
        if ((!r106.isEmpty()) == false) goto L16;
        int r108 = 8194;
    L22:
        r102 = Integer.valueOf(r108);
    L16:
        if ((!r107.isEmpty()) == false) goto L19;
        r108 = 2;
        goto L22
    L19:
        if ((!r106.isEmpty()) == false) goto L21;
        r108 = 8192;
        goto L22
    L21:
        r108 = 0;
    L23:
        if (r102 != null) goto L25;
        return 0;
    L25:
        return r102.intValue();
    L26:
        return 0;
    }

    public final void X3() {
        if (((ArrayList) this.f421327u).isEmpty() == false) goto L5;
    L8:
        int r100 = 0;
        this.f421330x = false;
        UIFeedCard r101 = this.H;
        seb.b r102 = this.I;
        ueb.a r103 = this.f421318J;
        e r104 = this.K;
        if (r101 == null) goto L53;
        if (r102 == null) goto L53;
        if (r103 == null) goto L53;
        if (r104 == null) goto L53;
        r r105 = (r) this.D.getValue();
        r105.getClass();
        Intrinsics.checkNotNullParameter(r101, "uiFeedCard");
        Intrinsics.checkNotNullParameter(r102, "manager");
        Intrinsics.checkNotNullParameter(r103, "itemContainer");
        Intrinsics.checkNotNullParameter(r104, "actionStatusListener");
        aeb.f r106 = r105.f421380b;
        if (r106 != null) goto L16;
        List r107 = CollectionsKt.emptyList();
    L50:
        if (r107.isEmpty() == false) goto L52;
        float r108 = 0.0f;
        this.f276060g = 0.0f;
    L55:
        if (this.f421317l == true) goto L58;
        r108 = -((this.f421323q.getMeasuredWidth() * 1.0f) / this.itemView.getWidth());
    L58:
        this.f276060g = r108;
        return;
    L52:
        r108 = 0.0f;
        ((ArrayList) this.f421327u).addAll(r107);
        goto L55
    L16:
        List<FeedActionType> r109 = r102.c(r101, r106, r103);
        if (r109.isEmpty() == false) goto L23;
        Iterator<View> r110 = ViewGroupKt.getChildren(r105.f421379a).iterator();
    L20:
        if (r110.hasNext() == false) goto L22;
        r110.next().setVisibility(8);
        goto L20
    L22:
        r107 = CollectionsKt.emptyList();
        goto L50
    L23:
        LinkedHashMap<FeedActionType, aeb.c> r111 = r102.a(r109, r106.c());
        int r112 = r109.size() - r105.f421379a.getChildCount();
        if (r112 <= 0) goto L28;
        int r113 = 0;
    L26:
        if (r113 >= r112) goto L28;
        r105.f421379a.addView(r105.a(), new LinearLayout.LayoutParams(-2, -1));
        r113 = r113 + 1;
    L28:
        ArrayList r114 = new ArrayList();
        int r115 = r109.size();
        int r116 = 0;
    L29:
        if (r116 >= r115) goto L42;
        View r117 = ViewGroupKt.get(r105.f421379a, r116);
        FeedActionType r118 = (FeedActionType) ListProtector.get(r109, r116);
        if ((r117 instanceof BaseFeedSwipeActionView) == false) goto L41;
        BaseFeedSwipeActionView r119 = (BaseFeedSwipeActionView) r117;
        r119.setVisibility(r100);
        r114.add(r117);
        aeb.c r120 = r111.get(r118);
        if (r120 == null) goto L35;
        aeb.e r121 = r120.i();
    L36:
        if (r121 == null) goto L39;
        r119.a(UDIconUtils.getIconDrawable(r105.f421381c, r121.c(r101), ContextCompat.getColor(r105.f421381c, R.color.static_white)), r121.e(r101), ContextCompat.getColor(r105.f421381c, r121.getBackground()));
    L39:
        r117.setOnClickListener(new q(r111, r118, r101, r104));
        r116 = r116 + 1;
        r114 = r114;
        r100 = 0;
        goto L29
    L35:
        r121 = null;
        goto L36
    L41:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L42:
        ArrayList r122 = r114;
        int r123 = r109.size();
        int r124 = r105.f421379a.getChildCount();
    L43:
        if (r123 >= r124) goto L48;
        View r125 = r105.f421379a.getChildAt(r123);
        if (r125 == null) goto L47;
        r125.setVisibility(8);
    L47:
        r123 = r123 + 1;
        goto L43
    L48:
        r105.f421379a.measure(View.MeasureSpec.makeMeasureSpec(1073741823, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(1073741823, Integer.MIN_VALUE));
        r107 = r122;
    L53:
        r108 = 0.0f;
        Log.w("FeedSharedModule_FeedCommonViewHolder", "swipe left feed card, but UIFeedCard is invalid.");
        goto L55
    L5:
        if (this.f421330x == true) goto L8;
        r108 = 0.0f;
        goto L55
    }

    @Override // com.ss.android.lark.feed.shared.page.binder2.BaseFeedSwipeableViewHolder
    public final void onViewRecycled() {
        com.ss.android.lark.feed.export.feedcard.h r100 = this.f421331y;
        if (r100 == null) goto L5;
        r100.onViewRecycled();
    L5:
        this.f421325s.animate().cancel();
        if (this.f421325s.getTranslationX() != 0.0f) goto L8;
        boolean r101 = true;
    L9:
        if (r101 == true) goto L11;
        this.f421325s.setTranslationX(0.0f);
    L11:
        this.f276058e = 0.0f;
        return;
    L8:
        r101 = false;
        goto L9
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.utils.AbstractSwipeableItemViewHolder, bw7.f
    public final ConstraintLayout r1() {
        return this.f421325s;
    }

    @Override // com.ss.android.lark.feed.shared.page.binder2.BaseFeedSwipeableViewHolder
    public final void U3(UIFeedCard r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        StringBuilder r101 = new StringBuilder("onRightRemoveAction handler:");
        BaseFeedSwipeActionView r102 = this.f421328v;
        if (r102 == null) goto L5;
        aeb.d r103 = r102.getFeedActionHandler();
    L6:
        r101.append(r103);
        r101.append(" listener:");
        r101.append(this.K);
        Log.i("FeedSharedModule_FeedCommonViewHolder", r101.toString());
        BaseFeedSwipeActionView r104 = this.f421328v;
        if (r104 == null) goto L14;
        aeb.d r105 = r104.getFeedActionHandler();
        if (r105 == null) goto L15;
        e r106 = this.K;
        if (r106 == null) goto L16;
        r105.o(r100, FeedActionEvent.RIGHT_SWIPE_LONG, r106);
        return;
    L16:
        return;
    L15:
        return;
    L14:
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.h6ah4i.android.widget.advrecyclerview.utils.AbstractSwipeableItemViewHolder, bw7.f
    public final void W0(float r110) {
        if (this.L != null) goto L5;
        this.L = new k(this);
    L5:
        bw7.b r100 = this.f421319m.d();
        if (r100 == null) goto L8;
        r100.B = this.L;
    L8:
        boolean r101 = true;
        if (this.f421329w == true) goto L46;
        UIFeedCard r102 = this.H;
        seb.b r103 = this.I;
        ueb.a r104 = this.f421318J;
        e r111 = this.K;
        if (r102 == null) goto L44;
        if (r103 == null) goto L44;
        if (r104 == null) goto L44;
        if (r111 == null) goto L44;
        this.f421329w = true;
        if (this.f421328v != null) goto L18;
        BaseFeedSwipeActionView r112 = ((r) this.D.getValue()).a();
        this.f421328v = r112;
        this.f421324r.addView(r112, new LinearLayout.LayoutParams(-2, -1));
    L18:
        BaseFeedSwipeActionView r113 = this.f421328v;
        if (r113 == null) goto L46;
        r r114 = (r) this.D.getValue();
        r114.getClass();
        Intrinsics.checkNotNullParameter(r102, "uiFeedCard");
        Intrinsics.checkNotNullParameter(r103, "manager");
        Intrinsics.checkNotNullParameter(r104, "itemContainer");
        Intrinsics.checkNotNullParameter(r111, "actionStatusListener");
        Intrinsics.checkNotNullParameter(r113, "leftView");
        aeb.f r115 = r114.f421380b;
        if (r115 == null) goto L46;
        List<? extends FeedActionType> r105 = CollectionsKt.toMutableList(r103.d(r102, r115, r104));
        aeb.f r116 = r114.f421380b;
        if (r116 == null) goto L27;
        List<aeb.c> r117 = r116.c();
        if (r117 == null) goto L27;
    L29:
        if ((!r105.isEmpty()) == false) goto L31;
        aeb.c r106 = r103.a(r105, r117).get(ListProtector.get(r105, 0));
    L32:
        if (r106 == null) goto L34;
        aeb.d r107 = r106.m();
    L35:
        if (r106 == null) goto L37;
        aeb.e r108 = r106.i();
    L38:
        if (r108 == null) goto L40;
        r113.a(UDIconUtils.getIconDrawable(r114.f421381c, r108.c(r102), ContextCompat.getColor(r114.f421381c, R.color.static_white)), r108.e(r102), ContextCompat.getColor(r114.f421381c, r108.getBackground()));
        Log.i("FeedSharedModule_FeedCommonViewHolder", "set background color:" + r108.getBackground());
    L40:
        Log.i("FeedSharedModule_FeedCommonViewHolder", "leftItem:" + r108);
        r113.setFeedActionHandler(r107);
        if (r107 == null) goto L43;
        r113.setVisibility(0);
        r113.setOnClickListener(new p(r107, r102, r111));
        goto L46
    L43:
        r113.setVisibility(8);
        goto L46
    L37:
        r108 = null;
        goto L38
    L34:
        r107 = null;
        goto L35
    L31:
        r106 = null;
    L27:
        r117 = CollectionsKt.emptyList();
    L44:
        Log.w("FeedSharedModule_FeedCommonViewHolder", "swipe right feed card, but UIFeedCard is invalid.");
    L46:
        if (this.f421316k == false) goto L49;
        this.f276062i = 0.0f;
    L57:
        X3();
        if (r110 >= 0.0f) goto L84;
        LinearLayout r109 = this.f421323q;
        if (r109.getVisibility() != 8) goto L62;
        boolean r118 = true;
    L63:
        if (r118 == true) goto L66;
        r109 = null;
    L66:
        if (r109 == null) goto L68;
        this.f421323q.setVisibility(0);
    L68:
        this.f421324r.setBackgroundColor(this.itemView.getResources().getColor(R.color.transparent));
        float r119 = r110 / this.f276060g;
        if (r119 <= 1.0f) goto L71;
        return;
    L71:
        if (r119 >= 0.0f) goto L73;
        return;
    L73:
        if (((ArrayList) this.f421327u).size() <= 0) goto L136;
        Iterator r120 = com.larksuite.framework.utils.p.a(this.f421327u).iterator();
        BaseFeedSwipeActionView r121 = null;
    L77:
        if (r120.hasNext() == false) goto L137;
        BaseFeedSwipeActionView r122 = (BaseFeedSwipeActionView) r120.next();
        if (r121 == null) goto L81;
        int r123 = r121.getMeasuredWidth();
    L82:
        r122.setTranslationX((r123 + r122.getMeasuredWidth()) * (1 - r119));
        r121 = r122;
        goto L77
    L81:
        r123 = 0;
        goto L82
    L137:
        return;
    L136:
        return;
    L62:
        r118 = false;
        goto L63
    L84:
        if (r110 > 0.0f) goto L86;
        return;
    L86:
        if (this.f421316k == true) goto L134;
        LinearLayout r124 = this.f421323q;
        if (r124.getVisibility() != 0) goto L90;
        boolean r125 = true;
    L91:
        if (r125 == true) goto L94;
        r124 = null;
    L94:
        if (r124 == null) goto L96;
        this.f421323q.setVisibility(8);
    L96:
        LinearLayout r126 = this.f421324r;
        if (r126.getVisibility() != 8) goto L99;
        boolean r127 = true;
    L100:
        if (r127 == true) goto L103;
        r126 = null;
    L103:
        if (r126 == null) goto L105;
        this.f421324r.setVisibility(0);
    L105:
        BaseFeedSwipeActionView r128 = this.f421328v;
        if (r128 == null) goto L108;
        Integer r129 = Integer.valueOf(r128.getBgColor());
    L109:
        if (r129 == null) goto L111;
        this.f421324r.setBackgroundColor(r129.intValue());
    L112:
        float r130 = this.itemView.getMeasuredWidth() * r110;
        BaseFeedSwipeActionView r131 = this.f421328v;
        if (r131 == null) goto L115;
        int r132 = r131.getMeasuredWidth();
    L116:
        float r133 = r130 - r132;
        UIFeedCard r134 = this.H;
        if (r134 != null) goto L119;
    L121:
        r101 = false;
    L122:
        if (r101 == false) goto L124;
        this.f276058e = r110;
    L124:
        BaseFeedSwipeActionView r135 = this.f421328v;
        if (r135 == null) goto L135;
        r135.setTranslationX(r133);
        return;
    L135:
        return;
    L119:
        if (r134.isSwipeRightPinned() != true) goto L121;
    L115:
        r132 = 0;
        goto L116
    L111:
        Log.e("FeedSharedModule_FeedCommonViewHolder", "updateLeftContainerBackground failed, bgColor:" + r129);
        goto L112
    L108:
        r129 = null;
        goto L109
    L99:
        r127 = false;
        goto L100
    L90:
        r125 = false;
        goto L91
    L134:
        return;
    L49:
        if (this.f421317l == false) goto L51;
        float r136 = 2.3148148f;
    L56:
        this.f276062i = r136;
        goto L57
    L51:
        BaseFeedSwipeActionView r137 = this.f421328v;
        if (r137 == null) goto L54;
        int r138 = r137.getMeasuredWidth();
    L55:
        r136 = (r138 * 1.0f) / this.itemView.getWidth();
        goto L56
    L54:
        r138 = 0;
        goto L55
    }

    public final void W3(int r100) {
        ViewGroup.LayoutParams r101 = this.f421324r.getLayoutParams();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r102 = (FrameLayout.LayoutParams) r101;
        if (r102.topMargin == r100) goto L5;
        r102.setMargins(0, r100, 0, 0);
        this.f421324r.setLayoutParams(r102);
    L5:
        ViewGroup.LayoutParams r103 = this.f421323q.getLayoutParams();
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams r104 = (FrameLayout.LayoutParams) r103;
        if (r104.topMargin == r100) goto L9;
        r104.setMargins(0, r100, 0, 0);
        this.f421323q.setLayoutParams(r104);
        return;
    }

    public FeedCommonViewHolder(View r100, yeb.a r101) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r101, "feedCardContext");
        super(r100);
        this.f421319m = r101;
        r100.addOnAttachStateChangeListener(new c(this, r100));
        Context r102 = r100.getContext();
        this.f421320n = r102;
        this.f421322p = 500;
        this.f421323q = (LinearLayout) r100.findViewById(R.id.right_container);
        this.f421324r = (LinearLayout) r100.findViewById(R.id.left_container);
        this.f421325s = (ConstraintLayout) r100.findViewById(R.id.content_view);
        this.f421326t = (RelativeLayout) r100.findViewById(R.id.rl_priority_message);
        this.f421327u = new ArrayList();
        this.A = FeedCard.Type.UNKNOWN;
        this.B = AppFeedCardType.UNKNOWN_APP_FEED_CARD_TYPE;
        this.D = LazyKt.lazy(new FeedCommonViewHolder$swipeViewBinder$2(this));
        zz7.b.g(r102, 48);
        zz7.b.g(r102, 20);
        this.F = new i(this);
        this.G = LazyKt.lazy(LazyThreadSafetyMode.NONE, FeedCommonViewHolder$disableDialogNoDismiss$2.INSTANCE);
    }

    public final void V3(UIFeedCard r100, ueb.a r101) {
        Intrinsics.checkNotNullParameter(r100, "uiFeedCard");
        Intrinsics.checkNotNullParameter(r101, "itemContainer");
        if (neb.e.a(r100) == false) goto L8;
        this.f421326t.setVisibility(0);
        W3(O);
        n r102 = M;
        if (r102 == null) goto L7;
        RelativeLayout r103 = this.f421326t;
        r102.a();
        r103.setBackgroundResource(R.drawable.flow_top_feed_item_selector_bg);
    L10:
        if (com.ss.android.lark.feed.shared.fg.c.b(this.f421319m.getHost().getActivity()) == false) goto L15;
        if (Intrinsics.areEqual(jeb.b.a().q3(), r100.getId()) == false) goto L15;
        this.f421325s.setBackgroundResource(R.drawable.bg_feed_item_active_layer);
        return;
    L15:
        if (r101.y() == true) goto L17;
    L22:
        n r104 = M;
        if (r104 == null) goto L25;
        ConstraintLayout r105 = this.f421325s;
        r104.c();
        r105.setBackgroundResource(R.drawable.flow_feed_item_selector_bg);
        return;
    L25:
        Log.e("FeedSharedModule_FeedCommonViewHolder", "set feed background failed, layoutStrategy is null");
        return;
    L17:
        if (com.ss.android.lark.feed.shared.page.utils.d.a(r100) == false) goto L22;
        n r106 = M;
        if (r106 == null) goto L21;
        ConstraintLayout r107 = this.f421325s;
        r106.a();
        r107.setBackgroundResource(R.drawable.flow_top_feed_item_selector_bg);
        return;
    L21:
        Log.e("FeedSharedModule_FeedCommonViewHolder", "set top feed background failed, layoutStrategy is null");
        return;
    L7:
        Log.e("FeedSharedModule_FeedCommonViewHolder", "set priority item background failed, layoutStrategy is null");
        goto L10
    L8:
        this.f421326t.setVisibility(8);
        W3(0);
        goto L10
    }
}
