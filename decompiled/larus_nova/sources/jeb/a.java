package jeb;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.dwarf.UserScope;
import java.util.ArrayList;
import java.util.Iterator;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@UserScope
public final class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f498836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<e> f498837b;

    /* JADX INFO: renamed from: jeb.a$a, reason: collision with other inner class name */
    public static final class C6428a {
    }

    static {
    }

    @Override // jeb.d
    public final void Xa() {
        this.f498836a = null;
    }

    @Override // jeb.d
    public final String q3() {
        return this.f498836a;
    }

    @Inject
    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        this.f498837b = new ArrayList();
    }

    @Override // jeb.d
    public final void g5(e r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        if (this.f498837b.contains(r100) == true) goto L6;
        this.f498837b.add(r100);
        return;
    }

    @Override // jeb.d
    public final void k4(String r100) {
        Intrinsics.checkNotNullParameter(r100, "feedId");
        this.f498836a = r100;
        Iterator<e> r101 = this.f498837b.iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        e r102 = r101.next();
        if (r102 != null) goto L7;
        Log.w("FeedClickDataCache", "IFeedClickDataCacheChangedListener is null");
        goto L4
    L7:
        r102.a(this.f498836a);
        goto L4
    }

    @Override // jeb.d
    public final void od(e r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        if (this.f498837b.contains(r100) == false) goto L6;
        this.f498837b.remove(r100);
        return;
    }
}
