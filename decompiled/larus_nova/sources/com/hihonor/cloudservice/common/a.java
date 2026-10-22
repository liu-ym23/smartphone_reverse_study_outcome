package com.hihonor.cloudservice.common;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import exc.e;
import hxc.d;
import hxc.d.a;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes23.dex */
public class a<TOption extends d.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TOption f276474a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f276475b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WeakReference<Activity> f276476c;

    public Activity getActivity() {
        WeakReference<Activity> r100 = this.f276476c;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.get();
    }

    public Context getContext() {
        return this.f276475b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(FragmentActivity r100, d.a r101) {
        this.f276475b = r100.getApplicationContext();
        this.f276476c = new WeakReference(r100);
        this.f276475b = r100.getApplicationContext();
        this.f276474a = r101;
        e.a(r100);
        monitor-enter(mw7.a.class);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (mw7.a.f515971b != null) goto L7;
        mw7.a.f515971b = new mw7.a();     // Catch: Throwable -> L11
    L7:
        mw7.a r102 = mw7.a.f515971b;     // Catch: Throwable -> L11
        monitor-exit(mw7.a.class);
        r102.getClass();
        r102.f515972a = new WeakReference(r100);
    }
}
