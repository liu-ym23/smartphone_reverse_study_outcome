package com.squareup.wire;

import com.squareup.wire.Message;
import com.squareup.wire.Message.Builder;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes34.dex */
final class FieldBinding<M extends Message<M, B>, B extends Message.Builder<M, B>> {
    private ProtoAdapter<Object> adapter;
    private final String adapterString;
    private final Field builderField;
    private final Method builderMethod;
    private ProtoAdapter<?> keyAdapter;
    private final String keyAdapterString;
    public final WireField.Label label;
    private final Field messageField;
    public final String name;
    public final boolean redacted;
    private ProtoAdapter<?> singleAdapter;
    public final int tag;

    public ProtoAdapter<Object> adapter() {
        ProtoAdapter<Object> r100 = this.adapter;
        if (r100 == null) goto L6;
        return r100;
    L6:
        if (isMap() == false) goto L9;
        ProtoAdapter<Object> r101 = ProtoAdapter.newMapAdapter(keyAdapter(), singleAdapter());
        this.adapter = r101;
        return r101;
    L9:
        ProtoAdapter<?> r102 = singleAdapter().withLabel(this.label);
        this.adapter = r102;
        return r102;
    }

    public boolean isMap() {
        return !this.keyAdapterString.isEmpty();
    }

    public ProtoAdapter<?> keyAdapter() {
        ProtoAdapter<?> r100 = this.keyAdapter;
        if (r100 == null) goto L5;
        return r100;
    L5:
        ProtoAdapter<?> r101 = ProtoAdapter.get(this.keyAdapterString);
        this.keyAdapter = r101;
        return r101;
    }

    public ProtoAdapter<?> singleAdapter() {
        ProtoAdapter<?> r100 = this.singleAdapter;
        if (r100 == null) goto L5;
        return r100;
    L5:
        ProtoAdapter<?> r101 = ProtoAdapter.get(this.adapterString);
        this.singleAdapter = r101;
        return r101;
    }

    public Object get(M r100) {
        return this.messageField.get(r100);
    L4:
        e = move-exception;
        throw new AssertionError(e);
    }

    public Object getFromBuilder(B r100) {
        return this.builderField.get(r100);
    L4:
        e = move-exception;
        throw new AssertionError(e);
    }

    private static Field getBuilderField(Class<?> r100, String r101) {
        return r100.getField(r101);
    L5:
        throw new AssertionError("No builder field " + r100.getName() + "." + r101);
    }

    public void set(B r100, Object r101) {
    L9:
        e = move-exception;
        throw new AssertionError(e);
    L3:
        if (this.label.isOneOf() == false) goto L5;
        this.builderMethod.invoke(r100, new Object[]{r101});     // Catch: InvocationTargetException -> L7 Throwable -> L9
        return;
    L5:
        this.builderField.set(r100, r101);     // Catch: InvocationTargetException -> L7 Throwable -> L9
    }

    public void value(B r100, Object r101) {
        if (this.label.isRepeated() == false) goto L6;
        ((List) getFromBuilder(r100)).add(r101);
        return;
    L6:
        if (this.keyAdapterString.isEmpty() == true) goto L8;
        ((Map) getFromBuilder(r100)).putAll((Map) r101);
        return;
    L8:
        set(r100, r101);
    }

    public FieldBinding(WireField r100, Field r101, Class<B> r102) {
        this.label = r100.label();
        String r103 = r101.getName();
        this.name = r103;
        this.tag = r100.tag();
        this.keyAdapterString = r100.keyAdapter();
        this.adapterString = r100.adapter();
        this.redacted = r100.redacted();
        this.messageField = r101;
        this.builderField = getBuilderField(r102, r103);
        this.builderMethod = getBuilderMethod(r102, r103, r101.getType());
    }

    private static Method getBuilderMethod(Class<?> r100, String r101, Class<?> r102) {
        return r100.getMethod(r101, new Class[]{r102});
    L6:
        throw new AssertionError("No builder method " + r100.getName() + "." + r101 + "(" + r102.getName() + ")");
    }
}
