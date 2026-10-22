package com.larus.init.task.feed;

import com.larus.bmhome.chat.input.SendImageCacheScope;
import com.larus.disk.api.CacheHandlerBiz;
import com.larus.disk.api.CacheHandlerBusiness;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f351260a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LinkedHashMap<String, a> f351261b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Set<String> f351262c = null;

    public static final class a implements com.larus.disk.api.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ye8.e f351263a;

        /* JADX INFO: renamed from: com.larus.init.task.feed.q$a$a, reason: collision with other inner class name */
        /* JADX INFO: loaded from: classes30.dex */
        public /* synthetic */ class C4381a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f351264a = null;

            static {
                int[] r100 = new int[SendImageCacheScope.values().length];
                r100[SendImageCacheScope.INTERNAL_CACHE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r100[SendImageCacheScope.EXTERNAL_FILES.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                f351264a = r100;
            }
        }

        @Override // com.larus.disk.api.c
        public final String business() {
            return CacheHandlerBusiness.FILE_CACHE;
        }

        @Override // com.larus.disk.api.d
        public final boolean e(boolean r100) {
            return false;
        }

        @Override // com.larus.disk.api.d
        public final boolean f() {
            return true;
        }

        @Override // com.larus.disk.api.d
        public final boolean g() {
            return false;
        }

        @Override // com.larus.disk.api.c
        public final boolean i() {
            return true;
        }

        @Override // com.larus.disk.api.c
        public final String a() {
            return this.f351263a.getPath();
        }

        @Override // com.larus.disk.api.c
        public final String bizTag() {
            SendImageCacheScope r100 = this.f351263a.getScope();
            int r101 = C4381a.f351264a[r100.ordinal()];
            if (r101 != 1) goto L5;
            return CacheHandlerBiz.BIZ_SEND_IMAGE_LOCAL;
        L5:
            if (r101 != 2) goto L8;
            return CacheHandlerBiz.BIZ_SEND_IMAGE_EXTERNAL_LOCAL;
        L8:
            throw new NoWhenBranchMatchedException();
        }

        @Override // com.larus.disk.api.d
        public final long d() {
            return this.f351263a.b();
        }

        @Override // com.larus.disk.api.c
        public final long getCacheSize() {
            return this.f351263a.a();
        }

        public a(ye8.e r100) {
            Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
            this.f351263a = r100;
        }

        @Override // com.larus.disk.api.c
        public final long b(boolean r100) {
            return getCacheSize();
        }

        @Override // com.larus.disk.api.d
        public final boolean c(boolean r100, boolean r101) {
            return com.larus.disk.api.d.a.a(this, r100, r101);
        }

        @Override // com.larus.disk.api.c
        public final void h(boolean r100, boolean r101) {
            if (r101 == false) goto L5;
            this.f351263a.clean();
            return;
        }
    }

    static {
        f351260a = new Object();
        f351261b = new LinkedHashMap();
        f351262c = new LinkedHashSet();
    }
}
