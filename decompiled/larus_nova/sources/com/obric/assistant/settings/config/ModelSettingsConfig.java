package com.obric.assistant.settings.config;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u0011\u001a\u00020\u0005J\u0006\u0010\u0012\u001a\u00020\nJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0014\u001a\u00020\u0007J\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\tJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÂ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÂ\u0003J\u0011\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003J;\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0001J\u0006\u0010\u001b\u001a\u00020\u001cJ\u0013\u0010\u001d\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u001cHÖ\u0001J\t\u0010!\u001a\u00020\u0007HÖ\u0001J\u0016\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001cR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u0004\u001a\u00020\u00058\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006'"}, d2 = {"Lcom/obric/assistant/settings/config/ModelSettingsConfig;", "Landroid/os/Parcelable;", "queryWithPicTimeout", "", "modelSettingsEnable", "", "defaultModel", "", "modelSettingsList", "", "Lcom/obric/assistant/settings/config/ModelSettingsItem;", "<init>", "(JZLjava/lang/String;Ljava/util/List;)V", "getQueryWithPicTimeout", "()J", "getModelSettingsList", "()Ljava/util/List;", "isModelSettingsEnable", "getDefaultModel", "getModel", "key", "getModelList", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ModelSettingsConfig implements Parcelable {
    public static final Parcelable.Creator<ModelSettingsConfig> CREATOR = null;

    @SerializedName("default_model")
    private final String defaultModel;

    @SerializedName("model_settings_enable")
    private final boolean modelSettingsEnable;

    @SerializedName("model_settings_list")
    private final List<ModelSettingsItem> modelSettingsList;

    @SerializedName("query_with_pic_timeout")
    private final long queryWithPicTimeout;

    public static final class a implements Parcelable.Creator<ModelSettingsConfig> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ModelSettingsConfig createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            long r101 = r100.readLong();
            int r102 = 0;
            if (r100.readInt() == 0) goto L5;
            boolean r103 = true;
        L6:
            String r104 = r100.readString();
            if (r100.readInt() != 0) goto L9;
            ArrayList r105 = null;
        L13:
            return new ModelSettingsConfig(r101, r103, r104, r105);
        L9:
            int r106 = r100.readInt();
            r105 = new ArrayList(r106);
        L10:
            if (r102 == r106) goto L13;
            r105.add(ModelSettingsItem.CREATOR.createFromParcel(r100));
            r102 = r102 + 1;
            goto L10
        L5:
            r103 = false;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final ModelSettingsConfig[] newArray(int r100) {
            return new ModelSettingsConfig[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public ModelSettingsConfig() {
        this(0, false, null, null, 15, null);
    }

    private final boolean component2() {
        return this.modelSettingsEnable;
    }

    private final String component3() {
        return this.defaultModel;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ModelSettingsConfig copy$default(ModelSettingsConfig r100, long r101, boolean r102, String r110, List r111, int r112, Object r113) {
        if ((r112 & 1) == 0) goto L5;
        r101 = r100.queryWithPicTimeout;
    L5:
        long r103 = r101;
        if ((r112 & 2) == 0) goto L8;
        r102 = r100.modelSettingsEnable;
    L8:
        boolean r104 = r102;
        if ((r112 & 4) == 0) goto L11;
        r110 = r100.defaultModel;
    L11:
        String r105 = r110;
        if ((r112 & 8) == 0) goto L15;
        r111 = r100.modelSettingsList;
    L15:
        return r100.copy(r103, r104, r105, r111);
    }

    public final long component1() {
        return this.queryWithPicTimeout;
    }

    public final List<ModelSettingsItem> component4() {
        return this.modelSettingsList;
    }

    public final ModelSettingsConfig copy(long r100, boolean r110, String r111, List<ModelSettingsItem> r112) {
        return new ModelSettingsConfig(r100, r110, r111, r112);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ModelSettingsConfig) == true) goto L8;
        return false;
    L8:
        ModelSettingsConfig r101 = (ModelSettingsConfig) r100;
        if (this.queryWithPicTimeout == r101.queryWithPicTimeout) goto L12;
        return false;
    L12:
        if (this.modelSettingsEnable == r101.modelSettingsEnable) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.defaultModel, r101.defaultModel) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.modelSettingsList, r101.modelSettingsList) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        long r100 = this.queryWithPicTimeout;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        if (this.modelSettingsEnable == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r101 + r102) * 31;
        String r104 = this.defaultModel;
        int r105 = 0;
        if (r104 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r103 + r106) * 31;
        List<ModelSettingsItem> r108 = this.modelSettingsList;
        if (r108 == null) goto L15;
        r105 = r108.hashCode();
    L15:
        return r107 + r105;
    L9:
        r106 = r104.hashCode();
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public String toString() {
        return "ModelSettingsConfig(queryWithPicTimeout=" + this.queryWithPicTimeout + ", modelSettingsEnable=" + this.modelSettingsEnable + ", defaultModel=" + this.defaultModel + ", modelSettingsList=" + this.modelSettingsList + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeLong(this.queryWithPicTimeout);
        r100.writeInt(this.modelSettingsEnable ? 1 : 0);
        r100.writeString(this.defaultModel);
        List<ModelSettingsItem> r102 = this.modelSettingsList;
        if (r102 != null) goto L5;
        r100.writeInt(0);
        return;
    L5:
        r100.writeInt(1);
        r100.writeInt(r102.size());
        Iterator<ModelSettingsItem> r103 = r102.iterator();
    L7:
        if (r103.hasNext() == false) goto L11;
        r103.next().writeToParcel(r100, r101);
        goto L7
    }

    public final ModelSettingsItem getDefaultModel() {
        List<ModelSettingsItem> r100 = this.modelSettingsList;
        ModelSettingsItem r101 = null;
        if (r100 == null) goto L18;
        Iterator<T> r102 = r100.iterator();
    L6:
        if (r102.hasNext() == false) goto L13;
        Object r103 = r102.next();
        ModelSettingsItem r104 = (ModelSettingsItem) r103;
        String r105 = this.defaultModel;
        if (r105 != null) goto L11;
        r105 = "";
    L11:
        if (r104.isCurrent(r105) == false) goto L6;
    L14:
        ModelSettingsItem r106 = (ModelSettingsItem) r103;
        if (r106 == null) goto L18;
        r101 = r106;
    L21:
        if (r101 == null) goto L23;
        return r101;
    L23:
        return new ModelSettingsItem(0, null, null, 7, null);
    L13:
        r103 = null;
    L18:
        List<ModelSettingsItem> r107 = this.modelSettingsList;
        if (r107 == null) goto L21;
        r101 = (ModelSettingsItem) CollectionsKt.firstOrNull(r107);
        goto L21
    }

    public final List<ModelSettingsItem> getModelList() {
        List<ModelSettingsItem> r100 = this.modelSettingsList;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return CollectionsKt.emptyList();
    }

    public final boolean isModelSettingsEnable() {
        if (this.modelSettingsEnable == false) goto L13;
        List<ModelSettingsItem> r100 = this.modelSettingsList;
        if (r100 != null) goto L7;
    L9:
        boolean r101 = false;
    L10:
        if (r101 == false) goto L14;
        return true;
    L14:
        return false;
    L7:
        if ((!r100.isEmpty()) != true) goto L9;
        r101 = true;
        goto L10
    L13:
        return false;
    }

    public final List<ModelSettingsItem> getModelSettingsList() {
        return this.modelSettingsList;
    }

    public final long getQueryWithPicTimeout() {
        return this.queryWithPicTimeout;
    }

    public final ModelSettingsItem getModel(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        List<ModelSettingsItem> r101 = this.modelSettingsList;
        Object r102 = null;
        if (r101 == null) goto L15;
        Iterator<T> r103 = r101.iterator();
    L6:
        if (r103.hasNext() == false) goto L11;
        Object r104 = r103.next();
        if (((ModelSettingsItem) r104).isCurrent(r100) == false) goto L6;
        r102 = r104;
    L11:
        return (ModelSettingsItem) r102;
    L15:
        return null;
    }

    public ModelSettingsConfig(long r100, boolean r101, String r102, List<ModelSettingsItem> r103) {
        this.queryWithPicTimeout = r100;
        this.modelSettingsEnable = r101;
        this.defaultModel = r102;
        this.modelSettingsList = r103;
    }

    public /* synthetic */ ModelSettingsConfig(long r110, boolean r111, String r112, List r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 1) == 0) goto L5;
        long r100 = 5000;
    L7:
        if ((r114 & 2) == 0) goto L9;
        boolean r101 = false;
    L11:
        if ((r114 & 4) == 0) goto L13;
        String r102 = "seed";
    L15:
        if ((r114 & 8) == 0) goto L17;
        List r103 = CollectionsKt.arrayListOf(new ModelSettingsItem[]{new ModelSettingsItem(0, null, null, 7, null)});
    L18:
        this(r100, r101, r102, r103);
        return;
    L17:
        r103 = r113;
        goto L18
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
