package androidx.compose.foundation.lazy;

import androidx.autofill.HintConstants;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.OverscrollKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.ScrollableDefaults;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a©\u0001\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042%\b\n\u0010\u0005\u001a\u001f\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u00062%\b\n\u0010\u000b\u001a\u001f\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\u000623\b\u0004\u0010\f\u001a-\u0012\u0004\u0012\u00020\u000e\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0086\b¢\u0006\u0002\u0010\u0011\u001a\u0082\u0001\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042%\b\n\u0010\u0005\u001a\u001f\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u000623\b\u0004\u0010\f\u001a-\u0012\u0004\u0012\u00020\u000e\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0087\b¢\u0006\u0002\u0010\u0012\u001aè\u0001\u0010\u0013\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042:\b\n\u0010\u0005\u001a4\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\r2:\b\u0006\u0010\u000b\u001a4\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\r2H\b\u0004\u0010\f\u001aB\u0012\u0004\u0012\u00020\u000e\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0086\b¢\u0006\u0002\u0010\u0017\u001a¬\u0001\u0010\u0013\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042:\b\n\u0010\u0005\u001a4\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\r2H\b\u0004\u0010\f\u001aB\u0012\u0004\u0012\u00020\u000e\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0087\b¢\u0006\u0002\u0010\u0018\u001a©\u0001\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00192%\b\n\u0010\u0005\u001a\u001f\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u00062%\b\n\u0010\u000b\u001a\u001f\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\u000623\b\u0004\u0010\f\u001a-\u0012\u0004\u0012\u00020\u000e\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0086\b¢\u0006\u0002\u0010\u001a\u001a\u0082\u0001\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00192%\b\n\u0010\u0005\u001a\u001f\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u000623\b\u0004\u0010\f\u001a-\u0012\u0004\u0012\u00020\u000e\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0087\b¢\u0006\u0002\u0010\u001b\u001aè\u0001\u0010\u0013\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00192:\b\n\u0010\u0005\u001a4\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\r2:\b\u0006\u0010\u000b\u001a4\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\r2H\b\u0004\u0010\f\u001aB\u0012\u0004\u0012\u00020\u000e\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0086\b¢\u0006\u0002\u0010\u001c\u001a¬\u0001\u0010\u0013\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00192:\b\n\u0010\u0005\u001a4\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\r2H\b\u0004\u0010\f\u001aB\u0012\u0004\u0012\u00020\u000e\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00010\u0016¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0087\b¢\u0006\u0002\u0010\u001d\u001a\u0082\u0001\u0010\u001e\u001a\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020&2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/2\u0017\u00100\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u00101\u001a\u0082\u0001\u00102\u001a\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u00103\u001a\u0002042\b\b\u0002\u00105\u001a\u0002062\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020&2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/2\u0017\u00100\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u00107\u001av\u00102\u001a\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u00103\u001a\u0002042\b\b\u0002\u00105\u001a\u0002062\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020&2\u0017\u00100\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u00108\u001al\u00102\u001a\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u00103\u001a\u0002042\b\b\u0002\u00105\u001a\u0002062\b\b\u0002\u0010+\u001a\u00020,2\u0017\u00100\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u00109\u001av\u0010\u001e\u001a\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020&2\u0017\u00100\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010:\u001al\u0010\u001e\u001a\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010+\u001a\u00020,2\u0017\u00100\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010;¨\u0006<"}, d2 = {"items", "", "T", "Landroidx/compose/foundation/lazy/LazyListScope;", "", "key", "Lkotlin/Function1;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "item", "", "contentType", "itemContent", "Lkotlin/Function2;", "Landroidx/compose/foundation/lazy/LazyItemScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/lazy/LazyListScope;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "(Landroidx/compose/foundation/lazy/LazyListScope;Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "itemsIndexed", "", "index", "Lkotlin/Function3;", "(Landroidx/compose/foundation/lazy/LazyListScope;Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "(Landroidx/compose/foundation/lazy/LazyListScope;Ljava/util/List;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "", "(Landroidx/compose/foundation/lazy/LazyListScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "(Landroidx/compose/foundation/lazy/LazyListScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;)V", "(Landroidx/compose/foundation/lazy/LazyListScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "(Landroidx/compose/foundation/lazy/LazyListScope;[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function5;)V", "LazyRow", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/lazy/LazyListState;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "reverseLayout", "", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "userScrollEnabled", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "content", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/gestures/FlingBehavior;ZLandroidx/compose/foundation/OverscrollEffect;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "LazyColumn", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/foundation/gestures/FlingBehavior;ZLandroidx/compose/foundation/OverscrollEffect;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/foundation/gestures/FlingBehavior;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/foundation/gestures/FlingBehavior;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/gestures/FlingBehavior;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/layout/Arrangement$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/gestures/FlingBehavior;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class LazyDslKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyDslKt$items$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
    public static final class AnonymousClass1 implements Function1 {
        public static final AnonymousClass1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        public AnonymousClass1() {
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final Void m1080invoke(Object r1) {
            return null;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return m1080invoke(r1);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyDslKt$items$2, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
    public static final class AnonymousClass2 implements Function1<Integer, Object> {
        final /* synthetic */ List<T> $items;
        final /* synthetic */ Function1<T, Object> $key;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(Function1<? super T, ? extends Object> r1, List<? extends T> r2) {
            this.$key = r1;
            this.$items = r2;
        }

        public final Object invoke(int r3) {
            return this.$key.invoke(ListProtector.get(this.$items, r3));
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke(((Number) r1).intValue());
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyDslKt$items$3, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
    public static final class AnonymousClass3 implements Function1<Integer, Object> {
        final /* synthetic */ Function1<T, Object> $contentType;
        final /* synthetic */ List<T> $items;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass3(Function1<? super T, ? extends Object> r1, List<? extends T> r2) {
            this.$contentType = r1;
            this.$items = r2;
        }

        public final Object invoke(int r3) {
            return this.$contentType.invoke(ListProtector.get(this.$items, r3));
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke(((Number) r1).intValue());
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyDslKt$items$4, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
    public static final class AnonymousClass4 implements Function4<LazyItemScope, Integer, Composer, Integer, Unit> {
        final /* synthetic */ Function4<LazyItemScope, T, Composer, Integer, Unit> $itemContent;
        final /* synthetic */ List<T> $items;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass4(Function4<? super LazyItemScope, ? super T, ? super Composer, ? super Integer, Unit> r1, List<? extends T> r2) {
            this.$itemContent = r1;
            this.$items = r2;
        }

        public final void invoke(LazyItemScope r4, int r5, Composer r6, int r7) {
            if ((r7 & 6) == 0) goto L5;
            int r0 = r7;
        L11:
            if ((r7 & 48) != 0) goto L18;
            if (r6.changed(r5) == false) goto L15;
            int r8 = 32;
        L16:
            r0 = r0 | r8;
            goto L18
        L15:
            r8 = 16;
        L18:
            if ((r0 & 147) == 146) goto L20;
            boolean r9 = true;
        L22:
            if (r6.shouldExecute(r9, r0 & 1) == true) goto L24;
            r6.skipToGroupEnd();
            return;
        L24:
            if (ComposerKt.isTraceInProgress() == false) goto L26;
            ComposerKt.traceEventStart(802480018, r0, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
        L26:
            this.$itemContent.invoke(r4, ListProtector.get(this.$items, r5), r6, Integer.valueOf(r0 & 14));
            if (ComposerKt.isTraceInProgress() == false) goto L31;
            ComposerKt.traceEventEnd();
            return;
        L31:
            return;
        L20:
            r9 = false;
            goto L22
        L5:
            if (r6.changed(r4) == false) goto L7;
            int r1 = 4;
        L8:
            r0 = r1 | r7;
            goto L11
        L7:
            r1 = 2;
            goto L8
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3, Object r4) {
            invoke((LazyItemScope) r1, ((Number) r2).intValue(), (Composer) r3, ((Number) r4).intValue());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyDslKt$items$5, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
    public static final class AnonymousClass5 implements Function1 {
        public static final AnonymousClass5 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass5();
        }

        public AnonymousClass5() {
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final Void m1081invoke(Object r1) {
            return null;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return m1081invoke(r1);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyDslKt$items$6, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
    public static final class AnonymousClass6 implements Function1<Integer, Object> {
        final /* synthetic */ T[] $items;
        final /* synthetic */ Function1<T, Object> $key;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass6(Function1<? super T, ? extends Object> r1, T[] r2) {
            this.$key = r1;
            this.$items = r2;
        }

        public final Object invoke(int r3) {
            return this.$key.invoke(this.$items[r3]);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke(((Number) r1).intValue());
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyDslKt$items$7, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
    public static final class AnonymousClass7 implements Function1<Integer, Object> {
        final /* synthetic */ Function1<T, Object> $contentType;
        final /* synthetic */ T[] $items;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass7(Function1<? super T, ? extends Object> r1, T[] r2) {
            this.$contentType = r1;
            this.$items = r2;
        }

        public final Object invoke(int r3) {
            return this.$contentType.invoke(this.$items[r3]);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke(((Number) r1).intValue());
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyDslKt$items$8, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
    public static final class AnonymousClass8 implements Function4<LazyItemScope, Integer, Composer, Integer, Unit> {
        final /* synthetic */ Function4<LazyItemScope, T, Composer, Integer, Unit> $itemContent;
        final /* synthetic */ T[] $items;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass8(Function4<? super LazyItemScope, ? super T, ? super Composer, ? super Integer, Unit> r1, T[] r2) {
            this.$itemContent = r1;
            this.$items = r2;
        }

        public final void invoke(LazyItemScope r4, int r5, Composer r6, int r7) {
            if ((r7 & 6) == 0) goto L5;
            int r0 = r7;
        L11:
            if ((r7 & 48) != 0) goto L18;
            if (r6.changed(r5) == false) goto L15;
            int r8 = 32;
        L16:
            r0 = r0 | r8;
            goto L18
        L15:
            r8 = 16;
        L18:
            if ((r0 & 147) == 146) goto L20;
            boolean r9 = true;
        L22:
            if (r6.shouldExecute(r9, r0 & 1) == true) goto L24;
            r6.skipToGroupEnd();
            return;
        L24:
            if (ComposerKt.isTraceInProgress() == false) goto L26;
            ComposerKt.traceEventStart(-1781742563, r0, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:250)");
        L26:
            this.$itemContent.invoke(r4, this.$items[r5], r6, Integer.valueOf(r0 & 14));
            if (ComposerKt.isTraceInProgress() == false) goto L31;
            ComposerKt.traceEventEnd();
            return;
        L31:
            return;
        L20:
            r9 = false;
            goto L22
        L5:
            if (r6.changed(r4) == false) goto L7;
            int r1 = 4;
        L8:
            r0 = r1 | r7;
            goto L11
        L7:
            r1 = 2;
            goto L8
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3, Object r4) {
            invoke((LazyItemScope) r1, ((Number) r2).intValue(), (Composer) r3, ((Number) r4).intValue());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyDslKt$itemsIndexed$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
    public static final class C01732 implements Function1<Integer, Object> {
        final /* synthetic */ List<T> $items;
        final /* synthetic */ Function2<Integer, T, Object> $key;

        /* JADX WARN: Multi-variable type inference failed */
        public C01732(Function2<? super Integer, ? super T, ? extends Object> r1, List<? extends T> r2) {
            this.$key = r1;
            this.$items = r2;
        }

        public final Object invoke(int r4) {
            return this.$key.invoke(Integer.valueOf(r4), ListProtector.get(this.$items, r4));
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke(((Number) r1).intValue());
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyDslKt$itemsIndexed$3, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
    public static final class C01743 implements Function1<Integer, Object> {
        final /* synthetic */ Function2<Integer, T, Object> $contentType;
        final /* synthetic */ List<T> $items;

        /* JADX WARN: Multi-variable type inference failed */
        public C01743(Function2<? super Integer, ? super T, ? extends Object> r1, List<? extends T> r2) {
            this.$contentType = r1;
            this.$items = r2;
        }

        public final Object invoke(int r4) {
            return this.$contentType.invoke(Integer.valueOf(r4), ListProtector.get(this.$items, r4));
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke(((Number) r1).intValue());
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyDslKt$itemsIndexed$4, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
    public static final class C01754 implements Function4<LazyItemScope, Integer, Composer, Integer, Unit> {
        final /* synthetic */ Function5<LazyItemScope, Integer, T, Composer, Integer, Unit> $itemContent;
        final /* synthetic */ List<T> $items;

        /* JADX WARN: Multi-variable type inference failed */
        public C01754(Function5<? super LazyItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> r1, List<? extends T> r2) {
            this.$itemContent = r1;
            this.$items = r2;
        }

        public final void invoke(LazyItemScope r10, int r11, Composer r12, int r13) {
            if ((r13 & 6) == 0) goto L5;
            int r0 = r13;
        L11:
            if ((r13 & 48) != 0) goto L18;
            if (r12.changed(r11) == false) goto L15;
            int r14 = 32;
        L16:
            r0 = r0 | r14;
            goto L18
        L15:
            r14 = 16;
        L18:
            if ((r0 & 147) == 146) goto L20;
            boolean r15 = true;
        L22:
            if (r12.shouldExecute(r15, r0 & 1) == true) goto L24;
            r12.skipToGroupEnd();
            return;
        L24:
            if (ComposerKt.isTraceInProgress() == false) goto L26;
            ComposerKt.traceEventStart(2039820996, r0, -1, "androidx.compose.foundation.lazy.itemsIndexed.<anonymous> (LazyDsl.kt:214)");
        L26:
            this.$itemContent.invoke(r10, Integer.valueOf(r11), ListProtector.get(this.$items, r11), r12, Integer.valueOf((r0 & 14) | (r0 & 112)));
            if (ComposerKt.isTraceInProgress() == false) goto L31;
            ComposerKt.traceEventEnd();
            return;
        L31:
            return;
        L20:
            r15 = false;
            goto L22
        L5:
            if (r12.changed(r10) == false) goto L7;
            int r1 = 4;
        L8:
            r0 = r1 | r13;
            goto L11
        L7:
            r1 = 2;
            goto L8
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3, Object r4) {
            invoke((LazyItemScope) r1, ((Number) r2).intValue(), (Composer) r3, ((Number) r4).intValue());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyDslKt$itemsIndexed$6, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
    public static final class C01776 implements Function1<Integer, Object> {
        final /* synthetic */ T[] $items;
        final /* synthetic */ Function2<Integer, T, Object> $key;

        /* JADX WARN: Multi-variable type inference failed */
        public C01776(Function2<? super Integer, ? super T, ? extends Object> r1, T[] r2) {
            this.$key = r1;
            this.$items = r2;
        }

        public final Object invoke(int r4) {
            return this.$key.invoke(Integer.valueOf(r4), this.$items[r4]);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke(((Number) r1).intValue());
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyDslKt$itemsIndexed$7, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
    public static final class C01787 implements Function1<Integer, Object> {
        final /* synthetic */ Function2<Integer, T, Object> $contentType;
        final /* synthetic */ T[] $items;

        /* JADX WARN: Multi-variable type inference failed */
        public C01787(Function2<? super Integer, ? super T, ? extends Object> r1, T[] r2) {
            this.$contentType = r1;
            this.$items = r2;
        }

        public final Object invoke(int r4) {
            return this.$contentType.invoke(Integer.valueOf(r4), this.$items[r4]);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke(((Number) r1).intValue());
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyDslKt$itemsIndexed$8, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
    public static final class C01798 implements Function4<LazyItemScope, Integer, Composer, Integer, Unit> {
        final /* synthetic */ Function5<LazyItemScope, Integer, T, Composer, Integer, Unit> $itemContent;
        final /* synthetic */ T[] $items;

        /* JADX WARN: Multi-variable type inference failed */
        public C01798(Function5<? super LazyItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> r1, T[] r2) {
            this.$itemContent = r1;
            this.$items = r2;
        }

        public final void invoke(LazyItemScope r10, int r11, Composer r12, int r13) {
            if ((r13 & 6) == 0) goto L5;
            int r0 = r13;
        L11:
            if ((r13 & 48) != 0) goto L18;
            if (r12.changed(r11) == false) goto L15;
            int r14 = 32;
        L16:
            r0 = r0 | r14;
            goto L18
        L15:
            r14 = 16;
        L18:
            if ((r0 & 147) == 146) goto L20;
            boolean r15 = true;
        L22:
            if (r12.shouldExecute(r15, r0 & 1) == true) goto L24;
            r12.skipToGroupEnd();
            return;
        L24:
            if (ComposerKt.isTraceInProgress() == false) goto L26;
            ComposerKt.traceEventStart(1763000017, r0, -1, "androidx.compose.foundation.lazy.itemsIndexed.<anonymous> (LazyDsl.kt:286)");
        L26:
            this.$itemContent.invoke(r10, Integer.valueOf(r11), this.$items[r11], r12, Integer.valueOf((r0 & 14) | (r0 & 112)));
            if (ComposerKt.isTraceInProgress() == false) goto L31;
            ComposerKt.traceEventEnd();
            return;
        L31:
            return;
        L20:
            r15 = false;
            goto L22
        L5:
            if (r12.changed(r10) == false) goto L7;
            int r1 = 4;
        L8:
            r0 = r1 | r13;
            goto L11
        L7:
            r1 = 2;
            goto L8
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3, Object r4) {
            invoke((LazyItemScope) r1, ((Number) r2).intValue(), (Composer) r3, ((Number) r4).intValue());
            return Unit.INSTANCE;
        }
    }

    private static final Unit LazyColumn$lambda$1(Modifier r14, LazyListState r15, PaddingValues r16, boolean r17, Arrangement.Vertical r18, Alignment.Horizontal r19, FlingBehavior r20, boolean r21, OverscrollEffect r22, Function1 r23, int r24, int r25, Composer r26, int r27) {
        LazyColumn(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r26, RecomposeScopeImplKt.updateChangedFlags(r24 | 1), r25);
        return Unit.INSTANCE;
    }

    private static final Unit LazyColumn$lambda$2(Modifier r13, LazyListState r14, PaddingValues r15, boolean r16, Arrangement.Vertical r17, Alignment.Horizontal r18, FlingBehavior r19, boolean r20, Function1 r21, int r22, int r23, Composer r24, int r25) {
        LazyColumn(r13, r14, r15, r16, r17, r18, r19, r20, r21, r24, RecomposeScopeImplKt.updateChangedFlags(r22 | 1), r23);
        return Unit.INSTANCE;
    }

    private static final Unit LazyColumn$lambda$3(Modifier r12, LazyListState r13, PaddingValues r14, boolean r15, Arrangement.Vertical r16, Alignment.Horizontal r17, FlingBehavior r18, Function1 r19, int r20, int r21, Composer r22, int r23) {
        LazyColumn(r12, r13, r14, r15, r16, r17, r18, r19, r22, RecomposeScopeImplKt.updateChangedFlags(r20 | 1), r21);
        return Unit.INSTANCE;
    }

    private static final Unit LazyRow$lambda$0(Modifier r14, LazyListState r15, PaddingValues r16, boolean r17, Arrangement.Horizontal r18, Alignment.Vertical r19, FlingBehavior r20, boolean r21, OverscrollEffect r22, Function1 r23, int r24, int r25, Composer r26, int r27) {
        LazyRow(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r26, RecomposeScopeImplKt.updateChangedFlags(r24 | 1), r25);
        return Unit.INSTANCE;
    }

    private static final Unit LazyRow$lambda$4(Modifier r13, LazyListState r14, PaddingValues r15, boolean r16, Arrangement.Horizontal r17, Alignment.Vertical r18, FlingBehavior r19, boolean r20, Function1 r21, int r22, int r23, Composer r24, int r25) {
        LazyRow(r13, r14, r15, r16, r17, r18, r19, r20, r21, r24, RecomposeScopeImplKt.updateChangedFlags(r22 | 1), r23);
        return Unit.INSTANCE;
    }

    private static final Unit LazyRow$lambda$5(Modifier r12, LazyListState r13, PaddingValues r14, boolean r15, Arrangement.Horizontal r16, Alignment.Vertical r17, FlingBehavior r18, Function1 r19, int r20, int r21, Composer r22, int r23) {
        LazyRow(r12, r13, r14, r15, r16, r17, r18, r19, r22, RecomposeScopeImplKt.updateChangedFlags(r20 | 1), r21);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(Modifier r0, LazyListState r1, PaddingValues r2, boolean r3, Arrangement.Vertical r4, Alignment.Horizontal r5, FlingBehavior r6, Function1 r7, int r8, int r9, Composer r10, int r11) {
        return LazyColumn$lambda$3(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
    }

    public static /* synthetic */ Unit b(Modifier r0, LazyListState r1, PaddingValues r2, boolean r3, Arrangement.Vertical r4, Alignment.Horizontal r5, FlingBehavior r6, boolean r7, Function1 r8, int r9, int r10, Composer r11, int r12) {
        return LazyColumn$lambda$2(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12);
    }

    public static /* synthetic */ Unit c(Modifier r0, LazyListState r1, PaddingValues r2, boolean r3, Arrangement.Horizontal r4, Alignment.Vertical r5, FlingBehavior r6, boolean r7, Function1 r8, int r9, int r10, Composer r11, int r12) {
        return LazyRow$lambda$4(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12);
    }

    public static /* synthetic */ Unit d(Modifier r0, LazyListState r1, PaddingValues r2, boolean r3, Arrangement.Vertical r4, Alignment.Horizontal r5, FlingBehavior r6, boolean r7, OverscrollEffect r8, Function1 r9, int r10, int r11, Composer r12, int r13) {
        return LazyColumn$lambda$1(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
    }

    public static /* synthetic */ Unit e(Modifier r0, LazyListState r1, PaddingValues r2, boolean r3, Arrangement.Horizontal r4, Alignment.Vertical r5, FlingBehavior r6, boolean r7, OverscrollEffect r8, Function1 r9, int r10, int r11, Composer r12, int r13) {
        return LazyRow$lambda$0(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
    }

    public static /* synthetic */ Unit f(Modifier r0, LazyListState r1, PaddingValues r2, boolean r3, Arrangement.Horizontal r4, Alignment.Vertical r5, FlingBehavior r6, Function1 r7, int r8, int r9, Composer r10, int r11) {
        return LazyRow$lambda$5(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    public static final /* synthetic */ <T> void items(LazyListScope r3, List<? extends T> r4, Function1<? super T, ? extends Object> r5, Function4<? super LazyItemScope, ? super T, ? super Composer, ? super Integer, Unit> r6) {
        AnonymousClass1 r0 = AnonymousClass1.INSTANCE;
        int r1 = r4.size();
        if (r5 == null) goto L5;
        AnonymousClass2 r2 = new AnonymousClass2(r5, r4);
    L6:
        r3.items(r1, r2, new AnonymousClass3(r0, r4), ComposableLambdaKt.composableLambdaInstance(802480018, true, new AnonymousClass4(r6, r4)));
        return;
    L5:
        r2 = null;
        goto L6
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    public static final /* synthetic */ <T> void itemsIndexed(LazyListScope r3, List<? extends T> r4, Function2<? super Integer, ? super T, ? extends Object> r5, Function5<? super LazyItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> r6) {
        int r0 = r4.size();
        if (r5 == null) goto L5;
        C01732 r1 = new C01732(r5, r4);
    L6:
        r3.items(r0, r1, new LazyDslKt$itemsIndexed$$inlined$itemsIndexed$default$1(r4), ComposableLambdaKt.composableLambdaInstance(2039820996, true, new C01754(r6, r4)));
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    public static final /* synthetic */ <T> void items(LazyListScope r3, T[] r4, Function1<? super T, ? extends Object> r5, Function4<? super LazyItemScope, ? super T, ? super Composer, ? super Integer, Unit> r6) {
        AnonymousClass5 r0 = AnonymousClass5.INSTANCE;
        int r1 = r4.length;
        if (r5 == null) goto L5;
        AnonymousClass6 r2 = new AnonymousClass6(r5, r4);
    L6:
        r3.items(r1, r2, new AnonymousClass7(r0, r4), ComposableLambdaKt.composableLambdaInstance(-1781742563, true, new AnonymousClass8(r6, r4)));
        return;
    L5:
        r2 = null;
        goto L6
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    public static final /* synthetic */ <T> void itemsIndexed(LazyListScope r3, T[] r4, Function2<? super Integer, ? super T, ? extends Object> r5, Function5<? super LazyItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> r6) {
        int r0 = r4.length;
        if (r5 == null) goto L5;
        C01776 r1 = new C01776(r5, r4);
    L6:
        r3.items(r0, r1, new LazyDslKt$itemsIndexed$$inlined$itemsIndexed$default$2(r4), ComposableLambdaKt.composableLambdaInstance(1763000017, true, new C01798(r6, r4)));
        return;
    L5:
        r1 = null;
        goto L6
    }

    public static final <T> void items(LazyListScope r2, List<? extends T> r3, Function1<? super T, ? extends Object> r4, Function1<? super T, ? extends Object> r5, Function4<? super LazyItemScope, ? super T, ? super Composer, ? super Integer, Unit> r6) {
        int r0 = r3.size();
        if (r4 == null) goto L5;
        AnonymousClass2 r1 = new AnonymousClass2(r4, r3);
    L6:
        r2.items(r0, r1, new AnonymousClass3(r5, r3), ComposableLambdaKt.composableLambdaInstance(802480018, true, new AnonymousClass4(r6, r3)));
        return;
    L5:
        r1 = null;
        goto L6
    }

    public static final <T> void itemsIndexed(LazyListScope r2, List<? extends T> r3, Function2<? super Integer, ? super T, ? extends Object> r4, Function2<? super Integer, ? super T, ? extends Object> r5, Function5<? super LazyItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> r6) {
        int r0 = r3.size();
        if (r4 == null) goto L5;
        C01732 r1 = new C01732(r4, r3);
    L6:
        r2.items(r0, r1, new C01743(r5, r3), ComposableLambdaKt.composableLambdaInstance(2039820996, true, new C01754(r6, r3)));
        return;
    L5:
        r1 = null;
        goto L6
    }

    public static final <T> void items(LazyListScope r2, T[] r3, Function1<? super T, ? extends Object> r4, Function1<? super T, ? extends Object> r5, Function4<? super LazyItemScope, ? super T, ? super Composer, ? super Integer, Unit> r6) {
        int r0 = r3.length;
        if (r4 == null) goto L5;
        AnonymousClass6 r1 = new AnonymousClass6(r4, r3);
    L6:
        r2.items(r0, r1, new AnonymousClass7(r5, r3), ComposableLambdaKt.composableLambdaInstance(-1781742563, true, new AnonymousClass8(r6, r3)));
        return;
    L5:
        r1 = null;
        goto L6
    }

    public static final <T> void itemsIndexed(LazyListScope r2, T[] r3, Function2<? super Integer, ? super T, ? extends Object> r4, Function2<? super Integer, ? super T, ? extends Object> r5, Function5<? super LazyItemScope, ? super Integer, ? super T, ? super Composer, ? super Integer, Unit> r6) {
        int r0 = r3.length;
        if (r4 == null) goto L5;
        C01776 r1 = new C01776(r4, r3);
    L6:
        r2.items(r0, r1, new C01787(r5, r3), ComposableLambdaKt.composableLambdaInstance(1763000017, true, new C01798(r6, r3)));
        return;
    L5:
        r1 = null;
        goto L6
    }

    public static /* synthetic */ void items$default(LazyListScope r1, List r2, Function1 r3, Function4 r4, int r5, Object r6) {
        AnonymousClass2 r7 = null;
        if ((r5 & 2) == 0) goto L5;
        r3 = null;
    L5:
        AnonymousClass1 r8 = AnonymousClass1.INSTANCE;
        int r0 = r2.size();
        if (r3 == null) goto L8;
        r7 = new AnonymousClass2(r3, r2);
    L8:
        r1.items(r0, r7, new AnonymousClass3(r8, r2), ComposableLambdaKt.composableLambdaInstance(802480018, true, new AnonymousClass4(r4, r2)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyListScope r1, List r2, Function2 r3, Function5 r4, int r5, Object r6) {
        C01732 r7 = null;
        if ((r5 & 2) == 0) goto L5;
        r3 = null;
    L5:
        int r8 = r2.size();
        if (r3 == null) goto L8;
        r7 = new C01732(r3, r2);
    L8:
        r1.items(r8, r7, new LazyDslKt$itemsIndexed$$inlined$itemsIndexed$default$1(r2), ComposableLambdaKt.composableLambdaInstance(2039820996, true, new C01754(r4, r2)));
    }

    public static /* synthetic */ void items$default(LazyListScope r1, Object[] r2, Function1 r3, Function4 r4, int r5, Object r6) {
        AnonymousClass6 r7 = null;
        if ((r5 & 2) == 0) goto L5;
        r3 = null;
    L5:
        AnonymousClass5 r8 = AnonymousClass5.INSTANCE;
        int r0 = r2.length;
        if (r3 == null) goto L8;
        r7 = new AnonymousClass6(r3, r2);
    L8:
        r1.items(r0, r7, new AnonymousClass7(r8, r2), ComposableLambdaKt.composableLambdaInstance(-1781742563, true, new AnonymousClass8(r4, r2)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyListScope r1, Object[] r2, Function2 r3, Function5 r4, int r5, Object r6) {
        C01776 r7 = null;
        if ((r5 & 2) == 0) goto L5;
        r3 = null;
    L5:
        int r8 = r2.length;
        if (r3 == null) goto L8;
        r7 = new C01776(r3, r2);
    L8:
        r1.items(r8, r7, new LazyDslKt$itemsIndexed$$inlined$itemsIndexed$default$2(r2), ComposableLambdaKt.composableLambdaInstance(1763000017, true, new C01798(r4, r2)));
    }

    public static /* synthetic */ void items$default(LazyListScope r1, List r2, Function1 r3, Function1 r4, Function4 r5, int r6, Object r7) {
        AnonymousClass2 r0 = null;
        if ((r6 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r6 & 4) == 0) goto L8;
        r4 = AnonymousClass1.INSTANCE;
    L8:
        int r8 = r2.size();
        if (r3 == null) goto L11;
        r0 = new AnonymousClass2(r3, r2);
    L11:
        r1.items(r8, r0, new AnonymousClass3(r4, r2), ComposableLambdaKt.composableLambdaInstance(802480018, true, new AnonymousClass4(r5, r2)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyListScope r1, List r2, Function2 r3, Function2 r4, Function5 r5, int r6, Object r7) {
        C01732 r0 = null;
        if ((r6 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r6 & 4) == 0) goto L8;
        r4 = C01721.INSTANCE;
    L8:
        int r8 = r2.size();
        if (r3 == null) goto L11;
        r0 = new C01732(r3, r2);
    L11:
        r1.items(r8, r0, new C01743(r4, r2), ComposableLambdaKt.composableLambdaInstance(2039820996, true, new C01754(r5, r2)));
    }

    public static /* synthetic */ void items$default(LazyListScope r1, Object[] r2, Function1 r3, Function1 r4, Function4 r5, int r6, Object r7) {
        AnonymousClass6 r0 = null;
        if ((r6 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r6 & 4) == 0) goto L8;
        r4 = AnonymousClass5.INSTANCE;
    L8:
        int r8 = r2.length;
        if (r3 == null) goto L11;
        r0 = new AnonymousClass6(r3, r2);
    L11:
        r1.items(r8, r0, new AnonymousClass7(r4, r2), ComposableLambdaKt.composableLambdaInstance(-1781742563, true, new AnonymousClass8(r5, r2)));
    }

    public static /* synthetic */ void itemsIndexed$default(LazyListScope r1, Object[] r2, Function2 r3, Function2 r4, Function5 r5, int r6, Object r7) {
        C01776 r0 = null;
        if ((r6 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r6 & 4) == 0) goto L8;
        r4 = C01765.INSTANCE;
    L8:
        int r8 = r2.length;
        if (r3 == null) goto L11;
        r0 = new C01776(r3, r2);
    L11:
        r1.items(r8, r0, new C01787(r4, r2), ComposableLambdaKt.composableLambdaInstance(1763000017, true, new C01798(r5, r2)));
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    public static final /* synthetic */ void LazyColumn(Modifier r24, LazyListState r25, PaddingValues r26, boolean r27, Arrangement.Vertical r28, Alignment.Horizontal r29, FlingBehavior r30, final Function1 r31, Composer r32, final int r33, final int r34) {
        Composer r1 = r32.startRestartGroup(-563353797);
        int r2 = r34 & 1;
        if (r2 == 0) goto L6;
        int r4 = r33 | 6;
    L14:
        if ((r33 & 48) != 0) goto L24;
        if ((r34 & 2) != 0) goto L21;
        if (r1.changed(r25) == false) goto L21;
        int r6 = 32;
    L22:
        r4 = r4 | r6;
    L21:
        r6 = 16;
    L24:
        int r7 = r34 & 4;
        if (r7 == 0) goto L28;
        r4 = r4 | 384;
    L34:
        PaddingValues r8 = r26;
    L35:
        int r9 = r34 & 8;
        if (r9 == 0) goto L39;
        r4 = r4 | 3072;
    L45:
        boolean r11 = r27;
    L47:
        if ((r33 & 24576) == 0) goto L49;
        Arrangement.Vertical r12 = r28;
    L57:
        int r13 = r34 & 32;
        if (r13 == 0) goto L61;
        r4 = r4 | 196608;
    L67:
        Alignment.Horizontal r14 = r29;
    L69:
        if ((1572864 & r33) == 0) goto L71;
        FlingBehavior r15 = r30;
    L80:
        if ((r34 & 128) == 0) goto L83;
        r4 = r4 | 12582912;
    L91:
        if ((r4 & 4793491) == 4793490) goto L93;
        boolean r0 = true;
    L95:
        if (r1.shouldExecute(r0, r4 & 1) == false) goto L144;
        r1.startDefaults();
        if ((r33 & 1) != 0) goto L99;
    L113:
        if (r2 == 0) goto L115;
        Modifier r3 = Modifier.Companion;
    L117:
        if ((r34 & 2) == 0) goto L119;
        int r5 = 0;
        LazyListState r10 = LazyListStateKt.rememberLazyListState(0, 0, r1, 0, 3);
        r4 = r4 & (-113);
    L120:
        if (r7 == 0) goto L122;
        PaddingValues r16 = PaddingKt.m953PaddingValues0680j_4(Dp.constructor-impl(r5));
    L123:
        if (r9 == 0) goto L126;
        r11 = false;
    L126:
        if ((r34 & 16) == 0) goto L132;
        Arrangement r17 = Arrangement.INSTANCE;
        if (r11 == true) goto L130;
        Arrangement.Vertical r18 = r17.getTop();
    L131:
        r4 = r4 & (-57345);
        r12 = r18;
        goto L132
    L130:
        r18 = r17.getBottom();
    L132:
        if (r13 == 0) goto L135;
        r14 = Alignment.Companion.getStart();
    L135:
        if ((r34 & 64) != 0) goto L136;
    L111:
        boolean r19 = r11;
        Alignment.Horizontal r20 = r14;
        FlingBehavior r21 = r15;
    L112:
        int r110 = r4;
        Arrangement.Vertical r22 = r12;
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L140;
        ComposerKt.traceEventStart(-563353797, r110, -1, "androidx.compose.foundation.lazy.LazyColumn (LazyDsl.kt:455)");
    L140:
        LazyColumn(r3, r10, r16, r19, r22, r20, r21, true, null, r31, r1, ((((((((r110 & 14) | 12582912) | (r110 & 112)) | (r110 & 896)) | (r110 & 7168)) | (57344 & r110)) | (458752 & r110)) | (3670016 & r110)) | ((r110 << 6) & 1879048192), 256);
        if (ComposerKt.isTraceInProgress() == false) goto L143;
        ComposerKt.traceEventEnd();
    L143:
        final Arrangement.Vertical r23 = r22;
        final boolean r35 = r19;
        LazyListState r36 = r10;
        Modifier r37 = r3;
    L145:
        ScopeUpdateScope r111 = r1.endRestartGroup();
        if (r111 == null) goto L149;
        final Modifier r38 = r37;
        final LazyListState r39 = r36;
        final PaddingValues r40 = r16;
        final Alignment.Horizontal r41 = r20;
        final FlingBehavior r42 = r21;
        r111.updateScope(new f(r38, r39, r40, r35, r23, r41, r42, r31, r33, r34));
        return;
    L149:
        return;
    L136:
        r4 = r4 & (-3670017);
        r21 = ScrollableDefaults.INSTANCE.flingBehavior(r1, 6);
        r19 = r11;
        r20 = r14;
        goto L112
    L122:
        r16 = r8;
        goto L123
    L119:
        r5 = 0;
        r10 = r25;
        goto L120
    L115:
        r3 = r24;
        goto L117
    L99:
        if (r1.getDefaultsInvalid() == true) goto L113;
        r1.skipToGroupEnd();
        if ((r34 & 2) == 0) goto L105;
        r4 = r4 & (-113);
    L105:
        if ((r34 & 16) == 0) goto L108;
        r4 = r4 & (-57345);
    L108:
        if ((r34 & 64) == 0) goto L110;
        r4 = r4 & (-3670017);
    L110:
        r3 = r24;
        r10 = r25;
        r16 = r8;
        goto L111
    L144:
        r1.skipToGroupEnd();
        r37 = r24;
        r36 = r25;
        r16 = r8;
        r35 = r11;
        r23 = r12;
        r20 = r14;
        r21 = r15;
        goto L145
    L93:
        r0 = false;
        goto L95
    L83:
        if ((r33 & 12582912) != 0) goto L91;
        if (r1.changedInstance(r31) == false) goto L87;
        int r112 = 8388608;
    L88:
        r4 = r4 | r112;
        goto L91
    L87:
        r112 = 4194304;
        goto L88
    L71:
        if ((r34 & 64) != 0) goto L75;
        r15 = r30;
        if (r1.changed(r15) == false) goto L76;
        int r113 = 1048576;
    L77:
        r4 = r4 | r113;
    L76:
        r113 = 524288;
        goto L77
    L75:
        r15 = r30;
        goto L76
    L61:
        if ((196608 & r33) != 0) goto L67;
        r14 = r29;
        if (r1.changed(r14) == false) goto L65;
        int r114 = 131072;
    L66:
        r4 = r4 | r114;
        goto L69
    L65:
        r114 = 65536;
        goto L66
    L49:
        if ((r34 & 16) != 0) goto L53;
        r12 = r28;
        if (r1.changed(r12) == false) goto L54;
        int r115 = 16384;
    L55:
        r4 = r4 | r115;
    L54:
        r115 = 8192;
        goto L55
    L53:
        r12 = r28;
        goto L54
    L39:
        if ((r33 & 3072) != 0) goto L45;
        r11 = r27;
        if (r1.changed(r11) == false) goto L43;
        int r116 = 2048;
    L44:
        r4 = r4 | r116;
        goto L47
    L43:
        r116 = 1024;
        goto L44
    L28:
        if ((r33 & 384) != 0) goto L34;
        r8 = r26;
        if (r1.changed(r8) == false) goto L32;
        int r43 = 256;
    L33:
        r4 = r4 | r43;
        goto L35
    L32:
        r43 = 128;
        goto L33
    L6:
        if ((r33 & 6) == 0) goto L8;
        r4 = r33;
        goto L14
    L8:
        if (r1.changed(r24) == false) goto L10;
        int r44 = 4;
    L11:
        r4 = r44 | r33;
        goto L14
    L10:
        r44 = 2;
        goto L11
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    public static final /* synthetic */ void LazyRow(Modifier r24, LazyListState r25, PaddingValues r26, boolean r27, Arrangement.Horizontal r28, Alignment.Vertical r29, FlingBehavior r30, final Function1 r31, Composer r32, final int r33, final int r34) {
        Composer r1 = r32.startRestartGroup(407929823);
        int r2 = r34 & 1;
        if (r2 == 0) goto L6;
        int r4 = r33 | 6;
    L14:
        if ((r33 & 48) != 0) goto L24;
        if ((r34 & 2) != 0) goto L21;
        if (r1.changed(r25) == false) goto L21;
        int r6 = 32;
    L22:
        r4 = r4 | r6;
    L21:
        r6 = 16;
    L24:
        int r7 = r34 & 4;
        if (r7 == 0) goto L28;
        r4 = r4 | 384;
    L34:
        PaddingValues r8 = r26;
    L35:
        int r9 = r34 & 8;
        if (r9 == 0) goto L39;
        r4 = r4 | 3072;
    L45:
        boolean r11 = r27;
    L47:
        if ((r33 & 24576) == 0) goto L49;
        Arrangement.Horizontal r12 = r28;
    L57:
        int r13 = r34 & 32;
        if (r13 == 0) goto L61;
        r4 = r4 | 196608;
    L67:
        Alignment.Vertical r14 = r29;
    L69:
        if ((1572864 & r33) == 0) goto L71;
        FlingBehavior r15 = r30;
    L80:
        if ((r34 & 128) == 0) goto L83;
        r4 = r4 | 12582912;
    L91:
        if ((r4 & 4793491) == 4793490) goto L93;
        boolean r0 = true;
    L95:
        if (r1.shouldExecute(r0, r4 & 1) == false) goto L144;
        r1.startDefaults();
        if ((r33 & 1) != 0) goto L99;
    L113:
        if (r2 == 0) goto L115;
        Modifier r3 = Modifier.Companion;
    L117:
        if ((r34 & 2) == 0) goto L119;
        int r5 = 0;
        LazyListState r10 = LazyListStateKt.rememberLazyListState(0, 0, r1, 0, 3);
        r4 = r4 & (-113);
    L120:
        if (r7 == 0) goto L122;
        PaddingValues r16 = PaddingKt.m953PaddingValues0680j_4(Dp.constructor-impl(r5));
    L123:
        if (r9 == 0) goto L126;
        r11 = false;
    L126:
        if ((r34 & 16) == 0) goto L132;
        Arrangement r17 = Arrangement.INSTANCE;
        if (r11 == true) goto L130;
        Arrangement.Horizontal r18 = r17.getStart();
    L131:
        r4 = r4 & (-57345);
        r12 = r18;
        goto L132
    L130:
        r18 = r17.getEnd();
    L132:
        if (r13 == 0) goto L135;
        r14 = Alignment.Companion.getTop();
    L135:
        if ((r34 & 64) != 0) goto L136;
    L111:
        boolean r19 = r11;
        Alignment.Vertical r20 = r14;
        FlingBehavior r21 = r15;
    L112:
        int r110 = r4;
        Arrangement.Horizontal r22 = r12;
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L140;
        ComposerKt.traceEventStart(407929823, r110, -1, "androidx.compose.foundation.lazy.LazyRow (LazyDsl.kt:509)");
    L140:
        LazyRow(r3, r10, r16, r19, r22, r20, r21, true, null, r31, r1, ((((((((r110 & 14) | 12582912) | (r110 & 112)) | (r110 & 896)) | (r110 & 7168)) | (57344 & r110)) | (458752 & r110)) | (3670016 & r110)) | ((r110 << 6) & 1879048192), 256);
        if (ComposerKt.isTraceInProgress() == false) goto L143;
        ComposerKt.traceEventEnd();
    L143:
        final Arrangement.Horizontal r23 = r22;
        final boolean r35 = r19;
        LazyListState r36 = r10;
        Modifier r37 = r3;
    L145:
        ScopeUpdateScope r111 = r1.endRestartGroup();
        if (r111 == null) goto L149;
        final Modifier r38 = r37;
        final LazyListState r39 = r36;
        final PaddingValues r40 = r16;
        final Alignment.Vertical r41 = r20;
        final FlingBehavior r42 = r21;
        r111.updateScope(new d(r38, r39, r40, r35, r23, r41, r42, r31, r33, r34));
        return;
    L149:
        return;
    L136:
        r4 = r4 & (-3670017);
        r21 = ScrollableDefaults.INSTANCE.flingBehavior(r1, 6);
        r19 = r11;
        r20 = r14;
        goto L112
    L122:
        r16 = r8;
        goto L123
    L119:
        r5 = 0;
        r10 = r25;
        goto L120
    L115:
        r3 = r24;
        goto L117
    L99:
        if (r1.getDefaultsInvalid() == true) goto L113;
        r1.skipToGroupEnd();
        if ((r34 & 2) == 0) goto L105;
        r4 = r4 & (-113);
    L105:
        if ((r34 & 16) == 0) goto L108;
        r4 = r4 & (-57345);
    L108:
        if ((r34 & 64) == 0) goto L110;
        r4 = r4 & (-3670017);
    L110:
        r3 = r24;
        r10 = r25;
        r16 = r8;
        goto L111
    L144:
        r1.skipToGroupEnd();
        r37 = r24;
        r36 = r25;
        r16 = r8;
        r35 = r11;
        r23 = r12;
        r20 = r14;
        r21 = r15;
        goto L145
    L93:
        r0 = false;
        goto L95
    L83:
        if ((r33 & 12582912) != 0) goto L91;
        if (r1.changedInstance(r31) == false) goto L87;
        int r112 = 8388608;
    L88:
        r4 = r4 | r112;
        goto L91
    L87:
        r112 = 4194304;
        goto L88
    L71:
        if ((r34 & 64) != 0) goto L75;
        r15 = r30;
        if (r1.changed(r15) == false) goto L76;
        int r113 = 1048576;
    L77:
        r4 = r4 | r113;
    L76:
        r113 = 524288;
        goto L77
    L75:
        r15 = r30;
        goto L76
    L61:
        if ((196608 & r33) != 0) goto L67;
        r14 = r29;
        if (r1.changed(r14) == false) goto L65;
        int r114 = 131072;
    L66:
        r4 = r4 | r114;
        goto L69
    L65:
        r114 = 65536;
        goto L66
    L49:
        if ((r34 & 16) != 0) goto L53;
        r12 = r28;
        if (r1.changed(r12) == false) goto L54;
        int r115 = 16384;
    L55:
        r4 = r4 | r115;
    L54:
        r115 = 8192;
        goto L55
    L53:
        r12 = r28;
        goto L54
    L39:
        if ((r33 & 3072) != 0) goto L45;
        r11 = r27;
        if (r1.changed(r11) == false) goto L43;
        int r116 = 2048;
    L44:
        r4 = r4 | r116;
        goto L47
    L43:
        r116 = 1024;
        goto L44
    L28:
        if ((r33 & 384) != 0) goto L34;
        r8 = r26;
        if (r1.changed(r8) == false) goto L32;
        int r43 = 256;
    L33:
        r4 = r4 | r43;
        goto L35
    L32:
        r43 = 128;
        goto L33
    L6:
        if ((r33 & 6) == 0) goto L8;
        r4 = r33;
        goto L14
    L8:
        if (r1.changed(r24) == false) goto L10;
        int r44 = 4;
    L11:
        r4 = r44 | r33;
        goto L14
    L10:
        r44 = 2;
        goto L11
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    public static final /* synthetic */ void LazyColumn(Modifier r26, LazyListState r27, PaddingValues r28, boolean r29, Arrangement.Vertical r30, Alignment.Horizontal r31, FlingBehavior r32, boolean r33, final Function1 r34, Composer r35, final int r36, final int r37) {
        Composer r1 = r35.startRestartGroup(-740714857);
        int r2 = r37 & 1;
        if (r2 == 0) goto L6;
        int r4 = r36 | 6;
    L14:
        if ((r36 & 48) != 0) goto L24;
        if ((r37 & 2) != 0) goto L21;
        if (r1.changed(r27) == false) goto L21;
        int r6 = 32;
    L22:
        r4 = r4 | r6;
    L21:
        r6 = 16;
    L24:
        int r7 = r37 & 4;
        if (r7 == 0) goto L28;
        r4 = r4 | 384;
    L35:
        int r8 = r37 & 8;
        if (r8 == 0) goto L39;
        r4 = r4 | 3072;
    L45:
        boolean r9 = r29;
    L47:
        if ((r36 & 24576) == 0) goto L49;
        Arrangement.Vertical r12 = r30;
    L57:
        int r13 = r37 & 32;
        if (r13 == 0) goto L61;
        r4 = r4 | 196608;
    L67:
        Alignment.Horizontal r14 = r31;
    L69:
        if ((1572864 & r36) == 0) goto L71;
        FlingBehavior r15 = r32;
    L79:
        int r0 = r37 & 128;
        if (r0 == 0) goto L83;
        r4 = r4 | 12582912;
    L90:
        if ((r37 & 256) == 0) goto L93;
        r4 = r4 | 100663296;
    L101:
        if ((r4 & 38347923) == 38347922) goto L103;
        boolean r3 = true;
    L105:
        if (r1.shouldExecute(r3, r4 & 1) == false) goto L159;
        r1.startDefaults();
        if ((r36 & 1) != 0) goto L109;
    L121:
        if (r2 == 0) goto L123;
        Modifier r5 = Modifier.Companion;
    L125:
        if ((r37 & 2) == 0) goto L127;
        int r10 = 0;
        LazyListState r19 = LazyListStateKt.rememberLazyListState(0, 0, r1, 0, 3);
        r4 = r4 & (-113);
    L128:
        if (r7 == 0) goto L130;
        PaddingValues r11 = PaddingKt.m953PaddingValues0680j_4(Dp.constructor-impl(r10));
    L131:
        if (r8 == 0) goto L134;
        r9 = false;
    L134:
        if ((r37 & 16) == 0) goto L140;
        Arrangement r16 = Arrangement.INSTANCE;
        if (r9 == true) goto L138;
        Arrangement.Vertical r17 = r16.getTop();
    L139:
        r4 = r4 & (-57345);
    L141:
        if (r13 == 0) goto L143;
        Alignment.Horizontal r18 = Alignment.Companion.getStart();
    L145:
        if ((r37 & 64) == 0) goto L147;
        FlingBehavior r110 = ScrollableDefaults.INSTANCE.flingBehavior(r1, 6);
        r4 = r4 & (-3670017);
    L148:
        if (r0 == 0) goto L150;
        boolean r20 = true;
    L151:
        FlingBehavior r25 = r110;
        int r111 = r4;
        FlingBehavior r21 = r25;
    L152:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L155;
        ComposerKt.traceEventStart(-740714857, r111, -1, "androidx.compose.foundation.lazy.LazyColumn (LazyDsl.kt:428)");
    L155:
        int r23 = ((((((((r111 & 14) | (r111 & 112)) | (r111 & 896)) | (r111 & 7168)) | (57344 & r111)) | (458752 & r111)) | (3670016 & r111)) | (29360128 & r111)) | ((r111 << 3) & 1879048192);
        LazyColumn(r5, r19, r11, r9, r17, r18, r21, r20, OverscrollKt.rememberOverscrollEffect(r1, 0), r34, r1, r23, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L158;
        ComposerKt.traceEventEnd();
    L158:
        final FlingBehavior r22 = r21;
        PaddingValues r24 = r11;
        LazyListState r38 = r19;
        Alignment.Horizontal r210 = r18;
        final boolean r39 = r20;
        final Arrangement.Vertical r40 = r17;
        final Alignment.Horizontal r41 = r210;
    L160:
        ScopeUpdateScope r112 = r1.endRestartGroup();
        if (r112 == null) goto L164;
        final Modifier r42 = r5;
        final LazyListState r43 = r38;
        final PaddingValues r44 = r24;
        final boolean r45 = r9;
        r112.updateScope(new c(r42, r43, r44, r45, r40, r41, r22, r39, r34, r36, r37));
        return;
    L164:
        return;
    L150:
        r20 = r33;
        goto L151
    L147:
        r110 = r15;
        goto L148
    L143:
        r18 = r14;
        goto L145
    L138:
        r17 = r16.getBottom();
        goto L139
    L140:
        r17 = r12;
        goto L141
    L130:
        r11 = r28;
        goto L131
    L127:
        r10 = 0;
        r19 = r27;
        goto L128
    L123:
        r5 = r26;
        goto L125
    L109:
        if (r1.getDefaultsInvalid() == true) goto L121;
        r1.skipToGroupEnd();
        if ((r37 & 2) == 0) goto L115;
        r4 = r4 & (-113);
    L115:
        if ((r37 & 16) == 0) goto L118;
        r4 = r4 & (-57345);
    L118:
        if ((r37 & 64) == 0) goto L120;
        r4 = r4 & (-3670017);
    L120:
        r5 = r26;
        r19 = r27;
        r11 = r28;
        r20 = r33;
        r17 = r12;
        r18 = r14;
        r111 = r4;
        r21 = r15;
        goto L152
    L159:
        r1.skipToGroupEnd();
        r5 = r26;
        r38 = r27;
        r24 = r28;
        r39 = r33;
        r40 = r12;
        r41 = r14;
        r22 = r15;
        goto L160
    L103:
        r3 = false;
        goto L105
    L93:
        if ((r36 & 100663296) != 0) goto L101;
        if (r1.changedInstance(r34) == false) goto L97;
        int r113 = 67108864;
    L98:
        r4 = r4 | r113;
        goto L101
    L97:
        r113 = 33554432;
        goto L98
    L83:
        if ((r36 & 12582912) != 0) goto L90;
        if (r1.changed(r33) == false) goto L87;
        int r114 = 8388608;
    L88:
        r4 = r4 | r114;
        goto L90
    L87:
        r114 = 4194304;
        goto L88
    L71:
        if ((r37 & 64) != 0) goto L75;
        r15 = r32;
        if (r1.changed(r15) == false) goto L76;
        int r115 = 1048576;
    L77:
        r4 = r4 | r115;
    L76:
        r115 = 524288;
        goto L77
    L75:
        r15 = r32;
        goto L76
    L61:
        if ((196608 & r36) != 0) goto L67;
        r14 = r31;
        if (r1.changed(r14) == false) goto L65;
        int r116 = 131072;
    L66:
        r4 = r4 | r116;
        goto L69
    L65:
        r116 = 65536;
        goto L66
    L49:
        if ((r37 & 16) != 0) goto L53;
        r12 = r30;
        if (r1.changed(r12) == false) goto L54;
        int r117 = 16384;
    L55:
        r4 = r4 | r117;
    L54:
        r117 = 8192;
        goto L55
    L53:
        r12 = r30;
        goto L54
    L39:
        if ((r36 & 3072) != 0) goto L45;
        r9 = r29;
        if (r1.changed(r9) == false) goto L43;
        int r118 = 2048;
    L44:
        r4 = r4 | r118;
        goto L47
    L43:
        r118 = 1024;
        goto L44
    L28:
        if ((r36 & 384) != 0) goto L35;
        if (r1.changed(r28) == false) goto L32;
        int r46 = 256;
    L33:
        r4 = r4 | r46;
        goto L35
    L32:
        r46 = 128;
        goto L33
    L6:
        if ((r36 & 6) == 0) goto L8;
        r4 = r36;
        goto L14
    L8:
        if (r1.changed(r26) == false) goto L10;
        int r47 = 4;
    L11:
        r4 = r47 | r36;
        goto L14
    L10:
        r47 = 2;
        goto L11
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the non deprecated overload")
    public static final /* synthetic */ void LazyRow(Modifier r26, LazyListState r27, PaddingValues r28, boolean r29, Arrangement.Horizontal r30, Alignment.Vertical r31, FlingBehavior r32, boolean r33, final Function1 r34, Composer r35, final int r36, final int r37) {
        Composer r1 = r35.startRestartGroup(-1724297413);
        int r2 = r37 & 1;
        if (r2 == 0) goto L6;
        int r4 = r36 | 6;
    L14:
        if ((r36 & 48) != 0) goto L24;
        if ((r37 & 2) != 0) goto L21;
        if (r1.changed(r27) == false) goto L21;
        int r6 = 32;
    L22:
        r4 = r4 | r6;
    L21:
        r6 = 16;
    L24:
        int r7 = r37 & 4;
        if (r7 == 0) goto L28;
        r4 = r4 | 384;
    L35:
        int r8 = r37 & 8;
        if (r8 == 0) goto L39;
        r4 = r4 | 3072;
    L45:
        boolean r9 = r29;
    L47:
        if ((r36 & 24576) == 0) goto L49;
        Arrangement.Horizontal r12 = r30;
    L57:
        int r13 = r37 & 32;
        if (r13 == 0) goto L61;
        r4 = r4 | 196608;
    L67:
        Alignment.Vertical r14 = r31;
    L69:
        if ((1572864 & r36) == 0) goto L71;
        FlingBehavior r15 = r32;
    L79:
        int r0 = r37 & 128;
        if (r0 == 0) goto L83;
        r4 = r4 | 12582912;
    L90:
        if ((r37 & 256) == 0) goto L93;
        r4 = r4 | 100663296;
    L101:
        if ((r4 & 38347923) == 38347922) goto L103;
        boolean r3 = true;
    L105:
        if (r1.shouldExecute(r3, r4 & 1) == false) goto L159;
        r1.startDefaults();
        if ((r36 & 1) != 0) goto L109;
    L121:
        if (r2 == 0) goto L123;
        Modifier r5 = Modifier.Companion;
    L125:
        if ((r37 & 2) == 0) goto L127;
        int r10 = 0;
        LazyListState r19 = LazyListStateKt.rememberLazyListState(0, 0, r1, 0, 3);
        r4 = r4 & (-113);
    L128:
        if (r7 == 0) goto L130;
        PaddingValues r11 = PaddingKt.m953PaddingValues0680j_4(Dp.constructor-impl(r10));
    L131:
        if (r8 == 0) goto L134;
        r9 = false;
    L134:
        if ((r37 & 16) == 0) goto L140;
        Arrangement r16 = Arrangement.INSTANCE;
        if (r9 == true) goto L138;
        Arrangement.Horizontal r17 = r16.getStart();
    L139:
        r4 = r4 & (-57345);
    L141:
        if (r13 == 0) goto L143;
        Alignment.Vertical r18 = Alignment.Companion.getTop();
    L145:
        if ((r37 & 64) == 0) goto L147;
        FlingBehavior r110 = ScrollableDefaults.INSTANCE.flingBehavior(r1, 6);
        r4 = r4 & (-3670017);
    L148:
        if (r0 == 0) goto L150;
        boolean r20 = true;
    L151:
        FlingBehavior r25 = r110;
        int r111 = r4;
        FlingBehavior r21 = r25;
    L152:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L155;
        ComposerKt.traceEventStart(-1724297413, r111, -1, "androidx.compose.foundation.lazy.LazyRow (LazyDsl.kt:482)");
    L155:
        int r23 = ((((((((r111 & 14) | (r111 & 112)) | (r111 & 896)) | (r111 & 7168)) | (57344 & r111)) | (458752 & r111)) | (3670016 & r111)) | (29360128 & r111)) | ((r111 << 3) & 1879048192);
        LazyRow(r5, r19, r11, r9, r17, r18, r21, r20, OverscrollKt.rememberOverscrollEffect(r1, 0), r34, r1, r23, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L158;
        ComposerKt.traceEventEnd();
    L158:
        final FlingBehavior r22 = r21;
        PaddingValues r24 = r11;
        LazyListState r38 = r19;
        Alignment.Vertical r210 = r18;
        final boolean r39 = r20;
        final Arrangement.Horizontal r40 = r17;
        final Alignment.Vertical r41 = r210;
    L160:
        ScopeUpdateScope r112 = r1.endRestartGroup();
        if (r112 == null) goto L164;
        final Modifier r42 = r5;
        final LazyListState r43 = r38;
        final PaddingValues r44 = r24;
        final boolean r45 = r9;
        r112.updateScope(new a(r42, r43, r44, r45, r40, r41, r22, r39, r34, r36, r37));
        return;
    L164:
        return;
    L150:
        r20 = r33;
        goto L151
    L147:
        r110 = r15;
        goto L148
    L143:
        r18 = r14;
        goto L145
    L138:
        r17 = r16.getEnd();
        goto L139
    L140:
        r17 = r12;
        goto L141
    L130:
        r11 = r28;
        goto L131
    L127:
        r10 = 0;
        r19 = r27;
        goto L128
    L123:
        r5 = r26;
        goto L125
    L109:
        if (r1.getDefaultsInvalid() == true) goto L121;
        r1.skipToGroupEnd();
        if ((r37 & 2) == 0) goto L115;
        r4 = r4 & (-113);
    L115:
        if ((r37 & 16) == 0) goto L118;
        r4 = r4 & (-57345);
    L118:
        if ((r37 & 64) == 0) goto L120;
        r4 = r4 & (-3670017);
    L120:
        r5 = r26;
        r19 = r27;
        r11 = r28;
        r20 = r33;
        r17 = r12;
        r18 = r14;
        r111 = r4;
        r21 = r15;
        goto L152
    L159:
        r1.skipToGroupEnd();
        r5 = r26;
        r38 = r27;
        r24 = r28;
        r39 = r33;
        r40 = r12;
        r41 = r14;
        r22 = r15;
        goto L160
    L103:
        r3 = false;
        goto L105
    L93:
        if ((r36 & 100663296) != 0) goto L101;
        if (r1.changedInstance(r34) == false) goto L97;
        int r113 = 67108864;
    L98:
        r4 = r4 | r113;
        goto L101
    L97:
        r113 = 33554432;
        goto L98
    L83:
        if ((r36 & 12582912) != 0) goto L90;
        if (r1.changed(r33) == false) goto L87;
        int r114 = 8388608;
    L88:
        r4 = r4 | r114;
        goto L90
    L87:
        r114 = 4194304;
        goto L88
    L71:
        if ((r37 & 64) != 0) goto L75;
        r15 = r32;
        if (r1.changed(r15) == false) goto L76;
        int r115 = 1048576;
    L77:
        r4 = r4 | r115;
    L76:
        r115 = 524288;
        goto L77
    L75:
        r15 = r32;
        goto L76
    L61:
        if ((196608 & r36) != 0) goto L67;
        r14 = r31;
        if (r1.changed(r14) == false) goto L65;
        int r116 = 131072;
    L66:
        r4 = r4 | r116;
        goto L69
    L65:
        r116 = 65536;
        goto L66
    L49:
        if ((r37 & 16) != 0) goto L53;
        r12 = r30;
        if (r1.changed(r12) == false) goto L54;
        int r117 = 16384;
    L55:
        r4 = r4 | r117;
    L54:
        r117 = 8192;
        goto L55
    L53:
        r12 = r30;
        goto L54
    L39:
        if ((r36 & 3072) != 0) goto L45;
        r9 = r29;
        if (r1.changed(r9) == false) goto L43;
        int r118 = 2048;
    L44:
        r4 = r4 | r118;
        goto L47
    L43:
        r118 = 1024;
        goto L44
    L28:
        if ((r36 & 384) != 0) goto L35;
        if (r1.changed(r28) == false) goto L32;
        int r46 = 256;
    L33:
        r4 = r4 | r46;
        goto L35
    L32:
        r46 = 128;
        goto L33
    L6:
        if ((r36 & 6) == 0) goto L8;
        r4 = r36;
        goto L14
    L8:
        if (r1.changed(r26) == false) goto L10;
        int r47 = 4;
    L11:
        r4 = r47 | r36;
        goto L14
    L10:
        r47 = 2;
        goto L11
    }

    public static final void LazyColumn(Modifier r32, LazyListState r33, PaddingValues r34, boolean r35, Arrangement.Vertical r36, Alignment.Horizontal r37, FlingBehavior r38, boolean r39, OverscrollEffect r40, final Function1<? super LazyListScope, Unit> r41, Composer r42, final int r43, final int r44) {
        Composer r1 = r42.startRestartGroup(53695811);
        int r2 = r44 & 1;
        if (r2 == 0) goto L6;
        int r4 = r43 | 6;
    L14:
        if ((r43 & 48) != 0) goto L24;
        if ((r44 & 2) != 0) goto L21;
        if (r1.changed(r33) == false) goto L21;
        int r6 = 32;
    L22:
        r4 = r4 | r6;
    L21:
        r6 = 16;
    L24:
        int r7 = r44 & 4;
        if (r7 == 0) goto L28;
        r4 = r4 | 384;
    L35:
        int r8 = r44 & 8;
        if (r8 == 0) goto L39;
        r4 = r4 | 3072;
    L45:
        boolean r9 = r35;
    L47:
        if ((r43 & 24576) == 0) goto L49;
        Arrangement.Vertical r10 = r36;
    L57:
        int r13 = r44 & 32;
        if (r13 == 0) goto L61;
        r4 = r4 | 196608;
    L67:
        Alignment.Horizontal r14 = r37;
    L69:
        if ((1572864 & r43) == 0) goto L71;
        FlingBehavior r15 = r38;
    L79:
        int r0 = r44 & 128;
        if (r0 == 0) goto L83;
        r4 = r4 | 12582912;
    L90:
        if ((r43 & 100663296) != 0) goto L101;
        if ((r44 & 256) != 0) goto L97;
        if (r1.changed(r40) == false) goto L97;
        int r17 = 67108864;
    L98:
        r4 = r4 | r17;
    L97:
        r17 = 33554432;
    L101:
        if ((r44 & 512) == 0) goto L104;
        r4 = r4 | 805306368;
    L111:
        boolean r18 = true;
        if ((r4 & 306783379) == 306783378) goto L114;
        boolean r3 = true;
    L116:
        if (r1.shouldExecute(r3, r4 & 1) == false) goto L177;
        r1.startDefaults();
        if ((r43 & 1) != 0) goto L120;
    L135:
        if (r2 == 0) goto L137;
        Modifier r5 = Modifier.Companion;
    L139:
        if ((r44 & 2) == 0) goto L141;
        LazyListState r11 = LazyListStateKt.rememberLazyListState(0, 0, r1, 0, 3);
        r4 = r4 & (-113);
    L142:
        if (r7 == 0) goto L144;
        PaddingValues r12 = PaddingKt.m953PaddingValues0680j_4(Dp.constructor-impl(0));
    L145:
        if (r8 == 0) goto L148;
        r9 = false;
    L148:
        if ((r44 & 16) == 0) goto L154;
        Arrangement r16 = Arrangement.INSTANCE;
        if (r9 == true) goto L152;
        Arrangement.Vertical r19 = r16.getTop();
    L153:
        r4 = r4 & (-57345);
    L155:
        if (r13 == 0) goto L157;
        Alignment.Horizontal r110 = Alignment.Companion.getStart();
    L159:
        if ((r44 & 64) == 0) goto L161;
        FlingBehavior r111 = ScrollableDefaults.INSTANCE.flingBehavior(r1, 6);
        r4 = r4 & (-3670017);
    L162:
        if (r0 != 0) goto L166;
        r18 = r39;
    L166:
        if ((r44 & 256) == 0) goto L168;
        r4 = r4 & (-234881025);
        OverscrollEffect r20 = OverscrollKt.rememberOverscrollEffect(r1, 0);
    L169:
        int r21 = r4;
        FlingBehavior r22 = r111;
        boolean r23 = r18;
    L170:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L173;
        ComposerKt.traceEventStart(53695811, r21, -1, "androidx.compose.foundation.lazy.LazyColumn (LazyDsl.kt:399)");
    L173:
        int r112 = r21 >> 3;
        LazyListKt.LazyList(r5, r11, r12, r9, true, r22, r23, r20, 0, r110, r19, null, null, r41, r1, ((((((((r21 & 14) | 24576) | (r21 & 112)) | (r21 & 896)) | (r21 & 7168)) | (458752 & r112)) | (3670016 & r112)) | (r112 & 29360128)) | ((r21 << 12) & 1879048192), ((r21 >> 12) & 14) | ((r21 >> 18) & 7168), 6400);
        if (ComposerKt.isTraceInProgress() == false) goto L176;
        ComposerKt.traceEventEnd();
    L176:
        final FlingBehavior r24 = r22;
        Arrangement.Vertical r31 = r19;
        final boolean r25 = r23;
        final boolean r26 = r9;
        final OverscrollEffect r27 = r20;
        final Arrangement.Vertical r28 = r31;
    L178:
        ScopeUpdateScope r113 = r1.endRestartGroup();
        if (r113 == null) goto L182;
        final Modifier r29 = r5;
        final LazyListState r30 = r11;
        final PaddingValues r45 = r12;
        final Alignment.Horizontal r46 = r110;
        r113.updateScope(new b(r29, r30, r45, r26, r28, r46, r24, r25, r27, r41, r43, r44));
        return;
    L182:
        return;
    L168:
        r20 = r40;
        goto L169
    L161:
        r111 = r15;
        goto L162
    L157:
        r110 = r14;
        goto L159
    L152:
        r19 = r16.getBottom();
        goto L153
    L154:
        r19 = r10;
        goto L155
    L144:
        r12 = r34;
        goto L145
    L141:
        r11 = r33;
        goto L142
    L137:
        r5 = r32;
        goto L139
    L120:
        if (r1.getDefaultsInvalid() == true) goto L135;
        r1.skipToGroupEnd();
        if ((r44 & 2) == 0) goto L126;
        r4 = r4 & (-113);
    L126:
        if ((r44 & 16) == 0) goto L129;
        r4 = r4 & (-57345);
    L129:
        if ((r44 & 64) == 0) goto L132;
        r4 = r4 & (-3670017);
    L132:
        if ((r44 & 256) == 0) goto L134;
        r4 = r4 & (-234881025);
    L134:
        r5 = r32;
        r11 = r33;
        r12 = r34;
        r20 = r40;
        r21 = r4;
        r19 = r10;
        r110 = r14;
        r22 = r15;
        r23 = r39;
        goto L170
    L177:
        r1.skipToGroupEnd();
        r5 = r32;
        r11 = r33;
        r12 = r34;
        r25 = r39;
        r26 = r9;
        r28 = r10;
        r110 = r14;
        r24 = r15;
        r27 = r40;
        goto L178
    L114:
        r3 = false;
        goto L116
    L104:
        if ((r43 & 805306368) != 0) goto L111;
        if (r1.changedInstance(r41) == false) goto L108;
        int r114 = 536870912;
    L109:
        r4 = r4 | r114;
        goto L111
    L108:
        r114 = 268435456;
        goto L109
    L83:
        if ((r43 & 12582912) != 0) goto L90;
        if (r1.changed(r39) == false) goto L87;
        int r115 = 8388608;
    L88:
        r4 = r4 | r115;
        goto L90
    L87:
        r115 = 4194304;
        goto L88
    L71:
        if ((r44 & 64) != 0) goto L75;
        r15 = r38;
        if (r1.changed(r15) == false) goto L76;
        int r116 = 1048576;
    L77:
        r4 = r4 | r116;
    L76:
        r116 = 524288;
        goto L77
    L75:
        r15 = r38;
        goto L76
    L61:
        if ((196608 & r43) != 0) goto L67;
        r14 = r37;
        if (r1.changed(r14) == false) goto L65;
        int r117 = 131072;
    L66:
        r4 = r4 | r117;
        goto L69
    L65:
        r117 = 65536;
        goto L66
    L49:
        if ((r44 & 16) != 0) goto L53;
        r10 = r36;
        if (r1.changed(r10) == false) goto L54;
        int r118 = 16384;
    L55:
        r4 = r4 | r118;
    L54:
        r118 = 8192;
        goto L55
    L53:
        r10 = r36;
        goto L54
    L39:
        if ((r43 & 3072) != 0) goto L45;
        r9 = r35;
        if (r1.changed(r9) == false) goto L43;
        int r119 = 2048;
    L44:
        r4 = r4 | r119;
        goto L47
    L43:
        r119 = 1024;
        goto L44
    L28:
        if ((r43 & 384) != 0) goto L35;
        if (r1.changed(r34) == false) goto L32;
        int r47 = 256;
    L33:
        r4 = r4 | r47;
        goto L35
    L32:
        r47 = 128;
        goto L33
    L6:
        if ((r43 & 6) == 0) goto L8;
        r4 = r43;
        goto L14
    L8:
        if (r1.changed(r32) == false) goto L10;
        int r48 = 4;
    L11:
        r4 = r48 | r43;
        goto L14
    L10:
        r48 = 2;
        goto L11
    }

    public static final void LazyRow(Modifier r32, LazyListState r33, PaddingValues r34, boolean r35, Arrangement.Horizontal r36, Alignment.Vertical r37, FlingBehavior r38, boolean r39, OverscrollEffect r40, final Function1<? super LazyListScope, Unit> r41, Composer r42, final int r43, final int r44) {
        Composer r1 = r42.startRestartGroup(-1884325601);
        int r2 = r44 & 1;
        if (r2 == 0) goto L6;
        int r4 = r43 | 6;
    L14:
        if ((r43 & 48) != 0) goto L24;
        if ((r44 & 2) != 0) goto L21;
        if (r1.changed(r33) == false) goto L21;
        int r6 = 32;
    L22:
        r4 = r4 | r6;
    L21:
        r6 = 16;
    L24:
        int r7 = r44 & 4;
        if (r7 == 0) goto L28;
        r4 = r4 | 384;
    L35:
        int r8 = r44 & 8;
        if (r8 == 0) goto L39;
        r4 = r4 | 3072;
    L45:
        boolean r9 = r35;
    L47:
        if ((r43 & 24576) == 0) goto L49;
        Arrangement.Horizontal r10 = r36;
    L57:
        int r13 = r44 & 32;
        if (r13 == 0) goto L61;
        r4 = r4 | 196608;
    L67:
        Alignment.Vertical r14 = r37;
    L69:
        if ((1572864 & r43) == 0) goto L71;
        FlingBehavior r15 = r38;
    L79:
        int r0 = r44 & 128;
        if (r0 == 0) goto L83;
        r4 = r4 | 12582912;
    L90:
        if ((r43 & 100663296) != 0) goto L101;
        if ((r44 & 256) != 0) goto L97;
        if (r1.changed(r40) == false) goto L97;
        int r17 = 67108864;
    L98:
        r4 = r4 | r17;
    L97:
        r17 = 33554432;
    L101:
        if ((r44 & 512) == 0) goto L104;
        r4 = r4 | 805306368;
    L111:
        boolean r18 = true;
        if ((r4 & 306783379) == 306783378) goto L114;
        boolean r3 = true;
    L116:
        if (r1.shouldExecute(r3, r4 & 1) == false) goto L177;
        r1.startDefaults();
        if ((r43 & 1) != 0) goto L120;
    L135:
        if (r2 == 0) goto L137;
        Modifier r5 = Modifier.Companion;
    L139:
        if ((r44 & 2) == 0) goto L141;
        LazyListState r11 = LazyListStateKt.rememberLazyListState(0, 0, r1, 0, 3);
        r4 = r4 & (-113);
    L142:
        if (r7 == 0) goto L144;
        PaddingValues r12 = PaddingKt.m953PaddingValues0680j_4(Dp.constructor-impl(0));
    L145:
        if (r8 == 0) goto L148;
        r9 = false;
    L148:
        if ((r44 & 16) == 0) goto L154;
        Arrangement r16 = Arrangement.INSTANCE;
        if (r9 == true) goto L152;
        Arrangement.Horizontal r19 = r16.getStart();
    L153:
        r4 = r4 & (-57345);
    L155:
        if (r13 == 0) goto L157;
        Alignment.Vertical r110 = Alignment.Companion.getTop();
    L159:
        if ((r44 & 64) == 0) goto L161;
        FlingBehavior r111 = ScrollableDefaults.INSTANCE.flingBehavior(r1, 6);
        r4 = r4 & (-3670017);
    L162:
        if (r0 != 0) goto L166;
        r18 = r39;
    L166:
        if ((r44 & 256) == 0) goto L168;
        r4 = r4 & (-234881025);
        OverscrollEffect r20 = OverscrollKt.rememberOverscrollEffect(r1, 0);
    L169:
        int r21 = r4;
        FlingBehavior r22 = r111;
        boolean r23 = r18;
    L170:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L173;
        ComposerKt.traceEventStart(-1884325601, r21, -1, "androidx.compose.foundation.lazy.LazyRow (LazyDsl.kt:339)");
    L173:
        int r112 = r21 >> 3;
        LazyListKt.LazyList(r5, r11, r12, r9, false, r22, r23, r20, 0, null, null, r110, r19, r41, r1, (((((((r21 & 14) | 24576) | (r21 & 112)) | (r21 & 896)) | (r21 & 7168)) | (458752 & r112)) | (3670016 & r112)) | (r112 & 29360128), (((r21 >> 12) & 112) | ((r21 >> 6) & 896)) | ((r21 >> 18) & 7168), 1792);
        if (ComposerKt.isTraceInProgress() == false) goto L176;
        ComposerKt.traceEventEnd();
    L176:
        final FlingBehavior r24 = r22;
        Arrangement.Horizontal r31 = r19;
        final boolean r25 = r23;
        final boolean r26 = r9;
        final OverscrollEffect r27 = r20;
        final Arrangement.Horizontal r28 = r31;
    L178:
        ScopeUpdateScope r113 = r1.endRestartGroup();
        if (r113 == null) goto L182;
        final Modifier r29 = r5;
        final LazyListState r30 = r11;
        final PaddingValues r45 = r12;
        final Alignment.Vertical r46 = r110;
        r113.updateScope(new e(r29, r30, r45, r26, r28, r46, r24, r25, r27, r41, r43, r44));
        return;
    L182:
        return;
    L168:
        r20 = r40;
        goto L169
    L161:
        r111 = r15;
        goto L162
    L157:
        r110 = r14;
        goto L159
    L152:
        r19 = r16.getEnd();
        goto L153
    L154:
        r19 = r10;
        goto L155
    L144:
        r12 = r34;
        goto L145
    L141:
        r11 = r33;
        goto L142
    L137:
        r5 = r32;
        goto L139
    L120:
        if (r1.getDefaultsInvalid() == true) goto L135;
        r1.skipToGroupEnd();
        if ((r44 & 2) == 0) goto L126;
        r4 = r4 & (-113);
    L126:
        if ((r44 & 16) == 0) goto L129;
        r4 = r4 & (-57345);
    L129:
        if ((r44 & 64) == 0) goto L132;
        r4 = r4 & (-3670017);
    L132:
        if ((r44 & 256) == 0) goto L134;
        r4 = r4 & (-234881025);
    L134:
        r5 = r32;
        r11 = r33;
        r12 = r34;
        r20 = r40;
        r21 = r4;
        r19 = r10;
        r110 = r14;
        r22 = r15;
        r23 = r39;
        goto L170
    L177:
        r1.skipToGroupEnd();
        r5 = r32;
        r11 = r33;
        r12 = r34;
        r25 = r39;
        r26 = r9;
        r28 = r10;
        r110 = r14;
        r24 = r15;
        r27 = r40;
        goto L178
    L114:
        r3 = false;
        goto L116
    L104:
        if ((r43 & 805306368) != 0) goto L111;
        if (r1.changedInstance(r41) == false) goto L108;
        int r114 = 536870912;
    L109:
        r4 = r4 | r114;
        goto L111
    L108:
        r114 = 268435456;
        goto L109
    L83:
        if ((r43 & 12582912) != 0) goto L90;
        if (r1.changed(r39) == false) goto L87;
        int r115 = 8388608;
    L88:
        r4 = r4 | r115;
        goto L90
    L87:
        r115 = 4194304;
        goto L88
    L71:
        if ((r44 & 64) != 0) goto L75;
        r15 = r38;
        if (r1.changed(r15) == false) goto L76;
        int r116 = 1048576;
    L77:
        r4 = r4 | r116;
    L76:
        r116 = 524288;
        goto L77
    L75:
        r15 = r38;
        goto L76
    L61:
        if ((196608 & r43) != 0) goto L67;
        r14 = r37;
        if (r1.changed(r14) == false) goto L65;
        int r117 = 131072;
    L66:
        r4 = r4 | r117;
        goto L69
    L65:
        r117 = 65536;
        goto L66
    L49:
        if ((r44 & 16) != 0) goto L53;
        r10 = r36;
        if (r1.changed(r10) == false) goto L54;
        int r118 = 16384;
    L55:
        r4 = r4 | r118;
    L54:
        r118 = 8192;
        goto L55
    L53:
        r10 = r36;
        goto L54
    L39:
        if ((r43 & 3072) != 0) goto L45;
        r9 = r35;
        if (r1.changed(r9) == false) goto L43;
        int r119 = 2048;
    L44:
        r4 = r4 | r119;
        goto L47
    L43:
        r119 = 1024;
        goto L44
    L28:
        if ((r43 & 384) != 0) goto L35;
        if (r1.changed(r34) == false) goto L32;
        int r47 = 256;
    L33:
        r4 = r4 | r47;
        goto L35
    L32:
        r47 = 128;
        goto L33
    L6:
        if ((r43 & 6) == 0) goto L8;
        r4 = r43;
        goto L14
    L8:
        if (r1.changed(r32) == false) goto L10;
        int r48 = 4;
    L11:
        r4 = r48 | r43;
        goto L14
    L10:
        r48 = 2;
        goto L11
    }
}
