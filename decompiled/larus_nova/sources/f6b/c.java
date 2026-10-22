package f6b;

import android.os.SystemClock;
import com.ss.android.lark.biz.im.api.page.ChatDestination;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.featuregating.interfaces.IFeatureGatingService;
import com.ss.android.lark.im.sdk.service.ImSdkChatService;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.im.sdk.service.h;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;
import u3b.e;

/* JADX INFO: loaded from: classes35.dex */
public final class c implements com.ss.android.lark.chat.chatwindow.chat.perload.loader.c<b, e<ChatDestination>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImSdkChatService f475728a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f475729b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final IFeatureGatingService f475730c;

    public static final class a {
    }

    static {
    }

    public c() {
        ImSdkChatService r100 = ImSdkService.b();
        h r101 = ImSdkService.d();
        IFeatureGatingService r102 = FeatureGatingModule.getFeatureGatingService();
        Intrinsics.checkNotNullParameter(r100, "chatService");
        Intrinsics.checkNotNullParameter(r101, "chatterService");
        Intrinsics.checkNotNullParameter(r102, "fgService");
        this.f475728a = r100;
        this.f475729b = r101;
        this.f475730c = r102;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.lark.chat.chatwindow.chat.perload.loader.c
    public final e a(u3b.a r100) {
        b r101 = (b) r100;
        Intrinsics.checkNotNullParameter(r101, "task");
        e r102 = new e();
        long r103 = SystemClock.elapsedRealtime();
        String r104 = r101.f475726a;
        if (this.f475730c.isCurrentEnable("im.chat.secret_chat_isolate") == false) goto L14;
        d r105 = r101.f475727b;
        if (r105 == null) goto L11;
        fxa.b r106 = r105.f475732b;
        if (r106 == null) goto L11;
        boolean r107 = true;
        if (r106.isSecretChat() != true) goto L11;
    L12:
        if (r107 == false) goto L14;
        T r108 = ChatDestination.SECRET_CHAT;
    L44:
        r102.f548631a = r108;
        Log.i("ChatDestinationPreLoader", "getChatDestination du:" + (SystemClock.elapsedRealtime() - r103));
        return r102;
    L11:
        r107 = false;
    L14:
        d r109 = r101.f475727b;
        if (r109 == null) goto L18;
        Chat r110 = r109.f475731a;
        if (r110 == null) goto L18;
    L22:
        if (this.f475730c.isCurrentEnable("im.chat.secret_chat_isolate") == false) goto L27;
        if (r110.isSecret() == false) goto L27;
        r108 = ChatDestination.SECRET_CHAT;
    L27:
        if (r110.isP2PChat() == true) goto L30;
        r108 = ChatDestination.CHAT_WINDOW;
        goto L44
    L30:
        if (r110.isFake() == false) goto L36;
        if (this.f475730c.isCurrentEnable("im.chat.fake_chat_isolate") == false) goto L34;
        r108 = ChatDestination.FAKE_CHAT;
        goto L44
    L34:
        r108 = ChatDestination.CHAT_WINDOW;
        goto L44
    L36:
        if (this.f475730c.isCurrentEnable("messenger.im.bot_isolate") == false) goto L43;
        ChatChatter r111 = this.f475729b.He(r104, r110.getP2pChatterId());
        Chatter.ChatterType r112 = Chatter.ChatterType.BOT;
        if (r111 == null) goto L40;
        Chatter.ChatterType r113 = r111.getType();
    L41:
        if (r112 != r113) goto L43;
        r108 = ChatDestination.BOT_CHAT;
        goto L44
    L40:
        r113 = null;
    L43:
        r108 = ChatDestination.CHAT_WINDOW;
    L18:
        r110 = this.f475728a.we(r104);
        if (r110 != null) goto L22;
        r108 = ChatDestination.CHAT_WINDOW;
        goto L44
    }
}
