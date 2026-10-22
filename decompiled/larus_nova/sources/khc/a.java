package khc;

import android.app.Activity;
import android.content.Intent;
import com.ss.android.ugc.route_monitor.impl.launch_info.f;
import com.ss.android.ugc.route_monitor.utils.u;

/* JADX INFO: loaded from: classes40.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f503593a = 0;

    static {
    }

    public static f a(Activity r100, Intent r101) {
        if (r101 != null) goto L5;
        r101 = r100.getIntent();
    L5:
        String r102 = (String) u.c(r100, "mReferrer");
        if (r102 != null) goto L9;
        r102 = "";
    L9:
        f.a r103 = f.f454464l;
        String r104 = r100.getClass().getName();
        r103.getClass();
        f r105 = f.a.a(r104, r101, r102, r100);
        r105.f454467c = false;
        return r105;
    }
}
