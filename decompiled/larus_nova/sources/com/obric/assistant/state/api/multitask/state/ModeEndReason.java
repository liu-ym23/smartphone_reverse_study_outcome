package com.obric.assistant.state.api.multitask.state;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/assistant/state/api/multitask/state/ModeEndReason;", "", "<init>", "(Ljava/lang/String;I)V", EffectConstants.NORMAL, "TIMEOUT", "INTERRUPTED", "REPLACED", "PAGE_DESTROYED", "ERROR", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ModeEndReason extends Enum<ModeEndReason> {
    public static final ModeEndReason ERROR = null;
    public static final ModeEndReason INTERRUPTED = null;
    public static final ModeEndReason NORMAL = null;
    public static final ModeEndReason PAGE_DESTROYED = null;
    public static final ModeEndReason REPLACED = null;
    public static final ModeEndReason TIMEOUT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ModeEndReason[] f392951a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f392952b = null;

    public static EnumEntries<ModeEndReason> getEntries() {
        return f392952b;
    }

    static {
        ModeEndReason r100 = new ModeEndReason(EffectConstants.NORMAL, 0);
        NORMAL = r100;
        ModeEndReason r101 = new ModeEndReason("TIMEOUT", 1);
        TIMEOUT = r101;
        ModeEndReason r102 = new ModeEndReason("INTERRUPTED", 2);
        INTERRUPTED = r102;
        ModeEndReason r103 = new ModeEndReason("REPLACED", 3);
        REPLACED = r103;
        ModeEndReason r104 = new ModeEndReason("PAGE_DESTROYED", 4);
        PAGE_DESTROYED = r104;
        ModeEndReason r105 = new ModeEndReason("ERROR", 5);
        ERROR = r105;
        ModeEndReason[] r110 = {r100, r101, r102, r103, r104, r105};
        f392951a = r110;
        f392952b = EnumEntriesKt.enumEntries(r110);
    }

    public static ModeEndReason[] values() {
        return (ModeEndReason[]) f392951a.clone();
    }

    public static ModeEndReason valueOf(String r100) {
        return (ModeEndReason) a.a(ModeEndReason.class, r100);
    }

    public ModeEndReason(String r100, int r101) {
        super(r100, r101);
    }
}
