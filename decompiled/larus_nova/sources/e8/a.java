package e8;

import com.bytedance.android.annie.ng.h;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes43.dex */
public final class a implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<d8.b, Unit> f471278a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.annie.ng.a.C0738a f471279b;

    @Override // com.bytedance.android.annie.ng.h
    public final void onCallback() {
        d8.b r100 = new d8.b();
        this.f471278a.invoke(r100);
        ConcurrentHashMap<String, d8.b> r101 = d.f471282a;
        d.f471282a.put(this.f471279b.f39647a, r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(Function1<? super d8.b, Unit> r100, com.bytedance.android.annie.ng.a.C0738a r101) {
        this.f471278a = r100;
        this.f471279b = r101;
    }
}
