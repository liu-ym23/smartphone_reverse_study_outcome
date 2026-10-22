package com.bytedance.ee.lark.infra.cookie.persistence;

import android.text.TextUtils;
import com.bytedance.ee.lark.infra.foundation.log.AppBrandLogger;
import com.bytedance.ee.lark.infra.sandbox.context.IAppContext;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import kotlin.UByte;
import okhttp3.g;

/* JADX INFO: loaded from: classes19.dex */
public class SerializableCookie implements Serializable {
    private static final long serialVersionUID = -8594045714036645534L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient g f242790a;

    public SerializableCookie() {
    }

    private void readObject(ObjectInputStream r100) throws IOException, ClassNotFoundException {
        g.a r101 = new g.a();
        r101.c((String) r100.readObject());
        r101.e((String) r100.readObject());
        long r102 = r100.readLong();
        if (r102 == (-1)) goto L5;
        r101.b(r102);
    L5:
        String r103 = (String) r100.readObject();
        r101.a(r103, false);
        r101.d((String) r100.readObject());
        if (r100.readBoolean() == false) goto L9;
        r101.f523869f = true;
    L9:
        if (r100.readBoolean() == false) goto L12;
        r101.f523870g = true;
    L12:
        if (r100.readBoolean() == false) goto L14;
        r101.a(r103, true);
    L14:
        this.f242790a = new g(r101);
    }

    private void writeObject(ObjectOutputStream r100) throws IOException {
        r100.writeObject(this.f242790a.f523855a);
        r100.writeObject(this.f242790a.f523856b);
        g r101 = this.f242790a;
        if (r101.f523862h == false) goto L5;
        long r102 = r101.f523857c;
    L6:
        r100.writeLong(r102);
        r100.writeObject(this.f242790a.f523858d);
        r100.writeObject(this.f242790a.f523859e);
        r100.writeBoolean(this.f242790a.f523860f);
        r100.writeBoolean(this.f242790a.f523861g);
        r100.writeBoolean(this.f242790a.f523863i);
        return;
    L5:
        r102 = -1;
        goto L6
    }

    /* JADX WARN: Not initialized variable reg: 6, insn: 0x0051: MOVE (r5 I:??[OBJECT, ARRAY]) = (r6 I:??[OBJECT, ARRAY]) (LINE:16777297), block:B:18:0x0051 */
    public String encode(g r110) {
        this.f242790a = r110;
        ByteArrayOutputStream r111 = new ByteArrayOutputStream();
        int r100 = 0;
        ObjectOutputStream r101 = null;
        ObjectOutputStream r102 = new ObjectOutputStream(r111);     // Catch: Throwable -> L21 IOException -> L23
        r102.writeObject(this);     // Catch: Throwable -> L17 IOException -> L19
        r102.close();     // Catch: IOException -> L7
    L9:
        byte[] r112 = r111.toByteArray();
        StringBuilder r103 = new StringBuilder(r112.length * 2);
        int r104 = r112.length;
    L10:
        if (r100 >= r104) goto L16;
        int r105 = r112[r100] & UByte.MAX_VALUE;
        if (r105 >= 16) goto L14;
        r103.append('0');
    L14:
        r103.append(Integer.toHexString(r105));
        r100 = r100 + 1;
        goto L10
    L16:
        return r103.toString();
    L7:
        e = move-exception;
        AppBrandLogger.d("SerializableCookie", new Object[]{"Stream not closed in encodeCookie", e});
    L19:
        e = e;
    L25:
        AppBrandLogger.d("SerializableCookie", new Object[]{"IOException in encodeCookie", e});     // Catch: Throwable -> L17
        if (r102 != null) goto L39;
    L31:
        return null;
    L39:
        r102.close();     // Catch: IOException -> L29
    L29:
        e = move-exception;
        AppBrandLogger.d("SerializableCookie", new Object[]{"Stream not closed in encodeCookie", e});
        goto L31
    L17:
        th = th;
        r101 = r6;
    L32:
        if (r101 != null) goto L43;
    L37:
        throw th;
    L43:
        r101.close();     // Catch: IOException -> L35
    L35:
        e = move-exception;
        AppBrandLogger.d("SerializableCookie", new Object[]{"Stream not closed in encodeCookie", e});
    L23:
        e = e;
        r102 = null;
    L21:
        th = th;
        goto L32
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.ObjectInputStream] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [int] */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r5v10, types: [int] */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v9 */
    public g decode(String r110, IAppContext r111) {
        g r100 = null;
        r100 = null;
        r100 = null;
        r100 = null;
        r100 = null;
        r100 = null;
        r100 = null;
        ?? r101 = 0;
        if (TextUtils.isEmpty(r110) == false) goto L56;
        return null;
    L56:
        int r102 = r110.length();     // Catch: Throwable -> L10
        byte[] r103 = new byte[r102 / 2];     // Catch: Throwable -> L10
        ?? r104 = 0;
    L7:
        if (r104 >= r102) goto L12;
        r103[r104 / 2] = (byte) ((Character.digit(r110.charAt(r104), 16) << 4) + Character.digit(r110.charAt(r104 + 1), 16));     // Catch: Throwable -> L10
        r104 = r104 + 2;
    L12:
        if (r103 == null) goto L50;
        ByteArrayInputStream r112 = new ByteArrayInputStream(r103);
        int r105 = 2;
        r105 = 2;
        r105 = 2;
        r105 = 2;
        r105 = 2;
        r105 = 2;
        r105 = 2;
        ObjectInputStream r106 = new ObjectInputStream(r112);     // Catch: Throwable -> L26 ClassNotFoundException -> L28 IOException -> L36
        r100 = ((SerializableCookie) r106.readObject()).f242790a;     // Catch: Throwable -> L20 ClassNotFoundException -> L22 IOException -> L24
        r106.close();     // Catch: IOException -> L18
        r104 = r106;
    L53:
    L18:
        e = move-exception;
        AppBrandLogger.e("SerializableCookie", new Object[]{"Stream not closed in decodeCookie", e});
        goto L50
    L24:
        e = e;
    L38:
        AppBrandLogger.e("SerializableCookie", new Object[]{"IOException in decodeCookie", e});     // Catch: Throwable -> L20
        r104 = r106;
        if (r106 == null) goto L53;
        r106.close();     // Catch: IOException -> L42
        r104 = r106;
    L42:
        e = move-exception;
        Object[] r107 = {"Stream not closed in decodeCookie", e};
        AppBrandLogger.e("SerializableCookie", r107);
        r105 = r107;
        r104 = r106;
    L22:
        e = e;
    L30:
        AppBrandLogger.e("SerializableCookie", new Object[]{"ClassNotFoundException in decodeCookie", e});     // Catch: Throwable -> L20
        r104 = r106;
        if (r106 == null) goto L53;
        r106.close();     // Catch: IOException -> L34
        r104 = r106;
    L34:
        e = move-exception;
        Object[] r108 = {"Stream not closed in decodeCookie", e};
        AppBrandLogger.e("SerializableCookie", r108);
        r105 = r108;
        r104 = r106;
        goto L53
    L20:
        th = th;
        r101 = r104;
    L44:
        if (r101 != 0) goto L58;
    L49:
        throw th;
    L58:
        r101.close();     // Catch: IOException -> L47
    L47:
        e = move-exception;
        Object[] r109 = new Object[r105];
        r109[0] = "Stream not closed in decodeCookie";
        r109[1] = e;
        AppBrandLogger.e("SerializableCookie", r109);
    L36:
        e = e;
        r106 = null;
    L28:
        e = e;
        r106 = null;
    L26:
        th = th;
    L50:
        return r100;
    L10:
        th = move-exception;
        AppBrandLogger.eWithThrowable("SerializableCookie", r110, th);
        r103 = null;
        goto L12
    }
}
