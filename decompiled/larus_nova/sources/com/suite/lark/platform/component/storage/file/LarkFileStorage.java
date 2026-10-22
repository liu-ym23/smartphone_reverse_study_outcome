package com.suite.lark.platform.component.storage.file;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.storage.f;
import com.ss.android.lark.storage.file.FileStorage;
import com.ss.android.lark.storage.file.RootDirResolver;
import com.ss.android.lark.storage.file.USFFileSystemProvider;
import com.ss.android.lark.storage.file.d;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.vfs.Schemes;
import com.ss.android.lark.vfs.c;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import java.io.File;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes36.dex */
public final class LarkFileStorage {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile Application f460624a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile a f460625b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final HashMap<String, FileStorage> f460626c = null;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J \u0010\f\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\rH\u0016J\u0018\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\rH\u0016J\u0018\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\rH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/suite/lark/platform/component/storage/file/LarkFileStorage$LarkSpaceRootDirResolver;", "Lcom/ss/android/lark/storage/file/FileStorage$DefaultRootDirResolver;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "useNew", "", "<init>", "(Landroid/content/Context;Z)V", "getContext", "()Landroid/content/Context;", "userSpaceDirFormatter", "Lcom/suite/lark/platform/component/storage/file/LarkFileStorage$UserSpaceDirFormatter;", "getRootDir", "", ITTVideoEngineEventSource.KEY_VOLUME, "Lcom/ss/android/lark/storage/file/IVolume;", "spaceName", "getVolumeRootDir", "volumeParentRoot", "getSpaceDirName", "lark-storage_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LarkSpaceRootDirResolver extends FileStorage.DefaultRootDirResolver {
        private final Context context;
        private final boolean useNew;
        private final b userSpaceDirFormatter;

        public final Context getContext() {
            return this.context;
        }

        public LarkSpaceRootDirResolver(Context r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            this.context = r100;
            this.useNew = r101;
            this.userSpaceDirFormatter = new b();
        }

        @Override // com.ss.android.lark.storage.file.FileStorage.DefaultRootDirResolver, com.ss.android.lark.storage.file.RootDirResolver
        public String getSpaceDirName(Context r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "spaceName");
            if (Intrinsics.areEqual(r101, "Lark") == true) goto L30;
            b r102 = this.userSpaceDirFormatter;
            r102.getClass();
            Intrinsics.checkNotNullParameter(r101, "userSpace");
            ConcurrentHashMap<String, String> r103 = r102.f460629a;
            String r104 = r103.get(r101);
            if (r104 != null) goto L22;
            StringBuilder r105 = new StringBuilder();
            MessageDigest r106 = MessageDigest.getInstance("MD5");     // Catch: Exception -> L12
            r106.update(r101.getBytes(Charsets.UTF_8));     // Catch: Exception -> L12
            String r107 = new BigInteger(1, r106.digest()).toString(16);     // Catch: Exception -> L12
            if (24 > r107.length()) goto L14;
            r107 = r107.substring(8, 24);     // Catch: Exception -> L12
        L14:
            r105.append(r107);
            r105.append('_');
            if (r101.length() <= 4) goto L17;
            String r108 = r101.substring(r101.length() - 4);
        L18:
            r105.append(r108);
            r104 = r105.toString();
            String r109 = r103.putIfAbsent(r101, r104);
            if (r109 == null) goto L22;
            r104 = r109;
            goto L22
        L17:
            r108 = r101;
        L12:
            e = move-exception;
            Log.e("LarkFileStorage", "space name md5 failed:", e);
            r107 = r101;
        L22:
            String r110 = r104;
            if (this.useNew == false) goto L25;
            String r111 = "user" + File.separator + r110;
        L27:
            return r111;
        L25:
            r111 = "uz_" + r110;
            goto L27
        L30:
            return r101;
        }

        @Override // com.ss.android.lark.storage.file.FileStorage.DefaultRootDirResolver
        public String getVolumeRootDir(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "volumeParentRoot");
            Intrinsics.checkNotNullParameter(r101, "spaceName");
            return super.getVolumeRootDir(r100, getSpaceDirName(this.context, r101));
        }

        @Override // com.ss.android.lark.storage.file.FileStorage.DefaultRootDirResolver, com.ss.android.lark.storage.file.RootDirResolver
        public String getRootDir(Context r100, com.ss.android.lark.storage.file.b r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, ITTVideoEngineEventSource.KEY_VOLUME);
            Intrinsics.checkNotNullParameter(r102, "spaceName");
            HashMap<String, String> r103 = f.f440956c;
            return getVolumeRootDir(((f) r101).a(r100, null), r102);
        }
    }

    public static final class LarkUniUriFactory implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Schemes f460627a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final RootDirResolver f460628b;

        @Override // com.ss.android.lark.storage.file.d
        public final c b() {
            return new USFFileSystemProvider(this.f460627a.getValue(), this.f460628b);
        }

        public LarkUniUriFactory(Schemes r100, LarkSpaceRootDirResolver r101) {
            Intrinsics.checkNotNullParameter(r100, "supportScheme");
            Intrinsics.checkNotNullParameter(r101, "rootDirResolver");
            this.f460627a = r100;
            this.f460628b = r101;
        }

        @Override // com.ss.android.lark.storage.file.d
        public final Uri a(Context r100, final com.ss.android.lark.storage.file.b r101, final String r102, RootDirResolver r103, final com.ss.android.lark.storage.d r104) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, ITTVideoEngineEventSource.KEY_VOLUME);
            Intrinsics.checkNotNullParameter(r102, "spaceName");
            Intrinsics.checkNotNullParameter(r103, "rootDirResolver");
            String r105 = com.ss.android.lark.storage.file.c.f440978e;
            Function1<com.ss.android.lark.storage.file.c.b, Unit> r106 = new LarkFileStorage$LarkUniUriFactory$customVFSUri$1(this, r102, r101, r104);
            Intrinsics.checkNotNullParameter(r106, "block");
            com.ss.android.lark.storage.file.c.b r107 = new com.ss.android.lark.storage.file.c.b();
            r106.invoke(r107);
            if (r107.f440952a != null) goto L6;
            r107.f440952a = com.ss.android.lark.storage.file.c.f440978e;
        L6:
            return UriProtector.parse(new com.ss.android.lark.storage.file.c(r107).a());
        }
    }

    public interface a {
        String a();
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ConcurrentHashMap<String, String> f460629a;

        public b() {
            this.f460629a = new ConcurrentHashMap();
        }
    }

    @JvmStatic
    public static final FileStorage b() {
        return a("Lark", false);
    }

    static {
        f460626c = new HashMap();
    }

    @Deprecated(message = "use userSpace2(userId)  instead if possible")
    @JvmStatic
    public static final FileStorage c() {
        a r100 = f460625b;
        if (r100 == null) goto L6;
        String r101 = r100.a();
        if (r101 == null) goto L6;
    L8:
        return d(r101);
    L6:
        r101 = "";
        goto L8
    }

    @Deprecated(message = "use userSpace2(userId)  instead if possible")
    @JvmStatic
    public static final FileStorage e() {
        a r100 = f460625b;
        if (r100 == null) goto L6;
        String r101 = r100.a();
        if (r101 == null) goto L6;
    L8:
        return f(r101);
    L6:
        r101 = "";
        goto L8
    }

    @Deprecated(message = "use userSpace2 instead if possible")
    @JvmStatic
    public static final FileStorage d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        return a(r100, false);
    }

    @JvmStatic
    public static final FileStorage f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        return a(r100, true);
    }

    public static FileStorage a(String r100, boolean r101) {
        FileStorage r102 = f460626c.get(r100 + '_' + r101);
        if (r102 != null) goto L18;
        Application r103 = f460624a;
        Application r104 = null;
        if (r103 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException(PerfLog.PARAM_KEY_CONTEXT_ID);
        r103 = null;
    L7:
        LarkSpaceRootDirResolver r105 = new LarkSpaceRootDirResolver(r103, r101);
        if (r101 == false) goto L10;
        Schemes r106 = Schemes.USF2;
    L11:
        LarkUniUriFactory r107 = new LarkUniUriFactory(r106, r105);
        Application r108 = f460624a;
        if (r108 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException(PerfLog.PARAM_KEY_CONTEXT_ID);
    L15:
        FileStorage.a r109 = new FileStorage.a(r104);
        Intrinsics.checkNotNullParameter(r100, "spaceName");
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        r109.f440971b = r100;
        Intrinsics.checkNotNullParameter(r107, "uriFactory");
        r109.f440973d = r107;
        Intrinsics.checkNotNullParameter(r105, "rootDirResolver");
        r109.f440972c = r105;
        return new FileStorage(r109);
    L14:
        r104 = r108;
        goto L15
    L10:
        r106 = Schemes.USF;
        goto L11
    L18:
        return r102;
    }
}
