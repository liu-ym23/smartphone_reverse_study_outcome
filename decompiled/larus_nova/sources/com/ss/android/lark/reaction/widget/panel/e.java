package com.ss.android.lark.reaction.widget.panel;

import android.graphics.drawable.Drawable;
import android.view.View;

/* JADX INFO: loaded from: classes37.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f439495a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f439496b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f439497c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Drawable f439498d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f439499e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b f439500f;

    public interface a {
        void a(View r100);
    }

    public interface b {
        boolean a();

        boolean b();

        void onClick();

        void onHide();

        void onShow();

        void onViewCreated();
    }

    public e(String r100, int r101, a r102) {
        this.f439497c = -1;
        this.f439498d = null;
        this.f439499e = true;
        this.f439495a = r100;
        this.f439497c = r101;
        this.f439496b = r102;
    }

    public e(String r100, Drawable r101, a r102) {
        this.f439497c = -1;
        this.f439498d = null;
        this.f439499e = true;
        this.f439495a = r100;
        this.f439498d = r101;
        this.f439496b = r102;
    }
}
