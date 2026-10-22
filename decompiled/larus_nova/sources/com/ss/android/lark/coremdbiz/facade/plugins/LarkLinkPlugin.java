package com.ss.android.lark.coremdbiz.facade.plugins;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import com.ss.android.lark.coremd.facade.plugins.a1;
import com.ss.android.lark.coremdbiz.facade.bizext.LarkThemeExtend;
import com.ss.android.lark.coremdbiz.facade.bizext.props.LarkLinkExtend;
import com.ss.android.lark.coremdbiz.facade.bizext.theme.LarkLinkThemeData;
import com.ss.android.lark.coremdbiz.facade.link.LinkType;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import v7b.e0;

/* JADX INFO: loaded from: classes35.dex */
public class LarkLinkPlugin extends a1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f420093a = 0;

    public static final class a {
    }

    static {
    }

    public LarkLinkPlugin() {
    }

    @Override // com.ss.android.lark.coremd.facade.plugins.a1, com.ss.android.lark.coremd.base.parse.g
    public final void a(com.ss.android.lark.coremd.impl.parse.l.a r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        r100.a(v7b.n.class, new s(this));
    }

    public final Spannable g(final com.ss.android.lark.coremd.base.parse.r<v7b.n> r100, final v7b.n r110) {
        SpannableStringBuilder r101 = new SpannableStringBuilder();
        String r102 = r110.f553562k;
        com.ss.android.lark.coremdbiz.facade.link.parser.b r103 = ((LarkLinkThemeData) LarkThemeExtend.f419998m.b(new LarkLinkPlugin$prepareLinkSpannable$1$themeData$1(r100))).k();
        LarkLinkExtend.a r104 = LarkLinkExtend.f420024f;
        dab.a r105 = (dab.a) r104.b(new LarkLinkPlugin$prepareLinkSpannable$1$iconInfo$1(r110));
        LinkType r106 = (LinkType) r104.b(new LarkLinkPlugin$prepareLinkSpannable$1$linkType$1(r100));
        if (r105 == null) goto L5;
        CharSequence r107 = r103.b(r100, r105);
    L6:
        if (r107 == null) goto L9;
        int r108 = r101.length();
        r101.append(r107);
        r100.a().c(r101, r108, r101.length());
    L9:
        if (FeatureGatingModule.getFeatureGatingService().isEnable("im.richtext.link.inline_render", false) == true) goto L11;
        r101.append(r102);
    L29:
        if (r107 == null) goto L31;
        r101.append(" ");
    L31:
        Object r109 = r100.f().a(r100, r110);
        if (r109 == null) goto L34;
        r100.a().a(r101, r109, 0, r101.length(), 33);
    L34:
        r100.a().b(r101, r110, 0, r101.length(), 0);
        com.ss.android.lark.coremd.base.parse.w.a.a(r100.a(), r101, r110, 0, r101.length());
        return r101;
    L11:
        if (r102 != null) goto L13;
    L16:
        boolean r111 = true;
    L17:
        if (r111 == false) goto L20;
        r102 = r110.f553561j;
    L20:
        if (r110.f553569e == null) goto L28;
        int r112 = r101.length();
        v7b.s r113 = r110.f553569e;
    L22:
        if (r113 == null) goto L25;
        e(r113, r101, r100);
        r113 = r113.f553572h;
        goto L22
    L25:
        if (r101.length() != r112) goto L27;
        r101.append(r102);
    L27:
        Unit r114 = Unit.INSTANCE;
        goto L29
    L28:
        r101.append(r102);
        goto L29
    L13:
        if (r102.length() == 0) goto L16;
        r111 = false;
        goto L17
    L5:
        r107 = null;
        goto L6
    }

    public final void e(v7b.s r110, SpannableStringBuilder r111, com.ss.android.lark.coremd.base.parse.r<v7b.n> r112) {
        if ((r110 instanceof v7b.b0) == false) goto L6;
        r111.append(((v7b.b0) r110).f553548j);
        return;
    L6:
        if ((r110 instanceof v7b.a0) == false) goto L9;
        f(this, r110, r111, r112, true, false, false, false, 112);
        return;
    L9:
        if ((r110 instanceof v7b.f) == false) goto L12;
        f(this, r110, r111, r112, false, true, false, false, 104);
        return;
    L12:
        if ((r110 instanceof e0) == false) goto L15;
        f(this, r110, r111, r112, false, false, true, false, 88);
        return;
    L15:
        if ((r110 instanceof v7b.z) == false) goto L17;
        f(this, r110, r111, r112, false, false, false, true, 56);
        return;
    L17:
        v7b.s r113 = r110.f553569e;
    L18:
        if (r113 == null) goto L26;
        e(r113, r111, r112);
        r113 = r113.f553572h;
        goto L18
    }

    public static void f(LarkLinkPlugin r100, v7b.s r101, SpannableStringBuilder r102, com.ss.android.lark.coremd.base.parse.r r103, boolean r110, boolean r111, boolean r112, boolean r113, int r114) {
        if ((r114 & 8) == 0) goto L6;
        r110 = false;
    L6:
        if ((r114 & 16) == 0) goto L9;
        r111 = false;
    L9:
        if ((r114 & 32) == 0) goto L12;
        r112 = false;
    L12:
        if ((r114 & 64) == 0) goto L14;
        r113 = false;
    L14:
        r100.getClass();
        int r104 = r102.length();
        v7b.s r105 = r101.f553569e;
    L15:
        if (r105 == null) goto L17;
        r100.e(r105, r102, r103);
        r105 = r105.f553572h;
        goto L15
    L17:
        int r106 = r102.length();
        if (com.ss.android.lark.coremd.base.parse.k.f419543b.h(r103.getTheme()) == false) goto L24;
        if (r106 <= r104) goto L25;
        x9b.h r107 = new x9b.h();
        r107.f563010a = r110;
        r107.f563011b = r111;
        r107.f563012c = r112;
        r107.f563013d = r113;
        r103.a().a(r102, r107, r104, r106, 33);
        return;
    L25:
        return;
    }
}
