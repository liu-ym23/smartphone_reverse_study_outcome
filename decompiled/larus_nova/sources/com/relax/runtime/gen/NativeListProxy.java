package com.relax.runtime.gen;

/* JADX INFO: loaded from: classes34.dex */
public class NativeListProxy {
    private native boolean nativeCommonCallbackReady(long r100);

    private native long nativeCreate(long r100);

    private native void nativeCreateList(long r100, int r101);

    private native void nativeCreateListItem(long r100, int r101);

    private native void nativeDestroy(long r100);

    private native void nativeDestroyList(long r100, int r101);

    private native void nativeDestroyListItem(long r100, int r101);

    private native void nativeMarkCommonCallbackReady(long r100);

    private native void nativeOnBindItemFinished(long r100, int r101, int r102, Object r103);

    private native void nativeOnListElementUpdated(long r100, int r101, int[] r102);

    private native void nativeOnListItemLayoutUpdated(long r100, int r101, int r102);

    private native void nativeScrollByListContainer(long r100, int r101, double r102, double r103, double r104, double r110);

    private native void nativeScrollStopped(long r100, int r101);

    private native void nativeScrollToPosition(long r100, int r101, int r102, double r103, int r104, boolean r105);

    private native void nativeSetComponentAtIndexCallback(long r100, int r101, ComponentAtIndexHandler r102);

    private native void nativeSetEngine(long r100, long r101);

    private native void nativeSetEnqueueComponentCallback(long r100, int r101, EnqueueComponentHandler r102);

    private native void nativeSetHasEventListenerCallback(long r100, int r101, HasEventListenerCallback r102);

    private native void nativeSetInsertListItemNodeCallback(long r100, InsertListItemNodeCallback r101);

    private native void nativeSetMarkNeedsLayoutCallback(long r100, int r101, MarkNeedsLayoutCallback r102);

    private native void nativeSetMarkNeedsPaintCallback(long r100, MarkNeedsPaintCallback r101);

    private native void nativeSetNativeLayoutProxy(long r100, long r101);

    private native void nativeSetOnNodeReadyCallback(long r100, OnNodeReadyCallback r101);

    private native void nativeSetRemoveListItemNodeCallback(long r100, RemoveListItemNodeCallback r101);

    private native void nativeSetUpdateContentSizeAndOffsetCallback(long r100, UpdateContentSizeAndOffsetCallback r101);

    private native void nativeSetUpdateLayoutToPlatformCallback(long r100, int r101, UpdateLayoutToPlatformCallback r102);

    private native void nativeSetUpdateListContainerInfoCallback(long r100, int r101, UpdateListContainerInfoCallback r102);

    private native void nativeSetUpdateScrollInfoCallback(long r100, UpdateScrollInfoCallback r101);

    private native void nativeUpdateListAttribute(long r100, int r101, int r102, Object r103);

    private native void nativeUpdateListItemAttribute(long r100, int r101, int r102, Object r103);

    public NativeListProxy() {
    }

    public NativeListProxy(long r100) {
        nativeCreate(r100);
    }
}
