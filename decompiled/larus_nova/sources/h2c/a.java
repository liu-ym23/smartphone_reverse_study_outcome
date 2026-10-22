package h2c;

import android.os.SystemClock;
import android.view.View;
import com.ss.android.lark.quicklaunchbar.widget.QuickLaunchBar;

/* JADX INFO: loaded from: classes37.dex */
public abstract class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f483642a;

    /* JADX INFO: renamed from: h2c.a$a, reason: collision with other inner class name */
    public static final class C6094a {
    }

    static {
    }

    public a() {
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        long r101 = SystemClock.elapsedRealtime();
        if ((r101 - this.f483642a) <= 500) goto L10;
        com.ss.android.lark.quicklaunchbar.widget.a r102 = (com.ss.android.lark.quicklaunchbar.widget.a) this;
        if (r102.f439143b == false) goto L7;
        QuickLaunchBar r103 = r102.f439144c;
        int r104 = QuickLaunchBar.f439134g;
        r103.getClass();
    L8:
        r102.f439145d.getClass();
        this.f483642a = r101;
        return;
    L7:
        QuickLaunchBar r105 = r102.f439144c;
        int r106 = QuickLaunchBar.f439134g;
        r105.getClass();
        goto L8
    }
}
