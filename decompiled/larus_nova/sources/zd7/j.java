package zd7;

import android.app.Activity;
import com.bytedance.android.anniex.ability.service.IAnnieXCustomActivityService;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostMediaDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XBaseRuntime;
import java.util.List;
import java.util.Locale;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "x.chooseMedia")
public final class j extends yd7.c {
    public j() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r210, XBaseParamModel r211, CompletionBlock r212) {
        yd7.c.e r100 = (yd7.c.e) r211;
        Intrinsics.checkNotNullParameter(r210, "bridgeContext");
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r212, "callback");
        String r101 = r100.getSourceType();
        String r102 = r100.getCameraType();
        if (r102 != null) goto L5;
        r102 = "back";
    L5:
        Locale r103 = Locale.ROOT;
        if (r101 == null) goto L113;
        if (Intrinsics.areEqual(r101.toLowerCase(r103), "camera") == true) goto L10;
    L15:
        Activity r104 = r210.getOwnerActivity();
        if (r104 != null) goto L18;
        CompletionBlock.DefaultImpls.onFailure$default(r212, 0, "Context not provided in host", null, 4, null);
        return;
    L18:
        List<String> r105 = r100.getMediaType();
        List<String> r106 = r100.getMediaTypes();
        List<String> r107 = r105;
        if (r107 != null) goto L21;
    L24:
        boolean r110 = true;
    L25:
        if (r110 == false) goto L35;
        List<String> r111 = r106;
        if (r111 != null) goto L29;
    L32:
        boolean r112 = true;
    L33:
        if (r112 == false) goto L35;
        CompletionBlock.DefaultImpls.onFailure$default(r212, -3, "either mediaType or mediaTypes must not be null", null, 4, null);
        return;
    L29:
        if (r111.isEmpty() == true) goto L32;
        r112 = false;
    L35:
        if (r107 != null) goto L37;
    L40:
        boolean r108 = true;
    L41:
        if (r108 == false) goto L43;
        List<String> r113 = r106;
    L44:
        String r114 = r100.getSourceType();
        Number r109 = r100.getMaxCount();
        if (r109 == null) goto L47;
        int r115 = r109.intValue();
    L48:
        Boolean r116 = r100.getCompressImage();
        if (r116 == null) goto L51;
        boolean r117 = r116.booleanValue();
    L52:
        Boolean r118 = Boolean.valueOf(r117);
        Boolean r119 = r100.getSaveToPhotoAlbum();
        if (r119 == null) goto L55;
        boolean r120 = r119.booleanValue();
    L56:
        Boolean r121 = Boolean.valueOf(r120);
        String r122 = r100.getCameraType();
        if (r122 != null) goto L59;
        r122 = "";
    L59:
        String r123 = r122;
        Boolean r124 = r100.getNeedBinaryData();
        if (r124 == null) goto L62;
        boolean r125 = r124.booleanValue();
    L63:
        Number r126 = r100.getCompressWidth();
        if (r126 == null) goto L66;
        int r127 = r126.intValue();
    L67:
        Number r128 = r100.getCompressHeight();
        if (r128 == null) goto L70;
        int r129 = r128.intValue();
    L71:
        yd7.c.b r130 = r100.getImageParams();
        if (r130 == null) goto L74;
        r130.getCropWidth();
    L74:
        yd7.c.b r131 = r100.getImageParams();
        if (r131 == null) goto L77;
        r131.getCropWidth();
    L77:
        yd7.c.b r132 = r100.getImageParams();
        if (r132 == null) goto L82;
        Number r133 = r132.getCompressMaxSize();
        if (r133 == null) goto L82;
        r133.intValue();
    L82:
        yd7.c.d r134 = r100.getVideoParams();
        if (r134 == null) goto L87;
        Number r135 = r134.getDurationLimit();
        if (r135 == null) goto L87;
        r135.intValue();
    L87:
        re7.c r136 = new re7.c(r113, r114, r115, r118, r121, r123, r125, r127, r129);
        Boolean r137 = r100.isNeedCut();
        if (r137 == null) goto L90;
        r137.booleanValue();
    L90:
        Number r138 = r100.getCropRatioHeight();
        if (r138 == null) goto L93;
        r138.intValue();
    L93:
        Number r139 = r100.getCropRatioWidth();
        if (r139 == null) goto L96;
        r139.intValue();
    L96:
        r136.f537443g = Intrinsics.areEqual(r100.getNeedBase64Data(), Boolean.TRUE);
        Boolean r140 = r100.getCopyToPrivateDirection();
        if (r140 == null) goto L99;
        r140.booleanValue();
    L99:
        Boolean r141 = r100.getInAppStyle();
        if (r141 == null) goto L102;
        r141.booleanValue();
    L102:
        i r142 = new i(r212);
        IAnnieXCustomActivityService r143 = (IAnnieXCustomActivityService) r210.getService(IAnnieXCustomActivityService.class);
        if (r143 == null) goto L105;
        r143.i();
    L105:
        int r144 = com.bytedance.sdk.xbridge.cn.utils.g.f270260a;
        Intrinsics.checkNotNullParameter(r210, "bridgeContext");
        XBaseRuntime.f270095a.getClass();
        IHostMediaDepend r145 = XBaseRuntime.f270097c;
        if (r145 == null) goto L108;
        r145.handleJsInvoke(r104, r136, r142);
        Unit r146 = Unit.INSTANCE;
    L109:
        if (r146 != null) goto L117;
        CompletionBlock.DefaultImpls.onFailure$default(r212, 0, "hostMediaDepend is null", null, 4, null);
        return;
    L117:
        return;
    L108:
        r146 = null;
        goto L109
    L70:
        r129 = 0;
        goto L71
    L66:
        r127 = 0;
        goto L67
    L62:
        r125 = false;
        goto L63
    L55:
        r120 = false;
        goto L56
    L51:
        r117 = false;
        goto L52
    L47:
        r115 = 1;
        goto L48
    L43:
        r113 = r105;
        goto L44
    L37:
        if (r107.isEmpty() == true) goto L40;
        r108 = false;
        goto L41
    L21:
        if (r107.isEmpty() == true) goto L24;
        r110 = false;
        goto L25
    L10:
        if (r102.length() != 0) goto L12;
        boolean r147 = true;
    L13:
        if (r147 == false) goto L15;
        CompletionBlock.DefaultImpls.onFailure$default(r212, -3, "CameraType not provided with sourceType specified as camera in params", null, 4, null);
        return;
    L12:
        r147 = false;
        goto L13
    L113:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }
}
