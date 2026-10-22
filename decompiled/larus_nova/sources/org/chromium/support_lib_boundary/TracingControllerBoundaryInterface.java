package org.chromium.support_lib_boundary;

import java.io.OutputStream;
import java.util.Collection;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes42.dex */
public interface TracingControllerBoundaryInterface {
    boolean isTracing();

    void start(int r100, Collection<String> r101, int r102) throws IllegalStateException, IllegalArgumentException;

    boolean stop(OutputStream r100, Executor r101);
}
