package com.larus.avlink.env.event.model;

import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.google.gson.annotations.SerializedName;
import com.ss.android.dypay.api.DyPayConstant;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o98.c;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002BO\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0004HÆ\u0003JV\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0004HÖ\u0001R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0014\u0010\u0012R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000e¨\u0006%"}, d2 = {"Lcom/larus/avlink/env/event/model/EnvObserveMemoryEvent;", "Lcom/larus/avlink/env/event/model/EnvObserveMemoryItem;", "Ljava/io/Serializable;", "id", "", "title", "content", DyPayConstant.KEY_START_TIME, "", "endTime", "type", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getTitle", "getContent", "getStartTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getEndTime", "getType", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;)Lcom/larus/avlink/env/event/model/EnvObserveMemoryEvent;", "equals", "", "other", "", "hashCode", "", "toString", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EnvObserveMemoryEvent implements c, Serializable {
    public static final int $stable = 0;

    @SerializedName("details")
    private final String content;

    @SerializedName("end_time")
    private final Long endTime;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("event_id")
    private final String f292294id;

    @SerializedName(ILoadStallMonitor.START_TIME)
    private final Long startTime;

    @SerializedName("title")
    private final String title;

    @SerializedName("event_type")
    private final String type;

    public EnvObserveMemoryEvent() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ EnvObserveMemoryEvent copy$default(EnvObserveMemoryEvent r100, String r101, String r102, String r103, Long r104, Long r105, String r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.f292294id;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.title;
    L8:
        String r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.content;
    L11:
        String r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.startTime;
    L14:
        Long r107 = r104;
        if ((r111 & 16) == 0) goto L17;
        r105 = r100.endTime;
    L17:
        Long r108 = r105;
        if ((r111 & 32) == 0) goto L20;
        r110 = r100.type;
    L20:
        String r109 = r101;
        return r100.copy(r109, r113, r106, r107, r108, r110);
    }

    public final String component1() {
        return this.f292294id;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.content;
    }

    public final Long component4() {
        return this.startTime;
    }

    public final Long component5() {
        return this.endTime;
    }

    public final String component6() {
        return this.type;
    }

    public final EnvObserveMemoryEvent copy(String r100, String r110, String r111, Long r112, Long r113, String r114) {
        return new EnvObserveMemoryEvent(r100, r110, r111, r112, r113, r114);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof EnvObserveMemoryEvent) == true) goto L8;
        return false;
    L8:
        EnvObserveMemoryEvent r101 = (EnvObserveMemoryEvent) r100;
        if (Intrinsics.areEqual(this.f292294id, r101.f292294id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.startTime, r101.startTime) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.endTime, r101.endTime) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        String r100 = this.f292294id;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.title;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.content;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.startTime;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Long r113 = this.endTime;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.type;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
    L21:
        r114 = r113.hashCode();
        goto L22
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

    public String toString() {
        return "EnvObserveMemoryEvent(id=" + this.f292294id + ", title=" + this.title + ", content=" + this.content + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", type=" + this.type + ')';
    }

    public final String getContent() {
        return this.content;
    }

    public final Long getEndTime() {
        return this.endTime;
    }

    public final String getId() {
        return this.f292294id;
    }

    public final Long getStartTime() {
        return this.startTime;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getType() {
        return this.type;
    }

    public EnvObserveMemoryEvent(String r100, String r101, String r102, Long r103, Long r104, String r105) {
        this.f292294id = r100;
        this.title = r101;
        this.content = r102;
        this.startTime = r103;
        this.endTime = r104;
        this.type = r105;
    }

    public /* synthetic */ EnvObserveMemoryEvent(String r100, String r101, String r102, Long r103, Long r110, String r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L5;
        String r114 = null;
    L7:
        if ((r112 & 2) == 0) goto L9;
        String r104 = null;
    L11:
        if ((r112 & 4) == 0) goto L13;
        String r105 = null;
    L15:
        if ((r112 & 8) == 0) goto L17;
        r103 = 0L;
    L17:
        Long r106 = r103;
        if ((r112 & 16) == 0) goto L20;
        r110 = 0L;
    L20:
        Long r107 = r110;
        if ((r112 & 32) == 0) goto L23;
        String r115 = null;
    L24:
        this(r114, r104, r105, r106, r107, r115);
        return;
    L23:
        r115 = r111;
        goto L24
    L13:
        r105 = r102;
        goto L15
    L9:
        r104 = r101;
        goto L11
    L5:
        r114 = r100;
        goto L7
    }
}
