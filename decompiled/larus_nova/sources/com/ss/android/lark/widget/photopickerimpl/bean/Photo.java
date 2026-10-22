package com.ss.android.lark.widget.photopickerimpl.bean;

import android.text.TextUtils;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes38.dex */
public class Photo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Integer f447736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f447737b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f447738c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f447739d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f447740e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f447741f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f447742g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f447743h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f447744i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f447745j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f447746k;

    public final boolean a() {
        if (TextUtils.isEmpty(this.f447738c) == true) goto L13;
        String r100 = this.f447738c;
        if (r100 != null) goto L7;
    L9:
        boolean r101 = false;
    L10:
        if (r101 == false) goto L14;
        return true;
    L14:
        return false;
    L7:
        if (StringsKt.startsWith$default(r100, "video", false, 2, null) != true) goto L9;
        r101 = true;
        goto L10
    L13:
        return false;
    }

    public final String toString() {
        return "Photo(id=" + this.f447736a + ", path=" + this.f447737b + ", mimeType=" + this.f447738c + ", dirName=" + this.f447739d + ", width=" + this.f447740e + ", height=" + this.f447741f + ", size=" + this.f447742g + ", duration=" + this.f447743h + ')';
    }

    public Photo() {
        this.f447744i = "";
        this.f447746k = LazyKt.lazy(new Photo$isHeif$2(this));
    }
}
