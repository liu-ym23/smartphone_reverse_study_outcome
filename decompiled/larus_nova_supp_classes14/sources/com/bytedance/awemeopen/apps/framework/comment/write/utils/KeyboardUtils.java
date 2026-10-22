package com.bytedance.awemeopen.apps.framework.comment.write.utils;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class KeyboardUtils {
    public static final List<ClearCursorDecorator> a = null;

    public static class ClearCursorDecorator implements LifecycleObserver {
        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        public void onDestroy() {
            Iterator r0 = ((ArrayList) KeyboardUtils.a).iterator();
        L4:
            if (r0.hasNext() == false) goto L8;
            if (((ClearCursorDecorator) r0.next()) != this) goto L4;
            ((ArrayList) KeyboardUtils.a).remove(this);
            goto L4
        }
    }

    static {
        a = new ArrayList(2);
        new ArrayList(2);
        x54.a.a(73);
    }
}
