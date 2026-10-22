package com.bytedance.expressecom.util;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.platform.comapi.map.MapController;
import java.util.ArrayList;
import java.util.EmptyStackException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u000b\u0010\u0006\u001a\u00028\u0000¢\u0006\u0002\u0010\u0007J\u000b\u0010\b\u001a\u00028\u0000¢\u0006\u0002\u0010\u0007J\u0013\u0010\t\u001a\u00028\u00002\u0006\u0010\n\u001a\u00028\u0000¢\u0006\u0002\u0010\u000bJ\u0010\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/expressecom/util/ExprStack;", ExifInterface.LONGITUDE_EAST, "Ljava/util/ArrayList;", "()V", "empty", "", "peek", "()Ljava/lang/Object;", "pop", "push", MapController.ITEM_LAYER_TAG, "(Ljava/lang/Object;)Ljava/lang/Object;", "search", "", "o", "", "express-ecom_release"}, k = 1, mv = {1, 1, 16})
public final class ExprStack<E> extends ArrayList<E> {
    public final boolean empty() {
        return isEmpty();
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    public final E peek() {
        int r100 = size();
        if (r100 == 0) goto L7;
        return get(r100 - 1);
    L7:
        throw new EmptyStackException();
    }

    public final E pop() {
        return remove(size() - 1);
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return getSize();
    }

    public ExprStack() {
    }

    public final E push(E r100) {
        add(r100);
        return r100;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public final /* bridge */ E remove(int r100) {
        return (E) removeAt(r100);
    }

    public /* bridge */ Object removeAt(int r100) {
        return super.remove(r100);
    }

    public final int search(Object r100) {
        int r101 = CollectionsKt.lastIndexOf(this, r100);
        if (r101 >= 0) goto L7;
        return -1;
    L7:
        return size() - r101;
    }
}
