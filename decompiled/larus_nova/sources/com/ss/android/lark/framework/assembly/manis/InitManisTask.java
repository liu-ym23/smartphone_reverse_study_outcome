package com.ss.android.lark.framework.assembly.manis;

import android.content.Context;
import com.larksuite.framework.launch.task.AbstractLaunchTask;
import com.larksuite.framework.launch.task.ILaunchTask;
import java.util.ArrayList;
import java.util.List;
import jrc.b;

/* JADX INFO: loaded from: classes36.dex */
public class InitManisTask extends AbstractLaunchTask {

    public class a implements jrc.a {
        public a() {
        }
    }

    @Override // com.larksuite.framework.launch.task.AbstractLaunchTask
    public final List<Class<? extends ILaunchTask>> i() {
        return new ArrayList();
    }

    public InitManisTask() {
    }

    @Override // com.larksuite.framework.launch.task.AbstractLaunchTask, com.larksuite.framework.launch.task.ILaunchTask
    public final void a(Context r100) {
        b r101 = b.a.f500175a;
        r101.f500174c = new a();
        krc.b.f505900a = new com.ss.android.lark.framework.assembly.manis.a();
    }
}
