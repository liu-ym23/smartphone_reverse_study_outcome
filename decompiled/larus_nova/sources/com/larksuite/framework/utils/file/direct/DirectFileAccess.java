package com.larksuite.framework.utils.file.direct;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.framework.utils.DevEnvUtil;
import com.ss.android.lark.log.Log;
import com.ss.ttvideoengine.model.VideoRef;
import java.io.File;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class DirectFileAccess {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f285961a = null;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/larksuite/framework/utils/file/direct/DirectFileAccess$InvalidPathTypeException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "tag", "", "params", "Lcom/larksuite/framework/utils/file/direct/DirectFileAccess$StorageParams;", "<init>", "(Ljava/lang/String;Lcom/larksuite/framework/utils/file/direct/DirectFileAccess$StorageParams;)V", "common-utils_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class InvalidPathTypeException extends Exception {
        public InvalidPathTypeException(String r100, a r101) {
            Intrinsics.checkNotNullParameter(r100, "tag");
            Intrinsics.checkNotNullParameter(r101, "params");
            super(r100 + ": invalid path type: " + r101.f285971c);
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/larksuite/framework/utils/file/direct/DirectFileAccess$NullContextException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "tag", "", "params", "Lcom/larksuite/framework/utils/file/direct/DirectFileAccess$StorageParams;", "<init>", "(Ljava/lang/String;Lcom/larksuite/framework/utils/file/direct/DirectFileAccess$StorageParams;)V", "common-utils_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class NullContextException extends Exception {
        public NullContextException(String r100, a r101) {
            Intrinsics.checkNotNullParameter(r100, "tag");
            Intrinsics.checkNotNullParameter(r101, "params");
            super(r100 + ": context is null, scope: " + r101.f285969a + ", location: " + r101.f285970b);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larksuite/framework/utils/file/direct/DirectFileAccess$PathType;", "", "<init>", "(Ljava/lang/String;I)V", "ROOT", "CACHE", "CODE_CACHE", "FILES", "common-utils_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum PathType extends Enum<PathType> {
        public static final PathType CACHE = null;
        public static final PathType CODE_CACHE = null;
        public static final PathType FILES = null;
        public static final PathType ROOT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ PathType[] f285962a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f285963b = null;

        public static EnumEntries<PathType> getEntries() {
            return f285963b;
        }

        static {
            PathType r100 = new PathType("ROOT", 0);
            ROOT = r100;
            PathType r101 = new PathType("CACHE", 1);
            CACHE = r101;
            PathType r102 = new PathType("CODE_CACHE", 2);
            CODE_CACHE = r102;
            PathType r103 = new PathType("FILES", 3);
            FILES = r103;
            PathType[] r104 = {r100, r101, r102, r103};
            f285962a = r104;
            f285963b = EnumEntriesKt.enumEntries(r104);
        }

        public static PathType[] values() {
            return (PathType[]) f285962a.clone();
        }

        public static PathType valueOf(String r100) {
            return (PathType) r27.a.a(PathType.class, r100);
        }

        public PathType(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larksuite/framework/utils/file/direct/DirectFileAccess$ScopedStorage;", "", "<init>", "(Ljava/lang/String;I)V", "APP", "SHARED", "common-utils_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ScopedStorage extends Enum<ScopedStorage> {
        public static final ScopedStorage APP = null;

        @Deprecated(message = "use MediaStore or SAF instead")
        public static final ScopedStorage SHARED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ScopedStorage[] f285964a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f285965b = null;

        public static EnumEntries<ScopedStorage> getEntries() {
            return f285965b;
        }

        static {
            ScopedStorage r100 = new ScopedStorage("APP", 0);
            APP = r100;
            ScopedStorage r101 = new ScopedStorage("SHARED", 1);
            SHARED = r101;
            ScopedStorage[] r102 = {r100, r101};
            f285964a = r102;
            f285965b = EnumEntriesKt.enumEntries(r102);
        }

        public static ScopedStorage[] values() {
            return (ScopedStorage[]) f285964a.clone();
        }

        public static ScopedStorage valueOf(String r100) {
            return (ScopedStorage) r27.a.a(ScopedStorage.class, r100);
        }

        public ScopedStorage(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larksuite/framework/utils/file/direct/DirectFileAccess$StorageLocation;", "", "<init>", "(Ljava/lang/String;I)V", "INTERNAL", "EXTERNAL", "common-utils_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum StorageLocation extends Enum<StorageLocation> {
        public static final StorageLocation EXTERNAL = null;
        public static final StorageLocation INTERNAL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ StorageLocation[] f285966a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f285967b = null;

        public static EnumEntries<StorageLocation> getEntries() {
            return f285967b;
        }

        static {
            StorageLocation r100 = new StorageLocation("INTERNAL", 0);
            INTERNAL = r100;
            StorageLocation r101 = new StorageLocation("EXTERNAL", 1);
            EXTERNAL = r101;
            StorageLocation[] r102 = {r100, r101};
            f285966a = r102;
            f285967b = EnumEntriesKt.enumEntries(r102);
        }

        public static StorageLocation[] values() {
            return (StorageLocation[]) f285966a.clone();
        }

        public static StorageLocation valueOf(String r100) {
            return (StorageLocation) r27.a.a(StorageLocation.class, r100);
        }

        public StorageLocation(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final /* synthetic */ int f285968i = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ScopedStorage f285969a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final StorageLocation f285970b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final PathType f285971c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f285972d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Context f285973e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Set<String> f285974f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final z28.b f285975g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final z28.a f285976h;

        /* JADX INFO: renamed from: com.larksuite.framework.utils.file.direct.DirectFileAccess$a$a, reason: collision with other inner class name */
        public static final class C3931a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final ScopedStorage f285977a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public StorageLocation f285978b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public PathType f285979c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public Context f285980d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final Set<String> f285981e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final c f285982f;

            public C3931a() {
                this.f285977a = ScopedStorage.APP;
                this.f285978b = StorageLocation.INTERNAL;
                this.f285979c = PathType.FILES;
                this.f285981e = SetsKt.setOf("mounted");
                this.f285982f = DirectFileAccess.f285961a;
            }
        }

        public static final class b {
        }

        static {
        }

        public a() {
            this(null, null, null, null, 255);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f285969a == r101.f285969a) goto L12;
            return false;
        L12:
            if (this.f285970b == r101.f285970b) goto L15;
            return false;
        L15:
            if (this.f285971c == r101.f285971c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f285972d, r101.f285972d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f285973e, r101.f285973e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f285974f, r101.f285974f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.f285975g, r101.f285975g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.f285976h, r101.f285976h) == true) goto L32;
            return false;
        L32:
            return true;
        }

        public final int hashCode() {
            ScopedStorage r100 = this.f285969a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            StorageLocation r104 = this.f285970b;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            PathType r107 = this.f285971c;
            if (r107 != null) goto L13;
            int r108 = 0;
        L14:
            int r109 = (r106 + r108) * 31;
            String r110 = this.f285972d;
            if (r110 != null) goto L17;
            int r111 = 0;
        L18:
            int r112 = (r109 + r111) * 31;
            Context r113 = this.f285973e;
            if (r113 != null) goto L21;
            int r114 = 0;
        L22:
            int r115 = (((r112 + r114) * 31) + this.f285974f.hashCode()) * 31;
            z28.b r116 = this.f285975g;
            if (r116 != null) goto L25;
            int r117 = 0;
        L26:
            int r118 = (r115 + r117) * 31;
            z28.a r119 = this.f285976h;
            if (r119 == null) goto L31;
            r101 = r119.hashCode();
        L31:
            return r118 + r101;
        L25:
            r117 = r116.hashCode();
            goto L26
        L21:
            r114 = r113.hashCode();
            goto L22
        L17:
            r111 = r110.hashCode();
            goto L18
        L13:
            r108 = r107.hashCode();
            goto L14
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "StorageParams(scope=" + this.f285969a + ", location=" + this.f285970b + ", pathType=" + this.f285971c + ", type=" + this.f285972d + ", context=" + this.f285973e + ", storageState=" + this.f285974f + ", log=" + this.f285975g + ", contextGet=" + this.f285976h + ')';
        }

        public final Context getContext() {
            return this.f285973e;
        }

        public final String getType() {
            return this.f285972d;
        }

        public static a a(a r100, ScopedStorage r110, Context r111, int r112) {
            if ((r112 & 1) == 0) goto L5;
            r110 = r100.f285969a;
        L5:
            ScopedStorage r101 = r110;
            if ((r112 & 2) == 0) goto L8;
            StorageLocation r102 = r100.f285970b;
        L10:
            if ((r112 & 4) == 0) goto L12;
            PathType r103 = r100.f285971c;
        L14:
            if ((r112 & 8) == 0) goto L16;
            String r104 = r100.f285972d;
        L18:
            if ((r112 & 16) == 0) goto L20;
            r111 = r100.f285973e;
        L20:
            Context r105 = r111;
            if ((r112 & 32) == 0) goto L23;
            Set<String> r106 = r100.f285974f;
        L25:
            if ((r112 & 64) == 0) goto L27;
            z28.b r107 = r100.f285975g;
        L29:
            if ((r112 & 128) == 0) goto L31;
            z28.a r108 = r100.f285976h;
        L32:
            Intrinsics.checkNotNullParameter(r106, "storageState");
            return new a(r101, r102, r103, r104, r105, r106, r107, r108);
        L31:
            r108 = null;
            goto L32
        L27:
            r107 = null;
            goto L29
        L23:
            r106 = null;
            goto L25
        L16:
            r104 = null;
            goto L18
        L12:
            r103 = null;
            goto L14
        L8:
            r102 = null;
            goto L10
        }

        public /* synthetic */ a(ScopedStorage r110, StorageLocation r111, String r112, Context r113, int r114) {
            if ((r114 & 1) == 0) goto L5;
            r110 = ScopedStorage.APP;
        L5:
            ScopedStorage r100 = r110;
            if ((r114 & 2) == 0) goto L8;
            r111 = StorageLocation.INTERNAL;
        L8:
            StorageLocation r101 = r111;
            if ((r114 & 4) == 0) goto L11;
            PathType r102 = PathType.FILES;
        L13:
            if ((r114 & 8) == 0) goto L15;
            String r103 = null;
        L17:
            if ((r114 & 16) == 0) goto L19;
            Context r104 = null;
        L21:
            if ((r114 & 32) == 0) goto L23;
            Set r105 = SetsKt.setOf("mounted");
        L25:
            if ((r114 & 64) == 0) goto L27;
            c r106 = DirectFileAccess.f285961a;
        L29:
            if ((r114 & 128) == 0) goto L31;
            c r115 = DirectFileAccess.f285961a;
        L31:
            this(r100, r101, r102, r103, r104, r105, r106, null);
            return;
        L27:
            r106 = null;
            goto L29
        L23:
            r105 = null;
            goto L25
        L19:
            r104 = r113;
            goto L21
        L15:
            r103 = r112;
            goto L17
        L11:
            r102 = null;
            goto L13
        }

        public a(ScopedStorage r100, StorageLocation r101, PathType r102, String r103, Context r104, Set<String> r105, z28.b r106, z28.a r107) {
            Intrinsics.checkNotNullParameter(r105, "storageState");
            this.f285969a = r100;
            this.f285970b = r101;
            this.f285971c = r102;
            this.f285972d = r103;
            this.f285973e = r104;
            this.f285974f = r105;
            this.f285975g = r106;
            this.f285976h = r107;
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f285983a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f285984b = null;

        static {
            int[] r100 = new int[ScopedStorage.values().length];
            r100[ScopedStorage.APP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[ScopedStorage.SHARED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L6:
            f285983a = r100;
            int[] r101 = new int[StorageLocation.values().length];
            r101[StorageLocation.INTERNAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L21:
            r101[StorageLocation.EXTERNAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L9:
            f285984b = r101;
        }
    }

    public static final class c implements z28.b {
        public c() {
        }

        @Override // z28.b
        public final void exception(Exception r100) {
            Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);
            c r101 = DirectFileAccess.f285961a;
            if (DevEnvUtil.isDebugMode(null) == true) goto L5;
            return;
        L5:
            throw r100;
        }

        @Override // z28.b
        public final void e(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "tag");
            Intrinsics.checkNotNullParameter(r101, "message");
            Log.e(r100, r101);
        }
    }

    static {
        f285961a = new c();
    }

    @JvmStatic
    public static final File a(a r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        ScopedStorage r101 = r100.f285969a;
        if (r101 != null) goto L5;
        int r102 = -1;
    L7:
        if (r102 == 1) goto L20;
        if (r102 != 2) goto L21;
        Intrinsics.checkNotNullParameter(r100, "params");
        if (d(r100) == false) goto L22;
        int r103 = a38.a.f1681a;
        String r104 = r100.getType();
        if (r104 == null) goto L24;
        Intrinsics.checkNotNullParameter(r104, "type");
        File r105 = Environment.getExternalStoragePublicDirectory(r104);
        if (r105 == null) goto L24;
        return r105;
    L24:
        return Environment.getExternalStorageDirectory();
    L22:
        return b(r100);
    L21:
        return a(a.a(r100, ScopedStorage.APP, null, 254));
    L20:
        return c(r100);
    L5:
        r102 = b.f285983a[r101.ordinal()];
        goto L7
    }

    public static File b(a r100) {
        int r101 = com.larksuite.framework.utils.file.direct.b.f285987a;
        Intrinsics.checkNotNullParameter(r100, "params");
        PathType r102 = r100.f285971c;
        if (r102 != null) goto L5;
        int r103 = -1;
    L7:
        if (r103 != 1) goto L9;
        Intrinsics.checkNotNullParameter(r100, "params");
        Context r104 = r100.getContext();
        if (r104 != null) goto L29;
    L32:
        return null;
    L29:
        if (Build.VERSION.SDK_INT < 24) goto L38;
        return r104.getDataDir();
    L38:
        return new PolarisFileWrapper(r104.getApplicationInfo().dataDir);
    L9:
        if (r103 != 2) goto L11;
        Intrinsics.checkNotNullParameter(r100, "params");
        Context r105 = r100.getContext();
        if (r105 == null) goto L32;
        return r105.getCacheDir();
    L11:
        if (r103 != 3) goto L13;
        Intrinsics.checkNotNullParameter(r100, "params");
        Context r106 = r100.getContext();
        if (r106 == null) goto L32;
        return r106.getCodeCacheDir();
    L13:
        if (r103 == 4) goto L17;
        z28.b r107 = r100.f285975g;
        if (r107 == null) goto L32;
        r107.e("AppInternalPathUtils", "invalid path type: " + r100.f285971c);
        r107.exception(new InvalidPathTypeException("AppInternalPathUtils", r100));
        goto L32
    L17:
        Intrinsics.checkNotNullParameter(r100, "params");
        Context r108 = r100.getContext();
        if (r108 == null) goto L32;
        return r108.getFilesDir();
    L5:
        r103 = com.larksuite.framework.utils.file.direct.b.a.f285988a[r102.ordinal()];
        goto L7
    }

    @JvmStatic
    public static final File c(a r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        File r101 = null;
        if (r100.getContext() != null) goto L19;
        z28.a r102 = r100.f285976h;
        if (r102 == null) goto L7;
        Context r103 = r102.getContext();
    L8:
        z28.b r104 = r100.f285975g;
        if (r104 == null) goto L11;
        r104.e("DirectFileAccess", "context is null");
    L11:
        if (r103 == null) goto L17;
        z28.b r105 = r100.f285975g;
        if (r105 == null) goto L16;
        r105.exception(new NullContextException("DirectFileAccess", r100));
    L16:
        return c(a.a(r100, null, r103, VideoRef.VALUE_VIDEO_REF_SUBTITLE_POSITION_X));
    L17:
        return null;
    L7:
        r103 = null;
        goto L8
    L19:
        if (r100.f285970b == StorageLocation.EXTERNAL) goto L21;
    L24:
        StorageLocation r106 = r100.f285970b;
        int r107 = -1;
        if (r106 != null) goto L27;
        int r108 = -1;
    L29:
        if (r108 == 1) goto L72;
        if (r108 != 2) goto L75;
        int r109 = com.larksuite.framework.utils.file.direct.a.f285985a;
        Intrinsics.checkNotNullParameter(r100, "params");
        PathType r110 = r100.f285971c;
        if (r110 == null) goto L37;
        r107 = com.larksuite.framework.utils.file.direct.a.C3932a.f285986a[r110.ordinal()];
    L37:
        if (r107 == 1) goto L65;
        if (r107 != 2) goto L40;
        Intrinsics.checkNotNullParameter(r100, "params");
        Context r111 = r100.getContext();     // Catch: Exception -> L64
        if (r111 == null) goto L68;
        r101 = r111.getExternalFilesDir(r100.getType());     // Catch: Exception -> L64
    L68:
        if (r101 != null) goto L77;
        return b(r100);
    L77:
        return r101;
    L40:
        if (r107 == 3) goto L44;
        z28.b r112 = r100.f285975g;
        if (r112 == null) goto L68;
        r112.e("AppExternalPathUtils", "invalid path type " + r100.f285971c);
        r112.exception(new InvalidPathTypeException("AppExternalPathUtils", r100));
        goto L68
    L44:
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r100, "params");
        Context r113 = r100.getContext();
        if (r113 == null) goto L47;
        File r114 = r113.getExternalCacheDir();
    L48:
        if (r114 == null) goto L50;
        File r115 = r114.getParentFile();
    L51:
        if (r115 == null) goto L53;
    L52:
        r101 = r115;
        goto L68
    L53:
        Context r116 = r100.getContext();
        if (r116 == null) goto L56;
        String r117 = r116.getPackageName();
    L57:
        if (r117 == null) goto L68;
        r101 = new PolarisFileWrapper(Environment.getExternalStorageDirectory() + "/Android/data/" + r100.getContext().getPackageName());
        goto L68
    L56:
        r117 = null;
        goto L57
    L50:
        r115 = null;
        goto L51
    L47:
        r114 = null;
        goto L48
    L65:
        Intrinsics.checkNotNullParameter(r100, "params");
        Context r118 = r100.getContext();
        if (r118 == null) goto L68;
        r115 = r118.getExternalCacheDir();
        goto L52
    L75:
        return b(r100);
    L72:
        return b(r100);
    L27:
        r108 = b.f285984b[r106.ordinal()];
        goto L29
    L21:
        if (d(r100) == true) goto L24;
        return b(r100);
    }

    public static boolean d(a r100) {
        return r100.f285974f.contains(Environment.getExternalStorageState());
    L4:
        Set<String> r101 = r100.f285974f;     // Catch: Throwable -> L9
        Context r102 = r100.getContext();     // Catch: Throwable -> L9
        File r103 = null;
        if (r102 == null) goto L7;
        r103 = r102.getExternalFilesDir(null);     // Catch: Throwable -> L9
    L7:
        return r101.contains(Environment.getExternalStorageState(r103));
    L9:
        return true;
    }
}
