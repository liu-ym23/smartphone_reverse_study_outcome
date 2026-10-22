package zq5;

import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class b {
    public String chainPushUUid;

    public b() {
    }

    public final boolean isHitThisTreeModel(String r5) {
        String r0 = this.chainPushUUid;
        if (r0 == null) goto L10;
        if (r5 != null) goto L7;
        r5 = "";
    L7:
        if (StringsKt.startsWith$default(r0, r5, false, 2, null) != true) goto L11;
        return true;
    L11:
        return false;
    L10:
        return false;
    }
}
