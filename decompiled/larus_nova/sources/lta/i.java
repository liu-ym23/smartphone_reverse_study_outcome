package lta;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bytedance.common.utility.NetworkUtils;
import java.lang.ref.WeakReference;
import java.util.Iterator;

/* JADX INFO: loaded from: classes6.dex */
public final class i extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f510753a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h.b f510754b;

    public i(h.b r100) {
        this.f510754b = r100;
        this.f510753a = true;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r100, Intent r101) {
        if (this.f510753a == false) goto L6;
        this.f510753a = false;
        return;
    L6:
        if (r101 != null) goto L9;
        return;
    L9:
        if (r101.getBooleanExtra("noConnectivity", false) == false) goto L12;
        return;
    L12:
        if (NetworkUtils.isNetworkAvailable(this.f510754b.f510752c) == false) goto L19;
        Iterator<WeakReference<h.b.a>> r102 = this.f510754b.f510750a.iterator();
    L15:
        if (r102.hasNext() == false) goto L25;
        h.b.a r103 = r102.next().get();
        if (r103 == null) goto L15;
        r103.onNetworkReady();
        goto L15
    L25:
        return;
    }
}
