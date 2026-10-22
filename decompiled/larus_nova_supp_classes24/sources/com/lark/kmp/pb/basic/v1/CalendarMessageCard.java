package com.lark.kmp.pb.basic.v1;

import com.lark.kmp.pb.calendar.v1.Calendar;
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
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000  2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001f B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001d\u001a\u00020\u0002H\u0016J\b\u0010\u001e\u001a\u00020\tH\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0015\u0010\u0017R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006!"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/CalendarMessageCard;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/CalendarMessageCard$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/CalendarMessageCard$Builder;Lokio/ByteString;)V", "calendar_id", "", "getCalendar_id", "()Ljava/lang/String;", "inviter_user_id", "getInviter_user_id", "summary", "getSummary", "type", "", "getType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "is_primary", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "self_access_role", "Lcom/lark/kmp/pb/calendar/v1/Calendar$AccessRole;", "getSelf_access_role", "()Lcom/lark/kmp/pb/calendar/v1/Calendar$AccessRole;", "newBuilder", "toString", "Builder", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class CalendarMessageCard extends com.lark.wire.Message<CalendarMessageCard, a> {
    public static final ProtoAdapter<CalendarMessageCard> ADAPTER = null;
    public static final c Companion = null;
    public static final String DEFAULT_CALENDAR_ID = "";
    public static final String DEFAULT_INVITER_USER_ID = "";
    public static final boolean DEFAULT_IS_PRIMARY = false;
    public static final Calendar.AccessRole DEFAULT_SELF_ACCESS_ROLE = null;
    public static final String DEFAULT_SUMMARY = "";
    public static final int DEFAULT_TYPE = 1;
    private static final long serialVersionUID = 0;
    private final String calendar_id;
    private final String inviter_user_id;
    private final Boolean is_primary;
    private final Calendar.AccessRole self_access_role;
    private final String summary;
    private final Integer type;

    public static final class a extends com.lark.wire.Message.a<CalendarMessageCard, a> {
        public String d;
        public String e;
        public String f;
        public Integer g;
        public Boolean h;
        public Calendar.AccessRole i;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new CalendarMessageCard(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<CalendarMessageCard> {
        @Override // com.lark.wire.ProtoAdapter
        public final CalendarMessageCard c(g0 r10) {
            Intrinsics.checkNotNullParameter(r10, "reader");
            a r1 = new a();
            long r2 = r10.c();
        L3:
            int r4 = r10.e();
            if (r4 == (-1)) goto L17;
            switch(r4) {
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L13;
                case 4: goto L12;
                case 5: goto L11;
                case 6: goto L18;
                default: goto L6;
            };
        L18:
            r1.i = Calendar.AccessRole.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L9
        L9:
            e = move-exception;
            r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r5 = Unit.INSTANCE;
            goto L3
        L11:
            r1.h = (Boolean) ProtoAdapter.g.c(r10);
            goto L3
        L12:
            r1.g = (Integer) ProtoAdapter.h.c(r10);
            goto L3
        L13:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.f = r10.i();
            goto L3
        L14:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.e = r10.i();
            goto L3
        L15:
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            r1.d = r10.i();
            goto L3
        L6:
            r10.j(r4);
            Unit r6 = Unit.INSTANCE;
            goto L3
        L17:
            return new CalendarMessageCard(r1, r10.d(r2), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(CalendarMessageCard r5) {
            CalendarMessageCard r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            int r0 = r6.unknownFields().size();
            w r1 = ProtoAdapter.q;
            return (((((r0 + r1.l(1, r6.getCalendar_id())) + r1.l(2, r6.getInviter_user_id())) + r1.l(3, r6.getSummary())) + ProtoAdapter.h.l(4, r6.getType())) + ProtoAdapter.g.l(5, r6.is_primary())) + Calendar.AccessRole.ADAPTER.l(6, r6.getSelf_access_role());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, CalendarMessageCard r5) {
            CalendarMessageCard r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            w r0 = ProtoAdapter.q;
            r0.i(r4, 1, r6.getCalendar_id());
            r0.i(r4, 2, r6.getInviter_user_id());
            r0.i(r4, 3, r6.getSummary());
            ProtoAdapter.h.i(r4, 4, r6.getType());
            ProtoAdapter.g.i(r4, 5, r6.is_primary());
            Calendar.AccessRole.ADAPTER.i(r4, 6, r6.getSelf_access_role());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, CalendarMessageCard r5) {
            CalendarMessageCard r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            Calendar.AccessRole.ADAPTER.j(r4, 6, r6.getSelf_access_role());
            ProtoAdapter.g.j(r4, 5, r6.is_primary());
            ProtoAdapter.h.j(r4, 4, r6.getType());
            w r0 = ProtoAdapter.q;
            r0.j(r4, 3, r6.getSummary());
            r0.j(r4, 2, r6.getInviter_user_id());
            r0.j(r4, 1, r6.getCalendar_id());
        }

        public b(FieldEncoding r7, KClass<CalendarMessageCard> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.CalendarMessageCard", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ CalendarMessageCard(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        DEFAULT_SELF_ACCESS_ROLE = Calendar.AccessRole.UNKNOWN_ACCESS_ROLE;
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(CalendarMessageCard.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.calendar_id;
        r0.e = this.inviter_user_id;
        r0.f = this.summary;
        r0.g = this.type;
        r0.h = this.is_primary;
        r0.i = this.self_access_role;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(CalendarMessageCard.class).getSimpleName() + '@' + hashCode();
    }

    public final String getCalendar_id() {
        return this.calendar_id;
    }

    public final String getInviter_user_id() {
        return this.inviter_user_id;
    }

    public final Calendar.AccessRole getSelf_access_role() {
        return this.self_access_role;
    }

    public final String getSummary() {
        return this.summary;
    }

    public final Integer getType() {
        return this.type;
    }

    public final Boolean is_primary() {
        return this.is_primary;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public CalendarMessageCard(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.calendar_id = r2.d;
        this.inviter_user_id = r2.e;
        this.summary = r2.f;
        this.type = r2.g;
        this.is_primary = r2.h;
        this.self_access_role = r2.i;
    }

    public /* synthetic */ CalendarMessageCard(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
