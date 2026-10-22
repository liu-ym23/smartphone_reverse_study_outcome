package fd5;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.ee.bear.list.dto.Document;

/* JADX INFO: loaded from: classes18.dex */
public final class c extends i {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f476516d;

    @Override // fd5.i
    public final void a() {
        int r100 = this.f476528b.getType();
        if (m.a() == false) goto L5;
        int r101 = rbb.b.c(r100, null);
    L6:
        int r102 = r101;
        if (this.f476516d == false) goto L13;
        Document.DocumentIcon r103 = this.f476528b.f227886k1;
        if (r103.f227912b == (-1)) goto L13;
        if (TextUtils.isEmpty(r103.f227911a) == true) goto L13;
        uz4.a r104 = (uz4.a) org.koin.java.a.a(uz4.a.class);
        Document.DocumentIcon r105 = this.f476528b.f227886k1;
        r104.d(r105.f227911a, r105.f227913c, r102, this.f476529c, this.f476516d);
        return;
    L13:
        this.f476529c.setImageResource(r102);
        return;
    L5:
        r101 = ua5.a.i(r100);
        goto L6
    }

    public c(Context r100, Document r101, ImageView r102, boolean r103) {
        super(r100, r101, r102);
        this.f476516d = r103;
    }
}
