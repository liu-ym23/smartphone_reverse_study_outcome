package com.google.protobuf;

import androidx.collection.SieveCacheKt;
import com.alipay.sdk.m.u.i;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.bouncycastle.asn1.cmc.BodyPartID;
import r27.a;
import tb2.c;

/* JADX INFO: loaded from: classes23.dex */
public final class TextFormat {
    private static final Parser PARSER = null;
    private static final Logger logger = null;

    /* JADX INFO: renamed from: com.google.protobuf.TextFormat$1, reason: invalid class name */
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

    public static class InvalidEscapeSequenceException extends IOException {
        private static final long serialVersionUID = -8164033650142593304L;

        public InvalidEscapeSequenceException(String r100) {
            super(r100);
        }
    }

    public static class ParseException extends IOException {
        private static final long serialVersionUID = 3196188060225107702L;
        private final int column;
        private final int line;

        public int getColumn() {
            return this.column;
        }

        public int getLine() {
            return this.line;
        }

        public ParseException(String r100) {
            this(-1, -1, r100);
        }

        public ParseException(int r100, int r101, String r102) {
            super(Integer.toString(r100) + ":" + r101 + ": " + r102);
            this.line = r100;
            this.column = r101;
        }
    }

    public static class Parser {
        private static final int BUFFER_SIZE = 4096;
        private final boolean allowUnknownFields;
        private TextFormatParseInfoTree.Builder parseInfoTreeBuilder;
        private final SingularOverwritePolicy singularOverwritePolicy;

        public static class Builder {
            private boolean allowUnknownFields;
            private TextFormatParseInfoTree.Builder parseInfoTreeBuilder;
            private SingularOverwritePolicy singularOverwritePolicy;

            public Parser build() {
                return new Parser(this.allowUnknownFields, this.singularOverwritePolicy, this.parseInfoTreeBuilder, null);
            }

            public Builder() {
                this.allowUnknownFields = false;
                this.singularOverwritePolicy = SingularOverwritePolicy.ALLOW_SINGULAR_OVERWRITES;
                this.parseInfoTreeBuilder = null;
            }

            public Builder setParseInfoTreeBuilder(TextFormatParseInfoTree.Builder r100) {
                this.parseInfoTreeBuilder = r100;
                return this;
            }

            public Builder setSingularOverwritePolicy(SingularOverwritePolicy r100) {
                this.singularOverwritePolicy = r100;
                return this;
            }
        }

        public static final enum SingularOverwritePolicy extends java.lang.Enum<SingularOverwritePolicy> {
            private static final /* synthetic */ SingularOverwritePolicy[] $VALUES = null;
            public static final SingularOverwritePolicy ALLOW_SINGULAR_OVERWRITES = null;
            public static final SingularOverwritePolicy FORBID_SINGULAR_OVERWRITES = null;

            static {
                SingularOverwritePolicy r100 = new SingularOverwritePolicy("ALLOW_SINGULAR_OVERWRITES", 0);
                ALLOW_SINGULAR_OVERWRITES = r100;
                SingularOverwritePolicy r101 = new SingularOverwritePolicy("FORBID_SINGULAR_OVERWRITES", 1);
                FORBID_SINGULAR_OVERWRITES = r101;
                $VALUES = new SingularOverwritePolicy[]{r100, r101};
            }

            public static SingularOverwritePolicy[] values() {
                return (SingularOverwritePolicy[]) $VALUES.clone();
            }

            public static SingularOverwritePolicy valueOf(String r100) {
                return (SingularOverwritePolicy) a.a(SingularOverwritePolicy.class, r100);
            }

            private SingularOverwritePolicy(String r100, int r101) {
                super(r100, r101);
            }
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        private void checkUnknownFields(List<String> r100) throws ParseException {
            if (r100.isEmpty() == false) goto L5;
            return;
        L5:
            StringBuilder r101 = new StringBuilder("Input contains unknown fields and/or extensions:");
            Iterator<String> r102 = r100.iterator();
        L7:
            if (r102.hasNext() == false) goto L10;
            String r103 = r102.next();
            r101.append('\n');
            r101.append(r103);
            goto L7
        L10:
            if (this.allowUnknownFields == false) goto L13;
            TextFormat.access$700().warning(r101.toString());
            return;
        L13:
            String[] r104 = ((String) ListProtector.get(r100, 0)).split(":");
            throw new ParseException(CastIntegerProtector.valueOf(r104[0]).intValue(), CastIntegerProtector.valueOf(r104[1]).intValue(), r101.toString());
        }

        private void skipField(Tokenizer r100) throws ParseException {
            if (r100.tryConsume("[") == false) goto L7;
        L4:
            r100.consumeIdentifier();
            if (r100.tryConsume(".") == true) goto L4;
            r100.consume("]");
        L9:
            if (r100.tryConsume(":") == true) goto L11;
        L15:
            skipFieldMessage(r100);
        L17:
            if (r100.tryConsume(i.f25853b) == true) goto L22;
            r100.tryConsume(",");
            return;
        L22:
            return;
        L11:
            if (r100.lookingAt("<") == true) goto L15;
            if (r100.lookingAt("{") == true) goto L15;
            skipFieldValue(r100);
            goto L17
        L7:
            r100.consumeIdentifier();
            goto L9
        }

        private void skipFieldMessage(Tokenizer r100) throws ParseException {
            if (r100.tryConsume("<") == false) goto L5;
            String r101 = ">";
        L7:
            if (r100.lookingAt(">") == true) goto L11;
            if (r100.lookingAt(i.f25855d) == true) goto L11;
            skipField(r100);
        L11:
            r100.consume(r101);
            return;
        L5:
            r100.consume("{");
            r101 = i.f25855d;
            goto L7
        }

        private void skipFieldValue(Tokenizer r100) throws ParseException {
            if (r100.tryConsumeString() == false) goto L9;
        L5:
            if (r100.tryConsumeString() == true) goto L5;
            return;
        L9:
            if (r100.tryConsumeIdentifier() == false) goto L11;
            return;
        L11:
            if (r100.tryConsumeInt64() == false) goto L13;
            return;
        L13:
            if (r100.tryConsumeUInt64() == false) goto L15;
            return;
        L15:
            if (r100.tryConsumeDouble() == false) goto L17;
            return;
        L17:
            if (r100.tryConsumeFloat() == false) goto L20;
            return;
        L20:
            throw r100.parseException("Invalid field value: " + Tokenizer.access$900(r100));
        }

        private static StringBuilder toStringBuilder(Readable r100) throws IOException {
            StringBuilder r101 = new StringBuilder();
            CharBuffer r102 = CharBuffer.allocate(4096);
        L3:
            int r103 = r100.read(r102);
            if (r103 == (-1)) goto L5;
            r102.flip();
            r101.append(r102, 0, r103);
            goto L3
        L5:
            return r101;
        }

        public void merge(CharSequence r100, Message.Builder r101) throws ParseException {
            merge(r100, ExtensionRegistry.getEmptyRegistry(), r101);
        }

        public void merge(Readable r100, Message.Builder r101) throws IOException {
            merge(r100, ExtensionRegistry.getEmptyRegistry(), r101);
        }

        private Parser(boolean r100, SingularOverwritePolicy r101, TextFormatParseInfoTree.Builder r102) {
            this.allowUnknownFields = r100;
            this.singularOverwritePolicy = r101;
            this.parseInfoTreeBuilder = r102;
        }

        public void merge(CharSequence r100, ExtensionRegistry r101, Message.Builder r102) throws ParseException {
            Tokenizer r103 = new Tokenizer(r100, null);
            MessageReflection.BuilderAdapter r104 = new MessageReflection.BuilderAdapter(r102);
            ArrayList r105 = new ArrayList();
        L4:
            if (r103.atEnd() == true) goto L6;
            mergeField(r103, r101, r104, r105);
            goto L4
        L6:
            checkUnknownFields(r105);
        }

        public void merge(Readable r100, ExtensionRegistry r101, Message.Builder r102) throws IOException {
            merge(toStringBuilder(r100), r101, r102);
        }

        public /* synthetic */ Parser(boolean r100, SingularOverwritePolicy r101, TextFormatParseInfoTree.Builder r102, AnonymousClass1 r103) {
            this(r100, r101, r102);
        }

        private void mergeField(Tokenizer r100, ExtensionRegistry r101, MessageReflection.MergeTarget r102, List<String> r110) throws ParseException {
            mergeField(r100, r101, r102, this.parseInfoTreeBuilder, r110);
        }

        private void mergeField(Tokenizer r110, ExtensionRegistry r111, MessageReflection.MergeTarget r112, TextFormatParseInfoTree.Builder r210, List<String> r211) throws ParseException {
            int r113 = r110.getLine();
            int r114 = r110.getColumn();
            Descriptors.Descriptor r100 = r112.getDescriptorForType();
            ExtensionRegistry.ExtensionInfo r101 = null;
            Descriptors.FieldDescriptor r102 = null;
            r101 = null;
            if (r110.tryConsume("[") == false) goto L17;
            StringBuilder r103 = new StringBuilder(r110.consumeIdentifier());
        L6:
            if (r110.tryConsume(".") == false) goto L8;
            r103.append('.');
            r103.append(r110.consumeIdentifier());
            goto L6
        L8:
            ExtensionRegistry.ExtensionInfo r104 = r112.findExtensionByName(r111, r103.toString());
            if (r104 != null) goto L12;
            r211.add((r110.getPreviousLine() + 1) + ":" + (r110.getPreviousColumn() + 1) + ":\t" + r100.getFullName() + ".[" + r103 + "]");
        L14:
            r110.consume("]");
            Descriptors.FieldDescriptor r115 = r102;
            r101 = r104;
        L32:
            if (r115 != null) goto L43;
            if (r110.tryConsume(":") == true) goto L36;
        L40:
            skipFieldMessage(r110);
            return;
        L36:
            if (r110.lookingAt("{") == true) goto L40;
            if (r110.lookingAt("<") == true) goto L40;
            skipFieldValue(r110);
            return;
        L43:
            if (r115.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L48;
            r110.tryConsume(":");
            if (r210 == null) goto L47;
            consumeFieldValues(r110, r111, r112, r115, r101, r210.getBuilderForSubMessageField(r115), r211);
        L49:
            if (r210 == null) goto L52;
            r210.setLocation(r115, TextFormatParseLocation.create(r113, r114));
        L52:
            if (r110.tryConsume(i.f25853b) == true) goto L57;
            r110.tryConsume(",");
            return;
        L57:
            return;
        L47:
            consumeFieldValues(r110, r111, r112, r115, r101, r210, r211);
            goto L49
        L48:
            r110.consume(":");
            consumeFieldValues(r110, r111, r112, r115, r101, r210, r211);
            goto L49
        L12:
            if (r104.descriptor.getContainingType() != r100) goto L16;
            r102 = r104.descriptor;
            goto L14
        L16:
            throw r110.parseExceptionPreviousToken("Extension \"" + r103 + "\" does not extend message type \"" + r100.getFullName() + "\".");
        L17:
            String r105 = r110.consumeIdentifier();
            r115 = r100.findFieldByName(r105);
            if (r115 != null) goto L24;
            r115 = r100.findFieldByName(r105.toLowerCase(Locale.US));
            if (r115 == null) goto L24;
            if (r115.getType() == Descriptors.FieldDescriptor.Type.GROUP) goto L24;
            r115 = null;
        L24:
            if (r115 != null) goto L26;
        L30:
            if (r115 != null) goto L32;
            r211.add((r110.getPreviousLine() + 1) + ":" + (r110.getPreviousColumn() + 1) + ":\t" + r100.getFullName() + "." + r105);
            goto L32
        L26:
            if (r115.getType() != Descriptors.FieldDescriptor.Type.GROUP) goto L30;
            if (r115.getMessageType().getName().equals(r105) == true) goto L30;
            r115 = null;
            goto L30
        }

        private void consumeFieldValue(Tokenizer r110, ExtensionRegistry r111, MessageReflection.MergeTarget r112, Descriptors.FieldDescriptor r113, ExtensionRegistry.ExtensionInfo r114, TextFormatParseInfoTree.Builder r115, List<String> r210) throws ParseException {
            Object r100 = null;
            Message r101 = null;
            if (r113.getJavaType() != Descriptors.FieldDescriptor.JavaType.MESSAGE) goto L22;
            if (r110.tryConsume("<") == false) goto L7;
            String r102 = ">";
        L8:
            String r116 = r102;
            if (r114 == null) goto L12;
            r101 = r114.defaultInstance;
        L12:
            MessageReflection.MergeTarget r117 = r112.newMergeTargetForField(r113, r101);
        L14:
            if (r110.tryConsume(r116) == true) goto L20;
            if (r110.atEnd() == true) goto L19;
            mergeField(r110, r111, r117, r115, r210);
            goto L14
        L19:
            throw r110.parseException("Expected \"" + r116 + "\".");
        L20:
            r100 = r117.finish();
        L48:
            if (r113.isRepeated() == false) goto L50;
            r112.addRepeatedField(r113, r100);
            return;
        L50:
            SingularOverwritePolicy r103 = this.singularOverwritePolicy;
            SingularOverwritePolicy r104 = SingularOverwritePolicy.FORBID_SINGULAR_OVERWRITES;
            if (r103 != r104) goto L58;
            if (r112.hasField(r113) == false) goto L58;
            throw r110.parseExceptionPreviousToken("Non-repeated field \"" + r113.getFullName() + "\" cannot be overwritten.");
        L58:
            if (this.singularOverwritePolicy == r104) goto L60;
        L66:
            r112.setField(r113, r100);
            return;
        L60:
            if (r113.getContainingOneof() == null) goto L66;
            if (r112.hasOneof(r113.getContainingOneof()) == false) goto L66;
            Descriptors.OneofDescriptor r105 = r113.getContainingOneof();
            throw r110.parseExceptionPreviousToken("Field \"" + r113.getFullName() + "\" is specified along with field \"" + r112.getOneofFieldDescriptor(r105).getFullName() + "\", another member of oneof \"" + r105.getName() + "\".");
        L7:
            r110.consume("{");
            r102 = i.f25855d;
            goto L8
        L22:
            switch(AnonymousClass1.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[r113.getType().ordinal()]) {
                case 1: goto L46;
                case 2: goto L46;
                case 3: goto L46;
                case 4: goto L45;
                case 5: goto L45;
                case 6: goto L45;
                case 7: goto L44;
                case 8: goto L43;
                case 9: goto L42;
                case 10: goto L41;
                case 11: goto L41;
                case 12: goto L40;
                case 13: goto L40;
                case 14: goto L39;
                case 15: goto L38;
                case 16: goto L26;
                case 17: goto L25;
                case 18: goto L25;
                default: goto L48;
            };
        L26:
            Descriptors.EnumDescriptor r106 = r113.getEnumType();
            if (r110.lookingAtInteger() == false) goto L33;
            int r107 = r110.consumeInt32();
            r100 = r106.findValueByNumber(r107);
            if (r100 != null) goto L48;
            throw r110.parseExceptionPreviousToken("Enum type \"" + r106.getFullName() + "\" has no value with number " + r107 + '.');
        L33:
            String r108 = r110.consumeIdentifier();
            r100 = r106.findValueByName(r108);
            if (r100 != null) goto L48;
            throw r110.parseExceptionPreviousToken("Enum type \"" + r106.getFullName() + "\" has no value named \"" + r108 + "\".");
        L38:
            r100 = r110.consumeByteString();
            goto L48
        L39:
            r100 = r110.consumeString();
            goto L48
        L40:
            r100 = Long.valueOf(r110.consumeUInt64());
            goto L48
        L41:
            r100 = Integer.valueOf(r110.consumeUInt32());
            goto L48
        L42:
            r100 = Double.valueOf(r110.consumeDouble());
            goto L48
        L43:
            r100 = Float.valueOf(r110.consumeFloat());
            goto L48
        L44:
            r100 = Boolean.valueOf(r110.consumeBoolean());
            goto L48
        L45:
            r100 = Long.valueOf(r110.consumeInt64());
            goto L48
        L46:
            r100 = Integer.valueOf(r110.consumeInt32());
            goto L48
        L25:
            throw new RuntimeException("Can't get here.");
        }

        private void consumeFieldValues(Tokenizer r100, ExtensionRegistry r101, MessageReflection.MergeTarget r102, Descriptors.FieldDescriptor r103, ExtensionRegistry.ExtensionInfo r104, TextFormatParseInfoTree.Builder r105, List<String> r106) throws ParseException {
            if (r103.isRepeated() == true) goto L5;
        L12:
            consumeFieldValue(r100, r101, r102, r103, r104, r105, r106);
            return;
        L5:
            if (r100.tryConsume("[") == false) goto L12;
            if (r100.tryConsume("]") == true) goto L15;
        L8:
            consumeFieldValue(r100, r101, r102, r103, r104, r105, r106);
            if (r100.tryConsume("]") == true) goto L16;
            r100.consume(",");
            goto L8
        L16:
            return;
        }
    }

    public static final class Printer {
        static final Printer DEFAULT = null;
        static final Printer UNICODE = null;
        private final boolean escapeNonAscii;

        static {
            DEFAULT = new Printer(true);
            UNICODE = new Printer(false);
        }

        private Printer(boolean r100) {
            this.escapeNonAscii = r100;
        }

        private void print(MessageOrBuilder r100, TextGenerator r101) throws IOException {
            Iterator<Map.Entry<Descriptors.FieldDescriptor, Object>> r102 = r100.getAllFields().entrySet().iterator();
        L4:
            if (r102.hasNext() == false) goto L6;
            Map.Entry<Descriptors.FieldDescriptor, Object> r103 = r102.next();
            printField(r103.getKey(), r103.getValue(), r101);
            goto L4
        L6:
            printUnknownFields(r100.getUnknownFields(), r101);
        }

        private void printUnknownFields(UnknownFieldSet r100, TextGenerator r101) throws IOException {
            Iterator<Map.Entry<Integer, UnknownFieldSet.Field>> r102 = r100.asMap().entrySet().iterator();
        L4:
            if (r102.hasNext() == false) goto L9;
            Map.Entry<Integer, UnknownFieldSet.Field> r103 = r102.next();
            int r104 = r103.getKey().intValue();
            UnknownFieldSet.Field r105 = r103.getValue();
            printUnknownField(r104, 0, r105.getVarintList(), r101);
            printUnknownField(r104, 5, r105.getFixed32List(), r101);
            printUnknownField(r104, 1, r105.getFixed64List(), r101);
            printUnknownField(r104, 2, r105.getLengthDelimitedList(), r101);
            Iterator<UnknownFieldSet> r106 = r105.getGroupList().iterator();
        L7:
            if (r106.hasNext() == false) goto L4;
            UnknownFieldSet r107 = r106.next();
            r101.print(r103.getKey().toString());
            r101.print(" {");
            r101.eol();
            r101.indent();
            printUnknownFields(r107, r101);
            r101.outdent();
            r101.print(i.f25855d);
            r101.eol();
            goto L7
        }

        public static /* synthetic */ void access$000(Printer r100, MessageOrBuilder r101, TextGenerator r102) throws IOException {
            r100.print(r101, r102);
        }

        public static /* synthetic */ void access$100(Printer r100, UnknownFieldSet r101, TextGenerator r102) throws IOException {
            r100.printUnknownFields(r101, r102);
        }

        private void printField(Descriptors.FieldDescriptor r100, Object r101, TextGenerator r102) throws IOException {
            if (r100.isRepeated() == false) goto L8;
            Iterator r103 = ((List) r101).iterator();
        L6:
            if (r103.hasNext() == false) goto L11;
            printSingleField(r100, r103.next(), r102);
            goto L6
        L11:
            return;
        L8:
            printSingleField(r100, r101, r102);
        }

        private void printFieldValue(Descriptors.FieldDescriptor r100, Object r101, TextGenerator r102) throws IOException {
            switch(AnonymousClass1.$SwitchMap$com$google$protobuf$Descriptors$FieldDescriptor$Type[r100.getType().ordinal()]) {
                case 1: goto L23;
                case 2: goto L23;
                case 3: goto L23;
                case 4: goto L22;
                case 5: goto L22;
                case 6: goto L22;
                case 7: goto L21;
                case 8: goto L20;
                case 9: goto L19;
                case 10: goto L18;
                case 11: goto L18;
                case 12: goto L17;
                case 13: goto L17;
                case 14: goto L12;
                case 15: goto L7;
                case 16: goto L6;
                case 17: goto L5;
                case 18: goto L5;
                default: goto L35;
            };
        L5:
            print((Message) r101, r102);
            return;
        L6:
            r102.print(((Descriptors.EnumValueDescriptor) r101).getName());
            return;
        L7:
            r102.print("\"");
            if ((r101 instanceof ByteString) == false) goto L10;
            r102.print(TextFormat.escapeBytes((ByteString) r101));
        L11:
            r102.print("\"");
            return;
        L10:
            r102.print(TextFormat.escapeBytes((byte[]) r101));
            goto L11
        L12:
            r102.print("\"");
            if (this.escapeNonAscii == false) goto L15;
            String r103 = TextFormatEscaper.escapeText((String) r101);
        L16:
            r102.print(r103);
            r102.print("\"");
            return;
        L15:
            r103 = TextFormat.escapeDoubleQuotesAndBackslashes((String) r101).replace("\n", "\\n");
            goto L16
        L17:
            r102.print(TextFormat.unsignedToString(((Long) r101).longValue()));
            return;
        L18:
            r102.print(TextFormat.unsignedToString(((Integer) r101).intValue()));
            return;
        L19:
            r102.print(((Double) r101).toString());
            return;
        L20:
            r102.print(((Float) r101).toString());
            return;
        L21:
            r102.print(((Boolean) r101).toString());
            return;
        L22:
            r102.print(((Long) r101).toString());
            return;
        L23:
            r102.print(((Integer) r101).toString());
            return;
        }

        private void printSingleField(Descriptors.FieldDescriptor r100, Object r101, TextGenerator r102) throws IOException {
            if (r100.isExtension() == false) goto L16;
            r102.print("[");
            if (r100.getContainingType().getOptions().getMessageSetWireFormat() == true) goto L7;
        L13:
            r102.print(r100.getFullName());
        L14:
            r102.print("]");
        L19:
            Descriptors.FieldDescriptor.JavaType r103 = r100.getJavaType();
            Descriptors.FieldDescriptor.JavaType r104 = Descriptors.FieldDescriptor.JavaType.MESSAGE;
            if (r103 != r104) goto L22;
            r102.print(" {");
            r102.eol();
            r102.indent();
        L23:
            printFieldValue(r100, r101, r102);
            if (r100.getJavaType() != r104) goto L26;
            r102.outdent();
            r102.print(i.f25855d);
        L26:
            r102.eol();
            return;
        L22:
            r102.print(": ");
            goto L23
        L7:
            if (r100.getType() != Descriptors.FieldDescriptor.Type.MESSAGE) goto L13;
            if (r100.isOptional() == false) goto L13;
            if (r100.getExtensionScope() != r100.getMessageType()) goto L13;
            r102.print(r100.getMessageType().getFullName());
            goto L14
        L16:
            if (r100.getType() != Descriptors.FieldDescriptor.Type.GROUP) goto L18;
            r102.print(r100.getMessageType().getName());
            goto L19
        L18:
            r102.print(r100.getName());
            goto L19
        }

        public static /* synthetic */ void access$200(Printer r100, Descriptors.FieldDescriptor r101, Object r102, TextGenerator r103) throws IOException {
            r100.printField(r101, r102, r103);
        }

        public static /* synthetic */ void access$300(Printer r100, Descriptors.FieldDescriptor r101, Object r102, TextGenerator r103) throws IOException {
            r100.printFieldValue(r101, r102, r103);
        }

        private void printUnknownField(int r100, int r101, List<?> r102, TextGenerator r103) throws IOException {
            Iterator<?> r104 = r102.iterator();
        L4:
            if (r104.hasNext() == false) goto L6;
            Object r105 = r104.next();
            r103.print(String.valueOf(r100));
            r103.print(": ");
            TextFormat.access$400(r101, r105, r103);
            r103.eol();
            goto L4
        }
    }

    public static final class TextGenerator {
        private boolean atStartOfLine;
        private final StringBuilder indent;
        private final Appendable output;
        private final boolean singleLineMode;

        public void eol() throws IOException {
            if (this.singleLineMode == true) goto L5;
            this.output.append("\n");
        L5:
            this.atStartOfLine = true;
        }

        public void indent() {
            this.indent.append(c.DEFAULT_TEXT);
        }

        public void outdent() {
            int r100 = this.indent.length();
            if (r100 == 0) goto L7;
            this.indent.setLength(r100 - 2);
            return;
        L7:
            throw new IllegalArgumentException(" Outdent() without matching Indent().");
        }

        public void print(CharSequence r100) throws IOException {
            if (this.atStartOfLine == false) goto L9;
            this.atStartOfLine = false;
            Appendable r101 = this.output;
            if (this.singleLineMode == false) goto L7;
            CharSequence r102 = " ";
        L8:
            r101.append(r102);
            goto L9
        L7:
            r102 = this.indent;
        L9:
            this.output.append(r100);
        }

        private TextGenerator(Appendable r100, boolean r101) {
            this.indent = new StringBuilder();
            this.atStartOfLine = false;
            this.output = r100;
            this.singleLineMode = r101;
        }

        public /* synthetic */ TextGenerator(Appendable r100, boolean r101, AnonymousClass1 r102) {
            this(r100, r101);
        }
    }

    public static final class Tokenizer {
        private static final Pattern DOUBLE_INFINITY = null;
        private static final Pattern FLOAT_INFINITY = null;
        private static final Pattern FLOAT_NAN = null;
        private static final Pattern TOKEN = null;
        private static final Pattern WHITESPACE = null;
        private int column;
        private String currentToken;
        private int line;
        private final Matcher matcher;
        private int pos;
        private int previousColumn;
        private int previousLine;
        private final CharSequence text;

        public String consumeIdentifier() throws ParseException {
            int r100 = 0;
        L4:
            if (r100 >= this.currentToken.length()) goto L25;
            char r101 = this.currentToken.charAt(r100);
            if ('a' > r101) goto L10;
            if (r101 > 'z') goto L10;
        L24:
            r100 = r100 + 1;
        L10:
            if ('A' > r101) goto L14;
            if (r101 <= 'Z') goto L24;
        L14:
            if ('0' > r101) goto L18;
            if (r101 <= '9') goto L24;
        L18:
            if (r101 == '_') goto L24;
            if (r101 == '.') goto L24;
            throw parseException("Expected identifier. Found '" + this.currentToken + "'");
        L25:
            String r102 = this.currentToken;
            nextToken();
            return r102;
        }

        static {
            WHITESPACE = PatternProtector.compile("(\\s|(#.*$))++", 8);
            TOKEN = PatternProtector.compile("[a-zA-Z_][0-9a-zA-Z_+-]*+|[.]?[0-9+-][0-9a-zA-Z_.+-]*+|\"([^\"\n\\\\]|\\\\.)*+(\"|\\\\?$)|'([^'\n\\\\]|\\\\.)*+('|\\\\?$)", 8);
            DOUBLE_INFINITY = PatternProtector.compile("-?inf(inity)?", 2);
            FLOAT_INFINITY = PatternProtector.compile("-?inf(inity)?f?", 2);
            FLOAT_NAN = PatternProtector.compile("nanf?", 2);
        }

        private void skipWhitespace() {
            this.matcher.usePattern(WHITESPACE);
            if (this.matcher.lookingAt() == false) goto L6;
            Matcher r100 = this.matcher;
            r100.region(r100.end(), this.matcher.regionEnd());
            return;
        }

        public boolean atEnd() {
            if (this.currentToken.length() != 0) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean consumeBoolean() throws ParseException {
            if (this.currentToken.equals("true") == false) goto L5;
        L24:
            nextToken();
            return true;
        L5:
            if (this.currentToken.equals(BdpAppEventConstant.TRUE) == true) goto L24;
            if (this.currentToken.equals("t") == true) goto L24;
            if (this.currentToken.equals("1") == true) goto L24;
            if (this.currentToken.equals("false") == false) goto L14;
        L22:
            nextToken();
            return false;
        L14:
            if (this.currentToken.equals(BdpAppEventConstant.FALSE) == true) goto L22;
            if (this.currentToken.equals("f") == true) goto L22;
            if (this.currentToken.equals("0") == true) goto L22;
            throw parseException("Expected \"true\" or \"false\".");
        }

        public ByteString consumeByteString() throws ParseException {
            ArrayList r100 = new ArrayList();
            consumeByteString(r100);
        L4:
            if (this.currentToken.startsWith("'") == true) goto L10;
            if (this.currentToken.startsWith("\"") == true) goto L10;
            return ByteString.copyFrom(r100);
        L10:
            consumeByteString(r100);
            goto L4
        }

        public double consumeDouble() throws ParseException {
            if (DOUBLE_INFINITY.matcher(this.currentToken).matches() == false) goto L10;
            boolean r100 = this.currentToken.startsWith("-");
            nextToken();
            if (r100 == false) goto L7;
            return Double.NEGATIVE_INFINITY;
        L7:
            return Double.POSITIVE_INFINITY;
        L10:
            if (this.currentToken.equalsIgnoreCase("nan") == false) goto L18;
            nextToken();
            return Double.NaN;
        L18:
            double r101 = CastDoubleProtector.parseDouble(this.currentToken);     // Catch: NumberFormatException -> L15
            nextToken();     // Catch: NumberFormatException -> L15
            return r101;
        L15:
            e = move-exception;
            throw floatParseException(e);
        }

        public float consumeFloat() throws ParseException {
            if (FLOAT_INFINITY.matcher(this.currentToken).matches() == false) goto L10;
            boolean r100 = this.currentToken.startsWith("-");
            nextToken();
            if (r100 == false) goto L7;
            return Float.NEGATIVE_INFINITY;
        L7:
            return Float.POSITIVE_INFINITY;
        L10:
            if (FLOAT_NAN.matcher(this.currentToken).matches() == false) goto L18;
            nextToken();
            return Float.NaN;
        L18:
            float r101 = CastFloatProtector.parseFloat(this.currentToken);     // Catch: NumberFormatException -> L15
            nextToken();     // Catch: NumberFormatException -> L15
            return r101;
        L15:
            e = move-exception;
            throw floatParseException(e);
        }

        public int consumeInt32() throws ParseException {
            int r100 = TextFormat.parseInt32(this.currentToken);     // Catch: NumberFormatException -> L4
            nextToken();     // Catch: NumberFormatException -> L4
            return r100;
        L4:
            e = move-exception;
            throw integerParseException(e);
        }

        public long consumeInt64() throws ParseException {
            long r100 = TextFormat.parseInt64(this.currentToken);     // Catch: NumberFormatException -> L4
            nextToken();     // Catch: NumberFormatException -> L4
            return r100;
        L4:
            e = move-exception;
            throw integerParseException(e);
        }

        public int consumeUInt32() throws ParseException {
            int r100 = TextFormat.parseUInt32(this.currentToken);     // Catch: NumberFormatException -> L4
            nextToken();     // Catch: NumberFormatException -> L4
            return r100;
        L4:
            e = move-exception;
            throw integerParseException(e);
        }

        public long consumeUInt64() throws ParseException {
            long r100 = TextFormat.parseUInt64(this.currentToken);     // Catch: NumberFormatException -> L4
            nextToken();     // Catch: NumberFormatException -> L4
            return r100;
        L4:
            e = move-exception;
            throw integerParseException(e);
        }

        public boolean lookingAtInteger() {
            if (this.currentToken.length() != 0) goto L5;
            return false;
        L5:
            char r100 = this.currentToken.charAt(0);
            if ('0' > r100) goto L10;
            if (r100 > '9') goto L10;
        L13:
            return true;
        L10:
            if (r100 == '-') goto L13;
            if (r100 == '+') goto L13;
            return false;
        }

        public void nextToken() {
            this.previousLine = this.line;
            this.previousColumn = this.column;
        L4:
            if (this.pos >= this.matcher.regionStart()) goto L11;
            if (this.text.charAt(this.pos) != '\n') goto L8;
            this.line++;
            this.column = 0;
        L9:
            this.pos++;
            goto L4
        L8:
            this.column++;
            goto L9
        L11:
            if (this.matcher.regionStart() != this.matcher.regionEnd()) goto L13;
            this.currentToken = "";
            return;
        L13:
            this.matcher.usePattern(TOKEN);
            if (this.matcher.lookingAt() == false) goto L16;
            this.currentToken = this.matcher.group();
            Matcher r100 = this.matcher;
            r100.region(r100.end(), this.matcher.regionEnd());
        L17:
            skipWhitespace();
            return;
        L16:
            this.currentToken = String.valueOf(this.text.charAt(this.pos));
            Matcher r101 = this.matcher;
            r101.region(this.pos + 1, r101.regionEnd());
            goto L17
        }

        public String consumeString() throws ParseException {
            return consumeByteString().toStringUtf8();
        }

        public boolean tryConsumeDouble() {
            consumeDouble();     // Catch: ParseException -> L5
            return true;
        L5:
            return false;
        }

        public boolean tryConsumeFloat() {
            consumeFloat();     // Catch: ParseException -> L5
            return true;
        L5:
            return false;
        }

        public boolean tryConsumeIdentifier() {
            consumeIdentifier();     // Catch: ParseException -> L5
            return true;
        L5:
            return false;
        }

        public boolean tryConsumeInt64() {
            consumeInt64();     // Catch: ParseException -> L5
            return true;
        L5:
            return false;
        }

        public boolean tryConsumeString() {
            consumeString();     // Catch: ParseException -> L5
            return true;
        L5:
            return false;
        }

        public boolean tryConsumeUInt64() {
            consumeUInt64();     // Catch: ParseException -> L5
            return true;
        L5:
            return false;
        }

        public int getColumn() {
            return this.column;
        }

        public int getLine() {
            return this.line;
        }

        public int getPreviousColumn() {
            return this.previousColumn;
        }

        public int getPreviousLine() {
            return this.previousLine;
        }

        private Tokenizer(CharSequence r100) {
            this.pos = 0;
            this.line = 0;
            this.column = 0;
            this.previousLine = 0;
            this.previousColumn = 0;
            this.text = r100;
            this.matcher = WHITESPACE.matcher(r100);
            skipWhitespace();
            nextToken();
        }

        public static /* synthetic */ String access$900(Tokenizer r100) {
            return r100.currentToken;
        }

        private void consumeByteString(List<ByteString> r100) throws ParseException {
            char r101 = 0;
            if (this.currentToken.length() <= 0) goto L6;
            r101 = this.currentToken.charAt(0);
        L6:
            if (r101 == '\"') goto L13;
            if (r101 == '\'') goto L13;
            throw parseException("Expected string.");
        L13:
            if (this.currentToken.length() < 2) goto L22;
            String r102 = this.currentToken;
            if (r102.charAt(r102.length() - 1) != r101) goto L22;
            String r103 = this.currentToken;     // Catch: InvalidEscapeSequenceException -> L18
            ByteString r104 = TextFormat.unescapeBytes(r103.substring(1, r103.length() - 1));     // Catch: InvalidEscapeSequenceException -> L18
            nextToken();     // Catch: InvalidEscapeSequenceException -> L18
            r100.add(r104);     // Catch: InvalidEscapeSequenceException -> L18
            return;
        L18:
            e = move-exception;
            throw parseException(e.getMessage());
        L22:
            throw parseException("String missing ending quote.");
        }

        private ParseException floatParseException(NumberFormatException r100) {
            return parseException("Couldn't parse number: " + r100.getMessage());
        }

        private ParseException integerParseException(NumberFormatException r100) {
            return parseException("Couldn't parse integer: " + r100.getMessage());
        }

        public void consume(String r100) throws ParseException {
            if (tryConsume(r100) == false) goto L6;
            return;
        L6:
            throw parseException("Expected \"" + r100 + "\".");
        }

        public boolean lookingAt(String r100) {
            return this.currentToken.equals(r100);
        }

        public ParseException parseException(String r100) {
            return new ParseException(this.line + 1, this.column + 1, r100);
        }

        public ParseException parseExceptionPreviousToken(String r100) {
            return new ParseException(this.previousLine + 1, this.previousColumn + 1, r100);
        }

        public boolean tryConsume(String r100) {
            if (this.currentToken.equals(r100) == false) goto L6;
            nextToken();
            return true;
        L6:
            return false;
        }

        public /* synthetic */ Tokenizer(CharSequence r100, AnonymousClass1 r101) {
            this(r100);
        }

        public UnknownFieldParseException unknownFieldParseExceptionPreviousToken(String r100, String r101) {
            return new UnknownFieldParseException(this.previousLine + 1, this.previousColumn + 1, r100, r101);
        }
    }

    public static class UnknownFieldParseException extends ParseException {
        private final String unknownField;

        public String getUnknownField() {
            return this.unknownField;
        }

        public UnknownFieldParseException(String r100) {
            this(-1, -1, "", r100);
        }

        public UnknownFieldParseException(int r100, int r101, String r102, String r103) {
            super(r100, r101, r103);
            this.unknownField = r102;
        }
    }

    private TextFormat() {
    }

    private static int digitValue(byte r100) {
        if (48 > r100) goto L9;
        if (r100 > 57) goto L9;
        return r100 - 48;
    L9:
        if (97 <= r100) goto L11;
    L15:
        int r101 = r100 - 65;
    L14:
        return r101 + 10;
    L11:
        if (r100 > 122) goto L15;
        r101 = r100 - 97;
        goto L14
    }

    private static boolean isHex(byte r100) {
        if (48 > r100) goto L7;
        if (r100 > 57) goto L7;
    L14:
        return true;
    L7:
        if (97 > r100) goto L11;
        if (r100 <= 102) goto L14;
    L11:
        if (65 <= r100) goto L13;
    L15:
        return false;
    L13:
        if (r100 > 70) goto L15;
        goto L14
    }

    private static boolean isOctal(byte r100) {
        if (48 <= r100) goto L5;
    L7:
        return false;
    L5:
        if (r100 > 55) goto L7;
        return true;
    }

    static {
        logger = Logger.getLogger(TextFormat.class.getName());
        PARSER = Parser.newBuilder().build();
    }

    public static /* synthetic */ Logger access$700() {
        return logger;
    }

    public static Parser getParser() {
        return PARSER;
    }

    public static String escapeBytes(ByteString r100) {
        return TextFormatEscaper.escapeBytes(r100);
    }

    public static String escapeDoubleQuotesAndBackslashes(String r100) {
        return TextFormatEscaper.escapeDoubleQuotesAndBackslashes(r100);
    }

    public static String escapeText(String r100) {
        return escapeBytes(ByteString.copyFromUtf8(r100));
    }

    private static TextGenerator multiLineOutput(Appendable r100) {
        return new TextGenerator(r100, false, null);
    }

    public static int parseInt32(String r100) throws NumberFormatException {
        return (int) parseInteger(r100, true, false);
    }

    public static long parseInt64(String r100) throws NumberFormatException {
        return parseInteger(r100, true, true);
    }

    public static int parseUInt32(String r100) throws NumberFormatException {
        return (int) parseInteger(r100, false, false);
    }

    public static long parseUInt64(String r100) throws NumberFormatException {
        return parseInteger(r100, false, true);
    }

    public static String printToString(MessageOrBuilder r100) {
        StringBuilder r101 = new StringBuilder();     // Catch: IOException -> L4
        print(r100, r101);     // Catch: IOException -> L4
        return r101.toString();
    L4:
        e = move-exception;
        throw new IllegalStateException(e);
    }

    public static String printToUnicodeString(MessageOrBuilder r100) {
        StringBuilder r101 = new StringBuilder();     // Catch: IOException -> L4
        Printer.access$000(Printer.UNICODE, r100, multiLineOutput(r101));     // Catch: IOException -> L4
        return r101.toString();
    L4:
        e = move-exception;
        throw new IllegalStateException(e);
    }

    public static String shortDebugString(MessageOrBuilder r100) {
        StringBuilder r101 = new StringBuilder();     // Catch: IOException -> L4
        Printer.access$000(Printer.DEFAULT, r100, singleLineOutput(r101));     // Catch: IOException -> L4
        return r101.toString();
    L4:
        e = move-exception;
        throw new IllegalStateException(e);
    }

    private static TextGenerator singleLineOutput(Appendable r100) {
        return new TextGenerator(r100, true, null);
    }

    public static ByteString unescapeBytes(CharSequence r100) throws InvalidEscapeSequenceException {
        ByteString r101 = ByteString.copyFromUtf8(r100.toString());
        int r102 = r101.size();
        byte[] r103 = new byte[r102];
        int r104 = 0;
        int r105 = 0;
    L4:
        if (r104 >= r101.size()) goto L73;
        byte r106 = r101.byteAt(r104);
        if (r106 != 92) goto L70;
        r104 = r104 + 1;
        if (r104 >= r101.size()) goto L69;
        byte r107 = r101.byteAt(r104);
        if (isOctal(r107) == false) goto L23;
        int r108 = digitValue(r107);
        int r109 = r104 + 1;
        if (r109 < r101.size()) goto L14;
    L16:
        int r110 = r104 + 1;
        if (r110 < r101.size()) goto L19;
    L21:
        int r111 = r105 + 1;
        r103[r105] = (byte) r108;
    L71:
        r105 = r111;
    L72:
        r104 = r104 + 1;
        goto L4
    L19:
        if (isOctal(r101.byteAt(r110)) == false) goto L21;
        r108 = (r108 * 8) + digitValue(r101.byteAt(r110));
        r104 = r110;
        goto L21
    L14:
        if (isOctal(r101.byteAt(r109)) == false) goto L16;
        r108 = (r108 * 8) + digitValue(r101.byteAt(r109));
        r104 = r109;
        goto L16
    L23:
        if (r107 != 34) goto L25;
        int r112 = r105 + 1;
        r103[r105] = 34;
    L67:
        r105 = r112;
        goto L72
    L25:
        if (r107 == 39) goto L65;
        if (r107 != 92) goto L28;
        r112 = r105 + 1;
        r103[r105] = 92;
        goto L67
    L28:
        if (r107 != 102) goto L30;
        r112 = r105 + 1;
        r103[r105] = 12;
        goto L67
    L30:
        if (r107 != 110) goto L32;
        r112 = r105 + 1;
        r103[r105] = 10;
        goto L67
    L32:
        if (r107 != 114) goto L34;
        r112 = r105 + 1;
        r103[r105] = HTTP.CR;
        goto L67
    L34:
        if (r107 != 116) goto L36;
        r112 = r105 + 1;
        r103[r105] = 9;
        goto L67
    L36:
        if (r107 != 118) goto L38;
        r112 = r105 + 1;
        r103[r105] = 11;
        goto L67
    L38:
        if (r107 != 120) goto L40;
        r104 = r104 + 1;
        if (r104 >= r101.size()) goto L58;
        if (isHex(r101.byteAt(r104)) == false) goto L58;
        int r113 = digitValue(r101.byteAt(r104));
        int r114 = r104 + 1;
        if (r114 < r101.size()) goto L54;
    L56:
        r111 = r105 + 1;
        r103[r105] = (byte) r113;
        goto L71
    L54:
        if (isHex(r101.byteAt(r114)) == false) goto L56;
        r113 = (r113 * 16) + digitValue(r101.byteAt(r114));
        r104 = r114;
    L58:
        throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\x' with no digits");
    L40:
        if (r107 != 97) goto L42;
        r112 = r105 + 1;
        r103[r105] = 7;
        goto L67
    L42:
        if (r107 != 98) goto L45;
        r112 = r105 + 1;
        r103[r105] = 8;
        goto L67
    L45:
        throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\" + ((char) r107) + '\'');
    L65:
        r112 = r105 + 1;
        r103[r105] = 39;
        goto L67
    L69:
        throw new InvalidEscapeSequenceException("Invalid escape sequence: '\\' at end of string.");
    L70:
        r111 = r105 + 1;
        r103[r105] = r106;
        goto L71
    L73:
        if (r102 != r105) goto L76;
        return ByteString.wrap(r103);
    L76:
        return ByteString.copyFrom(r103, 0, r105);
    }

    public static String unescapeText(String r100) throws InvalidEscapeSequenceException {
        return unescapeBytes(r100).toStringUtf8();
    }

    public static String unsignedToString(long r100) {
        if (r100 < 0) goto L7;
        return Long.toString(r100);
    L7:
        return BigInteger.valueOf(r100 & Long.MAX_VALUE).setBit(63).toString();
    }

    public static String escapeBytes(byte[] r100) {
        return TextFormatEscaper.escapeBytes(r100);
    }

    public static String printToString(UnknownFieldSet r100) {
        StringBuilder r101 = new StringBuilder();     // Catch: IOException -> L4
        print(r100, r101);     // Catch: IOException -> L4
        return r101.toString();
    L4:
        e = move-exception;
        throw new IllegalStateException(e);
    }

    public static String printToUnicodeString(UnknownFieldSet r100) {
        StringBuilder r101 = new StringBuilder();     // Catch: IOException -> L4
        Printer.access$100(Printer.UNICODE, r100, multiLineOutput(r101));     // Catch: IOException -> L4
        return r101.toString();
    L4:
        e = move-exception;
        throw new IllegalStateException(e);
    }

    public static String shortDebugString(UnknownFieldSet r100) {
        StringBuilder r101 = new StringBuilder();     // Catch: IOException -> L4
        Printer.access$100(Printer.DEFAULT, r100, singleLineOutput(r101));     // Catch: IOException -> L4
        return r101.toString();
    L4:
        e = move-exception;
        throw new IllegalStateException(e);
    }

    public static String unsignedToString(int r100) {
        if (r100 < 0) goto L6;
        return Integer.toString(r100);
    L6:
        return Long.toString(((long) r100) & BodyPartID.bodyIdMax);
    }

    public static void merge(CharSequence r100, Message.Builder r101) throws ParseException {
        PARSER.merge(r100, r101);
    }

    public static void print(MessageOrBuilder r100, Appendable r101) throws IOException {
        Printer.access$000(Printer.DEFAULT, r100, multiLineOutput(r101));
    }

    public static String printFieldToString(Descriptors.FieldDescriptor r100, Object r101) {
        StringBuilder r102 = new StringBuilder();     // Catch: IOException -> L4
        printField(r100, r101, r102);     // Catch: IOException -> L4
        return r102.toString();
    L4:
        e = move-exception;
        throw new IllegalStateException(e);
    }

    public static void printUnicode(MessageOrBuilder r100, Appendable r101) throws IOException {
        Printer.access$000(Printer.UNICODE, r100, multiLineOutput(r101));
    }

    public static String shortDebugString(Descriptors.FieldDescriptor r100, Object r101) {
        StringBuilder r102 = new StringBuilder();     // Catch: IOException -> L4
        Printer.access$200(Printer.DEFAULT, r100, r101, singleLineOutput(r102));     // Catch: IOException -> L4
        return r102.toString();
    L4:
        e = move-exception;
        throw new IllegalStateException(e);
    }

    public static void merge(Readable r100, Message.Builder r101) throws IOException {
        PARSER.merge(r100, r101);
    }

    public static void print(UnknownFieldSet r100, Appendable r101) throws IOException {
        Printer.access$100(Printer.DEFAULT, r100, multiLineOutput(r101));
    }

    public static void printUnicode(UnknownFieldSet r100, Appendable r101) throws IOException {
        Printer.access$100(Printer.UNICODE, r100, multiLineOutput(r101));
    }

    public static /* synthetic */ void access$400(int r100, Object r101, TextGenerator r102) throws IOException {
        printUnknownFieldValue(r100, r101, r102);
    }

    public static void merge(CharSequence r100, ExtensionRegistry r101, Message.Builder r102) throws ParseException {
        PARSER.merge(r100, r101, r102);
    }

    private static long parseInteger(String r100, boolean r101, boolean r102) throws NumberFormatException {
        int r103 = 0;
        if (r100.startsWith("-", 0) == false) goto L8;
        if (r101 == false) goto L7;
        r103 = 1;
        boolean r104 = true;
    L10:
        if (r100.startsWith("0x", r103) == false) goto L13;
        r103 = r103 + 2;
        int r105 = 16;
    L16:
        String r106 = r100.substring(r103);
        if (r106.length() >= 16) goto L37;
        long r107 = CastLongProtector.parseLong(r106, r105);
        if (r104 == false) goto L21;
        r107 = -r107;
    L21:
        if (r102 == true) goto L64;
        if (r101 == false) goto L31;
        if (r107 > SieveCacheKt.NodeLinkMask) goto L29;
        if (r107 < SieveCacheKt.NodeMetaAndPreviousMask) goto L29;
        return r107;
    L29:
        throw new NumberFormatException("Number out of range for 32-bit signed integer: ".concat(r100));
    L31:
        if (r107 >= 4294967296L) goto L36;
        if (r107 < 0) goto L36;
        return r107;
    L36:
        throw new NumberFormatException("Number out of range for 32-bit unsigned integer: ".concat(r100));
    L64:
        return r107;
    L37:
        BigInteger r108 = new BigInteger(r106, r105);
        if (r104 == false) goto L40;
        r108 = r108.negate();
    L40:
        if (r102 == true) goto L52;
        if (r101 == false) goto L48;
        if (r108.bitLength() <= 31) goto L61;
        throw new NumberFormatException("Number out of range for 32-bit signed integer: ".concat(r100));
    L61:
        return r108.longValue();
    L48:
        if (r108.bitLength() <= 32) goto L61;
        throw new NumberFormatException("Number out of range for 32-bit unsigned integer: ".concat(r100));
    L52:
        if (r101 == false) goto L59;
        if (r108.bitLength() <= 63) goto L61;
        throw new NumberFormatException("Number out of range for 64-bit signed integer: ".concat(r100));
    L59:
        if (r108.bitLength() <= 64) goto L61;
        throw new NumberFormatException("Number out of range for 64-bit unsigned integer: ".concat(r100));
    L13:
        if (r100.startsWith("0", r103) == false) goto L15;
        r105 = 8;
        goto L16
    L15:
        r105 = 10;
        goto L16
    L7:
        throw new NumberFormatException("Number must be positive: ".concat(r100));
    L8:
        r104 = false;
        goto L10
    }

    public static void printField(Descriptors.FieldDescriptor r100, Object r101, Appendable r102) throws IOException {
        Printer.access$200(Printer.DEFAULT, r100, r101, multiLineOutput(r102));
    }

    public static void printFieldValue(Descriptors.FieldDescriptor r100, Object r101, Appendable r102) throws IOException {
        Printer.access$300(Printer.DEFAULT, r100, r101, multiLineOutput(r102));
    }

    public static void printUnicodeFieldValue(Descriptors.FieldDescriptor r100, Object r101, Appendable r102) throws IOException {
        Printer.access$300(Printer.UNICODE, r100, r101, multiLineOutput(r102));
    }

    private static void printUnknownFieldValue(int r100, Object r101, TextGenerator r102) throws IOException {
        int r103 = WireFormat.getTagWireType(r100);
        if (r103 != 0) goto L5;
        r102.print(unsignedToString(((Long) r101).longValue()));
        return;
    L5:
        if (r103 != 1) goto L7;
        r102.print(String.format(null, "0x%016x", new Object[]{(Long) r101}));
        return;
    L7:
        if (r103 != 2) goto L9;
        UnknownFieldSet r104 = UnknownFieldSet.parseFrom((ByteString) r101);     // Catch: InvalidProtocolBufferException -> L18
        r102.print("{");     // Catch: InvalidProtocolBufferException -> L18
        r102.eol();     // Catch: InvalidProtocolBufferException -> L18
        r102.indent();     // Catch: InvalidProtocolBufferException -> L18
        Printer.access$100(Printer.DEFAULT, r104, r102);     // Catch: InvalidProtocolBufferException -> L18
        r102.outdent();     // Catch: InvalidProtocolBufferException -> L18
        r102.print(i.f25855d);     // Catch: InvalidProtocolBufferException -> L18
        return;
    L18:
        r102.print("\"");
        r102.print(escapeBytes((ByteString) r101));
        r102.print("\"");
        return;
    L9:
        if (r103 != 3) goto L11;
        Printer.access$100(Printer.DEFAULT, (UnknownFieldSet) r101, r102);
        return;
    L11:
        if (r103 != 5) goto L14;
        r102.print(String.format(null, "0x%08x", new Object[]{(Integer) r101}));
        return;
    L14:
        throw new IllegalArgumentException("Bad tag: " + r100);
    }

    public static void merge(Readable r100, ExtensionRegistry r101, Message.Builder r102) throws IOException {
        PARSER.merge(r100, r101, r102);
    }

    public static void printUnknownFieldValue(int r100, Object r101, Appendable r102) throws IOException {
        printUnknownFieldValue(r100, r101, multiLineOutput(r102));
    }
}
