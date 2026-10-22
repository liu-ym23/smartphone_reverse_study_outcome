package kotlin.reflect.jvm.internal.impl.metadata;

import androidx.camera.video.AudioStats;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.miniapp.alarm.AccountType;
import com.ss.ttm.player.MediaPlayer;
import com.ttnet.org.chromium.net.NetError;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedInputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.Internal;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.LazyStringArrayList;
import kotlin.reflect.jvm.internal.impl.protobuf.LazyStringList;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder;
import kotlin.reflect.jvm.internal.impl.protobuf.Parser;
import kotlin.reflect.jvm.internal.impl.protobuf.ProtocolStringList;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final class ProtoBuf {

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: loaded from: classes5.dex */
    public static final class Annotation extends GeneratedMessageLite implements AnnotationOrBuilder {
        public static Parser<Annotation> PARSER;
        private static final Annotation defaultInstance = null;
        private List<Argument> argument_;
        private int bitField0_;
        private int id_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private final ByteString unknownFields;

        public static final class Argument extends GeneratedMessageLite implements ArgumentOrBuilder {
            public static Parser<Argument> PARSER;
            private static final Argument defaultInstance = null;
            private int bitField0_;
            private byte memoizedIsInitialized;
            private int memoizedSerializedSize;
            private int nameId_;
            private final ByteString unknownFields;
            private Value value_;

            /* JADX INFO: loaded from: classes42.dex */
            public static final class Builder extends GeneratedMessageLite.Builder<Argument, Builder> implements ArgumentOrBuilder {
                private int bitField0_;
                private int nameId_;
                private Value value_;

                private void maybeForceBuilderInitialization() {
                }

                private static Builder create() {
                    return new Builder();
                }

                public Argument buildPartial() {
                    Argument r100 = new Argument(this, null);
                    int r101 = this.bitField0_;
                    int r102 = 1;
                    if ((r101 & 1) == 1) goto L6;
                    r102 = 0;
                L6:
                    Argument.access$3802(r100, this.nameId_);
                    if ((r101 & 2) != 2) goto L9;
                    r102 = r102 | 2;
                L9:
                    Argument.access$3902(r100, this.value_);
                    Argument.access$4002(r100, r102);
                    return r100;
                }

                public boolean hasNameId() {
                    if ((this.bitField0_ & 1) == 1) goto L7;
                    return false;
                L7:
                    return true;
                }

                public boolean hasValue() {
                    if ((this.bitField0_ & 2) != 2) goto L5;
                    return true;
                L5:
                    return false;
                }

                private Builder() {
                    this.value_ = Value.getDefaultInstance();
                    maybeForceBuilderInitialization();
                }

                public static /* synthetic */ Builder access$3600() {
                    return create();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                public Argument build() {
                    Argument r100 = buildPartial();
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
                public Argument getDefaultInstanceForType() {
                    return Argument.getDefaultInstance();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                public final boolean isInitialized() {
                    if (hasNameId() == true) goto L6;
                    return false;
                L6:
                    if (hasValue() == true) goto L9;
                    return false;
                L9:
                    if (getValue().isInitialized() == true) goto L11;
                    return false;
                L11:
                    return true;
                }

                public Value getValue() {
                    return this.value_;
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
                /* JADX INFO: renamed from: clone, reason: collision with other method in class */
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

                public Builder mergeFrom(Argument r100) {
                    if (r100 != Argument.getDefaultInstance()) goto L6;
                    return this;
                L6:
                    if (r100.hasNameId() == false) goto L9;
                    setNameId(r100.getNameId());
                L9:
                    if (r100.hasValue() == false) goto L11;
                    mergeValue(r100.getValue());
                L11:
                    setUnknownFields(getUnknownFields().concat(Argument.access$4100(r100)));
                    return this;
                }

                public Builder mergeValue(Value r100) {
                    if ((this.bitField0_ & 2) == 2) goto L5;
                L7:
                    this.value_ = r100;
                L8:
                    this.bitField0_ |= 2;
                    return this;
                L5:
                    if (this.value_ == Value.getDefaultInstance()) goto L7;
                    this.value_ = Value.newBuilder(this.value_).mergeFrom(r100).buildPartial();
                    goto L8
                }

                public Builder setNameId(int r100) {
                    this.bitField0_ |= 1;
                    this.nameId_ = r100;
                    return this;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
                public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r100) {
                    return mergeFrom((Argument) r100);
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                public Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
                    Argument r102 = null;
                    Argument r103 = Argument.PARSER.parsePartialFrom(r100, r101);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                    if (r103 == null) goto L6;
                    mergeFrom(r103);
                L6:
                    return this;
                L9:
                    e = move-exception;
                    Argument r104 = (Argument) e.getUnfinishedMessage();     // Catch: Throwable -> L7
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

            public static final class Value extends GeneratedMessageLite implements ValueOrBuilder {
                public static Parser<Value> PARSER;
                private static final Value defaultInstance = null;
                private Annotation annotation_;
                private int arrayDimensionCount_;
                private List<Value> arrayElement_;
                private int bitField0_;
                private int classId_;
                private double doubleValue_;
                private int enumValueId_;
                private int flags_;
                private float floatValue_;
                private long intValue_;
                private byte memoizedIsInitialized;
                private int memoizedSerializedSize;
                private int stringValue_;
                private Type type_;
                private final ByteString unknownFields;

                public static final class Builder extends GeneratedMessageLite.Builder<Value, Builder> implements ValueOrBuilder {
                    private Annotation annotation_;
                    private int arrayDimensionCount_;
                    private List<Value> arrayElement_;
                    private int bitField0_;
                    private int classId_;
                    private double doubleValue_;
                    private int enumValueId_;
                    private int flags_;
                    private float floatValue_;
                    private long intValue_;
                    private int stringValue_;
                    private Type type_;

                    private void maybeForceBuilderInitialization() {
                    }

                    private static Builder create() {
                        return new Builder();
                    }

                    private void ensureArrayElementIsMutable() {
                        if ((this.bitField0_ & 256) == 256) goto L6;
                        this.arrayElement_ = new ArrayList(this.arrayElement_);
                        this.bitField0_ |= 256;
                        return;
                    }

                    public Value buildPartial() {
                        Value r100 = new Value(this, null);
                        int r101 = this.bitField0_;
                        int r102 = 1;
                        if ((r101 & 1) == 1) goto L6;
                        r102 = 0;
                    L6:
                        Value.access$2302(r100, this.type_);
                        if ((r101 & 2) != 2) goto L9;
                        r102 = r102 | 2;
                    L9:
                        Value.access$2402(r100, this.intValue_);
                        if ((r101 & 4) != 4) goto L12;
                        r102 = r102 | 4;
                    L12:
                        Value.access$2502(r100, this.floatValue_);
                        if ((r101 & 8) != 8) goto L15;
                        r102 = r102 | 8;
                    L15:
                        Value.access$2602(r100, this.doubleValue_);
                        if ((r101 & 16) != 16) goto L18;
                        r102 = r102 | 16;
                    L18:
                        Value.access$2702(r100, this.stringValue_);
                        if ((r101 & 32) != 32) goto L21;
                        r102 = r102 | 32;
                    L21:
                        Value.access$2802(r100, this.classId_);
                        if ((r101 & 64) != 64) goto L24;
                        r102 = r102 | 64;
                    L24:
                        Value.access$2902(r100, this.enumValueId_);
                        if ((r101 & 128) != 128) goto L27;
                        r102 = r102 | 128;
                    L27:
                        Value.access$3002(r100, this.annotation_);
                        if ((this.bitField0_ & 256) != 256) goto L30;
                        this.arrayElement_ = Collections.unmodifiableList(this.arrayElement_);
                        this.bitField0_ &= -257;
                    L30:
                        Value.access$3102(r100, this.arrayElement_);
                        if ((r101 & 512) != 512) goto L33;
                        r102 = r102 | 256;
                    L33:
                        Value.access$3202(r100, this.arrayDimensionCount_);
                        if ((r101 & 1024) != 1024) goto L36;
                        r102 = r102 | 512;
                    L36:
                        Value.access$3302(r100, this.flags_);
                        Value.access$3402(r100, r102);
                        return r100;
                    }

                    public int getArrayElementCount() {
                        return this.arrayElement_.size();
                    }

                    public boolean hasAnnotation() {
                        if ((this.bitField0_ & 128) != 128) goto L5;
                        return true;
                    L5:
                        return false;
                    }

                    private Builder() {
                        this.type_ = Type.BYTE;
                        this.annotation_ = Annotation.getDefaultInstance();
                        this.arrayElement_ = Collections.emptyList();
                        maybeForceBuilderInitialization();
                    }

                    public static /* synthetic */ Builder access$2100() {
                        return create();
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                    public Value build() {
                        Value r100 = buildPartial();
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
                    public Value getDefaultInstanceForType() {
                        return Value.getDefaultInstance();
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                    public final boolean isInitialized() {
                        if (hasAnnotation() == true) goto L5;
                    L7:
                        int r100 = 0;
                    L9:
                        if (r100 >= getArrayElementCount()) goto L14;
                        if (getArrayElement(r100).isInitialized() == false) goto L12;
                        r100 = r100 + 1;
                        goto L9
                    L12:
                        return false;
                    L14:
                        return true;
                    L5:
                        if (getAnnotation().isInitialized() == true) goto L7;
                        return false;
                    }

                    public Annotation getAnnotation() {
                        return this.annotation_;
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

                    public Value getArrayElement(int r100) {
                        return (Value) ListProtector.get(this.arrayElement_, r100);
                    }

                    public Builder mergeAnnotation(Annotation r100) {
                        if ((this.bitField0_ & 128) == 128) goto L5;
                    L7:
                        this.annotation_ = r100;
                    L8:
                        this.bitField0_ |= 128;
                        return this;
                    L5:
                        if (this.annotation_ == Annotation.getDefaultInstance()) goto L7;
                        this.annotation_ = Annotation.newBuilder(this.annotation_).mergeFrom(r100).buildPartial();
                        goto L8
                    }

                    public Builder mergeFrom(Value r100) {
                        if (r100 != Value.getDefaultInstance()) goto L6;
                        return this;
                    L6:
                        if (r100.hasType() == false) goto L9;
                        setType(r100.getType());
                    L9:
                        if (r100.hasIntValue() == false) goto L12;
                        setIntValue(r100.getIntValue());
                    L12:
                        if (r100.hasFloatValue() == false) goto L15;
                        setFloatValue(r100.getFloatValue());
                    L15:
                        if (r100.hasDoubleValue() == false) goto L18;
                        setDoubleValue(r100.getDoubleValue());
                    L18:
                        if (r100.hasStringValue() == false) goto L21;
                        setStringValue(r100.getStringValue());
                    L21:
                        if (r100.hasClassId() == false) goto L24;
                        setClassId(r100.getClassId());
                    L24:
                        if (r100.hasEnumValueId() == false) goto L27;
                        setEnumValueId(r100.getEnumValueId());
                    L27:
                        if (r100.hasAnnotation() == false) goto L30;
                        mergeAnnotation(r100.getAnnotation());
                    L30:
                        if (Value.access$3100(r100).isEmpty() == true) goto L36;
                        if (this.arrayElement_.isEmpty() == false) goto L34;
                        this.arrayElement_ = Value.access$3100(r100);
                        this.bitField0_ &= -257;
                        goto L36
                    L34:
                        ensureArrayElementIsMutable();
                        this.arrayElement_.addAll(Value.access$3100(r100));
                    L36:
                        if (r100.hasArrayDimensionCount() == false) goto L39;
                        setArrayDimensionCount(r100.getArrayDimensionCount());
                    L39:
                        if (r100.hasFlags() == false) goto L41;
                        setFlags(r100.getFlags());
                    L41:
                        setUnknownFields(getUnknownFields().concat(Value.access$3500(r100)));
                        return this;
                    }

                    public Builder setArrayDimensionCount(int r100) {
                        this.bitField0_ |= 512;
                        this.arrayDimensionCount_ = r100;
                        return this;
                    }

                    public Builder setClassId(int r100) {
                        this.bitField0_ |= 32;
                        this.classId_ = r100;
                        return this;
                    }

                    public Builder setDoubleValue(double r100) {
                        this.bitField0_ |= 8;
                        this.doubleValue_ = r100;
                        return this;
                    }

                    public Builder setEnumValueId(int r100) {
                        this.bitField0_ |= 64;
                        this.enumValueId_ = r100;
                        return this;
                    }

                    public Builder setFlags(int r100) {
                        this.bitField0_ |= 1024;
                        this.flags_ = r100;
                        return this;
                    }

                    public Builder setFloatValue(float r100) {
                        this.bitField0_ |= 4;
                        this.floatValue_ = r100;
                        return this;
                    }

                    public Builder setIntValue(long r100) {
                        this.bitField0_ |= 2;
                        this.intValue_ = r100;
                        return this;
                    }

                    public Builder setStringValue(int r100) {
                        this.bitField0_ |= 16;
                        this.stringValue_ = r100;
                        return this;
                    }

                    public Builder setType(Type r100) {
                        if (r100 == null) goto L6;
                        this.bitField0_ |= 1;
                        this.type_ = r100;
                        return this;
                    L6:
                        throw null;
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
                    public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r100) {
                        return mergeFrom((Value) r100);
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                    public Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
                        Value r102 = null;
                        Value r103 = Value.PARSER.parsePartialFrom(r100, r101);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                        if (r103 == null) goto L6;
                        mergeFrom(r103);
                    L6:
                        return this;
                    L9:
                        e = move-exception;
                        Value r104 = (Value) e.getUnfinishedMessage();     // Catch: Throwable -> L7
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

                public static final enum Type extends Enum<Type> implements Internal.EnumLite {
                    private static final /* synthetic */ Type[] $VALUES = null;
                    public static final Type ANNOTATION = null;
                    public static final Type ARRAY = null;
                    public static final Type BOOLEAN = null;
                    public static final Type BYTE = null;
                    public static final Type CHAR = null;
                    public static final Type CLASS = null;
                    public static final Type DOUBLE = null;
                    public static final Type ENUM = null;
                    public static final Type FLOAT = null;
                    public static final Type INT = null;
                    public static final Type LONG = null;
                    public static final Type SHORT = null;
                    public static final Type STRING = null;
                    private static Internal.EnumLiteMap<Type> internalValueMap;
                    private final int value;

                    static {
                        Type r100 = new Type("BYTE", 0, 0, 0);
                        BYTE = r100;
                        Type r101 = new Type("CHAR", 1, 1, 1);
                        CHAR = r101;
                        Type r102 = new Type("SHORT", 2, 2, 2);
                        SHORT = r102;
                        Type r103 = new Type("INT", 3, 3, 3);
                        INT = r103;
                        Type r104 = new Type("LONG", 4, 4, 4);
                        LONG = r104;
                        Type r105 = new Type("FLOAT", 5, 5, 5);
                        FLOAT = r105;
                        Type r110 = new Type("DOUBLE", 6, 6, 6);
                        DOUBLE = r110;
                        Type r111 = new Type("BOOLEAN", 7, 7, 7);
                        BOOLEAN = r111;
                        Type r112 = new Type("STRING", 8, 8, 8);
                        STRING = r112;
                        Type r113 = new Type("CLASS", 9, 9, 9);
                        CLASS = r113;
                        Type r114 = new Type("ENUM", 10, 10, 10);
                        ENUM = r114;
                        Type r115 = new Type("ANNOTATION", 11, 11, 11);
                        ANNOTATION = r115;
                        Type r106 = new Type("ARRAY", 12, 12, 12);
                        ARRAY = r106;
                        $VALUES = new Type[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106};
                        internalValueMap = new AnonymousClass1();
                    }

                    public static Type[] values() {
                        return (Type[]) $VALUES.clone();
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
                    public final int getNumber() {
                        return this.value;
                    }

                    public static Type valueOf(int r100) {
                        switch(r100) {
                            case 0: goto L30;
                            case 1: goto L28;
                            case 2: goto L26;
                            case 3: goto L24;
                            case 4: goto L22;
                            case 5: goto L20;
                            case 6: goto L18;
                            case 7: goto L16;
                            case 8: goto L14;
                            case 9: goto L12;
                            case 10: goto L10;
                            case 11: goto L8;
                            case 12: goto L6;
                            default: goto L3;
                        };
                    L3:
                        return null;
                    L6:
                        return ARRAY;
                    L8:
                        return ANNOTATION;
                    L10:
                        return ENUM;
                    L12:
                        return CLASS;
                    L14:
                        return STRING;
                    L16:
                        return BOOLEAN;
                    L18:
                        return DOUBLE;
                    L20:
                        return FLOAT;
                    L22:
                        return LONG;
                    L24:
                        return INT;
                    L26:
                        return SHORT;
                    L28:
                        return CHAR;
                    L30:
                        return BYTE;
                    }

                    public static Type valueOf(String r100) {
                        return (Type) a.a(Type.class, r100);
                    }

                    private Type(String r100, int r101, int r102, int r103) {
                        super(r100, r101);
                        this.value = r103;
                    }
                }

                static {
                    PARSER = new AnonymousClass1();
                    Value r100 = new Value(true);
                    defaultInstance = r100;
                    r100.initFields();
                }

                private void initFields() {
                    this.type_ = Type.BYTE;
                    this.intValue_ = 0;
                    this.floatValue_ = 0.0f;
                    this.doubleValue_ = AudioStats.AUDIO_AMPLITUDE_NONE;
                    this.stringValue_ = 0;
                    this.classId_ = 0;
                    this.enumValueId_ = 0;
                    this.annotation_ = Annotation.getDefaultInstance();
                    this.arrayElement_ = Collections.emptyList();
                    this.arrayDimensionCount_ = 0;
                    this.flags_ = 0;
                }

                public int getArrayElementCount() {
                    return this.arrayElement_.size();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
                public int getSerializedSize() {
                    int r100 = this.memoizedSerializedSize;
                    if (r100 == (-1)) goto L5;
                    return r100;
                L5:
                    int r101 = 0;
                    if ((this.bitField0_ & 1) != 1) goto L8;
                    int r102 = CodedOutputStream.computeEnumSize(1, this.type_.getNumber()) + 0;
                L10:
                    if ((this.bitField0_ & 2) != 2) goto L13;
                    r102 = r102 + CodedOutputStream.computeSInt64Size(2, this.intValue_);
                L13:
                    if ((this.bitField0_ & 4) != 4) goto L16;
                    r102 = r102 + CodedOutputStream.computeFloatSize(3, this.floatValue_);
                L16:
                    if ((this.bitField0_ & 8) != 8) goto L19;
                    r102 = r102 + CodedOutputStream.computeDoubleSize(4, this.doubleValue_);
                L19:
                    if ((this.bitField0_ & 16) != 16) goto L22;
                    r102 = r102 + CodedOutputStream.computeInt32Size(5, this.stringValue_);
                L22:
                    if ((this.bitField0_ & 32) != 32) goto L25;
                    r102 = r102 + CodedOutputStream.computeInt32Size(6, this.classId_);
                L25:
                    if ((this.bitField0_ & 64) != 64) goto L28;
                    r102 = r102 + CodedOutputStream.computeInt32Size(7, this.enumValueId_);
                L28:
                    if ((this.bitField0_ & 128) != 128) goto L31;
                    r102 = r102 + CodedOutputStream.computeMessageSize(8, this.annotation_);
                L31:
                    if (r101 >= this.arrayElement_.size()) goto L34;
                    r102 = r102 + CodedOutputStream.computeMessageSize(9, (MessageLite) ListProtector.get(this.arrayElement_, r101));
                    r101 = r101 + 1;
                    goto L31
                L34:
                    if ((this.bitField0_ & 512) != 512) goto L37;
                    r102 = r102 + CodedOutputStream.computeInt32Size(10, this.flags_);
                L37:
                    if ((this.bitField0_ & 256) != 256) goto L39;
                    r102 = r102 + CodedOutputStream.computeInt32Size(11, this.arrayDimensionCount_);
                L39:
                    int r103 = r102 + this.unknownFields.size();
                    this.memoizedSerializedSize = r103;
                    return r103;
                L8:
                    r102 = 0;
                    goto L10
                }

                public boolean hasAnnotation() {
                    if ((this.bitField0_ & 128) != 128) goto L5;
                    return true;
                L5:
                    return false;
                }

                public boolean hasArrayDimensionCount() {
                    if ((this.bitField0_ & 256) != 256) goto L5;
                    return true;
                L5:
                    return false;
                }

                public boolean hasClassId() {
                    if ((this.bitField0_ & 32) != 32) goto L5;
                    return true;
                L5:
                    return false;
                }

                public boolean hasDoubleValue() {
                    if ((this.bitField0_ & 8) != 8) goto L5;
                    return true;
                L5:
                    return false;
                }

                public boolean hasEnumValueId() {
                    if ((this.bitField0_ & 64) != 64) goto L5;
                    return true;
                L5:
                    return false;
                }

                public boolean hasFlags() {
                    if ((this.bitField0_ & 512) != 512) goto L5;
                    return true;
                L5:
                    return false;
                }

                public boolean hasFloatValue() {
                    if ((this.bitField0_ & 4) != 4) goto L5;
                    return true;
                L5:
                    return false;
                }

                public boolean hasIntValue() {
                    if ((this.bitField0_ & 2) != 2) goto L5;
                    return true;
                L5:
                    return false;
                }

                public boolean hasStringValue() {
                    if ((this.bitField0_ & 16) != 16) goto L5;
                    return true;
                L5:
                    return false;
                }

                public boolean hasType() {
                    if ((this.bitField0_ & 1) == 1) goto L7;
                    return false;
                L7:
                    return true;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                public final boolean isInitialized() {
                    byte r100 = this.memoizedIsInitialized;
                    if (r100 != 1) goto L6;
                    return true;
                L6:
                    if (r100 != 0) goto L9;
                    return false;
                L9:
                    if (hasAnnotation() == true) goto L11;
                L14:
                    int r101 = 0;
                L16:
                    if (r101 >= getArrayElementCount()) goto L22;
                    if (getArrayElement(r101).isInitialized() == false) goto L19;
                    r101 = r101 + 1;
                    goto L16
                L19:
                    this.memoizedIsInitialized = 0;
                    return false;
                L22:
                    this.memoizedIsInitialized = 1;
                    return true;
                L11:
                    if (getAnnotation().isInitialized() == true) goto L14;
                    this.memoizedIsInitialized = 0;
                    return false;
                }

                public static Builder newBuilder() {
                    return Builder.access$2100();
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

                public static Value getDefaultInstance() {
                    return defaultInstance;
                }

                public Annotation getAnnotation() {
                    return this.annotation_;
                }

                public int getArrayDimensionCount() {
                    return this.arrayDimensionCount_;
                }

                public List<Value> getArrayElementList() {
                    return this.arrayElement_;
                }

                public int getClassId() {
                    return this.classId_;
                }

                public double getDoubleValue() {
                    return this.doubleValue_;
                }

                public int getEnumValueId() {
                    return this.enumValueId_;
                }

                public int getFlags() {
                    return this.flags_;
                }

                public float getFloatValue() {
                    return this.floatValue_;
                }

                public long getIntValue() {
                    return this.intValue_;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
                public Parser<Value> getParserForType() {
                    return PARSER;
                }

                public int getStringValue() {
                    return this.stringValue_;
                }

                public Type getType() {
                    return this.type_;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                public Value getDefaultInstanceForType() {
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

                private Value(GeneratedMessageLite.Builder r100) {
                    super(r100);
                    this.memoizedIsInitialized = -1;
                    this.memoizedSerializedSize = -1;
                    this.unknownFields = r100.getUnknownFields();
                }

                public static /* synthetic */ List access$3100(Value r100) {
                    return r100.arrayElement_;
                }

                public static /* synthetic */ ByteString access$3500(Value r100) {
                    return r100.unknownFields;
                }

                public static Builder newBuilder(Value r100) {
                    return newBuilder().mergeFrom(r100);
                }

                public Value getArrayElement(int r100) {
                    return (Value) ListProtector.get(this.arrayElement_, r100);
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
                public void writeTo(CodedOutputStream r100) throws IOException {
                    getSerializedSize();
                    if ((this.bitField0_ & 1) != 1) goto L6;
                    r100.writeEnum(1, this.type_.getNumber());
                L6:
                    if ((this.bitField0_ & 2) != 2) goto L9;
                    r100.writeSInt64(2, this.intValue_);
                L9:
                    if ((this.bitField0_ & 4) != 4) goto L12;
                    r100.writeFloat(3, this.floatValue_);
                L12:
                    if ((this.bitField0_ & 8) != 8) goto L15;
                    r100.writeDouble(4, this.doubleValue_);
                L15:
                    if ((this.bitField0_ & 16) != 16) goto L18;
                    r100.writeInt32(5, this.stringValue_);
                L18:
                    if ((this.bitField0_ & 32) != 32) goto L21;
                    r100.writeInt32(6, this.classId_);
                L21:
                    if ((this.bitField0_ & 64) != 64) goto L24;
                    r100.writeInt32(7, this.enumValueId_);
                L24:
                    if ((this.bitField0_ & 128) != 128) goto L26;
                    r100.writeMessage(8, this.annotation_);
                L26:
                    int r101 = 0;
                L28:
                    if (r101 >= this.arrayElement_.size()) goto L31;
                    r100.writeMessage(9, (MessageLite) ListProtector.get(this.arrayElement_, r101));
                    r101 = r101 + 1;
                    goto L28
                L31:
                    if ((this.bitField0_ & 512) != 512) goto L34;
                    r100.writeInt32(10, this.flags_);
                L34:
                    if ((this.bitField0_ & 256) != 256) goto L36;
                    r100.writeInt32(11, this.arrayDimensionCount_);
                L36:
                    r100.writeRawBytes(this.unknownFields);
                }

                private Value(boolean r100) {
                    this.memoizedIsInitialized = -1;
                    this.memoizedSerializedSize = -1;
                    this.unknownFields = ByteString.EMPTY;
                }

                private Value(CodedInputStream r110, ExtensionRegistryLite r111) throws InvalidProtocolBufferException {
                    this.memoizedIsInitialized = -1;
                    this.memoizedSerializedSize = -1;
                    initFields();
                    ByteString.Output r100 = ByteString.newOutput();
                    CodedOutputStream r101 = CodedOutputStream.newInstance(r100, 1);
                    boolean r102 = false;
                    int r103 = 0;
                L4:
                    if (r102 == true) goto L55;
                    int r104 = r110.readTag();     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                    switch(r104) {
                        case 0: goto L33;
                        case 8: goto L28;
                        case 16: goto L27;
                        case 29: goto L26;
                        case 33: goto L25;
                        case 40: goto L24;
                        case 48: goto L23;
                        case 56: goto L22;
                        case 66: goto L15;
                        case 74: goto L11;
                        case 80: goto L9;
                        case 88: goto L8;
                        default: goto L34;
                    };     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                L8:
                    this.bitField0_ |= 256;     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                    this.arrayDimensionCount_ = r110.readInt32();     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                    goto L4
                L9:
                    this.bitField0_ |= 512;     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                    this.flags_ = r110.readInt32();     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                    goto L4
                L11:
                    if ((r103 & 256) == 256) goto L13;
                    this.arrayElement_ = new ArrayList();     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                    r103 = r103 | 256;     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                L13:
                    this.arrayElement_.add((Value) r110.readMessage(PARSER, r111));     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                    goto L4
                L15:
                    if ((this.bitField0_ & 128) != 128) goto L17;
                    Builder r105 = this.annotation_.toBuilder();     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                L18:
                    Annotation r106 = (Annotation) r110.readMessage(Annotation.PARSER, r111);     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                    this.annotation_ = r106;     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                    if (r105 == null) goto L21;
                    r105.mergeFrom(r106);     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                    this.annotation_ = r105.buildPartial();     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                L21:
                    this.bitField0_ |= 128;     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                    goto L4
                L17:
                    r105 = null;
                    goto L18
                L22:
                    this.bitField0_ |= 64;     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                    this.enumValueId_ = r110.readInt32();     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                    goto L4
                L23:
                    this.bitField0_ |= 32;     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                    this.classId_ = r110.readInt32();     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                    goto L4
                L24:
                    this.bitField0_ |= 16;     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                    this.stringValue_ = r110.readInt32();     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                    goto L4
                L25:
                    this.bitField0_ |= 8;     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                    this.doubleValue_ = r110.readDouble();     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                    goto L4
                L26:
                    this.bitField0_ |= 4;     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                    this.floatValue_ = r110.readFloat();     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                    goto L4
                L27:
                    this.bitField0_ |= 2;     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                    this.intValue_ = r110.readSInt64();     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                    goto L4
                L28:
                    int r107 = r110.readEnum();     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                    Type r108 = Type.valueOf(r107);     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                    if (r108 == null) goto L30;
                    this.bitField0_ |= 1;     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                    this.type_ = r108;     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                    goto L4
                L30:
                    r101.writeRawVarint32(r104);     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                    r101.writeRawVarint32(r107);     // Catch: Throwable -> L36 IOException -> L38 InvalidProtocolBufferException -> L41
                L33:
                    r102 = true;
                    goto L4
                L34:
                    if (parseUnknownField(r110, r101, r111, r104) == true) goto L4;
                L36:
                    th = move-exception;
                    if ((r103 & 256) != 256) goto L68;
                    this.arrayElement_ = Collections.unmodifiableList(this.arrayElement_);
                L68:
                    r101.flush();     // Catch: IOException -> L65 Throwable -> L49
                L49:
                    th = move-exception;
                    this.unknownFields = r100.toByteString();
                    throw th;
                L48:
                    this.unknownFields = r100.toByteString();
                    makeExtensionsImmutable();
                    throw th;
                L41:
                    e = move-exception;
                    throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L36
                L38:
                    e = move-exception;
                    throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L36
                L55:
                    if ((r103 & 256) != 256) goto L70;
                    this.arrayElement_ = Collections.unmodifiableList(this.arrayElement_);
                L70:
                    r101.flush();     // Catch: IOException -> L64 Throwable -> L59
                L59:
                    th = move-exception;
                    this.unknownFields = r100.toByteString();
                    throw th;
                L58:
                    this.unknownFields = r100.toByteString();
                    makeExtensionsImmutable();
                }

                public static /* synthetic */ Type access$2302(Value r100, Type r101) {
                    r100.type_ = r101;
                    return r101;
                }

                public static /* synthetic */ long access$2402(Value r100, long r101) {
                    r100.intValue_ = r101;
                    return r101;
                }

                public static /* synthetic */ float access$2502(Value r100, float r101) {
                    r100.floatValue_ = r101;
                    return r101;
                }

                public static /* synthetic */ double access$2602(Value r100, double r101) {
                    r100.doubleValue_ = r101;
                    return r101;
                }

                public static /* synthetic */ int access$2702(Value r100, int r101) {
                    r100.stringValue_ = r101;
                    return r101;
                }

                public static /* synthetic */ int access$2802(Value r100, int r101) {
                    r100.classId_ = r101;
                    return r101;
                }

                public static /* synthetic */ int access$2902(Value r100, int r101) {
                    r100.enumValueId_ = r101;
                    return r101;
                }

                public static /* synthetic */ Annotation access$3002(Value r100, Annotation r101) {
                    r100.annotation_ = r101;
                    return r101;
                }

                public static /* synthetic */ List access$3102(Value r100, List r101) {
                    r100.arrayElement_ = r101;
                    return r101;
                }

                public static /* synthetic */ int access$3202(Value r100, int r101) {
                    r100.arrayDimensionCount_ = r101;
                    return r101;
                }

                public static /* synthetic */ int access$3302(Value r100, int r101) {
                    r100.flags_ = r101;
                    return r101;
                }

                public static /* synthetic */ int access$3402(Value r100, int r101) {
                    r100.bitField0_ = r101;
                    return r101;
                }

                public /* synthetic */ Value(GeneratedMessageLite.Builder r100, AnonymousClass1 r101) {
                    this(r100);
                }

                public /* synthetic */ Value(CodedInputStream r100, ExtensionRegistryLite r101, AnonymousClass1 r102) throws InvalidProtocolBufferException {
                    this(r100, r101);
                }
            }

            public interface ValueOrBuilder extends MessageLiteOrBuilder {
            }

            private void initFields() {
                this.nameId_ = 0;
                this.value_ = Value.getDefaultInstance();
            }

            static {
                PARSER = new AnonymousClass1();
                Argument r100 = new Argument(true);
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
                r101 = 0 + CodedOutputStream.computeInt32Size(1, this.nameId_);
            L9:
                if ((this.bitField0_ & 2) != 2) goto L11;
                r101 = r101 + CodedOutputStream.computeMessageSize(2, this.value_);
            L11:
                int r102 = r101 + this.unknownFields.size();
                this.memoizedSerializedSize = r102;
                return r102;
            }

            public boolean hasNameId() {
                if ((this.bitField0_ & 1) == 1) goto L7;
                return false;
            L7:
                return true;
            }

            public boolean hasValue() {
                if ((this.bitField0_ & 2) != 2) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                byte r100 = this.memoizedIsInitialized;
                if (r100 != 1) goto L6;
                return true;
            L6:
                if (r100 != 0) goto L9;
                return false;
            L9:
                if (hasNameId() == true) goto L13;
                this.memoizedIsInitialized = 0;
                return false;
            L13:
                if (hasValue() == true) goto L17;
                this.memoizedIsInitialized = 0;
                return false;
            L17:
                if (getValue().isInitialized() == true) goto L20;
                this.memoizedIsInitialized = 0;
                return false;
            L20:
                this.memoizedIsInitialized = 1;
                return true;
            }

            public static Builder newBuilder() {
                return Builder.access$3600();
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

            public static Argument getDefaultInstance() {
                return defaultInstance;
            }

            public int getNameId() {
                return this.nameId_;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public Parser<Argument> getParserForType() {
                return PARSER;
            }

            public Value getValue() {
                return this.value_;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public Argument getDefaultInstanceForType() {
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

            private Argument(GeneratedMessageLite.Builder r100) {
                super(r100);
                this.memoizedIsInitialized = -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = r100.getUnknownFields();
            }

            public static /* synthetic */ ByteString access$4100(Argument r100) {
                return r100.unknownFields;
            }

            public static Builder newBuilder(Argument r100) {
                return newBuilder().mergeFrom(r100);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public void writeTo(CodedOutputStream r100) throws IOException {
                getSerializedSize();
                if ((this.bitField0_ & 1) != 1) goto L6;
                r100.writeInt32(1, this.nameId_);
            L6:
                if ((this.bitField0_ & 2) != 2) goto L8;
                r100.writeMessage(2, this.value_);
            L8:
                r100.writeRawBytes(this.unknownFields);
            }

            private Argument(boolean r100) {
                this.memoizedIsInitialized = -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = ByteString.EMPTY;
            }

            private Argument(CodedInputStream r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
                this.memoizedIsInitialized = -1;
                this.memoizedSerializedSize = -1;
                initFields();
                ByteString.Output r102 = ByteString.newOutput();
                CodedOutputStream r103 = CodedOutputStream.newInstance(r102, 1);
                boolean r104 = false;
            L3:
                if (r104 == true) goto L52;
                int r105 = r100.readTag();     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L29
                if (r105 == 0) goto L23;
                if (r105 != 8) goto L9;
                this.bitField0_ |= 1;     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L29
                this.nameId_ = r100.readInt32();     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L29
                goto L3
            L9:
                if (r105 != 18) goto L11;
                if ((this.bitField0_ & 2) != 2) goto L16;
                Value.Builder r106 = this.value_.toBuilder();     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L29
            L17:
                Value r107 = (Value) r100.readMessage(Value.PARSER, r101);     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L29
                this.value_ = r107;     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L29
                if (r106 == null) goto L20;
                r106.mergeFrom(r107);     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L29
                this.value_ = r106.buildPartial();     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L29
            L20:
                this.bitField0_ |= 2;     // Catch: Throwable -> L24 IOException -> L26 InvalidProtocolBufferException -> L29
                goto L3
            L16:
                r106 = null;
                goto L17
            L11:
                if (parseUnknownField(r100, r103, r101, r105) == true) goto L3;
            L23:
                r104 = true;
                goto L3
            L24:
                th = move-exception;
                r103.flush();     // Catch: IOException -> L46 Throwable -> L34
            L34:
                th = move-exception;
                this.unknownFields = r102.toByteString();
                throw th;
            L33:
                this.unknownFields = r102.toByteString();
                makeExtensionsImmutable();
                throw th;
            L26:
                e = move-exception;
                throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L24
            L29:
                e = move-exception;
                throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L24
            L52:
                r103.flush();     // Catch: IOException -> L47 Throwable -> L41
            L41:
                th = move-exception;
                this.unknownFields = r102.toByteString();
                throw th;
            L40:
                this.unknownFields = r102.toByteString();
                makeExtensionsImmutable();
            }

            public static /* synthetic */ int access$3802(Argument r100, int r101) {
                r100.nameId_ = r101;
                return r101;
            }

            public static /* synthetic */ Value access$3902(Argument r100, Value r101) {
                r100.value_ = r101;
                return r101;
            }

            public static /* synthetic */ int access$4002(Argument r100, int r101) {
                r100.bitField0_ = r101;
                return r101;
            }

            public /* synthetic */ Argument(GeneratedMessageLite.Builder r100, AnonymousClass1 r101) {
                this(r100);
            }

            public /* synthetic */ Argument(CodedInputStream r100, ExtensionRegistryLite r101, AnonymousClass1 r102) throws InvalidProtocolBufferException {
                this(r100, r101);
            }
        }

        public interface ArgumentOrBuilder extends MessageLiteOrBuilder {
        }

        public static final class Builder extends GeneratedMessageLite.Builder<Annotation, Builder> implements AnnotationOrBuilder {
            private List<Argument> argument_;
            private int bitField0_;
            private int id_;

            private void maybeForceBuilderInitialization() {
            }

            private static Builder create() {
                return new Builder();
            }

            private void ensureArgumentIsMutable() {
                if ((this.bitField0_ & 2) == 2) goto L6;
                this.argument_ = new ArrayList(this.argument_);
                this.bitField0_ |= 2;
                return;
            }

            public Annotation buildPartial() {
                Annotation r100 = new Annotation(this, null);
                int r101 = 1;
                if ((this.bitField0_ & 1) == 1) goto L6;
                r101 = 0;
            L6:
                Annotation.access$4402(r100, this.id_);
                if ((this.bitField0_ & 2) != 2) goto L9;
                this.argument_ = Collections.unmodifiableList(this.argument_);
                this.bitField0_ &= -3;
            L9:
                Annotation.access$4502(r100, this.argument_);
                Annotation.access$4602(r100, r101);
                return r100;
            }

            public int getArgumentCount() {
                return this.argument_.size();
            }

            public boolean hasId() {
                if ((this.bitField0_ & 1) == 1) goto L7;
                return false;
            L7:
                return true;
            }

            private Builder() {
                this.argument_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            public static /* synthetic */ Builder access$4200() {
                return create();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Annotation build() {
                Annotation r100 = buildPartial();
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
            public Annotation getDefaultInstanceForType() {
                return Annotation.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                if (hasId() == true) goto L5;
                return false;
            L5:
                int r100 = 0;
            L7:
                if (r100 >= getArgumentCount()) goto L12;
                if (getArgument(r100).isInitialized() == false) goto L10;
                r100 = r100 + 1;
                goto L7
            L10:
                return false;
            L12:
                return true;
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

            public Argument getArgument(int r100) {
                return (Argument) ListProtector.get(this.argument_, r100);
            }

            public Builder mergeFrom(Annotation r100) {
                if (r100 != Annotation.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r100.hasId() == false) goto L9;
                setId(r100.getId());
            L9:
                if (Annotation.access$4500(r100).isEmpty() == false) goto L11;
            L14:
                setUnknownFields(getUnknownFields().concat(Annotation.access$4700(r100)));
                return this;
            L11:
                if (this.argument_.isEmpty() == false) goto L13;
                this.argument_ = Annotation.access$4500(r100);
                this.bitField0_ &= -3;
                goto L14
            L13:
                ensureArgumentIsMutable();
                this.argument_.addAll(Annotation.access$4500(r100));
                goto L14
            }

            public Builder setId(int r100) {
                this.bitField0_ |= 1;
                this.id_ = r100;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r100) {
                return mergeFrom((Annotation) r100);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
                Annotation r102 = null;
                Annotation r103 = Annotation.PARSER.parsePartialFrom(r100, r101);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r103 == null) goto L6;
                mergeFrom(r103);
            L6:
                return this;
            L9:
                e = move-exception;
                Annotation r104 = (Annotation) e.getUnfinishedMessage();     // Catch: Throwable -> L7
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
            this.id_ = 0;
            this.argument_ = Collections.emptyList();
        }

        static {
            PARSER = new AnonymousClass1();
            Annotation r100 = new Annotation(true);
            defaultInstance = r100;
            r100.initFields();
        }

        public int getArgumentCount() {
            return this.argument_.size();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int r100 = this.memoizedSerializedSize;
            if (r100 == (-1)) goto L5;
            return r100;
        L5:
            int r101 = 0;
            if ((this.bitField0_ & 1) != 1) goto L8;
            int r102 = CodedOutputStream.computeInt32Size(1, this.id_) + 0;
        L10:
            if (r101 >= this.argument_.size()) goto L12;
            r102 = r102 + CodedOutputStream.computeMessageSize(2, (MessageLite) ListProtector.get(this.argument_, r101));
            r101 = r101 + 1;
            goto L10
        L12:
            int r103 = r102 + this.unknownFields.size();
            this.memoizedSerializedSize = r103;
            return r103;
        L8:
            r102 = 0;
            goto L10
        }

        public boolean hasId() {
            if ((this.bitField0_ & 1) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte r100 = this.memoizedIsInitialized;
            if (r100 != 1) goto L6;
            return true;
        L6:
            if (r100 != 0) goto L9;
            return false;
        L9:
            if (hasId() == true) goto L12;
            this.memoizedIsInitialized = 0;
            return false;
        L12:
            int r101 = 0;
        L14:
            if (r101 >= getArgumentCount()) goto L20;
            if (getArgument(r101).isInitialized() == false) goto L17;
            r101 = r101 + 1;
            goto L14
        L17:
            this.memoizedIsInitialized = 0;
            return false;
        L20:
            this.memoizedIsInitialized = 1;
            return true;
        }

        public static Builder newBuilder() {
            return Builder.access$4200();
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

        public static Annotation getDefaultInstance() {
            return defaultInstance;
        }

        public List<Argument> getArgumentList() {
            return this.argument_;
        }

        public int getId() {
            return this.id_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<Annotation> getParserForType() {
            return PARSER;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public Annotation getDefaultInstanceForType() {
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

        private Annotation(GeneratedMessageLite.Builder r100) {
            super(r100);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r100.getUnknownFields();
        }

        public static /* synthetic */ List access$4500(Annotation r100) {
            return r100.argument_;
        }

        public static /* synthetic */ ByteString access$4700(Annotation r100) {
            return r100.unknownFields;
        }

        public static Builder newBuilder(Annotation r100) {
            return newBuilder().mergeFrom(r100);
        }

        public Argument getArgument(int r100) {
            return (Argument) ListProtector.get(this.argument_, r100);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r100) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) != 1) goto L5;
            r100.writeInt32(1, this.id_);
        L5:
            int r101 = 0;
        L7:
            if (r101 >= this.argument_.size()) goto L9;
            r100.writeMessage(2, (MessageLite) ListProtector.get(this.argument_, r101));
            r101 = r101 + 1;
            goto L7
        L9:
            r100.writeRawBytes(this.unknownFields);
        }

        private Annotation(boolean r100) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        private Annotation(CodedInputStream r100, ExtensionRegistryLite r110) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r101 = ByteString.newOutput();
            CodedOutputStream r102 = CodedOutputStream.newInstance(r101, 1);
            boolean r103 = false;
            int r104 = 0;
        L4:
            if (r103 == true) goto L40;
            int r105 = r100.readTag();     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L26
            if (r105 == 0) goto L20;
            if (r105 != 8) goto L10;
            this.bitField0_ |= 1;     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L26
            this.id_ = r100.readInt32();     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L26
            goto L4
        L10:
            if (r105 != 18) goto L12;
            if ((r104 & 2) == 2) goto L17;
            this.argument_ = new ArrayList();     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L26
            r104 = r104 | 2;     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L26
        L17:
            this.argument_.add((Argument) r100.readMessage(Argument.PARSER, r110));     // Catch: Throwable -> L21 IOException -> L23 InvalidProtocolBufferException -> L26
            goto L4
        L12:
            if (parseUnknownField(r100, r102, r110, r105) == true) goto L4;
        L20:
            r103 = true;
            goto L4
        L21:
            th = move-exception;
            if ((r104 & 2) != 2) goto L52;
            this.argument_ = Collections.unmodifiableList(this.argument_);
        L52:
            r102.flush();     // Catch: IOException -> L50 Throwable -> L34
        L34:
            th = move-exception;
            this.unknownFields = r101.toByteString();
            throw th;
        L33:
            this.unknownFields = r101.toByteString();
            makeExtensionsImmutable();
            throw th;
        L26:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L21
        L23:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L21
        L40:
            if ((r104 & 2) != 2) goto L55;
            this.argument_ = Collections.unmodifiableList(this.argument_);
        L55:
            r102.flush();     // Catch: IOException -> L49 Throwable -> L44
        L44:
            th = move-exception;
            this.unknownFields = r101.toByteString();
            throw th;
        L43:
            this.unknownFields = r101.toByteString();
            makeExtensionsImmutable();
        }

        public static /* synthetic */ int access$4402(Annotation r100, int r101) {
            r100.id_ = r101;
            return r101;
        }

        public static /* synthetic */ List access$4502(Annotation r100, List r101) {
            r100.argument_ = r101;
            return r101;
        }

        public static /* synthetic */ int access$4602(Annotation r100, int r101) {
            r100.bitField0_ = r101;
            return r101;
        }

        public /* synthetic */ Annotation(GeneratedMessageLite.Builder r100, AnonymousClass1 r101) {
            this(r100);
        }

        public /* synthetic */ Annotation(CodedInputStream r100, ExtensionRegistryLite r101, AnonymousClass1 r102) throws InvalidProtocolBufferException {
            this(r100, r101);
        }
    }

    /* JADX INFO: loaded from: classes5.dex */
    public interface AnnotationOrBuilder extends MessageLiteOrBuilder {
    }

    /* JADX INFO: loaded from: classes5.dex */
    public static final class Class extends GeneratedMessageLite.ExtendableMessage<Class> implements ClassOrBuilder {
        public static Parser<Class> PARSER;
        private static final Class defaultInstance = null;
        private int bitField0_;
        private int companionObjectName_;
        private List<Constructor> constructor_;
        private int contextReceiverTypeIdMemoizedSerializedSize;
        private List<Integer> contextReceiverTypeId_;
        private List<Type> contextReceiverType_;
        private List<EnumEntry> enumEntry_;
        private int flags_;
        private int fqName_;
        private List<Function> function_;
        private int inlineClassUnderlyingPropertyName_;
        private int inlineClassUnderlyingTypeId_;
        private Type inlineClassUnderlyingType_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int multiFieldValueClassUnderlyingNameMemoizedSerializedSize;
        private List<Integer> multiFieldValueClassUnderlyingName_;
        private int multiFieldValueClassUnderlyingTypeIdMemoizedSerializedSize;
        private List<Integer> multiFieldValueClassUnderlyingTypeId_;
        private List<Type> multiFieldValueClassUnderlyingType_;
        private int nestedClassNameMemoizedSerializedSize;
        private List<Integer> nestedClassName_;
        private List<Property> property_;
        private int sealedSubclassFqNameMemoizedSerializedSize;
        private List<Integer> sealedSubclassFqName_;
        private int supertypeIdMemoizedSerializedSize;
        private List<Integer> supertypeId_;
        private List<Type> supertype_;
        private List<TypeAlias> typeAlias_;
        private List<TypeParameter> typeParameter_;
        private TypeTable typeTable_;
        private final ByteString unknownFields;
        private VersionRequirementTable versionRequirementTable_;
        private List<Integer> versionRequirement_;

        /* JADX INFO: loaded from: classes42.dex */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<Class, Builder> implements ClassOrBuilder {
            private int bitField0_;
            private int companionObjectName_;
            private List<Constructor> constructor_;
            private List<Integer> contextReceiverTypeId_;
            private List<Type> contextReceiverType_;
            private List<EnumEntry> enumEntry_;
            private int flags_;
            private int fqName_;
            private List<Function> function_;
            private int inlineClassUnderlyingPropertyName_;
            private int inlineClassUnderlyingTypeId_;
            private Type inlineClassUnderlyingType_;
            private List<Integer> multiFieldValueClassUnderlyingName_;
            private List<Integer> multiFieldValueClassUnderlyingTypeId_;
            private List<Type> multiFieldValueClassUnderlyingType_;
            private List<Integer> nestedClassName_;
            private List<Property> property_;
            private List<Integer> sealedSubclassFqName_;
            private List<Integer> supertypeId_;
            private List<Type> supertype_;
            private List<TypeAlias> typeAlias_;
            private List<TypeParameter> typeParameter_;
            private TypeTable typeTable_;
            private VersionRequirementTable versionRequirementTable_;
            private List<Integer> versionRequirement_;

            private void maybeForceBuilderInitialization() {
            }

            private static Builder create() {
                return new Builder();
            }

            private void ensureConstructorIsMutable() {
                if ((this.bitField0_ & 512) == 512) goto L6;
                this.constructor_ = new ArrayList(this.constructor_);
                this.bitField0_ |= 512;
                return;
            }

            private void ensureContextReceiverTypeIdIsMutable() {
                if ((this.bitField0_ & 256) == 256) goto L6;
                this.contextReceiverTypeId_ = new ArrayList(this.contextReceiverTypeId_);
                this.bitField0_ |= 256;
                return;
            }

            private void ensureContextReceiverTypeIsMutable() {
                if ((this.bitField0_ & 128) == 128) goto L6;
                this.contextReceiverType_ = new ArrayList(this.contextReceiverType_);
                this.bitField0_ |= 128;
                return;
            }

            private void ensureEnumEntryIsMutable() {
                if ((this.bitField0_ & 8192) == 8192) goto L6;
                this.enumEntry_ = new ArrayList(this.enumEntry_);
                this.bitField0_ |= 8192;
                return;
            }

            private void ensureFunctionIsMutable() {
                if ((this.bitField0_ & 1024) == 1024) goto L6;
                this.function_ = new ArrayList(this.function_);
                this.bitField0_ |= 1024;
                return;
            }

            private void ensureMultiFieldValueClassUnderlyingNameIsMutable() {
                if ((this.bitField0_ & 262144) == 262144) goto L6;
                this.multiFieldValueClassUnderlyingName_ = new ArrayList(this.multiFieldValueClassUnderlyingName_);
                this.bitField0_ |= 262144;
                return;
            }

            private void ensureMultiFieldValueClassUnderlyingTypeIdIsMutable() {
                if ((this.bitField0_ & 1048576) == 1048576) goto L6;
                this.multiFieldValueClassUnderlyingTypeId_ = new ArrayList(this.multiFieldValueClassUnderlyingTypeId_);
                this.bitField0_ |= 1048576;
                return;
            }

            private void ensureMultiFieldValueClassUnderlyingTypeIsMutable() {
                if ((this.bitField0_ & 524288) == 524288) goto L6;
                this.multiFieldValueClassUnderlyingType_ = new ArrayList(this.multiFieldValueClassUnderlyingType_);
                this.bitField0_ |= 524288;
                return;
            }

            private void ensureNestedClassNameIsMutable() {
                if ((this.bitField0_ & 64) == 64) goto L6;
                this.nestedClassName_ = new ArrayList(this.nestedClassName_);
                this.bitField0_ |= 64;
                return;
            }

            private void ensurePropertyIsMutable() {
                if ((this.bitField0_ & 2048) == 2048) goto L6;
                this.property_ = new ArrayList(this.property_);
                this.bitField0_ |= 2048;
                return;
            }

            private void ensureSealedSubclassFqNameIsMutable() {
                if ((this.bitField0_ & 16384) == 16384) goto L6;
                this.sealedSubclassFqName_ = new ArrayList(this.sealedSubclassFqName_);
                this.bitField0_ |= 16384;
                return;
            }

            private void ensureSupertypeIdIsMutable() {
                if ((this.bitField0_ & 32) == 32) goto L6;
                this.supertypeId_ = new ArrayList(this.supertypeId_);
                this.bitField0_ |= 32;
                return;
            }

            private void ensureSupertypeIsMutable() {
                if ((this.bitField0_ & 16) == 16) goto L6;
                this.supertype_ = new ArrayList(this.supertype_);
                this.bitField0_ |= 16;
                return;
            }

            private void ensureTypeAliasIsMutable() {
                if ((this.bitField0_ & 4096) == 4096) goto L6;
                this.typeAlias_ = new ArrayList(this.typeAlias_);
                this.bitField0_ |= 4096;
                return;
            }

            private void ensureTypeParameterIsMutable() {
                if ((this.bitField0_ & 8) == 8) goto L6;
                this.typeParameter_ = new ArrayList(this.typeParameter_);
                this.bitField0_ |= 8;
                return;
            }

            private void ensureVersionRequirementIsMutable() {
                if ((this.bitField0_ & 4194304) == 4194304) goto L6;
                this.versionRequirement_ = new ArrayList(this.versionRequirement_);
                this.bitField0_ |= 4194304;
                return;
            }

            public Class buildPartial() {
                Class r100 = new Class(this, null);
                int r101 = this.bitField0_;
                int r102 = 1;
                if ((r101 & 1) == 1) goto L6;
                r102 = 0;
            L6:
                Class.access$8902(r100, this.flags_);
                if ((r101 & 2) != 2) goto L9;
                r102 = r102 | 2;
            L9:
                Class.access$9002(r100, this.fqName_);
                if ((r101 & 4) != 4) goto L12;
                r102 = r102 | 4;
            L12:
                Class.access$9102(r100, this.companionObjectName_);
                if ((this.bitField0_ & 8) != 8) goto L15;
                this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                this.bitField0_ &= -9;
            L15:
                Class.access$9202(r100, this.typeParameter_);
                if ((this.bitField0_ & 16) != 16) goto L18;
                this.supertype_ = Collections.unmodifiableList(this.supertype_);
                this.bitField0_ &= -17;
            L18:
                Class.access$9302(r100, this.supertype_);
                if ((this.bitField0_ & 32) != 32) goto L21;
                this.supertypeId_ = Collections.unmodifiableList(this.supertypeId_);
                this.bitField0_ &= -33;
            L21:
                Class.access$9402(r100, this.supertypeId_);
                if ((this.bitField0_ & 64) != 64) goto L24;
                this.nestedClassName_ = Collections.unmodifiableList(this.nestedClassName_);
                this.bitField0_ &= -65;
            L24:
                Class.access$9502(r100, this.nestedClassName_);
                if ((this.bitField0_ & 128) != 128) goto L27;
                this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
                this.bitField0_ &= -129;
            L27:
                Class.access$9602(r100, this.contextReceiverType_);
                if ((this.bitField0_ & 256) != 256) goto L30;
                this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
                this.bitField0_ &= -257;
            L30:
                Class.access$9702(r100, this.contextReceiverTypeId_);
                if ((this.bitField0_ & 512) != 512) goto L33;
                this.constructor_ = Collections.unmodifiableList(this.constructor_);
                this.bitField0_ &= NetError.ERR_TTNET_FT_INVALID_STREAM;
            L33:
                Class.access$9802(r100, this.constructor_);
                if ((this.bitField0_ & 1024) != 1024) goto L36;
                this.function_ = Collections.unmodifiableList(this.function_);
                this.bitField0_ &= -1025;
            L36:
                Class.access$9902(r100, this.function_);
                if ((this.bitField0_ & 2048) != 2048) goto L39;
                this.property_ = Collections.unmodifiableList(this.property_);
                this.bitField0_ &= -2049;
            L39:
                Class.access$10002(r100, this.property_);
                if ((this.bitField0_ & 4096) != 4096) goto L42;
                this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
                this.bitField0_ &= -4097;
            L42:
                Class.access$10102(r100, this.typeAlias_);
                if ((this.bitField0_ & 8192) != 8192) goto L45;
                this.enumEntry_ = Collections.unmodifiableList(this.enumEntry_);
                this.bitField0_ &= -8193;
            L45:
                Class.access$10202(r100, this.enumEntry_);
                if ((this.bitField0_ & 16384) != 16384) goto L48;
                this.sealedSubclassFqName_ = Collections.unmodifiableList(this.sealedSubclassFqName_);
                this.bitField0_ &= -16385;
            L48:
                Class.access$10302(r100, this.sealedSubclassFqName_);
                if ((r101 & 32768) != 32768) goto L51;
                r102 = r102 | 8;
            L51:
                Class.access$10402(r100, this.inlineClassUnderlyingPropertyName_);
                if ((r101 & 65536) != 65536) goto L54;
                r102 = r102 | 16;
            L54:
                Class.access$10502(r100, this.inlineClassUnderlyingType_);
                if ((r101 & 131072) != 131072) goto L57;
                r102 = r102 | 32;
            L57:
                Class.access$10602(r100, this.inlineClassUnderlyingTypeId_);
                if ((this.bitField0_ & 262144) != 262144) goto L60;
                this.multiFieldValueClassUnderlyingName_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingName_);
                this.bitField0_ &= -262145;
            L60:
                Class.access$10702(r100, this.multiFieldValueClassUnderlyingName_);
                if ((this.bitField0_ & 524288) != 524288) goto L63;
                this.multiFieldValueClassUnderlyingType_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingType_);
                this.bitField0_ &= -524289;
            L63:
                Class.access$10802(r100, this.multiFieldValueClassUnderlyingType_);
                if ((this.bitField0_ & 1048576) != 1048576) goto L66;
                this.multiFieldValueClassUnderlyingTypeId_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingTypeId_);
                this.bitField0_ &= -1048577;
            L66:
                Class.access$10902(r100, this.multiFieldValueClassUnderlyingTypeId_);
                if ((r101 & 2097152) != 2097152) goto L69;
                r102 = r102 | 64;
            L69:
                Class.access$11002(r100, this.typeTable_);
                if ((this.bitField0_ & 4194304) != 4194304) goto L72;
                this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                this.bitField0_ &= -4194305;
            L72:
                Class.access$11102(r100, this.versionRequirement_);
                if ((r101 & 8388608) != 8388608) goto L75;
                r102 = r102 | 128;
            L75:
                Class.access$11202(r100, this.versionRequirementTable_);
                Class.access$11302(r100, r102);
                return r100;
            }

            public int getConstructorCount() {
                return this.constructor_.size();
            }

            public int getContextReceiverTypeCount() {
                return this.contextReceiverType_.size();
            }

            public int getEnumEntryCount() {
                return this.enumEntry_.size();
            }

            public int getFunctionCount() {
                return this.function_.size();
            }

            public int getMultiFieldValueClassUnderlyingTypeCount() {
                return this.multiFieldValueClassUnderlyingType_.size();
            }

            public int getPropertyCount() {
                return this.property_.size();
            }

            public int getSupertypeCount() {
                return this.supertype_.size();
            }

            public int getTypeAliasCount() {
                return this.typeAlias_.size();
            }

            public int getTypeParameterCount() {
                return this.typeParameter_.size();
            }

            public boolean hasFqName() {
                if ((this.bitField0_ & 2) != 2) goto L5;
                return true;
            L5:
                return false;
            }

            public boolean hasInlineClassUnderlyingType() {
                if ((this.bitField0_ & 65536) != 65536) goto L5;
                return true;
            L5:
                return false;
            }

            public boolean hasTypeTable() {
                if ((this.bitField0_ & 2097152) != 2097152) goto L5;
                return true;
            L5:
                return false;
            }

            private Builder() {
                this.flags_ = 6;
                this.typeParameter_ = Collections.emptyList();
                this.supertype_ = Collections.emptyList();
                this.supertypeId_ = Collections.emptyList();
                this.nestedClassName_ = Collections.emptyList();
                this.contextReceiverType_ = Collections.emptyList();
                this.contextReceiverTypeId_ = Collections.emptyList();
                this.constructor_ = Collections.emptyList();
                this.function_ = Collections.emptyList();
                this.property_ = Collections.emptyList();
                this.typeAlias_ = Collections.emptyList();
                this.enumEntry_ = Collections.emptyList();
                this.sealedSubclassFqName_ = Collections.emptyList();
                this.inlineClassUnderlyingType_ = Type.getDefaultInstance();
                this.multiFieldValueClassUnderlyingName_ = Collections.emptyList();
                this.multiFieldValueClassUnderlyingType_ = Collections.emptyList();
                this.multiFieldValueClassUnderlyingTypeId_ = Collections.emptyList();
                this.typeTable_ = TypeTable.getDefaultInstance();
                this.versionRequirement_ = Collections.emptyList();
                this.versionRequirementTable_ = VersionRequirementTable.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            public static /* synthetic */ Builder access$8700() {
                return create();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Class build() {
                Class r100 = buildPartial();
                if (r100.isInitialized() == false) goto L6;
                return r100;
            L6:
                throw AbstractMessageLite.Builder.newUninitializedMessageException(r100);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public Class getDefaultInstanceForType() {
                return Class.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                if (hasFqName() == true) goto L5;
                return false;
            L5:
                int r100 = 0;
            L7:
                if (r100 >= getTypeParameterCount()) goto L12;
                if (getTypeParameter(r100).isInitialized() == false) goto L10;
                r100 = r100 + 1;
                goto L7
            L10:
                return false;
            L12:
                int r101 = 0;
            L14:
                if (r101 >= getSupertypeCount()) goto L19;
                if (getSupertype(r101).isInitialized() == false) goto L17;
                r101 = r101 + 1;
                goto L14
            L17:
                return false;
            L19:
                int r102 = 0;
            L21:
                if (r102 >= getContextReceiverTypeCount()) goto L26;
                if (getContextReceiverType(r102).isInitialized() == false) goto L24;
                r102 = r102 + 1;
                goto L21
            L24:
                return false;
            L26:
                int r103 = 0;
            L28:
                if (r103 >= getConstructorCount()) goto L33;
                if (getConstructor(r103).isInitialized() == false) goto L31;
                r103 = r103 + 1;
                goto L28
            L31:
                return false;
            L33:
                int r104 = 0;
            L35:
                if (r104 >= getFunctionCount()) goto L40;
                if (getFunction(r104).isInitialized() == false) goto L38;
                r104 = r104 + 1;
                goto L35
            L38:
                return false;
            L40:
                int r105 = 0;
            L42:
                if (r105 >= getPropertyCount()) goto L47;
                if (getProperty(r105).isInitialized() == false) goto L45;
                r105 = r105 + 1;
                goto L42
            L45:
                return false;
            L47:
                int r106 = 0;
            L49:
                if (r106 >= getTypeAliasCount()) goto L54;
                if (getTypeAlias(r106).isInitialized() == false) goto L52;
                r106 = r106 + 1;
                goto L49
            L52:
                return false;
            L54:
                int r107 = 0;
            L56:
                if (r107 >= getEnumEntryCount()) goto L62;
                if (getEnumEntry(r107).isInitialized() == false) goto L59;
                r107 = r107 + 1;
                goto L56
            L59:
                return false;
            L62:
                if (hasInlineClassUnderlyingType() == true) goto L64;
            L66:
                int r108 = 0;
            L68:
                if (r108 >= getMultiFieldValueClassUnderlyingTypeCount()) goto L74;
                if (getMultiFieldValueClassUnderlyingType(r108).isInitialized() == false) goto L71;
                r108 = r108 + 1;
                goto L68
            L71:
                return false;
            L74:
                if (hasTypeTable() == false) goto L79;
                if (getTypeTable().isInitialized() == true) goto L79;
                return false;
            L79:
                if (extensionsAreInitialized() == true) goto L81;
                return false;
            L81:
                return true;
            L64:
                if (getInlineClassUnderlyingType().isInitialized() == true) goto L66;
                return false;
            }

            public Type getInlineClassUnderlyingType() {
                return this.inlineClassUnderlyingType_;
            }

            public TypeTable getTypeTable() {
                return this.typeTable_;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo10730clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.ExtendableBuilder clone() {
                return clone();
            }

            public Constructor getConstructor(int r100) {
                return (Constructor) ListProtector.get(this.constructor_, r100);
            }

            public Type getContextReceiverType(int r100) {
                return (Type) ListProtector.get(this.contextReceiverType_, r100);
            }

            public EnumEntry getEnumEntry(int r100) {
                return (EnumEntry) ListProtector.get(this.enumEntry_, r100);
            }

            public Function getFunction(int r100) {
                return (Function) ListProtector.get(this.function_, r100);
            }

            public Type getMultiFieldValueClassUnderlyingType(int r100) {
                return (Type) ListProtector.get(this.multiFieldValueClassUnderlyingType_, r100);
            }

            public Property getProperty(int r100) {
                return (Property) ListProtector.get(this.property_, r100);
            }

            public Type getSupertype(int r100) {
                return (Type) ListProtector.get(this.supertype_, r100);
            }

            public TypeAlias getTypeAlias(int r100) {
                return (TypeAlias) ListProtector.get(this.typeAlias_, r100);
            }

            public TypeParameter getTypeParameter(int r100) {
                return (TypeParameter) ListProtector.get(this.typeParameter_, r100);
            }

            public Builder mergeFrom(Class r100) {
                if (r100 != Class.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r100.hasFlags() == false) goto L9;
                setFlags(r100.getFlags());
            L9:
                if (r100.hasFqName() == false) goto L12;
                setFqName(r100.getFqName());
            L12:
                if (r100.hasCompanionObjectName() == false) goto L15;
                setCompanionObjectName(r100.getCompanionObjectName());
            L15:
                if (Class.access$9200(r100).isEmpty() == true) goto L21;
                if (this.typeParameter_.isEmpty() == false) goto L19;
                this.typeParameter_ = Class.access$9200(r100);
                this.bitField0_ &= -9;
                goto L21
            L19:
                ensureTypeParameterIsMutable();
                this.typeParameter_.addAll(Class.access$9200(r100));
            L21:
                if (Class.access$9300(r100).isEmpty() == true) goto L27;
                if (this.supertype_.isEmpty() == false) goto L25;
                this.supertype_ = Class.access$9300(r100);
                this.bitField0_ &= -17;
                goto L27
            L25:
                ensureSupertypeIsMutable();
                this.supertype_.addAll(Class.access$9300(r100));
            L27:
                if (Class.access$9400(r100).isEmpty() == true) goto L33;
                if (this.supertypeId_.isEmpty() == false) goto L31;
                this.supertypeId_ = Class.access$9400(r100);
                this.bitField0_ &= -33;
                goto L33
            L31:
                ensureSupertypeIdIsMutable();
                this.supertypeId_.addAll(Class.access$9400(r100));
            L33:
                if (Class.access$9500(r100).isEmpty() == true) goto L39;
                if (this.nestedClassName_.isEmpty() == false) goto L37;
                this.nestedClassName_ = Class.access$9500(r100);
                this.bitField0_ &= -65;
                goto L39
            L37:
                ensureNestedClassNameIsMutable();
                this.nestedClassName_.addAll(Class.access$9500(r100));
            L39:
                if (Class.access$9600(r100).isEmpty() == true) goto L45;
                if (this.contextReceiverType_.isEmpty() == false) goto L43;
                this.contextReceiverType_ = Class.access$9600(r100);
                this.bitField0_ &= -129;
                goto L45
            L43:
                ensureContextReceiverTypeIsMutable();
                this.contextReceiverType_.addAll(Class.access$9600(r100));
            L45:
                if (Class.access$9700(r100).isEmpty() == true) goto L51;
                if (this.contextReceiverTypeId_.isEmpty() == false) goto L49;
                this.contextReceiverTypeId_ = Class.access$9700(r100);
                this.bitField0_ &= -257;
                goto L51
            L49:
                ensureContextReceiverTypeIdIsMutable();
                this.contextReceiverTypeId_.addAll(Class.access$9700(r100));
            L51:
                if (Class.access$9800(r100).isEmpty() == true) goto L57;
                if (this.constructor_.isEmpty() == false) goto L55;
                this.constructor_ = Class.access$9800(r100);
                this.bitField0_ &= NetError.ERR_TTNET_FT_INVALID_STREAM;
                goto L57
            L55:
                ensureConstructorIsMutable();
                this.constructor_.addAll(Class.access$9800(r100));
            L57:
                if (Class.access$9900(r100).isEmpty() == true) goto L63;
                if (this.function_.isEmpty() == false) goto L61;
                this.function_ = Class.access$9900(r100);
                this.bitField0_ &= -1025;
                goto L63
            L61:
                ensureFunctionIsMutable();
                this.function_.addAll(Class.access$9900(r100));
            L63:
                if (Class.access$10000(r100).isEmpty() == true) goto L69;
                if (this.property_.isEmpty() == false) goto L67;
                this.property_ = Class.access$10000(r100);
                this.bitField0_ &= -2049;
                goto L69
            L67:
                ensurePropertyIsMutable();
                this.property_.addAll(Class.access$10000(r100));
            L69:
                if (Class.access$10100(r100).isEmpty() == true) goto L75;
                if (this.typeAlias_.isEmpty() == false) goto L73;
                this.typeAlias_ = Class.access$10100(r100);
                this.bitField0_ &= -4097;
                goto L75
            L73:
                ensureTypeAliasIsMutable();
                this.typeAlias_.addAll(Class.access$10100(r100));
            L75:
                if (Class.access$10200(r100).isEmpty() == true) goto L81;
                if (this.enumEntry_.isEmpty() == false) goto L79;
                this.enumEntry_ = Class.access$10200(r100);
                this.bitField0_ &= -8193;
                goto L81
            L79:
                ensureEnumEntryIsMutable();
                this.enumEntry_.addAll(Class.access$10200(r100));
            L81:
                if (Class.access$10300(r100).isEmpty() == true) goto L87;
                if (this.sealedSubclassFqName_.isEmpty() == false) goto L85;
                this.sealedSubclassFqName_ = Class.access$10300(r100);
                this.bitField0_ &= -16385;
                goto L87
            L85:
                ensureSealedSubclassFqNameIsMutable();
                this.sealedSubclassFqName_.addAll(Class.access$10300(r100));
            L87:
                if (r100.hasInlineClassUnderlyingPropertyName() == false) goto L90;
                setInlineClassUnderlyingPropertyName(r100.getInlineClassUnderlyingPropertyName());
            L90:
                if (r100.hasInlineClassUnderlyingType() == false) goto L93;
                mergeInlineClassUnderlyingType(r100.getInlineClassUnderlyingType());
            L93:
                if (r100.hasInlineClassUnderlyingTypeId() == false) goto L96;
                setInlineClassUnderlyingTypeId(r100.getInlineClassUnderlyingTypeId());
            L96:
                if (Class.access$10700(r100).isEmpty() == true) goto L102;
                if (this.multiFieldValueClassUnderlyingName_.isEmpty() == false) goto L100;
                this.multiFieldValueClassUnderlyingName_ = Class.access$10700(r100);
                this.bitField0_ &= -262145;
                goto L102
            L100:
                ensureMultiFieldValueClassUnderlyingNameIsMutable();
                this.multiFieldValueClassUnderlyingName_.addAll(Class.access$10700(r100));
            L102:
                if (Class.access$10800(r100).isEmpty() == true) goto L108;
                if (this.multiFieldValueClassUnderlyingType_.isEmpty() == false) goto L106;
                this.multiFieldValueClassUnderlyingType_ = Class.access$10800(r100);
                this.bitField0_ &= -524289;
                goto L108
            L106:
                ensureMultiFieldValueClassUnderlyingTypeIsMutable();
                this.multiFieldValueClassUnderlyingType_.addAll(Class.access$10800(r100));
            L108:
                if (Class.access$10900(r100).isEmpty() == true) goto L114;
                if (this.multiFieldValueClassUnderlyingTypeId_.isEmpty() == false) goto L112;
                this.multiFieldValueClassUnderlyingTypeId_ = Class.access$10900(r100);
                this.bitField0_ &= -1048577;
                goto L114
            L112:
                ensureMultiFieldValueClassUnderlyingTypeIdIsMutable();
                this.multiFieldValueClassUnderlyingTypeId_.addAll(Class.access$10900(r100));
            L114:
                if (r100.hasTypeTable() == false) goto L117;
                mergeTypeTable(r100.getTypeTable());
            L117:
                if (Class.access$11100(r100).isEmpty() == true) goto L123;
                if (this.versionRequirement_.isEmpty() == false) goto L121;
                this.versionRequirement_ = Class.access$11100(r100);
                this.bitField0_ &= -4194305;
                goto L123
            L121:
                ensureVersionRequirementIsMutable();
                this.versionRequirement_.addAll(Class.access$11100(r100));
            L123:
                if (r100.hasVersionRequirementTable() == false) goto L125;
                mergeVersionRequirementTable(r100.getVersionRequirementTable());
            L125:
                mergeExtensionFields(r100);
                setUnknownFields(getUnknownFields().concat(Class.access$11400(r100)));
                return this;
            }

            public Builder mergeInlineClassUnderlyingType(Type r100) {
                if ((this.bitField0_ & 65536) == 65536) goto L5;
            L7:
                this.inlineClassUnderlyingType_ = r100;
            L8:
                this.bitField0_ |= 65536;
                return this;
            L5:
                if (this.inlineClassUnderlyingType_ == Type.getDefaultInstance()) goto L7;
                this.inlineClassUnderlyingType_ = Type.newBuilder(this.inlineClassUnderlyingType_).mergeFrom(r100).buildPartial();
                goto L8
            }

            public Builder mergeTypeTable(TypeTable r100) {
                if ((this.bitField0_ & 2097152) == 2097152) goto L5;
            L7:
                this.typeTable_ = r100;
            L8:
                this.bitField0_ |= 2097152;
                return this;
            L5:
                if (this.typeTable_ == TypeTable.getDefaultInstance()) goto L7;
                this.typeTable_ = TypeTable.newBuilder(this.typeTable_).mergeFrom(r100).buildPartial();
                goto L8
            }

            public Builder mergeVersionRequirementTable(VersionRequirementTable r100) {
                if ((this.bitField0_ & 8388608) == 8388608) goto L5;
            L7:
                this.versionRequirementTable_ = r100;
            L8:
                this.bitField0_ |= 8388608;
                return this;
            L5:
                if (this.versionRequirementTable_ == VersionRequirementTable.getDefaultInstance()) goto L7;
                this.versionRequirementTable_ = VersionRequirementTable.newBuilder(this.versionRequirementTable_).mergeFrom(r100).buildPartial();
                goto L8
            }

            public Builder setCompanionObjectName(int r100) {
                this.bitField0_ |= 4;
                this.companionObjectName_ = r100;
                return this;
            }

            public Builder setFlags(int r100) {
                this.bitField0_ |= 1;
                this.flags_ = r100;
                return this;
            }

            public Builder setFqName(int r100) {
                this.bitField0_ |= 2;
                this.fqName_ = r100;
                return this;
            }

            public Builder setInlineClassUnderlyingPropertyName(int r100) {
                this.bitField0_ |= 32768;
                this.inlineClassUnderlyingPropertyName_ = r100;
                return this;
            }

            public Builder setInlineClassUnderlyingTypeId(int r100) {
                this.bitField0_ |= 131072;
                this.inlineClassUnderlyingTypeId_ = r100;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r100) {
                return mergeFrom((Class) r100);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
                Class r102 = null;
                Class r103 = Class.PARSER.parsePartialFrom(r100, r101);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r103 == null) goto L6;
                mergeFrom(r103);
            L6:
                return this;
            L9:
                e = move-exception;
                Class r104 = (Class) e.getUnfinishedMessage();     // Catch: Throwable -> L7
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

        public static final enum Kind extends Enum<Kind> implements Internal.EnumLite {
            private static final /* synthetic */ Kind[] $VALUES = null;
            public static final Kind ANNOTATION_CLASS = null;
            public static final Kind CLASS = null;
            public static final Kind COMPANION_OBJECT = null;
            public static final Kind ENUM_CLASS = null;
            public static final Kind ENUM_ENTRY = null;
            public static final Kind INTERFACE = null;
            public static final Kind OBJECT = null;
            private static Internal.EnumLiteMap<Kind> internalValueMap;
            private final int value;

            static {
                Kind r100 = new Kind("CLASS", 0, 0, 0);
                CLASS = r100;
                Kind r101 = new Kind("INTERFACE", 1, 1, 1);
                INTERFACE = r101;
                Kind r102 = new Kind("ENUM_CLASS", 2, 2, 2);
                ENUM_CLASS = r102;
                Kind r103 = new Kind("ENUM_ENTRY", 3, 3, 3);
                ENUM_ENTRY = r103;
                Kind r104 = new Kind("ANNOTATION_CLASS", 4, 4, 4);
                ANNOTATION_CLASS = r104;
                Kind r105 = new Kind("OBJECT", 5, 5, 5);
                OBJECT = r105;
                Kind r110 = new Kind("COMPANION_OBJECT", 6, 6, 6);
                COMPANION_OBJECT = r110;
                $VALUES = new Kind[]{r100, r101, r102, r103, r104, r105, r110};
                internalValueMap = new AnonymousClass1();
            }

            public static Kind[] values() {
                return (Kind[]) $VALUES.clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            public static Kind valueOf(int r100) {
                switch(r100) {
                    case 0: goto L18;
                    case 1: goto L16;
                    case 2: goto L14;
                    case 3: goto L12;
                    case 4: goto L10;
                    case 5: goto L8;
                    case 6: goto L6;
                    default: goto L3;
                };
            L3:
                return null;
            L6:
                return COMPANION_OBJECT;
            L8:
                return OBJECT;
            L10:
                return ANNOTATION_CLASS;
            L12:
                return ENUM_ENTRY;
            L14:
                return ENUM_CLASS;
            L16:
                return INTERFACE;
            L18:
                return CLASS;
            }

            public static Kind valueOf(String r100) {
                return (Kind) a.a(Kind.class, r100);
            }

            private Kind(String r100, int r101, int r102, int r103) {
                super(r100, r101);
                this.value = r103;
            }
        }

        private void initFields() {
            this.flags_ = 6;
            this.fqName_ = 0;
            this.companionObjectName_ = 0;
            this.typeParameter_ = Collections.emptyList();
            this.supertype_ = Collections.emptyList();
            this.supertypeId_ = Collections.emptyList();
            this.nestedClassName_ = Collections.emptyList();
            this.contextReceiverType_ = Collections.emptyList();
            this.contextReceiverTypeId_ = Collections.emptyList();
            this.constructor_ = Collections.emptyList();
            this.function_ = Collections.emptyList();
            this.property_ = Collections.emptyList();
            this.typeAlias_ = Collections.emptyList();
            this.enumEntry_ = Collections.emptyList();
            this.sealedSubclassFqName_ = Collections.emptyList();
            this.inlineClassUnderlyingPropertyName_ = 0;
            this.inlineClassUnderlyingType_ = Type.getDefaultInstance();
            this.inlineClassUnderlyingTypeId_ = 0;
            this.multiFieldValueClassUnderlyingName_ = Collections.emptyList();
            this.multiFieldValueClassUnderlyingType_ = Collections.emptyList();
            this.multiFieldValueClassUnderlyingTypeId_ = Collections.emptyList();
            this.typeTable_ = TypeTable.getDefaultInstance();
            this.versionRequirement_ = Collections.emptyList();
            this.versionRequirementTable_ = VersionRequirementTable.getDefaultInstance();
        }

        static {
            PARSER = new AnonymousClass1();
            Class r100 = new Class(true);
            defaultInstance = r100;
            r100.initFields();
        }

        public int getConstructorCount() {
            return this.constructor_.size();
        }

        public int getContextReceiverTypeCount() {
            return this.contextReceiverType_.size();
        }

        public int getEnumEntryCount() {
            return this.enumEntry_.size();
        }

        public int getFunctionCount() {
            return this.function_.size();
        }

        public int getMultiFieldValueClassUnderlyingNameCount() {
            return this.multiFieldValueClassUnderlyingName_.size();
        }

        public int getMultiFieldValueClassUnderlyingTypeCount() {
            return this.multiFieldValueClassUnderlyingType_.size();
        }

        public int getMultiFieldValueClassUnderlyingTypeIdCount() {
            return this.multiFieldValueClassUnderlyingTypeId_.size();
        }

        public int getPropertyCount() {
            return this.property_.size();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int r100 = this.memoizedSerializedSize;
            if (r100 == (-1)) goto L5;
            return r100;
        L5:
            int r101 = 0;
            if ((this.bitField0_ & 1) != 1) goto L8;
            int r102 = CodedOutputStream.computeInt32Size(1, this.flags_) + 0;
        L9:
            int r103 = 0;
            int r104 = 0;
        L11:
            if (r103 >= this.supertypeId_.size()) goto L13;
            r104 = r104 + CodedOutputStream.computeInt32SizeNoTag(((Integer) ListProtector.get(this.supertypeId_, r103)).intValue());
            r103 = r103 + 1;
            goto L11
        L13:
            int r105 = r102 + r104;
            if (getSupertypeIdList().isEmpty() == true) goto L16;
            r105 = (r105 + 1) + CodedOutputStream.computeInt32SizeNoTag(r104);
        L16:
            this.supertypeIdMemoizedSerializedSize = r104;
            if ((this.bitField0_ & 2) != 2) goto L20;
            r105 = r105 + CodedOutputStream.computeInt32Size(3, this.fqName_);
        L20:
            if ((this.bitField0_ & 4) != 4) goto L22;
            r105 = r105 + CodedOutputStream.computeInt32Size(4, this.companionObjectName_);
        L22:
            int r106 = 0;
        L24:
            if (r106 >= this.typeParameter_.size()) goto L26;
            r105 = r105 + CodedOutputStream.computeMessageSize(5, (MessageLite) ListProtector.get(this.typeParameter_, r106));
            r106 = r106 + 1;
            goto L24
        L26:
            int r107 = 0;
        L28:
            if (r107 >= this.supertype_.size()) goto L30;
            r105 = r105 + CodedOutputStream.computeMessageSize(6, (MessageLite) ListProtector.get(this.supertype_, r107));
            r107 = r107 + 1;
            goto L28
        L30:
            int r108 = 0;
            int r109 = 0;
        L32:
            if (r108 >= this.nestedClassName_.size()) goto L34;
            r109 = r109 + CodedOutputStream.computeInt32SizeNoTag(((Integer) ListProtector.get(this.nestedClassName_, r108)).intValue());
            r108 = r108 + 1;
            goto L32
        L34:
            int r110 = r105 + r109;
            if (getNestedClassNameList().isEmpty() == true) goto L37;
            r110 = (r110 + 1) + CodedOutputStream.computeInt32SizeNoTag(r109);
        L37:
            this.nestedClassNameMemoizedSerializedSize = r109;
            int r111 = 0;
        L39:
            if (r111 >= this.constructor_.size()) goto L41;
            r110 = r110 + CodedOutputStream.computeMessageSize(8, (MessageLite) ListProtector.get(this.constructor_, r111));
            r111 = r111 + 1;
            goto L39
        L41:
            int r112 = 0;
        L43:
            if (r112 >= this.function_.size()) goto L45;
            r110 = r110 + CodedOutputStream.computeMessageSize(9, (MessageLite) ListProtector.get(this.function_, r112));
            r112 = r112 + 1;
            goto L43
        L45:
            int r113 = 0;
        L47:
            if (r113 >= this.property_.size()) goto L49;
            r110 = r110 + CodedOutputStream.computeMessageSize(10, (MessageLite) ListProtector.get(this.property_, r113));
            r113 = r113 + 1;
            goto L47
        L49:
            int r114 = 0;
        L51:
            if (r114 >= this.typeAlias_.size()) goto L53;
            r110 = r110 + CodedOutputStream.computeMessageSize(11, (MessageLite) ListProtector.get(this.typeAlias_, r114));
            r114 = r114 + 1;
            goto L51
        L53:
            int r115 = 0;
        L55:
            if (r115 >= this.enumEntry_.size()) goto L57;
            r110 = r110 + CodedOutputStream.computeMessageSize(13, (MessageLite) ListProtector.get(this.enumEntry_, r115));
            r115 = r115 + 1;
            goto L55
        L57:
            int r116 = 0;
            int r117 = 0;
        L59:
            if (r116 >= this.sealedSubclassFqName_.size()) goto L61;
            r117 = r117 + CodedOutputStream.computeInt32SizeNoTag(((Integer) ListProtector.get(this.sealedSubclassFqName_, r116)).intValue());
            r116 = r116 + 1;
            goto L59
        L61:
            int r118 = r110 + r117;
            if (getSealedSubclassFqNameList().isEmpty() == true) goto L64;
            r118 = (r118 + 2) + CodedOutputStream.computeInt32SizeNoTag(r117);
        L64:
            this.sealedSubclassFqNameMemoizedSerializedSize = r117;
            if ((this.bitField0_ & 8) != 8) goto L68;
            r118 = r118 + CodedOutputStream.computeInt32Size(17, this.inlineClassUnderlyingPropertyName_);
        L68:
            if ((this.bitField0_ & 16) != 16) goto L71;
            r118 = r118 + CodedOutputStream.computeMessageSize(18, this.inlineClassUnderlyingType_);
        L71:
            if ((this.bitField0_ & 32) != 32) goto L73;
            r118 = r118 + CodedOutputStream.computeInt32Size(19, this.inlineClassUnderlyingTypeId_);
        L73:
            int r119 = 0;
        L75:
            if (r119 >= this.contextReceiverType_.size()) goto L77;
            r118 = r118 + CodedOutputStream.computeMessageSize(20, (MessageLite) ListProtector.get(this.contextReceiverType_, r119));
            r119 = r119 + 1;
            goto L75
        L77:
            int r120 = 0;
            int r121 = 0;
        L79:
            if (r120 >= this.contextReceiverTypeId_.size()) goto L81;
            r121 = r121 + CodedOutputStream.computeInt32SizeNoTag(((Integer) ListProtector.get(this.contextReceiverTypeId_, r120)).intValue());
            r120 = r120 + 1;
            goto L79
        L81:
            int r122 = r118 + r121;
            if (getContextReceiverTypeIdList().isEmpty() == true) goto L84;
            r122 = (r122 + 2) + CodedOutputStream.computeInt32SizeNoTag(r121);
        L84:
            this.contextReceiverTypeIdMemoizedSerializedSize = r121;
            int r123 = 0;
            int r124 = 0;
        L86:
            if (r123 >= this.multiFieldValueClassUnderlyingName_.size()) goto L88;
            r124 = r124 + CodedOutputStream.computeInt32SizeNoTag(((Integer) ListProtector.get(this.multiFieldValueClassUnderlyingName_, r123)).intValue());
            r123 = r123 + 1;
            goto L86
        L88:
            int r125 = r122 + r124;
            if (getMultiFieldValueClassUnderlyingNameList().isEmpty() == true) goto L91;
            r125 = (r125 + 2) + CodedOutputStream.computeInt32SizeNoTag(r124);
        L91:
            this.multiFieldValueClassUnderlyingNameMemoizedSerializedSize = r124;
            int r126 = 0;
        L93:
            if (r126 >= this.multiFieldValueClassUnderlyingType_.size()) goto L95;
            r125 = r125 + CodedOutputStream.computeMessageSize(23, (MessageLite) ListProtector.get(this.multiFieldValueClassUnderlyingType_, r126));
            r126 = r126 + 1;
            goto L93
        L95:
            int r127 = 0;
            int r128 = 0;
        L97:
            if (r127 >= this.multiFieldValueClassUnderlyingTypeId_.size()) goto L99;
            r128 = r128 + CodedOutputStream.computeInt32SizeNoTag(((Integer) ListProtector.get(this.multiFieldValueClassUnderlyingTypeId_, r127)).intValue());
            r127 = r127 + 1;
            goto L97
        L99:
            int r129 = r125 + r128;
            if (getMultiFieldValueClassUnderlyingTypeIdList().isEmpty() == true) goto L102;
            r129 = (r129 + 2) + CodedOutputStream.computeInt32SizeNoTag(r128);
        L102:
            this.multiFieldValueClassUnderlyingTypeIdMemoizedSerializedSize = r128;
            if ((this.bitField0_ & 64) != 64) goto L105;
            r129 = r129 + CodedOutputStream.computeMessageSize(30, this.typeTable_);
        L105:
            int r130 = 0;
        L107:
            if (r101 >= this.versionRequirement_.size()) goto L109;
            r130 = r130 + CodedOutputStream.computeInt32SizeNoTag(((Integer) ListProtector.get(this.versionRequirement_, r101)).intValue());
            r101 = r101 + 1;
            goto L107
        L109:
            int r131 = (r129 + r130) + (getVersionRequirementList().size() * 2);
            if ((this.bitField0_ & 128) != 128) goto L112;
            r131 = r131 + CodedOutputStream.computeMessageSize(32, this.versionRequirementTable_);
        L112:
            int r132 = (r131 + extensionsSerializedSize()) + this.unknownFields.size();
            this.memoizedSerializedSize = r132;
            return r132;
        L8:
            r102 = 0;
            goto L9
        }

        public int getSupertypeCount() {
            return this.supertype_.size();
        }

        public int getTypeAliasCount() {
            return this.typeAlias_.size();
        }

        public int getTypeParameterCount() {
            return this.typeParameter_.size();
        }

        public boolean hasCompanionObjectName() {
            if ((this.bitField0_ & 4) != 4) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasFlags() {
            if ((this.bitField0_ & 1) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        public boolean hasFqName() {
            if ((this.bitField0_ & 2) != 2) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasInlineClassUnderlyingPropertyName() {
            if ((this.bitField0_ & 8) != 8) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasInlineClassUnderlyingType() {
            if ((this.bitField0_ & 16) != 16) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasInlineClassUnderlyingTypeId() {
            if ((this.bitField0_ & 32) != 32) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasTypeTable() {
            if ((this.bitField0_ & 64) != 64) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasVersionRequirementTable() {
            if ((this.bitField0_ & 128) != 128) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte r100 = this.memoizedIsInitialized;
            if (r100 != 1) goto L6;
            return true;
        L6:
            if (r100 != 0) goto L9;
            return false;
        L9:
            if (hasFqName() == true) goto L12;
            this.memoizedIsInitialized = 0;
            return false;
        L12:
            int r101 = 0;
        L14:
            if (r101 >= getTypeParameterCount()) goto L20;
            if (getTypeParameter(r101).isInitialized() == false) goto L17;
            r101 = r101 + 1;
            goto L14
        L17:
            this.memoizedIsInitialized = 0;
            return false;
        L20:
            int r102 = 0;
        L22:
            if (r102 >= getSupertypeCount()) goto L28;
            if (getSupertype(r102).isInitialized() == false) goto L25;
            r102 = r102 + 1;
            goto L22
        L25:
            this.memoizedIsInitialized = 0;
            return false;
        L28:
            int r103 = 0;
        L30:
            if (r103 >= getContextReceiverTypeCount()) goto L36;
            if (getContextReceiverType(r103).isInitialized() == false) goto L33;
            r103 = r103 + 1;
            goto L30
        L33:
            this.memoizedIsInitialized = 0;
            return false;
        L36:
            int r104 = 0;
        L38:
            if (r104 >= getConstructorCount()) goto L44;
            if (getConstructor(r104).isInitialized() == false) goto L41;
            r104 = r104 + 1;
            goto L38
        L41:
            this.memoizedIsInitialized = 0;
            return false;
        L44:
            int r105 = 0;
        L46:
            if (r105 >= getFunctionCount()) goto L52;
            if (getFunction(r105).isInitialized() == false) goto L49;
            r105 = r105 + 1;
            goto L46
        L49:
            this.memoizedIsInitialized = 0;
            return false;
        L52:
            int r106 = 0;
        L54:
            if (r106 >= getPropertyCount()) goto L60;
            if (getProperty(r106).isInitialized() == false) goto L57;
            r106 = r106 + 1;
            goto L54
        L57:
            this.memoizedIsInitialized = 0;
            return false;
        L60:
            int r107 = 0;
        L62:
            if (r107 >= getTypeAliasCount()) goto L68;
            if (getTypeAlias(r107).isInitialized() == false) goto L65;
            r107 = r107 + 1;
            goto L62
        L65:
            this.memoizedIsInitialized = 0;
            return false;
        L68:
            int r108 = 0;
        L70:
            if (r108 >= getEnumEntryCount()) goto L77;
            if (getEnumEntry(r108).isInitialized() == false) goto L73;
            r108 = r108 + 1;
            goto L70
        L73:
            this.memoizedIsInitialized = 0;
            return false;
        L77:
            if (hasInlineClassUnderlyingType() == true) goto L79;
        L82:
            int r109 = 0;
        L84:
            if (r109 >= getMultiFieldValueClassUnderlyingTypeCount()) goto L91;
            if (getMultiFieldValueClassUnderlyingType(r109).isInitialized() == false) goto L87;
            r109 = r109 + 1;
            goto L84
        L87:
            this.memoizedIsInitialized = 0;
            return false;
        L91:
            if (hasTypeTable() == false) goto L97;
            if (getTypeTable().isInitialized() == true) goto L97;
            this.memoizedIsInitialized = 0;
            return false;
        L97:
            if (extensionsAreInitialized() == true) goto L100;
            this.memoizedIsInitialized = 0;
            return false;
        L100:
            this.memoizedIsInitialized = 1;
            return true;
        L79:
            if (getInlineClassUnderlyingType().isInitialized() == true) goto L82;
            this.memoizedIsInitialized = 0;
            return false;
        }

        public static Builder newBuilder() {
            return Builder.access$8700();
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

        public static Class getDefaultInstance() {
            return defaultInstance;
        }

        public int getCompanionObjectName() {
            return this.companionObjectName_;
        }

        public List<Constructor> getConstructorList() {
            return this.constructor_;
        }

        public List<Integer> getContextReceiverTypeIdList() {
            return this.contextReceiverTypeId_;
        }

        public List<Type> getContextReceiverTypeList() {
            return this.contextReceiverType_;
        }

        public List<EnumEntry> getEnumEntryList() {
            return this.enumEntry_;
        }

        public int getFlags() {
            return this.flags_;
        }

        public int getFqName() {
            return this.fqName_;
        }

        public List<Function> getFunctionList() {
            return this.function_;
        }

        public int getInlineClassUnderlyingPropertyName() {
            return this.inlineClassUnderlyingPropertyName_;
        }

        public Type getInlineClassUnderlyingType() {
            return this.inlineClassUnderlyingType_;
        }

        public int getInlineClassUnderlyingTypeId() {
            return this.inlineClassUnderlyingTypeId_;
        }

        public List<Integer> getMultiFieldValueClassUnderlyingNameList() {
            return this.multiFieldValueClassUnderlyingName_;
        }

        public List<Integer> getMultiFieldValueClassUnderlyingTypeIdList() {
            return this.multiFieldValueClassUnderlyingTypeId_;
        }

        public List<Type> getMultiFieldValueClassUnderlyingTypeList() {
            return this.multiFieldValueClassUnderlyingType_;
        }

        public List<Integer> getNestedClassNameList() {
            return this.nestedClassName_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<Class> getParserForType() {
            return PARSER;
        }

        public List<Property> getPropertyList() {
            return this.property_;
        }

        public List<Integer> getSealedSubclassFqNameList() {
            return this.sealedSubclassFqName_;
        }

        public List<Integer> getSupertypeIdList() {
            return this.supertypeId_;
        }

        public List<Type> getSupertypeList() {
            return this.supertype_;
        }

        public List<TypeAlias> getTypeAliasList() {
            return this.typeAlias_;
        }

        public List<TypeParameter> getTypeParameterList() {
            return this.typeParameter_;
        }

        public TypeTable getTypeTable() {
            return this.typeTable_;
        }

        public List<Integer> getVersionRequirementList() {
            return this.versionRequirement_;
        }

        public VersionRequirementTable getVersionRequirementTable() {
            return this.versionRequirementTable_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public Class getDefaultInstanceForType() {
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

        private Class(GeneratedMessageLite.ExtendableBuilder<Class, ?> r100) {
            super(r100);
            this.supertypeIdMemoizedSerializedSize = -1;
            this.nestedClassNameMemoizedSerializedSize = -1;
            this.contextReceiverTypeIdMemoizedSerializedSize = -1;
            this.sealedSubclassFqNameMemoizedSerializedSize = -1;
            this.multiFieldValueClassUnderlyingNameMemoizedSerializedSize = -1;
            this.multiFieldValueClassUnderlyingTypeIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r100.getUnknownFields();
        }

        public static /* synthetic */ List access$10000(Class r100) {
            return r100.property_;
        }

        public static /* synthetic */ List access$10100(Class r100) {
            return r100.typeAlias_;
        }

        public static /* synthetic */ List access$10200(Class r100) {
            return r100.enumEntry_;
        }

        public static /* synthetic */ List access$10300(Class r100) {
            return r100.sealedSubclassFqName_;
        }

        public static /* synthetic */ List access$10700(Class r100) {
            return r100.multiFieldValueClassUnderlyingName_;
        }

        public static /* synthetic */ List access$10800(Class r100) {
            return r100.multiFieldValueClassUnderlyingType_;
        }

        public static /* synthetic */ List access$10900(Class r100) {
            return r100.multiFieldValueClassUnderlyingTypeId_;
        }

        public static /* synthetic */ List access$11100(Class r100) {
            return r100.versionRequirement_;
        }

        public static /* synthetic */ ByteString access$11400(Class r100) {
            return r100.unknownFields;
        }

        public static /* synthetic */ List access$9200(Class r100) {
            return r100.typeParameter_;
        }

        public static /* synthetic */ List access$9300(Class r100) {
            return r100.supertype_;
        }

        public static /* synthetic */ List access$9400(Class r100) {
            return r100.supertypeId_;
        }

        public static /* synthetic */ List access$9500(Class r100) {
            return r100.nestedClassName_;
        }

        public static /* synthetic */ List access$9600(Class r100) {
            return r100.contextReceiverType_;
        }

        public static /* synthetic */ List access$9700(Class r100) {
            return r100.contextReceiverTypeId_;
        }

        public static /* synthetic */ List access$9800(Class r100) {
            return r100.constructor_;
        }

        public static /* synthetic */ List access$9900(Class r100) {
            return r100.function_;
        }

        public static Builder newBuilder(Class r100) {
            return newBuilder().mergeFrom(r100);
        }

        public Constructor getConstructor(int r100) {
            return (Constructor) ListProtector.get(this.constructor_, r100);
        }

        public Type getContextReceiverType(int r100) {
            return (Type) ListProtector.get(this.contextReceiverType_, r100);
        }

        public EnumEntry getEnumEntry(int r100) {
            return (EnumEntry) ListProtector.get(this.enumEntry_, r100);
        }

        public Function getFunction(int r100) {
            return (Function) ListProtector.get(this.function_, r100);
        }

        public Type getMultiFieldValueClassUnderlyingType(int r100) {
            return (Type) ListProtector.get(this.multiFieldValueClassUnderlyingType_, r100);
        }

        public Property getProperty(int r100) {
            return (Property) ListProtector.get(this.property_, r100);
        }

        public Type getSupertype(int r100) {
            return (Type) ListProtector.get(this.supertype_, r100);
        }

        public TypeAlias getTypeAlias(int r100) {
            return (TypeAlias) ListProtector.get(this.typeAlias_, r100);
        }

        public TypeParameter getTypeParameter(int r100) {
            return (TypeParameter) ListProtector.get(this.typeParameter_, r100);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r100) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter r101 = newExtensionWriter();
            if ((this.bitField0_ & 1) != 1) goto L6;
            r100.writeInt32(1, this.flags_);
        L6:
            if (getSupertypeIdList().size() <= 0) goto L8;
            r100.writeRawVarint32(18);
            r100.writeRawVarint32(this.supertypeIdMemoizedSerializedSize);
        L8:
            int r102 = 0;
            int r103 = 0;
        L10:
            if (r103 >= this.supertypeId_.size()) goto L13;
            r100.writeInt32NoTag(((Integer) ListProtector.get(this.supertypeId_, r103)).intValue());
            r103 = r103 + 1;
            goto L10
        L13:
            if ((this.bitField0_ & 2) != 2) goto L16;
            r100.writeInt32(3, this.fqName_);
        L16:
            if ((this.bitField0_ & 4) != 4) goto L18;
            r100.writeInt32(4, this.companionObjectName_);
        L18:
            int r104 = 0;
        L20:
            if (r104 >= this.typeParameter_.size()) goto L22;
            r100.writeMessage(5, (MessageLite) ListProtector.get(this.typeParameter_, r104));
            r104 = r104 + 1;
            goto L20
        L22:
            int r105 = 0;
        L24:
            if (r105 >= this.supertype_.size()) goto L27;
            r100.writeMessage(6, (MessageLite) ListProtector.get(this.supertype_, r105));
            r105 = r105 + 1;
            goto L24
        L27:
            if (getNestedClassNameList().size() <= 0) goto L29;
            r100.writeRawVarint32(58);
            r100.writeRawVarint32(this.nestedClassNameMemoizedSerializedSize);
        L29:
            int r106 = 0;
        L31:
            if (r106 >= this.nestedClassName_.size()) goto L33;
            r100.writeInt32NoTag(((Integer) ListProtector.get(this.nestedClassName_, r106)).intValue());
            r106 = r106 + 1;
            goto L31
        L33:
            int r107 = 0;
        L35:
            if (r107 >= this.constructor_.size()) goto L37;
            r100.writeMessage(8, (MessageLite) ListProtector.get(this.constructor_, r107));
            r107 = r107 + 1;
            goto L35
        L37:
            int r108 = 0;
        L39:
            if (r108 >= this.function_.size()) goto L41;
            r100.writeMessage(9, (MessageLite) ListProtector.get(this.function_, r108));
            r108 = r108 + 1;
            goto L39
        L41:
            int r109 = 0;
        L43:
            if (r109 >= this.property_.size()) goto L45;
            r100.writeMessage(10, (MessageLite) ListProtector.get(this.property_, r109));
            r109 = r109 + 1;
            goto L43
        L45:
            int r110 = 0;
        L47:
            if (r110 >= this.typeAlias_.size()) goto L49;
            r100.writeMessage(11, (MessageLite) ListProtector.get(this.typeAlias_, r110));
            r110 = r110 + 1;
            goto L47
        L49:
            int r111 = 0;
        L51:
            if (r111 >= this.enumEntry_.size()) goto L54;
            r100.writeMessage(13, (MessageLite) ListProtector.get(this.enumEntry_, r111));
            r111 = r111 + 1;
            goto L51
        L54:
            if (getSealedSubclassFqNameList().size() <= 0) goto L56;
            r100.writeRawVarint32(130);
            r100.writeRawVarint32(this.sealedSubclassFqNameMemoizedSerializedSize);
        L56:
            int r112 = 0;
        L58:
            if (r112 >= this.sealedSubclassFqName_.size()) goto L61;
            r100.writeInt32NoTag(((Integer) ListProtector.get(this.sealedSubclassFqName_, r112)).intValue());
            r112 = r112 + 1;
            goto L58
        L61:
            if ((this.bitField0_ & 8) != 8) goto L64;
            r100.writeInt32(17, this.inlineClassUnderlyingPropertyName_);
        L64:
            if ((this.bitField0_ & 16) != 16) goto L67;
            r100.writeMessage(18, this.inlineClassUnderlyingType_);
        L67:
            if ((this.bitField0_ & 32) != 32) goto L69;
            r100.writeInt32(19, this.inlineClassUnderlyingTypeId_);
        L69:
            int r113 = 0;
        L71:
            if (r113 >= this.contextReceiverType_.size()) goto L74;
            r100.writeMessage(20, (MessageLite) ListProtector.get(this.contextReceiverType_, r113));
            r113 = r113 + 1;
            goto L71
        L74:
            if (getContextReceiverTypeIdList().size() <= 0) goto L76;
            r100.writeRawVarint32(170);
            r100.writeRawVarint32(this.contextReceiverTypeIdMemoizedSerializedSize);
        L76:
            int r114 = 0;
        L78:
            if (r114 >= this.contextReceiverTypeId_.size()) goto L81;
            r100.writeInt32NoTag(((Integer) ListProtector.get(this.contextReceiverTypeId_, r114)).intValue());
            r114 = r114 + 1;
            goto L78
        L81:
            if (getMultiFieldValueClassUnderlyingNameList().size() <= 0) goto L83;
            r100.writeRawVarint32(178);
            r100.writeRawVarint32(this.multiFieldValueClassUnderlyingNameMemoizedSerializedSize);
        L83:
            int r115 = 0;
        L85:
            if (r115 >= this.multiFieldValueClassUnderlyingName_.size()) goto L87;
            r100.writeInt32NoTag(((Integer) ListProtector.get(this.multiFieldValueClassUnderlyingName_, r115)).intValue());
            r115 = r115 + 1;
            goto L85
        L87:
            int r116 = 0;
        L89:
            if (r116 >= this.multiFieldValueClassUnderlyingType_.size()) goto L92;
            r100.writeMessage(23, (MessageLite) ListProtector.get(this.multiFieldValueClassUnderlyingType_, r116));
            r116 = r116 + 1;
            goto L89
        L92:
            if (getMultiFieldValueClassUnderlyingTypeIdList().size() <= 0) goto L94;
            r100.writeRawVarint32(MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY);
            r100.writeRawVarint32(this.multiFieldValueClassUnderlyingTypeIdMemoizedSerializedSize);
        L94:
            int r117 = 0;
        L96:
            if (r117 >= this.multiFieldValueClassUnderlyingTypeId_.size()) goto L99;
            r100.writeInt32NoTag(((Integer) ListProtector.get(this.multiFieldValueClassUnderlyingTypeId_, r117)).intValue());
            r117 = r117 + 1;
            goto L96
        L99:
            if ((this.bitField0_ & 64) != 64) goto L102;
            r100.writeMessage(30, this.typeTable_);
        L102:
            if (r102 >= this.versionRequirement_.size()) goto L105;
            r100.writeInt32(31, ((Integer) ListProtector.get(this.versionRequirement_, r102)).intValue());
            r102 = r102 + 1;
            goto L102
        L105:
            if ((this.bitField0_ & 128) != 128) goto L107;
            r100.writeMessage(32, this.versionRequirementTable_);
        L107:
            r101.writeUntil(19000, r100);
            r100.writeRawBytes(this.unknownFields);
        }

        private Class(boolean r100) {
            this.supertypeIdMemoizedSerializedSize = -1;
            this.nestedClassNameMemoizedSerializedSize = -1;
            this.contextReceiverTypeIdMemoizedSerializedSize = -1;
            this.sealedSubclassFqNameMemoizedSerializedSize = -1;
            this.multiFieldValueClassUnderlyingNameMemoizedSerializedSize = -1;
            this.multiFieldValueClassUnderlyingTypeIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private Class(CodedInputStream r110, ExtensionRegistryLite r111) throws InvalidProtocolBufferException {
            this.supertypeIdMemoizedSerializedSize = -1;
            this.nestedClassNameMemoizedSerializedSize = -1;
            this.contextReceiverTypeIdMemoizedSerializedSize = -1;
            this.sealedSubclassFqNameMemoizedSerializedSize = -1;
            this.multiFieldValueClassUnderlyingNameMemoizedSerializedSize = -1;
            this.multiFieldValueClassUnderlyingTypeIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r100 = ByteString.newOutput();
            CodedOutputStream r101 = CodedOutputStream.newInstance(r100, 1);
            boolean r102 = false;
            int r103 = 0;
        L4:
            if (r102 == true) goto L233;
            int r112 = r110.readTag();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            Cloneable r113 = null;
            switch(r112) {
                case 0: goto L164;
                case 8: goto L161;
                case 16: goto L157;
                case 18: goto L147;
                case 24: goto L146;
                case 32: goto L145;
                case 42: goto L142;
                case 50: goto L138;
                case 56: goto L134;
                case 58: goto L124;
                case 66: goto L121;
                case 74: goto L117;
                case 82: goto L113;
                case 90: goto L109;
                case 106: goto L105;
                case 128: goto L101;
                case 130: goto L91;
                case 136: goto L90;
                case 146: goto L84;
                case 152: goto L82;
                case 162: goto L79;
                case 168: goto L75;
                case 170: goto L65;
                case 176: goto L62;
                case 178: goto L52;
                case 186: goto L49;
                case 192: goto L45;
                case 194: goto L35;
                case 242: goto L29;
                case 248: goto L25;
                case 250: goto L15;
                case 258: goto L9;
                default: goto L165;
            };     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        L15:
            int r114 = r110.pushLimit(r110.readRawVarint32());     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            if ((r103 & 4194304) == 4194304) goto L21;
            if (r110.getBytesUntilLimit() <= 0) goto L21;
            this.versionRequirement_ = new ArrayList();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            r103 = r103 | 4194304;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        L21:
            if (r110.getBytesUntilLimit() <= 0) goto L23;
            this.versionRequirement_.add(Integer.valueOf(r110.readInt32()));     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            goto L21
        L23:
            r110.popLimit(r114);     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            goto L4
        L35:
            int r115 = r110.pushLimit(r110.readRawVarint32());     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            if ((r103 & 1048576) == 1048576) goto L41;
            if (r110.getBytesUntilLimit() <= 0) goto L41;
            this.multiFieldValueClassUnderlyingTypeId_ = new ArrayList();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            r103 = r103 | 1048576;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        L41:
            if (r110.getBytesUntilLimit() <= 0) goto L43;
            this.multiFieldValueClassUnderlyingTypeId_.add(Integer.valueOf(r110.readInt32()));     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            goto L41
        L43:
            r110.popLimit(r115);     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            goto L4
        L52:
            int r116 = r110.pushLimit(r110.readRawVarint32());     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            if ((r103 & 262144) == 262144) goto L58;
            if (r110.getBytesUntilLimit() <= 0) goto L58;
            this.multiFieldValueClassUnderlyingName_ = new ArrayList();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            r103 = r103 | 262144;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        L58:
            if (r110.getBytesUntilLimit() <= 0) goto L60;
            this.multiFieldValueClassUnderlyingName_.add(Integer.valueOf(r110.readInt32()));     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            goto L58
        L60:
            r110.popLimit(r116);     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            goto L4
        L65:
            int r117 = r110.pushLimit(r110.readRawVarint32());     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            if ((r103 & 256) == 256) goto L71;
            if (r110.getBytesUntilLimit() <= 0) goto L71;
            this.contextReceiverTypeId_ = new ArrayList();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            r103 = r103 | 256;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        L71:
            if (r110.getBytesUntilLimit() <= 0) goto L73;
            this.contextReceiverTypeId_.add(Integer.valueOf(r110.readInt32()));     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            goto L71
        L73:
            r110.popLimit(r117);     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            goto L4
        L82:
            this.bitField0_ |= 32;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            this.inlineClassUnderlyingTypeId_ = r110.readInt32();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            goto L4
        L90:
            this.bitField0_ |= 8;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            this.inlineClassUnderlyingPropertyName_ = r110.readInt32();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            goto L4
        L91:
            int r118 = r110.pushLimit(r110.readRawVarint32());     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            if ((r103 & 16384) == 16384) goto L97;
            if (r110.getBytesUntilLimit() <= 0) goto L97;
            this.sealedSubclassFqName_ = new ArrayList();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            r103 = r103 | 16384;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        L97:
            if (r110.getBytesUntilLimit() <= 0) goto L99;
            this.sealedSubclassFqName_.add(Integer.valueOf(r110.readInt32()));     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            goto L97
        L99:
            r110.popLimit(r118);     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            goto L4
        L124:
            int r119 = r110.pushLimit(r110.readRawVarint32());     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            if ((r103 & 64) == 64) goto L130;
            if (r110.getBytesUntilLimit() <= 0) goto L130;
            this.nestedClassName_ = new ArrayList();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            r103 = r103 | 64;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        L130:
            if (r110.getBytesUntilLimit() <= 0) goto L132;
            this.nestedClassName_.add(Integer.valueOf(r110.readInt32()));     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            goto L130
        L132:
            r110.popLimit(r119);     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            goto L4
        L145:
            this.bitField0_ |= 4;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            this.companionObjectName_ = r110.readInt32();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            goto L4
        L146:
            this.bitField0_ |= 2;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            this.fqName_ = r110.readInt32();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            goto L4
        L147:
            int r120 = r110.pushLimit(r110.readRawVarint32());     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            if ((r103 & 32) == 32) goto L153;
            if (r110.getBytesUntilLimit() <= 0) goto L153;
            this.supertypeId_ = new ArrayList();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            r103 = r103 | 32;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        L153:
            if (r110.getBytesUntilLimit() <= 0) goto L155;
            this.supertypeId_.add(Integer.valueOf(r110.readInt32()));     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            goto L153
        L155:
            r110.popLimit(r120);     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            goto L4
        L161:
            this.bitField0_ |= 1;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            this.flags_ = r110.readInt32();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            goto L4
        L165:
            if (parseUnknownField(r110, r101, r111, r112) == true) goto L4;
        L9:
            if ((this.bitField0_ & 128) != 128) goto L11;
            r113 = this.versionRequirementTable_.toBuilder();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        L11:
            VersionRequirementTable.Builder r121 = r113;
            VersionRequirementTable r122 = (VersionRequirementTable) r110.readMessage(VersionRequirementTable.PARSER, r111);     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            this.versionRequirementTable_ = r122;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            if (r121 == 0) goto L14;
            r121.mergeFrom(r122);     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            this.versionRequirementTable_ = r121.buildPartial();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        L14:
            this.bitField0_ |= 128;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            goto L4
        L25:
            if ((r103 & 4194304) == 4194304) goto L27;
            this.versionRequirement_ = new ArrayList();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            r103 = r103 | 4194304;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        L27:
            this.versionRequirement_.add(Integer.valueOf(r110.readInt32()));     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            goto L4
        L29:
            if ((this.bitField0_ & 64) != 64) goto L31;
            r113 = this.typeTable_.toBuilder();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        L31:
            TypeTable.Builder r123 = r113;
            TypeTable r124 = (TypeTable) r110.readMessage(TypeTable.PARSER, r111);     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            this.typeTable_ = r124;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            if (r123 == 0) goto L34;
            r123.mergeFrom(r124);     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            this.typeTable_ = r123.buildPartial();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        L34:
            this.bitField0_ |= 64;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            goto L4
        L45:
            if ((r103 & 1048576) == 1048576) goto L47;
            this.multiFieldValueClassUnderlyingTypeId_ = new ArrayList();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            r103 = r103 | 1048576;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        L47:
            this.multiFieldValueClassUnderlyingTypeId_.add(Integer.valueOf(r110.readInt32()));     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            goto L4
        L49:
            if ((r103 & 524288) == 524288) goto L51;
            this.multiFieldValueClassUnderlyingType_ = new ArrayList();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            r103 = r103 | 524288;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        L51:
            this.multiFieldValueClassUnderlyingType_.add((Type) r110.readMessage(Type.PARSER, r111));     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            goto L4
        L62:
            if ((r103 & 262144) == 262144) goto L64;
            this.multiFieldValueClassUnderlyingName_ = new ArrayList();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            r103 = r103 | 262144;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        L64:
            this.multiFieldValueClassUnderlyingName_.add(Integer.valueOf(r110.readInt32()));     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            goto L4
        L75:
            if ((r103 & 256) == 256) goto L77;
            this.contextReceiverTypeId_ = new ArrayList();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            r103 = r103 | 256;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        L77:
            this.contextReceiverTypeId_.add(Integer.valueOf(r110.readInt32()));     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            goto L4
        L79:
            if ((r103 & 128) == 128) goto L81;
            this.contextReceiverType_ = new ArrayList();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            r103 = r103 | 128;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        L81:
            this.contextReceiverType_.add((Type) r110.readMessage(Type.PARSER, r111));     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            goto L4
        L84:
            if ((this.bitField0_ & 16) != 16) goto L86;
            r113 = this.inlineClassUnderlyingType_.toBuilder();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        L86:
            Type.Builder r125 = r113;
            Type r126 = (Type) r110.readMessage(Type.PARSER, r111);     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            this.inlineClassUnderlyingType_ = r126;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            if (r125 == 0) goto L89;
            r125.mergeFrom(r126);     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            this.inlineClassUnderlyingType_ = r125.buildPartial();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        L89:
            this.bitField0_ |= 16;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            goto L4
        L101:
            if ((r103 & 16384) == 16384) goto L103;
            this.sealedSubclassFqName_ = new ArrayList();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            r103 = r103 | 16384;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        L103:
            this.sealedSubclassFqName_.add(Integer.valueOf(r110.readInt32()));     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            goto L4
        L105:
            if ((r103 & 8192) == 8192) goto L107;
            this.enumEntry_ = new ArrayList();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            r103 = r103 | 8192;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        L107:
            this.enumEntry_.add((EnumEntry) r110.readMessage(EnumEntry.PARSER, r111));     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            goto L4
        L109:
            if ((r103 & 4096) == 4096) goto L111;
            this.typeAlias_ = new ArrayList();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            r103 = r103 | 4096;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        L111:
            this.typeAlias_.add((TypeAlias) r110.readMessage(TypeAlias.PARSER, r111));     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            goto L4
        L113:
            if ((r103 & 2048) == 2048) goto L115;
            this.property_ = new ArrayList();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            r103 = r103 | 2048;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        L115:
            this.property_.add((Property) r110.readMessage(Property.PARSER, r111));     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            goto L4
        L117:
            if ((r103 & 1024) == 1024) goto L119;
            this.function_ = new ArrayList();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            r103 = r103 | 1024;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        L119:
            this.function_.add((Function) r110.readMessage(Function.PARSER, r111));     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            goto L4
        L121:
            if ((r103 & 512) == 512) goto L123;
            this.constructor_ = new ArrayList();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            r103 = r103 | 512;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        L123:
            this.constructor_.add((Constructor) r110.readMessage(Constructor.PARSER, r111));     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            goto L4
        L134:
            if ((r103 & 64) == 64) goto L136;
            this.nestedClassName_ = new ArrayList();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            r103 = r103 | 64;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        L136:
            this.nestedClassName_.add(Integer.valueOf(r110.readInt32()));     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            goto L4
        L138:
            if ((r103 & 16) == 16) goto L140;
            this.supertype_ = new ArrayList();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            r103 = r103 | 16;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        L140:
            this.supertype_.add((Type) r110.readMessage(Type.PARSER, r111));     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            goto L4
        L142:
            if ((r103 & 8) == 8) goto L144;
            this.typeParameter_ = new ArrayList();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            r103 = r103 | 8;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        L144:
            this.typeParameter_.add((TypeParameter) r110.readMessage(TypeParameter.PARSER, r111));     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            goto L4
        L157:
            if ((r103 & 32) == 32) goto L159;
            this.supertypeId_ = new ArrayList();     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
            r103 = r103 | 32;     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        L159:
            this.supertypeId_.add(Integer.valueOf(r110.readInt32()));     // Catch: Throwable -> L168 IOException -> L170 InvalidProtocolBufferException -> L174
        L164:
            r102 = true;
            goto L4
        L168:
            th = move-exception;
            if ((r103 & 32) != 32) goto L181;
            this.supertypeId_ = Collections.unmodifiableList(this.supertypeId_);
        L181:
            if ((r103 & 8) != 8) goto L184;
            this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
        L184:
            if ((r103 & 16) != 16) goto L187;
            this.supertype_ = Collections.unmodifiableList(this.supertype_);
        L187:
            if ((r103 & 64) != 64) goto L190;
            this.nestedClassName_ = Collections.unmodifiableList(this.nestedClassName_);
        L190:
            if ((r103 & 512) != 512) goto L193;
            this.constructor_ = Collections.unmodifiableList(this.constructor_);
        L193:
            if ((r103 & 1024) != 1024) goto L196;
            this.function_ = Collections.unmodifiableList(this.function_);
        L196:
            if ((r103 & 2048) != 2048) goto L199;
            this.property_ = Collections.unmodifiableList(this.property_);
        L199:
            if ((r103 & 4096) != 4096) goto L202;
            this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
        L202:
            if ((r103 & 8192) != 8192) goto L205;
            this.enumEntry_ = Collections.unmodifiableList(this.enumEntry_);
        L205:
            if ((r103 & 16384) != 16384) goto L208;
            this.sealedSubclassFqName_ = Collections.unmodifiableList(this.sealedSubclassFqName_);
        L208:
            if ((r103 & 128) != 128) goto L211;
            this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
        L211:
            if ((r103 & 256) != 256) goto L214;
            this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
        L214:
            if ((r103 & 262144) != 262144) goto L217;
            this.multiFieldValueClassUnderlyingName_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingName_);
        L217:
            if ((r103 & 524288) != 524288) goto L220;
            this.multiFieldValueClassUnderlyingType_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingType_);
        L220:
            if ((r103 & 1048576) != 1048576) goto L223;
            this.multiFieldValueClassUnderlyingTypeId_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingTypeId_);
        L223:
            if ((r103 & 4194304) != 4194304) goto L291;
            this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
        L291:
            r101.flush();     // Catch: IOException -> L288 Throwable -> L227
        L227:
            th = move-exception;
            this.unknownFields = r100.toByteString();
            throw th;
        L226:
            this.unknownFields = r100.toByteString();
            makeExtensionsImmutable();
            throw th;
        L174:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L168
        L170:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L168
        L233:
            if ((r103 & 32) != 32) goto L236;
            this.supertypeId_ = Collections.unmodifiableList(this.supertypeId_);
        L236:
            if ((r103 & 8) != 8) goto L239;
            this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
        L239:
            if ((r103 & 16) != 16) goto L242;
            this.supertype_ = Collections.unmodifiableList(this.supertype_);
        L242:
            if ((r103 & 64) != 64) goto L245;
            this.nestedClassName_ = Collections.unmodifiableList(this.nestedClassName_);
        L245:
            if ((r103 & 512) != 512) goto L248;
            this.constructor_ = Collections.unmodifiableList(this.constructor_);
        L248:
            if ((r103 & 1024) != 1024) goto L251;
            this.function_ = Collections.unmodifiableList(this.function_);
        L251:
            if ((r103 & 2048) != 2048) goto L254;
            this.property_ = Collections.unmodifiableList(this.property_);
        L254:
            if ((r103 & 4096) != 4096) goto L257;
            this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
        L257:
            if ((r103 & 8192) != 8192) goto L260;
            this.enumEntry_ = Collections.unmodifiableList(this.enumEntry_);
        L260:
            if ((r103 & 16384) != 16384) goto L263;
            this.sealedSubclassFqName_ = Collections.unmodifiableList(this.sealedSubclassFqName_);
        L263:
            if ((r103 & 128) != 128) goto L266;
            this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
        L266:
            if ((r103 & 256) != 256) goto L269;
            this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
        L269:
            if ((r103 & 262144) != 262144) goto L272;
            this.multiFieldValueClassUnderlyingName_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingName_);
        L272:
            if ((r103 & 524288) != 524288) goto L275;
            this.multiFieldValueClassUnderlyingType_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingType_);
        L275:
            if ((r103 & 1048576) != 1048576) goto L278;
            this.multiFieldValueClassUnderlyingTypeId_ = Collections.unmodifiableList(this.multiFieldValueClassUnderlyingTypeId_);
        L278:
            if ((r103 & 4194304) != 4194304) goto L293;
            this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
        L293:
            r101.flush();     // Catch: IOException -> L287 Throwable -> L282
        L282:
            th = move-exception;
            this.unknownFields = r100.toByteString();
            throw th;
        L281:
            this.unknownFields = r100.toByteString();
            makeExtensionsImmutable();
        }

        public static /* synthetic */ List access$10002(Class r100, List r101) {
            r100.property_ = r101;
            return r101;
        }

        public static /* synthetic */ List access$10102(Class r100, List r101) {
            r100.typeAlias_ = r101;
            return r101;
        }

        public static /* synthetic */ List access$10202(Class r100, List r101) {
            r100.enumEntry_ = r101;
            return r101;
        }

        public static /* synthetic */ List access$10302(Class r100, List r101) {
            r100.sealedSubclassFqName_ = r101;
            return r101;
        }

        public static /* synthetic */ int access$10402(Class r100, int r101) {
            r100.inlineClassUnderlyingPropertyName_ = r101;
            return r101;
        }

        public static /* synthetic */ Type access$10502(Class r100, Type r101) {
            r100.inlineClassUnderlyingType_ = r101;
            return r101;
        }

        public static /* synthetic */ int access$10602(Class r100, int r101) {
            r100.inlineClassUnderlyingTypeId_ = r101;
            return r101;
        }

        public static /* synthetic */ List access$10702(Class r100, List r101) {
            r100.multiFieldValueClassUnderlyingName_ = r101;
            return r101;
        }

        public static /* synthetic */ List access$10802(Class r100, List r101) {
            r100.multiFieldValueClassUnderlyingType_ = r101;
            return r101;
        }

        public static /* synthetic */ List access$10902(Class r100, List r101) {
            r100.multiFieldValueClassUnderlyingTypeId_ = r101;
            return r101;
        }

        public static /* synthetic */ TypeTable access$11002(Class r100, TypeTable r101) {
            r100.typeTable_ = r101;
            return r101;
        }

        public static /* synthetic */ List access$11102(Class r100, List r101) {
            r100.versionRequirement_ = r101;
            return r101;
        }

        public static /* synthetic */ VersionRequirementTable access$11202(Class r100, VersionRequirementTable r101) {
            r100.versionRequirementTable_ = r101;
            return r101;
        }

        public static /* synthetic */ int access$11302(Class r100, int r101) {
            r100.bitField0_ = r101;
            return r101;
        }

        public static /* synthetic */ int access$8902(Class r100, int r101) {
            r100.flags_ = r101;
            return r101;
        }

        public static /* synthetic */ int access$9002(Class r100, int r101) {
            r100.fqName_ = r101;
            return r101;
        }

        public static /* synthetic */ int access$9102(Class r100, int r101) {
            r100.companionObjectName_ = r101;
            return r101;
        }

        public static /* synthetic */ List access$9202(Class r100, List r101) {
            r100.typeParameter_ = r101;
            return r101;
        }

        public static /* synthetic */ List access$9302(Class r100, List r101) {
            r100.supertype_ = r101;
            return r101;
        }

        public static /* synthetic */ List access$9402(Class r100, List r101) {
            r100.supertypeId_ = r101;
            return r101;
        }

        public static /* synthetic */ List access$9502(Class r100, List r101) {
            r100.nestedClassName_ = r101;
            return r101;
        }

        public static /* synthetic */ List access$9602(Class r100, List r101) {
            r100.contextReceiverType_ = r101;
            return r101;
        }

        public static /* synthetic */ List access$9702(Class r100, List r101) {
            r100.contextReceiverTypeId_ = r101;
            return r101;
        }

        public static /* synthetic */ List access$9802(Class r100, List r101) {
            r100.constructor_ = r101;
            return r101;
        }

        public static /* synthetic */ List access$9902(Class r100, List r101) {
            r100.function_ = r101;
            return r101;
        }

        public static Class parseFrom(InputStream r100, ExtensionRegistryLite r101) throws IOException {
            return PARSER.parseFrom(r100, r101);
        }

        public /* synthetic */ Class(GeneratedMessageLite.ExtendableBuilder r100, AnonymousClass1 r101) {
            this(r100);
        }

        public /* synthetic */ Class(CodedInputStream r100, ExtensionRegistryLite r101, AnonymousClass1 r102) throws InvalidProtocolBufferException {
            this(r100, r101);
        }
    }

    /* JADX INFO: loaded from: classes5.dex */
    public interface ClassOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder {
    }

    /* JADX INFO: loaded from: classes5.dex */
    public static final class Constructor extends GeneratedMessageLite.ExtendableMessage<Constructor> implements ConstructorOrBuilder {
        public static Parser<Constructor> PARSER;
        private static final Constructor defaultInstance = null;
        private int bitField0_;
        private int flags_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private final ByteString unknownFields;
        private List<ValueParameter> valueParameter_;
        private List<Integer> versionRequirement_;

        /* JADX INFO: loaded from: classes42.dex */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<Constructor, Builder> implements ConstructorOrBuilder {
            private int bitField0_;
            private int flags_;
            private List<ValueParameter> valueParameter_;
            private List<Integer> versionRequirement_;

            private void maybeForceBuilderInitialization() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                int r100 = 0;
            L4:
                if (r100 >= getValueParameterCount()) goto L10;
                if (getValueParameter(r100).isInitialized() == false) goto L7;
                r100 = r100 + 1;
                goto L4
            L7:
                return false;
            L10:
                if (extensionsAreInitialized() == true) goto L12;
                return false;
            L12:
                return true;
            }

            private static Builder create() {
                return new Builder();
            }

            private void ensureValueParameterIsMutable() {
                if ((this.bitField0_ & 2) == 2) goto L6;
                this.valueParameter_ = new ArrayList(this.valueParameter_);
                this.bitField0_ |= 2;
                return;
            }

            private void ensureVersionRequirementIsMutable() {
                if ((this.bitField0_ & 4) == 4) goto L6;
                this.versionRequirement_ = new ArrayList(this.versionRequirement_);
                this.bitField0_ |= 4;
                return;
            }

            public Constructor buildPartial() {
                Constructor r100 = new Constructor(this, null);
                int r101 = 1;
                if ((this.bitField0_ & 1) == 1) goto L6;
                r101 = 0;
            L6:
                Constructor.access$13502(r100, this.flags_);
                if ((this.bitField0_ & 2) != 2) goto L9;
                this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
                this.bitField0_ &= -3;
            L9:
                Constructor.access$13602(r100, this.valueParameter_);
                if ((this.bitField0_ & 4) != 4) goto L12;
                this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                this.bitField0_ &= -5;
            L12:
                Constructor.access$13702(r100, this.versionRequirement_);
                Constructor.access$13802(r100, r101);
                return r100;
            }

            public int getValueParameterCount() {
                return this.valueParameter_.size();
            }

            private Builder() {
                this.flags_ = 6;
                this.valueParameter_ = Collections.emptyList();
                this.versionRequirement_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            public static /* synthetic */ Builder access$13300() {
                return create();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Constructor build() {
                Constructor r100 = buildPartial();
                if (r100.isInitialized() == false) goto L6;
                return r100;
            L6:
                throw AbstractMessageLite.Builder.newUninitializedMessageException(r100);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public Constructor getDefaultInstanceForType() {
                return Constructor.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo10730clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.ExtendableBuilder clone() {
                return clone();
            }

            public ValueParameter getValueParameter(int r100) {
                return (ValueParameter) ListProtector.get(this.valueParameter_, r100);
            }

            public Builder mergeFrom(Constructor r100) {
                if (r100 != Constructor.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r100.hasFlags() == false) goto L9;
                setFlags(r100.getFlags());
            L9:
                if (Constructor.access$13600(r100).isEmpty() == true) goto L15;
                if (this.valueParameter_.isEmpty() == false) goto L13;
                this.valueParameter_ = Constructor.access$13600(r100);
                this.bitField0_ &= -3;
                goto L15
            L13:
                ensureValueParameterIsMutable();
                this.valueParameter_.addAll(Constructor.access$13600(r100));
            L15:
                if (Constructor.access$13700(r100).isEmpty() == false) goto L17;
            L20:
                mergeExtensionFields(r100);
                setUnknownFields(getUnknownFields().concat(Constructor.access$13900(r100)));
                return this;
            L17:
                if (this.versionRequirement_.isEmpty() == false) goto L19;
                this.versionRequirement_ = Constructor.access$13700(r100);
                this.bitField0_ &= -5;
                goto L20
            L19:
                ensureVersionRequirementIsMutable();
                this.versionRequirement_.addAll(Constructor.access$13700(r100));
                goto L20
            }

            public Builder setFlags(int r100) {
                this.bitField0_ |= 1;
                this.flags_ = r100;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r100) {
                return mergeFrom((Constructor) r100);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
                Constructor r102 = null;
                Constructor r103 = Constructor.PARSER.parsePartialFrom(r100, r101);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r103 == null) goto L6;
                mergeFrom(r103);
            L6:
                return this;
            L9:
                e = move-exception;
                Constructor r104 = (Constructor) e.getUnfinishedMessage();     // Catch: Throwable -> L7
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
            this.flags_ = 6;
            this.valueParameter_ = Collections.emptyList();
            this.versionRequirement_ = Collections.emptyList();
        }

        static {
            PARSER = new AnonymousClass1();
            Constructor r100 = new Constructor(true);
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
            if ((this.bitField0_ & 1) != 1) goto L8;
            int r102 = CodedOutputStream.computeInt32Size(1, this.flags_) + 0;
        L9:
            int r103 = 0;
        L11:
            if (r103 >= this.valueParameter_.size()) goto L13;
            r102 = r102 + CodedOutputStream.computeMessageSize(2, (MessageLite) ListProtector.get(this.valueParameter_, r103));
            r103 = r103 + 1;
            goto L11
        L13:
            int r104 = 0;
        L15:
            if (r101 >= this.versionRequirement_.size()) goto L17;
            r104 = r104 + CodedOutputStream.computeInt32SizeNoTag(((Integer) ListProtector.get(this.versionRequirement_, r101)).intValue());
            r101 = r101 + 1;
            goto L15
        L17:
            int r105 = (((r102 + r104) + (getVersionRequirementList().size() * 2)) + extensionsSerializedSize()) + this.unknownFields.size();
            this.memoizedSerializedSize = r105;
            return r105;
        L8:
            r102 = 0;
            goto L9
        }

        public int getValueParameterCount() {
            return this.valueParameter_.size();
        }

        public boolean hasFlags() {
            if ((this.bitField0_ & 1) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte r100 = this.memoizedIsInitialized;
            if (r100 != 1) goto L6;
            return true;
        L6:
            if (r100 != 0) goto L8;
            return false;
        L8:
            int r101 = 0;
        L10:
            if (r101 >= getValueParameterCount()) goto L17;
            if (getValueParameter(r101).isInitialized() == false) goto L13;
            r101 = r101 + 1;
            goto L10
        L13:
            this.memoizedIsInitialized = 0;
            return false;
        L17:
            if (extensionsAreInitialized() == true) goto L20;
            this.memoizedIsInitialized = 0;
            return false;
        L20:
            this.memoizedIsInitialized = 1;
            return true;
        }

        public static Builder newBuilder() {
            return Builder.access$13300();
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

        public static Constructor getDefaultInstance() {
            return defaultInstance;
        }

        public int getFlags() {
            return this.flags_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<Constructor> getParserForType() {
            return PARSER;
        }

        public List<ValueParameter> getValueParameterList() {
            return this.valueParameter_;
        }

        public List<Integer> getVersionRequirementList() {
            return this.versionRequirement_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public Constructor getDefaultInstanceForType() {
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

        private Constructor(GeneratedMessageLite.ExtendableBuilder<Constructor, ?> r100) {
            super(r100);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r100.getUnknownFields();
        }

        public static /* synthetic */ List access$13600(Constructor r100) {
            return r100.valueParameter_;
        }

        public static /* synthetic */ List access$13700(Constructor r100) {
            return r100.versionRequirement_;
        }

        public static /* synthetic */ ByteString access$13900(Constructor r100) {
            return r100.unknownFields;
        }

        public static Builder newBuilder(Constructor r100) {
            return newBuilder().mergeFrom(r100);
        }

        public ValueParameter getValueParameter(int r100) {
            return (ValueParameter) ListProtector.get(this.valueParameter_, r100);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r100) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter r101 = newExtensionWriter();
            if ((this.bitField0_ & 1) != 1) goto L5;
            r100.writeInt32(1, this.flags_);
        L5:
            int r102 = 0;
            int r103 = 0;
        L7:
            if (r103 >= this.valueParameter_.size()) goto L10;
            r100.writeMessage(2, (MessageLite) ListProtector.get(this.valueParameter_, r103));
            r103 = r103 + 1;
        L10:
            if (r102 >= this.versionRequirement_.size()) goto L12;
            r100.writeInt32(31, ((Integer) ListProtector.get(this.versionRequirement_, r102)).intValue());
            r102 = r102 + 1;
            goto L10
        L12:
            r101.writeUntil(19000, r100);
            r100.writeRawBytes(this.unknownFields);
        }

        private Constructor(boolean r100) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        private Constructor(CodedInputStream r110, ExtensionRegistryLite r111) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r100 = ByteString.newOutput();
            CodedOutputStream r101 = CodedOutputStream.newInstance(r100, 1);
            boolean r102 = false;
            int r103 = 0;
        L4:
            if (r102 == true) goto L60;
            int r104 = r110.readTag();     // Catch: Throwable -> L38 IOException -> L40 InvalidProtocolBufferException -> L43
            if (r104 == 0) goto L37;
            if (r104 != 8) goto L10;
            this.bitField0_ |= 1;     // Catch: Throwable -> L38 IOException -> L40 InvalidProtocolBufferException -> L43
            this.flags_ = r110.readInt32();     // Catch: Throwable -> L38 IOException -> L40 InvalidProtocolBufferException -> L43
            goto L4
        L10:
            if (r104 != 18) goto L12;
            if ((r103 & 2) == 2) goto L34;
            this.valueParameter_ = new ArrayList();     // Catch: Throwable -> L38 IOException -> L40 InvalidProtocolBufferException -> L43
            r103 = r103 | 2;     // Catch: Throwable -> L38 IOException -> L40 InvalidProtocolBufferException -> L43
        L34:
            this.valueParameter_.add((ValueParameter) r110.readMessage(ValueParameter.PARSER, r111));     // Catch: Throwable -> L38 IOException -> L40 InvalidProtocolBufferException -> L43
            goto L4
        L12:
            if (r104 != 248) goto L14;
            if ((r103 & 4) == 4) goto L30;
            this.versionRequirement_ = new ArrayList();     // Catch: Throwable -> L38 IOException -> L40 InvalidProtocolBufferException -> L43
            r103 = r103 | 4;     // Catch: Throwable -> L38 IOException -> L40 InvalidProtocolBufferException -> L43
        L30:
            this.versionRequirement_.add(Integer.valueOf(r110.readInt32()));     // Catch: Throwable -> L38 IOException -> L40 InvalidProtocolBufferException -> L43
            goto L4
        L14:
            if (r104 != 250) goto L16;
            int r105 = r110.pushLimit(r110.readRawVarint32());     // Catch: Throwable -> L38 IOException -> L40 InvalidProtocolBufferException -> L43
            if ((r103 & 4) == 4) goto L24;
            if (r110.getBytesUntilLimit() <= 0) goto L24;
            this.versionRequirement_ = new ArrayList();     // Catch: Throwable -> L38 IOException -> L40 InvalidProtocolBufferException -> L43
            r103 = r103 | 4;     // Catch: Throwable -> L38 IOException -> L40 InvalidProtocolBufferException -> L43
        L24:
            if (r110.getBytesUntilLimit() <= 0) goto L26;
            this.versionRequirement_.add(Integer.valueOf(r110.readInt32()));     // Catch: Throwable -> L38 IOException -> L40 InvalidProtocolBufferException -> L43
            goto L24
        L26:
            r110.popLimit(r105);     // Catch: Throwable -> L38 IOException -> L40 InvalidProtocolBufferException -> L43
            goto L4
        L16:
            if (parseUnknownField(r110, r101, r111, r104) == true) goto L4;
        L37:
            r102 = true;
            goto L4
        L38:
            th = move-exception;
            if ((r103 & 2) != 2) goto L50;
            this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
        L50:
            if ((r103 & 4) != 4) goto L78;
            this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
        L78:
            r101.flush();     // Catch: IOException -> L73 Throwable -> L54
        L54:
            th = move-exception;
            this.unknownFields = r100.toByteString();
            throw th;
        L53:
            this.unknownFields = r100.toByteString();
            makeExtensionsImmutable();
            throw th;
        L43:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L38
        L40:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L38
        L60:
            if ((r103 & 2) != 2) goto L63;
            this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
        L63:
            if ((r103 & 4) != 4) goto L76;
            this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
        L76:
            r101.flush();     // Catch: IOException -> L72 Throwable -> L67
        L67:
            th = move-exception;
            this.unknownFields = r100.toByteString();
            throw th;
        L66:
            this.unknownFields = r100.toByteString();
            makeExtensionsImmutable();
        }

        public static /* synthetic */ int access$13502(Constructor r100, int r101) {
            r100.flags_ = r101;
            return r101;
        }

        public static /* synthetic */ List access$13602(Constructor r100, List r101) {
            r100.valueParameter_ = r101;
            return r101;
        }

        public static /* synthetic */ List access$13702(Constructor r100, List r101) {
            r100.versionRequirement_ = r101;
            return r101;
        }

        public static /* synthetic */ int access$13802(Constructor r100, int r101) {
            r100.bitField0_ = r101;
            return r101;
        }

        public /* synthetic */ Constructor(GeneratedMessageLite.ExtendableBuilder r100, AnonymousClass1 r101) {
            this(r100);
        }

        public /* synthetic */ Constructor(CodedInputStream r100, ExtensionRegistryLite r101, AnonymousClass1 r102) throws InvalidProtocolBufferException {
            this(r100, r101);
        }
    }

    /* JADX INFO: loaded from: classes5.dex */
    public interface ConstructorOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder {
    }

    /* JADX INFO: loaded from: classes5.dex */
    public static final class Contract extends GeneratedMessageLite implements ContractOrBuilder {
        public static Parser<Contract> PARSER;
        private static final Contract defaultInstance = null;
        private List<Effect> effect_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private final ByteString unknownFields;

        public static final class Builder extends GeneratedMessageLite.Builder<Contract, Builder> implements ContractOrBuilder {
            private int bitField0_;
            private List<Effect> effect_;

            private void maybeForceBuilderInitialization() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                int r100 = 0;
            L4:
                if (r100 >= getEffectCount()) goto L9;
                if (getEffect(r100).isInitialized() == false) goto L7;
                r100 = r100 + 1;
                goto L4
            L7:
                return false;
            L9:
                return true;
            }

            private static Builder create() {
                return new Builder();
            }

            private void ensureEffectIsMutable() {
                if ((this.bitField0_ & 1) == 1) goto L6;
                this.effect_ = new ArrayList(this.effect_);
                this.bitField0_ |= 1;
                return;
            }

            public Contract buildPartial() {
                Contract r100 = new Contract(this, null);
                if ((this.bitField0_ & 1) != 1) goto L5;
                this.effect_ = Collections.unmodifiableList(this.effect_);
                this.bitField0_ &= -2;
            L5:
                Contract.access$23702(r100, this.effect_);
                return r100;
            }

            public int getEffectCount() {
                return this.effect_.size();
            }

            private Builder() {
                this.effect_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            public static /* synthetic */ Builder access$23500() {
                return create();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Contract build() {
                Contract r100 = buildPartial();
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
            public Contract getDefaultInstanceForType() {
                return Contract.getDefaultInstance();
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

            public Effect getEffect(int r100) {
                return (Effect) ListProtector.get(this.effect_, r100);
            }

            public Builder mergeFrom(Contract r100) {
                if (r100 != Contract.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (Contract.access$23700(r100).isEmpty() == false) goto L8;
            L11:
                setUnknownFields(getUnknownFields().concat(Contract.access$23800(r100)));
                return this;
            L8:
                if (this.effect_.isEmpty() == false) goto L10;
                this.effect_ = Contract.access$23700(r100);
                this.bitField0_ &= -2;
                goto L11
            L10:
                ensureEffectIsMutable();
                this.effect_.addAll(Contract.access$23700(r100));
                goto L11
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r100) {
                return mergeFrom((Contract) r100);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
                Contract r102 = null;
                Contract r103 = Contract.PARSER.parsePartialFrom(r100, r101);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r103 == null) goto L6;
                mergeFrom(r103);
            L6:
                return this;
            L9:
                e = move-exception;
                Contract r104 = (Contract) e.getUnfinishedMessage();     // Catch: Throwable -> L7
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
            Contract r100 = new Contract(true);
            defaultInstance = r100;
            r100.initFields();
        }

        public int getEffectCount() {
            return this.effect_.size();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int r100 = this.memoizedSerializedSize;
            if (r100 == (-1)) goto L5;
            return r100;
        L5:
            int r101 = 0;
            int r102 = 0;
        L7:
            if (r101 >= this.effect_.size()) goto L9;
            r102 = r102 + CodedOutputStream.computeMessageSize(1, (MessageLite) ListProtector.get(this.effect_, r101));
            r101 = r101 + 1;
            goto L7
        L9:
            int r103 = r102 + this.unknownFields.size();
            this.memoizedSerializedSize = r103;
            return r103;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte r100 = this.memoizedIsInitialized;
            if (r100 != 1) goto L6;
            return true;
        L6:
            if (r100 != 0) goto L8;
            return false;
        L8:
            int r101 = 0;
        L10:
            if (r101 >= getEffectCount()) goto L16;
            if (getEffect(r101).isInitialized() == false) goto L13;
            r101 = r101 + 1;
            goto L10
        L13:
            this.memoizedIsInitialized = 0;
            return false;
        L16:
            this.memoizedIsInitialized = 1;
            return true;
        }

        private void initFields() {
            this.effect_ = Collections.emptyList();
        }

        public static Builder newBuilder() {
            return Builder.access$23500();
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

        public static Contract getDefaultInstance() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<Contract> getParserForType() {
            return PARSER;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public Contract getDefaultInstanceForType() {
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

        private Contract(GeneratedMessageLite.Builder r100) {
            super(r100);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r100.getUnknownFields();
        }

        public static /* synthetic */ List access$23700(Contract r100) {
            return r100.effect_;
        }

        public static /* synthetic */ ByteString access$23800(Contract r100) {
            return r100.unknownFields;
        }

        public static Builder newBuilder(Contract r100) {
            return newBuilder().mergeFrom(r100);
        }

        public Effect getEffect(int r100) {
            return (Effect) ListProtector.get(this.effect_, r100);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r100) throws IOException {
            getSerializedSize();
            int r101 = 0;
        L4:
            if (r101 >= this.effect_.size()) goto L6;
            r100.writeMessage(1, (MessageLite) ListProtector.get(this.effect_, r101));
            r101 = r101 + 1;
            goto L4
        L6:
            r100.writeRawBytes(this.unknownFields);
        }

        private Contract(boolean r100) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        private Contract(CodedInputStream r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r102 = ByteString.newOutput();
            CodedOutputStream r103 = CodedOutputStream.newInstance(r102, 1);
            boolean r104 = false;
            boolean r105 = false;
        L3:
            if (r104 == true) goto L36;
            int r106 = r100.readTag();     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
            if (r106 == 0) goto L16;
            if (r106 != 10) goto L9;
            if ((r105 & true) == true) goto L14;
            this.effect_ = new ArrayList();     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
            r105 = r105 | true;     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
        L14:
            this.effect_.add((Effect) r100.readMessage(Effect.PARSER, r101));     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
            goto L3
        L9:
            if (parseUnknownField(r100, r103, r101, r106) == true) goto L3;
        L16:
            r104 = true;
            goto L3
        L17:
            th = move-exception;
            if ((r105 & true) != true) goto L48;
            this.effect_ = Collections.unmodifiableList(this.effect_);
        L48:
            r103.flush();     // Catch: IOException -> L46 Throwable -> L30
        L30:
            th = move-exception;
            this.unknownFields = r102.toByteString();
            throw th;
        L29:
            this.unknownFields = r102.toByteString();
            makeExtensionsImmutable();
            throw th;
        L22:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L17
        L19:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L17
        L36:
            if ((r105 & true) != true) goto L51;
            this.effect_ = Collections.unmodifiableList(this.effect_);
        L51:
            r103.flush();     // Catch: IOException -> L45 Throwable -> L40
        L40:
            th = move-exception;
            this.unknownFields = r102.toByteString();
            throw th;
        L39:
            this.unknownFields = r102.toByteString();
            makeExtensionsImmutable();
        }

        public static /* synthetic */ List access$23702(Contract r100, List r101) {
            r100.effect_ = r101;
            return r101;
        }

        public /* synthetic */ Contract(GeneratedMessageLite.Builder r100, AnonymousClass1 r101) {
            this(r100);
        }

        public /* synthetic */ Contract(CodedInputStream r100, ExtensionRegistryLite r101, AnonymousClass1 r102) throws InvalidProtocolBufferException {
            this(r100, r101);
        }
    }

    /* JADX INFO: loaded from: classes5.dex */
    public interface ContractOrBuilder extends MessageLiteOrBuilder {
    }

    public static final class Effect extends GeneratedMessageLite implements EffectOrBuilder {
        public static Parser<Effect> PARSER;
        private static final Effect defaultInstance = null;
        private int bitField0_;
        private Expression conclusionOfConditionalEffect_;
        private List<Expression> effectConstructorArgument_;
        private EffectType effectType_;
        private InvocationKind kind_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private final ByteString unknownFields;

        public static final class Builder extends GeneratedMessageLite.Builder<Effect, Builder> implements EffectOrBuilder {
            private int bitField0_;
            private Expression conclusionOfConditionalEffect_;
            private List<Expression> effectConstructorArgument_;
            private EffectType effectType_;
            private InvocationKind kind_;

            private void maybeForceBuilderInitialization() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                int r100 = 0;
            L4:
                if (r100 >= getEffectConstructorArgumentCount()) goto L10;
                if (getEffectConstructorArgument(r100).isInitialized() == false) goto L7;
                r100 = r100 + 1;
                goto L4
            L7:
                return false;
            L10:
                if (hasConclusionOfConditionalEffect() == true) goto L12;
                return true;
            L12:
                if (getConclusionOfConditionalEffect().isInitialized() == true) goto L18;
                return false;
            L18:
                return true;
            }

            private static Builder create() {
                return new Builder();
            }

            private void ensureEffectConstructorArgumentIsMutable() {
                if ((this.bitField0_ & 2) == 2) goto L6;
                this.effectConstructorArgument_ = new ArrayList(this.effectConstructorArgument_);
                this.bitField0_ |= 2;
                return;
            }

            public Effect buildPartial() {
                Effect r100 = new Effect(this, null);
                int r101 = this.bitField0_;
                int r102 = 1;
                if ((r101 & 1) == 1) goto L6;
                r102 = 0;
            L6:
                Effect.access$24202(r100, this.effectType_);
                if ((this.bitField0_ & 2) != 2) goto L9;
                this.effectConstructorArgument_ = Collections.unmodifiableList(this.effectConstructorArgument_);
                this.bitField0_ &= -3;
            L9:
                Effect.access$24302(r100, this.effectConstructorArgument_);
                if ((r101 & 4) != 4) goto L12;
                r102 = r102 | 2;
            L12:
                Effect.access$24402(r100, this.conclusionOfConditionalEffect_);
                if ((r101 & 8) != 8) goto L15;
                r102 = r102 | 4;
            L15:
                Effect.access$24502(r100, this.kind_);
                Effect.access$24602(r100, r102);
                return r100;
            }

            public int getEffectConstructorArgumentCount() {
                return this.effectConstructorArgument_.size();
            }

            public boolean hasConclusionOfConditionalEffect() {
                if ((this.bitField0_ & 4) != 4) goto L5;
                return true;
            L5:
                return false;
            }

            private Builder() {
                this.effectType_ = EffectType.RETURNS_CONSTANT;
                this.effectConstructorArgument_ = Collections.emptyList();
                this.conclusionOfConditionalEffect_ = Expression.getDefaultInstance();
                this.kind_ = InvocationKind.AT_MOST_ONCE;
                maybeForceBuilderInitialization();
            }

            public static /* synthetic */ Builder access$24000() {
                return create();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Effect build() {
                Effect r100 = buildPartial();
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
            public Effect getDefaultInstanceForType() {
                return Effect.getDefaultInstance();
            }

            public Expression getConclusionOfConditionalEffect() {
                return this.conclusionOfConditionalEffect_;
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

            public Expression getEffectConstructorArgument(int r100) {
                return (Expression) ListProtector.get(this.effectConstructorArgument_, r100);
            }

            public Builder mergeConclusionOfConditionalEffect(Expression r100) {
                if ((this.bitField0_ & 4) == 4) goto L5;
            L7:
                this.conclusionOfConditionalEffect_ = r100;
            L8:
                this.bitField0_ |= 4;
                return this;
            L5:
                if (this.conclusionOfConditionalEffect_ == Expression.getDefaultInstance()) goto L7;
                this.conclusionOfConditionalEffect_ = Expression.newBuilder(this.conclusionOfConditionalEffect_).mergeFrom(r100).buildPartial();
                goto L8
            }

            public Builder mergeFrom(Effect r100) {
                if (r100 != Effect.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r100.hasEffectType() == false) goto L9;
                setEffectType(r100.getEffectType());
            L9:
                if (Effect.access$24300(r100).isEmpty() == true) goto L15;
                if (this.effectConstructorArgument_.isEmpty() == false) goto L13;
                this.effectConstructorArgument_ = Effect.access$24300(r100);
                this.bitField0_ &= -3;
                goto L15
            L13:
                ensureEffectConstructorArgumentIsMutable();
                this.effectConstructorArgument_.addAll(Effect.access$24300(r100));
            L15:
                if (r100.hasConclusionOfConditionalEffect() == false) goto L18;
                mergeConclusionOfConditionalEffect(r100.getConclusionOfConditionalEffect());
            L18:
                if (r100.hasKind() == false) goto L20;
                setKind(r100.getKind());
            L20:
                setUnknownFields(getUnknownFields().concat(Effect.access$24700(r100)));
                return this;
            }

            public Builder setEffectType(EffectType r100) {
                if (r100 == null) goto L6;
                this.bitField0_ |= 1;
                this.effectType_ = r100;
                return this;
            L6:
                throw null;
            }

            public Builder setKind(InvocationKind r100) {
                if (r100 == null) goto L6;
                this.bitField0_ |= 8;
                this.kind_ = r100;
                return this;
            L6:
                throw null;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r100) {
                return mergeFrom((Effect) r100);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
                Effect r102 = null;
                Effect r103 = Effect.PARSER.parsePartialFrom(r100, r101);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r103 == null) goto L6;
                mergeFrom(r103);
            L6:
                return this;
            L9:
                e = move-exception;
                Effect r104 = (Effect) e.getUnfinishedMessage();     // Catch: Throwable -> L7
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

        public static final enum EffectType extends Enum<EffectType> implements Internal.EnumLite {
            private static final /* synthetic */ EffectType[] $VALUES = null;
            public static final EffectType CALLS = null;
            public static final EffectType RETURNS_CONSTANT = null;
            public static final EffectType RETURNS_NOT_NULL = null;
            private static Internal.EnumLiteMap<EffectType> internalValueMap;
            private final int value;

            static {
                EffectType r100 = new EffectType("RETURNS_CONSTANT", 0, 0, 0);
                RETURNS_CONSTANT = r100;
                EffectType r101 = new EffectType("CALLS", 1, 1, 1);
                CALLS = r101;
                EffectType r102 = new EffectType("RETURNS_NOT_NULL", 2, 2, 2);
                RETURNS_NOT_NULL = r102;
                $VALUES = new EffectType[]{r100, r101, r102};
                internalValueMap = new AnonymousClass1();
            }

            public static EffectType[] values() {
                return (EffectType[]) $VALUES.clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            public static EffectType valueOf(int r100) {
                if (r100 == 0) goto L14;
                if (r100 == 1) goto L12;
                if (r100 == 2) goto L10;
                return null;
            L10:
                return RETURNS_NOT_NULL;
            L12:
                return CALLS;
            L14:
                return RETURNS_CONSTANT;
            }

            public static EffectType valueOf(String r100) {
                return (EffectType) a.a(EffectType.class, r100);
            }

            private EffectType(String r100, int r101, int r102, int r103) {
                super(r100, r101);
                this.value = r103;
            }
        }

        public static final enum InvocationKind extends Enum<InvocationKind> implements Internal.EnumLite {
            private static final /* synthetic */ InvocationKind[] $VALUES = null;
            public static final InvocationKind AT_LEAST_ONCE = null;
            public static final InvocationKind AT_MOST_ONCE = null;
            public static final InvocationKind EXACTLY_ONCE = null;
            private static Internal.EnumLiteMap<InvocationKind> internalValueMap;
            private final int value;

            static {
                InvocationKind r100 = new InvocationKind("AT_MOST_ONCE", 0, 0, 0);
                AT_MOST_ONCE = r100;
                InvocationKind r101 = new InvocationKind("EXACTLY_ONCE", 1, 1, 1);
                EXACTLY_ONCE = r101;
                InvocationKind r102 = new InvocationKind("AT_LEAST_ONCE", 2, 2, 2);
                AT_LEAST_ONCE = r102;
                $VALUES = new InvocationKind[]{r100, r101, r102};
                internalValueMap = new AnonymousClass1();
            }

            public static InvocationKind[] values() {
                return (InvocationKind[]) $VALUES.clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            public static InvocationKind valueOf(int r100) {
                if (r100 == 0) goto L14;
                if (r100 == 1) goto L12;
                if (r100 == 2) goto L10;
                return null;
            L10:
                return AT_LEAST_ONCE;
            L12:
                return EXACTLY_ONCE;
            L14:
                return AT_MOST_ONCE;
            }

            public static InvocationKind valueOf(String r100) {
                return (InvocationKind) a.a(InvocationKind.class, r100);
            }

            private InvocationKind(String r100, int r101, int r102, int r103) {
                super(r100, r101);
                this.value = r103;
            }
        }

        static {
            PARSER = new AnonymousClass1();
            Effect r100 = new Effect(true);
            defaultInstance = r100;
            r100.initFields();
        }

        private void initFields() {
            this.effectType_ = EffectType.RETURNS_CONSTANT;
            this.effectConstructorArgument_ = Collections.emptyList();
            this.conclusionOfConditionalEffect_ = Expression.getDefaultInstance();
            this.kind_ = InvocationKind.AT_MOST_ONCE;
        }

        public int getEffectConstructorArgumentCount() {
            return this.effectConstructorArgument_.size();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int r100 = this.memoizedSerializedSize;
            if (r100 == (-1)) goto L5;
            return r100;
        L5:
            int r101 = 0;
            if ((this.bitField0_ & 1) != 1) goto L8;
            int r102 = CodedOutputStream.computeEnumSize(1, this.effectType_.getNumber()) + 0;
        L10:
            if (r101 >= this.effectConstructorArgument_.size()) goto L13;
            r102 = r102 + CodedOutputStream.computeMessageSize(2, (MessageLite) ListProtector.get(this.effectConstructorArgument_, r101));
            r101 = r101 + 1;
            goto L10
        L13:
            if ((this.bitField0_ & 2) != 2) goto L16;
            r102 = r102 + CodedOutputStream.computeMessageSize(3, this.conclusionOfConditionalEffect_);
        L16:
            if ((this.bitField0_ & 4) != 4) goto L18;
            r102 = r102 + CodedOutputStream.computeEnumSize(4, this.kind_.getNumber());
        L18:
            int r103 = r102 + this.unknownFields.size();
            this.memoizedSerializedSize = r103;
            return r103;
        L8:
            r102 = 0;
            goto L10
        }

        public boolean hasConclusionOfConditionalEffect() {
            if ((this.bitField0_ & 2) != 2) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasEffectType() {
            if ((this.bitField0_ & 1) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        public boolean hasKind() {
            if ((this.bitField0_ & 4) != 4) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte r100 = this.memoizedIsInitialized;
            if (r100 != 1) goto L6;
            return true;
        L6:
            if (r100 != 0) goto L8;
            return false;
        L8:
            int r101 = 0;
        L10:
            if (r101 >= getEffectConstructorArgumentCount()) goto L17;
            if (getEffectConstructorArgument(r101).isInitialized() == false) goto L13;
            r101 = r101 + 1;
            goto L10
        L13:
            this.memoizedIsInitialized = 0;
            return false;
        L17:
            if (hasConclusionOfConditionalEffect() == true) goto L19;
        L22:
            this.memoizedIsInitialized = 1;
            return true;
        L19:
            if (getConclusionOfConditionalEffect().isInitialized() == true) goto L22;
            this.memoizedIsInitialized = 0;
            return false;
        }

        public static Builder newBuilder() {
            return Builder.access$24000();
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

        public static Effect getDefaultInstance() {
            return defaultInstance;
        }

        public Expression getConclusionOfConditionalEffect() {
            return this.conclusionOfConditionalEffect_;
        }

        public EffectType getEffectType() {
            return this.effectType_;
        }

        public InvocationKind getKind() {
            return this.kind_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<Effect> getParserForType() {
            return PARSER;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public Effect getDefaultInstanceForType() {
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

        private Effect(GeneratedMessageLite.Builder r100) {
            super(r100);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r100.getUnknownFields();
        }

        public static /* synthetic */ List access$24300(Effect r100) {
            return r100.effectConstructorArgument_;
        }

        public static /* synthetic */ ByteString access$24700(Effect r100) {
            return r100.unknownFields;
        }

        public static Builder newBuilder(Effect r100) {
            return newBuilder().mergeFrom(r100);
        }

        public Expression getEffectConstructorArgument(int r100) {
            return (Expression) ListProtector.get(this.effectConstructorArgument_, r100);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r100) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) != 1) goto L5;
            r100.writeEnum(1, this.effectType_.getNumber());
        L5:
            int r101 = 0;
        L7:
            if (r101 >= this.effectConstructorArgument_.size()) goto L10;
            r100.writeMessage(2, (MessageLite) ListProtector.get(this.effectConstructorArgument_, r101));
            r101 = r101 + 1;
            goto L7
        L10:
            if ((this.bitField0_ & 2) != 2) goto L13;
            r100.writeMessage(3, this.conclusionOfConditionalEffect_);
        L13:
            if ((this.bitField0_ & 4) != 4) goto L15;
            r100.writeEnum(4, this.kind_.getNumber());
        L15:
            r100.writeRawBytes(this.unknownFields);
        }

        private Effect(boolean r100) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        private Effect(CodedInputStream r110, ExtensionRegistryLite r111) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r100 = ByteString.newOutput();
            CodedOutputStream r101 = CodedOutputStream.newInstance(r100, 1);
            boolean r102 = false;
            int r103 = 0;
        L4:
            if (r102 == true) goto L59;
            int r104 = r110.readTag();     // Catch: Throwable -> L40 IOException -> L42 InvalidProtocolBufferException -> L45
            if (r104 == 0) goto L39;
            if (r104 != 8) goto L10;
            int r105 = r110.readEnum();     // Catch: Throwable -> L40 IOException -> L42 InvalidProtocolBufferException -> L45
            EffectType r106 = EffectType.valueOf(r105);     // Catch: Throwable -> L40 IOException -> L42 InvalidProtocolBufferException -> L45
            if (r106 == null) goto L36;
            this.bitField0_ |= 1;     // Catch: Throwable -> L40 IOException -> L42 InvalidProtocolBufferException -> L45
            this.effectType_ = r106;     // Catch: Throwable -> L40 IOException -> L42 InvalidProtocolBufferException -> L45
            goto L4
        L36:
            r101.writeRawVarint32(r104);     // Catch: Throwable -> L40 IOException -> L42 InvalidProtocolBufferException -> L45
            r101.writeRawVarint32(r105);     // Catch: Throwable -> L40 IOException -> L42 InvalidProtocolBufferException -> L45
            goto L4
        L10:
            if (r104 != 18) goto L12;
            if ((r103 & 2) == 2) goto L33;
            this.effectConstructorArgument_ = new ArrayList();     // Catch: Throwable -> L40 IOException -> L42 InvalidProtocolBufferException -> L45
            r103 = r103 | 2;     // Catch: Throwable -> L40 IOException -> L42 InvalidProtocolBufferException -> L45
        L33:
            this.effectConstructorArgument_.add((Expression) r110.readMessage(Expression.PARSER, r111));     // Catch: Throwable -> L40 IOException -> L42 InvalidProtocolBufferException -> L45
            goto L4
        L12:
            if (r104 != 26) goto L14;
            if ((this.bitField0_ & 2) != 2) goto L25;
            Expression.Builder r107 = this.conclusionOfConditionalEffect_.toBuilder();     // Catch: Throwable -> L40 IOException -> L42 InvalidProtocolBufferException -> L45
        L26:
            Expression r108 = (Expression) r110.readMessage(Expression.PARSER, r111);     // Catch: Throwable -> L40 IOException -> L42 InvalidProtocolBufferException -> L45
            this.conclusionOfConditionalEffect_ = r108;     // Catch: Throwable -> L40 IOException -> L42 InvalidProtocolBufferException -> L45
            if (r107 == null) goto L29;
            r107.mergeFrom(r108);     // Catch: Throwable -> L40 IOException -> L42 InvalidProtocolBufferException -> L45
            this.conclusionOfConditionalEffect_ = r107.buildPartial();     // Catch: Throwable -> L40 IOException -> L42 InvalidProtocolBufferException -> L45
        L29:
            this.bitField0_ |= 2;     // Catch: Throwable -> L40 IOException -> L42 InvalidProtocolBufferException -> L45
            goto L4
        L25:
            r107 = null;
            goto L26
        L14:
            if (r104 != 32) goto L16;
            int r109 = r110.readEnum();     // Catch: Throwable -> L40 IOException -> L42 InvalidProtocolBufferException -> L45
            InvocationKind r112 = InvocationKind.valueOf(r109);     // Catch: Throwable -> L40 IOException -> L42 InvalidProtocolBufferException -> L45
            if (r112 == null) goto L20;
            this.bitField0_ |= 4;     // Catch: Throwable -> L40 IOException -> L42 InvalidProtocolBufferException -> L45
            this.kind_ = r112;     // Catch: Throwable -> L40 IOException -> L42 InvalidProtocolBufferException -> L45
            goto L4
        L20:
            r101.writeRawVarint32(r104);     // Catch: Throwable -> L40 IOException -> L42 InvalidProtocolBufferException -> L45
            r101.writeRawVarint32(r109);     // Catch: Throwable -> L40 IOException -> L42 InvalidProtocolBufferException -> L45
            goto L4
        L16:
            if (parseUnknownField(r110, r101, r111, r104) == true) goto L4;
        L39:
            r102 = true;
            goto L4
        L40:
            th = move-exception;
            if ((r103 & 2) != 2) goto L74;
            this.effectConstructorArgument_ = Collections.unmodifiableList(this.effectConstructorArgument_);
        L74:
            r101.flush();     // Catch: IOException -> L69 Throwable -> L53
        L53:
            th = move-exception;
            this.unknownFields = r100.toByteString();
            throw th;
        L52:
            this.unknownFields = r100.toByteString();
            makeExtensionsImmutable();
            throw th;
        L45:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L40
        L42:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L40
        L59:
            if ((r103 & 2) != 2) goto L72;
            this.effectConstructorArgument_ = Collections.unmodifiableList(this.effectConstructorArgument_);
        L72:
            r101.flush();     // Catch: IOException -> L68 Throwable -> L63
        L63:
            th = move-exception;
            this.unknownFields = r100.toByteString();
            throw th;
        L62:
            this.unknownFields = r100.toByteString();
            makeExtensionsImmutable();
        }

        public static /* synthetic */ EffectType access$24202(Effect r100, EffectType r101) {
            r100.effectType_ = r101;
            return r101;
        }

        public static /* synthetic */ List access$24302(Effect r100, List r101) {
            r100.effectConstructorArgument_ = r101;
            return r101;
        }

        public static /* synthetic */ Expression access$24402(Effect r100, Expression r101) {
            r100.conclusionOfConditionalEffect_ = r101;
            return r101;
        }

        public static /* synthetic */ InvocationKind access$24502(Effect r100, InvocationKind r101) {
            r100.kind_ = r101;
            return r101;
        }

        public static /* synthetic */ int access$24602(Effect r100, int r101) {
            r100.bitField0_ = r101;
            return r101;
        }

        public /* synthetic */ Effect(GeneratedMessageLite.Builder r100, AnonymousClass1 r101) {
            this(r100);
        }

        public /* synthetic */ Effect(CodedInputStream r100, ExtensionRegistryLite r101, AnonymousClass1 r102) throws InvalidProtocolBufferException {
            this(r100, r101);
        }
    }

    public interface EffectOrBuilder extends MessageLiteOrBuilder {
    }

    /* JADX INFO: loaded from: classes5.dex */
    public static final class EnumEntry extends GeneratedMessageLite.ExtendableMessage<EnumEntry> implements EnumEntryOrBuilder {
        public static Parser<EnumEntry> PARSER;
        private static final EnumEntry defaultInstance = null;
        private int bitField0_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private final ByteString unknownFields;

        /* JADX INFO: loaded from: classes42.dex */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<EnumEntry, Builder> implements EnumEntryOrBuilder {
            private int bitField0_;
            private int name_;

            private void maybeForceBuilderInitialization() {
            }

            private static Builder create() {
                return new Builder();
            }

            public EnumEntry buildPartial() {
                EnumEntry r100 = new EnumEntry(this, null);
                int r101 = 1;
                if ((this.bitField0_ & 1) == 1) goto L6;
                r101 = 0;
            L6:
                EnumEntry.access$20602(r100, this.name_);
                EnumEntry.access$20702(r100, r101);
                return r100;
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            public static /* synthetic */ Builder access$20400() {
                return create();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public EnumEntry build() {
                EnumEntry r100 = buildPartial();
                if (r100.isInitialized() == false) goto L6;
                return r100;
            L6:
                throw AbstractMessageLite.Builder.newUninitializedMessageException(r100);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public EnumEntry getDefaultInstanceForType() {
                return EnumEntry.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                if (extensionsAreInitialized() == true) goto L6;
                return false;
            L6:
                return true;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo10730clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.ExtendableBuilder clone() {
                return clone();
            }

            public Builder mergeFrom(EnumEntry r100) {
                if (r100 != EnumEntry.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r100.hasName() == false) goto L8;
                setName(r100.getName());
            L8:
                mergeExtensionFields(r100);
                setUnknownFields(getUnknownFields().concat(EnumEntry.access$20800(r100)));
                return this;
            }

            public Builder setName(int r100) {
                this.bitField0_ |= 1;
                this.name_ = r100;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r100) {
                return mergeFrom((EnumEntry) r100);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
                EnumEntry r102 = null;
                EnumEntry r103 = EnumEntry.PARSER.parsePartialFrom(r100, r101);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r103 == null) goto L6;
                mergeFrom(r103);
            L6:
                return this;
            L9:
                e = move-exception;
                EnumEntry r104 = (EnumEntry) e.getUnfinishedMessage();     // Catch: Throwable -> L7
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
        }

        static {
            PARSER = new AnonymousClass1();
            EnumEntry r100 = new EnumEntry(true);
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
            if ((this.bitField0_ & 1) != 1) goto L8;
            r101 = 0 + CodedOutputStream.computeInt32Size(1, this.name_);
        L8:
            int r102 = (r101 + extensionsSerializedSize()) + this.unknownFields.size();
            this.memoizedSerializedSize = r102;
            return r102;
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
            if (r100 != 1) goto L6;
            return true;
        L6:
            if (r100 != 0) goto L9;
            return false;
        L9:
            if (extensionsAreInitialized() == true) goto L12;
            this.memoizedIsInitialized = 0;
            return false;
        L12:
            this.memoizedIsInitialized = 1;
            return true;
        }

        public static Builder newBuilder() {
            return Builder.access$20400();
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

        public static EnumEntry getDefaultInstance() {
            return defaultInstance;
        }

        public int getName() {
            return this.name_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<EnumEntry> getParserForType() {
            return PARSER;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public EnumEntry getDefaultInstanceForType() {
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

        private EnumEntry(GeneratedMessageLite.ExtendableBuilder<EnumEntry, ?> r100) {
            super(r100);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r100.getUnknownFields();
        }

        public static /* synthetic */ ByteString access$20800(EnumEntry r100) {
            return r100.unknownFields;
        }

        public static Builder newBuilder(EnumEntry r100) {
            return newBuilder().mergeFrom(r100);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r100) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter r101 = newExtensionWriter();
            if ((this.bitField0_ & 1) != 1) goto L5;
            r100.writeInt32(1, this.name_);
        L5:
            r101.writeUntil(200, r100);
            r100.writeRawBytes(this.unknownFields);
        }

        private EnumEntry(boolean r100) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        private EnumEntry(CodedInputStream r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r102 = ByteString.newOutput();
            CodedOutputStream r103 = CodedOutputStream.newInstance(r102, 1);
            boolean r104 = false;
        L3:
            if (r104 == true) goto L40;
            int r105 = r100.readTag();     // Catch: Throwable -> L14 IOException -> L16 InvalidProtocolBufferException -> L19
            if (r105 == 0) goto L13;
            if (r105 != 8) goto L9;
            this.bitField0_ |= 1;     // Catch: Throwable -> L14 IOException -> L16 InvalidProtocolBufferException -> L19
            this.name_ = r100.readInt32();     // Catch: Throwable -> L14 IOException -> L16 InvalidProtocolBufferException -> L19
            goto L3
        L9:
            if (parseUnknownField(r100, r103, r101, r105) == true) goto L3;
        L13:
            r104 = true;
            goto L3
        L14:
            th = move-exception;
            r103.flush();     // Catch: IOException -> L36 Throwable -> L24
        L24:
            th = move-exception;
            this.unknownFields = r102.toByteString();
            throw th;
        L23:
            this.unknownFields = r102.toByteString();
            makeExtensionsImmutable();
            throw th;
        L19:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L14
        L16:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L14
        L40:
            r103.flush();     // Catch: IOException -> L37 Throwable -> L31
        L31:
            th = move-exception;
            this.unknownFields = r102.toByteString();
            throw th;
        L30:
            this.unknownFields = r102.toByteString();
            makeExtensionsImmutable();
        }

        public static /* synthetic */ int access$20602(EnumEntry r100, int r101) {
            r100.name_ = r101;
            return r101;
        }

        public static /* synthetic */ int access$20702(EnumEntry r100, int r101) {
            r100.bitField0_ = r101;
            return r101;
        }

        public /* synthetic */ EnumEntry(GeneratedMessageLite.ExtendableBuilder r100, AnonymousClass1 r101) {
            this(r100);
        }

        public /* synthetic */ EnumEntry(CodedInputStream r100, ExtensionRegistryLite r101, AnonymousClass1 r102) throws InvalidProtocolBufferException {
            this(r100, r101);
        }
    }

    /* JADX INFO: loaded from: classes5.dex */
    public interface EnumEntryOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder {
    }

    public static final class Expression extends GeneratedMessageLite implements ExpressionOrBuilder {
        public static Parser<Expression> PARSER;
        private static final Expression defaultInstance = null;
        private List<Expression> andArgument_;
        private int bitField0_;
        private ConstantValue constantValue_;
        private int flags_;
        private int isInstanceTypeId_;
        private Type isInstanceType_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<Expression> orArgument_;
        private final ByteString unknownFields;
        private int valueParameterReference_;

        public static final class Builder extends GeneratedMessageLite.Builder<Expression, Builder> implements ExpressionOrBuilder {
            private List<Expression> andArgument_;
            private int bitField0_;
            private ConstantValue constantValue_;
            private int flags_;
            private int isInstanceTypeId_;
            private Type isInstanceType_;
            private List<Expression> orArgument_;
            private int valueParameterReference_;

            private void maybeForceBuilderInitialization() {
            }

            private static Builder create() {
                return new Builder();
            }

            private void ensureAndArgumentIsMutable() {
                if ((this.bitField0_ & 32) == 32) goto L6;
                this.andArgument_ = new ArrayList(this.andArgument_);
                this.bitField0_ |= 32;
                return;
            }

            private void ensureOrArgumentIsMutable() {
                if ((this.bitField0_ & 64) == 64) goto L6;
                this.orArgument_ = new ArrayList(this.orArgument_);
                this.bitField0_ |= 64;
                return;
            }

            public Expression buildPartial() {
                Expression r100 = new Expression(this, null);
                int r101 = this.bitField0_;
                int r102 = 1;
                if ((r101 & 1) == 1) goto L6;
                r102 = 0;
            L6:
                Expression.access$25102(r100, this.flags_);
                if ((r101 & 2) != 2) goto L9;
                r102 = r102 | 2;
            L9:
                Expression.access$25202(r100, this.valueParameterReference_);
                if ((r101 & 4) != 4) goto L12;
                r102 = r102 | 4;
            L12:
                Expression.access$25302(r100, this.constantValue_);
                if ((r101 & 8) != 8) goto L15;
                r102 = r102 | 8;
            L15:
                Expression.access$25402(r100, this.isInstanceType_);
                if ((r101 & 16) != 16) goto L18;
                r102 = r102 | 16;
            L18:
                Expression.access$25502(r100, this.isInstanceTypeId_);
                if ((this.bitField0_ & 32) != 32) goto L21;
                this.andArgument_ = Collections.unmodifiableList(this.andArgument_);
                this.bitField0_ &= -33;
            L21:
                Expression.access$25602(r100, this.andArgument_);
                if ((this.bitField0_ & 64) != 64) goto L24;
                this.orArgument_ = Collections.unmodifiableList(this.orArgument_);
                this.bitField0_ &= -65;
            L24:
                Expression.access$25702(r100, this.orArgument_);
                Expression.access$25802(r100, r102);
                return r100;
            }

            public int getAndArgumentCount() {
                return this.andArgument_.size();
            }

            public int getOrArgumentCount() {
                return this.orArgument_.size();
            }

            public boolean hasIsInstanceType() {
                if ((this.bitField0_ & 8) != 8) goto L5;
                return true;
            L5:
                return false;
            }

            private Builder() {
                this.constantValue_ = ConstantValue.TRUE;
                this.isInstanceType_ = Type.getDefaultInstance();
                this.andArgument_ = Collections.emptyList();
                this.orArgument_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            public static /* synthetic */ Builder access$24900() {
                return create();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Expression build() {
                Expression r100 = buildPartial();
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
            public Expression getDefaultInstanceForType() {
                return Expression.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                if (hasIsInstanceType() == true) goto L5;
            L7:
                int r100 = 0;
            L9:
                if (r100 >= getAndArgumentCount()) goto L14;
                if (getAndArgument(r100).isInitialized() == false) goto L12;
                r100 = r100 + 1;
                goto L9
            L12:
                return false;
            L14:
                int r101 = 0;
            L16:
                if (r101 >= getOrArgumentCount()) goto L21;
                if (getOrArgument(r101).isInitialized() == false) goto L19;
                r101 = r101 + 1;
                goto L16
            L19:
                return false;
            L21:
                return true;
            L5:
                if (getIsInstanceType().isInitialized() == true) goto L7;
                return false;
            }

            public Type getIsInstanceType() {
                return this.isInstanceType_;
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

            public Expression getAndArgument(int r100) {
                return (Expression) ListProtector.get(this.andArgument_, r100);
            }

            public Expression getOrArgument(int r100) {
                return (Expression) ListProtector.get(this.orArgument_, r100);
            }

            public Builder mergeFrom(Expression r100) {
                if (r100 != Expression.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r100.hasFlags() == false) goto L9;
                setFlags(r100.getFlags());
            L9:
                if (r100.hasValueParameterReference() == false) goto L12;
                setValueParameterReference(r100.getValueParameterReference());
            L12:
                if (r100.hasConstantValue() == false) goto L15;
                setConstantValue(r100.getConstantValue());
            L15:
                if (r100.hasIsInstanceType() == false) goto L18;
                mergeIsInstanceType(r100.getIsInstanceType());
            L18:
                if (r100.hasIsInstanceTypeId() == false) goto L21;
                setIsInstanceTypeId(r100.getIsInstanceTypeId());
            L21:
                if (Expression.access$25600(r100).isEmpty() == true) goto L27;
                if (this.andArgument_.isEmpty() == false) goto L25;
                this.andArgument_ = Expression.access$25600(r100);
                this.bitField0_ &= -33;
                goto L27
            L25:
                ensureAndArgumentIsMutable();
                this.andArgument_.addAll(Expression.access$25600(r100));
            L27:
                if (Expression.access$25700(r100).isEmpty() == false) goto L29;
            L32:
                setUnknownFields(getUnknownFields().concat(Expression.access$25900(r100)));
                return this;
            L29:
                if (this.orArgument_.isEmpty() == false) goto L31;
                this.orArgument_ = Expression.access$25700(r100);
                this.bitField0_ &= -65;
                goto L32
            L31:
                ensureOrArgumentIsMutable();
                this.orArgument_.addAll(Expression.access$25700(r100));
                goto L32
            }

            public Builder mergeIsInstanceType(Type r100) {
                if ((this.bitField0_ & 8) == 8) goto L5;
            L7:
                this.isInstanceType_ = r100;
            L8:
                this.bitField0_ |= 8;
                return this;
            L5:
                if (this.isInstanceType_ == Type.getDefaultInstance()) goto L7;
                this.isInstanceType_ = Type.newBuilder(this.isInstanceType_).mergeFrom(r100).buildPartial();
                goto L8
            }

            public Builder setConstantValue(ConstantValue r100) {
                if (r100 == null) goto L6;
                this.bitField0_ |= 4;
                this.constantValue_ = r100;
                return this;
            L6:
                throw null;
            }

            public Builder setFlags(int r100) {
                this.bitField0_ |= 1;
                this.flags_ = r100;
                return this;
            }

            public Builder setIsInstanceTypeId(int r100) {
                this.bitField0_ |= 16;
                this.isInstanceTypeId_ = r100;
                return this;
            }

            public Builder setValueParameterReference(int r100) {
                this.bitField0_ |= 2;
                this.valueParameterReference_ = r100;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r100) {
                return mergeFrom((Expression) r100);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
                Expression r102 = null;
                Expression r103 = Expression.PARSER.parsePartialFrom(r100, r101);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r103 == null) goto L6;
                mergeFrom(r103);
            L6:
                return this;
            L9:
                e = move-exception;
                Expression r104 = (Expression) e.getUnfinishedMessage();     // Catch: Throwable -> L7
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

        public static final enum ConstantValue extends Enum<ConstantValue> implements Internal.EnumLite {
            private static final /* synthetic */ ConstantValue[] $VALUES = null;
            public static final ConstantValue FALSE = null;
            public static final ConstantValue NULL = null;
            public static final ConstantValue TRUE = null;
            private static Internal.EnumLiteMap<ConstantValue> internalValueMap;
            private final int value;

            static {
                ConstantValue r100 = new ConstantValue("TRUE", 0, 0, 0);
                TRUE = r100;
                ConstantValue r101 = new ConstantValue("FALSE", 1, 1, 1);
                FALSE = r101;
                ConstantValue r102 = new ConstantValue("NULL", 2, 2, 2);
                NULL = r102;
                $VALUES = new ConstantValue[]{r100, r101, r102};
                internalValueMap = new AnonymousClass1();
            }

            public static ConstantValue[] values() {
                return (ConstantValue[]) $VALUES.clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            public static ConstantValue valueOf(int r100) {
                if (r100 == 0) goto L14;
                if (r100 == 1) goto L12;
                if (r100 == 2) goto L10;
                return null;
            L10:
                return NULL;
            L12:
                return FALSE;
            L14:
                return TRUE;
            }

            public static ConstantValue valueOf(String r100) {
                return (ConstantValue) a.a(ConstantValue.class, r100);
            }

            private ConstantValue(String r100, int r101, int r102, int r103) {
                super(r100, r101);
                this.value = r103;
            }
        }

        private void initFields() {
            this.flags_ = 0;
            this.valueParameterReference_ = 0;
            this.constantValue_ = ConstantValue.TRUE;
            this.isInstanceType_ = Type.getDefaultInstance();
            this.isInstanceTypeId_ = 0;
            this.andArgument_ = Collections.emptyList();
            this.orArgument_ = Collections.emptyList();
        }

        static {
            PARSER = new AnonymousClass1();
            Expression r100 = new Expression(true);
            defaultInstance = r100;
            r100.initFields();
        }

        public int getAndArgumentCount() {
            return this.andArgument_.size();
        }

        public int getOrArgumentCount() {
            return this.orArgument_.size();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int r100 = this.memoizedSerializedSize;
            if (r100 == (-1)) goto L5;
            return r100;
        L5:
            int r101 = 0;
            if ((this.bitField0_ & 1) != 1) goto L8;
            int r102 = CodedOutputStream.computeInt32Size(1, this.flags_) + 0;
        L10:
            if ((this.bitField0_ & 2) != 2) goto L13;
            r102 = r102 + CodedOutputStream.computeInt32Size(2, this.valueParameterReference_);
        L13:
            if ((this.bitField0_ & 4) != 4) goto L16;
            r102 = r102 + CodedOutputStream.computeEnumSize(3, this.constantValue_.getNumber());
        L16:
            if ((this.bitField0_ & 8) != 8) goto L19;
            r102 = r102 + CodedOutputStream.computeMessageSize(4, this.isInstanceType_);
        L19:
            if ((this.bitField0_ & 16) != 16) goto L21;
            r102 = r102 + CodedOutputStream.computeInt32Size(5, this.isInstanceTypeId_);
        L21:
            int r103 = 0;
        L23:
            if (r103 >= this.andArgument_.size()) goto L26;
            r102 = r102 + CodedOutputStream.computeMessageSize(6, (MessageLite) ListProtector.get(this.andArgument_, r103));
            r103 = r103 + 1;
        L26:
            if (r101 >= this.orArgument_.size()) goto L28;
            r102 = r102 + CodedOutputStream.computeMessageSize(7, (MessageLite) ListProtector.get(this.orArgument_, r101));
            r101 = r101 + 1;
            goto L26
        L28:
            int r104 = r102 + this.unknownFields.size();
            this.memoizedSerializedSize = r104;
            return r104;
        L8:
            r102 = 0;
            goto L10
        }

        public boolean hasConstantValue() {
            if ((this.bitField0_ & 4) != 4) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasFlags() {
            if ((this.bitField0_ & 1) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        public boolean hasIsInstanceType() {
            if ((this.bitField0_ & 8) != 8) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasIsInstanceTypeId() {
            if ((this.bitField0_ & 16) != 16) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasValueParameterReference() {
            if ((this.bitField0_ & 2) != 2) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte r100 = this.memoizedIsInitialized;
            if (r100 != 1) goto L6;
            return true;
        L6:
            if (r100 != 0) goto L9;
            return false;
        L9:
            if (hasIsInstanceType() == true) goto L11;
        L14:
            int r101 = 0;
        L16:
            if (r101 >= getAndArgumentCount()) goto L22;
            if (getAndArgument(r101).isInitialized() == false) goto L19;
            r101 = r101 + 1;
            goto L16
        L19:
            this.memoizedIsInitialized = 0;
            return false;
        L22:
            int r102 = 0;
        L24:
            if (r102 >= getOrArgumentCount()) goto L30;
            if (getOrArgument(r102).isInitialized() == false) goto L27;
            r102 = r102 + 1;
            goto L24
        L27:
            this.memoizedIsInitialized = 0;
            return false;
        L30:
            this.memoizedIsInitialized = 1;
            return true;
        L11:
            if (getIsInstanceType().isInitialized() == true) goto L14;
            this.memoizedIsInitialized = 0;
            return false;
        }

        public static Builder newBuilder() {
            return Builder.access$24900();
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

        public static Expression getDefaultInstance() {
            return defaultInstance;
        }

        public ConstantValue getConstantValue() {
            return this.constantValue_;
        }

        public int getFlags() {
            return this.flags_;
        }

        public Type getIsInstanceType() {
            return this.isInstanceType_;
        }

        public int getIsInstanceTypeId() {
            return this.isInstanceTypeId_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<Expression> getParserForType() {
            return PARSER;
        }

        public int getValueParameterReference() {
            return this.valueParameterReference_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public Expression getDefaultInstanceForType() {
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

        private Expression(GeneratedMessageLite.Builder r100) {
            super(r100);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r100.getUnknownFields();
        }

        public static /* synthetic */ List access$25600(Expression r100) {
            return r100.andArgument_;
        }

        public static /* synthetic */ List access$25700(Expression r100) {
            return r100.orArgument_;
        }

        public static /* synthetic */ ByteString access$25900(Expression r100) {
            return r100.unknownFields;
        }

        public static Builder newBuilder(Expression r100) {
            return newBuilder().mergeFrom(r100);
        }

        public Expression getAndArgument(int r100) {
            return (Expression) ListProtector.get(this.andArgument_, r100);
        }

        public Expression getOrArgument(int r100) {
            return (Expression) ListProtector.get(this.orArgument_, r100);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r100) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) != 1) goto L6;
            r100.writeInt32(1, this.flags_);
        L6:
            if ((this.bitField0_ & 2) != 2) goto L9;
            r100.writeInt32(2, this.valueParameterReference_);
        L9:
            if ((this.bitField0_ & 4) != 4) goto L12;
            r100.writeEnum(3, this.constantValue_.getNumber());
        L12:
            if ((this.bitField0_ & 8) != 8) goto L15;
            r100.writeMessage(4, this.isInstanceType_);
        L15:
            if ((this.bitField0_ & 16) != 16) goto L17;
            r100.writeInt32(5, this.isInstanceTypeId_);
        L17:
            int r101 = 0;
            int r102 = 0;
        L19:
            if (r102 >= this.andArgument_.size()) goto L22;
            r100.writeMessage(6, (MessageLite) ListProtector.get(this.andArgument_, r102));
            r102 = r102 + 1;
        L22:
            if (r101 >= this.orArgument_.size()) goto L24;
            r100.writeMessage(7, (MessageLite) ListProtector.get(this.orArgument_, r101));
            r101 = r101 + 1;
            goto L22
        L24:
            r100.writeRawBytes(this.unknownFields);
        }

        private Expression(boolean r100) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        private Expression(CodedInputStream r110, ExtensionRegistryLite r111) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r100 = ByteString.newOutput();
            CodedOutputStream r101 = CodedOutputStream.newInstance(r100, 1);
            boolean r102 = false;
            int r103 = 0;
        L4:
            if (r102 == true) goto L71;
            int r104 = r110.readTag();     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            if (r104 == 0) goto L48;
            if (r104 != 8) goto L10;
            this.bitField0_ |= 1;     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            this.flags_ = r110.readInt32();     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            goto L4
        L10:
            if (r104 != 16) goto L12;
            this.bitField0_ |= 2;     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            this.valueParameterReference_ = r110.readInt32();     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            goto L4
        L12:
            if (r104 != 24) goto L14;
            int r105 = r110.readEnum();     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            ConstantValue r106 = ConstantValue.valueOf(r105);     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            if (r106 == null) goto L43;
            this.bitField0_ |= 4;     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            this.constantValue_ = r106;     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            goto L4
        L43:
            r101.writeRawVarint32(r104);     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            r101.writeRawVarint32(r105);     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            goto L4
        L14:
            if (r104 != 34) goto L16;
            if ((this.bitField0_ & 8) != 8) goto L36;
            Type.Builder r107 = this.isInstanceType_.toBuilder();     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
        L37:
            Type r108 = (Type) r110.readMessage(Type.PARSER, r111);     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            this.isInstanceType_ = r108;     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            if (r107 == null) goto L40;
            r107.mergeFrom(r108);     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            this.isInstanceType_ = r107.buildPartial();     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
        L40:
            this.bitField0_ |= 8;     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            goto L4
        L36:
            r107 = null;
            goto L37
        L16:
            if (r104 != 40) goto L18;
            this.bitField0_ |= 16;     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            this.isInstanceTypeId_ = r110.readInt32();     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            goto L4
        L18:
            if (r104 != 50) goto L20;
            if ((r103 & 32) == 32) goto L31;
            this.andArgument_ = new ArrayList();     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            r103 = r103 | 32;     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
        L31:
            this.andArgument_.add((Expression) r110.readMessage(PARSER, r111));     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            goto L4
        L20:
            if (r104 != 58) goto L22;
            if ((r103 & 64) == 64) goto L27;
            this.orArgument_ = new ArrayList();     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            r103 = r103 | 64;     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
        L27:
            this.orArgument_.add((Expression) r110.readMessage(PARSER, r111));     // Catch: Throwable -> L49 IOException -> L51 InvalidProtocolBufferException -> L54
            goto L4
        L22:
            if (parseUnknownField(r110, r101, r111, r104) == true) goto L4;
        L48:
            r102 = true;
            goto L4
        L49:
            th = move-exception;
            if ((r103 & 32) != 32) goto L61;
            this.andArgument_ = Collections.unmodifiableList(this.andArgument_);
        L61:
            if ((r103 & 64) != 64) goto L86;
            this.orArgument_ = Collections.unmodifiableList(this.orArgument_);
        L86:
            r101.flush();     // Catch: IOException -> L84 Throwable -> L65
        L65:
            th = move-exception;
            this.unknownFields = r100.toByteString();
            throw th;
        L64:
            this.unknownFields = r100.toByteString();
            makeExtensionsImmutable();
            throw th;
        L54:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L49
        L51:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L49
        L71:
            if ((r103 & 32) != 32) goto L74;
            this.andArgument_ = Collections.unmodifiableList(this.andArgument_);
        L74:
            if ((r103 & 64) != 64) goto L89;
            this.orArgument_ = Collections.unmodifiableList(this.orArgument_);
        L89:
            r101.flush();     // Catch: IOException -> L83 Throwable -> L78
        L78:
            th = move-exception;
            this.unknownFields = r100.toByteString();
            throw th;
        L77:
            this.unknownFields = r100.toByteString();
            makeExtensionsImmutable();
        }

        public static /* synthetic */ int access$25102(Expression r100, int r101) {
            r100.flags_ = r101;
            return r101;
        }

        public static /* synthetic */ int access$25202(Expression r100, int r101) {
            r100.valueParameterReference_ = r101;
            return r101;
        }

        public static /* synthetic */ ConstantValue access$25302(Expression r100, ConstantValue r101) {
            r100.constantValue_ = r101;
            return r101;
        }

        public static /* synthetic */ Type access$25402(Expression r100, Type r101) {
            r100.isInstanceType_ = r101;
            return r101;
        }

        public static /* synthetic */ int access$25502(Expression r100, int r101) {
            r100.isInstanceTypeId_ = r101;
            return r101;
        }

        public static /* synthetic */ List access$25602(Expression r100, List r101) {
            r100.andArgument_ = r101;
            return r101;
        }

        public static /* synthetic */ List access$25702(Expression r100, List r101) {
            r100.orArgument_ = r101;
            return r101;
        }

        public static /* synthetic */ int access$25802(Expression r100, int r101) {
            r100.bitField0_ = r101;
            return r101;
        }

        public /* synthetic */ Expression(GeneratedMessageLite.Builder r100, AnonymousClass1 r101) {
            this(r100);
        }

        public /* synthetic */ Expression(CodedInputStream r100, ExtensionRegistryLite r101, AnonymousClass1 r102) throws InvalidProtocolBufferException {
            this(r100, r101);
        }
    }

    public interface ExpressionOrBuilder extends MessageLiteOrBuilder {
    }

    /* JADX INFO: loaded from: classes5.dex */
    public static final class Function extends GeneratedMessageLite.ExtendableMessage<Function> implements FunctionOrBuilder {
        public static Parser<Function> PARSER;
        private static final Function defaultInstance = null;
        private int bitField0_;
        private int contextReceiverTypeIdMemoizedSerializedSize;
        private List<Integer> contextReceiverTypeId_;
        private List<Type> contextReceiverType_;
        private Contract contract_;
        private int flags_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private int oldFlags_;
        private int receiverTypeId_;
        private Type receiverType_;
        private int returnTypeId_;
        private Type returnType_;
        private List<TypeParameter> typeParameter_;
        private TypeTable typeTable_;
        private final ByteString unknownFields;
        private List<ValueParameter> valueParameter_;
        private List<Integer> versionRequirement_;

        /* JADX INFO: loaded from: classes42.dex */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<Function, Builder> implements FunctionOrBuilder {
            private int bitField0_;
            private List<Integer> contextReceiverTypeId_;
            private List<Type> contextReceiverType_;
            private Contract contract_;
            private int flags_;
            private int name_;
            private int oldFlags_;
            private int receiverTypeId_;
            private Type receiverType_;
            private int returnTypeId_;
            private Type returnType_;
            private List<TypeParameter> typeParameter_;
            private TypeTable typeTable_;
            private List<ValueParameter> valueParameter_;
            private List<Integer> versionRequirement_;

            private void maybeForceBuilderInitialization() {
            }

            private static Builder create() {
                return new Builder();
            }

            private void ensureContextReceiverTypeIdIsMutable() {
                if ((this.bitField0_ & 512) == 512) goto L6;
                this.contextReceiverTypeId_ = new ArrayList(this.contextReceiverTypeId_);
                this.bitField0_ |= 512;
                return;
            }

            private void ensureContextReceiverTypeIsMutable() {
                if ((this.bitField0_ & 256) == 256) goto L6;
                this.contextReceiverType_ = new ArrayList(this.contextReceiverType_);
                this.bitField0_ |= 256;
                return;
            }

            private void ensureTypeParameterIsMutable() {
                if ((this.bitField0_ & 32) == 32) goto L6;
                this.typeParameter_ = new ArrayList(this.typeParameter_);
                this.bitField0_ |= 32;
                return;
            }

            private void ensureValueParameterIsMutable() {
                if ((this.bitField0_ & 1024) == 1024) goto L6;
                this.valueParameter_ = new ArrayList(this.valueParameter_);
                this.bitField0_ |= 1024;
                return;
            }

            private void ensureVersionRequirementIsMutable() {
                if ((this.bitField0_ & 4096) == 4096) goto L6;
                this.versionRequirement_ = new ArrayList(this.versionRequirement_);
                this.bitField0_ |= 4096;
                return;
            }

            public Function buildPartial() {
                Function r100 = new Function(this, null);
                int r101 = this.bitField0_;
                int r102 = 1;
                if ((r101 & 1) == 1) goto L6;
                r102 = 0;
            L6:
                Function.access$14302(r100, this.flags_);
                if ((r101 & 2) != 2) goto L9;
                r102 = r102 | 2;
            L9:
                Function.access$14402(r100, this.oldFlags_);
                if ((r101 & 4) != 4) goto L12;
                r102 = r102 | 4;
            L12:
                Function.access$14502(r100, this.name_);
                if ((r101 & 8) != 8) goto L15;
                r102 = r102 | 8;
            L15:
                Function.access$14602(r100, this.returnType_);
                if ((r101 & 16) != 16) goto L18;
                r102 = r102 | 16;
            L18:
                Function.access$14702(r100, this.returnTypeId_);
                if ((this.bitField0_ & 32) != 32) goto L21;
                this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                this.bitField0_ &= -33;
            L21:
                Function.access$14802(r100, this.typeParameter_);
                if ((r101 & 64) != 64) goto L24;
                r102 = r102 | 32;
            L24:
                Function.access$14902(r100, this.receiverType_);
                if ((r101 & 128) != 128) goto L27;
                r102 = r102 | 64;
            L27:
                Function.access$15002(r100, this.receiverTypeId_);
                if ((this.bitField0_ & 256) != 256) goto L30;
                this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
                this.bitField0_ &= -257;
            L30:
                Function.access$15102(r100, this.contextReceiverType_);
                if ((this.bitField0_ & 512) != 512) goto L33;
                this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
                this.bitField0_ &= NetError.ERR_TTNET_FT_INVALID_STREAM;
            L33:
                Function.access$15202(r100, this.contextReceiverTypeId_);
                if ((this.bitField0_ & 1024) != 1024) goto L36;
                this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
                this.bitField0_ &= -1025;
            L36:
                Function.access$15302(r100, this.valueParameter_);
                if ((r101 & 2048) != 2048) goto L39;
                r102 = r102 | 128;
            L39:
                Function.access$15402(r100, this.typeTable_);
                if ((this.bitField0_ & 4096) != 4096) goto L42;
                this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                this.bitField0_ &= -4097;
            L42:
                Function.access$15502(r100, this.versionRequirement_);
                if ((r101 & 8192) != 8192) goto L45;
                r102 = r102 | 256;
            L45:
                Function.access$15602(r100, this.contract_);
                Function.access$15702(r100, r102);
                return r100;
            }

            public int getContextReceiverTypeCount() {
                return this.contextReceiverType_.size();
            }

            public int getTypeParameterCount() {
                return this.typeParameter_.size();
            }

            public int getValueParameterCount() {
                return this.valueParameter_.size();
            }

            public boolean hasContract() {
                if ((this.bitField0_ & 8192) != 8192) goto L5;
                return true;
            L5:
                return false;
            }

            public boolean hasName() {
                if ((this.bitField0_ & 4) != 4) goto L5;
                return true;
            L5:
                return false;
            }

            public boolean hasReceiverType() {
                if ((this.bitField0_ & 64) != 64) goto L5;
                return true;
            L5:
                return false;
            }

            public boolean hasReturnType() {
                if ((this.bitField0_ & 8) != 8) goto L5;
                return true;
            L5:
                return false;
            }

            public boolean hasTypeTable() {
                if ((this.bitField0_ & 2048) != 2048) goto L5;
                return true;
            L5:
                return false;
            }

            private Builder() {
                this.flags_ = 6;
                this.oldFlags_ = 6;
                this.returnType_ = Type.getDefaultInstance();
                this.typeParameter_ = Collections.emptyList();
                this.receiverType_ = Type.getDefaultInstance();
                this.contextReceiverType_ = Collections.emptyList();
                this.contextReceiverTypeId_ = Collections.emptyList();
                this.valueParameter_ = Collections.emptyList();
                this.typeTable_ = TypeTable.getDefaultInstance();
                this.versionRequirement_ = Collections.emptyList();
                this.contract_ = Contract.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            public static /* synthetic */ Builder access$14100() {
                return create();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Function build() {
                Function r100 = buildPartial();
                if (r100.isInitialized() == false) goto L6;
                return r100;
            L6:
                throw AbstractMessageLite.Builder.newUninitializedMessageException(r100);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public Function getDefaultInstanceForType() {
                return Function.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                if (hasName() == true) goto L6;
                return false;
            L6:
                if (hasReturnType() == true) goto L8;
            L10:
                int r100 = 0;
            L12:
                if (r100 >= getTypeParameterCount()) goto L18;
                if (getTypeParameter(r100).isInitialized() == false) goto L15;
                r100 = r100 + 1;
                goto L12
            L15:
                return false;
            L18:
                if (hasReceiverType() == true) goto L20;
            L22:
                int r101 = 0;
            L24:
                if (r101 >= getContextReceiverTypeCount()) goto L29;
                if (getContextReceiverType(r101).isInitialized() == false) goto L27;
                r101 = r101 + 1;
                goto L24
            L27:
                return false;
            L29:
                int r102 = 0;
            L31:
                if (r102 >= getValueParameterCount()) goto L37;
                if (getValueParameter(r102).isInitialized() == false) goto L34;
                r102 = r102 + 1;
                goto L31
            L34:
                return false;
            L37:
                if (hasTypeTable() == false) goto L42;
                if (getTypeTable().isInitialized() == true) goto L42;
                return false;
            L42:
                if (hasContract() == false) goto L47;
                if (getContract().isInitialized() == true) goto L47;
                return false;
            L47:
                if (extensionsAreInitialized() == true) goto L49;
                return false;
            L49:
                return true;
            L20:
                if (getReceiverType().isInitialized() == true) goto L22;
                return false;
            L8:
                if (getReturnType().isInitialized() == true) goto L10;
                return false;
            }

            public Contract getContract() {
                return this.contract_;
            }

            public Type getReceiverType() {
                return this.receiverType_;
            }

            public Type getReturnType() {
                return this.returnType_;
            }

            public TypeTable getTypeTable() {
                return this.typeTable_;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo10730clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.ExtendableBuilder clone() {
                return clone();
            }

            public Type getContextReceiverType(int r100) {
                return (Type) ListProtector.get(this.contextReceiverType_, r100);
            }

            public TypeParameter getTypeParameter(int r100) {
                return (TypeParameter) ListProtector.get(this.typeParameter_, r100);
            }

            public ValueParameter getValueParameter(int r100) {
                return (ValueParameter) ListProtector.get(this.valueParameter_, r100);
            }

            public Builder mergeContract(Contract r100) {
                if ((this.bitField0_ & 8192) == 8192) goto L5;
            L7:
                this.contract_ = r100;
            L8:
                this.bitField0_ |= 8192;
                return this;
            L5:
                if (this.contract_ == Contract.getDefaultInstance()) goto L7;
                this.contract_ = Contract.newBuilder(this.contract_).mergeFrom(r100).buildPartial();
                goto L8
            }

            public Builder mergeFrom(Function r100) {
                if (r100 != Function.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r100.hasFlags() == false) goto L9;
                setFlags(r100.getFlags());
            L9:
                if (r100.hasOldFlags() == false) goto L12;
                setOldFlags(r100.getOldFlags());
            L12:
                if (r100.hasName() == false) goto L15;
                setName(r100.getName());
            L15:
                if (r100.hasReturnType() == false) goto L18;
                mergeReturnType(r100.getReturnType());
            L18:
                if (r100.hasReturnTypeId() == false) goto L21;
                setReturnTypeId(r100.getReturnTypeId());
            L21:
                if (Function.access$14800(r100).isEmpty() == true) goto L27;
                if (this.typeParameter_.isEmpty() == false) goto L25;
                this.typeParameter_ = Function.access$14800(r100);
                this.bitField0_ &= -33;
                goto L27
            L25:
                ensureTypeParameterIsMutable();
                this.typeParameter_.addAll(Function.access$14800(r100));
            L27:
                if (r100.hasReceiverType() == false) goto L30;
                mergeReceiverType(r100.getReceiverType());
            L30:
                if (r100.hasReceiverTypeId() == false) goto L33;
                setReceiverTypeId(r100.getReceiverTypeId());
            L33:
                if (Function.access$15100(r100).isEmpty() == true) goto L39;
                if (this.contextReceiverType_.isEmpty() == false) goto L37;
                this.contextReceiverType_ = Function.access$15100(r100);
                this.bitField0_ &= -257;
                goto L39
            L37:
                ensureContextReceiverTypeIsMutable();
                this.contextReceiverType_.addAll(Function.access$15100(r100));
            L39:
                if (Function.access$15200(r100).isEmpty() == true) goto L45;
                if (this.contextReceiverTypeId_.isEmpty() == false) goto L43;
                this.contextReceiverTypeId_ = Function.access$15200(r100);
                this.bitField0_ &= NetError.ERR_TTNET_FT_INVALID_STREAM;
                goto L45
            L43:
                ensureContextReceiverTypeIdIsMutable();
                this.contextReceiverTypeId_.addAll(Function.access$15200(r100));
            L45:
                if (Function.access$15300(r100).isEmpty() == true) goto L51;
                if (this.valueParameter_.isEmpty() == false) goto L49;
                this.valueParameter_ = Function.access$15300(r100);
                this.bitField0_ &= -1025;
                goto L51
            L49:
                ensureValueParameterIsMutable();
                this.valueParameter_.addAll(Function.access$15300(r100));
            L51:
                if (r100.hasTypeTable() == false) goto L54;
                mergeTypeTable(r100.getTypeTable());
            L54:
                if (Function.access$15500(r100).isEmpty() == true) goto L60;
                if (this.versionRequirement_.isEmpty() == false) goto L58;
                this.versionRequirement_ = Function.access$15500(r100);
                this.bitField0_ &= -4097;
                goto L60
            L58:
                ensureVersionRequirementIsMutable();
                this.versionRequirement_.addAll(Function.access$15500(r100));
            L60:
                if (r100.hasContract() == false) goto L62;
                mergeContract(r100.getContract());
            L62:
                mergeExtensionFields(r100);
                setUnknownFields(getUnknownFields().concat(Function.access$15800(r100)));
                return this;
            }

            public Builder mergeReceiverType(Type r100) {
                if ((this.bitField0_ & 64) == 64) goto L5;
            L7:
                this.receiverType_ = r100;
            L8:
                this.bitField0_ |= 64;
                return this;
            L5:
                if (this.receiverType_ == Type.getDefaultInstance()) goto L7;
                this.receiverType_ = Type.newBuilder(this.receiverType_).mergeFrom(r100).buildPartial();
                goto L8
            }

            public Builder mergeReturnType(Type r100) {
                if ((this.bitField0_ & 8) == 8) goto L5;
            L7:
                this.returnType_ = r100;
            L8:
                this.bitField0_ |= 8;
                return this;
            L5:
                if (this.returnType_ == Type.getDefaultInstance()) goto L7;
                this.returnType_ = Type.newBuilder(this.returnType_).mergeFrom(r100).buildPartial();
                goto L8
            }

            public Builder mergeTypeTable(TypeTable r100) {
                if ((this.bitField0_ & 2048) == 2048) goto L5;
            L7:
                this.typeTable_ = r100;
            L8:
                this.bitField0_ |= 2048;
                return this;
            L5:
                if (this.typeTable_ == TypeTable.getDefaultInstance()) goto L7;
                this.typeTable_ = TypeTable.newBuilder(this.typeTable_).mergeFrom(r100).buildPartial();
                goto L8
            }

            public Builder setFlags(int r100) {
                this.bitField0_ |= 1;
                this.flags_ = r100;
                return this;
            }

            public Builder setName(int r100) {
                this.bitField0_ |= 4;
                this.name_ = r100;
                return this;
            }

            public Builder setOldFlags(int r100) {
                this.bitField0_ |= 2;
                this.oldFlags_ = r100;
                return this;
            }

            public Builder setReceiverTypeId(int r100) {
                this.bitField0_ |= 128;
                this.receiverTypeId_ = r100;
                return this;
            }

            public Builder setReturnTypeId(int r100) {
                this.bitField0_ |= 16;
                this.returnTypeId_ = r100;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r100) {
                return mergeFrom((Function) r100);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
                Function r102 = null;
                Function r103 = Function.PARSER.parsePartialFrom(r100, r101);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r103 == null) goto L6;
                mergeFrom(r103);
            L6:
                return this;
            L9:
                e = move-exception;
                Function r104 = (Function) e.getUnfinishedMessage();     // Catch: Throwable -> L7
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
            this.flags_ = 6;
            this.oldFlags_ = 6;
            this.name_ = 0;
            this.returnType_ = Type.getDefaultInstance();
            this.returnTypeId_ = 0;
            this.typeParameter_ = Collections.emptyList();
            this.receiverType_ = Type.getDefaultInstance();
            this.receiverTypeId_ = 0;
            this.contextReceiverType_ = Collections.emptyList();
            this.contextReceiverTypeId_ = Collections.emptyList();
            this.valueParameter_ = Collections.emptyList();
            this.typeTable_ = TypeTable.getDefaultInstance();
            this.versionRequirement_ = Collections.emptyList();
            this.contract_ = Contract.getDefaultInstance();
        }

        static {
            PARSER = new AnonymousClass1();
            Function r100 = new Function(true);
            defaultInstance = r100;
            r100.initFields();
        }

        public int getContextReceiverTypeCount() {
            return this.contextReceiverType_.size();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int r100 = this.memoizedSerializedSize;
            if (r100 == (-1)) goto L5;
            return r100;
        L5:
            int r101 = 0;
            if ((this.bitField0_ & 2) != 2) goto L8;
            int r102 = CodedOutputStream.computeInt32Size(1, this.oldFlags_) + 0;
        L10:
            if ((this.bitField0_ & 4) != 4) goto L13;
            r102 = r102 + CodedOutputStream.computeInt32Size(2, this.name_);
        L13:
            if ((this.bitField0_ & 8) != 8) goto L15;
            r102 = r102 + CodedOutputStream.computeMessageSize(3, this.returnType_);
        L15:
            int r103 = 0;
        L17:
            if (r103 >= this.typeParameter_.size()) goto L20;
            r102 = r102 + CodedOutputStream.computeMessageSize(4, (MessageLite) ListProtector.get(this.typeParameter_, r103));
            r103 = r103 + 1;
            goto L17
        L20:
            if ((this.bitField0_ & 32) != 32) goto L22;
            r102 = r102 + CodedOutputStream.computeMessageSize(5, this.receiverType_);
        L22:
            int r104 = 0;
        L24:
            if (r104 >= this.valueParameter_.size()) goto L27;
            r102 = r102 + CodedOutputStream.computeMessageSize(6, (MessageLite) ListProtector.get(this.valueParameter_, r104));
            r104 = r104 + 1;
            goto L24
        L27:
            if ((this.bitField0_ & 16) != 16) goto L30;
            r102 = r102 + CodedOutputStream.computeInt32Size(7, this.returnTypeId_);
        L30:
            if ((this.bitField0_ & 64) != 64) goto L33;
            r102 = r102 + CodedOutputStream.computeInt32Size(8, this.receiverTypeId_);
        L33:
            if ((this.bitField0_ & 1) != 1) goto L35;
            r102 = r102 + CodedOutputStream.computeInt32Size(9, this.flags_);
        L35:
            int r105 = 0;
        L37:
            if (r105 >= this.contextReceiverType_.size()) goto L39;
            r102 = r102 + CodedOutputStream.computeMessageSize(10, (MessageLite) ListProtector.get(this.contextReceiverType_, r105));
            r105 = r105 + 1;
            goto L37
        L39:
            int r106 = 0;
            int r107 = 0;
        L41:
            if (r106 >= this.contextReceiverTypeId_.size()) goto L43;
            r107 = r107 + CodedOutputStream.computeInt32SizeNoTag(((Integer) ListProtector.get(this.contextReceiverTypeId_, r106)).intValue());
            r106 = r106 + 1;
            goto L41
        L43:
            int r108 = r102 + r107;
            if (getContextReceiverTypeIdList().isEmpty() == true) goto L46;
            r108 = (r108 + 1) + CodedOutputStream.computeInt32SizeNoTag(r107);
        L46:
            this.contextReceiverTypeIdMemoizedSerializedSize = r107;
            if ((this.bitField0_ & 128) != 128) goto L49;
            r108 = r108 + CodedOutputStream.computeMessageSize(30, this.typeTable_);
        L49:
            int r109 = 0;
        L51:
            if (r101 >= this.versionRequirement_.size()) goto L53;
            r109 = r109 + CodedOutputStream.computeInt32SizeNoTag(((Integer) ListProtector.get(this.versionRequirement_, r101)).intValue());
            r101 = r101 + 1;
            goto L51
        L53:
            int r110 = (r108 + r109) + (getVersionRequirementList().size() * 2);
            if ((this.bitField0_ & 256) != 256) goto L56;
            r110 = r110 + CodedOutputStream.computeMessageSize(32, this.contract_);
        L56:
            int r111 = (r110 + extensionsSerializedSize()) + this.unknownFields.size();
            this.memoizedSerializedSize = r111;
            return r111;
        L8:
            r102 = 0;
            goto L10
        }

        public int getTypeParameterCount() {
            return this.typeParameter_.size();
        }

        public int getValueParameterCount() {
            return this.valueParameter_.size();
        }

        public boolean hasContract() {
            if ((this.bitField0_ & 256) != 256) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasFlags() {
            if ((this.bitField0_ & 1) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        public boolean hasName() {
            if ((this.bitField0_ & 4) != 4) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasOldFlags() {
            if ((this.bitField0_ & 2) != 2) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasReceiverType() {
            if ((this.bitField0_ & 32) != 32) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasReceiverTypeId() {
            if ((this.bitField0_ & 64) != 64) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasReturnType() {
            if ((this.bitField0_ & 8) != 8) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasReturnTypeId() {
            if ((this.bitField0_ & 16) != 16) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasTypeTable() {
            if ((this.bitField0_ & 128) != 128) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte r100 = this.memoizedIsInitialized;
            if (r100 != 1) goto L6;
            return true;
        L6:
            if (r100 != 0) goto L9;
            return false;
        L9:
            if (hasName() == true) goto L13;
            this.memoizedIsInitialized = 0;
            return false;
        L13:
            if (hasReturnType() == true) goto L15;
        L18:
            int r101 = 0;
        L20:
            if (r101 >= getTypeParameterCount()) goto L27;
            if (getTypeParameter(r101).isInitialized() == false) goto L23;
            r101 = r101 + 1;
            goto L20
        L23:
            this.memoizedIsInitialized = 0;
            return false;
        L27:
            if (hasReceiverType() == true) goto L29;
        L32:
            int r102 = 0;
        L34:
            if (r102 >= getContextReceiverTypeCount()) goto L40;
            if (getContextReceiverType(r102).isInitialized() == false) goto L37;
            r102 = r102 + 1;
            goto L34
        L37:
            this.memoizedIsInitialized = 0;
            return false;
        L40:
            int r103 = 0;
        L42:
            if (r103 >= getValueParameterCount()) goto L49;
            if (getValueParameter(r103).isInitialized() == false) goto L45;
            r103 = r103 + 1;
            goto L42
        L45:
            this.memoizedIsInitialized = 0;
            return false;
        L49:
            if (hasTypeTable() == false) goto L55;
            if (getTypeTable().isInitialized() == true) goto L55;
            this.memoizedIsInitialized = 0;
            return false;
        L55:
            if (hasContract() == false) goto L61;
            if (getContract().isInitialized() == true) goto L61;
            this.memoizedIsInitialized = 0;
            return false;
        L61:
            if (extensionsAreInitialized() == true) goto L64;
            this.memoizedIsInitialized = 0;
            return false;
        L64:
            this.memoizedIsInitialized = 1;
            return true;
        L29:
            if (getReceiverType().isInitialized() == true) goto L32;
            this.memoizedIsInitialized = 0;
            return false;
        L15:
            if (getReturnType().isInitialized() == true) goto L18;
            this.memoizedIsInitialized = 0;
            return false;
        }

        public static Builder newBuilder() {
            return Builder.access$14100();
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

        public static Function getDefaultInstance() {
            return defaultInstance;
        }

        public List<Integer> getContextReceiverTypeIdList() {
            return this.contextReceiverTypeId_;
        }

        public List<Type> getContextReceiverTypeList() {
            return this.contextReceiverType_;
        }

        public Contract getContract() {
            return this.contract_;
        }

        public int getFlags() {
            return this.flags_;
        }

        public int getName() {
            return this.name_;
        }

        public int getOldFlags() {
            return this.oldFlags_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<Function> getParserForType() {
            return PARSER;
        }

        public Type getReceiverType() {
            return this.receiverType_;
        }

        public int getReceiverTypeId() {
            return this.receiverTypeId_;
        }

        public Type getReturnType() {
            return this.returnType_;
        }

        public int getReturnTypeId() {
            return this.returnTypeId_;
        }

        public List<TypeParameter> getTypeParameterList() {
            return this.typeParameter_;
        }

        public TypeTable getTypeTable() {
            return this.typeTable_;
        }

        public List<ValueParameter> getValueParameterList() {
            return this.valueParameter_;
        }

        public List<Integer> getVersionRequirementList() {
            return this.versionRequirement_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public Function getDefaultInstanceForType() {
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

        private Function(GeneratedMessageLite.ExtendableBuilder<Function, ?> r100) {
            super(r100);
            this.contextReceiverTypeIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r100.getUnknownFields();
        }

        public static /* synthetic */ List access$14800(Function r100) {
            return r100.typeParameter_;
        }

        public static /* synthetic */ List access$15100(Function r100) {
            return r100.contextReceiverType_;
        }

        public static /* synthetic */ List access$15200(Function r100) {
            return r100.contextReceiverTypeId_;
        }

        public static /* synthetic */ List access$15300(Function r100) {
            return r100.valueParameter_;
        }

        public static /* synthetic */ List access$15500(Function r100) {
            return r100.versionRequirement_;
        }

        public static /* synthetic */ ByteString access$15800(Function r100) {
            return r100.unknownFields;
        }

        public static Builder newBuilder(Function r100) {
            return newBuilder().mergeFrom(r100);
        }

        public Type getContextReceiverType(int r100) {
            return (Type) ListProtector.get(this.contextReceiverType_, r100);
        }

        public TypeParameter getTypeParameter(int r100) {
            return (TypeParameter) ListProtector.get(this.typeParameter_, r100);
        }

        public ValueParameter getValueParameter(int r100) {
            return (ValueParameter) ListProtector.get(this.valueParameter_, r100);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r100) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter r101 = newExtensionWriter();
            if ((this.bitField0_ & 2) != 2) goto L6;
            r100.writeInt32(1, this.oldFlags_);
        L6:
            if ((this.bitField0_ & 4) != 4) goto L9;
            r100.writeInt32(2, this.name_);
        L9:
            if ((this.bitField0_ & 8) != 8) goto L11;
            r100.writeMessage(3, this.returnType_);
        L11:
            int r102 = 0;
            int r103 = 0;
        L13:
            if (r103 >= this.typeParameter_.size()) goto L16;
            r100.writeMessage(4, (MessageLite) ListProtector.get(this.typeParameter_, r103));
            r103 = r103 + 1;
            goto L13
        L16:
            if ((this.bitField0_ & 32) != 32) goto L18;
            r100.writeMessage(5, this.receiverType_);
        L18:
            int r104 = 0;
        L20:
            if (r104 >= this.valueParameter_.size()) goto L23;
            r100.writeMessage(6, (MessageLite) ListProtector.get(this.valueParameter_, r104));
            r104 = r104 + 1;
            goto L20
        L23:
            if ((this.bitField0_ & 16) != 16) goto L26;
            r100.writeInt32(7, this.returnTypeId_);
        L26:
            if ((this.bitField0_ & 64) != 64) goto L29;
            r100.writeInt32(8, this.receiverTypeId_);
        L29:
            if ((this.bitField0_ & 1) != 1) goto L31;
            r100.writeInt32(9, this.flags_);
        L31:
            int r105 = 0;
        L33:
            if (r105 >= this.contextReceiverType_.size()) goto L36;
            r100.writeMessage(10, (MessageLite) ListProtector.get(this.contextReceiverType_, r105));
            r105 = r105 + 1;
            goto L33
        L36:
            if (getContextReceiverTypeIdList().size() <= 0) goto L38;
            r100.writeRawVarint32(90);
            r100.writeRawVarint32(this.contextReceiverTypeIdMemoizedSerializedSize);
        L38:
            int r106 = 0;
        L40:
            if (r106 >= this.contextReceiverTypeId_.size()) goto L43;
            r100.writeInt32NoTag(((Integer) ListProtector.get(this.contextReceiverTypeId_, r106)).intValue());
            r106 = r106 + 1;
            goto L40
        L43:
            if ((this.bitField0_ & 128) != 128) goto L46;
            r100.writeMessage(30, this.typeTable_);
        L46:
            if (r102 >= this.versionRequirement_.size()) goto L49;
            r100.writeInt32(31, ((Integer) ListProtector.get(this.versionRequirement_, r102)).intValue());
            r102 = r102 + 1;
            goto L46
        L49:
            if ((this.bitField0_ & 256) != 256) goto L51;
            r100.writeMessage(32, this.contract_);
        L51:
            r101.writeUntil(19000, r100);
            r100.writeRawBytes(this.unknownFields);
        }

        private Function(boolean r100) {
            this.contextReceiverTypeIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        private Function(CodedInputStream r110, ExtensionRegistryLite r111) throws InvalidProtocolBufferException {
            this.contextReceiverTypeIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r100 = ByteString.newOutput();
            CodedOutputStream r101 = CodedOutputStream.newInstance(r100, 1);
            boolean r102 = false;
            int r103 = 0;
        L4:
            if (r102 == true) goto L114;
            int r112 = r110.readTag();     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            Type.Builder r113 = null;
            Contract.Builder r114 = null;
            TypeTable.Builder r115 = null;
            Type.Builder r116 = null;
            switch(r112) {
                case 0: goto L80;
                case 8: goto L78;
                case 16: goto L77;
                case 26: goto L71;
                case 34: goto L67;
                case 42: goto L60;
                case 50: goto L56;
                case 56: goto L54;
                case 64: goto L53;
                case 72: goto L52;
                case 82: goto L49;
                case 88: goto L45;
                case 90: goto L35;
                case 242: goto L29;
                case 248: goto L25;
                case 250: goto L15;
                case 258: goto L9;
                default: goto L81;
            };     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
        L9:
            if ((this.bitField0_ & 256) != 256) goto L11;
            r114 = this.contract_.toBuilder();     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
        L11:
            Contract r117 = (Contract) r110.readMessage(Contract.PARSER, r111);     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            this.contract_ = r117;     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            if (r114 == null) goto L14;
            r114.mergeFrom(r117);     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            this.contract_ = r114.buildPartial();     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
        L14:
            this.bitField0_ |= 256;     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            goto L4
        L15:
            int r118 = r110.pushLimit(r110.readRawVarint32());     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            if ((r103 & 4096) == 4096) goto L21;
            if (r110.getBytesUntilLimit() <= 0) goto L21;
            this.versionRequirement_ = new ArrayList();     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            r103 = r103 | 4096;     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
        L21:
            if (r110.getBytesUntilLimit() <= 0) goto L23;
            this.versionRequirement_.add(Integer.valueOf(r110.readInt32()));     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            goto L21
        L23:
            r110.popLimit(r118);     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            goto L4
        L25:
            if ((r103 & 4096) == 4096) goto L27;
            this.versionRequirement_ = new ArrayList();     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            r103 = r103 | 4096;     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
        L27:
            this.versionRequirement_.add(Integer.valueOf(r110.readInt32()));     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            goto L4
        L29:
            if ((this.bitField0_ & 128) != 128) goto L31;
            r115 = this.typeTable_.toBuilder();     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
        L31:
            TypeTable r119 = (TypeTable) r110.readMessage(TypeTable.PARSER, r111);     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            this.typeTable_ = r119;     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            if (r115 == null) goto L34;
            r115.mergeFrom(r119);     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            this.typeTable_ = r115.buildPartial();     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
        L34:
            this.bitField0_ |= 128;     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            goto L4
        L35:
            int r120 = r110.pushLimit(r110.readRawVarint32());     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            if ((r103 & 512) == 512) goto L41;
            if (r110.getBytesUntilLimit() <= 0) goto L41;
            this.contextReceiverTypeId_ = new ArrayList();     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            r103 = r103 | 512;     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
        L41:
            if (r110.getBytesUntilLimit() <= 0) goto L43;
            this.contextReceiverTypeId_.add(Integer.valueOf(r110.readInt32()));     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            goto L41
        L43:
            r110.popLimit(r120);     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            goto L4
        L45:
            if ((r103 & 512) == 512) goto L47;
            this.contextReceiverTypeId_ = new ArrayList();     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            r103 = r103 | 512;     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
        L47:
            this.contextReceiverTypeId_.add(Integer.valueOf(r110.readInt32()));     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            goto L4
        L49:
            if ((r103 & 256) == 256) goto L51;
            this.contextReceiverType_ = new ArrayList();     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            r103 = r103 | 256;     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
        L51:
            this.contextReceiverType_.add((Type) r110.readMessage(Type.PARSER, r111));     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            goto L4
        L52:
            this.bitField0_ |= 1;     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            this.flags_ = r110.readInt32();     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            goto L4
        L53:
            this.bitField0_ |= 64;     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            this.receiverTypeId_ = r110.readInt32();     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            goto L4
        L54:
            this.bitField0_ |= 16;     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            this.returnTypeId_ = r110.readInt32();     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            goto L4
        L56:
            if ((r103 & 1024) == 1024) goto L58;
            this.valueParameter_ = new ArrayList();     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            r103 = r103 | 1024;     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
        L58:
            this.valueParameter_.add((ValueParameter) r110.readMessage(ValueParameter.PARSER, r111));     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            goto L4
        L60:
            if ((this.bitField0_ & 32) != 32) goto L62;
            r116 = this.receiverType_.toBuilder();     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
        L62:
            Type r121 = (Type) r110.readMessage(Type.PARSER, r111);     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            this.receiverType_ = r121;     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            if (r116 == null) goto L65;
            r116.mergeFrom(r121);     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            this.receiverType_ = r116.buildPartial();     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
        L65:
            this.bitField0_ |= 32;     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            goto L4
        L67:
            if ((r103 & 32) == 32) goto L69;
            this.typeParameter_ = new ArrayList();     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            r103 = r103 | 32;     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
        L69:
            this.typeParameter_.add((TypeParameter) r110.readMessage(TypeParameter.PARSER, r111));     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            goto L4
        L71:
            if ((this.bitField0_ & 8) != 8) goto L73;
            r113 = this.returnType_.toBuilder();     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
        L73:
            Type r122 = (Type) r110.readMessage(Type.PARSER, r111);     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            this.returnType_ = r122;     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            if (r113 == null) goto L76;
            r113.mergeFrom(r122);     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            this.returnType_ = r113.buildPartial();     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
        L76:
            this.bitField0_ |= 8;     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            goto L4
        L77:
            this.bitField0_ |= 4;     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            this.name_ = r110.readInt32();     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            goto L4
        L78:
            this.bitField0_ |= 2;     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
            this.oldFlags_ = r110.readInt32();     // Catch: Throwable -> L83 IOException -> L85 InvalidProtocolBufferException -> L88
        L80:
            r102 = true;
            goto L4
        L81:
            if (parseUnknownField(r110, r101, r111, r112) == true) goto L4;
        L83:
            th = move-exception;
            if ((r103 & 32) != 32) goto L95;
            this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
        L95:
            if ((r103 & 1024) != 1024) goto L98;
            this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
        L98:
            if ((r103 & 256) != 256) goto L101;
            this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
        L101:
            if ((r103 & 512) != 512) goto L104;
            this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
        L104:
            if ((r103 & 4096) != 4096) goto L139;
            this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
        L139:
            r101.flush();     // Catch: IOException -> L136 Throwable -> L108
        L108:
            th = move-exception;
            this.unknownFields = r100.toByteString();
            throw th;
        L107:
            this.unknownFields = r100.toByteString();
            makeExtensionsImmutable();
            throw th;
        L85:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L83
        L88:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L83
        L114:
            if ((r103 & 32) != 32) goto L117;
            this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
        L117:
            if ((r103 & 1024) != 1024) goto L120;
            this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
        L120:
            if ((r103 & 256) != 256) goto L123;
            this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
        L123:
            if ((r103 & 512) != 512) goto L126;
            this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
        L126:
            if ((r103 & 4096) != 4096) goto L141;
            this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
        L141:
            r101.flush();     // Catch: IOException -> L135 Throwable -> L130
        L130:
            th = move-exception;
            this.unknownFields = r100.toByteString();
            throw th;
        L129:
            this.unknownFields = r100.toByteString();
            makeExtensionsImmutable();
        }

        public static /* synthetic */ int access$14302(Function r100, int r101) {
            r100.flags_ = r101;
            return r101;
        }

        public static /* synthetic */ int access$14402(Function r100, int r101) {
            r100.oldFlags_ = r101;
            return r101;
        }

        public static /* synthetic */ int access$14502(Function r100, int r101) {
            r100.name_ = r101;
            return r101;
        }

        public static /* synthetic */ Type access$14602(Function r100, Type r101) {
            r100.returnType_ = r101;
            return r101;
        }

        public static /* synthetic */ int access$14702(Function r100, int r101) {
            r100.returnTypeId_ = r101;
            return r101;
        }

        public static /* synthetic */ List access$14802(Function r100, List r101) {
            r100.typeParameter_ = r101;
            return r101;
        }

        public static /* synthetic */ Type access$14902(Function r100, Type r101) {
            r100.receiverType_ = r101;
            return r101;
        }

        public static /* synthetic */ int access$15002(Function r100, int r101) {
            r100.receiverTypeId_ = r101;
            return r101;
        }

        public static /* synthetic */ List access$15102(Function r100, List r101) {
            r100.contextReceiverType_ = r101;
            return r101;
        }

        public static /* synthetic */ List access$15202(Function r100, List r101) {
            r100.contextReceiverTypeId_ = r101;
            return r101;
        }

        public static /* synthetic */ List access$15302(Function r100, List r101) {
            r100.valueParameter_ = r101;
            return r101;
        }

        public static /* synthetic */ TypeTable access$15402(Function r100, TypeTable r101) {
            r100.typeTable_ = r101;
            return r101;
        }

        public static /* synthetic */ List access$15502(Function r100, List r101) {
            r100.versionRequirement_ = r101;
            return r101;
        }

        public static /* synthetic */ Contract access$15602(Function r100, Contract r101) {
            r100.contract_ = r101;
            return r101;
        }

        public static /* synthetic */ int access$15702(Function r100, int r101) {
            r100.bitField0_ = r101;
            return r101;
        }

        public static Function parseFrom(InputStream r100, ExtensionRegistryLite r101) throws IOException {
            return PARSER.parseFrom(r100, r101);
        }

        public /* synthetic */ Function(GeneratedMessageLite.ExtendableBuilder r100, AnonymousClass1 r101) {
            this(r100);
        }

        public /* synthetic */ Function(CodedInputStream r100, ExtensionRegistryLite r101, AnonymousClass1 r102) throws InvalidProtocolBufferException {
            this(r100, r101);
        }
    }

    /* JADX INFO: loaded from: classes5.dex */
    public interface FunctionOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder {
    }

    /* JADX INFO: loaded from: classes5.dex */
    public static final enum MemberKind extends Enum<MemberKind> implements Internal.EnumLite {
        private static final /* synthetic */ MemberKind[] $VALUES = null;
        public static final MemberKind DECLARATION = null;
        public static final MemberKind DELEGATION = null;
        public static final MemberKind FAKE_OVERRIDE = null;
        public static final MemberKind SYNTHESIZED = null;
        private static Internal.EnumLiteMap<MemberKind> internalValueMap;
        private final int value;

        static {
            MemberKind r100 = new MemberKind("DECLARATION", 0, 0, 0);
            DECLARATION = r100;
            MemberKind r101 = new MemberKind("FAKE_OVERRIDE", 1, 1, 1);
            FAKE_OVERRIDE = r101;
            MemberKind r102 = new MemberKind("DELEGATION", 2, 2, 2);
            DELEGATION = r102;
            MemberKind r103 = new MemberKind("SYNTHESIZED", 3, 3, 3);
            SYNTHESIZED = r103;
            $VALUES = new MemberKind[]{r100, r101, r102, r103};
            internalValueMap = new AnonymousClass1();
        }

        public static MemberKind[] values() {
            return (MemberKind[]) $VALUES.clone();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }

        public static MemberKind valueOf(int r100) {
            if (r100 == 0) goto L18;
            if (r100 == 1) goto L16;
            if (r100 == 2) goto L14;
            if (r100 == 3) goto L12;
            return null;
        L12:
            return SYNTHESIZED;
        L14:
            return DELEGATION;
        L16:
            return FAKE_OVERRIDE;
        L18:
            return DECLARATION;
        }

        public static MemberKind valueOf(String r100) {
            return (MemberKind) a.a(MemberKind.class, r100);
        }

        private MemberKind(String r100, int r101, int r102, int r103) {
            super(r100, r101);
            this.value = r103;
        }
    }

    /* JADX INFO: loaded from: classes5.dex */
    public static final enum Modality extends Enum<Modality> implements Internal.EnumLite {
        private static final /* synthetic */ Modality[] $VALUES = null;
        public static final Modality ABSTRACT = null;
        public static final Modality FINAL = null;
        public static final Modality OPEN = null;
        public static final Modality SEALED = null;
        private static Internal.EnumLiteMap<Modality> internalValueMap;
        private final int value;

        static {
            Modality r100 = new Modality("FINAL", 0, 0, 0);
            FINAL = r100;
            Modality r101 = new Modality("OPEN", 1, 1, 1);
            OPEN = r101;
            Modality r102 = new Modality("ABSTRACT", 2, 2, 2);
            ABSTRACT = r102;
            Modality r103 = new Modality("SEALED", 3, 3, 3);
            SEALED = r103;
            $VALUES = new Modality[]{r100, r101, r102, r103};
            internalValueMap = new AnonymousClass1();
        }

        public static Modality[] values() {
            return (Modality[]) $VALUES.clone();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }

        public static Modality valueOf(int r100) {
            if (r100 == 0) goto L18;
            if (r100 == 1) goto L16;
            if (r100 == 2) goto L14;
            if (r100 == 3) goto L12;
            return null;
        L12:
            return SEALED;
        L14:
            return ABSTRACT;
        L16:
            return OPEN;
        L18:
            return FINAL;
        }

        public static Modality valueOf(String r100) {
            return (Modality) a.a(Modality.class, r100);
        }

        private Modality(String r100, int r101, int r102, int r103) {
            super(r100, r101);
            this.value = r103;
        }
    }

    /* JADX INFO: loaded from: classes5.dex */
    public static final class Package extends GeneratedMessageLite.ExtendableMessage<Package> implements PackageOrBuilder {
        public static Parser<Package> PARSER;
        private static final Package defaultInstance = null;
        private int bitField0_;
        private List<Function> function_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<Property> property_;
        private List<TypeAlias> typeAlias_;
        private TypeTable typeTable_;
        private final ByteString unknownFields;
        private VersionRequirementTable versionRequirementTable_;

        /* JADX INFO: loaded from: classes42.dex */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<Package, Builder> implements PackageOrBuilder {
            private int bitField0_;
            private List<Function> function_;
            private List<Property> property_;
            private List<TypeAlias> typeAlias_;
            private TypeTable typeTable_;
            private VersionRequirementTable versionRequirementTable_;

            private void maybeForceBuilderInitialization() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                int r100 = 0;
            L4:
                if (r100 >= getFunctionCount()) goto L9;
                if (getFunction(r100).isInitialized() == false) goto L7;
                r100 = r100 + 1;
                goto L4
            L7:
                return false;
            L9:
                int r101 = 0;
            L11:
                if (r101 >= getPropertyCount()) goto L16;
                if (getProperty(r101).isInitialized() == false) goto L14;
                r101 = r101 + 1;
                goto L11
            L14:
                return false;
            L16:
                int r102 = 0;
            L18:
                if (r102 >= getTypeAliasCount()) goto L24;
                if (getTypeAlias(r102).isInitialized() == false) goto L21;
                r102 = r102 + 1;
                goto L18
            L21:
                return false;
            L24:
                if (hasTypeTable() == false) goto L29;
                if (getTypeTable().isInitialized() == true) goto L29;
                return false;
            L29:
                if (extensionsAreInitialized() == true) goto L31;
                return false;
            L31:
                return true;
            }

            private static Builder create() {
                return new Builder();
            }

            private void ensureFunctionIsMutable() {
                if ((this.bitField0_ & 1) == 1) goto L6;
                this.function_ = new ArrayList(this.function_);
                this.bitField0_ |= 1;
                return;
            }

            private void ensurePropertyIsMutable() {
                if ((this.bitField0_ & 2) == 2) goto L6;
                this.property_ = new ArrayList(this.property_);
                this.bitField0_ |= 2;
                return;
            }

            private void ensureTypeAliasIsMutable() {
                if ((this.bitField0_ & 4) == 4) goto L6;
                this.typeAlias_ = new ArrayList(this.typeAlias_);
                this.bitField0_ |= 4;
                return;
            }

            public Package buildPartial() {
                Package r100 = new Package(this, null);
                int r101 = this.bitField0_;
                int r102 = 1;
                if ((r101 & 1) != 1) goto L5;
                this.function_ = Collections.unmodifiableList(this.function_);
                this.bitField0_ &= -2;
            L5:
                Package.access$11802(r100, this.function_);
                if ((this.bitField0_ & 2) != 2) goto L8;
                this.property_ = Collections.unmodifiableList(this.property_);
                this.bitField0_ &= -3;
            L8:
                Package.access$11902(r100, this.property_);
                if ((this.bitField0_ & 4) != 4) goto L11;
                this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
                this.bitField0_ &= -5;
            L11:
                Package.access$12002(r100, this.typeAlias_);
                if ((r101 & 8) == 8) goto L15;
                r102 = 0;
            L15:
                Package.access$12102(r100, this.typeTable_);
                if ((r101 & 16) != 16) goto L18;
                r102 = r102 | 2;
            L18:
                Package.access$12202(r100, this.versionRequirementTable_);
                Package.access$12302(r100, r102);
                return r100;
            }

            public int getFunctionCount() {
                return this.function_.size();
            }

            public int getPropertyCount() {
                return this.property_.size();
            }

            public int getTypeAliasCount() {
                return this.typeAlias_.size();
            }

            public boolean hasTypeTable() {
                if ((this.bitField0_ & 8) != 8) goto L5;
                return true;
            L5:
                return false;
            }

            private Builder() {
                this.function_ = Collections.emptyList();
                this.property_ = Collections.emptyList();
                this.typeAlias_ = Collections.emptyList();
                this.typeTable_ = TypeTable.getDefaultInstance();
                this.versionRequirementTable_ = VersionRequirementTable.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            public static /* synthetic */ Builder access$11600() {
                return create();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Package build() {
                Package r100 = buildPartial();
                if (r100.isInitialized() == false) goto L6;
                return r100;
            L6:
                throw AbstractMessageLite.Builder.newUninitializedMessageException(r100);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public Package getDefaultInstanceForType() {
                return Package.getDefaultInstance();
            }

            public TypeTable getTypeTable() {
                return this.typeTable_;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo10730clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.ExtendableBuilder clone() {
                return clone();
            }

            public Function getFunction(int r100) {
                return (Function) ListProtector.get(this.function_, r100);
            }

            public Property getProperty(int r100) {
                return (Property) ListProtector.get(this.property_, r100);
            }

            public TypeAlias getTypeAlias(int r100) {
                return (TypeAlias) ListProtector.get(this.typeAlias_, r100);
            }

            public Builder mergeFrom(Package r100) {
                if (r100 != Package.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (Package.access$11800(r100).isEmpty() == true) goto L12;
                if (this.function_.isEmpty() == false) goto L10;
                this.function_ = Package.access$11800(r100);
                this.bitField0_ &= -2;
                goto L12
            L10:
                ensureFunctionIsMutable();
                this.function_.addAll(Package.access$11800(r100));
            L12:
                if (Package.access$11900(r100).isEmpty() == true) goto L18;
                if (this.property_.isEmpty() == false) goto L16;
                this.property_ = Package.access$11900(r100);
                this.bitField0_ &= -3;
                goto L18
            L16:
                ensurePropertyIsMutable();
                this.property_.addAll(Package.access$11900(r100));
            L18:
                if (Package.access$12000(r100).isEmpty() == true) goto L24;
                if (this.typeAlias_.isEmpty() == false) goto L22;
                this.typeAlias_ = Package.access$12000(r100);
                this.bitField0_ &= -5;
                goto L24
            L22:
                ensureTypeAliasIsMutable();
                this.typeAlias_.addAll(Package.access$12000(r100));
            L24:
                if (r100.hasTypeTable() == false) goto L27;
                mergeTypeTable(r100.getTypeTable());
            L27:
                if (r100.hasVersionRequirementTable() == false) goto L29;
                mergeVersionRequirementTable(r100.getVersionRequirementTable());
            L29:
                mergeExtensionFields(r100);
                setUnknownFields(getUnknownFields().concat(Package.access$12400(r100)));
                return this;
            }

            public Builder mergeTypeTable(TypeTable r100) {
                if ((this.bitField0_ & 8) == 8) goto L5;
            L7:
                this.typeTable_ = r100;
            L8:
                this.bitField0_ |= 8;
                return this;
            L5:
                if (this.typeTable_ == TypeTable.getDefaultInstance()) goto L7;
                this.typeTable_ = TypeTable.newBuilder(this.typeTable_).mergeFrom(r100).buildPartial();
                goto L8
            }

            public Builder mergeVersionRequirementTable(VersionRequirementTable r100) {
                if ((this.bitField0_ & 16) == 16) goto L5;
            L7:
                this.versionRequirementTable_ = r100;
            L8:
                this.bitField0_ |= 16;
                return this;
            L5:
                if (this.versionRequirementTable_ == VersionRequirementTable.getDefaultInstance()) goto L7;
                this.versionRequirementTable_ = VersionRequirementTable.newBuilder(this.versionRequirementTable_).mergeFrom(r100).buildPartial();
                goto L8
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r100) {
                return mergeFrom((Package) r100);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
                Package r102 = null;
                Package r103 = Package.PARSER.parsePartialFrom(r100, r101);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r103 == null) goto L6;
                mergeFrom(r103);
            L6:
                return this;
            L9:
                e = move-exception;
                Package r104 = (Package) e.getUnfinishedMessage();     // Catch: Throwable -> L7
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
            Package r100 = new Package(true);
            defaultInstance = r100;
            r100.initFields();
        }

        public int getFunctionCount() {
            return this.function_.size();
        }

        public int getPropertyCount() {
            return this.property_.size();
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
            if (r102 >= this.function_.size()) goto L9;
            r103 = r103 + CodedOutputStream.computeMessageSize(3, (MessageLite) ListProtector.get(this.function_, r102));
            r102 = r102 + 1;
            goto L7
        L9:
            int r104 = 0;
        L11:
            if (r104 >= this.property_.size()) goto L14;
            r103 = r103 + CodedOutputStream.computeMessageSize(4, (MessageLite) ListProtector.get(this.property_, r104));
            r104 = r104 + 1;
        L14:
            if (r101 >= this.typeAlias_.size()) goto L17;
            r103 = r103 + CodedOutputStream.computeMessageSize(5, (MessageLite) ListProtector.get(this.typeAlias_, r101));
            r101 = r101 + 1;
            goto L14
        L17:
            if ((this.bitField0_ & 1) != 1) goto L20;
            r103 = r103 + CodedOutputStream.computeMessageSize(30, this.typeTable_);
        L20:
            if ((this.bitField0_ & 2) != 2) goto L22;
            r103 = r103 + CodedOutputStream.computeMessageSize(32, this.versionRequirementTable_);
        L22:
            int r105 = (r103 + extensionsSerializedSize()) + this.unknownFields.size();
            this.memoizedSerializedSize = r105;
            return r105;
        }

        public int getTypeAliasCount() {
            return this.typeAlias_.size();
        }

        public boolean hasTypeTable() {
            if ((this.bitField0_ & 1) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        public boolean hasVersionRequirementTable() {
            if ((this.bitField0_ & 2) != 2) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte r100 = this.memoizedIsInitialized;
            if (r100 != 1) goto L6;
            return true;
        L6:
            if (r100 != 0) goto L8;
            return false;
        L8:
            int r101 = 0;
        L10:
            if (r101 >= getFunctionCount()) goto L16;
            if (getFunction(r101).isInitialized() == false) goto L13;
            r101 = r101 + 1;
            goto L10
        L13:
            this.memoizedIsInitialized = 0;
            return false;
        L16:
            int r102 = 0;
        L18:
            if (r102 >= getPropertyCount()) goto L24;
            if (getProperty(r102).isInitialized() == false) goto L21;
            r102 = r102 + 1;
            goto L18
        L21:
            this.memoizedIsInitialized = 0;
            return false;
        L24:
            int r103 = 0;
        L26:
            if (r103 >= getTypeAliasCount()) goto L33;
            if (getTypeAlias(r103).isInitialized() == false) goto L29;
            r103 = r103 + 1;
            goto L26
        L29:
            this.memoizedIsInitialized = 0;
            return false;
        L33:
            if (hasTypeTable() == false) goto L39;
            if (getTypeTable().isInitialized() == true) goto L39;
            this.memoizedIsInitialized = 0;
            return false;
        L39:
            if (extensionsAreInitialized() == true) goto L42;
            this.memoizedIsInitialized = 0;
            return false;
        L42:
            this.memoizedIsInitialized = 1;
            return true;
        }

        private void initFields() {
            this.function_ = Collections.emptyList();
            this.property_ = Collections.emptyList();
            this.typeAlias_ = Collections.emptyList();
            this.typeTable_ = TypeTable.getDefaultInstance();
            this.versionRequirementTable_ = VersionRequirementTable.getDefaultInstance();
        }

        public static Builder newBuilder() {
            return Builder.access$11600();
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

        public static Package getDefaultInstance() {
            return defaultInstance;
        }

        public List<Function> getFunctionList() {
            return this.function_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<Package> getParserForType() {
            return PARSER;
        }

        public List<Property> getPropertyList() {
            return this.property_;
        }

        public List<TypeAlias> getTypeAliasList() {
            return this.typeAlias_;
        }

        public TypeTable getTypeTable() {
            return this.typeTable_;
        }

        public VersionRequirementTable getVersionRequirementTable() {
            return this.versionRequirementTable_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public Package getDefaultInstanceForType() {
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

        private Package(GeneratedMessageLite.ExtendableBuilder<Package, ?> r100) {
            super(r100);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r100.getUnknownFields();
        }

        public static /* synthetic */ List access$11800(Package r100) {
            return r100.function_;
        }

        public static /* synthetic */ List access$11900(Package r100) {
            return r100.property_;
        }

        public static /* synthetic */ List access$12000(Package r100) {
            return r100.typeAlias_;
        }

        public static /* synthetic */ ByteString access$12400(Package r100) {
            return r100.unknownFields;
        }

        public static Builder newBuilder(Package r100) {
            return newBuilder().mergeFrom(r100);
        }

        public Function getFunction(int r100) {
            return (Function) ListProtector.get(this.function_, r100);
        }

        public Property getProperty(int r100) {
            return (Property) ListProtector.get(this.property_, r100);
        }

        public TypeAlias getTypeAlias(int r100) {
            return (TypeAlias) ListProtector.get(this.typeAlias_, r100);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r100) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter r101 = newExtensionWriter();
            int r102 = 0;
            int r103 = 0;
        L4:
            if (r103 >= this.function_.size()) goto L6;
            r100.writeMessage(3, (MessageLite) ListProtector.get(this.function_, r103));
            r103 = r103 + 1;
            goto L4
        L6:
            int r104 = 0;
        L8:
            if (r104 >= this.property_.size()) goto L11;
            r100.writeMessage(4, (MessageLite) ListProtector.get(this.property_, r104));
            r104 = r104 + 1;
        L11:
            if (r102 >= this.typeAlias_.size()) goto L14;
            r100.writeMessage(5, (MessageLite) ListProtector.get(this.typeAlias_, r102));
            r102 = r102 + 1;
            goto L11
        L14:
            if ((this.bitField0_ & 1) != 1) goto L17;
            r100.writeMessage(30, this.typeTable_);
        L17:
            if ((this.bitField0_ & 2) != 2) goto L19;
            r100.writeMessage(32, this.versionRequirementTable_);
        L19:
            r101.writeUntil(200, r100);
            r100.writeRawBytes(this.unknownFields);
        }

        private Package(boolean r100) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        private Package(CodedInputStream r110, ExtensionRegistryLite r111) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r100 = ByteString.newOutput();
            CodedOutputStream r101 = CodedOutputStream.newInstance(r100, 1);
            boolean r102 = false;
            int r103 = 0;
        L4:
            if (r102 == true) goto L73;
            int r104 = r110.readTag();     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
            if (r104 == 0) goto L47;
            if (r104 != 26) goto L10;
            if ((r103 & 1) == 1) goto L45;
            this.function_ = new ArrayList();     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
            r103 = r103 | 1;     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
        L45:
            this.function_.add((Function) r110.readMessage(Function.PARSER, r111));     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
            goto L4
        L10:
            if (r104 != 34) goto L12;
            if ((r103 & 2) == 2) goto L41;
            this.property_ = new ArrayList();     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
            r103 = r103 | 2;     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
        L41:
            this.property_.add((Property) r110.readMessage(Property.PARSER, r111));     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
            goto L4
        L12:
            if (r104 != 42) goto L13;
            if ((r103 & 4) == 4) goto L37;
            this.typeAlias_ = new ArrayList();     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
            r103 = r103 | 4;     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
        L37:
            this.typeAlias_.add((TypeAlias) r110.readMessage(TypeAlias.PARSER, r111));     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
            goto L4
        L13:
            VersionRequirementTable.Builder r105 = null;
            TypeTable.Builder r106 = null;
            if (r104 != 242) goto L16;
            if ((this.bitField0_ & 1) != 1) goto L30;
            r106 = this.typeTable_.toBuilder();     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
        L30:
            TypeTable r107 = (TypeTable) r110.readMessage(TypeTable.PARSER, r111);     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
            this.typeTable_ = r107;     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
            if (r106 == null) goto L33;
            r106.mergeFrom(r107);     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
            this.typeTable_ = r106.buildPartial();     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
        L33:
            this.bitField0_ |= 1;     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
            goto L4
        L16:
            if (r104 != 258) goto L18;
            if ((this.bitField0_ & 2) != 2) goto L23;
            r105 = this.versionRequirementTable_.toBuilder();     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
        L23:
            VersionRequirementTable r108 = (VersionRequirementTable) r110.readMessage(VersionRequirementTable.PARSER, r111);     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
            this.versionRequirementTable_ = r108;     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
            if (r105 == null) goto L26;
            r105.mergeFrom(r108);     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
            this.versionRequirementTable_ = r105.buildPartial();     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
        L26:
            this.bitField0_ |= 2;     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
            goto L4
        L18:
            if (parseUnknownField(r110, r101, r111, r104) == true) goto L4;
        L47:
            r102 = true;
            goto L4
        L48:
            th = move-exception;
            if ((r103 & 1) != 1) goto L60;
            this.function_ = Collections.unmodifiableList(this.function_);
        L60:
            if ((r103 & 2) != 2) goto L63;
            this.property_ = Collections.unmodifiableList(this.property_);
        L63:
            if ((r103 & 4) != 4) goto L92;
            this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
        L92:
            r101.flush();     // Catch: IOException -> L89 Throwable -> L67
        L67:
            th = move-exception;
            this.unknownFields = r100.toByteString();
            throw th;
        L66:
            this.unknownFields = r100.toByteString();
            makeExtensionsImmutable();
            throw th;
        L53:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L48
        L50:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L48
        L73:
            if ((r103 & 1) != 1) goto L76;
            this.function_ = Collections.unmodifiableList(this.function_);
        L76:
            if ((r103 & 2) != 2) goto L79;
            this.property_ = Collections.unmodifiableList(this.property_);
        L79:
            if ((r103 & 4) != 4) goto L94;
            this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
        L94:
            r101.flush();     // Catch: IOException -> L88 Throwable -> L83
        L83:
            th = move-exception;
            this.unknownFields = r100.toByteString();
            throw th;
        L82:
            this.unknownFields = r100.toByteString();
            makeExtensionsImmutable();
        }

        public static /* synthetic */ List access$11802(Package r100, List r101) {
            r100.function_ = r101;
            return r101;
        }

        public static /* synthetic */ List access$11902(Package r100, List r101) {
            r100.property_ = r101;
            return r101;
        }

        public static /* synthetic */ List access$12002(Package r100, List r101) {
            r100.typeAlias_ = r101;
            return r101;
        }

        public static /* synthetic */ TypeTable access$12102(Package r100, TypeTable r101) {
            r100.typeTable_ = r101;
            return r101;
        }

        public static /* synthetic */ VersionRequirementTable access$12202(Package r100, VersionRequirementTable r101) {
            r100.versionRequirementTable_ = r101;
            return r101;
        }

        public static /* synthetic */ int access$12302(Package r100, int r101) {
            r100.bitField0_ = r101;
            return r101;
        }

        public static Package parseFrom(InputStream r100, ExtensionRegistryLite r101) throws IOException {
            return PARSER.parseFrom(r100, r101);
        }

        public /* synthetic */ Package(GeneratedMessageLite.ExtendableBuilder r100, AnonymousClass1 r101) {
            this(r100);
        }

        public /* synthetic */ Package(CodedInputStream r100, ExtensionRegistryLite r101, AnonymousClass1 r102) throws InvalidProtocolBufferException {
            this(r100, r101);
        }
    }

    /* JADX INFO: loaded from: classes5.dex */
    public static final class PackageFragment extends GeneratedMessageLite.ExtendableMessage<PackageFragment> implements PackageFragmentOrBuilder {
        public static Parser<PackageFragment> PARSER;
        private static final PackageFragment defaultInstance = null;
        private int bitField0_;
        private List<Class> class__;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private Package package_;
        private QualifiedNameTable qualifiedNames_;
        private StringTable strings_;
        private final ByteString unknownFields;

        /* JADX INFO: loaded from: classes42.dex */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<PackageFragment, Builder> implements PackageFragmentOrBuilder {
            private int bitField0_;
            private List<Class> class__;
            private Package package_;
            private QualifiedNameTable qualifiedNames_;
            private StringTable strings_;

            private void maybeForceBuilderInitialization() {
            }

            private static Builder create() {
                return new Builder();
            }

            private void ensureClass_IsMutable() {
                if ((this.bitField0_ & 8) == 8) goto L6;
                this.class__ = new ArrayList(this.class__);
                this.bitField0_ |= 8;
                return;
            }

            public PackageFragment buildPartial() {
                PackageFragment r100 = new PackageFragment(this, null);
                int r101 = this.bitField0_;
                int r102 = 1;
                if ((r101 & 1) == 1) goto L6;
                r102 = 0;
            L6:
                PackageFragment.access$22802(r100, this.strings_);
                if ((r101 & 2) != 2) goto L9;
                r102 = r102 | 2;
            L9:
                PackageFragment.access$22902(r100, this.qualifiedNames_);
                if ((r101 & 4) != 4) goto L12;
                r102 = r102 | 4;
            L12:
                PackageFragment.access$23002(r100, this.package_);
                if ((this.bitField0_ & 8) != 8) goto L15;
                this.class__ = Collections.unmodifiableList(this.class__);
                this.bitField0_ &= -9;
            L15:
                PackageFragment.access$23102(r100, this.class__);
                PackageFragment.access$23202(r100, r102);
                return r100;
            }

            public int getClass_Count() {
                return this.class__.size();
            }

            public boolean hasPackage() {
                if ((this.bitField0_ & 4) != 4) goto L5;
                return true;
            L5:
                return false;
            }

            public boolean hasQualifiedNames() {
                if ((this.bitField0_ & 2) != 2) goto L5;
                return true;
            L5:
                return false;
            }

            private Builder() {
                this.strings_ = StringTable.getDefaultInstance();
                this.qualifiedNames_ = QualifiedNameTable.getDefaultInstance();
                this.package_ = Package.getDefaultInstance();
                this.class__ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            public static /* synthetic */ Builder access$22600() {
                return create();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public PackageFragment build() {
                PackageFragment r100 = buildPartial();
                if (r100.isInitialized() == false) goto L6;
                return r100;
            L6:
                throw AbstractMessageLite.Builder.newUninitializedMessageException(r100);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public PackageFragment getDefaultInstanceForType() {
                return PackageFragment.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                if (hasQualifiedNames() == false) goto L8;
                if (getQualifiedNames().isInitialized() == true) goto L8;
                return false;
            L8:
                if (hasPackage() == true) goto L10;
            L12:
                int r100 = 0;
            L14:
                if (r100 >= getClass_Count()) goto L20;
                if (getClass_(r100).isInitialized() == false) goto L17;
                r100 = r100 + 1;
                goto L14
            L17:
                return false;
            L20:
                if (extensionsAreInitialized() == true) goto L22;
                return false;
            L22:
                return true;
            L10:
                if (getPackage().isInitialized() == true) goto L12;
                return false;
            }

            public Package getPackage() {
                return this.package_;
            }

            public QualifiedNameTable getQualifiedNames() {
                return this.qualifiedNames_;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo10730clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.ExtendableBuilder clone() {
                return clone();
            }

            public Class getClass_(int r100) {
                return (Class) ListProtector.get(this.class__, r100);
            }

            public Builder mergeFrom(PackageFragment r100) {
                if (r100 != PackageFragment.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r100.hasStrings() == false) goto L9;
                mergeStrings(r100.getStrings());
            L9:
                if (r100.hasQualifiedNames() == false) goto L12;
                mergeQualifiedNames(r100.getQualifiedNames());
            L12:
                if (r100.hasPackage() == false) goto L15;
                mergePackage(r100.getPackage());
            L15:
                if (PackageFragment.access$23100(r100).isEmpty() == false) goto L17;
            L20:
                mergeExtensionFields(r100);
                setUnknownFields(getUnknownFields().concat(PackageFragment.access$23300(r100)));
                return this;
            L17:
                if (this.class__.isEmpty() == false) goto L19;
                this.class__ = PackageFragment.access$23100(r100);
                this.bitField0_ &= -9;
                goto L20
            L19:
                ensureClass_IsMutable();
                this.class__.addAll(PackageFragment.access$23100(r100));
                goto L20
            }

            public Builder mergePackage(Package r100) {
                if ((this.bitField0_ & 4) == 4) goto L5;
            L7:
                this.package_ = r100;
            L8:
                this.bitField0_ |= 4;
                return this;
            L5:
                if (this.package_ == Package.getDefaultInstance()) goto L7;
                this.package_ = Package.newBuilder(this.package_).mergeFrom(r100).buildPartial();
                goto L8
            }

            public Builder mergeQualifiedNames(QualifiedNameTable r100) {
                if ((this.bitField0_ & 2) == 2) goto L5;
            L7:
                this.qualifiedNames_ = r100;
            L8:
                this.bitField0_ |= 2;
                return this;
            L5:
                if (this.qualifiedNames_ == QualifiedNameTable.getDefaultInstance()) goto L7;
                this.qualifiedNames_ = QualifiedNameTable.newBuilder(this.qualifiedNames_).mergeFrom(r100).buildPartial();
                goto L8
            }

            public Builder mergeStrings(StringTable r100) {
                if ((this.bitField0_ & 1) == 1) goto L5;
            L7:
                this.strings_ = r100;
            L8:
                this.bitField0_ |= 1;
                return this;
            L5:
                if (this.strings_ == StringTable.getDefaultInstance()) goto L7;
                this.strings_ = StringTable.newBuilder(this.strings_).mergeFrom(r100).buildPartial();
                goto L8
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r100) {
                return mergeFrom((PackageFragment) r100);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
                PackageFragment r102 = null;
                PackageFragment r103 = PackageFragment.PARSER.parsePartialFrom(r100, r101);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r103 == null) goto L6;
                mergeFrom(r103);
            L6:
                return this;
            L9:
                e = move-exception;
                PackageFragment r104 = (PackageFragment) e.getUnfinishedMessage();     // Catch: Throwable -> L7
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
            PackageFragment r100 = new PackageFragment(true);
            defaultInstance = r100;
            r100.initFields();
        }

        public int getClass_Count() {
            return this.class__.size();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int r100 = this.memoizedSerializedSize;
            if (r100 == (-1)) goto L5;
            return r100;
        L5:
            int r101 = 0;
            if ((this.bitField0_ & 1) != 1) goto L8;
            int r102 = CodedOutputStream.computeMessageSize(1, this.strings_) + 0;
        L10:
            if ((this.bitField0_ & 2) != 2) goto L13;
            r102 = r102 + CodedOutputStream.computeMessageSize(2, this.qualifiedNames_);
        L13:
            if ((this.bitField0_ & 4) != 4) goto L16;
            r102 = r102 + CodedOutputStream.computeMessageSize(3, this.package_);
        L16:
            if (r101 >= this.class__.size()) goto L18;
            r102 = r102 + CodedOutputStream.computeMessageSize(4, (MessageLite) ListProtector.get(this.class__, r101));
            r101 = r101 + 1;
            goto L16
        L18:
            int r103 = (r102 + extensionsSerializedSize()) + this.unknownFields.size();
            this.memoizedSerializedSize = r103;
            return r103;
        L8:
            r102 = 0;
            goto L10
        }

        public boolean hasPackage() {
            if ((this.bitField0_ & 4) != 4) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasQualifiedNames() {
            if ((this.bitField0_ & 2) != 2) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasStrings() {
            if ((this.bitField0_ & 1) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte r100 = this.memoizedIsInitialized;
            if (r100 != 1) goto L6;
            return true;
        L6:
            if (r100 != 0) goto L9;
            return false;
        L9:
            if (hasQualifiedNames() == false) goto L15;
            if (getQualifiedNames().isInitialized() == true) goto L15;
            this.memoizedIsInitialized = 0;
            return false;
        L15:
            if (hasPackage() == true) goto L17;
        L20:
            int r101 = 0;
        L22:
            if (r101 >= getClass_Count()) goto L29;
            if (getClass_(r101).isInitialized() == false) goto L25;
            r101 = r101 + 1;
            goto L22
        L25:
            this.memoizedIsInitialized = 0;
            return false;
        L29:
            if (extensionsAreInitialized() == true) goto L32;
            this.memoizedIsInitialized = 0;
            return false;
        L32:
            this.memoizedIsInitialized = 1;
            return true;
        L17:
            if (getPackage().isInitialized() == true) goto L20;
            this.memoizedIsInitialized = 0;
            return false;
        }

        private void initFields() {
            this.strings_ = StringTable.getDefaultInstance();
            this.qualifiedNames_ = QualifiedNameTable.getDefaultInstance();
            this.package_ = Package.getDefaultInstance();
            this.class__ = Collections.emptyList();
        }

        public static Builder newBuilder() {
            return Builder.access$22600();
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

        public static PackageFragment getDefaultInstance() {
            return defaultInstance;
        }

        public List<Class> getClass_List() {
            return this.class__;
        }

        public Package getPackage() {
            return this.package_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<PackageFragment> getParserForType() {
            return PARSER;
        }

        public QualifiedNameTable getQualifiedNames() {
            return this.qualifiedNames_;
        }

        public StringTable getStrings() {
            return this.strings_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public PackageFragment getDefaultInstanceForType() {
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

        private PackageFragment(GeneratedMessageLite.ExtendableBuilder<PackageFragment, ?> r100) {
            super(r100);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r100.getUnknownFields();
        }

        public static /* synthetic */ List access$23100(PackageFragment r100) {
            return r100.class__;
        }

        public static /* synthetic */ ByteString access$23300(PackageFragment r100) {
            return r100.unknownFields;
        }

        public static Builder newBuilder(PackageFragment r100) {
            return newBuilder().mergeFrom(r100);
        }

        public Class getClass_(int r100) {
            return (Class) ListProtector.get(this.class__, r100);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r100) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter r101 = newExtensionWriter();
            if ((this.bitField0_ & 1) != 1) goto L6;
            r100.writeMessage(1, this.strings_);
        L6:
            if ((this.bitField0_ & 2) != 2) goto L9;
            r100.writeMessage(2, this.qualifiedNames_);
        L9:
            if ((this.bitField0_ & 4) != 4) goto L11;
            r100.writeMessage(3, this.package_);
        L11:
            int r102 = 0;
        L13:
            if (r102 >= this.class__.size()) goto L15;
            r100.writeMessage(4, (MessageLite) ListProtector.get(this.class__, r102));
            r102 = r102 + 1;
            goto L13
        L15:
            r101.writeUntil(200, r100);
            r100.writeRawBytes(this.unknownFields);
        }

        private PackageFragment(boolean r100) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        private PackageFragment(CodedInputStream r110, ExtensionRegistryLite r111) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r100 = ByteString.newOutput();
            CodedOutputStream r101 = CodedOutputStream.newInstance(r100, 1);
            boolean r102 = false;
            int r103 = 0;
        L4:
            if (r102 == true) goto L64;
            int r104 = r110.readTag();     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
            if (r104 == 0) goto L44;
            Package.Builder r105 = null;
            StringTable.Builder r106 = null;
            QualifiedNameTable.Builder r107 = null;
            if (r104 != 10) goto L10;
            if ((this.bitField0_ & 1) != 1) goto L39;
            r106 = this.strings_.toBuilder();     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
        L39:
            StringTable r108 = (StringTable) r110.readMessage(StringTable.PARSER, r111);     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
            this.strings_ = r108;     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
            if (r106 == null) goto L42;
            r106.mergeFrom(r108);     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
            this.strings_ = r106.buildPartial();     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
        L42:
            this.bitField0_ |= 1;     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
            goto L4
        L10:
            if (r104 != 18) goto L12;
            if ((this.bitField0_ & 2) != 2) goto L32;
            r107 = this.qualifiedNames_.toBuilder();     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
        L32:
            QualifiedNameTable r109 = (QualifiedNameTable) r110.readMessage(QualifiedNameTable.PARSER, r111);     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
            this.qualifiedNames_ = r109;     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
            if (r107 == null) goto L35;
            r107.mergeFrom(r109);     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
            this.qualifiedNames_ = r107.buildPartial();     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
        L35:
            this.bitField0_ |= 2;     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
            goto L4
        L12:
            if (r104 != 26) goto L14;
            if ((this.bitField0_ & 4) != 4) goto L25;
            r105 = this.package_.toBuilder();     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
        L25:
            Package r112 = (Package) r110.readMessage(Package.PARSER, r111);     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
            this.package_ = r112;     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
            if (r105 == null) goto L28;
            r105.mergeFrom(r112);     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
            this.package_ = r105.buildPartial();     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
        L28:
            this.bitField0_ |= 4;     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
            goto L4
        L14:
            if (r104 != 34) goto L16;
            if ((r103 & 8) == 8) goto L21;
            this.class__ = new ArrayList();     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
            r103 = r103 | 8;     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
        L21:
            this.class__.add((Class) r110.readMessage(Class.PARSER, r111));     // Catch: Throwable -> L45 IOException -> L47 InvalidProtocolBufferException -> L50
            goto L4
        L16:
            if (parseUnknownField(r110, r101, r111, r104) == true) goto L4;
        L44:
            r102 = true;
            goto L4
        L45:
            th = move-exception;
            if ((r103 & 8) != 8) goto L79;
            this.class__ = Collections.unmodifiableList(this.class__);
        L79:
            r101.flush();     // Catch: IOException -> L74 Throwable -> L58
        L58:
            th = move-exception;
            this.unknownFields = r100.toByteString();
            throw th;
        L57:
            this.unknownFields = r100.toByteString();
            makeExtensionsImmutable();
            throw th;
        L47:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L45
        L50:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L45
        L64:
            if ((r103 & 8) != 8) goto L77;
            this.class__ = Collections.unmodifiableList(this.class__);
        L77:
            r101.flush();     // Catch: IOException -> L73 Throwable -> L68
        L68:
            th = move-exception;
            this.unknownFields = r100.toByteString();
            throw th;
        L67:
            this.unknownFields = r100.toByteString();
            makeExtensionsImmutable();
        }

        public static /* synthetic */ StringTable access$22802(PackageFragment r100, StringTable r101) {
            r100.strings_ = r101;
            return r101;
        }

        public static /* synthetic */ QualifiedNameTable access$22902(PackageFragment r100, QualifiedNameTable r101) {
            r100.qualifiedNames_ = r101;
            return r101;
        }

        public static /* synthetic */ Package access$23002(PackageFragment r100, Package r101) {
            r100.package_ = r101;
            return r101;
        }

        public static /* synthetic */ List access$23102(PackageFragment r100, List r101) {
            r100.class__ = r101;
            return r101;
        }

        public static /* synthetic */ int access$23202(PackageFragment r100, int r101) {
            r100.bitField0_ = r101;
            return r101;
        }

        public static PackageFragment parseFrom(InputStream r100, ExtensionRegistryLite r101) throws IOException {
            return PARSER.parseFrom(r100, r101);
        }

        public /* synthetic */ PackageFragment(GeneratedMessageLite.ExtendableBuilder r100, AnonymousClass1 r101) {
            this(r100);
        }

        public /* synthetic */ PackageFragment(CodedInputStream r100, ExtensionRegistryLite r101, AnonymousClass1 r102) throws InvalidProtocolBufferException {
            this(r100, r101);
        }
    }

    /* JADX INFO: loaded from: classes5.dex */
    public interface PackageFragmentOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder {
    }

    /* JADX INFO: loaded from: classes5.dex */
    public interface PackageOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder {
    }

    /* JADX INFO: loaded from: classes5.dex */
    public static final class Property extends GeneratedMessageLite.ExtendableMessage<Property> implements PropertyOrBuilder {
        public static Parser<Property> PARSER;
        private static final Property defaultInstance = null;
        private int bitField0_;
        private int contextReceiverTypeIdMemoizedSerializedSize;
        private List<Integer> contextReceiverTypeId_;
        private List<Type> contextReceiverType_;
        private int flags_;
        private int getterFlags_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private int oldFlags_;
        private int receiverTypeId_;
        private Type receiverType_;
        private int returnTypeId_;
        private Type returnType_;
        private int setterFlags_;
        private ValueParameter setterValueParameter_;
        private List<TypeParameter> typeParameter_;
        private final ByteString unknownFields;
        private List<Integer> versionRequirement_;

        /* JADX INFO: loaded from: classes42.dex */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<Property, Builder> implements PropertyOrBuilder {
            private int bitField0_;
            private List<Integer> contextReceiverTypeId_;
            private List<Type> contextReceiverType_;
            private int flags_;
            private int getterFlags_;
            private int name_;
            private int oldFlags_;
            private int receiverTypeId_;
            private Type receiverType_;
            private int returnTypeId_;
            private Type returnType_;
            private int setterFlags_;
            private ValueParameter setterValueParameter_;
            private List<TypeParameter> typeParameter_;
            private List<Integer> versionRequirement_;

            private void maybeForceBuilderInitialization() {
            }

            private static Builder create() {
                return new Builder();
            }

            private void ensureContextReceiverTypeIdIsMutable() {
                if ((this.bitField0_ & 512) == 512) goto L6;
                this.contextReceiverTypeId_ = new ArrayList(this.contextReceiverTypeId_);
                this.bitField0_ |= 512;
                return;
            }

            private void ensureContextReceiverTypeIsMutable() {
                if ((this.bitField0_ & 256) == 256) goto L6;
                this.contextReceiverType_ = new ArrayList(this.contextReceiverType_);
                this.bitField0_ |= 256;
                return;
            }

            private void ensureTypeParameterIsMutable() {
                if ((this.bitField0_ & 32) == 32) goto L6;
                this.typeParameter_ = new ArrayList(this.typeParameter_);
                this.bitField0_ |= 32;
                return;
            }

            private void ensureVersionRequirementIsMutable() {
                if ((this.bitField0_ & 8192) == 8192) goto L6;
                this.versionRequirement_ = new ArrayList(this.versionRequirement_);
                this.bitField0_ |= 8192;
                return;
            }

            public Property buildPartial() {
                Property r100 = new Property(this, null);
                int r101 = this.bitField0_;
                int r102 = 1;
                if ((r101 & 1) == 1) goto L6;
                r102 = 0;
            L6:
                Property.access$16202(r100, this.flags_);
                if ((r101 & 2) != 2) goto L9;
                r102 = r102 | 2;
            L9:
                Property.access$16302(r100, this.oldFlags_);
                if ((r101 & 4) != 4) goto L12;
                r102 = r102 | 4;
            L12:
                Property.access$16402(r100, this.name_);
                if ((r101 & 8) != 8) goto L15;
                r102 = r102 | 8;
            L15:
                Property.access$16502(r100, this.returnType_);
                if ((r101 & 16) != 16) goto L18;
                r102 = r102 | 16;
            L18:
                Property.access$16602(r100, this.returnTypeId_);
                if ((this.bitField0_ & 32) != 32) goto L21;
                this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                this.bitField0_ &= -33;
            L21:
                Property.access$16702(r100, this.typeParameter_);
                if ((r101 & 64) != 64) goto L24;
                r102 = r102 | 32;
            L24:
                Property.access$16802(r100, this.receiverType_);
                if ((r101 & 128) != 128) goto L27;
                r102 = r102 | 64;
            L27:
                Property.access$16902(r100, this.receiverTypeId_);
                if ((this.bitField0_ & 256) != 256) goto L30;
                this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
                this.bitField0_ &= -257;
            L30:
                Property.access$17002(r100, this.contextReceiverType_);
                if ((this.bitField0_ & 512) != 512) goto L33;
                this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
                this.bitField0_ &= NetError.ERR_TTNET_FT_INVALID_STREAM;
            L33:
                Property.access$17102(r100, this.contextReceiverTypeId_);
                if ((r101 & 1024) != 1024) goto L36;
                r102 = r102 | 128;
            L36:
                Property.access$17202(r100, this.setterValueParameter_);
                if ((r101 & 2048) != 2048) goto L39;
                r102 = r102 | 256;
            L39:
                Property.access$17302(r100, this.getterFlags_);
                if ((r101 & 4096) != 4096) goto L42;
                r102 = r102 | 512;
            L42:
                Property.access$17402(r100, this.setterFlags_);
                if ((this.bitField0_ & 8192) != 8192) goto L45;
                this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                this.bitField0_ &= -8193;
            L45:
                Property.access$17502(r100, this.versionRequirement_);
                Property.access$17602(r100, r102);
                return r100;
            }

            public int getContextReceiverTypeCount() {
                return this.contextReceiverType_.size();
            }

            public int getTypeParameterCount() {
                return this.typeParameter_.size();
            }

            public boolean hasName() {
                if ((this.bitField0_ & 4) != 4) goto L5;
                return true;
            L5:
                return false;
            }

            public boolean hasReceiverType() {
                if ((this.bitField0_ & 64) != 64) goto L5;
                return true;
            L5:
                return false;
            }

            public boolean hasReturnType() {
                if ((this.bitField0_ & 8) != 8) goto L5;
                return true;
            L5:
                return false;
            }

            public boolean hasSetterValueParameter() {
                if ((this.bitField0_ & 1024) != 1024) goto L5;
                return true;
            L5:
                return false;
            }

            private Builder() {
                this.flags_ = 518;
                this.oldFlags_ = 2054;
                this.returnType_ = Type.getDefaultInstance();
                this.typeParameter_ = Collections.emptyList();
                this.receiverType_ = Type.getDefaultInstance();
                this.contextReceiverType_ = Collections.emptyList();
                this.contextReceiverTypeId_ = Collections.emptyList();
                this.setterValueParameter_ = ValueParameter.getDefaultInstance();
                this.versionRequirement_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            public static /* synthetic */ Builder access$16000() {
                return create();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Property build() {
                Property r100 = buildPartial();
                if (r100.isInitialized() == false) goto L6;
                return r100;
            L6:
                throw AbstractMessageLite.Builder.newUninitializedMessageException(r100);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public Property getDefaultInstanceForType() {
                return Property.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                if (hasName() == true) goto L6;
                return false;
            L6:
                if (hasReturnType() == true) goto L8;
            L10:
                int r100 = 0;
            L12:
                if (r100 >= getTypeParameterCount()) goto L18;
                if (getTypeParameter(r100).isInitialized() == false) goto L15;
                r100 = r100 + 1;
                goto L12
            L15:
                return false;
            L18:
                if (hasReceiverType() == true) goto L20;
            L22:
                int r101 = 0;
            L24:
                if (r101 >= getContextReceiverTypeCount()) goto L30;
                if (getContextReceiverType(r101).isInitialized() == false) goto L27;
                r101 = r101 + 1;
                goto L24
            L27:
                return false;
            L30:
                if (hasSetterValueParameter() == false) goto L35;
                if (getSetterValueParameter().isInitialized() == true) goto L35;
                return false;
            L35:
                if (extensionsAreInitialized() == true) goto L37;
                return false;
            L37:
                return true;
            L20:
                if (getReceiverType().isInitialized() == true) goto L22;
                return false;
            L8:
                if (getReturnType().isInitialized() == true) goto L10;
                return false;
            }

            public Type getReceiverType() {
                return this.receiverType_;
            }

            public Type getReturnType() {
                return this.returnType_;
            }

            public ValueParameter getSetterValueParameter() {
                return this.setterValueParameter_;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo10730clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.ExtendableBuilder clone() {
                return clone();
            }

            public Type getContextReceiverType(int r100) {
                return (Type) ListProtector.get(this.contextReceiverType_, r100);
            }

            public TypeParameter getTypeParameter(int r100) {
                return (TypeParameter) ListProtector.get(this.typeParameter_, r100);
            }

            public Builder mergeFrom(Property r100) {
                if (r100 != Property.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r100.hasFlags() == false) goto L9;
                setFlags(r100.getFlags());
            L9:
                if (r100.hasOldFlags() == false) goto L12;
                setOldFlags(r100.getOldFlags());
            L12:
                if (r100.hasName() == false) goto L15;
                setName(r100.getName());
            L15:
                if (r100.hasReturnType() == false) goto L18;
                mergeReturnType(r100.getReturnType());
            L18:
                if (r100.hasReturnTypeId() == false) goto L21;
                setReturnTypeId(r100.getReturnTypeId());
            L21:
                if (Property.access$16700(r100).isEmpty() == true) goto L27;
                if (this.typeParameter_.isEmpty() == false) goto L25;
                this.typeParameter_ = Property.access$16700(r100);
                this.bitField0_ &= -33;
                goto L27
            L25:
                ensureTypeParameterIsMutable();
                this.typeParameter_.addAll(Property.access$16700(r100));
            L27:
                if (r100.hasReceiverType() == false) goto L30;
                mergeReceiverType(r100.getReceiverType());
            L30:
                if (r100.hasReceiverTypeId() == false) goto L33;
                setReceiverTypeId(r100.getReceiverTypeId());
            L33:
                if (Property.access$17000(r100).isEmpty() == true) goto L39;
                if (this.contextReceiverType_.isEmpty() == false) goto L37;
                this.contextReceiverType_ = Property.access$17000(r100);
                this.bitField0_ &= -257;
                goto L39
            L37:
                ensureContextReceiverTypeIsMutable();
                this.contextReceiverType_.addAll(Property.access$17000(r100));
            L39:
                if (Property.access$17100(r100).isEmpty() == true) goto L45;
                if (this.contextReceiverTypeId_.isEmpty() == false) goto L43;
                this.contextReceiverTypeId_ = Property.access$17100(r100);
                this.bitField0_ &= NetError.ERR_TTNET_FT_INVALID_STREAM;
                goto L45
            L43:
                ensureContextReceiverTypeIdIsMutable();
                this.contextReceiverTypeId_.addAll(Property.access$17100(r100));
            L45:
                if (r100.hasSetterValueParameter() == false) goto L48;
                mergeSetterValueParameter(r100.getSetterValueParameter());
            L48:
                if (r100.hasGetterFlags() == false) goto L51;
                setGetterFlags(r100.getGetterFlags());
            L51:
                if (r100.hasSetterFlags() == false) goto L54;
                setSetterFlags(r100.getSetterFlags());
            L54:
                if (Property.access$17500(r100).isEmpty() == false) goto L56;
            L59:
                mergeExtensionFields(r100);
                setUnknownFields(getUnknownFields().concat(Property.access$17700(r100)));
                return this;
            L56:
                if (this.versionRequirement_.isEmpty() == false) goto L58;
                this.versionRequirement_ = Property.access$17500(r100);
                this.bitField0_ &= -8193;
                goto L59
            L58:
                ensureVersionRequirementIsMutable();
                this.versionRequirement_.addAll(Property.access$17500(r100));
                goto L59
            }

            public Builder mergeReceiverType(Type r100) {
                if ((this.bitField0_ & 64) == 64) goto L5;
            L7:
                this.receiverType_ = r100;
            L8:
                this.bitField0_ |= 64;
                return this;
            L5:
                if (this.receiverType_ == Type.getDefaultInstance()) goto L7;
                this.receiverType_ = Type.newBuilder(this.receiverType_).mergeFrom(r100).buildPartial();
                goto L8
            }

            public Builder mergeReturnType(Type r100) {
                if ((this.bitField0_ & 8) == 8) goto L5;
            L7:
                this.returnType_ = r100;
            L8:
                this.bitField0_ |= 8;
                return this;
            L5:
                if (this.returnType_ == Type.getDefaultInstance()) goto L7;
                this.returnType_ = Type.newBuilder(this.returnType_).mergeFrom(r100).buildPartial();
                goto L8
            }

            public Builder mergeSetterValueParameter(ValueParameter r100) {
                if ((this.bitField0_ & 1024) == 1024) goto L5;
            L7:
                this.setterValueParameter_ = r100;
            L8:
                this.bitField0_ |= 1024;
                return this;
            L5:
                if (this.setterValueParameter_ == ValueParameter.getDefaultInstance()) goto L7;
                this.setterValueParameter_ = ValueParameter.newBuilder(this.setterValueParameter_).mergeFrom(r100).buildPartial();
                goto L8
            }

            public Builder setFlags(int r100) {
                this.bitField0_ |= 1;
                this.flags_ = r100;
                return this;
            }

            public Builder setGetterFlags(int r100) {
                this.bitField0_ |= 2048;
                this.getterFlags_ = r100;
                return this;
            }

            public Builder setName(int r100) {
                this.bitField0_ |= 4;
                this.name_ = r100;
                return this;
            }

            public Builder setOldFlags(int r100) {
                this.bitField0_ |= 2;
                this.oldFlags_ = r100;
                return this;
            }

            public Builder setReceiverTypeId(int r100) {
                this.bitField0_ |= 128;
                this.receiverTypeId_ = r100;
                return this;
            }

            public Builder setReturnTypeId(int r100) {
                this.bitField0_ |= 16;
                this.returnTypeId_ = r100;
                return this;
            }

            public Builder setSetterFlags(int r100) {
                this.bitField0_ |= 4096;
                this.setterFlags_ = r100;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r100) {
                return mergeFrom((Property) r100);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
                Property r102 = null;
                Property r103 = Property.PARSER.parsePartialFrom(r100, r101);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r103 == null) goto L6;
                mergeFrom(r103);
            L6:
                return this;
            L9:
                e = move-exception;
                Property r104 = (Property) e.getUnfinishedMessage();     // Catch: Throwable -> L7
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
            Property r100 = new Property(true);
            defaultInstance = r100;
            r100.initFields();
        }

        private void initFields() {
            this.flags_ = 518;
            this.oldFlags_ = 2054;
            this.name_ = 0;
            this.returnType_ = Type.getDefaultInstance();
            this.returnTypeId_ = 0;
            this.typeParameter_ = Collections.emptyList();
            this.receiverType_ = Type.getDefaultInstance();
            this.receiverTypeId_ = 0;
            this.contextReceiverType_ = Collections.emptyList();
            this.contextReceiverTypeId_ = Collections.emptyList();
            this.setterValueParameter_ = ValueParameter.getDefaultInstance();
            this.getterFlags_ = 0;
            this.setterFlags_ = 0;
            this.versionRequirement_ = Collections.emptyList();
        }

        public int getContextReceiverTypeCount() {
            return this.contextReceiverType_.size();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int r100 = this.memoizedSerializedSize;
            if (r100 == (-1)) goto L5;
            return r100;
        L5:
            int r101 = 0;
            if ((this.bitField0_ & 2) != 2) goto L8;
            int r102 = CodedOutputStream.computeInt32Size(1, this.oldFlags_) + 0;
        L10:
            if ((this.bitField0_ & 4) != 4) goto L13;
            r102 = r102 + CodedOutputStream.computeInt32Size(2, this.name_);
        L13:
            if ((this.bitField0_ & 8) != 8) goto L15;
            r102 = r102 + CodedOutputStream.computeMessageSize(3, this.returnType_);
        L15:
            int r103 = 0;
        L17:
            if (r103 >= this.typeParameter_.size()) goto L20;
            r102 = r102 + CodedOutputStream.computeMessageSize(4, (MessageLite) ListProtector.get(this.typeParameter_, r103));
            r103 = r103 + 1;
            goto L17
        L20:
            if ((this.bitField0_ & 32) != 32) goto L23;
            r102 = r102 + CodedOutputStream.computeMessageSize(5, this.receiverType_);
        L23:
            if ((this.bitField0_ & 128) != 128) goto L26;
            r102 = r102 + CodedOutputStream.computeMessageSize(6, this.setterValueParameter_);
        L26:
            if ((this.bitField0_ & 256) != 256) goto L29;
            r102 = r102 + CodedOutputStream.computeInt32Size(7, this.getterFlags_);
        L29:
            if ((this.bitField0_ & 512) != 512) goto L32;
            r102 = r102 + CodedOutputStream.computeInt32Size(8, this.setterFlags_);
        L32:
            if ((this.bitField0_ & 16) != 16) goto L35;
            r102 = r102 + CodedOutputStream.computeInt32Size(9, this.returnTypeId_);
        L35:
            if ((this.bitField0_ & 64) != 64) goto L38;
            r102 = r102 + CodedOutputStream.computeInt32Size(10, this.receiverTypeId_);
        L38:
            if ((this.bitField0_ & 1) != 1) goto L40;
            r102 = r102 + CodedOutputStream.computeInt32Size(11, this.flags_);
        L40:
            int r104 = 0;
        L42:
            if (r104 >= this.contextReceiverType_.size()) goto L44;
            r102 = r102 + CodedOutputStream.computeMessageSize(12, (MessageLite) ListProtector.get(this.contextReceiverType_, r104));
            r104 = r104 + 1;
            goto L42
        L44:
            int r105 = 0;
            int r106 = 0;
        L46:
            if (r105 >= this.contextReceiverTypeId_.size()) goto L48;
            r106 = r106 + CodedOutputStream.computeInt32SizeNoTag(((Integer) ListProtector.get(this.contextReceiverTypeId_, r105)).intValue());
            r105 = r105 + 1;
            goto L46
        L48:
            int r107 = r102 + r106;
            if (getContextReceiverTypeIdList().isEmpty() == true) goto L51;
            r107 = (r107 + 1) + CodedOutputStream.computeInt32SizeNoTag(r106);
        L51:
            this.contextReceiverTypeIdMemoizedSerializedSize = r106;
            int r108 = 0;
        L53:
            if (r101 >= this.versionRequirement_.size()) goto L55;
            r108 = r108 + CodedOutputStream.computeInt32SizeNoTag(((Integer) ListProtector.get(this.versionRequirement_, r101)).intValue());
            r101 = r101 + 1;
            goto L53
        L55:
            int r109 = (((r107 + r108) + (getVersionRequirementList().size() * 2)) + extensionsSerializedSize()) + this.unknownFields.size();
            this.memoizedSerializedSize = r109;
            return r109;
        L8:
            r102 = 0;
            goto L10
        }

        public int getTypeParameterCount() {
            return this.typeParameter_.size();
        }

        public boolean hasFlags() {
            if ((this.bitField0_ & 1) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        public boolean hasGetterFlags() {
            if ((this.bitField0_ & 256) != 256) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasName() {
            if ((this.bitField0_ & 4) != 4) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasOldFlags() {
            if ((this.bitField0_ & 2) != 2) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasReceiverType() {
            if ((this.bitField0_ & 32) != 32) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasReceiverTypeId() {
            if ((this.bitField0_ & 64) != 64) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasReturnType() {
            if ((this.bitField0_ & 8) != 8) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasReturnTypeId() {
            if ((this.bitField0_ & 16) != 16) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasSetterFlags() {
            if ((this.bitField0_ & 512) != 512) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasSetterValueParameter() {
            if ((this.bitField0_ & 128) != 128) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte r100 = this.memoizedIsInitialized;
            if (r100 != 1) goto L6;
            return true;
        L6:
            if (r100 != 0) goto L9;
            return false;
        L9:
            if (hasName() == true) goto L13;
            this.memoizedIsInitialized = 0;
            return false;
        L13:
            if (hasReturnType() == true) goto L15;
        L18:
            int r101 = 0;
        L20:
            if (r101 >= getTypeParameterCount()) goto L27;
            if (getTypeParameter(r101).isInitialized() == false) goto L23;
            r101 = r101 + 1;
            goto L20
        L23:
            this.memoizedIsInitialized = 0;
            return false;
        L27:
            if (hasReceiverType() == true) goto L29;
        L32:
            int r102 = 0;
        L34:
            if (r102 >= getContextReceiverTypeCount()) goto L41;
            if (getContextReceiverType(r102).isInitialized() == false) goto L37;
            r102 = r102 + 1;
            goto L34
        L37:
            this.memoizedIsInitialized = 0;
            return false;
        L41:
            if (hasSetterValueParameter() == false) goto L47;
            if (getSetterValueParameter().isInitialized() == true) goto L47;
            this.memoizedIsInitialized = 0;
            return false;
        L47:
            if (extensionsAreInitialized() == true) goto L50;
            this.memoizedIsInitialized = 0;
            return false;
        L50:
            this.memoizedIsInitialized = 1;
            return true;
        L29:
            if (getReceiverType().isInitialized() == true) goto L32;
            this.memoizedIsInitialized = 0;
            return false;
        L15:
            if (getReturnType().isInitialized() == true) goto L18;
            this.memoizedIsInitialized = 0;
            return false;
        }

        public static Builder newBuilder() {
            return Builder.access$16000();
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

        public static Property getDefaultInstance() {
            return defaultInstance;
        }

        public List<Integer> getContextReceiverTypeIdList() {
            return this.contextReceiverTypeId_;
        }

        public List<Type> getContextReceiverTypeList() {
            return this.contextReceiverType_;
        }

        public int getFlags() {
            return this.flags_;
        }

        public int getGetterFlags() {
            return this.getterFlags_;
        }

        public int getName() {
            return this.name_;
        }

        public int getOldFlags() {
            return this.oldFlags_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<Property> getParserForType() {
            return PARSER;
        }

        public Type getReceiverType() {
            return this.receiverType_;
        }

        public int getReceiverTypeId() {
            return this.receiverTypeId_;
        }

        public Type getReturnType() {
            return this.returnType_;
        }

        public int getReturnTypeId() {
            return this.returnTypeId_;
        }

        public int getSetterFlags() {
            return this.setterFlags_;
        }

        public ValueParameter getSetterValueParameter() {
            return this.setterValueParameter_;
        }

        public List<TypeParameter> getTypeParameterList() {
            return this.typeParameter_;
        }

        public List<Integer> getVersionRequirementList() {
            return this.versionRequirement_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public Property getDefaultInstanceForType() {
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

        private Property(GeneratedMessageLite.ExtendableBuilder<Property, ?> r100) {
            super(r100);
            this.contextReceiverTypeIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r100.getUnknownFields();
        }

        public static /* synthetic */ List access$16700(Property r100) {
            return r100.typeParameter_;
        }

        public static /* synthetic */ List access$17000(Property r100) {
            return r100.contextReceiverType_;
        }

        public static /* synthetic */ List access$17100(Property r100) {
            return r100.contextReceiverTypeId_;
        }

        public static /* synthetic */ List access$17500(Property r100) {
            return r100.versionRequirement_;
        }

        public static /* synthetic */ ByteString access$17700(Property r100) {
            return r100.unknownFields;
        }

        public static Builder newBuilder(Property r100) {
            return newBuilder().mergeFrom(r100);
        }

        public Type getContextReceiverType(int r100) {
            return (Type) ListProtector.get(this.contextReceiverType_, r100);
        }

        public TypeParameter getTypeParameter(int r100) {
            return (TypeParameter) ListProtector.get(this.typeParameter_, r100);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r100) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter r101 = newExtensionWriter();
            if ((this.bitField0_ & 2) != 2) goto L6;
            r100.writeInt32(1, this.oldFlags_);
        L6:
            if ((this.bitField0_ & 4) != 4) goto L9;
            r100.writeInt32(2, this.name_);
        L9:
            if ((this.bitField0_ & 8) != 8) goto L11;
            r100.writeMessage(3, this.returnType_);
        L11:
            int r102 = 0;
            int r103 = 0;
        L13:
            if (r103 >= this.typeParameter_.size()) goto L16;
            r100.writeMessage(4, (MessageLite) ListProtector.get(this.typeParameter_, r103));
            r103 = r103 + 1;
            goto L13
        L16:
            if ((this.bitField0_ & 32) != 32) goto L19;
            r100.writeMessage(5, this.receiverType_);
        L19:
            if ((this.bitField0_ & 128) != 128) goto L22;
            r100.writeMessage(6, this.setterValueParameter_);
        L22:
            if ((this.bitField0_ & 256) != 256) goto L25;
            r100.writeInt32(7, this.getterFlags_);
        L25:
            if ((this.bitField0_ & 512) != 512) goto L28;
            r100.writeInt32(8, this.setterFlags_);
        L28:
            if ((this.bitField0_ & 16) != 16) goto L31;
            r100.writeInt32(9, this.returnTypeId_);
        L31:
            if ((this.bitField0_ & 64) != 64) goto L34;
            r100.writeInt32(10, this.receiverTypeId_);
        L34:
            if ((this.bitField0_ & 1) != 1) goto L36;
            r100.writeInt32(11, this.flags_);
        L36:
            int r104 = 0;
        L38:
            if (r104 >= this.contextReceiverType_.size()) goto L41;
            r100.writeMessage(12, (MessageLite) ListProtector.get(this.contextReceiverType_, r104));
            r104 = r104 + 1;
            goto L38
        L41:
            if (getContextReceiverTypeIdList().size() <= 0) goto L43;
            r100.writeRawVarint32(106);
            r100.writeRawVarint32(this.contextReceiverTypeIdMemoizedSerializedSize);
        L43:
            int r105 = 0;
        L45:
            if (r105 >= this.contextReceiverTypeId_.size()) goto L48;
            r100.writeInt32NoTag(((Integer) ListProtector.get(this.contextReceiverTypeId_, r105)).intValue());
            r105 = r105 + 1;
        L48:
            if (r102 >= this.versionRequirement_.size()) goto L50;
            r100.writeInt32(31, ((Integer) ListProtector.get(this.versionRequirement_, r102)).intValue());
            r102 = r102 + 1;
            goto L48
        L50:
            r101.writeUntil(19000, r100);
            r100.writeRawBytes(this.unknownFields);
        }

        private Property(boolean r100) {
            this.contextReceiverTypeIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        private Property(CodedInputStream r110, ExtensionRegistryLite r111) throws InvalidProtocolBufferException {
            this.contextReceiverTypeIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r100 = ByteString.newOutput();
            CodedOutputStream r101 = CodedOutputStream.newInstance(r100, 1);
            boolean r102 = false;
            int r103 = 0;
        L4:
            if (r102 == true) goto L102;
            int r104 = r110.readTag();     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            Type.Builder r112 = null;
            ValueParameter.Builder r113 = null;
            Type.Builder r114 = null;
            switch(r104) {
                case 0: goto L71;
                case 8: goto L69;
                case 16: goto L68;
                case 26: goto L62;
                case 34: goto L58;
                case 42: goto L51;
                case 50: goto L44;
                case 56: goto L42;
                case 64: goto L41;
                case 72: goto L40;
                case 80: goto L39;
                case 88: goto L38;
                case 98: goto L35;
                case 104: goto L31;
                case 106: goto L21;
                case 248: goto L18;
                case 250: goto L8;
                default: goto L72;
            };     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
        L8:
            int r105 = r110.pushLimit(r110.readRawVarint32());     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            if ((r103 & 8192) == 8192) goto L14;
            if (r110.getBytesUntilLimit() <= 0) goto L14;
            this.versionRequirement_ = new ArrayList();     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            r103 = r103 | 8192;     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
        L14:
            if (r110.getBytesUntilLimit() <= 0) goto L16;
            this.versionRequirement_.add(Integer.valueOf(r110.readInt32()));     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            goto L14
        L16:
            r110.popLimit(r105);     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            goto L4
        L18:
            if ((r103 & 8192) == 8192) goto L20;
            this.versionRequirement_ = new ArrayList();     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            r103 = r103 | 8192;     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
        L20:
            this.versionRequirement_.add(Integer.valueOf(r110.readInt32()));     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            goto L4
        L21:
            int r106 = r110.pushLimit(r110.readRawVarint32());     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            if ((r103 & 512) == 512) goto L27;
            if (r110.getBytesUntilLimit() <= 0) goto L27;
            this.contextReceiverTypeId_ = new ArrayList();     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            r103 = r103 | 512;     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
        L27:
            if (r110.getBytesUntilLimit() <= 0) goto L29;
            this.contextReceiverTypeId_.add(Integer.valueOf(r110.readInt32()));     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            goto L27
        L29:
            r110.popLimit(r106);     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            goto L4
        L31:
            if ((r103 & 512) == 512) goto L33;
            this.contextReceiverTypeId_ = new ArrayList();     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            r103 = r103 | 512;     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
        L33:
            this.contextReceiverTypeId_.add(Integer.valueOf(r110.readInt32()));     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            goto L4
        L35:
            if ((r103 & 256) == 256) goto L37;
            this.contextReceiverType_ = new ArrayList();     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            r103 = r103 | 256;     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
        L37:
            this.contextReceiverType_.add((Type) r110.readMessage(Type.PARSER, r111));     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            goto L4
        L38:
            this.bitField0_ |= 1;     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            this.flags_ = r110.readInt32();     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            goto L4
        L39:
            this.bitField0_ |= 64;     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            this.receiverTypeId_ = r110.readInt32();     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            goto L4
        L40:
            this.bitField0_ |= 16;     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            this.returnTypeId_ = r110.readInt32();     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            goto L4
        L41:
            this.bitField0_ |= 512;     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            this.setterFlags_ = r110.readInt32();     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            goto L4
        L42:
            this.bitField0_ |= 256;     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            this.getterFlags_ = r110.readInt32();     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            goto L4
        L44:
            if ((this.bitField0_ & 128) != 128) goto L46;
            r113 = this.setterValueParameter_.toBuilder();     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
        L46:
            ValueParameter r107 = (ValueParameter) r110.readMessage(ValueParameter.PARSER, r111);     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            this.setterValueParameter_ = r107;     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            if (r113 == null) goto L49;
            r113.mergeFrom(r107);     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            this.setterValueParameter_ = r113.buildPartial();     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
        L49:
            this.bitField0_ |= 128;     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            goto L4
        L51:
            if ((this.bitField0_ & 32) != 32) goto L53;
            r114 = this.receiverType_.toBuilder();     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
        L53:
            Type r108 = (Type) r110.readMessage(Type.PARSER, r111);     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            this.receiverType_ = r108;     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            if (r114 == null) goto L56;
            r114.mergeFrom(r108);     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            this.receiverType_ = r114.buildPartial();     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
        L56:
            this.bitField0_ |= 32;     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            goto L4
        L58:
            if ((r103 & 32) == 32) goto L60;
            this.typeParameter_ = new ArrayList();     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            r103 = r103 | 32;     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
        L60:
            this.typeParameter_.add((TypeParameter) r110.readMessage(TypeParameter.PARSER, r111));     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            goto L4
        L62:
            if ((this.bitField0_ & 8) != 8) goto L64;
            r112 = this.returnType_.toBuilder();     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
        L64:
            Type r109 = (Type) r110.readMessage(Type.PARSER, r111);     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            this.returnType_ = r109;     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            if (r112 == null) goto L67;
            r112.mergeFrom(r109);     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            this.returnType_ = r112.buildPartial();     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
        L67:
            this.bitField0_ |= 8;     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            goto L4
        L68:
            this.bitField0_ |= 4;     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            this.name_ = r110.readInt32();     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            goto L4
        L69:
            this.bitField0_ |= 2;     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
            this.oldFlags_ = r110.readInt32();     // Catch: Throwable -> L74 IOException -> L76 InvalidProtocolBufferException -> L79
        L71:
            r102 = true;
            goto L4
        L72:
            if (parseUnknownField(r110, r101, r111, r104) == true) goto L4;
        L74:
            th = move-exception;
            if ((r103 & 32) != 32) goto L86;
            this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
        L86:
            if ((r103 & 256) != 256) goto L89;
            this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
        L89:
            if ((r103 & 512) != 512) goto L92;
            this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
        L92:
            if ((r103 & 8192) != 8192) goto L124;
            this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
        L124:
            r101.flush();     // Catch: IOException -> L121 Throwable -> L96
        L96:
            th = move-exception;
            this.unknownFields = r100.toByteString();
            throw th;
        L95:
            this.unknownFields = r100.toByteString();
            makeExtensionsImmutable();
            throw th;
        L79:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L74
        L76:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L74
        L102:
            if ((r103 & 32) != 32) goto L105;
            this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
        L105:
            if ((r103 & 256) != 256) goto L108;
            this.contextReceiverType_ = Collections.unmodifiableList(this.contextReceiverType_);
        L108:
            if ((r103 & 512) != 512) goto L111;
            this.contextReceiverTypeId_ = Collections.unmodifiableList(this.contextReceiverTypeId_);
        L111:
            if ((r103 & 8192) != 8192) goto L126;
            this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
        L126:
            r101.flush();     // Catch: IOException -> L120 Throwable -> L115
        L115:
            th = move-exception;
            this.unknownFields = r100.toByteString();
            throw th;
        L114:
            this.unknownFields = r100.toByteString();
            makeExtensionsImmutable();
        }

        public static /* synthetic */ int access$16202(Property r100, int r101) {
            r100.flags_ = r101;
            return r101;
        }

        public static /* synthetic */ int access$16302(Property r100, int r101) {
            r100.oldFlags_ = r101;
            return r101;
        }

        public static /* synthetic */ int access$16402(Property r100, int r101) {
            r100.name_ = r101;
            return r101;
        }

        public static /* synthetic */ Type access$16502(Property r100, Type r101) {
            r100.returnType_ = r101;
            return r101;
        }

        public static /* synthetic */ int access$16602(Property r100, int r101) {
            r100.returnTypeId_ = r101;
            return r101;
        }

        public static /* synthetic */ List access$16702(Property r100, List r101) {
            r100.typeParameter_ = r101;
            return r101;
        }

        public static /* synthetic */ Type access$16802(Property r100, Type r101) {
            r100.receiverType_ = r101;
            return r101;
        }

        public static /* synthetic */ int access$16902(Property r100, int r101) {
            r100.receiverTypeId_ = r101;
            return r101;
        }

        public static /* synthetic */ List access$17002(Property r100, List r101) {
            r100.contextReceiverType_ = r101;
            return r101;
        }

        public static /* synthetic */ List access$17102(Property r100, List r101) {
            r100.contextReceiverTypeId_ = r101;
            return r101;
        }

        public static /* synthetic */ ValueParameter access$17202(Property r100, ValueParameter r101) {
            r100.setterValueParameter_ = r101;
            return r101;
        }

        public static /* synthetic */ int access$17302(Property r100, int r101) {
            r100.getterFlags_ = r101;
            return r101;
        }

        public static /* synthetic */ int access$17402(Property r100, int r101) {
            r100.setterFlags_ = r101;
            return r101;
        }

        public static /* synthetic */ List access$17502(Property r100, List r101) {
            r100.versionRequirement_ = r101;
            return r101;
        }

        public static /* synthetic */ int access$17602(Property r100, int r101) {
            r100.bitField0_ = r101;
            return r101;
        }

        public /* synthetic */ Property(GeneratedMessageLite.ExtendableBuilder r100, AnonymousClass1 r101) {
            this(r100);
        }

        public /* synthetic */ Property(CodedInputStream r100, ExtensionRegistryLite r101, AnonymousClass1 r102) throws InvalidProtocolBufferException {
            this(r100, r101);
        }
    }

    /* JADX INFO: loaded from: classes5.dex */
    public interface PropertyOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder {
    }

    /* JADX INFO: loaded from: classes5.dex */
    public static final class QualifiedNameTable extends GeneratedMessageLite implements QualifiedNameTableOrBuilder {
        public static Parser<QualifiedNameTable> PARSER;
        private static final QualifiedNameTable defaultInstance = null;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<QualifiedName> qualifiedName_;
        private final ByteString unknownFields;

        /* JADX INFO: loaded from: classes42.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<QualifiedNameTable, Builder> implements QualifiedNameTableOrBuilder {
            private int bitField0_;
            private List<QualifiedName> qualifiedName_;

            private void maybeForceBuilderInitialization() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                int r100 = 0;
            L4:
                if (r100 >= getQualifiedNameCount()) goto L9;
                if (getQualifiedName(r100).isInitialized() == false) goto L7;
                r100 = r100 + 1;
                goto L4
            L7:
                return false;
            L9:
                return true;
            }

            private static Builder create() {
                return new Builder();
            }

            private void ensureQualifiedNameIsMutable() {
                if ((this.bitField0_ & 1) == 1) goto L6;
                this.qualifiedName_ = new ArrayList(this.qualifiedName_);
                this.bitField0_ |= 1;
                return;
            }

            public QualifiedNameTable buildPartial() {
                QualifiedNameTable r100 = new QualifiedNameTable(this, null);
                if ((this.bitField0_ & 1) != 1) goto L5;
                this.qualifiedName_ = Collections.unmodifiableList(this.qualifiedName_);
                this.bitField0_ &= -2;
            L5:
                QualifiedNameTable.access$1602(r100, this.qualifiedName_);
                return r100;
            }

            public int getQualifiedNameCount() {
                return this.qualifiedName_.size();
            }

            private Builder() {
                this.qualifiedName_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            public static /* synthetic */ Builder access$1400() {
                return create();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public QualifiedNameTable build() {
                QualifiedNameTable r100 = buildPartial();
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
            public QualifiedNameTable getDefaultInstanceForType() {
                return QualifiedNameTable.getDefaultInstance();
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

            public QualifiedName getQualifiedName(int r100) {
                return (QualifiedName) ListProtector.get(this.qualifiedName_, r100);
            }

            public Builder mergeFrom(QualifiedNameTable r100) {
                if (r100 != QualifiedNameTable.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (QualifiedNameTable.access$1600(r100).isEmpty() == false) goto L8;
            L11:
                setUnknownFields(getUnknownFields().concat(QualifiedNameTable.access$1700(r100)));
                return this;
            L8:
                if (this.qualifiedName_.isEmpty() == false) goto L10;
                this.qualifiedName_ = QualifiedNameTable.access$1600(r100);
                this.bitField0_ &= -2;
                goto L11
            L10:
                ensureQualifiedNameIsMutable();
                this.qualifiedName_.addAll(QualifiedNameTable.access$1600(r100));
                goto L11
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r100) {
                return mergeFrom((QualifiedNameTable) r100);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
                QualifiedNameTable r102 = null;
                QualifiedNameTable r103 = QualifiedNameTable.PARSER.parsePartialFrom(r100, r101);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r103 == null) goto L6;
                mergeFrom(r103);
            L6:
                return this;
            L9:
                e = move-exception;
                QualifiedNameTable r104 = (QualifiedNameTable) e.getUnfinishedMessage();     // Catch: Throwable -> L7
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

        public static final class QualifiedName extends GeneratedMessageLite implements QualifiedNameOrBuilder {
            public static Parser<QualifiedName> PARSER;
            private static final QualifiedName defaultInstance = null;
            private int bitField0_;
            private Kind kind_;
            private byte memoizedIsInitialized;
            private int memoizedSerializedSize;
            private int parentQualifiedName_;
            private int shortName_;
            private final ByteString unknownFields;

            /* JADX INFO: loaded from: classes42.dex */
            public static final class Builder extends GeneratedMessageLite.Builder<QualifiedName, Builder> implements QualifiedNameOrBuilder {
                private int bitField0_;
                private Kind kind_;
                private int parentQualifiedName_;
                private int shortName_;

                private void maybeForceBuilderInitialization() {
                }

                private static Builder create() {
                    return new Builder();
                }

                public QualifiedName buildPartial() {
                    QualifiedName r100 = new QualifiedName(this, null);
                    int r101 = this.bitField0_;
                    int r102 = 1;
                    if ((r101 & 1) == 1) goto L6;
                    r102 = 0;
                L6:
                    QualifiedName.access$902(r100, this.parentQualifiedName_);
                    if ((r101 & 2) != 2) goto L9;
                    r102 = r102 | 2;
                L9:
                    QualifiedName.access$1002(r100, this.shortName_);
                    if ((r101 & 4) != 4) goto L12;
                    r102 = r102 | 4;
                L12:
                    QualifiedName.access$1102(r100, this.kind_);
                    QualifiedName.access$1202(r100, r102);
                    return r100;
                }

                public boolean hasShortName() {
                    if ((this.bitField0_ & 2) != 2) goto L5;
                    return true;
                L5:
                    return false;
                }

                private Builder() {
                    this.parentQualifiedName_ = -1;
                    this.kind_ = Kind.PACKAGE;
                    maybeForceBuilderInitialization();
                }

                public static /* synthetic */ Builder access$700() {
                    return create();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                public QualifiedName build() {
                    QualifiedName r100 = buildPartial();
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
                public QualifiedName getDefaultInstanceForType() {
                    return QualifiedName.getDefaultInstance();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                public final boolean isInitialized() {
                    if (hasShortName() == true) goto L6;
                    return false;
                L6:
                    return true;
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

                public Builder mergeFrom(QualifiedName r100) {
                    if (r100 != QualifiedName.getDefaultInstance()) goto L6;
                    return this;
                L6:
                    if (r100.hasParentQualifiedName() == false) goto L9;
                    setParentQualifiedName(r100.getParentQualifiedName());
                L9:
                    if (r100.hasShortName() == false) goto L12;
                    setShortName(r100.getShortName());
                L12:
                    if (r100.hasKind() == false) goto L14;
                    setKind(r100.getKind());
                L14:
                    setUnknownFields(getUnknownFields().concat(QualifiedName.access$1300(r100)));
                    return this;
                }

                public Builder setKind(Kind r100) {
                    if (r100 == null) goto L6;
                    this.bitField0_ |= 4;
                    this.kind_ = r100;
                    return this;
                L6:
                    throw null;
                }

                public Builder setParentQualifiedName(int r100) {
                    this.bitField0_ |= 1;
                    this.parentQualifiedName_ = r100;
                    return this;
                }

                public Builder setShortName(int r100) {
                    this.bitField0_ |= 2;
                    this.shortName_ = r100;
                    return this;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
                public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r100) {
                    return mergeFrom((QualifiedName) r100);
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                public Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
                    QualifiedName r102 = null;
                    QualifiedName r103 = QualifiedName.PARSER.parsePartialFrom(r100, r101);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                    if (r103 == null) goto L6;
                    mergeFrom(r103);
                L6:
                    return this;
                L9:
                    e = move-exception;
                    QualifiedName r104 = (QualifiedName) e.getUnfinishedMessage();     // Catch: Throwable -> L7
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

            public static final enum Kind extends Enum<Kind> implements Internal.EnumLite {
                private static final /* synthetic */ Kind[] $VALUES = null;
                public static final Kind CLASS = null;
                public static final Kind LOCAL = null;
                public static final Kind PACKAGE = null;
                private static Internal.EnumLiteMap<Kind> internalValueMap;
                private final int value;

                static {
                    Kind r100 = new Kind("CLASS", 0, 0, 0);
                    CLASS = r100;
                    Kind r101 = new Kind("PACKAGE", 1, 1, 1);
                    PACKAGE = r101;
                    Kind r102 = new Kind(AccountType.LOCAL, 2, 2, 2);
                    LOCAL = r102;
                    $VALUES = new Kind[]{r100, r101, r102};
                    internalValueMap = new AnonymousClass1();
                }

                public static Kind[] values() {
                    return (Kind[]) $VALUES.clone();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
                public final int getNumber() {
                    return this.value;
                }

                public static Kind valueOf(int r100) {
                    if (r100 == 0) goto L14;
                    if (r100 == 1) goto L12;
                    if (r100 == 2) goto L10;
                    return null;
                L10:
                    return LOCAL;
                L12:
                    return PACKAGE;
                L14:
                    return CLASS;
                }

                public static Kind valueOf(String r100) {
                    return (Kind) a.a(Kind.class, r100);
                }

                private Kind(String r100, int r101, int r102, int r103) {
                    super(r100, r101);
                    this.value = r103;
                }
            }

            private void initFields() {
                this.parentQualifiedName_ = -1;
                this.shortName_ = 0;
                this.kind_ = Kind.PACKAGE;
            }

            static {
                PARSER = new AnonymousClass1();
                QualifiedName r100 = new QualifiedName(true);
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
                r101 = 0 + CodedOutputStream.computeInt32Size(1, this.parentQualifiedName_);
            L9:
                if ((this.bitField0_ & 2) != 2) goto L12;
                r101 = r101 + CodedOutputStream.computeInt32Size(2, this.shortName_);
            L12:
                if ((this.bitField0_ & 4) != 4) goto L14;
                r101 = r101 + CodedOutputStream.computeEnumSize(3, this.kind_.getNumber());
            L14:
                int r102 = r101 + this.unknownFields.size();
                this.memoizedSerializedSize = r102;
                return r102;
            }

            public boolean hasKind() {
                if ((this.bitField0_ & 4) != 4) goto L5;
                return true;
            L5:
                return false;
            }

            public boolean hasParentQualifiedName() {
                if ((this.bitField0_ & 1) == 1) goto L7;
                return false;
            L7:
                return true;
            }

            public boolean hasShortName() {
                if ((this.bitField0_ & 2) != 2) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                byte r100 = this.memoizedIsInitialized;
                if (r100 != 1) goto L6;
                return true;
            L6:
                if (r100 != 0) goto L9;
                return false;
            L9:
                if (hasShortName() == true) goto L12;
                this.memoizedIsInitialized = 0;
                return false;
            L12:
                this.memoizedIsInitialized = 1;
                return true;
            }

            public static Builder newBuilder() {
                return Builder.access$700();
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

            public static QualifiedName getDefaultInstance() {
                return defaultInstance;
            }

            public Kind getKind() {
                return this.kind_;
            }

            public int getParentQualifiedName() {
                return this.parentQualifiedName_;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public Parser<QualifiedName> getParserForType() {
                return PARSER;
            }

            public int getShortName() {
                return this.shortName_;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public QualifiedName getDefaultInstanceForType() {
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

            private QualifiedName(GeneratedMessageLite.Builder r100) {
                super(r100);
                this.memoizedIsInitialized = -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = r100.getUnknownFields();
            }

            public static /* synthetic */ ByteString access$1300(QualifiedName r100) {
                return r100.unknownFields;
            }

            public static Builder newBuilder(QualifiedName r100) {
                return newBuilder().mergeFrom(r100);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public void writeTo(CodedOutputStream r100) throws IOException {
                getSerializedSize();
                if ((this.bitField0_ & 1) != 1) goto L6;
                r100.writeInt32(1, this.parentQualifiedName_);
            L6:
                if ((this.bitField0_ & 2) != 2) goto L9;
                r100.writeInt32(2, this.shortName_);
            L9:
                if ((this.bitField0_ & 4) != 4) goto L11;
                r100.writeEnum(3, this.kind_.getNumber());
            L11:
                r100.writeRawBytes(this.unknownFields);
            }

            private QualifiedName(boolean r100) {
                this.memoizedIsInitialized = -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = ByteString.EMPTY;
            }

            private QualifiedName(CodedInputStream r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
                this.memoizedIsInitialized = -1;
                this.memoizedSerializedSize = -1;
                initFields();
                ByteString.Output r102 = ByteString.newOutput();
                CodedOutputStream r103 = CodedOutputStream.newInstance(r102, 1);
                boolean r104 = false;
            L3:
                if (r104 == true) goto L49;
                int r105 = r100.readTag();     // Catch: Throwable -> L23 IOException -> L25 InvalidProtocolBufferException -> L28
                if (r105 == 0) goto L22;
                if (r105 != 8) goto L9;
                this.bitField0_ |= 1;     // Catch: Throwable -> L23 IOException -> L25 InvalidProtocolBufferException -> L28
                this.parentQualifiedName_ = r100.readInt32();     // Catch: Throwable -> L23 IOException -> L25 InvalidProtocolBufferException -> L28
                goto L3
            L9:
                if (r105 != 16) goto L11;
                this.bitField0_ |= 2;     // Catch: Throwable -> L23 IOException -> L25 InvalidProtocolBufferException -> L28
                this.shortName_ = r100.readInt32();     // Catch: Throwable -> L23 IOException -> L25 InvalidProtocolBufferException -> L28
                goto L3
            L11:
                if (r105 != 24) goto L13;
                int r106 = r100.readEnum();     // Catch: Throwable -> L23 IOException -> L25 InvalidProtocolBufferException -> L28
                Kind r107 = Kind.valueOf(r106);     // Catch: Throwable -> L23 IOException -> L25 InvalidProtocolBufferException -> L28
                if (r107 == null) goto L17;
                this.bitField0_ |= 4;     // Catch: Throwable -> L23 IOException -> L25 InvalidProtocolBufferException -> L28
                this.kind_ = r107;     // Catch: Throwable -> L23 IOException -> L25 InvalidProtocolBufferException -> L28
                goto L3
            L17:
                r103.writeRawVarint32(r105);     // Catch: Throwable -> L23 IOException -> L25 InvalidProtocolBufferException -> L28
                r103.writeRawVarint32(r106);     // Catch: Throwable -> L23 IOException -> L25 InvalidProtocolBufferException -> L28
                goto L3
            L13:
                if (parseUnknownField(r100, r103, r101, r105) == true) goto L3;
            L22:
                r104 = true;
                goto L3
            L23:
                th = move-exception;
                r103.flush();     // Catch: IOException -> L45 Throwable -> L33
            L33:
                th = move-exception;
                this.unknownFields = r102.toByteString();
                throw th;
            L32:
                this.unknownFields = r102.toByteString();
                makeExtensionsImmutable();
                throw th;
            L28:
                e = move-exception;
                throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L23
            L25:
                e = move-exception;
                throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L23
            L49:
                r103.flush();     // Catch: IOException -> L46 Throwable -> L40
            L40:
                th = move-exception;
                this.unknownFields = r102.toByteString();
                throw th;
            L39:
                this.unknownFields = r102.toByteString();
                makeExtensionsImmutable();
            }

            public static /* synthetic */ int access$1002(QualifiedName r100, int r101) {
                r100.shortName_ = r101;
                return r101;
            }

            public static /* synthetic */ Kind access$1102(QualifiedName r100, Kind r101) {
                r100.kind_ = r101;
                return r101;
            }

            public static /* synthetic */ int access$1202(QualifiedName r100, int r101) {
                r100.bitField0_ = r101;
                return r101;
            }

            public static /* synthetic */ int access$902(QualifiedName r100, int r101) {
                r100.parentQualifiedName_ = r101;
                return r101;
            }

            public /* synthetic */ QualifiedName(GeneratedMessageLite.Builder r100, AnonymousClass1 r101) {
                this(r100);
            }

            public /* synthetic */ QualifiedName(CodedInputStream r100, ExtensionRegistryLite r101, AnonymousClass1 r102) throws InvalidProtocolBufferException {
                this(r100, r101);
            }
        }

        public interface QualifiedNameOrBuilder extends MessageLiteOrBuilder {
        }

        static {
            PARSER = new AnonymousClass1();
            QualifiedNameTable r100 = new QualifiedNameTable(true);
            defaultInstance = r100;
            r100.initFields();
        }

        public int getQualifiedNameCount() {
            return this.qualifiedName_.size();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int r100 = this.memoizedSerializedSize;
            if (r100 == (-1)) goto L5;
            return r100;
        L5:
            int r101 = 0;
            int r102 = 0;
        L7:
            if (r101 >= this.qualifiedName_.size()) goto L9;
            r102 = r102 + CodedOutputStream.computeMessageSize(1, (MessageLite) ListProtector.get(this.qualifiedName_, r101));
            r101 = r101 + 1;
            goto L7
        L9:
            int r103 = r102 + this.unknownFields.size();
            this.memoizedSerializedSize = r103;
            return r103;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte r100 = this.memoizedIsInitialized;
            if (r100 != 1) goto L6;
            return true;
        L6:
            if (r100 != 0) goto L8;
            return false;
        L8:
            int r101 = 0;
        L10:
            if (r101 >= getQualifiedNameCount()) goto L16;
            if (getQualifiedName(r101).isInitialized() == false) goto L13;
            r101 = r101 + 1;
            goto L10
        L13:
            this.memoizedIsInitialized = 0;
            return false;
        L16:
            this.memoizedIsInitialized = 1;
            return true;
        }

        private void initFields() {
            this.qualifiedName_ = Collections.emptyList();
        }

        public static Builder newBuilder() {
            return Builder.access$1400();
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

        public static QualifiedNameTable getDefaultInstance() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<QualifiedNameTable> getParserForType() {
            return PARSER;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public QualifiedNameTable getDefaultInstanceForType() {
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

        private QualifiedNameTable(GeneratedMessageLite.Builder r100) {
            super(r100);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r100.getUnknownFields();
        }

        public static /* synthetic */ List access$1600(QualifiedNameTable r100) {
            return r100.qualifiedName_;
        }

        public static /* synthetic */ ByteString access$1700(QualifiedNameTable r100) {
            return r100.unknownFields;
        }

        public static Builder newBuilder(QualifiedNameTable r100) {
            return newBuilder().mergeFrom(r100);
        }

        public QualifiedName getQualifiedName(int r100) {
            return (QualifiedName) ListProtector.get(this.qualifiedName_, r100);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r100) throws IOException {
            getSerializedSize();
            int r101 = 0;
        L4:
            if (r101 >= this.qualifiedName_.size()) goto L6;
            r100.writeMessage(1, (MessageLite) ListProtector.get(this.qualifiedName_, r101));
            r101 = r101 + 1;
            goto L4
        L6:
            r100.writeRawBytes(this.unknownFields);
        }

        private QualifiedNameTable(boolean r100) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        private QualifiedNameTable(CodedInputStream r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r102 = ByteString.newOutput();
            CodedOutputStream r103 = CodedOutputStream.newInstance(r102, 1);
            boolean r104 = false;
            boolean r105 = false;
        L3:
            if (r104 == true) goto L36;
            int r106 = r100.readTag();     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
            if (r106 == 0) goto L16;
            if (r106 != 10) goto L9;
            if ((r105 & true) == true) goto L14;
            this.qualifiedName_ = new ArrayList();     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
            r105 = r105 | true;     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
        L14:
            this.qualifiedName_.add((QualifiedName) r100.readMessage(QualifiedName.PARSER, r101));     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
            goto L3
        L9:
            if (parseUnknownField(r100, r103, r101, r106) == true) goto L3;
        L16:
            r104 = true;
            goto L3
        L17:
            th = move-exception;
            if ((r105 & true) != true) goto L48;
            this.qualifiedName_ = Collections.unmodifiableList(this.qualifiedName_);
        L48:
            r103.flush();     // Catch: IOException -> L46 Throwable -> L30
        L30:
            th = move-exception;
            this.unknownFields = r102.toByteString();
            throw th;
        L29:
            this.unknownFields = r102.toByteString();
            makeExtensionsImmutable();
            throw th;
        L22:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L17
        L19:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L17
        L36:
            if ((r105 & true) != true) goto L51;
            this.qualifiedName_ = Collections.unmodifiableList(this.qualifiedName_);
        L51:
            r103.flush();     // Catch: IOException -> L45 Throwable -> L40
        L40:
            th = move-exception;
            this.unknownFields = r102.toByteString();
            throw th;
        L39:
            this.unknownFields = r102.toByteString();
            makeExtensionsImmutable();
        }

        public static /* synthetic */ List access$1602(QualifiedNameTable r100, List r101) {
            r100.qualifiedName_ = r101;
            return r101;
        }

        public /* synthetic */ QualifiedNameTable(GeneratedMessageLite.Builder r100, AnonymousClass1 r101) {
            this(r100);
        }

        public /* synthetic */ QualifiedNameTable(CodedInputStream r100, ExtensionRegistryLite r101, AnonymousClass1 r102) throws InvalidProtocolBufferException {
            this(r100, r101);
        }
    }

    /* JADX INFO: loaded from: classes5.dex */
    public interface QualifiedNameTableOrBuilder extends MessageLiteOrBuilder {
    }

    /* JADX INFO: loaded from: classes5.dex */
    public static final class StringTable extends GeneratedMessageLite implements StringTableOrBuilder {
        public static Parser<StringTable> PARSER;
        private static final StringTable defaultInstance = null;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private LazyStringList string_;
        private final ByteString unknownFields;

        /* JADX INFO: loaded from: classes42.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<StringTable, Builder> implements StringTableOrBuilder {
            private int bitField0_;
            private LazyStringList string_;

            private void maybeForceBuilderInitialization() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            private static Builder create() {
                return new Builder();
            }

            private void ensureStringIsMutable() {
                if ((this.bitField0_ & 1) == 1) goto L6;
                this.string_ = new LazyStringArrayList(this.string_);
                this.bitField0_ |= 1;
                return;
            }

            public StringTable buildPartial() {
                StringTable r100 = new StringTable(this, null);
                if ((this.bitField0_ & 1) != 1) goto L5;
                this.string_ = this.string_.getUnmodifiableView();
                this.bitField0_ &= -2;
            L5:
                StringTable.access$302(r100, this.string_);
                return r100;
            }

            private Builder() {
                this.string_ = LazyStringArrayList.EMPTY;
                maybeForceBuilderInitialization();
            }

            public static /* synthetic */ Builder access$100() {
                return create();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public StringTable build() {
                StringTable r100 = buildPartial();
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
            public StringTable getDefaultInstanceForType() {
                return StringTable.getDefaultInstance();
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

            public Builder mergeFrom(StringTable r100) {
                if (r100 != StringTable.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (StringTable.access$300(r100).isEmpty() == false) goto L8;
            L11:
                setUnknownFields(getUnknownFields().concat(StringTable.access$400(r100)));
                return this;
            L8:
                if (this.string_.isEmpty() == false) goto L10;
                this.string_ = StringTable.access$300(r100);
                this.bitField0_ &= -2;
                goto L11
            L10:
                ensureStringIsMutable();
                this.string_.addAll(StringTable.access$300(r100));
                goto L11
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r100) {
                return mergeFrom((StringTable) r100);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
                StringTable r102 = null;
                StringTable r103 = StringTable.PARSER.parsePartialFrom(r100, r101);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r103 == null) goto L6;
                mergeFrom(r103);
            L6:
                return this;
            L9:
                e = move-exception;
                StringTable r104 = (StringTable) e.getUnfinishedMessage();     // Catch: Throwable -> L7
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
            StringTable r100 = new StringTable(true);
            defaultInstance = r100;
            r100.initFields();
        }

        private void initFields() {
            this.string_ = LazyStringArrayList.EMPTY;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int r100 = this.memoizedSerializedSize;
            if (r100 == (-1)) goto L5;
            return r100;
        L5:
            int r101 = 0;
            int r102 = 0;
        L7:
            if (r101 >= this.string_.size()) goto L9;
            r102 = r102 + CodedOutputStream.computeBytesSizeNoTag(this.string_.getByteString(r101));
            r101 = r101 + 1;
            goto L7
        L9:
            int r103 = ((0 + r102) + (getStringList().size() * 1)) + this.unknownFields.size();
            this.memoizedSerializedSize = r103;
            return r103;
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
            return Builder.access$100();
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

        public static StringTable getDefaultInstance() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<StringTable> getParserForType() {
            return PARSER;
        }

        public ProtocolStringList getStringList() {
            return this.string_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public StringTable getDefaultInstanceForType() {
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

        private StringTable(GeneratedMessageLite.Builder r100) {
            super(r100);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r100.getUnknownFields();
        }

        public static /* synthetic */ LazyStringList access$300(StringTable r100) {
            return r100.string_;
        }

        public static /* synthetic */ ByteString access$400(StringTable r100) {
            return r100.unknownFields;
        }

        public static Builder newBuilder(StringTable r100) {
            return newBuilder().mergeFrom(r100);
        }

        public String getString(int r100) {
            return this.string_.get(r100);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r100) throws IOException {
            getSerializedSize();
            int r101 = 0;
        L4:
            if (r101 >= this.string_.size()) goto L6;
            r100.writeBytes(1, this.string_.getByteString(r101));
            r101 = r101 + 1;
            goto L4
        L6:
            r100.writeRawBytes(this.unknownFields);
        }

        private StringTable(boolean r100) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        private StringTable(CodedInputStream r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r102 = ByteString.newOutput();
            CodedOutputStream r103 = CodedOutputStream.newInstance(r102, 1);
            boolean r104 = false;
            boolean r105 = false;
        L3:
            if (r104 == true) goto L36;
            int r106 = r100.readTag();     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
            if (r106 == 0) goto L16;
            if (r106 != 10) goto L9;
            ByteString r107 = r100.readBytes();     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
            if ((r105 & true) == true) goto L14;
            this.string_ = new LazyStringArrayList();     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
            r105 = r105 | true;     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
        L14:
            this.string_.add(r107);     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
            goto L3
        L9:
            if (parseUnknownField(r100, r103, r101, r106) == true) goto L3;
        L16:
            r104 = true;
            goto L3
        L17:
            th = move-exception;
            if ((r105 & true) != true) goto L51;
            this.string_ = this.string_.getUnmodifiableView();
        L51:
            r103.flush();     // Catch: IOException -> L46 Throwable -> L30
        L30:
            th = move-exception;
            this.unknownFields = r102.toByteString();
            throw th;
        L29:
            this.unknownFields = r102.toByteString();
            makeExtensionsImmutable();
            throw th;
        L22:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L17
        L19:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L17
        L36:
            if ((r105 & true) != true) goto L49;
            this.string_ = this.string_.getUnmodifiableView();
        L49:
            r103.flush();     // Catch: IOException -> L45 Throwable -> L40
        L40:
            th = move-exception;
            this.unknownFields = r102.toByteString();
            throw th;
        L39:
            this.unknownFields = r102.toByteString();
            makeExtensionsImmutable();
        }

        public static /* synthetic */ LazyStringList access$302(StringTable r100, LazyStringList r101) {
            r100.string_ = r101;
            return r101;
        }

        public /* synthetic */ StringTable(GeneratedMessageLite.Builder r100, AnonymousClass1 r101) {
            this(r100);
        }

        public /* synthetic */ StringTable(CodedInputStream r100, ExtensionRegistryLite r101, AnonymousClass1 r102) throws InvalidProtocolBufferException {
            this(r100, r101);
        }
    }

    /* JADX INFO: loaded from: classes5.dex */
    public interface StringTableOrBuilder extends MessageLiteOrBuilder {
    }

    /* JADX INFO: loaded from: classes5.dex */
    public static final class Type extends GeneratedMessageLite.ExtendableMessage<Type> implements TypeOrBuilder {
        public static Parser<Type> PARSER;
        private static final Type defaultInstance = null;
        private int abbreviatedTypeId_;
        private Type abbreviatedType_;
        private List<Argument> argument_;
        private int bitField0_;
        private int className_;
        private int flags_;
        private int flexibleTypeCapabilitiesId_;
        private int flexibleUpperBoundId_;
        private Type flexibleUpperBound_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private boolean nullable_;
        private int outerTypeId_;
        private Type outerType_;
        private int typeAliasName_;
        private int typeParameterName_;
        private int typeParameter_;
        private final ByteString unknownFields;

        public static final class Argument extends GeneratedMessageLite implements ArgumentOrBuilder {
            public static Parser<Argument> PARSER;
            private static final Argument defaultInstance = null;
            private int bitField0_;
            private byte memoizedIsInitialized;
            private int memoizedSerializedSize;
            private Projection projection_;
            private int typeId_;
            private Type type_;
            private final ByteString unknownFields;

            /* JADX INFO: loaded from: classes42.dex */
            public static final class Builder extends GeneratedMessageLite.Builder<Argument, Builder> implements ArgumentOrBuilder {
                private int bitField0_;
                private Projection projection_;
                private int typeId_;
                private Type type_;

                private void maybeForceBuilderInitialization() {
                }

                private static Builder create() {
                    return new Builder();
                }

                public Argument buildPartial() {
                    Argument r100 = new Argument(this, null);
                    int r101 = this.bitField0_;
                    int r102 = 1;
                    if ((r101 & 1) == 1) goto L6;
                    r102 = 0;
                L6:
                    Argument.access$5202(r100, this.projection_);
                    if ((r101 & 2) != 2) goto L9;
                    r102 = r102 | 2;
                L9:
                    Argument.access$5302(r100, this.type_);
                    if ((r101 & 4) != 4) goto L12;
                    r102 = r102 | 4;
                L12:
                    Argument.access$5402(r100, this.typeId_);
                    Argument.access$5502(r100, r102);
                    return r100;
                }

                public boolean hasType() {
                    if ((this.bitField0_ & 2) != 2) goto L5;
                    return true;
                L5:
                    return false;
                }

                private Builder() {
                    this.projection_ = Projection.INV;
                    this.type_ = Type.getDefaultInstance();
                    maybeForceBuilderInitialization();
                }

                public static /* synthetic */ Builder access$5000() {
                    return create();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                public Argument build() {
                    Argument r100 = buildPartial();
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
                public Argument getDefaultInstanceForType() {
                    return Argument.getDefaultInstance();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
                public final boolean isInitialized() {
                    if (hasType() == true) goto L5;
                    return true;
                L5:
                    if (getType().isInitialized() == true) goto L10;
                    return false;
                L10:
                    return true;
                }

                public Type getType() {
                    return this.type_;
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

                public Builder mergeFrom(Argument r100) {
                    if (r100 != Argument.getDefaultInstance()) goto L6;
                    return this;
                L6:
                    if (r100.hasProjection() == false) goto L9;
                    setProjection(r100.getProjection());
                L9:
                    if (r100.hasType() == false) goto L12;
                    mergeType(r100.getType());
                L12:
                    if (r100.hasTypeId() == false) goto L14;
                    setTypeId(r100.getTypeId());
                L14:
                    setUnknownFields(getUnknownFields().concat(Argument.access$5600(r100)));
                    return this;
                }

                public Builder mergeType(Type r100) {
                    if ((this.bitField0_ & 2) == 2) goto L5;
                L7:
                    this.type_ = r100;
                L8:
                    this.bitField0_ |= 2;
                    return this;
                L5:
                    if (this.type_ == Type.getDefaultInstance()) goto L7;
                    this.type_ = Type.newBuilder(this.type_).mergeFrom(r100).buildPartial();
                    goto L8
                }

                public Builder setProjection(Projection r100) {
                    if (r100 == null) goto L6;
                    this.bitField0_ |= 1;
                    this.projection_ = r100;
                    return this;
                L6:
                    throw null;
                }

                public Builder setTypeId(int r100) {
                    this.bitField0_ |= 4;
                    this.typeId_ = r100;
                    return this;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
                public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r100) {
                    return mergeFrom((Argument) r100);
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
                public Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
                    Argument r102 = null;
                    Argument r103 = Argument.PARSER.parsePartialFrom(r100, r101);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                    if (r103 == null) goto L6;
                    mergeFrom(r103);
                L6:
                    return this;
                L9:
                    e = move-exception;
                    Argument r104 = (Argument) e.getUnfinishedMessage();     // Catch: Throwable -> L7
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

            public static final enum Projection extends Enum<Projection> implements Internal.EnumLite {
                private static final /* synthetic */ Projection[] $VALUES = null;
                public static final Projection IN = null;
                public static final Projection INV = null;
                public static final Projection OUT = null;
                public static final Projection STAR = null;
                private static Internal.EnumLiteMap<Projection> internalValueMap;
                private final int value;

                static {
                    Projection r100 = new Projection("IN", 0, 0, 0);
                    IN = r100;
                    Projection r101 = new Projection("OUT", 1, 1, 1);
                    OUT = r101;
                    Projection r102 = new Projection("INV", 2, 2, 2);
                    INV = r102;
                    Projection r103 = new Projection("STAR", 3, 3, 3);
                    STAR = r103;
                    $VALUES = new Projection[]{r100, r101, r102, r103};
                    internalValueMap = new AnonymousClass1();
                }

                public static Projection[] values() {
                    return (Projection[]) $VALUES.clone();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
                public final int getNumber() {
                    return this.value;
                }

                public static Projection valueOf(int r100) {
                    if (r100 == 0) goto L18;
                    if (r100 == 1) goto L16;
                    if (r100 == 2) goto L14;
                    if (r100 == 3) goto L12;
                    return null;
                L12:
                    return STAR;
                L14:
                    return INV;
                L16:
                    return OUT;
                L18:
                    return IN;
                }

                public static Projection valueOf(String r100) {
                    return (Projection) a.a(Projection.class, r100);
                }

                private Projection(String r100, int r101, int r102, int r103) {
                    super(r100, r101);
                    this.value = r103;
                }
            }

            static {
                PARSER = new AnonymousClass1();
                Argument r100 = new Argument(true);
                defaultInstance = r100;
                r100.initFields();
            }

            private void initFields() {
                this.projection_ = Projection.INV;
                this.type_ = Type.getDefaultInstance();
                this.typeId_ = 0;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public int getSerializedSize() {
                int r100 = this.memoizedSerializedSize;
                if (r100 == (-1)) goto L5;
                return r100;
            L5:
                int r101 = 0;
                if ((this.bitField0_ & 1) != 1) goto L9;
                r101 = 0 + CodedOutputStream.computeEnumSize(1, this.projection_.getNumber());
            L9:
                if ((this.bitField0_ & 2) != 2) goto L12;
                r101 = r101 + CodedOutputStream.computeMessageSize(2, this.type_);
            L12:
                if ((this.bitField0_ & 4) != 4) goto L14;
                r101 = r101 + CodedOutputStream.computeInt32Size(3, this.typeId_);
            L14:
                int r102 = r101 + this.unknownFields.size();
                this.memoizedSerializedSize = r102;
                return r102;
            }

            public boolean hasProjection() {
                if ((this.bitField0_ & 1) == 1) goto L7;
                return false;
            L7:
                return true;
            }

            public boolean hasType() {
                if ((this.bitField0_ & 2) != 2) goto L5;
                return true;
            L5:
                return false;
            }

            public boolean hasTypeId() {
                if ((this.bitField0_ & 4) != 4) goto L5;
                return true;
            L5:
                return false;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                byte r100 = this.memoizedIsInitialized;
                if (r100 != 1) goto L6;
                return true;
            L6:
                if (r100 != 0) goto L9;
                return false;
            L9:
                if (hasType() == true) goto L11;
            L14:
                this.memoizedIsInitialized = 1;
                return true;
            L11:
                if (getType().isInitialized() == true) goto L14;
                this.memoizedIsInitialized = 0;
                return false;
            }

            public static Builder newBuilder() {
                return Builder.access$5000();
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

            public static Argument getDefaultInstance() {
                return defaultInstance;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public Parser<Argument> getParserForType() {
                return PARSER;
            }

            public Projection getProjection() {
                return this.projection_;
            }

            public Type getType() {
                return this.type_;
            }

            public int getTypeId() {
                return this.typeId_;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public Argument getDefaultInstanceForType() {
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

            private Argument(GeneratedMessageLite.Builder r100) {
                super(r100);
                this.memoizedIsInitialized = -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = r100.getUnknownFields();
            }

            public static /* synthetic */ ByteString access$5600(Argument r100) {
                return r100.unknownFields;
            }

            public static Builder newBuilder(Argument r100) {
                return newBuilder().mergeFrom(r100);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
            public void writeTo(CodedOutputStream r100) throws IOException {
                getSerializedSize();
                if ((this.bitField0_ & 1) != 1) goto L6;
                r100.writeEnum(1, this.projection_.getNumber());
            L6:
                if ((this.bitField0_ & 2) != 2) goto L9;
                r100.writeMessage(2, this.type_);
            L9:
                if ((this.bitField0_ & 4) != 4) goto L11;
                r100.writeInt32(3, this.typeId_);
            L11:
                r100.writeRawBytes(this.unknownFields);
            }

            private Argument(boolean r100) {
                this.memoizedIsInitialized = -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = ByteString.EMPTY;
            }

            private Argument(CodedInputStream r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
                this.memoizedIsInitialized = -1;
                this.memoizedSerializedSize = -1;
                initFields();
                ByteString.Output r102 = ByteString.newOutput();
                CodedOutputStream r103 = CodedOutputStream.newInstance(r102, 1);
                boolean r104 = false;
            L3:
                if (r104 == true) goto L58;
                int r105 = r100.readTag();     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
                if (r105 == 0) goto L29;
                if (r105 != 8) goto L9;
                int r106 = r100.readEnum();     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
                Projection r107 = Projection.valueOf(r106);     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
                if (r107 == null) goto L26;
                this.bitField0_ |= 1;     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
                this.projection_ = r107;     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
                goto L3
            L26:
                r103.writeRawVarint32(r105);     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
                r103.writeRawVarint32(r106);     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
                goto L3
            L9:
                if (r105 != 18) goto L11;
                if ((this.bitField0_ & 2) != 2) goto L19;
                Builder r108 = this.type_.toBuilder();     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
            L20:
                Type r109 = (Type) r100.readMessage(Type.PARSER, r101);     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
                this.type_ = r109;     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
                if (r108 == null) goto L23;
                r108.mergeFrom(r109);     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
                this.type_ = r108.buildPartial();     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
            L23:
                this.bitField0_ |= 2;     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
                goto L3
            L19:
                r108 = null;
                goto L20
            L11:
                if (r105 != 24) goto L13;
                this.bitField0_ |= 4;     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
                this.typeId_ = r100.readInt32();     // Catch: Throwable -> L30 IOException -> L32 InvalidProtocolBufferException -> L35
                goto L3
            L13:
                if (parseUnknownField(r100, r103, r101, r105) == true) goto L3;
            L29:
                r104 = true;
                goto L3
            L30:
                th = move-exception;
                r103.flush();     // Catch: IOException -> L52 Throwable -> L40
            L40:
                th = move-exception;
                this.unknownFields = r102.toByteString();
                throw th;
            L39:
                this.unknownFields = r102.toByteString();
                makeExtensionsImmutable();
                throw th;
            L32:
                e = move-exception;
                throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L30
            L35:
                e = move-exception;
                throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L30
            L58:
                r103.flush();     // Catch: IOException -> L53 Throwable -> L47
            L47:
                th = move-exception;
                this.unknownFields = r102.toByteString();
                throw th;
            L46:
                this.unknownFields = r102.toByteString();
                makeExtensionsImmutable();
            }

            public static /* synthetic */ Projection access$5202(Argument r100, Projection r101) {
                r100.projection_ = r101;
                return r101;
            }

            public static /* synthetic */ Type access$5302(Argument r100, Type r101) {
                r100.type_ = r101;
                return r101;
            }

            public static /* synthetic */ int access$5402(Argument r100, int r101) {
                r100.typeId_ = r101;
                return r101;
            }

            public static /* synthetic */ int access$5502(Argument r100, int r101) {
                r100.bitField0_ = r101;
                return r101;
            }

            public /* synthetic */ Argument(GeneratedMessageLite.Builder r100, AnonymousClass1 r101) {
                this(r100);
            }

            public /* synthetic */ Argument(CodedInputStream r100, ExtensionRegistryLite r101, AnonymousClass1 r102) throws InvalidProtocolBufferException {
                this(r100, r101);
            }
        }

        public interface ArgumentOrBuilder extends MessageLiteOrBuilder {
        }

        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<Type, Builder> implements TypeOrBuilder {
            private int abbreviatedTypeId_;
            private Type abbreviatedType_;
            private List<Argument> argument_;
            private int bitField0_;
            private int className_;
            private int flags_;
            private int flexibleTypeCapabilitiesId_;
            private int flexibleUpperBoundId_;
            private Type flexibleUpperBound_;
            private boolean nullable_;
            private int outerTypeId_;
            private Type outerType_;
            private int typeAliasName_;
            private int typeParameterName_;
            private int typeParameter_;

            private void maybeForceBuilderInitialization() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                int r100 = 0;
            L4:
                if (r100 >= getArgumentCount()) goto L10;
                if (getArgument(r100).isInitialized() == false) goto L7;
                r100 = r100 + 1;
                goto L4
            L7:
                return false;
            L10:
                if (hasFlexibleUpperBound() == false) goto L15;
                if (getFlexibleUpperBound().isInitialized() == true) goto L15;
                return false;
            L15:
                if (hasOuterType() == false) goto L20;
                if (getOuterType().isInitialized() == true) goto L20;
                return false;
            L20:
                if (hasAbbreviatedType() == false) goto L25;
                if (getAbbreviatedType().isInitialized() == true) goto L25;
                return false;
            L25:
                if (extensionsAreInitialized() == true) goto L27;
                return false;
            L27:
                return true;
            }

            private static Builder create() {
                return new Builder();
            }

            private void ensureArgumentIsMutable() {
                if ((this.bitField0_ & 1) == 1) goto L6;
                this.argument_ = new ArrayList(this.argument_);
                this.bitField0_ |= 1;
                return;
            }

            public Type buildPartial() {
                Type r100 = new Type(this, null);
                int r101 = this.bitField0_;
                int r102 = 1;
                if ((r101 & 1) != 1) goto L5;
                this.argument_ = Collections.unmodifiableList(this.argument_);
                this.bitField0_ &= -2;
            L5:
                Type.access$5902(r100, this.argument_);
                if ((r101 & 2) == 2) goto L9;
                r102 = 0;
            L9:
                Type.access$6002(r100, this.nullable_);
                if ((r101 & 4) != 4) goto L12;
                r102 = r102 | 2;
            L12:
                Type.access$6102(r100, this.flexibleTypeCapabilitiesId_);
                if ((r101 & 8) != 8) goto L15;
                r102 = r102 | 4;
            L15:
                Type.access$6202(r100, this.flexibleUpperBound_);
                if ((r101 & 16) != 16) goto L18;
                r102 = r102 | 8;
            L18:
                Type.access$6302(r100, this.flexibleUpperBoundId_);
                if ((r101 & 32) != 32) goto L21;
                r102 = r102 | 16;
            L21:
                Type.access$6402(r100, this.className_);
                if ((r101 & 64) != 64) goto L24;
                r102 = r102 | 32;
            L24:
                Type.access$6502(r100, this.typeParameter_);
                if ((r101 & 128) != 128) goto L27;
                r102 = r102 | 64;
            L27:
                Type.access$6602(r100, this.typeParameterName_);
                if ((r101 & 256) != 256) goto L30;
                r102 = r102 | 128;
            L30:
                Type.access$6702(r100, this.typeAliasName_);
                if ((r101 & 512) != 512) goto L33;
                r102 = r102 | 256;
            L33:
                Type.access$6802(r100, this.outerType_);
                if ((r101 & 1024) != 1024) goto L36;
                r102 = r102 | 512;
            L36:
                Type.access$6902(r100, this.outerTypeId_);
                if ((r101 & 2048) != 2048) goto L39;
                r102 = r102 | 1024;
            L39:
                Type.access$7002(r100, this.abbreviatedType_);
                if ((r101 & 4096) != 4096) goto L42;
                r102 = r102 | 2048;
            L42:
                Type.access$7102(r100, this.abbreviatedTypeId_);
                if ((r101 & 8192) != 8192) goto L45;
                r102 = r102 | 4096;
            L45:
                Type.access$7202(r100, this.flags_);
                Type.access$7302(r100, r102);
                return r100;
            }

            public int getArgumentCount() {
                return this.argument_.size();
            }

            public boolean hasAbbreviatedType() {
                if ((this.bitField0_ & 2048) != 2048) goto L5;
                return true;
            L5:
                return false;
            }

            public boolean hasFlexibleUpperBound() {
                if ((this.bitField0_ & 8) != 8) goto L5;
                return true;
            L5:
                return false;
            }

            public boolean hasOuterType() {
                if ((this.bitField0_ & 512) != 512) goto L5;
                return true;
            L5:
                return false;
            }

            private Builder() {
                this.argument_ = Collections.emptyList();
                this.flexibleUpperBound_ = Type.getDefaultInstance();
                this.outerType_ = Type.getDefaultInstance();
                this.abbreviatedType_ = Type.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            public static /* synthetic */ Builder access$5700() {
                return create();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Type build() {
                Type r100 = buildPartial();
                if (r100.isInitialized() == false) goto L6;
                return r100;
            L6:
                throw AbstractMessageLite.Builder.newUninitializedMessageException(r100);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public Type getDefaultInstanceForType() {
                return Type.getDefaultInstance();
            }

            public Type getAbbreviatedType() {
                return this.abbreviatedType_;
            }

            public Type getFlexibleUpperBound() {
                return this.flexibleUpperBound_;
            }

            public Type getOuterType() {
                return this.outerType_;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo10730clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.ExtendableBuilder clone() {
                return clone();
            }

            public Argument getArgument(int r100) {
                return (Argument) ListProtector.get(this.argument_, r100);
            }

            public Builder mergeAbbreviatedType(Type r100) {
                if ((this.bitField0_ & 2048) == 2048) goto L5;
            L7:
                this.abbreviatedType_ = r100;
            L8:
                this.bitField0_ |= 2048;
                return this;
            L5:
                if (this.abbreviatedType_ == Type.getDefaultInstance()) goto L7;
                this.abbreviatedType_ = Type.newBuilder(this.abbreviatedType_).mergeFrom(r100).buildPartial();
                goto L8
            }

            public Builder mergeFlexibleUpperBound(Type r100) {
                if ((this.bitField0_ & 8) == 8) goto L5;
            L7:
                this.flexibleUpperBound_ = r100;
            L8:
                this.bitField0_ |= 8;
                return this;
            L5:
                if (this.flexibleUpperBound_ == Type.getDefaultInstance()) goto L7;
                this.flexibleUpperBound_ = Type.newBuilder(this.flexibleUpperBound_).mergeFrom(r100).buildPartial();
                goto L8
            }

            public Builder mergeFrom(Type r100) {
                if (r100 != Type.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (Type.access$5900(r100).isEmpty() == true) goto L12;
                if (this.argument_.isEmpty() == false) goto L10;
                this.argument_ = Type.access$5900(r100);
                this.bitField0_ &= -2;
                goto L12
            L10:
                ensureArgumentIsMutable();
                this.argument_.addAll(Type.access$5900(r100));
            L12:
                if (r100.hasNullable() == false) goto L15;
                setNullable(r100.getNullable());
            L15:
                if (r100.hasFlexibleTypeCapabilitiesId() == false) goto L18;
                setFlexibleTypeCapabilitiesId(r100.getFlexibleTypeCapabilitiesId());
            L18:
                if (r100.hasFlexibleUpperBound() == false) goto L21;
                mergeFlexibleUpperBound(r100.getFlexibleUpperBound());
            L21:
                if (r100.hasFlexibleUpperBoundId() == false) goto L24;
                setFlexibleUpperBoundId(r100.getFlexibleUpperBoundId());
            L24:
                if (r100.hasClassName() == false) goto L27;
                setClassName(r100.getClassName());
            L27:
                if (r100.hasTypeParameter() == false) goto L30;
                setTypeParameter(r100.getTypeParameter());
            L30:
                if (r100.hasTypeParameterName() == false) goto L33;
                setTypeParameterName(r100.getTypeParameterName());
            L33:
                if (r100.hasTypeAliasName() == false) goto L36;
                setTypeAliasName(r100.getTypeAliasName());
            L36:
                if (r100.hasOuterType() == false) goto L39;
                mergeOuterType(r100.getOuterType());
            L39:
                if (r100.hasOuterTypeId() == false) goto L42;
                setOuterTypeId(r100.getOuterTypeId());
            L42:
                if (r100.hasAbbreviatedType() == false) goto L45;
                mergeAbbreviatedType(r100.getAbbreviatedType());
            L45:
                if (r100.hasAbbreviatedTypeId() == false) goto L48;
                setAbbreviatedTypeId(r100.getAbbreviatedTypeId());
            L48:
                if (r100.hasFlags() == false) goto L50;
                setFlags(r100.getFlags());
            L50:
                mergeExtensionFields(r100);
                setUnknownFields(getUnknownFields().concat(Type.access$7400(r100)));
                return this;
            }

            public Builder mergeOuterType(Type r100) {
                if ((this.bitField0_ & 512) == 512) goto L5;
            L7:
                this.outerType_ = r100;
            L8:
                this.bitField0_ |= 512;
                return this;
            L5:
                if (this.outerType_ == Type.getDefaultInstance()) goto L7;
                this.outerType_ = Type.newBuilder(this.outerType_).mergeFrom(r100).buildPartial();
                goto L8
            }

            public Builder setAbbreviatedTypeId(int r100) {
                this.bitField0_ |= 4096;
                this.abbreviatedTypeId_ = r100;
                return this;
            }

            public Builder setClassName(int r100) {
                this.bitField0_ |= 32;
                this.className_ = r100;
                return this;
            }

            public Builder setFlags(int r100) {
                this.bitField0_ |= 8192;
                this.flags_ = r100;
                return this;
            }

            public Builder setFlexibleTypeCapabilitiesId(int r100) {
                this.bitField0_ |= 4;
                this.flexibleTypeCapabilitiesId_ = r100;
                return this;
            }

            public Builder setFlexibleUpperBoundId(int r100) {
                this.bitField0_ |= 16;
                this.flexibleUpperBoundId_ = r100;
                return this;
            }

            public Builder setNullable(boolean r100) {
                this.bitField0_ |= 2;
                this.nullable_ = r100;
                return this;
            }

            public Builder setOuterTypeId(int r100) {
                this.bitField0_ |= 1024;
                this.outerTypeId_ = r100;
                return this;
            }

            public Builder setTypeAliasName(int r100) {
                this.bitField0_ |= 256;
                this.typeAliasName_ = r100;
                return this;
            }

            public Builder setTypeParameter(int r100) {
                this.bitField0_ |= 64;
                this.typeParameter_ = r100;
                return this;
            }

            public Builder setTypeParameterName(int r100) {
                this.bitField0_ |= 128;
                this.typeParameterName_ = r100;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r100) {
                return mergeFrom((Type) r100);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
                Type r102 = null;
                Type r103 = Type.PARSER.parsePartialFrom(r100, r101);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r103 == null) goto L6;
                mergeFrom(r103);
            L6:
                return this;
            L9:
                e = move-exception;
                Type r104 = (Type) e.getUnfinishedMessage();     // Catch: Throwable -> L7
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
            Type r100 = new Type(true);
            defaultInstance = r100;
            r100.initFields();
        }

        public int getArgumentCount() {
            return this.argument_.size();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int r100 = this.memoizedSerializedSize;
            if (r100 == (-1)) goto L5;
            return r100;
        L5:
            int r101 = 0;
            if ((this.bitField0_ & 4096) != 4096) goto L8;
            int r102 = CodedOutputStream.computeInt32Size(1, this.flags_) + 0;
        L10:
            if (r101 >= this.argument_.size()) goto L13;
            r102 = r102 + CodedOutputStream.computeMessageSize(2, (MessageLite) ListProtector.get(this.argument_, r101));
            r101 = r101 + 1;
            goto L10
        L13:
            if ((this.bitField0_ & 1) != 1) goto L16;
            r102 = r102 + CodedOutputStream.computeBoolSize(3, this.nullable_);
        L16:
            if ((this.bitField0_ & 2) != 2) goto L19;
            r102 = r102 + CodedOutputStream.computeInt32Size(4, this.flexibleTypeCapabilitiesId_);
        L19:
            if ((this.bitField0_ & 4) != 4) goto L22;
            r102 = r102 + CodedOutputStream.computeMessageSize(5, this.flexibleUpperBound_);
        L22:
            if ((this.bitField0_ & 16) != 16) goto L25;
            r102 = r102 + CodedOutputStream.computeInt32Size(6, this.className_);
        L25:
            if ((this.bitField0_ & 32) != 32) goto L28;
            r102 = r102 + CodedOutputStream.computeInt32Size(7, this.typeParameter_);
        L28:
            if ((this.bitField0_ & 8) != 8) goto L31;
            r102 = r102 + CodedOutputStream.computeInt32Size(8, this.flexibleUpperBoundId_);
        L31:
            if ((this.bitField0_ & 64) != 64) goto L34;
            r102 = r102 + CodedOutputStream.computeInt32Size(9, this.typeParameterName_);
        L34:
            if ((this.bitField0_ & 256) != 256) goto L37;
            r102 = r102 + CodedOutputStream.computeMessageSize(10, this.outerType_);
        L37:
            if ((this.bitField0_ & 512) != 512) goto L40;
            r102 = r102 + CodedOutputStream.computeInt32Size(11, this.outerTypeId_);
        L40:
            if ((this.bitField0_ & 128) != 128) goto L43;
            r102 = r102 + CodedOutputStream.computeInt32Size(12, this.typeAliasName_);
        L43:
            if ((this.bitField0_ & 1024) != 1024) goto L46;
            r102 = r102 + CodedOutputStream.computeMessageSize(13, this.abbreviatedType_);
        L46:
            if ((this.bitField0_ & 2048) != 2048) goto L48;
            r102 = r102 + CodedOutputStream.computeInt32Size(14, this.abbreviatedTypeId_);
        L48:
            int r103 = (r102 + extensionsSerializedSize()) + this.unknownFields.size();
            this.memoizedSerializedSize = r103;
            return r103;
        L8:
            r102 = 0;
            goto L10
        }

        public boolean hasAbbreviatedType() {
            if ((this.bitField0_ & 1024) != 1024) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasAbbreviatedTypeId() {
            if ((this.bitField0_ & 2048) != 2048) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasClassName() {
            if ((this.bitField0_ & 16) != 16) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasFlags() {
            if ((this.bitField0_ & 4096) != 4096) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasFlexibleTypeCapabilitiesId() {
            if ((this.bitField0_ & 2) != 2) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasFlexibleUpperBound() {
            if ((this.bitField0_ & 4) != 4) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasFlexibleUpperBoundId() {
            if ((this.bitField0_ & 8) != 8) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasNullable() {
            if ((this.bitField0_ & 1) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        public boolean hasOuterType() {
            if ((this.bitField0_ & 256) != 256) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasOuterTypeId() {
            if ((this.bitField0_ & 512) != 512) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasTypeAliasName() {
            if ((this.bitField0_ & 128) != 128) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasTypeParameter() {
            if ((this.bitField0_ & 32) != 32) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasTypeParameterName() {
            if ((this.bitField0_ & 64) != 64) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte r100 = this.memoizedIsInitialized;
            if (r100 != 1) goto L6;
            return true;
        L6:
            if (r100 != 0) goto L8;
            return false;
        L8:
            int r101 = 0;
        L10:
            if (r101 >= getArgumentCount()) goto L17;
            if (getArgument(r101).isInitialized() == false) goto L13;
            r101 = r101 + 1;
            goto L10
        L13:
            this.memoizedIsInitialized = 0;
            return false;
        L17:
            if (hasFlexibleUpperBound() == false) goto L23;
            if (getFlexibleUpperBound().isInitialized() == true) goto L23;
            this.memoizedIsInitialized = 0;
            return false;
        L23:
            if (hasOuterType() == false) goto L29;
            if (getOuterType().isInitialized() == true) goto L29;
            this.memoizedIsInitialized = 0;
            return false;
        L29:
            if (hasAbbreviatedType() == false) goto L35;
            if (getAbbreviatedType().isInitialized() == true) goto L35;
            this.memoizedIsInitialized = 0;
            return false;
        L35:
            if (extensionsAreInitialized() == true) goto L38;
            this.memoizedIsInitialized = 0;
            return false;
        L38:
            this.memoizedIsInitialized = 1;
            return true;
        }

        private void initFields() {
            this.argument_ = Collections.emptyList();
            this.nullable_ = false;
            this.flexibleTypeCapabilitiesId_ = 0;
            this.flexibleUpperBound_ = getDefaultInstance();
            this.flexibleUpperBoundId_ = 0;
            this.className_ = 0;
            this.typeParameter_ = 0;
            this.typeParameterName_ = 0;
            this.typeAliasName_ = 0;
            this.outerType_ = getDefaultInstance();
            this.outerTypeId_ = 0;
            this.abbreviatedType_ = getDefaultInstance();
            this.abbreviatedTypeId_ = 0;
            this.flags_ = 0;
        }

        public static Builder newBuilder() {
            return Builder.access$5700();
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

        public static Type getDefaultInstance() {
            return defaultInstance;
        }

        public Type getAbbreviatedType() {
            return this.abbreviatedType_;
        }

        public int getAbbreviatedTypeId() {
            return this.abbreviatedTypeId_;
        }

        public List<Argument> getArgumentList() {
            return this.argument_;
        }

        public int getClassName() {
            return this.className_;
        }

        public int getFlags() {
            return this.flags_;
        }

        public int getFlexibleTypeCapabilitiesId() {
            return this.flexibleTypeCapabilitiesId_;
        }

        public Type getFlexibleUpperBound() {
            return this.flexibleUpperBound_;
        }

        public int getFlexibleUpperBoundId() {
            return this.flexibleUpperBoundId_;
        }

        public boolean getNullable() {
            return this.nullable_;
        }

        public Type getOuterType() {
            return this.outerType_;
        }

        public int getOuterTypeId() {
            return this.outerTypeId_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<Type> getParserForType() {
            return PARSER;
        }

        public int getTypeAliasName() {
            return this.typeAliasName_;
        }

        public int getTypeParameter() {
            return this.typeParameter_;
        }

        public int getTypeParameterName() {
            return this.typeParameterName_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public Type getDefaultInstanceForType() {
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

        private Type(GeneratedMessageLite.ExtendableBuilder<Type, ?> r100) {
            super(r100);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r100.getUnknownFields();
        }

        public static /* synthetic */ List access$5900(Type r100) {
            return r100.argument_;
        }

        public static /* synthetic */ ByteString access$7400(Type r100) {
            return r100.unknownFields;
        }

        public static Builder newBuilder(Type r100) {
            return newBuilder().mergeFrom(r100);
        }

        public Argument getArgument(int r100) {
            return (Argument) ListProtector.get(this.argument_, r100);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r100) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter r101 = newExtensionWriter();
            if ((this.bitField0_ & 4096) != 4096) goto L5;
            r100.writeInt32(1, this.flags_);
        L5:
            int r102 = 0;
        L7:
            if (r102 >= this.argument_.size()) goto L10;
            r100.writeMessage(2, (MessageLite) ListProtector.get(this.argument_, r102));
            r102 = r102 + 1;
            goto L7
        L10:
            if ((this.bitField0_ & 1) != 1) goto L13;
            r100.writeBool(3, this.nullable_);
        L13:
            if ((this.bitField0_ & 2) != 2) goto L16;
            r100.writeInt32(4, this.flexibleTypeCapabilitiesId_);
        L16:
            if ((this.bitField0_ & 4) != 4) goto L19;
            r100.writeMessage(5, this.flexibleUpperBound_);
        L19:
            if ((this.bitField0_ & 16) != 16) goto L22;
            r100.writeInt32(6, this.className_);
        L22:
            if ((this.bitField0_ & 32) != 32) goto L25;
            r100.writeInt32(7, this.typeParameter_);
        L25:
            if ((this.bitField0_ & 8) != 8) goto L28;
            r100.writeInt32(8, this.flexibleUpperBoundId_);
        L28:
            if ((this.bitField0_ & 64) != 64) goto L31;
            r100.writeInt32(9, this.typeParameterName_);
        L31:
            if ((this.bitField0_ & 256) != 256) goto L34;
            r100.writeMessage(10, this.outerType_);
        L34:
            if ((this.bitField0_ & 512) != 512) goto L37;
            r100.writeInt32(11, this.outerTypeId_);
        L37:
            if ((this.bitField0_ & 128) != 128) goto L40;
            r100.writeInt32(12, this.typeAliasName_);
        L40:
            if ((this.bitField0_ & 1024) != 1024) goto L43;
            r100.writeMessage(13, this.abbreviatedType_);
        L43:
            if ((this.bitField0_ & 2048) != 2048) goto L45;
            r100.writeInt32(14, this.abbreviatedTypeId_);
        L45:
            r101.writeUntil(200, r100);
            r100.writeRawBytes(this.unknownFields);
        }

        private Type(boolean r100) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        private Type(CodedInputStream r100, ExtensionRegistryLite r110) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r101 = ByteString.newOutput();
            CodedOutputStream r102 = CodedOutputStream.newInstance(r101, 1);
            boolean r103 = false;
            boolean r104 = false;
        L3:
            if (r103 == true) goto L65;
            int r105 = r100.readTag();     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
            Builder r106 = null;
            switch(r105) {
                case 0: goto L43;
                case 8: goto L41;
                case 18: goto L38;
                case 24: goto L36;
                case 32: goto L35;
                case 42: goto L29;
                case 48: goto L27;
                case 56: goto L26;
                case 64: goto L25;
                case 72: goto L24;
                case 82: goto L18;
                case 88: goto L16;
                case 96: goto L15;
                case 106: goto L9;
                case 112: goto L7;
                default: goto L44;
            };     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
        L7:
            this.bitField0_ |= 2048;     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
            this.abbreviatedTypeId_ = r100.readInt32();     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
            goto L3
        L9:
            if ((this.bitField0_ & 1024) != 1024) goto L11;
            r106 = this.abbreviatedType_.toBuilder();     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
        L11:
            Type r107 = (Type) r100.readMessage(PARSER, r110);     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
            this.abbreviatedType_ = r107;     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
            if (r106 == null) goto L14;
            r106.mergeFrom(r107);     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
            this.abbreviatedType_ = r106.buildPartial();     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
        L14:
            this.bitField0_ |= 1024;     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
            goto L3
        L15:
            this.bitField0_ |= 128;     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
            this.typeAliasName_ = r100.readInt32();     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
            goto L3
        L16:
            this.bitField0_ |= 512;     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
            this.outerTypeId_ = r100.readInt32();     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
            goto L3
        L18:
            if ((this.bitField0_ & 256) != 256) goto L20;
            r106 = this.outerType_.toBuilder();     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
        L20:
            Type r108 = (Type) r100.readMessage(PARSER, r110);     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
            this.outerType_ = r108;     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
            if (r106 == null) goto L23;
            r106.mergeFrom(r108);     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
            this.outerType_ = r106.buildPartial();     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
        L23:
            this.bitField0_ |= 256;     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
            goto L3
        L24:
            this.bitField0_ |= 64;     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
            this.typeParameterName_ = r100.readInt32();     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
            goto L3
        L25:
            this.bitField0_ |= 8;     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
            this.flexibleUpperBoundId_ = r100.readInt32();     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
            goto L3
        L26:
            this.bitField0_ |= 32;     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
            this.typeParameter_ = r100.readInt32();     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
            goto L3
        L27:
            this.bitField0_ |= 16;     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
            this.className_ = r100.readInt32();     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
            goto L3
        L29:
            if ((this.bitField0_ & 4) != 4) goto L31;
            r106 = this.flexibleUpperBound_.toBuilder();     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
        L31:
            Type r109 = (Type) r100.readMessage(PARSER, r110);     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
            this.flexibleUpperBound_ = r109;     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
            if (r106 == null) goto L34;
            r106.mergeFrom(r109);     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
            this.flexibleUpperBound_ = r106.buildPartial();     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
        L34:
            this.bitField0_ |= 4;     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
            goto L3
        L35:
            this.bitField0_ |= 2;     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
            this.flexibleTypeCapabilitiesId_ = r100.readInt32();     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
            goto L3
        L36:
            this.bitField0_ |= 1;     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
            this.nullable_ = r100.readBool();     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
            goto L3
        L38:
            if ((r104 & true) == true) goto L40;
            this.argument_ = new ArrayList();     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
            r104 = r104 | true;     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
        L40:
            this.argument_.add((Argument) r100.readMessage(Argument.PARSER, r110));     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
            goto L3
        L41:
            this.bitField0_ |= 4096;     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
            this.flags_ = r100.readInt32();     // Catch: Throwable -> L46 IOException -> L48 InvalidProtocolBufferException -> L51
        L43:
            r103 = true;
            goto L3
        L44:
            if (parseUnknownField(r100, r102, r110, r105) == true) goto L3;
        L46:
            th = move-exception;
            if ((r104 & true) != true) goto L78;
            this.argument_ = Collections.unmodifiableList(this.argument_);
        L78:
            r102.flush();     // Catch: IOException -> L75 Throwable -> L59
        L59:
            th = move-exception;
            this.unknownFields = r101.toByteString();
            throw th;
        L58:
            this.unknownFields = r101.toByteString();
            makeExtensionsImmutable();
            throw th;
        L51:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L46
        L48:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L46
        L65:
            if ((r104 & true) != true) goto L80;
            this.argument_ = Collections.unmodifiableList(this.argument_);
        L80:
            r102.flush();     // Catch: IOException -> L74 Throwable -> L69
        L69:
            th = move-exception;
            this.unknownFields = r101.toByteString();
            throw th;
        L68:
            this.unknownFields = r101.toByteString();
            makeExtensionsImmutable();
        }

        public static /* synthetic */ List access$5902(Type r100, List r101) {
            r100.argument_ = r101;
            return r101;
        }

        public static /* synthetic */ boolean access$6002(Type r100, boolean r101) {
            r100.nullable_ = r101;
            return r101;
        }

        public static /* synthetic */ int access$6102(Type r100, int r101) {
            r100.flexibleTypeCapabilitiesId_ = r101;
            return r101;
        }

        public static /* synthetic */ Type access$6202(Type r100, Type r101) {
            r100.flexibleUpperBound_ = r101;
            return r101;
        }

        public static /* synthetic */ int access$6302(Type r100, int r101) {
            r100.flexibleUpperBoundId_ = r101;
            return r101;
        }

        public static /* synthetic */ int access$6402(Type r100, int r101) {
            r100.className_ = r101;
            return r101;
        }

        public static /* synthetic */ int access$6502(Type r100, int r101) {
            r100.typeParameter_ = r101;
            return r101;
        }

        public static /* synthetic */ int access$6602(Type r100, int r101) {
            r100.typeParameterName_ = r101;
            return r101;
        }

        public static /* synthetic */ int access$6702(Type r100, int r101) {
            r100.typeAliasName_ = r101;
            return r101;
        }

        public static /* synthetic */ Type access$6802(Type r100, Type r101) {
            r100.outerType_ = r101;
            return r101;
        }

        public static /* synthetic */ int access$6902(Type r100, int r101) {
            r100.outerTypeId_ = r101;
            return r101;
        }

        public static /* synthetic */ Type access$7002(Type r100, Type r101) {
            r100.abbreviatedType_ = r101;
            return r101;
        }

        public static /* synthetic */ int access$7102(Type r100, int r101) {
            r100.abbreviatedTypeId_ = r101;
            return r101;
        }

        public static /* synthetic */ int access$7202(Type r100, int r101) {
            r100.flags_ = r101;
            return r101;
        }

        public static /* synthetic */ int access$7302(Type r100, int r101) {
            r100.bitField0_ = r101;
            return r101;
        }

        public /* synthetic */ Type(GeneratedMessageLite.ExtendableBuilder r100, AnonymousClass1 r101) {
            this(r100);
        }

        public /* synthetic */ Type(CodedInputStream r100, ExtensionRegistryLite r101, AnonymousClass1 r102) throws InvalidProtocolBufferException {
            this(r100, r101);
        }
    }

    /* JADX INFO: loaded from: classes5.dex */
    public static final class TypeAlias extends GeneratedMessageLite.ExtendableMessage<TypeAlias> implements TypeAliasOrBuilder {
        public static Parser<TypeAlias> PARSER;
        private static final TypeAlias defaultInstance = null;
        private List<Annotation> annotation_;
        private int bitField0_;
        private int expandedTypeId_;
        private Type expandedType_;
        private int flags_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private List<TypeParameter> typeParameter_;
        private int underlyingTypeId_;
        private Type underlyingType_;
        private final ByteString unknownFields;
        private List<Integer> versionRequirement_;

        /* JADX INFO: loaded from: classes42.dex */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<TypeAlias, Builder> implements TypeAliasOrBuilder {
            private List<Annotation> annotation_;
            private int bitField0_;
            private int expandedTypeId_;
            private Type expandedType_;
            private int flags_;
            private int name_;
            private List<TypeParameter> typeParameter_;
            private int underlyingTypeId_;
            private Type underlyingType_;
            private List<Integer> versionRequirement_;

            private void maybeForceBuilderInitialization() {
            }

            private static Builder create() {
                return new Builder();
            }

            private void ensureAnnotationIsMutable() {
                if ((this.bitField0_ & 128) == 128) goto L6;
                this.annotation_ = new ArrayList(this.annotation_);
                this.bitField0_ |= 128;
                return;
            }

            private void ensureTypeParameterIsMutable() {
                if ((this.bitField0_ & 4) == 4) goto L6;
                this.typeParameter_ = new ArrayList(this.typeParameter_);
                this.bitField0_ |= 4;
                return;
            }

            private void ensureVersionRequirementIsMutable() {
                if ((this.bitField0_ & 256) == 256) goto L6;
                this.versionRequirement_ = new ArrayList(this.versionRequirement_);
                this.bitField0_ |= 256;
                return;
            }

            public TypeAlias buildPartial() {
                TypeAlias r100 = new TypeAlias(this, null);
                int r101 = this.bitField0_;
                int r102 = 1;
                if ((r101 & 1) == 1) goto L6;
                r102 = 0;
            L6:
                TypeAlias.access$19202(r100, this.flags_);
                if ((r101 & 2) != 2) goto L9;
                r102 = r102 | 2;
            L9:
                TypeAlias.access$19302(r100, this.name_);
                if ((this.bitField0_ & 4) != 4) goto L12;
                this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                this.bitField0_ &= -5;
            L12:
                TypeAlias.access$19402(r100, this.typeParameter_);
                if ((r101 & 8) != 8) goto L15;
                r102 = r102 | 4;
            L15:
                TypeAlias.access$19502(r100, this.underlyingType_);
                if ((r101 & 16) != 16) goto L18;
                r102 = r102 | 8;
            L18:
                TypeAlias.access$19602(r100, this.underlyingTypeId_);
                if ((r101 & 32) != 32) goto L21;
                r102 = r102 | 16;
            L21:
                TypeAlias.access$19702(r100, this.expandedType_);
                if ((r101 & 64) != 64) goto L24;
                r102 = r102 | 32;
            L24:
                TypeAlias.access$19802(r100, this.expandedTypeId_);
                if ((this.bitField0_ & 128) != 128) goto L27;
                this.annotation_ = Collections.unmodifiableList(this.annotation_);
                this.bitField0_ &= -129;
            L27:
                TypeAlias.access$19902(r100, this.annotation_);
                if ((this.bitField0_ & 256) != 256) goto L30;
                this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                this.bitField0_ &= -257;
            L30:
                TypeAlias.access$20002(r100, this.versionRequirement_);
                TypeAlias.access$20102(r100, r102);
                return r100;
            }

            public int getAnnotationCount() {
                return this.annotation_.size();
            }

            public int getTypeParameterCount() {
                return this.typeParameter_.size();
            }

            public boolean hasExpandedType() {
                if ((this.bitField0_ & 32) != 32) goto L5;
                return true;
            L5:
                return false;
            }

            public boolean hasName() {
                if ((this.bitField0_ & 2) != 2) goto L5;
                return true;
            L5:
                return false;
            }

            public boolean hasUnderlyingType() {
                if ((this.bitField0_ & 8) != 8) goto L5;
                return true;
            L5:
                return false;
            }

            private Builder() {
                this.flags_ = 6;
                this.typeParameter_ = Collections.emptyList();
                this.underlyingType_ = Type.getDefaultInstance();
                this.expandedType_ = Type.getDefaultInstance();
                this.annotation_ = Collections.emptyList();
                this.versionRequirement_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            public static /* synthetic */ Builder access$19000() {
                return create();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public TypeAlias build() {
                TypeAlias r100 = buildPartial();
                if (r100.isInitialized() == false) goto L6;
                return r100;
            L6:
                throw AbstractMessageLite.Builder.newUninitializedMessageException(r100);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public TypeAlias getDefaultInstanceForType() {
                return TypeAlias.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                if (hasName() == true) goto L5;
                return false;
            L5:
                int r100 = 0;
            L7:
                if (r100 >= getTypeParameterCount()) goto L13;
                if (getTypeParameter(r100).isInitialized() == false) goto L10;
                r100 = r100 + 1;
                goto L7
            L10:
                return false;
            L13:
                if (hasUnderlyingType() == false) goto L18;
                if (getUnderlyingType().isInitialized() == true) goto L18;
                return false;
            L18:
                if (hasExpandedType() == true) goto L20;
            L22:
                int r101 = 0;
            L24:
                if (r101 >= getAnnotationCount()) goto L30;
                if (getAnnotation(r101).isInitialized() == false) goto L27;
                r101 = r101 + 1;
                goto L24
            L27:
                return false;
            L30:
                if (extensionsAreInitialized() == true) goto L32;
                return false;
            L32:
                return true;
            L20:
                if (getExpandedType().isInitialized() == true) goto L22;
                return false;
            }

            public Type getExpandedType() {
                return this.expandedType_;
            }

            public Type getUnderlyingType() {
                return this.underlyingType_;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo10730clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.ExtendableBuilder clone() {
                return clone();
            }

            public Annotation getAnnotation(int r100) {
                return (Annotation) ListProtector.get(this.annotation_, r100);
            }

            public TypeParameter getTypeParameter(int r100) {
                return (TypeParameter) ListProtector.get(this.typeParameter_, r100);
            }

            public Builder mergeExpandedType(Type r100) {
                if ((this.bitField0_ & 32) == 32) goto L5;
            L7:
                this.expandedType_ = r100;
            L8:
                this.bitField0_ |= 32;
                return this;
            L5:
                if (this.expandedType_ == Type.getDefaultInstance()) goto L7;
                this.expandedType_ = Type.newBuilder(this.expandedType_).mergeFrom(r100).buildPartial();
                goto L8
            }

            public Builder mergeFrom(TypeAlias r100) {
                if (r100 != TypeAlias.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r100.hasFlags() == false) goto L9;
                setFlags(r100.getFlags());
            L9:
                if (r100.hasName() == false) goto L12;
                setName(r100.getName());
            L12:
                if (TypeAlias.access$19400(r100).isEmpty() == true) goto L18;
                if (this.typeParameter_.isEmpty() == false) goto L16;
                this.typeParameter_ = TypeAlias.access$19400(r100);
                this.bitField0_ &= -5;
                goto L18
            L16:
                ensureTypeParameterIsMutable();
                this.typeParameter_.addAll(TypeAlias.access$19400(r100));
            L18:
                if (r100.hasUnderlyingType() == false) goto L21;
                mergeUnderlyingType(r100.getUnderlyingType());
            L21:
                if (r100.hasUnderlyingTypeId() == false) goto L24;
                setUnderlyingTypeId(r100.getUnderlyingTypeId());
            L24:
                if (r100.hasExpandedType() == false) goto L27;
                mergeExpandedType(r100.getExpandedType());
            L27:
                if (r100.hasExpandedTypeId() == false) goto L30;
                setExpandedTypeId(r100.getExpandedTypeId());
            L30:
                if (TypeAlias.access$19900(r100).isEmpty() == true) goto L36;
                if (this.annotation_.isEmpty() == false) goto L34;
                this.annotation_ = TypeAlias.access$19900(r100);
                this.bitField0_ &= -129;
                goto L36
            L34:
                ensureAnnotationIsMutable();
                this.annotation_.addAll(TypeAlias.access$19900(r100));
            L36:
                if (TypeAlias.access$20000(r100).isEmpty() == false) goto L38;
            L41:
                mergeExtensionFields(r100);
                setUnknownFields(getUnknownFields().concat(TypeAlias.access$20200(r100)));
                return this;
            L38:
                if (this.versionRequirement_.isEmpty() == false) goto L40;
                this.versionRequirement_ = TypeAlias.access$20000(r100);
                this.bitField0_ &= -257;
                goto L41
            L40:
                ensureVersionRequirementIsMutable();
                this.versionRequirement_.addAll(TypeAlias.access$20000(r100));
                goto L41
            }

            public Builder mergeUnderlyingType(Type r100) {
                if ((this.bitField0_ & 8) == 8) goto L5;
            L7:
                this.underlyingType_ = r100;
            L8:
                this.bitField0_ |= 8;
                return this;
            L5:
                if (this.underlyingType_ == Type.getDefaultInstance()) goto L7;
                this.underlyingType_ = Type.newBuilder(this.underlyingType_).mergeFrom(r100).buildPartial();
                goto L8
            }

            public Builder setExpandedTypeId(int r100) {
                this.bitField0_ |= 64;
                this.expandedTypeId_ = r100;
                return this;
            }

            public Builder setFlags(int r100) {
                this.bitField0_ |= 1;
                this.flags_ = r100;
                return this;
            }

            public Builder setName(int r100) {
                this.bitField0_ |= 2;
                this.name_ = r100;
                return this;
            }

            public Builder setUnderlyingTypeId(int r100) {
                this.bitField0_ |= 16;
                this.underlyingTypeId_ = r100;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r100) {
                return mergeFrom((TypeAlias) r100);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
                TypeAlias r102 = null;
                TypeAlias r103 = TypeAlias.PARSER.parsePartialFrom(r100, r101);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r103 == null) goto L6;
                mergeFrom(r103);
            L6:
                return this;
            L9:
                e = move-exception;
                TypeAlias r104 = (TypeAlias) e.getUnfinishedMessage();     // Catch: Throwable -> L7
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
            this.flags_ = 6;
            this.name_ = 0;
            this.typeParameter_ = Collections.emptyList();
            this.underlyingType_ = Type.getDefaultInstance();
            this.underlyingTypeId_ = 0;
            this.expandedType_ = Type.getDefaultInstance();
            this.expandedTypeId_ = 0;
            this.annotation_ = Collections.emptyList();
            this.versionRequirement_ = Collections.emptyList();
        }

        static {
            PARSER = new AnonymousClass1();
            TypeAlias r100 = new TypeAlias(true);
            defaultInstance = r100;
            r100.initFields();
        }

        public int getAnnotationCount() {
            return this.annotation_.size();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int r100 = this.memoizedSerializedSize;
            if (r100 == (-1)) goto L5;
            return r100;
        L5:
            int r101 = 0;
            if ((this.bitField0_ & 1) != 1) goto L8;
            int r102 = CodedOutputStream.computeInt32Size(1, this.flags_) + 0;
        L10:
            if ((this.bitField0_ & 2) != 2) goto L12;
            r102 = r102 + CodedOutputStream.computeInt32Size(2, this.name_);
        L12:
            int r103 = 0;
        L14:
            if (r103 >= this.typeParameter_.size()) goto L17;
            r102 = r102 + CodedOutputStream.computeMessageSize(3, (MessageLite) ListProtector.get(this.typeParameter_, r103));
            r103 = r103 + 1;
            goto L14
        L17:
            if ((this.bitField0_ & 4) != 4) goto L20;
            r102 = r102 + CodedOutputStream.computeMessageSize(4, this.underlyingType_);
        L20:
            if ((this.bitField0_ & 8) != 8) goto L23;
            r102 = r102 + CodedOutputStream.computeInt32Size(5, this.underlyingTypeId_);
        L23:
            if ((this.bitField0_ & 16) != 16) goto L26;
            r102 = r102 + CodedOutputStream.computeMessageSize(6, this.expandedType_);
        L26:
            if ((this.bitField0_ & 32) != 32) goto L28;
            r102 = r102 + CodedOutputStream.computeInt32Size(7, this.expandedTypeId_);
        L28:
            int r104 = 0;
        L30:
            if (r104 >= this.annotation_.size()) goto L32;
            r102 = r102 + CodedOutputStream.computeMessageSize(8, (MessageLite) ListProtector.get(this.annotation_, r104));
            r104 = r104 + 1;
            goto L30
        L32:
            int r105 = 0;
        L34:
            if (r101 >= this.versionRequirement_.size()) goto L36;
            r105 = r105 + CodedOutputStream.computeInt32SizeNoTag(((Integer) ListProtector.get(this.versionRequirement_, r101)).intValue());
            r101 = r101 + 1;
            goto L34
        L36:
            int r106 = (((r102 + r105) + (getVersionRequirementList().size() * 2)) + extensionsSerializedSize()) + this.unknownFields.size();
            this.memoizedSerializedSize = r106;
            return r106;
        L8:
            r102 = 0;
            goto L10
        }

        public int getTypeParameterCount() {
            return this.typeParameter_.size();
        }

        public boolean hasExpandedType() {
            if ((this.bitField0_ & 16) != 16) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasExpandedTypeId() {
            if ((this.bitField0_ & 32) != 32) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasFlags() {
            if ((this.bitField0_ & 1) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        public boolean hasName() {
            if ((this.bitField0_ & 2) != 2) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasUnderlyingType() {
            if ((this.bitField0_ & 4) != 4) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasUnderlyingTypeId() {
            if ((this.bitField0_ & 8) != 8) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte r100 = this.memoizedIsInitialized;
            if (r100 != 1) goto L6;
            return true;
        L6:
            if (r100 != 0) goto L9;
            return false;
        L9:
            if (hasName() == true) goto L12;
            this.memoizedIsInitialized = 0;
            return false;
        L12:
            int r101 = 0;
        L14:
            if (r101 >= getTypeParameterCount()) goto L21;
            if (getTypeParameter(r101).isInitialized() == false) goto L17;
            r101 = r101 + 1;
            goto L14
        L17:
            this.memoizedIsInitialized = 0;
            return false;
        L21:
            if (hasUnderlyingType() == false) goto L27;
            if (getUnderlyingType().isInitialized() == true) goto L27;
            this.memoizedIsInitialized = 0;
            return false;
        L27:
            if (hasExpandedType() == true) goto L29;
        L32:
            int r102 = 0;
        L34:
            if (r102 >= getAnnotationCount()) goto L41;
            if (getAnnotation(r102).isInitialized() == false) goto L37;
            r102 = r102 + 1;
            goto L34
        L37:
            this.memoizedIsInitialized = 0;
            return false;
        L41:
            if (extensionsAreInitialized() == true) goto L44;
            this.memoizedIsInitialized = 0;
            return false;
        L44:
            this.memoizedIsInitialized = 1;
            return true;
        L29:
            if (getExpandedType().isInitialized() == true) goto L32;
            this.memoizedIsInitialized = 0;
            return false;
        }

        public static Builder newBuilder() {
            return Builder.access$19000();
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

        public static TypeAlias getDefaultInstance() {
            return defaultInstance;
        }

        public List<Annotation> getAnnotationList() {
            return this.annotation_;
        }

        public Type getExpandedType() {
            return this.expandedType_;
        }

        public int getExpandedTypeId() {
            return this.expandedTypeId_;
        }

        public int getFlags() {
            return this.flags_;
        }

        public int getName() {
            return this.name_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<TypeAlias> getParserForType() {
            return PARSER;
        }

        public List<TypeParameter> getTypeParameterList() {
            return this.typeParameter_;
        }

        public Type getUnderlyingType() {
            return this.underlyingType_;
        }

        public int getUnderlyingTypeId() {
            return this.underlyingTypeId_;
        }

        public List<Integer> getVersionRequirementList() {
            return this.versionRequirement_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public TypeAlias getDefaultInstanceForType() {
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

        private TypeAlias(GeneratedMessageLite.ExtendableBuilder<TypeAlias, ?> r100) {
            super(r100);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r100.getUnknownFields();
        }

        public static /* synthetic */ List access$19400(TypeAlias r100) {
            return r100.typeParameter_;
        }

        public static /* synthetic */ List access$19900(TypeAlias r100) {
            return r100.annotation_;
        }

        public static /* synthetic */ List access$20000(TypeAlias r100) {
            return r100.versionRequirement_;
        }

        public static /* synthetic */ ByteString access$20200(TypeAlias r100) {
            return r100.unknownFields;
        }

        public static Builder newBuilder(TypeAlias r100) {
            return newBuilder().mergeFrom(r100);
        }

        public Annotation getAnnotation(int r100) {
            return (Annotation) ListProtector.get(this.annotation_, r100);
        }

        public TypeParameter getTypeParameter(int r100) {
            return (TypeParameter) ListProtector.get(this.typeParameter_, r100);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r100) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter r101 = newExtensionWriter();
            if ((this.bitField0_ & 1) != 1) goto L6;
            r100.writeInt32(1, this.flags_);
        L6:
            if ((this.bitField0_ & 2) != 2) goto L8;
            r100.writeInt32(2, this.name_);
        L8:
            int r102 = 0;
            int r103 = 0;
        L10:
            if (r103 >= this.typeParameter_.size()) goto L13;
            r100.writeMessage(3, (MessageLite) ListProtector.get(this.typeParameter_, r103));
            r103 = r103 + 1;
            goto L10
        L13:
            if ((this.bitField0_ & 4) != 4) goto L16;
            r100.writeMessage(4, this.underlyingType_);
        L16:
            if ((this.bitField0_ & 8) != 8) goto L19;
            r100.writeInt32(5, this.underlyingTypeId_);
        L19:
            if ((this.bitField0_ & 16) != 16) goto L22;
            r100.writeMessage(6, this.expandedType_);
        L22:
            if ((this.bitField0_ & 32) != 32) goto L24;
            r100.writeInt32(7, this.expandedTypeId_);
        L24:
            int r104 = 0;
        L26:
            if (r104 >= this.annotation_.size()) goto L29;
            r100.writeMessage(8, (MessageLite) ListProtector.get(this.annotation_, r104));
            r104 = r104 + 1;
        L29:
            if (r102 >= this.versionRequirement_.size()) goto L31;
            r100.writeInt32(31, ((Integer) ListProtector.get(this.versionRequirement_, r102)).intValue());
            r102 = r102 + 1;
            goto L29
        L31:
            r101.writeUntil(200, r100);
            r100.writeRawBytes(this.unknownFields);
        }

        private TypeAlias(boolean r100) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        private TypeAlias(CodedInputStream r110, ExtensionRegistryLite r111) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r100 = ByteString.newOutput();
            CodedOutputStream r101 = CodedOutputStream.newInstance(r100, 1);
            boolean r102 = false;
            int r103 = 0;
        L4:
            if (r102 == true) goto L76;
            int r104 = r110.readTag();     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
            Type.Builder r105 = null;
            switch(r104) {
                case 0: goto L48;
                case 8: goto L46;
                case 16: goto L45;
                case 26: goto L42;
                case 34: goto L35;
                case 40: goto L33;
                case 50: goto L27;
                case 56: goto L25;
                case 66: goto L22;
                case 248: goto L18;
                case 250: goto L8;
                default: goto L49;
            };     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
        L8:
            int r106 = r110.pushLimit(r110.readRawVarint32());     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
            if ((r103 & 256) == 256) goto L14;
            if (r110.getBytesUntilLimit() <= 0) goto L14;
            this.versionRequirement_ = new ArrayList();     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
            r103 = r103 | 256;     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
        L14:
            if (r110.getBytesUntilLimit() <= 0) goto L16;
            this.versionRequirement_.add(Integer.valueOf(r110.readInt32()));     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
            goto L14
        L16:
            r110.popLimit(r106);     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
            goto L4
        L18:
            if ((r103 & 256) == 256) goto L20;
            this.versionRequirement_ = new ArrayList();     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
            r103 = r103 | 256;     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
        L20:
            this.versionRequirement_.add(Integer.valueOf(r110.readInt32()));     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
            goto L4
        L22:
            if ((r103 & 128) == 128) goto L24;
            this.annotation_ = new ArrayList();     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
            r103 = r103 | 128;     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
        L24:
            this.annotation_.add((Annotation) r110.readMessage(Annotation.PARSER, r111));     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
            goto L4
        L25:
            this.bitField0_ |= 32;     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
            this.expandedTypeId_ = r110.readInt32();     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
            goto L4
        L27:
            if ((this.bitField0_ & 16) != 16) goto L29;
            r105 = this.expandedType_.toBuilder();     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
        L29:
            Type r107 = (Type) r110.readMessage(Type.PARSER, r111);     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
            this.expandedType_ = r107;     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
            if (r105 == null) goto L32;
            r105.mergeFrom(r107);     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
            this.expandedType_ = r105.buildPartial();     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
        L32:
            this.bitField0_ |= 16;     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
            goto L4
        L33:
            this.bitField0_ |= 8;     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
            this.underlyingTypeId_ = r110.readInt32();     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
            goto L4
        L35:
            if ((this.bitField0_ & 4) != 4) goto L37;
            r105 = this.underlyingType_.toBuilder();     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
        L37:
            Type r108 = (Type) r110.readMessage(Type.PARSER, r111);     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
            this.underlyingType_ = r108;     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
            if (r105 == null) goto L40;
            r105.mergeFrom(r108);     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
            this.underlyingType_ = r105.buildPartial();     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
        L40:
            this.bitField0_ |= 4;     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
            goto L4
        L42:
            if ((r103 & 4) == 4) goto L44;
            this.typeParameter_ = new ArrayList();     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
            r103 = r103 | 4;     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
        L44:
            this.typeParameter_.add((TypeParameter) r110.readMessage(TypeParameter.PARSER, r111));     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
            goto L4
        L45:
            this.bitField0_ |= 2;     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
            this.name_ = r110.readInt32();     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
            goto L4
        L46:
            this.bitField0_ |= 1;     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
            this.flags_ = r110.readInt32();     // Catch: Throwable -> L51 IOException -> L53 InvalidProtocolBufferException -> L56
        L48:
            r102 = true;
            goto L4
        L49:
            if (parseUnknownField(r110, r101, r111, r104) == true) goto L4;
        L51:
            th = move-exception;
            if ((r103 & 4) != 4) goto L63;
            this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
        L63:
            if ((r103 & 128) != 128) goto L66;
            this.annotation_ = Collections.unmodifiableList(this.annotation_);
        L66:
            if ((r103 & 256) != 256) goto L95;
            this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
        L95:
            r101.flush();     // Catch: IOException -> L92 Throwable -> L70
        L70:
            th = move-exception;
            this.unknownFields = r100.toByteString();
            throw th;
        L69:
            this.unknownFields = r100.toByteString();
            makeExtensionsImmutable();
            throw th;
        L53:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L51
        L56:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L51
        L76:
            if ((r103 & 4) != 4) goto L79;
            this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
        L79:
            if ((r103 & 128) != 128) goto L82;
            this.annotation_ = Collections.unmodifiableList(this.annotation_);
        L82:
            if ((r103 & 256) != 256) goto L97;
            this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
        L97:
            r101.flush();     // Catch: IOException -> L91 Throwable -> L86
        L86:
            th = move-exception;
            this.unknownFields = r100.toByteString();
            throw th;
        L85:
            this.unknownFields = r100.toByteString();
            makeExtensionsImmutable();
        }

        public static /* synthetic */ int access$19202(TypeAlias r100, int r101) {
            r100.flags_ = r101;
            return r101;
        }

        public static /* synthetic */ int access$19302(TypeAlias r100, int r101) {
            r100.name_ = r101;
            return r101;
        }

        public static /* synthetic */ List access$19402(TypeAlias r100, List r101) {
            r100.typeParameter_ = r101;
            return r101;
        }

        public static /* synthetic */ Type access$19502(TypeAlias r100, Type r101) {
            r100.underlyingType_ = r101;
            return r101;
        }

        public static /* synthetic */ int access$19602(TypeAlias r100, int r101) {
            r100.underlyingTypeId_ = r101;
            return r101;
        }

        public static /* synthetic */ Type access$19702(TypeAlias r100, Type r101) {
            r100.expandedType_ = r101;
            return r101;
        }

        public static /* synthetic */ int access$19802(TypeAlias r100, int r101) {
            r100.expandedTypeId_ = r101;
            return r101;
        }

        public static /* synthetic */ List access$19902(TypeAlias r100, List r101) {
            r100.annotation_ = r101;
            return r101;
        }

        public static /* synthetic */ List access$20002(TypeAlias r100, List r101) {
            r100.versionRequirement_ = r101;
            return r101;
        }

        public static /* synthetic */ int access$20102(TypeAlias r100, int r101) {
            r100.bitField0_ = r101;
            return r101;
        }

        public static TypeAlias parseDelimitedFrom(InputStream r100, ExtensionRegistryLite r101) throws IOException {
            return PARSER.parseDelimitedFrom(r100, r101);
        }

        public /* synthetic */ TypeAlias(GeneratedMessageLite.ExtendableBuilder r100, AnonymousClass1 r101) {
            this(r100);
        }

        public /* synthetic */ TypeAlias(CodedInputStream r100, ExtensionRegistryLite r101, AnonymousClass1 r102) throws InvalidProtocolBufferException {
            this(r100, r101);
        }
    }

    /* JADX INFO: loaded from: classes5.dex */
    public interface TypeAliasOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder {
    }

    /* JADX INFO: loaded from: classes5.dex */
    public interface TypeOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder {
    }

    /* JADX INFO: loaded from: classes5.dex */
    public static final class TypeParameter extends GeneratedMessageLite.ExtendableMessage<TypeParameter> implements TypeParameterOrBuilder {
        public static Parser<TypeParameter> PARSER;
        private static final TypeParameter defaultInstance = null;
        private int bitField0_;
        private int id_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private boolean reified_;
        private final ByteString unknownFields;
        private int upperBoundIdMemoizedSerializedSize;
        private List<Integer> upperBoundId_;
        private List<Type> upperBound_;
        private Variance variance_;

        /* JADX INFO: loaded from: classes42.dex */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<TypeParameter, Builder> implements TypeParameterOrBuilder {
            private int bitField0_;
            private int id_;
            private int name_;
            private boolean reified_;
            private List<Integer> upperBoundId_;
            private List<Type> upperBound_;
            private Variance variance_;

            private void maybeForceBuilderInitialization() {
            }

            private static Builder create() {
                return new Builder();
            }

            private void ensureUpperBoundIdIsMutable() {
                if ((this.bitField0_ & 32) == 32) goto L6;
                this.upperBoundId_ = new ArrayList(this.upperBoundId_);
                this.bitField0_ |= 32;
                return;
            }

            private void ensureUpperBoundIsMutable() {
                if ((this.bitField0_ & 16) == 16) goto L6;
                this.upperBound_ = new ArrayList(this.upperBound_);
                this.bitField0_ |= 16;
                return;
            }

            public TypeParameter buildPartial() {
                TypeParameter r100 = new TypeParameter(this, null);
                int r101 = this.bitField0_;
                int r102 = 1;
                if ((r101 & 1) == 1) goto L6;
                r102 = 0;
            L6:
                TypeParameter.access$7802(r100, this.id_);
                if ((r101 & 2) != 2) goto L9;
                r102 = r102 | 2;
            L9:
                TypeParameter.access$7902(r100, this.name_);
                if ((r101 & 4) != 4) goto L12;
                r102 = r102 | 4;
            L12:
                TypeParameter.access$8002(r100, this.reified_);
                if ((r101 & 8) != 8) goto L15;
                r102 = r102 | 8;
            L15:
                TypeParameter.access$8102(r100, this.variance_);
                if ((this.bitField0_ & 16) != 16) goto L18;
                this.upperBound_ = Collections.unmodifiableList(this.upperBound_);
                this.bitField0_ &= -17;
            L18:
                TypeParameter.access$8202(r100, this.upperBound_);
                if ((this.bitField0_ & 32) != 32) goto L21;
                this.upperBoundId_ = Collections.unmodifiableList(this.upperBoundId_);
                this.bitField0_ &= -33;
            L21:
                TypeParameter.access$8302(r100, this.upperBoundId_);
                TypeParameter.access$8402(r100, r102);
                return r100;
            }

            public int getUpperBoundCount() {
                return this.upperBound_.size();
            }

            public boolean hasId() {
                if ((this.bitField0_ & 1) == 1) goto L7;
                return false;
            L7:
                return true;
            }

            public boolean hasName() {
                if ((this.bitField0_ & 2) != 2) goto L5;
                return true;
            L5:
                return false;
            }

            private Builder() {
                this.variance_ = Variance.INV;
                this.upperBound_ = Collections.emptyList();
                this.upperBoundId_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            public static /* synthetic */ Builder access$7600() {
                return create();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public TypeParameter build() {
                TypeParameter r100 = buildPartial();
                if (r100.isInitialized() == false) goto L6;
                return r100;
            L6:
                throw AbstractMessageLite.Builder.newUninitializedMessageException(r100);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public TypeParameter getDefaultInstanceForType() {
                return TypeParameter.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                if (hasId() == true) goto L6;
                return false;
            L6:
                if (hasName() == true) goto L8;
                return false;
            L8:
                int r100 = 0;
            L10:
                if (r100 >= getUpperBoundCount()) goto L16;
                if (getUpperBound(r100).isInitialized() == false) goto L13;
                r100 = r100 + 1;
                goto L10
            L13:
                return false;
            L16:
                if (extensionsAreInitialized() == true) goto L18;
                return false;
            L18:
                return true;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo10730clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.ExtendableBuilder clone() {
                return clone();
            }

            public Type getUpperBound(int r100) {
                return (Type) ListProtector.get(this.upperBound_, r100);
            }

            public Builder mergeFrom(TypeParameter r100) {
                if (r100 != TypeParameter.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r100.hasId() == false) goto L9;
                setId(r100.getId());
            L9:
                if (r100.hasName() == false) goto L12;
                setName(r100.getName());
            L12:
                if (r100.hasReified() == false) goto L15;
                setReified(r100.getReified());
            L15:
                if (r100.hasVariance() == false) goto L18;
                setVariance(r100.getVariance());
            L18:
                if (TypeParameter.access$8200(r100).isEmpty() == true) goto L24;
                if (this.upperBound_.isEmpty() == false) goto L22;
                this.upperBound_ = TypeParameter.access$8200(r100);
                this.bitField0_ &= -17;
                goto L24
            L22:
                ensureUpperBoundIsMutable();
                this.upperBound_.addAll(TypeParameter.access$8200(r100));
            L24:
                if (TypeParameter.access$8300(r100).isEmpty() == false) goto L26;
            L29:
                mergeExtensionFields(r100);
                setUnknownFields(getUnknownFields().concat(TypeParameter.access$8500(r100)));
                return this;
            L26:
                if (this.upperBoundId_.isEmpty() == false) goto L28;
                this.upperBoundId_ = TypeParameter.access$8300(r100);
                this.bitField0_ &= -33;
                goto L29
            L28:
                ensureUpperBoundIdIsMutable();
                this.upperBoundId_.addAll(TypeParameter.access$8300(r100));
                goto L29
            }

            public Builder setId(int r100) {
                this.bitField0_ |= 1;
                this.id_ = r100;
                return this;
            }

            public Builder setName(int r100) {
                this.bitField0_ |= 2;
                this.name_ = r100;
                return this;
            }

            public Builder setReified(boolean r100) {
                this.bitField0_ |= 4;
                this.reified_ = r100;
                return this;
            }

            public Builder setVariance(Variance r100) {
                if (r100 == null) goto L6;
                this.bitField0_ |= 8;
                this.variance_ = r100;
                return this;
            L6:
                throw null;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r100) {
                return mergeFrom((TypeParameter) r100);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
                TypeParameter r102 = null;
                TypeParameter r103 = TypeParameter.PARSER.parsePartialFrom(r100, r101);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r103 == null) goto L6;
                mergeFrom(r103);
            L6:
                return this;
            L9:
                e = move-exception;
                TypeParameter r104 = (TypeParameter) e.getUnfinishedMessage();     // Catch: Throwable -> L7
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

        public static final enum Variance extends Enum<Variance> implements Internal.EnumLite {
            private static final /* synthetic */ Variance[] $VALUES = null;
            public static final Variance IN = null;
            public static final Variance INV = null;
            public static final Variance OUT = null;
            private static Internal.EnumLiteMap<Variance> internalValueMap;
            private final int value;

            static {
                Variance r100 = new Variance("IN", 0, 0, 0);
                IN = r100;
                Variance r101 = new Variance("OUT", 1, 1, 1);
                OUT = r101;
                Variance r102 = new Variance("INV", 2, 2, 2);
                INV = r102;
                $VALUES = new Variance[]{r100, r101, r102};
                internalValueMap = new AnonymousClass1();
            }

            public static Variance[] values() {
                return (Variance[]) $VALUES.clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            public static Variance valueOf(int r100) {
                if (r100 == 0) goto L14;
                if (r100 == 1) goto L12;
                if (r100 == 2) goto L10;
                return null;
            L10:
                return INV;
            L12:
                return OUT;
            L14:
                return IN;
            }

            public static Variance valueOf(String r100) {
                return (Variance) a.a(Variance.class, r100);
            }

            private Variance(String r100, int r101, int r102, int r103) {
                super(r100, r101);
                this.value = r103;
            }
        }

        private void initFields() {
            this.id_ = 0;
            this.name_ = 0;
            this.reified_ = false;
            this.variance_ = Variance.INV;
            this.upperBound_ = Collections.emptyList();
            this.upperBoundId_ = Collections.emptyList();
        }

        static {
            PARSER = new AnonymousClass1();
            TypeParameter r100 = new TypeParameter(true);
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
            if ((this.bitField0_ & 1) != 1) goto L8;
            int r102 = CodedOutputStream.computeInt32Size(1, this.id_) + 0;
        L10:
            if ((this.bitField0_ & 2) != 2) goto L13;
            r102 = r102 + CodedOutputStream.computeInt32Size(2, this.name_);
        L13:
            if ((this.bitField0_ & 4) != 4) goto L16;
            r102 = r102 + CodedOutputStream.computeBoolSize(3, this.reified_);
        L16:
            if ((this.bitField0_ & 8) != 8) goto L18;
            r102 = r102 + CodedOutputStream.computeEnumSize(4, this.variance_.getNumber());
        L18:
            int r103 = 0;
        L20:
            if (r103 >= this.upperBound_.size()) goto L22;
            r102 = r102 + CodedOutputStream.computeMessageSize(5, (MessageLite) ListProtector.get(this.upperBound_, r103));
            r103 = r103 + 1;
            goto L20
        L22:
            int r104 = 0;
        L24:
            if (r101 >= this.upperBoundId_.size()) goto L26;
            r104 = r104 + CodedOutputStream.computeInt32SizeNoTag(((Integer) ListProtector.get(this.upperBoundId_, r101)).intValue());
            r101 = r101 + 1;
            goto L24
        L26:
            int r105 = r102 + r104;
            if (getUpperBoundIdList().isEmpty() == true) goto L29;
            r105 = (r105 + 1) + CodedOutputStream.computeInt32SizeNoTag(r104);
        L29:
            this.upperBoundIdMemoizedSerializedSize = r104;
            int r106 = (r105 + extensionsSerializedSize()) + this.unknownFields.size();
            this.memoizedSerializedSize = r106;
            return r106;
        L8:
            r102 = 0;
            goto L10
        }

        public int getUpperBoundCount() {
            return this.upperBound_.size();
        }

        public boolean hasId() {
            if ((this.bitField0_ & 1) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        public boolean hasName() {
            if ((this.bitField0_ & 2) != 2) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasReified() {
            if ((this.bitField0_ & 4) != 4) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasVariance() {
            if ((this.bitField0_ & 8) != 8) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte r100 = this.memoizedIsInitialized;
            if (r100 != 1) goto L6;
            return true;
        L6:
            if (r100 != 0) goto L9;
            return false;
        L9:
            if (hasId() == true) goto L13;
            this.memoizedIsInitialized = 0;
            return false;
        L13:
            if (hasName() == true) goto L16;
            this.memoizedIsInitialized = 0;
            return false;
        L16:
            int r101 = 0;
        L18:
            if (r101 >= getUpperBoundCount()) goto L25;
            if (getUpperBound(r101).isInitialized() == false) goto L21;
            r101 = r101 + 1;
            goto L18
        L21:
            this.memoizedIsInitialized = 0;
            return false;
        L25:
            if (extensionsAreInitialized() == true) goto L28;
            this.memoizedIsInitialized = 0;
            return false;
        L28:
            this.memoizedIsInitialized = 1;
            return true;
        }

        public static Builder newBuilder() {
            return Builder.access$7600();
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

        public static TypeParameter getDefaultInstance() {
            return defaultInstance;
        }

        public int getId() {
            return this.id_;
        }

        public int getName() {
            return this.name_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<TypeParameter> getParserForType() {
            return PARSER;
        }

        public boolean getReified() {
            return this.reified_;
        }

        public List<Integer> getUpperBoundIdList() {
            return this.upperBoundId_;
        }

        public List<Type> getUpperBoundList() {
            return this.upperBound_;
        }

        public Variance getVariance() {
            return this.variance_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public TypeParameter getDefaultInstanceForType() {
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

        private TypeParameter(GeneratedMessageLite.ExtendableBuilder<TypeParameter, ?> r100) {
            super(r100);
            this.upperBoundIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r100.getUnknownFields();
        }

        public static /* synthetic */ List access$8200(TypeParameter r100) {
            return r100.upperBound_;
        }

        public static /* synthetic */ List access$8300(TypeParameter r100) {
            return r100.upperBoundId_;
        }

        public static /* synthetic */ ByteString access$8500(TypeParameter r100) {
            return r100.unknownFields;
        }

        public static Builder newBuilder(TypeParameter r100) {
            return newBuilder().mergeFrom(r100);
        }

        public Type getUpperBound(int r100) {
            return (Type) ListProtector.get(this.upperBound_, r100);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r100) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter r101 = newExtensionWriter();
            if ((this.bitField0_ & 1) != 1) goto L6;
            r100.writeInt32(1, this.id_);
        L6:
            if ((this.bitField0_ & 2) != 2) goto L9;
            r100.writeInt32(2, this.name_);
        L9:
            if ((this.bitField0_ & 4) != 4) goto L12;
            r100.writeBool(3, this.reified_);
        L12:
            if ((this.bitField0_ & 8) != 8) goto L14;
            r100.writeEnum(4, this.variance_.getNumber());
        L14:
            int r102 = 0;
            int r103 = 0;
        L16:
            if (r103 >= this.upperBound_.size()) goto L19;
            r100.writeMessage(5, (MessageLite) ListProtector.get(this.upperBound_, r103));
            r103 = r103 + 1;
            goto L16
        L19:
            if (getUpperBoundIdList().size() <= 0) goto L22;
            r100.writeRawVarint32(50);
            r100.writeRawVarint32(this.upperBoundIdMemoizedSerializedSize);
        L22:
            if (r102 >= this.upperBoundId_.size()) goto L24;
            r100.writeInt32NoTag(((Integer) ListProtector.get(this.upperBoundId_, r102)).intValue());
            r102 = r102 + 1;
            goto L22
        L24:
            r101.writeUntil(1000, r100);
            r100.writeRawBytes(this.unknownFields);
        }

        private TypeParameter(boolean r100) {
            this.upperBoundIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        private TypeParameter(CodedInputStream r110, ExtensionRegistryLite r111) throws InvalidProtocolBufferException {
            this.upperBoundIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r100 = ByteString.newOutput();
            CodedOutputStream r101 = CodedOutputStream.newInstance(r100, 1);
            boolean r102 = false;
            int r103 = 0;
        L4:
            if (r102 == true) goto L70;
            int r104 = r110.readTag();     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
            if (r104 == 0) goto L47;
            if (r104 != 8) goto L9;
            this.bitField0_ |= 1;     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
            this.id_ = r110.readInt32();     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
            goto L4
        L9:
            if (r104 != 16) goto L11;
            this.bitField0_ |= 2;     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
            this.name_ = r110.readInt32();     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
            goto L4
        L11:
            if (r104 != 24) goto L12;
            this.bitField0_ |= 4;     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
            this.reified_ = r110.readBool();     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
            goto L4
        L12:
            if (r104 != 32) goto L14;
            int r105 = r110.readEnum();     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
            Variance r112 = Variance.valueOf(r105);     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
            if (r112 == null) goto L41;
            this.bitField0_ |= 8;     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
            this.variance_ = r112;     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
            goto L4
        L41:
            r101.writeRawVarint32(r104);     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
            r101.writeRawVarint32(r105);     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
            goto L4
        L14:
            if (r104 != 42) goto L16;
            if ((r103 & 16) == 16) goto L38;
            this.upperBound_ = new ArrayList();     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
            r103 = r103 | 16;     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
        L38:
            this.upperBound_.add((Type) r110.readMessage(Type.PARSER, r111));     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
            goto L4
        L16:
            if (r104 != 48) goto L18;
            if ((r103 & 32) == 32) goto L34;
            this.upperBoundId_ = new ArrayList();     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
            r103 = r103 | 32;     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
        L34:
            this.upperBoundId_.add(Integer.valueOf(r110.readInt32()));     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
            goto L4
        L18:
            if (r104 != 50) goto L20;
            int r106 = r110.pushLimit(r110.readRawVarint32());     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
            if ((r103 & 32) == 32) goto L28;
            if (r110.getBytesUntilLimit() <= 0) goto L28;
            this.upperBoundId_ = new ArrayList();     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
            r103 = r103 | 32;     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
        L28:
            if (r110.getBytesUntilLimit() <= 0) goto L30;
            this.upperBoundId_.add(Integer.valueOf(r110.readInt32()));     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
            goto L28
        L30:
            r110.popLimit(r106);     // Catch: Throwable -> L48 IOException -> L50 InvalidProtocolBufferException -> L53
            goto L4
        L20:
            if (parseUnknownField(r110, r101, r111, r104) == true) goto L4;
        L47:
            r102 = true;
            goto L4
        L48:
            th = move-exception;
            if ((r103 & 16) != 16) goto L60;
            this.upperBound_ = Collections.unmodifiableList(this.upperBound_);
        L60:
            if ((r103 & 32) != 32) goto L86;
            this.upperBoundId_ = Collections.unmodifiableList(this.upperBoundId_);
        L86:
            r101.flush();     // Catch: IOException -> L83 Throwable -> L64
        L64:
            th = move-exception;
            this.unknownFields = r100.toByteString();
            throw th;
        L63:
            this.unknownFields = r100.toByteString();
            makeExtensionsImmutable();
            throw th;
        L50:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L48
        L53:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L48
        L70:
            if ((r103 & 16) != 16) goto L73;
            this.upperBound_ = Collections.unmodifiableList(this.upperBound_);
        L73:
            if ((r103 & 32) != 32) goto L88;
            this.upperBoundId_ = Collections.unmodifiableList(this.upperBoundId_);
        L88:
            r101.flush();     // Catch: IOException -> L82 Throwable -> L77
        L77:
            th = move-exception;
            this.unknownFields = r100.toByteString();
            throw th;
        L76:
            this.unknownFields = r100.toByteString();
            makeExtensionsImmutable();
        }

        public static /* synthetic */ int access$7802(TypeParameter r100, int r101) {
            r100.id_ = r101;
            return r101;
        }

        public static /* synthetic */ int access$7902(TypeParameter r100, int r101) {
            r100.name_ = r101;
            return r101;
        }

        public static /* synthetic */ boolean access$8002(TypeParameter r100, boolean r101) {
            r100.reified_ = r101;
            return r101;
        }

        public static /* synthetic */ Variance access$8102(TypeParameter r100, Variance r101) {
            r100.variance_ = r101;
            return r101;
        }

        public static /* synthetic */ List access$8202(TypeParameter r100, List r101) {
            r100.upperBound_ = r101;
            return r101;
        }

        public static /* synthetic */ List access$8302(TypeParameter r100, List r101) {
            r100.upperBoundId_ = r101;
            return r101;
        }

        public static /* synthetic */ int access$8402(TypeParameter r100, int r101) {
            r100.bitField0_ = r101;
            return r101;
        }

        public /* synthetic */ TypeParameter(GeneratedMessageLite.ExtendableBuilder r100, AnonymousClass1 r101) {
            this(r100);
        }

        public /* synthetic */ TypeParameter(CodedInputStream r100, ExtensionRegistryLite r101, AnonymousClass1 r102) throws InvalidProtocolBufferException {
            this(r100, r101);
        }
    }

    /* JADX INFO: loaded from: classes5.dex */
    public interface TypeParameterOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder {
    }

    /* JADX INFO: loaded from: classes5.dex */
    public static final class TypeTable extends GeneratedMessageLite implements TypeTableOrBuilder {
        public static Parser<TypeTable> PARSER;
        private static final TypeTable defaultInstance = null;
        private int bitField0_;
        private int firstNullable_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<Type> type_;
        private final ByteString unknownFields;

        public static final class Builder extends GeneratedMessageLite.Builder<TypeTable, Builder> implements TypeTableOrBuilder {
            private int bitField0_;
            private int firstNullable_;
            private List<Type> type_;

            private void maybeForceBuilderInitialization() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                int r100 = 0;
            L4:
                if (r100 >= getTypeCount()) goto L9;
                if (getType(r100).isInitialized() == false) goto L7;
                r100 = r100 + 1;
                goto L4
            L7:
                return false;
            L9:
                return true;
            }

            private static Builder create() {
                return new Builder();
            }

            private void ensureTypeIsMutable() {
                if ((this.bitField0_ & 1) == 1) goto L6;
                this.type_ = new ArrayList(this.type_);
                this.bitField0_ |= 1;
                return;
            }

            public TypeTable buildPartial() {
                TypeTable r100 = new TypeTable(this, null);
                int r101 = this.bitField0_;
                int r102 = 1;
                if ((r101 & 1) != 1) goto L5;
                this.type_ = Collections.unmodifiableList(this.type_);
                this.bitField0_ &= -2;
            L5:
                TypeTable.access$12802(r100, this.type_);
                if ((r101 & 2) == 2) goto L9;
                r102 = 0;
            L9:
                TypeTable.access$12902(r100, this.firstNullable_);
                TypeTable.access$13002(r100, r102);
                return r100;
            }

            public int getTypeCount() {
                return this.type_.size();
            }

            private Builder() {
                this.type_ = Collections.emptyList();
                this.firstNullable_ = -1;
                maybeForceBuilderInitialization();
            }

            public static /* synthetic */ Builder access$12600() {
                return create();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public TypeTable build() {
                TypeTable r100 = buildPartial();
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
            public TypeTable getDefaultInstanceForType() {
                return TypeTable.getDefaultInstance();
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

            public Type getType(int r100) {
                return (Type) ListProtector.get(this.type_, r100);
            }

            public Builder mergeFrom(TypeTable r100) {
                if (r100 != TypeTable.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (TypeTable.access$12800(r100).isEmpty() == true) goto L12;
                if (this.type_.isEmpty() == false) goto L10;
                this.type_ = TypeTable.access$12800(r100);
                this.bitField0_ &= -2;
                goto L12
            L10:
                ensureTypeIsMutable();
                this.type_.addAll(TypeTable.access$12800(r100));
            L12:
                if (r100.hasFirstNullable() == false) goto L14;
                setFirstNullable(r100.getFirstNullable());
            L14:
                setUnknownFields(getUnknownFields().concat(TypeTable.access$13100(r100)));
                return this;
            }

            public Builder setFirstNullable(int r100) {
                this.bitField0_ |= 2;
                this.firstNullable_ = r100;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r100) {
                return mergeFrom((TypeTable) r100);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
                TypeTable r102 = null;
                TypeTable r103 = TypeTable.PARSER.parsePartialFrom(r100, r101);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r103 == null) goto L6;
                mergeFrom(r103);
            L6:
                return this;
            L9:
                e = move-exception;
                TypeTable r104 = (TypeTable) e.getUnfinishedMessage();     // Catch: Throwable -> L7
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
            TypeTable r100 = new TypeTable(true);
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
        L7:
            if (r101 >= this.type_.size()) goto L10;
            r102 = r102 + CodedOutputStream.computeMessageSize(1, (MessageLite) ListProtector.get(this.type_, r101));
            r101 = r101 + 1;
            goto L7
        L10:
            if ((this.bitField0_ & 1) != 1) goto L12;
            r102 = r102 + CodedOutputStream.computeInt32Size(2, this.firstNullable_);
        L12:
            int r103 = r102 + this.unknownFields.size();
            this.memoizedSerializedSize = r103;
            return r103;
        }

        public int getTypeCount() {
            return this.type_.size();
        }

        public boolean hasFirstNullable() {
            if ((this.bitField0_ & 1) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte r100 = this.memoizedIsInitialized;
            if (r100 != 1) goto L6;
            return true;
        L6:
            if (r100 != 0) goto L8;
            return false;
        L8:
            int r101 = 0;
        L10:
            if (r101 >= getTypeCount()) goto L16;
            if (getType(r101).isInitialized() == false) goto L13;
            r101 = r101 + 1;
            goto L10
        L13:
            this.memoizedIsInitialized = 0;
            return false;
        L16:
            this.memoizedIsInitialized = 1;
            return true;
        }

        private void initFields() {
            this.type_ = Collections.emptyList();
            this.firstNullable_ = -1;
        }

        public static Builder newBuilder() {
            return Builder.access$12600();
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

        public static TypeTable getDefaultInstance() {
            return defaultInstance;
        }

        public int getFirstNullable() {
            return this.firstNullable_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<TypeTable> getParserForType() {
            return PARSER;
        }

        public List<Type> getTypeList() {
            return this.type_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public TypeTable getDefaultInstanceForType() {
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

        private TypeTable(GeneratedMessageLite.Builder r100) {
            super(r100);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r100.getUnknownFields();
        }

        public static /* synthetic */ List access$12800(TypeTable r100) {
            return r100.type_;
        }

        public static /* synthetic */ ByteString access$13100(TypeTable r100) {
            return r100.unknownFields;
        }

        public static Builder newBuilder(TypeTable r100) {
            return newBuilder().mergeFrom(r100);
        }

        public Type getType(int r100) {
            return (Type) ListProtector.get(this.type_, r100);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r100) throws IOException {
            getSerializedSize();
            int r101 = 0;
        L4:
            if (r101 >= this.type_.size()) goto L7;
            r100.writeMessage(1, (MessageLite) ListProtector.get(this.type_, r101));
            r101 = r101 + 1;
            goto L4
        L7:
            if ((this.bitField0_ & 1) != 1) goto L9;
            r100.writeInt32(2, this.firstNullable_);
        L9:
            r100.writeRawBytes(this.unknownFields);
        }

        private TypeTable(boolean r100) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        private TypeTable(CodedInputStream r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r102 = ByteString.newOutput();
            CodedOutputStream r103 = CodedOutputStream.newInstance(r102, 1);
            boolean r104 = false;
            boolean r105 = false;
        L3:
            if (r104 == true) goto L39;
            int r106 = r100.readTag();     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L25
            if (r106 == 0) goto L19;
            if (r106 != 10) goto L9;
            if ((r105 & true) == true) goto L17;
            this.type_ = new ArrayList();     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L25
            r105 = r105 | true;     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L25
        L17:
            this.type_.add((Type) r100.readMessage(Type.PARSER, r101));     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L25
            goto L3
        L9:
            if (r106 != 16) goto L11;
            this.bitField0_ |= 1;     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L25
            this.firstNullable_ = r100.readInt32();     // Catch: Throwable -> L20 IOException -> L22 InvalidProtocolBufferException -> L25
            goto L3
        L11:
            if (parseUnknownField(r100, r103, r101, r106) == true) goto L3;
        L19:
            r104 = true;
            goto L3
        L20:
            th = move-exception;
            if ((r105 & true) != true) goto L51;
            this.type_ = Collections.unmodifiableList(this.type_);
        L51:
            r103.flush();     // Catch: IOException -> L49 Throwable -> L33
        L33:
            th = move-exception;
            this.unknownFields = r102.toByteString();
            throw th;
        L32:
            this.unknownFields = r102.toByteString();
            makeExtensionsImmutable();
            throw th;
        L25:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L20
        L22:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L20
        L39:
            if ((r105 & true) != true) goto L54;
            this.type_ = Collections.unmodifiableList(this.type_);
        L54:
            r103.flush();     // Catch: IOException -> L48 Throwable -> L43
        L43:
            th = move-exception;
            this.unknownFields = r102.toByteString();
            throw th;
        L42:
            this.unknownFields = r102.toByteString();
            makeExtensionsImmutable();
        }

        public static /* synthetic */ List access$12802(TypeTable r100, List r101) {
            r100.type_ = r101;
            return r101;
        }

        public static /* synthetic */ int access$12902(TypeTable r100, int r101) {
            r100.firstNullable_ = r101;
            return r101;
        }

        public static /* synthetic */ int access$13002(TypeTable r100, int r101) {
            r100.bitField0_ = r101;
            return r101;
        }

        public /* synthetic */ TypeTable(GeneratedMessageLite.Builder r100, AnonymousClass1 r101) {
            this(r100);
        }

        public /* synthetic */ TypeTable(CodedInputStream r100, ExtensionRegistryLite r101, AnonymousClass1 r102) throws InvalidProtocolBufferException {
            this(r100, r101);
        }
    }

    /* JADX INFO: loaded from: classes5.dex */
    public interface TypeTableOrBuilder extends MessageLiteOrBuilder {
    }

    /* JADX INFO: loaded from: classes5.dex */
    public static final class ValueParameter extends GeneratedMessageLite.ExtendableMessage<ValueParameter> implements ValueParameterOrBuilder {
        public static Parser<ValueParameter> PARSER;
        private static final ValueParameter defaultInstance = null;
        private int bitField0_;
        private int flags_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private int typeId_;
        private Type type_;
        private final ByteString unknownFields;
        private int varargElementTypeId_;
        private Type varargElementType_;

        /* JADX INFO: loaded from: classes42.dex */
        public static final class Builder extends GeneratedMessageLite.ExtendableBuilder<ValueParameter, Builder> implements ValueParameterOrBuilder {
            private int bitField0_;
            private int flags_;
            private int name_;
            private int typeId_;
            private Type type_;
            private int varargElementTypeId_;
            private Type varargElementType_;

            private void maybeForceBuilderInitialization() {
            }

            private static Builder create() {
                return new Builder();
            }

            public ValueParameter buildPartial() {
                ValueParameter r100 = new ValueParameter(this, null);
                int r101 = this.bitField0_;
                int r102 = 1;
                if ((r101 & 1) == 1) goto L6;
                r102 = 0;
            L6:
                ValueParameter.access$18102(r100, this.flags_);
                if ((r101 & 2) != 2) goto L9;
                r102 = r102 | 2;
            L9:
                ValueParameter.access$18202(r100, this.name_);
                if ((r101 & 4) != 4) goto L12;
                r102 = r102 | 4;
            L12:
                ValueParameter.access$18302(r100, this.type_);
                if ((r101 & 8) != 8) goto L15;
                r102 = r102 | 8;
            L15:
                ValueParameter.access$18402(r100, this.typeId_);
                if ((r101 & 16) != 16) goto L18;
                r102 = r102 | 16;
            L18:
                ValueParameter.access$18502(r100, this.varargElementType_);
                if ((r101 & 32) != 32) goto L21;
                r102 = r102 | 32;
            L21:
                ValueParameter.access$18602(r100, this.varargElementTypeId_);
                ValueParameter.access$18702(r100, r102);
                return r100;
            }

            public boolean hasName() {
                if ((this.bitField0_ & 2) != 2) goto L5;
                return true;
            L5:
                return false;
            }

            public boolean hasType() {
                if ((this.bitField0_ & 4) != 4) goto L5;
                return true;
            L5:
                return false;
            }

            public boolean hasVarargElementType() {
                if ((this.bitField0_ & 16) != 16) goto L5;
                return true;
            L5:
                return false;
            }

            private Builder() {
                this.type_ = Type.getDefaultInstance();
                this.varargElementType_ = Type.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            public static /* synthetic */ Builder access$17900() {
                return create();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public ValueParameter build() {
                ValueParameter r100 = buildPartial();
                if (r100.isInitialized() == false) goto L6;
                return r100;
            L6:
                throw AbstractMessageLite.Builder.newUninitializedMessageException(r100);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public Builder clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public ValueParameter getDefaultInstanceForType() {
                return ValueParameter.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                if (hasName() == true) goto L6;
                return false;
            L6:
                if (hasType() == false) goto L11;
                if (getType().isInitialized() == true) goto L11;
                return false;
            L11:
                if (hasVarargElementType() == false) goto L16;
                if (getVarargElementType().isInitialized() == true) goto L16;
                return false;
            L16:
                if (extensionsAreInitialized() == true) goto L18;
                return false;
            L18:
                return true;
            }

            public Type getType() {
                return this.type_;
            }

            public Type getVarargElementType() {
                return this.varargElementType_;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite build() {
                return build();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ GeneratedMessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            /* JADX INFO: renamed from: clone */
            public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mo10730clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
                return getDefaultInstanceForType();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clone() {
                return clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.ExtendableBuilder, kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.ExtendableBuilder clone() {
                return clone();
            }

            public Builder mergeFrom(ValueParameter r100) {
                if (r100 != ValueParameter.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r100.hasFlags() == false) goto L9;
                setFlags(r100.getFlags());
            L9:
                if (r100.hasName() == false) goto L12;
                setName(r100.getName());
            L12:
                if (r100.hasType() == false) goto L15;
                mergeType(r100.getType());
            L15:
                if (r100.hasTypeId() == false) goto L18;
                setTypeId(r100.getTypeId());
            L18:
                if (r100.hasVarargElementType() == false) goto L21;
                mergeVarargElementType(r100.getVarargElementType());
            L21:
                if (r100.hasVarargElementTypeId() == false) goto L23;
                setVarargElementTypeId(r100.getVarargElementTypeId());
            L23:
                mergeExtensionFields(r100);
                setUnknownFields(getUnknownFields().concat(ValueParameter.access$18800(r100)));
                return this;
            }

            public Builder mergeType(Type r100) {
                if ((this.bitField0_ & 4) == 4) goto L5;
            L7:
                this.type_ = r100;
            L8:
                this.bitField0_ |= 4;
                return this;
            L5:
                if (this.type_ == Type.getDefaultInstance()) goto L7;
                this.type_ = Type.newBuilder(this.type_).mergeFrom(r100).buildPartial();
                goto L8
            }

            public Builder mergeVarargElementType(Type r100) {
                if ((this.bitField0_ & 16) == 16) goto L5;
            L7:
                this.varargElementType_ = r100;
            L8:
                this.bitField0_ |= 16;
                return this;
            L5:
                if (this.varargElementType_ == Type.getDefaultInstance()) goto L7;
                this.varargElementType_ = Type.newBuilder(this.varargElementType_).mergeFrom(r100).buildPartial();
                goto L8
            }

            public Builder setFlags(int r100) {
                this.bitField0_ |= 1;
                this.flags_ = r100;
                return this;
            }

            public Builder setName(int r100) {
                this.bitField0_ |= 2;
                this.name_ = r100;
                return this;
            }

            public Builder setTypeId(int r100) {
                this.bitField0_ |= 8;
                this.typeId_ = r100;
                return this;
            }

            public Builder setVarargElementTypeId(int r100) {
                this.bitField0_ |= 32;
                this.varargElementTypeId_ = r100;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r100) {
                return mergeFrom((ValueParameter) r100);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
                ValueParameter r102 = null;
                ValueParameter r103 = ValueParameter.PARSER.parsePartialFrom(r100, r101);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r103 == null) goto L6;
                mergeFrom(r103);
            L6:
                return this;
            L9:
                e = move-exception;
                ValueParameter r104 = (ValueParameter) e.getUnfinishedMessage();     // Catch: Throwable -> L7
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
            this.flags_ = 0;
            this.name_ = 0;
            this.type_ = Type.getDefaultInstance();
            this.typeId_ = 0;
            this.varargElementType_ = Type.getDefaultInstance();
            this.varargElementTypeId_ = 0;
        }

        static {
            PARSER = new AnonymousClass1();
            ValueParameter r100 = new ValueParameter(true);
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
            r101 = 0 + CodedOutputStream.computeInt32Size(1, this.flags_);
        L9:
            if ((this.bitField0_ & 2) != 2) goto L12;
            r101 = r101 + CodedOutputStream.computeInt32Size(2, this.name_);
        L12:
            if ((this.bitField0_ & 4) != 4) goto L15;
            r101 = r101 + CodedOutputStream.computeMessageSize(3, this.type_);
        L15:
            if ((this.bitField0_ & 16) != 16) goto L18;
            r101 = r101 + CodedOutputStream.computeMessageSize(4, this.varargElementType_);
        L18:
            if ((this.bitField0_ & 8) != 8) goto L21;
            r101 = r101 + CodedOutputStream.computeInt32Size(5, this.typeId_);
        L21:
            if ((this.bitField0_ & 32) != 32) goto L23;
            r101 = r101 + CodedOutputStream.computeInt32Size(6, this.varargElementTypeId_);
        L23:
            int r102 = (r101 + extensionsSerializedSize()) + this.unknownFields.size();
            this.memoizedSerializedSize = r102;
            return r102;
        }

        public boolean hasFlags() {
            if ((this.bitField0_ & 1) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        public boolean hasName() {
            if ((this.bitField0_ & 2) != 2) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasType() {
            if ((this.bitField0_ & 4) != 4) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasTypeId() {
            if ((this.bitField0_ & 8) != 8) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasVarargElementType() {
            if ((this.bitField0_ & 16) != 16) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasVarargElementTypeId() {
            if ((this.bitField0_ & 32) != 32) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte r100 = this.memoizedIsInitialized;
            if (r100 != 1) goto L6;
            return true;
        L6:
            if (r100 != 0) goto L9;
            return false;
        L9:
            if (hasName() == true) goto L13;
            this.memoizedIsInitialized = 0;
            return false;
        L13:
            if (hasType() == false) goto L19;
            if (getType().isInitialized() == true) goto L19;
            this.memoizedIsInitialized = 0;
            return false;
        L19:
            if (hasVarargElementType() == false) goto L25;
            if (getVarargElementType().isInitialized() == true) goto L25;
            this.memoizedIsInitialized = 0;
            return false;
        L25:
            if (extensionsAreInitialized() == true) goto L28;
            this.memoizedIsInitialized = 0;
            return false;
        L28:
            this.memoizedIsInitialized = 1;
            return true;
        }

        public static Builder newBuilder() {
            return Builder.access$17900();
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

        public static ValueParameter getDefaultInstance() {
            return defaultInstance;
        }

        public int getFlags() {
            return this.flags_;
        }

        public int getName() {
            return this.name_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<ValueParameter> getParserForType() {
            return PARSER;
        }

        public Type getType() {
            return this.type_;
        }

        public int getTypeId() {
            return this.typeId_;
        }

        public Type getVarargElementType() {
            return this.varargElementType_;
        }

        public int getVarargElementTypeId() {
            return this.varargElementTypeId_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public ValueParameter getDefaultInstanceForType() {
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

        private ValueParameter(GeneratedMessageLite.ExtendableBuilder<ValueParameter, ?> r100) {
            super(r100);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r100.getUnknownFields();
        }

        public static /* synthetic */ ByteString access$18800(ValueParameter r100) {
            return r100.unknownFields;
        }

        public static Builder newBuilder(ValueParameter r100) {
            return newBuilder().mergeFrom(r100);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r100) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.ExtensionWriter r101 = newExtensionWriter();
            if ((this.bitField0_ & 1) != 1) goto L6;
            r100.writeInt32(1, this.flags_);
        L6:
            if ((this.bitField0_ & 2) != 2) goto L9;
            r100.writeInt32(2, this.name_);
        L9:
            if ((this.bitField0_ & 4) != 4) goto L12;
            r100.writeMessage(3, this.type_);
        L12:
            if ((this.bitField0_ & 16) != 16) goto L15;
            r100.writeMessage(4, this.varargElementType_);
        L15:
            if ((this.bitField0_ & 8) != 8) goto L18;
            r100.writeInt32(5, this.typeId_);
        L18:
            if ((this.bitField0_ & 32) != 32) goto L20;
            r100.writeInt32(6, this.varargElementTypeId_);
        L20:
            r101.writeUntil(200, r100);
            r100.writeRawBytes(this.unknownFields);
        }

        private ValueParameter(boolean r100) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        private ValueParameter(CodedInputStream r110, ExtensionRegistryLite r111) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r100 = ByteString.newOutput();
            CodedOutputStream r101 = CodedOutputStream.newInstance(r100, 1);
            boolean r102 = false;
        L3:
            if (r102 == true) goto L69;
            int r103 = r110.readTag();     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            if (r103 == 0) goto L40;
            if (r103 != 8) goto L9;
            this.bitField0_ |= 1;     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            this.flags_ = r110.readInt32();     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            goto L3
        L9:
            if (r103 != 16) goto L10;
            this.bitField0_ |= 2;     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            this.name_ = r110.readInt32();     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            goto L3
        L10:
            Type.Builder r104 = null;
            if (r103 != 26) goto L13;
            if ((this.bitField0_ & 4) != 4) goto L33;
            r104 = this.type_.toBuilder();     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
        L33:
            Type r105 = (Type) r110.readMessage(Type.PARSER, r111);     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            this.type_ = r105;     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            if (r104 == null) goto L36;
            r104.mergeFrom(r105);     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            this.type_ = r104.buildPartial();     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
        L36:
            this.bitField0_ |= 4;     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            goto L3
        L13:
            if (r103 != 34) goto L15;
            if ((this.bitField0_ & 16) != 16) goto L26;
            r104 = this.varargElementType_.toBuilder();     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
        L26:
            Type r106 = (Type) r110.readMessage(Type.PARSER, r111);     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            this.varargElementType_ = r106;     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            if (r104 == null) goto L29;
            r104.mergeFrom(r106);     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            this.varargElementType_ = r104.buildPartial();     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
        L29:
            this.bitField0_ |= 16;     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            goto L3
        L15:
            if (r103 != 40) goto L17;
            this.bitField0_ |= 8;     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            this.typeId_ = r110.readInt32();     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            goto L3
        L17:
            if (r103 != 48) goto L19;
            this.bitField0_ |= 32;     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            this.varargElementTypeId_ = r110.readInt32();     // Catch: Throwable -> L41 IOException -> L43 InvalidProtocolBufferException -> L46
            goto L3
        L19:
            if (parseUnknownField(r110, r101, r111, r103) == true) goto L3;
        L40:
            r102 = true;
            goto L3
        L41:
            th = move-exception;
            r101.flush();     // Catch: IOException -> L63 Throwable -> L51
        L51:
            th = move-exception;
            this.unknownFields = r100.toByteString();
            throw th;
        L50:
            this.unknownFields = r100.toByteString();
            makeExtensionsImmutable();
            throw th;
        L43:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L41
        L46:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L41
        L69:
            r101.flush();     // Catch: IOException -> L64 Throwable -> L58
        L58:
            th = move-exception;
            this.unknownFields = r100.toByteString();
            throw th;
        L57:
            this.unknownFields = r100.toByteString();
            makeExtensionsImmutable();
        }

        public static /* synthetic */ int access$18102(ValueParameter r100, int r101) {
            r100.flags_ = r101;
            return r101;
        }

        public static /* synthetic */ int access$18202(ValueParameter r100, int r101) {
            r100.name_ = r101;
            return r101;
        }

        public static /* synthetic */ Type access$18302(ValueParameter r100, Type r101) {
            r100.type_ = r101;
            return r101;
        }

        public static /* synthetic */ int access$18402(ValueParameter r100, int r101) {
            r100.typeId_ = r101;
            return r101;
        }

        public static /* synthetic */ Type access$18502(ValueParameter r100, Type r101) {
            r100.varargElementType_ = r101;
            return r101;
        }

        public static /* synthetic */ int access$18602(ValueParameter r100, int r101) {
            r100.varargElementTypeId_ = r101;
            return r101;
        }

        public static /* synthetic */ int access$18702(ValueParameter r100, int r101) {
            r100.bitField0_ = r101;
            return r101;
        }

        public /* synthetic */ ValueParameter(GeneratedMessageLite.ExtendableBuilder r100, AnonymousClass1 r101) {
            this(r100);
        }

        public /* synthetic */ ValueParameter(CodedInputStream r100, ExtensionRegistryLite r101, AnonymousClass1 r102) throws InvalidProtocolBufferException {
            this(r100, r101);
        }
    }

    /* JADX INFO: loaded from: classes5.dex */
    public interface ValueParameterOrBuilder extends GeneratedMessageLite.ExtendableMessageOrBuilder {
    }

    public static final class VersionRequirement extends GeneratedMessageLite implements VersionRequirementOrBuilder {
        public static Parser<VersionRequirement> PARSER;
        private static final VersionRequirement defaultInstance = null;
        private int bitField0_;
        private int errorCode_;
        private Level level_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int message_;
        private final ByteString unknownFields;
        private int versionFull_;
        private VersionKind versionKind_;
        private int version_;

        public static final class Builder extends GeneratedMessageLite.Builder<VersionRequirement, Builder> implements VersionRequirementOrBuilder {
            private int bitField0_;
            private int errorCode_;
            private Level level_;
            private int message_;
            private int versionFull_;
            private VersionKind versionKind_;
            private int version_;

            private void maybeForceBuilderInitialization() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            private static Builder create() {
                return new Builder();
            }

            public VersionRequirement buildPartial() {
                VersionRequirement r100 = new VersionRequirement(this, null);
                int r101 = this.bitField0_;
                int r102 = 1;
                if ((r101 & 1) == 1) goto L6;
                r102 = 0;
            L6:
                VersionRequirement.access$21202(r100, this.version_);
                if ((r101 & 2) != 2) goto L9;
                r102 = r102 | 2;
            L9:
                VersionRequirement.access$21302(r100, this.versionFull_);
                if ((r101 & 4) != 4) goto L12;
                r102 = r102 | 4;
            L12:
                VersionRequirement.access$21402(r100, this.level_);
                if ((r101 & 8) != 8) goto L15;
                r102 = r102 | 8;
            L15:
                VersionRequirement.access$21502(r100, this.errorCode_);
                if ((r101 & 16) != 16) goto L18;
                r102 = r102 | 16;
            L18:
                VersionRequirement.access$21602(r100, this.message_);
                if ((r101 & 32) != 32) goto L21;
                r102 = r102 | 32;
            L21:
                VersionRequirement.access$21702(r100, this.versionKind_);
                VersionRequirement.access$21802(r100, r102);
                return r100;
            }

            private Builder() {
                this.level_ = Level.ERROR;
                this.versionKind_ = VersionKind.LANGUAGE_VERSION;
                maybeForceBuilderInitialization();
            }

            public static /* synthetic */ Builder access$21000() {
                return create();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public VersionRequirement build() {
                VersionRequirement r100 = buildPartial();
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
            public VersionRequirement getDefaultInstanceForType() {
                return VersionRequirement.getDefaultInstance();
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

            public Builder mergeFrom(VersionRequirement r100) {
                if (r100 != VersionRequirement.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (r100.hasVersion() == false) goto L9;
                setVersion(r100.getVersion());
            L9:
                if (r100.hasVersionFull() == false) goto L12;
                setVersionFull(r100.getVersionFull());
            L12:
                if (r100.hasLevel() == false) goto L15;
                setLevel(r100.getLevel());
            L15:
                if (r100.hasErrorCode() == false) goto L18;
                setErrorCode(r100.getErrorCode());
            L18:
                if (r100.hasMessage() == false) goto L21;
                setMessage(r100.getMessage());
            L21:
                if (r100.hasVersionKind() == false) goto L23;
                setVersionKind(r100.getVersionKind());
            L23:
                setUnknownFields(getUnknownFields().concat(VersionRequirement.access$21900(r100)));
                return this;
            }

            public Builder setErrorCode(int r100) {
                this.bitField0_ |= 8;
                this.errorCode_ = r100;
                return this;
            }

            public Builder setLevel(Level r100) {
                if (r100 == null) goto L6;
                this.bitField0_ |= 4;
                this.level_ = r100;
                return this;
            L6:
                throw null;
            }

            public Builder setMessage(int r100) {
                this.bitField0_ |= 16;
                this.message_ = r100;
                return this;
            }

            public Builder setVersion(int r100) {
                this.bitField0_ |= 1;
                this.version_ = r100;
                return this;
            }

            public Builder setVersionFull(int r100) {
                this.bitField0_ |= 2;
                this.versionFull_ = r100;
                return this;
            }

            public Builder setVersionKind(VersionKind r100) {
                if (r100 == null) goto L6;
                this.bitField0_ |= 32;
                this.versionKind_ = r100;
                return this;
            L6:
                throw null;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r100) {
                return mergeFrom((VersionRequirement) r100);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
                VersionRequirement r102 = null;
                VersionRequirement r103 = VersionRequirement.PARSER.parsePartialFrom(r100, r101);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r103 == null) goto L6;
                mergeFrom(r103);
            L6:
                return this;
            L9:
                e = move-exception;
                VersionRequirement r104 = (VersionRequirement) e.getUnfinishedMessage();     // Catch: Throwable -> L7
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

        public static final enum Level extends Enum<Level> implements Internal.EnumLite {
            private static final /* synthetic */ Level[] $VALUES = null;
            public static final Level ERROR = null;
            public static final Level HIDDEN = null;
            public static final Level WARNING = null;
            private static Internal.EnumLiteMap<Level> internalValueMap;
            private final int value;

            static {
                Level r100 = new Level("WARNING", 0, 0, 0);
                WARNING = r100;
                Level r101 = new Level("ERROR", 1, 1, 1);
                ERROR = r101;
                Level r102 = new Level("HIDDEN", 2, 2, 2);
                HIDDEN = r102;
                $VALUES = new Level[]{r100, r101, r102};
                internalValueMap = new AnonymousClass1();
            }

            public static Level[] values() {
                return (Level[]) $VALUES.clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            public static Level valueOf(int r100) {
                if (r100 == 0) goto L14;
                if (r100 == 1) goto L12;
                if (r100 == 2) goto L10;
                return null;
            L10:
                return HIDDEN;
            L12:
                return ERROR;
            L14:
                return WARNING;
            }

            public static Level valueOf(String r100) {
                return (Level) a.a(Level.class, r100);
            }

            private Level(String r100, int r101, int r102, int r103) {
                super(r100, r101);
                this.value = r103;
            }
        }

        public static final enum VersionKind extends Enum<VersionKind> implements Internal.EnumLite {
            private static final /* synthetic */ VersionKind[] $VALUES = null;
            public static final VersionKind API_VERSION = null;
            public static final VersionKind COMPILER_VERSION = null;
            public static final VersionKind LANGUAGE_VERSION = null;
            private static Internal.EnumLiteMap<VersionKind> internalValueMap;
            private final int value;

            static {
                VersionKind r100 = new VersionKind("LANGUAGE_VERSION", 0, 0, 0);
                LANGUAGE_VERSION = r100;
                VersionKind r101 = new VersionKind("COMPILER_VERSION", 1, 1, 1);
                COMPILER_VERSION = r101;
                VersionKind r102 = new VersionKind("API_VERSION", 2, 2, 2);
                API_VERSION = r102;
                $VALUES = new VersionKind[]{r100, r101, r102};
                internalValueMap = new AnonymousClass1();
            }

            public static VersionKind[] values() {
                return (VersionKind[]) $VALUES.clone();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            public static VersionKind valueOf(int r100) {
                if (r100 == 0) goto L14;
                if (r100 == 1) goto L12;
                if (r100 == 2) goto L10;
                return null;
            L10:
                return API_VERSION;
            L12:
                return COMPILER_VERSION;
            L14:
                return LANGUAGE_VERSION;
            }

            public static VersionKind valueOf(String r100) {
                return (VersionKind) a.a(VersionKind.class, r100);
            }

            private VersionKind(String r100, int r101, int r102, int r103) {
                super(r100, r101);
                this.value = r103;
            }
        }

        private void initFields() {
            this.version_ = 0;
            this.versionFull_ = 0;
            this.level_ = Level.ERROR;
            this.errorCode_ = 0;
            this.message_ = 0;
            this.versionKind_ = VersionKind.LANGUAGE_VERSION;
        }

        static {
            PARSER = new AnonymousClass1();
            VersionRequirement r100 = new VersionRequirement(true);
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
            r101 = 0 + CodedOutputStream.computeInt32Size(1, this.version_);
        L9:
            if ((this.bitField0_ & 2) != 2) goto L12;
            r101 = r101 + CodedOutputStream.computeInt32Size(2, this.versionFull_);
        L12:
            if ((this.bitField0_ & 4) != 4) goto L15;
            r101 = r101 + CodedOutputStream.computeEnumSize(3, this.level_.getNumber());
        L15:
            if ((this.bitField0_ & 8) != 8) goto L18;
            r101 = r101 + CodedOutputStream.computeInt32Size(4, this.errorCode_);
        L18:
            if ((this.bitField0_ & 16) != 16) goto L21;
            r101 = r101 + CodedOutputStream.computeInt32Size(5, this.message_);
        L21:
            if ((this.bitField0_ & 32) != 32) goto L23;
            r101 = r101 + CodedOutputStream.computeEnumSize(6, this.versionKind_.getNumber());
        L23:
            int r102 = r101 + this.unknownFields.size();
            this.memoizedSerializedSize = r102;
            return r102;
        }

        public boolean hasErrorCode() {
            if ((this.bitField0_ & 8) != 8) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasLevel() {
            if ((this.bitField0_ & 4) != 4) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasMessage() {
            if ((this.bitField0_ & 16) != 16) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasVersion() {
            if ((this.bitField0_ & 1) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        public boolean hasVersionFull() {
            if ((this.bitField0_ & 2) != 2) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean hasVersionKind() {
            if ((this.bitField0_ & 32) != 32) goto L5;
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
            return Builder.access$21000();
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

        public static VersionRequirement getDefaultInstance() {
            return defaultInstance;
        }

        public int getErrorCode() {
            return this.errorCode_;
        }

        public Level getLevel() {
            return this.level_;
        }

        public int getMessage() {
            return this.message_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<VersionRequirement> getParserForType() {
            return PARSER;
        }

        public int getVersion() {
            return this.version_;
        }

        public int getVersionFull() {
            return this.versionFull_;
        }

        public VersionKind getVersionKind() {
            return this.versionKind_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public VersionRequirement getDefaultInstanceForType() {
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

        private VersionRequirement(GeneratedMessageLite.Builder r100) {
            super(r100);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r100.getUnknownFields();
        }

        public static /* synthetic */ ByteString access$21900(VersionRequirement r100) {
            return r100.unknownFields;
        }

        public static Builder newBuilder(VersionRequirement r100) {
            return newBuilder().mergeFrom(r100);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r100) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) != 1) goto L6;
            r100.writeInt32(1, this.version_);
        L6:
            if ((this.bitField0_ & 2) != 2) goto L9;
            r100.writeInt32(2, this.versionFull_);
        L9:
            if ((this.bitField0_ & 4) != 4) goto L12;
            r100.writeEnum(3, this.level_.getNumber());
        L12:
            if ((this.bitField0_ & 8) != 8) goto L15;
            r100.writeInt32(4, this.errorCode_);
        L15:
            if ((this.bitField0_ & 16) != 16) goto L18;
            r100.writeInt32(5, this.message_);
        L18:
            if ((this.bitField0_ & 32) != 32) goto L20;
            r100.writeEnum(6, this.versionKind_.getNumber());
        L20:
            r100.writeRawBytes(this.unknownFields);
        }

        private VersionRequirement(boolean r100) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        private VersionRequirement(CodedInputStream r100, ExtensionRegistryLite r110) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r101 = ByteString.newOutput();
            CodedOutputStream r102 = CodedOutputStream.newInstance(r101, 1);
            boolean r103 = false;
        L3:
            if (r103 == true) goto L63;
            int r104 = r100.readTag();     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
            if (r104 == 0) goto L34;
            if (r104 != 8) goto L9;
            this.bitField0_ |= 1;     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
            this.version_ = r100.readInt32();     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
            goto L3
        L9:
            if (r104 != 16) goto L11;
            this.bitField0_ |= 2;     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
            this.versionFull_ = r100.readInt32();     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
            goto L3
        L11:
            if (r104 != 24) goto L13;
            int r105 = r100.readEnum();     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
            Level r106 = Level.valueOf(r105);     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
            if (r106 == null) goto L29;
            this.bitField0_ |= 4;     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
            this.level_ = r106;     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
            goto L3
        L29:
            r102.writeRawVarint32(r104);     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
            r102.writeRawVarint32(r105);     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
            goto L3
        L13:
            if (r104 != 32) goto L15;
            this.bitField0_ |= 8;     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
            this.errorCode_ = r100.readInt32();     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
            goto L3
        L15:
            if (r104 != 40) goto L17;
            this.bitField0_ |= 16;     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
            this.message_ = r100.readInt32();     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
            goto L3
        L17:
            if (r104 != 48) goto L19;
            int r107 = r100.readEnum();     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
            VersionKind r108 = VersionKind.valueOf(r107);     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
            if (r108 == null) goto L23;
            this.bitField0_ |= 32;     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
            this.versionKind_ = r108;     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
            goto L3
        L23:
            r102.writeRawVarint32(r104);     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
            r102.writeRawVarint32(r107);     // Catch: Throwable -> L35 IOException -> L37 InvalidProtocolBufferException -> L40
            goto L3
        L19:
            if (parseUnknownField(r100, r102, r110, r104) == true) goto L3;
        L34:
            r103 = true;
            goto L3
        L35:
            th = move-exception;
            r102.flush();     // Catch: IOException -> L57 Throwable -> L45
        L45:
            th = move-exception;
            this.unknownFields = r101.toByteString();
            throw th;
        L44:
            this.unknownFields = r101.toByteString();
            makeExtensionsImmutable();
            throw th;
        L40:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L35
        L37:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L35
        L63:
            r102.flush();     // Catch: IOException -> L58 Throwable -> L52
        L52:
            th = move-exception;
            this.unknownFields = r101.toByteString();
            throw th;
        L51:
            this.unknownFields = r101.toByteString();
            makeExtensionsImmutable();
        }

        public static /* synthetic */ int access$21202(VersionRequirement r100, int r101) {
            r100.version_ = r101;
            return r101;
        }

        public static /* synthetic */ int access$21302(VersionRequirement r100, int r101) {
            r100.versionFull_ = r101;
            return r101;
        }

        public static /* synthetic */ Level access$21402(VersionRequirement r100, Level r101) {
            r100.level_ = r101;
            return r101;
        }

        public static /* synthetic */ int access$21502(VersionRequirement r100, int r101) {
            r100.errorCode_ = r101;
            return r101;
        }

        public static /* synthetic */ int access$21602(VersionRequirement r100, int r101) {
            r100.message_ = r101;
            return r101;
        }

        public static /* synthetic */ VersionKind access$21702(VersionRequirement r100, VersionKind r101) {
            r100.versionKind_ = r101;
            return r101;
        }

        public static /* synthetic */ int access$21802(VersionRequirement r100, int r101) {
            r100.bitField0_ = r101;
            return r101;
        }

        public /* synthetic */ VersionRequirement(GeneratedMessageLite.Builder r100, AnonymousClass1 r101) {
            this(r100);
        }

        public /* synthetic */ VersionRequirement(CodedInputStream r100, ExtensionRegistryLite r101, AnonymousClass1 r102) throws InvalidProtocolBufferException {
            this(r100, r101);
        }
    }

    public interface VersionRequirementOrBuilder extends MessageLiteOrBuilder {
    }

    /* JADX INFO: loaded from: classes5.dex */
    public static final class VersionRequirementTable extends GeneratedMessageLite implements VersionRequirementTableOrBuilder {
        public static Parser<VersionRequirementTable> PARSER;
        private static final VersionRequirementTable defaultInstance = null;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<VersionRequirement> requirement_;
        private final ByteString unknownFields;

        public static final class Builder extends GeneratedMessageLite.Builder<VersionRequirementTable, Builder> implements VersionRequirementTableOrBuilder {
            private int bitField0_;
            private List<VersionRequirement> requirement_;

            private void maybeForceBuilderInitialization() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            private static Builder create() {
                return new Builder();
            }

            private void ensureRequirementIsMutable() {
                if ((this.bitField0_ & 1) == 1) goto L6;
                this.requirement_ = new ArrayList(this.requirement_);
                this.bitField0_ |= 1;
                return;
            }

            public VersionRequirementTable buildPartial() {
                VersionRequirementTable r100 = new VersionRequirementTable(this, null);
                if ((this.bitField0_ & 1) != 1) goto L5;
                this.requirement_ = Collections.unmodifiableList(this.requirement_);
                this.bitField0_ &= -2;
            L5:
                VersionRequirementTable.access$22302(r100, this.requirement_);
                return r100;
            }

            private Builder() {
                this.requirement_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            public static /* synthetic */ Builder access$22100() {
                return create();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public VersionRequirementTable build() {
                VersionRequirementTable r100 = buildPartial();
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
            public VersionRequirementTable getDefaultInstanceForType() {
                return VersionRequirementTable.getDefaultInstance();
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

            public Builder mergeFrom(VersionRequirementTable r100) {
                if (r100 != VersionRequirementTable.getDefaultInstance()) goto L6;
                return this;
            L6:
                if (VersionRequirementTable.access$22300(r100).isEmpty() == false) goto L8;
            L11:
                setUnknownFields(getUnknownFields().concat(VersionRequirementTable.access$22400(r100)));
                return this;
            L8:
                if (this.requirement_.isEmpty() == false) goto L10;
                this.requirement_ = VersionRequirementTable.access$22300(r100);
                this.bitField0_ &= -2;
                goto L11
            L10:
                ensureRequirementIsMutable();
                this.requirement_.addAll(VersionRequirementTable.access$22300(r100));
                goto L11
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder mergeFrom(GeneratedMessageLite r100) {
                return mergeFrom((VersionRequirementTable) r100);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream r100, ExtensionRegistryLite r101) throws IOException {
                VersionRequirementTable r102 = null;
                VersionRequirementTable r103 = VersionRequirementTable.PARSER.parsePartialFrom(r100, r101);     // Catch: Throwable -> L7 InvalidProtocolBufferException -> L9
                if (r103 == null) goto L6;
                mergeFrom(r103);
            L6:
                return this;
            L9:
                e = move-exception;
                VersionRequirementTable r104 = (VersionRequirementTable) e.getUnfinishedMessage();     // Catch: Throwable -> L7
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
            VersionRequirementTable r100 = new VersionRequirementTable(true);
            defaultInstance = r100;
            r100.initFields();
        }

        public int getRequirementCount() {
            return this.requirement_.size();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public int getSerializedSize() {
            int r100 = this.memoizedSerializedSize;
            if (r100 == (-1)) goto L5;
            return r100;
        L5:
            int r101 = 0;
            int r102 = 0;
        L7:
            if (r101 >= this.requirement_.size()) goto L9;
            r102 = r102 + CodedOutputStream.computeMessageSize(1, (MessageLite) ListProtector.get(this.requirement_, r101));
            r101 = r101 + 1;
            goto L7
        L9:
            int r103 = r102 + this.unknownFields.size();
            this.memoizedSerializedSize = r103;
            return r103;
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
            this.requirement_ = Collections.emptyList();
        }

        public static Builder newBuilder() {
            return Builder.access$22100();
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

        public static VersionRequirementTable getDefaultInstance() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public Parser<VersionRequirementTable> getParserForType() {
            return PARSER;
        }

        public List<VersionRequirement> getRequirementList() {
            return this.requirement_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLiteOrBuilder
        public VersionRequirementTable getDefaultInstanceForType() {
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

        private VersionRequirementTable(GeneratedMessageLite.Builder r100) {
            super(r100);
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = r100.getUnknownFields();
        }

        public static /* synthetic */ List access$22300(VersionRequirementTable r100) {
            return r100.requirement_;
        }

        public static /* synthetic */ ByteString access$22400(VersionRequirementTable r100) {
            return r100.unknownFields;
        }

        public static Builder newBuilder(VersionRequirementTable r100) {
            return newBuilder().mergeFrom(r100);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.MessageLite
        public void writeTo(CodedOutputStream r100) throws IOException {
            getSerializedSize();
            int r101 = 0;
        L4:
            if (r101 >= this.requirement_.size()) goto L6;
            r100.writeMessage(1, (MessageLite) ListProtector.get(this.requirement_, r101));
            r101 = r101 + 1;
            goto L4
        L6:
            r100.writeRawBytes(this.unknownFields);
        }

        private VersionRequirementTable(boolean r100) {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = ByteString.EMPTY;
        }

        private VersionRequirementTable(CodedInputStream r100, ExtensionRegistryLite r101) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = -1;
            this.memoizedSerializedSize = -1;
            initFields();
            ByteString.Output r102 = ByteString.newOutput();
            CodedOutputStream r103 = CodedOutputStream.newInstance(r102, 1);
            boolean r104 = false;
            boolean r105 = false;
        L3:
            if (r104 == true) goto L36;
            int r106 = r100.readTag();     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
            if (r106 == 0) goto L16;
            if (r106 != 10) goto L9;
            if ((r105 & true) == true) goto L14;
            this.requirement_ = new ArrayList();     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
            r105 = r105 | true;     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
        L14:
            this.requirement_.add((VersionRequirement) r100.readMessage(VersionRequirement.PARSER, r101));     // Catch: Throwable -> L17 IOException -> L19 InvalidProtocolBufferException -> L22
            goto L3
        L9:
            if (parseUnknownField(r100, r103, r101, r106) == true) goto L3;
        L16:
            r104 = true;
            goto L3
        L17:
            th = move-exception;
            if ((r105 & true) != true) goto L48;
            this.requirement_ = Collections.unmodifiableList(this.requirement_);
        L48:
            r103.flush();     // Catch: IOException -> L46 Throwable -> L30
        L30:
            th = move-exception;
            this.unknownFields = r102.toByteString();
            throw th;
        L29:
            this.unknownFields = r102.toByteString();
            makeExtensionsImmutable();
            throw th;
        L22:
            e = move-exception;
            throw e.setUnfinishedMessage(this);     // Catch: Throwable -> L17
        L19:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);     // Catch: Throwable -> L17
        L36:
            if ((r105 & true) != true) goto L51;
            this.requirement_ = Collections.unmodifiableList(this.requirement_);
        L51:
            r103.flush();     // Catch: IOException -> L45 Throwable -> L40
        L40:
            th = move-exception;
            this.unknownFields = r102.toByteString();
            throw th;
        L39:
            this.unknownFields = r102.toByteString();
            makeExtensionsImmutable();
        }

        public static /* synthetic */ List access$22302(VersionRequirementTable r100, List r101) {
            r100.requirement_ = r101;
            return r101;
        }

        public /* synthetic */ VersionRequirementTable(GeneratedMessageLite.Builder r100, AnonymousClass1 r101) {
            this(r100);
        }

        public /* synthetic */ VersionRequirementTable(CodedInputStream r100, ExtensionRegistryLite r101, AnonymousClass1 r102) throws InvalidProtocolBufferException {
            this(r100, r101);
        }
    }

    /* JADX INFO: loaded from: classes5.dex */
    public interface VersionRequirementTableOrBuilder extends MessageLiteOrBuilder {
    }

    /* JADX INFO: loaded from: classes5.dex */
    public static final enum Visibility extends Enum<Visibility> implements Internal.EnumLite {
        private static final /* synthetic */ Visibility[] $VALUES = null;
        public static final Visibility INTERNAL = null;
        public static final Visibility LOCAL = null;
        public static final Visibility PRIVATE = null;
        public static final Visibility PRIVATE_TO_THIS = null;
        public static final Visibility PROTECTED = null;
        public static final Visibility PUBLIC = null;
        private static Internal.EnumLiteMap<Visibility> internalValueMap;
        private final int value;

        static {
            Visibility r100 = new Visibility("INTERNAL", 0, 0, 0);
            INTERNAL = r100;
            Visibility r101 = new Visibility("PRIVATE", 1, 1, 1);
            PRIVATE = r101;
            Visibility r102 = new Visibility("PROTECTED", 2, 2, 2);
            PROTECTED = r102;
            Visibility r103 = new Visibility("PUBLIC", 3, 3, 3);
            PUBLIC = r103;
            Visibility r104 = new Visibility("PRIVATE_TO_THIS", 4, 4, 4);
            PRIVATE_TO_THIS = r104;
            Visibility r105 = new Visibility(AccountType.LOCAL, 5, 5, 5);
            LOCAL = r105;
            $VALUES = new Visibility[]{r100, r101, r102, r103, r104, r105};
            internalValueMap = new AnonymousClass1();
        }

        public static Visibility[] values() {
            return (Visibility[]) $VALUES.clone();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }

        public static Visibility valueOf(int r100) {
            if (r100 == 0) goto L26;
            if (r100 == 1) goto L24;
            if (r100 == 2) goto L22;
            if (r100 == 3) goto L20;
            if (r100 == 4) goto L18;
            if (r100 == 5) goto L16;
            return null;
        L16:
            return LOCAL;
        L18:
            return PRIVATE_TO_THIS;
        L20:
            return PUBLIC;
        L22:
            return PROTECTED;
        L24:
            return PRIVATE;
        L26:
            return INTERNAL;
        }

        public static Visibility valueOf(String r100) {
            return (Visibility) a.a(Visibility.class, r100);
        }

        private Visibility(String r100, int r101, int r102, int r103) {
            super(r100, r101);
            this.value = r103;
        }
    }
}
