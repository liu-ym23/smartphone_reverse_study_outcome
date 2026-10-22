package usc;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Spanned;
import android.util.Size;
import android.view.View;
import android.widget.TextView;
import java.util.Map;

/* JADX INFO: loaded from: classes41.dex */
public interface f {
    void a();

    View asView();

    Integer b(Size r100, TextView r101, Canvas r102, Paint r103);

    Size c(TextView r100, e r101, Map<String, ? extends Object> r102);

    Size d(TextView r100, Spanned r101, e r102, int r103, Map<String, ? extends Object> r104);

    void e();

    void f();
}
