package com.lark.kmp.pb.basic.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.l;
import com.lark.wire.n0;
import com.lark.wire.w;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import okio.ByteString;
import we6.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class Packet$Companion$ADAPTER$1 extends ProtoAdapter<Packet> implements c<Packet> {
    public final Lazy v;

    @Override // com.lark.wire.ProtoAdapter
    public final Packet c(g0 r11) {
        Intrinsics.checkNotNullParameter(r11, "reader");
        Packet.a r1 = new Packet.a();
        LinkedHashMap r2 = new LinkedHashMap();
        long r3 = r11.c();
    L3:
        int r5 = r11.e();
        if (r5 == (-1)) goto L30;
        if (r5 != 9999) goto L7;
        ProtoAdapter.p.getClass();
        Intrinsics.checkNotNullParameter(r11, "reader");
        r1.r = r11.f();
        goto L3
    L7:
        switch(r5) {
            case 1: goto L32;
            case 2: goto L24;
            case 3: goto L23;
            case 4: goto L22;
            case 5: goto L21;
            case 6: goto L20;
            case 7: goto L19;
            case 8: goto L18;
            case 9: goto L34;
            case 10: goto L13;
            case 11: goto L12;
            case 12: goto L11;
            case 13: goto L10;
            case 14: goto L9;
            default: goto L8;
        };
    L32:
        r1.d = Command.ADAPTER.c(r11);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L27
    L27:
        e = move-exception;
        r11.a(r5, FieldEncoding.VARINT, Long.valueOf(e.value));
        Unit r6 = Unit.INSTANCE;
        goto L3
    L34:
        r1.l = Packet.StreamStatus.ADAPTER.c(r11);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
    L16:
        e = move-exception;
        r11.a(r5, FieldEncoding.VARINT, Long.valueOf(e.value));
        Unit r7 = Unit.INSTANCE;
        goto L3
    L9:
        r2.putAll((Map) ((ProtoAdapter) this.v.getValue()).c(r11));
        Unit r8 = Unit.INSTANCE;
        goto L3
    L10:
        r1.p = (Long) ProtoAdapter.l.c(r11);
        goto L3
    L11:
        r1.o = (Boolean) ProtoAdapter.g.c(r11);
        goto L3
    L12:
        r1.n = Trace.ADAPTER.c(r11);
        goto L3
    L13:
        ProtoAdapter.q.getClass();
        Intrinsics.checkNotNullParameter(r11, "reader");
        r1.m = r11.i();
        goto L3
    L18:
        r1.k = (Boolean) ProtoAdapter.g.c(r11);
        goto L3
    L19:
        r1.j = (Long) ProtoAdapter.k.c(r11);
        goto L3
    L20:
        ProtoAdapter.q.getClass();
        Intrinsics.checkNotNullParameter(r11, "reader");
        r1.i = r11.i();
        goto L3
    L21:
        ProtoAdapter.q.getClass();
        Intrinsics.checkNotNullParameter(r11, "reader");
        r1.h = r11.i();
        goto L3
    L22:
        ProtoAdapter.q.getClass();
        Intrinsics.checkNotNullParameter(r11, "reader");
        r1.g = r11.i();
        goto L3
    L23:
        ProtoAdapter.q.getClass();
        Intrinsics.checkNotNullParameter(r11, "reader");
        r1.f = r11.i();
        goto L3
    L24:
        r1.e = (Integer) ProtoAdapter.i.c(r11);
        goto L3
    L8:
        r11.j(r5);
        Unit r9 = Unit.INSTANCE;
        goto L3
    L30:
        ByteString r12 = r11.d(r3);
        Intrinsics.checkNotNullParameter(r2, "biz_response_meta");
        r1.q = r2;
        return new Packet(r1, r12, null);
    }

    @Override // com.lark.wire.ProtoAdapter
    public final int k(Packet r7) {
        Packet r8 = r7;
        Intrinsics.checkNotNullParameter(r8, "value");
        int r0 = (r8.unknownFields().size() + Command.ADAPTER.l(1, r8.getCmd())) + ProtoAdapter.i.l(2, r8.getStatus());
        w r1 = ProtoAdapter.q;
        int r2 = ((((r0 + r1.l(3, r8.getMessage())) + r1.l(4, r8.getContext_id())) + r1.l(5, r8.getUser_id())) + r1.l(6, r8.getStart_callback_time())) + ProtoAdapter.k.l(7, r8.getTask_id());
        l r3 = ProtoAdapter.g;
        return (((((((r2 + r3.l(8, r8.is_err())) + Packet.StreamStatus.ADAPTER.l(9, r8.getStream_status())) + r1.l(10, r8.getMail_account_id())) + Trace.ADAPTER.l(11, r8.getTrace())) + r3.l(12, r8.getVerify_user_id())) + ProtoAdapter.l.l(13, r8.getUser_container_id())) + ((ProtoAdapter) this.v.getValue()).l(14, r8.getBiz_response_meta())) + ProtoAdapter.p.l(9999, r8.getPayload());
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void f(j0 r6, Packet r7) {
        Packet r8 = r7;
        Intrinsics.checkNotNullParameter(r6, "writer");
        Intrinsics.checkNotNullParameter(r8, "value");
        Command.ADAPTER.i(r6, 1, r8.getCmd());
        ProtoAdapter.i.i(r6, 2, r8.getStatus());
        w r0 = ProtoAdapter.q;
        r0.i(r6, 3, r8.getMessage());
        r0.i(r6, 4, r8.getContext_id());
        r0.i(r6, 5, r8.getUser_id());
        r0.i(r6, 6, r8.getStart_callback_time());
        ProtoAdapter.k.i(r6, 7, r8.getTask_id());
        l r1 = ProtoAdapter.g;
        r1.i(r6, 8, r8.is_err());
        Packet.StreamStatus.ADAPTER.i(r6, 9, r8.getStream_status());
        r0.i(r6, 10, r8.getMail_account_id());
        Trace.ADAPTER.i(r6, 11, r8.getTrace());
        r1.i(r6, 12, r8.getVerify_user_id());
        ProtoAdapter.l.i(r6, 13, r8.getUser_container_id());
        ((ProtoAdapter) this.v.getValue()).i(r6, 14, r8.getBiz_response_meta());
        ProtoAdapter.p.i(r6, 9999, r8.getPayload());
        r6.a(r8.unknownFields());
    }

    @Override // com.lark.wire.ProtoAdapter
    public final void g(n0 r6, Packet r7) {
        Packet r8 = r7;
        Intrinsics.checkNotNullParameter(r6, "writer");
        Intrinsics.checkNotNullParameter(r8, "value");
        r6.d(r8.unknownFields());
        ProtoAdapter.p.j(r6, 9999, r8.getPayload());
        ((ProtoAdapter) this.v.getValue()).j(r6, 14, r8.getBiz_response_meta());
        ProtoAdapter.l.j(r6, 13, r8.getUser_container_id());
        l r0 = ProtoAdapter.g;
        r0.j(r6, 12, r8.getVerify_user_id());
        Trace.ADAPTER.j(r6, 11, r8.getTrace());
        w r1 = ProtoAdapter.q;
        r1.j(r6, 10, r8.getMail_account_id());
        Packet.StreamStatus.ADAPTER.j(r6, 9, r8.getStream_status());
        r0.j(r6, 8, r8.is_err());
        ProtoAdapter.k.j(r6, 7, r8.getTask_id());
        r1.j(r6, 6, r8.getStart_callback_time());
        r1.j(r6, 5, r8.getUser_id());
        r1.j(r6, 4, r8.getContext_id());
        r1.j(r6, 3, r8.getMessage());
        ProtoAdapter.i.j(r6, 2, r8.getStatus());
        Command.ADAPTER.j(r6, 1, r8.getCmd());
    }

    public Packet$Companion$ADAPTER$1(FieldEncoding r7, KClass<Packet> r8, Syntax r9) {
        super(r7, r8, "type.googleapis.com/basic.v1.Packet", r9, null);
        this.v = LazyKt.lazy(Packet$Companion$ADAPTER$1$biz_response_metaAdapter$2.INSTANCE);
    }
}
