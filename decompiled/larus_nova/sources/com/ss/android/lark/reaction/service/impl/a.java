package com.ss.android.lark.reaction.service.impl;

import com.bytedance.lark.pb.im.v1.EmojiPanel;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.newemoji.emoji_panel.DefaultEmojiPanelData;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class a {
    public static DefaultEmojiPanelData a(EmojiPanel r100) {
        DefaultEmojiPanelData r101 = new DefaultEmojiPanelData();
        if (r100 != null) goto L6;
        return r101;
    L6:
        if (CollectionUtils.isEmpty(r100.emojis_order) == false) goto L8;
        return r101;
    L8:
        Iterator<EmojiPanel.Emojis> r102 = r100.emojis_order.iterator();
    L10:
        if (r102.hasNext() == false) goto L47;
        EmojiPanel.Emojis r103 = r102.next();
        DefaultEmojiPanelData.a r104 = new DefaultEmojiPanelData.a();
        DefaultEmojiPanelData.Type.a r105 = DefaultEmojiPanelData.Type.Companion;
        int r106 = r103.type.getValue();
        r105.getClass();
        if (r106 != 1) goto L14;
        DefaultEmojiPanelData.Type r107 = DefaultEmojiPanelData.Type.DEFAULT;
    L18:
        Intrinsics.checkNotNullParameter(r107, "<set-?>");
        r104.f432958a = r107;
        String r108 = r103.title;
        if (r108 != null) goto L21;
    L23:
        String r109 = r103.source;
        if (r109 != null) goto L26;
    L28:
        String r110 = r103.icon_key;
        if (r110 != null) goto L31;
    L33:
        ArrayList r111 = new ArrayList();
        if (CollectionUtils.isNotEmpty(r103.keys) == false) goto L46;
        Iterator<EmojiPanel.Emojis.EmojiKey> r112 = r103.keys.iterator();
    L37:
        if (r112.hasNext() == false) goto L46;
        EmojiPanel.Emojis.EmojiKey r113 = r112.next();
        String r114 = r113.selected_skin_key;
        if (r114 != null) goto L41;
    L44:
        String r115 = r113.key;
    L45:
        r111.add(new Pair(r113.key, r115));
        goto L37
    L41:
        if (r114.length() <= 0) goto L44;
        r115 = r113.selected_skin_key;
    L46:
        r104.c(r111);
        Intrinsics.checkNotNullParameter(r104, "group");
        ((ArrayList) r101.f432955a).add(r104);
        goto L10
    L31:
        if (r110.length() <= 0) goto L33;
        String r116 = r103.icon_key;
        Intrinsics.checkNotNullParameter(r116, "<set-?>");
        r104.f432959b = r116;
        goto L33
    L26:
        if (r109.length() <= 0) goto L28;
        Intrinsics.checkNotNullParameter(r103.source, "<set-?>");
        goto L28
    L21:
        if (r108.length() <= 0) goto L23;
        String r117 = r103.title;
        Intrinsics.checkNotNullParameter(r117, "<set-?>");
        r104.f432960c = r117;
        goto L23
    L14:
        if (r106 == 2) goto L16;
        r107 = DefaultEmojiPanelData.Type.UNKNOWN;
        goto L18
    L16:
        r107 = DefaultEmojiPanelData.Type.CUSTOM;
        goto L18
    L47:
        return r101;
    }
}
