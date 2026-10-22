package n4a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.loc.av;
import com.loc.aw;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes32.dex */
public final class w {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<Class<? extends v>, v> f517839d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x f517840a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SQLiteDatabase f517841b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f517842c;

    static {
        f517839d = new HashMap();
    }

    public w(Context r100, v r101) {
        Context r102 = r100.getApplicationContext();     // Catch: Throwable -> L7
        r101.a();     // Catch: Throwable -> L7
        this.f517840a = new x(r102, "alsn20170807.db", r101);     // Catch: Throwable -> L7
    L9:
        this.f517842c = r101;
        return;
    L7:
        th = move-exception;
        th.printStackTrace();
        goto L9
    }

    public static synchronized v d(Class<? extends v> r100) throws IllegalAccessException, InstantiationException {
        monitor-enter(w.class);
        Map<Class<? extends v>, v> r101 = f517839d;     // Catch: Throwable -> L10
        if (((HashMap) r101).get(r100) != null) goto L7;
        HashMap r102 = (HashMap) r101;     // Catch: Throwable -> L10
        r102.put(r100, r100.newInstance());     // Catch: Throwable -> L10
    L7:
        v r103 = (v) ((HashMap) r101).get(r100);     // Catch: Throwable -> L10
        monitor-exit(w.class);
        return r103;
    L10:
        th = move-exception;
        throw th;
    }

    public static <T> av g(Class<T> r100) {
        Annotation r101 = r100.getAnnotation(av.class);
        if (r101 == null) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L10;
        return null;
    L10:
        return (av) r101;
    L5:
        r102 = false;
        goto L6
    }

    public final SQLiteDatabase f() {
        SQLiteDatabase r100 = this.f517841b;     // Catch: Throwable -> L11
        if (r100 != null) goto L5;
    L6:
        SQLiteDatabase r101 = this.f517841b;     // Catch: Throwable -> L11
        if (r101 == null) goto L9;
        r101.close();     // Catch: Throwable -> L11
    L9:
        this.f517841b = this.f517840a.getWritableDatabase();     // Catch: Throwable -> L11
    L14:
        return this.f517841b;
    L5:
        if (r100.isReadOnly() == false) goto L14;
    L11:
        th = move-exception;
        n.a(th, "dbs", "gwd");
        goto L14
    }

    public final List c(Class r110) {
        v r100 = this.f517842c;
        monitor-enter(r100);
        ArrayList r101 = new ArrayList();     // Catch: Throwable -> L84
        av r111 = g(r110);     // Catch: Throwable -> L84
        if (r111 != null) goto L7;
        String r102 = null;
    L8:
        SQLiteDatabase r103 = this.f517841b;     // Catch: Throwable -> L84
        if (r103 != null) goto L17;
        if (r103 == null) goto L91;
    L15:
        this.f517841b = this.f517841b;     // Catch: Throwable -> L84
        goto L17
    L91:
        this.f517841b = this.f517840a.getReadableDatabase();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        n.a(th, "dbs", "grd");     // Catch: Throwable -> L84
    L17:
        if (this.f517841b != null) goto L19;
    L82:
        monitor-exit(r100);     // Catch: Throwable -> L84
        return r101;
    L19:
        if (TextUtils.isEmpty(r102) == true) goto L82;
        Cursor r104 = this.f517841b.query(r102, null, "_id=1", null, null, null, null);     // Catch: Throwable -> L53
        if (r104 != null) goto L37;
        this.f517841b.close();     // Catch: Throwable -> L51
        this.f517841b = null;     // Catch: Throwable -> L51
        if (r104 != null) goto L100;
    L94:
        SQLiteDatabase r112 = this.f517841b;     // Catch: Throwable -> L32
        if (r112 == null) goto L82;
        r112.close();     // Catch: Throwable -> L32
        this.f517841b = null;     // Catch: Throwable -> L32
    L32:
        th = th;
        String r105 = "dbs";
        String r106 = "sld";
    L34:
        n.a(th, r105, r106);     // Catch: Throwable -> L84
        goto L82
    L100:
        r104.close();     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        n.a(th, "dbs", "sld");     // Catch: Throwable -> L84
    L37:
        if (r104.moveToNext() == false) goto L89;
        r101.add(b(r104, r110, r111));     // Catch: Throwable -> L51
        goto L37
    L89:
        r104.close();     // Catch: Throwable -> L42
    L102:
        SQLiteDatabase r113 = this.f517841b;     // Catch: Throwable -> L48
        if (r113 == null) goto L82;
        r113.close();     // Catch: Throwable -> L48
        this.f517841b = null;     // Catch: Throwable -> L48
    L48:
        th = th;
    L49:
        r105 = "dbs";
        r106 = "sld";
    L42:
        th = move-exception;
        n.a(th, "dbs", "sld");     // Catch: Throwable -> L84
    L51:
        th = th;
    L87:
        n.a(th, "dbs", "sld");     // Catch: Throwable -> L69
        if (r104 == null) goto L109;
        r104.close();     // Catch: Throwable -> L59
    L59:
        th = move-exception;
        n.a(th, "dbs", "sld");     // Catch: Throwable -> L84
    L109:
        SQLiteDatabase r114 = this.f517841b;     // Catch: Throwable -> L65
        if (r114 == null) goto L82;
        r114.close();     // Catch: Throwable -> L65
        this.f517841b = null;     // Catch: Throwable -> L65
    L65:
        th = th;
        goto L49
    L69:
        th = move-exception;
        if (r104 == null) goto L105;
        r104.close();     // Catch: Throwable -> L73
    L73:
        th = move-exception;
        n.a(th, "dbs", "sld");     // Catch: Throwable -> L84
    L105:
        SQLiteDatabase r107 = this.f517841b;     // Catch: Throwable -> L79
        if (r107 == null) goto L111;
        r107.close();     // Catch: Throwable -> L79
        this.f517841b = null;     // Catch: Throwable -> L79
    L112:
        throw th;     // Catch: Throwable -> L84
    L111:
        throw th;     // Catch: Throwable -> L84
    L79:
        th = move-exception;
        n.a(th, "dbs", "sld");     // Catch: Throwable -> L84
        throw th;     // Catch: Throwable -> L84
    L53:
        th = th;
        r104 = null;
        goto L87
    L7:
        r102 = r111.a();     // Catch: Throwable -> L84
    L84:
        th = move-exception;
        throw th;
    }

    public final void e(v3 r100) {
        v r101 = this.f517842c;
        monitor-enter(r101);
        SQLiteDatabase r102 = f();     // Catch: Throwable -> L31
        this.f517841b = r102;     // Catch: Throwable -> L31
        if (r102 != null) goto L37;
    L24:
        monitor-exit(r101);     // Catch: Throwable -> L31
        return;
    L37:
        av r103 = g(v3.class);     // Catch: Throwable -> L19
        if (r103 != null) goto L11;
        String r104 = null;
    L13:
        if (TextUtils.isEmpty(r104) == true) goto L16;
        r102.insert(r104, null, a(r100, r103));     // Catch: Throwable -> L19
    L16:
        SQLiteDatabase r105 = this.f517841b;     // Catch: Throwable -> L31
        if (r105 == null) goto L24;
    L23:
        r105.close();     // Catch: Throwable -> L31
        this.f517841b = null;     // Catch: Throwable -> L31
        goto L24
    L11:
        r104 = r103.a();     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        n.a(th, "dbs", "itd");     // Catch: Throwable -> L26
        r105 = this.f517841b;     // Catch: Throwable -> L31
        if (r105 == null) goto L24;
    L26:
        th = move-exception;
        SQLiteDatabase r106 = this.f517841b;     // Catch: Throwable -> L31
        if (r106 == null) goto L30;
        r106.close();     // Catch: Throwable -> L31
        this.f517841b = null;     // Catch: Throwable -> L31
    L30:
        throw th;     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        throw th;
    }

    public final void h(v3 r100) {
        v r101 = this.f517842c;
        monitor-enter(r101);
        av r102 = g(v3.class);     // Catch: Throwable -> L25
        if (r102 != null) goto L7;
        String r103 = null;
    L9:
        if (TextUtils.isEmpty(r103) == true) goto L23;
        ContentValues r104 = a(r100, r102);     // Catch: Throwable -> L25
        SQLiteDatabase r105 = f();     // Catch: Throwable -> L25
        this.f517841b = r105;     // Catch: Throwable -> L25
        if (r105 == null) goto L23;
        r105.update(r103, r104, "_id=1", null);     // Catch: Throwable -> L18
        SQLiteDatabase r106 = this.f517841b;     // Catch: Throwable -> L25
        if (r106 == null) goto L23;
    L22:
        r106.close();     // Catch: Throwable -> L25
        this.f517841b = null;     // Catch: Throwable -> L25
        goto L23
    L18:
        th = move-exception;
        n.a(th, "dbs", "udd");     // Catch: Throwable -> L27
        r106 = this.f517841b;     // Catch: Throwable -> L25
        if (r106 == null) goto L23;
    L27:
        th = move-exception;
        SQLiteDatabase r107 = this.f517841b;     // Catch: Throwable -> L25
        if (r107 == null) goto L31;
        r107.close();     // Catch: Throwable -> L25
        this.f517841b = null;     // Catch: Throwable -> L25
    L31:
        throw th;     // Catch: Throwable -> L25
    L23:
        monitor-exit(r101);     // Catch: Throwable -> L25
        return;
    L7:
        r103 = r102.a();     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        throw th;
    }

    public static ContentValues a(v3 r100, av r101) {
        ContentValues r102 = new ContentValues();
        if (r101.b() == false) goto L5;
        Field[] r103 = v3.class.getSuperclass().getDeclaredFields();
    L6:
        int r104 = r103.length;
        int r105 = 0;
    L7:
        if (r105 >= r104) goto L25;
        Field r106 = r103[r105];
        r106.setAccessible(true);
        Annotation r107 = r106.getAnnotation(aw.class);
        if (r107 == null) goto L24;
        aw r108 = (aw) r107;
        switch(r108.b()) {
            case 1: goto L20;
            case 2: goto L19;
            case 3: goto L18;
            case 4: goto L17;
            case 5: goto L16;
            case 6: goto L15;
            case 7: goto L26;
            default: goto L24;
        };
    L15:
        String r109 = (String) r106.get(r100);     // Catch: IllegalAccessException -> L22
        r102.put(r108.a(), r109);     // Catch: IllegalAccessException -> L22
        goto L24
    L16:
        long r110 = r106.getLong(r100);     // Catch: IllegalAccessException -> L22
        r102.put(r108.a(), Long.valueOf(r110));     // Catch: IllegalAccessException -> L22
        goto L24
    L17:
        double r111 = r106.getDouble(r100);     // Catch: IllegalAccessException -> L22
        r102.put(r108.a(), Double.valueOf(r111));     // Catch: IllegalAccessException -> L22
        goto L24
    L18:
        float r112 = r106.getFloat(r100);     // Catch: IllegalAccessException -> L22
        r102.put(r108.a(), Float.valueOf(r112));     // Catch: IllegalAccessException -> L22
        goto L24
    L19:
        int r113 = r106.getInt(r100);     // Catch: IllegalAccessException -> L22
        r102.put(r108.a(), Integer.valueOf(r113));     // Catch: IllegalAccessException -> L22
        goto L24
    L20:
        short r114 = r106.getShort(r100);     // Catch: IllegalAccessException -> L22
        r102.put(r108.a(), Short.valueOf(r114));     // Catch: IllegalAccessException -> L22
        goto L24
    L26:
        byte[] r115 = (byte[]) r106.get(r100);     // Catch: IllegalAccessException -> L22
        r102.put(r108.a(), r115);     // Catch: IllegalAccessException -> L22
    L22:
        e = move-exception;
        e.printStackTrace();
    L24:
        r105 = r105 + 1;
        goto L7
    L25:
        return r102;
    L5:
        r103 = v3.class.getDeclaredFields();
        goto L6
    }

    public static <T> T b(Cursor r100, Class<T> r101, av r102) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        if (r102.b() == false) goto L5;
        Field[] r103 = r101.getSuperclass().getDeclaredFields();
    L6:
        int r104 = 0;
        Constructor<T> r105 = r101.getDeclaredConstructor(new Class[0]);
        r105.setAccessible(true);
        T r106 = r105.newInstance(new Object[0]);
        int r107 = r103.length;
    L7:
        if (r104 >= r107) goto L22;
        Field r108 = r103[r104];
        r108.setAccessible(true);
        Annotation r109 = r108.getAnnotation(aw.class);
        if (r109 == null) goto L21;
        aw r110 = (aw) r109;
        int r111 = r110.b();
        int r112 = r100.getColumnIndex(r110.a());
        switch(r111) {
            case 1: goto L19;
            case 2: goto L18;
            case 3: goto L17;
            case 4: goto L16;
            case 5: goto L15;
            case 6: goto L14;
            case 7: goto L13;
            default: goto L21;
        };
    L13:
        r108.set(r106, r100.getBlob(r112));
        goto L21
    L14:
        Object r113 = r100.getString(r112);
    L20:
        r108.set(r106, r113);
        goto L21
    L15:
        r113 = Long.valueOf(r100.getLong(r112));
        goto L20
    L16:
        r113 = Double.valueOf(r100.getDouble(r112));
        goto L20
    L17:
        r113 = Float.valueOf(r100.getFloat(r112));
        goto L20
    L18:
        r113 = Integer.valueOf(r100.getInt(r112));
        goto L20
    L19:
        r113 = Short.valueOf(r100.getShort(r112));
    L21:
        r104 = r104 + 1;
        goto L7
    L22:
        return r106;
    L5:
        r103 = r101.getDeclaredFields();
        goto L6
    }
}
