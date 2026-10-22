package com.suite.lark.platform.component.widgetrenderinterceptor.entity;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/suite/lark/platform/component/widgetrenderinterceptor/entity/BizInterceptorType;", "", "priority", "", "<init>", "(Ljava/lang/String;II)V", "getPriority", "()I", "UNIFIED_STORAGE_REGULARLY_DELETE", "FILE_PREVIEW_PERMISSION", "FILE_RECEIVE_PERMISSION", "CSAM_DELETE", "Companion", "widget-biz-renderinterceptor_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BizInterceptorType extends Enum<BizInterceptorType> {
    public static final BizInterceptorType CSAM_DELETE = null;
    public static final a Companion = null;
    public static final BizInterceptorType FILE_PREVIEW_PERMISSION = null;
    public static final BizInterceptorType FILE_RECEIVE_PERMISSION = null;
    public static final BizInterceptorType UNIFIED_STORAGE_REGULARLY_DELETE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BizInterceptorType[] f461202a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f461203b = null;
    private final int priority;

    public static EnumEntries<BizInterceptorType> getEntries() {
        return f461203b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.suite.lark.platform.component.widgetrenderinterceptor.entity.BizInterceptorType$a] */
    static {
        BizInterceptorType r100 = new BizInterceptorType("UNIFIED_STORAGE_REGULARLY_DELETE", 0, 1);
        UNIFIED_STORAGE_REGULARLY_DELETE = r100;
        BizInterceptorType r101 = new BizInterceptorType("FILE_PREVIEW_PERMISSION", 1, 2);
        FILE_PREVIEW_PERMISSION = r101;
        BizInterceptorType r102 = new BizInterceptorType("FILE_RECEIVE_PERMISSION", 2, 3);
        FILE_RECEIVE_PERMISSION = r102;
        BizInterceptorType r103 = new BizInterceptorType("CSAM_DELETE", 3, 4);
        CSAM_DELETE = r103;
        BizInterceptorType[] r104 = {r100, r101, r102, r103};
        f461202a = r104;
        f461203b = EnumEntriesKt.enumEntries(r104);
        Companion = new a();
    }

    public static BizInterceptorType[] values() {
        return (BizInterceptorType[]) f461202a.clone();
    }

    public final int getPriority() {
        return this.priority;
    }

    public static BizInterceptorType valueOf(String r100) {
        return (BizInterceptorType) r27.a.a(BizInterceptorType.class, r100);
    }

    public BizInterceptorType(String r100, int r101, int r102) {
        super(r100, r101);
        this.priority = r102;
    }
}
