package com.bytedance.sync.v2.process;

import com.bytedance.sync.model.DataType;

/* JADX INFO: loaded from: classes22.dex */
public final /* synthetic */ class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f270515a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f270516b = null;

    static {
        int[] r100 = new int[DataType.values().length];
        f270515a = r100;
        DataType r101 = DataType.ORIGIN;
        r100[r101.ordinal()] = 1;
        DataType r102 = DataType.FILE_PATH;
        r100[r102.ordinal()] = 2;
        int[] r103 = new int[DataType.values().length];
        f270516b = r103;
        r103[r102.ordinal()] = 1;
        r103[r101.ordinal()] = 2;
    }
}
