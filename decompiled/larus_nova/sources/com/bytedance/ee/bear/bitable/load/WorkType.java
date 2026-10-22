package com.bytedance.ee.bear.bitable.load;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/bear/bitable/load/WorkType;", "", "<init>", "(Ljava/lang/String;I)V", "SETUP_WEBVIEW", "SETUP_RUST", "WIKI_INFO_CHECK", "CHECK_CURRENT_URL", "SETUP_TIMEOUT", "ENSURE_LOGIN", "RENDER_DOCUMENT", "NATIVE_CACHE_RENDER", "PRELOAD_DATA", "UNSUPPORT_WORK", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum WorkType extends Enum<WorkType> {
    public static final WorkType CHECK_CURRENT_URL = null;
    public static final WorkType ENSURE_LOGIN = null;
    public static final WorkType NATIVE_CACHE_RENDER = null;
    public static final WorkType PRELOAD_DATA = null;
    public static final WorkType RENDER_DOCUMENT = null;
    public static final WorkType SETUP_RUST = null;
    public static final WorkType SETUP_TIMEOUT = null;
    public static final WorkType SETUP_WEBVIEW = null;
    public static final WorkType UNSUPPORT_WORK = null;
    public static final WorkType WIKI_INFO_CHECK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WorkType[] f214463a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f214464b = null;

    public static EnumEntries<WorkType> getEntries() {
        return f214464b;
    }

    static {
        WorkType r100 = new WorkType("SETUP_WEBVIEW", 0);
        SETUP_WEBVIEW = r100;
        WorkType r101 = new WorkType("SETUP_RUST", 1);
        SETUP_RUST = r101;
        WorkType r102 = new WorkType("WIKI_INFO_CHECK", 2);
        WIKI_INFO_CHECK = r102;
        WorkType r103 = new WorkType("CHECK_CURRENT_URL", 3);
        CHECK_CURRENT_URL = r103;
        WorkType r104 = new WorkType("SETUP_TIMEOUT", 4);
        SETUP_TIMEOUT = r104;
        WorkType r105 = new WorkType("ENSURE_LOGIN", 5);
        ENSURE_LOGIN = r105;
        WorkType r110 = new WorkType("RENDER_DOCUMENT", 6);
        RENDER_DOCUMENT = r110;
        WorkType r111 = new WorkType("NATIVE_CACHE_RENDER", 7);
        NATIVE_CACHE_RENDER = r111;
        WorkType r112 = new WorkType("PRELOAD_DATA", 8);
        PRELOAD_DATA = r112;
        WorkType r113 = new WorkType("UNSUPPORT_WORK", 9);
        UNSUPPORT_WORK = r113;
        WorkType[] r114 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
        f214463a = r114;
        f214464b = EnumEntriesKt.enumEntries(r114);
    }

    public static WorkType[] values() {
        return (WorkType[]) f214463a.clone();
    }

    public static WorkType valueOf(String r100) {
        return (WorkType) r27.a.a(WorkType.class, r100);
    }

    public WorkType(String r100, int r101) {
        super(r100, r101);
    }
}
