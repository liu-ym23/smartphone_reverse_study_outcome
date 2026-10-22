package ouc;

import com.ss.android.lark.widget.codeblock.entity.LineContent;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.ClassDiscriminatorMode;

/* JADX INFO: loaded from: classes5.dex */
public final class w {
    public static v a(Function1 r210) {
        a.C7114a r100 = a.f526798d;
        Intrinsics.checkNotNullParameter(r100, "from");
        Intrinsics.checkNotNullParameter(r210, "builderAction");
        e r101 = new e(r100);
        r210.invoke(r101);
        boolean r102 = false;
        if (r101.f526829p == false) goto L17;
        if (Intrinsics.areEqual(r101.f526821h, "type") == false) goto L15;
        if (r101.f526822i != ClassDiscriminatorMode.POLYMORPHIC) goto L9;
        boolean r103 = true;
    L10:
        if (r103 == true) goto L17;
        throw new IllegalArgumentException("useArrayPolymorphism option can only be used if classDiscriminatorMode in a default POLYMORPHIC state.".toString());
    L9:
        r103 = false;
        goto L10
    L15:
        throw new IllegalArgumentException("Class discriminator should not be specified when array polymorphism is specified".toString());
    L17:
        if (r101.f526818e == true) goto L24;
        if (Intrinsics.areEqual(r101.f526819f, LineContent.FOUR_SPACE) == true) goto L48;
        throw new IllegalArgumentException("Indent should not be specified when default printing mode is used".toString());
    L48:
        return new v(new f(r101.f526814a, r101.f526816c, r101.f526817d, r101.f526828o, r101.f526818e, r101.f526815b, r101.f526819f, r101.f526820g, r101.f526829p, r101.f526821h, r101.f526827n, r101.f526823j, r101.f526824k, r101.f526825l, r101.f526826m, r101.f526822i), r101.f526830q);
    L24:
        if (Intrinsics.areEqual(r101.f526819f, LineContent.FOUR_SPACE) == true) goto L48;
        String r104 = r101.f526819f;
        int r105 = 0;
    L27:
        if (r105 >= r104.length()) goto L42;
        char r106 = r104.charAt(r105);
        if (r106 != ' ') goto L31;
    L38:
        boolean r107 = true;
    L39:
        if (r107 == false) goto L43;
        r105 = r105 + 1;
    L43:
        if (r102 == true) goto L48;
        throw new IllegalArgumentException(("Only whitespace, tab, newline and carriage return are allowed as pretty print symbols. Had " + r101.f526819f).toString());
    L31:
        if (r106 == '\t') goto L38;
        if (r106 == '\r') goto L38;
        if (r106 == '\n') goto L38;
        r107 = false;
        goto L39
    L42:
        r102 = true;
        goto L43
    }
}
