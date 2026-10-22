package com.ss.android.lark.storage;

import android.content.Context;
import android.os.Environment;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.framework.utils.file.direct.DirectFileAccess;
import com.larksuite.framework.utils.l;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.permission.StoragePermissionUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.File;
import java.util.HashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class f implements com.ss.android.lark.storage.file.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final HashMap<String, String> f440956c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final f f440957d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final f f440958e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final f f440959f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final f f440960g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final f f440961h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final f f440962i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final f f440963j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final f[] f440964k = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Location f440965a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PathType f440966b;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f440967a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f440968b = null;

        static {
            int[] r100 = new int[PathType.values().length];
            r100[PathType.ROOT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L26:
            r100[PathType.FILES.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L34:
            r100[PathType.CODE_CACHE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L28:
            r100[PathType.PICTURES.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
        L9:
            f440967a = r100;
            int[] r101 = new int[Location.values().length];
            r101[Location.INTERNAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L19
        L30:
            r101[Location.EXTERNAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L20
        L22:
            r101[Location.PUBLIC.ordinal()] = 3;     // Catch: NoSuchFieldError -> L21
        L13:
            f440968b = r101;
        }
    }

    static {
        f440956c = new HashMap(5);
        Location r100 = Location.INTERNAL;
        PathType r101 = PathType.FILES;
        f r102 = new f(r100, r101);
        f440957d = r102;
        PathType r103 = PathType.CACHE;
        f r104 = new f(r100, r103);
        f440958e = r104;
        PathType r105 = PathType.ROOT;
        f440959f = new f(r100, r105);
        Location r106 = Location.EXTERNAL;
        f r107 = new f(r106, r101);
        f440960g = r107;
        f r108 = new f(r106, r103);
        f440961h = r108;
        Location r109 = Location.PUBLIC;
        f r110 = new f(r109, r105);
        f440962i = r110;
        f r111 = new f(r109, PathType.PICTURES);
        f440963j = r111;
        f440964k = new f[]{r102, r104, r107, r108, r110, r111};
    }

    @Override // com.ss.android.lark.storage.file.b
    public final String getName() {
        StringBuilder r100 = new StringBuilder();
        r100.append(this.f440965a);
        r100.append('_');
        r100.append(this.f440966b);
        return r100.toString();
    }

    public final int hashCode() {
        return (this.f440965a.hashCode() * 31) + this.f440966b.hashCode();
    }

    public final String toString() {
        return getName();
    }

    public final PathType getType() {
        return this.f440966b;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (this.f440965a == r101.f440965a) goto L12;
        return false;
    L12:
        if (this.f440966b == r101.f440966b) goto L14;
        return false;
    L14:
        return true;
    }

    public f(Location r100, PathType r101) {
        Intrinsics.checkNotNullParameter(r100, "location");
        Intrinsics.checkNotNullParameter(r101, "type");
        this.f440965a = r100;
        this.f440966b = r101;
    }

    public final String a(Context r210, String r211) {
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r100 = f440956c.get(getName());
        String r101 = "";
        if (r100 != null) goto L64;
        int r102 = DirectFileAccess.a.f285968i;
        DirectFileAccess.a.C3931a r103 = new DirectFileAccess.a.C3931a();
        r103.f285980d = r210;
        int r104 = b.f440968b[this.f440965a.ordinal()];
        boolean r105 = true;
        if (r104 == 1) goto L46;
        if (r104 == 2) goto L38;
        if (r104 != 3) goto L37;
        int r106 = b.f440967a[this.f440966b.ordinal()];
        if (r106 != 1) goto L11;
        int r107 = o6c.d.f522233a;
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (StoragePermissionUtils.e(r210) == true) goto L69;
    L34:
        String r108 = l.a(r210);
    L35:
        r100 = r108;
        Unit r109 = Unit.INSTANCE;
        r105 = false;
    L54:
        if (r100 != null) goto L60;
        File r110 = DirectFileAccess.c(new DirectFileAccess.a(r103.f285977a, r103.f285978b, r103.f285979c, null, r103.f285980d, r103.f285981e, r103.f285982f, null));
        if (r110 == null) goto L58;
        String r111 = r110.getAbsolutePath();
    L59:
        r100 = r111;
        goto L60
    L58:
        r111 = null;
    L60:
        if (r105 == false) goto L64;
        if (r100 == null) goto L64;
        f440956c.put(getName(), r100);
        goto L64
    L69:
        r108 = l.d(r210);     // Catch: Exception -> L32
    L32:
        e = move-exception;
        Log.e("StoragePathUtils", "getExternalPublicDirPath failed, error:" + e.getMessage());
        goto L34
    L11:
        if (r106 != 4) goto L27;
        int r112 = o6c.d.f522233a;
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (StoragePermissionUtils.e(r210) == true) goto L71;
    L25:
        r108 = l.b(r210) + "/Pictures/";
        goto L35
    L71:
        File r113 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);     // Catch: Exception -> L20
        if (r113 != null) goto L18;
        r108 = "";
        goto L35
    L18:
        if (r113.exists() == true) goto L22;
        r113.mkdir();     // Catch: Exception -> L20
    L22:
        r108 = r113.getAbsolutePath();     // Catch: Exception -> L20
    L20:
        e = move-exception;
        Log.e("StoragePathUtils", "getStoragePicturesPath failed, error:" + e.getMessage());
        goto L25
    L27:
        throw new IllegalAccessException("not supported volume type: " + this.f440966b);
    L37:
        throw new NoWhenBranchMatchedException();
    L38:
        int r114 = b.f440967a[this.f440966b.ordinal()];
        if (r114 == 1) goto L45;
        if (r114 == 2) goto L44;
        if (r114 == 3) goto L43;
        r103.f285978b = DirectFileAccess.StorageLocation.EXTERNAL;
        r103.f285979c = DirectFileAccess.PathType.CACHE;
        goto L54
    L43:
        r103.f285978b = DirectFileAccess.StorageLocation.EXTERNAL;
        r103.f285979c = DirectFileAccess.PathType.CODE_CACHE;
        goto L54
    L44:
        r103.f285978b = DirectFileAccess.StorageLocation.EXTERNAL;
        r103.f285979c = DirectFileAccess.PathType.FILES;
        goto L54
    L45:
        r103.f285978b = DirectFileAccess.StorageLocation.EXTERNAL;
        r103.f285979c = DirectFileAccess.PathType.ROOT;
        goto L54
    L46:
        int r115 = b.f440967a[this.f440966b.ordinal()];
        if (r115 == 1) goto L53;
        if (r115 == 2) goto L52;
        if (r115 == 3) goto L51;
        r103.f285978b = DirectFileAccess.StorageLocation.INTERNAL;
        r103.f285979c = DirectFileAccess.PathType.CACHE;
        goto L54
    L51:
        r103.f285978b = DirectFileAccess.StorageLocation.INTERNAL;
        r103.f285979c = DirectFileAccess.PathType.CODE_CACHE;
        goto L54
    L52:
        r103.f285978b = DirectFileAccess.StorageLocation.INTERNAL;
        r103.f285979c = DirectFileAccess.PathType.FILES;
        goto L54
    L53:
        r103.f285978b = DirectFileAccess.StorageLocation.INTERNAL;
        r103.f285979c = DirectFileAccess.PathType.ROOT;
    L64:
        if (r211 == null) goto L68;
        r101 = r211;
    L68:
        return new PolarisFileWrapper(r100, r101).getAbsolutePath();
    }
}
