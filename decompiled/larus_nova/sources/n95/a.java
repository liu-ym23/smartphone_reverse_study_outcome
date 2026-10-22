package n95;

import android.net.Uri;
import android.text.TextUtils;
import java.net.URL;

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f518397a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f518398b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f518399c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public URL f518400d;

    public final String a() {
        if (TextUtils.isEmpty(this.f518399c) == false) goto L10;
        String r100 = this.f518398b;
        if (TextUtils.isEmpty(r100) == true) goto L8;
        this.f518399c = Uri.encode(r100, "@#&=*+-_.,:!?()/~'%");
        goto L10
    L8:
        throw null;
    L10:
        return this.f518399c;
    }

    public final int hashCode() {
        String r100 = this.f518398b;
        r100.getClass();
        return (r100.hashCode() * 31) + this.f518397a.hashCode();
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder();
        String r101 = this.f518398b;
        r101.getClass();
        r100.append(r101);
        r100.append('\n');
        r100.append(this.f518397a.toString());
        return r100.toString();
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof a) == false) goto L10;
        a r101 = (a) r100;
        String r102 = this.f518398b;
        r102.getClass();
        String r103 = r101.f518398b;
        r103.getClass();
        if (r102.equals(r103) == true) goto L7;
        return false;
    L7:
        if (this.f518397a.equals(r101.f518397a) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public a(String r100, h r101) {
        if (TextUtils.isEmpty(r100) == true) goto L7;
        this.f518398b = r100;
        this.f518397a = r101;
        return;
    L7:
        throw new IllegalArgumentException("String url must not be empty or null: " + r100);
    }
}
