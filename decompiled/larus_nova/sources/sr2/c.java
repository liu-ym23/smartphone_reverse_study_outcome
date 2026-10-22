package sr2;

import android.view.View;
import com.bytedance.android.livesdkapi.sti.framework.ITiltedTempIconTemplate;
import com.bytedance.android.livesdkapi.sti.framework.IconTemplate;
import kotlin.jvm.internal.Intrinsics;
import xr2.g;

/* JADX INFO: loaded from: classes11.dex */
public final class c implements g, com.bytedance.android.livesdk.revenue.service.sti.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ITiltedTempIconTemplate f543206a;

    @Override // xr2.g
    public final View getContentView() {
        return this.f543206a.getContentView();
    }

    @Override // xr2.a
    public final String getLabel() {
        return this.f543206a.getLabel();
    }

    @Override // xr2.g
    public final View getTempShortTermView() {
        return this.f543206a.getTempShortTermView();
    }

    @Override // xr2.h
    public final View getView() {
        return this.f543206a.getView();
    }

    @Override // xr2.g
    public final void removeTempView() {
        this.f543206a.removeTempView();
    }

    @Override // com.bytedance.android.livesdk.revenue.service.sti.b
    public final IconTemplate getOriginal() {
        return this.f543206a;
    }

    public c(ITiltedTempIconTemplate r100) {
        Intrinsics.checkNotNullParameter(r100, "original");
        this.f543206a = r100;
    }

    @Override // xr2.g
    public final void setContentRightMargin(int r100) {
        this.f543206a.setContentRightMargin(r100);
    }

    @Override // xr2.g
    public final void setContentTopMargin(int r100) {
        this.f543206a.setContentTopMargin(r100);
    }

    @Override // xr2.g
    public final void setContentView(View r100) {
        this.f543206a.setContentView(r100);
    }

    @Override // xr2.a
    public final void setLabel(String r100) {
        this.f543206a.setLabel(r100);
    }

    @Override // xr2.g
    public final void setResizeContentView(Boolean r100) {
        this.f543206a.setResizeContentView(r100);
    }

    @Override // xr2.g
    public final void setRotated(Boolean r100) {
        this.f543206a.setRotated(r100);
    }

    @Override // xr2.a
    public final void setSuperscript(String r100) {
        this.f543206a.setSuperscript(r100);
    }

    @Override // xr2.g
    public final void setTempShortTermView(View r100) {
        this.f543206a.setTempShortTermView(r100);
    }
}
