package ja6;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f497887a = 0;

    static {
    }

    @JvmStatic
    public static final float a(String r110, String r111, String r112) {
        if (StringsKt.contains$default(r110, "-", false, 2, null) == false) goto L36;
        List r113 = StringsKt.split$default(r110, new String[]{"-"}, false, 0, 6, null);
        ArrayList r100 = new ArrayList();
        Iterator r114 = r113.iterator();
    L6:
        if (r114.hasNext() == false) goto L11;
        Object r101 = r114.next();
        if ((true ^ StringsKt.isBlank((String) r101)) == false) goto L6;
        r100.add(r101);
        goto L6
    L11:
        if (r100.size() != 2) goto L34;
        float r115 = CastFloatProtector.parseFloat((String) ListProtector.get(r100, 0));
        String r116 = (String) ListProtector.get(r100, 1);
        int r117 = r116.hashCode();
        if (r117 == (-1378088671)) goto L28;
        if (r117 == 3633) goto L24;
        if (r117 == 92909918) goto L20;
    L30:
        float r118 = -0.75f;
    L32:
        return r115 + r118;
    L20:
        if (r116.equals("alpha") == false) goto L30;
        r118 = -0.5f;
        goto L32
    L24:
        if (r116.equals("rc") == false) goto L30;
        r118 = -0.25f;
        goto L32
    L28:
        if (r116.equals(DownloadSettingKeys.BUG_FIX) == false) goto L30;
        r118 = 0.25f;
        goto L32
    L34:
        throw new IllegalArgumentException("the version format is illegal,params:" + r111 + ',' + r112);
    L36:
        throw new IllegalArgumentException("params is string but don't  include '-',params:" + r111 + ',' + r112);
    }
}
