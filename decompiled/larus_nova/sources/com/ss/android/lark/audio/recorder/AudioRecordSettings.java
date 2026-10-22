package com.ss.android.lark.audio.recorder;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.log.Log;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class AudioRecordSettings {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicReference<String> f409071a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicReference<Map<String, AudioSceneParams>> f409072b = null;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/audio/recorder/AudioRecordSettings$AudioRecordParams;", "", "audioRecordDataRequestInterval", "", "audio2TextMaxDuration", "<init>", "(II)V", "getAudioRecordDataRequestInterval", "()I", "getAudio2TextMaxDuration", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "audio_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AudioRecordParams {

        @SerializedName("audio_max_duration")
        private final int audio2TextMaxDuration;

        @SerializedName("audio_record_data_request_interval")
        private final int audioRecordDataRequestInterval;

        public AudioRecordParams() {
            int r100 = 0;
            this(r100, r100, 3, null);
        }

        public static /* synthetic */ AudioRecordParams copy$default(AudioRecordParams r100, int r101, int r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.audioRecordDataRequestInterval;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.audio2TextMaxDuration;
        L9:
            return r100.copy(r101, r102);
        }

        public final int component1() {
            return this.audioRecordDataRequestInterval;
        }

        public final int component2() {
            return this.audio2TextMaxDuration;
        }

        public final AudioRecordParams copy(int r100, int r101) {
            return new AudioRecordParams(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof AudioRecordParams) == true) goto L8;
            return false;
        L8:
            AudioRecordParams r101 = (AudioRecordParams) r100;
            if (this.audioRecordDataRequestInterval == r101.audioRecordDataRequestInterval) goto L12;
            return false;
        L12:
            if (this.audio2TextMaxDuration == r101.audio2TextMaxDuration) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.audioRecordDataRequestInterval * 31) + this.audio2TextMaxDuration;
        }

        public String toString() {
            return "AudioRecordParams(audioRecordDataRequestInterval=" + this.audioRecordDataRequestInterval + ", audio2TextMaxDuration=" + this.audio2TextMaxDuration + ')';
        }

        public final int getAudio2TextMaxDuration() {
            return this.audio2TextMaxDuration;
        }

        public final int getAudioRecordDataRequestInterval() {
            return this.audioRecordDataRequestInterval;
        }

        public AudioRecordParams(int r100, int r101) {
            this.audioRecordDataRequestInterval = r100;
            this.audio2TextMaxDuration = r101;
        }

        public /* synthetic */ AudioRecordParams(int r100, int r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 1) == 0) goto L6;
            r100 = 100;
        L6:
            if ((r102 & 2) == 0) goto L8;
            r101 = BaseConstants.Time.HOUR;
        L8:
            this(r100, r101);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.audio.recorder.AudioRecordSettings$AudioRecordSettings, reason: collision with other inner class name */
    @AppConfig(key = "im_audio_settings")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/lark/audio/recorder/AudioRecordSettings$AudioRecordSettings;", "", "<init>", "()V", "audio_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class C4750AudioRecordSettings {
        public C4750AudioRecordSettings() {
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001Bk\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\tHÆ\u0003J\t\u0010&\u001a\u00020\u000bHÆ\u0003J\t\u0010'\u001a\u00020\u000bHÆ\u0003J\t\u0010(\u001a\u00020\u000bHÆ\u0003J\t\u0010)\u001a\u00020\u000fHÆ\u0003Jm\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000fHÆ\u0001J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020\u0003HÖ\u0001J\t\u0010/\u001a\u000200HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\f\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0016\u0010\r\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u0016\u0010\u000e\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u00061"}, d2 = {"Lcom/ss/android/lark/audio/recorder/AudioRecordSettings$AudioSceneParams;", "", "lastFrameTimeoutInterval", "", "asrWaitingTipsInterval", "lastFrameTimeoutResetMiddleResultThreshold", "audioRecordSource", "recordBufferSize", "oggPageSize", "", "audioWithText", "Lcom/ss/android/lark/audio/recorder/AudioRecordSettings$AudioRecordParams;", "audioRecord", "audioToText", "newAudioInputParams", "Lcom/ss/android/lark/audio/recorder/AudioRecordSettings$NewAudioInputParams;", "<init>", "(IIIIIJLcom/ss/android/lark/audio/recorder/AudioRecordSettings$AudioRecordParams;Lcom/ss/android/lark/audio/recorder/AudioRecordSettings$AudioRecordParams;Lcom/ss/android/lark/audio/recorder/AudioRecordSettings$AudioRecordParams;Lcom/ss/android/lark/audio/recorder/AudioRecordSettings$NewAudioInputParams;)V", "getLastFrameTimeoutInterval", "()I", "getAsrWaitingTipsInterval", "getLastFrameTimeoutResetMiddleResultThreshold", "getAudioRecordSource", "getRecordBufferSize", "getOggPageSize", "()J", "getAudioWithText", "()Lcom/ss/android/lark/audio/recorder/AudioRecordSettings$AudioRecordParams;", "getAudioRecord", "getAudioToText", "getNewAudioInputParams", "()Lcom/ss/android/lark/audio/recorder/AudioRecordSettings$NewAudioInputParams;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "", "other", "hashCode", "toString", "", "audio_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AudioSceneParams {

        @SerializedName("last_frame_warn_interval")
        private final int asrWaitingTipsInterval;

        @SerializedName("audio_record")
        private final AudioRecordParams audioRecord;

        @SerializedName("audio_record_source")
        private final int audioRecordSource;

        @SerializedName("audio_to_text")
        private final AudioRecordParams audioToText;

        @SerializedName("audio_with_text")
        private final AudioRecordParams audioWithText;

        @SerializedName("last_frame_timeout_interval")
        private final int lastFrameTimeoutInterval;

        @SerializedName("last_frame_timeout_reset_middle_result_threshold")
        private final int lastFrameTimeoutResetMiddleResultThreshold;

        @SerializedName("audio_input")
        private final NewAudioInputParams newAudioInputParams;

        @SerializedName("ogg_page_size")
        private final long oggPageSize;

        @SerializedName("record_buffer_size")
        private final int recordBufferSize;

        public AudioSceneParams() {
            this(0, 0, 0, 0, 0, 0, null, null, null, null, 1023, null);
        }

        public static /* synthetic */ AudioSceneParams copy$default(AudioSceneParams r110, int r111, int r112, int r113, int r114, int r115, long r116, AudioRecordParams r210, AudioRecordParams r211, AudioRecordParams r212, NewAudioInputParams r213, int r214, Object r215) {
            if ((r214 & 1) == 0) goto L5;
            int r100 = r110.lastFrameTimeoutInterval;
        L7:
            if ((r214 & 2) == 0) goto L9;
            int r101 = r110.asrWaitingTipsInterval;
        L11:
            if ((r214 & 4) == 0) goto L13;
            int r102 = r110.lastFrameTimeoutResetMiddleResultThreshold;
        L15:
            if ((r214 & 8) == 0) goto L17;
            int r103 = r110.audioRecordSource;
        L19:
            if ((r214 & 16) == 0) goto L21;
            int r104 = r110.recordBufferSize;
        L23:
            if ((r214 & 32) == 0) goto L25;
            long r105 = r110.oggPageSize;
        L27:
            if ((r214 & 64) == 0) goto L29;
            AudioRecordParams r106 = r110.audioWithText;
        L31:
            if ((r214 & 128) == 0) goto L33;
            AudioRecordParams r117 = r110.audioRecord;
        L35:
            if ((r214 & 256) == 0) goto L37;
            AudioRecordParams r118 = r110.audioToText;
        L39:
            if ((r214 & 512) == 0) goto L41;
            NewAudioInputParams r107 = r110.newAudioInputParams;
        L43:
            return r110.copy(r100, r101, r102, r103, r104, r105, r106, r117, r118, r107);
        L41:
            r107 = r213;
            goto L43
        L37:
            r118 = r212;
            goto L39
        L33:
            r117 = r211;
            goto L35
        L29:
            r106 = r210;
            goto L31
        L25:
            r105 = r116;
            goto L27
        L21:
            r104 = r115;
            goto L23
        L17:
            r103 = r114;
            goto L19
        L13:
            r102 = r113;
            goto L15
        L9:
            r101 = r112;
            goto L11
        L5:
            r100 = r111;
            goto L7
        }

        public final int component1() {
            return this.lastFrameTimeoutInterval;
        }

        public final NewAudioInputParams component10() {
            return this.newAudioInputParams;
        }

        public final int component2() {
            return this.asrWaitingTipsInterval;
        }

        public final int component3() {
            return this.lastFrameTimeoutResetMiddleResultThreshold;
        }

        public final int component4() {
            return this.audioRecordSource;
        }

        public final int component5() {
            return this.recordBufferSize;
        }

        public final long component6() {
            return this.oggPageSize;
        }

        public final AudioRecordParams component7() {
            return this.audioWithText;
        }

        public final AudioRecordParams component8() {
            return this.audioRecord;
        }

        public final AudioRecordParams component9() {
            return this.audioToText;
        }

        public final AudioSceneParams copy(int r110, int r111, int r112, int r113, int r114, long r115, AudioRecordParams r210, AudioRecordParams r211, AudioRecordParams r212, NewAudioInputParams r213) {
            Intrinsics.checkNotNullParameter(r210, "audioWithText");
            Intrinsics.checkNotNullParameter(r211, "audioRecord");
            Intrinsics.checkNotNullParameter(r212, "audioToText");
            Intrinsics.checkNotNullParameter(r213, "newAudioInputParams");
            return new AudioSceneParams(r110, r111, r112, r113, r114, r115, r210, r211, r212, r213);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof AudioSceneParams) == true) goto L8;
            return false;
        L8:
            AudioSceneParams r101 = (AudioSceneParams) r100;
            if (this.lastFrameTimeoutInterval == r101.lastFrameTimeoutInterval) goto L12;
            return false;
        L12:
            if (this.asrWaitingTipsInterval == r101.asrWaitingTipsInterval) goto L15;
            return false;
        L15:
            if (this.lastFrameTimeoutResetMiddleResultThreshold == r101.lastFrameTimeoutResetMiddleResultThreshold) goto L18;
            return false;
        L18:
            if (this.audioRecordSource == r101.audioRecordSource) goto L21;
            return false;
        L21:
            if (this.recordBufferSize == r101.recordBufferSize) goto L24;
            return false;
        L24:
            if (this.oggPageSize == r101.oggPageSize) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.audioWithText, r101.audioWithText) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.audioRecord, r101.audioRecord) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.audioToText, r101.audioToText) == true) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.newAudioInputParams, r101.newAudioInputParams) == true) goto L38;
            return false;
        L38:
            return true;
        }

        public int hashCode() {
            int r100 = ((((((((this.lastFrameTimeoutInterval * 31) + this.asrWaitingTipsInterval) * 31) + this.lastFrameTimeoutResetMiddleResultThreshold) * 31) + this.audioRecordSource) * 31) + this.recordBufferSize) * 31;
            long r101 = this.oggPageSize;
            return ((((((((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.audioWithText.hashCode()) * 31) + this.audioRecord.hashCode()) * 31) + this.audioToText.hashCode()) * 31) + this.newAudioInputParams.hashCode();
        }

        public String toString() {
            return "AudioSceneParams(lastFrameTimeoutInterval=" + this.lastFrameTimeoutInterval + ", asrWaitingTipsInterval=" + this.asrWaitingTipsInterval + ", lastFrameTimeoutResetMiddleResultThreshold=" + this.lastFrameTimeoutResetMiddleResultThreshold + ", audioRecordSource=" + this.audioRecordSource + ", recordBufferSize=" + this.recordBufferSize + ", oggPageSize=" + this.oggPageSize + ", audioWithText=" + this.audioWithText + ", audioRecord=" + this.audioRecord + ", audioToText=" + this.audioToText + ", newAudioInputParams=" + this.newAudioInputParams + ')';
        }

        public final int getAsrWaitingTipsInterval() {
            return this.asrWaitingTipsInterval;
        }

        public final AudioRecordParams getAudioRecord() {
            return this.audioRecord;
        }

        public final int getAudioRecordSource() {
            return this.audioRecordSource;
        }

        public final AudioRecordParams getAudioToText() {
            return this.audioToText;
        }

        public final AudioRecordParams getAudioWithText() {
            return this.audioWithText;
        }

        public final int getLastFrameTimeoutInterval() {
            return this.lastFrameTimeoutInterval;
        }

        public final int getLastFrameTimeoutResetMiddleResultThreshold() {
            return this.lastFrameTimeoutResetMiddleResultThreshold;
        }

        public final NewAudioInputParams getNewAudioInputParams() {
            return this.newAudioInputParams;
        }

        public final long getOggPageSize() {
            return this.oggPageSize;
        }

        public final int getRecordBufferSize() {
            return this.recordBufferSize;
        }

        public AudioSceneParams(int r100, int r101, int r102, int r103, int r104, long r105, AudioRecordParams r106, AudioRecordParams r110, AudioRecordParams r111, NewAudioInputParams r112) {
            Intrinsics.checkNotNullParameter(r106, "audioWithText");
            Intrinsics.checkNotNullParameter(r110, "audioRecord");
            Intrinsics.checkNotNullParameter(r111, "audioToText");
            Intrinsics.checkNotNullParameter(r112, "newAudioInputParams");
            this.lastFrameTimeoutInterval = r100;
            this.asrWaitingTipsInterval = r101;
            this.lastFrameTimeoutResetMiddleResultThreshold = r102;
            this.audioRecordSource = r103;
            this.recordBufferSize = r104;
            this.oggPageSize = r105;
            this.audioWithText = r106;
            this.audioRecord = r110;
            this.audioToText = r111;
            this.newAudioInputParams = r112;
        }

        public /* synthetic */ AudioSceneParams(int r210, int r211, int r212, int r213, int r214, long r215, AudioRecordParams r310, AudioRecordParams r311, AudioRecordParams r312, NewAudioInputParams r313, int r314, DefaultConstructorMarker r315) {
            if ((r314 & 1) == 0) goto L5;
            int r100 = 20;
        L7:
            if ((r314 & 2) == 0) goto L9;
            int r101 = 10;
        L10:
            int r102 = -1;
            if ((r314 & 4) == 0) goto L13;
            int r103 = -1;
        L15:
            if ((r314 & 8) == 0) goto L17;
            int r104 = 1;
        L19:
            if ((r314 & 16) != 0) goto L23;
            r102 = r214;
        L23:
            if ((r314 & 32) == 0) goto L25;
            long r105 = 40;
        L26:
            DefaultConstructorMarker r106 = null;
            int r110 = 3;
            int r111 = 0;
            if ((r314 & 64) == 0) goto L29;
            AudioRecordParams r107 = new AudioRecordParams(r111, r111, r110, r106);
        L31:
            if ((r314 & 128) == 0) goto L33;
            AudioRecordParams r112 = new AudioRecordParams(r111, r111, r110, r106);
        L35:
            if ((r314 & 256) == 0) goto L37;
            AudioRecordParams r113 = new AudioRecordParams(r111, r111, r110, r106);
        L39:
            if ((r314 & 512) == 0) goto L41;
            NewAudioInputParams r108 = new NewAudioInputParams(null, null, 0, 0, 0, 0, 0, 0, 0, 0, 1023, null);
        L42:
            this(r100, r101, r103, r104, r102, r105, r107, r112, r113, r108);
            return;
        L41:
            r108 = r313;
            goto L42
        L37:
            r113 = r312;
            goto L39
        L33:
            r112 = r311;
            goto L35
        L29:
            r107 = r310;
            goto L31
        L25:
            r105 = r215;
            goto L26
        L17:
            r104 = r213;
            goto L19
        L13:
            r103 = r212;
            goto L15
        L9:
            r101 = r211;
            goto L10
        L5:
            r100 = r210;
            goto L7
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001Bk\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÆ\u0003J\t\u0010 \u001a\u00020\u0006HÆ\u0003J\t\u0010!\u001a\u00020\u0006HÆ\u0003J\t\u0010\"\u001a\u00020\u0006HÆ\u0003J\t\u0010#\u001a\u00020\u0006HÆ\u0003J\t\u0010$\u001a\u00020\u0006HÆ\u0003J\t\u0010%\u001a\u00020\u0006HÆ\u0003Jm\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u0006HÆ\u0001J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020\u0006HÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0016\u0010\b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0016\u0010\t\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0016\u0010\n\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0016\u0010\u000b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0016\u0010\f\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0016\u0010\r\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014¨\u0006,"}, d2 = {"Lcom/ss/android/lark/audio/recorder/AudioRecordSettings$NewAudioInputParams;", "", "newVoiceFg", "", "textByDefaultFg", "audio2TextMaxDuration", "", "tokenMaxCount", "tokenSetUpCount", "tokenSetDownCount", "tokenInitCount", "audioAdditionalRecordTime", "audioUpdateRecordText", "audioNewCanRevert", "<init>", "(Ljava/lang/String;Ljava/lang/String;IIIIIIII)V", "getNewVoiceFg", "()Ljava/lang/String;", "getTextByDefaultFg", "getAudio2TextMaxDuration", "()I", "getTokenMaxCount", "getTokenSetUpCount", "getTokenSetDownCount", "getTokenInitCount", "getAudioAdditionalRecordTime", "getAudioUpdateRecordText", "getAudioNewCanRevert", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "", "other", "hashCode", "toString", "audio_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class NewAudioInputParams {

        @SerializedName("audio_max_duration")
        private final int audio2TextMaxDuration;

        @SerializedName("audio_additional_record_time")
        private final int audioAdditionalRecordTime;

        @SerializedName("audio_new_can_revert")
        private final int audioNewCanRevert;

        @SerializedName("audio_update_record_text")
        private final int audioUpdateRecordText;

        @SerializedName("fg_im_messenger_new_voice_input")
        private final String newVoiceFg;

        @SerializedName("fg_im_messenger_text_by_default")
        private final String textByDefaultFg;

        @SerializedName("token_first_step_up")
        private final int tokenInitCount;

        @SerializedName("token_upper_limit")
        private final int tokenMaxCount;

        @SerializedName("token_step_down")
        private final int tokenSetDownCount;

        @SerializedName("token_step_up")
        private final int tokenSetUpCount;

        public NewAudioInputParams() {
            this(null, null, 0, 0, 0, 0, 0, 0, 0, 0, 1023, null);
        }

        public static /* synthetic */ NewAudioInputParams copy$default(NewAudioInputParams r110, String r111, String r112, int r113, int r114, int r115, int r116, int r117, int r118, int r210, int r211, int r212, Object r213) {
            if ((r212 & 1) == 0) goto L5;
            String r100 = r110.newVoiceFg;
        L7:
            if ((r212 & 2) == 0) goto L9;
            String r101 = r110.textByDefaultFg;
        L11:
            if ((r212 & 4) == 0) goto L13;
            int r102 = r110.audio2TextMaxDuration;
        L15:
            if ((r212 & 8) == 0) goto L17;
            int r103 = r110.tokenMaxCount;
        L19:
            if ((r212 & 16) == 0) goto L21;
            int r104 = r110.tokenSetUpCount;
        L23:
            if ((r212 & 32) == 0) goto L25;
            int r105 = r110.tokenSetDownCount;
        L27:
            if ((r212 & 64) == 0) goto L29;
            int r106 = r110.tokenInitCount;
        L31:
            if ((r212 & 128) == 0) goto L33;
            int r107 = r110.audioAdditionalRecordTime;
        L35:
            if ((r212 & 256) == 0) goto L37;
            int r119 = r110.audioUpdateRecordText;
        L39:
            if ((r212 & 512) == 0) goto L41;
            int r108 = r110.audioNewCanRevert;
        L43:
            return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r119, r108);
        L41:
            r108 = r211;
            goto L43
        L37:
            r119 = r210;
            goto L39
        L33:
            r107 = r118;
            goto L35
        L29:
            r106 = r117;
            goto L31
        L25:
            r105 = r116;
            goto L27
        L21:
            r104 = r115;
            goto L23
        L17:
            r103 = r114;
            goto L19
        L13:
            r102 = r113;
            goto L15
        L9:
            r101 = r112;
            goto L11
        L5:
            r100 = r111;
            goto L7
        }

        public final String component1() {
            return this.newVoiceFg;
        }

        public final int component10() {
            return this.audioNewCanRevert;
        }

        public final String component2() {
            return this.textByDefaultFg;
        }

        public final int component3() {
            return this.audio2TextMaxDuration;
        }

        public final int component4() {
            return this.tokenMaxCount;
        }

        public final int component5() {
            return this.tokenSetUpCount;
        }

        public final int component6() {
            return this.tokenSetDownCount;
        }

        public final int component7() {
            return this.tokenInitCount;
        }

        public final int component8() {
            return this.audioAdditionalRecordTime;
        }

        public final int component9() {
            return this.audioUpdateRecordText;
        }

        public final NewAudioInputParams copy(String r110, String r111, int r112, int r113, int r114, int r115, int r116, int r210, int r211, int r212) {
            Intrinsics.checkNotNullParameter(r110, "newVoiceFg");
            Intrinsics.checkNotNullParameter(r111, "textByDefaultFg");
            return new NewAudioInputParams(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof NewAudioInputParams) == true) goto L8;
            return false;
        L8:
            NewAudioInputParams r101 = (NewAudioInputParams) r100;
            if (Intrinsics.areEqual(this.newVoiceFg, r101.newVoiceFg) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.textByDefaultFg, r101.textByDefaultFg) == true) goto L15;
            return false;
        L15:
            if (this.audio2TextMaxDuration == r101.audio2TextMaxDuration) goto L18;
            return false;
        L18:
            if (this.tokenMaxCount == r101.tokenMaxCount) goto L21;
            return false;
        L21:
            if (this.tokenSetUpCount == r101.tokenSetUpCount) goto L24;
            return false;
        L24:
            if (this.tokenSetDownCount == r101.tokenSetDownCount) goto L27;
            return false;
        L27:
            if (this.tokenInitCount == r101.tokenInitCount) goto L30;
            return false;
        L30:
            if (this.audioAdditionalRecordTime == r101.audioAdditionalRecordTime) goto L33;
            return false;
        L33:
            if (this.audioUpdateRecordText == r101.audioUpdateRecordText) goto L36;
            return false;
        L36:
            if (this.audioNewCanRevert == r101.audioNewCanRevert) goto L38;
            return false;
        L38:
            return true;
        }

        public int hashCode() {
            return (((((((((((((((((this.newVoiceFg.hashCode() * 31) + this.textByDefaultFg.hashCode()) * 31) + this.audio2TextMaxDuration) * 31) + this.tokenMaxCount) * 31) + this.tokenSetUpCount) * 31) + this.tokenSetDownCount) * 31) + this.tokenInitCount) * 31) + this.audioAdditionalRecordTime) * 31) + this.audioUpdateRecordText) * 31) + this.audioNewCanRevert;
        }

        public String toString() {
            return "NewAudioInputParams(newVoiceFg=" + this.newVoiceFg + ", textByDefaultFg=" + this.textByDefaultFg + ", audio2TextMaxDuration=" + this.audio2TextMaxDuration + ", tokenMaxCount=" + this.tokenMaxCount + ", tokenSetUpCount=" + this.tokenSetUpCount + ", tokenSetDownCount=" + this.tokenSetDownCount + ", tokenInitCount=" + this.tokenInitCount + ", audioAdditionalRecordTime=" + this.audioAdditionalRecordTime + ", audioUpdateRecordText=" + this.audioUpdateRecordText + ", audioNewCanRevert=" + this.audioNewCanRevert + ')';
        }

        public final int getAudio2TextMaxDuration() {
            return this.audio2TextMaxDuration;
        }

        public final int getAudioAdditionalRecordTime() {
            return this.audioAdditionalRecordTime;
        }

        public final int getAudioNewCanRevert() {
            return this.audioNewCanRevert;
        }

        public final int getAudioUpdateRecordText() {
            return this.audioUpdateRecordText;
        }

        public final String getNewVoiceFg() {
            return this.newVoiceFg;
        }

        public final String getTextByDefaultFg() {
            return this.textByDefaultFg;
        }

        public final int getTokenInitCount() {
            return this.tokenInitCount;
        }

        public final int getTokenMaxCount() {
            return this.tokenMaxCount;
        }

        public final int getTokenSetDownCount() {
            return this.tokenSetDownCount;
        }

        public final int getTokenSetUpCount() {
            return this.tokenSetUpCount;
        }

        public NewAudioInputParams(String r100, String r101, int r102, int r103, int r104, int r105, int r106, int r107, int r110, int r111) {
            Intrinsics.checkNotNullParameter(r100, "newVoiceFg");
            Intrinsics.checkNotNullParameter(r101, "textByDefaultFg");
            this.newVoiceFg = r100;
            this.textByDefaultFg = r101;
            this.audio2TextMaxDuration = r102;
            this.tokenMaxCount = r103;
            this.tokenSetUpCount = r104;
            this.tokenSetDownCount = r105;
            this.tokenInitCount = r106;
            this.audioAdditionalRecordTime = r107;
            this.audioUpdateRecordText = r110;
            this.audioNewCanRevert = r111;
        }

        public /* synthetic */ NewAudioInputParams(String r110, String r111, int r112, int r113, int r114, int r115, int r116, int r117, int r210, int r211, int r212, DefaultConstructorMarker r213) {
            String r100 = "";
            if ((r212 & 1) == 0) goto L5;
            String r101 = "";
        L7:
            if ((r212 & 2) != 0) goto L11;
            r100 = r111;
        L11:
            if ((r212 & 4) == 0) goto L13;
            int r102 = 300000;
        L15:
            if ((r212 & 8) == 0) goto L17;
            int r103 = 10;
        L18:
            int r104 = 1;
            if ((r212 & 16) == 0) goto L21;
            int r105 = 1;
        L23:
            if ((r212 & 32) != 0) goto L27;
            r104 = r115;
        L27:
            if ((r212 & 64) == 0) goto L29;
            int r106 = 5;
        L30:
            int r107 = 0;
            if ((r212 & 128) == 0) goto L33;
            int r108 = 0;
        L35:
            if ((r212 & 256) == 0) goto L37;
            int r118 = 0;
        L39:
            if ((r212 & 512) != 0) goto L42;
            r107 = r211;
        L42:
            this(r101, r100, r102, r103, r105, r104, r106, r108, r118, r107);
            return;
        L37:
            r118 = r210;
            goto L39
        L33:
            r108 = r117;
            goto L35
        L29:
            r106 = r116;
            goto L30
        L21:
            r105 = r114;
            goto L23
        L17:
            r103 = r113;
            goto L18
        L13:
            r102 = r112;
            goto L15
        L5:
            r101 = r110;
            goto L7
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001¨\u0006\u0005"}, d2 = {"com/ss/android/lark/audio/recorder/AudioRecordSettings$checkAndUpdateAudioSettings$newAudioSceneParams$1$1", "Lcom/google/gson/reflect/TypeToken;", "", "", "Lcom/ss/android/lark/audio/recorder/AudioRecordSettings$AudioSceneParams;", "audio_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a extends TypeToken<Map<String, ? extends AudioSceneParams>> {
        public a() {
        }
    }

    static {
        f409071a = new AtomicReference("");
        f409072b = new AtomicReference(MapsKt.emptyMap());
    }

    public static void a() {
        String r100 = SettingManager.getInstance().getString(C4750AudioRecordSettings.class);
        AtomicReference<String> r101 = f409071a;
        if (Intrinsics.areEqual(r100, r101.get()) == false) goto L5;
        return;
    L5:
        Log.i("AudioRecordSettings", "update audio settings: " + r100);
        r101.set(r100);
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L8
        Object r103 = Result.m9449constructorimpl((Map) new Gson().fromJson(r100, new a().getType()));     // Catch: Throwable -> L8
    L11:
        if (Result.m9455isFailureimpl(r103) == false) goto L13;
        r103 = null;
    L13:
        Map<String, AudioSceneParams> r104 = (Map) r103;
        if (r104 != null) goto L16;
        r104 = MapsKt.emptyMap();
    L16:
        f409072b.set(r104);
        return;
    L8:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    public static AudioSceneParams c() {
        a();
        AudioSceneParams r100 = f409072b.get().get("im");
        if (r100 == null) goto L6;
        return r100;
    L6:
        return new AudioSceneParams(0, 0, 0, 0, 0, 0, null, null, null, null, 1023, null);
    }

    public static NewAudioInputParams d() {
        a();
        AudioSceneParams r100 = f409072b.get().get("im");
        if (r100 == null) goto L7;
        return r100.getNewAudioInputParams();
    L7:
        return new NewAudioInputParams(null, null, 0, 0, 0, 0, 0, 0, 0, 0, 1023, null);
    }

    public static Set e() {
        a();
        AudioSceneParams r100 = f409072b.get().get("im");
        if (r100 == null) goto L9;
        NewAudioInputParams r101 = r100.getNewAudioInputParams();
        if (r101 == null) goto L9;
        Set r102 = SetsKt.setOf(new String[]{r101.getNewVoiceFg(), r101.getTextByDefaultFg()});
        if (r102 == null) goto L9;
        return r102;
    L9:
        return SetsKt.emptySet();
    }

    public static AudioRecordParams b(int r100) {
        a();
        AudioSceneParams r101 = f409072b.get().get("im");
        if (r101 == null) goto L14;
        if (r100 == 0) goto L13;
        if (r100 == 1) goto L18;
        if (r100 == 2) goto L17;
        return r101.getAudioWithText();
    L17:
        return r101.getAudioToText();
    L18:
        return r101.getAudioRecord();
    L13:
        return r101.getAudioWithText();
    L14:
        int r102 = 0;
        int r103 = 3;
        return new AudioRecordParams(r102, r102, r103, null);
    }
}
