package hn5;

import com.bytedance.ee.bear.domain.BearUrl;
import com.ss.ttvideoengine.log.VideoEventOneOutSync;
import java.util.HashMap;

/* JADX INFO: loaded from: classes18.dex */
public final class c implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final on5.a f486106a;

    @Override // hn5.a
    public final void b() {
        qm5.b.d(VideoEventOneOutSync.END_TYPE_FINISH);
    }

    public c() {
        this.f486106a = new on5.a();
    }

    @Override // hn5.a
    public final void a(BearUrl r100) {
        this.f486106a.f524353a = r100;
    }

    @Override // hn5.a
    public final void c(boolean r100) {
        on5.a r101 = this.f486106a;
        r101.getClass();
        HashMap r102 = new HashMap();
        if (r100 == false) goto L5;
        String r103 = "last button";
    L6:
        r102.put("op_item", r103);
        r101.c("find_item", r102);
        return;
    L5:
        r103 = "next button";
        goto L6
    }
}
