package com.bytedance.apm.util;

import android.content.ContentResolver;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import av3.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import xu3.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class MultiProcessSharedPreferences$a implements SharedPreferences.Editor {
    public boolean a;
    public final HashMap<String, Object> b;
    public final /* synthetic */ MultiProcessSharedPreferences c;

    @Override // android.content.SharedPreferences.Editor
    public final void apply() {
        if (this.a == false) goto L5;
    L7:
        Bundle r0 = new Bundle();
        if (this.a == false) goto L10;
        r0.putBoolean("clear", true);
    L10:
        ArrayList<? extends Parcelable> r1 = new ArrayList(this.b.size());
        Iterator<Map.Entry<String, Object>> r2 = this.b.entrySet().iterator();
    L12:
        if (r2.hasNext() == false) goto L14;
        Map.Entry<String, Object> r3 = r2.next();
        r1.add(new SpPair(r3.getKey(), r3.getValue()));
        goto L12
    L14:
        r0.putParcelableArrayList("edit", r1);
        ContentResolver r4 = this.c.b.getContentResolver();     // Catch: Exception -> L17
        MultiProcessSharedPreferences r5 = this.c;     // Catch: Exception -> L17
        r4.call(r5.d, r5.c, "edit", r0);     // Catch: Exception -> L17
        return;
    L17:
        e = move-exception;
        b.c("MultiProcessSharedPref", "apply exception: ", e);
        return;
    L5:
        if (this.b.isEmpty() == false) goto L7;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor clear() {
        this.b.clear();
        this.a = true;
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final boolean commit() {
        apply();
        return true;
    }

    public MultiProcessSharedPreferences$a(MultiProcessSharedPreferences r1) {
        this.c = r1;
        this.a = false;
        this.b = new HashMap();
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor remove(String r3) {
        this.b.put(r3, null);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putBoolean(String r2, boolean r3) {
        this.b.put(r2, Boolean.valueOf(r3));
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putFloat(String r2, float r3) {
        this.b.put(r2, Float.valueOf(r3));
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putInt(String r2, int r3) {
        this.b.put(r2, Integer.valueOf(r3));
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putLong(String r2, long r3) {
        this.b.put(r2, Long.valueOf(r3));
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putString(String r2, String r3) {
        this.b.put(r2, r3);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putStringSet(String r2, Set<String> r3) {
        this.b.put(r2, e.d(r3));
        return this;
    }
}
