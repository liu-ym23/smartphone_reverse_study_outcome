package com.bytedance.frameworks.baselib.netx.partner.mutable;

import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes19.dex */
public final class MutableUrl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f244831a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f244832b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f244833c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f244834d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f244835e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final d f244836f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final e f244837g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f244838h;

    public static final enum ParseResult extends Enum<ParseResult> {
        public static final ParseResult INVALID_HOST = null;
        public static final ParseResult INVALID_PORT = null;
        public static final ParseResult MISSING_SCHEME = null;
        public static final ParseResult SUCCESS = null;
        public static final ParseResult UNSUPPORTED_SCHEME = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ParseResult[] f244839a = null;

        static {
            ParseResult r100 = new ParseResult("SUCCESS", 0);
            SUCCESS = r100;
            ParseResult r101 = new ParseResult("MISSING_SCHEME", 1);
            MISSING_SCHEME = r101;
            ParseResult r102 = new ParseResult("UNSUPPORTED_SCHEME", 2);
            UNSUPPORTED_SCHEME = r102;
            ParseResult r103 = new ParseResult("INVALID_PORT", 3);
            INVALID_PORT = r103;
            ParseResult r104 = new ParseResult("INVALID_HOST", 4);
            INVALID_HOST = r104;
            f244839a = new ParseResult[]{r100, r101, r102, r103, r104};
        }

        public static ParseResult[] values() {
            return (ParseResult[]) f244839a.clone();
        }

        public static ParseResult valueOf(String r100) {
            return (ParseResult) r27.a.a(ParseResult.class, r100);
        }

        public ParseResult(String r100, int r101) {
            super(r100, r101);
        }
    }

    public final String a() {
        if ("http".equals(this.f244831a) == false) goto L5;
        return "http";
    L5:
        return "https";
    }

    public final String b() {
        StringBuilder r100 = new StringBuilder();
        r100.append(a());
        r100.append("://");
        if (this.f244832b.isEmpty() == false) goto L7;
        if (this.f244833c.isEmpty() == false) goto L7;
    L19:
        if (this.f244834d.indexOf(58) == (-1)) goto L21;
        r100.append('[');
        r100.append(this.f244834d);
        r100.append(']');
    L22:
        int r101 = this.f244835e;
        if (r101 != (-1)) goto L27;
        r101 = HttpUrl.defaultPort(a());
    L27:
        if (r101 == HttpUrl.defaultPort(a())) goto L29;
        r100.append(':');
        r100.append(r101);
    L29:
        d r102 = this.f244836f;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        int r103 = ((ArrayList) r102.f244844a).size();
        int r104 = 0;
    L30:
        if (r104 >= r103) goto L32;
        r100.append('/');
        String r110 = (String) ListProtector.get(r102.f244844a, r104);
        r100.append(a.a(r110, 0, r110.length(), " \"<>^`{}|/\\?#", false, false, true));
        r104 = r104 + 1;
        goto L30
    L32:
        e r105 = this.f244837g;
        r105.getClass();
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        r100.append('?');
        Iterator r106 = ((LinkedHashMap) r105.f244845a).entrySet().iterator();
    L34:
        if (r106.hasNext() == false) goto L42;
        Map.Entry r107 = (Map.Entry) r106.next();
        String r108 = (String) r107.getKey();
        List r109 = (List) r107.getValue();
        String r111 = a.b(r108, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", true, true);
        Iterator r112 = r109.iterator();
    L37:
        if (r112.hasNext() == false) goto L34;
        String r113 = (String) r112.next();
        r100.append(r111);
        if (r113 == null) goto L41;
        r100.append(com.alipay.sdk.m.n.a.f25612h);
        r100.append(a.b(r113, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", true, true));
    L41:
        r100.append(Typography.amp);
        goto L37
    L42:
        r100.setLength(r100.length() - 1);
        if (this.f244838h == null) goto L46;
        r100.append('#');
        r100.append(a.b(this.f244838h, "", false, false));
    L46:
        return r100.toString();
    L21:
        r100.append(this.f244834d);
    L7:
        if (this.f244832b.isEmpty() == false) goto L9;
        String r114 = "";
    L10:
        r100.append(r114);
        if (this.f244833c.isEmpty() == false) goto L13;
        String r115 = "";
    L15:
        if (r115.isEmpty() == true) goto L17;
        r100.append(':');
        r100.append(r115);
    L17:
        r100.append('@');
        goto L19
    L13:
        r115 = a.b(this.f244833c, " \"':;<=>@[]^`{}|/\\?#", false, true);
        goto L15
    L9:
        r114 = a.b(this.f244832b, " \"':;<=>@[]^`{}|/\\?#", false, true);
        goto L10
    }

    public MutableUrl() {
        this.f244832b = "";
        this.f244833c = "";
        this.f244835e = -1;
        this.f244836f = new d();
        this.f244837g = new e();
    }

    public final String toString() {
        return b();
    }
}
