package y15;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.appcompat.content.res.AppCompatResources;
import com.bytedance.ee.bear.browser.plugin.MenuItem;
import com.bytedance.ee.bear.document.e4;
import com.bytedance.ee.bear.document.menu.MenuData;
import com.bytedance.ee.bear.document.menu.OfficeTitleMenuPlugin;
import com.bytedance.ee.bear.document.y3;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
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
public abstract class h<T extends MenuData> implements i<T> {
    public final Context a;
    public m b;
    public List<MenuItem> c;
    public final Set<MenuItem> d;
    public final e45.e e;
    public final vo5.a f;

    @Override // tb5.i, tb5.o
    public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return BridgeHandlerV2$CC.$default$authType(this);
    }

    public h(Context r2, vo5.a r3) {
        this.d = new HashSet();
        this.e = new e45.e();
        this.a = r2;
        this.f = r3;
    }

    public final void a(ImageView r3, e r4) {
        if (r4.a() == true) goto L5;
        return;
    L5:
        int r0 = r4.b;
        if (r0 != 0) goto L8;
        r3.setImageDrawable(AppCompatResources.getDrawable(this.a, r4.a));
        return;
    L8:
        r3.setImageDrawable(l.a(this.a, r4.a, r0));
    }

    @Override // tb5.i, tb5.o
    public final void handle(Object r10, m r11) {
        MenuData r12 = (MenuData) r10;
        tt5.a.h("BaseMenuHandler", "update menu:" + r12);
        this.b = r11;
        List<MenuItem> r13 = r12.getItems();
        if (r13 != null) goto L5;
        ((HashSet) this.d).clear();
        r13 = null;
    L58:
        this.c = r13;
        OfficeTitleMenuPlugin.a r14 = (OfficeTitleMenuPlugin.a) this;
        if (r13 != null) goto L61;
    L71:
        y3 r0 = ((e4) r14.g.getHostAbility(e4.class)).getDocumentMetadata();
        if (r0.allowCustomTitleMenu() == true) goto L74;
    L77:
        tt5.a.h("TitleMenuPlugin", "Custom title menu disabled");
        return;
    L74:
        if (r0.isAnnounceTemplatePreview() == true) goto L77;
        r14.g.setMenus(r13);
        OfficeTitleMenuPlugin.access$000(r14.g, r13);
        return;
    L61:
        if (r13.size() <= 0) goto L71;
        Iterator<e45.a> r1 = r14.e.a.iterator();
    L65:
        if (r1.hasNext() == false) goto L67;
        r1.next().a();
        goto L65
    L67:
        Iterator<e45.a> r2 = r14.e.b.iterator();
    L69:
        if (r2.hasNext() == false) goto L71;
        r2.next().a();
        goto L69
    L5:
        Iterator r3 = ((HashSet) this.d).iterator();
    L7:
        if (r3.hasNext() == false) goto L11;
        if (r13.contains((MenuItem) r3.next()) == true) goto L7;
        r3.remove();
        goto L7
    L11:
        int r4 = r13.size() - 1;
    L12:
        if (r4 < 0) goto L58;
        MenuItem r5 = (MenuItem) ListProtector.get(r13, r4);
        if (r5 != null) goto L16;
    L56:
        tt5.a.k("BaseMenuHandler", "invalid menuItem");
        ListProtector.remove(r13, r4);
    L57:
        r4 = r4 - 1;
        goto L12
    L16:
        if (r5.getId() == null) goto L56;
        e r6 = d.c(r5.getId());
        String r7 = r5.getIconKey();
        if (TextUtils.isEmpty(r7) == false) goto L79;
        String r8 = r5.getId();
        if (r6 != null) goto L26;
    L32:
        Drawable r9 = d.b(this.a, r8);
    L33:
        Integer r16 = (Integer) ((HashMap) d.c).get(r5.getId());
        boolean r17 = false;
        if (r16 != null) goto L36;
        int r18 = 0;
    L37:
        int r19 = Integer.valueOf(r18).intValue();
        if (r19 != 0) goto L40;
        String r20 = null;
    L41:
        if (r6 == null) goto L46;
        int r21 = r6.c;
        if (r21 == 0) goto L45;
        r17 = true;
    L45:
        if (r17 == false) goto L46;
    L47:
        if (r9 != null) goto L51;
        if (r20 != null) goto L51;
        if (r21 != (-1)) goto L51;
        tt5.a.k("BaseMenuHandler", "Found unsupported menu:" + r5);
        ListProtector.remove(r13, r4);
    L51:
        if (r9 == null) goto L53;
        r5.setIcon(r9);
    L53:
        if (r21 == (-1)) goto L55;
        r5.setLottieRawRes(r21);
    L55:
        r5.setClickListener(new f(this));
    L46:
        r21 = -1;
        goto L47
    L40:
        r20 = this.a.getResources().getString(r19);
        goto L41
    L36:
        r18 = r16.intValue();
        goto L37
    L26:
        if (r6.a() == false) goto L32;
        int r22 = r6.b;
        if (r22 != 0) goto L31;
        r9 = AppCompatResources.getDrawable(this.a, r6.a);
        goto L33
    L31:
        r9 = l.a(this.a, r6.a, r22);
        goto L33
    L79:
        r9 = UDIconUtils.getIconDrawable(this.a, n.n(this.a, r7));     // Catch: Exception -> L22
    L22:
        tt5.a.d("BaseMenuHandler", "get icon fail");
        r9 = null;
        goto L33
    }
}
