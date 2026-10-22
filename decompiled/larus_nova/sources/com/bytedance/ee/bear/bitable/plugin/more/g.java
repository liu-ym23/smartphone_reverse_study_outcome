package com.bytedance.ee.bear.bitable.plugin.more;

import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.larksuite.component.universe_design.menu.PositionAlign;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FragmentActivity f214940a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.ee.bear.bitable.plugin.more.f f214941b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f214942c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.larksuite.component.universe_design.menu.c f214943d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public lk5.a f214944e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, Integer> f214945f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b f214946g;

    public static final class a {
    }

    public interface b {
    }

    public interface c {
    }

    public static final class d implements com.larksuite.component.universe_design.menu.c.InterfaceC3918c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f214947a = null;

        static {
            f214947a = new d();
        }

        public d() {
        }

        @Override // com.larksuite.component.universe_design.menu.c.InterfaceC3918c
        public final void a(PopupWindow r100) {
            Intrinsics.checkNotNullParameter(r100, "popWindow");
            View r101 = r100.getContentView();
            if (r101 != null) goto L6;
            return;
        L6:
            if ((r101 instanceof FrameLayout) == false) goto L9;
            FrameLayout r102 = (FrameLayout) r101;
        L12:
            if (r102 == null) goto L15;
            ((zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6)).p(r102);
            return;
        L15:
            return;
        L9:
            if ((r101.getParent() instanceof FrameLayout) == false) goto L11;
            ViewParent r103 = r101.getParent();
            Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type android.widget.FrameLayout");
            r102 = (FrameLayout) r103;
            goto L12
        L11:
            r102 = null;
            goto L12
        }
    }

    public static final class e implements com.larksuite.component.universe_design.menu.c.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f214948a;

        @Override // com.larksuite.component.universe_design.menu.c.b
        public final void onDismiss() {
            ((com.bytedance.ee.bear.bitable.plugin.more.d) this.f214948a).a();
        }

        public e(b r100) {
            this.f214948a = r100;
        }
    }

    public static final class f implements com.larksuite.component.universe_design.menu.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableMoreItemInfo f214949a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g f214950b;

        @Override // com.larksuite.component.universe_design.menu.g
        public final /* synthetic */ int b() {
            return 0;
        }

        @Override // com.larksuite.component.universe_design.menu.g
        public final /* synthetic */ int c() {
            return R.color.ud_menu_icon_color;
        }

        @Override // com.larksuite.component.universe_design.menu.g
        public final /* synthetic */ void getDescription() {
        }

        @Override // com.larksuite.component.universe_design.menu.g
        public final /* synthetic */ int getTextColor() {
            return 0;
        }

        @Override // com.larksuite.component.universe_design.menu.g
        public final void a() {
            BitableMoreItemInfo r100 = this.f214949a;
            if (r100.enable == false) goto L11;
            c r101 = this.f214950b.f214942c;
            if (r101 == null) goto L7;
            String r102 = r100.f214928id;
            JSONObject r103 = new JSONObject();
            r103.put2("id", r102);
            ((com.bytedance.ee.bear.bitable.plugin.more.c) r101).f214932a.b(r103);
        L7:
            com.larksuite.component.universe_design.menu.c r104 = this.f214950b.f214943d;
            if (r104 == null) goto L12;
            r104.a();
            return;
        L12:
            return;
        }

        @Override // com.larksuite.component.universe_design.menu.g
        public final int getIcon() {
            return this.f214950b.a(this.f214949a.f214928id);
        }

        @Override // com.larksuite.component.universe_design.menu.g
        public final String getName() {
            return this.f214949a.name;
        }

        @Override // com.larksuite.component.universe_design.menu.g
        public final boolean isEnabled() {
            return this.f214949a.enable;
        }

        public f(BitableMoreItemInfo r100, g r101) {
            this.f214949a = r100;
            this.f214950b = r101;
        }
    }

    static {
    }

    public g(FragmentActivity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        this.f214940a = r100;
        int r101 = com.bytedance.ee.bear.bitable.plugin.more.f.f214937c;
        this.f214941b = com.bytedance.ee.bear.bitable.plugin.more.f.a.a(null, null);
        LinkedHashMap r102 = new LinkedHashMap();
        this.f214945f = r102;
        r102.put("MORE_OPERATE", Integer.valueOf(R.drawable.ud_icon_app_outlined));
        if (AppInfoUtils.f().booleanValue() == false) goto L6;
        r102.put("MORE_OPERATE", Integer.valueOf(R.drawable.ud_icon_app_v2_outlined));
        r102.put("SEARCH", Integer.valueOf(R.drawable.ud_icon_search_v2_outlined));
        r102.put(BitableTitleMorePlugin.MENU_ID_BASE_MORE_PRO, Integer.valueOf(R.drawable.ud_icon_file_permission_v2_outlined));
        return;
    }

    public final int a(String r100) {
        Integer r101 = (Integer) ((LinkedHashMap) this.f214945f).get(r100);
        if (r101 != null) goto L5;
        y15.e r102 = y15.d.c(r100);
        if (r102 != null) goto L9;
    L14:
        return R.drawable.ud_icon_bitableunknow_outlined;
    L9:
        if (r102.a() == false) goto L11;
        Integer r103 = Integer.valueOf(r102.f565645a);
    L12:
        if (r103 == null) goto L14;
        return r103.intValue();
    L11:
        r103 = null;
        goto L12
    L5:
        return r101.intValue();
    }

    public final void b(View r100) {
        Intrinsics.checkNotNullParameter(r100, "anchorView");
        com.larksuite.component.universe_design.menu.c r101 = this.f214943d;
        if (r101 == null) goto L5;
        r101.a();
    L5:
        lk5.a r102 = this.f214944e;
        if (r102 == null) goto L9;
        r102.dismiss();
    L9:
        if (AppInfoUtils.f().booleanValue() == false) goto L27;
        lk5.a r103 = this.f214944e;
        if (r103 != null) goto L19;
        lk5.b r104 = lk5.d.f509575a;
        FragmentActivity r105 = this.f214940a;
        Intrinsics.checkNotNullParameter(r105, "activity");
        lk5.b r106 = lk5.d.f509575a;
        if (r106 == null) goto L15;
        r103 = r106.a(r105);
    L16:
        if (r103 == null) goto L18;
        this.f214944e = r103;
        goto L19
    L18:
        lk5.a r107 = null;
    L20:
        if (r107 != null) goto L22;
        tt5.a.d("BitableToolBarMoreMenuPanel", "Office anchored menu renderer is not registered, fallback to UDMenu");
        c(r100);
        return;
    L22:
        List<BitableMoreItemInfo> r108 = this.f214941b.f214938a;
        ArrayList r109 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r108, 10));
        Iterator<T> r110 = r108.iterator();
    L24:
        if (r110.hasNext() == false) goto L26;
        BitableMoreItemInfo r111 = (BitableMoreItemInfo) r110.next();
        String r112 = r111.f214928id;
        r109.add(new lk5.c(r112, r111.name, a(r112), r111.enable));
        goto L24
    L26:
        r107.a(r100, r109, this.f214941b.f214939b, new BitableToolBarMoreMenuPanel$showOfficeMenu$2(this), new BitableToolBarMoreMenuPanel$showOfficeMenu$3(this));
        return;
    L15:
        r103 = null;
    L19:
        r107 = r103;
        goto L20
    L27:
        c(r100);
    }

    public final void c(View r100) {
        List<BitableMoreItemInfo> r101 = this.f214941b.f214938a;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r102.add(new f((BitableMoreItemInfo) r103.next(), this));
        goto L4
    L6:
        com.larksuite.component.universe_design.menu.c.f r104 = new com.larksuite.component.universe_design.menu.c.f();
        r104.c(80);
        r104.b(PositionAlign.END);
        r104.f(new ArrayList(r102));
        int r105 = this.f214941b.f214939b;
        if (r105 < 0) goto L9;
        int[] r106 = {r105};
        Intrinsics.checkNotNullParameter(r106, "positions");
        ((ArrayList) r104.f285098h).clear();
        int r107 = r106[0];
        ((ArrayList) r104.f285098h).add(Integer.valueOf(r107));
    L9:
        com.larksuite.component.universe_design.menu.c r108 = r104.a();
        d r109 = d.f214947a;
        Intrinsics.checkNotNullParameter(r109, "listener");
        r108.f285080f = r109;
        b r110 = this.f214946g;
        if (r110 == null) goto L12;
        e r111 = new e(r110);
        Intrinsics.checkNotNullParameter(r111, "listener");
        r108.f285081g = r111;
    L12:
        Intrinsics.checkNotNullParameter(r100, "anchorView");
        r108.c(r100);
        this.f214943d = r108;
    }
}
