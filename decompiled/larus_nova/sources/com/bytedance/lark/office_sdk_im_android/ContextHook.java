package com.bytedance.lark.office_sdk_im_android;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0001H&J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00012\u0006\u0010\n\u001a\u00020\u0003H&¨\u0006\u000b"}, d2 = {"Lcom/bytedance/lark/office_sdk_im_android/ContextHook;", "", "onInvoke", "", "info", "Lcom/bytedance/lark/office_sdk_im_android/InvokeHookInfo;", "onInvokeeEnd", "", "invokeeObj", "onInvokeeStart", "hookBuf", "office_sdk_im_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface ContextHook {
    byte[] onInvoke(InvokeHookInfo r100);

    void onInvokeeEnd(Object r100);

    Object onInvokeeStart(byte[] r100);
}
