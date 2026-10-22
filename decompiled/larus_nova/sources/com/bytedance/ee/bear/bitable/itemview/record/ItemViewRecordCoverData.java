package com.bytedance.ee.bear.bitable.itemview.record;

import com.bytedance.ee.bear.bitable.card.model.stmodel.cell.AttachmentEntity;
import com.bytedance.ee.bear.bitable.uikit.ContextField;
import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u0014\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0016\u0010\u0003\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\u001b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001c\u0010\u0003\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\t¨\u0006 "}, d2 = {"Lcom/bytedance/ee/bear/bitable/itemview/record/ItemViewRecordCoverData;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "name", "getName", "setName", "cellValue", "", "Lcom/bytedance/ee/bear/bitable/card/model/stmodel/cell/AttachmentEntity;", "getCellValue", "()Ljava/util/List;", "setCellValue", "(Ljava/util/List;)V", "globalIndex", "", "getGlobalIndex$annotations", "getGlobalIndex", "()I", "setGlobalIndex", "(I)V", "recordId", "getRecordId$annotations", "getRecordId", "setRecordId", "safeValue", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ItemViewRecordCoverData implements NonProguard {
    private List<? extends AttachmentEntity> cellValue;
    private int globalIndex;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private String f214011id;
    private String name;
    private String recordId;

    @ContextField
    public static /* synthetic */ void getGlobalIndex$annotations() {
    }

    @ContextField
    public static /* synthetic */ void getRecordId$annotations() {
    }

    public final List<AttachmentEntity> safeValue() {
        List r100 = this.cellValue;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return new ArrayList();
    }

    public ItemViewRecordCoverData() {
        this.f214011id = "";
        this.name = "";
        this.cellValue = new ArrayList();
        this.recordId = "";
    }

    public final List<AttachmentEntity> getCellValue() {
        return this.cellValue;
    }

    public final int getGlobalIndex() {
        return this.globalIndex;
    }

    public final String getId() {
        return this.f214011id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getRecordId() {
        return this.recordId;
    }

    public final void setCellValue(List<? extends AttachmentEntity> r100) {
        this.cellValue = r100;
    }

    public final void setGlobalIndex(int r100) {
        this.globalIndex = r100;
    }

    public final void setId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f214011id = r100;
    }

    public final void setName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.name = r100;
    }

    public final void setRecordId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.recordId = r100;
    }
}
