package ta5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.ColorUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.insets.WindowInsetsUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class g extends sa5.e {
    public final AppCompatActivity a;

    public g(AppCompatActivity r2) {
        this.a = r2;
        k(2131100548);
        int r0 = UIUtils.getColor(r2, 2131100548);
        WindowInsetsUtils.c(r2).i(r0);
    }

    public final void k(int r6) {
        int r7 = UIUtils.getColor(this.a, r6);
        if (ColorUtils.calculateContrast(-1, r7) > 3.0d) goto L5;
        com.ss.android.lark.insets.h r0 = WindowInsetsUtils.c(this.a);
        r0.b(r7);
        r0.v(true);
        return;
    L5:
        com.ss.android.lark.insets.h r1 = WindowInsetsUtils.c(this.a);
        r1.b(r7);
        r1.v(false);
    }
}
