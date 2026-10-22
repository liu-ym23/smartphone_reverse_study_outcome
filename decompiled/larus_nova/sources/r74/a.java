package r74;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ JSONObject f536426a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f536427b;

    public final void a() {
        JSONObject r100 = new JSONObject();
        JSONObject r101 = new JSONObject();
        this.f536426a.putOpt("device_type", Build.MODEL);     // Catch: Exception -> L13
        this.f536426a.putOpt("device_platform", "android");     // Catch: Exception -> L13
        r100.putOpt("header", y74.d.b(this.f536426a));     // Catch: Exception -> L13
        String r102 = this.f536427b.f540926c.a(Constants.Keys.SP_D_DATA);     // Catch: Exception -> L13
        if (TextUtils.isEmpty(r102) == true) goto L6;
        r101.putOpt("message", com.bytedance.android.ec.core.event.a.VALUE_CLICK_TYPE);     // Catch: Exception -> L13
        r101.putOpt("data", r102);     // Catch: Exception -> L13
        this.f536427b.getClass();     // Catch: Exception -> L13
        m74.a.a("[dt] [collectLoader] get config from cache.");     // Catch: Exception -> L13
    L7:
        this.f536427b.f540927d.c(r101);     // Catch: Exception -> L13
        c r103 = this.f536427b;     // Catch: Exception -> L13
        HashMap r104 = (HashMap) r103.f540927d.f528023d;     // Catch: Exception -> L13
        if (r104.isEmpty() == false) goto L10;
        m74.a.a("[dt] [collectLoader] parseCollectorByConfig# config map is empty");     // Catch: Exception -> L13
    L11:
        this.f536427b.e();     // Catch: Exception -> L13
        c r105 = this.f536427b;     // Catch: Exception -> L13
        c.d(r105, this.f536426a, r105.f540928e);     // Catch: Exception -> L13
        return;
    L10:
        r103.a(r104);     // Catch: Exception -> L13
        goto L11
    L6:
        c r106 = this.f536427b;     // Catch: Exception -> L13
        Context r107 = r106.f540925b;     // Catch: Exception -> L13
        r101 = x74.c.b(r100, r106.f540928e);     // Catch: Exception -> L13
        this.f536427b.getClass();     // Catch: Exception -> L13
        m74.a.a("[dt] [collectLoader] get config from server.");     // Catch: Exception -> L13
    L13:
        e = move-exception;
        StringBuilder r108 = new StringBuilder("[dt] [collectLoader] handleCollect#error ");
        this.f536427b.getClass();
        r108.append(e.getMessage());
        m74.a.b(r108.toString());
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

    public a(c r100, JSONObject r101) {
        this.f536427b = r100;
        this.f536426a = r101;
    }
}
