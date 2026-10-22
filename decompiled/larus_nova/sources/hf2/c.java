package hf2;

import com.alipay.sdk.m.x.d;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR*\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lhf2/c;", "", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", d.f25925o, "(Ljava/lang/String;)V", "", "type", "I", "getType", "()I", "setType", "(I)V", "", "Lhf2/a;", "content", "Ljava/util/List;", "getContent", "()Ljava/util/List;", "setContent", "(Ljava/util/List;)V", "room-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("content")
    private List<a> content;

    @SerializedName("title")
    private String title;

    @SerializedName("type")
    private int type;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L12;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L8;
        return false;
    L8:
        if (this.type == r101.type) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.title;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.type) * 31;
        List<a> r104 = this.content;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "LinkVideoItem(title=" + this.title + ", type=" + this.type + ", content=" + this.content + ")";
    }

    public final List<b> a() {
        int r100 = this.type;
        if (r100 != 0) goto L5;
        ArrayList r101 = new ArrayList();
        int r102 = this.type;
        String r103 = this.title;
        List<a> r104 = this.content;
        if (r104 == null) goto L43;
        a r105 = (a) ListProtector.get(r104, 0);
        if (r105 == null) goto L43;
        String r106 = r105.a();
        if (r106 == null) goto L43;
    L44:
        r101.add(new b(r102, r103, r106, null, null, 24));
        return r101;
    L43:
        r106 = "";
        goto L44
    L5:
        if (r100 != 1) goto L52;
        ArrayList r107 = new ArrayList();
        List<a> r108 = this.content;
        if (r108 == null) goto L51;
        Iterator<T> r109 = r108.iterator();
        int r110 = 0;
    L11:
        if (r109.hasNext() == false) goto L51;
        a r111 = (a) r109.next();
        List<String> r112 = r111.b();
        if (r112 == null) goto L35;
        if (r112.size() < 2) goto L35;
        if (r110 != 0) goto L26;
        int r113 = this.type;
        String r114 = this.title;
        String r115 = r111.a();
        List<String> r116 = r111.b();
        if (r116 == null) goto L20;
        String r117 = (String) ListProtector.get(r116, 0);
    L21:
        List<String> r118 = r111.b();
        if (r118 == null) goto L24;
        String r119 = (String) ListProtector.get(r118, 1);
    L25:
        r107.add(new b(r113, r114, r115, r117, r119));
        goto L35
    L24:
        r119 = null;
        goto L25
    L20:
        r117 = null;
        goto L21
    L26:
        int r120 = this.type;
        String r121 = r111.a();
        List<String> r122 = r111.b();
        if (r122 == null) goto L29;
        String r210 = (String) ListProtector.get(r122, 0);
    L30:
        List<String> r123 = r111.b();
        if (r123 == null) goto L33;
        String r211 = (String) ListProtector.get(r123, 1);
    L34:
        r107.add(new b(r120, null, r121, r210, r211, 2));
        goto L35
    L33:
        r211 = null;
        goto L34
    L29:
        r210 = null;
    L35:
        r110 = r110 + 1;
    L51:
        return r107;
    L52:
        return null;
    }

    public c() {
        this.title = null;
        this.type = -1;
        this.content = null;
    }

    public final int getType() {
        return this.type;
    }
}
