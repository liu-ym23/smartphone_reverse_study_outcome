package com.ss.android.lark.todo.impl.adapterhelper.loadmodule;

import com.alibaba.gaiax.model.GXAnimation;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/todo/impl/adapterhelper/loadmodule/PageLoadingStatus;", "", "<init>", "(Ljava/lang/String;I)V", "LOADING_FIRST", "LOADING_NEXT", "LOADING_FIRST_SUCCESS", "LOADING_NEXT_SUCCESS", "LOADING_FIRST_FAIL", "LOADING_NEXT_FAIL", GXAnimation.STATE_END, "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PageLoadingStatus extends Enum<PageLoadingStatus> {
    public static final PageLoadingStatus END = null;
    public static final PageLoadingStatus LOADING_FIRST = null;
    public static final PageLoadingStatus LOADING_FIRST_FAIL = null;
    public static final PageLoadingStatus LOADING_FIRST_SUCCESS = null;
    public static final PageLoadingStatus LOADING_NEXT = null;
    public static final PageLoadingStatus LOADING_NEXT_FAIL = null;
    public static final PageLoadingStatus LOADING_NEXT_SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PageLoadingStatus[] f441369a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f441370b = null;

    public static EnumEntries<PageLoadingStatus> getEntries() {
        return f441370b;
    }

    static {
        PageLoadingStatus r100 = new PageLoadingStatus("LOADING_FIRST", 0);
        LOADING_FIRST = r100;
        PageLoadingStatus r101 = new PageLoadingStatus("LOADING_NEXT", 1);
        LOADING_NEXT = r101;
        PageLoadingStatus r102 = new PageLoadingStatus("LOADING_FIRST_SUCCESS", 2);
        LOADING_FIRST_SUCCESS = r102;
        PageLoadingStatus r103 = new PageLoadingStatus("LOADING_NEXT_SUCCESS", 3);
        LOADING_NEXT_SUCCESS = r103;
        PageLoadingStatus r104 = new PageLoadingStatus("LOADING_FIRST_FAIL", 4);
        LOADING_FIRST_FAIL = r104;
        PageLoadingStatus r105 = new PageLoadingStatus("LOADING_NEXT_FAIL", 5);
        LOADING_NEXT_FAIL = r105;
        PageLoadingStatus r110 = new PageLoadingStatus(GXAnimation.STATE_END, 6);
        END = r110;
        PageLoadingStatus[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        f441369a = r111;
        f441370b = EnumEntriesKt.enumEntries(r111);
    }

    public static PageLoadingStatus[] values() {
        return (PageLoadingStatus[]) f441369a.clone();
    }

    public static PageLoadingStatus valueOf(String r100) {
        return (PageLoadingStatus) a.a(PageLoadingStatus.class, r100);
    }

    public PageLoadingStatus(String r100, int r101) {
        super(r100, r101);
    }
}
