package com.bytedance.ee.bear.document.forecast;

import com.bytedance.ee.bear.document.DocOpenConfig;
import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u001f\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u0006J\u000e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0006J\u0018\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0002J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0016\u001a\u00020\u0006J\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00070\u001aJ\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ee/bear/document/forecast/OperationRecord;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "records", "", "", "Lcom/bytedance/ee/bear/document/forecast/OperationRecord$Record;", "getRecords", "()Ljava/util/Map;", "defaultTypes", "", "getDefaultTypes", "()Ljava/util/List;", "size", "getSize", "()I", "setSize", "(I)V", "init", "", "recordOpenDoc", "type", "newRecord", "findRecordByType", "getAllRecords", "", "toString", "", "Record", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OperationRecord implements NonProguard {
    private final transient List<Integer> defaultTypes;
    private final Map<Integer, Record> records;
    private transient int size;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u0010\u001a\u00020\u000fH\u0002J\u0006\u0010\u0011\u001a\u00020\u000fJ\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ee/bear/document/forecast/OperationRecord$Record;", "Lcom/bytedance/ee/util/io/NonProguard;", "recentOpenCount", "Ljava/util/ArrayDeque;", "", "<init>", "(Ljava/util/ArrayDeque;)V", "getRecentOpenCount", "()Ljava/util/ArrayDeque;", "maxRecordSize", "getMaxRecordSize", "()I", "setMaxRecordSize", "(I)V", "startRecord", "", "trimRecordIfNeed", "increaseOpenCount", "toString", "", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Record implements NonProguard {
        private transient int maxRecordSize;
        private final ArrayDeque<Integer> recentOpenCount;

        public Record() {
            ArrayDeque r0 = null;
            this(r0, 1, r0);
        }

        private final void trimRecordIfNeed() {
        L3:
            if (this.recentOpenCount.size() <= this.maxRecordSize) goto L7;
            if ((!this.recentOpenCount.isEmpty()) == false) goto L10;
            this.recentOpenCount.remove();
            goto L3
        L10:
            return;
        }

        public final void increaseOpenCount() {
            Integer r0 = this.recentOpenCount.pollLast();
            if (r0 == null) goto L6;
            int r1 = r0.intValue();
            this.recentOpenCount.add(Integer.valueOf(r1 + 1));
            return;
        }

        public final void startRecord() {
            this.recentOpenCount.add(0);
            trimRecordIfNeed();
        }

        public String toString() {
            return this.recentOpenCount.toString();
        }

        public final int getMaxRecordSize() {
            return this.maxRecordSize;
        }

        public final ArrayDeque<Integer> getRecentOpenCount() {
            return this.recentOpenCount;
        }

        public Record(ArrayDeque<Integer> r2) {
            Intrinsics.checkNotNullParameter(r2, "recentOpenCount");
            this.recentOpenCount = r2;
        }

        public final void setMaxRecordSize(int r1) {
            this.maxRecordSize = r1;
        }

        public /* synthetic */ Record(ArrayDeque r1, int r2, DefaultConstructorMarker r3) {
            if ((r2 & 1) == 0) goto L5;
            r1 = new ArrayDeque();
        L5:
            this(r1);
        }
    }

    public final Collection<Record> getAllRecords() {
        return this.records.values();
    }

    public String toString() {
        return this.records.toString();
    }

    public OperationRecord() {
        this.records = new LinkedHashMap();
        List<String> r0 = DocOpenConfig.a;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r1.add(Integer.valueOf(e.e((String) r2.next()).b));
        goto L4
    L6:
        this.defaultTypes = r1;
    }

    public final List<Integer> getDefaultTypes() {
        return this.defaultTypes;
    }

    public final Map<Integer, Record> getRecords() {
        return this.records;
    }

    public final int getSize() {
        return this.size;
    }

    public final Record findRecordByType(int r2) {
        return this.records.get(Integer.valueOf(r2));
    }

    public final void init(int r4) {
        this.size = r4;
        Iterator<Map.Entry<Integer, Record>> r0 = this.records.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Record r1 = r0.next().getValue();
        r1.setMaxRecordSize(r4);
        r1.startRecord();
        goto L4
    L6:
        Iterator<T> r2 = this.defaultTypes.iterator();
    L8:
        if (r2.hasNext() == false) goto L12;
        int r3 = ((Number) r2.next()).intValue();
        if (findRecordByType(r3) != null) goto L8;
        newRecord(r3, r4);
        goto L8
    }

    public final void recordOpenDoc(int r3) {
        Record r0 = this.records.get(Integer.valueOf(r3));
        if (r0 != null) goto L5;
        r0 = newRecord(r3, this.size);
    L5:
        r0.increaseOpenCount();
    }

    public final void setSize(int r1) {
        this.size = r1;
    }

    private final Record newRecord(int r4, int r5) {
        ArrayDeque r1 = null;
        Record r0 = new Record(r1, 1, r1);
        r0.setMaxRecordSize(r5);
        r0.startRecord();
        Integer r6 = Integer.valueOf(r4);
        this.records.put(r6, r0);
        return r0;
    }
}
