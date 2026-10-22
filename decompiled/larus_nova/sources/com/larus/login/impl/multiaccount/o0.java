package com.larus.login.impl.multiaccount;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.activity.result.ActivityResultCaller;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.wikiv2.home2.model.WikiSpaceType;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import com.larus.account.base.api.AccountSwitchReason;
import com.larus.account.base.api.ILoginService;
import com.larus.account.base.api.IMultiAccountService;
import com.larus.bmhome.bot.CommonSettingFragment;
import com.larus.bmhome.view.RoundAvatarImageView;
import com.larus.nova.R;
import com.larus.platform.api.n4;
import com.larus.utils.e1;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import tx9.g2;

/* JADX INFO: loaded from: classes30.dex */
public final class o0 implements n4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Fragment f358135a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f358136b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FrameLayout f358137c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<q38.b> f358138d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, RoundAvatarImageView> f358139e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Set<String> f358140f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f358141g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f358142h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f358143i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final r0 f358144j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final h0 f358145k;

    public static final class a {
    }

    public static final class b<T> implements Comparator {
        public b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues(Boolean.valueOf(((q38.b) r101).k()), Boolean.valueOf(((q38.b) r100).k()));
        }
    }

    public static final class c<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Comparator f358146a;

        public c(b r100) {
            this.f358146a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            int r102 = this.f358146a.compare(r100, r101);
            if (r102 == 0) goto L6;
            return r102;
        L6:
            return ComparisonsKt.compareValues(Long.valueOf(((q38.b) r101).e()), Long.valueOf(((q38.b) r100).e()));
        }
    }

    static {
    }

    @Override // com.larus.platform.api.n4
    public final void release() {
        if (this.f358141g == false) goto L5;
        return;
    L5:
        this.f358141g = true;
        ILoginService.f286097a.Q(this.f358144j);
        IMultiAccountService.f286100a.b(this.f358145k);
        this.f358135a = null;
        ((LinkedHashMap) this.f358139e).clear();
        this.f358140f.clear();
        this.f358137c.removeAllViews();
    }

    @Override // com.larus.platform.api.n4
    public final View getView() {
        return this.f358137c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.larus.account.base.api.IMultiAccountService$a, com.larus.login.impl.multiaccount.h0] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public o0(CommonSettingFragment r100) {
        Intrinsics.checkNotNullParameter(r100, "hostFragment");
        this.f358135a = r100;
        Context r101 = r100.requireContext();
        this.f358136b = r101;
        FrameLayout r102 = new FrameLayout(r101);
        this.f358137c = r102;
        this.f358138d = CollectionsKt.emptyList();
        this.f358139e = new LinkedHashMap();
        this.f358140f = new LinkedHashSet();
        this.f358142h = LazyKt.lazy(new f0(this));
        this.f358143i = LazyKt.lazy(new g0(this));
        r0 r103 = new r0(this);
        this.f358144j = r103;
        ?? r104 = new h0(this);
        this.f358145k = r104;
        r102.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        ILoginService.a.c(ILoginService.f286097a, r103);
        IMultiAccountService.f286100a.i(r104);
        J(true);
    }

    @Override // com.larus.platform.api.n4
    public final void J(boolean r210) {
        if (this.f358141g == false) goto L5;
        return;
    L5:
        this.f358138d = CollectionsKt.sortedWith(IMultiAccountService.f286100a.g(), new c(new b()));
        this.f358137c.removeAllViews();
        if (this.f358138d.size() > 1) goto L8;
        this.f358140f.clear();
        this.f358137c.setVisibility(8);
    L104:
        if (r210 == false) goto L125;
        IMultiAccountService.f286100a.f(new i0(this));
        return;
    L125:
        return;
    L8:
        this.f358137c.setVisibility(0);
        FrameLayout r100 = this.f358137c;
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        r101.height = b(134);
        r100.setLayoutParams(r101);
        int r102 = this.f358138d.size();
        if (2 <= r102) goto L11;
    L13:
        boolean r103 = false;
    L14:
        if (r103 == false) goto L24;
        FrameLayout r110 = this.f358137c;
        ImageView r111 = new ImageView(this.f358136b);
        r111.setScaleType(ImageView.ScaleType.FIT_CENTER);
        r111.setImageResource(R.drawable.larus_ic_settings_add_account);
        r111.setContentDescription(r111.getContext().getString(R.string.larus_switchAccount_addAcc));
        e1.d(r111, new j0(this));
        if (this.f358138d.size() != 2) goto L18;
        int r104 = 64;
    L19:
        Integer r105 = Integer.valueOf(r104);
        if (this.f358138d.size() != 2) goto L22;
        int r106 = 0;
    L23:
        r110.addView(r111, a(this, 44, r105, null, r106, 4));
        goto L24
    L22:
        r106 = 2;
        goto L23
    L18:
        r104 = 62;
    L24:
        List<q38.b> r107 = this.f358138d;
        ArrayList r108 = new ArrayList();
        Iterator<T> r109 = r107.iterator();
    L26:
        if (r109.hasNext() == false) goto L30;
        Object r112 = r109.next();
        if (((q38.b) r112).k() == true) goto L26;
        r108.add(r112);
        goto L26
    L30:
        List r113 = CollectionsKt.take(r108, 4);
        Iterator<T> r114 = this.f358138d.iterator();
    L32:
        if (r114.hasNext() == false) goto L36;
        Object r115 = r114.next();
        if (((q38.b) r115).k() == false) goto L32;
    L37:
        List r116 = r113;
        List r117 = CollectionsKt.plus(CollectionsKt.listOfNotNull(r115), r116);
        LinkedHashSet r118 = new LinkedHashSet();
        Iterator r119 = r117.iterator();
        int r120 = 0;
    L39:
        if (r119.hasNext() == false) goto L67;
        Object r121 = r119.next();
        int r122 = r120 + 1;
        if (r120 >= 0) goto L43;
        CollectionsKt.throwIndexOverflow();
    L43:
        q38.b r123 = (q38.b) r121;
        String r124 = r123.g();
        if (r124 != null) goto L48;
        r124 = r123.j();
        if (r124 != null) goto L48;
        r124 = "position_" + r120;
    L48:
        r118.add(r124);
        String r125 = r123.j();
        if (r125 == null) goto L66;
        if ((!StringsKt.isBlank(r125)) == true) goto L54;
        r125 = null;
    L54:
        if (r125 == null) goto L66;
        if (this.f358140f.add(r124) == false) goto L66;
        if (r123.l() == false) goto L60;
        String r126 = "enterprise";
    L61:
        String r127 = AccountSwitchReason.SETTING_TOP.getEnterMethod();
        ActivityResultCaller r128 = this.f358135a;
        if ((r128 instanceof by7.e) == false) goto L64;
        by7.e r129 = (by7.e) r128;
    L65:
        g2.b(r126, r125, r127, r129, 8);
        goto L66
    L64:
        r129 = null;
        goto L65
    L60:
        r126 = WikiSpaceType.PERSONAL;
    L66:
        r120 = r122;
        goto L39
    L67:
        LinkedHashSet r130 = new LinkedHashSet();
        Iterator r131 = r116.iterator();
        int r132 = 0;
    L69:
        if (r131.hasNext() == false) goto L103;
        Object r133 = r131.next();
        int r134 = r132 + 1;
        if (r132 >= 0) goto L73;
        CollectionsKt.throwIndexOverflow();
    L73:
        final q38.b r135 = (q38.b) r133;
        String r136 = r135.g();
        if (r136 != null) goto L78;
        r136 = r135.j();
        if (r136 != null) goto L78;
        r136 = "position_" + r132;
    L78:
        r130.add(r136);
        LinkedHashMap r137 = (LinkedHashMap) this.f358139e;
        Object r138 = r137.get(r136);
        Object r139 = r138;
        if (r138 != null) goto L84;
        RoundAvatarImageView r140 = new RoundAvatarImageView(this.f358136b);
        GenericDraweeHierarchy r141 = r140.getHierarchy();
        RoundingParams r142 = r140.getHierarchy().getRoundingParams();
        if (r142 != null) goto L83;
        r142 = RoundingParams.asCircle();
    L83:
        r141.setRoundingParams(r142.setBorder(((Number) this.f358143i.getValue()).intValue(), 1.0f));
        r137.put(r136, r140);
        r139 = r140;
    L84:
        RoundAvatarImageView r143 = (RoundAvatarImageView) r139;
        RoundAvatarImageView.f(r143, r135.b(), "settings.multi_account", false, 12);
        r143.setContentDescription(r135.c());
        e1.d(r143, new k0(this, r135));
        FrameLayout r144 = this.f358137c;
        int r145 = this.f358138d.size();
        if (r132 == 0) goto L94;
        if (r132 != 1) goto L89;
        FrameLayout.LayoutParams r146 = a(this, 60, 22, null, 58, 4);
    L102:
        r144.addView(r143, r146);
        r132 = r134;
        goto L69
    L89:
        if (r132 == 2) goto L91;
        r146 = a(this, 44, 62, null, 4, 4);
        goto L102
    L91:
        r146 = a(this, 44, null, 20, 0, 2);
        goto L102
    L94:
        if (r145 > 3) goto L96;
        int r147 = 36;
    L97:
        Integer r148 = Integer.valueOf(r147);
        if (r145 > 3) goto L100;
        int r149 = 33;
    L101:
        r146 = a(this, 60, null, r148, r149, 2);
        goto L102
    L100:
        r149 = 60;
        goto L101
    L96:
        r147 = 44;
        goto L97
    L103:
        ((LinkedHashMap) this.f358139e).keySet().retainAll(r130);
        this.f358140f.retainAll(r118);
        goto L104
    L36:
        r115 = null;
        goto L37
    L11:
        if (r102 >= 5) goto L13;
        r103 = true;
        goto L14
    }

    public final int b(int r100) {
        return MathKt.roundToInt(r100 * ((Number) this.f358142h.getValue()).floatValue());
    }

    public static FrameLayout.LayoutParams a(o0 r100, int r101, Integer r102, Integer r103, int r104, int r105) {
        if ((r105 & 2) == 0) goto L6;
        r102 = null;
    L6:
        if ((r105 & 4) == 0) goto L8;
        r103 = null;
    L8:
        r100.getClass();
        FrameLayout.LayoutParams r106 = new FrameLayout.LayoutParams(r100.b(r101), r100.b(r101));
        if (r103 == null) goto L11;
        int r107 = GravityCompat.END;
    L12:
        r106.gravity = r107 | 48;
        int r108 = 0;
        if (r102 == null) goto L15;
        int r109 = Integer.valueOf(r100.b(r102.intValue())).intValue();
    L16:
        r106.setMarginStart(r109);
        if (r103 == null) goto L19;
        r108 = Integer.valueOf(r100.b(r103.intValue())).intValue();
    L19:
        r106.setMarginEnd(r108);
        r106.topMargin = r100.b(r104);
        return r106;
    L15:
        r109 = 0;
        goto L16
    L11:
        r107 = GravityCompat.START;
        goto L12
    }
}
