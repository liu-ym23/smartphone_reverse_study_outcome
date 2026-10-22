package ss3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h extends BroadcastReceiver {
    public final /* synthetic */ i a;

    public h(i r1) {
        this.a = r1;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r3, Intent r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        this.a.d = r4.getIntExtra("temperature", 0) / 10.0f;
        this.a.e = r4.getIntExtra("status", 1);
        i r5 = this.a;
        r4.getIntExtra("plugged", -1);
        r5.getClass();
    }
}
