package eu8;

import android.content.Context;
import android.content.SharedPreferences;
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
public final class h extends eu8.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f474107c;

    public static class a extends eu8.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f474108c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List<String> f474109d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Object f474110e;

        @Override // eu8.a
        public final String a() {
            Iterator<String> r100 = this.f474109d.iterator();
            if (r100.hasNext() == false) goto L29;
            SharedPreferences.Editor r101 = this.f474096a.getSharedPreferences(r100.next(), 0).edit();
            Object r102 = this.f474110e;
            if (r102 != null) goto L9;
            r101.remove(this.f474108c);
            r101.apply();
            return String.format("remove key %s successfully", new Object[]{this.f474108c});
        L9:
            if ((r102 instanceof Integer) == false) goto L12;
            r101.putInt(this.f474108c, ((Integer) r102).intValue());
        L26:
            r101.apply();
            return String.format("put key %s successfully", new Object[]{this.f474108c});
        L12:
            if ((r102 instanceof Float) == false) goto L15;
            r101.putFloat(this.f474108c, ((Float) r102).floatValue());
            goto L26
        L15:
            if ((r102 instanceof String) == false) goto L18;
            r101.putString(this.f474108c, (String) r102);
            goto L26
        L18:
            if ((r102 instanceof Long) == false) goto L21;
            r101.putLong(this.f474108c, ((Long) r102).longValue());
            goto L26
        L21:
            if ((r102 instanceof Boolean) == false) goto L24;
            r101.putBoolean(this.f474108c, ((Boolean) r102).booleanValue());
            goto L26
        L24:
            if ((r102 instanceof Set) == false) goto L26;
            r101.putStringSet(this.f474108c, (Set) r102);
            goto L26
        L29:
            return String.format("remove key %s failed", new Object[]{this.f474108c});
        }

        public a(Context r100, JsonElement r101, List<String> r102, String r103, Object r104) {
            super(r100, r101);
            this.f474108c = r103;
            this.f474109d = r102;
            this.f474110e = r104;
        }
    }

    @Override // eu8.a
    public final String a() {
        return (String) this.f474107c.execute();
    }

    public static eu8.a c(Context r100, JsonObject r110) {
        String r101 = r110.get("cmd").getAsString();
        if (r101.startsWith("delete sp") == false) goto L38;
        if (r110.has("key") == true) goto L28;
        if (r110.has("repo") == false) goto L28;
        String r102 = String.format("%s.xml", new Object[]{r110.get("repo").getAsString()});
        String r103 = new PolarisFileWrapper(r100.getFilesDir().getParent(), "shared_prefs").getAbsolutePath();
        List<File> r104 = lu8.b.b(r103, true);
        ArrayList r105 = new ArrayList();
        if (r104 == null) goto L26;
        Iterator r106 = ((ArrayList) r104).iterator();     // Catch: Exception -> L23
    L12:
        if (r106.hasNext() == false) goto L26;
        File r107 = (File) r106.next();     // Catch: Exception -> L23
        if (r107 == null) goto L12;
        if (r107.exists() == false) goto L12;
        if (r107.isFile() == false) goto L12;
        String r108 = r107.getAbsolutePath().substring((r107.getAbsolutePath().indexOf(r103) + r103.length()) + 1);     // Catch: Exception -> L23
        nu8.a.a("SpOpExecutor", "subFilePath is " + r108 + " params is " + r102);     // Catch: Exception -> L23
        if (r108.matches(eu8.a.b(r102)) == false) goto L12;
        nu8.a.b("SpOpExecutor", "delete sp match success");     // Catch: Exception -> L23
        r105.add(new PolarisFileWrapper(r103, r108));     // Catch: Exception -> L23
    L23:
        e = move-exception;
        nu8.a.b("SpOpExecutor", "getMatchedFiles failed:" + e);
    L26:
        return new h(r100, r110, new b(r100, r110, r105));
    L28:
        if (r110.has("key") == false) goto L85;
        if (r110.has("repo") == false) goto L85;
        if (r110.has("valueType") == false) goto L36;
        if (r110.has("value") == true) goto L85;
    L36:
        return new h(r100, r110, new a(r100, r110, d(r100, String.format("%s.xml", new Object[]{r110.get("repo").getAsString()})), r110.get("key").getAsString(), null));
    L85:
        return new f(r100, String.format("SpOpExecutor unsupport cmd %s", new Object[]{r101}));
    L38:
        if (r101.startsWith("set sp") == false) goto L85;
        String r109 = r110.get("repo").getAsString();
        String r111 = r110.get("key").getAsString();
        JsonElement r112 = r110.get("value");
        if (r112 != null) goto L42;
    L80:
        Object r113 = null;
    L81:
        Object r114 = r113;
    L83:
        return new h(r100, r110, new a(r100, r110, d(r100, String.format("%s.xml", new Object[]{r109})), r111, r114));
    L42:
        if (r112.isJsonPrimitive() == false) goto L74;
        String r115 = r110.get("valueType").getAsString();
        r115.getClass();
        byte r116 = -1;
        switch(r115.hashCode()) {
            case -891985903: goto L63;
            case 104431: goto L59;
            case 3327612: goto L55;
            case 64711720: goto L51;
            case 97526364: goto L47;
            default: goto L66;
        };
    L66:
        switch(r116) {
            case 0: goto L72;
            case 1: goto L71;
            case 2: goto L70;
            case 3: goto L69;
            case 4: goto L68;
            default: goto L80;
        };
    L68:
        r113 = Float.valueOf(r112.getAsFloat());
        goto L81
    L69:
        r113 = Boolean.valueOf(r112.getAsBoolean());
        goto L81
    L70:
        r113 = Long.valueOf(r112.getAsLong());
        goto L81
    L71:
        r113 = Integer.valueOf(r112.getAsInt());
        goto L81
    L72:
        r113 = r112.getAsString();
        goto L81
    L47:
        if (r115.equals("float") == false) goto L66;
        r116 = 4;
        goto L66
    L51:
        if (r115.equals("boolean") == false) goto L66;
        r116 = 3;
        goto L66
    L55:
        if (r115.equals("long") == false) goto L66;
        r116 = 2;
        goto L66
    L59:
        if (r115.equals("int") == false) goto L66;
        r116 = 1;
        goto L66
    L63:
        if (r115.equals("string") == false) goto L66;
        r116 = 0;
        goto L66
    L74:
        if (r112.isJsonArray() == false) goto L80;
        HashSet r117 = new HashSet();
        Iterator<JsonElement> r118 = r112.getAsJsonArray().iterator();
    L77:
        if (r118.hasNext() == false) goto L79;
        r117.add(r118.next().getAsString());
        goto L77
    L79:
        r114 = r117;
        goto L83
    }

    public static ArrayList<String> d(Context r100, String r101) {
        String r102 = new PolarisFileWrapper(r100.getFilesDir().getParent(), "shared_prefs").getAbsolutePath();
        List<File> r103 = lu8.b.b(r102, true);
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
        if (r106.isFile() == false) goto L6;
        String r107 = r106.getAbsolutePath().substring((r106.getAbsolutePath().indexOf(r102) + r102.length()) + 1);     // Catch: Exception -> L17
        nu8.a.a("SpOpExecutor", "subFilePath is " + r107 + " params is " + r101);     // Catch: Exception -> L17
        if (r107.matches(eu8.a.b(r101)) == false) goto L6;
        nu8.a.b("SpOpExecutor", "match sp files success: " + r107);     // Catch: Exception -> L17
        r104.add(r107.replaceAll("\\.xml", ""));     // Catch: Exception -> L17
    L17:
        e = move-exception;
        nu8.a.b("SpOpExecutor", "getMatchedSps failed: " + e);
        goto L19
    }

    public h(Context r100, JsonElement r101, eu8.a r102) {
        super(r100, r101);
        this.f474107c = r102;
    }
}
