package yp6;

import com.bytedance.locallife.dito.Dito;
import com.bytedance.locallife.dito.common.experiment.e;
import com.bytedance.locallife.dito.config.i;
import com.bytedance.locallife.dito.utils.l;
import en6.f;

/* JADX INFO: loaded from: classes21.dex */
public final class a implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f568720a = null;

    static {
        f568720a = new a();
    }

    public a() {
    }

    @Override // com.bytedance.locallife.dito.config.i
    public final boolean a() {
        int r100 = e.f257352a;
        Dito r101 = Dito.f257280a;
        jq6.a r102 = l.a();
        if (r102 == null) goto L11;
        f r103 = (f) r102;
        Integer r104 = (Integer) r103.a("dito_top_model_optimization_exp", Integer.TYPE, 0);
        if (r104 != null) goto L8;
        return false;
    L8:
        if (r104.intValue() != 1) goto L12;
        return true;
    L12:
        return false;
    L11:
        return false;
    }
}
