package ud8;

import com.larus.bmhome.social.userchat.model.b0;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import td8.d;

/* JADX INFO: loaded from: classes25.dex */
public final class c implements td8.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f549751a;

    public static final class a {
    }

    static {
    }

    public c(d r100) {
        Intrinsics.checkNotNullParameter(r100, "taskContext");
        this.f549751a = r100;
    }

    @Override // td8.c
    public final boolean a(int r100, xc8.b r101, xc8.b r102, List<? extends xc8.b> r103) {
        Intrinsics.checkNotNullParameter(r102, "current");
        Intrinsics.checkNotNullParameter(r103, "input");
        return this.f549751a.k();
    }

    @Override // td8.c
    public final List<xc8.b> b(int r100, xc8.b r101, xc8.b r102, List<xc8.b> r103) {
        Intrinsics.checkNotNullParameter(r102, "current");
        Intrinsics.checkNotNullParameter(r103, "input");
        FLogger.f375446a.i("Pipeline_List_ImmerseCutTask", "start ImmerseCutTask, start input size is " + r103.size());
        Iterator<xc8.b> r104 = r103.iterator();
        int r105 = 0;
    L4:
        if (r104.hasNext() == false) goto L14;
        xc8.b r106 = r104.next();
        if (com.larus.bmhome.chat.bean.d.G0(r106.getMessage()) == true) goto L8;
    L10:
        boolean r107 = false;
    L11:
        if (r107 == true) goto L15;
        r105 = r105 + 1;
    L15:
        if (r105 < 0) goto L18;
        List<xc8.b> r108 = r103.subList(0, r105 + 1);
        FLogger.f375446a.i("Pipeline_List_ImmerseCutTask", "end ImmerseCutTask, end result size is " + r108.size() + ", lastSelfMessageIndex is " + r105);
        return r108;
    L18:
        FLogger.f375446a.i("Pipeline_List_ImmerseCutTask", "end ImmerseCutTask, no any immerse cut");
        return r103;
    L8:
        if (b0.f(r106.getMessage()) == true) goto L10;
        r107 = true;
        goto L11
    L14:
        r105 = -1;
        goto L15
    }
}
