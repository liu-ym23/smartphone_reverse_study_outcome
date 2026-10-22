package y15;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import androidx.appcompat.content.res.AppCompatResources;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.ee.bear.browser.plugin.MenuItem;
import com.bytedance.ee.bear.document.menu.MenuData;
import com.bytedance.ee.bear.document.y3;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.bear.widgets.BadgeStyle;
import com.bytedance.ee.util.ui.l;
import com.bytedance.ee.util.ui.n;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: classes16.dex */
public abstract class c<T extends MenuData> implements i<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f565634a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public m f565635b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<MenuItem> f565636c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set<MenuItem> f565637d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public T f565638e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final y3 f565639f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final e45.f f565640g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final vo5.a f565641h;

    @Override // tb5.i, tb5.o
    public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return BridgeHandlerV2$CC.$default$authType(this);
    }

    public List<MenuItem> a(List<MenuItem> r110) {
        if (r110 != null) goto L6;
        ((HashSet) this.f565637d).clear();
        return null;
    L6:
        Iterator r100 = ((HashSet) this.f565637d).iterator();
    L8:
        if (r100.hasNext() == false) goto L12;
        if (r110.contains((MenuItem) r100.next()) == true) goto L8;
        r100.remove();
        goto L8
    L12:
        int r101 = r110.size() - 1;
    L13:
        if (r101 < 0) goto L62;
        MenuItem r102 = (MenuItem) ListProtector.get(r110, r101);
        if (r102 != null) goto L17;
    L60:
        tt5.a.k("BaseMenuHandler", "invalid menuItem");
        ListProtector.remove(r110, r101);
    L61:
        r101 = r101 - 1;
        goto L13
    L17:
        if (r102.getId() == null) goto L60;
        String r103 = r102.getIconKey();
        if (TextUtils.isEmpty(r103) == false) goto L63;
        String r104 = r102.getId();
        e r105 = d.c(r104);
        if (r105 != null) goto L27;
    L33:
        Drawable r106 = d.b(this.f565634a, r104);
    L34:
        Integer r107 = (Integer) ((HashMap) d.f565644c).get(r102.getId());
        boolean r108 = false;
        if (r107 != null) goto L37;
        int r109 = 0;
    L38:
        int r111 = Integer.valueOf(r109).intValue();
        if (r111 != 0) goto L41;
        String r112 = null;
    L42:
        e r113 = d.c(r102.getId());
        if (r113 == null) goto L49;
        int r114 = r113.f565647c;
        if (r114 == 0) goto L47;
        r108 = true;
    L47:
        if (r108 == false) goto L49;
    L50:
        int r115 = Integer.valueOf(r114).intValue();
        if (r106 != null) goto L55;
        if (r112 != null) goto L55;
        if (r115 != (-1)) goto L55;
        tt5.a.k("BaseMenuHandler", "Found unsupported menu:" + r102);
        ListProtector.remove(r110, r101);
    L55:
        if (r106 == null) goto L57;
        r102.setIcon(r106);
    L57:
        if (r115 == (-1)) goto L59;
        r102.setLottieRawRes(r115);
    L59:
        r102.setClickListener(new a(this));
    L49:
        r114 = -1;
        goto L50
    L41:
        r112 = this.f565634a.getResources().getString(r111);
        goto L42
    L37:
        r109 = r107.intValue();
        goto L38
    L27:
        if (r105.a() == false) goto L33;
        int r116 = r105.f565646b;
        if (r116 != 0) goto L32;
        r106 = AppCompatResources.getDrawable(this.f565634a, r105.f565645a);
        goto L34
    L32:
        r106 = l.a(this.f565634a, r105.f565645a, r116);
        goto L34
    L63:
        r106 = UDIconUtils.getIconDrawable(this.f565634a, n.n(this.f565634a, r103));     // Catch: Exception -> L23
    L23:
        tt5.a.d("BaseMenuHandler", "get icon fail");
        r106 = null;
        goto L34
    L62:
        return r110;
    }

    public void e(List<MenuItem> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.size() > 0) goto L7;
        return;
    L7:
        if (e45.f.b(this.f565640g.f470983a) == false) goto L17;
        tt5.a.h("BaseMenuHandler", "set show more badge");
        Iterator<MenuItem> r101 = r100.iterator();
    L10:
        if (r101.hasNext() == false) goto L17;
        MenuItem r102 = r101.next();
        if ("MORE_OPERATE".equals(r102.getId()) == false) goto L10;
        if (r102.isEnable() == false) goto L10;
        r102.setBadgeStyle(BadgeStyle.point);
        r102.setBadgeNum(1);
    L17:
        if (e45.f.b(this.f565640g.f470984b) == false) goto L40;
        tt5.a.h("BaseMenuHandler", "set show share badge");
        Iterator<MenuItem> r103 = r100.iterator();
    L20:
        if (r103.hasNext() == false) goto L42;
        MenuItem r104 = r103.next();
        if ("SHARE".equals(r104.getId()) == false) goto L20;
        if (r104.isEnable() == false) goto L20;
        r104.setBadgeStyle(BadgeStyle.point);
        r104.setBadgeNum(1);
        return;
    L42:
        return;
    }

    public void c(MenuItem r100, View r101) {
        if ("MORE_OPERATE".equals(r100.getId()) == false) goto L6;
        e45.f.a(this.f565640g.f470983a);
    L6:
        if ("SHARE".equals(r100.getId()) == false) goto L9;
        e45.f.a(this.f565640g.f470984b);
    L9:
        if (((HashSet) this.f565637d).contains(r100) == false) goto L12;
        tt5.a.k("BaseMenuHandler", "Ignore click until menu update:" + r100);
        return;
    L12:
        String r102 = d.a(r100.getId());
        if (TextUtils.isEmpty(r102) == true) goto L22;
        ((HashSet) this.f565637d).add(r100);
        e r103 = d.c(r102);
        if (r103 == null) goto L22;
        if (r103.a() == false) goto L22;
        ObjectAnimator r104 = ObjectAnimator.ofFloat(r101, LiveDegradeFpsAnimator.SCALE_X, new float[]{1.0f, 0.0f}).setDuration(200);
        ObjectAnimator r105 = ObjectAnimator.ofFloat(r101, LiveDegradeFpsAnimator.SCALE_X, new float[]{0.0f, 1.0f}).setDuration(200);
        r104.setInterpolator(new DecelerateInterpolator());
        r105.setInterpolator(new AccelerateDecelerateInterpolator());
        r104.addListener(new b(this, r101, r103, r105));
        r104.start();
    L22:
        if (this.f565635b == null) goto L25;
        JSONObject r106 = new JSONObject();
        r106.put2("id", String.valueOf(r100.getId()));
        tt5.a.h("BaseMenuHandler", "click menu:" + r100);
        this.f565635b.b(r106);
        return;
    }

    public final void d(ImageView r100, e r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (r101.a() == false) goto L13;
        int r102 = r101.f565646b;
        if (r102 != 0) goto L9;
        r100.setImageDrawable(AppCompatResources.getDrawable(this.f565634a, r101.f565645a));
        return;
    L9:
        r100.setImageDrawable(l.a(this.f565634a, r101.f565645a, r102));
        return;
    }

    @Override // tb5.i, tb5.o
    public final void handle(Object r100, m r101) {
        T r102 = (T) r100;
        tt5.a.h("BaseMenuHandler", "update menu:" + r102);
        this.f565635b = r101;
        this.f565638e = r102;
        List<MenuItem> r103 = a(r102.getItems());
        this.f565636c = r103;
        e(r103);
    }

    public c(Context r100, y3 r101, vo5.a r102) {
        this.f565637d = new HashSet();
        this.f565640g = new e45.f();
        this.f565634a = r100;
        this.f565639f = r101;
        this.f565641h = r102;
    }
}
