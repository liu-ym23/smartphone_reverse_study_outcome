package jg5;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.bear.bizwidget.shareview.ShareItemModel;
import com.bytedance.ee.bear.bizwidget.shareview.ShareItemUtil;
import com.bytedance.ee.bear.bizwidget.shareview.ShareState;
import com.bytedance.ee.bear.bizwidget.shareview.ShareType;
import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.share.info.ShareFolderInfo;
import com.bytedance.ee.bear.mindnote.toolbar.MindNoteTitleMenuConfigPlugin;
import com.bytedance.ee.bear.share.externalshare.ShareScene;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.bytedance.supervisor.token.Token;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileAuthResultFrom;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import com.ss.android.lark.utils.LarkContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c implements com.bytedance.ee.bear.share.export.o {

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ShareScene.values().length];
            r0[ShareScene.DOCUMENT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[ShareScene.EXPORT_IMAGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[ShareScene.SHARE_TEXT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    static {
    }

    public c() {
    }

    @Override // com.bytedance.ee.bear.share.export.o
    public final List<ShareItemModel> a(km5.a r15) {
        Intrinsics.checkNotNullParameter(r15, "params");
        int r0 = b.a[r15.q.ordinal()];
        Object r1 = null;
        if (r0 == 1) goto L10;
        if (r0 == 2) goto L9;
        if (r0 != 3) goto L8;
        List<ShareItemModel> r2 = e(r15, false, true);
    L209:
        Iterator<T> r3 = r2.iterator();
    L211:
        if (r3.hasNext() == false) goto L218;
        Object r4 = r3.next();
        if (((ShareItemModel) r4).getType() != ShareType.Lark) goto L215;
        boolean r6 = true;
    L216:
        if (r6 == false) goto L211;
        r1 = r4;
        goto L218
    L215:
        r6 = false;
    L218:
        ShareItemModel r5 = (ShareItemModel) r1;
        if (r5 == null) goto L221;
        r5.setOnClickedListener(new d(this, r15));
    L221:
        Iterator<T> r16 = r2.iterator();
    L223:
        if (r16.hasNext() == false) goto L225;
        ShareItemModel r7 = (ShareItemModel) r16.next();
        r7.setShareIconStyle(ShareItemModel.ShareIconStyle.FILL);
        r7.setSrcTint(Integer.MIN_VALUE);
        r7.setShareItemBackground(0);
        goto L223
    L225:
        return r2;
    L8:
        throw new NoWhenBranchMatchedException();
    L9:
        r2 = e(r15, true, false);
        goto L209
    L10:
        int r8 = r15.b;
        if (r8 != 0) goto L46;
        boolean r9 = r15.k;
        Object r10 = r15.r;
        if ((r10 instanceof ShareFolderInfo) == false) goto L15;
        ShareFolderInfo r11 = (ShareFolderInfo) r10;
    L16:
        boolean r12 = !km5.c.d();
        if (r9 == true) goto L19;
        ArrayList r13 = new ArrayList();
        km5.b.b(r13);
        km5.b.a(r13);
    L208:
        Intrinsics.checkNotNull(r13);
        r2 = r13;
        goto L209
    L19:
        r13 = new ArrayList();
        km5.b.b(r13);
        km5.b.a(r13);
        if (com.bytedance.ee.bear.middleground.permission.b.m() == true) goto L22;
    L39:
        boolean r14 = false;
    L40:
        if (r14 == false) goto L42;
        ShareItemUtil r17 = ShareItemUtil.a;
        ShareType r18 = ShareType.PasswordLink;
        ShareState r19 = ShareState.SHOW;
        r17.getClass();
        r13.add(ShareItemUtil.a(r18, r19));
    L42:
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        if (e.a.a.h() == false) goto L208;
        km5.b.d(r13, r12);
        ShareItemUtil r20 = ShareItemUtil.a;
        ShareType r21 = ShareType.More;
        ShareState r22 = ShareState.SHOW;
        r20.getClass();
        r13.add(ShareItemUtil.a(r21, r22));
        goto L208
    L22:
        if (ui5.b.b() == false) goto L39;
        if (r11 == null) goto L39;
        int r23 = r11.i.b.getLinkShareAnyoneReadBlockValue();
        if (r23 == 0) goto L30;
        if (r23 == 3) goto L30;
        boolean r24 = false;
    L32:
        if (r11.e() == false) goto L39;
        if (r24 == false) goto L39;
        if (r11.i.b.adminCanCross() == false) goto L39;
        if (r11.i.b.showLinkShare() == false) goto L39;
        r14 = true;
    L30:
        r24 = true;
        goto L32
    L15:
        r11 = null;
        goto L16
    L46:
        if (r15.k == true) goto L48;
        r13 = new ArrayList();
        km5.b.b(r13);
        km5.b.a(r13);
        goto L208
    L48:
        String r25 = r15.c;
        if (r15.a != 2) goto L51;
        boolean r26 = true;
    L52:
        boolean r27 = !km5.c.d();
        AccountService.Account r28 = ((h0) org.koin.java.a.a(h0.class)).G2();
        if (r28 == null) goto L55;
        String r29 = r28.tenantId;
    L56:
        TextUtils.equals("1", r29);
        gj5.b r30 = (gj5.b) org.koin.java.a.a(gj5.b.class);
        FileBizDomain r31 = FileBizDomain.FileBizDomainCCM;
        gj5.c r32 = r30.g("CCM_EXPORT", r31, r8, r25);
        gj5.c r33 = ((gj5.b) org.koin.java.a.a(gj5.b.class)).g("CCM_FILE_DOWNLOAD", r31, r8, r25);
        Intrinsics.checkNotNullParameter(r32, "exportResult");
        Intrinsics.checkNotNullParameter(r33, "downloadResult");
        if (r15.d == false) goto L80;
        if (r8 != sbb.e.k.b) goto L65;
        if (r26 == true) goto L62;
    L70:
        r26 = false;
    L71:
        ArrayList r34 = new ArrayList();
        km5.b.b(r34);
        km5.b.a(r34);
        km5.b.c(r15, r34);
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        e r35 = e.a.a;
        boolean r36 = r35.i();
        boolean r37 = !km5.c.d();
        ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
        boolean r38 = r35.h();
        ShareItemUtil r39 = ShareItemUtil.a;
        ShareType r110 = ShareType.ExportImage;
        ShareState r40 = km5.b.f(r26, r32, r15.e, r15.i, r15.j);
        r39.getClass();
        ShareItemModel r41 = ShareItemUtil.a(r110, r40);
        if (r41.getState() != ShareState.CAC_NOT_CLICK) goto L74;
        r41.setDocType(r15.b);
        r41.setDocToken(r15.c);
    L74:
        r34.add(r41);
        if (r36 == false) goto L78;
        if (r38 == false) goto L78;
        km5.b.d(r34, r37);
        r34.add(ShareItemUtil.a(ShareType.More, ShareState.SHOW));
    L78:
        r13 = r34;
        goto L208
    L62:
        if (TextUtils.equals(r15.f, MindNoteTitleMenuConfigPlugin.MENU_ID_OUTLINE) == false) goto L70;
        r26 = true;
        goto L71
    L65:
        if (r8 == sbb.e.i.b) goto L70;
        if (r8 == sbb.e.l.b) goto L70;
        if (r8 != sbb.e.m.b) goto L71;
    L80:
        if (r8 != sbb.e.g.b) goto L94;
        boolean r42 = !TextUtils.isEmpty(((com.bytedance.ee.bear.middleground_permission_export.model.d) org.koin.java.a.a(com.bytedance.ee.bear.middleground_permission_export.model.d.class)).a(r25, r8, "CCM_EXPORT", "", ""));
        ArrayList r43 = new ArrayList();
        km5.b.b(r43);
        km5.b.a(r43);
        km5.b.c(r15, r43);
        ShareItemUtil r44 = ShareItemUtil.a;
        ShareType r45 = ShareType.ExportImage;
        ShareState r46 = km5.b.f(r26, r32, r15.e, r15.i, r15.j);
        r44.getClass();
        ShareItemModel r47 = ShareItemUtil.a(r45, r46);
        if (r47.getState() != ShareState.CAC_NOT_CLICK) goto L84;
        r47.setDocType(r15.b);
        r47.setDocToken(r15.c);
    L84:
        r43.add(r47);
        if (km5.b.h() == false) goto L193;
        if (r27 == true) goto L88;
    L91:
        ShareState r48 = ShareState.NOT_SHOW;
    L92:
        km5.b.e(r43, r27, r48);
        r43.add(ShareItemUtil.a(ShareType.More, ShareState.SHOW));
        goto L193
    L88:
        if (r15.j == true) goto L91;
        if (r42 == true) goto L91;
        r48 = ShareState.SHOW;
    L193:
        r13 = r43;
        goto L208
    L94:
        if (r8 != sbb.e.o.b) goto L102;
        ArrayList r49 = new ArrayList();
        km5.b.b(r49);
        km5.b.a(r49);
        km5.b.c(r15, r49);
        ShareItemUtil r50 = ShareItemUtil.a;
        ShareType r51 = ShareType.ExportImage;
        ShareState r52 = km5.b.f(r26, r32, r15.e, r15.i, r15.j);
        r50.getClass();
        ShareItemModel r53 = ShareItemUtil.a(r51, r52);
        if (r53.getState() != ShareState.CAC_NOT_CLICK) goto L98;
        r53.setDocToken(r15.c);
        r53.setDocType(r15.b);
    L98:
        r49.add(r53);
        if (km5.b.h() == false) goto L152;
        km5.b.d(r49, r27);
        r49.add(ShareItemUtil.a(ShareType.More, ShareState.SHOW));
    L152:
        r13 = r49;
        goto L208
    L102:
        if (r8 != sbb.e.h.b) goto L140;
        boolean r54 = r15.e;
        r43 = new ArrayList();
        km5.b.b(r43);
        km5.b.a(r43);
        km5.b.c(r15, r43);
        if (r26 == false) goto L137;
        if (r32.a == false) goto L137;
        ShareItemUtil r55 = ShareItemUtil.a;
        ShareType r56 = ShareType.ExportImage;
        if (r54 == false) goto L110;
        ShareState r57 = ShareState.SHOW;
    L111:
        r55.getClass();
        ShareItemModel r58 = ShareItemUtil.a(r56, r57);
        int r59 = r56.ordinal();
        ArrayList<Integer> r60 = r15.g;
        if (r60 != null) goto L114;
    L119:
        ArrayList<Integer> r61 = r15.h;
        if (r61 == null) goto L128;
        if (r61.contains(Integer.valueOf(r59)) == false) goto L128;
        if (r54 == false) goto L125;
        ShareState r62 = ShareState.SHOW_NEW;
    L126:
        r58.setState(r62);
        goto L128
    L125:
        r62 = ShareState.NOT_SHOW;
    L128:
        if (r15.j == false) goto L131;
        r58.setState(ShareState.NOT_SHOW);
    L131:
        if (r32.a == false) goto L133;
    L135:
        r43.add(r58);
        goto L137
    L133:
        if (r32.b != FileAuthResultFrom.COME_FROM_FILE_POLICY) goto L135;
        r58.setState(ShareState.CAC_NOT_CLICK);
        r58.setDocType(r15.b);
        r58.setDocToken(r15.c);
        goto L135
    L114:
        if (r60.contains(Integer.valueOf(r59)) == false) goto L119;
        if (r54 == false) goto L117;
        ShareState r63 = ShareState.NOT_CLICK;
    L118:
        r58.setState(r63);
        goto L119
    L117:
        r63 = ShareState.NOT_SHOW;
        goto L118
    L110:
        r57 = ShareState.NOT_SHOW;
    L137:
        if (km5.b.h() == false) goto L193;
        km5.b.d(r43, r27);
        ShareItemUtil r64 = ShareItemUtil.a;
        ShareType r65 = ShareType.More;
        ShareState r66 = ShareState.SHOW;
        r64.getClass();
        r43.add(ShareItemUtil.a(r65, r66));
        goto L193
    L140:
        if (r8 != sbb.e.k.b) goto L154;
        if (r26 == true) goto L143;
    L145:
        boolean r67 = false;
    L146:
        r49 = new ArrayList();
        km5.b.b(r49);
        km5.b.a(r49);
        km5.b.c(r15, r49);
        ShareItemUtil r68 = ShareItemUtil.a;
        ShareType r69 = ShareType.ExportImage;
        ShareState r70 = km5.b.f(r67, r32, r15.e, r15.i, r15.j);
        r68.getClass();
        ShareItemModel r71 = ShareItemUtil.a(r69, r70);
        if (r71.getState() != ShareState.CAC_NOT_CLICK) goto L149;
        r71.setDocType(r15.b);
        r71.setDocToken(r15.c);
    L149:
        r49.add(r71);
        if (km5.b.h() == false) goto L152;
        km5.b.d(r49, r27);
        r49.add(ShareItemUtil.a(ShareType.More, ShareState.SHOW));
        goto L152
    L143:
        if (TextUtils.equals(r15.f, MindNoteTitleMenuConfigPlugin.MENU_ID_OUTLINE) == false) goto L145;
        r67 = true;
        goto L146
    L154:
        if (r8 != sbb.e.l.b) goto L159;
        r13 = new ArrayList();
        km5.b.b(r13);
        km5.b.a(r13);
        km5.b.c(r15, r13);
        if (km5.b.h() == false) goto L208;
        km5.b.d(r13, r27);
        ShareItemUtil r72 = ShareItemUtil.a;
        ShareType r73 = ShareType.More;
        ShareState r74 = ShareState.SHOW;
        r72.getClass();
        r13.add(ShareItemUtil.a(r73, r74));
        goto L208
    L159:
        if (r8 != sbb.e.m.b) goto L164;
        r13 = new ArrayList();
        km5.b.b(r13);
        km5.b.a(r13);
        km5.b.c(r15, r13);
        if (km5.b.h() == false) goto L208;
        km5.b.d(r13, r27);
        ShareItemUtil r75 = ShareItemUtil.a;
        ShareType r76 = ShareType.More;
        ShareState r77 = km5.b.g(r33.a, r15.e);
        r75.getClass();
        r13.add(ShareItemUtil.a(r76, r77));
        goto L208
    L164:
        if (r8 != sbb.e.i.b) goto L169;
        r13 = new ArrayList();
        km5.b.b(r13);
        km5.b.a(r13);
        km5.b.c(r15, r13);
        if (km5.b.h() == false) goto L208;
        km5.b.d(r13, r27);
        ShareItemUtil r78 = ShareItemUtil.a;
        ShareType r79 = ShareType.More;
        ShareState r80 = ShareState.SHOW;
        r78.getClass();
        r13.add(ShareItemUtil.a(r79, r80));
        goto L208
    L169:
        if (r8 != 113) goto L174;
        r13 = new ArrayList();
        km5.b.b(r13);
        km5.b.a(r13);
        km5.b.c(r15, r13);
        if (km5.b.h() == false) goto L208;
        km5.b.d(r13, r27);
        ShareItemUtil r81 = ShareItemUtil.a;
        ShareType r82 = ShareType.More;
        ShareState r83 = km5.b.g(r33.a, r15.e);
        r81.getClass();
        r13.add(ShareItemUtil.a(r82, r83));
        goto L208
    L174:
        if (r8 != sbb.e.j.b) goto L177;
        r13 = new ArrayList();
        km5.b.b(r13);
        ShareItemUtil r84 = ShareItemUtil.a;
        ShareType r85 = ShareType.CopyLink;
        ShareState r86 = ShareState.SHOW;
        r84.getClass();
        r13.add(ShareItemUtil.a(r85, r86));
        goto L208
    L177:
        if (r8 != sbb.e.r.b) goto L180;
        r13 = new ArrayList();
        km5.b.b(r13);
        ShareItemUtil r87 = ShareItemUtil.a;
        ShareType r88 = ShareType.CopyLink;
        ShareState r89 = ShareState.SHOW;
        r87.getClass();
        r13.add(ShareItemUtil.a(r88, r89));
        km5.b.d(r13, r27);
        r13.add(ShareItemUtil.a(ShareType.More, r89));
        goto L208
    L180:
        if (r8 != 44) goto L183;
        r13 = new ArrayList();
        km5.b.b(r13);
        ShareItemUtil r90 = ShareItemUtil.a;
        ShareType r91 = ShareType.CopyLink;
        ShareState r92 = ShareState.SHOW;
        r90.getClass();
        r13.add(ShareItemUtil.a(r91, r92));
        goto L208
    L183:
        if (r8 != sbb.e.q.b) goto L195;
        r43 = new ArrayList();
        km5.b.b(r43);
        km5.b.a(r43);
        if (r15.p == false) goto L191;
        ShareItemUtil r93 = ShareItemUtil.a;
        ShareType r94 = ShareType.ExportImage;
        ShareState r95 = km5.b.f(r26, r32, r15.e, r15.i, r15.j);
        r93.getClass();
        ShareItemModel r96 = ShareItemUtil.a(r94, r95);
        if (r96.getState() != ShareState.CAC_NOT_CLICK) goto L189;
        r96.setDocToken(r15.c);
        r96.setDocType(r15.b);
    L189:
        r43.add(r96);
    L191:
        if (km5.b.h() == false) goto L193;
        km5.b.d(r43, r27);
        ShareItemUtil r97 = ShareItemUtil.a;
        ShareType r98 = ShareType.More;
        ShareState r99 = km5.b.g(r33.a, r15.e);
        r97.getClass();
        r43.add(ShareItemUtil.a(r98, r99));
        goto L193
    L195:
        if (r8 != 125) goto L205;
        r13 = new ArrayList();
        km5.b.b(r13);
        km5.b.a(r13);
        boolean r100 = km5.b.h();
        if (r15.p == false) goto L200;
        if (r100 == false) goto L200;
        ShareItemUtil r101 = ShareItemUtil.a;
        ShareType r102 = ShareType.ExportImage;
        ShareState r103 = ShareState.SHOW;
        r101.getClass();
        r13.add(ShareItemUtil.a(r102, r103));
    L200:
        if (r100 == false) goto L208;
        if (r27 == false) goto L203;
        ShareState r104 = ShareState.SHOW;
    L204:
        ShareItemUtil r105 = ShareItemUtil.a;
        ShareType r106 = ShareType.Wechat;
        r105.getClass();
        r13.add(ShareItemUtil.a(r106, r104));
        r13.add(ShareItemUtil.a(ShareType.WechatMoments, r104));
        r13.add(ShareItemUtil.a(ShareType.More, ShareState.SHOW));
        goto L208
    L203:
        r104 = ShareState.NOT_SHOW;
        goto L204
    L205:
        r13 = new ArrayList();
        km5.b.b(r13);
        km5.b.a(r13);
        if (km5.b.h() == false) goto L208;
        km5.b.d(r13, r27);
        ShareItemUtil r107 = ShareItemUtil.a;
        ShareType r108 = ShareType.More;
        ShareState r109 = km5.b.g(r33.a, r15.e);
        r107.getClass();
        r13.add(ShareItemUtil.a(r108, r109));
        goto L208
    L55:
        r29 = "";
        goto L56
    L51:
        r26 = false;
        goto L52
    }

    @Override // com.bytedance.ee.bear.share.export.o
    public final boolean b(km5.a r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        if (r2.q == ShareScene.DOCUMENT) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean f(km5.a r0, ShareType r1) {
        ArrayList<Integer> r2 = r0.g;
        if (r2 != null) goto L5;
    L7:
        return false;
    L5:
        if (r2.contains(Integer.valueOf(r1.ordinal())) != true) goto L7;
        return true;
    }

    public static void d(List r1, km5.a r2, ShareType r3) {
        if (f(r2, r3) == true) goto L6;
        ShareItemUtil r4 = ShareItemUtil.a;
        ShareState r0 = ShareState.SHOW;
        r4.getClass();
        ArrayList r5 = (ArrayList) r1;
        r5.add(ShareItemUtil.a(r3, r0));
        return;
    }

    public static List e(km5.a r3, boolean r4, boolean r5) {
        ArrayList r0 = new ArrayList();
        if (r4 == false) goto L8;
        ShareType r6 = ShareType.Download;
        if (f(r3, r6) == true) goto L8;
        ShareItemUtil r1 = ShareItemUtil.a;
        ShareState r2 = ShareState.SHOW;
        r1.getClass();
        r0.add(ShareItemUtil.a(r6, r2));
    L8:
        if (AppInfoUtils.e().booleanValue() == true) goto L12;
        ShareType r7 = ShareType.Lark;
        if (f(r3, r7) == true) goto L12;
        ShareItemUtil r8 = ShareItemUtil.a;
        ShareState r9 = ShareState.SHOW;
        r8.getClass();
        r0.add(ShareItemUtil.a(r7, r9));
    L12:
        if (r5 == false) goto L16;
        ShareType r10 = ShareType.CopyText;
        if (f(r3, r10) == true) goto L16;
        ShareItemUtil r11 = ShareItemUtil.a;
        ShareState r12 = ShareState.SHOW;
        r11.getClass();
        r0.add(ShareItemUtil.a(r10, r12));
    L16:
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        boolean r13 = e.a.a.h();
        if (r13 == false) goto L21;
        ((com.bytedance.ee.bear.share.export.a) org.koin.java.a.c(com.bytedance.ee.bear.share.export.a.class, null, null, 6)).Y9().getClass();
        if ((!km5.c.d()) == false) goto L21;
        d(r0, r3, ShareType.Wechat);
        d(r0, r3, ShareType.WechatMoments);
        d(r0, r3, ShareType.QQ);
        d(r0, r3, ShareType.Weibo);
    L21:
        if (r13 == false) goto L25;
        ShareType r14 = ShareType.More;
        if (f(r3, r14) == true) goto L25;
        ShareItemUtil r15 = ShareItemUtil.a;
        ShareState r16 = ShareState.SHOW;
        r15.getClass();
        r0.add(ShareItemUtil.a(r14, r16));
    L25:
        return r0;
    }

    public static String g(ShareItemModel r2, com.bytedance.ee.bear.share.g r3, km5.a r4) {
        String r5 = ((t45.c) LarkContext.spiByDwarf(t45.c.class)).T6(r3.a, Integer.valueOf(r2.getDocType()));
        if (r5 != null) goto L5;
        r5 = "";
    L5:
        s45.i r6 = s45.i.a;
        int r7 = r4.b;
        boolean r0 = Intrinsics.areEqual(AppInfoUtils.f(), Boolean.TRUE);
        r6.getClass();
        return s45.i.b(r5, r7, r0);
    }

    public static final void c(c r0, Context r1, ShareItemModel r2, com.bytedance.ee.bear.share.g r3, km5.a r4) {
        r0.getClass();
        Toast.showSuccessText(r1, 2131889044);
        String r5 = g(r2, r3, r4);
        ((fu5.a) org.koin.java.a.c(fu5.a.class, null, null, 6)).n(r5, false, new Token("LARK-PSDA-ccm_android_share_dialog_copy_link"));
    }
}
