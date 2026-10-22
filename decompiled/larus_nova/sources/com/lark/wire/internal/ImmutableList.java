package com.lark.wire.internal;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\u00022\u00060\u0003j\u0002`\u00042\u00060\u0005j\u0002`\u0006B\u0015\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00020\u000fH\u0096\u0002¢\u0006\u0002\u0010\u0014J\u0015\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0016H\u0014¢\u0006\u0002\u0010\u0018J\b\u0010\u0019\u001a\u00020\u0017H\u0002R \u0010\u0007\u001a\u0014\u0012\f\u0012\n \f*\u0004\u0018\u00018\u00008\u00000\u000bj\u0002`\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001a"}, d2 = {"Lcom/lark/wire/internal/ImmutableList;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/collections/AbstractList;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "Ljava/io/Serializable;", "Lcom/lark/wire/internal/Serializable;", "list", "", "<init>", "(Ljava/util/List;)V", "Ljava/util/ArrayList;", "kotlin.jvm.PlatformType", "Lkotlin/collections/ArrayList;", "size", "", "getSize", "()I", MonitorConstants.CONNECT_TYPE_GET, "index", "(I)Ljava/lang/Object;", "toArray", "", "", "()[Ljava/lang/Object;", "writeReplace", "wire-runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ImmutableList<T> extends AbstractList<T> implements RandomAccess, Serializable {
    private final ArrayList<T> list;

    private final Object writeReplace() throws ObjectStreamException {
        return Collections.unmodifiableList(this.list);
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return this.list.size();
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return this.list.toArray(new Object[0]);
    }

    public ImmutableList(List<? extends T> r100) {
        Intrinsics.checkNotNullParameter(r100, "list");
        this.list = new ArrayList(r100);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public T get(int r100) {
        return (T) ListProtector.get(this.list, r100);
    }
}
