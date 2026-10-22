package i83;

import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderContentModel;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ScrollContainerFooter;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.container.HeadAdapter;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e implements Runnable {
    public final /* synthetic */ HeadAdapter a;
    public final /* synthetic */ List b;
    public final /* synthetic */ ScrollContainerFooter c;

    public e(HeadAdapter r1, List r2, ScrollContainerFooter r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        ((ArrayList) this.a.a).clear();
        List<HeaderContentModel> r0 = this.a.a;
        List r1 = this.b;
        if (r1 != null) goto L6;
        r1 = CollectionsKt.emptyList();
    L6:
        ArrayList r2 = (ArrayList) r0;
        r2.addAll(r1);
        HeadAdapter r3 = this.a;
        r3.b = this.c;
        r3.notifyDataSetChanged();
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
