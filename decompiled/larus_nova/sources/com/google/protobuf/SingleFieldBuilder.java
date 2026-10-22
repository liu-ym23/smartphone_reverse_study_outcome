package com.google.protobuf;

import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage.Builder;
import com.google.protobuf.MessageOrBuilder;

/* JADX INFO: loaded from: classes23.dex */
public class SingleFieldBuilder<MType extends GeneratedMessage, BType extends GeneratedMessage.Builder, IType extends MessageOrBuilder> implements GeneratedMessage.BuilderParent {
    private BType builder;
    private boolean isClean;
    private MType message;
    private GeneratedMessage.BuilderParent parent;

    public MType build() {
        this.isClean = true;
        return (MType) getMessage();
    }

    public void dispose() {
        this.parent = null;
    }

    private void onChanged() {
        if (this.builder == null) goto L6;
        this.message = null;
    L6:
        if (this.isClean == false) goto L11;
        GeneratedMessage.BuilderParent r100 = this.parent;
        if (r100 == null) goto L12;
        r100.markDirty();
        this.isClean = false;
        return;
    L12:
        return;
    }

    public SingleFieldBuilder<MType, BType, IType> clear() {
        MType r100 = this.message;
        if (r100 == null) goto L5;
        Message r101 = r100.getDefaultInstanceForType();
    L6:
        this.message = (MType) r101;
        BType r102 = this.builder;
        if (r102 == null) goto L9;
        r102.dispose();
        this.builder = null;
    L9:
        onChanged();
        return this;
    L5:
        r101 = this.builder.getDefaultInstanceForType();
        goto L6
    }

    public BType getBuilder() {
        if (this.builder != null) goto L6;
        BType r100 = (BType) this.message.newBuilderForType(this);
        this.builder = r100;
        r100.mergeFrom(this.message);
        this.builder.markClean();
    L6:
        return this.builder;
    }

    public MType getMessage() {
        if (this.message != null) goto L6;
        this.message = (MType) this.builder.buildPartial();
    L6:
        return this.message;
    }

    public IType getMessageOrBuilder() {
        BType r100 = this.builder;
        if (r100 == null) goto L6;
        return r100;
    L6:
        return this.message;
    }

    @Override // com.google.protobuf.AbstractMessage.BuilderParent
    public void markDirty() {
        onChanged();
    }

    public SingleFieldBuilder<MType, BType, IType> mergeFrom(MType r100) {
        if (this.builder != null) goto L7;
        Message r101 = this.message;
        if (r101 != r101.getDefaultInstanceForType()) goto L7;
        this.message = r100;
    L8:
        onChanged();
        return this;
    L7:
        getBuilder().mergeFrom(r100);
        goto L8
    }

    public SingleFieldBuilder<MType, BType, IType> setMessage(MType r100) {
        if (r100 == null) goto L9;
        this.message = r100;
        BType r101 = this.builder;
        if (r101 == null) goto L7;
        r101.dispose();
        this.builder = null;
    L7:
        onChanged();
        return this;
    L9:
        throw null;
    }

    public SingleFieldBuilder(MType r100, GeneratedMessage.BuilderParent r101, boolean r102) {
        if (r100 == null) goto L7;
        this.message = r100;
        this.parent = r101;
        this.isClean = r102;
        return;
    L7:
        throw null;
    }
}
