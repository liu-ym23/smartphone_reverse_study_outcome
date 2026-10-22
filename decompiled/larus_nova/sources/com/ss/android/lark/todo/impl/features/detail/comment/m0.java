package com.ss.android.lark.todo.impl.features.detail.comment;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.lark.pb.todo.v1.TodoComment;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class m0 implements com.larksuite.framework.section.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f442960a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TodoComment f442961b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m0) == true) goto L8;
        return false;
    L8:
        m0 r101 = (m0) r100;
        if (this.f442960a == r101.f442960a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f442961b, r101.f442961b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f442960a * 31) + this.f442961b.hashCode();
    }

    public final String toString() {
        return "CommentReplyInfo(position=" + this.f442960a + ", item=" + this.f442961b + ')';
    }

    public m0(int r100, TodoComment r101) {
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
        this.f442960a = r100;
        this.f442961b = r101;
    }
}
