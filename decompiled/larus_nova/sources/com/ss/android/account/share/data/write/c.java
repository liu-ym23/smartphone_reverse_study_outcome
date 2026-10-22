package com.ss.android.account.share.data.write;

import android.content.pm.Signature;
import android.util.Log;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.security.MessageDigest;
import kotlin.TypeCastException;
import kotlin.UByte;

/* JADX INFO: loaded from: classes34.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f406343a = 0;

    static {
    }

    public static String a(Signature r100) {
        byte[] r101 = r100.toByteArray();
        StringBuffer r102 = new StringBuffer();     // Catch: Exception -> L17
        MessageDigest r103 = MessageDigest.getInstance("SHA256");     // Catch: Exception -> L17
        if (r103 == null) goto L19;
        r103.reset();     // Catch: Exception -> L17
        r103.update(r101);     // Catch: Exception -> L17
        byte[] r104 = r103.digest();     // Catch: Exception -> L17
        int r105 = r104.length;     // Catch: Exception -> L17
        int r106 = 0;
    L6:
        if (r106 >= r105) goto L12;
        if (Integer.toHexString(r104[r106] & UByte.MAX_VALUE).length() != 1) goto L10;
        r102.append("0");     // Catch: Exception -> L17
        r102.append(Integer.toHexString(r104[r106] & UByte.MAX_VALUE));     // Catch: Exception -> L17
    L11:
        r106 = r106 + 1;     // Catch: Exception -> L17
        goto L6
    L10:
        r102.append(Integer.toHexString(r104[r106] & UByte.MAX_VALUE));     // Catch: Exception -> L17
        goto L11
    L12:
        String r107 = r102.toString();     // Catch: Exception -> L17
        if (r107 == null) goto L16;
        return r107.toUpperCase();
    L16:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");     // Catch: Exception -> L17
    L19:
        return "";
    L17:
        e = move-exception;
        e.printStackTrace();
        dra.b r108 = new dra.b();
        r108.b("share_sdk_get_pkg_sign_failed");
        r108.a(LocationMonitorConst.ERR_MSG, e.getMessage());
        r108.a("err_msg_stack", Log.getStackTraceString(e));
        r108.c();
        goto L19
    }
}
