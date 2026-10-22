package u20;

import com.bytedance.geckox.OptionCheckUpdateParams;

/* JADX INFO: loaded from: classes45.dex */
public final class a implements OptionCheckUpdateParams.CustomValue {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f548401a;

    public a(int r100) {
        this.f548401a = r100;
    }

    @Override // com.bytedance.geckox.OptionCheckUpdateParams.CustomValue
    public final Object getValue() {
        return Integer.valueOf(this.f548401a);
    }
}
