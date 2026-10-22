package ka3;

import android.content.Context;
import com.bytedance.android.ec.opt.asynctask.k;
import com.bytedance.android.ec.opt.asynctask.r;
import com.bytedance.android.ec.opt.asynctask.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements w {
    public final /* synthetic */ Context a;

    public final k r() {
        r r0 = new r();
        r0.a = true;
        return r0.e;
    }

    public final void run() {
        Context r0 = this.a;
        if (r0 == null) goto L6;
        r0.getSharedPreferences("js_kv_methods_20191113", 0);
        return;
    }

    public a(Context r1) {
        this.a = r1;
    }
}
