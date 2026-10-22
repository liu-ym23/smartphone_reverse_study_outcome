package nt;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b<\u0010=R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR$\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\bR$\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\bR$\u0010\"\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u0014\u001a\u0004\b#\u0010\u0016\"\u0004\b$\u0010\u0018R$\u0010%\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010\u0004\u001a\u0004\b&\u0010\u0006\"\u0004\b'\u0010\bR$\u0010(\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010\u0004\u001a\u0004\b)\u0010\u0006\"\u0004\b*\u0010\bR*\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010+8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R$\u00103\u001a\u0004\u0018\u0001028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R$\u00109\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b9\u0010\u0004\u001a\u0004\b:\u0010\u0006\"\u0004\b;\u0010\b¨\u0006>"}, d2 = {"Lnt/b;", "", "", "gameId", "Ljava/lang/String;", "getGameId", "()Ljava/lang/String;", "setGameId", "(Ljava/lang/String;)V", "gameName", "f", "setGameName", "gameIcon", "e", "setGameIcon", "gamePoint", ce.f26391f, "setGamePoint", "", "displayRating", "Ljava/lang/Integer;", "c", "()Ljava/lang/Integer;", "setDisplayRating", "(Ljava/lang/Integer;)V", "scoreGuidePrompt", ce.f26396k, "setScoreGuidePrompt", "contentGuidePrompt", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setContentGuidePrompt", "deviceSeries", "b", "setDeviceSeries", "minNum", RXScreenCaptureService.KEY_INDEX, "setMinNum", "toast", "m", "setToast", "needRatingToast", ce.f26395j, "setNeedRatingToast", "", "makeCommentGuideTagListArray", "Ljava/util/List;", "h", "()Ljava/util/List;", "setMakeCommentGuideTagListArray", "(Ljava/util/List;)V", "Lnt/b$a;", "firstMakeCommentGuide", "Lnt/b$a;", "d", "()Lnt/b$a;", "setFirstMakeCommentGuide", "(Lnt/b$a;)V", "starPrompts", "l", "setStarPrompts", "<init>", "()V", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("contentGuidePrompt")
    private String contentGuidePrompt;

    @SerializedName("deviceSeries")
    private String deviceSeries;

    @SerializedName("displayRating")
    private Integer displayRating;

    @SerializedName("firstMakeCommentGuide")
    private a firstMakeCommentGuide;

    @SerializedName("gameIcon")
    private String gameIcon;

    @SerializedName("gameId")
    private String gameId;

    @SerializedName("gameName")
    private String gameName;

    @SerializedName("gamePoint")
    private String gamePoint;

    @SerializedName("makeCommentGuideTagListArray")
    private List<String> makeCommentGuideTagListArray;

    @SerializedName("minNum")
    private Integer minNum;

    @SerializedName("needRatingToast")
    private String needRatingToast;

    @SerializedName("scoreGuidePrompt")
    private String scoreGuidePrompt;

    @SerializedName("starPrompts")
    private String starPrompts;

    @SerializedName("toast")
    private String toast;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u000e"}, d2 = {"Lnt/b$a;", "", "", "title", "Ljava/lang/String;", "b", "()Ljava/lang/String;", com.alipay.sdk.m.x.d.f25925o, "(Ljava/lang/String;)V", "content", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setContent", "<init>", "()V", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("content")
        private String content;

        @SerializedName("title")
        private String title;

        public a() {
        }

        public final String a() {
            return this.content;
        }

        public final String b() {
            return this.title;
        }
    }

    public b() {
    }

    public final String a() {
        return this.contentGuidePrompt;
    }

    public final String b() {
        return this.deviceSeries;
    }

    public final Integer c() {
        return this.displayRating;
    }

    public final a d() {
        return this.firstMakeCommentGuide;
    }

    public final String e() {
        return this.gameIcon;
    }

    public final String f() {
        return this.gameName;
    }

    public final String g() {
        return this.gamePoint;
    }

    public final List<String> h() {
        return this.makeCommentGuideTagListArray;
    }

    public final Integer i() {
        return this.minNum;
    }

    public final String j() {
        return this.needRatingToast;
    }

    public final String k() {
        return this.scoreGuidePrompt;
    }

    public final String l() {
        return this.starPrompts;
    }

    public final String m() {
        return this.toast;
    }
}
