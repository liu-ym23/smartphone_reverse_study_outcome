package com.larus.chat.gallery.impl.preview.toolbar;

import com.baidu.platform.comapi.map.MapController;
import com.larus.chat.gallery.impl.preview.data.SourceType;
import com.larus.common.apphost.AppHost;
import com.larus.gallery.api.GalleryType;
import com.larus.nova.R;
import com.larus.platform.service.n0;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes26.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<SourceType, Set<ToolbarButtonType>> f324813a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f324814b = 0;

    public k() {
    }

    static {
        SourceType r100 = SourceType.USER_SEND;
        ToolbarButtonType r101 = ToolbarButtonType.SHARE;
        ToolbarButtonType r102 = ToolbarButtonType.DOWNLOAD;
        ToolbarButtonType r103 = ToolbarButtonType.MARK;
        SourceType r104 = SourceType.BOT_RESP;
        ToolbarButtonType[] r110 = {r101, r102, r103, ToolbarButtonType.VIEW_SOURCE};
        SourceType r105 = SourceType.CREATION_CARD;
        ToolbarButtonType r111 = ToolbarButtonType.PUBLISH;
        ToolbarButtonType r112 = ToolbarButtonType.SET_PRIVATE;
        ToolbarButtonType r113 = ToolbarButtonType.WATERMARK;
        ToolbarButtonType[] r114 = {r101, r102, r103, r111, r112, r113};
        SourceType r106 = SourceType.CREATION_RECORD;
        ToolbarButtonType r115 = ToolbarButtonType.DELETE;
        ToolbarButtonType[] r116 = {r101, r102, r103, r111, r112, r115, r113};
        SourceType r107 = SourceType.ALBUM;
        ToolbarButtonType r117 = ToolbarButtonType.CROP;
        f324813a = MapsKt.mapOf(new Pair[]{TuplesKt.to(r100, SetsKt.setOf(new ToolbarButtonType[]{r101, r102, r103})), TuplesKt.to(r104, SetsKt.setOf(r110)), TuplesKt.to(r105, SetsKt.setOf(r114)), TuplesKt.to(r106, SetsKt.setOf(r116)), TuplesKt.to(r107, SetsKt.setOf(new ToolbarButtonType[]{r103, r117, ToolbarButtonType.SELECT})), TuplesKt.to(SourceType.ATTACHMENT, SetsKt.setOf(new ToolbarButtonType[]{r103, r117})), TuplesKt.to(SourceType.CAMERA_RESULT, SetsKt.setOf(new ToolbarButtonType[]{r103, r117, r102})), TuplesKt.to(SourceType.CLOUD_DRIVE, SetsKt.setOf(new ToolbarButtonType[]{r103, r101, r102, ToolbarButtonType.RENAME, ToolbarButtonType.MOVE, r115}))});
        f324814b = R.string.larus_album_select_btn;
    }

    public static j a(j r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r110, MapController.ITEM_LAYER_TAG);
        if (r111 == false) goto L5;
        int r100 = R.drawable.larus_preview_toolbar_select_done_fill;
    L6:
        if (r111 == false) goto L8;
        int r101 = R.drawable.larus_preview_toolbar_select_done_fill;
    L9:
        if (r111 == false) goto L11;
        int r102 = R.string.larus_accessibility_photoDetail_selected;
    L13:
        return j.a(r110, r100, r101, r102, false, false, MapsKt.plus(r110.f324812i, TuplesKt.to("selected", Boolean.valueOf(r111))), 225);
    L11:
        r102 = f324814b;
        goto L13
    L8:
        r101 = R.drawable.larus_preview_toolbar_select_done;
        goto L9
    L5:
        r100 = R.drawable.larus_preview_toolbar_select_done;
        goto L6
    }

    public static boolean b(ToolbarButtonType r100, SourceType r101, boolean r102, GalleryType r103, String r104, boolean r105) {
        Set<ToolbarButtonType> r106 = f324813a.get(r101);
        if (r106 != null) goto L6;
        r106 = SetsKt.emptySet();
    L6:
        if (r100 != ToolbarButtonType.MORE) goto L9;
        return true;
    L9:
        if (r106.contains(r100) == true) goto L12;
    L48:
        return false;
    L12:
        if (r100 != ToolbarButtonType.VIEW_SOURCE) goto L21;
        if (r104 != null) goto L15;
    L18:
        boolean r107 = true;
    L19:
        if (r107 == false) goto L21;
    L15:
        if (StringsKt.isBlank(r104) == true) goto L18;
        r107 = false;
    L21:
        ToolbarButtonType r108 = ToolbarButtonType.PUBLISH;
        if (r100 == r108) goto L26;
        if (r100 == ToolbarButtonType.SET_PRIVATE) goto L26;
    L30:
        ToolbarButtonType r109 = ToolbarButtonType.MARK;
        if (r100 == r109) goto L35;
        if (r100 == ToolbarButtonType.CROP) goto L35;
    L37:
        if (r100 != r109) goto L39;
    L40:
        if (r105 == true) goto L48;
    L42:
        if (r100 != r108) goto L46;
        if (r102 == true) goto L48;
    L46:
        if (r100 != ToolbarButtonType.SET_PRIVATE) goto L50;
        if (r102 == false) goto L48;
        return true;
    L50:
        return true;
    L39:
        if (r100 != ToolbarButtonType.CROP) goto L42;
    L35:
        if (r103 != GalleryType.Video) goto L37;
    L26:
        if (AppHost.f326268a.isOversea() == true) goto L48;
        if (n0.f365775a.b() == false) goto L30;
        goto L30
    }
}
