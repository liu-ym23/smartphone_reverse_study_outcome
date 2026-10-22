package com.larus.platform.model.camera.ve;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/platform/model/camera/ve/Ratio;", "", "<init>", "(Ljava/lang/String;I)V", "RATIO_3_4", "RATIO_9_16", "RATIO_FULL_SCREEN", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum Ratio extends Enum<Ratio> {
    public static final Ratio RATIO_3_4 = null;
    public static final Ratio RATIO_9_16 = null;
    public static final Ratio RATIO_FULL_SCREEN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Ratio[] f365557a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f365558b = null;

    public static EnumEntries<Ratio> getEntries() {
        return f365558b;
    }

    static {
        Ratio r100 = new Ratio("RATIO_3_4", 0);
        RATIO_3_4 = r100;
        Ratio r101 = new Ratio("RATIO_9_16", 1);
        RATIO_9_16 = r101;
        Ratio r102 = new Ratio("RATIO_FULL_SCREEN", 2);
        RATIO_FULL_SCREEN = r102;
        Ratio[] r103 = {r100, r101, r102};
        f365557a = r103;
        f365558b = EnumEntriesKt.enumEntries(r103);
    }

    public static Ratio[] values() {
        return (Ratio[]) f365557a.clone();
    }

    public static Ratio valueOf(String r100) {
        return (Ratio) a.a(Ratio.class, r100);
    }

    public Ratio(String r100, int r101) {
        super(r100, r101);
    }
}
