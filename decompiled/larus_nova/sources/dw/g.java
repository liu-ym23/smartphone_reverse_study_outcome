package dw;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.gamecp.business.gamedetail.m;
import java.util.HashMap;

/* JADX INFO: loaded from: classes44.dex */
public interface g {
    void a(DialogFragment r100, FrameLayout r101, boolean r102, boolean r103, HashMap r104);

    void b(Context r100, HashMap r101);

    void c(m r100);

    void d(m r100);

    boolean isFloatViewShowing();

    void stopFloatView();
}
