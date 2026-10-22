package kotlinx.coroutines.flow;

import com.alibaba.gaiax.model.GXAnimation;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lkotlinx/coroutines/flow/SharingCommand;", "", "(Ljava/lang/String;I)V", GXAnimation.STATE_START, "STOP", "STOP_AND_RESET_REPLAY_CACHE", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final enum SharingCommand extends Enum<SharingCommand> {
    public static final SharingCommand START = null;
    public static final SharingCommand STOP = null;
    public static final SharingCommand STOP_AND_RESET_REPLAY_CACHE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SharingCommand[] f504822a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f504823b = null;

    public static EnumEntries<SharingCommand> getEntries() {
        return f504823b;
    }

    public static SharingCommand valueOf(String r100) {
        return (SharingCommand) r27.a.a(SharingCommand.class, r100);
    }

    public static SharingCommand[] values() {
        return (SharingCommand[]) f504822a.clone();
    }

    static {
        SharingCommand r100 = new SharingCommand(GXAnimation.STATE_START, 0);
        START = r100;
        SharingCommand r101 = new SharingCommand("STOP", 1);
        STOP = r101;
        SharingCommand r102 = new SharingCommand("STOP_AND_RESET_REPLAY_CACHE", 2);
        STOP_AND_RESET_REPLAY_CACHE = r102;
        SharingCommand[] r103 = {r100, r101, r102};
        f504822a = r103;
        f504823b = EnumEntriesKt.enumEntries(r103);
    }

    public SharingCommand(String r100, int r101) {
        super(r100, r101);
    }
}
