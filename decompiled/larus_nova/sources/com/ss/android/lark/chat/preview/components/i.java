package com.ss.android.lark.chat.preview.components;

import androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.ss.android.lark.chat.preview.entity.component.property.LinearLayoutProperty;
import com.ss.android.lark.export.entity.preview.Padding;
import com.ss.android.lark.tangram.base.props.Props;
import com.ss.android.lark.tangram.base.style.TCStyle;
import com.ss.android.lark.tangram.engine.TangramNative;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class i extends s6c.c<LinearLayoutProperty> {
    @Override // s6c.a
    public final long c(int r100) {
        long r101 = TangramNative.newLinearLayoutNode();
        m(r101);
        Props r102 = this.f540884e;
        if ((r102 instanceof LinearLayoutProperty) == false) goto L21;
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type com.ss.android.lark.chat.preview.entity.component.property.LinearLayoutProperty");
        LinearLayoutProperty r103 = (LinearLayoutProperty) r102;
        Padding r104 = r103.getSidePadding();
        if (r104 == null) goto L7;
        float r105 = r104.getTop();
    L8:
        float r106 = r105;
        Padding r107 = r103.getSidePadding();
        if (r107 == null) goto L11;
        float r108 = r107.getLeft();
    L12:
        float r109 = r108;
        Padding r110 = r103.getSidePadding();
        if (r110 == null) goto L15;
        float r111 = r110.getBottom();
    L16:
        float r112 = r111;
        Padding r113 = r103.getSidePadding();
        if (r113 == null) goto L19;
        float r114 = r113.getRight();
    L20:
        TangramNative.setLinearLayoutPropsPadding(r101, r106, r109, r112, r114);
        TangramNative.setLinearLayoutPropsSpace(r101, r103.getSpacing());
        TangramNative.setLinearLayoutPropsOrientation(r101, r103.getOrientation().getValue());
        TangramNative.setLinearLayoutPropsAlign(r101, r103.getCrossAxisAlign().getValue());
        TangramNative.setLinearLayoutPropsJustify(r101, r103.getMainAxisJustify().getValue());
        TangramNative.setLinearLayoutPropsWrapWidth(r101, r103.getWrapWidth());
        goto L21
    L19:
        r114 = r103.getPadding();
        goto L20
    L15:
        r111 = r103.getPadding();
        goto L16
    L11:
        r108 = r103.getPadding();
        goto L12
    L7:
        r105 = r103.getPadding();
    L21:
        return r101;
    }

    public i(String r100, LinearLayoutProperty r101, TCStyle r102) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(AndroidComposeViewAccessibilityDelegateCompat.ClassName, "viewTypeIdentity");
        Intrinsics.checkNotNullParameter(r101, SlcElement.KEY_PROPS);
        super(r100, AndroidComposeViewAccessibilityDelegateCompat.ClassName, r101, r102);
    }
}
