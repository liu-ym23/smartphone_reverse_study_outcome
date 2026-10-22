package qr1;

import com.bytedance.android.live.livepullstream.api.apm.APMEvent;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public final class e implements Observer<Map<String, String>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f534519a;

    public e(i r100) {
        this.f534519a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Map r101 = (Map) r100;
        if (r101 != null) goto L5;
        this.f534519a.c(com.bytedance.android.live.livepullstream.api.apm.a.a(APMEvent.Level.E, "enter failed"));
        this.f534519a.a("network_status", "-1");
    L6:
        i r102 = this.f534519a;
        r102.f534528f.f534541b = true;
        r102.h(4, "enter failed cause of room/enter error");
        return;
    L5:
        this.f534519a.d("enter_room_log_id", (String) r101.get("log_id"));
        this.f534519a.c(com.bytedance.android.live.livepullstream.api.apm.a.c(APMEvent.Level.E, "enter failed", String.valueOf(r101)));
        this.f534519a.a("network_status", String.valueOf(r101.get("error_code")));
        goto L6
    }
}
