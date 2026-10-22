package com.ss.android.lark.chatwindow.view.tip;

import android.content.Context;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.obric.assistant.WakeupSoundEffectSettings;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.chat.ChatHitPoint;
import com.ss.android.lark.utils.UIHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes35.dex */
public abstract class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<MessageInfo> f417102a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r7b.c f417103b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f417104c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f417105d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c f417106e;

    /* JADX INFO: renamed from: com.ss.android.lark.chatwindow.view.tip.a$a, reason: collision with other inner class name */
    public static class C4883a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f417107a;

        public C4883a() {
        }
    }

    public interface b<T> {
        boolean a(MessageInfo r100, T r101);

        int b(T r100);
    }

    public interface c {
        void a(int r100, boolean r101);

        void b(Message r100);
    }

    public abstract int b();

    public abstract int c();

    public abstract String d();

    public abstract boolean f();

    public abstract boolean g();

    public abstract boolean h();

    public abstract boolean i();

    public final void e() {
        String r100 = "up";
        if (((ArrayList) this.f417102a).isEmpty() == true) goto L14;
        Message r101 = ((MessageInfo) ListProtector.get(this.f417102a, 0)).getMessage();
        this.f417106e.b(r101);
        int r102 = c();
        boolean r103 = f();
        boolean r104 = r101.isAtAll();
        o5c.b r105 = ChatHitPoint.f440631a.b();
        JSONObject r106 = new JSONObject().put("unread_total", r102).put("chat_mode", WakeupSoundEffectSettings.CLASSIC);
        if (r103 == true) goto L8;
        r100 = ILiveRoomPlayFragmentConstant.LOG_DIRECTION_DOWN;
    L8:
        JSONObject r107 = r106.put("direction", r100);
        if (r104 == false) goto L11;
        String r108 = "all";
    L12:
        r105.sendEvent("new_message_mention_click", r107.put("type", r108));
        return;
    L11:
        r108 = "user";
        goto L12
    L14:
        if (c() <= 0) goto L21;
        this.f417106e.a(b(), true ^ f());
        int r109 = c();
        boolean r110 = f();
        o5c.b r111 = ChatHitPoint.f440631a.b();
        JSONObject r112 = new JSONObject().put("unread_total", r109).put("chat_mode", WakeupSoundEffectSettings.CLASSIC);
        if (r110 == true) goto L19;
        r100 = ILiveRoomPlayFragmentConstant.LOG_DIRECTION_DOWN;
    L19:
        r111.sendEvent("new_message_toast_click", r112.put("direction", r100));
        return;
    L21:
        if (g() == false) goto L23;
        this.f417106e.a(b(), true);
        int r113 = c();
        ChatHitPoint.f440631a.b().sendEvent("message_dialog_back_to_bottom_click", new JSONObject().put("unread_total", r113).put("chat_mode", WakeupSoundEffectSettings.CLASSIC));
        return;
    L23:
        Log.e("BaseNewMessageTiphandleOnTipClick, unReadAtMessage is 0, newMessageCount is 0");
    }

    public a(Context r100, r7b.c r101) {
        this.f417102a = new ArrayList();
        this.f417104c = r100;
        this.f417103b = r101;
    }

    public String a(Message r100, String r101) {
        if (r100.isAtAll() == false) goto L6;
        return UIHelper.mustacheFormat(R.string.Lark_Legacy_AtAllUser, "chatter_name", r101);
    L6:
        if (r100.isOtherAtMe() == true) goto L11;
        return null;
    L11:
        return UIHelper.mustacheFormat(R.string.Lark_Legacy_AtWindowTip, "chatter_name", r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void j(List<T> r100, b<T> r101) {
        Iterator r102 = ((ArrayList) r100).iterator();
    L4:
        if (r102.hasNext() == false) goto L11;
        Object r103 = r102.next();
        Iterator r104 = ((ArrayList) this.f417102a).iterator();
    L7:
        if (r104.hasNext() == false) goto L4;
        if (r101.a((MessageInfo) r104.next(), r103) == false) goto L7;
        r104.remove();
        goto L7
    }
}
