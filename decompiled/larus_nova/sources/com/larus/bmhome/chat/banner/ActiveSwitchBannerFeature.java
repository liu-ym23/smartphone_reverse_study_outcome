package com.larus.bmhome.chat.banner;

import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.keva.Keva;
import com.google.gson.Gson;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.platform.service.AccountService;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.utils.logger.FLogger;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000I\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0012\u0018\u0000  2\u00020\u00012\u00020\u0002:\u0001 B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u0019\u001a\u00020\u0017H\u0016J\n\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u0016H\u0016J\u0014\u0010\u001e\u001a\u00020\u00162\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0016H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0007\u001a\u0004\u0018\u00010\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/larus/bmhome/chat/banner/ActiveSwitchBannerFeature;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/larus/bmhome/chat/banner/IActiveSwitchBannerAbility;", "<init>", "()V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "conversationAbility", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "getConversationAbility", "()Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "conversationAbility$delegate", "Lkotlin/Lazy;", "runningJob", "Lkotlinx/coroutines/Job;", "hasRequested", "", "conversationChangeListener", "com/larus/bmhome/chat/banner/ActiveSwitchBannerFeature$conversationChangeListener$1", "Lcom/larus/bmhome/chat/banner/ActiveSwitchBannerFeature$conversationChangeListener$1;", "cmdRefreshListener", "Lkotlin/Function1;", "", "", WidgetCostModule.TYPE_ON_CREATE, LiveCommonConstants.REASON_ON_DEDTROY, "getCached", "Lcom/larus/bmhome/chat/banner/ActiveSwitchBannerData;", "requestRemote", "source", "cacheKey", "conversationId", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ActiveSwitchBannerFeature extends ComponentFeature implements l {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Gson f297385n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Keva f297386o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final ConcurrentHashMap<String, c> f297387p = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final CoroutineScope f297388h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f297389i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Job f297390j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f297391k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final b f297392l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Function1<String, Unit> f297393m;

    public static final class a {
    }

    public static final class b implements y.a<wc9.e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ActiveSwitchBannerFeature f297394a;

        public b(ActiveSwitchBannerFeature r100) {
            this.f297394a = r100;
        }

        @Override // com.larus.bmhome.chat.component.cvs.y.a
        public final void c(wc9.e r100) {
            Intrinsics.checkNotNullParameter(r100, "new");
            ActiveSwitchBannerFeature r101 = this.f297394a;
            if (r101.f297391k == false) goto L5;
            String r102 = "conversation_change";
        L6:
            r101.iw(r102);
            return;
        L5:
            r102 = "cold_start";
            goto L6
        }
    }

    static {
        f297385n = new Gson();
        f297386o = Keva.getRepo("active_switch_banner_cache");
        f297387p = new ConcurrentHashMap();
    }

    @Override // com.larus.bmhome.chat.banner.l
    public final c EE() {
        y r100 = (y) this.f297389i.getValue();
        Object r101 = null;
        if (r100 == null) goto L7;
        wc9.e r102 = r100.h();
        if (r102 == null) goto L7;
        String r103 = r102.f559198a;
    L8:
        String r104 = AccountService.f365697a.getUserId() + '_' + r103;
        c r105 = f297387p.get(r104);
        if (r105 == null) goto L11;
        return r105;
    L11:
        String r106 = f297386o.getString(r104, "");
        Intrinsics.checkNotNull(r106);
        if ((!StringsKt.isBlank(r106)) == true) goto L15;
        r106 = null;
    L15:
        if (r106 != null) goto L35;
        return null;
    L35:
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L19
        Object r108 = Result.m9449constructorimpl((c) f297385n.fromJson(r106, c.class));     // Catch: Throwable -> L19
    L22:
        if (Result.m9456isSuccessimpl(r108) == false) goto L26;
        c r109 = (c) r108;
        if (r109 == null) goto L26;
        f297387p.put(r104, r109);
    L26:
        Throwable r110 = Result.m9452exceptionOrNullimpl(r108);
        if (r110 == null) goto L30;
        FLogger.f375446a.w("ActiveSwitchBanner", "read cache failed, key=" + r104 + ", error=" + r110.getMessage());
        f297386o.erase(r104);
    L30:
        if (Result.m9455isFailureimpl(r108) == true) goto L34;
        r101 = r108;
    L34:
        return (c) r101;
    L19:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r103 = null;
        goto L8
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onCreate() {
        y r100 = (y) this.f297389i.getValue();
        if (r100 == null) goto L5;
        y.b.b(r100, this.f297392l);
    L5:
        CopyOnWriteArraySet<Function1<String, Unit>> r101 = j.f297400a;
        Function1<String, Unit> r102 = this.f297393m;
        Intrinsics.checkNotNullParameter(r102, "listener");
        j.f297400a.add(r102);
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onDestroy() {
        y r100 = (y) this.f297389i.getValue();
        if (r100 == null) goto L5;
        r100.lQ(this.f297392l);
    L5:
        CopyOnWriteArraySet<Function1<String, Unit>> r101 = j.f297400a;
        Function1<String, Unit> r102 = this.f297393m;
        Intrinsics.checkNotNullParameter(r102, "listener");
        j.f297400a.remove(r102);
        Job r103 = this.f297390j;
        if (r103 == null) goto L8;
        Job.DefaultImpls.cancel$default(r103, null, 1, null);
    L8:
        CoroutineScopeKt.cancel$default(this.f297388h, null, 1, null);
    }

    public ActiveSwitchBannerFeature() {
        this.f297388h = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        this.f297389i = LazyKt.lazy(new d(this));
        this.f297392l = new b(this);
        this.f297393m = new ActiveSwitchBannerFeature$cmdRefreshListener$1(this);
    }

    @Override // com.larus.bmhome.chat.banner.l
    public final void iw(final String r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        if (AccountService.f365697a.isLogin().booleanValue() == true) goto L5;
        return;
    L5:
        y r101 = (y) this.f297389i.getValue();
        if (r101 == null) goto L9;
        r101.Z7(new e(this, r100));
        return;
    }
}
