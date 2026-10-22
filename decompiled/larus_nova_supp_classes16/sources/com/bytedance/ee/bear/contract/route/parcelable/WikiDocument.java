package com.bytedance.ee.bear.contract.route.parcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.wikiv2.home.api.DisplayTag;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class WikiDocument extends Document {
    public static final Parcelable.Creator<WikiDocument> CREATOR = null;
    public final String N2;
    public int O2;
    public String P2;
    public String Q2;
    public SpaceCover R2;
    public final String S2;
    public final int T2;
    public int U2;
    public int V2;
    public DisplayTag W2;

    public static class SpaceCover implements Parcelable {
        public static final Parcelable.Creator<SpaceCover> CREATOR = null;
        public String a;
        public String b;
        public String c;
        public boolean d;
        public String e;

        public class a implements Parcelable.Creator<SpaceCover> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final SpaceCover createFromParcel(Parcel r2) {
                return new SpaceCover(r2);
            }

            @Override // android.os.Parcelable.Creator
            public final SpaceCover[] newArray(int r1) {
                return new SpaceCover[r1];
            }
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        static {
            CREATOR = new a();
        }

        public SpaceCover() {
        }

        public SpaceCover(Parcel r2) {
            this.a = r2.readString();
            this.b = r2.readString();
            this.c = r2.readString();
            if (r2.readByte() == 0) goto L5;
            boolean r0 = true;
        L6:
            this.d = r0;
            this.e = r2.readString();
            return;
        L5:
            r0 = false;
            goto L6
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r1, int r2) {
            r1.writeString(this.a);
            r1.writeString(this.b);
            r1.writeString(this.c);
            r1.writeByte(this.d ? 1 : 0);
            r1.writeString(this.e);
        }
    }

    public class a implements Parcelable.Creator<WikiDocument> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final WikiDocument createFromParcel(Parcel r2) {
            return new WikiDocument(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final WikiDocument[] newArray(int r1) {
            return new WikiDocument[r1];
        }
    }

    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public WikiDocument() {
    }

    public WikiDocument(Parcel r2) {
        super(r2);
        this.N2 = r2.readString();
        this.O2 = r2.readInt();
        this.P2 = r2.readString();
        this.Q2 = r2.readString();
        this.R2 = (SpaceCover) r2.readParcelable(SpaceCover.class.getClassLoader());
        this.S2 = r2.readString();
        this.T2 = r2.readInt();
        this.U2 = r2.readInt();
        this.V2 = r2.readInt();
        this.W2 = r2.readSerializable();
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if (r4 != null) goto L8;
    L20:
        return false;
    L8:
        if (getClass() != r4.getClass()) goto L20;
        WikiDocument r5 = (WikiDocument) r4;
        if (TextUtils.isEmpty(this.Q2) == true) goto L20;
        if (TextUtils.isEmpty(r5.Q2) == true) goto L20;
        if (lbb.a.a(this.Q2) == true) goto L20;
        if (lbb.a.a(r5.Q2) == true) goto L20;
        return TextUtils.equals(this.Q2, r5.Q2);
    }

    public final void writeToParcel(Parcel r2, int r3) {
        super.writeToParcel(r2, r3);
        r2.writeString(this.N2);
        r2.writeInt(this.O2);
        r2.writeString(this.P2);
        r2.writeString(this.Q2);
        r2.writeParcelable(this.R2, r3);
        r2.writeString(this.S2);
        r2.writeInt(this.T2);
        r2.writeInt(this.U2);
        r2.writeInt(this.V2);
        r2.writeSerializable(this.W2);
    }
}
