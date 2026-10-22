package com.google.protobuf.util;

import com.google.common.base.CaseFormat;
import com.google.common.base.b;
import com.google.common.base.i;
import com.google.common.base.m;
import com.google.common.base.p;
import com.google.common.base.q;
import com.google.common.primitives.Ints;
import com.google.protobuf.Descriptors;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Internal;
import com.google.protobuf.Message;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: loaded from: classes23.dex */
public class FieldMaskUtil {
    private static final String FIELD_PATH_SEPARATOR = ",";
    private static final String FIELD_PATH_SEPARATOR_REGEX = ",";
    private static final String FIELD_SEPARATOR_REGEX = "\\.";

    public static final class MergeOptions {
        private boolean replaceMessageFields;
        private boolean replacePrimitiveFields;
        private boolean replaceRepeatedFields;

        public MergeOptions() {
            this.replaceMessageFields = false;
            this.replaceRepeatedFields = false;
            this.replacePrimitiveFields = false;
        }

        public boolean replaceMessageFields() {
            return this.replaceMessageFields;
        }

        public boolean replacePrimitiveFields() {
            return this.replacePrimitiveFields;
        }

        public boolean replaceRepeatedFields() {
            return this.replaceRepeatedFields;
        }

        public MergeOptions setReplaceMessageFields(boolean r100) {
            this.replaceMessageFields = r100;
            return this;
        }

        public MergeOptions setReplacePrimitiveFields(boolean r100) {
            this.replacePrimitiveFields = r100;
            return this;
        }

        public MergeOptions setReplaceRepeatedFields(boolean r100) {
            this.replaceRepeatedFields = r100;
            return this;
        }
    }

    private FieldMaskUtil() {
    }

    public static FieldMask fromJsonString(String r100) {
        q r101 = new q(new p(new b.d(",".charAt(0))));
        r100.getClass();
        FieldMask.Builder r102 = FieldMask.newBuilder();
        Iterator<String> r103 = r101.f274728b.a(r101, r100);
    L4:
        if (r103.hasNext() == false) goto L10;
        String r104 = r103.next();
        if (r104.isEmpty() == true) goto L4;
        r102.addPaths(CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, r104));
        goto L4
    L10:
        return r102.build();
    }

    public static FieldMask fromString(String r100) {
        return fromStringList(null, Arrays.asList(r100.split(",")));
    }

    public static FieldMask normalize(FieldMask r100) {
        return new FieldMaskTree(r100).toFieldMask();
    }

    public static String toJsonString(FieldMask r100) {
        ArrayList r101 = new ArrayList(r100.getPathsCount());
        Iterator<String> r102 = r100.getPathsList().iterator();
    L4:
        if (r102.hasNext() == false) goto L10;
        String r103 = r102.next();
        if (r103.isEmpty() == true) goto L4;
        r101.add(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, r103));
        goto L4
    L10:
        return new i(",").b(r101);
    }

    public static String toString(FieldMask r100) {
        StringBuilder r101 = new StringBuilder();
        Iterator<String> r102 = r100.getPathsList().iterator();
        boolean r103 = true;
    L4:
        if (r102.hasNext() == false) goto L13;
        String r104 = r102.next();
        if (r104.isEmpty() == true) goto L4;
        if (r103 == false) goto L10;
        r103 = false;
    L11:
        r101.append(r104);
        goto L4
    L10:
        r101.append(",");
        goto L11
    L13:
        return r101.toString();
    }

    public static FieldMask fromFieldNumbers(Class<? extends Message> r100, Iterable<Integer> r101) {
        Descriptors.Descriptor r102 = ((Message) Internal.getDefaultInstance(r100)).getDescriptorForType();
        FieldMask.Builder r103 = FieldMask.newBuilder();
        Iterator<Integer> r104 = r101.iterator();
    L4:
        if (r104.hasNext() == false) goto L11;
        Integer r105 = r104.next();
        Descriptors.FieldDescriptor r106 = r102.findFieldByNumber(r105.intValue());
        if (r106 == null) goto L8;
        boolean r107 = true;
    L9:
        m.c(r107, String.format("%s is not a valid field number for %s.", new Object[]{r105, r100}));
        r103.addPaths(r106.getName());
        goto L4
    L8:
        r107 = false;
        goto L9
    L11:
        return r103.build();
    }

    public static FieldMask fromString(Class<? extends Message> r100, String r101) {
        return fromStringList(r100, Arrays.asList(r101.split(",")));
    }

    public static FieldMask fromStringList(Class<? extends Message> r100, Iterable<String> r101) {
        FieldMask.Builder r102 = FieldMask.newBuilder();
        Iterator<String> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L16;
        String r104 = r103.next();
        if (r104.isEmpty() == true) goto L4;
        if (r100 != null) goto L10;
    L14:
        r102.addPaths(r104);
        goto L4
    L10:
        if (isValid(r100, r104) == true) goto L14;
        throw new IllegalArgumentException(r104 + " is not a valid path for " + r100);
    L16:
        return r102.build();
    }

    public static FieldMask intersection(FieldMask r100, FieldMask r101) {
        FieldMaskTree r102 = new FieldMaskTree(r100);
        FieldMaskTree r103 = new FieldMaskTree();
        Iterator<String> r104 = r101.getPathsList().iterator();
    L4:
        if (r104.hasNext() == false) goto L7;
        r102.intersectFieldPath(r104.next(), r103);
        goto L4
    L7:
        return r103.toFieldMask();
    }

    public static boolean isValid(Descriptors.Descriptor r100, String r101) {
        String[] r102 = r101.split("\\.");
        if (r102.length != 0) goto L5;
        return false;
    L5:
        int r103 = r102.length;
        int r104 = 0;
    L6:
        if (r104 >= r103) goto L20;
        String r105 = r102[r104];
        if (r100 == null) goto L9;
        Descriptors.FieldDescriptor r106 = r100.findFieldByName(r105);
        if (r106 == null) goto L12;
        if (r106.isRepeated() == false) goto L16;
    L18:
        r100 = null;
    L19:
        r104 = r104 + 1;
        goto L6
    L16:
        if (r106.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L18;
        r100 = r106.getMessageType();
        goto L19
    L12:
        return false;
    L9:
        return false;
    L20:
        return true;
    }

    public static FieldMask fromFieldNumbers(Class<? extends Message> r100, int... r101) {
        return fromFieldNumbers(r100, Ints.a(r101));
    }

    public static boolean isValid(Descriptors.Descriptor r100, FieldMask r101) {
        Iterator<String> r102 = r101.getPathsList().iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        if (isValid(r100, r102.next()) == true) goto L4;
        return false;
    L9:
        return true;
    }

    public static boolean isValid(Class<? extends Message> r100, FieldMask r101) {
        return isValid(((Message) Internal.getDefaultInstance(r100)).getDescriptorForType(), r101);
    }

    public static boolean isValid(Class<? extends Message> r100, String r101) {
        return isValid(((Message) Internal.getDefaultInstance(r100)).getDescriptorForType(), r101);
    }

    public static void merge(FieldMask r100, Message r101, Message.Builder r102) {
        merge(r100, r101, r102, new MergeOptions());
    }

    public static FieldMask union(FieldMask r100, FieldMask r101, FieldMask... r102) {
        FieldMaskTree r103 = new FieldMaskTree(r100).mergeFromFieldMask(r101);
        int r104 = r102.length;
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L6;
        r103.mergeFromFieldMask(r102[r105]);
        r105 = r105 + 1;
        goto L3
    L6:
        return r103.toFieldMask();
    }

    public static void merge(FieldMask r100, Message r101, Message.Builder r102, MergeOptions r103) {
        new FieldMaskTree(r100).merge(r101, r102, r103);
    }
}
