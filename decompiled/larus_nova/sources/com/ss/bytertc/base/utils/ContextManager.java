package com.ss.bytertc.base.utils;

import android.content.Context;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes40.dex */
public class ContextManager {
    private WeakReference<Context> mContextWeakReference;

    public static class SingletonHelper {
        private static final ContextManager INSTANCE = null;

        private SingletonHelper() {
        }

        static {
            INSTANCE = new ContextManager();
        }

        public static /* synthetic */ ContextManager access$000() {
            return INSTANCE;
        }
    }

    public ContextManager() {
    }

    public Context getContext() {
        WeakReference<Context> r100 = this.mContextWeakReference;
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r100.get() != null) goto L7;
        return null;
    L7:
        return this.mContextWeakReference.get();
    }

    public static ContextManager instance() {
        return SingletonHelper.access$000();
    }

    public void setContext(Context r100) {
        if (this.mContextWeakReference == null) goto L5;
        this.mContextWeakReference = null;
    L5:
        this.mContextWeakReference = new WeakReference(r100);
    }
}
