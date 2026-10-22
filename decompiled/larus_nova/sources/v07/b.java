package v07;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Movie;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes21.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Movie f552313a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Integer> f552314b;

    public final void a() {
        Canvas r100 = new Canvas(Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888));
        ArrayList r101 = new ArrayList();
        int r102 = 0;
        int r103 = 0;
    L4:
        if (r103 >= this.f552313a.duration()) goto L10;
        if (this.f552313a.setTime(r103) == true) goto L8;
        if (r103 == 0) goto L8;
    L9:
        r103 = r103 + 17;
    L8:
        this.f552313a.draw(r100, 0.0f, 0.0f);
        r101.add(Integer.valueOf(r103));
        goto L9
    L10:
        int r104 = r101.size() - 1;
    L11:
        if (r102 >= r104) goto L13;
        List<Integer> r105 = this.f552314b;
        int r106 = r102 + 1;
        ArrayList r107 = (ArrayList) r105;
        r107.add(Integer.valueOf(((Integer) ListProtector.get(r101, r106)).intValue() - ((Integer) ListProtector.get(r101, r102)).intValue()));
        r102 = r106;
        goto L11
    L13:
        List<Integer> r108 = this.f552314b;
        ArrayList r109 = (ArrayList) r108;
        r109.add(Integer.valueOf(this.f552313a.duration() - ((Integer) ListProtector.get(r101, r101.size() - 1)).intValue()));
    }

    public final int b() {
        return ((ArrayList) this.f552314b).size();
    }

    public b(Movie r100) {
        this.f552314b = new ArrayList();
        this.f552313a = r100;
    }

    public final int c(int r100) {
        return ((Integer) ListProtector.get(this.f552314b, r100)).intValue();
    }
}
