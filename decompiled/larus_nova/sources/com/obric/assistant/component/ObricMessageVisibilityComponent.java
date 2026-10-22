package com.obric.assistant.component;

import android.graphics.Rect;
import android.os.SystemClock;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.larus.bmhome.chat.adapter.MessageAdapter;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.ui.arch.component.external.api.provider.EmptyComponent;
import com.larus.ui.arch.component.external.api.receiver.AttachReceiver;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.data.ObricFloatChatPageData;
import com.obric.assistant.data.ObricFloatChatPageState;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000¹\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0003.14\u0018\u0000 [2\u00020\u00012\u00020\u0002:\u0004[\\]^B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u00108\u001a\u000209H\u0016J\b\u0010:\u001a\u000209H\u0016J\b\u0010;\u001a\u000209H\u0016J\b\u0010<\u001a\u000209H\u0016J\b\u0010=\u001a\u000209H\u0016J\u0018\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020CH\u0016J\u0010\u0010D\u001a\u0002092\u0006\u0010E\u001a\u00020FH\u0002J\u0010\u0010G\u001a\u0002092\u0006\u0010E\u001a\u00020FH\u0002J\u0010\u0010H\u001a\u0002092\u0006\u0010E\u001a\u00020FH\u0002J\u000e\u0010I\u001a\b\u0012\u0004\u0012\u00020K0JH\u0002J\b\u0010L\u001a\u00020)H\u0002J\b\u0010M\u001a\u000209H\u0002J\b\u0010N\u001a\u000209H\u0002J\b\u0010O\u001a\u000209H\u0002J\b\u0010P\u001a\u000209H\u0002J\u0014\u0010Q\u001a\u0002092\n\u0010R\u001a\u0006\u0012\u0002\b\u00030'H\u0002J\u0014\u0010S\u001a\u0002092\n\u0010R\u001a\u0006\u0012\u0002\b\u00030'H\u0002J\n\u0010T\u001a\u0004\u0018\u00010%H\u0002J\u000e\u0010U\u001a\b\u0012\u0002\b\u0003\u0018\u00010'H\u0002J\u0018\u0010V\u001a\u00020F2\u0006\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020ZH\u0002R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\u000b\u001a\u0004\u0018\u00010\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\n\u001a\u0004\b\u001c\u0010\u001dR\u0018\u0010\u001f\u001a\f\u0012\b\u0012\u00060!R\u00020\u00000 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\b\u0012\u0002\b\u0003\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0004\n\u0002\u0010/R\u0010\u00100\u001a\u000201X\u0082\u0004¢\u0006\u0004\n\u0002\u00102R\u0010\u00103\u001a\u000204X\u0082\u0004¢\u0006\u0004\n\u0002\u00105R\u000e\u00106\u001a\u000207X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006_"}, d2 = {"Lcom/obric/assistant/component/ObricMessageVisibilityComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/obric/assistant/ability/IObricMessageVisibilityAbility;", "<init>", "()V", "chatFragmentAbility", "Lcom/larus/bmhome/ability/IChatFragmentCoreAbility;", "getChatFragmentAbility", "()Lcom/larus/bmhome/ability/IChatFragmentCoreAbility;", "chatFragmentAbility$delegate", "Lkotlin/Lazy;", "chatListAbility", "Lcom/larus/bmhome/ability/IChatListCoreAbility;", "getChatListAbility", "()Lcom/larus/bmhome/ability/IChatListCoreAbility;", "chatListAbility$delegate", "chatListComponentAbility", "Lcom/larus/bmhome/chat/component/list/IChatListComponentAbility;", "getChatListComponentAbility", "()Lcom/larus/bmhome/chat/component/list/IChatListComponentAbility;", "chatListComponentAbility$delegate", "pageStateAbility", "Lcom/obric/assistant/ability/IObricChatPageStateAbility;", "getPageStateAbility", "()Lcom/obric/assistant/ability/IObricChatPageStateAbility;", "pageStateAbility$delegate", "binding", "Lcom/larus/bmhome/ability/IChatCoreBinding;", "getBinding", "()Lcom/larus/bmhome/ability/IChatCoreBinding;", "binding$delegate", "subscriptions", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/obric/assistant/component/ObricMessageVisibilityComponent$SubscriptionState;", "subscriptionIdGenerator", "Ljava/util/concurrent/atomic/AtomicLong;", "observedRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "observedAdapter", "Lcom/larus/bmhome/chat/adapter/IMessageListAdapter;", "dispatchPosted", "", "listObserver", "Lcom/larus/bmhome/social/page/datasource/diff/IPagingDataSourceObserver;", "Lcom/larus/bmhome/chat/bean/IMessageProvider;", "pageStateCallback", "com/obric/assistant/component/ObricMessageVisibilityComponent$pageStateCallback$1", "Lcom/obric/assistant/component/ObricMessageVisibilityComponent$pageStateCallback$1;", "scrollListener", "com/obric/assistant/component/ObricMessageVisibilityComponent$scrollListener$1", "Lcom/obric/assistant/component/ObricMessageVisibilityComponent$scrollListener$1;", "childAttachListener", "com/obric/assistant/component/ObricMessageVisibilityComponent$childAttachListener$1", "Lcom/obric/assistant/component/ObricMessageVisibilityComponent$childAttachListener$1;", "layoutChangeListener", "Landroid/view/View$OnLayoutChangeListener;", "onParentViewCreated", "", "onResume", "onPause", "onStop", LiveCommonConstants.REASON_ON_DEDTROY, "observeMessageVisibility", "Lcom/obric/assistant/ability/ObricMessageVisibilitySubscription;", "config", "Lcom/obric/assistant/ability/ObricMessageVisibilityConfig;", "listener", "Lcom/obric/assistant/ability/ObricMessageVisibilityListener;", "scheduleVisibilityDispatch", "reason", "", "dispatchVisibility", "flushVisibleMessages", "collectVisibleMessageSnapshots", "", "Lcom/obric/assistant/component/ObricMessageVisibilityComponent$VisibleMessageSnapshot;", "isPageActuallyVisible", "ensureRecyclerViewObserver", "removeRecyclerViewObserver", "ensureAdapterObserver", "removeAdapterObserver", "registerAdapterObserver", "adapter", "unregisterAdapterObserver", "getMessageListView", "getMessageListAdapter", "buildMessageKey", "message", "Lcom/larus/im/bean/message/Message;", "position", "", "Companion", "SubscriptionState", "VisibleRecord", "VisibleMessageSnapshot", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricMessageVisibilityComponent extends ComponentFeature implements laa.g {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ int f388149w = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f388150h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f388151i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f388152j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f388153k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f388154l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final CopyOnWriteArrayList<b> f388155m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final AtomicLong f388156n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public RecyclerView f388157o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public com.larus.bmhome.chat.adapter.i<?> f388158p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f388159q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final z2 f388160r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final e f388161s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final ObricMessageVisibilityComponent$scrollListener$1 f388162t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final ObricMessageVisibilityComponent$childAttachListener$1 f388163u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final a3 f388164v;

    public static final class a {
    }

    public final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f388165a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final laa.o f388166b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final laa.q f388167c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final LinkedHashMap<String, d> f388168d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ ObricMessageVisibilityComponent f388169e;

        public final void a() {
            Iterator<T> r100 = this.f388168d.values().iterator();
        L4:
            if (r100.hasNext() == false) goto L8;
            Job r101 = ((d) r100.next()).f388177c;
            if (r101 == null) goto L4;
            Job.DefaultImpls.cancel$default(r101, null, 1, null);
            goto L4
        L8:
            this.f388168d.clear();
        }

        public final void b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "reason");
            Iterator r101 = CollectionsKt.toList(this.f388168d.keySet()).iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            String r102 = (String) r101.next();
            Intrinsics.checkNotNull(r102);
            c(r102, r100);
            goto L4
        }

        public final void c(String r100, final String r101) {
            final d r102 = this.f388168d.remove(r100);
            if (r102 != null) goto L5;
            return;
        L5:
            Job r103 = r102.f388177c;
            if (r103 == null) goto L8;
            Job.DefaultImpls.cancel$default(r103, null, 1, null);
        L8:
            d("onMessageHidden", new c3(this, r102, r101));
        }

        public final void d(String r100, Function0<Unit> r101) {
            Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L4
            Object r103 = Result.m9449constructorimpl(r101.invoke());     // Catch: Throwable -> L4
        L6:
            Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
            if (r104 == null) goto L12;
            FLogger.f375446a.e("ObricMessageVisibility", r100 + " failed, subscriptionId=" + this.f388165a, r104);
            return;
        L12:
            return;
        L4:
            th = move-exception;
            Result.Companion r105 = Result.Companion;
            r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L6
        }

        public b(ObricMessageVisibilityComponent r100, long r101, laa.o r102, ComplexTaskCompletedIslandVisibilityComponent.b r103) {
            Intrinsics.checkNotNullParameter(r102, "config");
            Intrinsics.checkNotNullParameter(r103, "listener");
            this.f388169e = r100;
            this.f388165a = r101;
            this.f388166b = r102;
            this.f388167c = r103;
            this.f388168d = new LinkedHashMap();
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Message f388170a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f388171b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f388172c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f388173d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f388170a, r101.f388170a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f388171b, r101.f388171b) == true) goto L15;
            return false;
        L15:
            if (this.f388172c == r101.f388172c) goto L18;
            return false;
        L18:
            if (Float.compare(this.f388173d, r101.f388173d) == 0) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.f388170a.hashCode() * 31) + this.f388171b.hashCode()) * 31) + this.f388172c) * 31) + Float.floatToIntBits(this.f388173d);
        }

        public final String toString() {
            return "VisibleMessageSnapshot(message=" + this.f388170a + ", messageKey=" + this.f388171b + ", position=" + this.f388172c + ", visibleRatio=" + this.f388173d + ')';
        }

        public final laa.p a(long r110, String r111) {
            Intrinsics.checkNotNullParameter(r111, "reason");
            return new laa.p(this.f388170a, this.f388171b, this.f388172c, this.f388173d, SystemClock.elapsedRealtime() - r110, r111);
        }

        public c(Message r100, String r101, int r102, float r103) {
            Intrinsics.checkNotNullParameter(r100, "message");
            Intrinsics.checkNotNullParameter(r101, "messageKey");
            this.f388170a = r100;
            this.f388171b = r101;
            this.f388172c = r102;
            this.f388173d = r103;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c f388175a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f388176b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Job f388177c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L8;
            return false;
        L8:
            d r101 = (d) r100;
            if (Intrinsics.areEqual(this.f388175a, r101.f388175a) == true) goto L12;
            return false;
        L12:
            if (this.f388176b == r101.f388176b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f388177c, r101.f388177c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f388175a.hashCode() * 31;
            long r101 = this.f388176b;
            int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
            Job r103 = this.f388177c;
            if (r103 != null) goto L5;
            int r104 = 0;
        L7:
            return r102 + r104;
        L5:
            r104 = r103.hashCode();
            goto L7
        }

        public final String toString() {
            return "VisibleRecord(snapshot=" + this.f388175a + ", firstShownAtMs=" + this.f388176b + ", visibleForJob=" + this.f388177c + ')';
        }

        public d(c r100, long r101) {
            Intrinsics.checkNotNullParameter(r100, "snapshot");
            this.f388175a = r100;
            this.f388176b = r101;
            this.f388177c = null;
        }
    }

    public static final class e implements hca.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ObricMessageVisibilityComponent f388178a;

        public e(ObricMessageVisibilityComponent r100) {
            this.f388178a = r100;
        }

        @Override // hca.b
        public final void r2(boolean r100) {
            if (r100 == false) goto L4;
            ObricMessageVisibilityComponent r101 = this.f388178a;
            int r102 = ObricMessageVisibilityComponent.f388149w;
            r101.N2("page_change_to_chat_window");
            return;
        L4:
            ObricMessageVisibilityComponent r103 = this.f388178a;
            int r104 = ObricMessageVisibilityComponent.f388149w;
            r103.Y2("chat_style_changed");
        }

        @Override // hca.b
        public final void x1(ObricFloatChatPageState r100) {
            Intrinsics.checkNotNullParameter(r100, "pageState");
            ObricFloatChatPageData.Companion.getClass();
            if (ObricFloatChatPageData.a.d(r100) == false) goto L5;
            ObricMessageVisibilityComponent r101 = this.f388178a;
            int r102 = ObricMessageVisibilityComponent.f388149w;
            r101.Y2("page_visible");
            return;
        L5:
            ObricMessageVisibilityComponent r103 = this.f388178a;
            int r104 = ObricMessageVisibilityComponent.f388149w;
            r103.N2("page_invisible");
        }
    }

    public static final class f implements Function0<va8.m> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f388179a;

        public f(AttachReceiver r100) {
            this.f388179a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [t1a.a, va8.m] */
        @Override // kotlin.jvm.functions.Function0
        public final va8.m invoke() {
            AttachReceiver r100 = this.f388179a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(va8.m.class));
        }
    }

    public static final class g implements Function0<va8.p> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f388180a;

        public g(AttachReceiver r100) {
            this.f388180a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [t1a.a, va8.p] */
        @Override // kotlin.jvm.functions.Function0
        public final va8.p invoke() {
            AttachReceiver r100 = this.f388180a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(va8.p.class));
        }
    }

    public static final class h implements Function0<u7> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f388181a;

        public h(AttachReceiver r100) {
            this.f388181a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.bmhome.chat.component.list.u7, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final u7 invoke() {
            AttachReceiver r100 = this.f388181a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(u7.class));
        }
    }

    public static final class i implements Function0<laa.d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachReceiver f388182a;

        public i(AttachReceiver r100) {
            this.f388182a = r100;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [laa.d, t1a.a] */
        @Override // kotlin.jvm.functions.Function0
        public final laa.d invoke() {
            AttachReceiver r100 = this.f388182a;
            if ((r100 instanceof EmptyComponent) == false) goto L6;
            return null;
        L6:
            return s1a.d.a(r100).o(Reflection.getOrCreateKotlinClass(laa.d.class));
        }
    }

    static {
    }

    public final RecyclerView Ly() {
        laa.d r100 = (laa.d) this.f388153k.getValue();
        if (r100 == null) goto L6;
        RecyclerView r101 = r100.Xw();
        if (r101 == null) goto L6;
        return r101;
    L6:
        va8.l r102 = (va8.l) this.f388154l.getValue();
        if (r102 != null) goto L12;
        return null;
    L12:
        return r102.getMessageList();
    }

    public final com.larus.bmhome.chat.adapter.i<?> P2() {
        va8.p r100 = (va8.p) this.f388151i.getValue();
        if ((r100 instanceof u7) == false) goto L5;
        u7 r101 = (u7) r100;
    L6:
        if (r101 == null) goto L8;
        MessageAdapter r102 = r101.MF();
    L10:
        if ((r102 instanceof com.larus.bmhome.chat.adapter.i) == true) goto L13;
        r102 = null;
    L13:
        if (r102 != null) goto L21;
        u7 r103 = (u7) this.f388152j.getValue();
        if (r103 == null) goto L17;
        r102 = r103.MF();
    L19:
        if ((r102 instanceof com.larus.bmhome.chat.adapter.i) == true) goto L21;
        return null;
    L17:
        r102 = null;
    L21:
        return r102;
    L8:
        r102 = null;
        goto L10
    L5:
        r101 = null;
        goto L6
    }

    public final void X2() {
        RecyclerView r100 = this.f388157o;
        if (r100 == null) goto L5;
        r100.removeOnScrollListener(this.f388162t);
    L5:
        RecyclerView r101 = this.f388157o;
        if (r101 == null) goto L8;
        r101.removeOnChildAttachStateChangeListener(this.f388163u);
    L8:
        RecyclerView r102 = this.f388157o;
        if (r102 == null) goto L11;
        r102.removeOnLayoutChangeListener(this.f388164v);
    L11:
        this.f388157o = null;
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onDestroy() {
        N2("component_destroy");
        laa.d r100 = (laa.d) this.f388153k.getValue();
        if (r100 == null) goto L5;
        r100.AN(this.f388161s);
    L5:
        X2();
        com.larus.bmhome.chat.adapter.i<?> r101 = this.f388158p;
        if (r101 == null) goto L8;
        r101.r1(this.f388160r);
    L8:
        this.f388158p = null;
        Iterator<b> r102 = this.f388155m.iterator();
    L10:
        if (r102.hasNext() == false) goto L12;
        r102.next().a();
        goto L10
    L12:
        this.f388155m.clear();
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onPause() {
        N2("component_pause");
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onResume() {
        Y2("component_resume");
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onStop() {
        N2("component_stop");
    }

    /* JADX WARN: Type inference failed for: r0v12, types: [com.obric.assistant.component.z2] */
    /* JADX WARN: Type inference failed for: r0v14, types: [com.obric.assistant.component.ObricMessageVisibilityComponent$scrollListener$1] */
    /* JADX WARN: Type inference failed for: r0v15, types: [com.obric.assistant.component.ObricMessageVisibilityComponent$childAttachListener$1] */
    /* JADX WARN: Type inference failed for: r0v16, types: [com.obric.assistant.component.a3] */
    public ObricMessageVisibilityComponent() {
        this.f388150h = LazyKt.lazy(new f(this));
        this.f388151i = LazyKt.lazy(new g(this));
        this.f388152j = LazyKt.lazy(new h(this));
        this.f388153k = LazyKt.lazy(new i(this));
        this.f388154l = LazyKt.lazy(new y2(this));
        this.f388155m = new CopyOnWriteArrayList();
        this.f388156n = new AtomicLong(0);
        this.f388160r = new z2(this);
        this.f388161s = new e(this);
        this.f388162t = new ObricMessageVisibilityComponent$scrollListener$1(this);
        this.f388163u = new ObricMessageVisibilityComponent$childAttachListener$1(this);
        this.f388164v = new a3(this);
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void B2() {
        L2();
        com.larus.bmhome.chat.adapter.i<?> r100 = P2();
        if (r100 == null) goto L11;
        com.larus.bmhome.chat.adapter.i<?> r101 = this.f388158p;
        if (r101 == r100) goto L11;
        if (r101 == null) goto L10;
        r101.r1(this.f388160r);
    L10:
        this.f388158p = r100;
        MessageAdapter r102 = (MessageAdapter) r100;
        r102.p1(this.f388160r);
    L11:
        laa.d r103 = (laa.d) this.f388153k.getValue();
        if (r103 == null) goto L14;
        r103.HU(this.f388161s);
    L14:
        Y2("parent_view_created");
    }

    public final void L2() {
        RecyclerView r100 = Ly();
        if (r100 != null) goto L6;
        return;
    L6:
        if (this.f388157o != r100) goto L8;
        return;
    L8:
        X2();
        this.f388157o = r100;
        r100.addOnScrollListener(this.f388162t);
        r100.addOnChildAttachStateChangeListener(this.f388163u);
        r100.addOnLayoutChangeListener(this.f388164v);
    }

    public final boolean U2() {
        RecyclerView r100 = Ly();
        if (r100 != null) goto L5;
        return false;
    L5:
        Rect r101 = new Rect();
        if (this.f375147a.getCurrentState().isAtLeast(Lifecycle.State.RESUMED) == false) goto L28;
        laa.d r102 = (laa.d) this.f388153k.getValue();
        if (r102 != null) goto L10;
    L12:
        boolean r103 = false;
    L13:
        if (r103 == true) goto L15;
        return false;
    L15:
        if (r100.isAttachedToWindow() == true) goto L17;
        return false;
    L17:
        if (r100.isShown() == true) goto L19;
        return false;
    L19:
        if (r100.getAlpha() > 0.0f) goto L21;
        return false;
    L21:
        if (r100.getGlobalVisibleRect(r101) == true) goto L23;
        return false;
    L23:
        if (r101.height() > 0) goto L25;
        return false;
    L25:
        if (r101.width() <= 0) goto L35;
        return true;
    L35:
        return false;
    L10:
        if (r102.isVisible() != true) goto L12;
        r103 = true;
        goto L13
    L28:
        return false;
    }

    public final void N2(String r100) {
        Iterator<T> r101 = this.f388155m.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((b) r101.next()).b(r100);
        goto L4
    }

    public final void Y2(String r100) {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain(), null, new ObricMessageVisibilityComponent$scheduleVisibilityDispatch$1(this, r100, null), 2, null);
    }

    public static final void F2(ObricMessageVisibilityComponent r210, final String r211) {
        if (r210.f388155m.isEmpty() == false) goto L6;
        return;
    L6:
        if (r210.U2() == true) goto L8;
        r210.N2(r211);
        return;
    L8:
        RecyclerView r100 = r210.Ly();
        if (r100 != null) goto L12;
        List r101 = CollectionsKt.emptyList();
    L11:
        List r102 = r101;
        Iterator<b> r110 = r210.f388155m.iterator();
    L117:
        if (r110.hasNext() == false) goto L179;
        b r111 = r110.next();
        r111.getClass();
        Intrinsics.checkNotNullParameter(r102, "snapshots");
        Intrinsics.checkNotNullParameter(r211, "reason");
        ArrayList r103 = new ArrayList();
        Iterator r104 = r102.iterator();
    L120:
        if (r104.hasNext() == false) goto L127;
        Object r105 = r104.next();
        if (((c) r105).f388173d < r111.f388166b.f508226a) goto L124;
        boolean r106 = true;
    L125:
        if (r106 == false) goto L120;
        r103.add(r105);
        goto L120
    L124:
        r106 = false;
        goto L125
    L127:
        LinkedHashMap r107 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r103, 10)), 16));
        Iterator r108 = r103.iterator();
    L129:
        if (r108.hasNext() == false) goto L131;
        Object r109 = r108.next();
        r107.put(((c) r109).f388171b, r109);
        goto L129
    L131:
        Set<String> r112 = r111.f388168d.keySet();
        ArrayList r113 = new ArrayList();
        Iterator<T> r114 = r112.iterator();
    L133:
        if (r114.hasNext() == false) goto L137;
        Object r115 = r114.next();
        if ((!r107.keySet().contains((String) r115)) == false) goto L133;
        r113.add(r115);
        goto L133
    L137:
        Iterator r116 = r113.iterator();
    L139:
        if (r116.hasNext() == false) goto L141;
        String r117 = (String) r116.next();
        Intrinsics.checkNotNull(r117);
        r111.c(r117, r211);
        goto L139
    L141:
        Iterator r118 = r107.values().iterator();
    L143:
        if (r118.hasNext() == false) goto L117;
        final c r119 = (c) r118.next();
        d r120 = r111.f388168d.get(r119.f388171b);
        if (r120 == null) goto L146;
        Intrinsics.checkNotNullParameter(r119, "<set-?>");
        r120.f388175a = r119;
        goto L143
    L146:
        final long r121 = SystemClock.elapsedRealtime();
        d r122 = new d(r119, r121);
        r111.f388168d.put(r119.f388171b, r122);
        final b r123 = r111;
        r111.d("onMessageShown", new d3(r123, r119, r121, r211));
        Long r124 = r111.f388166b.f508227b;
        if (r124 == null) goto L143;
        if (r124.longValue() < 0) goto L143;
        r122.f388177c = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r111.f388169e), Dispatchers.getMain(), null, new ObricMessageVisibilityComponent$SubscriptionState$showRecord$2(r124, r111, r119, r111.f388169e, null), 2, null);
        r111 = r111;
        goto L143
    L179:
        return;
    L12:
        RecyclerView.LayoutManager r125 = r100.getLayoutManager();
        if ((r125 instanceof LinearLayoutManager) == false) goto L15;
        LinearLayoutManager r126 = (LinearLayoutManager) r125;
    L16:
        if (r126 != null) goto L18;
        r101 = CollectionsKt.emptyList();
        goto L11
    L18:
        com.larus.bmhome.chat.adapter.i<?> r127 = r210.P2();
        if (r127 == null) goto L114;
        List<xc8.b> r128 = ((MessageAdapter) r127).z2();
        if (r128 == null) goto L114;
        int r129 = r126.findFirstVisibleItemPosition();
        int r130 = r126.findLastVisibleItemPosition();
        if (r129 == (-1)) goto L113;
        if (r130 == (-1)) goto L113;
        if (r129 > r130) goto L113;
        LinkedHashMap r131 = new LinkedHashMap();
        if (r129 > r130) goto L112;
    L30:
        ic8.v r132 = (ic8.v) CollectionsKt.getOrNull(r128, r129);
        if (r132 == null) goto L110;
        Message r133 = r132.a();
        if (r133 == null) goto L110;
        if (com.larus.bmhome.chat.bean.d.i0(r133) == false) goto L41;
        if (com.larus.bmhome.chat.bean.d.w(r133) == true) goto L41;
    L60:
        boolean r134 = false;
    L61:
        if (r134 == false) goto L110;
        View r135 = r126.findViewByPosition(r129);
        if (r135 == null) goto L110;
        Rect r136 = new Rect();
        if (r135.isAttachedToWindow() == true) goto L69;
    L79:
        boolean r137 = false;
    L80:
        if (r137 == false) goto L110;
        float r138 = RangesKt.coerceIn(r136.height() / RangesKt.coerceAtLeast(r135.getHeight(), 1.0f), 0.0f, 1.0f);
        String r139 = r133.getMessageId();
        String r140 = "";
        if (r139 != null) goto L86;
        r139 = "";
    L86:
        if (r139.length() <= 0) goto L88;
        boolean r141 = true;
    L89:
        if (r141 == true) goto L105;
        r139 = r133.getLocalMessageId();
        if (r139 != null) goto L95;
        r139 = "";
    L95:
        if (r139.length() <= 0) goto L97;
        boolean r142 = true;
    L98:
        if (r142 == true) goto L105;
        StringBuilder r143 = new StringBuilder();
        String r144 = r133.getConversationId();
        if (r144 == null) goto L104;
        r140 = r144;
    L104:
        r143.append(r140);
        r143.append('_');
        r143.append(r133.getContentType());
        r143.append('_');
        r143.append(r129);
        r139 = r143.toString();
        goto L105
    L97:
        r142 = false;
    L105:
        c r145 = new c(r133, r139, r129, r138);
        c r146 = (c) r131.get(r139);
        if (r146 != null) goto L108;
    L109:
        r131.put(r139, r145);
        goto L110
    L108:
        if (r146.f388173d >= r138) goto L110;
    L88:
        r141 = false;
        goto L89
    L69:
        if (r135.isShown() == false) goto L79;
        if (r135.getAlpha() <= 0.0f) goto L79;
        if (r135.getGlobalVisibleRect(r136) == false) goto L79;
        if (r136.height() <= 0) goto L79;
        if (r136.width() <= 0) goto L79;
        r137 = true;
    L41:
        if (com.larus.bmhome.chat.bean.d.T(r133) == true) goto L60;
        if (com.larus.bmhome.chat.bean.d.p0(r133) == true) goto L60;
        if (com.larus.bmhome.chat.bean.d.C0(r133) == true) goto L48;
    L50:
        MessageStatus r147 = r133.getMessageStatus();
        if (r147 != null) goto L53;
    L55:
        boolean r148 = false;
    L56:
        if (r148 == false) goto L58;
    L59:
        r134 = true;
        goto L61
    L58:
        if (com.larus.bmhome.social.userchat.model.b0.f(r133) == false) goto L60;
    L53:
        if (r147.isVisible() != true) goto L55;
        r148 = true;
        goto L56
    L48:
        if (r133.getRegenVisible() == true) goto L50;
    L110:
        if (r129 == r130) goto L112;
        r129 = r129 + 1;
    L112:
        r101 = CollectionsKt.toList(r131.values());
    L113:
        r101 = CollectionsKt.emptyList();
    L114:
        r101 = CollectionsKt.emptyList();
        goto L11
    L15:
        r126 = null;
        goto L16
    }

    /* JADX WARN: Type inference failed for: r9v3, types: [com.obric.assistant.component.ObricMessageVisibilityComponent$observeMessageVisibility$1] */
    @Override // laa.g
    public final ObricMessageVisibilityComponent$observeMessageVisibility$1 tt(laa.o r100, ComplexTaskCompletedIslandVisibilityComponent.b r101) {
        Intrinsics.checkNotNullParameter(r100, "config");
        Intrinsics.checkNotNullParameter(r101, "listener");
        laa.o r102 = new laa.o(RangesKt.coerceIn(r100.f508226a, 0.0f, 1.0f), r100.f508227b);
        final b r103 = new b(this, this.f388156n.incrementAndGet(), r102, r101);
        this.f388155m.add(r103);
        Y2("observe");
        return new ObricMessageVisibilityComponent$observeMessageVisibility$1(this, r103);
    }
}
