package com.larus.bmhome.chat.bean;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/bmhome/chat/bean/DeepThinkFoldStatus;", "", "<init>", "(Ljava/lang/String;I)V", "CompleteFold", "HalfFold", "CompleteExpand", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DeepThinkFoldStatus extends Enum<DeepThinkFoldStatus> {
    public static final DeepThinkFoldStatus CompleteExpand = null;
    public static final DeepThinkFoldStatus CompleteFold = null;
    public static final DeepThinkFoldStatus HalfFold = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DeepThinkFoldStatus[] f297407a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f297408b = null;

    public static EnumEntries<DeepThinkFoldStatus> getEntries() {
        return f297408b;
    }

    static {
        DeepThinkFoldStatus r100 = new DeepThinkFoldStatus("CompleteFold", 0);
        CompleteFold = r100;
        DeepThinkFoldStatus r101 = new DeepThinkFoldStatus("HalfFold", 1);
        HalfFold = r101;
        DeepThinkFoldStatus r102 = new DeepThinkFoldStatus("CompleteExpand", 2);
        CompleteExpand = r102;
        DeepThinkFoldStatus[] r103 = {r100, r101, r102};
        f297407a = r103;
        f297408b = EnumEntriesKt.enumEntries(r103);
    }

    public static DeepThinkFoldStatus[] values() {
        return (DeepThinkFoldStatus[]) f297407a.clone();
    }

    public static DeepThinkFoldStatus valueOf(String r100) {
        return (DeepThinkFoldStatus) r27.a.a(DeepThinkFoldStatus.class, r100);
    }

    public DeepThinkFoldStatus(String r100, int r101) {
        super(r100, r101);
    }
}
