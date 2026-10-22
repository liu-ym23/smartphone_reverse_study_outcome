package com.ss.android.ugc.aweme.poi.bean;

import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.ies.modulize.rule.AllowImpl;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.poi.listener.OnControlFeedVideoListener;
import com.ss.android.ugc.aweme.poi.listener.OnLifePanelShowHeightChangeListener;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 @2\u00020\u0001:\u0002A@B\u0007¢\u0006\u0004\b>\u0010?J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0004\u001a\u00020\u0002H\u0007J\b\u0010\u0005\u001a\u00020\u0002H\u0007J\b\u0010\u0006\u001a\u00020\u0002H\u0007R\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u000e\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010(\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010)\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010\t\u001a\u0004\b*\u0010\u000b\"\u0004\b+\u0010\rR\"\u0010,\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010\t\u001a\u0004\b-\u0010\u000b\"\u0004\b.\u0010\rR\"\u0010/\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u0010\u000f\u001a\u0004\b0\u0010\u0010\"\u0004\b1\u0010\u0012R\"\u00102\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u0010\u000f\u001a\u0004\b2\u0010\u0010\"\u0004\b3\u0010\u0012R\"\u00104\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u0010\t\u001a\u0004\b5\u0010\u000b\"\u0004\b6\u0010\rR$\u00108\u001a\u0004\u0018\u0001078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=¨\u0006B"}, d2 = {"Lcom/ss/android/ugc/aweme/poi/bean/PoiDetailNewPageParams;", "Ljava/io/Serializable;", "", "isParamValid", "isHalfScreen", "isFullScreen", "isPoiFixHeight", "", "poiPageStyle", "I", "getPoiPageStyle", "()I", "setPoiPageStyle", "(I)V", "isFullPageFragment", "Z", "()Z", "setFullPageFragment", "(Z)V", "", "pageInitialHeightPercentage", FaceService.girlLabel, "getPageInitialHeightPercentage", "()F", "setPageInitialHeightPercentage", "(F)V", "", "awemeId", "Ljava/lang/String;", "getAwemeId", "()Ljava/lang/String;", "setAwemeId", "(Ljava/lang/String;)V", "Lcom/ss/android/ugc/aweme/poi/listener/OnLifePanelShowHeightChangeListener;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/ss/android/ugc/aweme/poi/listener/OnLifePanelShowHeightChangeListener;", "getOnShowHeightChangeListener", "()Lcom/ss/android/ugc/aweme/poi/listener/OnLifePanelShowHeightChangeListener;", "setOnShowHeightChangeListener", "(Lcom/ss/android/ugc/aweme/poi/listener/OnLifePanelShowHeightChangeListener;)V", "onShowHeightChangeListener", "pageFrom", "getPageFrom", "setPageFrom", "pageLayoutStyle", "getPageLayoutStyle", "setPageLayoutStyle", "hideAble", "getHideAble", "setHideAble", "isSplitScreen", "setSplitScreen", "poiFixHeight", "getPoiFixHeight", "setPoiFixHeight", "Lcom/ss/android/ugc/aweme/poi/listener/OnControlFeedVideoListener;", "onControlFeedListener", "Lcom/ss/android/ugc/aweme/poi/listener/OnControlFeedVideoListener;", "getOnControlFeedListener", "()Lcom/ss/android/ugc/aweme/poi/listener/OnControlFeedVideoListener;", "setOnControlFeedListener", "(Lcom/ss/android/ugc/aweme/poi/listener/OnControlFeedVideoListener;)V", "<init>", "()V", "Companion", "Builder", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
public final class PoiDetailNewPageParams implements Serializable {
    public static final Companion Companion = null;
    public static final int PAGE_FROM_MAIN = 1;
    public static final int POI_COMMON_HALF_LAYOUT = 0;
    public static final int POI_FIX_HEIGHT_ENABLE = 1;
    public static final int POI_FIX_HEIGHT_UNABLE = 0;
    public static final int POI_NEW_HALF_LAYOUT = 1;
    public static final int POI_NEW_HALF_LAYOUT_2 = 2;
    public static final int POI_PAGE_STYLE_FULL = 0;
    public static final int POI_PAGE_STYLE_HALF = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient OnLifePanelShowHeightChangeListener f451307a;
    private String awemeId;
    private boolean hideAble;
    private boolean isFullPageFragment;
    private boolean isSplitScreen;
    private int pageFrom;
    private float pageInitialHeightPercentage;
    private int pageLayoutStyle;
    private int poiFixHeight;
    private int poiPageStyle;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/poi/bean/PoiDetailNewPageParams$Builder;", "", "<init>", "()V", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f451308a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f451309b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f451310c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f451311d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f451312e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f451313f;

        @AllowImpl
        public final PoiDetailNewPageParams a() {
            PoiDetailNewPageParams r100 = new PoiDetailNewPageParams();
            r100.setPoiPageStyle(this.f451308a);
            r100.setFullPageFragment(false);
            r100.setPageInitialHeightPercentage(this.f451309b);
            r100.setAwemeId(null);
            r100.setOnShowHeightChangeListener(null);
            r100.setOnControlFeedListener(null);
            r100.setPageFrom(this.f451310c);
            r100.setPageLayoutStyle(this.f451311d);
            r100.setHideAble(this.f451312e);
            r100.setPoiFixHeight(this.f451313f);
            return r100;
        }

        public Builder() {
            this.f451308a = 1;
            this.f451309b = 0.75f;
            this.f451310c = 1;
            this.f451312e = true;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004¨\u0006\u000e"}, d2 = {"Lcom/ss/android/ugc/aweme/poi/bean/PoiDetailNewPageParams$Companion;", "", "", "PAGE_FROM_MAIN", "I", "POI_COMMON_HALF_LAYOUT", "POI_FIX_HEIGHT_ENABLE", "POI_FIX_HEIGHT_UNABLE", "POI_NEW_HALF_LAYOUT", "POI_NEW_HALF_LAYOUT_2", "POI_PAGE_STYLE_FULL", "POI_PAGE_STYLE_HALF", "<init>", "()V", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }

        public static boolean a(Integer r100) {
            if (r100 != null) goto L6;
        L7:
            if (r100 != null) goto L10;
        L12:
            return false;
        L10:
            if (r100.intValue() != 2) goto L12;
            return true;
        L6:
            if (r100.intValue() != 1) goto L7;
            return true;
        }
    }

    static {
        Companion = new Companion(0);
    }

    public final OnControlFeedVideoListener getOnControlFeedListener() {
        return null;
    }

    public final void setOnControlFeedListener(OnControlFeedVideoListener r100) {
    }

    @AllowImpl
    public final boolean isFullScreen() {
        if (this.poiPageStyle != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @AllowImpl
    public final boolean isHalfScreen() {
        if (this.poiPageStyle == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @AllowImpl
    public final boolean isParamValid() {
        float r100 = this.pageInitialHeightPercentage;
        if (r100 > 0) goto L5;
        return false;
    L5:
        if (r100 <= 1) goto L7;
        return false;
    L7:
        if (this.poiPageStyle != 1) goto L12;
        return true;
    L12:
        return false;
    }

    @AllowImpl
    public final boolean isPoiFixHeight() {
        if (this.poiFixHeight == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public PoiDetailNewPageParams() {
        this.poiPageStyle = 1;
        this.pageInitialHeightPercentage = 0.75f;
        this.pageFrom = 1;
        this.hideAble = true;
    }

    public final String getAwemeId() {
        return this.awemeId;
    }

    public final boolean getHideAble() {
        return this.hideAble;
    }

    public final OnLifePanelShowHeightChangeListener getOnShowHeightChangeListener() {
        return this.f451307a;
    }

    public final int getPageFrom() {
        return this.pageFrom;
    }

    public final float getPageInitialHeightPercentage() {
        return this.pageInitialHeightPercentage;
    }

    public final int getPageLayoutStyle() {
        return this.pageLayoutStyle;
    }

    public final int getPoiFixHeight() {
        return this.poiFixHeight;
    }

    public final int getPoiPageStyle() {
        return this.poiPageStyle;
    }

    public final boolean isFullPageFragment() {
        return this.isFullPageFragment;
    }

    public final boolean isSplitScreen() {
        return this.isSplitScreen;
    }

    public final void setAwemeId(String r100) {
        this.awemeId = r100;
    }

    public final void setFullPageFragment(boolean r100) {
        this.isFullPageFragment = r100;
    }

    public final void setHideAble(boolean r100) {
        this.hideAble = r100;
    }

    public final void setOnShowHeightChangeListener(OnLifePanelShowHeightChangeListener r100) {
        this.f451307a = r100;
    }

    public final void setPageFrom(int r100) {
        this.pageFrom = r100;
    }

    public final void setPageInitialHeightPercentage(float r100) {
        this.pageInitialHeightPercentage = r100;
    }

    public final void setPageLayoutStyle(int r100) {
        this.pageLayoutStyle = r100;
    }

    public final void setPoiFixHeight(int r100) {
        this.poiFixHeight = r100;
    }

    public final void setPoiPageStyle(int r100) {
        this.poiPageStyle = r100;
    }

    public final void setSplitScreen(boolean r100) {
        this.isSplitScreen = r100;
    }
}
