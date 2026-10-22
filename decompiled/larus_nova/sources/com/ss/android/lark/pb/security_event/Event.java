package com.ss.android.lark.pb.security_event;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import com.ss.android.downloadad.api.model.NativeDownloadModel;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class Event extends Message<Event, Builder> {
    public static final ProtoAdapter<Event> ADAPTER = null;
    public static final String DEFAULT_BIZUNIQUEID = "";
    public static final String DEFAULT_TENANTID = "";
    public static final String DEFAULT_TIMESTAMP = "";
    private static final long serialVersionUID = 0;
    public final String mBizUniqueID;
    public final Env mEnv;
    public final Extend mExtend;
    public final ModuleType mModule;
    public final List<ObjectEntity> mObjects;
    public final OperationType mOperation;
    public final OperatorEntity mOperator;
    public final List<RecipientEntity> mRecipients;
    public final String mTenantID;
    public final String mTimeStamp;

    public static final class Builder extends Message.Builder<Event, Builder> {
        public String mBizUniqueID;
        public Env mEnv;
        public Extend mExtend;
        public ModuleType mModule;
        public List<ObjectEntity> mObjects;
        public OperationType mOperation;
        public OperatorEntity mOperator;
        public List<RecipientEntity> mRecipients;
        public String mTenantID;
        public String mTimeStamp;

        @Override // com.squareup.wire.Message.Builder
        public Event build() {
            ModuleType r100 = this.mModule;
            if (r100 == null) goto L13;
            if (this.mOperation == null) goto L13;
            if (this.mTimeStamp == null) goto L13;
            if (this.mOperator == null) goto L13;
            return new Event(this.mModule, this.mOperation, this.mTimeStamp, this.mTenantID, this.mOperator, this.mRecipients, this.mObjects, this.mEnv, this.mExtend, this.mBizUniqueID, super.buildUnknownFields());
        L13:
            throw Internal.missingRequiredFields(new Object[]{r100, "mModule", this.mOperation, "mOperation", this.mTimeStamp, NativeDownloadModel.JsonKey.TIME_STAMP, this.mOperator, "mOperator"});
        }

        public Builder() {
            this.mRecipients = Internal.newMutableList();
            this.mObjects = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder BizUniqueID(String r100) {
            this.mBizUniqueID = r100;
            return this;
        }

        public Builder Env(Env r100) {
            this.mEnv = r100;
            return this;
        }

        public Builder Extend(Extend r100) {
            this.mExtend = r100;
            return this;
        }

        public Builder Module(ModuleType r100) {
            this.mModule = r100;
            return this;
        }

        public Builder Objects(List<ObjectEntity> r100) {
            Internal.checkElementsNotNull(r100);
            this.mObjects = r100;
            return this;
        }

        public Builder Operation(OperationType r100) {
            this.mOperation = r100;
            return this;
        }

        public Builder Operator(OperatorEntity r100) {
            this.mOperator = r100;
            return this;
        }

        public Builder Recipients(List<RecipientEntity> r100) {
            Internal.checkElementsNotNull(r100);
            this.mRecipients = r100;
            return this;
        }

        public Builder TenantID(String r100) {
            this.mTenantID = r100;
            return this;
        }

        public Builder TimeStamp(String r100) {
            this.mTimeStamp = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_Event extends ProtoAdapter<Event> {
        public ProtoAdapter_Event() {
            super(FieldEncoding.LENGTH_DELIMITED, Event.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Event decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mTimeStamp = "";
            r101.mTenantID = "";
            r101.mBizUniqueID = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L23;
            switch(r103) {
                case 1: goto L25;
                case 2: goto L27;
                case 3: goto L14;
                case 4: goto L13;
                case 5: goto L12;
                case 6: goto L11;
                case 7: goto L10;
                case 8: goto L9;
                case 9: goto L8;
                case 10: goto L7;
                default: goto L6;
            };
        L25:
            r101.mModule = ModuleType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L21
        L21:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L27:
            r101.mOperation = OperationType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L17
        L17:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.mBizUniqueID = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            r101.mExtend = Extend.ADAPTER.decode(r100);
            goto L3
        L9:
            r101.mEnv = Env.ADAPTER.decode(r100);
            goto L3
        L10:
            r101.mObjects.add(ObjectEntity.ADAPTER.decode(r100));
            goto L3
        L11:
            r101.mRecipients.add(RecipientEntity.ADAPTER.decode(r100));
            goto L3
        L12:
            r101.mOperator = OperatorEntity.ADAPTER.decode(r100);
            goto L3
        L13:
            r101.mTenantID = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            r101.mTimeStamp = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L23:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(Event r100) {
            int r101 = ModuleType.ADAPTER.encodedSizeWithTag(1, r100.mModule) + OperationType.ADAPTER.encodedSizeWithTag(2, r100.mOperation);
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            int r103 = r101 + r102.encodedSizeWithTag(3, r100.mTimeStamp);
            String r104 = r100.mTenantID;
            int r105 = 0;
            if (r104 == null) goto L5;
            int r106 = r102.encodedSizeWithTag(4, r104);
        L6:
            int r107 = (((r103 + r106) + OperatorEntity.ADAPTER.encodedSizeWithTag(5, r100.mOperator)) + RecipientEntity.ADAPTER.asRepeated().encodedSizeWithTag(6, r100.mRecipients)) + ObjectEntity.ADAPTER.asRepeated().encodedSizeWithTag(7, r100.mObjects);
            Env r108 = r100.mEnv;
            if (r108 == null) goto L9;
            int r109 = Env.ADAPTER.encodedSizeWithTag(8, r108);
        L10:
            int r110 = r107 + r109;
            Extend r111 = r100.mExtend;
            if (r111 == null) goto L13;
            int r112 = Extend.ADAPTER.encodedSizeWithTag(9, r111);
        L14:
            int r113 = r110 + r112;
            String r114 = r100.mBizUniqueID;
            if (r114 == null) goto L18;
            r105 = r102.encodedSizeWithTag(10, r114);
        L18:
            return (r113 + r105) + r100.unknownFields().size();
        L13:
            r112 = 0;
            goto L14
        L9:
            r109 = 0;
            goto L10
        L5:
            r106 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Event decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Event r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, Event r101) throws IOException {
            ModuleType.ADAPTER.encodeWithTag(r100, 1, r101.mModule);
            OperationType.ADAPTER.encodeWithTag(r100, 2, r101.mOperation);
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 3, r101.mTimeStamp);
            String r103 = r101.mTenantID;
            if (r103 == null) goto L5;
            r102.encodeWithTag(r100, 4, r103);
        L5:
            OperatorEntity.ADAPTER.encodeWithTag(r100, 5, r101.mOperator);
            RecipientEntity.ADAPTER.asRepeated().encodeWithTag(r100, 6, r101.mRecipients);
            ObjectEntity.ADAPTER.asRepeated().encodeWithTag(r100, 7, r101.mObjects);
            Env r104 = r101.mEnv;
            if (r104 == null) goto L8;
            Env.ADAPTER.encodeWithTag(r100, 8, r104);
        L8:
            Extend r105 = r101.mExtend;
            if (r105 == null) goto L11;
            Extend.ADAPTER.encodeWithTag(r100, 9, r105);
        L11:
            String r106 = r101.mBizUniqueID;
            if (r106 == null) goto L14;
            r102.encodeWithTag(r100, 10, r106);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Event r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Event();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mModule = this.mModule;
        r100.mOperation = this.mOperation;
        r100.mTimeStamp = this.mTimeStamp;
        r100.mTenantID = this.mTenantID;
        r100.mOperator = this.mOperator;
        r100.mRecipients = Internal.copyOf("mRecipients", this.mRecipients);
        r100.mObjects = Internal.copyOf("mObjects", this.mObjects);
        r100.mEnv = this.mEnv;
        r100.mExtend = this.mExtend;
        r100.mBizUniqueID = this.mBizUniqueID;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return Event.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public Event(ModuleType r110, OperationType r111, String r112, String r113, OperatorEntity r114, List<RecipientEntity> r115, List<ObjectEntity> r116, Env r210, Extend r211, String r212) {
        this(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212, ByteString.EMPTY);
    }

    public Event(ModuleType r100, OperationType r101, String r102, String r103, OperatorEntity r104, List<RecipientEntity> r105, List<ObjectEntity> r106, Env r107, Extend r110, String r111, ByteString r112) {
        super(ADAPTER, r112);
        this.mModule = r100;
        this.mOperation = r101;
        this.mTimeStamp = r102;
        this.mTenantID = r103;
        this.mOperator = r104;
        this.mRecipients = Internal.immutableCopyOf("mRecipients", r105);
        this.mObjects = Internal.immutableCopyOf("mObjects", r106);
        this.mEnv = r107;
        this.mExtend = r110;
        this.mBizUniqueID = r111;
    }
}
