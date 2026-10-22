package com.vivo.push;

import android.content.Intent;

/* JADX INFO: loaded from: classes41.dex */
public interface IPushClientFactory {
    com.vivo.push.h.ab createReceiveTask(v r100);

    v createReceiverCommand(Intent r100);

    s createTask(v r100);
}
