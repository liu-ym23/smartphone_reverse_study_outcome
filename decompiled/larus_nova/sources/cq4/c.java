package cq4;

import com.bytedance.ee.bear.bitable.card.view.cell.title.record.span.DescriptionIconSpan;
import com.bytedance.ee.bear.bitable.panel.l;

/* JADX INFO: loaded from: classes15.dex */
public final class c implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f464787a;

    @Override // com.bytedance.ee.bear.bitable.panel.l
    public final void a(String r100) {
    }

    @Override // com.bytedance.ee.bear.bitable.panel.l
    public final void onExit() {
        b.c r100 = this.f464787a.f464772c;
        DescriptionIconSpan.DescriptionIconState r101 = DescriptionIconSpan.DescriptionIconState.STATE_NORMAL;
        DescriptionIconSpan r102 = r100.f464778c;
        if (r102 == null) goto L6;
        r100.f464779d = r101;
        r102.f208281b = r101;
        r100.f464781f.invalidate();
        return;
    }

    public c(b r100) {
        this.f464787a = r100;
    }
}
