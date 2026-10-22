package x4c;

import android.content.Context;
import androidx.room.Room;
import com.ss.android.lark.security.compliance.infra.storage.lru.CacheDatabase;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f562496a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f562497b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, f> f562498c;

    public g(Context r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "name");
        this.f562496a = r102;
        this.f562497b = ((CacheDatabase) Room.databaseBuilder(r100.getApplicationContext(), CacheDatabase.class, r101 + DBDefinition.DATABASE_SUBPROCESS_SUFFIX_NAME).build()).c();
        this.f562498c = new HashMap();
    }
}
