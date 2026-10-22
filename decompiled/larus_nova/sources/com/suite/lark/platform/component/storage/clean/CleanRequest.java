package com.suite.lark.platform.component.storage.clean;

import android.content.Context;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.suite.lark.platform.component.storage.clean.f;
import dagger.hilt.EntryPoints;
import dagger.hilt.android.internal.Contexts;
import dagger.hilt.dwarf.spi.DwarfSPIEntryPoint;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes36.dex */
public class CleanRequest<Res extends f> {
    public static final b Companion = null;
    public static final String TAG = "CleanRequest";
    private final List<Res> cleanResources;
    private final int retryCount;
    private final String uniqueName;
    private final List<Res> whiteListResources;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/suite/lark/platform/component/storage/clean/CleanRequest$Status;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "RUNNING", "PENDING", "SUCCEED", "FAILED", "CANCELED", "lark-storage_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Status extends Enum<Status> {
        public static final Status CANCELED = null;
        public static final Status FAILED = null;
        public static final Status IDLE = null;
        public static final Status PENDING = null;
        public static final Status RUNNING = null;
        public static final Status SUCCEED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Status[] f460590a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f460591b = null;

        public static EnumEntries<Status> getEntries() {
            return f460591b;
        }

        static {
            Status r100 = new Status("IDLE", 0);
            IDLE = r100;
            Status r101 = new Status("RUNNING", 1);
            RUNNING = r101;
            Status r102 = new Status("PENDING", 2);
            PENDING = r102;
            Status r103 = new Status("SUCCEED", 3);
            SUCCEED = r103;
            Status r104 = new Status("FAILED", 4);
            FAILED = r104;
            Status r105 = new Status("CANCELED", 5);
            CANCELED = r105;
            Status[] r110 = {r100, r101, r102, r103, r104, r105};
            f460590a = r110;
            f460591b = EnumEntriesKt.enumEntries(r110);
        }

        public static Status[] values() {
            return (Status[]) f460590a.clone();
        }

        public static Status valueOf(String r100) {
            return (Status) r27.a.a(Status.class, r100);
        }

        public Status(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static abstract class a<Res extends f, Req extends CleanRequest<Res>, BD extends a<Res, Req, BD>> {
        public final Context getContext() {
            return null;
        }
    }

    public static final class b {
        public b() {
        }
    }

    public static final class c<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c<T> f460592a = null;

        static {
            f460592a = new c();
        }

        public c() {
        }

        @Override // java.util.Comparator
        public final int compare(Object r100, Object r101) {
            return ((String) r100).length() - ((String) r101).length();
        }
    }

    static {
        Companion = new b();
    }

    public final void cancel() {
        h r100 = o.f460618a;
        String r101 = this.uniqueName;
        Intrinsics.checkNotNullParameter(r101, "requestName");
        HashMap<String, Object> r102 = CleanStore.f460593a;
        Intrinsics.checkNotNullParameter(r101, "requestName");
        CleanStore.f460593a.remove(r101);
        CleanStore.f460594b.remove(r101);
        Lazy r103 = CleanStore.f460595c;
        ((KVRepo) r103.getValue()).remove("result_" + r101);
        ((KVRepo) r103.getValue()).remove("request_" + r101);
        Log.i("StorageCleaner", "all request data cleaned: " + r101);
    }

    public final long getTotalProgressWeight() {
        Iterator<T> r100 = this.cleanResources.iterator();
        long r101 = 0;
    L4:
        if (r100.hasNext() == false) goto L6;
        r101 = r101 + ((f) r100.next()).progressWeight();
        goto L4
    L6:
        return r101;
    }

    public int hashCode() {
        return (((this.uniqueName.hashCode() * 31) + this.retryCount) * 31) + this.cleanResources.hashCode();
    }

    public List<f> getResources() {
        return this.cleanResources;
    }

    public final int getRetryCount() {
        return this.retryCount;
    }

    public final String getUniqueName() {
        return this.uniqueName;
    }

    public List<f> getWhitelistResources() {
        return this.whiteListResources;
    }

    private final long calculateTotalSizeForPath(String r110) {
        PolarisFileWrapper r100 = new PolarisFileWrapper(r110);
    L22:
        e = move-exception;
        Log.e(TAG, "无法访问文件：" + r110, e);
        return 0;
    L4:
        if (r100.exists() == true) goto L7;
        return 0;
    L7:
        if (r100.isFile() == true) goto L9;
        Iterator<File> r101 = FilesKt.walk$default(r100, null, 1, null).iterator();     // Catch: Exception -> L22
        long r102 = 0;
    L12:
        if (r101.hasNext() == false) goto L21;
        File r103 = r101.next();     // Catch: Exception -> L22
    L18:
        e = move-exception;
        Log.e(TAG, "无法访问文件：" + r103.getAbsolutePath(), e);     // Catch: Exception -> L22
        goto L12
    L15:
        if (r103.isFile() == false) goto L12;
    L17:
        r102 = r102 + r103.length();
        goto L12
    L21:
        return r102;
    L9:
        return r100.length();
    }

    private final long calculateTotalSizeForPaths(List<String> r100) {
        List<String> r101 = r100;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r102.add(Long.valueOf(calculateTotalSizeForPath((String) r103.next())));
        goto L4
    L6:
        Iterator r104 = r102.iterator();
        long r105 = 0;
    L8:
        if (r104.hasNext() == false) goto L10;
        r105 = r105 + ((Number) r104.next()).longValue();
        goto L8
    L10:
        return r105;
    }

    private final List<String> removeRedundantPaths(List<String> r100) {
        List r101 = CollectionsKt.sortedWith(r100, c.f460592a);
        ArrayList r102 = new ArrayList();
        Iterator r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L26;
        String r104 = (String) r103.next();
        boolean r105 = false;
        if (r102.isEmpty() == true) goto L22;
        Iterator r106 = r102.iterator();
    L10:
        if (r106.hasNext() == false) goto L22;
        String r107 = (String) r106.next();
        if (Intrinsics.areEqual(r104, r107) == false) goto L14;
    L19:
        boolean r108 = true;
    L20:
        if (r108 == false) goto L10;
        r105 = true;
        goto L22
    L14:
        if (new PolarisFileWrapper(r107).isDirectory() == true) goto L16;
    L18:
        r108 = false;
        goto L20
    L16:
        if (StringsKt.startsWith$default(r104, r107, false, 2, null) == false) goto L18;
    L22:
        if (r105 == true) goto L4;
        if (new PolarisFileWrapper(r104).exists() == false) goto L4;
        r102.add(r104);
        goto L4
    L26:
        return r102;
    }

    public final long calculateCleanSize(Context r110) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        List<String> r100 = collectResourceFilePaths(r110, getResources());
        List<String> r111 = collectResourceFilePaths(r110, getWhitelistResources());
        List<String> r101 = removeRedundantPaths(r100);
        List<String> r112 = removeRedundantPaths(r111);
        ArrayList r102 = new ArrayList();
        Iterator<T> r113 = r112.iterator();
    L4:
        if (r113.hasNext() == false) goto L27;
        Object r103 = r113.next();
        String r104 = (String) r103;
        List<String> r105 = r101;
        boolean r106 = false;
        if ((r105 instanceof Collection) == true) goto L8;
    L10:
        Iterator<T> r107 = r105.iterator();
    L12:
        if (r107.hasNext() == false) goto L24;
        String r108 = p.a((String) r107.next());
        String r109 = p.a(r104);
        if (Intrinsics.areEqual(r109, r108) == false) goto L16;
    L21:
        boolean r114 = true;
    L22:
        if (r114 == false) goto L12;
        r106 = true;
        goto L24
    L16:
        if (new PolarisFileWrapper(r108).isDirectory() == true) goto L18;
    L20:
        r114 = false;
        goto L22
    L18:
        if (StringsKt.startsWith$default(r109, r108, false, 2, null) == false) goto L20;
    L24:
        if (r106 == false) goto L4;
        r102.add(r103);
        goto L4
    L8:
        if (r105.isEmpty() == false) goto L10;
    L27:
        return calculateTotalSizeForPaths(r101) - calculateTotalSizeForPaths(r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CleanRequest) == true) goto L8;
        return false;
    L8:
        CleanRequest r101 = (CleanRequest) r100;
        if (Intrinsics.areEqual(this.uniqueName, r101.uniqueName) == true) goto L12;
        return false;
    L12:
        if (this.retryCount == r101.retryCount) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.cleanResources, r101.cleanResources) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final com.suite.lark.platform.component.storage.clean.b newClean(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        h r101 = o.f460618a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(this, "request");
        if (o.f460620c == true) goto L15;
        o.f460620c = true;
        int r102 = e.f460603b;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        k r103 = (k) ((DwarfSPIEntryPoint) EntryPoints.get(Contexts.getApplication(r100.getApplicationContext()), DwarfSPIEntryPoint.class)).dwarfSPI().get(k.class);
        if (r103 == null) goto L9;
        Set<j> r104 = r103.a();
        if (r104 == null) goto L9;
    L10:
        Iterator<T> r105 = r104.iterator();
    L12:
        if (r105.hasNext() == false) goto L15;
        j r106 = (j) r105.next();
        r106.a(r100, o.f460618a);
        r106.b(r100, o.f460619b);
    L9:
        r104 = SetsKt.emptySet();
    L15:
        return new com.suite.lark.platform.component.storage.clean.c(r100, this, o.f460618a);
    }

    private final List<String> collectResourceFilePaths(Context r100, List<? extends f> r101) {
        ArrayList r102 = new ArrayList();
        if (r101 == null) goto L10;
        Iterator<T> r103 = r101.iterator();
    L6:
        if (r103.hasNext() == false) goto L10;
        f r104 = (f) r103.next();
        if ((r104 instanceof voc.a) == false) goto L6;
        r102.addAll(((voc.a) r104).getFilePaths(r100));
    L10:
        return r102;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CleanRequest(String r100, int r101, List<? extends Res> r102, List<? extends Res> r103) {
        Intrinsics.checkNotNullParameter(r100, "uniqueName");
        Intrinsics.checkNotNullParameter(r102, "cleanResources");
        this.uniqueName = r100;
        this.retryCount = r101;
        this.cleanResources = r102;
        this.whiteListResources = r103;
    }

    public /* synthetic */ CleanRequest(String r100, int r101, List r102, List r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 2) == 0) goto L6;
        r101 = 0;
    L6:
        if ((r104 & 8) == 0) goto L8;
        r103 = null;
    L8:
        this(r100, r101, r102, r103);
    }
}
