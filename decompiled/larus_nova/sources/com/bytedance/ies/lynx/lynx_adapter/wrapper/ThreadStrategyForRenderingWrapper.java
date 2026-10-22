package com.bytedance.ies.lynx.lynx_adapter.wrapper;

import com.ss.android.downloadad.api.model.NativeDownloadModel;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ies/lynx/lynx_adapter/wrapper/ThreadStrategyForRenderingWrapper;", "", "", "id", NativeDownloadModel.JsonKey.ID, "I", "ALL_ON_UI", "MOST_ON_TASM", "PART_ON_LAYOUT", "MULTI_THREADS", "lynx-adapter_release"}, k = 1, mv = {1, 4, 0})
public final enum ThreadStrategyForRenderingWrapper extends Enum<ThreadStrategyForRenderingWrapper> {
    public static final ThreadStrategyForRenderingWrapper ALL_ON_UI = null;
    public static final ThreadStrategyForRenderingWrapper MOST_ON_TASM = null;
    public static final ThreadStrategyForRenderingWrapper MULTI_THREADS = null;
    public static final ThreadStrategyForRenderingWrapper PART_ON_LAYOUT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ThreadStrategyForRenderingWrapper[] f248613a = null;
    private final int mId;

    static {
        ThreadStrategyForRenderingWrapper r100 = new ThreadStrategyForRenderingWrapper("ALL_ON_UI", 0, 0);
        ALL_ON_UI = r100;
        ThreadStrategyForRenderingWrapper r101 = new ThreadStrategyForRenderingWrapper("MOST_ON_TASM", 1, 1);
        MOST_ON_TASM = r101;
        ThreadStrategyForRenderingWrapper r102 = new ThreadStrategyForRenderingWrapper("PART_ON_LAYOUT", 2, 2);
        PART_ON_LAYOUT = r102;
        ThreadStrategyForRenderingWrapper r103 = new ThreadStrategyForRenderingWrapper("MULTI_THREADS", 3, 3);
        MULTI_THREADS = r103;
        f248613a = new ThreadStrategyForRenderingWrapper[]{r100, r101, r102, r103};
    }

    public static ThreadStrategyForRenderingWrapper valueOf(String r100) {
        return (ThreadStrategyForRenderingWrapper) a.a(ThreadStrategyForRenderingWrapper.class, r100);
    }

    public static ThreadStrategyForRenderingWrapper[] values() {
        return (ThreadStrategyForRenderingWrapper[]) f248613a.clone();
    }

    public final int id() {
        return this.mId;
    }

    public ThreadStrategyForRenderingWrapper(String r100, int r101, int r102) {
        super(r100, r101);
        this.mId = r102;
    }
}
