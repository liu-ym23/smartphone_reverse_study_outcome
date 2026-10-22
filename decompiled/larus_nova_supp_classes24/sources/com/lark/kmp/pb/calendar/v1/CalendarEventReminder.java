package com.lark.kmp.pb.calendar.v1;

import com.lark.wire.FieldEncoding;
import com.lark.wire.Message;
import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.d;
import com.lark.wire.g0;
import com.lark.wire.j0;
import com.lark.wire.n0;
import com.lark.wire.o0;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00172\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0016\u0017\u0018B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0014\u001a\u00020\u0002H\u0016J\b\u0010\u0015\u001a\u00020\tH\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0019"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/CalendarEventReminder;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/calendar/v1/CalendarEventReminder$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/calendar/v1/CalendarEventReminder$Builder;Lokio/ByteString;)V", "calendar_event_id", "", "getCalendar_event_id", "()Ljava/lang/String;", "minutes", "", "getMinutes", "()I", "method", "Lcom/lark/kmp/pb/calendar/v1/CalendarEventReminder$Method;", "getMethod", "()Lcom/lark/kmp/pb/calendar/v1/CalendarEventReminder$Method;", "newBuilder", "toString", "Builder", "Companion", "Method", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class CalendarEventReminder extends Message<CalendarEventReminder, a> {
    public static final ProtoAdapter<CalendarEventReminder> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final String calendar_event_id;
    private final Method method;
    private final int minutes;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \r2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/calendar/v1/CalendarEventReminder$Method;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "DEFAULT", "EMAIL", "POPUP", "SMS", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum Method extends Enum<Method> implements o0 {
        public static final ProtoAdapter<Method> ADAPTER = null;
        public static final b Companion = null;
        public static final Method DEFAULT = null;
        public static final Method EMAIL = null;
        public static final Method POPUP = null;
        public static final Method SMS = null;
        public static final /* synthetic */ Method[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<Method> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                Method.Companion.getClass();
                if (r2 == 1) goto L15;
                if (r2 == 2) goto L19;
                if (r2 == 3) goto L18;
                if (r2 == 4) goto L17;
                return null;
            L17:
                return Method.SMS;
            L18:
                return Method.POPUP;
            L19:
                return Method.EMAIL;
            L15:
                return Method.DEFAULT;
            }

            public a(KClass<Method> r2, Syntax r3) {
                super(r2, r3, null);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<Method> getEntries() {
            return b;
        }

        static {
            Method r0 = new Method("DEFAULT", 0, 1);
            DEFAULT = r0;
            Method r1 = new Method("EMAIL", 1, 2);
            EMAIL = r1;
            Method r4 = new Method("POPUP", 2, 3);
            POPUP = r4;
            Method r6 = new Method("SMS", 3, 4);
            SMS = r6;
            Method[] r8 = {r0, r1, r4, r6};
            a = r8;
            b = EnumEntriesKt.enumEntries(r8);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(Method.class), Syntax.PROTO_2);
        }

        public static Method[] values() {
            return (Method[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final Method fromValue(int r1) {
            Companion.getClass();
            if (r1 == 1) goto L15;
            if (r1 == 2) goto L19;
            if (r1 == 3) goto L18;
            if (r1 == 4) goto L17;
            return null;
        L17:
            return SMS;
        L18:
            return POPUP;
        L19:
            return EMAIL;
        L15:
            return DEFAULT;
        }

        public static Method valueOf(String r1) {
            return (Method) r27.a.a(Method.class, r1);
        }

        public Method(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a extends Message.a<CalendarEventReminder, a> {
        public String d;
        public Integer e;
        public Method f;

        @Override // com.lark.wire.Message.a
        public final Message b() {
            return new CalendarEventReminder(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<CalendarEventReminder> {
        @Override // com.lark.wire.ProtoAdapter
        public final CalendarEventReminder c(g0 r10) {
            Intrinsics.checkNotNullParameter(r10, "reader");
            a r1 = new a();
            long r2 = r10.c();
        L3:
            int r4 = r10.e();
            if (r4 == (-1)) goto L19;
            if (r4 != 1) goto L8;
            ProtoAdapter.q.getClass();
            Intrinsics.checkNotNullParameter(r10, "reader");
            String r5 = r10.i();
            Intrinsics.checkNotNullParameter(r5, "calendar_event_id");
            r1.d = r5;
            goto L3
        L8:
            if (r4 != 2) goto L10;
            r1.e = Integer.valueOf(((Number) ProtoAdapter.h.c(r10)).intValue());
            goto L3
        L10:
            if (r4 != 3) goto L11;
            Method r6 = Method.ADAPTER.c(r10);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
            Intrinsics.checkNotNullParameter(r6, "method");     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
            r1.f = r6;     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r10.a(r4, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r7 = Unit.INSTANCE;
            goto L3
        L11:
            r10.j(r4);
            goto L3
        L19:
            return new CalendarEventReminder(r1, r10.d(r2), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(CalendarEventReminder r5) {
            CalendarEventReminder r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            return ((r6.unknownFields().size() + ProtoAdapter.q.l(1, r6.getCalendar_event_id())) + ProtoAdapter.h.l(2, Integer.valueOf(r6.getMinutes()))) + Method.ADAPTER.l(3, r6.getMethod());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, CalendarEventReminder r5) {
            CalendarEventReminder r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            ProtoAdapter.q.i(r4, 1, r6.getCalendar_event_id());
            ProtoAdapter.h.i(r4, 2, Integer.valueOf(r6.getMinutes()));
            Method.ADAPTER.i(r4, 3, r6.getMethod());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, CalendarEventReminder r5) {
            CalendarEventReminder r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            Method.ADAPTER.j(r4, 3, r6.getMethod());
            ProtoAdapter.h.j(r4, 2, Integer.valueOf(r6.getMinutes()));
            ProtoAdapter.q.j(r4, 1, r6.getCalendar_event_id());
        }

        public b(FieldEncoding r7, KClass<CalendarEventReminder> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/calendar.v1.CalendarEventReminder", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ CalendarEventReminder(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(CalendarEventReminder.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.calendar_event_id;
        r0.e = Integer.valueOf(this.minutes);
        r0.f = this.method;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(CalendarEventReminder.class).getSimpleName() + '@' + hashCode();
    }

    public final String getCalendar_event_id() {
        return this.calendar_event_id;
    }

    public final Method getMethod() {
        return this.method;
    }

    public final int getMinutes() {
        return this.minutes;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ Message.a newBuilder() {
        return newBuilder();
    }

    public CalendarEventReminder(a r2, ByteString r3) {
        super(ADAPTER, r3);
        String r4 = r2.d;
        Intrinsics.checkNotNull(r4);
        this.calendar_event_id = r4;
        Integer r5 = r2.e;
        Intrinsics.checkNotNull(r5);
        this.minutes = r5.intValue();
        Method r6 = r2.f;
        Intrinsics.checkNotNull(r6);
        this.method = r6;
    }

    public /* synthetic */ CalendarEventReminder(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
