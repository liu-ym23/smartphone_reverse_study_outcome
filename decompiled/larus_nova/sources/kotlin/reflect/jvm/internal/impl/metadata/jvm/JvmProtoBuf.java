package kotlin.reflect.jvm.internal.impl.metadata.jvm;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Internal;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;
import kotlin.reflect.jvm.internal.impl.protobuf.WireFormat;
import r27.a;

/* JADX INFO: loaded from: classes5.dex */
public final class JvmProtoBuf {
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Class, Integer> anonymousObjectOriginName = null;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Class, List<ProtoBuf.Property>> classLocalVariable = null;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Class, Integer> classModuleName = null;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Constructor, JvmMethodSignature> constructorSignature = null;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, Integer> flags = null;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Type, Boolean> isRaw = null;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Class, Integer> jvmClassFlags = null;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Function, Integer> lambdaClassOriginName = null;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Function, JvmMethodSignature> methodSignature = null;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Package, List<ProtoBuf.Property>> packageLocalVariable = null;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Package, Integer> packageModuleName = null;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Property, JvmPropertySignature> propertySignature = null;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.Type, List<ProtoBuf.Annotation>> typeAnnotation = null;
    public static final GeneratedMessageLite.GeneratedExtension<ProtoBuf.TypeParameter, List<ProtoBuf.Annotation>> typeParameterAnnotation = null;

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes42.dex */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class JvmFieldSignature extends GeneratedMessageLite implements JvmFieldSignatureOrBuilder {
        public static Parser<JvmFieldSignature> PARSER;
        private static final JvmFieldSignature defaultInstance = null;
        private int bitField0_;
        private int desc_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private final ByteString unknownFields;

        /* JADX INFO: loaded from: classes42.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<JvmFieldSignature, Builder> implements JvmFieldSignatureOrBuilder {
            private int bitField0_;
            private int desc_;
            private int name_;

            private void maybeForceBuilderInitialization() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            private static Builder create() {
                return new Builder();
            }

            public JvmFieldSignature buildPartial() {
                JvmFieldSignature r100 = new JvmFieldSignature(this, null);
                int r101 = this.bitField0_;
                int r102 = 1;
                if ((r101 & 1) == 1) goto L6;
                r102 = 0;
            L6:
                JvmFieldSignature.access$2702(r100, this.name_);
                if ((r101 & 2) != 2) goto L9;
                r102 = r102 | 2;
            L9:
                JvmFieldSignature.access$2802(r100, this.desc_);
                JvmFieldSignature.access$2902(r100, r102);
                return r100;
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            public static /* synthetic */ Builder access$2500() {
                return create();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public JvmFieldSignature build() {
                JvmFieldSignature r100 = buildPartial();
                if (r100.isInitialized() == false) goto L6;
                return r100;
            L6:
                throw AbstractMessageLite.Builder.newUninitializedMessageException(r100);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public JvmFieldSignature getDefaultInstanceForType() {
                return JvmFieldSignature.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo10730clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                return clone();
            }

            public Builder mergeFrom(JvmFieldSignature r100) {
                if (r100 != JvmFieldSignature.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r100.hasName() == false) goto L9;
                setName(r100.getName());
            L9:
                if (r100.hasDesc() == false) goto L11;
                setDesc(r100.getDesc());
            L11:
                setUnknownFields(getUnknownFields().concat(JvmFieldSignature.access$3000(r100)));
                return this;
            }

            public Builder setDesc(int r100) {
                this.bitField0_ |= 2;
                this.desc_ = r100;
                return this;
            }

            public Builder setName(int r100) {
                this.bitField0_ |= 1;
                this.name_ = r100;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r100) {
                return mergeFrom((JvmFieldSignature) r100);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
                JvmFieldSignature r102 = null;
                JvmFieldSignature r103 = JvmFieldSignature.PARSER.parsePartialFrom(r100, r101);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r103 == null) goto L6;
                mergeFrom(r103);
            L6:
                return this;
            L9:
                e = move-exception;
                JvmFieldSignature r104 = (JvmFieldSignature) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                throw e;     // Catch: Throwable -> L12
            L12:
                th = th;
                r102 = r104;
            L14:
                if (r102 == null) goto L16;
                mergeFrom(r102);
            L16:
                throw th;
            L7:
                th = th;
                goto L14
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
                return mergeFrom(r100, r101);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
                return mergeFrom(r100, r101);
            }
        }

        private void initFields() {
            this.name_ = 0;
            this.desc_ = 0;
        }

        static {
            PARSER = new AnonymousClass1();
            JvmFieldSignature r100 = new JvmFieldSignature(true);
            defaultInstance = r100;
            r100.initFields();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int r100 = this.memoizedSerializedSize;
            if (r100 == (-1)) goto L5;
            return r100;
        L5:
            int r101 = 0;
            if ((this.bitField0_ & 1) != 1) goto L9;
            r101 = 0 + CodedOutputStream.computeInt32Size(1, this.name_);
        L9:
            if ((this.bitField0_ & 2) != 2) goto L11;
            r101 = r101 + CodedOutputStream.computeInt32Size(2, this.desc_);
        L11:
            int r102 = r101 + this.unknownFields.size();
            this.memoizedSerializedSize = r102;
            return r102;
        }

        public boolean hasDesc() {
            if ((this.bitField0_ & 2) != 2) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasName() {
            if ((this.bitField0_ & 1) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte r100 = this.memoizedIsInitialized;
            if (r100 != 1) goto L5;
            return true;
        L5:
            if (r100 != 0) goto L8;
            return false;
        L8:
            this.memoizedIsInitialized = 1;
            return true;
        }

        public static Builder newBuilder() {
            return Builder.access$2500();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        public static JvmFieldSignature getDefaultInstance() {
            return defaultInstance;
        }

        public int getDesc() {
            return this.desc_;
        }

        public int getName() {
            return this.name_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<JvmFieldSignature> getParserForType() {
            return PARSER;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public JvmFieldSignature getDefaultInstanceForType() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        private JvmFieldSignature(GeneratedMessageLite.Builder r100) {
            super(r100);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r100.getUnknownFields();
        }

        public static /* synthetic */ ByteString access$3000(JvmFieldSignature r100) {
            return r100.unknownFields;
        }

        public static Builder newBuilder(JvmFieldSignature r100) {
            return newBuilder().mergeFrom(r100);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r100) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) != 1) goto L6;
            r100.writeInt32(1, this.name_);
        L6:
            if ((this.bitField0_ & 2) != 2) goto L8;
            r100.writeInt32(2, this.desc_);
        L8:
            r100.writeRawBytes(this.unknownFields);
        }

        private JvmFieldSignature(boolean r100) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        private JvmFieldSignature(CodedInputStream r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r102 = ByteString.newOutput();
            CodedOutputStream r103 = CodedOutputStream.newInstance(r102, 1);
            boolean r104 = false;
        L3:
            if (r104 == true) goto L43;
            int r105 = r100.readTag();     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
            if (r105 == 0) goto L16;
            if (r105 != 8) goto L9;
            this.bitField0_ |= 1;     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
            this.name_ = r100.readInt32();     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
            goto L3
        L9:
            if (r105 != 16) goto L11;
            this.bitField0_ |= 2;     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
            this.desc_ = r100.readInt32();     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
            goto L3
        L11:
            if (parseUnknownField(r100, r103, r101, r105) == true) goto L3;
        L16:
            r104 = true;
            goto L3
        L17:
            th = move-exception;
            r103.flush();     // Catch: IOException -> L39 Throwable -> L27
        L27:
            th = move-exception;
            this.unknownFields = r102.toByteString();
            throw th;
        L26:
            this.unknownFields = r102.toByteString();
            makeExtensionsImmutable();
            throw th;
        L22:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L17
        L19:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L17
        L43:
            r103.flush();     // Catch: IOException -> L40 Throwable -> L34
        L34:
            th = move-exception;
            this.unknownFields = r102.toByteString();
            throw th;
        L33:
            this.unknownFields = r102.toByteString();
            makeExtensionsImmutable();
        }

        public static /* synthetic */ int access$2702(JvmFieldSignature r100, int r101) {
            r100.name_ = r101;
            return r101;
        }

        public static /* synthetic */ int access$2802(JvmFieldSignature r100, int r101) {
            r100.desc_ = r101;
            return r101;
        }

        public static /* synthetic */ int access$2902(JvmFieldSignature r100, int r101) {
            r100.bitField0_ = r101;
            return r101;
        }

        public /* synthetic */ JvmFieldSignature(GeneratedMessageLite.Builder r100, AnonymousClass1 r101) {
            this(r100);
        }

        public /* synthetic */ JvmFieldSignature(CodedInputStream r100, ExtensionRegistryLite r101, AnonymousClass1 r102) throws InvalidProtocolBufferException {
            this(r100, r101);
        }
    }

    public interface JvmFieldSignatureOrBuilder extends MessageLiteOrBuilder {
    }

    public static final class JvmMethodSignature extends GeneratedMessageLite implements JvmMethodSignatureOrBuilder {
        public static Parser<JvmMethodSignature> PARSER;
        private static final JvmMethodSignature defaultInstance = null;
        private int bitField0_;
        private int desc_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private final ByteString unknownFields;

        public static final class Builder extends GeneratedMessageLite.Builder<JvmMethodSignature, Builder> implements JvmMethodSignatureOrBuilder {
            private int bitField0_;
            private int desc_;
            private int name_;

            private void maybeForceBuilderInitialization() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            private static Builder create() {
                return new Builder();
            }

            public JvmMethodSignature buildPartial() {
                JvmMethodSignature r100 = new JvmMethodSignature(this, null);
                int r101 = this.bitField0_;
                int r102 = 1;
                if ((r101 & 1) == 1) goto L6;
                r102 = 0;
            L6:
                JvmMethodSignature.access$2002(r100, this.name_);
                if ((r101 & 2) != 2) goto L9;
                r102 = r102 | 2;
            L9:
                JvmMethodSignature.access$2102(r100, this.desc_);
                JvmMethodSignature.access$2202(r100, r102);
                return r100;
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            public static /* synthetic */ Builder access$1800() {
                return create();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public JvmMethodSignature build() {
                JvmMethodSignature r100 = buildPartial();
                if (r100.isInitialized() == false) goto L6;
                return r100;
            L6:
                throw AbstractMessageLite.Builder.newUninitializedMessageException(r100);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public JvmMethodSignature getDefaultInstanceForType() {
                return JvmMethodSignature.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo10730clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                return clone();
            }

            public Builder mergeFrom(JvmMethodSignature r100) {
                if (r100 != JvmMethodSignature.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r100.hasName() == false) goto L9;
                setName(r100.getName());
            L9:
                if (r100.hasDesc() == false) goto L11;
                setDesc(r100.getDesc());
            L11:
                setUnknownFields(getUnknownFields().concat(JvmMethodSignature.access$2300(r100)));
                return this;
            }

            public Builder setDesc(int r100) {
                this.bitField0_ |= 2;
                this.desc_ = r100;
                return this;
            }

            public Builder setName(int r100) {
                this.bitField0_ |= 1;
                this.name_ = r100;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r100) {
                return mergeFrom((JvmMethodSignature) r100);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
                JvmMethodSignature r102 = null;
                JvmMethodSignature r103 = JvmMethodSignature.PARSER.parsePartialFrom(r100, r101);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r103 == null) goto L6;
                mergeFrom(r103);
            L6:
                return this;
            L9:
                e = move-exception;
                JvmMethodSignature r104 = (JvmMethodSignature) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                throw e;     // Catch: Throwable -> L12
            L12:
                th = th;
                r102 = r104;
            L14:
                if (r102 == null) goto L16;
                mergeFrom(r102);
            L16:
                throw th;
            L7:
                th = th;
                goto L14
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
                return mergeFrom(r100, r101);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
                return mergeFrom(r100, r101);
            }
        }

        private void initFields() {
            this.name_ = 0;
            this.desc_ = 0;
        }

        static {
            PARSER = new AnonymousClass1();
            JvmMethodSignature r100 = new JvmMethodSignature(true);
            defaultInstance = r100;
            r100.initFields();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int r100 = this.memoizedSerializedSize;
            if (r100 == (-1)) goto L5;
            return r100;
        L5:
            int r101 = 0;
            if ((this.bitField0_ & 1) != 1) goto L9;
            r101 = 0 + CodedOutputStream.computeInt32Size(1, this.name_);
        L9:
            if ((this.bitField0_ & 2) != 2) goto L11;
            r101 = r101 + CodedOutputStream.computeInt32Size(2, this.desc_);
        L11:
            int r102 = r101 + this.unknownFields.size();
            this.memoizedSerializedSize = r102;
            return r102;
        }

        public boolean hasDesc() {
            if ((this.bitField0_ & 2) != 2) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasName() {
            if ((this.bitField0_ & 1) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte r100 = this.memoizedIsInitialized;
            if (r100 != 1) goto L5;
            return true;
        L5:
            if (r100 != 0) goto L8;
            return false;
        L8:
            this.memoizedIsInitialized = 1;
            return true;
        }

        public static Builder newBuilder() {
            return Builder.access$1800();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        public static JvmMethodSignature getDefaultInstance() {
            return defaultInstance;
        }

        public int getDesc() {
            return this.desc_;
        }

        public int getName() {
            return this.name_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<JvmMethodSignature> getParserForType() {
            return PARSER;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public JvmMethodSignature getDefaultInstanceForType() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        private JvmMethodSignature(GeneratedMessageLite.Builder r100) {
            super(r100);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r100.getUnknownFields();
        }

        public static /* synthetic */ ByteString access$2300(JvmMethodSignature r100) {
            return r100.unknownFields;
        }

        public static Builder newBuilder(JvmMethodSignature r100) {
            return newBuilder().mergeFrom(r100);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r100) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) != 1) goto L6;
            r100.writeInt32(1, this.name_);
        L6:
            if ((this.bitField0_ & 2) != 2) goto L8;
            r100.writeInt32(2, this.desc_);
        L8:
            r100.writeRawBytes(this.unknownFields);
        }

        private JvmMethodSignature(boolean r100) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        private JvmMethodSignature(CodedInputStream r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r102 = ByteString.newOutput();
            CodedOutputStream r103 = CodedOutputStream.newInstance(r102, 1);
            boolean r104 = false;
        L3:
            if (r104 == true) goto L43;
            int r105 = r100.readTag();     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
            if (r105 == 0) goto L16;
            if (r105 != 8) goto L9;
            this.bitField0_ |= 1;     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
            this.name_ = r100.readInt32();     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
            goto L3
        L9:
            if (r105 != 16) goto L11;
            this.bitField0_ |= 2;     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
            this.desc_ = r100.readInt32();     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
            goto L3
        L11:
            if (parseUnknownField(r100, r103, r101, r105) == true) goto L3;
        L16:
            r104 = true;
            goto L3
        L17:
            th = move-exception;
            r103.flush();     // Catch: IOException -> L39 Throwable -> L27
        L27:
            th = move-exception;
            this.unknownFields = r102.toByteString();
            throw th;
        L26:
            this.unknownFields = r102.toByteString();
            makeExtensionsImmutable();
            throw th;
        L22:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L17
        L19:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L17
        L43:
            r103.flush();     // Catch: IOException -> L40 Throwable -> L34
        L34:
            th = move-exception;
            this.unknownFields = r102.toByteString();
            throw th;
        L33:
            this.unknownFields = r102.toByteString();
            makeExtensionsImmutable();
        }

        public static /* synthetic */ int access$2002(JvmMethodSignature r100, int r101) {
            r100.name_ = r101;
            return r101;
        }

        public static /* synthetic */ int access$2102(JvmMethodSignature r100, int r101) {
            r100.desc_ = r101;
            return r101;
        }

        public static /* synthetic */ int access$2202(JvmMethodSignature r100, int r101) {
            r100.bitField0_ = r101;
            return r101;
        }

        public /* synthetic */ JvmMethodSignature(GeneratedMessageLite.Builder r100, AnonymousClass1 r101) {
            this(r100);
        }

        public /* synthetic */ JvmMethodSignature(CodedInputStream r100, ExtensionRegistryLite r101, AnonymousClass1 r102) throws InvalidProtocolBufferException {
            this(r100, r101);
        }
    }

    public interface JvmMethodSignatureOrBuilder extends MessageLiteOrBuilder {
    }

    public static final class JvmPropertySignature extends GeneratedMessageLite implements JvmPropertySignatureOrBuilder {
        public static Parser<JvmPropertySignature> PARSER;
        private static final JvmPropertySignature defaultInstance = null;
        private int bitField0_;
        private JvmMethodSignature delegateMethod_;
        private JvmFieldSignature field_;
        private JvmMethodSignature getter_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private JvmMethodSignature setter_;
        private JvmMethodSignature syntheticMethod_;
        private final ByteString unknownFields;

        public static final class Builder extends GeneratedMessageLite.Builder<JvmPropertySignature, Builder> implements JvmPropertySignatureOrBuilder {
            private int bitField0_;
            private JvmMethodSignature delegateMethod_;
            private JvmFieldSignature field_;
            private JvmMethodSignature getter_;
            private JvmMethodSignature setter_;
            private JvmMethodSignature syntheticMethod_;

            private void maybeForceBuilderInitialization() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            private static Builder create() {
                return new Builder();
            }

            public JvmPropertySignature buildPartial() {
                JvmPropertySignature r100 = new JvmPropertySignature(this, null);
                int r101 = this.bitField0_;
                int r102 = 1;
                if ((r101 & 1) == 1) goto L6;
                r102 = 0;
            L6:
                JvmPropertySignature.access$3402(r100, this.field_);
                if ((r101 & 2) != 2) goto L9;
                r102 = r102 | 2;
            L9:
                JvmPropertySignature.access$3502(r100, this.syntheticMethod_);
                if ((r101 & 4) != 4) goto L12;
                r102 = r102 | 4;
            L12:
                JvmPropertySignature.access$3602(r100, this.getter_);
                if ((r101 & 8) != 8) goto L15;
                r102 = r102 | 8;
            L15:
                JvmPropertySignature.access$3702(r100, this.setter_);
                if ((r101 & 16) != 16) goto L18;
                r102 = r102 | 16;
            L18:
                JvmPropertySignature.access$3802(r100, this.delegateMethod_);
                JvmPropertySignature.access$3902(r100, r102);
                return r100;
            }

            private Builder() {
                this.field_ = JvmFieldSignature.getDefaultInstance();
                this.syntheticMethod_ = JvmMethodSignature.getDefaultInstance();
                this.getter_ = JvmMethodSignature.getDefaultInstance();
                this.setter_ = JvmMethodSignature.getDefaultInstance();
                this.delegateMethod_ = JvmMethodSignature.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            public static /* synthetic */ Builder access$3200() {
                return create();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public JvmPropertySignature build() {
                JvmPropertySignature r100 = buildPartial();
                if (r100.isInitialized() == false) goto L6;
                return r100;
            L6:
                throw AbstractMessageLite.Builder.newUninitializedMessageException(r100);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public JvmPropertySignature getDefaultInstanceForType() {
                return JvmPropertySignature.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo10730clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                return clone();
            }

            public Builder mergeDelegateMethod(JvmMethodSignature r100) {
                if ((this.bitField0_ & 16) == 16) goto L5;
            L7:
                this.delegateMethod_ = r100;
            L8:
                this.bitField0_ |= 16;
                return this;
            L5:
                if (this.delegateMethod_ == JvmMethodSignature.getDefaultInstance()) goto L7;
                this.delegateMethod_ = JvmMethodSignature.newBuilder(this.delegateMethod_).mergeFrom(r100).buildPartial();
                goto L8
            }

            public Builder mergeField(JvmFieldSignature r100) {
                if ((this.bitField0_ & 1) == 1) goto L5;
            L7:
                this.field_ = r100;
            L8:
                this.bitField0_ |= 1;
                return this;
            L5:
                if (this.field_ == JvmFieldSignature.getDefaultInstance()) goto L7;
                this.field_ = JvmFieldSignature.newBuilder(this.field_).mergeFrom(r100).buildPartial();
                goto L8
            }

            public Builder mergeFrom(JvmPropertySignature r100) {
                if (r100 != JvmPropertySignature.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r100.hasField() == false) goto L9;
                mergeField(r100.getField());
            L9:
                if (r100.hasSyntheticMethod() == false) goto L12;
                mergeSyntheticMethod(r100.getSyntheticMethod());
            L12:
                if (r100.hasGetter() == false) goto L15;
                mergeGetter(r100.getGetter());
            L15:
                if (r100.hasSetter() == false) goto L18;
                mergeSetter(r100.getSetter());
            L18:
                if (r100.hasDelegateMethod() == false) goto L20;
                mergeDelegateMethod(r100.getDelegateMethod());
            L20:
                setUnknownFields(getUnknownFields().concat(JvmPropertySignature.access$4000(r100)));
                return this;
            }

            public Builder mergeGetter(JvmMethodSignature r100) {
                if ((this.bitField0_ & 4) == 4) goto L5;
            L7:
                this.getter_ = r100;
            L8:
                this.bitField0_ |= 4;
                return this;
            L5:
                if (this.getter_ == JvmMethodSignature.getDefaultInstance()) goto L7;
                this.getter_ = JvmMethodSignature.newBuilder(this.getter_).mergeFrom(r100).buildPartial();
                goto L8
            }

            public Builder mergeSetter(JvmMethodSignature r100) {
                if ((this.bitField0_ & 8) == 8) goto L5;
            L7:
                this.setter_ = r100;
            L8:
                this.bitField0_ |= 8;
                return this;
            L5:
                if (this.setter_ == JvmMethodSignature.getDefaultInstance()) goto L7;
                this.setter_ = JvmMethodSignature.newBuilder(this.setter_).mergeFrom(r100).buildPartial();
                goto L8
            }

            public Builder mergeSyntheticMethod(JvmMethodSignature r100) {
                if ((this.bitField0_ & 2) == 2) goto L5;
            L7:
                this.syntheticMethod_ = r100;
            L8:
                this.bitField0_ |= 2;
                return this;
            L5:
                if (this.syntheticMethod_ == JvmMethodSignature.getDefaultInstance()) goto L7;
                this.syntheticMethod_ = JvmMethodSignature.newBuilder(this.syntheticMethod_).mergeFrom(r100).buildPartial();
                goto L8
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r100) {
                return mergeFrom((JvmPropertySignature) r100);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
                JvmPropertySignature r102 = null;
                JvmPropertySignature r103 = JvmPropertySignature.PARSER.parsePartialFrom(r100, r101);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r103 == null) goto L6;
                mergeFrom(r103);
            L6:
                return this;
            L9:
                e = move-exception;
                JvmPropertySignature r104 = (JvmPropertySignature) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                throw e;     // Catch: Throwable -> L12
            L12:
                th = th;
                r102 = r104;
            L14:
                if (r102 == null) goto L16;
                mergeFrom(r102);
            L16:
                throw th;
            L7:
                th = th;
                goto L14
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
                return mergeFrom(r100, r101);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
                return mergeFrom(r100, r101);
            }
        }

        static {
            PARSER = new AnonymousClass1();
            JvmPropertySignature r100 = new JvmPropertySignature(true);
            defaultInstance = r100;
            r100.initFields();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int r100 = this.memoizedSerializedSize;
            if (r100 == (-1)) goto L5;
            return r100;
        L5:
            int r101 = 0;
            if ((this.bitField0_ & 1) != 1) goto L9;
            r101 = 0 + CodedOutputStream.computeMessageSize(1, this.field_);
        L9:
            if ((this.bitField0_ & 2) != 2) goto L12;
            r101 = r101 + CodedOutputStream.computeMessageSize(2, this.syntheticMethod_);
        L12:
            if ((this.bitField0_ & 4) != 4) goto L15;
            r101 = r101 + CodedOutputStream.computeMessageSize(3, this.getter_);
        L15:
            if ((this.bitField0_ & 8) != 8) goto L18;
            r101 = r101 + CodedOutputStream.computeMessageSize(4, this.setter_);
        L18:
            if ((this.bitField0_ & 16) != 16) goto L20;
            r101 = r101 + CodedOutputStream.computeMessageSize(5, this.delegateMethod_);
        L20:
            int r102 = r101 + this.unknownFields.size();
            this.memoizedSerializedSize = r102;
            return r102;
        }

        public boolean hasDelegateMethod() {
            if ((this.bitField0_ & 16) != 16) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasField() {
            if ((this.bitField0_ & 1) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        public boolean hasGetter() {
            if ((this.bitField0_ & 4) != 4) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasSetter() {
            if ((this.bitField0_ & 8) != 8) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasSyntheticMethod() {
            if ((this.bitField0_ & 2) != 2) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte r100 = this.memoizedIsInitialized;
            if (r100 != 1) goto L5;
            return true;
        L5:
            if (r100 != 0) goto L8;
            return false;
        L8:
            this.memoizedIsInitialized = 1;
            return true;
        }

        private void initFields() {
            this.field_ = JvmFieldSignature.getDefaultInstance();
            this.syntheticMethod_ = JvmMethodSignature.getDefaultInstance();
            this.getter_ = JvmMethodSignature.getDefaultInstance();
            this.setter_ = JvmMethodSignature.getDefaultInstance();
            this.delegateMethod_ = JvmMethodSignature.getDefaultInstance();
        }

        public static Builder newBuilder() {
            return Builder.access$3200();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        public static JvmPropertySignature getDefaultInstance() {
            return defaultInstance;
        }

        public JvmMethodSignature getDelegateMethod() {
            return this.delegateMethod_;
        }

        public JvmFieldSignature getField() {
            return this.field_;
        }

        public JvmMethodSignature getGetter() {
            return this.getter_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<JvmPropertySignature> getParserForType() {
            return PARSER;
        }

        public JvmMethodSignature getSetter() {
            return this.setter_;
        }

        public JvmMethodSignature getSyntheticMethod() {
            return this.syntheticMethod_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public JvmPropertySignature getDefaultInstanceForType() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        private JvmPropertySignature(GeneratedMessageLite.Builder r100) {
            super(r100);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r100.getUnknownFields();
        }

        public static /* synthetic */ ByteString access$4000(JvmPropertySignature r100) {
            return r100.unknownFields;
        }

        public static Builder newBuilder(JvmPropertySignature r100) {
            return newBuilder().mergeFrom(r100);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r100) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) != 1) goto L6;
            r100.writeMessage(1, this.field_);
        L6:
            if ((this.bitField0_ & 2) != 2) goto L9;
            r100.writeMessage(2, this.syntheticMethod_);
        L9:
            if ((this.bitField0_ & 4) != 4) goto L12;
            r100.writeMessage(3, this.getter_);
        L12:
            if ((this.bitField0_ & 8) != 8) goto L15;
            r100.writeMessage(4, this.setter_);
        L15:
            if ((this.bitField0_ & 16) != 16) goto L17;
            r100.writeMessage(5, this.delegateMethod_);
        L17:
            r100.writeRawBytes(this.unknownFields);
        }

        private JvmPropertySignature(boolean r100) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        private JvmPropertySignature(CodedInputStream r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r102 = ByteString.newOutput();
            CodedOutputStream r103 = CodedOutputStream.newInstance(r102, 1);
            boolean r104 = false;
        L3:
            if (r104 == true) goto L84;
            int r105 = r100.readTag();     // Catch: Throwable -> L56 IOException -> L58 InvalidProtocolBufferException -> L61
            if (r105 == 0) goto L55;
            JvmMethodSignature.Builder r106 = null;
            JvmFieldSignature.Builder r107 = null;
            JvmMethodSignature.Builder r108 = null;
            JvmMethodSignature.Builder r109 = null;
            JvmMethodSignature.Builder r110 = null;
            if (r105 != 10) goto L9;
            if ((this.bitField0_ & 1) != 1) goto L50;
            r107 = this.field_.toBuilder();     // Catch: Throwable -> L56 IOException -> L58 InvalidProtocolBufferException -> L61
        L50:
            JvmFieldSignature r111 = (JvmFieldSignature) r100.readMessage(JvmFieldSignature.PARSER, r101);     // Catch: Throwable -> L56 IOException -> L58 InvalidProtocolBufferException -> L61
            this.field_ = r111;     // Catch: Throwable -> L56 IOException -> L58 InvalidProtocolBufferException -> L61
            if (r107 == null) goto L53;
            r107.mergeFrom(r111);     // Catch: Throwable -> L56 IOException -> L58 InvalidProtocolBufferException -> L61
            this.field_ = r107.buildPartial();     // Catch: Throwable -> L56 IOException -> L58 InvalidProtocolBufferException -> L61
        L53:
            this.bitField0_ |= 1;     // Catch: Throwable -> L56 IOException -> L58 InvalidProtocolBufferException -> L61
            goto L3
        L9:
            if (r105 != 18) goto L11;
            if ((this.bitField0_ & 2) != 2) goto L43;
            r108 = this.syntheticMethod_.toBuilder();     // Catch: Throwable -> L56 IOException -> L58 InvalidProtocolBufferException -> L61
        L43:
            JvmMethodSignature r112 = (JvmMethodSignature) r100.readMessage(JvmMethodSignature.PARSER, r101);     // Catch: Throwable -> L56 IOException -> L58 InvalidProtocolBufferException -> L61
            this.syntheticMethod_ = r112;     // Catch: Throwable -> L56 IOException -> L58 InvalidProtocolBufferException -> L61
            if (r108 == null) goto L46;
            r108.mergeFrom(r112);     // Catch: Throwable -> L56 IOException -> L58 InvalidProtocolBufferException -> L61
            this.syntheticMethod_ = r108.buildPartial();     // Catch: Throwable -> L56 IOException -> L58 InvalidProtocolBufferException -> L61
        L46:
            this.bitField0_ |= 2;     // Catch: Throwable -> L56 IOException -> L58 InvalidProtocolBufferException -> L61
            goto L3
        L11:
            if (r105 != 26) goto L13;
            if ((this.bitField0_ & 4) != 4) goto L36;
            r109 = this.getter_.toBuilder();     // Catch: Throwable -> L56 IOException -> L58 InvalidProtocolBufferException -> L61
        L36:
            JvmMethodSignature r113 = (JvmMethodSignature) r100.readMessage(JvmMethodSignature.PARSER, r101);     // Catch: Throwable -> L56 IOException -> L58 InvalidProtocolBufferException -> L61
            this.getter_ = r113;     // Catch: Throwable -> L56 IOException -> L58 InvalidProtocolBufferException -> L61
            if (r109 == null) goto L39;
            r109.mergeFrom(r113);     // Catch: Throwable -> L56 IOException -> L58 InvalidProtocolBufferException -> L61
            this.getter_ = r109.buildPartial();     // Catch: Throwable -> L56 IOException -> L58 InvalidProtocolBufferException -> L61
        L39:
            this.bitField0_ |= 4;     // Catch: Throwable -> L56 IOException -> L58 InvalidProtocolBufferException -> L61
            goto L3
        L13:
            if (r105 != 34) goto L15;
            if ((this.bitField0_ & 8) != 8) goto L29;
            r110 = this.setter_.toBuilder();     // Catch: Throwable -> L56 IOException -> L58 InvalidProtocolBufferException -> L61
        L29:
            JvmMethodSignature r114 = (JvmMethodSignature) r100.readMessage(JvmMethodSignature.PARSER, r101);     // Catch: Throwable -> L56 IOException -> L58 InvalidProtocolBufferException -> L61
            this.setter_ = r114;     // Catch: Throwable -> L56 IOException -> L58 InvalidProtocolBufferException -> L61
            if (r110 == null) goto L32;
            r110.mergeFrom(r114);     // Catch: Throwable -> L56 IOException -> L58 InvalidProtocolBufferException -> L61
            this.setter_ = r110.buildPartial();     // Catch: Throwable -> L56 IOException -> L58 InvalidProtocolBufferException -> L61
        L32:
            this.bitField0_ |= 8;     // Catch: Throwable -> L56 IOException -> L58 InvalidProtocolBufferException -> L61
            goto L3
        L15:
            if (r105 != 42) goto L17;
            if ((this.bitField0_ & 16) != 16) goto L22;
            r106 = this.delegateMethod_.toBuilder();     // Catch: Throwable -> L56 IOException -> L58 InvalidProtocolBufferException -> L61
        L22:
            JvmMethodSignature r115 = (JvmMethodSignature) r100.readMessage(JvmMethodSignature.PARSER, r101);     // Catch: Throwable -> L56 IOException -> L58 InvalidProtocolBufferException -> L61
            this.delegateMethod_ = r115;     // Catch: Throwable -> L56 IOException -> L58 InvalidProtocolBufferException -> L61
            if (r106 == null) goto L25;
            r106.mergeFrom(r115);     // Catch: Throwable -> L56 IOException -> L58 InvalidProtocolBufferException -> L61
            this.delegateMethod_ = r106.buildPartial();     // Catch: Throwable -> L56 IOException -> L58 InvalidProtocolBufferException -> L61
        L25:
            this.bitField0_ |= 16;     // Catch: Throwable -> L56 IOException -> L58 InvalidProtocolBufferException -> L61
            goto L3
        L17:
            if (parseUnknownField(r100, r103, r101, r105) == true) goto L3;
        L55:
            r104 = true;
            goto L3
        L56:
            th = move-exception;
            r103.flush();     // Catch: IOException -> L78 Throwable -> L66
        L66:
            th = move-exception;
            this.unknownFields = r102.toByteString();
            throw th;
        L65:
            this.unknownFields = r102.toByteString();
            makeExtensionsImmutable();
            throw th;
        L61:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L56
        L58:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L56
        L84:
            r103.flush();     // Catch: IOException -> L79 Throwable -> L73
        L73:
            th = move-exception;
            this.unknownFields = r102.toByteString();
            throw th;
        L72:
            this.unknownFields = r102.toByteString();
            makeExtensionsImmutable();
        }

        public static /* synthetic */ JvmFieldSignature access$3402(JvmPropertySignature r100, JvmFieldSignature r101) {
            r100.field_ = r101;
            return r101;
        }

        public static /* synthetic */ JvmMethodSignature access$3502(JvmPropertySignature r100, JvmMethodSignature r101) {
            r100.syntheticMethod_ = r101;
            return r101;
        }

        public static /* synthetic */ JvmMethodSignature access$3602(JvmPropertySignature r100, JvmMethodSignature r101) {
            r100.getter_ = r101;
            return r101;
        }

        public static /* synthetic */ JvmMethodSignature access$3702(JvmPropertySignature r100, JvmMethodSignature r101) {
            r100.setter_ = r101;
            return r101;
        }

        public static /* synthetic */ JvmMethodSignature access$3802(JvmPropertySignature r100, JvmMethodSignature r101) {
            r100.delegateMethod_ = r101;
            return r101;
        }

        public static /* synthetic */ int access$3902(JvmPropertySignature r100, int r101) {
            r100.bitField0_ = r101;
            return r101;
        }

        public /* synthetic */ JvmPropertySignature(GeneratedMessageLite.Builder r100, AnonymousClass1 r101) {
            this(r100);
        }

        public /* synthetic */ JvmPropertySignature(CodedInputStream r100, ExtensionRegistryLite r101, AnonymousClass1 r102) throws InvalidProtocolBufferException {
            this(r100, r101);
        }
    }

    public interface JvmPropertySignatureOrBuilder extends MessageLiteOrBuilder {
    }

    public static final class StringTableTypes extends GeneratedMessageLite implements StringTableTypesOrBuilder {
        public static Parser<StringTableTypes> PARSER;
        private static final StringTableTypes defaultInstance = null;
        private int localNameMemoizedSerializedSize;
        private List<Integer> localName_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<Record> record_;
        private final ByteString unknownFields;

        /* JADX INFO: loaded from: classes42.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<StringTableTypes, Builder> implements StringTableTypesOrBuilder {
            private int bitField0_;
            private List<Integer> localName_;
            private List<Record> record_;

            private void maybeForceBuilderInitialization() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            private static Builder create() {
                return new Builder();
            }

            private void ensureLocalNameIsMutable() {
                if ((this.bitField0_ & 2) == 2) goto L6;
                this.localName_ = new ArrayList(this.localName_);
                this.bitField0_ |= 2;
                return;
            }

            private void ensureRecordIsMutable() {
                if ((this.bitField0_ & 1) == 1) goto L6;
                this.record_ = new ArrayList(this.record_);
                this.bitField0_ |= 1;
                return;
            }

            public StringTableTypes buildPartial() {
                StringTableTypes r100 = new StringTableTypes(this, null);
                if ((this.bitField0_ & 1) != 1) goto L5;
                this.record_ = Collections.unmodifiableList(this.record_);
                this.bitField0_ &= -2;
            L5:
                StringTableTypes.access$1402(r100, this.record_);
                if ((this.bitField0_ & 2) != 2) goto L8;
                this.localName_ = Collections.unmodifiableList(this.localName_);
                this.bitField0_ &= -3;
            L8:
                StringTableTypes.access$1502(r100, this.localName_);
                return r100;
            }

            private Builder() {
                this.record_ = Collections.emptyList();
                this.localName_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            public static /* synthetic */ Builder access$1200() {
                return create();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public StringTableTypes build() {
                StringTableTypes r100 = buildPartial();
                if (r100.isInitialized() == false) goto L6;
                return r100;
            L6:
                throw AbstractMessageLite.Builder.newUninitializedMessageException(r100);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public StringTableTypes getDefaultInstanceForType() {
                return StringTableTypes.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo10730clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                return clone();
            }

            public Builder mergeFrom(StringTableTypes r100) {
                if (r100 != StringTableTypes.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (StringTableTypes.access$1400(r100).isEmpty() == true) goto L12;
                if (this.record_.isEmpty() == false) goto L10;
                this.record_ = StringTableTypes.access$1400(r100);
                this.bitField0_ &= -2;
                goto L12
            L10:
                ensureRecordIsMutable();
                this.record_.addAll(StringTableTypes.access$1400(r100));
            L12:
                if (StringTableTypes.access$1500(r100).isEmpty() == false) goto L14;
            L17:
                setUnknownFields(getUnknownFields().concat(StringTableTypes.access$1600(r100)));
                return this;
            L14:
                if (this.localName_.isEmpty() == false) goto L16;
                this.localName_ = StringTableTypes.access$1500(r100);
                this.bitField0_ &= -3;
                goto L17
            L16:
                ensureLocalNameIsMutable();
                this.localName_.addAll(StringTableTypes.access$1500(r100));
                goto L17
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r100) {
                return mergeFrom((StringTableTypes) r100);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
                StringTableTypes r102 = null;
                StringTableTypes r103 = StringTableTypes.PARSER.parsePartialFrom(r100, r101);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r103 == null) goto L6;
                mergeFrom(r103);
            L6:
                return this;
            L9:
                e = move-exception;
                StringTableTypes r104 = (StringTableTypes) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                throw e;     // Catch: Throwable -> L12
            L12:
                th = th;
                r102 = r104;
            L14:
                if (r102 == null) goto L16;
                mergeFrom(r102);
            L16:
                throw th;
            L7:
                th = th;
                goto L14
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
                return mergeFrom(r100, r101);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
                return mergeFrom(r100, r101);
            }
        }

        public static final class Record extends GeneratedMessageLite implements RecordOrBuilder {
            public static Parser<Record> PARSER;
            private static final Record defaultInstance = null;
            private int bitField0_;
            private byte memoizedIsInitialized;
            private int memoizedSerializedSize;
            private Operation operation_;
            private int predefinedIndex_;
            private int range_;
            private int replaceCharMemoizedSerializedSize;
            private List<Integer> replaceChar_;
            private Object string_;
            private int substringIndexMemoizedSerializedSize;
            private List<Integer> substringIndex_;
            private final ByteString unknownFields;

            /* JADX INFO: loaded from: classes42.dex */
            public static final class Builder extends GeneratedMessageLite.Builder<Record, Builder> implements RecordOrBuilder {
                private int bitField0_;
                private Operation operation_;
                private int predefinedIndex_;
                private int range_;
                private List<Integer> replaceChar_;
                private Object string_;
                private List<Integer> substringIndex_;

                private void maybeForceBuilderInitialization() {
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                public final boolean isInitialized() {
                    return true;
                }

                private static Builder create() {
                    return new Builder();
                }

                private void ensureReplaceCharIsMutable() {
                    if ((this.bitField0_ & 32) == 32) goto L6;
                    this.replaceChar_ = new ArrayList(this.replaceChar_);
                    this.bitField0_ |= 32;
                    return;
                }

                private void ensureSubstringIndexIsMutable() {
                    if ((this.bitField0_ & 16) == 16) goto L6;
                    this.substringIndex_ = new ArrayList(this.substringIndex_);
                    this.bitField0_ |= 16;
                    return;
                }

                public Record buildPartial() {
                    Record r100 = new Record(this, null);
                    int r101 = this.bitField0_;
                    int r102 = 1;
                    if ((r101 & 1) == 1) goto L6;
                    r102 = 0;
                L6:
                    Record.access$402(r100, this.range_);
                    if ((r101 & 2) != 2) goto L9;
                    r102 = r102 | 2;
                L9:
                    Record.access$502(r100, this.predefinedIndex_);
                    if ((r101 & 4) != 4) goto L12;
                    r102 = r102 | 4;
                L12:
                    Record.access$602(r100, this.string_);
                    if ((r101 & 8) != 8) goto L15;
                    r102 = r102 | 8;
                L15:
                    Record.access$702(r100, this.operation_);
                    if ((this.bitField0_ & 16) != 16) goto L18;
                    this.substringIndex_ = Collections.unmodifiableList(this.substringIndex_);
                    this.bitField0_ &= -17;
                L18:
                    Record.access$802(r100, this.substringIndex_);
                    if ((this.bitField0_ & 32) != 32) goto L21;
                    this.replaceChar_ = Collections.unmodifiableList(this.replaceChar_);
                    this.bitField0_ &= -33;
                L21:
                    Record.access$902(r100, this.replaceChar_);
                    Record.access$1002(r100, r102);
                    return r100;
                }

                private Builder() {
                    this.range_ = 1;
                    this.string_ = "";
                    this.operation_ = Operation.NONE;
                    this.substringIndex_ = Collections.emptyList();
                    this.replaceChar_ = Collections.emptyList();
                    maybeForceBuilderInitialization();
                }

                public static /* synthetic */ Builder access$200() {
                    return create();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                public Record build() {
                    Record r100 = buildPartial();
                    if (r100.isInitialized() == false) goto L6;
                    return r100;
                L6:
                    throw AbstractMessageLite.Builder.newUninitializedMessageException(r100);
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
                public Builder clone() {
                    return create().mergeFrom(buildPartial());
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                public Record getDefaultInstanceForType() {
                    return Record.getDefaultInstance();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite build() {
                    return build();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
                public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
                    return clone();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                    return getDefaultInstanceForType();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
                /* JADX INFO: renamed from: clone */
                public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo10730clone() {
                    return clone();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                    return getDefaultInstanceForType();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
                public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                    return clone();
                }

                public Builder mergeFrom(Record r100) {
                    if (r100 != Record.getDefaultInstance()) goto L6;
                    return this;
                L6:
                    if (r100.hasRange() == false) goto L9;
                    setRange(r100.getRange());
                L9:
                    if (r100.hasPredefinedIndex() == false) goto L12;
                    setPredefinedIndex(r100.getPredefinedIndex());
                L12:
                    if (r100.hasString() == false) goto L15;
                    this.bitField0_ |= 4;
                    this.string_ = Record.access$600(r100);
                L15:
                    if (r100.hasOperation() == false) goto L18;
                    setOperation(r100.getOperation());
                L18:
                    if (Record.access$800(r100).isEmpty() == true) goto L24;
                    if (this.substringIndex_.isEmpty() == false) goto L22;
                    this.substringIndex_ = Record.access$800(r100);
                    this.bitField0_ &= -17;
                    goto L24
                L22:
                    ensureSubstringIndexIsMutable();
                    this.substringIndex_.addAll(Record.access$800(r100));
                L24:
                    if (Record.access$900(r100).isEmpty() == false) goto L26;
                L29:
                    setUnknownFields(getUnknownFields().concat(Record.access$1100(r100)));
                    return this;
                L26:
                    if (this.replaceChar_.isEmpty() == false) goto L28;
                    this.replaceChar_ = Record.access$900(r100);
                    this.bitField0_ &= -33;
                    goto L29
                L28:
                    ensureReplaceCharIsMutable();
                    this.replaceChar_.addAll(Record.access$900(r100));
                    goto L29
                }

                public Builder setOperation(Operation r100) {
                    if (r100 == null) goto L6;
                    this.bitField0_ |= 8;
                    this.operation_ = r100;
                    return this;
                L6:
                    throw null;
                }

                public Builder setPredefinedIndex(int r100) {
                    this.bitField0_ |= 2;
                    this.predefinedIndex_ = r100;
                    return this;
                }

                public Builder setRange(int r100) {
                    this.bitField0_ |= 1;
                    this.range_ = r100;
                    return this;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
                public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r100) {
                    return mergeFrom((Record) r100);
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                public Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
                    Record r102 = null;
                    Record r103 = Record.PARSER.parsePartialFrom(r100, r101);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                    if (r103 == null) goto L6;
                    mergeFrom(r103);
                L6:
                    return this;
                L9:
                    e = move-exception;
                    Record r104 = (Record) e.getUnfinishedMessage();     // Catch: Throwable -> L7
                    throw e;     // Catch: Throwable -> L12
                L12:
                    th = th;
                    r102 = r104;
                L14:
                    if (r102 == null) goto L16;
                    mergeFrom(r102);
                L16:
                    throw th;
                L7:
                    th = th;
                    goto L14
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
                    return mergeFrom(r100, r101);
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
                    return mergeFrom(r100, r101);
                }
            }

            public static final enum Operation extends Enum<Operation> implements Internal.EnumLite {
                private static final /* synthetic */ Operation[] $VALUES = null;
                public static final Operation DESC_TO_CLASS_ID = null;
                public static final Operation INTERNAL_TO_CLASS_ID = null;
                public static final Operation NONE = null;
                private static Internal.EnumLiteMap<Operation> internalValueMap;
                private final int value;

                static {
                    Operation r100 = new Operation(UserProfileEvent.POSITION_NONE, 0, 0, 0);
                    NONE = r100;
                    Operation r101 = new Operation("INTERNAL_TO_CLASS_ID", 1, 1, 1);
                    INTERNAL_TO_CLASS_ID = r101;
                    Operation r102 = new Operation("DESC_TO_CLASS_ID", 2, 2, 2);
                    DESC_TO_CLASS_ID = r102;
                    $VALUES = new Operation[]{r100, r101, r102};
                    internalValueMap = new AnonymousClass1();
                }

                public static Operation[] values() {
                    return (Operation[]) $VALUES.clone();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
                public final int getNumber() {
                    return this.value;
                }

                public static Operation valueOf(int r100) {
                    if (r100 == 0) goto L14;
                    if (r100 == 1) goto L12;
                    if (r100 == 2) goto L10;
                    return null;
                L10:
                    return DESC_TO_CLASS_ID;
                L12:
                    return INTERNAL_TO_CLASS_ID;
                L14:
                    return NONE;
                }

                public static Operation valueOf(String r100) {
                    return (Operation) a.a(Operation.class, r100);
                }

                private Operation(String r100, int r101, int r102, int r103) {
                    super(r100, r101);
                    this.value = r103;
                }
            }

            private void initFields() {
                this.range_ = 1;
                this.predefinedIndex_ = 0;
                this.string_ = "";
                this.operation_ = Operation.NONE;
                this.substringIndex_ = Collections.emptyList();
                this.replaceChar_ = Collections.emptyList();
            }

            static {
                PARSER = new AnonymousClass1();
                Record r100 = new Record(true);
                defaultInstance = r100;
                r100.initFields();
            }

            public int getReplaceCharCount() {
                return this.replaceChar_.size();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public int getSerializedSize() {
                int r100 = this.memoizedSerializedSize;
                if (r100 == (-1)) goto L5;
                return r100;
            L5:
                int r101 = 0;
                if ((this.bitField0_ & 1) != 1) goto L8;
                int r102 = CodedOutputStream.computeInt32Size(1, this.range_) + 0;
            L10:
                if ((this.bitField0_ & 2) != 2) goto L13;
                r102 = r102 + CodedOutputStream.computeInt32Size(2, this.predefinedIndex_);
            L13:
                if ((this.bitField0_ & 8) != 8) goto L15;
                r102 = r102 + CodedOutputStream.computeEnumSize(3, this.operation_.getNumber());
            L15:
                int r103 = 0;
                int r104 = 0;
            L17:
                if (r103 >= this.substringIndex_.size()) goto L19;
                r104 = r104 + CodedOutputStream.computeInt32SizeNoTag(((Integer) ListProtector.get(this.substringIndex_, r103)).intValue());
                r103 = r103 + 1;
                goto L17
            L19:
                int r105 = r102 + r104;
                if (getSubstringIndexList().isEmpty() == true) goto L22;
                r105 = (r105 + 1) + CodedOutputStream.computeInt32SizeNoTag(r104);
            L22:
                this.substringIndexMemoizedSerializedSize = r104;
                int r106 = 0;
            L24:
                if (r101 >= this.replaceChar_.size()) goto L26;
                r106 = r106 + CodedOutputStream.computeInt32SizeNoTag(((Integer) ListProtector.get(this.replaceChar_, r101)).intValue());
                r101 = r101 + 1;
                goto L24
            L26:
                int r107 = r105 + r106;
                if (getReplaceCharList().isEmpty() == true) goto L29;
                r107 = (r107 + 1) + CodedOutputStream.computeInt32SizeNoTag(r106);
            L29:
                this.replaceCharMemoizedSerializedSize = r106;
                if ((this.bitField0_ & 4) != 4) goto L32;
                r107 = r107 + CodedOutputStream.computeBytesSize(6, getStringBytes());
            L32:
                int r108 = r107 + this.unknownFields.size();
                this.memoizedSerializedSize = r108;
                return r108;
            L8:
                r102 = 0;
                goto L10
            }

            public String getString() {
                Object r100 = this.string_;
                if ((r100 instanceof String) == true) goto L5;
                ByteString r101 = (ByteString) r100;
                String r102 = r101.toStringUtf8();
                if (r101.isValidUtf8() == false) goto L9;
                this.string_ = r102;
            L9:
                return r102;
            L5:
                return (String) r100;
            }

            public ByteString getStringBytes() {
                Object r100 = this.string_;
                if ((r100 instanceof String) == false) goto L7;
                ByteString r101 = ByteString.copyFromUtf8((String) r100);
                this.string_ = r101;
                return r101;
            L7:
                return (ByteString) r100;
            }

            public int getSubstringIndexCount() {
                return this.substringIndex_.size();
            }

            public boolean hasOperation() {
                if ((this.bitField0_ & 8) != 8) goto L5;
                return true;
            L5:
                return false;
            }

            public boolean hasPredefinedIndex() {
                if ((this.bitField0_ & 2) != 2) goto L5;
                return true;
            L5:
                return false;
            }

            public boolean hasRange() {
                if ((this.bitField0_ & 1) == 1) goto L7;
                return false;
            L7:
                return true;
            }

            public boolean hasString() {
                if ((this.bitField0_ & 4) != 4) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                byte r100 = this.memoizedIsInitialized;
                if (r100 != 1) goto L5;
                return true;
            L5:
                if (r100 != 0) goto L8;
                return false;
            L8:
                this.memoizedIsInitialized = 1;
                return true;
            }

            public static Builder newBuilder() {
                return Builder.access$200();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public Builder newBuilderForType() {
                return newBuilder();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public Builder toBuilder() {
                return newBuilder(this);
            }

            public static Record getDefaultInstance() {
                return defaultInstance;
            }

            public Operation getOperation() {
                return this.operation_;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public Parser<Record> getParserForType() {
                return PARSER;
            }

            public int getPredefinedIndex() {
                return this.predefinedIndex_;
            }

            public int getRange() {
                return this.range_;
            }

            public List<Integer> getReplaceCharList() {
                return this.replaceChar_;
            }

            public List<Integer> getSubstringIndexList() {
                return this.substringIndex_;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public Record getDefaultInstanceForType() {
                return defaultInstance;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
                return newBuilderForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
                return toBuilder();
            }

            private Record(GeneratedMessageLite.Builder r100) {
                super(r100);
                this.substringIndexMemoizedSerializedSize = -1;
                this.replaceCharMemoizedSerializedSize = -1;
                this.memoizedIsInitialized = -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = r100.getUnknownFields();
            }

            public static /* synthetic */ ByteString access$1100(Record r100) {
                return r100.unknownFields;
            }

            public static /* synthetic */ Object access$600(Record r100) {
                return r100.string_;
            }

            public static /* synthetic */ List access$800(Record r100) {
                return r100.substringIndex_;
            }

            public static /* synthetic */ List access$900(Record r100) {
                return r100.replaceChar_;
            }

            public static Builder newBuilder(Record r100) {
                return newBuilder().mergeFrom(r100);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public void writeTo(CodedOutputStream r100) throws IOException {
                getSerializedSize();
                if ((this.bitField0_ & 1) != 1) goto L6;
                r100.writeInt32(1, this.range_);
            L6:
                if ((this.bitField0_ & 2) != 2) goto L9;
                r100.writeInt32(2, this.predefinedIndex_);
            L9:
                if ((this.bitField0_ & 8) != 8) goto L12;
                r100.writeEnum(3, this.operation_.getNumber());
            L12:
                if (getSubstringIndexList().size() <= 0) goto L14;
                r100.writeRawVarint32(34);
                r100.writeRawVarint32(this.substringIndexMemoizedSerializedSize);
            L14:
                int r101 = 0;
                int r102 = 0;
            L16:
                if (r102 >= this.substringIndex_.size()) goto L19;
                r100.writeInt32NoTag(((Integer) ListProtector.get(this.substringIndex_, r102)).intValue());
                r102 = r102 + 1;
                goto L16
            L19:
                if (getReplaceCharList().size() <= 0) goto L22;
                r100.writeRawVarint32(42);
                r100.writeRawVarint32(this.replaceCharMemoizedSerializedSize);
            L22:
                if (r101 >= this.replaceChar_.size()) goto L25;
                r100.writeInt32NoTag(((Integer) ListProtector.get(this.replaceChar_, r101)).intValue());
                r101 = r101 + 1;
                goto L22
            L25:
                if ((this.bitField0_ & 4) != 4) goto L27;
                r100.writeBytes(6, getStringBytes());
            L27:
                r100.writeRawBytes(this.unknownFields);
            }

            private Record(boolean r100) {
                this.substringIndexMemoizedSerializedSize = -1;
                this.replaceCharMemoizedSerializedSize = -1;
                this.memoizedIsInitialized = -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = ByteString.EMPTY;
            }

            private Record(CodedInputStream r110, ExtensionRegistryLite r111) throws InvalidProtocolBufferException {
                this.substringIndexMemoizedSerializedSize = -1;
                this.replaceCharMemoizedSerializedSize = -1;
                this.memoizedIsInitialized = -1;
                this.memoizedSerializedSize = -1;
                initFields();
                ByteString.Output r100 = ByteString.newOutput();
                CodedOutputStream r101 = CodedOutputStream.newInstance(r100, 1);
                boolean r102 = false;
                int r103 = 0;
            L4:
                if (r102 == true) goto L81;
                int r104 = r110.readTag();     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
                if (r104 == 0) goto L58;
                if (r104 != 8) goto L9;
                this.bitField0_ |= 1;     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
                this.range_ = r110.readInt32();     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
                goto L4
            L9:
                if (r104 != 16) goto L11;
                this.bitField0_ |= 2;     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
                this.predefinedIndex_ = r110.readInt32();     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
                goto L4
            L11:
                if (r104 != 24) goto L12;
                int r105 = r110.readEnum();     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
                Operation r112 = Operation.valueOf(r105);     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
                if (r112 == null) goto L53;
                this.bitField0_ |= 8;     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
                this.operation_ = r112;     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
                goto L4
            L53:
                r101.writeRawVarint32(r104);     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
                r101.writeRawVarint32(r105);     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
                goto L4
            L12:
                if (r104 != 32) goto L14;
                if ((r103 & 16) == 16) goto L50;
                this.substringIndex_ = new ArrayList();     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
                r103 = r103 | 16;     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
            L50:
                this.substringIndex_.add(Integer.valueOf(r110.readInt32()));     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
                goto L4
            L14:
                if (r104 != 34) goto L16;
                int r106 = r110.pushLimit(r110.readRawVarint32());     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
                if ((r103 & 16) == 16) goto L44;
                if (r110.getBytesUntilLimit() <= 0) goto L44;
                this.substringIndex_ = new ArrayList();     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
                r103 = r103 | 16;     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
            L44:
                if (r110.getBytesUntilLimit() <= 0) goto L46;
                this.substringIndex_.add(Integer.valueOf(r110.readInt32()));     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
                goto L44
            L46:
                r110.popLimit(r106);     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
                goto L4
            L16:
                if (r104 != 40) goto L18;
                if ((r103 & 32) == 32) goto L37;
                this.replaceChar_ = new ArrayList();     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
                r103 = r103 | 32;     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
            L37:
                this.replaceChar_.add(Integer.valueOf(r110.readInt32()));     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
                goto L4
            L18:
                if (r104 != 42) goto L20;
                int r107 = r110.pushLimit(r110.readRawVarint32());     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
                if ((r103 & 32) == 32) goto L31;
                if (r110.getBytesUntilLimit() <= 0) goto L31;
                this.replaceChar_ = new ArrayList();     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
                r103 = r103 | 32;     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
            L31:
                if (r110.getBytesUntilLimit() <= 0) goto L33;
                this.replaceChar_.add(Integer.valueOf(r110.readInt32()));     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
                goto L31
            L33:
                r110.popLimit(r107);     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
                goto L4
            L20:
                if (r104 != 50) goto L22;
                ByteString r108 = r110.readBytes();     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
                this.bitField0_ |= 4;     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
                this.string_ = r108;     // Catch: Throwable -> L59 IOException -> L61 InvalidProtocolBufferException -> L64
                goto L4
            L22:
                if (parseUnknownField(r110, r101, r111, r104) == true) goto L4;
            L58:
                r102 = true;
                goto L4
            L59:
                th = move-exception;
                if ((r103 & 16) != 16) goto L71;
                this.substringIndex_ = Collections.unmodifiableList(this.substringIndex_);
            L71:
                if ((r103 & 32) != 32) goto L98;
                this.replaceChar_ = Collections.unmodifiableList(this.replaceChar_);
            L98:
                r101.flush();     // Catch: IOException -> L94 Throwable -> L75
            L75:
                th = move-exception;
                this.unknownFields = r100.toByteString();
                throw th;
            L74:
                this.unknownFields = r100.toByteString();
                makeExtensionsImmutable();
                throw th;
            L64:
                e = move-exception;
                throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L59
            L61:
                e = move-exception;
                throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L59
            L81:
                if ((r103 & 16) != 16) goto L84;
                this.substringIndex_ = Collections.unmodifiableList(this.substringIndex_);
            L84:
                if ((r103 & 32) != 32) goto L96;
                this.replaceChar_ = Collections.unmodifiableList(this.replaceChar_);
            L96:
                r101.flush();     // Catch: IOException -> L93 Throwable -> L88
            L88:
                th = move-exception;
                this.unknownFields = r100.toByteString();
                throw th;
            L87:
                this.unknownFields = r100.toByteString();
                makeExtensionsImmutable();
            }

            public static /* synthetic */ int access$1002(Record r100, int r101) {
                r100.bitField0_ = r101;
                return r101;
            }

            public static /* synthetic */ int access$402(Record r100, int r101) {
                r100.range_ = r101;
                return r101;
            }

            public static /* synthetic */ int access$502(Record r100, int r101) {
                r100.predefinedIndex_ = r101;
                return r101;
            }

            public static /* synthetic */ Object access$602(Record r100, Object r101) {
                r100.string_ = r101;
                return r101;
            }

            public static /* synthetic */ Operation access$702(Record r100, Operation r101) {
                r100.operation_ = r101;
                return r101;
            }

            public static /* synthetic */ List access$802(Record r100, List r101) {
                r100.substringIndex_ = r101;
                return r101;
            }

            public static /* synthetic */ List access$902(Record r100, List r101) {
                r100.replaceChar_ = r101;
                return r101;
            }

            public /* synthetic */ Record(GeneratedMessageLite.Builder r100, AnonymousClass1 r101) {
                this(r100);
            }

            public /* synthetic */ Record(CodedInputStream r100, ExtensionRegistryLite r101, AnonymousClass1 r102) throws InvalidProtocolBufferException {
                this(r100, r101);
            }
        }

        public interface RecordOrBuilder extends MessageLiteOrBuilder {
        }

        static {
            PARSER = new AnonymousClass1();
            StringTableTypes r100 = new StringTableTypes(true);
            defaultInstance = r100;
            r100.initFields();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int r100 = this.memoizedSerializedSize;
            if (r100 == (-1)) goto L5;
            return r100;
        L5:
            int r101 = 0;
            int r102 = 0;
            int r103 = 0;
        L7:
            if (r102 >= this.record_.size()) goto L9;
            r103 = r103 + CodedOutputStream.computeMessageSize(1, (MessageLite) ListProtector.get(this.record_, r102));
            r102 = r102 + 1;
            goto L7
        L9:
            int r104 = 0;
        L11:
            if (r101 >= this.localName_.size()) goto L13;
            r104 = r104 + CodedOutputStream.computeInt32SizeNoTag(((Integer) ListProtector.get(this.localName_, r101)).intValue());
            r101 = r101 + 1;
            goto L11
        L13:
            int r105 = r103 + r104;
            if (getLocalNameList().isEmpty() == true) goto L16;
            r105 = (r105 + 1) + CodedOutputStream.computeInt32SizeNoTag(r104);
        L16:
            this.localNameMemoizedSerializedSize = r104;
            int r106 = r105 + this.unknownFields.size();
            this.memoizedSerializedSize = r106;
            return r106;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte r100 = this.memoizedIsInitialized;
            if (r100 != 1) goto L5;
            return true;
        L5:
            if (r100 != 0) goto L8;
            return false;
        L8:
            this.memoizedIsInitialized = 1;
            return true;
        }

        private void initFields() {
            this.record_ = Collections.emptyList();
            this.localName_ = Collections.emptyList();
        }

        public static Builder newBuilder() {
            return Builder.access$1200();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Builder toBuilder() {
            return newBuilder(this);
        }

        public static StringTableTypes getDefaultInstance() {
            return defaultInstance;
        }

        public List<Integer> getLocalNameList() {
            return this.localName_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<StringTableTypes> getParserForType() {
            return PARSER;
        }

        public List<Record> getRecordList() {
            return this.record_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public StringTableTypes getDefaultInstanceForType() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder newBuilderForType() {
            return newBuilderForType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.Builder toBuilder() {
            return toBuilder();
        }

        private StringTableTypes(GeneratedMessageLite.Builder r100) {
            super(r100);
            this.localNameMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r100.getUnknownFields();
        }

        public static /* synthetic */ List access$1400(StringTableTypes r100) {
            return r100.record_;
        }

        public static /* synthetic */ List access$1500(StringTableTypes r100) {
            return r100.localName_;
        }

        public static /* synthetic */ ByteString access$1600(StringTableTypes r100) {
            return r100.unknownFields;
        }

        public static Builder newBuilder(StringTableTypes r100) {
            return newBuilder().mergeFrom(r100);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r100) throws IOException {
            getSerializedSize();
            int r101 = 0;
            int r102 = 0;
        L4:
            if (r102 >= this.record_.size()) goto L7;
            r100.writeMessage(1, (MessageLite) ListProtector.get(this.record_, r102));
            r102 = r102 + 1;
            goto L4
        L7:
            if (getLocalNameList().size() <= 0) goto L10;
            r100.writeRawVarint32(42);
            r100.writeRawVarint32(this.localNameMemoizedSerializedSize);
        L10:
            if (r101 >= this.localName_.size()) goto L12;
            r100.writeInt32NoTag(((Integer) ListProtector.get(this.localName_, r101)).intValue());
            r101 = r101 + 1;
            goto L10
        L12:
            r100.writeRawBytes(this.unknownFields);
        }

        private StringTableTypes(boolean r100) {
            this.localNameMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        private StringTableTypes(CodedInputStream r110, ExtensionRegistryLite r111) throws InvalidProtocolBufferException {
            this.localNameMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r100 = ByteString.newOutput();
            CodedOutputStream r101 = CodedOutputStream.newInstance(r100, 1);
            boolean r102 = false;
            int r103 = 0;
        L4:
            if (r102 == true) goto L57;
            int r104 = r110.readTag();     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
            if (r104 == 0) goto L34;
            if (r104 != 10) goto L10;
            if ((r103 & 1) == 1) goto L32;
            this.record_ = new ArrayList();     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
            r103 = r103 | 1;     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
        L32:
            this.record_.add((Record) r110.readMessage(Record.PARSER, r111));     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
            goto L4
        L10:
            if (r104 != 40) goto L12;
            if ((r103 & 2) == 2) goto L28;
            this.localName_ = new ArrayList();     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
            r103 = r103 | 2;     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
        L28:
            this.localName_.add(Integer.valueOf(r110.readInt32()));     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
            goto L4
        L12:
            if (r104 != 42) goto L14;
            int r105 = r110.pushLimit(r110.readRawVarint32());     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
            if ((r103 & 2) == 2) goto L22;
            if (r110.getBytesUntilLimit() <= 0) goto L22;
            this.localName_ = new ArrayList();     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
            r103 = r103 | 2;     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
        L22:
            if (r110.getBytesUntilLimit() <= 0) goto L24;
            this.localName_.add(Integer.valueOf(r110.readInt32()));     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
            goto L22
        L24:
            r110.popLimit(r105);     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
            goto L4
        L14:
            if (parseUnknownField(r110, r101, r111, r104) == true) goto L4;
        L34:
            r102 = true;
            goto L4
        L35:
            th = move-exception;
            if ((r103 & 1) != 1) goto L47;
            this.record_ = Collections.unmodifiableList(this.record_);
        L47:
            if ((r103 & 2) != 2) goto L74;
            this.localName_ = Collections.unmodifiableList(this.localName_);
        L74:
            r101.flush();     // Catch: IOException -> L70 Throwable -> L51
        L51:
            th = move-exception;
            this.unknownFields = r100.toByteString();
            throw th;
        L50:
            this.unknownFields = r100.toByteString();
            makeExtensionsImmutable();
            throw th;
        L40:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L35
        L37:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L35
        L57:
            if ((r103 & 1) != 1) goto L60;
            this.record_ = Collections.unmodifiableList(this.record_);
        L60:
            if ((r103 & 2) != 2) goto L72;
            this.localName_ = Collections.unmodifiableList(this.localName_);
        L72:
            r101.flush();     // Catch: IOException -> L69 Throwable -> L64
        L64:
            th = move-exception;
            this.unknownFields = r100.toByteString();
            throw th;
        L63:
            this.unknownFields = r100.toByteString();
            makeExtensionsImmutable();
        }

        public static /* synthetic */ List access$1402(StringTableTypes r100, List r101) {
            r100.record_ = r101;
            return r101;
        }

        public static /* synthetic */ List access$1502(StringTableTypes r100, List r101) {
            r100.localName_ = r101;
            return r101;
        }

        public static StringTableTypes parseDelimitedFrom(InputStream r100, ExtensionRegistryLite r101) throws IOException {
            return PARSER.parseDelimitedFrom(r100, r101);
        }

        public /* synthetic */ StringTableTypes(GeneratedMessageLite.Builder r100, AnonymousClass1 r101) {
            this(r100);
        }

        public /* synthetic */ StringTableTypes(CodedInputStream r100, ExtensionRegistryLite r101, AnonymousClass1 r102) throws InvalidProtocolBufferException {
            this(r100, r101);
        }
    }

    public interface StringTableTypesOrBuilder extends MessageLiteOrBuilder {
    }

    static {
        ProtoBuf.Constructor r100 = ProtoBuf.Constructor.getDefaultInstance();
        JvmMethodSignature r101 = JvmMethodSignature.getDefaultInstance();
        JvmMethodSignature r102 = JvmMethodSignature.getDefaultInstance();
        WireFormat.FieldType r110 = WireFormat.FieldType.MESSAGE;
        constructorSignature = GeneratedMessageLite.newSingularGeneratedExtension(r100, r101, r102, null, 100, r110, JvmMethodSignature.class);
        methodSignature = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Function.getDefaultInstance(), JvmMethodSignature.getDefaultInstance(), JvmMethodSignature.getDefaultInstance(), null, 100, r110, JvmMethodSignature.class);
        ProtoBuf.Function r103 = ProtoBuf.Function.getDefaultInstance();
        WireFormat.FieldType r111 = WireFormat.FieldType.INT32;
        lambdaClassOriginName = GeneratedMessageLite.newSingularGeneratedExtension(r103, 0, null, null, 101, r111, Integer.class);
        propertySignature = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Property.getDefaultInstance(), JvmPropertySignature.getDefaultInstance(), JvmPropertySignature.getDefaultInstance(), null, 100, r110, JvmPropertySignature.class);
        flags = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Property.getDefaultInstance(), 0, null, null, 101, r111, Integer.class);
        typeAnnotation = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.Type.getDefaultInstance(), ProtoBuf.Annotation.getDefaultInstance(), null, 100, r110, false, ProtoBuf.Annotation.class);
        isRaw = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Type.getDefaultInstance(), Boolean.FALSE, null, null, 101, WireFormat.FieldType.BOOL, Boolean.class);
        typeParameterAnnotation = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.TypeParameter.getDefaultInstance(), ProtoBuf.Annotation.getDefaultInstance(), null, 100, r110, false, ProtoBuf.Annotation.class);
        classModuleName = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Class.getDefaultInstance(), 0, null, null, 101, r111, Integer.class);
        classLocalVariable = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.Class.getDefaultInstance(), ProtoBuf.Property.getDefaultInstance(), null, 102, r110, false, ProtoBuf.Property.class);
        anonymousObjectOriginName = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Class.getDefaultInstance(), 0, null, null, 103, r111, Integer.class);
        jvmClassFlags = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Class.getDefaultInstance(), 0, null, null, 104, r111, Integer.class);
        packageModuleName = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Package.getDefaultInstance(), 0, null, null, 101, r111, Integer.class);
        packageLocalVariable = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.Package.getDefaultInstance(), ProtoBuf.Property.getDefaultInstance(), null, 102, r110, false, ProtoBuf.Property.class);
    }

    public static void registerAllExtensions(ExtensionRegistryLite r100) {
        r100.add(constructorSignature);
        r100.add(methodSignature);
        r100.add(lambdaClassOriginName);
        r100.add(propertySignature);
        r100.add(flags);
        r100.add(typeAnnotation);
        r100.add(isRaw);
        r100.add(typeParameterAnnotation);
        r100.add(classModuleName);
        r100.add(classLocalVariable);
        r100.add(anonymousObjectOriginName);
        r100.add(jvmClassFlags);
        r100.add(packageModuleName);
        r100.add(packageLocalVariable);
    }
}
