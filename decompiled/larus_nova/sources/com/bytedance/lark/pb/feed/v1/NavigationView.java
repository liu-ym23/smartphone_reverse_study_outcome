package com.bytedance.lark.pb.feed.v1;

import annotation.Debug;
import com.google.protobuf.FieldOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class NavigationView extends Message<NavigationView, Builder> {
    public static final ProtoAdapter<NavigationView> ADAPTER = null;
    public static final Long DEFAULT_ID = null;
    public static final Boolean DEFAULT_IS_REMOVED = null;
    public static final Long DEFAULT_VERSION = null;
    public static final FieldOptions FIELD_OPTIONS_IS_REMOVED = null;
    public static final FieldOptions FIELD_OPTIONS_TEAM_DATA = null;
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final Long f253629id;
    public final Boolean is_removed;
    public final TeamData team_data;
    public final Long version;

    public static final class Builder extends Message.Builder<NavigationView, Builder> {

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public Long f253630id;
        public Boolean is_removed;
        public TeamData team_data;
        public Long version;

        @Override // com.squareup.wire.Message.Builder
        public NavigationView build() {
            return new NavigationView(this.f253630id, this.version, this.is_removed, this.team_data, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder id(Long r100) {
            this.f253630id = r100;
            return this;
        }

        public Builder is_removed(Boolean r100) {
            this.is_removed = r100;
            this.team_data = null;
            return this;
        }

        public Builder team_data(TeamData r100) {
            this.team_data = r100;
            this.is_removed = null;
            return this;
        }

        public Builder version(Long r100) {
            this.version = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_NavigationView extends ProtoAdapter<NavigationView> {
        public ProtoAdapter_NavigationView() {
            super(FieldEncoding.LENGTH_DELIMITED, NavigationView.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public NavigationView decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f253630id = 0L;
            r101.version = 0L;
            r101.is_removed(Boolean.FALSE);
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.f253630id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.version = ProtoAdapter.INT64.decode(r100);
            goto L3
        L10:
            if (r103 != 50) goto L12;
            r101.is_removed(ProtoAdapter.BOOL.decode(r100));
            goto L3
        L12:
            if (r103 != 51) goto L13;
            r101.team_data(TeamData.ADAPTER.decode(r100));
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(NavigationView r100) {
            Long r101 = r100.f253629id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            Long r104 = r100.version;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Boolean r107 = r100.is_removed;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.BOOL.encodedSizeWithTag(50, r107);
        L14:
            int r109 = r106 + r108;
            TeamData r110 = r100.team_data;
            if (r110 == null) goto L18;
            r102 = TeamData.ADAPTER.encodedSizeWithTag(51, r110);
        L18:
            return (r109 + r102) + r100.unknownFields().size();
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ NavigationView decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(NavigationView r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, NavigationView r101) throws IOException {
            Long r102 = r101.f253629id;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            Long r103 = r101.version;
            if (r103 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
        L8:
            Boolean r104 = r101.is_removed;
            if (r104 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 50, r104);
        L11:
            TeamData r105 = r101.team_data;
            if (r105 == null) goto L14;
            TeamData.ADAPTER.encodeWithTag(r100, 51, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, NavigationView r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_NavigationView();
        FIELD_OPTIONS_IS_REMOVED = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        FIELD_OPTIONS_TEAM_DATA = new FieldOptions.Builder().debug(new Debug.Builder().build()).build();
        DEFAULT_ID = 0L;
        DEFAULT_VERSION = 0L;
        DEFAULT_IS_REMOVED = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f253630id = this.f253629id;
        r100.version = this.version;
        r100.is_removed = this.is_removed;
        r100.team_data = this.team_data;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return NavigationView.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public NavigationView(Long r100, Long r101, Boolean r102, TeamData r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public NavigationView(Long r100, Long r101, Boolean r102, TeamData r103, ByteString r104) {
        super(ADAPTER, r104);
        if (Internal.countNonNull(r102, r103) > 1) goto L7;
        this.f253629id = r100;
        this.version = r101;
        this.is_removed = r102;
        this.team_data = r103;
        return;
    L7:
        throw new IllegalArgumentException("at most one of is_removed, team_data may be non-null");
    }
}
