package com.lark.kmp.pb.basic.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.lark.wire.w;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \u001a2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0019\u001aB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0017\u001a\u00020\u0002H\u0016J\b\u0010\u0018\u001a\u00020\tH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000bR\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001b"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/QuasiThread;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/QuasiThread$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/QuasiThread$Builder;Lokio/ByteString;)V", "id", "", "getId", "()Ljava/lang/String;", "channel", "Lcom/lark/kmp/pb/basic/v1/Channel;", "getChannel", "()Lcom/lark/kmp/pb/basic/v1/Channel;", "topic", "getTopic", "position", "", "getPosition", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class QuasiThread extends com.lark.wire.Message<QuasiThread, a> {
    public static final ProtoAdapter<QuasiThread> ADAPTER = null;
    public static final c Companion = null;
    public static final String DEFAULT_TOPIC = "";
    private static final long serialVersionUID = 0;
    private final Channel channel;
    private final String id;
    private final Integer position;
    private final String topic;

    public static final class a extends com.lark.wire.Message.a<QuasiThread, a> {
        public String d;
        public Channel e;
        public String f;
        public Integer g;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new QuasiThread(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<QuasiThread> {
        @Override // com.lark.wire.ProtoAdapter
        public final QuasiThread c(g0 r7) {
            Intrinsics.checkNotNullParameter(r7, "reader");
            a r1 = new a();
            long r2 = r7.c();
        L3:
            int r4 = r7.e();
            if (r4 == (-1)) goto L19;
            if (r4 != 1) goto L8;
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r7, "reader");
            String r5 = r7.i();
            Intrinsics.checkNotNullParameter(r5, "id");
            r1.d = r5;
            goto L3
        L8:
            if (r4 != 2) goto L10;
            r1.e = Channel.ADAPTER.c(r7);
            goto L3
        L10:
            if (r4 != 3) goto L12;
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r7, "reader");
            r1.f = r7.i();
            goto L3
        L12:
            if (r4 != 4) goto L13;
            r1.g = (Integer) ProtoAdapter.h.c(r7);
            goto L3
        L13:
            r7.j(r4);
            Unit r6 = Unit.INSTANCE;
            goto L3
        L19:
            return new QuasiThread(r1, r7.d(r2), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(QuasiThread r6) {
            QuasiThread r7 = r6;
            Intrinsics.checkNotNullParameter(r7, "value");
            int r0 = r7.unknownFields().size();
            w r1 = ProtoAdapter.q;
            return (((r0 + r1.l(1, r7.getId())) + Channel.ADAPTER.l(2, r7.getChannel())) + r1.l(3, r7.getTopic())) + ProtoAdapter.h.l(4, r7.getPosition());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r5, QuasiThread r6) {
            QuasiThread r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            w r0 = ProtoAdapter.q;
            r0.i(r5, 1, r7.getId());
            Channel.ADAPTER.i(r5, 2, r7.getChannel());
            r0.i(r5, 3, r7.getTopic());
            ProtoAdapter.h.i(r5, 4, r7.getPosition());
            r5.a(r7.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r5, QuasiThread r6) {
            QuasiThread r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            r5.d(r7.unknownFields());
            ProtoAdapter.h.j(r5, 4, r7.getPosition());
            w r0 = ProtoAdapter.q;
            r0.j(r5, 3, r7.getTopic());
            Channel.ADAPTER.j(r5, 2, r7.getChannel());
            r0.j(r5, 1, r7.getId());
        }

        public b(FieldEncoding r7, KClass<QuasiThread> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.QuasiThread", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ QuasiThread(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(QuasiThread.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.id;
        r0.e = this.channel;
        r0.f = this.topic;
        r0.g = this.position;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(QuasiThread.class).getSimpleName() + '@' + hashCode();
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final String getId() {
        return this.id;
    }

    public final Integer getPosition() {
        return this.position;
    }

    public final String getTopic() {
        return this.topic;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public QuasiThread(a r2, ByteString r3) {
        super(ADAPTER, r3);
        String r4 = r2.d;
        Intrinsics.checkNotNull(r4);
        this.id = r4;
        Channel r5 = r2.e;
        Intrinsics.checkNotNull(r5);
        this.channel = r5;
        this.topic = r2.f;
        this.position = r2.g;
    }

    public /* synthetic */ QuasiThread(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
