package jec;

import com.ss.android.lark.widget.richtext.RichTextElement;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RichTextElement f498845a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<c> f498846b;

    public c(RichTextElement r100, List<c> r101) {
        Intrinsics.checkNotNullParameter(r100, "richTextElement");
        Intrinsics.checkNotNullParameter(r101, "subElements");
        this.f498845a = r100;
        this.f498846b = r101;
    }
}
