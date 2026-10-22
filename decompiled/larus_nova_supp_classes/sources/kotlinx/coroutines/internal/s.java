package kotlinx.coroutines.internal;

import java.util.Arrays;
import java.util.Iterator;
import java.util.ServiceConfigurationError;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final /* synthetic */ class s {
    public static /* synthetic */ Iterator a() {
        return Arrays.asList(new r[]{new kotlinx.coroutines.android.a()}).iterator();
    L5:
        th = move-exception;
        throw new ServiceConfigurationError(th.getMessage(), th);
    }
}
