package com.huawei.agconnect.core.a;

import com.huawei.agconnect.AGCInitFinishManager;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class a extends AGCInitFinishManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final List<AGCInitFinishManager.AGCInitFinishCallback> f276752a = null;

    static {
        f276752a = new CopyOnWriteArrayList();
    }

    public a() {
    }

    public static void a() {
        Iterator<AGCInitFinishManager.AGCInitFinishCallback> r100 = f276752a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().onFinish();
        goto L4
    }

    @Override // com.huawei.agconnect.AGCInitFinishManager
    public void addAGCInitFinishCallback(AGCInitFinishManager.AGCInitFinishCallback r100) {
        if (r100 == null) goto L5;
        f276752a.add(r100);
        return;
    }
}
