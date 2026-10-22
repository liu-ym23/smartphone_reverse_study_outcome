package com.larus.common.account.bdauth.repository;

import android.content.Context;
import android.os.Bundle;
import com.larus.account.base.api.AccountSwitchReason;
import com.larus.account.base.api.IAccountService;
import com.larus.account.base.api.ILoginService;
import com.larus.account.base.api.IMultiAccountService;
import com.larus.account.base.model.profile.AvatarInfo;
import com.larus.common.account.bdauth.model.CustomBDAuthorizeModel;
import com.larus.nova.view.FlowBDAuthorizeActivity$authorizeViewModel$2$1;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import com.obric.sva.sdk.data.ISmModel;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes27.dex */
public final class BDAuthorizeRepository {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f325917a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final vz8.a f325918b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k f325919c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f325920d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f325921e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.larus.common.account.bdauth.repository.a f325922f;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final za7.c f325923a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f325923a, ((a) r100).f325923a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            za7.c r100 = this.f325923a;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "AuthInfoResult(response=" + this.f325923a + ')';
        }

        public a(za7.c r100) {
            this.f325923a = r100;
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f325924a = null;

        static {
            int[] r100 = new int[BDAuthorizeBlockingErrorType.values().length];
            r100[BDAuthorizeBlockingErrorType.MinorMode.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[BDAuthorizeBlockingErrorType.EnterpriseAccount.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f325924a = r100;
        }
    }

    public static final class c<T> implements Comparator {
        public c() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            if (((com.larus.common.account.bdauth.repository.a) r100).f325932f == false) goto L5;
            int r102 = 1;
        L7:
            if (((com.larus.common.account.bdauth.repository.a) r101).f325932f == false) goto L9;
            int r103 = 1;
        L11:
            return ComparisonsKt.compareValues(r102, r103);
        L9:
            r103 = 0;
            goto L11
        L5:
            r102 = 0;
            goto L7
        }
    }

    public static final class d<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Comparator f325925a;

        public d(e r100) {
            this.f325925a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            int r102 = this.f325925a.compare(r100, r101);
            if (r102 != 0) goto L14;
            String r103 = ((com.larus.common.account.bdauth.repository.a) r100).f325927a;
            String r104 = "";
            if (r103 != null) goto L8;
            r103 = "";
        L8:
            String r105 = ((com.larus.common.account.bdauth.repository.a) r101).f325927a;
            if (r105 == null) goto L13;
            r104 = r105;
        L13:
            return ComparisonsKt.compareValues(r103, r104);
        L14:
            return r102;
        }
    }

    public static final class e<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Comparator f325926a;

        public e(c r100) {
            this.f325926a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            int r102 = this.f325926a.compare(r100, r101);
            if (r102 == 0) goto L6;
            return r102;
        L6:
            return ComparisonsKt.compareValues(Long.valueOf(((com.larus.common.account.bdauth.repository.a) r101).f325935i), Long.valueOf(((com.larus.common.account.bdauth.repository.a) r100).f325935i));
        }
    }

    public static List h(List r100) {
        if (r100.isEmpty() == true) goto L5;
        List r101 = r100;
        Iterator r102 = r101.iterator();
    L8:
        if (r102.hasNext() == false) goto L19;
        Object r103 = r102.next();
        com.larus.common.account.bdauth.repository.a r104 = (com.larus.common.account.bdauth.repository.a) r103;
        if (r104.f325934h == true) goto L12;
    L16:
        boolean r105 = false;
    L17:
        if (r105 == false) goto L8;
    L20:
        com.larus.common.account.bdauth.repository.a r106 = (com.larus.common.account.bdauth.repository.a) r103;
        ArrayList r107 = new ArrayList();
        Iterator r108 = r101.iterator();
    L22:
        if (r108.hasNext() == false) goto L30;
        Object r109 = r108.next();
        String r110 = ((com.larus.common.account.bdauth.repository.a) r109).f325928b;
        if (r106 == null) goto L26;
        String r111 = r106.f325928b;
    L28:
        if (Intrinsics.areEqual(r110, r111) == true) goto L22;
        r107.add(r109);
        goto L22
    L26:
        r111 = null;
        goto L28
    L30:
        List r112 = CollectionsKt.sortedWith(r107, new d(new e(new c())));
        List r113 = CollectionsKt.createListBuilder();
        if (r106 == null) goto L33;
        r113.add(r106);
    L33:
        r113.addAll(r112);
        return CollectionsKt.build(r113);
    L12:
        if (r104.f325933g == false) goto L16;
        if (r104.f325932f == true) goto L16;
        r105 = true;
        goto L17
    L19:
        r103 = null;
        goto L20
    L5:
        return CollectionsKt.emptyList();
    }

    public static com.larus.common.account.bdauth.repository.a l(q38.b r110) {
        String r100 = r110.g();
        String r101 = null;
        if (r100 != null) goto L5;
    L18:
        return null;
    L5:
        if ((!StringsKt.isBlank(r100)) == false) goto L7;
        String r102 = r100;
    L8:
        if (r102 == null) goto L18;
        String r103 = r110.j();
        String r104 = r110.c();
        if (r104 != null) goto L13;
        r104 = "";
    L13:
        String r105 = r104;
        String r106 = r110.b();
        q38.b.a r107 = r110.i();
        if (r107 == null) goto L17;
        r101 = r107.b();
    L17:
        return new com.larus.common.account.bdauth.repository.a(r103, r102, r105, r106, r101, r110.l(), r110.d(), r110.k(), r110.e());
    L7:
        r102 = null;
        goto L8
    }

    public final Object c(Continuation<? super com.larus.common.account.bdauth.repository.a> r110) {
        if ((r110 instanceof BDAuthorizeRepository$buildFallbackCurrentAccount$1) == false) goto L7;
        BDAuthorizeRepository$buildFallbackCurrentAccount$1 r100 = (BDAuthorizeRepository$buildFallbackCurrentAccount$1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        String r105 = null;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        String r106 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);
        String r107 = r106;
    L26:
        r38.b r108 = (r38.b) r102;
        FLogger.f375446a.d("BDAuthorizeRepository", "1. [buildFallbackCurrentAccount]: secUserId=" + r107 + ", userInfo=" + r108);
        if (r108 == null) goto L35;
        String r109 = r108.d();
        if (r109 == null) goto L35;
        if ((!StringsKt.isBlank(r109)) == true) goto L34;
        r109 = null;
    L34:
        if (r109 == null) goto L35;
    L44:
        String r111 = r109;
        if (r108 == null) goto L52;
        AvatarInfo r112 = r108.a();
        if (r112 == null) goto L52;
        String r113 = r112.a();
        if (r113 == null) goto L52;
    L51:
        String r114 = r113;
    L57:
        ILoginService.Companion r115 = ILoginService.f286097a;
        String r116 = r115.getAccountInfo().f531530c;
        if (r108 == null) goto L63;
        r38.a r117 = r108.e();
        if (r117 == null) goto L63;
        r105 = r117.b();
    L63:
        return new com.larus.common.account.bdauth.repository.a(r116, r107, r111, r114, r105, r115.getAccountInfo().f531534g, true, true, System.currentTimeMillis());
    L52:
        if (r108 == null) goto L56;
        AvatarInfo r118 = r108.a();
        if (r118 == null) goto L56;
        r113 = r118.b();
    L56:
        r114 = null;
    L35:
        if (r108 == null) goto L41;
        r109 = r108.g();
        if (r109 == null) goto L41;
        if ((!StringsKt.isBlank(r109)) == false) goto L41;
    L42:
        if (r109 != null) goto L44;
        r109 = "";
    L41:
        r109 = null;
        goto L42
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        String r119 = ILoginService.f286097a.getAccountInfo().f531531d;
        if (r119 != null) goto L17;
    L64:
        return null;
    L17:
        if ((!StringsKt.isBlank(r119)) == true) goto L20;
        r119 = null;
    L20:
        if (r119 == null) goto L64;
        r100.L$0 = r119;
        r100.label = 1;
        Object r120 = d(r100);
        if (r120 != r103) goto L25;
        return r103;
    L25:
        r107 = r119;
        r102 = r120;
    L7:
        r100 = new BDAuthorizeRepository$buildFallbackCurrentAccount$1(this, r110);
        goto L8
    }

    public final Object d(Continuation<? super r38.b> r100) {
        if ((r100 instanceof BDAuthorizeRepository$ensureCurrentUserProfileIfNeeded$1) == false) goto L7;
        BDAuthorizeRepository$ensureCurrentUserProfileIfNeeded$1 r101 = (BDAuthorizeRepository$ensureCurrentUserProfileIfNeeded$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L18;
        if (r105 == 1) goto L17;
        if (r105 == 2) goto L16;
        if (r105 != 3) goto L15;
        ResultKt.throwOnFailure(r103);
    L39:
        return r103;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r103);
    L36:
        r101.label = 3;
        r103 = BuildersKt.withContext(Dispatchers.getIO(), new BDAuthorizeRepository$requestUserInfoFromRemote$2(null), r101);
        if (r103 != r104) goto L39;
        return r104;
    L17:
        ResultKt.throwOnFailure(r103);
    L27:
        r38.b r106 = (r38.b) r103;
        if (r106 == null) goto L30;
        return r106;
    L30:
        r101.label = 2;
        Object r107 = BuildersKt.withContext(Dispatchers.getIO(), new BDAuthorizeRepository$createDefaultUserInfo$2(null), r101);
        if (r107 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L34;
        r107 = Unit.INSTANCE;
    L34:
        if (r107 != r104) goto L36;
        return r104;
    L18:
        ResultKt.throwOnFailure(r103);
        if (AccountService.f365697a.isLogin().booleanValue() == true) goto L21;
        return null;
    L21:
        r38.b r108 = IAccountService.f286094a.getUserInfo();
        if (r108 == null) goto L24;
        return r108;
    L24:
        r101.label = 1;
        r103 = BuildersKt.withContext(Dispatchers.getIO(), new BDAuthorizeRepository$requestUserInfoFromRemote$2(null), r101);
        if (r103 != r104) goto L27;
        return r104;
    L7:
        r101 = new BDAuthorizeRepository$ensureCurrentUserProfileIfNeeded$1(this, r100);
        goto L8
    }

    public BDAuthorizeRepository(Context r100, FlowBDAuthorizeActivity$authorizeViewModel$2$1.a r101) {
        CustomBDAuthorizeModel r102 = new CustomBDAuthorizeModel(r100);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "authorizeModel");
        Intrinsics.checkNotNullParameter(r101, "sceneRestorer");
        this.f325917a = r100;
        this.f325918b = r102;
        this.f325919c = r101;
        this.f325920d = LazyKt.lazy(new g());
        this.f325921e = LazyKt.lazy(new h());
    }

    public static void a(fb7.d r100, int r101) {
        if (r100.f476269c != null) goto L5;
        r100.f476269c = new Bundle();
    L5:
        r100.f476269c.putInt("response_type", r101);
    }

    public static Object k(com.larus.common.account.bdauth.repository.a r110, ContinuationImpl r111) {
        kotlinx.coroutines.j r100 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r111), 1);
        r100.C();
        IMultiAccountService.Companion r101 = IMultiAccountService.f286100a;
        String r102 = r110.f325927a;
        String r103 = r110.f325928b;
        String r104 = r110.f325929c;
        String r105 = r110.f325930d;
        String r106 = r110.f325931e;
        if (r106 == null) goto L5;
        q38.b.a r107 = new q38.b.a(r106, 1);
    L6:
        r101.e(new q38.b(r102, r103, r104, r105, r107, r110.f325932f, r110.f325935i, r110.f325933g, r110.f325934h, ISmModel.VERSION_0300), new j(r100), AccountSwitchReason.UNKNOWN);
        Object r108 = r100.B();
        if (r108 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L9;
        DebugProbesKt.probeCoroutineSuspended(r111);
    L9:
        return r108;
    L5:
        r107 = null;
        goto L6
    }

    public final Object e(fb7.c r110, Continuation<? super f> r111) {
        fb7.c r100 = r110;
        if ((r111 instanceof BDAuthorizeRepository$prepareAuthorize$1) == false) goto L7;
        BDAuthorizeRepository$prepareAuthorize$1 r101 = (BDAuthorizeRepository$prepareAuthorize$1) r111;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        Object r112 = null;
        if (r105 == 0) goto L20;
        if (r105 == 1) goto L19;
        if (r105 == 2) goto L18;
        if (r105 == 3) goto L17;
        if (r105 != 4) goto L16;
        BDAuthorizeRepository r106 = (BDAuthorizeRepository) r101.L$2;
        com.larus.common.account.bdauth.repository.c r107 = (com.larus.common.account.bdauth.repository.c) r101.L$1;
        a r108 = (a) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L72:
        r106.f325922f = (com.larus.common.account.bdauth.repository.a) r103;
        FLogger.f375446a.d("BDAuthorizeRepository", "4. [prepareAuthorize]: getCurrentAuthorizeAccount = " + this.f325922f);
        return new f.d(new com.larus.common.account.bdauth.repository.e(r108.f325923a, r107));
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        a r109 = (a) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L47:
        com.larus.common.account.bdauth.repository.c r113 = (com.larus.common.account.bdauth.repository.c) r103;
        FLogger.f375446a.d("BDAuthorizeRepository", "3. [prepareAuthorize]: build account snapshot = " + r113);
        Iterator<T> r114 = r113.f325938a.iterator();
    L49:
        if (r114.hasNext() == false) goto L59;
        Object r115 = r114.next();
        com.larus.common.account.bdauth.repository.a r116 = (com.larus.common.account.bdauth.repository.a) r115;
        if (r116.f325933g == true) goto L53;
    L55:
        boolean r117 = false;
    L56:
        if (r117 == false) goto L49;
        r112 = r115;
        goto L59
    L53:
        if (r116.f325932f == true) goto L55;
        r117 = true;
    L59:
        if (((com.larus.common.account.bdauth.repository.a) r112) != null) goto L62;
        com.larus.common.account.bdauth.repository.d r118 = new com.larus.common.account.bdauth.repository.d(BDAuthorizeBlockingErrorType.EnterpriseAccount);
        FLogger.f375446a.d("BDAuthorizeRepository", "1.3 [prepareAuthorize]: check blocking: EnterpriseAccount=" + r118);
        return new f.a(r118);
    L62:
        r101.L$0 = r109;
        r101.L$1 = r113;
        r101.L$2 = this;
        r101.label = 4;
        q38.b r119 = IMultiAccountService.f286100a.c();
        if (r119 == null) goto L68;
        com.larus.common.account.bdauth.repository.a r120 = l(r119);
        if (r120 == null) goto L68;
        Object r121 = r120;
    L69:
        if (r121 != r104) goto L71;
        return r104;
    L71:
        r107 = r113;
        r103 = r121;
        r108 = r109;
        r106 = this;
    L68:
        r121 = c(r101);
        goto L69
    L18:
        ResultKt.throwOnFailure(r103);
    L38:
        a r122 = (a) r103;
        FLogger.f375446a.d("BDAuthorizeRepository", "2. [prepareAuthorize]: request auth info = " + r122);
        za7.c r123 = r122.f325923a;
        if (r123 != null) goto L41;
    L74:
        fb7.d r124 = new fb7.d();
        r124.f476267a = -1;
        if (r123 == null) goto L77;
        r124.f476267a = r123.f571092b;
        r124.f476268b = r123.f571093c;
    L78:
        a(r124, 1);
        return new f.b(r124);
    L77:
        r124.f476267a = -3;
        goto L78
    L41:
        if (r123.f571091a == false) goto L74;
        boolean r125 = ((Boolean) this.f325920d.getValue()).booleanValue();
        r101.L$0 = r122;
        r101.label = 3;
        Object r126 = b(true, r125, false, r101);
        if (r126 != r104) goto L46;
        return r104;
    L46:
        r103 = r126;
        r109 = r122;
        goto L47
    L19:
        r100 = (fb7.c) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L32:
        if (((Boolean) r103).booleanValue() == false) goto L35;
        com.larus.common.account.bdauth.repository.d r127 = new com.larus.common.account.bdauth.repository.d(BDAuthorizeBlockingErrorType.MinorMode);
        FLogger.f375446a.d("BDAuthorizeRepository", "1.2 [prepareAuthorize]: check blocking: isMinorMode=" + r127);
        return new f.a(r127);
    L35:
        r101.L$0 = null;
        r101.label = 2;
        r103 = f(r100, r101);
        if (r103 != r104) goto L38;
        return r104;
    L20:
        ResultKt.throwOnFailure(r103);
        if (r100 != null) goto L24;
        fb7.d r128 = new fb7.d();
        r128.f476267a = -1;
        return new f.b(r128);
    L24:
        boolean r129 = AccountService.f365697a.isLogin().booleanValue();
        FLogger.f375446a.d("BDAuthorizeRepository", "1.1 [prepareAuthorize]: check blocking: multiAccountAuthEnabled=" + ((Boolean) this.f325921e.getValue()).booleanValue() + ", multiAccountEnabled=" + ((Boolean) this.f325920d.getValue()).booleanValue() + ", isLogin=" + r129);
        if (r129 == false) goto L27;
        CoroutineDispatcher r130 = Dispatchers.getIO();
        BDAuthorizeRepository$prepareAuthorize$isMinorMode$1 r131 = new BDAuthorizeRepository$prepareAuthorize$isMinorMode$1(null);
        r101.L$0 = r100;
        r101.label = 1;
        r103 = BuildersKt.withContext(r130, r131, r101);
        if (r103 != r104) goto L32;
        return r104;
    L27:
        return f.c.f325948a;
    L7:
        r101 = new BDAuthorizeRepository$prepareAuthorize$1(this, r111);
        goto L8
    }

    public final Object f(fb7.c r100, Continuation<? super a> r101) {
        if ((r101 instanceof BDAuthorizeRepository$requestAuthInfo$1) == false) goto L7;
        BDAuthorizeRepository$requestAuthInfo$1 r102 = (BDAuthorizeRepository$requestAuthInfo$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r104);
    L22:
        return new a((za7.c) r104);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        int r107 = xz8.b.f565543a;
        if (xz8.b.a.b(this.f325917a) == false) goto L17;
        CoroutineDispatcher r108 = Dispatchers.getIO();
        BDAuthorizeRepository$requestAuthInfo$authInfoResponse$1 r109 = new BDAuthorizeRepository$requestAuthInfo$authInfoResponse$1(this, r100, null);
        r102.label = 1;
        r104 = BuildersKt.withContext(r108, r109, r102);
        if (r104 != r105) goto L22;
        return r105;
    L17:
        return new a(null);
    L7:
        r102 = new BDAuthorizeRepository$requestAuthInfo$1(this, r101);
        goto L8
    }

    public final Object i(fb7.c r110, Continuation<? super m> r111) {
        if ((r111 instanceof BDAuthorizeRepository$submitAuthCodeInternal$1) == false) goto L7;
        BDAuthorizeRepository$submitAuthCodeInternal$1 r100 = (BDAuthorizeRepository$submitAuthCodeInternal$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        boolean r104 = true;
        if (r103 == 0) goto L18;
        if (r103 == 1) goto L17;
        if (r103 == 2) goto L16;
        if (r103 != 3) goto L15;
        r110 = (fb7.c) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L44:
        za7.a r113 = (za7.a) r112;
    L50:
        if (r113 != null) goto L52;
    L55:
        fb7.d r114 = new fb7.d();
        r114.f476267a = -1;
        if (r113 == null) goto L58;
        r114.f476267a = r113.f571092b;
        r114.f476268b = r113.f571093c;
    L58:
        a(r114, 3);
        return new m.b(r114);
    L52:
        if (r113.f571091a == false) goto L55;
        fb7.d r105 = new fb7.d();
        r105.f476277d = r113.f571087e;
        r105.f476279f = r110.f476274g;
        r105.f476278e = r110.f476270c;
        return new m.d(r105);
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        za7.a r115 = (za7.a) r100.L$1;
        fb7.c r106 = (fb7.c) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L39:
        if (((Boolean) r112).booleanValue() == false) goto L45;
        CoroutineDispatcher r116 = Dispatchers.getIO();
        BDAuthorizeRepository$submitAuthCodeInternal$2 r117 = new BDAuthorizeRepository$submitAuthCodeInternal$2(this, r106, null);
        r100.L$0 = r106;
        r100.L$1 = null;
        r100.label = 3;
        r112 = BuildersKt.withContext(r116, r117, r100);
        if (r112 != r102) goto L43;
        return r102;
    L43:
        r110 = r106;
        goto L44
    L45:
        fb7.d r107 = new fb7.d();
        r107.f476267a = -1;
        if (r115 == null) goto L48;
        r107.f476267a = r115.f571092b;
        r107.f476268b = r115.f571093c;
    L48:
        a(r107, 3);
        return new m.b(r107);
    L17:
        r110 = (fb7.c) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L21:
        r113 = (za7.a) r112;
        if (r113 != null) goto L24;
    L26:
        boolean r108 = false;
    L27:
        if (r108 == true) goto L50;
        if (r113 != null) goto L30;
    L32:
        r104 = false;
    L33:
        if (r104 == false) goto L50;
        CoroutineDispatcher r109 = Dispatchers.getIO();
        BDAuthorizeRepository$submitAuthCodeInternal$registerResult$1 r118 = new BDAuthorizeRepository$submitAuthCodeInternal$registerResult$1(this, null);
        r100.L$0 = r110;
        r100.L$1 = r113;
        r100.label = 2;
        Object r119 = BuildersKt.withContext(r109, r118, r100);
        if (r119 != r102) goto L37;
        return r102;
    L37:
        r106 = r110;
        r115 = r113;
        r112 = r119;
        goto L39
    L30:
        if (r113.f571092b != 4099) goto L32;
    L24:
        if (r113.f571091a != true) goto L26;
        r108 = true;
        goto L27
    L18:
        ResultKt.throwOnFailure(r112);
        CoroutineDispatcher r120 = Dispatchers.getIO();
        BDAuthorizeRepository$submitAuthCodeInternal$authCodeResponse$1 r121 = new BDAuthorizeRepository$submitAuthCodeInternal$authCodeResponse$1(this, r110, null);
        r100.L$0 = r110;
        r100.label = 1;
        r112 = BuildersKt.withContext(r120, r121, r100);
        if (r112 != r102) goto L21;
        return r102;
    L7:
        r100 = new BDAuthorizeRepository$submitAuthCodeInternal$1(this, r111);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0069 -> B:25:0x006e). Please report as a decompilation issue!!! */
    public final Object g(com.larus.common.account.bdauth.repository.a r110, l r111, Continuation<? super Unit> r112) {
        if ((r112 instanceof BDAuthorizeRepository$restoreOriginalAccount$2) == false) goto L7;
        BDAuthorizeRepository$restoreOriginalAccount$2 r100 = (BDAuthorizeRepository$restoreOriginalAccount$2) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r113 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L19;
        if (r103 == 1) goto L18;
        if (r103 != 2) goto L17;
        ResultKt.throwOnFailure(r113);     // Catch: Throwable -> L14
    L30:
        Object r114 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L14
    L33:
        Throwable r115 = Result.m9452exceptionOrNullimpl(r114);
        if (r115 == null) goto L37;
        FLogger.f375446a.w("BDAuthorizeRepository", "restore scene failed: " + r115.getMessage());
    L37:
        return Unit.INSTANCE;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        int r116 = r100.I$2;
        int r117 = r100.I$1;
        int r104 = r100.I$0;
        l r105 = (l) r100.L$1;
        com.larus.common.account.bdauth.repository.a r106 = (com.larus.common.account.bdauth.repository.a) r100.L$0;
        ResultKt.throwOnFailure(r113);
        BDAuthorizeRepository r107 = this;
    L25:
        n38.b r118 = (n38.b) r113;
        if (r118.f516989c == false) goto L38;
        Result.Companion r119 = Result.Companion;     // Catch: Throwable -> L14
        k r120 = r107.f325919c;     // Catch: Throwable -> L14
        r100.L$0 = null;     // Catch: Throwable -> L14
        r100.L$1 = null;     // Catch: Throwable -> L14
        r100.label = 2;     // Catch: Throwable -> L14
        if (r120.b(r100) != r102) goto L30;
        return r102;
    L38:
        FLogger.f375446a.w("BDAuthorizeRepository", "restoreOriginalAccount failed, retryIndex=" + r116 + ", code=" + r118.f516990d + ", msg=" + r118.f516991e);
        r116 = r117 + 1;
        l r121 = r105;
        com.larus.common.account.bdauth.repository.a r122 = r106;
        BDAuthorizeRepository r108 = r107;
    L20:
        if (r116 >= r104) goto L39;
        r100.L$0 = r122;
        r100.L$1 = r121;
        r100.I$0 = r104;
        r100.I$1 = r116;
        r100.I$2 = r116;
        r100.label = 1;
        Object r109 = k(r122, r100);
        if (r109 != r102) goto L24;
        return r102;
    L24:
        r107 = r108;
        r105 = r121;
        r113 = r109;
        r106 = r122;
        r117 = r116;
        goto L25
    L39:
        FLogger.f375446a.w("BDAuthorizeRepository", "restoreOriginalAccount failed after retry, keep target account in foreground");
        return Unit.INSTANCE;
    L19:
        ResultKt.throwOnFailure(r113);
        r108 = this;
        r121 = r111;
        r104 = 2;
        r122 = r110;
        r116 = 0;
    L14:
        th = move-exception;
        Result.Companion r123 = Result.Companion;
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r100 = new BDAuthorizeRepository$restoreOriginalAccount$2(this, r112);
        goto L8
    }

    public final Object j(fb7.c r110, com.larus.common.account.bdauth.repository.a r111, Continuation<? super m> r210) {
        fb7.c r100 = r110;
        if ((r210 instanceof BDAuthorizeRepository$submitAuthorize$1) == false) goto L7;
        BDAuthorizeRepository$submitAuthorize$1 r101 = (BDAuthorizeRepository$submitAuthorize$1) r210;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L26;
        if (r105 == 1) goto L25;
        if (r105 == 2) goto L24;
        if (r105 == 3) goto L19;
        if (r105 == 4) goto L18;
        if (r105 != 5) goto L16;
        Throwable r106 = (Throwable) r101.L$0;
        ResultKt.throwOnFailure(r103);
        throw r106;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        m r107 = (m) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L98:
        FLogger.f375446a.d("BDAuthorizeRepository", "5. [submitAuthorize]: Auth Code Result =" + r107);
        return r107;
    L19:
        l r108 = (l) r101.L$1;
        com.larus.common.account.bdauth.repository.a r109 = (com.larus.common.account.bdauth.repository.a) r101.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L22
    L90:
        r107 = (m) r103;     // Catch: Throwable -> L22
        com.larus.common.account.bdauth.repository.a r112 = this.f325922f;
        if (r112 == null) goto L98;
        if (Intrinsics.areEqual(r112.f325928b, r109.f325928b) == true) goto L98;
        FLogger.f375446a.d("BDAuthorizeRepository", "4. [submitAuthorize]: restoreOriginalAccount B->A = " + r112);
        r101.L$0 = r107;
        r101.L$1 = null;
        r101.label = 4;
        if (g(r112, r108, r101) != r104) goto L98;
        return r104;
    L22:
        th = th;
        l r113 = r108;
        com.larus.common.account.bdauth.repository.a r114 = r109;
    L102:
        com.larus.common.account.bdauth.repository.a r115 = this.f325922f;
        if (r115 != null) goto L105;
        throw th;
    L105:
        if (Intrinsics.areEqual(r115.f325928b, r114.f325928b) == true) goto L115;
        FLogger.f375446a.d("BDAuthorizeRepository", "4. [submitAuthorize]: restoreOriginalAccount B->A = " + r115);
        r101.L$0 = th;
        r101.L$1 = null;
        r101.L$2 = null;
        r101.label = 5;
        if (g(r115, r113, r101) != r104) goto L116;
        return r104;
    L116:
        throw th;
    L115:
        throw th;
    L24:
        l r116 = (l) r101.L$2;
        com.larus.common.account.bdauth.repository.a r117 = (com.larus.common.account.bdauth.repository.a) r101.L$1;
        fb7.c r118 = (fb7.c) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L73:
        n38.b r119 = (n38.b) r103;
        if (r119.f516989c == true) goto L85;
        int r120 = r119.f516990d;
        if (r120 == 1) goto L82;
        if (r120 == 4) goto L82;
        if (r120 == 1011) goto L81;
        com.larus.common.account.bdauth.repository.b r121 = new com.larus.common.account.bdauth.repository.b(BDAuthorizeAccountIssueType.SessionExpired, r117);
    L84:
        return new m.a(r121);
    L81:
        r121 = new com.larus.common.account.bdauth.repository.b(BDAuthorizeAccountIssueType.AccountDeactivated, r117);
    L82:
        r121 = new com.larus.common.account.bdauth.repository.b(BDAuthorizeAccountIssueType.SessionExpired, r117);
        goto L84
    L85:
        r113 = r116;
        r114 = r117;
        r100 = r118;
    L110:
        FLogger.f375446a.d("BDAuthorizeRepository", "3. [submitAuthorize]: submit Auth Code =" + r100);     // Catch: Throwable -> L101
        r101.L$0 = r114;     // Catch: Throwable -> L101
        r101.L$1 = r113;     // Catch: Throwable -> L101
        r101.L$2 = null;     // Catch: Throwable -> L101
        r101.label = 3;     // Catch: Throwable -> L101
        Object r122 = i(r100, r101);     // Catch: Throwable -> L101
        if (r122 != r104) goto L89;
        return r104;
    L89:
        r109 = r114;
        r108 = r113;
        r103 = r122;
    L101:
        th = th;
        goto L102
    L25:
        com.larus.common.account.bdauth.repository.a r123 = (com.larus.common.account.bdauth.repository.a) r101.L$1;
        fb7.c r124 = (fb7.c) r101.L$0;
        ResultKt.throwOnFailure(r103);
        r114 = r123;
        r100 = r124;
        Object r125 = r103;
    L45:
        com.larus.common.account.bdauth.repository.a r126 = (com.larus.common.account.bdauth.repository.a) r125;
        if (r114 != null) goto L48;
        r114 = r126;
    L48:
        if (r114 != null) goto L52;
        return m.c.f325955a;
    L52:
        if (r114.f325932f == false) goto L56;
        return new m.a(new com.larus.common.account.bdauth.repository.b(BDAuthorizeAccountIssueType.EnterpriseUnsupported, r114));
    L56:
        if (r114.f325933g == false) goto L58;
        if (r126 != null) goto L61;
    L63:
        boolean r127 = false;
    L64:
        FLogger r128 = FLogger.f375446a;
        r128.d("BDAuthorizeRepository", "1. [submitAuthorize]: shouldSwitchBeforeAuthorize=" + r127);
        if (r127 == false) goto L67;
        r113 = this.f325919c.a();
    L68:
        if (r127 == false) goto L110;
        r128.d("BDAuthorizeRepository", "2. [submitAuthorize]: switchAccountSilently A->B = " + r114);
        r101.L$0 = r100;
        r101.L$1 = r114;
        r101.L$2 = r113;
        r101.label = 2;
        Object r129 = k(r114, r101);
        if (r129 != r104) goto L72;
        return r104;
    L72:
        r118 = r100;
        r116 = r113;
        r117 = r114;
        r103 = r129;
        goto L73
    L67:
        r113 = null;
        goto L68
    L61:
        if (Intrinsics.areEqual(r126.f325928b, r114.f325928b) == true) goto L63;
        r127 = true;
        goto L64
    L58:
        return new m.a(new com.larus.common.account.bdauth.repository.b(BDAuthorizeAccountIssueType.SessionExpired, r114));
    L26:
        ResultKt.throwOnFailure(r103);
        if (r100 != null) goto L30;
        fb7.d r130 = new fb7.d();
        r130.f476267a = -1;
        return new m.b(r130);
    L30:
        int r131 = xz8.b.f565543a;
        if (xz8.b.a.b(this.f325917a) == true) goto L35;
        fb7.d r132 = new fb7.d();
        r132.f476267a = -3;
        a(r132, 3);
        return new m.b(r132);
    L35:
        if (AccountService.f365697a.isLogin().booleanValue() == false) goto L37;
        r101.L$0 = r100;
        r114 = r111;
        r101.L$1 = r114;
        r101.label = 1;
        q38.b r133 = IMultiAccountService.f286100a.c();
        if (r133 == null) goto L42;
        r125 = l(r133);
        if (r125 == null) goto L42;
    L43:
        if (r125 != r104) goto L45;
        return r104;
    L42:
        r125 = c(r101);
        goto L43
    L37:
        return m.c.f325955a;
    L7:
        r101 = new BDAuthorizeRepository$submitAuthorize$1(this, r210);
        goto L8
    }

    public final Object b(boolean r210, boolean r211, boolean r212, Continuation<? super com.larus.common.account.bdauth.repository.c> r213) {
        if ((r213 instanceof BDAuthorizeRepository$buildAccountSnapshot$1) == false) goto L7;
        BDAuthorizeRepository$buildAccountSnapshot$1 r100 = (BDAuthorizeRepository$buildAccountSnapshot$1) r213;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        String r110 = null;
        if (r104 == 0) goto L16;
        if (r104 == 1) goto L15;
        if (r104 != 2) goto L14;
        boolean r105 = r100.Z$0;
        List r106 = (List) r100.L$2;
        BDAuthorizeRepository r107 = (BDAuthorizeRepository) r100.L$1;
        List r108 = (List) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L44:
        r107.getClass();
        List r109 = (List) r102;
        if (r109.isEmpty() == true) goto L48;
        r106 = r109;
    L48:
        ArrayList r111 = new ArrayList();
        Iterator r112 = r106.iterator();
    L50:
        if (r112.hasNext() == false) goto L71;
        q38.b r113 = (q38.b) r112.next();
        String r114 = r113.g();
        if (r114 != null) goto L54;
    L67:
        com.larus.common.account.bdauth.repository.a r115 = null;
    L68:
        if (r115 == null) goto L50;
        r111.add(r115);
        goto L50
    L54:
        if ((!StringsKt.isBlank(r114)) == false) goto L56;
        String r116 = r114;
    L57:
        if (r116 == null) goto L67;
        String r117 = r113.j();
        String r118 = r113.c();
        if (r118 != null) goto L62;
        r118 = "";
    L62:
        String r119 = r118;
        String r120 = r113.b();
        q38.b.a r121 = r113.i();
        if (r121 == null) goto L65;
        String r122 = r121.b();
    L66:
        r115 = new com.larus.common.account.bdauth.repository.a(r117, r116, r119, r120, r122, r113.l(), r113.d(), r113.k(), r113.e());
        goto L68
    L65:
        r122 = null;
        goto L66
    L56:
        r116 = null;
        goto L57
    L71:
        if (r111.isEmpty() == true) goto L74;
        r108 = r111;
    L74:
        List r123 = r108;
        boolean r124 = r105;
    L76:
        if (r124 == true) goto L78;
    L80:
        List r125 = CollectionsKt.take(h(r123), 1);
    L81:
        List r126 = r125;
        List r127 = r126;
        Iterator r128 = r127.iterator();
    L83:
        if (r128.hasNext() == false) goto L94;
        Object r129 = r128.next();
        com.larus.common.account.bdauth.repository.a r130 = (com.larus.common.account.bdauth.repository.a) r129;
        if (r130.f325934h == true) goto L87;
    L91:
        boolean r131 = false;
    L92:
        if (r131 == false) goto L83;
    L95:
        com.larus.common.account.bdauth.repository.a r132 = (com.larus.common.account.bdauth.repository.a) r129;
        if (r132 == null) goto L100;
        String r133 = r132.f325928b;
        if (r133 == null) goto L100;
        String r134 = r133;
    L116:
        FLogger.f375446a.d("BDAuthorizeRepository", "2. [buildAccountSnapshot]: build account snapshot: defaultSelectedSecUserId=" + r134 + ", displayAccounts=" + r126);
        if (r124 == true) goto L119;
    L121:
        boolean r135 = false;
    L123:
        return new com.larus.common.account.bdauth.repository.c(r126, r134, r135, r124, !r126.isEmpty());
    L119:
        if (((Boolean) this.f325921e.getValue()).booleanValue() == false) goto L121;
        r135 = true;
    L100:
        Iterator r136 = r127.iterator();
    L102:
        if (r136.hasNext() == false) goto L111;
        Object r137 = r136.next();
        com.larus.common.account.bdauth.repository.a r138 = (com.larus.common.account.bdauth.repository.a) r137;
        if (r138.f325933g == true) goto L106;
    L108:
        boolean r139 = false;
    L109:
        if (r139 == false) goto L102;
    L112:
        com.larus.common.account.bdauth.repository.a r140 = (com.larus.common.account.bdauth.repository.a) r137;
        if (r140 == null) goto L115;
        r110 = r140.f325928b;
    L115:
        r134 = r110;
        goto L116
    L106:
        if (r138.f325932f == true) goto L108;
        r139 = true;
        goto L109
    L111:
        r137 = null;
        goto L112
    L87:
        if (r130.f325933g == false) goto L91;
        if (r130.f325932f == true) goto L91;
        r131 = true;
        goto L92
    L94:
        r129 = null;
        goto L95
    L78:
        if (((Boolean) this.f325921e.getValue()).booleanValue() == false) goto L80;
        r125 = h(r123);
        goto L81
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        boolean r141 = r100.Z$1;
        boolean r142 = r100.Z$0;
        List<q38.b> r143 = (List) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L35:
        r123 = CollectionsKt.listOfNotNull(r102);
    L36:
        if (r142 == false) goto L75;
        if (r141 == false) goto L75;
        r100.L$0 = r123;
        r100.L$1 = this;
        r100.L$2 = r143;
        r100.Z$0 = r142;
        r100.label = 2;
        kotlinx.coroutines.j r144 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r100), 1);
        r144.C();
        IMultiAccountService.f286100a.f(new i(r144));
        Object r145 = r144.B();
        if (r145 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L41;
        DebugProbesKt.probeCoroutineSuspended(r100);
    L41:
        if (r145 != r103) goto L43;
        return r103;
    L43:
        r108 = r123;
        r102 = r145;
        r105 = r142;
        r106 = r143;
        r107 = this;
    L75:
        r124 = r142;
        goto L76
    L16:
        ResultKt.throwOnFailure(r102);
        if (r210 == false) goto L19;
        FLogger.f375446a.d("BDAuthorizeRepository", "1. [buildAccountSnapshot]: build account snapshot: isLogin=" + r210 + ", multiAccountEnabled=" + r211 + ", refreshRemote=" + r212);
        List<q38.b> r146 = IMultiAccountService.f286100a.g();
        if (r211 == true) goto L23;
    L31:
        r100.L$0 = r146;
        r100.Z$0 = r211;
        r100.Z$1 = r212;
        r100.label = 1;
        r102 = c(r100);
        if (r102 != r103) goto L34;
        return r103;
    L34:
        r143 = r146;
        r141 = r212;
        r142 = r211;
        goto L35
    L23:
        if ((!r146.isEmpty()) == false) goto L31;
        ArrayList r147 = new ArrayList();
        Iterator<T> r148 = r146.iterator();
    L26:
        if (r148.hasNext() == false) goto L30;
        com.larus.common.account.bdauth.repository.a r149 = l((q38.b) r148.next());
        if (r149 == null) goto L26;
        r147.add(r149);
        goto L26
    L30:
        r123 = r147;
        r143 = r146;
        r141 = r212;
        r142 = r211;
        goto L36
    L19:
        return new com.larus.common.account.bdauth.repository.c(CollectionsKt.emptyList(), null, false, r211, false);
    L7:
        r100 = new BDAuthorizeRepository$buildAccountSnapshot$1(this, r213);
        goto L8
    }
}
