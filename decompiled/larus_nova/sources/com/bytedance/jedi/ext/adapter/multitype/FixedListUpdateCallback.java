package com.bytedance.jedi.ext.adapter.multitype;

import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.ListUpdateCallback;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import com.bytedance.jedi.ext.adapter.multitype.b;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000*&\b\u0000\u0010\u0005*\u0006\u0012\u0002\b\u00030\u0001*\u0018\u0012\u0002\b\u0003\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0002j\u0006\u0012\u0002\b\u0003`\u00042\u00020\u0006B%\u0012\u0006\u0010\u0007\u001a\u00028\u0000\u0012\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/jedi/ext/adapter/multitype/FixedListUpdateCallback;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/jedi/ext/adapter/multitype/b;", "Lcom/bytedance/jedi/ext/adapter/multitype/ViewHolderFactoryManager;", "Lcom/bytedance/jedi/ext/adapter/multitype/ViewHolderFactoryManagerOwner;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/recyclerview/widget/ListUpdateCallback;", "adapter", "Lkotlin/Function1;", "", "positionMapper", "<init>", "(Landroid/support/v7/widget/RecyclerView$Adapter;Lkotlin/jvm/functions/Function1;)V", "ext_adapter_release"}, k = 1, mv = {1, 4, 0})
public final class FixedListUpdateCallback<T extends RecyclerView.Adapter<?> & b<?, ? extends ViewHolderFactoryManager<?>>> implements ListUpdateCallback {

    /* JADX INFO: renamed from: com.bytedance.jedi.ext.adapter.multitype.FixedListUpdateCallback$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0010\t\u001a\u00020\u0005\"&\b\u0000\u0010\u0004*\u0006\u0012\u0002\b\u00030\u0000*\u0018\u0012\u0002\b\u0003\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001j\u0006\u0012\u0002\b\u0003`\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/jedi/ext/adapter/multitype/b;", "Lcom/bytedance/jedi/ext/adapter/multitype/ViewHolderFactoryManager;", "Lcom/bytedance/jedi/ext/adapter/multitype/ViewHolderFactoryManagerOwner;", ExifInterface.GPS_DIRECTION_TRUE, "", "it", AbsMethodDelegate.TAG_INVOKE, "(I)I", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    final class AnonymousClass1 extends Lambda implements Function1<Integer, Integer> {
        public static final AnonymousClass1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        public AnonymousClass1() {
            super(1);
        }

        public final int invoke(int r100) {
            return r100;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Integer invoke(Integer r100) {
            return Integer.valueOf(invoke(r100.intValue()));
        }
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public final void onInserted(int r100, int r101) {
        if (r101 != 0) goto L5;
        return;
    L5:
        throw null;
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public final void onMoved(int r100, int r101) {
        throw null;
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public final void onRemoved(int r100, int r101) {
        if (r101 != 0) goto L5;
        return;
    L5:
        throw null;
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public final void onChanged(int r100, int r101, Object r102) {
        throw null;
    }
}
