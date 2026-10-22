package kotlin.text;

import android.util.EventsUtils;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"kotlin/text/StringsKt__AppendableKt", "kotlin/text/StringsKt__IndentKt", "kotlin/text/StringsKt__RegexExtensionsJVMKt", "kotlin/text/StringsKt__RegexExtensionsKt", "kotlin/text/StringsKt__StringBuilderJVMKt", "kotlin/text/StringsKt__StringBuilderKt", "kotlin/text/StringsKt__StringNumberConversionsJVMKt", "kotlin/text/StringsKt__StringNumberConversionsKt", "kotlin/text/StringsKt__StringsJVMKt", "kotlin/text/StringsKt__StringsKt", "kotlin/text/StringsKt___StringsJvmKt", "kotlin/text/StringsKt___StringsKt"}, k = 4, mv = {1, 9, 0}, xi = EventsUtils.FEAT_TYPE_IOPRELOAD_DATA)
public final class StringsKt extends StringsKt___StringsKt {
    public static /* bridge */ /* synthetic */ StringBuilder append(StringBuilder r0, Object... r1) {
        return StringsKt__StringBuilderKt.append(r0, r1);
    }

    public static /* bridge */ /* synthetic */ StringBuilder append(StringBuilder r0, String... r1) {
        return StringsKt__StringBuilderKt.append(r0, r1);
    }

    public static /* bridge */ /* synthetic */ void appendElement(Appendable r0, Object r1, Function1 r2) {
        StringsKt__AppendableKt.appendElement(r0, r1, r2);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine()", imports = {}))
    public static /* bridge */ /* synthetic */ StringBuilder appendln(StringBuilder r0) {
        return StringsKt__StringBuilderJVMKt.appendln(r0);
    }

    public static /* bridge */ /* synthetic */ List chunked(CharSequence r0, int r1) {
        return StringsKt___StringsKt.chunked(r0, r1);
    }

    public static /* bridge */ /* synthetic */ StringBuilder clear(StringBuilder r0) {
        return StringsKt__StringBuilderJVMKt.clear(r0);
    }

    public static /* bridge */ /* synthetic */ int compareTo(String r0, String r1, boolean r2) {
        return StringsKt__StringsJVMKt.compareTo(r0, r1, r2);
    }

    public static /* bridge */ /* synthetic */ String concatToString(char[] r0) {
        return StringsKt__StringsJVMKt.concatToString(r0);
    }

    public static /* bridge */ /* synthetic */ String concatToString(char[] r0, int r1, int r2) {
        return StringsKt__StringsJVMKt.concatToString(r0, r1, r2);
    }

    public static /* bridge */ /* synthetic */ boolean contains(CharSequence r0, char r1, boolean r2) {
        return StringsKt__StringsKt.contains(r0, r1, r2);
    }

    public static /* bridge */ /* synthetic */ boolean contains(CharSequence r0, CharSequence r1, boolean r2) {
        return StringsKt__StringsKt.contains(r0, r1, r2);
    }

    public static /* bridge */ /* synthetic */ boolean contains$default(CharSequence r0, char r1, boolean r2, int r3, Object r4) {
        return StringsKt__StringsKt.contains$default(r0, r1, r2, r3, r4);
    }

    public static /* bridge */ /* synthetic */ boolean contains$default(CharSequence r0, CharSequence r1, boolean r2, int r3, Object r4) {
        return StringsKt__StringsKt.contains$default(r0, r1, r2, r3, r4);
    }

    public static /* bridge */ /* synthetic */ boolean contentEquals(CharSequence r0, CharSequence r1) {
        return StringsKt__StringsJVMKt.contentEquals(r0, r1);
    }

    public static /* bridge */ /* synthetic */ String decodeToString(byte[] r0) {
        return StringsKt__StringsJVMKt.decodeToString(r0);
    }

    public static /* bridge */ /* synthetic */ String decodeToString(byte[] r0, int r1, int r2, boolean r3) {
        return StringsKt__StringsJVMKt.decodeToString(r0, r1, r2, r3);
    }

    public static /* bridge */ /* synthetic */ String decodeToString$default(byte[] r0, int r1, int r2, boolean r3, int r4, Object r5) {
        return StringsKt__StringsJVMKt.decodeToString$default(r0, r1, r2, r3, r4, r5);
    }

    public static /* bridge */ /* synthetic */ String drop(String r0, int r1) {
        return StringsKt___StringsKt.drop(r0, r1);
    }

    public static /* bridge */ /* synthetic */ String dropLast(String r0, int r1) {
        return StringsKt___StringsKt.dropLast(r0, r1);
    }

    public static /* bridge */ /* synthetic */ byte[] encodeToByteArray(String r0) {
        return StringsKt__StringsJVMKt.encodeToByteArray(r0);
    }

    public static /* bridge */ /* synthetic */ boolean endsWith(CharSequence r0, char r1, boolean r2) {
        return StringsKt__StringsKt.endsWith(r0, r1, r2);
    }

    public static /* bridge */ /* synthetic */ boolean endsWith(String r0, String r1, boolean r2) {
        return StringsKt__StringsJVMKt.endsWith(r0, r1, r2);
    }

    public static /* bridge */ /* synthetic */ boolean endsWith$default(CharSequence r0, char r1, boolean r2, int r3, Object r4) {
        return StringsKt__StringsKt.endsWith$default(r0, r1, r2, r3, r4);
    }

    public static /* bridge */ /* synthetic */ boolean endsWith$default(CharSequence r0, CharSequence r1, boolean r2, int r3, Object r4) {
        return StringsKt__StringsKt.endsWith$default(r0, r1, r2, r3, r4);
    }

    public static /* bridge */ /* synthetic */ boolean endsWith$default(String r0, String r1, boolean r2, int r3, Object r4) {
        return StringsKt__StringsJVMKt.endsWith$default(r0, r1, r2, r3, r4);
    }

    public static /* bridge */ /* synthetic */ boolean equals(String r0, String r1, boolean r2) {
        return StringsKt__StringsJVMKt.equals(r0, r1, r2);
    }

    public static /* bridge */ /* synthetic */ boolean equals$default(String r0, String r1, boolean r2, int r3, Object r4) {
        return StringsKt__StringsJVMKt.equals$default(r0, r1, r2, r3, r4);
    }

    public static /* bridge */ /* synthetic */ Pair findAnyOf$default(CharSequence r0, Collection r1, int r2, boolean r3, int r4, Object r5) {
        return StringsKt__StringsKt.findAnyOf$default(r0, r1, r2, r3, r4, r5);
    }

    public static /* bridge */ /* synthetic */ char first(CharSequence r0) {
        return StringsKt___StringsKt.first(r0);
    }

    public static /* bridge */ /* synthetic */ Character firstOrNull(CharSequence r0) {
        return StringsKt___StringsKt.firstOrNull(r0);
    }

    public static /* bridge */ /* synthetic */ IntRange getIndices(CharSequence r0) {
        return StringsKt__StringsKt.getIndices(r0);
    }

    public static /* bridge */ /* synthetic */ int getLastIndex(CharSequence r0) {
        return StringsKt__StringsKt.getLastIndex(r0);
    }

    public static /* bridge */ /* synthetic */ Character getOrNull(CharSequence r0, int r1) {
        return StringsKt___StringsKt.getOrNull(r0, r1);
    }

    public static /* bridge */ /* synthetic */ int indexOf(CharSequence r0, String r1, int r2, boolean r3) {
        return StringsKt__StringsKt.indexOf(r0, r1, r2, r3);
    }

    public static /* bridge */ /* synthetic */ int indexOf$default(CharSequence r0, char r1, int r2, boolean r3, int r4, Object r5) {
        return StringsKt__StringsKt.indexOf$default(r0, r1, r2, r3, r4, r5);
    }

    public static /* bridge */ /* synthetic */ int indexOf$default(CharSequence r0, String r1, int r2, boolean r3, int r4, Object r5) {
        return StringsKt__StringsKt.indexOf$default(r0, r1, r2, r3, r4, r5);
    }

    public static /* bridge */ /* synthetic */ int indexOfAny$default(CharSequence r0, char[] r1, int r2, boolean r3, int r4, Object r5) {
        return StringsKt__StringsKt.indexOfAny$default(r0, r1, r2, r3, r4, r5);
    }

    public static /* bridge */ /* synthetic */ boolean isBlank(CharSequence r0) {
        return StringsKt__StringsKt.isBlank(r0);
    }

    public static /* bridge */ /* synthetic */ char last(CharSequence r0) {
        return StringsKt___StringsKt.last(r0);
    }

    public static /* bridge */ /* synthetic */ int lastIndexOf(CharSequence r0, String r1, int r2, boolean r3) {
        return StringsKt__StringsKt.lastIndexOf(r0, r1, r2, r3);
    }

    public static /* bridge */ /* synthetic */ int lastIndexOf$default(CharSequence r0, char r1, int r2, boolean r3, int r4, Object r5) {
        return StringsKt__StringsKt.lastIndexOf$default(r0, r1, r2, r3, r4, r5);
    }

    public static /* bridge */ /* synthetic */ int lastIndexOf$default(CharSequence r0, String r1, int r2, boolean r3, int r4, Object r5) {
        return StringsKt__StringsKt.lastIndexOf$default(r0, r1, r2, r3, r4, r5);
    }

    public static /* bridge */ /* synthetic */ int lastIndexOfAny$default(CharSequence r0, Collection r1, int r2, boolean r3, int r4, Object r5) {
        return StringsKt__StringsKt.lastIndexOfAny$default(r0, r1, r2, r3, r4, r5);
    }

    public static /* bridge */ /* synthetic */ int lastIndexOfAny$default(CharSequence r0, char[] r1, int r2, boolean r3, int r4, Object r5) {
        return StringsKt__StringsKt.lastIndexOfAny$default(r0, r1, r2, r3, r4, r5);
    }

    public static /* bridge */ /* synthetic */ Character lastOrNull(CharSequence r0) {
        return StringsKt___StringsKt.lastOrNull(r0);
    }

    public static /* bridge */ /* synthetic */ Sequence lineSequence(CharSequence r0) {
        return StringsKt__StringsKt.lineSequence(r0);
    }

    public static /* bridge */ /* synthetic */ List lines(CharSequence r0) {
        return StringsKt__StringsKt.lines(r0);
    }

    public static /* bridge */ /* synthetic */ String padEnd(String r0, int r1, char r2) {
        return StringsKt__StringsKt.padEnd(r0, r1, r2);
    }

    public static /* bridge */ /* synthetic */ String padEnd$default(String r0, int r1, char r2, int r3, Object r4) {
        return StringsKt__StringsKt.padEnd$default(r0, r1, r2, r3, r4);
    }

    public static /* bridge */ /* synthetic */ String padStart(String r0, int r1, char r2) {
        return StringsKt__StringsKt.padStart(r0, r1, r2);
    }

    public static /* bridge */ /* synthetic */ char random(CharSequence r0, Random r1) {
        return StringsKt___StringsKt.random(r0, r1);
    }

    public static /* bridge */ /* synthetic */ boolean regionMatches(String r0, int r1, String r2, int r3, int r4, boolean r5) {
        return StringsKt__StringsJVMKt.regionMatches(r0, r1, r2, r3, r4, r5);
    }

    public static /* bridge */ /* synthetic */ boolean regionMatches$default(String r0, int r1, String r2, int r3, int r4, boolean r5, int r6, Object r7) {
        return StringsKt__StringsJVMKt.regionMatches$default(r0, r1, r2, r3, r4, r5, r6, r7);
    }

    public static /* bridge */ /* synthetic */ String removePrefix(String r0, CharSequence r1) {
        return StringsKt__StringsKt.removePrefix(r0, r1);
    }

    public static /* bridge */ /* synthetic */ CharSequence removeRange(CharSequence r0, int r1, int r2) {
        return StringsKt__StringsKt.removeRange(r0, r1, r2);
    }

    public static /* bridge */ /* synthetic */ CharSequence removeRange(CharSequence r0, IntRange r1) {
        return StringsKt__StringsKt.removeRange(r0, r1);
    }

    public static /* bridge */ /* synthetic */ CharSequence removeSuffix(CharSequence r0, CharSequence r1) {
        return StringsKt__StringsKt.removeSuffix(r0, r1);
    }

    public static /* bridge */ /* synthetic */ String removeSuffix(String r0, CharSequence r1) {
        return StringsKt__StringsKt.removeSuffix(r0, r1);
    }

    public static /* bridge */ /* synthetic */ String removeSurrounding(String r0, CharSequence r1) {
        return StringsKt__StringsKt.removeSurrounding(r0, r1);
    }

    public static /* bridge */ /* synthetic */ String removeSurrounding(String r0, CharSequence r1, CharSequence r2) {
        return StringsKt__StringsKt.removeSurrounding(r0, r1, r2);
    }

    public static /* bridge */ /* synthetic */ String repeat(CharSequence r0, int r1) {
        return StringsKt__StringsJVMKt.repeat(r0, r1);
    }

    public static /* bridge */ /* synthetic */ String replace(String r0, String r1, String r2, boolean r3) {
        return StringsKt__StringsJVMKt.replace(r0, r1, r2, r3);
    }

    public static /* bridge */ /* synthetic */ String replace$default(String r0, char r1, char r2, boolean r3, int r4, Object r5) {
        return StringsKt__StringsJVMKt.replace$default(r0, r1, r2, r3, r4, r5);
    }

    public static /* bridge */ /* synthetic */ String replace$default(String r0, String r1, String r2, boolean r3, int r4, Object r5) {
        return StringsKt__StringsJVMKt.replace$default(r0, r1, r2, r3, r4, r5);
    }

    public static /* bridge */ /* synthetic */ String replaceAfterLast$default(String r0, char r1, String r2, String r3, int r4, Object r5) {
        return StringsKt__StringsKt.replaceAfterLast$default(r0, r1, r2, r3, r4, r5);
    }

    public static /* bridge */ /* synthetic */ String replaceFirst(String r0, String r1, String r2, boolean r3) {
        return StringsKt__StringsJVMKt.replaceFirst(r0, r1, r2, r3);
    }

    public static /* bridge */ /* synthetic */ String replaceFirst$default(String r0, String r1, String r2, boolean r3, int r4, Object r5) {
        return StringsKt__StringsJVMKt.replaceFirst$default(r0, r1, r2, r3, r4, r5);
    }

    public static /* bridge */ /* synthetic */ CharSequence replaceRange(CharSequence r0, int r1, int r2, CharSequence r3) {
        return StringsKt__StringsKt.replaceRange(r0, r1, r2, r3);
    }

    public static /* bridge */ /* synthetic */ CharSequence replaceRange(CharSequence r0, IntRange r1, CharSequence r2) {
        return StringsKt__StringsKt.replaceRange(r0, r1, r2);
    }

    public static /* bridge */ /* synthetic */ CharSequence reversed(CharSequence r0) {
        return StringsKt___StringsKt.reversed(r0);
    }

    public static /* bridge */ /* synthetic */ char single(CharSequence r0) {
        return StringsKt___StringsKt.single(r0);
    }

    public static /* bridge */ /* synthetic */ String slice(String r0, IntRange r1) {
        return StringsKt___StringsKt.slice(r0, r1);
    }

    public static /* bridge */ /* synthetic */ List split$default(CharSequence r0, Pattern r1, int r2, int r3, Object r4) {
        return StringsKt__StringsJVMKt.split$default(r0, r1, r2, r3, r4);
    }

    public static /* bridge */ /* synthetic */ List split$default(CharSequence r0, char[] r1, boolean r2, int r3, int r4, Object r5) {
        return StringsKt__StringsKt.split$default(r0, r1, r2, r3, r4, r5);
    }

    public static /* bridge */ /* synthetic */ List split$default(CharSequence r0, String[] r1, boolean r2, int r3, int r4, Object r5) {
        return StringsKt__StringsKt.split$default(r0, r1, r2, r3, r4, r5);
    }

    public static /* bridge */ /* synthetic */ Sequence splitToSequence$default(CharSequence r0, char[] r1, boolean r2, int r3, int r4, Object r5) {
        return StringsKt__StringsKt.splitToSequence$default(r0, r1, r2, r3, r4, r5);
    }

    public static /* bridge */ /* synthetic */ Sequence splitToSequence$default(CharSequence r0, String[] r1, boolean r2, int r3, int r4, Object r5) {
        return StringsKt__StringsKt.splitToSequence$default(r0, r1, r2, r3, r4, r5);
    }

    public static /* bridge */ /* synthetic */ boolean startsWith(String r0, String r1, int r2, boolean r3) {
        return StringsKt__StringsJVMKt.startsWith(r0, r1, r2, r3);
    }

    public static /* bridge */ /* synthetic */ boolean startsWith(String r0, String r1, boolean r2) {
        return StringsKt__StringsJVMKt.startsWith(r0, r1, r2);
    }

    public static /* bridge */ /* synthetic */ boolean startsWith$default(CharSequence r0, char r1, boolean r2, int r3, Object r4) {
        return StringsKt__StringsKt.startsWith$default(r0, r1, r2, r3, r4);
    }

    public static /* bridge */ /* synthetic */ boolean startsWith$default(CharSequence r0, CharSequence r1, int r2, boolean r3, int r4, Object r5) {
        return StringsKt__StringsKt.startsWith$default(r0, r1, r2, r3, r4, r5);
    }

    public static /* bridge */ /* synthetic */ boolean startsWith$default(CharSequence r0, CharSequence r1, boolean r2, int r3, Object r4) {
        return StringsKt__StringsKt.startsWith$default(r0, r1, r2, r3, r4);
    }

    public static /* bridge */ /* synthetic */ boolean startsWith$default(String r0, String r1, boolean r2, int r3, Object r4) {
        return StringsKt__StringsJVMKt.startsWith$default(r0, r1, r2, r3, r4);
    }

    public static /* bridge */ /* synthetic */ CharSequence subSequence(CharSequence r0, IntRange r1) {
        return StringsKt__StringsKt.subSequence(r0, r1);
    }

    public static /* bridge */ /* synthetic */ String substring(CharSequence r0, IntRange r1) {
        return StringsKt__StringsKt.substring(r0, r1);
    }

    public static /* bridge */ /* synthetic */ String substring(String r0, IntRange r1) {
        return StringsKt__StringsKt.substring(r0, r1);
    }

    public static /* bridge */ /* synthetic */ String substringAfter(String r0, char r1, String r2) {
        return StringsKt__StringsKt.substringAfter(r0, r1, r2);
    }

    public static /* bridge */ /* synthetic */ String substringAfter(String r0, String r1, String r2) {
        return StringsKt__StringsKt.substringAfter(r0, r1, r2);
    }

    public static /* bridge */ /* synthetic */ String substringAfter$default(String r0, char r1, String r2, int r3, Object r4) {
        return StringsKt__StringsKt.substringAfter$default(r0, r1, r2, r3, r4);
    }

    public static /* bridge */ /* synthetic */ String substringAfter$default(String r0, String r1, String r2, int r3, Object r4) {
        return StringsKt__StringsKt.substringAfter$default(r0, r1, r2, r3, r4);
    }

    public static /* bridge */ /* synthetic */ String substringAfterLast(String r0, char r1, String r2) {
        return StringsKt__StringsKt.substringAfterLast(r0, r1, r2);
    }

    public static /* bridge */ /* synthetic */ String substringAfterLast(String r0, String r1, String r2) {
        return StringsKt__StringsKt.substringAfterLast(r0, r1, r2);
    }

    public static /* bridge */ /* synthetic */ String substringAfterLast$default(String r0, char r1, String r2, int r3, Object r4) {
        return StringsKt__StringsKt.substringAfterLast$default(r0, r1, r2, r3, r4);
    }

    public static /* bridge */ /* synthetic */ String substringAfterLast$default(String r0, String r1, String r2, int r3, Object r4) {
        return StringsKt__StringsKt.substringAfterLast$default(r0, r1, r2, r3, r4);
    }

    public static /* bridge */ /* synthetic */ String substringBefore(String r0, char r1, String r2) {
        return StringsKt__StringsKt.substringBefore(r0, r1, r2);
    }

    public static /* bridge */ /* synthetic */ String substringBefore(String r0, String r1, String r2) {
        return StringsKt__StringsKt.substringBefore(r0, r1, r2);
    }

    public static /* bridge */ /* synthetic */ String substringBefore$default(String r0, char r1, String r2, int r3, Object r4) {
        return StringsKt__StringsKt.substringBefore$default(r0, r1, r2, r3, r4);
    }

    public static /* bridge */ /* synthetic */ String substringBefore$default(String r0, String r1, String r2, int r3, Object r4) {
        return StringsKt__StringsKt.substringBefore$default(r0, r1, r2, r3, r4);
    }

    public static /* bridge */ /* synthetic */ String substringBeforeLast(String r0, char r1, String r2) {
        return StringsKt__StringsKt.substringBeforeLast(r0, r1, r2);
    }

    public static /* bridge */ /* synthetic */ String substringBeforeLast(String r0, String r1, String r2) {
        return StringsKt__StringsKt.substringBeforeLast(r0, r1, r2);
    }

    public static /* bridge */ /* synthetic */ String substringBeforeLast$default(String r0, char r1, String r2, int r3, Object r4) {
        return StringsKt__StringsKt.substringBeforeLast$default(r0, r1, r2, r3, r4);
    }

    public static /* bridge */ /* synthetic */ String substringBeforeLast$default(String r0, String r1, String r2, int r3, Object r4) {
        return StringsKt__StringsKt.substringBeforeLast$default(r0, r1, r2, r3, r4);
    }

    public static /* bridge */ /* synthetic */ CharSequence take(CharSequence r0, int r1) {
        return StringsKt___StringsKt.take(r0, r1);
    }

    public static /* bridge */ /* synthetic */ String take(String r0, int r1) {
        return StringsKt___StringsKt.take(r0, r1);
    }

    public static /* bridge */ /* synthetic */ String takeLast(String r0, int r1) {
        return StringsKt___StringsKt.takeLast(r0, r1);
    }

    public static /* bridge */ /* synthetic */ BigDecimal toBigDecimalOrNull(String r0) {
        return StringsKt__StringNumberConversionsJVMKt.toBigDecimalOrNull(r0);
    }

    public static /* bridge */ /* synthetic */ Boolean toBooleanStrictOrNull(String r0) {
        return StringsKt__StringsKt.toBooleanStrictOrNull(r0);
    }

    public static /* bridge */ /* synthetic */ Byte toByteOrNull(String r0) {
        return StringsKt__StringNumberConversionsKt.toByteOrNull(r0);
    }

    public static /* bridge */ /* synthetic */ Collection toCollection(CharSequence r0, Collection r1) {
        return StringsKt___StringsKt.toCollection(r0, r1);
    }

    public static /* bridge */ /* synthetic */ Double toDoubleOrNull(String r0) {
        return StringsKt__StringNumberConversionsJVMKt.toDoubleOrNull(r0);
    }

    public static /* bridge */ /* synthetic */ Float toFloatOrNull(String r0) {
        return StringsKt__StringNumberConversionsJVMKt.toFloatOrNull(r0);
    }

    public static /* bridge */ /* synthetic */ Integer toIntOrNull(String r0) {
        return StringsKt__StringNumberConversionsKt.toIntOrNull(r0);
    }

    public static /* bridge */ /* synthetic */ Integer toIntOrNull(String r0, int r1) {
        return StringsKt__StringNumberConversionsKt.toIntOrNull(r0, r1);
    }

    public static /* bridge */ /* synthetic */ List toList(CharSequence r0) {
        return StringsKt___StringsKt.toList(r0);
    }

    public static /* bridge */ /* synthetic */ Long toLongOrNull(String r0) {
        return StringsKt__StringNumberConversionsKt.toLongOrNull(r0);
    }

    public static /* bridge */ /* synthetic */ Long toLongOrNull(String r0, int r1) {
        return StringsKt__StringNumberConversionsKt.toLongOrNull(r0, r1);
    }

    public static /* bridge */ /* synthetic */ List toMutableList(CharSequence r0) {
        return StringsKt___StringsKt.toMutableList(r0);
    }

    public static /* bridge */ /* synthetic */ Set toSet(CharSequence r0) {
        return StringsKt___StringsKt.toSet(r0);
    }

    public static /* bridge */ /* synthetic */ Short toShortOrNull(String r0) {
        return StringsKt__StringNumberConversionsKt.toShortOrNull(r0);
    }

    public static /* bridge */ /* synthetic */ CharSequence trim(CharSequence r0) {
        return StringsKt__StringsKt.trim(r0);
    }

    public static /* bridge */ /* synthetic */ CharSequence trim(CharSequence r0, char... r1) {
        return StringsKt__StringsKt.trim(r0, r1);
    }

    public static /* bridge */ /* synthetic */ String trim(String r0, char... r1) {
        return StringsKt__StringsKt.trim(r0, r1);
    }

    public static /* bridge */ /* synthetic */ CharSequence trimEnd(CharSequence r0) {
        return StringsKt__StringsKt.trimEnd(r0);
    }

    public static /* bridge */ /* synthetic */ String trimEnd(String r0, Function1 r1) {
        return StringsKt__StringsKt.trimEnd(r0, r1);
    }

    public static /* bridge */ /* synthetic */ String trimEnd(String r0, char... r1) {
        return StringsKt__StringsKt.trimEnd(r0, r1);
    }

    public static /* bridge */ /* synthetic */ String trimIndent(String r0) {
        return StringsKt__IndentKt.trimIndent(r0);
    }

    public static /* bridge */ /* synthetic */ String trimMargin$default(String r0, String r1, int r2, Object r3) {
        return StringsKt__IndentKt.trimMargin$default(r0, r1, r2, r3);
    }

    public static /* bridge */ /* synthetic */ CharSequence trimStart(CharSequence r0) {
        return StringsKt__StringsKt.trimStart(r0);
    }

    public static /* bridge */ /* synthetic */ String trimStart(String r0, char... r1) {
        return StringsKt__StringsKt.trimStart(r0, r1);
    }

    public static /* bridge */ /* synthetic */ Iterable withIndex(CharSequence r0) {
        return StringsKt___StringsKt.withIndex(r0);
    }

    public static /* bridge */ /* synthetic */ List zipWithNext(CharSequence r0) {
        return StringsKt___StringsKt.zipWithNext(r0);
    }

    private StringsKt() {
    }
}
