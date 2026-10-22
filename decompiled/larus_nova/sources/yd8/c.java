package yd8;

import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class c implements td8.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final td8.d f567348a;

    public static final class a {
    }

    static {
    }

    public c(td8.d r100) {
        Intrinsics.checkNotNullParameter(r100, "taskContext");
        this.f567348a = r100;
    }

    @Override // td8.c
    public final boolean a(int r100, xc8.b r101, xc8.b r102, List<? extends xc8.b> r103) {
        Intrinsics.checkNotNullParameter(r102, "current");
        Intrinsics.checkNotNullParameter(r103, "input");
        if (this.f567348a.d() == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // td8.c
    public final List<xc8.b> b(int r100, xc8.b r101, xc8.b r102, List<xc8.b> r103) {
        Intrinsics.checkNotNullParameter(r102, "current");
        Intrinsics.checkNotNullParameter(r103, "input");
        int r104 = this.f567348a.d();
        ArrayList r105 = new ArrayList();
        Iterator<T> r106 = r103.iterator();
    L4:
        if (r106.hasNext() == false) goto L26;
        Object r107 = r106.next();
        Message r108 = ((xc8.b) r107).getMessage();
        boolean r109 = false;
        if (com.larus.bmhome.chat.bean.d.O0(r108) == true) goto L9;
    L24:
        if (r109 == true) goto L4;
        r105.add(r107);
        goto L4
    L9:
        if (r104 == 0) goto L23;
        if (r104 != 1) goto L12;
        r109 = com.larus.bmhome.chat.bean.d.k0(r108);
        goto L24
    L12:
        if (r104 != 2) goto L14;
        r109 = com.larus.bmhome.chat.bean.d.W0(r108);
        goto L24
    L14:
        if (r104 != 3) goto L24;
        if (com.larus.bmhome.chat.bean.d.k0(r108) == true) goto L23;
        if (com.larus.bmhome.chat.bean.d.W0(r108) == false) goto L24;
    L23:
        r109 = true;
        goto L24
    L26:
        List<xc8.b> r110 = CollectionsKt.toMutableList(r105);
        FLogger.f375446a.i("PromptFilterTask", "filter prompt, type=" + r104 + ", before=" + r103.size() + ", after=" + r110.size());
        return r110;
    }
}
