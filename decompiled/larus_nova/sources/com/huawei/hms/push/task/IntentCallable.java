package com.huawei.hms.push.task;

import android.content.Context;
import android.content.Intent;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.push.utils.PushBiUtil;
import com.huawei.hms.support.api.entity.push.PushNaming;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes23.dex */
public class IntentCallable implements Callable<Void> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f277665a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Intent f277666b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f277667c;

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public Void call2() throws Exception {
        this.f277665a.sendBroadcast(this.f277666b);
        PushBiUtil.reportExit(this.f277665a, PushNaming.SET_NOTIFY_FLAG, this.f277667c, ErrorEnum.SUCCESS);
        return null;
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Void call() throws Exception {
        return call2();
    }

    public IntentCallable(Context r100, Intent r101, String r102) {
        this.f277665a = r100;
        this.f277666b = r101;
        this.f277667c = r102;
    }
}
