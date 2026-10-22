package mo7;

import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import jn7.l;

/* JADX INFO: loaded from: classes22.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ArrayList f514609a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f514610b;

    @Override // java.lang.Runnable
    public final void run() {
        f r100 = this.f514610b;     // Catch: Throwable -> L20
        r100.getClass();     // Catch: Throwable -> L20
        eo7.a r101 = eo7.a.b.f473353a;     // Catch: Throwable -> L20
        if (r101.h() != null) goto L6;
        return;
    L6:
        if (r100.f514613b != null) goto L8;
        return;
    L8:
        if (r100.f514612a != null) goto L11;
        return;
    L11:
        if (r101.h() == null) goto L29;
        l r102 = r101.f473336j;     // Catch: Throwable -> L20
        if (r102 == null) goto L16;
        r102.b();     // Catch: Throwable -> L20
    L16:
        l r103 = com.bytedance.ug.sdk.share.impl.manager.b.c();     // Catch: Throwable -> L20
        if (r103 == null) goto L30;
        r103.b();     // Catch: Throwable -> L20
        return;
    L30:
        return;
    L29:
        return;
    L20:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L31;
        throw th;
    }

    public e(f r100, ShareContent r101, ArrayList r102) {
        this.f514610b = r100;
        this.f514609a = r102;
    }
}
