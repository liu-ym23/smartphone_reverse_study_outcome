package kotlin.text;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function1;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"kotlin/text/StringsKt__AppendableKt", "kotlin/text/StringsKt__IndentKt", "kotlin/text/StringsKt__RegexExtensionsJVMKt", "kotlin/text/StringsKt__RegexExtensionsKt", "kotlin/text/StringsKt__StringBuilderJVMKt", "kotlin/text/StringsKt__StringBuilderKt", "kotlin/text/StringsKt__StringNumberConversionsJVMKt", "kotlin/text/StringsKt__StringNumberConversionsKt", "kotlin/text/StringsKt__StringsJVMKt", "kotlin/text/StringsKt__StringsKt", "kotlin/text/StringsKt___StringsJvmKt", "kotlin/text/StringsKt___StringsKt"}, k = 4, mv = {1, 9, 0}, xi = 49)
public final class StringsKt extends StringsKt___StringsKt {
    public static /* bridge */ /* synthetic */ StringBuilder append(StringBuilder r100, Object... r101) {
        return StringsKt__StringBuilderKt.append(r100, r101);
    }

    public static /* bridge */ /* synthetic */ StringBuilder append(StringBuilder r100, String... r101) {
        return StringsKt__StringBuilderKt.append(r100, r101);
    }

    public static /* bridge */ /* synthetic */ void appendElement(Appendable r100, Object r101, Function1 r102) {
        StringsKt__AppendableKt.appendElement(r100, r101, r102);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine()", imports = {}))
    public static /* bridge */ /* synthetic */ StringBuilder appendln(StringBuilder r100) {
        return StringsKt__StringBuilderJVMKt.appendln(r100);
    }

    public static /* bridge */ /* synthetic */ List chunked(CharSequence r100, int r101) {
        return StringsKt___StringsKt.chunked(r100, r101);
    }

    public static /* bridge */ /* synthetic */ StringBuilder clear(StringBuilder r100) {
        return StringsKt__StringBuilderJVMKt.clear(r100);
    }

    public static /* bridge */ /* synthetic */ int compareTo(String r100, String r101, boolean r102) {
        return StringsKt__StringsJVMKt.compareTo(r100, r101, r102);
    }

    public static /* bridge */ /* synthetic */ String concatToString(char[] r100) {
        return StringsKt__StringsJVMKt.concatToString(r100);
    }

    public static /* bridge */ /* synthetic */ String concatToString(char[] r100, int r101, int r102) {
        return StringsKt__StringsJVMKt.concatToString(r100, r101, r102);
    }

    public static /* bridge */ /* synthetic */ boolean contains(CharSequence r100, char r101, boolean r102) {
        return StringsKt__StringsKt.contains(r100, r101, r102);
    }

    public static /* bridge */ /* synthetic */ boolean contains(CharSequence r100, CharSequence r101, boolean r102) {
        return StringsKt__StringsKt.contains(r100, r101, r102);
    }

    public static /* bridge */ /* synthetic */ boolean contains$default(CharSequence r100, char r101, boolean r102, int r103, Object r104) {
        return StringsKt__StringsKt.contains$default(r100, r101, r102, r103, r104);
    }

    public static /* bridge */ /* synthetic */ boolean contains$default(CharSequence r100, CharSequence r101, boolean r102, int r103, Object r104) {
        return StringsKt__StringsKt.contains$default(r100, r101, r102, r103, r104);
    }

    public static /* bridge */ /* synthetic */ boolean contentEquals(CharSequence r100, CharSequence r101) {
        return StringsKt__StringsJVMKt.contentEquals(r100, r101);
    }

    public static /* bridge */ /* synthetic */ String decodeToString(byte[] r100) {
        return StringsKt__StringsJVMKt.decodeToString(r100);
    }

    public static /* bridge */ /* synthetic */ String decodeToString(byte[] r100, int r101, int r102, boolean r103) {
        return StringsKt__StringsJVMKt.decodeToString(r100, r101, r102, r103);
    }

    public static /* bridge */ /* synthetic */ String decodeToString$default(byte[] r100, int r101, int r102, boolean r103, int r104, Object r105) {
        return StringsKt__StringsJVMKt.decodeToString$default(r100, r101, r102, r103, r104, r105);
    }

    public static /* bridge */ /* synthetic */ String drop(String r100, int r101) {
        return StringsKt___StringsKt.drop(r100, r101);
    }

    public static /* bridge */ /* synthetic */ String dropLast(String r100, int r101) {
        return StringsKt___StringsKt.dropLast(r100, r101);
    }

    public static /* bridge */ /* synthetic */ byte[] encodeToByteArray(String r100) {
        return StringsKt__StringsJVMKt.encodeToByteArray(r100);
    }

    public static /* bridge */ /* synthetic */ boolean endsWith(CharSequence r100, char r101, boolean r102) {
        return StringsKt__StringsKt.endsWith(r100, r101, r102);
    }

    public static /* bridge */ /* synthetic */ boolean endsWith(String r100, String r101, boolean r102) {
        return StringsKt__StringsJVMKt.endsWith(r100, r101, r102);
    }

    public static /* bridge */ /* synthetic */ boolean endsWith$default(CharSequence r100, char r101, boolean r102, int r103, Object r104) {
        return StringsKt__StringsKt.endsWith$default(r100, r101, r102, r103, r104);
    }

    public static /* bridge */ /* synthetic */ boolean endsWith$default(CharSequence r100, CharSequence r101, boolean r102, int r103, Object r104) {
        return StringsKt__StringsKt.endsWith$default(r100, r101, r102, r103, r104);
    }

    public static /* bridge */ /* synthetic */ boolean endsWith$default(String r100, String r101, boolean r102, int r103, Object r104) {
        return StringsKt__StringsJVMKt.endsWith$default(r100, r101, r102, r103, r104);
    }

    public static /* bridge */ /* synthetic */ boolean equals(String r100, String r101, boolean r102) {
        return StringsKt__StringsJVMKt.equals(r100, r101, r102);
    }

    public static /* bridge */ /* synthetic */ boolean equals$default(String r100, String r101, boolean r102, int r103, Object r104) {
        return StringsKt__StringsJVMKt.equals$default(r100, r101, r102, r103, r104);
    }

    public static /* bridge */ /* synthetic */ Pair findAnyOf$default(CharSequence r100, Collection r101, int r102, boolean r103, int r104, Object r105) {
        return StringsKt__StringsKt.findAnyOf$default(r100, r101, r102, r103, r104, r105);
    }

    public static /* bridge */ /* synthetic */ char first(CharSequence r100) {
        return StringsKt___StringsKt.first(r100);
    }

    public static /* bridge */ /* synthetic */ Character firstOrNull(CharSequence r100) {
        return StringsKt___StringsKt.firstOrNull(r100);
    }

    public static /* bridge */ /* synthetic */ IntRange getIndices(CharSequence r100) {
        return StringsKt__StringsKt.getIndices(r100);
    }

    public static /* bridge */ /* synthetic */ int getLastIndex(CharSequence r100) {
        return StringsKt__StringsKt.getLastIndex(r100);
    }

    public static /* bridge */ /* synthetic */ Character getOrNull(CharSequence r100, int r101) {
        return StringsKt___StringsKt.getOrNull(r100, r101);
    }

    public static /* bridge */ /* synthetic */ int indexOf(CharSequence r100, String r101, int r102, boolean r103) {
        return StringsKt__StringsKt.indexOf(r100, r101, r102, r103);
    }

    public static /* bridge */ /* synthetic */ int indexOf$default(CharSequence r100, char r101, int r102, boolean r103, int r104, Object r105) {
        return StringsKt__StringsKt.indexOf$default(r100, r101, r102, r103, r104, r105);
    }

    public static /* bridge */ /* synthetic */ int indexOf$default(CharSequence r100, String r101, int r102, boolean r103, int r104, Object r105) {
        return StringsKt__StringsKt.indexOf$default(r100, r101, r102, r103, r104, r105);
    }

    public static /* bridge */ /* synthetic */ int indexOfAny$default(CharSequence r100, char[] r101, int r102, boolean r103, int r104, Object r105) {
        return StringsKt__StringsKt.indexOfAny$default(r100, r101, r102, r103, r104, r105);
    }

    public static /* bridge */ /* synthetic */ boolean isBlank(CharSequence r100) {
        return StringsKt__StringsKt.isBlank(r100);
    }

    public static /* bridge */ /* synthetic */ char last(CharSequence r100) {
        return StringsKt___StringsKt.last(r100);
    }

    public static /* bridge */ /* synthetic */ int lastIndexOf(CharSequence r100, String r101, int r102, boolean r103) {
        return StringsKt__StringsKt.lastIndexOf(r100, r101, r102, r103);
    }

    public static /* bridge */ /* synthetic */ int lastIndexOf$default(CharSequence r100, char r101, int r102, boolean r103, int r104, Object r105) {
        return StringsKt__StringsKt.lastIndexOf$default(r100, r101, r102, r103, r104, r105);
    }

    public static /* bridge */ /* synthetic */ int lastIndexOf$default(CharSequence r100, String r101, int r102, boolean r103, int r104, Object r105) {
        return StringsKt__StringsKt.lastIndexOf$default(r100, r101, r102, r103, r104, r105);
    }

    public static /* bridge */ /* synthetic */ int lastIndexOfAny$default(CharSequence r100, Collection r101, int r102, boolean r103, int r104, Object r105) {
        return StringsKt__StringsKt.lastIndexOfAny$default(r100, r101, r102, r103, r104, r105);
    }

    public static /* bridge */ /* synthetic */ int lastIndexOfAny$default(CharSequence r100, char[] r101, int r102, boolean r103, int r104, Object r105) {
        return StringsKt__StringsKt.lastIndexOfAny$default(r100, r101, r102, r103, r104, r105);
    }

    public static /* bridge */ /* synthetic */ Character lastOrNull(CharSequence r100) {
        return StringsKt___StringsKt.lastOrNull(r100);
    }

    public static /* bridge */ /* synthetic */ Sequence lineSequence(CharSequence r100) {
        return StringsKt__StringsKt.lineSequence(r100);
    }

    public static /* bridge */ /* synthetic */ List lines(CharSequence r100) {
        return StringsKt__StringsKt.lines(r100);
    }

    public static /* bridge */ /* synthetic */ String padEnd(String r100, int r101, char r102) {
        return StringsKt__StringsKt.padEnd(r100, r101, r102);
    }

    public static /* bridge */ /* synthetic */ String padEnd$default(String r100, int r101, char r102, int r103, Object r104) {
        return StringsKt__StringsKt.padEnd$default(r100, r101, r102, r103, r104);
    }

    public static /* bridge */ /* synthetic */ String padStart(String r100, int r101, char r102) {
        return StringsKt__StringsKt.padStart(r100, r101, r102);
    }

    public static /* bridge */ /* synthetic */ char random(CharSequence r100, Random r101) {
        return StringsKt___StringsKt.random(r100, r101);
    }

    public static /* bridge */ /* synthetic */ boolean regionMatches(String r100, int r101, String r102, int r103, int r104, boolean r105) {
        return StringsKt__StringsJVMKt.regionMatches(r100, r101, r102, r103, r104, r105);
    }

    public static /* bridge */ /* synthetic */ boolean regionMatches$default(String r100, int r101, String r102, int r103, int r104, boolean r105, int r106, Object r107) {
        return StringsKt__StringsJVMKt.regionMatches$default(r100, r101, r102, r103, r104, r105, r106, r107);
    }

    public static /* bridge */ /* synthetic */ String removePrefix(String r100, CharSequence r101) {
        return StringsKt__StringsKt.removePrefix(r100, r101);
    }

    public static /* bridge */ /* synthetic */ CharSequence removeRange(CharSequence r100, int r101, int r102) {
        return StringsKt__StringsKt.removeRange(r100, r101, r102);
    }

    public static /* bridge */ /* synthetic */ CharSequence removeRange(CharSequence r100, IntRange r101) {
        return StringsKt__StringsKt.removeRange(r100, r101);
    }

    public static /* bridge */ /* synthetic */ CharSequence removeSuffix(CharSequence r100, CharSequence r101) {
        return StringsKt__StringsKt.removeSuffix(r100, r101);
    }

    public static /* bridge */ /* synthetic */ String removeSuffix(String r100, CharSequence r101) {
        return StringsKt__StringsKt.removeSuffix(r100, r101);
    }

    public static /* bridge */ /* synthetic */ String removeSurrounding(String r100, CharSequence r101) {
        return StringsKt__StringsKt.removeSurrounding(r100, r101);
    }

    public static /* bridge */ /* synthetic */ String removeSurrounding(String r100, CharSequence r101, CharSequence r102) {
        return StringsKt__StringsKt.removeSurrounding(r100, r101, r102);
    }

    public static /* bridge */ /* synthetic */ String repeat(CharSequence r100, int r101) {
        return StringsKt__StringsJVMKt.repeat(r100, r101);
    }

    public static /* bridge */ /* synthetic */ String replace(String r100, String r101, String r102, boolean r103) {
        return StringsKt__StringsJVMKt.replace(r100, r101, r102, r103);
    }

    public static /* bridge */ /* synthetic */ String replace$default(String r100, char r101, char r102, boolean r103, int r104, Object r105) {
        return StringsKt__StringsJVMKt.replace$default(r100, r101, r102, r103, r104, r105);
    }

    public static /* bridge */ /* synthetic */ String replace$default(String r100, String r101, String r102, boolean r103, int r104, Object r105) {
        return StringsKt__StringsJVMKt.replace$default(r100, r101, r102, r103, r104, r105);
    }

    public static /* bridge */ /* synthetic */ String replaceAfterLast$default(String r100, char r101, String r102, String r103, int r104, Object r105) {
        return StringsKt__StringsKt.replaceAfterLast$default(r100, r101, r102, r103, r104, r105);
    }

    public static /* bridge */ /* synthetic */ String replaceFirst(String r100, String r101, String r102, boolean r103) {
        return StringsKt__StringsJVMKt.replaceFirst(r100, r101, r102, r103);
    }

    public static /* bridge */ /* synthetic */ String replaceFirst$default(String r100, String r101, String r102, boolean r103, int r104, Object r105) {
        return StringsKt__StringsJVMKt.replaceFirst$default(r100, r101, r102, r103, r104, r105);
    }

    public static /* bridge */ /* synthetic */ CharSequence replaceRange(CharSequence r100, int r101, int r102, CharSequence r103) {
        return StringsKt__StringsKt.replaceRange(r100, r101, r102, r103);
    }

    public static /* bridge */ /* synthetic */ CharSequence replaceRange(CharSequence r100, IntRange r101, CharSequence r102) {
        return StringsKt__StringsKt.replaceRange(r100, r101, r102);
    }

    public static /* bridge */ /* synthetic */ CharSequence reversed(CharSequence r100) {
        return StringsKt___StringsKt.reversed(r100);
    }

    public static /* bridge */ /* synthetic */ char single(CharSequence r100) {
        return StringsKt___StringsKt.single(r100);
    }

    public static /* bridge */ /* synthetic */ String slice(String r100, IntRange r101) {
        return StringsKt___StringsKt.slice(r100, r101);
    }

    public static /* bridge */ /* synthetic */ List split$default(CharSequence r100, Pattern r101, int r102, int r103, Object r104) {
        return StringsKt__StringsJVMKt.split$default(r100, r101, r102, r103, r104);
    }

    public static /* bridge */ /* synthetic */ List split$default(CharSequence r100, char[] r101, boolean r102, int r103, int r104, Object r105) {
        return StringsKt__StringsKt.split$default(r100, r101, r102, r103, r104, r105);
    }

    public static /* bridge */ /* synthetic */ List split$default(CharSequence r100, String[] r101, boolean r102, int r103, int r104, Object r105) {
        return StringsKt__StringsKt.split$default(r100, r101, r102, r103, r104, r105);
    }

    public static /* bridge */ /* synthetic */ Sequence splitToSequence$default(CharSequence r100, char[] r101, boolean r102, int r103, int r104, Object r105) {
        return StringsKt__StringsKt.splitToSequence$default(r100, r101, r102, r103, r104, r105);
    }

    public static /* bridge */ /* synthetic */ Sequence splitToSequence$default(CharSequence r100, String[] r101, boolean r102, int r103, int r104, Object r105) {
        return StringsKt__StringsKt.splitToSequence$default(r100, r101, r102, r103, r104, r105);
    }

    public static /* bridge */ /* synthetic */ boolean startsWith(String r100, String r101, int r102, boolean r103) {
        return StringsKt__StringsJVMKt.startsWith(r100, r101, r102, r103);
    }

    public static /* bridge */ /* synthetic */ boolean startsWith(String r100, String r101, boolean r102) {
        return StringsKt__StringsJVMKt.startsWith(r100, r101, r102);
    }

    public static /* bridge */ /* synthetic */ boolean startsWith$default(CharSequence r100, char r101, boolean r102, int r103, Object r104) {
        return StringsKt__StringsKt.startsWith$default(r100, r101, r102, r103, r104);
    }

    public static /* bridge */ /* synthetic */ boolean startsWith$default(CharSequence r100, CharSequence r101, int r102, boolean r103, int r104, Object r105) {
        return StringsKt__StringsKt.startsWith$default(r100, r101, r102, r103, r104, r105);
    }

    public static /* bridge */ /* synthetic */ boolean startsWith$default(CharSequence r100, CharSequence r101, boolean r102, int r103, Object r104) {
        return StringsKt__StringsKt.startsWith$default(r100, r101, r102, r103, r104);
    }

    public static /* bridge */ /* synthetic */ boolean startsWith$default(String r100, String r101, boolean r102, int r103, Object r104) {
        return StringsKt__StringsJVMKt.startsWith$default(r100, r101, r102, r103, r104);
    }

    public static /* bridge */ /* synthetic */ CharSequence subSequence(CharSequence r100, IntRange r101) {
        return StringsKt__StringsKt.subSequence(r100, r101);
    }

    public static /* bridge */ /* synthetic */ String substring(CharSequence r100, IntRange r101) {
        return StringsKt__StringsKt.substring(r100, r101);
    }

    public static /* bridge */ /* synthetic */ String substring(String r100, IntRange r101) {
        return StringsKt__StringsKt.substring(r100, r101);
    }

    public static /* bridge */ /* synthetic */ String substringAfter(String r100, char r101, String r102) {
        return StringsKt__StringsKt.substringAfter(r100, r101, r102);
    }

    public static /* bridge */ /* synthetic */ String substringAfter(String r100, String r101, String r102) {
        return StringsKt__StringsKt.substringAfter(r100, r101, r102);
    }

    public static /* bridge */ /* synthetic */ String substringAfter$default(String r100, char r101, String r102, int r103, Object r104) {
        return StringsKt__StringsKt.substringAfter$default(r100, r101, r102, r103, r104);
    }

    public static /* bridge */ /* synthetic */ String substringAfter$default(String r100, String r101, String r102, int r103, Object r104) {
        return StringsKt__StringsKt.substringAfter$default(r100, r101, r102, r103, r104);
    }

    public static /* bridge */ /* synthetic */ String substringAfterLast(String r100, char r101, String r102) {
        return StringsKt__StringsKt.substringAfterLast(r100, r101, r102);
    }

    public static /* bridge */ /* synthetic */ String substringAfterLast(String r100, String r101, String r102) {
        return StringsKt__StringsKt.substringAfterLast(r100, r101, r102);
    }

    public static /* bridge */ /* synthetic */ String substringAfterLast$default(String r100, char r101, String r102, int r103, Object r104) {
        return StringsKt__StringsKt.substringAfterLast$default(r100, r101, r102, r103, r104);
    }

    public static /* bridge */ /* synthetic */ String substringAfterLast$default(String r100, String r101, String r102, int r103, Object r104) {
        return StringsKt__StringsKt.substringAfterLast$default(r100, r101, r102, r103, r104);
    }

    public static /* bridge */ /* synthetic */ String substringBefore(String r100, char r101, String r102) {
        return StringsKt__StringsKt.substringBefore(r100, r101, r102);
    }

    public static /* bridge */ /* synthetic */ String substringBefore(String r100, String r101, String r102) {
        return StringsKt__StringsKt.substringBefore(r100, r101, r102);
    }

    public static /* bridge */ /* synthetic */ String substringBefore$default(String r100, char r101, String r102, int r103, Object r104) {
        return StringsKt__StringsKt.substringBefore$default(r100, r101, r102, r103, r104);
    }

    public static /* bridge */ /* synthetic */ String substringBefore$default(String r100, String r101, String r102, int r103, Object r104) {
        return StringsKt__StringsKt.substringBefore$default(r100, r101, r102, r103, r104);
    }

    public static /* bridge */ /* synthetic */ String substringBeforeLast(String r100, char r101, String r102) {
        return StringsKt__StringsKt.substringBeforeLast(r100, r101, r102);
    }

    public static /* bridge */ /* synthetic */ String substringBeforeLast(String r100, String r101, String r102) {
        return StringsKt__StringsKt.substringBeforeLast(r100, r101, r102);
    }

    public static /* bridge */ /* synthetic */ String substringBeforeLast$default(String r100, char r101, String r102, int r103, Object r104) {
        return StringsKt__StringsKt.substringBeforeLast$default(r100, r101, r102, r103, r104);
    }

    public static /* bridge */ /* synthetic */ String substringBeforeLast$default(String r100, String r101, String r102, int r103, Object r104) {
        return StringsKt__StringsKt.substringBeforeLast$default(r100, r101, r102, r103, r104);
    }

    public static /* bridge */ /* synthetic */ CharSequence take(CharSequence r100, int r101) {
        return StringsKt___StringsKt.take(r100, r101);
    }

    public static /* bridge */ /* synthetic */ String take(String r100, int r101) {
        return StringsKt___StringsKt.take(r100, r101);
    }

    public static /* bridge */ /* synthetic */ String takeLast(String r100, int r101) {
        return StringsKt___StringsKt.takeLast(r100, r101);
    }

    public static /* bridge */ /* synthetic */ BigDecimal toBigDecimalOrNull(String r100) {
        return StringsKt__StringNumberConversionsJVMKt.toBigDecimalOrNull(r100);
    }

    public static /* bridge */ /* synthetic */ Boolean toBooleanStrictOrNull(String r100) {
        return StringsKt__StringsKt.toBooleanStrictOrNull(r100);
    }

    public static /* bridge */ /* synthetic */ Byte toByteOrNull(String r100) {
        return StringsKt__StringNumberConversionsKt.toByteOrNull(r100);
    }

    public static /* bridge */ /* synthetic */ Collection toCollection(CharSequence r100, Collection r101) {
        return StringsKt___StringsKt.toCollection(r100, r101);
    }

    public static /* bridge */ /* synthetic */ Double toDoubleOrNull(String r100) {
        return StringsKt__StringNumberConversionsJVMKt.toDoubleOrNull(r100);
    }

    public static /* bridge */ /* synthetic */ Float toFloatOrNull(String r100) {
        return StringsKt__StringNumberConversionsJVMKt.toFloatOrNull(r100);
    }

    public static /* bridge */ /* synthetic */ Integer toIntOrNull(String r100) {
        return StringsKt__StringNumberConversionsKt.toIntOrNull(r100);
    }

    public static /* bridge */ /* synthetic */ Integer toIntOrNull(String r100, int r101) {
        return StringsKt__StringNumberConversionsKt.toIntOrNull(r100, r101);
    }

    public static /* bridge */ /* synthetic */ List toList(CharSequence r100) {
        return StringsKt___StringsKt.toList(r100);
    }

    public static /* bridge */ /* synthetic */ Long toLongOrNull(String r100) {
        return StringsKt__StringNumberConversionsKt.toLongOrNull(r100);
    }

    public static /* bridge */ /* synthetic */ Long toLongOrNull(String r100, int r101) {
        return StringsKt__StringNumberConversionsKt.toLongOrNull(r100, r101);
    }

    public static /* bridge */ /* synthetic */ List toMutableList(CharSequence r100) {
        return StringsKt___StringsKt.toMutableList(r100);
    }

    public static /* bridge */ /* synthetic */ Set toSet(CharSequence r100) {
        return StringsKt___StringsKt.toSet(r100);
    }

    public static /* bridge */ /* synthetic */ Short toShortOrNull(String r100) {
        return StringsKt__StringNumberConversionsKt.toShortOrNull(r100);
    }

    public static /* bridge */ /* synthetic */ CharSequence trim(CharSequence r100) {
        return StringsKt__StringsKt.trim(r100);
    }

    public static /* bridge */ /* synthetic */ CharSequence trim(CharSequence r100, char... r101) {
        return StringsKt__StringsKt.trim(r100, r101);
    }

    public static /* bridge */ /* synthetic */ String trim(String r100, char... r101) {
        return StringsKt__StringsKt.trim(r100, r101);
    }

    public static /* bridge */ /* synthetic */ CharSequence trimEnd(CharSequence r100) {
        return StringsKt__StringsKt.trimEnd(r100);
    }

    public static /* bridge */ /* synthetic */ String trimEnd(String r100, Function1 r101) {
        return StringsKt__StringsKt.trimEnd(r100, r101);
    }

    public static /* bridge */ /* synthetic */ String trimEnd(String r100, char... r101) {
        return StringsKt__StringsKt.trimEnd(r100, r101);
    }

    public static /* bridge */ /* synthetic */ String trimIndent(String r100) {
        return StringsKt__IndentKt.trimIndent(r100);
    }

    public static /* bridge */ /* synthetic */ String trimMargin$default(String r100, String r101, int r102, Object r103) {
        return StringsKt__IndentKt.trimMargin$default(r100, r101, r102, r103);
    }

    public static /* bridge */ /* synthetic */ CharSequence trimStart(CharSequence r100) {
        return StringsKt__StringsKt.trimStart(r100);
    }

    public static /* bridge */ /* synthetic */ String trimStart(String r100, char... r101) {
        return StringsKt__StringsKt.trimStart(r100, r101);
    }

    public static /* bridge */ /* synthetic */ Iterable withIndex(CharSequence r100) {
        return StringsKt___StringsKt.withIndex(r100);
    }

    public static /* bridge */ /* synthetic */ List zipWithNext(CharSequence r100) {
        return StringsKt___StringsKt.zipWithNext(r100);
    }

    private StringsKt() {
    }
}
