package com.bytedance.lego.init.util;

import com.bytedance.android.service.manager.pull.PullConfiguration;
import com.bytedance.lego.init.InitScheduler;
import com.bytedance.lego.init.config.ProcessMatchMode;
import java.util.Iterator;
import java.util.List;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class e {
    public static final boolean a(bf6.f r100) {
        if (r100.f18829f.contains("all") == false) goto L5;
        return true;
    L5:
        List<String> r101 = r100.f18829f;
        InitScheduler r102 = InitScheduler.INSTANCE;
        if (r101.contains(r102.getConfig$initscheduler_release().getProcessName()) == false) goto L9;
        return true;
    L9:
        if (r102.getConfig$initscheduler_release().isMainProcess() == false) goto L13;
        return r100.f18829f.contains(PullConfiguration.PROCESS_NAME_MAIN);
    L13:
        if (r100.f18829f.contains("nonmain") == false) goto L15;
        return true;
    L15:
        ProcessMatchMode r103 = r102.getProcessMatchMode$initscheduler_release();
        int r104 = d.f254572a[r103.ordinal()];
        if (r104 != 1) goto L18;
        Iterator<T> r105 = r100.f18829f.iterator();
    L28:
        if (r105.hasNext() == false) goto L41;
        String r106 = (String) r105.next();
        if (StringsKt.endsWith(InitScheduler.INSTANCE.getConfig$initscheduler_release().getProcessName(), r106, true) == false) goto L28;
        return true;
    L41:
        return false;
    L18:
        if (r104 != 2) goto L32;
        Iterator<T> r107 = r100.f18829f.iterator();
    L22:
        if (r107.hasNext() == false) goto L40;
        String r108 = (String) r107.next();
        if (StringsKt.contains(InitScheduler.INSTANCE.getConfig$initscheduler_release().getProcessName(), r108, true) == false) goto L22;
        return true;
    L40:
        return false;
    L32:
        return false;
    }
}
