package y69;

import android.os.Bundle;
import by7.h;
import com.ixigua.lib.track.TrackParams;
import com.larus.dora.impl.device.DoraBaseFragment;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class b {
    public static final String a(DoraBaseFragment r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        boolean r102 = true;
        if (r101 == null) goto L15;
        String r103 = r101.getString("previous_page");
        if (r103 == null) goto L15;
        if (r103.length() <= 0) goto L9;
        boolean r104 = true;
    L10:
        if (r104 == true) goto L13;
        r103 = null;
    L13:
        if (r103 == null) goto L15;
        return r103;
    L9:
        r104 = false;
    L15:
        TrackParams r105 = h.e(r100);
        if (r105 == null) goto L31;
        HashMap<String, Object> r106 = r105.getParams();
        if (r106 == null) goto L32;
        Object r107 = r106.get("current_page");
        if (r107 == null) goto L33;
        String r108 = r107.toString();
        if (r108 != null) goto L24;
        return null;
    L24:
        if (r108.length() > 0) goto L27;
        r102 = false;
    L27:
        if (r102 == true) goto L29;
        return null;
    L29:
        return r108;
    L33:
        return null;
    L32:
        return null;
    L31:
        return null;
    }
}
