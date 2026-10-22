package com.lynx.tasm.behavior.ui.image;

import android.content.Context;
import android.view.View;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.ec.model.response.anchorv3.SalesInfoStruct;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.LynxUI;

/* JADX INFO: loaded from: classes32.dex */
public abstract class AbsUIImage<T extends View> extends LynxUI<T> {
    @LynxProp(name = "auto-size")
    public void setAutoSize(boolean r100) {
    }

    @LynxProp(name = "blur-radius")
    public abstract void setBlurRadius(String r100);

    @LynxProp(name = "capInsets")
    public abstract void setCapInsets(String r100);

    @LynxProp(name = "cap-insets")
    public void setCapInsetsBackUp(String r100) {
    }

    @LynxProp(name = "cap-insets-scale")
    public void setCapInsetsScale(String r100) {
    }

    @LynxProp(defaultBoolean = false, name = "cover-start")
    public abstract void setCoverStart(boolean r100);

    @LynxProp(defaultBoolean = false, name = "disable-default-placeholder")
    public void setDisableDefaultPlaceholder(boolean r100) {
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    @LynxProp(name = "disable-default-resize")
    public void setDisableDefaultResize(boolean r100) {
    }

    @LynxProp(name = "loop-count")
    public abstract void setLoopCount(int r100);

    @LynxProp(name = "mode")
    public abstract void setObjectFit(String r100);

    @LynxProp(name = GXTemplateKey.GAIAX_PLACEHOLDER)
    public abstract void setPlaceholder(String r100);

    @LynxProp(name = "prefetch-height")
    public abstract void setPreFetchHeight(String r100);

    @LynxProp(name = "prefetch-width")
    public abstract void setPreFetchWidth(String r100);

    @LynxProp(defaultBoolean = false, name = SalesInfoStruct.REPEAT)
    public abstract void setRepeat(boolean r100);

    @LynxProp(name = "src")
    public abstract void setSource(String r100);

    public AbsUIImage(Context r100) {
        super(r100);
    }

    public AbsUIImage(LynxContext r100) {
        super(r100);
    }

    public AbsUIImage(LynxContext r100, Object r101) {
        super(r100, r101);
    }
}
