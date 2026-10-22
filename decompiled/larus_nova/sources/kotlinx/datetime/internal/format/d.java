package kotlinx.datetime.internal.format;

import com.ss.ttvideoengine.model.SubInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class d<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<q<T>> f505284a;

    public d() {
        this.f505284a = new ArrayList();
    }

    public final void a(n<? super T> r100) {
        Intrinsics.checkNotNullParameter(r100, SubInfo.KEY_FORMAT);
        if ((r100 instanceof q) == false) goto L6;
        ((ArrayList) this.f505284a).add(r100);
        return;
    L6:
        if ((r100 instanceof h) == false) goto L13;
        Iterator<T> r101 = ((h) r100).f505290a.iterator();
    L9:
        if (r101.hasNext() == false) goto L15;
        q r102 = (q) r101.next();
        ((ArrayList) this.f505284a).add(r102);
        goto L9
    L15:
        return;
    L13:
        throw new NoWhenBranchMatchedException();
    }
}
