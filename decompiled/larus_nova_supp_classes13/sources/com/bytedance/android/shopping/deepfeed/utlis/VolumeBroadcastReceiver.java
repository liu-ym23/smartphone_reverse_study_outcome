package com.bytedance.android.shopping.deepfeed.utlis;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class VolumeBroadcastReceiver extends BroadcastReceiver {
    public final LinkedList<WeakReference<i>> a;
    public final Lazy b;

    public static final class a {
    }

    static {
    }

    public VolumeBroadcastReceiver(final Context r2) {
        this.a = new LinkedList();
        this.b = LazyKt.lazy(new VolumeBroadcastReceiver$mAudioManager$2(r2));
    }

    public final void a(Function1<? super WeakReference<i>, Boolean> r3) {
        Iterator<WeakReference<i>> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        if (((Boolean) r3.invoke(r0.next())).booleanValue() == false) goto L4;
        r0.remove();
        goto L4
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r2, Intent r3) {
        if (r3 == null) goto L23;
        String r4 = r3.getAction();
        if (r4 != null) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(r4, "android.media.VOLUME_CHANGED_ACTION") == false) goto L25;
        final int r0 = -1;
        if (r3.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1) != 3) goto L26;
        AudioManager r5 = (AudioManager) this.b.getValue();     // Catch: Exception -> L13
        if (r5 == null) goto L18;
        r0 = r5.getStreamVolume(3);     // Catch: Exception -> L13
    L18:
        if (r0 < 0) goto L27;
        a(new VolumeBroadcastReceiver$onReceive$1$1(r0));
        return;
    L27:
        return;
    L13:
        e = move-exception;
        String r6 = e.getMessage();
        if (r6 != null) goto L17;
        r6 = "";
    L17:
        ECExceptionMonitor.c(r6);
        goto L18
    L26:
        return;
    L25:
        return;
    }
}
