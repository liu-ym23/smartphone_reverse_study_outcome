package com.obric.assistant.chat.component.list.pipeline.update;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/assistant/chat/component/list/pipeline/update/RecordingOperationCardKind;", "", "<init>", "(Ljava/lang/String;I)V", "TRANSIENT", "TERMINAL", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RecordingOperationCardKind extends Enum<RecordingOperationCardKind> {
    public static final RecordingOperationCardKind TERMINAL = null;
    public static final RecordingOperationCardKind TRANSIENT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RecordingOperationCardKind[] f386880a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f386881b = null;

    public static EnumEntries<RecordingOperationCardKind> getEntries() {
        return f386881b;
    }

    static {
        RecordingOperationCardKind r100 = new RecordingOperationCardKind("TRANSIENT", 0);
        TRANSIENT = r100;
        RecordingOperationCardKind r101 = new RecordingOperationCardKind("TERMINAL", 1);
        TERMINAL = r101;
        RecordingOperationCardKind[] r102 = {r100, r101};
        f386880a = r102;
        f386881b = EnumEntriesKt.enumEntries(r102);
    }

    public static RecordingOperationCardKind[] values() {
        return (RecordingOperationCardKind[]) f386880a.clone();
    }

    public static RecordingOperationCardKind valueOf(String r100) {
        return (RecordingOperationCardKind) a.a(RecordingOperationCardKind.class, r100);
    }

    public RecordingOperationCardKind(String r100, int r101) {
        super(r100, r101);
    }
}
