package com.bytedance.ee.bear.document.render.node;

import com.android.ttcjpaysdk.base.h5.cjjsb.constant.ErrorCode;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/document/render/node/DocLoadingState;", "", "<init>", "(Ljava/lang/String;I)V", ErrorCode.INIT, "WAITING_DOWNLOAD", "WAITING_PRELOAD", "RENDERING", "CANCELED", "OVERTIME", "SUCCESS", "FAIL", "docs-document-sdk-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DocLoadingState extends Enum<DocLoadingState> {
    public static final DocLoadingState CANCELED = null;
    public static final DocLoadingState FAIL = null;
    public static final DocLoadingState INIT = null;
    public static final DocLoadingState OVERTIME = null;
    public static final DocLoadingState RENDERING = null;
    public static final DocLoadingState SUCCESS = null;
    public static final DocLoadingState WAITING_DOWNLOAD = null;
    public static final DocLoadingState WAITING_PRELOAD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DocLoadingState[] f221325a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f221326b = null;

    public static EnumEntries<DocLoadingState> getEntries() {
        return f221326b;
    }

    static {
        DocLoadingState r100 = new DocLoadingState(ErrorCode.INIT, 0);
        INIT = r100;
        DocLoadingState r101 = new DocLoadingState("WAITING_DOWNLOAD", 1);
        WAITING_DOWNLOAD = r101;
        DocLoadingState r102 = new DocLoadingState("WAITING_PRELOAD", 2);
        WAITING_PRELOAD = r102;
        DocLoadingState r103 = new DocLoadingState("RENDERING", 3);
        RENDERING = r103;
        DocLoadingState r104 = new DocLoadingState("CANCELED", 4);
        CANCELED = r104;
        DocLoadingState r105 = new DocLoadingState("OVERTIME", 5);
        OVERTIME = r105;
        DocLoadingState r110 = new DocLoadingState("SUCCESS", 6);
        SUCCESS = r110;
        DocLoadingState r111 = new DocLoadingState("FAIL", 7);
        FAIL = r111;
        DocLoadingState[] r112 = {r100, r101, r102, r103, r104, r105, r110, r111};
        f221325a = r112;
        f221326b = EnumEntriesKt.enumEntries(r112);
    }

    public static DocLoadingState[] values() {
        return (DocLoadingState[]) f221325a.clone();
    }

    public static DocLoadingState valueOf(String r100) {
        return (DocLoadingState) r27.a.a(DocLoadingState.class, r100);
    }

    public DocLoadingState(String r100, int r101) {
        super(r100, r101);
    }
}
