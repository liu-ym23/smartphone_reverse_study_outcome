package yi2;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.g;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\t\u001a\u0004\b\u0017\u0010\u000bR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR(\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u001d8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!¨\u0006\""}, d2 = {"Lyi2/b;", "Lcom/bytedance/android/ec/model/g;", "", "labelType", "Ljava/lang/Integer;", "b", "()Ljava/lang/Integer;", "", "id", "Ljava/lang/Long;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Long;", "Lcom/bytedance/android/ec/model/ECUrlModel;", "icon", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getIcon", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "Lyi2/c;", "smallWindowText", "Lyi2/c;", "getSmallWindowText", "()Lyi2/c;", "duration", "getDuration", "", "trackEvent", "Ljava/lang/String;", "getTrackEvent", "()Ljava/lang/String;", "", "trackParams", "Ljava/util/Map;", "getTrackParams", "()Ljava/util/Map;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b extends g {

    @SerializedName("duration")
    private final Long duration;

    @SerializedName("icon")
    private final ECUrlModel icon;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final Long f567894id;

    @SerializedName("label_type")
    private final Integer labelType;

    @SerializedName("right_text")
    private final c smallWindowText;

    @SerializedName("track_event")
    private final String trackEvent;

    @SerializedName("track_params")
    private final Map<String, String> trackParams;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L20;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.labelType, r101.labelType) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f567894id, r101.f567894id) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.icon, r101.icon) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.smallWindowText, r101.smallWindowText) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.duration, r101.duration) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.trackEvent, r101.trackEvent) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.trackParams, r101.trackParams) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        Integer r100 = this.labelType;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Long r104 = this.f567894id;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        ECUrlModel r107 = this.icon;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        c r110 = this.smallWindowText;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Long r113 = this.duration;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.trackEvent;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        Map<String, String> r119 = this.trackParams;
        if (r119 == null) goto L30;
        r101 = r119.hashCode();
    L30:
        return r118 + r101;
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "SmallWindowLabel(labelType=" + this.labelType + ", id=" + this.f567894id + ", icon=" + this.icon + ", smallWindowText=" + this.smallWindowText + ", duration=" + this.duration + ", trackEvent=" + this.trackEvent + ", trackParams=" + this.trackParams + ")";
    }

    public b() {
        this.labelType = null;
        this.f567894id = null;
        this.icon = null;
        this.smallWindowText = null;
        this.duration = null;
        this.trackEvent = null;
        this.trackParams = null;
    }

    public final Long a() {
        return this.f567894id;
    }

    public final Integer b() {
        return this.labelType;
    }
}
