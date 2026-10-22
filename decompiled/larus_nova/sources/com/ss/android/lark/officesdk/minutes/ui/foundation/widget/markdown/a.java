package com.ss.android.lark.officesdk.minutes.ui.foundation.widget.markdown;

import com.ss.android.lark.widget.span.SpanInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f435763a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<RichTextInlineTagData> f435764b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f435765c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap<Integer, C5197a> f435766d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HashMap<Integer, Integer> f435767e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final StringBuilder f435768f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List<SpanInfo> f435769g;

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.ui.foundation.widget.markdown.a$a, reason: collision with other inner class name */
    public static final class C5197a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final char f435770a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f435771b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f435772c;

        public C5197a(char r100) {
            this.f435770a = r100;
            this.f435771b = true;
        }
    }

    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sourceText");
        this.f435763a = r100;
        this.f435764b = new ArrayList();
        this.f435766d = new HashMap();
        this.f435767e = new HashMap();
        this.f435768f = new StringBuilder();
        this.f435769g = new ArrayList();
    }
}
