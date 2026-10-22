package com.bytedance.lark.pb.basic.v1;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class EmailSystemEvent extends com.squareup.wire.Message<EmailSystemEvent, Builder> {
    public static final ProtoAdapter<EmailSystemEvent> ADAPTER = null;
    public static final String DEFAULT_OPERATOR_ID = "";
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: cc, reason: collision with root package name */
    public final List<EmailMember> f253489cc;
    public final String operator_id;

    /* JADX INFO: renamed from: to, reason: collision with root package name */
    public final List<EmailMember> f253490to;

    public static final class Builder extends com.squareup.wire.Message.Builder<EmailSystemEvent, Builder> {

        /* JADX INFO: renamed from: cc, reason: collision with root package name */
        public List<EmailMember> f253491cc;
        public String operator_id;

        /* JADX INFO: renamed from: to, reason: collision with root package name */
        public List<EmailMember> f253492to;

        @Override // com.squareup.wire.Message.Builder
        public EmailSystemEvent build() {
            return new EmailSystemEvent(this.operator_id, this.f253492to, this.f253491cc, super.buildUnknownFields());
        }

        public Builder() {
            this.f253492to = Internal.newMutableList();
            this.f253491cc = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder cc(List<EmailMember> r100) {
            Internal.checkElementsNotNull(r100);
            this.f253491cc = r100;
            return this;
        }

        public Builder operator_id(String r100) {
            this.operator_id = r100;
            return this;
        }

        public Builder to(List<EmailMember> r100) {
            Internal.checkElementsNotNull(r100);
            this.f253492to = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_EmailSystemEvent extends ProtoAdapter<EmailSystemEvent> {
        public ProtoAdapter_EmailSystemEvent() {
            super(FieldEncoding.LENGTH_DELIMITED, EmailSystemEvent.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public EmailSystemEvent decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.operator_id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.operator_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.f253492to.add(EmailMember.ADAPTER.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.f253491cc.add(EmailMember.ADAPTER.decode(r100));
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
        public int encodedSize2(EmailSystemEvent r100) {
            String r101 = r100.operator_id;
            if (r101 == null) goto L5;
            int r102 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            ProtoAdapter<EmailMember> r103 = EmailMember.ADAPTER;
            return ((r102 + r103.asRepeated().encodedSizeWithTag(2, r100.f253490to)) + r103.asRepeated().encodedSizeWithTag(3, r100.f253489cc)) + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ EmailSystemEvent decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(EmailSystemEvent r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, EmailSystemEvent r101) throws IOException {
            String r102 = r101.operator_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            ProtoAdapter<EmailMember> r103 = EmailMember.ADAPTER;
            r103.asRepeated().encodeWithTag(r100, 2, r101.f253490to);
            r103.asRepeated().encodeWithTag(r100, 3, r101.f253489cc);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, EmailSystemEvent r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_EmailSystemEvent();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.operator_id = this.operator_id;
        r100.f253492to = Internal.copyOf(RemoteMessageConst.TO, this.f253490to);
        r100.f253491cc = Internal.copyOf("cc", this.f253489cc);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return EmailSystemEvent.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public EmailSystemEvent(String r100, List<EmailMember> r101, List<EmailMember> r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public EmailSystemEvent(String r100, List<EmailMember> r101, List<EmailMember> r102, ByteString r103) {
        super(ADAPTER, r103);
        this.operator_id = r100;
        this.f253490to = Internal.immutableCopyOf(RemoteMessageConst.TO, r101);
        this.f253489cc = Internal.immutableCopyOf("cc", r102);
    }
}
