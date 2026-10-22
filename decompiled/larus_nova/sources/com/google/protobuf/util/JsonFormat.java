package com.google.protobuf.util;

import androidx.camera.video.AudioStats;
import com.alipay.sdk.m.u.i;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.google.common.base.m;
import com.google.common.io.BaseEncoding;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.google.gson.stream.JsonReader;
import com.google.protobuf.Any;
import com.google.protobuf.BoolValue;
import com.google.protobuf.ByteString;
import com.google.protobuf.BytesValue;
import com.google.protobuf.Descriptors;
import com.google.protobuf.DoubleValue;
import com.google.protobuf.Duration;
import com.google.protobuf.DynamicMessage;
import com.google.protobuf.FieldMask;
import com.google.protobuf.FloatValue;
import com.google.protobuf.Int32Value;
import com.google.protobuf.Int64Value;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.ListValue;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.NullValue;
import com.google.protobuf.StringValue;
import com.google.protobuf.Struct;
import com.google.protobuf.Timestamp;
import com.google.protobuf.UInt32Value;
import com.google.protobuf.UInt64Value;
import com.google.protobuf.Value;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.ParseException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.logging.Logger;
import org.bouncycastle.asn1.cmc.BodyPartID;
import tb2.c;

/* JADX INFO: loaded from: classes23.dex */
public class JsonFormat {
    private static final Logger logger = null;

    /* JADX INFO: renamed from: com.google.protobuf.util.JsonFormat$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type = null;

        static {
            int[] r100 = new int[Descriptors.FieldDescriptor.Type.values().length];
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type = r100;
            r100[Descriptors.FieldDescriptor.Type.INT32.ordinal()] = 1;     // Catch: NoSuchFieldError -> L22
        L62:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.SINT32.ordinal()] = 2;     // Catch: NoSuchFieldError -> L23
        L46:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.SFIXED32.ordinal()] = 3;     // Catch: NoSuchFieldError -> L24
        L58:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.INT64.ordinal()] = 4;     // Catch: NoSuchFieldError -> L25
        L64:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.SINT64.ordinal()] = 5;     // Catch: NoSuchFieldError -> L26
        L48:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.SFIXED64.ordinal()] = 6;     // Catch: NoSuchFieldError -> L27
        L52:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.BOOL.ordinal()] = 7;     // Catch: NoSuchFieldError -> L28
        L74:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.FLOAT.ordinal()] = 8;     // Catch: NoSuchFieldError -> L29
        L42:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.DOUBLE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L30
        L68:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.UINT32.ordinal()] = 10;     // Catch: NoSuchFieldError -> L31
        L70:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.FIXED32.ordinal()] = 11;     // Catch: NoSuchFieldError -> L32
        L54:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.UINT64.ordinal()] = 12;     // Catch: NoSuchFieldError -> L33
        L60:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.FIXED64.ordinal()] = 13;     // Catch: NoSuchFieldError -> L34
        L44:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.STRING.ordinal()] = 14;     // Catch: NoSuchFieldError -> L35
        L50:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.BYTES.ordinal()] = 15;     // Catch: NoSuchFieldError -> L36
        L72:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.ENUM.ordinal()] = 16;     // Catch: NoSuchFieldError -> L37
        L40:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.MESSAGE.ordinal()] = 17;     // Catch: NoSuchFieldError -> L38
        L66:
            $SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[Descriptors.FieldDescriptor.Type.GROUP.ordinal()] = 18;     // Catch: NoSuchFieldError -> L39
            return;
        }
    }

    public static final class CompactTextGenerator implements TextGenerator {
        private final Appendable output;

        @Override // com.google.protobuf.util.JsonFormat.TextGenerator
        public void indent() {
        }

        @Override // com.google.protobuf.util.JsonFormat.TextGenerator
        public void outdent() {
        }

        private CompactTextGenerator(Appendable r100) {
            this.output = r100;
        }

        @Override // com.google.protobuf.util.JsonFormat.TextGenerator
        public void print(CharSequence r100) throws IOException {
            this.output.append(r100);
        }

        public /* synthetic */ CompactTextGenerator(Appendable r100, AnonymousClass1 r101) {
            this(r100);
        }
    }

    public static class Parser {
        private static final int DEFAULT_RECURSION_LIMIT = 100;
        private final boolean ignoringUnknownFields;
        private final int recursionLimit;
        private final TypeRegistry registry;

        public Parser ignoringUnknownFields() {
            return new Parser(this.registry, true, this.recursionLimit);
        }

        public Parser usingRecursionLimit(int r100) {
            return new Parser(this.registry, this.ignoringUnknownFields, r100);
        }

        public Parser usingTypeRegistry(TypeRegistry r100) {
            if (this.registry != TypeRegistry.getEmptyTypeRegistry()) goto L7;
            return new Parser(r100, this.ignoringUnknownFields, this.recursionLimit);
        L7:
            throw new IllegalArgumentException("Only one registry is allowed.");
        }

        public void merge(Reader r100, Message.Builder r101) throws IOException {
            new ParserImpl(this.registry, this.ignoringUnknownFields, this.recursionLimit).merge(r100, r101);
        }

        public void merge(String r100, Message.Builder r101) throws InvalidProtocolBufferException {
            new ParserImpl(this.registry, this.ignoringUnknownFields, this.recursionLimit).merge(r100, r101);
        }

        private Parser(TypeRegistry r100, boolean r101, int r102) {
            this.registry = r100;
            this.ignoringUnknownFields = r101;
            this.recursionLimit = r102;
        }

        public /* synthetic */ Parser(TypeRegistry r100, boolean r101, int r102, AnonymousClass1 r103) {
            this(r100, r101, r102);
        }
    }

    public static class ParserImpl {
        private static final double EPSILON = 1.0E-6d;
        private static final BigDecimal MAX_DOUBLE = null;
        private static final BigInteger MAX_UINT64 = null;
        private static final BigDecimal MIN_DOUBLE = null;
        private static final BigDecimal MORE_THAN_ONE = null;
        private static final Map<String, WellKnownTypeParser> wellKnownTypeParsers = null;
        private int currentDepth;
        private final Map<Descriptors.Descriptor, Map<String, Descriptors.FieldDescriptor>> fieldNameMaps;
        private final boolean ignoringUnknownFields;
        private final JsonParser jsonParser;
        private final int recursionLimit;
        private final TypeRegistry registry;

        public interface WellKnownTypeParser {
            void merge(ParserImpl r100, JsonElement r101, Message.Builder r102) throws InvalidProtocolBufferException;
        }

        private static Map<String, WellKnownTypeParser> buildWellKnownTypeParsers() {
            HashMap r100 = new HashMap();
            r100.put(Any.getDescriptor().getFullName(), new AnonymousClass1());
            WellKnownTypeParser r101 = new AnonymousClass2();
            r100.put(BoolValue.getDescriptor().getFullName(), r101);
            r100.put(Int32Value.getDescriptor().getFullName(), r101);
            r100.put(UInt32Value.getDescriptor().getFullName(), r101);
            r100.put(Int64Value.getDescriptor().getFullName(), r101);
            r100.put(UInt64Value.getDescriptor().getFullName(), r101);
            r100.put(StringValue.getDescriptor().getFullName(), r101);
            r100.put(BytesValue.getDescriptor().getFullName(), r101);
            r100.put(FloatValue.getDescriptor().getFullName(), r101);
            r100.put(DoubleValue.getDescriptor().getFullName(), r101);
            r100.put(Timestamp.getDescriptor().getFullName(), new AnonymousClass3());
            r100.put(Duration.getDescriptor().getFullName(), new AnonymousClass4());
            r100.put(FieldMask.getDescriptor().getFullName(), new AnonymousClass5());
            r100.put(Struct.getDescriptor().getFullName(), new AnonymousClass6());
            r100.put(ListValue.getDescriptor().getFullName(), new AnonymousClass7());
            r100.put(Value.getDescriptor().getFullName(), new AnonymousClass8());
            return r100;
        }

        static {
            wellKnownTypeParsers = buildWellKnownTypeParsers();
            MAX_UINT64 = new BigInteger("FFFFFFFFFFFFFFFF", 16);
            BigDecimal r100 = new BigDecimal(String.valueOf(1.000001d));
            MORE_THAN_ONE = r100;
            MAX_DOUBLE = new BigDecimal(String.valueOf(Double.MAX_VALUE)).multiply(r100);
            MIN_DOUBLE = new BigDecimal(String.valueOf(-1.7976931348623157E308d)).multiply(r100);
        }

        private Map<String, Descriptors.FieldDescriptor> getFieldNameMap(Descriptors.Descriptor r100) {
            if (this.fieldNameMaps.containsKey(r100) == true) goto L11;
            HashMap r101 = new HashMap();
            Iterator<Descriptors.FieldDescriptor> r102 = r100.getFields().iterator();
        L6:
            if (r102.hasNext() == false) goto L8;
            Descriptors.FieldDescriptor r103 = r102.next();
            r101.put(r103.getName(), r103);
            r101.put(r103.getJsonName(), r103);
            goto L6
        L8:
            this.fieldNameMaps.put(r100, r101);
            return r101;
        L11:
            return this.fieldNameMaps.get(r100);
        }

        private boolean parseBool(JsonElement r100) throws InvalidProtocolBufferException {
            if (r100.getAsString().equals("true") == false) goto L7;
            return true;
        L7:
            if (r100.getAsString().equals("false") == false) goto L11;
            return false;
        L11:
            throw new InvalidProtocolBufferException("Invalid bool value: " + r100);
        }

        private ByteString parseBytes(JsonElement r100) throws InvalidProtocolBufferException {
            return ByteString.copyFrom(BaseEncoding.f275606a.a(r100.getAsString()));
        L5:
            return ByteString.copyFrom(BaseEncoding.f275607b.a(r100.getAsString()));
        }

        private double parseDouble(JsonElement r100) throws InvalidProtocolBufferException {
            if (r100.getAsString().equals("NaN") == false) goto L7;
            return Double.NaN;
        L7:
            if (r100.getAsString().equals("Infinity") == false) goto L11;
            return Double.POSITIVE_INFINITY;
        L11:
            if (r100.getAsString().equals("-Infinity") == false) goto L26;
            return Double.NEGATIVE_INFINITY;
        L26:
            BigDecimal r101 = new BigDecimal(r100.getAsString());     // Catch: Exception -> L22 InvalidProtocolBufferException -> L24
            if (r101.compareTo(MAX_DOUBLE) > 0) goto L21;
            if (r101.compareTo(MIN_DOUBLE) < 0) goto L21;
            return r101.doubleValue();
        L21:
            throw new InvalidProtocolBufferException("Out of range double value: " + r100);     // Catch: Exception -> L22 InvalidProtocolBufferException -> L24
        L24:
            e = move-exception;
            throw e;
        L23:
            throw new InvalidProtocolBufferException("Not an double value: " + r100);
        }

        private float parseFloat(JsonElement r100) throws InvalidProtocolBufferException {
            if (r100.getAsString().equals("NaN") == false) goto L7;
            return Float.NaN;
        L7:
            if (r100.getAsString().equals("Infinity") == false) goto L11;
            return Float.POSITIVE_INFINITY;
        L11:
            if (r100.getAsString().equals("-Infinity") == false) goto L26;
            return Float.NEGATIVE_INFINITY;
        L26:
            double r101 = CastDoubleProtector.parseDouble(r100.getAsString());     // Catch: Exception -> L22 InvalidProtocolBufferException -> L24
            if (r101 > 3.402826869208755E38d) goto L21;
            if (r101 < (-3.402826869208755E38d)) goto L21;
            return (float) r101;
        L21:
            throw new InvalidProtocolBufferException("Out of range float value: " + r100);     // Catch: Exception -> L22 InvalidProtocolBufferException -> L24
        L24:
            e = move-exception;
            throw e;
        L23:
            throw new InvalidProtocolBufferException("Not a float value: " + r100);
        }

        private int parseInt32(JsonElement r100) throws InvalidProtocolBufferException {
            return CastIntegerProtector.parseInt(r100.getAsString());
        L4:
            return new BigDecimal(r100.getAsString()).intValueExact();
        L7:
            throw new InvalidProtocolBufferException("Not an int32 value: " + r100);
        }

        private long parseInt64(JsonElement r100) throws InvalidProtocolBufferException {
            return CastLongProtector.parseLong(r100.getAsString());
        L4:
            return new BigDecimal(r100.getAsString()).longValueExact();
        L7:
            throw new InvalidProtocolBufferException("Not an int64 value: " + r100);
        }

        private String parseString(JsonElement r100) {
            return r100.getAsString();
        }

        private int parseUint32(JsonElement r100) throws InvalidProtocolBufferException {
            long r101 = CastLongProtector.parseLong(r100.getAsString());     // Catch: Exception -> L11 InvalidProtocolBufferException -> L23
            if (r101 < 0) goto L10;
            if (r101 > BodyPartID.bodyIdMax) goto L10;
            return (int) r101;
        L10:
            throw new InvalidProtocolBufferException("Out of range uint32 value: " + r100);     // Catch: Exception -> L11 InvalidProtocolBufferException -> L23
        L23:
            e = move-exception;
            throw e;
        L11:
            BigInteger r102 = new BigDecimal(r100.getAsString()).toBigIntegerExact();     // Catch: Exception -> L19 InvalidProtocolBufferException -> L21
            if (r102.signum() < 0) goto L18;
            if (r102.compareTo(new BigInteger("FFFFFFFF", 16)) > 0) goto L18;
            return r102.intValue();
        L18:
            throw new InvalidProtocolBufferException("Out of range uint32 value: " + r100);     // Catch: Exception -> L19 InvalidProtocolBufferException -> L21
        L21:
            e = move-exception;
            throw e;
        L20:
            throw new InvalidProtocolBufferException("Not an uint32 value: " + r100);
        }

        private long parseUint64(JsonElement r100) throws InvalidProtocolBufferException {
            BigInteger r101 = new BigDecimal(r100.getAsString()).toBigIntegerExact();     // Catch: Exception -> L11 InvalidProtocolBufferException -> L13
            if (r101.compareTo(BigInteger.ZERO) < 0) goto L10;
            if (r101.compareTo(MAX_UINT64) > 0) goto L10;
            return r101.longValue();
        L10:
            throw new InvalidProtocolBufferException("Out of range uint64 value: " + r100);     // Catch: Exception -> L11 InvalidProtocolBufferException -> L13
        L13:
            e = move-exception;
            throw e;
        L12:
            throw new InvalidProtocolBufferException("Not an uint64 value: " + r100);
        }

        private void mergeAny(JsonElement r100, Message.Builder r101) throws InvalidProtocolBufferException {
            Descriptors.Descriptor r102 = r101.getDescriptorForType();
            Descriptors.FieldDescriptor r103 = r102.findFieldByName("type_url");
            Descriptors.FieldDescriptor r104 = r102.findFieldByName("value");
            if (r103 == null) goto L33;
            if (r104 == null) goto L33;
            if (r103.getType() != Descriptors.FieldDescriptor.Type.STRING) goto L33;
            if (r104.getType() != Descriptors.FieldDescriptor.Type.BYTES) goto L33;
            if ((r100 instanceof JsonObject) == false) goto L31;
            JsonObject r105 = (JsonObject) r100;
            if (r105.entrySet().isEmpty() == false) goto L14;
            return;
        L14:
            JsonElement r106 = r105.get("@type");
            if (r106 == null) goto L29;
            String r107 = r106.getAsString();
            Descriptors.Descriptor r108 = this.registry.find(JsonFormat.access$1700(r107));
            if (r108 == null) goto L27;
            r101.setField(r103, r107);
            DynamicMessage.Builder r109 = DynamicMessage.getDefaultInstance(r108).newBuilderForType();
            WellKnownTypeParser r110 = wellKnownTypeParsers.get(r108.getFullName());
            if (r110 == null) goto L23;
            JsonElement r111 = r105.get("value");
            if (r111 == null) goto L24;
            r110.merge(this, r111, r109);
        L24:
            r101.setField(r104, r109.build().toByteString());
            return;
        L23:
            mergeMessage(r100, r109, true);
            goto L24
        L27:
            throw new InvalidProtocolBufferException("Cannot resolve type: " + r107);
        L29:
            throw new InvalidProtocolBufferException("Missing type url when parsing: " + r100);
        L31:
            throw new InvalidProtocolBufferException("Expect message object but got: " + r100);
        L33:
            throw new InvalidProtocolBufferException("Invalid Any type.");
        }

        private void mergeDuration(JsonElement r100, Message.Builder r101) throws InvalidProtocolBufferException {
            r101.mergeFrom(Durations.parse(r100.getAsString()).toByteString());     // Catch: ParseException -> L4
            return;
        L5:
            throw new InvalidProtocolBufferException("Failed to parse duration: " + r100);
        }

        private void mergeFieldMask(JsonElement r100, Message.Builder r101) throws InvalidProtocolBufferException {
            r101.mergeFrom(FieldMaskUtil.fromJsonString(r100.getAsString()).toByteString());
        }

        private void mergeListValue(JsonElement r100, Message.Builder r101) throws InvalidProtocolBufferException {
            Descriptors.FieldDescriptor r102 = r101.getDescriptorForType().findFieldByName("values");
            if (r102 == null) goto L7;
            mergeRepeatedField(r102, r100, r101);
            return;
        L7:
            throw new InvalidProtocolBufferException("Invalid ListValue type.");
        }

        private void mergeStruct(JsonElement r100, Message.Builder r101) throws InvalidProtocolBufferException {
            Descriptors.FieldDescriptor r102 = r101.getDescriptorForType().findFieldByName(SlcCommonAction.KEY_PARAMS);
            if (r102 == null) goto L7;
            mergeMapField(r102, r100, r101);
            return;
        L7:
            throw new InvalidProtocolBufferException("Invalid Struct type.");
        }

        private void mergeTimestamp(JsonElement r100, Message.Builder r101) throws InvalidProtocolBufferException {
            r101.mergeFrom(Timestamps.parse(r100.getAsString()).toByteString());     // Catch: ParseException -> L4
            return;
        L5:
            throw new InvalidProtocolBufferException("Failed to parse timestamp: " + r100);
        }

        private void mergeValue(JsonElement r100, Message.Builder r101) throws InvalidProtocolBufferException {
            Descriptors.Descriptor r102 = r101.getDescriptorForType();
            if ((r100 instanceof JsonPrimitive) == false) goto L12;
            JsonPrimitive r103 = (JsonPrimitive) r100;
            if (r103.isBoolean() == false) goto L8;
            r101.setField(r102.findFieldByName("bool_value"), Boolean.valueOf(r103.getAsBoolean()));
            return;
        L8:
            if (r103.isNumber() == false) goto L10;
            r101.setField(r102.findFieldByName("number_value"), Double.valueOf(r103.getAsDouble()));
            return;
        L10:
            r101.setField(r102.findFieldByName("string_value"), r103.getAsString());
            return;
        L12:
            if ((r100 instanceof JsonObject) == false) goto L15;
            Descriptors.FieldDescriptor r104 = r102.findFieldByName("struct_value");
            Message.Builder r105 = r101.newBuilderForField(r104);
            merge(r100, r105);
            r101.setField(r104, r105.build());
            return;
        L15:
            if ((r100 instanceof JsonArray) == false) goto L18;
            Descriptors.FieldDescriptor r106 = r102.findFieldByName("list_value");
            Message.Builder r107 = r101.newBuilderForField(r106);
            merge(r100, r107);
            r101.setField(r106, r107.build());
            return;
        L18:
            if ((r100 instanceof JsonNull) == false) goto L22;
            r101.setField(r102.findFieldByName("null_value"), NullValue.NULL_VALUE.getValueDescriptor());
            return;
        L22:
            throw new IllegalStateException("Unexpected json data: " + r100);
        }

        private void mergeWrapper(JsonElement r100, Message.Builder r101) throws InvalidProtocolBufferException {
            Descriptors.Descriptor r102 = r101.getDescriptorForType();
            Descriptors.FieldDescriptor r103 = r102.findFieldByName("value");
            if (r103 == null) goto L7;
            r101.setField(r103, parseFieldValue(r103, r100, r101));
            return;
        L7:
            throw new InvalidProtocolBufferException("Invalid wrapper type: " + r102.getFullName());
        }

        private Descriptors.EnumValueDescriptor parseEnum(Descriptors.EnumDescriptor r100, JsonElement r101) throws InvalidProtocolBufferException {
            String r102 = r101.getAsString();
            Descriptors.EnumValueDescriptor r103 = r100.findValueByName(r102);
            if (r103 == null) goto L15;
        L14:
            return r103;
        L15:
            int r104 = parseInt32(r101);     // Catch: InvalidProtocolBufferException -> L9
            if (r100.getFile().getSyntax() != Descriptors.FileDescriptor.Syntax.PROTO3) goto L7;
            Descriptors.EnumValueDescriptor r105 = r100.findValueByNumberCreatingIfUnknown(r104);     // Catch: InvalidProtocolBufferException -> L9
        L8:
            r103 = r105;
            goto L10
        L7:
            r105 = r100.findValueByNumber(r104);     // Catch: InvalidProtocolBufferException -> L9
        L10:
            if (r103 != null) goto L14;
            throw new InvalidProtocolBufferException("Invalid enum value: " + r102 + " for enum type: " + r100.getFullName());
        }

        public void merge(Reader r100, Message.Builder r101) throws IOException {
            JsonReader r102 = new JsonReader(r100);     // Catch: Exception -> L4 JsonIOException -> L7 InvalidProtocolBufferException -> L14
            r102.setLenient(false);     // Catch: Exception -> L4 JsonIOException -> L7 InvalidProtocolBufferException -> L14
            merge(this.jsonParser.parse(r102), r101);     // Catch: Exception -> L4 JsonIOException -> L7 InvalidProtocolBufferException -> L14
            return;
        L7:
            e = move-exception;
            if ((e.getCause() instanceof IOException) == false) goto L13;
            throw ((IOException) e.getCause());
        L13:
            throw new InvalidProtocolBufferException(e.getMessage());
        L14:
            e = move-exception;
            throw e;
        L4:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage());
        }

        public void merge(String r100, Message.Builder r101) throws InvalidProtocolBufferException {
            JsonReader r102 = new JsonReader(new StringReader(r100));     // Catch: Exception -> L4 InvalidProtocolBufferException -> L7
            r102.setLenient(false);     // Catch: Exception -> L4 InvalidProtocolBufferException -> L7
            merge(this.jsonParser.parse(r102), r101);     // Catch: Exception -> L4 InvalidProtocolBufferException -> L7
            return;
        L7:
            e = move-exception;
            throw e;
        L4:
            e = move-exception;
            throw new InvalidProtocolBufferException(e.getMessage());
        }

        private void merge(JsonElement r100, Message.Builder r101) throws InvalidProtocolBufferException {
            WellKnownTypeParser r102 = wellKnownTypeParsers.get(r101.getDescriptorForType().getFullName());
            if (r102 == null) goto L6;
            r102.merge(this, r100, r101);
            return;
        L6:
            mergeMessage(r100, r101, false);
        }

        public ParserImpl(TypeRegistry r100, boolean r101, int r102) {
            this.fieldNameMaps = new HashMap();
            this.registry = r100;
            this.ignoringUnknownFields = r101;
            this.jsonParser = new JsonParser();
            this.recursionLimit = r102;
            this.currentDepth = 0;
        }

        public static /* synthetic */ void access$2000(ParserImpl r100, JsonElement r101, Message.Builder r102) throws InvalidProtocolBufferException {
            r100.mergeAny(r101, r102);
        }

        public static /* synthetic */ void access$2100(ParserImpl r100, JsonElement r101, Message.Builder r102) throws InvalidProtocolBufferException {
            r100.mergeWrapper(r101, r102);
        }

        public static /* synthetic */ void access$2200(ParserImpl r100, JsonElement r101, Message.Builder r102) throws InvalidProtocolBufferException {
            r100.mergeTimestamp(r101, r102);
        }

        public static /* synthetic */ void access$2300(ParserImpl r100, JsonElement r101, Message.Builder r102) throws InvalidProtocolBufferException {
            r100.mergeDuration(r101, r102);
        }

        public static /* synthetic */ void access$2400(ParserImpl r100, JsonElement r101, Message.Builder r102) throws InvalidProtocolBufferException {
            r100.mergeFieldMask(r101, r102);
        }

        public static /* synthetic */ void access$2500(ParserImpl r100, JsonElement r101, Message.Builder r102) throws InvalidProtocolBufferException {
            r100.mergeStruct(r101, r102);
        }

        public static /* synthetic */ void access$2600(ParserImpl r100, JsonElement r101, Message.Builder r102) throws InvalidProtocolBufferException {
            r100.mergeListValue(r101, r102);
        }

        public static /* synthetic */ void access$2700(ParserImpl r100, JsonElement r101, Message.Builder r102) throws InvalidProtocolBufferException {
            r100.mergeValue(r101, r102);
        }

        private void mergeField(Descriptors.FieldDescriptor r100, JsonElement r101, Message.Builder r102) throws InvalidProtocolBufferException {
            if (r100.isRepeated() == false) goto L10;
            if (r102.getRepeatedFieldCount(r100) <= 0) goto L19;
            throw new InvalidProtocolBufferException("Field " + r100.getFullName() + " has already been set.");
        L19:
            if (r100.isRepeated() == false) goto L24;
            if ((r101 instanceof JsonNull) == false) goto L24;
            return;
        L24:
            if (r100.isMapField() == false) goto L27;
            mergeMapField(r100, r101, r102);
            return;
        L27:
            if (r100.isRepeated() == false) goto L29;
            mergeRepeatedField(r100, r101, r102);
            return;
        L29:
            Object r103 = parseFieldValue(r100, r101, r102);
            if (r103 == null) goto L37;
            r102.setField(r100, r103);
            return;
        L37:
            return;
        L10:
            if (r102.hasField(r100) == true) goto L34;
            if (r100.getContainingOneof() == null) goto L19;
            if (r102.getOneofFieldDescriptor(r100.getContainingOneof()) == null) goto L19;
            throw new InvalidProtocolBufferException("Cannot set field " + r100.getFullName() + " because another field " + r102.getOneofFieldDescriptor(r100.getContainingOneof()).getFullName() + " belonging to the same oneof has already been set ");
        L34:
            throw new InvalidProtocolBufferException("Field " + r100.getFullName() + " has already been set.");
        }

        private void mergeMapField(Descriptors.FieldDescriptor r100, JsonElement r101, Message.Builder r102) throws InvalidProtocolBufferException {
            if ((r101 instanceof JsonObject) == false) goto L19;
            Descriptors.Descriptor r103 = r100.getMessageType();
            Descriptors.FieldDescriptor r104 = r103.findFieldByName("key");
            Descriptors.FieldDescriptor r105 = r103.findFieldByName("value");
            if (r104 == null) goto L17;
            if (r105 == null) goto L17;
            Iterator<Map.Entry<String, JsonElement>> r106 = ((JsonObject) r101).entrySet().iterator();
        L9:
            if (r106.hasNext() == false) goto L15;
            Map.Entry<String, JsonElement> r107 = r106.next();
            Message.Builder r108 = r102.newBuilderForField(r100);
            Object r109 = parseFieldValue(r104, new JsonPrimitive(r107.getKey()), r108);
            Object r110 = parseFieldValue(r105, r107.getValue(), r108);
            if (r110 == null) goto L14;
            r108.setField(r104, r109);
            r108.setField(r105, r110);
            r102.addRepeatedField(r100, r108.build());
            goto L9
        L14:
            throw new InvalidProtocolBufferException("Map value cannot be null.");
        L15:
            return;
        L17:
            throw new InvalidProtocolBufferException("Invalid map field: " + r100.getFullName());
        L19:
            throw new InvalidProtocolBufferException("Expect a map object but found: " + r101);
        }

        private void mergeMessage(JsonElement r100, Message.Builder r101, boolean r102) throws InvalidProtocolBufferException {
            if ((r100 instanceof JsonObject) == false) goto L22;
            Map<String, Descriptors.FieldDescriptor> r103 = getFieldNameMap(r101.getDescriptorForType());
            Iterator<Map.Entry<String, JsonElement>> r104 = ((JsonObject) r100).entrySet().iterator();
        L6:
            if (r104.hasNext() == false) goto L20;
            Map.Entry<String, JsonElement> r105 = r104.next();
            if (r102 == false) goto L12;
            if (r105.getKey().equals("@type") == true) goto L6;
        L12:
            Descriptors.FieldDescriptor r106 = r103.get(r105.getKey());
            if (r106 == null) goto L15;
            mergeField(r106, r105.getValue(), r101);
            goto L6
        L15:
            if (this.ignoringUnknownFields == true) goto L6;
            throw new InvalidProtocolBufferException("Cannot find field: " + r105.getKey() + " in message " + r101.getDescriptorForType().getFullName());
        L20:
            return;
        L22:
            throw new InvalidProtocolBufferException("Expect message object but got: " + r100);
        }

        private void mergeRepeatedField(Descriptors.FieldDescriptor r100, JsonElement r101, Message.Builder r102) throws InvalidProtocolBufferException {
            if ((r101 instanceof JsonArray) == false) goto L14;
            JsonArray r103 = (JsonArray) r101;
            int r104 = 0;
        L6:
            if (r104 >= r103.size()) goto L12;
            Object r105 = parseFieldValue(r100, r103.get(r104), r102);
            if (r105 == null) goto L11;
            r102.addRepeatedField(r100, r105);
            r104 = r104 + 1;
            goto L6
        L11:
            throw new InvalidProtocolBufferException("Repeated field elements cannot be null in field: " + r100.getFullName());
        L12:
            return;
        L14:
            throw new InvalidProtocolBufferException("Expect an array but found: " + r101);
        }

        private Object parseFieldValue(Descriptors.FieldDescriptor r100, JsonElement r101, Message.Builder r102) throws InvalidProtocolBufferException {
            if ((r101 instanceof JsonNull) == false) goto L19;
            if (r100.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L11;
            if (r100.getMessageType().getFullName().equals(Value.getDescriptor().getFullName()) == false) goto L11;
            return r102.newBuilderForField(r100).mergeFrom(Value.newBuilder().setNullValueValue(0).build().toByteString()).build();
        L11:
            if (r100.getJavaType() == Descriptors.FieldDescriptor.JavaType.ENUM) goto L13;
            return null;
        L13:
            if (r100.getEnumType().getFullName().equals(NullValue.getDescriptor().getFullName()) == true) goto L15;
            return null;
        L15:
            return r100.getEnumType().findValueByNumber(0);
        L19:
            switch(AnonymousClass1.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[r100.getType().ordinal()]) {
                case 1: goto L47;
                case 2: goto L47;
                case 3: goto L47;
                case 4: goto L45;
                case 5: goto L45;
                case 6: goto L45;
                case 7: goto L43;
                case 8: goto L41;
                case 9: goto L39;
                case 10: goto L37;
                case 11: goto L37;
                case 12: goto L35;
                case 13: goto L35;
                case 14: goto L33;
                case 15: goto L31;
                case 16: goto L29;
                case 17: goto L22;
                case 18: goto L22;
                default: goto L21;
            };
        L22:
            int r103 = this.currentDepth;
            if (r103 >= this.recursionLimit) goto L27;
            this.currentDepth = r103 + 1;
            Message.Builder r104 = r102.newBuilderForField(r100);
            merge(r101, r104);
            this.currentDepth--;
            return r104.build();
        L27:
            throw new InvalidProtocolBufferException("Hit recursion limit.");
        L21:
            throw new InvalidProtocolBufferException("Invalid field type: " + r100.getType());
        L29:
            return parseEnum(r100.getEnumType(), r101);
        L31:
            return parseBytes(r101);
        L33:
            return parseString(r101);
        L35:
            return Long.valueOf(parseUint64(r101));
        L37:
            return Integer.valueOf(parseUint32(r101));
        L39:
            return Double.valueOf(parseDouble(r101));
        L41:
            return Float.valueOf(parseFloat(r101));
        L43:
            return Boolean.valueOf(parseBool(r101));
        L45:
            return Long.valueOf(parseInt64(r101));
        L47:
            return Integer.valueOf(parseInt32(r101));
        }
    }

    public static final class PrettyTextGenerator implements TextGenerator {
        private boolean atStartOfLine;
        private final StringBuilder indent;
        private final Appendable output;

        @Override // com.google.protobuf.util.JsonFormat.TextGenerator
        public void indent() {
            this.indent.append(c.DEFAULT_TEXT);
        }

        @Override // com.google.protobuf.util.JsonFormat.TextGenerator
        public void outdent() {
            int r100 = this.indent.length();
            if (r100 < 2) goto L7;
            this.indent.delete(r100 - 2, r100);
            return;
        L7:
            throw new IllegalArgumentException(" Outdent() without matching Indent().");
        }

        private PrettyTextGenerator(Appendable r100) {
            this.indent = new StringBuilder();
            this.atStartOfLine = true;
            this.output = r100;
        }

        private void write(CharSequence r100) throws IOException {
            if (r100.length() != 0) goto L6;
            return;
        L6:
            if (this.atStartOfLine == false) goto L8;
            this.atStartOfLine = false;
            this.output.append(this.indent);
        L8:
            this.output.append(r100);
        }

        @Override // com.google.protobuf.util.JsonFormat.TextGenerator
        public void print(CharSequence r100) throws IOException {
            int r101 = r100.length();
            int r102 = 0;
            int r103 = 0;
        L3:
            if (r102 >= r101) goto L8;
            if (r100.charAt(r102) != '\n') goto L7;
            int r104 = r102 + 1;
            write(r100.subSequence(r103, r104));
            this.atStartOfLine = true;
            r103 = r104;
        L7:
            r102 = r102 + 1;
            goto L3
        L8:
            write(r100.subSequence(r103, r101));
        }

        public /* synthetic */ PrettyTextGenerator(Appendable r100, AnonymousClass1 r101) {
            this(r100);
        }
    }

    public static class Printer {
        private boolean alwaysOutputDefaultValueFields;
        private Set<Descriptors.FieldDescriptor> includingDefaultValueFields;
        private final boolean omittingInsignificantWhitespace;
        private final boolean preservingProtoFieldNames;
        private final TypeRegistry registry;

        private void checkUnsetIncludingDefaultValueFields() {
            if (this.alwaysOutputDefaultValueFields == true) goto L8;
            if (this.includingDefaultValueFields.isEmpty() == false) goto L8;
            return;
        L8:
            throw new IllegalStateException("JsonFormat includingDefaultValueFields has already been set.");
        }

        public Printer omittingInsignificantWhitespace() {
            return new Printer(this.registry, this.alwaysOutputDefaultValueFields, this.includingDefaultValueFields, this.preservingProtoFieldNames, true);
        }

        public Printer preservingProtoFieldNames() {
            return new Printer(this.registry, this.alwaysOutputDefaultValueFields, this.includingDefaultValueFields, true, this.omittingInsignificantWhitespace);
        }

        public Printer includingDefaultValueFields() {
            checkUnsetIncludingDefaultValueFields();
            return new Printer(this.registry, true, Collections.emptySet(), this.preservingProtoFieldNames, this.omittingInsignificantWhitespace);
        }

        public Printer includingDefaultValueFields(Set<Descriptors.FieldDescriptor> r100) {
            if (r100 != null) goto L4;
        L6:
            boolean r101 = false;
        L7:
            m.c(r101, "Non-empty Set must be supplied for includingDefaultValueFields.");
            checkUnsetIncludingDefaultValueFields();
            return new Printer(this.registry, false, r100, this.preservingProtoFieldNames, this.omittingInsignificantWhitespace);
        L4:
            if (r100.isEmpty() == true) goto L6;
            r101 = true;
            goto L7
        }

        public String print(MessageOrBuilder r100) throws InvalidProtocolBufferException {
            StringBuilder r101 = new StringBuilder();     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            appendTo(r100, r101);     // Catch: IOException -> L4 InvalidProtocolBufferException -> L7
            return r101.toString();
        L7:
            e = move-exception;
            throw e;
        L4:
            e = move-exception;
            throw new IllegalStateException(e);
        }

        public Printer usingTypeRegistry(TypeRegistry r100) {
            if (this.registry != TypeRegistry.getEmptyTypeRegistry()) goto L7;
            return new Printer(r100, this.alwaysOutputDefaultValueFields, this.includingDefaultValueFields, this.preservingProtoFieldNames, this.omittingInsignificantWhitespace);
        L7:
            throw new IllegalArgumentException("Only one registry is allowed.");
        }

        public void appendTo(MessageOrBuilder r100, Appendable r110) throws IOException {
            new PrinterImpl(this.registry, this.alwaysOutputDefaultValueFields, this.includingDefaultValueFields, this.preservingProtoFieldNames, r110, this.omittingInsignificantWhitespace).print(r100);
        }

        private Printer(TypeRegistry r100, boolean r101, Set<Descriptors.FieldDescriptor> r102, boolean r103, boolean r104) {
            this.registry = r100;
            this.alwaysOutputDefaultValueFields = r101;
            this.includingDefaultValueFields = r102;
            this.preservingProtoFieldNames = r103;
            this.omittingInsignificantWhitespace = r104;
        }

        public /* synthetic */ Printer(TypeRegistry r100, boolean r101, Set r102, boolean r103, boolean r104, AnonymousClass1 r105) {
            this(r100, r101, r102, r103, r104);
        }
    }

    public static final class PrinterImpl {
        private static final Map<String, WellKnownTypePrinter> wellKnownTypePrinters = null;
        private final boolean alwaysOutputDefaultValueFields;
        private final CharSequence blankOrNewLine;
        private final CharSequence blankOrSpace;
        private final TextGenerator generator;
        private final Gson gson;
        private final Set<Descriptors.FieldDescriptor> includingDefaultValueFields;
        private final boolean preservingProtoFieldNames;
        private final TypeRegistry registry;

        public static class GsonHolder {
            private static final Gson DEFAULT_GSON = null;

            private GsonHolder() {
            }

            static {
                DEFAULT_GSON = new GsonBuilder().disableHtmlEscaping().create();
            }

            public static /* synthetic */ Gson access$600() {
                return DEFAULT_GSON;
            }
        }

        public interface WellKnownTypePrinter {
            void print(PrinterImpl r100, MessageOrBuilder r101) throws IOException;
        }

        private static Map<String, WellKnownTypePrinter> buildWellKnownTypePrinters() {
            HashMap r100 = new HashMap();
            r100.put(Any.getDescriptor().getFullName(), new AnonymousClass1());
            WellKnownTypePrinter r101 = new AnonymousClass2();
            r100.put(BoolValue.getDescriptor().getFullName(), r101);
            r100.put(Int32Value.getDescriptor().getFullName(), r101);
            r100.put(UInt32Value.getDescriptor().getFullName(), r101);
            r100.put(Int64Value.getDescriptor().getFullName(), r101);
            r100.put(UInt64Value.getDescriptor().getFullName(), r101);
            r100.put(StringValue.getDescriptor().getFullName(), r101);
            r100.put(BytesValue.getDescriptor().getFullName(), r101);
            r100.put(FloatValue.getDescriptor().getFullName(), r101);
            r100.put(DoubleValue.getDescriptor().getFullName(), r101);
            r100.put(Timestamp.getDescriptor().getFullName(), new AnonymousClass3());
            r100.put(Duration.getDescriptor().getFullName(), new AnonymousClass4());
            r100.put(FieldMask.getDescriptor().getFullName(), new AnonymousClass5());
            r100.put(Struct.getDescriptor().getFullName(), new AnonymousClass6());
            r100.put(Value.getDescriptor().getFullName(), new AnonymousClass7());
            r100.put(ListValue.getDescriptor().getFullName(), new AnonymousClass8());
            return r100;
        }

        static {
            wellKnownTypePrinters = buildWellKnownTypePrinters();
        }

        private void printAny(MessageOrBuilder r100) throws IOException {
            if (Any.getDefaultInstance().equals(r100) == false) goto L6;
            this.generator.print(SliceInitService.DEFAULT_SWITCH);
            return;
        L6:
            Descriptors.Descriptor r101 = r100.getDescriptorForType();
            Descriptors.FieldDescriptor r102 = r101.findFieldByName("type_url");
            Descriptors.FieldDescriptor r103 = r101.findFieldByName("value");
            if (r102 == null) goto L23;
            if (r103 == null) goto L23;
            if (r102.getType() != Descriptors.FieldDescriptor.Type.STRING) goto L23;
            if (r103.getType() != Descriptors.FieldDescriptor.Type.BYTES) goto L23;
            String r104 = (String) r100.getField(r102);
            String r105 = JsonFormat.access$1700(r104);
            Descriptors.Descriptor r106 = this.registry.find(r105);
            if (r106 == null) goto L21;
            DynamicMessage r107 = DynamicMessage.getDefaultInstance(r106).getParserForType().parseFrom((ByteString) r100.getField(r103));
            WellKnownTypePrinter r108 = wellKnownTypePrinters.get(r105);
            if (r108 == null) goto L18;
            this.generator.print("{" + this.blankOrNewLine);
            this.generator.indent();
            this.generator.print("\"@type\":" + this.blankOrSpace + GsonProtectorUtils.toJson(this.gson, r104) + "," + this.blankOrNewLine);
            TextGenerator r109 = this.generator;
            StringBuilder r110 = new StringBuilder("\"value\":");
            r110.append(this.blankOrSpace);
            r109.print(r110.toString());
            r108.print(this, r107);
            this.generator.print(this.blankOrNewLine);
            this.generator.outdent();
            this.generator.print(i.f25855d);
            return;
        L18:
            print(r107, r104);
            return;
        L21:
            throw new InvalidProtocolBufferException("Cannot find type for url: " + r104);
        L23:
            throw new InvalidProtocolBufferException("Invalid Any type.");
        }

        private void printDuration(MessageOrBuilder r100) throws IOException {
            Duration r101 = Duration.parseFrom(toByteString(r100));
            this.generator.print("\"" + Durations.toString(r101) + "\"");
        }

        private void printFieldMask(MessageOrBuilder r100) throws IOException {
            FieldMask r101 = FieldMask.parseFrom(toByteString(r100));
            this.generator.print("\"" + FieldMaskUtil.toJsonString(r101) + "\"");
        }

        private void printListValue(MessageOrBuilder r100) throws IOException {
            Descriptors.FieldDescriptor r101 = r100.getDescriptorForType().findFieldByName("values");
            if (r101 == null) goto L7;
            printRepeatedFieldValue(r101, r100.getField(r101));
            return;
        L7:
            throw new InvalidProtocolBufferException("Invalid ListValue type.");
        }

        private void printStruct(MessageOrBuilder r100) throws IOException {
            Descriptors.FieldDescriptor r101 = r100.getDescriptorForType().findFieldByName(SlcCommonAction.KEY_PARAMS);
            if (r101 == null) goto L7;
            printMapFieldValue(r101, r100.getField(r101));
            return;
        L7:
            throw new InvalidProtocolBufferException("Invalid Struct type.");
        }

        private void printTimestamp(MessageOrBuilder r100) throws IOException {
            Timestamp r101 = Timestamp.parseFrom(toByteString(r100));
            this.generator.print("\"" + Timestamps.toString(r101) + "\"");
        }

        private void printValue(MessageOrBuilder r100) throws IOException {
            Map<Descriptors.FieldDescriptor, Object> r101 = r100.getAllFields();
            if (r101.isEmpty() == false) goto L7;
            this.generator.print("null");
            return;
        L7:
            if (r101.size() != 1) goto L14;
            Iterator<Map.Entry<Descriptors.FieldDescriptor, Object>> r102 = r101.entrySet().iterator();
        L10:
            if (r102.hasNext() == false) goto L12;
            Map.Entry<Descriptors.FieldDescriptor, Object> r103 = r102.next();
            printSingleFieldValue(r103.getKey(), r103.getValue());
            goto L10
        L12:
            return;
        L14:
            throw new InvalidProtocolBufferException("Invalid Value type.");
        }

        private void printWrapper(MessageOrBuilder r100) throws IOException {
            Descriptors.FieldDescriptor r101 = r100.getDescriptorForType().findFieldByName("value");
            if (r101 == null) goto L7;
            printSingleFieldValue(r101, r100.getField(r101));
            return;
        L7:
            throw new InvalidProtocolBufferException("Invalid Wrapper type.");
        }

        private ByteString toByteString(MessageOrBuilder r100) {
            if ((r100 instanceof Message) == false) goto L7;
            return ((Message) r100).toByteString();
        L7:
            return ((Message.Builder) r100).build().toByteString();
        }

        public void print(MessageOrBuilder r100) throws IOException {
            WellKnownTypePrinter r101 = wellKnownTypePrinters.get(r100.getDescriptorForType().getFullName());
            if (r101 == null) goto L6;
            r101.print(this, r100);
            return;
        L6:
            print(r100, null);
        }

        public static /* synthetic */ void access$1000(PrinterImpl r100, MessageOrBuilder r101) throws IOException {
            r100.printWrapper(r101);
        }

        public static /* synthetic */ void access$1100(PrinterImpl r100, MessageOrBuilder r101) throws IOException {
            r100.printTimestamp(r101);
        }

        public static /* synthetic */ void access$1200(PrinterImpl r100, MessageOrBuilder r101) throws IOException {
            r100.printDuration(r101);
        }

        public static /* synthetic */ void access$1300(PrinterImpl r100, MessageOrBuilder r101) throws IOException {
            r100.printFieldMask(r101);
        }

        public static /* synthetic */ void access$1400(PrinterImpl r100, MessageOrBuilder r101) throws IOException {
            r100.printStruct(r101);
        }

        public static /* synthetic */ void access$1500(PrinterImpl r100, MessageOrBuilder r101) throws IOException {
            r100.printValue(r101);
        }

        public static /* synthetic */ void access$1600(PrinterImpl r100, MessageOrBuilder r101) throws IOException {
            r100.printListValue(r101);
        }

        public static /* synthetic */ void access$900(PrinterImpl r100, MessageOrBuilder r101) throws IOException {
            r100.printAny(r101);
        }

        private void print(MessageOrBuilder r100, String r101) throws IOException {
            this.generator.print("{" + this.blankOrNewLine);
            this.generator.indent();
            if (r101 == null) goto L5;
            this.generator.print("\"@type\":" + this.blankOrSpace + GsonProtectorUtils.toJson(this.gson, r101));
            boolean r102 = true;
        L7:
            if (this.alwaysOutputDefaultValueFields == false) goto L9;
        L12:
            TreeMap r103 = new TreeMap(r100.getAllFields());
            Iterator<Descriptors.FieldDescriptor> r104 = r100.getDescriptorForType().getFields().iterator();
        L14:
            if (r104.hasNext() == false) goto L34;
            Descriptors.FieldDescriptor r105 = r104.next();
            if (r105.isOptional() == false) goto L28;
            if (r105.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L23;
            if (r100.hasField(r105) == false) goto L14;
        L23:
            if (r105.getContainingOneof() == null) goto L28;
            if (r100.hasField(r105) == false) goto L14;
        L28:
            if (r103.containsKey(r105) == true) goto L14;
            if (this.alwaysOutputDefaultValueFields == true) goto L33;
            if (this.includingDefaultValueFields.contains(r105) == false) goto L14;
        L33:
            r103.put(r105, r100.getField(r105));
            goto L14
        L34:
            Map<Descriptors.FieldDescriptor, Object> r106 = r103;
        L35:
            Iterator<Map.Entry<Descriptors.FieldDescriptor, Object>> r107 = r106.entrySet().iterator();
        L37:
            if (r107.hasNext() == false) goto L43;
            Map.Entry<Descriptors.FieldDescriptor, Object> r108 = r107.next();
            if (r102 == false) goto L41;
            this.generator.print("," + this.blankOrNewLine);
        L42:
            printField(r108.getKey(), r108.getValue());
            goto L37
        L41:
            r102 = true;
            goto L42
        L43:
            if (r102 == false) goto L45;
            this.generator.print(this.blankOrNewLine);
        L45:
            this.generator.outdent();
            this.generator.print(i.f25855d);
            return;
        L9:
            if (this.includingDefaultValueFields.isEmpty() == false) goto L12;
            r106 = r100.getAllFields();
            goto L35
        L5:
            r102 = false;
            goto L7
        }

        private void printField(Descriptors.FieldDescriptor r100, Object r101) throws IOException {
            if (this.preservingProtoFieldNames == false) goto L5;
            this.generator.print("\"" + r100.getName() + "\":" + this.blankOrSpace);
        L7:
            if (r100.isMapField() == false) goto L10;
            printMapFieldValue(r100, r101);
            return;
        L10:
            if (r100.isRepeated() == false) goto L12;
            printRepeatedFieldValue(r100, r101);
            return;
        L12:
            printSingleFieldValue(r100, r101);
            return;
        L5:
            this.generator.print("\"" + r100.getJsonName() + "\":" + this.blankOrSpace);
            goto L7
        }

        private void printMapFieldValue(Descriptors.FieldDescriptor r100, Object r110) throws IOException {
            Descriptors.Descriptor r101 = r100.getMessageType();
            Descriptors.FieldDescriptor r102 = r101.findFieldByName("key");
            Descriptors.FieldDescriptor r103 = r101.findFieldByName("value");
            if (r102 == null) goto L18;
            if (r103 == null) goto L18;
            this.generator.print("{" + this.blankOrNewLine);
            this.generator.indent();
            Iterator r111 = ((List) r110).iterator();
            boolean r104 = false;
        L7:
            if (r111.hasNext() == false) goto L13;
            Message r105 = (Message) r111.next();
            Object r106 = r105.getField(r102);
            Object r107 = r105.getField(r103);
            if (r104 == false) goto L11;
            this.generator.print("," + this.blankOrNewLine);
        L12:
            printSingleFieldValue(r102, r106, true);
            this.generator.print(":" + this.blankOrSpace);
            printSingleFieldValue(r103, r107);
            goto L7
        L11:
            r104 = true;
            goto L12
        L13:
            if (r104 == false) goto L15;
            this.generator.print(this.blankOrNewLine);
        L15:
            this.generator.outdent();
            this.generator.print(i.f25855d);
            return;
        L18:
            throw new InvalidProtocolBufferException("Invalid map field.");
        }

        private void printRepeatedFieldValue(Descriptors.FieldDescriptor r100, Object r101) throws IOException {
            this.generator.print("[");
            Iterator r102 = ((List) r101).iterator();
            boolean r103 = false;
        L4:
            if (r102.hasNext() == false) goto L10;
            Object r104 = r102.next();
            if (r103 == false) goto L8;
            this.generator.print("," + this.blankOrSpace);
        L9:
            printSingleFieldValue(r100, r104);
            goto L4
        L8:
            r103 = true;
            goto L9
        L10:
            this.generator.print("]");
        }

        private void printSingleFieldValue(Descriptors.FieldDescriptor r100, Object r101) throws IOException {
            printSingleFieldValue(r100, r101, false);
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        private void printSingleFieldValue(Descriptors.FieldDescriptor r100, Object r101, boolean r102) throws IOException {
            switch(AnonymousClass1.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[r100.getType().ordinal()]) {
                case 1: goto L67;
                case 2: goto L67;
                case 3: goto L67;
                case 4: goto L66;
                case 5: goto L66;
                case 6: goto L66;
                case 7: goto L58;
                case 8: goto L44;
                case 9: goto L30;
                case 10: goto L25;
                case 11: goto L25;
                case 12: goto L24;
                case 13: goto L24;
                case 14: goto L23;
                case 15: goto L17;
                case 16: goto L7;
                case 17: goto L5;
                case 18: goto L5;
                default: goto L99;
            };
        L5:
            print((Message) r101);
            return;
        L17:
            this.generator.print("\"");
            TextGenerator r103 = this.generator;
            BaseEncoding.c r104 = BaseEncoding.f275606a;
            byte[] r105 = ((ByteString) r101).toByteArray();
            r104.getClass();
            int r106 = r105.length;
            m.n(0, r106 + 0, r105.length);
            BaseEncoding.a r107 = r104.f275618c;
            StringBuilder r108 = new StringBuilder(r107.f275612e * com.google.common.math.c.c(r106, r107.f275613f, RoundingMode.CEILING));
            r104.e(r108, r105, r106);     // Catch: IOException -> L20
            r103.print(r108.toString());
            this.generator.print("\"");
            return;
        L20:
            e = move-exception;
            throw new AssertionError(e);
        L23:
            this.generator.print(GsonProtectorUtils.toJson(this.gson, r101));
            return;
        L24:
            this.generator.print("\"" + JsonFormat.access$1900(((Long) r101).longValue()) + "\"");
            return;
        L25:
            if (r102 == false) goto L27;
            this.generator.print("\"");
        L27:
            this.generator.print(JsonFormat.access$1800(((Integer) r101).intValue()));
            if (r102 == false) goto L83;
            this.generator.print("\"");
            return;
        L83:
            return;
        L30:
            Double r109 = (Double) r101;
            if (r109.isNaN() == false) goto L34;
            this.generator.print("\"NaN\"");
            return;
        L34:
            if (r109.isInfinite() == true) goto L36;
            if (r102 == false) goto L41;
            this.generator.print("\"");
        L41:
            this.generator.print(r109.toString());
            if (r102 == false) goto L88;
            this.generator.print("\"");
            return;
        L88:
            return;
        L36:
            if (r109.doubleValue() >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L38;
            this.generator.print("\"-Infinity\"");
            return;
        L38:
            this.generator.print("\"Infinity\"");
            return;
        L44:
            Float r110 = (Float) r101;
            if (r110.isNaN() == false) goto L48;
            this.generator.print("\"NaN\"");
            return;
        L48:
            if (r110.isInfinite() == true) goto L50;
            if (r102 == false) goto L55;
            this.generator.print("\"");
        L55:
            this.generator.print(r110.toString());
            if (r102 == false) goto L93;
            this.generator.print("\"");
            return;
        L93:
            return;
        L50:
            if (r110.floatValue() >= 0.0f) goto L52;
            this.generator.print("\"-Infinity\"");
            return;
        L52:
            this.generator.print("\"Infinity\"");
            return;
        L58:
            if (r102 == false) goto L61;
            this.generator.print("\"");
        L61:
            if (((Boolean) r101).booleanValue() == false) goto L63;
            this.generator.print("true");
        L64:
            if (r102 == false) goto L95;
            this.generator.print("\"");
            return;
        L95:
            return;
        L63:
            this.generator.print("false");
            goto L64
        L66:
            this.generator.print("\"" + ((Long) r101).toString() + "\"");
            return;
        L67:
            if (r102 == false) goto L69;
            this.generator.print("\"");
        L69:
            this.generator.print(((Integer) r101).toString());
            if (r102 == false) goto L98;
            this.generator.print("\"");
            return;
        L98:
            return;
        L99:
            return;
        L7:
            if (r100.getEnumType().getFullName().equals("google.protobuf.NullValue") == false) goto L13;
            if (r102 == false) goto L10;
            this.generator.print("\"");
        L10:
            this.generator.print("null");
            if (r102 == false) goto L76;
            this.generator.print("\"");
            return;
        L76:
            return;
        L13:
            Descriptors.EnumValueDescriptor r111 = (Descriptors.EnumValueDescriptor) r101;
            if (r111.getIndex() != (-1)) goto L16;
            this.generator.print(String.valueOf(r111.getNumber()));
            return;
        L16:
            this.generator.print("\"" + r111.getName() + "\"");
        }

        public PrinterImpl(TypeRegistry r100, boolean r101, Set<Descriptors.FieldDescriptor> r102, boolean r103, Appendable r104, boolean r105) {
            this.registry = r100;
            this.alwaysOutputDefaultValueFields = r101;
            this.includingDefaultValueFields = r102;
            this.preservingProtoFieldNames = r103;
            this.gson = GsonHolder.access$600();
            AnonymousClass1 r106 = null;
            if (r105 == false) goto L5;
            this.generator = new CompactTextGenerator(r104, r106);
            this.blankOrSpace = "";
            this.blankOrNewLine = "";
            return;
        L5:
            this.generator = new PrettyTextGenerator(r104, r106);
            this.blankOrSpace = " ";
            this.blankOrNewLine = "\n";
        }
    }

    public interface TextGenerator {
        void indent();

        void outdent();

        void print(CharSequence r100) throws IOException;
    }

    public static class TypeRegistry {
        private final Map<String, Descriptors.Descriptor> types;

        public static class Builder {
            private final Set<String> files;
            private Map<String, Descriptors.Descriptor> types;

            public TypeRegistry build() {
                TypeRegistry r100 = new TypeRegistry(this.types, null);
                this.types = null;
                return r100;
            }

            private Builder() {
                this.files = new HashSet();
                this.types = new HashMap();
            }

            public /* synthetic */ Builder(AnonymousClass1 r100) {
                this();
            }

            private void addFile(Descriptors.FileDescriptor r100) {
                if (this.files.add(r100.getFullName()) == true) goto L5;
                return;
            L5:
                Iterator<Descriptors.FileDescriptor> r101 = r100.getDependencies().iterator();
            L7:
                if (r101.hasNext() == false) goto L9;
                addFile(r101.next());
                goto L7
            L9:
                Iterator<Descriptors.Descriptor> r102 = r100.getMessageTypes().iterator();
            L11:
                if (r102.hasNext() == false) goto L13;
                addMessage(r102.next());
                goto L11
            }

            private void addMessage(Descriptors.Descriptor r100) {
                Iterator<Descriptors.Descriptor> r101 = r100.getNestedTypes().iterator();
            L4:
                if (r101.hasNext() == false) goto L7;
                addMessage(r101.next());
                goto L4
            L7:
                if (this.types.containsKey(r100.getFullName()) == false) goto L10;
                JsonFormat.access$500().warning("Type " + r100.getFullName() + " is added multiple times.");
                return;
            L10:
                this.types.put(r100.getFullName(), r100);
            }

            public Builder add(Iterable<Descriptors.Descriptor> r100) {
                if (this.types == null) goto L10;
                Iterator<Descriptors.Descriptor> r101 = r100.iterator();
            L6:
                if (r101.hasNext() == false) goto L8;
                addFile(r101.next().getFile());
                goto L6
            L8:
                return this;
            L10:
                throw new IllegalStateException("A TypeRegistry.Builer can only be used once.");
            }

            public Builder add(Descriptors.Descriptor r100) {
                if (this.types == null) goto L7;
                addFile(r100.getFile());
                return this;
            L7:
                throw new IllegalStateException("A TypeRegistry.Builer can only be used once.");
            }
        }

        public static class EmptyTypeRegistryHolder {
            private static final TypeRegistry EMPTY = null;

            private EmptyTypeRegistryHolder() {
            }

            static {
                EMPTY = new TypeRegistry(Collections.emptyMap(), null);
            }

            public static /* synthetic */ TypeRegistry access$300() {
                return EMPTY;
            }
        }

        public static Builder newBuilder() {
            return new Builder(null);
        }

        public static TypeRegistry getEmptyTypeRegistry() {
            return EmptyTypeRegistryHolder.access$300();
        }

        private TypeRegistry(Map<String, Descriptors.Descriptor> r100) {
            this.types = r100;
        }

        public Descriptors.Descriptor find(String r100) {
            return this.types.get(r100);
        }

        public /* synthetic */ TypeRegistry(Map r100, AnonymousClass1 r101) {
            this(r100);
        }
    }

    private JsonFormat() {
    }

    static {
        logger = Logger.getLogger(JsonFormat.class.getName());
    }

    public static Parser parser() {
        boolean r100 = false;
        return new Parser(TypeRegistry.getEmptyTypeRegistry(), r100, 100, null);
    }

    public static Printer printer() {
        return new Printer(TypeRegistry.getEmptyTypeRegistry(), false, Collections.emptySet(), false, false, null);
    }

    public static /* synthetic */ Logger access$500() {
        return logger;
    }

    public static /* synthetic */ String access$1700(String r100) throws InvalidProtocolBufferException {
        return getTypeName(r100);
    }

    public static /* synthetic */ String access$1800(int r100) {
        return unsignedToString(r100);
    }

    public static /* synthetic */ String access$1900(long r100) {
        return unsignedToString(r100);
    }

    private static String getTypeName(String r100) throws InvalidProtocolBufferException {
        String[] r101 = r100.split(HTTP.URL_DEFAULT);
        if (r101.length == 1) goto L7;
        return r101[r101.length - 1];
    L7:
        throw new InvalidProtocolBufferException("Invalid type url found: ".concat(r100));
    }

    private static String unsignedToString(long r100) {
        if (r100 < 0) goto L7;
        return Long.toString(r100);
    L7:
        return BigInteger.valueOf(r100 & Long.MAX_VALUE).setBit(63).toString();
    }

    private static String unsignedToString(int r100) {
        if (r100 < 0) goto L6;
        return Integer.toString(r100);
    L6:
        return Long.toString(((long) r100) & BodyPartID.bodyIdMax);
    }
}
