package eu8;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.keva.Keva;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes26.dex */
public final class e extends eu8.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f474099c;

    public static class a extends eu8.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f474100c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List<String> f474101d;

        @Override // eu8.a
        public final String a() {
            List<String> r100 = this.f474101d;
            if (r100 != null) goto L5;
            return "invalid keva del op";
        L5:
            if (r100.size() == 0) goto L30;
            Iterator<String> r101 = this.f474101d.iterator();
        L8:
            if (r101.hasNext() == false) goto L31;
            String r102 = r101.next();
            if (TextUtils.isEmpty(r102) == true) goto L16;
            if (TextUtils.isEmpty(this.f474100c) == false) goto L16;
            Keva.getRepo(r102, 1).clear();
            return String.format("del keva repo %s success", new Object[]{r102});
        L16:
            if (TextUtils.isEmpty(r102) == true) goto L8;
            if (TextUtils.isEmpty(this.f474100c) == true) goto L8;
            Keva.getRepo(r102, 1).erase(this.f474100c);
            return String.format("del keva key repo %s key %s success", new Object[]{r102, this.f474100c});
        L31:
            return "invalid keva del op";
        L30:
            return "invalid keva del op";
        }

        public a(Context r100, JsonElement r101, List<String> r102, String r103) {
            super(r100, r101);
            this.f474100c = r103;
            this.f474101d = r102;
        }
    }

    public static class b extends eu8.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f474102c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List<String> f474103d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Object f474104e;

        @Override // eu8.a
        public final String a() {
            List<String> r100 = this.f474103d;
            if (r100 == null) goto L32;
            if (r100.size() == 0) goto L32;
            Iterator<String> r101 = this.f474103d.iterator();
        L8:
            if (r101.hasNext() == false) goto L30;
            Keva r102 = Keva.getRepo(r101.next(), 1);
            Object r103 = this.f474104e;
            if (r103 == null) goto L8;
            if ((r103 instanceof Integer) == true) goto L13;
            if ((r103 instanceof Float) == true) goto L16;
            if ((r103 instanceof String) == true) goto L19;
            if ((r103 instanceof Long) == true) goto L22;
            if ((r103 instanceof Boolean) == true) goto L25;
            if ((r103 instanceof Set) == false) goto L8;
            r102.storeStringSet(this.f474102c, (Set) r103);
            goto L8
        L25:
            r102.storeBoolean(this.f474102c, ((Boolean) r103).booleanValue());
            goto L8
        L22:
            r102.storeLong(this.f474102c, ((Long) r103).longValue());
            goto L8
        L19:
            r102.storeString(this.f474102c, (String) r103);
            goto L8
        L16:
            r102.storeFloat(this.f474102c, ((Float) r103).floatValue());
            goto L8
        L13:
            r102.storeInt(this.f474102c, ((Integer) r103).intValue());
            goto L8
        L30:
            return String.format("put key %s successfully", new Object[]{this.f474102c});
        L32:
            return String.format("put key %s failed, NO repo MATCHED ", new Object[]{this.f474102c});
        }

        public b(Context r100, JsonElement r101, List<String> r102, String r103, Object r104) {
            super(r100, r101);
            this.f474102c = r103;
            this.f474103d = r102;
            this.f474104e = r104;
        }
    }

    @Override // eu8.a
    public final String a() {
        return (String) this.f474099c.execute();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.util.HashSet] */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.Long] */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.lang.Float] */
    /* JADX WARN: Type inference failed for: r3v9 */
    public static eu8.a c(Context r110, JsonObject r111) {
        String r100 = r111.get("cmd").getAsString();
        ?? r101 = 0;
        r101 = 0;
        r101 = 0;
        byte r102 = 0;
        if (r100.startsWith("delete keva") == false) goto L21;
        if (r111.has("key") == true) goto L11;
        if (r111.has("repo") == false) goto L11;
        return new e(r110, r111, new a(r110, r111, d(r110, r111.get("repo").getAsString()), null));
    L11:
        if (r111.has("key") == false) goto L68;
        if (r111.has("repo") == false) goto L68;
        if (r111.has("valueType") == true) goto L17;
    L18:
        String r103 = r111.get("repo").getAsString();
        return new e(r110, r111, new a(r110, r111, d(r110, r103), r111.get("key").getAsString()));
    L17:
        if (r111.has("value") == false) goto L18;
    L68:
        return new f(r110, String.format("SpOpExecutor unsupport cmd %s", new Object[]{r100}));
    L21:
        if (r100.startsWith("set keva") == false) goto L68;
        String r104 = r111.get("repo").getAsString();
        String r112 = r111.get("key").getAsString();
        JsonElement r105 = r111.get("value");
        if (r105 == null) goto L66;
        if (r105.isJsonPrimitive() == false) goto L60;
        String r106 = r111.get("valueType").getAsString();
        r106.getClass();
        switch(r106.hashCode()) {
            case -891985903: goto L46;
            case 104431: goto L42;
            case 3327612: goto L38;
            case 64711720: goto L34;
            case 97526364: goto L30;
            default: goto L47;
        };
    L47:
        r102 = -1;
    L48:
        if (r102 == 0) goto L58;
        if (r102 == 1) goto L57;
        if (r102 == 2) goto L56;
        if (r102 == 3) goto L55;
        if (r102 != 4) goto L66;
        r101 = Float.valueOf(r105.getAsFloat());
        goto L66
    L55:
        r101 = Boolean.valueOf(r105.getAsBoolean());
        goto L66
    L56:
        r101 = Long.valueOf(r105.getAsLong());
        goto L66
    L57:
        r101 = Integer.valueOf(r105.getAsInt());
        goto L66
    L58:
        r101 = r105.getAsString();
        goto L66
    L30:
        if (r106.equals("float") == false) goto L47;
        r102 = 4;
        goto L48
    L34:
        if (r106.equals("boolean") == false) goto L47;
        r102 = 3;
        goto L48
    L38:
        if (r106.equals("long") == false) goto L47;
        r102 = 2;
        goto L48
    L42:
        if (r106.equals("int") == false) goto L47;
        r102 = 1;
        goto L48
    L46:
        if (r106.equals("string") == true) goto L48;
    L60:
        if (r105.isJsonArray() == false) goto L66;
        r101 = new HashSet();
        Iterator<JsonElement> r107 = r105.getAsJsonArray().iterator();
    L63:
        if (r107.hasNext() == false) goto L66;
        r101.add(r107.next().getAsString());
    L66:
        return new e(r110, r111, new b(r110, r111, d(r110, r104), r112, r101));
    }

    public static ArrayList<String> d(Context r100, String r101) {
        String r102 = new PolarisFileWrapper(r100.getFilesDir(), "keva/repo").getAbsolutePath();
        List<File> r103 = lu8.b.b(r102, false);
        ArrayList<String> r104 = new ArrayList();
        if (r103 != null) goto L20;
    L19:
        return r104;
    L20:
        Iterator r105 = ((ArrayList) r103).iterator();     // Catch: Exception -> L17
    L6:
        if (r105.hasNext() == false) goto L19;
        File r106 = (File) r105.next();     // Catch: Exception -> L17
        if (r106 == null) goto L6;
        if (r106.exists() == false) goto L6;
        if (r106.isDirectory() == false) goto L6;
        String r107 = r106.getAbsolutePath().substring((r106.getAbsolutePath().indexOf(r102) + r102.length()) + 1);     // Catch: Exception -> L17
        nu8.a.a("KevaOpExecutor", "subFilePath is " + r107 + " params is " + r101);     // Catch: Exception -> L17
        if (r107.matches(eu8.a.b(r101)) == false) goto L6;
        nu8.a.h("KevaOpExecutor", "match keva files success: " + r107);     // Catch: Exception -> L17
        r104.add(r107);     // Catch: Exception -> L17
    L17:
        e = move-exception;
        nu8.a.b("KevaOpExecutor", "getMatchedKevas failed: " + e);
        goto L19
    }

    public e(Context r100, JsonElement r101, eu8.a r102) {
        super(r100, r101);
        this.f474099c = r102;
    }
}
