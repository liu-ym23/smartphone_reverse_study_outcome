package com.larus.bmhome.chat.layout.holder.helper;

import android.view.View;
import android.view.ViewGroup;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.bmhome.view.screenmenu.CommonMenu;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.skydoves.balloon.Balloon;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes25.dex */
public abstract class a1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Message f303570a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.larus.bmhome.chat.api.q0 f303571b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.larus.bmhome.chat.api.q0.a f303572c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final t0 f303573d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ViewGroup f303574e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final JSONObject f303575f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Balloon f303576g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Balloon f303577h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public CommonMenu f303578i;

    public abstract void a(com.larus.bmhome.chat.layout.holder.menu.item.a.C4056a r100);

    public abstract ef8.b c(View r100);

    public void d() {
    }

    public static Integer e(JSONObject r100) {
        if (r100 == null) goto L5;
        Object r101 = r100.opt("content_type");
    L7:
        if ((r101 instanceof Number) == false) goto L10;
        return Integer.valueOf(((Number) r101).intValue());
    L10:
        if ((r101 instanceof String) == true) goto L12;
        return null;
    L12:
        return StringsKt.toIntOrNull((String) r101);
    L5:
        r101 = null;
        goto L7
    }

    public final void b(List<? extends ot8.a> r100, boolean r110, Integer r111) {
        ChatControlTrace r101 = ChatControlTrace.f309996b;
        Message r102 = this.f303570a;
        com.larus.bmhome.chat.api.q0.a r103 = this.f303572c;
        if (r103 == null) goto L7;
        com.larus.bmhome.chat.component.cvs.y r104 = r103.u0();
        if (r104 == null) goto L7;
        BotModel r105 = r104.j0();
    L8:
        com.larus.bmhome.chat.api.q0.a r106 = this.f303572c;
        if (r106 == null) goto L15;
        com.larus.bmhome.chat.component.cvs.y r107 = r106.u0();
        if (r107 == null) goto L15;
        wc9.e r108 = r107.h();
        if (r108 == null) goto L15;
        String r109 = ic8.n.f(r108);
    L16:
        if (r110 == false) goto L18;
        String r112 = "click_long_press_more";
    L19:
        JSONObject r113 = new JSONObject();
        r113.putOpt("content_type", r111);
        Unit r114 = Unit.INSTANCE;
        r101.jc(r100, r102, r105, null, r109, r112, r113);
        return;
    L18:
        r112 = "long_press_message";
    L15:
        r109 = null;
    L7:
        r105 = null;
        goto L8
    }

    public a1(Message r100, com.larus.bmhome.chat.api.q0 r101, com.larus.bmhome.chat.api.q0.a r102, t0 r103, ViewGroup r104, JSONObject r105) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r103, "popMenuGroupCreator");
        this.f303570a = r100;
        this.f303571b = r101;
        this.f303572c = r102;
        this.f303573d = r103;
        this.f303574e = r104;
        this.f303575f = r105;
    }

    public /* synthetic */ a1(Message r100, com.larus.bmhome.chat.api.q0 r101, com.larus.bmhome.chat.api.q0.a r110, t0 r111, JSONObject r112, int r113) {
        if ((r113 & 32) == 0) goto L5;
        r112 = null;
    L5:
        this(r100, r101, r110, r111, null, r112);
    }
}
