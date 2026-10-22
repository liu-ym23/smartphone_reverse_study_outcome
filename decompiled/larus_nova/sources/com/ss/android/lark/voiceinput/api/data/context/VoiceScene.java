package com.ss.android.lark.voiceinput.api.data.context;

import com.bytedance.ee.bear.document.offline.sync.PreloadConfigModel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/voiceinput/api/data/context/VoiceScene;", "", "<init>", "(Ljava/lang/String;I)V", "Default", "IM", PreloadConfigModel.VERSION_CHECK_TYPE_DOC, "voice-input-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VoiceScene extends Enum<VoiceScene> {
    public static final VoiceScene DOC = null;
    public static final VoiceScene Default = null;
    public static final VoiceScene IM = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VoiceScene[] f445030a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f445031b = null;

    public static EnumEntries<VoiceScene> getEntries() {
        return f445031b;
    }

    static {
        VoiceScene r100 = new VoiceScene("Default", 0);
        Default = r100;
        VoiceScene r101 = new VoiceScene("IM", 1);
        IM = r101;
        VoiceScene r102 = new VoiceScene(PreloadConfigModel.VERSION_CHECK_TYPE_DOC, 2);
        DOC = r102;
        VoiceScene[] r103 = {r100, r101, r102};
        f445030a = r103;
        f445031b = EnumEntriesKt.enumEntries(r103);
    }

    public static VoiceScene[] values() {
        return (VoiceScene[]) f445030a.clone();
    }

    public static VoiceScene valueOf(String r100) {
        return (VoiceScene) a.a(VoiceScene.class, r100);
    }

    public VoiceScene(String r100, int r101) {
        super(r100, r101);
    }
}
