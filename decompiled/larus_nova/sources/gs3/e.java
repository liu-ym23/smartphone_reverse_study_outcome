package gs3;

import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.Process;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.apm.core.SpPair;
import com.bytedance.apm.util.k;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.obric.systemopt.SysPowerKit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements SharedPreferences {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f482440d = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Application f482441a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f482442b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Uri f482443c;

    /* JADX INFO: loaded from: classes6.dex */
    public class a implements SharedPreferences.Editor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f482444a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final HashMap<String, Object> f482445b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ e f482446c;

        @Override // android.content.SharedPreferences.Editor
        public final void apply() {
            if (this.f482444a == false) goto L5;
        L7:
            Bundle r100 = new Bundle();
            if (this.f482444a == false) goto L10;
            r100.putBoolean("clear", true);
        L10:
            ArrayList<? extends Parcelable> r101 = new ArrayList(this.f482445b.size());
            Iterator<Map.Entry<String, Object>> r102 = this.f482445b.entrySet().iterator();
        L12:
            if (r102.hasNext() == false) goto L14;
            Map.Entry<String, Object> r103 = r102.next();
            r101.add(new SpPair(r103.getKey(), r103.getValue()));
            goto L12
        L14:
            r100.putParcelableArrayList("edit", r101);
            ContentResolver r104 = this.f482446c.f482441a.getContentResolver();     // Catch: Exception -> L17
            e r105 = this.f482446c;     // Catch: Exception -> L17
            r104.call(r105.f482443c, r105.f482442b, "edit", r100);     // Catch: Exception -> L17
            return;
        L21:
            return;
        L5:
            if (this.f482445b.isEmpty() == false) goto L7;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor clear() {
            this.f482445b.clear();
            this.f482444a = true;
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final boolean commit() {
            apply();
            return true;
        }

        public a(e r100) {
            this.f482446c = r100;
            this.f482444a = false;
            this.f482445b = new HashMap();
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor remove(String r100) {
            this.f482445b.put(r100, null);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putBoolean(String r100, boolean r101) {
            this.f482445b.put(r100, Boolean.valueOf(r101));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putFloat(String r100, float r101) {
            this.f482445b.put(r100, Float.valueOf(r101));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putInt(String r100, int r101) {
            this.f482445b.put(r100, Integer.valueOf(r101));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putLong(String r100, long r101) {
            this.f482445b.put(r100, Long.valueOf(r101));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putString(String r100, String r101) {
            this.f482445b.put(r100, r101);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public final SharedPreferences.Editor putStringSet(String r100, Set<String> r101) {
            this.f482445b.put(r100, k.c(r101));
            return this;
        }
    }

    @Override // android.content.SharedPreferences
    public final Map<String, ?> getAll() {
        ArrayList<SpPair> r100 = a(null, null);
        if (r100 != null) goto L5;
        return null;
    L5:
        HashMap r101 = new HashMap();
        Iterator<SpPair> r102 = r100.iterator();
    L7:
        if (r102.hasNext() == false) goto L9;
        SpPair r103 = r102.next();
        r101.put(r103.f190511a, r103.f190512b);
        goto L7
    L9:
        return r101;
    }

    @Override // android.content.SharedPreferences
    public final void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener r100) {
    }

    @Override // android.content.SharedPreferences
    public final void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener r100) {
    }

    @Override // android.content.SharedPreferences
    public final SharedPreferences.Editor edit() {
        return new a(this);
    }

    @Override // android.content.SharedPreferences
    public final boolean contains(String r100) {
        Bundle r101 = null;
        ContentResolver r102 = this.f482441a.getContentResolver();     // Catch: Exception -> L9
        Uri r103 = this.f482443c;     // Catch: Exception -> L9
        if (r100 == null) goto L6;
        String r104 = this.f482442b + HTTP.URL_DEFAULT + r100;     // Catch: Exception -> L9
    L7:
        r101 = r102.call(r103, r104, "contains", null);     // Catch: Exception -> L9
        goto L10
    L6:
        r104 = this.f482442b;     // Catch: Exception -> L9
    L10:
        if (r101 != null) goto L12;
    L14:
        return false;
    L12:
        if (r101.getBoolean("contains") == false) goto L14;
        return true;
    }

    public e(Application r100, String r101) {
        this.f482441a = r100;
        String r102 = "content://" + r100.getPackageName() + ".apm/sp/" + r101;
        this.f482442b = r102;
        this.f482443c = UriProtector.parse(r102);
    }

    public static SharedPreferences b(Context r100, String r101) {
        int r102 = -1;
        if (f482440d != (-1)) goto L10;
        Bundle r103 = r100.getContentResolver().call(UriProtector.parse("content://" + r100.getPackageName() + ".apm"), "getPid", null, null);     // Catch: Exception -> L22
        if (r103 == null) goto L8;
        r102 = r103.getInt(SysPowerKit.PWR_OVERUSE_PID, -1);     // Catch: Exception -> L22
    L8:
        f482440d = r102;
    L10:
        if (f482440d != Process.myPid()) goto L12;
        boolean r104 = true;
    L13:
        if (r104 == false) goto L17;
        return r100.getSharedPreferences(r101, 4);
    L17:
        if ((r100 instanceof Application) == false) goto L19;
        Application r105 = (Application) r100;
    L21:
        return new e(r105, r101);
    L19:
        r105 = (Application) r100.getApplicationContext();
        goto L21
    L12:
        r104 = false;
        goto L13
    }

    public final ArrayList<SpPair> a(String r100, Object r101) {
        Bundle r102 = new Bundle();
        if (r101 == null) goto L21;
        r102.putParcelable(CloudControlInf.SP, new SpPair(r100, r101));
    L21:
        ContentResolver r103 = this.f482441a.getContentResolver();     // Catch: Exception -> L16
        Uri r104 = this.f482443c;     // Catch: Exception -> L16
        if (r100 == null) goto L9;
        String r105 = this.f482442b + HTTP.URL_DEFAULT + r100;     // Catch: Exception -> L16
    L11:
        if (r101 != null) goto L14;
        r102 = null;
    L14:
        Bundle r106 = r103.call(r104, r105, "query", r102);     // Catch: Exception -> L16
    L17:
        if (r106 != null) goto L19;
        return null;
    L19:
        r106.setClassLoader(e.class.getClassLoader());
        return r106.getParcelableArrayList(CloudControlInf.SP);
    L9:
        r105 = this.f482442b;     // Catch: Exception -> L16
    L16:
        r106 = null;
        goto L17
    }

    @Override // android.content.SharedPreferences
    public final boolean getBoolean(String r100, boolean r101) {
        ArrayList<SpPair> r102 = a(r100, String.valueOf(r101));
        if (r102 != null) goto L5;
        return r101;
    L5:
        Object r103 = ((SpPair) ListProtector.get(r102, 0)).f190512b;
        if ((r103 instanceof Boolean) == false) goto L10;
        return ((Boolean) r103).booleanValue();
    L10:
        if ((r103 instanceof String) == true) goto L12;
        return r101;
    L12:
        return Boolean.valueOf((String) r103).booleanValue();
    }

    @Override // android.content.SharedPreferences
    public final float getFloat(String r100, float r101) {
        ArrayList<SpPair> r102 = a(r100, String.valueOf(r101));
        if (r102 != null) goto L5;
        return r101;
    L5:
        Object r103 = ((SpPair) ListProtector.get(r102, 0)).f190512b;
        if ((r103 instanceof Float) == false) goto L10;
        return ((Float) r103).floatValue();
    L10:
        if ((r103 instanceof String) == true) goto L12;
        return r101;
    L12:
        return CastFloatProtector.valueOf((String) r103).floatValue();
    }

    @Override // android.content.SharedPreferences
    public final int getInt(String r100, int r101) {
        ArrayList<SpPair> r102 = a(r100, String.valueOf(r101));
        if (r102 != null) goto L5;
        return r101;
    L5:
        Object r103 = ((SpPair) ListProtector.get(r102, 0)).f190512b;
        if ((r103 instanceof Integer) == false) goto L10;
        return ((Integer) r103).intValue();
    L10:
        if ((r103 instanceof String) == true) goto L12;
        return r101;
    L12:
        return Integer.decode((String) r103).intValue();
    }

    @Override // android.content.SharedPreferences
    public final long getLong(String r100, long r101) {
        ArrayList<SpPair> r102 = a(r100, String.valueOf(r101));
        if (r102 != null) goto L5;
        return r101;
    L5:
        Object r103 = ((SpPair) ListProtector.get(r102, 0)).f190512b;
        if ((r103 instanceof Long) == false) goto L10;
        return ((Long) r103).longValue();
    L10:
        if ((r103 instanceof String) == true) goto L12;
        return r101;
    L12:
        return Long.decode((String) r103).longValue();
    }

    @Override // android.content.SharedPreferences
    public final String getString(String r100, String r101) {
        ArrayList<SpPair> r102 = a(r100, r101);
        if (r102 != null) goto L7;
        return null;
    L7:
        return (String) ((SpPair) ListProtector.get(r102, 0)).f190512b;
    }

    @Override // android.content.SharedPreferences
    public final Set<String> getStringSet(String r100, Set<String> r101) {
        ArrayList<SpPair> r102 = a(r100, r101);
        if (r102 != null) goto L6;
        return null;
    L6:
        if (((SpPair) ListProtector.get(r102, 0)).f190512b != null) goto L8;
        return null;
    L8:
        String[] r103 = (String[]) ((SpPair) ListProtector.get(r102, 0)).f190512b;
        HashSet r104 = new HashSet(r103.length);
        r104.addAll(Arrays.asList(r103));
        return r104;
    }
}
