package com.obric.capabilitykit.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.RemoteViews;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000  2\u00020\u0001:\u0001 BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\nJ\b\u0010\u0018\u001a\u00020\u0005H\u0016J\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003J\b\u0010\u001a\u001a\u00020\bH\u0016J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0005H\u0016R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u0014\u0010\f\"\u0004\b\u0015\u0010\u000eR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/obric/capabilitykit/common/CardView;", "Landroid/os/Parcelable;", "remoteViews", "Landroid/widget/RemoteViews;", "backBackgroundResId", "", "iconResId", "description", "", "frontPanelResId", "(Landroid/widget/RemoteViews;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)V", "getBackBackgroundResId", "()Ljava/lang/Integer;", "setBackBackgroundResId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "getFrontPanelResId", "setFrontPanelResId", "getIconResId", "setIconResId", "describeContents", "getContentViews", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CardView implements Parcelable {
    public static final a CREATOR = null;
    private Integer backBackgroundResId;
    private String description;
    private Integer frontPanelResId;
    private Integer iconResId;
    private RemoteViews remoteViews;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<CardView> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final CardView createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            RemoteViews r101 = (RemoteViews) r100.readParcelable(RemoteViews.class.getClassLoader());
            Class r102 = Integer.TYPE;
            Object r103 = r100.readValue(r102.getClassLoader());
            if ((r103 instanceof Integer) == false) goto L5;
            Integer r104 = (Integer) r103;
        L6:
            Object r105 = r100.readValue(r102.getClassLoader());
            if ((r105 instanceof Integer) == false) goto L9;
            Integer r106 = (Integer) r105;
        L10:
            String r107 = r100.readString();
            Object r108 = r100.readValue(r102.getClassLoader());
            if ((r108 instanceof Integer) == false) goto L13;
            Integer r109 = (Integer) r108;
        L15:
            return new CardView(r101, r104, r106, r107, r109);
        L13:
            r109 = null;
            goto L15
        L9:
            r106 = null;
            goto L10
        L5:
            r104 = null;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final CardView[] newArray(int r100) {
            return new CardView[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public CardView() {
        this(null, null, null, null, null, 31, null);
    }

    public CardView(RemoteViews r100, Integer r101, Integer r102, String r103, Integer r104) {
        this.remoteViews = r100;
        this.backBackgroundResId = r101;
        this.iconResId = r102;
        this.description = r103;
        this.frontPanelResId = r104;
    }

    public /* synthetic */ CardView(RemoteViews r100, Integer r101, Integer r102, String r103, Integer r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        RemoteViews r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        Integer r105 = null;
    L11:
        if ((r110 & 4) == 0) goto L13;
        Integer r106 = null;
    L15:
        if ((r110 & 8) == 0) goto L17;
        String r107 = null;
    L19:
        if ((r110 & 16) == 0) goto L21;
        Integer r113 = null;
    L22:
        this(r112, r105, r106, r107, r113);
        return;
    L21:
        r113 = r104;
        goto L22
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final Integer getBackBackgroundResId() {
        return this.backBackgroundResId;
    }

    public final RemoteViews getContentViews() {
        return this.remoteViews;
    }

    public final String getDescription() {
        return this.description;
    }

    public final Integer getFrontPanelResId() {
        return this.frontPanelResId;
    }

    public final Integer getIconResId() {
        return this.iconResId;
    }

    public final void setBackBackgroundResId(Integer r100) {
        this.backBackgroundResId = r100;
    }

    public final void setDescription(String r100) {
        this.description = r100;
    }

    public final void setFrontPanelResId(Integer r100) {
        this.frontPanelResId = r100;
    }

    public final void setIconResId(Integer r100) {
        this.iconResId = r100;
    }

    public String toString() {
        return "CardView(remoteViews=" + this.remoteViews + ", backBackground=" + this.backBackgroundResId + ", icon=" + this.iconResId + ", description=" + this.description + ", frontPanel=" + this.frontPanelResId + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeParcelable(this.remoteViews, r101);
        r100.writeValue(this.backBackgroundResId);
        r100.writeValue(this.iconResId);
        r100.writeString(this.description);
        r100.writeValue(this.frontPanelResId);
    }
}
