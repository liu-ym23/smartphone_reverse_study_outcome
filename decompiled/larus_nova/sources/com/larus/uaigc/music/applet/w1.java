package com.larus.uaigc.music.applet;

import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class w1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bq8.a f373657a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f373658b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof w1) == true) goto L8;
        return false;
    L8:
        w1 r101 = (w1) r100;
        if (Intrinsics.areEqual(this.f373657a, r101.f373657a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f373658b, r101.f373658b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f373657a.hashCode() * 31) + this.f373658b.hashCode();
    }

    public final String toString() {
        return "UseTemplateEvent(template=" + this.f373657a + ", enterFrom=" + this.f373658b + ')';
    }

    public w1(bq8.a r100) {
        Intrinsics.checkNotNullParameter(r100, ThumbGlideUrl.SOURCE_TEMPLATE);
        Intrinsics.checkNotNullParameter("template_detail_button", "enterFrom");
        this.f373657a = r100;
        this.f373658b = "template_detail_button";
    }
}
