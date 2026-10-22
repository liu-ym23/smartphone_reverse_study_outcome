package com.bytedance.lark.pb.media.v1;

import com.bytedance.lark.pb.basic.v1.File;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;
import r27.a;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class UploadFilesRequest extends Message<UploadFilesRequest, Builder> {
    public static final ProtoAdapter<UploadFilesRequest> ADAPTER = null;
    public static final Action DEFAULT_ACTION = null;
    public static final File.EntityType DEFAULT_TYPE = null;
    public static final ProtoAdapter_UploadFilesRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Action action;
    public final List<String> cids;
    public final Map<String, String> key2paths;
    public final File.EntityType type;

    public static final enum Action extends Enum<Action> implements WireEnum {
        private static final /* synthetic */ Action[] $VALUES = null;
        public static final ProtoAdapter<Action> ADAPTER = null;
        public static final Action CANCEL = null;
        public static final Action UPLOAD = null;
        public final Boolean deprecated;
        private final int value;

        static {
            Action r100 = new Action("UPLOAD", 0, 1, Boolean.TRUE);
            UPLOAD = r100;
            Action r101 = new Action("CANCEL", 1, 2, null);
            CANCEL = r101;
            $VALUES = new Action[]{r100, r101};
            ADAPTER = ProtoAdapter.newEnumAdapter(Action.class);
        }

        public static Action[] values() {
            return (Action[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Action fromValue(int r100) {
            if (r100 == 1) goto L11;
            if (r100 == 2) goto L9;
            return null;
        L9:
            return CANCEL;
        L11:
            return UPLOAD;
        }

        public static Action valueOf(String r100) {
            return (Action) a.a(Action.class, r100);
        }

        private Action(String r100, int r101, int r102, Boolean r103) {
            super(r100, r101);
            this.value = r102;
            this.deprecated = r103;
        }
    }

    public static final class Builder extends Message.Builder<UploadFilesRequest, Builder> implements d<UploadFilesRequest> {
        public Action action;
        public List<String> cids;
        public Map<String, String> key2paths;
        public File.EntityType type;

        @Override // com.squareup.wire.Message.Builder
        public UploadFilesRequest build() {
            Action r100 = this.action;
            if (r100 == null) goto L9;
            if (this.type == null) goto L9;
            return new UploadFilesRequest(this.cids, this.key2paths, this.action, this.type, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "action", this.type, "type"});
        }

        public Builder() {
            this.cids = Internal.newMutableList();
            this.key2paths = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder action(Action r100) {
            this.action = r100;
            return this;
        }

        public Builder cids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.cids = r100;
            return this;
        }

        public Builder key2paths(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.key2paths = r100;
            return this;
        }

        public Builder type(File.EntityType r100) {
            this.type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_UploadFilesRequest extends ProtoAdapter<UploadFilesRequest> implements c<UploadFilesRequest> {
        private final ProtoAdapter<Map<String, String>> key2paths;

        public ProtoAdapter_UploadFilesRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, UploadFilesRequest.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.key2paths = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UploadFilesRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.action = Action.UPLOAD;
            r101.type = File.EntityType.MESSAGE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L24;
            if (r103 != 1) goto L8;
            r101.cids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.key2paths.putAll(this.key2paths.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.action = Action.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L20
        L20:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.type = File.EntityType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L24:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(UploadFilesRequest r100) {
            return (((ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r100.cids) + this.key2paths.encodedSizeWithTag(2, r100.key2paths)) + Action.ADAPTER.encodedSizeWithTag(3, r100.action)) + File.EntityType.ADAPTER.encodedSizeWithTag(4, r100.type)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UploadFilesRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UploadFilesRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UploadFilesRequest r101) throws IOException {
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 1, r101.cids);
            this.key2paths.encodeWithTag(r100, 2, r101.key2paths);
            Action.ADAPTER.encodeWithTag(r100, 3, r101.action);
            File.EntityType.ADAPTER.encodeWithTag(r100, 4, r101.type);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UploadFilesRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_UploadFilesRequest r100 = new ProtoAdapter_UploadFilesRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_ACTION = Action.UPLOAD;
        DEFAULT_TYPE = File.EntityType.MESSAGE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.cids = Internal.copyOf("cids", this.cids);
        r100.key2paths = Internal.copyOf("key2paths", this.key2paths);
        r100.action = this.action;
        r100.type = this.type;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UploadFilesRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UploadFilesRequest(List<String> r100, Map<String, String> r101, Action r102, File.EntityType r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public UploadFilesRequest(List<String> r100, Map<String, String> r101, Action r102, File.EntityType r103, ByteString r104) {
        super(ADAPTER, r104);
        this.cids = Internal.immutableCopyOf("cids", r100);
        this.key2paths = Internal.immutableCopyOf("key2paths", r101);
        this.action = r102;
        this.type = r103;
    }
}
