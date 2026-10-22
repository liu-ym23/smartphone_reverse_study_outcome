package com.bytedance.locallife.groupon.struct.halfscreen;

import com.bytedance.ee.bear.bitable.dao.resourcedata.BitableResourceData;
import com.google.gson.annotations.SerializedName;
import hs6.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B=\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b!\u0010\"R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001e\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001d¨\u0006#"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/halfscreen/DiamondPropsCacheData;", "Lhs6/a;", "", "viewId", "Ljava/lang/String;", "getViewId", "()Ljava/lang/String;", "setViewId", "(Ljava/lang/String;)V", "anchorViewID", "getAnchorViewID", "groupId", "getGroupId", "Lcom/bytedance/locallife/groupon/struct/halfscreen/AnchorViewProps;", "anchorViewProps", "Lcom/bytedance/locallife/groupon/struct/halfscreen/AnchorViewProps;", "getAnchorViewProps", "()Lcom/bytedance/locallife/groupon/struct/halfscreen/AnchorViewProps;", "Lcom/bytedance/locallife/groupon/struct/halfscreen/DialogProps;", "dialogProps", "Lcom/bytedance/locallife/groupon/struct/halfscreen/DialogProps;", "getDialogProps", "()Lcom/bytedance/locallife/groupon/struct/halfscreen/DialogProps;", "", "xTabHeight", "Ljava/lang/Integer;", "getXTabHeight", "()Ljava/lang/Integer;", "setXTabHeight", "(Ljava/lang/Integer;)V", "searchHeight", "getSearchHeight", "setSearchHeight", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/locallife/groupon/struct/halfscreen/AnchorViewProps;Lcom/bytedance/locallife/groupon/struct/halfscreen/DialogProps;)V", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final class DiamondPropsCacheData extends a {

    @SerializedName("anchor_view_id")
    private final String anchorViewID;

    @SerializedName("anchor_view_props")
    private final AnchorViewProps anchorViewProps;

    @SerializedName("dialog_props")
    private final DialogProps dialogProps;

    @SerializedName("group_id")
    private final String groupId;

    @SerializedName("search_height")
    private Integer searchHeight;

    @SerializedName(BitableResourceData.KEY_VIEW_ID)
    private String viewId;

    @SerializedName("x_tab_height")
    private Integer xTabHeight;

    public DiamondPropsCacheData() {
        this(null, null, null, null, null, 31, null);
    }

    public final String getAnchorViewID() {
        return this.anchorViewID;
    }

    public final AnchorViewProps getAnchorViewProps() {
        return this.anchorViewProps;
    }

    public final DialogProps getDialogProps() {
        return this.dialogProps;
    }

    public final String getGroupId() {
        return this.groupId;
    }

    public final Integer getSearchHeight() {
        return this.searchHeight;
    }

    public final String getViewId() {
        return this.viewId;
    }

    public final Integer getXTabHeight() {
        return this.xTabHeight;
    }

    public final void setSearchHeight(Integer r100) {
        this.searchHeight = r100;
    }

    public final void setViewId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.viewId = r100;
    }

    public final void setXTabHeight(Integer r100) {
        this.xTabHeight = r100;
    }

    public DiamondPropsCacheData(String r100, String r101, String r102, AnchorViewProps r103, DialogProps r104) {
        Intrinsics.checkNotNullParameter(r100, "viewId");
        Intrinsics.checkNotNullParameter(r101, "anchorViewID");
        Intrinsics.checkNotNullParameter(r102, "groupId");
        this.viewId = r100;
        this.anchorViewID = r101;
        this.groupId = r102;
        this.anchorViewProps = r103;
        this.dialogProps = r104;
    }

    public /* synthetic */ DiamondPropsCacheData(String r100, String r101, String r102, AnchorViewProps r103, DialogProps r104, int r105, DefaultConstructorMarker r110) {
        String r106 = "";
        if ((r105 & 1) == 0) goto L5;
        String r111 = "";
    L7:
        if ((r105 & 2) == 0) goto L9;
        String r107 = "";
    L11:
        if ((r105 & 4) != 0) goto L15;
        r106 = r102;
    L15:
        if ((r105 & 8) == 0) goto L17;
        AnchorViewProps r108 = null;
    L19:
        if ((r105 & 16) == 0) goto L21;
        DialogProps r109 = null;
    L22:
        this(r111, r107, r106, r108, r109);
        return;
    L21:
        r109 = r104;
        goto L22
    L17:
        r108 = r103;
        goto L19
    L9:
        r107 = r101;
        goto L11
    L5:
        r111 = r100;
        goto L7
    }
}
