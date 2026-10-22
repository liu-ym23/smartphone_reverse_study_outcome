package com.larksuite.component.card.utils;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.openplatform.v1.GetUuidRequest;
import com.bytedance.lark.pb.openplatform.v1.GetUuidResponse;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.sdk.SdkSender;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes24.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GetUuidRequest.Builder f283960a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1<String, Unit> f283961b;

    public static final class a<T> implements SdkSender.IParser {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a<T> f283962a = null;

        static {
            f283962a = new a();
        }

        public a() {
        }

        @Override // com.ss.android.lark.sdk.SdkSender.IParser
        public final Object parse(byte[] r100) {
            return "c-" + GetUuidResponse.ADAPTER.decode(r100).uuid;
        }
    }

    /* JADX INFO: renamed from: com.larksuite.component.card.utils.b$b, reason: collision with other inner class name */
    public static final class RunnableC3907b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f283963a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1<String, Unit> f283964b;

        /* JADX WARN: Multi-variable type inference failed */
        public RunnableC3907b(String r100, Function1<? super String, Unit> r101) {
            this.f283963a = r100;
            this.f283964b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            String r100 = this.f283963a;     // Catch: Throwable -> L4
            this.f283964b.invoke(r100);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(GetUuidRequest.Builder r100, Function1<? super String, Unit> r101) {
        this.f283960a = r100;
        this.f283961b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object r100 = SdkSender.syncSend(Command.GET_UUID, this.f283960a, a.f283962a);     // Catch: Throwable -> L4
        String r101 = (String) r100;     // Catch: Throwable -> L4
        UICallbackExecutor.execute(new RunnableC3907b(r101, this.f283961b));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
