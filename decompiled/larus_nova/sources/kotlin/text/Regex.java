package kotlin.text;

import com.android.ttcjpaysdk.thirdparty.verify.view.VerifyPasswordFragment;
import com.byted.cast.common.TeaEventTrack;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.ss.ttm.player.MediaPlayer;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequenceScope;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 02\u00060\u0001j\u0002`\u0002:\u000201B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u001d\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\n¢\u0006\u0002\u0010\u000bB\u000f\b\u0001\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u001bJ\u001e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u001d2\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u001bJ\u001a\u0010\u001e\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u001bH\u0007J\u0010\u0010 \u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0016\u001a\u00020\u0017J\u0011\u0010!\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0086\u0004J\u0018\u0010\"\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u001bH\u0007J\"\u0010#\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00170%J\u0016\u0010#\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\u0004J\u0016\u0010'\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\u0004J\u001e\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00040)2\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010*\u001a\u00020\u001bJ \u0010+\u001a\b\u0012\u0004\u0012\u00020\u00040\u001d2\u0006\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010*\u001a\u00020\u001bH\u0007J\u0006\u0010,\u001a\u00020\rJ\b\u0010-\u001a\u00020\u0004H\u0016J\b\u0010.\u001a\u00020/H\u0002R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\n8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u00062"}, d2 = {"Lkotlin/text/Regex;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "pattern", "", "(Ljava/lang/String;)V", "option", "Lkotlin/text/RegexOption;", "(Ljava/lang/String;Lkotlin/text/RegexOption;)V", "options", "", "(Ljava/lang/String;Ljava/util/Set;)V", "nativePattern", "Ljava/util/regex/Pattern;", "(Ljava/util/regex/Pattern;)V", "_options", "getOptions", "()Ljava/util/Set;", "getPattern", "()Ljava/lang/String;", "containsMatchIn", "", "input", "", "find", "Lkotlin/text/MatchResult;", "startIndex", "", "findAll", "Lkotlin/sequences/Sequence;", "matchAt", "index", "matchEntire", "matches", "matchesAt", "replace", "transform", "Lkotlin/Function1;", "replacement", "replaceFirst", "split", "", VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT, "splitToSequence", "toPattern", "toString", "writeReplace", "", "Companion", "Serialized", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class Regex implements Serializable {
    public static final Companion Companion = null;
    private Set<? extends RegexOption> _options;
    private final Pattern nativePattern;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007¨\u0006\f"}, d2 = {"Lkotlin/text/Regex$Companion;", "", "()V", "ensureUnicodeCase", "", "flags", "escape", "", "literal", "escapeReplacement", "fromLiteral", "Lkotlin/text/Regex;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        private final int ensureUnicodeCase(int r100) {
            if ((r100 & 2) != 0) goto L5;
            return r100;
        L5:
            return r100 | 64;
        }

        public final String escape(String r100) {
            Intrinsics.checkNotNullParameter(r100, "literal");
            return Pattern.quote(r100);
        }

        public final String escapeReplacement(String r100) {
            Intrinsics.checkNotNullParameter(r100, "literal");
            return Matcher.quoteReplacement(r100);
        }

        public final Regex fromLiteral(String r100) {
            Intrinsics.checkNotNullParameter(r100, "literal");
            return new Regex(r100, RegexOption.LITERAL);
        }

        public static final /* synthetic */ int access$ensureUnicodeCase(Companion r100, int r101) {
            return r100.ensureUnicodeCase(r101);
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u0000 \u000e2\u00060\u0001j\u0002`\u0002:\u0001\u000eB\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0002R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lkotlin/text/Regex$Serialized;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "pattern", "", "flags", "", "(Ljava/lang/String;I)V", "getFlags", "()I", "getPattern", "()Ljava/lang/String;", "readResolve", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Serialized implements Serializable {
        public static final Companion Companion = null;
        private static final long serialVersionUID = 0;
        private final int flags;
        private final String pattern;

        /* JADX INFO: loaded from: classes42.dex */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lkotlin/text/Regex$Serialized$Companion;", "", "()V", "serialVersionUID", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r100) {
                this();
            }
        }

        static {
            Companion = new Companion(null);
        }

        private final Object readResolve() {
            return new Regex(PatternProtector.compile(this.pattern, this.flags));
        }

        public final int getFlags() {
            return this.flags;
        }

        public final String getPattern() {
            return this.pattern;
        }

        public Serialized(String r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "pattern");
            this.pattern = r100;
            this.flags = r101;
        }
    }

    /* JADX INFO: renamed from: kotlin.text.Regex$findAll$2, reason: invalid class name */
    /* JADX INFO: loaded from: classes5.dex */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<MatchResult, MatchResult> {
        public static final AnonymousClass2 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass2();
        }

        public AnonymousClass2() {
            super(1, MatchResult.class, TeaEventTrack.ACTION_DRAMA_NEXT, "next()Lkotlin/text/MatchResult;", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final MatchResult invoke2(MatchResult r100) {
            Intrinsics.checkNotNullParameter(r100, "p0");
            return r100.next();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ MatchResult invoke(MatchResult r100) {
            return invoke2(r100);
        }
    }

    /* JADX INFO: renamed from: kotlin.text.Regex$splitToSequence$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: loaded from: classes6.dex */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "kotlin.text.Regex$splitToSequence$1", f = "Regex.kt", i = {1, 1, 1}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_HTTP_RES_FINSIH_TIME, MediaPlayer.MEDIA_PLAYER_OPTION_GET_CUR_UI_FPS, MediaPlayer.MEDIA_PLAYER_OPTION_HANDLE_AUDIO_EXTRADATA}, m = "invokeSuspend", n = {"$this$sequence", "matcher", "splitCount"}, s = {"L$0", "L$1", "I$0"})
    public static final class C123671 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super String>, Continuation<? super Unit>, Object> {
        final /* synthetic */ CharSequence $input;
        final /* synthetic */ int $limit;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ Regex this$0;

        public C123671(Regex r100, CharSequence r101, int r102, Continuation<? super C123671> r103) {
            this.this$0 = r100;
            this.$input = r101;
            this.$limit = r102;
            super(2, r103);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            C123671 r102 = new C123671(this.this$0, this.$input, this.$limit, r101);
            r102.L$0 = r100;
            return r102;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(SequenceScope<? super String> r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(SequenceScope<? super String> r100, Continuation<? super Unit> r101) {
            return ((C123671) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0070 -> B:21:0x0073). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r110) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            if (r101 == 0) goto L12;
            if (r101 == 1) goto L11;
            if (r101 == 2) goto L10;
            if (r101 != 3) goto L9;
            ResultKt.throwOnFailure(r110);
        L29:
            return Unit.INSTANCE;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            int r102 = this.I$0;
            Matcher r103 = (Matcher) this.L$1;
            SequenceScope r104 = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(r110);
            C123671 r105 = this;
            Matcher r111 = r103;
        L21:
            int r106 = r111.end();
            r102 = r102 + 1;
            if (r102 != (r105.$limit - 1)) goto L24;
        L25:
            CharSequence r112 = r105.$input;
            String r113 = r112.subSequence(r106, r112.length()).toString();
            r105.L$0 = null;
            r105.L$1 = null;
            r105.label = 3;
            if (r104.yield(r113, r105) != r100) goto L29;
            return r100;
        L24:
            if (r111.find() == false) goto L25;
        L18:
            String r107 = r105.$input.subSequence(r106, r111.start()).toString();
            r105.L$0 = r104;
            r105.L$1 = r111;
            r105.I$0 = r102;
            r105.label = 2;
            if (r104.yield(r107, r105) != r100) goto L21;
            return r100;
        L11:
            ResultKt.throwOnFailure(r110);
        L34:
            return Unit.INSTANCE;
        L12:
            ResultKt.throwOnFailure(r110);
            SequenceScope r114 = (SequenceScope) this.L$0;
            Matcher r108 = Regex.access$getNativePattern$p(this.this$0).matcher(this.$input);
            if (this.$limit != 1) goto L15;
        L30:
            String r109 = this.$input.toString();
            this.label = 1;
            if (r114.yield(r109, this) != r100) goto L34;
            return r100;
        L15:
            if (r108.find() == false) goto L30;
            r106 = 0;
            r105 = this;
            r104 = r114;
            r111 = r108;
            r102 = 0;
            goto L18
        }
    }

    static {
        Companion = new Companion(null);
    }

    private final Object writeReplace() {
        return new Serialized(this.nativePattern.pattern(), this.nativePattern.flags());
    }

    public final Set<RegexOption> getOptions() {
        Set r100 = this._options;
        if (r100 != null) goto L6;
        final int r101 = this.nativePattern.flags();
        EnumSet r102 = EnumSet.allOf(RegexOption.class);
        Intrinsics.checkNotNull(r102);
        CollectionsKt.retainAll(r102, new Regex$special$$inlined$fromInt$1(r101));
        Set<RegexOption> r103 = Collections.unmodifiableSet(r102);
        this._options = r103;
        return r103;
    L6:
        return r100;
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

    public Regex(String r100) {
        Intrinsics.checkNotNullParameter(r100, "pattern");
        this(PatternProtector.compile(r100));
    }

    public static final /* synthetic */ Pattern access$getNativePattern$p(Regex r100) {
        return r100.nativePattern;
    }

    public final boolean containsMatchIn(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "input");
        return this.nativePattern.matcher(r100).find();
    }

    public final MatchResult matchEntire(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "input");
        return RegexKt.access$matchEntire(this.nativePattern.matcher(r100), r100);
    }

    public final boolean matches(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "input");
        return this.nativePattern.matcher(r100).matches();
    }

    public Regex(Pattern r100) {
        Intrinsics.checkNotNullParameter(r100, "nativePattern");
        this.nativePattern = r100;
    }

    public Regex(String r100, Set<? extends RegexOption> r101) {
        Intrinsics.checkNotNullParameter(r100, "pattern");
        Intrinsics.checkNotNullParameter(r101, "options");
        this(PatternProtector.compile(r100, Companion.access$ensureUnicodeCase(Companion, RegexKt.access$toInt(r101))));
    }

    public final MatchResult find(CharSequence r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "input");
        return RegexKt.access$findNext(this.nativePattern.matcher(r100), r101, r100);
    }

    public final Sequence<MatchResult> findAll(final CharSequence r100, final int r101) {
        Intrinsics.checkNotNullParameter(r100, "input");
        if (r101 < 0) goto L9;
        if (r101 > r100.length()) goto L9;
        return SequencesKt.generateSequence(new AnonymousClass1(this, r100, r101), AnonymousClass2.INSTANCE);
    L9:
        throw new IndexOutOfBoundsException("Start index out of bounds: " + r101 + ", input length: " + r100.length());
    }

    public final MatchResult matchAt(CharSequence r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "input");
        Matcher r102 = this.nativePattern.matcher(r100).useAnchoringBounds(false).useTransparentBounds(true).region(r101, r100.length());
        if (r102.lookingAt() == false) goto L5;
        Intrinsics.checkNotNull(r102);
        return new MatcherMatchResult(r102, r100);
    L5:
        return null;
    }

    public final boolean matchesAt(CharSequence r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "input");
        return this.nativePattern.matcher(r100).useAnchoringBounds(false).useTransparentBounds(true).region(r101, r100.length()).lookingAt();
    }

    public final String replace(CharSequence r100, Function1<? super MatchResult, ? extends CharSequence> r101) {
        Intrinsics.checkNotNullParameter(r100, "input");
        Intrinsics.checkNotNullParameter(r101, "transform");
        int r102 = 0;
        MatchResult r103 = find$default(this, r100, 0, 2, null);
        if (r103 == null) goto L5;
        int r104 = r100.length();
        StringBuilder r105 = new StringBuilder(r104);
    L7:
        r105.append(r100, r102, r103.getRange().getStart().intValue());
        r105.append(r101.invoke(r103));
        r102 = r103.getRange().getEndInclusive().intValue() + 1;
        r103 = r103.next();
        if (r102 >= r104) goto L10;
        if (r103 != null) goto L7;
    L10:
        if (r102 >= r104) goto L13;
        r105.append(r100, r102, r104);
    L13:
        return r105.toString();
    L5:
        return r100.toString();
    }

    public final String replaceFirst(CharSequence r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "input");
        Intrinsics.checkNotNullParameter(r101, "replacement");
        return this.nativePattern.matcher(r100).replaceFirst(r101);
    }

    public final List<String> split(CharSequence r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "input");
        StringsKt__StringsKt.requireNonNegativeLimit(r101);
        Matcher r102 = this.nativePattern.matcher(r100);
        if (r101 == 1) goto L20;
        if (r102.find() == false) goto L20;
        int r103 = 10;
        if (r101 <= 0) goto L10;
        r103 = RangesKt.coerceAtMost(r101, 10);
    L10:
        ArrayList r104 = new ArrayList(r103);
        int r105 = r101 - 1;
        int r106 = 0;
    L11:
        r104.add(r100.subSequence(r106, r102.start()).toString());
        r106 = r102.end();
        if (r105 < 0) goto L16;
        if (r104.size() != r105) goto L16;
    L17:
        r104.add(r100.subSequence(r106, r100.length()).toString());
        return r104;
    L16:
        if (r102.find() == true) goto L11;
    L20:
        return CollectionsKt.listOf(r100.toString());
    }

    public final Sequence<String> splitToSequence(CharSequence r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "input");
        StringsKt__StringsKt.requireNonNegativeLimit(r101);
        return SequencesKt.sequence(new C123671(this, r100, r101, null));
    }

    public Regex(String r100, RegexOption r101) {
        Intrinsics.checkNotNullParameter(r100, "pattern");
        Intrinsics.checkNotNullParameter(r101, "option");
        this(PatternProtector.compile(r100, Companion.access$ensureUnicodeCase(Companion, r101.getValue())));
    }

    public final String replace(CharSequence r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "input");
        Intrinsics.checkNotNullParameter(r101, "replacement");
        return this.nativePattern.matcher(r100).replaceAll(r101);
    }

    public static /* synthetic */ MatchResult find$default(Regex r100, CharSequence r101, int r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = 0;
    L6:
        return r100.find(r101, r102);
    }

    public static /* synthetic */ Sequence findAll$default(Regex r100, CharSequence r101, int r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = 0;
    L6:
        return r100.findAll(r101, r102);
    }

    public static /* synthetic */ List split$default(Regex r100, CharSequence r101, int r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = 0;
    L6:
        return r100.split(r101, r102);
    }

    public static /* synthetic */ Sequence splitToSequence$default(Regex r100, CharSequence r101, int r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = 0;
    L6:
        return r100.splitToSequence(r101, r102);
    }
}
