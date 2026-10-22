package com.bytedance.awemeopen.apps.framework.feed.pinch.model;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import r14.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001:\u0001iB\u0007¢\u0006\u0004\bg\u0010hR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001a\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u001b\u0010\r\"\u0004\b\u001c\u0010\u000fR$\u0010\u001d\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0015\u001a\u0004\b\u001e\u0010\u0017\"\u0004\b\u001f\u0010\u0019R,\u0010\"\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010!\u0018\u00010 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R$\u0010)\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u00100\u001a\u0004\u0018\u00010/8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R$\u00106\u001a\u0004\u0018\u00010/8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b6\u00101\u001a\u0004\b7\u00103\"\u0004\b8\u00105R$\u00109\u001a\u0004\u0018\u00010/8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u00101\u001a\u0004\b:\u00103\"\u0004\b;\u00105R\"\u0010<\u001a\u00020/8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR$\u0010B\u001a\u0004\u0018\u00010/8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bB\u00101\u001a\u0004\bC\u00103\"\u0004\bD\u00105R*\u0010E\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bE\u0010#\u001a\u0004\bE\u0010%\"\u0004\bF\u0010'R,\u0010G\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u00010 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bG\u0010#\u001a\u0004\bH\u0010%\"\u0004\bI\u0010'R\"\u0010J\u001a\u00020/8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bJ\u0010=\u001a\u0004\bJ\u0010?\"\u0004\bK\u0010AR*\u0010L\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bL\u0010#\u001a\u0004\bL\u0010%\"\u0004\bM\u0010'R*\u0010N\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bN\u0010#\u001a\u0004\bO\u0010%\"\u0004\bP\u0010'R*\u0010Q\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bQ\u0010#\u001a\u0004\bQ\u0010%\"\u0004\bR\u0010'R*\u0010S\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bS\u0010#\u001a\u0004\bT\u0010%\"\u0004\bU\u0010'R$\u0010W\u001a\u0004\u0018\u00010V8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bW\u0010X\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R$\u0010^\u001a\u0004\u0018\u00010]8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b^\u0010_\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR$\u0010d\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bd\u0010\u0015\u001a\u0004\be\u0010\u0017\"\u0004\bf\u0010\u0019¨\u0006j"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/pinch/model/VideoPinchConfig;", "", "Lr14/c;", "aweme", "Lr14/c;", "getAweme", "()Lr14/c;", "setAweme", "(Lr14/c;)V", "", "eventType", "Ljava/lang/String;", "getEventType", "()Ljava/lang/String;", "setEventType", "(Ljava/lang/String;)V", "fromPage", "getFromPage", "setFromPage", "", "pageType", "Ljava/lang/Integer;", "getPageType", "()Ljava/lang/Integer;", "setPageType", "(Ljava/lang/Integer;)V", "previousPage", "getPreviousPage", "setPreviousPage", "awemeFromPage", "getAwemeFromPage", "setAwemeFromPage", "Lkotlin/Function0;", "Landroid/view/View;", "originView", "Lkotlin/jvm/functions/Function0;", "getOriginView", "()Lkotlin/jvm/functions/Function0;", "setOriginView", "(Lkotlin/jvm/functions/Function0;)V", "Landroid/view/ViewGroup;", "pinchViewContainer", "Landroid/view/ViewGroup;", "getPinchViewContainer", "()Landroid/view/ViewGroup;", "setPinchViewContainer", "(Landroid/view/ViewGroup;)V", "", "enablePinch", "Ljava/lang/Boolean;", "getEnablePinch", "()Ljava/lang/Boolean;", "setEnablePinch", "(Ljava/lang/Boolean;)V", "supportStableView", "getSupportStableView", "setSupportStableView", "enablePinchPage", "getEnablePinchPage", "setEnablePinchPage", "enableRelated", "Z", "getEnableRelated", "()Z", "setEnableRelated", "(Z)V", "clipChildrenOnAnimationEnd", "getClipChildrenOnAnimationEnd", "setClipChildrenOnAnimationEnd", "isInStoryStartPosition", "setInStoryStartPosition", "slidesPosition", "getSlidesPosition", "setSlidesPosition", "isStoryItemMode", "setStoryItemMode", "isPlaying", "setPlaying", "enablePinchInVideoClip", "getEnablePinchInVideoClip", "setEnablePinchInVideoClip", "isVideoClip", "setVideoClip", "slidesEnterFrom", "getSlidesEnterFrom", "setSlidesEnterFrom", "Landroidx/fragment/app/FragmentActivity;", "activity", "Landroidx/fragment/app/FragmentActivity;", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", "setActivity", "(Landroidx/fragment/app/FragmentActivity;)V", "Landroidx/fragment/app/Fragment;", "fragment", "Landroidx/fragment/app/Fragment;", "getFragment", "()Landroidx/fragment/app/Fragment;", "setFragment", "(Landroidx/fragment/app/Fragment;)V", "pinchBgColor", "getPinchBgColor", "setPinchBgColor", "<init>", "()V", "Builder", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class VideoPinchConfig {
    private FragmentActivity activity;
    private c aweme;
    private Integer awemeFromPage;
    private Boolean clipChildrenOnAnimationEnd;
    private Boolean enablePinch;
    private Function0<Boolean> enablePinchInVideoClip;
    private Boolean enablePinchPage;
    private boolean enableRelated;
    private String eventType;
    private Fragment fragment;
    private String fromPage;
    private Function0<Boolean> isInStoryStartPosition;
    private Function0<Boolean> isPlaying;
    private boolean isStoryItemMode;
    private Function0<Boolean> isVideoClip;
    private Function0<? extends View> originView;
    private Integer pageType;
    private Integer pinchBgColor;
    private ViewGroup pinchViewContainer;
    private String previousPage;
    private Function0<Integer> slidesEnterFrom;
    private Function0<Integer> slidesPosition;
    private Boolean supportStableView;

    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b,\u0010-J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0005J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0005J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\bJ\u0016\u0010\u0010\u001a\u00020\u00002\u000e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rJ\u0014\u0010\u0013\u001a\u00020\u00002\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\rJ\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0014J\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0011J\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0011J\u000e\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0011J\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0011J\u0014\u0010\u001f\u001a\u00020\u00002\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00110\rJ\u0010\u0010\"\u001a\u00020\u00002\b\u0010!\u001a\u0004\u0018\u00010 J\u000e\u0010%\u001a\u00020\u00002\u0006\u0010$\u001a\u00020#J\u0006\u0010'\u001a\u00020&R\u0017\u0010(\u001a\u00020&8\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+¨\u0006."}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/pinch/model/VideoPinchConfig$Builder;", "", "Lr14/c;", "aweme", "ofAweme", "", "eventType", "fromPage", "", "pageType", "page", "previousPage", "awemeFromPage", "Lkotlin/Function0;", "Landroid/view/View;", "oView", "originView", "", "playing", "isPlaying", "Landroid/view/ViewGroup;", "container", "pinchViewContainer", "enable", "enablePinch", "support", "supportStableView", "enablePinchPage", "doClip", "clipChildrenOnAnimationEnd", "check", "isInStoryStartPosition", "Landroidx/fragment/app/FragmentActivity;", "ac", "activity", "Landroidx/fragment/app/Fragment;", "f", "fragment", "Lcom/bytedance/awemeopen/apps/framework/feed/pinch/model/VideoPinchConfig;", "build", "config", "Lcom/bytedance/awemeopen/apps/framework/feed/pinch/model/VideoPinchConfig;", "getConfig", "()Lcom/bytedance/awemeopen/apps/framework/feed/pinch/model/VideoPinchConfig;", "<init>", "()V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
    public static final class Builder {
        private final VideoPinchConfig config;

        public Builder() {
            this.config = new VideoPinchConfig();
        }

        public final VideoPinchConfig build() {
            return this.config;
        }

        public final VideoPinchConfig getConfig() {
            return this.config;
        }

        public final Builder activity(FragmentActivity r2) {
            this.config.setActivity(r2);
            return this;
        }

        public final Builder awemeFromPage(int r2) {
            this.config.setAwemeFromPage(Integer.valueOf(r2));
            return this;
        }

        public final Builder clipChildrenOnAnimationEnd(boolean r2) {
            this.config.setClipChildrenOnAnimationEnd(Boolean.valueOf(r2));
            return this;
        }

        public final Builder enablePinch(boolean r2) {
            this.config.setEnablePinch(Boolean.valueOf(r2));
            return this;
        }

        public final Builder enablePinchPage(boolean r2) {
            this.config.setEnablePinchPage(Boolean.valueOf(r2));
            return this;
        }

        public final Builder eventType(String r2) {
            Intrinsics.checkNotNullParameter(r2, "eventType");
            this.config.setEventType(r2);
            return this;
        }

        public final Builder fragment(Fragment r2) {
            Intrinsics.checkNotNullParameter(r2, "f");
            this.config.setFragment(r2);
            return this;
        }

        public final Builder fromPage(String r2) {
            Intrinsics.checkNotNullParameter(r2, "fromPage");
            this.config.setFromPage(r2);
            return this;
        }

        public final Builder isInStoryStartPosition(Function0<Boolean> r2) {
            Intrinsics.checkNotNullParameter(r2, "check");
            this.config.setInStoryStartPosition(r2);
            return this;
        }

        public final Builder isPlaying(Function0<Boolean> r2) {
            Intrinsics.checkNotNullParameter(r2, "playing");
            this.config.setPlaying(r2);
            return this;
        }

        public final Builder ofAweme(c r2) {
            Intrinsics.checkNotNullParameter(r2, "aweme");
            this.config.setAweme(r2);
            return this;
        }

        public final Builder originView(Function0<? extends View> r2) {
            Intrinsics.checkNotNullParameter(r2, "oView");
            this.config.setOriginView(r2);
            return this;
        }

        public final Builder pageType(int r2) {
            this.config.setPageType(Integer.valueOf(r2));
            return this;
        }

        public final Builder pinchViewContainer(ViewGroup r2) {
            Intrinsics.checkNotNullParameter(r2, "container");
            this.config.setPinchViewContainer(r2);
            return this;
        }

        public final Builder previousPage(String r2) {
            Intrinsics.checkNotNullParameter(r2, "page");
            this.config.setPreviousPage(r2);
            return this;
        }

        public final Builder supportStableView(boolean r2) {
            this.config.setSupportStableView(Boolean.valueOf(r2));
            return this;
        }
    }

    public VideoPinchConfig() {
        this.eventType = "";
        this.fromPage = "";
        this.pageType = 0;
        this.previousPage = "";
        Boolean r0 = Boolean.TRUE;
        this.enablePinch = r0;
        this.supportStableView = r0;
        this.enablePinchPage = r0;
        this.enableRelated = true;
        this.clipChildrenOnAnimationEnd = r0;
    }

    public final FragmentActivity getActivity() {
        return this.activity;
    }

    public final c getAweme() {
        return this.aweme;
    }

    public final Integer getAwemeFromPage() {
        return this.awemeFromPage;
    }

    public final Boolean getClipChildrenOnAnimationEnd() {
        return this.clipChildrenOnAnimationEnd;
    }

    public final Boolean getEnablePinch() {
        return this.enablePinch;
    }

    public final Function0<Boolean> getEnablePinchInVideoClip() {
        return this.enablePinchInVideoClip;
    }

    public final Boolean getEnablePinchPage() {
        return this.enablePinchPage;
    }

    public final boolean getEnableRelated() {
        return this.enableRelated;
    }

    public final String getEventType() {
        return this.eventType;
    }

    public final Fragment getFragment() {
        return this.fragment;
    }

    public final String getFromPage() {
        return this.fromPage;
    }

    public final Function0<View> getOriginView() {
        return this.originView;
    }

    public final Integer getPageType() {
        return this.pageType;
    }

    public final Integer getPinchBgColor() {
        return this.pinchBgColor;
    }

    public final ViewGroup getPinchViewContainer() {
        return this.pinchViewContainer;
    }

    public final String getPreviousPage() {
        return this.previousPage;
    }

    public final Function0<Integer> getSlidesEnterFrom() {
        return this.slidesEnterFrom;
    }

    public final Function0<Integer> getSlidesPosition() {
        return this.slidesPosition;
    }

    public final Boolean getSupportStableView() {
        return this.supportStableView;
    }

    public final Function0<Boolean> isInStoryStartPosition() {
        return this.isInStoryStartPosition;
    }

    public final Function0<Boolean> isPlaying() {
        return this.isPlaying;
    }

    public final boolean isStoryItemMode() {
        return this.isStoryItemMode;
    }

    public final Function0<Boolean> isVideoClip() {
        return this.isVideoClip;
    }

    public final void setActivity(FragmentActivity r1) {
        this.activity = r1;
    }

    public final void setAweme(c r1) {
        this.aweme = r1;
    }

    public final void setAwemeFromPage(Integer r1) {
        this.awemeFromPage = r1;
    }

    public final void setClipChildrenOnAnimationEnd(Boolean r1) {
        this.clipChildrenOnAnimationEnd = r1;
    }

    public final void setEnablePinch(Boolean r1) {
        this.enablePinch = r1;
    }

    public final void setEnablePinchInVideoClip(Function0<Boolean> r1) {
        this.enablePinchInVideoClip = r1;
    }

    public final void setEnablePinchPage(Boolean r1) {
        this.enablePinchPage = r1;
    }

    public final void setEnableRelated(boolean r1) {
        this.enableRelated = r1;
    }

    public final void setEventType(String r1) {
        this.eventType = r1;
    }

    public final void setFragment(Fragment r1) {
        this.fragment = r1;
    }

    public final void setFromPage(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.fromPage = r2;
    }

    public final void setInStoryStartPosition(Function0<Boolean> r1) {
        this.isInStoryStartPosition = r1;
    }

    public final void setOriginView(Function0<? extends View> r1) {
        this.originView = r1;
    }

    public final void setPageType(Integer r1) {
        this.pageType = r1;
    }

    public final void setPinchBgColor(Integer r1) {
        this.pinchBgColor = r1;
    }

    public final void setPinchViewContainer(ViewGroup r1) {
        this.pinchViewContainer = r1;
    }

    public final void setPlaying(Function0<Boolean> r1) {
        this.isPlaying = r1;
    }

    public final void setPreviousPage(String r1) {
        this.previousPage = r1;
    }

    public final void setSlidesEnterFrom(Function0<Integer> r1) {
        this.slidesEnterFrom = r1;
    }

    public final void setSlidesPosition(Function0<Integer> r1) {
        this.slidesPosition = r1;
    }

    public final void setStoryItemMode(boolean r1) {
        this.isStoryItemMode = r1;
    }

    public final void setSupportStableView(Boolean r1) {
        this.supportStableView = r1;
    }

    public final void setVideoClip(Function0<Boolean> r1) {
        this.isVideoClip = r1;
    }
}
