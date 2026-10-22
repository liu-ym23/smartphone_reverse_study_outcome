package dagger.android;

import android.app.IntentService;

/* JADX INFO: loaded from: classes41.dex */
public abstract class DaggerIntentService extends IntentService {
    @Override // android.app.IntentService, android.app.Service
    public void onCreate() {
        AndroidInjection.inject(this);
        super.onCreate();
    }

    public DaggerIntentService(String r100) {
        super(r100);
    }
}
