package com.bytedance.ee.android.file.picker.lib.v2.util.content;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.bytedance.supervisor.token.Token;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.c1;

/* JADX INFO: loaded from: classes15.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Handler f206173a = null;

    static {
        f206173a = new Handler(Looper.getMainLooper());
    }

    public static final boolean a() {
        return ProcessLifecycleOwner.Companion.get().getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED);
    }

    public static c1 b(c1 r100, Function1 r101) {
        CoroutineDispatcher r102 = Dispatchers.getIO();
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r102, "dispatcher");
        Intrinsics.checkNotNullParameter(r101, "mapper");
        return new c1(new FlowContentResolver$mapToList$$inlined$transform$1(r100, null, r102, r101));
    }

    public static c1 c(ContentResolver r110, Uri r111, String[] r112, String r113, String[] r114, String r115, Token r116, int r117) {
        if ((r117 & 2) == 0) goto L5;
        String[] r100 = null;
    L7:
        if ((r117 & 4) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r117 & 8) == 0) goto L13;
        String[] r102 = null;
    L15:
        if ((r117 & 16) == 0) goto L17;
        String r103 = null;
    L18:
        Intrinsics.checkNotNullParameter(r110, "<this>");
        Intrinsics.checkNotNullParameter(r111, "uri");
        Intrinsics.checkNotNullParameter(r116, "token");
        return new c1(new FlowContentResolver$observeQuery$1(new a(r110, r111, r100, r101, r102, r103, r116), r111, r110, false, null));
    L17:
        r103 = r115;
        goto L18
    L13:
        r102 = r114;
        goto L15
    L9:
        r101 = r113;
        goto L11
    L5:
        r100 = r112;
        goto L7
    }
}
