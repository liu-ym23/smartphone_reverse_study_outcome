package com.bytedance.ee.bear.document.render.node;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/document/render/node/DocLoadingState;", "", "<init>", "(Ljava/lang/String;I)V", "INIT", "WAITING_DOWNLOAD", "WAITING_PRELOAD", "RENDERING", "CANCELED", "OVERTIME", "SUCCESS", "FAIL", "docs-document-sdk-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DocLoadingState extends Enum<DocLoadingState> {
    public static final DocLoadingState CANCELED = null;
    public static final DocLoadingState FAIL = null;
    public static final DocLoadingState INIT = null;
    public static final DocLoadingState OVERTIME = null;
    public static final DocLoadingState RENDERING = null;
    public static final DocLoadingState SUCCESS = null;
    public static final DocLoadingState WAITING_DOWNLOAD = null;
    public static final DocLoadingState WAITING_PRELOAD = null;
    public static final /* synthetic */ DocLoadingState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DocLoadingState> getEntries() {
        return b;
    }

    static {
        DocLoadingState r0 = new DocLoadingState("INIT", 0);
        INIT = r0;
        DocLoadingState r1 = new DocLoadingState("WAITING_DOWNLOAD", 1);
        WAITING_DOWNLOAD = r1;
        DocLoadingState r3 = new DocLoadingState("WAITING_PRELOAD", 2);
        WAITING_PRELOAD = r3;
        DocLoadingState r5 = new DocLoadingState("RENDERING", 3);
        RENDERING = r5;
        DocLoadingState r7 = new DocLoadingState("CANCELED", 4);
        CANCELED = r7;
        DocLoadingState r9 = new DocLoadingState("OVERTIME", 5);
        OVERTIME = r9;
        DocLoadingState r11 = new DocLoadingState("SUCCESS", 6);
        SUCCESS = r11;
        DocLoadingState r13 = new DocLoadingState("FAIL", 7);
        FAIL = r13;
        DocLoadingState[] r16 = {r0, r1, r3, r5, r7, r9, r11, r13};
        a = r16;
        b = EnumEntriesKt.enumEntries(r16);
    }

    public static DocLoadingState[] values() {
        return (DocLoadingState[]) a.clone();
    }

    public static DocLoadingState valueOf(String r1) {
        return (DocLoadingState) r27.a.a(DocLoadingState.class, r1);
    }

    public DocLoadingState(String r1, int r2) {
        super(r1, r2);
    }
}
