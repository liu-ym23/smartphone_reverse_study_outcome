package com.bytedance.ee.bear.middleground.comment.control;

import android.app.Dialog;
import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.comment.Comment;
import com.bytedance.ee.bear.middleground.comment.card.p1;
import com.bytedance.ee.bear.middleground.comment.export.CommentStyle;
import com.bytedance.ee.bear.middleground.comment.export.ICardAdapter;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentAction;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.DataEntity;
import com.bytedance.ee.bear.middleground.comment.export.bean.Reaction;
import com.bytedance.ee.bear.middleground.comment.export.bean.RevisionExtra;
import com.bytedance.ee.bear.middleground.comment.export.bean.TranslateConfig;
import com.bytedance.ee.bear.middleground.comment.extension.events.ReactionCacheActionType;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.supervisor.token.Token;
import com.larksuite.component.ui.dialog.LKUIDialog;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.ui.BasePopupWindow;
import com.larksuite.framework.utils.UIUtils;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.reaction.widget.detailwindow.ReactionPopupFacade;
import com.ss.android.lark.reaction.widget.detailwindow.bean.ReactionDetailViewModel;
import com.ss.android.lark.reaction.widget.panel.ReactionPanelFacade;
import com.ss.android.lark.utils.StatusBarUtil;
import ef5.e0;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class CommentFunction implements com.bytedance.ee.bear.middleground.comment.control.y {
    public final com.bytedance.ee.bear.middleground.comment.uitls.p a;
    public final com.bytedance.ee.bear.middleground.comment.control.z b;
    public final com.bytedance.ee.bear.middleground.comment.control.t c;
    public final String d;
    public final String e;
    public float f;
    public final Function0<Unit> g;
    public PopupWindow h;
    public sa5.b i;
    public Dialog j;
    public final e k;
    public final Map<String, List<q2c.c>> l;
    public com.bytedance.ee.bear.middleground.comment.detail.c m;
    public long n;

    public static abstract class a implements ReactionPanelFacade.b {
        public a() {
        }

        public final void b() {
        }
    }

    public static final class a0 implements ReactionPanelFacade.b {
        public final /* synthetic */ CommentFunction a;
        public final /* synthetic */ CommentBean.CommentDetail b;
        public final /* synthetic */ View c;

        public a0(CommentFunction r1, CommentBean.CommentDetail r2, View r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final /* synthetic */ void b() {
        }

        public final void a(String r3, int r4) {
            CommentFunction r5 = this.a;
            Intrinsics.checkNotNull(r3);
            r5.s(r3, this.b, this.c);
        }
    }

    public static final class b {
    }

    public static final class b0 implements com.bytedance.ee.bear.middleground.comment.control.b0 {
        public final /* synthetic */ CommentFunction a;
        public final /* synthetic */ ICardAdapter b;
        public final /* synthetic */ int c;
        public final /* synthetic */ List<com.ss.android.lark.reaction.widget.panel.e> d;
        public final /* synthetic */ CommentBean.CommentDetail e;
        public final /* synthetic */ View f;
        public final /* synthetic */ int g;

        public static final class a<T> implements FlowableOnSubscribe {
            public final /* synthetic */ View a;
            public final /* synthetic */ List<com.ss.android.lark.reaction.widget.panel.e> b;
            public final /* synthetic */ CommentFunction c;
            public final /* synthetic */ com.bytedance.ee.bear.middleground.comment.export.bean.b d;
            public final /* synthetic */ CommentBean e;

            public a(View r1, List<com.ss.android.lark.reaction.widget.panel.e> r2, CommentFunction r3, com.bytedance.ee.bear.middleground.comment.export.bean.b r4, CommentBean r5) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
                this.d = r4;
                this.e = r5;
            }

            public final void subscribe(FlowableEmitter<ReactionPanelFacade.a> r5) {
                Intrinsics.checkNotNullParameter(r5, "e");
                ReactionPanelFacade.a r0 = new ReactionPanelFacade.a(this.a);
                r0.f = false;
                r0.k = true;
                r0.l = ReactionPanelFacade.ReactionScene.CCM;
                List<com.ss.android.lark.reaction.widget.panel.e> r1 = this.b;
                if (r1 == null) goto L5;
                ((ArrayList) r0.d).clear();
                ((ArrayList) r0.d).addAll(r1);
            L5:
                r0.c = this.c.O(this.d, this.e);
                r5.onNext(r0);
                r5.onComplete();
            }
        }

        public static final class b<T, R> implements Function {
            public final /* synthetic */ CommentFunction a;
            public final /* synthetic */ com.bytedance.ee.bear.middleground.comment.export.bean.b b;
            public final /* synthetic */ CommentBean c;
            public final /* synthetic */ Ref.ObjectRef<List<String>> d;
            public final /* synthetic */ ICardAdapter e;
            public final /* synthetic */ CommentBean.CommentDetail f;
            public final /* synthetic */ View g;

            public b(CommentFunction r1, com.bytedance.ee.bear.middleground.comment.export.bean.b r2, CommentBean r3, Ref.ObjectRef<List<String>> r4, ICardAdapter r5, CommentBean.CommentDetail r6, View r7) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
                this.d = r4;
                this.e = r5;
                this.f = r6;
                this.g = r7;
            }

            public final Object apply(Object r8) {
                ReactionPanelFacade.a r1 = (ReactionPanelFacade.a) r8;
                Intrinsics.checkNotNullParameter(r1, "build");
                if (this.a.O(this.b, this.c) == false) goto L6;
                return Flowable.just("").subscribeOn(fo5.d.b()).map(com.bytedance.ee.bear.middleground.comment.control.l.a).map(new com.bytedance.ee.bear.middleground.comment.control.m(this.d)).map(new com.bytedance.ee.bear.middleground.comment.control.o(r1, this.a, this.e, this.f, this.g));
            L6:
                return Flowable.just(r1);
            }
        }

        public static final class c<T> implements Consumer {
            public final /* synthetic */ CommentFunction a;
            public final /* synthetic */ CommentBean.CommentDetail b;
            public final /* synthetic */ List<com.ss.android.lark.reaction.widget.panel.e> c;
            public final /* synthetic */ Ref.ObjectRef<List<String>> d;
            public final /* synthetic */ int e;
            public final /* synthetic */ ICardAdapter f;

            public c(CommentFunction r1, CommentBean.CommentDetail r2, List<com.ss.android.lark.reaction.widget.panel.e> r3, Ref.ObjectRef<List<String>> r4, int r5, ICardAdapter r6) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
                this.d = r4;
                this.e = r5;
                this.f = r6;
            }

            public final void accept(Object r12) {
                ReactionPanelFacade r13 = ((ReactionPanelFacade.a) r12).a();
                CommentFunction r1 = this.a;
                r13.r = new com.bytedance.ee.bear.middleground.comment.control.p(r1);
                r1.a.N.a(new e0(this.b.getReply_id()));
                CommentFunction r0 = this.a;
                com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.g r2 = com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.g.a;
                FragmentActivity r3 = r0.a.getActivity();
                Fragment r4 = this.a.a.b;
                r2.getClass();
                r0.i = com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.g.a(r3, r4);
                CommentFunction r5 = this.a;
                sa5.b r6 = r5.i;
                if (r6 == null) goto L5;
                r6.e(r5.k);
            L5:
                int r7 = v2c.a.d(this.a.a.getActivity());
                if (this.a.f <= (r7 / 2)) goto L8;
                boolean r8 = true;
            L10:
                if (this.c.size() > 3) goto L20;
                Collection r9 = (Collection) this.d.element;
                if (r9 != null) goto L14;
            L17:
                boolean r10 = true;
            L18:
                if (r10 == false) goto L20;
            L25:
                int r11 = this.e;
            L26:
                if (r8 == false) goto L28;
                int r14 = 80;
            L30:
                if (r11 != 5) goto L32;
                int r15 = com.bytedance.ee.util.ui.n.d(20);
            L34:
                if (r8 == false) goto L36;
                float r16 = r7 - this.a.f;
                int r17 = v2c.a.a(eu5.b.a, 22.0f);
            L37:
                int r18 = (int) (r16 + r17);
                CommentFunction r19 = this.a;
                if (r19.a.n.isAside() == false) goto L40;
                BasePopupWindow r110 = r13.g(r8, r14 | 5, r15, r18);
            L41:
                r19.h = r110;
                this.a.a.d0.d("show_reaction_panel", null, this.f.getCommentId(this.b), this.b.getReply_id(), false);
                com.bytedance.ee.bear.middleground.comment.uitls.h r111 = this.a.a.d0;
                String r20 = this.f.getCommentId(this.b);
                String r21 = this.b.getReply_id();
                Pair[] r22 = new Pair[2];
                if (this.a.a.V == false) goto L44;
                String r23 = "discussion";
            L45:
                r22[0] = TuplesKt.to(ResourceData.KEY_TYPE, r23);
                CommentBean r24 = this.a.c.N(this.b.getComment_id());
                if (r24 == null) goto L50;
                CommentBean.Extra r25 = r24.getExtra();
                if (r25 == null) goto L50;
                String r26 = r25.getReportVisibility();
            L51:
                r22[1] = TuplesKt.to("comment_visible_range", r26);
                r111.g("reaction_comment_panel", r20, r21, MapsKt.mapOf(r22));
                return;
            L50:
                r26 = null;
                goto L51
            L44:
                r23 = "comment";
                goto L45
            L40:
                r110 = r13.g(r8, r11 | r14, r15, r18);
                goto L41
            L36:
                r16 = this.a.f;
                r17 = v2c.a.a(eu5.b.a, 22.0f);
                goto L37
            L32:
                r15 = 0;
                goto L34
            L28:
                r14 = 48;
                goto L30
            L14:
                if (r9.isEmpty() == true) goto L17;
                r10 = false;
            L20:
                if (ku5.c.k(this.a.a.getActivity()) == true) goto L25;
                if (com.bytedance.ee.util.ui.n.C(this.a.a.getActivity()) == true) goto L25;
                r11 = 1;
                goto L26
            L8:
                r8 = false;
                goto L10
            }
        }

        public static final class d<T> implements Consumer {
            public static final d<T> a = null;

            static {
                a = new d();
            }

            public d() {
            }

            public final void accept(Object r4) {
                tt5.a.e("Comment#CommentFunction", "showReaction fail:", (Throwable) r4, false);
            }
        }

        @Override // com.bytedance.ee.bear.middleground.comment.control.b0
        public final void a(com.bytedance.ee.bear.middleground.comment.export.bean.b r27) {
            Intrinsics.checkNotNullParameter(r27, "permission");
            if (this.a.a.getActivity().getResources().getConfiguration().orientation == 2) goto L5;
        L10:
            boolean r2 = true;
        L11:
            CommentBean r8 = this.b.getData();
            if (r27.b == false) goto L23;
            if (r2 == false) goto L23;
            this.a.a.h.getClass();
            if (com.bytedance.ee.bear.middleground.comment.p.c() == true) goto L23;
            if (r8.isActionBlocked(CommentAction.REPLY_IN_MORE) == true) goto L23;
            CommentFunction r6 = this.a;
            ICardAdapter r12 = this.b;
            int r13 = this.c;
            List<com.ss.android.lark.reaction.widget.panel.e> r14 = this.d;
            r6.getClass();
            Intrinsics.checkNotNullParameter(r12, "cardAdapter");
            Intrinsics.checkNotNullParameter(r14, "menuList");
            CommentBean.CommentDetail r15 = (CommentBean.CommentDetail) CollectionsKt.getOrNull(r12.getCommentDetails(), r13);
            if (r15 != null) goto L21;
            tt5.a.k("Comment#CommentFunction", "addReplyItem commentDetail is null");
            goto L23
        L21:
            r14.add(new com.ss.android.lark.reaction.widget.panel.e(eu5.b.a.getText(2131887628).toString(), com.bytedance.ee.bear.middleground.comment.uitls.s.a("REPLY"), new com.bytedance.ee.bear.middleground.comment.control.f(r15, r12, r6, r6.a)));
        L23:
            CommentFunction r3 = this.a;
            ICardAdapter r4 = this.b;
            r3.getClass();
            Intrinsics.checkNotNullParameter(r4, "cardAdapter");
            if (r4.getData().getCommentType() != 2) goto L26;
            boolean r5 = true;
        L28:
            if (this.e.getReplyType() != 2) goto L30;
            boolean r7 = true;
        L32:
            if (TextUtils.isEmpty(this.e.getContent()) == true) goto L47;
            CommentFunction r9 = this.a;
            r9.getClass();
            Intrinsics.checkNotNullParameter(r27, "permission");
            if (r27.c == false) goto L36;
            tt5.a.h("Comment#CommentFunction", "escaped");
        L43:
            boolean r10 = true;
        L45:
            if (r10 == false) goto L47;
            CommentFunction r11 = this.a;
            View r16 = this.f;
            List<com.ss.android.lark.reaction.widget.panel.e> r17 = this.d;
            r11.getClass();
            Intrinsics.checkNotNullParameter(r16, "view");
            Intrinsics.checkNotNullParameter(r17, "menuList");
            Intrinsics.checkNotNullParameter(r27, "permission");
            r17.add(new com.ss.android.lark.reaction.widget.panel.e(eu5.b.a.getString(2131887612), com.bytedance.ee.bear.middleground.comment.uitls.s.a("COPY"), new com.bytedance.ee.bear.middleground.comment.control.b(r27, r11, (TextView) r16.findViewById(2131390392), r11.a)));
        L48:
            if (r7 == false) goto L50;
        L55:
            if (r5 == true) goto L65;
            if (r7 == true) goto L65;
            if (r27.d == false) goto L65;
            CommentFunction r1 = this.a;
            if (r1.a.n == CommentStyle.HALF_SCREEN) goto L65;
            ICardAdapter r18 = this.b;
            int r19 = this.c;
            List<com.ss.android.lark.reaction.widget.panel.e> r20 = this.d;
            Intrinsics.checkNotNullParameter(r18, "cardAdapter");
            Intrinsics.checkNotNullParameter(r20, "menuList");
            CommentBean.CommentDetail r21 = (CommentBean.CommentDetail) CollectionsKt.getOrNull(r18.getCommentDetails(), r19);
            if (r21 != null) goto L64;
            tt5.a.k("Comment#CommentFunction", "addRelatedKnowledgeItem commentDetail is null");
            goto L65
        L64:
            r20.add(new com.ss.android.lark.reaction.widget.panel.e(eu5.b.a.getString(2131888967), com.bytedance.ee.bear.middleground.comment.uitls.s.a("RELATED_KNOWLEDGE"), new com.bytedance.ee.bear.middleground.comment.control.e(r21, r1, r18.getCommentId(r21), r18.findReplyIdByPosition(r19), r1.a)));
        L65:
            Map<String, Boolean> r22 = nf5.a.a;
            TranslateConfig r23 = this.a.a.x;
            CommentBean.CommentDetail r24 = this.e;
            Intrinsics.checkNotNullParameter(r23, "config");
            Intrinsics.checkNotNullParameter(r24, "item");
            if (nf5.a.b(r23, r24.getReply_id(), r24.getTranslate_status(), r24.getContent()) == false) goto L68;
        L73:
            CommentFunction r25 = this.a;
            ICardAdapter r26 = this.b;
            CommentBean.CommentDetail r28 = this.e;
            int r110 = this.c;
            List<com.ss.android.lark.reaction.widget.panel.e> r111 = this.d;
            r25.getClass();
            Intrinsics.checkNotNullParameter(r26, "cardAdapter");
            Intrinsics.checkNotNullParameter(r28, "item");
            Intrinsics.checkNotNullParameter(r111, "menuList");
            Ref.BooleanRef r112 = new Ref.BooleanRef();
            TranslateConfig r113 = r25.a.x;
            Intrinsics.checkNotNullParameter(r113, "config");
            Intrinsics.checkNotNullParameter(r28, "item");
            if (nf5.a.b(r113, r28.getReply_id(), r28.getTranslate_status(), r28.getContent()) == false) goto L77;
            r112.element = true;
            String r29 = eu5.b.a.getString(2131887626);
        L80:
            Intrinsics.checkNotNull(r29);
            r111.add(new com.ss.android.lark.reaction.widget.panel.e(r29, com.bytedance.ee.bear.middleground.comment.uitls.s.a("TRANSLATE"), new com.bytedance.ee.bear.middleground.comment.control.i(r112, r28, r26, r110, r25, r25.a)));
        L81:
            if (r7 == true) goto L114;
            CommentFunction r30 = this.a;
            String r31 = this.e.getUser_id();
            if (r30.a.q.d() == true) goto L85;
            tt5.a.h("Comment#CommentFunction", "per delete is false");
        L105:
            boolean r32 = false;
        L109:
            if (r32 == false) goto L114;
            if (this.e.getReplyType() == 2) goto L114;
            CommentFunction r33 = this.a;
            ICardAdapter r34 = this.b;
            CommentBean.CommentDetail r35 = this.e;
            List<com.ss.android.lark.reaction.widget.panel.e> r36 = this.d;
            r33.getClass();
            Intrinsics.checkNotNullParameter(r34, "cardAdapter");
            Intrinsics.checkNotNullParameter(r35, "commentDetail");
            Intrinsics.checkNotNullParameter(r36, "menuList");
            r36.add(new com.ss.android.lark.reaction.widget.panel.e(eu5.b.a.getString(2131887736), com.bytedance.ee.bear.middleground.comment.uitls.s.a("DELETE"), new com.bytedance.ee.bear.middleground.comment.control.d(r33, r35, r33.a)));
            goto L114
        L85:
            boolean r37 = com.bytedance.ee.bear.appsetting.c.a.a.h("ccm.comment.delete_permission");
            tt5.a.h("Comment#CommentFunction", "canDeleteComment fg =" + r37);
            if (r37 == true) goto L88;
            r32 = r30.l(r31);
            goto L109
        L88:
            if (r30.l(r31) == true) goto L107;
            com.bytedance.ee.bear.middleground.comment.export.v r38 = r30.a.H;
            if (r38 == null) goto L94;
            boolean r39 = true;
            if (r38.isOwner() != true) goto L95;
            boolean r40 = true;
        L96:
            if (r40 == true) goto L107;
            com.bytedance.ee.bear.middleground.comment.export.v r41 = r30.a.H;
            if (r41 != null) goto L100;
        L102:
            boolean r42 = false;
        L103:
            if (r42 == false) goto L105;
        L100:
            if (r41.a() != r39) goto L102;
            r42 = true;
        L95:
            r40 = false;
            goto L96
        L94:
            r39 = true;
        L107:
            r32 = true;
        L114:
            com.bytedance.ee.bear.appsetting.c r43 = com.bytedance.ee.bear.appsetting.c.a.a;
            boolean r44 = r43.h("ccm.comment.reslove_permission_v2");
            boolean r210 = this.a.t(this.e.getUser_id(), this.e.getParticipantList());
            CommentFunction r45 = this.a;
            com.bytedance.ee.bear.middleground.comment.uitls.p r46 = r45.a;
            if (r46.u == true) goto L125;
            if (r5 == true) goto L125;
            if (r46.o != 0) goto L120;
            boolean r114 = true;
        L121:
            if (r114 == false) goto L125;
            if (r44 == true) goto L124;
            if (r210 == false) goto L125;
        L124:
            r45.L(this.b, this.c, false, this.d, r210);
            goto L125
        L120:
            r114 = false;
        L125:
            boolean r47 = r43.h("lark.tns.ccm_comment_report_appeal");
            if (r27.e == false) goto L136;
            if (this.a.a.X.n() == false) goto L136;
            if (r7 == true) goto L136;
            if (r47 == false) goto L136;
            CommentFunction r48 = this.a;
            ICardAdapter r49 = this.b;
            int r50 = this.c;
            List<com.ss.android.lark.reaction.widget.panel.e> r51 = this.d;
            r48.getClass();
            Intrinsics.checkNotNullParameter(r49, "cardAdapter");
            Intrinsics.checkNotNullParameter(r51, "menuList");
            CommentBean.CommentDetail r52 = (CommentBean.CommentDetail) CollectionsKt.getOrNull(r49.getCommentDetails(), r50);
            if (r52 != null) goto L134;
            tt5.a.d("Comment#CommentFunction", "addReportItem but commentDetail is null");
            goto L136
        L134:
            r51.add(new com.ss.android.lark.reaction.widget.panel.e(eu5.b.a.getText(2131889730).toString(), com.bytedance.ee.bear.middleground.comment.uitls.s.a("REPORT"), new com.bytedance.ee.bear.middleground.comment.control.g(r49, r52, r48.a)));
        L136:
            if (this.d.isEmpty() == false) goto L141;
            CommentBean r53 = r8;
            if (this.a.O(r27, r53) == true) goto L142;
            tt5.a.h("Comment#CommentFunction", "no reaction show toast");
            Toast.showFailureText(this.f.getContext(), 2131889892);
            return;
        L142:
            PopupWindow r54 = this.a.h;
            if (r54 == null) goto L145;
            PopupWindowLancet.handleDismissBeforeOrigin(r54);
            r54.dismiss();
        L145:
            Ref.ObjectRef r115 = new Ref.ObjectRef();
            Flowable.create(new a(this.f, this.d, this.a, r27, r53), BackpressureStrategy.BUFFER).flatMap(new b(this.a, r27, r53, r115, this.b, this.e, this.f)).observeOn(fo5.d.d()).subscribe(new c(this.a, this.e, this.d, r115, this.g, this.b), d.a);
            return;
        L141:
            r53 = r8;
            goto L142
        L77:
            if (nf5.a.c(r25.a.x, r28) == false) goto L79;
            r29 = eu5.b.a.getString(2131887627);
            goto L80
        L79:
            r29 = eu5.b.a.getString(2131887635);
            goto L80
        L68:
            if (nf5.a.c(this.a.a.x, this.e) == true) goto L73;
            TranslateConfig r55 = this.a.a.x;
            CommentBean.CommentDetail r56 = this.e;
            Intrinsics.checkNotNullParameter(r55, "config");
            Intrinsics.checkNotNullParameter(r56, "item");
            if (nf5.a.e(r55, r56.getReply_id(), r56.getTranslate_status(), r56.getContent()) == false) goto L81;
        L50:
            if (this.a.l(this.e.getUser_id()) == false) goto L55;
            if (r27.b == false) goto L55;
            if (r2 == false) goto L55;
            com.bytedance.ee.bear.middleground.comment.control.z r57 = this.a.b;
            Intrinsics.checkNotNull(r57, "null cannot be cast to non-null type com.bytedance.ee.bear.middleground.comment.Comment");
            int r58 = this.c;
            ((Comment) r57).D = r58;
            this.a.K(this.b, r58, this.d);
            goto L55
        L36:
            ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
            if (jg5.e.a.a.g() == false) goto L39;
            com.bytedance.ee.bear.middleground.comment.uitls.p r59 = r9.a;
            boolean r60 = r59.S.c(r59.k.b, r59.i, "CONTENT_COPY").getAllow();
        L40:
            if (r60 == true) goto L42;
        L44:
            r10 = false;
            goto L45
        L42:
            if (r27.a == false) goto L44;
        L39:
            com.bytedance.ee.bear.middleground.comment.uitls.p r61 = r9.a;
            r60 = r61.S.e(r61.k.b, r61.i).a;
        L47:
            tt5.a.h("Comment#CommentFunction", "no text or no perm no copy button");
            goto L48
        L30:
            r7 = false;
            goto L32
        L26:
            r5 = false;
            goto L28
        L5:
            if (ku5.c.k(this.a.a.getActivity()) == true) goto L10;
            if (this.a.a.C == true) goto L10;
            r2 = false;
            goto L11
        }

        public b0(CommentFunction r1, ICardAdapter r2, int r3, List<com.ss.android.lark.reaction.widget.panel.e> r4, CommentBean.CommentDetail r5, View r6, int r7) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
        }
    }

    public static final class c implements com.ss.android.lark.reaction.widget.panel.e.b {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ CommentFunction b;

        public final void onClick() {
        }

        public final void onHide() {
        }

        public final void onShow() {
        }

        public final void onViewCreated() {
        }

        public final boolean b() {
            UDToast.show(this.b.a.getActivity(), 2131889183);
            this.b.h();
            return this.a;
        }

        public final boolean a() {
            return this.a;
        }

        public c(boolean r1, CommentFunction r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class d extends c0 {
        public final /* synthetic */ boolean c;
        public final /* synthetic */ CommentFunction d;
        public final /* synthetic */ CommentBean.CommentDetail e;
        public final /* synthetic */ boolean f;

        @Override // com.bytedance.ee.bear.middleground.comment.control.c0
        public final void a(View r9) {
            Intrinsics.checkNotNullParameter(r9, "view");
            super.a(r9);
            if (this.c == true) goto L5;
            return;
        L5:
            CommentFunction r0 = this.d;
            String r10 = this.e.getComment_id();
            if (r10 != null) goto L8;
            r10 = "";
        L8:
            String r1 = r10;
            int r2 = this.e.getCommentType();
            boolean r3 = this.e.isWholeComment();
            boolean r4 = true;
            if (this.e.getCommentType() == 1) goto L12;
            r4 = false;
        L12:
            com.bytedance.ee.bear.middleground.comment.control.x.a(r0, r1, r2, r3, r4, this.f, null, 32);
        }

        public d(boolean r1, CommentFunction r2, CommentBean.CommentDetail r3, boolean r4, com.bytedance.ee.bear.middleground.comment.uitls.p r5) {
            this.c = r1;
            this.d = r2;
            this.e = r3;
            this.f = r4;
            super(r5, "RESOLVE");
        }
    }

    public static final class e implements sa5.d {
        public final /* synthetic */ CommentFunction a;

        public e(CommentFunction r1) {
            this.a = r1;
        }

        public final boolean onBackPressed() {
            PopupWindow r0 = this.a.h;
            if (r0 != null) goto L5;
        L7:
            boolean r1 = false;
        L8:
            if (r1 == false) goto L13;
            PopupWindow r2 = this.a.h;
            if (r2 == null) goto L12;
            PopupWindowLancet.handleDismissBeforeOrigin(r2);
            r2.dismiss();
        L12:
            return true;
        L13:
            return false;
        L5:
            if (r0.isShowing() != true) goto L7;
            r1 = true;
            goto L8
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ String a;
        public final /* synthetic */ CommentBean.CommentDetail b;
        public final /* synthetic */ CommentFunction c;

        public f(String r1, CommentBean.CommentDetail r2, CommentFunction r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r4) {
            String r5 = (String) r4;
            HashMap r6 = new HashMap();
            JSONObject r0 = new JSONObject();
            r0.put("value1", Boolean.FALSE);
            r0.put("value2", this.a);
            r0.put("value3", this.b.getComment_id());
            r0.put("value4", this.b.getComment_id());
            r6.put("action_value", r0.toJSONString());
            this.c.a.d0.o("reaction", this.b.getComment_id(), r6);
            tt5.a.h("Comment#CommentFunction", "clickContentReaction delete Reaction: " + this.a + " succeed!");
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ String a;

        public g(String r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            tt5.a.e("Comment#CommentFunction", "clickContentReaction delete Reaction: " + this.a + " failed!", (Throwable) r4, false);
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ String a;
        public final /* synthetic */ CommentBean.CommentDetail b;
        public final /* synthetic */ CommentFunction c;
        public final /* synthetic */ View d;

        public h(String r1, CommentBean.CommentDetail r2, CommentFunction r3, View r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void accept(Object r4) {
            String r5 = (String) r4;
            ((com.bytedance.ee.bear.contract.x) org.koin.java.a.c(com.bytedance.ee.bear.contract.x.class, null, null, 6)).q(this.a, new CommentFunction$clickContentReaction$3$1());
            HashMap r6 = new HashMap();
            JSONObject r0 = new JSONObject();
            r0.put("value1", Boolean.TRUE);
            r0.put("value2", this.a);
            r0.put("value3", this.b.getComment_id());
            r0.put("value4", this.b.getComment_id());
            r6.put("action_value", r0.toJSONString());
            this.c.a.d0.o("reaction", this.b.getComment_id(), r6);
            View r7 = this.d;
            if (r7 == null) goto L5;
            this.c.b.d0().invoke(r7);
        L5:
            tt5.a.h("Comment#CommentFunction", "clickContentReaction add Reaction: " + this.a + " succeed!");
        }
    }

    public static final class i<T> implements Consumer {
        public final /* synthetic */ String a;

        public i(String r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            tt5.a.e("Comment#CommentFunction", "clickContentReaction add Reaction: " + this.a + " failed!", (Throwable) r4, false);
        }
    }

    public static final class j<T> implements Consumer {
        public final /* synthetic */ CommentBean.CommentDetail a;
        public final /* synthetic */ String b;
        public final /* synthetic */ CommentFunction c;
        public final /* synthetic */ ICardAdapter d;

        public j(CommentBean.CommentDetail r1, String r2, CommentFunction r3, ICardAdapter r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        /* JADX WARN: Multi-variable type inference failed */
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
        public final void accept(Object r12) {
            String r13 = (String) r12;
            Object r0 = null;
            if (this.a.getCommentType() != 2) goto L10;
            Map<String, String> r10 = MapsKt.mutableMapOf(new Pair[]{new Pair("emoji", this.b)});
            com.bytedance.ee.bear.middleground.comment.uitls.h r5 = this.c.a.d0;
            String r7 = this.d.getCommentId(this.a);
            String r8 = this.a.getReply_id();
            CommentBean.Extra r14 = this.d.getData().getExtra();
            if (r14 == null) goto L9;
            RevisionExtra r15 = r14.getRevisionExtra();
            if (r15 == null) goto L9;
            r0 = r15.getRevisionTag();
        L9:
            r5.r("cancel_reaction_comment", r7, r8, r0, r10);
        L20:
            tt5.a.h("Comment#CommentFunction", "delete Reaction: " + this.b + " succeed!");
            return;
        L10:
            Pair[] r16 = new Pair[3];
            r16[0] = new Pair("emoji", this.b);
            if (this.c.a.V == false) goto L13;
            String r2 = "discussion";
        L14:
            r16[1] = TuplesKt.to(ResourceData.KEY_TYPE, r2);
            CommentBean r1 = this.c.c.N(this.a.getComment_id());
            if (r1 == null) goto L19;
            CommentBean.Extra r3 = r1.getExtra();
            if (r3 == null) goto L19;
            r0 = r3.getReportVisibility();
        L19:
            r16[2] = TuplesKt.to("comment_visible_range", r0);
            this.c.a.d0.g("cancel_reaction_comment", this.d.getCommentId(this.a), this.a.getReply_id(), MapsKt.mutableMapOf(r16));
            goto L20
        L13:
            r2 = "comment";
            goto L14
        }
    }

    public static final class k<T> implements Consumer {
        public final /* synthetic */ CommentFunction a;
        public final /* synthetic */ String b;

        public k(CommentFunction r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r5) {
            Toast.showText(this.a.a.getActivity(), "delete Reaction: " + this.b + "failed!!", 0);
            tt5.a.e("Comment#CommentFunction", "delete Reaction: " + this.b + " failed!", (Throwable) r5, false);
        }
    }

    public static final class l<T> implements Consumer {
        public final /* synthetic */ ICardAdapter a;
        public final /* synthetic */ String b;
        public final /* synthetic */ CommentFunction c;
        public final /* synthetic */ CommentBean.CommentDetail d;
        public final /* synthetic */ View e;

        public l(ICardAdapter r1, String r2, CommentFunction r3, CommentBean.CommentDetail r4, View r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        /* JADX WARN: Multi-variable type inference failed */
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
        public final void accept(Object r12) {
            String r13 = (String) r12;
            Object r0 = null;
            if (this.a.getData().getCommentType() != 2) goto L10;
            Map<String, String> r10 = MapsKt.mutableMapOf(new Pair[]{new Pair("emoji", this.b)});
            com.bytedance.ee.bear.middleground.comment.uitls.h r5 = this.c.a.d0;
            String r7 = this.a.getCommentId(this.d);
            String r8 = this.d.getReply_id();
            CommentBean.Extra r14 = this.a.getData().getExtra();
            if (r14 == null) goto L9;
            RevisionExtra r15 = r14.getRevisionExtra();
            if (r15 == null) goto L9;
            r0 = r15.getRevisionTag();
        L9:
            r5.r("reaction_comment", r7, r8, r0, r10);
        L20:
            View r16 = this.e;
            if (r16 == null) goto L23;
            this.c.b.d0().invoke(r16);
        L23:
            tt5.a.h("Comment#CommentFunction", "add Reaction: " + this.b + " succeed!");
            return;
        L10:
            Pair[] r17 = new Pair[3];
            r17[0] = new Pair("emoji", this.b);
            if (this.c.a.V == false) goto L13;
            String r2 = "discussion";
        L14:
            r17[1] = TuplesKt.to(ResourceData.KEY_TYPE, r2);
            CommentBean r1 = this.c.c.N(this.d.getComment_id());
            if (r1 == null) goto L19;
            CommentBean.Extra r3 = r1.getExtra();
            if (r3 == null) goto L19;
            r0 = r3.getReportVisibility();
        L19:
            r17[2] = TuplesKt.to("comment_visible_range", r0);
            this.c.a.d0.g("reaction_comment", this.a.getCommentId(this.d), this.d.getReply_id(), MapsKt.mutableMapOf(r17));
            goto L20
        L13:
            r2 = "comment";
            goto L14
        }
    }

    public static final class m<T> implements Consumer {
        public final /* synthetic */ String a;

        public m(String r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            tt5.a.e("Comment#CommentFunction", "add Reaction: " + this.a + " failed!", (Throwable) r4, false);
        }
    }

    public static final class n<T, R> implements Function {
        public static final n<T, R> a = null;

        static {
            a = new n();
        }

        public n() {
        }

        public final Object apply(Object r3) {
            Intrinsics.checkNotNullParameter((String) r3, "it");
            return (com.bytedance.ee.bear.contract.x) org.koin.java.a.c(com.bytedance.ee.bear.contract.x.class, null, null, 6);
        }
    }

    public static final class o<T, R> implements Function {
        public final /* synthetic */ String a;

        public o(String r1) {
            this.a = r1;
        }

        public final Object apply(Object r3) {
            com.bytedance.ee.bear.contract.x r4 = (com.bytedance.ee.bear.contract.x) r3;
            Intrinsics.checkNotNullParameter(r4, "hostService");
            r4.q(this.a, new CommentFunction$clickReaction$d$2$1());
            return "";
        }
    }

    public static final class p<T> implements Consumer {
        public static final p<T> a = null;

        static {
            a = new p();
        }

        public p() {
        }

        public final void accept(Object r2) {
            String r3 = (String) r2;
            tt5.a.b("Comment#CommentFunction", "hostService updateOrder success ");
        }
    }

    public static final class q<T> implements Consumer {
        public static final q<T> a = null;

        static {
            a = new q();
        }

        public q() {
        }

        public final void accept(Object r4) {
            tt5.a.e("Comment#CommentFunction", "hostService updateOrder fail", (Throwable) r4, false);
        }
    }

    public static final class r<T> implements Consumer {
        public final /* synthetic */ CommentFunction a;
        public final /* synthetic */ String b;

        public r(CommentFunction r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r5) {
            String r6 = (String) r5;
            DataEntity r0 = (DataEntity) JSON.parseObject(r6, DataEntity.class);
            if (r0 == null) goto L9;
            DataEntity.Entity r1 = r0.getData();
            if (r1 == null) goto L9;
            DataEntity.Entity.BodyEntity r2 = r1.getBody();
            if (r2 == null) goto L9;
            int r3 = r2.getCode();
        L11:
            if (r3 != 0) goto L13;
            this.a.e(r0.getData().getBody().getData());
            tt5.a.h("Comment#CommentFunction", "get ReactionDetail: " + this.b + " succeed!");
            return;
        L13:
            tt5.a.d("Comment#CommentFunction", "get ReactionDetail: " + this.b + " failed! result = " + r6);
            return;
        L9:
            r3 = -1;
            goto L11
        }
    }

    public static final class s<T> implements Consumer {
        public final /* synthetic */ String a;

        public s(String r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            tt5.a.e("Comment#CommentFunction", "get ReactionDetail: " + this.a + " exception!", (Throwable) r4, false);
        }
    }

    public static final class t implements ReactionPopupFacade.c {
        public final /* synthetic */ CommentFunction a;

        public t(CommentFunction r1) {
            this.a = r1;
        }

        public final void a(String r2) {
            com.bytedance.ee.bear.middleground.comment.control.z r0 = this.a.b;
            if (r0 == null) goto L8;
            Function1<String, Unit> r1 = r0.s0();
            if (r1 == null) goto L9;
            r1.invoke(r2);
            return;
        L9:
            return;
        }
    }

    public static final class u implements DialogInterface.OnDismissListener {
        public final /* synthetic */ CommentFunction a;
        public final /* synthetic */ CommentBean.CommentDetail b;

        public static final class a<T> implements Consumer {
            public static final a<T> a = null;

            static {
                a = new a();
            }

            public a() {
            }

            public final void accept(Object r2) {
                String r3 = (String) r2;
                tt5.a.h("Comment#CommentFunction", "setDetailPanelStatus: status0 succeed!");
            }
        }

        public static final class b<T> implements Consumer {
            public static final b<T> a = null;

            static {
                a = new b();
            }

            public b() {
            }

            public final void accept(Object r4) {
                tt5.a.e("Comment#CommentFunction", "setDetailPanelStatus: status0 failed!", (Throwable) r4, false);
            }
        }

        public u(CommentFunction r1, CommentBean.CommentDetail r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface r4) {
            this.a.c.F(0, "", "").subscribe(a.a, b.a);
            this.a.a.d0.p("exit", this.b.getComment_id(), null);
        }
    }

    public static final class v implements ReactionPopupFacade.d {
        public final /* synthetic */ Ref.IntRef a;
        public final /* synthetic */ CommentBean.CommentDetail b;
        public final /* synthetic */ CommentFunction c;

        public v(Ref.IntRef r1, CommentBean.CommentDetail r2, CommentFunction r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void a(int r5) {
            int r0 = this.a.element;
            if (r0 == r5) goto L11;
            if (r0 < 0) goto L11;
            if (this.b.getReactionDetailData().size() <= this.a.element) goto L11;
            if (r5 < 0) goto L11;
            if (this.b.getReactionDetailData().size() <= r5) goto L11;
            HashMap r1 = new HashMap();
            r1.put("emoji_type_before", ((ReactionDetailViewModel) ListProtector.get(this.b.getReactionDetailData(), this.a.element)).getReactionKey());
            r1.put("emoji_type_after", ((ReactionDetailViewModel) ListProtector.get(this.b.getReactionDetailData(), r5)).getReactionKey());
            this.c.a.d0.p("switch_emoji", this.b.getComment_id(), r1);
        L11:
            this.a.element = r5;
        }
    }

    public static final class w<T> implements Consumer {
        public static final w<T> a = null;

        static {
            a = new w();
        }

        public w() {
        }

        public final void accept(Object r2) {
            String r3 = (String) r2;
            tt5.a.h("Comment#CommentFunction", "setDetailPanelStatus: status1 succeed!");
        }
    }

    public static final class x<T> implements Consumer {
        public static final x<T> a = null;

        static {
            a = new x();
        }

        public x() {
        }

        public final void accept(Object r4) {
            tt5.a.e("Comment#CommentFunction", "setDetailPanelStatus: status1 failed!", (Throwable) r4, false);
        }
    }

    public static final class y implements PopupWindow.OnDismissListener {
        public final /* synthetic */ CommentFunction a;

        public y(CommentFunction r1) {
            this.a = r1;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public final void onDismiss() {
            CommentFunction r0 = this.a;
            sa5.b r1 = r0.i;
            if (r1 == null) goto L5;
            r1.d(r0.k);
        L5:
            this.a.a.N.a(new ef5.c0());
        }
    }

    public static final class z implements PopupWindow.OnDismissListener {
        public final /* synthetic */ CommentFunction a;
        public final /* synthetic */ Function0<Unit> b;

        public z(CommentFunction r1, Function0<Unit> r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public final void onDismiss() {
            CommentFunction r0 = this.a;
            sa5.b r1 = r0.i;
            if (r1 == null) goto L5;
            r1.d(r0.k);
        L5:
            CommentFunction r2 = this.a;
            r2.n = System.currentTimeMillis();
            this.b.invoke();
            this.a.a.N.a(new ef5.c0());
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.y
    public final void h() {
        PopupWindow r0 = this.h;
        if (r0 == null) goto L6;
        PopupWindowLancet.handleDismissBeforeOrigin(r0);
        r0.dismiss();
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.y
    public final boolean i() {
        Dialog r0 = this.j;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.isShowing() != true) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.y
    public final boolean k() {
        PopupWindow r0 = this.h;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.isShowing() != true) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.y
    public final void q() {
        Dialog r0 = this.j;
        if (r0 == null) goto L6;
        I(r0);
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.y
    public final void u() {
        this.k.onBackPressed();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.y
    public final com.bytedance.ee.bear.middleground.comment.detail.c r() {
        return this.m;
    }

    public static void I(Dialog r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L17:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L17;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.y
    public final void C(com.bytedance.ee.bear.rn.e r4) {
        Intrinsics.checkNotNullParameter(r4, "publishCommentParams");
        int r1 = com.bytedance.ee.bear.middleground.comment.cell.x.a;
        com.bytedance.ee.bear.middleground.comment.control.t r2 = this.c;
        Intrinsics.checkNotNullParameter(r2, "dataControl");
        Intrinsics.checkNotNullParameter(r4, "publishCommentParams");
        if (r4.a != null) goto L5;
        tt5.a.d("Comment#RetryCell", "retryCreateComment quote == null");
    L5:
        String r0 = r4.a;
        if (r0 != null) goto L8;
        r0 = "";
    L8:
        r4.a = r0;
        Flowable<String> r5 = com.bytedance.ee.bear.middleground.comment.uitls.o.a(r2.C(r4), null);
        if (r5 == null) goto L12;
        r5.subscribe(new com.bytedance.ee.bear.middleground.comment.cell.n(r2), new com.bytedance.ee.bear.middleground.comment.cell.o(r2));
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.y
    public final void E(com.bytedance.ee.bear.rn.e r4) {
        Intrinsics.checkNotNullParameter(r4, "publishCommentParams");
        int r1 = com.bytedance.ee.bear.middleground.comment.cell.x.a;
        com.bytedance.ee.bear.middleground.comment.control.t r2 = this.c;
        Intrinsics.checkNotNullParameter(r2, "dataControl");
        Intrinsics.checkNotNullParameter(r4, "publishCommentParams");
        Flowable<String> r5 = com.bytedance.ee.bear.middleground.comment.uitls.o.a(r2.M(r4), null);
        if (r5 == null) goto L6;
        r5.subscribe(new com.bytedance.ee.bear.middleground.comment.cell.v(r2), new com.bytedance.ee.bear.middleground.comment.cell.w(r2));
        return;
    }

    public final void Q(com.bytedance.ee.bear.middleground.comment.control.b0 r8) {
        Intrinsics.checkNotNullParameter(r8, "permissionCallback");
        boolean r2 = this.a.q.g();
        boolean r3 = this.a.q.getComment();
        boolean r4 = this.a.q.h();
        boolean r5 = this.a.q.c();
        this.a.q.j0();
        if (this.a.X.n() == false) goto L5;
        boolean r6 = true;
    L6:
        r8.a(new com.bytedance.ee.bear.middleground.comment.export.bean.b(r2, r3, r4, r5, r6));
        return;
    L5:
        r6 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.y
    public final void d(String r2) {
        Intrinsics.checkNotNullParameter(r2, "commentId");
        this.c.d(r2);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.y
    public final void e(String r6) {
        if (TextUtils.isEmpty(r6) == false) goto L6;
        tt5.a.h("Comment#CommentFunction", "updateReactionDetail: data isEmpty");
        return;
    L6:
        ReactionPopupFacade r1 = this.a.getActivity().getSupportFragmentManager().findFragmentByTag("REACTION_DETAIL");
        if (r1 != null) goto L9;
    L14:
        StringBuilder r7 = new StringBuilder("handle(): detailFragment is ");
        if (r1 == null) goto L17;
        Boolean r0 = Boolean.valueOf(r1.isResumed());
    L18:
        r7.append(r0);
        tt5.a.h("Comment#CommentFunction", r7.toString());
        return;
    L17:
        r0 = null;
        goto L18
    L9:
        if (r1.isResumed() == false) goto L14;
        List r8 = JSON.parseArray(r6, Reaction.class);     // Catch: Exception -> L12
        List r3 = com.bytedance.ee.bear.middleground.comment.uitls.s.b(r8);     // Catch: Exception -> L12
        tt5.a.h("Comment#CommentFunction", "updateReactionDetail reactionList = " + r8);     // Catch: Exception -> L12
        r1.T90(r3);     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        tt5.a.e("Comment#CommentFunction", "updateReactionDetail exception!", e, false);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.y
    public final void f(String r2) {
        Intrinsics.checkNotNullParameter(r2, "commentId");
        this.c.f(r2);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.y
    public final void g(List<String> r3) {
        Intrinsics.checkNotNullParameter(r3, "messageId");
        tt5.a.h("Comment#CommentFunction", "readMessage");
        this.b.Y0().invoke(r3);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.y
    public final boolean l(String r3) {
        if (r3 != null) goto L6;
        return false;
    L6:
        if (TextUtils.equals(r3, this.d) == true) goto L9;
        this.a.h.getClass();
        if (TextUtils.equals(r3, null) == true) goto L9;
        return false;
    L9:
        return true;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.y
    public final void m(float r1) {
        this.f = r1;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.y
    public final void p(com.bytedance.ee.bear.rn.d r4) {
        Intrinsics.checkNotNullParameter(r4, "editCommentParams");
        int r1 = com.bytedance.ee.bear.middleground.comment.cell.x.a;
        com.bytedance.ee.bear.middleground.comment.control.t r2 = this.c;
        Intrinsics.checkNotNullParameter(r2, "dataControl");
        Intrinsics.checkNotNullParameter(r4, "editCommentParams");
        Flowable<String> r5 = com.bytedance.ee.bear.middleground.comment.uitls.o.a(r2.p(r4), null);
        if (r5 == null) goto L6;
        r5.subscribe(new com.bytedance.ee.bear.middleground.comment.cell.r(r2), new com.bytedance.ee.bear.middleground.comment.cell.s(r2));
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.y
    public final void z(com.bytedance.ee.bear.rn.e r4) {
        Intrinsics.checkNotNullParameter(r4, "publishCommentParams");
        int r1 = com.bytedance.ee.bear.middleground.comment.cell.x.a;
        com.bytedance.ee.bear.middleground.comment.control.t r2 = this.c;
        Intrinsics.checkNotNullParameter(r2, "dataControl");
        Intrinsics.checkNotNullParameter(r4, "publishCommentParams");
        Flowable<String> r5 = com.bytedance.ee.bear.middleground.comment.uitls.o.a(r2.z(r4), null);
        if (r5 == null) goto L6;
        r5.subscribe(new com.bytedance.ee.bear.middleground.comment.cell.t(r2), new com.bytedance.ee.bear.middleground.comment.cell.u(r2));
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.y
    public final void D(CommentBean.CommentDetail r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "commentDetail");
        Intrinsics.checkNotNullParameter(r4, "replyId");
        int r0 = com.bytedance.ee.bear.middleground.comment.cell.h.a;
        com.bytedance.ee.bear.middleground.comment.cell.h.a(this.a, this.c, r3, r4);
    }

    public final boolean N(ICardAdapter r4, CommentBean.CommentDetail r5) {
        Intrinsics.checkNotNullParameter(r4, "cardAdapter");
        Intrinsics.checkNotNullParameter(r5, "commentDetail");
        CommentBean r6 = r4.getData();
        com.bytedance.ee.bear.appsetting.c r0 = com.bytedance.ee.bear.appsetting.c.a.a;
        boolean r1 = r0.h("ccm.doc.image_region_comment_add");
        boolean r2 = r0.h("ccm.doc.sent_image_comment_region_add");
        if (r1 == false) goto L20;
        if (r2 == true) goto L6;
        return false;
    L6:
        if (this.a.k.b == sbb.e.o.b) goto L8;
        return false;
    L8:
        if (r5.isFirstReply() == false) goto L23;
        CommentBean.Extra r7 = r6.getExtra();
        if (r7 != null) goto L12;
    L14:
        boolean r8 = false;
    L15:
        if (r8 == true) goto L17;
        return false;
    L17:
        if (l(r6.getUserId()) == false) goto L25;
        return true;
    L25:
        return false;
    L12:
        if (r7.getSource() != 3) goto L14;
        r8 = true;
        goto L15
    L23:
        return false;
    L20:
        return false;
    }

    public final boolean O(com.bytedance.ee.bear.middleground.comment.export.bean.b r2, CommentBean r3) {
        Intrinsics.checkNotNullParameter(r2, "permission");
        Intrinsics.checkNotNullParameter(r3, "commentBean");
        if (this.a.w == true) goto L5;
    L9:
        return false;
    L5:
        if (r2.b == false) goto L9;
        if (r3.isActionBlocked(CommentAction.REACTION) == true) goto L9;
        return true;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.y
    public final boolean b(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        Intrinsics.checkNotNullParameter(r3, "userName");
        return this.c.b(r2, r3);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.y
    public final void c(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "commentId");
        Intrinsics.checkNotNullParameter(r3, "replyId");
        this.c.c(r2, r3);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.y
    public final boolean t(String r10, List<String> r11) {
        if (this.a.q.a() == true) goto L6;
        tt5.a.h("Comment#CommentFunction", "per resolve is false");
        return false;
    L6:
        com.bytedance.ee.bear.appsetting.c r0 = com.bytedance.ee.bear.appsetting.c.a.a;
        boolean r3 = r0.h("ccm.comment.reslove_permission");
        boolean r1 = r0.h("ccm.comment.reslove_permission_v2");
        tt5.a.h("Comment#CommentFunction", "canResolveComment fg =" + r3 + ", fgV2 = " + r1);
        com.bytedance.ee.bear.middleground.comment.export.v r4 = this.a.H;
        if (r4 != null) goto L9;
    L11:
        boolean r5 = false;
    L12:
        boolean r12 = l(r10);
        List<String> r6 = r11;
        if (r6 != null) goto L15;
    L18:
        boolean r7 = true;
    L19:
        if (r7 == false) goto L21;
        boolean r8 = false;
    L23:
        if (r1 == false) goto L44;
        if (r11 == null) goto L44;
        StringBuilder r13 = new StringBuilder("comment isOwner =");
        r13.append(r12);
        r13.append("  doc isOwner=");
        r13.append(r5);
        r13.append("  canEdit=");
        com.bytedance.ee.bear.middleground.comment.export.v r2 = this.a.H;
        if (r2 != null) goto L28;
    L30:
        boolean r9 = false;
    L31:
        r13.append(r9);
        r13.append(" isParticipant = ");
        r13.append(r8);
        tt5.a.h("Comment#CommentFunction", r13.toString());
        if (r12 == true) goto L42;
        if (r5 == true) goto L42;
        com.bytedance.ee.bear.middleground.comment.export.v r14 = this.a.H;
        if (r14 != null) goto L37;
    L39:
        boolean r15 = false;
    L40:
        if (r15 == true) goto L42;
        if (r8 == true) goto L42;
        return false;
    L37:
        if (r14.canEdit() != true) goto L39;
        r15 = true;
    L42:
        return true;
    L28:
        if (r2.canEdit() != true) goto L30;
        r9 = true;
    L44:
        if (r3 == false) goto L63;
        StringBuilder r16 = new StringBuilder("comment isOwner =");
        r16.append(r12);
        r16.append("  doc isOwner=");
        r16.append(r5);
        r16.append("  fullAccess=");
        com.bytedance.ee.bear.middleground.comment.export.v r17 = this.a.H;
        if (r17 != null) goto L48;
    L50:
        boolean r18 = false;
    L51:
        r16.append(r18);
        tt5.a.h("Comment#CommentFunction", r16.toString());
        if (r12 == true) goto L61;
        if (r5 == true) goto L61;
        com.bytedance.ee.bear.middleground.comment.export.v r19 = this.a.H;
        if (r19 != null) goto L57;
    L59:
        boolean r110 = false;
    L60:
        if (r110 == true) goto L61;
        return false;
    L57:
        if (r19.a() != true) goto L59;
        r110 = true;
    L61:
        return true;
    L48:
        if (r17.a() != true) goto L50;
        r18 = true;
        goto L51
    L63:
        return true;
    L21:
        r8 = CollectionsKt.contains(r11, this.d);
        goto L23
    L15:
        if (r6.isEmpty() == true) goto L18;
        r7 = false;
        goto L19
    L9:
        if (r4.isOwner() != true) goto L11;
        r5 = true;
        goto L12
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.y
    public final void v(String r2, List<? extends q2c.c> r3) {
        Intrinsics.checkNotNullParameter(r2, "replyId");
        Intrinsics.checkNotNullParameter(r3, "reactions");
        this.l.put(r2, r3);
    }

    public CommentFunction(com.bytedance.ee.bear.middleground.comment.uitls.p r2, com.bytedance.ee.bear.middleground.comment.control.z r3, com.bytedance.ee.bear.middleground.comment.control.t r4) {
        Intrinsics.checkNotNullParameter(r2, "config");
        Intrinsics.checkNotNullParameter(r3, "commentListeners");
        Intrinsics.checkNotNullParameter(r4, "dataControl");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        r2.h.getClass();
        this.d = com.bytedance.ee.bear.middleground.comment.p.a();
        r2.h.getClass();
        this.e = com.bytedance.ee.bear.middleground.comment.p.b();
        this.g = CommentFunction$mUpdateWholeListener$1.INSTANCE;
        this.k = new e(this);
        this.l = new LinkedHashMap();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.y
    public final void F(CommentBean.CommentDetail r12, String r13, Function0<Unit> r14) {
        Intrinsics.checkNotNullParameter(r12, "commentDetail");
        Intrinsics.checkNotNullParameter(r13, "replyId");
        Dialog r2 = this.j;
        if (r2 == null) goto L6;
        I(r2);
    L6:
        if (r12.getSmartReplyData() != null) goto L9;
        tt5.a.d("Comment#CommentFunction", "showSmartReplyPreviewMenu commentDetail.smartReplyData is null");
        return;
    L9:
        int r3 = com.bytedance.ee.bear.middleground.comment.cell.h.a;
        com.bytedance.ee.bear.middleground.comment.uitls.p r4 = this.a;
        com.bytedance.ee.bear.middleground.comment.control.t r5 = this.c;
        Intrinsics.checkNotNullParameter(r4, "config");
        Intrinsics.checkNotNullParameter(r5, "dataControl");
        Intrinsics.checkNotNullParameter(r12, "commentDetail");
        Intrinsics.checkNotNullParameter(r13, "replyId");
        String r0 = r12.getComment_id();
        if (r0 != null) goto L12;
        r0 = "";
    L12:
        com.bytedance.ee.bear.widgets.a r9 = new com.bytedance.ee.bear.widgets.a(r4.getActivity());
        r9.a();
        r9.g(r4.getActivity().getText(2131888968), new com.bytedance.ee.bear.middleground.comment.cell.g(r4, r5, r12, r13, r14));
        if (ColorUtils.calculateContrast(-1, UIUtils.getColor(r4.getActivity(), 2131100548)) > 3.0d) goto L15;
        float r15 = -1.0f;
    L16:
        LKUIDialog r16 = r9.m(r15);
        Intrinsics.checkNotNull(r16);
        if (DialogLancet.shouldBlockDialogShow(r16) == false) goto L24;
        DialogLancet.handleBlockedDialogShow(r16);
    L21:
        r16.setOnDismissListener(new com.bytedance.ee.bear.middleground.comment.cell.f(r4));
        r4.N.a(new ef5.l(r0, r13, 3));
        this.j = r16;
        return;
    L24:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L23
    L20:
        DialogLancet.beforeDialogShow(r16);
        r16.show();
        DialogLancet.afterDialogShow(r16);
        goto L21
    L15:
        r15 = 0.4f;
        goto L16
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.y
    public final void G(FragmentManager r5, CommentBean.CommentDetail r6, String r7) {
        Intrinsics.checkNotNullParameter(r5, "fragmentManager");
        Intrinsics.checkNotNullParameter(r6, "commentDetail");
        Intrinsics.checkNotNullParameter(r7, "reactionKey");
        if (TextUtils.isEmpty(r6.getReaction_type()) == false) goto L5;
    L28:
        tt5.a.d("Comment#CommentFunction", "clickReactionDetail failed:commentDetail.referType = " + r6.getReaction_type() + ",commentDetail.referKey = " + r6.getReferKey());
        return;
    L5:
        if (TextUtils.isEmpty(r6.getReferKey()) == true) goto L28;
        this.a.h.getClass();
        if (com.bytedance.ee.bear.middleground.comment.p.c() == false) goto L12;
        tt5.a.h("Comment#CommentFunction", "clickReactionDetail is guest");
        return;
    L12:
        if (r6.isFull() == true) goto L14;
        this.c.t(r6.getReaction_type(), r6.getCommentType(), r6.getReferKey()).subscribe(new r(this, r7), new s(r7));
    L14:
        ReactionPopupFacade r8 = ReactionPopupFacade.S90(r6.getReactionDetailData(), r7, false);
        r8.f = new t(this);
        r8.i = new u(this, r6);
        Ref.IntRef r0 = new Ref.IntRef();
        r0.element = -1;
        r8.g = new v(r0, r6, this);
        LandscapeRestrictionOperation r1 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r8, "REACTION_DETAIL", r1);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r5, r8, r1) == false) goto L31;
    L19:
        this.c.F(1, r6.getReaction_type(), r6.getReferKey()).subscribe(w.a, x.a);
        com.bytedance.ee.bear.middleground.comment.uitls.h r9 = this.a.d0;
        int r10 = r6.getReaction().size();
        String r11 = r6.getComment_id();
        Map<String, Object> r2 = r9.b();
        if (r11 == null) goto L23;
        ((HashMap) r2).put("reaction_card_id", r11);
    L23:
        if (r10 != 1) goto L25;
        ((HashMap) r2).put("emoji_num", "one");
    L26:
        tt5.a.b("Comment#CommentAnalytic", "reportReactionDetailView params = " + r2);
        r9.g.a("ccm_reaction_detail_page_view", r2);
        return;
    L25:
        ((HashMap) r2).put("emoji_num", "multiple");
        goto L26
    L31:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L30
    L18:
        r8.show(r5, "REACTION_DETAIL");
        goto L19
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.y
    public final com.bytedance.ee.bear.middleground.comment.cell.i H(final String r4, int r5, com.bytedance.ee.bear.middleground.comment.cell.i.a r6) {
        Intrinsics.checkNotNullParameter(r4, "commentId");
        Intrinsics.checkNotNullParameter(r6, "callback");
        FragmentActivity r0 = this.a.getActivity();
        this.a.h.getClass();
        boolean r2 = true;
        if (com.bytedance.ee.bear.middleground.comment.p.c() == true) goto L6;
        r2 = false;
    L6:
        this.a.h.getClass();
        com.bytedance.ee.bear.middleground.comment.cell.i r7 = new com.bytedance.ee.bear.middleground.comment.cell.i(r0, r2, new CommentFunction$linkClick$linkClickCell$1(this, r4));
        r7.d = r6;
        return r7;
    }

    public void K(final ICardAdapter r10, int r11, List<com.ss.android.lark.reaction.widget.panel.e> r12) {
        Intrinsics.checkNotNullParameter(r10, "cardAdapter");
        Intrinsics.checkNotNullParameter(r12, "menuList");
        final CommentBean.CommentDetail r4 = (CommentBean.CommentDetail) CollectionsKt.getOrNull(r10.getCommentDetails(), r11);
        if (r4 != null) goto L6;
        tt5.a.k("Comment#CommentFunction", "addEditItem commentDetail is null");
        return;
    L6:
        final String r3 = r10.findReplyIdByPosition(r11);
        String r0 = eu5.b.a.getString(2131887749);
        int r7 = com.bytedance.ee.bear.middleground.comment.uitls.s.a("EDIT");
        final com.bytedance.ee.bear.middleground.comment.uitls.p r6 = this.a;
        r12.add(new com.ss.android.lark.reaction.widget.panel.e(r0, r7, new CommentFunction$addEditItem$editItem$1(r10, r3, r4, this, r6)));
    }

    public final String M(CommentBean.CommentDetail r13, String r14, ReactionCacheActionType r15) {
        if (com.bytedance.ee.bear.appsetting.c.a.a.h("ccm.mobile.comment.reaction_display_quickly") == true) goto L6;
        return null;
    L6:
        String r0 = UUID.randomUUID().toString();
        if (com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a() == true) goto L10;
        tt5.a.h("Comment#CommentFunction", "cacheReaction: network is not connected");
        return r0;
    L10:
        gf5.d r10 = this.a.N;
        String r3 = r13.getComment_id();
        String r4 = r13.getReply_id();
        String r1 = this.d;
        if (r1 != null) goto L13;
        String r7 = "";
    L14:
        String r2 = this.e;
        if (r2 != null) goto L17;
        String r8 = "";
    L18:
        r10.a(new ef5.b0(r15, r3, r4, r14, r0, r7, r8, r13));
        this.b.I0();
        return r0;
    L17:
        r8 = r2;
        goto L18
    L13:
        r7 = r1;
        goto L14
    }

    public final void R(CommentBean.CommentDetail r4, String r5, boolean r6) {
        if (r4.getSmartReplyData() != null) goto L5;
        return;
    L5:
        if (r6 == false) goto L7;
        String r7 = "reaction_add_adopt";
    L9:
        if (Intrinsics.areEqual(r5, "AINailedIt") == false) goto L25;
        tt5.a.h("Comment#CommentFunction", "tryReportAIReactionClick: AINailedIt");
        LinkedHashMap r8 = new LinkedHashMap();
        String r0 = r4.getSmartReplyData().getAiReplyId();
        String r1 = "";
        if (r0 != null) goto L13;
        r0 = "";
    L13:
        r8.put("ai_comment_id", r0);
        String r2 = r4.getSmartReplyData().getAiReplyUserType().getValue();
        if (r2 != null) goto L16;
        r2 = "";
    L16:
        r8.put("ai_reply_user_type", r2);
        com.bytedance.ee.bear.middleground.comment.uitls.h r3 = this.a.d0;
        String r9 = r4.getSmartReplyData().getCommentId();
        if (r9 != null) goto L19;
        r9 = "";
    L19:
        String r10 = r4.getSmartReplyData().getReplyId();
        if (r10 == null) goto L23;
        r1 = r10;
    L23:
        r3.g(r7, r9, r1, r8);
        return;
    L25:
        return;
    L7:
        r7 = "reaction_cancel_adopt";
        goto L9
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.y
    public final void a(String r2, int r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "commentId");
        Intrinsics.checkNotNullParameter(r4, "replyId");
        this.c.a(r2, r3, r4);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.y
    public final void n(String r5, int r6, String r7) {
        Intrinsics.checkNotNullParameter(r5, "commentId");
        Intrinsics.checkNotNullParameter(r7, "replyId");
        int r2 = com.bytedance.ee.bear.middleground.comment.cell.x.a;
        com.bytedance.ee.bear.middleground.comment.control.t r3 = this.c;
        Intrinsics.checkNotNullParameter(r3, "dataControl");
        Intrinsics.checkNotNullParameter(r5, "commentId");
        Intrinsics.checkNotNullParameter(r7, "replyId");
        Flowable<String> r8 = com.bytedance.ee.bear.middleground.comment.uitls.o.a(r3.n(r5, r6, r7), null);
        if (r8 == null) goto L6;
        r8.subscribe(new com.bytedance.ee.bear.middleground.comment.cell.p(r3), new com.bytedance.ee.bear.middleground.comment.cell.q(r3));
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.y
    public final void s(String r5, CommentBean.CommentDetail r6, View r7) {
        Intrinsics.checkNotNullParameter(r5, "reactionKey");
        Intrinsics.checkNotNullParameter(r6, "commentDetail");
        if (r6.getReactionFlowData() != null) goto L7;
        tt5.a.h("Comment#CommentFunction", "clickContentReaction: reactions data is null");
        return;
    L7:
        if (TextUtils.isEmpty(r6.getReaction_type()) == false) goto L9;
    L32:
        tt5.a.d("Comment#CommentFunction", "clickContentReaction: failed :commentDetail.referType = " + r6.getReaction_type() + ",commentDetail.referKey = " + r6.getReferKey());
        return;
    L9:
        if (TextUtils.isEmpty(r6.getReferKey()) == true) goto L32;
        Intrinsics.checkNotNullParameter(r6, "commentDetail");
        Intrinsics.checkNotNullParameter(r5, "reactionKey");
        List<q2c.c> r0 = r6.getReactionFlowData();
        if (r0 != null) goto L14;
    L27:
        boolean r1 = false;
    L28:
        if (r1 == false) goto L30;
        this.c.A(r6.getComment_id(), r6.getCommentType(), r6.getReferKey(), r5).subscribe(new f(r5, r6, this), new g(r5));
        return;
    L30:
        this.c.j(r6.getComment_id(), r6.getCommentType(), r6.getReferKey(), r5).subscribe(new h(r5, r6, this, r7), new i(r5));
        return;
    L14:
        if (r0.isEmpty() == true) goto L27;
        Iterator<T> r2 = r0.iterator();
    L18:
        if (r2.hasNext() == false) goto L27;
        q2c.c r3 = (q2c.c) r2.next();
        if (TextUtils.equals(r5, r3.a) == false) goto L18;
        Iterator r4 = r3.c.iterator();
    L23:
        if (r4.hasNext() == false) goto L18;
        if (TextUtils.equals(((q2c.d) r4.next()).a, this.d) == false) goto L23;
        r1 = true;
        goto L28
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.y
    public void w(CommentBean.CommentDetail r8, String r9, View r10) {
        Intrinsics.checkNotNullParameter(r8, "commentDetail");
        Intrinsics.checkNotNullParameter(r9, "replyId");
        Dialog r0 = this.j;
        if (r0 == null) goto L5;
        I(r0);
    L5:
        int r1 = com.bytedance.ee.bear.middleground.comment.cell.e.a;
        this.j = com.bytedance.ee.bear.middleground.comment.cell.e.a(this.a, this.c, r8, r9, r10, 32);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.y
    public final void x(View r21, CommentBean.CommentDetail r22, Function0<Unit> r23) {
        Intrinsics.checkNotNullParameter(r21, "itemView");
        Intrinsics.checkNotNullParameter(r22, "item");
        Intrinsics.checkNotNullParameter(r23, "dismissListener");
        if (this.a.q.getComment() == true) goto L5;
        return;
    L5:
        if (k() == false) goto L24;
        return;
    L24:
        PopupWindow r2 = this.h;     // Catch: Exception -> L20
        if (r2 == null) goto L11;
        PopupWindowLancet.handleDismissBeforeOrigin(r2);     // Catch: Exception -> L20
        r2.dismiss();     // Catch: Exception -> L20
    L11:
        ArrayList r5 = new ArrayList();     // Catch: Exception -> L20
        ReactionPanelFacade.ReactionScene r3 = ReactionPanelFacade.ReactionScene.IM;     // Catch: Exception -> L20
        Context r4 = r21.getContext();     // Catch: Exception -> L20
        ((com.bytedance.ee.bear.contract.x) org.koin.java.a.c(com.bytedance.ee.bear.contract.x.class, null, null, 6)).o();     // Catch: Exception -> L20
        ((com.bytedance.ee.bear.contract.x) org.koin.java.a.c(com.bytedance.ee.bear.contract.x.class, null, null, 6)).h();     // Catch: Exception -> L20
        ((com.bytedance.ee.bear.contract.x) org.koin.java.a.c(com.bytedance.ee.bear.contract.x.class, null, null, 6)).a();     // Catch: Exception -> L20
        ReactionPanelFacade r11 = new ReactionPanelFacade(r4, r21, r5, true, new a0(this, r22, r21), true, false, 2131953375, -1, -1, true, ReactionPanelFacade.ReactionScene.CCM, "");     // Catch: Exception -> L20
        r11.r = new z(this, r23);     // Catch: Exception -> L20
        this.a.N.a(new e0(r22.getComment_id()));     // Catch: Exception -> L20
        com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.g r6 = com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.g.a;     // Catch: Exception -> L20
        FragmentActivity r7 = this.a.getActivity();     // Catch: Exception -> L20
        Fragment r8 = this.a.b;     // Catch: Exception -> L20
        r6.getClass();     // Catch: Exception -> L20
        sa5.b r9 = com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.g.a(r7, r8);     // Catch: Exception -> L20
        this.i = r9;     // Catch: Exception -> L20
        if (r9 == null) goto L14;
        r9.e(this.k);     // Catch: Exception -> L20
    L14:
        int[] r10 = new int[2];     // Catch: Exception -> L20
        r21.getLocationOnScreen(r10);     // Catch: Exception -> L20
        boolean r12 = false;
        this.h = r11.g(false, 49, 0, (r10[1] + r21.getMeasuredHeight()) - v2c.a.a(this.a.getActivity(), 2.0f));     // Catch: Exception -> L18
        return;
    L18:
        e = e;
    L22:
        tt5.a.e("Comment#CommentFunction", "showContentReaction fail. ", e, r12);
        return;
    L20:
        e = e;
        r12 = false;
        goto L22
    }

    public static final void J(CommentFunction r1, View r2, ClipData r3, String r4) {
        r1.b.J0().invoke(r4);
        ((fu5.a) org.koin.java.a.c(fu5.a.class, null, null, 6)).h(r3, new Token("LARK-PSDA-ccm_android_comment_more_inner_set_clipboard"));
        Toast.showSuccessText(r2.getContext(), r2.getContext().getString(2131887614), 0);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.y
    public final void B(ICardAdapter r11, String r12, CommentBean.CommentDetail r13, View r14) {
        Intrinsics.checkNotNullParameter(r11, "cardAdapter");
        Intrinsics.checkNotNullParameter(r12, "reactionKey");
        Intrinsics.checkNotNullParameter(r13, "commentDetail");
        if (r13.getReactionFlowData() != null) goto L6;
        tt5.a.h("Comment#CommentFunction", "clickReaction: reactions data is null");
        return;
    L6:
        List r0 = (List) ((LinkedHashMap) this.l).get(r13.getReply_id());
        if (r0 != null) goto L9;
    L22:
        boolean r1 = false;
    L24:
        if (r1 == true) goto L26;
        Flowable.just("").subscribeOn(fo5.d.b()).map(n.a).map(new o(r12)).subscribe(p.a, q.a);
        if (TextUtils.isEmpty(r13.getReaction_type()) == false) goto L35;
    L40:
        tt5.a.d("Comment#CommentFunction", "clickReaction: failed :commentDetail.referType = " + r13.getReaction_type() + ",commentDetail.referKey = " + r13.getReferKey());
    L41:
        v(r13.getReply_id(), r13.getReactionFlowData());
        return;
    L35:
        if (TextUtils.isEmpty(r13.getReferKey()) == true) goto L40;
        String r9 = M(r13, r12, ReactionCacheActionType.CACHE_ADD);
        R(r13, r12, true);
        Flowable r2 = this.c.u(r13.getComment_id(), r13.getReferKey(), r13.getCommentType(), r12, r9).map(com.bytedance.ee.bear.middleground.comment.control.k.a);
        if (r2 == null) goto L41;
        r2.subscribe(new l(r11, r12, this, r13, r14), new m(r12));
        goto L41
    L26:
        if (TextUtils.isEmpty(r13.getReaction_type()) == false) goto L28;
    L31:
        tt5.a.d("Comment#CommentFunction", "clickReaction: failed :commentDetail.referType = " + r13.getReaction_type() + ",commentDetail.referKey = " + r13.getReferKey());
        goto L41
    L28:
        if (TextUtils.isEmpty(r13.getReferKey()) == true) goto L31;
        String r8 = M(r13, r12, ReactionCacheActionType.CACHE_DELETE);
        R(r13, r12, false);
        this.c.l(r13.getComment_id(), r13.getReferKey(), r13.getCommentType(), r12, r8).subscribe(new j(r13, r12, this, r11), new k(this, r12));
        goto L41
    L9:
        if (r0.isEmpty() == true) goto L22;
        Iterator r3 = r0.iterator();
    L13:
        if (r3.hasNext() == false) goto L22;
        q2c.c r4 = (q2c.c) r3.next();
        if (TextUtils.equals(r12, r4.a) == false) goto L13;
        Iterator r5 = r4.c.iterator();
    L18:
        if (r5.hasNext() == false) goto L13;
        if (TextUtils.equals(((q2c.d) r5.next()).a, this.d) == false) goto L18;
        r1 = true;
        goto L24
    }

    public final void L(ICardAdapter r7, int r8, boolean r9, List<com.ss.android.lark.reaction.widget.panel.e> r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r7, "cardAdapter");
        Intrinsics.checkNotNullParameter(r10, "menuList");
        CommentBean.CommentDetail r3 = (CommentBean.CommentDetail) CollectionsKt.getOrNull(r7.getCommentDetails(), r8);
        if (r3 != null) goto L6;
        tt5.a.d("Comment#CommentFunction", "addResolveItem commentDetail is null");
        return;
    L6:
        d r12 = new d(r11, this, r3, r9, this.a);
        com.ss.android.lark.reaction.widget.panel.e r13 = new com.ss.android.lark.reaction.widget.panel.e(eu5.b.a.getString(2131889251), com.bytedance.ee.bear.middleground.comment.uitls.s.a("RESOLVE"), r12);
        if (r11 == true) goto L9;
        r13.f = new c(r11, this);
    L9:
        r13.e = r11;
        r10.add(r13);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.y
    public final void o(View r10, CommentBean.CommentDetail r11, ICardAdapter r12, int r13, int r14) {
        Intrinsics.checkNotNullParameter(r10, "view");
        Intrinsics.checkNotNullParameter(r11, "item");
        Intrinsics.checkNotNullParameter(r12, "cardAdapter");
        if ((System.currentTimeMillis() - this.n) >= 100) goto L5;
        return;
    L5:
        if (r13 >= 0) goto L7;
    L11:
        tt5.a.d("Comment#CommentFunction", "showReaction but position is invalid, position: " + r13);
        return;
    L7:
        if (r13 >= r12.getCommentDetails().size()) goto L11;
        ArrayList r5 = new ArrayList();
        this.b.T().c.invoke();
        Q(new b0(this, r12, r13, r5, r11, r10, r14));
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.y
    public final void A(String r20, int r21, boolean r22, boolean r23, boolean r24, View r25) {
        Intrinsics.checkNotNullParameter(r20, "commentId");
        if (r24 == false) goto L39;
        Dialog r2 = this.j;
        if (r2 == null) goto L7;
        I(r2);
    L7:
        com.bytedance.ee.bear.middleground.comment.cell.j r5 = new com.bytedance.ee.bear.middleground.comment.cell.j();
        com.bytedance.ee.bear.middleground.comment.uitls.p r9 = this.a;
        com.bytedance.ee.bear.middleground.comment.control.t r6 = this.c;
        Intrinsics.checkNotNullParameter(r9, "config");
        Intrinsics.checkNotNullParameter(r6, "dataControl");
        Intrinsics.checkNotNullParameter(r20, "commentId");
        double r1 = ColorUtils.calculateContrast(-1, UIUtils.getColor(r9.getActivity(), 2131100548));
        if (r9.n.isAside() == false) goto L11;
        if (r25 == null) goto L11;
        boolean r13 = true;
    L13:
        if (r1 > 3.0d) goto L15;
        float r14 = -1.0f;
    L16:
        FragmentActivity r15 = r9.getActivity();
        com.bytedance.ee.bear.widgets.a r7 = new com.bytedance.ee.bear.widgets.a(r15);
        if (r23 == false) goto L19;
        Function0 r11 = null;
        com.bytedance.ee.bear.middleground.comment.cell.k r3 = new com.bytedance.ee.bear.middleground.comment.cell.k(r9, r20, r5, r6, r21);
        CharSequence r4 = r15.getText(2131889385);
        cp5.b r8 = new cp5.b();
        r8.a = r4;
        r8.d = false;
        r8.e = null;
        r8.f = r3;
        r8.c = false;
        r8.b = -1;
        r8.g = true;
        r8.h = 1.0f;
        r8.i = !r13;
        r7.f(r8);
        com.bytedance.ee.bear.widgets.a r10 = r7;
        float r12 = 1.0f;
    L20:
        if (r13 == false) goto L22;
        CharSequence r16 = r9.getActivity().getText(2131888309);
        cp5.b r17 = new cp5.b();
        r17.a = r16;
        r17.d = false;
        r17.e = r11;
        r17.f = r11;
        r17.c = false;
        r17.b = -1;
        r17.g = true;
        r17.h = r12;
        r17.i = false;
        r10.f(r17);
    L23:
        LKUIDialog r18 = r10.m(r14);
        if (DialogLancet.shouldBlockDialogShow(r18) == false) goto L42;
        DialogLancet.handleBlockedDialogShow(r18);
    L28:
        int r19 = com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.l.a;
        FragmentActivity r26 = r9.getActivity();
        Intrinsics.checkNotNull(r18);
        com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.k r27 = com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.l.c(r26, r18);
        if (r13 == false) goto L38;
        if (r25 == null) goto L38;
        Rect r28 = com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.m.b(r25);
        int r29 = UIUtils.dp2px(r9.getActivity(), 320.0f);
        dib.a r30 = com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.m.a(r9.getActivity(), r28, r29, UIUtils.dp2px(r9.getActivity(), 130.0f));
        int r31 = r30.a;
        int r32 = r30.b;
        Window r33 = r18.getWindow();
        if (r33 == null) goto L37;
        WindowManager.LayoutParams r34 = r33.getAttributes();
        if (r34 != null) goto L36;
        r34 = new WindowManager.LayoutParams();
    L36:
        r34.gravity = 8388659;
        r34.width = r29;
        r34.height = -2;
        r34.x = r31;
        r34.y = r32 - StatusBarUtil.getStatusBarHeight(r9.getActivity());
        r33.setAttributes(r34);
        com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.l.b(r9.getActivity(), r18);
    L37:
        r9.getActivity().registerComponentCallbacks(r27);
    L38:
        r18.setOnDismissListener(new com.bytedance.ee.bear.middleground.comment.cell.m(r11, r9, r13, r27));
        r9.N.a(new ef5.l(r20, "", 2));
        this.j = r18;
        return;
    L42:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L41
    L27:
        DialogLancet.beforeDialogShow(r18);
        r18.show();
        DialogLancet.afterDialogShow(r18);
        goto L28
    L22:
        r10.a();
        goto L23
    L19:
        r11 = null;
        com.bytedance.ee.bear.middleground.comment.cell.l r35 = new com.bytedance.ee.bear.middleground.comment.cell.l(r9, r20, r6, r5, r21, r22);
        CharSequence r36 = r15.getText(2131889251);
        cp5.b r37 = new cp5.b();
        r37.a = r36;
        r37.d = false;
        r37.e = null;
        r37.f = r35;
        r37.c = false;
        r37.b = -1;
        r37.g = true;
        r12 = 1.0f;
        r37.h = 1.0f;
        r37.i = !r13;
        r10 = r7;
        r10.f(r37);
        goto L20
    L15:
        r14 = 0.4f;
    L11:
        r13 = false;
        goto L13
    L39:
        com.bytedance.ee.bear.middleground.comment.cell.j.a(this.c, r20, r21, r22);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.y
    public final void y(View r25, CommentBean.CommentDetail r26, ICardAdapter r27, int r28, List<String> r29, boolean r30) {
        Intrinsics.checkNotNullParameter(r25, "view");
        Intrinsics.checkNotNullParameter(r26, "item");
        Intrinsics.checkNotNullParameter(r27, "cardAdapter");
        ArrayList r8 = new ArrayList();
        String r2 = this.a.O;
        if (r2 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == false) goto L11;
    L18:
        boolean r4 = com.bytedance.ee.bear.appsetting.c.a.a.h("ccm.comment.reslove_permission_v2");
        boolean r5 = t(r26.getUser_id(), r29);
        if (this.a.u == true) goto L31;
        Intrinsics.checkNotNullParameter(r27, "cardAdapter");
        if (r27.getData().getCommentType() != 2) goto L23;
        boolean r0 = true;
    L24:
        if (r0 == true) goto L31;
        if (r4 == false) goto L27;
        if (r5 == true) goto L27;
    L28:
        if (r30 == false) goto L31;
        L(r27, r28, true, r8, r5);
    L27:
        if (r5 == false) goto L31;
    L23:
        r0 = false;
    L31:
        if (r8.isEmpty() == false) goto L34;
        tt5.a.d("Comment#CommentFunction", "showCardMoreMenuList with empty menu list!");
        return;
    L34:
        PopupWindow r1 = this.h;
        if (r1 == null) goto L37;
        PopupWindowLancet.handleDismissBeforeOrigin(r1);
        r1.dismiss();
    L37:
        ArrayList r11 = new ArrayList();
        ReactionPanelFacade.ReactionScene r6 = ReactionPanelFacade.ReactionScene.IM;
        Context r9 = r25.getContext();
        ReactionPanelFacade.ReactionScene r20 = ReactionPanelFacade.ReactionScene.CCM;
        r11.clear();
        r11.addAll(r8);
        ReactionPanelFacade r7 = new ReactionPanelFacade(r9, r25, r11, false, null, false, true, 2131953375, -1, -1, true, r20, "");
        int r10 = v2c.a.d(this.a.getActivity());
        float r12 = this.f;
        if (r12 <= (r10 / 2)) goto L40;
        boolean r13 = true;
    L41:
        if (r13 == false) goto L43;
        int r14 = 80;
    L45:
        if (r13 == false) goto L47;
        int r15 = (int) ((r10 - r12) + v2c.a.a(eu5.b.a, 22.0f));
    L48:
        BasePopupWindow r16 = r7.g(r13, r14 | 5, com.bytedance.ee.util.ui.n.d(20), r15);
        this.h = r16;
        if (r16 == null) goto L51;
        r16.setOnDismissListener(new y(this));
    L51:
        this.a.N.a(new e0(r26.getComment_id()));
        com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.g r17 = com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.g.a;
        FragmentActivity r18 = this.a.getActivity();
        Fragment r19 = this.a.b;
        r17.getClass();
        sa5.b r21 = com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.g.a(r18, r19);
        this.i = r21;
        if (r21 == null) goto L55;
        r21.e(this.k);
        return;
    L55:
        return;
    L47:
        r15 = (int) (r12 + v2c.a.a(eu5.b.a, 22.0f));
        goto L48
    L43:
        r14 = 48;
        goto L45
    L40:
        r13 = false;
        goto L41
    L11:
        if (r27.getData().getCommentAnchorId() == null) goto L13;
        String r22 = r27.getData().getCommentAnchorId();
    L14:
        String r110 = r22;
        String r111 = this.a.O;
        Intrinsics.checkNotNull(r111);
        Intrinsics.checkNotNull(r110);
        String r23 = StringsKt.replace$default(r111, "{commentId}", r110, false, 4, null) + "&comment_type=" + r26.getCommentType();
        if (this.a.X.m() == false) goto L17;
        r8.add(new com.ss.android.lark.reaction.widget.panel.e(eu5.b.a.getString(2131889342), com.bytedance.ee.bear.middleground.comment.uitls.s.a("SEND_IM"), new com.bytedance.ee.bear.middleground.comment.control.h(r26, this, r23)));
    L17:
        r8.add(new com.ss.android.lark.reaction.widget.panel.e(eu5.b.a.getString(2131889341), com.bytedance.ee.bear.middleground.comment.uitls.s.a("COPY_LINK"), new com.bytedance.ee.bear.middleground.comment.control.c(r26, this, r23)));
        goto L18
    L13:
        r22 = r26.getComment_id();
        goto L14
    L5:
        if (r2.length() == 0) goto L8;
        r3 = false;
        goto L9
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.y
    public void j(final CommentBean.CommentDetail r16, ICardAdapter r17, String r18, int r19, String r20, String r21, Map<Object, ? extends Object> r22) {
        Intrinsics.checkNotNullParameter(r16, "commentDetail");
        Intrinsics.checkNotNullParameter(r17, "cardAdapter");
        Function2<String, List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity>, Unit> r8 = new CommentFunction$editCommentByReviewFail$edit$1(r16);
        Function0<Unit> r9 = new CommentFunction$editCommentByReviewFail$updateWhole$1(this);
        List<CommentBean.CommentDetail> r6 = r17.getLast3Item(r16.getReply_id());
        if (r6.size() != 0) goto L5;
        return;
    L5:
        com.bytedance.ee.bear.middleground.comment.uitls.p r1 = this.a;
        com.bytedance.ee.bear.middleground.comment.control.z r2 = this.b;
        com.bytedance.ee.bear.middleground.comment.control.t r3 = this.c;
        if (r1.o != 0) goto L8;
        boolean r7 = true;
    L9:
        P(r1, r2, r3, r17, r16, r6, r7, r8, r9, r18, r21, r20, Integer.valueOf(r19));
        return;
    L8:
        r7 = false;
        goto L9
    }

    public final void P(com.bytedance.ee.bear.middleground.comment.uitls.p r20, final com.bytedance.ee.bear.middleground.comment.control.z r21, com.bytedance.ee.bear.middleground.comment.control.t r22, ICardAdapter r23, CommentBean.CommentDetail r24, List<CommentBean.CommentDetail> r25, final boolean r26, final Function2<? super String, ? super List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity>, Unit> r27, final Function0<Unit> r28, String r29, String r30, String r31, Integer r32) {
        CommentBean r6 = new CommentBean();
        r6.setComment_list(r25);
        CommentBean.CommentDetail.ExtraEntity r2 = ((CommentBean.CommentDetail) ListProtector.get(r25, 0)).getExtra();
        if (r2 == null) goto L16;
        List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r3 = r2.getImage_list();
        if (r3 == null) goto L16;
        ArrayList r4 = new ArrayList();
        Iterator<T> r5 = r3.iterator();
    L8:
        if (r5.hasNext() == false) goto L15;
        CommentBean.CommentDetail.ExtraEntity.CommentImageEntity r7 = (CommentBean.CommentDetail.ExtraEntity.CommentImageEntity) r5.next();
        if (r7 == null) goto L12;
        CommentBean.CommentDetail.ExtraEntity.CommentImageEntity r8 = r7.copy();
    L13:
        if (r8 == null) goto L8;
        r4.add(r8);
        goto L8
    L12:
        r8 = null;
        goto L13
    L15:
        ArrayList r9 = r4;
    L17:
        com.bytedance.ee.bear.middleground.comment.detail.c r14 = new com.bytedance.ee.bear.middleground.comment.detail.c(r20, r21, r22, this, r23.getCommentId(r24), r6, ((CommentBean.CommentDetail) ListProtector.get(r25, 0)).getContent(), r9, new CommentFunction$edit$2(r26, r28, r21, r27), new CommentFunction$edit$3(this), r29, r30, r31, r32, N(r23, r24));
        this.m = r14;
        com.bytedance.ee.bear.middleground.comment.control.z r10 = r14.b;
        if ((r10 instanceof Comment) == false) goto L20;
        Comment r11 = (Comment) r10;
    L21:
        if (r11 == null) goto L25;
        p1 r12 = r11.o;
        if (r12 == null) goto L25;
        r12.IX();
    L25:
        View r13 = r14.i;
        if (r13 == null) goto L28;
        ViewParent r15 = r13.getParent();
    L29:
        ViewGroup r16 = (ViewGroup) r15;
        if (r16 == null) goto L32;
        r16.removeView(r14.i);
    L32:
        r14.a.c.addView(r14.i);
        kf5.b r17 = r14.m;
        if (r17 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("createComment");
        r17 = null;
    L35:
        kf5.a.b(r17, false, false, false, false, false, 30);
        sa5.b r18 = (sa5.b) sa5.m.a.a(r14.a.getActivity(), sa5.b.class);
        if (r18 == null) goto L38;
        r18.e(r14.q);
    L38:
        r21.Z().invoke(Boolean.TRUE);
        return;
    L28:
        r15 = null;
        goto L29
    L20:
        r11 = null;
    L16:
        r9 = null;
        goto L17
    }
}
