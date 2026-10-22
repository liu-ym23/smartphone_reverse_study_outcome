package faceverify;

import android.graphics.PointF;
import com.dtf.toyger.base.ToygerAttr;
import faceverify.s;
import java.util.Map;

/* JADX INFO: loaded from: classes41.dex */
public interface r<State extends s, Attr extends ToygerAttr> {
    PointF onAlignDepthPoint(PointF r100);

    boolean onEvent(int r100, Map<String, Object> r101);
}
