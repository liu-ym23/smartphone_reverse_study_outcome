package com.google.common.hash;

import com.google.common.base.m;
import com.google.errorprone.annotations.Immutable;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes23.dex */
@Immutable
@ElementTypesAreNonnullByDefault
final class MessageDigestHashFunction extends com.google.common.hash.b implements Serializable {
    private final int bytes;
    private final MessageDigest prototype;
    private final boolean supportsClone;
    private final String toString;

    public static final class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        private final String algorithmName;
        private final int bytes;
        private final String toString;

        private Object readResolve() {
            return new MessageDigestHashFunction(this.algorithmName, this.bytes, this.toString);
        }

        public SerializedForm(String r100, int r101, String r102, a r103) {
            this.algorithmName = r100;
            this.bytes = r101;
            this.toString = r102;
        }
    }

    public static /* synthetic */ class a {
    }

    public static final class b extends com.google.common.hash.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final MessageDigest f275573b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f275574c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f275575d;

        @Override // com.google.common.hash.f
        public final HashCode a() {
            m.p(!this.f275575d, "Cannot re-use a Hasher after calling hash() on it");
            this.f275575d = true;
            if (this.f275574c != this.f275573b.getDigestLength()) goto L6;
            return HashCode.fromBytesNoCopy(this.f275573b.digest());
        L6:
            return HashCode.fromBytesNoCopy(Arrays.copyOf(this.f275573b.digest(), this.f275574c));
        }

        @Override // com.google.common.hash.a
        public void update(byte r100) {
            m.p(!this.f275575d, "Cannot re-use a Hasher after calling hash() on it");
            this.f275573b.update(r100);
        }

        @Override // com.google.common.hash.a
        public void update(ByteBuffer r100) {
            m.p(!this.f275575d, "Cannot re-use a Hasher after calling hash() on it");
            this.f275573b.update(r100);
        }

        public b(MessageDigest r100, int r101) {
            this.f275573b = r100;
            this.f275574c = r101;
        }

        @Override // com.google.common.hash.a
        public void update(byte[] r100, int r101, int r102) {
            m.p(!this.f275575d, "Cannot re-use a Hasher after calling hash() on it");
            this.f275573b.update(r100, r101, r102);
        }
    }

    public int bits() {
        return this.bytes * 8;
    }

    @Override // com.google.common.hash.e
    public f newHasher() {
        if (this.supportsClone == false) goto L14;
        return new b((MessageDigest) this.prototype.clone(), this.bytes);
    L14:
        MessageDigest r100 = MessageDigest.getInstance(this.prototype.getAlgorithm());     // Catch: NoSuchAlgorithmException -> L10
        return new b(r100, this.bytes);
    L10:
        e = move-exception;
        throw new AssertionError(e);
    }

    public Object writeReplace() {
        return new SerializedForm(this.prototype.getAlgorithm(), this.bytes, this.toString, null);
    }

    public String toString() {
        return this.toString;
    }

    private void readObject(ObjectInputStream r100) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public MessageDigestHashFunction(String r100, String r101) {
        MessageDigest r102 = MessageDigest.getInstance(r100);     // Catch: NoSuchAlgorithmException -> L10
        this.prototype = r102;
        this.bytes = r102.getDigestLength();
        r101.getClass();
        this.toString = r101;
        r102.clone();     // Catch: CloneNotSupportedException -> L7
        boolean r103 = true;
    L8:
        this.supportsClone = r103;
        return;
    L7:
        r103 = false;
    L10:
        e = move-exception;
        throw new AssertionError(e);
    }

    public MessageDigestHashFunction(String r100, int r101, String r102) {
        r102.getClass();
        this.toString = r102;
        MessageDigest r103 = MessageDigest.getInstance(r100);     // Catch: NoSuchAlgorithmException -> L15
        this.prototype = r103;
        int r104 = r103.getDigestLength();
        boolean r105 = true;
        if (r101 < 4) goto L8;
        if (r101 > r104) goto L8;
        boolean r106 = true;
    L9:
        m.e(r106, "bytes (%s) must be >= 4 and < %s", r101, r104);
        this.bytes = r101;
        r103.clone();     // Catch: CloneNotSupportedException -> L12
    L13:
        this.supportsClone = r105;
        return;
    L12:
        r105 = false;
    L8:
        r106 = false;
    L15:
        e = move-exception;
        throw new AssertionError(e);
    }
}
