package com.bytedance.ee.bear.bitable.panel;

import android.text.TextUtils;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.cellvalue.SegmentModel;
import com.bytedance.ee.util.io.NonProguard;
import com.larksuite.framework.utils.q;
import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010N\u001a\u00020)J\u0006\u0010O\u001a\u00020)J\b\u0010P\u001a\u00020\u0005H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR.\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017j\n\u0012\u0004\u0012\u00020\u0018\u0018\u0001`\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR.\u0010\u001e\u001a\u0016\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u0017j\n\u0012\u0004\u0012\u00020\u001f\u0018\u0001`\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001b\"\u0004\b!\u0010\u001dR.\u0010\"\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0017j\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001b\"\u0004\b$\u0010\u001dR\u001c\u0010%\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0007\"\u0004\b'\u0010\tR\u001a\u0010(\u001a\u00020)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001c\u0010.\u001a\u0004\u0018\u00010/X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001c\u00104\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\r\"\u0004\b6\u0010\u000fR\u001e\u00107\u001a\u0004\u0018\u00010)X\u0086\u000e¢\u0006\u0010\n\u0002\u0010<\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001e\u0010=\u001a\u0004\u0018\u00010>X\u0086\u000e¢\u0006\u0010\n\u0002\u0010C\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001c\u0010D\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u0007\"\u0004\bF\u0010\tR\u001e\u0010G\u001a\u0004\u0018\u00010HX\u0086\u000e¢\u0006\u0010\n\u0002\u0010M\u001a\u0004\bI\u0010J\"\u0004\bK\u0010L¨\u0006Q"}, d2 = {"Lcom/bytedance/ee/bear/bitable/panel/BitablePanelModel;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "title", "", "getTitle", "()Ljava/lang/String;", com.alipay.sdk.m.x.d.f25925o, "(Ljava/lang/String;)V", "leftAction", "Lcom/bytedance/ee/bear/bitable/panel/BitablePanelItem;", "getLeftAction", "()Lcom/bytedance/ee/bear/bitable/panel/BitablePanelItem;", "setLeftAction", "(Lcom/bytedance/ee/bear/bitable/panel/BitablePanelItem;)V", "rightAction", "getRightAction", "setRightAction", "headerExtendMode", "getHeaderExtendMode", "setHeaderExtendMode", "groupInfo", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/bitable/panel/GroupInfo;", "Lkotlin/collections/ArrayList;", "getGroupInfo", "()Ljava/util/ArrayList;", "setGroupInfo", "(Ljava/util/ArrayList;)V", SocialConstants.PARAM_APP_DESC, "Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/cellvalue/SegmentModel;", "getDesc", "setDesc", "data", "getData", "setData", "contentExtendMode", "getContentExtendMode", "setContentExtendMode", "disableLandscape", "", "getDisableLandscape", "()Z", "setDisableLandscape", "(Z)V", "extra", "", "getExtra", "()Ljava/lang/Object;", "setExtra", "(Ljava/lang/Object;)V", "bottomFixedData", "getBottomFixedData", "setBottomFixedData", "draggable", "getDraggable", "()Ljava/lang/Boolean;", "setDraggable", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "heightPercent", "", "getHeightPercent", "()Ljava/lang/Float;", "setHeightPercent", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "srcObjToken", "getSrcObjToken", "setSrcObjToken", "srcObjType", "", "getSrcObjType", "()Ljava/lang/Integer;", "setSrcObjType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "isValid", "isContentExtendValid", "toString", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitablePanelModel implements NonProguard {
    private BitablePanelItem bottomFixedData;
    private String contentExtendMode;
    private ArrayList<BitablePanelItem> data;
    private ArrayList<SegmentModel> desc;
    private boolean disableLandscape;
    private Boolean draggable;
    private transient Object extra;
    private ArrayList<GroupInfo> groupInfo;
    private String headerExtendMode;
    private Float heightPercent;
    private BitablePanelItem leftAction;
    private BitablePanelItem rightAction;
    private String srcObjToken;
    private Integer srcObjType;
    private String title;

    public final boolean isContentExtendValid() {
        if (this.extra != null) goto L5;
    L7:
        return false;
    L5:
        if (TextUtils.equals(this.contentExtendMode, "default_content") == true) goto L7;
        return true;
    }

    public final boolean isValid() {
        if (q.a(this.data) == true) goto L5;
    L12:
        return true;
    L5:
        if (q.a(this.desc) == false) goto L12;
        if (this.bottomFixedData != null) goto L12;
        if (isContentExtendValid() == true) goto L12;
        return false;
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("BitablePanelModel(title=");
        r100.append(this.title);
        r100.append(", contentExtendMode=");
        r100.append(this.contentExtendMode);
        r100.append(", dataSize=");
        ArrayList<BitablePanelItem> r101 = this.data;
        if (r101 == null) goto L5;
        Integer r102 = Integer.valueOf(r101.size());
    L6:
        r100.append(r102);
        r100.append(')');
        return r100.toString();
    L5:
        r102 = null;
        goto L6
    }

    public BitablePanelModel() {
        this.headerExtendMode = "default_header";
        this.contentExtendMode = "default_content";
    }

    public final BitablePanelItem getBottomFixedData() {
        return this.bottomFixedData;
    }

    public final String getContentExtendMode() {
        return this.contentExtendMode;
    }

    public final ArrayList<BitablePanelItem> getData() {
        return this.data;
    }

    public final ArrayList<SegmentModel> getDesc() {
        return this.desc;
    }

    public final boolean getDisableLandscape() {
        return this.disableLandscape;
    }

    public final Boolean getDraggable() {
        return this.draggable;
    }

    public final Object getExtra() {
        return this.extra;
    }

    public final ArrayList<GroupInfo> getGroupInfo() {
        return this.groupInfo;
    }

    public final String getHeaderExtendMode() {
        return this.headerExtendMode;
    }

    public final Float getHeightPercent() {
        return this.heightPercent;
    }

    public final BitablePanelItem getLeftAction() {
        return this.leftAction;
    }

    public final BitablePanelItem getRightAction() {
        return this.rightAction;
    }

    public final String getSrcObjToken() {
        return this.srcObjToken;
    }

    public final Integer getSrcObjType() {
        return this.srcObjType;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setBottomFixedData(BitablePanelItem r100) {
        this.bottomFixedData = r100;
    }

    public final void setContentExtendMode(String r100) {
        this.contentExtendMode = r100;
    }

    public final void setData(ArrayList<BitablePanelItem> r100) {
        this.data = r100;
    }

    public final void setDesc(ArrayList<SegmentModel> r100) {
        this.desc = r100;
    }

    public final void setDisableLandscape(boolean r100) {
        this.disableLandscape = r100;
    }

    public final void setDraggable(Boolean r100) {
        this.draggable = r100;
    }

    public final void setExtra(Object r100) {
        this.extra = r100;
    }

    public final void setGroupInfo(ArrayList<GroupInfo> r100) {
        this.groupInfo = r100;
    }

    public final void setHeaderExtendMode(String r100) {
        this.headerExtendMode = r100;
    }

    public final void setHeightPercent(Float r100) {
        this.heightPercent = r100;
    }

    public final void setLeftAction(BitablePanelItem r100) {
        this.leftAction = r100;
    }

    public final void setRightAction(BitablePanelItem r100) {
        this.rightAction = r100;
    }

    public final void setSrcObjToken(String r100) {
        this.srcObjToken = r100;
    }

    public final void setSrcObjType(Integer r100) {
        this.srcObjType = r100;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }
}
