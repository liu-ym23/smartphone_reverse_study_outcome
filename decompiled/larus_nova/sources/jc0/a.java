package jc0;

import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.livesdk.chatroom.u;
import com.bytedance.android.livesdk.chatroom.viewmodel.e;
import com.bytedance.android.livesdk.chatroom.viewmodel.f;
import com.bytedance.android.livesdk.chatroom.viewmodel.i;
import com.bytedance.live.datacontext.j;
import kotlin.jvm.internal.Intrinsics;
import vm2.c;

/* JADX INFO: loaded from: classes45.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f498069a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f498070b;

    public static final boolean b(int r100, int r101) {
        if (r100 == 9) goto L5;
    L7:
        return false;
    L5:
        if (r101 != 61) goto L7;
        return true;
    }

    public static final boolean a() {
        u r100 = m.d();
        if (r100 != null) goto L5;
        return false;
    L5:
        j<f> r101 = r100.s();
        if (r101 == null) goto L23;
        f r102 = r101.getValue();
        if (r102 == null) goto L24;
        i r103 = r102.t();
        if (r103 != null) goto L12;
        return false;
    L12:
        if (r103.f114792a != 9) goto L26;
        j<f> r104 = r100.s();
        if (r104 == null) goto L27;
        f r105 = r104.getValue();
        if (r105 == null) goto L28;
        i r106 = r105.t();
        if (r106 != null) goto L20;
        return false;
    L20:
        if (r106.f114793b != 61) goto L30;
        return true;
    L30:
        return false;
    L28:
        return false;
    L27:
        return false;
    L26:
        return false;
    L24:
        return false;
    L23:
        return false;
    }

    public static final boolean c() {
        u r100 = m.d();
        if (r100 != null) goto L5;
        return false;
    L5:
        j<e> r101 = r100.getVideoTalkRoomSubScene();
        if (r101 == null) goto L23;
        e r102 = r101.getValue();
        if (r102 == null) goto L24;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r103 = r102.t();
        if (r103 != null) goto L12;
        return false;
    L12:
        if (r103.f114798a != 8) goto L26;
        j<e> r104 = r100.getVideoTalkRoomSubScene();
        if (r104 == null) goto L27;
        e r105 = r104.getValue();
        if (r105 == null) goto L28;
        com.bytedance.android.livesdk.chatroom.viewmodel.j r106 = r105.t();
        if (r106 != null) goto L20;
        return false;
    L20:
        if (r106.f114800c != 63) goto L30;
        return true;
    L30:
        return false;
    L28:
        return false;
    L27:
        return false;
    L26:
        return false;
    L24:
        return false;
    L23:
        return false;
    }

    public static final boolean d(int r100, int r101) {
        if ((!Intrinsics.areEqual(m.i().isAnchor(), Boolean.TRUE)) == true) goto L5;
    L9:
        return false;
    L5:
        if (b(r100, r101) == false) goto L9;
        if (c.k() == true) goto L9;
        return true;
    }
}
