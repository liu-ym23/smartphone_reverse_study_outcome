package com.larus.media.focus;

import android.graphics.Rect;
import android.os.SystemClock;
import android.util.Range;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.larus.utils.y;
import com.xiaomi.mipush.sdk.MiPushClient;
import go2.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import nk9.c;
import nk9.d;
import nk9.e;
import nk9.f;
import nk9.h;
import nk9.i;
import nk9.j;
import nk9.l;
import nk9.m;
import nk9.n;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000³\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\b\u0006\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f*\u0003BEK\u0018\u0000 \u0082\u00012\u00020\u0001:\u0006\u0082\u0001\u0083\u0001\u0084\u0001B)\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020\u0003H\u0002J\u000e\u0010W\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020#J\u000e\u0010X\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020#J\u000e\u0010Y\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020#J\u000e\u0010Z\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020#J\u000e\u0010[\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\\\u001a\u00020N2\u0006\u0010]\u001a\u00020\u0007J\u000e\u0010^\u001a\u00020N2\u0006\u0010]\u001a\u00020\u0007J\u0016\u0010_\u001a\u00020N2\u0006\u0010`\u001a\u00020\u00032\u0006\u0010O\u001a\u00020\u0003J\u000e\u0010a\u001a\u00020N2\u0006\u0010b\u001a\u00020cJ\u000e\u0010d\u001a\u00020\u00152\u0006\u0010e\u001a\u00020fJ\u000e\u0010g\u001a\u00020N2\u0006\u0010b\u001a\u00020cJ\u0010\u0010h\u001a\u00020\u00002\b\u0010i\u001a\u0004\u0018\u00010\u0011J\u0010\u0010j\u001a\u00020N2\u0006\u0010k\u001a\u00020cH\u0002J\u0012\u0010l\u001a\u00020N2\b\u0010m\u001a\u0004\u0018\u00010QH\u0002J\u0010\u0010n\u001a\u00020N2\u0006\u0010k\u001a\u00020cH\u0002J\b\u0010o\u001a\u00020#H\u0002J\u0010\u0010p\u001a\u00020N2\u0006\u0010q\u001a\u00020rH\u0016J\u0010\u0010s\u001a\u00020N2\u0006\u0010q\u001a\u00020rH\u0016J\u000e\u0010t\u001a\u00020N2\u0006\u0010u\u001a\u00020vJ\u000e\u0010t\u001a\u00020N2\u0006\u0010w\u001a\u00020fJ\u0012\u0010x\u001a\u0004\u0018\u00010v2\u0006\u0010u\u001a\u00020vH\u0002J\u0012\u0010x\u001a\u0004\u0018\u00010f2\u0006\u0010w\u001a\u00020fH\u0002J\u0006\u0010y\u001a\u00020#J\u000e\u0010z\u001a\u00020N2\u0006\u0010u\u001a\u00020vJ\u000e\u0010z\u001a\u00020N2\u0006\u0010w\u001a\u00020fJ\u0006\u0010{\u001a\u00020NJ\u0010\u0010|\u001a\u00020N2\u0006\u0010}\u001a\u00020:H\u0007J\u0010\u0010~\u001a\u00020N2\u0006\u0010}\u001a\u00020:H\u0007J\u000e\u0010\u007f\u001a\u00020N2\u0006\u0010}\u001a\u00020<J\u000f\u0010\u0080\u0001\u001a\u00020N2\u0006\u0010}\u001a\u00020<J\t\u0010\u0081\u0001\u001a\u00020\u0003H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R\u001e\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0003@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001a\u001a\u00020\u001e@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010'\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u000e\u0010,\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010-\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010)\"\u0004\b/\u0010+R\u001a\u00100\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010)\"\u0004\b1\u0010+R\u001a\u00102\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010)\"\u0004\b3\u0010+R\u000e\u00104\u001a\u000205X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00108\u001a\b\u0012\u0004\u0012\u00020:09X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010;\u001a\b\u0012\u0004\u0012\u00020<09X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010=\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0003@BX\u0086\u000e¢\u0006\u000e\n\u0000\u0012\u0004\b>\u0010?\u001a\u0004\b@\u0010\u001dR\u0010\u0010A\u001a\u00020BX\u0082\u0004¢\u0006\u0004\n\u0002\u0010CR\u0010\u0010D\u001a\u00020EX\u0082\u0004¢\u0006\u0004\n\u0002\u0010FR\u000e\u0010G\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020\u0003X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010J\u001a\u00020KX\u0082\u0004¢\u0006\u0004\n\u0002\u0010LR\u0014\u0010P\u001a\b\u0012\u0004\u0012\u00020Q09X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010R\u001a\b\u0012\u0004\u0012\u00020S09X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010T\u001a\b\u0012\u0004\u0012\u00020Q0UX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010V\u001a\b\u0012\u0004\u0012\u00020S0UX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0085\u0001"}, d2 = {"Lcom/larus/media/focus/OScrollStateHelper;", "Landroidx/recyclerview/widget/RecyclerView$OnChildAttachStateChangeListener;", "orientation", "", "focusStrategy", "Lcom/larus/media/focus/OIFocusStrategy;", "parentLifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "<init>", "(Ljava/lang/Integer;Lcom/larus/media/focus/OIFocusStrategy;Landroidx/lifecycle/LifecycleOwner;)V", "getFocusStrategy", "()Lcom/larus/media/focus/OIFocusStrategy;", "getParentLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "displayDispatcher", "Lcom/larus/media/focus/DisplayDispatcher;", "mRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "focusParent", "Lcom/larus/media/focus/OIFocusParent;", "touchSlop", "", "getTouchSlop", "()F", "touchSlop$delegate", "Lkotlin/Lazy;", "value", "scrollingState", "getScrollingState", "()I", "Lcom/larus/media/focus/OScrollStateHelper$ScrollDirection;", "scrollingDirection", "getScrollingDirection", "()Lcom/larus/media/focus/OScrollStateHelper$ScrollDirection;", "mSwitchFocusWhenDragging", "", "mSwitchFocusWhenFling", "mSwitchFocusWhenRaiseHand", "mLoseFocusWhenDragging", "ignoreSlop", "getIgnoreSlop", "()Z", "setIgnoreSlop", "(Z)V", "setOrientation", "enablePreRenderVideo", "getEnablePreRenderVideo", "setEnablePreRenderVideo", "isOpenSpeedFilter", "setOpenSpeedFilter", "isOpenSampleFilter", "setOpenSampleFilter", "cardActionCallback", "Lcom/larus/media/focus/OICardActionCallback;", "focusCardStateKeeper", "Lcom/larus/media/focus/CardStateKeeper;", "scrollListenerList", "", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "dispatchDisplayListenerList", "Lcom/larus/media/focus/OScrollStateHelper$DispatchDisplayListener;", "recyclerViewOrientation", "getRecyclerViewOrientation$annotations", "()V", "getRecyclerViewOrientation", "mDataObserver", "com/larus/media/focus/OScrollStateHelper$mDataObserver$1", "Lcom/larus/media/focus/OScrollStateHelper$mDataObserver$1;", "mLifecycleObserver", "com/larus/media/focus/OScrollStateHelper$mLifecycleObserver$1", "Lcom/larus/media/focus/OScrollStateHelper$mLifecycleObserver$1;", "onScrollCount", "onScrollSampleCount", "speedForDy", "mOnScrollListener", "com/larus/media/focus/OScrollStateHelper$mOnScrollListener$1", "Lcom/larus/media/focus/OScrollStateHelper$mOnScrollListener$1;", "computeFocusUseFilter", "", "dy", "mFocusListeners", "Lcom/larus/media/focus/FocusListenerWrapper;", "mDisplayListeners", "Lcom/larus/media/focus/DisplayListenerWrapper;", "mFocusComparator", "Lcom/larus/media/focus/RectComparator;", "mDisplayComparator", "switchWhenDragging", "switchWhenFling", "switchWhenRaiseHand", "loseWhenDragging", "setFocusParent", "pause", "owner", "resume", "computeDirection", "dx", "computeFocus", "triggerReason", "Lcom/larus/media/focus/CardContextState$TriggerReason;", "computeViewVisiblePct", "delegate", "Lcom/larus/media/focus/OIDisplayListener;", "computeAfterAnimation", "attachToRecyclerView", "recyclerView", "dispatchFocusSwitchEvent", "reason", "tryPreRenderVideo", "targetListenerWrapper", "dispatchDisplayChangeEvent", "checkLifecycle", "onChildViewAttachedToWindow", "view", "Landroid/view/View;", "onChildViewDetachedFromWindow", MiPushClient.COMMAND_REGISTER, "focusListener", "Lcom/larus/media/focus/OIFocusListener;", "displayListener", "preUnregister", "hasAttachRecyclerView", MiPushClient.COMMAND_UNREGISTER, "release", "addOnScrollListener", "listener", "removeOnScrollListener", "addDispatchDisplayListener", "removeDispatchDisplayListener", "getAdapterItemCount", "Companion", "ScrollDirection", "DispatchDisplayListener", "media_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OScrollStateHelper implements RecyclerView.OnChildAttachStateChangeListener {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final /* synthetic */ int f359033u = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f359034a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LifecycleOwner f359035b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.larus.media.focus.b f359036c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RecyclerView f359037d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f359038e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f359039f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ScrollDirection f359040g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f359041h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final g f359042i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final com.larus.media.focus.a f359043j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List<RecyclerView.OnScrollListener> f359044k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List<b> f359045l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f359046m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final OScrollStateHelper$mDataObserver$1 f359047n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final OScrollStateHelper$mLifecycleObserver$1 f359048o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final OScrollStateHelper$mOnScrollListener$1 f359049p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final List<c> f359050q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final List<nk9.b> f359051r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final l<c> f359052s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final l<nk9.b> f359053t;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\t\u001a\u00020\nj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\f"}, d2 = {"Lcom/larus/media/focus/OScrollStateHelper$ScrollDirection;", "", "<init>", "(Ljava/lang/String;I)V", UserProfileEvent.POSITION_NONE, "LEFT", "TOP", "RIGHT", "BOTTOM", "isPositive", "", "Companion", "media_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ScrollDirection extends Enum<ScrollDirection> {
        public static final ScrollDirection BOTTOM = null;
        public static final a Companion = null;
        public static final ScrollDirection LEFT = null;
        public static final ScrollDirection NONE = null;
        public static final ScrollDirection RIGHT = null;
        public static final ScrollDirection TOP = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ScrollDirection[] f359054a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f359055b = null;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<ScrollDirection> getEntries() {
            return f359055b;
        }

        static {
            ScrollDirection r100 = new ScrollDirection(UserProfileEvent.POSITION_NONE, 0);
            NONE = r100;
            ScrollDirection r101 = new ScrollDirection("LEFT", 1);
            LEFT = r101;
            ScrollDirection r102 = new ScrollDirection("TOP", 2);
            TOP = r102;
            ScrollDirection r103 = new ScrollDirection("RIGHT", 3);
            RIGHT = r103;
            ScrollDirection r104 = new ScrollDirection("BOTTOM", 4);
            BOTTOM = r104;
            ScrollDirection[] r105 = {r100, r101, r102, r103, r104};
            f359054a = r105;
            f359055b = EnumEntriesKt.enumEntries(r105);
            Companion = new a();
        }

        public static ScrollDirection[] values() {
            return (ScrollDirection[]) f359054a.clone();
        }

        public final boolean isPositive() {
            if (this != RIGHT) goto L5;
        L8:
            return true;
        L5:
            if (this == BOTTOM) goto L8;
            return false;
        }

        public static ScrollDirection valueOf(String r100) {
            return (ScrollDirection) r27.a.a(ScrollDirection.class, r100);
        }

        public ScrollDirection(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public interface b {
        void onComplete();
    }

    static {
    }

    public OScrollStateHelper() {
        this(null, 7);
    }

    public final void h() {
        Iterator r100 = ((ArrayList) this.f359050q).iterator();
    L4:
        if (r100.hasNext() == false) goto L8;
        if (g(((c) r100.next()).f519492a) == null) goto L4;
        r100.remove();
        goto L4
    L8:
        Iterator r101 = ((ArrayList) this.f359051r).iterator();
    L10:
        if (r101.hasNext() == false) goto L14;
        if (f(((nk9.b) r101.next()).f519488a) == null) goto L10;
        r101.remove();
        goto L10
    L14:
        this.f359043j.clear();
        this.f359035b.getLifecycle().removeObserver(this.f359048o);
        RecyclerView r102 = this.f359037d;
        if (r102 == null) goto L28;
        r102.removeOnChildAttachStateChangeListener(this);
        RecyclerView r103 = null;
        RecyclerView r104 = this.f359037d;     // Catch: IllegalStateException -> L30
        if (r104 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");     // Catch: IllegalStateException -> L30
        r104 = null;
    L20:
        r104.removeOnScrollListener(this.f359049p);     // Catch: IllegalStateException -> L30
    L34:
        RecyclerView r105 = this.f359037d;     // Catch: IllegalStateException -> L31
        if (r105 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");     // Catch: IllegalStateException -> L31
    L25:
        RecyclerView.Adapter r106 = r103.getAdapter();     // Catch: IllegalStateException -> L31
        if (r106 == null) goto L28;
        r106.unregisterAdapterDataObserver(this.f359047n);     // Catch: IllegalStateException -> L31
        goto L28
    L24:
        r103 = r105;
    L28:
        ((ArrayList) this.f359044k).clear();
        ((CopyOnWriteArrayList) this.f359045l).clear();
    }

    public final void a(RecyclerView r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        RecyclerView.Adapter r101 = r100.getAdapter();
        if (r101 != null) goto L7;
        return;
    L7:
        RecyclerView.LayoutManager r102 = r100.getLayoutManager();
        StaggeredGridLayoutManager r103 = null;
        if ((r102 instanceof LinearLayoutManager) == false) goto L10;
        LinearLayoutManager r104 = (LinearLayoutManager) r102;
    L11:
        if (r104 == null) goto L13;
        this.f359046m = r104.getOrientation();
    L13:
        RecyclerView.LayoutManager r105 = r100.getLayoutManager();
        if ((r105 instanceof StaggeredGridLayoutManager) == false) goto L16;
        r103 = (StaggeredGridLayoutManager) r105;
    L16:
        if (r103 == null) goto L18;
        this.f359046m = r103.getOrientation();
    L18:
        this.f359037d = r100;
        r100.addOnScrollListener(this.f359049p);
        r101.registerAdapterDataObserver(this.f359047n);
        r100.addOnChildAttachStateChangeListener(this);
        int r106 = 0;
    L20:
        if (r106 >= r100.getChildCount()) goto L22;
        boolean r107 = true;
    L23:
        if (r107 == false) goto L35;
        int r108 = r106 + 1;
        View r109 = r100.getChildAt(r106);
        if (r109.isAttachedToWindow() == false) goto L34;
        Object r110 = r100.getChildViewHolder(r109);
        if (r110 == null) goto L34;
        if ((r110 instanceof e) == false) goto L32;
        e r111 = (e) r110;
        Intrinsics.checkNotNullParameter(r111, "focusListener");
        ((ArrayList) this.f359050q).add(new c(r111, this.f359043j));
    L32:
        if ((r110 instanceof d) == false) goto L34;
        d r112 = (d) r110;
        Intrinsics.checkNotNullParameter(r112, "displayListener");
        ((ArrayList) this.f359051r).add(new nk9.b(r112));
    L34:
        r106 = r108;
        goto L20
    L35:
        this.f359035b.getLifecycle().addObserver(this.f359048o);
        b(CardContextState.TriggerReason.INIT);
        return;
    L22:
        r107 = false;
        goto L23
    L10:
        r104 = null;
        goto L11
    }

    public final void b(final CardContextState.TriggerReason r100) {
        Intrinsics.checkNotNullParameter(r100, "triggerReason");
        y.d(new j(this, r100), 200);
    }

    public final void c(CardContextState.TriggerReason r100) {
        Intrinsics.checkNotNullParameter(r100, "triggerReason");
        RecyclerView r101 = this.f359037d;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        r101 = null;
    L8:
        if (r101.isAttachedToWindow() == true) goto L16;
        return;
    L16:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L12
        e(r100);     // Catch: Throwable -> L12
        d(r100);     // Catch: Throwable -> L12
        Object r103 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L12
    L14:
        Result.m9452exceptionOrNullimpl(r103);
        return;
    L12:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L14
    }

    public final void d(CardContextState.TriggerReason r210) {
        SystemClock.elapsedRealtime();
        if (this.f359035b.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED) == true) goto L6;
        return;
    L6:
        if (((ArrayList) this.f359051r).isEmpty() == false) goto L8;
        return;
    L8:
        CollectionsKt.sortWith(this.f359051r, this.f359053t);
        List<nk9.b> r100 = this.f359051r;
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator r102 = ((ArrayList) r100).iterator();
    L10:
        if (r102.hasNext() == false) goto L12;
        r101.add(((nk9.b) r102.next()).S0());
        goto L10
    L12:
        r101.toString();
        com.larus.media.focus.b r103 = this.f359036c;
        RecyclerView r104 = this.f359037d;
        if (r104 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        r104 = null;
    L15:
        m r105 = new m(r104);
        List<nk9.b> r106 = this.f359051r;
        g r107 = this.f359042i;
        r103.getClass();
        Intrinsics.checkNotNullParameter(this, "manager");
        Intrinsics.checkNotNullParameter(r105, "focusParent");
        Intrinsics.checkNotNullParameter(r106, "focusableCards");
        Intrinsics.checkNotNullParameter(r210, "triggerReason");
        Intrinsics.checkNotNullParameter(r107, "cardActionCallback");
        Rect r108 = r105.a();
        Iterator r109 = ((ArrayList) r106).iterator();
    L17:
        if (r109.hasNext() == false) goto L63;
        nk9.b r110 = (nk9.b) r109.next();
        float r111 = r110.h3();
        float r112 = r110.C0();
        Rect r113 = r110.a();
        int[] r114 = n.f519505a;
        int r115 = this.f359046m;
        Intrinsics.checkNotNullParameter(r108, "parentRect");
        Intrinsics.checkNotNullParameter(r113, "childRect");
        if (r115 != 0) goto L21;
        float r116 = n.c(TuplesKt.to(Integer.valueOf(r113.left), Integer.valueOf(r113.right)), TuplesKt.to(Integer.valueOf(r108.left), Integer.valueOf(r108.right)));
    L22:
        r110.S0();
        if (r116 < r111) goto L34;
        Float r117 = r103.f359060a.get(r110.S0());
        if (r117 == null) goto L27;
        float r118 = r117.floatValue();
    L29:
        if (r118 >= r111) goto L34;
        if (r110.b() == true) goto L34;
        r110.c2(new CardContextState(this.f359039f, r210, this.f359046m, this.f359040g), r107);
        goto L34
    L27:
        r118 = -0.001f;
    L34:
        if (r116 > r112) goto L44;
        Float r119 = r103.f359060a.get(r110.S0());
        if (r119 == null) goto L38;
        float r120 = r119.floatValue();
    L40:
        if (r120 <= r112) goto L44;
        if (r110.b() == false) goto L44;
        r110.A0(new CardContextState(this.f359039f, r210, this.f359046m, this.f359040g));
        r103.f359060a.remove(r110.S0());
        goto L44
    L38:
        r120 = -0.001f;
    L44:
        Float r121 = r103.f359060a.get(r110.S0());
        if (r121 == null) goto L47;
        float r122 = r121.floatValue();
    L48:
        CardContextState r123 = new CardContextState(this.f359039f, r210, this.f359046m, this.f359040g);
        if (r210 != CardContextState.TriggerReason.LIFECYCLE) goto L52;
        r110.A3(r123, r116);
    L54:
        Iterator r124 = r109;
        g r125 = r107;
    L58:
        int r126 = this.f359046m;
        Intrinsics.checkNotNullParameter(r108, "parentRect");
        Intrinsics.checkNotNullParameter(r113, "childRect");
        if (r126 != 0) goto L61;
        Range<Float> r127 = n.d(TuplesKt.to(Integer.valueOf(r113.left), Integer.valueOf(r113.right)), TuplesKt.to(Integer.valueOf(r108.left), Integer.valueOf(r108.right)));
    L62:
        r110.q2(r123, r127);
        r103.f359060a.put(r110.S0(), Float.valueOf(r116));
        r107 = r125;
        r109 = r124;
        goto L17
    L61:
        r127 = n.d(TuplesKt.to(Integer.valueOf(r113.top), Integer.valueOf(r113.bottom)), TuplesKt.to(Integer.valueOf(r108.top), Integer.valueOf(r108.bottom)));
        goto L62
    L52:
        if (r116 <= (0.001f + r122)) goto L55;
        r110.A3(r123, r116);
        goto L54
    L55:
        r124 = r109;
        r125 = r107;
        if (r116 >= (((double) r122) - 0.001d)) goto L58;
        r110.F3(r123, r116);
        goto L58
    L47:
        r122 = 0.0f;
        goto L48
    L21:
        r116 = n.c(TuplesKt.to(Integer.valueOf(r113.top), Integer.valueOf(r113.bottom)), TuplesKt.to(Integer.valueOf(r108.top), Integer.valueOf(r108.bottom)));
        goto L22
    L63:
        Iterator r128 = ((CopyOnWriteArrayList) this.f359045l).iterator();
    L65:
        if (r128.hasNext() == false) goto L67;
        ((b) r128.next()).onComplete();
        goto L65
    L67:
        Unit r129 = Unit.INSTANCE;
        SystemClock.elapsedRealtime();
    }

    public final void e(CardContextState.TriggerReason r100) {
        SystemClock.elapsedRealtime();
        if (this.f359035b.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED) == true) goto L5;
        return;
    L5:
        List<c> r101 = this.f359050q;
        ArrayList r102 = new ArrayList();
        Iterator r103 = ((ArrayList) r101).iterator();
    L7:
        if (r103.hasNext() == false) goto L11;
        Object r104 = r103.next();
        if (((c) r104).g() == false) goto L7;
        r102.add(r104);
        goto L7
    L11:
        List r105 = CollectionsKt.toMutableList(r102);
        if (r105.isEmpty() == true) goto L14;
    L16:
        CollectionsKt.sortWith(r105, this.f359052s);
        CardContextState r106 = new CardContextState(this.f359039f, r100, this.f359046m, this.f359040g);
        f r107 = this.f359034a;
        RecyclerView r108 = this.f359037d;
        c r109 = null;
        if (r108 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        r108 = null;
    L19:
        c r110 = r107.a(this, new m(r108), r105, r106);
        Iterator r111 = ((ArrayList) this.f359050q).iterator();
    L21:
        if (r111.hasNext() == false) goto L31;
        c r112 = (c) r111.next();
        if (Intrinsics.areEqual(r112, r110) == true) goto L21;
        if (r112.k() == true) goto L28;
        r112 = null;
    L28:
        if (r112 == null) goto L21;
        r112.d(r106);
        goto L21
    L31:
        if (this.f359039f != 0) goto L38;
        if (r110 == null) goto L38;
        if ((!r110.k()) == false) goto L36;
        r109 = r110;
    L36:
        if (r109 == null) goto L38;
        r109.a(r106, this.f359042i);
    L38:
        Unit r113 = Unit.INSTANCE;
        SystemClock.elapsedRealtime();
        return;
    L14:
        if (((ArrayList) this.f359050q).isEmpty() == false) goto L16;
    }

    public final nk9.b f(d r100) {
        Iterator r101 = ((ArrayList) this.f359051r).iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Object r102 = r101.next();
        if (Intrinsics.areEqual(((nk9.b) r102).f519488a, r100) == false) goto L4;
    L9:
        nk9.b r103 = (nk9.b) r102;
        if (r103 != null) goto L12;
        return null;
    L12:
        if (r103.b() == false) goto L14;
        CardContextState r104 = new CardContextState(this.f359039f, CardContextState.TriggerReason.DETACH, this.f359046m, this.f359040g);
        r103.A0(r104);
        r103.F3(r104, 0.0f);
        r103.q2(r104, new Range(Float.valueOf(0.0f), Float.valueOf(0.0f)));
        com.larus.media.focus.b r105 = this.f359036c;
        String r106 = r103.S0();
        r105.getClass();
        Intrinsics.checkNotNullParameter(r106, "displayItemKey");
        r105.f359060a.remove(r106);
    L14:
        return r103;
    L8:
        r102 = null;
        goto L9
    }

    public final c g(e r100) {
        Iterator r101 = ((ArrayList) this.f359050q).iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Object r102 = r101.next();
        if (Intrinsics.areEqual(((c) r102).f519492a, r100) == false) goto L4;
    L9:
        c r103 = (c) r102;
        if (r103 != null) goto L12;
        return null;
    L12:
        if (r103.k() == false) goto L14;
        r103.d(new CardContextState(this.f359039f, CardContextState.TriggerReason.DETACH, this.f359046m, this.f359040g));
    L14:
        return r103;
    L8:
        r102 = null;
        goto L9
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
    public final void onChildViewAttachedToWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        RecyclerView r101 = this.f359037d;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        r101 = null;
    L5:
        Object r102 = r101.getChildViewHolder(r100);
        if ((r102 instanceof e) == false) goto L9;
        e r103 = (e) r102;
        Intrinsics.checkNotNullParameter(r103, "focusListener");
        List<c> r104 = this.f359050q;
        ArrayList r105 = (ArrayList) r104;
        r105.add(new c(r103, this.f359043j));
    L9:
        if ((r102 instanceof d) == false) goto L12;
        d r106 = (d) r102;
        Intrinsics.checkNotNullParameter(r106, "displayListener");
        List<nk9.b> r107 = this.f359051r;
        ArrayList r108 = (ArrayList) r107;
        r108.add(new nk9.b(r106));
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
    public final void onChildViewDetachedFromWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        RecyclerView r101 = this.f359037d;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        r101 = null;
    L5:
        Object r102 = r101.getChildViewHolder(r100);
        if ((r102 instanceof e) == false) goto L11;
        e r103 = (e) r102;
        Intrinsics.checkNotNullParameter(r103, "focusListener");
        c r104 = g(r103);
        if (r104 == null) goto L11;
        TypeIntrinsics.asMutableCollection(this.f359050q).remove(r104);
    L11:
        if ((r102 instanceof d) == false) goto L16;
        d r105 = (d) r102;
        Intrinsics.checkNotNullParameter(r105, "displayListener");
        nk9.b r106 = f(r105);
        if (r106 == null) goto L17;
        TypeIntrinsics.asMutableCollection(this.f359051r).remove(r106);
        return;
    L17:
        return;
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [com.larus.media.focus.OScrollStateHelper$mDataObserver$1] */
    /* JADX WARN: Type inference failed for: r3v3, types: [com.larus.media.focus.OScrollStateHelper$mLifecycleObserver$1] */
    /* JADX WARN: Type inference failed for: r3v4, types: [com.larus.media.focus.OScrollStateHelper$mOnScrollListener$1] */
    public OScrollStateHelper(Integer r100, int r101) {
        AlwaysResumeLifecycleOwner r102 = null;
        if ((r101 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r101 & 2) == 0) goto L8;
        nk9.a r103 = new nk9.a();
    L10:
        if ((r101 & 4) == 0) goto L12;
        r102 = new AlwaysResumeLifecycleOwner();
    L12:
        Intrinsics.checkNotNullParameter(r103, "focusStrategy");
        Intrinsics.checkNotNullParameter(r102, "parentLifecycleOwner");
        this.f359034a = r103;
        this.f359035b = r102;
        this.f359036c = new com.larus.media.focus.b();
        this.f359038e = LazyKt.lazy(new nk9.g(this));
        this.f359040g = ScrollDirection.NONE;
        this.f359041h = true;
        this.f359042i = new g();
        this.f359043j = new com.larus.media.focus.a(new LinkedHashMap());
        this.f359044k = new ArrayList();
        this.f359045l = new CopyOnWriteArrayList();
        this.f359046m = 1;
        if (r100 == null) goto L15;
        this.f359046m = r100.intValue();
    L15:
        this.f359047n = new OScrollStateHelper$mDataObserver$1(this);
        this.f359048o = new OScrollStateHelper$mLifecycleObserver$1(this);
        this.f359049p = new OScrollStateHelper$mOnScrollListener$1(this);
        this.f359050q = new ArrayList();
        this.f359051r = new ArrayList();
        this.f359052s = new l(this.f359046m, new h());
        this.f359053t = new l(this.f359046m, new i());
        return;
    L8:
        r103 = null;
        goto L10
    }
}
