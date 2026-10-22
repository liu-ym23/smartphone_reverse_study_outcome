package iw3;

import com.bytedance.applet.model.bottomsheet.DoubaoBottomSheetDialogFragment;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes14.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile WeakReference<DoubaoBottomSheetDialogFragment> f496178a;

    static {
    }

    public static final void a(AtomicBoolean r100, Function1<? super com.bytedance.ai.api.f, Unit> r101, com.bytedance.ai.api.f r102) {
        if (r100.compareAndSet(false, true) == false) goto L6;
        r101.invoke(r102);
        return;
    }
}
