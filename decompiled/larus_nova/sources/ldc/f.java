package ldc;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import java.util.Map;

/* JADX INFO: loaded from: classes38.dex */
public interface f<DATA, CONTEXT> {
    void a(DATA r100);

    View b(ViewGroup r100);

    void c(Map<Integer, com.ss.android.lark.widget.photopickerimpl.bean.b> r100);

    void d(CONTEXT r100);

    boolean onActivityResult(int r100, int r101, Intent r102);

    void onResume();

    void onStop();
}
