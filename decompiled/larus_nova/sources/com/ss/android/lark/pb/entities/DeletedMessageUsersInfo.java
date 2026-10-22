package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final class DeletedMessageUsersInfo extends com.squareup.wire.Message<DeletedMessageUsersInfo, Builder> {
    public static final ProtoAdapter<DeletedMessageUsersInfo> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<Long, Long> mDeletedMessageUserIDs2DelTime;
    public final StorageLocation mInfoStorageLocation;

    public static final class Builder extends com.squareup.wire.Message.Builder<DeletedMessageUsersInfo, Builder> {
        public Map<Long, Long> mDeletedMessageUserIDs2DelTime;
        public StorageLocation mInfoStorageLocation;

        @Override // com.squareup.wire.Message.Builder
        public DeletedMessageUsersInfo build() {
            return new DeletedMessageUsersInfo(this.mInfoStorageLocation, this.mDeletedMessageUserIDs2DelTime, super.buildUnknownFields());
        }

        public Builder() {
            this.mDeletedMessageUserIDs2DelTime = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder DeletedMessageUserIDs2DelTime(Map<Long, Long> r100) {
            Internal.checkElementsNotNull(r100);
            this.mDeletedMessageUserIDs2DelTime = r100;
            return this;
        }

        public Builder InfoStorageLocation(StorageLocation r100) {
            this.mInfoStorageLocation = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_DeletedMessageUsersInfo extends ProtoAdapter<DeletedMessageUsersInfo> {
        private final ProtoAdapter<Map<Long, Long>> mDeletedMessageUserIDs2DelTime;

        public ProtoAdapter_DeletedMessageUsersInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, DeletedMessageUsersInfo.class);
            ProtoAdapter<Long> r100 = ProtoAdapter.INT64;
            this.mDeletedMessageUserIDs2DelTime = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public DeletedMessageUsersInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.mInfoStorageLocation = StorageLocation.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.mDeletedMessageUserIDs2DelTime.putAll(this.mDeletedMessageUserIDs2DelTime.decode(r100));
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(DeletedMessageUsersInfo r100) {
            StorageLocation r101 = r100.mInfoStorageLocation;
            if (r101 == null) goto L5;
            int r102 = StorageLocation.ADAPTER.encodedSizeWithTag(1, r101);
        L7:
            return (r102 + this.mDeletedMessageUserIDs2DelTime.encodedSizeWithTag(2, r100.mDeletedMessageUserIDs2DelTime)) + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ DeletedMessageUsersInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(DeletedMessageUsersInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, DeletedMessageUsersInfo r101) throws IOException {
            StorageLocation r102 = r101.mInfoStorageLocation;
            if (r102 == null) goto L5;
            StorageLocation.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            this.mDeletedMessageUserIDs2DelTime.encodeWithTag(r100, 2, r101.mDeletedMessageUserIDs2DelTime);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DeletedMessageUsersInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum StorageLocation extends Enum<StorageLocation> implements WireEnum {
        private static final /* synthetic */ StorageLocation[] $VALUES = null;
        public static final ProtoAdapter<StorageLocation> ADAPTER = null;
        public static final StorageLocation STORAGE_IN_EXTERNAL = null;
        public static final StorageLocation STORAGE_IN_MYSQL_ENTITY = null;
        public static final StorageLocation UNKNOWN = null;
        private final int value;

        static {
            StorageLocation r100 = new StorageLocation("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            StorageLocation r101 = new StorageLocation("STORAGE_IN_EXTERNAL", 1, 1);
            STORAGE_IN_EXTERNAL = r101;
            StorageLocation r102 = new StorageLocation("STORAGE_IN_MYSQL_ENTITY", 2, 2);
            STORAGE_IN_MYSQL_ENTITY = r102;
            $VALUES = new StorageLocation[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(StorageLocation.class);
        }

        public static StorageLocation[] values() {
            return (StorageLocation[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static StorageLocation fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return STORAGE_IN_MYSQL_ENTITY;
        L12:
            return STORAGE_IN_EXTERNAL;
        L14:
            return UNKNOWN;
        }

        public static StorageLocation valueOf(String r100) {
            return (StorageLocation) a.a(StorageLocation.class, r100);
        }

        private StorageLocation(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_DeletedMessageUsersInfo();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mInfoStorageLocation = this.mInfoStorageLocation;
        r100.mDeletedMessageUserIDs2DelTime = Internal.copyOf("mDeletedMessageUserIDs2DelTime", this.mDeletedMessageUserIDs2DelTime);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return DeletedMessageUsersInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public DeletedMessageUsersInfo(StorageLocation r100, Map<Long, Long> r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public DeletedMessageUsersInfo(StorageLocation r100, Map<Long, Long> r101, ByteString r102) {
        super(ADAPTER, r102);
        this.mInfoStorageLocation = r100;
        this.mDeletedMessageUserIDs2DelTime = Internal.immutableCopyOf("mDeletedMessageUserIDs2DelTime", r101);
    }
}
