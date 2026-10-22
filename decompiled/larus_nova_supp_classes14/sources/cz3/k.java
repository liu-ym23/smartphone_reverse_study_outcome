package cz3;

import android.app.Activity;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.android.shopping.store.mall.follows.basic.BaseFollowStoreViewModel;
import com.bytedance.awemeopen.apps.framework.comment.api.statistics.CommentMobParameters;
import com.bytedance.awemeopen.apps.framework.comment.write.commentinputmanager.ManagerContext;
import com.bytedance.awemeopen.apps.framework.comment.write.model.TextExtraStruct;
import com.bytedance.awemeopen.apps.framework.comment.write.refactor.BaseInputPanel;
import com.bytedance.awemeopen.apps.framework.comment.write.refactor.r;
import com.bytedance.awemeopen.apps.framework.comment.write.refactor.s;
import com.bytedance.awemeopen.apps.framework.comment.write.viewmodel.CommentInputContentViewModel;
import com.bytedance.awemeopen.apps.framework.comment.write.viewmodel.CommentSharkViewModel;
import com.bytedance.awemeopen.apps.framework.feed.AosEventReporter;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class k extends com.bytedance.awemeopen.apps.framework.comment.write.commentinputmanager.a<jy3.d> {
    public final List<jy3.d> g;
    public final c h;
    public final e i;
    public final d j;

    public static final class a implements g {
        public final /* synthetic */ k a;

        @Override // cz3.g
        public final com.bytedance.awemeopen.apps.framework.comment.write.c x() {
            return this.a.I();
        }

        public a(k r1) {
            this.a = r1;
        }

        @Override // cz3.g
        public final void b(CommentMobParameters r2) {
            this.a.getClass();
            com.bytedance.awemeopen.apps.framework.comment.write.d r0 = this.a.d.c;
            if (r0 != null) goto L5;
        L7:
            boolean r1 = false;
        L8:
            if (r1 == false) goto L10;
            return;
        L10:
            com.bytedance.awemeopen.apps.framework.comment.write.c r3 = this.a.I();
            if (r3 == null) goto L19;
            ((s) r3).e(r2);     // Catch: IllegalStateException -> L14
            return;
        L14:
            e = move-exception;
            e.printStackTrace();
            return;
        L19:
            return;
        L5:
            if (r0.isShowing() == true) goto L7;
            r1 = true;
            goto L8
        }

        @Override // cz3.g
        public final void g(jy3.d r2) {
            Intrinsics.checkNotNullParameter(r2, "keyBoardServices");
            if (((ArrayList) this.a.g).contains(r2) == true) goto L6;
            ((ArrayList) this.a.g).add(r2);
            return;
        }

        @Override // cz3.g
        public final void l(com.bytedance.awemeopen.apps.framework.comment.write.g r9) {
            Intrinsics.checkNotNullParameter(r9, "param");
            k r1 = this.a;
            i r2 = r1.d.n;
            if (r2 == null) goto L5;
            r2.u();
            boolean r3 = true;
        L6:
            if (r3 == false) goto L137;
            WeakReference<com.bytedance.awemeopen.apps.framework.comment.write.n> r4 = com.bytedance.awemeopen.apps.framework.comment.write.f.a;
            com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b r5 = r1.d.b;
            Intrinsics.checkNotNullParameter(r5, "pageOwner");
            Intrinsics.checkNotNullParameter(r9, "param");
            Window r0 = r5.getActivity().getWindow();
            if (r0 == null) goto L11;
            r0.setSoftInputMode(48);
        L11:
            WeakReference<com.bytedance.awemeopen.apps.framework.comment.write.n> r6 = com.bytedance.awemeopen.apps.framework.comment.write.f.a;
            String r7 = null;
            if (r6 == null) goto L14;
            com.bytedance.awemeopen.apps.framework.comment.write.n r8 = r6.get();
        L15:
            if (r8 != null) goto L32;
            WeakReference<com.bytedance.awemeopen.apps.framework.comment.write.n> r10 = new WeakReference(new com.bytedance.awemeopen.apps.framework.comment.write.n(r5));
            com.bytedance.awemeopen.apps.framework.comment.write.f.a = r10;
            com.bytedance.awemeopen.apps.framework.comment.write.n r11 = r10.get();
            if (r11 == null) goto L27;
            r11.n = r9;
            s r12 = r11.g;
            if (r12 == null) goto L27;
            r12.q = r9;
            if (r12.k != null) goto L23;
            r12.C();
        L23:
            com.bytedance.awemeopen.apps.framework.comment.write.refactor.g r13 = r12.k;
            if (r13 == null) goto L27;
            r13.k = r9.c;
        L27:
            WeakReference<com.bytedance.awemeopen.apps.framework.comment.write.n> r14 = com.bytedance.awemeopen.apps.framework.comment.write.f.a;
            if (r14 == null) goto L71;
            com.bytedance.awemeopen.apps.framework.comment.write.n r15 = r14.get();
            if (r15 == null) goto L71;
            r15.a();
        L71:
            WeakReference<com.bytedance.awemeopen.apps.framework.comment.write.n> r16 = com.bytedance.awemeopen.apps.framework.comment.write.f.a;
            Intrinsics.checkNotNull(r16);
            com.bytedance.awemeopen.apps.framework.comment.write.n r17 = r16.get();
            if (r17 == null) goto L74;
            final s r18 = r17.g;
            Intrinsics.checkNotNull(r18);
        L75:
            Intrinsics.checkNotNull(r18);
            ManagerContext r19 = r1.d;
            WeakReference<com.bytedance.awemeopen.apps.framework.comment.write.n> r20 = com.bytedance.awemeopen.apps.framework.comment.write.f.a;
            if (r20 == null) goto L78;
            com.bytedance.awemeopen.apps.framework.comment.write.n r21 = r20.get();
        L79:
            r19.c = r21;
            com.bytedance.awemeopen.apps.framework.comment.write.c r22 = r1.I();
            if (r22 == null) goto L86;
            CommentInputContentViewModel r23 = (CommentInputContentViewModel) r1.d.q.getValue();
            if (r23 == null) goto L84;
            Editable r24 = r23.getContent(r1.d.c());
        L85:
            ((BaseInputPanel) r22).z(new fz3.a(r24, null));
            goto L86
        L84:
            r24 = null;
        L86:
            c r25 = r1.h;
            com.bytedance.awemeopen.apps.framework.comment.write.refactor.g r26 = r18.k;
            if (r26 == null) goto L90;
            r26.p = r25;
        L90:
            com.bytedance.awemeopen.apps.framework.comment.write.refactor.m r27 = r18.l;
            r27.d = r25;
            d r28 = r1.j;
            if (r26 == null) goto L94;
            r26.r = r28;
        L94:
            r27.e = r28;
            e r29 = r1.i;
            if (r26 == null) goto L98;
            r26.q = r29;
        L98:
            r27.f = r29;
            iy3.a<?> r30 = r1.d.b();
            com.bytedance.awemeopen.apps.framework.comment.write.refactor.g r31 = r18.k;
            if (r31 == null) goto L101;
            r31.f = r30;
        L101:
            r18.l.a = r30;
            hy3.b r32 = r1.d.g;
            if (r32 == null) goto L105;
            String r33 = r32.c;
            if (r33 == null) goto L105;
        L106:
            Intrinsics.checkNotNullParameter(r33, "scene");
            if (r18.k == null) goto L110;
            Intrinsics.checkNotNullParameter(r33, "<set-?>");
        L110:
            com.bytedance.awemeopen.apps.framework.comment.write.refactor.m r34 = r18.l;
            r34.getClass();
            Intrinsics.checkNotNullParameter(r33, "<set-?>");
            r34.b = r33;
            ManagerContext r35 = r1.d;
            hy3.b r36 = r35.g;
            if (r36 == null) goto L113;
            hy3.a r37 = r36.e;
        L114:
            if (r37 == null) goto L116;
            r7 = "";
        L116:
            com.bytedance.awemeopen.apps.framework.comment.write.refactor.g r38 = r18.k;
            if (r38 == null) goto L120;
            r38.j = r7;
        L120:
            com.bytedance.awemeopen.apps.framework.comment.write.refactor.m r39 = r18.l;
            r39.g = r7;
            bz3.b r40 = r35.h;
            if (r38 == null) goto L124;
            r38.o = r40;
        L124:
            r39.h = r40;
            if (r18.g == null) goto L127;
            r18.r();
            r18.B();
        L127:
            View r41 = r18.g;
            if (r41 == null) goto L135;
            r41.postDelayed(new r(r18), 500);
        L135:
            hy3.b r42 = r1.d.g;     // Catch: IllegalStateException -> L132
            Intrinsics.checkNotNullParameter("input", "tag");     // Catch: IllegalStateException -> L132
            r18.e.U0("input");     // Catch: IllegalStateException -> L132
            return;
        L132:
            e = move-exception;
            AoLogger.c("write_comment", new Object[]{"commonShowKeyboard: " + e.getMessage()});
            return;
        L113:
            r37 = null;
        L105:
            r33 = "";
            goto L106
        L78:
            r21 = null;
            goto L79
        L74:
            r18 = null;
            goto L75
        L32:
            String r43 = r5.getActivity().toString();
            WeakReference<com.bytedance.awemeopen.apps.framework.comment.write.n> r44 = com.bytedance.awemeopen.apps.framework.comment.write.f.a;
            if (r44 == null) goto L39;
            com.bytedance.awemeopen.apps.framework.comment.write.n r45 = r44.get();
            if (r45 == null) goto L39;
            com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b r46 = r45.a;
            if (r46 == null) goto L39;
            Activity r47 = r46.getActivity();
        L41:
            if (Intrinsics.areEqual(r43, String.valueOf(r47)) == false) goto L55;
            WeakReference<com.bytedance.awemeopen.apps.framework.comment.write.n> r48 = com.bytedance.awemeopen.apps.framework.comment.write.f.a;
            if (r48 == null) goto L71;
            com.bytedance.awemeopen.apps.framework.comment.write.n r49 = r48.get();
            if (r49 == null) goto L71;
            r49.n = r9;
            s r50 = r49.g;
            if (r50 == null) goto L71;
            r50.q = r9;
            if (r50.k != null) goto L51;
            r50.C();
        L51:
            com.bytedance.awemeopen.apps.framework.comment.write.refactor.g r51 = r50.k;
            if (r51 == null) goto L71;
            r51.k = r9.c;
            goto L71
        L55:
            WeakReference<com.bytedance.awemeopen.apps.framework.comment.write.n> r52 = new WeakReference(new com.bytedance.awemeopen.apps.framework.comment.write.n(r5));
            com.bytedance.awemeopen.apps.framework.comment.write.f.a = r52;
            com.bytedance.awemeopen.apps.framework.comment.write.n r53 = r52.get();
            if (r53 == null) goto L66;
            r53.n = r9;
            s r54 = r53.g;
            if (r54 == null) goto L66;
            r54.q = r9;
            if (r54.k != null) goto L62;
            r54.C();
        L62:
            com.bytedance.awemeopen.apps.framework.comment.write.refactor.g r55 = r54.k;
            if (r55 == null) goto L66;
            r55.k = r9.c;
        L66:
            WeakReference<com.bytedance.awemeopen.apps.framework.comment.write.n> r56 = com.bytedance.awemeopen.apps.framework.comment.write.f.a;
            if (r56 == null) goto L71;
            com.bytedance.awemeopen.apps.framework.comment.write.n r57 = r56.get();
            if (r57 == null) goto L71;
            r57.a();
        L39:
            r47 = null;
            goto L41
        L14:
            r8 = null;
            goto L15
        L137:
            return;
        L5:
            r3 = false;
            goto L6
        }

        @Override // cz3.g
        public final void n(cz3.c.a r2) {
            Intrinsics.checkNotNullParameter(r2, "keyBoardServices");
            ((ArrayList) this.a.g).remove(r2);
        }
    }

    public static final class b {
    }

    public static final class c implements com.bytedance.awemeopen.apps.framework.comment.write.h {
        public final /* synthetic */ k a;

        public c(k r1) {
            this.a = r1;
        }

        @Override // com.bytedance.awemeopen.apps.framework.comment.write.h
        public final void a(CommentMobParameters r4) {
            CommentMobParameters.a r0 = new CommentMobParameters.a();
            Map<String, Object> r1 = null;
            if (r4 == null) goto L5;
            String r2 = r4.getAuthorOpenId();
        L6:
            r0.d = r2;
            if (r4 == null) goto L9;
            String r3 = r4.getEnterFrom();
        L10:
            r0.b = r3;
            if (r4 == null) goto L13;
            String r5 = r4.getPreviousPage();
        L14:
            r0.l = r5;
            if (r4 == null) goto L17;
            String r6 = r4.getGroupId();
        L18:
            r0.c = r6;
            if (r4 == null) goto L21;
            String r7 = r4.getImprId();
        L22:
            r0.e = r7;
            if (r4 == null) goto L25;
            String r8 = r4.getCommentId();
        L26:
            r0.j = r8;
            if (r4 == null) goto L29;
            String r9 = r4.getCommentCategory();
        L30:
            r0.f = r9;
            if (r4 == null) goto L33;
            JSONObject r10 = r4.getHostExtraParams();
        L34:
            r0.m = r10;
            if (r4 == null) goto L37;
            r1 = r4.getExtraParams();
        L37:
            r0.o = r1;
            CommentMobParameters r11 = new CommentMobParameters(r0);
            Iterator<T> r12 = this.a.g.iterator();
        L39:
            if (r12.hasNext() == false) goto L41;
            ((jy3.d) r12.next()).e(r11);
            goto L39
        L41:
            return;
        L33:
            r10 = null;
            goto L34
        L29:
            r9 = null;
            goto L30
        L25:
            r8 = null;
            goto L26
        L21:
            r7 = null;
            goto L22
        L17:
            r6 = null;
            goto L18
        L13:
            r5 = null;
            goto L14
        L9:
            r3 = null;
            goto L10
        L5:
            r2 = null;
            goto L6
        }
    }

    public static final class d implements com.bytedance.awemeopen.apps.framework.comment.write.i {
        public final /* synthetic */ ManagerContext a;
        public final /* synthetic */ k b;

        @Override // com.bytedance.awemeopen.apps.framework.comment.write.i
        public final void b() {
            Iterator r0 = ((ArrayList) this.b.g).iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((jy3.d) r0.next()).getClass();
            goto L4
        }

        @Override // com.bytedance.awemeopen.apps.framework.comment.write.i
        public final void c(CommentMobParameters r9) {
            this.b.getClass();
            LinkedHashMap r3 = new LinkedHashMap();
            String r0 = "";
            if (r9 == null) goto L6;
            String r1 = r9.getEnterFrom();
            if (r1 == null) goto L6;
        L7:
            r3.put("enter_from", r1);
            if (r9 == null) goto L11;
            String r2 = r9.getAuthorOpenId();
            if (r2 == null) goto L11;
        L12:
            r3.put("author_openid", r2);
            if (r9 == null) goto L16;
            String r4 = r9.getGroupId();
            if (r4 == null) goto L16;
        L17:
            r3.put("group_id", r4);
            String r5 = null;
            if (r9 == null) goto L20;
            String r6 = r9.getEmojiToKeyboardMethod();
        L21:
            if (r6 != null) goto L23;
        L26:
            boolean r7 = true;
        L27:
            if (r7 == true) goto L31;
            if (r9 == null) goto L30;
            r5 = r9.getEmojiToKeyboardMethod();
        L30:
            Intrinsics.checkNotNull(r5);
        L34:
            r3.put("enter_method", r5);
            r3.put("close_method", "enter_emoji_board");
            if (r9 == null) goto L38;
            String r8 = r9.getImprId();
            if (r8 == null) goto L38;
        L39:
            r3.put("impr_id", r8);
            if (r9 == null) goto L43;
            String r10 = r9.getCommentCategory();
            if (r10 == null) goto L43;
        L44:
            r3.put("comment_category", r10);
            String r11 = r9.getPreviousPage();
            if (r11 == null) goto L48;
            r0 = r11;
        L48:
            r3.put(BaseFollowStoreViewModel.KEY_PREVIOUS_PAGE, r0);
            AosEventReporter.s(AosEventReporter.a, "close_text", r3, null, null, null, 28);
            Iterator r12 = ((ArrayList) this.b.g).iterator();
        L50:
            if (r12.hasNext() == false) goto L52;
            ((jy3.d) r12.next()).getClass();
            goto L50
        L52:
            return;
        L43:
            r10 = "original";
        L38:
            r8 = "";
            goto L39
        L31:
            if (r9 == null) goto L33;
            r5 = r9.getClickType();
        L33:
            Intrinsics.checkNotNull(r5);
            goto L34
        L23:
            if (r6.length() == 0) goto L26;
            r7 = false;
            goto L27
        L20:
            r6 = null;
        L16:
            r4 = "";
        L11:
            r2 = "";
        L6:
            r1 = "";
            goto L7
        }

        public d(ManagerContext r1, k r2) {
            this.a = r1;
            this.b = r2;
            r1.getClass();
        }

        @Override // com.bytedance.awemeopen.apps.framework.comment.write.i
        public final void a(CommentMobParameters r3, String r4) {
            Iterator r0 = ((ArrayList) this.b.g).iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((jy3.d) r0.next()).b(r3, r4);
            goto L4
        }

        @Override // com.bytedance.awemeopen.apps.framework.comment.write.i
        public final void d(CharSequence r1, List<? extends TextExtraStruct> r2, String r3, CommentMobParameters r4) {
            i r5 = this.a.n;
            if (r5 != null) goto L5;
        L7:
            boolean r6 = false;
        L8:
            if (r6 == false) goto L10;
            return;
        L10:
            Iterator r7 = ((ArrayList) this.b.g).iterator();
        L12:
            if (r7.hasNext() == false) goto L14;
            ((jy3.d) r7.next()).a(r1, r4);
            goto L12
        L14:
            return;
        L5:
            if (r5.k() == true) goto L7;
            r6 = true;
            goto L8
        }
    }

    public static final class e implements com.bytedance.awemeopen.apps.framework.comment.write.j {
        public final /* synthetic */ ManagerContext a;
        public final /* synthetic */ k b;

        @Override // com.bytedance.awemeopen.apps.framework.comment.write.j
        public final void a(CommentMobParameters r7) {
            CommentInputContentViewModel r0 = (CommentInputContentViewModel) this.b.d.q.getValue();
            if (r0 == null) goto L7;
            Editable r1 = r0.getContent(this.a.c());
            if (r1 == null) goto L7;
            String r2 = r1.toString();
        L9:
            if (TextUtils.isEmpty(r2) == false) goto L11;
            boolean r3 = true;
        L12:
            List<jy3.d> r4 = this.b.g;
            ManagerContext r5 = this.a;
            Iterator r6 = ((ArrayList) r4).iterator();
        L14:
            if (r6.hasNext() == false) goto L16;
            jy3.d r8 = (jy3.d) r6.next();
            q14.a r9 = r5.k;
            r8.c(r7);
            goto L14
        L16:
            if (r3 == false) goto L20;
            bz3.b r10 = this.a.h;
            if (r10 == null) goto L40;
            r10.e();
            return;
        L40:
            return;
        L20:
            ManagerContext r11 = this.a;
            if (Intrinsics.areEqual(r11.k, null) == true) goto L42;
            CommentInputContentViewModel r12 = (CommentInputContentViewModel) r11.q.getValue();
            if (r12 == null) goto L26;
            r12.putEmoji(r11.c(), null);
        L26:
            Iterator r13 = ((ArrayList) r11.j).iterator();
        L28:
            if (r13.hasNext() == false) goto L32;
            dz3.a r14 = (dz3.a) r13.next();
            if (r14 == null) goto L28;
            r14.a();
            goto L28
        L32:
            r11.k = null;
            return;
        L42:
            return;
        L11:
            r3 = false;
        L7:
            r2 = null;
            goto L9
        }

        @Override // com.bytedance.awemeopen.apps.framework.comment.write.j
        public final void b(CommentMobParameters r5) {
            CommentSharkViewModel.a r0 = CommentSharkViewModel.Companion;
            ViewModelStoreOwner r1 = this.a.b.e;
            r0.getClass();
            CommentSharkViewModel r2 = CommentSharkViewModel.a.a(r1);
            if (r2 == null) goto L5;
            r2.onKeyboardPanelShowTime();
        L5:
            List<jy3.d> r3 = this.b.g;
            ManagerContext r4 = this.a;
            Iterator r6 = ((ArrayList) r3).iterator();
        L7:
            if (r6.hasNext() == false) goto L9;
            jy3.d r7 = (jy3.d) r6.next();
            boolean r8 = r4.i;
            r7.d(r5);
            goto L7
        L9:
            this.a.i = false;
        }

        public e(ManagerContext r1, k r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    @Override // az3.a
    public final void C() {
        WeakReference<com.bytedance.awemeopen.apps.framework.comment.write.n> r0 = com.bytedance.awemeopen.apps.framework.comment.write.f.a;
        com.bytedance.awemeopen.apps.framework.comment.write.f.a = null;
        ((ArrayList) this.g).clear();
    }

    public final com.bytedance.awemeopen.apps.framework.comment.write.c I() {
        com.bytedance.awemeopen.apps.framework.comment.write.d r0 = this.d.c;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getPanel();
    }

    public k(ManagerContext r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "managerContext");
        Intrinsics.checkNotNullParameter(r3, "tag");
        super(r2, r3);
        this.g = new ArrayList();
        a r0 = new a(this);
        H(g.class, r0);
        r2.o = r0;
        this.h = new c(this);
        this.i = new e(r2, this);
        this.j = new d(r2, this);
    }
}
