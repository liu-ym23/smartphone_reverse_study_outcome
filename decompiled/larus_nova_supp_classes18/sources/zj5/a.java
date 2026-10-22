package zj5;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.ee.bear.DocFreshInfo;
import com.bytedance.ee.bear.DocMetaInfo;
import com.bytedance.ee.bear.PageviewResult;
import com.bytedance.ee.bear.common.DisplayName;
import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.facade.common.icon.IconSize;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.lynx.api.CCMLynxCardView;
import com.bytedance.ee.bear.more.PageViewResult;
import com.bytedance.ee.bear.more.pageview2.PageViewModel;
import com.bytedance.ee.bear.more.protocol3.g;
import com.bytedance.ee.bear.more.protocol3.k;
import com.bytedance.ee.bear.templates.TemplateViewModel;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import pj5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a extends g {
    public PageviewResult c;
    public PageViewResult d;
    public Boolean e;
    public boolean f;

    /* JADX INFO: renamed from: zj5.a$a, reason: collision with other inner class name */
    public static final class C0348a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ a a;

        public b(a r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.a.getHost().a();
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ a a;

        public c(a r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            a r0 = this.a;
            r0.d = (PageViewResult) r2;
            r0.j();
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ a a;

        public d(a r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            a r0 = this.a;
            r0.c = (PageviewResult) r2;
            r0.j();
        }
    }

    public static final class e<T> implements Observer {
        public final /* synthetic */ a a;

        public e(a r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            a r0 = this.a;
            r0.e = (Boolean) r2;
            r0.j();
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.more.protocol3.g
    public final k a() {
        oj5.c r1 = c();
        if (r1 != null) goto L5;
        String r8 = "";
    L27:
        oj5.c r2 = c();
        if (r2 == null) goto L30;
        int r9 = r2.getType();
        if (r9 != sbb.e.n.b) goto L44;
        if (kac.a.a() == false) goto L42;
        int r10 = r2.i();
        String r3 = r2.getTitle();
        IconSize r11 = IconSize.SIZE_24;
        if (r10 != sbb.e.l.b) goto L41;
        int r4 = rbb.b.e(com.bytedance.ee.util.io.a.c(r3));
    L33:
        int r12 = r4;
        oj5.c r13 = c();
        oj5.c r5 = c();
        if (r5 == null) goto L63;
        boolean r14 = r5.E();
    L64:
        oj5.c r6 = c();
        if (r6 != null) goto L67;
        String r7 = "";
    L117:
        Context r15 = getHost().getHostFragment().getContext();
        if (r15 == null) goto L122;
        PageViewResult r16 = this.d;
        if (r16 == null) goto L122;
        long r17 = r16.lastModifiedTime;
        if (r17 != 0) goto L126;
        String r18 = "";
    L127:
        String r19 = e(2131889037) + e(2131889040) + r18;
    L128:
        oj5.c r20 = c();
        if (r20 != null) goto L131;
        boolean r110 = false;
    L160:
        b r111 = new b(this);
        boolean r112 = k();
        oj5.c r21 = c();
        if (r21 != null) goto L164;
    L168:
        int r113 = -1;
    L178:
        Context r22 = getHost().getHostFragment().getContext();
        if (r22 == null) goto L186;
        oj5.c r23 = c();
        if (r23 == null) goto L186;
        if ((r23 instanceof oj5.a) == false) goto L186;
        String r114 = r22.getString(m.a(((oj5.a) r23).g.getFreshInfo().getFreshState()));
    L188:
        oj5.c r24 = c();
        if (r24 != null) goto L192;
    L196:
        int r115 = -1;
    L205:
        return new zj5.b(r8, r12, r13, r14, r7, r19, r110, r111, r112, r113, r114, r115);
    L192:
        if ((r24 instanceof oj5.a) == false) goto L196;
        DocMetaInfo r25 = ((oj5.a) r24).g;
        if (r25 == null) goto L196;
        int r26 = r25.getFreshInfo().getFreshState();
        ConcurrentHashMap<String, ArrayList<qj5.b>> r27 = m.a;
        if (r26 == 2) goto L202;
        if (r26 == 3) goto L201;
        int r28 = -1;
    L203:
        r115 = r28;
        goto L205
    L201:
        r28 = 2131102145;
        goto L203
    L202:
        r28 = 2131102420;
    L186:
        r114 = "";
        goto L188
    L164:
        if ((r21 instanceof oj5.a) == false) goto L168;
        DocMetaInfo r29 = ((oj5.a) r21).g;
        if (r29 == null) goto L168;
        int r30 = r29.getFreshInfo().getFreshState();
        ConcurrentHashMap<String, ArrayList<qj5.b>> r31 = m.a;
        if (r30 == 1) goto L176;
        if (r30 == 2) goto L175;
        if (r30 == 3) goto L174;
        int r32 = -1;
    L177:
        r113 = r32;
        goto L178
    L174:
        r32 = 2131256120;
        goto L177
    L175:
        r32 = 2131255223;
        goto L177
    L176:
        r32 = 2131256185;
        goto L177
    L131:
        Boolean r33 = this.e;
        if (r33 != null) goto L134;
        int r34 = com.bytedance.ee.bear.templates.g.a;
        if (r20.getTemplateType() != 2) goto L141;
        boolean r35 = true;
    L143:
        if (r20.getTemplateType() != 1) goto L145;
        boolean r36 = true;
    L147:
        if ((r20 instanceof oj5.a) == true) goto L149;
    L151:
        boolean r116 = false;
    L152:
        if (r116 == true) goto L158;
        if (r35 == true) goto L156;
        if (r36 == false) goto L158;
    L156:
        if (o(r20) == true) goto L158;
    L157:
        boolean r37 = true;
    L159:
        r110 = r37;
    L158:
        r37 = false;
        goto L159
    L149:
        if (((oj5.a) r20).k == false) goto L151;
        r116 = true;
        goto L152
    L145:
        r36 = false;
        goto L147
    L141:
        r35 = false;
        goto L143
    L134:
        if (r33.booleanValue() == false) goto L158;
        if (o(r20) == true) goto L158;
    L126:
        r18 = zu5.a.c(r15, r17 * ((long) CCMLynxCardView.ViewType.BANNER));
    L122:
        r19 = "";
        goto L128
    L67:
        FragmentActivity r117 = getHost().getHostFragment().getActivity();
        if (r117 == null) goto L77;
        if ((r6 instanceof oj5.a) == false) goto L77;
        if (o(r6) == false) goto L77;
        oj5.a r38 = (oj5.a) r6;
        String r39 = ((com.bytedance.ee.bear.k) org.koin.java.a.c(com.bytedance.ee.bear.k.class, null, null, 6)).a(r117, r38.c, r38.getType(), r38.n, ((i0) org.koin.java.a.c(i0.class, null, null, 6)).c());
        if (r39 != null) goto L116;
        r39 = "";
    L116:
        r7 = r39;
    L77:
        if (r6.E() == false) goto L80;
        r39 = e(2131887530);
        goto L116
    L80:
        if (k() == false) goto L83;
        r39 = l();
        goto L116
    L83:
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.docx.mobile.update_time_on_more") == false) goto L100;
        int r118 = r6.getType();
        if (r118 != sbb.e.g.b) goto L87;
    L99:
        r39 = l() + "  " + n() + m();
        goto L116
    L87:
        if (r118 == sbb.e.o.b) goto L99;
        if (r118 != sbb.e.f.b) goto L93;
        r39 = l();
        goto L116
    L93:
        if (r118 == sbb.e.i.b) goto L95;
        r39 = l() + "  " + m();
        goto L116
    L95:
        if (((bn4.a) org.koin.java.a.c(bn4.a.class, null, null, 6)).p(r6.getUrl()) == false) goto L97;
        r39 = l();
        goto L116
    L97:
        r39 = l() + "  " + m();
        goto L116
    L100:
        int r119 = r6.getType();
        if (r119 != sbb.e.g.b) goto L103;
    L115:
        r39 = n() + m() + l();
        goto L116
    L103:
        if (r119 == sbb.e.o.b) goto L115;
        if (r119 != sbb.e.f.b) goto L109;
        r39 = l();
        goto L116
    L109:
        if (r119 == sbb.e.i.b) goto L111;
        r39 = m() + l();
        goto L116
    L111:
        if (((bn4.a) org.koin.java.a.c(bn4.a.class, null, null, 6)).p(r6.getUrl()) == false) goto L113;
        r39 = l();
        goto L116
    L113:
        r39 = m() + l();
        goto L116
    L63:
        r14 = false;
        goto L64
    L41:
        r4 = rbb.b.c(r10, null);
        goto L33
    L42:
        int r40 = r2.i();
        String r41 = r2.getTitle();
        IconSize r120 = IconSize.SIZE_24;
        r4 = ua5.a.k(r40, r41);
        goto L33
    L44:
        if (r9 != sbb.e.l.b) goto L50;
        if (kac.a.a() == false) goto L48;
        r4 = rbb.b.e(r2.b());
        goto L33
    L48:
        String r42 = r2.b();
        IconSize r43 = IconSize.SIZE_24;
        r4 = ua5.a.h(r42);
        goto L33
    L50:
        if (r9 != sbb.e.f.b) goto L57;
        if (r2.E() == true) goto L55;
        FolderVersion.a r121 = FolderVersion.Companion;
        int r122 = r2.C();
        boolean r44 = r2.isShareFolder();
        r121.getClass();
        if (FolderVersion.a.b(r122, r44) == false) goto L57;
    L55:
        r4 = rbb.b.g();
    L57:
        if (kac.a.a() == false) goto L59;
        r4 = rbb.b.c(r9, null);
        goto L33
    L59:
        IconSize r45 = IconSize.SIZE_24;
        r4 = ua5.a.i(r9);
        goto L33
    L30:
        if (kac.a.a() == false) goto L32;
        r4 = rbb.b.c(sbb.e.e.b, null);
        goto L33
    L32:
        int r46 = sbb.e.e.b;
        IconSize r47 = IconSize.SIZE_24;
        r4 = ua5.a.i(r46);
        goto L33
    L5:
        r8 = r1.getTitle();
        if ((r1 instanceof oj5.a) == true) goto L8;
    L13:
        if (r8 != null) goto L15;
    L18:
        boolean r48 = true;
    L19:
        if (r48 == false) goto L21;
    L22:
        rc5.a r49 = (rc5.a) org.koin.java.a.c(rc5.a.class, null, null, 6);
        Context r50 = getHost().getHostFragment().getContext();
        oj5.c r123 = c();
        if (r123 == null) goto L25;
        int r124 = r123.getType();
    L26:
        String r51 = r49.e(r50, r124, r1.getUrl());
        Intrinsics.checkNotNull(r51);
    L12:
        r8 = r51;
        goto L27
    L25:
        r124 = -1;
        goto L26
    L21:
        if (TextUtils.equals(r8, "\n") == false) goto L27;
    L15:
        if (r8.length() == 0) goto L18;
        r48 = false;
        goto L19
    L8:
        if (o(r1) == false) goto L13;
        oj5.a r52 = (oj5.a) r1;
        r51 = ((com.bytedance.ee.bear.k) org.koin.java.a.c(com.bytedance.ee.bear.k.class, null, null, 6)).t(r52.c, r52.n);
        if (r51 != null) goto L12;
        r51 = "";
        goto L12
    }

    @Override // com.bytedance.ee.bear.more.protocol3.g, com.bytedance.ee.bear.more.protocol3.b, com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem, com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public final void create() {
        oj5.a r0 = (oj5.a) d(oj5.a.class);
        if (r0 != null) goto L5;
        return;
    L5:
        FragmentActivity r1 = getHost().getHostFragment().getActivity();
        if (r1 != null) goto L8;
        return;
    L8:
        PageViewModel r2 = (PageViewModel) ViewModelProviders.of(r1).get(PageViewModel.class);
        r2.getPageView(r0.getType(), r0.c);
        r2.getPageViewResult().observe(getHost().getHostFragment(), new c(this));
        if (r0.i() != sbb.e.g.b) goto L11;
    L14:
        boolean r3 = true;
    L15:
        if (r3 == false) goto L17;
        ((com.bytedance.ee.bear.d) org.koin.java.a.c(com.bytedance.ee.bear.d.class, null, null, 6)).c(r1).observe(getHost().getHostFragment(), new d(this));
    L17:
        this.f = com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.more.fresh_content");
        ((TemplateViewModel) ViewModelProviders.of(r1).get(TemplateViewModel.class)).getTemplateTagStatueLiveData().observe(getHost().getHostFragment(), new e(this));
        return;
    L11:
        if (r0.i() == sbb.e.o.b) goto L14;
        r3 = false;
        goto L15
    }

    public final String m() {
        PageViewResult r0 = this.d;
        if (r0 != null) goto L7;
        return "";
    L7:
        return e(2131887807) + r0.pv + "  ";
    }

    public final String n() {
        PageviewResult r0 = this.c;
        if (r0 != null) goto L7;
        return "";
    L7:
        return e(2131887850) + r0.getWordCount() + "  ";
    }

    public final boolean k() {
        oj5.c r0 = c();
        if (r0 != null) goto L6;
        return false;
    L6:
        if ((r0 instanceof oj5.a) == true) goto L8;
        return false;
    L8:
        oj5.a r1 = (oj5.a) r0;
        AccountService.Account r2 = ((h0) org.koin.java.a.c(h0.class, null, null, 6)).G2();
        if (r2 == null) goto L12;
        String r3 = r2.tenantId;
        if (r3 == null) goto L12;
    L13:
        boolean r4 = TextUtils.equals(r3, r1.a());
        DocFreshInfo r5 = r1.g.getFreshInfo();
        if (r5.getFreshState() != 0) goto L16;
    L19:
        boolean r6 = false;
    L21:
        if (r5.getFreshState() != 1) goto L26;
        if (r5.getFeedBackNum() >= r5.getMaxExpiredShowNum()) goto L26;
        return false;
    L26:
        return r6;
    L16:
        if (this.f == false) goto L19;
        if (r4 == false) goto L19;
        r6 = true;
    L12:
        r3 = "";
        goto L13
    }

    public final String l() {
        oj5.c r0 = c();
        if (r0 != null) goto L5;
        return "";
    L5:
        Context r2 = getHost().getHostFragment().getContext();
        if (r2 != null) goto L8;
        return "";
    L8:
        DisplayName r4 = null;
        String r3 = ((i0) org.koin.java.a.c(i0.class, null, null, 6)).a();
        PageViewResult r5 = this.d;
        if (r5 == null) goto L11;
        String r6 = r5.ownerName;
    L12:
        if (r5 == null) goto L14;
        String r7 = r5.ownerEnName;
    L15:
        if (r5 == null) goto L17;
        r4 = r5.displayName;
    L17:
        String r8 = ou5.a.a(r3, r4, r6, r7);
        boolean r9 = true;
        if (r8 != null) goto L20;
    L23:
        boolean r10 = true;
    L24:
        if (r10 == false) goto L26;
        r8 = r0.getOwnerName();
    L26:
        if (r8 != null) goto L28;
    L31:
        if (r9 == false) goto L34;
        return "";
    L34:
        return xo5.a.c(r2, 2131888024, "owner", r8);
    L28:
        if (r8.length() == 0) goto L31;
        r9 = false;
        goto L31
    L20:
        if (r8.length() == 0) goto L23;
        r10 = false;
        goto L24
    L14:
        r7 = null;
        goto L15
    L11:
        r6 = null;
        goto L12
    }

    public a() {
    }

    public static boolean o(oj5.c r3) {
        if ((r3 instanceof oj5.a) == false) goto L6;
        oj5.a r4 = (oj5.a) r3;
        return ((com.bytedance.ee.bear.k) org.koin.java.a.c(com.bytedance.ee.bear.k.class, null, null, 6)).p(r4.c, r4.n, r4.k);
    L6:
        return false;
    }
}
