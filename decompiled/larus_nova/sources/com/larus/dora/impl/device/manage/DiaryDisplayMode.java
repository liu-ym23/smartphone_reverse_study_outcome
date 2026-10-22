package com.larus.dora.impl.device.manage;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/dora/impl/device/manage/DiaryDisplayMode;", "", "<init>", "(Ljava/lang/String;I)V", EffectConstants.NORMAL, "ENVIRONMENT_OFF", "NO_CONTENT", "NETWORK_ERROR", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DiaryDisplayMode extends Enum<DiaryDisplayMode> {
    public static final DiaryDisplayMode ENVIRONMENT_OFF = null;
    public static final DiaryDisplayMode NETWORK_ERROR = null;
    public static final DiaryDisplayMode NORMAL = null;
    public static final DiaryDisplayMode NO_CONTENT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DiaryDisplayMode[] f333657a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f333658b = null;

    public static EnumEntries<DiaryDisplayMode> getEntries() {
        return f333658b;
    }

    static {
        DiaryDisplayMode r100 = new DiaryDisplayMode(EffectConstants.NORMAL, 0);
        NORMAL = r100;
        DiaryDisplayMode r101 = new DiaryDisplayMode("ENVIRONMENT_OFF", 1);
        ENVIRONMENT_OFF = r101;
        DiaryDisplayMode r102 = new DiaryDisplayMode("NO_CONTENT", 2);
        NO_CONTENT = r102;
        DiaryDisplayMode r103 = new DiaryDisplayMode("NETWORK_ERROR", 3);
        NETWORK_ERROR = r103;
        DiaryDisplayMode[] r104 = {r100, r101, r102, r103};
        f333657a = r104;
        f333658b = EnumEntriesKt.enumEntries(r104);
    }

    public static DiaryDisplayMode[] values() {
        return (DiaryDisplayMode[]) f333657a.clone();
    }

    public static DiaryDisplayMode valueOf(String r100) {
        return (DiaryDisplayMode) r27.a.a(DiaryDisplayMode.class, r100);
    }

    public DiaryDisplayMode(String r100, int r101) {
        super(r100, r101);
    }
}
