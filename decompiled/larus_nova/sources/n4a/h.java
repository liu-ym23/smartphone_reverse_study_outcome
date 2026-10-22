package n4a;

import android.content.Context;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.xml.XML;
import java.io.IOException;
import java.net.URLEncoder;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public final class h implements x4.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f517306a;

    public h() {
        this.f517306a = new i();
    }

    public final Map<String, String> c() {
        i r100 = this.f517306a;
        monitor-enter(r100);
    L16:
        th = move-exception;
        throw th;
    L5:
        String r101 = null;
        if (i.f517368g == false) goto L10;
        monitor-exit(r100);
        return null;
    L10:
        i.f517368g = true;     // Catch: Throwable -> L16
        HashMap r102 = new HashMap();     // Catch: Throwable -> L16
        r102.put(f5.o("FZW50"), f5.o("FMg"));     // Catch: Throwable -> L16
        StringBuilder r103 = new StringBuilder();     // Catch: Throwable -> L16
        r103.append(f5.o("SY2hhbm5lbD0"));     // Catch: Throwable -> L16
        String r104 = i.f517364c;     // Catch: Throwable -> L16
        r103.append(r104);     // Catch: Throwable -> L16
        r103.append(f5.o("SJmRpdj0"));     // Catch: Throwable -> L16
        String r105 = i.f517366e;     // Catch: Throwable -> L16
        r103.append(r105);     // Catch: Throwable -> L16
        StringBuffer r106 = new StringBuffer();     // Catch: Throwable -> L16
        r106.append(r104);     // Catch: Throwable -> L16
        r106.append(r105);     // Catch: Throwable -> L16
        r106.append(f5.o("FQA"));     // Catch: Throwable -> L16
        r106.append(i.f517365d);     // Catch: Throwable -> L16
        String r107 = r106.toString();     // Catch: Throwable -> L16
        byte[] r108 = k.f517415a;     // Catch: Throwable -> L16
        String r109 = b5.a(r107);     // Catch: Throwable -> L16
        r103.append(f5.o("FJnNpZ249"));     // Catch: Throwable -> L16
        r103.append(r109.toUpperCase(Locale.US));     // Catch: Throwable -> L16
        r103.append(f5.o("SJm91dHB1dD1qc29u").concat("\u0000"));     // Catch: Throwable -> L16
        byte[] r110 = g0.a(r103.toString().getBytes(), i.f517363b.getBytes());     // Catch: Throwable -> L16
        String r111 = f5.o("FaW4");     // Catch: Throwable -> L16
        r101 = f.a(r110, r110.length);     // Catch: IOException -> L19 Throwable -> L16
    L12:
        r102.put(r111, r101);     // Catch: Throwable -> L16
        r102.put(f5.o("Sa2V5dA"), i.f517367f);     // Catch: Throwable -> L16
        monitor-exit(r100);
        return r102;
    }

    public final String b(String r100) {
        i r101 = this.f517306a;
        r101.getClass();
        JSONObject r102 = new JSONObject();
        r102.put(f5.o("LdGlk"), r100);     // Catch: Throwable -> L5
        r102.put(f5.o("FZGl1"), "");     // Catch: Throwable -> L5
        r102.put(f5.o("AZGl1Mg"), "");     // Catch: Throwable -> L5
        r102.put(f5.o("EZGl1Mw"), "");     // Catch: Throwable -> L5
    L7:
        String r103 = r102.toString();
        if (TextUtils.isEmpty(r103) == true) goto L48;
        byte[] r104 = k.f517415a;
        SecureRandom r105 = new SecureRandom();
        KeyGenerator r106 = KeyGenerator.getInstance(f5.o("EQUVT"));     // Catch: Throwable -> L13
        r106.init(128, r105);     // Catch: Throwable -> L13
        byte[] r107 = r106.generateKey().getEncoded();     // Catch: Throwable -> L13
        byte[] r108 = f.f517274a;     // Catch: Throwable -> L13
        String r109 = f.a(r107, r107.length);
    L15:
        if (TextUtils.isEmpty(r109) == true) goto L46;
        byte[] r110 = g0.a((r103 + "\u0000").getBytes(), r109.getBytes());
        String r111 = f.a(r110, r110.length);     // Catch: IOException -> L19
    L21:
        if (TextUtils.isEmpty(r111) == true) goto L47;
        PublicKey r112 = j.a(r101.a());     // Catch: Throwable -> L31
        byte[] r113 = r109.getBytes(XML.CHARSET_UTF8);     // Catch: Throwable -> L31
        Cipher r114 = Cipher.getInstance(f5.o("CUlNBL0VDQi9QS0NTMVBhZGRpbmc"));     // Catch: Throwable -> L25
        r114.init(1, r112);     // Catch: Throwable -> L25
        byte[] r115 = r114.doFinal(r113);     // Catch: Throwable -> L25
    L36:
        String r116 = f.a(r115, r115.length);     // Catch: IOException -> L28 Throwable -> L31
    L29:
        return f5.o("Fa2V5PQ") + URLEncoder.encode(r116) + f5.o("SJmRhdGE9") + URLEncoder.encode(r111);
    L28:
        r116 = null;
    L25:
        r115 = null;
    L31:
        th = move-exception;
        th.printStackTrace();
        return null;
    L47:
        return null;
    L19:
        r111 = null;
        goto L21
    L46:
        return null;
    L13:
        r109 = null;
        goto L15
    L48:
        return null;
    L5:
        th = move-exception;
        th.printStackTrace();
        goto L7
    }

    public final String a(Context r100, String r101) {
        JSONObject r102 = new JSONObject(r101);     // Catch: JSONException -> L20
        if (r102.optInt(f5.o("UY29kZQ")) != 1) goto L22;
        String r103 = new JSONObject(r102.optString(f5.o("FZGF0YQ"))).optString(f5.o("FYWRpdQ"));     // Catch: JSONException -> L20
        if (TextUtils.isEmpty(r103) == true) goto L22;
        d r104 = d.a(r100);     // Catch: JSONException -> L20
        Context r105 = r104.f517218a;     // Catch: JSONException -> L20
        if (e.f517239d == null) goto L9;
    L18:
        e r106 = e.f517239d;     // Catch: JSONException -> L20
        r106.f517240a = r104.f517219b;     // Catch: JSONException -> L20
        e.a(r104.f517218a).b(r103, 273);     // Catch: JSONException -> L20
        return r103;
    L9:
        monitor-enter(e.class);     // Catch: JSONException -> L20
    L15:
        th = move-exception;
        throw th;     // Catch: JSONException -> L20
    L11:
        if (e.f517239d != null) goto L13;
        e.f517239d = new e(r105);     // Catch: Throwable -> L15
    L13:
        monitor-exit(e.class);     // Catch: Throwable -> L15
    L22:
        return "";
    L20:
        e = move-exception;
        e.printStackTrace();
        goto L22
    }
}
