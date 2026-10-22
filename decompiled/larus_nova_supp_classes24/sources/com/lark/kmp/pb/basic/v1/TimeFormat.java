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
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00182\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0017\u0018\u0019B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0014\u001a\u00020\u0002H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0010\u0010\u0012¨\u0006\u001a"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/TimeFormat;", "Lcom/lark/wire/Message;", "Lcom/lark/kmp/pb/basic/v1/TimeFormat$Builder;", "builder", "unknownFields", "Lokio/ByteString;", "<init>", "(Lcom/lark/kmp/pb/basic/v1/TimeFormat$Builder;Lokio/ByteString;)V", "time_unit", "Lcom/lark/kmp/pb/basic/v1/TimeUnit;", "getTime_unit", "()Lcom/lark/kmp/pb/basic/v1/TimeUnit;", "start_end_layout", "Lcom/lark/kmp/pb/basic/v1/TimeFormat$StartEndLayout;", "getStart_end_layout", "()Lcom/lark/kmp/pb/basic/v1/TimeFormat$StartEndLayout;", "is_show_to_others", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "newBuilder", "toString", "", "Builder", "Companion", "StartEndLayout", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class TimeFormat extends com.lark.wire.Message<TimeFormat, a> {
    public static final ProtoAdapter<TimeFormat> ADAPTER = null;
    public static final c Companion = null;
    private static final long serialVersionUID = 0;
    private final Boolean is_show_to_others;
    private final StartEndLayout start_end_layout;
    private final TimeUnit time_unit;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \r2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/TimeFormat$StartEndLayout;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "HIDE", "NORMAL", "START_ONLY", "END_ONLY", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final enum StartEndLayout extends Enum<StartEndLayout> implements o0 {
        public static final ProtoAdapter<StartEndLayout> ADAPTER = null;
        public static final b Companion = null;
        public static final StartEndLayout END_ONLY = null;
        public static final StartEndLayout HIDE = null;
        public static final StartEndLayout NORMAL = null;
        public static final StartEndLayout START_ONLY = null;
        public static final /* synthetic */ StartEndLayout[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static final class a extends d<StartEndLayout> {
            @Override // com.lark.wire.d
            public final o0 n(int r2) {
                StartEndLayout.Companion.getClass();
                if (r2 == 0) goto L15;
                if (r2 == 1) goto L19;
                if (r2 == 2) goto L18;
                if (r2 == 3) goto L17;
                return null;
            L17:
                return StartEndLayout.END_ONLY;
            L18:
                return StartEndLayout.START_ONLY;
            L19:
                return StartEndLayout.NORMAL;
            L15:
                return StartEndLayout.HIDE;
            }

            public a(KClass<StartEndLayout> r1, Syntax r2, StartEndLayout r3) {
                super(r1, r2, r3);
            }
        }

        public static final class b {
            public b() {
            }
        }

        public static EnumEntries<StartEndLayout> getEntries() {
            return b;
        }

        static {
            StartEndLayout r0 = new StartEndLayout("HIDE", 0, 0);
            HIDE = r0;
            StartEndLayout r1 = new StartEndLayout("NORMAL", 1, 1);
            NORMAL = r1;
            StartEndLayout r3 = new StartEndLayout("START_ONLY", 2, 2);
            START_ONLY = r3;
            StartEndLayout r5 = new StartEndLayout("END_ONLY", 3, 3);
            END_ONLY = r5;
            StartEndLayout[] r7 = {r0, r1, r3, r5};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
            Companion = new b();
            ADAPTER = new a(Reflection.getOrCreateKotlinClass(StartEndLayout.class), Syntax.PROTO_2, r0);
        }

        public static StartEndLayout[] values() {
            return (StartEndLayout[]) a.clone();
        }

        @Override // com.lark.wire.o0
        public int getValue() {
            return this.value;
        }

        @JvmStatic
        public static final StartEndLayout fromValue(int r1) {
            Companion.getClass();
            if (r1 == 0) goto L15;
            if (r1 == 1) goto L19;
            if (r1 == 2) goto L18;
            if (r1 == 3) goto L17;
            return null;
        L17:
            return END_ONLY;
        L18:
            return START_ONLY;
        L19:
            return NORMAL;
        L15:
            return HIDE;
        }

        public static StartEndLayout valueOf(String r1) {
            return (StartEndLayout) r27.a.a(StartEndLayout.class, r1);
        }

        public StartEndLayout(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a extends com.lark.wire.Message.a<TimeFormat, a> {
        public TimeUnit d;
        public StartEndLayout e;
        public Boolean f;

        @Override // com.lark.wire.Message.a
        public final com.lark.wire.Message b() {
            return new TimeFormat(this, c(), null);
        }

        public a() {
        }
    }

    public static final class b extends ProtoAdapter<TimeFormat> {
        @Override // com.lark.wire.ProtoAdapter
        public final TimeFormat c(g0 r9) {
            Intrinsics.checkNotNullParameter(r9, "reader");
            a r0 = new a();
            long r1 = r9.c();
        L3:
            int r3 = r9.e();
            if (r3 == (-1)) goto L22;
            if (r3 != 1) goto L8;
            r0.d = TimeUnit.ADAPTER.c(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
        L19:
            e = move-exception;
            r9.a(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r4 = Unit.INSTANCE;
            goto L3
        L8:
            if (r3 != 2) goto L10;
            r0.e = StartEndLayout.ADAPTER.c(r9);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r9.a(r3, FieldEncoding.VARINT, Long.valueOf(e.value));
            Unit r5 = Unit.INSTANCE;
            goto L3
        L10:
            if (r3 != 3) goto L11;
            r0.f = (Boolean) ProtoAdapter.g.c(r9);
            goto L3
        L11:
            r9.j(r3);
            goto L3
        L22:
            return new TimeFormat(r0, r9.d(r1), null);
        }

        @Override // com.lark.wire.ProtoAdapter
        public final int k(TimeFormat r5) {
            TimeFormat r6 = r5;
            Intrinsics.checkNotNullParameter(r6, "value");
            return ((r6.unknownFields().size() + TimeUnit.ADAPTER.l(1, r6.getTime_unit())) + StartEndLayout.ADAPTER.l(2, r6.getStart_end_layout())) + ProtoAdapter.g.l(3, r6.is_show_to_others());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void f(j0 r4, TimeFormat r5) {
            TimeFormat r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            TimeUnit.ADAPTER.i(r4, 1, r6.getTime_unit());
            StartEndLayout.ADAPTER.i(r4, 2, r6.getStart_end_layout());
            ProtoAdapter.g.i(r4, 3, r6.is_show_to_others());
            r4.a(r6.unknownFields());
        }

        @Override // com.lark.wire.ProtoAdapter
        public final void g(n0 r4, TimeFormat r5) {
            TimeFormat r6 = r5;
            Intrinsics.checkNotNullParameter(r4, "writer");
            Intrinsics.checkNotNullParameter(r6, "value");
            r4.d(r6.unknownFields());
            ProtoAdapter.g.j(r4, 3, r6.is_show_to_others());
            StartEndLayout.ADAPTER.j(r4, 2, r6.getStart_end_layout());
            TimeUnit.ADAPTER.j(r4, 1, r6.getTime_unit());
        }

        public b(FieldEncoding r7, KClass<TimeFormat> r8, Syntax r9) {
            super(r7, r8, "type.googleapis.com/basic.v1.TimeFormat", r9, null);
        }
    }

    public static final class c {
        public c() {
        }
    }

    public /* synthetic */ TimeFormat(a r1, ByteString r2, DefaultConstructorMarker r3) {
        this(r1, r2);
    }

    static {
        Companion = new c();
        ADAPTER = new b(FieldEncoding.LENGTH_DELIMITED, Reflection.getOrCreateKotlinClass(TimeFormat.class), Syntax.PROTO_2);
    }

    @Override // com.lark.wire.Message
    public a newBuilder() {
        a r0 = new a();
        r0.d = this.time_unit;
        r0.e = this.start_end_layout;
        r0.f = this.is_show_to_others;
        r0.a(unknownFields());
        return r0;
    }

    @Override // com.lark.wire.Message
    public String toString() {
        return Reflection.getOrCreateKotlinClass(TimeFormat.class).getSimpleName() + '@' + hashCode();
    }

    public final StartEndLayout getStart_end_layout() {
        return this.start_end_layout;
    }

    public final TimeUnit getTime_unit() {
        return this.time_unit;
    }

    public final Boolean is_show_to_others() {
        return this.is_show_to_others;
    }

    @Override // com.lark.wire.Message
    public /* bridge */ /* synthetic */ com.lark.wire.Message.a newBuilder() {
        return newBuilder();
    }

    public TimeFormat(a r2, ByteString r3) {
        super(ADAPTER, r3);
        this.time_unit = r2.d;
        this.start_end_layout = r2.e;
        this.is_show_to_others = r2.f;
    }

    public /* synthetic */ TimeFormat(a r1, ByteString r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = ByteString.EMPTY;
    L5:
        this(r1, r2);
    }
}
