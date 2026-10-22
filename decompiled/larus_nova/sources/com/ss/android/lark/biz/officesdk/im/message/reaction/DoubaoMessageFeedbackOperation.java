package com.ss.android.lark.biz.officesdk.im.message.reaction;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/biz/officesdk/im/message/reaction/DoubaoMessageFeedbackOperation;", "", "<init>", "(Ljava/lang/String;I)V", "ADD", "REMOVE", "officesdk-im-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoubaoMessageFeedbackOperation extends Enum<DoubaoMessageFeedbackOperation> {
    public static final DoubaoMessageFeedbackOperation ADD = null;
    public static final DoubaoMessageFeedbackOperation REMOVE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoubaoMessageFeedbackOperation[] f410607a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f410608b = null;

    public static EnumEntries<DoubaoMessageFeedbackOperation> getEntries() {
        return f410608b;
    }

    static {
        DoubaoMessageFeedbackOperation r100 = new DoubaoMessageFeedbackOperation("ADD", 0);
        ADD = r100;
        DoubaoMessageFeedbackOperation r101 = new DoubaoMessageFeedbackOperation("REMOVE", 1);
        REMOVE = r101;
        DoubaoMessageFeedbackOperation[] r102 = {r100, r101};
        f410607a = r102;
        f410608b = EnumEntriesKt.enumEntries(r102);
    }

    public static DoubaoMessageFeedbackOperation[] values() {
        return (DoubaoMessageFeedbackOperation[]) f410607a.clone();
    }

    public static DoubaoMessageFeedbackOperation valueOf(String r100) {
        return (DoubaoMessageFeedbackOperation) a.a(DoubaoMessageFeedbackOperation.class, r100);
    }

    public DoubaoMessageFeedbackOperation(String r100, int r101) {
        super(r100, r101);
    }
}
