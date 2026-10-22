package com.google.common.hash;

import com.google.errorprone.annotations.Immutable;
import java.util.zip.Checksum;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public final class Hashing {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f275566a = 0;

    @Immutable
    public static abstract enum ChecksumType extends Enum<ChecksumType> implements g<Checksum> {
        public static final ChecksumType ADLER_32 = null;
        public static final ChecksumType CRC_32 = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ChecksumType[] f275567a = null;
        public final e hashFunction;

        @Override // com.google.common.base.t
        @com.google.common.base.ParametricNullness
        public abstract /* synthetic */ Object get();

        static {
            final String r100 = "Hashing.crc32()";
            final String r101 = "CRC_32";
            final int r102 = 0;
            ChecksumType r103 = new AnonymousClass1(r101, r102, r100);
            CRC_32 = r103;
            final String r104 = "Hashing.adler32()";
            final String r105 = "ADLER_32";
            final int r106 = 1;
            ChecksumType r107 = new AnonymousClass2(r105, r106, r104);
            ADLER_32 = r107;
            f275567a = new ChecksumType[]{r103, r107};
        }

        public static ChecksumType[] values() {
            return (ChecksumType[]) f275567a.clone();
        }

        public static ChecksumType valueOf(String r100) {
            return (ChecksumType) r27.a.a(ChecksumType.class, r100);
        }

        public ChecksumType(String r100, int r101, String r102) {
            super(r100, r101);
            this.hashFunction = new ChecksumHashFunction(this, 32, r102);
        }

        public /* synthetic */ ChecksumType(String r100, int r101, String r102, a r103) {
            this(r100, r101, r102);
        }
    }

    public static /* synthetic */ class a {
    }

    static {
        f275566a = (int) System.currentTimeMillis();
    }
}
