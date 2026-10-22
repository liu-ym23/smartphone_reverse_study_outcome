package r90;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.bytedance.android.livehostapi.business.model.emoji.BaseEmoji;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class d implements c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Integer[] f536682d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, Integer> f536683a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String[] f536684b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<String> f536685c;

    public static final class a {
    }

    static {
        f536682d = new Integer[]{Integer.valueOf(R.drawable.im_e1), Integer.valueOf(R.drawable.im_e2), Integer.valueOf(R.drawable.im_e3), Integer.valueOf(R.drawable.im_e4), Integer.valueOf(R.drawable.im_e5), Integer.valueOf(R.drawable.im_e6), Integer.valueOf(R.drawable.im_e7), Integer.valueOf(R.drawable.im_e8), Integer.valueOf(R.drawable.im_e9), Integer.valueOf(R.drawable.im_e10), Integer.valueOf(R.drawable.im_e11), Integer.valueOf(R.drawable.im_e12), Integer.valueOf(R.drawable.im_e13), Integer.valueOf(R.drawable.im_e14), Integer.valueOf(R.drawable.im_e15), Integer.valueOf(R.drawable.im_e16), Integer.valueOf(R.drawable.im_e17), Integer.valueOf(R.drawable.im_e18), Integer.valueOf(R.drawable.im_e19), Integer.valueOf(R.drawable.im_e20), Integer.valueOf(R.drawable.im_e21), Integer.valueOf(R.drawable.im_e22), Integer.valueOf(R.drawable.im_e23), Integer.valueOf(R.drawable.im_e24), Integer.valueOf(R.drawable.im_e25), Integer.valueOf(R.drawable.im_e26), Integer.valueOf(R.drawable.im_e27), Integer.valueOf(R.drawable.im_e28), Integer.valueOf(R.drawable.im_e29), Integer.valueOf(R.drawable.im_e30)};
    }

    public final void e() {
        String[] r100 = this.f536684b;
        if (r100 != null) goto L5;
    L11:
        boolean r101 = true;
    L12:
        if (r101 == false) goto L14;
        return;
    L14:
        if (this.f536683a != null) goto L46;
        this.f536685c = new ArrayList();
        String[] r102 = this.f536684b;
        Intrinsics.checkNotNull(r102);
        this.f536683a = new HashMap(r102.length);
        String[] r103 = this.f536684b;
        Intrinsics.checkNotNull(r103);
        int r104 = r103.length;
        int r105 = 0;
    L16:
        if (r105 >= r104) goto L47;
        String r106 = r103[r105];
        if (TextUtils.isEmpty(r106) == true) goto L38;
        int r107 = b.f536681a;
        if (TextUtils.isEmpty(r106) == false) goto L23;
        String[] r108 = null;
    L24:
        if (r108 == null) goto L38;
        if (r108.length < 2) goto L38;
        int r109 = CastIntegerProtector.parseInt(r108[0]);
        Map<String, Integer> r110 = this.f536683a;
        Intrinsics.checkNotNull(r110);
        String r111 = r108[1];
        int r112 = r109 - 1;
        if (r112 >= 0) goto L31;
    L33:
        int r113 = 0;
    L34:
        ((HashMap) r110).put(r111, Integer.valueOf(r113));
        List<String> r114 = this.f536685c;
        Intrinsics.checkNotNull(r114);
        if (((ArrayList) r114).size() != r109) goto L37;
        List<String> r115 = this.f536685c;
        Intrinsics.checkNotNull(r115);
        ListProtector.set(r115, r112, r108[1]);
        goto L38
    L37:
        List<String> r116 = this.f536685c;
        Intrinsics.checkNotNull(r116);
        ((ArrayList) r116).add(r108[1]);
        goto L38
    L31:
        if (r112 >= 30) goto L33;
        r113 = f536682d[r112].intValue();
        goto L34
    L23:
        r108 = r106.split("\\|", 2);
    L38:
        r105 = r105 + 1;
        goto L16
    L47:
        return;
    L46:
        return;
    L5:
        if (r100.length != 0) goto L7;
        boolean r117 = true;
    L8:
        if (r117 == true) goto L11;
        r101 = false;
        goto L12
    L7:
        r117 = false;
        goto L8
    }

    @Override // r90.c
    public final int c() {
        e();
        List<String> r100 = this.f536685c;
        Intrinsics.checkNotNull(r100);
        return ((ArrayList) r100).size();
    }

    public d(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        String[] r101 = this.f536684b;
        boolean r102 = true;
        if (r101 != null) goto L5;
    L11:
        if (r102 == false) goto L14;
        this.f536684b = r100.getResources().getStringArray(R.array.im_emoji_index_name);
        return;
    L14:
        return;
    L5:
        if (r101.length != 0) goto L7;
        boolean r103 = true;
    L8:
        if (r103 == true) goto L11;
        r102 = false;
        goto L11
    L7:
        r103 = false;
        goto L8
    }

    @Override // r90.c
    public final List b(List r100) {
        if (r100 == null) goto L4;
        e();
        ArrayList r101 = new ArrayList();
        Iterator r102 = r100.iterator();
    L7:
        if (r102.hasNext() == false) goto L12;
        String r103 = (String) r102.next();
        if (f(r103) <= 0) goto L7;
        r101.add(r103);
        goto L7
    L12:
        if (r101.size() >= 8) goto L21;
        List<String> r104 = this.f536685c;
        Intrinsics.checkNotNull(r104);
        Iterator r105 = ((ArrayList) r104).iterator();
    L15:
        if (r105.hasNext() == false) goto L21;
        String r106 = (String) r105.next();
        if (r101.contains(r106) == true) goto L20;
        r101.add(r106);
    L20:
        if (r101.size() < 8) goto L15;
    L21:
        ArrayList r107 = new ArrayList();
        Iterator r108 = r101.iterator();
    L23:
        if (r108.hasNext() == false) goto L25;
        String r109 = (String) r108.next();
        BaseEmoji r110 = new BaseEmoji();
        r110.setDescription(r109);
        r110.setIconId(f(r109));
        r107.add(r110);
        goto L23
    L25:
        return r107;
    L4:
        return new ArrayList();
    }

    @Override // r90.c
    public final List d(int r100) {
        ArrayList r101 = new ArrayList();
        int r102 = r100 + 0;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L17;
        BaseEmoji r104 = new BaseEmoji();
        e();
        List<String> r105 = this.f536685c;
        if (r105 != null) goto L7;
    L9:
        String r106 = "";
    L10:
        r104.setDescription(r106);
        if (r103 >= 0) goto L13;
    L15:
        int r107 = 0;
    L16:
        r104.setIconId(r107);
        r101.add(r104);
        r103 = r103 + 1;
        goto L3
    L13:
        if (r103 >= 30) goto L15;
        r107 = f536682d[r103].intValue();
        goto L16
    L7:
        if (r103 >= ((ArrayList) r105).size()) goto L9;
        r106 = (String) ListProtector.get(r105, r103);
        goto L10
    L17:
        return r101;
    }

    public final int f(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return 0;
    L5:
        e();
        Map<String, Integer> r101 = this.f536683a;
        Intrinsics.checkNotNull(r101);
        Integer r102 = (Integer) ((HashMap) r101).get(r100);
        if (r102 != null) goto L8;
        return 0;
    L8:
        return r102.intValue();
    }

    @Override // r90.c
    public final Drawable a(Context r100, String r101) {
        if (r100 == null) goto L14;
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L16;
        int r103 = f(r101);
        if (r103 > 0) goto L13;
        return null;
    L13:
        return r100.getResources().getDrawable(r103);
    L16:
        return null;
    L5:
        if (r101.length() == 0) goto L8;
        r102 = false;
        goto L9
    L14:
        return null;
    }
}
