package com.obric.matrix.push.common.cross_process;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.ArrayList;
import kka.b;

/* JADX INFO: loaded from: classes5.dex */
public final class a implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CrossProcessService f397019a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f397020b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ArrayList<Object> f397021c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ jka.a f397022d;

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName r100) {
        if (r100 == null) goto L5;
        CrossProcessService r101 = this.f397019a;
        b.a(r101.f397015b, "on bind  " + r100.getPackageName() + "'s CrossProcessService disconnected");
        r101.f397017d.remove(r100.getPackageName());
        ICrossProcessInterface r102 = r101.f397016c.remove(r100.getPackageName());
        return;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName r100, IBinder r101) {
        if (r100 == null) goto L7;
        CrossProcessService r102 = this.f397019a;
        String r103 = this.f397020b;
        ArrayList<Object> r104 = this.f397021c;
        jka.a r105 = this.f397022d;
        if (r101 == null) goto L8;
        b.a(r102.f397015b, "success bind  " + r100.getPackageName() + "'s CrossProcessService, invoke " + r103 + " method internal");
        ICrossProcessInterface r106 = ICrossProcessInterface.Stub.asInterface(r101);
        r102.f397017d.put(r100.getPackageName(), this);
        r102.f397016c.put(r100.getPackageName(), r106);
        r102.c(r106, r103, r104, r105);
        return;
    L8:
        return;
    }

    public a(CrossProcessService r100, String r101, ArrayList<Object> r102, jka.a r103) {
        this.f397019a = r100;
        this.f397020b = r101;
        this.f397021c = r102;
        this.f397022d = r103;
    }
}
