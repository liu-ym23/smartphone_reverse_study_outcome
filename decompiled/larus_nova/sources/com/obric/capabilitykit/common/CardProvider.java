package com.obric.capabilitykit.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.alipay.sdk.m.x.d;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\b\u0010\u0016\u001a\u00020\u0005H\u0016J\b\u0010\u0017\u001a\u00020\u0003H\u0016J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0005H\u0016R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001e"}, d2 = {"Lcom/obric/capabilitykit/common/CardProvider;", "Landroid/os/Parcelable;", "cardUri", "", "viewHeight", "", "title", "extraParams", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getCardUri", "()Ljava/lang/String;", "setCardUri", "(Ljava/lang/String;)V", "getExtraParams", "setExtraParams", "getTitle", d.f25925o, "getViewHeight", "()Ljava/lang/Integer;", "setViewHeight", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "describeContents", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CardProvider implements Parcelable {
    public static final a CREATOR = null;
    private String cardUri;
    private String extraParams;
    private String title;
    private Integer viewHeight;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<CardProvider> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final CardProvider createFromParcel(Parcel r100) {
            int r101 = r100.readInt();
            Intrinsics.checkNotNullParameter(r100, "parcel");
            String r102 = r100.readString();
            Object r103 = r100.readValue(Integer.TYPE.getClassLoader());
            if ((r103 instanceof Integer) == false) goto L5;
            Integer r104 = (Integer) r103;
        L6:
            CardProvider r105 = new CardProvider(r102, r104, r100.readString(), r100.readString());
            int r106 = Math.min(r101, 0);
            ClassLoader r107 = a.class.getClassLoader();
            int r108 = 1;
        L7:
            if (r108 > r106) goto L9;
            r108 = r108 + 1;
        L9:
            if (r108 > r101) goto L11;
            joa.a.d(r100, r107);
            r108 = r108 + 1;
            goto L9
        L11:
            return r105;
        L5:
            r104 = null;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final CardProvider[] newArray(int r100) {
            return new CardProvider[r100];
        }
    }

    public CardProvider() {
        this(null, null, null, null, 15, null);
    }

    public CardProvider(String r100, Integer r101, String r102, String r103) {
        this.cardUri = r100;
        this.viewHeight = r101;
        this.title = r102;
        this.extraParams = r103;
    }

    public /* synthetic */ CardProvider(String r100, Integer r101, String r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String getCardUri() {
        return this.cardUri;
    }

    public final String getExtraParams() {
        return this.extraParams;
    }

    public final String getTitle() {
        return this.title;
    }

    public final Integer getViewHeight() {
        return this.viewHeight;
    }

    public final void setCardUri(String r100) {
        this.cardUri = r100;
    }

    public final void setExtraParams(String r100) {
        this.extraParams = r100;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }

    public final void setViewHeight(Integer r100) {
        this.viewHeight = r100;
    }

    public String toString() {
        return "CardProvider(cardUri=" + this.cardUri + ", viewHeight=" + this.viewHeight + ", title=" + this.title + ", extraParams=" + this.extraParams + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(0);
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeString(this.cardUri);
        r100.writeValue(this.viewHeight);
        r100.writeString(this.title);
        r100.writeString(this.extraParams);
    }

    static {
        CREATOR = new a();
    }
}
