package r4c;

import androidx.lifecycle.ProcessLifecycleOwner;
import com.larksuite.framework.utils.z;
import com.ss.android.lark.security.compliance.infra.SecurityComplianceInfraModule$doListenAppLifecycle$1;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.android.lark.utils.LarkContext;
import w4c.c;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f536116a;

    static {
    }

    public static void a() {
        if (z.e(LarkContext.getApplication()) == true) goto L5;
        return;
    L5:
        if (f536116a == false) goto L8;
        ScsLogger.d("SecurityComplianceInfraModule", "init: SecurityComplianceInfraModule has been initialized,end ");
        return;
    L8:
        f536116a = true;
        if (c.a().d() == false) goto L13;
        ProcessLifecycleOwner.Companion.get().getLifecycle().addObserver(new SecurityComplianceInfraModule$doListenAppLifecycle$1());
        return;
    }
}
