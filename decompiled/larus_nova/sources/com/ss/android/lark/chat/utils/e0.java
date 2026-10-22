package com.ss.android.lark.chat.utils;

import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.reaction.Reaction;
import com.ss.android.lark.chat.entity.reaction.ReactionInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f416663a = 0;

    static {
    }

    @JvmStatic
    public static final List<ReactionInfo> a(List<? extends Reaction> r100, Map<String, ? extends Chatter> r101) {
        ArrayList r102 = new ArrayList();
        if (r100 == null) goto L17;
        Iterator<T> r103 = r100.iterator();
    L6:
        if (r103.hasNext() == false) goto L17;
        Reaction r104 = (Reaction) r103.next();
        List<String> r105 = r104.getChatterIds();
        HashMap r106 = new HashMap();
        Intrinsics.checkNotNull(r105);
        Iterator<T> r107 = r105.iterator();
    L9:
        if (r107.hasNext() == false) goto L16;
        String r108 = (String) r107.next();
        if (r101 == null) goto L13;
        Chatter r109 = r101.get(r108);
    L14:
        if (r109 == null) goto L9;
        r106.put(r108, new ChatChatter(r109));
        goto L9
    L13:
        r109 = null;
        goto L14
    L16:
        r102.add(new ReactionInfo(r104, r106));
    L17:
        return r102;
    }
}
