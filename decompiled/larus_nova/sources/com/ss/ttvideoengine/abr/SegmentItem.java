package com.ss.ttvideoengine.abr;

import com.bytedance.vcloud.abrmodule.ISegmentItem;
import com.ss.ttvideoengine.utils.TTHelper;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes34.dex */
public class SegmentItem implements ISegmentItem {
    private static final String PLAYER_SIDX_ITEM_NAME = "com.ss.ttm.player.SidxListObject$SidxItem";
    private static boolean loadClassFailed;
    private static Method sidxItemGetDuration;
    private static Method sidxItemGetIndex;
    private static Method sidxItemGetOffset;
    private static Method sidxItemGetSize;
    private static Method sidxItemGetTimeStamp;
    private static Class<?> sidxItemObjectClass;
    private boolean loadObjectSucceed;
    private Long mDuration;
    private Integer mIndex;
    private Long mOffset;
    private Long mSize;
    private Long mTimeStamp;
    private Object playerSidxItem;

    @Override // com.bytedance.vcloud.abrmodule.ISegmentItem
    public long getDuration() {
        Long r100 = this.mDuration;
        if (r100 == null) goto L7;
        return r100.longValue();
    L7:
        if (this.loadObjectSucceed == false) goto L16;
        Method r101 = sidxItemGetDuration;
        if (r101 == null) goto L17;
        Long r102 = (Long) r101.invoke(this.playerSidxItem, new Object[0]);     // Catch: Exception -> L12
        this.mDuration = r102;     // Catch: Exception -> L12
        return r102.longValue();
    L12:
        this.mDuration = -1L;
        return -1;
    L17:
        return -1;
    L16:
        return -1;
    }

    @Override // com.bytedance.vcloud.abrmodule.ISegmentItem
    public int getIndex() {
        Integer r100 = this.mIndex;
        if (r100 == null) goto L7;
        return r100.intValue();
    L7:
        if (this.loadObjectSucceed == false) goto L16;
        Method r101 = sidxItemGetIndex;
        if (r101 == null) goto L17;
        Integer r102 = (Integer) r101.invoke(this.playerSidxItem, new Object[0]);     // Catch: Exception -> L12
        this.mIndex = r102;     // Catch: Exception -> L12
        return r102.intValue();
    L12:
        this.mIndex = -1;
        return -1;
    L17:
        return -1;
    L16:
        return -1;
    }

    @Override // com.bytedance.vcloud.abrmodule.ISegmentItem
    public long getOffset() {
        Long r100 = this.mOffset;
        if (r100 == null) goto L7;
        return r100.longValue();
    L7:
        if (this.loadObjectSucceed == false) goto L16;
        Method r101 = sidxItemGetOffset;
        if (r101 == null) goto L17;
        Long r102 = (Long) r101.invoke(this.playerSidxItem, new Object[0]);     // Catch: Exception -> L12
        this.mOffset = r102;     // Catch: Exception -> L12
        return r102.longValue();
    L12:
        this.mOffset = -1L;
        return -1;
    L17:
        return -1;
    L16:
        return -1;
    }

    @Override // com.bytedance.vcloud.abrmodule.ISegmentItem
    public long getSize() {
        Long r100 = this.mSize;
        if (r100 == null) goto L7;
        return r100.longValue();
    L7:
        if (this.loadObjectSucceed == false) goto L16;
        Method r101 = sidxItemGetSize;
        if (r101 == null) goto L17;
        Long r102 = (Long) r101.invoke(this.playerSidxItem, new Object[0]);     // Catch: Exception -> L12
        this.mSize = r102;     // Catch: Exception -> L12
        return r102.longValue();
    L12:
        this.mSize = -1L;
        return -1;
    L17:
        return -1;
    L16:
        return -1;
    }

    @Override // com.bytedance.vcloud.abrmodule.ISegmentItem
    public long getTimestamp() {
        Long r100 = this.mTimeStamp;
        if (r100 == null) goto L7;
        return r100.longValue();
    L7:
        if (this.loadObjectSucceed == false) goto L16;
        Method r101 = sidxItemGetTimeStamp;
        if (r101 == null) goto L17;
        Long r102 = (Long) r101.invoke(this.playerSidxItem, new Object[0]);     // Catch: Exception -> L12
        this.mTimeStamp = r102;     // Catch: Exception -> L12
        return r102.longValue();
    L12:
        this.mTimeStamp = -1L;
        return -1;
    L17:
        return -1;
    L16:
        return -1;
    }

    public SegmentItem(Object r100) {
        this.loadObjectSucceed = false;
        this.playerSidxItem = r100;
        Class<?> r101 = sidxItemObjectClass;
        if (r101 == null) goto L5;
    L9:
        if (r101 != null) goto L11;
        this.playerSidxItem = null;
    L11:
        Object r102 = this.playerSidxItem;
        if (r102 != null) goto L14;
        return;
    L14:
        if (r102.getClass().equals(sidxItemObjectClass) == false) goto L20;
        this.loadObjectSucceed = true;
        return;
    L20:
        return;
    L5:
        if (loadClassFailed == true) goto L9;
        Class<?> r103 = TTHelper.getClzUsingPluginLoader(200, PLAYER_SIDX_ITEM_NAME);     // Catch: Exception -> L8
        sidxItemObjectClass = r103;     // Catch: Exception -> L8
        sidxItemGetIndex = r103.getMethod("getIndex", new Class[0]);     // Catch: Exception -> L8
        sidxItemGetOffset = sidxItemObjectClass.getMethod("getOffset", new Class[0]);     // Catch: Exception -> L8
        sidxItemGetTimeStamp = sidxItemObjectClass.getMethod("getTimestamp", new Class[0]);     // Catch: Exception -> L8
        sidxItemGetDuration = sidxItemObjectClass.getMethod("getDuration", new Class[0]);     // Catch: Exception -> L8
        sidxItemGetSize = sidxItemObjectClass.getMethod("getSize", new Class[0]);     // Catch: Exception -> L8
    L8:
        this.playerSidxItem = null;
        loadClassFailed = true;
        goto L11
    }
}
