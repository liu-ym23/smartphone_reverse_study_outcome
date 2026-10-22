package com.ss.android.lark.storage.file;

import android.content.Context;
import android.net.Uri;
import com.ss.android.lark.storage.f;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.vfs.FileSystemManager;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.vfs.VFSPath;
import com.ss.android.lark.vfs.h;
import com.ss.android.lark.vfs.j;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class FileStorage implements com.ss.android.lark.storage.file.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f440969a;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007J\u001c\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0016¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/storage/file/FileStorage$DefaultRootDirResolver;", "Lcom/ss/android/lark/storage/file/RootDirResolver;", "<init>", "()V", "getRootDirs", "", "Lcom/ss/android/lark/storage/file/IVolume;", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "spaceName", "getRootParentDirs", "getVolumeRootDir", "volumeParentRoot", "unistore_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static class DefaultRootDirResolver implements RootDirResolver {
        public DefaultRootDirResolver() {
        }

        public Map<com.ss.android.lark.storage.file.b, String> getRootParentDirs(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            HashMap<String, String> r101 = f.f440956c;
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            f[] r102 = f.f440964k;
            ArrayList r103 = new ArrayList(r102.length);
            int r104 = r102.length;
            int r105 = 0;
        L3:
            if (r105 >= r104) goto L6;
            f r106 = r102[r105];
            r103.add(TuplesKt.to(r106, r106.a(r100, null)));
            r105 = r105 + 1;
            goto L3
        L6:
            return MapsKt.toMap(r103);
        }

        @Override // com.ss.android.lark.storage.file.RootDirResolver
        public final Map<com.ss.android.lark.storage.file.b, String> getRootDirs(Context r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "spaceName");
            HashMap r102 = new HashMap();
            Iterator<T> r103 = getRootParentDirs(r100).entrySet().iterator();
        L4:
            if (r103.hasNext() == false) goto L6;
            Map.Entry r104 = (Map.Entry) r103.next();
            r102.put(r104.getKey(), getVolumeRootDir((String) r104.getValue(), r101));
            goto L4
        L6:
            return r102;
        }

        @Override // com.ss.android.lark.storage.file.RootDirResolver
        public String getSpaceDirName(Context r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "spaceName");
            return r101;
        }

        public String getVolumeRootDir(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "volumeParentRoot");
            Intrinsics.checkNotNullParameter(r101, "spaceName");
            return r100 + File.separator + r101;
        }

        @Override // com.ss.android.lark.storage.file.RootDirResolver
        public String getRootDir(Context r100, com.ss.android.lark.storage.file.b r101, String r102) {
            return RootDirResolver.a.a(this, r100, r101, r102);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f440970a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f440971b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public RootDirResolver f440972c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public d f440973d;

        public final Context getContext() {
            return this.f440970a;
        }

        public a(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            this.f440970a = r100;
            this.f440972c = new DefaultRootDirResolver();
            this.f440973d = new c();
        }
    }

    public static final class b {
    }

    public static final class c implements d {
        public c() {
        }

        @Override // com.ss.android.lark.storage.file.d
        public final com.ss.android.lark.vfs.c b() {
            return nac.a.f518494a;
        }

        @Override // com.ss.android.lark.storage.file.d
        public final Uri a(Context r100, com.ss.android.lark.storage.file.b r101, String r102, RootDirResolver r103, com.ss.android.lark.storage.d r104) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, ITTVideoEngineEventSource.KEY_VOLUME);
            Intrinsics.checkNotNullParameter(r102, "spaceName");
            Intrinsics.checkNotNullParameter(r103, "rootDirResolver");
            String r105 = r103.getRootDir(r100, r101, r102);
            int r106 = o6c.c.f522230c;
            String r107 = File.separator;
            Intrinsics.checkNotNullParameter(r107, "separator");
            o6c.c r108 = new o6c.c(r107);
            r108.a(r105, false);
            if (r104 == null) goto L5;
            String[] r109 = r104.a();
        L6:
            String[] r110 = r109;
            if (r110 == null) goto L12;
            int r111 = r110.length;
            int r112 = 0;
        L9:
            if (r112 >= r111) goto L12;
            r108.a(r110[r112], false);
            r112 = r112 + 1;
        L12:
            return j.a(r108.toString());
        L5:
            r109 = null;
            goto L6
        }
    }

    static {
    }

    public FileStorage(a r100) {
        this.f440969a = r100;
        FileSystemManager.f(r100.f440973d.b());
    }

    @Override // com.ss.android.lark.storage.file.a
    public final VFSPath a(com.ss.android.lark.storage.file.b r100, com.ss.android.lark.storage.d r110) {
        Intrinsics.checkNotNullParameter(r100, ITTVideoEngineEventSource.KEY_VOLUME);
        a r101 = this.f440969a;
        h r102 = VFSFiles.c(VFSFiles.f444819b);
        d r103 = r101.f440973d;
        Context r104 = r101.getContext();
        String r105 = r101.f440971b;
        if (r105 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("spaceName");
        r105 = null;
    L7:
        return r102.q(r103.a(r104, r100, r105, r101.f440972c, r110));
    }

    public final VFSPath b(f r100, com.ss.android.lark.storage.d r110) {
        Intrinsics.checkNotNullParameter(r100, ITTVideoEngineEventSource.KEY_VOLUME);
        a r101 = this.f440969a;
        h r102 = VFSFiles.c(VFSFiles.f444819b);
        d r103 = r101.f440973d;
        Context r104 = r101.getContext();
        String r105 = r101.f440971b;
        if (r105 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("spaceName");
        r105 = null;
    L7:
        return r102.q(r103.a(r104, r100, r105, r101.f440972c, r110));
    }
}
