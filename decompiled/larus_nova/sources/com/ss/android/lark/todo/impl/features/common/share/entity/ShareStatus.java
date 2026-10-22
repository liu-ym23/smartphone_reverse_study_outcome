package com.ss.android.lark.todo.impl.features.common.share.entity;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/common/share/entity/ShareStatus;", "", "number", "", "<init>", "(Ljava/lang/String;II)V", "getNumber", "()I", "NO_LOADING", "SHARE_LOADING", "SHARE_SUCCESS", "SHARE_FAILURE", "Companion", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ShareStatus extends Enum<ShareStatus> {
    public static final a Companion = null;
    public static final ShareStatus NO_LOADING = null;
    public static final ShareStatus SHARE_FAILURE = null;
    public static final ShareStatus SHARE_LOADING = null;
    public static final ShareStatus SHARE_SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ShareStatus[] f442478a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f442479b = null;
    private final int number;

    public static EnumEntries<ShareStatus> getEntries() {
        return f442479b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.ss.android.lark.todo.impl.features.common.share.entity.ShareStatus$a] */
    static {
        ShareStatus r100 = new ShareStatus("NO_LOADING", 0, 0);
        NO_LOADING = r100;
        ShareStatus r101 = new ShareStatus("SHARE_LOADING", 1, 1);
        SHARE_LOADING = r101;
        ShareStatus r102 = new ShareStatus("SHARE_SUCCESS", 2, 2);
        SHARE_SUCCESS = r102;
        ShareStatus r103 = new ShareStatus("SHARE_FAILURE", 3, 3);
        SHARE_FAILURE = r103;
        ShareStatus[] r104 = {r100, r101, r102, r103};
        f442478a = r104;
        f442479b = EnumEntriesKt.enumEntries(r104);
        Companion = new a();
    }

    public static ShareStatus[] values() {
        return (ShareStatus[]) f442478a.clone();
    }

    public final int getNumber() {
        return this.number;
    }

    public static ShareStatus valueOf(String r100) {
        return (ShareStatus) r27.a.a(ShareStatus.class, r100);
    }

    public ShareStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.number = r102;
    }
}
