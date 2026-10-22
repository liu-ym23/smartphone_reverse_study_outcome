package androidx.compose.material3;

import androidx.biometric.BiometricManager$Authenticators;
import androidx.compose.animation.SplineBasedFloatDecayAnimationSpec_androidKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.text.BasicTextFieldKt;
import androidx.compose.foundation.text.KeyboardActionScope;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.KeyboardActionHandler;
import androidx.compose.foundation.text.input.OutputTransformation;
import androidx.compose.foundation.text.input.TextFieldDecorator;
import androidx.compose.foundation.text.input.TextFieldLineLimits;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.internal.SystemBarsDefaultInsets_androidKt;
import androidx.compose.material3.tokens.ElevationTokens;
import androidx.compose.material3.tokens.FilledTextFieldTokens;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.material3.tokens.SearchBarTokens;
import androidx.compose.material3.tokens.SearchViewTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusChangedModifierKt;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.input.InputMode;
import androidx.compose.ui.input.InputModeManager;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.ImeAction;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J[\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020!2\u000e\b\u0002\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$2\u000e\b\u0002\u0010&\u001a\b\u0012\u0004\u0012\u00020!0'2\u000e\b\u0002\u0010(\u001a\b\u0012\u0004\u0012\u00020!0)2\b\b\u0002\u0010*\u001a\u00020%H\u0007¢\u0006\u0002\u0010+J-\u0010,\u001a\u00020-2\b\b\u0002\u0010.\u001a\u00020/2\b\b\u0002\u00100\u001a\u00020/2\b\b\u0002\u00101\u001a\u000202H\u0007¢\u0006\u0004\b3\u00104Jõ\u0001\u00101\u001a\u0002022\b\b\u0002\u00105\u001a\u00020/2\b\b\u0002\u00106\u001a\u00020/2\b\b\u0002\u00107\u001a\u00020/2\b\b\u0002\u00108\u001a\u00020/2\b\b\u0002\u00109\u001a\u00020:2\b\b\u0002\u0010;\u001a\u00020/2\b\b\u0002\u0010<\u001a\u00020/2\b\b\u0002\u0010=\u001a\u00020/2\b\b\u0002\u0010>\u001a\u00020/2\b\b\u0002\u0010?\u001a\u00020/2\b\b\u0002\u0010@\u001a\u00020/2\b\b\u0002\u0010A\u001a\u00020/2\b\b\u0002\u0010B\u001a\u00020/2\b\b\u0002\u0010C\u001a\u00020/2\b\b\u0002\u0010D\u001a\u00020/2\b\b\u0002\u0010E\u001a\u00020/2\b\b\u0002\u0010F\u001a\u00020/2\b\b\u0002\u0010G\u001a\u00020/2\b\b\u0002\u0010H\u001a\u00020/2\b\b\u0002\u0010I\u001a\u00020/2\b\b\u0002\u0010J\u001a\u00020/2\b\b\u0002\u0010K\u001a\u00020/2\b\b\u0002\u0010L\u001a\u00020/H\u0007¢\u0006\u0004\bM\u0010NJ\u008e\u0002\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020R2\u0006\u0010S\u001a\u00020T2\u0012\u0010U\u001a\u000e\u0012\u0004\u0012\u00020W\u0012\u0004\u0012\u00020P0V2\b\b\u0002\u0010X\u001a\u00020Y2\b\b\u0002\u0010Z\u001a\u00020%2\b\b\u0002\u0010[\u001a\u00020%2\b\b\u0002\u0010\\\u001a\u00020]2\u0015\b\u0002\u0010^\u001a\u000f\u0012\u0004\u0012\u00020P\u0018\u00010$¢\u0006\u0002\b_2\u0015\b\u0002\u0010`\u001a\u000f\u0012\u0004\u0012\u00020P\u0018\u00010$¢\u0006\u0002\b_2\u0015\b\u0002\u0010a\u001a\u000f\u0012\u0004\u0012\u00020P\u0018\u00010$¢\u0006\u0002\b_2\u0015\b\u0002\u0010b\u001a\u000f\u0012\u0004\u0012\u00020P\u0018\u00010$¢\u0006\u0002\b_2\u0015\b\u0002\u0010c\u001a\u000f\u0012\u0004\u0012\u00020P\u0018\u00010$¢\u0006\u0002\b_2\n\b\u0002\u0010d\u001a\u0004\u0018\u00010e2\n\b\u0002\u0010f\u001a\u0004\u0018\u00010g2\b\b\u0002\u0010h\u001a\u00020i2\b\b\u0002\u0010j\u001a\u00020\u00112\b\b\u0002\u0010,\u001a\u0002022\n\b\u0002\u0010k\u001a\u0004\u0018\u00010lH\u0007¢\u0006\u0002\u0010mJ¢\u0002\u0010O\u001a\u00020P2\u0006\u0010n\u001a\u00020R2\u0012\u0010U\u001a\u000e\u0012\u0004\u0012\u00020W\u0012\u0004\u0012\u00020P0V2\u0006\u0010o\u001a\u00020%2\u0012\u0010p\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020P0V2\b\b\u0002\u0010X\u001a\u00020Y2\b\b\u0002\u0010Z\u001a\u00020%2\b\b\u0002\u0010[\u001a\u00020%2\b\b\u0002\u0010\\\u001a\u00020]2\u0015\b\u0002\u0010^\u001a\u000f\u0012\u0004\u0012\u00020P\u0018\u00010$¢\u0006\u0002\b_2\u0015\b\u0002\u0010`\u001a\u000f\u0012\u0004\u0012\u00020P\u0018\u00010$¢\u0006\u0002\b_2\u0015\b\u0002\u0010a\u001a\u000f\u0012\u0004\u0012\u00020P\u0018\u00010$¢\u0006\u0002\b_2\u0015\b\u0002\u0010b\u001a\u000f\u0012\u0004\u0012\u00020P\u0018\u00010$¢\u0006\u0002\b_2\u0015\b\u0002\u0010c\u001a\u000f\u0012\u0004\u0012\u00020P\u0018\u00010$¢\u0006\u0002\b_2\n\b\u0002\u0010d\u001a\u0004\u0018\u00010e2\n\b\u0002\u0010f\u001a\u0004\u0018\u00010g2\b\b\u0002\u0010h\u001a\u00020i2\b\b\u0002\u0010j\u001a\u00020\u00112\b\b\u0002\u0010,\u001a\u0002022\n\b\u0002\u0010k\u001a\u0004\u0018\u00010lH\u0007¢\u0006\u0002\u0010qJÈ\u0001\u0010O\u001a\u00020P2\u0006\u0010r\u001a\u00020W2\u0012\u0010s\u001a\u000e\u0012\u0004\u0012\u00020W\u0012\u0004\u0012\u00020P0V2\u0012\u0010U\u001a\u000e\u0012\u0004\u0012\u00020W\u0012\u0004\u0012\u00020P0V2\u0006\u0010o\u001a\u00020%2\u0012\u0010p\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020P0V2\b\b\u0002\u0010X\u001a\u00020Y2\b\b\u0002\u0010Z\u001a\u00020%2\u0015\b\u0002\u0010^\u001a\u000f\u0012\u0004\u0012\u00020P\u0018\u00010$¢\u0006\u0002\b_2\u0015\b\u0002\u0010`\u001a\u000f\u0012\u0004\u0012\u00020P\u0018\u00010$¢\u0006\u0002\b_2\u0015\b\u0002\u0010a\u001a\u000f\u0012\u0004\u0012\u00020P\u0018\u00010$¢\u0006\u0002\b_2\b\b\u0002\u0010,\u001a\u0002022\n\b\u0002\u0010k\u001a\u0004\u0018\u00010lH\u0007¢\u0006\u0002\u0010tJ#\u0010,\u001a\u00020-2\b\b\u0002\u0010.\u001a\u00020/2\b\b\u0002\u00100\u001a\u00020/H\u0007¢\u0006\u0004\bu\u0010vJ\u009b\u0001\u00101\u001a\u0002022\b\b\u0002\u00105\u001a\u00020/2\b\b\u0002\u00106\u001a\u00020/2\b\b\u0002\u00107\u001a\u00020/2\b\b\u0002\u00108\u001a\u00020/2\b\b\u0002\u00109\u001a\u00020:2\b\b\u0002\u0010;\u001a\u00020/2\b\b\u0002\u0010<\u001a\u00020/2\b\b\u0002\u0010=\u001a\u00020/2\b\b\u0002\u0010>\u001a\u00020/2\b\b\u0002\u0010?\u001a\u00020/2\b\b\u0002\u0010@\u001a\u00020/2\b\b\u0002\u0010A\u001a\u00020/2\b\b\u0002\u0010B\u001a\u00020/2\b\b\u0002\u0010C\u001a\u00020/H\u0007¢\u0006\u0004\bw\u0010xJ\u0087\u0001\u00101\u001a\u0002022\b\b\u0002\u0010y\u001a\u00020/2\b\b\u0002\u00107\u001a\u00020/2\b\b\u0002\u00108\u001a\u00020/2\b\b\u0002\u00109\u001a\u00020:2\b\b\u0002\u0010;\u001a\u00020/2\b\b\u0002\u0010<\u001a\u00020/2\b\b\u0002\u0010=\u001a\u00020/2\b\b\u0002\u0010>\u001a\u00020/2\b\b\u0002\u0010?\u001a\u00020/2\b\b\u0002\u0010@\u001a\u00020/2\b\b\u0002\u0010z\u001a\u00020/2\b\b\u0002\u0010C\u001a\u00020/H\u0007¢\u0006\u0004\b{\u0010|R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u001e\u0010\u000b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\b\u0012\u0004\b\f\u0010\u0003\u001a\u0004\b\r\u0010\u0007R\u0013\u0010\u000e\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000f\u0010\u0007R\u0011\u0010\u0010\u001a\u00020\u00118G¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00118G¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\u0016\u001a\u00020\u00118G¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0013R\u0011\u0010\u0018\u001a\u00020\u00198G¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u00198G¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001b¨\u0006}²\u0006\n\u0010~\u001a\u00020%X\u008a\u0084\u0002"}, d2 = {"Landroidx/compose/material3/SearchBarDefaults;", "", "<init>", "()V", "TonalElevation", "Landroidx/compose/ui/unit/Dp;", "getTonalElevation-D9Ej5fM", "()F", "F", "ShadowElevation", "getShadowElevation-D9Ej5fM", "Elevation", "getElevation-D9Ej5fM$annotations", "getElevation-D9Ej5fM", "InputFieldHeight", "getInputFieldHeight-D9Ej5fM", "inputFieldShape", "Landroidx/compose/ui/graphics/Shape;", "getInputFieldShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "fullScreenShape", "getFullScreenShape", "dockedShape", "getDockedShape", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "getWindowInsets", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/layout/WindowInsets;", "fullScreenWindowInsets", "getFullScreenWindowInsets", "enterAlwaysSearchBarScrollBehavior", "Landroidx/compose/material3/SearchBarScrollBehavior;", "initialOffset", "", "initialOffsetLimit", "canScroll", "Lkotlin/Function0;", "", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "flingAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "reverseLayout", "(FFLkotlin/jvm/functions/Function0;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/DecayAnimationSpec;ZLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SearchBarScrollBehavior;", "colors", "Landroidx/compose/material3/SearchBarColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "dividerColor", "inputFieldColors", "Landroidx/compose/material3/TextFieldColors;", "colors-Klgx-Pg", "(JJLandroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SearchBarColors;", "focusedTextColor", "unfocusedTextColor", "disabledTextColor", "cursorColor", "selectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "focusedLeadingIconColor", "unfocusedLeadingIconColor", "disabledLeadingIconColor", "focusedTrailingIconColor", "unfocusedTrailingIconColor", "disabledTrailingIconColor", "focusedPlaceholderColor", "unfocusedPlaceholderColor", "disabledPlaceholderColor", "focusedPrefixColor", "unfocusedPrefixColor", "disabledPrefixColor", "focusedSuffixColor", "unfocusedSuffixColor", "disabledSuffixColor", "focusedContainerColor", "unfocusedContainerColor", "disabledContainerColor", "inputFieldColors-JVEmHcM", "(JJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIII)Landroidx/compose/material3/TextFieldColors;", "InputField", "", "textFieldState", "Landroidx/compose/foundation/text/input/TextFieldState;", "searchBarState", "Landroidx/compose/material3/SearchBarState;", "onSearch", "Lkotlin/Function1;", "", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "readOnly", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "placeholder", "Landroidx/compose/runtime/Composable;", "leadingIcon", "trailingIcon", "prefix", "suffix", "inputTransformation", "Landroidx/compose/foundation/text/input/InputTransformation;", "outputTransformation", "Landroidx/compose/foundation/text/input/OutputTransformation;", "scrollState", "Landroidx/compose/foundation/ScrollState;", "shape", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Landroidx/compose/foundation/text/input/TextFieldState;Landroidx/compose/material3/SearchBarState;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/text/input/InputTransformation;Landroidx/compose/foundation/text/input/OutputTransformation;Landroidx/compose/foundation/ScrollState;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "state", "expanded", "onExpandedChange", "(Landroidx/compose/foundation/text/input/TextFieldState;Lkotlin/jvm/functions/Function1;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/text/input/InputTransformation;Landroidx/compose/foundation/text/input/OutputTransformation;Landroidx/compose/foundation/ScrollState;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "query", "onQueryChange", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "colors-dgg9oW8", "(JJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SearchBarColors;", "inputFieldColors-ITpI4ow", "(JJJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/TextFieldColors;", "textColor", "placeholderColor", "inputFieldColors--u-KgnY", "(JJJLandroidx/compose/foundation/text/selection/TextSelectionColors;JJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/TextFieldColors;", "material3", "focused"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SearchBarDefaults {
    public static final int $stable = 0;
    private static final float Elevation = 0.0f;
    public static final SearchBarDefaults INSTANCE = null;
    private static final float InputFieldHeight = 0.0f;
    private static final float ShadowElevation = 0.0f;
    private static final float TonalElevation = 0.0f;

    private SearchBarDefaults() {
    }

    private static final Unit InputField$lambda$20(SearchBarDefaults r23, TextFieldState r24, SearchBarState r25, Function1 r26, Modifier r27, boolean r28, boolean r29, TextStyle r30, Function2 r31, Function2 r32, Function2 r33, Function2 r34, Function2 r35, InputTransformation r36, OutputTransformation r37, ScrollState r38, Shape r39, TextFieldColors r40, MutableInteractionSource r41, int r42, int r43, int r44, Composer r45, int r46) {
        r23.InputField(r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r45, RecomposeScopeImplKt.updateChangedFlags(r42 | 1), RecomposeScopeImplKt.updateChangedFlags(r43), r44);
        return Unit.INSTANCE;
    }

    private static final Unit InputField$lambda$33(SearchBarDefaults r24, TextFieldState r25, Function1 r26, boolean r27, Function1 r28, Modifier r29, boolean r30, boolean r31, TextStyle r32, Function2 r33, Function2 r34, Function2 r35, Function2 r36, Function2 r37, InputTransformation r38, OutputTransformation r39, ScrollState r40, Shape r41, TextFieldColors r42, MutableInteractionSource r43, int r44, int r45, int r46, Composer r47, int r48) {
        r24.InputField(r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r47, RecomposeScopeImplKt.updateChangedFlags(r44 | 1), RecomposeScopeImplKt.updateChangedFlags(r45), r46);
        return Unit.INSTANCE;
    }

    private static final Unit InputField$lambda$44(SearchBarDefaults r17, String r18, Function1 r19, Function1 r20, boolean r21, Function1 r22, Modifier r23, boolean r24, Function2 r25, Function2 r26, Function2 r27, TextFieldColors r28, MutableInteractionSource r29, int r30, int r31, int r32, Composer r33, int r34) {
        r17.InputField(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r33, RecomposeScopeImplKt.updateChangedFlags(r30 | 1), RecomposeScopeImplKt.updateChangedFlags(r31), r32);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(SearchBarDefaults r1, String r2, Function1 r3, Function1 r4, boolean r5, Function1 r6, Modifier r7, boolean r8, Function2 r9, Function2 r10, Function2 r11, TextFieldColors r12, MutableInteractionSource r13, int r14, int r15, int r16, Composer r17, int r18) {
        return InputField$lambda$44(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public static /* synthetic */ Unit b(SearchBarDefaults r1, TextFieldState r2, SearchBarState r3, Function1 r4, Modifier r5, boolean r6, boolean r7, TextStyle r8, Function2 r9, Function2 r10, Function2 r11, Function2 r12, Function2 r13, InputTransformation r14, OutputTransformation r15, ScrollState r16, Shape r17, TextFieldColors r18, MutableInteractionSource r19, int r20, int r21, int r22, Composer r23, int r24) {
        return InputField$lambda$20(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24);
    }

    public static /* synthetic */ void c(Function1 r0, TextFieldState r1, Function0 r2) {
        InputField$lambda$29$lambda$28(r0, r1, r2);
    }

    public static /* synthetic */ Unit d(Function1 r0, FocusState r1) {
        return InputField$lambda$38$lambda$37(r0, r1);
    }

    public static /* synthetic */ Unit e(String r0, boolean r1, String r2, SemanticsPropertyReceiver r3) {
        return InputField$lambda$27$lambda$26(r0, r1, r2, r3);
    }

    private static final boolean enterAlwaysSearchBarScrollBehavior$lambda$1$lambda$0() {
        return true;
    }

    public static /* synthetic */ EnterAlwaysSearchBarScrollBehavior f(float r0, float r1, Function0 r2, boolean r3, AnimationSpec r4, DecayAnimationSpec r5) {
        return enterAlwaysSearchBarScrollBehavior$lambda$3$lambda$2(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ boolean g() {
        return enterAlwaysSearchBarScrollBehavior$lambda$1$lambda$0();
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Renamed to TonalElevation. Not to be confused with ShadowElevation.", replaceWith = @ReplaceWith(expression = "TonalElevation", imports = {}))
    /* JADX INFO: renamed from: getElevation-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m3040getElevationD9Ej5fM$annotations() {
    }

    public static /* synthetic */ Unit h(boolean r0, CoroutineScope r1, SearchBarState r2, FocusState r3) {
        return InputField$lambda$9$lambda$8(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit i(SearchBarDefaults r1, TextFieldState r2, Function1 r3, boolean r4, Function1 r5, Modifier r6, boolean r7, boolean r8, TextStyle r9, Function2 r10, Function2 r11, Function2 r12, Function2 r13, Function2 r14, InputTransformation r15, OutputTransformation r16, ScrollState r17, Shape r18, TextFieldColors r19, MutableInteractionSource r20, int r21, int r22, int r23, Composer r24, int r25) {
        return InputField$lambda$33(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25);
    }

    public static /* synthetic */ Unit j(Function1 r0, FocusState r1) {
        return InputField$lambda$25$lambda$24(r0, r1);
    }

    public static /* synthetic */ Unit k(Function1 r0, String r1, KeyboardActionScope r2) {
        return InputField$lambda$42$lambda$41(r0, r1, r2);
    }

    public static /* synthetic */ Unit l(SearchBarState r0, CoroutineScope r1) {
        return InputField$lambda$17$lambda$16(r0, r1);
    }

    public static /* synthetic */ Unit m(String r0, boolean r1, String r2, SemanticsPropertyReceiver r3) {
        return InputField$lambda$40$lambda$39(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit n(String r0, SearchBarState r1, String r2, SemanticsPropertyReceiver r3) {
        return InputField$lambda$11$lambda$10(r0, r1, r2, r3);
    }

    public static /* synthetic */ void o(Function1 r0, TextFieldState r1, Function0 r2) {
        InputField$lambda$13$lambda$12(r0, r1, r2);
    }

    static {
        INSTANCE = new SearchBarDefaults();
        ElevationTokens r0 = ElevationTokens.INSTANCE;
        float r1 = r0.getLevel0-D9Ej5fM();
        TonalElevation = r1;
        ShadowElevation = r0.getLevel0-D9Ej5fM();
        Elevation = r1;
        InputFieldHeight = SearchBarTokens.INSTANCE.getContainerHeight-D9Ej5fM();
    }

    /* JADX INFO: renamed from: getElevation-D9Ej5fM, reason: not valid java name */
    public final float m3043getElevationD9Ej5fM() {
        return Elevation;
    }

    /* JADX INFO: renamed from: getInputFieldHeight-D9Ej5fM, reason: not valid java name */
    public final float m3044getInputFieldHeightD9Ej5fM() {
        return InputFieldHeight;
    }

    /* JADX INFO: renamed from: getShadowElevation-D9Ej5fM, reason: not valid java name */
    public final float m3045getShadowElevationD9Ej5fM() {
        return ShadowElevation;
    }

    /* JADX INFO: renamed from: getTonalElevation-D9Ej5fM, reason: not valid java name */
    public final float m3046getTonalElevationD9Ej5fM() {
        return TonalElevation;
    }

    private static final boolean InputField$lambda$5(State<Boolean> r0) {
        return ((Boolean) r0.getValue()).booleanValue();
    }

    public static final /* synthetic */ boolean access$InputField$lambda$5(State r0) {
        return InputField$lambda$5(r0);
    }

    private static final Unit InputField$lambda$17$lambda$16(SearchBarState r7, CoroutineScope r8) {
        if (SearchBarKt.access$isExpanded(r7) == true) goto L6;
        BuildersKt.launch$default(r8, null, null, new SearchBarDefaults$InputField$8$1$1(r7, null), 3, null);
    L6:
        return Unit.INSTANCE;
    }

    private static final Unit InputField$lambda$25$lambda$24(Function1 r0, FocusState r1) {
        if (r1.isFocused() == false) goto L6;
        r0.invoke(Boolean.TRUE);
    L6:
        return Unit.INSTANCE;
    }

    private static final Unit InputField$lambda$38$lambda$37(Function1 r0, FocusState r1) {
        if (r1.isFocused() == false) goto L6;
        r0.invoke(Boolean.TRUE);
    L6:
        return Unit.INSTANCE;
    }

    public final Shape getDockedShape(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1447354121, r5, -1, "androidx.compose.material3.SearchBarDefaults.<get-dockedShape> (SearchBar.kt:1047)");
    L5:
        Shape r6 = ShapesKt.getValue(SearchViewTokens.INSTANCE.getDockedContainerShape(), r4, 6);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    public final Shape getFullScreenShape(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-2009956471, r5, -1, "androidx.compose.material3.SearchBarDefaults.<get-fullScreenShape> (SearchBar.kt:1043)");
    L5:
        Shape r6 = ShapesKt.getValue(SearchViewTokens.INSTANCE.getFullScreenContainerShape(), r4, 6);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    public final WindowInsets getFullScreenWindowInsets(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1745169224, r5, -1, "androidx.compose.material3.SearchBarDefaults.<get-fullScreenWindowInsets> (SearchBar.kt:1059)");
    L5:
        WindowInsets r6 = WindowInsets_androidKt.getSafeDrawing(WindowInsets.Companion, r4, 6);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    public final Shape getInputFieldShape(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1770571533, r5, -1, "androidx.compose.material3.SearchBarDefaults.<get-inputFieldShape> (SearchBar.kt:1039)");
    L5:
        Shape r6 = ShapesKt.getValue(SearchBarTokens.INSTANCE.getContainerShape(), r4, 6);
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    public final WindowInsets getWindowInsets(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-1795925906, r5, -1, "androidx.compose.material3.SearchBarDefaults.<get-windowInsets> (SearchBar.kt:1053)");
    L5:
        WindowInsets r6 = SystemBarsDefaultInsets_androidKt.getSystemBarsForVisualComponents(WindowInsets.Companion, r4, 6);
        WindowInsetsSides.Companion r7 = WindowInsetsSides.Companion;
        WindowInsets r8 = WindowInsetsKt.m1046onlybOOhFvg(r6, WindowInsetsSides.m1060plusgK_yJZ4(r7.m1070getHorizontalJoeWqyM(), r7.m1074getTopJoeWqyM()));
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r8;
    }

    private static final void InputField$lambda$13$lambda$12(Function1 r0, TextFieldState r1, Function0 r2) {
        r0.invoke(r1.getText().toString());
    }

    private static final void InputField$lambda$29$lambda$28(Function1 r0, TextFieldState r1, Function0 r2) {
        r0.invoke(r1.getText().toString());
    }

    private static final Unit InputField$lambda$42$lambda$41(Function1 r0, String r1, KeyboardActionScope r2) {
        r0.invoke(r1);
        return Unit.INSTANCE;
    }

    private static final Unit InputField$lambda$11$lambda$10(String r0, SearchBarState r1, String r2, SemanticsPropertyReceiver r3) {
        SemanticsPropertiesKt.setContentDescription(r3, r0);
        if (SearchBarKt.access$isExpanded(r1) == false) goto L6;
        SemanticsPropertiesKt.setStateDescription(r3, r2);
    L6:
        return Unit.INSTANCE;
    }

    private static final Unit InputField$lambda$27$lambda$26(String r0, boolean r1, String r2, SemanticsPropertyReceiver r3) {
        SemanticsPropertiesKt.setContentDescription(r3, r0);
        if (r1 == false) goto L6;
        SemanticsPropertiesKt.setStateDescription(r3, r2);
    L6:
        return Unit.INSTANCE;
    }

    private static final Unit InputField$lambda$40$lambda$39(String r0, boolean r1, String r2, SemanticsPropertyReceiver r3) {
        SemanticsPropertiesKt.setContentDescription(r3, r0);
        if (r1 == false) goto L6;
        SemanticsPropertiesKt.setStateDescription(r3, r2);
    L6:
        return Unit.INSTANCE;
    }

    private static final Unit InputField$lambda$9$lambda$8(boolean r6, CoroutineScope r7, SearchBarState r8, FocusState r9) {
        if (r9.isFocused() == false) goto L7;
        if (r6 == false) goto L7;
        BuildersKt.launch$default(r7, null, null, new SearchBarDefaults$InputField$2$1$1(r8, null), 3, null);
    L7:
        return Unit.INSTANCE;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* JADX INFO: renamed from: colors-dgg9oW8, reason: not valid java name */
    public final /* synthetic */ SearchBarColors m3042colorsdgg9oW8(long r57, long r59, Composer r61, int r62, int r63) {
        if ((r63 & 1) == 0) goto L5;
        long r51 = ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getContainerColor(), r61, 6);
    L7:
        if ((r63 & 2) == 0) goto L9;
        long r53 = ColorSchemeKt.getValue(SearchViewTokens.INSTANCE.getDividerColor(), r61, 6);
    L11:
        if (ComposerKt.isTraceInProgress() == false) goto L13;
        ComposerKt.traceEventStart(891254734, r62, -1, "androidx.compose.material3.SearchBarDefaults.colors (SearchBar.kt:1753)");
    L13:
        int r1 = r62 << 3;
        long r40 = r51;
        long r42 = r51;
        long r44 = r51;
        long r58 = r51;
        long r60 = r53;
        SearchBarColors r55 = new SearchBarColors(r58, r60, m3049inputFieldColorsJVEmHcM(0, 0, 0, 0, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, r40, r42, r44, r61, 0, 0, (((r62 & 14) | (r1 & 112)) | ((r62 << 6) & 896)) | (r1 & 7168), 1048575), null);
        if (ComposerKt.isTraceInProgress() == false) goto L16;
        ComposerKt.traceEventEnd();
    L16:
        return r55;
    L9:
        r53 = r59;
        goto L11
    L5:
        r51 = r57;
        goto L7
    }

    private static final EnterAlwaysSearchBarScrollBehavior enterAlwaysSearchBarScrollBehavior$lambda$3$lambda$2(float r8, float r9, Function0 r10, boolean r11, AnimationSpec r12, DecayAnimationSpec r13) {
        return new EnterAlwaysSearchBarScrollBehavior(r8, r9, r10, r11, r12, r13);
    }

    /* JADX INFO: renamed from: colors-Klgx-Pg, reason: not valid java name */
    public final SearchBarColors m3041colorsKlgxPg(long r56, long r58, TextFieldColors r60, Composer r61, int r62, int r63) {
        if ((r63 & 1) == 0) goto L5;
        long r51 = ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getContainerColor(), r61, 6);
    L7:
        if ((r63 & 2) == 0) goto L9;
        long r53 = ColorSchemeKt.getValue(SearchViewTokens.INSTANCE.getDividerColor(), r61, 6);
    L11:
        if ((r63 & 4) == 0) goto L13;
        int r49 = (((r62 & 14) | ((r62 << 3) & 112)) | ((r62 << 6) & 896)) | (r62 & 7168);
        TextFieldColors r0 = m3049inputFieldColorsJVEmHcM(0, 0, 0, 0, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, r51, r51, r51, r61, 0, 0, r49, 1048575);
    L15:
        if (ComposerKt.isTraceInProgress() == false) goto L17;
        ComposerKt.traceEventStart(701925149, r62, -1, "androidx.compose.material3.SearchBarDefaults.colors (SearchBar.kt:1137)");
    L17:
        SearchBarColors r1 = new SearchBarColors(r51, r53, r0, null);
        if (ComposerKt.isTraceInProgress() == false) goto L20;
        ComposerKt.traceEventEnd();
    L20:
        return r1;
    L13:
        r0 = r60;
        goto L15
    L9:
        r53 = r58;
        goto L11
    L5:
        r51 = r56;
        goto L7
    }

    public final SearchBarScrollBehavior enterAlwaysSearchBarScrollBehavior(float r17, float r18, Function0<Boolean> r19, AnimationSpec<Float> r20, DecayAnimationSpec<Float> r21, boolean r22, Composer r23, int r24, int r25) {
        if ((r25 & 1) == 0) goto L5;
        final float r4 = MenuKt.ClosedAlphaTarget;
    L7:
        if ((r25 & 2) == 0) goto L9;
        final float r5 = -3.4028235E38f;
    L11:
        if ((r25 & 4) == 0) goto L16;
        Object r2 = r23.rememberedValue();
        if (r2 != Composer.Companion.getEmpty()) goto L15;
        r2 = new dl();
        r23.updateRememberedValue(r2);
    L15:
        final Function0<Boolean> r6 = (Function0) r2;
    L18:
        if ((r25 & 8) == 0) goto L20;
        final AnimationSpec<Float> r8 = MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultEffects, r23, 6);
    L22:
        if ((r25 & 16) == 0) goto L24;
        final DecayAnimationSpec<Float> r9 = SplineBasedFloatDecayAnimationSpec_androidKt.rememberSplineBasedDecay(r23, 0);
    L26:
        if ((r25 & 32) == 0) goto L28;
        final boolean r7 = false;
    L30:
        if (ComposerKt.isTraceInProgress() == false) goto L32;
        ComposerKt.traceEventStart(1222500790, r24, -1, "androidx.compose.material3.SearchBarDefaults.enterAlwaysSearchBarScrollBehavior (SearchBar.kt:1094)");
    L32:
        boolean r13 = true;
        Object[] r12 = {r8, r9, r6, Boolean.valueOf(r7)};
        Saver<EnterAlwaysSearchBarScrollBehavior, ?> r14 = EnterAlwaysSearchBarScrollBehavior.Companion.Saver(r6, r8, r9);
        if ((6 ^ (r24 & 14)) <= 4) goto L37;
        if (r23.changed(r4) == false) goto L37;
    L38:
        boolean r3 = true;
    L41:
        if (((r24 & 112) ^ 48) <= 32) goto L45;
        if (r23.changed(r5) == false) goto L45;
    L46:
        boolean r10 = true;
    L48:
        boolean r11 = r10 | r3;
        if (((r24 & 896) ^ 384) <= 256) goto L53;
        if (r23.changed(r6) == false) goto L53;
    L54:
        boolean r15 = true;
    L56:
        boolean r16 = r11 | r15;
        if (((458752 & r24) ^ 196608) <= 131072) goto L61;
        if (r23.changed(r7) == false) goto L61;
    L64:
        boolean r1 = ((r16 | r13) | r23.changedInstance(r8)) | r23.changedInstance(r9);
        Object r26 = r23.rememberedValue();
        if (r1 == false) goto L67;
    L68:
        r26 = new jl(r4, r5, r6, r7, r8, r9);
        r23.updateRememberedValue(r26);
    L69:
        EnterAlwaysSearchBarScrollBehavior r0 = (EnterAlwaysSearchBarScrollBehavior) RememberSaveableKt.rememberSaveable(r12, r14, (Function0) r26, r23, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L72;
        ComposerKt.traceEventEnd();
    L72:
        return r0;
    L67:
        if (r26 != Composer.Companion.getEmpty()) goto L69;
    L61:
        if ((r24 & 196608) == 131072) goto L64;
        r13 = false;
    L53:
        if ((r24 & 384) == 256) goto L54;
        r15 = false;
    L45:
        if ((r24 & 48) == 32) goto L46;
        r10 = false;
    L37:
        if ((r24 & 6) == 4) goto L38;
        r3 = false;
        goto L41
    L28:
        r7 = r22;
        goto L30
    L24:
        r9 = r21;
        goto L26
    L20:
        r8 = r20;
        goto L22
    L16:
        r6 = r19;
        goto L18
    L9:
        r5 = r18;
        goto L11
    L5:
        r4 = r17;
        goto L7
    }

    public final void InputField(final String r71, final Function1<? super String, Unit> r72, final Function1<? super String, Unit> r73, final boolean r74, final Function1<? super Boolean, Unit> r75, Modifier r76, boolean r77, Function2<? super Composer, ? super Integer, Unit> r78, Function2<? super Composer, ? super Integer, Unit> r79, Function2<? super Composer, ? super Integer, Unit> r80, TextFieldColors r81, MutableInteractionSource r82, Composer r83, final int r84, final int r85, final int r86) {
        Composer r7 = r83.startRestartGroup(748018311);
        if ((r86 & 1) == 0) goto L6;
        int r1 = r84 | 6;
    L14:
        if ((r86 & 2) == 0) goto L17;
        r1 = r1 | 48;
    L24:
        int r16 = 128;
        if ((r86 & 4) == 0) goto L28;
        r1 = r1 | 384;
    L35:
        if ((r86 & 8) == 0) goto L38;
        r1 = r1 | 3072;
    L45:
        if ((r86 & 16) == 0) goto L48;
        r1 = r1 | 24576;
    L54:
        int r13 = r86 & 32;
        if (r13 == 0) goto L58;
        r1 = r1 | 196608;
    L64:
        int r19 = r86 & 64;
        if (r19 == 0) goto L68;
        r1 = r1 | 1572864;
    L74:
        int r5 = r86 & 128;
        if (r5 == 0) goto L78;
        r1 = r1 | 12582912;
    L84:
        int r0 = r86 & 256;
        if (r0 == 0) goto L88;
        r1 = r1 | 100663296;
    L94:
        int r2 = r86 & 512;
        if (r2 == 0) goto L98;
        r1 = r1 | 805306368;
    L105:
        if ((r85 & 6) == 0) goto L107;
        int r20 = r85;
    L115:
        int r3 = r86 & 2048;
        if (r3 == 0) goto L119;
        r20 = r20 | 48;
    L125:
        int r4 = r20;
        if ((r86 & 4096) == 0) goto L129;
        r4 = r4 | 384;
    L136:
        if ((r1 & 306783379) == 306783378) goto L138;
    L141:
        boolean r6 = true;
    L143:
        if (r7.shouldExecute(r6, r1 & 1) == false) goto L241;
        r7.startDefaults();
        if ((r84 & 1) != 0) goto L147;
    L153:
        if (r13 == 0) goto L155;
        Modifier r8 = Modifier.Companion;
    L156:
        if (r19 == 0) goto L158;
        boolean r14 = true;
    L159:
        if (r5 == 0) goto L161;
        Function2<? super Composer, ? super Integer, Unit> r9 = null;
    L162:
        if (r0 == 0) goto L164;
        Function2<? super Composer, ? super Integer, Unit> r10 = null;
    L165:
        if (r2 == 0) goto L167;
        Function2<? super Composer, ? super Integer, Unit> r11 = null;
    L169:
        if ((r86 & 1024) == 0) goto L171;
        TextFieldColors r12 = m3049inputFieldColorsJVEmHcM(0, 0, 0, 0, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, r7, 0, 0, (r4 << 3) & 7168, 8388607);
        r4 = r4 & (-15);
    L172:
        if (r3 == 0) goto L174;
        Function2<? super Composer, ? super Integer, Unit> r31 = r10;
        Function2<? super Composer, ? super Integer, Unit> r32 = r11;
        Function2<? super Composer, ? super Integer, Unit> r30 = r9;
        Modifier r29 = r8;
        TextFieldColors r15 = r12;
        boolean r17 = r14;
        MutableInteractionSource r33 = null;
    L175:
        r7.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L178;
        ComposerKt.traceEventStart(748018311, r1, r4, "androidx.compose.material3.SearchBarDefaults.InputField (SearchBar.kt:1655)");
    L178:
        if (r33 != null) goto L183;
        r7.startReplaceGroup(1923851092);
        Object r18 = r7.rememberedValue();
        if (r18 != Composer.Companion.getEmpty()) goto L182;
        r18 = InteractionSourceKt.MutableInteractionSource();
        r7.updateRememberedValue(r18);
    L182:
        r7.endReplaceGroup();
        MutableInteractionSource r21 = (MutableInteractionSource) r18;
    L184:
        final boolean r22 = ((Boolean) FocusInteractionKt.collectIsFocusedAsState(r21, r7, 0).getValue()).booleanValue();
        Object r23 = r7.rememberedValue();
        Composer.Companion r34 = Composer.Companion;
        if (r23 != r34.getEmpty()) goto L187;
        r23 = new FocusRequester();
        r7.updateRememberedValue(r23);
    L187:
        FocusRequester r24 = (FocusRequester) r23;
        FocusManager r25 = (FocusManager) r7.consume(CompositionLocalsKt.getLocalFocusManager());
        final String r26 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(2131911755), r7, 0);
        final String r110 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(2131911758), r7, 0);
        long r111 = ((TextStyle) r7.consume(TextKt.getLocalTextStyle())).getColor-0d7_KjU();
        if (r111 == 16) goto L190;
        boolean r112 = true;
    L191:
        if (r112 == true) goto L194;
        r111 = r15.m3328textColorXeAY9LY$material3(r17, false, r22);
    L194:
        long r36 = r111;
        float r113 = SearchBarKt.getSearchBarMinWidth();
        float r114 = SearchBarKt.access$getSearchBarMaxWidth$p();
        Modifier r710 = r29;
        Modifier r27 = FocusRequesterModifierKt.focusRequester(SizeKt.m1018sizeInqDBjuR0$default(r710, r113, InputFieldHeight, r114, MenuKt.ClosedAlphaTarget, 8, null), r24);
        if ((57344 & r1) != 16384) goto L197;
        boolean r28 = true;
    L198:
        Object r115 = r7.rememberedValue();
        if (r28 == false) goto L201;
    L202:
        r115 = new ol(r75);
        r7.updateRememberedValue(r115);
    L203:
        Modifier r35 = FocusChangedModifierKt.onFocusChanged(r27, (Function1) r115);
        boolean r37 = r7.changed(r26);
        if ((r1 & 7168) != 2048) goto L206;
        boolean r38 = true;
    L207:
        boolean r39 = (r37 | r38) | r7.changed(r110);
        Object r40 = r7.rememberedValue();
        if (r39 == false) goto L210;
    L211:
        r40 = new pl(r26, r74, r110);
        r7.updateRememberedValue(r40);
    L212:
        Modifier r116 = SemanticsModifierKt.semantics$default(r35, false, (Function1) r40, 1, null);
        TextStyle r210 = ((TextStyle) r7.consume(TextKt.getLocalTextStyle())).merge(new TextStyle(r36, 0, null, null, null, null, null, 0, null, null, null, 0, null, null, null, 0, 0, 0, null, null, null, 0, 0, null, 16777214, null));
        SolidColor r41 = new SolidColor(r15.m3278cursorColorvNxB06k$material3(false), null);
        KeyboardOptions r211 = new KeyboardOptions(0, null, 0, ImeAction.Companion.getSearch-eUduSuo(), null, null, null, 119, null);
        if ((r1 & 896) != 256) goto L215;
        boolean r42 = true;
    L216:
        int r43 = r1 & 14;
        if (r43 != 4) goto L219;
        boolean r44 = true;
    L220:
        boolean r45 = r44 | r42;
        Object r46 = r7.rememberedValue();
        if (r45 == false) goto L223;
    L226:
        r46 = new ql(r73, r71);
        r7.updateRememberedValue(r46);
    L227:
        KeyboardActions r47 = new KeyboardActions(null, null, null, null, (Function1) r46, null, 47, null);
        int r212 = r1;
        final boolean r48 = r17;
        final MutableInteractionSource r49 = r21;
        final Function2<? super Composer, ? super Integer, Unit> r50 = r30;
        MutableInteractionSource r310 = r21;
        final Function2<? super Composer, ? super Integer, Unit> r51 = r31;
        final TextFieldColors r410 = r15;
        final Function2<? super Composer, ? super Integer, Unit> r52 = r32;
        ComposableLambda r213 = ComposableLambdaKt.rememberComposableLambda(-813926844, true, new AnonymousClass23(r71, r48, r49, r50, r51, r52, r410, r22), r7, 54);
        int r53 = (r43 | 102236160) | (r212 & 112);
        int r54 = r212 >> 9;
        int r214 = r53 | (r54 & 7168);
        boolean r55 = r17;
        Composer r56 = r7;
        BasicTextFieldKt.BasicTextField(r71, r72, r116, r55, false, r210, r211, r47, true, 0, 0, null, null, r310, r41, r213, r56, r214, 196608, 7696);
        if (r74 == true) goto L231;
        if (r22 == false) goto L231;
        boolean r117 = true;
    L232:
        Boolean r57 = Boolean.valueOf(r74);
        boolean r58 = r56.changed(r117) | r56.changedInstance(r25);
        Object r59 = r56.rememberedValue();
        if (r58 == false) goto L235;
    L236:
        r59 = new SearchBarDefaults$InputField$24$1(r117, r25, null);
        r56.updateRememberedValue(r59);
    L237:
        EffectsKt.LaunchedEffect(r57, (Function2) r59, r56, r54 & 14);
        if (ComposerKt.isTraceInProgress() == false) goto L240;
        ComposerKt.traceEventEnd();
    L240:
        final boolean r60 = r55;
        final Modifier r61 = r29;
        final Function2<? super Composer, ? super Integer, Unit> r62 = r30;
        final Function2<? super Composer, ? super Integer, Unit> r118 = r31;
        final Function2<? super Composer, ? super Integer, Unit> r119 = r32;
        final MutableInteractionSource r120 = r33;
        final TextFieldColors r121 = r410;
    L242:
        ScopeUpdateScope r122 = r56.endRestartGroup();
        if (r122 == null) goto L246;
        r122.updateScope(new rl(this, r71, r72, r73, r74, r75, r61, r60, r62, r118, r119, r121, r120, r84, r85, r86));
        return;
    L246:
        return;
    L235:
        if (r59 != r34.getEmpty()) goto L237;
    L231:
        r117 = false;
        goto L232
    L223:
        if (r46 != r34.getEmpty()) goto L227;
    L219:
        r44 = false;
        goto L220
    L215:
        r42 = false;
        goto L216
    L210:
        if (r40 != r34.getEmpty()) goto L212;
    L206:
        r38 = false;
        goto L207
    L201:
        if (r115 != r34.getEmpty()) goto L203;
    L197:
        r28 = false;
        goto L198
    L190:
        r112 = false;
        goto L191
    L183:
        r7.startReplaceGroup(1586079715);
        r7.endReplaceGroup();
        r21 = r33;
        goto L184
    L174:
        r33 = r82;
        r31 = r10;
        r32 = r11;
        r30 = r9;
        r29 = r8;
        r15 = r12;
        r17 = r14;
        goto L175
    L171:
        r12 = r81;
        goto L172
    L167:
        r11 = r80;
        goto L169
    L164:
        r10 = r79;
        goto L165
    L161:
        r9 = r78;
        goto L162
    L158:
        r14 = r77;
        goto L159
    L155:
        r8 = r76;
        goto L156
    L147:
        if (r7.getDefaultsInvalid() == true) goto L153;
        r7.skipToGroupEnd();
        if ((r86 & 1024) == 0) goto L152;
        r4 = r4 & (-15);
    L152:
        r29 = r76;
        r17 = r77;
        r30 = r78;
        r31 = r79;
        r32 = r80;
        r15 = r81;
        r33 = r82;
        goto L175
    L241:
        r56 = r7;
        r56.skipToGroupEnd();
        r61 = r76;
        r60 = r77;
        r62 = r78;
        r118 = r79;
        r119 = r80;
        r121 = r81;
        r120 = r82;
        goto L242
    L138:
        if ((r4 & 147) != 146) goto L141;
        r6 = false;
        goto L143
    L129:
        if ((r85 & 384) != 0) goto L136;
        if (r7.changed(this) == false) goto L133;
        r16 = 256;
    L133:
        r4 = r4 | r16;
        goto L136
    L119:
        if ((r85 & 48) != 0) goto L125;
        if (r7.changed(r82) == false) goto L123;
        int r123 = 32;
    L124:
        r20 = r20 | r123;
        goto L125
    L123:
        r123 = 16;
        goto L124
    L107:
        if ((r86 & 1024) != 0) goto L112;
        if (r7.changed(r81) == false) goto L112;
        int r215 = 4;
    L113:
        r20 = r85 | r215;
    L112:
        r215 = 2;
        goto L113
    L98:
        if ((r84 & 805306368) != 0) goto L105;
        if (r7.changedInstance(r80) == false) goto L102;
        int r216 = 536870912;
    L103:
        r1 = r1 | r216;
        goto L105
    L102:
        r216 = 268435456;
        goto L103
    L88:
        if ((r84 & 100663296) != 0) goto L94;
        if (r7.changedInstance(r79) == false) goto L92;
        int r217 = 67108864;
    L93:
        r1 = r1 | r217;
        goto L94
    L92:
        r217 = 33554432;
        goto L93
    L78:
        if ((r84 & 12582912) != 0) goto L84;
        if (r7.changedInstance(r78) == false) goto L82;
        int r218 = 8388608;
    L83:
        r1 = r1 | r218;
        goto L84
    L82:
        r218 = 4194304;
        goto L83
    L68:
        if ((r84 & 1572864) != 0) goto L74;
        if (r7.changed(r77) == false) goto L72;
        int r219 = 1048576;
    L73:
        r1 = r1 | r219;
        goto L74
    L72:
        r219 = 524288;
        goto L73
    L58:
        if ((r84 & 196608) != 0) goto L64;
        if (r7.changed(r76) == false) goto L62;
        int r124 = 131072;
    L63:
        r1 = r1 | r124;
        goto L64
    L62:
        r124 = 65536;
        goto L63
    L48:
        if ((r84 & 24576) != 0) goto L54;
        if (r7.changedInstance(r75) == false) goto L52;
        int r125 = 16384;
    L53:
        r1 = r1 | r125;
        goto L54
    L52:
        r125 = 8192;
        goto L53
    L38:
        if ((r84 & 3072) != 0) goto L45;
        if (r7.changed(r74) == false) goto L42;
        int r126 = 2048;
    L43:
        r1 = r1 | r126;
        goto L45
    L42:
        r126 = 1024;
        goto L43
    L28:
        if ((r84 & 384) != 0) goto L35;
        if (r7.changedInstance(r73) == false) goto L32;
        int r127 = 256;
    L33:
        r1 = r1 | r127;
        goto L35
    L32:
        r127 = 128;
        goto L33
    L17:
        if ((r84 & 48) != 0) goto L24;
        if (r7.changedInstance(r72) == false) goto L21;
        int r128 = 32;
    L22:
        r1 = r1 | r128;
        goto L24
    L21:
        r128 = 16;
        goto L22
    L6:
        if ((r84 & 6) == 0) goto L8;
        r1 = r84;
        goto L14
    L8:
        if (r7.changed(r71) == false) goto L10;
        int r63 = 4;
    L11:
        r1 = r63 | r84;
        goto L14
    L10:
        r63 = 2;
        goto L11
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* JADX INFO: renamed from: inputFieldColors--u-KgnY, reason: not valid java name */
    public final /* synthetic */ TextFieldColors m3047inputFieldColorsuKgnY(long r52, long r54, long r56, TextSelectionColors r58, long r59, long r61, long r63, long r65, long r67, long r69, long r71, long r73, Composer r75, int r76, int r77, int r78) {
        if ((r78 & 1) == 0) goto L5;
        long r5 = ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getInputTextColor(), r75, 6);
    L7:
        if ((r78 & 2) == 0) goto L9;
        FilledTextFieldTokens r3 = FilledTextFieldTokens.INSTANCE;
        long r7 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(r3.getDisabledInputColor(), r75, 6), r3.getDisabledInputOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
    L11:
        if ((r78 & 4) == 0) goto L13;
        long r9 = ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getCaretColor(), r75, 6);
    L15:
        if ((r78 & 8) == 0) goto L17;
        TextSelectionColors r11 = (TextSelectionColors) r75.consume(TextSelectionColorsKt.getLocalTextSelectionColors());
    L19:
        if ((r78 & 16) == 0) goto L21;
        long r12 = ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getLeadingIconColor(), r75, 6);
    L23:
        if ((r78 & 32) == 0) goto L25;
        long r15 = ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getLeadingIconColor(), r75, 6);
    L27:
        if ((r78 & 64) == 0) goto L29;
        FilledTextFieldTokens r4 = FilledTextFieldTokens.INSTANCE;
        long r16 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(r4.getDisabledLeadingIconColor(), r75, 6), r4.getDisabledLeadingIconOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
    L31:
        if ((r78 & 128) == 0) goto L33;
        long r17 = ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getTrailingIconColor(), r75, 6);
    L35:
        if ((r78 & 256) == 0) goto L37;
        long r19 = ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getTrailingIconColor(), r75, 6);
    L39:
        if ((r78 & 512) == 0) goto L41;
        FilledTextFieldTokens r6 = FilledTextFieldTokens.INSTANCE;
        long r21 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(r6.getDisabledTrailingIconColor(), r75, 6), r6.getDisabledTrailingIconOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
    L43:
        if ((r78 & 1024) == 0) goto L45;
        long r24 = ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getSupportingTextColor(), r75, 6);
    L47:
        if ((r78 & 2048) == 0) goto L49;
        FilledTextFieldTokens r2 = FilledTextFieldTokens.INSTANCE;
        long r26 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(r2.getDisabledInputColor(), r75, 6), r2.getDisabledInputOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
    L51:
        if (ComposerKt.isTraceInProgress() == false) goto L53;
        ComposerKt.traceEventStart(1842555178, r76, r77, "androidx.compose.material3.SearchBarDefaults.inputFieldColors (SearchBar.kt:1854)");
    L53:
        int r8 = r76 << 3;
        int r47 = (((((((((r76 & 14) | (r8 & 112)) | (r8 & 896)) | (r8 & 7168)) | (57344 & r8)) | (458752 & r8)) | (3670016 & r8)) | (29360128 & r8)) | (234881024 & r8)) | (r8 & 1879048192);
        int r10 = r77 << 3;
        int r1 = r77 << 6;
        long r13 = r5;
        long r14 = r5;
        long r18 = r7;
        long r20 = r9;
        TextSelectionColors r22 = r11;
        long r110 = r12;
        long r111 = r15;
        long r112 = r16;
        long r113 = r17;
        long r114 = r19;
        long r23 = r21;
        long r25 = r24;
        TextFieldColors r0 = m3049inputFieldColorsJVEmHcM(r13, r14, r18, r20, r22, r110, r111, r112, r113, r114, r23, r25, r24, r26, 0, 0, 0, 0, 0, 0, 0, 0, 0, r75, r47, ((((r76 >> 27) & 14) | (r10 & 112)) | (r1 & 896)) | (r1 & 7168), r10 & 7168, 8372224);
        if (ComposerKt.isTraceInProgress() == false) goto L56;
        ComposerKt.traceEventEnd();
    L56:
        return r0;
    L49:
        r26 = r73;
        goto L51
    L45:
        r24 = r71;
        goto L47
    L41:
        r21 = r69;
        goto L43
    L37:
        r19 = r67;
        goto L39
    L33:
        r17 = r65;
        goto L35
    L29:
        r16 = r63;
        goto L31
    L25:
        r15 = r61;
        goto L27
    L21:
        r12 = r59;
        goto L23
    L17:
        r11 = r58;
        goto L19
    L13:
        r9 = r56;
        goto L15
    L9:
        r7 = r54;
        goto L11
    L5:
        r5 = r52;
        goto L7
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility")
    /* JADX INFO: renamed from: inputFieldColors-ITpI4ow, reason: not valid java name */
    public final /* synthetic */ TextFieldColors m3048inputFieldColorsITpI4ow(long r56, long r58, long r60, long r62, TextSelectionColors r64, long r65, long r67, long r69, long r71, long r73, long r75, long r77, long r79, long r81, Composer r83, int r84, int r85, int r86) {
        if ((r86 & 1) == 0) goto L5;
        long r5 = ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getInputTextColor(), r83, 6);
    L7:
        if ((r86 & 2) == 0) goto L9;
        long r7 = ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getInputTextColor(), r83, 6);
    L11:
        if ((r86 & 4) == 0) goto L13;
        FilledTextFieldTokens r3 = FilledTextFieldTokens.INSTANCE;
        long r9 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(r3.getDisabledInputColor(), r83, 6), r3.getDisabledInputOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
    L15:
        if ((r86 & 8) == 0) goto L17;
        long r11 = ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getCaretColor(), r83, 6);
    L19:
        if ((r86 & 16) == 0) goto L21;
        TextSelectionColors r13 = (TextSelectionColors) r83.consume(TextSelectionColorsKt.getLocalTextSelectionColors());
    L23:
        if ((r86 & 32) == 0) goto L25;
        long r15 = ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getLeadingIconColor(), r83, 6);
    L27:
        if ((r86 & 64) == 0) goto L29;
        long r17 = ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getLeadingIconColor(), r83, 6);
    L31:
        if ((r86 & 128) == 0) goto L33;
        FilledTextFieldTokens r4 = FilledTextFieldTokens.INSTANCE;
        long r16 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(r4.getDisabledLeadingIconColor(), r83, 6), r4.getDisabledLeadingIconOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
    L35:
        if ((r86 & 256) == 0) goto L37;
        long r19 = ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getTrailingIconColor(), r83, 6);
    L39:
        if ((r86 & 512) == 0) goto L41;
        long r21 = ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getTrailingIconColor(), r83, 6);
    L43:
        if ((r86 & 1024) == 0) goto L45;
        FilledTextFieldTokens r6 = FilledTextFieldTokens.INSTANCE;
        long r23 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(r6.getDisabledTrailingIconColor(), r83, 6), r6.getDisabledTrailingIconOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
    L47:
        if ((r86 & 2048) == 0) goto L49;
        long r25 = ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getSupportingTextColor(), r83, 6);
    L51:
        if ((r86 & 4096) == 0) goto L53;
        long r51 = ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getSupportingTextColor(), r83, 6);
    L55:
        if ((r86 & 8192) == 0) goto L57;
        FilledTextFieldTokens r2 = FilledTextFieldTokens.INSTANCE;
        long r53 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(r2.getDisabledInputColor(), r83, 6), r2.getDisabledInputOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
    L59:
        if (ComposerKt.isTraceInProgress() == false) goto L61;
        ComposerKt.traceEventStart(-2048506052, r84, r85, "androidx.compose.material3.SearchBarDefaults.inputFieldColors (SearchBar.kt:1794)");
    L61:
        FilledTextFieldTokens r8 = FilledTextFieldTokens.INSTANCE;
        long r28 = ColorSchemeKt.getValue(r8.getInputPrefixColor(), r83, 6);
        long r30 = ColorSchemeKt.getValue(r8.getInputPrefixColor(), r83, 6);
        long r32 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(r8.getInputPrefixColor(), r83, 6), r8.getDisabledInputOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
        long r34 = ColorSchemeKt.getValue(r8.getInputSuffixColor(), r83, 6);
        long r36 = ColorSchemeKt.getValue(r8.getInputSuffixColor(), r83, 6);
        long r38 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(r8.getInputSuffixColor(), r83, 6), r8.getDisabledInputOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
        SearchBarTokens r10 = SearchBarTokens.INSTANCE;
        long r1 = r5;
        long r12 = r7;
        long r14 = r9;
        long r18 = r11;
        TextSelectionColors r20 = r13;
        long r110 = r15;
        long r111 = r17;
        long r112 = r16;
        long r113 = r19;
        long r114 = r21;
        long r22 = r23;
        long r24 = r25;
        long r26 = r51;
        long r27 = r53;
        TextFieldColors r0 = m3049inputFieldColorsJVEmHcM(r1, r12, r14, r18, r20, r110, r111, r112, r113, r114, r22, r24, r26, r27, r28, r30, r32, r34, r36, r38, ColorSchemeKt.getValue(r10.getContainerColor(), r83, 6), ColorSchemeKt.getValue(r10.getContainerColor(), r83, 6), ColorSchemeKt.getValue(r10.getContainerColor(), r83, 6), r83, (((((((((r84 & 14) | (r84 & 112)) | (r84 & 896)) | (r84 & 7168)) | (57344 & r84)) | (458752 & r84)) | (3670016 & r84)) | (29360128 & r84)) | (234881024 & r84)) | (r84 & 1879048192), (((r85 & 14) | (r85 & 112)) | (r85 & 896)) | (r85 & 7168), (r85 >> 3) & 7168, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L64;
        ComposerKt.traceEventEnd();
    L64:
        return r0;
    L57:
        r53 = r81;
        goto L59
    L53:
        r51 = r79;
        goto L55
    L49:
        r25 = r77;
        goto L51
    L45:
        r23 = r75;
        goto L47
    L41:
        r21 = r73;
        goto L43
    L37:
        r19 = r71;
        goto L39
    L33:
        r16 = r69;
        goto L35
    L29:
        r17 = r67;
        goto L31
    L25:
        r15 = r65;
        goto L27
    L21:
        r13 = r64;
        goto L23
    L17:
        r11 = r62;
        goto L19
    L13:
        r9 = r60;
        goto L15
    L9:
        r7 = r58;
        goto L11
    L5:
        r5 = r56;
        goto L7
    }

    public final void InputField(final TextFieldState r109, final SearchBarState r110, final Function1<? super String, Unit> r111, Modifier r112, boolean r113, boolean r114, TextStyle r115, Function2<? super Composer, ? super Integer, Unit> r116, Function2<? super Composer, ? super Integer, Unit> r117, Function2<? super Composer, ? super Integer, Unit> r118, Function2<? super Composer, ? super Integer, Unit> r119, Function2<? super Composer, ? super Integer, Unit> r120, InputTransformation r121, OutputTransformation r122, ScrollState r123, Shape r124, TextFieldColors r125, MutableInteractionSource r126, Composer r127, final int r128, final int r129, final int r130) {
        Composer r9 = r127.startRestartGroup(759286022);
        if ((r130 & 1) == 0) goto L6;
        int r1 = r128 | 6;
    L14:
        if ((r130 & 2) == 0) goto L17;
        r1 = r1 | 48;
    L24:
        if ((r130 & 4) == 0) goto L27;
        r1 = r1 | 384;
    L33:
        int r3 = r130 & 8;
        int r16 = 1024;
        if (r3 == 0) goto L37;
        r1 = r1 | 3072;
    L44:
        int r17 = r130 & 16;
        int r18 = 16384;
        if (r17 == 0) goto L48;
        r1 = r1 | 24576;
    L55:
        int r20 = r130 & 32;
        if (r20 == 0) goto L59;
        r1 = r1 | 196608;
    L66:
        if ((r128 & 1572864) != 0) goto L75;
        if ((r130 & 64) == 0) goto L70;
    L72:
        int r24 = 524288;
    L73:
        r1 = r1 | r24;
        goto L75
    L70:
        if (r9.changed(r115) == false) goto L72;
        r24 = 1048576;
    L75:
        int r7 = r130 & 128;
        if (r7 == 0) goto L79;
        r1 = r1 | 12582912;
    L85:
        int r2 = r130 & 256;
        if (r2 == 0) goto L89;
        r1 = r1 | 100663296;
    L95:
        int r4 = r130 & 512;
        if (r4 == 0) goto L99;
        r1 = r1 | 805306368;
    L105:
        int r5 = r130 & 1024;
        if (r5 == 0) goto L109;
        int r28 = r129 | 6;
    L116:
        int r6 = r130 & 2048;
        if (r6 == 0) goto L120;
        r28 = r28 | 48;
    L126:
        int r8 = r28;
        int r12 = r130 & 4096;
        if (r12 == 0) goto L130;
        r8 = r8 | 384;
    L137:
        int r14 = r130 & 8192;
        if (r14 == 0) goto L141;
        r8 = r8 | 3072;
    L148:
        if ((r129 & 24576) != 0) goto L159;
        if ((r130 & 16384) != 0) goto L155;
        if (r9.changed(r123) == false) goto L155;
    L156:
        r8 = r8 | r18;
    L155:
        r18 = 8192;
    L159:
        if ((r129 & 196608) != 0) goto L169;
        if ((r130 & BiometricManager$Authenticators.DEVICE_CREDENTIAL) == 0) goto L163;
    L165:
        int r19 = 65536;
    L166:
        r8 = r8 | r19;
        goto L169
    L163:
        if (r9.changed(r124) == false) goto L165;
        r19 = 131072;
    L169:
        if ((r129 & 1572864) != 0) goto L178;
        if ((r130 & 65536) == 0) goto L173;
    L175:
        int r131 = 524288;
    L176:
        r8 = r8 | r131;
        goto L178
    L173:
        if (r9.changed(r125) == false) goto L175;
        r131 = 1048576;
    L178:
        int r51 = r130 & 131072;
        if (r51 == 0) goto L182;
        r8 = r8 | 12582912;
    L189:
        if ((r130 & 262144) == 0) goto L192;
        r8 = r8 | 100663296;
    L199:
        if ((r1 & 306783379) == 306783378) goto L201;
    L204:
        boolean r10 = true;
    L206:
        if (r9.shouldExecute(r10, r1 & 1) == false) goto L384;
        r9.startDefaults();
        if ((r128 & 1) != 0) goto L210;
    L225:
        if (r3 == 0) goto L227;
        Modifier r53 = Modifier.Companion;
    L228:
        if (r17 == 0) goto L230;
        boolean r54 = true;
    L231:
        if (r20 == 0) goto L233;
        boolean r55 = false;
    L235:
        if ((r130 & 64) == 0) goto L237;
        int r57 = r1 & (-3670017);
        TextStyle r56 = (TextStyle) r9.consume(TextKt.getLocalTextStyle());
    L238:
        if (r7 == 0) goto L240;
        Function2<? super Composer, ? super Integer, Unit> r58 = null;
    L241:
        if (r2 == 0) goto L243;
        Function2<? super Composer, ? super Integer, Unit> r59 = null;
    L244:
        if (r4 == 0) goto L246;
        Function2<? super Composer, ? super Integer, Unit> r60 = null;
    L247:
        if (r5 == 0) goto L249;
        Function2<? super Composer, ? super Integer, Unit> r61 = null;
    L250:
        if (r6 == 0) goto L252;
        Function2<? super Composer, ? super Integer, Unit> r62 = null;
    L253:
        if (r12 == 0) goto L255;
        InputTransformation r63 = null;
    L256:
        if (r14 == 0) goto L258;
        OutputTransformation r64 = null;
    L260:
        if ((r130 & 16384) == 0) goto L262;
        r8 = r8 & (-57345);
        ScrollState r65 = ScrollKt.rememberScrollState(0, r9, 0, 1);
    L264:
        if ((32768 & r130) == 0) goto L266;
        Shape r11 = getInputFieldShape(r9, (r8 >> 24) & 14);
        r8 = r8 & (-458753);
        Shape r66 = r11;
    L267:
        int r67 = r8;
        if ((r130 & 65536) == 0) goto L270;
        Composer r1210 = r9;
        TextFieldColors r0 = m3049inputFieldColorsJVEmHcM(0, 0, 0, 0, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, r1210, 0, 0, (r67 >> 15) & 7168, 8388607);
        int r13 = r67 & (-3670017);
    L271:
        if (r51 == 0) goto L273;
        final TextFieldColors r15 = r0;
        int r21 = r13;
        Modifier r132 = r53;
        final boolean r133 = r54;
        TextStyle r134 = r56;
        int r22 = r57;
        final Function2<? super Composer, ? super Integer, Unit> r135 = r59;
        final Function2<? super Composer, ? super Integer, Unit> r23 = r60;
        final Shape r25 = r66;
        MutableInteractionSource r26 = null;
    L274:
        r1210.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L277;
        ComposerKt.traceEventStart(759286022, r22, r21, "androidx.compose.material3.SearchBarDefaults.InputField (SearchBar.kt:1310)");
    L277:
        if (r26 != null) goto L282;
        Composer r27 = r1210;
        r27.startReplaceGroup(-1701839691);
        Object r29 = r27.rememberedValue();
        if (r29 != Composer.Companion.getEmpty()) goto L281;
        r29 = InteractionSourceKt.MutableInteractionSource();
        r27.updateRememberedValue(r29);
    L281:
        r27.endReplaceGroup();
        MutableInteractionSource r30 = (MutableInteractionSource) r29;
    L283:
        final State<Boolean> r31 = FocusInteractionKt.collectIsFocusedAsState(r30, r27, 0);
        final FocusManager r32 = (FocusManager) r27.consume(CompositionLocalsKt.getLocalFocusManager());
        final boolean r136 = InputMode.equals-impl0(((InputModeManager) r27.consume(CompositionLocalsKt.getLocalInputModeManager())).getInputMode-aOaMEAU(), InputMode.Companion.getTouch-aOaMEAU());
        final String r137 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(2131911755), r27, 0);
        MutableInteractionSource r138 = r30;
        final String r33 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(2131911758), r27, 0);
        long r139 = r134.getColor-0d7_KjU();
        if (r139 == 16) goto L286;
        boolean r140 = true;
    L287:
        if (r140 == true) goto L290;
        r139 = r15.m3328textColorXeAY9LY$material3(r133, false, InputField$lambda$5(r31));
    L290:
        TextStyle r210 = r134.merge(new TextStyle(r139, 0, null, null, null, null, null, 0, null, null, null, 0, null, null, null, 0, 0, 0, null, null, null, 0, 0, null, 16777214, null));
        Object r34 = r27.rememberedValue();
        Composer.Companion r211 = Composer.Companion;
        if (r34 != r211.getEmpty()) goto L293;
        r34 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, r27);
        r27.updateRememberedValue(r34);
    L293:
        final CoroutineScope r35 = (CoroutineScope) r34;
        boolean r36 = r27.changed(r136);
        TextStyle r1110 = r134;
        int r141 = r22 & 112;
        if (r141 != 32) goto L296;
        boolean r142 = true;
    L297:
        boolean r37 = ((r36 | r142) | r27.changedInstance(r35)) | r27.changedInstance(r32);
        Object r38 = r27.rememberedValue();
        if (r37 == false) goto L300;
    L303:
        final SearchBarState r39 = r110;
        r38 = new SearchBarDefaults$InputField$1$1(r136, r39, r35, r32);
        r27.updateRememberedValue(r38);
    L304:
        Modifier r40 = SizeKt.m1018sizeInqDBjuR0$default(KeyInputModifierKt.onPreviewKeyEvent(r132, (Function1) r38), SearchBarKt.getSearchBarMinWidth(), InputFieldHeight, SearchBarKt.access$getSearchBarMaxWidth$p(), MenuKt.ClosedAlphaTarget, 8, null);
        boolean r143 = r27.changed(r136) | r27.changedInstance(r35);
        if (r141 != 32) goto L307;
        boolean r41 = true;
    L308:
        boolean r42 = r143 | r41;
        Modifier r212 = r132;
        Object r144 = r27.rememberedValue();
        if (r42 == false) goto L311;
    L312:
        r144 = new el(r136, r35, r39);
        r27.updateRememberedValue(r144);
    L313:
        Modifier r43 = FocusChangedModifierKt.onFocusChanged(r40, (Function1) r144);
        boolean r44 = r27.changed(r137);
        if (r141 != 32) goto L316;
        boolean r145 = true;
    L317:
        boolean r45 = (r44 | r145) | r27.changed(r33);
        Object r146 = r27.rememberedValue();
        if (r45 == false) goto L320;
    L321:
        r146 = new fl(r137, r39, r33);
        r27.updateRememberedValue(r146);
    L322:
        Modifier r213 = SemanticsModifierKt.semantics$default(r43, false, (Function1) r146, 1, null);
        TextFieldLineLimits.SingleLine r214 = TextFieldLineLimits.SingleLine.INSTANCE;
        SolidColor r147 = new SolidColor(r15.m3278cursorColorvNxB06k$material3(false), null);
        KeyboardOptions r215 = new KeyboardOptions(0, null, 0, ImeAction.Companion.getSearch-eUduSuo(), null, null, null, 119, null);
        if ((r22 & 896) != 256) goto L325;
        boolean r46 = true;
    L326:
        int r148 = r22 & 14;
        if (r148 != 4) goto L329;
        boolean r149 = true;
    L330:
        boolean r47 = r46 | r149;
        Object r48 = r27.rememberedValue();
        if (r47 == false) goto L333;
    L336:
        r48 = new gl(r111, r109);
        r27.updateRememberedValue(r48);
    L337:
        KeyboardActionHandler r310 = (KeyboardActionHandler) r48;
        TextFieldDefaults r49 = TextFieldDefaults.INSTANCE;
        if (r135 != null) goto L340;
        r27.startReplaceGroup(-1698078028);
        r27.endReplaceGroup();
        Function2 r311 = null;
    L341:
        if (r23 != null) goto L343;
        r27.startReplaceGroup(-1697869615);
        r27.endReplaceGroup();
        Function2 r312 = null;
    L344:
        PaddingValues r150 = TextFieldDefaults.m3331contentPaddingWithoutLabela9UjIt4$default(r49, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 15, null);
        ComposableLambda r151 = ComposableLambdaKt.rememberComposableLambda(1500441906, true, new AnonymousClass7(r15, r133, r25, r31), r27, 54);
        int r50 = (r148 | 384) | ((r22 >> 9) & 112);
        int r152 = r21;
        Composer r1211 = r27;
        int r510 = r22;
        TextFieldColors r313 = r15;
        Shape r68 = r25;
        Function2<? super Composer, ? super Integer, Unit> r69 = r23;
        Function2<? super Composer, ? super Integer, Unit> r511 = r135;
        boolean r512 = r133;
        TextFieldDecorator r153 = r49.decorator(r109, r133, r214, r64, r138, null, null, r58, r311, r312, r61, r62, null, false, r313, r150, r151, r1211, (r50 | (r152 & 7168)) | (29360128 & r22), (((r152 & 14) | 14155776) | (r152 & 112)) | ((r152 >> 6) & 57344), 12384);
        int r52 = r510 >> 6;
        BasicTextFieldKt.BasicTextField(r109, r213, r512, r55, r63, r210, r215, r310, r214, null, r138, r147, r64, r153, r65, r1211, (((102236160 | r148) | (r52 & 896)) | (r52 & 7168)) | (57344 & (r152 << 6)), ((r152 >> 3) & 896) | (r152 & 57344), 512);
        Composer r70 = r1211;
        if (r141 != 32) goto L347;
        boolean r71 = true;
    L348:
        boolean r72 = r71 | r70.changedInstance(r35);
        Object r73 = r70.rememberedValue();
        if (r72 == false) goto L351;
    L354:
        final SearchBarState r74 = r110;
        r73 = new hl(r74, r35);
        r70.updateRememberedValue(r73);
    L355:
        SearchBarKt.access$DetectClickFromInteractionSource(r138, (Function0) r73, r70, 0);
        if (r141 != 32) goto L358;
        boolean r75 = true;
    L360:
        if (r148 != 4) goto L362;
        boolean r76 = true;
    L363:
        boolean r77 = ((r75 | r76) | r70.changed(r31)) | r70.changedInstance(r35);
        Object r78 = r70.rememberedValue();
        if (r77 == false) goto L366;
    L367:
        r78 = new SearchBarDefaults$InputField$9$1(r110, r109, r35, r31, null);
        r70.updateRememberedValue(r78);
    L368:
        EffectsKt.LaunchedEffect(r74, r109, (Function2) r78, r70, ((r510 >> 3) & 14) | ((r510 << 3) & 112));
        if (SearchBarKt.access$isExpanded(r110) == false) goto L371;
    L374:
        boolean r79 = false;
    L375:
        Boolean r80 = Boolean.valueOf(SearchBarKt.access$isExpanded(r110));
        boolean r81 = r70.changed(r79) | r70.changedInstance(r32);
        Object r82 = r70.rememberedValue();
        if (r81 == false) goto L378;
    L379:
        r82 = new SearchBarDefaults$InputField$10$1(r79, r32, null);
        r70.updateRememberedValue(r82);
    L380:
        EffectsKt.LaunchedEffect(r80, (Function2) r82, r70, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L383;
        ComposerKt.traceEventEnd();
    L383:
        final MutableInteractionSource r154 = r26;
        final TextFieldColors r155 = r313;
        final Modifier r83 = r212;
        final boolean r84 = r55;
        final TextStyle r85 = r1110;
        final Function2<? super Composer, ? super Integer, Unit> r86 = r58;
        final Function2<? super Composer, ? super Integer, Unit> r156 = r511;
        final Function2<? super Composer, ? super Integer, Unit> r157 = r69;
        final Function2<? super Composer, ? super Integer, Unit> r158 = r61;
        final Function2<? super Composer, ? super Integer, Unit> r159 = r62;
        final InputTransformation r160 = r63;
        final OutputTransformation r161 = r64;
        final ScrollState r162 = r65;
        final Shape r163 = r68;
    L385:
        ScopeUpdateScope r87 = r70.endRestartGroup();
        if (r87 == null) goto L389;
        final boolean r88 = r512;
        r87.updateScope(new il(this, r109, r110, r111, r83, r88, r84, r85, r86, r156, r157, r158, r159, r160, r161, r162, r163, r155, r154, r128, r129, r130));
        return;
    L389:
        return;
    L378:
        if (r82 != r211.getEmpty()) goto L380;
    L371:
        if (InputField$lambda$5(r31) == false) goto L374;
        if (r136 == false) goto L374;
        r79 = true;
        goto L375
    L366:
        if (r78 != r211.getEmpty()) goto L368;
    L362:
        r76 = false;
        goto L363
    L358:
        r75 = false;
        goto L360
    L351:
        if (r73 == r211.getEmpty()) goto L354;
        r74 = r110;
        goto L355
    L347:
        r71 = false;
        goto L348
    L343:
        r27.startReplaceGroup(-1697869614);
        Function2 r89 = ComposableLambdaKt.rememberComposableLambda(55642171, true, new SearchBarDefaults$InputField$6$1(r23), r27, 54);
        r27.endReplaceGroup();
        r312 = r89;
        goto L344
    L340:
        r27.startReplaceGroup(-1698078027);
        Function2 r90 = ComposableLambdaKt.rememberComposableLambda(759038428, true, new SearchBarDefaults$InputField$5$1(r135), r27, 54);
        r27.endReplaceGroup();
        r311 = r90;
        goto L341
    L333:
        if (r48 != r211.getEmpty()) goto L337;
    L329:
        r149 = false;
        goto L330
    L325:
        r46 = false;
        goto L326
    L320:
        if (r146 != r211.getEmpty()) goto L322;
    L316:
        r145 = false;
        goto L317
    L311:
        if (r144 != r211.getEmpty()) goto L313;
    L307:
        r41 = false;
        goto L308
    L300:
        if (r38 == r211.getEmpty()) goto L303;
        r39 = r110;
        goto L304
    L296:
        r142 = false;
        goto L297
    L286:
        r140 = false;
        goto L287
    L282:
        r27 = r1210;
        r27.startReplaceGroup(-470540702);
        r27.endReplaceGroup();
        r30 = r26;
        goto L283
    L273:
        r26 = r126;
        r15 = r0;
        r21 = r13;
        r132 = r53;
        r133 = r54;
        r134 = r56;
        r22 = r57;
        r135 = r59;
        r23 = r60;
        r25 = r66;
        goto L274
    L270:
        r1210 = r9;
        r0 = r125;
        r13 = r67;
        goto L271
    L266:
        r66 = r124;
        goto L267
    L262:
        r65 = r123;
        goto L264
    L258:
        r64 = r122;
        goto L260
    L255:
        r63 = r121;
        goto L256
    L252:
        r62 = r120;
        goto L253
    L249:
        r61 = r119;
        goto L250
    L246:
        r60 = r118;
        goto L247
    L243:
        r59 = r117;
        goto L244
    L240:
        r58 = r116;
        goto L241
    L237:
        r56 = r115;
        r57 = r1;
        goto L238
    L233:
        r55 = r114;
        goto L235
    L230:
        r54 = r113;
        goto L231
    L227:
        r53 = r112;
        goto L228
    L210:
        if (r9.getDefaultsInvalid() == true) goto L225;
        r9.skipToGroupEnd();
        if ((r130 & 64) == 0) goto L216;
        r1 = r1 & (-3670017);
    L216:
        if ((r130 & 16384) == 0) goto L219;
        r8 = r8 & (-57345);
    L219:
        if ((32768 & r130) == 0) goto L222;
        r8 = r8 & (-458753);
    L222:
        if ((r130 & 65536) == 0) goto L224;
        r8 = r8 & (-3670017);
    L224:
        r132 = r112;
        r133 = r113;
        r55 = r114;
        r134 = r115;
        r58 = r116;
        r135 = r117;
        r61 = r119;
        r62 = r120;
        r63 = r121;
        r64 = r122;
        r65 = r123;
        r15 = r125;
        r26 = r126;
        r22 = r1;
        r21 = r8;
        r1210 = r9;
        r23 = r118;
        r25 = r124;
        goto L274
    L384:
        r70 = r9;
        r70.skipToGroupEnd();
        r83 = r112;
        r512 = r113;
        r84 = r114;
        r85 = r115;
        r86 = r116;
        r156 = r117;
        r157 = r118;
        r158 = r119;
        r159 = r120;
        r160 = r121;
        r161 = r122;
        r162 = r123;
        r163 = r124;
        r155 = r125;
        r154 = r126;
        goto L385
    L201:
        if ((38347923 & r8) != 38347922) goto L204;
        r10 = false;
        goto L206
    L192:
        if ((r129 & 100663296) != 0) goto L199;
        if (r9.changed(this) == false) goto L196;
        int r164 = 67108864;
    L197:
        r8 = r8 | r164;
        goto L199
    L196:
        r164 = 33554432;
        goto L197
    L182:
        if ((r129 & 12582912) != 0) goto L189;
        if (r9.changed(r126) == false) goto L186;
        int r165 = 8388608;
    L187:
        r8 = r8 | r165;
        goto L189
    L186:
        r165 = 4194304;
        goto L187
    L141:
        if ((r129 & 3072) != 0) goto L148;
        if (r9.changed(r122) == false) goto L145;
        r16 = 2048;
    L145:
        r8 = r8 | r16;
        goto L148
    L130:
        if ((r129 & 384) != 0) goto L137;
        if (r9.changed(r121) == false) goto L134;
        int r216 = 256;
    L135:
        r8 = r8 | r216;
        goto L137
    L134:
        r216 = 128;
        goto L135
    L120:
        if ((r129 & 48) != 0) goto L126;
        if (r9.changedInstance(r120) == false) goto L124;
        int r166 = 32;
    L125:
        r28 = r28 | r166;
        goto L126
    L124:
        r166 = 16;
        goto L125
    L109:
        if ((r129 & 6) == 0) goto L111;
        r28 = r129;
        goto L116
    L111:
        if (r9.changedInstance(r119) == false) goto L113;
        int r217 = 4;
    L114:
        r28 = r129 | r217;
        goto L116
    L113:
        r217 = 2;
        goto L114
    L99:
        if ((r128 & 805306368) != 0) goto L105;
        if (r9.changedInstance(r118) == false) goto L103;
        int r218 = 536870912;
    L104:
        r1 = r1 | r218;
        goto L105
    L103:
        r218 = 268435456;
        goto L104
    L89:
        if ((r128 & 100663296) != 0) goto L95;
        if (r9.changedInstance(r117) == false) goto L93;
        int r219 = 67108864;
    L94:
        r1 = r1 | r219;
        goto L95
    L93:
        r219 = 33554432;
        goto L94
    L79:
        if ((r128 & 12582912) != 0) goto L85;
        if (r9.changedInstance(r116) == false) goto L83;
        int r220 = 8388608;
    L84:
        r1 = r1 | r220;
        goto L85
    L83:
        r220 = 4194304;
        goto L84
    L59:
        if ((r128 & 196608) != 0) goto L66;
        if (r9.changed(r114) == false) goto L63;
        int r221 = 131072;
    L64:
        r1 = r1 | r221;
        goto L66
    L63:
        r221 = 65536;
        goto L64
    L48:
        if ((r128 & 24576) != 0) goto L55;
        if (r9.changed(r113) == false) goto L52;
        int r222 = 16384;
    L53:
        r1 = r1 | r222;
        goto L55
    L52:
        r222 = 8192;
        goto L53
    L37:
        if ((r128 & 3072) != 0) goto L44;
        if (r9.changed(r112) == false) goto L41;
        int r167 = 2048;
    L42:
        r1 = r1 | r167;
        goto L44
    L41:
        r167 = 1024;
        goto L42
    L27:
        if ((r128 & 384) != 0) goto L33;
        if (r9.changedInstance(r111) == false) goto L31;
        int r91 = 256;
    L32:
        r1 = r1 | r91;
        goto L33
    L31:
        r91 = 128;
        goto L32
    L17:
        if ((r128 & 48) != 0) goto L24;
        if (r9.changed(r110) == false) goto L21;
        int r92 = 32;
    L22:
        r1 = r1 | r92;
        goto L24
    L21:
        r92 = 16;
        goto L22
    L6:
        if ((r128 & 6) == 0) goto L8;
        r1 = r128;
        goto L14
    L8:
        if (r9.changed(r109) == false) goto L10;
        int r93 = 4;
    L11:
        r1 = r93 | r128;
        goto L14
    L10:
        r93 = 2;
        goto L11
    }

    public final void InputField(final TextFieldState r104, final Function1<? super String, Unit> r105, final boolean r106, final Function1<? super Boolean, Unit> r107, Modifier r108, boolean r109, boolean r110, TextStyle r111, Function2<? super Composer, ? super Integer, Unit> r112, Function2<? super Composer, ? super Integer, Unit> r113, Function2<? super Composer, ? super Integer, Unit> r114, Function2<? super Composer, ? super Integer, Unit> r115, Function2<? super Composer, ? super Integer, Unit> r116, InputTransformation r117, OutputTransformation r118, ScrollState r119, Shape r120, TextFieldColors r121, MutableInteractionSource r122, Composer r123, final int r124, final int r125, final int r126) {
        Composer r7 = r123.startRestartGroup(1994562483);
        if ((r126 & 1) == 0) goto L6;
        int r1 = r124 | 6;
    L14:
        if ((r126 & 2) == 0) goto L17;
        r1 = r1 | 48;
    L23:
        int r16 = 128;
        if ((r126 & 4) == 0) goto L27;
        r1 = r1 | 384;
    L34:
        if ((r126 & 8) == 0) goto L37;
        r1 = r1 | 3072;
    L43:
        int r3 = r126 & 16;
        if (r3 == 0) goto L47;
        r1 = r1 | 24576;
    L54:
        int r17 = r126 & 32;
        if (r17 == 0) goto L58;
        r1 = r1 | 196608;
    L64:
        int r21 = r126 & 64;
        if (r21 == 0) goto L68;
        r1 = r1 | 1572864;
    L75:
        if ((r124 & 12582912) != 0) goto L85;
        if ((r126 & 128) != 0) goto L82;
        if (r7.changed(r111) == false) goto L82;
        int r24 = 8388608;
    L83:
        r1 = r1 | r24;
    L82:
        r24 = 4194304;
    L85:
        int r8 = r126 & 256;
        if (r8 == 0) goto L89;
        r1 = r1 | 100663296;
    L95:
        int r2 = r126 & 512;
        if (r2 == 0) goto L99;
        r1 = r1 | 805306368;
    L105:
        int r4 = r126 & 1024;
        if (r4 == 0) goto L109;
        int r28 = r125 | 6;
    L116:
        int r5 = r126 & 2048;
        if (r5 == 0) goto L120;
        r28 = r28 | 48;
    L126:
        int r6 = r28;
        int r12 = r126 & 4096;
        if (r12 == 0) goto L130;
        r6 = r6 | 384;
    L136:
        int r13 = r126 & 8192;
        if (r13 == 0) goto L140;
        r6 = r6 | 3072;
    L147:
        int r14 = r126 & 16384;
        if (r14 == 0) goto L151;
        r6 = r6 | 24576;
    L159:
        if ((r125 & 196608) != 0) goto L169;
        if ((r126 & BiometricManager$Authenticators.DEVICE_CREDENTIAL) == 0) goto L163;
    L165:
        int r18 = 65536;
    L166:
        r6 = r6 | r18;
        goto L169
    L163:
        if (r7.changed(r119) == false) goto L165;
        r18 = 131072;
    L169:
        if ((r125 & 1572864) != 0) goto L179;
        if ((r126 & 65536) == 0) goto L173;
    L175:
        int r19 = 524288;
    L176:
        r6 = r6 | r19;
        goto L179
    L173:
        if (r7.changed(r120) == false) goto L175;
        r19 = 1048576;
    L179:
        if ((r125 & 12582912) != 0) goto L188;
        if ((r126 & 131072) == 0) goto L183;
    L185:
        int r127 = 4194304;
    L186:
        r6 = r6 | r127;
        goto L188
    L183:
        if (r7.changed(r121) == false) goto L185;
        r127 = 8388608;
    L188:
        int r51 = r126 & 262144;
        if (r51 == 0) goto L192;
        r6 = r6 | 100663296;
    L199:
        if ((r126 & 524288) == 0) goto L202;
        r6 = r6 | 805306368;
    L209:
        if ((r1 & 306783379) == 306783378) goto L211;
    L214:
        boolean r11 = true;
    L216:
        if (r7.shouldExecute(r11, r1 & 1) == false) goto L361;
        r7.startDefaults();
        if ((r124 & 1) != 0) goto L220;
    L235:
        if (r3 == 0) goto L237;
        Modifier r53 = Modifier.Companion;
    L238:
        if (r17 == 0) goto L240;
        boolean r54 = true;
    L241:
        if (r21 == 0) goto L243;
        boolean r55 = false;
    L245:
        if ((r126 & 128) == 0) goto L247;
        int r57 = r1 & (-29360129);
        TextStyle r56 = (TextStyle) r7.consume(TextKt.getLocalTextStyle());
    L248:
        if (r8 == 0) goto L250;
        Function2<? super Composer, ? super Integer, Unit> r58 = null;
    L251:
        if (r2 == 0) goto L253;
        Function2<? super Composer, ? super Integer, Unit> r59 = null;
    L254:
        if (r4 == 0) goto L256;
        Function2<? super Composer, ? super Integer, Unit> r60 = null;
    L257:
        if (r5 == 0) goto L259;
        Function2<? super Composer, ? super Integer, Unit> r61 = null;
    L260:
        if (r12 == 0) goto L262;
        Function2<? super Composer, ? super Integer, Unit> r62 = null;
    L263:
        if (r13 == 0) goto L265;
        InputTransformation r63 = null;
    L266:
        if (r14 == 0) goto L268;
        OutputTransformation r64 = null;
    L270:
        if ((32768 & r126) == 0) goto L272;
        r6 = r6 & (-458753);
        ScrollState r65 = ScrollKt.rememberScrollState(0, r7, 0, 1);
    L274:
        if ((r126 & 65536) == 0) goto L276;
        Shape r9 = getInputFieldShape(r7, (r6 >> 27) & 14);
        r6 = r6 & (-3670017);
        Shape r66 = r9;
    L277:
        int r67 = r6;
        if ((r126 & 131072) == 0) goto L280;
        Composer r128 = r7;
        TextFieldColors r0 = m3049inputFieldColorsJVEmHcM(0, 0, 0, 0, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, r128, 0, 0, (r67 >> 18) & 7168, 8388607);
        r6 = r67 & (-29360129);
    L281:
        if (r51 == 0) goto L283;
        final TextFieldColors r10 = r0;
        final boolean r15 = r54;
        TextStyle r129 = r56;
        int r20 = r57;
        final Function2<? super Composer, ? super Integer, Unit> r130 = r59;
        Function2<? super Composer, ? super Integer, Unit> r131 = r60;
        Shape r22 = r66;
        MutableInteractionSource r23 = null;
    L284:
        r128.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L287;
        ComposerKt.traceEventStart(1994562483, r20, r6, "androidx.compose.material3.SearchBarDefaults.InputField (SearchBar.kt:1520)");
    L287:
        if (r23 != null) goto L292;
        Composer r25 = r128;
        r25.startReplaceGroup(-860559352);
        Object r26 = r25.rememberedValue();
        if (r26 != Composer.Companion.getEmpty()) goto L291;
        r26 = InteractionSourceKt.MutableInteractionSource();
        r25.updateRememberedValue(r26);
    L291:
        r25.endReplaceGroup();
        MutableInteractionSource r27 = (MutableInteractionSource) r26;
    L293:
        final boolean r29 = ((Boolean) FocusInteractionKt.collectIsFocusedAsState(r27, r25, 0).getValue()).booleanValue();
        Object r30 = r25.rememberedValue();
        Composer.Companion r210 = Composer.Companion;
        if (r30 != r210.getEmpty()) goto L296;
        r30 = new FocusRequester();
        r25.updateRememberedValue(r30);
    L296:
        FocusRequester r31 = (FocusRequester) r30;
        FocusManager r32 = (FocusManager) r25.consume(CompositionLocalsKt.getLocalFocusManager());
        final String r132 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(2131911755), r25, 0);
        final String r133 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(2131911758), r25, 0);
        long r134 = r129.getColor-0d7_KjU();
        if (r134 == 16) goto L299;
        boolean r135 = true;
    L300:
        if (r135 == true) goto L303;
        r134 = r10.m3328textColorXeAY9LY$material3(r15, false, r29);
    L303:
        TextStyle r211 = r129.merge(new TextStyle(r134, 0, null, null, null, null, null, 0, null, null, null, 0, null, null, null, 0, 0, 0, null, null, null, 0, 0, null, 16777214, null));
        Modifier r1010 = r53;
        Modifier r33 = FocusRequesterModifierKt.focusRequester(SizeKt.m1018sizeInqDBjuR0$default(r1010, SearchBarKt.getSearchBarMinWidth(), InputFieldHeight, SearchBarKt.access$getSearchBarMaxWidth$p(), MenuKt.ClosedAlphaTarget, 8, null), r31);
        if ((r20 & 7168) != 2048) goto L306;
        boolean r34 = true;
    L307:
        Object r35 = r25.rememberedValue();
        if (r34 == false) goto L310;
    L313:
        r35 = new kl(r107);
        r25.updateRememberedValue(r35);
    L314:
        Modifier r36 = FocusChangedModifierKt.onFocusChanged(r33, (Function1) r35);
        boolean r37 = r25.changed(r132);
        MutableInteractionSource r136 = r27;
        if ((r20 & 896) != 256) goto L317;
        boolean r38 = true;
    L318:
        boolean r39 = (r38 | r37) | r25.changed(r133);
        Object r40 = r25.rememberedValue();
        if (r39 == false) goto L321;
    L324:
        r40 = new ll(r132, r106, r133);
        r25.updateRememberedValue(r40);
    L325:
        Modifier r212 = SemanticsModifierKt.semantics$default(r36, false, (Function1) r40, 1, null);
        TextFieldLineLimits.SingleLine r213 = TextFieldLineLimits.SingleLine.INSTANCE;
        final Shape r214 = r22;
        final Function2<? super Composer, ? super Integer, Unit> r1011 = r131;
        SolidColor r41 = new SolidColor(r10.m3278cursorColorvNxB06k$material3(false), null);
        KeyboardOptions r215 = new KeyboardOptions(0, null, 0, ImeAction.Companion.getSearch-eUduSuo(), null, null, null, 119, null);
        if ((r20 & 112) != 32) goto L328;
        boolean r42 = true;
    L329:
        int r137 = r20 & 14;
        if (r137 != 4) goto L332;
        boolean r43 = true;
    L333:
        boolean r44 = r42 | r43;
        Object r45 = r25.rememberedValue();
        if (r44 == false) goto L336;
    L339:
        r45 = new ml(r105, r104);
        r25.updateRememberedValue(r45);
    L340:
        KeyboardActionHandler r216 = (KeyboardActionHandler) r45;
        TextFieldDefaults r46 = TextFieldDefaults.INSTANCE;
        if (r130 != null) goto L343;
        r25.startReplaceGroup(-858226169);
        r25.endReplaceGroup();
        Function2 r310 = null;
    L344:
        if (r1011 != null) goto L346;
        r25.startReplaceGroup(-858017756);
        r25.endReplaceGroup();
        Function2 r311 = null;
    L347:
        PaddingValues r138 = TextFieldDefaults.m3331contentPaddingWithoutLabela9UjIt4$default(r46, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 15, null);
        ComposableLambda r139 = ComposableLambdaKt.rememberComposableLambda(-1551441816, true, new AnonymousClass17(r10, r15, r29, r214), r25, 54);
        int r47 = (r137 | 384) | ((r20 >> 12) & 112);
        int r140 = r6 >> 3;
        Composer r1210 = r25;
        int r312 = r6;
        int r510 = r20;
        TextFieldColors r313 = r10;
        Function2<? super Composer, ? super Integer, Unit> r511 = r130;
        TextStyle r512 = r129;
        boolean r513 = r15;
        int r48 = r510 >> 9;
        boolean r49 = r55;
        InputTransformation r50 = r63;
        OutputTransformation r141 = r64;
        ScrollState r142 = r65;
        BasicTextFieldKt.BasicTextField(r104, r212, r513, r49, r50, r211, r215, r216, r213, null, r136, r41, r141, r46.decorator(r104, r15, r213, r64, r136, null, null, r58, r310, r311, r61, r62, null, false, r313, r138, r139, r1210, (r47 | (r140 & 7168)) | ((r20 >> 3) & 29360128), (((r140 & 14) | 14155776) | (r140 & 112)) | ((r6 >> 9) & 57344), 12384), r142, r1210, (((r137 | 102236160) | (r48 & 896)) | (r48 & 7168)) | ((r312 << 3) & 57344), ((r312 >> 6) & 896) | (r140 & 57344), 512);
        if (r106 == true) goto L351;
        if (r29 == false) goto L351;
        boolean r52 = true;
    L352:
        Boolean r68 = Boolean.valueOf(r106);
        Composer r69 = r1210;
        boolean r70 = r69.changed(r52) | r69.changedInstance(r32);
        Object r71 = r69.rememberedValue();
        if (r70 == false) goto L355;
    L356:
        r71 = new SearchBarDefaults$InputField$18$1(r52, r32, null);
        r69.updateRememberedValue(r71);
    L357:
        EffectsKt.LaunchedEffect(r68, (Function2) r71, r69, (r510 >> 6) & 14);
        if (ComposerKt.isTraceInProgress() == false) goto L360;
        ComposerKt.traceEventEnd();
    L360:
        final MutableInteractionSource r217 = r23;
        final TextFieldColors r143 = r313;
        final Modifier r72 = r53;
        final boolean r73 = r513;
        final boolean r74 = r55;
        final TextStyle r75 = r512;
        final Function2<? super Composer, ? super Integer, Unit> r144 = r58;
        final Function2<? super Composer, ? super Integer, Unit> r145 = r511;
        final Function2<? super Composer, ? super Integer, Unit> r146 = r1011;
        final Function2<? super Composer, ? super Integer, Unit> r147 = r61;
        final Function2<? super Composer, ? super Integer, Unit> r148 = r62;
        final InputTransformation r149 = r63;
        final OutputTransformation r150 = r64;
        final ScrollState r151 = r65;
        final Shape r152 = r214;
    L362:
        ScopeUpdateScope r76 = r69.endRestartGroup();
        if (r76 == null) goto L366;
        r76.updateScope(new nl(this, r104, r105, r106, r107, r72, r73, r74, r75, r144, r145, r146, r147, r148, r149, r150, r151, r152, r143, r217, r124, r125, r126));
        return;
    L366:
        return;
    L355:
        if (r71 != r210.getEmpty()) goto L357;
    L351:
        r52 = false;
        goto L352
    L346:
        r25.startReplaceGroup(-858017755);
        Function2 r77 = ComposableLambdaKt.rememberComposableLambda(581893311, true, new SearchBarDefaults$InputField$16$1(r1011), r25, 54);
        r25.endReplaceGroup();
        r311 = r77;
        goto L347
    L343:
        r25.startReplaceGroup(-858226168);
        Function2 r78 = ComposableLambdaKt.rememberComposableLambda(314348414, true, new SearchBarDefaults$InputField$15$1(r130), r25, 54);
        r25.endReplaceGroup();
        r310 = r78;
        goto L344
    L336:
        if (r45 != r210.getEmpty()) goto L340;
    L332:
        r43 = false;
        goto L333
    L328:
        r42 = false;
        goto L329
    L321:
        if (r40 != r210.getEmpty()) goto L325;
    L317:
        r38 = false;
        goto L318
    L310:
        if (r35 != r210.getEmpty()) goto L314;
    L306:
        r34 = false;
        goto L307
    L299:
        r135 = false;
        goto L300
    L292:
        r25 = r128;
        r25.startReplaceGroup(1219165359);
        r25.endReplaceGroup();
        r27 = r23;
        goto L293
    L283:
        r23 = r122;
        r10 = r0;
        r15 = r54;
        r129 = r56;
        r20 = r57;
        r130 = r59;
        r131 = r60;
        r22 = r66;
        goto L284
    L280:
        r128 = r7;
        r0 = r121;
        r6 = r67;
        goto L281
    L276:
        r66 = r120;
        goto L277
    L272:
        r65 = r119;
        goto L274
    L268:
        r64 = r118;
        goto L270
    L265:
        r63 = r117;
        goto L266
    L262:
        r62 = r116;
        goto L263
    L259:
        r61 = r115;
        goto L260
    L256:
        r60 = r114;
        goto L257
    L253:
        r59 = r113;
        goto L254
    L250:
        r58 = r112;
        goto L251
    L247:
        r56 = r111;
        r57 = r1;
        goto L248
    L243:
        r55 = r110;
        goto L245
    L240:
        r54 = r109;
        goto L241
    L237:
        r53 = r108;
        goto L238
    L220:
        if (r7.getDefaultsInvalid() == true) goto L235;
        r7.skipToGroupEnd();
        if ((r126 & 128) == 0) goto L226;
        r1 = r1 & (-29360129);
    L226:
        if ((32768 & r126) == 0) goto L229;
        r6 = r6 & (-458753);
    L229:
        if ((r126 & 65536) == 0) goto L232;
        r6 = r6 & (-3670017);
    L232:
        if ((r126 & 131072) == 0) goto L234;
        r6 = r6 & (-29360129);
    L234:
        r53 = r108;
        r15 = r109;
        r55 = r110;
        r129 = r111;
        r58 = r112;
        r130 = r113;
        r131 = r114;
        r61 = r115;
        r62 = r116;
        r63 = r117;
        r64 = r118;
        r65 = r119;
        r22 = r120;
        r10 = r121;
        r23 = r122;
        r128 = r7;
        r20 = r1;
        goto L284
    L361:
        r69 = r7;
        r69.skipToGroupEnd();
        r72 = r108;
        r73 = r109;
        r74 = r110;
        r75 = r111;
        r144 = r112;
        r145 = r113;
        r146 = r114;
        r147 = r115;
        r148 = r116;
        r149 = r117;
        r150 = r118;
        r151 = r119;
        r152 = r120;
        r143 = r121;
        r217 = r122;
        goto L362
    L211:
        if ((306783379 & r6) != 306783378) goto L214;
        r11 = false;
        goto L216
    L202:
        if ((r125 & 805306368) != 0) goto L209;
        if (r7.changed(this) == false) goto L206;
        int r153 = 536870912;
    L207:
        r6 = r6 | r153;
        goto L209
    L206:
        r153 = 268435456;
        goto L207
    L192:
        if ((r125 & 100663296) != 0) goto L199;
        if (r7.changed(r122) == false) goto L196;
        int r154 = 67108864;
    L197:
        r6 = r6 | r154;
        goto L199
    L196:
        r154 = 33554432;
        goto L197
    L151:
        if ((r125 & 24576) != 0) goto L159;
        if (r7.changed(r118) == false) goto L155;
        int r155 = 16384;
    L156:
        r6 = r6 | r155;
        goto L159
    L155:
        r155 = 8192;
        goto L156
    L140:
        if ((r125 & 3072) != 0) goto L147;
        if (r7.changed(r117) == false) goto L144;
        int r156 = 2048;
    L145:
        r6 = r6 | r156;
        goto L147
    L144:
        r156 = 1024;
        goto L145
    L130:
        if ((r125 & 384) != 0) goto L136;
        if (r7.changedInstance(r116) == false) goto L134;
        r16 = 256;
    L134:
        r6 = r6 | r16;
        goto L136
    L120:
        if ((r125 & 48) != 0) goto L126;
        if (r7.changedInstance(r115) == false) goto L124;
        int r218 = 32;
    L125:
        r28 = r28 | r218;
        goto L126
    L124:
        r218 = 16;
        goto L125
    L109:
        if ((r125 & 6) == 0) goto L111;
        r28 = r125;
        goto L116
    L111:
        if (r7.changedInstance(r114) == false) goto L113;
        int r219 = 4;
    L114:
        r28 = r125 | r219;
        goto L116
    L113:
        r219 = 2;
        goto L114
    L99:
        if ((r124 & 805306368) != 0) goto L105;
        if (r7.changedInstance(r113) == false) goto L103;
        int r220 = 536870912;
    L104:
        r1 = r1 | r220;
        goto L105
    L103:
        r220 = 268435456;
        goto L104
    L89:
        if ((r124 & 100663296) != 0) goto L95;
        if (r7.changedInstance(r112) == false) goto L93;
        int r221 = 67108864;
    L94:
        r1 = r1 | r221;
        goto L95
    L93:
        r221 = 33554432;
        goto L94
    L68:
        if ((r124 & 1572864) != 0) goto L75;
        if (r7.changed(r110) == false) goto L72;
        int r222 = 1048576;
    L73:
        r1 = r1 | r222;
        goto L75
    L72:
        r222 = 524288;
        goto L73
    L58:
        if ((r124 & 196608) != 0) goto L64;
        if (r7.changed(r109) == false) goto L62;
        int r223 = 131072;
    L63:
        r1 = r1 | r223;
        goto L64
    L62:
        r223 = 65536;
        goto L63
    L47:
        if ((r124 & 24576) != 0) goto L54;
        if (r7.changed(r108) == false) goto L51;
        int r157 = 16384;
    L52:
        r1 = r1 | r157;
        goto L54
    L51:
        r157 = 8192;
        goto L52
    L37:
        if ((r124 & 3072) != 0) goto L43;
        if (r7.changedInstance(r107) == false) goto L41;
        int r79 = 2048;
    L42:
        r1 = r1 | r79;
        goto L43
    L41:
        r79 = 1024;
        goto L42
    L27:
        if ((r124 & 384) != 0) goto L34;
        if (r7.changed(r106) == false) goto L31;
        int r80 = 256;
    L32:
        r1 = r1 | r80;
        goto L34
    L31:
        r80 = 128;
        goto L32
    L17:
        if ((r124 & 48) != 0) goto L23;
        if (r7.changedInstance(r105) == false) goto L21;
        int r81 = 32;
    L22:
        r1 = r1 | r81;
        goto L23
    L21:
        r81 = 16;
        goto L22
    L6:
        if ((r124 & 6) == 0) goto L8;
        r1 = r124;
        goto L14
    L8:
        if (r7.changed(r104) == false) goto L10;
        int r82 = 4;
    L11:
        r1 = r82 | r124;
        goto L14
    L10:
        r82 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: inputFieldColors-JVEmHcM, reason: not valid java name */
    public final TextFieldColors m3049inputFieldColorsJVEmHcM(long r101, long r103, long r105, long r107, TextSelectionColors r109, long r110, long r112, long r114, long r116, long r118, long r120, long r122, long r124, long r126, long r128, long r130, long r132, long r134, long r136, long r138, long r140, long r142, long r144, Composer r146, int r147, int r148, int r149, int r150) {
        if ((r150 & 1) == 0) goto L5;
        long r5 = ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getInputTextColor(), r146, 6);
    L7:
        if ((r150 & 2) == 0) goto L9;
        long r9 = ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getInputTextColor(), r146, 6);
    L11:
        if ((r150 & 4) == 0) goto L13;
        FilledTextFieldTokens r3 = FilledTextFieldTokens.INSTANCE;
        long r11 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(r3.getDisabledInputColor(), r146, 6), r3.getDisabledInputOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
    L15:
        if ((r150 & 8) == 0) goto L17;
        long r17 = ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getCaretColor(), r146, 6);
    L19:
        if ((r150 & 16) == 0) goto L21;
        TextSelectionColors r21 = (TextSelectionColors) r146.consume(TextSelectionColorsKt.getLocalTextSelectionColors());
    L23:
        if ((r150 & 32) == 0) goto L25;
        long r30 = ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getLeadingIconColor(), r146, 6);
    L27:
        if ((r150 & 64) == 0) goto L29;
        long r32 = ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getLeadingIconColor(), r146, 6);
    L31:
        if ((r150 & 128) == 0) goto L33;
        FilledTextFieldTokens r4 = FilledTextFieldTokens.INSTANCE;
        long r34 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(r4.getDisabledLeadingIconColor(), r146, 6), r4.getDisabledLeadingIconOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
    L35:
        if ((r150 & 256) == 0) goto L37;
        long r38 = ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getTrailingIconColor(), r146, 6);
    L39:
        if ((r150 & 512) == 0) goto L41;
        long r40 = ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getTrailingIconColor(), r146, 6);
    L43:
        if ((r150 & 1024) == 0) goto L45;
        FilledTextFieldTokens r6 = FilledTextFieldTokens.INSTANCE;
        long r42 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(r6.getDisabledTrailingIconColor(), r146, 6), r6.getDisabledTrailingIconOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
    L47:
        if ((r150 & 2048) == 0) goto L49;
        long r54 = ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getSupportingTextColor(), r146, 6);
    L51:
        if ((r150 & 4096) == 0) goto L53;
        long r56 = ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getSupportingTextColor(), r146, 6);
    L55:
        if ((r150 & 8192) == 0) goto L57;
        FilledTextFieldTokens r7 = FilledTextFieldTokens.INSTANCE;
        long r58 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(r7.getDisabledInputColor(), r146, 6), r7.getDisabledInputOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
    L59:
        if ((r150 & 16384) == 0) goto L61;
        long r70 = ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getInputPrefixColor(), r146, 6);
    L63:
        if ((32768 & r150) == 0) goto L65;
        long r72 = ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getInputPrefixColor(), r146, 6);
    L67:
        if ((65536 & r150) == 0) goto L69;
        FilledTextFieldTokens r8 = FilledTextFieldTokens.INSTANCE;
        long r74 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(r8.getInputPrefixColor(), r146, 6), r8.getDisabledInputOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
    L71:
        if ((131072 & r150) == 0) goto L73;
        long r78 = ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getInputSuffixColor(), r146, 6);
    L75:
        if ((262144 & r150) == 0) goto L77;
        long r80 = ColorSchemeKt.getValue(FilledTextFieldTokens.INSTANCE.getInputSuffixColor(), r146, 6);
    L79:
        if ((524288 & r150) == 0) goto L81;
        FilledTextFieldTokens r10 = FilledTextFieldTokens.INSTANCE;
        long r82 = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(r10.getInputSuffixColor(), r146, 6), r10.getDisabledInputOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null);
    L83:
        if ((1048576 & r150) == 0) goto L85;
        long r94 = ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getContainerColor(), r146, 6);
    L87:
        if ((2097152 & r150) == 0) goto L89;
        long r96 = ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getContainerColor(), r146, 6);
    L91:
        if ((r150 & 4194304) == 0) goto L93;
        long r98 = ColorSchemeKt.getValue(SearchBarTokens.INSTANCE.getContainerColor(), r146, 6);
    L95:
        if (ComposerKt.isTraceInProgress() == false) goto L97;
        ComposerKt.traceEventStart(-2000124979, r147, r148, "androidx.compose.material3.SearchBarDefaults.inputFieldColors (SearchBar.kt:1220)");
    L97:
        int r12 = ((r147 & 14) | (r147 & 112)) | (r147 & 896);
        int r13 = r149 << 12;
        int r87 = (((r12 | (57344 & r13)) | (r13 & 458752)) | (r13 & 3670016)) | ((r147 << 15) & 234881024);
        int r88 = (((((r147 >> 12) & 14) | (r147 & 458752)) | (r147 & 3670016)) | (r147 & 29360128)) | ((r147 << 3) & 1879048192);
        int r14 = r148 << 3;
        int r1 = ((r147 >> 27) & 14) | (r14 & 112);
        int r91 = r148 << 18;
        int r89 = ((r1 | (r91 & 29360128)) | (r91 & 234881024)) | (r91 & 1879048192);
        int r90 = (((r14 & 458752) | (r14 & 3670016)) | (r14 & 29360128)) | ((r148 << 6) & 1879048192);
        int r2 = r148 >> 24;
        int r92 = ((r2 & 14) | 3072) | (r2 & 112);
        TextFieldColors r0 = TextFieldDefaults.INSTANCE.m3341colors0hiis_0(r5, r9, r11, 0, r94, r96, r98, 0, r17, 0, r21, 0, 0, 0, 0, r30, r32, r34, 0, r38, r40, r42, 0, 0, 0, 0, 0, r54, r56, r58, 0, 0, 0, 0, 0, r70, r72, r74, 0, r78, r80, r82, 0, r146, r87, r88, r89, r90, r92, 1204058760, 2191);
        if (ComposerKt.isTraceInProgress() == false) goto L100;
        ComposerKt.traceEventEnd();
    L100:
        return r0;
    L93:
        r98 = r144;
        goto L95
    L89:
        r96 = r142;
        goto L91
    L85:
        r94 = r140;
        goto L87
    L81:
        r82 = r138;
        goto L83
    L77:
        r80 = r136;
        goto L79
    L73:
        r78 = r134;
        goto L75
    L69:
        r74 = r132;
        goto L71
    L65:
        r72 = r130;
        goto L67
    L61:
        r70 = r128;
        goto L63
    L57:
        r58 = r126;
        goto L59
    L53:
        r56 = r124;
        goto L55
    L49:
        r54 = r122;
        goto L51
    L45:
        r42 = r120;
        goto L47
    L41:
        r40 = r118;
        goto L43
    L37:
        r38 = r116;
        goto L39
    L33:
        r34 = r114;
        goto L35
    L29:
        r32 = r112;
        goto L31
    L25:
        r30 = r110;
        goto L27
    L21:
        r21 = r109;
        goto L23
    L17:
        r17 = r107;
        goto L19
    L13:
        r11 = r105;
        goto L15
    L9:
        r9 = r103;
        goto L11
    L5:
        r5 = r101;
        goto L7
    }
}
