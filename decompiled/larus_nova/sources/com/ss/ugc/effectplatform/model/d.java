package com.ss.ugc.effectplatform.model;

import bytekn.foundation.io.file.FileManager;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.ss.ugc.effectplatform.util.k;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
public final class d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f457416g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f457417a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f457418b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f457419c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f457420d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f457421e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f457422f;

    public static final class a {
    }

    static {
    }

    public final String a() {
        String r100 = this.f457419c;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L14;
        String r102 = FileManager.f21782a;
        String r103 = FileManager.e(this.f457422f);
        if (r103 == null) goto L14;
        this.f457419c = k.b(r103);
    L14:
        return this.f457419c;
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r101 = false;
        goto L9
    }

    public final String b() {
        String r100 = this.f457417a;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L14;
        String r102 = FileManager.f21782a;
        String r103 = FileManager.e(this.f457422f);
        if (r103 == null) goto L14;
        this.f457417a = k.d(r103);
    L14:
        return this.f457417a;
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r101 = false;
        goto L9
    }

    public final int c() {
        if (this.f457420d != (-1)) goto L13;
        String r100 = FileManager.f21782a;
        if (FileManager.d(this.f457422f) == false) goto L9;
        String r101 = FileManager.e(this.f457422f);
        if (r101 == null) goto L9;
        int r102 = k.e(r101);
    L11:
        this.f457420d = r102;
    L9:
        r102 = 0;
    L13:
        return this.f457420d;
    }

    public final String d() {
        String r100 = this.f457418b;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L21;
        String r102 = FileManager.f21782a;
        String r103 = FileManager.e(this.f457422f);
        if (r103 == null) goto L21;
        StringsKt.lastIndexOf$default(r103, HTTP.URL_DEFAULT, 0, false, 6, null);
        int r104 = StringsKt.lastIndexOf$default(r103, "_v", 0, false, 6, null);
        if (StringsKt.contains$default(r103, "size", false, 2, null) == false) goto L15;
        int r105 = StringsKt.lastIndexOf$default(r103, "_size", 0, false, 6, null);
    L16:
        if (r104 <= 0) goto L18;
        String r106 = StringsKt.replace$default(r103.substring(r104 + 2, r105), '_', '.', false, 4, null);
    L19:
        this.f457418b = r106;
        goto L21
    L18:
        r106 = "1.0";
        goto L19
    L15:
        r105 = StringsKt.lastIndexOf$default(r103, "_model", 0, false, 6, null);
    L21:
        return this.f457418b;
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r101 = false;
        goto L9
    }

    public final String toString() {
        return "LocalModelInfo{name=" + b() + "',version=" + d() + "',size=" + c() + "'}";
    }

    public d(String r100) {
        this.f457422f = r100;
        this.f457420d = -1;
    }
}
