package com.bytedance.ee.bear.task;

import android.content.Context;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.larksuite.framework.utils.DevEnvUtil;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.log.Log;
import du5.b;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/task/SensitiveLogCheckTask;", "Lcom/bytedance/ee/bear/task/BaseTask;", "<init>", "()V", "firstSensitiveLog", "", "execute", "", "context", "Landroid/content/Context;", "basesdk_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SensitiveLogCheckTask extends BaseTask {
    public boolean c;

    public static final class a implements tt5.a.a {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ SensitiveLogCheckTask b;
        public final /* synthetic */ Context c;

        public final void a(String r4) {
            if (this.a == true) goto L5;
            return;
        L5:
            if (b.a(r4) == false) goto L12;
            SensitiveLogCheckTask r0 = this.b;
            if (r0.c == false) goto L10;
            r0.c = false;
            Toast.showSuccessText(this.c, "token is sensitive **** ");
        L10:
            throw new RuntimeException("token is sensitive **** " + r4);
        }

        public a(boolean r1, SensitiveLogCheckTask r2, Context r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final boolean b(String r5, String r6, Throwable r7) {
            if (b.a(r6) == false) goto L5;
            r6 = b.k(r6);
            boolean r0 = true;
        L6:
            StackTraceElement[] r2 = null;
            if (r7 == null) goto L9;
            String r3 = r7.getMessage();
        L11:
            if (b.a(r3) == false) goto L19;
            if (r7 == null) goto L14;
            String r1 = r7.getMessage();
        L15:
            Throwable r4 = new Throwable(b.k(r1));
            if (r7 == null) goto L18;
            r2 = r7.getStackTrace();
        L18:
            r4.setStackTrace(r2);
            r7 = r4;
            r0 = true;
            goto L19
        L14:
            r1 = null;
        L19:
            if (r0 == false) goto L21;
            Log.e("token is sensitive **** " + r5, r6, r7, true);
        L21:
            return r0;
        L9:
            r3 = null;
            goto L11
        L5:
            r0 = false;
            goto L6
        }
    }

    public SensitiveLogCheckTask() {
        this.c = true;
    }

    @Override // com.bytedance.ee.bear.task.BaseTask
    public final void a(Context r5) {
        LarkAppContext.Companion.getClass();
        if (LarkAppContext.access$getInstance$cp().buildConfig().isOfficeSDK() == false) goto L5;
        return;
    L5:
        Intrinsics.checkNotNullParameter("debug_config", "name");
        com.ss.android.lark.storage.kv.repo.a r0 = ay4.b.b("debug_config", true, ay4.b.a("debug_config"));
        Intrinsics.checkNotNullParameter(r0, "repo");
        new ArrayList();
        Intrinsics.checkNotNullParameter("sensitive_log_enable", "key");
        if (r0.getBoolean("sensitive_log_enable", true) == true) goto L8;
        return;
    L8:
        tt5.a.a = new a(DevEnvUtil.isDebugMode(r5), this, r5);
    }
}
