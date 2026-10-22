package com.obric.update.bean;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/update/bean/ObricUpdateStateType;", "", "<init>", "(Ljava/lang/String;I)V", "UPDATE_NOT_AVAILABLE", "UPDATE_AVAILABLE", "DOWNLOADING", "PAUSE", "WAITING_INSTALL_DOUBAO", "DOUBAO_INSTALLING", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ObricUpdateStateType extends Enum<ObricUpdateStateType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ObricUpdateStateType[] $VALUES = null;
    public static final ObricUpdateStateType DOUBAO_INSTALLING = null;
    public static final ObricUpdateStateType DOWNLOADING = null;
    public static final ObricUpdateStateType PAUSE = null;
    public static final ObricUpdateStateType UPDATE_AVAILABLE = null;
    public static final ObricUpdateStateType UPDATE_NOT_AVAILABLE = null;
    public static final ObricUpdateStateType WAITING_INSTALL_DOUBAO = null;

    private static final /* synthetic */ ObricUpdateStateType[] $values() {
        return new ObricUpdateStateType[]{UPDATE_NOT_AVAILABLE, UPDATE_AVAILABLE, DOWNLOADING, PAUSE, WAITING_INSTALL_DOUBAO, DOUBAO_INSTALLING};
    }

    public static EnumEntries<ObricUpdateStateType> getEntries() {
        return $ENTRIES;
    }

    static {
        UPDATE_NOT_AVAILABLE = new ObricUpdateStateType("UPDATE_NOT_AVAILABLE", 0);
        UPDATE_AVAILABLE = new ObricUpdateStateType("UPDATE_AVAILABLE", 1);
        DOWNLOADING = new ObricUpdateStateType("DOWNLOADING", 2);
        PAUSE = new ObricUpdateStateType("PAUSE", 3);
        WAITING_INSTALL_DOUBAO = new ObricUpdateStateType("WAITING_INSTALL_DOUBAO", 4);
        DOUBAO_INSTALLING = new ObricUpdateStateType("DOUBAO_INSTALLING", 5);
        ObricUpdateStateType[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static ObricUpdateStateType[] values() {
        return (ObricUpdateStateType[]) $VALUES.clone();
    }

    public static ObricUpdateStateType valueOf(String r100) {
        return (ObricUpdateStateType) a.a(ObricUpdateStateType.class, r100);
    }

    private ObricUpdateStateType(String r100, int r101) {
        super(r100, r101);
    }
}
