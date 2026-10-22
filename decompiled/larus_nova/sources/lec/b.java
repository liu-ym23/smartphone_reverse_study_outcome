package lec;

import android.text.Layout;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.codeblock.process.CodeBlockV2ProcessParams;
import com.ss.android.lark.widget.span.PrefixSpanStyle;
import java.util.HashMap;
import java.util.Objects;

/* JADX INFO: loaded from: classes38.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f508982a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f508983b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f508984c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f508985d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f508986e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f508987f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f508988g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f508989h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f508990i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final CodeBlockV2ProcessParams f508991j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f508992k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f508993l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f508994m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f508995n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f508996o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final PrefixSpanStyle f508997p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final HashMap<String, HashMap<Integer, Layout>> f508998q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final HashMap<String, HashMap<Integer, Layout>> f508999r;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f509000a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f509001b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f509002c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f509003d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f509004e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f509005f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f509006g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f509007h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f509008i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f509009j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f509010k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f509011l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public PrefixSpanStyle f509012m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final int f509013n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f509014o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public CodeBlockV2ProcessParams f509015p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public HashMap<String, HashMap<Integer, Layout>> f509016q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public HashMap<String, HashMap<Integer, Layout>> f509017r;

        public a() {
            this.f509000a = true;
            this.f509001b = true;
            this.f509002c = false;
            this.f509003d = false;
            this.f509004e = false;
            this.f509005f = true;
            this.f509006g = true;
            this.f509007h = 0;
            this.f509008i = false;
            this.f509009j = 0;
            this.f509010k = false;
            this.f509011l = UIHelper.dp2px(5.0f);
            this.f509012m = PrefixSpanStyle.NORMAL;
            this.f509013n = UIHelper.getColor(R.color.bg_body);
            this.f509014o = true;
            this.f509015p = null;
            this.f509016q = null;
            this.f509017r = null;
        }
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{Boolean.valueOf(this.f508982a), Boolean.valueOf(this.f508983b), Boolean.valueOf(this.f508985d), Boolean.valueOf(this.f508984c), Integer.valueOf(this.f508986e), Boolean.valueOf(this.f508989h), "", Boolean.valueOf(this.f508992k), this.f508991j, Boolean.valueOf(this.f508995n), Boolean.valueOf(this.f508993l), Boolean.valueOf(this.f508994m), this.f508998q, this.f508999r, Boolean.FALSE});
    }

    public b(a r100) {
        this.f508982a = r100.f509001b;
        this.f508983b = r100.f509002c;
        this.f508985d = r100.f509004e;
        this.f508986e = r100.f509007h;
        this.f508987f = r100.f509008i;
        this.f508988g = r100.f509009j;
        this.f508984c = r100.f509003d;
        this.f508989h = r100.f509010k;
        this.f508990i = r100.f509013n;
        this.f508991j = r100.f509015p;
        this.f508992k = r100.f509014o;
        this.f508995n = r100.f509000a;
        this.f508993l = r100.f509005f;
        this.f508994m = r100.f509006g;
        this.f508998q = r100.f509016q;
        this.f508999r = r100.f509017r;
        this.f508996o = r100.f509011l;
        this.f508997p = r100.f509012m;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L45:
        return false;
    L8:
        if (b.class != r100.getClass()) goto L45;
        b r101 = (b) r100;
        if (this.f508982a == r101.f508982a) goto L13;
    L43:
        return false;
    L13:
        if (this.f508983b != r101.f508983b) goto L43;
        if (this.f508985d != r101.f508985d) goto L43;
        if (this.f508984c != r101.f508984c) goto L43;
        if (this.f508986e != r101.f508986e) goto L43;
        if (this.f508987f != r101.f508987f) goto L43;
        if (this.f508989h != r101.f508989h) goto L43;
        if ("".equals("") == false) goto L43;
        if (this.f508992k != r101.f508992k) goto L43;
        if (this.f508995n != r101.f508995n) goto L43;
        if (this.f508991j != r101.f508991j) goto L43;
        if (this.f508993l != r101.f508993l) goto L43;
        if (this.f508994m != r101.f508994m) goto L43;
        if (this.f508998q != r101.f508998q) goto L43;
        if (this.f508999r != r101.f508999r) goto L43;
        if (this.f508996o != r101.f508996o) goto L43;
        return true;
    }
}
