package com.larus.avlink.business.api;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/avlink/business/api/DoraAvlinkSessionMode;", "", "<init>", "(Ljava/lang/String;I)V", EffectConstants.NORMAL, "SIMUL_INTERPRET", "LIVE_AI", "ENVIRONMENT_OBSERVE", "dora_business_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraAvlinkSessionMode extends Enum<DoraAvlinkSessionMode> {
    public static final DoraAvlinkSessionMode ENVIRONMENT_OBSERVE = null;
    public static final DoraAvlinkSessionMode LIVE_AI = null;
    public static final DoraAvlinkSessionMode NORMAL = null;
    public static final DoraAvlinkSessionMode SIMUL_INTERPRET = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoraAvlinkSessionMode[] f291702a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f291703b = null;

    public static EnumEntries<DoraAvlinkSessionMode> getEntries() {
        return f291703b;
    }

    static {
        DoraAvlinkSessionMode r100 = new DoraAvlinkSessionMode(EffectConstants.NORMAL, 0);
        NORMAL = r100;
        DoraAvlinkSessionMode r101 = new DoraAvlinkSessionMode("SIMUL_INTERPRET", 1);
        SIMUL_INTERPRET = r101;
        DoraAvlinkSessionMode r102 = new DoraAvlinkSessionMode("LIVE_AI", 2);
        LIVE_AI = r102;
        DoraAvlinkSessionMode r103 = new DoraAvlinkSessionMode("ENVIRONMENT_OBSERVE", 3);
        ENVIRONMENT_OBSERVE = r103;
        DoraAvlinkSessionMode[] r104 = {r100, r101, r102, r103};
        f291702a = r104;
        f291703b = EnumEntriesKt.enumEntries(r104);
    }

    public static DoraAvlinkSessionMode[] values() {
        return (DoraAvlinkSessionMode[]) f291702a.clone();
    }

    public static DoraAvlinkSessionMode valueOf(String r100) {
        return (DoraAvlinkSessionMode) a.a(DoraAvlinkSessionMode.class, r100);
    }

    public DoraAvlinkSessionMode(String r100, int r101) {
        super(r100, r101);
    }
}
