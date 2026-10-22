package com.larus.chat.gallery.api;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000 \f2\u00020\u0001:\u0001\fJ6\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\r"}, d2 = {"Lcom/larus/chat/gallery/api/IFindSimilarClickHandler;", "", "handleFindSimilarClick", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "imageUri", "", "messageId", "sendText", "sender", "Lcom/larus/chat/gallery/api/FindSimilarSender;", "Delegate", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IFindSimilarClickHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Delegate f324105a = null;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J6\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/larus/chat/gallery/api/IFindSimilarClickHandler$Delegate;", "Lcom/larus/chat/gallery/api/IFindSimilarClickHandler;", "<init>", "()V", "impl", "getImpl", "()Lcom/larus/chat/gallery/api/IFindSimilarClickHandler;", "impl$delegate", "Lkotlin/Lazy;", "handleFindSimilarClick", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "imageUri", "", "messageId", "sendText", "sender", "Lcom/larus/chat/gallery/api/FindSimilarSender;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Delegate implements IFindSimilarClickHandler {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ Delegate f324106b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Lazy<IFindSimilarClickHandler> f324107c = null;

        private Delegate() {
        }

        static {
            f324106b = new Delegate();
            f324107c = LazyKt.lazy(new k());
        }

        @Override // com.larus.chat.gallery.api.IFindSimilarClickHandler
        public final boolean a(Context r100, String r101, String r110, String r111, com.larus.chat.gallery.impl.providers.h r112) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r112, "sender");
            IFindSimilarClickHandler r102 = f324107c.getValue();
            if (r102 != null) goto L7;
            return false;
        L7:
            return r102.a(r100, r101, r110, r111, r112);
        }
    }

    static {
        f324105a = Delegate.f324106b;
    }

    boolean a(Context r100, String r101, String r102, String r103, com.larus.chat.gallery.impl.providers.h r104);
}
