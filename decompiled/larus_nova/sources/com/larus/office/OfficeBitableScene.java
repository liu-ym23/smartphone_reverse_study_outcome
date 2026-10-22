package com.larus.office;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/office/OfficeBitableScene;", "", "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "BASE_MAIN", "BASE_APP", "BASE_RECORD", "BASE_ADD", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OfficeBitableScene extends Enum<OfficeBitableScene> {
    public static final OfficeBitableScene BASE_ADD = null;
    public static final OfficeBitableScene BASE_APP = null;
    public static final OfficeBitableScene BASE_MAIN = null;
    public static final OfficeBitableScene BASE_RECORD = null;
    public static final OfficeBitableScene DEFAULT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OfficeBitableScene[] f360425a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f360426b = null;

    public static EnumEntries<OfficeBitableScene> getEntries() {
        return f360426b;
    }

    static {
        OfficeBitableScene r100 = new OfficeBitableScene("DEFAULT", 0);
        DEFAULT = r100;
        OfficeBitableScene r101 = new OfficeBitableScene("BASE_MAIN", 1);
        BASE_MAIN = r101;
        OfficeBitableScene r102 = new OfficeBitableScene("BASE_APP", 2);
        BASE_APP = r102;
        OfficeBitableScene r103 = new OfficeBitableScene("BASE_RECORD", 3);
        BASE_RECORD = r103;
        OfficeBitableScene r104 = new OfficeBitableScene("BASE_ADD", 4);
        BASE_ADD = r104;
        OfficeBitableScene[] r105 = {r100, r101, r102, r103, r104};
        f360425a = r105;
        f360426b = EnumEntriesKt.enumEntries(r105);
    }

    public static OfficeBitableScene[] values() {
        return (OfficeBitableScene[]) f360425a.clone();
    }

    public static OfficeBitableScene valueOf(String r100) {
        return (OfficeBitableScene) r27.a.a(OfficeBitableScene.class, r100);
    }

    public OfficeBitableScene(String r100, int r101) {
        super(r100, r101);
    }
}
