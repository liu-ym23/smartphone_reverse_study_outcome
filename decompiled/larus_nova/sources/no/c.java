package no;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ui.ec.widget.tools.ECToastUtils;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.downloadlib.constants.DownloadConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class c extends no.a<a> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f519882b = null;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lno/c$a;", "", "", "msg", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "", "shortStyle", "Ljava/lang/Boolean;", "b", "()Ljava/lang/Boolean;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("message")
        private final String msg;

        @SerializedName("short_style")
        private final Boolean shortStyle;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L10;
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.msg, r101.msg) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.shortStyle, r101.shortStyle) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            String r100 = this.msg;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            Boolean r104 = this.shortStyle;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "ToastMessage(msg=" + this.msg + ", shortStyle=" + this.shortStyle + ")";
        }

        public final String a() {
            return this.msg;
        }

        public final Boolean b() {
            return this.shortStyle;
        }
    }

    static {
        f519882b = new c();
    }

    public c() {
        super(DownloadConstants.KEY_TOAST);
    }

    @Override // no.a
    public final a b(String r100) {
        if (com.bytedance.android.ec.window.base.dynamicview.common.c.f49250a == true) goto L6;
    L6:
        if (r100 != null) goto L9;
        return null;
    L9:
        return (a) uo.a.b(r100, a.class);
    }

    @Override // no.a
    public final void a(View r100, a r101) {
        a r102 = r101;
        Intrinsics.checkNotNullParameter(r100, "view");
        ECToastUtils r103 = ECToastUtils.INSTANCE;
        Context r104 = r100.getContext();
        Boolean r105 = null;
        if (r102 == null) goto L5;
        String r106 = r102.a();
    L6:
        if (r102 == null) goto L8;
        r105 = r102.b();
    L8:
        r103.showToast(r104, r106, r105);
        return;
    L5:
        r106 = null;
        goto L6
    }
}
