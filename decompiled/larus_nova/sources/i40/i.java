package i40;

import android.content.Context;
import com.bytedance.android.live.common.keyboard.MeasureLinearLayout;
import com.obric.trace.ObricActionBarTrackType;

/* JADX INFO: loaded from: classes45.dex */
public final class i extends b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f488151c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f488152d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f488153e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f488154f;

    @Override // i40.b
    public final boolean a(Context r100, int r101) {
        d r102 = this.f488133a.b(r100, r101);
        if (r102 != null) goto L6;
        return true;
    L6:
        if (this.f488151c != 0) goto L9;
        this.f488151c = System.currentTimeMillis();
    L9:
        if ((System.currentTimeMillis() - this.f488151c) < this.f488152d) goto L11;
    L20:
        this.f488151c = System.currentTimeMillis();
        c(r102.f488135a, r102.f488136b);
        return true;
    L11:
        if (r102.f488135a == true) goto L20;
        h.c("【hit invalid check】", this.f488153e);
        if (this.f488154f == false) goto L18;
        h.c("target section is " + h.f488150d, this.f488153e);
        if (ObricActionBarTrackType.KEY_BOARD.equals(h.f488150d) == false) goto L20;
        h.c("【invalid update measure, don't update for keyboard】", this.f488153e);
        return false;
    L18:
        h.c("【invalid update measure, don't update】", this.f488153e);
        return false;
    }

    public i(MeasureLinearLayout r100, int r101, boolean r102, boolean r103) {
        super(r100);
        this.f488151c = 0;
        this.f488152d = 200;
        this.f488153e = false;
        this.f488154f = false;
        this.f488133a = new g(r103);
        this.f488152d = r101;
        this.f488153e = r103;
        this.f488154f = r102;
    }
}
