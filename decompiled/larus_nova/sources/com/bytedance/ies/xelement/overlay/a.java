package com.bytedance.ies.xelement.overlay;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<C3566a> f250201a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f250202b;

    /* JADX INFO: renamed from: com.bytedance.ies.xelement.overlay.a$a, reason: collision with other inner class name */
    public static final class C3566a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f250203a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final LynxOverlayDialog f250204b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C3566a) == true) goto L8;
            return false;
        L8:
            C3566a r101 = (C3566a) r100;
            if (Intrinsics.areEqual(this.f250203a, r101.f250203a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f250204b, r101.f250204b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f250203a.hashCode() * 31) + this.f250204b.hashCode();
        }

        public final String toString() {
            return "OverlayData(id=" + this.f250203a + ", dialog=" + this.f250204b + ')';
        }

        public C3566a(String r100, LynxOverlayDialog r101) {
            Intrinsics.checkNotNullParameter(r100, "id");
            Intrinsics.checkNotNullParameter(r101, "dialog");
            this.f250203a = r100;
            this.f250204b = r101;
        }
    }

    static {
        f250201a = new ArrayList();
    }

    public static ArrayList b() {
        ArrayList r100 = new ArrayList();
        Iterator r101 = ((ArrayList) f250201a).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r100.add(((C3566a) r101.next()).f250204b);
        goto L4
    L6:
        return r100;
    }

    public static void c(String r100) {
        if (r100 == null) goto L13;
        Iterator r101 = ((ArrayList) f250201a).iterator();
    L5:
        if (r101.hasNext() == false) goto L14;
        C3566a r102 = (C3566a) r101.next();
        if (Intrinsics.areEqual(r102.f250203a, r100) == false) goto L5;
        ((ArrayList) f250201a).remove(r102);
        return;
    L14:
        return;
    }

    public static String a(String r100, LynxOverlayDialog r101) {
        Intrinsics.checkNotNullParameter(r101, "dialog");
        if (r100 != null) goto L5;
        StringBuilder r102 = new StringBuilder("default_overlay_id_");
        int r103 = f250202b;
        f250202b = r103 + 1;
        r102.append(r103);
        r100 = r102.toString();
    L5:
        ListProtector.add(f250201a, 0, new C3566a(r100, r101));
        return r100;
    }
}
