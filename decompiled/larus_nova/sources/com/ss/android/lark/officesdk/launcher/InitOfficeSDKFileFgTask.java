package com.ss.android.lark.officesdk.launcher;

import android.content.Context;
import com.larksuite.framework.launch.task.AsyncLaunchTask;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000b2\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/officesdk/launcher/InitOfficeSDKFileFgTask;", "Lcom/larksuite/framework/launch/task/AsyncLaunchTask;", "", "<init>", "()V", "execute", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "delayDuration", "", "Companion", "officesdk-assemble_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InitOfficeSDKFileFgTask extends AsyncLaunchTask<Object> {

    public static final class a {
    }

    static {
    }

    @Override // com.larksuite.framework.launch.task.AbstractLaunchTask, com.larksuite.framework.launch.task.ILaunchTask
    public final int c() {
        return 2;
    }

    public InitOfficeSDKFileFgTask() {
    }

    @Override // com.larksuite.framework.launch.task.AbstractLaunchTask, com.larksuite.framework.launch.task.ILaunchTask
    public final void a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r101 = ((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).d();
        if (r101.length() != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        return;
    L8:
        com.ss.android.lark.featuregating.b.C4959b r103 = new com.ss.android.lark.featuregating.b.C4959b(r101, (jdb.e) e0c.k.a(com.larksuite.framework.utils.b.f285948a, jdb.e.class));
        com.ss.android.lark.featuregating.b r104 = com.ss.android.lark.featuregating.b.f420726d.b(r100);
        Intrinsics.checkNotNullParameter("init.language_task.sync", "fgKey");
        Intrinsics.checkNotNullParameter(r103, "fgSource");
        r104.f420729b.put("init.language_task.sync", r103);
        Iterator<Map.Entry<String, com.ss.android.lark.featuregating.b.c>> r105 = r104.f420729b.entrySet().iterator();
    L10:
        if (r105.hasNext() == false) goto L12;
        Map.Entry<String, com.ss.android.lark.featuregating.b.c> r106 = r105.next();
        String r107 = r106.getKey();
        boolean r108 = r106.getValue().isEnable(r107);
        com.ss.android.lark.storage.kv.flash.c r109 = r104.f420728a;
        r109.getClass();
        Intrinsics.checkNotNullParameter(r107, "key");
        r109.f441038a.putBoolean(r107, r108);
        Log.i("FlashFG", "update flash fg: key=" + r107 + ", value=" + r108);
        goto L10
    L12:
        return;
    L5:
        r102 = false;
        goto L6
    }
}
