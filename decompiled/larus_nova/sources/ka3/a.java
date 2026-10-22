package ka3;

import android.content.Context;
import com.bytedance.android.ec.opt.asynctask.k;
import com.bytedance.android.ec.opt.asynctask.r;
import com.bytedance.android.ec.opt.asynctask.w;

/* JADX INFO: loaded from: classes13.dex */
public final class a implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f502182a;

    @Override // com.bytedance.android.ec.opt.asynctask.w
    public final k r() {
        r r100 = new r();
        r100.f48046a = true;
        return r100.f48050e;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context r100 = this.f502182a;
        if (r100 == null) goto L6;
        r100.getSharedPreferences("js_kv_methods_20191113", 0);
        return;
    }

    public a(Context r100) {
        this.f502182a = r100;
    }
}
