package com.bytedance.awemeopen.apps.framework.comment.write.utils;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes14.dex */
public final class KeyboardUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<ClearCursorDecorator> f194574a = null;

    public static class ClearCursorDecorator implements LifecycleObserver {
        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        public void onDestroy() {
            Iterator r100 = ((ArrayList) KeyboardUtils.f194574a).iterator();
        L4:
            if (r100.hasNext() == false) goto L8;
            if (((ClearCursorDecorator) r100.next()) != this) goto L4;
            ((ArrayList) KeyboardUtils.f194574a).remove(this);
            goto L4
        }
    }

    static {
        f194574a = new ArrayList(2);
        new ArrayList(2);
        x54.a.a(73);
    }
}
