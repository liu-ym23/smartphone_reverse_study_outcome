package com.larus.login.api;

import com.huawei.hms.support.feature.result.CommonConstant;
import com.larus.platform.api.ISdkDouyinAuth;
import com.larus.platform.api.g5;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes30.dex */
public final class DouYinLoginScopeUpgradeHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DouYinLoginScopeUpgradeHelper f356980a = null;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/larus/login/api/DouYinLoginScopeUpgradeHelper$UpdateAuthorizeInfoFailedException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "errorCode", "", "<init>", "(I)V", "getErrorCode", "()I", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class UpdateAuthorizeInfoFailedException extends Exception {
        private final int errorCode;

        public final int getErrorCode() {
            return this.errorCode;
        }

        public UpdateAuthorizeInfoFailedException(int r100) {
            this.errorCode = r100;
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f356981a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f356982b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Set<String> f356983c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f356981a == r101.f356981a) goto L12;
            return false;
        L12:
            if (this.f356982b == r101.f356982b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f356983c, r101.f356983c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = 1231;
            if (this.f356981a == false) goto L5;
            int r101 = 1231;
        L6:
            int r102 = r101 * 31;
            if (this.f356982b == true) goto L11;
            r100 = 1237;
        L11:
            return ((r102 + r100) * 31) + this.f356983c.hashCode();
        L5:
            r101 = 1237;
            goto L6
        }

        public final String toString() {
            return "ScopeCheckResult(isAlreadyBound=" + this.f356981a + ", isScopeUpgrade=" + this.f356982b + ", grantedScopes=" + this.f356983c + ')';
        }

        public a(boolean r100, boolean r101, Set<String> r102) {
            Intrinsics.checkNotNullParameter(r102, CommonConstant.KEY_GRANTED_SCOPES);
            this.f356981a = r100;
            this.f356982b = r101;
            this.f356983c = r102;
        }
    }

    static {
        f356980a = new DouYinLoginScopeUpgradeHelper();
    }

    public DouYinLoginScopeUpgradeHelper() {
    }

    public static a a(g5 r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tokenResult");
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L11;
        String r103 = r100.f365136c;
        if (r103 == null) goto L22;
        List r104 = StringsKt.split$default(r103, new String[]{","}, false, 0, 6, null);
        if (r104 == null) goto L22;
        List r105 = r104;
        ArrayList r106 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
        Iterator r107 = r105.iterator();
    L18:
        if (r107.hasNext() == false) goto L20;
        r106.add(StringsKt.trim((String) r107.next()).toString());
        goto L18
    L20:
        Set r108 = CollectionsKt.toSet(r106);
        if (r108 == null) goto L22;
    L23:
        List r109 = StringsKt.split$default(r101, new String[]{","}, false, 0, 6, null);
        ArrayList r110 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r109, 10));
        Iterator r111 = r109.iterator();
    L25:
        if (r111.hasNext() == false) goto L27;
        r110.add(StringsKt.trim((String) r111.next()).toString());
        goto L25
    L27:
        Set r112 = CollectionsKt.toSet(r110);
        boolean r113 = r108.containsAll(r112);
        FLogger.f375446a.i("DouYinAuthUtil", "scope check: required=" + r112 + ", granted=" + r108 + ", satisfied=" + r113);
        return new a(r113, !r113, r108);
    L22:
        r108 = SetsKt.emptySet();
        goto L23
    L11:
        return new a(true, false, SetsKt.emptySet());
    L5:
        if (StringsKt.isBlank(r101) == true) goto L8;
        r102 = false;
        goto L9
    }

    public final Object b(ISdkDouyinAuth r100, k0 r101, CommonDouYinLoginUtil.b r102, CommonDouYinLoginTracker.ResultStage r103, String r110, Continuation<? super Unit> r111) {
        if ((r111 instanceof DouYinLoginScopeUpgradeHelper$handleScopeUpgrade$1) == false) goto L7;
        DouYinLoginScopeUpgradeHelper$handleScopeUpgrade$1 r104 = (DouYinLoginScopeUpgradeHelper$handleScopeUpgrade$1) r111;
        int r105 = r104.label;
        if ((r105 & Integer.MIN_VALUE) == 0) goto L7;
        r104.label = r105 - Integer.MIN_VALUE;
    L8:
        Object r112 = r104.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r104.label;
        if (r107 == 0) goto L18;
        if (r107 != 1) goto L17;
        r103 = (CommonDouYinLoginTracker.ResultStage) r104.L$2;
        r102 = (CommonDouYinLoginUtil.b) r104.L$1;
        r101 = (k0) r104.L$0;
        ResultKt.throwOnFailure(r112);     // Catch: UpdateAuthorizeInfoFailedException -> L14
    L28:
        FLogger.f375446a.i("DouYinAuthUtil", "awaitUpdateAuthorizeInfo success");     // Catch: UpdateAuthorizeInfoFailedException -> L14
        CommonDouYinLoginUtil r108 = CommonDouYinLoginUtil.f356945a;     // Catch: UpdateAuthorizeInfoFailedException -> L14
        b0 r113 = r101.f357067g;     // Catch: UpdateAuthorizeInfoFailedException -> L14
        r108.getClass();     // Catch: UpdateAuthorizeInfoFailedException -> L14
        CommonDouYinLoginUtil.q(r113, r102, r103, 0, "Bind Douyin successfully.");     // Catch: UpdateAuthorizeInfoFailedException -> L14
    L32:
        return Unit.INSTANCE;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r112);
        FLogger.f375446a.i("DouYinAuthUtil", "scope upgrade path: calling updateAuthorizeInfo instead of bindPlatform");
        r104.L$0 = r101;     // Catch: UpdateAuthorizeInfoFailedException -> L14
        r104.L$1 = r102;     // Catch: UpdateAuthorizeInfoFailedException -> L14
        r104.L$2 = r103;     // Catch: UpdateAuthorizeInfoFailedException -> L14
        r104.label = 1;     // Catch: UpdateAuthorizeInfoFailedException -> L14
        kotlinx.coroutines.j r114 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r104), 1);     // Catch: UpdateAuthorizeInfoFailedException -> L14
        r114.C();     // Catch: UpdateAuthorizeInfoFailedException -> L14
        r100.j(r110, new c0(r114));     // Catch: UpdateAuthorizeInfoFailedException -> L14
        Object r109 = r114.B();     // Catch: UpdateAuthorizeInfoFailedException -> L14
        if (r109 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L23;
        DebugProbesKt.probeCoroutineSuspended(r104);     // Catch: UpdateAuthorizeInfoFailedException -> L14
    L23:
        if (r109 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L26;
        r109 = Unit.INSTANCE;     // Catch: UpdateAuthorizeInfoFailedException -> L14
    L26:
        if (r109 != r106) goto L28;
        return r106;
    L14:
        e = move-exception;
        FLogger.f375446a.e("DouYinAuthUtil", "awaitUpdateAuthorizeInfo failed, code=" + e.getErrorCode());
        CommonDouYinLoginUtil r115 = CommonDouYinLoginUtil.f356945a;
        b0 r116 = r101.f357067g;
        int r117 = e.getErrorCode();
        r115.getClass();
        CommonDouYinLoginUtil.l(r116, r102, r103, r117, "awaitUpdateAuthorizeInfo failed");
    L7:
        r104 = new DouYinLoginScopeUpgradeHelper$handleScopeUpgrade$1(this, r111);
        goto L8
    }
}
