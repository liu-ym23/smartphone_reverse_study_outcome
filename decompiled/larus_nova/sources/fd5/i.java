package fd5;

import android.content.Context;
import android.widget.ImageView;
import com.bytedance.ee.bear.list.dto.Document;

/* JADX INFO: loaded from: classes18.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f476527a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Document f476528b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f476529c;

    public abstract void a();

    public i(Context r100, Document r101, ImageView r102) {
        this.f476528b = r101;
        this.f476527a = r100;
        this.f476529c = r102;
    }
}
