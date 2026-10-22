package com.larus.home.impl.main.tab.component;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.bmhome.BaseHomeTabFragment;
import com.larus.bmhome.auth.c1;
import com.larus.bmhome.chat.ChatFragment;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.model.repo.INotifyService;
import com.larus.bmhome.utils.LandingRedBadgeHelperDelegate;
import com.larus.home.impl.MainActivity;
import com.larus.home.impl.main.tab.MainTabFragment;
import com.larus.home.impl.main.tab.config.BottomTabConfigManager;
import com.larus.ui.arch.component.external.LazyComponent;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import tx9.f2;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000O\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0015*\u0001\u0010\u0018\u0000 62\u00020\u00012\u00020\u0002:\u00016B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0017\u001a\u00020\u0015H\u0016J\b\u0010\u0018\u001a\u00020\u0015H\u0002J\b\u0010\u0019\u001a\u00020\u0015H\u0016J\n\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u0015H\u0002J\u0010\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\fH\u0002J\u0010\u0010\u001f\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\fH\u0002J\u0010\u0010'\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\fH\u0002J\b\u0010(\u001a\u00020\u0015H\u0002J\u0017\u0010)\u001a\u0004\u0018\u00010\u00152\u0006\u0010*\u001a\u00020\fH\u0002¢\u0006\u0002\u0010+J\u0017\u0010,\u001a\u0004\u0018\u00010\u00152\u0006\u0010 \u001a\u00020\fH\u0002¢\u0006\u0002\u0010+J \u0010-\u001a\u00020\u00152\u0006\u0010.\u001a\u00020\u001b2\u0006\u0010/\u001a\u00020\f2\u0006\u00100\u001a\u00020\fH\u0002J\b\u00101\u001a\u00020\u0015H\u0016J\b\u00102\u001a\u00020\u0015H\u0016J\u0010\u00103\u001a\u00020\u00152\u0006\u00104\u001a\u00020\fH\u0002J\u0010\u00105\u001a\u00020\u00152\u0006\u00104\u001a\u00020\fH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00150\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b#\u0010$¨\u00067"}, d2 = {"Lcom/larus/home/impl/main/tab/component/MainBottomRedComponent;", "Lcom/larus/ui/arch/component/external/LazyComponent;", "Lcom/larus/home/impl/main/tab/component/IMainBottomRedComponentAbility;", "<init>", "()V", "mainContentAbility", "Lcom/larus/home/impl/main/tab/component/IMainContentComponentAbility;", "mainAbility", "Lcom/larus/home/impl/main/tab/component/IMainAbility;", "mainBottomTabAbility", "Lcom/larus/home/impl/main/tab/component/IMainBottomTabComponentAbility;", "conversationRedDotNum", "", "notifyRedDotNum", "unReadRedPointCount", "unReadObserver", "com/larus/home/impl/main/tab/component/MainBottomRedComponent$unReadObserver$1", "Lcom/larus/home/impl/main/tab/component/MainBottomRedComponent$unReadObserver$1;", "unReadObserver2", "Lcom/larus/bmhome/chat/reddot/ConversationRedDotListenerWrapper;", "onAttach", "", WidgetCostModule.TYPE_ON_CREATE, "onViewCreatedInternal", "refreshConversationRedDotObserver", "onFragmentViewDestroyed", "getStackTopChatCvsId", "", "observeNotificationTabRedDotEvent", "updateNotificationTabRedDotVisibility", "unreadCount", "onNotifyRedDotChange", "count", "checkRedJob", "Lkotlin/Function0;", "getCheckRedJob", "()Lkotlin/jvm/functions/Function0;", "checkRedJob$delegate", "Lkotlin/Lazy;", "onCvsRedDotChange", "checkRedDot", "updateRedDotVisibility", RemoteMessageConst.Notification.VISIBILITY, "(I)Lkotlin/Unit;", "updateUnreadCount", "reportMsgNoticeChange", "noticeCategory", "currentCount", "lastCount", "onRedDotShow", "resumeHandleLandingRedBadge", "reportCvsMsgNoticeShow", "showCnt", "reportNotifyMsgNoticeShow", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MainBottomRedComponent extends LazyComponent implements com.larus.home.impl.main.tab.component.b {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f345873q = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public d f345874h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public com.larus.home.impl.main.tab.component.a f345875i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public com.larus.home.impl.main.tab.component.c f345876j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f345877k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f345878l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f345879m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final c f345880n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public com.larus.bmhome.chat.reddot.a f345881o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f345882p;

    public static final class a {
    }

    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f345883a;

        public b(Function1 r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f345883a = r100;
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r100 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r100).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> getFunctionDelegate() {
            return this.f345883a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object r100) {
            this.f345883a.invoke(r100);
        }
    }

    public static final class c implements nf9.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MainBottomRedComponent f345884a;

        @Override // nf9.e
        public final String a() {
            MainBottomRedComponent r100 = this.f345884a;
            int r101 = MainBottomRedComponent.f345873q;
            r100.getClass();
            Activity r102 = com.bytedance.sdk.account.utils.d.b();
            String r103 = null;
            if ((r102 instanceof MainActivity) == false) goto L5;
            MainActivity r104 = (MainActivity) r102;
        L6:
            if (r104 == null) goto L44;
            Fragment r105 = r104.getSupportFragmentManager().findFragmentByTag("tag_main_tab_fragment");
            if ((r105 instanceof MainTabFragment) == false) goto L11;
            MainTabFragment r106 = (MainTabFragment) r105;
        L12:
            if (r106 == null) goto L44;
            d r107 = r100.f345874h;
            if (r107 == null) goto L44;
            BaseHomeTabFragment r108 = r107.IK(null);
            if (r108 == null) goto L44;
            Fragment r109 = r108.U90();
            if (r109 == null) goto L44;
            if ((r109 instanceof ChatFragment) == false) goto L24;
            r103 = ((ChatFragment) r109).getConversationId();
            goto L44
        L24:
            Iterator<T> r110 = r109.getChildFragmentManager().getFragments().iterator();
        L26:
            if (r110.hasNext() == false) goto L37;
            Object r111 = r110.next();
            Fragment r112 = (Fragment) r111;
            if ((r112 instanceof ChatFragment) == false) goto L34;
            ChatFragment r113 = (ChatFragment) r112;
            if (r113.isVisible() == false) goto L34;
            if (r113.isResumed() == false) goto L34;
            boolean r114 = true;
        L35:
            if (r114 == false) goto L26;
        L39:
            if ((r111 instanceof ChatFragment) == false) goto L41;
            ChatFragment r115 = (ChatFragment) r111;
        L42:
            if (r115 == null) goto L44;
            r103 = r115.getConversationId();
            goto L44
        L41:
            r115 = null;
        L34:
            r114 = false;
            goto L35
        L37:
            r111 = null;
            goto L39
        L11:
            r106 = null;
        L44:
            FLogger.f375446a.d("MainBottomRedComponent", "ignoreId=" + r103);
            return r103;
        L5:
            r104 = null;
            goto L6
        }

        public c(MainBottomRedComponent r100) {
            this.f345884a = r100;
        }

        @Override // nf9.e
        public final void onUpdate(int r100) {
            MainBottomRedComponent r101 = this.f345884a;
            r101.f345879m = r100;
            ((Function0) r101.f345882p.getValue()).invoke();
            FLogger.f375446a.d("MainBottomRedComponent", "on update count=" + r100);
        }
    }

    static {
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void A2() {
        com.larus.bmhome.chat.reddot.a r100 = this.f345881o;
        if (r100 == null) goto L6;
        com.larus.bmhome.chat.reddot.f r101 = com.larus.bmhome.chat.reddot.f.f308497a;
        com.larus.bmhome.chat.reddot.f.e(r100);
        return;
    }

    @Override // com.larus.home.impl.main.tab.component.b
    public final void US() {
        com.larus.home.impl.main.tab.component.a r100 = this.f345875i;
        boolean r101 = false;
        if (r100 != null) goto L5;
    L7:
        if (r101 == false) goto L10;
        Intrinsics.checkNotNullParameter(this, "<this>");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(com.larus.ui.arch.component.internal.attach.a.b(this, this).getViewLifecycleOwner()), Dispatchers.getIO(), null, new MainBottomRedComponent$onRedDotShow$1(this, null), 2, null);
        L2(this.f345878l);
        return;
    L10:
        return;
    L5:
        if (r100.vj() != true) goto L7;
        r101 = true;
        goto L7
    }

    @Override // com.larus.home.impl.main.tab.component.b
    public final void iv() {
        LandingRedBadgeHelperDelegate r100 = LandingRedBadgeHelperDelegate.f314918b;
        if (r100.b() == false) goto L6;
        FLogger r101 = FLogger.f375446a;
        String r102 = MainTabFragment.f345844J;
        r101.d(MainTabFragment.f345844J, "main tab resumed");
        r100.a();
        return;
    }

    @Override // com.larus.home.impl.main.tab.component.b
    public final void v40() {
        BottomTabConfigManager r100 = BottomTabConfigManager.f345968a;
        if (r100.j() == false) goto L6;
        MutableLiveData<Integer> r101 = INotifyService.f307709a.e().a();
        Intrinsics.checkNotNullParameter(this, "<this>");
        r101.observe(com.larus.ui.arch.component.internal.attach.a.b(this, this).getViewLifecycleOwner(), new b(new g(this)));
    L6:
        if (r100.a() == false) goto L8;
        MutableLiveData<Integer> r102 = INotifyService.f307709a.e().a();
        Intrinsics.checkNotNullParameter(this, "<this>");
        r102.observe(com.larus.ui.arch.component.internal.attach.a.b(this, this).getViewLifecycleOwner(), new b(new h(this)));
    L8:
        LiveData<c1<com.larus.bmhome.auth.j0>> r103 = AuthModelDelegate.f297134b.B();
        Intrinsics.checkNotNullParameter(this, "<this>");
        r103.observe(com.larus.ui.arch.component.internal.attach.a.b(this, this).getViewLifecycleOwner(), new b(new e(this)));
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, com.larus.home.impl.main.tab.component.b.class);
    }

    public MainBottomRedComponent() {
        this.f345877k = -1;
        this.f345878l = -1;
        this.f345880n = new c(this);
        this.f345882p = LazyKt.lazy(new f(this));
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onCreate() {
        this.f345875i = (com.larus.home.impl.main.tab.component.a) s1a.d.a(this).getAbility(com.larus.home.impl.main.tab.component.a.class);
        this.f345876j = (com.larus.home.impl.main.tab.component.c) s1a.d.a(this).getAbility(com.larus.home.impl.main.tab.component.c.class);
        this.f345874h = (d) s1a.d.a(this).getAbility(d.class);
    }

    public final void F2(int r100) {
        com.larus.home.impl.main.tab.component.c r101 = this.f345876j;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.OO(MainTabFragment.MainTab.CONVERSATION.getIndex()) == null) goto L10;
        if (r100 <= 0) goto L11;
        f2.b("chat_list", "number_dot", String.valueOf(r100), 24);
        return;
    L11:
        return;
    }

    public final void L2(int r100) {
        com.larus.home.impl.main.tab.component.c r101 = this.f345876j;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.OO(MainTabFragment.MainTab.NOTIFY.getIndex()) == null) goto L10;
        if (r100 <= 0) goto L11;
        f2.b("notify", "number_dot", String.valueOf(r100), 24);
        return;
    L11:
        return;
    }
}
