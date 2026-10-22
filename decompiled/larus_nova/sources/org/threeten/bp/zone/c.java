package org.threeten.bp.zone;

import java.util.Arrays;
import java.util.Iterator;
import java.util.ServiceConfigurationError;

/* JADX INFO: loaded from: classes41.dex */
public final /* synthetic */ class c {
    public static /* synthetic */ Iterator a() {
        return Arrays.asList(new d[]{new a()}).iterator();
    L5:
        th = move-exception;
        throw new ServiceConfigurationError(th.getMessage(), th);
    }
}
