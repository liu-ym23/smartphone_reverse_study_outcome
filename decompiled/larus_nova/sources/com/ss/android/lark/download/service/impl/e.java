package com.ss.android.lark.download.service.impl;

import com.bytedance.lark.pb.media.v1.FileState;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes35.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, wbb.d.a<wbb.d.b>> f420541a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<wbb.e> f420542b;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f420543a = null;

        static {
            int[] r100 = new int[FileState.values().length];
            f420543a = r100;
            r100[FileState.DOWNLOAD_WAIT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            f420543a[FileState.DOWNLOADING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            f420543a[FileState.DOWNLOAD_FAIL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            f420543a[FileState.DOWNLOAD_SUCCESS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            f420543a[FileState.DOWNLOAD_CANCEL.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            f420543a[FileState.CANCEL_BY_RISK.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f420544a = null;

        static {
            f420544a = new e();
        }
    }

    public e() {
        this.f420541a = new HashMap();
        this.f420542b = new CopyOnWriteArrayList();
    }
}
