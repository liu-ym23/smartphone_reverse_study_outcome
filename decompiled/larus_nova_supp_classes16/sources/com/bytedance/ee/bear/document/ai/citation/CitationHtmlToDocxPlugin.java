package com.bytedance.ee.bear.document.ai.citation;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.DocumentPluginV2;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.inline.ai.api.citation.CitationReferenceType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import vv4.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 02\u00020\u00012\u00020\u0002:\u000201B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\t\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J4\u0010\n\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u001e\u0010\u0014\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010J\u0010\u0010\u0015\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0017H\u0002J\u0018\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0017H\u0002J\u0018\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0017H\u0002J\u0017\u0010\u001c\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001d\u001a\u00020\fH\u0002¢\u0006\u0002\u0010\u001eJ\u0016\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u00102\u0006\u0010!\u001a\u00020\fH\u0002J\u0016\u0010\"\u001a\u00020#2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020 0\u0010H\u0002J.\u0010%\u001a\u00020\f2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020 0\u00102\u0006\u0010&\u001a\u00020\f2\u0006\u0010'\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\fH\u0002J\u0010\u0010(\u001a\u00020\f2\u0006\u0010)\u001a\u00020\fH\u0002J\u0010\u0010*\u001a\u00020\f2\u0006\u0010+\u001a\u00020\fH\u0002J\u0018\u0010,\u001a\u00020#2\u0006\u0010+\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0017H\u0002J\u0010\u0010-\u001a\u00020\u00172\u0006\u0010.\u001a\u00020/H\u0002¨\u00062"}, d2 = {"Lcom/bytedance/ee/bear/document/ai/citation/CitationHtmlToDocxPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPluginV2;", "Lcom/bytedance/ee/bear/document/ai/citation/HtmlToDocxRecordAbility;", "<init>", "()V", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/browser/plugin/PluginHost;", "onDetachFromHost", "processCopyAction", "html", "", "context", "Landroid/content/Context;", "copyReferences", "", "Lcom/ss/android/lark/inline/ai/api/citation/CopyReference;", "callback", "Lcom/ss/android/lark/inline/ai/api/citation/HtmlToDocxCallback;", "processCitationTags", "extractBodyContent", "findNextAnchorStart", "", "content", "startIndex", "findNextAnchorEnd", "findTagEnd", "parseCitationNumber", "innerHtml", "(Ljava/lang/String;)Ljava/lang/Integer;", "parseAttributes", "Lcom/bytedance/ee/bear/document/ai/citation/CitationHtmlToDocxPlugin$ParsedAttribute;", "source", "containsHrefAttribute", "", "attributes", "buildAnchorTag", "title", "urlType", "appendCitationClass", "classValue", "escapeAttributeValue", "value", "isHtmlEntity", "convertCitationReferenceType", "type", "Lcom/ss/android/lark/inline/ai/api/citation/CitationReferenceType;", "Companion", "ParsedAttribute", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CitationHtmlToDocxPlugin extends DocumentPluginV2 implements j {
    public static final a Companion = null;
    private static final long JSB_TIMEOUT_MS = 6000;
    public static final String JS_API_PROCESS_HTML = "window.lark.biz.util.htmlToDocxRecordHtml";
    public static final String TAG = "CitationHtmlToDocxPlugin";

    public static final class a {
        public a() {
        }
    }

    public static final class b {
        public final String a;
        public final String b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            String r1 = this.b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public final String toString() {
            return "ParsedAttribute(name=" + this.a + ", value=" + this.b + ')';
        }

        public b(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "name");
            this.a = r2;
            this.b = r3;
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[CitationReferenceType.values().length];
            r0[CitationReferenceType.Unknown.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L35:
            r0[CitationReferenceType.Doc.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L51:
            r0[CitationReferenceType.Message.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L39:
            r0[CitationReferenceType.Lingo.ordinal()] = 4;     // Catch: NoSuchFieldError -> L20
        L43:
            r0[CitationReferenceType.Helpdesk.ordinal()] = 5;     // Catch: NoSuchFieldError -> L21
        L29:
            r0[CitationReferenceType.Minutes.ordinal()] = 6;     // Catch: NoSuchFieldError -> L22
        L45:
            r0[CitationReferenceType.Outlink.ordinal()] = 7;     // Catch: NoSuchFieldError -> L23
        L47:
            r0[CitationReferenceType.Comment.ordinal()] = 8;     // Catch: NoSuchFieldError -> L24
        L37:
            r0[CitationReferenceType.Base.ordinal()] = 9;     // Catch: NoSuchFieldError -> L25
        L41:
            r0[CitationReferenceType.Sheet.ordinal()] = 10;     // Catch: NoSuchFieldError -> L26
        L31:
            r0[CitationReferenceType.Excel.ordinal()] = 11;     // Catch: NoSuchFieldError -> L27
        L33:
            r0[CitationReferenceType.Mail.ordinal()] = 12;     // Catch: NoSuchFieldError -> L28
        L15:
            a = r0;
        }
    }

    public static final class d<T> implements ValueCallback {
        public final /* synthetic */ AtomicBoolean a;
        public final /* synthetic */ Handler b;
        public final /* synthetic */ Runnable c;

        public d(AtomicBoolean r1, Handler r2, e r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // android.webkit.ValueCallback
        public final void onReceiveValue(Object r5) {
            String r6 = (String) r5;
            if (this.a.compareAndSet(false, true) == true) goto L5;
            tt5.a.k(CitationHtmlToDocxPlugin.TAG, "processCopyAction() callback received after timeout");
            return;
        L5:
            this.b.removeCallbacks(this.c);
            if (r6 != null) goto L8;
        L21:
            tt5.a.d(CitationHtmlToDocxPlugin.TAG, "processCopyAction() JSB call failed for , data is null");
            return;
        L8:
            if (TextUtils.equals("null", r6) == true) goto L21;
            Object r0 = JSON.parse(r6);     // Catch: Exception -> L18
            if (r0 == null) goto L16;
            String r1 = r0.toString();     // Catch: Exception -> L18
            if (r1 == null) goto L16;
            r6 = r1;
        L20:
            tt5.a.h(CitationHtmlToDocxPlugin.TAG, "processCopyAction() JS resultLength=" + ("<html><head><meta charset=\"utf-8\"></head>" + r6 + "</html>").length());
            return;
        L16:
            r6 = "";
        L18:
            e = move-exception;
            tt5.a.e(CitationHtmlToDocxPlugin.TAG, "processCopyAction() parse js data error", e, false);
            goto L20
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ AtomicBoolean a;

        public e(AtomicBoolean r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        L13:
            return;
        L3:
            if (this.a.compareAndSet(false, true) == false) goto L9;
            tt5.a.d(CitationHtmlToDocxPlugin.TAG, "processCopyAction() JSB timeout after 6000ms");     // Catch: Throwable -> L6
            return;
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPluginV2, com.bytedance.ee.bear.browser.plugin.BasePluginV2, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public CitationHtmlToDocxPlugin() {
    }

    private final String appendCitationClass(String r12) {
        if (StringsKt.isBlank(r12) == false) goto L5;
        return "citation";
    L5:
        List r13 = SequencesKt.toMutableList(SequencesKt.filter(StringsKt.splitToSequence$default(r12, new char[]{' ', '\n', '\t', '\r'}, false, 0, 6, null), CitationHtmlToDocxPlugin$appendCitationClass$classNames$1.INSTANCE));
        if (r13.contains("citation") == true) goto L9;
        r13.add("citation");
    L9:
        return CollectionsKt.joinToString$default(r13, " ", null, null, 0, null, null, 62, null);
    }

    private final boolean containsHrefAttribute(List<b> r6) {
        List<b> r7 = r6;
        if ((r7 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r8 = r7.iterator();
    L9:
        if (r8.hasNext() == false) goto L31;
        b r0 = (b) r8.next();
        if (StringsKt.equals(r0.a, "href", true) == false) goto L21;
        String r1 = r0.b;
        if (r1 != null) goto L15;
    L18:
        boolean r2 = true;
    L19:
        if (r2 == true) goto L21;
        boolean r3 = true;
    L22:
        if (r3 == false) goto L9;
        return true;
    L15:
        if (StringsKt.isBlank(r1) == true) goto L18;
        r2 = false;
    L21:
        r3 = false;
        goto L22
    L31:
        return false;
    L5:
        if (r7.isEmpty() == false) goto L7;
        return false;
    }

    private final int convertCitationReferenceType(CitationReferenceType r2) {
        switch(c.a[r2.ordinal()]) {
            case 1: goto L17;
            case 2: goto L29;
            case 3: goto L28;
            case 4: goto L27;
            case 5: goto L26;
            case 6: goto L25;
            case 7: goto L24;
            case 8: goto L23;
            case 9: goto L22;
            case 10: goto L21;
            case 11: goto L20;
            case 12: goto L19;
            default: goto L18;
        };
    L18:
        return DocCitationRefType.UNKNOWN.getValue();
    L19:
        return DocCitationRefType.MAIL.getValue();
    L20:
        return DocCitationRefType.EXCEL.getValue();
    L21:
        return DocCitationRefType.SHEET.getValue();
    L22:
        return DocCitationRefType.BASE.getValue();
    L23:
        return DocCitationRefType.COMMENT.getValue();
    L24:
        return DocCitationRefType.OUTLINK.getValue();
    L25:
        return DocCitationRefType.MINUTES.getValue();
    L26:
        return DocCitationRefType.HELPDESK.getValue();
    L27:
        return DocCitationRefType.LINGO.getValue();
    L28:
        return DocCitationRefType.MESSAGE.getValue();
    L29:
        return DocCitationRefType.DOC.getValue();
    L17:
        return DocCitationRefType.UNKNOWN.getValue();
    }

    private final String escapeAttributeValue(String r5) {
        int r1 = 0;
        if (r5.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return r5;
    L8:
        StringBuilder r2 = new StringBuilder(r5.length() + 8);
    L10:
        if (r1 >= r5.length()) goto L29;
        char r3 = r5.charAt(r1);
        if (r3 != '\"') goto L14;
        r2.append("&quot;");
    L27:
        r1 = r1 + 1;
        goto L10
    L14:
        if (r3 == '&') goto L23;
        if (r3 != '<') goto L18;
        r2.append("&lt;");
        goto L27
    L18:
        if (r3 == '>') goto L20;
        r2.append(r3);
        goto L27
    L20:
        r2.append("&gt;");
        goto L27
    L23:
        if (isHtmlEntity(r5, r1) == false) goto L25;
        r2.append('&');
        goto L27
    L25:
        r2.append("&amp;");
        goto L27
    L29:
        return r2.toString();
    L5:
        r0 = false;
        goto L6
    }

    private final String extractBodyContent(String r7) {
        int r0 = StringsKt.indexOf$default(r7, "<body", 0, true, 2, null);
        if (r0 >= 0) goto L5;
        return r7;
    L5:
        int r1 = findTagEnd(r7, r0 + 5);
        if (r1 < 0) goto L16;
        int r2 = r1 + 1;
        if (r2 >= r7.length()) goto L17;
        int r3 = StringsKt.indexOf(r7, "</body", r2, true);
        if (r3 >= 0) goto L15;
        return r7.substring(r2);
    L15:
        return r7.substring(r2, r3);
    L17:
        return r7;
    L16:
        return r7;
    }

    private final List<b> parseAttributes(String r7) {
        ArrayList r0 = new ArrayList();
        int r1 = 0;
    L4:
        if (r1 >= r7.length()) goto L63;
    L6:
        if (r1 >= r7.length()) goto L11;
        if (CharsKt.isWhitespace(r7.charAt(r1)) == false) goto L11;
        r1 = r1 + 1;
    L11:
        if (r1 >= r7.length()) goto L63;
        int r2 = r1;
    L15:
        if (r2 >= r7.length()) goto L21;
        if (CharsKt.isWhitespace(r7.charAt(r2)) == true) goto L21;
        if (r7.charAt(r2) == '=') goto L21;
        r2 = r2 + 1;
    L21:
        String r3 = r7.substring(r1, r2);
    L23:
        if (r2 >= r7.length()) goto L27;
        if (CharsKt.isWhitespace(r7.charAt(r2)) == false) goto L27;
        r2 = r2 + 1;
    L27:
        String r5 = null;
        if (r2 >= r7.length()) goto L60;
        if (r7.charAt(r2) != '=') goto L60;
    L31:
        r2 = r2 + 1;
        if (r2 >= r7.length()) goto L37;
        if (CharsKt.isWhitespace(r7.charAt(r2)) == true) goto L31;
    L37:
        if (r2 >= r7.length()) goto L60;
        char r4 = r7.charAt(r2);
        if (r4 != '\"') goto L41;
    L49:
        int r6 = r2 + 1;
        int r8 = r6;
    L51:
        if (r8 >= r7.length()) goto L55;
        if (r7.charAt(r8) == r4) goto L55;
        r8 = r8 + 1;
    L55:
        r5 = r7.substring(r6, r8);
        if (r8 >= r7.length()) goto L58;
        r8 = r8 + 1;
    L58:
        r2 = r8;
        goto L60
    L41:
        if (r4 == '\'') goto L49;
        int r9 = r2;
    L44:
        if (r9 >= r7.length()) goto L48;
        if (CharsKt.isWhitespace(r7.charAt(r9)) == true) goto L48;
        r9 = r9 + 1;
    L48:
        r5 = r7.substring(r2, r9);
        r2 = r9;
    L60:
        if ((!StringsKt.isBlank(r3)) == false) goto L62;
        r0.add(new b(r3, r5));
    L62:
        r1 = r2;
    L63:
        return r0;
    }

    private final Integer parseCitationNumber(String r7) {
        String r8 = StringsKt.trim(r7).toString();
        if (r8.length() >= 3) goto L5;
    L26:
        return null;
    L5:
        if (StringsKt.first(r8) != '[') goto L26;
        if (StringsKt.last(r8) != ']') goto L26;
        boolean r0 = false;
        int r1 = 0;
    L11:
        if (r1 >= r8.length()) goto L22;
        char r3 = r8.charAt(r1);
        if (r3 != '<') goto L15;
    L18:
        boolean r4 = true;
    L19:
        if (r4 == true) goto L20;
        r1 = r1 + 1;
        goto L11
    L20:
        r0 = true;
        goto L22
    L15:
        if (r3 == '>') goto L18;
        r4 = false;
    L22:
        if (r0 == false) goto L25;
        return null;
    L25:
        return StringsKt.toIntOrNull(r8.substring(1, r8.length() - 1));
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onAttachToHost(PluginHost r2) {
        super.onAttachToHost(r2);
        if (r2 == null) goto L5;
        r2.registerHostAbility(this);
    L5:
        tt5.a.h(TAG, "HtmlToDocxPlugin registered to host ability, record: " + this);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public void onDetachFromHost(PluginHost r2) {
        super.onDetachFromHost(r2);
        tt5.a.h(TAG, "HtmlToDocxPlugin detached from host, record: " + this);
    }

    private final int findNextAnchorEnd(String r4, int r5) {
    L3:
        if (r5 >= (r4.length() - 3)) goto L20;
        if (r4.charAt(r5) != '<') goto L19;
        if (r4.charAt(r5 + 1) != '/') goto L19;
        int r0 = r5 + 2;
        if (r4.charAt(r0) != 'a') goto L11;
    L12:
        Character r1 = StringsKt.getOrNull(r4, r5 + 3);
        if (r1 == null) goto L18;
        if (CharsKt.isWhitespace(r1.charValue()) == true) goto L18;
        if (r1.charValue() != '>') goto L19;
    L18:
        return r5;
    L11:
        if (r4.charAt(r0) == 'A') goto L12;
    L19:
        r5 = r5 + 1;
        goto L3
    L20:
        return -1;
    }

    private final int findNextAnchorStart(String r4, int r5) {
    L3:
        if (r5 >= (r4.length() - 1)) goto L18;
        if (r4.charAt(r5) != '<') goto L17;
        int r0 = r5 + 1;
        if (r4.charAt(r0) != 'a') goto L9;
    L10:
        Character r1 = StringsKt.getOrNull(r4, r5 + 2);
        if (r1 == null) goto L16;
        if (CharsKt.isWhitespace(r1.charValue()) == true) goto L16;
        if (r1.charValue() != '>') goto L17;
    L16:
        return r5;
    L9:
        if (r4.charAt(r0) == 'A') goto L10;
    L17:
        r5 = r5 + 1;
        goto L3
    L18:
        return -1;
    }

    private final int findTagEnd(String r5, int r6) {
        Character r1 = null;
    L4:
        if (r6 >= r5.length()) goto L20;
        char r2 = r5.charAt(r6);
        if (r1 != null) goto L17;
        if (r2 != '\"') goto L10;
    L15:
        r1 = Character.valueOf(r2);
    L19:
        r6 = r6 + 1;
        goto L4
    L10:
        if (r2 == '\'') goto L15;
        if (r2 != '>') goto L19;
        return r6;
    L17:
        if (r2 != r1.charValue()) goto L19;
        r1 = null;
        goto L19
    L20:
        return -1;
    }

    private final boolean isHtmlEntity(String r6, int r7) {
        int r0 = r7 + 1;
        if (r0 < r6.length()) goto L6;
        return false;
    L6:
        if (r6.charAt(r0) != '#') goto L14;
        r0 = r0 + 1;
        if (r0 >= r6.length()) goto L14;
        if (r6.charAt(r0) != 'x') goto L12;
    L13:
        r0 = r0 + 1;
        goto L14
    L12:
        if (r6.charAt(r0) == 'X') goto L13;
    L14:
        int r1 = r0;
    L16:
        if (r1 >= r6.length()) goto L28;
        if ((r1 - r7) > 10) goto L28;
        char r3 = r6.charAt(r1);
        if (r3 == ';') goto L21;
        if (Character.isLetterOrDigit(r3) == false) goto L26;
        r1 = r1 + 1;
        goto L16
    L26:
        return false;
    L21:
        if (r1 <= r0) goto L33;
        return true;
    L33:
        return false;
    L28:
        return false;
    }

    public final String processCitationTags(String r21, List<ulb.a> r22) {
        Intrinsics.checkNotNullParameter(r21, "html");
        if (StringsKt.isBlank(r21) == false) goto L54;
        return r21;
    L54:
        String r11 = extractBodyContent(r21);     // Catch: Exception -> L51
        StringBuilder r12 = new StringBuilder(r11.length() + 64);     // Catch: Exception -> L51
        int r5 = 0;
        int r13 = 0;
    L7:
        if (r5 >= r11.length()) goto L49;
        int r14 = findNextAnchorStart(r11, r5);     // Catch: Exception -> L51
        if (r14 < 0) goto L10;
        r12.append(r11, r5, r14);     // Catch: Exception -> L51
        int r16 = r14 + 2;     // Catch: Exception -> L51
        int r10 = findTagEnd(r11, r16);     // Catch: Exception -> L51
        if (r10 < 0) goto L13;
        int r9 = r10 + 1;     // Catch: Exception -> L51
        int r8 = findNextAnchorEnd(r11, r9);     // Catch: Exception -> L51
        if (r8 < 0) goto L16;
        int r6 = StringsKt.indexOf$default(r11, '>', r8, false, 4, null);     // Catch: Exception -> L51
        if (r6 < 0) goto L19;
        String r2 = r11.substring(r16, r10);     // Catch: Exception -> L51
        String r4 = r11.substring(r9, r8);     // Catch: Exception -> L51
        Integer r7 = parseCitationNumber(r4);     // Catch: Exception -> L51
        r5 = r6 + 1;     // Catch: Exception -> L51
        String r17 = r11.substring(r14, r5);     // Catch: Exception -> L51
        if (r7 == null) goto L47;
        List<b> r3 = parseAttributes(r2);     // Catch: Exception -> L51
        if (containsHrefAttribute(r3) == false) goto L46;
        boolean r18 = true;
        Integer r19 = Integer.valueOf(r7.intValue() - 1);     // Catch: Exception -> L51
        int r20 = r19.intValue();     // Catch: Exception -> L51
        if (r20 < 0) goto L31;
        if (r22 == null) goto L28;
        int r23 = r22.size();     // Catch: Exception -> L51
    L29:
        if (r20 >= r23) goto L31;
    L32:
        ulb.a r24 = null;
        if (r18 == true) goto L36;
        r19 = null;
    L36:
        if (r19 == null) goto L41;
        int r26 = r19.intValue();     // Catch: Exception -> L51
        if (r22 == null) goto L41;
        r24 = (ulb.a) ListProtector.get(r22, r26);     // Catch: Exception -> L51
    L41:
        if (r24 == null) goto L44;
        CitationReferenceType r27 = r24.getType();     // Catch: Exception -> L51
        if (r27 == null) goto L44;
    L45:
        r12.append(buildAnchorTag(r3, "", convertCitationReferenceType(r27), r4));     // Catch: Exception -> L51
        r13 = r13 + 1;     // Catch: Exception -> L51
    L44:
        r27 = CitationReferenceType.Unknown;     // Catch: Exception -> L51
        goto L45
    L28:
        r23 = 0;
    L31:
        r18 = false;
        goto L32
    L46:
        r12.append(r17);     // Catch: Exception -> L51
        goto L7
    L47:
        r12.append(r17);     // Catch: Exception -> L51
        goto L7
    L19:
        r12.append(r11, r14, r11.length());     // Catch: Exception -> L51
        goto L49
    L16:
        r12.append(r11, r14, r11.length());     // Catch: Exception -> L51
        goto L49
    L13:
        r12.append(r11, r14, r11.length());     // Catch: Exception -> L51
        goto L49
    L10:
        r12.append(r11, r5, r11.length());     // Catch: Exception -> L51
    L49:
        String r0 = r12.toString();     // Catch: Exception -> L51
        tt5.a.h(TAG, "processCitationTags completed. Processed " + r13 + " citation tags");     // Catch: Exception -> L51
        return r0;
    L51:
        e = move-exception;
        tt5.a.e(TAG, "Error in processCitationTags", e, false);
        return r21;
    }

    private final String buildAnchorTag(List<b> r12, String r13, int r14, String r16) {
        ArrayList r0 = new ArrayList(r12.size() + 3);
        Iterator<T> r17 = r12.iterator();
        boolean r2 = false;
        boolean r3 = false;
        boolean r4 = false;
    L4:
        if (r17.hasNext() == false) goto L18;
        b r5 = (b) r17.next();
        if (StringsKt.equals(r5.a, "class", true) == true) goto L7;
        if (StringsKt.equals(r5.a, "title", true) == true) goto L13;
        if (StringsKt.equals(r5.a, "data-url-type", true) == true) goto L16;
        r0.add(r5);
        goto L4
    L16:
        r0.add(new b(r5.a, String.valueOf(r14)));
        r4 = true;
        goto L4
    L13:
        r0.add(new b(r5.a, r13));
        r3 = true;
        goto L4
    L7:
        String r6 = r5.a;
        String r7 = r5.b;
        if (r7 != null) goto L10;
        r7 = "";
    L10:
        r0.add(new b(r6, appendCitationClass(r7)));
        r2 = true;
        goto L4
    L18:
        if (r2 == true) goto L20;
        ListProtector.add(r0, 0, new b("class", "citation"));
    L20:
        if (r3 == true) goto L22;
        r0.add(new b("title", r13));
    L22:
        if (r4 == true) goto L24;
        r0.add(new b("data-url-type", String.valueOf(r14)));
    L24:
        StringBuilder r18 = new StringBuilder(r16.length() + 64);
        r18.append("<a");
        Iterator r19 = r0.iterator();
    L26:
        if (r19.hasNext() == false) goto L30;
        b r110 = (b) r19.next();
        r18.append(' ');
        r18.append(r110.a);
        String r111 = r110.b;
        if (r111 == null) goto L26;
        r18.append("=\"");
        r18.append(escapeAttributeValue(r111));
        r18.append('\"');
        goto L26
    L30:
        r18.append('>');
        r18.append(r16);
        r18.append("</a>");
        return r18.toString();
    }

    public void processCopyAction(String r7, Context r8, List<ulb.a> r9, ulb.b r10) {
        Intrinsics.checkNotNullParameter(r8, "context");
    L28:
        e = move-exception;
        tt5.a.e(TAG, "Error in processCopyAction", e, false);
        if (r10 == null) goto L37;
        e.getMessage();
        r10.a();
        return;
    L37:
        return;
    L4:
        if (com.bytedance.ee.bear.appsetting.c.a.a.h("ccm.ai.citation_block") == true) goto L8;
        if (r10 == null) goto L34;
        r10.a();     // Catch: Exception -> L28
        return;
    L34:
        return;
    L8:
        StringBuilder r2 = new StringBuilder("processCopyAction() called wit htmlLength=");     // Catch: Exception -> L28
        if (r7 == null) goto L11;
        Integer r1 = Integer.valueOf(r7.length());     // Catch: Exception -> L28
    L12:
        r2.append(r1);     // Catch: Exception -> L28
        tt5.a.h(TAG, r2.toString());     // Catch: Exception -> L28
        if (r7 != null) goto L15;
    L18:
        boolean r3 = true;
    L19:
        if (r3 == false) goto L24;
        tt5.a.d(TAG, "processCopyAction() HTML content is empty");     // Catch: Exception -> L28
        if (r10 == null) goto L35;
        r10.a();     // Catch: Exception -> L28
        return;
    L35:
        return;
    L24:
        String r11 = processCitationTags(r7, r9);     // Catch: Exception -> L28
        JSONObject r12 = new JSONObject();     // Catch: Exception -> L28
        r12.put("html", r11);     // Catch: Exception -> L28
        AtomicBoolean r13 = new AtomicBoolean(false);     // Catch: Exception -> L28
        Handler r4 = new Handler(Looper.getMainLooper());     // Catch: Exception -> L28
        e r5 = new e(r13);     // Catch: Exception -> L28
        r4.postDelayed(r5, JSB_TIMEOUT_MS);     // Catch: Exception -> L28
        k r6 = getWebOrNull();     // Catch: Exception -> L28
        if (r6 == null) goto L36;
        r6.a(JS_API_PROCESS_HTML, r12, new d(r13, r4, r5));     // Catch: Exception -> L28
        return;
    L36:
        return;
    L15:
        if (r7.length() == 0) goto L18;
        r3 = false;
        goto L19
    L11:
        r1 = null;
        goto L12
    }
}
