package iy6;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u0010¨\u0006\u0018"}, d2 = {"Liy6/c;", "", "Liy6/g;", "poiMedia", "Liy6/g;", "d", "()Liy6/g;", "Lcom/google/gson/JsonObject;", "trackData", "Lcom/google/gson/JsonObject;", "e", "()Lcom/google/gson/JsonObject;", "Liy6/d;", "interactorContainer", "Liy6/d;", "b", "()Liy6/d;", "Liy6/a;", "lynxUpdateData", "Liy6/a;", "c", "()Liy6/a;", "bodyContainer", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("body_container")
    private final d bodyContainer;

    @SerializedName("interactor_container")
    private final d interactorContainer;

    @SerializedName("lynx_update_data")
    private final a lynxUpdateData;

    @SerializedName("poi_media")
    private final g poiMedia;

    @SerializedName("track_data")
    private final JsonObject trackData;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.poiMedia, r101.poiMedia) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.trackData, r101.trackData) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.interactorContainer, r101.interactorContainer) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.lynxUpdateData, r101.lynxUpdateData) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.bodyContainer, r101.bodyContainer) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        g r100 = this.poiMedia;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        JsonObject r104 = this.trackData;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        d r107 = this.interactorContainer;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        a r110 = this.lynxUpdateData;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        d r113 = this.bodyContainer;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "PlayItem(poiMedia=" + this.poiMedia + ", trackData=" + this.trackData + ", interactorContainer=" + this.interactorContainer + ", lynxUpdateData=" + this.lynxUpdateData + ", bodyContainer=" + this.bodyContainer + ')';
    }

    public c() {
        this.poiMedia = null;
        this.trackData = null;
        this.interactorContainer = null;
        this.lynxUpdateData = null;
        this.bodyContainer = null;
    }

    public final d a() {
        return this.bodyContainer;
    }

    public final d b() {
        return this.interactorContainer;
    }

    public final a c() {
        return this.lynxUpdateData;
    }

    public final g d() {
        return this.poiMedia;
    }

    public final JsonObject e() {
        return this.trackData;
    }
}
