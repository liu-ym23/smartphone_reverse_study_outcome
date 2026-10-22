package zw7;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.push.PushSupporter;
import com.bytedance.push.utils.f;
import com.honor.HonorPushAdapter;
import com.larus.apm.impl.protector.RunnableProtector;
import ww7.a0;
import ww7.c0;
import ww7.h;
import ww7.t;

/* JADX INFO: loaded from: classes23.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f573845a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f573846b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f573847c;

    /* JADX INFO: renamed from: zw7.a$a, reason: collision with other inner class name */
    public class C8500a implements ww7.a<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f573848a;

        public C8500a(a r100) {
            this.f573848a = r100;
        }

        @Override // ww7.a
        public final void onSuccess(String r100) {
            String r101 = r100;
            if (TextUtils.isEmpty(r101) == false) goto L5;
            f.e("HonorPush", "get honor token is null");
            a r102 = this.f573848a;
            r102.getClass();
            PushSupporter.monitor().monitorRegisterSenderFailed(r102.f573846b, 102, "-1", "token is empty");
            return;
        L5:
            a r103 = this.f573848a;
            r103.getClass();
            PushSupporter.thirdService().registerSenderSuccessAndUploadToken(r103.f573845a, r103.f573846b, r101);
        }

        @Override // ww7.a
        public final void onFailure(int r100, String r101) {
            f.e("HonorPush", "get honor error,errorCode:" + r100 + " errorString:" + r101);
            a r102 = this.f573848a;
            StringBuilder r103 = new StringBuilder("");
            r103.append(r100);
            String r104 = r103.toString();
            r102.getClass();
            PushSupporter.monitor().monitorRegisterSenderFailed(r102.f573846b, 102, r104, r101);
        }
    }

    public final void a() {
    L6:
        th = move-exception;
        f.e("HonorPush", "get honor token err: " + th.getLocalizedMessage() + " stack:" + Log.getStackTraceString(th));
        PushSupporter.monitor().monitorRegisterSenderFailed(this.f573846b, 102, "-1", th.getLocalizedMessage());
        return;
    L3:
        if (TextUtils.isEmpty(this.f573847c) == false) goto L11;
        int r100 = ww7.b.f561640a;     // Catch: Throwable -> L6
        C8500a r101 = new C8500a(this);     // Catch: Throwable -> L6
        h.a(new a0(c0.f561643e, new t(r101, false), r101));     // Catch: Throwable -> L6
        return;
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

    public a(Context r100) {
        this.f573845a = r100;
        this.f573846b = HonorPushAdapter.getHonorPush();
    }

    public a(Context r100, String r101) {
        this.f573845a = r100;
        this.f573846b = HonorPushAdapter.getHonorPush();
        this.f573847c = r101;
    }
}
