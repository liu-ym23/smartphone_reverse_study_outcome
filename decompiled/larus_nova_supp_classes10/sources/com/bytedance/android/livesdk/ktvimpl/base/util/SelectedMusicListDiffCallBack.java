package com.bytedance.android.livesdk.ktvimpl.base.util;

import androidx.recyclerview.widget.DiffUtil;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/util/SelectedMusicListDiffCallBack;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SelectedMusicListDiffCallBack extends DiffUtil.Callback {
    public final List<Object> a;
    public final List<Object> b;

    public static final class a {
    }

    static {
    }

    public final int getNewListSize() {
        return this.b.size();
    }

    public final int getOldListSize() {
        return this.a.size();
    }

    public SelectedMusicListDiffCallBack(List<? extends Object> r2, List<? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r2, "oldDataList");
        Intrinsics.checkNotNullParameter(r3, "newDataList");
        this.a = r2;
        this.b = r3;
    }

    public final boolean areContentsTheSame(int r5, int r6) {
        if (r5 != r6) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == true) goto L8;
        return false;
    L8:
        Object r7 = ListProtector.get(this.a, r5);
        Object r8 = ListProtector.get(this.b, r6);
        if (Intrinsics.areEqual(r7.getClass(), r8.getClass()) == true) goto L12;
        return false;
    L12:
        if ((r7 instanceof com.bytedance.android.livesdk.ktvimpl.ktvroom.view.dialog.selected.d) == false) goto L23;
        if ((r8 instanceof com.bytedance.android.livesdk.ktvimpl.ktvroom.view.dialog.selected.d) == false) goto L23;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.view.dialog.selected.d r9 = (com.bytedance.android.livesdk.ktvimpl.ktvroom.view.dialog.selected.d) r7;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.view.dialog.selected.d r10 = (com.bytedance.android.livesdk.ktvimpl.ktvroom.view.dialog.selected.d) r8;
        if (com.bytedance.android.live.ktv.common.util.KtvUtilsKt.u(r9.a, r10.a) == true) goto L18;
    L20:
        return false;
    L18:
        if (r9.b.a(r10.b) == false) goto L20;
        return true;
    L23:
        if ((r7 instanceof com.bytedance.android.livesdk.ktvimpl.ktvroom.view.dialog.selected.b.a) == true) goto L25;
    L33:
        return false;
    L25:
        if ((r8 instanceof com.bytedance.android.livesdk.ktvimpl.ktvroom.view.dialog.selected.b.a) == false) goto L33;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.view.dialog.selected.b.a r11 = (com.bytedance.android.livesdk.ktvimpl.ktvroom.view.dialog.selected.b.a) r7;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.view.dialog.selected.b.a r12 = (com.bytedance.android.livesdk.ktvimpl.ktvroom.view.dialog.selected.b.a) r8;
        if (com.bytedance.android.live.ktv.common.util.KtvUtilsKt.u(r11.a, r12.a) == true) goto L29;
    L31:
        return false;
    L29:
        if (r11.b.a(r12.b) == false) goto L31;
        return true;
    L5:
        r2 = false;
        goto L6
    }

    public final boolean areItemsTheSame(int r4, int r5) {
        if (r4 != r5) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == true) goto L8;
        return false;
    L8:
        Object r6 = ListProtector.get(this.a, r4);
        Object r7 = ListProtector.get(this.b, r5);
        if (Intrinsics.areEqual(r6.getClass(), r7.getClass()) == true) goto L11;
        return false;
    L11:
        return true;
    L5:
        r2 = false;
        goto L6
    }
}
