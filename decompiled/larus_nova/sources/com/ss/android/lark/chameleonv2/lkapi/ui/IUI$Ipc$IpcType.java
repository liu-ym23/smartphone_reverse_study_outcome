package com.ss.android.lark.chameleonv2.lkapi.ui;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/ui/IUI$Ipc$IpcType;", "Lcom/bytedance/ee/util/io/NonProguard;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "APP_THEME_CHANGE", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum IUI$Ipc$IpcType extends Enum<IUI$Ipc$IpcType> implements NonProguard {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ IUI$Ipc$IpcType[] $VALUES = null;
    public static final IUI$Ipc$IpcType APP_THEME_CHANGE = null;
    private final String value;

    private static final /* synthetic */ IUI$Ipc$IpcType[] $values() {
        return new IUI$Ipc$IpcType[]{APP_THEME_CHANGE};
    }

    public static EnumEntries<IUI$Ipc$IpcType> getEntries() {
        return $ENTRIES;
    }

    static {
        APP_THEME_CHANGE = new IUI$Ipc$IpcType("APP_THEME_CHANGE", 0, "APP_THEME_CHANGE");
        IUI$Ipc$IpcType[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static IUI$Ipc$IpcType[] values() {
        return (IUI$Ipc$IpcType[]) $VALUES.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static IUI$Ipc$IpcType valueOf(String r100) {
        return (IUI$Ipc$IpcType) a.a(IUI$Ipc$IpcType.class, r100);
    }

    private IUI$Ipc$IpcType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
