package com.bytedance.ee.bear.middleground.comment.control;

import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.middleground.comment.export.Action;
import com.bytedance.ee.bear.middleground.comment.export.ICardAdapter;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.ss.android.lark.chat.entity.translate.TranslateLanguageSetting;
import com.ss.android.lark.storage.LarkKVStorage;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i extends c0 {
    public final /* synthetic */ Ref.BooleanRef c;
    public final /* synthetic */ CommentBean.CommentDetail d;
    public final /* synthetic */ ICardAdapter e;
    public final /* synthetic */ int f;
    public final /* synthetic */ CommentFunction g;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ CommentFunction a;

        public a(CommentFunction r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            String r4 = (String) r3;
            t r0 = this.a.c;
            Intrinsics.checkNotNull(r4);
            r0.w(r4, Action.TRANSLATE);
        }
    }

    public static final class b<T> implements Consumer {
        public static final b<T> a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final void accept(Object r2) {
            iu5.d.a("Comment#CommentFunction", (Throwable) r2);
        }
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.c0
    public final void a(View r13) {
        Intrinsics.checkNotNullParameter(r13, "view");
        super.a(r13);
        String r3 = "discussion";
        boolean r6 = false;
        String r8 = null;
        if (this.c.element == false) goto L20;
        nf5.a.a.put(this.d.getReply_id(), Boolean.TRUE);
        RecyclerView.Adapter r14 = this.e;
        if ((r14 instanceof RecyclerView.Adapter) == false) goto L7;
        RecyclerView.Adapter r15 = r14;
    L8:
        if (r15 == null) goto L10;
        r15.notifyItemChanged(this.f, nf5.a.b);
    L10:
        com.bytedance.ee.bear.middleground.comment.uitls.h r16 = this.a.d0;
        String r9 = this.e.getCommentId(this.d);
        String r10 = this.d.getReply_id();
        Pair[] r0 = new Pair[2];
        if (this.a.V == true) goto L14;
        r3 = "comment";
    L14:
        r0[0] = TuplesKt.to(ResourceData.KEY_TYPE, r3);
        CommentBean r4 = this.g.c.N(this.d.getComment_id());
        if (r4 == null) goto L19;
        CommentBean.Extra r5 = r4.getExtra();
        if (r5 == null) goto L19;
        r8 = r5.getReportVisibility();
    L19:
        r0[1] = TuplesKt.to("comment_visible_range", r8);
        r16.g("cancel_translate_click", r9, r10, MapsKt.mapOf(r0));
        return;
    L7:
        r15 = null;
        goto L8
    L20:
        Map<String, Boolean> r17 = nf5.a.a;
        if (nf5.a.c(this.a.x, this.d) == false) goto L38;
        Map<String, Boolean> r18 = nf5.a.a;
        r18.put(this.d.getReply_id(), Boolean.valueOf(!Intrinsics.areEqual(((LinkedHashMap) r18).get(this.d.getReply_id()), Boolean.TRUE)));
        RecyclerView.Adapter r19 = this.e;
        if ((r19 instanceof RecyclerView.Adapter) == false) goto L25;
        RecyclerView.Adapter r110 = r19;
    L26:
        if (r110 == null) goto L28;
        r110.notifyItemChanged(this.f, nf5.a.b);
    L28:
        com.bytedance.ee.bear.middleground.comment.uitls.h r111 = this.a.d0;
        String r11 = this.e.getCommentId(this.d);
        String r12 = this.d.getReply_id();
        Pair[] r1 = new Pair[2];
        if (this.a.V == true) goto L32;
        r3 = "comment";
    L32:
        r1[0] = TuplesKt.to(ResourceData.KEY_TYPE, r3);
        CommentBean r7 = this.g.c.N(this.d.getComment_id());
        if (r7 == null) goto L37;
        CommentBean.Extra r20 = r7.getExtra();
        if (r20 == null) goto L37;
        r8 = r20.getReportVisibility();
    L37:
        r1[1] = TuplesKt.to("comment_visible_range", r8);
        r111.g("cancel_translate_click", r11, r12, MapsKt.mapOf(r1));
        return;
    L25:
        r110 = null;
        goto L26
    L38:
        boolean r112 = com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mob.docx.translate_lang_recognition");
        CommentFunction r2 = this.g;
        String r21 = this.d.getTargetLanguage();
        r2.getClass();
        if (r21 != null) goto L41;
        boolean r22 = false;
    L46:
        if (r22 == true) goto L49;
        if (r112 == false) goto L49;
        r6 = true;
    L49:
        if (r6 == false) goto L51;
        nf5.a.a.remove(this.d.getReply_id());
    L51:
        if (r6 == false) goto L53;
    L72:
        this.g.c.a(this.e.getCommentId(this.d), this.d.getCommentType(), this.d.getReply_id()).subscribe(new a(this.g), b.a);
        return;
    L53:
        if (TextUtils.isEmpty(this.d.getTranslate_content()) == true) goto L72;
        nf5.a.a.remove(this.d.getReply_id());
        ICardAdapter r113 = this.e;
        if ((r113 instanceof RecyclerView.Adapter) == false) goto L58;
        r8 = (RecyclerView.Adapter) r113;
    L58:
        if (r8 == null) goto L60;
        r8.notifyItemChanged(this.f, nf5.a.b);
    L60:
        HashMap r114 = new HashMap();
        CommentBean.CommentDetail r23 = this.d;
        CommentFunction r24 = this.g;
        r114.put("user_main_lang", r23.getUserMainLang());
        r114.put("user_default_lang", r23.getUserDefaultTargetLang());
        r114.put("menu_level", "first");
        if (this.a.V == true) goto L64;
        r3 = "comment";
    L64:
        r114.put(ResourceData.KEY_TYPE, r3);
        CommentBean r25 = r24.c.N(r23.getComment_id());
        if (r25 == null) goto L70;
        CommentBean.Extra r26 = r25.getExtra();
        if (r26 == null) goto L70;
        String r27 = r26.getReportVisibility();
        if (r27 == null) goto L70;
    L71:
        r114.put("comment_visible_range", r27);
        this.a.d0.g("translate_click", this.d.getComment_id(), this.d.getReply_id(), r114);
        return;
    L70:
        r27 = "";
        goto L71
    L41:
        TranslateLanguageSetting r28 = (TranslateLanguageSetting) LarkKVStorage.p(new com.ss.android.lark.storage.a("ccm"), "translate", true).getJSONObject("config", TranslateLanguageSetting.class);
        if (r28 == null) goto L44;
        String r29 = r28.getTargetLanguageKey();
    L45:
        r22 = TextUtils.equals(r21, r29);
        goto L46
    L44:
        r29 = null;
        goto L45
    }

    public i(Ref.BooleanRef r1, CommentBean.CommentDetail r2, ICardAdapter r3, int r4, CommentFunction r5, com.bytedance.ee.bear.middleground.comment.uitls.p r6) {
        this.c = r1;
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.g = r5;
        super(r6, "TRANSLATE");
    }
}
