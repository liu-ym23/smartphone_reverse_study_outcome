package vl9;

import androidx.camera.video.AudioStats;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0012\u001a\u00020\u0013J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\bHÆ\u0003J5\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/larus/navigation/api/baidu/bean/instruction/BaiduNaviVisualInstruction;", "", "position", "", "distanceToOrigin", "", "distanceToCurrent", "turnInfo", "Lcom/larus/navigation/api/baidu/bean/instruction/BaiduNaviTurnInfo;", "<init>", "(Ljava/lang/String;IILcom/larus/navigation/api/baidu/bean/instruction/BaiduNaviTurnInfo;)V", "getPosition", "()Ljava/lang/String;", "getDistanceToOrigin", "()I", "getDistanceToCurrent", "getTurnInfo", "()Lcom/larus/navigation/api/baidu/bean/instruction/BaiduNaviTurnInfo;", "getGeoPosition", "Lcom/larus/navigation/api/baidu/bean/BaiduNaviGeoPoint;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class d {

    @SerializedName("distance_to_current")
    private final int distanceToCurrent;

    @SerializedName("distance_to_origin")
    private final int distanceToOrigin;

    @SerializedName("position")
    private final String position;

    @SerializedName("turn_description")
    private final a turnInfo;

    public d() {
        this("", 0, 0, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.position, r101.position) == true) goto L12;
        return false;
    L12:
        if (this.distanceToOrigin == r101.distanceToOrigin) goto L15;
        return false;
    L15:
        if (this.distanceToCurrent == r101.distanceToCurrent) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.turnInfo, r101.turnInfo) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        String r100 = this.position;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((((r102 * 31) + this.distanceToOrigin) * 31) + this.distanceToCurrent) * 31;
        a r104 = this.turnInfo;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "BaiduNaviVisualInstruction(position=" + this.position + ", distanceToOrigin=" + this.distanceToOrigin + ", distanceToCurrent=" + this.distanceToCurrent + ", turnInfo=" + this.turnInfo + ')';
    }

    public final ul9.a c() {
        String r100 = this.position;
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        List r101 = StringsKt.split$default(r100, new String[]{","}, false, 0, 6, null);
        if (r101.size() < 2) goto L8;
        Double r102 = StringsKt.toDoubleOrNull((String) ListProtector.get(r101, 0));
        Double r103 = StringsKt.toDoubleOrNull((String) ListProtector.get(r101, 1));
        int r104 = r101.size();
        double r105 = AudioStats.AUDIO_AMPLITUDE_NONE;
        if (r104 != 2) goto L12;
        Double r106 = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
    L14:
        if (r103 == null) goto L16;
        double r107 = r103.doubleValue();
    L17:
        if (r102 == null) goto L19;
        double r110 = r102.doubleValue();
    L20:
        if (r106 == null) goto L23;
        r105 = r106.doubleValue();
    L23:
        return new ul9.a(r107, r110, r105);
    L19:
        r110 = 0.0d;
        goto L20
    L16:
        r107 = 0.0d;
        goto L17
    L12:
        r106 = StringsKt.toDoubleOrNull((String) ListProtector.get(r101, 2));
        goto L14
    L8:
        return new ul9.a(AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE);
    }

    public final int a() {
        return this.distanceToCurrent;
    }

    public final int b() {
        return this.distanceToOrigin;
    }

    public final a d() {
        return this.turnInfo;
    }

    public d(String r100, int r101, int r102, a r103) {
        this.position = r100;
        this.distanceToOrigin = r101;
        this.distanceToCurrent = r102;
        this.turnInfo = r103;
    }
}
