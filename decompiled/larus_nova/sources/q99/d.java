package q99;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.music.applet.MusicAppletPage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B\u0095\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\u0012\b\u0002\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\u0018\b\u0002\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0011¢\u0006\u0004\b\u0012\u0010\u0013J8\u0010(\u001a\u00020\u00002\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0018\b\u0002\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0011J\u0010\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0015J\u000b\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u000b\u0010,\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0013\u0010/\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\fHÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0019\u00102\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0011HÆ\u0003J\u009c\u0001\u00103\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\u0012\b\u0002\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0018\b\u0002\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0011HÆ\u0001¢\u0006\u0002\u00104J\u0013\u00105\u001a\u00020\u00072\b\u00106\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00107\u001a\u00020\u0003HÖ\u0001J\t\u00108\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0018R \u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0018R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0018R&\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0017\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\f8F¢\u0006\u0006\u001a\u0004\b'\u0010 ¨\u00069"}, d2 = {"Lcom/larus/feedback/api/model/FlowFeedbackContentResponse;", "", "feedbackScene", "", "feedbackSceneName", "", "needShow", "", "feedbackId", GXTemplateKey.GAIAX_PLACEHOLDER, "showContent", "dislikeKeys", "", "Lcom/larus/feedback/api/model/FlowFeedbackDislikeKey;", "messageId", "sectionId", "extra", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "getFeedbackScene", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getFeedbackSceneName", "()Ljava/lang/String;", "getNeedShow", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getFeedbackId", "getPlaceholder", "getShowContent", "getDislikeKeys", "()Ljava/util/List;", "getMessageId", "getSectionId", "getExtra", "()Ljava/util/Map;", "dislikeOptions", "Lcom/larus/feedback/api/model/FlowDislikeOption;", "getDislikeOptions", "withResolvedContext", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Lcom/larus/feedback/api/model/FlowFeedbackContentResponse;", "equals", "other", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class d {

    @SerializedName("dislike_keys")
    private final List<f> dislikeKeys;

    @SerializedName("extra")
    private final Map<String, String> extra;

    @SerializedName("feedback_id")
    private final String feedbackId;

    @SerializedName("feedback_scene")
    private final Integer feedbackScene;

    @SerializedName("feedback_scene_name")
    private final String feedbackSceneName;

    @SerializedName(MusicAppletPage.KEY_MESSAGE_ID)
    private final String messageId;

    @SerializedName("need_show")
    private final Boolean needShow;

    @SerializedName(GXTemplateKey.GAIAX_PLACEHOLDER)
    private final String placeholder;

    @SerializedName("section_id")
    private final String sectionId;

    @SerializedName("show_content")
    private final String showContent;

    public d() {
        this(null, null, null, null, null, null, null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.feedbackScene, r101.feedbackScene) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.feedbackSceneName, r101.feedbackSceneName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.needShow, r101.needShow) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.feedbackId, r101.feedbackId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.placeholder, r101.placeholder) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.showContent, r101.showContent) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.dislikeKeys, r101.dislikeKeys) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.messageId, r101.messageId) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.sectionId, r101.sectionId) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.extra, r101.extra) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.feedbackScene;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.feedbackSceneName;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.needShow;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.feedbackId;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.placeholder;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.showContent;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        List<f> r119 = this.dislikeKeys;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.messageId;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.sectionId;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        Map<String, String> r128 = this.extra;
        if (r128 == null) goto L43;
        r101 = r128.hashCode();
    L43:
        return r127 + r101;
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "FlowFeedbackContentResponse(feedbackScene=" + this.feedbackScene + ", feedbackSceneName=" + this.feedbackSceneName + ", needShow=" + this.needShow + ", feedbackId=" + this.feedbackId + ", placeholder=" + this.placeholder + ", showContent=" + this.showContent + ", dislikeKeys=" + this.dislikeKeys + ", messageId=" + this.messageId + ", sectionId=" + this.sectionId + ", extra=" + this.extra + ')';
    }

    public final List<b> a() {
        List<f> r100 = this.dislikeKeys;
        if (r100 != null) goto L5;
        r100 = CollectionsKt.emptyList();
    L5:
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L7:
        if (r102.hasNext() == false) goto L14;
        f r103 = (f) r102.next();
        if (r103 == null) goto L11;
        b r104 = r103.a();
    L12:
        if (r104 == null) goto L7;
        r101.add(r104);
        goto L7
    L11:
        r104 = null;
        goto L12
    L14:
        return r101;
    }

    public final String b() {
        return this.feedbackId;
    }

    public final Integer c() {
        return this.feedbackScene;
    }

    public final String d() {
        return this.feedbackSceneName;
    }

    public final String e() {
        return this.messageId;
    }

    public final Boolean f() {
        return this.needShow;
    }

    public final String g() {
        return this.placeholder;
    }

    public final String h() {
        return this.sectionId;
    }

    public final String i() {
        return this.showContent;
    }

    public final d j(String r110, String r111, Map<String, String> r112) {
        String r100 = this.messageId;
        if (r100 != null) goto L5;
        String r101 = r110;
    L6:
        String r113 = this.sectionId;
        if (r113 != null) goto L9;
        String r114 = r111;
    L10:
        Map<String, String> r115 = this.extra;
        if (r115 != null) goto L13;
        r115 = MapsKt.emptyMap();
    L13:
        if (r112 != null) goto L15;
        r112 = MapsKt.emptyMap();
    L15:
        Map r116 = MapsKt.plus(r115, r112);
        return new d(this.feedbackScene, this.feedbackSceneName, this.needShow, this.feedbackId, this.placeholder, this.showContent, this.dislikeKeys, r101, r114, r116);
    L9:
        r114 = r113;
        goto L10
    L5:
        r101 = r100;
        goto L6
    }

    public d(Integer r100, String r101, Boolean r102, String r103, String r104, String r105, List<f> r106, String r107, String r108, Map<String, String> r110) {
        this.feedbackScene = r100;
        this.feedbackSceneName = r101;
        this.needShow = r102;
        this.feedbackId = r103;
        this.placeholder = r104;
        this.showContent = r105;
        this.dislikeKeys = r106;
        this.messageId = r107;
        this.sectionId = r108;
        this.extra = r110;
    }
}
