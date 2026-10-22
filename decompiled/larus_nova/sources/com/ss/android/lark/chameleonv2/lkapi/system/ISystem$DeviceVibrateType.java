package com.ss.android.lark.chameleonv2.lkapi.system;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \u000b2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/system/ISystem$DeviceVibrateType;", "Lcom/bytedance/ee/util/io/NonProguard;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "LONG", "SHORT", "Companion", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ISystem$DeviceVibrateType extends Enum<ISystem$DeviceVibrateType> implements NonProguard {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ISystem$DeviceVibrateType[] $VALUES = null;
    public static final a Companion = null;
    public static final ISystem$DeviceVibrateType LONG = null;
    public static final ISystem$DeviceVibrateType SHORT = null;
    private final String value;

    private static final /* synthetic */ ISystem$DeviceVibrateType[] $values() {
        return new ISystem$DeviceVibrateType[]{LONG, SHORT};
    }

    public static EnumEntries<ISystem$DeviceVibrateType> getEntries() {
        return $ENTRIES;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.ss.android.lark.chameleonv2.lkapi.system.ISystem$DeviceVibrateType$a] */
    static {
        LONG = new ISystem$DeviceVibrateType("LONG", 0, "long");
        SHORT = new ISystem$DeviceVibrateType("SHORT", 1, "short");
        ISystem$DeviceVibrateType[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new a();
    }

    public static ISystem$DeviceVibrateType[] values() {
        return (ISystem$DeviceVibrateType[]) $VALUES.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static ISystem$DeviceVibrateType valueOf(String r100) {
        return (ISystem$DeviceVibrateType) r27.a.a(ISystem$DeviceVibrateType.class, r100);
    }

    private ISystem$DeviceVibrateType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
