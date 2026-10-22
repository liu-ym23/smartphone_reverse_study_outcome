package com.larus.profile.api.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.platform.api.creation.UserCreation;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\bHÆ\u0003J1\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0006\u0010\u0019\u001a\u00020\u0003J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020\bHÖ\u0001J\u0016\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0003R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR&\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006%"}, d2 = {"Lcom/larus/profile/api/bean/UserCreationModel;", "Landroid/os/Parcelable;", "dataType", "", "creationList", "", "Lcom/larus/platform/api/creation/UserCreation;", "modelId", "", "<init>", "(ILjava/util/List;Ljava/lang/String;)V", "getDataType", "()I", "getCreationList", "()Ljava/util/List;", "setCreationList", "(Ljava/util/List;)V", "getModelId", "()Ljava/lang/String;", "setModelId", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UserCreationModel implements Parcelable {
    public static final Parcelable.Creator<UserCreationModel> CREATOR = null;

    @SerializedName("creation_list")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private List<UserCreation> creationList;

    @SerializedName("data_type")
    private final int dataType;

    @SerializedName("model_id")
    private String modelId;

    public static final class a implements Parcelable.Creator<UserCreationModel> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final UserCreationModel createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            int r101 = r100.readInt();
            if (r100.readInt() != 0) goto L5;
            ArrayList r102 = null;
        L10:
            return new UserCreationModel(r101, r102, r100.readString());
        L5:
            int r103 = r100.readInt();
            ArrayList r104 = new ArrayList(r103);
            int r105 = 0;
        L6:
            if (r105 == r103) goto L8;
            r104.add(r100.readParcelable(UserCreationModel.class.getClassLoader()));
            r105 = r105 + 1;
            goto L6
        L8:
            r102 = r104;
            goto L10
        }

        @Override // android.os.Parcelable.Creator
        public final UserCreationModel[] newArray(int r100) {
            return new UserCreationModel[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public UserCreationModel() {
        int r100 = 0;
        Object[] r101 = 0 == true ? 1 : 0;
        this(r100, null, r101, 7);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof UserCreationModel) == true) goto L8;
        return false;
    L8:
        UserCreationModel r101 = (UserCreationModel) r100;
        if (this.dataType == r101.dataType) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.creationList, r101.creationList) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.modelId, r101.modelId) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.dataType * 31;
        List<UserCreation> r101 = this.creationList;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.modelId;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "UserCreationModel(dataType=" + this.dataType + ", creationList=" + this.creationList + ", modelId=" + this.modelId + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeInt(this.dataType);
        List<UserCreation> r102 = this.creationList;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L9:
        r100.writeString(this.modelId);
        return;
    L5:
        r100.writeInt(1);
        r100.writeInt(r102.size());
        Iterator<UserCreation> r103 = r102.iterator();
    L7:
        if (r103.hasNext() == false) goto L9;
        r100.writeParcelable(r103.next(), r101);
        goto L7
    }

    public final List<UserCreation> b() {
        return this.creationList;
    }

    public final int c() {
        return this.dataType;
    }

    public final String d() {
        return this.modelId;
    }

    public final void e(List<UserCreation> r100) {
        this.creationList = r100;
    }

    public final void g(String r100) {
        this.modelId = r100;
    }

    public static UserCreationModel a(UserCreationModel r100, List r101) {
        int r102 = r100.dataType;
        String r103 = r100.modelId;
        r100.getClass();
        return new UserCreationModel(r102, r101, r103);
    }

    public UserCreationModel(int r100, List<UserCreation> r101, String r102) {
        this.dataType = r100;
        this.creationList = r101;
        this.modelId = r102;
    }

    public /* synthetic */ UserCreationModel(int r100, List r101, String r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = new ArrayList();
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = "";
    L11:
        this(r100, r101, r102);
    }
}
