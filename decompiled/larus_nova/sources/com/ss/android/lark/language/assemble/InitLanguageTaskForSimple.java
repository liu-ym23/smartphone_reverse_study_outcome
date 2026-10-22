package com.ss.android.lark.language.assemble;

import android.app.Application;
import android.content.Context;
import com.larksuite.framework.launch.task.AbstractLaunchTask;
import com.larksuite.framework.utils.Reflect;
import com.ss.android.lark.language.service.impl.a;
import java.util.Locale;
import yob.e;

/* JADX INFO: loaded from: classes36.dex */
public class InitLanguageTaskForSimple extends AbstractLaunchTask {
    public InitLanguageTaskForSimple() {
    }

    @Override // com.larksuite.framework.launch.task.AbstractLaunchTask, com.larksuite.framework.launch.task.ILaunchTask
    public final void a(Context r100) {
        if ((r100 instanceof Application) == false) goto L6;
        Application r101 = (Application) r100;
        e.a().getClass();
        int r102 = a.f431092f;
        Context r103 = a.b.f431098a.i(r101.getBaseContext(), new Locale("zh", "cn"));
        new Reflect(r101).i("mBase", r103);
        return;
    }
}
