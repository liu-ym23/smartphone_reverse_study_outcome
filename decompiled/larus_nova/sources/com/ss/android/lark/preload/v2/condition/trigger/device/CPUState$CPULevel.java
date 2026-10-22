package com.ss.android.lark.preload.v2.condition.trigger.device;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/preload/v2/condition/trigger/device/CPUState$CPULevel;", "", "<init>", "(Ljava/lang/String;I)V", "BUSY", "IDLE", EffectConstants.NORMAL, "preload-manager_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CPUState$CPULevel extends Enum<CPUState$CPULevel> {
    public static final CPUState$CPULevel BUSY = null;
    public static final CPUState$CPULevel IDLE = null;
    public static final CPUState$CPULevel NORMAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CPUState$CPULevel[] f438819a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f438820b = null;

    public static EnumEntries<CPUState$CPULevel> getEntries() {
        return f438820b;
    }

    static {
        CPUState$CPULevel r100 = new CPUState$CPULevel("BUSY", 0);
        BUSY = r100;
        CPUState$CPULevel r101 = new CPUState$CPULevel("IDLE", 1);
        IDLE = r101;
        CPUState$CPULevel r102 = new CPUState$CPULevel(EffectConstants.NORMAL, 2);
        NORMAL = r102;
        CPUState$CPULevel[] r103 = {r100, r101, r102};
        f438819a = r103;
        f438820b = EnumEntriesKt.enumEntries(r103);
    }

    public static CPUState$CPULevel[] values() {
        return (CPUState$CPULevel[]) f438819a.clone();
    }

    public static CPUState$CPULevel valueOf(String r100) {
        return (CPUState$CPULevel) a.a(CPUState$CPULevel.class, r100);
    }

    public CPUState$CPULevel(String r100, int r101) {
        super(r100, r101);
    }
}
