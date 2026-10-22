package com.ss.android.lark.todo.impl.features.detail.comment;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.lark.pb.todo.v1.TodoComment;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class v implements com.larksuite.framework.section.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TodoComment f442996a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f442997b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f442998c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof v) == true) goto L8;
        return false;
    L8:
        v r101 = (v) r100;
        if (Intrinsics.areEqual(this.f442996a, r101.f442996a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f442997b, r101.f442997b) == true) goto L15;
        return false;
    L15:
        if (this.f442998c == r101.f442998c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f442996a.hashCode() * 31) + this.f442997b.hashCode()) * 31) + this.f442998c;
    }

    public final String toString() {
        return "CommentItemReactionInfo(item=" + this.f442996a + ", reactionKey=" + this.f442997b + ", reactionSource=" + this.f442998c + ')';
    }

    public v(TodoComment r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r101, "reactionKey");
        this.f442996a = r100;
        this.f442997b = r101;
        this.f442998c = r102;
    }
}
