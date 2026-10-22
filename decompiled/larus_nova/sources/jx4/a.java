package jx4;

import android.app.Activity;
import android.preference.PreferenceScreen;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes16.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PreferenceScreen f500814a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakReference<Activity> f500815b;

    public a(PreferenceScreen r100, Activity r101) {
        this.f500814a = r100;
        this.f500815b = new WeakReference(r101);
    }
}
