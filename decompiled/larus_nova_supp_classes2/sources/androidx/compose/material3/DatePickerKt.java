package androidx.compose.material3;

import androidx.autofill.HintConstants;
import androidx.compose.animation.AnimatedContentKt;
import androidx.compose.animation.AnimatedContentTransitionScope;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.ContentTransform;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.foundation.lazy.grid.GridCells;
import androidx.compose.foundation.lazy.grid.LazyGridDslKt;
import androidx.compose.foundation.lazy.grid.LazyGridScope;
import androidx.compose.foundation.lazy.grid.LazyGridState;
import androidx.compose.foundation.lazy.grid.LazyGridStateKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.internal.CalendarDate;
import androidx.compose.material3.internal.CalendarModel;
import androidx.compose.material3.internal.CalendarModel_androidKt;
import androidx.compose.material3.internal.CalendarMonth;
import androidx.compose.material3.internal.ProvideContentColorTextStyleKt;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.tokens.DatePickerModalTokens;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.ScrollAxisRange;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000Æ\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\u001aw\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\f2\u0015\b\u0002\u0010\r\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0002\u0010\u0012\u001aE\u0010\u0013\u001a\u00020\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001cH\u0007¢\u0006\u0004\b\u001d\u0010\u001e\u001aO\u0010\u001f\u001a\u00020\u00032\n\u0010 \u001a\u00060!j\u0002`\"2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001c¢\u0006\u0004\b#\u0010$\u001a\u0081\u0001\u0010%\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0013\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\f2\u0013\u0010\r\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\f2\u0013\u0010&\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0011\u0010+\u001a\r\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\fH\u0001¢\u0006\u0004\b,\u0010-\u001a;\u0010.\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u001a2\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u0001012\u0006\u0010\b\u001a\u00020\tH\u0001¢\u0006\u0004\b2\u00103\u001a£\u0001\u00104\u001a\u00020\u00012\b\u00105\u001a\u0004\u0018\u00010\u00152\u0006\u00106\u001a\u00020\u00152\u0006\u0010/\u001a\u00020\u001a2#\u00107\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0015¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(:\u0012\u0004\u0012\u00020\u0001012!\u0010;\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u0001012\u0006\u0010=\u001a\u00020>2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0003¢\u0006\u0004\b?\u0010@\u001a\u008d\u0001\u0010A\u001a\u00020\u00012\b\u00105\u001a\u0004\u0018\u00010\u00152\u0006\u00106\u001a\u00020\u00152!\u00107\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(:\u0012\u0004\u0012\u00020\u0001012!\u0010;\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u0001012\u0006\u0010=\u001a\u00020>2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\b\u001a\u00020\tH\u0003¢\u0006\u0002\u0010B\u001aW\u0010C\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0013\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\f2\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020E2\u0006\u0010G\u001a\u00020*2\u0011\u0010+\u001a\r\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\fH\u0001¢\u0006\u0004\bH\u0010I\u001a\u008d\u0001\u0010J\u001a\u00020\u00012\u0006\u0010K\u001a\u00020L2\b\u00105\u001a\u0004\u0018\u00010\u00152!\u00107\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(:\u0012\u0004\u0012\u00020\u0001012!\u0010;\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u0001012\u0006\u0010=\u001a\u00020>2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\b\u001a\u00020\tH\u0003¢\u0006\u0002\u0010M\u001aI\u0010N\u001a\u00020\u00012\u0006\u0010K\u001a\u00020L2!\u0010;\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\u0001012\u0006\u0010=\u001a\u00020>2\u0006\u0010\u0017\u001a\u00020\u0018H\u0080@¢\u0006\u0002\u0010O\u001a\u001d\u0010P\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010=\u001a\u00020>H\u0001¢\u0006\u0002\u0010Q\u001a\u0082\u0001\u0010R\u001a\u00020\u00012\u0006\u0010S\u001a\u00020T2!\u00107\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(:\u0012\u0004\u0012\u00020\u0001012\u0006\u0010U\u001a\u00020\u00152\b\u0010V\u001a\u0004\u0018\u00010\u00152\b\u0010W\u001a\u0004\u0018\u00010\u00152\b\u0010X\u001a\u0004\u0018\u00010Y2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\b\u001a\u00020\t2\n\u0010 \u001a\u00060!j\u0002`\"H\u0001¢\u0006\u0002\u0010Z\u001a\u0010\u0010[\u001a\u00020\\2\u0006\u0010\u0017\u001a\u00020\u0018H\u0000\u001a7\u0010]\u001a\u0004\u0018\u00010^2\u0006\u0010_\u001a\u00020\u000f2\u0006\u0010`\u001a\u00020\u000f2\u0006\u0010a\u001a\u00020\u000f2\u0006\u0010b\u001a\u00020\u000f2\u0006\u0010c\u001a\u00020\u000fH\u0003¢\u0006\u0002\u0010d\u001ac\u0010e\u001a\u00020\u00012\u0006\u0010f\u001a\u00020^2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010g\u001a\u00020\u000f2\f\u0010h\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\u0006\u0010i\u001a\u00020\u000f2\u0006\u0010j\u001a\u00020\u000f2\u0006\u0010k\u001a\u00020\u000f2\u0006\u0010l\u001a\u00020\u000f2\u0006\u0010m\u001a\u00020^2\u0006\u0010\b\u001a\u00020\tH\u0003¢\u0006\u0002\u0010n\u001a`\u0010o\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u00106\u001a\u00020\u00152!\u0010p\u001a\u001d\u0012\u0013\u0012\u00110\\¢\u0006\f\b8\u0012\b\b9\u0012\u0004\b\b(q\u0012\u0004\u0012\u00020\u0001012\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010=\u001a\u00020>2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\tH\u0003¢\u0006\u0002\u0010r\u001aS\u0010s\u001a\u00020\u00012\u0006\u0010f\u001a\u00020^2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010g\u001a\u00020\u000f2\u0006\u0010t\u001a\u00020\u000f2\f\u0010h\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\u0006\u0010j\u001a\u00020\u000f2\u0006\u0010m\u001a\u00020^2\u0006\u0010\b\u001a\u00020\tH\u0003¢\u0006\u0002\u0010u\u001ag\u0010v\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010w\u001a\u00020\u000f2\u0006\u0010x\u001a\u00020\u000f2\u0006\u0010y\u001a\u00020\u000f2\u0006\u0010z\u001a\u00020^2\f\u0010{\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\f\u0010|\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\f\u0010}\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\u0006\u0010\b\u001a\u00020\tH\u0003¢\u0006\u0002\u0010~\u001aB\u0010\u007f\u001a\u00020\u00012\f\u0010h\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\u0007\u0010\u0080\u0001\u001a\u00020\u000f2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0011\u0010+\u001a\r\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\fH\u0003¢\u0006\u0003\u0010\u0081\u0001\u001aD\u0010\u0082\u0001\u001a\u00020\u00012\f\u0010h\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\b\u0010\u0083\u0001\u001a\u00030\u0084\u00012\u0007\u0010\u0085\u0001\u001a\u00020^2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010j\u001a\u00020\u000fH\u0003¢\u0006\u0003\u0010\u0086\u0001\"\u001a\u0010\u0087\u0001\u001a\u00020*X\u0080\u0004¢\u0006\r\n\u0003\u0010\u008a\u0001\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001\"\u001a\u0010\u008b\u0001\u001a\u00020*X\u0080\u0004¢\u0006\r\n\u0003\u0010\u008a\u0001\u001a\u0006\b\u008c\u0001\u0010\u0089\u0001\"\u001a\u0010\u008d\u0001\u001a\u00020*X\u0080\u0004¢\u0006\r\n\u0003\u0010\u008a\u0001\u001a\u0006\b\u008e\u0001\u0010\u0089\u0001\"\u0018\u0010\u008f\u0001\u001a\u00030\u0090\u0001X\u0080\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0091\u0001\u0010\u0092\u0001\"\u0010\u0010\u0093\u0001\u001a\u00030\u0090\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0094\u0001\u001a\u00030\u0090\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0012\u0010\u0095\u0001\u001a\u00020*X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u008a\u0001\"\u000f\u0010\u0096\u0001\u001a\u00020\\X\u0082T¢\u0006\u0002\n\u0000\"\u000f\u0010\u0097\u0001\u001a\u00020\\X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0098\u0001²\u0006\n\u0010y\u001a\u00020\u000fX\u008a\u008e\u0002"}, d2 = {"DatePicker", "", "state", "Landroidx/compose/material3/DatePickerState;", "modifier", "Landroidx/compose/ui/Modifier;", "dateFormatter", "Landroidx/compose/material3/DatePickerFormatter;", "colors", "Landroidx/compose/material3/DatePickerColors;", "title", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "headline", "showModeToggle", "", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "(Landroidx/compose/material3/DatePickerState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/DatePickerColors;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/focus/FocusRequester;Landroidx/compose/runtime/Composer;II)V", "rememberDatePickerState", "initialSelectedDateMillis", "", "initialDisplayedMonthMillis", "yearRange", "Lkotlin/ranges/IntRange;", "initialDisplayMode", "Landroidx/compose/material3/DisplayMode;", "selectableDates", "Landroidx/compose/material3/SelectableDates;", "rememberDatePickerState-EU0dCGE", "(Ljava/lang/Long;Ljava/lang/Long;Lkotlin/ranges/IntRange;ILandroidx/compose/material3/SelectableDates;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/DatePickerState;", "DatePickerState", "locale", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "DatePickerState-sHin3Bw", "(Ljava/util/Locale;Ljava/lang/Long;Ljava/lang/Long;Lkotlin/ranges/IntRange;ILandroidx/compose/material3/SelectableDates;)Landroidx/compose/material3/DatePickerState;", "DateEntryContainer", "modeToggleButton", "headlineTextStyle", "Landroidx/compose/ui/text/TextStyle;", "headerMinHeight", "Landroidx/compose/ui/unit/Dp;", "content", "DateEntryContainer-au3_HiA", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/ui/text/TextStyle;FLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "DisplayModeToggleButton", "displayMode", "onDisplayModeChange", "Lkotlin/Function1;", "DisplayModeToggleButton-iUJLfQg", "(Landroidx/compose/ui/Modifier;ILkotlin/jvm/functions/Function1;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "SwitchableDateEntryContent", "selectedDateMillis", "displayedMonthMillis", "onDateSelectionChange", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "dateInMillis", "onDisplayedMonthChange", "monthInMillis", "calendarModel", "Landroidx/compose/material3/internal/CalendarModel;", "SwitchableDateEntryContent-KaiTk9E", "(Ljava/lang/Long;JILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/internal/CalendarModel;Lkotlin/ranges/IntRange;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/ui/focus/FocusRequester;Landroidx/compose/runtime/Composer;II)V", "DatePickerContent", "(Ljava/lang/Long;JLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/internal/CalendarModel;Lkotlin/ranges/IntRange;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "DatePickerHeader", "titleContentColor", "Landroidx/compose/ui/graphics/Color;", "headlineContentColor", "minHeight", "DatePickerHeader-pc5RIQQ", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;JJFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "HorizontalMonthsList", "lazyListState", "Landroidx/compose/foundation/lazy/LazyListState;", "(Landroidx/compose/foundation/lazy/LazyListState;Ljava/lang/Long;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/internal/CalendarModel;Lkotlin/ranges/IntRange;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "updateDisplayedMonth", "(Landroidx/compose/foundation/lazy/LazyListState;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/internal/CalendarModel;Lkotlin/ranges/IntRange;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "WeekDays", "(Landroidx/compose/material3/DatePickerColors;Landroidx/compose/material3/internal/CalendarModel;Landroidx/compose/runtime/Composer;I)V", "Month", "month", "Landroidx/compose/material3/internal/CalendarMonth;", "todayMillis", "startDateMillis", "endDateMillis", "rangeSelectionInfo", "Landroidx/compose/material3/SelectedRangeInfo;", "(Landroidx/compose/material3/internal/CalendarMonth;Lkotlin/jvm/functions/Function1;JLjava/lang/Long;Ljava/lang/Long;Landroidx/compose/material3/SelectedRangeInfo;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DatePickerColors;Ljava/util/Locale;Landroidx/compose/runtime/Composer;I)V", "numberOfMonthsInRange", "", "dayContentDescription", "", "rangeSelectionEnabled", "isToday", "isStartDate", "isEndDate", "isInRange", "(ZZZZZLandroidx/compose/runtime/Composer;I)Ljava/lang/String;", "Day", "text", "selected", "onClick", "animateChecked", "enabled", "today", "inRange", "description", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function0;ZZZZLjava/lang/String;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "YearPicker", "onYearSelected", "year", "(Landroidx/compose/ui/Modifier;JLkotlin/jvm/functions/Function1;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/internal/CalendarModel;Lkotlin/ranges/IntRange;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "Year", "currentYear", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;ZZLkotlin/jvm/functions/Function0;ZLjava/lang/String;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "MonthsNavigation", "nextAvailable", "previousAvailable", "yearPickerVisible", "yearPickerText", "onNextClicked", "onPreviousClicked", "onYearPickerButtonClicked", "(Landroidx/compose/ui/Modifier;ZZZLjava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "YearPickerMenuButton", "expanded", "(Lkotlin/jvm/functions/Function0;ZLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "IconButtonWithTooltip", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "contentDescription", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/graphics/vector/ImageVector;Ljava/lang/String;Landroidx/compose/ui/Modifier;ZLandroidx/compose/runtime/Composer;II)V", "RecommendedSizeForAccessibility", "getRecommendedSizeForAccessibility", "()F", "F", "MonthYearHeight", "getMonthYearHeight", "DatePickerHorizontalPadding", "getDatePickerHorizontalPadding", "DatePickerModeTogglePadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getDatePickerModeTogglePadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "DatePickerTitlePadding", "DatePickerHeadlinePadding", "YearsVerticalPadding", "MaxCalendarRows", "YearsInRow", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class DatePickerKt {
    private static final PaddingValues DatePickerHeadlinePadding = null;
    private static final float DatePickerHorizontalPadding = 0.0f;
    private static final PaddingValues DatePickerModeTogglePadding = null;
    private static final PaddingValues DatePickerTitlePadding = null;
    private static final int MaxCalendarRows = 6;
    private static final float MonthYearHeight = 0.0f;
    private static final float RecommendedSizeForAccessibility = 0.0f;
    private static final int YearsInRow = 3;
    private static final float YearsVerticalPadding = 0.0f;

    /* JADX INFO: renamed from: androidx.compose.material3.DatePickerKt$DatePicker$5, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class AnonymousClass5 implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ DatePickerColors $colors;
        final /* synthetic */ DatePickerState $state;

        public AnonymousClass5(DatePickerState r1, DatePickerColors r2) {
            this.$state = r1;
            this.$colors = r2;
        }

        public static /* synthetic */ Unit a(DatePickerState r0, DisplayMode r1) {
            return invoke$lambda$1$lambda$0(r0, r1);
        }

        private static final Unit invoke$lambda$1$lambda$0(DatePickerState r0, DisplayMode r1) {
            r0.mo2591setDisplayModevCnGnXg(r1.m2629unboximpl());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer r8, int r9) {
            if ((r9 & 3) == 2) goto L5;
            boolean r0 = true;
        L7:
            if (r8.shouldExecute(r0, r9 & 1) == true) goto L9;
            r8.skipToGroupEnd();
            return;
        L9:
            if (ComposerKt.isTraceInProgress() == false) goto L11;
            ComposerKt.traceEventStart(-1483431603, r9, -1, "androidx.compose.material3.DatePicker.<anonymous> (DatePicker.kt:206)");
        L11:
            Modifier r1 = PaddingKt.padding(Modifier.Companion, DatePickerKt.getDatePickerModeTogglePadding());
            int r2 = this.$state.mo2590getDisplayModejFl4v0();
            boolean r10 = r8.changed(this.$state);
            final DatePickerState r3 = this.$state;
            Object r4 = r8.rememberedValue();
            if (r10 == false) goto L14;
        L15:
            r4 = new f6(r3);
            r8.updateRememberedValue(r4);
        L16:
            DatePickerKt.m2585DisplayModeToggleButtoniUJLfQg(r1, r2, (Function1) r4, this.$colors, r8, 6);
            if (ComposerKt.isTraceInProgress() == false) goto L21;
            ComposerKt.traceEventEnd();
            return;
        L21:
            return;
        L14:
            if (r4 != Composer.Companion.getEmpty()) goto L16;
        L5:
            r0 = false;
            goto L7
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            invoke((Composer) r1, ((Number) r2).intValue());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.DatePickerKt$DatePicker$6, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class AnonymousClass6 implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ CalendarModel $calendarModel;
        final /* synthetic */ DatePickerColors $colors;
        final /* synthetic */ DatePickerFormatter $dateFormatter;
        final /* synthetic */ FocusRequester $focusRequester;
        final /* synthetic */ DatePickerState $state;

        public AnonymousClass6(DatePickerState r1, CalendarModel r2, DatePickerFormatter r3, DatePickerColors r4, FocusRequester r5) {
            this.$state = r1;
            this.$calendarModel = r2;
            this.$dateFormatter = r3;
            this.$colors = r4;
            this.$focusRequester = r5;
        }

        public static /* synthetic */ Unit a(DatePickerState r0, Long r1) {
            return invoke$lambda$1$lambda$0(r0, r1);
        }

        public static /* synthetic */ Unit b(DatePickerState r0, long r1) {
            return invoke$lambda$3$lambda$2(r0, r1);
        }

        private static final Unit invoke$lambda$1$lambda$0(DatePickerState r0, Long r1) {
            r0.setSelectedDateMillis(r1);
            return Unit.INSTANCE;
        }

        private static final Unit invoke$lambda$3$lambda$2(DatePickerState r0, long r1) {
            r0.setDisplayedMonthMillis(r1);
            return Unit.INSTANCE;
        }

        public final void invoke(Composer r17, int r18) {
            if ((r18 & 3) == 2) goto L5;
            boolean r2 = true;
        L7:
            if (r17.shouldExecute(r2, r18 & 1) == true) goto L9;
            r17.skipToGroupEnd();
            return;
        L9:
            if (ComposerKt.isTraceInProgress() == false) goto L11;
            ComposerKt.traceEventStart(-1346903698, r18, -1, "androidx.compose.material3.DatePicker.<anonymous> (DatePicker.kt:220)");
        L11:
            Long r1 = this.$state.getSelectedDateMillis();
            long r3 = this.$state.getDisplayedMonthMillis();
            int r4 = this.$state.mo2590getDisplayModejFl4v0();
            boolean r5 = r17.changed(this.$state);
            final DatePickerState r6 = this.$state;
            Object r7 = r17.rememberedValue();
            if (r5 == false) goto L14;
        L15:
            r7 = new g6(r6);
            r17.updateRememberedValue(r7);
        L16:
            Function1 r8 = (Function1) r7;
            boolean r9 = r17.changed(this.$state);
            final DatePickerState r10 = this.$state;
            Object r11 = r17.rememberedValue();
            if (r9 == false) goto L19;
        L20:
            r11 = new h6(r10);
            r17.updateRememberedValue(r11);
        L21:
            DatePickerKt.m2587access$SwitchableDateEntryContentKaiTk9E(r1, r3, r4, r8, (Function1) r11, this.$calendarModel, this.$state.getYearRange(), this.$dateFormatter, this.$state.getSelectableDates(), this.$colors, this.$focusRequester, r17, 0, 0);
            if (ComposerKt.isTraceInProgress() == false) goto L26;
            ComposerKt.traceEventEnd();
            return;
        L26:
            return;
        L19:
            if (r11 != Composer.Companion.getEmpty()) goto L21;
        L14:
            if (r7 != Composer.Companion.getEmpty()) goto L16;
        L5:
            r2 = false;
            goto L7
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            invoke((Composer) r1, ((Number) r2).intValue());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.DatePickerKt$Day$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class C02572 implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ DatePickerColors $colors;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ boolean $inRange;
        final /* synthetic */ boolean $selected;
        final /* synthetic */ String $text;
        final /* synthetic */ boolean $today;

        public C02572(String r1, DatePickerColors r2, boolean r3, boolean r4, boolean r5, boolean r6) {
            this.$text = r1;
            this.$colors = r2;
            this.$today = r3;
            this.$selected = r4;
            this.$inRange = r5;
            this.$enabled = r6;
        }

        public static /* synthetic */ Unit a(SemanticsPropertyReceiver r0) {
            return invoke$lambda$2$lambda$1$lambda$0(r0);
        }

        private static final Unit invoke$lambda$2$lambda$1$lambda$0(SemanticsPropertyReceiver r0) {
            return Unit.INSTANCE;
        }

        public final void invoke(Composer r35, int r36) {
            if ((r36 & 3) == 2) goto L5;
            boolean r2 = true;
        L7:
            if (r35.shouldExecute(r2, r36 & 1) == true) goto L9;
            r35.skipToGroupEnd();
            return;
        L9:
            if (ComposerKt.isTraceInProgress() == false) goto L11;
            ComposerKt.traceEventStart(1126347158, r36, -1, "androidx.compose.material3.Day.<anonymous> (DatePicker.kt:2032)");
        L11:
            Modifier.Companion r1 = Modifier.Companion;
            DatePickerModalTokens r3 = DatePickerModalTokens.INSTANCE;
            Modifier r4 = SizeKt.m1008requiredSizeVpY3zN4(r1, r3.getDateContainerWidth-D9Ej5fM(), r3.getDateContainerHeight-D9Ej5fM());
            Alignment r5 = Alignment.Companion.getCenter();
            String r15 = this.$text;
            DatePickerColors r6 = this.$colors;
            boolean r7 = this.$today;
            boolean r8 = this.$selected;
            boolean r10 = this.$inRange;
            boolean r11 = this.$enabled;
            MeasurePolicy r9 = BoxKt.maybeCachedBoxMeasurePolicy(r5, false);
            int r12 = ComposablesKt.getCurrentCompositeKeyHash(r35, 0);
            CompositionLocalMap r13 = r35.getCurrentCompositionLocalMap();
            Modifier r14 = ComposedModifierKt.materializeModifier(r35, r4);
            ComposeUiNode.Companion r16 = ComposeUiNode.Companion;
            Function0 r17 = r16.getConstructor();
            if ((r35.getApplier() instanceof Applier) == true) goto L14;
            ComposablesKt.invalidApplier();
        L14:
            r35.startReusableNode();
            if (r35.getInserting() == false) goto L17;
            r35.createNode(r17);
        L18:
            Composer r18 = Updater.constructor-impl(r35);
            Updater.set-impl(r18, r9, r16.getSetMeasurePolicy());
            Updater.set-impl(r18, r13, r16.getSetResolvedCompositionLocals());
            Function2 r19 = r16.getSetCompositeKeyHash();
            if (r18.getInserting() == false) goto L21;
        L22:
            r18.updateRememberedValue(Integer.valueOf(r12));
            r18.apply(Integer.valueOf(r12), r19);
        L23:
            Updater.set-impl(r18, r14, r16.getSetModifier());
            BoxScopeInstance r20 = BoxScopeInstance.INSTANCE;
            Object r21 = r35.rememberedValue();
            if (r21 != Composer.Companion.getEmpty()) goto L26;
            r21 = new k6();
            r35.updateRememberedValue(r21);
        L26:
            TextKt.m3363TextNvy7gAk(r15, SemanticsModifierKt.clearAndSetSemantics(r1, (Function1) r21), ((Color) r6.dayContentColor$material3(r7, r8, r10, r11, r35, 0).getValue()).unbox-impl(), null, 0, null, null, null, 0, null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0, 0, false, 0, 0, null, null, r35, 0, 0, 261112);
            r35.endNode();
            if (ComposerKt.isTraceInProgress() == false) goto L31;
            ComposerKt.traceEventEnd();
            return;
        L31:
            return;
        L21:
            if (Intrinsics.areEqual(r18.rememberedValue(), Integer.valueOf(r12)) == true) goto L23;
        L17:
            r35.useNode();
            goto L18
        L5:
            r2 = false;
            goto L7
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            invoke((Composer) r1, ((Number) r2).intValue());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.DatePickerKt$HorizontalMonthsList$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class AnonymousClass1 implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ CalendarModel $calendarModel;
        final /* synthetic */ DatePickerColors $colors;
        final /* synthetic */ DatePickerFormatter $dateFormatter;
        final /* synthetic */ CalendarMonth $firstMonth;
        final /* synthetic */ LazyListState $lazyListState;
        final /* synthetic */ Function1<Long, Unit> $onDateSelectionChange;
        final /* synthetic */ SelectableDates $selectableDates;
        final /* synthetic */ Long $selectedDateMillis;
        final /* synthetic */ CalendarDate $today;
        final /* synthetic */ IntRange $yearRange;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(LazyListState r1, IntRange r2, CalendarModel r3, CalendarMonth r4, Function1<? super Long, Unit> r5, CalendarDate r6, Long r7, DatePickerFormatter r8, SelectableDates r9, DatePickerColors r10) {
            this.$lazyListState = r1;
            this.$yearRange = r2;
            this.$calendarModel = r3;
            this.$firstMonth = r4;
            this.$onDateSelectionChange = r5;
            this.$today = r6;
            this.$selectedDateMillis = r7;
            this.$dateFormatter = r8;
            this.$selectableDates = r9;
            this.$colors = r10;
        }

        public static /* synthetic */ Unit a(IntRange r0, CalendarModel r1, CalendarMonth r2, Function1 r3, CalendarDate r4, Long r5, DatePickerFormatter r6, SelectableDates r7, DatePickerColors r8, LazyListScope r9) {
            return invoke$lambda$5$lambda$4(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
        }

        public static /* synthetic */ Unit b(SemanticsPropertyReceiver r0) {
            return invoke$lambda$3$lambda$2(r0);
        }

        public static /* synthetic */ float c() {
            return invoke$lambda$3$lambda$2$lambda$1();
        }

        public static /* synthetic */ float d() {
            return invoke$lambda$3$lambda$2$lambda$0();
        }

        private static final float invoke$lambda$3$lambda$2$lambda$0() {
            return MenuKt.ClosedAlphaTarget;
        }

        private static final float invoke$lambda$3$lambda$2$lambda$1() {
            return MenuKt.ClosedAlphaTarget;
        }

        private static final Unit invoke$lambda$3$lambda$2(SemanticsPropertyReceiver r7) {
            SemanticsPropertiesKt.setHorizontalScrollAxisRange(r7, new ScrollAxisRange(new p6(), new q6(), false, 4, null));
            return Unit.INSTANCE;
        }

        public final void invoke(Composer r29, int r30) {
            if ((r30 & 3) == 2) goto L5;
            boolean r2 = true;
        L7:
            if (r29.shouldExecute(r2, r30 & 1) == true) goto L9;
            r29.skipToGroupEnd();
            return;
        L9:
            if (ComposerKt.isTraceInProgress() == false) goto L11;
            ComposerKt.traceEventStart(1504086906, r30, -1, "androidx.compose.material3.HorizontalMonthsList.<anonymous> (DatePicker.kt:1721)");
        L11:
            Modifier.Companion r1 = Modifier.Companion;
            Object r3 = r29.rememberedValue();
            Composer.Companion r7 = Composer.Companion;
            if (r3 != r7.getEmpty()) goto L14;
            r3 = new n6();
            r29.updateRememberedValue(r3);
        L14:
            Modifier r8 = SemanticsModifierKt.semantics$default(r1, false, (Function1) r3, 1, null);
            LazyListState r9 = this.$lazyListState;
            FlingBehavior r15 = DatePickerDefaults.INSTANCE.rememberSnapFlingBehavior$material3(r9, null, r29, 384, 2);
            boolean r4 = (((((((r29.changedInstance(this.$yearRange) | r29.changedInstance(this.$calendarModel)) | r29.changed(this.$firstMonth)) | r29.changed(this.$onDateSelectionChange)) | r29.changed(this.$today)) | r29.changed(this.$selectedDateMillis)) | r29.changedInstance(this.$dateFormatter)) | r29.changed(this.$selectableDates)) | r29.changed(this.$colors);
            final IntRange r5 = this.$yearRange;
            final CalendarModel r6 = this.$calendarModel;
            final CalendarMonth r10 = this.$firstMonth;
            final Function1<Long, Unit> r11 = this.$onDateSelectionChange;
            final CalendarDate r12 = this.$today;
            final Long r14 = this.$selectedDateMillis;
            final DatePickerFormatter r13 = this.$dateFormatter;
            final SelectableDates r16 = this.$selectableDates;
            final DatePickerColors r17 = this.$colors;
            Object r0 = r29.rememberedValue();
            if (r4 == false) goto L17;
        L18:
            r0 = new o6(r5, r6, r10, r11, r12, r14, r13, r16, r17);
            r29.updateRememberedValue(r0);
        L19:
            LazyDslKt.LazyRow(r8, r9, null, false, null, null, r15, false, null, (Function1) r0, r29, 0, 444);
            if (ComposerKt.isTraceInProgress() == false) goto L24;
            ComposerKt.traceEventEnd();
            return;
        L24:
            return;
        L17:
            if (r0 != r7.getEmpty()) goto L19;
        L5:
            r2 = false;
            goto L7
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            invoke((Composer) r1, ((Number) r2).intValue());
            return Unit.INSTANCE;
        }

        private static final Unit invoke$lambda$5$lambda$4(IntRange r13, final CalendarModel r14, final CalendarMonth r15, final Function1 r16, final CalendarDate r17, final Long r18, final DatePickerFormatter r19, final SelectableDates r20, final DatePickerColors r21, LazyListScope r22) {
            LazyListScope.CC.items$default(r22, DatePickerKt.numberOfMonthsInRange(r13), null, null, ComposableLambdaKt.composableLambdaInstance(72599078, true, new DatePickerKt$HorizontalMonthsList$1$2$1$1(r14, r15, r16, r17, r18, r19, r20, r21)), 6, null);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.DatePickerKt$Year$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class C02602 implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ DatePickerColors $colors;
        final /* synthetic */ boolean $currentYear;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ boolean $selected;
        final /* synthetic */ String $text;

        public C02602(String r1, DatePickerColors r2, boolean r3, boolean r4, boolean r5) {
            this.$text = r1;
            this.$colors = r2;
            this.$currentYear = r3;
            this.$selected = r4;
            this.$enabled = r5;
        }

        public static /* synthetic */ Unit a(SemanticsPropertyReceiver r0) {
            return invoke$lambda$2$lambda$1$lambda$0(r0);
        }

        private static final Unit invoke$lambda$2$lambda$1$lambda$0(SemanticsPropertyReceiver r0) {
            return Unit.INSTANCE;
        }

        public final void invoke(Composer r34, int r35) {
            if ((r35 & 3) == 2) goto L5;
            boolean r2 = true;
        L7:
            if (r34.shouldExecute(r2, r35 & 1) == true) goto L9;
            r34.skipToGroupEnd();
            return;
        L9:
            if (ComposerKt.isTraceInProgress() == false) goto L11;
            ComposerKt.traceEventStart(-564400443, r35, -1, "androidx.compose.material3.Year.<anonymous> (DatePicker.kt:2157)");
        L11:
            Modifier.Companion r1 = Modifier.Companion;
            Modifier r3 = SizeKt.fillMaxWidth$default(r1, MenuKt.ClosedAlphaTarget, 1, null);
            Alignment r4 = Alignment.Companion.getCenter();
            String r15 = this.$text;
            DatePickerColors r5 = this.$colors;
            boolean r6 = this.$currentYear;
            boolean r9 = this.$selected;
            boolean r10 = this.$enabled;
            MeasurePolicy r7 = BoxKt.maybeCachedBoxMeasurePolicy(r4, false);
            int r8 = ComposablesKt.getCurrentCompositeKeyHash(r34, 0);
            CompositionLocalMap r11 = r34.getCurrentCompositionLocalMap();
            Modifier r12 = ComposedModifierKt.materializeModifier(r34, r3);
            ComposeUiNode.Companion r13 = ComposeUiNode.Companion;
            Function0 r14 = r13.getConstructor();
            if ((r34.getApplier() instanceof Applier) == true) goto L14;
            ComposablesKt.invalidApplier();
        L14:
            r34.startReusableNode();
            if (r34.getInserting() == false) goto L17;
            r34.createNode(r14);
        L18:
            Composer r16 = Updater.constructor-impl(r34);
            Updater.set-impl(r16, r7, r13.getSetMeasurePolicy());
            Updater.set-impl(r16, r11, r13.getSetResolvedCompositionLocals());
            Function2 r17 = r13.getSetCompositeKeyHash();
            if (r16.getInserting() == false) goto L21;
        L22:
            r16.updateRememberedValue(Integer.valueOf(r8));
            r16.apply(Integer.valueOf(r8), r17);
        L23:
            Updater.set-impl(r16, r12, r13.getSetModifier());
            BoxScopeInstance r18 = BoxScopeInstance.INSTANCE;
            Object r19 = r34.rememberedValue();
            if (r19 != Composer.Companion.getEmpty()) goto L26;
            r19 = new s6();
            r34.updateRememberedValue(r19);
        L26:
            TextKt.m3363TextNvy7gAk(r15, SemanticsModifierKt.clearAndSetSemantics(r1, (Function1) r19), ((Color) r5.yearContentColor$material3(r6, r9, r10, r34, 0).getValue()).unbox-impl(), null, 0, null, null, null, 0, null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0, 0, false, 0, 0, null, null, r34, 0, 0, 261112);
            r34.endNode();
            if (ComposerKt.isTraceInProgress() == false) goto L31;
            ComposerKt.traceEventEnd();
            return;
        L31:
            return;
        L21:
            if (Intrinsics.areEqual(r16.rememberedValue(), Integer.valueOf(r8)) == true) goto L23;
        L17:
            r34.useNode();
            goto L18
        L5:
            r2 = false;
            goto L7
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            invoke((Composer) r1, ((Number) r2).intValue());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.DatePickerKt$YearPicker$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class C02611 implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ CalendarModel $calendarModel;
        final /* synthetic */ DatePickerColors $colors;
        final /* synthetic */ long $displayedMonthMillis;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ Function1<Integer, Unit> $onYearSelected;
        final /* synthetic */ SelectableDates $selectableDates;
        final /* synthetic */ IntRange $yearRange;

        /* JADX WARN: Multi-variable type inference failed */
        public C02611(CalendarModel r1, long r2, IntRange r4, Modifier r5, DatePickerColors r6, Function1<? super Integer, Unit> r7, SelectableDates r8) {
            this.$calendarModel = r1;
            this.$displayedMonthMillis = r2;
            this.$yearRange = r4;
            this.$modifier = r5;
            this.$colors = r6;
            this.$onYearSelected = r7;
            this.$selectableDates = r8;
        }

        public static /* synthetic */ Unit a(IntRange r0, CalendarModel r1, int r2, int r3, Function1 r4, SelectableDates r5, DatePickerColors r6, LazyGridScope r7) {
            return invoke$lambda$1$lambda$0(r0, r1, r2, r3, r4, r5, r6, r7);
        }

        public final void invoke(Composer r23, int r24) {
            if ((r24 & 3) == 2) goto L5;
            boolean r2 = true;
        L7:
            if (r23.shouldExecute(r2, r24 & 1) == true) goto L9;
            r23.skipToGroupEnd();
            return;
        L9:
            if (ComposerKt.isTraceInProgress() == false) goto L11;
            ComposerKt.traceEventStart(1301915789, r24, -1, "androidx.compose.material3.YearPicker.<anonymous> (DatePicker.kt:2070)");
        L11:
            CalendarModel r1 = this.$calendarModel;
            final int r3 = r1.getMonth(r1.getToday()).getYear();
            final int r4 = this.$calendarModel.getMonth(this.$displayedMonthMillis).getYear();
            LazyGridState r5 = LazyGridStateKt.rememberLazyGridState(Math.max(0, (r4 - this.$yearRange.getFirst()) - 3), 0, r23, 0, 2);
            GridCells.Fixed r6 = new GridCells.Fixed(3);
            Modifier r7 = BackgroundKt.m342backgroundbw27NRU$default(this.$modifier, this.$colors.m2552getContainerColor0d7_KjU(), null, 2, null);
            Arrangement r8 = Arrangement.INSTANCE;
            Arrangement.HorizontalOrVertical r9 = r8.getSpaceEvenly();
            Arrangement.HorizontalOrVertical r10 = r8.m806spacedBy0680j_4(DatePickerKt.access$getYearsVerticalPadding$p());
            boolean r13 = (((((r23.changedInstance(this.$yearRange) | r23.changedInstance(this.$calendarModel)) | r23.changed(r4)) | r23.changed(r3)) | r23.changed(this.$onYearSelected)) | r23.changed(this.$selectableDates)) | r23.changed(this.$colors);
            final IntRange r14 = this.$yearRange;
            final CalendarModel r15 = this.$calendarModel;
            final Function1<Integer, Unit> r11 = this.$onYearSelected;
            final SelectableDates r12 = this.$selectableDates;
            final DatePickerColors r16 = this.$colors;
            Object r17 = r23.rememberedValue();
            if (r13 == false) goto L14;
        L15:
            r17 = new t6(r14, r15, r4, r3, r11, r12, r16);
            r23.updateRememberedValue(r17);
        L16:
            LazyGridDslKt.LazyVerticalGrid(r6, r7, r5, null, false, r10, r9, null, false, null, (Function1) r17, r23, 1769472, 0, 920);
            if (ComposerKt.isTraceInProgress() == false) goto L21;
            ComposerKt.traceEventEnd();
            return;
        L21:
            return;
        L14:
            if (r17 != Composer.Companion.getEmpty()) goto L16;
        L5:
            r2 = false;
            goto L7
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            invoke((Composer) r1, ((Number) r2).intValue());
            return Unit.INSTANCE;
        }

        private static final Unit invoke$lambda$1$lambda$0(IntRange r13, CalendarModel r14, int r15, int r16, Function1 r17, SelectableDates r18, DatePickerColors r19, LazyGridScope r20) {
            LazyGridScope.CC.items$default(r20, CollectionsKt.count(r13), null, null, null, ComposableLambdaKt.composableLambdaInstance(674613074, true, new DatePickerKt$YearPicker$1$1$1$1(r13, r14, r15, r16, r17, r18, r19)), 14, null);
            return Unit.INSTANCE;
        }
    }

    public static /* synthetic */ ContentTransform A(FiniteAnimationSpec r0, FiniteAnimationSpec r1, FiniteAnimationSpec r2, int r3, FiniteAnimationSpec r4, AnimatedContentTransitionScope r5) {
        return SwitchableDateEntryContent_KaiTk9E$lambda$21$lambda$20(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ Unit B(LazyListState r0, Long r1, Function1 r2, Function1 r3, CalendarModel r4, IntRange r5, DatePickerFormatter r6, SelectableDates r7, DatePickerColors r8, int r9, Composer r10, int r11) {
        return HorizontalMonthsList$lambda$42(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
    }

    public static /* synthetic */ Unit C(Pair r0, SemanticsPropertyReceiver r1) {
        return WeekDays$lambda$48$lambda$47$lambda$45$lambda$44(r0, r1);
    }

    public static /* synthetic */ Unit D(Function0 r0, boolean r1, Modifier r2, Function2 r3, int r4, int r5, Composer r6, int r7) {
        return YearPickerMenuButton$lambda$70(r0, r1, r2, r3, r4, r5, r6, r7);
    }

    private static final Unit DateEntryContainer_au3_HiA$lambda$10(Modifier r11, Function2 r12, Function2 r13, Function2 r14, DatePickerColors r15, TextStyle r16, float r17, Function2 r18, int r19, Composer r20, int r21) {
        m2581DateEntryContainerau3_HiA(r11, r12, r13, r14, r15, r16, r17, r18, r20, RecomposeScopeImplKt.updateChangedFlags(r19 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit DatePicker$lambda$3(DatePickerState r12, Modifier r13, DatePickerFormatter r14, DatePickerColors r15, Function2 r16, Function2 r17, boolean r18, FocusRequester r19, int r20, int r21, Composer r22, int r23) {
        DatePicker(r12, r13, r14, r15, r16, r17, r18, r19, r22, RecomposeScopeImplKt.updateChangedFlags(r20 | 1), r21);
        return Unit.INSTANCE;
    }

    private static final Unit DatePickerContent$lambda$37(Long r13, long r14, Function1 r16, Function1 r17, CalendarModel r18, IntRange r19, DatePickerFormatter r20, SelectableDates r21, DatePickerColors r22, int r23, Composer r24, int r25) {
        DatePickerContent(r13, r14, r16, r17, r18, r19, r20, r21, r22, r24, RecomposeScopeImplKt.updateChangedFlags(r23 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit DatePickerHeader_pc5RIQQ$lambda$39(Modifier r11, Function2 r12, long r13, long r15, float r17, Function2 r18, int r19, Composer r20, int r21) {
        m2582DatePickerHeaderpc5RIQQ(r11, r12, r13, r15, r17, r18, r20, RecomposeScopeImplKt.updateChangedFlags(r19 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit Day$lambda$62(String r13, Modifier r14, boolean r15, Function0 r16, boolean r17, boolean r18, boolean r19, boolean r20, String r21, DatePickerColors r22, int r23, Composer r24, int r25) {
        Day(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r24, RecomposeScopeImplKt.updateChangedFlags(r23 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit DisplayModeToggleButton_iUJLfQg$lambda$11(Modifier r6, int r7, Function1 r8, DatePickerColors r9, int r10, Composer r11, int r12) {
        m2585DisplayModeToggleButtoniUJLfQg(r6, r7, r8, r9, r11, RecomposeScopeImplKt.updateChangedFlags(r10 | 1));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ DatePickerStateImpl E(Long r0, Long r1, IntRange r2, int r3, SelectableDates r4, Locale r5) {
        return rememberDatePickerState_EU0dCGE$lambda$5$lambda$4(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ Unit F(Function1 r0, long r1) {
        return Month$lambda$58$lambda$57$lambda$54$lambda$53(r0, r1);
    }

    public static /* synthetic */ int G(LazyListState r0) {
        return updateDisplayedMonth$lambda$43(r0);
    }

    public static /* synthetic */ Unit H(String r0, SemanticsPropertyReceiver r1) {
        return Day$lambda$61$lambda$60(r0, r1);
    }

    private static final Unit HorizontalMonthsList$lambda$42(LazyListState r12, Long r13, Function1 r14, Function1 r15, CalendarModel r16, IntRange r17, DatePickerFormatter r18, SelectableDates r19, DatePickerColors r20, int r21, Composer r22, int r23) {
        HorizontalMonthsList(r12, r13, r14, r15, r16, r17, r18, r19, r20, r22, RecomposeScopeImplKt.updateChangedFlags(r21 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit IconButtonWithTooltip$lambda$71(Function0 r9, ImageVector r10, String r11, Modifier r12, boolean r13, int r14, int r15, Composer r16, int r17) {
        IconButtonWithTooltip(r9, r10, r11, r12, r13, r16, RecomposeScopeImplKt.updateChangedFlags(r14 | 1), r15);
        return Unit.INSTANCE;
    }

    private static final Unit Month$lambda$59(CalendarMonth r14, Function1 r15, long r16, Long r18, Long r19, SelectedRangeInfo r20, DatePickerFormatter r21, SelectableDates r22, DatePickerColors r23, Locale r24, int r25, Composer r26, int r27) {
        Month(r14, r15, r16, r18, r19, r20, r21, r22, r23, r24, r26, RecomposeScopeImplKt.updateChangedFlags(r25 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit MonthsNavigation$lambda$69(Modifier r12, boolean r13, boolean r14, boolean r15, String r16, Function0 r17, Function0 r18, Function0 r19, DatePickerColors r20, int r21, Composer r22, int r23) {
        MonthsNavigation(r12, r13, r14, r15, r16, r17, r18, r19, r20, r22, RecomposeScopeImplKt.updateChangedFlags(r21 | 1));
        return Unit.INSTANCE;
    }

    private static final int SwitchableDateEntryContent_KaiTk9E$lambda$21$lambda$20$lambda$15(int r0) {
        return r0;
    }

    private static final int SwitchableDateEntryContent_KaiTk9E$lambda$21$lambda$20$lambda$16(int r0, int r1) {
        return r0;
    }

    private static final int SwitchableDateEntryContent_KaiTk9E$lambda$21$lambda$20$lambda$17(int r0, int r1) {
        return r0;
    }

    private static final int SwitchableDateEntryContent_KaiTk9E$lambda$21$lambda$20$lambda$18(int r0) {
        return r0;
    }

    private static final FiniteAnimationSpec SwitchableDateEntryContent_KaiTk9E$lambda$21$lambda$20$lambda$19(FiniteAnimationSpec r0, IntSize r1, IntSize r2) {
        return r0;
    }

    private static final Unit SwitchableDateEntryContent_KaiTk9E$lambda$22(Long r16, long r17, int r19, Function1 r20, Function1 r21, CalendarModel r22, IntRange r23, DatePickerFormatter r24, SelectableDates r25, DatePickerColors r26, FocusRequester r27, int r28, int r29, Composer r30, int r31) {
        m2586SwitchableDateEntryContentKaiTk9E(r16, r17, r19, r20, r21, r22, r23, r24, r25, r26, r27, r30, RecomposeScopeImplKt.updateChangedFlags(r28 | 1), RecomposeScopeImplKt.updateChangedFlags(r29));
        return Unit.INSTANCE;
    }

    private static final Unit WeekDays$lambda$49(DatePickerColors r0, CalendarModel r1, int r2, Composer r3, int r4) {
        WeekDays(r0, r1, r3, RecomposeScopeImplKt.updateChangedFlags(r2 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit Year$lambda$67(String r11, Modifier r12, boolean r13, boolean r14, Function0 r15, boolean r16, String r17, DatePickerColors r18, int r19, Composer r20, int r21) {
        Year(r11, r12, r13, r14, r15, r16, r17, r18, r20, RecomposeScopeImplKt.updateChangedFlags(r19 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit YearPicker$lambda$63(Modifier r11, long r12, Function1 r14, SelectableDates r15, CalendarModel r16, IntRange r17, DatePickerColors r18, int r19, Composer r20, int r21) {
        YearPicker(r11, r12, r14, r15, r16, r17, r18, r20, RecomposeScopeImplKt.updateChangedFlags(r19 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit YearPickerMenuButton$lambda$70(Function0 r7, boolean r8, Modifier r9, Function2 r10, int r11, int r12, Composer r13, int r14) {
        YearPickerMenuButton(r7, r8, r9, r10, r13, RecomposeScopeImplKt.updateChangedFlags(r11 | 1), r12);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(DatePickerState r0, Modifier r1, DatePickerFormatter r2, DatePickerColors r3, Function2 r4, Function2 r5, boolean r6, FocusRequester r7, int r8, int r9, Composer r10, int r11) {
        return DatePicker$lambda$3(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
    }

    public static /* synthetic */ Unit b(Long r0, long r1, Function1 r3, Function1 r4, CalendarModel r5, IntRange r6, DatePickerFormatter r7, SelectableDates r8, DatePickerColors r9, int r10, Composer r11, int r12) {
        return DatePickerContent$lambda$37(r0, r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12);
    }

    public static /* synthetic */ Unit c(Function0 r0, ImageVector r1, String r2, Modifier r3, boolean r4, int r5, int r6, Composer r7, int r8) {
        return IconButtonWithTooltip$lambda$71(r0, r1, r2, r3, r4, r5, r6, r7, r8);
    }

    public static /* synthetic */ Unit d(Modifier r0, Function2 r1, Function2 r2, Function2 r3, DatePickerColors r4, TextStyle r5, float r6, Function2 r7, int r8, Composer r9, int r10) {
        return DateEntryContainer_au3_HiA$lambda$10(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }

    public static /* synthetic */ Unit e(CoroutineScope r0, LazyListState r1) {
        return DatePickerContent$lambda$36$lambda$29$lambda$28(r0, r1);
    }

    public static /* synthetic */ int f(int r0) {
        return SwitchableDateEntryContent_KaiTk9E$lambda$21$lambda$20$lambda$15(r0);
    }

    public static /* synthetic */ Unit g(Modifier r0, boolean r1, boolean r2, boolean r3, String r4, Function0 r5, Function0 r6, Function0 r7, DatePickerColors r8, int r9, Composer r10, int r11) {
        return MonthsNavigation$lambda$69(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
    }

    public static /* synthetic */ Unit h(String r0, Modifier r1, boolean r2, boolean r3, Function0 r4, boolean r5, String r6, DatePickerColors r7, int r8, Composer r9, int r10) {
        return Year$lambda$67(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }

    public static /* synthetic */ Unit i(String r0, SemanticsPropertyReceiver r1) {
        return Year$lambda$66$lambda$65(r0, r1);
    }

    public static /* synthetic */ Unit j(Modifier r0, Function2 r1, long r2, long r4, float r6, Function2 r7, int r8, Composer r9, int r10) {
        return DatePickerHeader_pc5RIQQ$lambda$39(r0, r1, r2, r4, r6, r7, r8, r9, r10);
    }

    public static /* synthetic */ int k(int r0) {
        return SwitchableDateEntryContent_KaiTk9E$lambda$21$lambda$20$lambda$18(r0);
    }

    public static /* synthetic */ int l(int r0, int r1) {
        return SwitchableDateEntryContent_KaiTk9E$lambda$21$lambda$20$lambda$16(r0, r1);
    }

    public static /* synthetic */ FiniteAnimationSpec m(FiniteAnimationSpec r0, IntSize r1, IntSize r2) {
        return SwitchableDateEntryContent_KaiTk9E$lambda$21$lambda$20$lambda$19(r0, r1, r2);
    }

    public static /* synthetic */ Unit n(CalendarMonth r0, Function1 r1, long r2, Long r4, Long r5, SelectedRangeInfo r6, DatePickerFormatter r7, SelectableDates r8, DatePickerColors r9, Locale r10, int r11, Composer r12, int r13) {
        return Month$lambda$59(r0, r1, r2, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
    }

    public static /* synthetic */ Unit o(Modifier r0, long r1, Function1 r3, SelectableDates r4, CalendarModel r5, IntRange r6, DatePickerColors r7, int r8, Composer r9, int r10) {
        return YearPicker$lambda$63(r0, r1, r3, r4, r5, r6, r7, r8, r9, r10);
    }

    public static /* synthetic */ Unit p(CoroutineScope r0, LazyListState r1) {
        return DatePickerContent$lambda$36$lambda$31$lambda$30(r0, r1);
    }

    public static /* synthetic */ Unit q(MutableState r0) {
        return DatePickerContent$lambda$36$lambda$33$lambda$32(r0);
    }

    public static /* synthetic */ Unit r(Modifier r0, int r1, Function1 r2, DatePickerColors r3, int r4, Composer r5, int r6) {
        return DisplayModeToggleButton_iUJLfQg$lambda$11(r0, r1, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ Unit s(String r0, Modifier r1, boolean r2, Function0 r3, boolean r4, boolean r5, boolean r6, boolean r7, String r8, DatePickerColors r9, int r10, Composer r11, int r12) {
        return Day$lambda$62(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12);
    }

    public static /* synthetic */ Unit t(SemanticsPropertyReceiver r0) {
        return DateEntryContainer_au3_HiA$lambda$8$lambda$7(r0);
    }

    public static /* synthetic */ Unit u(SemanticsPropertyReceiver r0) {
        return SwitchableDateEntryContent_KaiTk9E$lambda$14$lambda$13(r0);
    }

    public static /* synthetic */ Unit v(Long r0, long r1, int r3, Function1 r4, Function1 r5, CalendarModel r6, IntRange r7, DatePickerFormatter r8, SelectableDates r9, DatePickerColors r10, FocusRequester r11, int r12, int r13, Composer r14, int r15) {
        return SwitchableDateEntryContent_KaiTk9E$lambda$22(r0, r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15);
    }

    public static /* synthetic */ MutableState w() {
        return DatePickerContent$lambda$25$lambda$24();
    }

    public static /* synthetic */ int x(int r0, int r1) {
        return SwitchableDateEntryContent_KaiTk9E$lambda$21$lambda$20$lambda$17(r0, r1);
    }

    public static /* synthetic */ Unit y(SelectedRangeInfo r0, DatePickerColors r1, ContentDrawScope r2) {
        return Month$lambda$51$lambda$50(r0, r1, r2);
    }

    public static /* synthetic */ Unit z(DatePickerColors r0, CalendarModel r1, int r2, Composer r3, int r4) {
        return WeekDays$lambda$49(r0, r1, r2, r3, r4);
    }

    static {
        RecommendedSizeForAccessibility = Dp.constructor-impl(48);
        MonthYearHeight = Dp.constructor-impl(56);
        float r0 = 12;
        DatePickerHorizontalPadding = Dp.constructor-impl(r0);
        DatePickerModeTogglePadding = PaddingKt.m957PaddingValuesa9UjIt4$default(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, Dp.constructor-impl(r0), Dp.constructor-impl(r0), 3, null);
        float r1 = 24;
        float r8 = 16;
        DatePickerTitlePadding = PaddingKt.m957PaddingValuesa9UjIt4$default(Dp.constructor-impl(r1), Dp.constructor-impl(r8), Dp.constructor-impl(r0), MenuKt.ClosedAlphaTarget, 8, null);
        DatePickerHeadlinePadding = PaddingKt.m957PaddingValuesa9UjIt4$default(Dp.constructor-impl(r1), MenuKt.ClosedAlphaTarget, Dp.constructor-impl(r0), Dp.constructor-impl(r0), 2, null);
        YearsVerticalPadding = Dp.constructor-impl(r8);
    }

    private static final MutableState DatePickerContent$lambda$25$lambda$24() {
        return SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
    }

    public static final /* synthetic */ PaddingValues access$getDatePickerHeadlinePadding$p() {
        return DatePickerHeadlinePadding;
    }

    public static final /* synthetic */ PaddingValues access$getDatePickerTitlePadding$p() {
        return DatePickerTitlePadding;
    }

    public static final /* synthetic */ float access$getYearsVerticalPadding$p() {
        return YearsVerticalPadding;
    }

    public static final float getDatePickerHorizontalPadding() {
        return DatePickerHorizontalPadding;
    }

    public static final PaddingValues getDatePickerModeTogglePadding() {
        return DatePickerModeTogglePadding;
    }

    public static final float getMonthYearHeight() {
        return MonthYearHeight;
    }

    public static final float getRecommendedSizeForAccessibility() {
        return RecommendedSizeForAccessibility;
    }

    private static final Unit DateEntryContainer_au3_HiA$lambda$8$lambda$7(SemanticsPropertyReceiver r1) {
        SemanticsPropertiesKt.setContainer(r1, true);
        return Unit.INSTANCE;
    }

    private static final boolean DatePickerContent$lambda$26(MutableState<Boolean> r0) {
        return ((Boolean) r0.getValue()).booleanValue();
    }

    private static final Unit DatePickerContent$lambda$36$lambda$33$lambda$32(MutableState r1) {
        DatePickerContent$lambda$27(r1, !DatePickerContent$lambda$26(r1));
        return Unit.INSTANCE;
    }

    private static final Unit SwitchableDateEntryContent_KaiTk9E$lambda$14$lambda$13(SemanticsPropertyReceiver r1) {
        SemanticsPropertiesKt.setContainer(r1, true);
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ boolean access$DatePickerContent$lambda$26(MutableState r0) {
        return DatePickerContent$lambda$26(r0);
    }

    public static final int numberOfMonthsInRange(IntRange r1) {
        return ((r1.getLast() - r1.getFirst()) + 1) * 12;
    }

    private static final int updateDisplayedMonth$lambda$43(LazyListState r0) {
        return r0.getFirstVisibleItemIndex();
    }

    private static final void DatePickerContent$lambda$27(MutableState<Boolean> r0, boolean r1) {
        r0.setValue(Boolean.valueOf(r1));
    }

    private static final Unit DatePickerContent$lambda$36$lambda$29$lambda$28(CoroutineScope r6, LazyListState r7) {
        BuildersKt.launch$default(r6, null, null, new DatePickerKt$DatePickerContent$2$1$1$1(r7, null), 3, null);
        return Unit.INSTANCE;
    }

    private static final Unit DatePickerContent$lambda$36$lambda$31$lambda$30(CoroutineScope r6, LazyListState r7) {
        BuildersKt.launch$default(r6, null, null, new DatePickerKt$DatePickerContent$2$2$1$1(r7, null), 3, null);
        return Unit.INSTANCE;
    }

    private static final Unit Day$lambda$61$lambda$60(String r3, SemanticsPropertyReceiver r4) {
        SemanticsPropertiesKt.setText(r4, new AnnotatedString(r3, null, 2, null));
        SemanticsPropertiesKt.setRole-kuIjeqM(r4, Role.Companion.getButton-o7Vup1c());
        return Unit.INSTANCE;
    }

    private static final Unit Month$lambda$58$lambda$57$lambda$54$lambda$53(Function1 r0, long r1) {
        r0.invoke(Long.valueOf(r1));
        return Unit.INSTANCE;
    }

    private static final Unit WeekDays$lambda$48$lambda$47$lambda$45$lambda$44(Pair r0, SemanticsPropertyReceiver r1) {
        SemanticsPropertiesKt.setContentDescription(r1, (String) r0.getFirst());
        return Unit.INSTANCE;
    }

    private static final Unit Year$lambda$66$lambda$65(String r3, SemanticsPropertyReceiver r4) {
        SemanticsPropertiesKt.setText(r4, new AnnotatedString(r3, null, 2, null));
        SemanticsPropertiesKt.setRole-kuIjeqM(r4, Role.Companion.getButton-o7Vup1c());
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ void access$DatePickerContent$lambda$27(MutableState r0, boolean r1) {
        DatePickerContent$lambda$27(r0, r1);
    }

    private static final Unit Month$lambda$51$lambda$50(SelectedRangeInfo r2, DatePickerColors r3, ContentDrawScope r4) {
        DateRangePickerKt.m2605drawRangeBackgroundmxwnekA(r4, r2, r3.m2555getDayInSelectionRangeContainerColor0d7_KjU());
        r4.drawContent();
        return Unit.INSTANCE;
    }

    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r15v7 */
    public static final void WeekDays(final DatePickerColors r36, final CalendarModel r37, Composer r38, final int r39) {
        Composer r14 = r38.startRestartGroup(-1849465391);
        if ((r39 & 6) == 0) goto L5;
        int r4 = r39;
    L11:
        if ((r39 & 48) == 0) goto L13;
    L17:
        ?? r15 = 0;
        if ((r4 & 19) == 18) goto L20;
        boolean r5 = true;
    L22:
        if (r14.shouldExecute(r5, r4 & 1) == true) goto L24;
        Composer r34 = r14;
        r34.skipToGroupEnd();
    L68:
        ScopeUpdateScope r3 = r34.endRestartGroup();
        if (r3 == null) goto L77;
        r3.updateScope(new x5(r36, r37, r39));
        return;
    L77:
        return;
    L24:
        if (ComposerKt.isTraceInProgress() == false) goto L26;
        ComposerKt.traceEventStart(-1849465391, r4, -1, "androidx.compose.material3.WeekDays (DatePicker.kt:1782)");
    L26:
        int r6 = r37.getFirstDayOfWeek();
        List r7 = r37.getWeekdayNames();
        ArrayList r13 = new ArrayList();
        int r8 = r6 - 1;
        int r9 = r7.size();
        int r10 = r8;
    L27:
        if (r10 >= r9) goto L29;
        r13.add(ListProtector.get(r7, r10));
        r10 = r10 + 1;
        goto L27
    L29:
        int r11 = 0;
    L30:
        if (r11 >= r8) goto L32;
        r13.add(ListProtector.get(r7, r11));
        r11 = r11 + 1;
        goto L30
    L32:
        TextStyle r12 = TypographyKt.getValue(DatePickerModalTokens.INSTANCE.getWeekdaysLabelTextFont(), r14, 6);
        Modifier r16 = SizeKt.fillMaxWidth$default(SizeKt.m999defaultMinSizeVpY3zN4$default(Modifier.Companion, MenuKt.ClosedAlphaTarget, RecommendedSizeForAccessibility, 1, null), MenuKt.ClosedAlphaTarget, 1, null);
        MeasurePolicy r17 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getSpaceEvenly(), Alignment.Companion.getCenterVertically(), r14, 54);
        int r18 = ComposablesKt.getCurrentCompositeKeyHash(r14, 0);
        CompositionLocalMap r19 = r14.getCurrentCompositionLocalMap();
        Modifier r20 = ComposedModifierKt.materializeModifier(r14, r16);
        ComposeUiNode.Companion r21 = ComposeUiNode.Companion;
        Function0 r22 = r21.getConstructor();
        if ((r14.getApplier() instanceof Applier) == true) goto L35;
        ComposablesKt.invalidApplier();
    L35:
        r14.startReusableNode();
        if (r14.getInserting() == false) goto L38;
        r14.createNode(r22);
    L39:
        Composer r23 = Updater.constructor-impl(r14);
        Updater.set-impl(r23, r17, r21.getSetMeasurePolicy());
        Updater.set-impl(r23, r19, r21.getSetResolvedCompositionLocals());
        Function2 r24 = r21.getSetCompositeKeyHash();
        if (r23.getInserting() == false) goto L42;
    L43:
        r23.updateRememberedValue(Integer.valueOf(r18));
        r23.apply(Integer.valueOf(r18), r24);
    L44:
        Updater.set-impl(r23, r20, r21.getSetModifier());
        RowScopeInstance r25 = RowScopeInstance.INSTANCE;
        r14.startReplaceGroup(24563235);
        int r110 = r13.size();
        int r26 = 0;
    L45:
        if (r26 >= r110) goto L64;
        final Pair r27 = (Pair) ListProtector.get(r13, r26);
        Modifier.Companion r28 = Modifier.Companion;
        boolean r29 = r14.changed(r27);
        Object r30 = r14.rememberedValue();
        if (r29 == false) goto L49;
    L50:
        r30 = new w5(r27);
        r14.updateRememberedValue(r30);
    L51:
        Modifier r111 = SemanticsModifierKt.clearAndSetSemantics(r28, (Function1) r30);
        DatePickerModalTokens r31 = DatePickerModalTokens.INSTANCE;
        Modifier r32 = SizeKt.m1016sizeVpY3zN4(SizeKt.m1018sizeInqDBjuR0$default(r111, r31.getDateContainerWidth-D9Ej5fM(), r31.getDateContainerHeight-D9Ej5fM(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 12, null), ((Dp) r14.consume(InteractiveComponentSizeKt.getLocalMinimumInteractiveComponentSize())).unbox-impl(), ((Dp) r14.consume(InteractiveComponentSizeKt.getLocalMinimumInteractiveComponentSize())).unbox-impl());
        MeasurePolicy r33 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getCenter(), r15);
        int r35 = ComposablesKt.getCurrentCompositeKeyHash(r14, r15);
        CompositionLocalMap r112 = r14.getCurrentCompositionLocalMap();
        Modifier r40 = ComposedModifierKt.materializeModifier(r14, r32);
        ComposeUiNode.Companion r113 = ComposeUiNode.Companion;
        Function0 r114 = r113.getConstructor();
        if ((r14.getApplier() instanceof Applier) == true) goto L54;
        ComposablesKt.invalidApplier();
    L54:
        r14.startReusableNode();
        if (r14.getInserting() == false) goto L57;
        r14.createNode(r114);
    L58:
        Composer r115 = Updater.constructor-impl(r14);
        Updater.set-impl(r115, r33, r113.getSetMeasurePolicy());
        Updater.set-impl(r115, r112, r113.getSetResolvedCompositionLocals());
        Function2 r41 = r113.getSetCompositeKeyHash();
        if (r115.getInserting() == false) goto L61;
    L62:
        r115.updateRememberedValue(Integer.valueOf(r35));
        r115.apply(Integer.valueOf(r35), r41);
    L63:
        Updater.set-impl(r115, r40, r113.getSetModifier());
        BoxScopeInstance r42 = BoxScopeInstance.INSTANCE;
        Composer r310 = r14;
        TextKt.m3363TextNvy7gAk((String) r27.getSecond(), SizeKt.wrapContentSize$default(r28, null, false, 3, null), r36.m2574getWeekdayContentColor0d7_KjU(), null, 0, null, null, null, 0, null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0, 0, false, 0, 0, null, r12, r310, 48, 0, 130040);
        r310.endNode();
        r26 = r26 + 1;
        r110 = r110;
        r13 = r13;
        r14 = r310;
        r15 = 0;
        goto L45
    L61:
        if (Intrinsics.areEqual(r115.rememberedValue(), Integer.valueOf(r35)) == true) goto L63;
    L57:
        r14.useNode();
        goto L58
    L49:
        if (r30 != Composer.Companion.getEmpty()) goto L51;
    L64:
        r34 = r14;
        r34.endReplaceGroup();
        r34.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L68;
        ComposerKt.traceEventEnd();
        goto L68
    L42:
        if (Intrinsics.areEqual(r23.rememberedValue(), Integer.valueOf(r18)) == true) goto L44;
    L38:
        r14.useNode();
        goto L39
    L20:
        r5 = false;
        goto L22
    L13:
        if (r14.changedInstance(r37) == false) goto L15;
        int r43 = 32;
    L16:
        r4 = r4 | r43;
        goto L17
    L15:
        r43 = 16;
        goto L16
    L5:
        if (r14.changed(r36) == false) goto L7;
        int r44 = 4;
    L8:
        r4 = r44 | r39;
        goto L11
    L7:
        r44 = 2;
        goto L8
    }

    public static final Object updateDisplayedMonth(final LazyListState r2, final Function1<? super Long, Unit> r3, final CalendarModel r4, final IntRange r5, Continuation<? super Unit> r6) {
        Object r7 = SnapshotStateKt.snapshotFlow(new m5(r2)).collect(new C02633(r2, r3, r4, r5), r6);
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r7;
    L6:
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: DatePickerState-sHin3Bw, reason: not valid java name */
    public static final DatePickerState m2583DatePickerStatesHin3Bw(Locale r9, Long r10, Long r11, IntRange r12, int r13, SelectableDates r14) {
        return new DatePickerStateImpl(r10, r11, r12, r13, r14, r9, null);
    }

    /* JADX INFO: renamed from: DisplayModeToggleButton-iUJLfQg, reason: not valid java name */
    public static final void m2585DisplayModeToggleButtoniUJLfQg(final Modifier r7, final int r8, final Function1<? super DisplayMode, Unit> r9, final DatePickerColors r10, Composer r11, final int r12) {
        Composer r13 = r11.startRestartGroup(-1461252485);
        if ((r12 & 6) == 0) goto L5;
        int r1 = r12;
    L11:
        if ((r12 & 48) != 0) goto L18;
        if (r13.changed(r8) == false) goto L15;
        int r2 = 32;
    L16:
        r1 = r1 | r2;
        goto L18
    L15:
        r2 = 16;
    L18:
        if ((r12 & 384) != 0) goto L25;
        if (r13.changedInstance(r9) == false) goto L22;
        int r3 = 256;
    L23:
        r1 = r1 | r3;
        goto L25
    L22:
        r3 = 128;
    L25:
        if ((r12 & 3072) != 0) goto L32;
        if (r13.changed(r10) == false) goto L29;
        int r4 = 2048;
    L30:
        r1 = r1 | r4;
        goto L32
    L29:
        r4 = 1024;
    L32:
        if ((r1 & 1171) == 1170) goto L34;
        boolean r5 = true;
    L36:
        if (r13.shouldExecute(r5, r1 & 1) == true) goto L38;
        r13.skipToGroupEnd();
    L44:
        ScopeUpdateScope r14 = r13.endRestartGroup();
        if (r14 == null) goto L48;
        r14.updateScope(new l5(r7, r8, r9, r10, r12));
        return;
    L48:
        return;
    L38:
        if (ComposerKt.isTraceInProgress() == false) goto L40;
        ComposerKt.traceEventStart(-1461252485, r1, -1, "androidx.compose.material3.DisplayModeToggleButton (DatePicker.kt:1406)");
    L40:
        CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.box-impl(r10.m2564getHeadlineContentColor0d7_KjU())), ComposableLambdaKt.rememberComposableLambda(-1734512197, true, new DatePickerKt$DisplayModeToggleButton$1(r8, r9, r7), r13, 54), r13, ProvidedValue.$stable | 48);
        if (ComposerKt.isTraceInProgress() == false) goto L44;
        ComposerKt.traceEventEnd();
        goto L44
    L34:
        r5 = false;
        goto L36
    L5:
        if (r13.changed(r7) == false) goto L7;
        int r6 = 4;
    L8:
        r1 = r6 | r12;
        goto L11
    L7:
        r6 = 2;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final ContentTransform SwitchableDateEntryContent_KaiTk9E$lambda$21$lambda$20(FiniteAnimationSpec r4, FiniteAnimationSpec r5, FiniteAnimationSpec r6, final int r7, final FiniteAnimationSpec r8, AnimatedContentTransitionScope r9) {
        if (DisplayMode.m2626equalsimpl0(((DisplayMode) r9.getTargetState()).m2629unboximpl(), DisplayMode.Companion.m2630getInputjFl4v0()) == false) goto L5;
        ContentTransform r10 = AnimatedContentKt.togetherWith(EnterExitTransitionKt.slideInVertically(r4, new e6()).plus(EnterExitTransitionKt.fadeIn$default(r5, MenuKt.ClosedAlphaTarget, 2, null)), EnterExitTransitionKt.fadeOut$default(r6, MenuKt.ClosedAlphaTarget, 2, null).plus(EnterExitTransitionKt.slideOutVertically(r4, new y4(r7))));
    L7:
        return r9.using(r10, AnimatedContentKt.SizeTransform(true, new b5(r8)));
    L5:
        r10 = AnimatedContentKt.togetherWith(EnterExitTransitionKt.slideInVertically(r4, new z4(r7)).plus(EnterExitTransitionKt.fadeIn$default(r5, MenuKt.ClosedAlphaTarget, 2, null)), EnterExitTransitionKt.slideOutVertically(r4, new a5()).plus(EnterExitTransitionKt.fadeOut$default(r6, MenuKt.ClosedAlphaTarget, 2, null)));
        goto L7
    }

    private static final DatePickerStateImpl rememberDatePickerState_EU0dCGE$lambda$5$lambda$4(Long r9, Long r10, IntRange r11, int r12, SelectableDates r13, Locale r14) {
        return new DatePickerStateImpl(r9, r10, r11, r12, r13, r14, null);
    }

    private static final void YearPickerMenuButton(final Function0<Unit> r23, final boolean r24, Modifier r25, final Function2<? super Composer, ? super Integer, Unit> r26, Composer r27, final int r28, final int r29) {
        Composer r1 = r27.startRestartGroup(-709923073);
        if ((r29 & 1) == 0) goto L6;
        int r6 = r28 | 6;
    L14:
        if ((r29 & 2) == 0) goto L17;
        r6 = r6 | 48;
    L23:
        int r7 = r29 & 4;
        if (r7 == 0) goto L27;
        r6 = r6 | 384;
    L33:
        Modifier r8 = r25;
    L35:
        if ((r29 & 8) == 0) goto L38;
        r6 = r6 | 3072;
    L44:
        int r15 = r6;
        if ((r15 & 1171) == 1170) goto L47;
        boolean r9 = true;
    L49:
        if (r1.shouldExecute(r9, r15 & 1) == false) goto L59;
        if (r7 == 0) goto L52;
        Modifier r19 = Modifier.Companion;
    L54:
        if (ComposerKt.isTraceInProgress() == false) goto L56;
        ComposerKt.traceEventStart(-709923073, r15, -1, "androidx.compose.material3.YearPickerMenuButton (DatePicker.kt:2247)");
    L56:
        Modifier r10 = r19;
        ButtonKt.TextButton(r23, r10, false, RoundedCornerShapeKt.getCircleShape(), ButtonDefaults.INSTANCE.m2361textButtonColorsro_MJ88(0, ((Color) r1.consume(ContentColorKt.getLocalContentColor())).unbox-impl(), 0, 0, r1, 24576, 13), null, null, null, null, ComposableLambdaKt.rememberComposableLambda(1899489890, true, new C02621(r26, r24), r1, 54), r1, ((r15 & 14) | 807075840) | ((r15 >> 3) & 112), 388);
        if (ComposerKt.isTraceInProgress() == false) goto L60;
        ComposerKt.traceEventEnd();
    L60:
        ScopeUpdateScope r11 = r1.endRestartGroup();
        if (r11 == null) goto L64;
        final Modifier r3 = r19;
        r11.updateScope(new e5(r23, r24, r3, r26, r28, r29));
        return;
    L64:
        return;
    L52:
        r19 = r8;
        goto L54
    L59:
        r1.skipToGroupEnd();
        r19 = r8;
        goto L60
    L47:
        r9 = false;
        goto L49
    L38:
        if ((r28 & 3072) != 0) goto L44;
        if (r1.changedInstance(r26) == false) goto L42;
        int r12 = 2048;
    L43:
        r6 = r6 | r12;
        goto L44
    L42:
        r12 = 1024;
        goto L43
    L27:
        if ((r28 & 384) != 0) goto L33;
        r8 = r25;
        if (r1.changed(r8) == false) goto L31;
        int r13 = 256;
    L32:
        r6 = r6 | r13;
        goto L35
    L31:
        r13 = 128;
        goto L32
    L17:
        if ((r28 & 48) != 0) goto L23;
        if (r1.changed(r24) == false) goto L21;
        int r14 = 32;
    L22:
        r6 = r6 | r14;
        goto L23
    L21:
        r14 = 16;
        goto L22
    L6:
        if ((r28 & 6) == 0) goto L8;
        r6 = r28;
        goto L14
    L8:
        if (r1.changedInstance(r23) == false) goto L10;
        int r16 = 4;
    L11:
        r6 = r16 | r28;
        goto L14
    L10:
        r16 = 2;
        goto L11
    }

    private static final String dayContentDescription(boolean r3, boolean r4, boolean r5, boolean r6, boolean r7, Composer r8, int r9) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(502032503, r9, -1, "androidx.compose.material3.dayContentDescription (DatePicker.kt:1972)");
    L5:
        StringBuilder r10 = new StringBuilder();
        boolean r0 = false;
        if (r3 == false) goto L16;
        r8.startReplaceGroup(974450583);
        if (r5 == false) goto L10;
        r8.startReplaceGroup(1416909399);
        r10.append(Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(2131911747), r8, 0));
        r8.endReplaceGroup();
    L15:
        r8.endReplaceGroup();
    L18:
        if (r4 == false) goto L26;
        r8.startReplaceGroup(1416920485);
        if (r10.length() <= 0) goto L22;
        boolean r11 = true;
    L23:
        if (r11 == false) goto L25;
        r10.append(", ");
    L25:
        r10.append(Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(2131911739), r8, 0));
        r8.endReplaceGroup();
    L28:
        if (r10.length() != 0) goto L30;
        r0 = true;
    L30:
        if (r0 == false) goto L32;
        String r12 = null;
    L34:
        if (ComposerKt.isTraceInProgress() == false) goto L36;
        ComposerKt.traceEventEnd();
    L36:
        return r12;
    L32:
        r12 = r10.toString();
        goto L34
    L22:
        r11 = false;
        goto L23
    L26:
        r8.startReplaceGroup(975029291);
        r8.endReplaceGroup();
        goto L28
    L10:
        if (r6 == false) goto L12;
        r8.startReplaceGroup(1416913397);
        r10.append(Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(2131911744), r8, 0));
        r8.endReplaceGroup();
        goto L15
    L12:
        if (r7 == false) goto L14;
        r8.startReplaceGroup(1416917332);
        r10.append(Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(2131911743), r8, 0));
        r8.endReplaceGroup();
        goto L15
    L14:
        r8.startReplaceGroup(974832875);
        r8.endReplaceGroup();
        goto L15
    L16:
        r8.startReplaceGroup(974838827);
        r8.endReplaceGroup();
        goto L18
    }

    /* JADX INFO: renamed from: DatePickerHeader-pc5RIQQ, reason: not valid java name */
    public static final void m2582DatePickerHeaderpc5RIQQ(final Modifier r17, final Function2<? super Composer, ? super Integer, Unit> r18, final long r19, final long r21, final float r23, final Function2<? super Composer, ? super Integer, Unit> r24, Composer r25, final int r26) {
        Composer r3 = r25.startRestartGroup(2020490761);
        if ((r26 & 6) == 0) goto L5;
        int r4 = r26;
    L11:
        if ((r26 & 48) != 0) goto L18;
        if (r3.changedInstance(r18) == false) goto L15;
        int r5 = 32;
    L16:
        r4 = r4 | r5;
        goto L18
    L15:
        r5 = 16;
    L18:
        if ((r26 & 384) != 0) goto L26;
        if (r3.changed(r19) == false) goto L22;
        int r10 = 256;
    L23:
        r4 = r4 | r10;
        goto L26
    L22:
        r10 = 128;
    L26:
        if ((r26 & 3072) != 0) goto L33;
        if (r3.changed(r21) == false) goto L30;
        int r11 = 2048;
    L31:
        r4 = r4 | r11;
        goto L33
    L30:
        r11 = 1024;
    L33:
        if ((r26 & 24576) != 0) goto L40;
        if (r3.changed(r23) == false) goto L37;
        int r12 = 16384;
    L38:
        r4 = r4 | r12;
        goto L40
    L37:
        r12 = 8192;
    L40:
        if ((196608 & r26) != 0) goto L47;
        if (r3.changedInstance(r24) == false) goto L44;
        int r13 = 131072;
    L45:
        r4 = r4 | r13;
        goto L47
    L44:
        r13 = 65536;
    L47:
        if ((74899 & r4) == 74898) goto L49;
        boolean r14 = true;
    L51:
        if (r3.shouldExecute(r14, r4 & 1) == true) goto L53;
        r3.skipToGroupEnd();
    L79:
        ScopeUpdateScope r15 = r3.endRestartGroup();
        if (r15 == null) goto L83;
        r15.updateScope(new f5(r17, r18, r19, r21, r23, r24, r26));
        return;
    L83:
        return;
    L53:
        if (ComposerKt.isTraceInProgress() == false) goto L56;
        ComposerKt.traceEventStart(2020490761, r4, -1, "androidx.compose.material3.DatePickerHeader (DatePicker.kt:1677)");
    L56:
        if (r18 == null) goto L58;
        Modifier r16 = SizeKt.m999defaultMinSizeVpY3zN4$default(Modifier.Companion, MenuKt.ClosedAlphaTarget, r23, 1, null);
    L59:
        Modifier r0 = SizeKt.fillMaxWidth$default(r17, MenuKt.ClosedAlphaTarget, 1, null).then(r16);
        MeasurePolicy r110 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getSpaceBetween(), Alignment.Companion.getStart(), r3, 6);
        int r111 = ComposablesKt.getCurrentCompositeKeyHash(r3, 0);
        CompositionLocalMap r112 = r3.getCurrentCompositionLocalMap();
        Modifier r1 = ComposedModifierKt.materializeModifier(r3, r0);
        ComposeUiNode.Companion r113 = ComposeUiNode.Companion;
        Function0 r114 = r113.getConstructor();
        if ((r3.getApplier() instanceof Applier) == true) goto L62;
        ComposablesKt.invalidApplier();
    L62:
        r3.startReusableNode();
        if (r3.getInserting() == false) goto L65;
        r3.createNode(r114);
    L66:
        Composer r2 = Updater.constructor-impl(r3);
        Updater.set-impl(r2, r110, r113.getSetMeasurePolicy());
        Updater.set-impl(r2, r112, r113.getSetResolvedCompositionLocals());
        Function2 r115 = r113.getSetCompositeKeyHash();
        if (r2.getInserting() == false) goto L69;
    L70:
        r2.updateRememberedValue(Integer.valueOf(r111));
        r2.apply(Integer.valueOf(r111), r115);
    L71:
        Updater.set-impl(r2, r1, r113.getSetModifier());
        ColumnScopeInstance r6 = ColumnScopeInstance.INSTANCE;
        if (r18 == null) goto L74;
        r3.startReplaceGroup(396894187);
        ProvideContentColorTextStyleKt.ProvideContentColorTextStyle-3J-VO9M(r19, TypographyKt.getValue(DatePickerModalTokens.INSTANCE.getHeaderSupportingTextFont(), r3, 6), ComposableLambdaKt.rememberComposableLambda(1344395458, true, new DatePickerKt$DatePickerHeader$1$1(r18), r3, 54), r3, ((r4 >> 6) & 14) | 384);
        r3.endReplaceGroup();
    L75:
        CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.box-impl(r21)), r24, r3, ProvidedValue.$stable | ((r4 >> 12) & 112));
        r3.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L79;
        ComposerKt.traceEventEnd();
        goto L79
    L74:
        r3.startReplaceGroup(397163267);
        r3.endReplaceGroup();
        goto L75
    L69:
        if (Intrinsics.areEqual(r2.rememberedValue(), Integer.valueOf(r111)) == true) goto L71;
    L65:
        r3.useNode();
        goto L66
    L58:
        r16 = Modifier.Companion;
        goto L59
    L49:
        r14 = false;
        goto L51
    L5:
        if (r3.changed(r17) == false) goto L7;
        int r7 = 4;
    L8:
        r4 = r7 | r26;
        goto L11
    L7:
        r7 = 2;
        goto L8
    }

    /* JADX INFO: renamed from: DatePickerState-sHin3Bw$default, reason: not valid java name */
    public static /* synthetic */ DatePickerState m2584DatePickerStatesHin3Bw$default(Locale r3, Long r4, Long r5, IntRange r6, int r7, SelectableDates r8, int r9, Object r10) {
        if ((r9 & 2) == 0) goto L6;
        r4 = null;
    L6:
        if ((r9 & 4) == 0) goto L8;
        Long r11 = r4;
    L10:
        if ((r9 & 8) == 0) goto L12;
        r6 = DatePickerDefaults.INSTANCE.getYearRange();
    L12:
        IntRange r0 = r6;
        if ((r9 & 16) == 0) goto L15;
        r7 = DisplayMode.Companion.m2631getPickerjFl4v0();
    L15:
        int r1 = r7;
        if ((r9 & 32) == 0) goto L18;
        r8 = DatePickerDefaults.INSTANCE.getAllDates();
    L18:
        Long r12 = r4;
        Long r13 = r11;
        return m2583DatePickerStatesHin3Bw(r3, r12, r13, r0, r1, r8);
    L8:
        r11 = r5;
        goto L10
    }

    private static final void IconButtonWithTooltip(final Function0<Unit> r22, final ImageVector r23, final String r24, Modifier r25, boolean r26, Composer r27, final int r28, final int r29) {
        Composer r15 = r27.startRestartGroup(-368059805);
        if ((r29 & 1) == 0) goto L6;
        int r1 = r28 | 6;
    L14:
        if ((r29 & 2) == 0) goto L17;
        r1 = r1 | 48;
    L24:
        if ((r29 & 4) == 0) goto L27;
        r1 = r1 | 384;
    L33:
        int r2 = r29 & 8;
        if (r2 == 0) goto L37;
        r1 = r1 | 3072;
    L43:
        Modifier r3 = r25;
    L44:
        int r4 = r29 & 16;
        if (r4 == 0) goto L48;
        r1 = r1 | 24576;
    L54:
        boolean r8 = r26;
    L56:
        if ((r1 & 9363) == 9362) goto L58;
        boolean r9 = true;
    L60:
        if (r15.shouldExecute(r9, r1 & 1) == false) goto L74;
        if (r2 == 0) goto L63;
        Modifier r20 = Modifier.Companion;
    L64:
        if (r4 == 0) goto L66;
        boolean r21 = true;
    L68:
        if (ComposerKt.isTraceInProgress() == false) goto L70;
        ComposerKt.traceEventStart(-368059805, r1, -1, "androidx.compose.material3.IconButtonWithTooltip (DatePicker.kt:2279)");
    L70:
        final Modifier r5 = r20;
        final boolean r6 = r21;
        Composer r7 = r15;
        TooltipKt.TooltipBox(TooltipDefaults.INSTANCE.m3549rememberTooltipPositionProviderHu5FAss(TooltipAnchorPosition.Companion.m3535getAbovelOKsHw4(), MenuKt.ClosedAlphaTarget, r15, 390, 2), ComposableLambdaKt.rememberComposableLambda(-456272562, true, new C02581(r24), r15, 54), TooltipKt.rememberTooltipState(false, false, null, r15, 0, 7), null, null, false, false, false, ComposableLambdaKt.rememberComposableLambda(-1124908186, true, new C02592(r22, r5, r6, r23, r24), r15, 54), r7, 100663344, 248);
        if (ComposerKt.isTraceInProgress() == false) goto L73;
        ComposerKt.traceEventEnd();
    L73:
        final boolean r10 = r21;
    L75:
        ScopeUpdateScope r11 = r7.endRestartGroup();
        if (r11 == null) goto L79;
        final Modifier r12 = r20;
        r11.updateScope(new c5(r22, r23, r24, r12, r10, r28, r29));
        return;
    L79:
        return;
    L66:
        r21 = r8;
        goto L68
    L63:
        r20 = r3;
        goto L64
    L74:
        r7 = r15;
        r7.skipToGroupEnd();
        r20 = r3;
        r10 = r8;
        goto L75
    L58:
        r9 = false;
        goto L60
    L48:
        if ((r28 & 24576) != 0) goto L54;
        r8 = r26;
        if (r15.changed(r8) == false) goto L52;
        int r13 = 16384;
    L53:
        r1 = r1 | r13;
        goto L56
    L52:
        r13 = 8192;
        goto L53
    L37:
        if ((r28 & 3072) != 0) goto L43;
        r3 = r25;
        if (r15.changed(r3) == false) goto L41;
        int r14 = 2048;
    L42:
        r1 = r1 | r14;
        goto L44
    L41:
        r14 = 1024;
        goto L42
    L27:
        if ((r28 & 384) != 0) goto L33;
        if (r15.changed(r24) == false) goto L31;
        int r16 = 256;
    L32:
        r1 = r1 | r16;
        goto L33
    L31:
        r16 = 128;
        goto L32
    L17:
        if ((r28 & 48) != 0) goto L24;
        if (r15.changed(r23) == false) goto L21;
        int r17 = 32;
    L22:
        r1 = r1 | r17;
        goto L24
    L21:
        r17 = 16;
        goto L22
    L6:
        if ((r28 & 6) == 0) goto L8;
        r1 = r28;
        goto L14
    L8:
        if (r15.changedInstance(r22) == false) goto L10;
        int r18 = 4;
    L11:
        r1 = r18 | r28;
        goto L14
    L10:
        r18 = 2;
        goto L11
    }

    public static final /* synthetic */ void access$IconButtonWithTooltip(Function0 r0, ImageVector r1, String r2, Modifier r3, boolean r4, Composer r5, int r6, int r7) {
        IconButtonWithTooltip(r0, r1, r2, r3, r4, r5, r6, r7);
    }

    /* JADX INFO: renamed from: rememberDatePickerState-EU0dCGE, reason: not valid java name */
    public static final DatePickerState m2588rememberDatePickerStateEU0dCGE(Long r7, Long r8, IntRange r9, int r10, SelectableDates r11, Composer r12, int r13, int r14) {
        if ((r14 & 1) == 0) goto L5;
        r7 = null;
    L5:
        final Long r1 = r7;
        if ((r14 & 2) == 0) goto L8;
        final Long r2 = r1;
    L10:
        if ((r14 & 4) == 0) goto L12;
        r9 = DatePickerDefaults.INSTANCE.getYearRange();
    L12:
        final IntRange r3 = r9;
        if ((r14 & 8) == 0) goto L15;
        r10 = DisplayMode.Companion.m2631getPickerjFl4v0();
    L15:
        final int r4 = r10;
        if ((r14 & 16) == 0) goto L19;
        r11 = DatePickerDefaults.INSTANCE.getAllDates();
    L19:
        if (ComposerKt.isTraceInProgress() == false) goto L21;
        ComposerKt.traceEventStart(2065763010, r13, -1, "androidx.compose.material3.rememberDatePickerState (DatePicker.kt:373)");
    L21:
        final Locale r6 = CalendarLocale_androidKt.defaultLocale(r12, 0);
        Object[] r15 = new Object[0];
        Saver<DatePickerStateImpl, Object> r16 = DatePickerStateImpl.Companion.Saver(r11, r6);
        boolean r0 = true;
        if (((r13 & 14) ^ 6) <= 4) goto L26;
        if (r12.changed(r1) == false) goto L26;
    L27:
        boolean r17 = true;
    L30:
        if (((r13 & 112) ^ 48) <= 32) goto L34;
        if (r12.changed(r2) == false) goto L34;
    L35:
        boolean r18 = true;
    L37:
        boolean r19 = (r17 | r18) | r12.changedInstance(r3);
        if (((r13 & 7168) ^ 3072) <= 2048) goto L42;
        if (r12.changed(r4) == false) goto L42;
    L43:
        boolean r110 = true;
    L45:
        boolean r111 = r19 | r110;
        if (((57344 & r13) ^ 24576) <= 16384) goto L50;
        if (r12.changed(r11) == false) goto L50;
    L53:
        boolean r112 = (r111 | r0) | r12.changedInstance(r6);
        Object r113 = r12.rememberedValue();
        if (r112 == false) goto L56;
    L57:
        final SelectableDates r5 = r11;
        r113 = new b6(r1, r2, r3, r4, r5, r6);
        r12.updateRememberedValue(r113);
    L58:
        DatePickerStateImpl r20 = (DatePickerStateImpl) RememberSaveableKt.rememberSaveable(r15, r16, (Function0) r113, r12, 0);
        r20.setSelectableDates(r11);
        if (ComposerKt.isTraceInProgress() == false) goto L61;
        ComposerKt.traceEventEnd();
    L61:
        return r20;
    L56:
        if (r113 != Composer.Companion.getEmpty()) goto L58;
    L50:
        if ((r13 & 24576) == 16384) goto L53;
        r0 = false;
    L42:
        if ((r13 & 3072) == 2048) goto L43;
        r110 = false;
    L34:
        if ((r13 & 48) == 32) goto L35;
        r18 = false;
    L26:
        if ((r13 & 6) == 4) goto L27;
        r17 = false;
        goto L30
    L8:
        r2 = r8;
        goto L10
    }

    private static final void YearPicker(final Modifier r19, final long r20, final Function1<? super Integer, Unit> r22, final SelectableDates r23, final CalendarModel r24, final IntRange r25, final DatePickerColors r26, Composer r27, final int r28) {
        Composer r1 = r27.startRestartGroup(-1286899812);
        if ((r28 & 6) == 0) goto L5;
        int r3 = r28;
    L11:
        if ((r28 & 48) != 0) goto L19;
        if (r1.changed(r20) == false) goto L15;
        int r6 = 32;
    L16:
        r3 = r3 | r6;
        goto L19
    L15:
        r6 = 16;
    L19:
        if ((r28 & 384) != 0) goto L27;
        if (r1.changedInstance(r22) == false) goto L23;
        int r7 = 256;
    L24:
        r3 = r3 | r7;
        goto L27
    L23:
        r7 = 128;
    L27:
        if ((r28 & 3072) != 0) goto L35;
        if (r1.changed(r23) == false) goto L31;
        int r8 = 2048;
    L32:
        r3 = r3 | r8;
        goto L35
    L31:
        r8 = 1024;
    L35:
        if ((r28 & 24576) != 0) goto L43;
        if (r1.changedInstance(r24) == false) goto L39;
        int r10 = 16384;
    L40:
        r3 = r3 | r10;
        goto L43
    L39:
        r10 = 8192;
    L43:
        if ((196608 & r28) != 0) goto L50;
        if (r1.changedInstance(r25) == false) goto L47;
        int r11 = 131072;
    L48:
        r3 = r3 | r11;
        goto L50
    L47:
        r11 = 65536;
    L50:
        if ((1572864 & r28) != 0) goto L57;
        if (r1.changed(r26) == false) goto L54;
        int r12 = 1048576;
    L55:
        r3 = r3 | r12;
        goto L57
    L54:
        r12 = 524288;
    L57:
        if ((599187 & r3) == 599186) goto L59;
        boolean r13 = true;
    L61:
        if (r1.shouldExecute(r13, r3 & 1) == true) goto L63;
        r1.skipToGroupEnd();
    L69:
        ScopeUpdateScope r14 = r1.endRestartGroup();
        if (r14 == null) goto L73;
        r14.updateScope(new x4(r19, r20, r22, r23, r24, r25, r26, r28));
        return;
    L73:
        return;
    L63:
        if (ComposerKt.isTraceInProgress() == false) goto L65;
        ComposerKt.traceEventStart(-1286899812, r3, -1, "androidx.compose.material3.YearPicker (DatePicker.kt:2068)");
    L65:
        TextKt.ProvideTextStyle(TypographyKt.getValue(DatePickerModalTokens.INSTANCE.getSelectionYearLabelTextFont(), r1, 6), ComposableLambdaKt.rememberComposableLambda(1301915789, true, new C02611(r24, r20, r25, r19, r26, r22, r23), r1, 54), r1, 48);
        if (ComposerKt.isTraceInProgress() == false) goto L69;
        ComposerKt.traceEventEnd();
        goto L69
    L59:
        r13 = false;
        goto L61
    L5:
        if (r1.changed(r19) == false) goto L7;
        int r4 = 4;
    L8:
        r3 = r4 | r28;
        goto L11
    L7:
        r4 = 2;
        goto L8
    }

    public static final /* synthetic */ void access$YearPicker(Modifier r0, long r1, Function1 r3, SelectableDates r4, CalendarModel r5, IntRange r6, DatePickerColors r7, Composer r8, int r9) {
        YearPicker(r0, r1, r3, r4, r5, r6, r7, r8, r9);
    }

    /* JADX INFO: renamed from: DateEntryContainer-au3_HiA, reason: not valid java name */
    public static final void m2581DateEntryContainerau3_HiA(final Modifier r22, final Function2<? super Composer, ? super Integer, Unit> r23, final Function2<? super Composer, ? super Integer, Unit> r24, final Function2<? super Composer, ? super Integer, Unit> r25, final DatePickerColors r26, final TextStyle r27, final float r28, final Function2<? super Composer, ? super Integer, Unit> r29, Composer r30, final int r31) {
        Composer r1 = r30.startRestartGroup(1539132883);
        if ((r31 & 6) == 0) goto L5;
        int r3 = r31;
    L11:
        if ((r31 & 48) != 0) goto L19;
        if (r1.changedInstance(r23) == false) goto L15;
        int r5 = 32;
    L16:
        r3 = r3 | r5;
        goto L19
    L15:
        r5 = 16;
    L19:
        if ((r31 & 384) != 0) goto L27;
        if (r1.changedInstance(r24) == false) goto L23;
        int r6 = 256;
    L24:
        r3 = r3 | r6;
        goto L27
    L23:
        r6 = 128;
    L27:
        if ((r31 & 3072) != 0) goto L35;
        if (r1.changedInstance(r25) == false) goto L31;
        int r7 = 2048;
    L32:
        r3 = r3 | r7;
        goto L35
    L31:
        r7 = 1024;
    L35:
        if ((r31 & 24576) != 0) goto L43;
        if (r1.changed(r26) == false) goto L39;
        int r10 = 16384;
    L40:
        r3 = r3 | r10;
        goto L43
    L39:
        r10 = 8192;
    L43:
        if ((196608 & r31) != 0) goto L50;
        if (r1.changed(r27) == false) goto L47;
        int r11 = 131072;
    L48:
        r3 = r3 | r11;
        goto L50
    L47:
        r11 = 65536;
    L50:
        if ((1572864 & r31) != 0) goto L57;
        if (r1.changed(r28) == false) goto L54;
        int r12 = 1048576;
    L55:
        r3 = r3 | r12;
        goto L57
    L54:
        r12 = 524288;
    L57:
        if ((12582912 & r31) != 0) goto L64;
        if (r1.changedInstance(r29) == false) goto L61;
        int r13 = 8388608;
    L62:
        r3 = r3 | r13;
        goto L64
    L61:
        r13 = 4194304;
    L64:
        if ((4793491 & r3) == 4793490) goto L66;
        boolean r14 = true;
    L68:
        if (r1.shouldExecute(r14, r3 & 1) == true) goto L70;
        r1.skipToGroupEnd();
    L91:
        ScopeUpdateScope r15 = r1.endRestartGroup();
        if (r15 == null) goto L95;
        r15.updateScope(new o5(r22, r23, r24, r25, r26, r27, r28, r29, r31));
        return;
    L95:
        return;
    L70:
        if (ComposerKt.isTraceInProgress() == false) goto L72;
        ComposerKt.traceEventStart(1539132883, r3, -1, "androidx.compose.material3.DateEntryContainer (DatePicker.kt:1351)");
    L72:
        Modifier r16 = SizeKt.m1018sizeInqDBjuR0$default(r22, DatePickerModalTokens.INSTANCE.getContainerWidth-D9Ej5fM(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
        Object r17 = r1.rememberedValue();
        if (r17 != Composer.Companion.getEmpty()) goto L75;
        r17 = new n5();
        r1.updateRememberedValue(r17);
    L75:
        Modifier r18 = BackgroundKt.m342backgroundbw27NRU$default(SemanticsModifierKt.semantics$default(r16, false, (Function1) r17, 1, null), r26.m2552getContainerColor0d7_KjU(), null, 2, null);
        MeasurePolicy r19 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.Companion.getStart(), r1, 0);
        int r110 = ComposablesKt.getCurrentCompositeKeyHash(r1, 0);
        CompositionLocalMap r111 = r1.getCurrentCompositionLocalMap();
        Modifier r112 = ComposedModifierKt.materializeModifier(r1, r18);
        ComposeUiNode.Companion r113 = ComposeUiNode.Companion;
        Function0 r114 = r113.getConstructor();
        if ((r1.getApplier() instanceof Applier) == true) goto L78;
        ComposablesKt.invalidApplier();
    L78:
        r1.startReusableNode();
        if (r1.getInserting() == false) goto L81;
        r1.createNode(r114);
    L82:
        Composer r0 = Updater.constructor-impl(r1);
        Updater.set-impl(r0, r19, r113.getSetMeasurePolicy());
        Updater.set-impl(r0, r111, r113.getSetResolvedCompositionLocals());
        Function2 r115 = r113.getSetCompositeKeyHash();
        if (r0.getInserting() == false) goto L85;
    L86:
        r0.updateRememberedValue(Integer.valueOf(r110));
        r0.apply(Integer.valueOf(r110), r115);
    L87:
        Updater.set-impl(r0, r112, r113.getSetModifier());
        ColumnScopeInstance r2 = ColumnScopeInstance.INSTANCE;
        m2582DatePickerHeaderpc5RIQQ(Modifier.Companion, r23, r26.m2571getTitleContentColor0d7_KjU(), r26.m2564getHeadlineContentColor0d7_KjU(), r28, ComposableLambdaKt.rememberComposableLambda(-1658370654, true, new DatePickerKt$DateEntryContainer$2$1(r24, r25, r23, r26, r27), r1, 54), r1, ((r3 & 112) | 196614) | (57344 & (r3 >> 6)));
        r29.invoke(r1, Integer.valueOf((r3 >> 21) & 14));
        r1.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L91;
        ComposerKt.traceEventEnd();
        goto L91
    L85:
        if (Intrinsics.areEqual(r0.rememberedValue(), Integer.valueOf(r110)) == true) goto L87;
    L81:
        r1.useNode();
        goto L82
    L66:
        r14 = false;
        goto L68
    L5:
        if (r1.changed(r22) == false) goto L7;
        int r4 = 4;
    L8:
        r3 = r4 | r31;
        goto L11
    L7:
        r4 = 2;
        goto L8
    }

    private static final void Year(final String r27, final Modifier r28, final boolean r29, final boolean r30, final Function0<Unit> r31, final boolean r32, final String r33, final DatePickerColors r34, Composer r35, final int r36) {
        Composer r7 = r35.startRestartGroup(-1153850597);
        if ((r36 & 6) == 0) goto L5;
        int r4 = r36;
    L11:
        if ((r36 & 48) != 0) goto L18;
        if (r7.changed(r28) == false) goto L15;
        int r5 = 32;
    L16:
        r4 = r4 | r5;
        goto L18
    L15:
        r5 = 16;
    L18:
        if ((r36 & 384) != 0) goto L25;
        if (r7.changed(r29) == false) goto L22;
        int r6 = 256;
    L23:
        r4 = r4 | r6;
        goto L25
    L22:
        r6 = 128;
    L25:
        if ((r36 & 3072) != 0) goto L32;
        if (r7.changed(r30) == false) goto L29;
        int r8 = 2048;
    L30:
        r4 = r4 | r8;
        goto L32
    L29:
        r8 = 1024;
    L32:
        if ((r36 & 24576) != 0) goto L40;
        if (r7.changedInstance(r31) == false) goto L36;
        int r14 = 16384;
    L37:
        r4 = r4 | r14;
        goto L40
    L36:
        r14 = 8192;
    L40:
        if ((196608 & r36) != 0) goto L47;
        if (r7.changed(r32) == false) goto L44;
        int r15 = 131072;
    L45:
        r4 = r4 | r15;
        goto L47
    L44:
        r15 = 65536;
    L47:
        if ((1572864 & r36) != 0) goto L54;
        if (r7.changed(r33) == false) goto L51;
        int r16 = 1048576;
    L52:
        r4 = r4 | r16;
        goto L54
    L51:
        r16 = 524288;
    L54:
        if ((12582912 & r36) == 0) goto L56;
    L60:
        boolean r17 = false;
        if ((4793491 & r4) == 4793490) goto L63;
        boolean r18 = true;
    L65:
        if (r7.shouldExecute(r18, r4 & 1) == true) goto L67;
        Composer r2 = r7;
        r2.skipToGroupEnd();
    L98:
        ScopeUpdateScope r10 = r2.endRestartGroup();
        if (r10 == null) goto L102;
        r10.updateScope(new d6(r27, r28, r29, r30, r31, r32, r33, r34, r36));
        return;
    L102:
        return;
    L67:
        if (ComposerKt.isTraceInProgress() == false) goto L70;
        ComposerKt.traceEventStart(-1153850597, r4, -1, "androidx.compose.material3.Year (DatePicker.kt:2128)");
    L70:
        if ((r4 & 7168) != 2048) goto L72;
        boolean r3 = true;
    L74:
        if ((r4 & 896) != 256) goto L76;
        boolean r13 = true;
    L77:
        boolean r9 = r3 | r13;
        Object r19 = r7.rememberedValue();
        if (r9 == false) goto L80;
    L81:
        if (r30 == false) goto L84;
        if (r29 == true) goto L84;
        BorderStroke r11 = BorderStrokeKt.m369BorderStrokecXLIe8U(DatePickerModalTokens.INSTANCE.getDateTodayContainerOutlineWidth-D9Ej5fM(), r34.m2573getTodayDateBorderColor0d7_KjU());
    L85:
        r19 = r11;
        r7.updateRememberedValue(r19);
    L86:
        BorderStroke r20 = (BorderStroke) r19;
        if ((3670016 & r4) != 1048576) goto L89;
        r17 = true;
    L89:
        Object r12 = r7.rememberedValue();
        if (r17 == false) goto L92;
    L93:
        r12 = new c6(r33);
        r7.updateRememberedValue(r12);
    L94:
        Modifier r21 = SemanticsModifierKt.semantics(r28, true, (Function1) r12);
        Shape r110 = ShapesKt.getValue(DatePickerModalTokens.INSTANCE.getSelectionYearStateLayerShape(), r7, 6);
        int r22 = r4 >> 6;
        int r23 = r22 & 14;
        int r111 = (r4 >> 15) & 896;
        r2 = r7;
        SurfaceKt.m3214Surfaced85dljk(r29, r31, r21, r32, r110, ((Color) r34.yearContainerColor$material3(r29, r32, r7, r111 | (r23 | ((r4 >> 12) & 112))).getValue()).unbox-impl(), 0, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, r20, null, ComposableLambdaKt.rememberComposableLambda(-564400443, true, new C02602(r27, r34, r30, r29, r32), r2, 54), r2, (r23 | ((r4 >> 9) & 112)) | (r22 & 7168), 48, 1472);
        if (ComposerKt.isTraceInProgress() == false) goto L98;
        ComposerKt.traceEventEnd();
        goto L98
    L92:
        if (r12 != Composer.Companion.getEmpty()) goto L94;
    L84:
        r11 = null;
        goto L85
    L80:
        if (r19 != Composer.Companion.getEmpty()) goto L86;
    L76:
        r13 = false;
        goto L77
    L72:
        r3 = false;
        goto L74
    L63:
        r18 = false;
        goto L65
    L56:
        if (r7.changed(r34) == false) goto L58;
        int r112 = 8388608;
    L59:
        r4 = r4 | r112;
        goto L60
    L58:
        r112 = 4194304;
        goto L59
    L5:
        if (r7.changed(r27) == false) goto L7;
        int r24 = 4;
    L8:
        r4 = r24 | r36;
        goto L11
    L7:
        r24 = 2;
        goto L8
    }

    public static final /* synthetic */ void access$Year(String r0, Modifier r1, boolean r2, boolean r3, Function0 r4, boolean r5, String r6, DatePickerColors r7, Composer r8, int r9) {
        Year(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void DatePicker(final DatePickerState r26, Modifier r27, DatePickerFormatter r28, DatePickerColors r29, Function2<? super Composer, ? super Integer, Unit> r30, Function2<? super Composer, ? super Integer, Unit> r31, boolean r32, FocusRequester r33, Composer r34, final int r35, final int r36) {
        Composer r3 = r34.startRestartGroup(1105472031);
        if ((r36 & 1) == 0) goto L6;
        int r4 = r35 | 6;
    L13:
        int r5 = r36 & 2;
        if (r5 == 0) goto L17;
        r4 = r4 | 48;
    L25:
        if ((r35 & 384) != 0) goto L37;
        if ((r36 & 4) == 0) goto L29;
    L34:
        int r7 = 128;
    L35:
        r4 = r4 | r7;
        goto L37
    L29:
        if ((r35 & 512) != 0) goto L31;
        boolean r8 = r3.changed(r28);
    L32:
        if (r8 == false) goto L34;
        r7 = 256;
        goto L35
    L31:
        r8 = r3.changedInstance(r28);
    L37:
        if ((r35 & 3072) != 0) goto L47;
        if ((r36 & 8) != 0) goto L44;
        if (r3.changed(r29) == false) goto L44;
        int r9 = 2048;
    L45:
        r4 = r4 | r9;
    L44:
        r9 = 1024;
    L47:
        int r10 = r36 & 16;
        if (r10 == 0) goto L51;
        r4 = r4 | 24576;
    L57:
        Function2<? super Composer, ? super Integer, Unit> r11 = r30;
    L58:
        int r12 = r36 & 32;
        if (r12 == 0) goto L62;
        r4 = r4 | 196608;
    L68:
        Function2<? super Composer, ? super Integer, Unit> r13 = r31;
    L69:
        int r14 = r36 & 64;
        if (r14 == 0) goto L73;
        r4 = r4 | 1572864;
    L79:
        boolean r15 = r32;
    L80:
        int r2 = r36 & 128;
        if (r2 == 0) goto L84;
        r4 = r4 | 12582912;
    L91:
        if ((r4 & 4793491) == 4793490) goto L93;
        boolean r0 = true;
    L95:
        if (r3.shouldExecute(r0, r4 & 1) == false) goto L157;
        r3.startDefaults();
        if ((r35 & 1) != 0) goto L99;
    L109:
        if (r5 == 0) goto L111;
        Modifier r1 = Modifier.Companion;
    L113:
        if ((r36 & 4) == 0) goto L118;
        Object r6 = r3.rememberedValue();
        if (r6 != Composer.Companion.getEmpty()) goto L117;
        r6 = DatePickerDefaults.dateFormatter$default(DatePickerDefaults.INSTANCE, null, null, null, 7, null);
        r3.updateRememberedValue(r6);
    L117:
        final DatePickerFormatter r16 = (DatePickerFormatter) r6;
        r4 = r4 & (-897);
    L120:
        if ((r36 & 8) == 0) goto L122;
        final DatePickerColors r17 = DatePickerDefaults.INSTANCE.colors(r3, 6);
        r4 = r4 & (-7169);
    L123:
        if (r10 == 0) goto L125;
        boolean r18 = true;
        int r19 = 54;
        Function2<? super Composer, ? super Integer, Unit> r20 = ComposableLambdaKt.rememberComposableLambda(1655706771, true, new AnonymousClass2(r26, r17), r3, 54);
    L126:
        if (r12 == 0) goto L128;
        Function2<? super Composer, ? super Integer, Unit> r110 = ComposableLambdaKt.rememberComposableLambda(1439279037, r18, new AnonymousClass3(r26, r16, r17), r3, r19);
    L129:
        if (r14 == 0) goto L131;
        r15 = true;
    L131:
        if (r2 == 0) goto L136;
        Object r21 = r3.rememberedValue();
        if (r21 != Composer.Companion.getEmpty()) goto L135;
        r21 = new FocusRequester();
        r3.updateRememberedValue(r21);
    L135:
        FocusRequester r22 = (FocusRequester) r21;
        Function2<? super Composer, ? super Integer, Unit> r23 = r110;
        Modifier r24 = r1;
    L108:
        int r111 = r4;
        boolean r25 = r15;
        r3.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L140;
        ComposerKt.traceEventStart(1105472031, r111, -1, "androidx.compose.material3.DatePicker (DatePicker.kt:190)");
    L140:
        boolean r112 = r3.changed(r26.getLocale());
        Object r113 = r3.rememberedValue();
        if (r112 == true) goto L145;
        if (r113 == Composer.Companion.getEmpty()) goto L145;
    L149:
        CalendarModel r114 = (CalendarModel) r113;
        if (r25 == false) goto L152;
        r3.startReplaceGroup(-690551113);
        Function2 r115 = ComposableLambdaKt.rememberComposableLambda(-1483431603, true, new AnonymousClass5(r26, r17), r3, 54);
        r3.endReplaceGroup();
        Function2 r116 = r115;
    L153:
        DatePickerModalTokens r37 = DatePickerModalTokens.INSTANCE;
        TextStyle r117 = TypographyKt.getValue(r37.getHeaderHeadlineFont(), r3, 6);
        float r118 = r37.getHeaderContainerHeight-D9Ej5fM();
        ComposableLambda r119 = ComposableLambdaKt.rememberComposableLambda(-1346903698, true, new AnonymousClass6(r26, r114, r16, r17, r22), r3, 54);
        int r120 = r111 >> 9;
        m2581DateEntryContainerau3_HiA(r24, r20, r23, r116, r17, r117, r118, r119, r3, (((((r111 >> 3) & 14) | 14155776) | (r120 & 112)) | (r120 & 896)) | ((r111 << 3) & 57344));
        if (ComposerKt.isTraceInProgress() == false) goto L156;
        ComposerKt.traceEventEnd();
    L156:
        FocusRequester r121 = r22;
        final Function2<? super Composer, ? super Integer, Unit> r38 = r23;
        final Modifier r39 = r24;
        DatePickerColors r210 = r17;
        final boolean r40 = r25;
        final DatePickerColors r41 = r210;
    L158:
        ScopeUpdateScope r122 = r3.endRestartGroup();
        if (r122 == null) goto L162;
        final DatePickerFormatter r42 = r16;
        final Function2<? super Composer, ? super Integer, Unit> r43 = r20;
        final FocusRequester r44 = r121;
        r122.updateScope(new k5(r26, r39, r42, r41, r43, r38, r40, r44, r35, r36));
        return;
    L162:
        return;
    L152:
        r3.startReplaceGroup(-690163489);
        r3.endReplaceGroup();
        r116 = null;
    L145:
        if ((r26 instanceof BaseDatePickerStateImpl) == false) goto L147;
        CalendarModel r123 = ((BaseDatePickerStateImpl) r26).getCalendarModel();
    L148:
        r113 = r123;
        r3.updateRememberedValue(r113);
        goto L149
    L147:
        r123 = CalendarModel_androidKt.createCalendarModel(r26.getLocale());
        goto L148
    L136:
        r24 = r1;
        r22 = r33;
        r23 = r110;
        goto L108
    L128:
        r110 = r13;
        goto L129
    L125:
        r18 = true;
        r19 = 54;
        r20 = r11;
        goto L126
    L122:
        r17 = r29;
        goto L123
    L118:
        r16 = r28;
        goto L120
    L111:
        r1 = r27;
        goto L113
    L99:
        if (r3.getDefaultsInvalid() == true) goto L109;
        r3.skipToGroupEnd();
        if ((r36 & 4) == 0) goto L105;
        r4 = r4 & (-897);
    L105:
        if ((r36 & 8) == 0) goto L107;
        r4 = r4 & (-7169);
    L107:
        r24 = r27;
        r16 = r28;
        r17 = r29;
        r22 = r33;
        r20 = r11;
        r23 = r13;
        goto L108
    L157:
        r3.skipToGroupEnd();
        r39 = r27;
        r16 = r28;
        r41 = r29;
        r20 = r11;
        r38 = r13;
        r40 = r15;
        r121 = r33;
        goto L158
    L93:
        r0 = false;
        goto L95
    L84:
        if ((r35 & 12582912) != 0) goto L91;
        if (r3.changed(r33) == false) goto L88;
        int r124 = 8388608;
    L89:
        r4 = r4 | r124;
        goto L91
    L88:
        r124 = 4194304;
        goto L89
    L73:
        if ((1572864 & r35) != 0) goto L79;
        r15 = r32;
        if (r3.changed(r15) == false) goto L77;
        int r125 = 1048576;
    L78:
        r4 = r4 | r125;
        goto L80
    L77:
        r125 = 524288;
        goto L78
    L62:
        if ((196608 & r35) != 0) goto L68;
        r13 = r31;
        if (r3.changedInstance(r13) == false) goto L66;
        int r126 = 131072;
    L67:
        r4 = r4 | r126;
        goto L69
    L66:
        r126 = 65536;
        goto L67
    L51:
        if ((r35 & 24576) != 0) goto L57;
        r11 = r30;
        if (r3.changedInstance(r11) == false) goto L55;
        int r127 = 16384;
    L56:
        r4 = r4 | r127;
        goto L58
    L55:
        r127 = 8192;
        goto L56
    L17:
        if ((r35 & 48) != 0) goto L25;
        if (r3.changed(r27) == false) goto L21;
        int r45 = 32;
    L22:
        r4 = r4 | r45;
        goto L25
    L21:
        r45 = 16;
        goto L22
    L6:
        if ((r35 & 6) == 0) goto L8;
        r4 = r35;
        goto L13
    L8:
        if (r3.changed(r26) == false) goto L10;
        int r46 = 4;
    L11:
        r4 = r46 | r35;
        goto L13
    L10:
        r46 = 2;
        goto L11
    }

    private static final void DatePickerContent(final Long r28, final long r29, final Function1<? super Long, Unit> r31, final Function1<? super Long, Unit> r32, final CalendarModel r33, final IntRange r34, final DatePickerFormatter r35, final SelectableDates r36, final DatePickerColors r37, Composer r38, final int r39) {
        Composer r8 = r38.startRestartGroup(-434467002);
        if ((r39 & 6) == 0) goto L5;
        int r1 = r39;
    L11:
        if ((r39 & 48) != 0) goto L18;
        if (r8.changed(r29) == false) goto L15;
        int r2 = 32;
    L16:
        r1 = r1 | r2;
        goto L18
    L15:
        r2 = 16;
    L18:
        if ((r39 & 384) != 0) goto L25;
        if (r8.changedInstance(r31) == false) goto L22;
        int r3 = 256;
    L23:
        r1 = r1 | r3;
        goto L25
    L22:
        r3 = 128;
    L25:
        if ((r39 & 3072) != 0) goto L32;
        if (r8.changedInstance(r32) == false) goto L29;
        int r4 = 2048;
    L30:
        r1 = r1 | r4;
        goto L32
    L29:
        r4 = 1024;
    L32:
        if ((r39 & 24576) != 0) goto L39;
        if (r8.changedInstance(r33) == false) goto L36;
        int r5 = 16384;
    L37:
        r1 = r1 | r5;
        goto L39
    L36:
        r5 = 8192;
    L39:
        if ((196608 & r39) != 0) goto L46;
        if (r8.changedInstance(r34) == false) goto L43;
        int r6 = 131072;
    L44:
        r1 = r1 | r6;
        goto L46
    L43:
        r6 = 65536;
    L46:
        if ((1572864 & r39) != 0) goto L56;
        if ((2097152 & r39) != 0) goto L50;
        boolean r7 = r8.changed(r35);
    L51:
        if (r7 == false) goto L53;
        int r9 = 1048576;
    L54:
        r1 = r1 | r9;
        goto L56
    L53:
        r9 = 524288;
        goto L54
    L50:
        r7 = r8.changedInstance(r35);
    L56:
        if ((12582912 & r39) != 0) goto L63;
        if (r8.changed(r36) == false) goto L60;
        int r10 = 8388608;
    L61:
        r1 = r1 | r10;
        goto L63
    L60:
        r10 = 4194304;
    L63:
        if ((100663296 & r39) == 0) goto L65;
    L69:
        int r11 = r1;
        if ((38347923 & r11) == 38347922) goto L72;
        boolean r12 = true;
    L74:
        if (r8.shouldExecute(r12, r11 & 1) == true) goto L76;
        Composer r13 = r8;
        r13.skipToGroupEnd();
    L147:
        ScopeUpdateScope r14 = r13.endRestartGroup();
        if (r14 == null) goto L151;
        r14.updateScope(new v5(r28, r29, r31, r32, r33, r34, r35, r36, r37, r39));
        return;
    L151:
        return;
    L76:
        if (ComposerKt.isTraceInProgress() == false) goto L78;
        ComposerKt.traceEventStart(-434467002, r11, -1, "androidx.compose.material3.DatePickerContent (DatePicker.kt:1537)");
    L78:
        CalendarMonth r15 = r33.getMonth(r29);
        int r0 = RangesKt.coerceAtLeast(r15.indexIn(r34), 0);
        final LazyListState r16 = LazyListStateKt.rememberLazyListState(r0, 0, r8, 0, 2);
        Integer r17 = Integer.valueOf(r0);
        boolean r18 = r8.changed(r16) | r8.changed(r0);
        Object r19 = r8.rememberedValue();
        if (r18 == false) goto L81;
    L82:
        r19 = new DatePickerKt$DatePickerContent$1$1(r16, r0, null);
        r8.updateRememberedValue(r19);
    L83:
        EffectsKt.LaunchedEffect(r17, (Function2) r19, r8, 0);
        Object r20 = r8.rememberedValue();
        Composer.Companion r110 = Composer.Companion;
        if (r20 != r110.getEmpty()) goto L86;
        r20 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, r8);
        r8.updateRememberedValue(r20);
    L86:
        final CoroutineScope r111 = (CoroutineScope) r20;
        Object[] r21 = new Object[0];
        Object r22 = r8.rememberedValue();
        if (r22 != r110.getEmpty()) goto L89;
        r22 = new q5();
        r8.updateRememberedValue(r22);
    L89:
        final MutableState r112 = (MutableState) RememberSaveableKt.rememberSaveable(r21, (Function0) r22, r8, 48);
        Modifier.Companion r23 = Modifier.Companion;
        Arrangement r113 = Arrangement.INSTANCE;
        Arrangement.Vertical r24 = r113.getTop();
        Alignment.Companion r114 = Alignment.Companion;
        MeasurePolicy r25 = ColumnKt.columnMeasurePolicy(r24, r114.getStart(), r8, 0);
        int r26 = ComposablesKt.getCurrentCompositeKeyHash(r8, 0);
        CompositionLocalMap r115 = r8.getCurrentCompositionLocalMap();
        Modifier r27 = ComposedModifierKt.materializeModifier(r8, r23);
        ComposeUiNode.Companion r210 = ComposeUiNode.Companion;
        Function0 r30 = r210.getConstructor();
        if ((r8.getApplier() instanceof Applier) == true) goto L92;
        ComposablesKt.invalidApplier();
    L92:
        r8.startReusableNode();
        if (r8.getInserting() == false) goto L95;
        r8.createNode(r30);
    L96:
        Composer r40 = Updater.constructor-impl(r8);
        Updater.set-impl(r40, r25, r210.getSetMeasurePolicy());
        Updater.set-impl(r40, r115, r210.getSetResolvedCompositionLocals());
        Function2 r41 = r210.getSetCompositeKeyHash();
        if (r40.getInserting() == false) goto L99;
    L100:
        r40.updateRememberedValue(Integer.valueOf(r26));
        r40.apply(Integer.valueOf(r26), r41);
    L101:
        Updater.set-impl(r40, r27, r210.getSetModifier());
        ColumnScopeInstance r42 = ColumnScopeInstance.INSTANCE;
        float r116 = DatePickerHorizontalPadding;
        Modifier r43 = PaddingKt.m962paddingVpY3zN4$default(r23, r116, MenuKt.ClosedAlphaTarget, 2, null);
        boolean r44 = r16.getCanScrollForward();
        boolean r211 = r16.getCanScrollBackward();
        boolean r212 = DatePickerContent$lambda$26(r112);
        String r45 = r35.formatMonthYear(Long.valueOf(r29), r33.getLocale());
        if (r45 != null) goto L104;
        r45 = "-";
    L104:
        String r46 = r45;
        boolean r47 = r8.changedInstance(r111) | r8.changed(r16);
        Object r48 = r8.rememberedValue();
        if (r47 == false) goto L107;
    L108:
        r48 = new r5(r111, r16);
        r8.updateRememberedValue(r48);
    L109:
        Function0 r49 = (Function0) r48;
        boolean r50 = r8.changedInstance(r111) | r8.changed(r16);
        Object r51 = r8.rememberedValue();
        if (r50 == false) goto L112;
    L113:
        r51 = new s5(r111, r16);
        r8.updateRememberedValue(r51);
    L114:
        Function0 r213 = (Function0) r51;
        boolean r52 = r8.changed(r112);
        Object r53 = r8.rememberedValue();
        if (r52 == false) goto L117;
    L118:
        r53 = new u5(r112);
        r8.updateRememberedValue(r53);
    L119:
        int r214 = r11 & 234881024;
        r13 = r8;
        MonthsNavigation(r43, r44, r211, r212, r46, r49, r213, (Function0) r53, r37, r8, r214 | 6);
        MeasurePolicy r54 = BoxKt.maybeCachedBoxMeasurePolicy(r114.getTopStart(), false);
        int r55 = ComposablesKt.getCurrentCompositeKeyHash(r13, 0);
        CompositionLocalMap r56 = r13.getCurrentCompositionLocalMap();
        Modifier r57 = ComposedModifierKt.materializeModifier(r13, r23);
        Function0 r58 = r210.getConstructor();
        if ((r13.getApplier() instanceof Applier) == true) goto L122;
        ComposablesKt.invalidApplier();
    L122:
        r13.startReusableNode();
        if (r13.getInserting() == false) goto L125;
        r13.createNode(r58);
    L126:
        Composer r59 = Updater.constructor-impl(r13);
        Updater.set-impl(r59, r54, r210.getSetMeasurePolicy());
        Updater.set-impl(r59, r56, r210.getSetResolvedCompositionLocals());
        Function2 r60 = r210.getSetCompositeKeyHash();
        if (r59.getInserting() == false) goto L129;
    L130:
        r59.updateRememberedValue(Integer.valueOf(r55));
        r59.apply(Integer.valueOf(r55), r60);
    L131:
        Updater.set-impl(r59, r57, r210.getSetModifier());
        BoxScopeInstance r61 = BoxScopeInstance.INSTANCE;
        Modifier r62 = PaddingKt.m962paddingVpY3zN4$default(r23, r116, MenuKt.ClosedAlphaTarget, 2, null);
        MeasurePolicy r63 = ColumnKt.columnMeasurePolicy(r113.getTop(), r114.getStart(), r13, 0);
        int r64 = ComposablesKt.getCurrentCompositeKeyHash(r13, 0);
        CompositionLocalMap r65 = r13.getCurrentCompositionLocalMap();
        Modifier r66 = ComposedModifierKt.materializeModifier(r13, r62);
        Function0 r67 = r210.getConstructor();
        if ((r13.getApplier() instanceof Applier) == true) goto L134;
        ComposablesKt.invalidApplier();
    L134:
        r13.startReusableNode();
        if (r13.getInserting() == false) goto L137;
        r13.createNode(r67);
    L138:
        Composer r68 = Updater.constructor-impl(r13);
        Updater.set-impl(r68, r63, r210.getSetMeasurePolicy());
        Updater.set-impl(r68, r65, r210.getSetResolvedCompositionLocals());
        Function2 r69 = r210.getSetCompositeKeyHash();
        if (r68.getInserting() == false) goto L141;
    L142:
        r68.updateRememberedValue(Integer.valueOf(r64));
        r68.apply(Integer.valueOf(r64), r69);
    L143:
        Updater.set-impl(r68, r66, r210.getSetModifier());
        WeekDays(r37, r33, r13, ((r11 >> 24) & 14) | ((r11 >> 9) & 112));
        HorizontalMonthsList(r16, r28, r31, r32, r33, r34, r35, r36, r37, r13, ((((((((r11 << 3) & 112) | (r11 & 896)) | (r11 & 7168)) | (57344 & r11)) | (458752 & r11)) | (3670016 & r11)) | (29360128 & r11)) | r214);
        r13.endNode();
        MotionSchemeKeyTokens r70 = MotionSchemeKeyTokens.DefaultEffects;
        FiniteAnimationSpec r71 = MotionSchemeKt.value(r70, r13, 6);
        FiniteAnimationSpec r72 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, r13, 6);
        FiniteAnimationSpec r73 = MotionSchemeKt.value(r70, r13, 6);
        AnimatedVisibilityKt.AnimatedVisibility(DatePickerContent$lambda$26(r112), ClipKt.clipToBounds(r23), EnterExitTransitionKt.expandVertically$default(r73, null, false, null, 14, null).plus(EnterExitTransitionKt.fadeIn(r71, 0.6f)), EnterExitTransitionKt.shrinkVertically$default(r73, null, false, null, 14, null).plus(EnterExitTransitionKt.fadeOut$default(r72, MenuKt.ClosedAlphaTarget, 2, null)), null, ComposableLambdaKt.rememberComposableLambda(1193716082, true, new DatePickerKt$DatePickerContent$2$4$2(r29, r112, r111, r16, r34, r15, r36, r33, r37), r13, 54), r13, 196656, 16);
        r13.endNode();
        r13.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L147;
        ComposerKt.traceEventEnd();
        goto L147
    L141:
        if (Intrinsics.areEqual(r68.rememberedValue(), Integer.valueOf(r64)) == true) goto L143;
    L137:
        r13.useNode();
        goto L138
    L129:
        if (Intrinsics.areEqual(r59.rememberedValue(), Integer.valueOf(r55)) == true) goto L131;
    L125:
        r13.useNode();
        goto L126
    L117:
        if (r53 != r110.getEmpty()) goto L119;
    L112:
        if (r51 != r110.getEmpty()) goto L114;
    L107:
        if (r48 != r110.getEmpty()) goto L109;
    L99:
        if (Intrinsics.areEqual(r40.rememberedValue(), Integer.valueOf(r26)) == true) goto L101;
    L95:
        r8.useNode();
        goto L96
    L81:
        if (r19 != Composer.Companion.getEmpty()) goto L83;
    L72:
        r12 = false;
        goto L74
    L65:
        if (r8.changed(r37) == false) goto L67;
        int r74 = 67108864;
    L68:
        r1 = r1 | r74;
        goto L69
    L67:
        r74 = 33554432;
        goto L68
    L5:
        if (r8.changed(r28) == false) goto L7;
        int r75 = 4;
    L8:
        r1 = r75 | r39;
        goto L11
    L7:
        r75 = 2;
        goto L8
    }

    private static final void HorizontalMonthsList(final LazyListState r20, final Long r21, final Function1<? super Long, Unit> r22, final Function1<? super Long, Unit> r23, final CalendarModel r24, final IntRange r25, final DatePickerFormatter r26, final SelectableDates r27, final DatePickerColors r28, Composer r29, final int r30) {
        Composer r10 = r29.startRestartGroup(-1994757941);
        if ((r30 & 6) == 0) goto L5;
        int r1 = r30;
    L11:
        if ((r30 & 48) != 0) goto L18;
        if (r10.changed(r21) == false) goto L15;
        int r2 = 32;
    L16:
        r1 = r1 | r2;
        goto L18
    L15:
        r2 = 16;
    L18:
        if ((r30 & 384) != 0) goto L25;
        if (r10.changedInstance(r22) == false) goto L22;
        int r3 = 256;
    L23:
        r1 = r1 | r3;
        goto L25
    L22:
        r3 = 128;
    L25:
        if ((r30 & 3072) != 0) goto L32;
        if (r10.changedInstance(r23) == false) goto L29;
        int r4 = 2048;
    L30:
        r1 = r1 | r4;
        goto L32
    L29:
        r4 = 1024;
    L32:
        if ((r30 & 24576) != 0) goto L39;
        if (r10.changedInstance(r24) == false) goto L36;
        int r5 = 16384;
    L37:
        r1 = r1 | r5;
        goto L39
    L36:
        r5 = 8192;
    L39:
        if ((196608 & r30) != 0) goto L46;
        if (r10.changedInstance(r25) == false) goto L43;
        int r6 = 131072;
    L44:
        r1 = r1 | r6;
        goto L46
    L43:
        r6 = 65536;
    L46:
        if ((1572864 & r30) != 0) goto L56;
        if ((2097152 & r30) != 0) goto L50;
        boolean r7 = r10.changed(r26);
    L51:
        if (r7 == false) goto L53;
        int r8 = 1048576;
    L54:
        r1 = r1 | r8;
        goto L56
    L53:
        r8 = 524288;
        goto L54
    L50:
        r7 = r10.changedInstance(r26);
    L56:
        if ((12582912 & r30) != 0) goto L63;
        if (r10.changed(r27) == false) goto L60;
        int r9 = 8388608;
    L61:
        r1 = r1 | r9;
        goto L63
    L60:
        r9 = 4194304;
    L63:
        if ((100663296 & r30) == 0) goto L65;
    L69:
        int r11 = r1;
        boolean r16 = false;
        if ((38347923 & r11) == 38347922) goto L72;
        boolean r12 = true;
    L74:
        if (r10.shouldExecute(r12, r11 & 1) == true) goto L76;
        Composer r15 = r10;
        r15.skipToGroupEnd();
    L99:
        ScopeUpdateScope r14 = r15.endRestartGroup();
        if (r14 == null) goto L103;
        r14.updateScope(new d5(r20, r21, r22, r23, r24, r25, r26, r27, r28, r30));
        return;
    L103:
        return;
    L76:
        if (ComposerKt.isTraceInProgress() == false) goto L78;
        ComposerKt.traceEventStart(-1994757941, r11, -1, "androidx.compose.material3.HorizontalMonthsList (DatePicker.kt:1711)");
    L78:
        CalendarDate r13 = r24.getToday();
        boolean r17 = r10.changed(r25);
        Object r18 = r10.rememberedValue();
        if (r17 == false) goto L81;
    L82:
        r18 = r24.getMonth(r25.getFirst(), 1);
        r10.updateRememberedValue(r18);
    L83:
        r15 = r10;
        TextKt.ProvideTextStyle(TypographyKt.getValue(DatePickerModalTokens.INSTANCE.getDateLabelTextFont(), r10, 6), ComposableLambdaKt.rememberComposableLambda(1504086906, true, new AnonymousClass1(r20, r25, r24, (CalendarMonth) r18, r22, r13, r21, r26, r27, r28), r15, 54), r15, 48);
        int r19 = r11 & 14;
        if (r19 != 4) goto L86;
        boolean r0 = true;
    L88:
        if ((r11 & 7168) != 2048) goto L90;
        r16 = true;
    L90:
        boolean r31 = ((r0 | r16) | r15.changedInstance(r24)) | r15.changedInstance(r25);
        Object r32 = r15.rememberedValue();
        if (r31 == false) goto L93;
    L94:
        DatePickerKt$HorizontalMonthsList$2$1 r33 = new DatePickerKt$HorizontalMonthsList$2$1(r20, r23, r24, r25, null);
        r15.updateRememberedValue(r33);
        r32 = r33;
    L95:
        EffectsKt.LaunchedEffect(r20, (Function2) r32, r15, r19);
        if (ComposerKt.isTraceInProgress() == false) goto L99;
        ComposerKt.traceEventEnd();
        goto L99
    L93:
        if (r32 != Composer.Companion.getEmpty()) goto L95;
    L86:
        r0 = false;
        goto L88
    L81:
        if (r18 != Composer.Companion.getEmpty()) goto L83;
    L72:
        r12 = false;
        goto L74
    L65:
        if (r10.changed(r28) == false) goto L67;
        int r34 = 67108864;
    L68:
        r1 = r1 | r34;
        goto L69
    L67:
        r34 = 33554432;
        goto L68
    L5:
        if (r10.changed(r20) == false) goto L7;
        int r35 = 4;
    L8:
        r1 = r35 | r30;
        goto L11
    L7:
        r35 = 2;
        goto L8
    }

    private static final void MonthsNavigation(final Modifier r18, final boolean r19, final boolean r20, final boolean r21, final String r22, final Function0<Unit> r23, final Function0<Unit> r24, final Function0<Unit> r25, final DatePickerColors r26, Composer r27, final int r28) {
        Composer r10 = r27.startRestartGroup(-773929258);
        if ((r28 & 6) == 0) goto L5;
        int r5 = r28;
    L11:
        if ((r28 & 48) != 0) goto L18;
        if (r10.changed(r19) == false) goto L15;
        int r6 = 32;
    L16:
        r5 = r5 | r6;
        goto L18
    L15:
        r6 = 16;
    L18:
        if ((r28 & 384) != 0) goto L25;
        if (r10.changed(r20) == false) goto L22;
        int r7 = 256;
    L23:
        r5 = r5 | r7;
        goto L25
    L22:
        r7 = 128;
    L25:
        if ((r28 & 3072) != 0) goto L32;
        if (r10.changed(r21) == false) goto L29;
        int r8 = 2048;
    L30:
        r5 = r5 | r8;
        goto L32
    L29:
        r8 = 1024;
    L32:
        if ((r28 & 24576) != 0) goto L39;
        if (r10.changed(r22) == false) goto L36;
        int r9 = 16384;
    L37:
        r5 = r5 | r9;
        goto L39
    L36:
        r9 = 8192;
    L39:
        if ((196608 & r28) != 0) goto L46;
        if (r10.changedInstance(r23) == false) goto L43;
        int r11 = 131072;
    L44:
        r5 = r5 | r11;
        goto L46
    L43:
        r11 = 65536;
    L46:
        if ((1572864 & r28) != 0) goto L53;
        if (r10.changedInstance(r24) == false) goto L50;
        int r12 = 1048576;
    L51:
        r5 = r5 | r12;
        goto L53
    L50:
        r12 = 524288;
    L53:
        if ((12582912 & r28) != 0) goto L60;
        if (r10.changedInstance(r25) == false) goto L57;
        int r13 = 8388608;
    L58:
        r5 = r5 | r13;
        goto L60
    L57:
        r13 = 4194304;
    L60:
        if ((100663296 & r28) != 0) goto L67;
        if (r10.changed(r26) == false) goto L64;
        int r14 = 67108864;
    L65:
        r5 = r5 | r14;
        goto L67
    L64:
        r14 = 33554432;
    L67:
        if ((38347923 & r5) == 38347922) goto L69;
        boolean r15 = true;
    L71:
        if (r10.shouldExecute(r15, r5 & 1) == true) goto L73;
        Composer r1 = r10;
        r1.skipToGroupEnd();
    L99:
        ScopeUpdateScope r16 = r1.endRestartGroup();
        if (r16 == null) goto L103;
        r16.updateScope(new p5(r18, r19, r20, r21, r22, r23, r24, r25, r26, r28));
        return;
    L103:
        return;
    L73:
        if (ComposerKt.isTraceInProgress() == false) goto L75;
        ComposerKt.traceEventStart(-773929258, r5, -1, "androidx.compose.material3.MonthsNavigation (DatePicker.kt:2191)");
    L75:
        Modifier r4 = SizeKt.m1003requiredHeight3ABfNKs(SizeKt.fillMaxWidth$default(r18, MenuKt.ClosedAlphaTarget, 1, null), MonthYearHeight);
        if (r21 == false) goto L78;
        Arrangement.Horizontal r17 = Arrangement.INSTANCE.getStart();
    L79:
        MeasurePolicy r29 = RowKt.rowMeasurePolicy(r17, Alignment.Companion.getCenterVertically(), r10, 48);
        int r30 = ComposablesKt.getCurrentCompositeKeyHash(r10, 0);
        CompositionLocalMap r31 = r10.getCurrentCompositionLocalMap();
        Modifier r32 = ComposedModifierKt.materializeModifier(r10, r4);
        ComposeUiNode.Companion r110 = ComposeUiNode.Companion;
        Function0 r0 = r110.getConstructor();
        if ((r10.getApplier() instanceof Applier) == true) goto L82;
        ComposablesKt.invalidApplier();
    L82:
        r10.startReusableNode();
        if (r10.getInserting() == false) goto L85;
        r10.createNode(r0);
    L86:
        Composer r2 = Updater.constructor-impl(r10);
        Updater.set-impl(r2, r29, r110.getSetMeasurePolicy());
        Updater.set-impl(r2, r31, r110.getSetResolvedCompositionLocals());
        Function2 r3 = r110.getSetCompositeKeyHash();
        if (r2.getInserting() == false) goto L89;
    L90:
        r2.updateRememberedValue(Integer.valueOf(r30));
        r2.apply(Integer.valueOf(r30), r3);
    L91:
        Updater.set-impl(r2, r32, r110.getSetModifier());
        RowScopeInstance r33 = RowScopeInstance.INSTANCE;
        int r34 = (((r5 >> 21) & 14) | 3072) | ((r5 >> 6) & 112);
        r1 = r10;
        YearPickerMenuButton(r25, r21, null, ComposableLambdaKt.rememberComposableLambda(619076006, true, new DatePickerKt$MonthsNavigation$1$1(r22, r26), r10, 54), r10, r34, 4);
        if (r21 == true) goto L94;
        r1.startReplaceGroup(281624840);
        CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.box-impl(r26.m2565getNavigationContentColor0d7_KjU())), ComposableLambdaKt.rememberComposableLambda(-128317193, true, new DatePickerKt$MonthsNavigation$1$2(r24, r20, r23, r19), r1, 54), r1, ProvidedValue.$stable | 48);
        r1.endReplaceGroup();
    L95:
        r1.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L99;
        ComposerKt.traceEventEnd();
        goto L99
    L94:
        r1.startReplaceGroup(282432080);
        r1.endReplaceGroup();
        goto L95
    L89:
        if (Intrinsics.areEqual(r2.rememberedValue(), Integer.valueOf(r30)) == true) goto L91;
    L85:
        r10.useNode();
        goto L86
    L78:
        r17 = Arrangement.INSTANCE.getSpaceBetween();
        goto L79
    L69:
        r15 = false;
        goto L71
    L5:
        if (r10.changed(r18) == false) goto L7;
        int r35 = 4;
    L8:
        r5 = r35 | r28;
        goto L11
    L7:
        r35 = 2;
        goto L8
    }

    public static final /* synthetic */ void access$DatePickerContent(Long r0, long r1, Function1 r3, Function1 r4, CalendarModel r5, IntRange r6, DatePickerFormatter r7, SelectableDates r8, DatePickerColors r9, Composer r10, int r11) {
        DatePickerContent(r0, r1, r3, r4, r5, r6, r7, r8, r9, r10, r11);
    }

    private static final void Day(final String r33, final Modifier r34, final boolean r35, final Function0<Unit> r36, final boolean r37, final boolean r38, final boolean r39, final boolean r40, final String r41, final DatePickerColors r42, Composer r43, final int r44) {
        Composer r13 = r43.startRestartGroup(-945355136);
        if ((r44 & 6) == 0) goto L5;
        int r4 = r44;
    L11:
        if ((r44 & 48) != 0) goto L18;
        if (r13.changed(r34) == false) goto L15;
        int r5 = 32;
    L16:
        r4 = r4 | r5;
        goto L18
    L15:
        r5 = 16;
    L18:
        if ((r44 & 384) != 0) goto L25;
        if (r13.changed(r35) == false) goto L22;
        int r6 = 256;
    L23:
        r4 = r4 | r6;
        goto L25
    L22:
        r6 = 128;
    L25:
        if ((r44 & 3072) != 0) goto L32;
        if (r13.changedInstance(r36) == false) goto L29;
        int r7 = 2048;
    L30:
        r4 = r4 | r7;
        goto L32
    L29:
        r7 = 1024;
    L32:
        if ((r44 & 24576) != 0) goto L39;
        if (r13.changed(r37) == false) goto L36;
        int r8 = 16384;
    L37:
        r4 = r4 | r8;
        goto L39
    L36:
        r8 = 8192;
    L39:
        if ((196608 & r44) != 0) goto L46;
        if (r13.changed(r38) == false) goto L43;
        int r9 = 131072;
    L44:
        r4 = r4 | r9;
        goto L46
    L43:
        r9 = 65536;
    L46:
        if ((1572864 & r44) != 0) goto L53;
        if (r13.changed(r39) == false) goto L50;
        int r10 = 1048576;
    L51:
        r4 = r4 | r10;
        goto L53
    L50:
        r10 = 524288;
    L53:
        if ((12582912 & r44) != 0) goto L60;
        if (r13.changed(r40) == false) goto L57;
        int r11 = 8388608;
    L58:
        r4 = r4 | r11;
        goto L60
    L57:
        r11 = 4194304;
    L60:
        if ((100663296 & r44) != 0) goto L67;
        if (r13.changed(r41) == false) goto L64;
        int r12 = 67108864;
    L65:
        r4 = r4 | r12;
        goto L67
    L64:
        r12 = 33554432;
    L67:
        if ((805306368 & r44) == 0) goto L69;
    L73:
        boolean r16 = false;
        if ((306783379 & r4) == 306783378) goto L76;
        boolean r14 = true;
    L78:
        if (r13.shouldExecute(r14, r4 & 1) == true) goto L80;
        Composer r0 = r13;
        r0.skipToGroupEnd();
    L99:
        ScopeUpdateScope r15 = r0.endRestartGroup();
        if (r15 == null) goto L103;
        r15.updateScope(new a6(r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r44));
        return;
    L103:
        return;
    L80:
        if (ComposerKt.isTraceInProgress() == false) goto L83;
        ComposerKt.traceEventStart(-945355136, r4, -1, "androidx.compose.material3.Day (DatePicker.kt:2003)");
    L83:
        if ((234881024 & r4) != 67108864) goto L85;
        r16 = true;
    L85:
        Object r3 = r13.rememberedValue();
        if (r16 == false) goto L88;
    L89:
        r3 = new z5(r41);
        r13.updateRememberedValue(r3);
    L90:
        Modifier r17 = SemanticsModifierKt.semantics(r34, true, (Function1) r3);
        DatePickerModalTokens r18 = DatePickerModalTokens.INSTANCE;
        Shape r19 = ShapesKt.getValue(r18.getDateContainerShape(), r13, 6);
        int r20 = r4 >> 6;
        int r110 = r20 & 14;
        long r21 = ((Color) r42.dayContainerColor$material3(r35, r38, r37, r13, ((r110 | ((r4 >> 12) & 112)) | (r20 & 896)) | ((r4 >> 18) & 7168)).getValue()).unbox-impl();
        if (r39 == false) goto L94;
        if (r35 == true) goto L94;
        BorderStroke r22 = BorderStrokeKt.m369BorderStrokecXLIe8U(r18.getDateTodayContainerOutlineWidth-D9Ej5fM(), r42.m2573getTodayDateBorderColor0d7_KjU());
    L95:
        int r25 = (r110 | (r20 & 112)) | (r20 & 7168);
        r0 = r13;
        SurfaceKt.m3214Surfaced85dljk(r35, r36, r17, r38, r19, r21, 0, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, r22, null, ComposableLambdaKt.rememberComposableLambda(1126347158, true, new C02572(r33, r42, r39, r35, r40, r38), r13, 54), r0, r25, 48, 1472);
        if (ComposerKt.isTraceInProgress() == false) goto L99;
        ComposerKt.traceEventEnd();
    L94:
        r22 = null;
        goto L95
    L88:
        if (r3 != Composer.Companion.getEmpty()) goto L90;
    L76:
        r14 = false;
        goto L78
    L69:
        if (r13.changed(r42) == false) goto L71;
        int r23 = 536870912;
    L72:
        r4 = r4 | r23;
        goto L73
    L71:
        r23 = 268435456;
        goto L72
    L5:
        if (r13.changed(r33) == false) goto L7;
        int r24 = 4;
    L8:
        r4 = r24 | r44;
        goto L11
    L7:
        r24 = 2;
        goto L8
    }

    public static final void Month(final CalendarMonth r38, final Function1<? super Long, Unit> r39, final long r40, final Long r42, final Long r43, final SelectedRangeInfo r44, final DatePickerFormatter r45, final SelectableDates r46, final DatePickerColors r47, final Locale r48, Composer r49, final int r50) {
        long r3 = r40;
        Locale r0 = r48;
        Composer r14 = r49.startRestartGroup(-333300603);
        if ((r50 & 6) == 0) goto L5;
        int r11 = r50;
    L11:
        if ((r50 & 48) != 0) goto L18;
        if (r14.changedInstance(r39) == false) goto L15;
        int r16 = 32;
    L16:
        r11 = r11 | r16;
        goto L18
    L15:
        r16 = 16;
    L18:
        if ((r50 & 384) != 0) goto L25;
        if (r14.changed(r3) == false) goto L22;
        int r12 = 256;
    L23:
        r11 = r11 | r12;
        goto L25
    L22:
        r12 = 128;
    L25:
        if ((r50 & 3072) != 0) goto L32;
        if (r14.changed(r42) == false) goto L29;
        int r13 = 2048;
    L30:
        r11 = r11 | r13;
        goto L32
    L29:
        r13 = 1024;
    L32:
        if ((r50 & 24576) != 0) goto L39;
        if (r14.changed(r43) == false) goto L36;
        int r15 = 16384;
    L37:
        r11 = r11 | r15;
        goto L39
    L36:
        r15 = 8192;
    L39:
        if ((196608 & r50) != 0) goto L46;
        if (r14.changed(r44) == false) goto L43;
        int r17 = 131072;
    L44:
        r11 = r11 | r17;
        goto L46
    L43:
        r17 = 65536;
    L46:
        if ((1572864 & r50) != 0) goto L56;
        if ((2097152 & r50) != 0) goto L50;
        boolean r18 = r14.changed(r45);
    L51:
        if (r18 == false) goto L53;
        int r19 = 1048576;
    L54:
        r11 = r11 | r19;
        goto L56
    L53:
        r19 = 524288;
        goto L54
    L50:
        r18 = r14.changedInstance(r45);
    L56:
        if ((12582912 & r50) != 0) goto L63;
        if (r14.changed(r46) == false) goto L60;
        int r110 = 8388608;
    L61:
        r11 = r11 | r110;
        goto L63
    L60:
        r110 = 4194304;
    L63:
        if ((100663296 & r50) != 0) goto L70;
        if (r14.changed(r47) == false) goto L67;
        int r111 = 67108864;
    L68:
        r11 = r11 | r111;
        goto L70
    L67:
        r111 = 33554432;
    L70:
        if ((805306368 & r50) == 0) goto L72;
    L76:
        int r112 = r11;
        if ((306783379 & r112) == 306783378) goto L79;
        boolean r113 = true;
    L81:
        if (r14.shouldExecute(r113, r112 & 1) == true) goto L83;
        Composer r1 = r14;
        r1.skipToGroupEnd();
    L230:
        ScopeUpdateScope r114 = r1.endRestartGroup();
        if (r114 == null) goto L238;
        r114.updateScope(new j5(r38, r39, r40, r42, r43, r44, r45, r46, r47, r48, r50));
        return;
    L238:
        return;
    L83:
        if (ComposerKt.isTraceInProgress() == false) goto L86;
        ComposerKt.traceEventStart(-333300603, r112, -1, "androidx.compose.material3.Month (DatePicker.kt:1844)");
    L86:
        if (r44 == null) goto L101;
        r14.startReplaceGroup(606579709);
        Modifier.Companion r10 = Modifier.Companion;
        if ((r112 & 458752) != 131072) goto L90;
        boolean r115 = true;
    L92:
        if ((234881024 & r112) != 67108864) goto L94;
        boolean r116 = true;
    L95:
        boolean r117 = r115 | r116;
        Object r118 = r14.rememberedValue();
        if (r117 == false) goto L98;
    L99:
        r118 = new g5(r44, r47);
        r14.updateRememberedValue(r118);
    L100:
        Modifier r119 = DrawModifierKt.drawWithContent(r10, (Function1) r118);
        r14.endReplaceGroup();
    L102:
        Modifier r2 = SizeKt.m1003requiredHeight3ABfNKs(Modifier.Companion, Dp.constructor-impl(RecommendedSizeForAccessibility * 6)).then(r119);
        MeasurePolicy r120 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getSpaceEvenly(), Alignment.Companion.getStart(), r14, 6);
        int r121 = ComposablesKt.getCurrentCompositeKeyHash(r14, 0);
        CompositionLocalMap r122 = r14.getCurrentCompositionLocalMap();
        Modifier r4 = ComposedModifierKt.materializeModifier(r14, r2);
        ComposeUiNode.Companion r123 = ComposeUiNode.Companion;
        Function0 r124 = r123.getConstructor();
        if ((r14.getApplier() instanceof Applier) == true) goto L105;
        ComposablesKt.invalidApplier();
    L105:
        r14.startReusableNode();
        if (r14.getInserting() == false) goto L108;
        r14.createNode(r124);
    L109:
        Composer r9 = Updater.constructor-impl(r14);
        Updater.set-impl(r9, r120, r123.getSetMeasurePolicy());
        Updater.set-impl(r9, r122, r123.getSetResolvedCompositionLocals());
        Function2 r125 = r123.getSetCompositeKeyHash();
        if (r9.getInserting() == false) goto L112;
    L113:
        r9.updateRememberedValue(Integer.valueOf(r121));
        r9.apply(Integer.valueOf(r121), r125);
    L114:
        Updater.set-impl(r9, r4, r123.getSetModifier());
        ColumnScopeInstance r5 = ColumnScopeInstance.INSTANCE;
        r14.startReplaceGroup(-680088486);
        int r6 = 0;
        int r20 = 6;
        int r126 = 0;
    L115:
        if (r6 >= r20) goto L226;
        Modifier r127 = SizeKt.fillMaxWidth$default(Modifier.Companion, MenuKt.ClosedAlphaTarget, 1, null);
        MeasurePolicy r21 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getSpaceEvenly(), Alignment.Companion.getCenterVertically(), r14, 54);
        int r128 = ComposablesKt.getCurrentCompositeKeyHash(r14, 0);
        CompositionLocalMap r129 = r14.getCurrentCompositionLocalMap();
        Modifier r130 = ComposedModifierKt.materializeModifier(r14, r127);
        ComposeUiNode.Companion r131 = ComposeUiNode.Companion;
        int r132 = r126;
        Function0 r133 = r131.getConstructor();
        int r30 = r6;
        if ((r14.getApplier() instanceof Applier) == true) goto L119;
        ComposablesKt.invalidApplier();
    L119:
        r14.startReusableNode();
        if (r14.getInserting() == false) goto L122;
        r14.createNode(r133);
    L123:
        Composer r7 = Updater.constructor-impl(r14);
        Updater.set-impl(r7, r21, r131.getSetMeasurePolicy());
        Updater.set-impl(r7, r129, r131.getSetResolvedCompositionLocals());
        Function2 r22 = r131.getSetCompositeKeyHash();
        if (r7.getInserting() == false) goto L126;
    L127:
        r7.updateRememberedValue(Integer.valueOf(r128));
        r7.apply(Integer.valueOf(r128), r22);
    L128:
        Updater.set-impl(r7, r130, r131.getSetModifier());
        RowScopeInstance r8 = RowScopeInstance.INSTANCE;
        r14.startReplaceGroup(1542622325);
        int r23 = r132;
        int r24 = 0;
    L130:
        if (r24 >= 7) goto L225;
        if (r23 >= r38.getDaysFromStartOfWeekToFirstOfMonth()) goto L134;
    L223:
        int r25 = r112;
        Composer r26 = r14;
        r26.startReplaceGroup(576825328);
        Modifier.Companion r134 = Modifier.Companion;
        DatePickerModalTokens r27 = DatePickerModalTokens.INSTANCE;
        SpacerKt.Spacer(SizeKt.m1016sizeVpY3zN4(SizeKt.m1018sizeInqDBjuR0$default(r134, r27.getDateContainerWidth-D9Ej5fM(), r27.getDateContainerHeight-D9Ej5fM(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 12, null), ((Dp) r26.consume(InteractiveComponentSizeKt.getLocalMinimumInteractiveComponentSize())).unbox-impl(), ((Dp) r26.consume(InteractiveComponentSizeKt.getLocalMinimumInteractiveComponentSize())).unbox-impl()), r26, 0);
        r26.endReplaceGroup();
    L224:
        r23 = r23 + 1;
        r3 = r40;
        r14 = r26;
        r112 = r25;
        r24 = r24 + 1;
        r0 = r48;
        goto L130
    L134:
        if (r23 >= (r38.getDaysFromStartOfWeekToFirstOfMonth() + r38.getNumberOfDays())) goto L223;
        r14.startReplaceGroup(577914947);
        int r135 = r23 - r38.getDaysFromStartOfWeekToFirstOfMonth();
        final long r28 = (((long) r135) * 86400000) + r38.getStartUtcTimeMillis();
        if (r28 != r3) goto L139;
        boolean r32 = true;
    L140:
        if (r42 != null) goto L143;
    L145:
        boolean r33 = false;
    L146:
        if (r43 != null) goto L149;
    L151:
        boolean r34 = false;
    L152:
        if (r44 == null) goto L177;
        r14.startReplaceGroup(578361347);
        if ((r112 & 458752) != 131072) goto L156;
        boolean r136 = true;
    L157:
        boolean r137 = r136 | r14.changed(r28);
        Object r138 = r14.rememberedValue();
        if (r137 == false) goto L160;
    L163:
        if (r42 == null) goto L165;
        long r139 = r42.longValue();
    L167:
        if (r28 < r139) goto L174;
        if (r43 == null) goto L170;
        long r140 = r43.longValue();
    L172:
        if (r28 > r140) goto L174;
        boolean r141 = true;
    L175:
        Object r142 = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(r141), null, 2, null);
        r14.updateRememberedValue(r142);
    L176:
        boolean r143 = ((Boolean) ((MutableState) r142).getValue()).booleanValue();
        r14.endReplaceGroup();
        boolean r29 = r143;
    L178:
        if (r44 == null) goto L180;
        boolean r144 = true;
    L181:
        String r145 = dayContentDescription(r144, r32, r33, r34, r29, r14, 0);
        String r146 = r45.formatDate(Long.valueOf(r28), r0, true);
        if (r146 != null) goto L184;
        r146 = "";
    L184:
        r25 = r112;
        String r36 = r146;
        Composer r37 = r14;
        String r147 = CalendarLocale_jvmKt.toLocalString$default(r135 + 1, 0, 0, false, r48, 7, null);
        Modifier.Companion r148 = Modifier.Companion;
        if (r33 == true) goto L189;
        if (r34 == true) goto L189;
        boolean r149 = false;
    L191:
        if ((r25 & 112) != 32) goto L193;
        boolean r150 = true;
    L194:
        boolean r151 = r150 | r37.changed(r28);
        Object r152 = r37.rememberedValue();
        if (r151 == false) goto L197;
    L200:
        r152 = new h5(r39, r28);
        r37.updateRememberedValue(r152);
    L201:
        Function0 r153 = (Function0) r152;
        boolean r154 = r37.changed(r28);
        if ((r25 & 29360128) != 8388608) goto L204;
        boolean r31 = true;
    L205:
        boolean r35 = r154 | r31;
        Object r41 = r37.rememberedValue();
        if (r35 == true) goto L212;
        if (r41 == Composer.Companion.getEmpty()) goto L212;
        Object r51 = r41;
    L218:
        boolean r52 = ((Boolean) r51).booleanValue();
        if (r145 == null) goto L221;
        String r53 = r145 + ", " + r36;
    L222:
        r26 = r37;
        Day(r147, r148, r149, r153, r33, r52, r32, r29, r53, r47, r26, ((r25 << 3) & 1879048192) | 48);
        r26.endReplaceGroup();
        goto L224
    L221:
        r53 = r36;
    L212:
        if (r46.isSelectableYear(r38.getYear()) == true) goto L214;
    L216:
        boolean r54 = false;
    L217:
        r51 = Boolean.valueOf(r54);
        r37.updateRememberedValue(r51);
        goto L218
    L214:
        if (r46.isSelectableDate(r28) == false) goto L216;
        r54 = true;
        goto L217
    L204:
        r31 = false;
        goto L205
    L197:
        if (r152 != Composer.Companion.getEmpty()) goto L201;
    L193:
        r150 = false;
    L189:
        r149 = true;
        goto L191
    L180:
        r144 = false;
        goto L181
    L170:
        r140 = Long.MIN_VALUE;
    L174:
        r141 = false;
        goto L175
    L165:
        r139 = Long.MAX_VALUE;
        goto L167
    L160:
        if (r138 == Composer.Companion.getEmpty()) goto L163;
        r142 = r138;
        goto L176
    L156:
        r136 = false;
        goto L157
    L177:
        r14.startReplaceGroup(578890300);
        r14.endReplaceGroup();
        r29 = false;
        goto L178
    L149:
        if (r28 != r43.longValue()) goto L151;
        r34 = true;
        goto L152
    L143:
        if (r28 != r42.longValue()) goto L145;
        r33 = true;
        goto L146
    L139:
        r32 = false;
        goto L140
    L225:
        Composer r55 = r14;
        r55.endReplaceGroup();
        r55.endNode();
        r3 = r40;
        r126 = r23;
        r20 = 6;
        r6 = r30 + 1;
        r0 = r48;
        goto L115
    L126:
        if (Intrinsics.areEqual(r7.rememberedValue(), Integer.valueOf(r128)) == true) goto L128;
    L122:
        r14.useNode();
        goto L123
    L226:
        r1 = r14;
        r1.endReplaceGroup();
        r1.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L230;
        ComposerKt.traceEventEnd();
        goto L230
    L112:
        if (Intrinsics.areEqual(r9.rememberedValue(), Integer.valueOf(r121)) == true) goto L114;
    L108:
        r14.useNode();
        goto L109
    L98:
        if (r118 != Composer.Companion.getEmpty()) goto L100;
    L94:
        r116 = false;
        goto L95
    L90:
        r115 = false;
        goto L92
    L101:
        r14.startReplaceGroup(606771165);
        r14.endReplaceGroup();
        r119 = Modifier.Companion;
        goto L102
    L79:
        r113 = false;
        goto L81
    L72:
        if (r14.changedInstance(r0) == false) goto L74;
        int r155 = 536870912;
    L75:
        r11 = r11 | r155;
        goto L76
    L74:
        r155 = 268435456;
        goto L75
    L5:
        if (r14.changed(r38) == false) goto L7;
        int r156 = 4;
    L8:
        r11 = r156 | r50;
        goto L11
    L7:
        r156 = 2;
        goto L8
    }

    /* JADX INFO: renamed from: SwitchableDateEntryContent-KaiTk9E, reason: not valid java name */
    private static final void m2586SwitchableDateEntryContentKaiTk9E(final Long r26, final long r27, final int r29, final Function1<? super Long, Unit> r30, final Function1<? super Long, Unit> r31, final CalendarModel r32, final IntRange r33, final DatePickerFormatter r34, final SelectableDates r35, final DatePickerColors r36, final FocusRequester r37, Composer r38, final int r39, final int r40) {
        Composer r14 = r38.startRestartGroup(-2053685029);
        int r2 = 4;
        if ((r39 & 6) == 0) goto L5;
        int r1 = r39;
    L11:
        if ((r39 & 48) != 0) goto L18;
        if (r14.changed(r27) == false) goto L15;
        int r4 = 32;
    L16:
        r1 = r1 | r4;
        goto L18
    L15:
        r4 = 16;
    L18:
        if ((r39 & 384) != 0) goto L25;
        if (r14.changed(r29) == false) goto L22;
        int r5 = 256;
    L23:
        r1 = r1 | r5;
        goto L25
    L22:
        r5 = 128;
    L25:
        if ((r39 & 3072) != 0) goto L32;
        if (r14.changedInstance(r30) == false) goto L29;
        int r6 = 2048;
    L30:
        r1 = r1 | r6;
        goto L32
    L29:
        r6 = 1024;
    L32:
        if ((r39 & 24576) != 0) goto L39;
        if (r14.changedInstance(r31) == false) goto L36;
        int r7 = 16384;
    L37:
        r1 = r1 | r7;
        goto L39
    L36:
        r7 = 8192;
    L39:
        if ((196608 & r39) != 0) goto L46;
        if (r14.changedInstance(r32) == false) goto L43;
        int r8 = 131072;
    L44:
        r1 = r1 | r8;
        goto L46
    L43:
        r8 = 65536;
    L46:
        if ((1572864 & r39) != 0) goto L53;
        if (r14.changedInstance(r33) == false) goto L50;
        int r9 = 1048576;
    L51:
        r1 = r1 | r9;
        goto L53
    L50:
        r9 = 524288;
    L53:
        if ((12582912 & r39) != 0) goto L63;
        if ((16777216 & r39) != 0) goto L57;
        boolean r10 = r14.changed(r34);
    L58:
        if (r10 == false) goto L60;
        int r11 = 8388608;
    L61:
        r1 = r1 | r11;
        goto L63
    L60:
        r11 = 4194304;
        goto L61
    L57:
        r10 = r14.changedInstance(r34);
    L63:
        if ((100663296 & r39) != 0) goto L71;
        if (r14.changed(r35) == false) goto L67;
        int r16 = 67108864;
    L68:
        r1 = r1 | r16;
        goto L71
    L67:
        r16 = 33554432;
    L71:
        if ((r39 & 805306368) != 0) goto L78;
        if (r14.changed(r36) == false) goto L75;
        int r17 = 536870912;
    L76:
        r1 = r1 | r17;
        goto L78
    L75:
        r17 = 268435456;
    L78:
        if ((r40 & 6) == 0) goto L80;
        int r3 = r40;
    L86:
        if ((r1 & 306783379) == 306783378) goto L88;
    L91:
        boolean r0 = true;
    L93:
        if (r14.shouldExecute(r0, r1 & 1) == true) goto L95;
        r14.skipToGroupEnd();
    L109:
        ScopeUpdateScope r15 = r14.endRestartGroup();
        if (r15 == null) goto L113;
        r15.updateScope(new y5(r26, r27, r29, r30, r31, r32, r33, r34, r35, r36, r37, r39, r40));
        return;
    L113:
        return;
    L95:
        if (ComposerKt.isTraceInProgress() == false) goto L97;
        ComposerKt.traceEventStart(-2053685029, r1, r3, "androidx.compose.material3.SwitchableDateEntryContent (DatePicker.kt:1443)");
    L97:
        final int r12 = -((Density) r14.consume(CompositionLocalsKt.getLocalDensity())).roundToPx-0680j_4(Dp.constructor-impl(48));
        final FiniteAnimationSpec r13 = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, r14, 6);
        final FiniteAnimationSpec r18 = MotionSchemeKt.value(MotionSchemeKeyTokens.FastEffects, r14, 6);
        int r19 = r1;
        MotionSchemeKeyTokens r20 = MotionSchemeKeyTokens.DefaultSpatial;
        final FiniteAnimationSpec r21 = MotionSchemeKt.value(r20, r14, 6);
        final FiniteAnimationSpec r22 = MotionSchemeKt.value(r20, r14, 6);
        DisplayMode r24 = DisplayMode.m2623boximpl(r29);
        Modifier.Companion r23 = Modifier.Companion;
        Object r25 = r14.rememberedValue();
        Composer.Companion r110 = Composer.Companion;
        if (r25 != r110.getEmpty()) goto L100;
        r25 = new i5();
        r14.updateRememberedValue(r25);
    L100:
        Modifier r111 = SemanticsModifierKt.semantics$default(r23, false, (Function1) r25, 1, null);
        boolean r28 = (((r14.changedInstance(r21) | r14.changedInstance(r13)) | r14.changedInstance(r18)) | r14.changed(r12)) | r14.changedInstance(r22);
        Object r41 = r14.rememberedValue();
        if (r28 == false) goto L103;
    L104:
        r41 = new t5(r21, r13, r18, r12, r22);
        r14.updateRememberedValue(r41);
    L105:
        AnimatedContentKt.AnimatedContent(r24, r111, (Function1) r41, null, "DatePickerDisplayModeAnimation", null, ComposableLambdaKt.rememberComposableLambda(1838500091, true, new DatePickerKt$SwitchableDateEntryContent$3(r26, r27, r30, r31, r32, r33, r34, r35, r36, r37), r14, 54), r14, ((r19 >> 6) & 14) | 1597440, 40);
        if (ComposerKt.isTraceInProgress() == false) goto L109;
        ComposerKt.traceEventEnd();
        goto L109
    L103:
        if (r41 != r110.getEmpty()) goto L105;
    L88:
        if ((r3 & 3) != 2) goto L91;
        r0 = false;
        goto L93
    L80:
        if (r14.changed(r37) == true) goto L83;
        r2 = 2;
    L83:
        r3 = r40 | r2;
        goto L86
    L5:
        if (r14.changed(r26) == false) goto L7;
        int r42 = 4;
    L8:
        r1 = r42 | r39;
        goto L11
    L7:
        r42 = 2;
        goto L8
    }

    /* JADX INFO: renamed from: access$SwitchableDateEntryContent-KaiTk9E, reason: not valid java name */
    public static final /* synthetic */ void m2587access$SwitchableDateEntryContentKaiTk9E(Long r0, long r1, int r3, Function1 r4, Function1 r5, CalendarModel r6, IntRange r7, DatePickerFormatter r8, SelectableDates r9, DatePickerColors r10, FocusRequester r11, Composer r12, int r13, int r14) {
        m2586SwitchableDateEntryContentKaiTk9E(r0, r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14);
    }
}
