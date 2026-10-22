package vd8;

import com.bytedance.keva.Keva;
import com.larus.bmhome.social.userchat.model.b0;
import com.larus.bmhome.social.userchat.model.z;
import com.larus.home.impl.sdk.FlowAppletServiceImpl;
import com.larus.im.bean.message.Message;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes25.dex */
public final class g implements td8.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy<Keva> f554218b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final td8.d f554219a;

    public static final class a {
    }

    static {
        f554218b = LazyKt.lazy(new f());
    }

    public static nf8.d c() {
        return new nf8.d(b0.j(new Message(null, null, null, 0, 0, null, 0, false, null, null, null, null, null, null, null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -65, 31, null), 8));
    }

    public g(td8.d r100) {
        Intrinsics.checkNotNullParameter(r100, "taskContextTask");
        this.f554219a = r100;
    }

    @Override // td8.c
    public final boolean a(int r100, xc8.b r101, xc8.b r102, List<? extends xc8.b> r103) {
        Intrinsics.checkNotNullParameter(r102, "current");
        Intrinsics.checkNotNullParameter(r103, "input");
        if ((this.f554219a.l() instanceof z) == false) goto L5;
        return false;
    L5:
        if (this.f554219a.c() == false) goto L7;
        return false;
    L7:
        if ((this.f554219a.l() instanceof com.larus.bmhome.social.userchat.model.b) == true) goto L36;
        wc9.e r104 = this.f554219a.g();
        Lazy r105 = ic8.n.f489237a;
        if (r104 == null) goto L15;
        String r106 = r104.f559198a;
        if (r106 == null) goto L15;
        if (StringsKt.contains$default(r106, "doc_manager", false, 2, null) != true) goto L15;
        boolean r107 = true;
    L16:
        if (r107 == true) goto L27;
        if (r104 == null) goto L23;
        String r108 = r104.f559198a;
        if (r108 == null) goto L23;
        if (StringsKt.contains$default(r108, "doc_detail", false, 2, null) != true) goto L23;
        boolean r109 = true;
    L24:
        if (r109 == true) goto L27;
        boolean r110 = false;
    L28:
        if (r110 == true) goto L37;
        IFlowSdkDepend r111 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r111 == null) goto L32;
        r111.C0();
        hc9.d r112 = hc9.d.f484554a;
    L32:
        return true;
    L37:
        return false;
    L23:
        r109 = false;
    L27:
        r110 = true;
    L15:
        r107 = false;
        goto L16
    L36:
        return false;
    }

    @Override // td8.c
    public final List<xc8.b> b(int r510, xc8.b r511, xc8.b r512, List<xc8.b> r513) {
        Intrinsics.checkNotNullParameter(r512, "current");
        Intrinsics.checkNotNullParameter(r513, "input");
        FLogger r100 = FLogger.f375446a;
        r100.i("Pipeline_List_BigAvatarTask", "BigAvatarTask process, input size = " + r513.size());
        wc9.e r101 = this.f554219a.g();
        IFlowSdkDepend r102 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        boolean r103 = false;
        if (r102 == null) goto L9;
        FlowAppletServiceImpl r104 = r102.g0();
        if (r104 == null) goto L9;
        if (r104.m(r101) != true) goto L9;
        boolean r105 = true;
    L11:
        if (ic8.n.D(r101) == false) goto L17;
        if (r105 == false) goto L17;
        if (this.f554219a.e() == false) goto L35;
        r100.i("Pipeline_List_BigAvatarTask", "mini app debug sub cvs is load completed, add big avatar");
        r513.add(c());
    L35:
        return r513;
    L17:
        if (ic8.n.D(r101) == false) goto L25;
        z2 r106 = z2.f365865a;
        r106.w3();
        if (this.f554219a.e() == false) goto L35;
        if (r513.isEmpty() == false) goto L35;
        if (r106.enableSubSmallAvatar() == false) goto L35;
        r100.i("Pipeline_List_BigAvatarTask", "sub cvs is load completed, input empty, add small avatar");
        r513.add(new nf8.j(b0.j(new Message(null, null, null, 0, 0, null, 0, false, null, null, null, null, null, null, null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -65, 31, null), 9)));
        goto L35
    L25:
        boolean r107 = this.f554219a.e();
        int r108 = r513.size();
        if (r107 == true) goto L34;
        if (1 <= r108) goto L29;
    L31:
        if (r103 == true) goto L34;
        r100.i("Pipeline_List_BigAvatarTask", "cvs is load completed or input size(" + r513.size() + ") >= 8, not add big avatar");
        goto L35
    L29:
        if (r108 >= 8) goto L31;
        r103 = true;
    L34:
        r100.i("Pipeline_List_BigAvatarTask", "cvs is load completed or input size < 8, add big avatar, isLoadCompleted = " + r107 + ", inputSize = " + r108);
        r513.add(c());
    L9:
        r105 = false;
        goto L11
    }
}
