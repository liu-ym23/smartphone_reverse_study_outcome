package kotlin.collections;

import android.util.EventsUtils;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"kotlin/collections/MapsKt__MapWithDefaultKt", "kotlin/collections/MapsKt__MapsJVMKt", "kotlin/collections/MapsKt__MapsKt", "kotlin/collections/MapsKt___MapsJvmKt", "kotlin/collections/MapsKt___MapsKt"}, k = 4, mv = {1, 9, 0}, xi = EventsUtils.FEAT_TYPE_IOPRELOAD_DATA)
public final class MapsKt extends MapsKt___MapsKt {
    public static /* bridge */ /* synthetic */ Sequence asSequence(Map r0) {
        return MapsKt___MapsKt.asSequence(r0);
    }

    public static /* bridge */ /* synthetic */ Map build(Map r0) {
        return MapsKt__MapsJVMKt.build(r0);
    }

    public static /* bridge */ /* synthetic */ Map createMapBuilder() {
        return MapsKt__MapsJVMKt.createMapBuilder();
    }

    public static /* bridge */ /* synthetic */ Map createMapBuilder(int r0) {
        return MapsKt__MapsJVMKt.createMapBuilder(r0);
    }

    public static /* bridge */ /* synthetic */ Map emptyMap() {
        return MapsKt__MapsKt.emptyMap();
    }

    public static /* bridge */ /* synthetic */ Object getOrImplicitDefaultNullable(Map r0, Object r1) {
        return MapsKt__MapWithDefaultKt.getOrImplicitDefaultNullable(r0, r1);
    }

    public static /* bridge */ /* synthetic */ Object getValue(Map r0, Object r1) {
        return MapsKt__MapsKt.getValue(r0, r1);
    }

    public static /* bridge */ /* synthetic */ HashMap hashMapOf(Pair... r0) {
        return MapsKt__MapsKt.hashMapOf(r0);
    }

    public static /* bridge */ /* synthetic */ LinkedHashMap linkedMapOf(Pair... r0) {
        return MapsKt__MapsKt.linkedMapOf(r0);
    }

    public static /* bridge */ /* synthetic */ int mapCapacity(int r0) {
        return MapsKt__MapsJVMKt.mapCapacity(r0);
    }

    public static /* bridge */ /* synthetic */ Map mapOf(Pair r0) {
        return MapsKt__MapsJVMKt.mapOf(r0);
    }

    public static /* bridge */ /* synthetic */ Map mapOf(Pair... r0) {
        return MapsKt__MapsKt.mapOf(r0);
    }

    public static /* bridge */ /* synthetic */ Map minus(Map r0, Iterable r1) {
        return MapsKt__MapsKt.minus(r0, r1);
    }

    public static /* bridge */ /* synthetic */ Map minus(Map r0, Object r1) {
        return MapsKt__MapsKt.minus(r0, r1);
    }

    public static /* bridge */ /* synthetic */ Map minus(Map r0, Sequence r1) {
        return MapsKt__MapsKt.minus(r0, r1);
    }

    public static /* bridge */ /* synthetic */ Map mutableMapOf(Pair... r0) {
        return MapsKt__MapsKt.mutableMapOf(r0);
    }

    public static /* bridge */ /* synthetic */ Map plus(Map r0, Map r1) {
        return MapsKt__MapsKt.plus(r0, r1);
    }

    public static /* bridge */ /* synthetic */ Map plus(Map r0, Pair r1) {
        return MapsKt__MapsKt.plus(r0, r1);
    }

    public static /* bridge */ /* synthetic */ Map plus(Map r0, Pair[] r1) {
        return MapsKt__MapsKt.plus(r0, r1);
    }

    public static /* bridge */ /* synthetic */ void putAll(Map r0, Iterable r1) {
        MapsKt__MapsKt.putAll(r0, r1);
    }

    public static /* bridge */ /* synthetic */ void putAll(Map r0, Sequence r1) {
        MapsKt__MapsKt.putAll(r0, r1);
    }

    public static /* bridge */ /* synthetic */ void putAll(Map r0, Pair[] r1) {
        MapsKt__MapsKt.putAll(r0, r1);
    }

    public static /* bridge */ /* synthetic */ SortedMap sortedMapOf(Comparator r0, Pair... r1) {
        return MapsKt__MapsJVMKt.sortedMapOf(r0, r1);
    }

    public static /* bridge */ /* synthetic */ SortedMap sortedMapOf(Pair... r0) {
        return MapsKt__MapsJVMKt.sortedMapOf(r0);
    }

    public static /* bridge */ /* synthetic */ List toList(Map r0) {
        return MapsKt___MapsKt.toList(r0);
    }

    public static /* bridge */ /* synthetic */ Map toMap(Iterable r0) {
        return MapsKt__MapsKt.toMap(r0);
    }

    public static /* bridge */ /* synthetic */ Map toMap(Iterable r0, Map r1) {
        return MapsKt__MapsKt.toMap(r0, r1);
    }

    public static /* bridge */ /* synthetic */ Map toMap(Map r0) {
        return MapsKt__MapsKt.toMap(r0);
    }

    public static /* bridge */ /* synthetic */ Map toMap(Sequence r0) {
        return MapsKt__MapsKt.toMap(r0);
    }

    public static /* bridge */ /* synthetic */ Map toMap(Sequence r0, Map r1) {
        return MapsKt__MapsKt.toMap(r0, r1);
    }

    public static /* bridge */ /* synthetic */ Map toMap(Pair[] r0) {
        return MapsKt__MapsKt.toMap(r0);
    }

    public static /* bridge */ /* synthetic */ Map toMutableMap(Map r0) {
        return MapsKt__MapsKt.toMutableMap(r0);
    }

    public static /* bridge */ /* synthetic */ SortedMap toSortedMap(Map r0) {
        return MapsKt__MapsJVMKt.toSortedMap(r0);
    }

    public static /* bridge */ /* synthetic */ SortedMap toSortedMap(Map r0, Comparator r1) {
        return MapsKt__MapsJVMKt.toSortedMap(r0, r1);
    }

    public static /* bridge */ /* synthetic */ Map withDefaultMutable(Map r0, Function1 r1) {
        return MapsKt__MapWithDefaultKt.withDefaultMutable(r0, r1);
    }

    private MapsKt() {
    }
}
