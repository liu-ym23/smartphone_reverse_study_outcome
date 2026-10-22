package com.google.protobuf.util;

import com.google.protobuf.Descriptors;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Message;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes23.dex */
final class FieldMaskTree {
    private static final String FIELD_PATH_SEPARATOR_REGEX = "\\.";
    private static final Logger logger = null;
    private final Node root;

    /* JADX INFO: renamed from: com.google.protobuf.util.FieldMaskTree$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Node {
        final SortedMap<String, Node> children;

        private Node() {
            this.children = new TreeMap();
        }

        public /* synthetic */ Node(AnonymousClass1 r100) {
            this();
        }
    }

    static {
        logger = Logger.getLogger(FieldMaskTree.class.getName());
    }

    public FieldMask toFieldMask() {
        if (this.root.children.isEmpty() == true) goto L5;
        ArrayList r100 = new ArrayList();
        getFieldPaths(this.root, "", r100);
        return FieldMask.newBuilder().addAllPaths(r100).build();
    L5:
        return FieldMask.getDefaultInstance();
    }

    public FieldMaskTree() {
        this.root = new Node(null);
    }

    public String toString() {
        return FieldMaskUtil.toString(toFieldMask());
    }

    public FieldMaskTree(FieldMask r100) {
        this.root = new Node(null);
        mergeFromFieldMask(r100);
    }

    public FieldMaskTree addFieldPath(String r100) {
        String[] r101 = r100.split("\\.");
        if (r101.length != 0) goto L5;
        return this;
    L5:
        Node r102 = this.root;
        int r103 = r101.length;
        int r104 = 0;
        boolean r105 = false;
    L6:
        if (r104 >= r103) goto L19;
        String r106 = r101[r104];
        if (r105 == true) goto L15;
        if (r102 == this.root) goto L15;
        if (r102.children.isEmpty() == false) goto L15;
        return this;
    L15:
        if (r102.children.containsKey(r106) == false) goto L17;
        r102 = r102.children.get(r106);
    L18:
        r104 = r104 + 1;
        goto L6
    L17:
        Node r107 = new Node(null);
        r102.children.put(r106, r107);
        r102 = r107;
        r105 = true;
        goto L18
    L19:
        r102.children.clear();
        return this;
    }

    public FieldMaskTree mergeFromFieldMask(FieldMask r100) {
        Iterator<String> r101 = r100.getPathsList().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        addFieldPath(r101.next());
        goto L4
    L6:
        return this;
    }

    public void intersectFieldPath(String r100, FieldMaskTree r101) {
        if (this.root.children.isEmpty() == false) goto L5;
        return;
    L5:
        String[] r102 = r100.split("\\.");
        if (r102.length != 0) goto L8;
        return;
    L8:
        Node r103 = this.root;
        int r104 = r102.length;
        int r105 = 0;
    L9:
        if (r105 >= r104) goto L20;
        String r106 = r102[r105];
        if (r103 == this.root) goto L17;
        if (r103.children.isEmpty() == false) goto L17;
        r101.addFieldPath(r100);
        return;
    L17:
        if (r103.children.containsKey(r106) == false) goto L19;
        r103 = r103.children.get(r106);
        r105 = r105 + 1;
        goto L9
    L19:
        return;
    L20:
        ArrayList r107 = new ArrayList();
        getFieldPaths(r103, r100, r107);
        Iterator r108 = r107.iterator();
    L22:
        if (r108.hasNext() == false) goto L24;
        r101.addFieldPath((String) r108.next());
        goto L22
    }

    private void getFieldPaths(Node r100, String r101, List<String> r102) {
        if (r100.children.isEmpty() == false) goto L6;
        r102.add(r101);
        return;
    L6:
        Iterator<Map.Entry<String, Node>> r103 = r100.children.entrySet().iterator();
    L8:
        if (r103.hasNext() == false) goto L14;
        Map.Entry<String, Node> r104 = r103.next();
        if (r101.isEmpty() == false) goto L12;
        String r105 = r104.getKey();
    L13:
        getFieldPaths(r104.getValue(), r105, r102);
        goto L8
    L12:
        r105 = r101 + "." + r104.getKey();
        goto L13
    }

    public void merge(Message r100, Message.Builder r101, FieldMaskUtil.MergeOptions r110) {
        if (r100.getDescriptorForType() != r101.getDescriptorForType()) goto L10;
        if (this.root.children.isEmpty() == false) goto L7;
        return;
    L7:
        merge(this.root, "", r100, r101, r110);
        return;
    L10:
        throw new IllegalArgumentException("Cannot merge messages of different types.");
    }

    private void merge(Node r110, String r111, Message r112, Message.Builder r113, FieldMaskUtil.MergeOptions r114) {
        if (r112.getDescriptorForType() != r113.getDescriptorForType()) goto L57;
        Descriptors.Descriptor r100 = r112.getDescriptorForType();
        Iterator<Map.Entry<String, Node>> r115 = r110.children.entrySet().iterator();
    L6:
        if (r115.hasNext() == false) goto L55;
        Map.Entry<String, Node> r101 = r115.next();
        Descriptors.FieldDescriptor r102 = r100.findFieldByName(r101.getKey());
        if (r102 == null) goto L9;
        if (r101.getValue().children.isEmpty() == false) goto L13;
        if (r102.isRepeated() == true) goto L31;
        if (r102.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L40;
        if (r112.hasField(r102) == true) goto L54;
        if (r114.replacePrimitiveFields() == false) goto L54;
        r113.clearField(r102);
    L54:
        r113.setField(r102, r112.getField(r102));
        goto L6
    L40:
        if (r114.replaceMessageFields() == true) goto L42;
        if (r112.hasField(r102) == false) goto L6;
        r113.getFieldBuilder(r102).mergeFrom((Message) r112.getField(r102));
        goto L6
    L42:
        if (r112.hasField(r102) == false) goto L43;
        r113.setField(r102, r112.getField(r102));
        goto L6
    L43:
        r113.clearField(r102);
        goto L6
    L31:
        if (r114.replaceRepeatedFields() == true) goto L32;
        Iterator r103 = ((List) r112.getField(r102)).iterator();
    L35:
        if (r103.hasNext() == false) goto L6;
        r113.addRepeatedField(r102, r103.next());
        goto L35
    L32:
        r113.setField(r102, r112.getField(r102));
        goto L6
    L13:
        if (r102.isRepeated() == true) goto L27;
        if (r102.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L27;
        if (r112.hasField(r102) == true) goto L23;
        if (r113.hasField(r102) == false) goto L6;
    L23:
        if (r111.isEmpty() == false) goto L25;
        String r104 = r101.getKey();
    L26:
        merge(r101.getValue(), r104, (Message) r112.getField(r102), r113.getFieldBuilder(r102), r114);
        goto L6
    L25:
        r104 = r111 + "." + r101.getKey();
    L27:
        logger.warning("Field \"" + r102.getFullName() + "\" is not a singluar message field and cannot have sub-fields.");
        goto L6
    L9:
        logger.warning("Cannot find field \"" + r101.getKey() + "\" in message type " + r100.getFullName());
        goto L6
    L55:
        return;
    L57:
        throw new IllegalArgumentException(String.format("source (%s) and destination (%s) descriptor must be equal", new Object[]{r112.getDescriptorForType(), r113.getDescriptorForType()}));
    }
}
