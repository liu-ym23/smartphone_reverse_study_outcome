package com.bytedance.lark.sdk.refactor;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.Packet;
import com.larus.apm.impl.protector.RunnableProtector;
import com.squareup.wire.ProtoAdapter;
import com.ss.android.lark.log.Log;
import java.io.IOException;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class r implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f254282a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f254283b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Executor f254284c;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ r f254285a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f254286b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f254287c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ byte[] f254288d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f254289e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ boolean f254290f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ se6.b f254291g;

        public a(r r100, long r101, boolean r102, byte[] r103, String r104, boolean r105, se6.b r106) {
            this.f254285a = r100;
            this.f254286b = r101;
            this.f254287c = r102;
            this.f254288d = r103;
            this.f254289e = r104;
            this.f254290f = r105;
            this.f254291g = r106;
        }

        @Override // java.lang.Runnable
        public final void run() {
            h r100 = this.f254285a.f254282a;     // Catch: Throwable -> L8
            long r101 = this.f254286b;     // Catch: Throwable -> L8
            boolean r102 = this.f254287c;     // Catch: Throwable -> L8
            byte[] r103 = this.f254288d;     // Catch: Throwable -> L8
            String r104 = this.f254289e;     // Catch: Throwable -> L8
            boolean r105 = this.f254290f;     // Catch: Throwable -> L8
            if (this.f254291g == null) goto L5;
            boolean r106 = true;
        L6:
            r100.y(new com.bytedance.lark.sdk.refactor.b(r101, r102, r103, r104, r105, r106, null, 64));     // Catch: Throwable -> L8
            return;
        L5:
            r106 = false;
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L12;
            return;
        L12:
            throw th;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ byte[] f254292a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ r f254293b;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ r f254294a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Packet f254295b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Ref.ObjectRef<q.a> f254296c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ long f254297d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ long f254298e;

            public a(r r100, Packet r101, Ref.ObjectRef<q.a> r102, long r103, long r104) {
                this.f254294a = r100;
                this.f254295b = r101;
                this.f254296c = r102;
                this.f254297d = r103;
                this.f254298e = r104;
            }

            public final void a() {
                h r100 = this.f254294a.f254282a;
                Packet r101 = this.f254295b;
                r100.v(new q(r101.cmd, r101, this.f254296c.element));
                Long r102 = this.f254295b.task_id;
                Intrinsics.checkNotNull(r102);
                com.bytedance.lark.sdk.d.f(r102.longValue(), this.f254295b, this.f254297d, this.f254298e);
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public b(byte[] r100, r r101) {
            this.f254292a = r100;
            this.f254293b = r101;
        }

        /* JADX WARN: Type inference failed for: r11v2, types: [T, com.bytedance.lark.sdk.refactor.q$a] */
        public final void a() {
            long r100 = System.currentTimeMillis();
            Packet r101 = Packet.ADAPTER.decode(this.f254292a);     // Catch: IOException -> L5
        L7:
            Packet r102 = r101;
            long r103 = System.currentTimeMillis();
            if (r102 != null) goto L11;
            Log.e("RustSDK", "RustSdk pushCallback packet is null");
            return;
        L11:
            String r110 = qqb.a.b(r102.context_id);
            Ref.ObjectRef r104 = new Ref.ObjectRef();
            if (Intrinsics.areEqual(r102.cmd, Command.PASS_THROUGH_PUSH) == true) goto L43;
        L26:
            a r105 = new a(this.f254293b, r102, r104, r100, r103);
            String r106 = qqb.a.d();     // Catch: Throwable -> L33
            Intrinsics.checkNotNullParameter(r110, "traceId");     // Catch: Throwable -> L31
            qqb.a.g(r110);     // Catch: Throwable -> L31
            r105.run();     // Catch: Throwable -> L31
            qqb.a.a();
            Intrinsics.checkNotNullParameter(r106, "traceId");
            qqb.a.g(r106);
            return;
        L31:
            th = th;
        L35:
            qqb.a.a();
            Intrinsics.checkNotNullParameter(r106, "traceId");
            qqb.a.g(r106);
            throw th;
        L33:
            th = th;
            r106 = "";
            goto L35
        L43:
            ProtoAdapter<com.ss.android.lark.pb.improto.Packet> r107 = com.ss.android.lark.pb.improto.Packet.ADAPTER;     // Catch: Throwable -> L18 IOException -> L20
            ByteString r108 = r102.payload;     // Catch: Throwable -> L18 IOException -> L20
            if (r108 != null) goto L16;
            r108 = ByteString.EMPTY;     // Catch: Throwable -> L18 IOException -> L20
        L16:
            com.ss.android.lark.pb.improto.Packet r109 = r107.decode(r108);     // Catch: Throwable -> L18 IOException -> L20
            r104.element = new q.a(com.ss.android.lark.pb.improto.Command.fromValue(r109.mcommand.intValue()), r109);     // Catch: Throwable -> L18 IOException -> L20
        L23:
            if (r104.element != 0) goto L26;
            Log.e("RustSDK", "RustSdk pushCallback server packet is null");
            return;
        L20:
            e = move-exception;
            Log.e("RustSDK", "RustSdk pushCallback server packet adapter decode error : " + e.getMessage());
        L18:
            th = move-exception;
            Log.e("RustSDK", "RustSdk pushCallback server push unsupported command: " + th.getMessage());
        L5:
            e = move-exception;
            Log.e("RustSDK", "RustSdk pushCallback packet adapter decode error : " + e.getMessage());
            r101 = null;
            goto L7
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // com.bytedance.lark.sdk.refactor.j
    public final void a(byte[] r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        b r101 = new b(r100, this);
        this.f254283b.execute(r101);
    }

    public r(h r100, Executor r101, Executor r102) {
        Intrinsics.checkNotNullParameter(r100, "callBacker");
        Intrinsics.checkNotNullParameter(r101, "pushExecutor");
        Intrinsics.checkNotNullParameter(r102, "asyncExecutor");
        this.f254282a = r100;
        this.f254283b = r101;
        this.f254284c = r102;
    }

    @Override // com.bytedance.lark.sdk.refactor.j
    public final void b(long r110, boolean r111, byte[] r112, boolean r113, boolean r210, String r211, se6.b r212) {
        Intrinsics.checkNotNullParameter(r112, "data");
        Intrinsics.checkNotNullParameter(r211, "userId");
        this.f254284c.execute(new a(this, r110, r111, r112, r211, r210, r212));
        com.bytedance.lark.sdk.d.e(r110, r111, r112, r113, r210, r211, r212);
    }
}
