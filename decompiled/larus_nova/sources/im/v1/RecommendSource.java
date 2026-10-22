package im.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes41.dex */
public final class RecommendSource extends Message<RecommendSource, Builder> {
    public static final ProtoAdapter<RecommendSource> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<DocIdentity> source_doc_metas;
    public final List<EntityType> source_entity_types;
    public final List<MessageIdentity> source_message_metas;
    public final List<WikiIdentity> source_wiki_metas;

    public static final class Builder extends Message.Builder<RecommendSource, Builder> {
        public List<DocIdentity> source_doc_metas;
        public List<EntityType> source_entity_types;
        public List<MessageIdentity> source_message_metas;
        public List<WikiIdentity> source_wiki_metas;

        @Override // com.squareup.wire.Message.Builder
        public RecommendSource build() {
            return new RecommendSource(this.source_entity_types, this.source_doc_metas, this.source_wiki_metas, this.source_message_metas, super.buildUnknownFields());
        }

        public Builder() {
            this.source_entity_types = Internal.newMutableList();
            this.source_doc_metas = Internal.newMutableList();
            this.source_wiki_metas = Internal.newMutableList();
            this.source_message_metas = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder source_doc_metas(List<DocIdentity> r100) {
            Internal.checkElementsNotNull(r100);
            this.source_doc_metas = r100;
            return this;
        }

        public Builder source_entity_types(List<EntityType> r100) {
            Internal.checkElementsNotNull(r100);
            this.source_entity_types = r100;
            return this;
        }

        public Builder source_message_metas(List<MessageIdentity> r100) {
            Internal.checkElementsNotNull(r100);
            this.source_message_metas = r100;
            return this;
        }

        public Builder source_wiki_metas(List<WikiIdentity> r100) {
            Internal.checkElementsNotNull(r100);
            this.source_wiki_metas = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_RecommendSource extends ProtoAdapter<RecommendSource> {
        public ProtoAdapter_RecommendSource() {
            super(FieldEncoding.LENGTH_DELIMITED, RecommendSource.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public RecommendSource decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.source_entity_types.add(EntityType.ADAPTER.decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L19
        L19:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.source_doc_metas.add(DocIdentity.ADAPTER.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.source_wiki_metas.add(WikiIdentity.ADAPTER.decode(r100));
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.source_message_metas.add(MessageIdentity.ADAPTER.decode(r100));
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(RecommendSource r100) {
            return (((EntityType.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.source_entity_types) + DocIdentity.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.source_doc_metas)) + WikiIdentity.ADAPTER.asRepeated().encodedSizeWithTag(3, r100.source_wiki_metas)) + MessageIdentity.ADAPTER.asRepeated().encodedSizeWithTag(4, r100.source_message_metas)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ RecommendSource decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(RecommendSource r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, RecommendSource r101) throws IOException {
            EntityType.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.source_entity_types);
            DocIdentity.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.source_doc_metas);
            WikiIdentity.ADAPTER.asRepeated().encodeWithTag(r100, 3, r101.source_wiki_metas);
            MessageIdentity.ADAPTER.asRepeated().encodeWithTag(r100, 4, r101.source_message_metas);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, RecommendSource r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_RecommendSource();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.source_entity_types = Internal.copyOf("source_entity_types", this.source_entity_types);
        r100.source_doc_metas = Internal.copyOf("source_doc_metas", this.source_doc_metas);
        r100.source_wiki_metas = Internal.copyOf("source_wiki_metas", this.source_wiki_metas);
        r100.source_message_metas = Internal.copyOf("source_message_metas", this.source_message_metas);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return RecommendSource.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public RecommendSource(List<EntityType> r100, List<DocIdentity> r101, List<WikiIdentity> r102, List<MessageIdentity> r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public RecommendSource(List<EntityType> r100, List<DocIdentity> r101, List<WikiIdentity> r102, List<MessageIdentity> r103, ByteString r104) {
        super(ADAPTER, r104);
        this.source_entity_types = Internal.immutableCopyOf("source_entity_types", r100);
        this.source_doc_metas = Internal.immutableCopyOf("source_doc_metas", r101);
        this.source_wiki_metas = Internal.immutableCopyOf("source_wiki_metas", r102);
        this.source_message_metas = Internal.immutableCopyOf("source_message_metas", r103);
    }
}
