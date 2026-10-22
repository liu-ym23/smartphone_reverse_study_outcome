package fob;

import com.ss.android.lark.widget.richtext.RichTextElement;
import hob.b;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public abstract class a<I extends hob.b> implements c<RichTextElement.AnchorProperty, I> {

    /* JADX INFO: renamed from: fob.a$a, reason: collision with other inner class name */
    public static final class C5937a {
    }

    static {
    }

    public abstract boolean a(RichTextElement.AnchorProperty r100);

    public abstract I b(RichTextElement.AnchorProperty r100);

    public a(eob.a r100) {
        Intrinsics.checkNotNullParameter(r100, "editor");
    }

    @Override // fob.c
    public final c.a resolve(RichTextElement.AnchorProperty r100) {
        RichTextElement.AnchorProperty r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "value");
        if (a(r101) == true) goto L6;
        return new c.a();
    L6:
        return new c.a(true, b(r101));
    }
}
