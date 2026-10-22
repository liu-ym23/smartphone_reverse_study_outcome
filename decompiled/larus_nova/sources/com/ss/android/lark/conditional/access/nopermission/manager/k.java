package com.ss.android.lark.conditional.access.nopermission.manager;

import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.component.appcontext.LarkAppContext;

/* JADX INFO: loaded from: classes35.dex */
public final class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f418182a = null;

    static {
        f418182a = new k();
    }

    public k() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        LarkAppContext.Companion.getClass();     // Catch: Throwable -> L4
        x08.a.a(LarkAppContext.access$getInstance$cp().getContext(), R.string.Lark_Shared_FilePolicyMgmtDevice_FileSecurityAssessmentInProgress_Desc).show();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
