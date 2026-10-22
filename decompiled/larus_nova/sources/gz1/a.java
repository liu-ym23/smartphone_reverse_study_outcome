package gz1;

import android.text.TextUtils;
import com.bytedance.android.live.core.resources.e;
import com.bytedance.android.live.core.resources.f;
import com.bytedance.android.live.core.resources.j;
import com.bytedance.android.live.core.resources.k;
import com.bytedance.android.livesdk.gift.model.CardLockInfo;
import com.bytedance.android.livesdk.gift.model.e3;
import com.bytedance.android.livesdk.gift.model.n;
import com.bytedance.android.livesdk.gift.model.p;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes9.dex */
public final class a {
    public static final boolean c(n r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isUnlocked");
        if (r100.getLockInfo() == null) goto L10;
        CardLockInfo r101 = r100.getLockInfo();
        if (r101 != null) goto L7;
    L9:
        return false;
    L7:
        if (r101.getLockStatus() != CardLockInfo.Companion.LockStatus.UNLOCKED.getV()) goto L9;
    L10:
        return true;
    }

    public static final String a(p r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$findCardName");
        if (r101 != null) goto L22;
        return null;
    L22:
        ArrayList<e3> r102 = c.d(new JSONArray(r101));     // Catch: JSONException -> L21
        Iterator<T> r103 = r100.getForceIndexCards().iterator();
    L8:
        if (r103.hasNext() == false) goto L13;
        n r104 = (n) r103.next();
        if (c.h(r102, c.g(r104)) == false) goto L8;
        return r104.getCardName();
    L13:
        Iterator<T> r105 = r100.getCards().iterator();
    L15:
        if (r105.hasNext() == false) goto L20;
        n r106 = (n) r105.next();
        if (c.h(r102, c.g(r106)) == false) goto L15;
        return r106.getCardName();
    L20:
        return null;
    }

    public static final boolean b(e r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$isMd5Matched");
        if (TextUtils.equals(r101, r100.getMD5()) == true) goto L31;
        f r102 = (f) r100.castToOrNull(f.class);
        String r103 = null;
        if (r102 == null) goto L7;
        j r104 = r102.getH265ResourceModel();
    L8:
        if (r104 == null) goto L17;
        f r105 = (f) r100.castToOrNull(f.class);
        if (r105 == null) goto L14;
        j r106 = r105.getH265ResourceModel();
        if (r106 == null) goto L14;
        String r107 = r106.getMd5();
    L16:
        if (TextUtils.equals(r101, r107) == true) goto L31;
    L14:
        r107 = null;
    L17:
        f r108 = (f) r100.castToOrNull(f.class);
        if (r108 == null) goto L20;
        k r109 = r108.getH265SuperResourceModel();
    L21:
        if (r109 == null) goto L30;
        f r110 = (f) r100.castToOrNull(f.class);
        if (r110 == null) goto L28;
        k r111 = r110.getH265SuperResourceModel();
        if (r111 == null) goto L28;
        r103 = r111.getMd5();
    L28:
        if (TextUtils.equals(r101, r103) == true) goto L31;
    L30:
        return false;
    L20:
        r109 = null;
        goto L21
    L7:
        r104 = null;
    L31:
        return true;
    }
}
