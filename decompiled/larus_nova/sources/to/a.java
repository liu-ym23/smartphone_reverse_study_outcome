package to;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\f\u0010\rR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lto/a;", "", "", RemoteMessageConst.Notification.VISIBILITY, "Ljava/lang/String;", "b", "()Ljava/lang/String;", "Lto/a$a;", GXTemplateKey.FLEXBOX_PADDING, "Lto/a$a;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lto/a$a;", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class a {

    @SerializedName(GXTemplateKey.FLEXBOX_PADDING)
    private final C7747a padding;

    @SerializedName(RemoteMessageConst.Notification.VISIBILITY)
    private final String visibility;

    /* JADX INFO: renamed from: to.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006¨\u0006\r"}, d2 = {"Lto/a$a;", "", "", "left", "Ljava/lang/Float;", "b", "()Ljava/lang/Float;", "top", "d", "right", "c", "bottom", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class C7747a {

        @SerializedName("bottom")
        private final Float bottom;

        @SerializedName("left")
        private final Float left;

        @SerializedName("right")
        private final Float right;

        @SerializedName("top")
        private final Float top;

        public final Float a() {
            return this.bottom;
        }

        public final Float b() {
            return this.left;
        }

        public final Float c() {
            return this.right;
        }

        public final Float d() {
            return this.top;
        }
    }

    public a() {
    }

    public final C7747a a() {
        return this.padding;
    }

    public final String b() {
        return this.visibility;
    }
}
