package vd8;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.chat.component.list.ChatListComponentViewModel;
import com.larus.bmhome.social.userchat.model.b0;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.TextContent;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class d implements td8.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final td8.d f554214a;

    public static final class a {
    }

    static {
    }

    public d(td8.d r100) {
        Intrinsics.checkNotNullParameter(r100, "taskContextTask");
        this.f554214a = r100;
    }

    @Override // td8.c
    public final boolean a(int r100, xc8.b r101, xc8.b r102, List<? extends xc8.b> r103) {
        Intrinsics.checkNotNullParameter(r102, "current");
        Intrinsics.checkNotNullParameter(r103, "input");
        return Intrinsics.areEqual(this.f554214a.extraInfo().get(ChatListComponentViewModel.EXTRA_SHOW_AI_GENERATED_FOOTER), Boolean.TRUE);
    }

    @Override // td8.c
    public final List<xc8.b> b(int r610, xc8.b r611, xc8.b r612, List<xc8.b> r613) {
        Intrinsics.checkNotNullParameter(r612, "current");
        Intrinsics.checkNotNullParameter(r613, "input");
        Iterator<T> r100 = r613.iterator();
    L3:
        boolean r101 = true;
        if (r100.hasNext() == false) goto L8;
        Object r102 = r100.next();
        if ((!b0.f(((xc8.b) r102).getMessage())) == false) goto L3;
    L9:
        xc8.b r103 = (xc8.b) r102;
        if (r103 == null) goto L30;
        Message r104 = r103.getMessage();
        if (r104 == null) goto L30;
        if (com.larus.bmhome.chat.bean.d.G0(r104) == false) goto L17;
    L27:
        r101 = false;
    L28:
        if (r101 == false) goto L30;
        FLogger.f375446a.i("Pipeline_List_AiDisclaimerTask", "add ai disclaimer for message id: " + r104.getMessageId());
        String r210 = com.larus.im.internal.core.message.converter.a.a(new TextContent(AppHost.f326268a.getApplication().getString(R.string.larus_ai_content_disclaimer_cn), null, null, null, null, null, null, null, 254, null), TextContent.Companion.serializer());
        ListProtector.add(r613, 0, new cg8.c(b0.j(new Message(r104.getConversationId(), null, null, 0, 21, null, 1001, false, null, r210, null, null, null, null, null, r104.getMessageId() + "-ai-disclaimer", r104.getLocalIndex() - 1, 0, false, r104.getSectionId(), null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -623186, 31, null), 13)));
        goto L30
    L17:
        if (com.larus.bmhome.chat.bean.d.W0(r104) == true) goto L27;
        if (com.larus.bmhome.chat.bean.d.k0(r104) == true) goto L27;
        if (com.larus.bmhome.chat.bean.d.z0(r104) == true) goto L27;
        if (com.larus.bmhome.chat.bean.d.j0(r104) == false) goto L27;
        if (com.larus.bmhome.chat.bean.d.Q0(r104) == true) goto L27;
    L30:
        return r613;
    L8:
        r102 = null;
        goto L9
    }
}
