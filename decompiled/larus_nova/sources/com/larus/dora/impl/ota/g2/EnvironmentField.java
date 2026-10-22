package com.larus.dora.impl.ota.g2;

import com.android.ttcjpaysdk.bdpay.counter.outer.bean.ConfirmNextAction;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/larus/dora/impl/ota/g2/EnvironmentField;", "", "<init>", "(Ljava/lang/String;I)V", "CONNECTED", ConfirmNextAction.ACTION_TYPE_QUERY, "COMPANION", "NETWORK", "PHONE_BATTERY", "WEARING", "CHARGING", "GLASSES_BATTERY", "P2P_ENVIRONMENT", "STORAGE", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum EnvironmentField extends Enum<EnvironmentField> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ EnvironmentField[] $VALUES = null;
    public static final EnvironmentField CHARGING = null;
    public static final EnvironmentField COMPANION = null;
    public static final EnvironmentField CONNECTED = null;
    public static final EnvironmentField GLASSES_BATTERY = null;
    public static final EnvironmentField NETWORK = null;
    public static final EnvironmentField P2P_ENVIRONMENT = null;
    public static final EnvironmentField PHONE_BATTERY = null;
    public static final EnvironmentField QUERY = null;
    public static final EnvironmentField STORAGE = null;
    public static final EnvironmentField WEARING = null;

    public static EnumEntries<EnvironmentField> getEntries() {
        return $ENTRIES;
    }

    static {
        EnvironmentField r100 = new EnvironmentField("CONNECTED", 0);
        CONNECTED = r100;
        EnvironmentField r101 = new EnvironmentField(ConfirmNextAction.ACTION_TYPE_QUERY, 1);
        QUERY = r101;
        EnvironmentField r102 = new EnvironmentField("COMPANION", 2);
        COMPANION = r102;
        EnvironmentField r103 = new EnvironmentField("NETWORK", 3);
        NETWORK = r103;
        EnvironmentField r104 = new EnvironmentField("PHONE_BATTERY", 4);
        PHONE_BATTERY = r104;
        EnvironmentField r105 = new EnvironmentField("WEARING", 5);
        WEARING = r105;
        EnvironmentField r110 = new EnvironmentField("CHARGING", 6);
        CHARGING = r110;
        EnvironmentField r111 = new EnvironmentField("GLASSES_BATTERY", 7);
        GLASSES_BATTERY = r111;
        EnvironmentField r112 = new EnvironmentField("P2P_ENVIRONMENT", 8);
        P2P_ENVIRONMENT = r112;
        EnvironmentField r113 = new EnvironmentField("STORAGE", 9);
        STORAGE = r113;
        EnvironmentField[] r114 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
        $VALUES = r114;
        $ENTRIES = EnumEntriesKt.enumEntries(r114);
    }

    public static EnvironmentField[] values() {
        return (EnvironmentField[]) $VALUES.clone();
    }

    public static EnvironmentField valueOf(String r100) {
        return (EnvironmentField) r27.a.a(EnvironmentField.class, r100);
    }

    public EnvironmentField(String r100, int r101) {
        super(r100, r101);
    }
}
