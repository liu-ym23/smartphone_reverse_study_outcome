package com.ss.android.lark.picker.config.condition;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.config.condition.Condition.Element;
import com.ss.android.lark.picker.config.condition.FoldCondition;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.reflect.KFunction;
import kotlin.reflect.full.KClasses;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010(\n\u0002\b\u0010\b&\u0018\u0000*\f\b\u0000\u0010\u0001*\u0006\u0012\u0002\b\u00030\u0002*\u0014\b\u0001\u0010\u0003*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u00002\b\u0012\u0004\u0012\u0002H\u00030\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J.\u0010\u000e\u001a\u0004\u0018\u0001H\u000f\"\u000e\b\u0002\u0010\u000f*\b\u0012\u0004\u0012\u0002H\u000f0\u00022\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000f0\tH\u0096\u0002¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0096\u0002J8\u0010\u0016\u001a\u0002H\u0017\"\u0016\b\u0002\u0010\u0017\u0018\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\u00170\u00002\u0006\u0010\u0018\u001a\u00028\u00002\u0006\u0010\u0019\u001a\u00028\u0000H\u0080\b¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001c\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0018\u001a\u00028\u00002\u0006\u0010\u0019\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u001dJ\u0015\u0010\u001e\u001a\u00028\u00012\u0006\u0010\u001f\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00028\u00002\u0006\u0010\"\u001a\u00028\u0000¢\u0006\u0002\u0010#J\u0015\u0010$\u001a\u00028\u00002\u0006\u0010\"\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010#R*\u0010\u0007\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t\u0012\u0004\u0012\u00028\u00000\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006%"}, d2 = {"Lcom/ss/android/lark/picker/config/condition/FoldCondition;", "C", "Lcom/ss/android/lark/picker/config/condition/Condition$Element;", FaceService.girlLabel, "", "<init>", "()V", "set", "", "Lcom/ss/android/lark/picker/config/condition/Condition$Key;", "getSet", "()Ljava/util/Map;", "setSet", "(Ljava/util/Map;)V", MonitorConstants.CONNECT_TYPE_GET, ExifInterface.LONGITUDE_EAST, "key", "(Lcom/ss/android/lark/picker/config/condition/Condition$Key;)Lcom/ss/android/lark/picker/config/condition/Condition$Element;", "isNone", "", "iterator", "", "inter", "FOLD", "condition0", "condition1", "inter$picker_release", "(Lcom/ss/android/lark/picker/config/condition/Condition$Element;Lcom/ss/android/lark/picker/config/condition/Condition$Element;)Lcom/ss/android/lark/picker/config/condition/FoldCondition;", "interInternal", "(Lcom/ss/android/lark/picker/config/condition/Condition$Element;Lcom/ss/android/lark/picker/config/condition/Condition$Element;)Lcom/ss/android/lark/picker/config/condition/Condition$Element;", "union", "other", "(Lcom/ss/android/lark/picker/config/condition/FoldCondition;)Lcom/ss/android/lark/picker/config/condition/FoldCondition;", "replace", "condition", "(Lcom/ss/android/lark/picker/config/condition/Condition$Element;)Lcom/ss/android/lark/picker/config/condition/Condition$Element;", "replaceSingle", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class FoldCondition<C extends Condition.Element<?>, F extends FoldCondition<C, F>> implements Condition.Element<F>, Iterable<C>, KMappedMarker {
    private Map<Condition.Key<?>, C> set;

    @Override // com.ss.android.lark.picker.config.condition.Condition.Element
    public boolean isNone() {
        Iterator r100 = MapsKt.asSequence(this.set).iterator();
    L4:
        if (r100.hasNext() == false) goto L8;
        if ((!((Condition.Element) ((Map.Entry) r100.next()).getValue()).isNone()) == false) goto L4;
        boolean r101 = true;
    L10:
        return !r101;
    L8:
        r101 = false;
        goto L10
    }

    @Override // java.lang.Iterable
    public Iterator<C> iterator() {
        return this.set.values().iterator();
    }

    public FoldCondition() {
        this.set = new LinkedHashMap();
    }

    public final Map<Condition.Key<?>, C> getSet() {
        return this.set;
    }

    private final C replaceSingle(C r100) {
        this.set.put(r100.getKey(), r100);
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type C of com.ss.android.lark.picker.config.condition.FoldCondition");
        return this;
    }

    @Override // com.ss.android.lark.picker.config.condition.Condition.Element
    public <E extends Condition.Element<E>> E get(Condition.Key<E> r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return this.set.get(r100);
    }

    public final C replace(C r100) {
        Intrinsics.checkNotNullParameter(r100, "condition");
        if ((r100 instanceof FoldCondition) == false) goto L8;
        Iterator r101 = ((Iterable) r100).iterator();
    L6:
        if (r101.hasNext() == false) goto L9;
        Condition.Element r102 = (Condition.Element) r101.next();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type C of com.ss.android.lark.picker.config.condition.FoldCondition");
        replaceSingle(r102);
    L9:
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type C of com.ss.android.lark.picker.config.condition.FoldCondition");
        return this;
    L8:
        replaceSingle(r100);
        goto L9
    }

    public final void setSet(Map<Condition.Key<?>, C> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.set = r100;
    }

    public F union(F r100) {
        Intrinsics.checkNotNullParameter(r100, "other");
        throw new IllegalAccessException("Can't union FoldCondition!");
    }

    @Override // com.ss.android.lark.picker.config.condition.Condition.Element
    public /* bridge */ /* synthetic */ Condition.Element union(Condition.Element r100) {
        return union((FoldCondition) r100);
    }

    private final C interInternal(C r100, C r101) {
        Iterator<T> r102 = KClasses.getFunctions(Reflection.getOrCreateKotlinClass(r100.getClass())).iterator();     // Catch: Throwable -> L14
    L5:
        if (r102.hasNext() == false) goto L9;
        Object r103 = r102.next();     // Catch: Throwable -> L14
        if (Intrinsics.areEqual(((KFunction) r103).getName(), "inter") == false) goto L5;
    L10:
        KFunction r104 = (KFunction) r103;     // Catch: Throwable -> L14
        if (r104 == null) goto L22;
        R r105 = r104.call(new Object[]{r100, r101});     // Catch: Throwable -> L14
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type C of com.ss.android.lark.picker.config.condition.FoldCondition");     // Catch: Throwable -> L14
        return (C) r105;
    L22:
        return null;
    L9:
        r103 = null;
    L14:
        th = move-exception;
        Log.e("Picker_FoldCondition", th.getMessage(), th);
        return null;
    }

    public final /* synthetic */ <FOLD extends FoldCondition<C, FOLD>> FOLD inter$picker_release(C r100, C r101) {
        Intrinsics.checkNotNullParameter(r100, "condition0");
        Intrinsics.checkNotNullParameter(r101, "condition1");
        Intrinsics.reifiedOperationMarker(3, "FOLD");
        boolean r102 = r100 instanceof FoldCondition;
        if (r102 == true) goto L13;
        Intrinsics.reifiedOperationMarker(3, "FOLD");
        if ((r101 instanceof FoldCondition) == true) goto L13;
        if (Intrinsics.areEqual(r100.getKey(), r101.getKey()) == false) goto L12;
        Condition.Element r103 = access$interInternal(this, r100, r101);
        if (r103 == null) goto L37;
        getSet().put(r103.getKey(), r103);
    L37:
        Intrinsics.reifiedOperationMarker(1, "FOLD");
        return this;
    L12:
        getSet().put(r100.getKey(), r100);
        getSet().put(r101.getKey(), r101);
    L13:
        Intrinsics.reifiedOperationMarker(3, "FOLD");
        if (r102 == false) goto L16;
        Intrinsics.reifiedOperationMarker(1, "FOLD");
        Pair r104 = TuplesKt.to((FoldCondition) r100, r101);
    L17:
        FoldCondition r105 = (FoldCondition) r104.component1();
        Condition.Element r106 = (Condition.Element) r104.component2();
        Iterator<C> r107 = r105.iterator();
    L18:
        Condition.Element r108 = null;
        if (r107.hasNext() == false) goto L28;
        Condition.Element r109 = (Condition.Element) r107.next();
        Condition.Element r110 = r106.get(r109.getKey());
        if ((r110 instanceof Condition.Element) == false) goto L23;
        r108 = r110;
    L23:
        if (r108 == null) goto L26;
        r109 = access$interInternal(this, r109, r108);
    L26:
        if (r109 == null) goto L18;
        getSet().put(r109.getKey(), r109);
        goto L18
    L28:
        Intrinsics.reifiedOperationMarker(3, "FOLD");
        if ((r106 instanceof FoldCondition) == false) goto L32;
        MapsKt.putAll(getSet(), SequencesKt.map(SequencesKt.filter(CollectionsKt.asSequence((Iterable) r106), new FoldCondition$inter$2(this)), FoldCondition$inter$3.INSTANCE));
        goto L37
    L32:
        if ((!getSet().containsKey(r106.getKey())) == true) goto L35;
        r106 = null;
    L35:
        if (r106 == null) goto L37;
        getSet().put(r106.getKey(), r106);
        goto L37
    L16:
        Intrinsics.reifiedOperationMarker(1, "FOLD");
        r104 = TuplesKt.to((FoldCondition) r101, r100);
        goto L17
    }

    public static final /* synthetic */ Condition.Element access$interInternal(FoldCondition r100, Condition.Element r101, Condition.Element r102) {
        return r100.interInternal(r101, r102);
    }
}
