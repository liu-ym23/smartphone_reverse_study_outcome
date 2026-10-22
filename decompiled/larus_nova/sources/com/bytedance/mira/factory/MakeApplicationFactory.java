package com.bytedance.mira.factory;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.bytedance.mira.Mira;
import com.bytedance.mira.helper.ActivityThreadHelper;
import com.bytedance.mira.helper.ContextImplHelper;
import com.bytedance.mira.util.FieldUtils;
import java.util.List;

/* JADX INFO: loaded from: classes21.dex */
public class MakeApplicationFactory {
    public MakeApplicationFactory() {
    }

    public static void makeApplication(Object r100, ApplicationInfo r101) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        if (r101 == null) goto L5;
        String r102 = r101.className;
        if (r102 == null) goto L5;
    L6:
        Context r103 = ContextImplHelper.createAppContext(r100);
        Application r104 = ActivityThreadHelper.getInstrumentation().newApplication(Mira.getAppContext().getClassLoader(), r102, r103);
        ContextImplHelper.setOuterContext(r103, r104);
        List<Application> r105 = ActivityThreadHelper.getApplications();
        r105.add(r104);
        ActivityThreadHelper.setApplications(r105);
        FieldUtils.writeField(r100, "mApplication", r104);
        return;
    L5:
        r102 = "android.app.Application";
        goto L6
    }
}
