package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import android.view.View;
import android.widget.LinearLayout;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.larksuite.component.ui.layout.LKUIRoundableLayout;
import com.ss.android.lark.chat.base.view.vo.message.BaseTextContentVO;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Blocks;
import com.ss.android.lark.chat.open.message.IMMessageKeys$Slots;
import com.ss.android.lark.chatwindow.view.preview.UrlPreviewBinder;
import com.ss.android.lark.export.entity.PreviewHangPoint;
import com.ss.android.lark.widget.richtext.RichText;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class UrlPreviewContentBlock extends com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b<y6b.a<?>, Object> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final IMMessageKeys$Blocks f413064g;

    public static final class a implements UrlPreviewBinder.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ mya.f f413065a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ y6b.a<?> f413066b;

        public a(mya.f r100, y6b.a<?> r101) {
            this.f413065a = r100;
            this.f413066b = r101;
        }

        @Override // com.ss.android.lark.chatwindow.view.preview.UrlPreviewBinder.c
        public final boolean a(LKUIRoundableLayout r100, PreviewHangPoint r101) {
            Intrinsics.checkNotNullParameter(r100, "view");
            Intrinsics.checkNotNullParameter(r101, "previewHangPoint");
            return this.f413065a.h(r100, r101, this.f413066b.getId());
        }
    }

    public static final class b implements View.OnLongClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.ss.android.lark.blueprint.m<y6b.a<?>> f413067a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ UrlPreviewContentBlock f413068b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ y6b.a<?> f413069c;

        public b(com.ss.android.lark.blueprint.m<y6b.a<?>> r100, UrlPreviewContentBlock r101, y6b.a<?> r102) {
            this.f413067a = r100;
            this.f413068b = r101;
            this.f413069c = r102;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r100) {
            com.ss.android.lark.blueprint.m<y6b.a<?>> r101 = this.f413067a;
            if ((r101 instanceof e6b.b) == false) goto L5;
            e6b.b r102 = (e6b.b) r101;
        L6:
            if (r102 != null) goto L10;
            return false;
        L10:
            return r102.e(this.f413068b, this.f413069c);
        L5:
            r102 = null;
            goto L6
        }
    }

    public static final class c implements b3b.t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f413070a = null;

        static {
            f413070a = new c();
        }

        public c() {
        }

        @Override // b3b.t
        public final void E(String r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
        }
    }

    @Override // com.ss.android.lark.blueprint.i
    public final com.ss.android.lark.blueprint.j getKey() {
        return this.f413064g;
    }

    public UrlPreviewContentBlock(com.ss.android.lark.blueprint.g r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        super(r100);
        this.f413064g = IMMessageKeys$Blocks.URL_PREVIEW_CONTENT;
    }

    public void update(com.ss.android.lark.blueprint.m<y6b.a<?>> r100, com.ss.android.lark.blueprint.q<y6b.a<?>> r110, y6b.a<?> r111) {
        Intrinsics.checkNotNullParameter(r100, LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL);
        Intrinsics.checkNotNullParameter(r110, "layout");
        Intrinsics.checkNotNullParameter(r111, "data");
        Object r101 = r111.b();
        if ((r101 instanceof BaseTextContentVO) == false) goto L5;
        BaseTextContentVO r102 = (BaseTextContentVO) r101;
    L6:
        if (r102 != null) goto L9;
        r110.o(this.f413064g, IMMessageKeys$Slots.CONTENT);
        return;
    L9:
        LinearLayout r112 = (LinearLayout) r110.c(IMMessageKeys$Blocks.URL_PREVIEW_CONTENT, IMMessageKeys$Slots.CONTENT, new UrlPreviewContentBlock$update$rootLayout$1(this)).getView();
        com.ss.android.lark.chatwindow.view.preview.i.b(r102.C);
        UrlPreviewBinder r103 = new UrlPreviewBinder(getContext(), new b(r100, this, r111), new f3b.d(r111, this.f412673c.getChat(), this.f412673c.x8()), this.f412673c, c.f413070a);
        Map<String, PreviewHangPoint> r104 = r102.C;
        Map<String, xcb.b> r105 = r102.B;
        RichText r106 = r102.g();
        if (r106 == null) goto L12;
        List<String> r107 = j6b.k.a(r106, r102.C);
    L13:
        h2b.c r108 = new h2b.c(r104, r105, r107, false);
        List r109 = this.f412673c.j5().c(mya.f.class);
        if ((!r109.isEmpty()) == false) goto L16;
        r103.f417004h = new a((mya.f) CollectionsKt.first(r109), r111);
    L16:
        Intrinsics.checkNotNullParameter(r112, "parent");
        r103.c(r108, new UrlPreviewBinder.b(r112));
        return;
    L12:
        r107 = CollectionsKt.emptyList();
        goto L13
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.b, com.ss.android.lark.blueprint.i
    public /* bridge */ /* synthetic */ void update(com.ss.android.lark.blueprint.m r100, com.ss.android.lark.blueprint.q r101, Object r102) {
        update(r100, r101, (y6b.a) r102);
    }
}
