package com.bytedance.android.livesdk.livecommerce.utils;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\f\u0010\rJ\n\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/utils/LogRuleRevMsg;", "Lcom/bytedance/android/livesdk/livecommerce/utils/LogRule;", "parse", "", "getIntrinsicOn", "", "msgType", "", "isHandleMsgType", "Ljava/util/HashSet;", "msgTypeSet", "Ljava/util/HashSet;", "<init>", "()V", "Companion", "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
final class LogRuleRevMsg extends LogRule {
    public static final a Companion = null;
    public static final String RULE_STR_REV_MSG = "recv_msg";
    public static final Lazy a = null;
    private final HashSet<Integer> msgTypeSet;

    public static final class a {
        public a() {
        }
    }

    @Override // com.bytedance.android.livesdk.livecommerce.utils.LogRule
    public String getIntrinsicOn() {
        return RULE_STR_REV_MSG;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.utils.LogRule
    public LogRule parse() {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L16
        Companion.getClass();     // Catch: Throwable -> L16
        Regex r2 = (Regex) access$getRULE_REV_MSG_REGEX$cp().getValue();     // Catch: Throwable -> L16
        String r3 = getOn();     // Catch: Throwable -> L16
        if (r3 != null) goto L6;
        r3 = "";
    L6:
        MatchResult r4 = Regex.find$default(r2, r3, 0, 2, null);     // Catch: Throwable -> L16
        if (r4 == null) goto L13;
        Iterator r5 = StringsKt.split$default((String) ListProtector.get(r4.getDestructured().getMatch().getGroupValues(), 1), new String[]{"/"}, false, 0, 6, null).iterator();     // Catch: Throwable -> L16
    L10:
        if (r5.hasNext() == false) goto L12;
        this.msgTypeSet.add(Integer.valueOf(CastIntegerProtector.parseInt((String) r5.next())));     // Catch: Throwable -> L16
        goto L10
    L12:
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L16
    L14:
        Result.constructor-impl(r6);     // Catch: Throwable -> L16
    L19:
        if (this.msgTypeSet.size() > 0) goto L21;
        return null;
    L21:
        return this;
    L13:
        r6 = null;
    L16:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L19
    }

    static {
        Companion = new a();
        a = LazyKt.lazy(LogRuleRevMsg$Companion$RULE_REV_MSG_REGEX$2.INSTANCE);
    }

    public LogRuleRevMsg() {
        this.msgTypeSet = new HashSet();
    }

    public static final /* synthetic */ Lazy access$getRULE_REV_MSG_REGEX$cp() {
        return a;
    }

    public final boolean isHandleMsgType(int r2) {
        return this.msgTypeSet.contains(Integer.valueOf(r2));
    }
}
