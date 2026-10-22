package org.jsoup.nodes;

import com.bytedance.android.ecom.arch.slice.render.SlcFlexWrap;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.mt.protector.impl.PatternProtector;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import kotlin.text.Typography;
import org.jsoup.SerializationException;

/* JADX INFO: loaded from: classes42.dex */
public final class a implements Map.Entry<String, String>, Cloneable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String[] f525916d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Pattern f525917e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Pattern f525918f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Pattern f525919g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Pattern f525920h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f525921a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public String f525922b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public b f525923c;

    static {
        f525916d = new String[]{"allowfullscreen", "async", "autofocus", "checked", "compact", "declare", "default", "defer", "disabled", "formnovalidate", "hidden", "inert", "ismap", "itemscope", BdpAppEventConstant.MULTIPLE, "muted", "nohref", "noresize", "noshade", "novalidate", SlcFlexWrap.NOWRAP, "open", "readonly", "required", "reversed", "seamless", "selected", "sortable", "truespeed", "typemustmatch"};
        f525917e = PatternProtector.compile("[a-zA-Z_:][-a-zA-Z0-9_:.]*");
        f525918f = PatternProtector.compile("[^-a-zA-Z0-9_:.]");
        f525919g = PatternProtector.compile("[^\\x00-\\x1f\\x7f-\\x9f \"'/=]+");
        f525920h = PatternProtector.compile("[\\x00-\\x1f\\x7f-\\x9f \"'/=]");
    }

    @Override // java.util.Map.Entry
    public final String getValue() {
        String r100 = this.f525922b;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        String r100 = this.f525921a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f525922b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final Object clone() throws CloneNotSupportedException {
        return (a) super.clone();
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public final String toString() {
        StringBuilder r100 = fwc.b.b();
        Document.OutputSettings r101 = new Document("").f525890k;     // Catch: IOException -> L9
        String r102 = this.f525921a;     // Catch: IOException -> L9
        String r103 = this.f525922b;     // Catch: IOException -> L9
        String r104 = a(r102, r101.f525900h);     // Catch: IOException -> L9
        if (r104 == null) goto L8;
        b(r104, r103, r100, r101);     // Catch: IOException -> L9
    L8:
        return fwc.b.g(r100);
    L9:
        e = move-exception;
        throw new SerializationException(e);
    }

    @Override // java.util.Map.Entry
    public final String getKey() {
        return this.f525921a;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(@Nullable Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L25:
        return false;
    L8:
        if (a.class != r100.getClass()) goto L25;
        a r101 = (a) r100;
        String r102 = this.f525921a;
        if (r102 == null) goto L16;
        if (r102.equals(r101.f525921a) == false) goto L17;
    L18:
        String r103 = this.f525922b;
        String r104 = r101.f525922b;
        if (r103 != null) goto L26;
        if (r104 == null) goto L27;
        return false;
    L27:
        return true;
    L26:
        return r103.equals(r104);
    L17:
        return false;
    L16:
        if (r101.f525921a == null) goto L18;
        goto L17
    }

    @Override // java.util.Map.Entry
    public final String setValue(@Nullable String r100) {
        String r101 = r100;
        String r102 = this.f525922b;
        b r103 = this.f525923c;
        if (r103 == null) goto L7;
        int r104 = r103.h(this.f525921a);
        if (r104 == (-1)) goto L7;
        r102 = this.f525923c.e(this.f525921a);
        this.f525923c.f525926c[r104] = r101;
    L7:
        this.f525922b = r101;
        if (r102 != null) goto L11;
        return "";
    L11:
        return r102;
    }

    @Nullable
    public static String a(String r100, Document.OutputSettings.Syntax r101) {
        if (r101 != Document.OutputSettings.Syntax.xml) goto L11;
        Pattern r102 = f525917e;
        if (r102.matcher(r100).matches() == true) goto L11;
        String r103 = f525918f.matcher(r100).replaceAll("");
        if (r102.matcher(r103).matches() == true) goto L9;
        return null;
    L9:
        return r103;
    L11:
        if (r101 != Document.OutputSettings.Syntax.html) goto L18;
        Pattern r104 = f525919g;
        if (r104.matcher(r100).matches() == true) goto L18;
        String r105 = f525920h.matcher(r100).replaceAll("");
        if (r104.matcher(r105).matches() == true) goto L17;
        return null;
    L17:
        return r105;
    L18:
        return r100;
    }

    public a(String r100, @Nullable String r101, @Nullable b r102) {
        ewc.b.d(r100);
        String r103 = r100.trim();
        ewc.b.b(r103);
        this.f525921a = r103;
        this.f525922b = r101;
        this.f525923c = r102;
    }

    public static void b(String r100, @Nullable String r101, Appendable r102, Document.OutputSettings r110) throws IOException {
        r102.append(r100);
        boolean r103 = false;
        if (r110.f525900h == Document.OutputSettings.Syntax.html) goto L5;
    L16:
        if (r103 == true) goto L22;
        r102.append("=\"");
        if (r101 != null) goto L20;
        r101 = "";
    L20:
        Entities.b(r102, r101, r110, true, false, false, false);
        r102.append(Typography.quote);
        return;
    L22:
        return;
    L5:
        if (r101 != null) goto L7;
    L15:
        r103 = true;
        goto L16
    L7:
        if (r101.isEmpty() == true) goto L11;
        if (r101.equalsIgnoreCase(r100) == false) goto L16;
    L11:
        if (Arrays.binarySearch(f525916d, fwc.a.a(r100)) < 0) goto L13;
        boolean r104 = true;
    L14:
        if (r104 == false) goto L16;
    L13:
        r104 = false;
        goto L14
    }
}
