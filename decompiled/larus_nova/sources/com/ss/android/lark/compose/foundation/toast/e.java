package com.ss.android.lark.compose.foundation.toast;

import android.os.Handler;
import android.os.Message;
import java.util.LinkedList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class e implements Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f417653a = null;

    static {
        f417653a = new e();
    }

    public e() {
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        Handler r101 = FlowActionToastManager.f417620a;
        int r102 = r100.what;
        LinkedList<FlowActionToastManager.a> r103 = FlowActionToastManager.f417621b;
        if (r103.isEmpty() == true) goto L11;
        final FlowActionToastManager.a r104 = (FlowActionToastManager.a) CollectionsKt.first(r103);
        if (r104.f417624b != r102) goto L12;
        r104.f417623a.a(new FlowActionToastManager$dismissByTag$1(r104));
        return true;
    L12:
        return true;
    L11:
        return true;
    }
}
