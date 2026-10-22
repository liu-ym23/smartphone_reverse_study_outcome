package com.bytedance.lark.pb.feed.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class FeedFolderRules extends Message<FeedFolderRules, Builder> {
    public static final ProtoAdapter<FeedFolderRules> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<Long, FolderRuleList> folder_list;

    public static final class Builder extends Message.Builder<FeedFolderRules, Builder> {
        public Map<Long, FolderRuleList> folder_list;

        @Override // com.squareup.wire.Message.Builder
        public FeedFolderRules build() {
            return new FeedFolderRules(this.folder_list, super.buildUnknownFields());
        }

        public Builder() {
            this.folder_list = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder folder_list(Map<Long, FolderRuleList> r100) {
            Internal.checkElementsNotNull(r100);
            this.folder_list = r100;
            return this;
        }
    }

    public static final class FolderRuleList extends Message<FolderRuleList, Builder> {
        public static final ProtoAdapter<FolderRuleList> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<FeedFolderRule> rules;

        public static final class Builder extends Message.Builder<FolderRuleList, Builder> {
            public List<FeedFolderRule> rules;

            @Override // com.squareup.wire.Message.Builder
            public FolderRuleList build() {
                return new FolderRuleList(this.rules, super.buildUnknownFields());
            }

            public Builder() {
                this.rules = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder rules(List<FeedFolderRule> r100) {
                Internal.checkElementsNotNull(r100);
                this.rules = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_FolderRuleList extends ProtoAdapter<FolderRuleList> {
            public ProtoAdapter_FolderRuleList() {
                super(FieldEncoding.LENGTH_DELIMITED, FolderRuleList.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public FolderRuleList decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.rules.add(FeedFolderRule.ADAPTER.decode(r100));
                goto L3
            L7:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L9:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(FolderRuleList r100) {
                return FeedFolderRule.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.rules) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ FolderRuleList decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(FolderRuleList r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, FolderRuleList r101) throws IOException {
                FeedFolderRule.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.rules);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FolderRuleList r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_FolderRuleList();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.rules = Internal.copyOf("rules", this.rules);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return FolderRuleList.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public FolderRuleList(List<FeedFolderRule> r100) {
            this(r100, ByteString.EMPTY);
        }

        public FolderRuleList(List<FeedFolderRule> r100, ByteString r101) {
            super(ADAPTER, r101);
            this.rules = Internal.immutableCopyOf("rules", r100);
        }
    }

    public static final class ProtoAdapter_FeedFolderRules extends ProtoAdapter<FeedFolderRules> {
        private final ProtoAdapter<Map<Long, FolderRuleList>> folder_list;

        public ProtoAdapter_FeedFolderRules() {
            super(FieldEncoding.LENGTH_DELIMITED, FeedFolderRules.class);
            this.folder_list = ProtoAdapter.newMapAdapter(ProtoAdapter.INT64, FolderRuleList.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public FeedFolderRules decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.folder_list.putAll(this.folder_list.decode(r100));
            goto L3
        L7:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L9:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(FeedFolderRules r100) {
            return this.folder_list.encodedSizeWithTag(1, r100.folder_list) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FeedFolderRules decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FeedFolderRules r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FeedFolderRules r101) throws IOException {
            this.folder_list.encodeWithTag(r100, 1, r101.folder_list);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FeedFolderRules r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FeedFolderRules();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.folder_list = Internal.copyOf("folder_list", this.folder_list);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FeedFolderRules.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FeedFolderRules(Map<Long, FolderRuleList> r100) {
        this(r100, ByteString.EMPTY);
    }

    public FeedFolderRules(Map<Long, FolderRuleList> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.folder_list = Internal.immutableCopyOf("folder_list", r100);
    }
}
