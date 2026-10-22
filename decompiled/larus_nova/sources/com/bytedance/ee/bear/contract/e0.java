package com.bytedance.ee.bear.contract;

import android.content.Context;
import com.bytedance.ee.bear.list.dto.Document;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f217045a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Document f217046b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f217047c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<Document> f217048d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f217049e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f217050f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e0) == true) goto L8;
        return false;
    L8:
        e0 r101 = (e0) r100;
        if (Intrinsics.areEqual(this.f217045a, r101.f217045a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f217046b, r101.f217046b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f217047c, r101.f217047c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f217048d, r101.f217048d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f217049e, r101.f217049e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f217050f, r101.f217050f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        Context r100 = this.f217045a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Document r104 = this.f217046b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f217047c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        List<Document> r110 = this.f217048d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f217049e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f217050f;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ListRouteBean(context=" + this.f217045a + ", item=" + this.f217046b + ", currentModule=" + this.f217047c + ", fileList=" + this.f217048d + ", subModule=" + this.f217049e + ", srcModule=" + this.f217050f + ')';
    }

    public final Context getContext() {
        return this.f217045a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e0(Context r100, Document r101, String r102, List<? extends Document> r103, String r104, String r105) {
        this.f217045a = r100;
        this.f217046b = r101;
        this.f217047c = r102;
        this.f217048d = r103;
        this.f217049e = r104;
        this.f217050f = r105;
    }
}
