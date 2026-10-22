package com.bytedance.awemeopen.apps.framework.comment.util;

import android.app.Activity;
import android.content.Context;
import com.bytedance.awemeopen.bizmodels.feed.video.TextExtraStruct;
import com.bytedance.awemeopen.bizmodels.user.f;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import o14.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e {

    public static final class a implements com.bytedance.awemeopen.bizmodels.user.b {
        public final /* synthetic */ Function0<Unit> a;

        public final void onFail(Exception r1) {
        }

        public a(Function0<Unit> r1) {
            this.a = r1;
        }

        public final void a(com.bytedance.awemeopen.bizmodels.user.c r2) {
            Intrinsics.checkNotNullParameter(r2, "tokenResult");
            this.a.invoke();
        }
    }

    public static final List b(o14.a r3, Context r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "context");
        g r5 = r3.b;
        String r0 = null;
        if (r5 == null) goto L5;
        Boolean r1 = r5.a;
    L6:
        if (r5 == null) goto L9;
        r0 = r5.b;
    L9:
        if (r3.m() == null) goto L30;
        List r2 = r3.m();
        Intrinsics.checkNotNull(r2);
        ArrayList r6 = new ArrayList(r2.size());
        if (Intrinsics.areEqual(r1, Boolean.TRUE) == false) goto L25;
        if (r0 == null) goto L14;
        int r7 = r0.length() - 7;
    L15:
        List r8 = r3.m();
        Intrinsics.checkNotNull(r8);
        Iterator r9 = r8.iterator();
    L17:
        if (r9.hasNext() == false) goto L37;
        TextExtraStruct r10 = (TextExtraStruct) r9.next();
        if (r10.getStart() >= r7) goto L17;
        TextExtraStruct r11 = r10.clone();
        if (r11.getEnd() < r7) goto L24;
        r11.setEnd(r7);
    L24:
        r6.add(r11);
        goto L17
    L37:
        return r6;
    L14:
        r7 = 0;
        goto L15
    L25:
        List r12 = r3.m();
        Intrinsics.checkNotNull(r12);
        Iterator r13 = r12.iterator();
    L27:
        if (r13.hasNext() == false) goto L38;
        r6.add(((TextExtraStruct) r13.next()).clone());
        goto L27
    L38:
        return r6;
    L30:
        return new ArrayList();
    L5:
        r1 = null;
        goto L6
    }

    public static final void a(Context r2, String r3, Function0<Unit> r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "source");
        Intrinsics.checkNotNullParameter(r4, "action");
        Intrinsics.checkNotNullParameter(r5, "tag");
        d14.a r0 = b14.a.a;
        k34.b r1 = b14.a.a(k34.b.class);
        if (r1.isLogin() == false) goto L5;
        r4.invoke();
        return;
    L5:
        Activity r6 = com.bytedance.awemeopen.infra.util.b.a(r2);
        if (r6 == null) goto L8;
        r1.l0(new f(r6, r3, null), new a(r4));
        return;
    L8:
        AoLogger.c(r5, new Object[]{"start login fail activity is null"});
    }
}
