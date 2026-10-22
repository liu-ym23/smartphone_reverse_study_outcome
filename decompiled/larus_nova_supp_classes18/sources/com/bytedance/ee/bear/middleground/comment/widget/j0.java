package com.bytedance.ee.bear.middleground.comment.widget;

import com.alibaba.fastjson.JSON;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j0 {
    public final b a;
    public final List<String> b;
    public final List<Long> c;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[BotAtHintActionType.values().length];
            r0[BotAtHintActionType.CONFIGURE_NOW.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[BotAtHintActionType.LEARN_MORE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof j0) == true) goto L8;
        return false;
    L8:
        j0 r6 = (j0) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public final String toString() {
        return "DisplayBotAtHintItem(hintInfo=" + this.a + ", botNames=" + this.b + ", botIds=" + this.c + ')';
    }

    public final String a() {
        if (this.c.size() == 1) goto L7;
        String r0 = JSON.toJSONString(this.c);
        Intrinsics.checkNotNull(r0);
        return r0;
    L7:
        return String.valueOf(((Number) CollectionsKt.first(this.c)).longValue());
    }

    public final String b() {
        BotAtHintActionType r0 = this.a.c;
        int r1 = a.a[r0.ordinal()];
        if (r1 != 1) goto L5;
        return "bot_reply_conf";
    L5:
        if (r1 != 2) goto L8;
        return "bot_reply_more";
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public final String c() {
        return b() + '#' + a();
    }

    public j0(b r2, List<String> r3, List<Long> r4) {
        Intrinsics.checkNotNullParameter(r2, "hintInfo");
        Intrinsics.checkNotNullParameter(r3, "botNames");
        Intrinsics.checkNotNullParameter(r4, "botIds");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
