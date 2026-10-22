package com.obric.miniapp.intent;

import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.obric.assistant.spi.miniapp.IObricIntentWidgetPolicy;
import com.obric.assistant.spi.miniapp.ObricIntentWidgetUpdateMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\t"}, d2 = {"Lcom/obric/miniapp/intent/ObricIntentWidgetPolicyImpl;", "Lcom/obric/assistant/spi/miniapp/IObricIntentWidgetPolicy;", "<init>", "()V", JSEventListener.ACTION_RESOLVE, "Lcom/obric/assistant/spi/miniapp/ObricIntentWidgetPolicy;", "renderData", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricIntentWidgetPolicyImpl implements IObricIntentWidgetPolicy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final rga.a f397682a = null;

    public static final class a {
    }

    public ObricIntentWidgetPolicyImpl() {
    }

    static {
        f397682a = new rga.a(0);
    }

    @Override // com.obric.assistant.spi.miniapp.IObricIntentWidgetPolicy
    public final rga.a resolve(String r100) {
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == true) goto L11;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L22
        JSONObject r103 = new JSONObject(r100);     // Catch: Throwable -> L22
        if (Intrinsics.areEqual(r103.optString("applet_id"), "ability.intent.card") == true) goto L17;
        return f397682a;
    L17:
        if (Intrinsics.areEqual(r103.optString("widget_id"), "appintent_alarm") == false) goto L19;
        ObricIntentWidgetUpdateMode r104 = ObricIntentWidgetUpdateMode.UPDATE_IN_PLACE;     // Catch: Throwable -> L22
    L20:
        Object r105 = Result.m9449constructorimpl(new rga.a(r104, true, 134));     // Catch: Throwable -> L22
    L24:
        rga.a r106 = f397682a;
        if (Result.m9455isFailureimpl(r105) == false) goto L28;
        r105 = r106;
    L28:
        return (rga.a) r105;
    L19:
        r104 = ObricIntentWidgetUpdateMode.RECREATE;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L24
    L11:
        return f397682a;
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r101 = false;
        goto L9
    }
}
