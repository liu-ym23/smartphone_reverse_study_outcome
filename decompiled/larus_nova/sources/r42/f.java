package r42;

import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ vlc.m f536039a;

    public f(com.bytedance.android.livesdk.interactivity.publicscreen.repository.first.g r100) {
        this.f536039a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        MainThreadPostUtils.e(new e(this, (Throwable) r100));
    }
}
