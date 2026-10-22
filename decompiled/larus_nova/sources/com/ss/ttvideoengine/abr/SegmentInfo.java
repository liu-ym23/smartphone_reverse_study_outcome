package com.ss.ttvideoengine.abr;

import com.bytedance.vcloud.abrmodule.ISegmentInfo;
import com.bytedance.vcloud.abrmodule.ISegmentItem;
import com.ss.ttvideoengine.utils.TTHelper;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes34.dex */
public class SegmentInfo implements ISegmentInfo {
    private static final String PLAYER_SIDX_OBJECT_NAME = "com.ss.ttm.player.SidxListObject";
    private static boolean loadClassFailed;
    private static Method sidxGetBitRate;
    private static Method sidxGetEndIndex;
    private static Method sidxGetFileId;
    private static Method sidxGetItem;
    private static Method sidxGetMediaType;
    private static Method sidxGetStartIndex;
    private static Method sidxGetTotalNum;
    private static Class<?> sidxListObjectClass;
    private boolean loadObjectSucceed;
    private Long mBitrate;
    private Integer mEndIndex;
    private String mFileId;
    private Integer mMediaType;
    private Integer mStartIndex;
    private Integer mTotalNum;
    private Object playerSidxList;

    @Override // com.bytedance.vcloud.abrmodule.ISegmentInfo
    public long getBitrate() {
        Long r100 = this.mBitrate;
        if (r100 == null) goto L7;
        return r100.longValue();
    L7:
        if (this.loadObjectSucceed == false) goto L16;
        Method r101 = sidxGetBitRate;
        if (r101 == null) goto L17;
        Long r102 = (Long) r101.invoke(this.playerSidxList, new Object[0]);     // Catch: Exception -> L12
        this.mBitrate = r102;     // Catch: Exception -> L12
        return r102.longValue();
    L12:
        this.mBitrate = -1L;
        return -1;
    L17:
        return -1;
    L16:
        return -1;
    }

    @Override // com.bytedance.vcloud.abrmodule.ISegmentInfo
    public int getEndIndex() {
        Integer r100 = this.mEndIndex;
        if (r100 == null) goto L7;
        return r100.intValue();
    L7:
        if (this.loadObjectSucceed == false) goto L16;
        Method r101 = sidxGetEndIndex;
        if (r101 == null) goto L17;
        Integer r102 = (Integer) r101.invoke(this.playerSidxList, new Object[0]);     // Catch: Exception -> L12
        this.mEndIndex = r102;     // Catch: Exception -> L12
        return r102.intValue();
    L12:
        return -1;
    L17:
        return 0;
    L16:
        return 0;
    }

    @Override // com.bytedance.vcloud.abrmodule.ISegmentInfo
    public String getFileId() {
        String r100 = this.mFileId;
        if (r100 == null) goto L6;
        return r100;
    L6:
        if (this.loadObjectSucceed == false) goto L13;
        Method r101 = sidxGetFileId;
        if (r101 == null) goto L13;
        this.mFileId = (String) r101.invoke(this.playerSidxList, new Object[0]);     // Catch: Exception -> L11
    L11:
        this.mFileId = null;
    L13:
        return this.mFileId;
    }

    @Override // com.bytedance.vcloud.abrmodule.ISegmentInfo
    public List<? extends ISegmentItem> getItems() {
        ArrayList r100 = new ArrayList();
        if (this.loadObjectSucceed == true) goto L5;
        return r100;
    L5:
        if (sidxGetItem == null) goto L17;
        int r101 = 0;
    L13:
    L11:
        return null;
    L8:
        if ((getStartIndex() + r101) > getEndIndex()) goto L18;
        r100.add(new SegmentItem(sidxGetItem.invoke(this.playerSidxList, new Object[]{Integer.valueOf(r101)})));     // Catch: Exception -> L11
        r101 = r101 + 1;
        goto L13
    L18:
        return r100;
    L17:
        return r100;
    }

    @Override // com.bytedance.vcloud.abrmodule.ISegmentInfo
    public int getMediaType() {
        Integer r100 = this.mMediaType;
        if (r100 == null) goto L7;
        return r100.intValue();
    L7:
        if (this.loadObjectSucceed == false) goto L16;
        Method r101 = sidxGetMediaType;
        if (r101 == null) goto L17;
        Integer r102 = (Integer) r101.invoke(this.playerSidxList, new Object[0]);     // Catch: Exception -> L12
        this.mMediaType = r102;     // Catch: Exception -> L12
        return r102.intValue();
    L12:
        this.mMediaType = -1;
        return -1;
    L17:
        return -1;
    L16:
        return -1;
    }

    @Override // com.bytedance.vcloud.abrmodule.ISegmentInfo
    public int getStartIndex() {
        Integer r100 = this.mStartIndex;
        if (r100 == null) goto L7;
        return r100.intValue();
    L7:
        if (this.loadObjectSucceed == false) goto L16;
        Method r101 = sidxGetStartIndex;
        if (r101 == null) goto L17;
        Integer r102 = (Integer) r101.invoke(this.playerSidxList, new Object[0]);     // Catch: Exception -> L12
        this.mStartIndex = r102;     // Catch: Exception -> L12
        return r102.intValue();
    L12:
        return -1;
    L17:
        return 0;
    L16:
        return 0;
    }

    @Override // com.bytedance.vcloud.abrmodule.ISegmentInfo
    public int getTotalNum() {
        Integer r100 = this.mTotalNum;
        if (r100 == null) goto L7;
        return r100.intValue();
    L7:
        if (this.loadObjectSucceed == false) goto L16;
        Method r101 = sidxGetTotalNum;
        if (r101 == null) goto L17;
        Integer r102 = (Integer) r101.invoke(this.playerSidxList, new Object[0]);     // Catch: Exception -> L12
        this.mTotalNum = r102;     // Catch: Exception -> L12
        return r102.intValue();
    L12:
        this.mTotalNum = -1;
        return -1;
    L17:
        return -1;
    L16:
        return -1;
    }

    public SegmentInfo(Object r100) {
        this.loadObjectSucceed = false;
        this.playerSidxList = r100;
        Class<?> r101 = sidxListObjectClass;
        if (r101 == null) goto L5;
    L9:
        if (r101 != null) goto L11;
        this.playerSidxList = null;
    L11:
        Object r102 = this.playerSidxList;
        if (r102 != null) goto L14;
        return;
    L14:
        if (r102.getClass().equals(sidxListObjectClass) == false) goto L20;
        this.loadObjectSucceed = true;
        return;
    L20:
        return;
    L5:
        if (loadClassFailed == true) goto L9;
        Class<?> r103 = TTHelper.getClzUsingPluginLoader(200, PLAYER_SIDX_OBJECT_NAME);     // Catch: Exception -> L8
        sidxListObjectClass = r103;     // Catch: Exception -> L8
        sidxGetMediaType = r103.getMethod("getMediaType", new Class[0]);     // Catch: Exception -> L8
        sidxGetTotalNum = sidxListObjectClass.getMethod("getTotalNum", new Class[0]);     // Catch: Exception -> L8
        sidxGetStartIndex = sidxListObjectClass.getMethod("getStartIndex", new Class[0]);     // Catch: Exception -> L8
        sidxGetEndIndex = sidxListObjectClass.getMethod("getEndIndex", new Class[0]);     // Catch: Exception -> L8
        sidxGetBitRate = sidxListObjectClass.getMethod("getBitrate", new Class[0]);     // Catch: Exception -> L8
        sidxGetFileId = sidxListObjectClass.getMethod("getFileId", new Class[0]);     // Catch: Exception -> L8
        sidxGetItem = sidxListObjectClass.getMethod("getItem", new Class[]{Integer.TYPE});     // Catch: Exception -> L8
    L8:
        this.playerSidxList = null;
        loadClassFailed = true;
        goto L11
    }
}
