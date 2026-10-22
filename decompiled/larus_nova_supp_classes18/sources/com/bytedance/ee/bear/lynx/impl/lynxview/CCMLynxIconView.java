package com.bytedance.ee.bear.lynx.impl.lynxview;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.ee.bear.appsetting.c;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.larksuite.component.universe_design.image.UDAvatar;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.ss.android.lark.docs.icon.entity.IconShape;
import com.ss.android.lark.larkicon.IconScene;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import obb.a;
import obb.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0014J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007J\u0012\u0010\u0011\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0010H\u0007J\u0006\u0010\u0013\u001a\u00020\tR\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ee/bear/lynx/impl/lynxview/CCMLynxIconView;", "Lcom/lynx/tasm/behavior/ui/LynxUI;", "Lcom/larksuite/component/universe_design/image/UDAvatar;", "lynxContext", "Lcom/lynx/tasm/behavior/LynxContext;", "<init>", "(Lcom/lynx/tasm/behavior/LynxContext;)V", "avatarView", "isLoaded", "", "createView", "context", "Landroid/content/Context;", "setIconToken", "", "iconToken", "", "setUrl", ResourceData.KEY_URL, "isLoadedFunc", "features-lynx-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CCMLynxIconView extends LynxUI<UDAvatar> {
    public UDAvatar a;
    public boolean b;

    public CCMLynxIconView(LynxContext r2) {
        Intrinsics.checkNotNullParameter(r2, "lynxContext");
        super(r2);
        this.b = true;
    }

    public final View createView(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        FrameLayout.LayoutParams r0 = new FrameLayout.LayoutParams(-2, -2);
        UDAvatar r1 = new UDAvatar(r3);
        this.a = r1;
        r1.setBorderStyle(1);
        r0.gravity = 17;
        UDAvatar r4 = this.a;
        if (r4 == null) goto L5;
        r4.setLayoutParams(r0);
    L5:
        return r1;
    }

    @LynxProp(name = "icon-token")
    public final void setIconToken(String r8) {
        if (TextUtils.isEmpty(r8) == false) goto L5;
        return;
    L5:
        if (c.a.a.g("base.share.icon_reuse_fix") == false) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == false) goto L20;
        sbb.c.a.getClass();
        b r1 = sbb.c.c(null, r8);
        if (r1 != null) goto L12;
        return;
    L12:
        UDAvatar r2 = this.a;
        if (r2 == null) goto L21;
        String r3 = r1.b;
        if (r3 != null) goto L17;
        r3 = "";
    L17:
        mbb.c.d(r2, r3, r1.getType(), r8, IconShape.CIRCLE, new a(IconScene.LYNX));
        this.b = false;
        return;
    L21:
        return;
    L20:
        return;
    L7:
        r0 = this.b;
        goto L8
    }

    @LynxProp(name = ResourceData.KEY_URL)
    public final void setUrl(String r5) {
        if (TextUtils.isEmpty(r5) == true) goto L14;
        if (r5 != null) goto L6;
        return;
    L6:
        if (c.a.a.g("base.share.icon_reuse_fix") == false) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == false) goto L16;
        UDAvatar r1 = this.a;
        if (r1 == null) goto L17;
        mbb.c.e(r1, r5, IconShape.CIRCLE, new a(IconScene.LYNX));
        this.b = false;
        return;
    L17:
        return;
    L16:
        return;
    L8:
        r0 = this.b;
        goto L9
    }
}
