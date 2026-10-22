package com.larus.home.impl.main.side_bar.view.adapter;

import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.byted.cast.common.auth.AuthConstants;
import com.larus.audio.AudioServiceDelegate;
import com.larus.bmhome.ConversationChangeModel;
import com.larus.bmhome.chat.manager.ChatListScreenMenuManager;
import com.larus.bmhome.chat.manager.NavigationSideBarState;
import com.larus.bmhome.chat.model.ConversationModel;
import com.larus.im.bean.bot.BotModel;
import com.larus.nova.R;
import com.ss.ttm.player.MediaPlayer;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tx9.u1;
import v19.i5;

/* JADX INFO: loaded from: classes29.dex */
public final class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f344992a = 0;

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r18v0, types: [com.larus.home.impl.main.side_bar.view.adapter.h0] */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.larus.home.impl.main.side_bar.view.adapter.i0] */
    public static void a(final View r310, final wh8.a r311, final com.larus.home.impl.main.side_bar.view.b r312, com.larus.home.impl.main.side_bar.view.c r313) {
        Intrinsics.checkNotNullParameter(r310, "anchor");
        Intrinsics.checkNotNullParameter(r313, "conversationBridge");
        if (r311 == null) goto L5;
        wc9.e r100 = r311.f559708a;
    L6:
        boolean r210 = ic8.n.u(r100);
        boolean r101 = com.larus.platform.exp.o.a();
        if (r210 == false) goto L10;
        if (r101 == true) goto L10;
        return;
    L10:
        boolean r211 = false;
        if (r312 == null) goto L38;
        Fragment r102 = r312.getFragment();
        if (r102 == null) goto L38;
        FragmentManager r103 = r102.getChildFragmentManager();
        if (r103 == null) goto L38;
        com.larus.bmhome.view.screenmenu.x0 r104 = r313.VZ();
        boolean r105 = r310.isActivated();
        r310.setActivated(true);
        int r106 = ChatListScreenMenuManager.f306626a;
        Function0 r107 = new g0(r310);
        ConversationModel r108 = r313.HC();
        ConversationChangeModel r109 = r313.Na();
        int r110 = i5.h();
        ?? r111 = new h0();
        ?? r112 = new i0(r312);
        if (r312.bH() == false) goto L19;
        j0 r212 = new j0(r311, r312);
    L20:
        if (r210 == false) goto L24;
        if (r101 == true) goto L24;
        boolean r213 = false;
    L25:
        if (r210 == false) goto L28;
        if (r101 == false) goto L28;
        boolean r214 = true;
    L29:
        if (r210 == false) goto L35;
        TextView r113 = (TextView) r310.findViewById(R.id.tv_title);
        if (r113 == null) goto L35;
        CharSequence r114 = r113.getText();
        if (r114 == null) goto L35;
        String r215 = r114.toString();
    L36:
        ChatListScreenMenuManager.i(r310, r103, r104, r107, r108, r109, r311, new com.larus.bmhome.chat.manager.u0(r110, true, null, r111, r112, r212, r210, r213, r214, r215, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_ENABLE_UNRELIABLE), new com.larus.bmhome.chat.manager.t0("long_press_cell", r312.getCurrentPage(), r312.b(), f0.a(r311), NavigationSideBarState.YES.getState(), 32), r312.getFragment());
        r310.setActivated(r105);
    L35:
        r215 = null;
    L28:
        r214 = false;
    L24:
        r213 = true;
        goto L25
    L19:
        r212 = 0;
    L38:
        AudioServiceDelegate r115 = AudioServiceDelegate.f288288a;
        if (r311 == null) goto L41;
        BotModel r116 = r311.f559709b;
    L43:
        if (r115.n(r116) == false) goto L45;
        String r117 = "1";
    L46:
        String r118 = r117;
        if (r311 == null) goto L51;
        BotModel r119 = r311.f559709b;
        if (r119 == null) goto L51;
        String r120 = r119.getBotId();
    L52:
        int r121 = ChatListScreenMenuManager.f306626a;
        String r122 = ChatListScreenMenuManager.g(r311);
        if (r312 == null) goto L55;
        String r123 = r312.getCurrentPage();
    L56:
        String r124 = f0.a(r311);
        if (r311 == null) goto L59;
        String r125 = r311.f559712e;
    L60:
        JSONObject r126 = new JSONObject();
        if (r311 == null) goto L73;
        wc9.e r127 = r311.f559708a;
        if (r127 == null) goto L73;
        String r128 = r127.I;
        if (r128 == null) goto L73;
        if (r128.length() <= 0) goto L69;
        r211 = true;
    L69:
        if (r211 == false) goto L71;
        String r129 = r128;
    L72:
        if (r129 == null) goto L73;
    L74:
        r126.put(AuthConstants.PARAM_KEY_LICENSE_PROJECT_ID, r129);
        u1.a(r120, r122, r123, r124, r118, r125, "1", null, r126, null, 640);
        return;
    L71:
        r129 = null;
    L73:
        r129 = "-";
        goto L74
    L59:
        r125 = null;
        goto L60
    L55:
        r123 = null;
    L51:
        r120 = null;
        goto L52
    L45:
        r117 = "0";
        goto L46
    L41:
        r116 = null;
        goto L43
    L5:
        r100 = null;
        goto L6
    }
}
