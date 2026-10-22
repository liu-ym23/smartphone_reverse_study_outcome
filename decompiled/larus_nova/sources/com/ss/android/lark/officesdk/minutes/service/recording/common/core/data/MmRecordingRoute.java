package com.ss.android.lark.officesdk.minutes.service.recording.common.core.data;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0012B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u000e\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rj\u0002\b\bj\u0002\b\t¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/data/MmRecordingRoute;", "", "storageValue", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getStorageValue", "()Ljava/lang/String;", "LEGACY", "RECORDING_API", "usesRecordingApi", "", "getUsesRecordingApi", "()Z", "resolvedAfterJoin", "source", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingSource;", "recordingId", "Companion", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MmRecordingRoute extends Enum<MmRecordingRoute> {
    public static final a Companion = null;
    public static final MmRecordingRoute LEGACY = null;
    public static final MmRecordingRoute RECORDING_API = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MmRecordingRoute[] f434186a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f434187b = null;
    private final String storageValue;

    public static final class a {
        public a() {
        }

        public static MmRecordingRoute a(MmRecordingSource r100, boolean r101) {
            if (r100 != MmRecordingSource.FEISHU) goto L7;
            if (r101 == false) goto L17;
            return MmRecordingRoute.RECORDING_API;
        L17:
            return MmRecordingRoute.LEGACY;
        L7:
            if (r100 == null) goto L11;
            boolean r102 = true;
            if (r100.usesRecordingApiByDefault() != true) goto L11;
        L12:
            if (r102 == false) goto L15;
            return MmRecordingRoute.RECORDING_API;
        L15:
            return MmRecordingRoute.LEGACY;
        L11:
            r102 = false;
            goto L12
        }
    }

    public static EnumEntries<MmRecordingRoute> getEntries() {
        return f434187b;
    }

    static {
        MmRecordingRoute r100 = new MmRecordingRoute("LEGACY", 0, "legacy");
        LEGACY = r100;
        MmRecordingRoute r101 = new MmRecordingRoute("RECORDING_API", 1, "recording_api");
        RECORDING_API = r101;
        MmRecordingRoute[] r102 = {r100, r101};
        f434186a = r102;
        f434187b = EnumEntriesKt.enumEntries(r102);
        Companion = new a();
    }

    public static MmRecordingRoute[] values() {
        return (MmRecordingRoute[]) f434186a.clone();
    }

    public final boolean getUsesRecordingApi() {
        if (this != RECORDING_API) goto L5;
        return true;
    L5:
        return false;
    }

    public final String getStorageValue() {
        return this.storageValue;
    }

    public static MmRecordingRoute valueOf(String r100) {
        return (MmRecordingRoute) r27.a.a(MmRecordingRoute.class, r100);
    }

    public final MmRecordingRoute resolvedAfterJoin(MmRecordingSource r100, String r101) {
        MmRecordingRoute r102 = RECORDING_API;
        if (this != r102) goto L30;
        boolean r103 = false;
        if (r100 == null) goto L12;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100 != MmRecordingSource.FEISHU) goto L9;
        boolean r104 = true;
    L10:
        if (r104 != true) goto L12;
        boolean r105 = true;
    L13:
        if (r105 == false) goto L30;
        Companion.getClass();
        if (r101 != null) goto L18;
    L21:
        boolean r106 = true;
    L22:
        if (r106 == false) goto L24;
    L26:
        if (r103 == false) goto L29;
        return r102;
    L29:
        return LEGACY;
    L24:
        if (Intrinsics.areEqual(r101, "0") == true) goto L26;
        r103 = true;
        goto L26
    L18:
        if (StringsKt.isBlank(r101) == true) goto L21;
        r106 = false;
        goto L22
    L9:
        r104 = false;
    L12:
        r105 = false;
    L30:
        return this;
    }

    public MmRecordingRoute(String r100, int r101, String r102) {
        super(r100, r101);
        this.storageValue = r102;
    }
}
