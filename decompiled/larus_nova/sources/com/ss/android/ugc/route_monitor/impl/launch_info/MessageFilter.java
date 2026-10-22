package com.ss.android.ugc.route_monitor.impl.launch_info;

import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import com.byted.cast.common.TeaEventTrack;
import com.ss.android.ugc.route_monitor.ComponentType;
import com.ss.android.ugc.route_monitor.utils.u;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes40.dex */
public final class MessageFilter {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [T, com.ss.android.ugc.route_monitor.ComponentType] */
    @JvmStatic
    public static final com.ss.android.ugc.route_monitor.impl.route_in.e a() {
        final Ref.ObjectRef r100 = new Ref.ObjectRef();
        r100.element = ComponentType.UNKNOWN;
        Function1<Message, Boolean> r101 = new MessageFilter$findLaunchComponentMessage$message$1(r100);
        if (Build.VERSION.SDK_INT < 23) goto L5;
        MessageQueue r102 = Looper.getMainLooper().getQueue();
    L7:
        if (r102 == null) goto L13;
        Message r103 = (Message) u.c(r102, "mMessages");
    L9:
        if (r103 == null) goto L14;
        if (r101.invoke(r103).booleanValue() == true) goto L14;
        r103 = (Message) u.c(r103, TeaEventTrack.ACTION_DRAMA_NEXT);
    L14:
        if (r103 != null) goto L16;
        return null;
    L16:
        return new com.ss.android.ugc.route_monitor.impl.route_in.e(r103, (ComponentType) r100.element);
    L13:
        r103 = null;
        goto L14
    L5:
        r102 = (MessageQueue) u.c(Looper.getMainLooper(), "mQueue");
        goto L7
    }

    static {
    }
}
