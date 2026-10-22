package ly7;

import android.graphics.Point;
import android.view.View;
import com.larksuite.common_selection.SelectionContainer;
import com.larksuite.common_selection.d;
import com.larksuite.common_selection.o;
import com.larksuite.common_selection.t;

/* JADX INFO: loaded from: classes24.dex */
public interface c extends d {
    void e(o r100, t r101);

    float getOffsetForMagnifier();

    View getView();

    Point h(float r100, float r101);

    void k(SelectionContainer r100, Point r101, float r102);
}
