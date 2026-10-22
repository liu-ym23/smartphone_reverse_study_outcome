package com.larus.im.service;

import com.larus.im.callback.IIMError;
import com.larus.im.internal.jni.bean.OmniDispatchCommandResponse;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public interface a0 {

    /* JADX INFO: loaded from: classes30.dex */
    public static final class a {
        public static void a(String r100, String r101, IIMError r102) {
            Intrinsics.checkNotNullParameter(r100, "targetDeviceId");
            Intrinsics.checkNotNullParameter(r101, "commandId");
            Intrinsics.checkNotNullParameter(r102, "error");
        }
    }

    void a(String r100, String r101, IIMError r102);

    void onReceiveDispatchCommand(OmniDispatchCommandResponse r100);
}
