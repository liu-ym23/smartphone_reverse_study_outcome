package com.larus.push.impl.reminder;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0003HÆ\u0003J#\u0010\u000b\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0004HÖ\u0001R&\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/larus/push/impl/reminder/OpenPushReminderConfig;", "", "sceneInfo", "", "", "Lcom/larus/push/impl/reminder/OpenPushReminderSceneInfo;", "<init>", "(Ljava/util/Map;)V", "getSceneInfo", "()Ljava/util/Map;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OpenPushReminderConfig {

    @SerializedName("scene_info")
    private final Map<String, OpenPushReminderSceneInfo> sceneInfo;

    /* JADX WARN: Multi-variable type inference failed */
    public OpenPushReminderConfig() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OpenPushReminderConfig copy$default(OpenPushReminderConfig r100, Map r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.sceneInfo;
    L6:
        return r100.copy(r101);
    }

    public final Map<String, OpenPushReminderSceneInfo> component1() {
        return this.sceneInfo;
    }

    public final OpenPushReminderConfig copy(Map<String, OpenPushReminderSceneInfo> r100) {
        return new OpenPushReminderConfig(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OpenPushReminderConfig) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.sceneInfo, ((OpenPushReminderConfig) r100).sceneInfo) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        Map<String, OpenPushReminderSceneInfo> r100 = this.sceneInfo;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public String toString() {
        return "OpenPushReminderConfig(sceneInfo=" + this.sceneInfo + ')';
    }

    public final Map<String, OpenPushReminderSceneInfo> getSceneInfo() {
        return this.sceneInfo;
    }

    public OpenPushReminderConfig(Map<String, OpenPushReminderSceneInfo> r100) {
        this.sceneInfo = r100;
    }

    public /* synthetic */ OpenPushReminderConfig(Map r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = MapsKt.emptyMap();
    L5:
        this(r100);
    }
}
