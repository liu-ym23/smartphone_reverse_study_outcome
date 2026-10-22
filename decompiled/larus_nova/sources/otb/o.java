package otb;

import com.google.gson.annotations.SerializedName;
import com.lynx.serval.svg.SVGRenderEngine;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bB\t\b\u0016¢\u0006\u0004\b\u0007\u0010\tB\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u0000¢\u0006\u0004\b\u0007\u0010\u000bJ\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0019\u001a\u00020\u0003H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0006\u0010\u001c\u001a\u00020\u001bJ\u0012\u0010\u001c\u001a\u00020\u001b2\n\u0010\u001d\u001a\u00060\u001ej\u0002`\u001fJ)\u0010 \u001a\u00020!2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0086\u0002J\u000e\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0000R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000f¨\u0006#"}, d2 = {"Lcom/ss/android/lark/officesdk/di/core/deps/webview/ViewRect;", "", "x", "", "y", "width", "height", "<init>", "(IIII)V", "()V", SVGRenderEngine.RECT, "(Lcom/ss/android/lark/officesdk/di/core/deps/webview/ViewRect;)V", "getX", "()I", "setX", "(I)V", "getY", "setY", "getWidth", "setWidth", "getHeight", "setHeight", "equals", "", "other", "hashCode", "toString", "", "toShortString", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "set", "", "src", "di-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class o {

    @SerializedName("height")
    private int height;

    @SerializedName("width")
    private int width;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @SerializedName("x")
    private int f526704x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @SerializedName("y")
    private int f526705y;

    public final int hashCode() {
        return (((((this.f526704x * 31) + this.f526705y) * 31) + this.width) * 31) + this.height;
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder(32);
        r100.append("Rect(");
        r100.append(this.f526704x);
        r100.append(", ");
        r100.append(this.f526705y);
        r100.append(" - ");
        r100.append(this.width);
        r100.append(", ");
        r100.append(this.height);
        r100.append(")");
        return r100.toString();
    }

    public o() {
        this.f526704x = 0;
        this.f526705y = 0;
        this.width = 0;
        this.height = 0;
    }

    public final int a() {
        return this.height;
    }

    public final int b() {
        return this.width;
    }

    public final int c() {
        return this.f526704x;
    }

    public final int d() {
        return this.f526705y;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(o.class, r101) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.ss.android.lark.officesdk.di.core.deps.webview.ViewRect");
        o r102 = (o) r100;
        if (this.f526704x == r102.f526704x) goto L16;
        return false;
    L16:
        if (this.f526705y == r102.f526705y) goto L19;
        return false;
    L19:
        if (this.width == r102.width) goto L22;
        return false;
    L22:
        if (this.height == r102.height) goto L24;
        return false;
    L24:
        return true;
    L8:
        r101 = null;
        goto L10
    }
}
