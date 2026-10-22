package zq5;

import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes18.dex */
public class b {
    public String chainPushUUid;

    public b() {
    }

    public final boolean isHitThisTreeModel(String r100) {
        String r101 = this.chainPushUUid;
        if (r101 == null) goto L10;
        if (r100 != null) goto L7;
        r100 = "";
    L7:
        if (StringsKt.startsWith$default(r101, r100, false, 2, null) != true) goto L11;
        return true;
    L11:
        return false;
    L10:
        return false;
    }
}
