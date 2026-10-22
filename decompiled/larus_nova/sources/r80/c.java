package r80;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.config.p5;
import j40.j0;

/* JADX INFO: loaded from: classes45.dex */
public class c implements com.bytedance.android.live.core.utils.screen.b, com.bytedance.android.live.core.utils.screen.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p5 f536494a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f536495b;

    @Override // com.bytedance.android.live.core.utils.screen.b
    public boolean isFoldScreen() {
        if (this.f536494a.b() == true) goto L7;
        return false;
    L7:
        return this.f536494a.c().contains(Build.MODEL);
    }

    public c() {
        this.f536494a = j0.f497243a.getValue();
        this.f536495b = "dynamic_fold_screen_checker";
    }

    @Override // com.bytedance.android.live.core.utils.screen.b
    public int a(Configuration r100) {
        if (r100 != null) goto L6;
        return -1;
    L6:
        if (isFoldScreen() == true) goto L8;
        return -1;
    L8:
        ALogger.d(this.f536495b, b.f536493a);
        float r101 = (r100.screenHeightDp * 1.0f) / r100.screenWidthDp;
        if (r101 >= 0.75f) goto L11;
    L13:
        return 1;
    L11:
        if (r101 > 1.5f) goto L13;
        return 0;
    }

    @Override // com.bytedance.android.live.core.utils.screen.a
    public final boolean b(Context r100) {
        if (this.f536494a.b() == true) goto L7;
        return false;
    L7:
        return this.f536494a.a().contains(Build.MODEL);
    }
}
