package com.larus.bmhome.bot.utils;

import android.app.Activity;
import android.net.Uri;
import com.larus.bmhome.auth.feature_config.model.FeatureKitDelegate;
import com.larus.bmhome.chat.model.repo.BotRepo;
import com.larus.bmhome.chat.model.repo.IBotRepoService;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.im.bean.bot.BotConfItem;
import com.larus.im.bean.bot.BotIconImage;
import com.larus.im.bean.bot.BotModel;
import com.larus.platform.api.IShortcutPlatformService;
import com.larus.utils.logger.FLogger;
import com.larus.utils.y0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;
import wc9.e;

/* JADX INFO: loaded from: classes25.dex */
public final class PinBotShortcutLinkProcessor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PinBotShortcutLinkProcessor f296774a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final BotModel f296775a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f296776b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f296777c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f296778d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Boolean f296779e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f296775a, r101.f296775a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f296776b, r101.f296776b) == true) goto L15;
            return false;
        L15:
            if (this.f296777c == r101.f296777c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f296778d, r101.f296778d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f296779e, r101.f296779e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f296775a.hashCode() * 31) + this.f296776b.hashCode()) * 31;
            if (this.f296777c == false) goto L5;
            int r101 = 1231;
        L6:
            int r102 = (((r100 + r101) * 31) + this.f296778d.hashCode()) * 31;
            Boolean r103 = this.f296779e;
            if (r103 != null) goto L9;
            int r104 = 0;
        L11:
            return r102 + r104;
        L9:
            r104 = r103.hashCode();
            goto L11
        L5:
            r101 = 1237;
            goto L6
        }

        public final String toString() {
            return "Parameter(botModel=" + this.f296775a + ", conversationId=" + this.f296776b + ", openChat=" + this.f296777c + ", currentPage=" + this.f296778d + ", ifCanUploadImage=" + this.f296779e + ')';
        }

        public a(BotModel r100, String r101, boolean r102, String r103, Boolean r104) {
            Intrinsics.checkNotNullParameter(r100, "botModel");
            Intrinsics.checkNotNullParameter(r101, "conversationId");
            Intrinsics.checkNotNullParameter(r103, "currentPage");
            this.f296775a = r100;
            this.f296776b = r101;
            this.f296777c = r102;
            this.f296778d = r103;
            this.f296779e = r104;
        }
    }

    static {
        f296774a = new PinBotShortcutLinkProcessor();
    }

    public PinBotShortcutLinkProcessor() {
    }

    public static void e(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new PinBotShortcutLinkProcessor$process$2(r100, null), 3, null);
    }

    public static final void b(PinBotShortcutLinkProcessor r110, a r111) {
        r110.getClass();
        String r112 = r111.f296778d;
        String r100 = r111.f296775a.getBotId();
        ChatControlTrace r101 = ChatControlTrace.f309996b;
        r101.getClass();
        String r102 = r101.h(ChatControlTrace.f310027y);
        Boolean r103 = Boolean.valueOf(ve8.c.c(r111.f296775a));
        Boolean r104 = r111.f296779e;
        String r105 = null;
        if (r104 == null) goto L5;
        boolean r106 = r104.booleanValue();
    L28:
        JSONObject r113 = tx9.c.a(r112, r100, r102, r103, Boolean.valueOf(r106));
        IShortcutPlatformService r107 = (IShortcutPlatformService) ServiceManager.get().getService(IShortcutPlatformService.class);
        if (r107 == null) goto L40;
        String r108 = r111.f296776b;
        String r109 = r111.f296775a.getName();
        BotIconImage r114 = r111.f296775a.getIconImage();
        if (r114 == null) goto L33;
        r105 = r114.getOriginUrl();
    L33:
        r107.c(r108, r109, r105, vb8.a.a(r111.f296775a), r113);
        return;
    L40:
        return;
    L5:
        BotModel r115 = r111.f296775a;
        Intrinsics.checkNotNullParameter(r115, "<this>");
        List<BotConfItem> r116 = r115.getBotConf();
        if (r116 == null) goto L22;
        Iterator<T> r117 = r116.iterator();
    L9:
        if (r117.hasNext() == false) goto L18;
        Object r118 = r117.next();
        BotConfItem r119 = (BotConfItem) r118;
        if (Intrinsics.areEqual(r119.getConfGroupKey(), "show_icon") == true) goto L13;
    L15:
        boolean r120 = false;
    L16:
        if (r120 == false) goto L9;
    L19:
        BotConfItem r121 = (BotConfItem) r118;
        if (r121 == null) goto L22;
        String r122 = r121.getConfValue();
    L23:
        boolean r123 = Intrinsics.areEqual(r122, "1");
        if (FeatureKitDelegate.f295792b.U().b() == false) goto L27;
        if (r123 == false) goto L27;
        r106 = true;
    L27:
        r106 = false;
        goto L28
    L13:
        if (Intrinsics.areEqual(r119.getConfKey(), "show_image_icon") == false) goto L15;
        r120 = true;
        goto L16
    L18:
        r118 = null;
    L22:
        r122 = null;
        goto L23
    }

    public static void d(Activity r100, Uri r101) {
        Intrinsics.checkNotNullParameter(r100, "host");
        Intrinsics.checkNotNullParameter(r101, "uri");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new PinBotShortcutLinkProcessor$process$1(r101, r100, null), 3, null);
    }

    public final Object c(String r110, Continuation<? super String> r111) {
        if ((r111 instanceof PinBotShortcutLinkProcessor$findConversationIdByBot$1) == false) goto L7;
        PinBotShortcutLinkProcessor$findConversationIdByBot$1 r100 = (PinBotShortcutLinkProcessor$findConversationIdByBot$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        PinBotShortcutLinkProcessor$findConversationIdByBot$1 r112 = r100;
        Object r113 = r112.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r112.label;
        if (r103 == 0) goto L16;
        if (r103 == 1) goto L15;
        if (r103 != 2) goto L14;
        ResultKt.throwOnFailure(r113);
    L35:
        e r114 = (e) r113;
        if (r114 == null) goto L43;
        Map<String, String> r115 = r114.f559221x;
        if (r115 == null) goto L41;
        Map<String, String> r116 = MapsKt.toMutableMap(r115);
        if (r116 == null) goto L41;
    L42:
        r116.put("is_from_local_discovery", "1");
        RepoDispatcherDelegate.f307737b.f().c(r114, r116);
    L41:
        r116 = new HashMap();
    L43:
        if (r114 == null) goto L46;
        String r117 = r114.f559198a;
        if (r117 == null) goto L46;
        return r117;
    L46:
        return "";
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r110 = (String) r112.L$0;
        ResultKt.throwOnFailure(r113);
    L19:
        e r118 = (e) r113;
        if (r118 == null) goto L27;
        Integer r104 = r118.f559217t;
        if (r104 == null) goto L27;
        if (r104.intValue() != 1) goto L27;
        String r119 = r118.f559198a;
    L28:
        if (r119 != null) goto L30;
    L32:
        IConversationRepoService r120 = RepoDispatcherDelegate.f307737b.f();
        r112.L$0 = null;
        r112.label = 2;
        r113 = IConversationRepoService.a.a(r120, r110, 2, null, null, false, null, null, null, null, r112, 508);
        if (r113 != r102) goto L35;
        return r102;
    L30:
        if (StringsKt.contains$default(r119, "local", false, 2, null) == true) goto L32;
        return r119;
    L27:
        r119 = null;
        goto L28
    L16:
        ResultKt.throwOnFailure(r113);
        IConversationRepoService r121 = RepoDispatcherDelegate.f307737b.f();
        r112.L$0 = r110;
        r112.label = 1;
        r113 = r121.a(r110, r112);
        if (r113 != r102) goto L19;
        return r102;
    L7:
        r100 = new PinBotShortcutLinkProcessor$findConversationIdByBot$1(this, r111);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Object a(PinBotShortcutLinkProcessor r110, Uri r111, Continuation r210) {
        Uri r100 = r111;
        r110.getClass();
        if ((r210 instanceof PinBotShortcutLinkProcessor$buildParameter$1) == false) goto L7;
        PinBotShortcutLinkProcessor$buildParameter$1 r101 = (PinBotShortcutLinkProcessor$buildParameter$1) r210;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        PinBotShortcutLinkProcessor$buildParameter$1 r103 = r101;
        Object r104 = r103.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r103.label;
        boolean r112 = true;
        if (r106 == 0) goto L16;
        if (r106 == 1) goto L15;
        if (r106 != 2) goto L14;
        boolean r107 = r103.Z$0;
        String r108 = (String) r103.L$2;
        String r109 = (String) r103.L$1;
        Uri r113 = (Uri) r103.L$0;
        ResultKt.throwOnFailure(r104);
        boolean r114 = r107;
        String r115 = r108;
    L34:
        BotModel r116 = (BotModel) r104;
        Object r117 = null;
        if (r116 != null) goto L38;
        FLogger.f375446a.e("PinBotShortcutLinkProcessor", "[buildParameter] failed, cannot find botModel");
    L52:
        return r117;
    L38:
        if (r115.length() == 0) goto L41;
        r112 = false;
    L41:
        if (r112 == false) goto L44;
        FLogger.f375446a.e("PinBotShortcutLinkProcessor", "[buildParameter] failed, conversationId is empty");
        goto L52
    L44:
        String r118 = y0.f(r113, "shortcut_if_can_upload_image");
        if (r118 == null) goto L47;
        r117 = Boxing.boxBoolean(Intrinsics.areEqual(r118, "1"));
    L47:
        Boolean r119 = r117;
        if (r109 != null) goto L50;
        String r120 = "";
    L51:
        r117 = new a(r116, r115, r114, r120, r119);
        goto L52
    L50:
        r120 = r109;
        goto L51
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        String r121 = (String) r103.L$2;
        String r122 = (String) r103.L$1;
        Uri r123 = (Uri) r103.L$0;
        ResultKt.throwOnFailure(r104);
        String r124 = r122;
        r100 = r123;
        Object r125 = r104;
    L25:
        String r126 = r121;
        String r127 = (String) r125;
    L27:
        boolean r128 = Intrinsics.areEqual(y0.f(r100, "open_chat"), "1");
        FLogger.f375446a.i("PinBotShortcutLinkProcessor", "[buildParameter] url_params(bot_id:" + r124 + ", conversation_id:" + r127 + ", open_chat:" + r128 + ", current_page:" + r126 + ')');
        RepoDispatcher.f307729a.getClass();
        BotRepo r129 = RepoDispatcher.f307735g;
        if (r124 != null) goto L30;
        r124 = "";
    L30:
        r103.L$0 = r100;
        r103.L$1 = r126;
        r103.L$2 = r127;
        r103.Z$0 = r128;
        r103.label = 2;
        Object r130 = IBotRepoService.b.a(r129, r124, false, null, false, r103, 30);
        if (r130 == r105) goto L54;
        r115 = r127;
        r114 = r128;
        r104 = r130;
        r109 = r126;
        r113 = r100;
        goto L34
    L54:
        return r105;
    L16:
        ResultKt.throwOnFailure(r104);
        r124 = y0.f(r100, "bot_id");
        String r131 = y0.f(r100, "current_page");
        String r132 = y0.f(r100, "conversation_id");
        if (r132 != null) goto L26;
        if (r124 != null) goto L20;
        String r133 = "";
    L21:
        r103.L$0 = r100;
        r103.L$1 = r124;
        r103.L$2 = r131;
        r103.label = 1;
        Object r134 = r110.c(r133, r103);
        if (r134 == r105) goto L53;
        r125 = r134;
        r121 = r131;
        goto L25
    L53:
        return r105;
    L20:
        r133 = r124;
        goto L21
    L26:
        r126 = r131;
        r127 = r132;
    L7:
        r101 = new PinBotShortcutLinkProcessor$buildParameter$1(r110, r210);
        goto L8
    }
}
