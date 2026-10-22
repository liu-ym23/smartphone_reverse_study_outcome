package d28;

import android.content.Context;
import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.larksuite.framework.utils.z;
import com.ss.android.lark.utils.statistics.PerfLog;
import dagger.hilt.android.qualifiers.ApplicationContext;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Singleton
public final class b implements com.larksuite.framework.http.v2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f466547a;

    @Override // com.larksuite.framework.http.v2.a
    public final c a() {
        return this.f466547a;
    }

    @Inject
    public b(@ApplicationContext Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f466547a = new c(r100, new SetCookieCache(), new d(r100, a.b(r100, "CookiePersistence_" + z.b(r100)), a.b(r100, "CookiePersistence")));
    }
}
