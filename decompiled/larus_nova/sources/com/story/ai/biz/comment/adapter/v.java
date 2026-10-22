package com.story.ai.biz.comment.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.larus.nova.R;
import com.story.ai.biz.comment.model.CommentSection;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class v extends dnc.a<CommentSection> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<ViewGroup, Unit> f459838a;

    @Override // dnc.a
    public final int c() {
        return R.layout.larus_comment_section_footer_layout;
    }

    @Override // dnc.a
    public final int b() {
        return CommentSection.CommentItemType.FOOTER.ordinal();
    }

    public v(h r100) {
        Intrinsics.checkNotNullParameter(r100, "footCreator");
        this.f459838a = r100;
    }

    @Override // dnc.a
    public final void a(RecyclerView.ViewHolder r100, CommentSection r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
        View r103 = r100.itemView;
        if ((r103 instanceof ViewGroup) == false) goto L5;
        ViewGroup r104 = (ViewGroup) r103;
    L6:
        if (r104 == null) goto L8;
        this.f459838a.invoke(r104);
    L8:
        Intrinsics.checkNotNullParameter(r100, "holder");
        return;
    L5:
        r104 = null;
        goto L6
    }
}
