package com.obric.update.bean;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/obric/update/bean/ObricInstallMode;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "SILENT_INSTALL", "USER_CONFIRM", "FORCE_INSTALL", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ObricInstallMode extends Enum<ObricInstallMode> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ObricInstallMode[] $VALUES = null;
    public static final ObricInstallMode FORCE_INSTALL = null;
    public static final ObricInstallMode SILENT_INSTALL = null;
    public static final ObricInstallMode USER_CONFIRM = null;
    private final int type;

    private static final /* synthetic */ ObricInstallMode[] $values() {
        return new ObricInstallMode[]{SILENT_INSTALL, USER_CONFIRM, FORCE_INSTALL};
    }

    public static EnumEntries<ObricInstallMode> getEntries() {
        return $ENTRIES;
    }

    static {
        SILENT_INSTALL = new ObricInstallMode("SILENT_INSTALL", 0, 1);
        USER_CONFIRM = new ObricInstallMode("USER_CONFIRM", 1, 2);
        FORCE_INSTALL = new ObricInstallMode("FORCE_INSTALL", 2, 3);
        ObricInstallMode[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static ObricInstallMode[] values() {
        return (ObricInstallMode[]) $VALUES.clone();
    }

    public final int getType() {
        return this.type;
    }

    public static ObricInstallMode valueOf(String r100) {
        return (ObricInstallMode) a.a(ObricInstallMode.class, r100);
    }

    private ObricInstallMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
