package com.bytedance.forest.pollyfill.ttnet;

import com.bytedance.forest.utils.OfflineUtil;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ForestNetAPI {

    public static abstract class HttpResponse {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final List<Integer> f244419e = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f244420a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f244421b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Map<String, String> f244422c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f244423d;

        /* JADX INFO: loaded from: classes19.dex */
        public static final class Companion {

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/forest/pollyfill/ttnet/ForestNetAPI$HttpResponse$Companion$ForestNetException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "forest_release"}, k = 1, mv = {1, 1, 16})
            public static final class ForestNetException extends Exception {
                private final String message;

                @Override // java.lang.Throwable
                public String getMessage() {
                    return this.message;
                }

                public ForestNetException(String r100) {
                    this.message = r100;
                }
            }
        }

        public abstract InputStream b();

        static {
            f244419e = CollectionsKt.listOf(new Integer[]{408, 503, 504});
        }

        public final boolean a() {
            int r100 = this.f244420a;
            if (300 <= r100) goto L6;
        L10:
            return false;
        L6:
            if (399 < r100) goto L10;
            if (r100 == 304) goto L10;
            return true;
        }

        public final boolean c() {
            OfflineUtil.f244497d.getClass();
            int r100 = this.f244420a;
            if (200 <= r100) goto L6;
        L8:
            boolean r101 = false;
        L9:
            if (r101 == false) goto L11;
        L13:
            Map<String, String> r102 = this.f244422c;
            if (r100 != 206) goto L16;
        L29:
            return false;
        L16:
            if (Intrinsics.areEqual(r102.get("vary"), "*") == true) goto L29;
            String r103 = r102.get("cache-control");
            if (r103 == null) goto L27;
            Iterator<String> r104 = OfflineUtil.f244494a.iterator();
        L22:
            if (r104.hasNext() == false) goto L27;
            if (StringsKt.contains$default(r103, r104.next(), false, 2, null) == false) goto L22;
        L27:
            if (OfflineUtil.d(this) == null) goto L29;
            return true;
        L11:
            if (r100 == 304) goto L13;
        L6:
            if (299 < r100) goto L8;
            r101 = true;
            goto L9
        }

        public /* synthetic */ HttpResponse(int r100, String r101, Map r102, int r110) {
            if ((r110 & 2) == 0) goto L5;
            r101 = "";
        L5:
            String r103 = r101;
            if ((r110 & 8) == 0) goto L8;
            long r104 = System.currentTimeMillis();
        L9:
            this(r100, r103, r102, r104);
            return;
        L8:
            r104 = 0;
            goto L9
        }

        public HttpResponse(int r100, String r101, Map<String, String> r102, long r103) {
            this.f244420a = r100;
            this.f244421b = r101;
            this.f244422c = r102;
            this.f244423d = r103;
        }
    }

    /* JADX INFO: loaded from: classes19.dex */
    public static abstract class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile String f244424a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ConcurrentHashMap<String, String> f244425b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f244426c;

        public abstract void a();

        public final String toString() {
            String r100 = this.f244424a;
            if (r100 == null) goto L5;
            return r100;
        L5:
            StringBuilder r101 = new StringBuilder(this.f244426c);
            Map r102 = MapsKt.toSortedMap(this.f244425b);
            if (r102 != null) goto L9;
            r102 = MapsKt.emptyMap();
        L9:
            Iterator r103 = r102.entrySet().iterator();
        L11:
            if (r103.hasNext() == false) goto L13;
            Map.Entry r104 = (Map.Entry) r103.next();
            r101.append((String) r104.getKey());
            r101.append((String) r104.getValue());
            goto L11
        L13:
            String r105 = r101.toString();
            this.f244424a = r105;
            return r105;
        }

        public a(String r100, Map<String, String> r101) {
            this.f244426c = r100;
            this.f244425b = new ConcurrentHashMap(r101);
        }
    }

    public ForestNetAPI() {
    }
}
