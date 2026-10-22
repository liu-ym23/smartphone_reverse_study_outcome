package com.ss.android.lark.player.player;

import com.ss.android.lark.log.Log;
import com.ss.ttvideoengine.SeekCompletionListener;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class j implements SeekCompletionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<s> f438675a;

    public static final class a {
    }

    static {
    }

    public j(s r100) {
        Intrinsics.checkNotNullParameter(r100, "player");
        this.f438675a = new WeakReference(r100);
    }

    @Override // com.ss.ttvideoengine.SeekCompletionListener
    public final void onCompletion(boolean r100) {
        Log.i("LarkSeekCompletionListener", "EVENT_CODE_SEEK_COMPLETE");
        s r101 = this.f438675a.get();
        if (r101 == null) goto L5;
        r101.a(-99014, null);
    L5:
        s r102 = this.f438675a.get();
        if (r102 != null) goto L8;
        return;
    L8:
        if (r102.c() != r102.d()) goto L10;
        boolean r103 = true;
    L11:
        if (r103 == true) goto L15;
        r102.h();
        return;
    L15:
        return;
    L10:
        r103 = false;
        goto L11
    }
}
