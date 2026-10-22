package org.chromium.support_lib_boundary;

import android.os.Handler;
import java.lang.reflect.InvocationHandler;

/* JADX INFO: loaded from: classes42.dex */
public interface WebMessagePortBoundaryInterface {
    void close();

    void postMessage(InvocationHandler r100);

    void setWebMessageCallback(InvocationHandler r100);

    void setWebMessageCallback(InvocationHandler r100, Handler r101);
}
