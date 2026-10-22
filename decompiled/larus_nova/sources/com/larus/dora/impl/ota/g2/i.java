package com.larus.dora.impl.ota.g2;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.dora.impl.core.wifi.DoraWifiLinkWrapper;
import com.larus.dora.impl.ota.connector.DoraOTAWifiConnector;
import com.larus.dora.impl.ota.g.DoraGOTAPlugin;
import com.monitor.cloudmessage.consts.CloudControlInf;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes4.dex */
public final class i implements p4 {
    private static final a Companion = null;
    public static final String TAG = "G2OtaTransport";
    private final DoraOTAWifiConnector connector;
    private final Function1<e, Boolean> currentDeviceMatches;
    private final DoraGOTAPlugin plugin;
    private final CoroutineScope scope;
    private final Object transferLock;
    private final ConcurrentHashMap<b, Job> uploads;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: loaded from: classes27.dex */
    public static final class b {
        private final e device;
        private final long operationId;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.device, r101.device) == true) goto L12;
            return false;
        L12:
            if (this.operationId == r101.operationId) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.device.hashCode() * 31;
            long r101 = this.operationId;
            return r100 + ((int) (r101 ^ (r101 >>> 32)));
        }

        public final String toString() {
            return "UploadOperationKey(device=" + this.device + ", operationId=" + this.operationId + ')';
        }

        public b(e r100, long r101) {
            Intrinsics.checkNotNullParameter(r100, "device");
            this.device = r100;
            this.operationId = r101;
        }
    }

    static {
        Companion = new a();
    }

    public i(int r100) {
        DoraOTAWifiConnector r101 = new DoraOTAWifiConnector();
        DoraGOTAPlugin r102 = new DoraGOTAPlugin();
        CoroutineScope r103 = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        Function1<e, Boolean> r104 = new h();
        Intrinsics.checkNotNullParameter(r101, "connector");
        Intrinsics.checkNotNullParameter(r102, CloudControlInf.PLUGIN);
        Intrinsics.checkNotNullParameter(r103, "scope");
        Intrinsics.checkNotNullParameter(r104, "currentDeviceMatches");
        this.connector = r101;
        this.plugin = r102;
        this.scope = r103;
        this.currentDeviceMatches = r104;
        this.transferLock = new Object();
        this.uploads = new ConcurrentHashMap();
    }

    public static final /* synthetic */ DoraOTAWifiConnector f(i r100) {
        return r100.connector;
    }

    public static final /* synthetic */ DoraGOTAPlugin g(i r100) {
        return r100.plugin;
    }

    public static final /* synthetic */ Object h(i r100) {
        return r100.transferLock;
    }

    public static final /* synthetic */ ConcurrentHashMap i(i r100) {
        return r100.uploads;
    }

    public final boolean k(e r100) {
        return this.currentDeviceMatches.invoke(r100).booleanValue();
    }

    public static String l(e r100, String r101) {
        return j0.d(r100) + ':' + r101;
    }

    @Override // com.larus.dora.impl.ota.g2.p4
    public final boolean c(e r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "ownerId");
        DoraOTAWifiConnector r102 = this.connector;
        String r103 = l(r100, r101);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, "owner");
        DoraWifiLinkWrapper.f332292a.getClass();
        Intrinsics.checkNotNullParameter(r103, "owner");
        vk4.e r104 = vk4.e.d.f555490a;
        Object r105 = DoraWifiLinkWrapper.f332297f;
        monitor-enter(r105);
    L22:
        th = move-exception;
        throw th;
    L5:
        if (Intrinsics.areEqual(DoraWifiLinkWrapper.f332300i, r103) == false) goto L8;
    L12:
        boolean r106 = false;
    L20:
        monitor-exit(r105);
        return r106;
    L8:
        if (Intrinsics.areEqual(DoraWifiLinkWrapper.f332298g, r103) == true) goto L11;
    L19:
        r106 = true;
        goto L20
    L11:
        if (r104.f555486e != 0) goto L12;
        vk4.h r107 = DoraWifiLinkWrapper.f332294c.remove(r103);     // Catch: Throwable -> L22
        if (Intrinsics.areEqual(DoraWifiLinkWrapper.f332298g, r103) == false) goto L16;
        DoraWifiLinkWrapper.f332298g = null;     // Catch: Throwable -> L22
        DoraWifiLinkWrapper.f332299h = null;     // Catch: Throwable -> L22
        DoraWifiLinkWrapper.f332295d.remove(r103);     // Catch: Throwable -> L22
    L16:
        DoraWifiLinkWrapper.f332296e.remove(r103);     // Catch: Throwable -> L22
        if (r107 == null) goto L19;
        r104.j(r107);     // Catch: Throwable -> L22
        goto L19
    }

    @Override // com.larus.dora.impl.ota.g2.p4
    public final Object e(e r100, String r101, OtaMode r110) {
        boolean r102 = false;
        if (k(r100) == false) goto L5;
        kj4.a r103 = kj4.a.g();
        if (r110 != OtaMode.SILENT_G2) goto L9;
        int r104 = 1;
    L10:
        int r105 = r103.f503708c.f514229d.i(3, 16, new byte[]{3, 1, (byte) (r104 ^ 1)});
        g49.d.d(c.TAG, "declare type owner=" + r101 + " mode=" + r110 + " ret=" + r105 + " device=" + j0.d(r100));
        if (r105 != 0) goto L14;
        r102 = true;
    L14:
        return Boxing.boxBoolean(r102);
    L9:
        r104 = 0;
        goto L10
    L5:
        return Boxing.boxBoolean(false);
    }

    @Override // com.larus.dora.impl.ota.g2.p4
    public final Unit a(e r100, String r101, long r102, FailureReason r103) {
        Job r104 = this.uploads.remove(new b(r100, r102));
        if (r104 == null) goto L5;
        Job.DefaultImpls.cancel$default(r104, null, 1, null);
    L5:
        Object r105 = this.transferLock;
        monitor-enter(r105);
        g49.d.e(c.TAG, "stop owner=" + r101 + " operation=" + r102 + " reason=" + r103 + " device=" + j0.d(r100));     // Catch: Throwable -> L11
        this.connector.c(r103.name().toLowerCase(Locale.ROOT));     // Catch: Throwable -> L11
        DoraOTAWifiConnector r106 = this.connector;     // Catch: Throwable -> L11
        String r107 = l(r100, r101);     // Catch: Throwable -> L11
        r106.getClass();     // Catch: Throwable -> L11
        DoraOTAWifiConnector.g(r107);     // Catch: Throwable -> L11
        monitor-exit(r105);
        return Unit.INSTANCE;
    L11:
        th = move-exception;
        throw th;
    }

    public static final void j(i r110, e r111, String r112, long r113, String r114, p4.a r115) {
        PolarisFileWrapper r100 = new PolarisFileWrapper(r114);
        DoraOTAWifiConnector r101 = r110.connector;
        String r102 = r100.getParent();
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        r101.d(r102, r100.getName(), new j(r115, r112, r113, r110, r111));
    }

    @Override // com.larus.dora.impl.ota.g2.p4
    public final Object b(e r100, String r101, long r110, OtaMode r111, com.larus.dora.impl.ota.g2.a r112, Continuation r113) {
        if ((r113 instanceof DoraG2OtaTransport$connect$1) == false) goto L7;
        DoraG2OtaTransport$connect$1 r102 = (DoraG2OtaTransport$connect$1) r113;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r114 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        boolean r106 = true;
        if (r105 == 0) goto L16;
        if (r105 == 1) goto L15;
        if (r105 != 2) goto L14;
        r110 = r102.J$0;
        String r107 = (String) r102.L$3;
        r111 = (OtaMode) r102.L$2;
        r101 = (String) r102.L$1;
        e r115 = (e) r102.L$0;
        ResultKt.throwOnFailure(r114);
        String r116 = r107;
        r100 = r115;
        Object r117 = r114;
    L29:
        com.larus.dora.impl.ota.c r118 = (com.larus.dora.impl.ota.c) r117;
    L31:
        if (Intrinsics.areEqual(r118, com.larus.dora.impl.ota.c.a.f337426a) == true) goto L33;
    L35:
        r106 = false;
    L36:
        g49.d.d(c.TAG, "connect owner=" + r101 + " operation=" + r110 + " mode=" + r111 + " result=" + r118.a() + " currentMatch=" + k(r100));
        if (r106 == true) goto L40;
        this.connector.getClass();
        DoraOTAWifiConnector.g(r116);
    L40:
        return Boxing.boxBoolean(r106);
    L33:
        if (k(r100) == false) goto L35;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r110 = r102.J$0;
        String r108 = (String) r102.L$3;
        r111 = (OtaMode) r102.L$2;
        r101 = (String) r102.L$1;
        e r119 = (e) r102.L$0;
        ResultKt.throwOnFailure(r114);
        r116 = r108;
        r100 = r119;
        Object r120 = r114;
    L25:
        r118 = (com.larus.dora.impl.ota.c) r120;
        goto L31
    L16:
        ResultKt.throwOnFailure(r114);
        if (k(r100) == false) goto L19;
        r116 = l(r100, r101);
        if (r111 != OtaMode.SILENT_G2) goto L26;
        DoraOTAWifiConnector r109 = this.connector;
        r102.L$0 = r100;
        r102.L$1 = r101;
        r102.L$2 = r111;
        r102.L$3 = r116;
        r102.J$0 = r110;
        r102.label = 1;
        r120 = r109.i(r116, r112, r102);
        if (r120 != r104) goto L25;
        return r104;
    L26:
        DoraOTAWifiConnector r121 = this.connector;
        r102.L$0 = r100;
        r102.L$1 = r101;
        r102.L$2 = r111;
        r102.L$3 = r116;
        r102.J$0 = r110;
        r102.label = 2;
        r117 = r121.h(r116, r112, r102);
        if (r117 != r104) goto L29;
        return r104;
    L19:
        return Boxing.boxBoolean(false);
    L7:
        r102 = new DoraG2OtaTransport$connect$1(this, r113);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v7, types: [T, kotlinx.coroutines.Job] */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.lang.Object] */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.larus.dora.impl.ota.g2.p4
    public final void d(e r210, String r211, long r212, e5 r213, String r214, AndroidG2OtaRuntime.d r215) {
        Intrinsics.checkNotNullParameter(r210, "key");
        Intrinsics.checkNotNullParameter(r211, "ownerId");
        Intrinsics.checkNotNullParameter(r213, "spec");
        Intrinsics.checkNotNullParameter(r214, "filePath");
        Intrinsics.checkNotNullParameter(r215, "callback");
        b r110 = new b(r210, r212);
        Ref.ObjectRef r111 = new Ref.ObjectRef();
        ?? r100 = BuildersKt.launch$default(this.scope, null, CoroutineStart.LAZY, new DoraG2OtaTransport$upload$1(this, r210, r215, r211, r213, r110, r111, r212, r214, null), 1, null);
        r111.element = r100;
        ConcurrentHashMap<b, Job> r101 = this.uploads;
        Job r102 = null;
        ?? r103 = r100;
        if (r100 != 0) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("job");
        r103 = 0;
    L5:
        Job r104 = r101.put(r110, (Job) r103);
        if (r104 == null) goto L8;
        Job.DefaultImpls.cancel$default(r104, null, 1, null);
    L8:
        Object r105 = r111.element;
        if (r105 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("job");
    L12:
        r102.start();
        return;
    L11:
        r102 = (Job) r105;
        goto L12
    }
}
