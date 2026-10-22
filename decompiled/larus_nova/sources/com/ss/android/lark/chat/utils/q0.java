package com.ss.android.lark.chat.utils;

import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.content.ImageContent;
import com.ss.android.lark.chat.entity.message.content.MediaContent;
import com.ss.android.lark.chat.entity.message.content.PostContent;
import com.ss.android.lark.image.entity.Image;
import com.ss.android.lark.image.impl.preload.ImagePreloadManager;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.player.player.LarkPlayerUtils;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.RichTextElement;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class q0 {
    static {
    }

    @JvmStatic
    public static final void a(MessageInfo r110) {
        Intrinsics.checkNotNullParameter(r110, "info");
        Message r111 = r110.getMessage();
        Intrinsics.checkNotNullParameter(r111, "msg");
        CopyOnWriteArraySet<String> r100 = f.f416665a;
        Intrinsics.checkNotNullParameter("chat", "scene");
        Intrinsics.checkNotNullParameter(r111, "msg");
        Log.i("ImagePreloadUtils", "preload, scene:chat, msg:" + r111.getId());
        boolean r101 = false;
        if (r111.isPreMessage() == false) goto L5;
    L13:
        boolean r102 = false;
    L14:
        if (r102 == false) goto L78;
        CopyOnWriteArraySet<String> r103 = f.f416665a;
        if (r103.contains(r111.getId()) == true) goto L78;
        if (ImagePreloadManager.isLimitCount("chat") == true) goto L78;
        r103.add(r111.getId());
        Message.Type r104 = r111.getType();
        if (r104 != null) goto L23;
        int r105 = -1;
    L24:
        if (r105 != 1) goto L26;
        Image r106 = MessengerImageLoadController.c(MessageImageMonitor.Scene.IMAGE_MESSAGE.getValue(), ((ImageContent) r111.getContent()).getImageSet());
        if (r106 == null) goto L78;
        ImagePreloadManager.preload("chat", r111.getChatId(), r106.getKey(), r106.getFsUnit(), r106.getCrypto());
        goto L78
    L26:
        if (r105 != 2) goto L28;
        Image r107 = MessengerImageLoadController.c(MessageImageMonitor.Scene.MEDIA_COVER.getValue(), ((MediaContent) r111.getContent()).getImageSet());
        if (r107 == null) goto L78;
        ImagePreloadManager.preload("chat", r111.getChatId(), r107.getKey(), r107.getFsUnit(), r107.getCrypto());
        goto L78
    L28:
        if (r105 != 3) goto L78;
        RichText r108 = ((PostContent) r111.getContent()).getRichText();
        if (r108 == null) goto L78;
        List<String> r109 = r108.getImageIds();
        if (r109 == null) goto L50;
        List r112 = CollectionsKt.filterNotNull(r109);
        if (r112 == null) goto L50;
        Iterator r113 = r112.iterator();
    L38:
        if (r113.hasNext() == false) goto L50;
        String r114 = (String) r113.next();
        RichText.RichTextElements r115 = r108.getElements();
        if (r115 == null) goto L46;
        Map<String, RichTextElement> r116 = r115.getDictionary();
        if (r116 == null) goto L46;
        RichTextElement r117 = r116.get(r114);
        if (r117 == null) goto L46;
        RichTextElement.RichTextProperty r118 = r117.getProperty();
    L48:
        if ((r118 instanceof RichTextElement.ImageProperty) == false) goto L38;
        RichTextElement.ImageProperty r119 = (RichTextElement.ImageProperty) r118;
        ImagePreloadManager.preload("chat", r111.getChatId(), r119.getThumbKey(), r119.getFsUnit(), r119.getCrypto());
    L46:
        r118 = null;
    L50:
        List<String> r120 = r108.getMediaIds();
        if (r120 == null) goto L78;
        List r121 = CollectionsKt.filterNotNull(r120);
        if (r121 == null) goto L78;
        Iterator r122 = r121.iterator();
    L56:
        if (r122.hasNext() == false) goto L78;
        String r123 = (String) r122.next();
        RichText.RichTextElements r124 = r108.getElements();
        if (r124 == null) goto L64;
        Map<String, RichTextElement> r125 = r124.getDictionary();
        if (r125 == null) goto L64;
        RichTextElement r126 = r125.get(r123);
        if (r126 == null) goto L64;
        RichTextElement.RichTextProperty r127 = r126.getProperty();
    L66:
        if ((r127 instanceof RichTextElement.MediaProperty) == false) goto L56;
        String r128 = r111.getChatId();
        RichTextElement.MediaProperty r129 = (RichTextElement.MediaProperty) r127;
        com.ss.android.lark.widget.richtext.Image r130 = r129.getOriginImage();
        if (r130 == null) goto L70;
        String r131 = r130.getKey();
    L71:
        ImagePreloadManager.preload("chat", r128, r131, r129.getFsUnit(), r129.getCrypto());
        goto L56
    L70:
        r131 = null;
    L64:
        r127 = null;
        goto L66
    L23:
        r105 = f.a.f416666a[r104.ordinal()];
    L78:
        CopyOnWriteArraySet<String> r132 = h.f416677a;
        Intrinsics.checkNotNullParameter(r111, "msg");
        String r133 = r111.getId();
        if (r111.isRemoved() == false) goto L81;
    L86:
        boolean r134 = true;
    L87:
        if (r134 == true) goto L89;
        return;
    L89:
        if (r111.getType() != Message.Type.MEDIA) goto L91;
    L92:
        r101 = true;
    L93:
        if (r101 == false) goto L111;
        CopyOnWriteArraySet<String> r135 = h.f416677a;
        if (r135.contains(r133) == true) goto L112;
        r135.add(r133);
        LarkPlayerUtils r136 = LarkPlayerUtils.f438652a;
        if (r133 == null) goto L113;
        CoreThreadPool.getSerialTaskHandler().post(new com.ss.android.lark.player.player.i(r133));
        return;
    L113:
        return;
    L112:
        return;
    L111:
        return;
    L91:
        if (r111.getType() != Message.Type.POST) goto L93;
    L81:
        if (r111.isRecalled() == true) goto L86;
        if (r111.isBurned() == true) goto L86;
        r134 = false;
        goto L87
    L5:
        if (r111.isRecalled() == true) goto L13;
        if (r111.isRemoved() == true) goto L13;
        if (r111.isBurned() == true) goto L13;
        if (r111.isSecret() == true) goto L13;
        r102 = true;
        goto L14
    }

    @JvmStatic
    public static final void b(List<? extends MessageInfo> r100) {
        Intrinsics.checkNotNullParameter(r100, "infoList");
        Log.i("MessageUpdateReceiver", "onUpdateMessageInfo, list size:" + r100.size());
        Iterator<T> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        a((MessageInfo) r101.next());
        goto L4
    }
}
