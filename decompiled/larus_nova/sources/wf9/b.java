package wf9;

import com.flow.kmp.common.util.i;
import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f559489a = 0;

    static {
    }

    public static String a() {
        return i.a();
    }

    public static boolean b(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.getMessageStatusLocal() != 24) goto L5;
        return true;
    L5:
        return false;
    }
}
