package com.obric.oui.coachmark;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"com/obric/oui/coachmark/OCoachmark$Type", "", "Lcom/obric/oui/coachmark/OCoachmark$Type;", "PILL", "CARD", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final enum OCoachmark$Type extends Enum<OCoachmark$Type> {
    public static final OCoachmark$Type CARD = null;
    public static final OCoachmark$Type PILL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OCoachmark$Type[] f399433a = null;

    public static OCoachmark$Type valueOf(String r100) {
        return (OCoachmark$Type) a.a(OCoachmark$Type.class, r100);
    }

    public static OCoachmark$Type[] values() {
        return (OCoachmark$Type[]) f399433a.clone();
    }

    static {
        OCoachmark$Type r100 = new OCoachmark$Type("PILL", 0);
        PILL = r100;
        OCoachmark$Type r101 = new OCoachmark$Type("CARD", 1);
        CARD = r101;
        f399433a = new OCoachmark$Type[]{r100, r101};
    }

    public OCoachmark$Type(String r100, int r101) {
        super(r100, r101);
    }
}
