package androidx.compose.foundation.layout;

import androidx.autofill.HintConstants;
import androidx.compose.runtime.Composer;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Deprecated(message = "FlowLayout overflow is no longer maintained")
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0001\u001bB\u0089\u0001\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u00120\b\u0002\u0010\u0007\u001a*\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0002\b\u000f\u0018\u00010\b\u00120\b\u0002\u0010\u0010\u001a*\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0002\b\u000f\u0018\u00010\b¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0015\u001a\u00020\tH\u0000¢\u0006\u0002\b\u0016J.\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\t2\u0017\u0010\u0018\u001a\u0013\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0002\b\u000f0\u0019H\u0000¢\u0006\u0002\b\u001aR\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R6\u0010\u0007\u001a*\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0002\b\u000f\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R6\u0010\u0010\u001a*\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0002\b\u000f\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0001\u0004\u001c\u001d\u001e\u001f¨\u0006 "}, d2 = {"Landroidx/compose/foundation/layout/FlowLayoutOverflow;", "", "type", "Landroidx/compose/foundation/layout/FlowLayoutOverflow$OverflowType;", "minLinesToShowCollapse", "", "minCrossAxisSizeToShowCollapse", "seeMoreGetter", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/FlowLayoutOverflowState;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "state", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "collapseGetter", "<init>", "(Landroidx/compose/foundation/layout/FlowLayoutOverflow$OverflowType;IILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getType$foundation_layout", "()Landroidx/compose/foundation/layout/FlowLayoutOverflow$OverflowType;", "createOverflowState", "createOverflowState$foundation_layout", "addOverflowComposables", "list", "", "addOverflowComposables$foundation_layout", "OverflowType", "Landroidx/compose/foundation/layout/ContextualFlowColumnOverflow;", "Landroidx/compose/foundation/layout/ContextualFlowRowOverflow;", "Landroidx/compose/foundation/layout/FlowColumnOverflow;", "Landroidx/compose/foundation/layout/FlowRowOverflow;", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class FlowLayoutOverflow {
    public static final int $stable = 0;
    private final Function1<FlowLayoutOverflowState, Function2<Composer, Integer, Unit>> collapseGetter;
    private final int minCrossAxisSizeToShowCollapse;
    private final int minLinesToShowCollapse;
    private final Function1<FlowLayoutOverflowState, Function2<Composer, Integer, Unit>> seeMoreGetter;
    private final OverflowType type;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/foundation/layout/FlowLayoutOverflow$OverflowType;", "", "<init>", "(Ljava/lang/String;I)V", "Visible", "Clip", "ExpandIndicator", "ExpandOrCollapseIndicator", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum OverflowType extends Enum<OverflowType> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ OverflowType[] $VALUES = null;
        public static final OverflowType Clip = null;
        public static final OverflowType ExpandIndicator = null;
        public static final OverflowType ExpandOrCollapseIndicator = null;
        public static final OverflowType Visible = null;

        private static final /* synthetic */ OverflowType[] $values() {
            return new OverflowType[]{Visible, Clip, ExpandIndicator, ExpandOrCollapseIndicator};
        }

        public static EnumEntries<OverflowType> getEntries() {
            return $ENTRIES;
        }

        static {
            Visible = new OverflowType("Visible", 0);
            Clip = new OverflowType("Clip", 1);
            ExpandIndicator = new OverflowType("ExpandIndicator", 2);
            ExpandOrCollapseIndicator = new OverflowType("ExpandOrCollapseIndicator", 3);
            OverflowType[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries(r0);
        }

        public static OverflowType[] values() {
            return (OverflowType[]) $VALUES.clone();
        }

        public static OverflowType valueOf(String r1) {
            return (OverflowType) r27.a.a(OverflowType.class, r1);
        }

        private OverflowType(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[OverflowType.values().length];
            r0[OverflowType.ExpandIndicator.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[OverflowType.ExpandOrCollapseIndicator.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            $EnumSwitchMapping$0 = r0;
        }
    }

    public /* synthetic */ FlowLayoutOverflow(OverflowType r1, int r2, int r3, Function1 r4, Function1 r5, DefaultConstructorMarker r6) {
        this(r1, r2, r3, r4, r5);
    }

    public final FlowLayoutOverflowState createOverflowState$foundation_layout() {
        return new FlowLayoutOverflowState(this.type, this.minLinesToShowCollapse, this.minCrossAxisSizeToShowCollapse);
    }

    public final OverflowType getType$foundation_layout() {
        return this.type;
    }

    public final void addOverflowComposables$foundation_layout(FlowLayoutOverflowState r4, List<Function2<Composer, Integer, Unit>> r5) {
        Function1<FlowLayoutOverflowState, Function2<Composer, Integer, Unit>> r0 = this.seeMoreGetter;
        Function2<Composer, Integer, Unit> r1 = null;
        if (r0 == null) goto L5;
        Function2<Composer, Integer, Unit> r2 = (Function2) r0.invoke(r4);
    L6:
        Function1<FlowLayoutOverflowState, Function2<Composer, Integer, Unit>> r3 = this.collapseGetter;
        if (r3 == null) goto L9;
        r1 = (Function2) r3.invoke(r4);
    L9:
        int r6 = WhenMappings.$EnumSwitchMapping$0[this.type.ordinal()];
        if (r6 != 1) goto L12;
        if (r2 == null) goto L23;
        r5.add(r2);
        return;
    L23:
        return;
    L12:
        if (r6 != 2) goto L24;
        if (r2 == null) goto L16;
        r5.add(r2);
    L16:
        if (r1 == null) goto L21;
        r5.add(r1);
        return;
    L21:
        return;
    L24:
        return;
    L5:
        r2 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    private FlowLayoutOverflow(OverflowType r1, int r2, int r3, Function1<? super FlowLayoutOverflowState, ? extends Function2<? super Composer, ? super Integer, Unit>> r4, Function1<? super FlowLayoutOverflowState, ? extends Function2<? super Composer, ? super Integer, Unit>> r5) {
        this.type = r1;
        this.minLinesToShowCollapse = r2;
        this.minCrossAxisSizeToShowCollapse = r3;
        this.seeMoreGetter = r4;
        this.collapseGetter = r5;
    }

    public /* synthetic */ FlowLayoutOverflow(OverflowType r9, int r10, int r11, Function1 r12, Function1 r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 2) == 0) goto L5;
        int r3 = 0;
    L7:
        if ((r14 & 4) == 0) goto L9;
        int r4 = 0;
    L11:
        if ((r14 & 8) == 0) goto L13;
        Function1 r5 = null;
    L15:
        if ((r14 & 16) == 0) goto L17;
        Function1 r6 = null;
    L18:
        this(r9, r3, r4, r5, r6, null);
        return;
    L17:
        r6 = r13;
        goto L18
    L13:
        r5 = r12;
        goto L15
    L9:
        r4 = r11;
        goto L11
    L5:
        r3 = r10;
        goto L7
    }
}
