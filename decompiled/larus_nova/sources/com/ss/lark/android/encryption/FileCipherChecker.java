package com.ss.lark.android.encryption;

import android.util.LruCache;
import com.ss.lark.android.encryption.utils.PreCheckUtilKt;
import java.io.File;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class FileCipherChecker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LruCache<String, b> f456791a = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0007\u001a\u00020\bj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\t"}, d2 = {"Lcom/ss/lark/android/encryption/FileCipherChecker$CipherStatus;", "", "<init>", "(Ljava/lang/String;I)V", "ENCRYPTED", "UN_ENCRYPT", "UNKNOWN", "isEncrypt", "", "security-encryption_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum CipherStatus extends Enum<CipherStatus> {
        public static final CipherStatus ENCRYPTED = null;
        public static final CipherStatus UNKNOWN = null;
        public static final CipherStatus UN_ENCRYPT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CipherStatus[] f456792a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f456793b = null;

        public static EnumEntries<CipherStatus> getEntries() {
            return f456793b;
        }

        static {
            CipherStatus r100 = new CipherStatus("ENCRYPTED", 0);
            ENCRYPTED = r100;
            CipherStatus r101 = new CipherStatus("UN_ENCRYPT", 1);
            UN_ENCRYPT = r101;
            CipherStatus r102 = new CipherStatus("UNKNOWN", 2);
            UNKNOWN = r102;
            CipherStatus[] r103 = {r100, r101, r102};
            f456792a = r103;
            f456793b = EnumEntriesKt.enumEntries(r103);
        }

        public static CipherStatus[] values() {
            return (CipherStatus[]) f456792a.clone();
        }

        public final boolean isEncrypt() {
            if (this != ENCRYPTED) goto L5;
            return true;
        L5:
            return false;
        }

        public static CipherStatus valueOf(String r100) {
            return (CipherStatus) r27.a.a(CipherStatus.class, r100);
        }

        public CipherStatus(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f456794a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f456795b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f456796c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f456794a, r101.f456794a) == true) goto L12;
            return false;
        L12:
            if (this.f456795b == r101.f456795b) goto L15;
            return false;
        L15:
            if (this.f456796c == r101.f456796c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f456794a.hashCode() * 31;
            long r101 = this.f456795b;
            int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
            long r103 = this.f456796c;
            return r102 + ((int) (r103 ^ (r103 >>> 32)));
        }

        public final String toString() {
            return "FileMeta(path=" + this.f456794a + ", size=" + this.f456795b + ", modifyTime=" + this.f456796c + ')';
        }

        public a(File r100) {
            Intrinsics.checkNotNullParameter(r100, "file");
            String r101 = r100.getAbsolutePath();
            long r102 = r100.length();
            long r103 = r100.lastModified();
            Intrinsics.checkNotNullParameter(r101, "path");
            this.f456794a = r101;
            this.f456795b = r102;
            this.f456796c = r103;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int f456797c = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a f456798a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final CipherStatus f456799b;

        public static final class a {
        }

        static {
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f456798a, r101.f456798a) == true) goto L12;
            return false;
        L12:
            if (this.f456799b == r101.f456799b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f456798a.hashCode() * 31) + this.f456799b.hashCode();
        }

        public final String toString() {
            return "FileStatus(fileMeta=" + this.f456798a + ", status=" + this.f456799b + ')';
        }

        public b(a r100, CipherStatus r101) {
            Intrinsics.checkNotNullParameter(r100, "fileMeta");
            Intrinsics.checkNotNullParameter(r101, "status");
            this.f456798a = r100;
            this.f456799b = r101;
        }
    }

    static {
        f456791a = new LruCache(256);
    }

    @JvmStatic
    public static final boolean a(File r110) {
        Intrinsics.checkNotNullParameter(r110, "file");
        LruCache<String, b> r100 = f456791a;
        b r101 = r100.get(r110.getAbsolutePath());
        if (r101 == null) goto L19;
        a r102 = r101.f456798a;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r110, "file");
        if (Intrinsics.areEqual(r102.f456794a, r110.getAbsolutePath()) == true) goto L7;
    L11:
        boolean r103 = false;
    L12:
        if (r103 == true) goto L15;
        r101 = null;
    L15:
        if (r101 == null) goto L19;
        CipherStatus r104 = r101.f456799b;
        if (r104 == null) goto L19;
    L21:
        if (r104 != CipherStatus.UNKNOWN) goto L29;
        boolean r105 = PreCheckUtilKt.a(r110.getAbsolutePath(), null);
        if (r105 == false) goto L26;
        CipherStatus r106 = CipherStatus.ENCRYPTED;
    L27:
        int r107 = b.f456797c;
        Intrinsics.checkNotNullParameter(r110, "file");
        Intrinsics.checkNotNullParameter(r106, "status");
        b r108 = new b(new a(r110), r106);
        b r111 = r100.put(r108.f456798a.f456794a, r108);
        return r105;
    L26:
        r106 = CipherStatus.UN_ENCRYPT;
        goto L27
    L29:
        return r104.isEncrypt();
    L7:
        if (r102.f456795b != r110.length()) goto L11;
        if (r102.f456795b != r110.lastModified()) goto L11;
        r103 = true;
    L19:
        r104 = CipherStatus.UNKNOWN;
        goto L21
    }
}
