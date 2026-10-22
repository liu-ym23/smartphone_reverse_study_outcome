package com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.user.UserAttr;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.commonui.KtvCommonEmptyView;
import com.bytedance.android.live.ktv.common.karaokestation.ItemExposureCheckHelper;
import com.bytedance.android.live.ktv.common.karaokestation.model.w;
import com.bytedance.android.live.ktv.common.music.control.KtvMusicControlManager;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.model.interact.x;
import com.bytedance.android.livesdk.chatroom.ui.SSLinearLayoutManager;
import com.bytedance.android.livesdk.config.a50;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.controlnode.CutMusicControlNode;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvcomponent.KtvComponentOrderSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.OrderedSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.util.SelectedMusicListDiffCallBack;
import com.bytedance.android.livesdk.ktvimpl.base.viewmodel.BaseCoreViewModel;
import com.bytedance.android.livesdk.ktvimpl.chorus.ChorusContext;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.KtvComponentContext;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.view.dialog.selected.KtvRoomBottomFillViewBinder;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.view.dialog.selected.KtvRoomSelectedMusicTipsViewBinder;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.view.dialog.selected.KtvRoomSelectedMusicViewHolder;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdk.ktvimpl.multichorus.MultiChorusContext;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.video.VideoChorusDataContext;
import com.bytedance.android.livesdk.message.model.InteractiveSongUserInfo;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.message.model.OrderInfo;
import com.bytedance.android.livesdk.utils.LifecycleOwnerCompat;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.model.ModeType;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001=J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016R\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0015\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001f\u001a\u0004\u0018\u00010\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\r\u001a\u0004\b\u001d\u0010\u001eR\u001d\u0010$\u001a\u0004\u0018\u00010 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\r\u001a\u0004\b\"\u0010#R\u001d\u0010)\u001a\u0004\u0018\u00010%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\r\u001a\u0004\b'\u0010(R\u001b\u0010.\u001a\u00020*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\r\u001a\u0004\b,\u0010-R\u001b\u00103\u001a\u00020/8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u0010\r\u001a\u0004\b1\u00102R\u001b\u00108\u001a\u0002048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b5\u0010\r\u001a\u0004\b6\u00107R\u0016\u0010<\u001a\u0004\u0018\u0001098BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b:\u0010;¨\u0006>"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/karaokestation/ktvmode/view/secondleveltab/PlayListContainerView;", "Landroid/widget/FrameLayout;", "Lwb0/a;", "Lcom/bytedance/android/livesdk/ktvimpl/base/karaokestation/ktvmode/view/secondleveltab/d;", "Lcom/bytedance/android/livesdk/utils/LifecycleOwnerCompat;", "", "getWaitingRankState", "", "getOnlineLinkMicCount", "Landroidx/lifecycle/Lifecycle;", "getLifecycleCompat", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "e", "Lkotlin/Lazy;", "getDataCenter", "()Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lme/drakeet/multitype/MultiTypeAdapter;", "f", "getAdapter", "()Lme/drakeet/multitype/MultiTypeAdapter;", "adapter", "Landroidx/constraintlayout/widget/ConstraintLayout;", "g", "getSelectedListContainer", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "selectedListContainer", "Landroidx/recyclerview/widget/RecyclerView;", "h", "getSelectedListRv", "()Landroidx/recyclerview/widget/RecyclerView;", "selectedListRv", "Lcom/bytedance/android/livesdk/ktvimpl/base/karaokestation/ktvmode/view/secondleveltab/FloatingBottomView;", "i", "getSelfMusicFloatBottomView", "()Lcom/bytedance/android/livesdk/ktvimpl/base/karaokestation/ktvmode/view/secondleveltab/FloatingBottomView;", "selfMusicFloatBottomView", "Lcom/bytedance/android/live/ktv/common/commonui/KtvCommonEmptyView;", "j", "getEmptyView", "()Lcom/bytedance/android/live/ktv/common/commonui/KtvCommonEmptyView;", "emptyView", "Lio/reactivex/disposables/CompositeDisposable;", "k", "getCompositeDisposable", "()Lio/reactivex/disposables/CompositeDisposable;", "compositeDisposable", "Lcom/bytedance/android/live/ktv/common/karaokestation/ItemExposureCheckHelper;", "n", "getItemExposureCheckHelper", "()Lcom/bytedance/android/live/ktv/common/karaokestation/ItemExposureCheckHelper;", "itemExposureCheckHelper", "Lcom/bytedance/android/livesdk/ktvimpl/base/karaokestation/ktvmode/view/secondleveltab/i;", "o", "getItemExposureListener", "()Lcom/bytedance/android/livesdk/ktvimpl/base/karaokestation/ktvmode/view/secondleveltab/i;", "itemExposureListener", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/view/dialog/selected/KtvRoomSelectedMusicViewHolder;", "getSingingMusicItem", "()Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/view/dialog/selected/KtvRoomSelectedMusicViewHolder;", "singingMusicItem", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PlayListContainerView extends FrameLayout implements wb0.a, com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab.d, LifecycleOwnerCompat {
    public static final /* synthetic */ int r = 0;
    public final List<Object> a;
    public final LifecycleRegistry b;
    public final w c;
    public boolean d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public final com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab.h l;
    public final Map<Long, Boolean> m;
    public final Lazy n;
    public final Lazy o;
    public final com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b p;
    public final com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d q;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ PlayListContainerView a;

        public b(PlayListContainerView r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            com.bytedance.android.live.network.response.e r3 = (com.bytedance.android.live.network.response.e) r2;
            Intrinsics.checkNotNullParameter(r3, "response");
            PlayListContainerView.j(this.a, (x) ((ExtraResponse) r3).data);
        }
    }

    public static final class c<T> implements Consumer {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            Intrinsics.checkNotNullParameter(r4, "e");
            ALogger.e("PlayListContainerView", "LinkAudienceApi#getUserWaitingRankPosition()失败", r4);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ PlayListContainerView a;
        public final /* synthetic */ ArrayList b;

        public d(PlayListContainerView r1, ArrayList r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            DiffUtil.DiffResult r4 = (DiffUtil.DiffResult) r3;
            Intrinsics.checkNotNullParameter(r4, "diffResult");
            ((ArrayList) this.a.a).clear();     // Catch: Exception -> L5
            List<Object> r0 = this.a.a;     // Catch: Exception -> L5
            ArrayList r1 = (ArrayList) r0;     // Catch: Exception -> L5
            r1.addAll(this.b);     // Catch: Exception -> L5
            r4.dispatchUpdatesTo(PlayListContainerView.g(this.a));     // Catch: Exception -> L5
            return;
        }
    }

    public static final class e<T> implements Consumer {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final void accept(Object r2) {
            Intrinsics.checkNotNullParameter((Throwable) r2, "error");
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ PlayListContainerView a;

        public f(PlayListContainerView r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            PlayListContainerView r0 = this.a;
            int r1 = PlayListContainerView.r;
            r0.getClass();
            r0.m(PlayListContainerView.k((List) r3), 1);
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ PlayListContainerView a;

        public g(PlayListContainerView r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Boolean r4 = (Boolean) r3;
            PlayListContainerView r5 = this.a;
            com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r0 = r5.q;
            if (r0 == null) goto L7;
            OrderedSongDataContext r1 = r0.getOrderedSongDataContext();
            if (r1 == null) goto L7;
            List<MusicPanel> r2 = r1.m199getKtvOrderedSongList();
        L8:
            r5.m(PlayListContainerView.k(r2), 1);
            return;
        L7:
            r2 = null;
            goto L8
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ PlayListContainerView a;

        public h(PlayListContainerView r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            PlayListContainerView r0 = this.a;
            long r1 = ((Long) r4).longValue();
            com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r5 = r0.q;
            if (r5 == null) goto L6;
            r5.moveOrderedSongToOtherRoom(r1);
            return;
        }
    }

    public static final class i<T> implements Observer {
        public final /* synthetic */ PlayListContainerView a;

        public i(PlayListContainerView r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            PlayListContainerView r0 = this.a;
            int r1 = PlayListContainerView.r;
            r0.o((jd2.c) r3);
        }
    }

    public static final class j<T> implements Consumer {
        public final /* synthetic */ PlayListContainerView a;

        public j(PlayListContainerView r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            sh6.b r4 = (sh6.b) r3;
            if (ChorusContext.Companion.c() == false) goto L8;
            List r5 = (List) sh6.c.b(r4);
            if (r5 == null) goto L9;
            PlayListContainerView r0 = this.a;
            int r1 = PlayListContainerView.r;
            r0.getClass();
            r0.m(PlayListContainerView.k(r5), 2);
            return;
        L9:
            return;
        }
    }

    public static final class k<T> implements Observer {
        public final /* synthetic */ PlayListContainerView a;

        public k(PlayListContainerView r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            jd2.a r4 = (jd2.a) r3;
            KtvRoomSelectedMusicViewHolder r5 = PlayListContainerView.h(this.a);
            if (r5 == null) goto L8;
            MusicPanel r0 = r5.E;
            if (r0 == null) goto L9;
            r5.U3(r0, 0);
            return;
        L9:
            return;
        }
    }

    public static final class l<T> implements Consumer {
        public final /* synthetic */ PlayListContainerView a;

        public l(PlayListContainerView r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            UserAttr r4 = (UserAttr) r3;
            ChorusContext.a r5 = ChorusContext.Companion;
            List<MusicPanel> r1 = null;
            if (r5.c() == false) goto L10;
            PlayListContainerView r0 = this.a;
            ChorusContext r6 = r5.getContext();
            if (r6 == null) goto L9;
            com.bytedance.live.datacontext.n<List<MusicPanel>> r7 = r6.getChorusSelectedSongList();
            if (r7 == null) goto L9;
            r1 = (List) r7.getValue();
        L9:
            int r8 = PlayListContainerView.r;
            r0.getClass();
            r0.m(PlayListContainerView.k(r1), 2);
            return;
        L10:
            PlayListContainerView r9 = this.a;
            com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r2 = r9.q;
            if (r2 == null) goto L15;
            OrderedSongDataContext r10 = r2.getOrderedSongDataContext();
            if (r10 == null) goto L15;
            r1 = r10.m199getKtvOrderedSongList();
        L15:
            r9.m(PlayListContainerView.k(r1), 1);
        }
    }

    public static final class m<T> implements Consumer {
        public final /* synthetic */ PlayListContainerView a;

        public m(PlayListContainerView r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            sh6.b r3 = (sh6.b) r2;
            PlayListContainerView r4 = this.a;
            int r0 = PlayListContainerView.r;
            r4.l();
        }
    }

    public static final class n implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ PlayListContainerView a;
        public final /* synthetic */ long b;

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            ViewTreeObserver r0 = this.a.getViewTreeObserver();
            if (r0 == null) goto L5;
            r0.removeOnGlobalLayoutListener(this);
        L5:
            mb0.c.a.c(pd2.d.n, "ordered_music", System.currentTimeMillis() - this.b);
        }

        public n(PlayListContainerView r1, long r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    private final MultiTypeAdapter getAdapter() {
        return (MultiTypeAdapter) this.f.getValue();
    }

    private final CompositeDisposable getCompositeDisposable() {
        return (CompositeDisposable) this.k.getValue();
    }

    private final DataCenter getDataCenter() {
        return (DataCenter) this.e.getValue();
    }

    private final KtvCommonEmptyView getEmptyView() {
        return (KtvCommonEmptyView) this.j.getValue();
    }

    private final ItemExposureCheckHelper getItemExposureCheckHelper() {
        return (ItemExposureCheckHelper) this.n.getValue();
    }

    private final com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab.i getItemExposureListener() {
        return (com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab.i) this.o.getValue();
    }

    private final ConstraintLayout getSelectedListContainer() {
        return (ConstraintLayout) this.g.getValue();
    }

    private final RecyclerView getSelectedListRv() {
        return (RecyclerView) this.h.getValue();
    }

    private final FloatingBottomView getSelfMusicFloatBottomView() {
        return (FloatingBottomView) this.i.getValue();
    }

    public /* bridge */ /* synthetic */ Lifecycle getLifecycle() {
        return LifecycleOwnerCompat.-CC.$default$getLifecycle(this);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab.d
    public final void O0() {
        ((LinkedHashMap) this.m).clear();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab.d
    public final void a() {
        this.c.a = false;
    }

    public final void l() {
        KtvComponentContext r0 = KtvComponentContext.Companion.getContext();
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.n<Boolean> r1 = r0.isAudienceEnableSing();
        if (r1 == null) goto L9;
        Boolean r2 = (Boolean) r1.getValue();
        if (r2 == null) goto L9;
        boolean r3 = r2.booleanValue();
    L10:
        KtvContext.Companion.getClass();
        if (KtvContext.a.k() == false) goto L13;
        return;
    L13:
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L15;
        return;
    L15:
        if (r3 == false) goto L22;
        KtvCommonEmptyView r4 = getEmptyView();
        if (r4 == null) goto L19;
        r4.a(s1.B(2131918556), s1.B(2131918557));
    L19:
        KtvCommonEmptyView r5 = getEmptyView();
        if (r5 == null) goto L31;
        r5.c(0);
        return;
    L31:
        return;
    L22:
        KtvCommonEmptyView r6 = getEmptyView();
        if (r6 == null) goto L25;
        r6.a(s1.B(2131918556), "");
    L25:
        KtvCommonEmptyView r7 = getEmptyView();
        if (r7 == null) goto L33;
        r7.c(8);
        return;
    L33:
        return;
    L9:
        r3 = false;
        goto L10
    }

    public final void p() {
        this.b.setCurrentState(Lifecycle.State.CREATED);
        LayoutInflater.from(getContext()).inflate(2131566506, this, true);
        KtvCommonEmptyView r0 = getEmptyView();
        if (r0 == null) goto L5;
        r0.c(0);
    L5:
        KtvCommonEmptyView r1 = getEmptyView();
        if (r1 == null) goto L8;
        r1.setGoSelectMusicAction(new PlayListContainerView$initView$1(this));
    L8:
        RecyclerView r2 = getSelectedListRv();
        if (r2 == null) goto L11;
        r2.setLayoutManager(new SSLinearLayoutManager(getContext(), 1));
    L11:
        MultiTypeAdapter r3 = getAdapter();
        r3.z2(com.bytedance.android.livesdk.ktvimpl.ktvroom.view.dialog.selected.d.class, new com.bytedance.android.livesdk.ktvimpl.ktvroom.view.dialog.selected.c(this));
        KtvContext.Companion.getClass();
        if (KtvContext.a.k() == false) goto L14;
        r3.z2(com.bytedance.android.livesdk.ktvimpl.ktvroom.view.dialog.selected.b.a.class, new com.bytedance.android.livesdk.ktvimpl.ktvroom.view.dialog.selected.b(this));
        r3.z2(KtvRoomSelectedMusicTipsViewBinder.a.class, new KtvRoomSelectedMusicTipsViewBinder());
        r3.z2(KtvRoomBottomFillViewBinder.a.class, new KtvRoomBottomFillViewBinder());
    L14:
        RecyclerView r4 = getSelectedListRv();
        if (r4 == null) goto L17;
        r4.setAdapter(getAdapter());
    L17:
        RecyclerView r5 = getSelectedListRv();
        if (r5 == null) goto L20;
        r5.setNestedScrollingEnabled(true);
    L20:
        List<MusicPanel> r6 = null;
        if (jc0.a.c() == false) goto L29;
        VideoChorusDataContext.a r7 = VideoChorusDataContext.Companion;
        com.bytedance.android.livesdk.ktvimpl.crossplatform.player.c r8 = r7.a();
        if (r8 == null) goto L25;
        jd2.c r9 = r8.f();
    L26:
        o(r9);
        com.bytedance.android.livesdk.ktvimpl.crossplatform.player.c r10 = r7.a();
        if (r10 == null) goto L29;
        r10.l(this, new i(this));
        goto L29
    L25:
        r9 = null;
    L29:
        KtvContext r11 = KtvContext.a.g();
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c> r12 = r11.getKtvCoreViewModel();
        if (r12 == null) goto L36;
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r13 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c) r12.getValue();
        if (r13 == null) goto L36;
        if ((r13 instanceof BaseCoreViewModel) == false) goto L36;
        r13.registerKtvCoreListener(CollectionsKt.arrayListOf(new String[]{BaseCoreViewModel.CORE_TAG_STATE}), this.l, false);
    L36:
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r14 = this.q;
        if (r14 == null) goto L43;
        OrderedSongDataContext r15 = r14.getOrderedSongDataContext();
        if (r15 == null) goto L43;
        Disposable r16 = r15.observerKtvOrderedSongListChange(null, false, new f(this));
        if (r16 == null) goto L43;
        RxUtilKt.c(r16, getCompositeDisposable());
    L43:
        MultiChorusContext.a r17 = MultiChorusContext.Companion;
        Disposable r18 = r17.g(new g(this));
        if (r18 == null) goto L46;
        RxUtilKt.c(r18, getCompositeDisposable());
    L46:
        RxUtilKt.c(r11.getMoveSongToOtherRoomEvent().onEvent().subscribe(new h(this)), getCompositeDisposable());
        ChorusContext.a r19 = ChorusContext.Companion;
        ChorusContext r20 = r19.getContext();
        if (r20 == null) goto L55;
        com.bytedance.live.datacontext.n<List<MusicPanel>> r21 = r20.getChorusSelectedSongList();
        if (r21 == null) goto L55;
        Observable r22 = r21.a();
        if (r22 == null) goto L55;
        Disposable r23 = r22.subscribe(new j(this));
        if (r23 == null) goto L55;
        RxUtilKt.c(r23, getCompositeDisposable());
    L55:
        com.bytedance.android.livesdk.ktvimpl.crossplatform.player.c r24 = VideoChorusDataContext.Companion.a();
        if (r24 == null) goto L58;
        r24.r(this, new k(this));
    L58:
        r17.i(this, new PlayListContainerView$initView$7(this));
        if (r19.c() == false) goto L66;
        ChorusContext r25 = r19.getContext();
        if (r25 == null) goto L65;
        com.bytedance.live.datacontext.n<List<MusicPanel>> r26 = r25.getChorusSelectedSongList();
        if (r26 == null) goto L65;
        r6 = (List) r26.getValue();
    L65:
        m(k(r6), 2);
    L72:
        IMiddlewareUserService r27 = jc1.k.f(IMiddlewareUserService.class);
        if (r27 == null) goto L81;
        com.bytedance.android.livesdk.user.e r28 = r27.user();
        if (r28 == null) goto L81;
        Observable r29 = r28.u();
        if (r29 == null) goto L81;
        Disposable r30 = r29.subscribe(new l(this));
        if (r30 == null) goto L81;
        RxUtilKt.c(r30, getCompositeDisposable());
    L81:
        getItemExposureCheckHelper().b(getSelectedListRv(), getItemExposureListener());
        l();
        KtvComponentContext r31 = KtvComponentContext.Companion.getContext();
        if (r31 == null) goto L91;
        com.bytedance.live.datacontext.n<Boolean> r32 = r31.isAudienceEnableSing();
        if (r32 == null) goto L91;
        Observable r33 = r32.a();
        if (r33 == null) goto L91;
        Disposable r34 = r33.subscribe(new m(this));
        if (r34 == null) goto L91;
        RxUtilKt.c(r34, getCompositeDisposable());
    L91:
        if (KtvUtilsKt.v() == false) goto L96;
        KtvCommonEmptyView r35 = getEmptyView();
        if (r35 == null) goto L97;
        r35.a(s1.B(2131918556), s1.B(2131918339));
        return;
    L97:
        return;
    L96:
        return;
    L66:
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r36 = this.q;
        if (r36 == null) goto L71;
        OrderedSongDataContext r37 = r36.getOrderedSongDataContext();
        if (r37 == null) goto L71;
        r6 = r37.m199getKtvOrderedSongList();
    L71:
        m(k(r6), 1);
        goto L72
    }

    private final KtvRoomSelectedMusicViewHolder getSingingMusicItem() {
        int r0 = getAdapter().getItemCount();
        int r1 = 0;
    L3:
        RecyclerView.ViewHolder r2 = null;
        if (r1 >= r0) goto L13;
        RecyclerView r3 = getSelectedListRv();
        if (r3 == null) goto L9;
        r2 = r3.findViewHolderForAdapterPosition(r1);
    L9:
        if ((r2 instanceof KtvRoomSelectedMusicViewHolder) == true) goto L11;
        r1 = r1 + 1;
        goto L3
    L11:
        return (KtvRoomSelectedMusicViewHolder) r2;
    L13:
        return null;
    }

    private final void getWaitingRankState() {
        DataCenter r0 = getDataCenter();
        if (r0 == null) goto L8;
        IRoom r1 = a0.m(r0).a;
        if (r1 == null) goto L9;
        long r4 = r1.getId();
        Disposable r2 = jc1.k.n(IInteractService.class).getUserWaitingRankPosition(r4, r4, 9).compose(RxUtil.rxSchedulerHelper()).subscribe(new b(this), c.a);
        getCompositeDisposable().add(r2);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab.d
    public final void f() {
        getItemExposureCheckHelper().a(false);
        long r0 = System.currentTimeMillis();
        if (this.d == false) goto L11;
        DataCenter r2 = getDataCenter();
        if (r2 == null) goto L9;
        if (a0.m(r2).c == true) goto L11;
    L9:
        if (((Boolean) a50.a.getValue()).booleanValue() == false) goto L11;
        getWaitingRankState();
    L11:
        ViewTreeObserver r3 = getViewTreeObserver();
        if (r3 == null) goto L15;
        r3.addOnGlobalLayoutListener(new n(this, r0));
        return;
    }

    public int getOnlineLinkMicCount() {
        DataCenter r0 = getDataCenter();
        if (r0 == null) goto L7;
        List r1 = (List) r0.get("data_online_changed_list", new ArrayList());
        if (r1 == null) goto L7;
        return r1.size();
    L7:
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.b.setCurrentState(Lifecycle.State.STARTED);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getCompositeDisposable().clear();
        KtvContext.Companion.getClass();
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r0 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c) KtvContext.a.g().getKtvCoreViewModel().getValue();
        if (r0 == null) goto L5;
        r0.unregisterKtvCoreListener(this.l);
    L5:
        this.b.setCurrentState(Lifecycle.State.DESTROYED);
    }

    public Lifecycle getLifecycleCompat() {
        return this.b;
    }

    public static final /* synthetic */ MultiTypeAdapter g(PlayListContainerView r0) {
        return r0.getAdapter();
    }

    public static final /* synthetic */ KtvRoomSelectedMusicViewHolder h(PlayListContainerView r0) {
        return r0.getSingingMusicItem();
    }

    public static List k(List r4) {
        ArrayList r0 = new ArrayList();
        if (r4 == null) goto L14;
        KtvContext.Companion.getClass();
        if (KtvContext.a.k() == false) goto L7;
        r0.addAll(r4);
        goto L14
    L7:
        ArrayList r1 = new ArrayList();
        Iterator r5 = r4.iterator();
    L9:
        if (r5.hasNext() == false) goto L13;
        Object r2 = r5.next();
        if ((!((MusicPanel) r2).e) == false) goto L9;
        r1.add(r2);
        goto L9
    L13:
        r0.addAll(r1);
    L14:
        return r0;
    }

    public final void b(MusicPanel r5) {
        Intrinsics.checkNotNullParameter(r5, "musicPanel");
        Lazy r0 = KtvMusicControlManager.d;
        KtvMusicControlManager r1 = KtvMusicControlManager.a.a();
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r2 = this.q;
        if (r2 == null) goto L6;
        ModeType r3 = r2.getModeType();
        if (r3 == null) goto L6;
    L7:
        r1.d(new CutMusicControlNode(r5, false, r3), null);
        return;
    L6:
        r3 = ModeType.KTV_MODE;
        goto L7
    }

    public final void e(MusicPanel r2) {
        Intrinsics.checkNotNullParameter(r2, "musicPanel");
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r0 = this.q;
        if (r0 == null) goto L6;
        r0.pinMusic(r2);
        return;
    }

    public final void jumpToChorusRoom(MusicPanel r2) {
        Intrinsics.checkNotNullParameter(r2, "music");
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r0 = this.q;
        if (r0 == null) goto L6;
        r0.jumpToChorusRoom(r2);
        return;
    }

    public final void o(jd2.c r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (r2.a != 3) goto L9;
        KtvRoomSelectedMusicViewHolder r3 = getSingingMusicItem();
        if (r3 == null) goto L13;
        r3.g4(true);
        return;
    L13:
        return;
    L9:
        KtvRoomSelectedMusicViewHolder r4 = getSingingMusicItem();
        if (r4 == null) goto L15;
        r4.g4(false);
        return;
    }

    public static final void i(PlayListContainerView r10, com.bytedance.android.livesdk.ktvapi.util.e r11) {
        r10.getClass();
        MusicPanel r0 = r11.a;
        if (r0 == null) goto L36;
        KtvMusic r1 = r0.a;
        if (r1 == null) goto L41;
        long r2 = r1.getMId();
        MusicPanel r3 = r11.a;
        if (r3 == null) goto L10;
        String r4 = r3.g();
        if (r4 == null) goto L10;
    L11:
        int r5 = r10.getAdapter().getItemCount();
        int r6 = 0;
    L12:
        if (r6 >= r5) goto L42;
        RecyclerView r7 = r10.getSelectedListRv();
        if (r7 == null) goto L16;
        RecyclerView.ViewHolder r8 = r7.findViewHolderForAdapterPosition(r6);
    L18:
        if ((r8 instanceof KtvRoomSelectedMusicViewHolder) == false) goto L35;
        KtvRoomSelectedMusicViewHolder r9 = (KtvRoomSelectedMusicViewHolder) r8;
        r9.getClass();
        Intrinsics.checkNotNullParameter(r4, "orderId");
        MusicPanel r12 = r9.E;
        if (r12 == null) goto L32;
        KtvMusic r13 = r12.a;
        if (r13 == null) goto L32;
        if (r13.getMId() != r2) goto L32;
        MusicPanel r14 = r9.E;
        if (r14 == null) goto L32;
        KtvMusic r15 = r14.a;
        if (r15 == null) goto L32;
        boolean r16 = true;
        if (r15.isOrderedBy(r4) != true) goto L32;
    L33:
        if (r16 == false) goto L35;
        r9.f4(r11.b);
    L32:
        r16 = false;
    L35:
        r6 = r6 + 1;
        goto L12
    L16:
        r8 = null;
        goto L18
    L42:
        return;
    L10:
        r4 = "";
        goto L11
    L41:
        return;
    }

    public static final void j(PlayListContainerView r2, x r3) {
        FloatingBottomView r4 = r2.getSelfMusicFloatBottomView();
        if (r4 == null) goto L6;
        r4.f((int) r3.getTotalCount());
        return;
    }

    public final void c(MusicPanel r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "musicPanel");
        if (jc0.a.c() == false) goto L8;
        KtvComponentOrderSongDataContext.Companion.getClass();
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r4 = KtvComponentOrderSongDataContext.Companion.a();
        if (r4 == null) goto L12;
        r4.togglePause(r3);
        return;
    L12:
        return;
    L8:
        KtvContext.Companion.getClass();
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d r5 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.d) KtvContext.a.g().getKtvSingerViewModel().getValue();
        if (r5 == null) goto L13;
        r5.togglePause(r3);
        return;
    }

    public final void m(List<MusicPanel> r20, int r21) {
        if (r21 != 1) goto L8;
        if (ChorusContext.Companion.c() == false) goto L8;
        return;
    L8:
        if (r21 != 2) goto L13;
        if (ChorusContext.Companion.c() == true) goto L13;
        return;
    L13:
        if (r20.isEmpty() == false) goto L15;
        boolean r2 = true;
    L16:
        if (r2 == false) goto L24;
        KtvCommonEmptyView r1 = getEmptyView();
        if (r1 == null) goto L20;
        UtilityKotlinExtentionsKt.w(r1);
    L20:
        ConstraintLayout r3 = getSelectedListContainer();
        if (r3 == null) goto L23;
        r3.setVisibility(8);
    L23:
        ((ArrayList) this.a).clear();
        getAdapter().notifyDataSetChanged();
        return;
    L24:
        KtvCommonEmptyView r4 = getEmptyView();
        if (r4 == null) goto L27;
        UtilityKotlinExtentionsKt.t(r4);
    L27:
        ConstraintLayout r5 = getSelectedListContainer();
        if (r5 == null) goto L30;
        r5.setVisibility(0);
    L30:
        ArrayList r6 = new ArrayList();
        ArrayList r7 = new ArrayList();
        boolean r13 = KtvUtilsKt.j();
        com.bytedance.android.livesdk.ktvimpl.base.util.j.l.getClass();
        boolean r14 = com.bytedance.android.livesdk.ktvimpl.base.util.j.a();
        ArrayList r15 = (ArrayList) r20;
        Iterator r16 = r15.iterator();
    L32:
        if (r16.hasNext() == false) goto L38;
        MusicPanel r12 = (MusicPanel) r16.next();
        if (r12.e == false) goto L36;
        r7.add(r12);
        goto L32
    L36:
        MultiChorusContext.a r8 = MultiChorusContext.Companion;
        r12.h = r8.c();
        r6.add(new com.bytedance.android.livesdk.ktvimpl.ktvroom.view.dialog.selected.d(r12, new com.bytedance.android.livesdk.ktvimpl.ktvroom.view.dialog.selected.a(r13, r8.c(), r12.D, r12.B, r14)));
        goto L32
    L38:
        KtvContext.Companion.getClass();
        if (KtvContext.a.k() == true) goto L41;
    L143:
        String r9 = "refresh selected music,size:" + r6.size();
        ALogger.i(bb0.b.b(), r9 + ", invoke class :PlayListContainerView");
        KtvContext.Companion.getClass();
        List<MusicPanel> r10 = com.bytedance.android.livesdk.ktvimpl.base.orderedsong.d.b(KtvContext.a.g());
        Set r11 = ((LinkedHashMap) this.m).keySet();
        List<MusicPanel> r17 = r10;
        ArrayList r18 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r17, 10));
        Iterator<T> r19 = r17.iterator();
    L145:
        if (r19.hasNext() == false) goto L147;
        r18.add(Long.valueOf(((MusicPanel) r19.next()).a.getMId()));
        goto L145
    L147:
        Iterator r22 = CollectionsKt.subtract(r11, CollectionsKt.toMutableSet(r18)).iterator();
    L149:
        if (r22.hasNext() == false) goto L151;
        this.m.remove(Long.valueOf(((Number) r22.next()).longValue()));
        goto L149
    L151:
        Disposable r23 = Observable.just(DiffUtil.calculateDiff(new SelectedMusicListDiffCallBack(CollectionsKt.toList(this.a), r6))).compose(RxUtil.rxSchedulerHelper()).subscribe(new d(this, r6), e.a);
        if (r23 == null) goto L155;
        RxUtilKt.c(r23, getCompositeDisposable());
    L155:
        if (jc0.a.c() == false) goto L161;
        com.bytedance.android.livesdk.ktvimpl.crossplatform.player.c r24 = VideoChorusDataContext.Companion.a();
        if (r24 == null) goto L159;
        jd2.c r25 = r24.f();
    L160:
        o(r25);
        return;
    L159:
        r25 = null;
        goto L160
    L161:
        KtvContext.Companion.getClass();
        KtvContext r26 = KtvContext.a.g();
        if (r26 == null) goto L168;
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c> r27 = r26.getKtvCoreViewModel();
        if (r27 == null) goto L168;
        com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c r28 = (com.bytedance.android.livesdk.ktvimpl.base.viewmodel.c) r27.getValue();
        if (r28 == null) goto L168;
        KtvRoomLyricsStateMachineConfig.d r29 = r28.getCurState();
    L169:
        boolean r30 = r29 instanceof KtvRoomLyricsStateMachineConfig.d.C0041d;
        KtvRoomSelectedMusicViewHolder r31 = getSingingMusicItem();
        if (r31 == null) goto L197;
        r31.g4(r30);
        return;
    L197:
        return;
    L168:
        r29 = null;
        goto L169
    L41:
        if ((!r7.isEmpty()) == true) goto L43;
    L77:
        com.bytedance.android.livesdk.ktvimpl.base.util.j.l.getClass();
        boolean r32 = com.bytedance.android.livesdk.ktvimpl.base.util.j.a();
        this.d = !r7.isEmpty();
        Iterator r33 = r7.iterator();
    L79:
        if (r33.hasNext() == false) goto L81;
        MusicPanel r34 = (MusicPanel) r33.next();
        r6.add(new com.bytedance.android.livesdk.ktvimpl.ktvroom.view.dialog.selected.b.a(r34, new com.bytedance.android.livesdk.ktvimpl.ktvroom.view.dialog.selected.a(r13, MultiChorusContext.Companion.c(), r34.D, r34.B, r32)));
        goto L79
    L81:
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r35 = this.q;
        if (r35 == null) goto L84;
        int r36 = r35.getWantSingSongThreshold();
    L85:
        if (r36 > 0) goto L87;
    L89:
        ArrayList r37 = new ArrayList();
        Iterator<T> r38 = r20.iterator();
    L91:
        if (r38.hasNext() == false) goto L108;
        Object r39 = r38.next();
        OrderInfo r40 = ((MusicPanel) r39).a.getOrderInfo();
        if (r40 == null) goto L98;
        InteractiveSongUserInfo r41 = r40.getTopUser();
        if (r41 == null) goto L98;
        String r42 = r41.getIdString();
        if (r42 == null) goto L98;
    L99:
        IMiddlewareUserService r43 = jc1.k.f(IMiddlewareUserService.class);
        if (r43 == null) goto L104;
        com.bytedance.android.livesdk.user.e r44 = r43.user();
        if (r44 == null) goto L104;
        String r45 = r44.n();
    L106:
        if (Intrinsics.areEqual(r42, r45) == false) goto L91;
        r37.add(r39);
    L104:
        r45 = null;
    L98:
        r42 = "";
        goto L99
    L108:
        boolean r46 = true;
        if ((!r37.isEmpty()) == true) goto L112;
        r37 = null;
    L112:
        if (r37 == null) goto L140;
        MusicPanel r47 = (MusicPanel) ListProtector.get(r37, 0);
        if (r47 == null) goto L140;
        Iterator r48 = CollectionsKt.take(r20, 2).iterator();
    L117:
        if (r48.hasNext() == false) goto L122;
        if (KtvUtilsKt.t(r47.a, ((MusicPanel) r48.next()).a) == false) goto L117;
        r46 = false;
        goto L117
    L122:
        if (r47.e == true) goto L133;
        Iterator<T> r49 = r20.iterator();
        int r50 = 0;
    L125:
        if (r49.hasNext() == false) goto L133;
        Object r51 = r49.next();
        int r52 = r50 + 1;
        if (r50 >= 0) goto L130;
        CollectionsKt.throwIndexOverflow();
    L130:
        if (KtvUtilsKt.t(r47.a, ((MusicPanel) r51).a) == true) goto L131;
        r50 = r52;
        goto L125
    L131:
        int r110 = r50;
    L134:
        r6.add(new KtvRoomBottomFillViewBinder.a());
        FloatingBottomView r53 = getSelfMusicFloatBottomView();
        if (r53 == null) goto L137;
        int r54 = FloatingBottomView.y;
        Intrinsics.checkNotNullParameter(r53, "$this$showSelf");
        r53.setVisibility(0);
    L137:
        FloatingBottomView r55 = getSelfMusicFloatBottomView();
        if (r55 == null) goto L143;
        r55.d(r47, r46, r110);
    L133:
        r110 = -1;
    L140:
        FloatingBottomView r56 = getSelfMusicFloatBottomView();
        if (r56 == null) goto L143;
        int r57 = FloatingBottomView.y;
        FloatingBottomView.a.a(r56);
        Unit r58 = Unit.INSTANCE;
        goto L143
    L87:
        if (r15.size() < r36) goto L89;
        r6.add(new KtvRoomSelectedMusicTipsViewBinder.a(r36, true));
        goto L89
    L84:
        r36 = -1;
        goto L85
    L43:
        if (KtvUtilsKt.j() == true) goto L61;
        DataCenter r59 = getDataCenter();
        if (r59 != null) goto L47;
    L49:
        Iterator<T> r60 = r20.iterator();
        int r61 = 0;
    L51:
        if (r60.hasNext() == false) goto L61;
        Object r62 = r60.next();
        int r63 = r61 + 1;
        if (r61 >= 0) goto L55;
        CollectionsKt.throwIndexOverflow();
    L55:
        MusicPanel r64 = (MusicPanel) r62;
        if (r64.e == false) goto L60;
        if (KtvUtilsKt.w(r64.a) == false) goto L60;
    L62:
        if (r61 < 0) goto L64;
        int r65 = r61;
    L66:
        if (KtvUtilsKt.j() == true) goto L74;
        DataCenter r66 = getDataCenter();
        if (r66 != null) goto L70;
    L72:
        if (r61 != (-1)) goto L74;
        boolean r67 = true;
    L75:
        if (r67 == true) goto L77;
        r6.add(new KtvRoomSelectedMusicTipsViewBinder.a(r65, false));
        goto L77
    L70:
        if (a0.d(r66, false) != true) goto L72;
    L74:
        r67 = false;
        goto L75
    L64:
        r65 = r7.size();
    L60:
        r61 = r63;
        goto L51
    L47:
        if (a0.d(r59, false) != true) goto L49;
    L61:
        r61 = -1;
        goto L62
    L15:
        r2 = false;
        goto L16
    }

    public PlayListContainerView(com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r3, com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r4, Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, null, 0);
        this.p = r3;
        this.q = r4;
        this.a = new ArrayList();
        this.b = new LifecycleRegistry(this);
        this.c = new w();
        this.e = LazyKt.lazy(PlayListContainerView$dataCenter$2.INSTANCE);
        this.f = LazyKt.lazy(new PlayListContainerView$adapter$2(this));
        this.g = LazyKt.lazy(new PlayListContainerView$selectedListContainer$2(this));
        this.h = LazyKt.lazy(new PlayListContainerView$selectedListRv$2(this));
        this.i = LazyKt.lazy(new PlayListContainerView$selfMusicFloatBottomView$2(this));
        this.j = LazyKt.lazy(new PlayListContainerView$emptyView$2(this));
        this.k = LazyKt.lazy(PlayListContainerView$compositeDisposable$2.INSTANCE);
        this.l = new com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab.h(this);
        this.m = new LinkedHashMap();
        this.n = LazyKt.lazy(PlayListContainerView$itemExposureCheckHelper$2.INSTANCE);
        this.o = LazyKt.lazy(new PlayListContainerView$itemExposureListener$2(this));
    }
}
