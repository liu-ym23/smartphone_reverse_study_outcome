package com.bytedance.retrofit2.intercept;

/* JADX INFO: loaded from: classes3.dex */
public interface IInterceptorProperty {

    /* JADX INFO: renamed from: com.bytedance.retrofit2.intercept.IInterceptorProperty$-CC, reason: invalid class name */
    /* JADX INFO: loaded from: classes21.dex */
    public final /* synthetic */ class CC {
        public static boolean $default$shouldRunInMergeMode(IInterceptorProperty r100) {
            return false;
        }

        public static boolean $default$shouldRunInPureMode(IInterceptorProperty r100) {
            return false;
        }
    }

    boolean shouldRunInMergeMode();

    boolean shouldRunInPureMode();
}
