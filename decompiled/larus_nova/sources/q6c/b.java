package q6c;

import com.ss.android.lark.tangram.base.style.TCStyle;
import java.util.ArrayList;
import r6c.a;

/* JADX INFO: loaded from: classes38.dex */
public abstract class b<Dp extends r6c.a> extends a<Dp> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TCStyle f531877c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ArrayList<a<Dp>> f531878d;

    @Override // q6c.c
    public final TCStyle getStyle() {
        return this.f531877c;
    }

    public b(Dp r100, TCStyle r101) {
        super(r100);
        this.f531877c = r101;
    }
}
