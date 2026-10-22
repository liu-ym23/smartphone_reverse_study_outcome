package com.larus.uaigc.createpage.component.stylelist;

import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.POST;
import com.google.gson.annotations.SerializedName;
import com.hihonor.honorid.core.data.UserInfo;
import com.larus.bmhome.actionbar.model.g1;
import com.larus.network.bean.BizResponse;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u0000 \f2\u00020\u0001:\u0005\b\t\n\u000b\fJ\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@¢\u0006\u0002\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/larus/uaigc/createpage/component/stylelist/ImageStyleRecommendApi;", "", "imageStyleRecommend", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/uaigc/createpage/component/stylelist/ImageStyleRecommendApi$ImageStyleRecommendResponse;", "request", "Lcom/larus/uaigc/createpage/component/stylelist/ImageStyleRecommendApi$ImageStyleRecommendRequest;", "(Lcom/larus/uaigc/createpage/component/stylelist/ImageStyleRecommendApi$ImageStyleRecommendRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ImageStyleRecommendRequest", "ImageStyleRecommendResponse", "ImageStyle", "ImageStyleType", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ImageStyleRecommendApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f372472a = null;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R \u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/larus/uaigc/createpage/component/stylelist/ImageStyleRecommendApi$ImageStyle;", "Ljava/io/Serializable;", "id", "", "displayText", "", "messageText", "icon", "Lcom/larus/bmhome/actionbar/model/Icon;", "<init>", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Lcom/larus/bmhome/actionbar/model/Icon;)V", "getId", "()Ljava/lang/Long;", "setId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getDisplayText", "()Ljava/lang/String;", "setDisplayText", "(Ljava/lang/String;)V", "getMessageText", "setMessageText", "getIcon", "()Lcom/larus/bmhome/actionbar/model/Icon;", "setIcon", "(Lcom/larus/bmhome/actionbar/model/Icon;)V", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ImageStyle implements Serializable {

        @SerializedName("display_text")
        private String displayText;

        @SerializedName("icon")
        private g1 icon;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        @SerializedName("id")
        private Long f372473id;

        @SerializedName(TTDelegateActivity.MESSAGE_TEXT)
        private String messageText;

        public ImageStyle() {
            this(null, null, null, null, 15, null);
        }

        public final String getDisplayText() {
            return this.displayText;
        }

        public final g1 getIcon() {
            return this.icon;
        }

        public final Long getId() {
            return this.f372473id;
        }

        public final String getMessageText() {
            return this.messageText;
        }

        public final void setDisplayText(String r100) {
            this.displayText = r100;
        }

        public final void setIcon(g1 r100) {
            this.icon = r100;
        }

        public final void setId(Long r100) {
            this.f372473id = r100;
        }

        public final void setMessageText(String r100) {
            this.messageText = r100;
        }

        public ImageStyle(Long r100, String r101, String r102, g1 r103) {
            this.f372473id = r100;
            this.displayText = r101;
            this.messageText = r102;
            this.icon = r103;
        }

        public /* synthetic */ ImageStyle(Long r100, String r101, String r102, g1 r103, int r104, DefaultConstructorMarker r105) {
            if ((r104 & 1) == 0) goto L6;
            r100 = -1L;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r101 = "";
        L9:
            if ((r104 & 4) == 0) goto L12;
            r102 = "";
        L12:
            if ((r104 & 8) == 0) goto L14;
            r103 = null;
        L14:
            this(r100, r101, r102, r103);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B5\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tR(\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR.\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/larus/uaigc/createpage/component/stylelist/ImageStyleRecommendApi$ImageStyleRecommendResponse;", "Ljava/io/Serializable;", "styleList", "", "Lcom/larus/uaigc/createpage/component/stylelist/ImageStyleRecommendApi$ImageStyle;", "traceMap", "", "", "<init>", "(Ljava/util/List;Ljava/util/Map;)V", "getStyleList", "()Ljava/util/List;", "setStyleList", "(Ljava/util/List;)V", "getTraceMap", "()Ljava/util/Map;", "setTraceMap", "(Ljava/util/Map;)V", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ImageStyleRecommendResponse implements Serializable {

        @SerializedName("style_list")
        private List<ImageStyle> styleList;

        @SerializedName("trace_map")
        private Map<String, String> traceMap;

        /* JADX WARN: Multi-variable type inference failed */
        public ImageStyleRecommendResponse() {
            Object[] r100 = 0 == true ? 1 : 0;
            this(null, r100, 3, 0 == true ? 1 : 0);
        }

        public final List<ImageStyle> getStyleList() {
            return this.styleList;
        }

        public final Map<String, String> getTraceMap() {
            return this.traceMap;
        }

        public final void setStyleList(List<ImageStyle> r100) {
            this.styleList = r100;
        }

        public final void setTraceMap(Map<String, String> r100) {
            this.traceMap = r100;
        }

        public ImageStyleRecommendResponse(List<ImageStyle> r100, Map<String, String> r101) {
            this.styleList = r100;
            this.traceMap = r101;
        }

        public /* synthetic */ ImageStyleRecommendResponse(List r100, Map r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 1) == 0) goto L6;
            r100 = null;
        L6:
            if ((r102 & 2) == 0) goto L8;
            r101 = null;
        L8:
            this(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/uaigc/createpage/component/stylelist/ImageStyleRecommendApi$ImageStyleType;", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ImageStyleType {
        public static final a Companion = null;
        public static final int Img2Img = 1;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f372474a = null;

            static {
                f372474a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.f372474a;
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f372475a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static boolean f372476b;

        public a() {
        }

        static {
            f372475a = new a();
            f372476b = true;
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/larus/uaigc/createpage/component/stylelist/ImageStyleRecommendApi$ImageStyleRecommendRequest;", "", "coldStart", "", "type", "", UserInfo.LANGUAGECODE, "", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;)V", "getColdStart", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getLanguageCode", "()Ljava/lang/String;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b {

        @SerializedName("cold_start")
        private final Boolean coldStart;

        @SerializedName("language_code")
        private final String languageCode;

        @SerializedName("type")
        private final Integer type;

        public b() {
            this(null, null, null);
        }

        public final Integer getType() {
            return this.type;
        }

        public b(Boolean r100, @ImageStyleType Integer r101, String r102) {
            this.coldStart = r100;
            this.type = r101;
            this.languageCode = r102;
        }
    }

    static {
        f372472a = a.f372475a;
    }

    @POST("/creativity/image_style/recommend")
    Object imageStyleRecommend(@Body b r100, Continuation<? super BizResponse<ImageStyleRecommendResponse>> r101);
}
