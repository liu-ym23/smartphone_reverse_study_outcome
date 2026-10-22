package com.ss.android.lark.newemoji.larkemoji;

import android.graphics.Bitmap;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f433047a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LiveData<String> f433048b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f433049c;

    @Override // com.ss.android.lark.newemoji.larkemoji.a
    public final Bitmap a() {
        return g(this.f433047a);
    }

    @Override // com.ss.android.lark.newemoji.larkemoji.a
    public final Bitmap d() {
        return g(this.f433048b.getValue());
    }

    public final int hashCode() {
        return (this.f433047a.hashCode() * 31) + this.f433048b.hashCode();
    }

    @Override // com.ss.android.lark.newemoji.larkemoji.a
    public final int getHeight() {
        qsb.a r100 = qsb.b.a().Q1().get(this.f433047a);
        if (r100 != null) goto L7;
        return 32;
    L7:
        return r100.a();
    }

    @Override // com.ss.android.lark.newemoji.larkemoji.a
    public final int getWidth() {
        qsb.a r100 = qsb.b.a().Q1().get(this.f433047a);
        if (r100 != null) goto L7;
        return 32;
    L7:
        return r100.c();
    }

    @Override // com.ss.android.lark.newemoji.larkemoji.a
    public final String b() {
        return this.f433047a;
    }

    @Override // com.ss.android.lark.newemoji.larkemoji.a
    public final List<String> e() {
        return this.f433049c;
    }

    @Override // com.ss.android.lark.newemoji.larkemoji.a
    public final LiveData<String> f() {
        return this.f433048b;
    }

    @Override // com.ss.android.lark.newemoji.larkemoji.a
    public final String getId() {
        return this.f433047a;
    }

    public static Bitmap g(String r100) {
        ConcurrentHashMap<String, qsb.a> r101 = qsb.b.a().Q1();
        if (r100 != null) goto L5;
        String r102 = "";
    L6:
        qsb.a r103 = r101.get(r102);
        if (r103 == null) goto L9;
        Bitmap r104 = r103.b();
    L10:
        if (r104 != null) goto L13;
        if (r100 == null) goto L13;
        qsb.b.a().sb(r100);
    L13:
        return r104;
    L9:
        r104 = null;
        goto L10
    L5:
        r102 = r100;
        goto L6
    }

    @Override // com.ss.android.lark.newemoji.larkemoji.a
    public final boolean c(boolean r100) {
        if (g(this.f433047a) == null) goto L5;
        boolean r101 = true;
    L6:
        if (r100 == true) goto L8;
        return r101;
    L8:
        qsb.a r102 = qsb.b.a().Q1().get(this.f433047a);
        if (r102 != null) goto L11;
        return false;
    L11:
        Iterator<String> r103 = r102.f534728f.iterator();
    L13:
        if (r103.hasNext() == false) goto L20;
        String r104 = r103.next();
        qsb.a r105 = qsb.b.a().Q1().get(r104);
        if (r105 == null) goto L17;
        Bitmap r106 = r105.b();
    L18:
        if (r106 != null) goto L13;
        return false;
    L17:
        r106 = null;
        goto L18
    L20:
        return r101;
    L5:
        r101 = false;
        goto L6
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof b) == true) goto L5;
        return false;
    L5:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f433047a, r101.f433047a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f433048b, r101.f433048b) == false) goto L12;
        return true;
    L12:
        return false;
    }

    public b(String r100, MutableLiveData r101) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "skinedReactionKey");
        this.f433047a = r100;
        this.f433048b = r101;
        qsb.a r102 = qsb.b.a().Q1().get(r100);
        if (r102 == null) goto L7;
        List<String> r103 = r102.f534728f;
        if (r103 == null) goto L7;
    L8:
        this.f433049c = r103;
        return;
    L7:
        r103 = CollectionsKt.emptyList();
        goto L8
    }
}
