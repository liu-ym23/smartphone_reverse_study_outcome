package com.obric.assistant.task.skill;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/obric/assistant/task/skill/ObricOmniModeTag;", "", "value", "", "defaultModeId", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "getDefaultModeId", "QUICK", "PROFESSIONAL", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ObricOmniModeTag extends Enum<ObricOmniModeTag> {
    public static final ObricOmniModeTag PROFESSIONAL = null;
    public static final ObricOmniModeTag QUICK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ObricOmniModeTag[] f393395a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f393396b = null;
    private final String defaultModeId;
    private final String value;

    public static EnumEntries<ObricOmniModeTag> getEntries() {
        return f393396b;
    }

    static {
        ObricOmniModeTag r100 = new ObricOmniModeTag("QUICK", 0, "quick", "1");
        QUICK = r100;
        ObricOmniModeTag r101 = new ObricOmniModeTag("PROFESSIONAL", 1, "professional", "2");
        PROFESSIONAL = r101;
        ObricOmniModeTag[] r102 = {r100, r101};
        f393395a = r102;
        f393396b = EnumEntriesKt.enumEntries(r102);
    }

    public static ObricOmniModeTag[] values() {
        return (ObricOmniModeTag[]) f393395a.clone();
    }

    public final String getDefaultModeId() {
        return this.defaultModeId;
    }

    public final String getValue() {
        return this.value;
    }

    public static ObricOmniModeTag valueOf(String r100) {
        return (ObricOmniModeTag) r27.a.a(ObricOmniModeTag.class, r100);
    }

    public ObricOmniModeTag(String r100, int r101, String r102, String r103) {
        super(r100, r101);
        this.value = r102;
        this.defaultModeId = r103;
    }
}
