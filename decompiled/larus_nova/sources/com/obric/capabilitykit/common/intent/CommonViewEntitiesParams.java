package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.obric.capabilitykit.entity.app.AppEntity;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B#\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0016\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\nJ,\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0016J\t\u0010\u0017\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0004HÖ\u0001J\u0012\u0010\u001d\u001a\u00020\u00012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001bH\u0016J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\u0019\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0004HÖ\u0001R$\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006&"}, d2 = {"Lcom/obric/capabilitykit/common/intent/CommonViewEntitiesParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "index", "", "entities", "", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "(Ljava/lang/Integer;[Lcom/obric/capabilitykit/entity/app/AppEntity;)V", "getEntities", "()[Lcom/obric/capabilitykit/entity/app/AppEntity;", "setEntities", "([Lcom/obric/capabilitykit/entity/app/AppEntity;)V", "[Lcom/obric/capabilitykit/entity/app/AppEntity;", "getIndex", "()Ljava/lang/Integer;", "setIndex", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/Integer;[Lcom/obric/capabilitykit/entity/app/AppEntity;)Lcom/obric/capabilitykit/common/intent/CommonViewEntitiesParams;", "describeContents", "equals", "", "other", "", "hashCode", "mergeParams", "params", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CommonViewEntitiesParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<CommonViewEntitiesParams> CREATOR = null;
    private AppEntity[] entities;
    private Integer index;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<CommonViewEntitiesParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final CommonViewEntitiesParams createFromParcel(Parcel r100) {
            int r101 = r100.readInt();
            Intrinsics.checkNotNullParameter(r100, "parcel");
            AppEntity[] r102 = null;
            if (r100.readInt() != 0) goto L5;
            Integer r103 = null;
        L7:
            if (r100.readInt() == 0) goto L13;
            int r104 = r100.readInt();
            AppEntity[] r105 = new AppEntity[r104];
            int r106 = 0;
        L10:
            if (r106 == r104) goto L12;
            r105[r106] = (AppEntity) r100.readParcelable(CommonViewEntitiesParams.class.getClassLoader());
            r106 = r106 + 1;
            goto L10
        L12:
            r102 = r105;
        L13:
            CommonViewEntitiesParams r107 = new CommonViewEntitiesParams(r103, r102);
            int r108 = Math.min(r101, 0);
            ClassLoader r109 = a.class.getClassLoader();
            int r110 = 1;
        L14:
            if (r110 > r108) goto L16;
            r110 = r110 + 1;
        L16:
            if (r110 > r101) goto L18;
            joa.a.d(r100, r109);
            r110 = r110 + 1;
            goto L16
        L18:
            return r107;
        L5:
            r103 = Integer.valueOf(r100.readInt());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final CommonViewEntitiesParams[] newArray(int r100) {
            return new CommonViewEntitiesParams[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CommonViewEntitiesParams() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ CommonViewEntitiesParams copy$default(CommonViewEntitiesParams r100, Integer r101, AppEntity[] r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.index;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.entities;
    L9:
        return r100.copy(r101, r102);
    }

    public final Integer component1() {
        return this.index;
    }

    public final AppEntity[] component2() {
        return this.entities;
    }

    public final CommonViewEntitiesParams copy(Integer r100, AppEntity[] r101) {
        return new CommonViewEntitiesParams(r100, r101);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CommonViewEntitiesParams) == true) goto L8;
        return false;
    L8:
        CommonViewEntitiesParams r101 = (CommonViewEntitiesParams) r100;
        if (Intrinsics.areEqual(this.index, r101.index) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.entities, r101.entities) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public String getSubActionValue() {
        return null;
    }

    public int hashCode() {
        Integer r100 = this.index;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        AppEntity[] r104 = this.entities;
        if (r104 == null) goto L11;
        r101 = Arrays.hashCode(r104);
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public boolean isParamsCompleted() {
        return true;
    }

    public String toString() {
        return "CommonViewEntitiesParams(index=" + this.index + ", entities=" + Arrays.toString(this.entities) + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        int r102 = 0;
        r100.writeInt(0);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        Integer r103 = this.index;
        if (r103 != null) goto L5;
        r100.writeInt(0);
    L6:
        AppEntity[] r104 = this.entities;
        if (r104 != null) goto L9;
        r100.writeInt(0);
        return;
    L9:
        r100.writeInt(1);
        int r105 = r104.length;
        r100.writeInt(r105);
    L10:
        if (r102 == r105) goto L14;
        r100.writeParcelable(r104[r102], r101);
        r102 = r102 + 1;
        goto L10
    L14:
        return;
    L5:
        r100.writeInt(1);
        r100.writeInt(r103.intValue());
        goto L6
    }

    public final AppEntity[] getEntities() {
        return this.entities;
    }

    public final Integer getIndex() {
        return this.index;
    }

    public IntentParams mergeParams(Object r100) {
        if ((r100 instanceof CommonViewEntitiesParams) == true) goto L5;
        return this;
    L5:
        Integer r101 = this.index;
        if (r101 != null) goto L8;
        r101 = ((CommonViewEntitiesParams) r100).index;
    L8:
        AppEntity[] r102 = this.entities;
        if (r102 != null) goto L12;
        r102 = ((CommonViewEntitiesParams) r100).entities;
    L12:
        return new CommonViewEntitiesParams(r101, r102);
    }

    public final void setEntities(AppEntity[] r100) {
        this.entities = r100;
    }

    public final void setIndex(Integer r100) {
        this.index = r100;
    }

    public CommonViewEntitiesParams(Integer r100, AppEntity[] r101) {
        this.index = r100;
        this.entities = r101;
    }

    public /* synthetic */ CommonViewEntitiesParams(Integer r100, AppEntity[] r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
