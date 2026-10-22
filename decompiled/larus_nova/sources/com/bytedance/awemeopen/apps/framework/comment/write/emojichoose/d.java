package com.bytedance.awemeopen.apps.framework.comment.write.emojichoose;

import android.content.Context;
import android.view.View;
import com.bytedance.awemeopen.apps.framework.comment.write.emojichoose.choose.EmojiChooseParams;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f194454a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f194455b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e f194456c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public EmojiChooseParams f194457d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f194454a, ((d) r100).f194454a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f194454a.hashCode();
    }

    public final String toString() {
        return "EmojiGridPageParams(ctx=" + this.f194454a + ')';
    }

    public d(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        this.f194454a = r100;
    }
}
