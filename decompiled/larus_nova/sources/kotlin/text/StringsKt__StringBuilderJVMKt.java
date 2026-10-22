package kotlin.text;

import com.bytedance.android.ec.core.event.a;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0002\u0010\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\u0010\b\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\u001a\u001d\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u001d\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u0005H\u0087\b\u001a\u001f\u0010\u0006\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0007H\u0087\b\u001a\u001d\u0010\u0006\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u001d\u0010\u0006\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\bH\u0087\b\u001a\u001d\u0010\u0006\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\tH\u0087\b\u001a\u001d\u0010\u0006\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\nH\u0087\b\u001a\u001d\u0010\u0006\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u000bH\u0087\b\u001a\u001d\u0010\u0006\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u0005H\u0087\b\u001a%\u0010\u0006\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u000e\u0010\u0003\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u0002H\u0087\b\u001a-\u0010\f\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nH\u0087\b\u001a-\u0010\f\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nH\u0087\b\u001a\u0014\u0010\u0011\u001a\u00060\u0012j\u0002`\u0013*\u00060\u0012j\u0002`\u0013H\u0007\u001a\u001d\u0010\u0011\u001a\u00060\u0012j\u0002`\u0013*\u00060\u0012j\u0002`\u00132\u0006\u0010\u0003\u001a\u00020\u0014H\u0087\b\u001a\u001f\u0010\u0011\u001a\u00060\u0012j\u0002`\u0013*\u00060\u0012j\u0002`\u00132\b\u0010\u0003\u001a\u0004\u0018\u00010\u0010H\u0087\b\u001a\u0014\u0010\u0011\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u0002H\u0007\u001a\u001f\u0010\u0011\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0007H\u0087\b\u001a\u001f\u0010\u0011\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0015H\u0087\b\u001a\u001d\u0010\u0011\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u0016H\u0087\b\u001a\u001d\u0010\u0011\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u001d\u0010\u0011\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u0014H\u0087\b\u001a\u001d\u0010\u0011\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\rH\u0087\b\u001a\u001f\u0010\u0011\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0010H\u0087\b\u001a\u001d\u0010\u0011\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\bH\u0087\b\u001a\u001d\u0010\u0011\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\tH\u0087\b\u001a\u001d\u0010\u0011\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\nH\u0087\b\u001a\u001d\u0010\u0011\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u000bH\u0087\b\u001a\u001d\u0010\u0011\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u0005H\u0087\b\u001a\u001f\u0010\u0011\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0017H\u0087\b\u001a%\u0010\u0011\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u000e\u0010\u0003\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u0002H\u0087\b\u001a\u0014\u0010\u0018\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u0002H\u0007\u001a\u001d\u0010\u0019\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u001a\u001a\u00020\nH\u0087\b\u001a%\u0010\u001b\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nH\u0087\b\u001a%\u0010\u001c\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a%\u0010\u001c\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0005H\u0087\b\u001a5\u0010\u001d\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nH\u0087\b\u001a5\u0010\u001d\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nH\u0087\b\u001a!\u0010\u001e\u001a\u00020\u001f*\u00060\u0001j\u0002`\u00022\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0014H\u0087\n\u001a-\u0010 \u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0017H\u0087\b\u001a7\u0010!\u001a\u00020\u001f*\u00060\u0001j\u0002`\u00022\u0006\u0010\"\u001a\u00020\r2\b\b\u0002\u0010#\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\nH\u0087\b¨\u0006$"}, d2 = {"append", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "value", "", "", "appendLine", "Ljava/lang/StringBuffer;", "", "", "", "", "appendRange", "", "startIndex", "endIndex", "", "appendln", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "", "", "", "", "clear", "deleteAt", "index", "deleteRange", "insert", "insertRange", "set", "", "setRange", "toCharArray", a.KEY_DESTINATION, "destinationOffset", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/text/StringsKt")
class StringsKt__StringBuilderJVMKt extends StringsKt__RegexExtensionsKt {
    public StringsKt__StringBuilderJVMKt() {
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine()", imports = {}))
    public static final Appendable appendln(Appendable r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100.append(SystemProperties.LINE_SEPARATOR);
    }

    public static StringBuilder clear(StringBuilder r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.setLength(0);
        return r100;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine()", imports = {}))
    public static StringBuilder appendln(StringBuilder r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.append(SystemProperties.LINE_SEPARATOR);
        return r100;
    }

    private static final StringBuilder append(StringBuilder r100, byte r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.append(r101);
        return r100;
    }

    private static final StringBuilder appendLine(StringBuilder r100, byte r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.append(r101);
        r100.append('\n');
        return r100;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    private static final StringBuilder appendln(StringBuilder r100, char[] r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "value");
        r100.append(r101);
        return StringsKt.appendln(r100);
    }

    private static final StringBuilder deleteAt(StringBuilder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100.deleteCharAt(r101);
    }

    private static final StringBuilder append(StringBuilder r100, short r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.append(r101);
        return r100;
    }

    private static final StringBuilder appendLine(StringBuilder r100, double r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.append(r101);
        r100.append('\n');
        return r100;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    private static final Appendable appendln(Appendable r100, char r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return appendln(r100.append(r101));
    }

    private static final StringBuilder appendLine(StringBuilder r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.append(r101);
        r100.append('\n');
        return r100;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    private static final Appendable appendln(Appendable r100, CharSequence r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return appendln(r100.append(r101));
    }

    private static final StringBuilder appendLine(StringBuilder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.append(r101);
        r100.append('\n');
        return r100;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    private static final StringBuilder appendln(StringBuilder r100, byte r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.append(r101);
        return StringsKt.appendln(r100);
    }

    private static final StringBuilder appendLine(StringBuilder r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.append(r101);
        r100.append('\n');
        return r100;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    private static final StringBuilder appendln(StringBuilder r100, char r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.append(r101);
        return StringsKt.appendln(r100);
    }

    private static final StringBuilder appendLine(StringBuilder r100, StringBuffer r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.append(r101);
        r100.append('\n');
        return r100;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    private static final StringBuilder appendln(StringBuilder r100, double r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.append(r101);
        return StringsKt.appendln(r100);
    }

    private static final StringBuilder appendLine(StringBuilder r100, StringBuilder r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.append(r101);
        r100.append('\n');
        return r100;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    private static final StringBuilder appendln(StringBuilder r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.append(r101);
        return StringsKt.appendln(r100);
    }

    private static final StringBuilder appendLine(StringBuilder r100, short r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.append(r101);
        r100.append('\n');
        return r100;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    private static final StringBuilder appendln(StringBuilder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.append(r101);
        return StringsKt.appendln(r100);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    private static final StringBuilder appendln(StringBuilder r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.append(r101);
        return StringsKt.appendln(r100);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    private static final StringBuilder appendln(StringBuilder r100, CharSequence r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.append(r101);
        return StringsKt.appendln(r100);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    private static final StringBuilder appendln(StringBuilder r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.append(r101);
        return StringsKt.appendln(r100);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    private static final StringBuilder appendln(StringBuilder r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.append(r101);
        return StringsKt.appendln(r100);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    private static final StringBuilder appendln(StringBuilder r100, StringBuffer r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.append(r101);
        return StringsKt.appendln(r100);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    private static final StringBuilder appendln(StringBuilder r100, StringBuilder r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.append(r101);
        return StringsKt.appendln(r100);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    private static final StringBuilder appendln(StringBuilder r100, short r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.append(r101);
        return StringsKt.appendln(r100);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    private static final StringBuilder appendln(StringBuilder r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.append(r101);
        return StringsKt.appendln(r100);
    }

    private static final StringBuilder deleteRange(StringBuilder r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100.delete(r101, r102);
    }

    private static final StringBuilder insert(StringBuilder r100, int r101, byte r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100.insert(r101, r102);
    }

    private static final void set(StringBuilder r100, int r101, char r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.setCharAt(r101, r102);
    }

    private static final StringBuilder insert(StringBuilder r100, int r101, short r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100.insert(r101, r102);
    }

    private static final StringBuilder appendRange(StringBuilder r100, char[] r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "value");
        r100.append(r101, r102, r103 - r102);
        return r100;
    }

    private static final StringBuilder setRange(StringBuilder r100, int r101, int r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r103, "value");
        return r100.replace(r101, r102, r103);
    }

    private static final StringBuilder appendRange(StringBuilder r100, CharSequence r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "value");
        r100.append(r101, r102, r103);
        return r100;
    }

    private static final StringBuilder insertRange(StringBuilder r100, int r101, char[] r102, int r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r102, "value");
        return r100.insert(r101, r102, r103, r104 - r103);
    }

    private static final void toCharArray(StringBuilder r100, char[] r101, int r102, int r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, a.KEY_DESTINATION);
        r100.getChars(r103, r104, r101, r102);
    }

    private static final StringBuilder insertRange(StringBuilder r100, int r101, CharSequence r102, int r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r102, "value");
        return r100.insert(r101, r102, r103, r104);
    }

    public static /* synthetic */ void toCharArray$default(StringBuilder r100, char[] r101, int r102, int r103, int r104, int r105, Object r106) {
        if ((r105 & 2) == 0) goto L6;
        r102 = 0;
    L6:
        if ((r105 & 4) == 0) goto L9;
        r103 = 0;
    L9:
        if ((r105 & 8) == 0) goto L11;
        r104 = r100.length();
    L11:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, a.KEY_DESTINATION);
        r100.getChars(r103, r104, r101, r102);
    }
}
