package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.common.CardProvider;
import com.obric.capabilitykit.entity.app.AppEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 &2\u00020\u0001:\u0001&B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003J?\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tHÆ\u0001J\u0006\u0010\u001a\u001a\u00020\u0003J\u0013\u0010\u001b\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\u0016\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0013R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0013¨\u0006'"}, d2 = {"Lcom/obric/aiagent/assistant/idl/bean/AppIntentCardData;", "Landroid/os/Parcelable;", "type", "", "appEntity", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "cardProvider", "Lcom/obric/capabilitykit/common/CardProvider;", "isDeleted", "", "isRefreshed", "<init>", "(ILcom/obric/capabilitykit/entity/app/AppEntity;Lcom/obric/capabilitykit/common/CardProvider;ZZ)V", "getType", "()I", "getAppEntity", "()Lcom/obric/capabilitykit/entity/app/AppEntity;", "getCardProvider", "()Lcom/obric/capabilitykit/common/CardProvider;", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppIntentCardData implements Parcelable {
    public static final Parcelable.Creator<AppIntentCardData> CREATOR = null;
    public static final a Companion = null;
    public static final int TYPE_ENTITY = 0;
    public static final int TYPE_REMOTE = 1;
    private final AppEntity appEntity;
    private final CardProvider cardProvider;
    private final boolean isDeleted;
    private final boolean isRefreshed;
    private final int type;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: loaded from: classes32.dex */
    public static final class b implements Parcelable.Creator<AppIntentCardData> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final AppIntentCardData createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            int r101 = r100.readInt();
            AppEntity r102 = (AppEntity) r100.readParcelable(AppIntentCardData.class.getClassLoader());
            CardProvider r103 = (CardProvider) r100.readParcelable(AppIntentCardData.class.getClassLoader());
            boolean r104 = false;
            if (r100.readInt() == 0) goto L5;
            boolean r105 = true;
        L7:
            if (r100.readInt() == 0) goto L10;
            r104 = true;
        L10:
            return new AppIntentCardData(r101, r102, r103, r105, r104);
        L5:
            r105 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final AppIntentCardData[] newArray(int r100) {
            return new AppIntentCardData[r100];
        }
    }

    static {
        Companion = new a();
        CREATOR = new b();
    }

    public static /* synthetic */ AppIntentCardData copy$default(AppIntentCardData r100, int r101, AppEntity r102, CardProvider r103, boolean r104, boolean r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.type;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.appEntity;
    L8:
        AppEntity r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.cardProvider;
    L11:
        CardProvider r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.isDeleted;
    L14:
        boolean r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.isRefreshed;
    L17:
        int r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final int component1() {
        return this.type;
    }

    public final AppEntity component2() {
        return this.appEntity;
    }

    public final CardProvider component3() {
        return this.cardProvider;
    }

    public final boolean component4() {
        return this.isDeleted;
    }

    public final boolean component5() {
        return this.isRefreshed;
    }

    public final AppIntentCardData copy(int r100, AppEntity r101, CardProvider r110, boolean r111, boolean r112) {
        return new AppIntentCardData(r100, r101, r110, r111, r112);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AppIntentCardData) == true) goto L8;
        return false;
    L8:
        AppIntentCardData r101 = (AppIntentCardData) r100;
        if (this.type == r101.type) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.appEntity, r101.appEntity) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.cardProvider, r101.cardProvider) == true) goto L18;
        return false;
    L18:
        if (this.isDeleted == r101.isDeleted) goto L21;
        return false;
    L21:
        if (this.isRefreshed == r101.isRefreshed) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r100 = this.type * 31;
        AppEntity r101 = this.appEntity;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        CardProvider r105 = this.cardProvider;
        if (r105 == null) goto L10;
        r102 = r105.hashCode();
    L10:
        int r106 = (r104 + r102) * 31;
        int r107 = 1231;
        if (this.isDeleted == false) goto L13;
        int r108 = 1231;
    L14:
        int r109 = (r106 + r108) * 31;
        if (this.isRefreshed == true) goto L19;
        r107 = 1237;
    L19:
        return r109 + r107;
    L13:
        r108 = 1237;
        goto L14
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "AppIntentCardData(type=" + this.type + ", appEntity=" + this.appEntity + ", cardProvider=" + this.cardProvider + ", isDeleted=" + this.isDeleted + ", isRefreshed=" + this.isRefreshed + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeInt(this.type);
        r100.writeParcelable(this.appEntity, r101);
        r100.writeParcelable(this.cardProvider, r101);
        r100.writeInt(this.isDeleted ? 1 : 0);
        r100.writeInt(this.isRefreshed ? 1 : 0);
    }

    public final AppEntity getAppEntity() {
        return this.appEntity;
    }

    public final CardProvider getCardProvider() {
        return this.cardProvider;
    }

    public final int getType() {
        return this.type;
    }

    public final boolean isDeleted() {
        return this.isDeleted;
    }

    public final boolean isRefreshed() {
        return this.isRefreshed;
    }

    public AppIntentCardData(int r100, AppEntity r101, CardProvider r102, boolean r103, boolean r104) {
        this.type = r100;
        this.appEntity = r101;
        this.cardProvider = r102;
        this.isDeleted = r103;
        this.isRefreshed = r104;
    }

    public /* synthetic */ AppIntentCardData(int r100, AppEntity r101, CardProvider r110, boolean r111, boolean r112, int r113, DefaultConstructorMarker r114) {
        if ((r113 & 2) == 0) goto L5;
        AppEntity r102 = null;
    L7:
        if ((r113 & 4) == 0) goto L9;
        CardProvider r103 = null;
    L11:
        if ((r113 & 8) == 0) goto L13;
        boolean r104 = false;
    L15:
        if ((r113 & 16) == 0) goto L17;
        boolean r105 = false;
    L18:
        this(r100, r102, r103, r104, r105);
        return;
    L17:
        r105 = r112;
        goto L18
    L13:
        r104 = r111;
        goto L15
    L9:
        r103 = r110;
        goto L11
    L5:
        r102 = r101;
        goto L7
    }
}
