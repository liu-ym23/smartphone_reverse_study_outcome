package com.google.protobuf;

import androidx.camera.video.AudioStats;
import com.alipay.sdk.m.u.i;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes23.dex */
final class MessageLiteToString {
    private static final String BUILDER_LIST_SUFFIX = "OrBuilderList";
    private static final String BYTES_SUFFIX = "Bytes";
    private static final String LIST_SUFFIX = "List";

    public MessageLiteToString() {
    }

    private static final String camelCaseToSnakeCase(String r100) {
        StringBuilder r101 = new StringBuilder();
        int r102 = 0;
    L4:
        if (r102 >= r100.length()) goto L10;
        char r103 = r100.charAt(r102);
        if (Character.isUpperCase(r103) == false) goto L8;
        r101.append("_");
    L8:
        r101.append(Character.toLowerCase(r103));
        r102 = r102 + 1;
        goto L4
    L10:
        return r101.toString();
    }

    private static boolean isDefaultValue(Object r100) {
        if ((r100 instanceof Boolean) == false) goto L7;
        return !((Boolean) r100).booleanValue();
    L7:
        if ((r100 instanceof Integer) == false) goto L14;
        if (((Integer) r100).intValue() == 0) goto L50;
        return false;
    L50:
        return true;
    L14:
        if ((r100 instanceof Float) == false) goto L21;
        if (((Float) r100).floatValue() == 0.0f) goto L51;
        return false;
    L51:
        return true;
    L21:
        if ((r100 instanceof Double) == false) goto L28;
        if (((Double) r100).doubleValue() == AudioStats.AUDIO_AMPLITUDE_NONE) goto L52;
        return false;
    L52:
        return true;
    L28:
        if ((r100 instanceof String) == false) goto L32;
        return r100.equals("");
    L32:
        if ((r100 instanceof ByteString) == false) goto L36;
        return r100.equals(ByteString.EMPTY);
    L36:
        if ((r100 instanceof MessageLite) == false) goto L43;
        if (r100 == ((MessageLite) r100).getDefaultInstanceForType()) goto L53;
        return false;
    L53:
        return true;
    L43:
        if ((r100 instanceof java.lang.Enum) == true) goto L45;
        return false;
    L45:
        if (((java.lang.Enum) r100).ordinal() == 0) goto L54;
        return false;
    L54:
        return true;
    }

    public static String toString(MessageLite r100, String r101) {
        StringBuilder r102 = new StringBuilder();
        r102.append("# ");
        r102.append(r101);
        reflectivePrintWithIndent(r100, r102, 0);
        return r102.toString();
    }

    private static void reflectivePrintWithIndent(MessageLite r110, StringBuilder r111, int r112) {
        HashMap r100 = new HashMap();
        HashMap r101 = new HashMap();
        TreeSet r102 = new TreeSet();
        java.lang.reflect.Method[] r103 = r110.getClass().getDeclaredMethods();
        int r104 = r103.length;
        int r105 = 0;
    L4:
        if (r105 >= r104) goto L11;
        java.lang.reflect.Method r106 = r103[r105];
        r101.put(r106.getName(), r106);
        if (r106.getParameterTypes().length != 0) goto L10;
        r100.put(r106.getName(), r106);
        if (r106.getName().startsWith(MonitorConstants.CONNECT_TYPE_GET) == false) goto L10;
        r102.add(r106.getName());
    L10:
        r105 = r105 + 1;
        goto L4
    L11:
        Iterator r107 = r102.iterator();
    L13:
        if (r107.hasNext() == false) goto L43;
        String r108 = ((String) r107.next()).replaceFirst(MonitorConstants.CONNECT_TYPE_GET, "");
        boolean r109 = true;
        if (r108.endsWith(LIST_SUFFIX) == false) goto L24;
        if (r108.endsWith(BUILDER_LIST_SUFFIX) == true) goto L24;
        String r113 = r108.substring(0, 1).toLowerCase() + r108.substring(1, r108.length() - 4);
        java.lang.reflect.Method r114 = (java.lang.reflect.Method) r100.get(MonitorConstants.CONNECT_TYPE_GET.concat(r108));
        if (r114 == null) goto L24;
        if (r114.getReturnType().equals(List.class) == false) goto L24;
        printField(r111, r112, camelCaseToSnakeCase(r113), GeneratedMessageLite.invokeOrDie(r114, r110, new Object[0]));
    L24:
        if (((java.lang.reflect.Method) r101.get("set".concat(r108))) == null) goto L13;
        if (r108.endsWith(BYTES_SUFFIX) == false) goto L31;
        if (r100.containsKey(MonitorConstants.CONNECT_TYPE_GET + r108.substring(0, r108.length() - 5)) == true) goto L13;
    L31:
        String r115 = r108.substring(0, 1).toLowerCase() + r108.substring(1);
        java.lang.reflect.Method r116 = (java.lang.reflect.Method) r100.get(MonitorConstants.CONNECT_TYPE_GET.concat(r108));
        java.lang.reflect.Method r117 = (java.lang.reflect.Method) r100.get("has".concat(r108));
        if (r116 == null) goto L13;
        Object r118 = GeneratedMessageLite.invokeOrDie(r116, r110, new Object[0]);
        if (r117 == null) goto L36;
        r109 = ((Boolean) GeneratedMessageLite.invokeOrDie(r117, r110, new Object[0])).booleanValue();
    L40:
        if (r109 == false) goto L13;
        printField(r111, r112, camelCaseToSnakeCase(r115), r118);
        goto L13
    L36:
        if (isDefaultValue(r118) == false) goto L40;
        r109 = false;
        goto L40
    L43:
        if ((r110 instanceof GeneratedMessageLite.ExtendableMessage) == false) goto L48;
        Iterator<Map.Entry<FieldDescriptorType, Object>> r119 = ((GeneratedMessageLite.ExtendableMessage) r110).extensions.iterator();
    L46:
        if (r119.hasNext() == false) goto L48;
        Map.Entry r120 = (Map.Entry) r119.next();
        printField(r111, r112, "[" + ((GeneratedMessageLite.ExtensionDescriptor) r120.getKey()).getNumber() + "]", r120.getValue());
    L48:
        UnknownFieldSetLite r121 = ((GeneratedMessageLite) r110).unknownFields;
        if (r121 == null) goto L75;
        r121.printWithIndent(r111, r112);
        return;
    }

    public static final void printField(StringBuilder r100, int r101, String r102, Object r103) {
        if ((r103 instanceof List) == false) goto L9;
        Iterator r104 = ((List) r103).iterator();
    L6:
        if (r104.hasNext() == false) goto L8;
        printField(r100, r101, r102, r104.next());
        goto L6
    L8:
        return;
    L9:
        r100.append('\n');
        int r105 = 0;
        int r106 = 0;
    L11:
        if (r106 >= r101) goto L13;
        r100.append(' ');
        r106 = r106 + 1;
        goto L11
    L13:
        r100.append(r102);
        if ((r103 instanceof String) == false) goto L17;
        r100.append(": \"");
        r100.append(TextFormatEscaper.escapeText((String) r103));
        r100.append(Typography.quote);
        return;
    L17:
        if ((r103 instanceof ByteString) == false) goto L20;
        r100.append(": \"");
        r100.append(TextFormatEscaper.escapeBytes((ByteString) r103));
        r100.append(Typography.quote);
        return;
    L20:
        if ((r103 instanceof GeneratedMessageLite) == false) goto L25;
        r100.append(" {");
        reflectivePrintWithIndent((GeneratedMessageLite) r103, r100, r101 + 2);
        r100.append("\n");
    L22:
        if (r105 >= r101) goto L24;
        r100.append(' ');
        r105 = r105 + 1;
        goto L22
    L24:
        r100.append(i.f25855d);
        return;
    L25:
        r100.append(": ");
        r100.append(r103.toString());
    }
}
