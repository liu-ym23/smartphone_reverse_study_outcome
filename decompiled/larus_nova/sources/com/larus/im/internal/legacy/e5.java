package com.larus.im.internal.legacy;

import com.larus.im.bean.thread.GetThreadSource;

/* JADX INFO: loaded from: classes29.dex */
public final class e5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f348757a = 0;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f348758a = null;

        static {
            int[] r100 = new int[GetThreadSource.values().length];
            r100[GetThreadSource.GetThreadSource_MIXED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[GetThreadSource.GetThreadSource_LOCAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[GetThreadSource.GetThreadSource_REMOTE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f348758a = r100;
        }
    }

    static {
    }
}
