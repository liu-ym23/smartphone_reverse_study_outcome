package com.bytedance.ee.bear.bitable.celleditor.editor.attachment;

import com.bytedance.ee.bear.bitable.card.model.stmodel.cell.AttachmentEntity;
import com.bytedance.ee.bear.bitable.celleditor.bean.CommonEditorModel;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000  2\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0014\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000f\"\u0004\b\u0016\u0010\u0011R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001c¨\u0006!"}, d2 = {"Lcom/bytedance/ee/bear/bitable/celleditor/editor/attachment/AttachmentEditorModel;", "Lcom/bytedance/ee/bear/bitable/celleditor/bean/CommonEditorModel;", "", "Lcom/bytedance/ee/bear/bitable/card/model/stmodel/cell/AttachmentEntity;", "<init>", "()V", "fieldName", "", "getFieldName", "()Ljava/lang/String;", "setFieldName", "(Ljava/lang/String;)V", "onlyCamera", "", "getOnlyCamera", "()Z", "setOnlyCamera", "(Z)V", "isPreAdd", "setPreAdd", "onlyImageAndVideo", "getOnlyImageAndVideo", "setOnlyImageAndVideo", "uploadMode", "", "getUploadMode", "()I", "setUploadMode", "(I)V", "editCellMode", "getEditCellMode", "setEditCellMode", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AttachmentEditorModel extends CommonEditorModel<List<? extends AttachmentEntity>> {
    public static final a Companion = null;
    public static final int preUploadForAddRecord = 1;
    public static final int preUploadForSubmit = 2;
    public static final int uploadImmediately = 0;
    public static final int uploadUntilSubmit = 3;
    private int editCellMode;
    private String fieldName;
    private boolean isPreAdd;
    private boolean onlyCamera;
    private boolean onlyImageAndVideo;
    private int uploadMode;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public AttachmentEditorModel() {
    }

    public final int getEditCellMode() {
        return this.editCellMode;
    }

    public final String getFieldName() {
        return this.fieldName;
    }

    public final boolean getOnlyCamera() {
        return this.onlyCamera;
    }

    public final boolean getOnlyImageAndVideo() {
        return this.onlyImageAndVideo;
    }

    public final int getUploadMode() {
        return this.uploadMode;
    }

    public final boolean isPreAdd() {
        return this.isPreAdd;
    }

    public final void setEditCellMode(int r100) {
        this.editCellMode = r100;
    }

    public final void setFieldName(String r100) {
        this.fieldName = r100;
    }

    public final void setOnlyCamera(boolean r100) {
        this.onlyCamera = r100;
    }

    public final void setOnlyImageAndVideo(boolean r100) {
        this.onlyImageAndVideo = r100;
    }

    public final void setPreAdd(boolean r100) {
        this.isPreAdd = r100;
    }

    public final void setUploadMode(int r100) {
        this.uploadMode = r100;
    }
}
