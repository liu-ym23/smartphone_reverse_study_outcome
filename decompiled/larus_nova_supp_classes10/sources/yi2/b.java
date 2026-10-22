package yi2;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.g;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\t\u001a\u0004\b\u0017\u0010\u000bR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR(\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u001d8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!¨\u0006\""}, d2 = {"Lyi2/b;", "Lcom/bytedance/android/ec/model/g;", "", "labelType", "Ljava/lang/Integer;", "b", "()Ljava/lang/Integer;", "", "id", "Ljava/lang/Long;", "a", "()Ljava/lang/Long;", "Lcom/bytedance/android/ec/model/ECUrlModel;", "icon", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getIcon", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "Lyi2/c;", "smallWindowText", "Lyi2/c;", "getSmallWindowText", "()Lyi2/c;", "duration", "getDuration", "", "trackEvent", "Ljava/lang/String;", "getTrackEvent", "()Ljava/lang/String;", "", "trackParams", "Ljava/util/Map;", "getTrackParams", "()Ljava/util/Map;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b extends g {

    @SerializedName("duration")
    private final Long duration;

    @SerializedName("icon")
    private final ECUrlModel icon;

    @SerializedName("id")
    private final Long id;

    @SerializedName("label_type")
    private final Integer labelType;

    @SerializedName("right_text")
    private final c smallWindowText;

    @SerializedName("track_event")
    private final String trackEvent;

    @SerializedName("track_params")
    private final Map<String, String> trackParams;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof b) == false) goto L20;
        b r4 = (b) r3;
        if (Intrinsics.areEqual(this.labelType, r4.labelType) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.id, r4.id) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.icon, r4.icon) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.smallWindowText, r4.smallWindowText) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.duration, r4.duration) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.trackEvent, r4.trackEvent) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.trackParams, r4.trackParams) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        Integer r0 = this.labelType;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Long r4 = this.id;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        ECUrlModel r7 = this.icon;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        c r10 = this.smallWindowText;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        Long r13 = this.duration;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.trackEvent;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        Map<String, String> r19 = this.trackParams;
        if (r19 == null) goto L30;
        r1 = r19.hashCode();
    L30:
        return r18 + r1;
    L25:
        r17 = 0;
        goto L26
    L21:
        r14 = 0;
        goto L22
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "SmallWindowLabel(labelType=" + this.labelType + ", id=" + this.id + ", icon=" + this.icon + ", smallWindowText=" + this.smallWindowText + ", duration=" + this.duration + ", trackEvent=" + this.trackEvent + ", trackParams=" + this.trackParams + ")";
    }

    public b() {
        this.labelType = null;
        this.id = null;
        this.icon = null;
        this.smallWindowText = null;
        this.duration = null;
        this.trackEvent = null;
        this.trackParams = null;
    }

    public final Long a() {
        return this.id;
    }

    public final Integer b() {
        return this.labelType;
    }
}
