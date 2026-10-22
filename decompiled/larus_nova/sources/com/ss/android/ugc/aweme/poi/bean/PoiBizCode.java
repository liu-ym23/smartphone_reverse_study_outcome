package com.ss.android.ugc.aweme.poi.bean;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/ugc/aweme/poi/bean/PoiBizCode;", "", "", "bizCode", "Ljava/lang/String;", "DELIVER", "TRIP", "GENERAL", "FOOD", "DEFAULT", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
public final enum PoiBizCode extends Enum<PoiBizCode> {
    public static final PoiBizCode DEFAULT = null;
    public static final PoiBizCode DELIVER = null;
    public static final PoiBizCode FOOD = null;
    public static final PoiBizCode GENERAL = null;
    public static final PoiBizCode TRIP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PoiBizCode[] f451306a = null;
    public final String bizCode;

    public static PoiBizCode valueOf(String r100) {
        return (PoiBizCode) a.a(PoiBizCode.class, r100);
    }

    public static PoiBizCode[] values() {
        return (PoiBizCode[]) f451306a.clone();
    }

    static {
        PoiBizCode r100 = new PoiBizCode("DELIVER", 0, "deliver");
        DELIVER = r100;
        PoiBizCode r101 = new PoiBizCode("TRIP", 1, "trip");
        TRIP = r101;
        PoiBizCode r102 = new PoiBizCode("GENERAL", 2, "general");
        GENERAL = r102;
        PoiBizCode r103 = new PoiBizCode("FOOD", 3, "food");
        FOOD = r103;
        PoiBizCode r104 = new PoiBizCode("DEFAULT", 4, "default");
        DEFAULT = r104;
        f451306a = new PoiBizCode[]{r100, r101, r102, r103, r104};
    }

    public PoiBizCode(String r100, int r101, String r102) {
        super(r100, r101);
        this.bizCode = r102;
    }
}
