package fd5;

import android.content.Context;
import android.widget.ImageView;
import com.bytedance.ee.bear.list.dto.Document;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class i {
    public final Context a;
    public final Document b;
    public final ImageView c;

    public abstract void a();

    public i(Context r1, Document r2, ImageView r3) {
        this.b = r2;
        this.a = r1;
        this.c = r3;
    }
}
