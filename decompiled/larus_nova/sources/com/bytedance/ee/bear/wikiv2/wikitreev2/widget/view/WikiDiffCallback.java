package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import android.text.TextUtils;
import androidx.recyclerview.widget.DiffUtil;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.d3;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0011H\u0016J\u0018\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0011H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/view/WikiDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "olds", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/model/WikiUIList;", "news", "oldFocus", "", "newFocus", "<init>", "(Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/model/WikiUIList;Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/model/WikiUIList;Ljava/lang/String;Ljava/lang/String;)V", "getOlds", "()Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/model/WikiUIList;", "getNews", "getOldFocus", "()Ljava/lang/String;", "getNewFocus", "getOldListSize", "", "getNewListSize", "areItemsTheSame", "", "oldItemPosition", "newItemPosition", "areContentsTheSame", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WikiDiffCallback extends DiffUtil.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d3 f242273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d3 f242274b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f242275c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f242276d;

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final int getNewListSize() {
        return ((ArrayList) this.f242274b.f241799a).size();
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final int getOldListSize() {
        return ((ArrayList) this.f242273a.f241799a).size();
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final boolean areContentsTheSame(int r100, int r101) {
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r102 = (com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j) ListProtector.get(this.f242273a.f241799a, r100);
        com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j r103 = (com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j) ListProtector.get(this.f242274b.f241799a, r101);
        if (CollectionsKt.getLastIndex(this.f242273a.f241799a) != r100) goto L5;
        return false;
    L5:
        if (CollectionsKt.getLastIndex(this.f242274b.f241799a) != r101) goto L8;
        return false;
    L8:
        if (TextUtils.isEmpty(this.f242275c) == true) goto L12;
        if (TextUtils.equals(this.f242275c, r103.f241914b) == false) goto L12;
    L15:
        return false;
    L12:
        if (TextUtils.isEmpty(this.f242276d) == true) goto L17;
        if (TextUtils.equals(this.f242276d, r103.f241914b) == true) goto L15;
    L17:
        if (Intrinsics.areEqual(r102.f241913a, r103.f241913a) == true) goto L19;
        return false;
    L19:
        if (Intrinsics.areEqual(r102.f241914b, r103.f241914b) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(r102.f241915c, r103.f241915c) == true) goto L23;
        return false;
    L23:
        if (r102.f241916d == r103.f241916d) goto L25;
        return false;
    L25:
        if (Intrinsics.areEqual(r102.f241917e, r103.f241917e) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(r102.f241918f, r103.f241918f) == true) goto L29;
        return false;
    L29:
        if (r102.f241919g != r103.f241919g) goto L31;
        boolean r104 = true;
    L32:
        if (r104 == true) goto L34;
        return false;
    L34:
        if (r102.f241920h == r103.f241920h) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(r102.b(), r103.b()) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(r102.f241922j, r103.f241922j) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(r102.f241926n, r103.f241926n) == true) goto L42;
        return false;
    L42:
        if (r102.f241927o == r103.f241927o) goto L44;
        return false;
    L44:
        if (r102.f241928p == r103.f241928p) goto L46;
        return false;
    L46:
        if (r102.f241929q == r103.f241929q) goto L48;
        return false;
    L48:
        if (r102.f241930r == r103.f241930r) goto L50;
        return false;
    L50:
        if (r102.f241933u == r103.f241933u) goto L52;
        return false;
    L52:
        if (Intrinsics.areEqual(r102.f241934v, r103.f241934v) == false) goto L72;
        return true;
    L72:
        return false;
    L31:
        r104 = false;
        goto L32
    }

    @Override // androidx.recyclerview.widget.DiffUtil.Callback
    public final boolean areItemsTheSame(int r100, int r101) {
        return Intrinsics.areEqual(((com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j) ListProtector.get(this.f242273a.f241799a, r100)).f241914b, ((com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j) ListProtector.get(this.f242274b.f241799a, r101)).f241914b);
    }

    public WikiDiffCallback(d3 r100, d3 r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "olds");
        Intrinsics.checkNotNullParameter(r101, "news");
        this.f242273a = r100;
        this.f242274b = r101;
        this.f242275c = r102;
        this.f242276d = r103;
    }
}
