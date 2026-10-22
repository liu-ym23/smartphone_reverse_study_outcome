package com.larus.im.internal.jni.observer;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J(\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0006H\u0016¨\u0006\u000e"}, d2 = {"Lcom/larus/im/internal/jni/observer/OmniAIJobObserver;", "Lcom/larus/im/internal/jni/observer/Observer;", "onJobsChanged", "", "changedIds", "", "", "deletedIds", "onRequestStateChanged", "requestType", "", "status", "errorCode", "errorMessage", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface OmniAIJobObserver extends Observer {

    /* JADX INFO: loaded from: classes29.dex */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void onRequestStateChanged(OmniAIJobObserver r100, int r101, int r102, int r103, String r104) {
            Intrinsics.checkNotNullParameter(r104, "errorMessage");
        }
    }

    void onJobsChanged(List<String> r100, List<String> r101);

    void onRequestStateChanged(int r100, int r101, int r102, String r103);
}
