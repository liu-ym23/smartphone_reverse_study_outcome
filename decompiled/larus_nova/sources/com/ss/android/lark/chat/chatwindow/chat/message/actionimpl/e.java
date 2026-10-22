package com.ss.android.lark.chat.chatwindow.chat.message.actionimpl;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.chat.base.view.vo.message.MediaContentVO;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.image.ImageSet;
import com.ss.android.lark.chat.entity.media.MediaImageSet;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageIdentity;
import com.ss.android.lark.chat.entity.message.content.ImageContent;
import com.ss.android.lark.chat.entity.message.content.MediaContent;
import com.ss.android.lark.chat.entity.message.content.PostContent;
import com.ss.android.lark.chat.entity.message.content.StickerContent;
import com.ss.android.lark.chat.utils.v0;
import com.ss.android.lark.chat.utils.w;
import com.ss.android.lark.chat.utils.y0;
import com.ss.android.lark.image.entity.Image;
import com.ss.android.lark.widget.photo.preview.k;
import com.ss.android.lark.widget.photo.preview.utils.PhotoUtilsNew;
import com.ss.android.lark.widget.photopicker.animation.activitytransition.ActivityTransitionLauncher;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f412609a = 0;

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v17, types: [v5b.a] */
    /* JADX WARN: Type inference failed for: r7v10, types: [v5b.a] */
    /* JADX WARN: Type inference failed for: r7v14, types: [v5b.a] */
    /* JADX WARN: Type inference failed for: r7v18, types: [v5b.a] */
    /* JADX WARN: Type inference failed for: r9v12, types: [v5b.a] */
    public static void a(m2b.a r110, Activity r111, View r112, nya.a r113) {
        Intrinsics.checkNotNullParameter(r111, "activity");
        Intrinsics.checkNotNullParameter(r112, "itemView");
        Intrinsics.checkNotNullParameter(r113, "params");
        y6b.a<?> r100 = r113.f521285b;
        Scene r101 = Scene.Chat;
        ArrayList r102 = new ArrayList();
        List r103 = CollectionsKt.listOfNotNull(r100);
        Intrinsics.checkNotNullParameter(r103, "messageVoList");
        Intrinsics.checkNotNullParameter(r102, "imageSetList");
        ArrayList r104 = new ArrayList();
        Iterator r105 = r103.iterator();
    L3:
        boolean r114 = false;
        if (r105.hasNext() == false) goto L8;
        Object r106 = r105.next();
        if (CollectionsKt.listOf(new Message.Type[]{Message.Type.IMAGE, Message.Type.MEDIA, Message.Type.POST, Message.Type.STICKER}).contains(((y6b.a) r106).getType()) == false) goto L3;
        r104.add(r106);
        goto L3
    L8:
        Iterator r107 = r104.iterator();
    L9:
        ActivityTransitionLauncher.LocationInfo r115 = null;
        MediaContent r116 = null;
        String r117 = null;
        if (r107.hasNext() == false) goto L55;
        y6b.a r108 = (y6b.a) r107.next();
        Message.Type r118 = r108.getType();
        if (r118 == Message.Type.IMAGE) goto L13;
        if (r118 != Message.Type.MEDIA) goto L28;
        T r109 = r108.b();
        Intrinsics.checkNotNull(r109, "null cannot be cast to non-null type com.ss.android.lark.chat.base.view.vo.message.MediaContentVO");
        MediaImageSet r119 = com.ss.android.lark.parser.internal.d.a((MediaContentVO) r109);
        MessageIdentity r120 = new MessageIdentity(r108.getId(), r108.getChatId(), r108.I(), r108.J());
        r120.setHideStickerSave(false);
        r119.setMessageIdentity(r120);
        T r121 = r108.b().f553338a;
        if ((r121 instanceof MediaContent) == false) goto L25;
        r116 = (MediaContent) r121;
    L25:
        if (r116 == null) goto L9;
        r119.setResourceIsCleaned(r116.resourceIsCleaned());
        r119.setResourceCleanScene(r116.currentResourceScene());
        Intrinsics.checkNotNull(r119);
        r102.add(r119);
        goto L9
    L28:
        if (r118 != Message.Type.POST) goto L41;
        T r122 = r108.b().f553338a;
        Intrinsics.checkNotNull(r122, "null cannot be cast to non-null type com.ss.android.lark.chat.entity.message.content.PostContent");
        PostContent r123 = (PostContent) r122;
        if (r123.isGroupAnnouncement() == true) goto L9;
        RichText r124 = r123.getRichText();
        boolean r125 = r108.h();
        y6b.b r126 = r108.a();
        if (r126 == null) goto L35;
        r117 = r126.f566474w;
    L35:
        List r127 = CollectionsKt.filterNotNull(v0.e(r124, r125, r117));
        Iterator r128 = r127.iterator();
    L37:
        if (r128.hasNext() == false) goto L39;
        w.a((ImageSet) r128.next(), r108.N());
        goto L37
    L39:
        r102.addAll(r127);
        goto L9
    L41:
        if (r118 != Message.Type.STICKER) goto L9;
        T r129 = r108.b().f553338a;
        if ((r129 instanceof StickerContent) == false) goto L9;
        StickerContent r130 = (StickerContent) r129;
        String r131 = r130.getStickerSetId();
        if (r131 != null) goto L47;
    L50:
        boolean r132 = true;
    L51:
        if (r132 == false) goto L9;
        Image r133 = new Image();
        r133.setKey(r130.getKey());
        r133.setHeight(r130.getHeight());
        r133.setWidth(r130.getWidth());
        r133.setType(Image.Type.ENCRYPTED);
        r133.setResourceCleanScene(r130.currentResourceScene());
        r133.setResourceIsCleaned(r130.resourceIsCleaned());
        ImageSet r134 = new ImageSet();
        r134.setOrigin(r133);
        r134.setKey(r133.getKey());
        r134.setTranslated(false);
        r134.setResourceCleanScene(r130.currentResourceScene());
        r134.setResourceIsCleaned(r130.resourceIsCleaned());
        r102.add(r134);
        goto L9
    L47:
        if (r131.length() == 0) goto L50;
        r132 = false;
        goto L51
    L13:
        T r135 = r108.b().f553338a;
        Intrinsics.checkNotNull(r135, "null cannot be cast to non-null type com.ss.android.lark.chat.entity.message.content.ImageContent");
        ImageContent r136 = (ImageContent) r135;
        ImageSet r137 = r136.getImageSet();
        if (r137 == null) goto L16;
        r137.setResourceIsCleaned(r136.resourceIsCleaned());
    L16:
        if (r137 == null) goto L18;
        r137.setResourceCleanScene(r136.currentResourceScene());
    L18:
        if (r137 == null) goto L9;
        r102.add(r137);
        goto L9
    L55:
        int r138 = com.ss.android.lark.widget.photo.preview.utils.d.f447154a;
        if (r100 == null) goto L58;
        String r139 = r100.getId();
    L59:
        List r140 = com.ss.android.lark.widget.photo.preview.utils.d.b(r102, r139);
        if (((ArrayList) r140).isEmpty() == false) goto L62;
        return;
    L62:
        if (r100 == null) goto L64;
        Message.Type r141 = r100.getType();
    L66:
        if (r141 != Message.Type.POST) goto L74;
        T r142 = r100.b().f553338a;
        Intrinsics.checkNotNull(r142, "null cannot be cast to non-null type com.ss.android.lark.chat.entity.message.content.PostContent");
        PostContent r143 = (PostContent) r142;
        if (r143.isGroupAnnouncement() == true) goto L74;
        RichText r144 = r143.getRichText();
        Image r145 = r113.f521286c;
        String r146 = r100.getId();
        boolean r147 = r100.h();
        y6b.b r148 = r100.a();
        if (r148 == null) goto L72;
        String r149 = r148.f566474w;
    L73:
        PhotoItem r150 = v0.d(r144, r145, r146, r147, r149);
        PhotoUtilsNew r151 = PhotoUtilsNew.f447142a;
        int r152 = PhotoUtilsNew.g(r140, r150);
    L75:
        Rect r153 = r113.f521284a;
        if (r153 == null) goto L78;
        r115 = new ActivityTransitionLauncher.LocationInfo();
        int r154 = r153.left;
        r115.left = r154;
        int r155 = r153.top;
        r115.top = r155;
        r115.height = r153.bottom - r155;
        r115.width = r153.right - r154;
    L78:
        if (r110 == null) goto L82;
        Chat r156 = r110.getChat();
        if (r156 == null) goto L82;
        r114 = y0.c(r156);
    L82:
        int r157 = k.f446736a;
        k.c r158 = k.a.a(r140, r152, r112);
        r158.f446739c = r115;
        r158.d(r113.f521287d);
        r158.q(Biz.Messenger, r101, r113.f521288e);
        r158.f446737a.putString("preview_id", r113.f521289f);
        r158.f446737a.putString("msg_link_token", r113.f521290g);
        r158.h(r114);
        r158.r(r111);
        return;
    L72:
        r149 = null;
    L74:
        r152 = 0;
        goto L75
    L64:
        r141 = null;
        goto L66
    L58:
        r139 = null;
        goto L59
    }

    public static void b(m2b.a r100, View r101, Rect r102, y6b.a r103, Image r104, boolean r105, int r106) {
        Intrinsics.checkNotNullParameter(r100, "chatContext");
        Intrinsics.checkNotNullParameter(r101, "itemView");
        Intrinsics.checkNotNullParameter(r103, "messageVO");
        nya.a.C6993a r107 = new nya.a.C6993a();
        r107.f521291a = r102;
        r107.f521292b = r103;
        r107.f521293c = r104;
        r107.f521294d = false;
        r107.f521295e = r106;
        nya.a r108 = new nya.a(r107);
        a(r100, r100.getContext(), r101, r108);
    }
}
