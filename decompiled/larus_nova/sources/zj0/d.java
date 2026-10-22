package zj0;

import com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.CommonMultiLinkWindowManager;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.m;
import hh1.t0;
import tf0.o;

/* JADX INFO: loaded from: classes46.dex */
public abstract class d implements t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f572392a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f572393b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f572394c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f572395d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f572396e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Class<? extends o> f572397f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f572398g;

    public static final class a extends d {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final a f572399h = null;

        public a() {
            super(0, 0, 0, 0, 0, "EmptyWindow", zj0.a.class);
        }

        static {
            f572399h = new a();
        }
    }

    public static final class b extends d {
        public b(int r110, int r111, int r112, int r113, int r114, int r115) {
            if ((r115 & 1) == 0) goto L5;
            int r100 = 0;
        L7:
            if ((r115 & 2) == 0) goto L9;
            int r101 = 0;
        L11:
            if ((r115 & 4) == 0) goto L13;
            int r102 = 1;
        L15:
            if ((r115 & 8) == 0) goto L17;
            int r103 = 0;
        L19:
            if ((r115 & 16) == 0) goto L21;
            int r104 = 0;
        L22:
            super(r100, r101, r102, r103, "MultiLinkCommonWindow", CommonMultiLinkWindowManager.class, r104);
            return;
        L21:
            r104 = r114;
            goto L22
        L17:
            r103 = r113;
            goto L19
        L13:
            r102 = r112;
            goto L15
        L9:
            r101 = r111;
            goto L11
        L5:
            r100 = r110;
            goto L7
        }
    }

    public final boolean b() {
        int r100 = this.f572393b;
        if (r100 != 3) goto L5;
    L23:
        return true;
    L5:
        if (r100 == 6) goto L23;
        if (r100 == 11) goto L23;
        if (r100 == 12) goto L23;
        if (r100 == 3) goto L23;
        if (r100 == 109) goto L23;
        if (r100 == 110) goto L23;
        if (r100 == 111) goto L23;
        if (r100 == 112) goto L23;
        if (r100 == 43) goto L23;
        return false;
    }

    public final boolean c() {
        if (this.f572392a != 16) goto L11;
        m<IRoom> r100 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r100 == null) goto L11;
        IRoom r101 = r100.getValue();
        if (r101 == null) goto L11;
        if (r101.isLiveTypeAudio() == true) goto L11;
        return true;
    L11:
        return false;
    }

    @Override // hh1.t0
    public final boolean isDynamic() {
        int r100 = this.f572393b;
        if (r100 != 7) goto L5;
    L12:
        return true;
    L5:
        if (r100 == 2) goto L12;
        if (r100 == 15) goto L12;
        if (r100 == 113) goto L12;
        return false;
    }

    public String toString() {
        return this.f572396e + "(scene=" + this.f572392a + ",uiLayout=" + this.f572393b + ",seiVer=" + this.f572394c + ')';
    }

    @Override // hh1.t0
    public final int a() {
        return this.f572393b;
    }

    public d(int r100, int r101, int r102, int r103, String r104, Class r105, int r106) {
        this.f572392a = r100;
        this.f572393b = r101;
        this.f572394c = r102;
        this.f572395d = r103;
        this.f572396e = r104;
        this.f572397f = r105;
        this.f572398g = r106;
    }

    public /* synthetic */ d(int r100, int r110, int r111, int r112, int r113, String r114, Class r115) {
        this(r100, r110, r111, r112, r114, r115, 0);
    }
}
