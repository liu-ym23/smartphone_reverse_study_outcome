package com.bytedance.ee.bear.middleground.comment.widget;

import com.alibaba.fastjson.JSON;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f232338a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f232339b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Long> f232340c;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f232341a = null;

        static {
            int[] r100 = new int[BotAtHintActionType.values().length];
            r100[BotAtHintActionType.CONFIGURE_NOW.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[BotAtHintActionType.LEARN_MORE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f232341a = r100;
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j0) == true) goto L8;
        return false;
    L8:
        j0 r101 = (j0) r100;
        if (Intrinsics.areEqual(this.f232338a, r101.f232338a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f232339b, r101.f232339b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f232340c, r101.f232340c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f232338a.hashCode() * 31) + this.f232339b.hashCode()) * 31) + this.f232340c.hashCode();
    }

    public final String toString() {
        return "DisplayBotAtHintItem(hintInfo=" + this.f232338a + ", botNames=" + this.f232339b + ", botIds=" + this.f232340c + ')';
    }

    public final String a() {
        if (this.f232340c.size() == 1) goto L7;
        String r100 = JSON.toJSONString(this.f232340c);
        Intrinsics.checkNotNull(r100);
        return r100;
    L7:
        return String.valueOf(((Number) CollectionsKt.first(this.f232340c)).longValue());
    }

    public final String b() {
        BotAtHintActionType r100 = this.f232338a.f232320c;
        int r101 = a.f232341a[r100.ordinal()];
        if (r101 != 1) goto L5;
        return "bot_reply_conf";
    L5:
        if (r101 != 2) goto L8;
        return "bot_reply_more";
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public final String c() {
        return b() + '#' + a();
    }

    public j0(b r100, List<String> r101, List<Long> r102) {
        Intrinsics.checkNotNullParameter(r100, "hintInfo");
        Intrinsics.checkNotNullParameter(r101, "botNames");
        Intrinsics.checkNotNullParameter(r102, "botIds");
        this.f232338a = r100;
        this.f232339b = r101;
        this.f232340c = r102;
    }
}
