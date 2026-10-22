package d32;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.interactivity.api.commentcontrol.utils.CommentControlSwitchHelper;
import com.bytedance.android.livesdk.sharedpref.e;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f466703a = null;

    static {
        f466703a = new b();
    }

    public b() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        Intrinsics.checkNotNullParameter(r101, "e");
        e<Long> r102 = CommentControlSwitchHelper.f133089a;
        ALogger.w("CommentControlSwitchHelper", "fetchCommentControlMessage error " + r101.getMessage());
    }
}
