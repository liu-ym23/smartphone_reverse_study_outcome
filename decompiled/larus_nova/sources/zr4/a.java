package zr4;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes15.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f573413a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f573414b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f573415c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f573416d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f573417e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Long f573418f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f573419g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f573420h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f573421i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f573422j;

    public final void a() {
        if (this.f573415c == 83) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(this.f573417e) == true) goto L9;
        this.f573419g = this.f573417e;
        this.f573417e = "";
        return;
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder("blockId:");
        r100.append(this.f573414b);
        r100.append(",viewId:");
        a();
        r100.append(this.f573419g);
        r100.append(",recordId:");
        r100.append(this.f573422j);
        r100.append(",blockType:");
        r100.append(this.f573415c);
        r100.append(",isFromDB:");
        r100.append(this.f573420h);
        return r100.toString();
    }

    public a() {
        this.f573413a = "";
        this.f573414b = "";
        this.f573415c = -1;
        this.f573416d = "";
        this.f573417e = "";
        this.f573418f = 0L;
        this.f573419g = "";
        this.f573420h = true;
        this.f573421i = "";
        this.f573422j = "";
    }
}
