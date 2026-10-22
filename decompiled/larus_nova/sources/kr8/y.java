package kr8;

import com.bytedance.map.api.monitor.MapMonitorConst;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0011JJ\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011¨\u0006!"}, d2 = {"Lcom/larus/bmhome/music/mob/MusicSaveStatus;", "Lcom/larus/bmhome/music/mob/MobEvent;", "mobKey", "", "success", "errorInfo", "videoId", "duration", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "getMobKey", "()Ljava/lang/String;", "getSuccess", "getErrorInfo", "getVideoId", "getDuration", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Lcom/larus/bmhome/music/mob/MusicSaveStatus;", "equals", "", "other", "", "hashCode", "", "toString", "music_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class y implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient String f505897a;

    @SerializedName("duration")
    private final Long duration;

    @SerializedName(MapMonitorConst.ERROR_INFO)
    private final String errorInfo;

    @SerializedName("success")
    private final String success;

    @SerializedName("video_id")
    private final String videoId;

    public y() {
        this(null, null, null, null, 31);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof y) == true) goto L8;
        return false;
    L8:
        y r101 = (y) r100;
        if (Intrinsics.areEqual(this.f505897a, r101.f505897a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.success, r101.success) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.errorInfo, r101.errorInfo) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.videoId, r101.videoId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.duration, r101.duration) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f505897a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.success;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.errorInfo;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.videoId;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Long r113 = this.duration;
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
        return "MusicSaveStatus(mobKey=" + this.f505897a + ", success=" + this.success + ", errorInfo=" + this.errorInfo + ", videoId=" + this.videoId + ", duration=" + this.duration + ')';
    }

    @Override // kr8.l
    public final String a() {
        return this.f505897a;
    }

    @Override // kr8.l
    public final void b(by7.e r100, JSONObject r101) {
        l.a.a(this, r100, r101);
    }

    public y(String r100, String r101, String r102, Long r103, int r104) {
        if ((r104 & 1) == 0) goto L5;
        String r105 = "music_save_status";
    L7:
        if ((r104 & 2) == 0) goto L10;
        r100 = "";
    L10:
        if ((r104 & 4) == 0) goto L13;
        r101 = "";
    L13:
        if ((r104 & 8) == 0) goto L16;
        r102 = "";
    L16:
        if ((r104 & 16) == 0) goto L18;
        r103 = null;
    L18:
        this.f505897a = r105;
        this.success = r100;
        this.errorInfo = r101;
        this.videoId = r102;
        this.duration = r103;
        return;
    L5:
        r105 = null;
        goto L7
    }
}
