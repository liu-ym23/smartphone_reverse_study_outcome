package com.obric.capabilitykit.common;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB%\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0012H\u0016R&\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0002\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/obric/capabilitykit/common/RemoteCard;", "Landroid/os/Parcelable;", "isIndependent", "", "cardProviders", "", "Lcom/obric/capabilitykit/common/CardProvider;", "(Ljava/lang/Boolean;[Lcom/obric/capabilitykit/common/CardProvider;)V", "getCardProviders", "()[Lcom/obric/capabilitykit/common/CardProvider;", "setCardProviders", "([Lcom/obric/capabilitykit/common/CardProvider;)V", "[Lcom/obric/capabilitykit/common/CardProvider;", "()Ljava/lang/Boolean;", "setIndependent", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "describeContents", "", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class RemoteCard implements Parcelable {
    public static final a CREATOR = null;
    private CardProvider[] cardProviders;
    private Boolean isIndependent;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<RemoteCard> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final RemoteCard createFromParcel(Parcel r100) {
            int r101 = r100.readInt();
            Intrinsics.checkNotNullParameter(r100, "parcel");
            Object r102 = r100.readValue(CardProvider.class.getClassLoader());
            if ((r102 instanceof Boolean) == false) goto L5;
            Boolean r103 = (Boolean) r102;
        L6:
            int r104 = r100.readInt();
            CardProvider[] r105 = new CardProvider[r104];
            int r106 = 0;
        L7:
            if (r106 >= r104) goto L9;
            r105[r106] = (CardProvider) r100.readParcelable(CardProvider.class.getClassLoader());
            r106 = r106 + 1;
            goto L7
        L9:
            RemoteCard r107 = new RemoteCard(r103, r105);
            int r108 = Math.min(r101, 0);
            ClassLoader r109 = a.class.getClassLoader();
            int r110 = 1;
        L10:
            if (r110 > r108) goto L12;
            r110 = r110 + 1;
        L12:
            if (r110 > r101) goto L14;
            joa.a.d(r100, r109);
            r110 = r110 + 1;
            goto L12
        L14:
            return r107;
        L5:
            r103 = null;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final RemoteCard[] newArray(int r100) {
            return new RemoteCard[r100];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RemoteCard() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public RemoteCard(Boolean r100, CardProvider[] r101) {
        this.isIndependent = r100;
        this.cardProviders = r101;
    }

    public /* synthetic */ RemoteCard(Boolean r100, CardProvider[] r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = Boolean.TRUE;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final CardProvider[] getCardProviders() {
        return this.cardProviders;
    }

    public final Boolean isIndependent() {
        return this.isIndependent;
    }

    public final void setCardProviders(CardProvider[] r100) {
        this.cardProviders = r100;
    }

    public final void setIndependent(Boolean r100) {
        this.isIndependent = r100;
    }

    public String toString() {
        return "RemoteCard(isIndependent=" + this.isIndependent + ", cardProviders=" + Arrays.toString(this.cardProviders) + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        int r102 = 0;
        r100.writeInt(0);
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeValue(this.isIndependent);
        CardProvider[] r103 = this.cardProviders;
        if (r103 == null) goto L5;
        int r104 = r103.length;
    L6:
        r100.writeInt(r104);
        CardProvider[] r105 = this.cardProviders;
        if (r105 == null) goto L11;
        int r106 = r105.length;
    L9:
        if (r102 >= r106) goto L13;
        r100.writeParcelable(r105[r102], r101);
        r102 = r102 + 1;
        goto L9
    L13:
        return;
    L11:
        return;
    L5:
        r104 = 0;
        goto L6
    }

    static {
        CREATOR = new a();
    }
}
