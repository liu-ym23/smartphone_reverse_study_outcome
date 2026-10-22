package iec;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f489517a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f489518b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f489519c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f489520d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f489517a, r101.f489517a) == true) goto L12;
        return false;
    L12:
        if (this.f489518b == r101.f489518b) goto L15;
        return false;
    L15:
        if (this.f489519c == r101.f489519c) goto L18;
        return false;
    L18:
        if (this.f489520d == r101.f489520d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f489517a.hashCode() * 31) + this.f489518b) * 31) + this.f489519c) * 31) + this.f489520d;
    }

    public final String toString() {
        return "EmojiIconParams(context=" + this.f489517a + ", emojiSize=" + this.f489518b + ", emojiAlignment=" + this.f489519c + ", emojiTextSize=" + this.f489520d + ')';
    }

    public final Context getContext() {
        return this.f489517a;
    }

    public f(Context r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f489517a = r100;
        this.f489518b = r101;
        this.f489519c = 1;
        this.f489520d = r102;
    }
}
