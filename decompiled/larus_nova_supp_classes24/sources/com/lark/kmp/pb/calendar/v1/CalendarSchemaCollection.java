package com.lark.kmp.pb.calendar.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.Message;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00152\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0014\u0015B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/CalendarSchemaCollection;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/calendar/v1/CalendarSchemaCollection$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/calendar/v1/CalendarSchemaCollection$Builder;Lokio/ByteString;)V", "entity_schemas", "", "Lcom/lark/kmp/pb/calendar/v1/EntitySchema;", "getEntity_schemas", "()Ljava/util/List;", "compatibility", "Lcom/lark/kmp/pb/calendar/v1/CalendarSchemaCompatibility;", "getCompatibility", "()Lcom/lark/kmp/pb/calendar/v1/CalendarSchemaCompatibility;", "newBuilder", "toString", "", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class CalendarSchemaCollection extends Message<CalendarSchemaCollection, a> {
    public static final ProtoAdapter<CalendarSchemaCollection> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final CalendarSchemaCompatibility compatibility;
    private final List<EntitySchema> entity_schemas;

    public static final class a extends Message.a<CalendarSchemaCollection, a> {
        public List<EntitySchema> d;
        public CalendarSchemaCompatibility e;

        @Override // com.lark.wire.Message.a
        public final Message b() {
            return new CalendarSchemaCollection(this, c(), null);
        }

        public a() {
            this.d = CollectionsKt.emptyList();
        }
    }

    public static final class b extends ProtoAdapter<CalendarSchemaCollection> {
        @Override // com.lark.wire.ProtoAdapter
        public final CalendarSchemaCollection c(g0 r7) {
            Intrinsics.checkNotNullParameter(r7, "reader");
            a r0 = new a();
            ArrayList r1 = new ArrayList();
            long r2 = r7.c();
        L3:
            int r4 = r7.e();
            if (r4 == (-1)) goto L12;
            if (r4 != 1) goto L8;
            r1.add(EntitySchema.ADAPTER.c(r7));
            goto L3
        L8:
            if (r4 != 2) goto L9;
            r0.e = CalendarSchemaCompatibility.ADAPTER.c(r7);
            goto L3
        L9:
            r7.j(r4);
            goto L3
        L12:
            ByteString r8 = r7.d(r2);
            Intrinsics.checkNotNullParameter(r1, "entity_schemas");
            com.lark.wire.internal.a.a(r1);
            r0.d = r1;
            return new CalendarSchemaCollection(r0, r8, null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(CalendarSchemaCollection r5) {
            CalendarSchemaCollection r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            return (r6.unknownFields().size() + EntitySchema.ADAPTER.a().l(1, r6.getEntity_schemas())) + CalendarSchemaCompatibility.ADAPTER.l(2, r6.getCompatibility());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, CalendarSchemaCollection r5) {
            CalendarSchemaCollection r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            EntitySchema.ADAPTER.a().i(r4, 1, r6.getEntity_schemas());
            CalendarSchemaCompatibility.ADAPTER.i(r4, 2, r6.getCompatibility());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, CalendarSchemaCollection r5) {
            CalendarSchemaCollection r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            CalendarSchemaCompatibility.ADAPTER.j(r4, 2, r6.getCompatibility());
            EntitySchema.ADAPTER.a().j(r4, 1, r6.getEntity_schemas());
        }

        public b(FieldEncoding r7, KClass<CalendarSchemaCollection> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/calendar.v1.CalendarSchemaCollection", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ CalendarSchemaCollection(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(CalendarSchemaCollection.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.entity_schemas;
        r0.e = this.compatibility;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(CalendarSchemaCollection.class).getSimpleName() + '@' + hashCode();
    }

    public final CalendarSchemaCompatibility getCompatibility() {
        return this.compatibility;
    }

    public final List<EntitySchema> getEntity_schemas() {
        return this.entity_schemas;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ Message.a newBuilder() {
        return newBuilder();
    }

    public CalendarSchemaCollection(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.entity_schemas = com.lark.wire.internal.a.c("entity_schemas", r2.d);
        this.compatibility = r2.e;
    }

    public /* synthetic */ CalendarSchemaCollection(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
