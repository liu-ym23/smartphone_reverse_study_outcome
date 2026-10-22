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
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB/\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J1\u0010\r\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0001J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000fR \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR \u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u001d"}, d2 = {"Lcom/obric/assistant/settings/config/ObricImageUploadCompressConfig;", "Landroid/os/Parcelable;", "screenSemanticScene", "", "Lcom/obric/assistant/settings/config/CompressParam;", "defaultScene", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getScreenSemanticScene", "()Ljava/util/List;", "getDefaultScene", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricImageUploadCompressConfig implements Parcelable {
    public static final Parcelable.Creator<ObricImageUploadCompressConfig> CREATOR = null;
    public static final a Companion = null;

    @SerializedName("default")
    private final List<CompressParam> defaultScene;

    @SerializedName("screen_semantic")
    private final List<CompressParam> screenSemanticScene;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements Parcelable.Creator<ObricImageUploadCompressConfig> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final ObricImageUploadCompressConfig createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            int r101 = 0;
            ArrayList r102 = null;
            if (r100.readInt() != 0) goto L5;
            ArrayList r103 = null;
        L13:
            if (r100.readInt() == 0) goto L24;
            int r104 = r100.readInt();
            ArrayList r105 = new ArrayList(r104);
        L16:
            if (r101 == r104) goto L22;
            if (r100.readInt() != 0) goto L20;
            CompressParam r106 = null;
        L21:
            r105.add(r106);
            r101 = r101 + 1;
            goto L16
        L20:
            r106 = CompressParam.CREATOR.createFromParcel(r100);
            goto L21
        L22:
            r102 = r105;
        L24:
            return new ObricImageUploadCompressConfig(r103, r102);
        L5:
            int r107 = r100.readInt();
            r103 = new ArrayList(r107);
            int r108 = 0;
        L6:
            if (r108 == r107) goto L13;
            if (r100.readInt() != 0) goto L10;
            CompressParam r109 = null;
        L11:
            r103.add(r109);
            r108 = r108 + 1;
            goto L6
        L10:
            r109 = CompressParam.CREATOR.createFromParcel(r100);
            goto L11
        }

        @Override // android.os.Parcelable.Creator
        public final ObricImageUploadCompressConfig[] newArray(int r100) {
            return new ObricImageUploadCompressConfig[r100];
        }
    }

    static {
        Companion = new a();
        CREATOR = new b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ObricImageUploadCompressConfig() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ObricImageUploadCompressConfig copy$default(ObricImageUploadCompressConfig r100, List r101, List r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.screenSemanticScene;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.defaultScene;
    L9:
        return r100.copy(r101, r102);
    }

    public final List<CompressParam> component1() {
        return this.screenSemanticScene;
    }

    public final List<CompressParam> component2() {
        return this.defaultScene;
    }

    public final ObricImageUploadCompressConfig copy(List<CompressParam> r100, List<CompressParam> r101) {
        return new ObricImageUploadCompressConfig(r100, r101);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ObricImageUploadCompressConfig) == true) goto L8;
        return false;
    L8:
        ObricImageUploadCompressConfig r101 = (ObricImageUploadCompressConfig) r100;
        if (Intrinsics.areEqual(this.screenSemanticScene, r101.screenSemanticScene) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.defaultScene, r101.defaultScene) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        List<CompressParam> r100 = this.screenSemanticScene;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<CompressParam> r104 = this.defaultScene;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "ObricImageUploadCompressConfig(screenSemanticScene=" + this.screenSemanticScene + ", defaultScene=" + this.defaultScene + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        List<CompressParam> r102 = this.screenSemanticScene;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L12:
        List<CompressParam> r103 = this.defaultScene;
        if (r103 != null) goto L15;
        r100.writeInt(0);
        return;
    L15:
        r100.writeInt(1);
        r100.writeInt(r103.size());
        Iterator<CompressParam> r104 = r103.iterator();
    L17:
        if (r104.hasNext() == false) goto L35;
        CompressParam r105 = r104.next();
        if (r105 == null) goto L20;
        r100.writeInt(1);
        r105.writeToParcel(r100, r101);
        goto L17
    L20:
        r100.writeInt(0);
        goto L17
    L35:
        return;
    L5:
        r100.writeInt(1);
        r100.writeInt(r102.size());
        Iterator<CompressParam> r106 = r102.iterator();
    L7:
        if (r106.hasNext() == false) goto L12;
        CompressParam r107 = r106.next();
        if (r107 == null) goto L10;
        r100.writeInt(1);
        r107.writeToParcel(r100, r101);
        goto L7
    L10:
        r100.writeInt(0);
        goto L7
    }

    public final List<CompressParam> getDefaultScene() {
        return this.defaultScene;
    }

    public final List<CompressParam> getScreenSemanticScene() {
        return this.screenSemanticScene;
    }

    public ObricImageUploadCompressConfig(List<CompressParam> r100, List<CompressParam> r101) {
        this.screenSemanticScene = r100;
        this.defaultScene = r101;
    }

    public /* synthetic */ ObricImageUploadCompressConfig(List r100, List r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = CollectionsKt.emptyList();
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = CollectionsKt.emptyList();
    L8:
        this(r100, r101);
    }
}
