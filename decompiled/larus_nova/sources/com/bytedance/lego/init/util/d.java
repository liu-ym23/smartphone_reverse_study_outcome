package com.bytedance.lego.init.util;

import com.bytedance.lego.init.config.ProcessMatchMode;

/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f254572a = null;

    static {
        int[] r100 = new int[ProcessMatchMode.values().length];
        f254572a = r100;
        r100[ProcessMatchMode.ENDWITH.ordinal()] = 1;
        r100[ProcessMatchMode.CONTAIN.ordinal()] = 2;
    }
}
