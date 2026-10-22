package u19;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.lynx.lottieadapter.LottieAdapterView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes27.dex */
public interface f {
    void dismiss();

    void icon(int r100);

    boolean isShown();

    void lottie(Function1<? super LottieAdapterView, Unit> r100);

    void setAutoDisappear(boolean r100);

    void setDuration(int r100);

    void setYOffsetPx(Integer r100);

    void show(Context r100, boolean r101);

    void show(Fragment r100, boolean r101);

    void text(CharSequence r100);

    void updateText(CharSequence r100);
}
