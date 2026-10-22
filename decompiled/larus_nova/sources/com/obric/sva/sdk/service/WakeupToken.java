package com.obric.sva.sdk.service;

import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.obric.sva.framework.wrapper.SoundTriggerWrapper;
import com.obric.sva.sdk.session.OpaqueDataHelper;
import com.obric.sva.sdk.utils.LogUtils;
import com.ss.android.dypay.api.DyPayConstant;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\b\u0018\u0000 .2\u00020\u0001:\u0002./B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u001a\u001a\u00020\u001bJ\t\u0010&\u001a\u00020\u0003HÆ\u0003J\u0013\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\u001dHÖ\u0001J\t\u0010,\u001a\u00020-HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001c\u001a\u00020\u001d8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010 \u001a\u00020\u001d8F¢\u0006\u0006\u001a\u0004\b!\u0010\u001fR\u0013\u0010\"\u001a\u0004\u0018\u00010#8F¢\u0006\u0006\u001a\u0004\b$\u0010%¨\u00060"}, d2 = {"Lcom/obric/sva/sdk/service/WakeupToken;", "", "event", "Lcom/obric/sva/framework/wrapper/SoundTriggerWrapper$RecognitionEventWrapper;", "<init>", "(Lcom/obric/sva/framework/wrapper/SoundTriggerWrapper$RecognitionEventWrapper;)V", "getEvent", "()Lcom/obric/sva/framework/wrapper/SoundTriggerWrapper$RecognitionEventWrapper;", DyPayConstant.KEY_START_TIME, "", "getStartTime", "()J", "setStartTime", "(J)V", "ftrtDataGetWay", "Lcom/obric/sva/sdk/service/WakeupToken$FTRT_DATA_GETWAY;", "getFtrtDataGetWay", "()Lcom/obric/sva/sdk/service/WakeupToken$FTRT_DATA_GETWAY;", "setFtrtDataGetWay", "(Lcom/obric/sva/sdk/service/WakeupToken$FTRT_DATA_GETWAY;)V", "opaqueData", "Lcom/obric/sva/sdk/service/OpaqueData;", "getOpaqueData", "()Lcom/obric/sva/sdk/service/OpaqueData;", "setOpaqueData", "(Lcom/obric/sva/sdk/service/OpaqueData;)V", WidgetCostModule.TYPE_INFLATE, "", "keywordLength", "", "getKeywordLength", "()I", "ftrtLength", "getFtrtLength", "ftrtData", "", "getFtrtData", "()[B", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "Companion", "FTRT_DATA_GETWAY", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WakeupToken {
    public static final Companion Companion = null;
    public static final String TAG = "WakeupService/[WakeupToken]";
    public static final int WAKEUP_NEED_FOUND_KEYS_SIZE = 2;
    private final SoundTriggerWrapper.RecognitionEventWrapper event;
    private FTRT_DATA_GETWAY ftrtDataGetWay;
    private OpaqueData opaqueData;
    private long startTime;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/sva/sdk/service/WakeupToken$Companion;", "", "<init>", "()V", "TAG", "", "WAKEUP_NEED_FOUND_KEYS_SIZE", "", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/sva/sdk/service/WakeupToken$FTRT_DATA_GETWAY;", "", "<init>", "(Ljava/lang/String;I)V", "NA", "OPAQUE_DATA", "RECORDING_DATA", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum FTRT_DATA_GETWAY extends Enum<FTRT_DATA_GETWAY> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ FTRT_DATA_GETWAY[] $VALUES = null;
        public static final FTRT_DATA_GETWAY NA = null;
        public static final FTRT_DATA_GETWAY OPAQUE_DATA = null;
        public static final FTRT_DATA_GETWAY RECORDING_DATA = null;

        private static final /* synthetic */ FTRT_DATA_GETWAY[] $values() {
            return new FTRT_DATA_GETWAY[]{NA, OPAQUE_DATA, RECORDING_DATA};
        }

        public static EnumEntries<FTRT_DATA_GETWAY> getEntries() {
            return $ENTRIES;
        }

        static {
            NA = new FTRT_DATA_GETWAY("NA", 0);
            OPAQUE_DATA = new FTRT_DATA_GETWAY("OPAQUE_DATA", 1);
            RECORDING_DATA = new FTRT_DATA_GETWAY("RECORDING_DATA", 2);
            FTRT_DATA_GETWAY[] r100 = $values();
            $VALUES = r100;
            $ENTRIES = EnumEntriesKt.enumEntries(r100);
        }

        public static FTRT_DATA_GETWAY[] values() {
            return (FTRT_DATA_GETWAY[]) $VALUES.clone();
        }

        public static FTRT_DATA_GETWAY valueOf(String r100) {
            return (FTRT_DATA_GETWAY) r27.a.a(FTRT_DATA_GETWAY.class, r100);
        }

        private FTRT_DATA_GETWAY(String r100, int r101) {
            super(r100, r101);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ WakeupToken copy$default(WakeupToken r100, SoundTriggerWrapper.RecognitionEventWrapper r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.event;
    L6:
        return r100.copy(r101);
    }

    public final SoundTriggerWrapper.RecognitionEventWrapper component1() {
        return this.event;
    }

    public final WakeupToken copy(SoundTriggerWrapper.RecognitionEventWrapper r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        return new WakeupToken(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof WakeupToken) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.event, ((WakeupToken) r100).event) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.event.hashCode();
    }

    public final void inflate() {
        LogUtils.d(TAG, "inflate start ...", new Object[0]);
        int r100 = this.opaqueData.getSize();
        int r101 = 2;
        int r102 = 0;
    L3:
        if (r102 >= r100) goto L18;
        if ((r102 + 8) >= r100) goto L18;
        int r103 = OpaqueDataHelper.byte2Int(this.opaqueData.getRaw(), r102);
        int r104 = r102 + 4;
        int r105 = OpaqueDataHelper.byte2Int(this.opaqueData.getRaw(), r104);
        int r106 = r104 + 4;
        if (r103 != 32) goto L9;
        int r107 = OpaqueDataHelper.byte2Int(this.opaqueData.getRaw(), r106 + 4);
        LogUtils.d(TAG, "inflate found length=" + r107, new Object[0]);
        this.opaqueData.setKeywordLength(r107);
    L13:
        r101 = r101 - 1;
    L14:
        r102 = r106 + r105;
        if (r101 > 0) goto L3;
        LogUtils.d(TAG, "inflate done=" + r101, new Object[0]);
        goto L18
    L9:
        if (r103 != 34) goto L14;
        int r108 = r106 + 4;
        int r109 = OpaqueDataHelper.byte2Int(this.opaqueData.getRaw(), r108);
        byte[] r110 = new byte[r109];
        LogUtils.d(TAG, "inflate found ftrtData " + r109, new Object[0]);
        System.arraycopy(this.opaqueData.getRaw(), r108 + 4, r110, 0, r109);
        this.ftrtDataGetWay = FTRT_DATA_GETWAY.OPAQUE_DATA;
        this.opaqueData.setFtrtData(r110);
        this.opaqueData.setFtrtLength(r109);
    L18:
        if (this.ftrtDataGetWay != FTRT_DATA_GETWAY.NA) goto L25;
        this.ftrtDataGetWay = FTRT_DATA_GETWAY.RECORDING_DATA;
        LogUtils.d(TAG, "inflate not found ftrtData , will use recording", new Object[0]);
        return;
    }

    public String toString() {
        return "WakeupToken(event=" + this.event + ')';
    }

    public final byte[] getFtrtData() {
        return this.opaqueData.getFtrtData();
    }

    public final int getFtrtLength() {
        return this.opaqueData.getFtrtLength();
    }

    public final int getKeywordLength() {
        return this.opaqueData.getKeywordLength();
    }

    public final SoundTriggerWrapper.RecognitionEventWrapper getEvent() {
        return this.event;
    }

    public final FTRT_DATA_GETWAY getFtrtDataGetWay() {
        return this.ftrtDataGetWay;
    }

    public final OpaqueData getOpaqueData() {
        return this.opaqueData;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public WakeupToken(SoundTriggerWrapper.RecognitionEventWrapper r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        this.event = r100;
        this.ftrtDataGetWay = FTRT_DATA_GETWAY.NA;
        this.opaqueData = new OpaqueData(r100.data());
    }

    public final void setFtrtDataGetWay(FTRT_DATA_GETWAY r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.ftrtDataGetWay = r100;
    }

    public final void setOpaqueData(OpaqueData r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.opaqueData = r100;
    }

    public final void setStartTime(long r100) {
        this.startTime = r100;
    }
}
