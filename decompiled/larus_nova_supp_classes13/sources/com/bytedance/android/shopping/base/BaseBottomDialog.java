package com.bytedance.android.shopping.base;

import android.view.View;
import android.view.Window;
import androidx.appcompat.app.AppCompatDialog;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/base/BaseBottomDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BaseBottomDialog extends AppCompatDialog {

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ BaseBottomDialog a;

        public b(BaseBottomDialog r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Window r0 = this.a.getWindow();     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.setWindowAnimations(2131952021);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    static {
    }

    public abstract View getRootView();

    /* JADX WARN: Multi-variable type inference failed */
    public final void show() {
    L12:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return;
    L3:
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L18;
        DialogLancet.handleBlockedDialogShow(this);     // Catch: Exception -> L12
    L8:
        View r0 = getRootView();     // Catch: Exception -> L12
        if (r0 == null) goto L20;
        r0.postDelayed(new b(this), 300);     // Catch: Exception -> L12
        return;
    L20:
        return;
    L18:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L15
    L7:
        DialogLancet.beforeDialogShow(this);     // Catch: Exception -> L12
        super/*android.app.Dialog*/.show();     // Catch: Exception -> L12
        DialogLancet.afterDialogShow(this);     // Catch: Exception -> L12
        goto L8
    }
}
