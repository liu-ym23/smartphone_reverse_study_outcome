package com.larksuite.component.card.component.image;

import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.google.gson.Gson;
import com.larksuite.component.card.component.g;
import com.larksuite.component.card.protocol.data.CardAttachment;
import com.larksuite.component.card.protocol.data.CardContent;
import com.larksuite.component.card.utils.k;
import com.larksuite.framework.utils.DeviceUtils;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.shadow.LayoutNode;
import com.lynx.tasm.behavior.shadow.MeasureMode;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.widget.richtext.RichTextElement;
import idb.f;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import y6a.h;
import y6a.i;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 (2\u00020\u00012\u00020\u0002:\u0001(B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\r\u001a\u00020\u000eH\u0002J(\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0006H\u0016J6\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0012\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0013\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001c\u001a\u00020\fH\u0002J\u0010\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u0012\u0010 \u001a\u00020\u000e2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0002J\u001e\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010\"2\b\u0010&\u001a\u0004\u0018\u00010'H\u0002R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0007R\u0012\u0010\b\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0007R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/larksuite/component/card/component/image/UniversalCardImageShadowNode;", "Lcom/lynx/tasm/behavior/shadow/ShadowNode;", "Lcom/lynx/tasm/behavior/shadow/MeasureFunc;", "<init>", "()V", "originWidth", "", "Ljava/lang/Integer;", "originHeight", "imageId", "", "hasValidAttachmentImages", "", "initMeasureFunction", "", "onLayout", "left", "top", "width", "height", "measure", "", "node", "Lcom/lynx/tasm/behavior/shadow/LayoutNode;", "", "widthMode", "Lcom/lynx/tasm/behavior/shadow/MeasureMode;", "heightMode", "enableInvalidImageFix", "setContent", SlcElement.KEY_PROPS, "Lcom/lynx/react/bridge/ReadableMap;", "filterInvalidImages", "imageContent", "Lcom/larksuite/component/card/component/image/ImageContentProps;", "getJsonAttachment", "Lcom/larksuite/component/card/protocol/data/CardAttachment;", "imageContentProps", "cardShareData", "Lcom/larksuite/component/card/cardcontainer/UniversalCardShareData;", "Companion", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UniversalCardImageShadowNode extends ShadowNode implements h {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Integer f283377v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Integer f283378w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f283379x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f283380y;

    public static final class a {
    }

    static {
    }

    public UniversalCardImageShadowNode() {
        this.f283377v = 0;
        this.f283378w = 0;
        this.f283380y = true;
        i(this);
    }

    @LynxProp(name = SlcElement.KEY_PROPS)
    public final void setContent(ReadableMap r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_PROPS);
        TraceEvent.beginSection("UniversalCardImageShadowNode.setContent");
        RichTextElement.ImageProperty r101 = null;
        Gson r102 = g.f283368a;     // Catch: Throwable -> L5
        com.larksuite.component.card.component.image.a r103 = (com.larksuite.component.card.component.image.a) g.c(r100, com.larksuite.component.card.component.image.a.class);     // Catch: Throwable -> L5
    L7:
        if (r103 != null) goto L10;
        Log.e("MsgCardImageShadowNode", "setContent fail, content is empty");
        return;
    L10:
        this.f283377v = r103.h();
        this.f283378w = r103.g();
        String r104 = r103.e();
        this.f283379x = r104;
        LynxContext r105 = this.f382220m;
        boolean r106 = true;
        if (r105 == null) goto L34;
        if (r104 == null) goto L34;
        Object r107 = r105.getSharedData("card_share_data");
        if ((r107 instanceof com.larksuite.component.card.cardcontainer.c) == false) goto L16;
        com.larksuite.component.card.cardcontainer.c r108 = (com.larksuite.component.card.cardcontainer.c) r107;
    L17:
        if (r108 != null) goto L20;
    L24:
        CardAttachment r109 = null;
    L26:
        if (r109 == null) goto L30;
        HashMap<String, RichTextElement.ImageProperty> r110 = r109.getImages();
        if (r110 == null) goto L30;
        r101 = r110.get(r104);
    L30:
        if (r101 != null) goto L33;
        r106 = false;
    L33:
        this.f283380y = r106;
    L35:
        TraceEvent.endSection("UniversalCardImageShadowNode.setContent");
        return;
    L20:
        if (r103.m() == false) goto L25;
        CardContent r111 = r108.f283234b.getTranslateContent();
        if (r111 == null) goto L24;
        r109 = r111.getAttachment();
        goto L26
    L25:
        r109 = r108.f283234b.getCardContent().getAttachment();
        goto L26
    L16:
        r108 = null;
    L34:
        this.f283380y = true;
    L5:
        th = move-exception;
        Log.e("MsgCardImageShadowNode", "props from lynx transform failed", th);
        r103 = null;
        goto L7
    }

    @Override // com.lynx.tasm.behavior.shadow.LayoutNode
    public final void f(int r100, int r101) {
        TraceEvent.beginSection("UniversalCardImageShadowNode.onLayout");
        this.f382206e = false;
        TraceEvent.endSection("UniversalCardImageShadowNode.onLayout");
    }

    @Override // y6a.h
    public final long c(LayoutNode r100, float r101, MeasureMode r102, float r103, MeasureMode r104) {
        TraceEvent.beginSection("UniversalCardImageShadowNode.measure");
        Integer r105 = this.f283377v;
        if (r105 == null) goto L20;
        int r106 = r105.intValue();
        Integer r107 = this.f283378w;
        if (r107 == null) goto L20;
        int r108 = r107.intValue();
        MeasureMode r109 = MeasureMode.UNDEFINED;
        if (r102 != r109) goto L11;
        if (r104 != r109) goto L11;
        TraceEvent.endSection("UniversalCardImageShadowNode.measure");
        return i.b(r106, r108);
    L11:
        if (r102 == r109) goto L15;
        if (r104 != r109) goto L15;
        TraceEvent.endSection("UniversalCardImageShadowNode.measure");
        return i.a(r101, r101 / (r106 / r108));
    L15:
        if (r102 != r109) goto L18;
        TraceEvent.endSection("UniversalCardImageShadowNode.measure");
        return i.a((r106 / r108) * r103, r103);
    L18:
        TraceEvent.endSection("UniversalCardImageShadowNode.measure");
        return i.a(r101, r103);
    L20:
        TraceEvent.endSection("UniversalCardImageShadowNode.measure");
        if ((!f.a().isCurrentEnable("openplatform.universalcard.invalid_image_fix.disable")) == false) goto L25;
        if (this.f283380y == true) goto L25;
    L34:
        return i.a(r101, r103);
    L25:
        if (k.b(this.f283379x) == false) goto L34;
        MeasureMode r110 = MeasureMode.UNDEFINED;
        if (r104 != r110) goto L29;
        r103 = 32767.0f;
    L29:
        if (r102 != r110) goto L32;
        r101 = DeviceUtils.getScreenWidth(LarkContext.getApplication());
    L32:
        return i.a(r101, r103);
    }
}
