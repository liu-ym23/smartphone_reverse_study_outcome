package com.ss.android.ainote;

import android.util.Base64;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import java.util.Arrays;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.Regex;
import kotlin.text.RegexOption;

/* JADX INFO: loaded from: classes34.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f406686a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Regex f406687b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Regex f406688c = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final byte[] f406689a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f406690b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f406689a, r101.f406689a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f406690b, r101.f406690b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = Arrays.hashCode(this.f406689a) * 31;
            String r101 = this.f406690b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "ParsedImage(bytes=" + Arrays.toString(this.f406689a) + ", mimeType=" + this.f406690b + ')';
        }

        public a(byte[] r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, HTTP.CONTENT_RANGE_BYTES);
            this.f406689a = r100;
            this.f406690b = r101;
        }
    }

    public c() {
    }

    static {
        f406686a = new c();
        f406687b = new Regex("^data:image/([a-zA-Z0-9.+-]+);base64,(.+)$", RegexOption.DOT_MATCHES_ALL);
        f406688c = new Regex("^[A-Za-z0-9+/=\\s]+$");
    }

    public static a a(String r100, String r101) {
        StringBuilder r102 = new StringBuilder();
        int r103 = 0;
    L4:
        if (r103 >= r100.length()) goto L9;
        char r104 = r100.charAt(r103);
        if (CharsKt.isWhitespace(r104) == true) goto L8;
        r102.append(r104);
    L8:
        r103 = r103 + 1;
        goto L4
    L9:
        String r105 = r102.toString();
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L12
        Object r107 = Result.m9449constructorimpl(Base64.decode(r105, 0));     // Catch: Throwable -> L12
    L15:
        if (Result.m9455isFailureimpl(r107) == false) goto L17;
        r107 = null;
    L17:
        byte[] r108 = (byte[]) r107;
        if (r108 != null) goto L21;
        return null;
    L21:
        return new a(r108, r101);
    L12:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L15
    }
}
