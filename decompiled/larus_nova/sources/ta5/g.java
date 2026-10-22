package ta5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.ColorUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.insets.WindowInsetsUtils;

/* JADX INFO: loaded from: classes16.dex */
public final class g extends sa5.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AppCompatActivity f545177a;

    public g(AppCompatActivity r100) {
        this.f545177a = r100;
        k(R.color.bg_body);
        int r101 = UIUtils.getColor(r100, R.color.bg_body);
        WindowInsetsUtils.c(r100).i(r101);
    }

    public final void k(int r100) {
        int r101 = UIUtils.getColor(this.f545177a, r100);
        if (ColorUtils.calculateContrast(-1, r101) > 3.0d) goto L5;
        com.ss.android.lark.insets.h r102 = WindowInsetsUtils.c(this.f545177a);
        r102.b(r101);
        r102.v(true);
        return;
    L5:
        com.ss.android.lark.insets.h r103 = WindowInsetsUtils.c(this.f545177a);
        r103.b(r101);
        r103.v(false);
    }
}
