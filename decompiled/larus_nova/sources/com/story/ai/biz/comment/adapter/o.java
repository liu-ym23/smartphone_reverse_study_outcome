package com.story.ai.biz.comment.adapter;

import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.larus.platform.model.comment.api.CommentItemCustomType;
import com.story.ai.biz.comment.model.CommentSection;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class o extends dnc.a<CommentSection> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ rq9.e f459831a;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f459832a = null;

        static {
            int[] r100 = new int[CommentItemCustomType.values().length];
            r100[CommentItemCustomType.LOADING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[CommentItemCustomType.EMPTY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[CommentItemCustomType.FAIL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f459832a = r100;
        }
    }

    @Override // dnc.a
    public final int b() {
        CommentItemCustomType r100 = this.f459831a.c();
        int r101 = a.f459832a[r100.ordinal()];
        if (r101 == 1) goto L13;
        if (r101 == 2) goto L15;
        if (r101 != 3) goto L10;
        return CommentSection.CommentItemType.FAIL.ordinal();
    L10:
        throw new NoWhenBranchMatchedException();
    L15:
        return CommentSection.CommentItemType.EMPTY.ordinal();
    L13:
        return CommentSection.CommentItemType.LOADING.ordinal();
    }

    @Override // dnc.a
    public final int c() {
        return this.f459831a.a();
    }

    public o(rq9.e r100) {
        this.f459831a = r100;
    }

    @Override // dnc.a
    public final void a(RecyclerView.ViewHolder r100, CommentSection r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r100, "holder");
        this.f459831a.b(r100);
    }
}
