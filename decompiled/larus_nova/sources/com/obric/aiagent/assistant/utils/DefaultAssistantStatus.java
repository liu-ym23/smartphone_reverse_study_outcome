package com.obric.aiagent.assistant.utils;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/obric/aiagent/assistant/utils/DefaultAssistantStatus;", "", "errorCode", "", "errorMessage", "", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "getErrorCode", "()I", "getErrorMessage", "()Ljava/lang/String;", "Unknown", "IsDefaultAssistant", "NotDefaultAssistant", "assistant-status-utils_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DefaultAssistantStatus extends Enum<DefaultAssistantStatus> {
    public static final DefaultAssistantStatus IsDefaultAssistant = null;
    public static final DefaultAssistantStatus NotDefaultAssistant = null;
    public static final DefaultAssistantStatus Unknown = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DefaultAssistantStatus[] f384604a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f384605b = null;
    private final int errorCode;
    private final String errorMessage;

    public static EnumEntries<DefaultAssistantStatus> getEntries() {
        return f384605b;
    }

    static {
        DefaultAssistantStatus r100 = new DefaultAssistantStatus("Unknown", 0, -1, "unknown");
        Unknown = r100;
        DefaultAssistantStatus r101 = new DefaultAssistantStatus("IsDefaultAssistant", 1, 0, "isDefaultAssistant");
        IsDefaultAssistant = r101;
        DefaultAssistantStatus r102 = new DefaultAssistantStatus("NotDefaultAssistant", 2, 1, "notDefaultAssistant");
        NotDefaultAssistant = r102;
        DefaultAssistantStatus[] r103 = {r100, r101, r102};
        f384604a = r103;
        f384605b = EnumEntriesKt.enumEntries(r103);
    }

    public static DefaultAssistantStatus[] values() {
        return (DefaultAssistantStatus[]) f384604a.clone();
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public static DefaultAssistantStatus valueOf(String r100) {
        return (DefaultAssistantStatus) r27.a.a(DefaultAssistantStatus.class, r100);
    }

    public DefaultAssistantStatus(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.errorCode = r102;
        this.errorMessage = r103;
    }
}
