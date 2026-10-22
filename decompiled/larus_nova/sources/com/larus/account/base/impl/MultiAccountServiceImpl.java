package com.larus.account.base.impl;

import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.bytedance.sdk.account.impl.d0;
import com.google.gson.Gson;
import com.larus.account.base.api.AccountSwitchReason;
import com.larus.account.base.api.IAccountService;
import com.larus.account.base.api.ILoginService;
import com.larus.account.base.api.IMultiAccountService;
import com.larus.account.base.api.UserAction;
import com.larus.platform.api.IAccountRemovedCacheService;
import com.larus.settings.value.e10;
import com.larus.settings.value.is;
import com.larus.utils.l0;
import com.larus.utils.logger.FLogger;
import com.obric.sva.sdk.data.ISmModel;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.ttm.player.MediaPlayer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import org.json.JSONObject;
import tx9.g2;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u0002\b\u0007\u0018\u0000 ?2\u00020\u0001:\u0001?B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0017\u001a\u00020\u0012H\u0016J\b\u0010\u0018\u001a\u00020\u0012H\u0002J\u0010\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u001a\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J$\u0010!\u001a\u00020\u00122\b\u0010\"\u001a\u0004\u0018\u00010\u00152\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u001a\u0010#\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u00152\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0010\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u0010H\u0016J\u0010\u0010&\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u0010H\u0016J\u0018\u0010'\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020\u001bH\u0002Jn\u0010)\u001a\u00020\u00122d\u0010*\u001a`\u0012\u0013\u0012\u00110,¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0015\u0012\u0013\u0018\u00010\u001b¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(0\u0012\u0013\u0012\u001101¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(2\u0012\u0015\u0012\u0013\u0018\u00010\u001b¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(3\u0012\u0004\u0012\u00020\u00120+H\u0016J&\u00104\u001a\u00020\u00122\u000e\u00105\u001a\n\u0012\u0004\u0012\u000206\u0018\u00010\u00142\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u001208H\u0002J\u0016\u00109\u001a\u00020\u00122\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u001208H\u0002J(\u0010;\u001a\u0004\u0018\u00010\u00152\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u000e\b\u0002\u0010=\u001a\b\u0012\u0004\u0012\u00020\u001b0>H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lcom/larus/account/base/impl/MultiAccountServiceImpl;", "Lcom/larus/account/base/api/IMultiAccountService;", "<init>", "()V", "gson", "Lcom/google/gson/Gson;", "extraApi", "Lcom/bytedance/sdk/account/IBDAccountExtraApi;", "getExtraApi", "()Lcom/bytedance/sdk/account/IBDAccountExtraApi;", "extraApi$delegate", "Lkotlin/Lazy;", "accountScope", "Lkotlinx/coroutines/CoroutineScope;", "accountRemovedListeners", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Lcom/larus/account/base/api/IMultiAccountService$AccountRemovedListener;", "init", "", "getLocalAccountList", "", "Lcom/larus/account/base/model/AccountLocalItem;", "getCurrentAccount", "onLoginSuccess", "enforceMultiAccountMaxListNum", "onLogout", "secUserId", "", "switchToNextAfterLogout", "reason", "Lcom/larus/account/base/api/AccountSwitchReason;", "callback", "Lcom/larus/account/base/api/IAccountSwitchCallback;", "switchAccount", "targetAccount", "removeAccount", "addAccountRemovedListener", "listener", "removeAccountRemovedListener", "dispatchAccountRemoved", "userId", "fetchServerAccountList", "onResult", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "success", "rawJson", "", "errorCode", "errorMsg", "refreshMembershipInfoFromProfileMulti", "userInfos", "Lcom/larus/account/base/multi/PassportUserInfo;", "onFinish", "Lkotlin/Function0;", "dispatchFetchServerAccountListResult", "action", "findNextValidAccount", "accounts", "excludedSecUserIds", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MultiAccountServiceImpl implements IMultiAccountService {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f286128f = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Gson f286129b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f286130c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CoroutineScope f286131d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CopyOnWriteArraySet<IMultiAccountService.a> f286132e;

    public static final class a {
    }

    /* JADX INFO: loaded from: classes24.dex */
    public static final class b<T> implements Comparator {
        public b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues(Long.valueOf(((q38.b) r100).e()), Long.valueOf(((q38.b) r101).e()));
        }
    }

    /* JADX INFO: loaded from: classes24.dex */
    public static final class c<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Comparator f286133a;

        public c(b r100) {
            this.f286133a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            int r102 = this.f286133a.compare(r100, r101);
            if (r102 != 0) goto L14;
            String r103 = ((q38.b) r100).j();
            String r104 = "";
            if (r103 != null) goto L8;
            r103 = "";
        L8:
            String r105 = ((q38.b) r101).j();
            if (r105 == null) goto L13;
            r104 = r105;
        L13:
            return ComparisonsKt.compareValues(r103, r104);
        L14:
            return r102;
        }
    }

    /* JADX INFO: loaded from: classes24.dex */
    public static final class d extends ua7.a<xa7.c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MultiAccountServiceImpl f286134a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function4<Boolean, String, Integer, String, Unit> f286135b;

        @Override // ua7.a
        public final void onResponse(ua7.b r210) {
            xa7.c r100 = (xa7.c) r210;
            if (r100 != null) goto L5;
        L7:
            final boolean r101 = false;
        L8:
            if (r100 == null) goto L10;
            final int r110 = r100.f549253g;
        L11:
            if (r100 == null) goto L13;
            final String r111 = r100.f549255i;
        L14:
            if (r100 == null) goto L18;
            JSONObject r102 = r100.f549259m;
            if (r102 == null) goto L18;
            final String r103 = r102.toString();
        L19:
            if (r101 == true) goto L21;
            FLogger.f375446a.e("MultiAccountServiceImpl", "fetchServerAccountList fail, code=" + r110 + ", msg=" + r111);
            MultiAccountServiceImpl r104 = this.f286134a;
            final Function4<Boolean, String, Integer, String, Unit> r105 = this.f286135b;
            final boolean r106 = r101;
            final String r107 = r103;
            final int r108 = r110;
            final String r112 = r111;
            Function0 r109 = new z(r105, r106, r107, r108, r112);
            int r113 = MultiAccountServiceImpl.f286128f;
            r104.getClass();
            com.larus.utils.y.c(new y(r109));
            return;
        L21:
            MultiAccountServiceImpl r114 = this.f286134a;
            Result.Companion r115 = Result.Companion;     // Catch: Throwable -> L24
            Object r116 = Result.m9449constructorimpl((com.larus.account.base.multi.m) r114.f286129b.fromJson(r103, com.larus.account.base.multi.m.class));     // Catch: Throwable -> L24
        L27:
            if (Result.m9455isFailureimpl(r116) == false) goto L29;
            r116 = null;
        L29:
            com.larus.account.base.multi.m r117 = (com.larus.account.base.multi.m) r116;
            if (r117 == null) goto L36;
            com.larus.account.base.multi.l r118 = r117.a();
            if (r118 == null) goto L36;
            List<com.larus.account.base.multi.n> r119 = r118.a();
            if (r119 == null) goto L36;
            List r120 = CollectionsKt.filterNotNull(r119);
        L37:
            Gson r121 = com.larus.account.base.multi.d.f286213a;
            List r122 = r120;
            if (r122 != null) goto L40;
        L43:
            boolean r123 = true;
        L44:
            if (r123 == true) goto L107;
            Object r124 = com.larus.account.base.multi.d.f286215c;
            monitor-enter(r124);
            List<q38.b> r125 = com.larus.account.base.multi.d.f286216d;     // Catch: Throwable -> L129
            ArrayList r126 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r125, 10));     // Catch: Throwable -> L129
            Iterator<T> r127 = r125.iterator();     // Catch: Throwable -> L129
            int r128 = 0;
        L50:
            if (r127.hasNext() == false) goto L102;
            q38.b r129 = (q38.b) r127.next();     // Catch: Throwable -> L129
            Iterator r130 = r120.iterator();     // Catch: Throwable -> L129
        L53:
            if (r130.hasNext() == false) goto L57;
            Object r131 = r130.next();     // Catch: Throwable -> L129
            if (Intrinsics.areEqual(((com.larus.account.base.multi.n) r131).e(), r129.g()) == false) goto L53;
        L58:
            com.larus.account.base.multi.n r132 = (com.larus.account.base.multi.n) r131;     // Catch: Throwable -> L129
            if (r132 == null) goto L101;
            Integer r133 = r132.d();     // Catch: Throwable -> L129
            if (r133 == null) goto L64;
            int r134 = r133.intValue();     // Catch: Throwable -> L129
        L65:
            if (r134 <= 0) goto L67;
            boolean r135 = true;
        L68:
            com.larus.account.base.multi.f r136 = r132.b();     // Catch: Throwable -> L129
            if (r136 == null) goto L82;
            String r137 = r136.a();     // Catch: Throwable -> L129
            if (r137 == null) goto L82;
            if ((!StringsKt.isBlank(r137)) == true) goto L76;
            r137 = null;
        L76:
            if (r137 == null) goto L82;
            q38.b.a r138 = r129.i();     // Catch: Throwable -> L129
            if (r138 == null) goto L80;
            String r139 = r138.a();     // Catch: Throwable -> L129
        L81:
            q38.b.a r140 = new q38.b.a(r139, r137);     // Catch: Throwable -> L129
        L83:
            String r141 = r132.c();     // Catch: Throwable -> L129
            if (r141 != null) goto L86;
        L90:
            r141 = r129.c();     // Catch: Throwable -> L129
        L91:
            String r142 = r132.a();     // Catch: Throwable -> L129
            if (r142 != null) goto L94;
            r142 = r129.b();     // Catch: Throwable -> L129
        L94:
            String r143 = r142;
            if (r140 != null) goto L97;
            r140 = r129.i();     // Catch: Throwable -> L129
        L97:
            q38.b r144 = q38.b.a(r129, r141, r143, r140, r135, 0, false, null, null, false, 1987);     // Catch: Throwable -> L129
            if (Intrinsics.areEqual(r144, r129) == true) goto L100;
            r128 = r128 + 1;     // Catch: Throwable -> L129
        L100:
            r129 = r144;
            goto L101
        L86:
            if ((!StringsKt.isBlank(r141)) == true) goto L89;
            r141 = null;
        L89:
            if (r141 != null) goto L91;
        L80:
            r139 = null;
        L82:
            r140 = null;
            goto L83
        L67:
            r135 = false;
            goto L68
        L64:
            r134 = 0;
        L101:
            r126.add(r129);     // Catch: Throwable -> L129
            goto L50
        L57:
            r131 = null;
            goto L58
        L102:
            com.larus.account.base.multi.d.f286216d = CollectionsKt.toMutableList(r126);     // Catch: Throwable -> L129
            if (r128 <= 0) goto L105;
            com.larus.account.base.multi.d.d();     // Catch: Throwable -> L129
        L105:
            Unit r145 = Unit.INSTANCE;     // Catch: Throwable -> L129
            monitor-exit(r124);
        L129:
            th = move-exception;
            throw th;
        L107:
            final MultiAccountServiceImpl r146 = this.f286134a;
            final Function4<Boolean, String, Integer, String, Unit> r147 = this.f286135b;
            Function0 r148 = new a0(r146, r147, r101, r103, r110, r111);
            int r149 = MultiAccountServiceImpl.f286128f;
            r146.getClass();
            if (r120 == null) goto L121;
            ArrayList r150 = new ArrayList();
            Iterator r151 = r120.iterator();
        L111:
            if (r151.hasNext() == false) goto L120;
            String r152 = ((com.larus.account.base.multi.n) r151.next()).e();
            if (r152 != null) goto L115;
        L117:
            r152 = null;
        L118:
            if (r152 == null) goto L111;
            r150.add(r152);
            goto L111
        L115:
            if ((!StringsKt.isBlank(r152)) == false) goto L117;
        L120:
            List r153 = CollectionsKt.distinct(r150);
        L122:
            if (r153 != null) goto L125;
            r153 = CollectionsKt.emptyList();
        L125:
            if (r153.isEmpty() == false) goto L127;
            r148.invoke();
            return;
        L127:
            BuildersKt.launch$default(r146.f286131d, null, null, new MultiAccountServiceImpl$refreshMembershipInfoFromProfileMulti$1(r148, r153, null), 3, null);
            return;
        L121:
            r153 = null;
            goto L122
        L40:
            if (r122.isEmpty() == true) goto L43;
            r123 = false;
        L36:
            r120 = null;
        L24:
            th = move-exception;
            Result.Companion r154 = Result.Companion;
            r116 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        L18:
            r103 = null;
            goto L19
        L13:
            r111 = null;
            goto L14
        L10:
            r110 = -1;
            goto L11
        L5:
            if (r100.f549249c != true) goto L7;
            r101 = true;
            goto L8
        }

        /* JADX WARN: Multi-variable type inference failed */
        public d(MultiAccountServiceImpl r100, Function4<? super Boolean, ? super String, ? super Integer, ? super String, Unit> r101) {
            this.f286134a = r100;
            this.f286135b = r101;
        }
    }

    /* JADX INFO: loaded from: classes24.dex */
    public static final class e extends va7.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ q38.b f286136a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ MultiAccountServiceImpl f286137b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ q38.b f286138c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ n38.k f286139d;

        @Override // sa7.h
        public final void onSuccess(ua7.b r110) {
            Intrinsics.checkNotNullParameter(r110, "response");
            Gson r111 = com.larus.account.base.multi.d.f286213a;
            com.larus.account.base.multi.d.e(this.f286136a);
            MultiAccountServiceImpl r112 = this.f286137b;
            String r100 = this.f286136a.g();
            String r101 = "";
            if (r100 != null) goto L5;
            r100 = "";
        L5:
            String r102 = this.f286136a.j();
            if (r102 == null) goto L9;
            r101 = r102;
        L9:
            int r103 = MultiAccountServiceImpl.f286128f;
            r112.getClass();
            IAccountRemovedCacheService.f364774a.a(r100);
            Iterator<IMultiAccountService.a> r113 = r112.f286132e.iterator();
        L11:
            if (r113.hasNext() == false) goto L20;
            IMultiAccountService.a r104 = r113.next();
            Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L15
            r104.a(r100, r101);     // Catch: Throwable -> L15
            Object r106 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L15
        L17:
            Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
            if (r107 == null) goto L11;
            FLogger.f375446a.e("MultiAccountServiceImpl", "dispatchAccountRemoved failed: " + r107, r107);
        L15:
            th = move-exception;
            Result.Companion r108 = Result.Companion;
            r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L17
        L20:
            n38.b r114 = new n38.b(this.f286138c, this.f286136a, true, 0, null);
            n38.k r109 = this.f286139d;
            if (r109 == null) goto L31;
            r109.b(r114);
            return;
        }

        @Override // sa7.h
        public final void onError(ua7.b r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "response");
            String r102 = r100.f549255i;
            FLogger.f375446a.e("MultiAccountServiceImpl", "removeAccount by IBDAccountExtraApi fail, code=" + r101 + ", msg=" + r102);
            n38.b r103 = new n38.b(this.f286138c, this.f286136a, false, r101, r102);
            n38.k r104 = this.f286139d;
            if (r104 == null) goto L6;
            r104.a(r103);
            return;
        }

        public e(q38.b r100, MultiAccountServiceImpl r101, q38.b r102, n38.k r103) {
            this.f286136a = r100;
            this.f286137b = r101;
            this.f286138c = r102;
            this.f286139d = r103;
        }
    }

    /* JADX INFO: loaded from: classes24.dex */
    public static final class f extends va7.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ q38.b f286140a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ q38.b f286141b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AccountSwitchReason f286142c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ n38.k f286143d;

        @Override // sa7.h
        public final void onSuccess(ua7.b r210) {
            Intrinsics.checkNotNullParameter((xa7.j) r210, "response");
            Gson r100 = com.larus.account.base.multi.d.f286213a;
            q38.b r101 = this.f286140a;
            Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
            long r102 = System.currentTimeMillis();
            Object r103 = com.larus.account.base.multi.d.f286215c;
            monitor-enter(r103);
            List<q38.b> r104 = com.larus.account.base.multi.d.f286216d;     // Catch: Throwable -> L46
            ArrayList r105 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r104, 10));     // Catch: Throwable -> L46
            Iterator<T> r106 = r104.iterator();     // Catch: Throwable -> L46
        L6:
            if (r106.hasNext() == false) goto L14;
            q38.b r107 = (q38.b) r106.next();     // Catch: Throwable -> L46
            if (Intrinsics.areEqual(r107.g(), r101.g()) == false) goto L11;
            r107 = q38.b.a(r107, null, null, null, false, Math.max(r107.e(), r102), true, null, null, true, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_ABI_VERSION);     // Catch: Throwable -> L46
        L13:
            r105.add(r107);     // Catch: Throwable -> L46
            goto L6
        L11:
            if (r107.k() == false) goto L13;
            r107 = q38.b.a(r107, null, null, null, false, 0, false, null, null, false, 1023);     // Catch: Throwable -> L46
            goto L13
        L14:
            com.larus.account.base.multi.d.f286216d = CollectionsKt.toMutableList(r105);     // Catch: Throwable -> L46
            com.larus.account.base.multi.d.d();     // Catch: Throwable -> L46
            Unit r108 = Unit.INSTANCE;     // Catch: Throwable -> L46
            monitor-exit(r103);
            q38.b r109 = this.f286141b;
            if (r109 == null) goto L21;
            String r110 = r109.g();
            if (r110 == null) goto L21;
            q38.b r111 = com.larus.account.base.multi.d.b(r110);
        L22:
            q38.b r112 = com.larus.account.base.multi.d.b(this.f286140a.g());
            if (r112 != null) goto L25;
            r112 = this.f286140a;
        L25:
            n38.b r113 = new n38.b(r111, r112, true, 0, null, this.f286142c);
            if (this.f286142c.isLogout() == true) goto L41;
            if (r111 != null) goto L29;
            r111 = this.f286141b;
        L29:
            m38.a r114 = m38.a.f511783a;
            UserAction r115 = UserAction.ACCOUNT_SWITCH;
            if (r111 == null) goto L32;
            String r116 = r111.j();
        L33:
            if (r116 != null) goto L35;
            r116 = "";
        L35:
            if (r111 == null) goto L37;
            String r117 = r111.g();
        L38:
            if (r117 != null) goto L40;
            r117 = "";
        L40:
            n38.c r118 = new n38.c(r116, r117);
            r114.getClass();
            m38.a.d("logout_by_account_switch", r115, r118);
            goto L41
        L37:
            r117 = null;
            goto L38
        L32:
            r116 = null;
        L41:
            m38.a r119 = m38.a.f511783a;
            UserAction r120 = UserAction.ACCOUNT_SWITCH;
            r119.getClass();
            m38.a.b("login_by_account_switch", null, r120);
            n38.k r121 = this.f286143d;
            if (r121 == null) goto L44;
            r121.b(r113);
        L44:
            g2.h(this.f286142c.getEnterMethod(), "1", null, null, 121);
            return;
        L21:
            r111 = null;
        L46:
            th = move-exception;
            throw th;
        }

        @Override // sa7.h
        public final void onError(ua7.b r100, int r110) {
            xa7.j r101 = (xa7.j) r100;
            Intrinsics.checkNotNullParameter(r101, "response");
            String r102 = r101.f549255i;
            FLogger.f375446a.e("MultiAccountServiceImpl", "switchAccount by IBDAccountExtraApi fail, code=" + r110 + ", msg=" + r102);
            n38.b r103 = new n38.b(this.f286141b, this.f286140a, false, r110, r102, this.f286142c);
            n38.k r104 = this.f286143d;
            if (r104 == null) goto L5;
            r104.a(r103);
        L5:
            g2.h(this.f286142c.getEnterMethod(), "0", String.valueOf(r110), r102, 97);
        }

        public f(q38.b r100, q38.b r101, AccountSwitchReason r102, n38.k r103) {
            this.f286140a = r100;
            this.f286141b = r101;
            this.f286142c = r102;
            this.f286143d = r103;
        }
    }

    /* JADX INFO: loaded from: classes24.dex */
    public static final class g implements n38.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n38.k f286144a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ q38.b f286145b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ MultiAccountServiceImpl f286146c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ List<q38.b> f286147d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Set<String> f286148e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ AccountSwitchReason f286149f;

        @Override // n38.k
        public final void a(n38.b r100) {
            Intrinsics.checkNotNullParameter(r100, "result");
            int r101 = r100.f516990d;
            String r102 = null;
            if (r101 != 1) goto L5;
        L14:
            FLogger r103 = FLogger.f375446a;
            StringBuilder r104 = new StringBuilder("switch to ");
            q38.b r105 = r100.f516988b;
            if (r105 == null) goto L17;
            r102 = r105.j();
        L17:
            r104.append(r102);
            r104.append(" failed, code = ");
            r104.append(r100.f516990d);
            r104.append(", try next candidate");
            r103.i("MultiAccountServiceImpl", r104.toString());
            Gson r106 = com.larus.account.base.multi.d.f286213a;
            com.larus.account.base.multi.d.e(this.f286145b);
            MultiAccountServiceImpl.k(this.f286146c, this.f286147d, this.f286148e, this.f286144a, this.f286149f, r100);
            return;
        L5:
            if (r101 == 4) goto L14;
            if (r101 == 1011) goto L14;
            FLogger r107 = FLogger.f375446a;
            StringBuilder r108 = new StringBuilder("switch to ");
            q38.b r109 = r100.f516988b;
            if (r109 == null) goto L11;
            r102 = r109.j();
        L11:
            r108.append(r102);
            r108.append(" failed, code = ");
            r108.append(r100.f516990d);
            r108.append(", Abort");
            r107.i("MultiAccountServiceImpl", r108.toString());
            n38.k r110 = this.f286144a;
            if (r110 == null) goto L19;
            r110.a(r100);
            return;
        }

        @Override // n38.k
        public final void b(n38.b r100) {
            Intrinsics.checkNotNullParameter(r100, "result");
            n38.k r101 = this.f286144a;
            if (r101 == null) goto L6;
            r101.b(r100);
            return;
        }

        public g(n38.k r100, q38.b r101, MultiAccountServiceImpl r102, List<q38.b> r103, Set<String> r104, AccountSwitchReason r105) {
            this.f286144a = r100;
            this.f286145b = r101;
            this.f286146c = r102;
            this.f286147d = r103;
            this.f286148e = r104;
            this.f286149f = r105;
        }
    }

    static {
    }

    @Override // com.larus.account.base.api.IMultiAccountService
    public final void init() {
        if (ILoginService.f286097a.getAccountInfo().f531528a == false) goto L52;
        sc7.a r100 = com.bytedance.sdk.account.impl.h.a().l();
        r38.b r101 = IAccountService.f286094a.getUserInfo();
        Gson r102 = com.larus.account.base.multi.d.f286213a;
        Intrinsics.checkNotNull(r100);
        Intrinsics.checkNotNullParameter(r100, "accountUserInfo");
        Object r103 = com.larus.account.base.multi.d.f286215c;
        monitor-enter(r103);
        List<q38.b> r104 = com.larus.account.base.multi.d.f286216d;     // Catch: Throwable -> L49
        if ((r104 instanceof Collection) == true) goto L9;
    L11:
        Iterator<T> r105 = r104.iterator();     // Catch: Throwable -> L49
    L13:
        if (r105.hasNext() == false) goto L17;
        if (Intrinsics.areEqual(((q38.b) r105.next()).g(), r100.f541370k) == false) goto L13;
        boolean r106 = true;
    L18:
        if (r106 == true) goto L46;
        FLogger.f375446a.i("AccountLocalStore", "try add local store for current user " + r100.f541360a);     // Catch: Throwable -> L49
        long r110 = System.currentTimeMillis();     // Catch: Throwable -> L49
        String r107 = String.valueOf(r100.f541360a);     // Catch: Throwable -> L49
        String r111 = r100.f541370k;     // Catch: Throwable -> L49
        JSONObject r108 = r100.f541374o;     // Catch: Throwable -> L49
        r38.a r109 = null;
        if (r108 == null) goto L22;
        String r112 = r108.optString("screen_name");     // Catch: Throwable -> L49
    L23:
        JSONObject r113 = r100.f541374o;     // Catch: Throwable -> L49
        if (r113 == null) goto L26;
        String r114 = r113.optString("avatar_url");     // Catch: Throwable -> L49
    L27:
        Gson r115 = com.larus.account.base.multi.d.f286213a;     // Catch: Throwable -> L49
        if (r101 == null) goto L30;
        r109 = r101.e();     // Catch: Throwable -> L49
    L30:
        q38.b.a r116 = com.larus.account.base.multi.d.f(r109);     // Catch: Throwable -> L49
        JSONObject r117 = r100.f541374o;     // Catch: Throwable -> L49
        if (r117 != null) goto L33;
    L35:
        boolean r118 = false;
    L36:
        if (r118 == true) goto L38;
        boolean r119 = true;
    L39:
        q38.b r120 = new q38.b(r107, r111, r112, r114, r116, r119, r110, true, true, ISmModel.VERSION_0300);     // Catch: Throwable -> L49
        int r121 = com.larus.account.base.multi.d.f286216d.size();     // Catch: Throwable -> L49
        int r122 = 0;
    L40:
        if (r122 >= r121) goto L45;
        q38.b r123 = com.larus.account.base.multi.d.f286216d.get(r122);     // Catch: Throwable -> L49
        if (r123.k() == false) goto L44;
        com.larus.account.base.multi.d.f286216d.set(r122, q38.b.a(r123, null, null, null, false, 0, false, null, null, false, 1023));     // Catch: Throwable -> L49
    L44:
        r122 = r122 + 1;     // Catch: Throwable -> L49
        goto L40
    L45:
        com.larus.account.base.multi.d.f286216d.add(0, r120);     // Catch: Throwable -> L49
        com.larus.account.base.multi.d.d();     // Catch: Throwable -> L49
        goto L46
    L38:
        r119 = false;
        goto L39
    L33:
        if (r117.optInt("passport_enterprise_user_type") != 0) goto L35;
        r118 = true;
        goto L36
    L26:
        r114 = null;
        goto L27
    L22:
        r112 = null;
    L46:
        Unit r124 = Unit.INSTANCE;     // Catch: Throwable -> L49
        monitor-exit(r103);
        return;
    L17:
        r106 = false;
        goto L18
    L9:
        if (r104.isEmpty() == false) goto L11;
    L49:
        th = move-exception;
        throw th;
    }

    public final void j() {
        e10 r100 = e10.f368561a;
        int r101 = l0.f375430a;
        int r102 = ((Number) l0.a(20, new is())).intValue();
        if (r102 > 0) goto L5;
        return;
    L5:
        Object r103 = com.larus.account.base.multi.d.f286215c;
        monitor-enter(r103);
        int r104 = com.larus.account.base.multi.d.f286216d.size();     // Catch: Throwable -> L21
        monitor-exit(r103);
        if (r104 > r102) goto L11;
        return;
    L11:
        if (r104 <= r102) goto L20;
        List r105 = com.larus.account.base.multi.d.a();
        q38.b r106 = com.larus.account.base.multi.d.c();
        if (r106 == null) goto L15;
        final String r107 = r106.g();
    L16:
        final q38.b r108 = (q38.b) SequencesKt.minWithOrNull(SequencesKt.filter(SequencesKt.filter(CollectionsKt.asSequence(r105), new v()), new w(r107)), new c(new b()));
        if (r108 == null) goto L18;
        com.larus.account.base.multi.d.e(r108);
        ThreadPlus.submitRunnable(new x(this, r108));
        r104 = r104 - 1;
        goto L11
    L18:
        return;
    L15:
        r107 = null;
        goto L16
    L20:
        return;
    L21:
        th = move-exception;
        throw th;
    }

    public MultiAccountServiceImpl() {
        this.f286129b = new Gson();
        this.f286130c = LazyKt.lazy(new u());
        this.f286131d = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        this.f286132e = new CopyOnWriteArraySet();
    }

    @Override // com.larus.account.base.api.IMultiAccountService
    public final q38.b c() {
        return com.larus.account.base.multi.d.c();
    }

    @Override // com.larus.account.base.api.IMultiAccountService
    public final List<q38.b> g() {
        return com.larus.account.base.multi.d.a();
    }

    @Override // com.larus.account.base.api.IMultiAccountService
    public final void onLoginSuccess() {
        sc7.a r100 = com.bytedance.sdk.account.impl.h.a().l();
        r38.b r101 = IAccountService.f286094a.getUserInfo();
        q38.b r102 = com.larus.account.base.multi.d.c();
        if (r102 == null) goto L11;
        FLogger.f375446a.i("MultiAccountServiceImpl", "Login from add account, dispatch previous account offline, previous = " + r102.j() + ", new = " + r100.f541360a);
        m38.a r103 = m38.a.f511783a;
        UserAction r104 = UserAction.ACCOUNT_SWITCH;
        String r105 = r102.j();
        if (r105 != null) goto L7;
        r105 = "";
    L7:
        String r106 = r102.g();
        if (r106 != null) goto L10;
        r106 = "";
    L10:
        n38.c r107 = new n38.c(r105, r106);
        r103.getClass();
        m38.a.d("logout_by_account_switch", r104, r107);
    L12:
        Intrinsics.checkNotNull(r100);
        Intrinsics.checkNotNullParameter(r100, "accountUserInfo");
        long r110 = System.currentTimeMillis();
        if (r101 == null) goto L15;
        r38.a r108 = r101.e();
    L16:
        final q38.b.a r109 = com.larus.account.base.multi.d.f(r108);
        ThreadPlus.submitRunnable(new com.larus.account.base.multi.b(r109));
        String r111 = String.valueOf(r100.f541360a);
        String r112 = r100.f541370k;
        JSONObject r113 = r100.f541374o;
        if (r113 == null) goto L19;
        String r114 = r113.optString("screen_name");
    L20:
        JSONObject r115 = r100.f541374o;
        if (r115 == null) goto L23;
        String r116 = r115.optString("avatar_url");
    L24:
        JSONObject r117 = r100.f541374o;
        boolean r118 = false;
        if (r117 != null) goto L27;
    L29:
        boolean r119 = false;
    L30:
        long r210 = r110;
        q38.b r120 = new q38.b(r111, r112, r114, r116, r109, !r119, r110, true, true, ISmModel.VERSION_0300);
        Object r121 = com.larus.account.base.multi.d.f286215c;
        monitor-enter(r121);
        List<q38.b> r122 = com.larus.account.base.multi.d.f286216d;     // Catch: Throwable -> L63
        ArrayList r123 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r122, 10));     // Catch: Throwable -> L63
        Iterator<T> r124 = r122.iterator();     // Catch: Throwable -> L63
    L34:
        if (r124.hasNext() == false) goto L56;
        q38.b r310 = (q38.b) r124.next();     // Catch: Throwable -> L63
        if (Intrinsics.areEqual(r310.g(), r120.g()) == true) goto L38;
        long r125 = r210;
        if (r310.k() == false) goto L54;
        r310 = q38.b.a(r310, null, null, null, false, 0, false, null, null, false, 1023);     // Catch: Throwable -> L63
    L54:
        q38.b r126 = r310;
    L55:
        r123.add(r126);     // Catch: Throwable -> L63
        r210 = r125;
        goto L34
    L38:
        if (r120.l() == false) goto L43;
        q38.b.a r127 = r120.i();     // Catch: Throwable -> L63
        if (r127 != null) goto L42;
        r127 = r310.i();     // Catch: Throwable -> L63
    L42:
        q38.b.a r128 = r127;
    L44:
        String r129 = r120.c();     // Catch: Throwable -> L63
        if (r129 != null) goto L47;
        r129 = r310.c();     // Catch: Throwable -> L63
    L47:
        String r130 = r129;
        String r131 = r120.b();     // Catch: Throwable -> L63
        if (r131 != null) goto L50;
        r131 = r310.b();     // Catch: Throwable -> L63
    L50:
        r125 = r210;
        r126 = q38.b.a(r120, r130, r131, r128, r120.l(), Math.max(r310.e(), r125), false, r310.h(), r310.f(), false, 1155);     // Catch: Throwable -> L63
        r118 = true;
        goto L55
    L43:
        r128 = null;
        goto L44
    L56:
        List<q38.b> r132 = CollectionsKt.toMutableList(r123);     // Catch: Throwable -> L63
        com.larus.account.base.multi.d.f286216d = r132;     // Catch: Throwable -> L63
        if (r118 == true) goto L59;
        r132.add(r120);     // Catch: Throwable -> L63
    L59:
        com.larus.account.base.multi.d.d();     // Catch: Throwable -> L63
        Unit r133 = Unit.INSTANCE;     // Catch: Throwable -> L63
        monitor-exit(r121);
        j();
        return;
    L63:
        th = move-exception;
        throw th;
    L27:
        if (r117.optInt("passport_enterprise_user_type") != 0) goto L29;
        r119 = true;
        goto L30
    L23:
        r116 = null;
        goto L24
    L19:
        r114 = null;
        goto L20
    L15:
        r108 = null;
        goto L16
    L11:
        FLogger.f375446a.i("MultiAccountServiceImpl", "Login from no user, new = " + r100.f541360a);
        goto L12
    }

    @Override // com.larus.account.base.api.IMultiAccountService
    public final void b(IMultiAccountService.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f286132e.remove(r100);
    }

    @Override // com.larus.account.base.api.IMultiAccountService
    public final void f(Function4<? super Boolean, ? super String, ? super Integer, ? super String, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "onResult");
        FLogger.f375446a.i("MultiAccountServiceImpl", "fetchServerAccountList via /passport/account/list/");
        ta7.j r101 = d0.c();
        d0 r102 = (d0) r101;
        r102.b("/passport/account/list/", null, null, new d(this, r100));
    }

    @Override // com.larus.account.base.api.IMultiAccountService
    public final void h(String r110) {
        Intrinsics.checkNotNullParameter(r110, "secUserId");
        if ((!StringsKt.isBlank(r110)) == false) goto L5;
        q38.b r100 = new q38.b(null, r110, null, null, null, false, 0, false, false, 2045);
    L8:
        com.larus.account.base.multi.d.e(r100);
        return;
    L5:
        r100 = com.larus.account.base.multi.d.c();
        if (r100 != null) goto L8;
    }

    @Override // com.larus.account.base.api.IMultiAccountService
    public final void i(IMultiAccountService.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f286132e.add(r100);
    }

    @Override // com.larus.account.base.api.IMultiAccountService
    public final void a(q38.b r100, n38.k r101) {
        Intrinsics.checkNotNullParameter(r100, "targetAccount");
        q38.b r102 = com.larus.account.base.multi.d.c();
        String r103 = r100.j();
        boolean r104 = true;
        if (r103 != null) goto L5;
    L8:
        boolean r105 = true;
    L9:
        if (r105 == true) goto L20;
        String r106 = r100.g();
        if (r106 != null) goto L13;
    L16:
        if (r104 == true) goto L20;
        FLogger.f375446a.i("MultiAccountServiceImpl", "removeAccount by IBDAccountExtraApi userId=" + r100.j() + ", secUserId=" + r100.g());
        ((sa7.j) this.f286130c.getValue()).i(r100.j(), new e(r100, this, r102, r101));
        return;
    L13:
        if (r106.length() == 0) goto L16;
        r104 = false;
    L20:
        n38.b r107 = new n38.b(r102, r100, false, -1, "userId or secUserId is empty");
        if (r101 == null) goto L24;
        r101.a(r107);
        return;
    L24:
        return;
    L5:
        if (r103.length() == 0) goto L8;
        r105 = false;
        goto L9
    }

    @Override // com.larus.account.base.api.IMultiAccountService
    public final void d(AccountSwitchReason r100, com.larus.login.impl.multiaccount.g r101) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        k(this, com.larus.account.base.multi.d.a(), new LinkedHashSet(), r101, r100, null);
    }

    @Override // com.larus.account.base.api.IMultiAccountService
    public final void e(q38.b r110, n38.k r111, AccountSwitchReason r112) {
        Intrinsics.checkNotNullParameter(r112, "reason");
        q38.b r100 = com.larus.account.base.multi.d.c();
        if (r110 == null) goto L22;
        String r101 = r110.j();
        boolean r102 = true;
        if (r101 != null) goto L7;
    L10:
        boolean r103 = true;
    L11:
        if (r103 == true) goto L22;
        String r104 = r110.g();
        if (r104 != null) goto L15;
    L18:
        if (r102 == true) goto L22;
        FLogger.f375446a.i("MultiAccountServiceImpl", "switchAccount by IBDAccountExtraApi to userId=" + r110.j() + ", secUserId=" + r110.g());
        ((sa7.j) this.f286130c.getValue()).h(r110.g(), MapsKt.emptyMap(), new f(r110, r100, r112, r111));
        return;
    L15:
        if (r104.length() == 0) goto L18;
        r102 = false;
        goto L18
    L7:
        if (r101.length() == 0) goto L10;
        r103 = false;
    L22:
        FLogger.f375446a.w("MultiAccountServiceImpl", "invalid target: " + r110);
        r111.a(new n38.b(r100, r110, false, -1, "target account or target id is empty", r112));
        g2.h(r112.getEnterMethod(), "0", String.valueOf(-1), "target account or target id is empty", 97);
    }

    public static final void k(MultiAccountServiceImpl r100, List<q38.b> r110, Set<String> r111, n38.k r112, AccountSwitchReason r113, n38.b r114) {
        r100.getClass();
        q38.b r101 = null;
        Object r102 = null;
        if (r110.isEmpty() == true) goto L17;
        Iterator<T> r103 = r110.iterator();
    L7:
        if (r103.hasNext() == false) goto L16;
        Object r104 = r103.next();
        q38.b r105 = (q38.b) r104;
        if (CollectionsKt.contains(r111, r105.g()) == false) goto L11;
    L13:
        boolean r106 = false;
    L14:
        if (r106 == false) goto L7;
        r102 = r104;
        goto L16
    L11:
        if (r105.d() == false) goto L13;
        r106 = true;
    L16:
        r101 = (q38.b) r102;
    L17:
        if (r101 != null) goto L24;
        FLogger.f375446a.i("MultiAccountServiceImpl", "no available account to switch after logout");
        if (r112 == null) goto L34;
        if (r114 != null) goto L22;
        r114 = new n38.b(com.larus.account.base.multi.d.c(), null, false, -1, "no available account to switch", r113);
    L22:
        r112.a(r114);
        return;
    L34:
        return;
    L24:
        String r115 = r101.g();
        if (r115 == null) goto L27;
        r111.add(r115);
    L27:
        r100.e(r101, new g(r112, r101, r100, r110, r111, r113), r113);
    }
}
