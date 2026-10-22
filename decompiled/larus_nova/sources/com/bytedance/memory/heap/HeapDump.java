package com.bytedance.memory.heap;

import java.io.File;
import java.io.Serializable;
import r17.g;

/* JADX INFO: loaded from: classes21.dex */
public final class HeapDump implements Serializable {
    public boolean computeRetainedHeapSize;
    public long currentTime;
    public final long gcDurationMs;
    public final long heapDumpDurationMs;
    public File heapDumpFile;
    public long heapDumpFileSize;
    public boolean isDebug;
    public String referenceClassName;
    public final String referenceKey;
    public final String referenceName;
    public String shrinkFilePath;
    public final long watchDurationMs;

    public static /* synthetic */ class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f265485a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public File f265486b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f265487c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f265488d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f265489e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f265490f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f265491g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public long f265492h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f265493i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public long f265494j;

        public b() {
            this.f265486b = null;
            this.f265488d = null;
            this.f265485a = true;
            this.f265489e = "";
            this.f265490f = 0;
            this.f265491g = 0;
            this.f265492h = 0;
            this.f265493i = true;
        }
    }

    public static b newBuilder() {
        return new b();
    }

    public String toString() {
        return " heapDumpFilePath " + this.heapDumpFile.getPath() + "\n heapDumpFileSize " + this.heapDumpFile.length() + "\n referenceName " + this.referenceName + "\n isDebug " + this.isDebug + "\n currentTime " + this.currentTime + "\n watchDurationMs " + this.watchDurationMs + "ms\n gcDurationMs " + this.gcDurationMs + "ms\n shrinkFilePath " + this.shrinkFilePath + "\n heapDumpDurationMs " + this.heapDumpDurationMs + "ms\n";
    }

    private HeapDump(b r100) {
        this.isDebug = true;
        this.computeRetainedHeapSize = true;
        this.isDebug = r100.f265485a;
        this.currentTime = r100.f265494j;
        this.heapDumpFile = r100.f265486b;
        this.referenceKey = r100.f265488d;
        this.referenceName = r100.f265489e;
        this.computeRetainedHeapSize = r100.f265493i;
        this.watchDurationMs = r100.f265490f;
        this.shrinkFilePath = r100.f265487c;
        this.gcDurationMs = r100.f265491g;
        this.heapDumpDurationMs = r100.f265492h;
    }

    public /* synthetic */ HeapDump(b r100, a r101) {
        this(r100);
    }

    public HeapDump(File r100, String r101, String r102, long r103, long r104, long r110, boolean r111) {
        b r105 = new b();
        g.a(r100, "heapDumpFile");
        r105.f265486b = r100;
        g.a(r101, "referenceKey");
        r105.f265488d = r101;
        g.a(r102, "referenceName");
        r105.f265489e = r102;
        r105.f265485a = r111;
        r105.f265493i = true;
        r105.f265490f = r103;
        r105.f265491g = r104;
        r105.f265492h = r110;
        this(r105);
    }
}
