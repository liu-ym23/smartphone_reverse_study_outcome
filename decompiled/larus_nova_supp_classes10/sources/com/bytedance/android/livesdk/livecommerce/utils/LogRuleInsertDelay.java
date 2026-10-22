package com.bytedance.android.livesdk.livecommerce.utils;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.text.MatchResult;
import kotlin.text.Regex;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\f\u0010\rJ\n\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\"\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/utils/LogRuleInsertDelay;", "Lcom/bytedance/android/livesdk/livecommerce/utils/LogRule;", "parse", "", "getIntrinsicOn", "", "delaySeconds", "I", "getDelaySeconds", "()I", "setDelaySeconds", "(I)V", "<init>", "()V", "Companion", "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
final class LogRuleInsertDelay extends LogRule {
    public static final a Companion = null;
    public static final String RULE_STR_CART_INSERT_DELAY = "cart_insert_delay";
    public static final Lazy a = null;
    private int delaySeconds;

    public static final class a {
        public a() {
        }
    }

    @Override // com.bytedance.android.livesdk.livecommerce.utils.LogRule
    public String getIntrinsicOn() {
        return RULE_STR_CART_INSERT_DELAY;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.utils.LogRule
    public LogRule parse() {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L12
        Companion.getClass();     // Catch: Throwable -> L12
        Regex r2 = (Regex) access$getRULE_CART_INSERT_DELAY_REGEX$cp().getValue();     // Catch: Throwable -> L12
        String r3 = getOn();     // Catch: Throwable -> L12
        if (r3 != null) goto L6;
        r3 = "";
    L6:
        MatchResult r4 = Regex.find$default(r2, r3, 0, 2, null);     // Catch: Throwable -> L12
        if (r4 == null) goto L9;
        this.delaySeconds = CastIntegerProtector.parseInt((String) ListProtector.get(r4.getDestructured().getMatch().getGroupValues(), 1));     // Catch: Throwable -> L12
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L12
    L10:
        Result.constructor-impl(r5);     // Catch: Throwable -> L12
    L15:
        if (this.delaySeconds > 0) goto L17;
        return null;
    L17:
        return this;
    L9:
        r5 = null;
    L12:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    }

    static {
        Companion = new a();
        a = LazyKt.lazy(LogRuleInsertDelay$Companion$RULE_CART_INSERT_DELAY_REGEX$2.INSTANCE);
    }

    public LogRuleInsertDelay() {
    }

    public static final /* synthetic */ Lazy access$getRULE_CART_INSERT_DELAY_REGEX$cp() {
        return a;
    }

    public final int getDelaySeconds() {
        return this.delaySeconds;
    }

    public final void setDelaySeconds(int r1) {
        this.delaySeconds = r1;
    }
}
