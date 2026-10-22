package com.obric.assistant.state.multitask;

import jha.q;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes33.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f393270a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C4634a f393271b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f393272c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final q<?> f393273d;

    /* JADX INFO: renamed from: com.obric.assistant.state.multitask.a$a, reason: collision with other inner class name */
    public static final class C4634a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f393274a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f393275b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C4634a) == true) goto L8;
            return false;
        L8:
            C4634a r101 = (C4634a) r100;
            if (Intrinsics.areEqual(this.f393274a, r101.f393274a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f393275b, r101.f393275b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f393274a.hashCode() * 31) + this.f393275b.hashCode();
        }

        public final String toString() {
            return this.f393274a + ':' + this.f393275b;
        }

        public C4634a(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "action");
            Intrinsics.checkNotNullParameter(r101, "result");
            this.f393274a = r100;
            this.f393275b = r101;
        }
    }

    public static final class b {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f393270a, r101.f393270a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f393271b, r101.f393271b) == true) goto L15;
        return false;
    L15:
        if (this.f393272c == r101.f393272c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f393273d, r101.f393273d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f393270a.hashCode() * 31) + this.f393271b.hashCode()) * 31;
        long r101 = this.f393272c;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        q<?> r103 = this.f393273d;
        if (r103 != null) goto L5;
        int r104 = 0;
    L7:
        return r102 + r104;
    L5:
        r104 = r103.hashCode();
        goto L7
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder();
        q<?> r101 = this.f393273d;
        if (r101 == null) goto L6;
        r100.append("taskFlowId=" + r101.a().f499147a + ", ");
        r100.append("sequenceId=" + this.f393272c + ", ");
        r100.append("state=" + r101.a().f499148b.getClass().getSimpleName() + ", ");
        r100.append("action=" + this.f393271b + ", ");
        StringBuilder r102 = new StringBuilder("taskEvent=");
        r102.append(r101.a());
        r100.append(r102.toString());
    L6:
        return StringsKt.trimEnd(r100.toString(), new char[]{',', ' '});
    }

    public a(String r100, C4634a r101, long r102, q<?> r103) {
        Intrinsics.checkNotNullParameter(r100, "logTag");
        Intrinsics.checkNotNullParameter(r101, "action");
        this.f393270a = r100;
        this.f393271b = r101;
        this.f393272c = r102;
        this.f393273d = r103;
    }
}
