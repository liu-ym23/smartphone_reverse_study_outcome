package com.ss.android.lark.widget.photo.preview.menu.action;

import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/ss/android/lark/widget/photo/preview/menu/action/MediaDownloadAction$downloadMessageFile$2$1", "Lcom/larksuite/framework/callback/IGetDataCallback;", "", "onSuccess", "", "s", LynxVideoManagerLite.EVENT_ON_ERROR, "err", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "photo-picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MediaDownloadAction$downloadMessageFile$2$1 implements IGetDataCallback<String> {
    final /* synthetic */ kotlinx.coroutines.i<MediaDownloadAction.b> $it;
    final /* synthetic */ MediaDownloadAction this$0;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ kotlinx.coroutines.i<MediaDownloadAction.b> f446818a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ErrorResult f446819b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ MediaDownloadAction f446820c;

        /* JADX WARN: Multi-variable type inference failed */
        public a(kotlinx.coroutines.i<? super MediaDownloadAction.b> r100, ErrorResult r101, MediaDownloadAction r102) {
            this.f446818a = r100;
            this.f446819b = r101;
            this.f446820c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            kotlinx.coroutines.i<MediaDownloadAction.b> r100 = this.f446818a;     // Catch: Throwable -> L4
            Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L4
            r100.resumeWith(Result.m9449constructorimpl(new MediaDownloadAction.b.a(this.f446819b)));     // Catch: Throwable -> L4
            MediaDownloadAction r102 = this.f446820c;     // Catch: Throwable -> L4
            ConcurrentHashMap<Integer, Boolean> r103 = MediaDownloadAction.f446807i;     // Catch: Throwable -> L4
            r102.b();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.larksuite.framework.callback.IGetDataCallback
    public void onError(ErrorResult r100) {
        Intrinsics.checkNotNullParameter(r100, "err");
        int r101 = com.ss.android.lark.widget.photopicker.f.a().e();
        int r102 = com.ss.android.lark.widget.photopicker.f.a().v();
        int r103 = r100.getErrorCode();
        if (r103 == r101) goto L7;
        if (r103 == r102) goto L7;
        UICallbackExecutor.executeDelayed(new a(this.$it, r100, this.this$0), 200);
        return;
    L7:
        kotlinx.coroutines.i<MediaDownloadAction.b> r104 = this.$it;
        Result.Companion r105 = Result.Companion;
        r104.resumeWith(Result.m9449constructorimpl(new MediaDownloadAction.b.a(r100)));
        MediaDownloadAction r106 = this.this$0;
        ConcurrentHashMap<Integer, Boolean> r107 = MediaDownloadAction.f446807i;
        r106.b();
    }

    public void onSuccess(String r100) {
        Intrinsics.checkNotNullParameter(r100, "s");
        kotlinx.coroutines.i<MediaDownloadAction.b> r101 = this.$it;
        Result.Companion r102 = Result.Companion;
        r101.resumeWith(Result.m9449constructorimpl(new MediaDownloadAction.b.C5412b(r100)));
        MediaDownloadAction r103 = this.this$0;
        ConcurrentHashMap<Integer, Boolean> r104 = MediaDownloadAction.f446807i;
        r103.b();
        MediaDownloadAction r105 = this.this$0;
        com.ss.android.lark.widget.photopicker.utils.g.b(r105.f446815h, r105.f446808a, r100);
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onError(ErrorResult r100) {
        onError(r100);
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onSuccess(Object r100) {
        onSuccess((String) r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MediaDownloadAction$downloadMessageFile$2$1(kotlinx.coroutines.i<? super MediaDownloadAction.b> r100, MediaDownloadAction r101) {
        this.$it = r100;
        this.this$0 = r101;
    }
}
