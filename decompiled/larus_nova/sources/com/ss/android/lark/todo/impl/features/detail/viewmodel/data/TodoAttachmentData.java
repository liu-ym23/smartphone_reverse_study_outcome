package com.ss.android.lark.todo.impl.features.detail.viewmodel.data;

import com.bytedance.lark.pb.todo.v1.TodoAttachment;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010:\u001a\u00020\u0002H\u0016J\u0006\u0010;\u001a\u00020\u0000J\u0013\u0010<\u001a\u00020#2\b\u0010=\u001a\u0004\u0018\u00010>H\u0096\u0002J\b\u0010?\u001a\u00020@H\u0016R\u001a\u0010\u0004\u001a\u00020\u0002X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\r\"\u0004\b\u001e\u0010\u000fR\u001a\u0010\u001f\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\r\"\u0004\b!\u0010\u000fR\u001a\u0010\"\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001c\u0010.\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\r\"\u0004\b0\u0010\u000fR\u001a\u00101\u001a\u00020)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010+\"\u0004\b3\u0010-R\u001a\u00104\u001a\u00020)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010+\"\u0004\b6\u0010-R\u001a\u00107\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010%\"\u0004\b9\u0010'¨\u0006A"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/detail/viewmodel/data/TodoAttachmentData;", "Lcom/ss/android/lark/todo/impl/features/detail/viewmodel/data/BaseData;", "Lcom/bytedance/lark/pb/todo/v1/TodoAttachment;", "Ljava/io/Serializable;", "pbData", "<init>", "(Lcom/bytedance/lark/pb/todo/v1/TodoAttachment;)V", "getPbData", "()Lcom/bytedance/lark/pb/todo/v1/TodoAttachment;", "setPbData", "fileToken", "", "getFileToken", "()Ljava/lang/String;", "setFileToken", "(Ljava/lang/String;)V", "fileSize", "getFileSize", "setFileSize", "name", "getName", "setName", "type", "Lcom/bytedance/lark/pb/todo/v1/TodoAttachment$Type;", "getType", "()Lcom/bytedance/lark/pb/todo/v1/TodoAttachment$Type;", "setType", "(Lcom/bytedance/lark/pb/todo/v1/TodoAttachment$Type;)V", "uploaderUserId", "getUploaderUserId", "setUploaderUserId", "guid", "getGuid", "setGuid", "canDelete", "", "getCanDelete", "()Z", "setCanDelete", "(Z)V", "uploadMilliTime", "", "getUploadMilliTime", "()J", "setUploadMilliTime", "(J)V", "key", "getKey", "setKey", "bytesTransferred", "getBytesTransferred", "setBytesTransferred", "bytesTotal", "getBytesTotal", "setBytesTotal", "statusFail", "getStatusFail", "setStatusFail", "parseToPb", "copy", "equals", "other", "", "hashCode", "", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TodoAttachmentData implements a<TodoAttachment>, Serializable {
    private long bytesTotal;
    private long bytesTransferred;
    private boolean canDelete;
    private String fileSize;
    private String fileToken;
    private String guid;
    private String key;
    private String name;
    private TodoAttachment pbData;
    private boolean statusFail;
    private TodoAttachment.Type type;
    private long uploadMilliTime;
    private String uploaderUserId;

    @Override // com.ss.android.lark.todo.impl.features.detail.viewmodel.data.a
    public boolean isValid() {
        return true;
    }

    public void setValid(boolean r100) {
    }

    public final TodoAttachmentData copy() {
        TodoAttachmentData r100 = new TodoAttachmentData(getPbData());
        r100.setPbData(getPbData());
        r100.fileToken = this.fileToken;
        r100.fileSize = this.fileSize;
        r100.name = this.name;
        r100.type = this.type;
        r100.uploaderUserId = this.uploaderUserId;
        r100.guid = this.guid;
        r100.canDelete = this.canDelete;
        r100.uploadMilliTime = this.uploadMilliTime;
        r100.key = this.key;
        r100.bytesTransferred = this.bytesTransferred;
        r100.bytesTotal = this.bytesTotal;
        r100.statusFail = this.statusFail;
        return r100;
    }

    public int hashCode() {
        String r100 = this.fileToken;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.fileSize.hashCode()) * 31;
        String r104 = this.name;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (((((((r103 + r105) * 31) + this.type.hashCode()) * 31) + this.uploaderUserId.hashCode()) * 31) + this.guid.hashCode()) * 31;
        int r107 = 1231;
        if (this.canDelete == false) goto L13;
        int r108 = 1231;
    L14:
        long r109 = this.uploadMilliTime;
        int r110 = (((r106 + r108) * 31) + ((int) (r109 ^ (r109 >>> 32)))) * 31;
        String r111 = this.key;
        if (r111 == null) goto L17;
        r101 = r111.hashCode();
    L17:
        long r112 = this.bytesTransferred;
        int r113 = (((r110 + r101) * 31) + ((int) (r112 ^ (r112 >>> 32)))) * 31;
        long r114 = this.bytesTotal;
        int r115 = (r113 + ((int) ((r114 >>> 32) ^ r114))) * 31;
        if (this.statusFail == true) goto L22;
        r107 = 1237;
    L22:
        return r115 + r107;
    L13:
        r108 = 1237;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    /* JADX INFO: renamed from: getPbData, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m8685getPbData() {
        return getPbData();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.ss.android.lark.todo.impl.features.detail.viewmodel.data.a
    public TodoAttachment parseToPb() {
        return getPbData().newBuilder().file_token(this.fileToken).file_size(this.fileSize).name(this.name).type(this.type).uploader_user_id(this.uploaderUserId).guid(this.guid).can_delete(Boolean.valueOf(this.canDelete)).upload_milli_time(Long.valueOf(this.uploadMilliTime)).build();
    }

    public final long getBytesTotal() {
        return this.bytesTotal;
    }

    public final long getBytesTransferred() {
        return this.bytesTransferred;
    }

    public final boolean getCanDelete() {
        return this.canDelete;
    }

    public final String getFileSize() {
        return this.fileSize;
    }

    public final String getFileToken() {
        return this.fileToken;
    }

    public final String getGuid() {
        return this.guid;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean getStatusFail() {
        return this.statusFail;
    }

    public final TodoAttachment.Type getType() {
        return this.type;
    }

    public final long getUploadMilliTime() {
        return this.uploadMilliTime;
    }

    public final String getUploaderUserId() {
        return this.uploaderUserId;
    }

    public TodoAttachment getPbData() {
        return this.pbData;
    }

    @Override // com.ss.android.lark.todo.impl.features.detail.viewmodel.data.a
    public /* bridge */ /* synthetic */ TodoAttachment parseToPb() {
        return parseToPb();
    }

    public TodoAttachmentData(TodoAttachment r100) {
        Intrinsics.checkNotNullParameter(r100, "pbData");
        this.pbData = r100;
        this.fileToken = getPbData().file_token;
        String r101 = getPbData().file_size;
        if (r101 != null) goto L5;
        r101 = "0";
    L5:
        this.fileSize = r101;
        String r102 = getPbData().name;
        String r103 = "";
        if (r102 != null) goto L8;
        r102 = "";
    L8:
        this.name = r102;
        this.type = TodoAttachment.Type.FILE;
        String r104 = getPbData().uploader_user_id;
        if (r104 != null) goto L11;
        r104 = "";
    L11:
        this.uploaderUserId = r104;
        String r105 = getPbData().guid;
        if (r105 == null) goto L15;
        r103 = r105;
    L15:
        this.guid = r103;
        this.canDelete = getPbData().can_delete.booleanValue();
        this.uploadMilliTime = getPbData().upload_milli_time.longValue();
        this.bytesTotal = CastLongProtector.parseLong(this.fileSize);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TodoAttachmentData) == true) goto L8;
        return false;
    L8:
        TodoAttachmentData r101 = (TodoAttachmentData) r100;
        if (Intrinsics.areEqual(this.fileToken, r101.fileToken) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.fileSize, r101.fileSize) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L18;
        return false;
    L18:
        if (this.type == r101.type) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.uploaderUserId, r101.uploaderUserId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.guid, r101.guid) == true) goto L27;
        return false;
    L27:
        if (this.canDelete == r101.canDelete) goto L30;
        return false;
    L30:
        if (this.uploadMilliTime == r101.uploadMilliTime) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.key, r101.key) == true) goto L36;
        return false;
    L36:
        if (this.bytesTransferred == r101.bytesTransferred) goto L39;
        return false;
    L39:
        if (this.bytesTotal == r101.bytesTotal) goto L42;
        return false;
    L42:
        if (this.statusFail == r101.statusFail) goto L44;
        return false;
    L44:
        return true;
    }

    public final void setBytesTotal(long r100) {
        this.bytesTotal = r100;
    }

    public final void setBytesTransferred(long r100) {
        this.bytesTransferred = r100;
    }

    public final void setCanDelete(boolean r100) {
        this.canDelete = r100;
    }

    public final void setFileSize(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.fileSize = r100;
    }

    public final void setFileToken(String r100) {
        this.fileToken = r100;
    }

    public final void setGuid(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.guid = r100;
    }

    public final void setKey(String r100) {
        this.key = r100;
    }

    public final void setName(String r100) {
        this.name = r100;
    }

    public void setPbData(TodoAttachment r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.pbData = r100;
    }

    public final void setStatusFail(boolean r100) {
        this.statusFail = r100;
    }

    public final void setType(TodoAttachment.Type r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.type = r100;
    }

    public final void setUploadMilliTime(long r100) {
        this.uploadMilliTime = r100;
    }

    public final void setUploaderUserId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.uploaderUserId = r100;
    }

    public /* bridge */ /* synthetic */ void setPbData(Object r100) {
        setPbData((TodoAttachment) r100);
    }
}
