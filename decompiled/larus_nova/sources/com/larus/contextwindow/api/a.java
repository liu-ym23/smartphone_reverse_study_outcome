package com.larus.contextwindow.api;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public interface a {

    /* JADX INFO: renamed from: com.larus.contextwindow.api.a$a, reason: collision with other inner class name */
    public static final class C4197a implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ContextWindowHiddenReason f330276a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C4197a) == true) goto L9;
            return false;
        L9:
            if (this.f330276a == ((C4197a) r100).f330276a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f330276a.hashCode();
        }

        public final String toString() {
            return "Hidden(reason=" + this.f330276a + ')';
        }

        public C4197a(ContextWindowHiddenReason r100) {
            Intrinsics.checkNotNullParameter(r100, "reason");
            this.f330276a = r100;
        }
    }

    /* JADX INFO: loaded from: classes27.dex */
    public static final class b implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ContextWindowSnapshot f330277a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f330277a, ((b) r100).f330277a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f330277a.hashCode();
        }

        public final String toString() {
            return "Visible(snapshot=" + this.f330277a + ')';
        }

        public b(ContextWindowSnapshot r100) {
            Intrinsics.checkNotNullParameter(r100, "snapshot");
            this.f330277a = r100;
        }
    }
}
