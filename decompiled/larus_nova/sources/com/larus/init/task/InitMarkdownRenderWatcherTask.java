package com.larus.init.task;

import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.bmhome.chat.interceptor.IMessageRenderInterceptor;
import com.larus.network.http.FirstInitStyle;
import com.larus.network.http.ServiceType;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/larus/init/task/InitMarkdownRenderWatcherTask;", "Lcom/bytedance/lego/init/model/IInitTask;", "Lcom/larus/init/task/base/IFlowInitReportTask;", "<init>", "()V", "scene", "", "getScene", "()Ljava/lang/String;", "firstStyle", "getFirstStyle", "markdownRenderCrashConfig", "Lcom/larus/settings/opt/launch/MarkdownRenderCrashConfig;", "getMarkdownRenderCrashConfig", "()Lcom/larus/settings/opt/launch/MarkdownRenderCrashConfig;", "markdownRenderCrashConfig$delegate", "Lkotlin/Lazy;", "runInternal", "", "app_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InitMarkdownRenderWatcherTask extends bf6.d implements bg9.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f351055a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f351056b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f351057c;

    @Override // bg9.i
    public final void runInternal() {
        if (Intrinsics.areEqual(((pt9.g) this.f351057c.getValue()).b(), Boolean.TRUE) == false) goto L13;
        IMessageRenderInterceptor r100 = IMessageRenderInterceptor.f303337a;
        Integer r101 = ((pt9.g) this.f351057c.getValue()).a();
        if (r101 == null) goto L7;
        int r102 = r101.intValue();
    L8:
        HashMap<String, String> r103 = ((pt9.g) this.f351057c.getValue()).c();
        if (r103 != null) goto L11;
        r103 = new HashMap();
    L11:
        r100.c(r102, r103);
        return;
    L7:
        r102 = 1;
        goto L8
    }

    public InitMarkdownRenderWatcherTask() {
        this.f351055a = ServiceType.BASIC_TEC;
        this.f351056b = FirstInitStyle.AsyncThreadWhenFirst;
        this.f351057c = LazyKt.lazy(new d0());
    }

    @Override // java.lang.Runnable, bg9.i
    public final void run() {
        bg9.i.a.a(this);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    @Override // bg9.i
    public final String getScene() {
        return this.f351055a;
    }

    @Override // bg9.i
    public final String v() {
        return this.f351056b;
    }
}
