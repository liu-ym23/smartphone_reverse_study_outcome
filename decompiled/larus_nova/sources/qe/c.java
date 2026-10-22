package qe;

import com.bytedance.android.ec.model.hybrid.IECBridgeMethod;

/* JADX INFO: loaded from: classes43.dex */
public final /* synthetic */ class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f532608a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f532609b = null;

    static {
        int[] r100 = new int[IECBridgeMethod.Access.values().length];
        f532608a = r100;
        IECBridgeMethod.Access r101 = IECBridgeMethod.Access.PUBLIC;
        r100[r101.ordinal()] = 1;
        IECBridgeMethod.Access r102 = IECBridgeMethod.Access.PROTECT;
        r100[r102.ordinal()] = 2;
        IECBridgeMethod.Access r103 = IECBridgeMethod.Access.PRIVATE;
        r100[r103.ordinal()] = 3;
        int[] r104 = new int[IECBridgeMethod.Access.values().length];
        f532609b = r104;
        r104[r101.ordinal()] = 1;
        r104[r102.ordinal()] = 2;
        r104[r103.ordinal()] = 3;
    }
}
