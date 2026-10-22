package xd8;

import com.larus.bmhome.social.userchat.model.b0;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.TextContent;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class d implements td8.c {

    public static final class a {
    }

    static {
    }

    public d() {
    }

    @Override // td8.c
    public final boolean a(int r100, xc8.b r101, xc8.b r110, List<? extends xc8.b> r111) {
        Intrinsics.checkNotNullParameter(r110, "current");
        Intrinsics.checkNotNullParameter(r111, "input");
        Message r102 = r110.getMessage();
        String r112 = null;
        if (r101 == null) goto L5;
        Message r103 = r101.getMessage();
    L6:
        boolean r113 = false;
        if (r102 != null) goto L9;
    L11:
        boolean r104 = false;
    L12:
        if (r104 == false) goto L30;
        if (r103 != null) goto L15;
    L17:
        boolean r105 = false;
    L18:
        if (r105 == false) goto L30;
        if (r102.getContentType() != 9) goto L24;
        if (r103.getContentType() != 1) goto L24;
    L28:
        if (Math.abs(r102.getCreateTime() - r103.getCreateTime()) >= TimeUnit.SECONDS.toMillis(30)) goto L30;
        r113 = true;
    L24:
        if (r102.getContentType() != 1) goto L30;
        if (r103.getContentType() != 9) goto L30;
    L15:
        if (com.larus.bmhome.chat.bean.d.W0(r103) != true) goto L17;
        r105 = true;
    L30:
        if (r113 == false) goto L71;
        FLogger r106 = FLogger.f375446a;
        StringBuilder r107 = new StringBuilder("RecommendDivider match: pre={msgId=");
        if (r103 == null) goto L34;
        String r108 = r103.getMessageId();
    L35:
        r107.append(r108);
        r107.append(", localMsgId=");
        if (r103 == null) goto L38;
        String r109 = r103.getLocalMessageId();
    L39:
        r107.append(r109);
        r107.append(", ct=");
        if (r103 == null) goto L42;
        Integer r114 = Integer.valueOf(r103.getContentType());
    L43:
        r107.append(r114);
        r107.append(", create=");
        if (r103 == null) goto L46;
        Long r115 = Long.valueOf(r103.getCreateTime());
    L47:
        r107.append(r115);
        r107.append(", section=");
        if (r103 == null) goto L50;
        String r116 = r103.getSectionId();
    L51:
        r107.append(r116);
        r107.append("} current={msgId=");
        if (r102 == null) goto L54;
        String r117 = r102.getMessageId();
    L55:
        r107.append(r117);
        r107.append(", localMsgId=");
        if (r102 == null) goto L58;
        String r118 = r102.getLocalMessageId();
    L59:
        r107.append(r118);
        r107.append(", ct=");
        if (r102 == null) goto L62;
        Integer r119 = Integer.valueOf(r102.getContentType());
    L63:
        r107.append(r119);
        r107.append(", create=");
        if (r102 == null) goto L66;
        Long r120 = Long.valueOf(r102.getCreateTime());
    L67:
        r107.append(r120);
        r107.append(", section=");
        if (r102 == null) goto L70;
        r112 = r102.getSectionId();
    L70:
        r107.append(r112);
        r107.append('}');
        r106.i("Pipeline_List_RecommendDividerTask", r107.toString());
        goto L71
    L66:
        r120 = null;
        goto L67
    L62:
        r119 = null;
        goto L63
    L58:
        r118 = null;
        goto L59
    L54:
        r117 = null;
        goto L55
    L50:
        r116 = null;
        goto L51
    L46:
        r115 = null;
        goto L47
    L42:
        r114 = null;
        goto L43
    L38:
        r109 = null;
        goto L39
    L34:
        r108 = null;
    L71:
        return r113;
    L9:
        if (com.larus.bmhome.chat.bean.d.W0(r102) != true) goto L11;
        r104 = true;
        goto L12
    L5:
        r103 = null;
        goto L6
    }

    @Override // td8.c
    public final List<xc8.b> b(int r410, xc8.b r510, xc8.b r511, List<xc8.b> r512) {
        Intrinsics.checkNotNullParameter(r511, "current");
        Intrinsics.checkNotNullParameter(r512, "input");
        FLogger r100 = FLogger.f375446a;
        StringBuilder r101 = new StringBuilder("RecommendDivider added in pre: messageId is >>>");
        Integer r102 = null;
        if (r510 == null) goto L7;
        Message r103 = r510.getMessage();
        if (r103 == null) goto L7;
        String r104 = r103.getMessageId();
    L8:
        r101.append(r104);
        r101.append(", contentType is >>> ");
        if (r510 == null) goto L13;
        Message r105 = r510.getMessage();
        if (r105 == null) goto L13;
        r102 = Integer.valueOf(r105.getContentType());
    L13:
        r101.append(r102);
        r101.append(" and current: messageId is >>>");
        r101.append(r511.getMessage().getMessageId());
        r101.append(", contentType is >>> ");
        r101.append(r511.getMessage().getContentType());
        r100.i("Pipeline_List_RecommendDividerTask", r101.toString());
        String r210 = r511.getMessage().getSectionId();
        Message r106 = r511.getMessage();
        String r110 = com.larus.im.internal.core.message.converter.a.a(new TextContent(AppHost.f326268a.getApplication().getString(R.string.larus_Welcome_back_for_you), null, null, null, null, null, null, null, 254, null), TextContent.Companion.serializer());
        return CollectionsKt.mutableListOf(new xc8.b[]{r511, new cg8.c(b0.j(new Message(r106.getConversationId(), null, null, 0, 21, null, 1001, false, null, r110, null, null, null, null, null, r106.getMessageId() + "-welcome-back", r106.getLocalIndex() - 1, 0, false, r210, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -623186, 31, null), 4))});
    L7:
        r104 = null;
        goto L8
    }
}
