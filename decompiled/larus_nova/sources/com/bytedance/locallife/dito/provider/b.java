package com.bytedance.locallife.dito.provider;

import androidx.exifinterface.media.ExifInterface;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u0011R\u001a\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00018\u00008\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/bytedance/locallife/dito/provider/b;", ExifInterface.GPS_DIRECTION_TRUE, "", "", "code", "I", "b", "()I", "", "msg", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "data", "Ljava/lang/Object;", "c", "()Ljava/lang/Object;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "dito-core-saas_release"}, k = 1, mv = {1, 4, 3})
public class b<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f258669b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient boolean f258670a;

    @SerializedName("code")
    private final int code;

    @SerializedName("data")
    private final T data;

    @SerializedName("msg")
    private final String msg;

    public static final class a {
        public a() {
        }
    }

    static {
        new a();
    }

    public b() {
        this(0, null, null, false, 15);
    }

    public final int b() {
        return this.code;
    }

    public final T c() {
        return this.data;
    }

    public final String d() {
        return this.msg;
    }

    public Map<String, Object> a(Map<String, Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "defaultValue");
        T r101 = this.data;
        if ((r101 instanceof Map) == false) goto L5;
        Map<String, Object> r102 = (Map) r101;
    L7:
        if (this.f258670a == true) goto L10;
        if (r102 == null) goto L10;
        return r102;
    L10:
        Integer r103 = Integer.valueOf(this.code);
        if (r103 != null) goto L14;
    L16:
        String r104 = this.msg;
        if (r104 != null) goto L20;
    L22:
        T r105 = this.data;
        if (r105 != null) goto L26;
    L28:
        return r100;
    L26:
        if (r100.get("data") != null) goto L28;
        r100.put("data", r105);
        goto L28
    L20:
        if (r100.get("msg") != null) goto L22;
        r100.put("msg", r104);
        goto L22
    L14:
        if (r100.get("code") != null) goto L16;
        r100.put("code", r103);
        goto L16
    L5:
        r102 = null;
        goto L7
    }

    public b(int r100, String r101, Object r102, boolean r103, int r104) {
        if ((r104 & 1) == 0) goto L6;
        r100 = 1;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = (T) null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = false;
    L14:
        this.code = r100;
        this.msg = r101;
        this.data = (T) r102;
        this.f258670a = r103;
    }
}
