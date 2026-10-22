package uwa;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;

/* JADX INFO: loaded from: classes34.dex */
public class d implements a.InterfaceC7940a {
    public d() {
    }

    @Override // uwa.a.InterfaceC7940a
    public void afterOnCreate(Activity r100, boolean r101) {
    }

    @Override // uwa.a.InterfaceC7940a
    public void afterOnPause(Activity r100) {
    }

    @Override // uwa.a.InterfaceC7940a
    public void afterOnResume(Activity r100) {
    }

    @Override // uwa.a.InterfaceC7940a
    public Context injectBaseContext(Context r100) {
        return r100;
    }

    @Override // uwa.a.InterfaceC7940a
    public Intent injectGetIntent(Intent r100) {
        return r100;
    }

    @Override // uwa.a.InterfaceC7940a
    public boolean onDetectKeyEvent(Activity r100, KeyEvent r101) {
        return false;
    }
}
