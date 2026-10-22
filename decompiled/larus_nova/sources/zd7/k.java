package zd7;

import android.app.Activity;
import bolts.Task;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostPermissionDepend;
import com.ss.android.lark.image.entity.LoadParams;
import java.util.Arrays;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "x.compressImage")
public final class k extends yd7.d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String[] f571376d = null;

    public static final class a {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final boolean canRunInBackground() {
        return true;
    }

    static {
        f571376d = new String[]{"jpg", LoadParams.ImageFormat.PNG, "webp"};
    }

    public k() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r110, XBaseParamModel r111, CompletionBlock r210) {
        yd7.d.b r100 = (yd7.d.b) r111;
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r210, "callback");
        String r101 = r100.getUri();
        float r112 = r100.getScalingRatio().floatValue();
        String r102 = r100.getFormat();
        if (r102 != null) goto L5;
        r102 = "jpg";
    L5:
        String r113 = r102;
        Number r103 = r100.getQuality();
        if (r103 == null) goto L8;
        int r104 = r103.intValue();
    L9:
        byte r114 = -3;
        if (StringUtils.isEmpty(r101) == false) goto L13;
        CompletionBlock.DefaultImpls.onFailure$default(r210, -3, "uri is empty", null, 4, null);
    L22:
        byte r105 = -3;
    L28:
        if (r105 == 1) goto L30;
        return;
    L30:
        if (r112 <= 1.0f) goto L33;
        CompletionBlock.DefaultImpls.onFailure$default(r210, -3, "scalingRatio must less than 1", null, 4, null);
    L35:
        byte r106 = -3;
    L37:
        if (r106 == 1) goto L39;
        return;
    L39:
        if (ArraysKt.contains(f571376d, r113) == true) goto L41;
        CompletionBlock.DefaultImpls.onFailure$default(r210, -3, "invalid format, which support 'jpg'，'png'，'webp'", null, 4, null);
        byte r107 = -3;
    L42:
        if (r107 != 1) goto L55;
        if (r104 <= 100) goto L46;
        CompletionBlock.DefaultImpls.onFailure$default(r210, -3, "quality must less than 100", null, 4, null);
    L49:
        if (r114 != 1) goto L56;
        Task.callInBackground(new l(this, r110, r101, r112, r113, r104, r210));
        return;
    L56:
        return;
    L46:
        if (r104 >= 0.0f) goto L48;
        CompletionBlock.DefaultImpls.onFailure$default(r210, -3, "quality must bigger then 0", null, 4, null);
        goto L49
    L48:
        r114 = 1;
        goto L49
    L55:
        return;
    L41:
        r107 = 1;
        goto L42
    L33:
        if (r112 > 0.0f) goto L36;
        CompletionBlock.DefaultImpls.onFailure$default(r210, -3, "scalingRatio must bigger then 0", null, 4, null);
        goto L35
    L36:
        r106 = 1;
        goto L37
    L13:
        if (r110.getOwnerActivity() != null) goto L15;
        CompletionBlock.DefaultImpls.onFailure$default(r210, 0, "bridge context is invalid", null, 4, null);
    L18:
        r105 = 0;
        goto L28
    L15:
        IHostPermissionDepend r108 = com.bytedance.sdk.xbridge.cn.utils.g.f(r110);
        if (r108 != null) goto L19;
        CompletionBlock.DefaultImpls.onFailure$default(r210, 0, "permission depend missing, please seek help from client RD", null, 4, null);
        goto L18
    L19:
        Activity r109 = r110.getOwnerActivity();
        Intrinsics.checkNotNull(r109);
        String[] r115 = ae7.h.e();
        boolean r116 = r108.isPermissionAllGranted(r109, (String[]) Arrays.copyOf(r115, r115.length));
        ae7.a.f3109a.getClass();
        if (ae7.a.e(r109, r101) == true) goto L23;
        CompletionBlock.DefaultImpls.onFailure$default(r210, -3, "file specified by uri not exists", null, 4, null);
        goto L22
    L23:
        if (r116 == false) goto L25;
    L27:
        r105 = 1;
        goto L28
    L25:
        if (ae7.a.d(r109, r101) == true) goto L27;
        CompletionBlock.DefaultImpls.onFailure$default(r210, -6, "need permission to access file specified by uri， please request permission with x.requestPermission", null, 4, null);
        r105 = -6;
        goto L28
    L8:
        r104 = 100;
        goto L9
    }
}
