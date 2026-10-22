package fva;

import android.app.Application;
import android.content.Context;
import com.ss.android.lark.officesdk.launcher.OfficeSDKAppLauncher;
import com.ss.android.lark.officesdk.launcher.i;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.ss.android.lark.app.initiator.b f478969a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f478970b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f478971c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set<fva.a> f478972d;

    public interface a {
        com.ss.android.lark.app.initiator.b a(Application r100);
    }

    public final void a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "base");
        Iterator<T> r101 = this.f478972d.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((fva.a) r101.next()).a();
        goto L4
    L6:
        com.ss.android.lark.app.initiator.b r102 = this.f478971c.a(this.f478970b.getApplication());
        this.f478969a = r102;
        if (r102 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("mAppLauncher");
        r102 = null;
    L9:
        r102.attachBaseContext(this.f478970b.getApplication());
    }

    public c(OfficeSDKAppLauncher r100, i r101) {
        Set<fva.a> r102 = SetsKt.emptySet();
        Intrinsics.checkNotNullParameter(r100, "applicationDelegate");
        Intrinsics.checkNotNullParameter(r101, "launcherFactory");
        Intrinsics.checkNotNullParameter(r102, "launchInterceptors");
        this.f478970b = r100;
        this.f478971c = r101;
        this.f478972d = r102;
    }
}
