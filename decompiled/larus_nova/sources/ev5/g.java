package ev5;

import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends q {
    public g() {
        super("is_contains_with");
    }

    @Override // ev5.q
    public final boolean b(String r100, String r101, boolean r102) {
        return StringsKt.contains(r100, r101, r102);
    }
}
