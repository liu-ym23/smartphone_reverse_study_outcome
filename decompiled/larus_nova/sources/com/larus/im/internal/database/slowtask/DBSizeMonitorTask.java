package com.larus.im.internal.database.slowtask;

import com.larus.im.internal.database.delegate.ReportDaoSource;
import com.larus.im.internal.delegate.c1;
import com.larus.im.internal.delegate.d1;
import com.larus.im.internal.delegate.y0;
import gd9.z;
import java.util.LinkedHashMap;
import juc.d;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import luc.f;
import muc.e;
import nuc.b2;
import nuc.g1;
import nuc.g2;
import nuc.i;
import nuc.i2;
import nuc.m0;
import ouc.d0;

/* JADX INFO: loaded from: classes4.dex */
public final class DBSizeMonitorTask implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy<b> f348125a = null;

    public static final class a {
        public static final String a() {
            Lazy<b> r100 = DBSizeMonitorTask.f348125a;
            return "DB_SIZE_" + com.larus.im.internal.delegate.b.f348193b.getUserId();
        }

        public a() {
        }
    }

    @Serializable
    public static final class b {
        public static final C4351b Companion = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f348126a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f348127b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f348128c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f348129d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f348130e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final long f348131f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final long f348132g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final long f348133h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public long f348134i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public long f348135j;

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
        public /* synthetic */ class a implements m0<b> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f348136a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final g2 f348137b = null;

            public a() {
            }

            @Override // juc.d, juc.n, juc.c
            public final f getDescriptor() {
                return f348137b;
            }

            static {
                a r100 = new a();
                f348136a = r100;
                g2 r101 = new g2("com.larus.im.internal.database.slowtask.DBSizeMonitorTask.Record", r100, 10);
                r101.j("hasNext", true);
                r101.j("lastCollectTime", true);
                r101.j("rows_count_conv", true);
                r101.j("rows_count_bot", true);
                r101.j("rows_count_participant", true);
                r101.j("rows_count_message", true);
                r101.j("content_block_total_count", true);
                r101.j("content_block_new_count", true);
                r101.j("db_size", true);
                r101.j("duration", true);
                f348137b = r101;
            }

            @Override // nuc.m0
            public final d<?>[] childSerializers() {
                g1 r100 = g1.f520681a;
                return new d[]{i.f520705a, r100, r100, r100, r100, r100, r100, r100, r100, r100};
            }

            @Override // nuc.m0
            public final d<?>[] typeParametersSerializers() {
                return i2.f520710a;
            }

            @Override // juc.c
            public final Object deserialize(e r410) {
                Intrinsics.checkNotNullParameter(r410, "decoder");
                g2 r100 = f348137b;
                muc.c r101 = r410.beginStructure(r100);
                if (r101.decodeSequentially() == false) goto L5;
                boolean r102 = r101.decodeBooleanElement(r100, 0);
                long r103 = r101.decodeLongElement(r100, 1);
                long r110 = r101.decodeLongElement(r100, 2);
                long r111 = r101.decodeLongElement(r100, 3);
                long r104 = r101.decodeLongElement(r100, 4);
                long r112 = r101.decodeLongElement(r100, 5);
                long r113 = r101.decodeLongElement(r100, 6);
                long r105 = r101.decodeLongElement(r100, 7);
                long r210 = r105;
                long r211 = r101.decodeLongElement(r100, 8);
                long r212 = r101.decodeLongElement(r100, 9);
                int r106 = 1023;
                boolean r114 = r102;
                long r115 = r112;
                long r213 = r113;
                long r116 = r104;
                long r117 = r103;
            L24:
                r101.endStructure(r100);
                return new b(r106, r114, r117, r110, r111, r116, r115, r213, r210, r211, r212);
            L5:
                long r118 = 0;
                long r119 = 0;
                long r120 = 0;
                long r214 = 0;
                long r215 = 0;
                long r216 = 0;
                long r217 = 0;
                long r218 = 0;
                long r310 = 0;
                boolean r107 = false;
                int r121 = 0;
                boolean r311 = true;
            L6:
                if (r311 == false) goto L23;
                int r108 = r101.decodeElementIndex(r100);
                switch(r108) {
                    case -1: goto L22;
                    case 0: goto L21;
                    case 1: goto L19;
                    case 2: goto L18;
                    case 3: goto L17;
                    case 4: goto L16;
                    case 5: goto L15;
                    case 6: goto L14;
                    case 7: goto L13;
                    case 8: goto L12;
                    case 9: goto L11;
                    default: goto L10;
                };
            L10:
                throw new UnknownFieldException(r108);
            L21:
                r107 = r101.decodeBooleanElement(r100, 0);
                r121 = r121 | 1;
                goto L6
            L22:
                r311 = false;
                goto L6
            L11:
                r310 = r101.decodeLongElement(r100, 9);
                int r109 = r121 | 512;
            L20:
                r121 = r109;
                goto L6
            L12:
                r218 = r101.decodeLongElement(r100, 8);
                r109 = r121 | 256;
                goto L20
            L13:
                r120 = r101.decodeLongElement(r100, 7);
                r109 = r121 | 128;
                goto L20
            L14:
                r217 = r101.decodeLongElement(r100, 6);
                r109 = r121 | 64;
                goto L20
            L15:
                r214 = r101.decodeLongElement(r100, 5);
                r109 = r121 | 32;
                goto L20
            L16:
                r118 = r101.decodeLongElement(r100, 4);
                r109 = r121 | 16;
                goto L20
            L17:
                r216 = r101.decodeLongElement(r100, 3);
                r109 = r121 | 8;
                goto L20
            L18:
                r215 = r101.decodeLongElement(r100, 2);
                r109 = r121 | 4;
                goto L20
            L19:
                r119 = r101.decodeLongElement(r100, 1);
                r109 = r121 | 2;
                goto L20
            L23:
                r114 = r107;
                r106 = r121;
                r117 = r119;
                r111 = r216;
                r212 = r310;
                r211 = r218;
                r213 = r217;
                r210 = r120;
                r115 = r214;
                r116 = r118;
                r110 = r215;
                goto L24
            }

            @Override // juc.n
            public final void serialize(muc.f r110, Object r111) {
                b r112 = (b) r111;
                Intrinsics.checkNotNullParameter(r110, "encoder");
                Intrinsics.checkNotNullParameter(r112, "value");
                g2 r100 = f348137b;
                muc.d r113 = r110.beginStructure(r100);
                C4351b r101 = b.Companion;
                boolean r102 = false;
                if (r113.shouldEncodeElementDefault(r100, 0) == false) goto L6;
            L7:
                boolean r103 = true;
            L9:
                if (r103 == false) goto L12;
                r113.encodeBooleanElement(r100, 0, r112.f348126a);
            L12:
                if (r113.shouldEncodeElementDefault(r100, 1) == false) goto L15;
            L16:
                boolean r104 = true;
            L18:
                if (r104 == false) goto L21;
                r113.encodeLongElement(r100, 1, r112.f348127b);
            L21:
                if (r113.shouldEncodeElementDefault(r100, 2) == false) goto L24;
            L25:
                boolean r105 = true;
            L27:
                if (r105 == false) goto L30;
                r113.encodeLongElement(r100, 2, r112.f348128c);
            L30:
                if (r113.shouldEncodeElementDefault(r100, 3) == false) goto L33;
            L34:
                boolean r106 = true;
            L36:
                if (r106 == false) goto L39;
                r113.encodeLongElement(r100, 3, r112.f348129d);
            L39:
                if (r113.shouldEncodeElementDefault(r100, 4) == false) goto L42;
            L43:
                boolean r107 = true;
            L45:
                if (r107 == false) goto L48;
                r113.encodeLongElement(r100, 4, r112.f348130e);
            L48:
                if (r113.shouldEncodeElementDefault(r100, 5) == false) goto L51;
            L52:
                boolean r108 = true;
            L54:
                if (r108 == false) goto L57;
                r113.encodeLongElement(r100, 5, r112.f348131f);
            L57:
                if (r113.shouldEncodeElementDefault(r100, 6) == false) goto L60;
            L61:
                boolean r109 = true;
            L63:
                if (r109 == false) goto L66;
                r113.encodeLongElement(r100, 6, r112.f348132g);
            L66:
                if (r113.shouldEncodeElementDefault(r100, 7) == false) goto L69;
            L70:
                boolean r114 = true;
            L72:
                if (r114 == false) goto L75;
                r113.encodeLongElement(r100, 7, r112.f348133h);
            L75:
                if (r113.shouldEncodeElementDefault(r100, 8) == false) goto L78;
            L79:
                boolean r115 = true;
            L81:
                if (r115 == false) goto L84;
                r113.encodeLongElement(r100, 8, r112.f348134i);
            L84:
                if (r113.shouldEncodeElementDefault(r100, 9) == false) goto L87;
            L88:
                r102 = true;
            L89:
                if (r102 == false) goto L91;
                r113.encodeLongElement(r100, 9, r112.f348135j);
            L91:
                r113.endStructure(r100);
                return;
            L87:
                if (r112.f348135j == (-1)) goto L89;
            L78:
                if (r112.f348134i != (-1)) goto L79;
                r115 = false;
                goto L81
            L69:
                if (r112.f348133h != (-1)) goto L70;
                r114 = false;
                goto L72
            L60:
                if (r112.f348132g != (-1)) goto L61;
                r109 = false;
                goto L63
            L51:
                if (r112.f348131f != (-1)) goto L52;
                r108 = false;
                goto L54
            L42:
                if (r112.f348130e != (-1)) goto L43;
                r107 = false;
                goto L45
            L33:
                if (r112.f348129d != (-1)) goto L34;
                r106 = false;
                goto L36
            L24:
                if (r112.f348128c != (-1)) goto L25;
                r105 = false;
                goto L27
            L15:
                if (r112.f348127b != (-1)) goto L16;
                r104 = false;
                goto L18
            L6:
                if (r112.f348126a != true) goto L7;
                r103 = false;
                goto L9
            }
        }

        /* JADX INFO: renamed from: com.larus.im.internal.database.slowtask.DBSizeMonitorTask$b$b, reason: collision with other inner class name */
        public static final class C4351b {
            public C4351b() {
            }

            public final d<b> serializer() {
                return a.f348136a;
            }
        }

        public b() {
            this(0, 0, 0, 0, 0, 0, 0, 1023);
        }

        static {
            Companion = new C4351b();
        }

        public final d0 a() {
            LinkedHashMap r100 = new LinkedHashMap();
            TuplesKt.to("rows_count_conv", Long.valueOf(this.f348128c));
            TuplesKt.to("rows_count_bot", Long.valueOf(this.f348129d));
            TuplesKt.to("rows_count_participant", Long.valueOf(this.f348130e));
            TuplesKt.to("rows_count_message", Long.valueOf(this.f348131f));
            TuplesKt.to("db_size", Long.valueOf(this.f348134i));
            return new d0(r100);
        }

        public b(long r210, long r211, long r212, long r310, long r311, long r312, long r313, int r314) {
            if ((r314 & 1) == 0) goto L5;
            boolean r100 = true;
        L7:
            if ((r314 & 2) == 0) goto L9;
            long r101 = -1;
        L11:
            if ((r314 & 4) == 0) goto L13;
            long r102 = -1;
        L15:
            if ((r314 & 8) == 0) goto L17;
            long r110 = -1;
        L19:
            if ((r314 & 16) == 0) goto L21;
            long r111 = -1;
        L23:
            if ((r314 & 32) == 0) goto L25;
            long r112 = -1;
        L27:
            if ((r314 & 64) == 0) goto L29;
            long r103 = -1;
        L31:
            if ((r314 & 128) == 0) goto L33;
            long r113 = -1;
        L35:
            if ((r314 & 256) == 0) goto L37;
            long r213 = -1;
        L39:
            if ((r314 & 512) == 0) goto L41;
            long r214 = -1;
        L42:
            this.f348126a = r100;
            this.f348127b = r101;
            this.f348128c = r102;
            this.f348129d = r110;
            this.f348130e = r111;
            this.f348131f = r112;
            this.f348132g = r103;
            this.f348133h = r113;
            this.f348134i = r213;
            this.f348135j = r214;
            return;
        L41:
            r214 = 0;
            goto L42
        L37:
            r213 = 0;
            goto L39
        L33:
            r113 = r313;
            goto L35
        L29:
            r103 = r312;
            goto L31
        L25:
            r112 = r311;
            goto L27
        L21:
            r111 = r310;
            goto L23
        L17:
            r110 = r212;
            goto L19
        L13:
            r102 = r211;
            goto L15
        L9:
            r101 = r210;
            goto L11
        L5:
            r100 = false;
            goto L7
        }

        public b(int r100, boolean r101, long r110, long r111, long r112, long r113, long r114, long r210, long r211, long r212, long r213) {
            if ((r100 & 0) == 0) goto L5;
            b2.b(r100, 0, a.f348137b);
            throw null;
        L5:
            if ((r100 & 1) != 0) goto L7;
            boolean r102 = true;
        L8:
            this.f348126a = r102;
            if ((r100 & 2) != 0) goto L11;
            this.f348127b = -1;
        L13:
            if ((r100 & 4) != 0) goto L15;
            this.f348128c = -1;
        L17:
            if ((r100 & 8) != 0) goto L19;
            this.f348129d = -1;
        L21:
            if ((r100 & 16) != 0) goto L23;
            this.f348130e = -1;
        L25:
            if ((r100 & 32) != 0) goto L27;
            this.f348131f = -1;
        L29:
            if ((r100 & 64) != 0) goto L31;
            this.f348132g = -1;
        L33:
            if ((r100 & 128) != 0) goto L35;
            this.f348133h = -1;
        L37:
            if ((r100 & 256) != 0) goto L39;
            this.f348134i = -1;
        L41:
            if ((r100 & 512) != 0) goto L43;
            this.f348135j = -1;
            return;
        L43:
            this.f348135j = r213;
            return;
        L39:
            this.f348134i = r212;
            goto L41
        L35:
            this.f348133h = r211;
            goto L37
        L31:
            this.f348132g = r210;
            goto L33
        L27:
            this.f348131f = r114;
            goto L29
        L23:
            this.f348130e = r113;
            goto L25
        L19:
            this.f348129d = r112;
            goto L21
        L15:
            this.f348128c = r111;
            goto L17
        L11:
            this.f348127b = r110;
            goto L13
        L7:
            r102 = r101;
            goto L8
        }
    }

    public DBSizeMonitorTask() {
    }

    @Override // com.larus.im.internal.database.slowtask.c
    public final String getName() {
        return "DBSizeMonitorTask";
    }

    static {
        new a();
        f348125a = LazyKt.lazy(new com.larus.im.internal.database.slowtask.a());
    }

    @Override // com.larus.im.internal.database.slowtask.c
    public final boolean enable() {
        return ((y0.f) com.larus.im.internal.core.message.utils.e.f347862b.getValue()).f348503a;
    }

    public static long c(String r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L4
        Object r102 = Result.m9449constructorimpl(Long.valueOf(com.larus.im.internal.delegate.c.f348197a.g(r100)));     // Catch: Throwable -> L4
    L6:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
        if (r103 == null) goto L11;
        com.larus.im.internal.delegate.a.f348188b.e("DBSizeMonitorTask", "getDBSize failed, dbName:" + r100 + ",error:" + r103);
        r102 = -1L;
    L11:
        return ((Number) r102).longValue();
    L4:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    @Override // com.larus.im.internal.database.slowtask.c
    public final Object a(String r110, Continuation<? super Unit> r111) {
        if ((r111 instanceof DBSizeMonitorTask$run$1) == false) goto L7;
        DBSizeMonitorTask$run$1 r100 = (DBSizeMonitorTask$run$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L16;
        if (r103 == 1) goto L15;
        if (r103 == 2) goto L15;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r112);
    L28:
        com.larus.im.internal.delegate.a.f348188b.i("DBSizeMonitorTask", "run end");
        return Unit.INSTANCE;
    L16:
        ResultKt.throwOnFailure(r112);
        com.larus.im.internal.delegate.a.f348188b.i("DBSizeMonitorTask", "run start, dbName:" + r110);
        b r113 = f348125a.getValue();
        if (r113 != null) goto L22;
        String r114 = a.a();
        r100.label = 1;
        if (d(r110, r114, r100) != r102) goto L28;
        return r102;
    L22:
        if ((com.larus.im.internal.delegate.c.f348197a.currentTimeMillis() - r113.f348127b) <= ((y0.f) com.larus.im.internal.core.message.utils.e.f347862b.getValue()).f348504b) goto L28;
        if (r113.f348126a == false) goto L28;
        String r115 = a.a();
        r100.label = 2;
        if (d(r110, r115, r100) != r102) goto L28;
        return r102;
    L7:
        r100 = new DBSizeMonitorTask$run$1(this, r111);
        goto L8
    }

    public final Object b(String r210, String r211, Continuation<? super b> r212) {
        if ((r212 instanceof DBSizeMonitorTask$collectOnce$1) == false) goto L7;
        DBSizeMonitorTask$collectOnce$1 r100 = (DBSizeMonitorTask$collectOnce$1) r212;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(r100.label) {
            case 0: goto L31;
            case 1: goto L28;
            case 2: goto L25;
            case 3: goto L22;
            case 4: goto L19;
            case 5: goto L16;
            case 6: goto L12;
            default: goto L11;
        };
    L12:
        long r104 = r100.J$5;
        long r105 = r100.J$4;
        long r106 = r100.J$3;
        long r107 = r100.J$2;
        long r110 = r100.J$1;
        long r111 = r100.J$0;
        DBSizeMonitorTask r112 = (DBSizeMonitorTask) r100.L$2;
        String r108 = (String) r100.L$1;
        String r109 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L63
        String r113 = r108;
        long r114 = r111;
        DBSizeMonitorTask r213 = r112;
        long r115 = r104;
    L55:
        b r116 = new b(r114, r110, r107, r106, r105, r115, ((Number) r102).longValue(), 769);     // Catch: Throwable -> L63
        r213.getClass();     // Catch: Throwable -> L63
        r116.f348134i = c(r109);     // Catch: Throwable -> L63
        long r117 = com.larus.im.internal.delegate.c.f348197a.currentTimeMillis() - r114;     // Catch: Throwable -> L63
        r116.f348135j = r117;     // Catch: Throwable -> L63
        if (r117 <= ((y0.f) com.larus.im.internal.core.message.utils.e.f347862b.getValue()).f348505c) goto L58;
        r116.f348126a = false;     // Catch: Throwable -> L63
    L58:
        wt7.c r118 = wt7.a.f561230a;     // Catch: Throwable -> L63
        d<b> r119 = b.Companion.serializer();     // Catch: Throwable -> L63
        r118.getClass();     // Catch: Throwable -> L63
        String r120 = wt7.c.b(r116, r119);     // Catch: Throwable -> L63
        if (r120 != null) goto L61;
        r120 = "";
    L61:
        c1 r121 = c1.f348202a;     // Catch: Throwable -> L63
        z.a.c(r113, r120);     // Catch: Throwable -> L63
        Object r122 = Result.m9449constructorimpl(r116);     // Catch: Throwable -> L63
    L65:
        Throwable r123 = Result.m9452exceptionOrNullimpl(r122);
        if (r123 == null) goto L72;
        com.larus.im.internal.delegate.a.f348188b.e("DBSizeMonitorTask", "recordOnce failed:" + r123);
        return null;
    L72:
        return r122;
    L16:
        long r124 = r100.J$4;
        long r125 = r100.J$3;
        long r126 = r100.J$2;
        long r127 = r100.J$1;
        long r128 = r100.J$0;
        DBSizeMonitorTask r129 = (DBSizeMonitorTask) r100.L$2;
        String r130 = (String) r100.L$1;
        String r131 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L63
        String r132 = r131;
        long r133 = r128;
        String r134 = r130;
        r110 = r127;
        DBSizeMonitorTask r135 = r129;
        r107 = r126;
        r106 = r125;
        r105 = r124;
    L51:
        long r136 = ((Number) r102).longValue();     // Catch: Throwable -> L63
        be9.f.f18793a.getClass();     // Catch: Throwable -> L63
        ReportDaoSource r137 = ReportDaoSource.f347927b;     // Catch: Throwable -> L63
        r100.L$0 = r132;     // Catch: Throwable -> L63
        r100.L$1 = r134;     // Catch: Throwable -> L63
        r100.L$2 = r135;     // Catch: Throwable -> L63
        r100.J$0 = r133;     // Catch: Throwable -> L63
        r100.J$1 = r110;     // Catch: Throwable -> L63
        r100.J$2 = r107;     // Catch: Throwable -> L63
        r100.J$3 = r106;     // Catch: Throwable -> L63
        r100.J$4 = r105;     // Catch: Throwable -> L63
        long r138 = r133;
        r100.J$5 = r136;     // Catch: Throwable -> L63
        r100.label = 6;     // Catch: Throwable -> L63
        r102 = r137.g(r100);     // Catch: Throwable -> L63
        if (r102 != r103) goto L54;
        return r103;
    L54:
        r113 = r134;
        r109 = r132;
        r213 = r135;
        r114 = r138;
        r115 = r136;
        goto L55
    L19:
        long r139 = r100.J$3;
        long r140 = r100.J$2;
        long r141 = r100.J$1;
        long r142 = r100.J$0;
        DBSizeMonitorTask r143 = (DBSizeMonitorTask) r100.L$2;
        r134 = (String) r100.L$1;
        r132 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L63
    L47:
        long r144 = ((Number) r102).longValue();     // Catch: Throwable -> L63
        be9.f.f18793a.getClass();     // Catch: Throwable -> L63
        ReportDaoSource r145 = ReportDaoSource.f347927b;     // Catch: Throwable -> L63
        r100.L$0 = r132;     // Catch: Throwable -> L63
        r100.L$1 = r134;     // Catch: Throwable -> L63
        r100.L$2 = r143;     // Catch: Throwable -> L63
        r100.J$0 = r142;     // Catch: Throwable -> L63
        r100.J$1 = r141;     // Catch: Throwable -> L63
        r100.J$2 = r140;     // Catch: Throwable -> L63
        r100.J$3 = r139;     // Catch: Throwable -> L63
        r100.J$4 = r144;     // Catch: Throwable -> L63
        r100.label = 5;     // Catch: Throwable -> L63
        r102 = r145.i(r100);     // Catch: Throwable -> L63
        if (r102 != r103) goto L50;
        return r103;
    L50:
        r135 = r143;
        r133 = r142;
        r110 = r141;
        r107 = r140;
        r105 = r144;
        r106 = r139;
        goto L51
    L22:
        long r146 = r100.J$2;
        long r147 = r100.J$1;
        long r148 = r100.J$0;
        DBSizeMonitorTask r149 = (DBSizeMonitorTask) r100.L$2;
        String r150 = (String) r100.L$1;
        String r151 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L63
        r134 = r150;
        r132 = r151;
        r143 = r149;
        r142 = r148;
        r141 = r147;
        r140 = r146;
    L44:
        r139 = ((Number) r102).longValue();     // Catch: Throwable -> L63
        be9.f.f18793a.getClass();     // Catch: Throwable -> L63
        ReportDaoSource r152 = ReportDaoSource.f347927b;     // Catch: Throwable -> L63
        r100.L$0 = r132;     // Catch: Throwable -> L63
        r100.L$1 = r134;     // Catch: Throwable -> L63
        r100.L$2 = r143;     // Catch: Throwable -> L63
        r100.J$0 = r142;     // Catch: Throwable -> L63
        r100.J$1 = r141;     // Catch: Throwable -> L63
        r100.J$2 = r140;     // Catch: Throwable -> L63
        r100.J$3 = r139;     // Catch: Throwable -> L63
        r100.label = 4;     // Catch: Throwable -> L63
        r102 = r152.d(r100);     // Catch: Throwable -> L63
        if (r102 != r103) goto L47;
        return r103;
    L25:
        long r153 = r100.J$1;
        long r154 = r100.J$0;
        DBSizeMonitorTask r155 = (DBSizeMonitorTask) r100.L$2;
        String r156 = (String) r100.L$1;
        String r157 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L63
    L40:
        long r158 = ((Number) r102).longValue();     // Catch: Throwable -> L63
        be9.f.f18793a.getClass();     // Catch: Throwable -> L63
        ReportDaoSource r159 = ReportDaoSource.f347927b;     // Catch: Throwable -> L63
        r100.L$0 = r157;     // Catch: Throwable -> L63
        r100.L$1 = r156;     // Catch: Throwable -> L63
        r100.L$2 = r155;     // Catch: Throwable -> L63
        r100.J$0 = r154;     // Catch: Throwable -> L63
        r100.J$1 = r153;     // Catch: Throwable -> L63
        r100.J$2 = r158;     // Catch: Throwable -> L63
        r100.label = 3;     // Catch: Throwable -> L63
        r102 = r159.e(r100);     // Catch: Throwable -> L63
        if (r102 != r103) goto L43;
        return r103;
    L43:
        r134 = r156;
        r132 = r157;
        r143 = r155;
        r141 = r153;
        r142 = r154;
        r140 = r158;
        goto L44
    L28:
        long r160 = r100.J$0;
        DBSizeMonitorTask r161 = (DBSizeMonitorTask) r100.L$2;
        String r162 = (String) r100.L$1;
        String r163 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L63
        r155 = r161;
        String r164 = r163;
    L36:
        long r165 = ((Number) r102).longValue();     // Catch: Throwable -> L63
        be9.f.f18793a.getClass();     // Catch: Throwable -> L63
        ReportDaoSource r166 = ReportDaoSource.f347927b;     // Catch: Throwable -> L63
        r100.L$0 = r164;     // Catch: Throwable -> L63
        r100.L$1 = r162;     // Catch: Throwable -> L63
        r100.L$2 = r155;     // Catch: Throwable -> L63
        r100.J$0 = r160;     // Catch: Throwable -> L63
        r100.J$1 = r165;     // Catch: Throwable -> L63
        r100.label = 2;     // Catch: Throwable -> L63
        r102 = r166.b(r100);     // Catch: Throwable -> L63
        if (r102 != r103) goto L39;
        return r103;
    L39:
        r157 = r164;
        r156 = r162;
        r154 = r160;
        r153 = r165;
        goto L40
    L31:
        ResultKt.throwOnFailure(r102);
        Result.Companion r167 = Result.Companion;     // Catch: Throwable -> L63
        r160 = com.larus.im.internal.delegate.c.f348197a.currentTimeMillis();     // Catch: Throwable -> L63
        be9.f.f18793a.getClass();     // Catch: Throwable -> L63
        ReportDaoSource r168 = ReportDaoSource.f347927b;     // Catch: Throwable -> L63
        r164 = r210;
        r100.L$0 = r164;     // Catch: Throwable -> L63
        r162 = r211;
        r100.L$1 = r162;     // Catch: Throwable -> L63
        r100.L$2 = this;     // Catch: Throwable -> L63
        r100.J$0 = r160;     // Catch: Throwable -> L63
        r100.label = 1;     // Catch: Throwable -> L63
        r102 = r168.c(r100);     // Catch: Throwable -> L63
        if (r102 != r103) goto L35;
        return r103;
    L35:
        r155 = this;
        goto L36
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L63:
        th = move-exception;
        Result.Companion r169 = Result.Companion;
        r122 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r100 = new DBSizeMonitorTask$collectOnce$1(this, r212);
        goto L8
    }

    public final Object d(String r100, String r101, Continuation<? super Unit> r110) {
        if ((r110 instanceof DBSizeMonitorTask$reportOnce$1) == false) goto L7;
        DBSizeMonitorTask$reportOnce$1 r102 = (DBSizeMonitorTask$reportOnce$1) r110;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r111 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        ResultKt.throwOnFailure(r111);
    L17:
        b r112 = (b) r111;
        if (r112 == null) goto L22;
        LinkedHashMap r106 = new LinkedHashMap();
        TuplesKt.to("duration", Long.valueOf(r112.f348135j));
        d0 r107 = com.flow.kmp.common.util.f.c(new d0(r106), r112.a(), true);
        if (r107 == null) goto L22;
        d1.f348206b.a("flow_im_db_status_report", r107);
    L22:
        if (r112 == null) goto L37;
        long r108 = r112.f348132g;
        long r109 = r112.f348133h;
        long r113 = r108 - r109;
        if (r108 >= 0) goto L26;
    L33:
        d0 r114 = null;
    L34:
        if (r114 == null) goto L37;
        d1.f348206b.a("flow_imsdk_content_block_info", r114);
        goto L37
    L26:
        if (r109 < 0) goto L33;
        if (r113 < 0) goto L33;
        long r115 = r112.f348131f;
        if (r115 <= 0) goto L33;
        float r116 = r115;
        float r117 = r113 / r116;
        float r118 = r109 / r116;
        LinkedHashMap r119 = new LinkedHashMap();
        TuplesKt.to("rows_count_message", Long.valueOf(r112.f348131f));
        TuplesKt.to("content_block_old_count", Long.valueOf(r113));
        TuplesKt.to("content_block_new_count", Long.valueOf(r112.f348133h));
        TuplesKt.to("content_block_total_count", Long.valueOf(r112.f348132g));
        TuplesKt.to("content_block_old_ratio", Float.valueOf(r117));
        TuplesKt.to("content_block_new_ratio", Float.valueOf(r118));
        TuplesKt.to("content_block_ratio", Float.valueOf(r117 + r118));
        r114 = new d0(r119);
    L37:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        com.larus.im.internal.delegate.a.f348188b.i("DBSizeMonitorTask", "reportOnce, dbName:" + r100);
        r102.label = 1;
        r111 = b(r100, r101, r102);
        if (r111 != r104) goto L17;
        return r104;
    L7:
        r102 = new DBSizeMonitorTask$reportOnce$1(this, r110);
        goto L8
    }
}
