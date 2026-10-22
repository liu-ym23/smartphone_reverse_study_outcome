package sr2;

import android.view.View;
import com.bytedance.android.livesdkapi.sti.framework.ITiltedIconTemplate;
import com.bytedance.android.livesdkapi.sti.framework.IconTemplate;
import kotlin.jvm.internal.Intrinsics;
import xr2.f;

/* JADX INFO: loaded from: classes11.dex */
public final class b implements f, com.bytedance.android.livesdk.revenue.service.sti.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ITiltedIconTemplate f543205a;

    @Override // xr2.f
    public final void clearAnimators() {
        this.f543205a.clearAnimators();
    }

    @Override // xr2.f
    public final View getContentView() {
        return this.f543205a.getContentView();
    }

    @Override // xr2.a
    public final String getLabel() {
        return this.f543205a.getLabel();
    }

    @Override // xr2.h
    public final View getView() {
        return this.f543205a.getView();
    }

    @Override // xr2.f
    public final void shake() {
        this.f543205a.shake();
    }

    @Override // com.bytedance.android.livesdk.revenue.service.sti.b
    public final IconTemplate getOriginal() {
        return this.f543205a;
    }

    public b(ITiltedIconTemplate r100) {
        Intrinsics.checkNotNullParameter(r100, "original");
        this.f543205a = r100;
    }

    @Override // xr2.f
    public final View inflateContentView(int r100) {
        return this.f543205a.inflateContentView(r100);
    }

    @Override // xr2.f
    public final void setContentRightMargin(int r100) {
        this.f543205a.setContentRightMargin(r100);
    }

    @Override // xr2.f
    public final void setContentTopMargin(int r100) {
        this.f543205a.setContentTopMargin(r100);
    }

    @Override // xr2.f
    public final void setContentView(View r100) {
        this.f543205a.setContentView(r100);
    }

    @Override // xr2.a
    public final void setLabel(String r100) {
        this.f543205a.setLabel(r100);
    }

    @Override // xr2.a
    public final void setSuperscript(String r100) {
        this.f543205a.setSuperscript(r100);
    }
}
