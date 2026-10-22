package o90;

import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.live.base.model.UrlModel;
import com.bytedance.ee.bear.bitable.fieldedit.BitableFieldEditAnalytic;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0012\u0018\u00002\u00020\u0001:\u0003&'(B\t\b\u0016¢\u0006\u0004\b$\u0010%R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R*\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR*\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR$\u0010!\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0012\u001a\u0004\b\"\u0010\u0014\"\u0004\b#\u0010\u0016¨\u0006)"}, d2 = {"Lo90/e;", "", "", "id", "J", "getId", "()J", "setId", "(J)V", "Lcom/bytedance/android/live/base/model/UrlModel;", "icon", "Lcom/bytedance/android/live/base/model/UrlModel;", "getIcon", "()Lcom/bytedance/android/live/base/model/UrlModel;", "setIcon", "(Lcom/bytedance/android/live/base/model/UrlModel;)V", "", "name", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "", PromotionProductPrivilegesStruct.TAGS, "Ljava/util/List;", "getTags", "()Ljava/util/List;", "setTags", "(Ljava/util/List;)V", "types", "getTypes", "setTypes", "extra", "getExtra", "setExtra", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e {

    @SerializedName("extra")
    private String extra;

    @SerializedName("icon_url")
    private UrlModel icon;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private long f522434id;

    @SerializedName("name")
    private String name;

    @SerializedName(PromotionProductPrivilegesStruct.TAGS)
    private List<String> tags;

    @SerializedName("types")
    private List<String> types;

    public static final class a {
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b \u0010!R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\"\u0010\u0013\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\"\u0010\u0016\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\"\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Lo90/e$b;", "", "", "name", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "", "defaultValue", "I", "getDefaultValue", "()I", "setDefaultValue", "(I)V", "tag", "getTag", "setTag", "maxValue", "getMaxValue", "setMaxValue", "minValue", "getMinValue", "setMinValue", "", "doubleDirection", "Z", "getDoubleDirection", "()Z", "setDoubleDirection", "(Z)V", "<init>", "()V", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("value")
        private int defaultValue;

        @SerializedName("doubleDirection")
        private boolean doubleDirection;

        @SerializedName(BitableFieldEditAnalytic.ProgressFieldEditScene.MAX)
        private int maxValue;

        @SerializedName(BitableFieldEditAnalytic.ProgressFieldEditScene.MIN)
        private int minValue;

        @SerializedName("name")
        private String name;

        @SerializedName("tag")
        private String tag;

        public b() {
            this.name = "";
            this.tag = "";
            this.maxValue = 100;
            this.minValue = 100;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lo90/e$c;", "", "", "isAudioEffect", "Z", "()Z", "setAudioEffect", "(Z)V", "<init>", "()V", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class c {

        @SerializedName("audio_effect")
        private boolean isAudioEffect;

        public c() {
        }
    }

    static {
    }

    public final int hashCode() {
        long r100 = this.f522434id;
        return (int) (r100 ^ (r100 >>> 32));
    }

    public e() {
        new ArrayList();
        new ArrayList();
        new ArrayList();
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if ((!Intrinsics.areEqual(e.class, r101)) == false) goto L12;
        return false;
    L12:
        if (r100 == null) goto L18;
        if (this.f522434id == ((e) r100).f522434id) goto L16;
        return false;
    L16:
        return true;
    L18:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.effect.model.Sticker");
    L8:
        r101 = null;
        goto L10
    }
}
