package com.squareup.wire;

import com.squareup.wire.Message;
import com.squareup.wire.Message.Builder;

/* JADX INFO: loaded from: classes34.dex */
public class DefaultValueBuilder<M extends Message<M, B>, B extends Message.Builder<M, B>> {
    private final B builder;

    public M build() {
        return (M) this.builder.build();
    }

    public DefaultValueBuilder(B r100) {
        this.builder = r100;
    }

    public DefaultValueBuilder addDefaultSettingGroup(DefaultValueGroup<M, B> r100) {
        r100.addDefaultValues(this.builder);
        return this;
    }
}
