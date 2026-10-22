package com.ss.android.lark.chat.entity.chat;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes35.dex */
public class AvatarMeta implements Parcelable {
    public static final Parcelable.Creator<AvatarMeta> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Type f415101a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final StyleType f415102b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f415103c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f415104d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f415105e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f415106f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f415107g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f415108h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f415109i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final CharSequence f415110j;

    public static final enum StyleType extends Enum<StyleType> {
        public static final StyleType BORDER = null;
        public static final StyleType FILL = null;
        public static final StyleType UNKNOWN_STYLE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ StyleType[] f415111a = null;
        private final int value;

        static {
            StyleType r100 = new StyleType("UNKNOWN_STYLE", 0, 0);
            UNKNOWN_STYLE = r100;
            StyleType r101 = new StyleType("FILL", 1, 1);
            FILL = r101;
            StyleType r102 = new StyleType("BORDER", 2, 2);
            BORDER = r102;
            f415111a = new StyleType[]{r100, r101, r102};
        }

        public static StyleType[] values() {
            return (StyleType[]) f415111a.clone();
        }

        public int getValue() {
            return this.value;
        }

        public static /* synthetic */ int access$100(StyleType r100) {
            return r100.value;
        }

        public static StyleType fromValue(int r100) {
            if (r100 == 1) goto L11;
            if (r100 == 2) goto L9;
            return UNKNOWN_STYLE;
        L9:
            return BORDER;
        L11:
            return FILL;
        }

        public static StyleType valueOf(String r100) {
            return (StyleType) r27.a.a(StyleType.class, r100);
        }

        public StyleType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum Type extends Enum<Type> {
        public static final Type COLLAGE = null;
        public static final Type RANDOM = null;
        public static final Type UNKNOWN = null;
        public static final Type UPLOAD = null;
        public static final Type WORDS = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Type[] f415112a = null;
        private final int value;

        static {
            Type r100 = new Type("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            Type r101 = new Type("RANDOM", 1, 1);
            RANDOM = r101;
            Type r102 = new Type("WORDS", 2, 2);
            WORDS = r102;
            Type r103 = new Type("UPLOAD", 3, 3);
            UPLOAD = r103;
            Type r104 = new Type("COLLAGE", 4, 4);
            COLLAGE = r104;
            f415112a = new Type[]{r100, r101, r102, r103, r104};
        }

        public static Type[] values() {
            return (Type[]) f415112a.clone();
        }

        public int getValue() {
            return this.value;
        }

        public static /* synthetic */ int access$000(Type r100) {
            return r100.value;
        }

        public static Type fromValue(int r100) {
            if (r100 == 1) goto L19;
            if (r100 == 2) goto L17;
            if (r100 == 3) goto L15;
            if (r100 == 4) goto L13;
            return UNKNOWN;
        L13:
            return COLLAGE;
        L15:
            return UPLOAD;
        L17:
            return WORDS;
        L19:
            return RANDOM;
        }

        public static Type valueOf(String r100) {
            return (Type) r27.a.a(Type.class, r100);
        }

        public Type(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public class a implements Parcelable.Creator<AvatarMeta> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final AvatarMeta createFromParcel(Parcel r100) {
            return new AvatarMeta(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final AvatarMeta[] newArray(int r100) {
            return new AvatarMeta[r100];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public final String toString() {
        return "AvatarMeta{type=" + this.f415101a + ", styleType=" + this.f415102b + ", color=" + this.f415103c + ", borderColor=" + this.f415105e + ", backgroundColor=" + this.f415106f + ", centerColor=" + this.f415107g + "', startColor=" + this.f415108h + "', endColor=" + this.f415109i + "'}";
    }

    public AvatarMeta() {
    }

    public Type getType() {
        return this.f415101a;
    }

    public AvatarMeta(Parcel r100) {
        this.f415101a = Type.fromValue(r100.readInt());
        this.f415102b = StyleType.fromValue(r100.readInt());
        this.f415103c = r100.readInt();
        this.f415104d = r100.readString();
        this.f415105e = r100.readInt();
        this.f415106f = r100.readInt();
        this.f415107g = r100.readInt();
        this.f415108h = r100.readInt();
        this.f415109i = r100.readInt();
        this.f415110j = r100.readString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(Type.access$000(this.f415101a));
        StyleType r102 = this.f415102b;
        if (r102 != null) goto L5;
        int r103 = 0;
    L6:
        r100.writeInt(r103);
        r100.writeInt(this.f415103c);
        r100.writeString(this.f415104d);
        r100.writeInt(this.f415105e);
        r100.writeInt(this.f415106f);
        r100.writeInt(this.f415107g);
        r100.writeInt(this.f415108h);
        r100.writeInt(this.f415109i);
        CharSequence r104 = this.f415110j;
        if (r104 != null) goto L9;
        String r105 = null;
    L10:
        r100.writeString(r105);
        return;
    L9:
        r105 = ((String) r104).toString();
        goto L10
    L5:
        r103 = StyleType.access$100(r102);
        goto L6
    }
}
