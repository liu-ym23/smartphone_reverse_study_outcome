package com.bytedance.ee.lark.infra.file.vfs;

import android.content.Context;
import com.ss.android.lark.storage.d;
import com.ss.android.lark.storage.f;
import com.ss.android.lark.storage.file.FileStorage;
import com.ss.android.lark.storage.file.RootDirResolver;
import com.ss.android.lark.storage.file.b;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.File;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J$\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH\u0016J\u0018\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/lark/infra/file/vfs/AppRootDirResolver;", "Lcom/ss/android/lark/storage/file/RootDirResolver;", "larkUserSpace", "Lcom/ss/android/lark/storage/file/FileStorage;", "<init>", "(Lcom/ss/android/lark/storage/file/FileStorage;)V", "getRootDirs", "", "Lcom/ss/android/lark/storage/file/IVolume;", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "spaceName", "formatRootDir", "parentRoot", "appName", "Companion", "eco-infra_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppRootDirResolver implements RootDirResolver {
    public static final a Companion = null;
    public static final String DOMAIN_OPEN_PLATFORM = "open_platform";
    private final FileStorage larkUserSpace;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public AppRootDirResolver(FileStorage r100) {
        Intrinsics.checkNotNullParameter(r100, "larkUserSpace");
        this.larkUserSpace = r100;
    }

    public static String a(String r100, String r101) {
        return r100 + File.separator + r101;
    }

    @Override // com.ss.android.lark.storage.file.RootDirResolver
    public Map<b, String> getRootDirs(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "spaceName");
        String r102 = this.larkUserSpace.b(f.f440957d, new d(new String[]{"open_platform"})).getRealPath();
        String r103 = this.larkUserSpace.b(f.f440961h, new d(new String[]{"open_platform"})).getRealPath();
        com.bytedance.ee.lark.infra.file.vfs.a.C3476a r104 = com.bytedance.ee.lark.infra.file.vfs.a.f242796c;
        StringBuilder r105 = new StringBuilder();
        r105.append(r101);
        String r106 = File.separator;
        r105.append(r106);
        r105.append(r104.f242799a);
        com.bytedance.ee.lark.infra.file.vfs.a.C3476a r107 = com.bytedance.ee.lark.infra.file.vfs.a.f242797d;
        com.bytedance.ee.lark.infra.file.vfs.a.C3476a r108 = com.bytedance.ee.lark.infra.file.vfs.a.f242798e;
        return MapsKt.mapOf(new Pair[]{TuplesKt.to(com.bytedance.ee.lark.infra.file.vfs.a.f242794a, a(r102, r101)), TuplesKt.to(com.bytedance.ee.lark.infra.file.vfs.a.f242795b, a(r103, r101)), TuplesKt.to(r104, a(r103, r105.toString())), TuplesKt.to(r107, a(r103, r101 + r106 + r107.f242799a)), TuplesKt.to(r108, a(r103, r101 + r106 + r108.f242799a))});
    }

    @Override // com.ss.android.lark.storage.file.RootDirResolver
    public String getSpaceDirName(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "spaceName");
        return r101;
    }

    @Override // com.ss.android.lark.storage.file.RootDirResolver
    public String getRootDir(Context r100, b r101, String r102) {
        return RootDirResolver.a.a(this, r100, r101, r102);
    }
}
