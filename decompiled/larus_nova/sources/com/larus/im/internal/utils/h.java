package com.larus.im.internal.utils;

import com.larus.im.internal.protocol.bean.IMCMD;
import kotlin.collections.SetsKt;

/* JADX INFO: loaded from: classes30.dex */
public final class h {
    public static final boolean a(int r100) {
        return SetsKt.setOf(new Integer[]{Integer.valueOf(IMCMD.SEND_MESSAGE.value), Integer.valueOf(IMCMD.SEND_MESSAGE_LIST.value), Integer.valueOf(IMCMD.CONVERSATION_OUT.value), Integer.valueOf(IMCMD.CONVERSATION_IN.value), Integer.valueOf(IMCMD.IMCMD_COMMON.value)}).contains(Integer.valueOf(r100));
    }
}
