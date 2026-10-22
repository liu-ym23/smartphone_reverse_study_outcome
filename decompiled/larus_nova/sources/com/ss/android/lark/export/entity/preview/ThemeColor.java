package com.ss.android.lark.export.entity.preview;

import androidx.exifinterface.media.ExifInterface;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001:\u0002\u001d\u001eB)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0005H\u0016J\u0006\u0010\u0016\u001a\u00020\u0000J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J0\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001¢\u0006\u0002\u0010\u001bJ\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001f"}, d2 = {"Lcom/ss/android/lark/export/entity/preview/ThemeColor;", "Ljava/io/Serializable;", "token", "", "value", "", "key", "Lcom/ss/android/lark/export/entity/preview/ThemeColor$Key;", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Lcom/ss/android/lark/export/entity/preview/ThemeColor$Key;)V", "getToken", "()Ljava/lang/String;", "getValue", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getKey", "()Lcom/ss/android/lark/export/entity/preview/ThemeColor$Key;", "equals", "", "other", "", "hashCode", "clone", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Lcom/ss/android/lark/export/entity/preview/ThemeColor$Key;)Lcom/ss/android/lark/export/entity/preview/ThemeColor;", "toString", "Key", "KeyType", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ThemeColor implements Serializable {
    private final Key key;
    private final String token;
    private final Integer value;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0096\u0002J\b\u0010\u0014\u001a\u00020\u0005H\u0016J\u0006\u0010\u0015\u001a\u00020\u0000J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J0\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u0010\u001aJ\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/export/entity/preview/ThemeColor$Key;", "Ljava/io/Serializable;", "type", "Lcom/ss/android/lark/export/entity/preview/ThemeColor$KeyType;", "value", "", "alpha", "<init>", "(Lcom/ss/android/lark/export/entity/preview/ThemeColor$KeyType;Ljava/lang/Integer;I)V", "getType", "()Lcom/ss/android/lark/export/entity/preview/ThemeColor$KeyType;", "getValue", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAlpha", "()I", "equals", "", "other", "", "hashCode", "clone", "component1", "component2", "component3", "copy", "(Lcom/ss/android/lark/export/entity/preview/ThemeColor$KeyType;Ljava/lang/Integer;I)Lcom/ss/android/lark/export/entity/preview/ThemeColor$Key;", "toString", "", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Key implements Serializable {
        private final int alpha;
        private final KeyType type;
        private final Integer value;

        public Key() {
            this(null, null, 0, 7, null);
        }

        public static /* synthetic */ Key copy$default(Key r100, KeyType r101, Integer r102, int r103, int r104, Object r105) {
            if ((r104 & 1) == 0) goto L6;
            r101 = r100.type;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r102 = r100.value;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r103 = r100.alpha;
        L12:
            return r100.copy(r101, r102, r103);
        }

        public final KeyType component1() {
            return this.type;
        }

        public final Integer component2() {
            return this.value;
        }

        public final int component3() {
            return this.alpha;
        }

        public final Key copy(KeyType r100, Integer r101, int r102) {
            return new Key(r100, r101, r102);
        }

        public String toString() {
            return "Key(type=" + this.type + ", value=" + this.value + ", alpha=" + this.alpha + ')';
        }

        public final Key clone() {
            return new Key(this.type, this.value, this.alpha);
        }

        public int hashCode() {
            KeyType r100 = this.type;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            Integer r104 = this.value;
            if (r104 == null) goto L10;
            r101 = r104.intValue();
        L10:
            return ((r103 + r101) * 31) + this.alpha;
        L5:
            r102 = 0;
            goto L6
        }

        public final int getAlpha() {
            return this.alpha;
        }

        public final KeyType getType() {
            return this.type;
        }

        public final Integer getValue() {
            return this.value;
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof Key) == true) goto L8;
            return false;
        L8:
            Key r101 = (Key) r100;
            if (this.type == r101.type) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.value, r101.value) == true) goto L15;
            return false;
        L15:
            if (this.alpha == r101.alpha) goto L17;
            return false;
        L17:
            return true;
        }

        public Key(KeyType r100, Integer r101, int r102) {
            this.type = r100;
            this.value = r101;
            this.alpha = r102;
        }

        public /* synthetic */ Key(KeyType r100, Integer r101, int r102, int r103, DefaultConstructorMarker r104) {
            if ((r103 & 1) == 0) goto L6;
            r100 = null;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r101 = null;
        L9:
            if ((r103 & 4) == 0) goto L11;
            r102 = 100;
        L11:
            this(r100, r101, r102);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\b\u0086\u0081\u0002\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0017B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0018"}, d2 = {"Lcom/ss/android/lark/export/entity/preview/ThemeColor$KeyType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "N", "B", ExifInterface.LONGITUDE_WEST, ExifInterface.GPS_DIRECTION_TRUE, "G", "L", "Y", ExifInterface.LATITUDE_SOUTH, "O", "R", "C", "V", "P", "I", "STATIC_WHITE", "Companion", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum KeyType extends Enum<KeyType> {
        public static final KeyType B = null;
        public static final KeyType C = null;
        public static final a Companion = null;
        public static final KeyType G = null;
        public static final KeyType I = null;
        public static final KeyType L = null;
        public static final KeyType N = null;
        public static final KeyType O = null;
        public static final KeyType P = null;
        public static final KeyType R = null;
        public static final KeyType S = null;
        public static final KeyType STATIC_WHITE = null;
        public static final KeyType T = null;
        public static final KeyType V = null;
        public static final KeyType W = null;
        public static final KeyType Y = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ KeyType[] f420669a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f420670b = null;
        private final int value;

        public static final class a {
            public a() {
            }

            public static KeyType a(Integer r100) {
                if (r100 != null) goto L5;
            L7:
                if (r100 != null) goto L10;
            L12:
                if (r100 != null) goto L15;
            L17:
                if (r100 != null) goto L20;
            L22:
                if (r100 != null) goto L25;
            L27:
                if (r100 != null) goto L30;
            L32:
                if (r100 != null) goto L35;
            L37:
                if (r100 != null) goto L40;
            L42:
                if (r100 != null) goto L45;
            L47:
                if (r100 != null) goto L50;
            L52:
                if (r100 != null) goto L55;
            L57:
                if (r100 != null) goto L60;
            L62:
                if (r100 != null) goto L65;
            L67:
                if (r100 != null) goto L70;
            L72:
                if (r100 != null) goto L75;
            L77:
                return null;
            L75:
                if (r100.intValue() != 14) goto L77;
                return KeyType.STATIC_WHITE;
            L70:
                if (r100.intValue() != 13) goto L72;
                return KeyType.I;
            L65:
                if (r100.intValue() != 12) goto L67;
                return KeyType.P;
            L60:
                if (r100.intValue() != 11) goto L62;
                return KeyType.V;
            L55:
                if (r100.intValue() != 10) goto L57;
                return KeyType.C;
            L50:
                if (r100.intValue() != 9) goto L52;
                return KeyType.R;
            L45:
                if (r100.intValue() != 8) goto L47;
                return KeyType.O;
            L40:
                if (r100.intValue() != 7) goto L42;
                return KeyType.S;
            L35:
                if (r100.intValue() != 6) goto L37;
                return KeyType.Y;
            L30:
                if (r100.intValue() != 5) goto L32;
                return KeyType.L;
            L25:
                if (r100.intValue() != 4) goto L27;
                return KeyType.G;
            L20:
                if (r100.intValue() != 3) goto L22;
                return KeyType.T;
            L15:
                if (r100.intValue() != 2) goto L17;
                return KeyType.W;
            L10:
                if (r100.intValue() != 1) goto L12;
                return KeyType.B;
            L5:
                if (r100.intValue() != 0) goto L7;
                return KeyType.N;
            }
        }

        public static EnumEntries<KeyType> getEntries() {
            return f420670b;
        }

        static {
            KeyType r100 = new KeyType("N", 0, 0);
            N = r100;
            KeyType r101 = new KeyType("B", 1, 1);
            B = r101;
            KeyType r102 = new KeyType(ExifInterface.LONGITUDE_WEST, 2, 2);
            W = r102;
            KeyType r103 = new KeyType(ExifInterface.GPS_DIRECTION_TRUE, 3, 3);
            T = r103;
            KeyType r104 = new KeyType("G", 4, 4);
            G = r104;
            KeyType r105 = new KeyType("L", 5, 5);
            L = r105;
            KeyType r110 = new KeyType("Y", 6, 6);
            Y = r110;
            KeyType r111 = new KeyType(ExifInterface.LATITUDE_SOUTH, 7, 7);
            S = r111;
            KeyType r112 = new KeyType("O", 8, 8);
            O = r112;
            KeyType r113 = new KeyType("R", 9, 9);
            R = r113;
            KeyType r114 = new KeyType("C", 10, 10);
            C = r114;
            KeyType r115 = new KeyType("V", 11, 11);
            V = r115;
            KeyType r106 = new KeyType("P", 12, 12);
            P = r106;
            KeyType r107 = new KeyType("I", 13, 13);
            I = r107;
            KeyType r108 = new KeyType("STATIC_WHITE", 14, 14);
            STATIC_WHITE = r108;
            KeyType[] r109 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108};
            f420669a = r109;
            f420670b = EnumEntriesKt.enumEntries(r109);
            Companion = new a();
        }

        public static KeyType[] values() {
            return (KeyType[]) f420669a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static KeyType valueOf(String r100) {
            return (KeyType) r27.a.a(KeyType.class, r100);
        }

        public KeyType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public ThemeColor() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ ThemeColor copy$default(ThemeColor r100, String r101, Integer r102, Key r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.token;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.value;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.key;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.token;
    }

    public final Integer component2() {
        return this.value;
    }

    public final Key component3() {
        return this.key;
    }

    public final ThemeColor copy(String r100, Integer r101, Key r102) {
        Intrinsics.checkNotNullParameter(r102, "key");
        return new ThemeColor(r100, r101, r102);
    }

    public String toString() {
        return "ThemeColor(token=" + this.token + ", value=" + this.value + ", key=" + this.key + ')';
    }

    public final ThemeColor clone() {
        return new ThemeColor(this.token, this.value, this.key);
    }

    public int hashCode() {
        String r100 = this.token;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.value;
        if (r104 == null) goto L10;
        r101 = r104.intValue();
    L10:
        return ((r103 + r101) * 31) + this.key.hashCode();
    L5:
        r102 = 0;
        goto L6
    }

    public final Key getKey() {
        return this.key;
    }

    public final String getToken() {
        return this.token;
    }

    public final Integer getValue() {
        return this.value;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ThemeColor) == true) goto L8;
        return false;
    L8:
        ThemeColor r101 = (ThemeColor) r100;
        if (Intrinsics.areEqual(this.token, r101.token) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.value, r101.value) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.key, r101.key) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public ThemeColor(String r100, Integer r101, Key r102) {
        Intrinsics.checkNotNullParameter(r102, "key");
        this.token = r100;
        this.value = r101;
        this.key = r102;
    }

    public /* synthetic */ ThemeColor(String r100, Integer r101, Key r102, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r110 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r110 & 4) == 0) goto L11;
        r102 = new Key(null, null, 0, 7, null);
    L11:
        this(r100, r101, r102);
    }
}
