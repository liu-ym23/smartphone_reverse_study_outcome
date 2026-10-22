package k4b;

import com.ss.android.lark.biz.im.api.ThreadTopic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a implements Function1<f5b.b, Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ThreadTopic f501768a;

    public a(ThreadTopic r100) {
        Intrinsics.checkNotNullParameter(r100, "threadTopic");
        this.f501768a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(f5b.b r100) {
        f5b.b r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "chatMessage");
        String r102 = null;
        if ((r101 instanceof y6b.c) == false) goto L5;
        y6b.c r103 = (y6b.c) r101;
    L6:
        if (r103 == null) goto L9;
        r102 = r103.Q1;
    L9:
        return Boolean.valueOf(Intrinsics.areEqual(r102, this.f501768a.getId()));
    L5:
        r103 = null;
        goto L6
    }
}
