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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class c<T extends MenuData> implements i<T> {
    public final Context a;
    public m b;
    public List<MenuItem> c;
    public final Set<MenuItem> d;
    public T e;
    public final y3 f;
    public final e45.f g;
    public final vo5.a h;

    @Override // tb5.i, tb5.o
    public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return BridgeHandlerV2$CC.$default$authType(this);
    }

    public List<MenuItem> a(List<MenuItem> r10) {
        if (r10 != null) goto L6;
        ((HashSet) this.d).clear();
        return null;
    L6:
        Iterator r1 = ((HashSet) this.d).iterator();
    L8:
        if (r1.hasNext() == false) goto L12;
        if (r10.contains((MenuItem) r1.next()) == true) goto L8;
        r1.remove();
        goto L8
    L12:
        int r2 = r10.size() - 1;
    L13:
        if (r2 < 0) goto L62;
        MenuItem r3 = (MenuItem) ListProtector.get(r10, r2);
        if (r3 != null) goto L17;
    L60:
        tt5.a.k("BaseMenuHandler", "invalid menuItem");
        ListProtector.remove(r10, r2);
    L61:
        r2 = r2 - 1;
        goto L13
    L17:
        if (r3.getId() == null) goto L60;
        String r5 = r3.getIconKey();
        if (TextUtils.isEmpty(r5) == false) goto L63;
        String r6 = r3.getId();
        e r7 = d.c(r6);
        if (r7 != null) goto L27;
    L33:
        Drawable r8 = d.b(this.a, r6);
    L34:
        Integer r9 = (Integer) ((HashMap) d.c).get(r3.getId());
        boolean r11 = false;
        if (r9 != null) goto L37;
        int r12 = 0;
    L38:
        int r13 = Integer.valueOf(r12).intValue();
        if (r13 != 0) goto L41;
        String r14 = null;
    L42:
        e r16 = d.c(r3.getId());
        if (r16 == null) goto L49;
        int r17 = r16.c;
        if (r17 == 0) goto L47;
        r11 = true;
    L47:
        if (r11 == false) goto L49;
    L50:
        int r18 = Integer.valueOf(r17).intValue();
        if (r8 != null) goto L55;
        if (r14 != null) goto L55;
        if (r18 != (-1)) goto L55;
        tt5.a.k("BaseMenuHandler", "Found unsupported menu:" + r3);
        ListProtector.remove(r10, r2);
    L55:
        if (r8 == null) goto L57;
        r3.setIcon(r8);
    L57:
        if (r18 == (-1)) goto L59;
        r3.setLottieRawRes(r18);
    L59:
        r3.setClickListener(new a(this));
    L49:
        r17 = -1;
        goto L50
    L41:
        r14 = this.a.getResources().getString(r13);
        goto L42
    L37:
        r12 = r9.intValue();
        goto L38
    L27:
        if (r7.a() == false) goto L33;
        int r19 = r7.b;
        if (r19 != 0) goto L32;
        r8 = AppCompatResources.getDrawable(this.a, r7.a);
        goto L34
    L32:
        r8 = l.a(this.a, r7.a, r19);
        goto L34
    L63:
        r8 = UDIconUtils.getIconDrawable(this.a, n.n(this.a, r5));     // Catch: Exception -> L23
    L23:
        tt5.a.d("BaseMenuHandler", "get icon fail");
        r8 = null;
        goto L34
    L62:
        return r10;
    }

    public void e(List<MenuItem> r7) {
        if (r7 != null) goto L4;
        return;
    L4:
        if (r7.size() > 0) goto L7;
        return;
    L7:
        if (e45.f.b(this.g.a) == false) goto L17;
        tt5.a.h("BaseMenuHandler", "set show more badge");
        Iterator<MenuItem> r0 = r7.iterator();
    L10:
        if (r0.hasNext() == false) goto L17;
        MenuItem r3 = r0.next();
        if ("MORE_OPERATE".equals(r3.getId()) == false) goto L10;
        if (r3.isEnable() == false) goto L10;
        r3.setBadgeStyle(BadgeStyle.point);
        r3.setBadgeNum(1);
    L17:
        if (e45.f.b(this.g.b) == false) goto L40;
        tt5.a.h("BaseMenuHandler", "set show share badge");
        Iterator<MenuItem> r8 = r7.iterator();
    L20:
        if (r8.hasNext() == false) goto L42;
        MenuItem r1 = r8.next();
        if ("SHARE".equals(r1.getId()) == false) goto L20;
        if (r1.isEnable() == false) goto L20;
        r1.setBadgeStyle(BadgeStyle.point);
        r1.setBadgeNum(1);
        return;
    L42:
        return;
    }

    public void c(MenuItem r8, View r9) {
        if ("MORE_OPERATE".equals(r8.getId()) == false) goto L6;
        e45.f.a(this.g.a);
    L6:
        if ("SHARE".equals(r8.getId()) == false) goto L9;
        e45.f.a(this.g.b);
    L9:
        if (((HashSet) this.d).contains(r8) == false) goto L12;
        tt5.a.k("BaseMenuHandler", "Ignore click until menu update:" + r8);
        return;
    L12:
        String r0 = d.a(r8.getId());
        if (TextUtils.isEmpty(r0) == true) goto L22;
        ((HashSet) this.d).add(r8);
        e r1 = d.c(r0);
        if (r1 == null) goto L22;
        if (r1.a() == false) goto L22;
        ObjectAnimator r3 = ObjectAnimator.ofFloat(r9, "scaleX", new float[]{1.0f, 0.0f}).setDuration(200);
        ObjectAnimator r2 = ObjectAnimator.ofFloat(r9, "scaleX", new float[]{0.0f, 1.0f}).setDuration(200);
        r3.setInterpolator(new DecelerateInterpolator());
        r2.setInterpolator(new AccelerateDecelerateInterpolator());
        r3.addListener(new b(this, r9, r1, r2));
        r3.start();
    L22:
        if (this.b == null) goto L25;
        JSONObject r10 = new JSONObject();
        r10.put("id", String.valueOf(r8.getId()));
        tt5.a.h("BaseMenuHandler", "click menu:" + r8);
        this.b.b(r10);
        return;
    }

    public final void d(ImageView r3, e r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (r4.a() == false) goto L13;
        int r0 = r4.b;
        if (r0 != 0) goto L9;
        r3.setImageDrawable(AppCompatResources.getDrawable(this.a, r4.a));
        return;
    L9:
        r3.setImageDrawable(l.a(this.a, r4.a, r0));
        return;
    }

    @Override // tb5.i, tb5.o
    public final void handle(Object r3, m r4) {
        T r5 = (T) r3;
        tt5.a.h("BaseMenuHandler", "update menu:" + r5);
        this.b = r4;
        this.e = r5;
        List<MenuItem> r6 = a(r5.getItems());
        this.c = r6;
        e(r6);
    }

    public c(Context r2, y3 r3, vo5.a r4) {
        this.d = new HashSet();
        this.g = new e45.f();
        this.a = r2;
        this.f = r3;
        this.h = r4;
    }
}
