package com.bytedance.jedi.ext.adapter;

import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListUpdateCallback;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.jedi.ext.adapter.internal.JediViewHolderProxy;
import com.bytedance.jedi.ext.adapter.multitype.b;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000*&\b\u0000\u0010\u0005*\u0006\u0012\u0002\b\u00030\u0001*\u0018\u0012\u0002\b\u0003\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0002j\u0006\u0012\u0002\b\u0003`\u00042\u00020\u0006B%\u0012\u0006\u0010\u0007\u001a\u00028\u0000\u0012\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/jedi/ext/adapter/JediListUpdateCallback;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/jedi/ext/adapter/multitype/b;", "Lcom/bytedance/jedi/ext/adapter/f;", "Lcom/bytedance/jedi/ext/adapter/JediViewHolderFactoryManagerOwner;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/recyclerview/widget/ListUpdateCallback;", "adapter", "Lkotlin/Function1;", "", "positionMapper", "<init>", "(Landroid/support/v7/widget/RecyclerView$Adapter;Lkotlin/jvm/functions/Function1;)V", "ext_adapter_release"}, k = 1, mv = {1, 4, 0})
public final class JediListUpdateCallback<T extends RecyclerView.Adapter<?> & com.bytedance.jedi.ext.adapter.multitype.b<?, ? extends f<?>>> implements ListUpdateCallback {

    /* JADX INFO: Incorrect field signature: TT; */
    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView.Adapter f250954a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<Integer, Integer> f250955b;

    /* JADX INFO: renamed from: com.bytedance.jedi.ext.adapter.JediListUpdateCallback$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0010\t\u001a\u00020\u0005\"&\b\u0000\u0010\u0004*\u0006\u0012\u0002\b\u00030\u0000*\u0018\u0012\u0002\b\u0003\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001j\u0006\u0012\u0002\b\u0003`\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/jedi/ext/adapter/multitype/b;", "Lcom/bytedance/jedi/ext/adapter/f;", "Lcom/bytedance/jedi/ext/adapter/JediViewHolderFactoryManagerOwner;", ExifInterface.GPS_DIRECTION_TRUE, "", "it", AbsMethodDelegate.TAG_INVOKE, "(I)I", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    public static final class AnonymousClass1 extends Lambda implements Function1<Integer, Integer> {
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

    public final com.bytedance.jedi.ext.adapter.internal.d a() {
        return ((f) ((com.bytedance.jedi.ext.adapter.multitype.b) this.f250954a).n()).f250999e.f251022c;
    }

    /* JADX WARN: Incorrect types in method signature: (TT;Lkotlin/jvm/functions/Function1<-Ljava/lang/Integer;Ljava/lang/Integer;>;)V */
    public JediListUpdateCallback(RecyclerView.Adapter r100, Function1 r101) {
        this.f250954a = r100;
        this.f250955b = r101;
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public final void onInserted(int r100, int r101) {
        if (r101 != 0) goto L4;
        return;
    L4:
        int r102 = 0;
    L5:
        if (r102 >= r101) goto L7;
        int r103 = r100 + r102;
        ((f) ((com.bytedance.jedi.ext.adapter.multitype.b) this.f250954a).n()).f250999e.f251021b.a(r103, false);
        a().b(r103, null);
        r102 = r102 + 1;
        goto L5
    L7:
        com.bytedance.jedi.ext.adapter.internal.a r104 = ((f) ((com.bytedance.jedi.ext.adapter.multitype.b) this.f250954a).n()).f251043d;
        RecyclerView r105 = r104.f251028b.f250986a;
        if (r105 == null) goto L15;
        RecyclerView.LayoutManager r106 = r105.getLayoutManager();
        if ((r106 instanceof LinearLayoutManager) == false) goto L13;
        r104.f251027a = ((LinearLayoutManager) r106).findFirstVisibleItemPosition();
        goto L15
    L13:
        if ((r106 instanceof StaggeredGridLayoutManager) == false) goto L15;
        StaggeredGridLayoutManager r107 = (StaggeredGridLayoutManager) r106;
        r104.f251027a = r107.findFirstVisibleItemPositions(new int[r107.getSpanCount()])[0];
    L15:
        int r108 = this.f250955b.invoke(Integer.valueOf(r100)).intValue();
        this.f250954a.notifyItemRangeInserted(r108, r101);
        com.bytedance.jedi.ext.adapter.internal.a r109 = ((f) ((com.bytedance.jedi.ext.adapter.multitype.b) this.f250954a).n()).f251043d;
        RecyclerView r110 = r109.f251028b.f250986a;
        if (r110 == null) goto L30;
        int r111 = r109.f251027a;
        if (r111 == (-241)) goto L33;
        if (r111 < r108) goto L34;
        RecyclerView.LayoutManager r112 = r110.getLayoutManager();
        if ((r112 instanceof LinearLayoutManager) == false) goto L26;
        r112.scrollToPosition(r109.f251027a);
        return;
    L26:
        if ((r112 instanceof StaggeredGridLayoutManager) == false) goto L32;
        r112.scrollToPosition(r109.f251027a);
        return;
    L32:
        return;
    L34:
        return;
    L33:
        return;
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public final void onMoved(int r100, int r101) {
        ArrayList r102 = (ArrayList) ((f) ((com.bytedance.jedi.ext.adapter.multitype.b) this.f250954a).n()).f250999e.f251021b.f251030a;
        if (r100 < r102.size()) goto L5;
    L7:
        ArrayList r103 = (ArrayList) a().f251032a;
        if (r100 < r103.size()) goto L10;
    L12:
        this.f250954a.notifyItemMoved(this.f250955b.invoke(Integer.valueOf(r100)).intValue(), this.f250955b.invoke(Integer.valueOf(r101)).intValue());
        return;
    L10:
        if (r101 >= r103.size()) goto L12;
        JediViewHolderProxy r104 = (JediViewHolderProxy) ListProtector.get(r103, r100);
        ListProtector.set(r103, r100, ListProtector.get(r103, r101));
        ListProtector.set(r103, r101, r104);
        goto L12
    L5:
        if (r101 >= r102.size()) goto L7;
        boolean r105 = ((Boolean) ListProtector.get(r102, r100)).booleanValue();
        ListProtector.set(r102, r100, ListProtector.get(r102, r101));
        ListProtector.set(r102, r101, Boolean.valueOf(r105));
        goto L7
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public final void onRemoved(int r100, int r101) {
        if (r101 != 0) goto L4;
        return;
    L4:
        com.bytedance.jedi.ext.adapter.internal.b r102 = ((f) ((com.bytedance.jedi.ext.adapter.multitype.b) this.f250954a).n()).f250999e.f251021b;
        if (r100 == 0) goto L7;
    L13:
        int r103 = 0;
    L14:
        if (r103 >= r101) goto L26;
        if (r100 >= ((ArrayList) r102.f251030a).size()) goto L19;
        ListProtector.remove(r102.f251030a, r100);
    L19:
        com.bytedance.jedi.ext.adapter.internal.d r104 = a();
        if (r100 >= ((ArrayList) r104.f251032a).size()) goto L25;
        JediViewHolderProxy r105 = (JediViewHolderProxy) ListProtector.remove(r104.f251032a, r100);
        if (r105 == null) goto L25;
        r104.f251033b.a(r105);
    L25:
        r103 = r103 + 1;
        goto L14
    L26:
        this.f250954a.notifyItemRangeRemoved(this.f250955b.invoke(Integer.valueOf(r100)).intValue(), r101);
        return;
    L7:
        if (r101 < ((ArrayList) r102.f251030a).size()) goto L13;
        if (((ArrayList) r102.f251030a).size() == 0) goto L12;
        ((ArrayList) r102.f251030a).clear();
    L12:
        a().a();
        this.f250954a.notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.ListUpdateCallback
    public final void onChanged(int r100, int r101, Object r102) {
        this.f250954a.notifyItemRangeChanged(this.f250955b.invoke(Integer.valueOf(r100)).intValue(), r101, TuplesKt.to(r102, c.f250964a));
    }
}
