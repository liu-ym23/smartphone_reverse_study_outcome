package com.lark.kmp.pb.basic.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 \u00122\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0011\u0012B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\b\u0010\u0010\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/MessageLocalData;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/MessageLocalData$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/MessageLocalData$Builder;Lokio/ByteString;)V", "json_data_string", "", "getJson_data_string", "()Ljava/lang/String;", "pb_data", "getPb_data", "()Lokio/ByteString;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class MessageLocalData extends com.lark.wire.Message<MessageLocalData, a> {
    public static final ProtoAdapter<MessageLocalData> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final String json_data_string;
    private final ByteString pb_data;

    public static final class a extends com.lark.wire.Message.a<MessageLocalData, a> {
        public String d;
        public ByteString e;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new MessageLocalData(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<MessageLocalData> {
        @Override // com.lark.wire.ProtoAdapter
        public final MessageLocalData c(g0 r7) {
            Intrinsics.checkNotNullParameter(r7, "reader");
            a r1 = new a();
            long r2 = r7.c();
        L3:
            int r4 = r7.e();
            if (r4 == (-1)) goto L13;
            if (r4 != 1) goto L8;
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r7, "reader");
            r1.d = r7.i();
            goto L3
        L8:
            if (r4 != 2) goto L9;
            ProtoAdapter.p.getClass();
            Intrinsics.checkNotNullParameter(r7, "reader");
            r1.e = r7.f();
            goto L3
        L9:
            r7.j(r4);
            Unit r5 = Unit.INSTANCE;
            goto L3
        L13:
            return new MessageLocalData(r1, r7.d(r2), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(MessageLocalData r5) {
            MessageLocalData r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            return (r6.unknownFields().size() + ProtoAdapter.q.l(1, r6.getJson_data_string())) + ProtoAdapter.p.l(2, r6.getPb_data());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, MessageLocalData r5) {
            MessageLocalData r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            ProtoAdapter.q.i(r4, 1, r6.getJson_data_string());
            ProtoAdapter.p.i(r4, 2, r6.getPb_data());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, MessageLocalData r5) {
            MessageLocalData r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            ProtoAdapter.p.j(r4, 2, r6.getPb_data());
            ProtoAdapter.q.j(r4, 1, r6.getJson_data_string());
        }

        public b(FieldEncoding r7, KClass<MessageLocalData> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.MessageLocalData", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ MessageLocalData(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(MessageLocalData.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.json_data_string;
        r0.e = this.pb_data;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(MessageLocalData.class).getSimpleName() + '@' + hashCode();
    }

    public final String getJson_data_string() {
        return this.json_data_string;
    }

    public final ByteString getPb_data() {
        return this.pb_data;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public MessageLocalData(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.json_data_string = r2.d;
        this.pb_data = r2.e;
    }

    public /* synthetic */ MessageLocalData(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
