package com.larus.platform.model.video.business;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u0000  2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001 B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001aH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018¨\u0006!"}, d2 = {"Lcom/larus/platform/model/video/business/EnterVideoMethod;", "Landroid/os/Parcelable;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", UserProfileEvent.POSITION_NONE, "MAIN_DOUBLE_TAG", "INDEPENDENT_DOU_YIN_BOT", "BOTTOM_TAB", "OUTER_PUSH", "SEARCH_VIDEO_PAGE", "WELCOME_BACK_AWEME_VIDEO_CARD_LIST", "COLLECTION_VIDEO_PAGE", "CLICK_MUSIC_FLOAT_WINDOW", "CLICK_NOTIFY_BANNER", "FLOW_CLICK_ONLY_VIDEO", "VLM", "VLM_SEARCH_AWEME", "FLOW_CLICK_MIXED_VIDEO_CARD", "FLOW_CLICK_RECOMMEND_VIDEO_CARD", "POI_VIDEO_PAGE", "describeContents", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "CREATOR", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum EnterVideoMethod extends Enum<EnterVideoMethod> implements Parcelable {
    public static final EnterVideoMethod BOTTOM_TAB = null;
    public static final EnterVideoMethod CLICK_MUSIC_FLOAT_WINDOW = null;
    public static final EnterVideoMethod CLICK_NOTIFY_BANNER = null;
    public static final EnterVideoMethod COLLECTION_VIDEO_PAGE = null;
    public static final a CREATOR = null;
    public static final EnterVideoMethod FLOW_CLICK_MIXED_VIDEO_CARD = null;
    public static final EnterVideoMethod FLOW_CLICK_ONLY_VIDEO = null;
    public static final EnterVideoMethod FLOW_CLICK_RECOMMEND_VIDEO_CARD = null;
    public static final EnterVideoMethod INDEPENDENT_DOU_YIN_BOT = null;
    public static final EnterVideoMethod MAIN_DOUBLE_TAG = null;
    public static final EnterVideoMethod NONE = null;
    public static final EnterVideoMethod OUTER_PUSH = null;
    public static final EnterVideoMethod POI_VIDEO_PAGE = null;
    public static final EnterVideoMethod SEARCH_VIDEO_PAGE = null;
    public static final EnterVideoMethod VLM = null;
    public static final EnterVideoMethod VLM_SEARCH_AWEME = null;
    public static final EnterVideoMethod WELCOME_BACK_AWEME_VIDEO_CARD_LIST = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EnterVideoMethod[] f365665a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f365666b = null;
    private final String value;

    public static EnumEntries<EnterVideoMethod> getEntries() {
        return f365666b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX WARN: Type inference failed for: r0v16, types: [com.larus.platform.model.video.business.EnterVideoMethod$a] */
    static {
        EnterVideoMethod r100 = new EnterVideoMethod(UserProfileEvent.POSITION_NONE, 0, "");
        NONE = r100;
        EnterVideoMethod r101 = new EnterVideoMethod("MAIN_DOUBLE_TAG", 1, "chat_feed_tab");
        MAIN_DOUBLE_TAG = r101;
        EnterVideoMethod r102 = new EnterVideoMethod("INDEPENDENT_DOU_YIN_BOT", 2, "chat_list_landing");
        INDEPENDENT_DOU_YIN_BOT = r102;
        EnterVideoMethod r103 = new EnterVideoMethod("BOTTOM_TAB", 3, "flow_click_navigate_video");
        BOTTOM_TAB = r103;
        EnterVideoMethod r104 = new EnterVideoMethod("OUTER_PUSH", 4, "flow_outer_push");
        OUTER_PUSH = r104;
        EnterVideoMethod r105 = new EnterVideoMethod("SEARCH_VIDEO_PAGE", 5, "flow_click_video_card");
        SEARCH_VIDEO_PAGE = r105;
        EnterVideoMethod r110 = new EnterVideoMethod("WELCOME_BACK_AWEME_VIDEO_CARD_LIST", 6, "flow_click_onboarding");
        WELCOME_BACK_AWEME_VIDEO_CARD_LIST = r110;
        EnterVideoMethod r111 = new EnterVideoMethod("COLLECTION_VIDEO_PAGE", 7, "click_collection");
        COLLECTION_VIDEO_PAGE = r111;
        EnterVideoMethod r112 = new EnterVideoMethod("CLICK_MUSIC_FLOAT_WINDOW", 8, "click_music_float_window");
        CLICK_MUSIC_FLOAT_WINDOW = r112;
        EnterVideoMethod r113 = new EnterVideoMethod("CLICK_NOTIFY_BANNER", 9, "click_notify_banner");
        CLICK_NOTIFY_BANNER = r113;
        EnterVideoMethod r106 = new EnterVideoMethod("FLOW_CLICK_ONLY_VIDEO", 10, "flow_click_only_video");
        FLOW_CLICK_ONLY_VIDEO = r106;
        EnterVideoMethod r107 = new EnterVideoMethod("VLM", 11, "vlm");
        VLM = r107;
        EnterVideoMethod r108 = new EnterVideoMethod("VLM_SEARCH_AWEME", 12, "vlm_search_aweme");
        VLM_SEARCH_AWEME = r108;
        EnterVideoMethod r109 = new EnterVideoMethod("FLOW_CLICK_MIXED_VIDEO_CARD", 13, "flow_click_mixed_video_card");
        FLOW_CLICK_MIXED_VIDEO_CARD = r109;
        EnterVideoMethod r114 = new EnterVideoMethod("FLOW_CLICK_RECOMMEND_VIDEO_CARD", 14, "flow_click_recommend_video_card");
        FLOW_CLICK_RECOMMEND_VIDEO_CARD = r114;
        EnterVideoMethod r115 = new EnterVideoMethod("POI_VIDEO_PAGE", 15, "poi_video_page");
        POI_VIDEO_PAGE = r115;
        EnterVideoMethod[] r116 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r106, r107, r108, r109, r114, r115};
        f365665a = r116;
        f365666b = EnumEntriesKt.enumEntries(r116);
        CREATOR = new a();
    }

    public static EnterVideoMethod[] values() {
        return (EnterVideoMethod[]) f365665a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static EnterVideoMethod valueOf(String r100) {
        return (EnterVideoMethod) r27.a.a(EnterVideoMethod.class, r100);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeInt(ordinal());
    }

    public EnterVideoMethod(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
