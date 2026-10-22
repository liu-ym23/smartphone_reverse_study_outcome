package com.ss.android.lark.todo.impl.features.detail.comment;

import com.baidu.platform.comapi.map.MapController;
import com.ss.android.lark.keyboard.keyboard2.KeyboardMenuItemKey;
import com.ss.android.lark.todo.dependency.TodoDependencyHolder;
import java.util.EnumSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a1 implements com.ss.android.lark.keyboard.keyboard2.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<KeyboardMenuItemKey> f442915a;

    @Override // com.ss.android.lark.keyboard.keyboard2.e
    public final boolean n(com.ss.android.lark.keyboard.keyboard2.m r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        return true;
    }

    public a1() {
        if (TodoDependencyHolder.b().f2210a.a("todo.disable_file_upload", false) == true) goto L5;
        EnumSet r100 = EnumSet.of(KeyboardMenuItemKey.At, KeyboardMenuItemKey.Photo, KeyboardMenuItemKey.TodoAttachment);
        Intrinsics.checkNotNull(r100);
    L6:
        this.f442915a = r100;
        return;
    L5:
        r100 = EnumSet.of(KeyboardMenuItemKey.At);
        Intrinsics.checkNotNull(r100);
        goto L6
    }

    @Override // com.ss.android.lark.keyboard.keyboard2.e
    public final boolean u(com.ss.android.lark.keyboard.keyboard2.m r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        return this.f442915a.contains(r100.g());
    }
}
