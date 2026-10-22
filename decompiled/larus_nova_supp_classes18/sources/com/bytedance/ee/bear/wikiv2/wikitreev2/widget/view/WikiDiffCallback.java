package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import android.text.TextUtils;
import androidx.recyclerview.widget.DiffUtil;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.d3;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0011H\u0016J\u0018\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0011H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "olds", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/model/WikiUIList;", "news", "oldFocus", "", "newFocus", "<init>", "(Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/model/WikiUIList;Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/model/WikiUIList;Ljava/lang/String;Ljava/lang/String;)V", "getOlds", "()Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/model/WikiUIList;", "getNews", "getOldFocus", "()Ljava/lang/String;", "getNewFocus", "getOldListSize", "", "getNewListSize", "areItemsTheSame", "", "oldItemPosition", "newItemPosition", "areContentsTheSame", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WikiDiffCallback extends DiffUtil.Callback {
    public final d3 a;
    public final d3 b;
    public final String c;
    public final String d;

    public final int getNewListSize() {
        return ((ArrayList) this.b.a).size();
    }

    public final int getOldListSize() {
        return ((ArrayList) this.a.a).size();
    }

    public final boolean areContentsTheSame(int r8, int r9) {
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r0 = (com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j) ListProtector.get(this.a.a, r8);
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r1 = (com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j) ListProtector.get(this.b.a, r9);
        if (CollectionsKt.getLastIndex(this.a.a) != r8) goto L5;
        return false;
    L5:
        if (CollectionsKt.getLastIndex(this.b.a) != r9) goto L8;
        return false;
    L8:
        if (TextUtils.isEmpty(this.c) == true) goto L12;
        if (TextUtils.equals(this.c, r1.b) == false) goto L12;
    L15:
        return false;
    L12:
        if (TextUtils.isEmpty(this.d) == true) goto L17;
        if (TextUtils.equals(this.d, r1.b) == true) goto L15;
    L17:
        if (Intrinsics.areEqual(r0.a, r1.a) == true) goto L19;
        return false;
    L19:
        if (Intrinsics.areEqual(r0.b, r1.b) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(r0.c, r1.c) == true) goto L23;
        return false;
    L23:
        if (r0.d == r1.d) goto L25;
        return false;
    L25:
        if (Intrinsics.areEqual(r0.e, r1.e) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(r0.f, r1.f) == true) goto L29;
        return false;
    L29:
        if (r0.g != r1.g) goto L31;
        boolean r10 = true;
    L32:
        if (r10 == true) goto L34;
        return false;
    L34:
        if (r0.h == r1.h) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(r0.b(), r1.b()) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(r0.j, r1.j) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(r0.n, r1.n) == true) goto L42;
        return false;
    L42:
        if (r0.o == r1.o) goto L44;
        return false;
    L44:
        if (r0.p == r1.p) goto L46;
        return false;
    L46:
        if (r0.q == r1.q) goto L48;
        return false;
    L48:
        if (r0.r == r1.r) goto L50;
        return false;
    L50:
        if (r0.u == r1.u) goto L52;
        return false;
    L52:
        if (Intrinsics.areEqual(r0.v, r1.v) == false) goto L72;
        return true;
    L72:
        return false;
    L31:
        r10 = false;
        goto L32
    }

    public final boolean areItemsTheSame(int r2, int r3) {
        return Intrinsics.areEqual(((com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j) ListProtector.get(this.a.a, r2)).b, ((com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j) ListProtector.get(this.b.a, r3)).b);
    }

    public WikiDiffCallback(d3 r2, d3 r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "olds");
        Intrinsics.checkNotNullParameter(r3, "news");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
