package com.ss.android.lark.framework.assembly.navigation;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.larksuite.framework.launch.task.AbstractLaunchTask;
import com.ss.android.lark.utils.navigation.Navigation;
import com.ss.android.lark.utils.statistics.PerfLog;
import hjb.a;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public class InitNavigationTask extends AbstractLaunchTask {
    public InitNavigationTask() {
    }

    @Override // com.larksuite.framework.launch.task.AbstractLaunchTask, com.larksuite.framework.launch.task.ILaunchTask
    public final void a(Context r100) {
        HashSet<String> r101 = a.f485493a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        boolean r102 = false;
        if ((r100.getResources().getConfiguration().screenLayout & 15) < 3) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L13;
        String r104 = Build.BRAND;
        Iterator<String> r105 = a.f485493a.iterator();
    L9:
        if (r105.hasNext() == false) goto L13;
        String r106 = r105.next().toLowerCase();
        Intrinsics.checkNotNull(r104);
        if (TextUtils.equals(r106, r104.toLowerCase()) == false) goto L9;
        r102 = true;
    L13:
        Navigation.setIsNavigationEnable(!r102);
        return;
    L5:
        r103 = false;
        goto L6
    }
}
