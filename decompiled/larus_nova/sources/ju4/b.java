package ju4;

import android.view.View;
import com.ss.android.lark.utils.LarkContext;
import e0c.k;

/* JADX INFO: loaded from: classes16.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f500482a;

    public b(String r100) {
        this.f500482a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        ((com.bytedance.ee.bear.route.h) k.a(LarkContext.getApplication(), com.bytedance.ee.bear.route.h.class)).u5(this.f500482a);
    }
}
