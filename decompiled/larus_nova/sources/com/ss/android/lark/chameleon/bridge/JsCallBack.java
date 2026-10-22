package com.ss.android.lark.chameleon.bridge;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u0016¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/chameleon/bridge/JsCallBack;", "", "onCallBack", "", "status", "Lcom/ss/android/lark/chameleon/bridge/Status;", "param", "chameleon-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface JsCallBack {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultImpls {
        public static void onCallBack(JsCallBack r100, Status r101, Object r102) {
            Intrinsics.checkNotNullParameter(r101, "status");
        }

        public static /* synthetic */ void onCallBack$default(JsCallBack r100, Status r101, Object r102, int r103, Object r104) {
            if (r104 != null) goto L9;
            if ((r103 & 1) == 0) goto L6;
            r101 = Status.SUCCESS;
        L6:
            r100.onCallBack(r101, r102);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onCallBack");
        }
    }

    void onCallBack(Status r100, Object r101);
}
