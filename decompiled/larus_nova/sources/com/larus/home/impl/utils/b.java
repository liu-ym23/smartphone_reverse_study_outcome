package com.larus.home.impl.utils;

import android.app.Activity;
import androidx.activity.result.ActivityResultCaller;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.larus.bmhome.BaseHomeTabFragment;
import com.larus.bmhome.a0;
import com.larus.bmhome.chat.ChatActivity;
import com.larus.bmhome.chat.ChatFragment;
import com.larus.bmhome.chat.bean.PageType;
import com.larus.bmhome.chat.immerse.ChatImmersActivity;
import com.larus.bmhome.chat.immerse.ChatImmersFragment;
import com.larus.common.apphost.AppHost;
import com.larus.home.impl.MainActivity;
import com.larus.home.impl.chat.multi_tab.ChatMultiTabActivity;
import com.larus.home.impl.chat.multi_tab.ChatMultiTabFragment;
import com.larus.home.impl.main.tab.MainTabFragment;
import com.obric.assistant.spi.window.ChatWindowServiceDelegate;
import kotlin.collections.CollectionsKt;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes29.dex */
public final class b {
    public static final ChatFragment a(Fragment r100) {
        Fragment r101 = r100.getChildFragmentManager().findFragmentByTag("tag_ai_float_chat_fragment");     // Catch: IllegalStateException -> L14
        if (r101 != null) goto L6;
    L8:
        r101 = null;
    L10:
        if ((r101 instanceof ChatFragment) == false) goto L17;
        return (ChatFragment) r101;
    L17:
        return null;
    L6:
        if (c(r101) == false) goto L8;
    L18:
        return null;
    }

    public static final ChatFragment b(Activity r100) {
        if (r100 != null) goto L5;
        r100 = AppHost.f326268a.a().getCurrentActivity();
    L5:
        if ((r100 instanceof ChatActivity) == false) goto L8;
        ChatFragment r101 = ((ChatActivity) r100).O1();
    L69:
        if (r101 != null) goto L80;
        if ((r100 instanceof FragmentActivity) == false) goto L73;
        FragmentActivity r102 = (FragmentActivity) r100;
    L74:
        if (r102 == null) goto L81;
        r101 = (ChatFragment) SequencesKt.firstOrNull(SequencesKt.mapNotNull(SequencesKt.filter(CollectionsKt.asSequence(CollectionsKt.asReversedMutable(r102.getSupportFragmentManager().getFragments())), ChatFragmentExtKt$findDirectAIFloatChatFragment$1.INSTANCE), ChatFragmentExtKt$findDirectAIFloatChatFragment$2.INSTANCE));
        if (r101 != null) goto L80;
        return (ChatFragment) SequencesKt.firstOrNull(SequencesKt.mapNotNull(SequencesKt.filter(CollectionsKt.asSequence(CollectionsKt.asReversedMutable(r102.getSupportFragmentManager().getFragments())), ChatFragmentExtKt$findAIFloatChatFragment$2.INSTANCE), new a()));
    L81:
        return null;
    L73:
        r102 = null;
    L80:
        return r101;
    L8:
        if ((r100 instanceof MainActivity) == false) goto L51;
        MainActivity r103 = (MainActivity) r100;
        ActivityResultCaller r104 = r103.getSupportFragmentManager().findFragmentByTag("tag_main_side_bar_fragment");
        if ((r104 instanceof a0) == false) goto L12;
        a0 r105 = (a0) r104;
    L13:
        if (r105 == null) goto L25;
        Fragment r106 = r105.getCurrentFragment();
        if ((r106 instanceof ChatFragment) == false) goto L18;
        r101 = (ChatFragment) r106;
        goto L69
    L18:
        if ((r106 instanceof ChatImmersFragment) == false) goto L21;
        r101 = ((ChatImmersFragment) r106).Z90();
        goto L69
    L21:
        if ((r106 instanceof ChatMultiTabFragment) == false) goto L68;
        Fragment r107 = ((ChatMultiTabFragment) r106).S90(PageType.Chat.getType());
        if ((r107 instanceof ChatFragment) == false) goto L68;
        r101 = (ChatFragment) r107;
    L68:
        r101 = null;
        goto L69
    L25:
        ActivityResultCaller r108 = r103.getSupportFragmentManager().findFragmentByTag("tag_main_container_fragment");
        if ((r108 instanceof xq8.a) == false) goto L28;
        xq8.a r109 = (xq8.a) r108;
    L29:
        if (r109 == null) goto L33;
        Fragment r110 = r109.p7();
        if ((r110 instanceof ChatFragment) == false) goto L68;
        r101 = (ChatFragment) r110;
        goto L69
    L33:
        Fragment r111 = r103.getSupportFragmentManager().findFragmentByTag("tag_main_tab_fragment");
        if ((r111 instanceof MainTabFragment) == false) goto L36;
        MainTabFragment r112 = (MainTabFragment) r111;
    L37:
        if (r112 == null) goto L43;
        String r113 = MainTabFragment.f345844J;
        BaseHomeTabFragment r114 = r112.IK(null);
        if (r114 == null) goto L43;
        FragmentManager r115 = r114.getChildFragmentManager();
        if (r115 == null) goto L43;
        int r116 = BaseHomeTabFragment.f294907i;
        Fragment r117 = r115.findFragmentByTag("chat_fragment_tag");
    L45:
        if ((r117 instanceof ChatFragment) == false) goto L48;
        r101 = (ChatFragment) r117;
        goto L69
    L48:
        if ((r117 instanceof ChatImmersFragment) == false) goto L68;
        r101 = ((ChatImmersFragment) r117).Z90();
    L43:
        r117 = null;
        goto L45
    L36:
        r112 = null;
        goto L37
    L28:
        r109 = null;
        goto L29
    L12:
        r105 = null;
        goto L13
    L51:
        if ((r100 instanceof ChatImmersActivity) == false) goto L54;
        r101 = ((ChatImmersActivity) r100).f303183h.Z90();
        goto L69
    L54:
        if ((r100 instanceof ChatMultiTabActivity) == false) goto L59;
        Fragment r118 = ((ChatMultiTabActivity) r100).f344196g.S90(PageType.Chat.getType());
        if ((r118 instanceof ChatFragment) == false) goto L68;
        r101 = (ChatFragment) r118;
        goto L69
    L59:
        if ((r100 instanceof com.bytedance.ai.api.n) == false) goto L63;
        Fragment r119 = ((com.bytedance.ai.api.n) r100).getChatFragment();
        if ((r119 instanceof ChatFragment) == false) goto L68;
        r101 = (ChatFragment) r119;
        goto L69
    L63:
        ChatWindowServiceDelegate r120 = ChatWindowServiceDelegate.f392926b;
        if (r120.d(r100) == false) goto L68;
        Fragment r121 = r120.a(r100);
        if ((r121 instanceof ChatFragment) == false) goto L68;
        r101 = (ChatFragment) r121;
        goto L69
    }

    public static final boolean c(Fragment r100) {
        if (r100.isAdded() == true) goto L5;
    L9:
        return false;
    L5:
        if (r100.isDetached() == true) goto L9;
        if (r100.getActivity() == null) goto L9;
        return true;
    }
}
