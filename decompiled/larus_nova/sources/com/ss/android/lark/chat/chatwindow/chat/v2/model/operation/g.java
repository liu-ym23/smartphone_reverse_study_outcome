package com.ss.android.lark.chat.chatwindow.chat.v2.model.operation;

import com.ss.android.lark.auditsdk.v2.receivecheck.entity.ValidateIMFileResult;
import com.ss.android.lark.chat.entity.message.content.MergeForwardContent;
import com.ss.android.lark.chat.export.entity.message.MessageType;
import com.ss.android.lark.chat.utils.ThreadMergeForwardAuthorityUtil;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class g implements Function1<f5b.b, f5b.b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, ValidateIMFileResult> f414425a;

    public static final class a implements Function1<f5b.b, Boolean> {
        public a() {
        }

        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(f5b.b r100) {
            f5b.b r101 = r100;
            if (r101 != null) goto L6;
            return Boolean.FALSE;
        L6:
            if (r101.getMessage().getMessageType() == MessageType.MERGE_FORWARD) goto L9;
            return Boolean.FALSE;
        L9:
            if (((MergeForwardContent) r101.getMessage().getMessageContent()).isFromPrivateTopic() == true) goto L12;
            return Boolean.FALSE;
        L12:
            return Boolean.TRUE;
        }
    }

    public g(Map<String, ValidateIMFileResult> r100) {
        Intrinsics.checkNotNullParameter(r100, "validateResult");
        this.f414425a = r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public final f5b.b invoke(f5b.b r100) {
        f5b.b r101 = r100;
        if (r101 != null) goto L5;
        return null;
    L5:
        ThreadMergeForwardAuthorityUtil.a(r101, this.f414425a);
        return r101;
    }
}
