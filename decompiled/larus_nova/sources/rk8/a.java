package rk8;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.chat.deepresearch.view.j;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a extends jc8.a {
    @Override // jc8.a
    public final int l() {
        int r100 = j.f302403a;
        return j.f302438r0;
    }

    @Override // jc8.a
    public final boolean e(jc8.a r100) {
        if ((r100 instanceof a) == true) goto L5;
        return false;
    L5:
        a r101 = (a) r100;
        if (this.f498145a.hashCode() == r101.f498145a.hashCode()) goto L8;
        return false;
    L8:
        List<jc8.a> r102 = i();
        List<jc8.a> r103 = r101.i();
        if (r102.size() != r103.size()) goto L32;
        Iterable r104 = CollectionsKt.getIndices(r102);
        if ((r104 instanceof Collection) == true) goto L13;
    L15:
        Iterator r105 = r104.iterator();
    L17:
        if (r105.hasNext() == false) goto L14;
        int r106 = ((IntIterator) r105).nextInt();
        if (((jc8.a) ListProtector.get(r102, r106)).f498145a.hashCode() != ((jc8.a) ListProtector.get(r103, r106)).f498145a.hashCode()) goto L21;
        boolean r107 = true;
    L22:
        if (r107 == true) goto L17;
        boolean r108 = false;
    L24:
        if (r108 == false) goto L33;
        return true;
    L33:
        return false;
    L21:
        r107 = false;
    L14:
        r108 = true;
        goto L24
    L13:
        if (((Collection) r104).isEmpty() == false) goto L15;
    L32:
        return false;
    }

    public a(Message r100, Block r101) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Intrinsics.checkNotNullParameter(r101, "block");
        super(r100, r101);
    }
}
