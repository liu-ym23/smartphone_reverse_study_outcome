package com.bytedance.ee.bear.contract.route.parcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.wikiv2.home.api.DisplayTag;

/* JADX INFO: loaded from: classes16.dex */
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

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f217149a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f217150b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f217151c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f217152d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f217153e;

        public class a implements Parcelable.Creator<SpaceCover> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final SpaceCover createFromParcel(Parcel r100) {
                return new SpaceCover(r100);
            }

            @Override // android.os.Parcelable.Creator
            public final SpaceCover[] newArray(int r100) {
                return new SpaceCover[r100];
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

        public SpaceCover(Parcel r100) {
            this.f217149a = r100.readString();
            this.f217150b = r100.readString();
            this.f217151c = r100.readString();
            if (r100.readByte() == 0) goto L5;
            boolean r101 = true;
        L6:
            this.f217152d = r101;
            this.f217153e = r100.readString();
            return;
        L5:
            r101 = false;
            goto L6
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r100, int r101) {
            r100.writeString(this.f217149a);
            r100.writeString(this.f217150b);
            r100.writeString(this.f217151c);
            r100.writeByte(this.f217152d ? 1 : 0);
            r100.writeString(this.f217153e);
        }
    }

    public class a implements Parcelable.Creator<WikiDocument> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final WikiDocument createFromParcel(Parcel r100) {
            return new WikiDocument(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final WikiDocument[] newArray(int r100) {
            return new WikiDocument[r100];
        }
    }

    @Override // com.bytedance.ee.bear.list.dto.Document, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public WikiDocument() {
    }

    public WikiDocument(Parcel r100) {
        super(r100);
        this.N2 = r100.readString();
        this.O2 = r100.readInt();
        this.P2 = r100.readString();
        this.Q2 = r100.readString();
        this.R2 = (SpaceCover) r100.readParcelable(SpaceCover.class.getClassLoader());
        this.S2 = r100.readString();
        this.T2 = r100.readInt();
        this.U2 = r100.readInt();
        this.V2 = r100.readInt();
        this.W2 = (DisplayTag) r100.readSerializable();
    }

    @Override // com.bytedance.ee.bear.list.dto.Document
    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L20:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L20;
        WikiDocument r101 = (WikiDocument) r100;
        if (TextUtils.isEmpty(this.Q2) == true) goto L20;
        if (TextUtils.isEmpty(r101.Q2) == true) goto L20;
        if (lbb.a.a(this.Q2) == true) goto L20;
        if (lbb.a.a(r101.Q2) == true) goto L20;
        return TextUtils.equals(this.Q2, r101.Q2);
    }

    @Override // com.bytedance.ee.bear.list.dto.Document, android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
        r100.writeString(this.N2);
        r100.writeInt(this.O2);
        r100.writeString(this.P2);
        r100.writeString(this.Q2);
        r100.writeParcelable(this.R2, r101);
        r100.writeString(this.S2);
        r100.writeInt(this.T2);
        r100.writeInt(this.U2);
        r100.writeInt(this.V2);
        r100.writeSerializable(this.W2);
    }
}
