package q74;

import android.media.MediaDrm;
import android.os.Build;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class d extends p74.a {
    @Override // p74.a
    public final String b() {
        return "d_m0";
    }

    @Override // p74.a
    public final String c() {
        int r100 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L23 Exception -> L25
        MediaDrm r101 = new MediaDrm(new UUID(-1301668207276963122L, -6645017420763422227L));     // Catch: Throwable -> L23 Exception -> L25
        String r102 = y74.d.a(r101.getPropertyByteArray("deviceUniqueId"));     // Catch: Exception -> L21 Throwable -> L51
        if (r100 < 28) goto L83;
        r101.close();     // Catch: Exception -> L8
    L20:
        return r102;
    L8:
        e = move-exception;
        if (e.getCause() == null) goto L12;
        this.f528017b = e.getCause().getMessage();
        goto L20
    L12:
        this.f528017b = e.getMessage();
        goto L20
    L83:
        r101.release();     // Catch: Exception -> L15
    L15:
        e = move-exception;
        if (e.getCause() == null) goto L19;
        this.f528017b = e.getCause().getMessage();
        goto L20
    L19:
        this.f528017b = e.getMessage();
    L21:
        Exception e100 = e;
    L28:
        if (e100.getCause() == null) goto L30;
        this.f528017b = e100.getCause().getMessage();     // Catch: Throwable -> L51
    L32:
        if (Build.VERSION.SDK_INT < 28) goto L41;
        if (r101 == null) goto L87;
        r101.close();     // Catch: Exception -> L36
        return "";
    L36:
        e = move-exception;
        if (e.getCause() == null) goto L40;
        this.f528017b = e.getCause().getMessage();
        return "";
    L40:
        this.f528017b = e.getMessage();
        return "";
    L87:
        return "";
    L41:
        if (r101 == null) goto L90;
        r101.release();     // Catch: Exception -> L44
        return "";
    L44:
        e = move-exception;
        if (e.getCause() == null) goto L48;
        this.f528017b = e.getCause().getMessage();
        return "";
    L48:
        this.f528017b = e.getMessage();
        return "";
    L90:
        return "";
    L30:
        this.f528017b = e100.getMessage();     // Catch: Throwable -> L51
    L51:
        Throwable th10 = th;
    L53:
        if (Build.VERSION.SDK_INT < 28) goto L62;
        if (r101 != null) goto L73;
    L70:
        throw th10;
    L73:
        r101.close();     // Catch: Exception -> L57
    L57:
        e = move-exception;
        if (e.getCause() == null) goto L61;
        this.f528017b = e.getCause().getMessage();
        goto L70
    L61:
        this.f528017b = e.getMessage();
        goto L70
    L62:
        if (r101 == null) goto L70;
        r101.release();     // Catch: Exception -> L65
    L65:
        e = move-exception;
        if (e.getCause() == null) goto L69;
        this.f528017b = e.getCause().getMessage();
        goto L70
    L69:
        this.f528017b = e.getMessage();
        goto L70
    L25:
        e = move-exception;
        r101 = null;
        e100 = e;
    L23:
        th = move-exception;
        r101 = null;
        th10 = th;
        goto L53
    }

    public d(JSONObject r100) {
        super(r100);
    }
}
