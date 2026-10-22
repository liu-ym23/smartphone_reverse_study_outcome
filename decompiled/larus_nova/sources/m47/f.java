package m47;

import com.google.gson.JsonObject;

/* JADX INFO: loaded from: classes21.dex */
public final /* synthetic */ class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f511861a;

    public /* synthetic */ f(o r100) {
        this.f511861a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        o r100 = this.f511861a;
        if (r100.f511888d == true) goto L10;
        r100.f511888d = true;
        com.bytedance.pia.core.utils.a<JsonObject> r101 = r100.f511889e;
        r101.f266388d = true;
        r101.b();
        r101.f266385a.set(null);
        n47.a r102 = r100.f511890f;
        if (r102 == null) goto L9;
        r102.close();
        return;
    L9:
        return;
    }
}
