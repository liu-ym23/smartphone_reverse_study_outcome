package com.ss.android.lark.chat.cot.detail.blueprint;

import androidx.recyclerview.widget.AsyncListDiffer;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.blueprint.recyclerview.BlueprintAdapter;
import com.ss.android.lark.chat.cot.detail.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0014J\b\u0010\u0014\u001a\u00020\u0013H\u0016J \u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\r2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0010\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\u00020\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/chat/cot/detail/blueprint/CotDetailBlueprintAdapter;", "Lcom/ss/android/lark/blueprint/recyclerview/BlueprintAdapter;", "Lcom/ss/android/lark/chat/cot/detail/CotDetailItem;", "blueprint", "Lcom/ss/android/lark/blueprint/Blueprint;", "<init>", "(Lcom/ss/android/lark/blueprint/Blueprint;)V", "getBlueprint", "()Lcom/ss/android/lark/blueprint/Blueprint;", "differ", "Landroidx/recyclerview/widget/AsyncListDiffer;", "kotlin.jvm.PlatformType", "currentList", "", "getCurrentList", "()Ljava/util/List;", "getItemData", "", "position", "", "getItemCount", "submitList", "", "list", "commitCallback", "Ljava/lang/Runnable;", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CotDetailBlueprintAdapter extends BlueprintAdapter<k> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final CotDetailBlueprintAdapter$Companion$DIFF_CALLBACK$1 f414850d = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.ss.android.lark.blueprint.d f414851b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AsyncListDiffer<k> f414852c;

    public static final class a {
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.ss.android.lark.chat.cot.detail.blueprint.CotDetailBlueprintAdapter$Companion$DIFF_CALLBACK$1] */
    static {
        f414850d = new CotDetailBlueprintAdapter$Companion$DIFF_CALLBACK$1();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f414852c.getCurrentList().size();
    }

    @Override // com.ss.android.lark.blueprint.recyclerview.BlueprintAdapter
    public final com.ss.android.lark.blueprint.d y2() {
        return this.f414851b;
    }

    public CotDetailBlueprintAdapter(com.ss.android.lark.blueprint.d r100) {
        Intrinsics.checkNotNullParameter(r100, "blueprint");
        this.f414851b = r100;
        this.f414852c = new AsyncListDiffer(this, f414850d);
    }

    @Override // com.ss.android.lark.blueprint.recyclerview.BlueprintAdapter
    public final Object z2(int r100) {
        return ListProtector.get(this.f414852c.getCurrentList(), r100);
    }
}
