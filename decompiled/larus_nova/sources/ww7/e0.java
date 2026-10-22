package ww7;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.hihonor.push.framework.aidl.entity.PushTokenResult;
import com.hihonor.push.sdk.common.data.DownMsgType;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes23.dex */
public final class e0 implements Callable<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f561653a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k0 f561654b;

    @Override // java.util.concurrent.Callable
    public String call() throws Exception {
        this.f561654b.f561669b.getClass();
        p r100 = new p();     // Catch: Exception -> L15
        r100.f561706e = i.a();     // Catch: Exception -> L15
        y0 r101 = y0.f561725c;     // Catch: Exception -> L15
        r101.getClass();     // Catch: Exception -> L15
        f0<TResult> r102 = new f0();     // Catch: Exception -> L15
        r100.f561702a = r102;     // Catch: Exception -> L15
        Handler r103 = r101.f561726a;     // Catch: Exception -> L15
        r103.sendMessage(r103.obtainMessage(1, r100));     // Catch: Exception -> L15
        String r104 = ((PushTokenResult) i.c(r102.f561656a)).getPushToken();     // Catch: Exception -> L15
        if (this.f561653a == false) goto L14;
        k0 r105 = this.f561654b;
        r105.getClass();
        if (TextUtils.isEmpty(r104) == true) goto L14;
        Bundle r106 = new Bundle();
        r106.putString("event_type", DownMsgType.RECEIVE_TOKEN);
        r106.putString("push_token", r104);
        u r107 = new u();
        Context r108 = r105.f561668a;
        Intent r109 = new Intent();     // Catch: Exception -> L12
        r109.setPackage(r108.getPackageName());     // Catch: Exception -> L12
        r109.setAction("com.hihonor.push.action.MESSAGING_EVENT");     // Catch: Exception -> L12
        Context r110 = r108.getApplicationContext();     // Catch: Exception -> L12
        r107.f561715c = r110;     // Catch: Exception -> L12
        r107.f561714b = r106;     // Catch: Exception -> L12
        r110.bindService(r109, r107, 1);     // Catch: Exception -> L12
    L12:
        e = move-exception;
        e.getMessage();
    L14:
        return r104;
    L15:
        e = move-exception;
        throw i.b(e);
    }

    public e0(k0 r100, boolean r101) {
        this.f561654b = r100;
        this.f561653a = r101;
    }
}
