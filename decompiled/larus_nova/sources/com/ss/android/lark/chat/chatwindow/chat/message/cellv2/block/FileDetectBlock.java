package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.ss.android.lark.chat.base.view.vo.message.FileContentVO;
import com.ss.android.lark.chat.base.view.vo.message.ImageContentVO;
import com.ss.android.lark.chat.base.view.vo.message.MediaContentVO;
import com.ss.android.lark.chat.base.view.vo.message.PostContentVO;
import com.ss.android.lark.chat.entity.message.MessageDLPState;
import com.ss.android.lark.chat.entity.message.content.FileContent;
import com.ss.android.lark.chat.entity.message.content.ImageContent;
import com.ss.android.lark.chat.entity.message.content.MediaContent;
import com.ss.android.lark.chat.entity.message.content.PostContent;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Blocks;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Slots;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class FileDetectBlock extends com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b<y6b.a<?>, Object> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final IMMessageKeys$Blocks f412755g;

    @Override // com.ss.android.lark.blueprint.i
    public final com.ss.android.lark.blueprint.j getKey() {
        return this.f412755g;
    }

    public FileDetectBlock(com.ss.android.lark.blueprint.g r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        super(r100);
        this.f412755g = IMMessageKeys$Blocks.FILE_DETECT;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b, com.ss.android.lark.blueprint.i
    public final void a(com.ss.android.lark.blueprint.m<y6b.a<?>> r100, com.ss.android.lark.blueprint.q<y6b.a<?>> r101) {
        Intrinsics.checkNotNullParameter(r100, LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL);
        Intrinsics.checkNotNullParameter(r101, "layout");
        com.ss.android.lark.blueprint.i.a.a(r100, r101);
        g(r101, this.f412755g, IMMessageKeys$Slots.BOTTOM);
    }

    public void update(com.ss.android.lark.blueprint.m<y6b.a<?>> r100, com.ss.android.lark.blueprint.q<y6b.a<?>> r101, y6b.a<?> r102) {
        Intrinsics.checkNotNullParameter(r100, LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL);
        Intrinsics.checkNotNullParameter(r101, "layout");
        Intrinsics.checkNotNullParameter(r102, "data");
        Object r103 = r102.b();
        boolean r104 = false;
        if ((r103 instanceof FileContentVO) == false) goto L14;
        ArrayList<String> r105 = ((FileContent) ((FileContentVO) r103).f553338a).getRiskObjectKeys();
        if (r105 != null) goto L7;
    L10:
        boolean r106 = true;
    L11:
        if (r106 == false) goto L45;
    L46:
        boolean r107 = false;
    L48:
        if (r102.h() == true) goto L50;
    L52:
        boolean r108 = false;
    L53:
        if (r108 == true) goto L56;
        if (r107 == false) goto L56;
        r104 = true;
    L56:
        if (r104 == true) goto L59;
        g(r101, this.f412755g, IMMessageKeys$Slots.BOTTOM);
        return;
    L59:
        r101.c(this.f412755g, IMMessageKeys$Slots.BOTTOM, new AnonymousClass1(this));
        return;
    L50:
        if (MessageDLPState.BLOCK != r102.t()) goto L52;
        r108 = true;
    L45:
        r107 = true;
        goto L48
    L7:
        if (r105.isEmpty() == true) goto L10;
        r106 = false;
        goto L11
    L14:
        if ((r103 instanceof PostContentVO) == false) goto L25;
        ArrayList<String> r109 = ((PostContent) ((PostContentVO) r103).f553338a).getRiskObjectKeys();
        if (r109 != null) goto L18;
    L21:
        boolean r110 = true;
    L22:
        if (r110 == true) goto L46;
    L18:
        if (r109.isEmpty() == true) goto L21;
        r110 = false;
        goto L22
    L25:
        if ((r103 instanceof MediaContentVO) == false) goto L36;
        ArrayList<String> r111 = ((MediaContent) ((MediaContentVO) r103).f553338a).getRiskObjectKeys();
        if (r111 != null) goto L29;
    L32:
        boolean r112 = true;
    L33:
        if (r112 == true) goto L46;
    L29:
        if (r111.isEmpty() == true) goto L32;
        r112 = false;
        goto L33
    L36:
        if ((r103 instanceof ImageContentVO) == false) goto L46;
        ArrayList<String> r113 = ((ImageContent) ((ImageContentVO) r103).f553338a).getRiskObjectKeys();
        if (r113 != null) goto L40;
    L43:
        boolean r114 = true;
    L44:
        if (r114 == true) goto L46;
    L40:
        if (r113.isEmpty() == true) goto L43;
        r114 = false;
        goto L44
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b, com.ss.android.lark.blueprint.i
    public /* bridge */ /* synthetic */ void update(com.ss.android.lark.blueprint.m r100, com.ss.android.lark.blueprint.q r101, Object r102) {
        update(r100, r101, (y6b.a) r102);
    }
}
