package com.lark.kmp.pb.calendar.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.Message;
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
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u001d2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001c\u001dB\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001a\u001a\u00020\u0002H\u0016J\b\u0010\u001b\u001a\u00020\u0017H\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001e"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/CalendarEventWebinarInfo;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/calendar/v1/CalendarEventWebinarInfo$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/calendar/v1/CalendarEventWebinarInfo$Builder;Lokio/ByteString;)V", "conf", "Lcom/lark/kmp/pb/calendar/v1/CalendarEventWebinarConf;", "getConf", "()Lcom/lark/kmp/pb/calendar/v1/CalendarEventWebinarConf;", "speakers", "Lcom/lark/kmp/pb/calendar/v1/CalendarEventWebinarAttendeeInfo;", "getSpeakers", "()Lcom/lark/kmp/pb/calendar/v1/CalendarEventWebinarAttendeeInfo;", "audiences", "getAudiences", "self_webinar_attendee_type", "Lcom/lark/kmp/pb/calendar/v1/WebinarAttendeeType;", "getSelf_webinar_attendee_type", "()Lcom/lark/kmp/pb/calendar/v1/WebinarAttendeeType;", "webinar_data", "", "getWebinar_data", "()Ljava/lang/String;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class CalendarEventWebinarInfo extends Message<CalendarEventWebinarInfo, a> {
    public static final ProtoAdapter<CalendarEventWebinarInfo> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final CalendarEventWebinarAttendeeInfo audiences;
    private final CalendarEventWebinarConf conf;
    private final WebinarAttendeeType self_webinar_attendee_type;
    private final CalendarEventWebinarAttendeeInfo speakers;
    private final String webinar_data;

    public static final class a extends Message.a<CalendarEventWebinarInfo, a> {
        public CalendarEventWebinarConf d;
        public CalendarEventWebinarAttendeeInfo e;
        public CalendarEventWebinarAttendeeInfo f;
        public WebinarAttendeeType g;
        public String h;

        @Override // com.lark.wire.Message.a
        public final Message b() {
            return new CalendarEventWebinarInfo(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<CalendarEventWebinarInfo> {
        @Override // com.lark.wire.ProtoAdapter
        public final CalendarEventWebinarInfo c(g0 r10) {
            Intrinsics.checkNotNullParameter(r10, "reader");
            a r1 = new a();
            long r2 = r10.c();
        L3:
            int r4 = r10.e();
            if (r4 == (-1)) goto L25;
            if (r4 != 1) goto L8;
            r1.d = CalendarEventWebinarConf.ADAPTER.c(r10);
            goto L3
        L8:
            if (r4 != 2) goto L10;
            r1.e = CalendarEventWebinarAttendeeInfo.ADAPTER.c(r10);
            goto L3
        L10:
            if (r4 != 3) goto L12;
            r1.f = CalendarEventWebinarAttendeeInfo.ADAPTER.c(r10);
            goto L3
        L12:
            if (r4 != 4) goto L14;
            r1.g = WebinarAttendeeType.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
        L19:
            e = move-exception;
            r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r5 = Unit.INSTANCE;
            goto L3
        L14:
            if (r4 != 5) goto L15;
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.h = r10.i();
            goto L3
        L15:
            r10.j(r4);
            Unit r6 = Unit.INSTANCE;
            goto L3
        L25:
            return new CalendarEventWebinarInfo(r1, r10.d(r2), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(CalendarEventWebinarInfo r5) {
            CalendarEventWebinarInfo r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            int r0 = r6.unknownFields().size() + CalendarEventWebinarConf.ADAPTER.l(1, r6.getConf());
            ProtoAdapter<CalendarEventWebinarAttendeeInfo> r1 = CalendarEventWebinarAttendeeInfo.ADAPTER;
            return (((r0 + r1.l(2, r6.getSpeakers())) + r1.l(3, r6.getAudiences())) + WebinarAttendeeType.ADAPTER.l(4, r6.getSelf_webinar_attendee_type())) + ProtoAdapter.q.l(5, r6.getWebinar_data());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, CalendarEventWebinarInfo r5) {
            CalendarEventWebinarInfo r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            CalendarEventWebinarConf.ADAPTER.i(r4, 1, r6.getConf());
            ProtoAdapter<CalendarEventWebinarAttendeeInfo> r0 = CalendarEventWebinarAttendeeInfo.ADAPTER;
            r0.i(r4, 2, r6.getSpeakers());
            r0.i(r4, 3, r6.getAudiences());
            WebinarAttendeeType.ADAPTER.i(r4, 4, r6.getSelf_webinar_attendee_type());
            ProtoAdapter.q.i(r4, 5, r6.getWebinar_data());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, CalendarEventWebinarInfo r5) {
            CalendarEventWebinarInfo r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            ProtoAdapter.q.j(r4, 5, r6.getWebinar_data());
            WebinarAttendeeType.ADAPTER.j(r4, 4, r6.getSelf_webinar_attendee_type());
            ProtoAdapter<CalendarEventWebinarAttendeeInfo> r0 = CalendarEventWebinarAttendeeInfo.ADAPTER;
            r0.j(r4, 3, r6.getAudiences());
            r0.j(r4, 2, r6.getSpeakers());
            CalendarEventWebinarConf.ADAPTER.j(r4, 1, r6.getConf());
        }

        public b(FieldEncoding r7, KClass<CalendarEventWebinarInfo> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/calendar.v1.CalendarEventWebinarInfo", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ CalendarEventWebinarInfo(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(CalendarEventWebinarInfo.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.conf;
        r0.e = this.speakers;
        r0.f = this.audiences;
        r0.g = this.self_webinar_attendee_type;
        r0.h = this.webinar_data;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(CalendarEventWebinarInfo.class).getSimpleName() + '@' + hashCode();
    }

    public final CalendarEventWebinarAttendeeInfo getAudiences() {
        return this.audiences;
    }

    public final CalendarEventWebinarConf getConf() {
        return this.conf;
    }

    public final WebinarAttendeeType getSelf_webinar_attendee_type() {
        return this.self_webinar_attendee_type;
    }

    public final CalendarEventWebinarAttendeeInfo getSpeakers() {
        return this.speakers;
    }

    public final String getWebinar_data() {
        return this.webinar_data;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ Message.a newBuilder() {
        return newBuilder();
    }

    public CalendarEventWebinarInfo(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.conf = r2.d;
        this.speakers = r2.e;
        this.audiences = r2.f;
        this.self_webinar_attendee_type = r2.g;
        this.webinar_data = r2.h;
    }

    public /* synthetic */ CalendarEventWebinarInfo(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
