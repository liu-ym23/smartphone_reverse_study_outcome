package com.lark.kmp.pb.basic.v1;

import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.o0;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u0000 \u000f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/TimeUnit;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "SECOND", "MINUTE", "HOUR", "DAY", "MONTH", "YEAR", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum TimeUnit extends Enum<TimeUnit> implements o0 {
    public static final ProtoAdapter<TimeUnit> ADAPTER = null;
    public static final b Companion = null;
    public static final TimeUnit DAY = null;
    public static final TimeUnit HOUR = null;
    public static final TimeUnit MINUTE = null;
    public static final TimeUnit MONTH = null;
    public static final TimeUnit SECOND = null;
    public static final TimeUnit YEAR = null;
    public static final /* synthetic */ TimeUnit[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static final class b {
        public b() {
        }

        @JvmStatic
        public static TimeUnit a(int r1) {
            if (r1 == 0) goto L20;
            if (r1 == 1) goto L26;
            if (r1 == 2) goto L25;
            if (r1 == 3) goto L24;
            if (r1 == 4) goto L23;
            if (r1 == 5) goto L22;
            return null;
        L22:
            return TimeUnit.YEAR;
        L23:
            return TimeUnit.MONTH;
        L24:
            return TimeUnit.DAY;
        L25:
            return TimeUnit.HOUR;
        L26:
            return TimeUnit.MINUTE;
        L20:
            return TimeUnit.SECOND;
        }
    }

    @JvmStatic
    public static final TimeUnit fromValue(int r1) {
        Companion.getClass();
        return b.a(r1);
    }

    public static EnumEntries<TimeUnit> getEntries() {
        return b;
    }

    static {
        final TimeUnit r0 = new TimeUnit("SECOND", 0, 0);
        SECOND = r0;
        TimeUnit r1 = new TimeUnit("MINUTE", 1, 1);
        MINUTE = r1;
        TimeUnit r3 = new TimeUnit("HOUR", 2, 2);
        HOUR = r3;
        TimeUnit r5 = new TimeUnit("DAY", 3, 3);
        DAY = r5;
        TimeUnit r7 = new TimeUnit("MONTH", 4, 4);
        MONTH = r7;
        TimeUnit r9 = new TimeUnit("YEAR", 5, 5);
        YEAR = r9;
        TimeUnit[] r11 = {r0, r1, r3, r5, r7, r9};
        a = r11;
        b = EnumEntriesKt.enumEntries(r11);
        Companion = new b();
        final KClass r2 = Reflection.getOrCreateKotlinClass(TimeUnit.class);
        final Syntax r4 = Syntax.PROTO_2;
        ADAPTER = new a(r2, r4, r0);
    }

    public static TimeUnit[] values() {
        return (TimeUnit[]) a.clone();
    }

    @Override // com.lark.wire.o0
    public int getValue() {
        return this.value;
    }

    public static TimeUnit valueOf(String r1) {
        return (TimeUnit) r27.a.a(TimeUnit.class, r1);
    }

    public TimeUnit(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
