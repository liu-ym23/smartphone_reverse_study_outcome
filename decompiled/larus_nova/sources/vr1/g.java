package vr1;

import android.content.Context;
import android.text.SpannableString;
import android.view.View;
import com.bytedance.android.live.core.widget.GradientEditText;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes8.dex */
public interface g {
    GradientEditText a(Context r100, int r101);

    SpannableString c(CharSequence r100, float r101);

    View d(boolean r100, boolean r101, Function2 r102, Function0 r103, Function0 r104);

    com.bytedance.android.livesdk.chatroom.vs_host.impl.f f(boolean r100, boolean r101, Function2 r102, Function0 r103, Function0 r104, Function0 r105);

    List<Object> parseEmojiIndexList(CharSequence r100);
}
