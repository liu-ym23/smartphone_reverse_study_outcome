package i7b;

import android.text.TextUtils;
import com.ss.android.lark.biz.im.api.ChatWindowPrepareData;
import com.ss.android.lark.biz.im.api.OpenApp;
import com.ss.android.lark.biz.im.api.bundle.ChatTeamBundle;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.wallpaper.ChatThemeInfo;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f488501a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f488502b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f488503c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f488504d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f488505e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Chat f488506f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ChatChatter f488507g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ChatChatter f488508h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public OpenApp f488509i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ChatThemeInfo f488510j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f488511k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f488512l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f488513m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ChatTeamBundle f488514n;

    public final boolean a() {
        if (TextUtils.isEmpty(this.f488505e) == false) goto L6;
        Log.e("ChatWindowInitData", "open chat failed，chatId is null!!!");
        return false;
    L6:
        Chat r100 = this.f488506f;
        if (r100 != null) goto L11;
        Log.e("ChatWindowInitData", "open chat failed，chat is null，chatId:" + this.f488505e);
        return false;
    L11:
        if (r100.isSecret() == true) goto L16;
        if (this.f488506f.isFake() == false) goto L16;
        return true;
    L16:
        if (this.f488506f.getType() != Chat.Type.P2P) goto L22;
        if (this.f488507g != null) goto L22;
        Log.e("ChatWindowInitData", "open chat failed，chatter is null, chatId:" + this.f488505e);
        return false;
    L22:
        if (this.f488508h != null) goto L25;
        Log.e("ChatWindowInitData", "open chat failed, self is null，chatId:" + this.f488505e);
        return false;
    L25:
        return true;
    }

    public a() {
    }

    public static a b(fxa.b r100, ChatWindowPrepareData r101) {
        a r102 = new a();
        r102.f488501a = r100.q();
        r102.f488504d = r100.i();
        r102.f488502b = r100.o();
        r102.f488503c = r100.t();
        r102.f488505e = r100.getChatId();
        r100.getAppId();
        r102.f488511k = r100.d();
        r100.k();
        r100.getSourceType();
        r100.getTabId();
        if (r101 != null) goto L5;
        r101 = r100.g();
    L5:
        if (r101 == null) goto L7;
        r102.f488506f = r101.chat;
        r102.f488507g = r101.p2pChatter;
        r102.f488508h = r101.self;
        r102.f488509i = r101.openApp;
        r102.f488510j = r101.chatThemeInfo;
    L7:
        r102.f488512l = r100.c();
        r102.f488513m = r100.h();
        r102.f488514n = r100.e();
        r100.j();
        return r102;
    }
}
