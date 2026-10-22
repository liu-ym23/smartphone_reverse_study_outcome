package mlc;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f514402a;

    @Override // mlc.c
    public final void clear() {
        SharedPreferences.Editor r100 = this.f514402a.edit();
        if (r100 == null) goto L11;
        Iterator<String> r101 = this.f514402a.getAll().keySet().iterator();
    L6:
        if (r101.hasNext() == false) goto L8;
        r100.remove(r101.next());
        goto L6
    L8:
        r100.apply();
        return;
    }

    public a(Context r100, String r101) {
        this.f514402a = r100.getApplicationContext().getSharedPreferences(r101, 0);
    }

    @Override // mlc.c
    public final String getString(String r100, String r101) {
        String r102 = this.f514402a.getString(r100, r101);
        if (r102 != null) goto L5;
        return r101;
    L5:
        return r102;
    }

    @Override // mlc.c
    public final void putString(String r100, String r101) {
        SharedPreferences.Editor r102 = this.f514402a.edit();
        if (r102 == null) goto L8;
        SharedPreferences.Editor r103 = r102.putString(r100, r101);
        if (r103 == null) goto L9;
        r103.apply();
        return;
    L9:
        return;
    }
}
