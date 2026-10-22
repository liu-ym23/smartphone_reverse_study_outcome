package com.ss.android.lark.widget.photo.preview.menu.action;

import com.larksuite.framework.callback.OnUpdateProgressListener;
import java.lang.ref.WeakReference;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0016¨\u0006\t"}, d2 = {"com/ss/android/lark/widget/photo/preview/menu/action/MediaDownloadAction$downloadMessageFile$2$2", "Lcom/larksuite/framework/callback/OnUpdateProgressListener;", "onUpdateProgress", "", "total", "", "curPos", "", "speed", "photo-picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MediaDownloadAction$downloadMessageFile$2$2 implements OnUpdateProgressListener {
    final /* synthetic */ WeakReference<MediaDownloadAction.DownloadCallback> $callbackRef;
    final /* synthetic */ String $key;
    final /* synthetic */ MediaDownloadAction this$0;

    public MediaDownloadAction$downloadMessageFile$2$2(MediaDownloadAction r100, String r101, WeakReference<MediaDownloadAction.DownloadCallback> r102) {
        this.this$0 = r100;
        this.$key = r101;
        this.$callbackRef = r102;
    }

    @Override // com.larksuite.framework.callback.OnUpdateProgressListener
    public void onUpdateProgress(long r100, int r101, long r102) {
        if (this.this$0.f446813f == true) goto L8;
        com.ss.android.lark.widget.photopicker.f.a().q();
        this.this$0.f446813f = true;
        MediaDownloadAction.DownloadCallback r103 = this.$callbackRef.get();
        if (r103 == null) goto L9;
        r103.onDownloadProgress((r101 * 100.0f) / r100);
        return;
    L9:
        return;
    }
}
