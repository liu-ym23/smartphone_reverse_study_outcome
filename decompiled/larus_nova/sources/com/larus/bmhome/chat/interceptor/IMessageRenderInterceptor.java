package com.larus.bmhome.chat.interceptor;

import bf8.a;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.im.bean.message.Message;
import com.vivo.push.PushClientConstants;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016JX\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152&\u0010\u0016\u001a\"\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0017j\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\f`\u00182\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\fH\u0016J \u0010\u001c\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\fH\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001d"}, d2 = {"Lcom/larus/bmhome/chat/interceptor/IMessageRenderInterceptor;", "Lcom/larus/bmhome/chat/interceptor/IMessageRenderInterceptorService;", "<init>", "()V", "service", "getService", "()Lcom/larus/bmhome/chat/interceptor/IMessageRenderInterceptorService;", "service$delegate", "Lkotlin/Lazy;", "updateMessageRenderState", "", RemoteMessageConst.MSGID, "", "state", "Lcom/larus/bmhome/chat/interceptor/MessageRenderState;", "message", "Lcom/larus/im/bean/message/Message;", "openMarkdownRenderCrashRecovery", "openMessageRenderWatcher", "", "effectiveThreshold", "", "portrayal", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", PushClientConstants.TAG_CLASS_NAME, "methodName", "errorType", "onMessageRenderException", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IMessageRenderInterceptor implements IMessageRenderInterceptorService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final IMessageRenderInterceptor f303337a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f303338b = null;

    private IMessageRenderInterceptor() {
    }

    static {
        f303337a = new IMessageRenderInterceptor();
        f303338b = LazyKt.lazy(new a());
    }

    @Override // com.larus.bmhome.chat.interceptor.IMessageRenderInterceptorService
    public final void c(int r100, HashMap r101) {
        Intrinsics.checkNotNullParameter(r101, "portrayal");
        Intrinsics.checkNotNullParameter("", PushClientConstants.TAG_CLASS_NAME);
        Intrinsics.checkNotNullParameter("", "methodName");
        Intrinsics.checkNotNullParameter("", "errorType");
        IMessageRenderInterceptorService r102 = (IMessageRenderInterceptorService) f303338b.getValue();
        if (r102 == null) goto L6;
        r102.c(r100, r101);
        return;
    }

    @Override // com.larus.bmhome.chat.interceptor.IMessageRenderInterceptorService
    public final void a(String r100, MessageRenderState r101, Message r102) {
        Intrinsics.checkNotNullParameter(r100, RemoteMessageConst.MSGID);
        Intrinsics.checkNotNullParameter(r101, "state");
        Intrinsics.checkNotNullParameter(r102, "message");
        IMessageRenderInterceptorService r103 = (IMessageRenderInterceptorService) f303338b.getValue();
        if (r103 == null) goto L6;
        r103.a(r100, r101, r102);
        return;
    }

    @Override // com.larus.bmhome.chat.interceptor.IMessageRenderInterceptorService
    public final void b(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, PushClientConstants.TAG_CLASS_NAME);
        Intrinsics.checkNotNullParameter(r101, "methodName");
        Intrinsics.checkNotNullParameter(r102, "errorType");
        IMessageRenderInterceptorService r103 = (IMessageRenderInterceptorService) f303338b.getValue();
        if (r103 == null) goto L6;
        r103.b(r100, r101, r102);
        return;
    }
}
