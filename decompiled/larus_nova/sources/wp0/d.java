package wp0;

import android.view.View;
import android.widget.EditText;
import com.bytedance.android.live.openplatform.impl.miniappanchor.sellingpoint.ShelfManagementSellingPointSettingDialog;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes46.dex */
public final class d implements View.OnFocusChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ShelfManagementSellingPointSettingDialog f560548a;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f560549a;

        public a(d r100) {
            this.f560549a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ((EditText) this.f560549a.f560548a.S90(R.id.edit_text)).setSelection(((EditText) this.f560549a.f560548a.S90(R.id.edit_text)).getText().toString().length());     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public d(ShelfManagementSellingPointSettingDialog r100) {
        this.f560548a = r100;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View r100, boolean r101) {
        if (r101 == false) goto L5;
        r100.post(new a(this));
        return;
    }
}
