package com.ss.android.lark.biz.im.extension.thread.option;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/biz/im/extension/thread/option/ThreadOptionContext$Page;", "", "<init>", "(Ljava/lang/String;I)V", "THREAD_WINDOW", "THREAD_DETAIL", "chat-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ThreadOptionContext$Page extends Enum<ThreadOptionContext$Page> {
    public static final ThreadOptionContext$Page THREAD_DETAIL = null;
    public static final ThreadOptionContext$Page THREAD_WINDOW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ThreadOptionContext$Page[] f410578a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f410579b = null;

    public static EnumEntries<ThreadOptionContext$Page> getEntries() {
        return f410579b;
    }

    static {
        ThreadOptionContext$Page r100 = new ThreadOptionContext$Page("THREAD_WINDOW", 0);
        THREAD_WINDOW = r100;
        ThreadOptionContext$Page r101 = new ThreadOptionContext$Page("THREAD_DETAIL", 1);
        THREAD_DETAIL = r101;
        ThreadOptionContext$Page[] r102 = {r100, r101};
        f410578a = r102;
        f410579b = EnumEntriesKt.enumEntries(r102);
    }

    public static ThreadOptionContext$Page[] values() {
        return (ThreadOptionContext$Page[]) f410578a.clone();
    }

    public static ThreadOptionContext$Page valueOf(String r100) {
        return (ThreadOptionContext$Page) a.a(ThreadOptionContext$Page.class, r100);
    }

    public ThreadOptionContext$Page(String r100, int r101) {
        super(r100, r101);
    }
}
