package com.ss.android.lark.chat.utils;

import android.text.TextUtils;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.entity.message.content.AudioContent;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.rxjava.RxScheduledExecutor;

/* JADX INFO: loaded from: classes35.dex */
class AudioMessageHelper$1 implements IGetDataCallback<String> {
    final /* synthetic */ AudioContent val$audioContent;

    public AudioMessageHelper$1(AudioContent r100) {
        this.val$audioContent = r100;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.larksuite.framework.callback.IGetDataCallback
    public void onError(ErrorResult r100) {
        Log.d(r100.toString());
        this.val$audioContent.setFileState(AudioContent.AudioState.DOWNLOAD);
    }

    public void onSuccess(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        this.val$audioContent.setFileState(AudioContent.AudioState.DOWNLOAD);
        return;
    L5:
        this.val$audioContent.setProgress(100);
        this.val$audioContent.setFileState(AudioContent.AudioState.DONE);
        this.val$audioContent.setLocalFilePath(r100);
        final AudioContent r101 = this.val$audioContent;
        if (r101 != null) goto L8;
        return;
    L8:
        if (r101.getAudioWaveBytes() == null) goto L10;
        return;
    L10:
        if (TextUtils.isEmpty(r101.getLocalFilePath()) == true) goto L16;
        RxScheduledExecutor.justInIO(new a(r101));
        return;
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onError(ErrorResult r100) {
        onError(r100);
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onSuccess(Object r100) {
        onSuccess((String) r100);
    }
}
