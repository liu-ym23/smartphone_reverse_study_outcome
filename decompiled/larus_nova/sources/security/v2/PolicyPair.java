package security.v2;

import annotation.OptionsExt;
import com.google.protobuf.MessageOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes41.dex */
public final class PolicyPair extends Message<PolicyPair, Builder> {
    public static final ProtoAdapter<PolicyPair> ADAPTER = null;
    public static final String DEFAULT_ID = "";
    public static final String DEFAULT_POLICY_SET_KEY = "";
    public static final String DEFAULT_VERSION = "";
    public static final MessageOptions MESSAGE_OPTIONS = null;
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f541674id;
    public final String policy_set_key;
    public final String version;

    public static final class Builder extends Message.Builder<PolicyPair, Builder> {

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f541675id;
        public String policy_set_key;
        public String version;

        @Override // com.squareup.wire.Message.Builder
        public PolicyPair build() {
            return new PolicyPair(this.f541675id, this.version, this.policy_set_key, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder id(String r100) {
            this.f541675id = r100;
            return this;
        }

        public Builder policy_set_key(String r100) {
            this.policy_set_key = r100;
            return this;
        }

        public Builder version(String r100) {
            this.version = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PolicyPair extends ProtoAdapter<PolicyPair> {
        public ProtoAdapter_PolicyPair() {
            super(FieldEncoding.LENGTH_DELIMITED, PolicyPair.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public PolicyPair decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f541675id = "";
            r101.version = "";
            r101.policy_set_key = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.f541675id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.version = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.policy_set_key = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(PolicyPair r100) {
            String r101 = r100.f541674id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.version;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.policy_set_key;
            if (r107 == null) goto L14;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            return (r106 + r102) + r100.unknownFields().size();
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PolicyPair decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PolicyPair r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PolicyPair r101) throws IOException {
            String r102 = r101.f541674id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.version;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.policy_set_key;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PolicyPair r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PolicyPair();
        MESSAGE_OPTIONS = new MessageOptions.Builder().message_options(new OptionsExt.Builder().serde(Boolean.TRUE).build()).build();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f541675id = this.f541674id;
        r100.version = this.version;
        r100.policy_set_key = this.policy_set_key;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PolicyPair.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PolicyPair(String r100, String r101, String r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public PolicyPair(String r100, String r101, String r102, ByteString r103) {
        super(ADAPTER, r103);
        this.f541674id = r100;
        this.version = r101;
        this.policy_set_key = r102;
    }
}
