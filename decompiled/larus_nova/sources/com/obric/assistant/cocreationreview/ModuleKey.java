package com.obric.assistant.cocreationreview;

import com.bytedance.android.ecom.arch.slice.slices.template.TemplateNodeType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0080\u0081\u0002\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0011"}, d2 = {"Lcom/obric/assistant/cocreationreview/ModuleKey;", "", TemplateNodeType.RAW, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getRaw", "()Ljava/lang/String;", "PROACTIVE_AGENT", "SCREEN_MEMORY", "AUDIO_MEMORY", "AUTO_MEMORY_PRO", "COLLECTION_MEMORY", "PERSONAL_MEMORY", "SEARCH_QA", "OMNI", "Companion", "cocreationreview_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ModuleKey extends Enum<ModuleKey> {
    public static final ModuleKey AUDIO_MEMORY = null;
    public static final ModuleKey AUTO_MEMORY_PRO = null;
    public static final ModuleKey COLLECTION_MEMORY = null;
    public static final a Companion = null;
    public static final ModuleKey OMNI = null;
    public static final ModuleKey PERSONAL_MEMORY = null;
    public static final ModuleKey PROACTIVE_AGENT = null;
    public static final ModuleKey SCREEN_MEMORY = null;
    public static final ModuleKey SEARCH_QA = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ModuleKey[] f387148a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f387149b = null;
    private final String raw;

    public static EnumEntries<ModuleKey> getEntries() {
        return f387149b;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.obric.assistant.cocreationreview.ModuleKey$a] */
    static {
        ModuleKey r100 = new ModuleKey("PROACTIVE_AGENT", 0, "proactive_agent");
        PROACTIVE_AGENT = r100;
        ModuleKey r101 = new ModuleKey("SCREEN_MEMORY", 1, "screen_memory");
        SCREEN_MEMORY = r101;
        ModuleKey r102 = new ModuleKey("AUDIO_MEMORY", 2, "audio_memory");
        AUDIO_MEMORY = r102;
        ModuleKey r103 = new ModuleKey("AUTO_MEMORY_PRO", 3, "auto_memory_pro");
        AUTO_MEMORY_PRO = r103;
        ModuleKey r104 = new ModuleKey("COLLECTION_MEMORY", 4, "collection_memory");
        COLLECTION_MEMORY = r104;
        ModuleKey r105 = new ModuleKey("PERSONAL_MEMORY", 5, "personal_memory");
        PERSONAL_MEMORY = r105;
        ModuleKey r110 = new ModuleKey("SEARCH_QA", 6, "search_qa");
        SEARCH_QA = r110;
        ModuleKey r111 = new ModuleKey("OMNI", 7, "omni");
        OMNI = r111;
        ModuleKey[] r112 = {r100, r101, r102, r103, r104, r105, r110, r111};
        f387148a = r112;
        f387149b = EnumEntriesKt.enumEntries(r112);
        Companion = new a();
    }

    public static ModuleKey[] values() {
        return (ModuleKey[]) f387148a.clone();
    }

    public final String getRaw() {
        return this.raw;
    }

    public static ModuleKey valueOf(String r100) {
        return (ModuleKey) r27.a.a(ModuleKey.class, r100);
    }

    public ModuleKey(String r100, int r101, String r102) {
        super(r100, r101);
        this.raw = r102;
    }
}
