package ucc;

import androidx.collection.LruCache;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.api.s;
import com.ss.android.lark.passportc.dwarf.UserScope;
import f0c.h;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@UserScope
public final class c extends c0c.c implements a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f549700b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LruCache<String, Integer> f549701c;

    @Inject
    public c(m r100) {
        Intrinsics.checkNotNullParameter(r100, "passport");
        super(r100);
        this.f549700b = "VideoProgressCacheImpl";
        this.f549701c = new LruCache(50);
        s.a(this);
    }

    @Override // ucc.a
    public final int V3(String r100) {
        Integer r101 = null;
        if (r100 == null) goto L7;
        Integer r102 = this.f549701c.get(r100);
        if (r102 == null) goto L7;
        int r103 = r102.intValue();
        Log.d(this.f549700b, "[getProgress]key:" + r100 + " progress:" + r103);
        r101 = r102;
    L7:
        if (r101 != null) goto L11;
        return 0;
    L11:
        return r101.intValue();
    }

    @Override // c0c.c
    public final void d(h r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        Intrinsics.checkNotNullParameter(r100, "state");
        Log.i(this.f549700b, "destroy state: " + r100.f475035a);
        this.f549701c.evictAll();
        s.b(this);
    }

    @Override // ucc.a
    public final void oa(String r100) {
        if (r100 == null) goto L7;
        Integer r101 = this.f549701c.remove(r100);
        if (r101 == null) goto L8;
        int r102 = r101.intValue();
        Log.i(this.f549700b, "[removeProgress]key:" + r100 + " progress:" + r102);
        return;
    L8:
        return;
    }

    @Override // ucc.a
    public final void b7(String r100, int r101) {
        if (r101 > 0) goto L4;
        return;
    L4:
        if (r100 == null) goto L7;
        this.f549701c.put(r100, Integer.valueOf(r101));
        Log.i(this.f549700b, "[saveProgress]video key:" + r100 + " current progress:" + r101);
        return;
    }
}
