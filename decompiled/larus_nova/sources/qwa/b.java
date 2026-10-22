package qwa;

import android.app.Activity;
import androidx.lifecycle.LifecycleOwner;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Activity f535070a;

    public b(Activity r100) {
        this.f535070a = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a() {
        Activity r100 = this.f535070a;
        if (r100 != null) goto L7;
        Log.e("UnifiedStorageLimitCTAUtil", "top activity is null, returns show cta dialog.");
        return;
    L7:
        if (r100.isFinishing() == false) goto L9;
    L31:
        Log.e("UnifiedStorageLimitCTAUtil", "activity is finishing or is destroyed, returns show cta dialog.");
        return;
    L9:
        if (this.f535070a.isDestroyed() == true) goto L31;
        if ((this.f535070a instanceof LifecycleOwner) == true) goto L15;
        Log.e("UnifiedStorageLimitCTAUtil", "activity is is not LifecycleOwner, returns show cta dialog.");
        return;
    L15:
        String r101 = owa.a.d().getTenantId();
        String r102 = owa.a.d().getUserId();
        boolean r103 = false;
        if (r101.length() != 0) goto L18;
        boolean r104 = true;
    L20:
        if (r104 == false) goto L22;
        String r110 = "0";
    L24:
        if (r102.length() != 0) goto L26;
        r103 = true;
    L26:
        if (r103 == false) goto L28;
        String r111 = "0";
    L29:
        Log.i("UnifiedStorageLimitCTAUtil", "check point tenant id = " + r110 + ", check point user id = " + r111);
        Activity r105 = this.f535070a;
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        com.suite.lark.platform.component.cta.a.b(r105, (LifecycleOwner) r105, "unified_storage_limit", "scene_limit_unified_storage_limit", r110, r111, 64);
        return;
    L28:
        r111 = r102;
        goto L29
    L22:
        r110 = r101;
        goto L24
    L18:
        r104 = false;
        goto L20
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
