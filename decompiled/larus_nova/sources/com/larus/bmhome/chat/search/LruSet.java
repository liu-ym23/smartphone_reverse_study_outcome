package com.larus.bmhome.chat.search;

import androidx.exifinterface.media.ExifInterface;
import java.util.LinkedHashSet;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\u0012\u0012\u0004\u0012\u0002H\u00010\u0002j\b\u0012\u0004\u0012\u0002H\u0001`\u0003B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/larus/bmhome/chat/search/LruSet;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "maxSize", "", "<init>", "(I)V", "add", "", "element", "(Ljava/lang/Object;)Z", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LruSet<T> extends LinkedHashSet<T> {
    private final int maxSize;

    public /* bridge */ int getSize() {
        return super.size();
    }

    @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ int size() {
        return getSize();
    }

    public LruSet(int r100) {
        this.maxSize = r100;
    }

    @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(T r100) {
        if (size() < this.maxSize) goto L6;
        remove(CollectionsKt.first(this));
    L6:
        return super.add(r100);
    }
}
