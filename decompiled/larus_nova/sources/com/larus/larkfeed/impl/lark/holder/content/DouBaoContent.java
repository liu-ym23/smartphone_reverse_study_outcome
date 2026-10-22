package com.larus.larkfeed.impl.lark.holder.content;

import com.ss.android.lark.chat.export.entity.message.Content;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/larus/larkfeed/impl/lark/holder/content/DouBaoContent;", "Lcom/ss/android/lark/chat/export/entity/message/Content;", "Lcom/ss/android/lark/biz/im/api/IDoubaoMessagePayloadContent;", "Lcom/ss/android/lark/biz/officesdk/im/mergeforward/IDoubaoMessagePayloadContent;", "<init>", "()V", "id", "", "getId", "()Ljava/lang/Long;", "setId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "data", "", "getData", "()[B", "setData", "([B)V", "larkMessageId", "", "getLarkMessageId", "()Ljava/lang/String;", "setLarkMessageId", "(Ljava/lang/String;)V", "doubaoMessagePayload", "getDoubaoMessagePayload", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DouBaoContent extends Content implements com.ss.android.lark.biz.im.api.s {
    private byte[] data;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private Long f355345id;
    private String larkMessageId;

    public DouBaoContent() {
    }

    public final byte[] getData() {
        return this.data;
    }

    @Override // com.ss.android.lark.biz.im.api.s
    public byte[] getDoubaoMessagePayload() {
        return this.data;
    }

    public final Long getId() {
        return this.f355345id;
    }

    public final String getLarkMessageId() {
        return this.larkMessageId;
    }

    public final void setData(byte[] r100) {
        this.data = r100;
    }

    public final void setId(Long r100) {
        this.f355345id = r100;
    }

    public final void setLarkMessageId(String r100) {
        this.larkMessageId = r100;
    }
}
