package com.bytedance.ies.bullet.kit.lynx.api;

import com.ss.android.downloadad.api.model.NativeDownloadModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0016\u0010\u0006\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ies/bullet/kit/lynx/api/ThreadStrategyForRendering;", "", "", "id", "", "ThreadStrategyForRendering", NativeDownloadModel.JsonKey.ID, "I", "ALL_ON_UI", "MOST_ON_TASM", "PART_ON_LAYOUT", "MULTI_THREADS", "anniex_release"}, k = 1, mv = {1, 4, 3})
public enum ThreadStrategyForRendering extends Enum<ThreadStrategyForRendering> {
    public static final ThreadStrategyForRendering ALL_ON_UI = null;
    public static final ThreadStrategyForRendering MOST_ON_TASM = null;
    public static final ThreadStrategyForRendering MULTI_THREADS = null;
    public static final ThreadStrategyForRendering PART_ON_LAYOUT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ThreadStrategyForRendering[] f246781a = null;
    private int mId;

    public ThreadStrategyForRendering() {
        throw null;
    }

    public static ThreadStrategyForRendering valueOf(String r100) {
        return (ThreadStrategyForRendering) a.a(ThreadStrategyForRendering.class, r100);
    }

    public static ThreadStrategyForRendering[] values() {
        return (ThreadStrategyForRendering[]) f246781a.clone();
    }

    static {
        final String r100 = "ALL_ON_UI";
        final int r101 = 0;
        ThreadStrategyForRendering r102 = new ALL_ON_UI(r100, r101);
        ALL_ON_UI = r102;
        final String r103 = "MOST_ON_TASM";
        final int r104 = 1;
        ThreadStrategyForRendering r105 = new MOST_ON_TASM(r103, r104);
        MOST_ON_TASM = r105;
        final String r106 = "PART_ON_LAYOUT";
        final int r107 = 2;
        ThreadStrategyForRendering r108 = new PART_ON_LAYOUT(r106, r107);
        PART_ON_LAYOUT = r108;
        final String r109 = "MULTI_THREADS";
        final int r110 = 3;
        ThreadStrategyForRendering r111 = new MULTI_THREADS(r109, r110);
        MULTI_THREADS = r111;
        f246781a = new ThreadStrategyForRendering[]{r102, r105, r108, r111};
    }

    public int id() {
        return this.mId;
    }

    public void ThreadStrategyForRendering(int r100) {
        this.mId = r100;
    }

    public ThreadStrategyForRendering(String r100, int r101, DefaultConstructorMarker r102) {
        super(r100, r101);
    }
}
