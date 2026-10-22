package com.lark.kmp.pb.basic.v1;

import com.lark.kmp.pb.calendar.v1.CalendarEventAttendee;
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
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 $2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002#$B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010!\u001a\u00020\u0002H\u0016J\b\u0010\"\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0016\u0010\u000fR\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0017\u0010\u0019R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u000bR\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u0006%"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/AttendeeRSVPInfo;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/AttendeeRSVPInfo$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/AttendeeRSVPInfo$Builder;Lokio/ByteString;)V", "display_name", "", "getDisplay_name", "()Ljava/lang/String;", "calendar_id", "", "getCalendar_id", "()Ljava/lang/Long;", "Ljava/lang/Long;", "status", "Lcom/lark/kmp/pb/calendar/v1/CalendarEventAttendee$Status;", "getStatus", "()Lcom/lark/kmp/pb/calendar/v1/CalendarEventAttendee$Status;", "chatter_id", "getChatter_id", "is_optional", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "avatar_key", "getAvatar_key", "description", "Lcom/lark/kmp/pb/basic/v1/Chatter$Description;", "getDescription", "()Lcom/lark/kmp/pb/basic/v1/Chatter$Description;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class AttendeeRSVPInfo extends com.lark.wire.Message<AttendeeRSVPInfo, a> {
    public static final ProtoAdapter<AttendeeRSVPInfo> ADAPTER = null;
    public static final c Companion = null;
    public static final String DEFAULT_AVATAR_KEY = "";
    public static final String DEFAULT_DISPLAY_NAME = "";
    private static final long serialVersionUID = 0;
    private final String avatar_key;
    private final Long calendar_id;
    private final Long chatter_id;
    private final Chatter.Description description;
    private final String display_name;
    private final Boolean is_optional;
    private final CalendarEventAttendee.Status status;

    public static final class a extends com.lark.wire.Message.a<AttendeeRSVPInfo, a> {
        public String d;
        public Long e;
        public CalendarEventAttendee.Status f;
        public Long g;
        public Boolean h;
        public String i;
        public Chatter.Description j;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new AttendeeRSVPInfo(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<AttendeeRSVPInfo> {
        @Override // com.lark.wire.ProtoAdapter
        public final AttendeeRSVPInfo c(g0 r10) {
            Intrinsics.checkNotNullParameter(r10, "reader");
            a r1 = new a();
            long r2 = r10.c();
        L3:
            int r4 = r10.e();
            if (r4 == (-1)) goto L18;
            switch(r4) {
                case 1: goto L16;
                case 2: goto L15;
                case 3: goto L19;
                case 4: goto L10;
                case 5: goto L9;
                case 6: goto L8;
                case 7: goto L7;
                default: goto L6;
            };
        L19:
            r1.f = CalendarEventAttendee.Status.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r5 = Unit.INSTANCE;
            goto L3
        L7:
            r1.j = Chatter.Description.ADAPTER.c(r10);
            goto L3
        L8:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.i = r10.i();
            goto L3
        L9:
            r1.h = (Boolean) ProtoAdapter.g.c(r10);
            goto L3
        L10:
            r1.g = (Long) ProtoAdapter.k.c(r10);
            goto L3
        L15:
            r1.e = (Long) ProtoAdapter.k.c(r10);
            goto L3
        L16:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.d = r10.i();
            goto L3
        L6:
            r10.j(r4);
            Unit r6 = Unit.INSTANCE;
            goto L3
        L18:
            return new AttendeeRSVPInfo(r1, r10.d(r2), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(AttendeeRSVPInfo r7) {
            AttendeeRSVPInfo r8 = r7;
            Intrinsics.checkNotNullParameter(r8, "value");
            int r0 = r8.unknownFields().size();
            w r1 = ProtoAdapter.q;
            int r2 = r0 + r1.l(1, r8.getDisplay_name());
            t r3 = ProtoAdapter.k;
            return (((((r2 + r3.l(2, r8.getCalendar_id())) + CalendarEventAttendee.Status.ADAPTER.l(3, r8.getStatus())) + r3.l(4, r8.getChatter_id())) + ProtoAdapter.g.l(5, r8.is_optional())) + r1.l(6, r8.getAvatar_key())) + Chatter.Description.ADAPTER.l(7, r8.getDescription());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r6, AttendeeRSVPInfo r7) {
            AttendeeRSVPInfo r8 = r7;
            Intrinsics.checkNotNullParameter(r6, "writer");
            Intrinsics.checkNotNullParameter(r8, "value");
            w r0 = ProtoAdapter.q;
            r0.i(r6, 1, r8.getDisplay_name());
            t r1 = ProtoAdapter.k;
            r1.i(r6, 2, r8.getCalendar_id());
            CalendarEventAttendee.Status.ADAPTER.i(r6, 3, r8.getStatus());
            r1.i(r6, 4, r8.getChatter_id());
            ProtoAdapter.g.i(r6, 5, r8.is_optional());
            r0.i(r6, 6, r8.getAvatar_key());
            Chatter.Description.ADAPTER.i(r6, 7, r8.getDescription());
            r6.a(r8.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r6, AttendeeRSVPInfo r7) {
            AttendeeRSVPInfo r8 = r7;
            Intrinsics.checkNotNullParameter(r6, "writer");
            Intrinsics.checkNotNullParameter(r8, "value");
            r6.d(r8.unknownFields());
            Chatter.Description.ADAPTER.j(r6, 7, r8.getDescription());
            w r0 = ProtoAdapter.q;
            r0.j(r6, 6, r8.getAvatar_key());
            ProtoAdapter.g.j(r6, 5, r8.is_optional());
            t r1 = ProtoAdapter.k;
            r1.j(r6, 4, r8.getChatter_id());
            CalendarEventAttendee.Status.ADAPTER.j(r6, 3, r8.getStatus());
            r1.j(r6, 2, r8.getCalendar_id());
            r0.j(r6, 1, r8.getDisplay_name());
        }

        public b(FieldEncoding r7, KClass<AttendeeRSVPInfo> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.AttendeeRSVPInfo", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ AttendeeRSVPInfo(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(AttendeeRSVPInfo.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.display_name;
        r0.e = this.calendar_id;
        r0.f = this.status;
        r0.g = this.chatter_id;
        r0.h = this.is_optional;
        r0.i = this.avatar_key;
        r0.j = this.description;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(AttendeeRSVPInfo.class).getSimpleName() + '@' + hashCode();
    }

    public final String getAvatar_key() {
        return this.avatar_key;
    }

    public final Long getCalendar_id() {
        return this.calendar_id;
    }

    public final Long getChatter_id() {
        return this.chatter_id;
    }

    public final Chatter.Description getDescription() {
        return this.description;
    }

    public final String getDisplay_name() {
        return this.display_name;
    }

    public final CalendarEventAttendee.Status getStatus() {
        return this.status;
    }

    public final Boolean is_optional() {
        return this.is_optional;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public AttendeeRSVPInfo(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.display_name = r2.d;
        this.calendar_id = r2.e;
        this.status = r2.f;
        this.chatter_id = r2.g;
        this.is_optional = r2.h;
        this.avatar_key = r2.i;
        this.description = r2.j;
    }

    public /* synthetic */ AttendeeRSVPInfo(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
