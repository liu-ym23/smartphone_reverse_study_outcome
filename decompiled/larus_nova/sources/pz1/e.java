package pz1;

import android.text.TextUtils;
import com.bytedance.android.livesdk.gift.model.l2;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper.j0;
import java.util.HashSet;
import py.k;

/* JADX INFO: loaded from: classes9.dex */
public final class e extends a<l2> {
    @Override // pz1.a
    public final void k() {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel
    public final String a() {
        return ((l2) this.f126620h).getDescription();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel
    public final k b() {
        return ((l2) this.f126620h).getDiamondLabel();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel
    public final long c() {
        return ((l2) this.f126620h).getId();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel
    public final k d() {
        return ((l2) this.f126620h).getIcon();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel
    public final k e() {
        return ((l2) this.f126620h).getLabelIcon();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel
    public final String f() {
        return ((l2) this.f126620h).getName();
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.ui.panel.AbsPanel
    public final boolean i() {
        if (((l2) this.f126620h).getGift() != null) goto L5;
        return true;
    L5:
        if (((l2) this.f126620h).getGift().getType() != 1) goto L7;
    L9:
        return false;
    L7:
        if (((l2) this.f126620h).getGift().getType() == 5) goto L9;
        return true;
    }

    @Override // pz1.a
    public final long j() {
        return ((l2) this.f126620h).getDiamond();
    }

    @Override // pz1.a
    public final String l() {
        return ((l2) this.f126620h).getManual();
    }

    @Override // pz1.a
    public final boolean m() {
        if (((l2) this.f126620h).getGift() != null) goto L6;
        return false;
    L6:
        if (j0.a(((l2) this.f126620h).getGift()) == false) goto L9;
        return false;
    L9:
        return !((l2) this.f126620h).getGift().getGiftGroupList().isEmpty();
    }

    @Override // pz1.a
    public final boolean n() {
        if (((l2) this.f126620h).getGift() != null) goto L6;
        return false;
    L6:
        return ((l2) this.f126620h).getGift().getRepeat();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // pz1.a
    public final boolean o() {
        return !((HashSet) ay1.b.f16701n.getValue(null, ay1.b.f16675a[16])).contains(String.valueOf(((l2) this.f126620h).getId()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // pz1.a
    public final boolean p() {
        if (TextUtils.isEmpty(((l2) this.f126620h).getManual()) == false) goto L5;
    L7:
        return false;
    L5:
        if (((HashSet) ay1.b.f16699m.getValue(null, ay1.b.f16675a[15])).contains(Long.valueOf(((l2) this.f126620h).getId())) == true) goto L7;
        return true;
    }

    public e(l2 r100) {
        long r101 = r100.getPropType();
        if (r101 != 4) goto L6;
        int r102 = 9;
    L12:
        super(r102, r100);
        return;
    L6:
        if (r101 != 9) goto L9;
        r102 = 14;
        goto L12
    L9:
        if (r101 != 5) goto L11;
        r102 = 18;
        goto L12
    L11:
        r102 = 2;
        goto L12
    }
}
