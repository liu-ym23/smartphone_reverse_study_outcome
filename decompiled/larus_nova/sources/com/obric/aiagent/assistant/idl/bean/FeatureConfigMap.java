package com.obric.aiagent.assistant.idl.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003HÆ\u0001J\u0006\u0010\r\u001a\u00020\u000eJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u000eHÖ\u0001J\t\u0010\u0014\u001a\u00020\u0004HÖ\u0001J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000eR,\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0007¨\u0006\u001a"}, d2 = {"Lcom/obric/aiagent/assistant/idl/bean/FeatureConfigMap;", "Landroid/os/Parcelable;", "configMap", "", "", "Lcom/obric/aiagent/assistant/idl/bean/FeatureConfigBean;", "<init>", "(Ljava/util/Map;)V", "getConfigMap", "()Ljava/util/Map;", "setConfigMap", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "assistant-ipc_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeatureConfigMap implements Parcelable {
    public static final Parcelable.Creator<FeatureConfigMap> CREATOR = null;

    @SerializedName("config_map")
    private Map<String, FeatureConfigBean> configMap;

    /* JADX INFO: loaded from: classes32.dex */
    public static final class a implements Parcelable.Creator<FeatureConfigMap> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final FeatureConfigMap createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            int r101 = r100.readInt();
            LinkedHashMap r102 = new LinkedHashMap(r101);
            int r103 = 0;
        L3:
            if (r103 == r101) goto L10;
            String r104 = r100.readString();
            if (r100.readInt() != 0) goto L7;
            FeatureConfigBean r105 = null;
        L8:
            r102.put(r104, r105);
            r103 = r103 + 1;
            goto L3
        L7:
            r105 = FeatureConfigBean.CREATOR.createFromParcel(r100);
            goto L8
        L10:
            return new FeatureConfigMap(r102);
        }

        @Override // android.os.Parcelable.Creator
        public final FeatureConfigMap[] newArray(int r100) {
            return new FeatureConfigMap[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FeatureConfigMap() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FeatureConfigMap copy$default(FeatureConfigMap r100, Map r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.configMap;
    L6:
        return r100.copy(r101);
    }

    public final Map<String, FeatureConfigBean> component1() {
        return this.configMap;
    }

    public final FeatureConfigMap copy(Map<String, FeatureConfigBean> r100) {
        Intrinsics.checkNotNullParameter(r100, "configMap");
        return new FeatureConfigMap(r100);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FeatureConfigMap) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.configMap, ((FeatureConfigMap) r100).configMap) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.configMap.hashCode();
    }

    public String toString() {
        return "FeatureConfigMap(configMap=" + this.configMap + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        Map<String, FeatureConfigBean> r102 = this.configMap;
        r100.writeInt(r102.size());
        Iterator<Map.Entry<String, FeatureConfigBean>> r103 = r102.entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L9;
        Map.Entry<String, FeatureConfigBean> r104 = r103.next();
        r100.writeString(r104.getKey());
        FeatureConfigBean r105 = r104.getValue();
        if (r105 == null) goto L7;
        r100.writeInt(1);
        r105.writeToParcel(r100, r101);
        goto L4
    L7:
        r100.writeInt(0);
        goto L4
    }

    public final Map<String, FeatureConfigBean> getConfigMap() {
        return this.configMap;
    }

    public FeatureConfigMap(Map<String, FeatureConfigBean> r100) {
        Intrinsics.checkNotNullParameter(r100, "configMap");
        this.configMap = r100;
    }

    public final void setConfigMap(Map<String, FeatureConfigBean> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.configMap = r100;
    }

    public /* synthetic */ FeatureConfigMap(Map r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = new LinkedHashMap();
    L5:
        this(r100);
    }
}
