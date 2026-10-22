package com.bytedance.gamecenter.base.order.preres;

import com.ss.android.lark.chat.core.dependency.ForwardDependency$ForwardLocation;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/gamecenter/base/order/preres/GResDownloadFlag;", "", "", ForwardDependency$ForwardLocation.FLAG, "I", "getFlag", "()I", "NOT_START", "START_DOWNLOAD", "DOWNLOAD_OFFLINE", "gamecenterbase_release"}, k = 1, mv = {1, 4, 3})
public final enum GResDownloadFlag extends Enum<GResDownloadFlag> {
    public static final GResDownloadFlag DOWNLOAD_OFFLINE = null;
    public static final GResDownloadFlag NOT_START = null;
    public static final GResDownloadFlag START_DOWNLOAD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GResDownloadFlag[] f245042a = null;
    private final int flag;

    static {
        GResDownloadFlag r100 = new GResDownloadFlag("NOT_START", 0, 0);
        NOT_START = r100;
        GResDownloadFlag r101 = new GResDownloadFlag("START_DOWNLOAD", 1, 1);
        START_DOWNLOAD = r101;
        GResDownloadFlag r102 = new GResDownloadFlag("DOWNLOAD_OFFLINE", 2, 2);
        DOWNLOAD_OFFLINE = r102;
        f245042a = new GResDownloadFlag[]{r100, r101, r102};
    }

    public static GResDownloadFlag valueOf(String r100) {
        return (GResDownloadFlag) a.a(GResDownloadFlag.class, r100);
    }

    public static GResDownloadFlag[] values() {
        return (GResDownloadFlag[]) f245042a.clone();
    }

    public final int getFlag() {
        return this.flag;
    }

    public GResDownloadFlag(String r100, int r101, int r102) {
        super(r100, r101);
        this.flag = r102;
    }
}
