package org.apache.commons.lang3.builder;

import com.alipay.sdk.m.u.i;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.text.Typography;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringEscapeUtils;
import tb2.c;

/* JADX INFO: loaded from: classes42.dex */
public abstract class ToStringStyle implements Serializable {
    public static final ToStringStyle DEFAULT_STYLE = null;
    public static final ToStringStyle JSON_STYLE = null;
    public static final ToStringStyle MULTI_LINE_STYLE = null;
    public static final ToStringStyle NO_CLASS_NAME_STYLE = null;
    public static final ToStringStyle NO_FIELD_NAMES_STYLE = null;
    private static final ThreadLocal<WeakHashMap<Object, Object>> REGISTRY = null;
    public static final ToStringStyle SHORT_PREFIX_STYLE = null;
    public static final ToStringStyle SIMPLE_STYLE = null;
    private static final long serialVersionUID = -2587890625525655916L;
    private boolean arrayContentDetail;
    private String arrayEnd;
    private String arraySeparator;
    private String arrayStart;
    private String contentEnd;
    private String contentStart;
    private boolean defaultFullDetail;
    private String fieldNameValueSeparator;
    private String fieldSeparator;
    private boolean fieldSeparatorAtEnd;
    private boolean fieldSeparatorAtStart;
    private String nullText;
    private String sizeEndText;
    private String sizeStartText;
    private String summaryObjectEndText;
    private String summaryObjectStartText;
    private boolean useClassName;
    private boolean useFieldNames;
    private boolean useIdentityHashCode;
    private boolean useShortClassName;

    public static final class DefaultToStringStyle extends ToStringStyle {
        private static final long serialVersionUID = 1;

        public DefaultToStringStyle() {
        }

        private Object readResolve() {
            return ToStringStyle.DEFAULT_STYLE;
        }
    }

    public static final class JsonToStringStyle extends ToStringStyle {
        private static final long serialVersionUID = 1;

        public JsonToStringStyle() {
            setUseClassName(false);
            setUseIdentityHashCode(false);
            setContentStart("{");
            setContentEnd(i.f25855d);
            setArrayStart("[");
            setArrayEnd("]");
            setFieldSeparator(",");
            setFieldNameValueSeparator(":");
            setNullText("null");
            setSummaryObjectStartText("\"<");
            setSummaryObjectEndText(">\"");
            setSizeStartText("\"<size=");
            setSizeEndText(">\"");
        }

        private Object readResolve() {
            return ToStringStyle.JSON_STYLE;
        }

        private boolean isJsonArray(String r100) {
            if (r100.startsWith(getArrayStart()) == true) goto L5;
        L7:
            return false;
        L5:
            if (r100.endsWith(getArrayEnd()) == false) goto L7;
            return true;
        }

        private boolean isJsonObject(String r100) {
            if (r100.startsWith(getContentStart()) == true) goto L5;
        L7:
            return false;
        L5:
            if (r100.endsWith(getContentEnd()) == false) goto L7;
            return true;
        }

        private void appendValueAsString(StringBuffer r100, String r101) {
            r100.append(Typography.quote);
            r100.append(StringEscapeUtils.escapeJson(r101));
            r100.append(Typography.quote);
        }

        @Override // org.apache.commons.lang3.builder.ToStringStyle
        public void appendFieldStart(StringBuffer r100, String r101) {
            if (r101 == null) goto L6;
            super.appendFieldStart(r100, "\"" + StringEscapeUtils.escapeJson(r101) + "\"");
            return;
        L6:
            throw new UnsupportedOperationException("Field names are mandatory when using JsonToStringStyle");
        }

        @Override // org.apache.commons.lang3.builder.ToStringStyle
        public void appendDetail(StringBuffer r100, String r101, Object r102) {
            if (r102 != null) goto L6;
            appendNullText(r100, r101);
            return;
        L6:
            if ((r102 instanceof String) == false) goto L8;
        L26:
            appendValueAsString(r100, r102.toString());
            return;
        L8:
            if ((r102 instanceof Character) == true) goto L26;
            if ((r102 instanceof Number) == false) goto L13;
        L24:
            r100.append(r102);
            return;
        L13:
            if ((r102 instanceof Boolean) == true) goto L24;
            String r103 = r102.toString();
            if (isJsonObject(r103) == false) goto L18;
        L22:
            r100.append(r102);
            return;
        L18:
            if (isJsonArray(r103) == true) goto L22;
            appendDetail(r100, r101, r103);
        }

        @Override // org.apache.commons.lang3.builder.ToStringStyle
        public void appendDetail(StringBuffer r100, String r101, char r102) {
            appendValueAsString(r100, String.valueOf(r102));
        }

        @Override // org.apache.commons.lang3.builder.ToStringStyle
        public void append(StringBuffer r100, String r101, Object r102, Boolean r103) {
            if (r101 == null) goto L10;
            if (isFullDetail(r103) == false) goto L8;
            super.append(r100, r101, r102, r103);
            return;
        L8:
            throw new UnsupportedOperationException("FullDetail must be true when using JsonToStringStyle");
        L10:
            throw new UnsupportedOperationException("Field names are mandatory when using JsonToStringStyle");
        }

        @Override // org.apache.commons.lang3.builder.ToStringStyle
        public void append(StringBuffer r100, String r101, byte[] r102, Boolean r103) {
            if (r101 == null) goto L10;
            if (isFullDetail(r103) == false) goto L8;
            super.append(r100, r101, r102, r103);
            return;
        L8:
            throw new UnsupportedOperationException("FullDetail must be true when using JsonToStringStyle");
        L10:
            throw new UnsupportedOperationException("Field names are mandatory when using JsonToStringStyle");
        }

        @Override // org.apache.commons.lang3.builder.ToStringStyle
        public void append(StringBuffer r100, String r101, char[] r102, Boolean r103) {
            if (r101 == null) goto L10;
            if (isFullDetail(r103) == false) goto L8;
            super.append(r100, r101, r102, r103);
            return;
        L8:
            throw new UnsupportedOperationException("FullDetail must be true when using JsonToStringStyle");
        L10:
            throw new UnsupportedOperationException("Field names are mandatory when using JsonToStringStyle");
        }

        @Override // org.apache.commons.lang3.builder.ToStringStyle
        public void append(StringBuffer r100, String r101, double[] r102, Boolean r103) {
            if (r101 == null) goto L10;
            if (isFullDetail(r103) == false) goto L8;
            super.append(r100, r101, r102, r103);
            return;
        L8:
            throw new UnsupportedOperationException("FullDetail must be true when using JsonToStringStyle");
        L10:
            throw new UnsupportedOperationException("Field names are mandatory when using JsonToStringStyle");
        }

        @Override // org.apache.commons.lang3.builder.ToStringStyle
        public void append(StringBuffer r100, String r101, float[] r102, Boolean r103) {
            if (r101 == null) goto L10;
            if (isFullDetail(r103) == false) goto L8;
            super.append(r100, r101, r102, r103);
            return;
        L8:
            throw new UnsupportedOperationException("FullDetail must be true when using JsonToStringStyle");
        L10:
            throw new UnsupportedOperationException("Field names are mandatory when using JsonToStringStyle");
        }

        @Override // org.apache.commons.lang3.builder.ToStringStyle
        public void append(StringBuffer r100, String r101, int[] r102, Boolean r103) {
            if (r101 == null) goto L10;
            if (isFullDetail(r103) == false) goto L8;
            super.append(r100, r101, r102, r103);
            return;
        L8:
            throw new UnsupportedOperationException("FullDetail must be true when using JsonToStringStyle");
        L10:
            throw new UnsupportedOperationException("Field names are mandatory when using JsonToStringStyle");
        }

        @Override // org.apache.commons.lang3.builder.ToStringStyle
        public void append(StringBuffer r100, String r101, long[] r102, Boolean r103) {
            if (r101 == null) goto L10;
            if (isFullDetail(r103) == false) goto L8;
            super.append(r100, r101, r102, r103);
            return;
        L8:
            throw new UnsupportedOperationException("FullDetail must be true when using JsonToStringStyle");
        L10:
            throw new UnsupportedOperationException("Field names are mandatory when using JsonToStringStyle");
        }

        @Override // org.apache.commons.lang3.builder.ToStringStyle
        public void append(StringBuffer r100, String r101, Object[] r102, Boolean r103) {
            if (r101 == null) goto L10;
            if (isFullDetail(r103) == false) goto L8;
            super.append(r100, r101, r102, r103);
            return;
        L8:
            throw new UnsupportedOperationException("FullDetail must be true when using JsonToStringStyle");
        L10:
            throw new UnsupportedOperationException("Field names are mandatory when using JsonToStringStyle");
        }

        @Override // org.apache.commons.lang3.builder.ToStringStyle
        public void append(StringBuffer r100, String r101, short[] r102, Boolean r103) {
            if (r101 == null) goto L10;
            if (isFullDetail(r103) == false) goto L8;
            super.append(r100, r101, r102, r103);
            return;
        L8:
            throw new UnsupportedOperationException("FullDetail must be true when using JsonToStringStyle");
        L10:
            throw new UnsupportedOperationException("Field names are mandatory when using JsonToStringStyle");
        }

        @Override // org.apache.commons.lang3.builder.ToStringStyle
        public void append(StringBuffer r100, String r101, boolean[] r102, Boolean r103) {
            if (r101 == null) goto L10;
            if (isFullDetail(r103) == false) goto L8;
            super.append(r100, r101, r102, r103);
            return;
        L8:
            throw new UnsupportedOperationException("FullDetail must be true when using JsonToStringStyle");
        L10:
            throw new UnsupportedOperationException("Field names are mandatory when using JsonToStringStyle");
        }
    }

    public static final class MultiLineToStringStyle extends ToStringStyle {
        private static final long serialVersionUID = 1;

        public MultiLineToStringStyle() {
            setContentStart("[");
            setFieldSeparator(System.lineSeparator() + c.DEFAULT_TEXT);
            setFieldSeparatorAtStart(true);
            setContentEnd(System.lineSeparator() + "]");
        }

        private Object readResolve() {
            return ToStringStyle.MULTI_LINE_STYLE;
        }
    }

    public static final class NoClassNameToStringStyle extends ToStringStyle {
        private static final long serialVersionUID = 1;

        public NoClassNameToStringStyle() {
            setUseClassName(false);
            setUseIdentityHashCode(false);
        }

        private Object readResolve() {
            return ToStringStyle.NO_CLASS_NAME_STYLE;
        }
    }

    public static final class NoFieldNameToStringStyle extends ToStringStyle {
        private static final long serialVersionUID = 1;

        public NoFieldNameToStringStyle() {
            setUseFieldNames(false);
        }

        private Object readResolve() {
            return ToStringStyle.NO_FIELD_NAMES_STYLE;
        }
    }

    public static final class ShortPrefixToStringStyle extends ToStringStyle {
        private static final long serialVersionUID = 1;

        public ShortPrefixToStringStyle() {
            setUseShortClassName(true);
            setUseIdentityHashCode(false);
        }

        private Object readResolve() {
            return ToStringStyle.SHORT_PREFIX_STYLE;
        }
    }

    public static final class SimpleToStringStyle extends ToStringStyle {
        private static final long serialVersionUID = 1;

        public SimpleToStringStyle() {
            setUseClassName(false);
            setUseIdentityHashCode(false);
            setUseFieldNames(false);
            setContentStart("");
            setContentEnd("");
        }

        private Object readResolve() {
            return ToStringStyle.SIMPLE_STYLE;
        }
    }

    static {
        DEFAULT_STYLE = new DefaultToStringStyle();
        MULTI_LINE_STYLE = new MultiLineToStringStyle();
        NO_FIELD_NAMES_STYLE = new NoFieldNameToStringStyle();
        SHORT_PREFIX_STYLE = new ShortPrefixToStringStyle();
        SIMPLE_STYLE = new SimpleToStringStyle();
        NO_CLASS_NAME_STYLE = new NoClassNameToStringStyle();
        JSON_STYLE = new JsonToStringStyle();
        REGISTRY = new ThreadLocal();
    }

    public static Map<Object, Object> getRegistry() {
        return REGISTRY.get();
    }

    public ToStringStyle() {
        this.useFieldNames = true;
        this.useClassName = true;
        this.useShortClassName = false;
        this.useIdentityHashCode = true;
        this.contentStart = "[";
        this.contentEnd = "]";
        this.fieldNameValueSeparator = ContainerUtils.KEY_VALUE_DELIMITER;
        this.fieldSeparatorAtStart = false;
        this.fieldSeparatorAtEnd = false;
        this.fieldSeparator = ",";
        this.arrayStart = "{";
        this.arraySeparator = ",";
        this.arrayContentDetail = true;
        this.arrayEnd = i.f25855d;
        this.defaultFullDetail = true;
        this.nullText = "<null>";
        this.sizeStartText = "<size=";
        this.sizeEndText = ">";
        this.summaryObjectStartText = "<";
        this.summaryObjectEndText = ">";
    }

    public String getArrayEnd() {
        return this.arrayEnd;
    }

    public String getArraySeparator() {
        return this.arraySeparator;
    }

    public String getArrayStart() {
        return this.arrayStart;
    }

    public String getContentEnd() {
        return this.contentEnd;
    }

    public String getContentStart() {
        return this.contentStart;
    }

    public String getFieldNameValueSeparator() {
        return this.fieldNameValueSeparator;
    }

    public String getFieldSeparator() {
        return this.fieldSeparator;
    }

    public String getNullText() {
        return this.nullText;
    }

    public String getSizeEndText() {
        return this.sizeEndText;
    }

    public String getSizeStartText() {
        return this.sizeStartText;
    }

    public String getSummaryObjectEndText() {
        return this.summaryObjectEndText;
    }

    public String getSummaryObjectStartText() {
        return this.summaryObjectStartText;
    }

    public boolean isArrayContentDetail() {
        return this.arrayContentDetail;
    }

    public boolean isDefaultFullDetail() {
        return this.defaultFullDetail;
    }

    public boolean isFieldSeparatorAtEnd() {
        return this.fieldSeparatorAtEnd;
    }

    public boolean isFieldSeparatorAtStart() {
        return this.fieldSeparatorAtStart;
    }

    public boolean isUseClassName() {
        return this.useClassName;
    }

    public boolean isUseFieldNames() {
        return this.useFieldNames;
    }

    public boolean isUseIdentityHashCode() {
        return this.useIdentityHashCode;
    }

    public boolean isUseShortClassName() {
        return this.useShortClassName;
    }

    public static boolean isRegistered(Object r100) {
        Map<Object, Object> r101 = getRegistry();
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (r101.containsKey(r100) == false) goto L7;
        return true;
    }

    public static void register(Object r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (getRegistry() != null) goto L6;
        REGISTRY.set(new WeakHashMap());
    L6:
        getRegistry().put(r100, null);
    }

    public static void unregister(Object r100) {
        if (r100 == null) goto L9;
        Map<Object, Object> r101 = getRegistry();
        if (r101 == null) goto L10;
        r101.remove(r100);
        if (r101.isEmpty() == false) goto L11;
        REGISTRY.remove();
        return;
    L11:
        return;
    L10:
        return;
    }

    public void appendContentEnd(StringBuffer r100) {
        r100.append(this.contentEnd);
    }

    public void appendContentStart(StringBuffer r100) {
        r100.append(this.contentStart);
    }

    public void appendFieldSeparator(StringBuffer r100) {
        r100.append(this.fieldSeparator);
    }

    public String getShortClassName(Class<?> r100) {
        return ClassUtils.getShortClassName(r100);
    }

    public boolean isFullDetail(Boolean r100) {
        if (r100 != null) goto L6;
        return this.defaultFullDetail;
    L6:
        return r100.booleanValue();
    }

    public void removeLastFieldSeparator(StringBuffer r100) {
        int r101 = r100.length();
        int r102 = this.fieldSeparator.length();
        if (r101 <= 0) goto L18;
        if (r102 <= 0) goto L19;
        if (r101 < r102) goto L20;
        boolean r103 = false;
        int r104 = 0;
    L7:
        if (r104 >= r102) goto L12;
        if (r100.charAt((r101 - 1) - r104) != this.fieldSeparator.charAt((r102 - 1) - r104)) goto L13;
        r104 = r104 + 1;
    L13:
        if (r103 == false) goto L21;
        r100.setLength(r101 - r102);
        return;
    L21:
        return;
    L12:
        r103 = true;
        goto L13
    L20:
        return;
    L19:
        return;
    }

    public void setArrayContentDetail(boolean r100) {
        this.arrayContentDetail = r100;
    }

    public void setArrayEnd(String r100) {
        if (r100 != null) goto L4;
        r100 = "";
    L4:
        this.arrayEnd = r100;
    }

    public void setArraySeparator(String r100) {
        if (r100 != null) goto L4;
        r100 = "";
    L4:
        this.arraySeparator = r100;
    }

    public void setArrayStart(String r100) {
        if (r100 != null) goto L4;
        r100 = "";
    L4:
        this.arrayStart = r100;
    }

    public void setContentEnd(String r100) {
        if (r100 != null) goto L4;
        r100 = "";
    L4:
        this.contentEnd = r100;
    }

    public void setContentStart(String r100) {
        if (r100 != null) goto L4;
        r100 = "";
    L4:
        this.contentStart = r100;
    }

    public void setDefaultFullDetail(boolean r100) {
        this.defaultFullDetail = r100;
    }

    public void setFieldNameValueSeparator(String r100) {
        if (r100 != null) goto L4;
        r100 = "";
    L4:
        this.fieldNameValueSeparator = r100;
    }

    public void setFieldSeparator(String r100) {
        if (r100 != null) goto L4;
        r100 = "";
    L4:
        this.fieldSeparator = r100;
    }

    public void setFieldSeparatorAtEnd(boolean r100) {
        this.fieldSeparatorAtEnd = r100;
    }

    public void setFieldSeparatorAtStart(boolean r100) {
        this.fieldSeparatorAtStart = r100;
    }

    public void setNullText(String r100) {
        if (r100 != null) goto L4;
        r100 = "";
    L4:
        this.nullText = r100;
    }

    public void setSizeEndText(String r100) {
        if (r100 != null) goto L4;
        r100 = "";
    L4:
        this.sizeEndText = r100;
    }

    public void setSizeStartText(String r100) {
        if (r100 != null) goto L4;
        r100 = "";
    L4:
        this.sizeStartText = r100;
    }

    public void setSummaryObjectEndText(String r100) {
        if (r100 != null) goto L4;
        r100 = "";
    L4:
        this.summaryObjectEndText = r100;
    }

    public void setSummaryObjectStartText(String r100) {
        if (r100 != null) goto L4;
        r100 = "";
    L4:
        this.summaryObjectStartText = r100;
    }

    public void setUseClassName(boolean r100) {
        this.useClassName = r100;
    }

    public void setUseFieldNames(boolean r100) {
        this.useFieldNames = r100;
    }

    public void setUseIdentityHashCode(boolean r100) {
        this.useIdentityHashCode = r100;
    }

    public void setUseShortClassName(boolean r100) {
        this.useShortClassName = r100;
    }

    public void appendClassName(StringBuffer r100, Object r101) {
        if (this.useClassName == false) goto L10;
        if (r101 == null) goto L11;
        register(r101);
        if (this.useShortClassName == false) goto L8;
        r100.append(getShortClassName(r101.getClass()));
        return;
    L8:
        r100.append(r101.getClass().getName());
        return;
    L11:
        return;
    }

    public void appendEnd(StringBuffer r100, Object r101) {
        if (this.fieldSeparatorAtEnd == true) goto L5;
        removeLastFieldSeparator(r100);
    L5:
        appendContentEnd(r100);
        unregister(r101);
    }

    public void appendFieldEnd(StringBuffer r100, String r101) {
        appendFieldSeparator(r100);
    }

    public void appendFieldStart(StringBuffer r100, String r101) {
        if (this.useFieldNames == false) goto L7;
        if (r101 == null) goto L8;
        r100.append(r101);
        r100.append(this.fieldNameValueSeparator);
        return;
    L8:
        return;
    }

    public void appendIdentityHashCode(StringBuffer r100, Object r101) {
        if (isUseIdentityHashCode() == false) goto L7;
        if (r101 == null) goto L8;
        register(r101);
        r100.append('@');
        r100.append(Integer.toHexString(System.identityHashCode(r101)));
        return;
    L8:
        return;
    }

    public void appendNullText(StringBuffer r100, String r101) {
        r100.append(this.nullText);
    }

    public void appendStart(StringBuffer r100, Object r101) {
        if (r101 == null) goto L7;
        appendClassName(r100, r101);
        appendIdentityHashCode(r100, r101);
        appendContentStart(r100);
        if (this.fieldSeparatorAtStart == false) goto L8;
        appendFieldSeparator(r100);
        return;
    L8:
        return;
    }

    public void appendSuper(StringBuffer r100, String r101) {
        appendToString(r100, r101);
    }

    public void appendToString(StringBuffer r100, String r101) {
        if (r101 == null) goto L12;
        int r102 = r101.indexOf(this.contentStart) + this.contentStart.length();
        int r103 = r101.lastIndexOf(this.contentEnd);
        if (r102 == r103) goto L13;
        if (r102 < 0) goto L14;
        if (r103 >= 0) goto L8;
        return;
    L8:
        if (this.fieldSeparatorAtStart == false) goto L10;
        removeLastFieldSeparator(r100);
    L10:
        r100.append(r101, r102, r103);
        appendFieldSeparator(r100);
        return;
    L14:
        return;
    L13:
        return;
    }

    public void append(StringBuffer r100, String r101, byte r102) {
        appendFieldStart(r100, r101);
        appendDetail(r100, r101, r102);
        appendFieldEnd(r100, r101);
    }

    public void appendCyclicObject(StringBuffer r100, String r101, Object r102) {
        ObjectUtils.identityToString(r100, r102);
    }

    public void appendDetail(StringBuffer r100, String r101, Object[] r102) {
        r100.append(this.arrayStart);
        int r103 = 0;
    L4:
        if (r103 >= r102.length) goto L12;
        Object r104 = r102[r103];
        if (r103 <= 0) goto L8;
        r100.append(this.arraySeparator);
    L8:
        if (r104 != null) goto L10;
        appendNullText(r100, r101);
    L11:
        r103 = r103 + 1;
        goto L4
    L10:
        appendInternal(r100, r101, r104, this.arrayContentDetail);
        goto L11
    L12:
        r100.append(this.arrayEnd);
    }

    public void appendSummary(StringBuffer r100, String r101, Object r102) {
        r100.append(this.summaryObjectStartText);
        r100.append(getShortClassName(r102.getClass()));
        r100.append(this.summaryObjectEndText);
    }

    public void appendSummarySize(StringBuffer r100, String r101, int r102) {
        r100.append(this.sizeStartText);
        r100.append(r102);
        r100.append(this.sizeEndText);
    }

    public void reflectionAppendArrayDetail(StringBuffer r100, String r101, Object r102) {
        r100.append(this.arrayStart);
        int r103 = Array.getLength(r102);
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L11;
        Object r105 = Array.get(r102, r104);
        if (r104 <= 0) goto L7;
        r100.append(this.arraySeparator);
    L7:
        if (r105 != null) goto L9;
        appendNullText(r100, r101);
    L10:
        r104 = r104 + 1;
        goto L3
    L9:
        appendInternal(r100, r101, r105, this.arrayContentDetail);
        goto L10
    L11:
        r100.append(this.arrayEnd);
    }

    public void append(StringBuffer r100, String r101, char r102) {
        appendFieldStart(r100, r101);
        appendDetail(r100, r101, r102);
        appendFieldEnd(r100, r101);
    }

    public void appendDetail(StringBuffer r100, String r101, byte[] r102) {
        r100.append(this.arrayStart);
        int r103 = 0;
    L4:
        if (r103 >= r102.length) goto L8;
        if (r103 <= 0) goto L7;
        r100.append(this.arraySeparator);
    L7:
        appendDetail(r100, r101, r102[r103]);
        r103 = r103 + 1;
        goto L4
    L8:
        r100.append(this.arrayEnd);
    }

    public void appendSummary(StringBuffer r100, String r101, byte[] r102) {
        appendSummarySize(r100, r101, r102.length);
    }

    public void append(StringBuffer r100, String r101, double r102) {
        appendFieldStart(r100, r101);
        appendDetail(r100, r101, r102);
        appendFieldEnd(r100, r101);
    }

    public void appendDetail(StringBuffer r100, String r101, char[] r102) {
        r100.append(this.arrayStart);
        int r103 = 0;
    L4:
        if (r103 >= r102.length) goto L8;
        if (r103 <= 0) goto L7;
        r100.append(this.arraySeparator);
    L7:
        appendDetail(r100, r101, r102[r103]);
        r103 = r103 + 1;
        goto L4
    L8:
        r100.append(this.arrayEnd);
    }

    public void appendSummary(StringBuffer r100, String r101, char[] r102) {
        appendSummarySize(r100, r101, r102.length);
    }

    public void append(StringBuffer r100, String r101, float r102) {
        appendFieldStart(r100, r101);
        appendDetail(r100, r101, r102);
        appendFieldEnd(r100, r101);
    }

    public void appendDetail(StringBuffer r100, String r101, double[] r102) {
        r100.append(this.arrayStart);
        int r103 = 0;
    L4:
        if (r103 >= r102.length) goto L8;
        if (r103 <= 0) goto L7;
        r100.append(this.arraySeparator);
    L7:
        appendDetail(r100, r101, r102[r103]);
        r103 = r103 + 1;
        goto L4
    L8:
        r100.append(this.arrayEnd);
    }

    public void appendSummary(StringBuffer r100, String r101, double[] r102) {
        appendSummarySize(r100, r101, r102.length);
    }

    public void append(StringBuffer r100, String r101, int r102) {
        appendFieldStart(r100, r101);
        appendDetail(r100, r101, r102);
        appendFieldEnd(r100, r101);
    }

    public void appendDetail(StringBuffer r100, String r101, float[] r102) {
        r100.append(this.arrayStart);
        int r103 = 0;
    L4:
        if (r103 >= r102.length) goto L8;
        if (r103 <= 0) goto L7;
        r100.append(this.arraySeparator);
    L7:
        appendDetail(r100, r101, r102[r103]);
        r103 = r103 + 1;
        goto L4
    L8:
        r100.append(this.arrayEnd);
    }

    public void appendSummary(StringBuffer r100, String r101, float[] r102) {
        appendSummarySize(r100, r101, r102.length);
    }

    public void append(StringBuffer r100, String r101, long r102) {
        appendFieldStart(r100, r101);
        appendDetail(r100, r101, r102);
        appendFieldEnd(r100, r101);
    }

    public void appendDetail(StringBuffer r100, String r101, int[] r102) {
        r100.append(this.arrayStart);
        int r103 = 0;
    L4:
        if (r103 >= r102.length) goto L8;
        if (r103 <= 0) goto L7;
        r100.append(this.arraySeparator);
    L7:
        appendDetail(r100, r101, r102[r103]);
        r103 = r103 + 1;
        goto L4
    L8:
        r100.append(this.arrayEnd);
    }

    public void appendSummary(StringBuffer r100, String r101, int[] r102) {
        appendSummarySize(r100, r101, r102.length);
    }

    public void append(StringBuffer r100, String r101, short r102) {
        appendFieldStart(r100, r101);
        appendDetail(r100, r101, r102);
        appendFieldEnd(r100, r101);
    }

    public void appendDetail(StringBuffer r100, String r101, long[] r102) {
        r100.append(this.arrayStart);
        int r103 = 0;
    L4:
        if (r103 >= r102.length) goto L8;
        if (r103 <= 0) goto L7;
        r100.append(this.arraySeparator);
    L7:
        appendDetail(r100, r101, r102[r103]);
        r103 = r103 + 1;
        goto L4
    L8:
        r100.append(this.arrayEnd);
    }

    public void appendSummary(StringBuffer r100, String r101, long[] r102) {
        appendSummarySize(r100, r101, r102.length);
    }

    public void append(StringBuffer r100, String r101, boolean r102) {
        appendFieldStart(r100, r101);
        appendDetail(r100, r101, r102);
        appendFieldEnd(r100, r101);
    }

    public void appendDetail(StringBuffer r100, String r101, short[] r102) {
        r100.append(this.arrayStart);
        int r103 = 0;
    L4:
        if (r103 >= r102.length) goto L8;
        if (r103 <= 0) goto L7;
        r100.append(this.arraySeparator);
    L7:
        appendDetail(r100, r101, r102[r103]);
        r103 = r103 + 1;
        goto L4
    L8:
        r100.append(this.arrayEnd);
    }

    public void appendSummary(StringBuffer r100, String r101, Object[] r102) {
        appendSummarySize(r100, r101, r102.length);
    }

    public void appendDetail(StringBuffer r100, String r101, boolean[] r102) {
        r100.append(this.arrayStart);
        int r103 = 0;
    L4:
        if (r103 >= r102.length) goto L8;
        if (r103 <= 0) goto L7;
        r100.append(this.arraySeparator);
    L7:
        appendDetail(r100, r101, r102[r103]);
        r103 = r103 + 1;
        goto L4
    L8:
        r100.append(this.arrayEnd);
    }

    public void appendSummary(StringBuffer r100, String r101, short[] r102) {
        appendSummarySize(r100, r101, r102.length);
    }

    public void appendDetail(StringBuffer r100, String r101, byte r102) {
        r100.append(r102);
    }

    public void appendSummary(StringBuffer r100, String r101, boolean[] r102) {
        appendSummarySize(r100, r101, r102.length);
    }

    public void appendDetail(StringBuffer r100, String r101, char r102) {
        r100.append(r102);
    }

    public void appendDetail(StringBuffer r100, String r101, double r102) {
        r100.append(r102);
    }

    public void appendDetail(StringBuffer r100, String r101, float r102) {
        r100.append(r102);
    }

    public void appendDetail(StringBuffer r100, String r101, int r102) {
        r100.append(r102);
    }

    public void appendDetail(StringBuffer r100, String r101, long r102) {
        r100.append(r102);
    }

    public void appendDetail(StringBuffer r100, String r101, Object r102) {
        r100.append(r102);
    }

    public void appendDetail(StringBuffer r100, String r101, Collection<?> r102) {
        r100.append(r102);
    }

    public void appendDetail(StringBuffer r100, String r101, Map<?, ?> r102) {
        r100.append(r102);
    }

    public void appendDetail(StringBuffer r100, String r101, short r102) {
        r100.append(r102);
    }

    public void appendDetail(StringBuffer r100, String r101, boolean r102) {
        r100.append(r102);
    }

    public void append(StringBuffer r100, String r101, byte[] r102, Boolean r103) {
        appendFieldStart(r100, r101);
        if (r102 != null) goto L6;
        appendNullText(r100, r101);
    L9:
        appendFieldEnd(r100, r101);
        return;
    L6:
        if (isFullDetail(r103) == false) goto L8;
        appendDetail(r100, r101, r102);
        goto L9
    L8:
        appendSummary(r100, r101, r102);
        goto L9
    }

    public void appendInternal(StringBuffer r100, String r101, Object r102, boolean r103) {
        if (isRegistered(r102) == true) goto L5;
    L12:
        register(r102);
    L73:
        th = move-exception;
        unregister(r102);
        throw th;
    L14:
        if ((r102 instanceof Collection) == false) goto L19;
        if (r103 == false) goto L17;
        appendDetail(r100, r101, (Collection) r102);     // Catch: Throwable -> L73
    L71:
        unregister(r102);
        return;
    L17:
        appendSummarySize(r100, r101, ((Collection) r102).size());     // Catch: Throwable -> L73
        goto L71
    L19:
        if ((r102 instanceof Map) == false) goto L24;
        if (r103 == false) goto L22;
        appendDetail(r100, r101, (Map) r102);     // Catch: Throwable -> L73
        goto L71
    L22:
        appendSummarySize(r100, r101, ((Map) r102).size());     // Catch: Throwable -> L73
        goto L71
    L24:
        if ((r102 instanceof long[]) == false) goto L29;
        if (r103 == false) goto L27;
        appendDetail(r100, r101, (long[]) r102);     // Catch: Throwable -> L73
        goto L71
    L27:
        appendSummary(r100, r101, (long[]) r102);     // Catch: Throwable -> L73
        goto L71
    L29:
        if ((r102 instanceof int[]) == false) goto L34;
        if (r103 == false) goto L32;
        appendDetail(r100, r101, (int[]) r102);     // Catch: Throwable -> L73
        goto L71
    L32:
        appendSummary(r100, r101, (int[]) r102);     // Catch: Throwable -> L73
        goto L71
    L34:
        if ((r102 instanceof short[]) == false) goto L39;
        if (r103 == false) goto L37;
        appendDetail(r100, r101, (short[]) r102);     // Catch: Throwable -> L73
        goto L71
    L37:
        appendSummary(r100, r101, (short[]) r102);     // Catch: Throwable -> L73
        goto L71
    L39:
        if ((r102 instanceof byte[]) == false) goto L44;
        if (r103 == false) goto L42;
        appendDetail(r100, r101, (byte[]) r102);     // Catch: Throwable -> L73
        goto L71
    L42:
        appendSummary(r100, r101, (byte[]) r102);     // Catch: Throwable -> L73
        goto L71
    L44:
        if ((r102 instanceof char[]) == false) goto L49;
        if (r103 == false) goto L47;
        appendDetail(r100, r101, (char[]) r102);     // Catch: Throwable -> L73
        goto L71
    L47:
        appendSummary(r100, r101, (char[]) r102);     // Catch: Throwable -> L73
        goto L71
    L49:
        if ((r102 instanceof double[]) == false) goto L54;
        if (r103 == false) goto L52;
        appendDetail(r100, r101, (double[]) r102);     // Catch: Throwable -> L73
        goto L71
    L52:
        appendSummary(r100, r101, (double[]) r102);     // Catch: Throwable -> L73
        goto L71
    L54:
        if ((r102 instanceof float[]) == false) goto L59;
        if (r103 == false) goto L57;
        appendDetail(r100, r101, (float[]) r102);     // Catch: Throwable -> L73
        goto L71
    L57:
        appendSummary(r100, r101, (float[]) r102);     // Catch: Throwable -> L73
        goto L71
    L59:
        if ((r102 instanceof boolean[]) == false) goto L64;
        if (r103 == false) goto L62;
        appendDetail(r100, r101, (boolean[]) r102);     // Catch: Throwable -> L73
        goto L71
    L62:
        appendSummary(r100, r101, (boolean[]) r102);     // Catch: Throwable -> L73
        goto L71
    L64:
        if (r102.getClass().isArray() == false) goto L68;
        if (r103 == false) goto L67;
        appendDetail(r100, r101, (Object[]) r102);     // Catch: Throwable -> L73
        goto L71
    L67:
        appendSummary(r100, r101, (Object[]) r102);     // Catch: Throwable -> L73
        goto L71
    L68:
        if (r103 == false) goto L70;
        appendDetail(r100, r101, r102);     // Catch: Throwable -> L73
        goto L71
    L70:
        appendSummary(r100, r101, r102);     // Catch: Throwable -> L73
        goto L71
    L5:
        if ((r102 instanceof Number) == true) goto L12;
        if ((r102 instanceof Boolean) == true) goto L12;
        if ((r102 instanceof Character) == true) goto L12;
        appendCyclicObject(r100, r101, r102);
    }

    public void append(StringBuffer r100, String r101, char[] r102, Boolean r103) {
        appendFieldStart(r100, r101);
        if (r102 != null) goto L6;
        appendNullText(r100, r101);
    L9:
        appendFieldEnd(r100, r101);
        return;
    L6:
        if (isFullDetail(r103) == false) goto L8;
        appendDetail(r100, r101, r102);
        goto L9
    L8:
        appendSummary(r100, r101, r102);
        goto L9
    }

    public void append(StringBuffer r100, String r101, double[] r102, Boolean r103) {
        appendFieldStart(r100, r101);
        if (r102 != null) goto L6;
        appendNullText(r100, r101);
    L9:
        appendFieldEnd(r100, r101);
        return;
    L6:
        if (isFullDetail(r103) == false) goto L8;
        appendDetail(r100, r101, r102);
        goto L9
    L8:
        appendSummary(r100, r101, r102);
        goto L9
    }

    public void append(StringBuffer r100, String r101, float[] r102, Boolean r103) {
        appendFieldStart(r100, r101);
        if (r102 != null) goto L6;
        appendNullText(r100, r101);
    L9:
        appendFieldEnd(r100, r101);
        return;
    L6:
        if (isFullDetail(r103) == false) goto L8;
        appendDetail(r100, r101, r102);
        goto L9
    L8:
        appendSummary(r100, r101, r102);
        goto L9
    }

    public void append(StringBuffer r100, String r101, int[] r102, Boolean r103) {
        appendFieldStart(r100, r101);
        if (r102 != null) goto L6;
        appendNullText(r100, r101);
    L9:
        appendFieldEnd(r100, r101);
        return;
    L6:
        if (isFullDetail(r103) == false) goto L8;
        appendDetail(r100, r101, r102);
        goto L9
    L8:
        appendSummary(r100, r101, r102);
        goto L9
    }

    public void append(StringBuffer r100, String r101, long[] r102, Boolean r103) {
        appendFieldStart(r100, r101);
        if (r102 != null) goto L6;
        appendNullText(r100, r101);
    L9:
        appendFieldEnd(r100, r101);
        return;
    L6:
        if (isFullDetail(r103) == false) goto L8;
        appendDetail(r100, r101, r102);
        goto L9
    L8:
        appendSummary(r100, r101, r102);
        goto L9
    }

    public void append(StringBuffer r100, String r101, Object[] r102, Boolean r103) {
        appendFieldStart(r100, r101);
        if (r102 != null) goto L6;
        appendNullText(r100, r101);
    L9:
        appendFieldEnd(r100, r101);
        return;
    L6:
        if (isFullDetail(r103) == false) goto L8;
        appendDetail(r100, r101, r102);
        goto L9
    L8:
        appendSummary(r100, r101, r102);
        goto L9
    }

    public void append(StringBuffer r100, String r101, short[] r102, Boolean r103) {
        appendFieldStart(r100, r101);
        if (r102 != null) goto L6;
        appendNullText(r100, r101);
    L9:
        appendFieldEnd(r100, r101);
        return;
    L6:
        if (isFullDetail(r103) == false) goto L8;
        appendDetail(r100, r101, r102);
        goto L9
    L8:
        appendSummary(r100, r101, r102);
        goto L9
    }

    public void append(StringBuffer r100, String r101, boolean[] r102, Boolean r103) {
        appendFieldStart(r100, r101);
        if (r102 != null) goto L6;
        appendNullText(r100, r101);
    L9:
        appendFieldEnd(r100, r101);
        return;
    L6:
        if (isFullDetail(r103) == false) goto L8;
        appendDetail(r100, r101, r102);
        goto L9
    L8:
        appendSummary(r100, r101, r102);
        goto L9
    }

    public void append(StringBuffer r100, String r101, Object r102, Boolean r103) {
        appendFieldStart(r100, r101);
        if (r102 != null) goto L5;
        appendNullText(r100, r101);
    L6:
        appendFieldEnd(r100, r101);
        return;
    L5:
        appendInternal(r100, r101, r102, isFullDetail(r103));
        goto L6
    }
}
