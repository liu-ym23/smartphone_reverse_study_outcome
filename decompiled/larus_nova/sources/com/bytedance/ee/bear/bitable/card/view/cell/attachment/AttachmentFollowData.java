package com.bytedance.ee.bear.bitable.card.view.cell.attachment;

import com.bytedance.ee.bear.contract.drive.sdk.entity.open.SpaceThirdPartyOpenEntity;
import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001BW\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u000bj\b\u0012\u0004\u0012\u00020\u0006`\f¢\u0006\u0004\b\r\u0010\u000eR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R!\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u000bj\b\u0012\u0004\u0012\u00020\u0006`\f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/view/cell/attachment/AttachmentFollowData;", "Lcom/bytedance/ee/util/io/NonProguard;", "fieldId", "", "recordId", "thirdEntity", "Lcom/bytedance/ee/bear/contract/drive/sdk/entity/open/SpaceThirdPartyOpenEntity;", "tableId", "localIndex", "", "localEntityList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/ee/bear/contract/drive/sdk/entity/open/SpaceThirdPartyOpenEntity;Ljava/lang/String;ILjava/util/ArrayList;)V", "getFieldId", "()Ljava/lang/String;", "getRecordId", "getThirdEntity", "()Lcom/bytedance/ee/bear/contract/drive/sdk/entity/open/SpaceThirdPartyOpenEntity;", "getTableId", "getLocalIndex", "()I", "getLocalEntityList", "()Ljava/util/ArrayList;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AttachmentFollowData implements NonProguard {
    private final String fieldId;
    private final ArrayList<SpaceThirdPartyOpenEntity> localEntityList;
    private final int localIndex;
    private final String recordId;
    private final String tableId;
    private final SpaceThirdPartyOpenEntity thirdEntity;

    public final String getFieldId() {
        return this.fieldId;
    }

    public final ArrayList<SpaceThirdPartyOpenEntity> getLocalEntityList() {
        return this.localEntityList;
    }

    public final int getLocalIndex() {
        return this.localIndex;
    }

    public final String getRecordId() {
        return this.recordId;
    }

    public final String getTableId() {
        return this.tableId;
    }

    public final SpaceThirdPartyOpenEntity getThirdEntity() {
        return this.thirdEntity;
    }

    public AttachmentFollowData(String r100, String r101, SpaceThirdPartyOpenEntity r102, String r103, int r104, ArrayList<SpaceThirdPartyOpenEntity> r105) {
        Intrinsics.checkNotNullParameter(r105, "localEntityList");
        this.fieldId = r100;
        this.recordId = r101;
        this.thirdEntity = r102;
        this.tableId = r103;
        this.localIndex = r104;
        this.localEntityList = r105;
    }

    public /* synthetic */ AttachmentFollowData(String r110, String r111, SpaceThirdPartyOpenEntity r112, String r113, int r114, ArrayList r115, int r116, DefaultConstructorMarker r117) {
        if ((r116 & 1) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r116 & 2) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r116 & 8) == 0) goto L13;
        String r102 = "";
    L15:
        if ((r116 & 16) == 0) goto L17;
        int r103 = 0;
    L18:
        this(r100, r101, r112, r102, r103, r115);
        return;
    L17:
        r103 = r114;
        goto L18
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
