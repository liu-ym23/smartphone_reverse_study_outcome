package xd8;

import com.larus.bmhome.social.userchat.model.b0;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.z2;
import com.larus.platform.service.n0;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import ic8.n;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class a implements td8.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final td8.d f563285a;

    /* JADX INFO: renamed from: xd8.a$a, reason: collision with other inner class name */
    public static final class C8217a {
    }

    static {
    }

    public a(td8.d r100) {
        Intrinsics.checkNotNullParameter(r100, "taskContext");
        this.f563285a = r100;
    }

    @Override // td8.c
    public final boolean a(int r100, xc8.b r101, xc8.b r102, List<? extends xc8.b> r103) {
        Intrinsics.checkNotNullParameter(r102, "current");
        Intrinsics.checkNotNullParameter(r103, "input");
        Message r104 = r102.getMessage();
        IFlowSdkDepend r105 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r105 == null) goto L9;
        z2 r106 = r105.O();
        if (r106 == null) goto L9;
        if (r106.a(r104) != true) goto L9;
        boolean r107 = true;
    L11:
        if (r107 == false) goto L15;
        FLogger.f375446a.i("Pipeline_List_FilterTask", "filter message by outer filter type=" + r104.getContentType());
        return true;
    L15:
        if (com.larus.bmhome.chat.bean.d.i0(r104) == false) goto L20;
        if (com.larus.bmhome.chat.bean.d.w(r104) == true) goto L20;
    L39:
        boolean r108 = false;
    L41:
        if (r108 == true) goto L44;
        FLogger.f375446a.i("Pipeline_List_FilterTask", "hide invisible message, messageId = " + r104.getMessageId() + ", localMessageId = " + r104.getLocalMessageId());
        return true;
    L44:
        Intrinsics.checkNotNullParameter(r104, "<this>");
        if (com.larus.bmhome.chat.bean.d.z0(r104) == true) goto L47;
    L49:
        boolean r109 = false;
    L50:
        if (r109 == false) goto L69;
        if (n0.f365775a.b() == false) goto L56;
        if (com.larus.bmhome.chat.bean.d.k0(r104) == false) goto L56;
    L66:
        FLogger.f375446a.i("Pipeline_List_FilterTask", "hide firstMet message, messageId = " + r104.getMessageId() + ", localMessageId = " + r104.getLocalMessageId());
        return true;
    L56:
        if (com.larus.bmhome.chat.bean.d.Y0(r104) == true) goto L69;
        if (IAIChatUgcAIGCService.f365905a.y0() == false) goto L69;
        wc9.e r110 = this.f563285a.g();
        if (r110 != null) goto L62;
    L64:
        boolean r111 = false;
    L65:
        if (r111 == true) goto L69;
    L62:
        if (n.v(r110) == true) goto L64;
        r111 = true;
    L69:
        if (com.larus.bmhome.chat.bean.d.W0(r104) == false) goto L81;
        if (com.larus.bmhome.chat.bean.d.x(r104).isWelcomeBackMessageHidden() == false) goto L81;
        if (com.larus.bmhome.chat.bean.d.O0(r104) == true) goto L76;
        FLogger.f375446a.i("Pipeline_List_FilterTask", "hide wcb message, messageId = " + r104.getMessageId() + ", localMessageId = " + r104.getLocalMessageId());
        return true;
    L76:
        if (r100 <= 0) goto L79;
        FLogger.f375446a.i("Pipeline_List_FilterTask", "hide history wcb message, messageId = " + r104.getMessageId() + ", localMessageId = " + r104.getLocalMessageId());
        return true;
    L79:
        FLogger.f375446a.d("Pipeline_List_FilterTask", "not hide wcb message, localMessageId = " + r104.getLocalMessageId());
    L81:
        if (com.larus.bmhome.chat.bean.d.m0(r104) == false) goto L84;
        FLogger.f375446a.i("Pipeline_List_FilterTask", "hide illegal asr loading, messageId = " + r104.getMessageId() + ", localMessageId = " + r104.getLocalMessageId());
        return true;
    L84:
        return false;
    L47:
        if (r104.getContentType() != 2) goto L49;
        r109 = true;
    L20:
        if (com.larus.bmhome.chat.bean.d.T(r104) == true) goto L39;
        if (com.larus.bmhome.chat.bean.d.p0(r104) == true) goto L39;
        if (com.larus.bmhome.chat.bean.d.C0(r104) == true) goto L27;
    L29:
        MessageStatus r112 = r104.getMessageStatus();
        if (r112 != null) goto L32;
    L34:
        boolean r113 = false;
    L35:
        if (r113 == false) goto L37;
    L38:
        r108 = true;
        goto L41
    L37:
        if (b0.f(r104) == false) goto L39;
    L32:
        if (r112.isVisible() != true) goto L34;
        r113 = true;
        goto L35
    L27:
        if (r104.getRegenVisible() == true) goto L29;
    L9:
        r107 = false;
        goto L11
    }

    @Override // td8.c
    public final List<xc8.b> b(int r100, xc8.b r101, xc8.b r102, List<xc8.b> r103) {
        Intrinsics.checkNotNullParameter(r102, "current");
        Intrinsics.checkNotNullParameter(r103, "input");
        return new ArrayList();
    }
}
