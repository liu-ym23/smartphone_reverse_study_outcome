package qh8;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.list.expose.ExposureTrackerExtKt;
import com.larus.nova.R;
import com.ss.android.lark.imagewidget.subsampling.decoder.custom.MSkiaImageRegionDecoder;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes25.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f533009a = null;

    public static final class a implements com.larus.business.markdown.api.extplugin.image.b {
        @Override // com.larus.business.markdown.api.extplugin.image.b
        public final void b() {
        }

        public a() {
        }

        @Override // com.larus.business.markdown.api.extplugin.image.b
        public final void a(com.larus.business.markdown.api.extplugin.image.g r100) {
            Intrinsics.checkNotNullParameter(r100, "info");
        }

        /* JADX WARN: Type inference failed for: r10v0, types: [T, kotlin.jvm.functions.Function0, qh8.a] */
        @Override // com.larus.business.markdown.api.extplugin.image.b
        public final void c(final com.larus.business.markdown.api.extplugin.image.g r110) {
            Intrinsics.checkNotNullParameter(r110, "info");
            View r100 = r110.f320467a;
            if ((r100 instanceof SimpleDraweeView) == false) goto L5;
            final SimpleDraweeView r101 = (SimpleDraweeView) r100;
        L6:
            if (r101 != null) goto L8;
            return;
        L8:
            final Context r102 = r101.getContext();
            a r103 = k.f533009a;
            if (k.a(r110.f320469c.getUrl()) == false) goto L12;
            r101.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
            r101.getHierarchy().setActualImageColorFilter(null);
            r101.setOnClickListener(null);
            r101.setActualImageResource(R.drawable.larus_flow_markdown_image_local);
            return;
        L12:
            final Ref.ObjectRef r104 = new Ref.ObjectRef();
            KeyEvent.Callback r105 = r110.f320468b;
            if ((r105 instanceof rt8.a) == false) goto L15;
            rt8.a r106 = (rt8.a) r105;
        L16:
            if (r106 == null) goto L20;
            Map<String, Object> r107 = r106.getPayload();
            if (r107 == null) goto L20;
            final fh8.f r108 = fh8.h.b(r107);
        L21:
            final fh8.f r109 = r108;
            ?? r111 = new qh8.a(r109, r110, r101, r102, this, r104);
            r104.element = r111;
            r111.invoke();
            com.larus.business.markdown.api.extplugin.image.f r112 = (com.larus.business.markdown.api.extplugin.image.f) CollectionsKt.firstOrNull(r110.f320471e);
            boolean r113 = false;
            if (r112 == null) goto L28;
            String r114 = r112.f320464a;
            if (r114 == null) goto L28;
            if (StringsKt.contains$default(r114, com.bytedance.android.ec.core.event.a.KEY_CARD_TYPE, false, 2, null) == true) goto L28;
            r113 = true;
        L28:
            if (r113 == true) goto L32;
            ExposureTrackerExtKt.a(r110.f320467a, new b(r110, r108, this));
            return;
        L32:
            return;
        L20:
            r108 = null;
            goto L21
        L15:
            r106 = null;
            goto L16
        L5:
            r101 = null;
            goto L6
        }
    }

    public k() {
    }

    static {
        f533009a = new a();
    }

    public static final boolean a(String r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (StringsKt.startsWith(r100, MSkiaImageRegionDecoder.FILE_PREFIX, true) != true) goto L6;
        return true;
    }
}
