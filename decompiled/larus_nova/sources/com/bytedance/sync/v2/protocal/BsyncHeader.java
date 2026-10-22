package com.bytedance.sync.v2.protocal;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes3.dex */
public final class BsyncHeader extends Message<BsyncHeader, Builder> {
    public static final ProtoAdapter<BsyncHeader> ADAPTER = null;
    public static final Ctrl DEFAULT_CTRL = null;
    public static final String DEFAULT_DID = "";
    public static final Long DEFAULT_TS = null;
    public static final String DEFAULT_UID = "";
    public static final Version DEFAULT_VERSION = null;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.bytedance.sync.v2.protocal.Ctrl#ADAPTER", tag = 5)
    public final Ctrl ctrl;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String did;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#BYTES", keyAdapter = "com.squareup.wire.ProtoAdapter#INT32", tag = 255)
    public final Map<Integer, ByteString> infos;

    /* JADX INFO: renamed from: ts, reason: collision with root package name */
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 4)
    public final Long f270527ts;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 2)
    public final String uid;

    @WireField(adapter = "com.bytedance.sync.v2.protocal.Version#ADAPTER", label = WireField.Label.REQUIRED, tag = 1)
    public final Version version;

    public static final class Builder extends Message.Builder<BsyncHeader, Builder> {
        public Ctrl ctrl;
        public String did;
        public Map<Integer, ByteString> infos;

        /* JADX INFO: renamed from: ts, reason: collision with root package name */
        public Long f270528ts;
        public String uid;
        public Version version;

        @Override // com.squareup.wire.Message.Builder
        public BsyncHeader build() {
            Version r100 = this.version;
            if (r100 == null) goto L7;
            return new BsyncHeader(this.version, this.uid, this.did, this.f270528ts, this.ctrl, this.infos, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "version"});
        }

        public Builder() {
            this.infos = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder ctrl(Ctrl r100) {
            this.ctrl = r100;
            return this;
        }

        public Builder did(String r100) {
            this.did = r100;
            return this;
        }

        public Builder infos(Map<Integer, ByteString> r100) {
            Internal.checkElementsNotNull(r100);
            this.infos = r100;
            return this;
        }

        public Builder ts(Long r100) {
            this.f270528ts = r100;
            return this;
        }

        public Builder uid(String r100) {
            this.uid = r100;
            return this;
        }

        public Builder version(Version r100) {
            this.version = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_BsyncHeader extends ProtoAdapter<BsyncHeader> {
        private final ProtoAdapter<Map<Integer, ByteString>> infos;

        public ProtoAdapter_BsyncHeader() {
            super(FieldEncoding.LENGTH_DELIMITED, BsyncHeader.class);
            this.infos = ProtoAdapter.newMapAdapter(ProtoAdapter.INT32, ProtoAdapter.BYTES);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public BsyncHeader decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L30;
            if (r103 != 1) goto L8;
            r101.version(Version.ADAPTER.decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L28
        L28:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.uid(ProtoAdapter.STRING.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.did(ProtoAdapter.STRING.decode(r100));
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.ts(ProtoAdapter.INT64.decode(r100));
            goto L3
        L14:
            if (r103 != 5) goto L16;
            r101.ctrl(Ctrl.ADAPTER.decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L21
        L21:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L16:
            if (r103 != 255) goto L17;
            r101.infos.putAll(this.infos.decode(r100));
            goto L3
        L17:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L30:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(BsyncHeader r100) {
            int r101 = Version.ADAPTER.encodedSizeWithTag(1, r100.version);
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            return (((((r101 + r102.encodedSizeWithTag(2, r100.uid)) + r102.encodedSizeWithTag(3, r100.did)) + ProtoAdapter.INT64.encodedSizeWithTag(4, r100.f270527ts)) + Ctrl.ADAPTER.encodedSizeWithTag(5, r100.ctrl)) + this.infos.encodedSizeWithTag(255, r100.infos)) + r100.unknownFields().size();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public BsyncHeader redact2(BsyncHeader r100) {
            Builder r101 = r100.newBuilder();
            r101.clearUnknownFields();
            return r101.build();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ BsyncHeader decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(BsyncHeader r100) {
            return encodedSize2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ BsyncHeader redact(BsyncHeader r100) {
            return redact2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, BsyncHeader r101) throws IOException {
            Version.ADAPTER.encodeWithTag(r100, 1, r101.version);
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 2, r101.uid);
            r102.encodeWithTag(r100, 3, r101.did);
            ProtoAdapter.INT64.encodeWithTag(r100, 4, r101.f270527ts);
            Ctrl.ADAPTER.encodeWithTag(r100, 5, r101.ctrl);
            this.infos.encodeWithTag(r100, 255, r101.infos);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, BsyncHeader r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_BsyncHeader();
        DEFAULT_VERSION = Version.Unknown;
        DEFAULT_TS = 0L;
        DEFAULT_CTRL = Ctrl.Default;
    }

    public int hashCode() {
        int r100 = this.hashCode;
        if (r100 != 0) goto L21;
        int r101 = ((unknownFields().hashCode() * 37) + this.version.hashCode()) * 37;
        String r102 = this.uid;
        int r103 = 0;
        if (r102 == null) goto L7;
        int r104 = r102.hashCode();
    L8:
        int r105 = (r101 + r104) * 37;
        String r106 = this.did;
        if (r106 == null) goto L11;
        int r107 = r106.hashCode();
    L12:
        int r108 = (r105 + r107) * 37;
        Long r109 = this.f270527ts;
        if (r109 == null) goto L15;
        int r110 = r109.hashCode();
    L16:
        int r111 = (r108 + r110) * 37;
        Ctrl r112 = this.ctrl;
        if (r112 == null) goto L19;
        r103 = r112.hashCode();
    L19:
        int r113 = ((r111 + r103) * 37) + this.infos.hashCode();
        this.hashCode = r113;
        return r113;
    L15:
        r110 = 0;
        goto L16
    L11:
        r107 = 0;
        goto L12
    L7:
        r104 = 0;
        goto L8
    L21:
        return r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.version = this.version;
        r100.uid = this.uid;
        r100.did = this.did;
        r100.f270528ts = this.f270527ts;
        r100.ctrl = this.ctrl;
        r100.infos = Internal.copyOf("infos", this.infos);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r100 = new StringBuilder();
        r100.append(", version=");
        r100.append(this.version);
        if (this.uid == null) goto L6;
        r100.append(", uid=");
        r100.append(this.uid);
    L6:
        if (this.did == null) goto L9;
        r100.append(", did=");
        r100.append(this.did);
    L9:
        if (this.f270527ts == null) goto L12;
        r100.append(", ts=");
        r100.append(this.f270527ts);
    L12:
        if (this.ctrl == null) goto L15;
        r100.append(", ctrl=");
        r100.append(this.ctrl);
    L15:
        if (this.infos.isEmpty() == true) goto L17;
        r100.append(", infos=");
        r100.append(this.infos);
    L17:
        StringBuilder r101 = r100.replace(0, 2, "BsyncHeader{");
        r101.append('}');
        return r101.toString();
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof BsyncHeader) == true) goto L8;
        return false;
    L8:
        BsyncHeader r101 = (BsyncHeader) r100;
        if (unknownFields().equals(r101.unknownFields()) == true) goto L11;
    L23:
        return false;
    L11:
        if (this.version.equals(r101.version) == false) goto L23;
        if (Internal.equals(this.uid, r101.uid) == false) goto L23;
        if (Internal.equals(this.did, r101.did) == false) goto L23;
        if (Internal.equals(this.f270527ts, r101.f270527ts) == false) goto L23;
        if (Internal.equals(this.ctrl, r101.ctrl) == false) goto L23;
        if (this.infos.equals(r101.infos) == false) goto L23;
        return true;
    }

    public BsyncHeader(Version r100, String r110, String r111, Long r112, Ctrl r113, Map<Integer, ByteString> r114) {
        this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
    }

    public BsyncHeader(Version r100, String r101, String r102, Long r103, Ctrl r104, Map<Integer, ByteString> r105, ByteString r106) {
        super(ADAPTER, r106);
        this.version = r100;
        this.uid = r101;
        this.did = r102;
        this.f270527ts = r103;
        this.ctrl = r104;
        this.infos = Internal.immutableCopyOf("infos", r105);
    }
}
