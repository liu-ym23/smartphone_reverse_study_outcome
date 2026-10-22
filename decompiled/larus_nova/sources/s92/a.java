package s92;

import aa2.w;
import com.bytedance.android.live.base.model.message.l4;
import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.m;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f541056a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f541057b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f541058c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final IRoom f541059d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final m f541060e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f541061f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f541062g;

    /* JADX INFO: renamed from: s92.a$a, reason: collision with other inner class name */
    public static final class C7587a {
    }

    static {
    }

    public final boolean a() {
        if (this.f541062g != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean b(l4 r110, m r111, int r112) {
        boolean r100 = false;
        if (this.f541061f == true) goto L5;
    L7:
        boolean r113 = false;
    L9:
        if (a() == false) goto L50;
        w r114 = (w) r111;
        if (r114.a() == false) goto L21;
        IRoomAuthStatus r101 = this.f541059d.getRoomAuthStatus();
        if (r101 == null) goto L21;
        if (r101.isAnchorColdMessageTiled() != true) goto L21;
        m0 r102 = r110.getBaseMessage();
        if (r102 == null) goto L21;
        if (r102.getAnchorFoldTypeV2() != 3) goto L21;
    L23:
        if (r114.a() == true) goto L34;
        m0 r115 = r110.getBaseMessage();
        if (r115 != null) goto L27;
    L28:
        m0 r116 = r110.getBaseMessage();
        if (r116 == null) goto L34;
        if (r116.getAnchorFoldTypeV2() != 3) goto L34;
    L32:
        r100 = true;
        goto L34
    L27:
        if (r115.getAnchorFoldTypeV2() == 1) goto L32;
    L34:
        if (r114.b() == false) goto L53;
        m0 r117 = r110.getBaseMessage();
        if (r117 != null) goto L38;
    L39:
        m0 r118 = r110.getBaseMessage();
        if (r118 != null) goto L42;
    L43:
        m0 r119 = r110.getBaseMessage();
        if (r119 == null) goto L53;
        if (r119.getAnchorFoldTypeV2() != 3) goto L53;
        return true;
    L42:
        if (r118.getAnchorFoldTypeV2() != 2) goto L43;
        return true;
    L38:
        if (r117.getAnchorFoldTypeV2() != 1) goto L39;
        return true;
    L53:
        return r100;
    L21:
        r100 = r113;
        goto L23
    L50:
        return r113;
    L5:
        if (r112 != 2) goto L7;
        r113 = true;
        goto L9
    }

    public a(IRoom r100, w r101, boolean r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "room");
        Intrinsics.checkNotNullParameter(r101, "widget");
        this.f541059d = r100;
        this.f541060e = r101;
        this.f541061f = r102;
        this.f541062g = r103;
        this.f541058c = new b(a());
    }
}
