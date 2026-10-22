package com.obric.assistant.cocreationreview.modules.memory;

import com.bytedance.android.ecom.arch.slice.slices.template.TemplateNodeType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0080\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/obric/assistant/cocreationreview/modules/memory/MemoryDataReviewModuleKey;", "", TemplateNodeType.RAW, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getRaw", "()Ljava/lang/String;", "SCREEN_MEMORY", "AUDIO_MEMORY", "AUTO_MEMORY_PRO", "COLLECTION_MEMORY", "PERSONAL_MEMORY", "Companion", "cocreationreview_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MemoryDataReviewModuleKey extends Enum<MemoryDataReviewModuleKey> {
    public static final MemoryDataReviewModuleKey AUDIO_MEMORY = null;
    public static final MemoryDataReviewModuleKey AUTO_MEMORY_PRO = null;
    public static final MemoryDataReviewModuleKey COLLECTION_MEMORY = null;
    public static final a Companion = null;
    public static final MemoryDataReviewModuleKey PERSONAL_MEMORY = null;
    public static final MemoryDataReviewModuleKey SCREEN_MEMORY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MemoryDataReviewModuleKey[] f387397a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f387398b = null;
    private final String raw;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<MemoryDataReviewModuleKey> getEntries() {
        return f387398b;
    }

    static {
        MemoryDataReviewModuleKey r100 = new MemoryDataReviewModuleKey("SCREEN_MEMORY", 0, "screen_memory");
        SCREEN_MEMORY = r100;
        MemoryDataReviewModuleKey r101 = new MemoryDataReviewModuleKey("AUDIO_MEMORY", 1, "auditory_memory");
        AUDIO_MEMORY = r101;
        MemoryDataReviewModuleKey r102 = new MemoryDataReviewModuleKey("AUTO_MEMORY_PRO", 2, "memory_task");
        AUTO_MEMORY_PRO = r102;
        MemoryDataReviewModuleKey r103 = new MemoryDataReviewModuleKey("COLLECTION_MEMORY", 3, "collection_memory");
        COLLECTION_MEMORY = r103;
        MemoryDataReviewModuleKey r104 = new MemoryDataReviewModuleKey("PERSONAL_MEMORY", 4, "personal_info_memory");
        PERSONAL_MEMORY = r104;
        MemoryDataReviewModuleKey[] r105 = {r100, r101, r102, r103, r104};
        f387397a = r105;
        f387398b = EnumEntriesKt.enumEntries(r105);
        Companion = new a();
    }

    public static MemoryDataReviewModuleKey[] values() {
        return (MemoryDataReviewModuleKey[]) f387397a.clone();
    }

    public final String getRaw() {
        return this.raw;
    }

    public static MemoryDataReviewModuleKey valueOf(String r100) {
        return (MemoryDataReviewModuleKey) r27.a.a(MemoryDataReviewModuleKey.class, r100);
    }

    public MemoryDataReviewModuleKey(String r100, int r101, String r102) {
        super(r100, r101);
        this.raw = r102;
    }
}
