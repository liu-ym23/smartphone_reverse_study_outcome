package sr2;

import android.view.View;
import com.bytedance.android.livesdkapi.sti.framework.ICustomIconTemplate;
import com.bytedance.android.livesdkapi.sti.framework.IconTemplate;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class a implements xr2.b, com.bytedance.android.livesdk.revenue.service.sti.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ICustomIconTemplate f543204a;

    @Override // xr2.b
    public final View getContentView() {
        return this.f543204a.getContentView();
    }

    @Override // xr2.a
    public final String getLabel() {
        return this.f543204a.getLabel();
    }

    @Override // xr2.h
    public final View getView() {
        return this.f543204a.getView();
    }

    @Override // com.bytedance.android.livesdk.revenue.service.sti.b
    public final IconTemplate getOriginal() {
        return this.f543204a;
    }

    public a(ICustomIconTemplate r100) {
        Intrinsics.checkNotNullParameter(r100, "original");
        this.f543204a = r100;
    }

    @Override // xr2.b
    public final View inflateContentView(int r100) {
        return this.f543204a.inflateContentView(R.layout.ttlive_view_vote_sti);
    }

    @Override // xr2.a
    public final void setBackgroundEnabled(boolean r100) {
        this.f543204a.setBackgroundEnabled(r100);
    }

    @Override // xr2.b
    public final void setContentView(View r100) {
        this.f543204a.setContentView(r100);
    }

    @Override // xr2.a
    public final void setLabel(String r100) {
        this.f543204a.setLabel(r100);
    }

    @Override // xr2.a
    public final void setSuperscript(String r100) {
        this.f543204a.setSuperscript(r100);
    }
}
