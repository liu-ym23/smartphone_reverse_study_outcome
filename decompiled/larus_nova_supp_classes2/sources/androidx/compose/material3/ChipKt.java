package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.tokens.AssistChipTokens;
import androidx.compose.material3.tokens.FilterChipTokens;
import androidx.compose.material3.tokens.InputChipTokens;
import androidx.compose.material3.tokens.SuggestionChipTokens;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a¨\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0002\u0010\u0016\u001a¦\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0007¢\u0006\u0002\u0010\u0018\u001a¨\u0001\u0010\u0019\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0002\u0010\u0016\u001a¦\u0001\u0010\u0019\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0007¢\u0006\u0002\u0010\u0018\u001a°\u0001\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\t2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u001c2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0002\u0010\u001e\u001a°\u0001\u0010\u001f\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\t2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u001c2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0002\u0010\u001e\u001aÇ\u0001\u0010 \u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\t2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010!\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0015\b\u0002\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u001c2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0002\u0010\"\u001a\u0091\u0001\u0010#\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0015\b\u0002\u0010$\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0002\u0010%\u001a\u008f\u0001\u0010#\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0015\b\u0002\u0010$\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0007¢\u0006\u0002\u0010&\u001a\u0091\u0001\u0010'\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0015\b\u0002\u0010$\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0002\u0010%\u001a\u008f\u0001\u0010'\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0015\b\u0002\u0010$\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0007¢\u0006\u0002\u0010&\u001a¸\u0001\u0010(\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\b\u001a\u00020\t2\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0013\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0013\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0003¢\u0006\u0004\b1\u00102\u001aÍ\u0001\u00103\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\b\u001a\u00020\t2\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\u0006\u0010)\u001a\u00020*2\u0013\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0013\u0010!\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0013\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u001c2\b\u0010\u0010\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0003¢\u0006\u0004\b4\u00105\u001a\u0091\u0001\u00106\u001a\u00020\u00012\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0013\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0013\u0010!\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0013\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0006\u00107\u001a\u00020,2\u0006\u00108\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0003¢\u0006\u0004\b9\u0010:\u001a\u0091\u0001\u0010;\u001a\u00020\u00012\u0011\u0010\u0004\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u00052\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0013\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0013\u0010!\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0013\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0006\u00107\u001a\u00020,2\u0006\u00108\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0003¢\u0006\u0004\b<\u0010:\u001aN\u0010=\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0013\u0010!\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0013\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0006\u00107\u001a\u00020,H\u0003¢\u0006\u0004\b>\u0010?\u001a9\u0010@\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0013\u0010\u000b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00052\u0006\u00108\u001a\u00020,H\u0003¢\u0006\u0004\bA\u0010B\u001a%\u0010C\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001HE0D\"\u0004\b\u0000\u0010E2\b\u0010F\u001a\u0004\u0018\u0001HEH\u0003¢\u0006\u0002\u0010G\u001a&\u0010L\u001a\u0002002\b\b\u0002\u0010M\u001a\u00020\t2\b\b\u0002\u0010N\u001a\u00020\t2\b\b\u0002\u0010O\u001a\u00020\tH\u0002\"\u0018\u0010H\u001a\u00020\u000f*\u00020I8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010K\"\u0010\u0010P\u001a\u00020.X\u0082\u0004¢\u0006\u0004\n\u0002\u0010Q\"\u000e\u0010R\u001a\u000200X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010S\u001a\u000200X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010T\u001a\u000200X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010U\u001a\u00020VX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010W\u001a\u00020VX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010X\u001a\u00020VX\u0082T¢\u0006\u0002\n\u0000¨\u0006Y"}, d2 = {"AssistChip", "", "onClick", "Lkotlin/Function0;", ChipKt.LabelLayoutId, "Landroidx/compose/runtime/Composable;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", ChipKt.LeadingIconLayoutId, ChipKt.TrailingIconLayoutId, "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/ChipColors;", "elevation", "Landroidx/compose/material3/ChipElevation;", androidx.compose.material.OutlinedTextFieldKt.BorderId, "Landroidx/compose/foundation/BorderStroke;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/ChipColors;Landroidx/compose/material3/ChipElevation;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "Landroidx/compose/material3/ChipBorder;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/ChipColors;Landroidx/compose/material3/ChipElevation;Landroidx/compose/material3/ChipBorder;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "ElevatedAssistChip", "FilterChip", "selected", "Landroidx/compose/material3/SelectableChipColors;", "Landroidx/compose/material3/SelectableChipElevation;", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SelectableChipColors;Landroidx/compose/material3/SelectableChipElevation;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "ElevatedFilterChip", "InputChip", "avatar", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SelectableChipColors;Landroidx/compose/material3/SelectableChipElevation;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;III)V", "SuggestionChip", "icon", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/ChipColors;Landroidx/compose/material3/ChipElevation;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/ChipColors;Landroidx/compose/material3/ChipElevation;Landroidx/compose/material3/ChipBorder;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "ElevatedSuggestionChip", "Chip", "labelTextStyle", "Landroidx/compose/ui/text/TextStyle;", "labelColor", "Landroidx/compose/ui/graphics/Color;", "minHeight", "Landroidx/compose/ui/unit/Dp;", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "Chip-nkUnTEs", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;ZLkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;JLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/ChipColors;Landroidx/compose/material3/ChipElevation;Landroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "SelectableChip", "SelectableChip-u0RnIRE", "(ZLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;ZLkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/SelectableChipColors;Landroidx/compose/material3/SelectableChipElevation;Landroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "ChipContent", "leadingIconColor", "trailingIconColor", "ChipContent-fe0OD_I", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;JLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;JJFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;I)V", "AnimatingChipContent", "AnimatingChipContent-fe0OD_I", "leadingContent", "leadingContent-XO-JAsU", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;JLandroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function2;", "trailingContent", "trailingContent-RPmYEkk", "(Lkotlin/jvm/functions/Function2;JLandroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function2;", "rememberRetainedState", "Landroidx/compose/runtime/State;", "T", "targetValue", "(Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "defaultSuggestionChipColors", "Landroidx/compose/material3/ColorScheme;", "getDefaultSuggestionChipColors", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/ChipColors;", "inputChipPadding", "hasAvatar", "hasLeadingIcon", "hasTrailingIcon", "HorizontalElementsPadding", "F", "AssistChipPadding", "FilterChipPadding", "SuggestionChipPadding", "LeadingIconLayoutId", "", "LabelLayoutId", "TrailingIconLayoutId", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ChipKt {
    private static final PaddingValues AssistChipPadding = null;
    private static final PaddingValues FilterChipPadding = null;
    private static final float HorizontalElementsPadding = 0.0f;
    private static final String LabelLayoutId = "label";
    private static final String LeadingIconLayoutId = "leadingIcon";
    private static final PaddingValues SuggestionChipPadding = null;
    private static final String TrailingIconLayoutId = "trailingIcon";

    /* JADX INFO: renamed from: androidx.compose.material3.ChipKt$InputChip$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class AnonymousClass1 implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ Function2<Composer, Integer, Unit> $avatar;
        final /* synthetic */ float $avatarOpacity;
        final /* synthetic */ Shape $avatarShape;

        public AnonymousClass1(float r1, Shape r2, Function2<? super Composer, ? super Integer, Unit> r3) {
            this.$avatarOpacity = r1;
            this.$avatarShape = r2;
            this.$avatar = r3;
        }

        public static /* synthetic */ Unit a(float r0, Shape r1, GraphicsLayerScope r2) {
            return invoke$lambda$1$lambda$0(r0, r1, r2);
        }

        public final void invoke(Composer r9, int r10) {
            if ((r10 & 3) == 2) goto L5;
            boolean r0 = true;
        L7:
            if (r9.shouldExecute(r0, r10 & 1) == true) goto L9;
            r9.skipToGroupEnd();
            return;
        L9:
            if (ComposerKt.isTraceInProgress() == false) goto L11;
            ComposerKt.traceEventStart(-570452295, r10, -1, "androidx.compose.material3.InputChip.<anonymous> (Chip.kt:654)");
        L11:
            Modifier.Companion r11 = Modifier.Companion;
            boolean r1 = r9.changed(this.$avatarOpacity) | r9.changed(this.$avatarShape);
            final float r2 = this.$avatarOpacity;
            final Shape r3 = this.$avatarShape;
            Object r4 = r9.rememberedValue();
            if (r1 == false) goto L14;
        L15:
            r4 = new x3(r2, r3);
            r9.updateRememberedValue(r4);
        L16:
            Modifier r12 = GraphicsLayerModifierKt.graphicsLayer(r11, (Function1) r4);
            Alignment r5 = Alignment.Companion.getCenter();
            Function2<Composer, Integer, Unit> r6 = this.$avatar;
            MeasurePolicy r7 = BoxKt.maybeCachedBoxMeasurePolicy(r5, false);
            int r8 = ComposablesKt.getCurrentCompositeKeyHash(r9, 0);
            CompositionLocalMap r13 = r9.getCurrentCompositionLocalMap();
            Modifier r14 = ComposedModifierKt.materializeModifier(r9, r12);
            ComposeUiNode.Companion r15 = ComposeUiNode.Companion;
            Function0 r16 = r15.getConstructor();
            if ((r9.getApplier() instanceof Applier) == true) goto L19;
            ComposablesKt.invalidApplier();
        L19:
            r9.startReusableNode();
            if (r9.getInserting() == false) goto L22;
            r9.createNode(r16);
        L23:
            Composer r17 = Updater.constructor-impl(r9);
            Updater.set-impl(r17, r7, r15.getSetMeasurePolicy());
            Updater.set-impl(r17, r13, r15.getSetResolvedCompositionLocals());
            Function2 r18 = r15.getSetCompositeKeyHash();
            if (r17.getInserting() == false) goto L26;
        L27:
            r17.updateRememberedValue(Integer.valueOf(r8));
            r17.apply(Integer.valueOf(r8), r18);
        L28:
            Updater.set-impl(r17, r14, r15.getSetModifier());
            BoxScopeInstance r19 = BoxScopeInstance.INSTANCE;
            r6.invoke(r9, 0);
            r9.endNode();
            if (ComposerKt.isTraceInProgress() == false) goto L33;
            ComposerKt.traceEventEnd();
            return;
        L33:
            return;
        L26:
            if (Intrinsics.areEqual(r17.rememberedValue(), Integer.valueOf(r8)) == true) goto L28;
        L22:
            r9.useNode();
            goto L23
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

        private static final Unit invoke$lambda$1$lambda$0(float r0, Shape r1, GraphicsLayerScope r2) {
            r2.setAlpha(r0);
            r2.setShape(r1);
            r2.setClip(true);
            return Unit.INSTANCE;
        }
    }

    private static final Unit AnimatingChipContent_fe0OD_I$lambda$24(Function2 r16, TextStyle r17, long r18, Function2 r20, Function2 r21, Function2 r22, long r23, long r25, float r27, PaddingValues r28, int r29, Composer r30, int r31) {
        m2415AnimatingChipContentfe0OD_I(r16, r17, r18, r20, r21, r22, r23, r25, r27, r28, r30, RecomposeScopeImplKt.updateChangedFlags(r29 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit AssistChip$lambda$0(Function0 r16, Function2 r17, Modifier r18, boolean r19, Function2 r20, Function2 r21, Shape r22, ChipColors r23, ChipElevation r24, BorderStroke r25, MutableInteractionSource r26, int r27, int r28, int r29, Composer r30, int r31) {
        AssistChip(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r30, RecomposeScopeImplKt.updateChangedFlags(r27 | 1), RecomposeScopeImplKt.updateChangedFlags(r28), r29);
        return Unit.INSTANCE;
    }

    private static final Unit AssistChip$lambda$2(Function0 r16, Function2 r17, Modifier r18, boolean r19, Function2 r20, Function2 r21, Shape r22, ChipColors r23, ChipElevation r24, ChipBorder r25, MutableInteractionSource r26, int r27, int r28, int r29, Composer r30, int r31) {
        AssistChip(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r30, RecomposeScopeImplKt.updateChangedFlags(r27 | 1), RecomposeScopeImplKt.updateChangedFlags(r28), r29);
        return Unit.INSTANCE;
    }

    private static final Unit ChipContent_fe0OD_I$lambda$23(Function2 r16, TextStyle r17, long r18, Function2 r20, Function2 r21, Function2 r22, long r23, long r25, float r27, PaddingValues r28, int r29, Composer r30, int r31) {
        m2417ChipContentfe0OD_I(r16, r17, r18, r20, r21, r22, r23, r25, r27, r28, r30, RecomposeScopeImplKt.updateChangedFlags(r29 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit Chip_nkUnTEs$lambda$18(Modifier r19, Function0 r20, boolean r21, Function2 r22, TextStyle r23, long r24, Function2 r26, Function2 r27, Shape r28, ChipColors r29, ChipElevation r30, BorderStroke r31, float r32, PaddingValues r33, MutableInteractionSource r34, int r35, int r36, Composer r37, int r38) {
        m2416ChipnkUnTEs(r19, r20, r21, r22, r23, r24, r26, r27, r28, r29, r30, r31, r32, r33, r34, r37, RecomposeScopeImplKt.updateChangedFlags(r35 | 1), RecomposeScopeImplKt.updateChangedFlags(r36));
        return Unit.INSTANCE;
    }

    private static final Unit ElevatedAssistChip$lambda$3(Function0 r16, Function2 r17, Modifier r18, boolean r19, Function2 r20, Function2 r21, Shape r22, ChipColors r23, ChipElevation r24, BorderStroke r25, MutableInteractionSource r26, int r27, int r28, int r29, Composer r30, int r31) {
        ElevatedAssistChip(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r30, RecomposeScopeImplKt.updateChangedFlags(r27 | 1), RecomposeScopeImplKt.updateChangedFlags(r28), r29);
        return Unit.INSTANCE;
    }

    private static final Unit ElevatedAssistChip$lambda$5(Function0 r16, Function2 r17, Modifier r18, boolean r19, Function2 r20, Function2 r21, Shape r22, ChipColors r23, ChipElevation r24, ChipBorder r25, MutableInteractionSource r26, int r27, int r28, int r29, Composer r30, int r31) {
        ElevatedAssistChip(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r30, RecomposeScopeImplKt.updateChangedFlags(r27 | 1), RecomposeScopeImplKt.updateChangedFlags(r28), r29);
        return Unit.INSTANCE;
    }

    private static final Unit ElevatedFilterChip$lambda$7(boolean r17, Function0 r18, Function2 r19, Modifier r20, boolean r21, Function2 r22, Function2 r23, Shape r24, SelectableChipColors r25, SelectableChipElevation r26, BorderStroke r27, MutableInteractionSource r28, int r29, int r30, int r31, Composer r32, int r33) {
        ElevatedFilterChip(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r32, RecomposeScopeImplKt.updateChangedFlags(r29 | 1), RecomposeScopeImplKt.updateChangedFlags(r30), r31);
        return Unit.INSTANCE;
    }

    private static final Unit ElevatedSuggestionChip$lambda$12(Function0 r14, Function2 r15, Modifier r16, boolean r17, Function2 r18, Shape r19, ChipColors r20, ChipElevation r21, BorderStroke r22, MutableInteractionSource r23, int r24, int r25, Composer r26, int r27) {
        ElevatedSuggestionChip(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r26, RecomposeScopeImplKt.updateChangedFlags(r24 | 1), r25);
        return Unit.INSTANCE;
    }

    private static final Unit ElevatedSuggestionChip$lambda$14(Function0 r14, Function2 r15, Modifier r16, boolean r17, Function2 r18, Shape r19, ChipColors r20, ChipElevation r21, ChipBorder r22, MutableInteractionSource r23, int r24, int r25, Composer r26, int r27) {
        ElevatedSuggestionChip(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r26, RecomposeScopeImplKt.updateChangedFlags(r24 | 1), r25);
        return Unit.INSTANCE;
    }

    private static final Unit FilterChip$lambda$6(boolean r17, Function0 r18, Function2 r19, Modifier r20, boolean r21, Function2 r22, Function2 r23, Shape r24, SelectableChipColors r25, SelectableChipElevation r26, BorderStroke r27, MutableInteractionSource r28, int r29, int r30, int r31, Composer r32, int r33) {
        FilterChip(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r32, RecomposeScopeImplKt.updateChangedFlags(r29 | 1), RecomposeScopeImplKt.updateChangedFlags(r30), r31);
        return Unit.INSTANCE;
    }

    private static final Unit InputChip$lambda$8(boolean r17, Function0 r18, Function2 r19, Modifier r20, boolean r21, Function2 r22, Function2 r23, Function2 r24, Shape r25, SelectableChipColors r26, SelectableChipElevation r27, BorderStroke r28, MutableInteractionSource r29, int r30, int r31, int r32, Composer r33, int r34) {
        InputChip(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r33, RecomposeScopeImplKt.updateChangedFlags(r30 | 1), RecomposeScopeImplKt.updateChangedFlags(r31), r32);
        return Unit.INSTANCE;
    }

    private static final Unit SelectableChip_u0RnIRE$lambda$22(boolean r19, Modifier r20, Function0 r21, boolean r22, Function2 r23, TextStyle r24, Function2 r25, Function2 r26, Function2 r27, Shape r28, SelectableChipColors r29, SelectableChipElevation r30, BorderStroke r31, float r32, PaddingValues r33, MutableInteractionSource r34, int r35, int r36, Composer r37, int r38) {
        m2418SelectableChipu0RnIRE(r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r37, RecomposeScopeImplKt.updateChangedFlags(r35 | 1), RecomposeScopeImplKt.updateChangedFlags(r36));
        return Unit.INSTANCE;
    }

    private static final Unit SuggestionChip$lambda$11(Function0 r14, Function2 r15, Modifier r16, boolean r17, Function2 r18, Shape r19, ChipColors r20, ChipElevation r21, ChipBorder r22, MutableInteractionSource r23, int r24, int r25, Composer r26, int r27) {
        SuggestionChip(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r26, RecomposeScopeImplKt.updateChangedFlags(r24 | 1), r25);
        return Unit.INSTANCE;
    }

    private static final Unit SuggestionChip$lambda$9(Function0 r14, Function2 r15, Modifier r16, boolean r17, Function2 r18, Shape r19, ChipColors r20, ChipElevation r21, BorderStroke r22, MutableInteractionSource r23, int r24, int r25, Composer r26, int r27) {
        SuggestionChip(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r26, RecomposeScopeImplKt.updateChangedFlags(r24 | 1), r25);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(Function2 r0, TextStyle r1, long r2, Function2 r4, Function2 r5, Function2 r6, long r7, long r9, float r11, PaddingValues r12, int r13, Composer r14, int r15) {
        return AnimatingChipContent_fe0OD_I$lambda$24(r0, r1, r2, r4, r5, r6, r7, r9, r11, r12, r13, r14, r15);
    }

    public static /* synthetic */ Unit b(Function0 r0, Function2 r1, Modifier r2, boolean r3, Function2 r4, Shape r5, ChipColors r6, ChipElevation r7, BorderStroke r8, MutableInteractionSource r9, int r10, int r11, Composer r12, int r13) {
        return ElevatedSuggestionChip$lambda$12(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
    }

    public static /* synthetic */ Unit c(boolean r1, Function0 r2, Function2 r3, Modifier r4, boolean r5, Function2 r6, Function2 r7, Shape r8, SelectableChipColors r9, SelectableChipElevation r10, BorderStroke r11, MutableInteractionSource r12, int r13, int r14, int r15, Composer r16, int r17) {
        return FilterChip$lambda$6(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17);
    }

    public static /* synthetic */ Unit d(Function2 r0, TextStyle r1, long r2, Function2 r4, Function2 r5, Function2 r6, long r7, long r9, float r11, PaddingValues r12, int r13, Composer r14, int r15) {
        return ChipContent_fe0OD_I$lambda$23(r0, r1, r2, r4, r5, r6, r7, r9, r11, r12, r13, r14, r15);
    }

    public static /* synthetic */ Unit e(boolean r1, Function0 r2, Function2 r3, Modifier r4, boolean r5, Function2 r6, Function2 r7, Function2 r8, Shape r9, SelectableChipColors r10, SelectableChipElevation r11, BorderStroke r12, MutableInteractionSource r13, int r14, int r15, int r16, Composer r17, int r18) {
        return InputChip$lambda$8(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public static /* synthetic */ Unit f(Modifier r1, Function0 r2, boolean r3, Function2 r4, TextStyle r5, long r6, Function2 r8, Function2 r9, Shape r10, ChipColors r11, ChipElevation r12, BorderStroke r13, float r14, PaddingValues r15, MutableInteractionSource r16, int r17, int r18, Composer r19, int r20) {
        return Chip_nkUnTEs$lambda$18(r1, r2, r3, r4, r5, r6, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20);
    }

    public static /* synthetic */ Unit g(Function0 r0, Function2 r1, Modifier r2, boolean r3, Function2 r4, Function2 r5, Shape r6, ChipColors r7, ChipElevation r8, BorderStroke r9, MutableInteractionSource r10, int r11, int r12, int r13, Composer r14, int r15) {
        return AssistChip$lambda$0(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15);
    }

    public static /* synthetic */ Unit h(Function0 r0, Function2 r1, Modifier r2, boolean r3, Function2 r4, Function2 r5, Shape r6, ChipColors r7, ChipElevation r8, ChipBorder r9, MutableInteractionSource r10, int r11, int r12, int r13, Composer r14, int r15) {
        return ElevatedAssistChip$lambda$5(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15);
    }

    public static /* synthetic */ Unit i(Function0 r0, Function2 r1, Modifier r2, boolean r3, Function2 r4, Shape r5, ChipColors r6, ChipElevation r7, BorderStroke r8, MutableInteractionSource r9, int r10, int r11, Composer r12, int r13) {
        return SuggestionChip$lambda$9(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
    }

    public static /* synthetic */ Unit j(Function0 r0, Function2 r1, Modifier r2, boolean r3, Function2 r4, Shape r5, ChipColors r6, ChipElevation r7, ChipBorder r8, MutableInteractionSource r9, int r10, int r11, Composer r12, int r13) {
        return ElevatedSuggestionChip$lambda$14(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
    }

    public static /* synthetic */ Unit k(boolean r1, Function0 r2, Function2 r3, Modifier r4, boolean r5, Function2 r6, Function2 r7, Shape r8, SelectableChipColors r9, SelectableChipElevation r10, BorderStroke r11, MutableInteractionSource r12, int r13, int r14, int r15, Composer r16, int r17) {
        return ElevatedFilterChip$lambda$7(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17);
    }

    public static /* synthetic */ Unit l(Function0 r0, Function2 r1, Modifier r2, boolean r3, Function2 r4, Function2 r5, Shape r6, ChipColors r7, ChipElevation r8, BorderStroke r9, MutableInteractionSource r10, int r11, int r12, int r13, Composer r14, int r15) {
        return ElevatedAssistChip$lambda$3(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15);
    }

    public static /* synthetic */ Unit m(boolean r1, Modifier r2, Function0 r3, boolean r4, Function2 r5, TextStyle r6, Function2 r7, Function2 r8, Function2 r9, Shape r10, SelectableChipColors r11, SelectableChipElevation r12, BorderStroke r13, float r14, PaddingValues r15, MutableInteractionSource r16, int r17, int r18, Composer r19, int r20) {
        return SelectableChip_u0RnIRE$lambda$22(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20);
    }

    public static /* synthetic */ Unit n(Function0 r0, Function2 r1, Modifier r2, boolean r3, Function2 r4, Function2 r5, Shape r6, ChipColors r7, ChipElevation r8, ChipBorder r9, MutableInteractionSource r10, int r11, int r12, int r13, Composer r14, int r15) {
        return AssistChip$lambda$2(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15);
    }

    public static /* synthetic */ Unit o(SemanticsPropertyReceiver r0) {
        return SelectableChip_u0RnIRE$lambda$21$lambda$20(r0);
    }

    public static /* synthetic */ Unit p(SemanticsPropertyReceiver r0) {
        return Chip_nkUnTEs$lambda$17$lambda$16(r0);
    }

    public static /* synthetic */ Unit q(Function0 r0, Function2 r1, Modifier r2, boolean r3, Function2 r4, Shape r5, ChipColors r6, ChipElevation r7, ChipBorder r8, MutableInteractionSource r9, int r10, int r11, Composer r12, int r13) {
        return SuggestionChip$lambda$11(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
    }

    static {
        float r0 = Dp.constructor-impl(8);
        HorizontalElementsPadding = r0;
        AssistChipPadding = PaddingKt.m955PaddingValuesYgX7TsA$default(r0, MenuKt.ClosedAlphaTarget, 2, null);
        FilterChipPadding = PaddingKt.m955PaddingValuesYgX7TsA$default(r0, MenuKt.ClosedAlphaTarget, 2, null);
        SuggestionChipPadding = PaddingKt.m955PaddingValuesYgX7TsA$default(r0, MenuKt.ClosedAlphaTarget, 2, null);
    }

    public static final /* synthetic */ float access$getHorizontalElementsPadding$p() {
        return HorizontalElementsPadding;
    }

    private static final Unit Chip_nkUnTEs$lambda$17$lambda$16(SemanticsPropertyReceiver r1) {
        SemanticsPropertiesKt.setRole-kuIjeqM(r1, Role.Companion.getButton-o7Vup1c());
        return Unit.INSTANCE;
    }

    private static final Unit SelectableChip_u0RnIRE$lambda$21$lambda$20(SemanticsPropertyReceiver r1) {
        SemanticsPropertiesKt.setRole-kuIjeqM(r1, Role.Companion.getCheckbox-o7Vup1c());
        return Unit.INSTANCE;
    }

    public static final ChipColors getDefaultSuggestionChipColors(ColorScheme r29) {
        ChipColors r1 = r29.getDefaultSuggestionChipColorsCached$material3();
        if (r1 != null) goto L6;
        Color.Companion r17 = Color.Companion;
        long r3 = r17.getTransparent-0d7_KjU();
        SuggestionChipTokens r15 = SuggestionChipTokens.INSTANCE;
        ChipColors r2 = new ChipColors(r3, ColorSchemeKt.fromToken(r29, r15.getLabelTextColor()), ColorSchemeKt.fromToken(r29, r15.getLeadingIconColor()), r17.getUnspecified-0d7_KjU(), r17.getTransparent-0d7_KjU(), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r29, r15.getDisabledLabelTextColor()), r15.getDisabledLabelTextOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r29, r15.getDisabledLeadingIconColor()), r15.getDisabledLeadingIconOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), r17.getUnspecified-0d7_KjU(), null);
        r29.setDefaultSuggestionChipColorsCached$material3(r2);
        return r2;
    L6:
        return r1;
    }

    public static final /* synthetic */ State access$rememberRetainedState(Object r0, Composer r1, int r2) {
        return rememberRetainedState(r0, r1, r2);
    }

    private static final PaddingValues inputChipPadding(boolean r8, boolean r9, boolean r10) {
        if (r8 == true) goto L7;
        if (r9 == false) goto L7;
        float r11 = 8;
    L8:
        float r12 = Dp.constructor-impl(r11);
        if (r10 == false) goto L11;
        float r13 = 8;
    L13:
        return PaddingKt.m957PaddingValuesa9UjIt4$default(r12, MenuKt.ClosedAlphaTarget, Dp.constructor-impl(r13), MenuKt.ClosedAlphaTarget, 10, null);
    L11:
        r13 = 4;
    L7:
        r11 = 4;
        goto L8
    }

    private static final <T> State<T> rememberRetainedState(T r3, Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-618198444, r5, -1, "androidx.compose.material3.rememberRetainedState (Chip.kt:2248)");
    L5:
        Object r6 = r4.rememberedValue();
        if (r6 != Composer.Companion.getEmpty()) goto L8;
        r6 = SnapshotStateKt.mutableStateOf$default(r3, null, 2, null);
        r4.updateRememberedValue(r6);
    L8:
        MutableState r7 = (MutableState) r6;
        if (r3 == null) goto L12;
        r7.setValue(r3);
    L12:
        if (ComposerKt.isTraceInProgress() == false) goto L14;
        ComposerKt.traceEventEnd();
    L14:
        return r7;
    }

    /* JADX INFO: renamed from: access$trailingContent-RPmYEkk, reason: not valid java name */
    public static final /* synthetic */ Function2 m2422access$trailingContentRPmYEkk(Function2 r0, long r1, Composer r3, int r4) {
        return m2424trailingContentRPmYEkk(r0, r1, r3, r4);
    }

    /* JADX INFO: renamed from: trailingContent-RPmYEkk, reason: not valid java name */
    private static final Function2<Composer, Integer, Unit> m2424trailingContentRPmYEkk(final Function2<? super Composer, ? super Integer, Unit> r3, final long r4, Composer r6, int r7) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(-165980551, r7, -1, "androidx.compose.material3.trailingContent (Chip.kt:2231)");
    L5:
        if (r3 == null) goto L7;
        r6.startReplaceGroup(-1219055576);
        ComposableLambda r5 = ComposableLambdaKt.rememberComposableLambda(-566924201, true, new ChipKt$trailingContent$1(r4, r3), r6, 54);
        r6.endReplaceGroup();
    L9:
        if (ComposerKt.isTraceInProgress() == false) goto L11;
        ComposerKt.traceEventEnd();
    L11:
        return r5;
    L7:
        r6.startReplaceGroup(-1218863531);
        r6.endReplaceGroup();
        r5 = null;
        goto L9
    }

    /* JADX INFO: renamed from: access$leadingContent-XO-JAsU, reason: not valid java name */
    public static final /* synthetic */ Function2 m2421access$leadingContentXOJAsU(Function2 r0, Function2 r1, long r2, Composer r4, int r5) {
        return m2423leadingContentXOJAsU(r0, r1, r2, r4, r5);
    }

    public static /* synthetic */ PaddingValues inputChipPadding$default(boolean r1, boolean r2, boolean r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = false;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = false;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = false;
    L12:
        return inputChipPadding(r1, r2, r3);
    }

    /* JADX INFO: renamed from: leadingContent-XO-JAsU, reason: not valid java name */
    private static final Function2<Composer, Integer, Unit> m2423leadingContentXOJAsU(Function2<? super Composer, ? super Integer, Unit> r3, final Function2<? super Composer, ? super Integer, Unit> r4, final long r5, Composer r7, int r8) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(1330309098, r8, -1, "androidx.compose.material3.leadingContent (Chip.kt:2212)");
    L5:
        if (r3 == null) goto L7;
        r7.startReplaceGroup(-1473203984);
        r7.endReplaceGroup();
    L11:
        if (ComposerKt.isTraceInProgress() == false) goto L13;
        ComposerKt.traceEventEnd();
    L13:
        return r3;
    L7:
        if (r4 == null) goto L9;
        r7.startReplaceGroup(1575390813);
        r3 = ComposableLambdaKt.rememberComposableLambda(-237350650, true, new ChipKt$leadingContent$1(r5, r4), r7, 54);
        r7.endReplaceGroup();
        goto L11
    L9:
        r7.startReplaceGroup(1575618259);
        r7.endReplaceGroup();
        r3 = null;
        goto L11
    }

    /* JADX INFO: renamed from: AnimatingChipContent-fe0OD_I, reason: not valid java name */
    private static final void m2415AnimatingChipContentfe0OD_I(final Function2<? super Composer, ? super Integer, Unit> r27, final TextStyle r28, final long r29, final Function2<? super Composer, ? super Integer, Unit> r31, final Function2<? super Composer, ? super Integer, Unit> r32, final Function2<? super Composer, ? super Integer, Unit> r33, final long r34, final long r36, final float r38, final PaddingValues r39, Composer r40, final int r41) {
        Composer r1 = r40.startRestartGroup(-2070754602);
        if ((r41 & 6) == 0) goto L5;
        int r5 = r41;
    L11:
        if ((r41 & 48) != 0) goto L18;
        if (r1.changed(r28) == false) goto L15;
        int r6 = 32;
    L16:
        r5 = r5 | r6;
        goto L18
    L15:
        r6 = 16;
    L18:
        if ((r41 & 384) != 0) goto L26;
        if (r1.changed(r29) == false) goto L22;
        int r8 = 256;
    L23:
        r5 = r5 | r8;
        goto L26
    L22:
        r8 = 128;
    L26:
        if ((r41 & 3072) != 0) goto L34;
        if (r1.changedInstance(r31) == false) goto L30;
        int r9 = 2048;
    L31:
        r5 = r5 | r9;
        goto L34
    L30:
        r9 = 1024;
    L34:
        if ((r41 & 24576) != 0) goto L42;
        if (r1.changedInstance(r32) == false) goto L38;
        int r10 = 16384;
    L39:
        r5 = r5 | r10;
        goto L42
    L38:
        r10 = 8192;
    L42:
        if ((196608 & r41) != 0) goto L50;
        if (r1.changedInstance(r33) == false) goto L46;
        int r11 = 131072;
    L47:
        r5 = r5 | r11;
        goto L50
    L46:
        r11 = 65536;
    L50:
        if ((1572864 & r41) != 0) goto L58;
        if (r1.changed(r34) == false) goto L54;
        int r13 = 1048576;
    L55:
        r5 = r5 | r13;
        goto L58
    L54:
        r13 = 524288;
    L58:
        if ((12582912 & r41) != 0) goto L64;
        int r14 = r5;
        if (r1.changed(r36) == false) goto L62;
        int r15 = 8388608;
    L63:
        int r16 = r14 | r15;
    L66:
        if ((100663296 & r41) != 0) goto L74;
        if (r1.changed(r38) == false) goto L70;
        int r17 = 67108864;
    L71:
        r16 = r16 | r17;
        goto L74
    L70:
        r17 = 33554432;
    L74:
        if ((r41 & 805306368) != 0) goto L81;
        if (r1.changed(r39) == false) goto L78;
        int r18 = 536870912;
    L79:
        r16 = r16 | r18;
        goto L81
    L78:
        r18 = 268435456;
    L81:
        if ((r16 & 306783379) == 306783378) goto L83;
        boolean r0 = true;
    L85:
        if (r1.shouldExecute(r0, r16 & 1) == true) goto L87;
        r1.skipToGroupEnd();
    L93:
        ScopeUpdateScope r19 = r1.endRestartGroup();
        if (r19 == null) goto L97;
        r19.updateScope(new t3(r27, r28, r29, r31, r32, r33, r34, r36, r38, r39, r41));
        return;
    L97:
        return;
    L87:
        if (ComposerKt.isTraceInProgress() == false) goto L89;
        ComposerKt.traceEventStart(-2070754602, r16, -1, "androidx.compose.material3.AnimatingChipContent (Chip.kt:2114)");
    L89:
        CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.box-impl(r29)), TextKt.getLocalTextStyle().provides(r28)}, ComposableLambdaKt.rememberComposableLambda(-668234218, true, new ChipKt$AnimatingChipContent$1(r38, r39, r32, r31, r33, r34, r27, r36), r1, 54), r1, ProvidedValue.$stable | 48);
        if (ComposerKt.isTraceInProgress() == false) goto L93;
        ComposerKt.traceEventEnd();
        goto L93
    L83:
        r0 = false;
        goto L85
    L62:
        r15 = 4194304;
        goto L63
    L64:
        r16 = r5;
        goto L66
    L5:
        if (r1.changedInstance(r27) == false) goto L7;
        int r7 = 4;
    L8:
        r5 = r7 | r41;
        goto L11
    L7:
        r7 = 2;
        goto L8
    }

    /* JADX INFO: renamed from: ChipContent-fe0OD_I, reason: not valid java name */
    private static final void m2417ChipContentfe0OD_I(final Function2<? super Composer, ? super Integer, Unit> r27, final TextStyle r28, final long r29, final Function2<? super Composer, ? super Integer, Unit> r31, final Function2<? super Composer, ? super Integer, Unit> r32, final Function2<? super Composer, ? super Integer, Unit> r33, final long r34, final long r36, final float r38, final PaddingValues r39, Composer r40, final int r41) {
        Composer r1 = r40.startRestartGroup(1105630840);
        if ((r41 & 6) == 0) goto L5;
        int r5 = r41;
    L11:
        if ((r41 & 48) != 0) goto L18;
        if (r1.changed(r28) == false) goto L15;
        int r6 = 32;
    L16:
        r5 = r5 | r6;
        goto L18
    L15:
        r6 = 16;
    L18:
        if ((r41 & 384) != 0) goto L26;
        if (r1.changed(r29) == false) goto L22;
        int r8 = 256;
    L23:
        r5 = r5 | r8;
        goto L26
    L22:
        r8 = 128;
    L26:
        if ((r41 & 3072) != 0) goto L34;
        if (r1.changedInstance(r31) == false) goto L30;
        int r9 = 2048;
    L31:
        r5 = r5 | r9;
        goto L34
    L30:
        r9 = 1024;
    L34:
        if ((r41 & 24576) != 0) goto L42;
        if (r1.changedInstance(r32) == false) goto L38;
        int r10 = 16384;
    L39:
        r5 = r5 | r10;
        goto L42
    L38:
        r10 = 8192;
    L42:
        if ((196608 & r41) != 0) goto L50;
        if (r1.changedInstance(r33) == false) goto L46;
        int r11 = 131072;
    L47:
        r5 = r5 | r11;
        goto L50
    L46:
        r11 = 65536;
    L50:
        if ((1572864 & r41) != 0) goto L58;
        if (r1.changed(r34) == false) goto L54;
        int r13 = 1048576;
    L55:
        r5 = r5 | r13;
        goto L58
    L54:
        r13 = 524288;
    L58:
        if ((12582912 & r41) != 0) goto L64;
        int r14 = r5;
        if (r1.changed(r36) == false) goto L62;
        int r15 = 8388608;
    L63:
        int r16 = r14 | r15;
    L66:
        if ((100663296 & r41) != 0) goto L74;
        if (r1.changed(r38) == false) goto L70;
        int r17 = 67108864;
    L71:
        r16 = r16 | r17;
        goto L74
    L70:
        r17 = 33554432;
    L74:
        if ((r41 & 805306368) != 0) goto L81;
        if (r1.changed(r39) == false) goto L78;
        int r18 = 536870912;
    L79:
        r16 = r16 | r18;
        goto L81
    L78:
        r18 = 268435456;
    L81:
        if ((r16 & 306783379) == 306783378) goto L83;
        boolean r0 = true;
    L85:
        if (r1.shouldExecute(r0, r16 & 1) == true) goto L87;
        r1.skipToGroupEnd();
    L93:
        ScopeUpdateScope r19 = r1.endRestartGroup();
        if (r19 == null) goto L97;
        r19.updateScope(new u3(r27, r28, r29, r31, r32, r33, r34, r36, r38, r39, r41));
        return;
    L97:
        return;
    L87:
        if (ComposerKt.isTraceInProgress() == false) goto L89;
        ComposerKt.traceEventStart(1105630840, r16, -1, "androidx.compose.material3.ChipContent (Chip.kt:2052)");
    L89:
        CompositionLocalKt.CompositionLocalProvider(new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.box-impl(r29)), TextKt.getLocalTextStyle().provides(r28)}, ComposableLambdaKt.rememberComposableLambda(-2130105544, true, new ChipKt$ChipContent$1(r38, r39, r32, r31, r33, r34, r27, r36), r1, 54), r1, ProvidedValue.$stable | 48);
        if (ComposerKt.isTraceInProgress() == false) goto L93;
        ComposerKt.traceEventEnd();
        goto L93
    L83:
        r0 = false;
        goto L85
    L62:
        r15 = 4194304;
        goto L63
    L64:
        r16 = r5;
        goto L66
    L5:
        if (r1.changedInstance(r27) == false) goto L7;
        int r7 = 4;
    L8:
        r5 = r7 | r41;
        goto L11
    L7:
        r7 = 2;
        goto L8
    }

    /* JADX INFO: renamed from: access$AnimatingChipContent-fe0OD_I, reason: not valid java name */
    public static final /* synthetic */ void m2419access$AnimatingChipContentfe0OD_I(Function2 r0, TextStyle r1, long r2, Function2 r4, Function2 r5, Function2 r6, long r7, long r9, float r11, PaddingValues r12, Composer r13, int r14) {
        m2415AnimatingChipContentfe0OD_I(r0, r1, r2, r4, r5, r6, r7, r9, r11, r12, r13, r14);
    }

    /* JADX INFO: renamed from: access$ChipContent-fe0OD_I, reason: not valid java name */
    public static final /* synthetic */ void m2420access$ChipContentfe0OD_I(Function2 r0, TextStyle r1, long r2, Function2 r4, Function2 r5, Function2 r6, long r7, long r9, float r11, PaddingValues r12, Composer r13, int r14) {
        m2417ChipContentfe0OD_I(r0, r1, r2, r4, r5, r6, r7, r9, r11, r12, r13, r14);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with ElevatedSuggestionChip that take a BorderStroke instead", replaceWith = @ReplaceWith(expression = "ElevatedSuggestionChip(onClick, label, modifier, enabled, icon, shape, colors, elevation, border, interactionSource", imports = {}))
    public static final /* synthetic */ void ElevatedSuggestionChip(final Function0 r32, final Function2 r33, Modifier r34, boolean r35, Function2 r36, Shape r37, ChipColors r38, ChipElevation r39, ChipBorder r40, MutableInteractionSource r41, Composer r42, final int r43, final int r44) {
        Composer r15 = r42.startRestartGroup(1306662363);
        if ((r44 & 1) == 0) goto L6;
        int r1 = r43 | 6;
    L14:
        if ((r44 & 2) == 0) goto L17;
        r1 = r1 | 48;
    L23:
        int r2 = r44 & 4;
        if (r2 == 0) goto L27;
        r1 = r1 | 384;
    L34:
        int r4 = r44 & 8;
        if (r4 == 0) goto L38;
        r1 = r1 | 3072;
    L45:
        int r6 = r44 & 16;
        if (r6 == 0) goto L49;
        r1 = r1 | 24576;
    L55:
        Function2 r7 = r36;
    L57:
        if ((196608 & r43) == 0) goto L59;
        Shape r8 = r37;
    L68:
        if ((1572864 & r43) == 0) goto L70;
        ChipColors r9 = r38;
    L79:
        if ((r43 & 12582912) != 0) goto L89;
        if ((r44 & 128) != 0) goto L86;
        if (r15.changed(r39) == false) goto L86;
        int r17 = 8388608;
    L87:
        r1 = r1 | r17;
    L86:
        r17 = 4194304;
    L89:
        int r0 = r44 & 256;
        if (r0 == 0) goto L93;
        r1 = r1 | 100663296;
    L99:
        int r10 = r44 & 512;
        if (r10 == 0) goto L103;
        r1 = r1 | 805306368;
    L110:
        boolean r19 = true;
        if ((r1 & 306783379) == 306783378) goto L113;
        boolean r3 = true;
    L115:
        if (r15.shouldExecute(r3, r1 & 1) == false) goto L175;
        r15.startDefaults();
        if ((r43 & 1) != 0) goto L119;
    L131:
        if (r2 == 0) goto L133;
        Modifier r23 = Modifier.Companion;
    L134:
        if (r4 != 0) goto L137;
        r19 = r35;
    L137:
        if (r6 == 0) goto L139;
        Function2 r24 = null;
    L141:
        if ((r44 & 32) == 0) goto L143;
        r1 = r1 & (-458753);
        Shape r21 = SuggestionChipDefaults.INSTANCE.getShape(r15, 6);
    L145:
        if ((r44 & 64) == 0) goto L147;
        int r26 = r1 & (-3670017);
        ChipColors r25 = SuggestionChipDefaults.INSTANCE.elevatedSuggestionChipColors(r15, 6);
    L149:
        if ((r44 & 128) == 0) goto L151;
        ChipElevation r5 = SuggestionChipDefaults.INSTANCE.m3206elevatedSuggestionChipElevationaqJV_2Y(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, r15, 1572864, 63);
        r26 = r26 & (-29360129);
    L152:
        if (r0 == 0) goto L154;
        ChipBorder r11 = null;
    L155:
        if (r10 == 0) goto L160;
        Object r12 = r15.rememberedValue();
        if (r12 != Composer.Companion.getEmpty()) goto L159;
        r12 = InteractionSourceKt.MutableInteractionSource();
        r15.updateRememberedValue(r12);
    L159:
        ChipBorder r13 = r11;
        MutableInteractionSource r14 = (MutableInteractionSource) r12;
        r8 = r21;
        Modifier r16 = r23;
        r7 = r24;
        r9 = r25;
        int r18 = r26;
        ChipElevation r20 = r5;
        boolean r22 = r19;
    L161:
        r15.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L164;
        ComposerKt.traceEventStart(1306662363, r18, -1, "androidx.compose.material3.ElevatedSuggestionChip (Chip.kt:980)");
    L164:
        TextStyle r110 = TypographyKt.getValue(SuggestionChipTokens.INSTANCE.getLabelTextFont(), r15, 6);
        long r111 = r9.m2406labelColorvNxB06k$material3(r22);
        float r27 = SuggestionChipDefaults.INSTANCE.m3207getHeightD9Ej5fM();
        PaddingValues r28 = SuggestionChipPadding;
        if (r13 != null) goto L167;
        r15.startReplaceGroup(1491294513);
        r15.endReplaceGroup();
        State<BorderStroke> r29 = null;
    L168:
        if (r29 == null) goto L170;
        BorderStroke r210 = (BorderStroke) r29.getValue();
    L171:
        int r112 = r18 << 6;
        int r30 = ((((((r18 >> 6) & 14) | 12582912) | ((r18 << 3) & 112)) | ((r18 >> 3) & 896)) | (r112 & 7168)) | (r112 & 3670016);
        int r113 = r18 << 9;
        int r31 = (((r18 >> 21) & 14) | 3456) | ((r18 >> 15) & 57344);
        Composer r45 = r15;
        m2416ChipnkUnTEs(r16, r32, r22, r33, r110, r111, r7, null, r8, r9, r20, r210, r27, r28, r14, r45, (r30 | (234881024 & r113)) | (r113 & 1879048192), r31);
        if (ComposerKt.isTraceInProgress() == false) goto L174;
        ComposerKt.traceEventEnd();
    L174:
        ChipBorder r114 = r13;
        MutableInteractionSource r115 = r14;
        final Shape r46 = r8;
        final Modifier r47 = r16;
        final boolean r48 = r22;
        final ChipElevation r49 = r20;
    L176:
        ScopeUpdateScope r116 = r45.endRestartGroup();
        if (r116 == null) goto L180;
        final Function2 r50 = r7;
        final ChipColors r51 = r9;
        final ChipBorder r52 = r114;
        final MutableInteractionSource r117 = r115;
        r116.updateScope(new n3(r32, r33, r47, r48, r50, r46, r51, r49, r52, r117, r43, r44));
        return;
    L180:
        return;
    L170:
        r210 = null;
        goto L171
    L167:
        r15.startReplaceGroup(1572126928);
        r29 = r13.borderStroke$material3(r22, r15, ((r18 >> 9) & 14) | ((r18 >> 21) & 112));
        r15.endReplaceGroup();
        goto L168
    L160:
        r14 = r41;
        r13 = r11;
        r20 = r5;
        r22 = r19;
        r8 = r21;
        r16 = r23;
        r7 = r24;
        r9 = r25;
        r18 = r26;
        goto L161
    L154:
        r11 = r40;
        goto L155
    L151:
        r5 = r39;
        goto L152
    L147:
        r26 = r1;
        r25 = r9;
        goto L149
    L143:
        r21 = r8;
        goto L145
    L139:
        r24 = r7;
        goto L141
    L133:
        r23 = r34;
        goto L134
    L119:
        if (r15.getDefaultsInvalid() == true) goto L131;
        r15.skipToGroupEnd();
        if ((r44 & 32) == 0) goto L125;
        r1 = r1 & (-458753);
    L125:
        if ((r44 & 64) == 0) goto L128;
        r1 = r1 & (-3670017);
    L128:
        if ((r44 & 128) == 0) goto L130;
        r1 = r1 & (-29360129);
    L130:
        r16 = r34;
        r20 = r39;
        r13 = r40;
        r14 = r41;
        r18 = r1;
        r22 = r35;
        goto L161
    L175:
        r45 = r15;
        r45.skipToGroupEnd();
        r47 = r34;
        r48 = r35;
        r114 = r40;
        r115 = r41;
        r46 = r8;
        r49 = r39;
        goto L176
    L113:
        r3 = false;
        goto L115
    L103:
        if ((r43 & 805306368) != 0) goto L110;
        if (r15.changed(r41) == false) goto L107;
        int r118 = 536870912;
    L108:
        r1 = r1 | r118;
        goto L110
    L107:
        r118 = 268435456;
        goto L108
    L93:
        if ((r43 & 100663296) != 0) goto L99;
        if (r15.changed(r40) == false) goto L97;
        int r119 = 67108864;
    L98:
        r1 = r1 | r119;
        goto L99
    L97:
        r119 = 33554432;
        goto L98
    L70:
        if ((r44 & 64) != 0) goto L74;
        r9 = r38;
        if (r15.changed(r9) == false) goto L75;
        int r120 = 1048576;
    L76:
        r1 = r1 | r120;
    L75:
        r120 = 524288;
        goto L76
    L74:
        r9 = r38;
        goto L75
    L59:
        if ((r44 & 32) != 0) goto L63;
        r8 = r37;
        if (r15.changed(r8) == false) goto L64;
        int r53 = 131072;
    L65:
        r1 = r1 | r53;
    L64:
        r53 = 65536;
        goto L65
    L63:
        r8 = r37;
        goto L64
    L49:
        if ((r43 & 24576) != 0) goto L55;
        r7 = r36;
        if (r15.changedInstance(r7) == false) goto L53;
        int r54 = 16384;
    L54:
        r1 = r1 | r54;
        goto L57
    L53:
        r54 = 8192;
        goto L54
    L38:
        if ((r43 & 3072) != 0) goto L45;
        if (r15.changed(r35) == false) goto L42;
        int r55 = 2048;
    L43:
        r1 = r1 | r55;
        goto L45
    L42:
        r55 = 1024;
        goto L43
    L27:
        if ((r43 & 384) != 0) goto L34;
        if (r15.changed(r34) == false) goto L31;
        int r56 = 256;
    L32:
        r1 = r1 | r56;
        goto L34
    L31:
        r56 = 128;
        goto L32
    L17:
        if ((r43 & 48) != 0) goto L23;
        if (r15.changedInstance(r33) == false) goto L21;
        int r57 = 32;
    L22:
        r1 = r1 | r57;
        goto L23
    L21:
        r57 = 16;
        goto L22
    L6:
        if ((r43 & 6) == 0) goto L8;
        r1 = r43;
        goto L14
    L8:
        if (r15.changedInstance(r32) == false) goto L10;
        int r58 = 4;
    L11:
        r1 = r58 | r43;
        goto L14
    L10:
        r58 = 2;
        goto L11
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with SuggestionChip that take a BorderStroke instead", replaceWith = @ReplaceWith(expression = "SuggestionChip(onClick, label, modifier, enabled, icon, shape, colors, elevation, border, interactionSource", imports = {}))
    public static final /* synthetic */ void SuggestionChip(final Function0 r32, final Function2 r33, Modifier r34, boolean r35, Function2 r36, Shape r37, ChipColors r38, ChipElevation r39, ChipBorder r40, MutableInteractionSource r41, Composer r42, final int r43, final int r44) {
        Composer r15 = r42.startRestartGroup(270460261);
        if ((r44 & 1) == 0) goto L6;
        int r1 = r43 | 6;
    L14:
        if ((r44 & 2) == 0) goto L17;
        r1 = r1 | 48;
    L23:
        int r2 = r44 & 4;
        if (r2 == 0) goto L27;
        r1 = r1 | 384;
    L34:
        int r4 = r44 & 8;
        if (r4 == 0) goto L38;
        r1 = r1 | 3072;
    L44:
        boolean r5 = r35;
    L45:
        int r6 = r44 & 16;
        if (r6 == 0) goto L49;
        r1 = r1 | 24576;
    L55:
        Function2 r7 = r36;
    L57:
        if ((196608 & r43) == 0) goto L59;
        Shape r8 = r37;
    L68:
        if ((1572864 & r43) == 0) goto L70;
        ChipColors r9 = r38;
    L79:
        if ((r43 & 12582912) != 0) goto L90;
        if ((r44 & 128) != 0) goto L86;
        if (r15.changed(r39) == false) goto L86;
        int r17 = 8388608;
    L87:
        r1 = r1 | r17;
    L86:
        r17 = 4194304;
    L90:
        if ((r43 & 100663296) != 0) goto L100;
        if ((r44 & 256) != 0) goto L97;
        if (r15.changed(r40) == false) goto L97;
        int r18 = 67108864;
    L98:
        r1 = r1 | r18;
    L97:
        r18 = 33554432;
    L100:
        int r10 = r44 & 512;
        if (r10 == 0) goto L104;
        r1 = r1 | 805306368;
    L111:
        boolean r19 = true;
        if ((r1 & 306783379) == 306783378) goto L114;
        boolean r0 = true;
    L116:
        if (r15.shouldExecute(r0, r1 & 1) == false) goto L181;
        r15.startDefaults();
        if ((r43 & 1) != 0) goto L120;
    L136:
        if (r2 == 0) goto L138;
        r34 = Modifier.Companion;
    L139:
        if (r4 != 0) goto L142;
        r19 = r5;
    L142:
        if (r6 == 0) goto L144;
        Function2 r24 = null;
    L146:
        if ((r44 & 32) == 0) goto L148;
        r1 = r1 & (-458753);
        Shape r22 = SuggestionChipDefaults.INSTANCE.getShape(r15, 6);
    L150:
        if ((r44 & 64) == 0) goto L152;
        int r26 = r1 & (-3670017);
        ChipColors r25 = SuggestionChipDefaults.INSTANCE.suggestionChipColors(r15, 6);
    L154:
        if ((r44 & 128) == 0) goto L156;
        r26 = r26 & (-29360129);
        ChipElevation r11 = SuggestionChipDefaults.INSTANCE.m3212suggestionChipElevationaqJV_2Y(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, r15, 1572864, 63);
    L158:
        if ((r44 & 256) == 0) goto L160;
        ChipBorder r3 = SuggestionChipDefaults.INSTANCE.m3209suggestionChipBorderd_3_b6Q(0, 0, MenuKt.ClosedAlphaTarget, r15, 3072, 7);
        r26 = r26 & (-234881025);
    L161:
        if (r10 == 0) goto L166;
        Object r12 = r15.rememberedValue();
        if (r12 != Composer.Companion.getEmpty()) goto L165;
        r12 = InteractionSourceKt.MutableInteractionSource();
        r15.updateRememberedValue(r12);
    L165:
        MutableInteractionSource r13 = (MutableInteractionSource) r12;
        r5 = r19;
        r8 = r22;
        r7 = r24;
        r9 = r25;
        int r14 = r26;
        ChipBorder r16 = r3;
    L135:
        Modifier r20 = r34;
        r15.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L170;
        ComposerKt.traceEventStart(270460261, r14, -1, "androidx.compose.material3.SuggestionChip (Chip.kt:828)");
    L170:
        TextStyle r110 = TypographyKt.getValue(SuggestionChipTokens.INSTANCE.getLabelTextFont(), r15, 6);
        long r111 = r9.m2406labelColorvNxB06k$material3(r5);
        if (r16 != null) goto L173;
        r15.startReplaceGroup(-75666041);
        r15.endReplaceGroup();
        State<BorderStroke> r21 = null;
    L174:
        if (r21 == null) goto L176;
        BorderStroke r27 = (BorderStroke) r21.getValue();
    L177:
        int r23 = r14 << 6;
        int r28 = ((((((r14 >> 6) & 14) | 12582912) | ((r14 << 3) & 112)) | ((r14 >> 3) & 896)) | (r23 & 7168)) | (r23 & 3670016);
        int r29 = r14 << 9;
        Composer r30 = r15;
        boolean r112 = r5;
        Function2 r210 = r7;
        Shape r211 = r8;
        ChipColors r212 = r9;
        ChipElevation r213 = r11;
        m2416ChipnkUnTEs(r20, r32, r112, r33, r110, r111, r210, null, r211, r212, r213, r27, SuggestionChipDefaults.INSTANCE.m3207getHeightD9Ej5fM(), SuggestionChipPadding, r13, r30, (r28 | (234881024 & r29)) | (r29 & 1879048192), (((r14 >> 21) & 14) | 3456) | ((r14 >> 15) & 57344));
        if (ComposerKt.isTraceInProgress() == false) goto L180;
        ComposerKt.traceEventEnd();
    L180:
        final boolean r31 = r5;
        final Function2 r45 = r7;
        final Shape r46 = r8;
        final ChipColors r47 = r9;
        final ChipElevation r48 = r11;
        final ChipBorder r49 = r16;
        final MutableInteractionSource r113 = r13;
        final Modifier r50 = r20;
    L182:
        ScopeUpdateScope r114 = r30.endRestartGroup();
        if (r114 == null) goto L186;
        r114.updateScope(new j3(r32, r33, r50, r31, r45, r46, r47, r48, r49, r113, r43, r44));
        return;
    L186:
        return;
    L176:
        r27 = null;
        goto L177
    L173:
        r15.startReplaceGroup(-2080650822);
        r21 = r16.borderStroke$material3(r5, r15, ((r14 >> 9) & 14) | ((r14 >> 21) & 112));
        r15.endReplaceGroup();
        goto L174
    L166:
        r13 = r41;
        r16 = r3;
        r5 = r19;
        r8 = r22;
        r7 = r24;
        r9 = r25;
        r14 = r26;
        goto L135
    L160:
        r3 = r40;
        goto L161
    L156:
        r11 = r39;
        goto L158
    L152:
        r26 = r1;
        r25 = r9;
        goto L154
    L148:
        r22 = r8;
        goto L150
    L144:
        r24 = r7;
        goto L146
    L138:
        r34 = r34;
        goto L139
    L120:
        if (r15.getDefaultsInvalid() == true) goto L136;
        r15.skipToGroupEnd();
        if ((r44 & 32) == 0) goto L126;
        r1 = r1 & (-458753);
    L126:
        if ((r44 & 64) == 0) goto L129;
        r1 = r1 & (-3670017);
    L129:
        if ((r44 & 128) == 0) goto L132;
        r1 = r1 & (-29360129);
    L132:
        if ((r44 & 256) == 0) goto L134;
        r1 = r1 & (-234881025);
    L134:
        r11 = r39;
        r16 = r40;
        r13 = r41;
        r14 = r1;
        goto L135
    L181:
        r30 = r15;
        r30.skipToGroupEnd();
        r50 = r34;
        r113 = r41;
        r31 = r5;
        r45 = r7;
        r46 = r8;
        r47 = r9;
        r48 = r39;
        r49 = r40;
        goto L182
    L114:
        r0 = false;
        goto L116
    L104:
        if ((r43 & 805306368) != 0) goto L111;
        if (r15.changed(r41) == false) goto L108;
        int r115 = 536870912;
    L109:
        r1 = r1 | r115;
        goto L111
    L108:
        r115 = 268435456;
        goto L109
    L70:
        if ((r44 & 64) != 0) goto L74;
        r9 = r38;
        if (r15.changed(r9) == false) goto L75;
        int r116 = 1048576;
    L76:
        r1 = r1 | r116;
    L75:
        r116 = 524288;
        goto L76
    L74:
        r9 = r38;
        goto L75
    L59:
        if ((r44 & 32) != 0) goto L63;
        r8 = r37;
        if (r15.changed(r8) == false) goto L64;
        int r51 = 131072;
    L65:
        r1 = r1 | r51;
    L64:
        r51 = 65536;
        goto L65
    L63:
        r8 = r37;
        goto L64
    L49:
        if ((r43 & 24576) != 0) goto L55;
        r7 = r36;
        if (r15.changedInstance(r7) == false) goto L53;
        int r52 = 16384;
    L54:
        r1 = r1 | r52;
        goto L57
    L53:
        r52 = 8192;
        goto L54
    L38:
        if ((r43 & 3072) != 0) goto L44;
        r5 = r35;
        if (r15.changed(r5) == false) goto L42;
        int r53 = 2048;
    L43:
        r1 = r1 | r53;
        goto L45
    L42:
        r53 = 1024;
        goto L43
    L27:
        if ((r43 & 384) != 0) goto L34;
        if (r15.changed(r34) == false) goto L31;
        int r54 = 256;
    L32:
        r1 = r1 | r54;
        goto L34
    L31:
        r54 = 128;
        goto L32
    L17:
        if ((r43 & 48) != 0) goto L23;
        if (r15.changedInstance(r33) == false) goto L21;
        int r55 = 32;
    L22:
        r1 = r1 | r55;
        goto L23
    L21:
        r55 = 16;
        goto L22
    L6:
        if ((r43 & 6) == 0) goto L8;
        r1 = r43;
        goto L14
    L8:
        if (r15.changedInstance(r32) == false) goto L10;
        int r56 = 4;
    L11:
        r1 = r56 | r43;
        goto L14
    L10:
        r56 = 2;
        goto L11
    }

    public static final void ElevatedSuggestionChip(final Function0<Unit> r32, final Function2<? super Composer, ? super Integer, Unit> r33, Modifier r34, boolean r35, Function2<? super Composer, ? super Integer, Unit> r36, Shape r37, ChipColors r38, ChipElevation r39, BorderStroke r40, MutableInteractionSource r41, Composer r42, final int r43, final int r44) {
        Composer r15 = r42.startRestartGroup(-894435833);
        if ((r44 & 1) == 0) goto L6;
        int r1 = r43 | 6;
    L14:
        if ((r44 & 2) == 0) goto L17;
        r1 = r1 | 48;
    L23:
        int r2 = r44 & 4;
        if (r2 == 0) goto L27;
        r1 = r1 | 384;
    L34:
        int r4 = r44 & 8;
        if (r4 == 0) goto L38;
        r1 = r1 | 3072;
    L45:
        int r6 = r44 & 16;
        if (r6 == 0) goto L49;
        r1 = r1 | 24576;
    L55:
        Function2<? super Composer, ? super Integer, Unit> r7 = r36;
    L57:
        if ((196608 & r43) == 0) goto L59;
        Shape r8 = r37;
    L68:
        if ((1572864 & r43) == 0) goto L70;
        ChipColors r9 = r38;
    L79:
        if ((r43 & 12582912) != 0) goto L89;
        if ((r44 & 128) != 0) goto L86;
        if (r15.changed(r39) == false) goto L86;
        int r17 = 8388608;
    L87:
        r1 = r1 | r17;
    L86:
        r17 = 4194304;
    L89:
        int r0 = r44 & 256;
        if (r0 == 0) goto L93;
        r1 = r1 | 100663296;
    L99:
        int r10 = r44 & 512;
        if (r10 == 0) goto L103;
        r1 = r1 | 805306368;
    L110:
        boolean r19 = true;
        if ((r1 & 306783379) == 306783378) goto L113;
        boolean r3 = true;
    L115:
        if (r15.shouldExecute(r3, r1 & 1) == false) goto L167;
        r15.startDefaults();
        if ((r43 & 1) != 0) goto L119;
    L131:
        if (r2 == 0) goto L133;
        Modifier r22 = Modifier.Companion;
    L134:
        if (r4 != 0) goto L138;
        r19 = r35;
    L138:
        if (r6 == 0) goto L140;
        Function2<? super Composer, ? super Integer, Unit> r24 = null;
    L142:
        if ((r44 & 32) == 0) goto L144;
        r1 = r1 & (-458753);
        r8 = SuggestionChipDefaults.INSTANCE.getShape(r15, 6);
    L146:
        if ((r44 & 64) == 0) goto L148;
        int r26 = r1 & (-3670017);
        ChipColors r25 = SuggestionChipDefaults.INSTANCE.elevatedSuggestionChipColors(r15, 6);
    L150:
        if ((r44 & 128) == 0) goto L152;
        ChipElevation r5 = SuggestionChipDefaults.INSTANCE.m3206elevatedSuggestionChipElevationaqJV_2Y(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, r15, 1572864, 63);
        r26 = r26 & (-29360129);
    L153:
        if (r0 == 0) goto L155;
        BorderStroke r11 = null;
    L156:
        if (r10 == 0) goto L158;
        MutableInteractionSource r12 = null;
    L159:
        r7 = r24;
        r9 = r25;
        int r13 = r26;
    L160:
        r15.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L163;
        ComposerKt.traceEventStart(-894435833, r13, -1, "androidx.compose.material3.ElevatedSuggestionChip (Chip.kt:899)");
    L163:
        int r14 = r13 << 6;
        int r16 = ((((((r13 >> 6) & 14) | 12582912) | ((r13 << 3) & 112)) | ((r13 >> 3) & 896)) | (r14 & 7168)) | (r14 & 3670016);
        int r18 = r13 << 9;
        int r30 = (r16 | (234881024 & r18)) | (r18 & 1879048192);
        int r20 = r13 >> 21;
        int r31 = ((r20 & 112) | ((r20 & 14) | 3456)) | ((r13 >> 15) & 57344);
        Composer r21 = r15;
        m2416ChipnkUnTEs(r22, r32, r19, r33, TypographyKt.getValue(SuggestionChipTokens.INSTANCE.getLabelTextFont(), r15, 6), r9.m2406labelColorvNxB06k$material3(r19), r7, null, r8, r9, r5, r11, SuggestionChipDefaults.INSTANCE.m3207getHeightD9Ej5fM(), SuggestionChipPadding, r12, r21, r30, r31);
        if (ComposerKt.isTraceInProgress() == false) goto L166;
        ComposerKt.traceEventEnd();
    L166:
        BorderStroke r110 = r11;
        MutableInteractionSource r111 = r12;
        final Shape r23 = r8;
        final Modifier r27 = r22;
        final boolean r28 = r19;
        final ChipElevation r29 = r5;
    L168:
        ScopeUpdateScope r112 = r21.endRestartGroup();
        if (r112 == null) goto L172;
        final Function2<? super Composer, ? super Integer, Unit> r45 = r7;
        final ChipColors r46 = r9;
        final BorderStroke r47 = r110;
        final MutableInteractionSource r113 = r111;
        r112.updateScope(new s3(r32, r33, r27, r28, r45, r23, r46, r29, r47, r113, r43, r44));
        return;
    L172:
        return;
    L158:
        r12 = r41;
        goto L159
    L155:
        r11 = r40;
        goto L156
    L152:
        r5 = r39;
        goto L153
    L148:
        r26 = r1;
        r25 = r9;
        goto L150
    L144:
        r8 = r8;
        goto L146
    L140:
        r24 = r7;
        goto L142
    L133:
        r22 = r34;
        goto L134
    L119:
        if (r15.getDefaultsInvalid() == true) goto L131;
        r15.skipToGroupEnd();
        if ((r44 & 32) == 0) goto L125;
        r1 = r1 & (-458753);
    L125:
        if ((r44 & 64) == 0) goto L128;
        r1 = r1 & (-3670017);
    L128:
        if ((r44 & 128) == 0) goto L130;
        r1 = r1 & (-29360129);
    L130:
        r22 = r34;
        r5 = r39;
        r11 = r40;
        r12 = r41;
        r13 = r1;
        r19 = r35;
        goto L160
    L167:
        r21 = r15;
        r21.skipToGroupEnd();
        r27 = r34;
        r28 = r35;
        r110 = r40;
        r111 = r41;
        r23 = r8;
        r29 = r39;
        goto L168
    L113:
        r3 = false;
        goto L115
    L103:
        if ((r43 & 805306368) != 0) goto L110;
        if (r15.changed(r41) == false) goto L107;
        int r114 = 536870912;
    L108:
        r1 = r1 | r114;
        goto L110
    L107:
        r114 = 268435456;
        goto L108
    L93:
        if ((r43 & 100663296) != 0) goto L99;
        if (r15.changed(r40) == false) goto L97;
        int r115 = 67108864;
    L98:
        r1 = r1 | r115;
        goto L99
    L97:
        r115 = 33554432;
        goto L98
    L70:
        if ((r44 & 64) != 0) goto L74;
        r9 = r38;
        if (r15.changed(r9) == false) goto L75;
        int r116 = 1048576;
    L76:
        r1 = r1 | r116;
    L75:
        r116 = 524288;
        goto L76
    L74:
        r9 = r38;
        goto L75
    L59:
        if ((r44 & 32) != 0) goto L63;
        r8 = r37;
        if (r15.changed(r8) == false) goto L64;
        int r48 = 131072;
    L65:
        r1 = r1 | r48;
    L64:
        r48 = 65536;
        goto L65
    L63:
        r8 = r37;
        goto L64
    L49:
        if ((r43 & 24576) != 0) goto L55;
        r7 = r36;
        if (r15.changedInstance(r7) == false) goto L53;
        int r49 = 16384;
    L54:
        r1 = r1 | r49;
        goto L57
    L53:
        r49 = 8192;
        goto L54
    L38:
        if ((r43 & 3072) != 0) goto L45;
        if (r15.changed(r35) == false) goto L42;
        int r50 = 2048;
    L43:
        r1 = r1 | r50;
        goto L45
    L42:
        r50 = 1024;
        goto L43
    L27:
        if ((r43 & 384) != 0) goto L34;
        if (r15.changed(r34) == false) goto L31;
        int r51 = 256;
    L32:
        r1 = r1 | r51;
        goto L34
    L31:
        r51 = 128;
        goto L32
    L17:
        if ((r43 & 48) != 0) goto L23;
        if (r15.changedInstance(r33) == false) goto L21;
        int r52 = 32;
    L22:
        r1 = r1 | r52;
        goto L23
    L21:
        r52 = 16;
        goto L22
    L6:
        if ((r43 & 6) == 0) goto L8;
        r1 = r43;
        goto L14
    L8:
        if (r15.changedInstance(r32) == false) goto L10;
        int r53 = 4;
    L11:
        r1 = r53 | r43;
        goto L14
    L10:
        r53 = 2;
        goto L11
    }

    public static final void SuggestionChip(final Function0<Unit> r32, final Function2<? super Composer, ? super Integer, Unit> r33, Modifier r34, boolean r35, Function2<? super Composer, ? super Integer, Unit> r36, Shape r37, ChipColors r38, ChipElevation r39, BorderStroke r40, MutableInteractionSource r41, Composer r42, final int r43, final int r44) {
        Composer r15 = r42.startRestartGroup(-252243183);
        if ((r44 & 1) == 0) goto L6;
        int r1 = r43 | 6;
    L14:
        if ((r44 & 2) == 0) goto L17;
        r1 = r1 | 48;
    L23:
        int r2 = r44 & 4;
        if (r2 == 0) goto L27;
        r1 = r1 | 384;
    L34:
        int r4 = r44 & 8;
        if (r4 == 0) goto L38;
        r1 = r1 | 3072;
    L44:
        boolean r5 = r35;
    L45:
        int r6 = r44 & 16;
        if (r6 == 0) goto L49;
        r1 = r1 | 24576;
    L55:
        Function2<? super Composer, ? super Integer, Unit> r7 = r36;
    L57:
        if ((196608 & r43) == 0) goto L59;
        Shape r8 = r37;
    L68:
        if ((1572864 & r43) == 0) goto L70;
        ChipColors r9 = r38;
    L79:
        if ((r43 & 12582912) != 0) goto L90;
        if ((r44 & 128) != 0) goto L86;
        if (r15.changed(r39) == false) goto L86;
        int r17 = 8388608;
    L87:
        r1 = r1 | r17;
    L86:
        r17 = 4194304;
    L90:
        if ((r43 & 100663296) != 0) goto L100;
        if ((r44 & 256) != 0) goto L97;
        if (r15.changed(r40) == false) goto L97;
        int r18 = 67108864;
    L98:
        r1 = r1 | r18;
    L97:
        r18 = 33554432;
    L100:
        int r10 = r44 & 512;
        if (r10 == 0) goto L104;
        r1 = r1 | 805306368;
    L111:
        r5 = true;
        if ((r1 & 306783379) == 306783378) goto L114;
        boolean r0 = true;
    L116:
        if (r15.shouldExecute(r0, r1 & 1) == false) goto L173;
        r15.startDefaults();
        if ((r43 & 1) != 0) goto L120;
    L136:
        if (r2 == 0) goto L138;
        r34 = Modifier.Companion;
    L139:
        if (r4 != 0) goto L143;
        r5 = r5;
    L143:
        if (r6 == 0) goto L145;
        Function2<? super Composer, ? super Integer, Unit> r24 = null;
    L147:
        if ((r44 & 32) == 0) goto L149;
        r1 = r1 & (-458753);
        r8 = SuggestionChipDefaults.INSTANCE.getShape(r15, 6);
    L151:
        if ((r44 & 64) == 0) goto L153;
        int r26 = r1 & (-3670017);
        ChipColors r25 = SuggestionChipDefaults.INSTANCE.suggestionChipColors(r15, 6);
    L155:
        if ((r44 & 128) == 0) goto L157;
        r26 = r26 & (-29360129);
        ChipElevation r21 = SuggestionChipDefaults.INSTANCE.m3212suggestionChipElevationaqJV_2Y(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, r15, 1572864, 63);
    L159:
        if ((r44 & 256) == 0) goto L161;
        BorderStroke r3 = SuggestionChipDefaults.INSTANCE.m3210suggestionChipBorderh1eTWw(r5, 0, 0, MenuKt.ClosedAlphaTarget, r15, ((r26 >> 9) & 14) | 24576, 14);
        r26 = r26 & (-234881025);
    L162:
        if (r10 == 0) goto L164;
        MutableInteractionSource r11 = null;
    L165:
        r7 = r24;
        r9 = r25;
        int r12 = r26;
    L135:
        Modifier r13 = r34;
        r15.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L169;
        ComposerKt.traceEventStart(-252243183, r12, -1, "androidx.compose.material3.SuggestionChip (Chip.kt:746)");
    L169:
        int r14 = r12 << 6;
        int r16 = ((((((r12 >> 6) & 14) | 12582912) | ((r12 << 3) & 112)) | ((r12 >> 3) & 896)) | (r14 & 7168)) | (r14 & 3670016);
        int r19 = r12 << 9;
        int r30 = (r16 | (234881024 & r19)) | (r19 & 1879048192);
        int r20 = r12 >> 21;
        int r31 = ((r20 & 112) | ((r20 & 14) | 3456)) | ((r12 >> 15) & 57344);
        Composer r22 = r15;
        m2416ChipnkUnTEs(r13, r32, r5, r33, TypographyKt.getValue(SuggestionChipTokens.INSTANCE.getLabelTextFont(), r15, 6), r9.m2406labelColorvNxB06k$material3(r5), r7, null, r8, r9, r21, r3, SuggestionChipDefaults.INSTANCE.m3207getHeightD9Ej5fM(), SuggestionChipPadding, r11, r22, r30, r31);
        if (ComposerKt.isTraceInProgress() == false) goto L172;
        ComposerKt.traceEventEnd();
    L172:
        final MutableInteractionSource r110 = r11;
        final boolean r23 = r5;
        final Function2<? super Composer, ? super Integer, Unit> r27 = r7;
        final Shape r28 = r8;
        final ChipColors r29 = r9;
        final ChipElevation r45 = r21;
        final BorderStroke r46 = r3;
        final Modifier r47 = r13;
    L174:
        ScopeUpdateScope r111 = r22.endRestartGroup();
        if (r111 == null) goto L178;
        r111.updateScope(new i3(r32, r33, r47, r23, r27, r28, r29, r45, r46, r110, r43, r44));
        return;
    L178:
        return;
    L164:
        r11 = r41;
        goto L165
    L161:
        r3 = r40;
        goto L162
    L157:
        r21 = r39;
        goto L159
    L153:
        r26 = r1;
        r25 = r9;
        goto L155
    L149:
        r8 = r8;
        goto L151
    L145:
        r24 = r7;
        goto L147
    L138:
        r34 = r34;
        goto L139
    L120:
        if (r15.getDefaultsInvalid() == true) goto L136;
        r15.skipToGroupEnd();
        if ((r44 & 32) == 0) goto L126;
        r1 = r1 & (-458753);
    L126:
        if ((r44 & 64) == 0) goto L129;
        r1 = r1 & (-3670017);
    L129:
        if ((r44 & 128) == 0) goto L132;
        r1 = r1 & (-29360129);
    L132:
        if ((r44 & 256) == 0) goto L134;
        r1 = r1 & (-234881025);
    L134:
        r21 = r39;
        r3 = r40;
        r11 = r41;
        r12 = r1;
        goto L135
    L173:
        r22 = r15;
        r22.skipToGroupEnd();
        r47 = r34;
        r110 = r41;
        r23 = r5;
        r27 = r7;
        r28 = r8;
        r29 = r9;
        r45 = r39;
        r46 = r40;
        goto L174
    L114:
        r0 = false;
        goto L116
    L104:
        if ((r43 & 805306368) != 0) goto L111;
        if (r15.changed(r41) == false) goto L108;
        int r112 = 536870912;
    L109:
        r1 = r1 | r112;
        goto L111
    L108:
        r112 = 268435456;
        goto L109
    L70:
        if ((r44 & 64) != 0) goto L74;
        r9 = r38;
        if (r15.changed(r9) == false) goto L75;
        int r113 = 1048576;
    L76:
        r1 = r1 | r113;
    L75:
        r113 = 524288;
        goto L76
    L74:
        r9 = r38;
        goto L75
    L59:
        if ((r44 & 32) != 0) goto L63;
        r8 = r37;
        if (r15.changed(r8) == false) goto L64;
        int r48 = 131072;
    L65:
        r1 = r1 | r48;
    L64:
        r48 = 65536;
        goto L65
    L63:
        r8 = r37;
        goto L64
    L49:
        if ((r43 & 24576) != 0) goto L55;
        r7 = r36;
        if (r15.changedInstance(r7) == false) goto L53;
        int r49 = 16384;
    L54:
        r1 = r1 | r49;
        goto L57
    L53:
        r49 = 8192;
        goto L54
    L38:
        if ((r43 & 3072) != 0) goto L44;
        r5 = r35;
        if (r15.changed(r5) == false) goto L42;
        int r50 = 2048;
    L43:
        r1 = r1 | r50;
        goto L45
    L42:
        r50 = 1024;
        goto L43
    L27:
        if ((r43 & 384) != 0) goto L34;
        if (r15.changed(r34) == false) goto L31;
        int r51 = 256;
    L32:
        r1 = r1 | r51;
        goto L34
    L31:
        r51 = 128;
        goto L32
    L17:
        if ((r43 & 48) != 0) goto L23;
        if (r15.changedInstance(r33) == false) goto L21;
        int r52 = 32;
    L22:
        r1 = r1 | r52;
        goto L23
    L21:
        r52 = 16;
        goto L22
    L6:
        if ((r43 & 6) == 0) goto L8;
        r1 = r43;
        goto L14
    L8:
        if (r15.changedInstance(r32) == false) goto L10;
        int r53 = 4;
    L11:
        r1 = r53 | r43;
        goto L14
    L10:
        r53 = 2;
        goto L11
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with AssistChip that take a BorderStroke instead", replaceWith = @ReplaceWith(expression = "AssistChip(onClick, label, modifier, enabled,leadingIcon, trailingIcon, shape, colors, elevation, border, interactionSource", imports = {}))
    public static final /* synthetic */ void AssistChip(final Function0 r37, final Function2 r38, Modifier r39, boolean r40, Function2 r41, Function2 r42, Shape r43, ChipColors r44, ChipElevation r45, ChipBorder r46, MutableInteractionSource r47, Composer r48, final int r49, final int r50, final int r51) {
        Composer r11 = r48.startRestartGroup(1930061919);
        if ((r51 & 1) == 0) goto L6;
        int r1 = r49 | 6;
    L14:
        if ((r51 & 2) == 0) goto L17;
        r1 = r1 | 48;
    L23:
        int r4 = r51 & 4;
        if (r4 == 0) goto L27;
        r1 = r1 | 384;
    L33:
        Modifier r5 = r39;
    L34:
        int r6 = r51 & 8;
        if (r6 == 0) goto L38;
        r1 = r1 | 3072;
    L44:
        boolean r7 = r40;
    L45:
        int r8 = r51 & 16;
        if (r8 == 0) goto L49;
        r1 = r1 | 24576;
    L56:
        int r10 = r51 & 32;
        if (r10 == 0) goto L60;
        r1 = r1 | 196608;
    L67:
        if ((r49 & 1572864) != 0) goto L77;
        if ((r51 & 64) == 0) goto L71;
    L73:
        int r17 = 524288;
    L74:
        r1 = r1 | r17;
        goto L77
    L71:
        if (r11.changed(r43) == false) goto L73;
        r17 = 1048576;
    L77:
        if ((r49 & 12582912) == 0) goto L79;
        ChipColors r3 = r44;
    L88:
        if ((r49 & 100663296) != 0) goto L99;
        if ((r51 & 256) != 0) goto L95;
        if (r11.changed(r45) == false) goto L95;
        int r18 = 67108864;
    L96:
        r1 = r1 | r18;
    L95:
        r18 = 33554432;
    L99:
        if ((r49 & 805306368) != 0) goto L109;
        if ((r51 & 512) != 0) goto L106;
        if (r11.changed(r46) == false) goto L106;
        int r19 = 536870912;
    L107:
        r1 = r1 | r19;
    L106:
        r19 = 268435456;
    L109:
        int r9 = r51 & 1024;
        if (r9 == 0) goto L113;
        int r12 = r50 | 6;
    L120:
        boolean r110 = true;
        if ((r1 & 306783379) == 306783378) goto L123;
    L126:
        boolean r0 = true;
    L128:
        if (r11.shouldExecute(r0, r1 & 1) == false) goto L196;
        r11.startDefaults();
        int r410 = r12;
        if ((r49 & 1) != 0) goto L132;
    L147:
        if (r4 == 0) goto L149;
        r5 = Modifier.Companion;
    L150:
        if (r6 != 0) goto L153;
        r110 = r7;
    L153:
        if (r8 == 0) goto L155;
        Function2 r21 = null;
    L156:
        if (r10 == 0) goto L158;
        Function2 r22 = null;
    L160:
        if ((r51 & 64) == 0) goto L162;
        r1 = r1 & (-3670017);
        Shape r111 = AssistChipDefaults.INSTANCE.getShape(r11, 6);
    L164:
        if ((r51 & 128) == 0) goto L166;
        r3 = AssistChipDefaults.INSTANCE.assistChipColors(r11, 6);
        r1 = r1 & (-29360129);
    L166:
        int r24 = r1;
        ChipColors r23 = r3;
        if ((r51 & 256) == 0) goto L169;
        r24 = r24 & (-234881025);
        ChipElevation r13 = AssistChipDefaults.INSTANCE.m2323assistChipElevationaqJV_2Y(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, r11, 1572864, 63);
    L171:
        if ((r51 & 512) == 0) goto L173;
        ChipBorder r2 = AssistChipDefaults.INSTANCE.m2320assistChipBorderd_3_b6Q(0, 0, MenuKt.ClosedAlphaTarget, r11, 3072, 7);
        int r14 = r24 & (-1879048193);
    L174:
        if (r9 == 0) goto L179;
        Object r15 = r11.rememberedValue();
        if (r15 != Composer.Companion.getEmpty()) goto L178;
        r15 = InteractionSourceKt.MutableInteractionSource();
        r11.updateRememberedValue(r15);
    L178:
        MutableInteractionSource r16 = (MutableInteractionSource) r15;
    L180:
        Shape r20 = r111;
        r7 = r110;
        Function2 r25 = r21;
        Function2 r26 = r22;
        r3 = r23;
    L181:
        r11.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L184;
        int r112 = r410;
        ComposerKt.traceEventStart(1930061919, r14, r112, "androidx.compose.material3.AssistChip (Chip.kt:231)");
    L185:
        TextStyle r113 = TypographyKt.getValue(AssistChipTokens.INSTANCE.getLabelTextFont(), r11, 6);
        long r27 = r3.m2406labelColorvNxB06k$material3(r7);
        if (r2 != null) goto L188;
        r11.startReplaceGroup(1748832781);
        r11.endReplaceGroup();
        State<BorderStroke> r28 = null;
    L189:
        if (r28 == null) goto L191;
        BorderStroke r29 = (BorderStroke) r28.getValue();
    L192:
        int r114 = r14 << 6;
        ChipBorder r310 = r2;
        Modifier r115 = r5;
        boolean r116 = r7;
        Function2 r210 = r25;
        Function2 r211 = r26;
        Shape r212 = r20;
        ChipColors r213 = r3;
        ChipElevation r214 = r13;
        MutableInteractionSource r30 = r16;
        m2416ChipnkUnTEs(r115, r37, r116, r38, r113, r27, r210, r211, r212, r213, r214, r29, AssistChipDefaults.INSTANCE.m2326getHeightD9Ej5fM(), AssistChipPadding, r30, r11, (((((r114 & 7168) | ((((r14 >> 6) & 14) | ((r14 << 3) & 112)) | ((r14 >> 3) & 896))) | (3670016 & r114)) | (29360128 & r114)) | (234881024 & r114)) | (1879048192 & r114), (((r14 >> 24) & 14) | 3456) | ((r112 << 12) & 57344));
        if (ComposerKt.isTraceInProgress() == false) goto L195;
        ComposerKt.traceEventEnd();
    L195:
        final ChipColors r31 = r3;
        final Modifier r32 = r5;
        MutableInteractionSource r117 = r16;
        final boolean r33 = r7;
        final ChipElevation r34 = r13;
        final ChipBorder r118 = r310;
        final Function2 r35 = r25;
        final Function2 r36 = r26;
        final Shape r52 = r20;
    L197:
        ScopeUpdateScope r119 = r11.endRestartGroup();
        if (r119 == null) goto L201;
        final MutableInteractionSource r120 = r117;
        r119.updateScope(new p3(r37, r38, r32, r33, r35, r36, r52, r31, r34, r118, r120, r49, r50, r51));
        return;
    L201:
        return;
    L191:
        r29 = null;
        goto L192
    L188:
        r11.startReplaceGroup(-636322700);
        r28 = r2.borderStroke$material3(r7, r11, ((r14 >> 9) & 14) | ((r14 >> 24) & 112));
        r11.endReplaceGroup();
        goto L189
    L184:
        r112 = r410;
        goto L185
    L179:
        r16 = r47;
        goto L180
    L173:
        r2 = r46;
        r14 = r24;
        goto L174
    L169:
        r13 = r45;
        goto L171
    L162:
        r111 = r43;
        goto L164
    L158:
        r22 = r42;
        goto L160
    L155:
        r21 = r41;
        goto L156
    L149:
        r5 = r5;
        goto L150
    L132:
        if (r11.getDefaultsInvalid() == true) goto L147;
        r11.skipToGroupEnd();
        if ((r51 & 64) == 0) goto L138;
        r1 = r1 & (-3670017);
    L138:
        if ((r51 & 128) == 0) goto L141;
        r1 = r1 & (-29360129);
    L141:
        if ((r51 & 256) == 0) goto L144;
        r1 = r1 & (-234881025);
    L144:
        if ((r51 & 512) == 0) goto L146;
        r1 = r1 & (-1879048193);
    L146:
        r25 = r41;
        r20 = r43;
        r13 = r45;
        r2 = r46;
        r16 = r47;
        r410 = r410;
        r14 = r1;
        r26 = r42;
        goto L181
    L196:
        r11.skipToGroupEnd();
        r36 = r42;
        r34 = r45;
        r118 = r46;
        r117 = r47;
        r31 = r3;
        r32 = r5;
        r33 = r7;
        r35 = r41;
        r52 = r43;
        goto L197
    L123:
        if ((r12 & 3) != 2) goto L126;
        r0 = false;
        goto L128
    L113:
        if ((r50 & 6) == 0) goto L115;
        r12 = r50;
        goto L120
    L115:
        if (r11.changed(r47) == false) goto L117;
        int r121 = 4;
    L118:
        r12 = r50 | r121;
        goto L120
    L117:
        r121 = 2;
        goto L118
    L79:
        if ((r51 & 128) != 0) goto L83;
        r3 = r44;
        if (r11.changed(r3) == false) goto L84;
        int r122 = 8388608;
    L85:
        r1 = r1 | r122;
    L84:
        r122 = 4194304;
        goto L85
    L83:
        r3 = r44;
        goto L84
    L60:
        if ((r49 & 196608) != 0) goto L67;
        if (r11.changedInstance(r42) == false) goto L64;
        int r123 = 131072;
    L65:
        r1 = r1 | r123;
        goto L67
    L64:
        r123 = 65536;
        goto L65
    L49:
        if ((r49 & 24576) != 0) goto L56;
        if (r11.changedInstance(r41) == false) goto L53;
        int r124 = 16384;
    L54:
        r1 = r1 | r124;
        goto L56
    L53:
        r124 = 8192;
        goto L54
    L38:
        if ((r49 & 3072) != 0) goto L44;
        r7 = r40;
        if (r11.changed(r7) == false) goto L42;
        int r53 = 2048;
    L43:
        r1 = r1 | r53;
        goto L45
    L42:
        r53 = 1024;
        goto L43
    L27:
        if ((r49 & 384) != 0) goto L33;
        r5 = r39;
        if (r11.changed(r5) == false) goto L31;
        int r54 = 256;
    L32:
        r1 = r1 | r54;
        goto L34
    L31:
        r54 = 128;
        goto L32
    L17:
        if ((r49 & 48) != 0) goto L23;
        if (r11.changedInstance(r38) == false) goto L21;
        int r55 = 32;
    L22:
        r1 = r1 | r55;
        goto L23
    L21:
        r55 = 16;
        goto L22
    L6:
        if ((r49 & 6) == 0) goto L8;
        r1 = r49;
        goto L14
    L8:
        if (r11.changedInstance(r37) == false) goto L10;
        int r56 = 4;
    L11:
        r1 = r56 | r49;
        goto L14
    L10:
        r56 = 2;
        goto L11
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with ElevatedAssistChip that take a BorderStroke instead", replaceWith = @ReplaceWith(expression = "ElevatedAssistChip(onClick, label, modifier, enabled,leadingIcon, trailingIcon, shape, colors, elevation, border, interactionSource", imports = {}))
    public static final /* synthetic */ void ElevatedAssistChip(final Function0 r37, final Function2 r38, Modifier r39, boolean r40, Function2 r41, Function2 r42, Shape r43, ChipColors r44, ChipElevation r45, ChipBorder r46, MutableInteractionSource r47, Composer r48, final int r49, final int r50, final int r51) {
        Composer r11 = r48.startRestartGroup(-759567147);
        if ((r51 & 1) == 0) goto L6;
        int r1 = r49 | 6;
    L14:
        if ((r51 & 2) == 0) goto L17;
        r1 = r1 | 48;
    L23:
        int r4 = r51 & 4;
        if (r4 == 0) goto L27;
        r1 = r1 | 384;
    L33:
        Modifier r5 = r39;
    L34:
        int r6 = r51 & 8;
        if (r6 == 0) goto L38;
        r1 = r1 | 3072;
    L44:
        boolean r7 = r40;
    L45:
        int r8 = r51 & 16;
        if (r8 == 0) goto L49;
        r1 = r1 | 24576;
    L56:
        int r10 = r51 & 32;
        if (r10 == 0) goto L60;
        r1 = r1 | 196608;
    L67:
        if ((r49 & 1572864) != 0) goto L77;
        if ((r51 & 64) == 0) goto L71;
    L73:
        int r17 = 524288;
    L74:
        r1 = r1 | r17;
        goto L77
    L71:
        if (r11.changed(r43) == false) goto L73;
        r17 = 1048576;
    L77:
        if ((r49 & 12582912) == 0) goto L79;
        ChipColors r3 = r44;
    L88:
        if ((r49 & 100663296) != 0) goto L98;
        if ((r51 & 256) != 0) goto L95;
        if (r11.changed(r45) == false) goto L95;
        int r18 = 67108864;
    L96:
        r1 = r1 | r18;
    L95:
        r18 = 33554432;
    L98:
        int r9 = r51 & 512;
        if (r9 == 0) goto L102;
        r1 = r1 | 805306368;
    L109:
        int r12 = r51 & 1024;
        if (r12 == 0) goto L113;
        int r13 = r50 | 6;
    L120:
        boolean r20 = true;
        if ((r1 & 306783379) == 306783378) goto L123;
    L126:
        boolean r0 = true;
    L128:
        if (r11.shouldExecute(r0, r1 & 1) == false) goto L191;
        r11.startDefaults();
        int r410 = r13;
        if ((r49 & 1) != 0) goto L132;
    L144:
        if (r4 == 0) goto L146;
        Modifier r2 = Modifier.Companion;
    L147:
        if (r6 != 0) goto L150;
        r20 = r7;
    L150:
        if (r8 == 0) goto L152;
        Function2 r22 = null;
    L153:
        if (r10 == 0) goto L155;
        Function2 r23 = null;
    L157:
        if ((r51 & 64) == 0) goto L159;
        r1 = r1 & (-3670017);
        Shape r19 = AssistChipDefaults.INSTANCE.getShape(r11, 6);
    L161:
        if ((r51 & 128) == 0) goto L163;
        r3 = AssistChipDefaults.INSTANCE.elevatedAssistChipColors(r11, 6);
        r1 = r1 & (-29360129);
    L163:
        int r25 = r1;
        ChipColors r24 = r3;
        if ((r51 & 256) == 0) goto L166;
        ChipElevation r14 = AssistChipDefaults.INSTANCE.m2325elevatedAssistChipElevationaqJV_2Y(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, r11, 1572864, 63);
        int r15 = r25 & (-234881025);
    L167:
        if (r9 == 0) goto L169;
        ChipBorder r16 = null;
    L170:
        if (r12 == 0) goto L175;
        Object r21 = r11.rememberedValue();
        if (r21 != Composer.Companion.getEmpty()) goto L174;
        r21 = InteractionSourceKt.MutableInteractionSource();
        r11.updateRememberedValue(r21);
    L174:
        r5 = r2;
        int r26 = r15;
        ChipBorder r27 = r16;
        MutableInteractionSource r28 = (MutableInteractionSource) r21;
        Shape r29 = r19;
        r7 = r20;
        Function2 r30 = r22;
        r3 = r24;
        ChipElevation r31 = r14;
        Function2 r32 = r23;
    L176:
        r11.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L179;
        int r110 = r410;
        ComposerKt.traceEventStart(-759567147, r26, r110, "androidx.compose.material3.ElevatedAssistChip (Chip.kt:389)");
    L180:
        TextStyle r111 = TypographyKt.getValue(AssistChipTokens.INSTANCE.getLabelTextFont(), r11, 6);
        long r210 = r3.m2406labelColorvNxB06k$material3(r7);
        float r211 = AssistChipDefaults.INSTANCE.m2326getHeightD9Ej5fM();
        PaddingValues r212 = AssistChipPadding;
        if (r27 != null) goto L183;
        r11.startReplaceGroup(1919297975);
        r11.endReplaceGroup();
        State<BorderStroke> r112 = null;
    L184:
        if (r112 == null) goto L186;
        BorderStroke r213 = (BorderStroke) r112.getValue();
    L187:
        int r113 = r26 << 6;
        ChipBorder r310 = r27;
        Modifier r114 = r5;
        boolean r115 = r7;
        Function2 r214 = r30;
        Function2 r215 = r32;
        Shape r216 = r29;
        ChipColors r217 = r3;
        ChipElevation r218 = r31;
        MutableInteractionSource r33 = r28;
        m2416ChipnkUnTEs(r114, r37, r115, r38, r111, r210, r214, r215, r216, r217, r218, r213, r211, r212, r33, r11, (((((r113 & 7168) | ((((r26 >> 6) & 14) | ((r26 << 3) & 112)) | ((r26 >> 3) & 896))) | (3670016 & r113)) | (29360128 & r113)) | (234881024 & r113)) | (1879048192 & r113), (((r26 >> 24) & 14) | 3456) | ((r110 << 12) & 57344));
        if (ComposerKt.isTraceInProgress() == false) goto L190;
        ComposerKt.traceEventEnd();
    L190:
        final ChipBorder r116 = r310;
        final Function2 r34 = r32;
        final ChipElevation r35 = r31;
        final boolean r36 = r7;
        MutableInteractionSource r117 = r28;
        final Shape r52 = r29;
        final ChipColors r53 = r3;
        final Modifier r54 = r5;
        final Function2 r55 = r30;
    L192:
        ScopeUpdateScope r118 = r11.endRestartGroup();
        if (r118 == null) goto L196;
        final MutableInteractionSource r119 = r117;
        r118.updateScope(new g3(r37, r38, r54, r36, r55, r34, r52, r53, r35, r116, r119, r49, r50, r51));
        return;
    L196:
        return;
    L186:
        r213 = null;
        goto L187
    L183:
        r11.startReplaceGroup(200460170);
        r112 = r27.borderStroke$material3(r7, r11, ((r26 >> 9) & 14) | ((r26 >> 24) & 112));
        r11.endReplaceGroup();
        goto L184
    L179:
        r110 = r410;
        goto L180
    L175:
        r28 = r47;
        r5 = r2;
        r31 = r14;
        r26 = r15;
        r27 = r16;
        r29 = r19;
        r7 = r20;
        r30 = r22;
        r32 = r23;
        r3 = r24;
        goto L176
    L169:
        r16 = r46;
        goto L170
    L166:
        r14 = r45;
        r15 = r25;
        goto L167
    L159:
        r19 = r43;
        goto L161
    L155:
        r23 = r42;
        goto L157
    L152:
        r22 = r41;
        goto L153
    L146:
        r2 = r5;
        goto L147
    L132:
        if (r11.getDefaultsInvalid() == true) goto L144;
        r11.skipToGroupEnd();
        if ((r51 & 64) == 0) goto L138;
        r1 = r1 & (-3670017);
    L138:
        if ((r51 & 128) == 0) goto L141;
        r1 = r1 & (-29360129);
    L141:
        if ((r51 & 256) == 0) goto L143;
        r1 = r1 & (-234881025);
    L143:
        r30 = r41;
        r29 = r43;
        r31 = r45;
        r27 = r46;
        r28 = r47;
        r410 = r410;
        r26 = r1;
        r32 = r42;
        goto L176
    L191:
        r11.skipToGroupEnd();
        r34 = r42;
        r35 = r45;
        r116 = r46;
        r117 = r47;
        r53 = r3;
        r54 = r5;
        r36 = r7;
        r55 = r41;
        r52 = r43;
        goto L192
    L123:
        if ((r13 & 3) != 2) goto L126;
        r0 = false;
        goto L128
    L113:
        if ((r50 & 6) == 0) goto L115;
        r13 = r50;
        goto L120
    L115:
        if (r11.changed(r47) == false) goto L117;
        int r219 = 4;
    L118:
        r13 = r50 | r219;
        goto L120
    L117:
        r219 = 2;
        goto L118
    L102:
        if ((r49 & 805306368) != 0) goto L109;
        if (r11.changed(r46) == false) goto L106;
        int r120 = 536870912;
    L107:
        r1 = r1 | r120;
        goto L109
    L106:
        r120 = 268435456;
        goto L107
    L79:
        if ((r51 & 128) != 0) goto L83;
        r3 = r44;
        if (r11.changed(r3) == false) goto L84;
        int r121 = 8388608;
    L85:
        r1 = r1 | r121;
    L84:
        r121 = 4194304;
        goto L85
    L83:
        r3 = r44;
        goto L84
    L60:
        if ((r49 & 196608) != 0) goto L67;
        if (r11.changedInstance(r42) == false) goto L64;
        int r122 = 131072;
    L65:
        r1 = r1 | r122;
        goto L67
    L64:
        r122 = 65536;
        goto L65
    L49:
        if ((r49 & 24576) != 0) goto L56;
        if (r11.changedInstance(r41) == false) goto L53;
        int r123 = 16384;
    L54:
        r1 = r1 | r123;
        goto L56
    L53:
        r123 = 8192;
        goto L54
    L38:
        if ((r49 & 3072) != 0) goto L44;
        r7 = r40;
        if (r11.changed(r7) == false) goto L42;
        int r56 = 2048;
    L43:
        r1 = r1 | r56;
        goto L45
    L42:
        r56 = 1024;
        goto L43
    L27:
        if ((r49 & 384) != 0) goto L33;
        r5 = r39;
        if (r11.changed(r5) == false) goto L31;
        int r57 = 256;
    L32:
        r1 = r1 | r57;
        goto L34
    L31:
        r57 = 128;
        goto L32
    L17:
        if ((r49 & 48) != 0) goto L23;
        if (r11.changedInstance(r38) == false) goto L21;
        int r58 = 32;
    L22:
        r1 = r1 | r58;
        goto L23
    L21:
        r58 = 16;
        goto L22
    L6:
        if ((r49 & 6) == 0) goto L8;
        r1 = r49;
        goto L14
    L8:
        if (r11.changedInstance(r37) == false) goto L10;
        int r59 = 4;
    L11:
        r1 = r59 | r49;
        goto L14
    L10:
        r59 = 2;
        goto L11
    }

    public static final void AssistChip(final Function0<Unit> r37, final Function2<? super Composer, ? super Integer, Unit> r38, Modifier r39, boolean r40, Function2<? super Composer, ? super Integer, Unit> r41, Function2<? super Composer, ? super Integer, Unit> r42, Shape r43, ChipColors r44, ChipElevation r45, BorderStroke r46, MutableInteractionSource r47, Composer r48, final int r49, final int r50, final int r51) {
        Composer r11 = r48.startRestartGroup(1192083339);
        if ((r51 & 1) == 0) goto L6;
        int r1 = r49 | 6;
    L14:
        if ((r51 & 2) == 0) goto L17;
        r1 = r1 | 48;
    L23:
        int r4 = r51 & 4;
        if (r4 == 0) goto L27;
        r1 = r1 | 384;
    L33:
        Modifier r5 = r39;
    L34:
        int r6 = r51 & 8;
        if (r6 == 0) goto L38;
        r1 = r1 | 3072;
    L44:
        boolean r7 = r40;
    L45:
        int r8 = r51 & 16;
        if (r8 == 0) goto L49;
        r1 = r1 | 24576;
    L56:
        int r10 = r51 & 32;
        if (r10 == 0) goto L60;
        r1 = r1 | 196608;
    L67:
        if ((r49 & 1572864) != 0) goto L77;
        if ((r51 & 64) == 0) goto L71;
    L73:
        int r17 = 524288;
    L74:
        r1 = r1 | r17;
        goto L77
    L71:
        if (r11.changed(r43) == false) goto L73;
        r17 = 1048576;
    L77:
        if ((r49 & 12582912) == 0) goto L79;
        ChipColors r3 = r44;
    L88:
        if ((r49 & 100663296) != 0) goto L99;
        if ((r51 & 256) != 0) goto L95;
        if (r11.changed(r45) == false) goto L95;
        int r18 = 67108864;
    L96:
        r1 = r1 | r18;
    L95:
        r18 = 33554432;
    L99:
        if ((r49 & 805306368) != 0) goto L109;
        if ((r51 & 512) != 0) goto L106;
        if (r11.changed(r46) == false) goto L106;
        int r19 = 536870912;
    L107:
        r1 = r1 | r19;
    L106:
        r19 = 268435456;
    L109:
        int r9 = r51 & 1024;
        if (r9 == 0) goto L113;
        int r12 = r50 | 6;
    L120:
        r7 = true;
        if ((r1 & 306783379) == 306783378) goto L123;
    L126:
        boolean r0 = true;
    L128:
        if (r11.shouldExecute(r0, r1 & 1) == false) goto L187;
        r11.startDefaults();
        int r410 = r12;
        if ((r49 & 1) != 0) goto L132;
    L147:
        if (r4 == 0) goto L149;
        r5 = Modifier.Companion;
    L150:
        if (r6 != 0) goto L154;
        r7 = r7;
    L154:
        if (r8 == 0) goto L156;
        Function2<? super Composer, ? super Integer, Unit> r21 = null;
    L157:
        if (r10 == 0) goto L159;
        Function2<? super Composer, ? super Integer, Unit> r22 = null;
    L161:
        if ((r51 & 64) == 0) goto L163;
        r1 = r1 & (-3670017);
        Shape r110 = AssistChipDefaults.INSTANCE.getShape(r11, 6);
    L165:
        if ((r51 & 128) == 0) goto L167;
        r3 = AssistChipDefaults.INSTANCE.assistChipColors(r11, 6);
        r1 = r1 & (-29360129);
    L167:
        int r24 = r1;
        ChipColors r23 = r3;
        if ((r51 & 256) == 0) goto L170;
        int r25 = r24 & (-234881025);
        ChipElevation r26 = AssistChipDefaults.INSTANCE.m2323assistChipElevationaqJV_2Y(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, r11, 1572864, 63);
    L172:
        if ((r51 & 512) == 0) goto L174;
        BorderStroke r2 = AssistChipDefaults.INSTANCE.m2321assistChipBorderh1eTWw(r7, 0, 0, MenuKt.ClosedAlphaTarget, r11, ((r25 >> 9) & 14) | 24576, 14);
        int r13 = r25 & (-1879048193);
    L175:
        if (r9 == 0) goto L177;
        MutableInteractionSource r14 = null;
    L178:
        Function2<? super Composer, ? super Integer, Unit> r15 = r21;
        Function2<? super Composer, ? super Integer, Unit> r16 = r22;
        r3 = r23;
        ChipElevation r20 = r26;
    L179:
        r11.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L182;
        int r111 = r410;
        ComposerKt.traceEventStart(1192083339, r13, r111, "androidx.compose.material3.AssistChip (Chip.kt:146)");
    L183:
        int r112 = r13 << 6;
        int r32 = ((((((((r13 >> 6) & 14) | ((r13 << 3) & 112)) | ((r13 >> 3) & 896)) | (r112 & 7168)) | (3670016 & r112)) | (29360128 & r112)) | (234881024 & r112)) | (r112 & 1879048192);
        int r27 = r13 >> 24;
        Modifier r113 = r5;
        boolean r114 = r7;
        Function2<? super Composer, ? super Integer, Unit> r28 = r15;
        Function2<? super Composer, ? super Integer, Unit> r29 = r16;
        Shape r210 = r110;
        ChipColors r211 = r3;
        ChipElevation r212 = r20;
        BorderStroke r213 = r2;
        MutableInteractionSource r30 = r14;
        m2416ChipnkUnTEs(r113, r37, r114, r38, TypographyKt.getValue(AssistChipTokens.INSTANCE.getLabelTextFont(), r11, 6), r3.m2406labelColorvNxB06k$material3(r7), r28, r29, r210, r211, r212, r213, AssistChipDefaults.INSTANCE.m2326getHeightD9Ej5fM(), AssistChipPadding, r30, r11, r32, ((r27 & 112) | ((r27 & 14) | 3456)) | ((r111 << 12) & 57344));
        if (ComposerKt.isTraceInProgress() == false) goto L186;
        ComposerKt.traceEventEnd();
    L186:
        final ChipElevation r31 = r20;
        final BorderStroke r115 = r2;
        final boolean r33 = r7;
        MutableInteractionSource r116 = r14;
        final Function2<? super Composer, ? super Integer, Unit> r34 = r16;
        final Shape r35 = r110;
        final ChipColors r36 = r3;
        final Modifier r52 = r5;
        final Function2<? super Composer, ? super Integer, Unit> r53 = r15;
    L188:
        ScopeUpdateScope r117 = r11.endRestartGroup();
        if (r117 == null) goto L192;
        final MutableInteractionSource r118 = r116;
        r117.updateScope(new w3(r37, r38, r52, r33, r53, r34, r35, r36, r31, r115, r118, r49, r50, r51));
        return;
    L192:
        return;
    L182:
        r111 = r410;
        goto L183
    L177:
        r14 = r47;
        goto L178
    L174:
        r2 = r46;
        r13 = r25;
        goto L175
    L170:
        r25 = r24;
        r26 = r45;
        goto L172
    L163:
        r110 = r43;
        goto L165
    L159:
        r22 = r42;
        goto L161
    L156:
        r21 = r41;
        goto L157
    L149:
        r5 = r5;
        goto L150
    L132:
        if (r11.getDefaultsInvalid() == true) goto L147;
        r11.skipToGroupEnd();
        if ((r51 & 64) == 0) goto L138;
        r1 = r1 & (-3670017);
    L138:
        if ((r51 & 128) == 0) goto L141;
        r1 = r1 & (-29360129);
    L141:
        if ((r51 & 256) == 0) goto L144;
        r1 = r1 & (-234881025);
    L144:
        if ((r51 & 512) == 0) goto L146;
        r1 = r1 & (-1879048193);
    L146:
        r15 = r41;
        r110 = r43;
        r20 = r45;
        r2 = r46;
        r14 = r47;
        r410 = r410;
        r13 = r1;
        r16 = r42;
        goto L179
    L187:
        r11.skipToGroupEnd();
        r34 = r42;
        r31 = r45;
        r115 = r46;
        r116 = r47;
        r36 = r3;
        r52 = r5;
        r33 = r7;
        r53 = r41;
        r35 = r43;
        goto L188
    L123:
        if ((r12 & 3) != 2) goto L126;
        r0 = false;
        goto L128
    L113:
        if ((r50 & 6) == 0) goto L115;
        r12 = r50;
        goto L120
    L115:
        if (r11.changed(r47) == false) goto L117;
        int r119 = 4;
    L118:
        r12 = r50 | r119;
        goto L120
    L117:
        r119 = 2;
        goto L118
    L79:
        if ((r51 & 128) != 0) goto L83;
        r3 = r44;
        if (r11.changed(r3) == false) goto L84;
        int r120 = 8388608;
    L85:
        r1 = r1 | r120;
    L84:
        r120 = 4194304;
        goto L85
    L83:
        r3 = r44;
        goto L84
    L60:
        if ((r49 & 196608) != 0) goto L67;
        if (r11.changedInstance(r42) == false) goto L64;
        int r121 = 131072;
    L65:
        r1 = r1 | r121;
        goto L67
    L64:
        r121 = 65536;
        goto L65
    L49:
        if ((r49 & 24576) != 0) goto L56;
        if (r11.changedInstance(r41) == false) goto L53;
        int r122 = 16384;
    L54:
        r1 = r1 | r122;
        goto L56
    L53:
        r122 = 8192;
        goto L54
    L38:
        if ((r49 & 3072) != 0) goto L44;
        r7 = r40;
        if (r11.changed(r7) == false) goto L42;
        int r54 = 2048;
    L43:
        r1 = r1 | r54;
        goto L45
    L42:
        r54 = 1024;
        goto L43
    L27:
        if ((r49 & 384) != 0) goto L33;
        r5 = r39;
        if (r11.changed(r5) == false) goto L31;
        int r55 = 256;
    L32:
        r1 = r1 | r55;
        goto L34
    L31:
        r55 = 128;
        goto L32
    L17:
        if ((r49 & 48) != 0) goto L23;
        if (r11.changedInstance(r38) == false) goto L21;
        int r56 = 32;
    L22:
        r1 = r1 | r56;
        goto L23
    L21:
        r56 = 16;
        goto L22
    L6:
        if ((r49 & 6) == 0) goto L8;
        r1 = r49;
        goto L14
    L8:
        if (r11.changedInstance(r37) == false) goto L10;
        int r57 = 4;
    L11:
        r1 = r57 | r49;
        goto L14
    L10:
        r57 = 2;
        goto L11
    }

    public static final void ElevatedAssistChip(final Function0<Unit> r37, final Function2<? super Composer, ? super Integer, Unit> r38, Modifier r39, boolean r40, Function2<? super Composer, ? super Integer, Unit> r41, Function2<? super Composer, ? super Integer, Unit> r42, Shape r43, ChipColors r44, ChipElevation r45, BorderStroke r46, MutableInteractionSource r47, Composer r48, final int r49, final int r50, final int r51) {
        Composer r11 = r48.startRestartGroup(2028863105);
        if ((r51 & 1) == 0) goto L6;
        int r1 = r49 | 6;
    L14:
        if ((r51 & 2) == 0) goto L17;
        r1 = r1 | 48;
    L23:
        int r4 = r51 & 4;
        if (r4 == 0) goto L27;
        r1 = r1 | 384;
    L33:
        Modifier r5 = r39;
    L34:
        int r6 = r51 & 8;
        if (r6 == 0) goto L38;
        r1 = r1 | 3072;
    L44:
        boolean r7 = r40;
    L45:
        int r8 = r51 & 16;
        if (r8 == 0) goto L49;
        r1 = r1 | 24576;
    L56:
        int r10 = r51 & 32;
        if (r10 == 0) goto L60;
        r1 = r1 | 196608;
    L67:
        if ((r49 & 1572864) != 0) goto L77;
        if ((r51 & 64) == 0) goto L71;
    L73:
        int r17 = 524288;
    L74:
        r1 = r1 | r17;
        goto L77
    L71:
        if (r11.changed(r43) == false) goto L73;
        r17 = 1048576;
    L77:
        if ((r49 & 12582912) == 0) goto L79;
        ChipColors r3 = r44;
    L88:
        if ((r49 & 100663296) != 0) goto L98;
        if ((r51 & 256) != 0) goto L95;
        if (r11.changed(r45) == false) goto L95;
        int r18 = 67108864;
    L96:
        r1 = r1 | r18;
    L95:
        r18 = 33554432;
    L98:
        int r9 = r51 & 512;
        if (r9 == 0) goto L102;
        r1 = r1 | 805306368;
    L109:
        int r12 = r51 & 1024;
        if (r12 == 0) goto L113;
        int r13 = r50 | 6;
    L120:
        r7 = true;
        if ((r1 & 306783379) == 306783378) goto L123;
    L126:
        boolean r0 = true;
    L128:
        if (r11.shouldExecute(r0, r1 & 1) == false) goto L183;
        r11.startDefaults();
        int r410 = r13;
        if ((r49 & 1) != 0) goto L132;
    L144:
        if (r4 == 0) goto L146;
        r5 = Modifier.Companion;
    L147:
        if (r6 != 0) goto L151;
        r7 = r7;
    L151:
        if (r8 == 0) goto L153;
        Function2<? super Composer, ? super Integer, Unit> r23 = null;
    L154:
        if (r10 == 0) goto L156;
        Function2<? super Composer, ? super Integer, Unit> r24 = null;
    L158:
        if ((r51 & 64) == 0) goto L160;
        r1 = r1 & (-3670017);
        Shape r21 = AssistChipDefaults.INSTANCE.getShape(r11, 6);
    L162:
        if ((r51 & 128) == 0) goto L164;
        r3 = AssistChipDefaults.INSTANCE.elevatedAssistChipColors(r11, 6);
        r1 = r1 & (-29360129);
    L164:
        int r26 = r1;
        ChipColors r25 = r3;
        if ((r51 & 256) == 0) goto L167;
        ChipElevation r2 = AssistChipDefaults.INSTANCE.m2325elevatedAssistChipElevationaqJV_2Y(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, r11, 1572864, 63);
        int r14 = r26 & (-234881025);
    L168:
        if (r9 == 0) goto L170;
        BorderStroke r15 = null;
    L171:
        if (r12 == 0) goto L173;
        MutableInteractionSource r16 = null;
    L174:
        Function2<? super Composer, ? super Integer, Unit> r19 = r23;
        Function2<? super Composer, ? super Integer, Unit> r20 = r24;
        r3 = r25;
    L175:
        r11.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L178;
        int r110 = r410;
        ComposerKt.traceEventStart(2028863105, r14, r110, "androidx.compose.material3.ElevatedAssistChip (Chip.kt:305)");
    L179:
        int r111 = r14 << 6;
        int r32 = ((((((((r14 >> 6) & 14) | ((r14 << 3) & 112)) | ((r14 >> 3) & 896)) | (r111 & 7168)) | (3670016 & r111)) | (29360128 & r111)) | (234881024 & r111)) | (r111 & 1879048192);
        int r22 = r14 >> 24;
        Modifier r112 = r5;
        boolean r113 = r7;
        Function2<? super Composer, ? super Integer, Unit> r27 = r19;
        Function2<? super Composer, ? super Integer, Unit> r28 = r20;
        Shape r29 = r21;
        ChipColors r210 = r3;
        ChipElevation r211 = r2;
        BorderStroke r212 = r15;
        MutableInteractionSource r30 = r16;
        m2416ChipnkUnTEs(r112, r37, r113, r38, TypographyKt.getValue(AssistChipTokens.INSTANCE.getLabelTextFont(), r11, 6), r3.m2406labelColorvNxB06k$material3(r7), r27, r28, r29, r210, r211, r212, AssistChipDefaults.INSTANCE.m2326getHeightD9Ej5fM(), AssistChipPadding, r30, r11, r32, ((r22 & 112) | ((r22 & 14) | 3456)) | ((r110 << 12) & 57344));
        if (ComposerKt.isTraceInProgress() == false) goto L182;
        ComposerKt.traceEventEnd();
    L182:
        final ChipElevation r31 = r2;
        final BorderStroke r114 = r15;
        final boolean r33 = r7;
        MutableInteractionSource r115 = r16;
        final Function2<? super Composer, ? super Integer, Unit> r34 = r20;
        final Shape r35 = r21;
        final ChipColors r36 = r3;
        final Modifier r52 = r5;
        final Function2<? super Composer, ? super Integer, Unit> r53 = r19;
    L184:
        ScopeUpdateScope r116 = r11.endRestartGroup();
        if (r116 == null) goto L188;
        final MutableInteractionSource r117 = r115;
        r116.updateScope(new v3(r37, r38, r52, r33, r53, r34, r35, r36, r31, r114, r117, r49, r50, r51));
        return;
    L188:
        return;
    L178:
        r110 = r410;
        goto L179
    L173:
        r16 = r47;
        goto L174
    L170:
        r15 = r46;
        goto L171
    L167:
        r2 = r45;
        r14 = r26;
        goto L168
    L160:
        r21 = r43;
        goto L162
    L156:
        r24 = r42;
        goto L158
    L153:
        r23 = r41;
        goto L154
    L146:
        r5 = r5;
        goto L147
    L132:
        if (r11.getDefaultsInvalid() == true) goto L144;
        r11.skipToGroupEnd();
        if ((r51 & 64) == 0) goto L138;
        r1 = r1 & (-3670017);
    L138:
        if ((r51 & 128) == 0) goto L141;
        r1 = r1 & (-29360129);
    L141:
        if ((r51 & 256) == 0) goto L143;
        r1 = r1 & (-234881025);
    L143:
        r19 = r41;
        r21 = r43;
        r2 = r45;
        r15 = r46;
        r16 = r47;
        r410 = r410;
        r14 = r1;
        r20 = r42;
        goto L175
    L183:
        r11.skipToGroupEnd();
        r34 = r42;
        r31 = r45;
        r114 = r46;
        r115 = r47;
        r36 = r3;
        r52 = r5;
        r33 = r7;
        r53 = r41;
        r35 = r43;
        goto L184
    L123:
        if ((r13 & 3) != 2) goto L126;
        r0 = false;
        goto L128
    L113:
        if ((r50 & 6) == 0) goto L115;
        r13 = r50;
        goto L120
    L115:
        if (r11.changed(r47) == false) goto L117;
        int r213 = 4;
    L118:
        r13 = r50 | r213;
        goto L120
    L117:
        r213 = 2;
        goto L118
    L102:
        if ((r49 & 805306368) != 0) goto L109;
        if (r11.changed(r46) == false) goto L106;
        int r118 = 536870912;
    L107:
        r1 = r1 | r118;
        goto L109
    L106:
        r118 = 268435456;
        goto L107
    L79:
        if ((r51 & 128) != 0) goto L83;
        r3 = r44;
        if (r11.changed(r3) == false) goto L84;
        int r119 = 8388608;
    L85:
        r1 = r1 | r119;
    L84:
        r119 = 4194304;
        goto L85
    L83:
        r3 = r44;
        goto L84
    L60:
        if ((r49 & 196608) != 0) goto L67;
        if (r11.changedInstance(r42) == false) goto L64;
        int r120 = 131072;
    L65:
        r1 = r1 | r120;
        goto L67
    L64:
        r120 = 65536;
        goto L65
    L49:
        if ((r49 & 24576) != 0) goto L56;
        if (r11.changedInstance(r41) == false) goto L53;
        int r121 = 16384;
    L54:
        r1 = r1 | r121;
        goto L56
    L53:
        r121 = 8192;
        goto L54
    L38:
        if ((r49 & 3072) != 0) goto L44;
        r7 = r40;
        if (r11.changed(r7) == false) goto L42;
        int r54 = 2048;
    L43:
        r1 = r1 | r54;
        goto L45
    L42:
        r54 = 1024;
        goto L43
    L27:
        if ((r49 & 384) != 0) goto L33;
        r5 = r39;
        if (r11.changed(r5) == false) goto L31;
        int r55 = 256;
    L32:
        r1 = r1 | r55;
        goto L34
    L31:
        r55 = 128;
        goto L32
    L17:
        if ((r49 & 48) != 0) goto L23;
        if (r11.changedInstance(r38) == false) goto L21;
        int r56 = 32;
    L22:
        r1 = r1 | r56;
        goto L23
    L21:
        r56 = 16;
        goto L22
    L6:
        if ((r49 & 6) == 0) goto L8;
        r1 = r49;
        goto L14
    L8:
        if (r11.changedInstance(r37) == false) goto L10;
        int r57 = 4;
    L11:
        r1 = r57 | r49;
        goto L14
    L10:
        r57 = 2;
        goto L11
    }

    public static final void ElevatedFilterChip(final boolean r37, final Function0<Unit> r38, final Function2<? super Composer, ? super Integer, Unit> r39, Modifier r40, boolean r41, Function2<? super Composer, ? super Integer, Unit> r42, Function2<? super Composer, ? super Integer, Unit> r43, Shape r44, SelectableChipColors r45, SelectableChipElevation r46, BorderStroke r47, MutableInteractionSource r48, Composer r49, final int r50, final int r51, final int r52) {
        Composer r11 = r49.startRestartGroup(1533553846);
        if ((r52 & 1) == 0) goto L6;
        int r1 = r50 | 6;
    L14:
        if ((r52 & 2) == 0) goto L17;
        r1 = r1 | 48;
    L24:
        if ((r52 & 4) == 0) goto L27;
        r1 = r1 | 384;
    L33:
        int r4 = r52 & 8;
        if (r4 == 0) goto L37;
        r1 = r1 | 3072;
    L43:
        Modifier r7 = r40;
    L44:
        int r8 = r52 & 16;
        if (r8 == 0) goto L48;
        r1 = r1 | 24576;
    L54:
        boolean r9 = r41;
    L55:
        int r16 = r52 & 32;
        if (r16 == 0) goto L59;
        r1 = r1 | 196608;
    L65:
        int r17 = r52 & 64;
        if (r17 == 0) goto L68;
        r1 = r1 | 1572864;
        Function2<? super Composer, ? super Integer, Unit> r3 = r43;
    L76:
        if ((r50 & 12582912) == 0) goto L78;
        Shape r5 = r44;
    L87:
        if ((r50 & 100663296) == 0) goto L89;
        SelectableChipColors r6 = r45;
    L98:
        if ((r50 & 805306368) != 0) goto L108;
        if ((r52 & 512) != 0) goto L105;
        if (r11.changed(r46) == false) goto L105;
        int r23 = 536870912;
    L106:
        r1 = r1 | r23;
    L105:
        r23 = 268435456;
    L108:
        int r10 = r52 & 1024;
        if (r10 == 0) goto L112;
        int r18 = r51 | 6;
    L119:
        int r12 = r52 & 2048;
        if (r12 == 0) goto L123;
        r18 = r18 | 48;
    L130:
        int r13 = r18;
        r9 = true;
        if ((r1 & 306783379) == 306783378) goto L133;
    L136:
        boolean r0 = true;
    L138:
        if (r11.shouldExecute(r0, r1 & 1) == false) goto L194;
        r11.startDefaults();
        int r410 = r13;
        if ((r50 & 1) != 0) goto L142;
    L154:
        if (r4 == 0) goto L156;
        Modifier r2 = Modifier.Companion;
    L157:
        if (r8 != 0) goto L161;
        r9 = r9;
    L161:
        if (r16 == 0) goto L163;
        Function2<? super Composer, ? super Integer, Unit> r19 = null;
    L164:
        if (r17 == 0) goto L166;
        r3 = null;
    L168:
        if ((r52 & 128) == 0) goto L170;
        r1 = r1 & (-29360129);
        r5 = FilterChipDefaults.INSTANCE.getShape(r11, 6);
    L172:
        if ((r52 & 256) == 0) goto L174;
        int r26 = r1 & (-234881025);
        SelectableChipColors r25 = FilterChipDefaults.INSTANCE.elevatedFilterChipColors(r11, 6);
    L176:
        if ((r52 & 512) == 0) goto L178;
        SelectableChipElevation r14 = FilterChipDefaults.INSTANCE.m2712elevatedFilterChipElevationaqJV_2Y(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, r11, 1572864, 63);
        int r15 = r26 & (-1879048193);
    L179:
        if (r10 == 0) goto L181;
        BorderStroke r20 = null;
    L182:
        r7 = r2;
        if (r12 == 0) goto L185;
        MutableInteractionSource r21 = null;
    L186:
        r6 = r25;
        SelectableChipElevation r22 = r14;
        Function2<? super Composer, ? super Integer, Unit> r24 = r19;
    L187:
        r11.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L190;
        ComposerKt.traceEventStart(1533553846, r15, r410, "androidx.compose.material3.ElevatedFilterChip (Chip.kt:556)");
    L190:
        int r110 = r15 << 3;
        int r111 = r15 << 6;
        int r33 = ((((((((r15 & 14) | 12582912) | ((r15 >> 6) & 112)) | (r110 & 896)) | ((r15 >> 3) & 7168)) | (r111 & 57344)) | (r110 & 3670016)) | (234881024 & r111)) | (1879048192 & r111);
        int r112 = r15 >> 24;
        Modifier r113 = r7;
        boolean r114 = r9;
        Function2<? super Composer, ? super Integer, Unit> r27 = r24;
        Function2<? super Composer, ? super Integer, Unit> r28 = r3;
        Shape r29 = r5;
        SelectableChipColors r210 = r6;
        SelectableChipElevation r211 = r22;
        BorderStroke r212 = r20;
        MutableInteractionSource r31 = r21;
        m2418SelectableChipu0RnIRE(r37, r113, r38, r114, r39, TypographyKt.getValue(FilterChipTokens.INSTANCE.getLabelTextFont(), r11, 6), r27, null, r28, r29, r210, r211, r212, FilterChipDefaults.INSTANCE.m2716getHeightD9Ej5fM(), FilterChipPadding, r31, r11, r33, (((r112 & 112) | ((r112 & 14) | 27648)) | ((r410 << 6) & 896)) | ((r410 << 12) & 458752));
        if (ComposerKt.isTraceInProgress() == false) goto L193;
        ComposerKt.traceEventEnd();
    L193:
        final SelectableChipElevation r115 = r22;
        BorderStroke r116 = r20;
        final Modifier r30 = r7;
        MutableInteractionSource r117 = r21;
        final Function2<? super Composer, ? super Integer, Unit> r32 = r3;
        final Shape r34 = r5;
        final boolean r35 = r9;
        final SelectableChipColors r36 = r6;
        final Function2<? super Composer, ? super Integer, Unit> r53 = r24;
    L195:
        ScopeUpdateScope r118 = r11.endRestartGroup();
        if (r118 == null) goto L199;
        final BorderStroke r119 = r116;
        final MutableInteractionSource r120 = r117;
        r118.updateScope(new h3(r37, r38, r39, r30, r35, r53, r32, r34, r36, r115, r119, r120, r50, r51, r52));
        return;
    L199:
        return;
    L185:
        r21 = r48;
        goto L186
    L181:
        r20 = r47;
        goto L182
    L178:
        r14 = r46;
        r15 = r26;
        goto L179
    L174:
        r26 = r1;
        r25 = r6;
        goto L176
    L170:
        r5 = r5;
        goto L172
    L166:
        r3 = r3;
        goto L168
    L163:
        r19 = r42;
        goto L164
    L156:
        r2 = r7;
        goto L157
    L142:
        if (r11.getDefaultsInvalid() == true) goto L154;
        r11.skipToGroupEnd();
        if ((r52 & 128) == 0) goto L148;
        r1 = r1 & (-29360129);
    L148:
        if ((r52 & 256) == 0) goto L151;
        r1 = r1 & (-234881025);
    L151:
        if ((r52 & 512) == 0) goto L153;
        r1 = r1 & (-1879048193);
    L153:
        r22 = r46;
        r20 = r47;
        r21 = r48;
        r410 = r410;
        r15 = r1;
        r24 = r42;
        goto L187
    L194:
        r11.skipToGroupEnd();
        r115 = r46;
        r116 = r47;
        r117 = r48;
        r34 = r5;
        r30 = r7;
        r35 = r9;
        r32 = r3;
        r36 = r6;
        r53 = r42;
        goto L195
    L133:
        if ((r13 & 19) != 18) goto L136;
        r0 = false;
        goto L138
    L123:
        if ((r51 & 48) != 0) goto L130;
        if (r11.changed(r48) == false) goto L127;
        int r213 = 32;
    L128:
        r18 = r18 | r213;
        goto L130
    L127:
        r213 = 16;
        goto L128
    L112:
        if ((r51 & 6) == 0) goto L114;
        r18 = r51;
        goto L119
    L114:
        if (r11.changed(r47) == false) goto L116;
        int r121 = 4;
    L117:
        r18 = r51 | r121;
        goto L119
    L116:
        r121 = 2;
        goto L117
    L89:
        if ((r52 & 256) != 0) goto L93;
        r6 = r45;
        if (r11.changed(r6) == false) goto L94;
        int r214 = 67108864;
    L95:
        r1 = r1 | r214;
    L94:
        r214 = 33554432;
        goto L95
    L93:
        r6 = r45;
        goto L94
    L78:
        if ((r52 & 128) != 0) goto L82;
        r5 = r44;
        if (r11.changed(r5) == false) goto L83;
        int r215 = 8388608;
    L84:
        r1 = r1 | r215;
    L83:
        r215 = 4194304;
        goto L84
    L82:
        r5 = r44;
        goto L83
    L68:
        r3 = r43;
        if ((r50 & 1572864) != 0) goto L76;
        if (r11.changedInstance(r3) == false) goto L73;
        int r122 = 1048576;
    L74:
        r1 = r1 | r122;
        goto L76
    L73:
        r122 = 524288;
        goto L74
    L59:
        if ((r50 & 196608) != 0) goto L65;
        if (r11.changedInstance(r42) == false) goto L63;
        int r123 = 131072;
    L64:
        r1 = r1 | r123;
        goto L65
    L63:
        r123 = 65536;
        goto L64
    L48:
        if ((r50 & 24576) != 0) goto L54;
        r9 = r41;
        if (r11.changed(r9) == false) goto L52;
        int r124 = 16384;
    L53:
        r1 = r1 | r124;
        goto L55
    L52:
        r124 = 8192;
        goto L53
    L37:
        if ((r50 & 3072) != 0) goto L43;
        r7 = r40;
        if (r11.changed(r7) == false) goto L41;
        int r54 = 2048;
    L42:
        r1 = r1 | r54;
        goto L44
    L41:
        r54 = 1024;
        goto L42
    L27:
        if ((r50 & 384) != 0) goto L33;
        if (r11.changedInstance(r39) == false) goto L31;
        int r55 = 256;
    L32:
        r1 = r1 | r55;
        goto L33
    L31:
        r55 = 128;
        goto L32
    L17:
        if ((r50 & 48) != 0) goto L24;
        if (r11.changedInstance(r38) == false) goto L21;
        int r56 = 32;
    L22:
        r1 = r1 | r56;
        goto L24
    L21:
        r56 = 16;
        goto L22
    L6:
        if ((r50 & 6) == 0) goto L8;
        r1 = r50;
        goto L14
    L8:
        if (r11.changed(r37) == false) goto L10;
        int r57 = 4;
    L11:
        r1 = r57 | r50;
        goto L14
    L10:
        r57 = 2;
        goto L11
    }

    public static final void FilterChip(final boolean r43, final Function0<Unit> r44, final Function2<? super Composer, ? super Integer, Unit> r45, Modifier r46, boolean r47, Function2<? super Composer, ? super Integer, Unit> r48, Function2<? super Composer, ? super Integer, Unit> r49, Shape r50, SelectableChipColors r51, SelectableChipElevation r52, BorderStroke r53, MutableInteractionSource r54, Composer r55, final int r56, final int r57, final int r58) {
        Composer r11 = r55.startRestartGroup(-1385473344);
        if ((r58 & 1) == 0) goto L6;
        int r1 = r56 | 6;
    L14:
        if ((r58 & 2) == 0) goto L17;
        r1 = r1 | 48;
    L24:
        if ((r58 & 4) == 0) goto L27;
        r1 = r1 | 384;
    L33:
        int r4 = r58 & 8;
        if (r4 == 0) goto L37;
        r1 = r1 | 3072;
    L43:
        Modifier r7 = r46;
    L44:
        int r8 = r58 & 16;
        if (r8 == 0) goto L48;
        r1 = r1 | 24576;
    L54:
        boolean r9 = r47;
    L55:
        int r16 = r58 & 32;
        if (r16 == 0) goto L59;
        r1 = r1 | 196608;
    L65:
        int r17 = r58 & 64;
        if (r17 == 0) goto L68;
        r1 = r1 | 1572864;
        Function2<? super Composer, ? super Integer, Unit> r3 = r49;
    L76:
        if ((r56 & 12582912) == 0) goto L78;
        Shape r5 = r50;
    L87:
        if ((r56 & 100663296) == 0) goto L89;
        SelectableChipColors r6 = r51;
    L98:
        if ((r56 & 805306368) != 0) goto L109;
        if ((r58 & 512) != 0) goto L105;
        if (r11.changed(r52) == false) goto L105;
        int r21 = 536870912;
    L106:
        r1 = r1 | r21;
    L105:
        r21 = 268435456;
    L109:
        if ((r57 & 6) == 0) goto L111;
        int r18 = r57;
    L119:
        int r10 = r58 & 2048;
        if (r10 == 0) goto L123;
        r10 = r10;
        int r33 = r18 | 48;
        MutableInteractionSource r12 = r54;
    L132:
        if ((r1 & 306783379) == 306783378) goto L134;
    L137:
        boolean r0 = true;
    L139:
        if (r11.shouldExecute(r0, r1 & 1) == false) goto L198;
        r11.startDefaults();
        if ((r56 & 1) != 0) goto L143;
    L158:
        if (r4 == 0) goto L160;
        Modifier r2 = Modifier.Companion;
    L161:
        if (r8 == 0) goto L163;
        r9 = true;
    L165:
        if (r16 == 0) goto L167;
        Function2<? super Composer, ? super Integer, Unit> r36 = null;
    L168:
        if (r17 == 0) goto L170;
        Function2<? super Composer, ? super Integer, Unit> r37 = null;
    L172:
        if ((r58 & 128) == 0) goto L174;
        r1 = r1 & (-29360129);
        Shape r38 = FilterChipDefaults.INSTANCE.getShape(r11, 6);
    L176:
        if ((r58 & 256) == 0) goto L178;
        int r19 = r1 & (-234881025);
        SelectableChipColors r39 = FilterChipDefaults.INSTANCE.filterChipColors(r11, 6);
    L180:
        if ((r58 & 512) == 0) goto L182;
        SelectableChipElevation r13 = FilterChipDefaults.INSTANCE.m2715filterChipElevationaqJV_2Y(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, r11, 1572864, 63);
        int r14 = r19 & (-1879048193);
    L184:
        if ((r58 & 1024) == 0) goto L186;
        BorderStroke r15 = FilterChipDefaults.INSTANCE.m2713filterChipBorder_7El2pE(r9, r43, 0, 0, 0, 0, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, r11, (((r14 >> 12) & 14) | 100663296) | ((r14 << 3) & 112), 252);
        r33 = r33 & (-15);
    L187:
        if (r10 == 0) goto L189;
        r12 = null;
    L190:
        r3 = r37;
        r5 = r38;
        r6 = r39;
    L191:
        r11.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L194;
        ComposerKt.traceEventStart(-1385473344, r14, r33, "androidx.compose.material3.FilterChip (Chip.kt:474)");
    L194:
        int r110 = r14 << 3;
        int r111 = r14 << 6;
        int r34 = ((((((((r14 & 14) | 12582912) | ((r14 >> 6) & 112)) | (r110 & 896)) | ((r14 >> 3) & 7168)) | (r111 & 57344)) | (r110 & 3670016)) | (234881024 & r111)) | (1879048192 & r111);
        int r20 = r14 >> 24;
        Modifier r112 = r2;
        boolean r113 = r9;
        Function2<? super Composer, ? super Integer, Unit> r22 = r36;
        Function2<? super Composer, ? super Integer, Unit> r24 = r3;
        Shape r25 = r5;
        SelectableChipColors r26 = r6;
        SelectableChipElevation r27 = r13;
        BorderStroke r28 = r15;
        MutableInteractionSource r31 = r12;
        m2418SelectableChipu0RnIRE(r43, r112, r44, r113, r45, TypographyKt.getValue(FilterChipTokens.INSTANCE.getLabelTextFont(), r11, 6), r22, null, r24, r25, r26, r27, r28, FilterChipDefaults.INSTANCE.m2716getHeightD9Ej5fM(), FilterChipPadding, r31, r11, r34, (((r20 & 112) | ((r20 & 14) | 27648)) | ((r33 << 6) & 896)) | ((r33 << 12) & 458752));
        if (ComposerKt.isTraceInProgress() == false) goto L197;
        ComposerKt.traceEventEnd();
    L197:
        final Modifier r23 = r2;
        BorderStroke r114 = r15;
        final Function2<? super Composer, ? super Integer, Unit> r29 = r3;
        final Shape r30 = r5;
        final boolean r32 = r9;
        MutableInteractionSource r115 = r12;
        final SelectableChipElevation r116 = r13;
        final SelectableChipColors r35 = r6;
        final Function2<? super Composer, ? super Integer, Unit> r40 = r36;
    L199:
        ScopeUpdateScope r117 = r11.endRestartGroup();
        if (r117 == null) goto L203;
        final BorderStroke r118 = r114;
        final MutableInteractionSource r119 = r115;
        r117.updateScope(new o3(r43, r44, r45, r23, r32, r40, r29, r30, r35, r116, r118, r119, r56, r57, r58));
        return;
    L203:
        return;
    L189:
        r12 = r54;
        goto L190
    L186:
        r15 = r53;
        goto L187
    L182:
        r13 = r52;
        r14 = r19;
        goto L184
    L178:
        r19 = r1;
        r39 = r6;
        goto L180
    L174:
        r38 = r5;
        goto L176
    L170:
        r37 = r3;
        goto L172
    L167:
        r36 = r48;
        goto L168
    L163:
        r9 = r9;
        goto L165
    L160:
        r2 = r7;
        goto L161
    L143:
        if (r11.getDefaultsInvalid() == true) goto L158;
        r11.skipToGroupEnd();
        if ((r58 & 128) == 0) goto L149;
        r1 = r1 & (-29360129);
    L149:
        if ((r58 & 256) == 0) goto L152;
        r1 = r1 & (-234881025);
    L152:
        if ((r58 & 512) == 0) goto L155;
        r1 = r1 & (-1879048193);
    L155:
        if ((r58 & 1024) == 0) goto L157;
        r33 = r33 & (-15);
    L157:
        r36 = r48;
        r15 = r53;
        r14 = r1;
        r2 = r7;
        r33 = r33;
        r13 = r52;
        goto L191
    L198:
        r11.skipToGroupEnd();
        r116 = r52;
        r114 = r53;
        r115 = r54;
        r30 = r5;
        r23 = r7;
        r32 = r9;
        r29 = r3;
        r35 = r6;
        r40 = r48;
        goto L199
    L134:
        if ((r33 & 19) != 18) goto L137;
        r0 = false;
        goto L139
    L123:
        if ((r57 & 48) != 0) goto L129;
        r12 = r54;
        if (r11.changed(r12) == false) goto L127;
        int r120 = 32;
    L128:
        r18 = r18 | r120;
    L130:
        r33 = r18;
        goto L132
    L127:
        r120 = 16;
        goto L128
    L129:
        r12 = r54;
        goto L130
    L111:
        if ((r58 & 1024) != 0) goto L116;
        if (r11.changed(r53) == false) goto L116;
        int r121 = 4;
    L117:
        r18 = r57 | r121;
    L116:
        r121 = 2;
        goto L117
    L89:
        if ((r58 & 256) != 0) goto L93;
        r6 = r51;
        if (r11.changed(r6) == false) goto L94;
        int r210 = 67108864;
    L95:
        r1 = r1 | r210;
    L94:
        r210 = 33554432;
        goto L95
    L93:
        r6 = r51;
        goto L94
    L78:
        if ((r58 & 128) != 0) goto L82;
        r5 = r50;
        if (r11.changed(r5) == false) goto L83;
        int r211 = 8388608;
    L84:
        r1 = r1 | r211;
    L83:
        r211 = 4194304;
        goto L84
    L82:
        r5 = r50;
        goto L83
    L68:
        r3 = r49;
        if ((r56 & 1572864) != 0) goto L76;
        if (r11.changedInstance(r3) == false) goto L73;
        int r122 = 1048576;
    L74:
        r1 = r1 | r122;
        goto L76
    L73:
        r122 = 524288;
        goto L74
    L59:
        if ((r56 & 196608) != 0) goto L65;
        if (r11.changedInstance(r48) == false) goto L63;
        int r123 = 131072;
    L64:
        r1 = r1 | r123;
        goto L65
    L63:
        r123 = 65536;
        goto L64
    L48:
        if ((r56 & 24576) != 0) goto L54;
        r9 = r47;
        if (r11.changed(r9) == false) goto L52;
        int r124 = 16384;
    L53:
        r1 = r1 | r124;
        goto L55
    L52:
        r124 = 8192;
        goto L53
    L37:
        if ((r56 & 3072) != 0) goto L43;
        r7 = r46;
        if (r11.changed(r7) == false) goto L41;
        int r41 = 2048;
    L42:
        r1 = r1 | r41;
        goto L44
    L41:
        r41 = 1024;
        goto L42
    L27:
        if ((r56 & 384) != 0) goto L33;
        if (r11.changedInstance(r45) == false) goto L31;
        int r42 = 256;
    L32:
        r1 = r1 | r42;
        goto L33
    L31:
        r42 = 128;
        goto L32
    L17:
        if ((r56 & 48) != 0) goto L24;
        if (r11.changedInstance(r44) == false) goto L21;
        int r59 = 32;
    L22:
        r1 = r1 | r59;
        goto L24
    L21:
        r59 = 16;
        goto L22
    L6:
        if ((r56 & 6) == 0) goto L8;
        r1 = r56;
        goto L14
    L8:
        if (r11.changed(r43) == false) goto L10;
        int r60 = 4;
    L11:
        r1 = r60 | r56;
        goto L14
    L10:
        r60 = 2;
        goto L11
    }

    public static final void InputChip(final boolean r46, final Function0<Unit> r47, final Function2<? super Composer, ? super Integer, Unit> r48, Modifier r49, boolean r50, Function2<? super Composer, ? super Integer, Unit> r51, Function2<? super Composer, ? super Integer, Unit> r52, Function2<? super Composer, ? super Integer, Unit> r53, Shape r54, SelectableChipColors r55, SelectableChipElevation r56, BorderStroke r57, MutableInteractionSource r58, Composer r59, final int r60, final int r61, final int r62) {
        Composer r11 = r59.startRestartGroup(-1975409271);
        if ((r62 & 1) == 0) goto L6;
        int r1 = r60 | 6;
    L14:
        if ((r62 & 2) == 0) goto L17;
        r1 = r1 | 48;
    L24:
        if ((r62 & 4) == 0) goto L27;
        r1 = r1 | 384;
    L33:
        int r4 = r62 & 8;
        if (r4 == 0) goto L37;
        r1 = r1 | 3072;
    L44:
        int r16 = r62 & 16;
        if (r16 == 0) goto L48;
        r1 = r1 | 24576;
    L55:
        int r18 = r62 & 32;
        if (r18 == 0) goto L58;
        r1 = r1 | 196608;
        Function2<? super Composer, ? super Integer, Unit> r5 = r51;
    L65:
        int r20 = r62 & 64;
        if (r20 == 0) goto L68;
        r1 = r1 | 1572864;
        Function2<? super Composer, ? super Integer, Unit> r6 = r52;
    L75:
        int r7 = r62 & 128;
        if (r7 == 0) goto L78;
        r1 = r1 | 12582912;
        final Function2<? super Composer, ? super Integer, Unit> r8 = r53;
    L86:
        if ((r60 & 100663296) != 0) goto L97;
        if ((r62 & 256) != 0) goto L93;
        if (r11.changed(r54) == false) goto L93;
        int r24 = 67108864;
    L94:
        r1 = r1 | r24;
    L93:
        r24 = 33554432;
    L97:
        if ((r60 & 805306368) != 0) goto L108;
        if ((r62 & 512) != 0) goto L104;
        if (r11.changed(r55) == false) goto L104;
        int r25 = 536870912;
    L105:
        r1 = r1 | r25;
    L104:
        r25 = 268435456;
    L108:
        if ((r61 & 6) == 0) goto L110;
        int r17 = r61;
    L119:
        if ((r61 & 48) != 0) goto L129;
        if ((r62 & 2048) != 0) goto L126;
        if (r11.changed(r57) == false) goto L126;
        int r19 = 32;
    L127:
        r17 = r17 | r19;
    L126:
        r19 = 16;
    L129:
        int r0 = r17;
        int r10 = r62 & 4096;
        if (r10 == 0) goto L133;
        r0 = r0 | 384;
    L141:
        if ((r1 & 306783379) == 306783378) goto L143;
    L146:
        boolean r2 = true;
    L148:
        if (r11.shouldExecute(r2, r1 & 1) == false) goto L227;
        r11.startDefaults();
        if ((r60 & 1) != 0) goto L152;
    L168:
        if (r4 == 0) goto L170;
        Modifier r35 = Modifier.Companion;
    L171:
        if (r16 == 0) goto L173;
        boolean r36 = true;
    L174:
        if (r18 == 0) goto L176;
        Function2<? super Composer, ? super Integer, Unit> r37 = null;
    L177:
        if (r20 == 0) goto L179;
        Function2<? super Composer, ? super Integer, Unit> r38 = null;
    L180:
        if (r7 == 0) goto L182;
        Function2<? super Composer, ? super Integer, Unit> r39 = null;
    L184:
        if ((r62 & 256) == 0) goto L186;
        r1 = r1 & (-234881025);
        Shape r40 = InputChipDefaults.INSTANCE.getShape(r11, 6);
    L188:
        if ((r62 & 512) == 0) goto L190;
        int r42 = r1 & (-1879048193);
        SelectableChipColors r41 = InputChipDefaults.INSTANCE.inputChipColors(r11, 6);
    L192:
        if ((r62 & 1024) == 0) goto L194;
        boolean r12 = true;
        SelectableChipElevation r3 = InputChipDefaults.INSTANCE.m2798inputChipElevationaqJV_2Y(MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, r11, 1572864, 63);
        r0 = r0 & (-15);
    L196:
        if ((r62 & 2048) == 0) goto L198;
        BorderStroke r9 = InputChipDefaults.INSTANCE.m2796inputChipBorder_7El2pE(r36, r46, 0, 0, 0, 0, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, r11, (((r42 >> 12) & 14) | 100663296) | ((r42 << 3) & 112), 252);
        r0 = r0 & (-113);
    L199:
        int r13 = r0;
        if (r10 == 0) goto L202;
        MutableInteractionSource r14 = null;
        r5 = r37;
        r6 = r38;
        int r15 = r42;
    L203:
        r11.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L206;
        ComposerKt.traceEventStart(-1975409271, r15, r13, "androidx.compose.material3.InputChip (Chip.kt:645)");
    L206:
        if (r6 == null) goto L212;
        r11.startReplaceGroup(225175787);
        if (r36 == false) goto L210;
        float r21 = 1.0f;
    L211:
        int r22 = 6;
        Function2 r23 = ComposableLambdaKt.rememberComposableLambda(-570452295, r12, new AnonymousClass1(r21, ShapesKt.getValue(InputChipTokens.INSTANCE.getAvatarShape(), r11, 6), r6), r11, 54);
        r11.endReplaceGroup();
        Function2 r26 = r23;
    L213:
        TextStyle r27 = TypographyKt.getValue(InputChipTokens.INSTANCE.getLabelTextFont(), r11, r22);
        float r29 = InputChipDefaults.INSTANCE.m2794getHeightD9Ej5fM();
        if (r26 == null) goto L216;
        boolean r110 = true;
    L217:
        if (r5 == null) goto L219;
        boolean r28 = true;
    L220:
        if (r39 != null) goto L223;
        r12 = false;
    L223:
        PaddingValues r30 = inputChipPadding(r110, r28, r12);
        int r31 = r15 << 3;
        int r33 = (((((((r15 & 14) | ((r15 >> 6) & 112)) | (r31 & 896)) | ((r15 >> 3) & 7168)) | ((r15 << 6) & 57344)) | (3670016 & r31)) | (234881024 & r31)) | (r31 & 1879048192);
        int r32 = r13 << 3;
        m2418SelectableChipu0RnIRE(r46, r35, r47, r36, r48, r27, r5, r26, r39, r40, r41, r3, r9, r29, r30, r14, r11, r33, (((((r15 >> 27) & 14) | 3072) | (r32 & 112)) | (r32 & 896)) | ((r13 << 9) & 458752));
        if (ComposerKt.isTraceInProgress() == false) goto L226;
        ComposerKt.traceEventEnd();
    L226:
        MutableInteractionSource r111 = r14;
        SelectableChipElevation r112 = r3;
        BorderStroke r113 = r9;
        final Function2<? super Composer, ? super Integer, Unit> r34 = r6;
        final Modifier r43 = r35;
        r8 = r39;
        final Shape r44 = r40;
        final SelectableChipColors r114 = r41;
        final Function2<? super Composer, ? super Integer, Unit> r45 = r5;
        final boolean r63 = r36;
    L228:
        ScopeUpdateScope r115 = r11.endRestartGroup();
        if (r115 == null) goto L232;
        final SelectableChipElevation r116 = r112;
        final BorderStroke r117 = r113;
        final MutableInteractionSource r118 = r111;
        r115.updateScope(new m3(r46, r47, r48, r43, r63, r45, r34, r8, r44, r114, r116, r117, r118, r60, r61, r62));
        return;
    L232:
        return;
    L219:
        r28 = false;
        goto L220
    L216:
        r110 = false;
        goto L217
    L210:
        r21 = InputChipTokens.INSTANCE.getDisabledAvatarOpacity();
        goto L211
    L212:
        r22 = 6;
        r11.startReplaceGroup(225773529);
        r11.endReplaceGroup();
        r26 = null;
        goto L213
    L202:
        r5 = r37;
        r6 = r38;
        r15 = r42;
    L167:
        r14 = r58;
        goto L203
    L198:
        r9 = r57;
        goto L199
    L194:
        r12 = true;
        r3 = r56;
        goto L196
    L190:
        r41 = r55;
        r42 = r1;
        goto L192
    L186:
        r40 = r54;
        goto L188
    L182:
        r39 = r8;
        goto L184
    L179:
        r38 = r6;
        goto L180
    L176:
        r37 = r5;
        goto L177
    L173:
        r36 = r50;
        goto L174
    L170:
        r35 = r49;
        goto L171
    L152:
        if (r11.getDefaultsInvalid() == true) goto L168;
        r11.skipToGroupEnd();
        if ((r62 & 256) == 0) goto L158;
        r1 = r1 & (-234881025);
    L158:
        if ((r62 & 512) == 0) goto L161;
        r1 = r1 & (-1879048193);
    L161:
        if ((r62 & 1024) == 0) goto L164;
        r0 = r0 & (-15);
    L164:
        if ((r62 & 2048) == 0) goto L166;
        r0 = r0 & (-113);
    L166:
        r35 = r49;
        r36 = r50;
        r40 = r54;
        r41 = r55;
        r9 = r57;
        r13 = r0;
        r15 = r1;
        r39 = r8;
        r12 = true;
        r3 = r56;
        goto L167
    L227:
        r11.skipToGroupEnd();
        r43 = r49;
        r44 = r54;
        r114 = r55;
        r112 = r56;
        r113 = r57;
        r111 = r58;
        r34 = r6;
        r45 = r5;
        r63 = r50;
        goto L228
    L143:
        if ((r0 & 147) != 146) goto L146;
        r2 = false;
        goto L148
    L133:
        if ((r61 & 384) != 0) goto L141;
        if (r11.changed(r58) == false) goto L137;
        int r210 = 256;
    L138:
        r0 = r0 | r210;
        goto L141
    L137:
        r210 = 128;
        goto L138
    L110:
        if ((r62 & 1024) != 0) goto L115;
        if (r11.changed(r56) == false) goto L115;
        int r119 = 4;
    L116:
        r17 = r61 | r119;
    L115:
        r119 = 2;
        goto L116
    L78:
        r8 = r53;
        if ((r60 & 12582912) != 0) goto L86;
        if (r11.changedInstance(r8) == false) goto L83;
        int r211 = 8388608;
    L84:
        r1 = r1 | r211;
        goto L86
    L83:
        r211 = 4194304;
        goto L84
    L68:
        r6 = r52;
        if ((r60 & 1572864) != 0) goto L75;
        if (r11.changedInstance(r6) == false) goto L73;
        int r212 = 1048576;
    L74:
        r1 = r1 | r212;
        goto L75
    L73:
        r212 = 524288;
        goto L74
    L58:
        r5 = r51;
        if ((r60 & 196608) != 0) goto L65;
        if (r11.changedInstance(r5) == false) goto L63;
        int r213 = 131072;
    L64:
        r1 = r1 | r213;
        goto L65
    L63:
        r213 = 65536;
        goto L64
    L48:
        if ((r60 & 24576) != 0) goto L55;
        if (r11.changed(r50) == false) goto L52;
        int r120 = 16384;
    L53:
        r1 = r1 | r120;
        goto L55
    L52:
        r120 = 8192;
        goto L53
    L37:
        if ((r60 & 3072) != 0) goto L44;
        if (r11.changed(r49) == false) goto L41;
        int r121 = 2048;
    L42:
        r1 = r1 | r121;
        goto L44
    L41:
        r121 = 1024;
        goto L42
    L27:
        if ((r60 & 384) != 0) goto L33;
        if (r11.changedInstance(r48) == false) goto L31;
        int r64 = 256;
    L32:
        r1 = r1 | r64;
        goto L33
    L31:
        r64 = 128;
        goto L32
    L17:
        if ((r60 & 48) != 0) goto L24;
        if (r11.changedInstance(r47) == false) goto L21;
        int r65 = 32;
    L22:
        r1 = r1 | r65;
        goto L24
    L21:
        r65 = 16;
        goto L22
    L6:
        if ((r60 & 6) == 0) goto L8;
        r1 = r60;
        goto L14
    L8:
        if (r11.changed(r46) == false) goto L10;
        int r66 = 4;
    L11:
        r1 = r66 | r60;
        goto L14
    L10:
        r66 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: Chip-nkUnTEs, reason: not valid java name */
    private static final void m2416ChipnkUnTEs(final Modifier r30, final Function0<Unit> r31, final boolean r32, final Function2<? super Composer, ? super Integer, Unit> r33, final TextStyle r34, final long r35, final Function2<? super Composer, ? super Integer, Unit> r37, final Function2<? super Composer, ? super Integer, Unit> r38, final Shape r39, final ChipColors r40, final ChipElevation r41, final BorderStroke r42, final float r43, final PaddingValues r44, final MutableInteractionSource r45, Composer r46, final int r47, final int r48) {
        Composer r10 = r46.startRestartGroup(892465622);
        int r5 = 2;
        if ((r47 & 6) == 0) goto L5;
        int r3 = r47;
    L10:
        int r7 = 32;
        if ((r47 & 48) == 0) goto L13;
    L17:
        int r16 = 256;
        if ((r47 & 384) == 0) goto L20;
    L24:
        int r18 = 2048;
        if ((r47 & 3072) != 0) goto L32;
        if (r10.changedInstance(r33) == false) goto L29;
        int r20 = 2048;
    L30:
        r3 = r3 | r20;
        goto L32
    L29:
        r20 = 1024;
    L32:
        int r21 = 16384;
        if ((r47 & 24576) != 0) goto L40;
        if (r10.changed(r34) == false) goto L37;
        int r22 = 16384;
    L38:
        r3 = r3 | r22;
        goto L40
    L37:
        r22 = 8192;
    L40:
        int r23 = r3;
        if ((r47 & 196608) != 0) goto L48;
        if (r10.changed(r35) == false) goto L45;
        int r24 = 131072;
    L46:
        r23 = r23 | r24;
        goto L48
    L45:
        r24 = 65536;
    L48:
        if ((r47 & 1572864) != 0) goto L55;
        if (r10.changedInstance(r37) == false) goto L52;
        int r25 = 1048576;
    L53:
        r23 = r23 | r25;
        goto L55
    L52:
        r25 = 524288;
    L55:
        if ((r47 & 12582912) != 0) goto L62;
        if (r10.changedInstance(r38) == false) goto L59;
        int r26 = 8388608;
    L60:
        r23 = r23 | r26;
        goto L62
    L59:
        r26 = 4194304;
    L62:
        if ((r47 & 100663296) != 0) goto L69;
        if (r10.changed(r39) == false) goto L66;
        int r27 = 67108864;
    L67:
        r23 = r23 | r27;
        goto L69
    L66:
        r27 = 33554432;
    L69:
        if ((r47 & 805306368) == 0) goto L71;
    L75:
        int r12 = r23;
        if ((r48 & 6) == 0) goto L78;
        int r6 = r48;
    L83:
        if ((r48 & 48) != 0) goto L90;
        if (r10.changed(r42) == true) goto L88;
        r7 = 16;
    L88:
        r6 = r6 | r7;
    L90:
        if ((r48 & 384) != 0) goto L97;
        if (r10.changed(r43) == true) goto L95;
        r16 = 128;
    L95:
        r6 = r6 | r16;
    L97:
        if ((r48 & 3072) != 0) goto L105;
        if (r10.changed(r44) == true) goto L102;
        r18 = 1024;
    L102:
        r6 = r6 | r18;
    L105:
        if ((r48 & 24576) != 0) goto L112;
        if (r10.changed(r45) == true) goto L110;
        r21 = 8192;
    L110:
        r6 = r6 | r21;
    L112:
        if ((306783379 & r12) == 306783378) goto L114;
    L117:
        boolean r2 = true;
    L119:
        if (r10.shouldExecute(r2, r12 & 1) == true) goto L121;
        Composer r0 = r10;
        r0.skipToGroupEnd();
    L144:
        ScopeUpdateScope r15 = r0.endRestartGroup();
        if (r15 == null) goto L148;
        r15.updateScope(new r3(r30, r31, r32, r33, r34, r35, r37, r38, r39, r40, r41, r42, r43, r44, r45, r47, r48));
        return;
    L148:
        return;
    L121:
        if (ComposerKt.isTraceInProgress() == false) goto L123;
        ComposerKt.traceEventStart(892465622, r12, r6, "androidx.compose.material3.Chip (Chip.kt:1957)");
    L123:
        if (r45 != null) goto L128;
        r10.startReplaceGroup(1596346437);
        Object r4 = r10.rememberedValue();
        if (r4 != Composer.Companion.getEmpty()) goto L127;
        r4 = InteractionSourceKt.MutableInteractionSource();
        r10.updateRememberedValue(r4);
    L127:
        r10.endReplaceGroup();
        MutableInteractionSource r8 = (MutableInteractionSource) r4;
    L129:
        Object r9 = r10.rememberedValue();
        if (r9 != Composer.Companion.getEmpty()) goto L132;
        r9 = new q3();
        r10.updateRememberedValue(r9);
    L132:
        State<Dp> r11 = null;
        Modifier r19 = SemanticsModifierKt.semantics$default(r30, false, (Function1) r9, 1, null);
        long r28 = r40.m2396containerColorvNxB06k$material3(r32);
        if (r41 != null) goto L135;
        r10.startReplaceGroup(1596621344);
    L136:
        r10.endReplaceGroup();
        if (r11 == null) goto L139;
        float r13 = ((Dp) r11.getValue()).unbox-impl();
    L140:
        int r17 = (((r12 >> 15) & 7168) | (((r12 >> 3) & 14) | (r12 & 896))) | ((r6 << 21) & 234881024);
        r0 = r10;
        SurfaceKt.m3216Surfaceo_FOJdg(r31, r19, r32, r39, r28, 0, MenuKt.ClosedAlphaTarget, r13, r42, r8, ComposableLambdaKt.rememberComposableLambda(-70915349, true, new ChipKt$Chip$2(r33, r34, r35, r37, r38, r40, r32, r43, r44), r10, 54), r10, r17, 6, 96);
        if (ComposerKt.isTraceInProgress() == false) goto L144;
        ComposerKt.traceEventEnd();
        goto L144
    L139:
        r13 = Dp.constructor-impl(0);
        goto L140
    L135:
        r10.startReplaceGroup(-1333969407);
        r11 = r41.shadowElevation$material3(r32, r8, r10, ((r12 >> 6) & 14) | ((r6 << 6) & 896));
        goto L136
    L128:
        r10.startReplaceGroup(-1333978926);
        r10.endReplaceGroup();
        r8 = r45;
        goto L129
    L114:
        if ((r6 & 9363) != 9362) goto L117;
        r2 = false;
        goto L119
    L78:
        if (r10.changed(r41) == false) goto L80;
        r5 = 4;
    L80:
        r6 = r5 | r48;
        goto L83
    L71:
        if (r10.changed(r40) == false) goto L73;
        int r29 = 536870912;
    L74:
        r23 = r23 | r29;
        goto L75
    L73:
        r29 = 268435456;
        goto L74
    L20:
        if (r10.changed(r32) == false) goto L22;
        int r14 = 256;
    L23:
        r3 = r3 | r14;
        goto L24
    L22:
        r14 = 128;
        goto L23
    L13:
        if (r10.changedInstance(r31) == false) goto L15;
        int r36 = 32;
    L16:
        r3 = r3 | r36;
        goto L17
    L15:
        r36 = 16;
        goto L16
    L5:
        if (r10.changed(r30) == false) goto L7;
        int r49 = 4;
    L8:
        r3 = r49 | r47;
        goto L10
    L7:
        r49 = 2;
        goto L8
    }

    /* JADX INFO: renamed from: SelectableChip-u0RnIRE, reason: not valid java name */
    private static final void m2418SelectableChipu0RnIRE(final boolean r31, final Modifier r32, final Function0<Unit> r33, final boolean r34, final Function2<? super Composer, ? super Integer, Unit> r35, final TextStyle r36, final Function2<? super Composer, ? super Integer, Unit> r37, final Function2<? super Composer, ? super Integer, Unit> r38, final Function2<? super Composer, ? super Integer, Unit> r39, final Shape r40, final SelectableChipColors r41, final SelectableChipElevation r42, final BorderStroke r43, final float r44, final PaddingValues r45, final MutableInteractionSource r46, Composer r47, final int r48, final int r49) {
        Composer r7 = r47.startRestartGroup(1786844928);
        int r3 = 2;
        if ((r48 & 6) == 0) goto L5;
        int r1 = r48;
    L10:
        int r5 = 32;
        if ((r48 & 48) == 0) goto L13;
    L17:
        int r16 = 256;
        if ((r48 & 384) != 0) goto L25;
        if (r7.changedInstance(r33) == false) goto L22;
        int r18 = 256;
    L23:
        r1 = r1 | r18;
        goto L25
    L22:
        r18 = 128;
    L25:
        int r19 = 2048;
        if ((r48 & 3072) == 0) goto L28;
    L32:
        int r20 = 16384;
        if ((r48 & 24576) != 0) goto L40;
        if (r7.changedInstance(r35) == false) goto L37;
        int r22 = 16384;
    L38:
        r1 = r1 | r22;
        goto L40
    L37:
        r22 = 8192;
    L40:
        int r24 = 131072;
        if ((r48 & 196608) != 0) goto L48;
        if (r7.changed(r36) == false) goto L45;
        int r26 = 131072;
    L46:
        r1 = r1 | r26;
        goto L48
    L45:
        r26 = 65536;
    L48:
        if ((r48 & 1572864) != 0) goto L55;
        if (r7.changedInstance(r37) == false) goto L52;
        int r27 = 1048576;
    L53:
        r1 = r1 | r27;
        goto L55
    L52:
        r27 = 524288;
    L55:
        if ((r48 & 12582912) != 0) goto L62;
        if (r7.changedInstance(r38) == false) goto L59;
        int r28 = 8388608;
    L60:
        r1 = r1 | r28;
        goto L62
    L59:
        r28 = 4194304;
    L62:
        if ((r48 & 100663296) != 0) goto L69;
        if (r7.changedInstance(r39) == false) goto L66;
        int r29 = 67108864;
    L67:
        r1 = r1 | r29;
        goto L69
    L66:
        r29 = 33554432;
    L69:
        if ((r48 & 805306368) != 0) goto L76;
        if (r7.changed(r40) == false) goto L73;
        int r210 = 536870912;
    L74:
        r1 = r1 | r210;
        goto L76
    L73:
        r210 = 268435456;
    L76:
        if ((r49 & 6) == 0) goto L78;
        int r4 = r49;
    L83:
        if ((r49 & 48) != 0) goto L90;
        if (r7.changed(r42) == true) goto L88;
        r5 = 16;
    L88:
        r4 = r4 | r5;
    L90:
        if ((r49 & 384) != 0) goto L98;
        if (r7.changed(r43) == true) goto L95;
        r16 = 128;
    L95:
        r4 = r4 | r16;
    L98:
        if ((r49 & 3072) != 0) goto L106;
        if (r7.changed(r44) == true) goto L103;
        r19 = 1024;
    L103:
        r4 = r4 | r19;
    L106:
        if ((r49 & 24576) != 0) goto L114;
        if (r7.changed(r45) == true) goto L111;
        r20 = 8192;
    L111:
        r4 = r4 | r20;
    L114:
        if ((r49 & 196608) != 0) goto L121;
        if (r7.changed(r46) == true) goto L119;
        r24 = 65536;
    L119:
        r4 = r4 | r24;
    L121:
        if ((r1 & 306783379) == 306783378) goto L123;
    L126:
        boolean r0 = true;
    L128:
        if (r7.shouldExecute(r0, r1 & 1) == true) goto L130;
        Composer r110 = r7;
        r110.skipToGroupEnd();
    L153:
        ScopeUpdateScope r15 = r110.endRestartGroup();
        if (r15 == null) goto L157;
        r15.updateScope(new l3(r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r48, r49));
        return;
    L157:
        return;
    L130:
        if (ComposerKt.isTraceInProgress() == false) goto L132;
        ComposerKt.traceEventStart(1786844928, r1, r4, "androidx.compose.material3.SelectableChip (Chip.kt:2003)");
    L132:
        if (r46 != null) goto L137;
        r7.startReplaceGroup(73215547);
        Object r2 = r7.rememberedValue();
        if (r2 != Composer.Companion.getEmpty()) goto L136;
        r2 = InteractionSourceKt.MutableInteractionSource();
        r7.updateRememberedValue(r2);
    L136:
        r7.endReplaceGroup();
        MutableInteractionSource r6 = (MutableInteractionSource) r2;
    L138:
        Object r8 = r7.rememberedValue();
        if (r8 != Composer.Companion.getEmpty()) goto L141;
        r8 = new k3();
        r7.updateRememberedValue(r8);
    L141:
        State<Dp> r9 = null;
        Modifier r111 = SemanticsModifierKt.semantics$default(r32, false, (Function1) r8, 1, null);
        long r112 = r41.m3101containerColorWaAFU9c$material3(r34, r31);
        if (r42 != null) goto L144;
        r7.startReplaceGroup(73531126);
    L145:
        r7.endReplaceGroup();
        if (r9 == null) goto L148;
        float r10 = ((Dp) r9.getValue()).unbox-impl();
    L149:
        int r11 = r1;
        r110 = r7;
        SurfaceKt.m3214Surfaced85dljk(r31, r33, r111, r34, r40, r112, 0, MenuKt.ClosedAlphaTarget, r10, r43, r6, ComposableLambdaKt.rememberComposableLambda(-990050154, true, new ChipKt$SelectableChip$2(r41, r34, r31, r35, r36, r37, r38, r39, r44, r45), r7, 54), r7, ((((r11 & 14) | ((r11 >> 3) & 112)) | (r11 & 7168)) | ((r11 >> 15) & 57344)) | ((r4 << 21) & 1879048192), 48, 192);
        if (ComposerKt.isTraceInProgress() == false) goto L153;
        ComposerKt.traceEventEnd();
        goto L153
    L148:
        r10 = Dp.constructor-impl(0);
        goto L149
    L144:
        r7.startReplaceGroup(-828912021);
        r9 = r42.shadowElevation$material3(r34, r6, r7, ((r1 >> 9) & 14) | ((r4 << 3) & 896));
        goto L145
    L137:
        r7.startReplaceGroup(-828922852);
        r7.endReplaceGroup();
        r6 = r46;
        goto L138
    L123:
        if ((74899 & r4) != 74898) goto L126;
        r0 = false;
        goto L128
    L78:
        if (r7.changed(r41) == false) goto L80;
        r3 = 4;
    L80:
        r4 = r3 | r49;
        goto L83
    L28:
        if (r7.changed(r34) == false) goto L30;
        int r12 = 2048;
    L31:
        r1 = r1 | r12;
        goto L32
    L30:
        r12 = 1024;
        goto L31
    L13:
        if (r7.changed(r32) == false) goto L15;
        int r13 = 32;
    L16:
        r1 = r1 | r13;
        goto L17
    L15:
        r13 = 16;
        goto L16
    L5:
        if (r7.changed(r31) == false) goto L7;
        int r14 = 4;
    L8:
        r1 = r14 | r48;
        goto L10
    L7:
        r14 = 2;
        goto L8
    }
}
