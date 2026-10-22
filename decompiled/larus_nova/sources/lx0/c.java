package lx0;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import com.bytedance.android.live.record.LiveScreenRecordPublishGuideDialog;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveScreenRecordPublishGuideDialog f511107a;

    public c(LiveScreenRecordPublishGuideDialog r100) {
        this.f511107a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Bitmap r101 = (Bitmap) r100;
        ImageView r102 = this.f511107a.E;
        if (r102 == null) goto L6;
        r102.setBackground(new BitmapDrawable(this.f511107a.getContext().getResources(), r101));
        return;
    }
}
