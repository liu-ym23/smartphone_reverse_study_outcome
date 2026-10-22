package com.lark.kmp.pb.calendar.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.Message;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.lark.wire.t;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\n\u0018\u0000 \u001a2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0019\u001aB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0017\u001a\u00020\u0002H\u0016J\b\u0010\u0018\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\f\u0010\u000eR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0016\u0010\u0013¨\u0006\u001b"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/CalendarSyncInfo;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/calendar/v1/CalendarSyncInfo$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/calendar/v1/CalendarSyncInfo$Builder;Lokio/ByteString;)V", "calendar_id", "", "getCalendar_id", "()Ljava/lang/String;", "is_syncing", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "min_instance_cache_time", "", "getMin_instance_cache_time", "()Ljava/lang/Long;", "Ljava/lang/Long;", "max_instance_cache_time", "getMax_instance_cache_time", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class CalendarSyncInfo extends Message<CalendarSyncInfo, a> {
    public static final ProtoAdapter<CalendarSyncInfo> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final String calendar_id;
    private final Boolean is_syncing;
    private final Long max_instance_cache_time;
    private final Long min_instance_cache_time;

    public static final class a extends Message.a<CalendarSyncInfo, a> {
        public String d;
        public Boolean e;
        public Long f;
        public Long g;

        @Override // com.lark.wire.Message.a
        public final Message b() {
            return new CalendarSyncInfo(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<CalendarSyncInfo> {
        @Override // com.lark.wire.ProtoAdapter
        public final CalendarSyncInfo c(g0 r7) {
            Intrinsics.checkNotNullParameter(r7, "reader");
            a r1 = new a();
            long r2 = r7.c();
        L3:
            int r4 = r7.e();
            if (r4 == (-1)) goto L19;
            if (r4 != 1) goto L8;
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r7, "reader");
            r1.d = r7.i();
            goto L3
        L8:
            if (r4 != 2) goto L10;
            r1.e = (Boolean) ProtoAdapter.g.c(r7);
            goto L3
        L10:
            if (r4 != 3) goto L12;
            r1.f = (Long) ProtoAdapter.k.c(r7);
            goto L3
        L12:
            if (r4 != 4) goto L13;
            r1.g = (Long) ProtoAdapter.k.c(r7);
            goto L3
        L13:
            r7.j(r4);
            Unit r5 = Unit.INSTANCE;
            goto L3
        L19:
            return new CalendarSyncInfo(r1, r7.d(r2), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(CalendarSyncInfo r5) {
            CalendarSyncInfo r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            int r0 = (r6.unknownFields().size() + ProtoAdapter.q.l(1, r6.getCalendar_id())) + ProtoAdapter.g.l(2, r6.is_syncing());
            t r1 = ProtoAdapter.k;
            return (r0 + r1.l(3, r6.getMin_instance_cache_time())) + r1.l(4, r6.getMax_instance_cache_time());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, CalendarSyncInfo r5) {
            CalendarSyncInfo r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            ProtoAdapter.q.i(r4, 1, r6.getCalendar_id());
            ProtoAdapter.g.i(r4, 2, r6.is_syncing());
            t r0 = ProtoAdapter.k;
            r0.i(r4, 3, r6.getMin_instance_cache_time());
            r0.i(r4, 4, r6.getMax_instance_cache_time());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, CalendarSyncInfo r5) {
            CalendarSyncInfo r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            t r0 = ProtoAdapter.k;
            r0.j(r4, 4, r6.getMax_instance_cache_time());
            r0.j(r4, 3, r6.getMin_instance_cache_time());
            ProtoAdapter.g.j(r4, 2, r6.is_syncing());
            ProtoAdapter.q.j(r4, 1, r6.getCalendar_id());
        }

        public b(FieldEncoding r7, KClass<CalendarSyncInfo> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/calendar.v1.CalendarSyncInfo", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ CalendarSyncInfo(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(CalendarSyncInfo.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.calendar_id;
        r0.e = this.is_syncing;
        r0.f = this.min_instance_cache_time;
        r0.g = this.max_instance_cache_time;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(CalendarSyncInfo.class).getSimpleName() + '@' + hashCode();
    }

    public final String getCalendar_id() {
        return this.calendar_id;
    }

    public final Long getMax_instance_cache_time() {
        return this.max_instance_cache_time;
    }

    public final Long getMin_instance_cache_time() {
        return this.min_instance_cache_time;
    }

    public final Boolean is_syncing() {
        return this.is_syncing;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ Message.a newBuilder() {
        return newBuilder();
    }

    public CalendarSyncInfo(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.calendar_id = r2.d;
        this.is_syncing = r2.e;
        this.min_instance_cache_time = r2.f;
        this.max_instance_cache_time = r2.g;
    }

    public /* synthetic */ CalendarSyncInfo(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
