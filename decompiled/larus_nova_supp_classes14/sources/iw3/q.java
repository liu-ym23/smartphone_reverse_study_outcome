package iw3;

import com.bytedance.applet.model.bottomsheet.DoubaoBottomSheetDialogFragment;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class q {
    public static volatile WeakReference<DoubaoBottomSheetDialogFragment> a;

    static {
    }

    public static final void a(AtomicBoolean r2, Function1<? super com.bytedance.ai.api.f, Unit> r3, com.bytedance.ai.api.f r4) {
        if (r2.compareAndSet(false, true) == false) goto L6;
        r3.invoke(r4);
        return;
    }
}
