package el9;

import com.bytedance.mira.MiraManager;

/* JADX INFO: loaded from: classes.dex */
public final class a {
    public static boolean a() {
        if (MiraManager.getInstance().getParam() != null) goto L5;
    L7:
        return false;
    L5:
        if (MiraManager.getInstance().getParam().isOpenMiraOpt() == false) goto L7;
        return true;
    }
}
