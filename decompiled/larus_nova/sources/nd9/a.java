package nd9;

import com.larus.im.service.audio.DataType;
import com.larus.im.service.audio.l;
import com.larus.im.service.audio.x;
import com.tencent.open.SocialConstants;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DataType f518807a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final vt7.b<x> f518808b;

    public a(DataType r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        this.f518807a = r100;
        this.f518808b = new vt7.b();
    }

    public final void a(x r100) {
        Intrinsics.checkNotNullParameter(r100, SocialConstants.PARAM_RECEIVER);
        if (r100.getType() != this.f518807a) goto L5;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (com.larus.im.internal.delegate.c.f348197a.isDebug() == false) goto L17;
        if ((r100 instanceof com.larus.im.internal.audio.g) == true) goto L17;
        r100 = new com.larus.im.internal.audio.g(r100);
    L17:
        if (this.f518808b.contains(r100) == false) goto L19;
        return;
    L19:
        this.f518808b.add(r100);
        return;
    L5:
        if (com.larus.im.internal.delegate.c.f348197a.isDebug() == true) goto L8;
        return;
    L8:
        throw new IllegalArgumentException("[Add] receiver(" + r100.getName() + ") type(" + r100.getType() + ") must be equals to " + this.f518807a + '.');
    }

    public final void b(l r100) {
        Intrinsics.checkNotNullParameter(r100, "frame");
        if (this.f518808b.isEmpty() == false) goto L5;
        return;
    L5:
        Iterator<x> r101 = this.f518808b.iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        r101.next().a(r100);
        goto L7
    }

    public final void c(x r100) {
        Intrinsics.checkNotNullParameter(r100, SocialConstants.PARAM_RECEIVER);
        if (r100.getType() != this.f518807a) goto L5;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (com.larus.im.internal.delegate.c.f348197a.isDebug() == false) goto L17;
        if ((r100 instanceof com.larus.im.internal.audio.g) == true) goto L17;
        r100 = new com.larus.im.internal.audio.g(r100);
    L17:
        if (this.f518808b.contains(r100) == true) goto L19;
        return;
    L19:
        this.f518808b.remove(r100);
        return;
    L5:
        if (com.larus.im.internal.delegate.c.f348197a.isDebug() == true) goto L8;
        return;
    L8:
        throw new IllegalArgumentException("[Remove] receiver(" + r100.getName() + ") type(" + r100.getType() + ") must be equals to " + this.f518807a + '.');
    }
}
