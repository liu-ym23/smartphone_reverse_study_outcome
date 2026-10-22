package v81;

import com.bytedance.android.live.room.incentiveinfo.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import u81.f;

/* JADX INFO: loaded from: classes47.dex */
public abstract class a implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<f.a> f553649a;

    @Override // u81.f
    public final int a() {
        return ((ArrayList) this.f553649a).size();
    }

    public a() {
        this.f553649a = new ArrayList();
    }

    @Override // u81.f
    public final boolean b(f.a r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        Iterator r101 = ((ArrayList) this.f553649a).iterator();
        if (r101.hasNext() == true) goto L5;
        return false;
    L5:
        if (Intrinsics.areEqual((f.a) r101.next(), r100) == false) goto L10;
        return true;
    L10:
        return false;
    }

    @Override // u81.f
    public final boolean c(f.a r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        List<f.a> r101 = this.f553649a;
        if (r101 != null) goto L5;
    L13:
        return false;
    L5:
        if (((ArrayList) r101).isEmpty() == true) goto L13;
        Iterator r102 = ((ArrayList) this.f553649a).iterator();
    L9:
        if (r102.hasNext() == false) goto L13;
        if (Intrinsics.areEqual((f.a) r102.next(), r100) == false) goto L9;
        r102.remove();
        return true;
    }

    public final boolean d(e r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        List<f.a> r101 = this.f553649a;
        boolean r102 = false;
        if (r101 != null) goto L5;
        return false;
    L5:
        Iterator r103 = ((ArrayList) r101).iterator();
    L7:
        if (r103.hasNext() == false) goto L11;
        if (Intrinsics.areEqual((f.a) r103.next(), r100) == false) goto L7;
        r102 = true;
    L11:
        if (r102 == true) goto L14;
        ((ArrayList) this.f553649a).add(r100);
    L14:
        return !r102;
    }
}
