package hob;

import com.ss.android.lark.widget.codeblock.entity.LineContent;
import com.ss.android.lark.widget.richtext.RichTextElement;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f486323c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<LineContent> f486324a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RichTextElement.CodeBlockV2Property f486325b;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f486324a, r101.f486324a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f486325b, r101.f486325b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f486324a.hashCode() * 31;
        RichTextElement.CodeBlockV2Property r101 = this.f486325b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "InsertCodeBlockV2Info(lineContents=" + this.f486324a + ", codeBlockV2Property=" + this.f486325b + ')';
    }

    public e(List<LineContent> r100, RichTextElement.CodeBlockV2Property r101) {
        Intrinsics.checkNotNullParameter(r100, "lineContents");
        this.f486324a = r100;
        this.f486325b = r101;
    }
}
