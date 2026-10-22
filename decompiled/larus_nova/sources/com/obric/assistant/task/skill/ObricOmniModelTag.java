package com.obric.assistant.task.skill;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/obric/assistant/task/skill/ObricOmniModelTag;", "", "value", "", "defaultModelId", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "getDefaultModelId", "QUICK", "PROFESSIONAL", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ObricOmniModelTag extends Enum<ObricOmniModelTag> {
    public static final ObricOmniModelTag PROFESSIONAL = null;
    public static final ObricOmniModelTag QUICK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ObricOmniModelTag[] f393405a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f393406b = null;
    private final String defaultModelId;
    private final String value;

    public static EnumEntries<ObricOmniModelTag> getEntries() {
        return f393406b;
    }

    static {
        ObricOmniModelTag r100 = new ObricOmniModelTag("QUICK", 0, "quick", "0");
        QUICK = r100;
        ObricOmniModelTag r101 = new ObricOmniModelTag("PROFESSIONAL", 1, "professional", "3");
        PROFESSIONAL = r101;
        ObricOmniModelTag[] r102 = {r100, r101};
        f393405a = r102;
        f393406b = EnumEntriesKt.enumEntries(r102);
    }

    public static ObricOmniModelTag[] values() {
        return (ObricOmniModelTag[]) f393405a.clone();
    }

    public final String getDefaultModelId() {
        return this.defaultModelId;
    }

    public final String getValue() {
        return this.value;
    }

    public static ObricOmniModelTag valueOf(String r100) {
        return (ObricOmniModelTag) r27.a.a(ObricOmniModelTag.class, r100);
    }

    public ObricOmniModelTag(String r100, int r101, String r102, String r103) {
        super(r100, r101);
        this.value = r102;
        this.defaultModelId = r103;
    }
}
