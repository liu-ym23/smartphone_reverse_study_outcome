package ef8;

import com.larus.bmhome.chat.layout.holder.menu.item.MenuActionType;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class c implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<ot8.a> f472542a;

    /* JADX WARN: Multi-variable type inference failed */
    public c(List<? extends ot8.a> r100) {
        Intrinsics.checkNotNullParameter(r100, "menuItems");
        this.f472542a = r100;
    }

    @Override // ef8.a
    public final boolean a(int r100) {
        if (this.f472542a.isEmpty() == false) goto L5;
        return false;
    L5:
        List<ot8.a> r101 = this.f472542a;
        if ((r101 instanceof Collection) == true) goto L8;
    L10:
        Iterator<T> r102 = r101.iterator();
    L12:
        if (r102.hasNext() == false) goto L9;
        if (((ot8.a) r102.next()).getId() == r100) goto L16;
        boolean r103 = true;
    L17:
        if (r103 == true) goto L12;
        boolean r104 = false;
    L19:
        if (r104 == false) goto L47;
        List<ot8.a> r105 = this.f472542a;
        if ((r105 instanceof Collection) == true) goto L23;
    L25:
        Iterator<T> r106 = r105.iterator();
    L27:
        if (r106.hasNext() == false) goto L24;
        if (((ot8.a) r106.next()).getId() != MenuActionType.MORE.getType()) goto L31;
        boolean r107 = true;
    L32:
        if (r107 == false) goto L27;
        boolean r108 = true;
    L34:
        if (r108 == false) goto L48;
        return true;
    L48:
        return false;
    L31:
        r107 = false;
    L24:
        r108 = false;
        goto L34
    L23:
        if (r105.isEmpty() == false) goto L25;
    L47:
        return false;
    L16:
        r103 = false;
    L9:
        r104 = true;
        goto L19
    L8:
        if (r101.isEmpty() == false) goto L10;
        goto L9
    }
}
