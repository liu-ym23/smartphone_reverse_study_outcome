package com.ss.android.lark.biz.im.api.extension.keyboard.menu.voice;

import com.larus.network.http.ServiceType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/biz/im/api/extension/keyboard/menu/voice/VoicePanelId;", "", "<init>", "(Ljava/lang/String;I)V", ServiceType.AUDIO, "AudioWithText", "Audio2Text", "im-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VoicePanelId extends Enum<VoicePanelId> {
    public static final VoicePanelId Audio = null;
    public static final VoicePanelId Audio2Text = null;
    public static final VoicePanelId AudioWithText = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VoicePanelId[] f410150a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f410151b = null;

    public static EnumEntries<VoicePanelId> getEntries() {
        return f410151b;
    }

    static {
        VoicePanelId r100 = new VoicePanelId(ServiceType.AUDIO, 0);
        Audio = r100;
        VoicePanelId r101 = new VoicePanelId("AudioWithText", 1);
        AudioWithText = r101;
        VoicePanelId r102 = new VoicePanelId("Audio2Text", 2);
        Audio2Text = r102;
        VoicePanelId[] r103 = {r100, r101, r102};
        f410150a = r103;
        f410151b = EnumEntriesKt.enumEntries(r103);
    }

    public static VoicePanelId[] values() {
        return (VoicePanelId[]) f410150a.clone();
    }

    public static VoicePanelId valueOf(String r100) {
        return (VoicePanelId) a.a(VoicePanelId.class, r100);
    }

    public VoicePanelId(String r100, int r101) {
        super(r100, r101);
    }
}
