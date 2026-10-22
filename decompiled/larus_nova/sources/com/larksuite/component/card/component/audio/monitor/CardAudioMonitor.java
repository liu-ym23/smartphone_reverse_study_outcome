package com.larksuite.component.card.component.audio.monitor;

import com.bytedance.android.livesdk.schema.AudienceGamePromoteDetailActionHandler;
import com.bytedance.android.shopping.buynow.data.model.CheckStatus;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import r27.a;

/* JADX INFO: loaded from: classes24.dex */
public final class CardAudioMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f283270a = 0;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larksuite/component/card/component/audio/monitor/CardAudioMonitor$AudioOperationEnum;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", FeatureConfigInfo.PLAY_FEATURE_TYPE_ID, "PAUSE", "STOP", "SEEK", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum AudioOperationEnum extends Enum<AudioOperationEnum> {
        public static final AudioOperationEnum PAUSE = null;
        public static final AudioOperationEnum PLAY = null;
        public static final AudioOperationEnum SEEK = null;
        public static final AudioOperationEnum STOP = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AudioOperationEnum[] f283271a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f283272b = null;
        private final String value;

        public static EnumEntries<AudioOperationEnum> getEntries() {
            return f283272b;
        }

        static {
            AudioOperationEnum r100 = new AudioOperationEnum(FeatureConfigInfo.PLAY_FEATURE_TYPE_ID, 0, "play");
            PLAY = r100;
            AudioOperationEnum r101 = new AudioOperationEnum("PAUSE", 1, "pause");
            PAUSE = r101;
            AudioOperationEnum r102 = new AudioOperationEnum("STOP", 2, "stop");
            STOP = r102;
            AudioOperationEnum r103 = new AudioOperationEnum("SEEK", 3, "seek");
            SEEK = r103;
            AudioOperationEnum[] r104 = {r100, r101, r102, r103};
            f283271a = r104;
            f283272b = EnumEntriesKt.enumEntries(r104);
        }

        public static AudioOperationEnum[] values() {
            return (AudioOperationEnum[]) f283271a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public static AudioOperationEnum valueOf(String r100) {
            return (AudioOperationEnum) a.a(AudioOperationEnum.class, r100);
        }

        public AudioOperationEnum(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larksuite/component/card/component/audio/monitor/CardAudioMonitor$AudioOperationFailType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "RESOURCE", "PLAYER", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum AudioOperationFailType extends Enum<AudioOperationFailType> {
        public static final AudioOperationFailType PLAYER = null;
        public static final AudioOperationFailType RESOURCE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AudioOperationFailType[] f283273a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f283274b = null;
        private final String value;

        public static EnumEntries<AudioOperationFailType> getEntries() {
            return f283274b;
        }

        static {
            AudioOperationFailType r100 = new AudioOperationFailType("RESOURCE", 0, "resource");
            RESOURCE = r100;
            AudioOperationFailType r101 = new AudioOperationFailType("PLAYER", 1, "player");
            PLAYER = r101;
            AudioOperationFailType[] r102 = {r100, r101};
            f283273a = r102;
            f283274b = EnumEntriesKt.enumEntries(r102);
        }

        public static AudioOperationFailType[] values() {
            return (AudioOperationFailType[]) f283273a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public static AudioOperationFailType valueOf(String r100) {
            return (AudioOperationFailType) a.a(AudioOperationFailType.class, r100);
        }

        public AudioOperationFailType(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larksuite/component/card/component/audio/monitor/CardAudioMonitor$AudioResult;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "SUCCESS", "FAIL", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum AudioResult extends Enum<AudioResult> {
        public static final AudioResult FAIL = null;
        public static final AudioResult SUCCESS = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AudioResult[] f283275a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f283276b = null;
        private final String value;

        public static EnumEntries<AudioResult> getEntries() {
            return f283276b;
        }

        static {
            AudioResult r100 = new AudioResult("SUCCESS", 0, "Success");
            SUCCESS = r100;
            AudioResult r101 = new AudioResult("FAIL", 1, CheckStatus.FAIL);
            FAIL = r101;
            AudioResult[] r102 = {r100, r101};
            f283275a = r102;
            f283276b = EnumEntriesKt.enumEntries(r102);
        }

        public static AudioResult[] values() {
            return (AudioResult[]) f283275a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public static AudioResult valueOf(String r100) {
            return (AudioResult) a.a(AudioResult.class, r100);
        }

        public AudioResult(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
    }

    public static void b(String r100, AudioOperationEnum r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "bizID");
        Intrinsics.checkNotNullParameter(r101, WikiFolderPushPlugin.OPT);
        JSONObject r104 = new JSONObject();
        r104.put("result", AudioResult.SUCCESS.getValue());     // Catch: Throwable -> L9
        r104.put(AudienceGamePromoteDetailActionHandler.PARA_BIZ_ID, r100);     // Catch: Throwable -> L9
        r104.put(WikiFolderPushPlugin.OPT, r101.getValue());     // Catch: Throwable -> L9
        if (r102 == null) goto L6;
        r104.put("source", r102);     // Catch: Throwable -> L9
    L6:
        if (r103 == null) goto L11;
        r104.put("file_key", r103);     // Catch: Throwable -> L9
    L11:
        Statistics.sendEvent("universal_card_audio_operation", r104);
        return;
    L9:
        th = move-exception;
        Log.e("CardAudioMonitor", "reportLoadResourceSuccess json error", th);
        goto L11
    }

    public static void a(String r100, AudioOperationEnum r101, String r102, String r103, AudioOperationFailType r104, int r105, String r110) {
        Intrinsics.checkNotNullParameter(r100, "bizID");
        Intrinsics.checkNotNullParameter(r101, WikiFolderPushPlugin.OPT);
        Intrinsics.checkNotNullParameter(r104, "failType");
        Intrinsics.checkNotNullParameter(r110, "errorMsg");
        JSONObject r106 = new JSONObject();
        r106.put("result", AudioResult.FAIL.getValue());     // Catch: Throwable -> L10
        r106.put(AudienceGamePromoteDetailActionHandler.PARA_BIZ_ID, r100);     // Catch: Throwable -> L10
        r106.put(WikiFolderPushPlugin.OPT, r101.getValue());     // Catch: Throwable -> L10
        if (r102 == null) goto L6;
        r106.put("source", r102);     // Catch: Throwable -> L10
    L6:
        if (r103 == null) goto L8;
        r106.put("file_key", r103);     // Catch: Throwable -> L10
    L8:
        r106.put(BdpAppEventConstant.PARAMS_FAIL_TYPE, r104.getValue());     // Catch: Throwable -> L10
        r106.put("error_code", r105);     // Catch: Throwable -> L10
        r106.put("error_msg", r110);     // Catch: Throwable -> L10
    L12:
        Statistics.sendEvent("universal_card_audio_operation", r106);
        return;
    L10:
        th = move-exception;
        Log.e("CardAudioMonitor", "reportLoadResourceSuccess json error", th);
        goto L12
    }
}
