package com.bytedance.awemeopen.apps.framework.feed.pinch.utils;

import android.content.Context;
import android.view.GestureDetector;
import android.view.ViewConfiguration;
import com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.r;

/* JADX INFO: loaded from: classes14.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f195817a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f195818b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f195819c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f195820d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f195821e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f195822f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f195823g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f195824h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f195825i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f195826j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f195827k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f195828l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f195829m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f195830n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public GestureDetector f195831o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f195832p;

    public interface a {
        void a();

        void b();

        boolean c(b r100);
    }

    public final boolean a() {
        if (this.f195830n == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public b(Context r100, r r101) {
        this.f195830n = 0;
        this.f195817a = r101;
        this.f195826j = ViewConfiguration.get(r100).getScaledTouchSlop() * 2;
        r100.getResources();
        this.f195827k = 1;
        int r102 = r100.getApplicationInfo().targetSdkVersion;
        if (r102 <= 18) goto L8;
        this.f195820d = true;
        if (this.f195831o != null) goto L8;
        this.f195831o = new GestureDetector(r100, new com.bytedance.awemeopen.apps.framework.feed.pinch.utils.a(this), null);
    L8:
        if (r102 <= 22) goto L11;
        this.f195821e = true;
        return;
    }
}
