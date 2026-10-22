package com.lark.kmp.pb.basic.v1;

import com.lark.wire.FieldEncoding;
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
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00142\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0013\u0014\u0015B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/CalendarEntityMeta;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/CalendarEntityMeta$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/CalendarEntityMeta$Builder;Lokio/ByteString;)V", "action_type", "Lcom/lark/kmp/pb/basic/v1/CalendarEntityMeta$ActionType;", "getAction_type", "()Lcom/lark/kmp/pb/basic/v1/CalendarEntityMeta$ActionType;", "monitor_entity_type", "Lcom/lark/kmp/pb/basic/v1/CalendarMonitorEntityType;", "getMonitor_entity_type", "()Lcom/lark/kmp/pb/basic/v1/CalendarMonitorEntityType;", "newBuilder", "toString", "", "Builder", "Companion", "ActionType", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class CalendarEntityMeta extends com.lark.wire.Message<CalendarEntityMeta, a> {
    public static final ProtoAdapter<CalendarEntityMeta> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final ActionType action_type;
    private final CalendarMonitorEntityType monitor_entity_type;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \u000b2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/CalendarEntityMeta$ActionType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "CREATE_EVENT", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum ActionType extends Enum<ActionType> implements o0 {
        public static final ProtoAdapter<ActionType> ADAPTER = null;
        public static final ActionType CREATE_EVENT = null;
        public static final b Companion = null;
        public static final ActionType UNKNOWN = null;
        public static final /* synthetic */ ActionType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<ActionType> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                ActionType.Companion.getClass();
                if (r2 == 0) goto L9;
                if (r2 == 1) goto L11;
                return null;
            L11:
                return ActionType.CREATE_EVENT;
            L9:
                return ActionType.UNKNOWN;
            }

            public a(KClass<ActionType> r1, Syntax r2, ActionType r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<ActionType> getEntries() {
            return b;
        }

        static {
            ActionType r0 = new ActionType("UNKNOWN", 0, 0);
            UNKNOWN = r0;
            ActionType r1 = new ActionType("CREATE_EVENT", 1, 1);
            CREATE_EVENT = r1;
            ActionType[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(ActionType.class), Syntax.PROTO_2, r0);
        }

        public static ActionType[] values() {
            return (ActionType[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final ActionType fromValue(int r1) {
            Companion.getClass();
            if (r1 == 0) goto L9;
            if (r1 == 1) goto L11;
            return null;
        L11:
            return CREATE_EVENT;
        L9:
            return UNKNOWN;
        }

        public static ActionType valueOf(String r1) {
            return (ActionType) r27.a.a(ActionType.class, r1);
        }

        public ActionType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a extends com.lark.wire.Message.a<CalendarEntityMeta, a> {
        public ActionType d;
        public CalendarMonitorEntityType e;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new CalendarEntityMeta(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<CalendarEntityMeta> {
        @Override // com.lark.wire.ProtoAdapter
        public final CalendarEntityMeta c(g0 r9) {
            Intrinsics.checkNotNullParameter(r9, "reader");
            a r0 = new a();
            long r1 = r9.c();
        L3:
            int r3 = r9.e();
            if (r3 == (-1)) goto L19;
            if (r3 != 1) goto L8;
            r0.d = ActionType.ADAPTER.c(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r9.a(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r4 = Unit.INSTANCE;
            goto L3
        L8:
            if (r3 != 2) goto L9;
            r0.e = CalendarMonitorEntityType.ADAPTER.c(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L12
        L12:
            e = move-exception;
            r9.a(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r5 = Unit.INSTANCE;
            goto L3
        L9:
            r9.j(r3);
            goto L3
        L19:
            return new CalendarEntityMeta(r0, r9.d(r1), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(CalendarEntityMeta r5) {
            CalendarEntityMeta r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            return (r6.unknownFields().size() + ActionType.ADAPTER.l(1, r6.getAction_type())) + CalendarMonitorEntityType.ADAPTER.l(2, r6.getMonitor_entity_type());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, CalendarEntityMeta r5) {
            CalendarEntityMeta r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            ActionType.ADAPTER.i(r4, 1, r6.getAction_type());
            CalendarMonitorEntityType.ADAPTER.i(r4, 2, r6.getMonitor_entity_type());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, CalendarEntityMeta r5) {
            CalendarEntityMeta r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            CalendarMonitorEntityType.ADAPTER.j(r4, 2, r6.getMonitor_entity_type());
            ActionType.ADAPTER.j(r4, 1, r6.getAction_type());
        }

        public b(FieldEncoding r7, KClass<CalendarEntityMeta> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.CalendarEntityMeta", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ CalendarEntityMeta(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(CalendarEntityMeta.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.action_type;
        r0.e = this.monitor_entity_type;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(CalendarEntityMeta.class).getSimpleName() + '@' + hashCode();
    }

    public final ActionType getAction_type() {
        return this.action_type;
    }

    public final CalendarMonitorEntityType getMonitor_entity_type() {
        return this.monitor_entity_type;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public CalendarEntityMeta(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.action_type = r2.d;
        this.monitor_entity_type = r2.e;
    }

    public /* synthetic */ CalendarEntityMeta(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
