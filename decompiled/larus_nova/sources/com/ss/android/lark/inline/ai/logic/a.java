package com.ss.android.lark.inline.ai.logic;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.inline.ai.api.ui.ParamDetail;
import com.ss.android.lark.inline.ai.api.ui.Prompt;
import com.ss.android.lark.inline.ai.api.ui.PromptGroup;
import com.ss.android.lark.inline.ai.api.ui.TextContentList;
import com.ss.android.lark.inline.ai.utils.StringUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import slb.m;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f427282a = 0;

    static {
    }

    public static Pair a(j r110) {
        Intrinsics.checkNotNullParameter(r110, "userInputText");
        if ((r110 instanceof j.a) == false) goto L6;
        return new Pair(((j.a) r110).f427308a, null);
    L6:
        if ((r110 instanceof j.b) == false) goto L24;
        j.b r111 = (j.b) r110;
        boolean r100 = true;
        if (r111.f427310b.size() != 1) goto L17;
        String r101 = ((j.b.a) ListProtector.get(r111.f427310b, 0)).f427314c;
        if (r101 != null) goto L12;
    L15:
        if (r100 == false) goto L17;
        return new Pair(r111.f427309a + ((j.b.a) ListProtector.get(r111.f427310b, 0)).f427313b + ((j.b.a) ListProtector.get(r111.f427310b, 0)).f427315d, null);
    L12:
        if (r101.length() == 0) goto L15;
        r100 = false;
    L17:
        TextContentList r102 = new TextContentList();
        r102.setDisplayName(r111.f427309a);
        ArrayList r103 = new ArrayList();
        Iterator<T> r112 = r111.f427310b.iterator();
    L19:
        if (r112.hasNext() == false) goto L21;
        j.b.a r104 = (j.b.a) r112.next();
        r103.add(new ParamDetail(r104.f427312a, r104.f427313b, r104.f427314c, r104.f427315d, null, 16, null));
        goto L19
    L21:
        r102.setParamDetails(r103);
        return new Pair("", r102);
    L24:
        throw new NoWhenBranchMatchedException();
    }

    public static ArrayList b(List r210, j r211) {
        Intrinsics.checkNotNullParameter(r210, "promptGroups");
        Intrinsics.checkNotNullParameter(r211, "userInputText");
        if ((r211 instanceof j.b) == true) goto L5;
        ArrayList r100 = new ArrayList();
        Iterator r101 = r210.iterator();
    L8:
        if (r101.hasNext() == false) goto L45;
        m r102 = (m) r101.next();
        PromptGroup r103 = new PromptGroup(r102.f542546a, new ArrayList());
        Iterator<T> r104 = r102.f542547b.iterator();
    L11:
        if (r104.hasNext() == false) goto L36;
        slb.j r105 = (slb.j) r104.next();
        if ((r211 instanceof j.a) == false) goto L23;
        j.a r106 = (j.a) r211;
        if (r106.f427308a.length() <= 0) goto L17;
        boolean r107 = true;
    L18:
        if (r107 == false) goto L23;
        if (StringsKt.indexOf$default(r105.f542537d, r106.f427308a, 0, false, 6, null) < 0) goto L22;
        StringUtils r108 = StringUtils.f427693a;
        String r110 = r105.f542537d;
        String r109 = r106.f427308a;
        r108.getClass();
        String r111 = StringUtils.c(r110, r109);
    L24:
        String r112 = r111;
        if (r112 == null) goto L11;
        ArrayList<Prompt> r113 = r103.getPrompts();
        if (r113 == null) goto L11;
        String r114 = r105.f542534a;
        int r115 = r105.f542536c;
        String r116 = r105.f542537d;
        ArrayList<slb.j> r117 = r105.f542540g;
        if (r117 != null) goto L31;
    L34:
        boolean r118 = true;
    L35:
        r113.add(new Prompt(null, r114, null, null, r115, r112, null, r116, !r118, null, null, r105.f542542i, 1613, null));
        goto L11
    L31:
        if (r117.isEmpty() == true) goto L34;
        r118 = false;
        goto L35
    L22:
        r111 = null;
        goto L24
    L17:
        r107 = false;
    L23:
        r111 = r105.f542537d;
        goto L24
    L36:
        ArrayList<Prompt> r119 = r103.getPrompts();
        if (r119 != null) goto L39;
    L42:
        boolean r120 = true;
    L43:
        if (r120 == true) goto L8;
        r100.add(r103);
        goto L8
    L39:
        if (r119.isEmpty() == true) goto L42;
        r120 = false;
        goto L43
    L45:
        return r100;
    L5:
        return new ArrayList();
    }
}
