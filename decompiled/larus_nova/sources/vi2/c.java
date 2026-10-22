package vi2;

import com.bytedance.android.livesdk.livecommerce.model.FilterNullArrayList;
import com.bytedance.retrofit2.SsResponse;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class c implements h.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FilterNullArrayList f555035a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f555036b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ el2.m f555037c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Class f555038d;

    public /* synthetic */ c(FilterNullArrayList r100, String r101, el2.m r102, Class r103) {
        this.f555035a = r100;
        this.f555036b = r101;
        this.f555037c = r102;
        this.f555038d = r103;
    }

    @Override // vi2.h.f
    public final wi2.a execute() {
        FilterNullArrayList r100 = this.f555035a;
        String r101 = this.f555036b;
        el2.m r102 = this.f555037c;
        Class r103 = this.f555038d;
        Map<String, String> r104 = com.bytedance.android.livesdk.livecommerce.utils.y.a(r100);
        SsResponse<String> r105 = h.i(r101, r100);
        if (r102 == null) goto L6;
        r102.a(r105);
    L6:
        return h.f((com.bytedance.android.ec.model.g) h.j(r105, r103), r104, r105);
    }
}
