package com.bytedance.ee.bear.bitable.infoarch.nativeview.common;

import android.text.TextUtils;
import com.alibaba.gaiax.render.view.GXViewKey;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.meta.GroupPosition;
import com.bytedance.ee.util.io.NonProguard;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020&2\u0006\u0010@\u001a\u00020&J\u0006\u0010A\u001a\u00020 J\u0006\u0010B\u001a\u00020 J\u0006\u0010C\u001a\u00020 J\u0006\u0010D\u001a\u00020 J\u0006\u0010E\u001a\u00020 J\u0006\u0010F\u001a\u00020 J\u0006\u0010G\u001a\u00020 J\u0012\u0010H\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020J0IJ\b\u0010K\u001a\u00020\u0005H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\u001a\u0010\u001f\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001e\u0010%\u001a\u0004\u0018\u00010&X\u0086\u000e¢\u0006\u0010\n\u0002\u0010+\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010,\u001a\u00020&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u00101\u001a\u00020&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010.\"\u0004\b3\u00100R\u001a\u00104\u001a\u00020&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010.\"\u0004\b6\u00100R\u001a\u00107\u001a\u00020&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010.\"\u0004\b9\u00100R\u001a\u0010:\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u0019\"\u0004\b<\u0010\u001b¨\u0006L"}, d2 = {"Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/UpdateStrategy;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", BdpAppEventConstant.PARAMS_STRATEGY_NAME, "", "getStrategy", "()Ljava/lang/String;", "setStrategy", "(Ljava/lang/String;)V", "scrollToId", "getScrollToId", "setScrollToId", "scrollToFieldId", "getScrollToFieldId", "setScrollToFieldId", "scrollPosition", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/meta/GroupPosition;", "getScrollPosition", "()Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/meta/GroupPosition;", "setScrollPosition", "(Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/meta/GroupPosition;)V", "pageSize", "", "getPageSize", "()I", "setPageSize", "(I)V", "preIndex", "getPreIndex", "setPreIndex", "switchView", "", "getSwitchView", "()Z", "setSwitchView", "(Z)V", "bridgeStart", "", "getBridgeStart", "()Ljava/lang/Long;", "setBridgeStart", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "bridgeDuration", "getBridgeDuration", "()J", "setBridgeDuration", "(J)V", "processDuration", "getProcessDuration", "setProcessDuration", "transferDuration", "getTransferDuration", "setTransferDuration", "deserializeDuration", "getDeserializeDuration", "setDeserializeDuration", "size", "getSize", "setSize", "calcBridgeDuration", "", "transferEnd", "bridgeEnd", "isRebuildUpdate", "isScrollUpdate", "isPullUpdate", "isPushUpdate", "isPushRecord", "isPushPatch", "isGetVisiblePullDataActions", "getStatistics", "", "", "toString", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UpdateStrategy implements NonProguard {
    private long bridgeDuration;
    private Long bridgeStart;
    private long deserializeDuration;
    private int pageSize;
    private int preIndex;
    private long processDuration;
    private GroupPosition scrollPosition;
    private String scrollToFieldId;
    private String scrollToId;
    private int size;
    private String strategy;
    private boolean switchView;
    private long transferDuration;

    public final Map<String, Object> getStatistics() {
        HashMap r100 = new HashMap();
        r100.put("size", Integer.valueOf(this.size));
        String r101 = this.strategy;
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        r100.put(BdpAppEventConstant.PARAMS_STRATEGY_NAME, r101);
        r100.put("processDuration", Long.valueOf(this.processDuration));
        r100.put("bridgeDuration", Long.valueOf(this.bridgeDuration));
        r100.put("transferDuration", Long.valueOf(this.transferDuration));
        r100.put("deserializeDuration", Long.valueOf(this.deserializeDuration));
        return r100;
    }

    public final boolean isGetVisiblePullDataActions() {
        return TextUtils.equals(this.strategy, "getVisiblePullActions");
    }

    public final boolean isPullUpdate() {
        return TextUtils.equals(this.strategy, "pull");
    }

    public final boolean isPushPatch() {
        return TextUtils.equals(this.strategy, "pushPatch");
    }

    public final boolean isPushRecord() {
        return TextUtils.equals(this.strategy, "pushRecord");
    }

    public final boolean isPushUpdate() {
        return TextUtils.equals(this.strategy, "push");
    }

    public final boolean isRebuildUpdate() {
        return TextUtils.equals(this.strategy, "rebuild");
    }

    public final boolean isScrollUpdate() {
        return TextUtils.equals(this.strategy, GXViewKey.VIEW_TYPE_CONTAINER_SCROLL);
    }

    public String toString() {
        return "UpdateStrategy(strategy=" + this.strategy + ", pageSize=" + this.pageSize + ", preIndex=" + this.preIndex + ", switchView=" + this.switchView + ", bridgeDuration=" + this.bridgeDuration + ", size=" + this.size + ", scrollGP:" + this.scrollPosition + ')';
    }

    public UpdateStrategy() {
        this.pageSize = 100;
        this.preIndex = 20;
    }

    public final long getBridgeDuration() {
        return this.bridgeDuration;
    }

    public final Long getBridgeStart() {
        return this.bridgeStart;
    }

    public final long getDeserializeDuration() {
        return this.deserializeDuration;
    }

    public final int getPageSize() {
        return this.pageSize;
    }

    public final int getPreIndex() {
        return this.preIndex;
    }

    public final long getProcessDuration() {
        return this.processDuration;
    }

    public final GroupPosition getScrollPosition() {
        return this.scrollPosition;
    }

    public final String getScrollToFieldId() {
        return this.scrollToFieldId;
    }

    public final String getScrollToId() {
        return this.scrollToId;
    }

    public final int getSize() {
        return this.size;
    }

    public final String getStrategy() {
        return this.strategy;
    }

    public final boolean getSwitchView() {
        return this.switchView;
    }

    public final long getTransferDuration() {
        return this.transferDuration;
    }

    public final void setBridgeDuration(long r100) {
        this.bridgeDuration = r100;
    }

    public final void setBridgeStart(Long r100) {
        this.bridgeStart = r100;
    }

    public final void setDeserializeDuration(long r100) {
        this.deserializeDuration = r100;
    }

    public final void setPageSize(int r100) {
        this.pageSize = r100;
    }

    public final void setPreIndex(int r100) {
        this.preIndex = r100;
    }

    public final void setProcessDuration(long r100) {
        this.processDuration = r100;
    }

    public final void setScrollPosition(GroupPosition r100) {
        this.scrollPosition = r100;
    }

    public final void setScrollToFieldId(String r100) {
        this.scrollToFieldId = r100;
    }

    public final void setScrollToId(String r100) {
        this.scrollToId = r100;
    }

    public final void setSize(int r100) {
        this.size = r100;
    }

    public final void setStrategy(String r100) {
        this.strategy = r100;
    }

    public final void setSwitchView(boolean r100) {
        this.switchView = r100;
    }

    public final void setTransferDuration(long r100) {
        this.transferDuration = r100;
    }

    public final void calcBridgeDuration(long r100, long r101) {
        Long r102 = this.bridgeStart;
        if (r102 == null) goto L6;
        long r103 = r102.longValue();
        this.bridgeDuration = r101 - r103;
        this.transferDuration = r100 - r103;
        this.deserializeDuration = r101 - r100;
        return;
    }
}
