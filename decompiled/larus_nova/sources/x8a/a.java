package x8a;

import android.text.TextUtils;
import android.util.Log;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f562933a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f562934b;

    public final void a() {
        c r100 = this.f562934b;
        String r101 = this.f562933a;
        if (TextUtils.isEmpty(r101) == false) goto L26;
    L14:
        z8a.a r102 = null;
    L15:
        r100.getClass();
        if (com.bytedance.apm.d.j() == false) goto L18;
        ps3.b.a(new String[]{"handleCloudMessageInternal cloudMessage=" + r102});
    L18:
        if (r102 == null) goto L25;
        Iterator<a9a.b> r103 = r100.f562944b.iterator();
    L22:
        if (r103.hasNext() == false) goto L31;
        if (r103.next().b(r102) == false) goto L22;
        return;
    L31:
        return;
    L25:
        return;
    L26:
        r102 = new z8a.a();     // Catch: Exception -> L10
        JSONObject r104 = new JSONObject(r101);     // Catch: Exception -> L10
        r102.f570967c = r104.optString("command_id");     // Catch: Exception -> L10
        r102.f570966b = r104.optString("type");     // Catch: Exception -> L10
        String r105 = r104.optString("params");     // Catch: Exception -> L10
        JSONObject r106 = new JSONObject();     // Catch: Exception -> L10
        if (TextUtils.isEmpty(r105) == true) goto L8;
        r106 = new JSONObject(r105);     // Catch: Exception -> L10
    L8:
        r102.f570965a = r105;     // Catch: Exception -> L10
        r102.f570968d = r106;     // Catch: Exception -> L10
    L10:
        e = move-exception;
        if (com.bytedance.apm.d.j() == false) goto L14;
        ps3.b.a(new String[]{"Parse CloudMessage Error."});
        Log.getStackTraceString(e);
        goto L14
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

    public a(c r100, String r101) {
        this.f562934b = r100;
        this.f562933a = r101;
    }
}
