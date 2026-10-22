package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.input.TextFieldCharSequence;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.runtime.snapshots.StateObject;
import androidx.compose.runtime.snapshots.StateRecord;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextMeasurer;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.intl.Locale;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0001\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u00020\u0003:\u0003JKLB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J.\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020#J-\u0010$\u001a\u00020\u00022\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,¢\u0006\u0004\b-\u0010.J\u0018\u0010/\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\"\u00100\u001a\u00020\u001a2\u0017\u00101\u001a\u0013\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u001a02¢\u0006\u0002\b4H\u0082\bJ\u0010\u00107\u001a\u0002062\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J:\u00108\u001a\u00020\u00022\u0006\u00109\u001a\u00020:2\u0018\u0010;\u001a\u0014\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020>0=j\u0002`?\u0018\u00010<2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010E\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020BH\u0016J \u0010F\u001a\u00020B2\u0006\u0010G\u001a\u00020B2\u0006\u0010H\u001a\u00020B2\u0006\u0010I\u001a\u00020BH\u0016R/\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00078B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR/\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u000f8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0010\u00105\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u000203X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010A\u001a\u00020B8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bC\u0010D¨\u0006M"}, d2 = {"Landroidx/compose/foundation/text/input/internal/TextFieldLayoutStateCache;", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/text/TextLayoutResult;", "Landroidx/compose/runtime/snapshots/StateObject;", "<init>", "()V", "<set-?>", "Landroidx/compose/foundation/text/input/internal/TextFieldLayoutStateCache$NonMeasureInputs;", "nonMeasureInputs", "getNonMeasureInputs", "()Landroidx/compose/foundation/text/input/internal/TextFieldLayoutStateCache$NonMeasureInputs;", "setNonMeasureInputs", "(Landroidx/compose/foundation/text/input/internal/TextFieldLayoutStateCache$NonMeasureInputs;)V", "nonMeasureInputs$delegate", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/foundation/text/input/internal/TextFieldLayoutStateCache$MeasureInputs;", "measureInputs", "getMeasureInputs", "()Landroidx/compose/foundation/text/input/internal/TextFieldLayoutStateCache$MeasureInputs;", "setMeasureInputs", "(Landroidx/compose/foundation/text/input/internal/TextFieldLayoutStateCache$MeasureInputs;)V", "measureInputs$delegate", "value", "getValue", "()Landroidx/compose/ui/text/TextLayoutResult;", "updateNonMeasureInputs", "", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "singleLine", "", "softWrap", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "layoutWithNewMeasureInputs", "density", "Landroidx/compose/ui/unit/Density;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "layoutWithNewMeasureInputs--hBUhpc", "(Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/text/font/FontFamily$Resolver;J)Landroidx/compose/ui/text/TextLayoutResult;", "getOrComputeLayout", "updateCacheIfWritable", "block", "Lkotlin/Function1;", "Landroidx/compose/foundation/text/input/internal/TextFieldLayoutStateCache$CacheRecord;", "Lkotlin/ExtensionFunctionType;", "textMeasurer", "Landroidx/compose/ui/text/TextMeasurer;", "obtainTextMeasurer", "computeLayout", "visualText", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "annotations", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/AnnotatedString$Annotation;", "Landroidx/compose/foundation/text/input/PlacedAnnotation;", "record", "firstStateRecord", "Landroidx/compose/runtime/snapshots/StateRecord;", "getFirstStateRecord", "()Landroidx/compose/runtime/snapshots/StateRecord;", "prependStateRecord", "mergeRecords", "previous", "current", "applied", "CacheRecord", "NonMeasureInputs", "MeasureInputs", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TextFieldLayoutStateCache implements State<TextLayoutResult>, StateObject {
    public static final int $stable = 0;
    private final MutableState measureInputs$delegate;
    private final MutableState nonMeasureInputs$delegate;
    private CacheRecord record;
    private TextMeasurer textMeasurer;

    @Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010J\u001a\u00020\u0001H\u0016J\u0010\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020\u0001H\u0016J\b\u0010N\u001a\u00020OH\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR,\u0010\n\u001a\u0014\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\r0\fj\u0002`\u000e\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\"\"\u0004\b'\u0010$R\u001a\u0010(\u001a\u00020)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010+\"\u0004\b0\u0010-R\u001c\u00101\u001a\u0004\u0018\u000102X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001c\u00107\u001a\u0004\u0018\u000108X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001c\u0010=\u001a\u00020>X\u0086\u000e¢\u0006\u0010\n\u0002\u0010C\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001c\u0010D\u001a\u0004\u0018\u00010EX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010I¨\u0006P"}, d2 = {"Landroidx/compose/foundation/text/input/internal/TextFieldLayoutStateCache$CacheRecord;", "Landroidx/compose/runtime/snapshots/StateRecord;", "<init>", "()V", "visualText", "", "getVisualText", "()Ljava/lang/CharSequence;", "setVisualText", "(Ljava/lang/CharSequence;)V", "annotations", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/AnnotatedString$Annotation;", "Landroidx/compose/foundation/text/input/PlacedAnnotation;", "getAnnotations", "()Ljava/util/List;", "setAnnotations", "(Ljava/util/List;)V", "composition", "Landroidx/compose/ui/text/TextRange;", "getComposition-MzsxiRA", "()Landroidx/compose/ui/text/TextRange;", "setComposition-OEnZFl4", "(Landroidx/compose/ui/text/TextRange;)V", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "getTextStyle", "()Landroidx/compose/ui/text/TextStyle;", "setTextStyle", "(Landroidx/compose/ui/text/TextStyle;)V", "singleLine", "", "getSingleLine", "()Z", "setSingleLine", "(Z)V", "softWrap", "getSoftWrap", "setSoftWrap", "densityValue", "", "getDensityValue", "()F", "setDensityValue", "(F)V", "fontScale", "getFontScale", "setFontScale", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "getFontFamilyResolver", "()Landroidx/compose/ui/text/font/FontFamily$Resolver;", "setFontFamilyResolver", "(Landroidx/compose/ui/text/font/FontFamily$Resolver;)V", "constraints", "Landroidx/compose/ui/unit/Constraints;", "getConstraints-msEJaDk", "()J", "setConstraints-BRTryo0", "(J)V", "J", "layoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "getLayoutResult", "()Landroidx/compose/ui/text/TextLayoutResult;", "setLayoutResult", "(Landroidx/compose/ui/text/TextLayoutResult;)V", "create", "assign", "", "value", "toString", "", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class CacheRecord extends StateRecord {
        private List<AnnotatedString.Range<AnnotatedString.Annotation>> annotations;
        private TextRange composition;
        private long constraints;
        private float densityValue;
        private FontFamily.Resolver fontFamilyResolver;
        private float fontScale;
        private LayoutDirection layoutDirection;
        private TextLayoutResult layoutResult;
        private boolean singleLine;
        private boolean softWrap;
        private TextStyle textStyle;
        private CharSequence visualText;

        public StateRecord create() {
            return new CacheRecord();
        }

        public String toString() {
            return "CacheRecord(visualText=" + this.visualText + ", annotations=" + this.annotations + ", composition=" + this.composition + ", textStyle=" + this.textStyle + ", singleLine=" + this.singleLine + ", softWrap=" + this.softWrap + ", densityValue=" + this.densityValue + ", fontScale=" + this.fontScale + ", layoutDirection=" + this.layoutDirection + ", fontFamilyResolver=" + this.fontFamilyResolver + ", constraints=" + Constraints.toString-impl(this.constraints) + ", layoutResult=" + this.layoutResult + ')';
        }

        public CacheRecord() {
            this.densityValue = Float.NaN;
            this.fontScale = Float.NaN;
            this.constraints = ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null);
        }

        public final List<AnnotatedString.Range<AnnotatedString.Annotation>> getAnnotations() {
            return this.annotations;
        }

        /* JADX INFO: renamed from: getComposition-MzsxiRA, reason: not valid java name */
        public final TextRange m1652getCompositionMzsxiRA() {
            return this.composition;
        }

        /* JADX INFO: renamed from: getConstraints-msEJaDk, reason: not valid java name */
        public final long m1653getConstraintsmsEJaDk() {
            return this.constraints;
        }

        public final float getDensityValue() {
            return this.densityValue;
        }

        public final FontFamily.Resolver getFontFamilyResolver() {
            return this.fontFamilyResolver;
        }

        public final float getFontScale() {
            return this.fontScale;
        }

        public final LayoutDirection getLayoutDirection() {
            return this.layoutDirection;
        }

        public final TextLayoutResult getLayoutResult() {
            return this.layoutResult;
        }

        public final boolean getSingleLine() {
            return this.singleLine;
        }

        public final boolean getSoftWrap() {
            return this.softWrap;
        }

        public final TextStyle getTextStyle() {
            return this.textStyle;
        }

        public final CharSequence getVisualText() {
            return this.visualText;
        }

        public void assign(StateRecord r3) {
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type androidx.compose.foundation.text.input.internal.TextFieldLayoutStateCache.CacheRecord");
            CacheRecord r4 = (CacheRecord) r3;
            this.visualText = r4.visualText;
            this.annotations = r4.annotations;
            this.composition = r4.composition;
            this.textStyle = r4.textStyle;
            this.singleLine = r4.singleLine;
            this.softWrap = r4.softWrap;
            this.densityValue = r4.densityValue;
            this.fontScale = r4.fontScale;
            this.layoutDirection = r4.layoutDirection;
            this.fontFamilyResolver = r4.fontFamilyResolver;
            this.constraints = r4.constraints;
            this.layoutResult = r4.layoutResult;
        }

        public final void setAnnotations(List<AnnotatedString.Range<AnnotatedString.Annotation>> r1) {
            this.annotations = r1;
        }

        /* JADX INFO: renamed from: setComposition-OEnZFl4, reason: not valid java name */
        public final void m1654setCompositionOEnZFl4(TextRange r1) {
            this.composition = r1;
        }

        /* JADX INFO: renamed from: setConstraints-BRTryo0, reason: not valid java name */
        public final void m1655setConstraintsBRTryo0(long r1) {
            this.constraints = r1;
        }

        public final void setDensityValue(float r1) {
            this.densityValue = r1;
        }

        public final void setFontFamilyResolver(FontFamily.Resolver r1) {
            this.fontFamilyResolver = r1;
        }

        public final void setFontScale(float r1) {
            this.fontScale = r1;
        }

        public final void setLayoutDirection(LayoutDirection r1) {
            this.layoutDirection = r1;
        }

        public final void setLayoutResult(TextLayoutResult r1) {
            this.layoutResult = r1;
        }

        public final void setSingleLine(boolean r1) {
            this.singleLine = r1;
        }

        public final void setSoftWrap(boolean r1) {
            this.softWrap = r1;
        }

        public final void setTextStyle(TextStyle r1) {
            this.textStyle = r1;
        }

        public final void setVisualText(CharSequence r1) {
            this.visualText = r1;
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0002\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u00020\t¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018¨\u0006\u001e"}, d2 = {"Landroidx/compose/foundation/text/input/internal/TextFieldLayoutStateCache$MeasureInputs;", "", "density", "Landroidx/compose/ui/unit/Density;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "fontFamilyResolver", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "<init>", "(Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/text/font/FontFamily$Resolver;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getDensity", "()Landroidx/compose/ui/unit/Density;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "getFontFamilyResolver", "()Landroidx/compose/ui/text/font/FontFamily$Resolver;", "getConstraints-msEJaDk", "()J", "J", "densityValue", "", "getDensityValue", "()F", "fontScale", "getFontScale", "toString", "", "Companion", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class MeasureInputs {
        public static final Companion Companion = null;
        private static final SnapshotMutationPolicy<MeasureInputs> mutationPolicy = null;
        private final long constraints;
        private final Density density;
        private final float densityValue;
        private final FontFamily.Resolver fontFamilyResolver;
        private final float fontScale;
        private final LayoutDirection layoutDirection;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0019\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/compose/foundation/text/input/internal/TextFieldLayoutStateCache$MeasureInputs$Companion;", "", "<init>", "()V", "mutationPolicy", "Landroidx/compose/runtime/SnapshotMutationPolicy;", "Landroidx/compose/foundation/text/input/internal/TextFieldLayoutStateCache$MeasureInputs;", "getMutationPolicy", "()Landroidx/compose/runtime/SnapshotMutationPolicy;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r1) {
                this();
            }

            public final SnapshotMutationPolicy<MeasureInputs> getMutationPolicy() {
                return MeasureInputs.access$getMutationPolicy$cp();
            }
        }

        public /* synthetic */ MeasureInputs(Density r1, LayoutDirection r2, FontFamily.Resolver r3, long r4, DefaultConstructorMarker r6) {
            this(r1, r2, r3, r4);
        }

        static {
            Companion = new Companion(null);
            mutationPolicy = new TextFieldLayoutStateCache$MeasureInputs$Companion$mutationPolicy$1();
        }

        public String toString() {
            return "MeasureInputs(density=" + this.density + ", densityValue=" + this.densityValue + ", fontScale=" + this.fontScale + ", layoutDirection=" + this.layoutDirection + ", fontFamilyResolver=" + this.fontFamilyResolver + ", constraints=" + Constraints.toString-impl(this.constraints) + ')';
        }

        public static final /* synthetic */ SnapshotMutationPolicy access$getMutationPolicy$cp() {
            return mutationPolicy;
        }

        /* JADX INFO: renamed from: getConstraints-msEJaDk, reason: not valid java name */
        public final long m1656getConstraintsmsEJaDk() {
            return this.constraints;
        }

        public final Density getDensity() {
            return this.density;
        }

        public final float getDensityValue() {
            return this.densityValue;
        }

        public final FontFamily.Resolver getFontFamilyResolver() {
            return this.fontFamilyResolver;
        }

        public final float getFontScale() {
            return this.fontScale;
        }

        public final LayoutDirection getLayoutDirection() {
            return this.layoutDirection;
        }

        private MeasureInputs(Density r1, LayoutDirection r2, FontFamily.Resolver r3, long r4) {
            this.density = r1;
            this.layoutDirection = r2;
            this.fontFamilyResolver = r3;
            this.constraints = r4;
            this.densityValue = r1.getDensity();
            this.fontScale = r1.getFontScale();
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0011¨\u0006\u0016"}, d2 = {"Landroidx/compose/foundation/text/input/internal/TextFieldLayoutStateCache$NonMeasureInputs;", "", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "singleLine", "", "softWrap", "isKeyboardTypePhone", "<init>", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/ui/text/TextStyle;ZZZ)V", "getTextFieldState", "()Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "getTextStyle", "()Landroidx/compose/ui/text/TextStyle;", "getSingleLine", "()Z", "getSoftWrap", "toString", "", "Companion", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class NonMeasureInputs {
        public static final Companion Companion = null;
        private static final SnapshotMutationPolicy<NonMeasureInputs> mutationPolicy = null;
        private final boolean isKeyboardTypePhone;
        private final boolean singleLine;
        private final boolean softWrap;
        private final TransformedTextFieldState textFieldState;
        private final TextStyle textStyle;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0019\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/compose/foundation/text/input/internal/TextFieldLayoutStateCache$NonMeasureInputs$Companion;", "", "<init>", "()V", "mutationPolicy", "Landroidx/compose/runtime/SnapshotMutationPolicy;", "Landroidx/compose/foundation/text/input/internal/TextFieldLayoutStateCache$NonMeasureInputs;", "getMutationPolicy", "()Landroidx/compose/runtime/SnapshotMutationPolicy;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r1) {
                this();
            }

            public final SnapshotMutationPolicy<NonMeasureInputs> getMutationPolicy() {
                return NonMeasureInputs.access$getMutationPolicy$cp();
            }
        }

        static {
            Companion = new Companion(null);
            mutationPolicy = new TextFieldLayoutStateCache$NonMeasureInputs$Companion$mutationPolicy$1();
        }

        public String toString() {
            return "NonMeasureInputs(textFieldState=" + this.textFieldState + ", textStyle=" + this.textStyle + ", singleLine=" + this.singleLine + ", softWrap=" + this.softWrap + ", isKeyboardTypePhone=" + this.isKeyboardTypePhone + ')';
        }

        public static final /* synthetic */ SnapshotMutationPolicy access$getMutationPolicy$cp() {
            return mutationPolicy;
        }

        public final boolean getSingleLine() {
            return this.singleLine;
        }

        public final boolean getSoftWrap() {
            return this.softWrap;
        }

        public final TransformedTextFieldState getTextFieldState() {
            return this.textFieldState;
        }

        public final TextStyle getTextStyle() {
            return this.textStyle;
        }

        public final boolean isKeyboardTypePhone() {
            return this.isKeyboardTypePhone;
        }

        public NonMeasureInputs(TransformedTextFieldState r1, TextStyle r2, boolean r3, boolean r4, boolean r5) {
            this.textFieldState = r1;
            this.textStyle = r2;
            this.singleLine = r3;
            this.softWrap = r4;
            this.isKeyboardTypePhone = r5;
        }
    }

    public StateRecord mergeRecords(StateRecord r1, StateRecord r2, StateRecord r3) {
        return r3;
    }

    private final MeasureInputs getMeasureInputs() {
        return (MeasureInputs) this.measureInputs$delegate.getValue();
    }

    private final NonMeasureInputs getNonMeasureInputs() {
        return (NonMeasureInputs) this.nonMeasureInputs$delegate.getValue();
    }

    public TextFieldLayoutStateCache() {
        this.nonMeasureInputs$delegate = SnapshotStateKt.mutableStateOf(null, NonMeasureInputs.Companion.getMutationPolicy());
        this.measureInputs$delegate = SnapshotStateKt.mutableStateOf(null, MeasureInputs.Companion.getMutationPolicy());
        this.record = new CacheRecord();
    }

    public TextLayoutResult getValue() {
        NonMeasureInputs r0 = getNonMeasureInputs();
        if (r0 != null) goto L5;
        return null;
    L5:
        MeasureInputs r2 = getMeasureInputs();
        if (r2 != null) goto L9;
        return null;
    L9:
        return getOrComputeLayout(r0, r2);
    }

    public StateRecord getFirstStateRecord() {
        return this.record;
    }

    /* JADX INFO: renamed from: getValue, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1651getValue() {
        return getValue();
    }

    private final TextMeasurer obtainTextMeasurer(MeasureInputs r5) {
        TextMeasurer r0 = this.textMeasurer;
        if (r0 != null) goto L6;
        TextMeasurer r1 = new TextMeasurer(r5.getFontFamilyResolver(), r5.getDensity(), r5.getLayoutDirection(), 1);
        this.textMeasurer = r1;
        return r1;
    L6:
        return r0;
    }

    private final void setMeasureInputs(MeasureInputs r2) {
        this.measureInputs$delegate.setValue(r2);
    }

    private final void setNonMeasureInputs(NonMeasureInputs r2) {
        this.nonMeasureInputs$delegate.setValue(r2);
    }

    private final void updateCacheIfWritable(Function1<? super CacheRecord, Unit> r5) {
        Snapshot r0 = Snapshot.Companion.getCurrent();
        if (r0.getReadOnly() == true) goto L16;
        CacheRecord r1 = this.record;
        Object r2 = SnapshotKt.getLock();
        monitor-enter(r2);
        r5.invoke(SnapshotKt.writableRecord(r1, this, r0));     // Catch: Throwable -> L11
        InlineMarker.finallyStart(1);
        monitor-exit(r2);
        InlineMarker.finallyEnd(1);
        SnapshotKt.notifyWrite(r0, this);
        return;
    L11:
        th = move-exception;
        InlineMarker.finallyStart(1);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public void prependStateRecord(StateRecord r2) {
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type androidx.compose.foundation.text.input.internal.TextFieldLayoutStateCache.CacheRecord");
        this.record = (CacheRecord) r2;
    }

    private final TextLayoutResult getOrComputeLayout(NonMeasureInputs r22, MeasureInputs r23) {
        TextFieldCharSequence r0 = r22.getTextFieldState().getVisualText();
        List<AnnotatedString.Range<AnnotatedString.Annotation>> r2 = TextFieldLayoutStateCacheKt.access$mergeNullableLists(r0.getComposingAnnotations(), r0.getOutputAnnotations());
        CacheRecord r3 = (CacheRecord) SnapshotKt.current(this.record);
        TextLayoutResult r4 = r3.getLayoutResult();
        if (r4 == null) goto L50;
        CharSequence r5 = r3.getVisualText();
        boolean r6 = true;
        boolean r7 = false;
        if (r5 != null) goto L7;
    L9:
        boolean r8 = false;
    L10:
        if (r8 == false) goto L50;
        if (Intrinsics.areEqual(r3.getAnnotations(), r2) == false) goto L50;
        if (Intrinsics.areEqual(r3.m1652getCompositionMzsxiRA(), r0.m1534getCompositionMzsxiRA()) == false) goto L50;
        if (r3.getSingleLine() != r22.getSingleLine()) goto L50;
        if (r3.getSoftWrap() != r22.getSoftWrap()) goto L50;
        if (r3.getLayoutDirection() != r23.getLayoutDirection()) goto L50;
        if (r3.getDensityValue() != r23.getDensity().getDensity()) goto L24;
        boolean r9 = true;
    L25:
        if (r9 == false) goto L50;
        if (r3.getFontScale() == r23.getDensity().getFontScale()) goto L30;
        r6 = false;
    L30:
        if (r6 == false) goto L50;
        if (Constraints.equals-impl0(r3.m1653getConstraintsmsEJaDk(), r23.m1656getConstraintsmsEJaDk()) == false) goto L50;
        if (Intrinsics.areEqual(r3.getFontFamilyResolver(), r23.getFontFamilyResolver()) == false) goto L50;
        if (r4.getMultiParagraph().getIntrinsics().getHasStaleResolvedFonts() == true) goto L50;
        TextStyle r10 = r3.getTextStyle();
        if (r10 == null) goto L40;
        boolean r11 = r10.hasSameLayoutAffectingAttributes(r22.getTextStyle());
    L41:
        TextStyle r12 = r3.getTextStyle();
        if (r12 == null) goto L44;
        r7 = r12.hasSameDrawAffectingAttributes(r22.getTextStyle());
    L44:
        if (r11 == false) goto L47;
        if (r7 == false) goto L47;
        return r4;
    L47:
        if (r11 == false) goto L50;
        return TextLayoutResult.copy-O0kMr_c$default(r4, new TextLayoutInput(r4.getLayoutInput().getText(), r22.getTextStyle(), r4.getLayoutInput().getPlaceholders(), r4.getLayoutInput().getMaxLines(), r4.getLayoutInput().getSoftWrap(), r4.getLayoutInput().getOverflow-gIe3tQ8(), r4.getLayoutInput().getDensity(), r4.getLayoutInput().getLayoutDirection(), r4.getLayoutInput().getFontFamilyResolver(), r4.getLayoutInput().getConstraints-msEJaDk(), null), 0, 2, null);
    L40:
        r11 = false;
        goto L41
    L24:
        r9 = false;
        goto L25
    L7:
        if (StringsKt.contentEquals(r5, r0) != true) goto L9;
        r8 = true;
    L50:
        TextLayoutResult r13 = computeLayout(r0, r2, r22, r23);
        if (Intrinsics.areEqual(r13, r4) == true) goto L62;
        Snapshot r14 = Snapshot.Companion.getCurrent();
        if (r14.getReadOnly() == true) goto L62;
        CacheRecord r15 = this.record;
        Object r16 = SnapshotKt.getLock();
        monitor-enter(r16);
        CacheRecord r17 = (CacheRecord) SnapshotKt.writableRecord(r15, this, r14);     // Catch: Throwable -> L59
        r17.setVisualText(r0);     // Catch: Throwable -> L59
        r17.setAnnotations(r2);     // Catch: Throwable -> L59
        r17.m1654setCompositionOEnZFl4(r0.m1534getCompositionMzsxiRA());     // Catch: Throwable -> L59
        r17.setSingleLine(r22.getSingleLine());     // Catch: Throwable -> L59
        r17.setSoftWrap(r22.getSoftWrap());     // Catch: Throwable -> L59
        r17.setTextStyle(r22.getTextStyle());     // Catch: Throwable -> L59
        r17.setLayoutDirection(r23.getLayoutDirection());     // Catch: Throwable -> L59
        r17.setDensityValue(r23.getDensityValue());     // Catch: Throwable -> L59
        r17.setFontScale(r23.getFontScale());     // Catch: Throwable -> L59
        r17.m1655setConstraintsBRTryo0(r23.m1656getConstraintsmsEJaDk());     // Catch: Throwable -> L59
        r17.setFontFamilyResolver(r23.getFontFamilyResolver());     // Catch: Throwable -> L59
        r17.setLayoutResult(r13);     // Catch: Throwable -> L59
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L59
        monitor-exit(r16);
        SnapshotKt.notifyWrite(r14, this);
    L59:
        th = move-exception;
        throw th;
    L62:
        return r13;
    }

    private final TextLayoutResult computeLayout(TextFieldCharSequence r38, List<AnnotatedString.Range<AnnotatedString.Annotation>> r39, NonMeasureInputs r40, MeasureInputs r41) {
        TextMeasurer r2 = obtainTextMeasurer(r41);
        if (r40.isKeyboardTypePhone() == false) goto L10;
        LocaleList r3 = r40.getTextStyle().getLocaleList();
        if (r3 == null) goto L8;
        Locale r4 = r3.get(0);
        if (r4 == null) goto L8;
    L9:
        int r25 = TextFieldLayoutStateCache_androidKt.resolveTextDirectionForKeyboardTypePhone(r4.getPlatformLocale());
        TextStyle r5 = r40.getTextStyle().merge(new TextStyle(0, 0, null, null, null, null, null, 0, null, null, null, 0, null, null, null, 0, r25, 0, null, null, null, 0, 0, null, 16711679, null));
    L11:
        String r6 = r38.toString();
        if (r39 != null) goto L14;
        List<AnnotatedString.Range<AnnotatedString.Annotation>> r7 = CollectionsKt.emptyList();
    L15:
        AnnotatedString r8 = new AnnotatedString(r6, r7);
        boolean r9 = r40.getSoftWrap();
        if (r40.getSingleLine() == false) goto L18;
        int r10 = 1;
    L19:
        int r11 = r10;
        return TextMeasurer.measure-xDpz5zY$default(r2, r8, r5, 0, r9, r11, null, r41.m1656getConstraintsmsEJaDk(), r41.getLayoutDirection(), r41.getDensity(), r41.getFontFamilyResolver(), false, 1060, null);
    L18:
        r10 = Integer.MAX_VALUE;
        goto L19
    L14:
        r7 = r39;
    L8:
        r4 = Locale.Companion.getCurrent();
        goto L9
    L10:
        r5 = r40.getTextStyle();
        goto L11
    }

    /* JADX INFO: renamed from: layoutWithNewMeasureInputs--hBUhpc, reason: not valid java name */
    public final TextLayoutResult m1650layoutWithNewMeasureInputshBUhpc(Density r9, LayoutDirection r10, FontFamily.Resolver r11, long r12) {
        MeasureInputs r7 = new MeasureInputs(r9, r10, r11, r12, null);
        setMeasureInputs(r7);
        NonMeasureInputs r13 = getNonMeasureInputs();
        if (r13 != null) goto L5;
        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("Called layoutWithNewMeasureInputs before updateNonMeasureInputs");
        throw new KotlinNothingValueException();
    L5:
        return getOrComputeLayout(r13, r7);
    }

    public final void updateNonMeasureInputs(TransformedTextFieldState r8, TextStyle r9, boolean r10, boolean r11, KeyboardOptions r12) {
        setNonMeasureInputs(new NonMeasureInputs(r8, r9, r10, r11, KeyboardType.equals-impl0(r12.m1387getKeyboardTypePjHm6EE(), KeyboardType.Companion.getPhone-PjHm6EE())));
    }
}
