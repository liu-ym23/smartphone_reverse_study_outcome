package com.bytedance.lark.office_sdk_im_android;

import com.bytedance.common.wschannel.WsConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H&ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\"\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H&ø\u0001\u0000¢\u0006\u0004\b\n\u0010\bJ\b\u0010\u000b\u001a\u00020\fH&\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\r"}, d2 = {"Lcom/bytedance/lark/office_sdk_im_android/OfficeSdkOpenMessageOperator;", "", "getMessageContentDigest", "", "sdkSession", "Lkotlin/ULong;", WsConstants.KEY_PAYLOAD, "getMessageContentDigest-4PLdz1A", "(J[B)[B", "onMessagesDelete", "onMessagesDelete-4PLdz1A", "supportMessageType", "Lcom/bytedance/lark/office_sdk_im_android/MessageType;", "office_sdk_im_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface OfficeSdkOpenMessageOperator {
    /* JADX INFO: renamed from: getMessageContentDigest-4PLdz1A, reason: not valid java name */
    byte[] mo8445getMessageContentDigest4PLdz1A(long r100, byte[] r101);

    /* JADX INFO: renamed from: onMessagesDelete-4PLdz1A, reason: not valid java name */
    byte[] mo8446onMessagesDelete4PLdz1A(long r100, byte[] r101);

    MessageType supportMessageType();
}
