package fg5;

import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.ee.bear.facade.common.widget.BearLottieView;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.facade.common.widget.u;
import com.bytedance.ee.bear.middleground.comment.export.bean.TranslateConfig;
import com.bytedance.ee.bear.middleground.comment.export.n;
import com.bytedance.ee.bear.middleground.comment.uitls.s;
import com.bytedance.ee.bear.middleground.comment.widget.CommentTextView;
import com.bytedance.ee.bear.middleground.comment.widget.RichTextInjector;
import com.bytedance.ee.bear.middleground.feed.export.bean.MessageConfig;
import com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.Notice;
import com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.TextContext;
import com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.content.ContentWraper;
import com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.content.IContent;
import com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.content.normal.NormalContent;
import com.bytedance.ee.bear.middleground.feed.view.apapterv2.BaseFeedItemAdapter;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.reaction.widget.panel.ReactionPanelFacade;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import db5.k;
import gg5.c0;
import gg5.o;
import gg5.p;
import gg5.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a extends BaseFeedItemAdapter<NormalContent> {
    public final String d;
    public final Function0<? extends MessageConfig> e;
    public final un5.a.InterfaceC0318a f;
    public final gg5.b g;
    public final Function1<Integer, Unit> h;
    public final Function5<String, String, String, Boolean, Notice<?>, Unit> i;
    public final Function1<String, Unit> j;

    /* JADX INFO: renamed from: fg5.a$a, reason: collision with other inner class name */
    public static final class C0230a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ View a;

        public b(View r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            this.a.performClick();
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ a a;
        public final /* synthetic */ BearLottieView b;

        public c(a r1, BearLottieView r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            a r0 = this.a;
            BearLottieView r1 = this.b;
            r0.getClass();
            if (r1.getVisibility() == 0) goto L5;
            Object r2 = r1.getParent();
            Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type android.view.View");
            ((View) r2).setTouchDelegate(null);
            return;
        L5:
            Rect r3 = new Rect();
            r1.getHitRect(r3);
            Object r4 = r1.getParent();
            Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.view.View");
            ((View) r4).setTouchDelegate(new TouchDelegate(new Rect(r3.left - 200, r3.top - 30, r3.right + 200, r3.bottom + 200), r1));
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ Notice<NormalContent> a;
        public final /* synthetic */ a b;
        public final /* synthetic */ int c;

        public d(Notice<NormalContent> r1, a r2, int r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r6) {
            Map<String, Boolean> r7 = ((com.bytedance.ee.bear.middleground.comment.export.bean.c) org.koin.java.a.c(com.bytedance.ee.bear.middleground.comment.export.bean.c.class, null, null, 6)).h();
            String r2 = this.a.getReplyId();
            String r3 = "";
            if (r2 != null) goto L5;
            r2 = "";
        L5:
            Map<String, Boolean> r0 = ((com.bytedance.ee.bear.middleground.comment.export.bean.c) org.koin.java.a.c(com.bytedance.ee.bear.middleground.comment.export.bean.c.class, null, null, 6)).h();
            String r1 = this.a.getReplyId();
            if (r1 == null) goto L9;
            r3 = r1;
        L9:
            r7.put(r2, Boolean.valueOf(!Intrinsics.areEqual(r0.get(r3), Boolean.TRUE)));
            this.b.h.invoke(Integer.valueOf(this.c));
        }
    }

    public static final class e implements View.OnLongClickListener {
        public final /* synthetic */ a a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Notice<NormalContent> c;

        public e(a r1, int r2, Notice<NormalContent> r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r4) {
            a r0 = this.a;
            Intrinsics.checkNotNull(r4);
            r0.a(r4, this.b, this.c);
            return true;
        }
    }

    static {
    }

    @Override // ag5.a
    public final int b() {
        return 5;
    }

    public final TranslateConfig g() {
        return ((MessageConfig) this.e.invoke()).getTranslateConfig();
    }

    @Override // com.bytedance.ee.bear.middleground.feed.view.apapterv2.BaseFeedItemAdapter
    public final View f(LayoutInflater r3, ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        Intrinsics.checkNotNullParameter(r4, "parent");
        return r3.inflate(2131563713, r4, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String h(CommentTextView r10, ArrayList<TextContext> r11) {
        StringBuilder r0 = new StringBuilder();
        ArrayList r1 = new ArrayList();
        if (r11 == null) goto L11;
        Iterator<T> r2 = r11.iterator();
    L6:
        if (r2.hasNext() == false) goto L11;
        TextContext r3 = (TextContext) r2.next();
        String r4 = cg5.a.a(r3);
        Integer r5 = r3.getStyleInt();
        if (r5 == null) goto L10;
        r1.add(new k(r0.length(), r0.length() + r4.length(), r5.intValue()));
    L10:
        r0.append(r4);
    L11:
        RichTextInjector.a(r10, CollectionsKt.listOf(this.d), this.f, (k[]) r1.toArray(new k[0]), com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.comment_markdown_enable"));
        if (r11 != null) goto L14;
    L17:
        boolean r12 = true;
    L18:
        if (r12 == false) goto L20;
        r10.setVisibility(8);
    L22:
        return r0.toString();
    L20:
        r10.setVisibility(0);
        goto L22
    L14:
        if (r11.isEmpty() == true) goto L17;
        r12 = false;
        goto L18
    }

    @Override // com.bytedance.ee.bear.middleground.feed.view.apapterv2.BaseFeedItemAdapter
    public final boolean a(View r21, int r22, Notice<?> r23) {
        Intrinsics.checkNotNullParameter(r21, "view");
        Intrinsics.checkNotNullParameter(r23, "notice");
        gg5.b r7 = this.g;
        MessageConfig r4 = (MessageConfig) this.e.invoke();
        r7.getClass();
        Intrinsics.checkNotNullParameter(r21, "view");
        Intrinsics.checkNotNullParameter(r23, "notice");
        Intrinsics.checkNotNullParameter(r4, "messageConfig");
        if (r23.getCommentId() != null) goto L5;
    L101:
        return true;
    L5:
        if (r23.getReplyId() == null) goto L101;
        ArrayList r2 = new ArrayList();
        ContentWraper<Content> r5 = r23.getContent();
        if (r5 == 0) goto L10;
        IContent r6 = r5.getData();
    L12:
        if ((r6 instanceof NormalContent) == false) goto L14;
        NormalContent r8 = (NormalContent) r6;
    L16:
        if (r8 == null) goto L22;
        ArrayList<TextContext> r9 = r8.getSummary();
        if (r9 == null) goto L22;
        TextContext r10 = (TextContext) CollectionsKt.getOrNull(r9, 0);
        if (r10 == null) goto L22;
        String r11 = r10.getText();
    L23:
        ContentWraper<Content> r12 = r23.getContent();
        if (r12 == 0) goto L26;
        IContent r13 = r12.getData();
    L28:
        if ((r13 instanceof NormalContent) == false) goto L30;
        NormalContent r14 = (NormalContent) r13;
    L31:
        if (r14 == null) goto L33;
        String r15 = r14.getTranslateStatus();
    L34:
        TranslateConfig r16 = r4.getTranslateConfig();
        String r17 = r23.getReplyId();
        String r18 = r23.getCommentIdForTranslate();
        ContentWraper<Content> r19 = r23.getContent();
        if (r19 == 0) goto L37;
        IContent r20 = r19.getData();
    L39:
        if ((r20 instanceof NormalContent) == false) goto L41;
        NormalContent r24 = (NormalContent) r20;
    L42:
        if (r24 == null) goto L48;
        ArrayList<TextContext> r25 = r24.getTranslateContent();
        if (r25 == null) goto L48;
        if ((!r25.isEmpty()) != true) goto L48;
        boolean r110 = true;
    L49:
        int r26 = r23.getCommentType();
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (jg5.e.a.a.g() == false) goto L58;
        PermissionResponse r27 = gg5.b.a(r4);
        if (r27 == null) goto L57;
        if (r27.getAllow() != true) goto L57;
        boolean r0 = true;
    L59:
        if (r0 == true) goto L61;
    L63:
        boolean r1 = false;
    L65:
        if (r23.getCanCopy() == false) goto L75;
        if (r1 == false) goto L75;
        if (r11 != null) goto L69;
    L72:
        boolean r3 = true;
    L73:
        if (r3 == true) goto L75;
        TextView r28 = (TextView) r21.findViewById(2131390392);
        String r29 = eu5.b.a.getString(2131887612);
        ((n) org.koin.java.a.c(n.class, null, null, 6)).c().getClass();
        Intrinsics.checkNotNullParameter("COPY", "menuId");
        r2.add(new com.ss.android.lark.reaction.widget.panel.e(r29, s.a("COPY"), new gg5.c(r7, r28, r4)));
    L76:
        com.bytedance.ee.bear.middleground.comment.export.bean.c r30 = (com.bytedance.ee.bear.middleground.comment.export.bean.c) org.koin.java.a.c(com.bytedance.ee.bear.middleground.comment.export.bean.c.class, null, null, 6);
        Intrinsics.checkNotNull(r16);
        if (r30.b(r16, r17, r15, r11) == false) goto L79;
    L86:
        Integer r111 = Integer.valueOf(r26);
        if (((com.bytedance.ee.bear.middleground.comment.export.bean.c) org.koin.java.a.c(com.bytedance.ee.bear.middleground.comment.export.bean.c.class, null, null, 6)).b(r16, r17, r15, r11) == false) goto L90;
        String r31 = eu5.b.a.getString(2131887626);
        boolean r32 = true;
    L94:
        ((n) org.koin.java.a.c(n.class, null, null, 6)).c().getClass();
        Intrinsics.checkNotNullParameter("TRANSLATE", "menuId");
        String r112 = "LongClickHandler";
        r2.add(new com.ss.android.lark.reaction.widget.panel.e(r31, s.a("TRANSLATE"), new gg5.d(r32, r17, r7, r22, r16, r15, r11, r110, r18, r111)));
    L96:
        if (r2.isEmpty() == false) goto L100;
        tt5.a.h(r112, "no reaction, show toast");
        if (r1 == true) goto L101;
        Toast.showFailureText(r21.getContext(), 2131889892);
        goto L101
    L100:
        ArrayList r33 = new ArrayList();
        ReactionPanelFacade.ReactionScene r34 = ReactionPanelFacade.ReactionScene.IM;
        Context r35 = r21.getContext();
        ReactionPanelFacade.ReactionScene r113 = ReactionPanelFacade.ReactionScene.CCM;
        r33.clear();
        r33.addAll(r2);
        new ReactionPanelFacade(r35, r21, r33, false, null, false, true, 2131953375, -1, -1, true, r113, "").f(r21);
        return true;
    L90:
        if (((com.bytedance.ee.bear.middleground.comment.export.bean.c) org.koin.java.a.c(com.bytedance.ee.bear.middleground.comment.export.bean.c.class, null, null, 6)).c(r16, r17, r15, r11) == false) goto L92;
        r31 = eu5.b.a.getString(2131887627);
    L93:
        r32 = false;
        goto L94
    L92:
        r31 = eu5.b.a.getString(2131887635);
        goto L93
    L79:
        if (((com.bytedance.ee.bear.middleground.comment.export.bean.c) org.koin.java.a.c(com.bytedance.ee.bear.middleground.comment.export.bean.c.class, null, null, 6)).c(r16, r17, r15, r11) == true) goto L86;
        if (((com.bytedance.ee.bear.middleground.comment.export.bean.c) org.koin.java.a.c(com.bytedance.ee.bear.middleground.comment.export.bean.c.class, null, null, 6)).g(r16, r17, r15, r11) == true) goto L83;
    L85:
        r112 = "LongClickHandler";
        goto L96
    L83:
        if (r23.getCanTranslate() == false) goto L85;
    L69:
        if (r11.length() == 0) goto L72;
        r3 = false;
    L75:
        tt5.a.h("LongClickHandler", "no perm no copy button");
        goto L76
    L61:
        if (r4.isCanCopy() == false) goto L63;
        r1 = true;
    L57:
        r0 = false;
        goto L59
    L58:
        r0 = ((gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6)).g("CCM_CONTENT_COPY", FileBizDomain.FileBizDomainCCM, r4.getDocumentType().b, r4.getToken()).a;
    L48:
        r110 = false;
        goto L49
    L41:
        r24 = null;
        goto L42
    L37:
        r20 = null;
        goto L39
    L33:
        r15 = null;
        goto L34
    L30:
        r14 = null;
        goto L31
    L26:
        r13 = null;
    L22:
        r11 = null;
        goto L23
    L14:
        r8 = null;
        goto L16
    L10:
        r6 = null;
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r16v0, types: [fg5.a] */
    /* JADX WARN: Type inference failed for: r7v1, types: [android.widget.TextView, com.bytedance.ee.bear.middleground.comment.widget.CommentTextView] */
    /* JADX WARN: Type inference failed for: r7v2, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r9v1, types: [android.widget.TextView, androidx.appcompat.widget.AppCompatTextView, com.bytedance.ee.bear.middleground.comment.widget.CommentTextView] */
    @Override // com.bytedance.ee.bear.middleground.feed.view.apapterv2.BaseFeedItemAdapter
    public final void e(View r17, FrameLayout r18, Notice<NormalContent> r19, int r20) {
        Intrinsics.checkNotNullParameter(r17, "itemView");
        Intrinsics.checkNotNullParameter(r18, "frameLayout");
        Intrinsics.checkNotNullParameter(r19, "item");
        ContentWraper r5 = r19.getContent();
        if (r5 == null) goto L63;
        NormalContent r6 = (NormalContent) r5.getData();
        if (r6 == null) goto L64;
        ?? r7 = (CommentTextView) r18.findViewById(2131390392);
        ?? r9 = (CommentTextView) r18.findViewById(2131390399);
        BearLottieView r2 = r18.findViewById(2131376701);
        r7.setOnClickListener(new b(r17));
        String r1 = h(r7, r6.getSummary());
        r7.setMovementMethod(u.a());
        String r10 = h(r9, r6.getTranslateContent());
        if (((com.bytedance.ee.bear.middleground.comment.export.bean.c) org.koin.java.a.c(com.bytedance.ee.bear.middleground.comment.export.bean.c.class, null, null, 6)).e(g(), r19.getReplyId(), r6.getTranslateStatus()) == false) goto L10;
        r7.setRawString(r10);
    L11:
        r7.post(new c(this, r2));
        int r8 = com.bytedance.ee.util.ui.n.v() - com.bytedance.ee.util.ui.n.d(86);
        r7.setMaxWidth(r8);
        r9.setMaxWidth(r8);
        if (((com.bytedance.ee.bear.middleground.comment.export.bean.c) org.koin.java.a.c(com.bytedance.ee.bear.middleground.comment.export.bean.c.class, null, null, 6)).f(g(), r19.getReplyId(), r6.getTranslateStatus()) == false) goto L17;
        r9.setVisibility(0);
        if (((com.bytedance.ee.bear.middleground.comment.export.bean.c) org.koin.java.a.c(com.bytedance.ee.bear.middleground.comment.export.bean.c.class, null, null, 6)).d(g(), r19.getReplyId()) == false) goto L16;
        r9.setRawString(r1);
    L19:
        if (Intrinsics.areEqual(r6.getTranslateStatus(), "loading") == false) goto L27;
        ViewGroup.LayoutParams r11 = r2.getLayoutParams();
        if ((r11 instanceof RelativeLayout.LayoutParams) == false) goto L23;
        RelativeLayout.LayoutParams r12 = (RelativeLayout.LayoutParams) r11;
    L24:
        if (r12 == null) goto L26;
        r12.addRule(8, 2131390392);
    L26:
        r2.playAnimation();
    L42:
        if (((com.bytedance.ee.bear.middleground.comment.export.bean.c) org.koin.java.a.c(com.bytedance.ee.bear.middleground.comment.export.bean.c.class, null, null, 6)).a(g(), r19.getReplyId(), r6.getTranslateStatus()) == false) goto L44;
        int r13 = 0;
    L45:
        r2.setVisibility(r13);
        if (r1 != null) goto L48;
    L51:
        boolean r3 = true;
    L52:
        if (r3 == false) goto L54;
        r7.setVisibility(8);
    L55:
        r2.setOnClickListener(new d(r19, this, r20));
        r7.setOnLongClickListener(new e(this, r20, r19));
        r9.setBackgroundResource(2131233333);
        if (r2.getVisibility() != 0) goto L65;
        ?? r14 = r7;
        if (r9.getVisibility() != 0) goto L61;
        r14 = r9;
    L61:
        r14.getViewTreeObserver().addOnPreDrawListener(new fg5.b(r14, r2));
        return;
    L65:
        return;
    L54:
        r7.setVisibility(0);
        goto L55
    L48:
        if (r1.length() == 0) goto L51;
        r3 = false;
        goto L52
    L44:
        r13 = 8;
        goto L45
    L23:
        r12 = null;
        goto L24
    L27:
        r2.cancelAnimation();
        r2.setFrame(0);
        if (r9.getVisibility() != 0) goto L35;
        ViewGroup.LayoutParams r15 = r2.getLayoutParams();
        if ((r15 instanceof RelativeLayout.LayoutParams) == false) goto L32;
        RelativeLayout.LayoutParams r16 = (RelativeLayout.LayoutParams) r15;
    L33:
        if (r16 == null) goto L42;
        r16.addRule(8, 2131390399);
        goto L42
    L32:
        r16 = null;
        goto L33
    L35:
        ViewGroup.LayoutParams r21 = r2.getLayoutParams();
        if ((r21 instanceof RelativeLayout.LayoutParams) == false) goto L38;
        RelativeLayout.LayoutParams r22 = (RelativeLayout.LayoutParams) r21;
    L39:
        if (r22 == null) goto L42;
        r22.addRule(8, 2131390392);
        goto L42
    L38:
        r22 = null;
        goto L39
    L16:
        r9.setRawString(r10);
        goto L19
    L17:
        r9.setVisibility(8);
        goto L19
    L10:
        r7.setRawString(r1);
        goto L11
    L64:
        return;
    }

    public a(String r2, q r3, un5.a.InterfaceC0318a r4, gg5.b r5, c0 r6, o r7, p r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r2, "userToken");
        Intrinsics.checkNotNullParameter(r3, "getMessageConfig");
        Intrinsics.checkNotNullParameter(r4, "fileSpanClickListener");
        Intrinsics.checkNotNullParameter(r5, "longClickHandler");
        Intrinsics.checkNotNullParameter(r6, "notifyItemChanged");
        Intrinsics.checkNotNullParameter(r7, "toMessage");
        Intrinsics.checkNotNullParameter(r8, "gotoProfile");
        super(r7, r8, r9);
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.g = r5;
        this.h = r6;
        this.i = r7;
        this.j = r8;
    }
}
