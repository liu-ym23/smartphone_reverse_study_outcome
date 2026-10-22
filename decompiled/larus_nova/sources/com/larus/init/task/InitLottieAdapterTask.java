package com.larus.init.task;

import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.utils.logger.FLogger;
import com.lynx.lottieadapter.AnimationType;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"Lcom/larus/init/task/InitLottieAdapterTask;", "Lcom/bytedance/lego/init/model/BaseFeedShowTask;", "<init>", "()V", "run", "", "Companion", "app_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InitLottieAdapterTask extends bf6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f351053a = 0;

    public static final class a {
    }

    static {
    }

    public static void a() {
        AnimationType r100 = AnimationType.LOTTIE;
        b6a.c r101 = new b0();
        Map<AnimationType, b6a.c> r102 = b6a.i.f17887b;
        ((ConcurrentHashMap) r102).put(r100, r101);
        AnimationType r103 = AnimationType.ANIMAX;
        ConcurrentHashMap r104 = (ConcurrentHashMap) r102;
        r104.put(r103, new c0());
        b6a.i.f17886a.f17892a = r103;
        FLogger.f375446a.i("InitLottieAdapterTask", "register lottie adapters and use animaX");
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public InitLottieAdapterTask() {
    }
}
