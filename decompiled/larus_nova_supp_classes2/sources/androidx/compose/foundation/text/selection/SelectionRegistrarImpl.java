package androidx.compose.foundation.text.selection;

import androidx.collection.LongObjectMap;
import androidx.collection.LongObjectMapKt;
import androidx.collection.MutableLongObjectMap;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b \b\u0001\u0018\u0000 f2\u00020\u0001:\u0001fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\t\b\u0016¢\u0006\u0004\b\u0004\u0010\u0006J\u0010\u0010N\u001a\u00020\u000f2\u0006\u0010O\u001a\u00020\u000fH\u0016J\u0010\u0010P\u001a\u00020 2\u0006\u0010O\u001a\u00020\u000fH\u0016J\b\u0010Q\u001a\u00020\u0003H\u0016J\u0014\u0010R\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00112\u0006\u0010S\u001a\u00020'J\u0010\u0010T\u001a\u00020 2\u0006\u0010U\u001a\u00020\u0003H\u0016J/\u0010V\u001a\u00020 2\u0006\u0010W\u001a\u00020'2\u0006\u0010X\u001a\u00020(2\u0006\u0010Y\u001a\u00020)2\u0006\u0010Z\u001a\u00020\bH\u0016¢\u0006\u0004\b[\u0010\\J\u0018\u0010]\u001a\u00020 2\u0006\u0010U\u001a\u00020\u00032\u0006\u0010Z\u001a\u00020\bH\u0016J?\u0010^\u001a\u00020\b2\u0006\u0010W\u001a\u00020'2\u0006\u0010_\u001a\u00020(2\u0006\u0010`\u001a\u00020(2\u0006\u0010a\u001a\u00020\b2\u0006\u0010Y\u001a\u00020)2\u0006\u0010Z\u001a\u00020\bH\u0016¢\u0006\u0004\bb\u0010cJ\b\u0010d\u001a\u00020 H\u0016J\u0010\u0010e\u001a\u00020 2\u0006\u0010U\u001a\u00020\u0003H\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00118@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00178@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00060\u001bj\u0002`\u001cX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001dR(\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020 \u0018\u00010\u001fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R:\u0010%\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020 \u0018\u00010&X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R.\u0010.\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020 \u0018\u00010/X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103RF\u00104\u001a.\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\b\u0018\u000105X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\"\u0010:\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010;X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R(\u0010@\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020 \u0018\u00010\u001fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\"\"\u0004\bB\u0010$R(\u0010C\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020 \u0018\u00010\u001fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\"\"\u0004\bE\u0010$R7\u0010H\u001a\b\u0012\u0004\u0012\u00020G0\u00172\f\u0010F\u001a\b\u0012\u0004\u0012\u00020G0\u00178V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bL\u0010M\u001a\u0004\bI\u0010\u0019\"\u0004\bJ\u0010K¨\u0006g"}, d2 = {"Landroidx/compose/foundation/text/selection/SelectionRegistrarImpl;", "Landroidx/compose/foundation/text/selection/SelectionRegistrar;", "initialIncrementId", "", "<init>", "(J)V", "()V", "sorted", "", "getSorted$foundation_release", "()Z", "setSorted$foundation_release", "(Z)V", "_selectables", "", "Landroidx/compose/foundation/text/selection/Selectable;", "selectables", "", "getSelectables$foundation_release", "()Ljava/util/List;", "_selectableMap", "Landroidx/collection/MutableLongObjectMap;", "selectableMap", "Landroidx/collection/LongObjectMap;", "getSelectableMap$foundation_release", "()Landroidx/collection/LongObjectMap;", "incrementId", "Ljava/util/concurrent/atomic/AtomicLong;", "Landroidx/compose/foundation/AtomicLong;", "Ljava/util/concurrent/atomic/AtomicLong;", "onPositionChangeCallback", "Lkotlin/Function1;", "", "getOnPositionChangeCallback$foundation_release", "()Lkotlin/jvm/functions/Function1;", "setOnPositionChangeCallback$foundation_release", "(Lkotlin/jvm/functions/Function1;)V", "onSelectionUpdateStartCallback", "Lkotlin/Function4;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "Landroidx/compose/ui/geometry/Offset;", "Landroidx/compose/foundation/text/selection/SelectionAdjustment;", "getOnSelectionUpdateStartCallback$foundation_release", "()Lkotlin/jvm/functions/Function4;", "setOnSelectionUpdateStartCallback$foundation_release", "(Lkotlin/jvm/functions/Function4;)V", "onSelectionUpdateSelectAll", "Lkotlin/Function2;", "getOnSelectionUpdateSelectAll$foundation_release", "()Lkotlin/jvm/functions/Function2;", "setOnSelectionUpdateSelectAll$foundation_release", "(Lkotlin/jvm/functions/Function2;)V", "onSelectionUpdateCallback", "Lkotlin/Function6;", "getOnSelectionUpdateCallback$foundation_release", "()Lkotlin/jvm/functions/Function6;", "setOnSelectionUpdateCallback$foundation_release", "(Lkotlin/jvm/functions/Function6;)V", "onSelectionUpdateEndCallback", "Lkotlin/Function0;", "getOnSelectionUpdateEndCallback$foundation_release", "()Lkotlin/jvm/functions/Function0;", "setOnSelectionUpdateEndCallback$foundation_release", "(Lkotlin/jvm/functions/Function0;)V", "onSelectableChangeCallback", "getOnSelectableChangeCallback$foundation_release", "setOnSelectableChangeCallback$foundation_release", "afterSelectableUnsubscribe", "getAfterSelectableUnsubscribe$foundation_release", "setAfterSelectableUnsubscribe$foundation_release", "<set-?>", "Landroidx/compose/foundation/text/selection/Selection;", "subselections", "getSubselections", "setSubselections", "(Landroidx/collection/LongObjectMap;)V", "subselections$delegate", "Landroidx/compose/runtime/MutableState;", "subscribe", "selectable", "unsubscribe", "nextSelectableId", "sort", "containerLayoutCoordinates", "notifyPositionChange", "selectableId", "notifySelectionUpdateStart", "layoutCoordinates", "startPosition", "adjustment", "isInTouchMode", "notifySelectionUpdateStart-ubNVwUQ", "(Landroidx/compose/ui/layout/LayoutCoordinates;JLandroidx/compose/foundation/text/selection/SelectionAdjustment;Z)V", "notifySelectionUpdateSelectAll", "notifySelectionUpdate", "newPosition", "previousPosition", "isStartHandle", "notifySelectionUpdate-njBpvok", "(Landroidx/compose/ui/layout/LayoutCoordinates;JJZLandroidx/compose/foundation/text/selection/SelectionAdjustment;Z)Z", "notifySelectionUpdateEnd", "notifySelectableChange", "Companion", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SelectionRegistrarImpl implements SelectionRegistrar {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private static final Saver<SelectionRegistrarImpl, Long> Saver = null;
    private final MutableLongObjectMap<Selectable> _selectableMap;
    private final List<Selectable> _selectables;
    private Function1<? super Long, Unit> afterSelectableUnsubscribe;
    private AtomicLong incrementId;
    private Function1<? super Long, Unit> onPositionChangeCallback;
    private Function1<? super Long, Unit> onSelectableChangeCallback;
    private Function6<? super Boolean, ? super LayoutCoordinates, ? super Offset, ? super Offset, ? super Boolean, ? super SelectionAdjustment, Boolean> onSelectionUpdateCallback;
    private Function0<Unit> onSelectionUpdateEndCallback;
    private Function2<? super Boolean, ? super Long, Unit> onSelectionUpdateSelectAll;
    private Function4<? super Boolean, ? super LayoutCoordinates, ? super Offset, ? super SelectionAdjustment, Unit> onSelectionUpdateStartCallback;
    private boolean sorted;
    private final MutableState subselections$delegate;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Landroidx/compose/foundation/text/selection/SelectionRegistrarImpl$Companion;", "", "<init>", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/text/selection/SelectionRegistrarImpl;", "", "getSaver", "()Landroidx/compose/runtime/saveable/Saver;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final Saver<SelectionRegistrarImpl, Long> getSaver() {
            return SelectionRegistrarImpl.access$getSaver$cp();
        }
    }

    public static /* synthetic */ SelectionRegistrarImpl a(long r0) {
        return Saver$lambda$5(r0);
    }

    public static /* synthetic */ Long b(SaverScope r0, SelectionRegistrarImpl r1) {
        return Saver$lambda$4(r0, r1);
    }

    public static /* synthetic */ int c(LayoutCoordinates r0, Selectable r1, Selectable r2) {
        return sort$lambda$2(r0, r1, r2);
    }

    public static /* synthetic */ int d(Function2 r0, Object r1, Object r2) {
        return sort$lambda$3(r0, r1, r2);
    }

    static {
        Companion = new Companion(null);
        $stable = 8;
        Saver = SaverKt.Saver(new q1(), new r1());
    }

    public SelectionRegistrarImpl() {
        this(1);
    }

    @Override // androidx.compose.foundation.text.selection.SelectionRegistrar
    public LongObjectMap<Selection> getSubselections() {
        return (LongObjectMap) this.subselections$delegate.getValue();
    }

    @Override // androidx.compose.foundation.text.selection.SelectionRegistrar
    public long nextSelectableId() {
        long r0 = this.incrementId.getAndIncrement();
    L4:
        if (r0 != 0) goto L6;
        r0 = this.incrementId.getAndIncrement();
        goto L4
    L6:
        return r0;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionRegistrar
    public void notifySelectionUpdateEnd() {
        Function0<Unit> r0 = this.onSelectionUpdateEndCallback;
        if (r0 == null) goto L6;
        r0.invoke();
        return;
    }

    public static final /* synthetic */ Saver access$getSaver$cp() {
        return Saver;
    }

    public final Function1<Long, Unit> getAfterSelectableUnsubscribe$foundation_release() {
        return this.afterSelectableUnsubscribe;
    }

    public final Function1<Long, Unit> getOnPositionChangeCallback$foundation_release() {
        return this.onPositionChangeCallback;
    }

    public final Function1<Long, Unit> getOnSelectableChangeCallback$foundation_release() {
        return this.onSelectableChangeCallback;
    }

    public final Function6<Boolean, LayoutCoordinates, Offset, Offset, Boolean, SelectionAdjustment, Boolean> getOnSelectionUpdateCallback$foundation_release() {
        return this.onSelectionUpdateCallback;
    }

    public final Function0<Unit> getOnSelectionUpdateEndCallback$foundation_release() {
        return this.onSelectionUpdateEndCallback;
    }

    public final Function2<Boolean, Long, Unit> getOnSelectionUpdateSelectAll$foundation_release() {
        return this.onSelectionUpdateSelectAll;
    }

    public final Function4<Boolean, LayoutCoordinates, Offset, SelectionAdjustment, Unit> getOnSelectionUpdateStartCallback$foundation_release() {
        return this.onSelectionUpdateStartCallback;
    }

    public final LongObjectMap<Selectable> getSelectableMap$foundation_release() {
        return this._selectableMap;
    }

    public final List<Selectable> getSelectables$foundation_release() {
        return this._selectables;
    }

    public final boolean getSorted$foundation_release() {
        return this.sorted;
    }

    private SelectionRegistrarImpl(long r2) {
        this._selectables = new ArrayList();
        this._selectableMap = LongObjectMapKt.mutableLongObjectMapOf();
        this.incrementId = new AtomicLong(r2);
        this.subselections$delegate = SnapshotStateKt.mutableStateOf$default(LongObjectMapKt.emptyLongObjectMap(), null, 2, null);
    }

    private static final SelectionRegistrarImpl Saver$lambda$5(long r1) {
        return new SelectionRegistrarImpl(r1);
    }

    @Override // androidx.compose.foundation.text.selection.SelectionRegistrar
    public void notifyPositionChange(long r2) {
        this.sorted = false;
        Function1<? super Long, Unit> r0 = this.onPositionChangeCallback;
        if (r0 == null) goto L6;
        r0.invoke(Long.valueOf(r2));
        return;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionRegistrar
    public void notifySelectableChange(long r2) {
        Function1<? super Long, Unit> r0 = this.onSelectableChangeCallback;
        if (r0 == null) goto L6;
        r0.invoke(Long.valueOf(r2));
        return;
    }

    public final void setAfterSelectableUnsubscribe$foundation_release(Function1<? super Long, Unit> r1) {
        this.afterSelectableUnsubscribe = r1;
    }

    public final void setOnPositionChangeCallback$foundation_release(Function1<? super Long, Unit> r1) {
        this.onPositionChangeCallback = r1;
    }

    public final void setOnSelectableChangeCallback$foundation_release(Function1<? super Long, Unit> r1) {
        this.onSelectableChangeCallback = r1;
    }

    public final void setOnSelectionUpdateCallback$foundation_release(Function6<? super Boolean, ? super LayoutCoordinates, ? super Offset, ? super Offset, ? super Boolean, ? super SelectionAdjustment, Boolean> r1) {
        this.onSelectionUpdateCallback = r1;
    }

    public final void setOnSelectionUpdateEndCallback$foundation_release(Function0<Unit> r1) {
        this.onSelectionUpdateEndCallback = r1;
    }

    public final void setOnSelectionUpdateSelectAll$foundation_release(Function2<? super Boolean, ? super Long, Unit> r1) {
        this.onSelectionUpdateSelectAll = r1;
    }

    public final void setOnSelectionUpdateStartCallback$foundation_release(Function4<? super Boolean, ? super LayoutCoordinates, ? super Offset, ? super SelectionAdjustment, Unit> r1) {
        this.onSelectionUpdateStartCallback = r1;
    }

    public final void setSorted$foundation_release(boolean r1) {
        this.sorted = r1;
    }

    public void setSubselections(LongObjectMap<Selection> r2) {
        this.subselections$delegate.setValue(r2);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [androidx.compose.foundation.text.selection.s1] */
    public final List<Selectable> sort(final LayoutCoordinates r3) {
        if (this.sorted == true) goto L6;
        List<Selectable> r0 = this._selectables;
        final ?? r1 = new s1(r3);
        CollectionsKt.sortWith(r0, new t1(r1));
        this.sorted = true;
    L6:
        return getSelectables$foundation_release();
    }

    @Override // androidx.compose.foundation.text.selection.SelectionRegistrar
    public Selectable subscribe(Selectable r8) {
        if (r8.getSelectableId() == 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        InlineClassHelperKt.throwIllegalArgumentException("The selectable contains an invalid id: " + r8.getSelectableId());
    L9:
        if ((!this._selectableMap.containsKey(r8.getSelectableId())) == true) goto L11;
        InlineClassHelperKt.throwIllegalArgumentException("Another selectable with the id: " + r8 + ".selectableId has already subscribed.");
    L11:
        this._selectableMap.set(r8.getSelectableId(), r8);
        this._selectables.add(r8);
        this.sorted = false;
        return r8;
    L5:
        r0 = false;
        goto L6
    }

    @Override // androidx.compose.foundation.text.selection.SelectionRegistrar
    public void unsubscribe(Selectable r4) {
        if (this._selectableMap.containsKey(r4.getSelectableId()) == true) goto L5;
        return;
    L5:
        this._selectables.remove(r4);
        this._selectableMap.remove(r4.getSelectableId());
        Function1<? super Long, Unit> r0 = this.afterSelectableUnsubscribe;
        if (r0 == null) goto L9;
        r0.invoke(Long.valueOf(r4.getSelectableId()));
        return;
    }

    private static final Long Saver$lambda$4(SaverScope r0, SelectionRegistrarImpl r1) {
        return Long.valueOf(r1.incrementId.get());
    }

    @Override // androidx.compose.foundation.text.selection.SelectionRegistrar
    public void notifySelectionUpdateSelectAll(long r2, boolean r4) {
        Function2<? super Boolean, ? super Long, Unit> r0 = this.onSelectionUpdateSelectAll;
        if (r0 == null) goto L6;
        r0.invoke(Boolean.valueOf(r4), Long.valueOf(r2));
        return;
    }

    private static final int sort$lambda$2(LayoutCoordinates r6, Selectable r7, Selectable r8) {
        LayoutCoordinates r9 = r7.getLayoutCoordinates();
        LayoutCoordinates r10 = r8.getLayoutCoordinates();
        if (r9 == null) goto L5;
        long r0 = r6.localPositionOf-R5De75A(r9, Offset.Companion.getZero-F1C5BW0());
    L6:
        if (r10 == null) goto L8;
        long r11 = r6.localPositionOf-R5De75A(r10, Offset.Companion.getZero-F1C5BW0());
    L9:
        int r12 = (int) (r0 & 4294967295L);
        int r3 = (int) (4294967295L & r11);
        if (Float.intBitsToFloat(r12) != Float.intBitsToFloat(r3)) goto L12;
        boolean r2 = true;
    L13:
        if (r2 == false) goto L16;
        return ComparisonsKt.compareValues(Float.valueOf(Float.intBitsToFloat((int) (r0 >> 32))), Float.valueOf(Float.intBitsToFloat((int) (r11 >> 32))));
    L16:
        return ComparisonsKt.compareValues(Float.valueOf(Float.intBitsToFloat(r12)), Float.valueOf(Float.intBitsToFloat(r3)));
    L12:
        r2 = false;
        goto L13
    L8:
        r11 = Offset.Companion.getZero-F1C5BW0();
        goto L9
    L5:
        r0 = Offset.Companion.getZero-F1C5BW0();
        goto L6
    }

    private static final int sort$lambda$3(Function2 r0, Object r1, Object r2) {
        return ((Number) r0.invoke(r1, r2)).intValue();
    }

    @Override // androidx.compose.foundation.text.selection.SelectionRegistrar
    /* JADX INFO: renamed from: notifySelectionUpdateStart-ubNVwUQ */
    public void mo1885notifySelectionUpdateStartubNVwUQ(LayoutCoordinates r2, long r3, SelectionAdjustment r5, boolean r6) {
        Function4<? super Boolean, ? super LayoutCoordinates, ? super Offset, ? super SelectionAdjustment, Unit> r0 = this.onSelectionUpdateStartCallback;
        if (r0 == null) goto L6;
        r0.invoke(Boolean.valueOf(r6), r2, Offset.box-impl(r3), r5);
        return;
    }

    @Override // androidx.compose.foundation.text.selection.SelectionRegistrar
    /* JADX INFO: renamed from: notifySelectionUpdate-njBpvok */
    public boolean mo1884notifySelectionUpdatenjBpvok(LayoutCoordinates r8, long r9, long r11, boolean r13, SelectionAdjustment r14, boolean r15) {
        Function6<? super Boolean, ? super LayoutCoordinates, ? super Offset, ? super Offset, ? super Boolean, ? super SelectionAdjustment, Boolean> r0 = this.onSelectionUpdateCallback;
        if (r0 != null) goto L7;
        return true;
    L7:
        return ((Boolean) r0.invoke(Boolean.valueOf(r15), r8, Offset.box-impl(r9), Offset.box-impl(r11), Boolean.valueOf(r13), r14)).booleanValue();
    }
}
