package com.ss.android.ugc.aweme.framework.services.dyext;

import com.ss.android.ugc.aweme.framework.services.dyext.api.IPluginInitializer;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/ss/android/ugc/aweme/framework/services/dyext/PluginInitializerList;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/ss/android/ugc/aweme/framework/services/dyext/api/IPluginInitializer;", "()V", "isInit", "", "()Z", "setInit", "(Z)V", "dy-ext-spi_release"}, k = 1, mv = {1, 1, 15})
public final class PluginInitializerList extends CopyOnWriteArrayList<IPluginInitializer> {
    private volatile boolean isInit;

    public /* bridge */ int getSize() {
        return super.size();
    }

    @Override // java.util.concurrent.CopyOnWriteArrayList, java.util.List, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    public PluginInitializerList() {
    }

    public final boolean isInit() {
        return this.isInit;
    }

    @Override // java.util.concurrent.CopyOnWriteArrayList, java.util.List, java.util.Collection
    public final /* bridge */ boolean contains(Object r100) {
        if (r100 == null) goto L4;
        boolean r101 = r100 instanceof IPluginInitializer;
    L5:
        if (r101 == true) goto L7;
        return false;
    L7:
        return contains((IPluginInitializer) r100);
    L4:
        r101 = true;
        goto L5
    }

    @Override // java.util.concurrent.CopyOnWriteArrayList, java.util.List
    public final /* bridge */ int indexOf(Object r100) {
        if (r100 == null) goto L4;
        boolean r101 = r100 instanceof IPluginInitializer;
    L5:
        if (r101 == true) goto L7;
        return -1;
    L7:
        return indexOf((IPluginInitializer) r100);
    L4:
        r101 = true;
        goto L5
    }

    @Override // java.util.concurrent.CopyOnWriteArrayList, java.util.List
    public final /* bridge */ int lastIndexOf(Object r100) {
        if (r100 == null) goto L4;
        boolean r101 = r100 instanceof IPluginInitializer;
    L5:
        if (r101 == true) goto L7;
        return -1;
    L7:
        return lastIndexOf((IPluginInitializer) r100);
    L4:
        r101 = true;
        goto L5
    }

    @Override // java.util.concurrent.CopyOnWriteArrayList, java.util.List, java.util.Collection
    public final /* bridge */ boolean remove(Object r100) {
        if (r100 == null) goto L4;
        boolean r101 = r100 instanceof IPluginInitializer;
    L5:
        if (r101 == true) goto L7;
        return false;
    L7:
        return remove((IPluginInitializer) r100);
    L4:
        r101 = true;
        goto L5
    }

    public /* bridge */ IPluginInitializer removeAt(int r100) {
        return remove(r100);
    }

    public final void setInit(boolean r100) {
        this.isInit = r100;
    }

    public /* bridge */ boolean contains(IPluginInitializer r100) {
        return super.contains(r100);
    }

    public /* bridge */ int indexOf(IPluginInitializer r100) {
        return super.indexOf(r100);
    }

    public /* bridge */ int lastIndexOf(IPluginInitializer r100) {
        return super.lastIndexOf(r100);
    }

    @Override // java.util.concurrent.CopyOnWriteArrayList, java.util.List
    public final /* bridge */ IPluginInitializer remove(int r100) {
        return removeAt(r100);
    }

    public /* bridge */ boolean remove(IPluginInitializer r100) {
        return super.remove(r100);
    }
}
