package com.bytedance.ee.bear.bitable.anniex.view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.bytedance.ee.bear.bitable.panel.Icon;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0014\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0014\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u000bH\u0014J\u0006\u0010\f\u001a\u00020\rJ\u0012\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007J\u0017\u0010\u0011\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007¢\u0006\u0002\u0010\u0014J\u0012\u0010\u0015\u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0010H\u0007J\u0012\u0010\u0017\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0010H\u0007J\u0012\u0010\u0019\u001a\u00020\r2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0010H\u0007J\u0017\u0010\u001b\u001a\u00020\r2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0013H\u0007¢\u0006\u0002\u0010\u0014J\u0017\u0010\u001d\u001a\u00020\r2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0007¢\u0006\u0002\u0010 J\u0017\u0010!\u001a\u00020\r2\b\u0010\"\u001a\u0004\u0018\u00010\u0013H\u0007¢\u0006\u0002\u0010\u0014J\u0012\u0010#\u001a\u00020\r2\b\u0010$\u001a\u0004\u0018\u00010\u0010H\u0007J\u0017\u0010%\u001a\u00020\r2\b\u0010&\u001a\u0004\u0018\u00010\u0013H\u0007¢\u0006\u0002\u0010\u0014J\u0012\u0010'\u001a\u00020\r2\b\u0010(\u001a\u0004\u0018\u00010\u0010H\u0007J\u0017\u0010)\u001a\u00020\r2\b\u0010*\u001a\u0004\u0018\u00010\u0013H\u0007¢\u0006\u0002\u0010\u0014J\u0012\u0010+\u001a\u00020\r2\b\u0010,\u001a\u0004\u0018\u00010\u0010H\u0007J\u0012\u0010-\u001a\u00020\r2\b\u0010.\u001a\u0004\u0018\u00010\u0010H\u0007J\u0017\u0010/\u001a\u00020\r2\b\u00100\u001a\u0004\u0018\u00010\u0013H\u0007¢\u0006\u0002\u0010\u0014J\u0012\u00101\u001a\u00020\r2\b\u00102\u001a\u0004\u0018\u00010\u0010H\u0007R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/bytedance/ee/bear/bitable/anniex/view/BitableLynxIconView;", "Lcom/lynx/tasm/behavior/ui/LynxUI;", "Landroid/widget/ImageView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/lynx/tasm/behavior/LynxContext;", "<init>", "(Lcom/lynx/tasm/behavior/LynxContext;)V", "imageView", "icon", "Lcom/bytedance/ee/bear/bitable/panel/Icon;", "createView", "Landroid/content/Context;", "updateImageView", "", "setUdKey", "udKey", "", "setImgRes", "imgRes", "", "(Ljava/lang/Integer;)V", "setUrl", "url", "setId", "id", "setResId", "result", "setGif", "gif", "setIsSync", "isSync", "", "(Ljava/lang/Boolean;)V", "setPlaceholderRes", "placeholderRes", "setIconMeta", "iconMeta", "setStyle", "style", "setClickAction", "clickAction", "setIconRadius", "iconRadius", "setIconTintColor", "iconTintColor", "setIconInfo", "iconInfo", "setEnumIcon", "enumIcon", "setVisibleType", "visibleType", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableLynxIconView extends LynxUI<ImageView> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImageView f206774a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Icon f206775b;

    @LynxProp(name = "iconMeta")
    public final void setIconMeta(String r100) {
    }

    @LynxProp(name = "resId")
    public final void setResId(String r100) {
    }

    public final void M() {
        ImageView r100 = this.f206774a;
        if (r100 != null) goto L5;
        return;
    L5:
        this.f206775b.apply(r100);
    }

    public BitableLynxIconView(LynxContext r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f206775b = new Icon();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        this.f206774a = new ImageView(r100);
        this.f206775b = new Icon();
        return this.f206774a;
    }

    @LynxProp(name = "clickAction")
    public final void setClickAction(String r100) {
        if (Intrinsics.areEqual(this.f206775b.getClickAction(), r100) == false) goto L5;
        return;
    L5:
        this.f206775b.setClickAction(r100);
        M();
    }

    @LynxProp(name = "enumIcon")
    public final void setEnumIcon(Integer r100) {
        if (Intrinsics.areEqual(this.f206775b.getEnumIcon(), r100) == false) goto L5;
        return;
    L5:
        this.f206775b.setEnumIcon(r100);
        M();
    }

    @LynxProp(name = "gif")
    public final void setGif(Integer r100) {
        if (Intrinsics.areEqual(this.f206775b.getGif(), r100) == false) goto L5;
        return;
    L5:
        this.f206775b.setGif(r100);
        M();
    }

    @LynxProp(name = "iconInfo")
    public final void setIconInfo(String r100) {
        if (Intrinsics.areEqual(this.f206775b.getIconInfo(), r100) == false) goto L5;
        return;
    L5:
        this.f206775b.setIconInfo(r100);
        M();
    }

    @LynxProp(name = "iconRadius")
    public final void setIconRadius(Integer r100) {
        int r101 = this.f206775b.getIconRadius();
        int r102 = 0;
        if (r100 != null) goto L5;
        Integer r103 = 0;
    L7:
        if (r101 != r103.intValue()) goto L9;
        return;
    L9:
        Icon r104 = this.f206775b;
        if (r100 == null) goto L12;
        r102 = r100.intValue();
    L12:
        r104.setIconRadius(r102);
        M();
        return;
    L5:
        r103 = r100;
        goto L7
    }

    @LynxProp(name = "iconTintColor")
    public final void setIconTintColor(String r100) {
        if (Intrinsics.areEqual(this.f206775b.getIconTintColor(), r100) == false) goto L5;
        return;
    L5:
        this.f206775b.setIconTintColor(r100);
        M();
    }

    @LynxProp(name = "id")
    public final void setId(String r100) {
        if (Intrinsics.areEqual(this.f206775b.getId(), r100) == false) goto L5;
        return;
    L5:
        this.f206775b.setId(r100);
        M();
    }

    @LynxProp(name = "imgRes")
    public final void setImgRes(Integer r100) {
        if (Intrinsics.areEqual(this.f206775b.getImgRes(), r100) == false) goto L5;
        return;
    L5:
        this.f206775b.setImgRes(r100);
        M();
    }

    @LynxProp(name = "isSync")
    public final void setIsSync(Boolean r100) {
        Boolean r101 = Boolean.valueOf(this.f206775b.isSync());
        if (r100 != null) goto L5;
        Boolean r102 = Boolean.FALSE;
    L7:
        if (Intrinsics.areEqual(r101, r102) == false) goto L9;
        return;
    L9:
        Icon r103 = this.f206775b;
        if (r100 == null) goto L12;
        boolean r104 = r100.booleanValue();
    L13:
        r103.setSync(r104);
        M();
        return;
    L12:
        r104 = false;
        goto L13
    L5:
        r102 = r100;
        goto L7
    }

    @LynxProp(name = "placeholderRes")
    public final void setPlaceholderRes(Integer r100) {
        if (Intrinsics.areEqual(this.f206775b.getPlaceholderRes(), r100) == false) goto L5;
        return;
    L5:
        this.f206775b.setPlaceholderRes(r100);
        M();
    }

    @LynxProp(name = "style")
    public final void setStyle(Integer r100) {
        if (Intrinsics.areEqual(this.f206775b.getStyle(), r100) == false) goto L5;
        return;
    L5:
        this.f206775b.setStyle(r100);
        M();
    }

    @LynxProp(name = "udKey")
    public final void setUdKey(String r100) {
        if (Intrinsics.areEqual(this.f206775b.getUdKey(), r100) == false) goto L5;
        return;
    L5:
        this.f206775b.setUdKey(r100);
        M();
    }

    @LynxProp(name = "url")
    public final void setUrl(String r100) {
        if (Intrinsics.areEqual(this.f206775b.getUrl(), r100) == false) goto L5;
        return;
    L5:
        this.f206775b.setUrl(r100);
        M();
    }

    @LynxProp(name = "visibleType")
    public final void setVisibleType(String r100) {
        if (Intrinsics.areEqual(this.f206775b.getVisibleType(), r100) == false) goto L5;
        return;
    L5:
        this.f206775b.setVisibleType(r100);
        M();
    }
}
