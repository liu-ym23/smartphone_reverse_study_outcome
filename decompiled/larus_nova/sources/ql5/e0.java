package ql5;

import com.ss.android.cert.manager.constants.EventConstant;
import java.util.HashMap;

/* JADX INFO: loaded from: classes18.dex */
public final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f533787a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f533788b;

    public e0() {
    }

    public final void a(String r100) {
        HashMap r101 = new HashMap();
        r101.put("file_id", this.f533787a);
        r101.put("file_type", this.f533788b);
        r101.put(EventConstant.Key.MODULE, this.f533788b);
        r101.put("action", r100);
        ((com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class)).v("client_reminder_operation", r101);
    }
}
