package androidx.compose.material3;

import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.autofill.HintConstants;
import androidx.collection.IntList;
import androidx.collection.IntListKt;
import androidx.collection.MutableIntList;
import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.FocusableKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.BasicTextFieldKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material3.internal.AccessibilityServiceStateProvider_androidKt;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.material3.tokens.TimeInputTokens;
import androidx.compose.material3.tokens.TimePickerTokens;
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
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.Ref;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpOffset;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.CharsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000Ü\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a5\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0004\b\n\u0010\u000b\u001a)\u0010\f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\r\u001a+\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0007¢\u0006\u0002\u0010\u0014\u001a \u0010\u0017\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0007\u001a3\u0010\u001b\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020!H\u0002¢\u0006\u0004\b\"\u0010#\u001aJ\u0010$\u001a\u00020\u0001*\u00020%2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020\u00132\u0006\u0010 \u001a\u00020!2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001d0(H\u0082@¢\u0006\u0004\b)\u0010*\u001a1\u0010/\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020%2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0013H\u0001¢\u0006\u0002\u00100\u001a1\u00101\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020%2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0013H\u0001¢\u0006\u0002\u00100\u001a%\u00102\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0003H\u0003¢\u0006\u0002\u00103\u001a\u001d\u00104\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0003¢\u0006\u0002\u00105\u001a\u001d\u00106\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0003¢\u0006\u0002\u00105\u001a\u001d\u00107\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0003¢\u0006\u0002\u00105\u001a%\u00108\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0003¢\u0006\u0002\u00109\u001a%\u0010:\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0003¢\u0006\u0002\u00109\u001a=\u0010;\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020?H\u0003¢\u0006\u0002\u0010A\u001aQ\u0010B\u001a\u00020\u00012\u0006\u0010C\u001a\u00020\u00132\u0006\u0010D\u001a\u00020?2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00010F2\u0006\u0010\u0006\u001a\u00020\u00072\u001c\u0010G\u001a\u0018\u0012\u0004\u0012\u00020I\u0012\u0004\u0012\u00020\u00010H¢\u0006\u0002\bJ¢\u0006\u0002\bKH\u0003¢\u0006\u0002\u0010L\u001a\u0015\u0010M\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0003¢\u0006\u0002\u0010N\u001a7\u0010O\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010P\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010Q\u001a\u00020R2\u0006\u0010\u0006\u001a\u00020\u0007H\u0003¢\u0006\u0004\bS\u0010T\u001a-\u0010U\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020%2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0013H\u0001¢\u0006\u0002\u0010V\u001a\u001c\u0010W\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0002\u001a\u00020%2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002\u001a-\u0010X\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020%2\u0006\u0010P\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u0013H\u0003¢\u0006\u0002\u0010Y\u001ah\u0010Z\u001a\u00020\u00012\u0006\u0010Q\u001a\u00020R2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010P\u001a\u00020[2\u0006\u0010\\\u001a\u00020[2\u0006\u0010]\u001a\u00020\u00102\f\u0010^\u001a\b\u0012\u0004\u0012\u00020\u00130_2!\u0010`\u001a\u001d\u0012\u0013\u0012\u00110[¢\u0006\f\ba\u0012\b\bb\u0012\u0004\b\b(P\u0012\u0004\u0012\u00020\u00010HH\u0002¢\u0006\u0004\bc\u0010d\u001a_\u0010e\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010P\u001a\u00020[2\u0012\u0010f\u001a\u000e\u0012\u0004\u0012\u00020[\u0012\u0004\u0012\u00020\u00010H2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010Q\u001a\u00020R2\b\b\u0002\u0010g\u001a\u00020h2\b\b\u0002\u0010i\u001a\u00020j2\u0006\u0010\u0006\u001a\u00020\u0007H\u0003¢\u0006\u0004\bk\u0010l\u001a4\u0010m\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010n\u001a\u00020\u001d2\u0011\u0010G\u001a\r\u0012\u0004\u0012\u00020\u00010F¢\u0006\u0002\bJH\u0003¢\u0006\u0002\u0010o\u001a'\u0010p\u001a\u00020q2\u0006\u0010Q\u001a\u00020R2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010r\u001a\u00020\u0010H\u0001¢\u0006\u0004\bs\u0010t\u001a(\u0010u\u001a\u00020\u001d2\u0006\u0010v\u001a\u00020\u001d2\u0006\u0010w\u001a\u00020\u001d2\u0006\u0010x\u001a\u00020\u00102\u0006\u0010y\u001a\u00020\u0010H\u0002\u001a\u0018\u0010z\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002\u001a\u0016\u0010\u009d\u0001\u001a\u00020\u0005*\u00020\u00052\u0007\u0010\u009d\u0001\u001a\u00020\u0013H\u0003\"\u0015\u0010\u0015\u001a\u00020\u0013*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\"\u0018\u0010\u0018\u001a\u00020\u0010*\u00020\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a\"\u0018\u0010+\u001a\u00020,*\u00020%8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.\"\u001a\u0010{\u001a\u00020\t8AX\u0080\u0004¢\u0006\f\u0012\u0004\b|\u0010}\u001a\u0004\b~\u0010\u007f\"\u000f\u0010\u0080\u0001\u001a\u00020\u001dX\u0082T¢\u0006\u0002\n\u0000\"\u000f\u0010\u0081\u0001\u001a\u00020\u001dX\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0082\u0001\u001a\u00030\u0083\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000f\u0010\u0084\u0001\u001a\u00020\u001dX\u0082T¢\u0006\u0002\n\u0000\"\u000f\u0010\u0085\u0001\u001a\u00020\u001dX\u0082T¢\u0006\u0002\n\u0000\"\u000f\u0010\u0086\u0001\u001a\u00020\u001dX\u0082T¢\u0006\u0002\n\u0000\"\u000f\u0010\u0087\u0001\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000f\u0010\u0088\u0001\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\u0089\u0001\u001a\u00030\u008a\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u008b\u0001\"\u0013\u0010\u008c\u0001\u001a\u00030\u008a\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u008b\u0001\"\u0013\u0010\u008d\u0001\u001a\u00030\u008a\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u008b\u0001\"\u0013\u0010\u008e\u0001\u001a\u00030\u008a\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u008b\u0001\"\u0013\u0010\u008f\u0001\u001a\u00030\u008a\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u008b\u0001\"\u0013\u0010\u0090\u0001\u001a\u00030\u008a\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u008b\u0001\"\u0013\u0010\u0091\u0001\u001a\u00030\u008a\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u008b\u0001\"\u0010\u0010\u0092\u0001\u001a\u00030\u0093\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0094\u0001\u001a\u00030\u0093\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0095\u0001\u001a\u00030\u0093\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\u0096\u0001\u001a\u00030\u008a\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u008b\u0001\"\u0013\u0010\u0097\u0001\u001a\u00030\u008a\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u008b\u0001\"\u0013\u0010\u0098\u0001\u001a\u00030\u008a\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u008b\u0001\"\u0013\u0010\u0099\u0001\u001a\u00030\u008a\u0001X\u0082\u0004¢\u0006\u0005\n\u0003\u0010\u008b\u0001\"\u001b\u0010\u009a\u0001\u001a\u00030\u008a\u0001X\u0080\u0004¢\u0006\r\n\u0003\u0010\u008b\u0001\u001a\u0006\b\u009b\u0001\u0010\u009c\u0001¨\u0006\u009e\u0001²\u0006\u000b\u0010\u009f\u0001\u001a\u00020\u0013X\u008a\u0084\u0002²\u0006\u000b\u0010 \u0001\u001a\u00020[X\u008a\u008e\u0002²\u0006\u000b\u0010¡\u0001\u001a\u00020[X\u008a\u008e\u0002²\u0006\u000b\u0010 \u001a\u00030¢\u0001X\u008a\u008e\u0002²\u0006\u000b\u0010£\u0001\u001a\u00020!X\u008a\u008e\u0002²\u0006\f\u0010¤\u0001\u001a\u00030¥\u0001X\u008a\u008e\u0002²\u0006\u000b\u0010¦\u0001\u001a\u00020\u0013X\u008a\u0084\u0002"}, d2 = {"TimePicker", "", "state", "Landroidx/compose/material3/TimePickerState;", "modifier", "Landroidx/compose/ui/Modifier;", "colors", "Landroidx/compose/material3/TimePickerColors;", "layoutType", "Landroidx/compose/material3/TimePickerLayoutType;", "TimePicker-mT9BvqQ", "(Landroidx/compose/material3/TimePickerState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TimePickerColors;ILandroidx/compose/runtime/Composer;II)V", "TimeInput", "(Landroidx/compose/material3/TimePickerState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TimePickerColors;Landroidx/compose/runtime/Composer;II)V", "rememberTimePickerState", "initialHour", "", "initialMinute", "is24Hour", "", "(IIZLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TimePickerState;", "isPm", "(Landroidx/compose/material3/TimePickerState;)Z", "TimePickerState", "hourForDisplay", "getHourForDisplay", "(Landroidx/compose/material3/TimePickerState;)I", "moveSelector", "x", "", "y", "maxDist", "center", "Landroidx/compose/ui/unit/IntOffset;", "moveSelector-d3b8Pxo", "(Landroidx/compose/material3/TimePickerState;FFFJ)V", "onTap", "Landroidx/compose/material3/AnalogTimePickerState;", "autoSwitchToMinute", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "onTap-uYHVD98", "(Landroidx/compose/material3/AnalogTimePickerState;FFFZJLandroidx/compose/animation/core/AnimationSpec;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectorPos", "Landroidx/compose/ui/unit/DpOffset;", "getSelectorPos", "(Landroidx/compose/material3/AnalogTimePickerState;)J", "VerticalTimePicker", "(Landroidx/compose/material3/AnalogTimePickerState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TimePickerColors;ZLandroidx/compose/runtime/Composer;II)V", "HorizontalTimePicker", "TimeInputImpl", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TimePickerColors;Landroidx/compose/material3/TimePickerState;Landroidx/compose/runtime/Composer;I)V", "HorizontalClockDisplay", "(Landroidx/compose/material3/TimePickerState;Landroidx/compose/material3/TimePickerColors;Landroidx/compose/runtime/Composer;I)V", "VerticalClockDisplay", "ClockDisplayNumbers", "HorizontalPeriodToggle", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TimePickerState;Landroidx/compose/material3/TimePickerColors;Landroidx/compose/runtime/Composer;I)V", "VerticalPeriodToggle", "PeriodToggleImpl", "measurePolicy", "Landroidx/compose/ui/layout/MeasurePolicy;", "startShape", "Landroidx/compose/ui/graphics/Shape;", "endShape", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TimePickerState;Landroidx/compose/material3/TimePickerColors;Landroidx/compose/ui/layout/MeasurePolicy;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/runtime/Composer;I)V", "ToggleItem", "checked", "shape", "onClick", "Lkotlin/Function0;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(ZLandroidx/compose/ui/graphics/Shape;Lkotlin/jvm/functions/Function0;Landroidx/compose/material3/TimePickerColors;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "DisplaySeparator", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "TimeSelector", "value", "selection", "Landroidx/compose/material3/TimePickerSelectionMode;", "TimeSelector-SAnMeKU", "(Landroidx/compose/ui/Modifier;ILandroidx/compose/material3/TimePickerState;ILandroidx/compose/material3/TimePickerColors;Landroidx/compose/runtime/Composer;I)V", "ClockFace", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/AnalogTimePickerState;Landroidx/compose/material3/TimePickerColors;ZLandroidx/compose/runtime/Composer;I)V", "drawSelector", "ClockText", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/AnalogTimePickerState;IZLandroidx/compose/runtime/Composer;I)V", "timeInputOnChange", "Landroidx/compose/ui/text/input/TextFieldValue;", "prevValue", "max", "userOverride", "Landroidx/compose/ui/node/Ref;", "onNewValue", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "timeInputOnChange-_K77t-0", "(ILandroidx/compose/material3/TimePickerState;Landroidx/compose/ui/text/input/TextFieldValue;Landroidx/compose/ui/text/input/TextFieldValue;ILandroidx/compose/ui/node/Ref;Lkotlin/jvm/functions/Function1;)V", "TimePickerTextField", "onValueChange", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "TimePickerTextField-1vLObsk", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/TimePickerState;ILandroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;Landroidx/compose/material3/TimePickerColors;Landroidx/compose/runtime/Composer;II)V", "CircularLayout", "radiusToSizeRatio", "(Landroidx/compose/ui/Modifier;FLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "numberContentDescription", "", "number", "numberContentDescription-dSwYdS4", "(IZILandroidx/compose/runtime/Composer;I)Ljava/lang/String;", "dist", "x1", "y1", "x2", "y2", "atan", "defaultTimePickerLayoutType", "getDefaultTimePickerLayoutType$annotations", "()V", "getDefaultTimePickerLayoutType", "(Landroidx/compose/runtime/Composer;I)I", "FullCircle", "HalfCircle", "QuarterCircle", "", "RadiansPerMinute", "RadiansPerHour", "SeparatorZIndex", "OuterCircleToSizeRatio", "InnerCircleToSizeRatio", "ClockDisplayBottomMargin", "Landroidx/compose/ui/unit/Dp;", "F", "ClockFaceBottomMargin", "DisplaySeparatorWidth", "SupportLabelTop", "TimeInputBottomPadding", "MaxDistance", "MinimumInteractiveSize", "Minutes", "Landroidx/collection/IntList;", "Hours", "ExtraHours", "PeriodToggleMargin", "TimePickerMaxHeight", "TimePickerMidHeight", "ClockDialMidContainerSize", "ClockDialMinContainerSize", "getClockDialMinContainerSize", "()F", "visible", "material3", "a11yServicesEnabled", "hourValue", "minuteValue", "Landroidx/compose/ui/geometry/Offset;", "parentCenter", "boundsInParent", "Landroidx/compose/ui/geometry/Rect;", "selected"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TimePickerKt {
    private static final float ClockDialMidContainerSize = 0.0f;
    private static final float ClockDialMinContainerSize = 0.0f;
    private static final float ClockDisplayBottomMargin = 0.0f;
    private static final float ClockFaceBottomMargin = 0.0f;
    private static final float DisplaySeparatorWidth = 0.0f;
    private static final IntList ExtraHours = null;
    private static final float FullCircle = 6.2831855f;
    private static final float HalfCircle = 3.1415927f;
    private static final IntList Hours = null;
    private static final float InnerCircleToSizeRatio = 0.0f;
    private static final float MaxDistance = 0.0f;
    private static final float MinimumInteractiveSize = 0.0f;
    private static final IntList Minutes = null;
    private static final float OuterCircleToSizeRatio = 0.0f;
    private static final float PeriodToggleMargin = 0.0f;
    private static final double QuarterCircle = 1.5707963267948966d;
    private static final float RadiansPerHour = 0.5235988f;
    private static final float RadiansPerMinute = 0.10471976f;
    private static final float SeparatorZIndex = 2.0f;
    private static final float SupportLabelTop = 0.0f;
    private static final float TimeInputBottomPadding = 0.0f;
    private static final float TimePickerMaxHeight = 0.0f;
    private static final float TimePickerMidHeight = 0.0f;

    /* JADX INFO: renamed from: androidx.compose.material3.TimePickerKt$ClockFace$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class C02811 implements Function3<IntList, Composer, Integer, Unit> {
        final /* synthetic */ boolean $autoSwitchToMinute;
        final /* synthetic */ TimePickerColors $colors;
        final /* synthetic */ AnalogTimePickerState $state;

        public C02811(TimePickerColors r1, AnalogTimePickerState r2, boolean r3) {
            this.$colors = r1;
            this.$state = r2;
            this.$autoSwitchToMinute = r3;
        }

        public static /* synthetic */ Unit a(SemanticsPropertyReceiver r0) {
            return invoke$lambda$1$lambda$0(r0);
        }

        private static final Unit invoke$lambda$1$lambda$0(SemanticsPropertyReceiver r0) {
            SemanticsPropertiesKt.selectableGroup(r0);
            return Unit.INSTANCE;
        }

        public final void invoke(final IntList r11, Composer r12, int r13) {
            if (ComposerKt.isTraceInProgress() == false) goto L5;
            ComposerKt.traceEventStart(747010833, r13, -1, "androidx.compose.material3.ClockFace.<anonymous> (TimePicker.kt:1609)");
        L5:
            Modifier r14 = SizeKt.m1014size3ABfNKs(Modifier.Companion, TimePickerTokens.INSTANCE.getClockDialContainerSize-D9Ej5fM());
            Object r0 = r12.rememberedValue();
            if (r0 != Composer.Companion.getEmpty()) goto L8;
            r0 = new bw();
            r12.updateRememberedValue(r0);
        L8:
            Modifier r4 = SemanticsModifierKt.semantics$default(r14, false, (Function1) r0, 1, null);
            float r5 = TimePickerKt.access$getOuterCircleToSizeRatio$p();
            final TimePickerColors r1 = this.$colors;
            final AnalogTimePickerState r2 = this.$state;
            final boolean r3 = this.$autoSwitchToMinute;
            TimePickerKt.access$CircularLayout(r4, r5, ComposableLambdaKt.rememberComposableLambda(-99063847, true, new AnonymousClass2(r1, r11, r2, r3), r12, 54), r12, 432, 0);
            if (ComposerKt.isTraceInProgress() == false) goto L12;
            ComposerKt.traceEventEnd();
            return;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
            invoke((IntList) r1, (Composer) r2, ((Number) r3).intValue());
            return Unit.INSTANCE;
        }
    }

    public static /* synthetic */ Unit A(int r0, TimePickerState r1) {
        return TimeSelector_SAnMeKU$lambda$58$lambda$57(r0, r1);
    }

    public static /* synthetic */ Unit B(Modifier r0, AnalogTimePickerState r1, TimePickerColors r2, boolean r3, int r4, Composer r5, int r6) {
        return ClockFace$lambda$60(r0, r1, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ boolean C(AnalogTimePickerState r0, Density r1, MutableState r2) {
        return ClockText$lambda$74$lambda$73(r0, r1, r2);
    }

    private static final Unit CircularLayout$lambda$96(Modifier r6, float r7, Function2 r8, int r9, int r10, Composer r11, int r12) {
        CircularLayout(r6, r7, r8, r11, RecomposeScopeImplKt.updateChangedFlags(r9 | 1), r10);
        return Unit.INSTANCE;
    }

    private static final Unit ClockDisplayNumbers$lambda$35(TimePickerState r0, TimePickerColors r1, int r2, Composer r3, int r4) {
        ClockDisplayNumbers(r0, r1, r3, RecomposeScopeImplKt.updateChangedFlags(r2 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit ClockFace$lambda$60(Modifier r6, AnalogTimePickerState r7, TimePickerColors r8, boolean r9, int r10, Composer r11, int r12) {
        ClockFace(r6, r7, r8, r9, r11, RecomposeScopeImplKt.updateChangedFlags(r10 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit ClockText$lambda$84(Modifier r6, AnalogTimePickerState r7, int r8, boolean r9, int r10, Composer r11, int r12) {
        ClockText(r6, r7, r8, r9, r11, RecomposeScopeImplKt.updateChangedFlags(r10 | 1));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit D(Modifier r0, TimePickerColors r1, TimePickerState r2, int r3, Composer r4, int r5) {
        return TimeInputImpl$lambda$28(r0, r1, r2, r3, r4, r5);
    }

    private static final Unit DisplaySeparator$lambda$54(Modifier r0, int r1, Composer r2, int r3) {
        DisplaySeparator(r0, r2, RecomposeScopeImplKt.updateChangedFlags(r1 | 1));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit E(TimePickerState r0, Modifier r1, TimePickerColors r2, int r3, int r4, Composer r5, int r6) {
        return TimeInput$lambda$5(r0, r1, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ Unit F(String r0, SemanticsPropertyReceiver r1) {
        return ClockText$lambda$83$lambda$82$lambda$81(r0, r1);
    }

    public static /* synthetic */ Unit G(Modifier r0, int r1, TimePickerState r2, int r3, TimePickerColors r4, int r5, Composer r6, int r7) {
        return TimeSelector_SAnMeKU$lambda$59(r0, r1, r2, r3, r4, r5, r6, r7);
    }

    public static /* synthetic */ Unit H(SemanticsPropertyReceiver r0) {
        return DisplaySeparator$lambda$52$lambda$51(r0);
    }

    private static final Unit HorizontalClockDisplay$lambda$31(TimePickerState r0, TimePickerColors r1, int r2, Composer r3, int r4) {
        HorizontalClockDisplay(r0, r1, r3, RecomposeScopeImplKt.updateChangedFlags(r2 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit HorizontalPeriodToggle$lambda$37(Modifier r0, TimePickerState r1, TimePickerColors r2, int r3, Composer r4, int r5) {
        HorizontalPeriodToggle(r0, r1, r2, r4, RecomposeScopeImplKt.updateChangedFlags(r3 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit HorizontalTimePicker$lambda$15(AnalogTimePickerState r7, Modifier r8, TimePickerColors r9, boolean r10, int r11, int r12, Composer r13, int r14) {
        HorizontalTimePicker(r7, r8, r9, r10, r13, RecomposeScopeImplKt.updateChangedFlags(r11 | 1), r12);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit I(SemanticsPropertyReceiver r0) {
        return TimePickerTextField_1vLObsk$lambda$92$lambda$91$lambda$90(r0);
    }

    public static /* synthetic */ Unit J(TimePickerState r0, Modifier r1, TimePickerColors r2, int r3, int r4, int r5, Composer r6, int r7) {
        return TimePicker_mT9BvqQ$lambda$4(r0, r1, r2, r3, r4, r5, r6, r7);
    }

    public static /* synthetic */ Unit K(String r0, SemanticsPropertyReceiver r1) {
        return TimePickerTextField_1vLObsk$lambda$92$lambda$89$lambda$88$lambda$87(r0, r1);
    }

    public static /* synthetic */ Unit L(TimePickerState r0, TimePickerColors r1, int r2, Composer r3, int r4) {
        return HorizontalClockDisplay$lambda$31(r0, r1, r2, r3, r4);
    }

    private static final Unit PeriodToggleImpl$lambda$47(Modifier r9, TimePickerState r10, TimePickerColors r11, MeasurePolicy r12, Shape r13, Shape r14, int r15, Composer r16, int r17) {
        PeriodToggleImpl(r9, r10, r11, r12, r13, r14, r16, RecomposeScopeImplKt.updateChangedFlags(r15 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit TimeInput$lambda$5(TimePickerState r6, Modifier r7, TimePickerColors r8, int r9, int r10, Composer r11, int r12) {
        TimeInput(r6, r7, r8, r11, RecomposeScopeImplKt.updateChangedFlags(r9 | 1), r10);
        return Unit.INSTANCE;
    }

    private static final Unit TimeInputImpl$lambda$28(Modifier r0, TimePickerColors r1, TimePickerState r2, int r3, Composer r4, int r5) {
        TimeInputImpl(r0, r1, r2, r4, RecomposeScopeImplKt.updateChangedFlags(r3 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit TimePickerTextField_1vLObsk$lambda$94(Modifier r12, TextFieldValue r13, Function1 r14, TimePickerState r15, int r16, KeyboardOptions r17, KeyboardActions r18, TimePickerColors r19, int r20, int r21, Composer r22, int r23) {
        m3407TimePickerTextField1vLObsk(r12, r13, r14, r15, r16, r17, r18, r19, r22, RecomposeScopeImplKt.updateChangedFlags(r20 | 1), r21);
        return Unit.INSTANCE;
    }

    private static final Unit TimePicker_mT9BvqQ$lambda$4(TimePickerState r7, Modifier r8, TimePickerColors r9, int r10, int r11, int r12, Composer r13, int r14) {
        m3406TimePickermT9BvqQ(r7, r8, r9, r10, r13, RecomposeScopeImplKt.updateChangedFlags(r11 | 1), r12);
        return Unit.INSTANCE;
    }

    private static final Unit TimeSelector_SAnMeKU$lambda$59(Modifier r7, int r8, TimePickerState r9, int r10, TimePickerColors r11, int r12, Composer r13, int r14) {
        m3408TimeSelectorSAnMeKU(r7, r8, r9, r10, r11, r13, RecomposeScopeImplKt.updateChangedFlags(r12 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit ToggleItem$lambda$50(boolean r7, Shape r8, Function0 r9, TimePickerColors r10, Function3 r11, int r12, Composer r13, int r14) {
        ToggleItem(r7, r8, r9, r10, r11, r13, RecomposeScopeImplKt.updateChangedFlags(r12 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit VerticalClockDisplay$lambda$34(TimePickerState r0, TimePickerColors r1, int r2, Composer r3, int r4) {
        VerticalClockDisplay(r0, r1, r3, RecomposeScopeImplKt.updateChangedFlags(r2 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit VerticalPeriodToggle$lambda$39(Modifier r0, TimePickerState r1, TimePickerColors r2, int r3, Composer r4, int r5) {
        VerticalPeriodToggle(r0, r1, r2, r4, RecomposeScopeImplKt.updateChangedFlags(r3 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit VerticalTimePicker$lambda$11(AnalogTimePickerState r7, Modifier r8, TimePickerColors r9, boolean r10, int r11, int r12, Composer r13, int r14) {
        VerticalTimePicker(r7, r8, r9, r10, r13, RecomposeScopeImplKt.updateChangedFlags(r11 | 1), r12);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(boolean r0, Shape r1, Function0 r2, TimePickerColors r3, Function3 r4, int r5, Composer r6, int r7) {
        return ToggleItem$lambda$50(r0, r1, r2, r3, r4, r5, r6, r7);
    }

    public static /* synthetic */ Unit b(MutableState r0, MutableState r1, MutableState r2, LayoutCoordinates r3) {
        return ClockText$lambda$77$lambda$76(r0, r1, r2, r3);
    }

    public static /* synthetic */ boolean c(CoroutineScope r0, AnalogTimePickerState r1, float r2, boolean r3, MutableState r4, MutableState r5) {
        return ClockText$lambda$80$lambda$79$lambda$78(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ MutableState d(TimePickerState r0) {
        return TimeInputImpl$lambda$21$lambda$20(r0);
    }

    public static /* synthetic */ Unit e(TimePickerState r0, TimePickerColors r1, int r2, Composer r3, int r4) {
        return VerticalClockDisplay$lambda$34(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ Unit f(AnalogTimePickerState r0, TimePickerColors r1, ContentDrawScope r2) {
        return drawSelector$lambda$61(r0, r1, r2);
    }

    public static /* synthetic */ Unit g(Modifier r0, AnalogTimePickerState r1, int r2, boolean r3, int r4, Composer r5, int r6) {
        return ClockText$lambda$84(r0, r1, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ void getDefaultTimePickerLayoutType$annotations() {
    }

    public static /* synthetic */ Unit h(SemanticsPropertyReceiver r0) {
        return VerticalTimePicker$lambda$9$lambda$8(r0);
    }

    public static /* synthetic */ Unit i(SemanticsPropertyReceiver r0) {
        return HorizontalTimePicker$lambda$13$lambda$12(r0);
    }

    public static /* synthetic */ Unit j(String r0, SemanticsPropertyReceiver r1) {
        return TimeSelector_SAnMeKU$lambda$56$lambda$55(r0, r1);
    }

    public static /* synthetic */ Unit k(CoroutineScope r0, AnalogTimePickerState r1, float r2, boolean r3, MutableState r4, MutableState r5, State r6, SemanticsPropertyReceiver r7) {
        return ClockText$lambda$80$lambda$79(r0, r1, r2, r3, r4, r5, r6, r7);
    }

    public static /* synthetic */ Unit l(boolean r0, SemanticsPropertyReceiver r1) {
        return ToggleItem$lambda$49$lambda$48(r0, r1);
    }

    public static /* synthetic */ Unit m(TimePickerState r0) {
        return PeriodToggleImpl$lambda$46$lambda$45$lambda$44(r0);
    }

    public static /* synthetic */ Unit n(Modifier r0, int r1, Composer r2, int r3) {
        return DisplaySeparator$lambda$54(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit o(Modifier r0, TimePickerState r1, TimePickerColors r2, int r3, Composer r4, int r5) {
        return HorizontalPeriodToggle$lambda$37(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ TimePickerStateImpl p(int r0, int r1, boolean r2) {
        return rememberTimePickerState$lambda$7$lambda$6(r0, r1, r2);
    }

    public static /* synthetic */ MutableState q(TimePickerState r0) {
        return TimeInputImpl$lambda$17$lambda$16(r0);
    }

    public static /* synthetic */ Unit r(AnalogTimePickerState r0, Modifier r1, TimePickerColors r2, boolean r3, int r4, int r5, Composer r6, int r7) {
        return VerticalTimePicker$lambda$11(r0, r1, r2, r3, r4, r5, r6, r7);
    }

    public static /* synthetic */ Unit s(TimePickerState r0, TimePickerColors r1, int r2, Composer r3, int r4) {
        return ClockDisplayNumbers$lambda$35(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ Unit t(TimePickerState r0) {
        return PeriodToggleImpl$lambda$46$lambda$43$lambda$42(r0);
    }

    public static /* synthetic */ Unit u(Modifier r0, TimePickerState r1, TimePickerColors r2, int r3, Composer r4, int r5) {
        return VerticalPeriodToggle$lambda$39(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ Unit v(Modifier r0, TimePickerState r1, TimePickerColors r2, MeasurePolicy r3, Shape r4, Shape r5, int r6, Composer r7, int r8) {
        return PeriodToggleImpl$lambda$47(r0, r1, r2, r3, r4, r5, r6, r7, r8);
    }

    public static /* synthetic */ Unit w(String r0, SemanticsPropertyReceiver r1) {
        return PeriodToggleImpl$lambda$41$lambda$40(r0, r1);
    }

    public static /* synthetic */ Unit x(Modifier r0, TextFieldValue r1, Function1 r2, TimePickerState r3, int r4, KeyboardOptions r5, KeyboardActions r6, TimePickerColors r7, int r8, int r9, Composer r10, int r11) {
        return TimePickerTextField_1vLObsk$lambda$94(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
    }

    public static /* synthetic */ Unit y(Modifier r0, float r1, Function2 r2, int r3, int r4, Composer r5, int r6) {
        return CircularLayout$lambda$96(r0, r1, r2, r3, r4, r5, r6);
    }

    public static /* synthetic */ Unit z(AnalogTimePickerState r0, Modifier r1, TimePickerColors r2, boolean r3, int r4, int r5, Composer r6, int r7) {
        return HorizontalTimePicker$lambda$15(r0, r1, r2, r3, r4, r5, r6, r7);
    }

    static {
        float r0 = Dp.constructor-impl(101);
        TimePickerTokens r1 = TimePickerTokens.INSTANCE;
        OuterCircleToSizeRatio = r0 / r1.getClockDialContainerSize-D9Ej5fM();
        InnerCircleToSizeRatio = Dp.constructor-impl(69) / r1.getClockDialContainerSize-D9Ej5fM();
        ClockDisplayBottomMargin = Dp.constructor-impl(36);
        float r2 = 24;
        ClockFaceBottomMargin = Dp.constructor-impl(r2);
        DisplaySeparatorWidth = Dp.constructor-impl(r2);
        SupportLabelTop = Dp.constructor-impl(7);
        TimeInputBottomPadding = Dp.constructor-impl(r2);
        MaxDistance = Dp.constructor-impl(74);
        MinimumInteractiveSize = Dp.constructor-impl(48);
        Minutes = IntListKt.intListOf(new int[]{0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55});
        IntList r3 = IntListKt.intListOf(new int[]{12, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11});
        Hours = r3;
        MutableIntList r4 = new MutableIntList(r3._size);
        int[] r5 = r3.content;
        int r6 = r3._size;
        int r7 = 0;
    L3:
        if (r7 >= r6) goto L5;
        r4.add((r5[r7] % 12) + 12);
        r7 = r7 + 1;
        goto L3
    L5:
        ExtraHours = r4;
        PeriodToggleMargin = Dp.constructor-impl(12);
        TimePickerMaxHeight = Dp.constructor-impl(384);
        TimePickerMidHeight = Dp.constructor-impl(330);
        ClockDialMidContainerSize = Dp.constructor-impl(238);
        ClockDialMinContainerSize = Dp.constructor-impl(200);
    }

    public static final /* synthetic */ float access$getClockDialMidContainerSize$p() {
        return ClockDialMidContainerSize;
    }

    public static final /* synthetic */ float access$getDisplaySeparatorWidth$p() {
        return DisplaySeparatorWidth;
    }

    public static final /* synthetic */ IntList access$getExtraHours$p() {
        return ExtraHours;
    }

    public static final /* synthetic */ IntList access$getHours$p() {
        return Hours;
    }

    public static final /* synthetic */ float access$getInnerCircleToSizeRatio$p() {
        return InnerCircleToSizeRatio;
    }

    public static final /* synthetic */ float access$getMaxDistance$p() {
        return MaxDistance;
    }

    public static final /* synthetic */ IntList access$getMinutes$p() {
        return Minutes;
    }

    public static final /* synthetic */ float access$getOuterCircleToSizeRatio$p() {
        return OuterCircleToSizeRatio;
    }

    public static final /* synthetic */ float access$getTimePickerMaxHeight$p() {
        return TimePickerMaxHeight;
    }

    public static final /* synthetic */ float access$getTimePickerMidHeight$p() {
        return TimePickerMidHeight;
    }

    public static final float getClockDialMinContainerSize() {
        return ClockDialMinContainerSize;
    }

    private static final long ClockText$lambda$64(MutableState<Offset> r2) {
        return ((Offset) r2.getValue()).unbox-impl();
    }

    private static final long ClockText$lambda$67(MutableState<IntOffset> r2) {
        return ((IntOffset) r2.getValue()).unbox-impl();
    }

    private static final Rect ClockText$lambda$70(MutableState<Rect> r0) {
        return (Rect) r0.getValue();
    }

    private static final boolean ClockText$lambda$75(State<Boolean> r0) {
        return ((Boolean) r0.getValue()).booleanValue();
    }

    private static final Unit DisplaySeparator$lambda$52$lambda$51(SemanticsPropertyReceiver r0) {
        return Unit.INSTANCE;
    }

    private static final Unit HorizontalTimePicker$lambda$13$lambda$12(SemanticsPropertyReceiver r1) {
        SemanticsPropertiesKt.setTraversalGroup(r1, true);
        return Unit.INSTANCE;
    }

    private static final Unit PeriodToggleImpl$lambda$46$lambda$43$lambda$42(TimePickerState r1) {
        if (isPm(r1) == false) goto L6;
        r1.setHour(r1.getHour() - 12);
    L6:
        return Unit.INSTANCE;
    }

    private static final Unit PeriodToggleImpl$lambda$46$lambda$45$lambda$44(TimePickerState r1) {
        if (isPm(r1) == true) goto L6;
        r1.setHour(r1.getHour() + 12);
    L6:
        return Unit.INSTANCE;
    }

    private static final TextFieldValue TimeInputImpl$hourTextValue(TimePickerState r8) {
        return new TextFieldValue(CalendarLocale_jvmKt.toLocalString$default(getHourForDisplay(r8), 2, 0, false, null, 14, null), 0, null, 6, null);
    }

    private static final MutableState TimeInputImpl$lambda$17$lambda$16(TimePickerState r2) {
        return SnapshotStateKt.mutableStateOf$default(TimeInputImpl$hourTextValue(r2), null, 2, null);
    }

    private static final TextFieldValue TimeInputImpl$lambda$18(MutableState<TextFieldValue> r0) {
        return (TextFieldValue) r0.getValue();
    }

    private static final MutableState TimeInputImpl$lambda$21$lambda$20(TimePickerState r2) {
        return SnapshotStateKt.mutableStateOf$default(TimeInputImpl$minuteTextValue(r2), null, 2, null);
    }

    private static final TextFieldValue TimeInputImpl$lambda$22(MutableState<TextFieldValue> r0) {
        return (TextFieldValue) r0.getValue();
    }

    private static final TextFieldValue TimeInputImpl$minuteTextValue(TimePickerState r8) {
        return new TextFieldValue(CalendarLocale_jvmKt.toLocalString$default(r8.getMinute(), 2, 0, false, null, 14, null), 0, null, 6, null);
    }

    private static final Unit TimePickerTextField_1vLObsk$lambda$92$lambda$91$lambda$90(SemanticsPropertyReceiver r0) {
        return Unit.INSTANCE;
    }

    private static final boolean TimePicker_mT9BvqQ$lambda$0(State<Boolean> r0) {
        return ((Boolean) r0.getValue()).booleanValue();
    }

    private static final Unit VerticalTimePicker$lambda$9$lambda$8(SemanticsPropertyReceiver r1) {
        SemanticsPropertiesKt.setTraversalGroup(r1, true);
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ long access$ClockText$lambda$64(MutableState r2) {
        return ClockText$lambda$64(r2);
    }

    public static final /* synthetic */ long access$ClockText$lambda$67(MutableState r2) {
        return ClockText$lambda$67(r2);
    }

    public static final /* synthetic */ TextFieldValue access$TimeInputImpl$hourTextValue(TimePickerState r0) {
        return TimeInputImpl$hourTextValue(r0);
    }

    public static final /* synthetic */ TextFieldValue access$TimeInputImpl$lambda$18(MutableState r0) {
        return TimeInputImpl$lambda$18(r0);
    }

    public static final /* synthetic */ TextFieldValue access$TimeInputImpl$lambda$22(MutableState r0) {
        return TimeInputImpl$lambda$22(r0);
    }

    public static final /* synthetic */ TextFieldValue access$TimeInputImpl$minuteTextValue(TimePickerState r0) {
        return TimeInputImpl$minuteTextValue(r0);
    }

    public static final int getHourForDisplay(TimePickerState r2) {
        if (r2.is24hour() == false) goto L6;
        return r2.getHour() % 24;
    L6:
        if ((r2.getHour() % 12) != 0) goto L9;
        return 12;
    L9:
        if (isPm(r2) == false) goto L12;
        return r2.getHour() - 12;
    L12:
        return r2.getHour();
    }

    public static final long getSelectorPos(AnalogTimePickerState r6) {
        float r0 = r6.m2285getCurrentDiameterD9Ej5fM();
        TimePickerTokens r1 = TimePickerTokens.INSTANCE;
        float r2 = Dp.constructor-impl(Dp.constructor-impl(r1.getClockDialSelectorHandleContainerSize-D9Ej5fM() / SeparatorZIndex) * (r0 / r1.getClockDialContainerSize-D9Ej5fM()));
        if (r6.is24hour() == true) goto L5;
    L9:
        float r3 = Dp.constructor-impl(r6.m2285getCurrentDiameterD9Ej5fM() * OuterCircleToSizeRatio);
    L10:
        float r4 = Dp.constructor-impl(RangesKt.coerceAtLeast(Dp.box-impl(Dp.constructor-impl(r3 - r2)), Dp.box-impl(Dp.constructor-impl(0))).unbox-impl() + r2);
        float r5 = 2;
        float r7 = Dp.constructor-impl(Dp.constructor-impl(((float) Math.cos(r6.getCurrentAngle())) * r4) + Dp.constructor-impl(r6.m2285getCurrentDiameterD9Ej5fM() / r5));
        float r8 = Dp.constructor-impl(Dp.constructor-impl(r4 * ((float) Math.sin(r6.getCurrentAngle()))) + Dp.constructor-impl(r6.m2285getCurrentDiameterD9Ej5fM() / r5));
        return DpOffset.constructor-impl((Float.floatToRawIntBits(r7) << 32) | (((long) Float.floatToRawIntBits(r8)) & 4294967295L));
    L5:
        if (isPm(r6) == false) goto L9;
        if (TimePickerSelectionMode.m3435equalsimpl0(r6.mo2286getSelectionyecRtBI(), TimePickerSelectionMode.Companion.m3439getHouryecRtBI()) == false) goto L9;
        r3 = Dp.constructor-impl(r6.m2285getCurrentDiameterD9Ej5fM() * InnerCircleToSizeRatio);
        goto L10
    }

    public static final boolean isPm(TimePickerState r1) {
        if (r1.getHour() < 12) goto L5;
        return true;
    L5:
        return false;
    }

    private static final void ClockText$lambda$65(MutableState<Offset> r0, long r1) {
        r0.setValue(Offset.box-impl(r1));
    }

    private static final void ClockText$lambda$68(MutableState<IntOffset> r0, long r1) {
        r0.setValue(IntOffset.box-impl(r1));
    }

    private static final void ClockText$lambda$71(MutableState<Rect> r0, Rect r1) {
        r0.setValue(r1);
    }

    private static final Unit ClockText$lambda$83$lambda$82$lambda$81(String r0, SemanticsPropertyReceiver r1) {
        SemanticsPropertiesKt.setContentDescription(r1, r0);
        return Unit.INSTANCE;
    }

    private static final Unit PeriodToggleImpl$lambda$41$lambda$40(String r1, SemanticsPropertyReceiver r2) {
        SemanticsPropertiesKt.setTraversalGroup(r2, true);
        SemanticsPropertiesKt.setContentDescription(r2, r1);
        return Unit.INSTANCE;
    }

    private static final void TimeInputImpl$lambda$19(MutableState<TextFieldValue> r0, TextFieldValue r1) {
        r0.setValue(r1);
    }

    private static final void TimeInputImpl$lambda$23(MutableState<TextFieldValue> r0, TextFieldValue r1) {
        r0.setValue(r1);
    }

    private static final Unit TimePickerTextField_1vLObsk$lambda$92$lambda$89$lambda$88$lambda$87(String r0, SemanticsPropertyReceiver r1) {
        SemanticsPropertiesKt.setContentDescription(r1, r0);
        return Unit.INSTANCE;
    }

    private static final Unit TimeSelector_SAnMeKU$lambda$56$lambda$55(String r1, SemanticsPropertyReceiver r2) {
        SemanticsPropertiesKt.setRole-kuIjeqM(r2, Role.Companion.getRadioButton-o7Vup1c());
        SemanticsPropertiesKt.setContentDescription(r2, r1);
        return Unit.INSTANCE;
    }

    private static final Unit TimeSelector_SAnMeKU$lambda$58$lambda$57(int r1, TimePickerState r2) {
        if (TimePickerSelectionMode.m3435equalsimpl0(r1, r2.mo2286getSelectionyecRtBI()) == true) goto L6;
        r2.mo2288setSelection6_8s6DQ(r1);
    L6:
        return Unit.INSTANCE;
    }

    private static final Unit ToggleItem$lambda$49$lambda$48(boolean r0, SemanticsPropertyReceiver r1) {
        SemanticsPropertiesKt.setSelected(r1, r0);
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ void access$TimeInputImpl$lambda$19(MutableState r0, TextFieldValue r1) {
        TimeInputImpl$lambda$19(r0, r1);
    }

    public static final /* synthetic */ void access$TimeInputImpl$lambda$23(MutableState r0, TextFieldValue r1) {
        TimeInputImpl$lambda$23(r0, r1);
    }

    public static final /* synthetic */ float access$atan(float r0, float r1) {
        return atan(r0, r1);
    }

    private static final float atan(float r2, float r3) {
        float r4 = ((float) Math.atan2(r2, r3)) - 1.5707964f;
        if (r4 < MenuKt.ClosedAlphaTarget) goto L5;
        return r4;
    L5:
        return r4 + FullCircle;
    }

    public static final int getDefaultTimePickerLayoutType(Composer r3, int r4) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(435687004, r4, -1, "androidx.compose.material3.<get-defaultTimePickerLayoutType> (TimePicker.kt:2051)");
    L5:
        int r5 = TimePicker_androidKt.defaultTimePickerLayoutType(r3, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r5;
    }

    private static final Modifier visible(Modifier r2, final boolean r3) {
        if (InspectableValueKt.isDebugInspectorInfoEnabled() == false) goto L5;
        Function1<InspectorInfo, Unit> r1 = new TimePickerKt$visible$$inlined$debugInspectorInfo$1(r3);
    L7:
        return r2.then(new VisibleModifier(r3, r1));
    L5:
        r1 = InspectableValueKt.getNoInspectorInfo();
        goto L7
    }

    private static final boolean ClockText$lambda$74$lambda$73(AnalogTimePickerState r4, Density r5, MutableState r6) {
        long r0 = getSelectorPos(r4);
        float r7 = r5.toPx-0680j_4(DpOffset.getX-D9Ej5fM(r0));
        float r8 = r5.toPx-0680j_4(DpOffset.getY-D9Ej5fM(r0));
        long r1 = Float.floatToRawIntBits(r7);
        return ClockText$lambda$70(r6).contains-k-4lQ0M(Offset.constructor-impl((((long) Float.floatToRawIntBits(r8)) & 4294967295L) | (r1 << 32)));
    }

    private static final void DisplaySeparator(final Modifier r48, Composer r49, final int r50) {
        Composer r15 = r49.startRestartGroup(2100674302);
        if ((r50 & 6) == 0) goto L5;
        int r3 = r50;
    L11:
        if ((r3 & 3) == 2) goto L13;
        boolean r4 = true;
    L15:
        if (r15.shouldExecute(r4, r3 & 1) == true) goto L17;
        Composer r29 = r15;
        r29.skipToGroupEnd();
    L38:
        ScopeUpdateScope r2 = r29.endRestartGroup();
        if (r2 == null) goto L42;
        r2.updateScope(new pu(r48, r50));
        return;
    L42:
        return;
    L17:
        if (ComposerKt.isTraceInProgress() == false) goto L19;
        ComposerKt.traceEventStart(2100674302, r3, -1, "androidx.compose.material3.DisplaySeparator (TimePicker.kt:1379)");
    L19:
        TextStyle r24 = TextStyle.copy-p1EtxEg$default((TextStyle) r15.consume(TextKt.getLocalTextStyle()), 0, 0, null, null, null, null, null, 0, null, null, null, 0, null, null, null, TextAlign.Companion.getCenter-e0LSkKk(), 0, 0, null, null, new LineHeightStyle(LineHeightStyle.Alignment.Companion.getCenter-PIaL0Z0(), LineHeightStyle.Trim.Companion.getBoth-EVpEnUU(), null), 0, 0, null, 15695871, null);
        Object r5 = r15.rememberedValue();
        if (r5 != Composer.Companion.getEmpty()) goto L22;
        r5 = new zv();
        r15.updateRememberedValue(r5);
    L22:
        Modifier r6 = SemanticsModifierKt.clearAndSetSemantics(r48, (Function1) r5);
        MeasurePolicy r7 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getCenter(), false);
        int r8 = ComposablesKt.getCurrentCompositeKeyHash(r15, 0);
        CompositionLocalMap r9 = r15.getCurrentCompositionLocalMap();
        Modifier r10 = ComposedModifierKt.materializeModifier(r15, r6);
        ComposeUiNode.Companion r11 = ComposeUiNode.Companion;
        Function0 r12 = r11.getConstructor();
        if ((r15.getApplier() instanceof Applier) == true) goto L25;
        ComposablesKt.invalidApplier();
    L25:
        r15.startReusableNode();
        if (r15.getInserting() == false) goto L28;
        r15.createNode(r12);
    L29:
        Composer r13 = Updater.constructor-impl(r15);
        Updater.set-impl(r13, r7, r11.getSetMeasurePolicy());
        Updater.set-impl(r13, r9, r11.getSetResolvedCompositionLocals());
        Function2 r14 = r11.getSetCompositeKeyHash();
        if (r13.getInserting() == false) goto L32;
    L33:
        r13.updateRememberedValue(Integer.valueOf(r8));
        r13.apply(Integer.valueOf(r8), r14);
    L34:
        Updater.set-impl(r13, r10, r11.getSetModifier());
        BoxScopeInstance r16 = BoxScopeInstance.INSTANCE;
        r29 = r15;
        TextKt.m3363TextNvy7gAk(":", null, ColorSchemeKt.getValue(TimeInputTokens.INSTANCE.getTimeFieldSeparatorColor(), r15, 6), null, 0, null, null, null, 0, null, null, 0, 0, false, 0, 0, null, r24, r29, 6, 0, 131066);
        r29.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L38;
        ComposerKt.traceEventEnd();
        goto L38
    L32:
        if (Intrinsics.areEqual(r13.rememberedValue(), Integer.valueOf(r8)) == true) goto L34;
    L28:
        r15.useNode();
        goto L29
    L13:
        r4 = false;
        goto L15
    L5:
        if (r15.changed(r48) == false) goto L7;
        int r17 = 4;
    L8:
        r3 = r17 | r50;
        goto L11
    L7:
        r17 = 2;
        goto L8
    }

    public static final TimePickerState TimePickerState(int r1, int r2, boolean r3) {
        return new TimePickerStateImpl(r1, r2, r3);
    }

    public static final /* synthetic */ void access$DisplaySeparator(Modifier r0, Composer r1, int r2) {
        DisplaySeparator(r0, r1, r2);
    }

    private static final Modifier drawSelector(Modifier r1, final AnalogTimePickerState r2, final TimePickerColors r3) {
        return DrawModifierKt.drawWithContent(r1, new vu(r2, r3));
    }

    private static final Unit drawSelector$lambda$61(AnalogTimePickerState r25, TimePickerColors r26, ContentDrawScope r27) {
        float r0 = r27.toPx-0680j_4(DpOffset.getX-D9Ej5fM(getSelectorPos(r25)));
        float r1 = r27.toPx-0680j_4(DpOffset.getY-D9Ej5fM(getSelectorPos(r25)));
        long r2 = Float.floatToRawIntBits(r0);
        long r10 = Offset.constructor-impl((((long) Float.floatToRawIntBits(r1)) & 4294967295L) | (r2 << 32));
        TimePickerTokens r16 = TimePickerTokens.INSTANCE;
        float r17 = ((r27.toPx-0680j_4(r16.getClockDialSelectorHandleContainerSize-D9Ej5fM()) / SeparatorZIndex) * r27.roundToPx-0680j_4(r25.m2285getCurrentDiameterD9Ej5fM())) / r27.roundToPx-0680j_4(r16.getClockDialContainerSize-D9Ej5fM());
        long r18 = r26.m3380getSelectorColor0d7_KjU();
        long r3 = Color.Companion.getBlack-0d7_KjU();
        BlendMode.Companion r20 = BlendMode.Companion;
        DrawScope.-CC.drawCircle-VaOC9Bg$default(r27, r3, r17, r10, MenuKt.ClosedAlphaTarget, null, null, r20.getClear-0nO6VwU(), 56, null);
        r27.drawContent();
        DrawScope.-CC.drawCircle-VaOC9Bg$default(r27, r18, r17, r10, MenuKt.ClosedAlphaTarget, null, null, r20.getXor-0nO6VwU(), 56, null);
        float r7 = r27.toPx-0680j_4(r16.getClockDialSelectorTrackContainerWidth-D9Ej5fM());
        float r4 = ((float) Math.cos(r25.getCurrentAngle())) * r17;
        float r5 = ((float) Math.sin(r25.getCurrentAngle())) * r17;
        long r6 = Float.floatToRawIntBits(r4);
        DrawScope.-CC.drawLine-NGM6Ib0$default(r27, r18, androidx.compose.ui.geometry.SizeKt.getCenter-uvyYCjk(r27.getSize-NH-jbRc()), Offset.minus-MK-Hz9U(r10, Offset.constructor-impl((((long) Float.floatToRawIntBits(r5)) & 4294967295L) | (r6 << 32))), r7, 0, null, MenuKt.ClosedAlphaTarget, null, r20.getSrcOver-0nO6VwU(), 240, null);
        DrawScope.-CC.drawCircle-VaOC9Bg$default(r27, r18, r27.toPx-0680j_4(r16.getClockDialSelectorCenterContainerSize-D9Ej5fM()) / 2, androidx.compose.ui.geometry.SizeKt.getCenter-uvyYCjk(r27.getSize-NH-jbRc()), MenuKt.ClosedAlphaTarget, null, null, 0, androidx.compose.material.MenuKt.InTransitionDuration, null);
        DrawScope.-CC.drawCircle-VaOC9Bg$default(r27, r26.m3369clockDialContentColorvNxB06k$material3(true), r17, r10, MenuKt.ClosedAlphaTarget, null, null, r20.getDstOver-0nO6VwU(), 56, null);
        return Unit.INSTANCE;
    }

    private static final TimePickerStateImpl rememberTimePickerState$lambda$7$lambda$6(int r1, int r2, boolean r3) {
        return new TimePickerStateImpl(r1, r2, r3);
    }

    private static final void ClockDisplayNumbers(final TimePickerState r7, final TimePickerColors r8, Composer r9, final int r10) {
        Composer r11 = r9.startRestartGroup(-934561141);
        if ((r10 & 6) == 0) goto L5;
        int r1 = r10;
    L14:
        if ((r10 & 48) != 0) goto L21;
        if (r11.changed(r8) == false) goto L18;
        int r3 = 32;
    L19:
        r1 = r1 | r3;
        goto L21
    L18:
        r3 = 16;
    L21:
        if ((r1 & 19) == 18) goto L23;
        boolean r4 = true;
    L25:
        if (r11.shouldExecute(r4, r1 & 1) == true) goto L27;
        r11.skipToGroupEnd();
    L33:
        ScopeUpdateScope r12 = r11.endRestartGroup();
        if (r12 == null) goto L37;
        r12.updateScope(new jv(r7, r8, r10));
        return;
    L37:
        return;
    L27:
        if (ComposerKt.isTraceInProgress() == false) goto L29;
        ComposerKt.traceEventStart(-934561141, r1, -1, "androidx.compose.material3.ClockDisplayNumbers (TimePicker.kt:1173)");
    L29:
        CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{TextKt.getLocalTextStyle().provides(TypographyKt.getValue(TimePickerTokens.INSTANCE.getTimeSelectorLabelTextFont(), r11, 6)), CompositionLocalsKt.getLocalLayoutDirection().provides(LayoutDirection.Ltr)}, ComposableLambdaKt.rememberComposableLambda(-477913269, true, new AnonymousClass1(r7, r8), r11, 54), r11, ProvidedValue.$stable | 48);
        if (ComposerKt.isTraceInProgress() == false) goto L33;
        ComposerKt.traceEventEnd();
        goto L33
    L23:
        r4 = false;
        goto L25
    L5:
        if ((r10 & 8) != 0) goto L7;
        boolean r2 = r11.changed(r7);
    L8:
        if (r2 == false) goto L10;
        int r5 = 4;
    L11:
        r1 = r5 | r10;
        goto L14
    L10:
        r5 = 2;
        goto L11
    L7:
        r2 = r11.changedInstance(r7);
        goto L8
    }

    private static final Unit ClockText$lambda$77$lambda$76(MutableState r2, MutableState r3, MutableState r4, LayoutCoordinates r5) {
        LayoutCoordinates r0 = r5.getParentCoordinates();
        if (r0 == null) goto L5;
        long r1 = IntSizeKt.getCenter-ozmzZPI(r0.getSize-YbymL2g());
    L6:
        ClockText$lambda$68(r2, r1);
        ClockText$lambda$71(r3, LayoutCoordinatesKt.boundsInParent(r5));
        ClockText$lambda$65(r4, ClockText$lambda$70(r3).getCenter-F1C5BW0());
        return Unit.INSTANCE;
    L5:
        r1 = IntOffset.Companion.getZero-nOcc-ac();
        goto L6
    }

    private static final void HorizontalClockDisplay(final TimePickerState r18, final TimePickerColors r19, Composer r20, final int r21) {
        Composer r4 = r20.startRestartGroup(755539561);
        if ((r21 & 6) == 0) goto L5;
        int r5 = r21;
    L14:
        if ((r21 & 48) != 0) goto L21;
        if (r4.changed(r19) == false) goto L18;
        int r6 = 32;
    L19:
        r5 = r5 | r6;
        goto L21
    L18:
        r6 = 16;
    L21:
        if ((r5 & 19) == 18) goto L23;
        boolean r7 = true;
    L25:
        if (r4.shouldExecute(r7, r5 & 1) == true) goto L27;
        r4.skipToGroupEnd();
    L61:
        ScopeUpdateScope r3 = r4.endRestartGroup();
        if (r3 == null) goto L65;
        r3.updateScope(new gv(r18, r19, r21));
        return;
    L65:
        return;
    L27:
        if (ComposerKt.isTraceInProgress() == false) goto L29;
        ComposerKt.traceEventStart(755539561, r5, -1, "androidx.compose.material3.HorizontalClockDisplay (TimePicker.kt:1133)");
    L29:
        Arrangement.HorizontalOrVertical r8 = Arrangement.INSTANCE.getCenter();
        Modifier.Companion r9 = Modifier.Companion;
        Alignment.Companion r10 = Alignment.Companion;
        MeasurePolicy r11 = ColumnKt.columnMeasurePolicy(r8, r10.getStart(), r4, 6);
        int r12 = ComposablesKt.getCurrentCompositeKeyHash(r4, 0);
        CompositionLocalMap r13 = r4.getCurrentCompositionLocalMap();
        Modifier r14 = ComposedModifierKt.materializeModifier(r4, r9);
        ComposeUiNode.Companion r16 = ComposeUiNode.Companion;
        Function0 r15 = r16.getConstructor();
        if ((r4.getApplier() instanceof Applier) == true) goto L32;
        ComposablesKt.invalidApplier();
    L32:
        r4.startReusableNode();
        if (r4.getInserting() == false) goto L35;
        r4.createNode(r15);
    L36:
        Composer r17 = Updater.constructor-impl(r4);
        Updater.set-impl(r17, r11, r16.getSetMeasurePolicy());
        Updater.set-impl(r17, r13, r16.getSetResolvedCompositionLocals());
        Function2 r22 = r16.getSetCompositeKeyHash();
        if (r17.getInserting() == false) goto L39;
    L40:
        r17.updateRememberedValue(Integer.valueOf(r12));
        r17.apply(Integer.valueOf(r12), r22);
    L41:
        Updater.set-impl(r17, r14, r16.getSetModifier());
        ColumnScopeInstance r23 = ColumnScopeInstance.INSTANCE;
        ClockDisplayNumbers(r18, r19, r4, (r5 & 14) | (r5 & 112));
        if (r18.is24hour() == true) goto L56;
        r4.startReplaceGroup(998576161);
        Modifier r24 = PaddingKt.m964paddingqDBjuR0$default(r9, MenuKt.ClosedAlphaTarget, PeriodToggleMargin, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 13, null);
        MeasurePolicy r25 = BoxKt.maybeCachedBoxMeasurePolicy(r10.getTopStart(), false);
        int r26 = ComposablesKt.getCurrentCompositeKeyHash(r4, 0);
        CompositionLocalMap r27 = r4.getCurrentCompositionLocalMap();
        Modifier r28 = ComposedModifierKt.materializeModifier(r4, r24);
        Function0 r110 = r16.getConstructor();
        if ((r4.getApplier() instanceof Applier) == true) goto L46;
        ComposablesKt.invalidApplier();
    L46:
        r4.startReusableNode();
        if (r4.getInserting() == false) goto L49;
        r4.createNode(r110);
    L50:
        Composer r111 = Updater.constructor-impl(r4);
        Updater.set-impl(r111, r25, r16.getSetMeasurePolicy());
        Updater.set-impl(r111, r27, r16.getSetResolvedCompositionLocals());
        Function2 r29 = r16.getSetCompositeKeyHash();
        if (r111.getInserting() == false) goto L53;
    L54:
        r111.updateRememberedValue(Integer.valueOf(r26));
        r111.apply(Integer.valueOf(r26), r29);
    L55:
        Updater.set-impl(r111, r28, r16.getSetModifier());
        BoxScopeInstance r30 = BoxScopeInstance.INSTANCE;
        TimePickerTokens r31 = TimePickerTokens.INSTANCE;
        Modifier r32 = SizeKt.m1016sizeVpY3zN4(r9, r31.getPeriodSelectorHorizontalContainerWidth-D9Ej5fM(), r31.getPeriodSelectorHorizontalContainerHeight-D9Ej5fM());
        int r33 = r5 << 3;
        int r34 = (r33 & 112) | 6;
        HorizontalPeriodToggle(r32, r18, r19, r4, (r33 & 896) | r34);
        r4.endNode();
        r4.endReplaceGroup();
    L57:
        r4.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L61;
        ComposerKt.traceEventEnd();
        goto L61
    L53:
        if (Intrinsics.areEqual(r111.rememberedValue(), Integer.valueOf(r26)) == true) goto L55;
    L49:
        r4.useNode();
        goto L50
    L56:
        r4.startReplaceGroup(999020143);
        r4.endReplaceGroup();
        goto L57
    L39:
        if (Intrinsics.areEqual(r17.rememberedValue(), Integer.valueOf(r12)) == true) goto L41;
    L35:
        r4.useNode();
        goto L36
    L23:
        r7 = false;
        goto L25
    L5:
        if ((r21 & 8) != 0) goto L7;
        boolean r35 = r4.changed(r18);
    L8:
        if (r35 == false) goto L10;
        int r36 = 4;
    L11:
        r5 = r36 | r21;
        goto L14
    L10:
        r36 = 2;
        goto L11
    L7:
        r35 = r4.changedInstance(r18);
        goto L8
    }

    private static final void VerticalClockDisplay(final TimePickerState r18, final TimePickerColors r19, Composer r20, final int r21) {
        Composer r4 = r20.startRestartGroup(2054675515);
        if ((r21 & 6) == 0) goto L5;
        int r5 = r21;
    L14:
        if ((r21 & 48) != 0) goto L21;
        if (r4.changed(r19) == false) goto L18;
        int r6 = 32;
    L19:
        r5 = r5 | r6;
        goto L21
    L18:
        r6 = 16;
    L21:
        if ((r5 & 19) == 18) goto L23;
        boolean r7 = true;
    L25:
        if (r4.shouldExecute(r7, r5 & 1) == true) goto L27;
        r4.skipToGroupEnd();
    L61:
        ScopeUpdateScope r3 = r4.endRestartGroup();
        if (r3 == null) goto L65;
        r3.updateScope(new ru(r18, r19, r21));
        return;
    L65:
        return;
    L27:
        if (ComposerKt.isTraceInProgress() == false) goto L29;
        ComposerKt.traceEventStart(2054675515, r5, -1, "androidx.compose.material3.VerticalClockDisplay (TimePicker.kt:1153)");
    L29:
        Arrangement.HorizontalOrVertical r8 = Arrangement.INSTANCE.getCenter();
        Modifier.Companion r9 = Modifier.Companion;
        Alignment.Companion r10 = Alignment.Companion;
        MeasurePolicy r11 = RowKt.rowMeasurePolicy(r8, r10.getTop(), r4, 6);
        int r12 = ComposablesKt.getCurrentCompositeKeyHash(r4, 0);
        CompositionLocalMap r13 = r4.getCurrentCompositionLocalMap();
        Modifier r14 = ComposedModifierKt.materializeModifier(r4, r9);
        ComposeUiNode.Companion r16 = ComposeUiNode.Companion;
        Function0 r15 = r16.getConstructor();
        if ((r4.getApplier() instanceof Applier) == true) goto L32;
        ComposablesKt.invalidApplier();
    L32:
        r4.startReusableNode();
        if (r4.getInserting() == false) goto L35;
        r4.createNode(r15);
    L36:
        Composer r17 = Updater.constructor-impl(r4);
        Updater.set-impl(r17, r11, r16.getSetMeasurePolicy());
        Updater.set-impl(r17, r13, r16.getSetResolvedCompositionLocals());
        Function2 r22 = r16.getSetCompositeKeyHash();
        if (r17.getInserting() == false) goto L39;
    L40:
        r17.updateRememberedValue(Integer.valueOf(r12));
        r17.apply(Integer.valueOf(r12), r22);
    L41:
        Updater.set-impl(r17, r14, r16.getSetModifier());
        RowScopeInstance r23 = RowScopeInstance.INSTANCE;
        ClockDisplayNumbers(r18, r19, r4, (r5 & 14) | (r5 & 112));
        if (r18.is24hour() == true) goto L56;
        r4.startReplaceGroup(1364287361);
        Modifier r24 = PaddingKt.m964paddingqDBjuR0$default(r9, PeriodToggleMargin, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
        MeasurePolicy r25 = BoxKt.maybeCachedBoxMeasurePolicy(r10.getTopStart(), false);
        int r26 = ComposablesKt.getCurrentCompositeKeyHash(r4, 0);
        CompositionLocalMap r27 = r4.getCurrentCompositionLocalMap();
        Modifier r28 = ComposedModifierKt.materializeModifier(r4, r24);
        Function0 r110 = r16.getConstructor();
        if ((r4.getApplier() instanceof Applier) == true) goto L46;
        ComposablesKt.invalidApplier();
    L46:
        r4.startReusableNode();
        if (r4.getInserting() == false) goto L49;
        r4.createNode(r110);
    L50:
        Composer r111 = Updater.constructor-impl(r4);
        Updater.set-impl(r111, r25, r16.getSetMeasurePolicy());
        Updater.set-impl(r111, r27, r16.getSetResolvedCompositionLocals());
        Function2 r29 = r16.getSetCompositeKeyHash();
        if (r111.getInserting() == false) goto L53;
    L54:
        r111.updateRememberedValue(Integer.valueOf(r26));
        r111.apply(Integer.valueOf(r26), r29);
    L55:
        Updater.set-impl(r111, r28, r16.getSetModifier());
        BoxScopeInstance r30 = BoxScopeInstance.INSTANCE;
        TimePickerTokens r31 = TimePickerTokens.INSTANCE;
        Modifier r32 = SizeKt.m1016sizeVpY3zN4(r9, r31.getPeriodSelectorVerticalContainerWidth-D9Ej5fM(), r31.getPeriodSelectorVerticalContainerHeight-D9Ej5fM());
        int r33 = r5 << 3;
        int r34 = (r33 & 112) | 6;
        VerticalPeriodToggle(r32, r18, r19, r4, (r33 & 896) | r34);
        r4.endNode();
        r4.endReplaceGroup();
    L57:
        r4.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L61;
        ComposerKt.traceEventEnd();
        goto L61
    L53:
        if (Intrinsics.areEqual(r111.rememberedValue(), Integer.valueOf(r26)) == true) goto L55;
    L49:
        r4.useNode();
        goto L50
    L56:
        r4.startReplaceGroup(1364727499);
        r4.endReplaceGroup();
        goto L57
    L39:
        if (Intrinsics.areEqual(r17.rememberedValue(), Integer.valueOf(r12)) == true) goto L41;
    L35:
        r4.useNode();
        goto L36
    L23:
        r7 = false;
        goto L25
    L5:
        if ((r21 & 8) != 0) goto L7;
        boolean r35 = r4.changed(r18);
    L8:
        if (r35 == false) goto L10;
        int r36 = 4;
    L11:
        r5 = r36 | r21;
        goto L14
    L10:
        r36 = 2;
        goto L11
    L7:
        r35 = r4.changedInstance(r18);
        goto L8
    }

    private static final float dist(float r2, float r3, int r4, int r5) {
        return (float) Math.hypot(r4 - r2, r5 - r3);
    }

    private static final void HorizontalPeriodToggle(final Modifier r9, final TimePickerState r10, final TimePickerColors r11, Composer r12, final int r13) {
        Composer r14 = r12.startRestartGroup(1261215927);
        if ((r13 & 6) == 0) goto L5;
        int r1 = r13;
    L11:
        if ((r13 & 48) != 0) goto L21;
        if ((r13 & 64) != 0) goto L15;
        boolean r2 = r14.changed(r10);
    L16:
        if (r2 == false) goto L18;
        int r3 = 32;
    L19:
        r1 = r1 | r3;
        goto L21
    L18:
        r3 = 16;
        goto L19
    L15:
        r2 = r14.changedInstance(r10);
    L21:
        if ((r13 & 384) != 0) goto L28;
        if (r14.changed(r11) == false) goto L25;
        int r4 = 256;
    L26:
        r1 = r1 | r4;
        goto L28
    L25:
        r4 = 128;
    L28:
        if ((r1 & 147) == 146) goto L30;
        boolean r5 = true;
    L32:
        if (r14.shouldExecute(r5, r1 & 1) == true) goto L34;
        r14.skipToGroupEnd();
    L43:
        ScopeUpdateScope r15 = r14.endRestartGroup();
        if (r15 == null) goto L47;
        r15.updateScope(new ev(r9, r10, r11, r13));
        return;
    L47:
        return;
    L34:
        if (ComposerKt.isTraceInProgress() == false) goto L36;
        ComposerKt.traceEventStart(1261215927, r1, -1, "androidx.compose.material3.HorizontalPeriodToggle (TimePicker.kt:1206)");
    L36:
        Object r0 = r14.rememberedValue();
        if (r0 != Composer.Companion.getEmpty()) goto L39;
        r0 = TimePickerKt$HorizontalPeriodToggle$measurePolicy$1$1.INSTANCE;
        r14.updateRememberedValue(r0);
    L39:
        Shape r6 = ShapesKt.getValue(TimePickerTokens.INSTANCE.getPeriodSelectorContainerShape(), r14, 6);
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type androidx.compose.foundation.shape.CornerBasedShape");
        CornerBasedShape r7 = (CornerBasedShape) r6;
        PeriodToggleImpl(r9, r10, r11, (MeasurePolicy) r0, ShapesKt.start$default(r7, null, 1, null), ShapesKt.end$default(r7, null, 1, null), r14, (((r1 & 14) | 3072) | (r1 & 112)) | (r1 & 896));
        if (ComposerKt.isTraceInProgress() == false) goto L43;
        ComposerKt.traceEventEnd();
        goto L43
    L30:
        r5 = false;
        goto L32
    L5:
        if (r14.changed(r9) == false) goto L7;
        int r8 = 4;
    L8:
        r1 = r8 | r13;
        goto L11
    L7:
        r8 = 2;
        goto L8
    }

    private static final void TimeInputImpl(final Modifier r52, final TimePickerColors r53, final TimePickerState r54, Composer r55, final int r56) {
        Composer r11 = r55.startRestartGroup(-475657989);
        if ((r56 & 6) == 0) goto L5;
        int r1 = r56;
    L11:
        if ((r56 & 48) != 0) goto L18;
        if (r11.changed(r53) == false) goto L15;
        int r2 = 32;
    L16:
        r1 = r1 | r2;
        goto L18
    L15:
        r2 = 16;
    L18:
        if ((r56 & 384) == 0) goto L20;
    L27:
        int r13 = r1;
        if ((r13 & 147) == 146) goto L30;
        boolean r3 = true;
    L32:
        if (r11.shouldExecute(r3, r13 & 1) == true) goto L34;
        r11.skipToGroupEnd();
    L115:
        ScopeUpdateScope r0 = r11.endRestartGroup();
        if (r0 == null) goto L119;
        r0.updateScope(new dv(r52, r53, r54, r56));
        return;
    L119:
        return;
    L34:
        if (ComposerKt.isTraceInProgress() == false) goto L36;
        ComposerKt.traceEventStart(-475657989, r13, -1, "androidx.compose.material3.TimeInputImpl (TimePicker.kt:997)");
    L36:
        Object[] r4 = new Object[0];
        TextFieldValue.Companion r5 = TextFieldValue.Companion;
        Saver r6 = r5.getSaver();
        int r7 = r13 & 896;
        if (r7 != 256) goto L39;
    L44:
        boolean r8 = true;
    L45:
        Object r9 = r11.rememberedValue();
        if (r8 == false) goto L48;
    L49:
        r9 = new bv(r54);
        r11.updateRememberedValue(r9);
    L50:
        MutableState r10 = RememberSaveableKt.rememberSaveable(r4, r6, (Function0) r9, r11, 0);
        Object[] r12 = new Object[0];
        Saver r14 = r5.getSaver();
        if (r7 != 256) goto L53;
    L58:
        boolean r15 = true;
    L59:
        Object r16 = r11.rememberedValue();
        if (r15 == false) goto L62;
    L63:
        r16 = new cv(r54);
        r11.updateRememberedValue(r16);
    L64:
        MutableState r17 = RememberSaveableKt.rememberSaveable(r12, r14, (Function0) r16, r11, 0);
        Object r18 = r11.rememberedValue();
        Composer.Companion r19 = Composer.Companion;
        if (r18 != r19.getEmpty()) goto L67;
        r18 = new Ref();
        r11.updateRememberedValue(r18);
    L67:
        Ref r20 = (Ref) r18;
        Integer r21 = Integer.valueOf(r54.getHour());
        Integer r110 = Integer.valueOf(r54.getMinute());
        boolean r111 = r11.changedInstance(r20) | r11.changed(r10);
        if (r7 != 256) goto L70;
    L75:
        boolean r22 = true;
    L76:
        boolean r23 = (r111 | r22) | r11.changed(r17);
        Object r24 = r11.rememberedValue();
        if (r23 == false) goto L79;
    L82:
        Integer r112 = r21;
        TimePickerKt$TimeInputImpl$1$1 r25 = new TimePickerKt$TimeInputImpl$1$1(r20, r54, r10, r17, null);
        r11.updateRememberedValue(r25);
        r24 = r25;
    L83:
        EffectsKt.LaunchedEffect(r112, r110, (Function2) r24, r11, 0);
        Modifier r26 = PaddingKt.m964paddingqDBjuR0$default(r52, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, TimeInputBottomPadding, 7, null);
        Alignment.Companion r27 = Alignment.Companion;
        MeasurePolicy r28 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), r27.getTop(), r11, 48);
        int r29 = ComposablesKt.getCurrentCompositeKeyHash(r11, 0);
        CompositionLocalMap r30 = r11.getCurrentCompositionLocalMap();
        Modifier r31 = ComposedModifierKt.materializeModifier(r11, r26);
        ComposeUiNode.Companion r113 = ComposeUiNode.Companion;
        Function0 r32 = r113.getConstructor();
        if ((r11.getApplier() instanceof Applier) == true) goto L86;
        ComposablesKt.invalidApplier();
    L86:
        r11.startReusableNode();
        if (r11.getInserting() == false) goto L89;
        r11.createNode(r32);
    L90:
        Composer r33 = Updater.constructor-impl(r11);
        Updater.set-impl(r33, r28, r113.getSetMeasurePolicy());
        Updater.set-impl(r33, r30, r113.getSetResolvedCompositionLocals());
        Function2 r34 = r113.getSetCompositeKeyHash();
        if (r33.getInserting() == false) goto L93;
    L94:
        r33.updateRememberedValue(Integer.valueOf(r29));
        r33.apply(Integer.valueOf(r29), r34);
    L95:
        Updater.set-impl(r33, r31, r113.getSetModifier());
        RowScopeInstance r35 = RowScopeInstance.INSTANCE;
        TimeInputTokens r114 = TimeInputTokens.INSTANCE;
        CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{TextKt.getLocalTextStyle().provides(TextStyle.copy-p1EtxEg$default(TypographyKt.getValue(r114.getTimeFieldLabelTextFont(), r11, 6), r53.m3388timeSelectorContentColorvNxB06k$material3(true), 0, null, null, null, null, null, 0, null, null, null, 0, null, null, null, TextAlign.Companion.getCenter-e0LSkKk(), 0, 0, null, null, null, 0, 0, null, 16744446, null)), CompositionLocalsKt.getLocalLayoutDirection().provides(LayoutDirection.Ltr)}, ComposableLambdaKt.rememberComposableLambda(1306700887, true, new TimePickerKt$TimeInputImpl$2$1(r10, r54, r20, r53, r17), r11, 54), r11, ProvidedValue.$stable | 48);
        if (r54.is24hour() == true) goto L110;
        r11.startReplaceGroup(-1381942321);
        Modifier.Companion r36 = Modifier.Companion;
        Modifier r37 = PaddingKt.m964paddingqDBjuR0$default(r36, PeriodToggleMargin, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
        MeasurePolicy r38 = BoxKt.maybeCachedBoxMeasurePolicy(r27.getTopStart(), false);
        int r39 = ComposablesKt.getCurrentCompositeKeyHash(r11, 0);
        CompositionLocalMap r40 = r11.getCurrentCompositionLocalMap();
        Modifier r41 = ComposedModifierKt.materializeModifier(r11, r37);
        Function0 r42 = r113.getConstructor();
        if ((r11.getApplier() instanceof Applier) == true) goto L100;
        ComposablesKt.invalidApplier();
    L100:
        r11.startReusableNode();
        if (r11.getInserting() == false) goto L103;
        r11.createNode(r42);
    L104:
        Composer r43 = Updater.constructor-impl(r11);
        Updater.set-impl(r43, r38, r113.getSetMeasurePolicy());
        Updater.set-impl(r43, r40, r113.getSetResolvedCompositionLocals());
        Function2 r44 = r113.getSetCompositeKeyHash();
        if (r43.getInserting() == false) goto L107;
    L108:
        r43.updateRememberedValue(Integer.valueOf(r39));
        r43.apply(Integer.valueOf(r39), r44);
    L109:
        Updater.set-impl(r43, r41, r113.getSetModifier());
        BoxScopeInstance r45 = BoxScopeInstance.INSTANCE;
        VerticalPeriodToggle(SizeKt.m1016sizeVpY3zN4(r36, r114.getPeriodSelectorContainerWidth-D9Ej5fM(), r114.getPeriodSelectorContainerHeight-D9Ej5fM()), r54, r53, r11, (((r13 >> 3) & 112) | 6) | ((r13 << 3) & 896));
        r11.endNode();
        r11.endReplaceGroup();
    L111:
        r11.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L115;
        ComposerKt.traceEventEnd();
        goto L115
    L107:
        if (Intrinsics.areEqual(r43.rememberedValue(), Integer.valueOf(r39)) == true) goto L109;
    L103:
        r11.useNode();
        goto L104
    L110:
        r11.startReplaceGroup(-1381607893);
        r11.endReplaceGroup();
        goto L111
    L93:
        if (Intrinsics.areEqual(r33.rememberedValue(), Integer.valueOf(r29)) == true) goto L95;
    L89:
        r11.useNode();
        goto L90
    L79:
        if (r24 == r19.getEmpty()) goto L82;
        r112 = r21;
        goto L83
    L70:
        if ((r13 & 512) != 0) goto L72;
    L74:
        r22 = false;
        goto L76
    L72:
        if (r11.changedInstance(r54) == false) goto L74;
    L62:
        if (r16 != Composer.Companion.getEmpty()) goto L64;
    L53:
        if ((r13 & 512) != 0) goto L55;
    L57:
        r15 = false;
        goto L59
    L55:
        if (r11.changedInstance(r54) == false) goto L57;
    L48:
        if (r9 != Composer.Companion.getEmpty()) goto L50;
    L39:
        if ((r13 & 512) != 0) goto L41;
    L43:
        r8 = false;
        goto L45
    L41:
        if (r11.changedInstance(r54) == false) goto L43;
    L30:
        r3 = false;
        goto L32
    L20:
        if ((r56 & 512) != 0) goto L22;
        boolean r46 = r11.changed(r54);
    L23:
        if (r46 == false) goto L25;
        int r47 = 256;
    L26:
        r1 = r1 | r47;
        goto L27
    L25:
        r47 = 128;
        goto L26
    L22:
        r46 = r11.changedInstance(r54);
        goto L23
    L5:
        if (r11.changed(r52) == false) goto L7;
        int r48 = 4;
    L8:
        r1 = r48 | r56;
        goto L11
    L7:
        r48 = 2;
        goto L8
    }

    private static final void VerticalPeriodToggle(final Modifier r9, final TimePickerState r10, final TimePickerColors r11, Composer r12, final int r13) {
        Composer r14 = r12.startRestartGroup(-1898918107);
        if ((r13 & 6) == 0) goto L5;
        int r1 = r13;
    L11:
        if ((r13 & 48) != 0) goto L21;
        if ((r13 & 64) != 0) goto L15;
        boolean r2 = r14.changed(r10);
    L16:
        if (r2 == false) goto L18;
        int r3 = 32;
    L19:
        r1 = r1 | r3;
        goto L21
    L18:
        r3 = 16;
        goto L19
    L15:
        r2 = r14.changedInstance(r10);
    L21:
        if ((r13 & 384) != 0) goto L28;
        if (r14.changed(r11) == false) goto L25;
        int r4 = 256;
    L26:
        r1 = r1 | r4;
        goto L28
    L25:
        r4 = 128;
    L28:
        if ((r1 & 147) == 146) goto L30;
        boolean r5 = true;
    L32:
        if (r14.shouldExecute(r5, r1 & 1) == true) goto L34;
        r14.skipToGroupEnd();
    L43:
        ScopeUpdateScope r15 = r14.endRestartGroup();
        if (r15 == null) goto L47;
        r15.updateScope(new ou(r9, r10, r11, r13));
        return;
    L47:
        return;
    L34:
        if (ComposerKt.isTraceInProgress() == false) goto L36;
        ComposerKt.traceEventStart(-1898918107, r1, -1, "androidx.compose.material3.VerticalPeriodToggle (TimePicker.kt:1252)");
    L36:
        Object r0 = r14.rememberedValue();
        if (r0 != Composer.Companion.getEmpty()) goto L39;
        r0 = TimePickerKt$VerticalPeriodToggle$measurePolicy$1$1.INSTANCE;
        r14.updateRememberedValue(r0);
    L39:
        Shape r6 = ShapesKt.getValue(TimePickerTokens.INSTANCE.getPeriodSelectorContainerShape(), r14, 6);
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type androidx.compose.foundation.shape.CornerBasedShape");
        CornerBasedShape r7 = (CornerBasedShape) r6;
        PeriodToggleImpl(r9, r10, r11, (MeasurePolicy) r0, ShapesKt.top$default(r7, null, 1, null), ShapesKt.bottom$default(r7, null, 1, null), r14, (((r1 & 14) | 3072) | (r1 & 112)) | (r1 & 896));
        if (ComposerKt.isTraceInProgress() == false) goto L43;
        ComposerKt.traceEventEnd();
        goto L43
    L30:
        r5 = false;
        goto L32
    L5:
        if (r14.changed(r9) == false) goto L7;
        int r8 = 4;
    L8:
        r1 = r8 | r13;
        goto L11
    L7:
        r8 = 2;
        goto L8
    }

    /* JADX INFO: renamed from: access$moveSelector-d3b8Pxo, reason: not valid java name */
    public static final /* synthetic */ void m3411access$moveSelectord3b8Pxo(TimePickerState r0, float r1, float r2, float r3, long r4) {
        m3414moveSelectord3b8Pxo(r0, r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: moveSelector-d3b8Pxo, reason: not valid java name */
    private static final void m3414moveSelectord3b8Pxo(TimePickerState r2, float r3, float r4, float r5, long r6) {
        if (TimePickerSelectionMode.m3435equalsimpl0(r2.mo2286getSelectionyecRtBI(), TimePickerSelectionMode.Companion.m3439getHouryecRtBI()) == true) goto L5;
        return;
    L5:
        if (r2.is24hour() == false) goto L20;
        float r7 = dist(r3, r4, IntOffset.getX-impl(r6), IntOffset.getY-impl(r6));
        int r8 = 12;
        if (isPm(r2) == false) goto L13;
        int r9 = r2.getHour();
        if (r7 >= r5) goto L12;
        r8 = 0;
    L12:
        r2.setHour(r9 - r8);
        return;
    L13:
        int r10 = r2.getHour();
        if (r7 < r5) goto L17;
        r8 = 0;
    L17:
        r2.setHour(r10 + r8);
        return;
    }

    /* JADX INFO: renamed from: numberContentDescription-dSwYdS4, reason: not valid java name */
    public static final String m3415numberContentDescriptiondSwYdS4(int r3, boolean r4, int r5, Composer r6, int r7) {
        if (ComposerKt.isTraceInProgress() == false) goto L6;
        ComposerKt.traceEventStart(194237364, r7, -1, "androidx.compose.material3.numberContentDescription (TimePicker.kt:2019)");
    L6:
        if (TimePickerSelectionMode.m3435equalsimpl0(r3, TimePickerSelectionMode.Companion.m3440getMinuteyecRtBI()) == false) goto L8;
        int r8 = Strings.constructor-impl(2131911769);
    L11:
        String r9 = Strings_androidKt.getString-qBjtwXw(r8, new Object[]{Integer.valueOf(r5)}, r6, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L14;
        ComposerKt.traceEventEnd();
    L14:
        return r9;
    L8:
        if (r4 == false) goto L10;
        r8 = Strings.constructor-impl(2131911763);
        goto L11
    L10:
        r8 = Strings.constructor-impl(2131911765);
        goto L11
    }

    private static final void CircularLayout(Modifier r8, final float r9, final Function2<? super Composer, ? super Integer, Unit> r10, Composer r11, final int r12, final int r13) {
        Composer r14 = r11.startRestartGroup(-1041042571);
        int r1 = r13 & 1;
        if (r1 == 0) goto L6;
        int r2 = r12 | 6;
    L14:
        if ((r13 & 2) == 0) goto L17;
        r2 = r2 | 48;
    L24:
        if ((r13 & 4) == 0) goto L27;
        r2 = r2 | 384;
    L33:
        boolean r7 = true;
        if ((r2 & 147) == 146) goto L36;
        boolean r3 = true;
    L38:
        if (r14.shouldExecute(r3, r2 & 1) == false) goto L68;
        if (r1 == 0) goto L42;
        r8 = Modifier.Companion;
    L42:
        if (ComposerKt.isTraceInProgress() == false) goto L45;
        ComposerKt.traceEventStart(-1041042571, r2, -1, "androidx.compose.material3.CircularLayout (TimePicker.kt:1978)");
    L45:
        if ((r2 & 112) == 32) goto L48;
        r7 = false;
    L48:
        Object r0 = r14.rememberedValue();
        if (r7 == false) goto L51;
    L52:
        r0 = new TimePickerKt$CircularLayout$1$1(r9);
        r14.updateRememberedValue(r0);
    L53:
        MeasurePolicy r4 = (MeasurePolicy) r0;
        int r5 = ((r2 >> 6) & 14) | ((r2 << 3) & 112);
        int r6 = ComposablesKt.getCurrentCompositeKeyHash(r14, 0);
        CompositionLocalMap r15 = r14.getCurrentCompositionLocalMap();
        Modifier r16 = ComposedModifierKt.materializeModifier(r14, r8);
        ComposeUiNode.Companion r17 = ComposeUiNode.Companion;
        Function0 r18 = r17.getConstructor();
        int r19 = ((r5 << 6) & 896) | 6;
        if ((r14.getApplier() instanceof Applier) == true) goto L56;
        ComposablesKt.invalidApplier();
    L56:
        r14.startReusableNode();
        if (r14.getInserting() == false) goto L59;
        r14.createNode(r18);
    L60:
        Composer r20 = Updater.constructor-impl(r14);
        Updater.set-impl(r20, r4, r17.getSetMeasurePolicy());
        Updater.set-impl(r20, r15, r17.getSetResolvedCompositionLocals());
        Function2 r21 = r17.getSetCompositeKeyHash();
        if (r20.getInserting() == false) goto L63;
    L64:
        r20.updateRememberedValue(Integer.valueOf(r6));
        r20.apply(Integer.valueOf(r6), r21);
    L65:
        Updater.set-impl(r20, r16, r17.getSetModifier());
        r10.invoke(r14, Integer.valueOf((r19 >> 6) & 14));
        r14.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L69;
        ComposerKt.traceEventEnd();
    L69:
        final Modifier r22 = r8;
        ScopeUpdateScope r23 = r14.endRestartGroup();
        if (r23 == null) goto L73;
        r23.updateScope(new qu(r22, r9, r10, r12, r13));
        return;
    L73:
        return;
    L63:
        if (Intrinsics.areEqual(r20.rememberedValue(), Integer.valueOf(r6)) == true) goto L65;
    L59:
        r14.useNode();
        goto L60
    L51:
        if (r0 != Composer.Companion.getEmpty()) goto L53;
    L68:
        r14.skipToGroupEnd();
        goto L69
    L36:
        r3 = false;
        goto L38
    L27:
        if ((r12 & 384) != 0) goto L33;
        if (r14.changedInstance(r10) == false) goto L31;
        int r24 = 256;
    L32:
        r2 = r2 | r24;
        goto L33
    L31:
        r24 = 128;
        goto L32
    L17:
        if ((r12 & 48) != 0) goto L24;
        if (r14.changed(r9) == false) goto L21;
        int r25 = 32;
    L22:
        r2 = r2 | r25;
        goto L24
    L21:
        r25 = 16;
        goto L22
    L6:
        if ((r12 & 6) == 0) goto L8;
        r2 = r12;
        goto L14
    L8:
        if (r14.changed(r8) == false) goto L10;
        int r26 = 4;
    L11:
        r2 = r26 | r12;
        goto L14
    L10:
        r26 = 2;
        goto L11
    }

    public static final void ClockFace(final Modifier r20, final AnalogTimePickerState r21, final TimePickerColors r22, final boolean r23, Composer r24, final int r25) {
        Composer r15 = r24.startRestartGroup(-478841003);
        if ((r25 & 6) == 0) goto L5;
        int r2 = r25;
    L11:
        if ((r25 & 48) != 0) goto L18;
        if (r15.changedInstance(r21) == false) goto L15;
        int r3 = 32;
    L16:
        r2 = r2 | r3;
        goto L18
    L15:
        r3 = 16;
    L18:
        if ((r25 & 384) != 0) goto L25;
        if (r15.changed(r22) == false) goto L22;
        int r4 = 256;
    L23:
        r2 = r2 | r4;
        goto L25
    L22:
        r4 = 128;
    L25:
        if ((r25 & 3072) != 0) goto L32;
        if (r15.changed(r23) == false) goto L29;
        int r5 = 2048;
    L30:
        r2 = r2 | r5;
        goto L32
    L29:
        r5 = 1024;
    L32:
        if ((r2 & 1171) == 1170) goto L34;
        boolean r6 = true;
    L36:
        if (r15.shouldExecute(r6, r2 & 1) == true) goto L38;
        Composer r0 = r15;
        r0.skipToGroupEnd();
    L44:
        ScopeUpdateScope r7 = r0.endRestartGroup();
        if (r7 == null) goto L48;
        r7.updateScope(new su(r20, r21, r22, r23, r25));
        return;
    L48:
        return;
    L38:
        if (ComposerKt.isTraceInProgress() == false) goto L40;
        ComposerKt.traceEventStart(-478841003, r2, -1, "androidx.compose.material3.ClockFace (TimePicker.kt:1591)");
    L40:
        RoundedCornerShape r1 = RoundedCornerShapeKt.getCircleShape();
        Modifier r13 = drawSelector(BackgroundKt.m341backgroundbw27NRU(r20, r22.m3371getClockDialColor0d7_KjU(), r1).then(new ClockDialModifier(r21, r23, r21.mo2286getSelectionyecRtBI(), MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, r15, 6), null)), r21, r22);
        r0 = r15;
        CrossfadeKt.Crossfade(r21.getClockFaceValues(), r13, MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, r15, 6), null, ComposableLambdaKt.rememberComposableLambda(747010833, true, new C02811(r22, r21, r23), r15, 54), r0, 24576, 8);
        if (ComposerKt.isTraceInProgress() == false) goto L44;
        ComposerKt.traceEventEnd();
        goto L44
    L34:
        r6 = false;
        goto L36
    L5:
        if (r15.changed(r20) == false) goto L7;
        int r8 = 4;
    L8:
        r2 = r8 | r25;
        goto L11
    L7:
        r8 = 2;
        goto L8
    }

    private static final void ClockText(final Modifier r43, final AnalogTimePickerState r44, final int r45, final boolean r46, Composer r47, final int r48) {
        Composer r13 = r47.startRestartGroup(-206784607);
        if ((r48 & 6) == 0) goto L5;
        int r2 = r48;
    L11:
        if ((r48 & 48) != 0) goto L18;
        if (r13.changedInstance(r44) == false) goto L15;
        int r4 = 32;
    L16:
        r2 = r2 | r4;
        goto L18
    L15:
        r4 = 16;
    L18:
        if ((r48 & 384) != 0) goto L25;
        if (r13.changed(r45) == false) goto L22;
        int r5 = 256;
    L23:
        r2 = r2 | r5;
        goto L25
    L22:
        r5 = 128;
    L25:
        if ((r48 & 3072) == 0) goto L27;
    L31:
        int r14 = r2;
        if ((r14 & 1171) == 1170) goto L34;
        boolean r3 = true;
    L36:
        if (r13.shouldExecute(r3, r14 & 1) == true) goto L38;
        Composer r0 = r13;
        r0.skipToGroupEnd();
    L93:
        ScopeUpdateScope r6 = r0.endRestartGroup();
        if (r6 == null) goto L97;
        r6.updateScope(new pv(r43, r44, r45, r46, r48));
        return;
    L97:
        return;
    L38:
        if (ComposerKt.isTraceInProgress() == false) goto L40;
        ComposerKt.traceEventStart(-206784607, r14, -1, "androidx.compose.material3.ClockText (TimePicker.kt:1727)");
    L40:
        TextStyle r34 = TypographyKt.getValue(TimePickerTokens.INSTANCE.getClockDialLabelTextFont(), r13, 6);
        final Density r1 = (Density) r13.consume(CompositionLocalsKt.getLocalDensity());
        final float r7 = r1.toPx-0680j_4(MaxDistance);
        Object r8 = r13.rememberedValue();
        Composer.Companion r16 = Composer.Companion;
        if (r8 != r16.getEmpty()) goto L43;
        r8 = SnapshotStateKt.mutableStateOf$default(Offset.box-impl(Offset.Companion.getZero-F1C5BW0()), null, 2, null);
        r13.updateRememberedValue(r8);
    L43:
        MutableState r9 = (MutableState) r8;
        Object r10 = r13.rememberedValue();
        if (r10 != r16.getEmpty()) goto L46;
        r10 = SnapshotStateKt.mutableStateOf$default(IntOffset.box-impl(IntOffset.Companion.getZero-nOcc-ac()), null, 2, null);
        r13.updateRememberedValue(r10);
    L46:
        MutableState r11 = (MutableState) r10;
        Object r12 = r13.rememberedValue();
        if (r12 != r16.getEmpty()) goto L49;
        r12 = SnapshotStateKt.mutableStateOf$default(Rect.Companion.getZero(), null, 2, null);
        r13.updateRememberedValue(r12);
    L49:
        final MutableState r15 = (MutableState) r12;
        Object r17 = r13.rememberedValue();
        if (r17 != r16.getEmpty()) goto L52;
        r17 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, r13);
        r13.updateRememberedValue(r17);
    L52:
        final CoroutineScope r18 = (CoroutineScope) r17;
        final String r19 = m3415numberContentDescriptiondSwYdS4(r44.mo2286getSelectionyecRtBI(), r44.is24hour(), r45, r13, r14 & 896);
        String r35 = CalendarLocale_jvmKt.toLocalString$default(r45, 0, 0, false, null, 15, null);
        boolean r20 = r13.changed(r44);
        Object r21 = r13.rememberedValue();
        if (r20 == false) goto L55;
    L56:
        r21 = SnapshotStateKt.derivedStateOf(new lv(r44, r1, r15));
        r13.updateRememberedValue(r21);
    L57:
        final State r22 = (State) r21;
        Alignment r23 = Alignment.Companion.getCenter();
        Object r24 = r13.rememberedValue();
        if (r24 != r16.getEmpty()) goto L60;
        final MutableState r25 = r9;
        final MutableState r26 = r11;
        r24 = new mv(r26, r15, r25);
        r13.updateRememberedValue(r24);
    L61:
        Modifier r27 = FocusableKt.focusable$default(SizeKt.m1014size3ABfNKs(InteractiveComponentSizeKt.minimumInteractiveComponentSize(OnGloballyPositionedModifierKt.onGloballyPositioned(r43, (Function1) r24)), MinimumInteractiveSize), false, null, 3, null);
        boolean r28 = (r13.changedInstance(r18) | r13.changedInstance(r44)) | r13.changed(r7);
        if ((r14 & 7168) != 2048) goto L64;
        boolean r110 = true;
    L65:
        boolean r29 = (r28 | r110) | r13.changed(r22);
        Object r111 = r13.rememberedValue();
        if (r29 == false) goto L68;
    L71:
        final MutableState r112 = r26;
        r111 = new nv(r18, r44, r7, r46, r25, r112, r22);
        r13.updateRememberedValue(r111);
    L72:
        Modifier r30 = SemanticsModifierKt.semantics(r27, true, (Function1) r111);
        MeasurePolicy r31 = BoxKt.maybeCachedBoxMeasurePolicy(r23, false);
        int r32 = ComposablesKt.getCurrentCompositeKeyHash(r13, 0);
        CompositionLocalMap r33 = r13.getCurrentCompositionLocalMap();
        Modifier r36 = ComposedModifierKt.materializeModifier(r13, r30);
        ComposeUiNode.Companion r37 = ComposeUiNode.Companion;
        Function0 r38 = r37.getConstructor();
        if ((r13.getApplier() instanceof Applier) == true) goto L75;
        ComposablesKt.invalidApplier();
    L75:
        r13.startReusableNode();
        if (r13.getInserting() == false) goto L78;
        r13.createNode(r38);
    L79:
        Composer r39 = Updater.constructor-impl(r13);
        Updater.set-impl(r39, r31, r37.getSetMeasurePolicy());
        Updater.set-impl(r39, r33, r37.getSetResolvedCompositionLocals());
        Function2 r40 = r37.getSetCompositeKeyHash();
        if (r39.getInserting() == false) goto L82;
    L83:
        r39.updateRememberedValue(Integer.valueOf(r32));
        r39.apply(Integer.valueOf(r32), r40);
    L84:
        Updater.set-impl(r39, r36, r37.getSetModifier());
        BoxScopeInstance r41 = BoxScopeInstance.INSTANCE;
        Modifier.Companion r42 = Modifier.Companion;
        boolean r49 = r13.changed(r19);
        Object r50 = r13.rememberedValue();
        if (r49 == false) goto L87;
    L88:
        r50 = new ov(r19);
        r13.updateRememberedValue(r50);
    L89:
        Modifier r113 = SemanticsModifierKt.clearAndSetSemantics(r42, (Function1) r50);
        r0 = r13;
        TextKt.m3363TextNvy7gAk(r35, r113, 0, null, 0, null, null, null, 0, null, null, 0, 0, false, 0, 0, null, r34, r0, 0, 0, 131068);
        r0.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L93;
        ComposerKt.traceEventEnd();
        goto L93
    L87:
        if (r50 != r16.getEmpty()) goto L89;
    L82:
        if (Intrinsics.areEqual(r39.rememberedValue(), Integer.valueOf(r32)) == true) goto L84;
    L78:
        r13.useNode();
        goto L79
    L68:
        if (r111 != r16.getEmpty()) goto L72;
    L64:
        r110 = false;
        goto L65
    L60:
        r25 = r9;
        r26 = r11;
        goto L61
    L55:
        if (r21 != r16.getEmpty()) goto L57;
    L34:
        r3 = false;
        goto L36
    L27:
        if (r13.changed(r46) == false) goto L29;
        int r51 = 2048;
    L30:
        r2 = r2 | r51;
        goto L31
    L29:
        r51 = 1024;
        goto L30
    L5:
        if (r13.changed(r43) == false) goto L7;
        int r52 = 4;
    L8:
        r2 = r52 | r48;
        goto L11
    L7:
        r52 = 2;
        goto L8
    }

    private static final boolean ClockText$lambda$80$lambda$79$lambda$78(CoroutineScope r10, AnalogTimePickerState r11, float r12, boolean r13, MutableState r14, MutableState r15) {
        BuildersKt.launch$default(r10, null, null, new TimePickerKt$ClockText$2$1$1$1(r11, r12, r13, r14, r15, null), 3, null);
        return true;
    }

    public static final void TimeInput(final TimePickerState r7, Modifier r8, TimePickerColors r9, Composer r10, final int r11, final int r12) {
        Composer r13 = r10.startRestartGroup(-760850373);
        if ((r12 & 1) == 0) goto L6;
        int r1 = r11 | 6;
    L16:
        int r2 = r12 & 2;
        if (r2 == 0) goto L20;
        r1 = r1 | 48;
    L27:
        if ((r11 & 384) != 0) goto L36;
        if ((r12 & 4) == 0) goto L31;
    L33:
        int r3 = 128;
    L34:
        r1 = r1 | r3;
        goto L36
    L31:
        if (r13.changed(r9) == false) goto L33;
        r3 = 256;
    L36:
        if ((r1 & 147) == 146) goto L38;
        boolean r4 = true;
    L40:
        if (r13.shouldExecute(r4, r1 & 1) == false) goto L61;
        r13.startDefaults();
        if ((r11 & 1) != 0) goto L44;
    L49:
        if (r2 == 0) goto L52;
        r8 = Modifier.Companion;
    L52:
        if ((r12 & 4) == 0) goto L55;
        r9 = TimePickerDefaults.INSTANCE.colors(r13, 6);
    L54:
        r1 = r1 & (-897);
    L55:
        r13.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L58;
        ComposerKt.traceEventStart(-760850373, r1, -1, "androidx.compose.material3.TimeInput (TimePicker.kt:274)");
    L58:
        int r0 = r1 >> 3;
        int r5 = r0 & 14;
        TimeInputImpl(r8, r9, r7, r13, ((r0 & 112) | r5) | ((r1 << 6) & 896));
        if (ComposerKt.isTraceInProgress() == false) goto L62;
        ComposerKt.traceEventEnd();
    L62:
        final Modifier r6 = r8;
        final TimePickerColors r14 = r9;
        ScopeUpdateScope r15 = r13.endRestartGroup();
        if (r15 == null) goto L66;
        r15.updateScope(new vv(r7, r6, r14, r11, r12));
        return;
    L66:
        return;
    L44:
        if (r13.getDefaultsInvalid() == true) goto L49;
        r13.skipToGroupEnd();
        if ((r12 & 4) == 0) goto L55;
    L61:
        r13.skipToGroupEnd();
        goto L62
    L38:
        r4 = false;
        goto L40
    L20:
        if ((r11 & 48) != 0) goto L27;
        if (r13.changed(r8) == false) goto L24;
        int r16 = 32;
    L25:
        r1 = r1 | r16;
        goto L27
    L24:
        r16 = 16;
        goto L25
    L6:
        if ((r11 & 6) == 0) goto L8;
        r1 = r11;
        goto L16
    L8:
        if ((r11 & 8) != 0) goto L10;
        boolean r17 = r13.changed(r7);
    L11:
        if (r17 == false) goto L13;
        int r18 = 4;
    L14:
        r1 = r18 | r11;
        goto L16
    L13:
        r18 = 2;
        goto L14
    L10:
        r17 = r13.changedInstance(r7);
        goto L11
    }

    public static final /* synthetic */ void access$CircularLayout(Modifier r0, float r1, Function2 r2, Composer r3, int r4, int r5) {
        CircularLayout(r0, r1, r2, r3, r4, r5);
    }

    public static final /* synthetic */ void access$ClockText(Modifier r0, AnalogTimePickerState r1, int r2, boolean r3, Composer r4, int r5) {
        ClockText(r0, r1, r2, r3, r4, r5);
    }

    public static final TimePickerState rememberTimePickerState(final int r6, final int r7, final boolean r8, Composer r9, int r10, int r11) {
        if ((r11 & 1) == 0) goto L6;
        r6 = 0;
    L6:
        if ((r11 & 2) == 0) goto L9;
        r7 = 0;
    L9:
        if ((r11 & 4) == 0) goto L12;
        r8 = TimeFormat_androidKt.is24HourFormat(r9, 0);
    L12:
        if (ComposerKt.isTraceInProgress() == false) goto L14;
        ComposerKt.traceEventStart(1237715277, r10, -1, "androidx.compose.material3.rememberTimePickerState (TimePicker.kt:587)");
    L14:
        Object[] r12 = new Object[0];
        Saver<TimePickerStateImpl, ?> r2 = TimePickerStateImpl.Companion.Saver();
        boolean r4 = true;
        if (((r10 & 14) ^ 6) <= 4) goto L19;
        if (r9.changed(r6) == false) goto L19;
    L20:
        boolean r0 = true;
    L23:
        if (((r10 & 112) ^ 48) <= 32) goto L27;
        if (r9.changed(r7) == false) goto L27;
    L28:
        boolean r3 = true;
    L30:
        boolean r1 = r0 | r3;
        if (((r10 & 896) ^ 384) <= 256) goto L35;
        if (r9.changed(r8) == false) goto L35;
    L38:
        boolean r13 = r1 | r4;
        Object r5 = r9.rememberedValue();
        if (r13 == false) goto L41;
    L42:
        r5 = new zu(r6, r7, r8);
        r9.updateRememberedValue(r5);
    L43:
        TimePickerStateImpl r14 = (TimePickerStateImpl) RememberSaveableKt.rememberSaveable(r12, r2, (Function0) r5, r9, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L46;
        ComposerKt.traceEventEnd();
    L46:
        return r14;
    L41:
        if (r5 != Composer.Companion.getEmpty()) goto L43;
    L35:
        if ((r10 & 384) == 256) goto L38;
        r4 = false;
    L27:
        if ((r10 & 48) == 32) goto L28;
        r3 = false;
    L19:
        if ((r10 & 6) == 4) goto L20;
        r0 = false;
        goto L23
    }

    public static final void HorizontalTimePicker(final AnalogTimePickerState r9, Modifier r10, TimePickerColors r11, final boolean r12, Composer r13, final int r14, final int r15) {
        Composer r16 = r13.startRestartGroup(1432307537);
        if ((r15 & 1) == 0) goto L6;
        int r1 = r14 | 6;
    L13:
        int r2 = r15 & 2;
        if (r2 == 0) goto L17;
        r1 = r1 | 48;
    L24:
        if ((r14 & 384) != 0) goto L33;
        if ((r15 & 4) == 0) goto L28;
    L30:
        int r3 = 128;
    L31:
        r1 = r1 | r3;
        goto L33
    L28:
        if (r16.changed(r11) == false) goto L30;
        r3 = 256;
    L33:
        if ((r15 & 8) == 0) goto L36;
        r1 = r1 | 3072;
    L43:
        if ((r1 & 1171) == 1170) goto L45;
        boolean r4 = true;
    L47:
        if (r16.shouldExecute(r4, r1 & 1) == false) goto L83;
        r16.startDefaults();
        if ((r14 & 1) != 0) goto L51;
    L56:
        if (r2 == 0) goto L59;
        r10 = Modifier.Companion;
    L59:
        if ((r15 & 4) == 0) goto L62;
        r11 = TimePickerDefaults.INSTANCE.colors(r16, 6);
    L61:
        r1 = r1 & (-897);
    L62:
        r16.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L65;
        ComposerKt.traceEventStart(1432307537, r1, -1, "androidx.compose.material3.HorizontalTimePicker (TimePicker.kt:980)");
    L65:
        Object r0 = r16.rememberedValue();
        if (r0 != Composer.Companion.getEmpty()) goto L68;
        r0 = new tu();
        r16.updateRememberedValue(r0);
    L68:
        Modifier r5 = SemanticsModifierKt.semantics$default(r10, false, (Function1) r0, 1, null);
        Alignment.Vertical r6 = Alignment.Companion.getCenterVertically();
        MeasurePolicy r7 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), r6, r16, 48);
        int r8 = ComposablesKt.getCurrentCompositeKeyHash(r16, 0);
        CompositionLocalMap r17 = r16.getCurrentCompositionLocalMap();
        Modifier r18 = ComposedModifierKt.materializeModifier(r16, r5);
        ComposeUiNode.Companion r19 = ComposeUiNode.Companion;
        Function0 r20 = r19.getConstructor();
        if ((r16.getApplier() instanceof Applier) == true) goto L71;
        ComposablesKt.invalidApplier();
    L71:
        r16.startReusableNode();
        if (r16.getInserting() == false) goto L74;
        r16.createNode(r20);
    L75:
        Composer r21 = Updater.constructor-impl(r16);
        Updater.set-impl(r21, r7, r19.getSetMeasurePolicy());
        Updater.set-impl(r21, r17, r19.getSetResolvedCompositionLocals());
        Function2 r22 = r19.getSetCompositeKeyHash();
        if (r21.getInserting() == false) goto L78;
    L79:
        r21.updateRememberedValue(Integer.valueOf(r8));
        r21.apply(Integer.valueOf(r8), r22);
    L80:
        Updater.set-impl(r21, r18, r19.getSetModifier());
        RowScopeInstance r23 = RowScopeInstance.INSTANCE;
        HorizontalClockDisplay(r9, r11, r16, (r1 & 14) | ((r1 >> 3) & 112));
        Modifier.Companion r24 = Modifier.Companion;
        SpacerKt.Spacer(SizeKt.m1019width3ABfNKs(r24, ClockDisplayBottomMargin), r16, 6);
        Modifier r25 = r24.then(new ClockFaceSizeModifier());
        int r26 = (((r1 << 3) & 112) | (r1 & 896)) | (r1 & 7168);
        ClockFace(r25, r9, r11, r12, r16, r26);
        r16.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L84;
        ComposerKt.traceEventEnd();
    L84:
        final Modifier r27 = r10;
        final TimePickerColors r28 = r11;
        ScopeUpdateScope r110 = r16.endRestartGroup();
        if (r110 == null) goto L88;
        r110.updateScope(new uu(r9, r27, r28, r12, r14, r15));
        return;
    L88:
        return;
    L78:
        if (Intrinsics.areEqual(r21.rememberedValue(), Integer.valueOf(r8)) == true) goto L80;
    L74:
        r16.useNode();
        goto L75
    L51:
        if (r16.getDefaultsInvalid() == true) goto L56;
        r16.skipToGroupEnd();
        if ((r15 & 4) == 0) goto L62;
    L83:
        r16.skipToGroupEnd();
        goto L84
    L45:
        r4 = false;
        goto L47
    L36:
        if ((r14 & 3072) != 0) goto L43;
        if (r16.changed(r12) == false) goto L40;
        int r29 = 2048;
    L41:
        r1 = r1 | r29;
        goto L43
    L40:
        r29 = 1024;
        goto L41
    L17:
        if ((r14 & 48) != 0) goto L24;
        if (r16.changed(r10) == false) goto L21;
        int r30 = 32;
    L22:
        r1 = r1 | r30;
        goto L24
    L21:
        r30 = 16;
        goto L22
    L6:
        if ((r14 & 6) == 0) goto L8;
        r1 = r14;
        goto L13
    L8:
        if (r16.changedInstance(r9) == false) goto L10;
        int r31 = 4;
    L11:
        r1 = r31 | r14;
        goto L13
    L10:
        r31 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: TimePicker-mT9BvqQ, reason: not valid java name */
    public static final void m3406TimePickermT9BvqQ(final TimePickerState r18, Modifier r19, TimePickerColors r20, int r21, Composer r22, final int r23, final int r24) {
        Composer r2 = r22.startRestartGroup(-619286452);
        if ((r24 & 1) == 0) goto L6;
        int r3 = r23 | 6;
    L16:
        int r6 = r24 & 2;
        if (r6 == 0) goto L20;
        r3 = r3 | 48;
    L26:
        Modifier r7 = r19;
    L28:
        if ((r23 & 384) == 0) goto L30;
        TimePickerColors r8 = r20;
    L39:
        if ((r23 & 3072) == 0) goto L41;
        int r9 = r21;
    L50:
        if ((r3 & 1171) == 1170) goto L52;
        boolean r10 = true;
    L54:
        if (r2.shouldExecute(r10, r3 & 1) == false) goto L121;
        r2.startDefaults();
        if ((r23 & 1) != 0) goto L58;
    L67:
        if (r6 == 0) goto L69;
        Modifier r11 = Modifier.Companion;
    L71:
        if ((r24 & 4) == 0) goto L73;
        TimePickerColors r12 = TimePickerDefaults.INSTANCE.colors(r2, 6);
        r3 = r3 & (-897);
    L75:
        if ((r24 & 8) == 0) goto L77;
        int r13 = r3 & (-7169);
        Modifier r4 = r11;
        TimePickerColors r14 = r12;
        int r15 = TimePickerDefaults.INSTANCE.m3390layoutTypesDNSZnc(r2, 6);
    L79:
        r2.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L82;
        ComposerKt.traceEventStart(-619286452, r13, -1, "androidx.compose.material3.TimePicker (TimePicker.kt:224)");
    L82:
        int r16 = r13;
        State r0 = AccessibilityServiceStateProvider_androidKt.rememberAccessibilityServiceState(false, false, false, r2, 0, 7);
        Object r17 = r2.rememberedValue();
        Composer.Companion r25 = Composer.Companion;
        if (r17 != r25.getEmpty()) goto L85;
        r17 = new Ref();
        r2.updateRememberedValue(r17);
    L85:
        Ref r26 = (Ref) r17;
        int r27 = r16 & 14;
        if (r27 != 4) goto L88;
    L93:
        boolean r28 = true;
    L94:
        Object r110 = r2.rememberedValue();
        if (r28 == false) goto L97;
    L98:
        r110 = new AnalogTimePickerState(r18, r26);
        r2.updateRememberedValue(r110);
    L99:
        AnalogTimePickerState r29 = (AnalogTimePickerState) r110;
        Integer r111 = Integer.valueOf(r18.getHour());
        Integer r112 = Integer.valueOf(r18.getMinute());
        boolean r113 = r2.changedInstance(r26) | r2.changedInstance(r29);
        if (r27 != 4) goto L102;
    L107:
        boolean r5 = true;
    L108:
        boolean r30 = r113 | r5;
        Object r31 = r2.rememberedValue();
        if (r30 == false) goto L111;
    L112:
        r31 = new TimePickerKt$TimePicker$1$1(r26, r29, r18, null);
        r2.updateRememberedValue(r31);
    L113:
        EffectsKt.LaunchedEffect(r111, r112, (Function2) r31, r2, 0);
        if (TimePickerLayoutType.m3426equalsimpl0(r15, TimePickerLayoutType.Companion.m3431getVerticalQJTpgSE()) == false) goto L116;
        r2.startReplaceGroup(2017551219);
        VerticalTimePicker(r29, r4, r14, !TimePicker_mT9BvqQ$lambda$0(r0), r2, (r16 & 112) | (r16 & 896), 0);
        r2.endReplaceGroup();
    L118:
        if (ComposerKt.isTraceInProgress() == false) goto L120;
        ComposerKt.traceEventEnd();
    L120:
        final int r32 = r15;
    L122:
        ScopeUpdateScope r33 = r2.endRestartGroup();
        if (r33 == null) goto L126;
        final Modifier r34 = r4;
        final TimePickerColors r35 = r14;
        r33.updateScope(new fv(r18, r34, r35, r32, r23, r24));
        return;
    L126:
        return;
    L116:
        r2.startReplaceGroup(2017750673);
        HorizontalTimePicker(r29, r4, r14, !TimePicker_mT9BvqQ$lambda$0(r0), r2, (r16 & 112) | (r16 & 896), 0);
        r2.endReplaceGroup();
        goto L118
    L111:
        if (r31 != r25.getEmpty()) goto L113;
    L102:
        if ((r16 & 8) != 0) goto L104;
    L106:
        r5 = false;
        goto L108
    L104:
        if (r2.changedInstance(r18) == false) goto L106;
    L97:
        if (r110 != r25.getEmpty()) goto L99;
    L88:
        if ((r16 & 8) != 0) goto L90;
    L92:
        r28 = false;
        goto L94
    L90:
        if (r2.changed(r18) == false) goto L92;
    L77:
        r13 = r3;
        r4 = r11;
        r14 = r12;
    L78:
        r15 = r9;
        goto L79
    L73:
        r12 = r8;
        goto L75
    L69:
        r11 = r7;
        goto L71
    L58:
        if (r2.getDefaultsInvalid() == true) goto L67;
        r2.skipToGroupEnd();
        if ((r24 & 4) == 0) goto L64;
        r3 = r3 & (-897);
    L64:
        if ((r24 & 8) == 0) goto L66;
        r3 = r3 & (-7169);
    L66:
        r13 = r3;
        r4 = r7;
        r14 = r8;
        goto L78
    L121:
        r2.skipToGroupEnd();
        r4 = r7;
        r14 = r8;
        r32 = r9;
        goto L122
    L52:
        r10 = false;
        goto L54
    L41:
        if ((r24 & 8) != 0) goto L45;
        r9 = r21;
        if (r2.changed(r9) == false) goto L46;
        int r114 = 2048;
    L47:
        r3 = r3 | r114;
    L46:
        r114 = 1024;
        goto L47
    L45:
        r9 = r21;
        goto L46
    L30:
        if ((r24 & 4) != 0) goto L34;
        r8 = r20;
        if (r2.changed(r8) == false) goto L35;
        int r36 = 256;
    L36:
        r3 = r3 | r36;
    L35:
        r36 = 128;
        goto L36
    L34:
        r8 = r20;
        goto L35
    L20:
        if ((r23 & 48) != 0) goto L26;
        r7 = r19;
        if (r2.changed(r7) == false) goto L24;
        int r37 = 32;
    L25:
        r3 = r3 | r37;
        goto L28
    L24:
        r37 = 16;
        goto L25
    L6:
        if ((r23 & 6) == 0) goto L8;
        r3 = r23;
        goto L16
    L8:
        if ((r23 & 8) != 0) goto L10;
        boolean r38 = r2.changed(r18);
    L11:
        if (r38 == false) goto L13;
        int r39 = 4;
    L14:
        r3 = r39 | r23;
        goto L16
    L13:
        r39 = 2;
        goto L14
    L10:
        r38 = r2.changedInstance(r18);
        goto L11
    }

    /* JADX INFO: renamed from: TimeSelector-SAnMeKU, reason: not valid java name */
    private static final void m3408TimeSelectorSAnMeKU(final Modifier r31, final int r32, final TimePickerState r33, final int r34, final TimePickerColors r35, Composer r36, final int r37) {
        Composer r14 = r36.startRestartGroup(-1148055889);
        if ((r37 & 6) == 0) goto L5;
        int r2 = r37;
    L11:
        if ((r37 & 48) != 0) goto L18;
        if (r14.changed(r32) == false) goto L15;
        int r3 = 32;
    L16:
        r2 = r2 | r3;
        goto L18
    L15:
        r3 = 16;
    L18:
        if ((r37 & 384) != 0) goto L28;
        if ((r37 & 512) != 0) goto L22;
        boolean r4 = r14.changed(r33);
    L23:
        if (r4 == false) goto L25;
        int r5 = 256;
    L26:
        r2 = r2 | r5;
        goto L28
    L25:
        r5 = 128;
        goto L26
    L22:
        r4 = r14.changedInstance(r33);
    L28:
        if ((r37 & 3072) != 0) goto L35;
        if (r14.changed(r34) == false) goto L32;
        int r6 = 2048;
    L33:
        r2 = r2 | r6;
        goto L35
    L32:
        r6 = 1024;
    L35:
        if ((r37 & 24576) == 0) goto L37;
    L41:
        boolean r7 = false;
        if ((r2 & 9363) == 9362) goto L44;
        boolean r8 = true;
    L46:
        if (r14.shouldExecute(r8, r2 & 1) == true) goto L48;
        Composer r0 = r14;
        r0.skipToGroupEnd();
    L79:
        ScopeUpdateScope r9 = r0.endRestartGroup();
        if (r9 == null) goto L83;
        r9.updateScope(new yv(r31, r32, r33, r34, r35, r37));
        return;
    L83:
        return;
    L48:
        if (ComposerKt.isTraceInProgress() == false) goto L50;
        ComposerKt.traceEventStart(-1148055889, r2, -1, "androidx.compose.material3.TimeSelector (TimePicker.kt:1403)");
    L50:
        boolean r1 = TimePickerSelectionMode.m3435equalsimpl0(r33.mo2286getSelectionyecRtBI(), r34);
        if (TimePickerSelectionMode.m3435equalsimpl0(r34, TimePickerSelectionMode.Companion.m3439getHouryecRtBI()) == false) goto L53;
        int r10 = Strings.constructor-impl(2131911764);
    L54:
        final String r11 = Strings_androidKt.getString-2EP1pXo(r10, r14, 0);
        long r17 = r35.m3387timeSelectorContainerColorvNxB06k$material3(r1);
        long r25 = r35.m3388timeSelectorContentColorvNxB06k$material3(r1);
        boolean r12 = r14.changed(r11);
        Object r13 = r14.rememberedValue();
        if (r12 == false) goto L57;
    L58:
        r13 = new wv(r11);
        r14.updateRememberedValue(r13);
    L59:
        Modifier r16 = SemanticsModifierKt.semantics(r31, true, (Function1) r13);
        Shape r30 = ShapesKt.getValue(TimePickerTokens.INSTANCE.getTimeSelectorContainerShape(), r14, 6);
        if ((r2 & 7168) != 2048) goto L62;
        boolean r15 = true;
    L64:
        if ((r2 & 896) != 256) goto L66;
    L69:
        r7 = true;
    L70:
        boolean r18 = r15 | r7;
        Object r19 = r14.rememberedValue();
        if (r18 == false) goto L73;
    L74:
        r19 = new xv(r34, r33);
        r14.updateRememberedValue(r19);
    L75:
        r0 = r14;
        SurfaceKt.m3214Surfaced85dljk(r1, (Function0) r19, r16, false, r30, r17, 0, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, null, null, ComposableLambdaKt.rememberComposableLambda(-1477282471, true, new TimePickerKt$TimeSelector$3(r34, r33, r32, r25), r14, 54), r0, 0, 48, 1992);
        if (ComposerKt.isTraceInProgress() == false) goto L79;
        ComposerKt.traceEventEnd();
        goto L79
    L73:
        if (r19 != Composer.Companion.getEmpty()) goto L75;
    L66:
        if ((r2 & 512) == 0) goto L70;
        if (r14.changedInstance(r33) == false) goto L70;
    L62:
        r15 = false;
        goto L64
    L57:
        if (r13 != Composer.Companion.getEmpty()) goto L59;
    L53:
        r10 = Strings.constructor-impl(2131911768);
        goto L54
    L44:
        r8 = false;
        goto L46
    L37:
        if (r14.changed(r35) == false) goto L39;
        int r20 = 16384;
    L40:
        r2 = r2 | r20;
        goto L41
    L39:
        r20 = 8192;
        goto L40
    L5:
        if (r14.changed(r31) == false) goto L7;
        int r21 = 4;
    L8:
        r2 = r21 | r37;
        goto L11
    L7:
        r21 = 2;
        goto L8
    }

    private static final void ToggleItem(final boolean r26, final Shape r27, final Function0<Unit> r28, final TimePickerColors r29, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> r30, Composer r31, final int r32) {
        Composer r2 = r31.startRestartGroup(1523811083);
        if ((r32 & 6) == 0) goto L5;
        int r3 = r32;
    L11:
        if ((r32 & 48) != 0) goto L18;
        if (r2.changed(r27) == false) goto L15;
        int r7 = 32;
    L16:
        r3 = r3 | r7;
        goto L18
    L15:
        r7 = 16;
    L18:
        if ((r32 & 384) != 0) goto L25;
        if (r2.changedInstance(r28) == false) goto L22;
        int r8 = 256;
    L23:
        r3 = r3 | r8;
        goto L25
    L22:
        r8 = 128;
    L25:
        if ((r32 & 3072) != 0) goto L32;
        if (r2.changed(r29) == false) goto L29;
        int r9 = 2048;
    L30:
        r3 = r3 | r9;
        goto L32
    L29:
        r9 = 1024;
    L32:
        if ((r32 & 24576) != 0) goto L39;
        if (r2.changedInstance(r30) == false) goto L36;
        int r10 = 16384;
    L37:
        r3 = r3 | r10;
        goto L39
    L36:
        r10 = 8192;
    L39:
        if ((r3 & 9363) == 9362) goto L41;
        boolean r11 = true;
    L43:
        if (r2.shouldExecute(r11, r3 & 1) == true) goto L45;
        r2.skipToGroupEnd();
    L64:
        ScopeUpdateScope r12 = r2.endRestartGroup();
        if (r12 == null) goto L68;
        r12.updateScope(new uv(r26, r27, r28, r29, r30, r32));
        return;
    L68:
        return;
    L45:
        if (ComposerKt.isTraceInProgress() == false) goto L47;
        ComposerKt.traceEventStart(1523811083, r3, -1, "androidx.compose.material3.ToggleItem (TimePicker.kt:1359)");
    L47:
        long r16 = r29.m3386periodSelectorContentColorvNxB06k$material3(r26);
        long r18 = r29.m3385periodSelectorContainerColorvNxB06k$material3(r26);
        Modifier.Companion r0 = Modifier.Companion;
        if (r26 == false) goto L50;
        float r13 = MenuKt.ClosedAlphaTarget;
    L51:
        Modifier r1 = SizeKt.fillMaxSize$default(ZIndexModifierKt.zIndex(r0, r13), MenuKt.ClosedAlphaTarget, 1, null);
        if ((r3 & 14) != 4) goto L54;
        boolean r5 = true;
    L55:
        Object r14 = r2.rememberedValue();
        if (r5 == false) goto L58;
    L59:
        r14 = new tv(r26);
        r2.updateRememberedValue(r14);
    L60:
        ButtonKt.TextButton(r28, SemanticsModifierKt.semantics$default(r1, false, (Function1) r14, 1, null), false, r27, ButtonDefaults.INSTANCE.m2361textButtonColorsro_MJ88(r18, r16, 0, 0, r2, 24576, 12), null, null, PaddingKt.m953PaddingValues0680j_4(Dp.constructor-impl(0)), null, r30, r2, ((((r3 >> 6) & 14) | 12582912) | ((r3 << 6) & 7168)) | ((r3 << 15) & 1879048192), 356);
        if (ComposerKt.isTraceInProgress() == false) goto L64;
        ComposerKt.traceEventEnd();
        goto L64
    L58:
        if (r14 != Composer.Companion.getEmpty()) goto L60;
    L54:
        r5 = false;
        goto L55
    L50:
        r13 = 1.0f;
        goto L51
    L41:
        r11 = false;
        goto L43
    L5:
        if (r2.changed(r26) == false) goto L7;
        int r4 = 4;
    L8:
        r3 = r4 | r32;
        goto L11
    L7:
        r4 = 2;
        goto L8
    }

    public static final void VerticalTimePicker(final AnalogTimePickerState r9, Modifier r10, TimePickerColors r11, final boolean r12, Composer r13, final int r14, final int r15) {
        Composer r16 = r13.startRestartGroup(1249591487);
        if ((r15 & 1) == 0) goto L6;
        int r1 = r14 | 6;
    L13:
        int r2 = r15 & 2;
        if (r2 == 0) goto L17;
        r1 = r1 | 48;
    L24:
        if ((r14 & 384) != 0) goto L33;
        if ((r15 & 4) == 0) goto L28;
    L30:
        int r3 = 128;
    L31:
        r1 = r1 | r3;
        goto L33
    L28:
        if (r16.changed(r11) == false) goto L30;
        r3 = 256;
    L33:
        if ((r15 & 8) == 0) goto L36;
        r1 = r1 | 3072;
    L43:
        if ((r1 & 1171) == 1170) goto L45;
        boolean r4 = true;
    L47:
        if (r16.shouldExecute(r4, r1 & 1) == false) goto L83;
        r16.startDefaults();
        if ((r14 & 1) != 0) goto L51;
    L56:
        if (r2 == 0) goto L59;
        r10 = Modifier.Companion;
    L59:
        if ((r15 & 4) == 0) goto L62;
        r11 = TimePickerDefaults.INSTANCE.colors(r16, 6);
    L61:
        r1 = r1 & (-897);
    L62:
        r16.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L65;
        ComposerKt.traceEventStart(1249591487, r1, -1, "androidx.compose.material3.VerticalTimePicker (TimePicker.kt:957)");
    L65:
        Object r0 = r16.rememberedValue();
        if (r0 != Composer.Companion.getEmpty()) goto L68;
        r0 = new hv();
        r16.updateRememberedValue(r0);
    L68:
        Modifier r5 = SemanticsModifierKt.semantics$default(r10, false, (Function1) r0, 1, null);
        Alignment.Horizontal r6 = Alignment.Companion.getCenterHorizontally();
        MeasurePolicy r7 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), r6, r16, 48);
        int r8 = ComposablesKt.getCurrentCompositeKeyHash(r16, 0);
        CompositionLocalMap r17 = r16.getCurrentCompositionLocalMap();
        Modifier r18 = ComposedModifierKt.materializeModifier(r16, r5);
        ComposeUiNode.Companion r19 = ComposeUiNode.Companion;
        Function0 r20 = r19.getConstructor();
        if ((r16.getApplier() instanceof Applier) == true) goto L71;
        ComposablesKt.invalidApplier();
    L71:
        r16.startReusableNode();
        if (r16.getInserting() == false) goto L74;
        r16.createNode(r20);
    L75:
        Composer r21 = Updater.constructor-impl(r16);
        Updater.set-impl(r21, r7, r19.getSetMeasurePolicy());
        Updater.set-impl(r21, r17, r19.getSetResolvedCompositionLocals());
        Function2 r22 = r19.getSetCompositeKeyHash();
        if (r21.getInserting() == false) goto L78;
    L79:
        r21.updateRememberedValue(Integer.valueOf(r8));
        r21.apply(Integer.valueOf(r8), r22);
    L80:
        Updater.set-impl(r21, r18, r19.getSetModifier());
        ColumnScopeInstance r23 = ColumnScopeInstance.INSTANCE;
        VerticalClockDisplay(r9, r11, r16, (r1 & 14) | ((r1 >> 3) & 112));
        Modifier.Companion r24 = Modifier.Companion;
        SpacerKt.Spacer(SizeKt.m1000height3ABfNKs(r24, ClockDisplayBottomMargin), r16, 6);
        int r25 = ((((r1 << 3) & 112) | 6) | (r1 & 896)) | (r1 & 7168);
        ClockFace(SizeKt.m1014size3ABfNKs(r24, TimePickerTokens.INSTANCE.getClockDialContainerSize-D9Ej5fM()), r9, r11, r12, r16, r25);
        SpacerKt.Spacer(SizeKt.m1000height3ABfNKs(r24, ClockFaceBottomMargin), r16, 6);
        r16.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L84;
        ComposerKt.traceEventEnd();
    L84:
        final Modifier r26 = r10;
        final TimePickerColors r27 = r11;
        ScopeUpdateScope r110 = r16.endRestartGroup();
        if (r110 == null) goto L88;
        r110.updateScope(new iv(r9, r26, r27, r12, r14, r15));
        return;
    L88:
        return;
    L78:
        if (Intrinsics.areEqual(r21.rememberedValue(), Integer.valueOf(r8)) == true) goto L80;
    L74:
        r16.useNode();
        goto L75
    L51:
        if (r16.getDefaultsInvalid() == true) goto L56;
        r16.skipToGroupEnd();
        if ((r15 & 4) == 0) goto L62;
    L83:
        r16.skipToGroupEnd();
        goto L84
    L45:
        r4 = false;
        goto L47
    L36:
        if ((r14 & 3072) != 0) goto L43;
        if (r16.changed(r12) == false) goto L40;
        int r28 = 2048;
    L41:
        r1 = r1 | r28;
        goto L43
    L40:
        r28 = 1024;
        goto L41
    L17:
        if ((r14 & 48) != 0) goto L24;
        if (r16.changed(r10) == false) goto L21;
        int r29 = 32;
    L22:
        r1 = r1 | r29;
        goto L24
    L21:
        r29 = 16;
        goto L22
    L6:
        if ((r14 & 6) == 0) goto L8;
        r1 = r14;
        goto L13
    L8:
        if (r16.changedInstance(r9) == false) goto L10;
        int r30 = 4;
    L11:
        r1 = r30 | r14;
        goto L13
    L10:
        r30 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: access$TimeSelector-SAnMeKU, reason: not valid java name */
    public static final /* synthetic */ void m3410access$TimeSelectorSAnMeKU(Modifier r0, int r1, TimePickerState r2, int r3, TimePickerColors r4, Composer r5, int r6) {
        m3408TimeSelectorSAnMeKU(r0, r1, r2, r3, r4, r5, r6);
    }

    /* JADX INFO: renamed from: access$timeInputOnChange-_K77t-0, reason: not valid java name */
    public static final /* synthetic */ void m3413access$timeInputOnChange_K77t0(int r0, TimePickerState r1, TextFieldValue r2, TextFieldValue r3, int r4, Ref r5, Function1 r6) {
        m3417timeInputOnChange_K77t0(r0, r1, r2, r3, r4, r5, r6);
    }

    /* JADX INFO: renamed from: timeInputOnChange-_K77t-0, reason: not valid java name */
    private static final void m3417timeInputOnChange_K77t0(int r8, TimePickerState r9, TextFieldValue r10, TextFieldValue r11, int r12, Ref<Boolean> r13, Function1<? super TextFieldValue, Unit> r14) {
        r13.setValue(Boolean.FALSE);
        if (Intrinsics.areEqual(r10.getText(), r11.getText()) == false) goto L6;
        r14.invoke(r10);
        return;
    L6:
        int r0 = 0;
        if (r10.getText().length() != 0) goto L9;
        boolean r15 = true;
    L10:
        int r1 = 12;
        if (r15 == true) goto L13;
        if (r10.getText().length() == 3) goto L26;
    L28:
        int r16 = CastIntegerProtector.parseInt(r10.getText());     // Catch: Throwable -> L61
    L29:
        if (r16 > r12) goto L64;
        TimePickerSelectionMode.Companion r17 = TimePickerSelectionMode.Companion;     // Catch: Throwable -> L61
        if (TimePickerSelectionMode.m3435equalsimpl0(r8, r17.m3439getHouryecRtBI()) == false) goto L54;
        if (r16 == 12) goto L34;
    L36:
        if (r16 != 12) goto L43;
        if (isPm(r9) == true) goto L43;
        if (r9.is24hour() == true) goto L43;
        r1 = 0;
    L49:
        r9.setHour(r1);     // Catch: Throwable -> L61
        if (r16 <= 1) goto L56;
        if (r9.is24hour() == true) goto L56;
        r9.mo2288setSelection6_8s6DQ(r17.m3440getMinuteyecRtBI());     // Catch: Throwable -> L61
    L56:
        if (r10.getText().length() <= 2) goto L59;
        r10 = TextFieldValue.copy-3r_uNRQ$default(r10, String.valueOf(r10.getText().charAt(0)), 0, null, 6, null);     // Catch: Throwable -> L61
    L59:
        r14.invoke(r10);     // Catch: Throwable -> L61
        return;
    L43:
        if (isPm(r9) == true) goto L45;
    L47:
        r1 = 0;
    L48:
        r1 = r1 + r16;     // Catch: Throwable -> L61
        goto L49
    L45:
        if (r9.is24hour() == true) goto L47;
    L34:
        if (isPm(r9) == false) goto L36;
    L54:
        r9.setMinute(r16);     // Catch: Throwable -> L61
        goto L56
    L64:
        return;
    L26:
        if (TextRange.getStart-impl(r10.getSelection-d9O1mEE()) != 1) goto L28;
        r16 = CharsKt.digitToInt(r10.getText().charAt(0));     // Catch: Throwable -> L61
    L65:
        return;
    L13:
        if (TimePickerSelectionMode.m3435equalsimpl0(r8, TimePickerSelectionMode.Companion.m3439getHouryecRtBI()) == true) goto L15;
        r9.setMinute(0);
    L21:
        r14.invoke(TextFieldValue.copy-3r_uNRQ$default(r10, "", 0, null, 6, null));
        return;
    L15:
        if (isPm(r9) == true) goto L17;
    L19:
        r9.setHour(r0);
        goto L21
    L17:
        if (r9.is24hour() == true) goto L19;
        r0 = 12;
        goto L19
    L9:
        r15 = false;
        goto L10
    }

    private static final Unit ClockText$lambda$80$lambda$79(final CoroutineScope r8, final AnalogTimePickerState r9, final float r10, final boolean r11, final MutableState r12, final MutableState r13, State r14, SemanticsPropertyReceiver r15) {
        SemanticsPropertiesKt.onClick$default(r15, null, new kv(r8, r9, r10, r11, r12, r13), 1, null);
        SemanticsPropertiesKt.setSelected(r15, ClockText$lambda$75(r14));
        return Unit.INSTANCE;
    }

    private static final void PeriodToggleImpl(final Modifier r25, final TimePickerState r26, final TimePickerColors r27, final MeasurePolicy r28, final Shape r29, final Shape r30, Composer r31, final int r32) {
        Composer r3 = r31.startRestartGroup(1374241901);
        if ((r32 & 6) == 0) goto L5;
        int r5 = r32;
    L11:
        if ((r32 & 48) != 0) goto L21;
        if ((r32 & 64) != 0) goto L15;
        boolean r6 = r3.changed(r26);
    L16:
        if (r6 == false) goto L18;
        int r7 = 32;
    L19:
        r5 = r5 | r7;
        goto L21
    L18:
        r7 = 16;
        goto L19
    L15:
        r6 = r3.changedInstance(r26);
    L21:
        if ((r32 & 384) != 0) goto L29;
        if (r3.changed(r27) == false) goto L25;
        int r8 = 256;
    L26:
        r5 = r5 | r8;
        goto L29
    L25:
        r8 = 128;
    L29:
        if ((r32 & 3072) != 0) goto L36;
        if (r3.changed(r28) == false) goto L33;
        int r9 = 2048;
    L34:
        r5 = r5 | r9;
        goto L36
    L33:
        r9 = 1024;
    L36:
        if ((r32 & 24576) != 0) goto L43;
        if (r3.changed(r29) == false) goto L40;
        int r10 = 16384;
    L41:
        r5 = r5 | r10;
        goto L43
    L40:
        r10 = 8192;
    L43:
        if ((196608 & r32) != 0) goto L50;
        if (r3.changed(r30) == false) goto L47;
        int r11 = 131072;
    L48:
        r5 = r5 | r11;
        goto L50
    L47:
        r11 = 65536;
    L50:
        if ((74899 & r5) == 74898) goto L52;
        boolean r12 = true;
    L54:
        if (r3.shouldExecute(r12, r5 & 1) == true) goto L56;
        r3.skipToGroupEnd();
    L107:
        ScopeUpdateScope r13 = r3.endRestartGroup();
        if (r13 == null) goto L111;
        r13.updateScope(new av(r25, r26, r27, r28, r29, r30, r32));
        return;
    L111:
        return;
    L56:
        if (ComposerKt.isTraceInProgress() == false) goto L58;
        ComposerKt.traceEventStart(1374241901, r5, -1, "androidx.compose.material3.PeriodToggleImpl (TimePicker.kt:1301)");
    L58:
        TimePickerTokens r0 = TimePickerTokens.INSTANCE;
        BorderStroke r14 = BorderStrokeKt.m369BorderStrokecXLIe8U(r0.getPeriodSelectorOutlineWidth-D9Ej5fM(), r27.m3375getPeriodSelectorBorderColor0d7_KjU());
        Shape r1 = ShapesKt.getValue(r0.getPeriodSelectorContainerShape(), r3, 6);
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type androidx.compose.foundation.shape.CornerBasedShape");
        CornerBasedShape r2 = (CornerBasedShape) r1;
        final String r15 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(2131911771), r3, 0);
        boolean r16 = r3.changed(r15);
        Object r17 = r3.rememberedValue();
        if (r16 == false) goto L61;
    L62:
        r17 = new wu(r15);
        r3.updateRememberedValue(r17);
    L63:
        Modifier r4 = BorderKt.border(SelectableGroupKt.selectableGroup(SemanticsModifierKt.semantics$default(r25, false, (Function1) r17, 1, null)), r14, r2);
        int r18 = ComposablesKt.getCurrentCompositeKeyHash(r3, 0);
        CompositionLocalMap r19 = r3.getCurrentCompositionLocalMap();
        Modifier r20 = ComposedModifierKt.materializeModifier(r3, r4);
        ComposeUiNode.Companion r110 = ComposeUiNode.Companion;
        Function0 r111 = r110.getConstructor();
        if ((r3.getApplier() instanceof Applier) == true) goto L66;
        ComposablesKt.invalidApplier();
    L66:
        r3.startReusableNode();
        if (r3.getInserting() == false) goto L69;
        r3.createNode(r111);
    L70:
        Composer r112 = Updater.constructor-impl(r3);
        Updater.set-impl(r112, r28, r110.getSetMeasurePolicy());
        Updater.set-impl(r112, r19, r110.getSetResolvedCompositionLocals());
        Function2 r21 = r110.getSetCompositeKeyHash();
        if (r112.getInserting() == false) goto L73;
    L74:
        r112.updateRememberedValue(Integer.valueOf(r18));
        r112.apply(Integer.valueOf(r18), r21);
    L75:
        Updater.set-impl(r112, r20, r110.getSetModifier());
        boolean r22 = !isPm(r26);
        int r23 = r5 & 112;
        if (r23 != 32) goto L78;
    L83:
        boolean r24 = true;
    L84:
        Object r113 = r3.rememberedValue();
        if (r24 == false) goto L87;
    L88:
        r113 = new xu(r26);
        r3.updateRememberedValue(r113);
    L89:
        ComposableSingletons$TimePickerKt r114 = ComposableSingletons$TimePickerKt.INSTANCE;
        int r115 = (r5 << 3) & 7168;
        ToggleItem(r22, r29, (Function0) r113, r27, r114.getLambda$1425358052$material3(), r3, (((r5 >> 9) & 112) | 24576) | r115);
        SpacerKt.Spacer(BackgroundKt.m342backgroundbw27NRU$default(SizeKt.fillMaxSize$default(ZIndexModifierKt.zIndex(LayoutIdKt.layoutId(Modifier.Companion, "Spacer"), SeparatorZIndex), MenuKt.ClosedAlphaTarget, 1, null), r27.m3375getPeriodSelectorBorderColor0d7_KjU(), null, 2, null), r3, 0);
        boolean r33 = isPm(r26);
        if (r23 != 32) goto L92;
    L97:
        boolean r116 = true;
    L98:
        Object r34 = r3.rememberedValue();
        if (r116 == false) goto L101;
    L102:
        r34 = new yu(r26);
        r3.updateRememberedValue(r34);
    L103:
        ToggleItem(r33, r30, (Function0) r34, r27, r114.m2546getLambda$1179219109$material3(), r3, (((r5 >> 12) & 112) | 24576) | r115);
        r3.endNode();
        if (ComposerKt.isTraceInProgress() == false) goto L107;
        ComposerKt.traceEventEnd();
        goto L107
    L101:
        if (r34 != Composer.Companion.getEmpty()) goto L103;
    L92:
        if ((r5 & 64) != 0) goto L94;
    L96:
        r116 = false;
        goto L98
    L94:
        if (r3.changedInstance(r26) == false) goto L96;
    L87:
        if (r113 != Composer.Companion.getEmpty()) goto L89;
    L78:
        if ((r5 & 64) != 0) goto L80;
    L82:
        r24 = false;
        goto L84
    L80:
        if (r3.changedInstance(r26) == false) goto L82;
    L73:
        if (Intrinsics.areEqual(r112.rememberedValue(), Integer.valueOf(r18)) == true) goto L75;
    L69:
        r3.useNode();
        goto L70
    L61:
        if (r17 != Composer.Companion.getEmpty()) goto L63;
    L52:
        r12 = false;
        goto L54
    L5:
        if (r3.changed(r25) == false) goto L7;
        int r35 = 4;
    L8:
        r5 = r35 | r32;
        goto L11
    L7:
        r35 = 2;
        goto L8
    }

    /* JADX INFO: renamed from: access$onTap-uYHVD98, reason: not valid java name */
    public static final /* synthetic */ Object m3412access$onTapuYHVD98(AnalogTimePickerState r0, float r1, float r2, float r3, boolean r4, long r5, AnimationSpec r7, Continuation r8) {
        return m3416onTapuYHVD98(r0, r1, r2, r3, r4, r5, r7, r8);
    }

    /* JADX INFO: renamed from: onTap-uYHVD98, reason: not valid java name */
    private static final Object m3416onTapuYHVD98(AnalogTimePickerState r12, float r13, float r14, float r15, boolean r16, long r17, AnimationSpec<Float> r19, Continuation<? super Unit> r20) {
        if ((r20 instanceof TimePickerKt$onTap$1) == false) goto L7;
        TimePickerKt$onTap$1 r1 = (TimePickerKt$onTap$1) r20;
        int r2 = r1.label;
        if ((r2 & RtlSpacingHelper.UNDEFINED) == 0) goto L7;
        r1.label = r2 - RtlSpacingHelper.UNDEFINED;
    L8:
        TimePickerKt$onTap$1 r7 = r1;
        Object r0 = r7.result;
        Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r7.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        boolean r4 = r7.Z$0;
        AnalogTimePickerState r5 = (AnalogTimePickerState) r7.L$0;
        ResultKt.throwOnFailure(r0);
    L31:
        boolean r6 = r4;
    L32:
        if (r6 == false) goto L35;
        r5.mo2288setSelection6_8s6DQ(TimePickerSelectionMode.Companion.m3440getMinuteyecRtBI());
    L35:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        boolean r9 = r7.Z$0;
        r5 = (AnalogTimePickerState) r7.L$0;
        ResultKt.throwOnFailure(r0);
        r6 = r9;
    L25:
        if (TimePickerSelectionMode.m3435equalsimpl0(r5.mo2286getSelectionyecRtBI(), TimePickerSelectionMode.Companion.m3439getHouryecRtBI()) == false) goto L32;
        if (r6 == false) goto L32;
        r7.L$0 = r5;
        r7.Z$0 = r6;
        r7.label = 2;
        if (DelayKt.delay(100, r7) != r8) goto L30;
        return r8;
    L30:
        r4 = r6;
        goto L31
    L16:
        ResultKt.throwOnFailure(r0);
        float r10 = atan(r14 - IntOffset.getY-impl(r17), r13 - IntOffset.getX-impl(r17));
        if (TimePickerSelectionMode.m3435equalsimpl0(r12.mo2286getSelectionyecRtBI(), TimePickerSelectionMode.Companion.m3440getMinuteyecRtBI()) == false) goto L19;
        float r11 = RadiansPerMinute;
        float r18 = ((float) Math.rint((r10 / RadiansPerMinute) / 5.0f)) * 5.0f;
    L20:
        float r21 = r18 * r11;
        m3414moveSelectord3b8Pxo(r12, r13, r14, r15, r17);
        r7.L$0 = r12;
        r6 = r16;
        r7.Z$0 = r6;
        r7.label = 1;
        if (r12.rotateTo(r21, r19, true, r7) != r8) goto L23;
        return r8;
    L23:
        r5 = r12;
        goto L25
    L19:
        r11 = RadiansPerHour;
        r18 = (float) Math.rint(r10 / RadiansPerHour);
    L7:
        r1 = new TimePickerKt$onTap$1(r20);
        goto L8
    }

    /* JADX INFO: renamed from: TimePickerTextField-1vLObsk, reason: not valid java name */
    private static final void m3407TimePickerTextField1vLObsk(final Modifier r118, final TextFieldValue r119, final Function1<? super TextFieldValue, Unit> r120, final TimePickerState r121, final int r122, KeyboardOptions r123, KeyboardActions r124, final TimePickerColors r125, Composer r126, final int r127, final int r128) {
        Composer r11 = r126.startRestartGroup(1299172990);
        if ((r128 & 1) == 0) goto L6;
        int r3 = r127 | 6;
    L14:
        if ((r128 & 2) == 0) goto L17;
        r3 = r3 | 48;
    L24:
        if ((r128 & 4) == 0) goto L27;
        r3 = r3 | 384;
    L34:
        if ((r128 & 8) == 0) goto L37;
        r3 = r3 | 3072;
    L47:
        if ((r128 & 16) == 0) goto L50;
        r3 = r3 | 24576;
    L56:
        int r4 = r128 & 32;
        if (r4 == 0) goto L60;
        r3 = r3 | 196608;
    L66:
        KeyboardOptions r5 = r123;
    L67:
        int r16 = r128 & 64;
        if (r16 == 0) goto L70;
        r3 = r3 | 1572864;
        KeyboardActions r6 = r124;
    L78:
        if ((r128 & 128) == 0) goto L81;
        r3 = r3 | 12582912;
    L87:
        int r7 = r3;
        if ((4793491 & r7) == 4793490) goto L90;
        boolean r8 = true;
    L92:
        if (r11.shouldExecute(r8, r7 & 1) == false) goto L179;
        if (r4 == 0) goto L95;
        KeyboardOptions r111 = KeyboardOptions.Companion.getDefault();
    L96:
        if (r16 == 0) goto L98;
        KeyboardActions r112 = KeyboardActions.Companion.getDefault();
    L100:
        if (ComposerKt.isTraceInProgress() == false) goto L102;
        ComposerKt.traceEventStart(1299172990, r7, -1, "androidx.compose.material3.TimePickerTextField (TimePicker.kt:1866)");
    L102:
        Object r2 = r11.rememberedValue();
        Composer.Companion r113 = Composer.Companion;
        if (r2 != r113.getEmpty()) goto L105;
        r2 = InteractionSourceKt.MutableInteractionSource();
        r11.updateRememberedValue(r2);
    L105:
        final MutableInteractionSource r10 = (MutableInteractionSource) r2;
        Object r9 = r11.rememberedValue();
        if (r9 != r113.getEmpty()) goto L108;
        r9 = new FocusRequester();
        r11.updateRememberedValue(r9);
    L108:
        FocusRequester r12 = (FocusRequester) r9;
        final TextFieldColors r13 = OutlinedTextFieldDefaults.INSTANCE.m2971colors0hiis_0(r125.m3388timeSelectorContentColorvNxB06k$material3(true), 0, 0, 0, r125.m3387timeSelectorContainerColorvNxB06k$material3(true), r125.m3387timeSelectorContainerColorvNxB06k$material3(true), 0, 0, 0, 0, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, r11, 0, 0, 0, 0, 3072, 2147483598, 4095);
        boolean r14 = TimePickerSelectionMode.m3435equalsimpl0(r122, r121.mo2286getSelectionyecRtBI());
        Arrangement.Vertical r15 = Arrangement.INSTANCE.getTop();
        Alignment.Companion r17 = Alignment.Companion;
        int r18 = (r7 & 14) >> 3;
        MeasurePolicy r19 = ColumnKt.columnMeasurePolicy(r15, r17.getStart(), r11, (r18 & 14) | (r18 & 112));
        int r20 = ComposablesKt.getCurrentCompositeKeyHash(r11, 0);
        CompositionLocalMap r110 = r11.getCurrentCompositionLocalMap();
        Modifier r114 = ComposedModifierKt.materializeModifier(r11, r118);
        ComposeUiNode.Companion r21 = ComposeUiNode.Companion;
        Function0 r1 = r21.getConstructor();
        if ((r11.getApplier() instanceof Applier) == true) goto L111;
        ComposablesKt.invalidApplier();
    L111:
        r11.startReusableNode();
        if (r11.getInserting() == false) goto L114;
        r11.createNode(r1);
    L115:
        Composer r22 = Updater.constructor-impl(r11);
        Updater.set-impl(r22, r19, r21.getSetMeasurePolicy());
        Updater.set-impl(r22, r110, r21.getSetResolvedCompositionLocals());
        Function2 r23 = r21.getSetCompositeKeyHash();
        if (r22.getInserting() == false) goto L118;
    L119:
        r22.updateRememberedValue(Integer.valueOf(r20));
        r22.apply(Integer.valueOf(r20), r23);
    L120:
        Updater.set-impl(r22, r114, r21.getSetModifier());
        ColumnScopeInstance r24 = ColumnScopeInstance.INSTANCE;
        if (r14 == true) goto L127;
        r11.startReplaceGroup(2023424468);
        Modifier.Companion r25 = Modifier.Companion;
        TimeInputTokens r26 = TimeInputTokens.INSTANCE;
        Modifier r27 = SizeKt.m1016sizeVpY3zN4(r25, r26.getTimeFieldContainerWidth-D9Ej5fM(), r26.getTimeFieldContainerHeight-D9Ej5fM());
        if (TimePickerSelectionMode.m3435equalsimpl0(r122, TimePickerSelectionMode.Companion.m3439getHouryecRtBI()) == false) goto L125;
        int r28 = getHourForDisplay(r121);
    L126:
        int r29 = r7 >> 3;
        m3408TimeSelectorSAnMeKU(r27, r28, r121, r122, r125, r11, ((r7 >> 9) & 57344) | ((r29 & 7168) | ((r29 & 896) | 6)));
        r11.endReplaceGroup();
    L128:
        TimePickerSelectionMode.Companion r210 = TimePickerSelectionMode.Companion;
        if (TimePickerSelectionMode.m3435equalsimpl0(r122, r210.m3440getMinuteyecRtBI()) == false) goto L131;
        int r30 = Strings.constructor-impl(2131911770);
    L132:
        final String r31 = Strings_androidKt.getString-2EP1pXo(r30, r11, 0);
        Modifier.Companion r32 = Modifier.Companion;
        Modifier r33 = visible(r32, r14);
        MeasurePolicy r34 = BoxKt.maybeCachedBoxMeasurePolicy(r17.getTopStart(), false);
        int r35 = ComposablesKt.getCurrentCompositeKeyHash(r11, 0);
        CompositionLocalMap r36 = r11.getCurrentCompositionLocalMap();
        Modifier r37 = ComposedModifierKt.materializeModifier(r11, r33);
        Function0 r38 = r21.getConstructor();
        if ((r11.getApplier() instanceof Applier) == true) goto L135;
        ComposablesKt.invalidApplier();
    L135:
        r11.startReusableNode();
        if (r11.getInserting() == false) goto L138;
        r11.createNode(r38);
    L139:
        Composer r39 = Updater.constructor-impl(r11);
        Updater.set-impl(r39, r34, r21.getSetMeasurePolicy());
        Updater.set-impl(r39, r36, r21.getSetResolvedCompositionLocals());
        Function2 r40 = r21.getSetCompositeKeyHash();
        if (r39.getInserting() == false) goto L142;
    L143:
        r39.updateRememberedValue(Integer.valueOf(r35));
        r39.apply(Integer.valueOf(r35), r40);
    L144:
        Updater.set-impl(r39, r37, r21.getSetModifier());
        BoxScopeInstance r41 = BoxScopeInstance.INSTANCE;
        Modifier r42 = FocusRequesterModifierKt.focusRequester(r32, r12);
        TimeInputTokens r211 = TimeInputTokens.INSTANCE;
        Modifier r43 = SizeKt.m1016sizeVpY3zN4(r42, r211.getTimeFieldContainerWidth-D9Ej5fM(), r211.getTimeFieldContainerHeight-D9Ej5fM());
        boolean r44 = r11.changed(r31);
        Object r45 = r11.rememberedValue();
        if (r44 == false) goto L147;
    L148:
        r45 = new qv(r31);
        r11.updateRememberedValue(r45);
    L149:
        Modifier r46 = SemanticsModifierKt.semantics$default(r43, false, (Function1) r45, 1, null);
        TextStyle r47 = (TextStyle) r11.consume(TextKt.getLocalTextStyle());
        Brush.Companion r212 = Brush.Companion;
        Float r48 = Float.valueOf(MenuKt.ClosedAlphaTarget);
        Color.Companion r49 = Color.Companion;
        Float r50 = Float.valueOf(0.1f);
        MaterialTheme r51 = MaterialTheme.INSTANCE;
        Brush r115 = Brush.Companion.verticalGradient-8A-3gB4$default(r212, new Pair[]{TuplesKt.to(r48, Color.box-impl(r49.getTransparent-0d7_KjU())), TuplesKt.to(Float.valueOf(0.1f), Color.box-impl(r49.getTransparent-0d7_KjU())), TuplesKt.to(r50, Color.box-impl(r51.getColorScheme(r11, 6).m2471getPrimary0d7_KjU())), TuplesKt.to(Float.valueOf(0.9f), Color.box-impl(r51.getColorScheme(r11, 6).m2471getPrimary0d7_KjU())), TuplesKt.to(Float.valueOf(0.9f), Color.box-impl(r49.getTransparent-0d7_KjU())), TuplesKt.to(Float.valueOf(1.0f), Color.box-impl(r49.getTransparent-0d7_KjU()))}, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 0, 14, null);
        Composer r52 = r11;
        ComposableLambda r116 = ComposableLambdaKt.rememberComposableLambda(1007938103, true, new TimePickerKt$TimePickerTextField$1$1$2(r119, r10, r13), r52, 54);
        int r53 = r7 >> 3;
        int r54 = (r53 & 112) | ((r53 & 14) | 100666368);
        int r117 = r7 << 3;
        BasicTextFieldKt.BasicTextField(r119, r120, r46, true, false, r47, r111, r112, true, 0, 0, null, null, r10, r115, r116, r52, (r54 | (r117 & 3670016)) | (r117 & 29360128), 199680, 7696);
        r52.endNode();
        Modifier r55 = OffsetKt.m916offsetVpY3zN4$default(r32, MenuKt.ClosedAlphaTarget, SupportLabelTop, 1, null);
        Object r56 = r52.rememberedValue();
        if (r56 != r113.getEmpty()) goto L152;
        r56 = new rv();
        r52.updateRememberedValue(r56);
    L152:
        Modifier r57 = SemanticsModifierKt.clearAndSetSemantics(r55, (Function1) r56);
        if (TimePickerSelectionMode.m3435equalsimpl0(r122, r210.m3439getHouryecRtBI()) == false) goto L155;
        int r58 = Strings.constructor-impl(2131911762);
    L156:
        boolean r213 = true;
        TextKt.m3363TextNvy7gAk(Strings_androidKt.getString-2EP1pXo(r58, r52, 0), r57, ColorSchemeKt.getValue(r211.getTimeFieldSupportingTextColor(), r52, 6), null, 0, null, null, null, 0, null, null, 0, 0, false, 0, 0, null, TypographyKt.getValue(r211.getTimeFieldSupportingTextFont(), r52, 6), r52, 0, 0, 131064);
        r52.endNode();
        TimePickerSelectionMode r59 = TimePickerSelectionMode.m3432boximpl(r121.mo2286getSelectionyecRtBI());
        if ((r7 & 7168) == 2048) goto L164;
        int r60 = r7 & 4096;
        TimePickerState r61 = r121;
        if (r60 != 0) goto L161;
    L163:
        boolean r129 = false;
    L167:
        if ((r7 & 57344) == 16384) goto L170;
        r213 = false;
    L170:
        boolean r62 = r129 | r213;
        Object r63 = r52.rememberedValue();
        if (r62 == false) goto L173;
    L174:
        r63 = new TimePickerKt$TimePickerTextField$2$1(r61, r122, r12, null);
        r52.updateRememberedValue(r63);
    L175:
        EffectsKt.LaunchedEffect(r59, (Function2) r63, r52, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L178;
        ComposerKt.traceEventEnd();
    L178:
        final KeyboardOptions r64 = r111;
    L180:
        ScopeUpdateScope r130 = r52.endRestartGroup();
        if (r130 == null) goto L184;
        final KeyboardActions r65 = r112;
        r130.updateScope(new sv(r118, r119, r120, r121, r122, r64, r65, r125, r127, r128));
        return;
    L184:
        return;
    L173:
        if (r63 != r113.getEmpty()) goto L175;
    L161:
        if (r52.changedInstance(r61) == false) goto L163;
    L165:
        r129 = true;
        goto L167
    L164:
        r61 = r121;
        goto L165
    L155:
        r58 = Strings.constructor-impl(2131911767);
        goto L156
    L147:
        if (r45 != r113.getEmpty()) goto L149;
    L142:
        if (Intrinsics.areEqual(r39.rememberedValue(), Integer.valueOf(r35)) == true) goto L144;
    L138:
        r11.useNode();
        goto L139
    L131:
        r30 = Strings.constructor-impl(2131911766);
        goto L132
    L125:
        r28 = r121.getMinute();
        goto L126
    L127:
        r11.startReplaceGroup(2023879982);
        r11.endReplaceGroup();
        goto L128
    L118:
        if (Intrinsics.areEqual(r22.rememberedValue(), Integer.valueOf(r20)) == true) goto L120;
    L114:
        r11.useNode();
        goto L115
    L98:
        r112 = r6;
        goto L100
    L95:
        r111 = r5;
        goto L96
    L179:
        r52 = r11;
        r52.skipToGroupEnd();
        r112 = r6;
        r64 = r5;
        goto L180
    L90:
        r8 = false;
        goto L92
    L81:
        if ((r127 & 12582912) != 0) goto L87;
        if (r11.changed(r125) == false) goto L85;
        int r66 = 8388608;
    L86:
        r3 = r3 | r66;
        goto L87
    L85:
        r66 = 4194304;
        goto L86
    L70:
        r6 = r124;
        if ((r127 & 1572864) != 0) goto L78;
        if (r11.changed(r6) == false) goto L75;
        int r131 = 1048576;
    L76:
        r3 = r3 | r131;
        goto L78
    L75:
        r131 = 524288;
        goto L76
    L60:
        if ((196608 & r127) != 0) goto L66;
        r5 = r123;
        if (r11.changed(r5) == false) goto L64;
        int r132 = 131072;
    L65:
        r3 = r3 | r132;
        goto L67
    L64:
        r132 = 65536;
        goto L65
    L50:
        if ((r127 & 24576) != 0) goto L56;
        if (r11.changed(r122) == false) goto L54;
        int r67 = 16384;
    L55:
        r3 = r3 | r67;
        goto L56
    L54:
        r67 = 8192;
        goto L55
    L37:
        if ((r127 & 3072) != 0) goto L47;
        if ((r127 & 4096) != 0) goto L41;
        boolean r68 = r11.changed(r121);
    L42:
        if (r68 == false) goto L44;
        int r69 = 2048;
    L45:
        r3 = r3 | r69;
        goto L47
    L44:
        r69 = 1024;
        goto L45
    L41:
        r68 = r11.changedInstance(r121);
        goto L42
    L27:
        if ((r127 & 384) != 0) goto L34;
        if (r11.changedInstance(r120) == false) goto L31;
        int r70 = 256;
    L32:
        r3 = r3 | r70;
        goto L34
    L31:
        r70 = 128;
        goto L32
    L17:
        if ((r127 & 48) != 0) goto L24;
        if (r11.changed(r119) == false) goto L21;
        int r71 = 32;
    L22:
        r3 = r3 | r71;
        goto L24
    L21:
        r71 = 16;
        goto L22
    L6:
        if ((r127 & 6) == 0) goto L8;
        r3 = r127;
        goto L14
    L8:
        if (r11.changed(r118) == false) goto L10;
        int r72 = 4;
    L11:
        r3 = r72 | r127;
        goto L14
    L10:
        r72 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: access$TimePickerTextField-1vLObsk, reason: not valid java name */
    public static final /* synthetic */ void m3409access$TimePickerTextField1vLObsk(Modifier r0, TextFieldValue r1, Function1 r2, TimePickerState r3, int r4, KeyboardOptions r5, KeyboardActions r6, TimePickerColors r7, Composer r8, int r9, int r10) {
        m3407TimePickerTextField1vLObsk(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10);
    }
}
