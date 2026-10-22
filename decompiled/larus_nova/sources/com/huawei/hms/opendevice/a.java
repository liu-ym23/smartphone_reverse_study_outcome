package com.huawei.hms.opendevice;

import android.content.Context;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.entity.AAIDResult;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes23.dex */
public class a implements Callable<AAIDResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f277526a;

    public AAIDResult a() throws Exception {
        Context r100 = this.f277526a;
        if (r100 == null) goto L7;
        String r101 = b.b(r100);
        AAIDResult r102 = new AAIDResult();
        r102.setId(r101);
        return r102;
    L7:
        throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ AAIDResult call() throws Exception {
        return a();
    }

    public a(Context r100) {
        this.f277526a = r100;
    }
}
