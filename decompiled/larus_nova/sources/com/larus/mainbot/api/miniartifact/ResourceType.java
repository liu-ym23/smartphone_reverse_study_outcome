package com.larus.mainbot.api.miniartifact;

import com.bytedance.speech.speechengine.SpeechEngineDefines;
import com.larus.network.http.ServiceType;
import com.ss.android.ugc.effectmanager.effect.model.ComposerHelper;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/larus/mainbot/api/miniartifact/ResourceType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", SpeechEngineDefines.RECORDER_TYPE_FILE, "Image", "Video", ServiceType.AUDIO, SpeechEngineDefines.RECORDER_TYPE_DIRECTORY, ComposerHelper.CONFIG_LINK, "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ResourceType extends Enum<ResourceType> {
    public static final ResourceType Audio = null;
    public static final ResourceType Directory = null;
    public static final ResourceType File = null;
    public static final ResourceType Image = null;
    public static final ResourceType Link = null;
    public static final ResourceType Video = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ResourceType[] f358424a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f358425b = null;
    private final int value;

    public static EnumEntries<ResourceType> getEntries() {
        return f358425b;
    }

    static {
        ResourceType r100 = new ResourceType(SpeechEngineDefines.RECORDER_TYPE_FILE, 0, 1);
        File = r100;
        ResourceType r101 = new ResourceType("Image", 1, 2);
        Image = r101;
        ResourceType r102 = new ResourceType("Video", 2, 3);
        Video = r102;
        ResourceType r103 = new ResourceType(ServiceType.AUDIO, 3, 4);
        Audio = r103;
        ResourceType r104 = new ResourceType(SpeechEngineDefines.RECORDER_TYPE_DIRECTORY, 4, 5);
        Directory = r104;
        ResourceType r110 = new ResourceType(ComposerHelper.CONFIG_LINK, 5, 6);
        Link = r110;
        ResourceType[] r111 = {r100, r101, r102, r103, r104, r110};
        f358424a = r111;
        f358425b = EnumEntriesKt.enumEntries(r111);
    }

    public static ResourceType[] values() {
        return (ResourceType[]) f358424a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ResourceType valueOf(String r100) {
        return (ResourceType) a.a(ResourceType.class, r100);
    }

    public ResourceType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
