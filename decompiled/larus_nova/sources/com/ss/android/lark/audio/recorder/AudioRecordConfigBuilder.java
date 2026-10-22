package com.ss.android.lark.audio.recorder;

import com.ss.android.lark.chameleon.container.webcontainer.res.resupdate.ChameleonResConstants;
import com.ss.ttvideoengine.DataLoaderHelper;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/audio/recorder/AudioRecordConfigBuilder;", "", "audioRecordConfig", "Lcom/ss/android/lark/audio/recorder/AudioRecordConfig;", "<init>", "(Ljava/lang/String;ILcom/ss/android/lark/audio/recorder/AudioRecordConfig;)V", "getAudioRecordConfig", "()Lcom/ss/android/lark/audio/recorder/AudioRecordConfig;", "IM", "CCM", "BASE_FORM", "audio_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AudioRecordConfigBuilder extends Enum<AudioRecordConfigBuilder> {
    public static final AudioRecordConfigBuilder BASE_FORM = null;
    public static final AudioRecordConfigBuilder CCM = null;
    public static final AudioRecordConfigBuilder IM = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AudioRecordConfigBuilder[] f409069a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f409070b = null;
    private final c audioRecordConfig;

    public static EnumEntries<AudioRecordConfigBuilder> getEntries() {
        return f409070b;
    }

    static {
        AudioRecordConfigBuilder r100 = new AudioRecordConfigBuilder("IM", 0, new c("im", new b(AnonymousClass1.INSTANCE, AnonymousClass2.INSTANCE), "LARK-PSDA-messenger_record_audio", 100, false, DataLoaderHelper.DATALOADER_KEY_INT_PRELOAD_INFO_RECORD_MAX_COUNT));
        IM = r100;
        AudioRecordConfigBuilder r101 = new AudioRecordConfigBuilder("CCM", 1, new c(ChameleonResConstants.CCM_ROOT_DIR, new b(AnonymousClass3.INSTANCE, AnonymousClass4.INSTANCE), "LARK-PSDA-ccm_android_comment_start_record_audio", 0, false, DataLoaderHelper.DATALOADER_KEY_INT_PRELOAD_INFO_RECORD_MAX_COUNT));
        CCM = r101;
        AudioRecordConfigBuilder r102 = new AudioRecordConfigBuilder("BASE_FORM", 2, new c("base_form", new b(AnonymousClass5.INSTANCE, AnonymousClass6.INSTANCE), "LARK-PSDA-base_form_request_audio_record_permission", 100, true, 1008));
        BASE_FORM = r102;
        AudioRecordConfigBuilder[] r103 = {r100, r101, r102};
        f409069a = r103;
        f409070b = EnumEntriesKt.enumEntries(r103);
    }

    public static AudioRecordConfigBuilder[] values() {
        return (AudioRecordConfigBuilder[]) f409069a.clone();
    }

    public final c getAudioRecordConfig() {
        return this.audioRecordConfig;
    }

    public static AudioRecordConfigBuilder valueOf(String r100) {
        return (AudioRecordConfigBuilder) r27.a.a(AudioRecordConfigBuilder.class, r100);
    }

    public AudioRecordConfigBuilder(String r100, int r101, c r102) {
        super(r100, r101);
        this.audioRecordConfig = r102;
    }
}
