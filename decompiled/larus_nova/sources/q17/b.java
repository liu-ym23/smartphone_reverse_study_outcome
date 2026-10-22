package q17;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import java.util.List;
import org.json.JSONObject;
import r17.c;

/* JADX INFO: loaded from: classes21.dex */
public final class b extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f531309a;

    public b(a r100) {
        this.f531309a = r100;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r100, Intent r101) {
        c.b("ResultReceiver onReceive", new Object[0]);
        this.f531309a.f531302d = false;
        if (r101.hasExtra("Key_Result_Client_Memory") == false) goto L17;
        String r102 = r101.getStringExtra("Key_Result_Client_Memory");
    L12:
        e = move-exception;
        c.b("deleteCache catch", new Object[0]);
        e.printStackTrace();
        return;
    L6:
        if (TextUtils.isEmpty(r102) == false) goto L8;
    L10:
        c.b("deleteCache", new Object[0]);     // Catch: Exception -> L12
        com.bytedance.memory.heap.a.b().a();     // Catch: Exception -> L12
        return;
    L8:
        if (TextUtils.isEmpty(new JSONObject(r102).optString("memory_object")) == true) goto L10;
        c.b("can upload", new Object[0]);     // Catch: Exception -> L12
        t17.a.d("client_analyze_time", System.currentTimeMillis() - this.f531309a.f531301c);     // Catch: Exception -> L12
        List<String> r103 = com.bytedance.memory.upload.c.f265535a;     // Catch: Exception -> L12
        r17.b.f535670b.a(new com.bytedance.memory.upload.a(r102), "uploadClientResult-MNA");     // Catch: Exception -> L12
        goto L10
    }
}
