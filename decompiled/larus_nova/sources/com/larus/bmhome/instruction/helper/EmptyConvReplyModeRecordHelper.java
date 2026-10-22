package com.larus.bmhome.instruction.helper;

import com.larus.bmhome.actionbar.model.ReplyOption;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\u000b"}, d2 = {"Lcom/larus/bmhome/instruction/helper/EmptyConvReplyModeRecordHelper;", "Lcom/larus/bmhome/instruction/helper/IConvReplyModeRecordHelper;", "<init>", "()V", "updateLatestReplyOption", "", "conversationId", "", "replyOption", "Lcom/larus/bmhome/actionbar/model/ReplyOption;", "getLatestReplyOption", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EmptyConvReplyModeRecordHelper implements IConvReplyModeRecordHelper {
    public EmptyConvReplyModeRecordHelper() {
    }

    @Override // com.larus.bmhome.instruction.helper.IConvReplyModeRecordHelper
    public final void a(String r100, ReplyOption r101) {
    }

    @Override // com.larus.bmhome.instruction.helper.IConvReplyModeRecordHelper
    public final ReplyOption b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        return null;
    }
}
