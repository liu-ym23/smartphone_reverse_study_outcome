package oba;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.attention.ObricAttentionServiceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class i implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ObricAttentionServiceImpl f522629a;

    public i(ObricAttentionServiceImpl r100) {
        this.f522629a = r100;
    }

    @Override // android.content.ServiceConnection
    public final void onBindingDied(ComponentName r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        ObricAttentionServiceImpl.c(this.f522629a, this, r100, "binding_died");
    }

    @Override // android.content.ServiceConnection
    public final void onNullBinding(ComponentName r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        ObricAttentionServiceImpl.c(this.f522629a, this, r100, "null_binding");
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        ObricAttentionServiceImpl.c(this.f522629a, this, r100, "disconnected");
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName r100, IBinder r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "service");
        ObricAttentionServiceImpl r102 = this.f522629a;
        if (r102.f385596d == this) goto L5;
        return;
    L5:
        c r103 = r102.f385597e;
        if (r103 == null) goto L8;
        r102.f385593a.removeCallbacks(r103);
    L8:
        r102.f385597e = null;
        this.f522629a.f385595c = r101;
        FLogger.f375446a.i("ObricAttentionService", "attention service connected, component=" + r100);
        this.f522629a.d();
    }
}
