package com.bytedance.ies.xelement;

import android.content.Context;
import android.view.View;
import com.bytedance.ies.xelement.view.PlaySeeker;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\tJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0007J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/ies/xelement/LynxSeekerManager;", "Lcom/lynx/tasm/behavior/ui/LynxUI;", "Lcom/bytedance/ies/xelement/view/PlaySeeker;", "", "progressRate", "", "setProgress", "duration", "setDuration", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "x-element-video_release"}, k = 1, mv = {1, 6, 0})
public final class LynxSeekerManager extends LynxUI<PlaySeeker> {

    public static final class a {
    }

    static {
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r100) {
        PlaySeeker r101 = new PlaySeeker(r100);
        r101.setStateReporter(new LynxSeekerManager$createView$1$1(this));
        return r101;
    }

    @LynxProp(name = "duration")
    public final void setDuration(int r100) {
        ((PlaySeeker) this.mView).setEnabled(true);
        ((PlaySeeker) this.mView).setMax(r100);
    }

    @LynxProp(name = "currentDuration")
    public final void setProgress(int r100) {
        ((PlaySeeker) this.mView).setProgress(r100);
    }
}
