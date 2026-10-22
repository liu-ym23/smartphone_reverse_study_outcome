package ww7;

import android.content.Intent;
import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public final class i0 implements Callable<c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Intent f561665a;

    @Override // java.util.concurrent.Callable
    public c call() throws Exception {
        Intent r100 = this.f561665a;
        if (r100 == null) goto L43;
        long r101 = 0;
        r101 = r100.getLongExtra("msg_id", 0);     // Catch: Exception -> L7
    L38:
        byte[] r102 = this.f561665a.getByteArrayExtra("msg_content");     // Catch: Exception -> L11
    L12:
        if (r102 != null) goto L14;
    L30:
        String r103 = null;
    L31:
        if (r103 == null) goto L44;
        String r104 = new JSONObject(r103).optString("data");
        if (TextUtils.isEmpty(r104) == true) goto L45;
        c r105 = new c();
        r105.f561641a = r101;
        r105.f561642b = r104;
        return r105;
    L45:
        return null;
    L44:
        return null;
    L14:
        if (r102.length == 0) goto L30;
        ByteArrayInputStream r106 = new ByteArrayInputStream(r102);
        InflaterInputStream r107 = new InflaterInputStream(r106, new Inflater());
        ByteArrayOutputStream r108 = new ByteArrayOutputStream();
        byte[] r109 = new byte[256];     // Catch: Throwable -> L23 IOException -> L25
    L18:
        int r110 = r107.read(r109);     // Catch: Throwable -> L23 IOException -> L25
        if (r110 <= 0) goto L21;
        r108.write(r109, 0, r110);     // Catch: Throwable -> L23 IOException -> L25
        goto L18
    L21:
        r103 = r108.toString("UTF-8");     // Catch: Throwable -> L23 IOException -> L25
        i.h(r106);
        i.h(r107);
        i.h(r108);
        goto L31
    L23:
        th = move-exception;
        i.h(r106);
        i.h(r107);
        i.h(r108);
        throw th;
    L26:
        k.b("unZipString");     // Catch: Throwable -> L23
        i.h(r106);
        i.h(r107);
        i.h(r108);
    L11:
        k.b("parseMsgContent");
        r102 = null;
    L7:
        k.b("parserMsgId");
        goto L38
    L43:
        return null;
    }

    public i0(Intent r100) {
        this.f561665a = r100;
    }
}
