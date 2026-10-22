package com.bytedance.ee.bear.middleground.comment.extension.addins;

import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.Reaction;
import com.bytedance.ee.bear.middleground.comment.export.bean.ReactionDetailUserInfo;
import com.bytedance.ee.bear.middleground.comment.export.reaction.ReactionFlowCacheEntity;
import com.bytedance.ee.bear.middleground.comment.extension.events.ReactionCacheActionType;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d0 extends com.bytedance.ee.bear.middleground.comment.extension.addins.b {
    public lf5.b b;

    public final class a extends ff5.a<ef5.a> {
        public final /* synthetic */ d0 a;

        public a(d0 r1) {
            this.a = r1;
        }

        @Override // ff5.a
        public final void b(gf5.c r18) {
            ef5.a r1 = (ef5.a) r18;
            Intrinsics.checkNotNullParameter(r1, "event");
            tt5.a.h("Comment#ReactionCacheAddin", "handle event: " + r1);
            CommentBean r2 = r1.a;
            if (r2 == null) goto L127;
            List<CommentBean.CommentDetail> r3 = r2.getComment_list();
            int r5 = 1;
            if (r3 != null) goto L8;
        L11:
            boolean r4 = true;
        L12:
            if (r4 == false) goto L14;
            tt5.a.h("Comment#ReactionCacheAddin", "BeforeItemPageDataChangeEventHandler, comment_list is null or empty");
            return;
        L14:
            Iterator<CommentBean.CommentDetail> r6 = r2.getComment_list().iterator();
        L16:
            if (r6.hasNext() == false) goto L128;
            CommentBean.CommentDetail r7 = r6.next();
            lf5.b r8 = this.a.b;
            if (r8 != null) goto L20;
            Intrinsics.throwUninitializedPropertyAccessException("reactionCacheManager");
            r8 = null;
        L20:
            lf5.b r9 = this.a.b;
            if (r9 != null) goto L23;
            Intrinsics.throwUninitializedPropertyAccessException("reactionCacheManager");
            r9 = null;
        L23:
            String r10 = r7.getComment_id();
            String r11 = r7.getReply_id();
            r9.getClass();
            String r12 = lf5.b.a(r10, r11);
            Intrinsics.checkNotNull(r7);
            r8.getClass();
            Intrinsics.checkNotNullParameter(r12, "key");
            Intrinsics.checkNotNullParameter(r7, "item");
            Set r13 = (Set) ((LinkedHashMap) r8.a).get(r12);
            List<Reaction> r14 = r7.getReaction();
            tt5.a.h("Comment#ReactionCacheManager", "mergeReaction, start to merge: key: " + r12 + ", itemReactions: " + r14);
            Set r15 = r13;
            if (r15 != null) goto L26;
        L29:
            boolean r16 = true;
        L30:
            if (r16 == false) goto L32;
            tt5.a.h("Comment#ReactionCacheManager", "mergeReaction, but no cache");
        L108:
            r5 = 1;
            goto L16
        L32:
            tt5.a.h("Comment#ReactionCacheManager", "mergeReaction, cacheReactions: " + r13);
            if (r14 == null) goto L36;
            List<Reaction> r17 = CollectionsKt.toMutableList(r14);
            if (r17 == null) goto L36;
        L37:
            Iterator r19 = r13.iterator();
            boolean r20 = false;
        L39:
            if (r19.hasNext() == false) goto L105;
            ReactionFlowCacheEntity r110 = (ReactionFlowCacheEntity) r19.next();
            int r111 = lf5.b.C0259b.a[r110.d.ordinal()];
            if (r111 == (-1)) goto L102;
            if (r111 != r5) goto L44;
            Iterator<Reaction> r21 = r17.iterator();
            int r22 = 0;
        L77:
            if (r21.hasNext() == false) goto L82;
            if (Intrinsics.areEqual(r21.next().getReactionKey(), r110.a) == true) goto L83;
            r22 = r22 + 1;
        L83:
            if (r22 == (-1)) goto L95;
            List<ReactionDetailUserInfo> r23 = CollectionsKt.toMutableList(((Reaction) ListProtector.get(r17, r22)).getUserList());
            Iterator<ReactionDetailUserInfo> r24 = r23.iterator();
            int r112 = 0;
        L86:
            if (r24.hasNext() == false) goto L91;
            if (Intrinsics.areEqual(r24.next().getUserId(), r110.b) == true) goto L92;
            r112 = r112 + 1;
        L92:
            if (r112 != (-1)) goto L94;
            ReactionDetailUserInfo r25 = new ReactionDetailUserInfo();
            r25.setUserId(r110.b);
            r25.setUserName(r110.c);
            ListProtector.add(r23, 0, r25);
            ((Reaction) ListProtector.get(r17, r22)).setUserList(r23);
            Reaction r26 = (Reaction) ListProtector.get(r17, r22);
            r26.setTotalCount(r26.getTotalCount() + 1);
        L96:
            tt5.a.h("Comment#ReactionCacheManager", "merge add reaction, cacheEntity: " + r110);
            boolean r27 = true;
        L97:
            if (r27 == true) goto L101;
            if (r20 == true) goto L101;
        L100:
            r20 = false;
        L103:
            r5 = 1;
        L101:
            r20 = true;
            goto L103
        L94:
            r27 = false;
            goto L97
        L91:
            r112 = -1;
            goto L92
        L95:
            Reaction r28 = new Reaction();
            r28.setReactionKey(r110.a);
            r28.setReferType("COMMENT_REACTION");
            r28.setReferKey(r110.e);
            ReactionDetailUserInfo r29 = new ReactionDetailUserInfo();
            r29.setUserId(r110.b);
            r29.setUserName(r110.c);
            r28.setUserList(CollectionsKt.listOf(r29));
            r28.setTotalCount(1);
            r17.add(r28);
            goto L96
        L82:
            r22 = -1;
            goto L83
        L44:
            if (r111 != 2) goto L74;
            Iterator<Reaction> r113 = r17.iterator();
            int r114 = 0;
        L47:
            if (r113.hasNext() == false) goto L52;
            if (Intrinsics.areEqual(r113.next().getReactionKey(), r110.a) == true) goto L53;
            r114 = r114 + 1;
        L53:
            if (r114 == (-1)) goto L67;
            List<ReactionDetailUserInfo> r30 = CollectionsKt.toMutableList(((Reaction) ListProtector.get(r17, r114)).getUserList());
            Iterator<ReactionDetailUserInfo> r115 = r30.iterator();
            int r116 = 0;
        L56:
            if (r115.hasNext() == false) goto L61;
            if (Intrinsics.areEqual(r115.next().getUserId(), r110.b) == true) goto L62;
            r116 = r116 + 1;
        L62:
            if (r116 == (-1)) goto L67;
            ListProtector.remove(r30, r116);
            ((Reaction) ListProtector.get(r17, r114)).setUserList(r30);
            Reaction r31 = (Reaction) ListProtector.get(r17, r114);
            r31.setTotalCount(r31.getTotalCount() - 1);
            if (((Reaction) ListProtector.get(r17, r114)).getTotalCount() != 0) goto L66;
            ListProtector.remove(r17, r114);
        L66:
            tt5.a.h("Comment#ReactionCacheManager", "merge delete reaction, cacheEntity: " + r110);
            boolean r32 = true;
        L68:
            if (r32 == true) goto L101;
            if (r20 == false) goto L100;
        L61:
            r116 = -1;
        L67:
            r32 = false;
            goto L68
        L52:
            r114 = -1;
            goto L53
        L74:
            throw new NoWhenBranchMatchedException();
        L102:
            tt5.a.d("Comment#ReactionCacheManager", "mergeReaction, cacheInfo status is null, cacheInfo: " + r110);
            goto L103
        L105:
            if (r20 == false) goto L107;
            tt5.a.h("Comment#ReactionCacheManager", "mergeReaction, merge completed: " + r12 + ", changed, targetReactions: " + r17);
            r7.setReaction(r17);
            com.bytedance.ee.bear.middleground.comment.uitls.s.a r33 = ((com.bytedance.ee.bear.middleground.comment.export.n) org.koin.java.a.c(com.bytedance.ee.bear.middleground.comment.export.n.class, null, null, 6)).c();
            List<Reaction> r34 = r7.getReaction();
            String r35 = r7.getReaction_type();
            String r36 = r7.getReply_id();
            r33.getClass();
            Intrinsics.checkNotNullParameter(r7, "commentDetail");
            com.bytedance.ee.bear.middleground.comment.uitls.s.c(r7, r34, r35, r36);
            goto L108
        L107:
            tt5.a.h("Comment#ReactionCacheManager", "mergeReaction, merge completed: " + r12 + ", no change");
        L36:
            r17 = new ArrayList();
            goto L37
        L26:
            if (r15.isEmpty() == true) goto L29;
            r16 = false;
            goto L30
        L128:
            return;
        L8:
            if (r3.isEmpty() == true) goto L11;
            r4 = false;
            goto L12
        }
    }

    public static final class b {
    }

    public final class c extends ff5.a<ef5.b0> {
        public final /* synthetic */ d0 a;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[ReactionCacheActionType.values().length];
                r0[ReactionCacheActionType.CACHE_ADD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r0[ReactionCacheActionType.CACHE_DELETE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r0[ReactionCacheActionType.REMOVE_CACHE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                a = r0;
            }
        }

        public c(d0 r1) {
            this.a = r1;
        }

        @Override // ff5.a
        public final void b(gf5.c r14) {
            ef5.b0 r15 = (ef5.b0) r14;
            Intrinsics.checkNotNullParameter(r15, "event");
            int r0 = a.a[r15.a.ordinal()];
            boolean r1 = true;
            if (r0 != 1) goto L5;
            d0.c(this.a, r15, ReactionFlowCacheEntity.STATUS.ADD);
            return;
        L5:
            if (r0 != 2) goto L7;
            d0.c(this.a, r15, ReactionFlowCacheEntity.STATUS.DELETE);
            return;
        L7:
            if (r0 == 3) goto L9;
            tt5.a.h("Comment#ReactionCacheAddin", "handle unknown event: " + r15);
            return;
        L9:
            d0 r2 = this.a;
            r2.getClass();
            tt5.a.h("Comment#ReactionCacheAddin", "removeCache() called with: event = " + r15);
            lf5.b r3 = r2.b;
            lf5.b r4 = null;
            if (r3 != null) goto L12;
            Intrinsics.throwUninitializedPropertyAccessException("reactionCacheManager");
            r3 = null;
        L12:
            lf5.b r5 = r2.b;
            if (r5 != null) goto L15;
            Intrinsics.throwUninitializedPropertyAccessException("reactionCacheManager");
        L16:
            String r6 = r15.b;
            String r7 = r15.c;
            r4.getClass();
            String r8 = lf5.b.a(r6, r7);
            String r9 = r15.d;
            String r16 = r15.e;
            r3.getClass();
            Intrinsics.checkNotNullParameter(r8, "key");
            Intrinsics.checkNotNullParameter(r9, "reactionKey");
            Intrinsics.checkNotNullParameter(r16, "actionId");
            Set r10 = (Set) ((LinkedHashMap) r3.a).get(r8);
            Set r11 = r10;
            if (r11 != null) goto L19;
        L22:
            boolean r12 = true;
        L24:
            if (r12 == false) goto L26;
            tt5.a.h("Comment#ReactionCacheManager", "removeCache, key: " + r8 + ", reactionKey: " + r9 + ", actionId: " + r16 + ", but reactionCacheSet is empty");
            return;
        L26:
            Iterator r13 = r10.iterator();
        L28:
            if (r13.hasNext() == false) goto L36;
            ReactionFlowCacheEntity r17 = (ReactionFlowCacheEntity) r13.next();
            if (Intrinsics.areEqual(r17.a, r9) == false) goto L28;
            if (Intrinsics.areEqual(r17.g, r16) == false) goto L28;
            Set r18 = (Set) ((LinkedHashMap) r3.a).get(r8);
            if (r18 == null) goto L36;
            r18.remove(r17);
        L36:
            tt5.a.h("Comment#ReactionCacheManager", "removeCache, key: " + r8 + ", reactionKey: " + r9 + ", actionId: " + r16 + ", reactionCacheSet: " + r10);
            Collection r19 = (Collection) ((LinkedHashMap) r3.a).get(r8);
            if (r19 != null) goto L39;
        L42:
            if (r1 == false) goto L55;
            r3.a.remove(r8);
            return;
        L55:
            return;
        L39:
            if (r19.isEmpty() == true) goto L42;
            r1 = false;
            goto L42
        L19:
            if (r11.isEmpty() == true) goto L22;
            r12 = false;
            goto L24
        L15:
            r4 = r5;
            goto L16
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.extension.addins.b, gf5.b
    public final void onDestroy() {
        tt5.a.h("Comment#ReactionCacheAddin", "onDestroy() called");
        lf5.b r0 = this.b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("reactionCacheManager");
        r0 = null;
    L5:
        r0.getClass();
        tt5.a.h("Comment#ReactionCacheManager", "clearCache() called");
        ((LinkedHashMap) r0.a).clear();
    }

    public d0() {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.extension.addins.b, gf5.b
    public final void a(cf5.a r5) {
        Intrinsics.checkNotNullParameter(r5, "host");
        Intrinsics.checkNotNullParameter(r5, "host");
        this.a = r5;
        boolean r0 = com.bytedance.ee.bear.appsetting.c.a.a.h("ccm.mobile.comment.reaction_display_quickly");
        tt5.a.h("Comment#ReactionCacheAddin", "onCreate() called, isReactionQuickDisplayEnabled: " + r0);
        lf5.b.a r1 = lf5.b.b;
        lf5.b r2 = lf5.b.c;
        if (r2 != null) goto L13;
        monitor-enter(r1);
        r2 = lf5.b.c;     // Catch: Throwable -> L10
        if (r2 != null) goto L8;
        r2 = new lf5.b();     // Catch: Throwable -> L10
        lf5.b.c = r2;     // Catch: Throwable -> L10
    L8:
        monitor-exit(r1);
    L10:
        th = move-exception;
        throw th;
    L13:
        this.b = r2;
        if (r0 == false) goto L19;
        r5.b(ef5.b0.class, new c(this));
        r5.b(ef5.a.class, new a(this));
        return;
    }

    public static final void c(d0 r10, ef5.b0 r11, ReactionFlowCacheEntity.STATUS r12) {
        r10.getClass();
        tt5.a.h("Comment#ReactionCacheAddin", "cacheReaction() called with: event = " + r11);
        lf5.b r0 = r10.b;
        lf5.b r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("reactionCacheManager");
        r0 = null;
    L5:
        lf5.b r13 = r10.b;
        if (r13 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("reactionCacheManager");
    L9:
        String r14 = r11.b;
        String r2 = r11.c;
        r1.getClass();
        String r15 = lf5.b.a(r14, r2);
        String r7 = r11.b;
        String r6 = r11.c;
        String r3 = r11.d;
        String r8 = r11.e;
        String r4 = r11.f;
        if (r4 != null) goto L12;
        String r5 = "";
    L13:
        String r16 = r11.g;
        if (r16 != null) goto L16;
        r16 = "";
    L16:
        ReactionFlowCacheEntity r9 = new ReactionFlowCacheEntity(r3, r5, r16, r12, r6, r7, r8);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r15, "key");
        Intrinsics.checkNotNullParameter(r9, "reactionFlowCacheEntity");
        LinkedHashMap r17 = (LinkedHashMap) r0.a;
        Object r18 = r17.get(r15);
        if (r18 != null) goto L19;
        r18 = new LinkedHashSet();
        r17.put(r15, r18);
    L19:
        Set r19 = (Set) r18;
        r19.remove(r9);
        r19.add(r9);
        tt5.a.h("Comment#ReactionCacheManager", "cacheReaction, key: " + r15 + ", reactionFlowCacheInfo: " + r9 + ", reactionSet: size " + r19.size());
        return;
    L12:
        r5 = r4;
        goto L13
    L8:
        r1 = r13;
        goto L9
    }
}
