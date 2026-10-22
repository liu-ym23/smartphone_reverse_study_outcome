package nd0;

import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import com.bytedance.android.live.liveinteract.plantform.permission.model.OperateType;

/* JADX INFO: loaded from: classes46.dex */
public final /* synthetic */ class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f518748a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f518749b = null;

    static {
        int[] r100 = new int[OperateType.values().length];
        f518748a = r100;
        r100[OperateType.APPLY.ordinal()] = 1;
        r100[OperateType.REPLY.ordinal()] = 2;
        r100[OperateType.PRE_APPLY.ordinal()] = 3;
        r100[OperateType.RESUME.ordinal()] = 4;
        r100[OperateType.JOIN.ordinal()] = 5;
        r100[OperateType.PRE_REPLY.ordinal()] = 6;
        r100[OperateType.MIDI.ordinal()] = 7;
        r100[OperateType.UniversalAnimForSaas.ordinal()] = 8;
        int[] r101 = new int[BaseCheckException.CheckType.values().length];
        f518749b = r101;
        r101[BaseCheckException.CheckType.Login.ordinal()] = 1;
        r101[BaseCheckException.CheckType.AndroidPermission.ordinal()] = 2;
        r101[BaseCheckException.CheckType.VideoShortPlugin.ordinal()] = 3;
        r101[BaseCheckException.CheckType.InteractPlugin.ordinal()] = 4;
        r101[BaseCheckException.CheckType.ServerPermission.ordinal()] = 5;
    }
}
