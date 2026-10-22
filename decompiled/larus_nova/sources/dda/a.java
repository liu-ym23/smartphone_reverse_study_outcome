package dda;

import android.app.Activity;
import android.content.Context;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.social.userchat.model.b0;
import com.larus.bmhome.utils.i;
import com.larus.common.apphost.AppHost;
import com.larus.home.api.main.HomeService;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.TextContent;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.obric.assistant.SessionAuthenticationServiceDelegate;
import com.obric.assistant.chat.p;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import com.obric.assistant.interaction.api.IKeyguardStateKt;
import com.obric.assistant.interaction.api.window.IWindowContextKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import lha.f;
import td8.d;

/* JADX INFO: loaded from: classes32.dex */
public final class a implements td8.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f468035a;

    /* JADX INFO: renamed from: dda.a$a, reason: collision with other inner class name */
    public static final class C5657a {
    }

    static {
    }

    public a(d r100) {
        Intrinsics.checkNotNullParameter(r100, "taskContext");
        this.f468035a = r100;
    }

    @Override // td8.c
    public final boolean a(int r110, xc8.b r111, xc8.b r112, List<? extends xc8.b> r113) {
        Intrinsics.checkNotNullParameter(r112, "current");
        Intrinsics.checkNotNullParameter(r113, "input");
        xc8.b r114 = (xc8.b) CollectionsKt.firstOrNull(r113);
        if (r114 == null) goto L9;
        Message r115 = r114.getMessage();
        if (r115 == null) goto L9;
        String r116 = r115.getConversationId();
        if (r116 == null) goto L9;
        boolean r117 = i.g(r116);
    L10:
        Context r118 = this.f468035a.j();
        String r119 = "";
        if (r118 == null) goto L13;
        String r120 = r118.getClass().getName();
    L14:
        AppHost.Companion r100 = AppHost.f326268a;
        Activity r101 = r100.a().getCurrentActivity();
        if (r101 == null) goto L17;
        String r102 = r101.getClass().getName();
    L18:
        if (r102 == null) goto L21;
        r119 = r102;
    L21:
        HomeService r103 = HomeService.f344094a;
        if (Intrinsics.areEqual(r120, r103.r()) == false) goto L24;
    L27:
        boolean r104 = true;
    L28:
        boolean r105 = IWindowContextKt.isWindowContext(this.f468035a.j());
        boolean r106 = SessionAuthenticationServiceDelegate.f385201b.o().getValue().booleanValue();
        boolean r107 = IKeyguardStateKt.getKeyguardState().isDeviceLocked();
        FLogger.f375446a.i("Pipeline_List_OKeyguardCutTask", "canProcess: isKeyguardLocked = " + IKeyguardStateKt.getKeyguardState().isKeyguardLocked() + ", isDeviceLocked: " + r107 + ", isBiometricAuthenticated: " + r106 + ", lock time = " + IKeyguardStateKt.getKeyguardState().getKeyguardLockTime() + ", isMainBotExceptCocoSub: " + r117 + ", isObricChatActivity: " + r104 + ", uiContextClassName: " + r120 + ", topActivityClassName = " + r119 + ", isChatWindow = " + r105);
        if (ObricFeatureServiceDelegate.f387839b.c() == true) goto L31;
        return false;
    L31:
        if (IKeyguardStateKt.getKeyguardState().isKeyguardLocked() == false) goto L53;
        if (r107 == false) goto L54;
        if (r106 == true) goto L55;
        if (r105 == true) goto L48;
        if (r104 == false) goto L56;
        if (r117 == true) goto L50;
        return false;
    L50:
        t1a.b r121 = p.a(r100.a().getCurrentActivity());     // Catch: Throwable -> L45
        if (r121 == null) goto L46;
        laa.d r122 = (laa.d) r121.getAbility(laa.d.class);     // Catch: Throwable -> L45
        if (r122 == null) goto L46;
        if (r122.isFullScreen() == true) goto L46;
        boolean r123 = true;
    L47:
        if (r123 == true) goto L48;
        return false;
    L46:
        r123 = false;
        goto L47
    L56:
        return false;
    L48:
        return true;
    L55:
        return false;
    L54:
        return false;
    L53:
        return false;
    L24:
        if (Intrinsics.areEqual(r119, r103.r()) == true) goto L27;
        r104 = false;
        goto L28
    L17:
        r102 = null;
        goto L18
    L13:
        r120 = "";
    L9:
        r117 = false;
        goto L10
    }

    @Override // td8.c
    public final List<xc8.b> b(int r410, xc8.b r411, xc8.b r510, List<xc8.b> r511) {
        Intrinsics.checkNotNullParameter(r510, "current");
        Intrinsics.checkNotNullParameter(r511, "input");
        FLogger.f375446a.i("Pipeline_List_OKeyguardCutTask", "start OKeyguardCutTask, start input size is " + r511.size());
        if (IKeyguardStateKt.getKeyguardState().isDeviceLocked() == false) goto L57;
        long r100 = f.a().b();
        String r101 = String.valueOf(r100);
        LinkedHashSet r102 = new LinkedHashSet();
        LinkedHashSet r103 = new LinkedHashSet();
        ArrayList r104 = new ArrayList();
        Iterator r105 = CollectionsKt.reversed(r511).iterator();
    L5:
        String r106 = null;
        if (r105.hasNext() == false) goto L39;
        xc8.b r107 = (xc8.b) r105.next();
        Message r110 = r107.getMessage();
        if (r110.getCreateTime() >= r100) goto L15;
        if (r110.getCreateTime() != 0) goto L5;
        if (o0.d(r110.getReplyId()) == false) goto L5;
        if (Intrinsics.areEqual(r110.getReplyId(), "0") == true) goto L5;
    L15:
        Map<String, String> r111 = r110.getExt();
        if (r111 == null) goto L19;
        r106 = r111.get("keyguard_lock_time");
    L19:
        if (Intrinsics.areEqual(r106, r101) == false) goto L24;
        String r108 = r110.getMessageId();
        if (r108 == null) goto L24;
        r102.add(r108);
    L24:
        if (CollectionsKt.contains(r102, r110.getMessageId()) == false) goto L26;
    L31:
        String r109 = r110.getMessageId();
        if (r109 == null) goto L35;
        r103.add(r109);
    L35:
        if (CollectionsKt.contains(r103, r110.getMessageId()) == true) goto L38;
        if (CollectionsKt.contains(r103, r110.getReplyId()) == false) goto L5;
    L38:
        r104.add(r107);
        goto L5
    L26:
        if (CollectionsKt.contains(r102, r110.getReplyId()) == true) goto L31;
        if (com.larus.bmhome.chat.bean.d.G0(r110) == true) goto L35;
        if (Intrinsics.areEqual(r110.getReplyId(), "0") == false) goto L35;
    L39:
        List<xc8.b> r112 = CollectionsKt.toMutableList(CollectionsKt.reversed(r104));
        FLogger r113 = FLogger.f375446a;
        StringBuilder r114 = new StringBuilder("end OKeyguardCutTask, lastMessage: ");
        xc8.b r115 = (xc8.b) CollectionsKt.firstOrNull(r112);
        if (r115 == null) goto L42;
        r106 = r115.getMessage();
    L42:
        r114.append(r106);
        r113.i("Pipeline_List_OKeyguardCutTask", r114.toString());
        ListProtector.add(r112, r112.size(), xc8.f.f(b0.j(new Message(null, null, null, 0, 0, null, 1001, false, null, com.larus.im.internal.core.message.converter.a.a(new TextContent(AppHost.f326268a.getApplication().getString(R.string.obric_unlock_to_see_more_chat_history), null, null, null, null, null, null, null, 254, null), TextContent.Companion.serializer()), null, null, null, null, null, null, 0, 0, false, null, null, null, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("o_keyguard_tips_message", "1")}), null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -4194881, 31, null), 3)));
        return r112;
    L57:
        return r511;
    }
}
