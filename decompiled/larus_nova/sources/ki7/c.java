package ki7;

import android.app.Application;
import android.content.Context;
import ci7.l;
import ci7.p;
import com.bytedance.ug.sdk.deeplink.IZlinkDepend;
import com.bytedance.ug.sdk.deeplink.ZlinkDependAbility;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<WeakReference<b>> f503641a = null;

    static {
        f503641a = Collections.synchronizedList(new ArrayList());
    }

    public static boolean c() {
        IZlinkDepend r100 = p.a();
        if (r100 == null) goto L17;
        if (r100.settingsRefactorEnable() == false) goto L17;
        Application r101 = l.a();
        if (a.f503640a.get() == false) goto L9;
        return true;
    L9:
        if (d.b(r101).length() <= 0) goto L11;
        boolean r102 = true;
    L12:
        if (r102 == true) goto L19;
        return false;
    L19:
        return true;
    L11:
        r102 = false;
    L17:
        return a.f503640a.get();
    }

    public static void a(b r100) {
        if (r100 == null) goto L19;
        Iterator<WeakReference<b>> r101 = f503641a.iterator();
    L5:
        if (r101.hasNext() == false) goto L11;
        WeakReference<b> r102 = r101.next();
        if (r102 == null) goto L5;
        if (r102.get() != r100) goto L5;
        return;
    L11:
        f503641a.add(new WeakReference(r100));
        return;
    }

    public static boolean b(Context r100) {
        boolean r101 = d.b(r100).optBoolean("deeplink_forbid_check_clipboard", true);
        ZlinkDependAbility r102 = p.f23879a;
        if (r102 != null) goto L5;
        boolean r103 = false;
    L6:
        mi7.e.c("ZlinkSettingsApi", "forbiddenBySettings= " + r101 + ", forbiddenByHost= " + r103);
        if (r101 == true) goto L12;
        if (r103 == true) goto L13;
        return false;
    L13:
        return true;
    L12:
        return true;
    L5:
        r103 = r102.isForbiddenCheckClipBoard();
        goto L6
    }

    public static void d(b r100) {
        if (r100 == null) goto L11;
        Iterator<WeakReference<b>> r101 = f503641a.iterator();
    L5:
        if (r101.hasNext() == false) goto L19;
        WeakReference<b> r102 = r101.next();
        if (r102 == null) goto L5;
        if (r102.get() != r100) goto L5;
        r101.remove();
        goto L5
    L19:
        return;
    }
}
