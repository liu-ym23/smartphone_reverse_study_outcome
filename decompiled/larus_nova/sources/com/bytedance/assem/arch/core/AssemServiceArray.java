package com.bytedance.assem.arch.core;

import com.bytedance.assem.arch.extensions.AssemDsl;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003B\u0007¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\t\u001a\u00020\u00062\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u0007H\u0007¨\u0006\f"}, d2 = {"Lcom/bytedance/assem/arch/core/AssemServiceArray;", "Ljava/util/ArrayList;", "Lcom/bytedance/assem/arch/core/l;", "Lkotlin/collections/ArrayList;", "Lkotlin/Function1;", "Lcom/bytedance/assem/arch/core/c;", "", "Lkotlin/ExtensionFunctionType;", "builder", "service", "<init>", "()V", "assem_release"}, k = 1, mv = {1, 4, 0})
public final class AssemServiceArray extends ArrayList<l> {
    public /* bridge */ int getSize() {
        return super.size();
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return getSize();
    }

    public AssemServiceArray() {
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object r100) {
        if ((r100 instanceof l) == true) goto L5;
        return false;
    L5:
        return contains((l) r100);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object r100) {
        if ((r100 instanceof l) == true) goto L5;
        return -1;
    L5:
        return indexOf((l) r100);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object r100) {
        if ((r100 instanceof l) == true) goto L5;
        return -1;
    L5:
        return lastIndexOf((l) r100);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean remove(Object r100) {
        if ((r100 instanceof l) == true) goto L5;
        return false;
    L5:
        return remove((l) r100);
    }

    public /* bridge */ l removeAt(int r100) {
        return remove(r100);
    }

    @AssemDsl
    public final void service(Function1<? super c, Unit> r100) {
        r100.invoke(new c());
        Intrinsics.throwUninitializedPropertyAccessException("type");
        add(new l(JvmClassMappingKt.getJavaClass(null), null));
    }

    public /* bridge */ boolean contains(l r100) {
        return super.contains(r100);
    }

    public /* bridge */ int indexOf(l r100) {
        return super.indexOf(r100);
    }

    public /* bridge */ int lastIndexOf(l r100) {
        return super.lastIndexOf(r100);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ l remove(int r100) {
        return removeAt(r100);
    }

    public /* bridge */ boolean remove(l r100) {
        return super.remove(r100);
    }
}
