package om7;

import android.text.TextUtils;
import com.bytedance.bpea.entry.common.DataType;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.ug.sdk.luckydog.tokenunion.dataunion.model.DataUnionStrategy;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes22.dex */
public final class b implements nm7.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f524298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CountDownLatch f524299b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ d f524300c;

    public final void a(List<String> r100) {
        um7.e.b("doGetUnionValue() IGetClipboardCallback on Callback();");
        String r101 = this.f524298a;
        um7.e.b("extractUnionValue()");
        if (r100 != null) goto L5;
    L21:
        um7.e.b("extractUnionValue() array is empty return null;");
    L22:
        String r102 = null;
    L23:
        um7.e.b("doGetUnionValue() DataUnionClipboardUtils 获取成功： value = " + r102);
        if (TextUtils.isEmpty(r102) == true) goto L26;
        com.bytedance.ug.sdk.luckydog.tokenunion.dataunion.utils.b.a(this.f524298a, r102, DataType.CLIPBOARD, DataUnionStrategy.UNION_CLIPBOARD);
        this.f524300c.d(this.f524298a, r102);
        this.f524299b.countDown();
    L26:
        this.f524299b.countDown();
        return;
    L5:
        if (r100.size() <= 0) goto L21;
        if (TextUtils.isEmpty(r101) == true) goto L21;
        String r103 = r101.toUpperCase();
        int r104 = r100.size();
    L10:
        r104 = r104 - 1;
        if (r104 < 0) goto L22;
        String r105 = (String) ListProtector.get(r100, r104);
        if (TextUtils.isEmpty(r105) == true) goto L10;
        if (r105.startsWith(r103) == false) goto L10;
        if (r105.endsWith(r103) == false) goto L10;
        String r106 = r105.substring(r103.length(), r105.length() - r103.length());
        um7.e.b("extractUnionValue() res = " + r106);
        if (TextUtils.isEmpty(r106) == true) goto L10;
        r102 = f.a(r106.getBytes());
        goto L23
    }

    public b(d r100, String r101, CountDownLatch r102) {
        this.f524300c = r100;
        this.f524298a = r101;
        this.f524299b = r102;
    }
}
