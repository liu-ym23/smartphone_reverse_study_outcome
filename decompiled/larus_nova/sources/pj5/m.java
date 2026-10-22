package pj5;

import com.larus.nova.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes18.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, ArrayList<qj5.b>> f529495a = null;

    @JvmStatic
    public static final int a(int r100) {
        if (r100 != 0) goto L5;
        return R.string.LarkCCM_CM_Verify_NotSet_Radio;
    L5:
        if (r100 != 1) goto L7;
        return R.string.LarkCCM_CM_Verify_MayBeOutdate_Radio;
    L7:
        if (r100 != 2) goto L9;
        return R.string.LarkCCM_CM_Verify_Outdated_Radio;
    L9:
        if (r100 != 3) goto L18;
        return R.string.LarkCCM_CM_Verify_UpToDate_Radio;
    L18:
        return R.string.LarkCCM_CM_Verify_NotSet_Radio;
    }

    static {
        f529495a = new ConcurrentHashMap();
    }

    @JvmStatic
    public static final void b(String r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        ArrayList<qj5.b> r101 = f529495a.get(r100);
        if (r101 == null) goto L10;
        Iterator<T> r102 = r101.iterator();
    L8:
        if (r102.hasNext() == false) goto L12;
        ((qj5.b) r102.next()).onDocFreshNessChange();
        goto L8
    L12:
        return;
    }
}
