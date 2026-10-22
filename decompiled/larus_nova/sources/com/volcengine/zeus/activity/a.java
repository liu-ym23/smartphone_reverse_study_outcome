package com.volcengine.zeus.activity;

import android.app.Activity;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes41.dex */
public final class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f462660a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f462661b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f462662c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Method f462663d;

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (this.f462663d == null) goto L20;
    L22:
        this.f462663d.invoke(this.f462660a, new Object[]{r100});     // Catch: InvocationTargetException -> L13 IllegalAccessException -> L16
        return;
    L16:
        e = move-exception;
        throw new IllegalStateException("Could not execute non-public method for android:onClick", e);
    L13:
        e = move-exception;
        throw new IllegalStateException("Could not execute method for android:onClick", e);
    L20:
        Method r101 = this.f462660a.getClass().getMethod(this.f462661b, new Class[]{View.class});     // Catch: NoSuchMethodException -> L19
        if (r101 == null) goto L10;
        this.f462663d = r101;     // Catch: NoSuchMethodException -> L19
    L10:
        throw new IllegalStateException("Could not find method " + this.f462661b + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.f462662c);
    }

    public a(Activity r100, int r101, String r102) {
        this.f462660a = r100;
        this.f462661b = r102;
        this.f462662c = r101;
    }
}
