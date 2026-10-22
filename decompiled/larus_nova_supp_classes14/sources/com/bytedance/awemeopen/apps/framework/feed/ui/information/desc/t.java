package com.bytedance.awemeopen.apps.framework.feed.ui.information.desc;

import com.bytedance.awemeopen.bizmodels.feed.video.TextExtraStruct;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class t extends com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.b {
    public final tz3.b<a> a;
    public final tz3.b<Boolean> b;
    public final tz3.b<Unit> c;
    public final tz3.b<Unit> d;
    public final tz3.b<Unit> e;
    public Function0<Integer> f;
    public Function0<Integer> g;
    public Function0<Integer> h;

    public static final class a {
        public final CharSequence a;
        public final List<TextExtraStruct> b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            List<TextExtraStruct> r1 = this.b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public final String toString() {
            return "DescBean(desc=" + this.a + ", textExtraList=" + this.b + ')';
        }

        public a(CharSequence r2, List<TextExtraStruct> r3) {
            Intrinsics.checkNotNullParameter(r2, "desc");
            this.a = r2;
            this.b = r3;
        }
    }

    public t() {
        this.a = new tz3.b();
        this.b = new tz3.b();
        this.c = new tz3.b();
        this.d = new tz3.b();
        this.e = new tz3.b();
        new ArrayList();
    }
}
