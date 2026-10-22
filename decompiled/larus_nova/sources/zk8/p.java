package zk8;

import android.app.Application;
import android.content.Context;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes26.dex */
public final /* synthetic */ class p implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f572690a;

    public /* synthetic */ p(Context r100) {
        this.f572690a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context r100 = this.f572690a;
        t19.s r101 = t19.s.f544207a;
        Application r102 = AppHost.f326268a.getApplication();
        String r103 = r100.getString(R.string.larus_create_bot_settings_sound_popup_error_msg);
        r101.getClass();
        t19.s.c(r102, r103);
    }
}
