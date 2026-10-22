package com.ss.android.lark.chat.utils;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.IMFileResult;
import com.ss.android.lark.auditsdk.v2.receivecheck.entity.ValidateIMFileResult;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.MergeForwardContent;
import com.ss.android.lark.chat.export.entity.message.MessageType;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class ThreadMergeForwardAuthorityUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f416635a = null;

    static {
        f416635a = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, ThreadMergeForwardAuthorityUtil$passportDependency$2.INSTANCE);
    }

    @JvmStatic
    public static final boolean a(f5b.b r100, Map<String, ValidateIMFileResult> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "resultMap");
        Message r102 = r100.getMessage();
        boolean r103 = false;
        if (r102.getMessageType() != MessageType.MERGE_FORWARD) goto L28;
        MergeForwardContent r104 = (MergeForwardContent) r102.getMessageContent();
        if (r104.isFromPrivateTopic() == false) goto L28;
        List<Message> r105 = r104.getMessages();
        List<Message> r106 = r105;
        if (r106 != null) goto L11;
    L14:
        boolean r107 = true;
    L15:
        if (r107 == true) goto L28;
        Message r108 = (Message) ListProtector.get(r105, 0);
        ValidateIMFileResult r109 = r101.get(r108.getId());
        if (r109 == null) goto L28;
        ValidateIMFileResult r110 = r108.getValidateIMFileResult();
        if (r110 == null) goto L25;
        IMFileResult r111 = r110.getResultType();
        if (r111 == null) goto L25;
        if (r111.getValue() != r109.getResultType().getValue()) goto L25;
        boolean r112 = true;
    L26:
        if (r112 == true) goto L28;
        r108.setValidateIMFileResult(r109);
        r103 = true;
    L25:
        r112 = false;
        goto L26
    L11:
        if (r106.isEmpty() == true) goto L14;
        r107 = false;
    L28:
        r100.setForceUpdate(r103);
        return r103;
    }
}
