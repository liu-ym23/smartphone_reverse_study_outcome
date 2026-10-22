package i83;

import com.bytedance.android.shopping.anchorv4.voavhs.headv2.HeaderContentModel;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ScrollContainerFooter;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.container.HeadAdapter;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes13.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HeadAdapter f488611a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f488612b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ScrollContainerFooter f488613c;

    public e(HeadAdapter r100, List r101, ScrollContainerFooter r102) {
        this.f488611a = r100;
        this.f488612b = r101;
        this.f488613c = r102;
    }

    public final void a() {
        ((ArrayList) this.f488611a.f169144a).clear();
        List<HeaderContentModel> r100 = this.f488611a.f169144a;
        List r101 = this.f488612b;
        if (r101 != null) goto L6;
        r101 = CollectionsKt.emptyList();
    L6:
        ArrayList r102 = (ArrayList) r100;
        r102.addAll(r101);
        HeadAdapter r103 = this.f488611a;
        r103.f169145b = this.f488613c;
        r103.notifyDataSetChanged();
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
