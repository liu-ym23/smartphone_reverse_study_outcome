package sea;

import android.os.SystemClock;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Unit> f541627a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f541628b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f541629c;

    /* JADX INFO: renamed from: sea.a$a, reason: collision with other inner class name */
    public static final class C7602a {
    }

    static {
    }

    public final void a() {
        FLogger r100 = FLogger.f375446a;
        r100.i("ClickWithQuicklyProtection", "onClick hashcode " + hashCode());
        long r101 = SystemClock.elapsedRealtime();
        if ((r101 - this.f541629c) >= this.f541628b) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L8;
        this.f541629c = r101;
    L8:
        if (r102 == false) goto L11;
        r100.i("ClickWithQuicklyProtection", "isQuicklyClick");
        return;
    L11:
        this.f541627a.invoke();
        return;
    L5:
        r102 = false;
        goto L6
    }

    public a(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "onClickListener");
        this.f541627a = r100;
        this.f541628b = 3000;
    }
}
