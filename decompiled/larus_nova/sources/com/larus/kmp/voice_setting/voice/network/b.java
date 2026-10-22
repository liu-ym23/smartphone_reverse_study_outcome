package com.larus.kmp.voice_setting.voice.network;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public abstract class b<T> {

    public static final class a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f353990a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f353991b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Throwable f353992c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f353990a == r101.f353990a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f353991b, r101.f353991b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f353992c, r101.f353992c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f353990a * 31) + this.f353991b.hashCode()) * 31;
            Throwable r101 = this.f353992c;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        @Override // com.larus.kmp.voice_setting.voice.network.b
        public final String toString() {
            return "Error(code=" + this.f353990a + ", msg=" + this.f353991b + ", throwable=" + this.f353992c + ')';
        }

        public a(int r100, String r101, Throwable r102) {
            Intrinsics.checkNotNullParameter(r101, "msg");
            this.f353990a = r100;
            this.f353991b = r101;
            this.f353992c = r102;
        }
    }

    /* JADX INFO: renamed from: com.larus.kmp.voice_setting.voice.network.b$b, reason: collision with other inner class name */
    public static final class C4393b<T> extends b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.larus.kmp.voice_setting.voice.network.a<T> f353993a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Throwable f353994b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C4393b) == true) goto L8;
            return false;
        L8:
            C4393b r101 = (C4393b) r100;
            if (Intrinsics.areEqual(this.f353993a, r101.f353993a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f353994b, r101.f353994b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f353993a.hashCode() * 31;
            Throwable r101 = this.f353994b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        @Override // com.larus.kmp.voice_setting.voice.network.b
        public final String toString() {
            return "Success(bizResp=" + this.f353993a + ", throwable=" + this.f353994b + ')';
        }

        public C4393b(com.larus.kmp.voice_setting.voice.network.a<T> r100, Throwable r101) {
            Intrinsics.checkNotNullParameter(r100, "bizResp");
            this.f353993a = r100;
            this.f353994b = r101;
        }
    }

    public b() {
    }

    public String toString() {
        if ((this instanceof C4393b) == false) goto L6;
        return "Success[" + this + ']';
    L6:
        if ((this instanceof a) == false) goto L10;
        return "Error[" + this + ']';
    L10:
        throw new NoWhenBranchMatchedException();
    }
}
