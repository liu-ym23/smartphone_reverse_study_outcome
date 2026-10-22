package org.bouncycastle.crypto.util;

import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final class DERMacData {
    private final byte[] macData;

    /* JADX INFO: renamed from: org.bouncycastle.crypto.util.DERMacData$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$bouncycastle$crypto$util$DERMacData$Type = null;

        static {
            int[] r100 = new int[Type.values().length];
            $SwitchMap$org$bouncycastle$crypto$util$DERMacData$Type = r100;
            r100[Type.UNILATERALU.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$org$bouncycastle$crypto$util$DERMacData$Type[Type.BILATERALU.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$org$bouncycastle$crypto$util$DERMacData$Type[Type.UNILATERALV.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$org$bouncycastle$crypto$util$DERMacData$Type[Type.BILATERALV.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public static final class Builder {
        private ASN1OctetString ephemDataU;
        private ASN1OctetString ephemDataV;
        private ASN1OctetString idU;
        private ASN1OctetString idV;
        private byte[] text;
        private final Type type;

        public Builder(Type r100, byte[] r101, byte[] r102, byte[] r103, byte[] r104) {
            this.type = r100;
            this.idU = DerUtil.getOctetString(r101);
            this.idV = DerUtil.getOctetString(r102);
            this.ephemDataU = DerUtil.getOctetString(r103);
            this.ephemDataV = DerUtil.getOctetString(r104);
        }

        private byte[] concatenate(byte[] r100, byte[] r101, byte[] r102, byte[] r103, byte[] r104, byte[] r105) {
            return Arrays.concatenate(Arrays.concatenate(r100, r101, r102), Arrays.concatenate(r103, r104, r105));
        }

        public DERMacData build() {
            int r100 = AnonymousClass1.$SwitchMap$org$bouncycastle$crypto$util$DERMacData$Type[this.type.ordinal()];
            AnonymousClass1 r101 = null;
            if (r100 == 1) goto L16;
            if (r100 == 2) goto L16;
            if (r100 == 3) goto L14;
            if (r100 == 4) goto L14;
            throw new IllegalStateException("Unknown type encountered in build");
        L14:
            return new DERMacData(concatenate(this.type.getHeader(), DerUtil.toByteArray(this.idV), DerUtil.toByteArray(this.idU), DerUtil.toByteArray(this.ephemDataV), DerUtil.toByteArray(this.ephemDataU), this.text), r101);
        L16:
            return new DERMacData(concatenate(this.type.getHeader(), DerUtil.toByteArray(this.idU), DerUtil.toByteArray(this.idV), DerUtil.toByteArray(this.ephemDataU), DerUtil.toByteArray(this.ephemDataV), this.text), r101);
        }

        public Builder withText(byte[] r100) {
            this.text = DerUtil.toByteArray(new DERTaggedObject(false, 0, DerUtil.getOctetString(r100)));
            return this;
        }
    }

    public static final enum Type extends Enum<Type> {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final Type BILATERALU = null;
        public static final Type BILATERALV = null;
        public static final Type UNILATERALU = null;
        public static final Type UNILATERALV = null;

        /* JADX INFO: renamed from: enc, reason: collision with root package name */
        private final String f525345enc;

        static {
            Type r100 = new Type("UNILATERALU", 0, "KC_1_U");
            UNILATERALU = r100;
            Type r101 = new Type("UNILATERALV", 1, "KC_1_V");
            UNILATERALV = r101;
            Type r102 = new Type("BILATERALU", 2, "KC_2_U");
            BILATERALU = r102;
            Type r103 = new Type("BILATERALV", 3, "KC_2_V");
            BILATERALV = r103;
            $VALUES = new Type[]{r100, r101, r102, r103};
        }

        private Type(String r100, int r101, String r102) {
            super(r100, r101);
            this.f525345enc = r102;
        }

        public static Type valueOf(String r100) {
            return (Type) a.a(Type.class, r100);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        public byte[] getHeader() {
            return Strings.toByteArray(this.f525345enc);
        }
    }

    private DERMacData(byte[] r100) {
        this.macData = r100;
    }

    public /* synthetic */ DERMacData(byte[] r100, AnonymousClass1 r101) {
        this(r100);
    }

    public byte[] getMacData() {
        return Arrays.clone(this.macData);
    }
}
