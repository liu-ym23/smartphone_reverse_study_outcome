package jx4;

import android.app.Activity;
import android.preference.PreferenceScreen;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class a {
    public final PreferenceScreen a;
    public final WeakReference<Activity> b;

    public a(PreferenceScreen r1, Activity r2) {
        this.a = r1;
        this.b = new WeakReference(r2);
    }
}
