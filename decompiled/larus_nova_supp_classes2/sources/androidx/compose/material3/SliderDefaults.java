package androidx.compose.material3;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.HoverableKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.tokens.SliderTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ScaleKt;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PointMode;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.util.MathHelpersKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006Js\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\bH\u0007¢\u0006\u0004\b\u0012\u0010\u0013J?\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!H\u0007¢\u0006\u0004\b\"\u0010#JG\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020%2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!H\u0001¢\u0006\u0004\b&\u0010'J3\u0010(\u001a\u00020\u00192\u0006\u0010)\u001a\u00020*2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u001e\u001a\u00020\u001fH\u0007¢\u0006\u0002\u0010+J3\u0010(\u001a\u00020\u00192\u0006\u0010$\u001a\u00020%2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u001e\u001a\u00020\u001fH\u0007¢\u0006\u0002\u0010,J\u0093\u0001\u0010(\u001a\u00020\u00192\u0006\u0010$\u001a\u00020%2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010\u0004\u001a\u00020\u00052!\b\u0002\u0010-\u001a\u001b\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u0019\u0018\u00010.¢\u0006\u0002\b12%\b\u0002\u00102\u001a\u001f\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001903¢\u0006\u0002\b12\b\b\u0002\u00104\u001a\u0002052\b\b\u0002\u00106\u001a\u000205H\u0007¢\u0006\u0004\b7\u00108J\u009b\u0001\u0010(\u001a\u00020\u00192\u0006\u0010$\u001a\u00020%2\u0006\u00109\u001a\u0002052\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010\u0004\u001a\u00020\u00052!\b\u0002\u0010-\u001a\u001b\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u0019\u0018\u00010.¢\u0006\u0002\b12%\b\u0002\u00102\u001a\u001f\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001903¢\u0006\u0002\b12\b\b\u0002\u00104\u001a\u0002052\b\b\u0002\u00106\u001a\u000205H\u0001¢\u0006\u0004\b:\u0010;J\u009d\u0001\u0010<\u001a\u00020\u00192\u0006\u0010$\u001a\u00020%2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010\u0004\u001a\u00020\u00052!\b\u0002\u0010-\u001a\u001b\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u0019\u0018\u00010.¢\u0006\u0002\b12%\b\u0002\u00102\u001a\u001f\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001903¢\u0006\u0002\b12\b\b\u0002\u00104\u001a\u0002052\b\b\u0002\u00106\u001a\u0002052\b\b\u0002\u00109\u001a\u000205H\u0001¢\u0006\u0004\b=\u0010>J\u009d\u0001\u0010?\u001a\u00020\u00192\u0006\u0010$\u001a\u00020%2\u0006\u00109\u001a\u0002052\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0004\u001a\u00020\u00052\u001f\u0010-\u001a\u001b\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u0019\u0018\u00010.¢\u0006\u0002\b12#\u00102\u001a\u001f\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001903¢\u0006\u0002\b12\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u0002052\u0006\u0010@\u001a\u00020\u001f2\u0006\u0010A\u001a\u00020\u001fH\u0003¢\u0006\u0004\bB\u0010CJ3\u0010(\u001a\u00020\u00192\u0006\u0010D\u001a\u00020E2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u001e\u001a\u00020\u001fH\u0007¢\u0006\u0002\u0010FJ\u0093\u0001\u0010(\u001a\u00020\u00192\u0006\u0010D\u001a\u00020E2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010\u0004\u001a\u00020\u00052!\b\u0002\u0010-\u001a\u001b\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u0019\u0018\u00010.¢\u0006\u0002\b12%\b\u0002\u00102\u001a\u001f\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001903¢\u0006\u0002\b12\b\b\u0002\u00104\u001a\u0002052\b\b\u0002\u00106\u001a\u000205H\u0007¢\u0006\u0004\b7\u0010GJ\u009b\u0001\u0010(\u001a\u00020\u00192\u0006\u0010D\u001a\u00020E2\u0006\u00109\u001a\u0002052\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010\u0004\u001a\u00020\u00052!\b\u0002\u0010-\u001a\u001b\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u0019\u0018\u00010.¢\u0006\u0002\b12%\b\u0002\u00102\u001a\u001f\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001903¢\u0006\u0002\b12\b\b\u0002\u00104\u001a\u0002052\b\b\u0002\u00106\u001a\u000205H\u0001¢\u0006\u0004\b:\u0010HJ\u008d\u0001\u0010?\u001a\u00020\u00192\u0006\u0010D\u001a\u00020E2\u0006\u00109\u001a\u0002052\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0004\u001a\u00020\u00052\u001f\u0010-\u001a\u001b\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u0019\u0018\u00010.¢\u0006\u0002\b12#\u00102\u001a\u001f\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001903¢\u0006\u0002\b12\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u000205H\u0003¢\u0006\u0004\bI\u0010JJï\u0001\u0010K\u001a\u00020\u0019*\u00020/2\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020O2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010Q\u001a\u0002052\u0006\u0010R\u001a\u0002052\u0006\u0010S\u001a\u0002052\u0006\u0010T\u001a\u0002052\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u0002052\u0006\u00109\u001a\u0002052\u001f\u0010-\u001a\u001b\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u0019\u0018\u00010.¢\u0006\u0002\b12#\u00102\u001a\u001f\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001903¢\u0006\u0002\b12\u0006\u0010U\u001a\u00020\u001f2\b\b\u0002\u0010@\u001a\u00020\u001f2\b\b\u0002\u0010V\u001a\u00020W2\b\b\u0002\u0010A\u001a\u00020\u001fH\u0002¢\u0006\u0004\bX\u0010YJC\u0010Z\u001a\u00020\u0019*\u00020/2\u0006\u0010V\u001a\u00020W2\u0006\u0010[\u001a\u0002002\u0006\u0010\\\u001a\u00020]2\u0006\u0010^\u001a\u00020\b2\u0006\u0010_\u001a\u00020O2\u0006\u0010`\u001a\u00020OH\u0002¢\u0006\u0004\ba\u0010bJ)\u0010-\u001a\u00020\u0019*\u00020/2\u0006\u0010[\u001a\u0002002\u0006\u0010\\\u001a\u0002052\u0006\u0010^\u001a\u00020\b¢\u0006\u0004\bc\u0010dR\u0018\u0010\u0014\u001a\u00020\u0005*\u00020\u00158@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010e\u001a\u000205¢\u0006\n\n\u0002\u0010h\u001a\u0004\bf\u0010gR\u0013\u0010i\u001a\u000205¢\u0006\n\n\u0002\u0010h\u001a\u0004\bj\u0010gR\u000e\u0010k\u001a\u00020lX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006m"}, d2 = {"Landroidx/compose/material3/SliderDefaults;", "", "<init>", "()V", "colors", "Landroidx/compose/material3/SliderColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/SliderColors;", "thumbColor", "Landroidx/compose/ui/graphics/Color;", "activeTrackColor", "activeTickColor", "inactiveTrackColor", "inactiveTickColor", "disabledThumbColor", "disabledActiveTrackColor", "disabledActiveTickColor", "disabledInactiveTrackColor", "disabledInactiveTickColor", "colors-q0g_0yA", "(JJJJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/SliderColors;", "defaultSliderColors", "Landroidx/compose/material3/ColorScheme;", "getDefaultSliderColors$material3", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/SliderColors;", "Thumb", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "thumbSize", "Landroidx/compose/ui/unit/DpSize;", "Thumb-9LiSoMs", "(Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SliderColors;ZJLandroidx/compose/runtime/Composer;II)V", "sliderState", "Landroidx/compose/material3/SliderState;", "Thumb-HwbPF3A$material3", "(Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material3/SliderState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SliderColors;ZJLandroidx/compose/runtime/Composer;II)V", "Track", "sliderPositions", "Landroidx/compose/material3/SliderPositions;", "(Landroidx/compose/material3/SliderPositions;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SliderColors;ZLandroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/material3/SliderState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SliderColors;ZLandroidx/compose/runtime/Composer;II)V", "drawStopIndicator", "Lkotlin/Function2;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/ExtensionFunctionType;", "drawTick", "Lkotlin/Function3;", "thumbTrackGapSize", "Landroidx/compose/ui/unit/Dp;", "trackInsideCornerSize", "Track-4EFweAY", "(Landroidx/compose/material3/SliderState;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SliderColors;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;FFLandroidx/compose/runtime/Composer;II)V", "trackCornerSize", "Track-mnvyFg4$material3", "(Landroidx/compose/material3/SliderState;FLandroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SliderColors;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;FFLandroidx/compose/runtime/Composer;II)V", "CenteredTrack", "CenteredTrack-7LSsfP0$material3", "(Landroidx/compose/material3/SliderState;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SliderColors;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;FFFLandroidx/compose/runtime/Composer;II)V", "TrackImpl", "enableCornerShrinking", "isCentered", "TrackImpl-VvwgllI", "(Landroidx/compose/material3/SliderState;FLandroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SliderColors;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;FFZZLandroidx/compose/runtime/Composer;II)V", "rangeSliderState", "Landroidx/compose/material3/RangeSliderState;", "(Landroidx/compose/material3/RangeSliderState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SliderColors;ZLandroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/material3/RangeSliderState;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SliderColors;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;FFLandroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/material3/RangeSliderState;FLandroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SliderColors;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;FFLandroidx/compose/runtime/Composer;II)V", "TrackImpl-xlyIBlM", "(Landroidx/compose/material3/RangeSliderState;FLandroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SliderColors;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;FFLandroidx/compose/runtime/Composer;I)V", "drawTrack", "tickFractions", "", "activeRangeStart", "", "activeRangeEnd", "startThumbWidth", "startThumbHeight", "endThumbWidth", "endThumbHeight", "isRangeSlider", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "drawTrack-GVD57ws", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;[FFFJJJJFFFFFFFLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;ZZLandroidx/compose/foundation/gestures/Orientation;Z)V", "drawTrackPath", "offset", "size", "Landroidx/compose/ui/geometry/Size;", "color", "startCornerRadius", "endCornerRadius", "drawTrackPath-zXTsYAs", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/foundation/gestures/Orientation;JJJFF)V", "drawStopIndicator-x3O1jOs", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFJ)V", "TrackStopIndicatorSize", "getTrackStopIndicatorSize-D9Ej5fM", "()F", "F", "TickSize", "getTickSize-D9Ej5fM", "trackPath", "Landroidx/compose/ui/graphics/Path;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SliderDefaults {
    public static final int $stable = 0;
    public static final SliderDefaults INSTANCE = null;
    private static final float TickSize = 0.0f;
    private static final float TrackStopIndicatorSize = 0.0f;
    private static final Path trackPath = null;

    private SliderDefaults() {
    }

    private static final Unit CenteredTrack_7LSsfP0$lambda$25(SliderDefaults r14, SliderState r15, Modifier r16, boolean r17, SliderColors r18, Function2 r19, Function3 r20, float r21, float r22, float r23, int r24, int r25, Composer r26, int r27) {
        r14.m3156CenteredTrack7LSsfP0$material3(r15, r16, r17, r18, r19, r20, r21, r22, r23, r26, RecomposeScopeImplKt.updateChangedFlags(r24 | 1), r25);
        return Unit.INSTANCE;
    }

    private static final Unit Thumb_9LiSoMs$lambda$3(SliderDefaults r11, MutableInteractionSource r12, Modifier r13, SliderColors r14, boolean r15, long r16, int r18, int r19, Composer r20, int r21) {
        r11.m3157Thumb9LiSoMs(r12, r13, r14, r15, r16, r20, RecomposeScopeImplKt.updateChangedFlags(r18 | 1), r19);
        return Unit.INSTANCE;
    }

    private static final Unit Thumb_HwbPF3A$lambda$6(SliderDefaults r12, MutableInteractionSource r13, SliderState r14, Modifier r15, SliderColors r16, boolean r17, long r18, int r20, int r21, Composer r22, int r23) {
        r12.m3158ThumbHwbPF3A$material3(r13, r14, r15, r16, r17, r18, r22, RecomposeScopeImplKt.updateChangedFlags(r20 | 1), r21);
        return Unit.INSTANCE;
    }

    private static final Unit Track$lambda$12(SliderDefaults r9, SliderPositions r10, Modifier r11, SliderColors r12, boolean r13, int r14, int r15, Composer r16, int r17) {
        r9.Track(r10, r11, r12, r13, r16, RecomposeScopeImplKt.updateChangedFlags(r14 | 1), r15);
        return Unit.INSTANCE;
    }

    private static final Unit Track$lambda$13(SliderDefaults r9, SliderState r10, Modifier r11, SliderColors r12, boolean r13, int r14, int r15, Composer r16, int r17) {
        r9.Track(r10, r11, r12, r13, r16, RecomposeScopeImplKt.updateChangedFlags(r14 | 1), r15);
        return Unit.INSTANCE;
    }

    private static final Unit Track$lambda$33(SliderDefaults r9, RangeSliderState r10, Modifier r11, SliderColors r12, boolean r13, int r14, int r15, Composer r16, int r17) {
        r9.Track(r10, r11, r12, r13, r16, RecomposeScopeImplKt.updateChangedFlags(r14 | 1), r15);
        return Unit.INSTANCE;
    }

    private static final Unit TrackImpl_VvwgllI$lambda$32(SliderDefaults r16, SliderState r17, float r18, Modifier r19, boolean r20, SliderColors r21, Function2 r22, Function3 r23, float r24, float r25, boolean r26, boolean r27, int r28, int r29, Composer r30, int r31) {
        r16.m3151TrackImplVvwgllI(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r30, RecomposeScopeImplKt.updateChangedFlags(r28 | 1), RecomposeScopeImplKt.updateChangedFlags(r29));
        return Unit.INSTANCE;
    }

    private static final Unit TrackImpl_xlyIBlM$lambda$47(SliderDefaults r13, RangeSliderState r14, float r15, Modifier r16, boolean r17, SliderColors r18, Function2 r19, Function3 r20, float r21, float r22, int r23, Composer r24, int r25) {
        r13.m3152TrackImplxlyIBlM(r14, r15, r16, r17, r18, r19, r20, r21, r22, r24, RecomposeScopeImplKt.updateChangedFlags(r23 | 1));
        return Unit.INSTANCE;
    }

    private static final Unit Track_4EFweAY$lambda$17(SliderDefaults r13, SliderState r14, Modifier r15, boolean r16, SliderColors r17, Function2 r18, Function3 r19, float r20, float r21, int r22, int r23, Composer r24, int r25) {
        r13.m3160Track4EFweAY(r14, r15, r16, r17, r18, r19, r20, r21, r24, RecomposeScopeImplKt.updateChangedFlags(r22 | 1), r23);
        return Unit.INSTANCE;
    }

    private static final Unit Track_4EFweAY$lambda$37(SliderDefaults r13, RangeSliderState r14, Modifier r15, boolean r16, SliderColors r17, Function2 r18, Function3 r19, float r20, float r21, int r22, int r23, Composer r24, int r25) {
        r13.m3159Track4EFweAY(r14, r15, r16, r17, r18, r19, r20, r21, r24, RecomposeScopeImplKt.updateChangedFlags(r22 | 1), r23);
        return Unit.INSTANCE;
    }

    private static final Unit Track_mnvyFg4$lambda$21(SliderDefaults r14, SliderState r15, float r16, Modifier r17, boolean r18, SliderColors r19, Function2 r20, Function3 r21, float r22, float r23, int r24, int r25, Composer r26, int r27) {
        r14.m3162TrackmnvyFg4$material3(r15, r16, r17, r18, r19, r20, r21, r22, r23, r26, RecomposeScopeImplKt.updateChangedFlags(r24 | 1), r25);
        return Unit.INSTANCE;
    }

    private static final Unit Track_mnvyFg4$lambda$41(SliderDefaults r14, RangeSliderState r15, float r16, Modifier r17, boolean r18, SliderColors r19, Function2 r20, Function3 r21, float r22, float r23, int r24, int r25, Composer r26, int r27) {
        r14.m3161TrackmnvyFg4$material3(r15, r16, r17, r18, r19, r20, r21, r22, r23, r26, RecomposeScopeImplKt.updateChangedFlags(r24 | 1), r25);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit a(SliderDefaults r0, RangeSliderState r1, float r2, Modifier r3, boolean r4, SliderColors r5, Function2 r6, Function3 r7, float r8, float r9, int r10, int r11, Composer r12, int r13) {
        return Track_mnvyFg4$lambda$41(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
    }

    public static /* synthetic */ Unit b(SliderDefaults r0, MutableInteractionSource r1, SliderState r2, Modifier r3, SliderColors r4, boolean r5, long r6, int r8, int r9, Composer r10, int r11) {
        return Thumb_HwbPF3A$lambda$6(r0, r1, r2, r3, r4, r5, r6, r8, r9, r10, r11);
    }

    public static /* synthetic */ Unit c(Placeable r0, Placeable.PlacementScope r1) {
        return TrackImpl_VvwgllI$lambda$29$lambda$28$lambda$27(r0, r1);
    }

    public static /* synthetic */ Unit d(float r1, SliderState r2, long r3, long r5, long r7, long r9, float r11, float r12, Function2 r13, Function3 r14, boolean r15, boolean r16, DrawScope r17) {
        return TrackImpl_VvwgllI$lambda$31$lambda$30(r1, r2, r3, r5, r7, r9, r11, r12, r13, r14, r15, r16, r17);
    }

    public static /* synthetic */ Unit e(long r0, SliderPositions r2, long r3, long r5, long r7, DrawScope r9) {
        return Track$lambda$11$lambda$10(r0, r2, r3, r5, r7, r9);
    }

    public static /* synthetic */ Unit f(Placeable r0, Placeable.PlacementScope r1) {
        return TrackImpl_xlyIBlM$lambda$44$lambda$43$lambda$42(r0, r1);
    }

    public static /* synthetic */ Unit g(SliderColors r0, boolean r1, DrawScope r2, Offset r3) {
        return Track_4EFweAY$lambda$15$lambda$14(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit h(SliderColors r0, boolean r1, DrawScope r2, Offset r3) {
        return Track_mnvyFg4$lambda$19$lambda$18(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit i(SliderDefaults r0, RangeSliderState r1, Modifier r2, boolean r3, SliderColors r4, Function2 r5, Function3 r6, float r7, float r8, int r9, int r10, Composer r11, int r12) {
        return Track_4EFweAY$lambda$37(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12);
    }

    public static /* synthetic */ Unit j(SliderDefaults r0, MutableInteractionSource r1, Modifier r2, SliderColors r3, boolean r4, long r5, int r7, int r8, Composer r9, int r10) {
        return Thumb_9LiSoMs$lambda$3(r0, r1, r2, r3, r4, r5, r7, r8, r9, r10);
    }

    public static /* synthetic */ Unit k(SliderDefaults r0, SliderState r1, float r2, Modifier r3, boolean r4, SliderColors r5, Function2 r6, Function3 r7, float r8, float r9, boolean r10, boolean r11, int r12, int r13, Composer r14, int r15) {
        return TrackImpl_VvwgllI$lambda$32(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15);
    }

    public static /* synthetic */ Unit l(SliderColors r0, boolean r1, DrawScope r2, Offset r3) {
        return CenteredTrack_7LSsfP0$lambda$23$lambda$22(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit m(SliderDefaults r0, SliderState r1, float r2, Modifier r3, boolean r4, SliderColors r5, Function2 r6, Function3 r7, float r8, float r9, int r10, int r11, Composer r12, int r13) {
        return Track_mnvyFg4$lambda$21(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
    }

    public static /* synthetic */ MeasureResult n(float r0, SliderState r1, MeasureScope r2, Measurable r3, Constraints r4) {
        return TrackImpl_VvwgllI$lambda$29$lambda$28(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ Unit o(SliderDefaults r0, SliderState r1, Modifier r2, boolean r3, SliderColors r4, Function2 r5, Function3 r6, float r7, float r8, int r9, int r10, Composer r11, int r12) {
        return Track_4EFweAY$lambda$17(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12);
    }

    public static /* synthetic */ Unit p(SliderDefaults r0, SliderState r1, Modifier r2, boolean r3, SliderColors r4, Function2 r5, Function3 r6, float r7, float r8, float r9, int r10, int r11, Composer r12, int r13) {
        return CenteredTrack_7LSsfP0$lambda$25(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
    }

    public static /* synthetic */ Unit q(SliderDefaults r0, RangeSliderState r1, Modifier r2, SliderColors r3, boolean r4, int r5, int r6, Composer r7, int r8) {
        return Track$lambda$33(r0, r1, r2, r3, r4, r5, r6, r7, r8);
    }

    public static /* synthetic */ Unit r(SliderDefaults r0, SliderState r1, Modifier r2, SliderColors r3, boolean r4, int r5, int r6, Composer r7, int r8) {
        return Track$lambda$13(r0, r1, r2, r3, r4, r5, r6, r7, r8);
    }

    public static /* synthetic */ Unit s(SliderColors r0, boolean r1, DrawScope r2, Offset r3) {
        return Track_4EFweAY$lambda$35$lambda$34(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit t(SliderColors r0, boolean r1, DrawScope r2, Offset r3) {
        return Track_mnvyFg4$lambda$39$lambda$38(r0, r1, r2, r3);
    }

    public static /* synthetic */ MeasureResult u(MeasureScope r0, Measurable r1, Constraints r2) {
        return TrackImpl_xlyIBlM$lambda$44$lambda$43(r0, r1, r2);
    }

    public static /* synthetic */ Unit v(SliderDefaults r0, RangeSliderState r1, float r2, Modifier r3, boolean r4, SliderColors r5, Function2 r6, Function3 r7, float r8, float r9, int r10, Composer r11, int r12) {
        return TrackImpl_xlyIBlM$lambda$47(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12);
    }

    public static /* synthetic */ Unit w(float r0, RangeSliderState r1, long r2, long r4, long r6, long r8, float r10, float r11, Function2 r12, Function3 r13, DrawScope r14) {
        return TrackImpl_xlyIBlM$lambda$46$lambda$45(r0, r1, r2, r4, r6, r8, r10, r11, r12, r13, r14);
    }

    public static /* synthetic */ Unit x(SliderDefaults r0, SliderPositions r1, Modifier r2, SliderColors r3, boolean r4, int r5, int r6, Composer r7, int r8) {
        return Track$lambda$12(r0, r1, r2, r3, r4, r5, r6, r7, r8);
    }

    static {
        INSTANCE = new SliderDefaults();
        SliderTokens r0 = SliderTokens.INSTANCE;
        TrackStopIndicatorSize = r0.getStopIndicatorSize-D9Ej5fM();
        TickSize = r0.getStopIndicatorSize-D9Ej5fM();
        trackPath = AndroidPath_androidKt.Path();
    }

    /* JADX INFO: renamed from: getTickSize-D9Ej5fM, reason: not valid java name */
    public final float m3165getTickSizeD9Ej5fM() {
        return TickSize;
    }

    /* JADX INFO: renamed from: getTrackStopIndicatorSize-D9Ej5fM, reason: not valid java name */
    public final float m3166getTrackStopIndicatorSizeD9Ej5fM() {
        return TrackStopIndicatorSize;
    }

    public final SliderColors getDefaultSliderColors$material3(ColorScheme r35) {
        SliderColors r1 = r35.getDefaultSliderColorsCached$material3();
        if (r1 != null) goto L6;
        SliderTokens r21 = SliderTokens.INSTANCE;
        SliderColors r2 = new SliderColors(ColorSchemeKt.fromToken(r35, r21.getHandleColor()), ColorSchemeKt.fromToken(r35, r21.getActiveTrackColor()), ColorSchemeKt.fromToken(r35, r21.getInactiveTrackColor()), ColorSchemeKt.fromToken(r35, r21.getInactiveTrackColor()), ColorSchemeKt.fromToken(r35, r21.getActiveTrackColor()), ColorKt.compositeOver--OWjLjI(Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r35, r21.getDisabledHandleColor()), r21.getDisabledHandleOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), r35.m2480getSurface0d7_KjU()), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r35, r21.getDisabledActiveTrackColor()), r21.getDisabledActiveTrackOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r35, r21.getDisabledInactiveTrackColor()), r21.getDisabledInactiveTrackOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r35, r21.getDisabledInactiveTrackColor()), r21.getDisabledInactiveTrackOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(r35, r21.getDisabledActiveTrackColor()), r21.getDisabledActiveTrackOpacity(), MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, MenuKt.ClosedAlphaTarget, 14, null), null);
        r35.setDefaultSliderColorsCached$material3(r2);
        return r2;
    L6:
        return r1;
    }

    private static final Unit TrackImpl_VvwgllI$lambda$29$lambda$28$lambda$27(Placeable r7, Placeable.PlacementScope r8) {
        Placeable.PlacementScope.place$default(r8, r7, 0, 0, MenuKt.ClosedAlphaTarget, 4, null);
        return Unit.INSTANCE;
    }

    private static final Unit TrackImpl_xlyIBlM$lambda$44$lambda$43$lambda$42(Placeable r7, Placeable.PlacementScope r8) {
        Placeable.PlacementScope.place$default(r8, r7, 0, 0, MenuKt.ClosedAlphaTarget, 4, null);
        return Unit.INSTANCE;
    }

    public final SliderColors colors(Composer r4, int r5) {
        if (ComposerKt.isTraceInProgress() == false) goto L5;
        ComposerKt.traceEventStart(1376295968, r5, -1, "androidx.compose.material3.SliderDefaults.colors (Slider.kt:1107)");
    L5:
        SliderColors r6 = getDefaultSliderColors$material3(MaterialTheme.INSTANCE.getColorScheme(r4, 6));
        if (ComposerKt.isTraceInProgress() == false) goto L8;
        ComposerKt.traceEventEnd();
    L8:
        return r6;
    }

    private static final MeasureResult TrackImpl_xlyIBlM$lambda$44$lambda$43(MeasureScope r3, Measurable r4, Constraints r5) {
        final Placeable r6 = r4.measure-BRTryo0(r5.unbox-impl());
        int r7 = r6.getHeight() / 2;
        return r3.layout(r6.getWidth(), r6.getHeight(), MapsKt.mapOf(TuplesKt.to(SliderKt.getCornerSizeAlignmentLine(), Integer.valueOf(r7))), new dp(r6));
    }

    private static final Unit CenteredTrack_7LSsfP0$lambda$23$lambda$22(SliderColors r7, boolean r8, DrawScope r9, Offset r10) {
        SliderDefaults r0 = INSTANCE;
        long r5 = r7.m3150trackColorWaAFU9c$material3(r8, true);
        float r4 = TrackStopIndicatorSize;
        r0.m3164drawStopIndicatorx3O1jOs(r9, r10.unbox-impl(), r4, r5);
        return Unit.INSTANCE;
    }

    private static final Unit Track_4EFweAY$lambda$15$lambda$14(SliderColors r7, boolean r8, DrawScope r9, Offset r10) {
        SliderDefaults r0 = INSTANCE;
        long r5 = r7.m3150trackColorWaAFU9c$material3(r8, true);
        float r4 = TrackStopIndicatorSize;
        r0.m3164drawStopIndicatorx3O1jOs(r9, r10.unbox-impl(), r4, r5);
        return Unit.INSTANCE;
    }

    private static final Unit Track_4EFweAY$lambda$35$lambda$34(SliderColors r7, boolean r8, DrawScope r9, Offset r10) {
        SliderDefaults r0 = INSTANCE;
        long r5 = r7.m3150trackColorWaAFU9c$material3(r8, true);
        float r4 = TrackStopIndicatorSize;
        r0.m3164drawStopIndicatorx3O1jOs(r9, r10.unbox-impl(), r4, r5);
        return Unit.INSTANCE;
    }

    private static final Unit Track_mnvyFg4$lambda$19$lambda$18(SliderColors r7, boolean r8, DrawScope r9, Offset r10) {
        SliderDefaults r0 = INSTANCE;
        long r5 = r7.m3150trackColorWaAFU9c$material3(r8, true);
        float r4 = TrackStopIndicatorSize;
        r0.m3164drawStopIndicatorx3O1jOs(r9, r10.unbox-impl(), r4, r5);
        return Unit.INSTANCE;
    }

    private static final Unit Track_mnvyFg4$lambda$39$lambda$38(SliderColors r7, boolean r8, DrawScope r9, Offset r10) {
        SliderDefaults r0 = INSTANCE;
        long r5 = r7.m3150trackColorWaAFU9c$material3(r8, true);
        float r4 = TrackStopIndicatorSize;
        r0.m3164drawStopIndicatorx3O1jOs(r9, r10.unbox-impl(), r4, r5);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: drawStopIndicator-x3O1jOs, reason: not valid java name */
    public final void m3164drawStopIndicatorx3O1jOs(DrawScope r13, long r14, float r16, long r17) {
        DrawScope.-CC.drawCircle-VaOC9Bg$default(r13, r17, r13.toPx-0680j_4(r16) / 2.0f, r14, MenuKt.ClosedAlphaTarget, null, null, 0, androidx.compose.material.MenuKt.InTransitionDuration, null);
    }

    private static final MeasureResult TrackImpl_VvwgllI$lambda$29$lambda$28(float r2, SliderState r3, MeasureScope r4, Measurable r5, Constraints r6) {
        final Placeable r7 = r5.measure-BRTryo0(r6.unbox-impl());
        if (Dp.equals-impl0(r2, Dp.Companion.getUnspecified-D9Ej5fM()) == true) goto L5;
        int r8 = r4.roundToPx-0680j_4(r2);
    L10:
        return r4.layout(r7.getWidth(), r7.getHeight(), MapsKt.mapOf(TuplesKt.to(SliderKt.getCornerSizeAlignmentLine(), Integer.valueOf(r8))), new so(r7));
    L5:
        if (r3.getOrientation$material3() != Orientation.Vertical) goto L7;
        r8 = r7.getWidth() / 2;
        goto L10
    L7:
        r8 = r7.getHeight() / 2;
        goto L10
    }

    private static final Unit Track$lambda$11$lambda$10(long r36, SliderPositions r38, long r39, long r41, long r43, DrawScope r45) {
        if (r45.getLayoutDirection() != LayoutDirection.Rtl) goto L5;
        boolean r0 = true;
    L6:
        float r1 = Float.intBitsToFloat((int) (r45.getCenter-F1C5BW0() & 4294967295L));
        long r2 = Offset.constructor-impl((Float.floatToRawIntBits(MenuKt.ClosedAlphaTarget) << 32) | (Float.floatToRawIntBits(r1) & 4294967295L));
        float r3 = Float.intBitsToFloat((int) (r45.getSize-NH-jbRc() >> 32));
        float r4 = Float.intBitsToFloat((int) (r45.getCenter-F1C5BW0() & 4294967295L));
        long r5 = Float.floatToRawIntBits(r3);
        long r6 = Offset.constructor-impl((((long) Float.floatToRawIntBits(r4)) & 4294967295L) | (r5 << 32));
        if (r0 == false) goto L9;
        long r13 = r6;
    L10:
        if (r0 == false) goto L12;
        long r11 = r2;
    L13:
        float r21 = r45.toPx-0680j_4(TickSize);
        float r22 = r45.toPx-0680j_4(SliderKt.getTrackHeight());
        StrokeCap.Companion r23 = StrokeCap.Companion;
        long r28 = r11;
        long r30 = r13;
        DrawScope.-CC.drawLine-NGM6Ib0$default(r45, r36, r13, r11, r22, r23.getRound-KaPHkGw(), null, MenuKt.ClosedAlphaTarget, null, 0, 480, null);
        int r7 = (int) (r30 >> 32);
        int r8 = (int) (r28 >> 32);
        float r9 = Float.intBitsToFloat(r7) + ((Float.intBitsToFloat(r8) - Float.intBitsToFloat(r7)) * ((Number) r38.getActiveRange().getEndInclusive()).floatValue());
        float r10 = Float.intBitsToFloat((int) (r45.getCenter-F1C5BW0() & 4294967295L));
        long r12 = Offset.constructor-impl((Float.floatToRawIntBits(r9) << 32) | (((long) Float.floatToRawIntBits(r10)) & 4294967295L));
        float r14 = Float.intBitsToFloat(r7) + ((Float.intBitsToFloat(r8) - Float.intBitsToFloat(r7)) * ((Number) r38.getActiveRange().getStart()).floatValue());
        float r15 = Float.intBitsToFloat((int) (r45.getCenter-F1C5BW0() & 4294967295L));
        long r16 = Float.floatToRawIntBits(r14);
        long r32 = r28;
        long r34 = r30;
        DrawScope.-CC.drawLine-NGM6Ib0$default(r45, r39, Offset.constructor-impl((((long) Float.floatToRawIntBits(r15)) & 4294967295L) | (r16 << 32)), r12, r22, r23.getRound-KaPHkGw(), null, MenuKt.ClosedAlphaTarget, null, 0, 480, null);
        float[] r17 = r38.getTickFractions();
        LinkedHashMap r18 = new LinkedHashMap();
        int r19 = r17.length;
        int r20 = 0;
    L14:
        if (r20 >= r19) goto L26;
        float r24 = r17[r20];
        if (r24 <= ((Number) r38.getActiveRange().getEndInclusive()).floatValue()) goto L18;
    L21:
        boolean r25 = true;
    L22:
        Boolean r26 = Boolean.valueOf(r25);
        Object r27 = r18.get(r26);
        if (r27 != null) goto L25;
        r27 = new ArrayList();
        r18.put(r26, r27);
    L25:
        ((List) r27).add(Float.valueOf(r24));
        r20 = r20 + 1;
        goto L14
    L18:
        if (r24 < ((Number) r38.getActiveRange().getStart()).floatValue()) goto L21;
        r25 = false;
        goto L22
    L26:
        Iterator r110 = r18.entrySet().iterator();
    L28:
        if (r110.hasNext() == false) goto L38;
        Map.Entry r29 = (Map.Entry) r110.next();
        boolean r31 = ((Boolean) r29.getKey()).booleanValue();
        List r33 = (List) r29.getValue();
        ArrayList r35 = new ArrayList(r33.size());
        int r37 = r33.size();
        int r40 = 0;
    L30:
        if (r40 >= r37) goto L32;
        long r111 = r34;
        float r42 = Float.intBitsToFloat((int) (OffsetKt.lerp-Wko1d7g(r111, r32, ((Number) ListProtector.get(r33, r40)).floatValue()) >> 32));
        float r44 = Float.intBitsToFloat((int) (r45.getCenter-F1C5BW0() & 4294967295L));
        long r46 = Float.floatToRawIntBits(r42);
        r35.add(Offset.box-impl(Offset.constructor-impl((((long) Float.floatToRawIntBits(r44)) & 4294967295L) | (r46 << 32))));
        r40 = r40 + 1;
        goto L30
    L32:
        long r47 = r32;
        long r112 = r34;
        int r48 = PointMode.Companion.getPoints-r_lszbg();
        if (r31 == false) goto L35;
        long r49 = r41;
    L36:
        DrawScope.-CC.drawPoints-F8ZwMP8$default(r45, r35, r48, r49, r21, StrokeCap.Companion.getRound-KaPHkGw(), null, MenuKt.ClosedAlphaTarget, null, 0, 480, null);
        r32 = r47;
        r34 = r112;
        goto L28
    L35:
        r49 = r43;
        goto L36
    L38:
        return Unit.INSTANCE;
    L12:
        r11 = r6;
        goto L13
    L9:
        r13 = r2;
        goto L10
    L5:
        r0 = false;
        goto L6
    }

    /* JADX INFO: renamed from: drawTrackPath-zXTsYAs, reason: not valid java name */
    private final void m3155drawTrackPathzXTsYAs(DrawScope r19, Orientation r20, long r21, long r23, long r25, float r27, float r28) {
        long r16 = CornerRadius.constructor-impl((Float.floatToRawIntBits(r27) << 32) | (((long) Float.floatToRawIntBits(r27)) & 4294967295L));
        long r2 = CornerRadius.constructor-impl((Float.floatToRawIntBits(r28) << 32) | (((long) Float.floatToRawIntBits(r28)) & 4294967295L));
        if (r20 != Orientation.Vertical) goto L5;
        float r4 = Float.intBitsToFloat((int) (r23 >> 32));
        float r5 = Float.intBitsToFloat((int) (r23 & 4294967295L));
        long r9 = Float.floatToRawIntBits(r4);
        RoundRect r0 = RoundRectKt.RoundRect-ZAM2FJo(RectKt.Rect-tz77jQw(r21, Size.constructor-impl((((long) Float.floatToRawIntBits(r5)) & 4294967295L) | (r9 << 32))), r16, r16, r2, r2);
    L6:
        Path r11 = trackPath;
        Path.-CC.addRoundRect$default(r11, r0, null, 2, null);
        DrawScope.-CC.drawPath-LG529CI$default(r19, r11, r25, MenuKt.ClosedAlphaTarget, null, null, 0, 60, null);
        r11.rewind();
        return;
    L5:
        float r6 = Float.intBitsToFloat((int) (r23 >> 32));
        float r7 = Float.intBitsToFloat((int) (r23 & 4294967295L));
        long r10 = Float.floatToRawIntBits(r6);
        r0 = RoundRectKt.RoundRect-ZAM2FJo(RectKt.Rect-tz77jQw(r21, Size.constructor-impl((((long) Float.floatToRawIntBits(r7)) & 4294967295L) | (r10 << 32))), r16, r2, r2, r16);
        goto L6
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r3v7 ??, still in use, count: 1, list:
          (r3v7 ?? I:java.lang.Object) from 0x0159: INVOKE (r1v1 ?? I:androidx.compose.runtime.Composer), (r3v7 ?? I:java.lang.Object) INTERFACE call: androidx.compose.runtime.Composer.updateRememberedValue(java.lang.Object):void (LINE:117440857)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:75)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:42)
        */
    @kotlin.Deprecated(message = "Use version that supports slider state")
    public final void Track(
    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r3v7 ??, still in use, count: 1, list:
          (r3v7 ?? I:java.lang.Object) from 0x0159: INVOKE (r1v1 ?? I:androidx.compose.runtime.Composer), (r3v7 ?? I:java.lang.Object) INTERFACE call: androidx.compose.runtime.Composer.updateRememberedValue(java.lang.Object):void (LINE:117440857)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:75)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r23v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:215)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:150)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:415)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
        	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
        	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
        	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
        	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
        	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
        	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
        	at jadx.core.ProcessClass.process(ProcessClass.java:89)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
        	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
        	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
        */

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the overload that takes `drawStopIndicator`, `drawTick`, `thumbTrackGapSize` and `trackInsideCornerSize`, see `LegacyRangeSliderSample` on how to restore the previous behavior", replaceWith = @ReplaceWith(expression = "Track(rangeSliderState, modifier, colors, enabled, drawStopIndicator, drawTick, thumbTrackGapSize, trackInsideCornerSize)", imports = {}))
    public final /* synthetic */ void Track(final RangeSliderState r20, Modifier r21, SliderColors r22, boolean r23, Composer r24, final int r25, final int r26) {
        Composer r14 = r24.startRestartGroup(-1617869097);
        if ((r26 & 1) == 0) goto L6;
        int r1 = r25 | 6;
    L13:
        int r2 = r26 & 2;
        if (r2 == 0) goto L17;
        r1 = r1 | 48;
    L23:
        final Modifier r3 = r21;
    L25:
        if ((r25 & 384) == 0) goto L27;
        final SliderColors r4 = r22;
    L35:
        int r5 = r26 & 8;
        if (r5 == 0) goto L39;
        r1 = r1 | 3072;
    L45:
        boolean r6 = r23;
    L47:
        if ((r26 & 16) == 0) goto L50;
        r1 = r1 | 24576;
    L57:
        if ((r1 & 9363) == 9362) goto L59;
        boolean r7 = true;
    L61:
        if (r14.shouldExecute(r7, r1 & 1) == false) goto L89;
        r14.startDefaults();
        if ((r25 & 1) != 0) goto L65;
    L72:
        if (r2 == 0) goto L74;
        Modifier r8 = Modifier.Companion;
    L76:
        if ((r26 & 4) == 0) goto L78;
        SliderColors r9 = colors(r14, (r1 >> 12) & 14);
        r1 = r1 & (-897);
    L79:
        Modifier r16 = r8;
        SliderColors r17 = r9;
        if (r5 != 0) goto L81;
    L71:
        boolean r18 = r6;
    L82:
        r14.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L85;
        ComposerKt.traceEventStart(-1617869097, r1, -1, "androidx.compose.material3.SliderDefaults.Track (Slider.kt:1688)");
    L85:
        int r10 = (((((r1 & 14) | 14155776) | (r1 & 112)) | ((r1 >> 3) & 896)) | ((r1 << 3) & 7168)) | ((r1 << 12) & 234881024);
        Modifier r11 = r16;
        boolean r12 = r18;
        SliderColors r13 = r17;
        m3159Track4EFweAY(r20, r11, r12, r13, null, null, SliderKt.access$getThumbTrackGapSize$p(), SliderKt.access$getTrackInsideCornerSize$p(), r14, r10, 48);
        if (ComposerKt.isTraceInProgress() == false) goto L88;
        ComposerKt.traceEventEnd();
    L88:
        r3 = r16;
        r4 = r17;
        final boolean r15 = r18;
    L90:
        ScopeUpdateScope r19 = r14.endRestartGroup();
        if (r19 == null) goto L94;
        r19.updateScope(new ep(this, r20, r3, r4, r15, r25, r26));
        return;
    L94:
        return;
    L81:
        r18 = true;
        goto L82
    L78:
        r9 = r4;
        goto L79
    L74:
        r8 = r3;
        goto L76
    L65:
        if (r14.getDefaultsInvalid() == true) goto L72;
        r14.skipToGroupEnd();
        if ((r26 & 4) == 0) goto L70;
        r1 = r1 & (-897);
    L70:
        r16 = r3;
        r17 = r4;
        goto L71
    L89:
        r14.skipToGroupEnd();
        r15 = r6;
        goto L90
    L59:
        r7 = false;
        goto L61
    L50:
        if ((r25 & 24576) != 0) goto L57;
        if (r14.changed(this) == false) goto L54;
        int r27 = 16384;
    L55:
        r1 = r1 | r27;
        goto L57
    L54:
        r27 = 8192;
        goto L55
    L39:
        if ((r25 & 3072) != 0) goto L45;
        r6 = r23;
        if (r14.changed(r6) == false) goto L43;
        int r28 = 2048;
    L44:
        r1 = r1 | r28;
        goto L47
    L43:
        r28 = 1024;
        goto L44
    L27:
        if ((r26 & 4) != 0) goto L31;
        r4 = r22;
        if (r14.changed(r4) == false) goto L32;
        int r29 = 256;
    L33:
        r1 = r1 | r29;
    L32:
        r29 = 128;
        goto L33
    L31:
        r4 = r22;
        goto L32
    L17:
        if ((r25 & 48) != 0) goto L23;
        r3 = r21;
        if (r14.changed(r3) == false) goto L21;
        int r30 = 32;
    L22:
        r1 = r1 | r30;
        goto L25
    L21:
        r30 = 16;
        goto L22
    L6:
        if ((r25 & 6) == 0) goto L8;
        r1 = r25;
        goto L13
    L8:
        if (r14.changedInstance(r20) == false) goto L10;
        int r31 = 4;
    L11:
        r1 = r31 | r25;
        goto L13
    L10:
        r31 = 2;
        goto L11
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the overload that takes `drawStopIndicator`, `drawTick`, `thumbTrackGapSize` and `trackInsideCornerSize`, see `LegacySliderSample` on how to restore the previous behavior", replaceWith = @ReplaceWith(expression = "Track(sliderState, modifier, enabled, colors, drawStopIndicator, drawTick, thumbTrackGapSize, trackInsideCornerSize)", imports = {}))
    public final /* synthetic */ void Track(final SliderState r20, Modifier r21, SliderColors r22, boolean r23, Composer r24, final int r25, final int r26) {
        Composer r14 = r24.startRestartGroup(593554206);
        if ((r26 & 1) == 0) goto L6;
        int r1 = r25 | 6;
    L13:
        int r2 = r26 & 2;
        if (r2 == 0) goto L17;
        r1 = r1 | 48;
    L23:
        final Modifier r3 = r21;
    L25:
        if ((r25 & 384) == 0) goto L27;
        final SliderColors r4 = r22;
    L35:
        int r5 = r26 & 8;
        if (r5 == 0) goto L39;
        r1 = r1 | 3072;
    L45:
        boolean r6 = r23;
    L47:
        if ((r26 & 16) == 0) goto L50;
        r1 = r1 | 24576;
    L57:
        if ((r1 & 9363) == 9362) goto L59;
        boolean r7 = true;
    L61:
        if (r14.shouldExecute(r7, r1 & 1) == false) goto L89;
        r14.startDefaults();
        if ((r25 & 1) != 0) goto L65;
    L72:
        if (r2 == 0) goto L74;
        Modifier r8 = Modifier.Companion;
    L76:
        if ((r26 & 4) == 0) goto L78;
        SliderColors r9 = colors(r14, (r1 >> 12) & 14);
        r1 = r1 & (-897);
    L79:
        Modifier r16 = r8;
        SliderColors r17 = r9;
        if (r5 != 0) goto L81;
    L71:
        boolean r18 = r6;
    L82:
        r14.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L85;
        ComposerKt.traceEventStart(593554206, r1, -1, "androidx.compose.material3.SliderDefaults.Track (Slider.kt:1400)");
    L85:
        int r10 = (((((r1 & 14) | 14155776) | (r1 & 112)) | ((r1 >> 3) & 896)) | ((r1 << 3) & 7168)) | ((r1 << 12) & 234881024);
        Modifier r11 = r16;
        boolean r12 = r18;
        SliderColors r13 = r17;
        m3160Track4EFweAY(r20, r11, r12, r13, null, null, SliderKt.access$getThumbTrackGapSize$p(), SliderKt.access$getTrackInsideCornerSize$p(), r14, r10, 48);
        if (ComposerKt.isTraceInProgress() == false) goto L88;
        ComposerKt.traceEventEnd();
    L88:
        r3 = r16;
        r4 = r17;
        final boolean r15 = r18;
    L90:
        ScopeUpdateScope r19 = r14.endRestartGroup();
        if (r19 == null) goto L94;
        r19.updateScope(new uo(this, r20, r3, r4, r15, r25, r26));
        return;
    L94:
        return;
    L81:
        r18 = true;
        goto L82
    L78:
        r9 = r4;
        goto L79
    L74:
        r8 = r3;
        goto L76
    L65:
        if (r14.getDefaultsInvalid() == true) goto L72;
        r14.skipToGroupEnd();
        if ((r26 & 4) == 0) goto L70;
        r1 = r1 & (-897);
    L70:
        r16 = r3;
        r17 = r4;
        goto L71
    L89:
        r14.skipToGroupEnd();
        r15 = r6;
        goto L90
    L59:
        r7 = false;
        goto L61
    L50:
        if ((r25 & 24576) != 0) goto L57;
        if (r14.changed(this) == false) goto L54;
        int r27 = 16384;
    L55:
        r1 = r1 | r27;
        goto L57
    L54:
        r27 = 8192;
        goto L55
    L39:
        if ((r25 & 3072) != 0) goto L45;
        r6 = r23;
        if (r14.changed(r6) == false) goto L43;
        int r28 = 2048;
    L44:
        r1 = r1 | r28;
        goto L47
    L43:
        r28 = 1024;
        goto L44
    L27:
        if ((r26 & 4) != 0) goto L31;
        r4 = r22;
        if (r14.changed(r4) == false) goto L32;
        int r29 = 256;
    L33:
        r1 = r1 | r29;
    L32:
        r29 = 128;
        goto L33
    L31:
        r4 = r22;
        goto L32
    L17:
        if ((r25 & 48) != 0) goto L23;
        r3 = r21;
        if (r14.changed(r3) == false) goto L21;
        int r30 = 32;
    L22:
        r1 = r1 | r30;
        goto L25
    L21:
        r30 = 16;
        goto L22
    L6:
        if ((r25 & 6) == 0) goto L8;
        r1 = r25;
        goto L13
    L8:
        if (r14.changedInstance(r20) == false) goto L10;
        int r31 = 4;
    L11:
        r1 = r31 | r25;
        goto L13
    L10:
        r31 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: Thumb-9LiSoMs, reason: not valid java name */
    public final void m3157Thumb9LiSoMs(final MutableInteractionSource r26, Modifier r27, SliderColors r28, boolean r29, long r30, Composer r32, final int r33, final int r34) {
        Composer r1 = r32.startRestartGroup(-290277409);
        if ((r34 & 1) == 0) goto L6;
        int r3 = r33 | 6;
    L13:
        int r6 = r34 & 2;
        if (r6 == 0) goto L17;
        r3 = r3 | 48;
    L23:
        Modifier r7 = r27;
    L25:
        if ((r33 & 384) == 0) goto L27;
        SliderColors r9 = r28;
    L35:
        int r11 = r34 & 8;
        if (r11 == 0) goto L39;
        r3 = r3 | 3072;
    L45:
        boolean r12 = r29;
    L46:
        int r13 = r34 & 16;
        if (r13 == 0) goto L50;
        r3 = r3 | 24576;
    L56:
        long r14 = r30;
    L58:
        if ((r34 & 32) == 0) goto L61;
        r3 = r3 | 196608;
    L68:
        if ((r3 & 74899) == 74898) goto L70;
        boolean r4 = true;
    L72:
        if (r1.shouldExecute(r4, r3 & 1) == false) goto L112;
        r1.startDefaults();
        if ((r33 & 1) != 0) goto L76;
    L81:
        if (r6 == 0) goto L84;
        r7 = Modifier.Companion;
    L84:
        if ((r34 & 4) == 0) goto L86;
        SliderColors r5 = colors(r1, (r3 >> 15) & 14);
        r3 = r3 & (-897);
        r9 = r5;
    L86:
        if (r11 == 0) goto L88;
        r12 = true;
    L88:
        if (r13 == 0) goto L90;
        r14 = SliderKt.access$getThumbSize$p();
    L90:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L93;
        ComposerKt.traceEventStart(-290277409, r3, -1, "androidx.compose.material3.SliderDefaults.Thumb (Slider.kt:1212)");
    L93:
        Object r8 = r1.rememberedValue();
        Composer.Companion r10 = Composer.Companion;
        if (r8 != r10.getEmpty()) goto L96;
        r8 = SnapshotStateKt.mutableStateListOf();
        r1.updateRememberedValue(r8);
    L96:
        SnapshotStateList r15 = (SnapshotStateList) r8;
        int r16 = r3 & 14;
        if (r16 != 4) goto L99;
        boolean r17 = true;
    L100:
        Object r18 = r1.rememberedValue();
        if (r17 == false) goto L103;
    L104:
        r18 = new SliderDefaults$Thumb$1$1(r26, r15, null);
        r1.updateRememberedValue(r18);
    L105:
        EffectsKt.LaunchedEffect(r26, (Function2) r18, r1, r16);
        if ((!r15.isEmpty()) == false) goto L108;
        long r19 = DpSize.copy-DwJknco$default(r14, Dp.constructor-impl(DpSize.getWidth-D9Ej5fM(r14) / 2), MenuKt.ClosedAlphaTarget, 2, null);
    L109:
        SpacerKt.Spacer(BackgroundKt.m341backgroundbw27NRU(HoverableKt.hoverable$default(SizeKt.m1015size6HolHcs(r7, r19), r26, false, 2, null), r9.m3148thumbColorvNxB06k$material3(r12), ShapesKt.getValue(SliderTokens.INSTANCE.getHandleShape(), r1, 6)), r1, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L113;
        ComposerKt.traceEventEnd();
    L113:
        final Modifier r20 = r7;
        final SliderColors r21 = r9;
        final boolean r22 = r12;
        final long r23 = r14;
        ScopeUpdateScope r110 = r1.endRestartGroup();
        if (r110 == null) goto L117;
        r110.updateScope(new jp(this, r26, r20, r21, r22, r23, r33, r34));
        return;
    L117:
        return;
    L108:
        r19 = r14;
        goto L109
    L103:
        if (r18 != r10.getEmpty()) goto L105;
    L99:
        r17 = false;
        goto L100
    L76:
        if (r1.getDefaultsInvalid() == true) goto L81;
        r1.skipToGroupEnd();
        if ((r34 & 4) == 0) goto L90;
        r3 = r3 & (-897);
        goto L90
    L112:
        r1.skipToGroupEnd();
        goto L113
    L70:
        r4 = false;
        goto L72
    L61:
        if ((r33 & 196608) != 0) goto L68;
        if (r1.changed(this) == false) goto L65;
        int r111 = 131072;
    L66:
        r3 = r3 | r111;
        goto L68
    L65:
        r111 = 65536;
        goto L66
    L50:
        if ((r33 & 24576) != 0) goto L56;
        r14 = r30;
        if (r1.changed(r14) == false) goto L54;
        int r112 = 16384;
    L55:
        r3 = r3 | r112;
        goto L58
    L54:
        r112 = 8192;
        goto L55
    L39:
        if ((r33 & 3072) != 0) goto L45;
        r12 = r29;
        if (r1.changed(r12) == false) goto L43;
        int r113 = 2048;
    L44:
        r3 = r3 | r113;
        goto L46
    L43:
        r113 = 1024;
        goto L44
    L27:
        if ((r34 & 4) != 0) goto L31;
        r9 = r28;
        if (r1.changed(r9) == false) goto L32;
        int r114 = 256;
    L33:
        r3 = r3 | r114;
    L32:
        r114 = 128;
        goto L33
    L31:
        r9 = r28;
        goto L32
    L17:
        if ((r33 & 48) != 0) goto L23;
        r7 = r27;
        if (r1.changed(r7) == false) goto L21;
        int r24 = 32;
    L22:
        r3 = r3 | r24;
        goto L25
    L21:
        r24 = 16;
        goto L22
    L6:
        if ((r33 & 6) == 0) goto L8;
        r3 = r33;
        goto L13
    L8:
        if (r1.changed(r26) == false) goto L10;
        int r25 = 4;
    L11:
        r3 = r25 | r33;
        goto L13
    L10:
        r25 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: Thumb-HwbPF3A$material3, reason: not valid java name */
    public final void m3158ThumbHwbPF3A$material3(final MutableInteractionSource r25, final SliderState r26, Modifier r27, SliderColors r28, boolean r29, long r30, Composer r32, final int r33, final int r34) {
        Composer r1 = r32.startRestartGroup(-889714565);
        if ((r34 & 1) == 0) goto L6;
        int r3 = r33 | 6;
    L14:
        if ((r34 & 2) == 0) goto L17;
        r3 = r3 | 48;
    L24:
        int r7 = r34 & 4;
        if (r7 == 0) goto L28;
        r3 = r3 | 384;
    L34:
        Modifier r8 = r27;
    L36:
        if ((r33 & 3072) == 0) goto L38;
        SliderColors r10 = r28;
    L46:
        int r12 = r34 & 16;
        if (r12 == 0) goto L50;
        r3 = r3 | 24576;
    L56:
        boolean r13 = r29;
    L57:
        int r14 = r34 & 32;
        if (r14 == 0) goto L60;
        r3 = r3 | 196608;
        long r5 = r30;
    L68:
        if ((r34 & 64) == 0) goto L71;
        r3 = r3 | 1572864;
    L78:
        if ((599187 & r3) == 599186) goto L80;
        boolean r4 = true;
    L82:
        if (r1.shouldExecute(r4, r3 & 1) == false) goto L125;
        r1.startDefaults();
        if ((r33 & 1) != 0) goto L86;
    L91:
        if (r7 == 0) goto L94;
        r8 = Modifier.Companion;
    L94:
        if ((r34 & 8) == 0) goto L96;
        SliderColors r6 = colors(r1, (r3 >> 18) & 14);
        r3 = r3 & (-7169);
        r10 = r6;
    L96:
        if (r12 == 0) goto L98;
        r13 = true;
    L98:
        if (r14 == 0) goto L100;
        r5 = SliderKt.access$getThumbSize$p();
    L100:
        r1.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L103;
        ComposerKt.traceEventStart(-889714565, r3, -1, "androidx.compose.material3.SliderDefaults.Thumb (Slider.kt:1265)");
    L103:
        Object r9 = r1.rememberedValue();
        Composer.Companion r11 = Composer.Companion;
        if (r9 != r11.getEmpty()) goto L106;
        r9 = SnapshotStateKt.mutableStateListOf();
        r1.updateRememberedValue(r9);
    L106:
        SnapshotStateList r15 = (SnapshotStateList) r9;
        int r16 = r3 & 14;
        if (r16 != 4) goto L109;
        boolean r17 = true;
    L110:
        Object r18 = r1.rememberedValue();
        if (r17 == false) goto L113;
    L114:
        r18 = new SliderDefaults$Thumb$3$1(r25, r15, null);
        r1.updateRememberedValue(r18);
    L115:
        EffectsKt.LaunchedEffect(r25, (Function2) r18, r1, r16);
        if ((!r15.isEmpty()) == true) goto L118;
        long r19 = r5;
    L122:
        SpacerKt.Spacer(BackgroundKt.m341backgroundbw27NRU(HoverableKt.hoverable$default(SizeKt.m1015size6HolHcs(r8, r19), r25, false, 2, null), r10.m3148thumbColorvNxB06k$material3(r13), ShapesKt.getValue(SliderTokens.INSTANCE.getHandleShape(), r1, 6)), r1, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L126;
        ComposerKt.traceEventEnd();
    L126:
        final Modifier r20 = r8;
        final long r21 = r5;
        final SliderColors r22 = r10;
        final boolean r23 = r13;
        ScopeUpdateScope r110 = r1.endRestartGroup();
        if (r110 == null) goto L130;
        r110.updateScope(new to(this, r25, r26, r20, r22, r23, r21, r33, r34));
        return;
    L130:
        return;
    L118:
        if (r26.getOrientation$material3() != Orientation.Vertical) goto L120;
        r19 = DpSize.copy-DwJknco$default(r5, MenuKt.ClosedAlphaTarget, Dp.constructor-impl(DpSize.getHeight-D9Ej5fM(r5) / 2), 1, null);
        goto L122
    L120:
        r19 = DpSize.copy-DwJknco$default(r5, Dp.constructor-impl(DpSize.getWidth-D9Ej5fM(r5) / 2), MenuKt.ClosedAlphaTarget, 2, null);
        goto L122
    L113:
        if (r18 != r11.getEmpty()) goto L115;
    L109:
        r17 = false;
        goto L110
    L86:
        if (r1.getDefaultsInvalid() == true) goto L91;
        r1.skipToGroupEnd();
        if ((r34 & 8) == 0) goto L100;
        r3 = r3 & (-7169);
        goto L100
    L125:
        r1.skipToGroupEnd();
        goto L126
    L80:
        r4 = false;
        goto L82
    L71:
        if ((r33 & 1572864) != 0) goto L78;
        if (r1.changed(this) == false) goto L75;
        int r111 = 1048576;
    L76:
        r3 = r3 | r111;
        goto L78
    L75:
        r111 = 524288;
        goto L76
    L60:
        r5 = r30;
        if ((196608 & r33) != 0) goto L68;
        if (r1.changed(r5) == false) goto L65;
        int r112 = 131072;
    L66:
        r3 = r3 | r112;
        goto L68
    L65:
        r112 = 65536;
        goto L66
    L50:
        if ((r33 & 24576) != 0) goto L56;
        r13 = r29;
        if (r1.changed(r13) == false) goto L54;
        int r113 = 16384;
    L55:
        r3 = r3 | r113;
        goto L57
    L54:
        r113 = 8192;
        goto L55
    L38:
        if ((r34 & 8) != 0) goto L42;
        r10 = r28;
        if (r1.changed(r10) == false) goto L43;
        int r114 = 2048;
    L44:
        r3 = r3 | r114;
    L43:
        r114 = 1024;
        goto L44
    L42:
        r10 = r28;
        goto L43
    L28:
        if ((r33 & 384) != 0) goto L34;
        r8 = r27;
        if (r1.changed(r8) == false) goto L32;
        int r115 = 256;
    L33:
        r3 = r3 | r115;
        goto L36
    L32:
        r115 = 128;
        goto L33
    L17:
        if ((r33 & 48) != 0) goto L24;
        if (r1.changedInstance(r26) == false) goto L21;
        int r24 = 32;
    L22:
        r3 = r3 | r24;
        goto L24
    L21:
        r24 = 16;
        goto L22
    L6:
        if ((r33 & 6) == 0) goto L8;
        r3 = r33;
        goto L14
    L8:
        if (r1.changed(r25) == false) goto L10;
        int r31 = 4;
    L11:
        r3 = r31 | r33;
        goto L14
    L10:
        r31 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: TrackImpl-xlyIBlM, reason: not valid java name */
    private final void m3152TrackImplxlyIBlM(final RangeSliderState r25, final float r26, final Modifier r27, final boolean r28, final SliderColors r29, final Function2<? super DrawScope, ? super Offset, Unit> r30, final Function3<? super DrawScope, ? super Offset, ? super Color, Unit> r31, final float r32, final float r33, Composer r34, final int r35) {
        Composer r9 = r34.startRestartGroup(-1719396904);
        if ((r35 & 6) == 0) goto L5;
        int r1 = r35;
    L11:
        if ((r35 & 48) != 0) goto L18;
        if (r9.changed(r26) == false) goto L15;
        int r2 = 32;
    L16:
        r1 = r1 | r2;
        goto L18
    L15:
        r2 = 16;
    L18:
        if ((r35 & 384) != 0) goto L25;
        if (r9.changed(r27) == false) goto L22;
        int r3 = 256;
    L23:
        r1 = r1 | r3;
        goto L25
    L22:
        r3 = 128;
    L25:
        if ((r35 & 3072) != 0) goto L32;
        if (r9.changed(r28) == false) goto L29;
        int r4 = 2048;
    L30:
        r1 = r1 | r4;
        goto L32
    L29:
        r4 = 1024;
    L32:
        if ((r35 & 24576) != 0) goto L39;
        if (r9.changed(r29) == false) goto L36;
        int r5 = 16384;
    L37:
        r1 = r1 | r5;
        goto L39
    L36:
        r5 = 8192;
    L39:
        if ((196608 & r35) != 0) goto L46;
        if (r9.changedInstance(r30) == false) goto L43;
        int r6 = 131072;
    L44:
        r1 = r1 | r6;
        goto L46
    L43:
        r6 = 65536;
    L46:
        if ((1572864 & r35) != 0) goto L53;
        if (r9.changedInstance(r31) == false) goto L50;
        int r7 = 1048576;
    L51:
        r1 = r1 | r7;
        goto L53
    L50:
        r7 = 524288;
    L53:
        if ((12582912 & r35) != 0) goto L61;
        if (r9.changed(r32) == false) goto L57;
        int r16 = 8388608;
    L58:
        r1 = r1 | r16;
        goto L61
    L57:
        r16 = 4194304;
    L61:
        if ((r35 & 100663296) != 0) goto L68;
        if (r9.changed(r33) == false) goto L65;
        int r17 = 67108864;
    L66:
        r1 = r1 | r17;
        goto L68
    L65:
        r17 = 33554432;
    L68:
        if ((r1 & 38347923) == 38347922) goto L70;
        boolean r8 = true;
    L72:
        if (r9.shouldExecute(r8, r1 & 1) == true) goto L74;
        Composer r0 = r9;
        r0.skipToGroupEnd();
    L110:
        ScopeUpdateScope r12 = r0.endRestartGroup();
        if (r12 == null) goto L114;
        r12.updateScope(new ro(this, r25, r26, r27, r28, r29, r30, r31, r32, r33, r35));
        return;
    L114:
        return;
    L74:
        if (ComposerKt.isTraceInProgress() == false) goto L76;
        ComposerKt.traceEventStart(-1719396904, r1, -1, "androidx.compose.material3.SliderDefaults.TrackImpl (Slider.kt:1811)");
    L76:
        final long r10 = r29.m3150trackColorWaAFU9c$material3(r28, false);
        final long r11 = r29.m3150trackColorWaAFU9c$material3(r28, true);
        final long r13 = r29.m3149tickColorWaAFU9c$material3(r28, false);
        final long r14 = r29.m3149tickColorWaAFU9c$material3(r28, true);
        Modifier r15 = SizeKt.m1000height3ABfNKs(SizeKt.fillMaxWidth$default(r27, MenuKt.ClosedAlphaTarget, 1, null), SliderKt.getTrackHeight());
        Object r18 = r9.rememberedValue();
        Composer.Companion r21 = Composer.Companion;
        if (r18 != r21.getEmpty()) goto L79;
        r18 = new po();
        r9.updateRememberedValue(r18);
    L79:
        Modifier r19 = LayoutModifierKt.layout(r15, (Function3) r18);
        if ((r1 & 112) != 32) goto L82;
        boolean r20 = true;
    L83:
        boolean r22 = ((((r20 | r9.changedInstance(r25)) | r9.changed(r10)) | r9.changed(r11)) | r9.changed(r13)) | r9.changed(r14);
        if ((29360128 & r1) != 8388608) goto L86;
        boolean r23 = true;
    L87:
        boolean r24 = r22 | r23;
        if ((234881024 & r1) != 67108864) goto L90;
        boolean r36 = true;
    L91:
        boolean r37 = r24 | r36;
        if ((458752 & r1) != 131072) goto L94;
        boolean r38 = true;
    L95:
        boolean r39 = r37 | r38;
        if ((r1 & 3670016) != 1048576) goto L98;
        boolean r40 = true;
    L99:
        boolean r41 = r39 | r40;
        Object r42 = r9.rememberedValue();
        if (r41 == false) goto L102;
    L105:
        Modifier r210 = r19;
        Function1 r43 = new qo(r26, r25, r10, r11, r13, r14, r32, r33, r30, r31);
        r0 = r9;
        r0.updateRememberedValue(r43);
        r42 = r43;
    L106:
        Modifier r44 = r210;
        CanvasKt.Canvas(r44, (Function1) r42, r0, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L110;
        ComposerKt.traceEventEnd();
        goto L110
    L102:
        if (r42 == r21.getEmpty()) goto L105;
        r0 = r9;
        r210 = r19;
        goto L106
    L98:
        r40 = false;
        goto L99
    L94:
        r38 = false;
        goto L95
    L90:
        r36 = false;
        goto L91
    L86:
        r23 = false;
        goto L87
    L82:
        r20 = false;
        goto L83
    L70:
        r8 = false;
        goto L72
    L5:
        if (r9.changedInstance(r25) == false) goto L7;
        int r45 = 4;
    L8:
        r1 = r45 | r35;
        goto L11
    L7:
        r45 = 2;
        goto L8
    }

    private static final Unit TrackImpl_xlyIBlM$lambda$46$lambda$45(float r28, RangeSliderState r29, long r30, long r32, long r34, long r36, float r38, float r39, Function2 r40, Function3 r41, DrawScope r42) {
        if (Dp.equals-impl0(r28, Dp.Companion.getUnspecified-D9Ej5fM()) == false) goto L5;
        float r0 = Float.intBitsToFloat((int) (r42.getSize-NH-jbRc() & 4294967295L)) / 2;
    L6:
        m3154drawTrackGVD57ws$default(INSTANCE, r42, r29.getTickFractions$material3(), r29.getCoercedActiveRangeStartAsFraction$material3(), r29.getCoercedActiveRangeEndAsFraction$material3(), r30, r32, r34, r36, r42.toDp-u2uoSUM(r29.getStartThumbWidth$material3()), r42.toDp-u2uoSUM(r29.getStartThumbHeight$material3()), r42.toDp-u2uoSUM(r29.getEndThumbWidth$material3()), r42.toDp-u2uoSUM(r29.getEndThumbHeight$material3()), r38, r39, r42.toDp-u2uoSUM(r0), r40, r41, true, false, null, false, 917504, null);
        return Unit.INSTANCE;
    L5:
        r0 = r42.toPx-0680j_4(r28);
        goto L6
    }

    /* JADX INFO: renamed from: Track-4EFweAY, reason: not valid java name */
    public final void m3160Track4EFweAY(final SliderState r27, Modifier r28, boolean r29, SliderColors r30, Function2<? super DrawScope, ? super Offset, Unit> r31, Function3<? super DrawScope, ? super Offset, ? super Color, Unit> r32, float r33, float r34, Composer r35, final int r36, final int r37) {
        Composer r12 = r35.startRestartGroup(49984771);
        if ((r37 & 1) == 0) goto L6;
        int r1 = r36 | 6;
    L13:
        int r2 = r37 & 2;
        if (r2 == 0) goto L17;
        r1 = r1 | 48;
    L24:
        int r4 = r37 & 4;
        if (r4 == 0) goto L28;
        r1 = r1 | 384;
    L34:
        final boolean r6 = r29;
    L36:
        if ((r36 & 3072) == 0) goto L38;
        final SliderColors r7 = r30;
    L47:
        if ((r36 & 24576) == 0) goto L49;
        Function2<? super DrawScope, ? super Offset, Unit> r9 = r31;
    L57:
        int r10 = r37 & 32;
        if (r10 == 0) goto L61;
        r1 = r1 | 196608;
    L67:
        int r17 = r37 & 64;
        if (r17 == 0) goto L70;
        r1 = r1 | 1572864;
        float r5 = r33;
    L77:
        int r8 = r37 & 128;
        if (r8 == 0) goto L81;
        r1 = r1 | 12582912;
    L88:
        if ((r37 & 256) == 0) goto L91;
        r1 = r1 | 100663296;
    L97:
        boolean r19 = false;
        if ((38347923 & r1) == 38347922) goto L100;
        boolean r0 = true;
    L102:
        if (r12.shouldExecute(r0, r1 & 1) == false) goto L161;
        r12.startDefaults();
        if ((r36 & 1) != 0) goto L106;
    L116:
        if (r2 == 0) goto L118;
        Modifier r3 = Modifier.Companion;
    L119:
        if (r4 == 0) goto L122;
        r6 = true;
    L122:
        if ((r37 & 8) == 0) goto L125;
        SliderColors r11 = colors(r12, (r1 >> 24) & 14);
        r1 = r1 & (-7169);
        r7 = r11;
    L125:
        if ((r37 & 16) != 0) goto L127;
    L143:
        if (r10 == 0) goto L148;
        Object r13 = r12.rememberedValue();
        if (r13 != Composer.Companion.getEmpty()) goto L147;
        r13 = SliderDefaults$Track$5$1.INSTANCE;
        r12.updateRememberedValue(r13);
    L147:
        Function3<? super DrawScope, ? super Offset, ? super Color, Unit> r14 = (Function3) r13;
    L149:
        if (r17 == 0) goto L151;
        r5 = SliderKt.access$getThumbTrackGapSize$p();
    L151:
        if (r8 == 0) goto L153;
        Modifier r18 = r3;
        Function3<? super DrawScope, ? super Offset, ? super Color, Unit> r21 = r14;
        float r23 = SliderKt.access$getTrackInsideCornerSize$p();
    L115:
        float r22 = r5;
        boolean r110 = r6;
        SliderColors r111 = r7;
        Function2<? super DrawScope, ? super Offset, Unit> r20 = r9;
        r12.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L157;
        ComposerKt.traceEventStart(49984771, r1, -1, "androidx.compose.material3.SliderDefaults.Track (Slider.kt:1446)");
    L157:
        int r15 = r1 << 3;
        Modifier r16 = r18;
        Function3<? super DrawScope, ? super Offset, ? super Color, Unit> r24 = r21;
        float r25 = r23;
        Composer r112 = r12;
        m3151TrackImplVvwgllI(r27, Dp.Companion.getUnspecified-D9Ej5fM(), r16, r110, r111, r20, r24, r22, r25, false, false, r12, ((((((((r1 & 14) | 805306416) | (r15 & 896)) | (r15 & 7168)) | (57344 & r15)) | (458752 & r15)) | (3670016 & r15)) | (29360128 & r15)) | (r15 & 234881024), ((r1 >> 21) & 112) | 6);
        if (ComposerKt.isTraceInProgress() == false) goto L160;
        ComposerKt.traceEventEnd();
    L160:
        final Modifier r26 = r18;
        final boolean r38 = r110;
        final SliderColors r39 = r111;
        final Function2<? super DrawScope, ? super Offset, Unit> r40 = r20;
        final Function3<? super DrawScope, ? super Offset, ? super Color, Unit> r41 = r21;
        final float r42 = r22;
        final float r43 = r23;
    L162:
        ScopeUpdateScope r113 = r112.endRestartGroup();
        if (r113 == null) goto L166;
        r113.updateScope(new yo(this, r27, r26, r38, r39, r40, r41, r42, r43, r36, r37));
        return;
    L166:
        return;
    L153:
        r23 = r34;
        r18 = r3;
        r21 = r14;
        goto L115
    L148:
        r14 = r32;
        goto L149
    L127:
        if (((r1 & 7168) ^ 3072) <= 2048) goto L131;
        if (r12.changed(r7) == false) goto L131;
    L132:
        boolean r44 = true;
    L135:
        if ((r1 & 896) != 256) goto L137;
        r19 = true;
    L137:
        boolean r45 = r44 | r19;
        Object r46 = r12.rememberedValue();
        if (r45 == false) goto L140;
    L141:
        r46 = new no(r7, r6);
        r12.updateRememberedValue(r46);
    L142:
        r1 = r1 & (-57345);
        r9 = (Function2) r46;
        goto L143
    L140:
        if (r46 != Composer.Companion.getEmpty()) goto L142;
    L131:
        if ((r1 & 3072) == 2048) goto L132;
        r44 = false;
        goto L135
    L118:
        r3 = r28;
        goto L119
    L106:
        if (r12.getDefaultsInvalid() == true) goto L116;
        r12.skipToGroupEnd();
        if ((r37 & 8) == 0) goto L112;
        r1 = r1 & (-7169);
    L112:
        if ((r37 & 16) == 0) goto L114;
        r1 = r1 & (-57345);
    L114:
        r18 = r28;
        r21 = r32;
        r23 = r34;
        goto L115
    L161:
        r112 = r12;
        r112.skipToGroupEnd();
        r26 = r28;
        r42 = r5;
        r38 = r6;
        r39 = r7;
        r40 = r9;
        r41 = r32;
        r43 = r34;
        goto L162
    L100:
        r0 = false;
        goto L102
    L91:
        if ((r36 & 100663296) != 0) goto L97;
        if (r12.changed(this) == false) goto L95;
        int r47 = 67108864;
    L96:
        r1 = r1 | r47;
        goto L97
    L95:
        r47 = 33554432;
        goto L96
    L81:
        if ((r36 & 12582912) != 0) goto L88;
        if (r12.changed(r34) == false) goto L85;
        int r114 = 8388608;
    L86:
        r1 = r1 | r114;
        goto L88
    L85:
        r114 = 4194304;
        goto L86
    L70:
        r5 = r33;
        if ((r36 & 1572864) != 0) goto L77;
        if (r12.changed(r5) == false) goto L75;
        int r115 = 1048576;
    L76:
        r1 = r1 | r115;
        goto L77
    L75:
        r115 = 524288;
        goto L76
    L61:
        if ((r36 & 196608) != 0) goto L67;
        if (r12.changedInstance(r32) == false) goto L65;
        int r116 = 131072;
    L66:
        r1 = r1 | r116;
        goto L67
    L65:
        r116 = 65536;
        goto L66
    L49:
        if ((r37 & 16) != 0) goto L53;
        r9 = r31;
        if (r12.changedInstance(r9) == false) goto L54;
        int r117 = 16384;
    L55:
        r1 = r1 | r117;
    L54:
        r117 = 8192;
        goto L55
    L53:
        r9 = r31;
        goto L54
    L38:
        if ((r37 & 8) != 0) goto L42;
        r7 = r30;
        if (r12.changed(r7) == false) goto L43;
        int r48 = 2048;
    L44:
        r1 = r1 | r48;
    L43:
        r48 = 1024;
        goto L44
    L42:
        r7 = r30;
        goto L43
    L28:
        if ((r36 & 384) != 0) goto L34;
        r6 = r29;
        if (r12.changed(r6) == false) goto L32;
        int r49 = 256;
    L33:
        r1 = r1 | r49;
        goto L36
    L32:
        r49 = 128;
        goto L33
    L17:
        if ((r36 & 48) != 0) goto L24;
        if (r12.changed(r28) == false) goto L21;
        int r50 = 32;
    L22:
        r1 = r1 | r50;
        goto L24
    L21:
        r50 = 16;
        goto L22
    L6:
        if ((r36 & 6) == 0) goto L8;
        r1 = r36;
        goto L13
    L8:
        if (r12.changedInstance(r27) == false) goto L10;
        int r51 = 4;
    L11:
        r1 = r51 | r36;
        goto L13
    L10:
        r51 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: Track-4EFweAY, reason: not valid java name */
    public final void m3159Track4EFweAY(final RangeSliderState r25, Modifier r26, boolean r27, SliderColors r28, Function2<? super DrawScope, ? super Offset, Unit> r29, Function3<? super DrawScope, ? super Offset, ? super Color, Unit> r30, float r31, float r32, Composer r33, final int r34, final int r35) {
        Composer r15 = r33.startRestartGroup(-541824132);
        if ((r35 & 1) == 0) goto L6;
        int r1 = r34 | 6;
    L13:
        int r2 = r35 & 2;
        if (r2 == 0) goto L17;
        r1 = r1 | 48;
    L24:
        int r4 = r35 & 4;
        if (r4 == 0) goto L28;
        r1 = r1 | 384;
    L34:
        final boolean r6 = r27;
    L36:
        if ((r34 & 3072) == 0) goto L38;
        final SliderColors r7 = r28;
    L47:
        if ((r34 & 24576) == 0) goto L49;
        Function2<? super DrawScope, ? super Offset, Unit> r9 = r29;
    L57:
        int r10 = r35 & 32;
        if (r10 == 0) goto L61;
        r1 = r1 | 196608;
    L67:
        int r17 = r35 & 64;
        if (r17 == 0) goto L70;
        r1 = r1 | 1572864;
        float r5 = r31;
    L77:
        int r8 = r35 & 128;
        if (r8 == 0) goto L81;
        r1 = r1 | 12582912;
    L88:
        if ((r35 & 256) == 0) goto L91;
        r1 = r1 | 100663296;
    L97:
        boolean r19 = false;
        if ((38347923 & r1) == 38347922) goto L100;
        boolean r0 = true;
    L102:
        if (r15.shouldExecute(r0, r1 & 1) == false) goto L161;
        r15.startDefaults();
        if ((r34 & 1) != 0) goto L106;
    L116:
        if (r2 == 0) goto L118;
        Modifier r3 = Modifier.Companion;
    L119:
        if (r4 == 0) goto L122;
        r6 = true;
    L122:
        if ((r35 & 8) == 0) goto L125;
        SliderColors r11 = colors(r15, (r1 >> 24) & 14);
        r1 = r1 & (-7169);
        r7 = r11;
    L125:
        if ((r35 & 16) != 0) goto L127;
    L143:
        if (r10 == 0) goto L148;
        Object r12 = r15.rememberedValue();
        if (r12 != Composer.Companion.getEmpty()) goto L147;
        r12 = SliderDefaults$Track$12$1.INSTANCE;
        r15.updateRememberedValue(r12);
    L147:
        Function3<? super DrawScope, ? super Offset, ? super Color, Unit> r13 = (Function3) r12;
    L149:
        if (r17 == 0) goto L151;
        r5 = SliderKt.access$getThumbTrackGapSize$p();
    L151:
        if (r8 == 0) goto L153;
        Modifier r18 = r3;
        Function3<? super DrawScope, ? super Offset, ? super Color, Unit> r21 = r13;
        float r23 = SliderKt.access$getTrackInsideCornerSize$p();
    L115:
        float r22 = r5;
        boolean r110 = r6;
        SliderColors r111 = r7;
        Function2<? super DrawScope, ? super Offset, Unit> r20 = r9;
        r15.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L157;
        ComposerKt.traceEventStart(-541824132, r1, -1, "androidx.compose.material3.SliderDefaults.Track (Slider.kt:1734)");
    L157:
        float r14 = Dp.Companion.getUnspecified-D9Ej5fM();
        int r16 = (r1 & 14) | 48;
        int r24 = r1 << 3;
        int r112 = (((((((r16 | (r24 & 896)) | (r24 & 7168)) | (57344 & r24)) | (458752 & r24)) | (3670016 & r24)) | (29360128 & r24)) | (234881024 & r24)) | (r24 & 1879048192);
        m3152TrackImplxlyIBlM(r25, r14, r18, r110, r111, r20, r21, r22, r23, r15, r112);
        if (ComposerKt.isTraceInProgress() == false) goto L160;
        ComposerKt.traceEventEnd();
    L160:
        final Modifier r36 = r18;
        final boolean r37 = r110;
        final SliderColors r38 = r111;
        final Function2<? super DrawScope, ? super Offset, Unit> r39 = r20;
        final Function3<? super DrawScope, ? super Offset, ? super Color, Unit> r40 = r21;
        final float r41 = r22;
        final float r42 = r23;
    L162:
        ScopeUpdateScope r113 = r15.endRestartGroup();
        if (r113 == null) goto L166;
        r113.updateScope(new cp(this, r25, r36, r37, r38, r39, r40, r41, r42, r34, r35));
        return;
    L166:
        return;
    L153:
        r23 = r32;
        r18 = r3;
        r21 = r13;
        goto L115
    L148:
        r13 = r30;
        goto L149
    L127:
        if (((r1 & 7168) ^ 3072) <= 2048) goto L131;
        if (r15.changed(r7) == false) goto L131;
    L132:
        boolean r43 = true;
    L135:
        if ((r1 & 896) != 256) goto L137;
        r19 = true;
    L137:
        boolean r44 = r43 | r19;
        Object r45 = r15.rememberedValue();
        if (r44 == false) goto L140;
    L141:
        r45 = new bp(r7, r6);
        r15.updateRememberedValue(r45);
    L142:
        r1 = r1 & (-57345);
        r9 = (Function2) r45;
        goto L143
    L140:
        if (r45 != Composer.Companion.getEmpty()) goto L142;
    L131:
        if ((r1 & 3072) == 2048) goto L132;
        r43 = false;
        goto L135
    L118:
        r3 = r26;
        goto L119
    L106:
        if (r15.getDefaultsInvalid() == true) goto L116;
        r15.skipToGroupEnd();
        if ((r35 & 8) == 0) goto L112;
        r1 = r1 & (-7169);
    L112:
        if ((r35 & 16) == 0) goto L114;
        r1 = r1 & (-57345);
    L114:
        r18 = r26;
        r21 = r30;
        r23 = r32;
        goto L115
    L161:
        r15.skipToGroupEnd();
        r36 = r26;
        r41 = r5;
        r37 = r6;
        r38 = r7;
        r39 = r9;
        r40 = r30;
        r42 = r32;
        goto L162
    L100:
        r0 = false;
        goto L102
    L91:
        if ((r34 & 100663296) != 0) goto L97;
        if (r15.changed(this) == false) goto L95;
        int r46 = 67108864;
    L96:
        r1 = r1 | r46;
        goto L97
    L95:
        r46 = 33554432;
        goto L96
    L81:
        if ((r34 & 12582912) != 0) goto L88;
        if (r15.changed(r32) == false) goto L85;
        int r114 = 8388608;
    L86:
        r1 = r1 | r114;
        goto L88
    L85:
        r114 = 4194304;
        goto L86
    L70:
        r5 = r31;
        if ((r34 & 1572864) != 0) goto L77;
        if (r15.changed(r5) == false) goto L75;
        int r115 = 1048576;
    L76:
        r1 = r1 | r115;
        goto L77
    L75:
        r115 = 524288;
        goto L76
    L61:
        if ((r34 & 196608) != 0) goto L67;
        if (r15.changedInstance(r30) == false) goto L65;
        int r116 = 131072;
    L66:
        r1 = r1 | r116;
        goto L67
    L65:
        r116 = 65536;
        goto L66
    L49:
        if ((r35 & 16) != 0) goto L53;
        r9 = r29;
        if (r15.changedInstance(r9) == false) goto L54;
        int r117 = 16384;
    L55:
        r1 = r1 | r117;
    L54:
        r117 = 8192;
        goto L55
    L53:
        r9 = r29;
        goto L54
    L38:
        if ((r35 & 8) != 0) goto L42;
        r7 = r28;
        if (r15.changed(r7) == false) goto L43;
        int r47 = 2048;
    L44:
        r1 = r1 | r47;
    L43:
        r47 = 1024;
        goto L44
    L42:
        r7 = r28;
        goto L43
    L28:
        if ((r34 & 384) != 0) goto L34;
        r6 = r27;
        if (r15.changed(r6) == false) goto L32;
        int r48 = 256;
    L33:
        r1 = r1 | r48;
        goto L36
    L32:
        r48 = 128;
        goto L33
    L17:
        if ((r34 & 48) != 0) goto L24;
        if (r15.changed(r26) == false) goto L21;
        int r49 = 32;
    L22:
        r1 = r1 | r49;
        goto L24
    L21:
        r49 = 16;
        goto L22
    L6:
        if ((r34 & 6) == 0) goto L8;
        r1 = r34;
        goto L13
    L8:
        if (r15.changedInstance(r25) == false) goto L10;
        int r50 = 4;
    L11:
        r1 = r50 | r34;
        goto L13
    L10:
        r50 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: CenteredTrack-7LSsfP0$material3, reason: not valid java name */
    public final void m3156CenteredTrack7LSsfP0$material3(final SliderState r28, Modifier r29, boolean r30, SliderColors r31, Function2<? super DrawScope, ? super Offset, Unit> r32, Function3<? super DrawScope, ? super Offset, ? super Color, Unit> r33, float r34, float r35, float r36, Composer r37, final int r38, final int r39) {
        Composer r12 = r37.startRestartGroup(1199441071);
        if ((r39 & 1) == 0) goto L6;
        int r1 = r38 | 6;
    L13:
        int r2 = r39 & 2;
        if (r2 == 0) goto L17;
        r1 = r1 | 48;
    L24:
        int r4 = r39 & 4;
        if (r4 == 0) goto L28;
        r1 = r1 | 384;
    L34:
        final boolean r6 = r30;
    L36:
        if ((r38 & 3072) == 0) goto L38;
        SliderColors r7 = r31;
    L47:
        if ((r38 & 24576) == 0) goto L49;
        Function2<? super DrawScope, ? super Offset, Unit> r9 = r32;
    L57:
        int r10 = r39 & 32;
        if (r10 == 0) goto L61;
        r1 = r1 | 196608;
    L67:
        int r17 = r39 & 64;
        if (r17 == 0) goto L71;
        r1 = r1 | 1572864;
    L77:
        int r8 = r39 & 128;
        if (r8 == 0) goto L81;
        r1 = r1 | 12582912;
    L87:
        int r0 = r39 & 256;
        if (r0 == 0) goto L91;
        r1 = r1 | 100663296;
    L98:
        if ((r39 & 512) == 0) goto L101;
        r1 = r1 | 805306368;
    L107:
        boolean r20 = false;
        if ((306783379 & r1) == 306783378) goto L110;
        boolean r3 = true;
    L112:
        if (r12.shouldExecute(r3, r1 & 1) == false) goto L177;
        r12.startDefaults();
        if ((r38 & 1) != 0) goto L116;
    L125:
        if (r2 == 0) goto L127;
        Modifier r5 = Modifier.Companion;
    L128:
        if (r4 == 0) goto L131;
        r6 = true;
    L131:
        if ((r39 & 8) == 0) goto L133;
        final SliderColors r11 = colors(r12, (r1 >> 27) & 14);
        r1 = r1 & (-7169);
    L135:
        if ((r39 & 16) != 0) goto L137;
        Function2<? super DrawScope, ? super Offset, Unit> r13 = r9;
    L154:
        if (r10 == 0) goto L159;
        Object r14 = r12.rememberedValue();
        if (r14 != Composer.Companion.getEmpty()) goto L158;
        r14 = SliderDefaults$CenteredTrack$2$1.INSTANCE;
        r12.updateRememberedValue(r14);
    L158:
        Function3<? super DrawScope, ? super Offset, ? super Color, Unit> r15 = (Function3) r14;
    L160:
        if (r17 == 0) goto L162;
        float r16 = SliderKt.access$getThumbTrackGapSize$p();
    L163:
        if (r8 == 0) goto L165;
        float r18 = SliderKt.access$getTrackInsideCornerSize$p();
    L166:
        if (r0 == 0) goto L168;
        float r25 = Dp.Companion.getUnspecified-D9Ej5fM();
    L169:
        Modifier r19 = r5;
        SliderColors r21 = r11;
        Function2<? super DrawScope, ? super Offset, Unit> r22 = r13;
        Function3<? super DrawScope, ? super Offset, ? super Color, Unit> r23 = r15;
        boolean r110 = r6;
        float r24 = r16;
        float r26 = r18;
    L170:
        r12.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L173;
        ComposerKt.traceEventStart(1199441071, r1, -1, "androidx.compose.material3.SliderDefaults.CenteredTrack (Slider.kt:1557)");
    L173:
        int r27 = ((r1 & 14) | 805306368) | ((r1 >> 21) & 112);
        int r40 = r1 << 3;
        float r41 = r25;
        Modifier r42 = r19;
        boolean r43 = r110;
        SliderColors r44 = r21;
        Function2<? super DrawScope, ? super Offset, Unit> r45 = r22;
        Function3<? super DrawScope, ? super Offset, ? super Color, Unit> r46 = r23;
        float r47 = r24;
        float r48 = r26;
        Composer r111 = r12;
        m3151TrackImplVvwgllI(r28, r41, r42, r43, r44, r45, r46, r47, r48, true, true, r12, ((((((r27 | (r40 & 896)) | (r40 & 7168)) | (57344 & r40)) | (458752 & r40)) | (3670016 & r40)) | (29360128 & r40)) | (r40 & 234881024), ((r1 >> 24) & 112) | 6);
        if (ComposerKt.isTraceInProgress() == false) goto L176;
        ComposerKt.traceEventEnd();
    L176:
        final Modifier r49 = r19;
        final boolean r50 = r110;
        final SliderColors r51 = r21;
        final Function2<? super DrawScope, ? super Offset, Unit> r52 = r22;
        final Function3<? super DrawScope, ? super Offset, ? super Color, Unit> r53 = r23;
        final float r54 = r24;
        final float r55 = r26;
        final float r112 = r25;
    L178:
        ScopeUpdateScope r113 = r111.endRestartGroup();
        if (r113 == null) goto L182;
        r113.updateScope(new wo(this, r28, r49, r50, r51, r52, r53, r54, r55, r112, r38, r39));
        return;
    L182:
        return;
    L168:
        r25 = r36;
        goto L169
    L165:
        r18 = r35;
        goto L166
    L162:
        r16 = r34;
        goto L163
    L159:
        r15 = r33;
        goto L160
    L137:
        if (((r1 & 7168) ^ 3072) <= 2048) goto L141;
        if (r12.changed(r11) == false) goto L141;
    L142:
        boolean r56 = true;
    L145:
        if ((r1 & 896) != 256) goto L147;
        r20 = true;
    L147:
        boolean r57 = r56 | r20;
        Object r58 = r12.rememberedValue();
        if (r57 == false) goto L150;
    L151:
        r58 = new vo(r11, r6);
        r12.updateRememberedValue(r58);
    L152:
        r13 = (Function2) r58;
        r1 = r1 & (-57345);
        goto L154
    L150:
        if (r58 != Composer.Companion.getEmpty()) goto L152;
    L141:
        if ((r1 & 3072) == 2048) goto L142;
        r56 = false;
        goto L145
    L133:
        r11 = r7;
        goto L135
    L127:
        r5 = r29;
        goto L128
    L116:
        if (r12.getDefaultsInvalid() == true) goto L125;
        r12.skipToGroupEnd();
        if ((r39 & 8) == 0) goto L122;
        r1 = r1 & (-7169);
    L122:
        if ((r39 & 16) == 0) goto L124;
        r1 = r1 & (-57345);
    L124:
        r19 = r29;
        r23 = r33;
        r24 = r34;
        r26 = r35;
        r25 = r36;
        r110 = r6;
        r21 = r7;
        r22 = r9;
        goto L170
    L177:
        r111 = r12;
        r111.skipToGroupEnd();
        r49 = r29;
        r54 = r34;
        r112 = r36;
        r50 = r6;
        r51 = r7;
        r52 = r9;
        r53 = r33;
        r55 = r35;
        goto L178
    L110:
        r3 = false;
        goto L112
    L101:
        if ((r38 & 805306368) != 0) goto L107;
        if (r12.changed(this) == false) goto L105;
        int r59 = 536870912;
    L106:
        r1 = r1 | r59;
        goto L107
    L105:
        r59 = 268435456;
        goto L106
    L91:
        if ((r38 & 100663296) != 0) goto L98;
        if (r12.changed(r36) == false) goto L95;
        int r114 = 67108864;
    L96:
        r1 = r1 | r114;
        goto L98
    L95:
        r114 = 33554432;
        goto L96
    L81:
        if ((r38 & 12582912) != 0) goto L87;
        if (r12.changed(r35) == false) goto L85;
        int r115 = 8388608;
    L86:
        r1 = r1 | r115;
        goto L87
    L85:
        r115 = 4194304;
        goto L86
    L71:
        if ((r38 & 1572864) != 0) goto L77;
        if (r12.changed(r34) == false) goto L75;
        int r116 = 1048576;
    L76:
        r1 = r1 | r116;
        goto L77
    L75:
        r116 = 524288;
        goto L76
    L61:
        if ((r38 & 196608) != 0) goto L67;
        if (r12.changedInstance(r33) == false) goto L65;
        int r117 = 131072;
    L66:
        r1 = r1 | r117;
        goto L67
    L65:
        r117 = 65536;
        goto L66
    L49:
        if ((r39 & 16) != 0) goto L53;
        r9 = r32;
        if (r12.changedInstance(r9) == false) goto L54;
        int r118 = 16384;
    L55:
        r1 = r1 | r118;
    L54:
        r118 = 8192;
        goto L55
    L53:
        r9 = r32;
        goto L54
    L38:
        if ((r39 & 8) != 0) goto L42;
        r7 = r31;
        if (r12.changed(r7) == false) goto L43;
        int r60 = 2048;
    L44:
        r1 = r1 | r60;
    L43:
        r60 = 1024;
        goto L44
    L42:
        r7 = r31;
        goto L43
    L28:
        if ((r38 & 384) != 0) goto L34;
        r6 = r30;
        if (r12.changed(r6) == false) goto L32;
        int r61 = 256;
    L33:
        r1 = r1 | r61;
        goto L36
    L32:
        r61 = 128;
        goto L33
    L17:
        if ((r38 & 48) != 0) goto L24;
        if (r12.changed(r29) == false) goto L21;
        int r62 = 32;
    L22:
        r1 = r1 | r62;
        goto L24
    L21:
        r62 = 16;
        goto L22
    L6:
        if ((r38 & 6) == 0) goto L8;
        r1 = r38;
        goto L13
    L8:
        if (r12.changedInstance(r28) == false) goto L10;
        int r63 = 4;
    L11:
        r1 = r63 | r38;
        goto L13
    L10:
        r63 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: Track-mnvyFg4$material3, reason: not valid java name */
    public final void m3162TrackmnvyFg4$material3(final SliderState r28, final float r29, Modifier r30, boolean r31, SliderColors r32, Function2<? super DrawScope, ? super Offset, Unit> r33, Function3<? super DrawScope, ? super Offset, ? super Color, Unit> r34, float r35, float r36, Composer r37, final int r38, final int r39) {
        Composer r12 = r37.startRestartGroup(1691224881);
        if ((r39 & 1) == 0) goto L6;
        int r1 = r38 | 6;
    L14:
        if ((r39 & 2) == 0) goto L17;
        r1 = r1 | 48;
    L23:
        int r2 = r39 & 4;
        if (r2 == 0) goto L27;
        r1 = r1 | 384;
    L34:
        int r4 = r39 & 8;
        if (r4 == 0) goto L38;
        r1 = r1 | 3072;
    L46:
        if ((r38 & 24576) == 0) goto L48;
        SliderColors r7 = r32;
    L57:
        if ((196608 & r38) == 0) goto L59;
        Function2<? super DrawScope, ? super Offset, Unit> r9 = r33;
    L67:
        int r16 = r39 & 64;
        if (r16 == 0) goto L71;
        r1 = r1 | 1572864;
    L77:
        int r5 = r39 & 128;
        if (r5 == 0) goto L80;
        r1 = r1 | 12582912;
        float r8 = r35;
    L87:
        int r0 = r39 & 256;
        if (r0 == 0) goto L91;
        r1 = r1 | 100663296;
    L98:
        if ((r39 & 512) == 0) goto L101;
        r1 = r1 | 805306368;
    L107:
        boolean r20 = false;
        if ((306783379 & r1) == 306783378) goto L110;
        boolean r3 = true;
    L112:
        if (r12.shouldExecute(r3, r1 & 1) == false) goto L175;
        r12.startDefaults();
        if ((r38 & 1) != 0) goto L116;
    L125:
        if (r2 == 0) goto L127;
        Modifier r6 = Modifier.Companion;
    L128:
        if (r4 == 0) goto L130;
        final boolean r10 = true;
    L132:
        if ((r39 & 16) == 0) goto L134;
        final SliderColors r11 = colors(r12, (r1 >> 27) & 14);
        r1 = r1 & (-57345);
    L136:
        if ((r39 & 32) != 0) goto L138;
        Function2<? super DrawScope, ? super Offset, Unit> r13 = r9;
    L155:
        if (r16 == 0) goto L160;
        Object r14 = r12.rememberedValue();
        if (r14 != Composer.Companion.getEmpty()) goto L159;
        r14 = SliderDefaults$Track$8$1.INSTANCE;
        r12.updateRememberedValue(r14);
    L159:
        Function3<? super DrawScope, ? super Offset, ? super Color, Unit> r15 = (Function3) r14;
    L161:
        if (r5 == 0) goto L163;
        float r17 = SliderKt.access$getThumbTrackGapSize$p();
    L164:
        if (r0 == 0) goto L166;
        float r24 = SliderKt.access$getTrackInsideCornerSize$p();
    L167:
        Modifier r18 = r6;
        boolean r19 = r10;
        SliderColors r21 = r11;
        float r23 = r17;
        Function2<? super DrawScope, ? super Offset, Unit> r22 = r13;
        Function3<? super DrawScope, ? super Offset, ? super Color, Unit> r25 = r15;
    L168:
        r12.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L171;
        ComposerKt.traceEventStart(1691224881, r1, -1, "androidx.compose.material3.SliderDefaults.Track (Slider.kt:1502)");
    L171:
        Modifier r26 = r18;
        boolean r27 = r19;
        SliderColors r40 = r21;
        Function2<? super DrawScope, ? super Offset, Unit> r41 = r22;
        Function3<? super DrawScope, ? super Offset, ? super Color, Unit> r42 = r25;
        float r43 = r23;
        float r44 = r24;
        Composer r110 = r12;
        m3151TrackImplVvwgllI(r28, r29, r26, r27, r40, r41, r42, r43, r44, true, false, r12, (((((((((r1 & 14) | 805306368) | (r1 & 112)) | (r1 & 896)) | (r1 & 7168)) | (57344 & r1)) | (458752 & r1)) | (3670016 & r1)) | (29360128 & r1)) | (234881024 & r1), ((r1 >> 24) & 112) | 6);
        if (ComposerKt.isTraceInProgress() == false) goto L174;
        ComposerKt.traceEventEnd();
    L174:
        final Modifier r45 = r18;
        final boolean r46 = r19;
        final SliderColors r47 = r21;
        final Function2<? super DrawScope, ? super Offset, Unit> r48 = r22;
        final Function3<? super DrawScope, ? super Offset, ? super Color, Unit> r49 = r25;
        final float r50 = r23;
        final float r111 = r24;
    L176:
        ScopeUpdateScope r112 = r110.endRestartGroup();
        if (r112 == null) goto L180;
        r112.updateScope(new oo(this, r28, r29, r45, r46, r47, r48, r49, r50, r111, r38, r39));
        return;
    L180:
        return;
    L166:
        r24 = r36;
        goto L167
    L163:
        r17 = r8;
        goto L164
    L160:
        r15 = r34;
        goto L161
    L138:
        if (((57344 & r1) ^ 24576) <= 16384) goto L142;
        if (r12.changed(r11) == false) goto L142;
    L143:
        boolean r51 = true;
    L146:
        if ((r1 & 7168) != 2048) goto L148;
        r20 = true;
    L148:
        boolean r52 = r51 | r20;
        Object r53 = r12.rememberedValue();
        if (r52 == false) goto L151;
    L152:
        r53 = new kp(r11, r10);
        r12.updateRememberedValue(r53);
    L153:
        r13 = (Function2) r53;
        r1 = r1 & (-458753);
        goto L155
    L151:
        if (r53 != Composer.Companion.getEmpty()) goto L153;
    L142:
        if ((r1 & 24576) == 16384) goto L143;
        r51 = false;
        goto L146
    L134:
        r11 = r7;
        goto L136
    L130:
        r10 = r31;
        goto L132
    L127:
        r6 = r30;
        goto L128
    L116:
        if (r12.getDefaultsInvalid() == true) goto L125;
        r12.skipToGroupEnd();
        if ((r39 & 16) == 0) goto L122;
        r1 = r1 & (-57345);
    L122:
        if ((r39 & 32) == 0) goto L124;
        r1 = r1 & (-458753);
    L124:
        r18 = r30;
        r19 = r31;
        r25 = r34;
        r24 = r36;
        r21 = r7;
        r23 = r8;
        r22 = r9;
        goto L168
    L175:
        r110 = r12;
        r110.skipToGroupEnd();
        r45 = r30;
        r46 = r31;
        r111 = r36;
        r47 = r7;
        r48 = r9;
        r50 = r8;
        r49 = r34;
        goto L176
    L110:
        r3 = false;
        goto L112
    L101:
        if ((r38 & 805306368) != 0) goto L107;
        if (r12.changed(this) == false) goto L105;
        int r54 = 536870912;
    L106:
        r1 = r1 | r54;
        goto L107
    L105:
        r54 = 268435456;
        goto L106
    L91:
        if ((r38 & 100663296) != 0) goto L98;
        if (r12.changed(r36) == false) goto L95;
        int r113 = 67108864;
    L96:
        r1 = r1 | r113;
        goto L98
    L95:
        r113 = 33554432;
        goto L96
    L80:
        r8 = r35;
        if ((r38 & 12582912) != 0) goto L87;
        if (r12.changed(r8) == false) goto L85;
        int r114 = 8388608;
    L86:
        r1 = r1 | r114;
        goto L87
    L85:
        r114 = 4194304;
        goto L86
    L71:
        if ((r38 & 1572864) != 0) goto L77;
        if (r12.changedInstance(r34) == false) goto L75;
        int r115 = 1048576;
    L76:
        r1 = r1 | r115;
        goto L77
    L75:
        r115 = 524288;
        goto L76
    L59:
        if ((r39 & 32) != 0) goto L63;
        r9 = r33;
        if (r12.changedInstance(r9) == false) goto L64;
        int r116 = 131072;
    L65:
        r1 = r1 | r116;
    L64:
        r116 = 65536;
        goto L65
    L63:
        r9 = r33;
        goto L64
    L48:
        if ((r39 & 16) != 0) goto L52;
        r7 = r32;
        if (r12.changed(r7) == false) goto L53;
        int r55 = 16384;
    L54:
        r1 = r1 | r55;
    L53:
        r55 = 8192;
        goto L54
    L52:
        r7 = r32;
        goto L53
    L38:
        if ((r38 & 3072) != 0) goto L46;
        if (r12.changed(r31) == false) goto L42;
        int r56 = 2048;
    L43:
        r1 = r1 | r56;
        goto L46
    L42:
        r56 = 1024;
        goto L43
    L27:
        if ((r38 & 384) != 0) goto L34;
        if (r12.changed(r30) == false) goto L31;
        int r57 = 256;
    L32:
        r1 = r1 | r57;
        goto L34
    L31:
        r57 = 128;
        goto L32
    L17:
        if ((r38 & 48) != 0) goto L23;
        if (r12.changed(r29) == false) goto L21;
        int r58 = 32;
    L22:
        r1 = r1 | r58;
        goto L23
    L21:
        r58 = 16;
        goto L22
    L6:
        if ((r38 & 6) == 0) goto L8;
        r1 = r38;
        goto L14
    L8:
        if (r12.changedInstance(r28) == false) goto L10;
        int r59 = 4;
    L11:
        r1 = r59 | r38;
        goto L14
    L10:
        r59 = 2;
        goto L11
    }

    /* JADX INFO: renamed from: Track-mnvyFg4$material3, reason: not valid java name */
    public final void m3161TrackmnvyFg4$material3(final RangeSliderState r25, final float r26, Modifier r27, boolean r28, SliderColors r29, Function2<? super DrawScope, ? super Offset, Unit> r30, Function3<? super DrawScope, ? super Offset, ? super Color, Unit> r31, float r32, float r33, Composer r34, final int r35, final int r36) {
        Composer r15 = r34.startRestartGroup(1952945688);
        if ((r36 & 1) == 0) goto L6;
        int r1 = r35 | 6;
    L14:
        if ((r36 & 2) == 0) goto L17;
        r1 = r1 | 48;
    L23:
        int r2 = r36 & 4;
        if (r2 == 0) goto L27;
        r1 = r1 | 384;
    L34:
        int r4 = r36 & 8;
        if (r4 == 0) goto L38;
        r1 = r1 | 3072;
    L46:
        if ((r35 & 24576) == 0) goto L48;
        SliderColors r7 = r29;
    L57:
        if ((196608 & r35) == 0) goto L59;
        Function2<? super DrawScope, ? super Offset, Unit> r9 = r30;
    L67:
        int r16 = r36 & 64;
        if (r16 == 0) goto L71;
        r1 = r1 | 1572864;
    L77:
        int r5 = r36 & 128;
        if (r5 == 0) goto L80;
        r1 = r1 | 12582912;
        float r8 = r32;
    L87:
        int r0 = r36 & 256;
        if (r0 == 0) goto L91;
        r1 = r1 | 100663296;
    L98:
        if ((r36 & 512) == 0) goto L101;
        r1 = r1 | 805306368;
    L107:
        boolean r19 = false;
        if ((306783379 & r1) == 306783378) goto L110;
        boolean r3 = true;
    L112:
        if (r15.shouldExecute(r3, r1 & 1) == false) goto L175;
        r15.startDefaults();
        if ((r35 & 1) != 0) goto L116;
    L125:
        if (r2 == 0) goto L127;
        Modifier r6 = Modifier.Companion;
    L128:
        if (r4 == 0) goto L130;
        final boolean r10 = true;
    L132:
        if ((r36 & 16) == 0) goto L134;
        final SliderColors r11 = colors(r15, (r1 >> 27) & 14);
        r1 = r1 & (-57345);
    L136:
        if ((r36 & 32) != 0) goto L138;
        Function2<? super DrawScope, ? super Offset, Unit> r12 = r9;
    L155:
        if (r16 == 0) goto L160;
        Object r13 = r15.rememberedValue();
        if (r13 != Composer.Companion.getEmpty()) goto L159;
        r13 = SliderDefaults$Track$15$1.INSTANCE;
        r15.updateRememberedValue(r13);
    L159:
        Function3<? super DrawScope, ? super Offset, ? super Color, Unit> r14 = (Function3) r13;
    L161:
        if (r5 == 0) goto L163;
        float r17 = SliderKt.access$getThumbTrackGapSize$p();
    L164:
        if (r0 == 0) goto L166;
        float r23 = SliderKt.access$getTrackInsideCornerSize$p();
    L167:
        Modifier r18 = r6;
        boolean r110 = r10;
        SliderColors r111 = r11;
        float r22 = r17;
        Function2<? super DrawScope, ? super Offset, Unit> r20 = r12;
        Function3<? super DrawScope, ? super Offset, ? super Color, Unit> r21 = r14;
    L168:
        r15.endDefaults();
        if (ComposerKt.isTraceInProgress() == false) goto L171;
        ComposerKt.traceEventStart(1952945688, r1, -1, "androidx.compose.material3.SliderDefaults.Track (Slider.kt:1785)");
    L171:
        Modifier r24 = r18;
        boolean r37 = r110;
        SliderColors r38 = r111;
        Function2<? super DrawScope, ? super Offset, Unit> r39 = r20;
        Function3<? super DrawScope, ? super Offset, ? super Color, Unit> r40 = r21;
        float r41 = r22;
        float r42 = r23;
        m3152TrackImplxlyIBlM(r25, r26, r24, r37, r38, r39, r40, r41, r42, r15, (((((((((r1 & 14) | (r1 & 112)) | (r1 & 896)) | (r1 & 7168)) | (57344 & r1)) | (458752 & r1)) | (3670016 & r1)) | (29360128 & r1)) | (234881024 & r1)) | (r1 & 1879048192));
        if (ComposerKt.isTraceInProgress() == false) goto L174;
        ComposerKt.traceEventEnd();
    L174:
        final Modifier r43 = r18;
        final boolean r44 = r110;
        final SliderColors r45 = r111;
        final Function2<? super DrawScope, ? super Offset, Unit> r46 = r20;
        final Function3<? super DrawScope, ? super Offset, ? super Color, Unit> r47 = r21;
        final float r48 = r22;
        final float r112 = r23;
    L176:
        ScopeUpdateScope r113 = r15.endRestartGroup();
        if (r113 == null) goto L180;
        r113.updateScope(new ip(this, r25, r26, r43, r44, r45, r46, r47, r48, r112, r35, r36));
        return;
    L180:
        return;
    L166:
        r23 = r33;
        goto L167
    L163:
        r17 = r8;
        goto L164
    L160:
        r14 = r31;
        goto L161
    L138:
        if (((57344 & r1) ^ 24576) <= 16384) goto L142;
        if (r15.changed(r11) == false) goto L142;
    L143:
        boolean r49 = true;
    L146:
        if ((r1 & 7168) != 2048) goto L148;
        r19 = true;
    L148:
        boolean r50 = r49 | r19;
        Object r51 = r15.rememberedValue();
        if (r50 == false) goto L151;
    L152:
        r51 = new hp(r11, r10);
        r15.updateRememberedValue(r51);
    L153:
        r12 = (Function2) r51;
        r1 = r1 & (-458753);
        goto L155
    L151:
        if (r51 != Composer.Companion.getEmpty()) goto L153;
    L142:
        if ((r1 & 24576) == 16384) goto L143;
        r49 = false;
        goto L146
    L134:
        r11 = r7;
        goto L136
    L130:
        r10 = r28;
        goto L132
    L127:
        r6 = r27;
        goto L128
    L116:
        if (r15.getDefaultsInvalid() == true) goto L125;
        r15.skipToGroupEnd();
        if ((r36 & 16) == 0) goto L122;
        r1 = r1 & (-57345);
    L122:
        if ((r36 & 32) == 0) goto L124;
        r1 = r1 & (-458753);
    L124:
        r18 = r27;
        r110 = r28;
        r21 = r31;
        r23 = r33;
        r111 = r7;
        r22 = r8;
        r20 = r9;
        goto L168
    L175:
        r15.skipToGroupEnd();
        r43 = r27;
        r44 = r28;
        r112 = r33;
        r45 = r7;
        r46 = r9;
        r48 = r8;
        r47 = r31;
        goto L176
    L110:
        r3 = false;
        goto L112
    L101:
        if ((r35 & 805306368) != 0) goto L107;
        if (r15.changed(this) == false) goto L105;
        int r52 = 536870912;
    L106:
        r1 = r1 | r52;
        goto L107
    L105:
        r52 = 268435456;
        goto L106
    L91:
        if ((r35 & 100663296) != 0) goto L98;
        if (r15.changed(r33) == false) goto L95;
        int r114 = 67108864;
    L96:
        r1 = r1 | r114;
        goto L98
    L95:
        r114 = 33554432;
        goto L96
    L80:
        r8 = r32;
        if ((r35 & 12582912) != 0) goto L87;
        if (r15.changed(r8) == false) goto L85;
        int r115 = 8388608;
    L86:
        r1 = r1 | r115;
        goto L87
    L85:
        r115 = 4194304;
        goto L86
    L71:
        if ((r35 & 1572864) != 0) goto L77;
        if (r15.changedInstance(r31) == false) goto L75;
        int r116 = 1048576;
    L76:
        r1 = r1 | r116;
        goto L77
    L75:
        r116 = 524288;
        goto L76
    L59:
        if ((r36 & 32) != 0) goto L63;
        r9 = r30;
        if (r15.changedInstance(r9) == false) goto L64;
        int r117 = 131072;
    L65:
        r1 = r1 | r117;
    L64:
        r117 = 65536;
        goto L65
    L63:
        r9 = r30;
        goto L64
    L48:
        if ((r36 & 16) != 0) goto L52;
        r7 = r29;
        if (r15.changed(r7) == false) goto L53;
        int r53 = 16384;
    L54:
        r1 = r1 | r53;
    L53:
        r53 = 8192;
        goto L54
    L52:
        r7 = r29;
        goto L53
    L38:
        if ((r35 & 3072) != 0) goto L46;
        if (r15.changed(r28) == false) goto L42;
        int r54 = 2048;
    L43:
        r1 = r1 | r54;
        goto L46
    L42:
        r54 = 1024;
        goto L43
    L27:
        if ((r35 & 384) != 0) goto L34;
        if (r15.changed(r27) == false) goto L31;
        int r55 = 256;
    L32:
        r1 = r1 | r55;
        goto L34
    L31:
        r55 = 128;
        goto L32
    L17:
        if ((r35 & 48) != 0) goto L23;
        if (r15.changed(r26) == false) goto L21;
        int r56 = 32;
    L22:
        r1 = r1 | r56;
        goto L23
    L21:
        r56 = 16;
        goto L22
    L6:
        if ((r35 & 6) == 0) goto L8;
        r1 = r35;
        goto L14
    L8:
        if (r15.changedInstance(r25) == false) goto L10;
        int r57 = 4;
    L11:
        r1 = r57 | r35;
        goto L14
    L10:
        r57 = 2;
        goto L11
    }

    private static final Unit TrackImpl_VvwgllI$lambda$31$lambda$30(float r26, SliderState r27, long r28, long r30, long r32, long r34, float r36, float r37, Function2 r38, Function3 r39, boolean r40, boolean r41, DrawScope r42) {
        if (Dp.equals-impl0(r26, Dp.Companion.getUnspecified-D9Ej5fM()) == true) goto L5;
        float r0 = r42.toPx-0680j_4(r26);
    L10:
        INSTANCE.m3153drawTrackGVD57ws(r42, r27.getTickFractions$material3(), MenuKt.ClosedAlphaTarget, r27.getCoercedValueAsFraction(), r28, r30, r32, r34, r42.toDp-u2uoSUM(0), r42.toDp-u2uoSUM(0), r42.toDp-u2uoSUM(r27.getThumbWidth$material3()), r42.toDp-u2uoSUM(r27.getThumbHeight$material3()), r36, r37, r42.toDp-u2uoSUM(r0), r38, r39, false, r40, r27.getOrientation$material3(), r41);
        return Unit.INSTANCE;
    L5:
        if (r27.getOrientation$material3() != Orientation.Vertical) goto L7;
        float r1 = Float.intBitsToFloat((int) (r42.getSize-NH-jbRc() >> 32));
    L8:
        r0 = r1 / 2;
        goto L10
    L7:
        r1 = Float.intBitsToFloat((int) (r42.getSize-NH-jbRc() & 4294967295L));
        goto L8
    }

    /* JADX INFO: renamed from: TrackImpl-VvwgllI, reason: not valid java name */
    private final void m3151TrackImplVvwgllI(final SliderState r29, final float r30, final Modifier r31, final boolean r32, final SliderColors r33, final Function2<? super DrawScope, ? super Offset, Unit> r34, final Function3<? super DrawScope, ? super Offset, ? super Color, Unit> r35, final float r36, final float r37, final boolean r38, final boolean r39, Composer r40, final int r41, final int r42) {
        Composer r10 = r40.startRestartGroup(133396521);
        if ((r41 & 6) == 0) goto L5;
        int r1 = r41;
    L11:
        if ((r41 & 48) != 0) goto L18;
        if (r10.changed(r30) == false) goto L15;
        int r4 = 32;
    L16:
        r1 = r1 | r4;
        goto L18
    L15:
        r4 = 16;
    L18:
        if ((r41 & 384) != 0) goto L25;
        if (r10.changed(r31) == false) goto L22;
        int r5 = 256;
    L23:
        r1 = r1 | r5;
        goto L25
    L22:
        r5 = 128;
    L25:
        if ((r41 & 3072) != 0) goto L32;
        if (r10.changed(r32) == false) goto L29;
        int r6 = 2048;
    L30:
        r1 = r1 | r6;
        goto L32
    L29:
        r6 = 1024;
    L32:
        if ((r41 & 24576) != 0) goto L39;
        if (r10.changed(r33) == false) goto L36;
        int r7 = 16384;
    L37:
        r1 = r1 | r7;
        goto L39
    L36:
        r7 = 8192;
    L39:
        if ((196608 & r41) != 0) goto L46;
        if (r10.changedInstance(r34) == false) goto L43;
        int r8 = 131072;
    L44:
        r1 = r1 | r8;
        goto L46
    L43:
        r8 = 65536;
    L46:
        if ((1572864 & r41) != 0) goto L54;
        if (r10.changedInstance(r35) == false) goto L50;
        int r16 = 1048576;
    L51:
        r1 = r1 | r16;
        goto L54
    L50:
        r16 = 524288;
    L54:
        if ((r41 & 12582912) != 0) goto L61;
        if (r10.changed(r36) == false) goto L58;
        int r17 = 8388608;
    L59:
        r1 = r1 | r17;
        goto L61
    L58:
        r17 = 4194304;
    L61:
        if ((r41 & 100663296) != 0) goto L68;
        if (r10.changed(r37) == false) goto L65;
        int r19 = 67108864;
    L66:
        r1 = r1 | r19;
        goto L68
    L65:
        r19 = 33554432;
    L68:
        if ((r41 & 805306368) != 0) goto L75;
        if (r10.changed(r38) == false) goto L72;
        int r20 = 536870912;
    L73:
        r1 = r1 | r20;
        goto L75
    L72:
        r20 = 268435456;
    L75:
        if ((r42 & 6) == 0) goto L77;
        int r0 = r42;
    L83:
        if ((r1 & 306783379) == 306783378) goto L85;
    L88:
        boolean r2 = true;
    L90:
        if (r10.shouldExecute(r2, r1 & 1) == true) goto L92;
        Composer r3 = r10;
        r3.skipToGroupEnd();
    L148:
        ScopeUpdateScope r15 = r3.endRestartGroup();
        if (r15 == null) goto L152;
        r15.updateScope(new ap(this, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r41, r42));
        return;
    L152:
        return;
    L92:
        if (ComposerKt.isTraceInProgress() == false) goto L94;
        ComposerKt.traceEventStart(133396521, r1, r0, "androidx.compose.material3.SliderDefaults.TrackImpl (Slider.kt:1587)");
    L94:
        final long r9 = r33.m3150trackColorWaAFU9c$material3(r32, false);
        final long r11 = r33.m3150trackColorWaAFU9c$material3(r32, true);
        final long r12 = r33.m3149tickColorWaAFU9c$material3(r32, false);
        final long r13 = r33.m3149tickColorWaAFU9c$material3(r32, true);
        if (r29.getOrientation$material3() != Orientation.Vertical) goto L99;
        Modifier r14 = SizeKt.fillMaxHeight$default(SizeKt.m1019width3ABfNKs(r31, SliderKt.getTrackHeight()), MenuKt.ClosedAlphaTarget, 1, null);
        if (r29.getReverseVerticalDirection$material3() == false) goto L100;
        r14 = ScaleKt.scale(r14, 1.0f, -1.0f);
    L100:
        Modifier.Companion r18 = Modifier.Companion;
        int r110 = r1 & 112;
        if (r110 != 32) goto L103;
        boolean r111 = true;
    L104:
        boolean r112 = r111 | r10.changedInstance(r29);
        Object r113 = r10.rememberedValue();
        if (r112 == false) goto L107;
    L108:
        r113 = new xo(r30, r29);
        r10.updateRememberedValue(r113);
    L109:
        Modifier r114 = r14.then(LayoutModifierKt.layout(r18, (Function3) r113));
        if (r110 != 32) goto L112;
        boolean r21 = true;
    L113:
        boolean r22 = ((((r21 | r10.changedInstance(r29)) | r10.changed(r9)) | r10.changed(r11)) | r10.changed(r12)) | r10.changed(r13);
        if ((29360128 & r1) != 8388608) goto L116;
        boolean r23 = true;
    L117:
        boolean r24 = r23 | r22;
        if ((234881024 & r1) != 67108864) goto L120;
        boolean r25 = true;
    L121:
        boolean r26 = r24 | r25;
        if ((458752 & r1) != 131072) goto L124;
        boolean r27 = true;
    L125:
        boolean r28 = r26 | r27;
        if ((3670016 & r1) != 1048576) goto L128;
        boolean r43 = true;
    L129:
        boolean r44 = r28 | r43;
        if ((r1 & 1879048192) != 536870912) goto L132;
        boolean r45 = true;
    L133:
        boolean r46 = r45 | r44;
        if ((r0 & 14) != 4) goto L136;
        boolean r47 = true;
    L137:
        boolean r48 = r46 | r47;
        Object r49 = r10.rememberedValue();
        if (r48 == false) goto L140;
    L143:
        r49 = new zo(r30, r29, r9, r11, r12, r13, r36, r37, r34, r35, r38, r39);
        r3 = r10;
        r3.updateRememberedValue(r49);
    L144:
        CanvasKt.Canvas(r114, (Function1) r49, r3, 0);
        if (ComposerKt.isTraceInProgress() == false) goto L148;
        ComposerKt.traceEventEnd();
        goto L148
    L140:
        if (r49 == Composer.Companion.getEmpty()) goto L143;
        r3 = r10;
        goto L144
    L136:
        r47 = false;
        goto L137
    L132:
        r45 = false;
        goto L133
    L128:
        r43 = false;
        goto L129
    L124:
        r27 = false;
        goto L125
    L120:
        r25 = false;
        goto L121
    L116:
        r23 = false;
        goto L117
    L112:
        r21 = false;
        goto L113
    L107:
        if (r113 != Composer.Companion.getEmpty()) goto L109;
    L103:
        r111 = false;
        goto L104
    L99:
        r14 = SizeKt.m1000height3ABfNKs(SizeKt.fillMaxWidth$default(r31, MenuKt.ClosedAlphaTarget, 1, null), SliderKt.getTrackHeight());
        goto L100
    L85:
        if ((r0 & 3) != 2) goto L88;
        r2 = false;
        goto L90
    L77:
        if (r10.changed(r39) == false) goto L79;
        int r210 = 4;
    L80:
        r0 = r42 | r210;
        goto L83
    L79:
        r210 = 2;
        goto L80
    L5:
        if (r10.changedInstance(r29) == false) goto L7;
        int r50 = 4;
    L8:
        r1 = r50 | r41;
        goto L11
    L7:
        r50 = 2;
        goto L8
    }

    /* JADX INFO: renamed from: colors-q0g_0yA, reason: not valid java name */
    public final SliderColors m3163colorsq0g_0yA(long r26, long r28, long r30, long r32, long r34, long r36, long r38, long r40, long r42, long r44, Composer r46, int r47, int r48, int r49) {
        if ((r49 & 1) == 0) goto L5;
        long r1 = Color.Companion.getUnspecified-0d7_KjU();
    L7:
        if ((r49 & 2) == 0) goto L9;
        long r3 = Color.Companion.getUnspecified-0d7_KjU();
    L11:
        if ((r49 & 4) == 0) goto L13;
        long r5 = Color.Companion.getUnspecified-0d7_KjU();
    L15:
        if ((r49 & 8) == 0) goto L17;
        long r7 = Color.Companion.getUnspecified-0d7_KjU();
    L19:
        if ((r49 & 16) == 0) goto L21;
        long r9 = Color.Companion.getUnspecified-0d7_KjU();
    L23:
        if ((r49 & 32) == 0) goto L25;
        long r11 = Color.Companion.getUnspecified-0d7_KjU();
    L27:
        if ((r49 & 64) == 0) goto L29;
        long r13 = Color.Companion.getUnspecified-0d7_KjU();
    L31:
        if ((r49 & 128) == 0) goto L33;
        long r15 = Color.Companion.getUnspecified-0d7_KjU();
    L34:
        long r17 = r15;
        if ((r49 & 256) == 0) goto L37;
        long r16 = Color.Companion.getUnspecified-0d7_KjU();
    L39:
        if ((r49 & 512) == 0) goto L41;
        long r19 = Color.Companion.getUnspecified-0d7_KjU();
    L43:
        if (ComposerKt.isTraceInProgress() == false) goto L46;
        ComposerKt.traceEventStart(885588574, r47, r48, "androidx.compose.material3.SliderDefaults.colors (Slider.kt:1149)");
    L46:
        SliderColors r0 = getDefaultSliderColors$material3(MaterialTheme.INSTANCE.getColorScheme(r46, 6)).m3137copyK518z4(r1, r3, r5, r7, r9, r11, r13, r17, r16, r19);
        if (ComposerKt.isTraceInProgress() == false) goto L49;
        ComposerKt.traceEventEnd();
    L49:
        return r0;
    L41:
        r19 = r44;
        goto L43
    L37:
        r16 = r42;
        goto L39
    L33:
        r15 = r40;
        goto L34
    L29:
        r13 = r38;
        goto L31
    L25:
        r11 = r36;
        goto L27
    L21:
        r9 = r34;
        goto L23
    L17:
        r7 = r32;
        goto L19
    L13:
        r5 = r30;
        goto L15
    L9:
        r3 = r28;
        goto L11
    L5:
        r1 = r26;
        goto L7
    }

    /* JADX INFO: renamed from: drawTrack-GVD57ws, reason: not valid java name */
    private final void m3153drawTrackGVD57ws(DrawScope r34, float[] r35, float r36, float r37, long r38, long r40, long r42, long r44, float r46, float r47, float r48, float r49, float r50, float r51, float r52, Function2<? super DrawScope, ? super Offset, Unit> r53, Function3<? super DrawScope, ? super Offset, ? super Color, Unit> r54, boolean r55, boolean r56, Orientation r57, boolean r58) {
        if (r57 != Orientation.Vertical) goto L5;
        boolean r16 = true;
    L7:
        if (r34.getLayoutDirection() != LayoutDirection.Rtl) goto L9;
        boolean r17 = true;
    L10:
        if (r17 == false) goto L13;
        if (r16 == true) goto L13;
        boolean r18 = true;
    L14:
        float r19 = r34.toPx-0680j_4(r52);
        long r3 = r34.getSize-NH-jbRc();
        if (r16 == false) goto L17;
        long r4 = r3 & 4294967295L;
    L18:
        float r5 = Float.intBitsToFloat((int) r4);
        if (Intrinsics.areEqual(r36, ArraysKt.firstOrNull(r35)) == false) goto L21;
    L24:
        boolean r6 = true;
    L26:
        if (Intrinsics.areEqual(r37, ArraysKt.firstOrNull(r35)) == false) goto L28;
    L31:
        boolean r7 = true;
    L33:
        if (r35.length != 0) goto L35;
        boolean r8 = true;
    L37:
        if ((!r8) == false) goto L40;
        if (r7 == true) goto L40;
        float r9 = ((((r5 - MenuKt.ClosedAlphaTarget) - (2 * r19)) * r37) + MenuKt.ClosedAlphaTarget) + r19;
    L41:
        float r10 = r9;
        if (r35.length != 0) goto L44;
        boolean r1 = true;
    L46:
        if ((!r1) == false) goto L49;
        if (r6 == true) goto L49;
        float r2 = ((((r5 - MenuKt.ClosedAlphaTarget) - (2 * r19)) * r36) + MenuKt.ClosedAlphaTarget) + r19;
    L50:
        float r25 = r2;
        float r26 = r34.toPx-0680j_4(r51);
        if (Dp.compareTo-0680j_4(r50, Dp.constructor-impl(0)) <= 0) goto L56;
        if (r16 == false) goto L54;
        float r11 = 2;
        float r0 = (r34.toPx-0680j_4(r47) / r11) + r34.toPx-0680j_4(r50);
        float r12 = r34.toPx-0680j_4(r49) / r11;
        float r13 = r34.toPx-0680j_4(r50);
    L55:
        float r27 = r0;
        float r28 = r12 + r13;
    L57:
        long r14 = r34.getCenter-F1C5BW0();
        if (r16 == false) goto L60;
        long r15 = r14 & 4294967295L;
    L61:
        float r20 = Float.intBitsToFloat((int) r15);
        float r21 = r27 + MenuKt.ClosedAlphaTarget;
        if (r56 == true) goto L64;
    L69:
        r21 = r21 + r19;
    L70:
        if (r58 == false) goto L72;
        float r29 = Math.min(r10, r20);
    L73:
        if (r58 == true) goto L76;
        if (r55 == true) goto L76;
    L99:
        float r110 = r20;
        float r32 = r10;
    L100:
        float r22 = r5 - r28;
        if (r56 == true) goto L103;
    L108:
        r22 = r22 - r19;
    L109:
        if (r58 == false) goto L111;
        float r111 = r32;
        float r30 = Math.max(r111, r110);
    L113:
        if (r30 >= r22) goto L142;
        if (r18 == false) goto L116;
        float r23 = r19;
    L117:
        if (r18 == false) goto L119;
        float r31 = r26;
    L120:
        float r24 = r30 + r28;
        float r33 = r5 - r24;
        if (r16 == false) goto L124;
        long r39 = Offset.constructor-impl((Float.floatToRawIntBits(MenuKt.ClosedAlphaTarget) << 32) | (((long) Float.floatToRawIntBits(r24)) & 4294967295L));
    L123:
        long r41 = r39;
        if (r16 == false) goto L130;
        long r43 = Float.floatToRawIntBits(Float.intBitsToFloat((int) (r34.getSize-NH-jbRc() >> 32)));
        long r45 = Size.constructor-impl((((long) Float.floatToRawIntBits(r33)) & 4294967295L) | (r43 << 32));
    L134:
        float r310 = r111;
        m3155drawTrackPathzXTsYAs(r34, r57, r41, r45, r38, r23, r31);
        if (r16 == false) goto L137;
        long r59 = Float.floatToRawIntBits(Float.intBitsToFloat((int) (r34.getCenter-F1C5BW0() >> 32)));
        long r60 = Offset.constructor-impl((((long) Float.floatToRawIntBits(r5 - r19)) & 4294967295L) | (r59 << 32));
    L140:
        if (r53 == null) goto L143;
        r53.invoke(r34, Offset.box-impl(r60));
        Unit r61 = Unit.INSTANCE;
    L143:
        if (r58 == true) goto L145;
        if (r55 == false) goto L152;
        float r210 = r25 + r27;
    L151:
        float r112 = r210;
    L153:
        if (r58 == true) goto L155;
        float r311 = r310 - r28;
    L160:
        float r62 = r311;
        if (r18 == true) goto L166;
        if (r58 == true) goto L166;
        if (r55 == true) goto L166;
        float r211 = r19;
    L167:
        if (r18 == false) goto L171;
        if (r58 == true) goto L171;
        if (r55 == true) goto L171;
        r26 = r19;
    L171:
        if (r18 == false) goto L175;
        if (r58 == true) goto L175;
        if (r55 == true) goto L175;
        float r63 = r62;
    L176:
        if (r56 == true) goto L178;
    L185:
        float r64 = r211;
    L187:
        if (r63 <= r64) goto L204;
        if (r16 == false) goto L191;
        long r65 = Offset.constructor-impl((Float.floatToRawIntBits(MenuKt.ClosedAlphaTarget) << 32) | (((long) Float.floatToRawIntBits(r112)) & 4294967295L));
    L190:
        long r66 = r65;
        if (r16 == false) goto L197;
        long r67 = Size.constructor-impl((Float.floatToRawIntBits(Float.intBitsToFloat((int) (r34.getSize-NH-jbRc() >> 32))) << 32) | (Float.floatToRawIntBits(r63) & 4294967295L));
    L202:
        m3155drawTrackPathzXTsYAs(r34, r57, r66, r67, r40, r211, r26);
        goto L204
    L197:
        if (r17 == false) goto L201;
        if (r58 == true) goto L201;
        if (r55 == true) goto L201;
        float r68 = Float.intBitsToFloat((int) (r34.getSize-NH-jbRc() & 4294967295L));
        r67 = Size.constructor-impl((Float.floatToRawIntBits(r62) << 32) | (Float.floatToRawIntBits(r68) & 4294967295L));
    L201:
        float r69 = Float.intBitsToFloat((int) (r34.getSize-NH-jbRc() & 4294967295L));
        long r70 = Float.floatToRawIntBits(r63);
        r67 = Size.constructor-impl((((long) Float.floatToRawIntBits(r69)) & 4294967295L) | (r70 << 32));
        goto L202
    L191:
        if (r17 == false) goto L193;
        r65 = Offset.constructor-impl((Float.floatToRawIntBits(Float.intBitsToFloat((int) (r34.getSize-NH-jbRc() >> 32)) - r62) << 32) | (((long) Float.floatToRawIntBits(MenuKt.ClosedAlphaTarget)) & 4294967295L));
        goto L190
    L193:
        r65 = Offset.constructor-impl((Float.floatToRawIntBits(r112) << 32) | (((long) Float.floatToRawIntBits(MenuKt.ClosedAlphaTarget)) & 4294967295L));
    L204:
        float r71 = MenuKt.ClosedAlphaTarget + r19;
        float r72 = r5 - r19;
        ClosedFloatingPointRange r73 = RangesKt.rangeTo(r112, r62);
        ClosedFloatingPointRange r74 = RangesKt.rangeTo(r110 - r28, r110 + r28);
        ClosedFloatingPointRange r75 = RangesKt.rangeTo(r25 - r27, r25 + r27);
        ClosedFloatingPointRange r76 = RangesKt.rangeTo(r310 - r28, r310 + r28);
        int r77 = r35.length;
        int r78 = 0;
        int r79 = 0;
    L205:
        if (r78 >= r77) goto L241;
        float r80 = r35[r78];
        int r113 = r79 + 1;
        if (r53 == null) goto L219;
        if (r58 == true) goto L210;
        if (r55 == true) goto L210;
    L212:
        boolean r114 = false;
    L213:
        if (r114 == true) goto L228;
        if (r79 != (r35.length - 1)) goto L219;
    L228:
        float r312 = r71;
        float r313 = r72;
    L240:
        r78 = r78 + 1;
        r71 = r312;
        r72 = r313;
        r79 = r113;
    L210:
        if (r79 != 0) goto L212;
        r114 = true;
    L219:
        float r81 = MathHelpersKt.lerp(r71, r72, r80);
        if (r58 == true) goto L222;
    L223:
        if (r55 == false) goto L227;
        if (r75.contains(Float.valueOf(r81)) == true) goto L228;
    L227:
        if (r76.contains(Float.valueOf(r81)) == true) goto L228;
        if (r16 == false) goto L231;
        long r115 = Float.floatToRawIntBits(Float.intBitsToFloat((int) (r34.getCenter-F1C5BW0() >> 32)));
        r312 = r71;
        r313 = r72;
        long r82 = Offset.constructor-impl((((long) Float.floatToRawIntBits(r81)) & 4294967295L) | (r115 << 32));
    L235:
        Offset r83 = Offset.box-impl(r82);
        if (r73.contains(Float.valueOf(r81)) == false) goto L238;
        long r84 = r44;
    L239:
        r54.invoke(r34, r83, Color.box-impl(r84));
        goto L240
    L238:
        r84 = r42;
        goto L239
    L231:
        r312 = r71;
        r313 = r72;
        if (r17 == false) goto L234;
        float r85 = Float.intBitsToFloat((int) (r34.getSize-NH-jbRc() >> 32)) - r81;
        float r86 = Float.intBitsToFloat((int) (r34.getCenter-F1C5BW0() & 4294967295L));
        long r116 = Float.floatToRawIntBits(r85);
        r82 = Offset.constructor-impl((((long) Float.floatToRawIntBits(r86)) & 4294967295L) | (r116 << 32));
        goto L235
    L234:
        float r87 = Float.intBitsToFloat((int) (r34.getCenter-F1C5BW0() & 4294967295L));
        long r117 = Float.floatToRawIntBits(r81);
        r82 = Offset.constructor-impl((((long) Float.floatToRawIntBits(r87)) & 4294967295L) | (r117 << 32));
        goto L235
    L222:
        if (r74.contains(Float.valueOf(r81)) == true) goto L228;
    L241:
        return;
    L178:
        if (r35.length != 0) goto L180;
        boolean r88 = true;
    L182:
        if ((!r88) == true) goto L185;
        r64 = MenuKt.ClosedAlphaTarget;
        goto L187
    L180:
        r88 = false;
    L175:
        r63 = r62 - r112;
    L166:
        r211 = r26;
        goto L167
    L155:
        if (r30 <= r110) goto L157;
        float r89 = r28;
    L158:
        r311 = r30 - r89;
        goto L160
    L157:
        r89 = MenuKt.ClosedAlphaTarget;
        goto L158
    L152:
        r112 = MenuKt.ClosedAlphaTarget;
        goto L153
    L145:
        if (r29 >= r110) goto L147;
        float r90 = r27;
    L148:
        r210 = r29 + r90;
        goto L151
    L147:
        r90 = MenuKt.ClosedAlphaTarget;
        goto L148
    L137:
        if (r17 == false) goto L139;
        float r91 = Float.intBitsToFloat((int) (r34.getCenter-F1C5BW0() & 4294967295L));
        r60 = Offset.constructor-impl((Float.floatToRawIntBits(r19) << 32) | (Float.floatToRawIntBits(r91) & 4294967295L));
        goto L140
    L139:
        float r92 = Float.intBitsToFloat((int) (r34.getCenter-F1C5BW0() & 4294967295L));
        long r93 = Float.floatToRawIntBits(r5 - r19);
        r60 = Offset.constructor-impl((((long) Float.floatToRawIntBits(r92)) & 4294967295L) | (r93 << 32));
        goto L140
    L130:
        if (r17 == false) goto L133;
        if (r55 == true) goto L133;
        float r94 = Float.intBitsToFloat((int) (r34.getSize-NH-jbRc() >> 32)) - r24;
        float r95 = Float.intBitsToFloat((int) (r34.getSize-NH-jbRc() & 4294967295L));
        r45 = Size.constructor-impl((Float.floatToRawIntBits(r94) << 32) | (Float.floatToRawIntBits(r95) & 4294967295L));
    L133:
        float r96 = Float.intBitsToFloat((int) (r34.getSize-NH-jbRc() & 4294967295L));
        r45 = Size.constructor-impl((Float.floatToRawIntBits(r33) << 32) | (Float.floatToRawIntBits(r96) & 4294967295L));
        goto L134
    L124:
        if (r17 == false) goto L126;
        r39 = Offset.constructor-impl((Float.floatToRawIntBits(MenuKt.ClosedAlphaTarget) << 32) | (((long) Float.floatToRawIntBits(MenuKt.ClosedAlphaTarget)) & 4294967295L));
        goto L123
    L126:
        r39 = Offset.constructor-impl((Float.floatToRawIntBits(r24) << 32) | (((long) Float.floatToRawIntBits(MenuKt.ClosedAlphaTarget)) & 4294967295L));
        goto L123
    L119:
        r31 = r19;
        goto L120
    L116:
        r23 = r26;
        goto L117
    L142:
        r310 = r111;
        goto L143
    L111:
        r111 = r32;
        r30 = r111;
        goto L113
    L103:
        if (r35.length != 0) goto L105;
        boolean r97 = true;
    L107:
        if ((!r97) == false) goto L109;
    L105:
        r97 = false;
    L76:
        if (r29 <= r21) goto L99;
        if (r18 == false) goto L79;
        float r314 = r26;
    L80:
        if (r18 == false) goto L82;
        float r315 = r19;
    L83:
        float r98 = r29 - r27;
        if (r18 == false) goto L86;
        long r99 = Offset.constructor-impl((Float.floatToRawIntBits(Float.intBitsToFloat((int) (r34.getSize-NH-jbRc() >> 32)) - r98) << 32) | (((long) Float.floatToRawIntBits(MenuKt.ClosedAlphaTarget)) & 4294967295L));
    L87:
        long r100 = r99;
        if (r16 == false) goto L90;
        float r101 = Float.intBitsToFloat((int) (r34.getSize-NH-jbRc() >> 32));
        float r102 = r98 - MenuKt.ClosedAlphaTarget;
        long r103 = Size.constructor-impl((Float.floatToRawIntBits(r101) << 32) | (Float.floatToRawIntBits(r102) & 4294967295L));
    L91:
        r110 = r20;
        r32 = r10;
        m3155drawTrackPathzXTsYAs(r34, r57, r100, r103, r38, r314, r315);
        if (r16 == false) goto L94;
        float r104 = Float.intBitsToFloat((int) (r34.getCenter-F1C5BW0() >> 32));
        float r105 = r19 + MenuKt.ClosedAlphaTarget;
        long r106 = Float.floatToRawIntBits(r104);
        long r107 = Offset.constructor-impl((((long) Float.floatToRawIntBits(r105)) & 4294967295L) | (r106 << 32));
    L97:
        if (r53 == null) goto L100;
        r53.invoke(r34, Offset.box-impl(r107));
        Unit r108 = Unit.INSTANCE;
        goto L100
    L94:
        if (r17 == false) goto L96;
        float r109 = (Float.intBitsToFloat((int) (r34.getSize-NH-jbRc() >> 32)) - MenuKt.ClosedAlphaTarget) - r19;
        float r118 = Float.intBitsToFloat((int) (r34.getCenter-F1C5BW0() & 4294967295L));
        long r119 = Float.floatToRawIntBits(r109);
        r107 = Offset.constructor-impl((((long) Float.floatToRawIntBits(r118)) & 4294967295L) | (r119 << 32));
        goto L97
    L96:
        float r120 = r19 + MenuKt.ClosedAlphaTarget;
        float r121 = Float.intBitsToFloat((int) (r34.getCenter-F1C5BW0() & 4294967295L));
        long r122 = Float.floatToRawIntBits(r120);
        r107 = Offset.constructor-impl((((long) Float.floatToRawIntBits(r121)) & 4294967295L) | (r122 << 32));
        goto L97
    L90:
        float r123 = r98 - MenuKt.ClosedAlphaTarget;
        float r124 = Float.intBitsToFloat((int) (r34.getSize-NH-jbRc() & 4294967295L));
        long r125 = Float.floatToRawIntBits(r123);
        r103 = Size.constructor-impl((((long) Float.floatToRawIntBits(r124)) & 4294967295L) | (r125 << 32));
        goto L91
    L86:
        r99 = Offset.constructor-impl((Float.floatToRawIntBits(MenuKt.ClosedAlphaTarget) << 32) | (((long) Float.floatToRawIntBits(MenuKt.ClosedAlphaTarget)) & 4294967295L));
        goto L87
    L82:
        r315 = r26;
        goto L83
    L79:
        r314 = r19;
        goto L80
    L72:
        r29 = r25;
        goto L73
    L64:
        if (r35.length != 0) goto L66;
        boolean r126 = true;
    L68:
        if ((!r126) == false) goto L70;
    L66:
        r126 = false;
        goto L68
    L60:
        r15 = r14 >> 32;
        goto L61
    L54:
        float r127 = 2;
        r0 = (r34.toPx-0680j_4(r46) / r127) + r34.toPx-0680j_4(r50);
        r12 = r34.toPx-0680j_4(r48) / r127;
        r13 = r34.toPx-0680j_4(r50);
        goto L55
    L56:
        r27 = MenuKt.ClosedAlphaTarget;
        r28 = MenuKt.ClosedAlphaTarget;
    L49:
        r2 = MenuKt.ClosedAlphaTarget + ((r5 - MenuKt.ClosedAlphaTarget) * r36);
        goto L50
    L44:
        r1 = false;
    L40:
        r9 = MenuKt.ClosedAlphaTarget + ((r5 - MenuKt.ClosedAlphaTarget) * r37);
        goto L41
    L35:
        r8 = false;
        goto L37
    L28:
        if (Intrinsics.areEqual(r37, ArraysKt.lastOrNull(r35)) == true) goto L31;
        r7 = false;
        goto L33
    L21:
        if (Intrinsics.areEqual(r36, ArraysKt.lastOrNull(r35)) == true) goto L24;
        r6 = false;
        goto L26
    L17:
        r4 = r3 >> 32;
    L13:
        r18 = false;
        goto L14
    L9:
        r17 = false;
        goto L10
    L5:
        r16 = false;
        goto L7
    }

    /* JADX INFO: renamed from: drawTrack-GVD57ws$default, reason: not valid java name */
    public static /* synthetic */ void m3154drawTrackGVD57ws$default(SliderDefaults r28, DrawScope r29, float[] r30, float r31, float r32, long r33, long r35, long r37, long r39, float r41, float r42, float r43, float r44, float r45, float r46, float r47, Function2 r48, Function3 r49, boolean r50, boolean r51, Orientation r52, boolean r53, int r54, Object r55) {
        if ((r54 & 131072) == 0) goto L5;
        boolean r25 = false;
    L7:
        if ((r54 & 262144) == 0) goto L9;
        Orientation r26 = Orientation.Horizontal;
    L11:
        if ((r54 & 524288) == 0) goto L13;
        boolean r27 = false;
    L14:
        r28.m3153drawTrackGVD57ws(r29, r30, r31, r32, r33, r35, r37, r39, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r25, r26, r27);
        return;
    L13:
        r27 = r53;
        goto L14
    L9:
        r26 = r52;
        goto L11
    L5:
        r25 = r51;
        goto L7
    }
}
