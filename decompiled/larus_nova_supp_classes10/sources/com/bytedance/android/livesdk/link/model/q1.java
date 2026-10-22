package com.bytedance.android.livesdk.link.model;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class q1 {
    public static final void a(IBattleLinkerInviteMessageExtra r8, Map<String, String> r9) {
        Intrinsics.checkNotNullParameter(r9, "logMap");
        Object r2 = null;
        String r3 = "none";
        if (r8 == null) goto L20;
        List<IBattleRivalTag> r4 = r8.getSemiFriendTags();
        if (r4 == null) goto L20;
        Iterator<T> r5 = r4.iterator();
    L8:
        if (r5.hasNext() == false) goto L15;
        Object r6 = r5.next();
        if (((IBattleRivalTag) r6).getTagType() != IBattleRivalTag.TagType.TypeRelation.ordinal()) goto L12;
        boolean r7 = true;
    L13:
        if (r7 == false) goto L8;
    L16:
        IBattleRivalTag r10 = (IBattleRivalTag) r6;
        if (r10 == null) goto L20;
        String r11 = r10.getTagDesc();
        if (r11 == null) goto L20;
    L21:
        r9.put("relationship_tag_type", r11);
        if (r8 == null) goto L40;
        List<IBattleRivalTag> r12 = r8.getSemiFriendTags();
        if (r12 == null) goto L40;
        Iterator<T> r13 = r12.iterator();
    L27:
        if (r13.hasNext() == false) goto L34;
        Object r14 = r13.next();
        if (((IBattleRivalTag) r14).getTagType() != IBattleRivalTag.TagType.TypePower.ordinal()) goto L31;
        boolean r15 = true;
    L32:
        if (r15 == false) goto L27;
        r2 = r14;
        goto L34
    L31:
        r15 = false;
    L34:
        IBattleRivalTag r16 = (IBattleRivalTag) r2;
        if (r16 == null) goto L40;
        String r17 = r16.getTagDesc();
        if (r17 == null) goto L40;
        r3 = r17;
    L40:
        r9.put("strength_tag_type", r3);
        return;
    L12:
        r7 = false;
        goto L13
    L15:
        r6 = null;
    L20:
        r11 = "none";
        goto L21
    }
}
