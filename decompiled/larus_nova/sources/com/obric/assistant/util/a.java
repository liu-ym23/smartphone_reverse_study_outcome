package com.obric.assistant.util;

import com.larus.utils.logger.FLogger;
import com.ss.android.lark.image.entity.LoadParams;
import java.io.File;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<String> f393658a = null;

    /* JADX INFO: renamed from: com.obric.assistant.util.a$a, reason: collision with other inner class name */
    public static final class C4636a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<String> f393659a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<String> f393660b;

        public C4636a() {
            List r100 = null;
            this(r100, r100, 3);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C4636a) == true) goto L8;
            return false;
        L8:
            C4636a r101 = (C4636a) r100;
            if (Intrinsics.areEqual(this.f393659a, r101.f393659a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f393660b, r101.f393660b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f393659a.hashCode() * 31) + this.f393660b.hashCode();
        }

        public final String toString() {
            return "PathClassifyResult(imagePaths=" + this.f393659a + ", otherPaths=" + this.f393660b + ')';
        }

        public C4636a(List<String> r100, List<String> r101) {
            Intrinsics.checkNotNullParameter(r100, "imagePaths");
            Intrinsics.checkNotNullParameter(r101, "otherPaths");
            this.f393659a = r100;
            this.f393660b = r101;
        }

        public /* synthetic */ C4636a(List r100, List r101, int r102) {
            if ((r102 & 1) == 0) goto L6;
            r100 = CollectionsKt.emptyList();
        L6:
            if ((r102 & 2) == 0) goto L8;
            r101 = CollectionsKt.emptyList();
        L8:
            this(r100, r101);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<String> f393661a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<String> f393662b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f393661a, r101.f393661a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f393662b, r101.f393662b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f393661a.hashCode() * 31) + this.f393662b.hashCode();
        }

        public final String toString() {
            return "PathSplitResult(imagePaths=" + this.f393661a + ", otherPaths=" + this.f393662b + ')';
        }

        public b(List<String> r100, List<String> r101) {
            Intrinsics.checkNotNullParameter(r100, "imagePaths");
            Intrinsics.checkNotNullParameter(r101, "otherPaths");
            this.f393661a = r100;
            this.f393662b = r101;
        }
    }

    static {
        f393658a = SetsKt.setOf(new String[]{LoadParams.ImageFormat.PNG, "jpg", LoadParams.ImageFormat.JPEG, "webp", "heic", "heif", "bmp"});
    }

    public static C4636a a(File r110) {
        int r100 = 3;
        List r101 = null;
        if (r110.exists() == true) goto L6;
        FLogger.f375446a.w("ObricTipOffDialogFragment", "gui log classification skipped: path not found, rawPath=" + r110.getAbsolutePath());
        return new C4636a(r101, r101, r100);
    L6:
        int r102 = 1;
        int r103 = 2;
        if (r110.isFile() == false) goto L14;
        if (f393658a.contains(FilesKt.getExtension(r110).toLowerCase(Locale.ROOT)) == false) goto L12;
        return new C4636a(CollectionsKt.listOf(r110.getAbsolutePath()), r101, r103);
    L12:
        return new C4636a(r101, CollectionsKt.listOf(r110.getAbsolutePath()), r102);
    L14:
        if (r110.isDirectory() == false) goto L16;
        File[] r104 = r110.listFiles();
        int r105 = 0;
        if (r104 != null) goto L21;
        r104 = new File[0];
    L21:
        if (r104.length != 0) goto L23;
        boolean r106 = true;
    L24:
        if (r106 == false) goto L27;
        FLogger.f375446a.i("ObricTipOffDialogFragment", "gui log classification skipped: empty directory, dir=" + r110.getAbsolutePath());
        return new C4636a(r101, r101, r100);
    L27:
        LinkedHashSet r107 = new LinkedHashSet();
        LinkedHashSet r108 = new LinkedHashSet();
        int r109 = r104.length;
    L28:
        if (r105 >= r109) goto L31;
        File r111 = r104[r105];
        Intrinsics.checkNotNull(r111);
        C4636a r112 = a(r111);
        r107.addAll(r112.f393659a);
        r108.addAll(r112.f393660b);
        r105 = r105 + 1;
        goto L28
    L31:
        if (r107.isEmpty() == false) goto L36;
        if (r108.isEmpty() == false) goto L36;
        FLogger.f375446a.i("ObricTipOffDialogFragment", "gui log classification skipped: no uploadable files under directory, dir=" + r110.getAbsolutePath());
        return new C4636a(r101, r101, r100);
    L36:
        if ((!r107.isEmpty()) == false) goto L42;
        if (r108.isEmpty() == false) goto L42;
        FLogger.f375446a.i("ObricTipOffDialogFragment", "gui log classification: directory contains images only, keep directory path, dir=" + r110.getAbsolutePath());
        C4636a r113 = new C4636a(CollectionsKt.listOf(r110.getAbsolutePath()), r101, r103);
    L51:
        return r113;
    L42:
        if (r107.isEmpty() == true) goto L44;
    L46:
        FLogger.f375446a.i("ObricTipOffDialogFragment", "gui log classification: directory contains both image and non-image files, split into child paths, dir=" + r110.getAbsolutePath());
        return new C4636a(CollectionsKt.toList(r107), CollectionsKt.toList(r108));
    L44:
        if ((!r108.isEmpty()) == false) goto L46;
        FLogger.f375446a.i("ObricTipOffDialogFragment", "gui log classification: directory contains non-image files only, keep directory path, dir=" + r110.getAbsolutePath());
        r113 = new C4636a(r101, CollectionsKt.listOf(r110.getAbsolutePath()), r102);
        goto L51
    L23:
        r106 = false;
        goto L24
    L16:
        return new C4636a(r101, r101, r100);
    }
}
