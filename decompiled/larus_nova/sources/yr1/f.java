package yr1;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.core.widget.GradientEditText;
import com.bytedance.android.livesdk.chatroom.replay.input.ReplayEmojiInputDialogFragment;
import vr1.c0;

/* JADX INFO: loaded from: classes8.dex */
public interface f {
    GradientEditText a(Context r100, int r101);

    CharSequence c(CharSequence r100, float r101);

    boolean d(CharSequence r100);

    View f(Context r100, boolean r101, int r102, lm1.e r103, c0 r104);

    View g(FragmentActivity r100, boolean r101, int r102, ReplayEmojiInputDialogFragment.b r103);

    Drawable getRealDrawable(String r100);

    int h(String r100, boolean r101, int r102);
}
