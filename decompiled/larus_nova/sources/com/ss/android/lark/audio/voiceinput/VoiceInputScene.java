package com.ss.android.lark.audio.voiceinput;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u0010"}, d2 = {"Lcom/ss/android/lark/audio/voiceinput/VoiceInputScene;", "", "scene", "", "<init>", "(Ljava/lang/String;II)V", "getScene", "()I", "EnterpriseAnswer", "AdvancedMode", "UniverseSearch", "NormalChat", "SecretChat", "CcmComment", "toString", "", "audio_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VoiceInputScene extends Enum<VoiceInputScene> {
    public static final VoiceInputScene AdvancedMode = null;
    public static final VoiceInputScene CcmComment = null;
    public static final VoiceInputScene EnterpriseAnswer = null;
    public static final VoiceInputScene NormalChat = null;
    public static final VoiceInputScene SecretChat = null;
    public static final VoiceInputScene UniverseSearch = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VoiceInputScene[] f409178a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f409179b = null;
    private final int scene;

    public static EnumEntries<VoiceInputScene> getEntries() {
        return f409179b;
    }

    static {
        VoiceInputScene r100 = new VoiceInputScene("EnterpriseAnswer", 0, 0);
        EnterpriseAnswer = r100;
        VoiceInputScene r101 = new VoiceInputScene("AdvancedMode", 1, 1);
        AdvancedMode = r101;
        VoiceInputScene r102 = new VoiceInputScene("UniverseSearch", 2, 2);
        UniverseSearch = r102;
        VoiceInputScene r103 = new VoiceInputScene("NormalChat", 3, 3);
        NormalChat = r103;
        VoiceInputScene r104 = new VoiceInputScene("SecretChat", 4, 4);
        SecretChat = r104;
        VoiceInputScene r105 = new VoiceInputScene("CcmComment", 5, 5);
        CcmComment = r105;
        VoiceInputScene[] r110 = {r100, r101, r102, r103, r104, r105};
        f409178a = r110;
        f409179b = EnumEntriesKt.enumEntries(r110);
    }

    public static VoiceInputScene[] values() {
        return (VoiceInputScene[]) f409178a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r100 = this.scene;
        if (r100 != 0) goto L5;
        return "EnterpriseAnswer";
    L5:
        if (r100 != 1) goto L7;
        return "AdvancedMode";
    L7:
        if (r100 != 2) goto L9;
        return "UniverseSearch";
    L9:
        if (r100 != 3) goto L11;
        return "NormalChat";
    L11:
        if (r100 != 4) goto L13;
        return "SecretChat";
    L13:
        if (r100 != 5) goto L26;
        return "CcmComment";
    L26:
        return "NormalChat";
    }

    public final int getScene() {
        return this.scene;
    }

    public static VoiceInputScene valueOf(String r100) {
        return (VoiceInputScene) r27.a.a(VoiceInputScene.class, r100);
    }

    public VoiceInputScene(String r100, int r101, int r102) {
        super(r100, r101);
        this.scene = r102;
    }
}
