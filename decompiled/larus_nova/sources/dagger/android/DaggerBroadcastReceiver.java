package dagger.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes41.dex */
public abstract class DaggerBroadcastReceiver extends BroadcastReceiver {
    public DaggerBroadcastReceiver() {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r100, Intent r101) {
        AndroidInjection.inject(this, r100);
    }
}
