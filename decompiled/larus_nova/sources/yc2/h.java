package yc2;

import android.text.TextUtils;
import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.android.live.core.utils.f2;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class h<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f567131a = null;

    static {
        f567131a = new h();
    }

    public h() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        if ((r101 instanceof CustomApiServerException) == false) goto L8;
        CustomApiServerException r102 = (CustomApiServerException) r101;
        if (TextUtils.isEmpty(r102.getPrompt()) == true) goto L9;
        f2.c(r102.getPrompt(), 0);
        return;
    L9:
        return;
    }
}
