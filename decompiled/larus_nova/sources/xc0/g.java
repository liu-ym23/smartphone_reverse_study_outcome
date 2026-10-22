package xc0;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes46.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function2 f563204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f563205b;

    public g(Function2 r100, String r101) {
        this.f563204a = r100;
        this.f563205b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        this.f563204a.invoke(Boolean.FALSE, null);
        ALogger.i("InteractAnimation.ResourceReader", "readAndParseInteractEmoji#error:" + this.f563205b + ", " + ((Throwable) r100));
    }
}
