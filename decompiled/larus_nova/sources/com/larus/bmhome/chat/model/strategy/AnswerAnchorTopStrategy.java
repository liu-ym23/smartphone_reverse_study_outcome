package com.larus.bmhome.chat.model.strategy;

import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes25.dex */
public final class AnswerAnchorTopStrategy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<String> f307884a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<String> f307885b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f307886c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Object f307887d = null;

    public static final class a implements nf9.c {
        public a() {
        }

        @Override // nf9.c
        public final void B(Message r100) {
            Intrinsics.checkNotNullParameter(r100, "message");
        }

        @Override // nf9.c
        public final void C(Message r100) {
            Intrinsics.checkNotNullParameter(r100, "message");
        }

        @Override // nf9.c
        public final void A(Message r100) {
            Intrinsics.checkNotNullParameter(r100, "message");
            if (com.larus.bmhome.chat.bean.d.j0(r100) == false) goto L6;
            Set<String> r101 = AnswerAnchorTopStrategy.f307884a;
            AnswerAnchorTopStrategy.a(r100.getReplyId());
            return;
        }
    }

    static {
        f307884a = new LinkedHashSet();
        f307885b = new LinkedHashSet();
        f307887d = new Object();
        FLogger.f375446a.d("AnswerAnchorTopStrategy", "add global message stream observer");
        int r100 = com.larus.im.d.f347134a;
        com.larus.im.internal.stream.b.f350138a.a(new a());
    }

    public static void a(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        return;
    L11:
        f307886c = false;
        FLogger.f375446a.d("AnswerAnchorTopStrategy", "endReply, reply_for: " + r100);
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), Dispatchers.getIO(), null, new AnswerAnchorTopStrategy$endAnswerReceiving$1(r100, null), 2, null);
        return;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }
}
