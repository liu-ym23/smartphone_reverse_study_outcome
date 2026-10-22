package jb5;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ x18.b f498003a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f498004b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ List f498005c;

    @Override // java.lang.Runnable
    public final void run() {
        this.f498003a.b(this.f498004b, this.f498005c);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public a(x18.b r100, String r101, List r102) {
        this.f498003a = r100;
        this.f498004b = r101;
        this.f498005c = r102;
    }
}
