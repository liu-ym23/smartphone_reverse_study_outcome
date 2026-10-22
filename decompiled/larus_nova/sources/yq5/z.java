package yq5;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes18.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f568851a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f568852b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f568853c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f568854d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f568855e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f568856f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f568857g;

    public final boolean a() {
        if (TextUtils.isEmpty(this.f568852b) == false) goto L5;
    L9:
        return false;
    L5:
        if (TextUtils.isEmpty(this.f568853c) == true) goto L9;
        if (this.f568854d == (-1)) goto L9;
        return true;
    }

    public final String toString() {
        return "WikiRouteEntry{wiki_token='" + du5.b.g(this.f568852b) + "', obj_token='" + du5.b.g(this.f568853c) + "', obj_type=" + this.f568854d + ", in_space=" + this.f568855e + ", log_id=" + this.f568857g + '}';
    }

    public z() {
        this.f568856f = System.currentTimeMillis();
    }
}
