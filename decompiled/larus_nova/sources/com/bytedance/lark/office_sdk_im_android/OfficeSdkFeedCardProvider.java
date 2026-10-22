package com.bytedance.lark.office_sdk_im_android;

import com.bytedance.common.wschannel.WsConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H&ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\"\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H&ø\u0001\u0000¢\u0006\u0004\b\n\u0010\bJ\"\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H&ø\u0001\u0000¢\u0006\u0004\b\f\u0010\bJ\"\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H&ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\bJ\b\u0010\u000f\u001a\u00020\u0010H&J\"\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H&ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\b\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0013"}, d2 = {"Lcom/bytedance/lark/office_sdk_im_android/OfficeSdkFeedCardProvider;", "", "packFeedChannel", "", "sdkSession", "Lkotlin/ULong;", WsConstants.KEY_PAYLOAD, "packFeedChannel-4PLdz1A", "(J[B)[B", "packFeedPreview", "packFeedPreview-4PLdz1A", "preloadByFeed", "preloadByFeed-4PLdz1A", "saveDataForSyncFeed", "saveDataForSyncFeed-4PLdz1A", "supportFeedType", "Lcom/bytedance/lark/office_sdk_im_android/SupportFeedType;", "verifyFeedData", "verifyFeedData-4PLdz1A", "office_sdk_im_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface OfficeSdkFeedCardProvider {
    /* JADX INFO: renamed from: packFeedChannel-4PLdz1A, reason: not valid java name */
    byte[] mo8437packFeedChannel4PLdz1A(long r100, byte[] r101);

    /* JADX INFO: renamed from: packFeedPreview-4PLdz1A, reason: not valid java name */
    byte[] mo8438packFeedPreview4PLdz1A(long r100, byte[] r101);

    /* JADX INFO: renamed from: preloadByFeed-4PLdz1A, reason: not valid java name */
    byte[] mo8439preloadByFeed4PLdz1A(long r100, byte[] r101);

    /* JADX INFO: renamed from: saveDataForSyncFeed-4PLdz1A, reason: not valid java name */
    byte[] mo8440saveDataForSyncFeed4PLdz1A(long r100, byte[] r101);

    SupportFeedType supportFeedType();

    /* JADX INFO: renamed from: verifyFeedData-4PLdz1A, reason: not valid java name */
    byte[] mo8441verifyFeedData4PLdz1A(long r100, byte[] r101);
}
