package l05;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import com.bytedance.ee.bear.document.comment.bean.Card;
import com.bytedance.ee.bear.document.comment.bean.Per;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.RevisionExtra;
import com.bytedance.ee.bear.middleground.comment.export.bean.SmartReplyData;
import com.bytedance.ee.bear.middleground.comment.export.n;
import com.bytedance.ee.bear.middleground.comment.uitls.s;
import com.bytedance.mira.core.opt.res.NewMiraResourcesManager;
import com.ss.android.lark.utils.LarkContext;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public static final a a = null;
    public static final HashMap<String, Context> b = null;

    /* JADX INFO: renamed from: l05.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0247a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[RevisionExtra.RevisionTypes.values().length];
            r0[RevisionExtra.RevisionTypes.ADD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[RevisionExtra.RevisionTypes.REPLACE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[RevisionExtra.RevisionTypes.DEL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[RevisionExtra.RevisionTypes.FORMAT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ SmartReplyData a;

        public b(SmartReplyData r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            SmartReplyData r0 = this.a;
            r0.setPlainTextPreview((String) r2);
        }
    }

    public static final class c<T> implements Consumer {
        public static final c<T> a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void accept(Object r4) {
            tt5.a.e("Js2NativeComment", "processAndFilterAtContent error ", (Throwable) r4, false);
        }
    }

    public a() {
    }

    static {
        a = new a();
        b = new HashMap();
    }

    public static int b(RevisionExtra.RevisionTypes r1) {
        int r2 = C0247a.a[r1.ordinal()];
        if (r2 != 1) goto L5;
        return 2131889270;
    L5:
        if (r2 != 2) goto L7;
        return 2131889285;
    L7:
        if (r2 != 3) goto L9;
        return 2131889273;
    L9:
        if (r2 != 4) goto L12;
        return 2131889274;
    L12:
        throw new NoWhenBranchMatchedException();
    }

    public static CommentBean a(Card r11, Per r12) {
        CommentBean r0 = new CommentBean();
        r0.setCommentUUID(r11.getCommentUUID());
        r0.setIs_whole(r11.isWhole() ? 1 : 0);
        r0.setQuote(r11.getQuote());
        r0.setPosition(r11.getPosition());
        r0.setBizParams(r11.getBizParams());
        r0.setComment_list(r11.getCommentList());
        r0.setUnSubmitComment(r11.isUnSubmitComment());
        r0.setCommentType(r11.getCommentType());
        r0.setReactionList(r11.getReactionList());
        r0.setCanPerformAction(r11.isCanPerformAction());
        r0.setBlockedActionList(r11.getBlockedActionList());
        r0.setExtra(r11.getExtra());
        if (r0.getComment_list() != null) goto L5;
        r0.setComment_list(new ArrayList());
    L5:
        List<CommentBean.CommentDetail> r1 = r11.getCommentList();
        RevisionExtra.RevisionTypes r3 = null;
        if (r1 == null) goto L28;
        Iterator<T> r2 = r1.iterator();
        int r4 = 0;
    L9:
        if (r2.hasNext() == false) goto L28;
        Object r5 = r2.next();
        int r6 = r4 + 1;
        if (r4 >= 0) goto L13;
        CollectionsKt.throwIndexOverflow();
    L13:
        CommentBean.CommentDetail r7 = (CommentBean.CommentDetail) r5;
        boolean r8 = true;
        if (r4 != 0) goto L16;
        boolean r9 = true;
    L17:
        r7.setFirstReply(r9);
        r7.setComment_id(r11.getCommentId());
        r7.setCommentType(r11.getCommentType());
        r7.setPerSmartReplyPreview(r12.smartReplyPreview);
        s.a r10 = ((n) org.koin.java.a.c(n.class, null, null, 6)).c();
        Intrinsics.checkNotNull(r7);
        List r13 = r7.getReaction();
        String r14 = r7.getReaction_type();
        String r16 = r7.getReply_id();
        r10.getClass();
        Intrinsics.checkNotNullParameter(r7, "commentDetail");
        s.c(r7, r13, r14, r16);
        r7.setOriginalReaction(r7.getReaction());
        SmartReplyData r17 = r7.getSmartReplyData();
        if (r17 == null) goto L27;
        String r18 = r17.getPlainTextPreview();
        if (r18 != null) goto L22;
    L25:
        if (r8 == true) goto L27;
        m05.c.a(r17.getPlainTextPreview(), new b(r17), c.a);
        goto L27
    L22:
        if (r18.length() == 0) goto L25;
        r8 = false;
    L27:
        r4 = r6;
        goto L9
    L16:
        r9 = false;
    L28:
        List<CommentBean.CommentDetail> r19 = r11.getCommentList();
        if (r19 == null) goto L31;
        CommentBean.CommentDetail r110 = (CommentBean.CommentDetail) CollectionsKt.getOrNull(r19, 0);
    L33:
        if (r11.getCommentType() != 2) goto L62;
        if (r110 == null) goto L62;
        CommentBean.Extra r20 = r11.getExtra();
        if (r20 == null) goto L41;
        RevisionExtra r21 = r20.getRevisionExtra();
        if (r21 == null) goto L41;
        r3 = r21.getRevisionTag();
    L41:
        if (r11.getCommentType() != 2) goto L61;
        if (r3 == null) goto L61;
        CommentBean.Extra r22 = r11.getExtra();
        if (r22 == null) goto L49;
        RevisionExtra r23 = r22.getRevisionExtra();
        if (r23 == null) goto L49;
        r23.setRevisionTitle(LarkContext.getApplication().getString(b(r3)));
    L49:
        if (Intrinsics.areEqual(r110.getTranslate_status(), "success") == false) goto L61;
        String r24 = r110.getTargetLanguage();
        HashMap<String, Context> r26 = b;
        Context r27 = r26.get(r24);
        if (r27 != null) goto L53;
        tt5.a.h("Js2NativeComment", "getContext start...");
        Application r28 = LarkContext.getApplication();
        Configuration r29 = new Configuration(r28.getResources().getConfiguration());
        r29.setLocale(new Locale(r24));
        Context r30 = r28.createConfigurationContext(r29);
        NewMiraResourcesManager.getInstance().install(r30);
        tt5.a.h("Js2NativeComment", "getContext end...");
        r26.put(r24, r30);
        Intrinsics.checkNotNull(r30);
        r27 = r30;
    L53:
        CommentBean.Extra r31 = r11.getExtra();
        if (r31 == null) goto L61;
        RevisionExtra r32 = r31.getRevisionExtra();
        if (r32 == null) goto L61;
        if (r27 != null) goto L59;
        String r33 = "";
    L60:
        r32.setRevisionTitleTranslate(r33);
        goto L61
    L59:
        r33 = r27.getResources().getString(b(r3));
        Intrinsics.checkNotNull(r33);
    L61:
        r110.setReplyType(2);
    L62:
        r0.setFinish(r11.getFinish());
        r0.setComment_id(r11.getCommentId());
        r0.setUserId(r11.getUserId());
        r0.setNewInput(r11.isNewInput());
        r0.setCommentAnchorId(r11.getCommentAnchorId());
        r0.setParticipantList(r11.getParticipantList());
        return r0;
    L31:
        r110 = null;
        goto L33
    }
}
