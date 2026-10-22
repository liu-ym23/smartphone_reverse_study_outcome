package com.larus.kmp.voice_setting.voice.image;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/kmp/voice_setting/voice/image/VoiceImageBizTag;", "", "tagName", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getTagName", "()Ljava/lang/String;", "CREATION_IMAGE", "flow-voice-setting-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VoiceImageBizTag extends Enum<VoiceImageBizTag> {
    public static final VoiceImageBizTag CREATION_IMAGE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VoiceImageBizTag[] f353397a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f353398b = null;
    private final String tagName;

    public static EnumEntries<VoiceImageBizTag> getEntries() {
        return f353398b;
    }

    static {
        VoiceImageBizTag r100 = new VoiceImageBizTag();
        CREATION_IMAGE = r100;
        VoiceImageBizTag[] r101 = {r100};
        f353397a = r101;
        f353398b = EnumEntriesKt.enumEntries(r101);
    }

    public VoiceImageBizTag() {
        super("CREATION_IMAGE", 0);
        this.tagName = "creation_image";
    }

    public static VoiceImageBizTag[] values() {
        return (VoiceImageBizTag[]) f353397a.clone();
    }

    public final String getTagName() {
        return this.tagName;
    }

    public static VoiceImageBizTag valueOf(String r100) {
        return (VoiceImageBizTag) a.a(VoiceImageBizTag.class, r100);
    }
}
