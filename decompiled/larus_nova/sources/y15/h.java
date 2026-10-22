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

/* JADX INFO: loaded from: classes16.dex */
public abstract class h<T extends MenuData> implements i<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f565653a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public m f565654b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<MenuItem> f565655c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set<MenuItem> f565656d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final e45.e f565657e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final vo5.a f565658f;

    @Override // tb5.i, tb5.o
    public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return BridgeHandlerV2$CC.$default$authType(this);
    }

    public h(Context r100, vo5.a r101) {
        this.f565656d = new HashSet();
        this.f565657e = new e45.e();
        this.f565653a = r100;
        this.f565658f = r101;
    }

    public final void a(ImageView r100, e r101) {
        if (r101.a() == true) goto L5;
        return;
    L5:
        int r102 = r101.f565646b;
        if (r102 != 0) goto L8;
        r100.setImageDrawable(AppCompatResources.getDrawable(this.f565653a, r101.f565645a));
        return;
    L8:
        r100.setImageDrawable(l.a(this.f565653a, r101.f565645a, r102));
    }

    @Override // tb5.i, tb5.o
    public final void handle(Object r110, m r111) {
        MenuData r112 = (MenuData) r110;
        tt5.a.h("BaseMenuHandler", "update menu:" + r112);
        this.f565654b = r111;
        List<MenuItem> r113 = r112.getItems();
        if (r113 != null) goto L5;
        ((HashSet) this.f565656d).clear();
        r113 = null;
    L58:
        this.f565655c = r113;
        OfficeTitleMenuPlugin.a r114 = (OfficeTitleMenuPlugin.a) this;
        if (r113 != null) goto L61;
    L71:
        y3 r100 = ((e4) r114.f220250g.getHostAbility(e4.class)).getDocumentMetadata();
        if (r100.allowCustomTitleMenu() == true) goto L74;
    L77:
        tt5.a.h("TitleMenuPlugin", "Custom title menu disabled");
        return;
    L74:
        if (r100.isAnnounceTemplatePreview() == true) goto L77;
        r114.f220250g.setMenus(r113);
        OfficeTitleMenuPlugin.access$000(r114.f220250g, r113);
        return;
    L61:
        if (r113.size() <= 0) goto L71;
        Iterator<e45.a> r101 = r114.f565657e.f470980a.iterator();
    L65:
        if (r101.hasNext() == false) goto L67;
        r101.next().a();
        goto L65
    L67:
        Iterator<e45.a> r102 = r114.f565657e.f470981b.iterator();
    L69:
        if (r102.hasNext() == false) goto L71;
        r102.next().a();
        goto L69
    L5:
        Iterator r103 = ((HashSet) this.f565656d).iterator();
    L7:
        if (r103.hasNext() == false) goto L11;
        if (r113.contains((MenuItem) r103.next()) == true) goto L7;
        r103.remove();
        goto L7
    L11:
        int r104 = r113.size() - 1;
    L12:
        if (r104 < 0) goto L58;
        MenuItem r105 = (MenuItem) ListProtector.get(r113, r104);
        if (r105 != null) goto L16;
    L56:
        tt5.a.k("BaseMenuHandler", "invalid menuItem");
        ListProtector.remove(r113, r104);
    L57:
        r104 = r104 - 1;
        goto L12
    L16:
        if (r105.getId() == null) goto L56;
        e r106 = d.c(r105.getId());
        String r107 = r105.getIconKey();
        if (TextUtils.isEmpty(r107) == false) goto L79;
        String r108 = r105.getId();
        if (r106 != null) goto L26;
    L32:
        Drawable r109 = d.b(this.f565653a, r108);
    L33:
        Integer r115 = (Integer) ((HashMap) d.f565644c).get(r105.getId());
        boolean r116 = false;
        if (r115 != null) goto L36;
        int r117 = 0;
    L37:
        int r118 = Integer.valueOf(r117).intValue();
        if (r118 != 0) goto L40;
        String r119 = null;
    L41:
        if (r106 == null) goto L46;
        int r120 = r106.f565647c;
        if (r120 == 0) goto L45;
        r116 = true;
    L45:
        if (r116 == false) goto L46;
    L47:
        if (r109 != null) goto L51;
        if (r119 != null) goto L51;
        if (r120 != (-1)) goto L51;
        tt5.a.k("BaseMenuHandler", "Found unsupported menu:" + r105);
        ListProtector.remove(r113, r104);
    L51:
        if (r109 == null) goto L53;
        r105.setIcon(r109);
    L53:
        if (r120 == (-1)) goto L55;
        r105.setLottieRawRes(r120);
    L55:
        r105.setClickListener(new f(this));
    L46:
        r120 = -1;
        goto L47
    L40:
        r119 = this.f565653a.getResources().getString(r118);
        goto L41
    L36:
        r117 = r115.intValue();
        goto L37
    L26:
        if (r106.a() == false) goto L32;
        int r121 = r106.f565646b;
        if (r121 != 0) goto L31;
        r109 = AppCompatResources.getDrawable(this.f565653a, r106.f565645a);
        goto L33
    L31:
        r109 = l.a(this.f565653a, r106.f565645a, r121);
        goto L33
    L79:
        r109 = UDIconUtils.getIconDrawable(this.f565653a, n.n(this.f565653a, r107));     // Catch: Exception -> L22
    L22:
        tt5.a.d("BaseMenuHandler", "get icon fail");
        r109 = null;
        goto L33
    }
}
