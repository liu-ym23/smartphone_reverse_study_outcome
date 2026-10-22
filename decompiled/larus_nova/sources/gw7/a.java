package gw7;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.hihonor.cloudservice.common.ApiException;
import com.hihonor.cloudservice.support.account.result.SignInAccountInfo;
import com.hihonor.cloudservice.support.api.clients.Status;
import com.hihonor.honorid.core.data.HonorAccount;
import exc.e;
import java.lang.ref.WeakReference;
import lw7.d;

/* JADX INFO: loaded from: classes23.dex */
public final class a {
    public static d a(int r100, Intent r101) {
        e.c("AccountAuthUtil", "getSignInResultFromIntent : resultCode" + r100);
        kw7.e r102 = new kw7.e();
        String r103 = "intent is null";
        Context r104 = null;
        if (r101 == null) goto L45;
        if ((-2) != r100) goto L7;
    L28:
        Bundle r105 = r101.getExtras();
        HonorAccount r106 = new HonorAccount();
        r106.a(r105);
        monitor-enter(mw7.a.class);
    L41:
        th = move-exception;
        throw th;
    L31:
        if (mw7.a.f515971b != null) goto L33;
        mw7.a.f515971b = new mw7.a();     // Catch: Throwable -> L41
    L33:
        mw7.a r107 = mw7.a.f515971b;     // Catch: Throwable -> L41
        monitor-exit(mw7.a.class);
        WeakReference<Context> r108 = r107.f515972a;
        if (r108 != null) goto L38;
    L40:
        rw7.a.a(r104).b(r106);
        r102.setResult(new SignInAccountInfo(r106.f276560v, r106.f276559u, r106.f276564z, r106.A));
        return r102.f506402a;
    L38:
        if (r108.get() == null) goto L40;
        r104 = r107.f515972a.get();
        goto L40
    L7:
        if ((-1) == r100) goto L28;
        if (57 != r100) goto L12;
        String r109 = "mcp check fail";
    L54:
        r102.a(new ApiException(new Status(r100, r109, null)));
        return r102.f506402a;
    L12:
        int r110 = 56;
        if (56 != r100) goto L25;
        Bundle r111 = r101.getExtras();
        if (r111 == null) goto L17;
        r110 = r111.getInt("err_code", 56);
        r103 = r111.getString("server_err_desc", "access server return error");
    L17:
        e.c("AccountAuthUtil", "loginResult : errCode = " + r110 + " errMsg = " + r103);
        if (1101 != r110) goto L21;
    L52:
        r100 = 67;
    L53:
        r109 = r103;
        goto L54
    L21:
        if (1202 != r110) goto L23;
        r100 = 68;
        goto L53
    L23:
        r109 = r103;
        r100 = r110;
        goto L54
    L25:
        if (2005 != r100) goto L27;
        r109 = "network unaviable!";
        r100 = 5;
        goto L54
    L27:
        r109 = "other error!";
        goto L54
    L45:
        if (r100 != 2) goto L47;
        r109 = "serviceToken invalid!";
        r100 = 30;
        goto L54
    L47:
        if (r100 != 0) goto L50;
        r109 = "user cancel login!";
        r100 = 3002;
        goto L54
    L50:
        if (2012 != r100) goto L52;
        r109 = "user cancel auth!";
        r100 = 70;
        goto L54
    }
}
