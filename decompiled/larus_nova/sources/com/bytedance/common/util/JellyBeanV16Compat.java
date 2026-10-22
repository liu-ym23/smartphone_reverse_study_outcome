package com.bytedance.common.util;

import android.app.ActivityManager;
import android.graphics.drawable.Drawable;
import android.view.View;

/* JADX INFO: loaded from: classes15.dex */
public class JellyBeanV16Compat {
    private static BaseImpl mImpl;

    /* JADX INFO: renamed from: com.bytedance.common.util.JellyBeanV16Compat$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class BaseImpl {
        private BaseImpl() {
        }

        public long getTotalMem(ActivityManager.MemoryInfo r100) {
            throw null;
        }

        public void setViewBackground(View r100, Drawable r101) {
            throw null;
        }

        public /* synthetic */ BaseImpl(AnonymousClass1 r100) {
            this();
        }
    }

    public static class V16Impl extends BaseImpl {
        private V16Impl() {
            super(null);
        }

        public /* synthetic */ V16Impl(AnonymousClass1 r100) {
            this();
        }

        @Override // com.bytedance.common.util.JellyBeanV16Compat.BaseImpl
        public long getTotalMem(ActivityManager.MemoryInfo r100) {
            return r100.totalMem;
        }

        @Override // com.bytedance.common.util.JellyBeanV16Compat.BaseImpl
        public void setViewBackground(View r100, Drawable r101) {
            r100.setBackground(r101);     // Catch: Throwable -> L4
            return;
        L4:
            r100.setBackgroundDrawable(r101);
        }
    }

    static {
        mImpl = new V16Impl(null);
    }

    public static long getTotalMem(ActivityManager.MemoryInfo r100) {
        return mImpl.getTotalMem(r100);
    }

    public static void setViewBackground(View r100, Drawable r101) {
        mImpl.setViewBackground(r100, r101);
    }
}
