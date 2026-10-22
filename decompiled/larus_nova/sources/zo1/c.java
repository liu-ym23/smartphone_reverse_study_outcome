package zo1;

import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.container.ListActionEnum;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public class c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<T> f573100a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<g<T>> f573101b;

    public final String a() {
        StringBuilder r100 = new StringBuilder("[");
        Iterator<T> r101 = this.f573100a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r100.append(String.valueOf(r101.next()));
        r100.append(", ");
        goto L4
    L6:
        r100.append("]");
        return r100.toString();
    }

    public c(ArrayList<T> r100, ArrayList<g<T>> r101) {
        Intrinsics.checkNotNullParameter(r100, "dataList");
        Intrinsics.checkNotNullParameter(r101, "listObserver");
        this.f573100a = r100;
        this.f573101b = r101;
    }

    public final boolean b(T r100, ListActionEnum r101) {
        Intrinsics.checkNotNullParameter(r101, "action");
        ArrayList<T> r102 = this.f573100a;
        int r103 = b.f573099a[r101.ordinal()];
        if (r103 != 1) goto L5;
        r102.remove(r100);
        r102.add(r100);
    L14:
        boolean r104 = true;
    L15:
        if (r104 == false) goto L21;
        Iterator<T> r105 = this.f573101b.iterator();
    L18:
        if (r105.hasNext() == false) goto L20;
        ((g) r105.next()).e(r100, r101);
        goto L18
    L20:
        return true;
    L21:
        return false;
    L5:
        if (r103 != 2) goto L7;
        r104 = r102.remove(r100);
        goto L15
    L7:
        if (r103 == 3) goto L10;
    L8:
        r104 = false;
        goto L15
    L10:
        if (r102.remove(r100) == false) goto L8;
        r102.add(r100);
        goto L14
    }
}
