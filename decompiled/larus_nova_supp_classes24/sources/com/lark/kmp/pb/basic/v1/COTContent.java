package com.lark.kmp.pb.basic.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.l;
import com.lark.wire.n0;
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
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u0000  2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001f B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001d\u001a\u00020\u0002H\u0016J\b\u0010\u001e\u001a\u00020\tH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0015\u0010\u0019\u001a\u0004\u0018\u00010\u0016¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001b¨\u0006!"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/COTContent;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/COTContent$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/COTContent$Builder;Lokio/ByteString;)V", "cot_id", "", "getCot_id", "()Ljava/lang/String;", "cot_events", "", "Lcom/lark/kmp/pb/basic/v1/COTEvent;", "getCot_events", "()Ljava/util/List;", "cot_status", "Lcom/lark/kmp/pb/basic/v1/COTStatus;", "getCot_status", "()Lcom/lark/kmp/pb/basic/v1/COTStatus;", "violated", "", "getViolated", "()Z", "cot_events_incomplete", "getCot_events_incomplete", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class COTContent extends com.lark.wire.Message<COTContent, a> {
    public static final ProtoAdapter<COTContent> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final List<COTEvent> cot_events;
    private final Boolean cot_events_incomplete;
    private final String cot_id;
    private final COTStatus cot_status;
    private final boolean violated;

    public static final class a extends com.lark.wire.Message.a<COTContent, a> {
        public String d;
        public List<COTEvent> e;
        public COTStatus f;
        public Boolean g;
        public Boolean h;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new COTContent(this, c(), null);
        }

        public a() {
            this.e = CollectionsKt.emptyList();
        }
    }

    public static final class b extends ProtoAdapter<COTContent> {
        @Override // com.lark.wire.ProtoAdapter
        public final COTContent c(g0 r11) {
            Intrinsics.checkNotNullParameter(r11, "reader");
            a r1 = new a();
            ArrayList r2 = new ArrayList();
            long r3 = r11.c();
        L3:
            int r5 = r11.e();
            if (r5 == (-1)) goto L24;
            if (r5 != 1) goto L8;
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r11, "reader");
            String r6 = r11.i();
            Intrinsics.checkNotNullParameter(r6, "cot_id");
            r1.d = r6;
            goto L3
        L8:
            if (r5 != 2) goto L10;
            r2.add(COTEvent.ADAPTER.c(r11));
            goto L3
        L10:
            if (r5 != 3) goto L12;
            COTStatus r7 = COTStatus.ADAPTER.c(r11);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L20
            Intrinsics.checkNotNullParameter(r7, "cot_status");     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L20
            r1.f = r7;     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L20
        L20:
            e = move-exception;
            r11.a(r5, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r8 = Unit.INSTANCE;
            goto L3
        L12:
            if (r5 != 4) goto L14;
            r1.g = Boolean.valueOf(((Boolean) ProtoAdapter.g.c(r11)).booleanValue());
            goto L3
        L14:
            if (r5 != 5) goto L15;
            r1.h = (Boolean) ProtoAdapter.g.c(r11);
            goto L3
        L15:
            r11.j(r5);
            Unit r9 = Unit.INSTANCE;
            goto L3
        L24:
            ByteString r12 = r11.d(r3);
            Intrinsics.checkNotNullParameter(r2, "cot_events");
            com.lark.wire.internal.a.a(r2);
            r1.e = r2;
            return new COTContent(r1, r12, null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(COTContent r5) {
            COTContent r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            int r0 = ((r6.unknownFields().size() + ProtoAdapter.q.l(1, r6.getCot_id())) + COTEvent.ADAPTER.a().l(2, r6.getCot_events())) + COTStatus.ADAPTER.l(3, r6.getCot_status());
            l r1 = ProtoAdapter.g;
            return (r0 + r1.l(4, Boolean.valueOf(r6.getViolated()))) + r1.l(5, r6.getCot_events_incomplete());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, COTContent r5) {
            COTContent r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            ProtoAdapter.q.i(r4, 1, r6.getCot_id());
            COTEvent.ADAPTER.a().i(r4, 2, r6.getCot_events());
            COTStatus.ADAPTER.i(r4, 3, r6.getCot_status());
            l r0 = ProtoAdapter.g;
            r0.i(r4, 4, Boolean.valueOf(r6.getViolated()));
            r0.i(r4, 5, r6.getCot_events_incomplete());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, COTContent r5) {
            COTContent r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            l r0 = ProtoAdapter.g;
            r0.j(r4, 5, r6.getCot_events_incomplete());
            r0.j(r4, 4, Boolean.valueOf(r6.getViolated()));
            COTStatus.ADAPTER.j(r4, 3, r6.getCot_status());
            COTEvent.ADAPTER.a().j(r4, 2, r6.getCot_events());
            ProtoAdapter.q.j(r4, 1, r6.getCot_id());
        }

        public b(FieldEncoding r7, KClass<COTContent> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.COTContent", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ COTContent(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(COTContent.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.cot_id;
        r0.e = this.cot_events;
        r0.f = this.cot_status;
        r0.g = Boolean.valueOf(this.violated);
        r0.h = this.cot_events_incomplete;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(COTContent.class).getSimpleName() + '@' + hashCode();
    }

    public final List<COTEvent> getCot_events() {
        return this.cot_events;
    }

    public final Boolean getCot_events_incomplete() {
        return this.cot_events_incomplete;
    }

    public final String getCot_id() {
        return this.cot_id;
    }

    public final COTStatus getCot_status() {
        return this.cot_status;
    }

    public final boolean getViolated() {
        return this.violated;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public COTContent(a r2, ByteString r3) {
        super(ADAPTER, r3);
        String r4 = r2.d;
        Intrinsics.checkNotNull(r4);
        this.cot_id = r4;
        this.cot_events = com.lark.wire.internal.a.c("cot_events", r2.e);
        COTStatus r5 = r2.f;
        Intrinsics.checkNotNull(r5);
        this.cot_status = r5;
        Boolean r6 = r2.g;
        Intrinsics.checkNotNull(r6);
        this.violated = r6.booleanValue();
        this.cot_events_incomplete = r2.h;
    }

    public /* synthetic */ COTContent(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
