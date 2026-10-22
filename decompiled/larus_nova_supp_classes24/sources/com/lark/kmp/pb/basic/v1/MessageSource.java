package com.lark.kmp.pb.basic.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.lark.wire.w;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\u0018\u0000 \u00172\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0016\u0017B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0014\u001a\u00020\u0002H\u0016J\b\u0010\u0015\u001a\u00020\rH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0018"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/MessageSource;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/MessageSource$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/MessageSource$Builder;Lokio/ByteString;)V", "source_type", "Lcom/lark/kmp/pb/basic/v1/MessageSourceType;", "getSource_type", "()Lcom/lark/kmp/pb/basic/v1/MessageSourceType;", "source_id", "", "getSource_id", "()Ljava/lang/String;", "message_id_path", "", "getMessage_id_path", "()Ljava/util/List;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class MessageSource extends com.lark.wire.Message<MessageSource, a> {
    public static final ProtoAdapter<MessageSource> ADAPTER = null;
    public static final c Companion = null;
    public static final MessageSourceType DEFAULT_SOURCE_TYPE = null;
    private static final long serialVersionUID = 0;
    private final List<String> message_id_path;
    private final String source_id;
    private final MessageSourceType source_type;

    public static final class a extends com.lark.wire.Message.a<MessageSource, a> {
        public MessageSourceType d;
        public String e;
        public List<String> f;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new MessageSource(this, c(), null);
        }

        public a() {
            this.f = CollectionsKt.emptyList();
        }
    }

    public static final class b extends ProtoAdapter<MessageSource> {
        @Override // com.lark.wire.ProtoAdapter
        public final MessageSource c(g0 r11) {
            Intrinsics.checkNotNullParameter(r11, "reader");
            a r1 = new a();
            ArrayList r2 = new ArrayList();
            long r3 = r11.c();
        L3:
            int r5 = r11.e();
            if (r5 == (-1)) goto L18;
            if (r5 != 1) goto L8;
            MessageSourceType r6 = MessageSourceType.ADAPTER.c(r11);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
            Intrinsics.checkNotNullParameter(r6, "source_type");     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
            r1.d = r6;     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r11.a(r5, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r7 = Unit.INSTANCE;
            goto L3
        L8:
            if (r5 != 2) goto L10;
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r11, "reader");
            r1.e = r11.i();
            goto L3
        L10:
            if (r5 != 3) goto L11;
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r11, "reader");
            r2.add(r11.i());
            goto L3
        L11:
            r11.j(r5);
            goto L3
        L18:
            ByteString r12 = r11.d(r3);
            Intrinsics.checkNotNullParameter(r2, "message_id_path");
            com.lark.wire.internal.a.a(r2);
            r1.f = r2;
            return new MessageSource(r1, r12, null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(MessageSource r5) {
            MessageSource r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            int r0 = r6.unknownFields().size() + MessageSourceType.ADAPTER.l(1, r6.getSource_type());
            w r1 = ProtoAdapter.q;
            return (r0 + r1.l(2, r6.getSource_id())) + r1.a().l(3, r6.getMessage_id_path());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, MessageSource r5) {
            MessageSource r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            MessageSourceType.ADAPTER.i(r4, 1, r6.getSource_type());
            w r0 = ProtoAdapter.q;
            r0.i(r4, 2, r6.getSource_id());
            r0.a().i(r4, 3, r6.getMessage_id_path());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r5, MessageSource r6) {
            MessageSource r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            r5.d(r7.unknownFields());
            w r0 = ProtoAdapter.q;
            r0.a().j(r5, 3, r7.getMessage_id_path());
            r0.j(r5, 2, r7.getSource_id());
            MessageSourceType.ADAPTER.j(r5, 1, r7.getSource_type());
        }

        public b(FieldEncoding r7, KClass<MessageSource> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.MessageSource", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ MessageSource(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        DEFAULT_SOURCE_TYPE = MessageSourceType.COMMON_MESSAGE;
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(MessageSource.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.source_type;
        r0.e = this.source_id;
        r0.f = this.message_id_path;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(MessageSource.class).getSimpleName() + '@' + hashCode();
    }

    public final List<String> getMessage_id_path() {
        return this.message_id_path;
    }

    public final String getSource_id() {
        return this.source_id;
    }

    public final MessageSourceType getSource_type() {
        return this.source_type;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public MessageSource(a r2, ByteString r3) {
        super(ADAPTER, r3);
        MessageSourceType r4 = r2.d;
        Intrinsics.checkNotNull(r4);
        this.source_type = r4;
        this.source_id = r2.e;
        this.message_id_path = com.lark.wire.internal.a.c("message_id_path", r2.f);
    }

    public /* synthetic */ MessageSource(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
