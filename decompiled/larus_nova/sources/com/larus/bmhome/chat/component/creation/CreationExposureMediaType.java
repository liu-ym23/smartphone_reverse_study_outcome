package com.larus.bmhome.chat.component.creation;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/chat/component/creation/CreationExposureMediaType;", "", "<init>", "(Ljava/lang/String;I)V", "IMAGE", "VIDEO", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CreationExposureMediaType extends Enum<CreationExposureMediaType> {
    public static final CreationExposureMediaType IMAGE = null;
    public static final CreationExposureMediaType VIDEO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CreationExposureMediaType[] f300606a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f300607b = null;

    public static EnumEntries<CreationExposureMediaType> getEntries() {
        return f300607b;
    }

    static {
        CreationExposureMediaType r100 = new CreationExposureMediaType("IMAGE", 0);
        IMAGE = r100;
        CreationExposureMediaType r101 = new CreationExposureMediaType("VIDEO", 1);
        VIDEO = r101;
        CreationExposureMediaType[] r102 = {r100, r101};
        f300606a = r102;
        f300607b = EnumEntriesKt.enumEntries(r102);
    }

    public static CreationExposureMediaType[] values() {
        return (CreationExposureMediaType[]) f300606a.clone();
    }

    public static CreationExposureMediaType valueOf(String r100) {
        return (CreationExposureMediaType) a.a(CreationExposureMediaType.class, r100);
    }

    public CreationExposureMediaType(String r100, int r101) {
        super(r100, r101);
    }
}
