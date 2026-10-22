package com.obric.assistant.settings;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0011"}, d2 = {"Lcom/obric/assistant/settings/AILabSettingItem;", "", "uriKey", "", "autoUpdate", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;Z)V", "getUriKey", "()Ljava/lang/String;", "getAutoUpdate", "()Z", "VoiceMemory", "ScreenMemory", "AILabStatus", "MemoryPermissonStatus", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AILabSettingItem extends Enum<AILabSettingItem> {
    public static final AILabSettingItem AILabStatus = null;
    public static final a Companion = null;
    public static final AILabSettingItem MemoryPermissonStatus = null;
    public static final AILabSettingItem ScreenMemory = null;
    public static final AILabSettingItem VoiceMemory = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AILabSettingItem[] f391695a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f391696b = null;
    private final boolean autoUpdate;
    private final String uriKey;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<AILabSettingItem> getEntries() {
        return f391696b;
    }

    static {
        AILabSettingItem r100 = new AILabSettingItem("VoiceMemory", 0, "voice_memory");
        VoiceMemory = r100;
        AILabSettingItem r101 = new AILabSettingItem("ScreenMemory", 1, "screen_memory");
        ScreenMemory = r101;
        AILabSettingItem r102 = new AILabSettingItem("AILabStatus", 2, "ai_lab_status");
        AILabStatus = r102;
        AILabSettingItem r103 = new AILabSettingItem("MemoryPermissonStatus", 3, "memory_permission_status");
        MemoryPermissonStatus = r103;
        AILabSettingItem[] r104 = {r100, r101, r102, r103};
        f391695a = r104;
        f391696b = EnumEntriesKt.enumEntries(r104);
        Companion = new a();
    }

    public static AILabSettingItem[] values() {
        return (AILabSettingItem[]) f391695a.clone();
    }

    public final boolean getAutoUpdate() {
        return this.autoUpdate;
    }

    public final String getUriKey() {
        return this.uriKey;
    }

    public static AILabSettingItem valueOf(String r100) {
        return (AILabSettingItem) r27.a.a(AILabSettingItem.class, r100);
    }

    public AILabSettingItem(String r100, int r101, String r102) {
        super(r100, r101);
        this.uriKey = r102;
        this.autoUpdate = true;
    }
}
