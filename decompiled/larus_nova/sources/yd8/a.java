package yd8;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.ability.FloatChatWindowState;
import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.api.e0;
import com.larus.bmhome.social.userchat.model.b0;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.larus.utils.logger.FLogger;
import com.tencent.connect.common.Constants;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes25.dex */
public final class a implements td8.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final td8.d f567346a;

    /* JADX INFO: renamed from: yd8.a$a, reason: collision with other inner class name */
    public static final class C8331a {
    }

    static {
    }

    @Override // td8.c
    public final boolean a(int r100, xc8.b r101, xc8.b r102, List<? extends xc8.b> r103) {
        Intrinsics.checkNotNullParameter(r102, "current");
        Intrinsics.checkNotNullParameter(r103, "input");
        return true;
    }

    public a(td8.d r100) {
        Intrinsics.checkNotNullParameter(r100, "taskContext");
        this.f567346a = r100;
    }

    @Override // td8.c
    public final List<xc8.b> b(int r510, xc8.b r511, xc8.b r512, List<xc8.b> r513) {
        Intrinsics.checkNotNullParameter(r512, "current");
        Intrinsics.checkNotNullParameter(r513, "input");
        if (this.f567346a.Pa() == true) goto L6;
        FLogger.f375446a.i("ForceLoadingWhenStreamingTask", "ForceLoadingWhenStreamingTask: disabled by task context");
        return r513;
    L6:
        FloatChatWindowState r100 = this.f567346a.h();
        if (r100 != null) goto L10;
        return r513;
    L10:
        if (r100 != FloatChatWindowState.Expanded) goto L12;
        return r513;
    L12:
        Iterator<T> r101 = r513.iterator();
    L13:
        String r102 = null;
        if (r101.hasNext() == false) goto L50;
        Object r103 = r101.next();
        xc8.b r104 = (xc8.b) r103;
        Message r105 = r104.getMessage();
        if (com.larus.bmhome.chat.bean.d.i0(r105) == false) goto L21;
        if (com.larus.bmhome.chat.bean.d.w(r105) == true) goto L21;
    L40:
        boolean r106 = false;
    L41:
        if (r106 == true) goto L43;
    L47:
        boolean r107 = false;
    L48:
        if (r107 == false) goto L13;
    L51:
        xc8.b r108 = (xc8.b) r103;
        if (r108 == null) goto L54;
        Message r109 = r108.getMessage();
    L55:
        if (r109 != null) goto L57;
        FLogger.f375446a.i("ForceLoadingWhenStreamingTask", "ForceLoadingWhenStreamingTask: latestStreamingMessage is null");
    L57:
        if (r109 != null) goto L60;
        return r513;
    L60:
        if (com.larus.bmhome.chat.bean.d.I0(r109) == false) goto L62;
    L100:
        FLogger.f375446a.i("ForceLoadingWhenStreamingTask", "ForceLoadingWhenStreamingTask: lastBlock is loading or thinking");
        return r513;
    L62:
        if (com.larus.bmhome.chat.bean.d.f0(r109) == true) goto L100;
        Iterator<xc8.b> r110 = r513.iterator();
        int r111 = 0;
    L66:
        if (r110.hasNext() == false) goto L71;
        if (Intrinsics.areEqual(r110.next().getMessage(), r109) == true) goto L72;
        r111 = r111 + 1;
    L72:
        if (r111 >= 0) goto L74;
        return r513;
    L74:
        e0 r112 = AuthModelDelegate.f297134b.e().getValue();
        if (r112 == null) goto L83;
        LaunchInfo r113 = r112.f297186a;
        if (r113 == null) goto L83;
        String r114 = r113.c();
        if (r114 == null) goto L83;
        if ((!StringsKt.isBlank(r114)) == false) goto L83;
    L84:
        if (r114 != null) goto L86;
        r114 = "";
    L86:
        String r115 = r114;
        Map<String, String> r116 = r109.getBusinessExt();
        if (r116 == null) goto L90;
        String r117 = r116.get("loading_reply_id");
        if (r117 == null) goto L90;
    L91:
        String r410 = r117;
        MessageStatus r118 = MessageStatus.MessageStatus_AVAILABLE;
        Intrinsics.checkNotNullParameter(r109, "<this>");
        Map<String, String> r119 = r109.getBusinessExt();
        if (r119 == null) goto L95;
        r102 = r119.get("waiting_error");
    L95:
        if (Intrinsics.areEqual(r102, "true") == false) goto L97;
        int r120 = 22;
    L98:
        ListProtector.set(r513, r111, xc8.f.f(b0.j(Message.copy$default(r109, null, null, "", 0, r120, r118, 1, false, null, r115, null, null, null, null, null, null, 0, 0, false, null, null, null, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("is_mock_receiving", "1"), TuplesKt.to("has_custom_loading_text", "1"), TuplesKt.to(Constants.KEY_ERROR_CODE, "-1"), TuplesKt.to(LocationMonitorConst.ERR_MSG, "first pkg timeout err"), TuplesKt.to("key_is_business_error", "0")}), null, null, 0, false, 0, r410, null, false, null, null, 0, null, null, null, -272630389, 31, null), 0)));
        return r513;
    L97:
        r120 = 0;
    L90:
        r117 = r109.getLocalMessageId();
    L83:
        r114 = null;
        goto L84
    L71:
        r111 = -1;
        goto L72
    L54:
        r109 = null;
        goto L55
    L43:
        if (b0.f(r104.getMessage()) == true) goto L47;
        if (com.larus.bmhome.chat.bean.d.Q0(r104.getMessage()) == false) goto L47;
        r107 = true;
    L21:
        if (com.larus.bmhome.chat.bean.d.T(r105) == true) goto L40;
        if (com.larus.bmhome.chat.bean.d.p0(r105) == true) goto L40;
        if (com.larus.bmhome.chat.bean.d.C0(r105) == true) goto L28;
    L30:
        MessageStatus r121 = r105.getMessageStatus();
        if (r121 != null) goto L33;
    L35:
        boolean r122 = false;
    L36:
        if (r122 == false) goto L38;
    L39:
        r106 = true;
        goto L41
    L38:
        if (b0.f(r105) == false) goto L40;
    L33:
        if (r121.isVisible() != true) goto L35;
        r122 = true;
        goto L36
    L28:
        if (r105.getRegenVisible() == true) goto L30;
    L50:
        r103 = null;
        goto L51
    }
}
