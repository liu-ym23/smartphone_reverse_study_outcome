package com.lark.wire.internal;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.collections.AbstractMutableList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u00042\u00060\u0005j\u0002`\u0006B\u0015\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00020\u0011H\u0096\u0002¢\u0006\u0002\u0010\u0012J\u001e\u0010\u0016\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0018J\u001d\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001bJ\u0015\u0010\u001c\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¢\u0006\u0002\u0010\u0012J\b\u0010\u001d\u001a\u00020\u001eH\u0002R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\nR\u0014\u0010\u0013\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001f"}, d2 = {"Lcom/lark/wire/internal/MutableOnWriteList;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/collections/AbstractMutableList;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "Ljava/io/Serializable;", "Lcom/lark/wire/internal/Serializable;", "immutableList", "", "<init>", "(Ljava/util/List;)V", "mutableList", "getMutableList$wire_runtime", "()Ljava/util/List;", "setMutableList$wire_runtime", MonitorConstants.CONNECT_TYPE_GET, "index", "", "(I)Ljava/lang/Object;", "size", "getSize", "()I", "set", "element", "(ILjava/lang/Object;)Ljava/lang/Object;", "add", "", "(ILjava/lang/Object;)V", "removeAt", "writeReplace", "", "wire-runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MutableOnWriteList<T> extends AbstractMutableList<T> implements RandomAccess, Serializable {
    private final List<T> immutableList;
    private List<? extends T> mutableList;

    private final Object writeReplace() throws ObjectStreamException {
        return new ArrayList(this.mutableList);
    }

    @Override // kotlin.collections.AbstractMutableList
    public int getSize() {
        return this.mutableList.size();
    }

    public final List<T> getMutableList$wire_runtime() {
        return this.mutableList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MutableOnWriteList(List<? extends T> r100) {
        Intrinsics.checkNotNullParameter(r100, "immutableList");
        this.immutableList = r100;
        this.mutableList = r100;
    }

    @Override // java.util.AbstractList, java.util.List
    public T get(int r100) {
        return (T) ListProtector.get(this.mutableList, r100);
    }

    @Override // kotlin.collections.AbstractMutableList
    public T removeAt(int r100) {
        if (this.mutableList != this.immutableList) goto L5;
        this.mutableList = new ArrayList(this.immutableList);
    L5:
        List<? extends T> r101 = this.mutableList;
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type java.util.ArrayList<T of com.lark.wire.internal.MutableOnWriteList>");
        return (T) ListProtector.remove((ArrayList) r101, r100);
    }

    public final void setMutableList$wire_runtime(List<? extends T> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.mutableList = r100;
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public void add(int r100, T r101) {
        if (this.mutableList != this.immutableList) goto L5;
        this.mutableList = new ArrayList(this.immutableList);
    L5:
        List<? extends T> r102 = this.mutableList;
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type java.util.ArrayList<T of com.lark.wire.internal.MutableOnWriteList>");
        ListProtector.add((ArrayList) r102, r100, r101);
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public T set(int r100, T r101) {
        if (this.mutableList != this.immutableList) goto L5;
        this.mutableList = new ArrayList(this.immutableList);
    L5:
        List<? extends T> r102 = this.mutableList;
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type java.util.ArrayList<T of com.lark.wire.internal.MutableOnWriteList>");
        return (T) ListProtector.set((ArrayList) r102, r100, r101);
    }
}
