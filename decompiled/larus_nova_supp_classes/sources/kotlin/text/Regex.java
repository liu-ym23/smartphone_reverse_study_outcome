package kotlin.text;

import android.util.EventsUtils;
import com.bytedance.mt.protector.impl.PatternProtector;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 02\u00060\u0001j\u0002`\u0002:\u000201B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u001d\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\n¢\u0006\u0002\u0010\u000bB\u000f\b\u0001\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u001bJ\u001e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u001d2\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u001bJ\u001a\u0010\u001e\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u001bH\u0007J\u0010\u0010 \u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0016\u001a\u00020\u0017J\u0011\u0010!\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0086\u0004J\u0018\u0010\"\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u001bH\u0007J\"\u0010#\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00170%J\u0016\u0010#\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\u0004J\u0016\u0010'\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\u0004J\u001e\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00040)2\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010*\u001a\u00020\u001bJ \u0010+\u001a\b\u0012\u0004\u0012\u00020\u00040\u001d2\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010*\u001a\u00020\u001bH\u0007J\u0006\u0010,\u001a\u00020\rJ\b\u0010-\u001a\u00020\u0004H\u0016J\b\u0010.\u001a\u00020/H\u0002R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\n8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u00062"}, d2 = {"Lkotlin/text/Regex;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "pattern", XmlPullParser.NO_NAMESPACE, "(Ljava/lang/String;)V", "option", "Lkotlin/text/RegexOption;", "(Ljava/lang/String;Lkotlin/text/RegexOption;)V", "options", XmlPullParser.NO_NAMESPACE, "(Ljava/lang/String;Ljava/util/Set;)V", "nativePattern", "Ljava/util/regex/Pattern;", "(Ljava/util/regex/Pattern;)V", "_options", "getOptions", "()Ljava/util/Set;", "getPattern", "()Ljava/lang/String;", "containsMatchIn", XmlPullParser.NO_NAMESPACE, "input", XmlPullParser.NO_NAMESPACE, "find", "Lkotlin/text/MatchResult;", "startIndex", XmlPullParser.NO_NAMESPACE, "findAll", "Lkotlin/sequences/Sequence;", "matchAt", "index", "matchEntire", "matches", "matchesAt", "replace", "transform", "Lkotlin/Function1;", "replacement", "replaceFirst", "split", XmlPullParser.NO_NAMESPACE, "limit", "splitToSequence", "toPattern", "toString", "writeReplace", XmlPullParser.NO_NAMESPACE, "Companion", "Serialized", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class Regex implements Serializable {
    public static final Companion Companion = null;
    private Set<? extends RegexOption> _options;
    private final Pattern nativePattern;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007¨\u0006\f"}, d2 = {"Lkotlin/text/Regex$Companion;", XmlPullParser.NO_NAMESPACE, "()V", "ensureUnicodeCase", XmlPullParser.NO_NAMESPACE, "flags", "escape", XmlPullParser.NO_NAMESPACE, "literal", "escapeReplacement", "fromLiteral", "Lkotlin/text/Regex;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private final int ensureUnicodeCase(int r2) {
            if ((r2 & 2) != 0) goto L5;
            return r2;
        L5:
            return r2 | 64;
        }

        public final String escape(String r2) {
            Intrinsics.checkNotNullParameter(r2, "literal");
            return Pattern.quote(r2);
        }

        public final String escapeReplacement(String r2) {
            Intrinsics.checkNotNullParameter(r2, "literal");
            return Matcher.quoteReplacement(r2);
        }

        public final Regex fromLiteral(String r3) {
            Intrinsics.checkNotNullParameter(r3, "literal");
            return new Regex(r3, RegexOption.LITERAL);
        }

        public static final /* synthetic */ int access$ensureUnicodeCase(Companion r0, int r1) {
            return r0.ensureUnicodeCase(r1);
        }
    }

    static {
        Companion = new Companion(null);
    }

    private final Object writeReplace() {
        return new Serialized(this.nativePattern.pattern(), this.nativePattern.flags());
    }

    public final Set<RegexOption> getOptions() {
        Set<? extends RegexOption> r0 = this._options;
        if (r0 != null) goto L6;
        int r1 = this.nativePattern.flags();
        EnumSet r2 = EnumSet.allOf(RegexOption.class);
        Intrinsics.checkNotNull(r2);
        CollectionsKt.retainAll(r2, new Regex$special$.inlined.fromInt.1(r1));
        Set<? extends RegexOption> r3 = Collections.unmodifiableSet(r2);
        this._options = r3;
        return r3;
    L6:
        return r0;
    }

    public final String getPattern() {
        return this.nativePattern.pattern();
    }

    public String toString() {
        return this.nativePattern.toString();
    }

    public final Pattern toPattern() {
        return this.nativePattern;
    }

    public Regex(String r2) {
        Intrinsics.checkNotNullParameter(r2, "pattern");
        this(PatternProtector.compile(r2));
    }

    public static final /* synthetic */ Pattern access$getNativePattern$p(Regex r0) {
        return r0.nativePattern;
    }

    public final boolean containsMatchIn(CharSequence r2) {
        Intrinsics.checkNotNullParameter(r2, "input");
        return this.nativePattern.matcher(r2).find();
    }

    public final MatchResult matchEntire(CharSequence r2) {
        Intrinsics.checkNotNullParameter(r2, "input");
        return RegexKt.access$matchEntire(this.nativePattern.matcher(r2), r2);
    }

    public final boolean matches(CharSequence r2) {
        Intrinsics.checkNotNullParameter(r2, "input");
        return this.nativePattern.matcher(r2).matches();
    }

    public Regex(Pattern r2) {
        Intrinsics.checkNotNullParameter(r2, "nativePattern");
        this.nativePattern = r2;
    }

    public Regex(String r2, Set<? extends RegexOption> r3) {
        Intrinsics.checkNotNullParameter(r2, "pattern");
        Intrinsics.checkNotNullParameter(r3, "options");
        this(PatternProtector.compile(r2, Companion.access$ensureUnicodeCase(Companion, RegexKt.access$toInt(r3))));
    }

    public final MatchResult find(CharSequence r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "input");
        return RegexKt.access$findNext(this.nativePattern.matcher(r2), r3, r2);
    }

    public final Sequence<MatchResult> findAll(CharSequence r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "input");
        if (r5 < 0) goto L9;
        if (r5 > r4.length()) goto L9;
        return SequencesKt.generateSequence(new findAll.1(this, r4, r5), findAll.2.INSTANCE);
    L9:
        throw new IndexOutOfBoundsException("Start index out of bounds: " + r5 + ", input length: " + r4.length());
    }

    public final MatchResult matchAt(CharSequence r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "input");
        Matcher r5 = this.nativePattern.matcher(r3).useAnchoringBounds(false).useTransparentBounds(true).region(r4, r3.length());
        if (r5.lookingAt() == false) goto L5;
        Intrinsics.checkNotNull(r5);
        return new MatcherMatchResult(r5, r3);
    L5:
        return null;
    }

    public final boolean matchesAt(CharSequence r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "input");
        return this.nativePattern.matcher(r3).useAnchoringBounds(false).useTransparentBounds(true).region(r4, r3.length()).lookingAt();
    }

    public final String replace(CharSequence r6, Function1<? super MatchResult, ? extends CharSequence> r7) {
        Intrinsics.checkNotNullParameter(r6, "input");
        Intrinsics.checkNotNullParameter(r7, "transform");
        int r2 = 0;
        MatchResult r0 = find$default(this, r6, 0, 2, null);
        if (r0 == null) goto L5;
        int r1 = r6.length();
        StringBuilder r3 = new StringBuilder(r1);
    L7:
        r3.append(r6, r2, r0.getRange().getStart().intValue());
        r3.append(r7.invoke(r0));
        r2 = r0.getRange().getEndInclusive().intValue() + 1;
        r0 = r0.next();
        if (r2 >= r1) goto L10;
        if (r0 != null) goto L7;
    L10:
        if (r2 >= r1) goto L13;
        r3.append(r6, r2, r1);
    L13:
        return r3.toString();
    L5:
        return r6.toString();
    }

    public final String replaceFirst(CharSequence r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "input");
        Intrinsics.checkNotNullParameter(r3, "replacement");
        return this.nativePattern.matcher(r2).replaceFirst(r3);
    }

    public final List<String> split(CharSequence r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "input");
        StringsKt__StringsKt.requireNonNegativeLimit(r6);
        Matcher r0 = this.nativePattern.matcher(r5);
        if (r6 == 1) goto L20;
        if (r0.find() == false) goto L20;
        int r3 = 10;
        if (r6 <= 0) goto L10;
        r3 = RangesKt.coerceAtMost(r6, 10);
    L10:
        ArrayList r2 = new ArrayList(r3);
        int r7 = r6 - 1;
        int r1 = 0;
    L11:
        r2.add(r5.subSequence(r1, r0.start()).toString());
        r1 = r0.end();
        if (r7 < 0) goto L16;
        if (r2.size() != r7) goto L16;
    L17:
        r2.add(r5.subSequence(r1, r5.length()).toString());
        return r2;
    L16:
        if (r0.find() == true) goto L11;
    L20:
        return CollectionsKt.listOf(r5.toString());
    }

    public final Sequence<String> splitToSequence(CharSequence r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "input");
        StringsKt__StringsKt.requireNonNegativeLimit(r4);
        return SequencesKt.sequence(new splitToSequence.1(this, r3, r4, null));
    }

    public Regex(String r2, RegexOption r3) {
        Intrinsics.checkNotNullParameter(r2, "pattern");
        Intrinsics.checkNotNullParameter(r3, "option");
        this(PatternProtector.compile(r2, Companion.access$ensureUnicodeCase(Companion, r3.getValue())));
    }

    public final String replace(CharSequence r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "input");
        Intrinsics.checkNotNullParameter(r3, "replacement");
        return this.nativePattern.matcher(r2).replaceAll(r3);
    }

    public static /* synthetic */ MatchResult find$default(Regex r0, CharSequence r1, int r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = 0;
    L6:
        return r0.find(r1, r2);
    }

    public static /* synthetic */ Sequence findAll$default(Regex r0, CharSequence r1, int r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = 0;
    L6:
        return r0.findAll(r1, r2);
    }

    public static /* synthetic */ List split$default(Regex r0, CharSequence r1, int r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = 0;
    L6:
        return r0.split(r1, r2);
    }

    public static /* synthetic */ Sequence splitToSequence$default(Regex r0, CharSequence r1, int r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = 0;
    L6:
        return r0.splitToSequence(r1, r2);
    }
}
