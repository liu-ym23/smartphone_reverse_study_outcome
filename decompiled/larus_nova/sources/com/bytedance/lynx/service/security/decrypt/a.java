package com.bytedance.lynx.service.security.decrypt;

import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DecryptErrorCode f264936a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f264937b;

    /* JADX INFO: renamed from: com.bytedance.lynx.service.security.decrypt.a$a, reason: collision with other inner class name */
    public static final class C3713a extends a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final DecryptErrorCode f264938c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f264939d;

        public final int hashCode() {
            return (this.f264938c.hashCode() * 31) + this.f264939d.hashCode();
        }

        public final String toString() {
            return "Failed(errorCode=" + this.f264938c + ", errorMessage=" + this.f264939d + ')';
        }

        @Override // com.bytedance.lynx.service.security.decrypt.a
        public final DecryptErrorCode a() {
            return this.f264938c;
        }

        @Override // com.bytedance.lynx.service.security.decrypt.a
        public final String b() {
            return this.f264939d;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C3713a) == true) goto L8;
            return false;
        L8:
            C3713a r101 = (C3713a) r100;
            if (this.f264938c == r101.f264938c) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f264939d, r101.f264939d) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public C3713a(DecryptErrorCode r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "errorCode");
            Intrinsics.checkNotNullParameter(r101, "errorMessage");
            super(r100, r101);
            this.f264938c = r100;
            this.f264939d = r101;
        }
    }

    public static final class b extends a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ByteBuffer f264940c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f264940c, ((b) r100).f264940c) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f264940c.hashCode();
        }

        public final String toString() {
            return "Success(template=" + this.f264940c + ')';
        }

        public b(ByteBuffer r100) {
            Intrinsics.checkNotNullParameter(r100, ThumbGlideUrl.SOURCE_TEMPLATE);
            super(DecryptErrorCode.Ok, null);
            this.f264940c = r100;
        }
    }

    public DecryptErrorCode a() {
        return this.f264936a;
    }

    public String b() {
        return this.f264937b;
    }

    public a(DecryptErrorCode r100, String r101) {
        this.f264936a = r100;
        this.f264937b = r101;
    }
}
