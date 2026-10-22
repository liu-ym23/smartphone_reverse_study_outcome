package rs3;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f539100a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f539101b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ JSONObject f539102c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ b f539103d;

    @Override // java.lang.Runnable
    public final void run() {
        Iterator<os3.a> r100 = this.f539103d.f539105a.iterator();     // Catch: Throwable -> L7
    L4:
        if (r100.hasNext() == false) goto L16;
        r100.next().onLog(this.f539100a, this.f539101b, this.f539102c);     // Catch: Throwable -> L7
        goto L4
    L16:
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }

    public a(b r100, String r101, String r102, JSONObject r103) {
        this.f539103d = r100;
        this.f539100a = r101;
        this.f539101b = r102;
        this.f539102c = r103;
    }
}
