package zqb;

import android.app.Activity;
import android.content.Context;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f573358a = 0;

    /* JADX INFO: renamed from: zqb.a$a, reason: collision with other inner class name */
    public static final class RunnableC8486a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f573359a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f573360b;

        public RunnableC8486a(Context r100, String r101) {
            this.f573359a = r100;
            this.f573360b = r101;
        }

        public final void a() {
            Context r100 = this.f573359a;
            if ((r100 instanceof Activity) == true) goto L6;
            String r101 = this.f573360b;
            Intrinsics.checkNotNull(r101);
            UDToast.show(r100, r101);
            return;
        L6:
            UDDialogBuilder r102 = new UDDialogBuilder(this.f573359a);
            String r103 = this.f573360b;
            Intrinsics.checkNotNull(r103);
            r102.message(r103).addActionButton(R.id.ud_dialog_btn_primary, R.string.Lark_Legacy_IKnow, null).show();
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
    }

    static {
    }

    public static void a(Context r100, ErrorResult r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "error");
        UICallbackExecutor.execute(new RunnableC8486a(r100, r101.getDisplayMsg(UIUtils.getString(r100, R.string.Lark_Group_GroupMemberReachLimit))));
    }
}
