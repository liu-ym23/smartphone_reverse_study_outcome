package com.bytedance.crash;

/* JADX INFO: loaded from: classes6.dex */
public interface ICrashFilter {
    boolean onJavaCrashFilter(Throwable r100, Thread r101);

    boolean onNativeCrashFilter(String r100, String r101);
}
