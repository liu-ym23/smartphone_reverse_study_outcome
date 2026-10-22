package n4a;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import java.io.ByteArrayOutputStream;

/* JADX INFO: loaded from: classes32.dex */
public final class r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f517631a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f517632b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f517633c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f517634d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f517635e;

    public r0(Context r100, String r101, String r102, String r103) throws com.loc.l {
        if (TextUtils.isEmpty(r103) == true) goto L9;
        if (r103.length() > 256) goto L9;
        this.f517631a = r100.getApplicationContext();
        this.f517633c = r101;
        this.f517634d = r102;
        this.f517632b = r103;
        return;
    L9:
        throw new com.loc.l(AMapException.AMAP_CLIENT_INVALID_PARAMETER);
    }

    public final void a(String r100) throws com.loc.l {
        if (TextUtils.isEmpty(r100) == true) goto L9;
        if (r100.length() > 65536) goto L9;
        this.f517635e = r100;
        return;
    L9:
        throw new com.loc.l(AMapException.AMAP_CLIENT_INVALID_PARAMETER);
    }

    public final byte[] b() {
        byte[] r100 = new byte[0];
        ByteArrayOutputStream r101 = null;
        ByteArrayOutputStream r102 = new ByteArrayOutputStream();     // Catch: Throwable -> L24
        f5.g(r102, this.f517633c);     // Catch: Throwable -> L22
        f5.g(r102, this.f517634d);     // Catch: Throwable -> L22
        f5.g(r102, this.f517632b);     // Catch: Throwable -> L22
        f5.g(r102, String.valueOf(x4.r(this.f517631a)));     // Catch: Throwable -> L22
        int r103 = (int) (System.currentTimeMillis() / 1000);
    L9:
        r102.write(new byte[]{(byte) ((r103 >> 24) & 255), (byte) ((r103 >> 16) & 255), (byte) ((r103 >> 8) & 255), (byte) (r103 & 255)});     // Catch: Throwable -> L22
        if (TextUtils.isEmpty(this.f517635e) == false) goto L13;
        byte[] r104 = new byte[2];     // Catch: Throwable -> L22
    L12:
        r104 = {x00a8: FILL_ARRAY_DATA  (LINE:168), data: [0, 0} // fill-array;     // Catch: Throwable -> L22
    L17:
        r102.write(r104);     // Catch: Throwable -> L22
        r102.write(f5.j(this.f517635e));     // Catch: Throwable -> L22
        r100 = r102.toByteArray();     // Catch: Throwable -> L22
        r102.close();     // Catch: Throwable -> L20
    L38:
    L28:
        return r100;
    L13:
        byte[] r105 = f5.j(this.f517635e);     // Catch: Throwable -> L22
        if (r105 != null) goto L16;
        r104 = new byte[2];     // Catch: Throwable -> L22
        goto L12
    L16:
        r104 = f5.i(r105.length);     // Catch: Throwable -> L22
    L7:
        r103 = 0;
    L22:
        th = th;
        r101 = r102;
    L43:
        r.f(th, "se", "tds");     // Catch: Throwable -> L29
        if (r101 == null) goto L28;
        r101.close();     // Catch: Throwable -> L20
    L29:
        th = move-exception;
        if (r101 != null) goto L36;
    L35:
        throw th;
    L36:
        r101.close();     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        th.printStackTrace();
    L20:
        th = move-exception;
        th.printStackTrace();
    L24:
        th = th;
        goto L43
    }
}
