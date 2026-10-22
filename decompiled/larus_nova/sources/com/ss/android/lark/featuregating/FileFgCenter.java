package com.ss.android.lark.featuregating;

import com.larksuite.framework.utils.FileUtils;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Deprecated(message = "replace with FlashFG")
public final class FileFgCenter {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f420719c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final FileFgCenter f420720d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, c> f420721a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f420722b;

    public static final class a {
    }

    public interface b {
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f420723a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Boolean f420724b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final b f420725c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f420723a, r101.f420723a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f420724b, r101.f420724b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f420725c, r101.f420725c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f420723a.hashCode() * 31;
            Boolean r101 = this.f420724b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return ((r100 + r102) * 31) + this.f420725c.hashCode();
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "KeyBean(markFile=" + this.f420723a + ", isEnable=" + this.f420724b + ", keyChecker=" + this.f420725c + ')';
        }

        public c(String r100, d r101) {
            Intrinsics.checkNotNullParameter(r100, "markFile");
            Intrinsics.checkNotNullParameter(r101, "keyChecker");
            this.f420723a = r100;
            this.f420724b = null;
            this.f420725c = r101;
        }
    }

    public static final class d implements b {
        public d() {
        }
    }

    static {
        f420719c = new String[]{"privacy_detection_dynamic", "render_svg_image"};
        f420720d = new FileFgCenter();
    }

    public FileFgCenter() {
        this.f420721a = new ConcurrentHashMap();
        this.f420722b = LazyKt.lazy(new FileFgCenter$mFileDir$2(this));
        d r100 = new d();
        String[] r101 = f420719c;
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        String r104 = r101[r103];
        Intrinsics.checkNotNullParameter(r104, "featureName");
        Intrinsics.checkNotNullParameter(r100, "keyChecker");
        this.f420721a.put(r104, new c(((String) this.f420722b.getValue()) + File.separator + r104, r100));
        r103 = r103 + 1;
        goto L3
    }

    public final synchronized boolean a(String r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "keyName");     // Catch: Throwable -> L12
        c r101 = this.f420721a.get(r100);     // Catch: Throwable -> L12
        if (r101 != null) goto L7;
        boolean r102 = FileUtils.r(((String) this.f420722b.getValue()) + File.separator + r100);     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);
        return r102;
    L7:
        if (r101.f420724b != null) goto L9;
        r101.f420724b = Boolean.valueOf(FileUtils.r(r101.f420723a));     // Catch: Throwable -> L12
    L9:
        r102 = Intrinsics.areEqual(r101.f420724b, Boolean.TRUE);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }
}
