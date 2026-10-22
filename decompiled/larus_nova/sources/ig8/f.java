package ig8;

import com.larus.bmhome.chat.layout.item.i;
import com.larus.im.bean.message.Message;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class f extends bd8.b {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f489750l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final wg8.f f489751m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final e f489752n;

    public f() {
        super(false, -1);
        this.f489750l = LazyKt.lazy(new c(this));
        this.f489751m = new wg8.f();
        this.f489752n = new e(this);
    }

    @Override // bd8.b
    public final void w(final Message r100, int r101, final ec8.b r102) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Intrinsics.checkNotNullParameter(r100, "message");
        wg8.f r103 = this.f489751m;
        r103.f559607a = this.f18694f;
        i r104 = this.f18692d;
        if (r104 == null) goto L6;
        r104.setOnLongClickListener(new d(this, r102, r100));
        return;
    }
}
