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
public final class FeedEntity extends Message<FeedEntity, Builder> {
    public static final ProtoAdapter<FeedEntity> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<Long, FeedFolderRules> feed2folders;
    public final Map<Long, NavigationView> navigation_views;
    public final List<FeedEntityPreview> previews;

    public static final class Builder extends Message.Builder<FeedEntity, Builder> {
        public Map<Long, FeedFolderRules> feed2folders;
        public Map<Long, NavigationView> navigation_views;
        public List<FeedEntityPreview> previews;

        @Override // com.squareup.wire.Message.Builder
        public FeedEntity build() {
            return new FeedEntity(this.previews, this.navigation_views, this.feed2folders, super.buildUnknownFields());
        }

        public Builder() {
            this.previews = Internal.newMutableList();
            this.navigation_views = Internal.newMutableMap();
            this.feed2folders = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder feed2folders(Map<Long, FeedFolderRules> r100) {
            Internal.checkElementsNotNull(r100);
            this.feed2folders = r100;
            return this;
        }

        public Builder navigation_views(Map<Long, NavigationView> r100) {
            Internal.checkElementsNotNull(r100);
            this.navigation_views = r100;
            return this;
        }

        public Builder previews(List<FeedEntityPreview> r100) {
            Internal.checkElementsNotNull(r100);
            this.previews = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FeedEntity extends ProtoAdapter<FeedEntity> {
        private final ProtoAdapter<Map<Long, FeedFolderRules>> feed2folders;
        private final ProtoAdapter<Map<Long, NavigationView>> navigation_views;

        public ProtoAdapter_FeedEntity() {
            super(FieldEncoding.LENGTH_DELIMITED, FeedEntity.class);
            ProtoAdapter<Long> r100 = ProtoAdapter.INT64;
            this.navigation_views = ProtoAdapter.newMapAdapter(r100, NavigationView.ADAPTER);
            this.feed2folders = ProtoAdapter.newMapAdapter(r100, FeedFolderRules.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public FeedEntity decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.previews.add(FeedEntityPreview.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.navigation_views.putAll(this.navigation_views.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.feed2folders.putAll(this.feed2folders.decode(r100));
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(FeedEntity r100) {
            return ((FeedEntityPreview.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.previews) + this.navigation_views.encodedSizeWithTag(2, r100.navigation_views)) + this.feed2folders.encodedSizeWithTag(3, r100.feed2folders)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FeedEntity decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FeedEntity r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FeedEntity r101) throws IOException {
            FeedEntityPreview.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.previews);
            this.navigation_views.encodeWithTag(r100, 2, r101.navigation_views);
            this.feed2folders.encodeWithTag(r100, 3, r101.feed2folders);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FeedEntity r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FeedEntity();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.previews = Internal.copyOf("previews", this.previews);
        r100.navigation_views = Internal.copyOf("navigation_views", this.navigation_views);
        r100.feed2folders = Internal.copyOf("feed2folders", this.feed2folders);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FeedEntity.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FeedEntity(List<FeedEntityPreview> r100, Map<Long, NavigationView> r101, Map<Long, FeedFolderRules> r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public FeedEntity(List<FeedEntityPreview> r100, Map<Long, NavigationView> r101, Map<Long, FeedFolderRules> r102, ByteString r103) {
        super(ADAPTER, r103);
        this.previews = Internal.immutableCopyOf("previews", r100);
        this.navigation_views = Internal.immutableCopyOf("navigation_views", r101);
        this.feed2folders = Internal.immutableCopyOf("feed2folders", r102);
    }
}
