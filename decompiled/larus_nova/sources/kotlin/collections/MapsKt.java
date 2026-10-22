package kotlin.collections;

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

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"kotlin/collections/MapsKt__MapWithDefaultKt", "kotlin/collections/MapsKt__MapsJVMKt", "kotlin/collections/MapsKt__MapsKt", "kotlin/collections/MapsKt___MapsJvmKt", "kotlin/collections/MapsKt___MapsKt"}, k = 4, mv = {1, 9, 0}, xi = 49)
public final class MapsKt extends MapsKt___MapsKt {
    public static /* bridge */ /* synthetic */ Sequence asSequence(Map r100) {
        return MapsKt___MapsKt.asSequence(r100);
    }

    public static /* bridge */ /* synthetic */ Map build(Map r100) {
        return MapsKt__MapsJVMKt.build(r100);
    }

    public static /* bridge */ /* synthetic */ Map createMapBuilder() {
        return MapsKt__MapsJVMKt.createMapBuilder();
    }

    public static /* bridge */ /* synthetic */ Map createMapBuilder(int r100) {
        return MapsKt__MapsJVMKt.createMapBuilder(r100);
    }

    public static /* bridge */ /* synthetic */ Map emptyMap() {
        return MapsKt__MapsKt.emptyMap();
    }

    public static /* bridge */ /* synthetic */ Object getOrImplicitDefaultNullable(Map r100, Object r101) {
        return MapsKt__MapWithDefaultKt.getOrImplicitDefaultNullable(r100, r101);
    }

    public static /* bridge */ /* synthetic */ Object getValue(Map r100, Object r101) {
        return MapsKt__MapsKt.getValue(r100, r101);
    }

    public static /* bridge */ /* synthetic */ HashMap hashMapOf(Pair... r100) {
        return MapsKt__MapsKt.hashMapOf(r100);
    }

    public static /* bridge */ /* synthetic */ LinkedHashMap linkedMapOf(Pair... r100) {
        return MapsKt__MapsKt.linkedMapOf(r100);
    }

    public static /* bridge */ /* synthetic */ int mapCapacity(int r100) {
        return MapsKt__MapsJVMKt.mapCapacity(r100);
    }

    public static /* bridge */ /* synthetic */ Map mapOf(Pair r100) {
        return MapsKt__MapsJVMKt.mapOf(r100);
    }

    public static /* bridge */ /* synthetic */ Map mapOf(Pair... r100) {
        return MapsKt__MapsKt.mapOf(r100);
    }

    public static /* bridge */ /* synthetic */ Map minus(Map r100, Iterable r101) {
        return MapsKt__MapsKt.minus(r100, r101);
    }

    public static /* bridge */ /* synthetic */ Map minus(Map r100, Object r101) {
        return MapsKt__MapsKt.minus(r100, r101);
    }

    public static /* bridge */ /* synthetic */ Map minus(Map r100, Sequence r101) {
        return MapsKt__MapsKt.minus(r100, r101);
    }

    public static /* bridge */ /* synthetic */ Map mutableMapOf(Pair... r100) {
        return MapsKt__MapsKt.mutableMapOf(r100);
    }

    public static /* bridge */ /* synthetic */ Map plus(Map r100, Map r101) {
        return MapsKt__MapsKt.plus(r100, r101);
    }

    public static /* bridge */ /* synthetic */ Map plus(Map r100, Pair r101) {
        return MapsKt__MapsKt.plus(r100, r101);
    }

    public static /* bridge */ /* synthetic */ Map plus(Map r100, Pair[] r101) {
        return MapsKt__MapsKt.plus(r100, r101);
    }

    public static /* bridge */ /* synthetic */ void putAll(Map r100, Iterable r101) {
        MapsKt__MapsKt.putAll(r100, r101);
    }

    public static /* bridge */ /* synthetic */ void putAll(Map r100, Sequence r101) {
        MapsKt__MapsKt.putAll(r100, r101);
    }

    public static /* bridge */ /* synthetic */ void putAll(Map r100, Pair[] r101) {
        MapsKt__MapsKt.putAll(r100, r101);
    }

    public static /* bridge */ /* synthetic */ SortedMap sortedMapOf(Comparator r100, Pair... r101) {
        return MapsKt__MapsJVMKt.sortedMapOf(r100, r101);
    }

    public static /* bridge */ /* synthetic */ SortedMap sortedMapOf(Pair... r100) {
        return MapsKt__MapsJVMKt.sortedMapOf(r100);
    }

    public static /* bridge */ /* synthetic */ List toList(Map r100) {
        return MapsKt___MapsKt.toList(r100);
    }

    public static /* bridge */ /* synthetic */ Map toMap(Iterable r100) {
        return MapsKt__MapsKt.toMap(r100);
    }

    public static /* bridge */ /* synthetic */ Map toMap(Iterable r100, Map r101) {
        return MapsKt__MapsKt.toMap(r100, r101);
    }

    public static /* bridge */ /* synthetic */ Map toMap(Map r100) {
        return MapsKt__MapsKt.toMap(r100);
    }

    public static /* bridge */ /* synthetic */ Map toMap(Sequence r100) {
        return MapsKt__MapsKt.toMap(r100);
    }

    public static /* bridge */ /* synthetic */ Map toMap(Sequence r100, Map r101) {
        return MapsKt__MapsKt.toMap(r100, r101);
    }

    public static /* bridge */ /* synthetic */ Map toMap(Pair[] r100) {
        return MapsKt__MapsKt.toMap(r100);
    }

    public static /* bridge */ /* synthetic */ Map toMutableMap(Map r100) {
        return MapsKt__MapsKt.toMutableMap(r100);
    }

    public static /* bridge */ /* synthetic */ SortedMap toSortedMap(Map r100) {
        return MapsKt__MapsJVMKt.toSortedMap(r100);
    }

    public static /* bridge */ /* synthetic */ SortedMap toSortedMap(Map r100, Comparator r101) {
        return MapsKt__MapsJVMKt.toSortedMap(r100, r101);
    }

    public static /* bridge */ /* synthetic */ Map withDefaultMutable(Map r100, Function1 r101) {
        return MapsKt__MapWithDefaultKt.withDefaultMutable(r100, r101);
    }

    private MapsKt() {
    }
}
