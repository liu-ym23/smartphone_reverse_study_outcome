package il7;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes22.dex */
public final class j implements f.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ImageView f490334a;

    @Override // il7.f.a
    public final void onError() {
    }

    public j(ImageView r100) {
        this.f490334a = r100;
    }

    @Override // il7.f.a
    public final void onSuccess(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L10;
        Bitmap r101 = BitmapFactory.decodeFile(r100);
        if (r101 != null) goto L7;
        return;
    L7:
        if (r101.isRecycled() == true) goto L12;
        this.f490334a.setVisibility(0);
        this.f490334a.setImageBitmap(r101);
        return;
    L12:
        return;
    }
}
