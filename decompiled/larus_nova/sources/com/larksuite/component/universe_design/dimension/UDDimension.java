package com.larksuite.component.universe_design.dimension;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u000b\f\rB\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&R\u0014\u0010\u0002\u001a\u00020\u0003X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0003\u000e\u000f\u0010¨\u0006\u0011"}, d2 = {"Lcom/larksuite/component/universe_design/dimension/UDDimension;", "", "value", "", "<init>", "(F)V", "getValue", "()F", "toPixels", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "Dp", "Px", "Sp", "Lcom/larksuite/component/universe_design/dimension/UDDimension$Dp;", "Lcom/larksuite/component/universe_design/dimension/UDDimension$Px;", "Lcom/larksuite/component/universe_design/dimension/UDDimension$Sp;", "universe-ui-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class UDDimension {
    public static final int $stable = 0;
    private final float value;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0006¢\u0006\u0004\b\u0004\u0010\u0007J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/larksuite/component/universe_design/dimension/UDDimension$Dp;", "Lcom/larksuite/component/universe_design/dimension/UDDimension;", "value", "", "<init>", "(F)V", "", "(I)V", "toPixels", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "universe-ui-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Dp extends UDDimension {
        public static final int $stable = 0;

        public Dp(float r100) {
            super(r100, null);
        }

        public static DisplayMetrics INVOKEVIRTUAL_com_larksuite_component_universe_design_dimension_UDDimension$Dp_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
            return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
        }

        @Override // com.larksuite.component.universe_design.dimension.UDDimension
        public float toPixels(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return TypedValue.applyDimension(1, getValue(), INVOKEVIRTUAL_com_larksuite_component_universe_design_dimension_UDDimension$Dp_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources()));
        }

        public Dp(int r100) {
            this(r100);
        }
    }

    public static final class a extends UDDimension {
        public a(int r100) {
            super(r100, null);
        }

        @Override // com.larksuite.component.universe_design.dimension.UDDimension
        public final float toPixels(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return getValue();
        }

        public a(float r100) {
            super(r100, null);
        }
    }

    public static final class b extends UDDimension {
        public b(int r100) {
            super(r100, null);
        }

        @Override // com.larksuite.component.universe_design.dimension.UDDimension
        public final float toPixels(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            float r101 = getValue();
            Resources r102 = r100.getResources();
            return TypedValue.applyDimension(2, r101, WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()));
        }

        public b(float r100) {
            super(r100, null);
        }
    }

    public /* synthetic */ UDDimension(float r100, DefaultConstructorMarker r101) {
        this(r100);
    }

    public abstract float toPixels(Context r100);

    public final float getValue() {
        return this.value;
    }

    private UDDimension(float r100) {
        this.value = r100;
    }
}
