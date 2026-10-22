package com.larus.account.saas.mfa.assist;

import com.larus.account.saas.mfa.assist.bean.MfaMessage;
import com.larus.account.saas.mfa.assist.bean.MfaPushCodeResponse;
import com.larus.account.saas.mfa.network.MfaApi;
import com.larus.account.saas.runtime.internal.delegate.SaasApp;
import com.larus.account.saas.runtime.internal.delegate.SaasSettings;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.SupervisorKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes24.dex */
public final class MfaAssistManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MfaAssistManager f286395a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CoroutineScope f286396b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final LinkedList<a48.a> f286397c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f286398d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile a f286399e;

    public static abstract class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f286400a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f286401b;

        /* JADX INFO: renamed from: com.larus.account.saas.mfa.assist.MfaAssistManager$a$a, reason: collision with other inner class name */
        public static final class C3943a extends a {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final long f286402c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final String f286403d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final String f286404e;

            public final int hashCode() {
                long r100 = this.f286402c;
                int r101 = ((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f286403d.hashCode()) * 31;
                String r102 = this.f286404e;
                if (r102 != null) goto L5;
                int r103 = 0;
            L7:
                return r101 + r103;
            L5:
                r103 = r102.hashCode();
                goto L7
            }

            public final String toString() {
                return "Dismiss(version=" + this.f286402c + ", token=" + this.f286403d + ", toast=" + this.f286404e + ')';
            }

            @Override // com.larus.account.saas.mfa.assist.MfaAssistManager.a
            public final String a() {
                return this.f286403d;
            }

            @Override // com.larus.account.saas.mfa.assist.MfaAssistManager.a
            public final long b() {
                return this.f286402c;
            }

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof C3943a) == true) goto L8;
                return false;
            L8:
                C3943a r101 = (C3943a) r100;
                if (this.f286402c == r101.f286402c) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.f286403d, r101.f286403d) == true) goto L15;
                return false;
            L15:
                if (Intrinsics.areEqual(this.f286404e, r101.f286404e) == true) goto L17;
                return false;
            L17:
                return true;
            }

            public C3943a(long r100, String r101, String r102) {
                Intrinsics.checkNotNullParameter(r101, "token");
                super(r100, r101);
                this.f286402c = r100;
                this.f286403d = r101;
                this.f286404e = r102;
            }
        }

        public static final class b extends a {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final long f286405c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final String f286406d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final MfaMessage f286407e;

            public final int hashCode() {
                long r100 = this.f286405c;
                return (((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f286406d.hashCode()) * 31) + this.f286407e.hashCode();
            }

            public final String toString() {
                return "Show(version=" + this.f286405c + ", token=" + this.f286406d + ", message=" + this.f286407e + ')';
            }

            @Override // com.larus.account.saas.mfa.assist.MfaAssistManager.a
            public final String a() {
                return this.f286406d;
            }

            @Override // com.larus.account.saas.mfa.assist.MfaAssistManager.a
            public final long b() {
                return this.f286405c;
            }

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof b) == true) goto L8;
                return false;
            L8:
                b r101 = (b) r100;
                if (this.f286405c == r101.f286405c) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.f286406d, r101.f286406d) == true) goto L15;
                return false;
            L15:
                if (Intrinsics.areEqual(this.f286407e, r101.f286407e) == true) goto L17;
                return false;
            L17:
                return true;
            }

            public b(long r100, String r101, MfaMessage r102) {
                Intrinsics.checkNotNullParameter(r101, "token");
                Intrinsics.checkNotNullParameter(r102, "message");
                super(r100, r101);
                this.f286405c = r100;
                this.f286406d = r101;
                this.f286407e = r102;
            }
        }

        public String a() {
            return this.f286401b;
        }

        public long b() {
            return this.f286400a;
        }

        public a(long r100, String r101) {
            this.f286400a = r100;
            this.f286401b = r101;
        }
    }

    public MfaAssistManager() {
    }

    static {
        f286395a = new MfaAssistManager();
        f286396b = CoroutineScopeKt.CoroutineScope(ExecutorsKt.from(PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("MfaAssistManager"))).plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        f286397c = new LinkedList();
        f286399e = new a.C3943a(0, "invalid_token", null);
    }

    public static void b(a48.a r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (SaasApp.f286460a.isTeenMode() == false) goto L5;
        com.larus.account.saas.runtime.internal.delegate.a.f286466a.d("MfaAssistManager", "ignore mfa event, reason = minor_mode, token = " + r100.a());
        boolean r101 = false;
    L6:
        if (r101 == true) goto L8;
        return;
    L8:
        BuildersKt.launch$default(f286396b, null, null, new MfaAssistManager$enqueue$1(r100, null), 3, null);
        return;
    L5:
        r101 = true;
        goto L6
    }

    public static final Object a(MfaAssistManager r110, Continuation r111) {
        r110.getClass();
        if ((r111 instanceof MfaAssistManager$consumeQueue$1) == false) goto L7;
        MfaAssistManager$consumeQueue$1 r100 = (MfaAssistManager$consumeQueue$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        final a r113 = (a) r100.L$1;
        MfaAssistManager r104 = (MfaAssistManager) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L73:
        final MfaPushCodeResponse r114 = (MfaPushCodeResponse) r112;
        if (r114 != null) goto L76;
        com.larus.account.saas.runtime.internal.delegate.a.f286466a.a("MfaAssistManager", "request push code failed, Abort, token = " + r113.a());
        return Unit.INSTANCE;
    L76:
        com.larus.account.saas.runtime.internal.util.b.f286474a.post(new b(r113, r114));
    L78:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r112);
        a r115 = f286399e;
        com.larus.account.saas.runtime.internal.delegate.a r105 = com.larus.account.saas.runtime.internal.delegate.a.f286466a;
        StringBuilder r106 = new StringBuilder("before reduce events, eventQueue = ");
        LinkedList<a48.a> r107 = f286397c;
        r106.append(r107);
        r105.d("MfaAssistManager", r106.toString());
        LinkedHashMap r108 = new LinkedHashMap();
        LinkedHashMap r109 = new LinkedHashMap();
        LinkedHashSet r116 = new LinkedHashSet();
        LinkedHashSet r117 = new LinkedHashSet();
        Iterator<T> r118 = r107.iterator();
    L16:
        if (r118.hasNext() == false) goto L35;
        a48.a r119 = (a48.a) r118.next();
        if ((r119 instanceof a48.a.b) == true) goto L20;
        if ((r119 instanceof a48.a.C0012a) == false) goto L16;
        if (r117.add(r119.a()) == false) goto L16;
        if (r108.remove(r119.a()) != null) goto L33;
        r109.put(r119.a(), r119);
        goto L16
    L33:
        r109.remove(r119.a());
        goto L16
    L20:
        if (r116.add(r119.a()) == false) goto L16;
        if (r109.remove(r119.a()) != null) goto L24;
        r108.remove(r119.a());
        r108.put(r119.a(), r119);
        goto L16
    L24:
        r108.remove(r119.a());
        goto L16
    L35:
        com.larus.account.saas.runtime.internal.delegate.a r120 = com.larus.account.saas.runtime.internal.delegate.a.f286466a;
        r120.d("MfaAssistManager", "after reduce events, pendingShowEvents = " + r108 + ", pendingDismissEvents = " + r109);
        a48.a.b r121 = (a48.a.b) CollectionsKt.lastOrNull(r108.values());
        String r122 = null;
        if (r121 == null) goto L48;
        a r123 = f286399e;
        if ((r123 instanceof a.b) == false) goto L40;
        a.b r124 = (a.b) r123;
    L41:
        if (r124 == null) goto L44;
        r122 = r124.f286406d;
    L44:
        if (Intrinsics.areEqual(r122, r121.f1793b) == false) goto L46;
        a r125 = f286399e;
    L61:
        f286399e = r125;
        final a r126 = f286399e;
        f286397c.clear();
        f286398d = false;
        if (r115.b() != r126.b()) goto L65;
        r120.d("MfaAssistManager", "ui state not changed, do nothing, token = " + r115.a());
        return Unit.INSTANCE;
    L65:
        if ((r126 instanceof a.C3943a) == false) goto L68;
        com.larus.account.saas.runtime.internal.util.b.f286474a.post(new com.larus.account.saas.mfa.assist.a(r126));
        goto L78
    L68:
        if ((r126 instanceof a.b) == false) goto L78;
        r100.L$0 = r110;
        r100.L$1 = r126;
        r100.label = 1;
        r112 = r110.c((a.b) r126, r100);
        if (r112 == r102) goto L99;
        r113 = r126;
        goto L73
    L99:
        return r102;
    L46:
        a r127 = new a.b(f286399e.b() + 1, r121.f1793b, r121.f1794c);
    L47:
        r125 = r127;
        goto L61
    L40:
        r124 = null;
        goto L41
    L48:
        a r128 = f286399e;
        if ((r128 instanceof a.b) == false) goto L51;
        a.b r129 = (a.b) r128;
    L52:
        if (r129 != null) goto L54;
        r125 = f286399e;
        goto L61
    L54:
        a48.a.C0012a r130 = (a48.a.C0012a) r109.get(r129.f286406d);
        if (r130 != null) goto L57;
        r125 = f286399e;
        goto L61
    L57:
        if (Intrinsics.areEqual(r130.f1792c.b(), SaasApp.f286460a.e()) == true) goto L59;
        r122 = r130.f1792c.c();
    L59:
        r127 = new a.C3943a(f286399e.b() + 1, r129.f286406d, r122);
        goto L47
    L51:
        r129 = null;
    L7:
        r100 = new MfaAssistManager$consumeQueue$1(r110, r111);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0087 -> B:30:0x008b). Please report as a decompilation issue!!! */
    public final Object c(a.b r110, Continuation<? super MfaPushCodeResponse> r111) {
        if ((r111 instanceof MfaAssistManager$requestPushCode$1) == false) goto L7;
        MfaAssistManager$requestPushCode$1 r100 = (MfaAssistManager$requestPushCode$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        int r113 = r100.I$1;
        int r104 = r100.I$0;
        a.b r105 = (a.b) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L30:
        com.larus.account.saas.mfa.network.a r114 = (com.larus.account.saas.mfa.network.a) r112;
        if ((r114 instanceof com.larus.account.saas.mfa.network.a.d) == false) goto L48;
        com.larus.account.saas.mfa.network.a.d r115 = (com.larus.account.saas.mfa.network.a.d) r114;
        MfaPushCodeResponse r106 = (MfaPushCodeResponse) r115.f286451a;
        if (r106 == null) goto L35;
        String r107 = r106.f286417a;
    L36:
        if (r107 != null) goto L38;
    L41:
        boolean r108 = true;
    L43:
        if (r108 == false) goto L45;
        com.larus.account.saas.runtime.internal.delegate.a.f286466a.a("MfaAssistManager", "request push code success #" + r113 + ", but code is empty, token = " + r105.f286406d);
    L57:
        if (r113 == r104) goto L59;
        int r116 = r113 + 1;
        r110 = r105;
    L26:
        int r109 = MfaApi.f286442a;
        String r117 = r110.f286406d;
        String r118 = r110.f286407e.a();
        r100.L$0 = r110;
        r100.I$0 = r104;
        r100.I$1 = r116;
        r100.label = 1;
        Object r119 = MfaApi.b(r117, r118, r100);
        if (r119 != r102) goto L29;
        return r102;
    L29:
        r105 = r110;
        r113 = r116;
        r112 = r119;
    L59:
        return null;
    L45:
        com.larus.account.saas.runtime.internal.delegate.a.f286466a.d("MfaAssistManager", "request push code success #" + r113 + ", token = " + r105.f286406d);
        return r115.f286451a;
    L38:
        if (StringsKt.isBlank(r107) == true) goto L41;
        r108 = false;
        goto L43
    L35:
        r107 = null;
        goto L36
    L48:
        if ((r114 instanceof com.larus.account.saas.mfa.network.a.C3944a) == false) goto L57;
        com.larus.account.saas.runtime.internal.delegate.a r120 = com.larus.account.saas.runtime.internal.delegate.a.f286466a;
        StringBuilder r121 = new StringBuilder("request push code failed #");
        r121.append(r113);
        r121.append(", code = ");
        com.larus.account.saas.mfa.network.a.C3944a r122 = (com.larus.account.saas.mfa.network.a.C3944a) r114;
        r121.append(r122.f286445a.f286447a);
        r121.append(", msg = ");
        r121.append(r122.f286445a.f286448b);
        r121.append(", token = ");
        r121.append(r105.f286406d);
        r120.a("MfaAssistManager", r121.toString());
        int r123 = r122.f286445a.f286447a;
        if (r123 != 1) goto L52;
    L56:
        return null;
    L52:
        if (r123 == 1409) goto L56;
        if (r123 == 1604) goto L56;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r112);
        Integer r124 = Boxing.boxInt(SaasSettings.f286462a.a("mfa_config", new JSONObject()).optInt("request_push_code_retry_times"));
        if (r124.intValue() <= 0) goto L17;
        boolean r125 = true;
    L18:
        if (r125 == true) goto L21;
        r124 = null;
    L21:
        if (r124 == null) goto L23;
        int r126 = r124.intValue();
    L24:
        if (1 > r126) goto L59;
        r104 = r126;
        r116 = 1;
        goto L26
    L23:
        r126 = 3;
        goto L24
    L17:
        r125 = false;
    L7:
        r100 = new MfaAssistManager$requestPushCode$1(this, r111);
        goto L8
    }
}
