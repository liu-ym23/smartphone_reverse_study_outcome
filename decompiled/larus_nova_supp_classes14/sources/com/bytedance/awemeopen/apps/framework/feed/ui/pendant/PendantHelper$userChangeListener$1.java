package com.bytedance.awemeopen.apps.framework.feed.ui.pendant;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "oldOpenId", "", "newOpenId", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class PendantHelper$userChangeListener$1 extends Lambda implements Function2<String, String, Unit> {
    final /* synthetic */ b this$0;

    public PendantHelper$userChangeListener$1(b r1) {
        this.this$0 = r1;
        super(2);
    }

    public final void invoke(String r1, String r2) {
        this.this$0.getClass();
        c.a.edit().clear().apply();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((String) r1, (String) r2);
        return Unit.INSTANCE;
    }
}
