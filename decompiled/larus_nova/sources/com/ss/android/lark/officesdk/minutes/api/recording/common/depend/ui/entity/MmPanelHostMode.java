package com.ss.android.lark.officesdk.minutes.api.recording.common.depend.ui.entity;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/api/recording/common/depend/ui/entity/MmPanelHostMode;", "", "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "DIALOG", "officesdk-minutes-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MmPanelHostMode extends Enum<MmPanelHostMode> {
    public static final MmPanelHostMode DEFAULT = null;
    public static final MmPanelHostMode DIALOG = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MmPanelHostMode[] f433557a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f433558b = null;

    public static EnumEntries<MmPanelHostMode> getEntries() {
        return f433558b;
    }

    static {
        MmPanelHostMode r100 = new MmPanelHostMode("DEFAULT", 0);
        DEFAULT = r100;
        MmPanelHostMode r101 = new MmPanelHostMode("DIALOG", 1);
        DIALOG = r101;
        MmPanelHostMode[] r102 = {r100, r101};
        f433557a = r102;
        f433558b = EnumEntriesKt.enumEntries(r102);
    }

    public static MmPanelHostMode[] values() {
        return (MmPanelHostMode[]) f433557a.clone();
    }

    public static MmPanelHostMode valueOf(String r100) {
        return (MmPanelHostMode) a.a(MmPanelHostMode.class, r100);
    }

    public MmPanelHostMode(String r100, int r101) {
        super(r100, r101);
    }
}
