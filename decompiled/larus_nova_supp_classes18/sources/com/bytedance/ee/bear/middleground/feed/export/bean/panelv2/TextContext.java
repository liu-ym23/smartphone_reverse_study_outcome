package com.bytedance.ee.bear.middleground.feed.export.bean.panelv2;

import android.text.TextUtils;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u0000 \u001e2\u00020\u0001:\u0003\u001c\u001d\u001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0015\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0096\u0002J\b\u0010\u001b\u001a\u00020\u000bH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000bX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ee/bear/middleground/feed/export/bean/panelv2/TextContext;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "text", "", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "textType", "", "getTextType", "()I", "i18nDatas", "", "Lcom/bytedance/ee/bear/middleground/feed/export/bean/panelv2/TextContext$I18nData;", "getI18nDatas", "()Ljava/util/List;", "style", "getStyle", "getStyleInt", "()Ljava/lang/Integer;", "equals", "", "other", "", "hashCode", "I18nData", "ReplaceInfo", "Companion", "middleground-feed-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TextContext implements NonProguard {
    public static final a Companion = null;
    public static final int I18N_TYPE_1 = 1;
    public static final int I18N_TYPE_2 = 2;
    private static final String STYLE_BOLD = null;
    public static final int TEXT_TYPE_NORMAL_TEXT = 1;
    public static final int TEXT_TYPE_RICH_TEXT = 2;
    private final List<I18nData> i18nDatas;
    private final List<String> style;
    private String text;
    private final int textType;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0096\u0002J\b\u0010\u001c\u001a\u00020\u0015H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR\u0014\u0010\u0014\u001a\u00020\u0015X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001d"}, d2 = {"Lcom/bytedance/ee/bear/middleground/feed/export/bean/panelv2/TextContext$I18nData;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "key", "", "getKey", "()Ljava/lang/String;", "setKey", "(Ljava/lang/String;)V", "replaceMap", "", "Lcom/bytedance/ee/bear/middleground/feed/export/bean/panelv2/TextContext$ReplaceInfo;", "getReplaceMap", "()Ljava/util/List;", "setReplaceMap", "(Ljava/util/List;)V", "lang", "getLang", "setLang", ResourceData.KEY_TYPE, "", "getType", "()I", "equals", "", "other", "", "hashCode", "middleground-feed-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class I18nData implements NonProguard {
        private String key;
        private String lang;
        private List<ReplaceInfo> replaceMap;
        private final int type;

        public int hashCode() {
            int r0 = this.key.hashCode() * 31;
            List<ReplaceInfo> r1 = this.replaceMap;
            int r2 = 0;
            if (r1 == null) goto L5;
            int r3 = r1.hashCode();
        L6:
            int r4 = (r0 + r3) * 31;
            String r5 = this.lang;
            if (r5 == null) goto L10;
            r2 = r5.hashCode();
        L10:
            return ((r4 + r2) * 31) + this.type;
        L5:
            r3 = 0;
            goto L6
        }

        public I18nData() {
            this.key = "";
            this.type = 1;
        }

        public final String getKey() {
            return this.key;
        }

        public final String getLang() {
            return this.lang;
        }

        public final List<ReplaceInfo> getReplaceMap() {
            return this.replaceMap;
        }

        public final int getType() {
            return this.type;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (r5 == null) goto L8;
            Class<?> r2 = r5.getClass();
        L10:
            if (Intrinsics.areEqual(I18nData.class, r2) == true) goto L12;
            return false;
        L12:
            Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.TextContext.I18nData");
            I18nData r6 = (I18nData) r5;
            if (Intrinsics.areEqual(this.key, r6.key) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.replaceMap, r6.replaceMap) == true) goto L19;
            return false;
        L19:
            if (Intrinsics.areEqual(this.lang, r6.lang) == true) goto L22;
            return false;
        L22:
            if (this.type == r6.type) goto L24;
            return false;
        L24:
            return true;
        L8:
            r2 = null;
            goto L10
        }

        public final void setKey(String r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.key = r2;
        }

        public final void setLang(String r1) {
            this.lang = r1;
        }

        public final void setReplaceMap(List<ReplaceInfo> r1) {
            this.replaceMap = r1;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0096\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/middleground/feed/export/bean/panelv2/TextContext$ReplaceInfo;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "key", "", "getKey", "()Ljava/lang/String;", "value", "getValue", "equals", "", "other", "", "hashCode", "", "middleground-feed-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ReplaceInfo implements NonProguard {
        private final String key;
        private final String value;

        public int hashCode() {
            return (this.key.hashCode() * 31) + this.value.hashCode();
        }

        public ReplaceInfo() {
            this.key = "";
            this.value = "";
        }

        public final String getKey() {
            return this.key;
        }

        public final String getValue() {
            return this.value;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (r5 == null) goto L8;
            Class<?> r2 = r5.getClass();
        L10:
            if (Intrinsics.areEqual(ReplaceInfo.class, r2) == true) goto L12;
            return false;
        L12:
            Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.TextContext.ReplaceInfo");
            ReplaceInfo r6 = (ReplaceInfo) r5;
            if (Intrinsics.areEqual(this.key, r6.key) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.value, r6.value) == true) goto L18;
            return false;
        L18:
            return true;
        L8:
            r2 = null;
            goto L10
        }
    }

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
        STYLE_BOLD = "Bold";
    }

    public final Integer getStyleInt() {
        List<String> r0 = this.style;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return null;
    L11:
        if (TextUtils.equals((CharSequence) ListProtector.get(this.style, 0), STYLE_BOLD) == true) goto L13;
        return null;
    L13:
        return 1;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    public int hashCode() {
        int r0 = ((this.text.hashCode() * 31) + this.textType) * 31;
        List<I18nData> r1 = this.i18nDatas;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (r0 + r3) * 31;
        List<String> r5 = this.style;
        if (r5 == null) goto L10;
        r2 = r5.hashCode();
    L10:
        return r4 + r2;
    L5:
        r3 = 0;
        goto L6
    }

    public TextContext() {
        this.text = "";
        this.textType = 1;
    }

    public static final /* synthetic */ String access$getSTYLE_BOLD$cp() {
        return STYLE_BOLD;
    }

    public final List<I18nData> getI18nDatas() {
        return this.i18nDatas;
    }

    public final List<String> getStyle() {
        return this.style;
    }

    public final String getText() {
        return this.text;
    }

    public final int getTextType() {
        return this.textType;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 == null) goto L8;
        Class<?> r2 = r5.getClass();
    L10:
        if (Intrinsics.areEqual(TextContext.class, r2) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.bytedance.ee.bear.middleground.feed.export.bean.panelv2.TextContext");
        TextContext r6 = (TextContext) r5;
        if (Intrinsics.areEqual(this.text, r6.text) == true) goto L16;
        return false;
    L16:
        if (this.textType == r6.textType) goto L19;
        return false;
    L19:
        if (Intrinsics.areEqual(this.i18nDatas, r6.i18nDatas) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.style, r6.style) == true) goto L24;
        return false;
    L24:
        return true;
    L8:
        r2 = null;
        goto L10
    }

    public final void setText(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.text = r2;
    }
}
