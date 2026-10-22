package py;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.discover.model.ScoreTags;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0016\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u00022\u00020\u0003:\u00013R$\u0010\u000b\u001a\u0004\u0018\u00010\u00048&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR2\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00040\fj\b\u0012\u0004\u0012\u00020\u0004`\r8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0012\u0010\n\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0015\u001a\u00020\u00148&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0019\u0010\n\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u001d\u001a\u0004\u0018\u00010\u00048&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001c\u0010\n\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR$\u0010$\u001a\u0004\u0018\u00010\u001e8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b#\u0010\n\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010*\u001a\u00020\u001e8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b)\u0010\n\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010.\u001a\u00020\u001e8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b-\u0010\n\u001a\u0004\b+\u0010&\"\u0004\b,\u0010(R$\u00102\u001a\u0004\u0018\u00010\u00048&@&X§\u000e¢\u0006\u0012\u0012\u0004\b1\u0010\n\u001a\u0004\b/\u0010\u0006\"\u0004\b0\u0010\b¨\u00064"}, d2 = {"Lpy/k;", "Lvh7/c;", "Lpy/l;", "", "", "getUri", "()Ljava/lang/String;", "setUri", "(Ljava/lang/String;)V", "getUri$annotations", "()V", "uri", "", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getUrls", "()Ljava/util/List;", "setUrls", "(Ljava/util/List;)V", "getUrls$annotations", "urls", "", "isAnimated", "()Z", "setAnimated", "(Z)V", "isAnimated$annotations", "getSchema", "setSchema", "getSchema$annotations", "schema", "", "getImageType", "()Ljava/lang/Integer;", "setImageType", "(Ljava/lang/Integer;)V", "getImageType$annotations", "imageType", "getWidth", "()I", "setWidth", "(I)V", "getWidth$annotations", "width", "getHeight", "setHeight", "getHeight$annotations", "height", "getAvgColor", "setAvgColor", "getAvgColor$annotations", "avgColor", "b", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface k extends vh7.c<k>, l {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\r\bg\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001aR$\u0010\t\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R$\u0010\r\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\f\u0010\b\u001a\u0004\b\n\u0010\u0004\"\u0004\b\u000b\u0010\u0006R\"\u0010\u0014\u001a\u00020\u000e8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0013\u0010\b\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0018\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0017\u0010\b\u001a\u0004\b\u0015\u0010\u0004\"\u0004\b\u0016\u0010\u0006¨\u0006\u001b"}, d2 = {"Lpy/k$b;", "Lvh7/c;", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getName$annotations", "()V", "name", "getFontColor", "setFontColor", "getFontColor$annotations", "fontColor", "", "getLevel", "()J", "setLevel", "(J)V", "getLevel$annotations", "level", "getAccessibilityText", "setAccessibilityText", "getAccessibilityText$annotations", "accessibilityText", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public interface b extends vh7.c<b> {
        public static final a Companion = null;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f530971a = null;

            public a() {
            }

            static {
                f530971a = new a();
            }

            public static boolean a(b r100) {
                if (r100 == null) goto L22;
                String r101 = r100.getName();
                if (r101 != null) goto L7;
            L10:
                boolean r102 = true;
            L11:
                if (r102 == true) goto L23;
                String r103 = r100.getFontColor();
                if (r103 != null) goto L15;
            L18:
                boolean r104 = true;
            L19:
                if (r104 == true) goto L24;
                return true;
            L24:
                return false;
            L15:
                if (r103.length() == 0) goto L18;
                r104 = false;
                goto L19
            L23:
                return false;
            L7:
                if (r101.length() == 0) goto L10;
                r102 = false;
                goto L11
            L22:
                return false;
            }
        }

        /* JADX INFO: renamed from: py.k$b$b, reason: collision with other inner class name */
        @JsonAdapter(FlexModelJsonAdapter.class)
        @Metadata(k = 3, mv = {1, 5, 1})
        public static final class C7255b {
        }

        static {
            Companion = a.f530971a;
        }

        @Override // vh7.c
        /* synthetic */ vh7.e castTo(Class r100);

        @Override // vh7.c
        /* synthetic */ vh7.e castToOrNull(Class r100);

        @FieldName(name = "alternative_text")
        String getAccessibilityText();

        @FieldName(name = "font_color")
        String getFontColor();

        @FieldName(name = "level")
        long getLevel();

        @FieldName(name = "name")
        String getName();

        @FieldName(name = "alternative_text#setter")
        void setAccessibilityText(String r100);

        @FieldName(name = "font_color#setter")
        void setFontColor(String r100);

        @FieldName(name = "level#setter")
        void setLevel(long r100);

        @FieldName(name = "name#setter")
        void setName(String r100);
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    /* synthetic */ boolean equalsOnlyUri(Object r100);

    @FieldName(name = "avg_color")
    String getAvgColor();

    @FieldName(name = "height")
    int getHeight();

    /* synthetic */ String getIconStub();

    /* synthetic */ b getImageContent();

    @FieldName(name = "image_type")
    Integer getImageType();

    @FieldName(name = "open_web_url")
    String getSchema();

    @FieldName(name = "uri")
    String getUri();

    @FieldName(name = ScoreTags.STAR_URL_LIST)
    List<String> getUrls();

    /* synthetic */ List<String> getUrlsKmp();

    @FieldName(name = "width")
    int getWidth();

    @FieldName(name = "is_animated")
    boolean isAnimated();

    /* synthetic */ boolean isFeedCandidate();

    /* synthetic */ boolean isLoaded();

    /* synthetic */ boolean isMonitored();

    /* synthetic */ boolean isResizableImg();

    /* synthetic */ boolean isValid();

    @FieldName(name = "is_animated#setter")
    void setAnimated(boolean r100);

    @FieldName(name = "avg_color#setter")
    void setAvgColor(String r100);

    /* synthetic */ void setContent(b r100);

    @FieldName(name = "height#setter")
    void setHeight(int r100);

    /* synthetic */ void setIconStub(String r100);

    @FieldName(name = "image_type#setter")
    void setImageType(Integer r100);

    /* synthetic */ void setIsResizableImg(boolean r100);

    /* synthetic */ void setLoaded(boolean r100);

    @FieldName(name = "open_web_url#setter")
    void setSchema(String r100);

    @FieldName(name = "uri#setter")
    void setUri(String r100);

    @FieldName(name = "url_list#setter")
    void setUrls(List<String> r100);

    @FieldName(name = "width#setter")
    void setWidth(int r100);
}
