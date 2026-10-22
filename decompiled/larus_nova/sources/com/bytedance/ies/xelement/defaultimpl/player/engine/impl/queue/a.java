package com.bytedance.ies.xelement.defaultimpl.player.engine.impl.queue;

import com.bytedance.ies.xelement.defaultimpl.player.engine.api.queue.PlayMode;
import com.bytedance.ies.xelement.defaultimpl.player.engine.api.queue.c;
import com.bytedance.ies.xelement.defaultimpl.player.engine.api.queue.f;
import com.bytedance.ies.xelement.defaultimpl.player.engine.api.queue.h;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final PlayMode f249958e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final com.bytedance.ies.xelement.defaultimpl.player.engine.api.queue.a f249959f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f249960a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h f249961b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PlayMode f249962c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.bytedance.ies.xelement.defaultimpl.player.engine.api.queue.a f249963d;

    /* JADX INFO: renamed from: com.bytedance.ies.xelement.defaultimpl.player.engine.impl.queue.a$a, reason: collision with other inner class name */
    public static final class C3561a {
    }

    static {
        PlayMode r100 = PlayMode.SEQUENCE;
        f249958e = r100;
        f249959f = s76.b.a(r100);
    }

    public a(AudioQueueListenerDispatcher r100) {
        Intrinsics.checkNotNullParameter(r100, "mListener");
        this.f249960a = r100;
        this.f249962c = f249958e;
        this.f249963d = f249959f;
    }

    public final void a(f r100) {
        h r101 = this.f249961b;
        if (r101 == null) goto L21;
        int r102 = -1;
        if (r101 == null) goto L20;
        List<f> r103 = r101.b();
        if (r103 == null) goto L20;
        Iterator<f> r104 = r103.iterator();
        int r105 = 0;
    L11:
        if (r104.hasNext() == false) goto L20;
        String r106 = r104.next().getId();
        if (r100 == null) goto L15;
        String r107 = r100.getId();
    L17:
        if (Intrinsics.areEqual(r106, r107) == true) goto L18;
        r105 = r105 + 1;
        goto L11
    L18:
        r102 = r105;
        goto L20
    L15:
        r107 = null;
    L20:
        r101.a(r102);
    L21:
        this.f249960a.m(r100);
    }
}
