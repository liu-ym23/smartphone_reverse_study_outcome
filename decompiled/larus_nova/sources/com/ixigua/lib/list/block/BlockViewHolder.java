package com.ixigua.lib.list.block;

import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import com.ixigua.lib.list.ListAgency;
import com.ixigua.lib.list.simple.ListViewHolder;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00020\u0003:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/ixigua/lib/list/block/BlockViewHolder;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/ixigua/lib/list/simple/ListViewHolder;", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liblist_release"}, k = 1, mv = {1, 4, 0})
public final class BlockViewHolder<T> extends ListViewHolder<T> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final BlockContainer f278514e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ConcurrentHashMap<Block<?>, View> f278515f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List<? extends Block<?>> f278516g;

    public static final class a {
    }

    static {
    }

    @Override // com.ixigua.lib.list.simple.ListViewHolder
    public final void W3() {
        List<? extends Block<?>> r100 = this.f278516g;
        if (r100 == null) goto L8;
        Iterator<T> r101 = r100.iterator();
    L6:
        if (r101.hasNext() == false) goto L10;
        ((Block) r101.next()).getClass();
        ListAgency.f278497d.getClass();
        goto L6
    L10:
        return;
    }

    @Override // com.ixigua.lib.list.simple.ListViewHolder
    public final void X3() {
        List<? extends Block<?>> r100 = this.f278516g;
        if (r100 == null) goto L8;
        Iterator<T> r101 = r100.iterator();
    L6:
        if (r101.hasNext() == false) goto L10;
        ((Block) r101.next()).getClass();
        ListAgency.f278497d.getClass();
        goto L6
    L10:
        return;
    }

    public final void Z3() {
        List<? extends Block<?>> r100 = this.f278516g;
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.f278515f.size() < r100.size()) goto L18;
        ArrayList r101 = new ArrayList();
        Iterator<? extends Block<?>> r102 = r100.iterator();
    L8:
        if (r102.hasNext() == false) goto L13;
        Block<?> r103 = r102.next();
        View r104 = this.f278515f.get(r103);
        if (r104 == null) goto L12;
        r101.add(r104);
        goto L8
    L12:
        return;
    L13:
        ListAgency.f278497d.getClass();
        this.f278514e.a(r101);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ixigua.lib.list.simple.ListViewHolder
    public final void T3(T r100) {
        this.f278523a = r100;
        if (this.f278514e.f278510b == false) goto L5;
        Z3();
    L5:
        List<? extends Block<?>> r101 = this.f278516g;
        if (r101 == null) goto L16;
        Iterator<T> r102 = r101.iterator();
    L9:
        if (r102.hasNext() == false) goto L25;
        Block r103 = (Block) r102.next();
        r103.getClass();
        r103.f278505b = r100;     // Catch: Throwable -> L15
        if (r103.f278508e == null) goto L9;
        r103.b();     // Catch: Throwable -> L15
    L15:
        ListAgency.f278497d.getClass();
        goto L9
    L25:
        return;
    }

    public final void Y3(List<? extends Block<?>> r100) {
        List<? extends Block<?>> r101 = this.f278516g;
        if (r101 == null) goto L11;
        ListAgency.f278497d.getClass();
        this.f278514e.removeAllViews();
        this.f278515f.clear();
        Iterator<? extends Block<?>> r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L11;
        Block<?> r103 = r102.next();
        WeakReference<BlockViewHolder<?>> r104 = r103.f278506c;
        if (r104 == null) goto L10;
        r104.clear();
    L10:
        r103.f278506c = null;
        Block.a(r103.f278508e);
        ListAgency.f278497d.getClass();
        r103.f278504a.clear();
    L11:
        if (r100 == null) goto L32;
        ListAgency.f278497d.getClass();
        this.f278515f.clear();
        Iterator<? extends Block<?>> r105 = r100.iterator();
    L14:
        if (r105.hasNext() == false) goto L32;
        Block<?> r106 = r105.next();
        r106.getClass();
        r106.f278506c = new WeakReference(this);
        View r107 = r106.f278508e;
        if (r107 == null) goto L18;
        Block.a(r107);
        View r108 = r106.f278508e;
        if (r108 != null) goto L24;
        Intrinsics.throwNpe();
    L24:
        this.f278515f.put(r106, r108);
        ListAgency.f278497d.getClass();
        Z3();
    L25:
        ListAgency.f278497d.getClass();
        T r109 = this.f278523a;
        if (r109 == 0) goto L14;
        r106.f278505b = r109;     // Catch: Throwable -> L31
        if (r106.f278508e == null) goto L14;
        r106.b();     // Catch: Throwable -> L31
    L31:
        ListAgency.f278497d.getClass();
        goto L14
    L18:
        if (r106.f278507d == true) goto L25;
        r106.f278507d = true;
        Intrinsics.throwNpe();
        Intrinsics.throwNpe();
    L32:
        this.f278516g = r100;
    }

    public BlockViewHolder(ViewGroup r100, int r101) {
        BlockContainer r102 = new BlockContainer(r100.getContext());
        r102.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        r102.setDefaultHeight(r101);
        super(r102);
        View r103 = this.itemView;
        if (r103 == null) goto L7;
        this.f278514e = (BlockContainer) r103;
        this.f278515f = new ConcurrentHashMap();
        return;
    L7:
        throw new TypeCastException("null cannot be cast to non-null type com.ixigua.lib.list.block.BlockContainer");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ixigua.lib.list.simple.ListViewHolder
    public final void U3(T r100, List<? extends Object> r101) {
        this.f278523a = r100;
        if (this.f278514e.f278510b == false) goto L5;
        Z3();
    L5:
        List<? extends Block<?>> r102 = this.f278516g;
        if (r102 == null) goto L20;
        Iterator<T> r103 = r102.iterator();
    L9:
        if (r103.hasNext() == false) goto L31;
        Block r104 = (Block) r103.next();
        Iterator<? extends Object> r105 = r101.iterator();
    L12:
        if (r105.hasNext() == false) goto L9;
        Object r106 = r105.next();
        if (Intrinsics.areEqual(r104.getClass(), r106) == false) goto L12;
        r104.f278505b = r100;     // Catch: Throwable -> L19
        if (r104.f278508e == null) goto L12;
        r104.b();     // Catch: Throwable -> L19
    L19:
        ListAgency.f278497d.getClass();
        goto L12
    L31:
        return;
    }
}
