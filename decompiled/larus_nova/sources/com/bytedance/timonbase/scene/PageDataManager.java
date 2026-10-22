package com.bytedance.timonbase.scene;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
public final class PageDataManager {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f270859b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f270860c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f270861d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedList<b> f270862a;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: loaded from: classes22.dex */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R.\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/bytedance/timonbase/scene/PageDataManager$b;", "", "", "pageType", "Ljava/lang/String;", "getPageType", "()Ljava/lang/String;", "c", "(Ljava/lang/String;)V", "pageName", "getPageName", "b", "", "timestamp", "J", "getTimestamp", "()J", "d", "(J)V", "", "extra", "Ljava/util/Map;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/Map;", "setExtra", "(Ljava/util/Map;)V", "timonbase_release"}, k = 1, mv = {1, 4, 0})
    public static final class b {

        @SerializedName("extra")
        private Map<String, Object> extra;

        @SerializedName("page_name")
        private String pageName;

        @SerializedName("page_type")
        private String pageType;

        @SerializedName("timestamp")
        private long timestamp;

        public b() {
            this(null);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == false) goto L14;
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.pageType, r101.pageType) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.pageName, r101.pageName) == true) goto L10;
            return false;
        L10:
            if (this.timestamp == r101.timestamp) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public final int hashCode() {
            String r100 = this.pageType;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.pageName;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            long r107 = this.timestamp;
            int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
            Map<String, Object> r109 = this.extra;
            if (r109 == null) goto L14;
            r101 = r109.hashCode();
        L14:
            return r108 + r101;
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "PageRecord(pageType=" + this.pageType + ", pageName=" + this.pageName + ", timestamp=" + this.timestamp + ", extra=" + this.extra + ")";
        }

        public final void c() {
            this.pageType = "activity";
        }

        public final Map<String, Object> a() {
            return this.extra;
        }

        public b(Object r100) {
            LinkedHashMap r101 = new LinkedHashMap();
            this.pageType = "";
            this.pageName = "";
            this.timestamp = 0;
            this.extra = r101;
        }

        public final void b(String r100) {
            this.pageName = r100;
        }

        public final void d(long r100) {
            this.timestamp = r100;
        }
    }

    public final synchronized List<b> a() {
        monitor-enter(this);
        ArrayList r100 = new ArrayList(this.f270862a);     // Catch: Throwable -> L14
        ArrayList r101 = new ArrayList();     // Catch: Throwable -> L14
        Iterator r102 = r100.iterator();     // Catch: Throwable -> L14
    L5:
        if (r102.hasNext() == false) goto L9;
        Object r103 = r102.next();     // Catch: Throwable -> L14
        if (Intrinsics.areEqual(((b) r103).a().get("status"), "onResumed") == false) goto L5;
        r101.add(r103);     // Catch: Throwable -> L14
        goto L5
    L9:
        boolean r104 = !r101.isEmpty();     // Catch: Throwable -> L14
        List<b> r105 = r101;
        if (r104 == false) goto L12;
        CollectionsKt.reversed(r101);     // Catch: Throwable -> L14
        r105 = r101.subList(0, RangesKt.coerceAtMost(r101.size(), 20));     // Catch: Throwable -> L14
    L12:
        monitor-exit(this);
        return r105;
    L14:
        th = move-exception;
        throw th;
    }

    static {
        f270861d = new a();
        f270859b = -1;
        f270860c = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, PageDataManager$Companion$instance$2.INSTANCE);
    }

    public PageDataManager() {
        this.f270862a = new LinkedList();
    }
}
