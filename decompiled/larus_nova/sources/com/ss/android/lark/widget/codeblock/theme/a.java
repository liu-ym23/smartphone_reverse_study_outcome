package com.ss.android.lark.widget.codeblock.theme;

import com.ss.android.lark.widget.codeblock.entity.LineContent;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f445722a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f445723b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map<LineContent.ContentType, C5390a> f445724c;

    /* JADX INFO: renamed from: com.ss.android.lark.widget.codeblock.theme.a$a, reason: collision with other inner class name */
    public static final class C5390a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f445725a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f445726b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Map<String, String> f445727c;

        public C5390a() {
            int r100 = 0;
            this(r100, r100, 7);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C5390a) == true) goto L8;
            return false;
        L8:
            C5390a r101 = (C5390a) r100;
            if (this.f445725a == r101.f445725a) goto L12;
            return false;
        L12:
            if (this.f445726b == r101.f445726b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f445727c, r101.f445727c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f445725a * 31) + this.f445726b) * 31;
            Map<String, String> r101 = this.f445727c;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "ContentTypeStyle(lightColor=" + this.f445725a + ", darkColor=" + this.f445726b + ", style=" + this.f445727c + ')';
        }

        public /* synthetic */ C5390a(int r100, int r101, int r102) {
            if ((r102 & 1) == 0) goto L6;
            r100 = -13947082;
        L6:
            if ((r102 & 2) == 0) goto L8;
            r101 = -1513240;
        L8:
            this(r100, r101, null);
        }

        public C5390a(int r100, int r101, Map<String, String> r102) {
            this.f445725a = r100;
            this.f445726b = r101;
            this.f445727c = r102;
        }
    }

    public a() {
        this.f445722a = -1;
        this.f445723b = -15066598;
        this.f445724c = new LinkedHashMap();
    }
}
