package hf2;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR*\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lhf2/c;", "", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "", LocationMonitorConst.TYPE, "I", "getType", "()I", "setType", "(I)V", "", "Lhf2/a;", "content", "Ljava/util/List;", "getContent", "()Ljava/util/List;", "setContent", "(Ljava/util/List;)V", "room-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("content")
    private List<a> content;

    @SerializedName("title")
    private String title;

    @SerializedName(LocationMonitorConst.TYPE)
    private int type;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof c) == false) goto L12;
        c r4 = (c) r3;
        if (Intrinsics.areEqual(this.title, r4.title) == true) goto L8;
        return false;
    L8:
        if (this.type == r4.type) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.content, r4.content) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r0 = this.title;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = ((r2 * 31) + this.type) * 31;
        List<a> r4 = this.content;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "LinkVideoItem(title=" + this.title + ", type=" + this.type + ", content=" + this.content + ")";
    }

    public final List<b> a() {
        int r1 = this.type;
        if (r1 != 0) goto L5;
        ArrayList r4 = new ArrayList();
        int r6 = this.type;
        String r7 = this.title;
        List<a> r3 = this.content;
        if (r3 == null) goto L43;
        a r2 = (a) ListProtector.get(r3, 0);
        if (r2 == null) goto L43;
        String r5 = r2.a();
        if (r5 == null) goto L43;
    L44:
        r4.add(new b(r6, r7, r5, null, null, 24));
        return r4;
    L43:
        r5 = "";
        goto L44
    L5:
        if (r1 != 1) goto L52;
        ArrayList r8 = new ArrayList();
        List<a> r9 = this.content;
        if (r9 == null) goto L51;
        Iterator<T> r10 = r9.iterator();
        int r11 = 0;
    L11:
        if (r10.hasNext() == false) goto L51;
        a r12 = (a) r10.next();
        List<String> r13 = r12.b();
        if (r13 == null) goto L35;
        if (r13.size() < 2) goto L35;
        if (r11 != 0) goto L26;
        int r14 = this.type;
        String r15 = this.title;
        String r16 = r12.a();
        List<String> r17 = r12.b();
        if (r17 == null) goto L20;
        String r18 = (String) ListProtector.get(r17, 0);
    L21:
        List<String> r19 = r12.b();
        if (r19 == null) goto L24;
        String r110 = (String) ListProtector.get(r19, 1);
    L25:
        r8.add(new b(r14, r15, r16, r18, r110));
        goto L35
    L24:
        r110 = null;
        goto L25
    L20:
        r18 = null;
        goto L21
    L26:
        int r20 = this.type;
        String r111 = r12.a();
        List<String> r112 = r12.b();
        if (r112 == null) goto L29;
        String r21 = (String) ListProtector.get(r112, 0);
    L30:
        List<String> r22 = r12.b();
        if (r22 == null) goto L33;
        String r23 = (String) ListProtector.get(r22, 1);
    L34:
        r8.add(new b(r20, null, r111, r21, r23, 2));
        goto L35
    L33:
        r23 = null;
        goto L34
    L29:
        r21 = null;
    L35:
        r11 = r11 + 1;
    L51:
        return r8;
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
