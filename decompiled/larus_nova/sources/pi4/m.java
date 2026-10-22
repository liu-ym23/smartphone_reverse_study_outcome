package pi4;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.core.content.ContentResolverCompat;
import androidx.core.os.CancellationSignal;
import com.bytedance.ee.bear.sheet.filter.FilterData;
import ki4.d0;
import ki4.h0;
import ki4.j0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class m {
    public static final Bundle a(h0 r100, d0 r101) {
        Bundle r102 = new Bundle();
        j0 r103 = r100.f503630c;
        String r104 = null;
        if (r103 != null) goto L5;
        String r105 = null;
    L9:
        j0 r106 = r100.f503630c;
        if (r106 == null) goto L12;
        String[] r107 = r106.a();
    L13:
        String r108 = r100.b(r101);
        Intrinsics.checkNotNullParameter(r101, FilterData.FilterOptionItem.Type.RANGE);
        int r109 = r101.f503622b;
        int r110 = r101.f503621a;
        if (Build.VERSION.SDK_INT < 30) goto L16;
        boolean r111 = true;
    L17:
        if (r111 == false) goto L26;
        if (r109 > 0) goto L21;
        if (r110 <= 0) goto L26;
    L21:
        StringBuilder r112 = new StringBuilder();
        if (r109 >= 0) goto L25;
        r109 = -1;
    L25:
        r112.append(r109);
        r112.append(" OFFSET ");
        r112.append(r110);
        r104 = r112.toString();
    L26:
        if (r105 == null) goto L28;
        r102.putString("android:query-arg-sql-selection", r105);
    L28:
        if (r108 == null) goto L30;
        r102.putString("android:query-arg-sql-sort-order", r108);
    L30:
        if (r104 == null) goto L32;
        r102.putString("android:query-arg-sql-limit", r104);
    L32:
        if (r107 == null) goto L34;
        r102.putStringArray("android:query-arg-sql-selection-args", r107);
    L34:
        return r102;
    L16:
        r111 = false;
        goto L17
    L12:
        r107 = null;
        goto L13
    L5:
        if (r103.f503632a == false) goto L7;
        r105 = "NOT " + r103.b();
        goto L9
    L7:
        r105 = r103.b();
        goto L9
    }

    public static final /* synthetic */ Cursor b(Context r100, Uri r101, String[] r102, String r103, String[] r104, String r105, CancellationSignal r106) {
        return query(r100, r101, r102, r103, r104, r105, r106);
    }

    private static final Cursor query(Context r100, Uri r101, String[] r102, String r110, String[] r111, String r112, CancellationSignal r113) {
        return ContentResolverCompat.query(r100.getContentResolver(), r101, r102, r110, r111, r112, r113);
    }
}
