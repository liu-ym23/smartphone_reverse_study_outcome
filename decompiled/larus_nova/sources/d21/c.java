package d21;

import com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.subdatacontext.PkBaseResult;

/* JADX INFO: loaded from: classes47.dex */
public final /* synthetic */ class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f466505a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f466506b = null;

    static {
        int[] r100 = new int[PkBaseResult.values().length];
        PkBaseResult r101 = PkBaseResult.WIN;
        r100[r101.ordinal()] = 1;
        PkBaseResult r102 = PkBaseResult.LOSE;
        r100[r102.ordinal()] = 2;
        PkBaseResult r103 = PkBaseResult.EVEN;
        r100[r103.ordinal()] = 3;
        int[] r104 = new int[PkBaseResult.values().length];
        f466505a = r104;
        r104[r101.ordinal()] = 1;
        r104[r102.ordinal()] = 2;
        r104[r103.ordinal()] = 3;
        int[] r105 = new int[PkBaseStateMachine.Source.values().length];
        f466506b = r105;
        r105[PkBaseStateMachine.Source.PKTimeUp.ordinal()] = 1;
        r105[PkBaseStateMachine.Source.PunishTimeUp.ordinal()] = 2;
        r105[PkBaseStateMachine.Source.RtcLinkerLeave.ordinal()] = 3;
        r105[PkBaseStateMachine.Source.RoomClose.ordinal()] = 4;
    }
}
