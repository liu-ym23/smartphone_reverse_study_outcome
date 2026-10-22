package com.ss.android.lark.export.flexlayout;

import androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.ss.android.lark.export.entity.preview.Padding;
import com.ss.android.lark.tangram.base.props.Props;
import com.ss.android.lark.tangram.base.style.TCStyle;
import com.ss.android.lark.tangram.engine.TangramNative;
import kotlin.jvm.internal.Intrinsics;
import s6c.c;

/* JADX INFO: loaded from: classes35.dex */
public final class a extends c<FlexLayoutProperty> {

    /* JADX INFO: renamed from: com.ss.android.lark.export.flexlayout.a$a, reason: collision with other inner class name */
    public static final class C4958a {
    }

    static {
    }

    @Override // s6c.a
    public final long c(int r100) {
        long r101 = TangramNative.newFlexLayoutNode();
        m(r101);
        Props r102 = this.f540884e;
        if ((r102 instanceof FlexLayoutProperty) == false) goto L14;
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type com.ss.android.lark.export.flexlayout.FlexLayoutProperty");
        FlexLayoutProperty r103 = (FlexLayoutProperty) r102;
        TangramNative.setFlexLayoutPropsAlign(r101, r103.getCrossAxisAlign().getValue());
        TangramNative.setFlexLayoutPropsCrossAxisSpace(r101, r103.getCrossAxisSpacing());
        TangramNative.setFlexLayoutPropsMainAxisSpace(r101, r103.getMainAxisSpacing());
        if (r100 > 378) goto L7;
    L9:
        TangramNative.setFlexLayoutPropsFlexWrap(r101, r103.getFlexWrap().getValue());
    L10:
        TangramNative.setFlexLayoutPropsJustify(r101, r103.getMainAxisJustify().getValue());
        TangramNative.setFlexLayoutPropsOrientation(r101, r103.getOrientation().getValue());
        Padding r104 = r103.getPadding();
        if (r104 != null) goto L13;
        r104 = new Padding(0.0f, 0.0f, 0.0f, 0.0f);
    L13:
        TangramNative.setFlexLayoutPropsPadding(r101, r104.getTop(), r104.getLeft(), r104.getBottom(), r104.getRight());
        goto L14
    L7:
        if (r103.getForceUseCompactMode() == true) goto L9;
        TangramNative.setFlexLayoutPropsFlexWrap(r101, FlexLayoutProperty.FlexWrap.NO_WRAP.getValue());
    L14:
        return r101;
    }

    public a(String r100, FlexLayoutProperty r101, TCStyle r102) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(AndroidComposeViewAccessibilityDelegateCompat.ClassName, "viewTypeIdentity");
        Intrinsics.checkNotNullParameter(r101, SlcElement.KEY_PROPS);
        super(r100, AndroidComposeViewAccessibilityDelegateCompat.ClassName, r101, r102);
    }
}
