package kotlinx.coroutines;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;

/* JADX INFO: loaded from: classes.dex */
@Deprecated(level = DeprecationLevel.ERROR, message = "This is internal API and may be removed in the future releases")
public interface o extends m0 {
    boolean b(Throwable r100);

    Job getParent();
}
