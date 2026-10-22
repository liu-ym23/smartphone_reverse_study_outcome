package com.ss.android.lark.chat.chatwindow.chat.model.preload.audio;

import android.text.TextUtils;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.biz.im.api.extension.message.f;
import com.ss.android.lark.biz.im.api.extension.message.g;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.entity.message.content.AudioContent;
import com.ss.android.lark.log.Log;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class AudioResourceLoadTask extends g {

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.biz.im.api.extension.message.IMessageResourcePreloadTask
    public final String getTaskType() {
        return "audio";
    }

    @Override // com.ss.android.lark.biz.im.api.extension.message.IMessageResourcePreloadTask
    public final Set<String> getScenes() {
        HashSet r100 = new HashSet();
        r100.add("chat");
        r100.add("chat_thread");
        r100.add("reply_in_thread");
        return r100;
    }

    public AudioResourceLoadTask(f r100) {
        Intrinsics.checkNotNullParameter(r100, "loadTaskContext");
        super(r100);
    }

    @Override // com.ss.android.lark.biz.im.api.extension.message.IMessageResourcePreloadTask
    public final boolean c(Set<? extends MessageInfo> r100) {
        Intrinsics.checkNotNullParameter(r100, "messageInfoList");
        return a(r100, false, null);
    }

    @Override // com.ss.android.lark.biz.im.api.extension.message.IMessageResourcePreloadTask
    public final boolean d(Message.Type r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        if (r100 != Message.Type.AUDIO) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.ss.android.lark.biz.im.api.extension.message.IMessageResourcePreloadTask
    public final boolean e(Set<? extends MessageInfo> r100, IGetDataCallback<Map<String, String>> r101) {
        return a(r100, true, r101);
    }

    public final boolean a(Set<? extends MessageInfo> r100, final boolean r110, final IGetDataCallback<Map<String, String>> r111) {
        Log.i("AudioResourceLoadTask", "load audio forceLoad =" + r110);
        final HashMap r101 = new HashMap();
        final HashMap r102 = new HashMap();
        Iterator<? extends MessageInfo> r103 = r100.iterator();
    L4:
        if (r103.hasNext() == false) goto L25;
        MessageInfo r104 = r103.next();
        if (r104 == null) goto L8;
        Message r105 = r104.getMessage();
    L9:
        if (r105 == null) goto L4;
        if (r104.getMessage().getType() != Message.Type.AUDIO) goto L4;
        Message r106 = r104.getMessage();
        AudioContent r107 = (AudioContent) r106.getContent();
        String r108 = r107.getKey();
        if (TextUtils.isEmpty(r108) == true) goto L4;
        if (r110 == true) goto L21;
        if (TextUtils.isEmpty(r107.getLocalFilePath()) == true) goto L21;
        if (r107.getAudioWaveBytes() != null) goto L4;
    L21:
        if (TextUtils.equals(r106.getId(), r106.getcId()) == true) goto L4;
        String r109 = r106.getId();
        r101.put(r108, r109);
        r102.put(r109, r104);
        goto L4
    L8:
        r105 = null;
        goto L9
    L25:
        if (CollectionUtils.isEmpty(r101) == false) goto L28;
        return false;
    L28:
        if (r110 == false) goto L33;
        Iterator r112 = r101.entrySet().iterator();
    L31:
        if (r112.hasNext() == false) goto L33;
        Map.Entry r113 = (Map.Entry) r112.next();
        Log.i("AudioResourceLoadTask", "forceFetch audio key:" + ((String) r113.getKey()) + ", messageId:" + ((String) r113.getValue()));
    L33:
        Log.d("AudioResourceLoadTask", "prepareAudioMessage1:" + r101.size());
        CoreThreadPool.getDefault().getCachedThreadPool().execute(new AudioResourceLoadTask$load$2(r110, r101, r102, this, r111));
        return true;
    }
}
