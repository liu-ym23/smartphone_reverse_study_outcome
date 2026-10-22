package com.lynx.clay.embedding.engine.plugins.platformview;

import android.content.Context;
import android.view.View;
import java.util.List;
import java.util.Map;
import n5a.h;
import n5a.j;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f380855a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f380856b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public j f380857c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<String> f380858d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f380859e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public InternalPlatformViewRegistry.ViewDrawType f380860f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LynxUIClayUIBridge$CompositionPreference f380861g;

    public abstract View a(Context r100);

    public abstract boolean d(String r100, JSONObject r101, n5a.a r102);

    public void g() {
    }

    public void h() {
    }

    public void i(int r100, int r101, int r102, int r103) {
    }

    public void j() {
    }

    public void k() {
    }

    public void l() {
    }

    public void m() {
    }

    public abstract void n(String r100, Object r101);

    public final View b() {
        if (this.f380856b != null) goto L6;
        this.f380856b = a(this.f380859e);
    L6:
        return this.f380856b;
    }

    public final void e() {
        this.f380857c.markLayoutDirty();
    }

    public final boolean c(String r100) {
        List<String> r101 = this.f380858d;
        if (r101 != null) goto L5;
        return false;
    L5:
        return r101.contains(r100);
    }

    public void o(j r100) {
        this.f380857c = r100;
    }

    public void p(List<String> r100) {
        this.f380858d = r100;
    }

    public final void q(String r100, Map<String, Object> r101) {
        if (this.f380857c != null) goto L5;
        return;
    L5:
        if (c(r100) == false) goto L9;
        this.f380857c.sendEvent(r100, r101);
        return;
    }

    public a(Context r100, int r101, String r102) {
        this.f380860f = InternalPlatformViewRegistry.ViewDrawType.DRAWABLE;
        this.f380861g = LynxUIClayUIBridge$CompositionPreference.AUTO;
        this.f380859e = r100;
        this.f380855a = r102;
    }

    public h f(MeasureMode r100, int r101, MeasureMode r102, int r103) {
        return new h(0.0f, 0.0f);
    }

    public void r(float r100, float r101, float r102, float r103) {
        View r104 = b();
        if (r104 == null) goto L6;
        r104.setPadding((int) r100, (int) r101, (int) r102, (int) r103);
        return;
    }
}
