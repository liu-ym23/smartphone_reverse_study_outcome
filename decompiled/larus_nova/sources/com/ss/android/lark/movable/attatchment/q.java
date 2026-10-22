package com.ss.android.lark.movable.attatchment;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes36.dex */
public final class q {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f432647d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f432648a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f432649b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f432650c;

    public static final class a {
        public static q a(String r110) {
            Intrinsics.checkNotNullParameter(r110, "url");
            if (r110.length() != 0) goto L5;
            boolean r100 = true;
        L6:
            q r101 = null;
            if (r100 == false) goto L22;
            return null;
        L22:
            Uri r102 = UriProtector.parse(r110);     // Catch: Exception -> L17
            String r103 = (String) ListProtector.get(StringsKt.split$default(r110, new String[]{"?"}, false, 0, 6, null), 0);     // Catch: Exception -> L17
            String r104 = UriProtector.getQueryParameter(r102, "event");     // Catch: Exception -> L17
            if (r104 == null) goto L14;
            Integer r105 = StringsKt.toIntOrNull(r104);     // Catch: Exception -> L17
            if (r105 == null) goto L14;
            int r106 = r105.intValue();     // Catch: Exception -> L17
        L15:
            return new q(r103, r106, UriProtector.getQueryParameter(r102, "tint_color"));
        L14:
            r106 = 0;
        L17:
            List r111 = StringsKt.split$default(r110, new String[]{"?"}, false, 0, 6, null);
            if ((!r111.isEmpty()) == false) goto L21;
            r101 = new q((String) ListProtector.get(r111, 0), 0, null);
        L21:
            return r101;
        L5:
            r100 = false;
            goto L6
        }
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q) == true) goto L8;
        return false;
    L8:
        q r101 = (q) r100;
        if (Intrinsics.areEqual(this.f432648a, r101.f432648a) == true) goto L12;
        return false;
    L12:
        if (this.f432649b == r101.f432649b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f432650c, r101.f432650c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f432648a.hashCode() * 31) + this.f432649b) * 31;
        String r101 = this.f432650c;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "MovableUDIconData(iconKey=" + this.f432648a + ", event=" + this.f432649b + ", tintColor=" + this.f432650c + ')';
    }

    public q(String r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "iconKey");
        this.f432648a = r100;
        this.f432649b = r101;
        this.f432650c = r102;
    }
}
