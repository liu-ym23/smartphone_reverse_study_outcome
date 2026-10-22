package yd8;

import com.larus.bmhome.ability.FloatChatWindowState;
import com.larus.bmhome.social.userchat.model.b0;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import va8.p0;

/* JADX INFO: loaded from: classes25.dex */
public final class b implements td8.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final td8.d f567347a;

    public static final class a {
    }

    static {
    }

    @Override // td8.c
    public final boolean a(int r100, xc8.b r101, xc8.b r102, List<? extends xc8.b> r103) {
        Intrinsics.checkNotNullParameter(r102, "current");
        Intrinsics.checkNotNullParameter(r103, "input");
        return true;
    }

    public b(td8.d r100) {
        Intrinsics.checkNotNullParameter(r100, "taskContext");
        this.f567347a = r100;
    }

    @Override // td8.c
    public final List<xc8.b> b(int r100, xc8.b r101, xc8.b r110, List<xc8.b> r111) {
        Intrinsics.checkNotNullParameter(r110, "current");
        Intrinsics.checkNotNullParameter(r111, "input");
        p0 r102 = this.f567347a.f();
        FloatChatWindowState r103 = this.f567347a.h();
        if (r103 != null) goto L6;
        return r111;
    L6:
        if (r102 != null) goto L8;
    L10:
        boolean r104 = false;
    L11:
        if (r104 == true) goto L13;
    L37:
        return r111;
    L13:
        if (r103 == FloatChatWindowState.Expanded) goto L37;
        Set<String> r105 = r102.f553972a;
        ArrayList r106 = new ArrayList();
        Iterator<T> r107 = r111.iterator();
    L17:
        if (r107.hasNext() == false) goto L35;
        Object r108 = r107.next();
        Message r109 = ((xc8.b) r108).getMessage();
        Integer r112 = b0.c(r109);
        if (r112 != null) goto L22;
    L24:
        Set<String> r113 = r105;
        if (CollectionsKt.contains(r113, r109.getMessageId()) == false) goto L27;
    L32:
        boolean r114 = true;
    L33:
        if (r114 == false) goto L17;
        r106.add(r108);
        goto L17
    L27:
        if (CollectionsKt.contains(r113, r109.getLocalMessageId()) == true) goto L32;
        if (CollectionsKt.contains(r113, r109.getReplyId()) == true) goto L32;
        r114 = false;
        goto L33
    L22:
        if (r112.intValue() != 0) goto L24;
    L35:
        List<xc8.b> r115 = CollectionsKt.toMutableList(r106);
        FLogger.f375446a.i("PreviewRoundMessageFilterTask", "filter preview round, before=" + r111.size() + ", after=" + r115.size() + ", queryIds=" + r102.f553972a);
        return r115;
    L8:
        if ((!r102.f553972a.isEmpty()) != true) goto L10;
        r104 = true;
        goto L11
    }
}
