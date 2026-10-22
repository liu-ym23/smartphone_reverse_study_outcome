package jx4;

import android.content.Context;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f500825a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f500826b;

    public e(Context r100) {
        Intrinsics.checkNotNullParameter("debug_config", "name");
        com.ss.android.lark.storage.kv.repo.a r101 = ay4.b.b("debug_config", true, ay4.b.a("debug_config"));
        Intrinsics.checkNotNullParameter(r101, "repo");
        new ArrayList();
        this.f500825a = r100;
        Intrinsics.checkNotNullParameter("offline_auto_download_full_res", "key");
        this.f500826b = r101.getBoolean("offline_auto_download_full_res", true);
    }
}
