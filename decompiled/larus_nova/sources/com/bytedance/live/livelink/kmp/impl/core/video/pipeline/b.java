package com.bytedance.live.livelink.kmp.impl.core.video.pipeline;

import com.bytedance.live.livelink.kmp.api.base.video.NodeType;
import com.bytedance.live.livelink.kmp.api.base.video.Status;

/* JADX INFO: loaded from: classes19.dex */
public final /* synthetic */ class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f255483a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f255484b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int[] f255485c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int[] f255486d = null;

    static {
        int[] r100 = new int[Status.values().length];
        f255483a = r100;
        Status r101 = Status.UNDEFINED;
        r100[r101.ordinal()] = 1;
        Status r102 = Status.READY;
        r100[r102.ordinal()] = 2;
        r100[Status.PAUSED.ordinal()] = 3;
        r100[Status.RESUMED.ordinal()] = 4;
        r100[Status.STARTED.ordinal()] = 5;
        Status r103 = Status.STOPPED;
        r100[r103.ordinal()] = 6;
        int[] r104 = new int[Status.values().length];
        f255484b = r104;
        r104[r101.ordinal()] = 1;
        r104[r102.ordinal()] = 2;
        r104[r103.ordinal()] = 3;
        int[] r105 = new int[NodeType.values().length];
        f255485c = r105;
        NodeType r106 = NodeType.PROVIDER;
        r105[r106.ordinal()] = 1;
        NodeType r107 = NodeType.CONSUMER;
        r105[r107.ordinal()] = 2;
        int[] r108 = new int[NodeType.values().length];
        f255486d = r108;
        r108[r106.ordinal()] = 1;
        r108[r107.ordinal()] = 2;
    }
}
