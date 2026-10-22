package com.larus.receive.contract;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public abstract class a {

    /* JADX INFO: renamed from: com.larus.receive.contract.a$a, reason: collision with other inner class name */
    public static final class C4480a extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ReceiveTextDelivery f367370a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C4480a) == true) goto L9;
            return false;
        L9:
            if (this.f367370a == ((C4480a) r100).f367370a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f367370a.hashCode();
        }

        public final String toString() {
            return "Handle(delivery=" + this.f367370a + ')';
        }

        public C4480a(ReceiveTextDelivery r100) {
            Intrinsics.checkNotNullParameter(r100, "delivery");
            this.f367370a = r100;
        }
    }

    public static final class b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f367371a = null;

        static {
            f367371a = new b();
        }

        public b() {
        }
    }

    public a() {
    }
}
