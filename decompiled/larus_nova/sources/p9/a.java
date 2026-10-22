package p9;

import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.Collection;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f528280a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Collection<h> f528281b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Collection<d> f528282c = null;

    public a() {
    }

    static {
        f528280a = new a();
        f528281b = new CopyOnWriteArrayList();
        f528282c = new CopyOnWriteArrayList();
    }

    @Override // p9.e
    public final void T0(com.bytedance.android.annie.debug.c r100) {
        Intrinsics.checkNotNullParameter(r100, ShortVideoSegments.KEY_PROP_PROVIDER);
        ((CopyOnWriteArrayList) f528282c).add(r100);
    }

    @Override // p9.e
    public final void b0(h r100) {
        Intrinsics.checkNotNullParameter(r100, ShortVideoSegments.KEY_PROP_PROVIDER);
        ((CopyOnWriteArrayList) f528281b).add(r100);
    }
}
