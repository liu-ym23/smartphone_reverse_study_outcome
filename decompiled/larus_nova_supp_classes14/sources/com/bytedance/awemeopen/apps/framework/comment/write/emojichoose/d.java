package com.bytedance.awemeopen.apps.framework.comment.write.emojichoose;

import android.content.Context;
import android.view.View;
import com.bytedance.awemeopen.apps.framework.comment.write.emojichoose.choose.EmojiChooseParams;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d {
    public final Context a;
    public View b;
    public e c;
    public EmojiChooseParams d;

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof d) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((d) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "EmojiGridPageParams(ctx=" + this.a + ')';
    }

    public d(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "ctx");
        this.a = r2;
    }
}
