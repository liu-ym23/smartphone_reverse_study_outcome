package com.larus.bmhome.chat.component.skill;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/bmhome/chat/component/skill/PcEntryDisplayMode;", "", "<init>", "(Ljava/lang/String;I)V", "DEVICE_ONLY", "DEVICE_AND_FOLDER", "SUB_CONVERSATION", "MERGED", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PcEntryDisplayMode extends Enum<PcEntryDisplayMode> {
    public static final PcEntryDisplayMode DEVICE_AND_FOLDER = null;
    public static final PcEntryDisplayMode DEVICE_ONLY = null;
    public static final PcEntryDisplayMode MERGED = null;
    public static final PcEntryDisplayMode SUB_CONVERSATION = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PcEntryDisplayMode[] f301661a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f301662b = null;

    public static EnumEntries<PcEntryDisplayMode> getEntries() {
        return f301662b;
    }

    static {
        PcEntryDisplayMode r100 = new PcEntryDisplayMode("DEVICE_ONLY", 0);
        DEVICE_ONLY = r100;
        PcEntryDisplayMode r101 = new PcEntryDisplayMode("DEVICE_AND_FOLDER", 1);
        DEVICE_AND_FOLDER = r101;
        PcEntryDisplayMode r102 = new PcEntryDisplayMode("SUB_CONVERSATION", 2);
        SUB_CONVERSATION = r102;
        PcEntryDisplayMode r103 = new PcEntryDisplayMode("MERGED", 3);
        MERGED = r103;
        PcEntryDisplayMode[] r104 = {r100, r101, r102, r103};
        f301661a = r104;
        f301662b = EnumEntriesKt.enumEntries(r104);
    }

    public static PcEntryDisplayMode[] values() {
        return (PcEntryDisplayMode[]) f301661a.clone();
    }

    public static PcEntryDisplayMode valueOf(String r100) {
        return (PcEntryDisplayMode) a.a(PcEntryDisplayMode.class, r100);
    }

    public PcEntryDisplayMode(String r100, int r101) {
        super(r100, r101);
    }
}
