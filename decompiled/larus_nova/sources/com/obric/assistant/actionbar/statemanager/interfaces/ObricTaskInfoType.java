package com.obric.assistant.actionbar.statemanager.interfaces;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/obric/assistant/actionbar/statemanager/interfaces/ObricTaskInfoType;", "", "infoType", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getInfoType", "()Ljava/lang/String;", "TYPE_OAUTO", "TYPE_COMPLEX_TASK", "TYPE_ONNI_QUERY", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ObricTaskInfoType extends Enum<ObricTaskInfoType> {

    @Deprecated(message = "use omni")
    public static final ObricTaskInfoType TYPE_COMPLEX_TASK = null;

    @Deprecated(message = "use omni")
    public static final ObricTaskInfoType TYPE_OAUTO = null;
    public static final ObricTaskInfoType TYPE_ONNI_QUERY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ObricTaskInfoType[] f385254a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f385255b = null;
    private final String infoType;

    public static EnumEntries<ObricTaskInfoType> getEntries() {
        return f385255b;
    }

    static {
        ObricTaskInfoType r100 = new ObricTaskInfoType("TYPE_OAUTO", 0, "oauto_info");
        TYPE_OAUTO = r100;
        ObricTaskInfoType r101 = new ObricTaskInfoType("TYPE_COMPLEX_TASK", 1, "example_query");
        TYPE_COMPLEX_TASK = r101;
        ObricTaskInfoType r102 = new ObricTaskInfoType("TYPE_ONNI_QUERY", 2, "example_omni_query");
        TYPE_ONNI_QUERY = r102;
        ObricTaskInfoType[] r103 = {r100, r101, r102};
        f385254a = r103;
        f385255b = EnumEntriesKt.enumEntries(r103);
    }

    public static ObricTaskInfoType[] values() {
        return (ObricTaskInfoType[]) f385254a.clone();
    }

    public final String getInfoType() {
        return this.infoType;
    }

    public static ObricTaskInfoType valueOf(String r100) {
        return (ObricTaskInfoType) a.a(ObricTaskInfoType.class, r100);
    }

    public ObricTaskInfoType(String r100, int r101, String r102) {
        super(r100, r101);
        this.infoType = r102;
    }
}
