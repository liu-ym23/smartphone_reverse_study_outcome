package qs8;

import android.view.View;
import com.larus.common_ui.video.progress.PlayerProgressView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes26.dex */
public interface a {
    void I4(boolean r100);

    void J1(float r100, boolean r101);

    View asView();

    void d5(Function0<Unit> r100);

    void h3();

    void setProgressViewVisibility(boolean r100);

    void z1(Function1<? super PlayerProgressView, Unit> r100);
}
