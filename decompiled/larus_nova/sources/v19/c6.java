package v19;

import android.view.View;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public abstract class c6 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f552452a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f552453b;

    public abstract void a(View r100);

    public c6() {
        this.f552452a = 500;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        long r101 = System.currentTimeMillis();
        if ((r101 - this.f552453b) <= this.f552452a) goto L6;
        a(r100);
        this.f552453b = r101;
        return;
    }
}
