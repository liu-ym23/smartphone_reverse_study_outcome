package com.bytedance.ee.bear.middleground.permission.secret.detail;

import android.app.Application;
import android.content.Context;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.bytedance.ee.bear.VisibleSecretResult;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.middleground.permission.secret.a0;
import com.bytedance.ee.bear.middleground.permission.secret.detail.adapter.DataAdapter;
import com.bytedance.ee.bear.middleground.permission.secret.detail.adapter.LeftAdapter;
import com.bytedance.ee.bear.middleground.permission.secret.detail.adapter.SecretDetailAdapter;
import com.bytedance.ee.bear.middleground.permission.secret.p;
import com.bytedance.ee.bear.secret.PermissionControl;
import com.bytedance.ee.bear.secret.SecretLevel;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.util.ui.n;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.passportc.internal.v;
import com.ss.android.lark.utils.LarkContext;
import e0c.k;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h {
    public final Context a;
    public final View b;
    public final String c;
    public final int d;
    public final jdb.g e;
    public f f;
    public d g;
    public final CompositeDisposable h;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ h a;

        public b(h r1) {
            this.a = r1;
        }

        /* JADX WARN: Type inference failed for: r12v2, types: [boolean, int] */
        /* JADX WARN: Type inference failed for: r12v5 */
        /* JADX WARN: Type inference failed for: r12v83 */
        public final void accept(Object r18) {
            VisibleSecretResult r1 = (VisibleSecretResult) r18;
            d r2 = this.a.g;
            if (r2 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("mControllerView");
            r2 = null;
        L5:
            r2.b.findViewById(2131378988).setVisibility(8);
            r2.b.findViewById(2131378988).cancelAnimation();
            if (CollectionUtils.isEmpty((ArrayList) ((Result) r1).data) == false) goto L8;
            tt5.a.d("SecretDetailPresenter", "data is null");
            return;
        L8:
            f r3 = this.a.f;
            if (r3 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            r3 = null;
        L11:
            jdb.g r6 = this.a.e;
            if (r6 == null) goto L14;
            boolean r7 = r6.isEnable("ccm.admin.department_search_default_setting");
        L15:
            int r9 = this.a.getType();
            r3.getClass();
            boolean r10 = com.bytedance.ee.bear.middleground.permission.b.j();
            boolean r12 = true;
            if (r9 != sbb.e.v.b) goto L18;
            boolean r11 = true;
        L19:
            if (r7 == false) goto L22;
            if (r11 == true) goto L22;
            boolean r8 = true;
        L23:
            ArrayList r13 = new ArrayList();
            r13.add(new com.bytedance.ee.bear.middleground.permission.secret.detail.b(1, false, r3.a.getString(2131889936), 8));
            int r15 = 2;
            r13.add(new com.bytedance.ee.bear.middleground.permission.secret.detail.b(2, !r8, r3.a.getString(2131889941), 8));
            if (r8 == false) goto L26;
            r13.add(new com.bytedance.ee.bear.middleground.permission.secret.detail.b(3, true, r3.a.getString(2131889940), 8));
        L26:
            r13.add(new com.bytedance.ee.bear.middleground.permission.secret.detail.b(4, false, r3.a.getString(a0.a(r9, 2131888872, 2131889934)), 8));
            r13.add(new com.bytedance.ee.bear.middleground.permission.secret.detail.b(5, !r10, r3.a.getString(2131889944), 8));
            if (r10 == false) goto L29;
            r13.add(new com.bytedance.ee.bear.middleground.permission.secret.detail.b(6, true, r3.a.getString(2131889735), 8));
        L29:
            r13.add(new com.bytedance.ee.bear.middleground.permission.secret.detail.b(7, true, r3.a.getString(2131889935), 8));
            if (r11 == true) goto L32;
            r13.add(new com.bytedance.ee.bear.middleground.permission.secret.detail.b(8, true, r3.a.getString(2131889696), 8));
            r13.add(new com.bytedance.ee.bear.middleground.permission.secret.detail.b(9, true, r3.a.getString(2131889699), 8));
            r13.add(new com.bytedance.ee.bear.middleground.permission.secret.detail.b(10, true, r3.a.getString(2131889931), 8));
        L32:
            com.bytedance.ee.bear.appsetting.c r14 = com.bytedance.ee.bear.appsetting.c.a.a;
            Application r16 = LarkContext.getApplication();
            r14.getClass();
            boolean r17 = ((dn4.a) k.b(((v) k.a(r16, v.class)).c(((com.ss.android.lark.passportc.convention.a) k.a(r16, com.ss.android.lark.passportc.convention.a.class)).b()), dn4.a.class)).a().isCurrentEnable("ccm.permission.knowledge_ai_search_excluded");
            tt5.a.h("PermFGUtils", "showAISearchDescItem()...enable = " + r17);
            if (r17 == false) goto L36;
            if (r11 == true) goto L36;
            r13.add(new com.bytedance.ee.bear.middleground.permission.secret.detail.b(11, true, r3.a.getString(2131889721), 8));
        L36:
            f r4 = this.a.f;
            if (r4 != null) goto L39;
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            r4 = null;
        L39:
            r4.getClass();
            ArrayList r5 = new ArrayList();
            Iterator r19 = ((ArrayList) ((Result) r1).data).iterator();
        L41:
            if (r19.hasNext() == false) goto L43;
            r5.add(new com.bytedance.ee.bear.middleground.permission.secret.detail.a(((SecretLevel) r19.next()).getName(), false, false, 6));
            goto L41
        L43:
            f r20 = this.a.f;
            if (r20 != null) goto L46;
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            r20 = null;
        L46:
            r20.getClass();
            Intrinsics.checkNotNullParameter(r13, "leftData");
            ArrayList r21 = new ArrayList();
            ArrayList r22 = (ArrayList) ((Result) r1).data;
            boolean r23 = com.bytedance.ee.bear.middleground.permission.b.j();
            Iterator r24 = r13.iterator();
        L48:
            if (r24.hasNext() == false) goto L50;
            r21.add(new j(((com.bytedance.ee.bear.middleground.permission.secret.detail.b) r24.next()).b, 6));
            goto L48
        L50:
            Iterator r25 = r22.iterator();
        L52:
            if (r25.hasNext() == false) goto L204;
            PermissionControl r26 = ((SecretLevel) r25.next()).getPermissionControl();
            int r110 = r13.size();
            int r111 = 0;
            ?? r112 = r12;
        L54:
            if (r111 >= r110) goto L203;
            com.bytedance.ee.bear.middleground.permission.secret.detail.b r113 = (com.bytedance.ee.bear.middleground.permission.secret.detail.b) CollectionsKt.getOrNull(r13, r111);
            j r27 = (j) CollectionsKt.getOrNull(r21, r111);
            if (r113 == null) goto L201;
            if (r27 == null) goto L201;
            switch(r113.a) {
                case 1: goto L191;
                case 2: goto L166;
                case 3: goto L157;
                case 4: goto L149;
                case 5: goto L127;
                case 6: goto L119;
                case 7: goto L98;
                case 8: goto L87;
                case 9: goto L76;
                case 10: goto L68;
                case 11: goto L63;
                default: goto L61;
            };
        L61:
            com.bytedance.ee.bear.middleground.permission.secret.detail.a r28 = new com.bytedance.ee.bear.middleground.permission.secret.detail.a(null, false, false, 7);
        L200:
            r27.b.add(r28);
        L202:
            r111 = r111 + 1;
            r112 = 1;
            r15 = 2;
            goto L54
        L157:
            int r114 = r26.getSearchEntity();
            if (r114 != 1) goto L160;
            String r115 = r20.a.getString(2131889942);
            Intrinsics.checkNotNull(r115);
        L164:
            r28 = new com.bytedance.ee.bear.middleground.permission.secret.detail.a(r115, false, false, 6);
            goto L200
        L160:
            if (r114 == 2) goto L162;
            r115 = r20.a.getString(2131889942);
            Intrinsics.checkNotNull(r115);
            goto L164
        L162:
            r115 = r20.a.getString(2131889938);
            Intrinsics.checkNotNull(r115);
            goto L164
        L63:
            if (r26.getDisableAISearchEntity() == r15) goto L65;
            boolean r116 = true;
        L66:
            r28 = new com.bytedance.ee.bear.middleground.permission.secret.detail.a(null, r112, r116, r112);
            goto L200
        L65:
            r116 = false;
            goto L66
        L68:
            if (r26.onlyCanReadCanComment() == false) goto L71;
            String r29 = r20.a.getString(2131889930);
        L74:
            r28 = new com.bytedance.ee.bear.middleground.permission.secret.detail.a(r29, false, false, 6);
            goto L200
        L71:
            if (r26.onlyCanEditorCanComment() == false) goto L73;
            r29 = r20.a.getString(2131889928);
            goto L74
        L73:
            r29 = r20.a.getString(2131889942);
            goto L74
        L76:
            if (r26.onlyCanCopyAndDownload() == false) goto L79;
            String r30 = r20.a.getString(2131889930);
        L85:
            com.bytedance.ee.bear.middleground.permission.secret.detail.a r117 = new com.bytedance.ee.bear.middleground.permission.secret.detail.a(r30, false, false, 6);
        L117:
            r28 = r117;
            goto L200
        L79:
            if (r26.onlyEditorOrFaCanCopyAndDownload() == false) goto L82;
            r30 = r20.a.getString(2131889928);
            goto L85
        L82:
            if (r26.onlyFaCanCopyAndDownload() == false) goto L84;
            r30 = r20.a.getString(2131889929);
            goto L85
        L84:
            r30 = r20.a.getString(2131889942);
            goto L85
        L87:
            if (r26.onlyReadCanCopy() == false) goto L90;
            String r31 = r20.a.getString(2131889930);
        L96:
            r117 = new com.bytedance.ee.bear.middleground.permission.secret.detail.a(r31, false, false, 6);
            goto L117
        L90:
            if (r26.onlyEditorOrFaCanCopy() == false) goto L93;
            r31 = r20.a.getString(2131889928);
            goto L96
        L93:
            if (r26.onlyFaCanCopy() == false) goto L95;
            r31 = r20.a.getString(2131889929);
            goto L96
        L95:
            r31 = r20.a.getString(2131889942);
            goto L96
        L98:
            if (r26.onlyCanAddCollaborator() == false) goto L101;
            String r32 = r20.a.getString(2131889930);
        L116:
            r117 = new com.bytedance.ee.bear.middleground.permission.secret.detail.a(r32, false, false, 6);
            goto L117
        L101:
            if (r26.onlyInternalCanAddCollaborator() == false) goto L104;
            r32 = r20.a.getString(2131889943);
            goto L116
        L104:
            if (r26.onlyCanEditorCanAddCollaborator() == false) goto L107;
            r32 = r20.a.getString(2131889928);
            goto L116
        L107:
            if (r26.onlyInterCanEditorCanAddCollaborator() == false) goto L110;
            r32 = r20.a.getString(2131889933);
            goto L116
        L110:
            if (r26.onlyFaCanAddOrManagerCollaborator() == false) goto L113;
            r32 = r20.a.getString(2131889929);
            goto L116
        L113:
            if (r26.onlyInternalCanAddOrManagerCollaborator() == false) goto L115;
            r32 = r20.a.getString(2131889939);
            goto L116
        L115:
            r32 = r20.a.getString(2131889942);
            goto L116
        L119:
            if (r26.shareExternalNoLimit() == false) goto L122;
            String r118 = r20.a.getString(2131889942);
        L125:
            r28 = new com.bytedance.ee.bear.middleground.permission.secret.detail.a(r118, false, false, 6);
            goto L200
        L122:
            if (r26.shareExternalOnlyRelated() == false) goto L124;
            r118 = r20.a.getString(2131889740);
            goto L125
        L124:
            r26.denyShareExternal();
            r118 = "-";
            goto L125
        L127:
            if (com.bytedance.ee.bear.middleground.permission.b.j() == false) goto L138;
            if (r26.onlyShareInternalV2() == false) goto L132;
            String r119 = r20.a.getString(2131889938);
        L147:
            r28 = new com.bytedance.ee.bear.middleground.permission.secret.detail.a(r119, false, false, 6);
            goto L200
        L132:
            if (r26.onlyFaCanShareExternalV2() == false) goto L135;
            r119 = r20.a.getString(2131889937);
            goto L147
        L135:
            if (r26.onlyCanShowInternalV2() == false) goto L146;
            r119 = r20.a.getString(2131889942);
        L146:
            r119 = r20.a.getString(2131889942);
            goto L147
        L138:
            if (r26.onlyShareInternal() == false) goto L141;
            r119 = r20.a.getString(2131889938);
            goto L147
        L141:
            if (r26.onlyFaCanShareExternal() == false) goto L144;
            r119 = r20.a.getString(2131889937);
            goto L147
        L144:
            if (r26.onlyCanShareInternal() == false) goto L146;
            r119 = r20.a.getString(2131889942);
            goto L147
        L149:
            if (r23 == false) goto L153;
            boolean r120 = r26.allowShareExternal();
        L156:
            r28 = new com.bytedance.ee.bear.middleground.permission.secret.detail.a(null, true, r120, 1);
            goto L200
        L153:
            if (r26.onlyShareInternal() == true) goto L155;
            r120 = true;
            goto L156
        L155:
            r120 = false;
            goto L156
        L166:
            if (r26.closeLinkShare() == false) goto L169;
            String r121 = r20.a.getString(2131889938);
        L189:
            r28 = new com.bytedance.ee.bear.middleground.permission.secret.detail.a(r121, false, false, 6);
            goto L200
        L169:
            if (r26.canReadInternalLinkShare() == false) goto L172;
            r121 = r20.a.getString(2131889733);
            goto L189
        L172:
            if (r26.canEditorInternalLinkShare() == false) goto L175;
            r121 = r20.a.getString(2131889732);
            goto L189
        L175:
            if (r26.canReadLinkShare() == false) goto L178;
            r121 = r20.a.getString(2131889737);
            goto L189
        L178:
            if (r26.canEditorLinkShare() == false) goto L181;
            r121 = r20.a.getString(2131889736);
            goto L189
        L181:
            if (com.bytedance.ee.bear.middleground.permission.b.j() == true) goto L183;
        L188:
            r121 = r20.a.getString(2131889942);
            goto L189
        L183:
            if (r26.canOrgReadLinkShare() == false) goto L186;
            r121 = r20.a.getString(2131889739);
            goto L189
        L186:
            if (r26.canOrgEditLinkShare() == false) goto L188;
            r121 = r20.a.getString(2131889738);
            goto L189
        L191:
            if (r23 == false) goto L195;
            boolean r122 = r26.allowLinkShare();
        L198:
            r28 = new com.bytedance.ee.bear.middleground.permission.secret.detail.a(null, true, r122, 1);
            goto L200
        L195:
            if (r26.closeLinkShare() == true) goto L197;
            r122 = true;
            goto L198
        L197:
            r122 = false;
        L201:
            tt5.a.h("SecretDetailModel", "getTableData - assemble detail, params invalid, eachLeft: " + r113 + ", eachDetail: " + r27);
            goto L202
        L203:
            r12 = true;
            goto L52
        L204:
            int r33 = r13.size();
            int r34 = 0;
        L205:
            if (r34 >= r33) goto L215;
            int r35 = n.d(r20.b);
            List<com.bytedance.ee.bear.middleground.permission.secret.detail.a> r36 = ((j) ListProtector.get(r21, r34)).b;
            if (CollectionUtils.isEmpty(r36) == true) goto L214;
            Iterator<com.bytedance.ee.bear.middleground.permission.secret.detail.a> r37 = r36.iterator();
        L211:
            if (r37.hasNext() == false) goto L213;
            r35 = Math.max(r35, r20.a(r37.next().a));
            goto L211
        L213:
            r35 = Math.max(r35, r20.a(((com.bytedance.ee.bear.middleground.permission.secret.detail.b) ListProtector.get(r13, r34)).c));
        L214:
            ((com.bytedance.ee.bear.middleground.permission.secret.detail.b) ListProtector.get(r13, r34)).d = r35;
            ((j) ListProtector.get(r21, r34)).c = r35;
            r34 = r34 + 1;
            goto L205
        L215:
            d r123 = this.a.g;
            if (r123 != null) goto L218;
            Intrinsics.throwUninitializedPropertyAccessException("mControllerView");
            r123 = null;
        L218:
            r123.getClass();
            Intrinsics.checkNotNullParameter(r21, "<set-?>");
            r123.c = r21;
            d r124 = this.a.g;
            if (r124 != null) goto L221;
            Intrinsics.throwUninitializedPropertyAccessException("mControllerView");
            r124 = null;
        L221:
            r124.getClass();
            Intrinsics.checkNotNullParameter(r5, "<set-?>");
            r124.d = r5;
            d r125 = this.a.g;
            if (r125 != null) goto L224;
            Intrinsics.throwUninitializedPropertyAccessException("mControllerView");
            r125 = null;
        L224:
            r125.getClass();
            Intrinsics.checkNotNullParameter(r13, "<set-?>");
            r125.e = r13;
            d r126 = this.a.g;
            if (r126 != null) goto L227;
            Intrinsics.throwUninitializedPropertyAccessException("mControllerView");
            r126 = null;
        L227:
            ((LinearLayout) r126.b.findViewById(2131374518)).setVisibility(0);
            ((ScrollView) r126.b.findViewById(2131385224)).setVisibility(0);
            ((SyncHorizontalScrollView) r126.b.findViewById(2131368529)).setScrollView(r126.b.findViewById(2131374292));
            ((SyncHorizontalScrollView) r126.b.findViewById(2131374292)).setScrollView(r126.b.findViewById(2131368529));
            LeftAdapter r38 = new LeftAdapter(r126.e);
            ((NoscrollRecycleView) r126.b.findViewById(2131379259)).setLayoutManager(new LinearLayoutManager(r126.a));
            ((NoscrollRecycleView) r126.b.findViewById(2131379259)).setAdapter(r38);
            SecretDetailAdapter r39 = new SecretDetailAdapter(r126.c);
            ((NoscrollRecycleView) r126.b.findViewById(2131379256)).setLayoutManager(new LinearLayoutManager(r126.a));
            ((NoscrollRecycleView) r126.b.findViewById(2131379256)).setAdapter(r39);
            if (Intrinsics.areEqual(Locale.CHINESE.getLanguage(), ((i0) org.koin.java.a.c(i0.class, null, null, 6)).a()) == true) goto L230;
            ViewGroup.LayoutParams r40 = ((LinearLayout) r126.b.findViewById(2131374311)).getLayoutParams();
            r40.width = n.d(98);
            ((LinearLayout) r126.b.findViewById(2131374311)).setLayoutParams(r40);
            ViewGroup.LayoutParams r41 = ((NoscrollRecycleView) r126.b.findViewById(2131379259)).getLayoutParams();
            r41.width = n.d(98);
            ((NoscrollRecycleView) r126.b.findViewById(2131379259)).setLayoutParams(r41);
        L230:
            DataAdapter r42 = new DataAdapter(r126.d, -1, true, r126.f);
            r126.b.findViewById(2131374312).setLayoutManager(new LinearLayoutManager(r126.a, 0, false));
            r126.b.findViewById(2131374312).setAdapter(r42);
            return;
        L22:
            r8 = false;
            goto L23
        L18:
            r11 = false;
            goto L19
        L14:
            r7 = false;
            goto L15
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ h a;

        public c(h r1) {
            this.a = r1;
        }

        public final void accept(Object r8) {
            tt5.a.d("SecretDetailPresenter", "throw error" + ((Throwable) r8));
            d r9 = this.a.g;
            f r1 = null;
            if (r9 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("mControllerView");
            r9 = null;
        L5:
            r9.b.findViewById(2131378988).setVisibility(8);
            r9.b.findViewById(2131378988).cancelAnimation();
            d r10 = this.a.g;
            if (r10 != null) goto L8;
            Intrinsics.throwUninitializedPropertyAccessException("mControllerView");
            r10 = null;
        L8:
            ((LinearLayout) r10.b.findViewById(2131374518)).setVisibility(8);
            ((ScrollView) r10.b.findViewById(2131385224)).setVisibility(8);
            f r11 = this.a.f;
            if (r11 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            r11 = null;
        L11:
            i r3 = new i(this.a);
            r11.getClass();
            Intrinsics.checkNotNullParameter(r3, "listener");
            r11.h = r3;
            d r12 = this.a.g;
            if (r12 != null) goto L14;
            Intrinsics.throwUninitializedPropertyAccessException("mControllerView");
            r12 = null;
        L14:
            f r0 = this.a.f;
            if (r0 != null) goto L17;
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
        L18:
            String r2 = r1.a.getString(2131887360);
            String r4 = r1.a.getString(2131887361);
            SpannableString r5 = new SpannableString(r2 + r4);
            g r6 = new g(r1);
            ForegroundColorSpan r7 = new ForegroundColorSpan(r1.a.getResources().getColor(2131105548));
            r5.setSpan(r6, 0, r5.length(), 17);
            r5.setSpan(r7, r5.length() - r4.length(), r5.length(), 17);
            r12.getClass();
            Intrinsics.checkNotNullParameter(r5, "str");
            ((LinearLayout) r12.b.findViewById(2131378979)).setVisibility(0);
            ((TextView) r12.b.findViewById(2131372062)).setMovementMethod(LinkMovementMethod.getInstance());
            ((TextView) r12.b.findViewById(2131372062)).setText(r5);
            return;
        L17:
            r1 = r0;
            goto L18
        }
    }

    static {
    }

    public final void a() {
        d r0 = this.g;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mControllerView");
        r0 = null;
    L5:
        r0.b.findViewById(2131378988).setVisibility(0);
        r0.b.findViewById(2131378988).playAnimation();
        CompositeDisposable r1 = this.h;
        int r2 = p.a;
        r1.add(p.a(this.c, this.d).subscribe(new b(this), new c(this)));
    }

    public final Context getContext() {
        return this.a;
    }

    public final int getType() {
        return this.d;
    }

    public h(Context r2, View r3, String r4, int r5, jdb.g r6) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "mRootView");
        Intrinsics.checkNotNullParameter(r4, ResourceData.KEY_TOKEN);
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.h = new CompositeDisposable();
        this.f = new f(r2);
        this.g = new d(r2, r3);
        a();
    }
}
