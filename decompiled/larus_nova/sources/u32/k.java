package u32;

import android.graphics.PointF;
import android.view.MotionEvent;
import io.reactivex.Observable;

/* JADX INFO: loaded from: classes9.dex */
public interface k {

    public static final class a {
        public static /* synthetic */ boolean a(k r100, MotionEvent r110, long r111, PointF r112, boolean r113, boolean r114, boolean r115, int r116) {
            if ((r116 & 4) == 0) goto L5;
            PointF r101 = null;
        L7:
            if ((r116 & 8) == 0) goto L9;
            boolean r102 = false;
        L11:
            if ((r116 & 16) == 0) goto L13;
            boolean r103 = false;
        L15:
            if ((r116 & 32) == 0) goto L17;
            boolean r104 = false;
        L19:
            return r100.Km(r110, r111, r101, r102, r103, r104);
        L17:
            r104 = r115;
            goto L19
        L13:
            r103 = r114;
            goto L15
        L9:
            r102 = r113;
            goto L11
        L5:
            r101 = r112;
            goto L7
        }
    }

    void A9(int r100);

    boolean D8(MotionEvent r100);

    boolean Eg();

    boolean Km(MotionEvent r100, long r101, PointF r102, boolean r103, boolean r104, boolean r105);

    Observable<Long> Lo();

    long getDiggCount();

    boolean needPerformHapticFeedback();

    void xo();
}
