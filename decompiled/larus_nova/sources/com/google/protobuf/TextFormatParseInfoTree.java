package com.google.protobuf;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes23.dex */
public class TextFormatParseInfoTree {
    private Map<Descriptors.FieldDescriptor, List<TextFormatParseLocation>> locationsFromField;
    Map<Descriptors.FieldDescriptor, List<TextFormatParseInfoTree>> subtreesFromField;

    /* JADX INFO: renamed from: com.google.protobuf.TextFormatParseInfoTree$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private Map<Descriptors.FieldDescriptor, List<TextFormatParseLocation>> locationsFromField;
        private Map<Descriptors.FieldDescriptor, List<Builder>> subtreeBuildersFromField;

        public TextFormatParseInfoTree build() {
            return new TextFormatParseInfoTree(this.locationsFromField, this.subtreeBuildersFromField, null);
        }

        private Builder() {
            this.locationsFromField = new HashMap();
            this.subtreeBuildersFromField = new HashMap();
        }

        public /* synthetic */ Builder(AnonymousClass1 r100) {
            this();
        }

        public Builder getBuilderForSubMessageField(Descriptors.FieldDescriptor r100) {
            List<Builder> r101 = this.subtreeBuildersFromField.get(r100);
            if (r101 != null) goto L5;
            r101 = new ArrayList();
            this.subtreeBuildersFromField.put(r100, r101);
        L5:
            Builder r102 = new Builder();
            r101.add(r102);
            return r102;
        }

        public Builder setLocation(Descriptors.FieldDescriptor r100, TextFormatParseLocation r101) {
            List<TextFormatParseLocation> r102 = this.locationsFromField.get(r100);
            if (r102 != null) goto L5;
            r102 = new ArrayList();
            this.locationsFromField.put(r100, r102);
        L5:
            r102.add(r101);
            return this;
        }
    }

    public static Builder builder() {
        return new Builder(null);
    }

    public List<TextFormatParseLocation> getLocations(Descriptors.FieldDescriptor r100) {
        List<TextFormatParseLocation> r101 = this.locationsFromField.get(r100);
        if (r101 == null) goto L5;
        return r101;
    L5:
        return Collections.emptyList();
    }

    public List<TextFormatParseInfoTree> getNestedTrees(Descriptors.FieldDescriptor r100) {
        List<TextFormatParseInfoTree> r101 = this.subtreesFromField.get(r100);
        if (r101 == null) goto L5;
        return r101;
    L5:
        return Collections.emptyList();
    }

    private TextFormatParseInfoTree(Map<Descriptors.FieldDescriptor, List<TextFormatParseLocation>> r100, Map<Descriptors.FieldDescriptor, List<Builder>> r101) {
        HashMap r102 = new HashMap();
        Iterator<Map.Entry<Descriptors.FieldDescriptor, List<TextFormatParseLocation>>> r103 = r100.entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        Map.Entry<Descriptors.FieldDescriptor, List<TextFormatParseLocation>> r104 = r103.next();
        r102.put(r104.getKey(), Collections.unmodifiableList(r104.getValue()));
        goto L4
    L6:
        this.locationsFromField = Collections.unmodifiableMap(r102);
        HashMap r105 = new HashMap();
        Iterator<Map.Entry<Descriptors.FieldDescriptor, List<Builder>>> r106 = r101.entrySet().iterator();
    L8:
        if (r106.hasNext() == false) goto L14;
        Map.Entry<Descriptors.FieldDescriptor, List<Builder>> r107 = r106.next();
        ArrayList r108 = new ArrayList();
        Iterator<Builder> r109 = r107.getValue().iterator();
    L11:
        if (r109.hasNext() == false) goto L13;
        r108.add(r109.next().build());
        goto L11
    L13:
        r105.put(r107.getKey(), Collections.unmodifiableList(r108));
        goto L8
    L14:
        this.subtreesFromField = Collections.unmodifiableMap(r105);
    }

    public TextFormatParseLocation getLocation(Descriptors.FieldDescriptor r100, int r101) {
        return (TextFormatParseLocation) getFromList(getLocations(r100), r101, r100);
    }

    public TextFormatParseInfoTree getNestedTree(Descriptors.FieldDescriptor r100, int r101) {
        return (TextFormatParseInfoTree) getFromList(getNestedTrees(r100), r101, r100);
    }

    public /* synthetic */ TextFormatParseInfoTree(Map r100, Map r101, AnonymousClass1 r102) {
        this(r100, r101);
    }

    private static <T> T getFromList(List<T> r100, int r101, Descriptors.FieldDescriptor r102) {
        if (r101 >= r100.size()) goto L8;
        if (r101 < 0) goto L8;
        return (T) ListProtector.get(r100, r101);
    L8:
        Object[] r103 = new Object[2];
        if (r102 != null) goto L11;
        String r104 = "<null>";
    L12:
        r103[0] = r104;
        r103[1] = Integer.valueOf(r101);
        throw new IllegalArgumentException(String.format("Illegal index field: %s, index %d", r103));
    L11:
        r104 = r102.getName();
        goto L12
    }
}
