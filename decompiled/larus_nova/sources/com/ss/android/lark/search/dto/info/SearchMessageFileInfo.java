package com.ss.android.lark.search.dto.info;

import com.bytedance.lark.pb.search.v2.MessageFileMeta;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00118F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"Lcom/ss/android/lark/search/dto/info/SearchMessageFileInfo;", "Lcom/ss/android/lark/search/dto/info/SearchMessageInfo;", "<init>", "()V", "fileType", "Lcom/bytedance/lark/pb/search/v2/MessageFileMeta$FileType;", "getFileType", "()Lcom/bytedance/lark/pb/search/v2/MessageFileMeta$FileType;", "setFileType", "(Lcom/bytedance/lark/pb/search/v2/MessageFileMeta$FileType;)V", RemoteMessageConst.MSGID, "", "getMsgId", "()Ljava/lang/String;", "setMsgId", "(Ljava/lang/String;)V", "isInnerFile", "", "()Z", "setInnerFile", "(Z)V", "_isDestroyed", "value", "isDestroyed", "setDestroyed", "sceneId", "", "getSceneId", "()Ljava/lang/Integer;", "setSceneId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "search-dto_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SearchMessageFileInfo extends SearchMessageInfo {
    private boolean _isDestroyed;
    private MessageFileMeta.FileType fileType;
    private boolean isInnerFile;
    private String msgId;
    private Integer sceneId;

    public final boolean isDestroyed() {
        Integer r100 = this.sceneId;
        if (r100 == null) goto L9;
        if (r100 != null) goto L7;
    L10:
        return true;
    L7:
        if (r100.intValue() != 0) goto L10;
    L9:
        if (this._isDestroyed == true) goto L10;
        return false;
    }

    public SearchMessageFileInfo() {
    }

    public final MessageFileMeta.FileType getFileType() {
        return this.fileType;
    }

    public final String getMsgId() {
        return this.msgId;
    }

    public final Integer getSceneId() {
        return this.sceneId;
    }

    public final boolean isInnerFile() {
        return this.isInnerFile;
    }

    public final void setDestroyed(boolean r100) {
        this._isDestroyed = r100;
    }

    public final void setFileType(MessageFileMeta.FileType r100) {
        this.fileType = r100;
    }

    public final void setInnerFile(boolean r100) {
        this.isInnerFile = r100;
    }

    public final void setMsgId(String r100) {
        this.msgId = r100;
    }

    public final void setSceneId(Integer r100) {
        this.sceneId = r100;
    }
}
