package pr4;

import android.os.SystemClock;
import android.view.View;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public abstract class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f530359a;

    /* JADX INFO: renamed from: pr4.a$a, reason: collision with other inner class name */
    public static final class C7231a {
    }

    static {
    }

    public abstract void a(View r100);

    public a() {
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        long r101 = SystemClock.uptimeMillis();
        if ((r101 - this.f530359a) <= 500) goto L6;
        a(r100);
        this.f530359a = r101;
        return;
    }
}
