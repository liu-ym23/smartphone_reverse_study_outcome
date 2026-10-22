package src;

import com.facebook.keyframes.model.KFAnimation;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.github.alexzhirkevich.compottie.internal.animation.expressions.e;
import io.github.alexzhirkevich.compottie.internal.animation.expressions.f;
import io.github.alexzhirkevich.compottie.internal.animation.k2;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes41.dex */
public final class c implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f543278a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f543279b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f543280c;

    public c(f r100, f r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "value");
        Intrinsics.checkNotNullParameter(r101, "search");
        this.f543278a = r100;
        this.f543279b = r101;
        this.f543280c = r102;
    }

    @Override // io.github.alexzhirkevich.compottie.internal.animation.expressions.f
    public final Object a(k2<? extends Object> r100, e r101, prc.f r110) {
        Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, "state");
        Object r102 = this.f543278a.a(r100, r101, r110);
        Object r103 = this.f543279b.a(r100, r101, r110);
        if ((r102 instanceof String) == false) goto L15;
        boolean r104 = r103 instanceof String;
        if (r104 == false) goto L7;
    L8:
        if (r104 == true) goto L10;
        int r105 = StringsKt.indexOf$default((CharSequence) r102, ((Character) r103).charValue(), 0, false, 6, null);
    L21:
        return Integer.valueOf(r105);
    L10:
        if (this.f543280c == false) goto L12;
        r105 = StringsKt.lastIndexOf$default((CharSequence) r102, (String) r103, 0, false, 6, null);
        goto L21
    L12:
        r105 = StringsKt.indexOf$default((CharSequence) r102, (String) r103, 0, false, 6, null);
        goto L21
    L7:
        if ((r103 instanceof Character) == true) goto L8;
    L15:
        if ((r102 instanceof List) == true) goto L17;
        qrc.e.c("indexOf", null);
        throw null;
    L17:
        if (this.f543280c == false) goto L19;
        r105 = ((List) r102).lastIndexOf(r103);
        goto L21
    L19:
        r105 = ((List) r102).indexOf(r103);
        goto L21
    }
}
