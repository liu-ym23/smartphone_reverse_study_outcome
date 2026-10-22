package yd8;

import com.larus.bmhome.social.userchat.model.b0;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class d implements td8.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f567349b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final td8.d f567350a;

    public static final class a {
    }

    static {
    }

    public d(td8.d r100) {
        Intrinsics.checkNotNullParameter(r100, "taskContext");
        this.f567350a = r100;
    }

    public final Message c(List<? extends xc8.b> r100) {
        Iterator<T> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L32;
        Object r102 = r101.next();
        Message r103 = ((xc8.b) r102).getMessage();
        boolean r104 = false;
        if (com.larus.bmhome.chat.bean.d.i0(r103) == false) goto L11;
        if (com.larus.bmhome.chat.bean.d.w(r103) == true) goto L11;
    L30:
        if (r104 == false) goto L4;
    L33:
        xc8.b r105 = (xc8.b) r102;
        if (r105 != null) goto L36;
        return null;
    L36:
        return r105.getMessage();
    L11:
        if (com.larus.bmhome.chat.bean.d.T(r103) == true) goto L30;
        if (com.larus.bmhome.chat.bean.d.p0(r103) == true) goto L30;
        if (com.larus.bmhome.chat.bean.d.C0(r103) == true) goto L18;
    L20:
        MessageStatus r106 = r103.getMessageStatus();
        if (r106 != null) goto L23;
    L25:
        boolean r107 = false;
    L26:
        if (r107 == false) goto L28;
    L29:
        r104 = true;
        goto L30
    L28:
        if (b0.f(r103) == false) goto L30;
    L23:
        if (r106.isVisible() != true) goto L25;
        r107 = true;
        goto L26
    L18:
        if (r103.getRegenVisible() == true) goto L20;
    L32:
        r102 = null;
        goto L33
    }

    @Override // td8.c
    public final boolean a(int r100, xc8.b r101, xc8.b r102, List<? extends xc8.b> r103) {
        Intrinsics.checkNotNullParameter(r102, "current");
        Intrinsics.checkNotNullParameter(r103, "input");
        Message r104 = c(r103);
        FLogger r105 = FLogger.f375446a;
        StringBuilder r106 = new StringBuilder("lastMessage = ");
        Boolean r107 = null;
        if (r104 == null) goto L5;
        String r108 = r104.getMessageId();
    L6:
        r106.append(r108);
        r106.append(", initCheckMessageId = ");
        r106.append(f567349b);
        r106.append(", pushContentId = ");
        r106.append(this.f567350a.m());
        r106.append(", contentType = ");
        if (r104 == null) goto L9;
        Integer r109 = Integer.valueOf(r104.getContentType());
    L10:
        r106.append(r109);
        r106.append(", isWelcomeBackMessage = ");
        if (r104 == null) goto L13;
        r107 = Boolean.valueOf(com.larus.bmhome.chat.bean.d.W0(r104));
    L13:
        r106.append(r107);
        r105.i("Pipeline_List_Update_PromptLoading_Task", r106.toString());
        if (r104 != null) goto L17;
        r105.i("Pipeline_List_Update_PromptLoading_Task", "suggest no update because of  lastMessage == null");
        return false;
    L17:
        String r110 = f567349b;
        if (r110 != null) goto L20;
    L23:
        String r111 = this.f567350a.m();
        if (r111 != null) goto L26;
    L29:
        boolean r112 = true;
    L30:
        if (r112 == false) goto L34;
        r105.i("Pipeline_List_Update_PromptLoading_Task", "suggest no update because of  pushContentId is null");
        return false;
    L34:
        if (com.larus.bmhome.chat.bean.d.W0(r104) == true) goto L38;
        r105.i("Pipeline_List_Update_PromptLoading_Task", "suggest no update because of  not welcome back message");
        return false;
    L38:
        if (z2.f365865a.enablePromptLoading() == true) goto L41;
        r105.i("Pipeline_List_Update_PromptLoading_Task", "suggest no update because of  not enablePromptLoading");
        return false;
    L41:
        String r113 = f567349b;
        if (r113 != null) goto L44;
        r113 = r104.getMessageId();
    L44:
        f567349b = r113;
        return true;
    L26:
        if (r111.length() == 0) goto L29;
        r112 = false;
        goto L30
    L20:
        if (Intrinsics.areEqual(r110, r104.getMessageId()) == true) goto L23;
        r105.i("Pipeline_List_Update_PromptLoading_Task", "suggest no update because of  not first check");
        return false;
    L9:
        r109 = null;
        goto L10
    L5:
        r108 = null;
        goto L6
    }

    @Override // td8.c
    public final List<xc8.b> b(int r100, xc8.b r101, xc8.b r102, List<xc8.b> r103) {
        Intrinsics.checkNotNullParameter(r102, "current");
        Intrinsics.checkNotNullParameter(r103, "input");
        Message r104 = c(r103);
        if (r104 == null) goto L7;
        Map<String, String> r105 = r104.getBusinessExt();
        if (r105 == null) goto L7;
        String r106 = r105.put("ui_prompt_type", "loading");
    L7:
        return r103;
    }
}
