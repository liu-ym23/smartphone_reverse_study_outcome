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
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0017\b\u0086\u0081\u0002\u0018\u0000 \u001a2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u001aB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019¨\u0006\u001b"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/DeniedReason;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN_REASON", "BE_BLOCKED", "CROSS_TENANT_DENY", "SAME_TENANT_DENY", "CRYPTO_CHAT_DENY", "BLOCKED", "NO_FRIENDSHIP", "PRIVACY_SETTING", "TARGET_PRIVACY_SETTING", "PRIVATE_CALENDAR", "EXTERNAL_COORDINATE_CTL", "TARGET_EXTERNAL_COORDINATE_CTL", "SEND_SECRET_CHAT_BY_ICON_DENY", "PRIVATE_CHAT_DISABLED", "PRIVATE_CHAT_KMS_UNAVAILABLE", "PRIVATE_CHAT_DENY", "PRIVATE_CHAT_CROSS_TENANT", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum DeniedReason extends Enum<DeniedReason> implements o0 {
    public static final ProtoAdapter<DeniedReason> ADAPTER = null;
    public static final DeniedReason BE_BLOCKED = null;
    public static final DeniedReason BLOCKED = null;
    public static final DeniedReason CROSS_TENANT_DENY = null;
    public static final DeniedReason CRYPTO_CHAT_DENY = null;
    public static final b Companion = null;
    public static final DeniedReason EXTERNAL_COORDINATE_CTL = null;
    public static final DeniedReason NO_FRIENDSHIP = null;
    public static final DeniedReason PRIVACY_SETTING = null;
    public static final DeniedReason PRIVATE_CALENDAR = null;
    public static final DeniedReason PRIVATE_CHAT_CROSS_TENANT = null;
    public static final DeniedReason PRIVATE_CHAT_DENY = null;
    public static final DeniedReason PRIVATE_CHAT_DISABLED = null;
    public static final DeniedReason PRIVATE_CHAT_KMS_UNAVAILABLE = null;
    public static final DeniedReason SAME_TENANT_DENY = null;
    public static final DeniedReason SEND_SECRET_CHAT_BY_ICON_DENY = null;
    public static final DeniedReason TARGET_EXTERNAL_COORDINATE_CTL = null;
    public static final DeniedReason TARGET_PRIVACY_SETTING = null;
    public static final DeniedReason UNKNOWN_REASON = null;
    public static final /* synthetic */ DeniedReason[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static final class b {
        public b() {
        }

        @JvmStatic
        public static DeniedReason a(int r0) {
            switch(r0) {
                case 0: goto L21;
                case 1: goto L38;
                case 2: goto L37;
                case 3: goto L36;
                case 4: goto L35;
                case 5: goto L34;
                case 6: goto L33;
                case 7: goto L32;
                case 8: goto L31;
                case 9: goto L30;
                case 10: goto L29;
                case 11: goto L28;
                case 12: goto L27;
                case 13: goto L3;
                case 14: goto L3;
                case 15: goto L26;
                case 16: goto L25;
                case 17: goto L24;
                case 18: goto L23;
                default: goto L3;
            };
        L3:
            return null;
        L23:
            return DeniedReason.PRIVATE_CHAT_CROSS_TENANT;
        L24:
            return DeniedReason.PRIVATE_CHAT_DENY;
        L25:
            return DeniedReason.PRIVATE_CHAT_KMS_UNAVAILABLE;
        L26:
            return DeniedReason.PRIVATE_CHAT_DISABLED;
        L27:
            return DeniedReason.SEND_SECRET_CHAT_BY_ICON_DENY;
        L28:
            return DeniedReason.TARGET_EXTERNAL_COORDINATE_CTL;
        L29:
            return DeniedReason.EXTERNAL_COORDINATE_CTL;
        L30:
            return DeniedReason.PRIVATE_CALENDAR;
        L31:
            return DeniedReason.TARGET_PRIVACY_SETTING;
        L32:
            return DeniedReason.PRIVACY_SETTING;
        L33:
            return DeniedReason.NO_FRIENDSHIP;
        L34:
            return DeniedReason.BLOCKED;
        L35:
            return DeniedReason.CRYPTO_CHAT_DENY;
        L36:
            return DeniedReason.SAME_TENANT_DENY;
        L37:
            return DeniedReason.CROSS_TENANT_DENY;
        L38:
            return DeniedReason.BE_BLOCKED;
        L21:
            return DeniedReason.UNKNOWN_REASON;
        }
    }

    @JvmStatic
    public static final DeniedReason fromValue(int r1) {
        Companion.getClass();
        return b.a(r1);
    }

    public static EnumEntries<DeniedReason> getEntries() {
        return b;
    }

    static {
        final DeniedReason r0 = new DeniedReason("UNKNOWN_REASON", 0, 0);
        UNKNOWN_REASON = r0;
        DeniedReason r1 = new DeniedReason("BE_BLOCKED", 1, 1);
        BE_BLOCKED = r1;
        DeniedReason r3 = new DeniedReason("CROSS_TENANT_DENY", 2, 2);
        CROSS_TENANT_DENY = r3;
        DeniedReason r5 = new DeniedReason("SAME_TENANT_DENY", 3, 3);
        SAME_TENANT_DENY = r5;
        DeniedReason r7 = new DeniedReason("CRYPTO_CHAT_DENY", 4, 4);
        CRYPTO_CHAT_DENY = r7;
        DeniedReason r9 = new DeniedReason("BLOCKED", 5, 5);
        BLOCKED = r9;
        DeniedReason r11 = new DeniedReason("NO_FRIENDSHIP", 6, 6);
        NO_FRIENDSHIP = r11;
        DeniedReason r13 = new DeniedReason("PRIVACY_SETTING", 7, 7);
        PRIVACY_SETTING = r13;
        DeniedReason r15 = new DeniedReason("TARGET_PRIVACY_SETTING", 8, 8);
        TARGET_PRIVACY_SETTING = r15;
        DeniedReason r14 = new DeniedReason("PRIVATE_CALENDAR", 9, 9);
        PRIVATE_CALENDAR = r14;
        DeniedReason r12 = new DeniedReason("EXTERNAL_COORDINATE_CTL", 10, 10);
        EXTERNAL_COORDINATE_CTL = r12;
        DeniedReason r10 = new DeniedReason("TARGET_EXTERNAL_COORDINATE_CTL", 11, 11);
        TARGET_EXTERNAL_COORDINATE_CTL = r10;
        DeniedReason r8 = new DeniedReason("SEND_SECRET_CHAT_BY_ICON_DENY", 12, 12);
        SEND_SECRET_CHAT_BY_ICON_DENY = r8;
        DeniedReason r6 = new DeniedReason("PRIVATE_CHAT_DISABLED", 13, 15);
        PRIVATE_CHAT_DISABLED = r6;
        DeniedReason r4 = new DeniedReason("PRIVATE_CHAT_KMS_UNAVAILABLE", 14, 16);
        PRIVATE_CHAT_KMS_UNAVAILABLE = r4;
        DeniedReason r2 = new DeniedReason("PRIVATE_CHAT_DENY", 15, 17);
        PRIVATE_CHAT_DENY = r2;
        DeniedReason r16 = new DeniedReason("PRIVATE_CHAT_CROSS_TENANT", 16, 18);
        PRIVATE_CHAT_CROSS_TENANT = r16;
        DeniedReason[] r17 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16};
        a = r17;
        b = EnumEntriesKt.enumEntries(r17);
        Companion = new b();
        final KClass r19 = Reflection.getOrCreateKotlinClass(DeniedReason.class);
        final Syntax r20 = Syntax.PROTO_2;
        ADAPTER = new a(r19, r20, r0);
    }

    public static DeniedReason[] values() {
        return (DeniedReason[]) a.clone();
    }

    @Override // com.lark.wire.o0
    public int getValue() {
        return this.value;
    }

    public static DeniedReason valueOf(String r1) {
        return (DeniedReason) r27.a.a(DeniedReason.class, r1);
    }

    public DeniedReason(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
