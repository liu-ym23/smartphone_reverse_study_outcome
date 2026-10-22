package com.bytedance.locallife.hybrid.bridge;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.larus.nova.R;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class d0 extends mt6.c {

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return "showImageToast";
    }

    public d0() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final void realHandle(IBDXBridgeContext r100, Map<String, ? extends Object> r101, IDLXBridgeMethod.a r110) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r110, "callback");
        Context r102 = ou6.b.f526748a.getContext(r100);
        if (r102 == null) goto L5;
        Context r103 = r102.getApplicationContext();
    L6:
        if (r103 != null) goto L9;
        b.a(r110, " context is null");
        return;
    L9:
        Object r104 = r101.get("type");
        if ((r104 instanceof Integer) == false) goto L12;
        Integer r105 = (Integer) r104;
    L14:
        if (r105 == null) goto L16;
        int r106 = r105.intValue();
    L17:
        Object r107 = r101.get("message");
        if ((r107 instanceof String) == false) goto L20;
        String r108 = (String) r107;
    L22:
        if (r108 != null) goto L24;
        r108 = "";
    L24:
        Toast r109 = new Toast(r103);
        View r111 = LayoutInflater.from(r103).inflate(R.layout.image_toast_layout, null);
        r111.findViewById(R.id.toast_content).setBackgroundResource(R.drawable.toast_bg);
        ((TextView) r111.findViewById(R.id.toast_tv)).setText(r108);
        if (r106 != 0) goto L27;
    L31:
        ((ImageView) r111.findViewById(R.id.toast_icon)).setImageResource(R.drawable.ic_toast_warning);
    L32:
        Resources r112 = r103.getResources();
        if (r112 == null) goto L38;
        int r113 = r112.getIdentifier("status_bar_height", "dimen", "android");
        if (r113 <= 0) goto L38;
        int r114 = r112.getDimensionPixelSize(r113);
    L39:
        r109.setGravity(17, 0, (-r114) / 2);
        r109.setView(r111);
        r109.setDuration(0);
        r109.show();
        b.b(r110, "");
        return;
    L38:
        r114 = 0;
        goto L39
    L27:
        if (r106 == 1) goto L30;
        if (r106 == 2) goto L31;
    L30:
        ((ImageView) r111.findViewById(R.id.toast_icon)).setImageResource(R.drawable.ic_toast_success);
        goto L32
    L20:
        r108 = null;
        goto L22
    L16:
        r106 = 0;
        goto L17
    L12:
        r105 = null;
        goto L14
    L5:
        r103 = null;
        goto L6
    }
}
