package j76;

import java.util.Map;

/* JADX INFO: loaded from: classes19.dex */
public final class r extends com.lynx.tasm.event.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Map<String, Object> f497630b;

    @Override // com.lynx.tasm.event.a
    public final String c() {
        return "detail";
    }

    @Override // com.lynx.tasm.event.a
    public final Map<String, Object> b() {
        return this.f497630b;
    }

    public r(String r100, Map<String, Object> r101, int r102) {
        this.f497630b = r101;
        super(r102, r100);
    }
}
