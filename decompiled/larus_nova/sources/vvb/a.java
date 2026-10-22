package vvb;

import android.content.Context;
import android.view.View;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import rub.c;

/* JADX INFO: loaded from: classes37.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, C8045a> f557399a = null;

    /* JADX INFO: renamed from: vvb.a$a, reason: collision with other inner class name */
    public static final class C8045a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Function1<Context, View> f557400a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Function0<Unit> f557401b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Function0<Unit> f557402c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final c f557403d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C8045a) == true) goto L8;
            return false;
        L8:
            C8045a r101 = (C8045a) r100;
            if (Intrinsics.areEqual(this.f557400a, r101.f557400a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f557401b, r101.f557401b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f557402c, r101.f557402c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f557403d, r101.f557403d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(null, null) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f557400a.hashCode() * 31;
            Function0<Unit> r101 = this.f557401b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = (r100 + r102) * 31;
            Function0<Unit> r104 = this.f557402c;
            if (r104 != null) goto L9;
            int r105 = 0;
        L11:
            return ((((r103 + r105) * 31) + this.f557403d.hashCode()) * 31) + 0;
        L9:
            r105 = r104.hashCode();
            goto L11
        L5:
            r102 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "Entry(contentViewProvider=" + this.f557400a + ", onDismiss=" + this.f557401b + ", onShow=" + this.f557402c + ", backgroundConfig=" + this.f557403d + ", dismissConfig=null)";
        }

        public C8045a(Function1 r100, Function0 r101, Function0 r102, c r103) {
            Intrinsics.checkNotNullParameter(r100, "contentViewProvider");
            Intrinsics.checkNotNullParameter(r103, "backgroundConfig");
            this.f557400a = r100;
            this.f557401b = r101;
            this.f557402c = r102;
            this.f557403d = r103;
        }
    }

    static {
        f557399a = new ConcurrentHashMap();
    }
}
