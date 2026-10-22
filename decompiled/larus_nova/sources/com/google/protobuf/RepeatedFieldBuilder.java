package com.google.protobuf;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage.Builder;
import com.google.protobuf.MessageOrBuilder;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public class RepeatedFieldBuilder<MType extends GeneratedMessage, BType extends GeneratedMessage.Builder, IType extends MessageOrBuilder> implements GeneratedMessage.BuilderParent {
    private List<SingleFieldBuilder<MType, BType, IType>> builders;
    private BuilderExternalList<MType, BType, IType> externalBuilderList;
    private MessageExternalList<MType, BType, IType> externalMessageList;
    private MessageOrBuilderExternalList<MType, BType, IType> externalMessageOrBuilderList;
    private boolean isClean;
    private boolean isMessagesListMutable;
    private List<MType> messages;
    private GeneratedMessage.BuilderParent parent;

    public static class BuilderExternalList<MType extends GeneratedMessage, BType extends GeneratedMessage.Builder, IType extends MessageOrBuilder> extends AbstractList<BType> implements List<BType> {
        RepeatedFieldBuilder<MType, BType, IType> builder;

        public void incrementModCount() {
            ((AbstractList) this).modCount++;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.builder.getCount();
        }

        public BuilderExternalList(RepeatedFieldBuilder<MType, BType, IType> r100) {
            this.builder = r100;
        }

        @Override // java.util.AbstractList, java.util.List
        public BType get(int r100) {
            return (BType) this.builder.getBuilder(r100);
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object get(int r100) {
            return get(r100);
        }
    }

    public static class MessageExternalList<MType extends GeneratedMessage, BType extends GeneratedMessage.Builder, IType extends MessageOrBuilder> extends AbstractList<MType> implements List<MType> {
        RepeatedFieldBuilder<MType, BType, IType> builder;

        public void incrementModCount() {
            ((AbstractList) this).modCount++;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.builder.getCount();
        }

        public MessageExternalList(RepeatedFieldBuilder<MType, BType, IType> r100) {
            this.builder = r100;
        }

        @Override // java.util.AbstractList, java.util.List
        public MType get(int r100) {
            return (MType) this.builder.getMessage(r100);
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object get(int r100) {
            return get(r100);
        }
    }

    public static class MessageOrBuilderExternalList<MType extends GeneratedMessage, BType extends GeneratedMessage.Builder, IType extends MessageOrBuilder> extends AbstractList<IType> implements List<IType> {
        RepeatedFieldBuilder<MType, BType, IType> builder;

        public void incrementModCount() {
            ((AbstractList) this).modCount++;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.builder.getCount();
        }

        public MessageOrBuilderExternalList(RepeatedFieldBuilder<MType, BType, IType> r100) {
            this.builder = r100;
        }

        @Override // java.util.AbstractList, java.util.List
        public IType get(int r100) {
            return (IType) this.builder.getMessageOrBuilder(r100);
        }

        @Override // java.util.AbstractList, java.util.List
        public /* bridge */ /* synthetic */ Object get(int r100) {
            return get(r100);
        }
    }

    public List<MType> build() {
        this.isClean = true;
        boolean r100 = this.isMessagesListMutable;
        if (r100 == true) goto L9;
        if (this.builders != null) goto L9;
        return this.messages;
    L9:
        if (r100 == true) goto L23;
        int r101 = 0;
    L12:
        if (r101 >= this.messages.size()) goto L19;
        Message r102 = (Message) ListProtector.get(this.messages, r101);
        SingleFieldBuilder r103 = (SingleFieldBuilder) ListProtector.get(this.builders, r101);
        if (r103 == null) goto L18;
        if (r103.build() == r102) goto L18;
        boolean r104 = false;
    L20:
        if (r104 == false) goto L23;
        return this.messages;
    L18:
        r101 = r101 + 1;
        goto L12
    L19:
        r104 = true;
    L23:
        ensureMutableMessageList();
        int r105 = 0;
    L25:
        if (r105 >= this.messages.size()) goto L27;
        ListProtector.set(this.messages, r105, getMessage(r105, true));
        r105 = r105 + 1;
        goto L25
    L27:
        List<MType> r106 = Collections.unmodifiableList(this.messages);
        this.messages = r106;
        this.isMessagesListMutable = false;
        return r106;
    }

    public void dispose() {
        this.parent = null;
    }

    private void ensureBuilders() {
        if (this.builders != null) goto L8;
        this.builders = new ArrayList(this.messages.size());
        int r100 = 0;
    L6:
        if (r100 >= this.messages.size()) goto L10;
        this.builders.add(null);
        r100 = r100 + 1;
        goto L6
    L10:
        return;
    }

    private void ensureMutableMessageList() {
        if (this.isMessagesListMutable == true) goto L6;
        this.messages = new ArrayList(this.messages);
        this.isMessagesListMutable = true;
        return;
    }

    private void incrementModCounts() {
        MessageExternalList<MType, BType, IType> r100 = this.externalMessageList;
        if (r100 == null) goto L5;
        r100.incrementModCount();
    L5:
        BuilderExternalList<MType, BType, IType> r101 = this.externalBuilderList;
        if (r101 == null) goto L8;
        r101.incrementModCount();
    L8:
        MessageOrBuilderExternalList<MType, BType, IType> r102 = this.externalMessageOrBuilderList;
        if (r102 == null) goto L12;
        r102.incrementModCount();
        return;
    }

    private void onChanged() {
        if (this.isClean == false) goto L8;
        GeneratedMessage.BuilderParent r100 = this.parent;
        if (r100 == null) goto L9;
        r100.markDirty();
        this.isClean = false;
        return;
    L9:
        return;
    }

    public List<BType> getBuilderList() {
        if (this.externalBuilderList != null) goto L6;
        this.externalBuilderList = new BuilderExternalList(this);
    L6:
        return this.externalBuilderList;
    }

    public int getCount() {
        return this.messages.size();
    }

    public List<MType> getMessageList() {
        if (this.externalMessageList != null) goto L6;
        this.externalMessageList = new MessageExternalList(this);
    L6:
        return this.externalMessageList;
    }

    public List<IType> getMessageOrBuilderList() {
        if (this.externalMessageOrBuilderList != null) goto L6;
        this.externalMessageOrBuilderList = new MessageOrBuilderExternalList(this);
    L6:
        return this.externalMessageOrBuilderList;
    }

    public boolean isEmpty() {
        return this.messages.isEmpty();
    }

    public void clear() {
        this.messages = Collections.emptyList();
        this.isMessagesListMutable = false;
        List<SingleFieldBuilder<MType, BType, IType>> r100 = this.builders;
        if (r100 == null) goto L11;
        Iterator<SingleFieldBuilder<MType, BType, IType>> r101 = r100.iterator();
    L6:
        if (r101.hasNext() == false) goto L10;
        SingleFieldBuilder<MType, BType, IType> r102 = r101.next();
        if (r102 == null) goto L6;
        r102.dispose();
        goto L6
    L10:
        this.builders = null;
    L11:
        onChanged();
        incrementModCounts();
    }

    @Override // com.google.protobuf.AbstractMessage.BuilderParent
    public void markDirty() {
        onChanged();
    }

    public RepeatedFieldBuilder<MType, BType, IType> addAllMessages(Iterable<? extends MType> r100) {
        Iterator<? extends MType> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L11;
        if (r101.next() != null) goto L4;
        throw null;
    L11:
        if ((r100 instanceof Collection) == false) goto L16;
        Collection r102 = (Collection) r100;
        if (r102.size() != 0) goto L15;
        return this;
    L15:
        int r103 = r102.size();
    L17:
        ensureMutableMessageList();
        if (r103 < 0) goto L22;
        List<MType> r104 = this.messages;
        if ((r104 instanceof ArrayList) == false) goto L22;
        ((ArrayList) r104).ensureCapacity(r104.size() + r103);
    L22:
        Iterator<? extends MType> r105 = r100.iterator();
    L24:
        if (r105.hasNext() == false) goto L26;
        addMessage(r105.next());
        goto L24
    L26:
        onChanged();
        incrementModCounts();
        return this;
    L16:
        r103 = -1;
        goto L17
    }

    public BType addBuilder(MType r100) {
        ensureMutableMessageList();
        ensureBuilders();
        SingleFieldBuilder<MType, BType, IType> r101 = new SingleFieldBuilder(r100, this, this.isClean);
        this.messages.add(null);
        this.builders.add(r101);
        onChanged();
        incrementModCounts();
        return (BType) r101.getBuilder();
    }

    public RepeatedFieldBuilder<MType, BType, IType> addMessage(MType r100) {
        if (r100 == null) goto L9;
        ensureMutableMessageList();
        this.messages.add(r100);
        List<SingleFieldBuilder<MType, BType, IType>> r101 = this.builders;
        if (r101 == null) goto L7;
        r101.add(null);
    L7:
        onChanged();
        incrementModCounts();
        return this;
    L9:
        throw null;
    }

    public BType getBuilder(int r100) {
        ensureBuilders();
        SingleFieldBuilder r101 = (SingleFieldBuilder) ListProtector.get(this.builders, r100);
        if (r101 != null) goto L6;
        SingleFieldBuilder r102 = new SingleFieldBuilder((GeneratedMessage) ListProtector.get(this.messages, r100), this, this.isClean);
        ListProtector.set(this.builders, r100, r102);
        r101 = r102;
    L6:
        return (BType) r101.getBuilder();
    }

    public MType getMessage(int r100) {
        return (MType) getMessage(r100, false);
    }

    public IType getMessageOrBuilder(int r100) {
        List<SingleFieldBuilder<MType, BType, IType>> r101 = this.builders;
        if (r101 == null) goto L5;
        SingleFieldBuilder r102 = (SingleFieldBuilder) ListProtector.get(r101, r100);
        if (r102 != null) goto L11;
        return (IType) ListProtector.get(this.messages, r100);
    L11:
        return (IType) r102.getMessageOrBuilder();
    L5:
        return (IType) ListProtector.get(this.messages, r100);
    }

    public void remove(int r100) {
        ensureMutableMessageList();
        ListProtector.remove(this.messages, r100);
        List<SingleFieldBuilder<MType, BType, IType>> r101 = this.builders;
        if (r101 == null) goto L7;
        SingleFieldBuilder r102 = (SingleFieldBuilder) ListProtector.remove(r101, r100);
        if (r102 == null) goto L7;
        r102.dispose();
    L7:
        onChanged();
        incrementModCounts();
    }

    private MType getMessage(int r100, boolean r101) {
        List<SingleFieldBuilder<MType, BType, IType>> r102 = this.builders;
        if (r102 == null) goto L5;
        SingleFieldBuilder r103 = (SingleFieldBuilder) ListProtector.get(r102, r100);
        if (r103 == null) goto L9;
        if (r101 == false) goto L13;
        return (MType) r103.build();
    L13:
        return (MType) r103.getMessage();
    L9:
        return (MType) ListProtector.get(this.messages, r100);
    L5:
        return (MType) ListProtector.get(this.messages, r100);
    }

    public BType addBuilder(int r100, MType r101) {
        ensureMutableMessageList();
        ensureBuilders();
        SingleFieldBuilder r102 = new SingleFieldBuilder(r101, this, this.isClean);
        ListProtector.add(this.messages, r100, null);
        ListProtector.add(this.builders, r100, r102);
        onChanged();
        incrementModCounts();
        return (BType) r102.getBuilder();
    }

    public RepeatedFieldBuilder<MType, BType, IType> addMessage(int r100, MType r101) {
        if (r101 == null) goto L9;
        ensureMutableMessageList();
        ListProtector.add(this.messages, r100, r101);
        List<SingleFieldBuilder<MType, BType, IType>> r102 = this.builders;
        if (r102 == null) goto L7;
        ListProtector.add(r102, r100, null);
    L7:
        onChanged();
        incrementModCounts();
        return this;
    L9:
        throw null;
    }

    public RepeatedFieldBuilder<MType, BType, IType> setMessage(int r100, MType r101) {
        if (r101 == null) goto L11;
        ensureMutableMessageList();
        ListProtector.set(this.messages, r100, r101);
        List<SingleFieldBuilder<MType, BType, IType>> r102 = this.builders;
        if (r102 == null) goto L9;
        SingleFieldBuilder r103 = (SingleFieldBuilder) ListProtector.set(r102, r100, null);
        if (r103 == null) goto L9;
        r103.dispose();
    L9:
        onChanged();
        incrementModCounts();
        return this;
    L11:
        throw null;
    }

    public RepeatedFieldBuilder(List<MType> r100, boolean r101, GeneratedMessage.BuilderParent r102, boolean r103) {
        this.messages = r100;
        this.isMessagesListMutable = r101;
        this.parent = r102;
        this.isClean = r103;
    }
}
