package r00;

import com.bytedance.android.live.broadcast.corepath.TaskLevel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public abstract class a {
    public a() {
        this(TaskLevel.Normal);
    }

    public final String toString() {
        return getClass().getSimpleName();
    }

    public a(TaskLevel r100) {
        Intrinsics.checkNotNullParameter(r100, "level");
    }
}
