package q6c;

import androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat;
import java.util.UUID;
import kotlin.TypeCastException;
import kotlin.text.StringsKt;
import r6c.a;

/* JADX INFO: loaded from: classes38.dex */
public abstract class a<Dp extends r6c.a> implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Dp f531875a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f531876b;

    /* JADX INFO: renamed from: q6c.a$a, reason: collision with other inner class name */
    public static final class C7291a {
    }

    static {
    }

    public String i() {
        return AndroidComposeViewAccessibilityDelegateCompat.ClassName;
    }

    @Override // q6c.c
    public final String getUniqueId() {
        return this.f531876b;
    }

    public a(Dp r100) {
        this.f531875a = r100;
        int r101 = t6c.a.f544841a;
        String r102 = StringsKt.replace$default(UUID.randomUUID().toString(), "-", "", false, 4, null);
        if (r102 == null) goto L7;
        this.f531876b = r102.substring(0, 10);
        return;
    L7:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }
}
