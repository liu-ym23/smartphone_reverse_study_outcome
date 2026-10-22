package ev5;

import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class n extends q {
    public n() {
        super("is_start_with");
    }

    @Override // ev5.q
    public final boolean b(String r100, String r101, boolean r102) {
        return StringsKt.startsWith(r100, r101, r102);
    }
}
