package com.larus.canvas.feature.ability;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/canvas/feature/ability/InstructionRenderStatus;", "", "<init>", "(Ljava/lang/String;I)V", EffectConstants.NORMAL, "LOADING", "ERROR", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum InstructionRenderStatus extends Enum<InstructionRenderStatus> {
    public static final InstructionRenderStatus ERROR = null;
    public static final InstructionRenderStatus LOADING = null;
    public static final InstructionRenderStatus NORMAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ InstructionRenderStatus[] f323028a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f323029b = null;

    public static EnumEntries<InstructionRenderStatus> getEntries() {
        return f323029b;
    }

    static {
        InstructionRenderStatus r100 = new InstructionRenderStatus(EffectConstants.NORMAL, 0);
        NORMAL = r100;
        InstructionRenderStatus r101 = new InstructionRenderStatus("LOADING", 1);
        LOADING = r101;
        InstructionRenderStatus r102 = new InstructionRenderStatus("ERROR", 2);
        ERROR = r102;
        InstructionRenderStatus[] r103 = {r100, r101, r102};
        f323028a = r103;
        f323029b = EnumEntriesKt.enumEntries(r103);
    }

    public static InstructionRenderStatus[] values() {
        return (InstructionRenderStatus[]) f323028a.clone();
    }

    public static InstructionRenderStatus valueOf(String r100) {
        return (InstructionRenderStatus) a.a(InstructionRenderStatus.class, r100);
    }

    public InstructionRenderStatus(String r100, int r101) {
        super(r100, r101);
    }
}
