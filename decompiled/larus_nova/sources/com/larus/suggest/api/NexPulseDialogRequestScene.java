package com.larus.suggest.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/suggest/api/NexPulseDialogRequestScene;", "", "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "PC_GUIDE_SCHEMA", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum NexPulseDialogRequestScene extends Enum<NexPulseDialogRequestScene> {
    public static final NexPulseDialogRequestScene DEFAULT = null;
    public static final NexPulseDialogRequestScene PC_GUIDE_SCHEMA = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NexPulseDialogRequestScene[] f369789a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f369790b = null;

    public static EnumEntries<NexPulseDialogRequestScene> getEntries() {
        return f369790b;
    }

    static {
        NexPulseDialogRequestScene r100 = new NexPulseDialogRequestScene("DEFAULT", 0);
        DEFAULT = r100;
        NexPulseDialogRequestScene r101 = new NexPulseDialogRequestScene("PC_GUIDE_SCHEMA", 1);
        PC_GUIDE_SCHEMA = r101;
        NexPulseDialogRequestScene[] r102 = {r100, r101};
        f369789a = r102;
        f369790b = EnumEntriesKt.enumEntries(r102);
    }

    public static NexPulseDialogRequestScene[] values() {
        return (NexPulseDialogRequestScene[]) f369789a.clone();
    }

    public static NexPulseDialogRequestScene valueOf(String r100) {
        return (NexPulseDialogRequestScene) a.a(NexPulseDialogRequestScene.class, r100);
    }

    public NexPulseDialogRequestScene(String r100, int r101) {
        super(r100, r101);
    }
}
