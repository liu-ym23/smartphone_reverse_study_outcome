package bz7;

import androidx.lifecycle.Lifecycle;
import com.larksuite.component.card.cardcontainer.CardImpl;
import com.larksuite.component.card.protocol.CardConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b {
    public Lifecycle a;
    public CardConfig b;

    public b() {
    }

    public final CardImpl a() {
        Lifecycle r1 = this.a;
        CardConfig r2 = this.b;
        if (r2 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("cardConfig");
        r2 = null;
    L6:
        return new CardImpl(r1, r2);
    }
}
