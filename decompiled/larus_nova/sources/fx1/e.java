package fx1;

import com.bytedance.android.livesdk.feedback.condition.trigger.base.TriggerId;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes8.dex */
public interface e<T> {
    void a();

    void b(Function2<? super TriggerId, ? super T, Unit> r100);

    TriggerId getId();

    void reset();
}
