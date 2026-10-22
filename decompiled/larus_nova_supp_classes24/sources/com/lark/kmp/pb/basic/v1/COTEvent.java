package com.lark.kmp.pb.basic.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.lark.wire.t;
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
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\t\u0018\u0000 \u001b2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001a\u001bB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0018\u001a\u00020\u0002H\u0016J\b\u0010\u0019\u001a\u00020\tH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000bR\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015¨\u0006\u001c"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/COTEvent;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/COTEvent$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/COTEvent$Builder;Lokio/ByteString;)V", "event_id", "", "getEvent_id", "()Ljava/lang/String;", "event_type", "Lcom/lark/kmp/pb/basic/v1/COTEventType;", "getEvent_type", "()Lcom/lark/kmp/pb/basic/v1/COTEventType;", "content", "getContent", "timestamp", "", "getTimestamp", "()J", "created_at", "getCreated_at", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class COTEvent extends com.lark.wire.Message<COTEvent, a> {
    public static final ProtoAdapter<COTEvent> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final String content;
    private final long created_at;
    private final String event_id;
    private final COTEventType event_type;
    private final long timestamp;

    public static final class a extends com.lark.wire.Message.a<COTEvent, a> {
        public String d;
        public COTEventType e;
        public String f;
        public Long g;
        public Long h;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new COTEvent(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<COTEvent> {
        @Override // com.lark.wire.ProtoAdapter
        public final COTEvent c(g0 r10) {
            Intrinsics.checkNotNullParameter(r10, "reader");
            a r1 = new a();
            long r2 = r10.c();
        L3:
            int r4 = r10.e();
            if (r4 == (-1)) goto L25;
            if (r4 != 1) goto L8;
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            String r5 = r10.i();
            Intrinsics.checkNotNullParameter(r5, "event_id");
            r1.d = r5;
            goto L3
        L8:
            if (r4 != 2) goto L10;
            COTEventType r6 = COTEventType.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L21
            Intrinsics.checkNotNullParameter(r6, "event_type");     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L21
            r1.e = r6;     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L21
        L21:
            e = move-exception;
            r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r7 = Unit.INSTANCE;
            goto L3
        L10:
            if (r4 != 3) goto L12;
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            String r8 = r10.i();
            Intrinsics.checkNotNullParameter(r8, "content");
            r1.f = r8;
            goto L3
        L12:
            if (r4 != 4) goto L14;
            r1.g = Long.valueOf(((Number) ProtoAdapter.k.c(r10)).longValue());
            goto L3
        L14:
            if (r4 != 5) goto L15;
            r1.h = Long.valueOf(((Number) ProtoAdapter.k.c(r10)).longValue());
            goto L3
        L15:
            r10.j(r4);
            Unit r9 = Unit.INSTANCE;
            goto L3
        L25:
            return new COTEvent(r1, r10.d(r2), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(COTEvent r6) {
            COTEvent r7 = r6;
            Intrinsics.checkNotNullParameter(r7, "value");
            int r0 = r7.unknownFields().size();
            w r1 = ProtoAdapter.q;
            int r2 = ((r0 + r1.l(1, r7.getEvent_id())) + COTEventType.ADAPTER.l(2, r7.getEvent_type())) + r1.l(3, r7.getContent());
            t r3 = ProtoAdapter.k;
            return (r2 + r3.l(4, Long.valueOf(r7.getTimestamp()))) + r3.l(5, Long.valueOf(r7.getCreated_at()));
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r5, COTEvent r6) {
            COTEvent r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            w r0 = ProtoAdapter.q;
            r0.i(r5, 1, r7.getEvent_id());
            COTEventType.ADAPTER.i(r5, 2, r7.getEvent_type());
            r0.i(r5, 3, r7.getContent());
            t r1 = ProtoAdapter.k;
            r1.i(r5, 4, Long.valueOf(r7.getTimestamp()));
            r1.i(r5, 5, Long.valueOf(r7.getCreated_at()));
            r5.a(r7.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r5, COTEvent r6) {
            COTEvent r7 = r6;
            Intrinsics.checkNotNullParameter(r5, "writer");
            Intrinsics.checkNotNullParameter(r7, "value");
            r5.d(r7.unknownFields());
            t r0 = ProtoAdapter.k;
            r0.j(r5, 5, Long.valueOf(r7.getCreated_at()));
            r0.j(r5, 4, Long.valueOf(r7.getTimestamp()));
            w r1 = ProtoAdapter.q;
            r1.j(r5, 3, r7.getContent());
            COTEventType.ADAPTER.j(r5, 2, r7.getEvent_type());
            r1.j(r5, 1, r7.getEvent_id());
        }

        public b(FieldEncoding r7, KClass<COTEvent> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.COTEvent", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ COTEvent(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(COTEvent.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.event_id;
        r0.e = this.event_type;
        r0.f = this.content;
        r0.g = Long.valueOf(this.timestamp);
        r0.h = Long.valueOf(this.created_at);
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(COTEvent.class).getSimpleName() + '@' + hashCode();
    }

    public final String getContent() {
        return this.content;
    }

    public final long getCreated_at() {
        return this.created_at;
    }

    public final String getEvent_id() {
        return this.event_id;
    }

    public final COTEventType getEvent_type() {
        return this.event_type;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public COTEvent(a r3, ByteString r4) {
        super(ADAPTER, r4);
        String r5 = r3.d;
        Intrinsics.checkNotNull(r5);
        this.event_id = r5;
        COTEventType r6 = r3.e;
        Intrinsics.checkNotNull(r6);
        this.event_type = r6;
        String r7 = r3.f;
        Intrinsics.checkNotNull(r7);
        this.content = r7;
        Long r8 = r3.g;
        Intrinsics.checkNotNull(r8);
        this.timestamp = r8.longValue();
        Long r9 = r3.h;
        Intrinsics.checkNotNull(r9);
        this.created_at = r9.longValue();
    }

    public /* synthetic */ COTEvent(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
