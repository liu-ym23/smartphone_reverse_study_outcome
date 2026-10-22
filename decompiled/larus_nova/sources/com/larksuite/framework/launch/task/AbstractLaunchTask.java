package com.larksuite.framework.launch.task;

import android.content.Context;
import com.ss.android.lark.framework.assembly.logger.InitMoltenLogTask;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes24.dex */
public abstract class AbstractLaunchTask<T> implements ILaunchTask<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<Class<? extends ILaunchTask>> f285668a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Period f285669b;

    @Override // com.larksuite.framework.launch.task.ILaunchTask
    public void a(Context r100) {
    }

    @Override // com.larksuite.framework.launch.task.ILaunchTask
    public int c() {
        return 0;
    }

    @Override // com.larksuite.framework.launch.task.ILaunchTask
    public boolean g() {
        return this instanceof InitMoltenLogTask;
    }

    public List<Class<? extends ILaunchTask>> i() {
        return null;
    }

    @Override // com.larksuite.framework.launch.task.ILaunchTask
    public final List<Class<? extends ILaunchTask>> e() {
        if (this.f285668a != null) goto L6;
        this.f285668a = i();
    L6:
        return this.f285668a;
    }

    public AbstractLaunchTask() {
        this.f285669b = Period.APP_ONATTACHBASECONTEXT_BEGIN;
        Period r100 = Period.APP_ONCREATE_END;
        TaskAttribute$BoostStage r101 = TaskAttribute$BoostStage.UNKNOWN;
    }

    @Override // com.larksuite.framework.launch.task.ILaunchTask
    public String f() {
        return getClass().getSimpleName();
    }

    @Override // com.larksuite.framework.launch.task.ILaunchTask
    public final Period d() {
        return this.f285669b;
    }

    public final AbstractLaunchTask h(Class r100) {
        if (this.f285668a != null) goto L7;
        List<Class<? extends ILaunchTask>> r101 = i();
        this.f285668a = r101;
        if (r101 != null) goto L7;
        this.f285668a = new ArrayList();
    L7:
        this.f285668a.add(r100);
        return this;
    }
}
