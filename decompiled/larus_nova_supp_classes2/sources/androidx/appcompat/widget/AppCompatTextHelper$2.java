package androidx.appcompat.widget;

import android.graphics.Typeface;
import android.widget.TextView;
import com.larus.apm.impl.protector.RunnableProtector;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class AppCompatTextHelper$2 implements Runnable {
    final /* synthetic */ AppCompatTextHelper this$0;
    final /* synthetic */ int val$style;
    final /* synthetic */ TextView val$textView;
    final /* synthetic */ Typeface val$typeface;

    @Override // java.lang.Runnable
    public void run() {
        androidx_appcompat_widget_AppCompatTextHelper$2_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public void androidx_appcompat_widget_AppCompatTextHelper$2__run$___twin___() {
        this.val$textView.setTypeface(this.val$typeface, this.val$style);
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void androidx_appcompat_widget_AppCompatTextHelper$2_com_larus_apm_impl_protector_RunnableLancet_run(AppCompatTextHelper$2 r1) {
        r1.androidx_appcompat_widget_AppCompatTextHelper$2__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public AppCompatTextHelper$2(AppCompatTextHelper r1, TextView r2, Typeface r3, int r4) {
        this.this$0 = r1;
        this.val$textView = r2;
        this.val$typeface = r3;
        this.val$style = r4;
    }
}
