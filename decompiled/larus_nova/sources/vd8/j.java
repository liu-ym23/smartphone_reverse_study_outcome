package vd8;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.chat.bean.WcbRenderStatus;
import com.larus.bmhome.social.userchat.model.b0;
import com.larus.bmhome.social.userchat.model.z;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.TextContent;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class j implements td8.c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f554225c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final td8.d f554226a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f554227b;

    public static final class a {
        public static cg8.c a(Message r510, String r610, String r611, boolean r612) {
            Intrinsics.checkNotNullParameter(r510, "current");
            Intrinsics.checkNotNullParameter(r611, "from");
            if (com.larus.bmhome.chat.bean.d.W0(r510) == false) goto L5;
            String r100 = com.larus.bmhome.chat.bean.d.x(r510).getWcbTitle();
        L7:
            if (com.larus.bmhome.chat.bean.d.Y0(r510) == false) goto L9;
            String r101 = (String) com.larus.bmhome.chat.bean.d.x(r510).get("z_lottery_title");
        L10:
            boolean r102 = true;
            if (r101 != null) goto L13;
        L16:
            boolean r103 = true;
        L17:
            if (r103 == true) goto L20;
            String r104 = r101;
        L29:
            String r210 = com.larus.im.internal.core.message.converter.a.a(new TextContent(r104, null, null, null, null, null, null, null, 254, null), TextContent.Companion.serializer());
            cg8.c r105 = new cg8.c(b0.j(new Message(r510.getConversationId(), null, null, 0, 21, null, 1001, false, null, r210, null, null, null, null, null, r510.getMessageId() + "-clear-context", r510.getLocalIndex() + 1, 0, false, r610, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -623186, 31, null), 3));
            FLogger r106 = FLogger.f375446a;
            StringBuilder r107 = new StringBuilder("createClearContextMessage, current:");
            int r108 = com.larus.bmhome.chat.component.list.pipeline.pre_dependent.d.f301202c;
            r107.append(com.larus.bmhome.chat.component.list.pipeline.pre_dependent.d.a.a(r510));
            r107.append(", sectionId:");
            r107.append(r610);
            r107.append(", from:");
            r107.append(r611);
            r106.i("Pipeline_List_ClearContextTask", r107.toString());
            return r105;
        L20:
            if (r100.length() > 0) goto L23;
            r102 = false;
        L23:
            if (r102 == true) goto L28;
            if (r612 == false) goto L27;
            r100 = AppHost.f326268a.getApplication().getString(R.string.larus_Welcome_back_for_you);
            Intrinsics.checkNotNull(r100);
            goto L28
        L27:
            r100 = AppHost.f326268a.getApplication().getString(R.string.larus_start_new_topic);
            Intrinsics.checkNotNull(r100);
        L28:
            r104 = r100;
            goto L29
        L13:
            if (r101.length() == 0) goto L16;
            r103 = false;
            goto L17
        L9:
            r101 = null;
            goto L10
        L5:
            r100 = "";
            goto L7
        }
    }

    static {
    }

    public j(td8.d r100) {
        Intrinsics.checkNotNullParameter(r100, "taskContextTask");
        this.f554226a = r100;
        this.f554227b = LazyKt.lazy(new i(this));
    }

    @Override // td8.c
    public final boolean a(int r100, xc8.b r101, xc8.b r110, List<? extends xc8.b> r111) {
        Intrinsics.checkNotNullParameter(r110, "current");
        Intrinsics.checkNotNullParameter(r111, "input");
        if (AppHost.f326268a.isPlugin() == false) goto L9;
        if (td8.c.a.a((e) this.f554227b.getValue(), 0, null, null, r111, 7) == false) goto L9;
        return ((e) this.f554227b.getValue()).a(r100, r101, r110, r111);
    L9:
        if ((this.f554226a.l() instanceof z) == false) goto L11;
    L13:
        return false;
    L11:
        if ((this.f554226a.l() instanceof com.larus.bmhome.social.userchat.model.b) == true) goto L13;
        return true;
    }

    @Override // td8.c
    public final List<xc8.b> b(int r100, xc8.b r101, xc8.b r102, List<xc8.b> r110) {
        Intrinsics.checkNotNullParameter(r102, "current");
        Intrinsics.checkNotNullParameter(r110, "input");
        if (AppHost.f326268a.isPlugin() == true) goto L5;
    L8:
        xc8.b r103 = (xc8.b) CollectionsKt.firstOrNull(r110);
        String r104 = null;
        if (r103 == null) goto L11;
        Message r105 = r103.getMessage();
    L12:
        FLogger r106 = FLogger.f375446a;
        StringBuilder r107 = new StringBuilder("start ClearContextTask, start input size is ");
        r107.append(r110.size());
        r107.append(", lastMessage:");
        if (r105 == null) goto L15;
        int r108 = com.larus.bmhome.chat.component.list.pipeline.pre_dependent.d.f301202c;
        r104 = com.larus.bmhome.chat.component.list.pipeline.pre_dependent.d.a.a(r105);
    L15:
        r107.append(r104);
        r106.i("Pipeline_List_ClearContextTask", r107.toString());
        if (r105 != null) goto L18;
    L20:
        boolean r109 = false;
    L22:
        if (r109 == true) goto L24;
        if (r105 == null) goto L55;
        String r111 = this.f554226a.p();
        if (Intrinsics.areEqual(r105.getSectionId(), r111) == false) goto L39;
    L43:
        boolean r112 = false;
    L44:
        if (r112 == false) goto L55;
        if (com.larus.bmhome.chat.bean.d.j0(r105) == true) goto L50;
        if (com.larus.bmhome.chat.bean.d.G0(r105) == false) goto L55;
    L50:
        if (com.larus.bmhome.chat.bean.d.Q0(r105) == true) goto L55;
        if (com.larus.bmhome.chat.bean.d.x(r105).getLocalSubCoCoMsg() == true) goto L55;
        r106.i("Pipeline_List_ClearContextTask", "clearContextDivider added for message id: " + r105.getMessageId() + '_' + r105.getLocalMessageId() + ", index: " + r105.getLocalIndex() + ",sectionId:" + this.f554226a.p() + "->" + r105.getSectionId());
        ListProtector.add(r110, 0, a.a(r105, this.f554226a.p(), "last_msg", com.larus.bmhome.chat.bean.d.X(r105)));
        goto L55
    L39:
        if (o0.d(r105.getSectionId()) == false) goto L43;
        if (o0.d(r111) == false) goto L43;
        r112 = true;
    L55:
        if (r110.size() >= 2) goto L57;
    L68:
        r106.i("Pipeline_List_ClearContextTask", "end ClearContextTask, end input size is " + r110.size());
        return r110;
    L57:
        if (com.larus.bmhome.chat.bean.d.Y(((xc8.b) ListProtector.get(r110, 0)).getMessage()) == false) goto L68;
        if (((xc8.b) ListProtector.get(r110, 1)).getMessage().getContentType() != 2) goto L66;
        if (com.larus.bmhome.chat.bean.d.k0(((xc8.b) ListProtector.get(r110, 1)).getMessage()) == true) goto L66;
        if (((xc8.b) ListProtector.get(r110, 1)).getMessage().getLocalIndex() != Long.MAX_VALUE) goto L66;
        r106.i("Pipeline_List_ClearContextTask", "input[1] removed");
        ListProtector.remove(r110, 1);
    L66:
        if (com.larus.bmhome.chat.bean.d.Y(((xc8.b) ListProtector.get(r110, 1)).getMessage()) == false) goto L68;
        r106.i("Pipeline_List_ClearContextTask", "input[1] removed again");
        ListProtector.remove(r110, 1);
        goto L68
    L24:
        if (Intrinsics.areEqual(com.larus.bmhome.chat.bean.d.x(r105).get("wcb_render_status"), WcbRenderStatus.DEPRECATED) == true) goto L55;
        if (com.larus.bmhome.chat.bean.d.W(r105) == true) goto L55;
        Integer r113 = com.larus.bmhome.chat.bean.d.x(r105).getNextPulseType();
        if (r113 != null) goto L31;
    L34:
        r106.i("Pipeline_List_ClearContextTask", "clearContextDivider added for wcb id: " + r105.getMessageId() + ", index: " + r105.getLocalIndex());
        ListProtector.add(r110, 1, a.a(r105, this.f554226a.p(), "last_msg_show_topic", com.larus.bmhome.chat.bean.d.X(r105)));
        goto L55
    L31:
        if (r113.intValue() != 1) goto L34;
        if (com.larus.bmhome.chat.bean.d.x(r105).getWcbTitleStyle() == 1) goto L55;
    L18:
        if (com.larus.bmhome.chat.bean.d.x(r105).isWelcomeBackMessageHidden() != true) goto L20;
        r109 = true;
        goto L22
    L11:
        r105 = null;
        goto L12
    L5:
        if (td8.c.a.a((e) this.f554227b.getValue(), 0, null, null, r110, 7) == false) goto L8;
        return td8.c.a.b((e) this.f554227b.getValue(), 0, r110, 7);
    }
}
