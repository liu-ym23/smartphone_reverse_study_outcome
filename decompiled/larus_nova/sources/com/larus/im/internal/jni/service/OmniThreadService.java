package com.larus.im.internal.jni.service;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.larus.im.internal.jni.bean.OmniCommonResponse;
import com.larus.im.internal.jni.bean.OmniDeleteThreadRequest;
import com.larus.im.internal.jni.bean.OmniGetThreadRequest;
import com.larus.im.internal.jni.bean.OmniGetThreadResponse;
import com.larus.im.internal.jni.bean.OmniInOutThreadRequest;
import com.larus.im.internal.jni.callback.OmniIMCallback;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0086 J\u001f\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00100\u000bH\u0086 J\u0011\u0010\u0011\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0012H\u0086 JY\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0019\u001a\u00020\u001a2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u001c2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u001a0\u000bH\u0086 R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/larus/im/internal/jni/service/OmniThreadService;", "", "omniSdkPtr", "", "<init>", "(J)V", "getThread", "", "request", "Lcom/larus/im/internal/jni/bean/OmniGetThreadRequest;", "callback", "Lcom/larus/im/internal/jni/callback/OmniIMCallback;", "Lcom/larus/im/internal/jni/bean/OmniGetThreadResponse;", "deleteThread", HiAnalyticsConstant.Direction.REQUEST, "Lcom/larus/im/internal/jni/bean/OmniDeleteThreadRequest;", "Lcom/larus/im/internal/jni/bean/OmniCommonResponse;", "inOutThread", "Lcom/larus/im/internal/jni/bean/OmniInOutThreadRequest;", "interruptMessage", "threadId", "", "lastSendMsgId", "lastSendMsgLocalId", "lastReplyMsgId", "interruptServer", "", "modifyAnswerMap", "", "omnisdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OmniThreadService {
    private final long omniSdkPtr;

    public final native void deleteThread(OmniDeleteThreadRequest r100, OmniIMCallback<OmniCommonResponse> r101);

    public final native void getThread(OmniGetThreadRequest r100, OmniIMCallback<OmniGetThreadResponse> r101);

    public final native void inOutThread(OmniInOutThreadRequest r100);

    public final native void interruptMessage(String r100, String r101, String r102, String r103, boolean r104, Map<String, String> r105, OmniIMCallback<Boolean> r106);

    private OmniThreadService(long r100) {
        this.omniSdkPtr = r100;
    }
}
