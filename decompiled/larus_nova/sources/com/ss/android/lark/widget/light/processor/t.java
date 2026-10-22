package com.ss.android.lark.widget.light.processor;

import android.content.Context;
import android.text.style.ClickableSpan;
import android.view.View;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.light.span.ImageClickSpan;
import com.ss.android.lark.widget.light.span.NoPreviewPlaceHolderSpan;
import com.ss.android.lark.widget.span.ImageInfo;
import com.ss.android.lark.widget.span.MediaInfo;
import com.ss.android.lark.widget.span.SpanInfo;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class t implements j<SpanInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f446190a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Unit> f446191b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f446192a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f446193b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f446194c;

        public final String toString() {
            return "NoPreviewDrawableConfig(borderRadius=" + this.f446192a + ", borderWidth=" + this.f446193b + ", useImageOriginSize=" + this.f446194c + ')';
        }

        public final int hashCode() {
            int r100 = ((Float.floatToIntBits(this.f446192a) * 31) + Float.floatToIntBits(this.f446193b)) * 31;
            if (this.f446194c == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public a() {
            this.f446192a = 0.0f;
            this.f446193b = 0.0f;
            this.f446194c = true;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 == null) goto L8;
            Class<?> r101 = r100.getClass();
        L10:
            if (Intrinsics.areEqual(a.class, r101) == true) goto L12;
            return false;
        L12:
            Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.ss.android.lark.widget.light.processor.NoPreviewCoverSpanProcessor.NoPreviewDrawableConfig");
            a r102 = (a) r100;
            if (this.f446192a != r102.f446192a) goto L15;
            boolean r103 = true;
        L16:
            if (r103 == true) goto L19;
            return false;
        L19:
            if (this.f446193b != r102.f446193b) goto L21;
            boolean r104 = true;
        L22:
            if (r104 == true) goto L25;
            return false;
        L25:
            if (this.f446194c == r102.f446194c) goto L27;
            return false;
        L27:
            return true;
        L21:
            r104 = false;
            goto L22
        L15:
            r103 = false;
            goto L16
        L8:
            r101 = null;
            goto L10
        }
    }

    public static final class b extends ClickableSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ t f446195a;

        public b(t r100) {
            this.f446195a = r100;
        }

        @Override // android.text.style.ClickableSpan
        public final void onClick(View r100) {
            Intrinsics.checkNotNullParameter(r100, "widget");
            if (r100.getTag(R.id.tag_long_press) == null) goto L6;
            r100.setTag(R.id.tag_long_press, null);
            return;
        L6:
            Function0<Unit> r101 = this.f446195a.f446191b;
            if (r101 == null) goto L10;
            r101.invoke();
            return;
        }
    }

    public t(String r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "noPreviewText");
        this.f446190a = r100;
        this.f446191b = r101;
    }

    @Override // com.ss.android.lark.widget.light.processor.j
    public final void a(Context r100, ncc.g r110, SpanInfo r111, com.ss.android.lark.widget.light.e r112) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, "spanBuilder");
        Intrinsics.checkNotNullParameter(r111, "spanInfo");
        Intrinsics.checkNotNullParameter(r112, "params");
        a r101 = r112.N;
        if (r101 == null) goto L7;
        boolean r102 = true;
        if (r101.f446194c != true) goto L7;
    L9:
        if (r102 == false) goto L23;
        float r103 = 0.0f;
        if (r101 == null) goto L13;
        float r104 = r101.f446192a;
    L14:
        if (r101 == null) goto L16;
        r103 = r101.f446193b;
    L16:
        NoPreviewPlaceHolderSpan.b.a r105 = new NoPreviewPlaceHolderSpan.b.a();
        NoPreviewPlaceHolderSpan.DrawableSizeType r106 = NoPreviewPlaceHolderSpan.DrawableSizeType.DYNAMIC_SIZE;
        Intrinsics.checkNotNullParameter(r106, "sizeType");
        r105.f446222d = r106;
        String r107 = this.f446190a;
        Intrinsics.checkNotNullParameter(r107, AppConstants.BUNDLE_TIP);
        r105.f446219a = r107;
        r105.f446221c = r104;
        r105.f446220b = r103;
        if ((r111 instanceof MediaInfo) == false) goto L20;
        MediaInfo r108 = (MediaInfo) r111;
        r105.f446223e = r108.width;
        r105.f446224f = r108.height;
    L22:
        NoPreviewPlaceHolderSpan.b r109 = r105.a();
    L34:
        Object r113 = new NoPreviewPlaceHolderSpan(r100, r109);
        String r114 = r111.text;
        r110.b(r114, r113, 33);
        int r115 = r110.length();
        int r116 = r115 - r114.length();
        if (r112.C == true) goto L37;
    L39:
        Object r117 = new b(this);
    L40:
        r110.setSpan(r117, r116, r115, 33);
        return;
    L37:
        if ((r111 instanceof ImageInfo) == false) goto L39;
        r117 = new ImageClickSpan((ImageInfo) r111, null);
        goto L40
    L20:
        if ((r111 instanceof ImageInfo) == false) goto L22;
        ImageInfo r118 = (ImageInfo) r111;
        r105.f446223e = r118.width;
        r105.f446224f = r118.height;
        NoPreviewPlaceHolderSpan.c r119 = new NoPreviewPlaceHolderSpan.c(r118.itemLeftMargin, 0, 0, 0);
        Intrinsics.checkNotNullParameter(r119, GXTemplateKey.FLEXBOX_MARGIN);
        r105.f446226h = r119;
        goto L22
    L13:
        r104 = 0.0f;
        goto L14
    L23:
        NoPreviewPlaceHolderSpan.b.a r120 = new NoPreviewPlaceHolderSpan.b.a();
        NoPreviewPlaceHolderSpan.DrawableSizeType r121 = NoPreviewPlaceHolderSpan.DrawableSizeType.FIX_SIZE;
        Intrinsics.checkNotNullParameter(r121, "sizeType");
        r120.f446222d = r121;
        String r122 = this.f446190a;
        Intrinsics.checkNotNullParameter(r122, AppConstants.BUNDLE_TIP);
        r120.f446219a = r122;
        r120.f446221c = UIHelper.dp2px(8.0f);
        r120.f446220b = UIHelper.dp2px(1.0f);
        if ((r111 instanceof ImageInfo) == false) goto L27;
        NoPreviewPlaceHolderSpan.c r123 = new NoPreviewPlaceHolderSpan.c(((ImageInfo) r111).itemLeftMargin, 0, 0, 0);
        Intrinsics.checkNotNullParameter(r123, GXTemplateKey.FLEXBOX_MARGIN);
        r120.f446226h = r123;
    L27:
        if ((r111 instanceof MediaInfo) == true) goto L29;
    L33:
        r109 = r120.a();
        goto L34
    L29:
        if (r112.I == true) goto L33;
        int r124 = r112.f445982J;
        if (r124 <= 0) goto L33;
        r120.f446225g = r124;
    L7:
        r102 = false;
        goto L9
    }
}
