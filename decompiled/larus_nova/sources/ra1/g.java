package ra1;

import android.text.TextUtils;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0002\n\u001dB\u0007¢\u0006\u0004\b\u001b\u0010\u001cR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR*\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lra1/g;", "", "", "sugType", "Ljava/lang/String;", "getSugType", "()Ljava/lang/String;", "f", "(Ljava/lang/String;)V", "content", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "e", "", "Lra1/d;", "position", "Ljava/util/List;", "c", "()Ljava/util/List;", "setPosition", "(Ljava/util/List;)V", "Lra1/g$b;", "wordRecord", "Lra1/g$b;", "getWordRecord", "()Lra1/g$b;", "setWordRecord", "(Lra1/g$b;)V", "<init>", "()V", "b", "livesearchimpl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f536808b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f536809a;

    @SerializedName("content")
    private String content;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_ROOM_POSITION)
    private List<d> position;

    @SerializedName("sug_type")
    private String sugType;

    @SerializedName("word_record")
    private b wordRecord;

    public static final class a {
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\b¨\u0006\u0018"}, d2 = {"Lra1/g$b;", "", "", "groupId", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "setGroupId", "(Ljava/lang/String;)V", "", "position", "I", "b", "()I", "setPosition", "(I)V", "wordSource", "d", "setWordSource", "wordContent", "c", "setWordContent", "<init>", "()V", "livesearchimpl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("group_id")
        private String groupId;

        @SerializedName("words_position")
        private int position;

        @SerializedName("words_content")
        private String wordContent;

        @SerializedName("words_source")
        private String wordSource;

        public b() {
            this.groupId = "";
            this.wordSource = "";
            this.wordContent = "";
        }

        public final String a() {
            return this.groupId;
        }

        public final int b() {
            return this.position;
        }

        public final String c() {
            return this.wordContent;
        }

        public final String d() {
            return this.wordSource;
        }
    }

    static {
    }

    public final Map<String, String> b() {
        HashMap r100 = new HashMap();
        b r101 = this.wordRecord;
        String r102 = "";
        if (r101 == null) goto L6;
        String r103 = r101.c();
        if (r103 == null) goto L6;
    L7:
        r100.put("words_content", r103);
        b r104 = this.wordRecord;
        if (r104 == null) goto L11;
        String r105 = String.valueOf(r104.b());
        if (r105 == null) goto L11;
    L12:
        r100.put("words_position", r105);
        b r106 = this.wordRecord;
        if (r106 == null) goto L16;
        String r107 = r106.a();
        if (r107 == null) goto L16;
    L17:
        r100.put("group_id", r107);
        b r108 = this.wordRecord;
        if (r108 == null) goto L23;
        String r109 = r108.d();
        if (r109 == null) goto L23;
        r102 = r109;
    L23:
        r100.put("wordSource", r102);
        return r100;
    L16:
        r107 = "";
    L11:
        r105 = "";
    L6:
        r103 = "";
        goto L7
    }

    public final boolean d() {
        return TextUtils.equals(this.sugType, "history");
    }

    public final void f() {
        Intrinsics.checkNotNullParameter("history", "<set-?>");
        this.sugType = "history";
    }

    public g() {
        this.sugType = "";
        this.content = "";
    }

    public final String a() {
        return this.content;
    }

    public final List<d> c() {
        return this.position;
    }

    public final void e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.content = r100;
    }
}
