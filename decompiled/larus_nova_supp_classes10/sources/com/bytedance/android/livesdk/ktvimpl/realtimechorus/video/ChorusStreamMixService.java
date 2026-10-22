package com.bytedance.android.livesdk.ktvimpl.realtimechorus.video;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IStreamUrlExtra;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.live.livelink.kmp.api.core.mixer.MixStreamType;
import com.bytedance.live.livelink.kmp.api.core.mixer.TaskMixerConfig;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class ChorusStreamMixService {
    public final f a;
    public String b;
    public final WeakReference<j1> c;

    public static final class a {
    }

    static {
    }

    public final ei6.a a() {
        j1 r0 = this.c.get();
        if (r0 == null) goto L9;
        cg6.a r1 = r0.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r1 == null) goto L9;
        hg6.g r2 = r1.getRtcManager();
        if (r2 == null) goto L9;
        return r2.V0();
    L9:
        return null;
    }

    public ChorusStreamMixService(WeakReference<j1> r2) {
        Intrinsics.checkNotNullParameter(r2, "scopeProviderRef");
        this.c = r2;
        this.a = new f();
        this.b = BDLocationException.ERROR_TIMEOUT;
    }

    public final void b(String r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "taskId");
        Intrinsics.checkNotNullParameter(r7, "streamUrl");
        b.b("VideoChorusStreamMixService", "startPushChorusCDNStream taskId " + r6 + " streamUrl : " + r7);
        com.bytedance.live.datacontext.m r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r0 == null) goto L9;
        IRoom r1 = (IRoom) r0.getValue();
        if (r1 == null) goto L9;
        IStreamUrlExtra r2 = r1.getStreamUrlExtra();
        if (r2 == null) goto L9;
        r2.getWidth();
    L9:
        IInteractService r3 = jc1.k.f(IInteractService.class);
        String r4 = null;
        if (r3 == null) goto L12;
        com.bytedance.android.live.liveinteract.plantform.base.i r5 = r3.getLinkUserInfoCenter();
    L13:
        if (r5 == null) goto L28;
        List r8 = r5.getOnlineUserList();
        if (r8 == null) goto L28;
        Iterator r9 = r8.iterator();
    L18:
        if (r9.hasNext() == false) goto L26;
        Object r10 = r9.next();
        IBaseUser r11 = ((ILinkPlayerInfoBridge) r10).getUser();
        if (r11 == null) goto L22;
        String r12 = r11.getIdString();
    L24:
        if (Intrinsics.areEqual(r12, je0.d.a()) == false) goto L18;
    L27:
        ILinkPlayerInfoBridge r13 = (ILinkPlayerInfoBridge) r10;
    L29:
        f r14 = this.a;
        if (r13 == null) goto L33;
        String r15 = r13.getInteractId();
        if (r15 == null) goto L33;
    L34:
        r14.getClass();
        Intrinsics.checkNotNullParameter(r15, "<set-?>");
        ei6.a r16 = a();
        if (r16 == null) goto L39;
        fi6.a r17 = r16.g();
        if (r17 == null) goto L39;
        f r18 = this.a;
        r18.getClass();
        Intrinsics.checkNotNullParameter(r17, "config");
        r18.a = r17;
    L39:
        this.b = r6;
        TaskMixerConfig r19 = new TaskMixerConfig();
        r19.a(MixStreamType.SERVER_MIX);
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        r19.c = r6;
        r19.g = r7;
        com.bytedance.live.datacontext.m r20 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r20 == null) goto L44;
        IRoom r21 = (IRoom) r20.getValue();
        if (r21 == null) goto L44;
        String r22 = r21.getIdStr();
    L45:
        r19.i = r22;
        ei6.a r23 = a();
        if (r23 == null) goto L50;
        fi6.a r24 = r23.g();
        if (r24 == null) goto L50;
        ti6.h r25 = r24.T;
    L51:
        r19.f = r25;
        r19.j = new ChorusStreamMixService$startPushChorusCDNStream$2(this);
        r19.b(TaskMixerConfig.TaskType.EXTRA);
        ei6.a r26 = a();
        if (r26 == null) goto L56;
        si6.b r27 = r26.b();
        if (r27 == null) goto L56;
        r4 = r27.m();
    L56:
        String r28 = String.valueOf(r4);
        Intrinsics.checkNotNullParameter(r28, "<set-?>");
        r19.d = r28;
        ei6.a r29 = a();
        if (r29 == null) goto L61;
        ti6.d r30 = r29.p();
        if (r30 == null) goto L61;
        r30.l(r19);
    L61:
        ei6.a r31 = a();
        if (r31 == null) goto L70;
        ti6.d r32 = r31.p();
        if (r32 == null) goto L71;
        r32.d(r6, "VideoChorusStreamMixService startPushChorusCDNStream");
        return;
    L71:
        return;
    L70:
        return;
    L50:
        r25 = null;
    L44:
        r22 = null;
    L33:
        r15 = BDLocationException.ERROR_TIMEOUT;
        goto L34
    L22:
        r12 = null;
        goto L24
    L26:
        r10 = null;
    L28:
        r13 = null;
        goto L29
    L12:
        r5 = null;
        goto L13
    }
}
