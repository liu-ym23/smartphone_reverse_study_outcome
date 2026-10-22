package com.larus.platform.model.video.business;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b&\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 w2\u00020\u0001:\u0001wB\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0018\u0010s\u001a\u00020t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010u\u001a\u00020\bH\u0016J\b\u0010v\u001a\u00020\bH\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0019\"\u0004\b'\u0010\u001bR\"\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010*0)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001c\u0010/\u001a\u0004\u0018\u00010*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001a\u00104\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0010\"\u0004\b6\u0010\u0012R\u001a\u00107\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0010\"\u0004\b9\u0010\u0012R\u001a\u0010:\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u0010\"\u0004\b<\u0010\u0012R\u001a\u0010=\u001a\u00020>X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001a\u0010C\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\n\"\u0004\bE\u0010\fR\u001a\u0010F\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\n\"\u0004\bH\u0010\fR\u001a\u0010I\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\n\"\u0004\bK\u0010\fR\u001a\u0010L\u001a\u00020MX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u001c\u0010R\u001a\u0004\u0018\u00010*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u00101\"\u0004\bT\u00103R\u001a\u0010U\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010\u0010\"\u0004\bW\u0010\u0012R\u001a\u0010X\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010\u0010\"\u0004\bZ\u0010\u0012R\u001a\u0010[\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010\u0010\"\u0004\b]\u0010\u0012R\u001a\u0010^\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010\u0010\"\u0004\b`\u0010\u0012R\u001a\u0010a\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010\u0010\"\u0004\bc\u0010\u0012R\u001c\u0010d\u001a\u0004\u0018\u00010*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u00101\"\u0004\bf\u00103R\u001c\u0010g\u001a\u0004\u0018\u00010*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u00101\"\u0004\bi\u00103R\u001a\u0010j\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010\n\"\u0004\bl\u0010\fR\u001a\u0010m\u001a\u00020MX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010O\"\u0004\bo\u0010QR\u001a\u0010p\u001a\u00020MX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u0010O\"\u0004\br\u0010Q¨\u0006x"}, d2 = {"Lcom/larus/platform/model/video/business/VideoFeedConfigure;", "Landroid/os/Parcelable;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "bottomMarginPxIfNotFullScreen", "", "getBottomMarginPxIfNotFullScreen", "()I", "setBottomMarginPxIfNotFullScreen", "(I)V", "ignoreUserPauseOrPlay", "", "getIgnoreUserPauseOrPlay", "()Z", "setIgnoreUserPauseOrPlay", "(Z)V", "ignoreReportLeaveVideoPlayer", "getIgnoreReportLeaveVideoPlayer", "setIgnoreReportLeaveVideoPlayer", "hostCommonParams", "Lorg/json/JSONObject;", "getHostCommonParams", "()Lorg/json/JSONObject;", "setHostCommonParams", "(Lorg/json/JSONObject;)V", "interactiveRecInfoParams", "getInteractiveRecInfoParams", "setInteractiveRecInfoParams", "enterVideoMethod", "Lcom/larus/platform/model/video/business/EnterVideoMethod;", "getEnterVideoMethod", "()Lcom/larus/platform/model/video/business/EnterVideoMethod;", "setEnterVideoMethod", "(Lcom/larus/platform/model/video/business/EnterVideoMethod;)V", "leavePageTrackJson", "getLeavePageTrackJson", "setLeavePageTrackJson", "itemIDList", "", "", "getItemIDList", "()Ljava/util/List;", "setItemIDList", "(Ljava/util/List;)V", "enterItemID", "getEnterItemID", "()Ljava/lang/String;", "setEnterItemID", "(Ljava/lang/String;)V", "needCachedRecommendFeed", "getNeedCachedRecommendFeed", "setNeedCachedRecommendFeed", "showLeftBackButton", "getShowLeftBackButton", "setShowLeftBackButton", "fullScreen", "getFullScreen", "setFullScreen", "hostCoverAspectRatio", "", "getHostCoverAspectRatio", "()F", "setHostCoverAspectRatio", "(F)V", "coverWidth", "getCoverWidth", "setCoverWidth", "coverHeight", "getCoverHeight", "setCoverHeight", "excludedHeight", "getExcludedHeight", "setExcludedHeight", "doubleBallLoadingDelay", "", "getDoubleBallLoadingDelay", "()J", "setDoubleBallLoadingDelay", "(J)V", "hostCoverUrl", "getHostCoverUrl", "setHostCoverUrl", "needCustomLoadMore", "getNeedCustomLoadMore", "setNeedCustomLoadMore", "needRefresh", "getNeedRefresh", "setNeedRefresh", "shouldPaddingStatusBarHeight", "getShouldPaddingStatusBarHeight", "setShouldPaddingStatusBarHeight", "showCommentSwitch", "getShowCommentSwitch", "setShowCommentSwitch", "showCollect", "getShowCollect", "setShowCollect", "eventPage", "getEventPage", "setEventPage", "sceneID", "getSceneID", "setSceneID", "commentBottomMargin", "getCommentBottomMargin", "setCommentBottomMargin", "userID", "getUserID", "setUserID", "startPlayPosition", "getStartPlayPosition", "setStartPlayPosition", "writeToParcel", "", "flags", "describeContents", "CREATOR", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VideoFeedConfigure implements Parcelable {
    public static final a CREATOR = null;
    public long A;
    public long B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f365669a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f365670b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f365671c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public JSONObject f365672d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public JSONObject f365673e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public EnterVideoMethod f365674f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public JSONObject f365675g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List<String> f365676h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f365677i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f365678j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f365679k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f365680l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f365681m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f365682n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f365683o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f365684p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f365685q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f365686r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f365687s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f365688t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f365689u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f365690v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f365691w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f365692x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f365693y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f365694z;

    public static final class a implements Parcelable.Creator<VideoFeedConfigure> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final VideoFeedConfigure createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            Intrinsics.checkNotNullParameter(r100, "parcel");
            VideoFeedConfigure r101 = new VideoFeedConfigure();
            r101.f365674f = (EnterVideoMethod) r100.readParcelable(EnterVideoMethod.class.getClassLoader());
            ArrayList r102 = new ArrayList();
            r100.readStringList(r102);
            r101.f365676h = r102;
            boolean r103 = true;
            if (r100.readByte() == 0) goto L5;
            boolean r104 = true;
        L6:
            r101.f365678j = r104;
            if (r100.readByte() == 0) goto L9;
            boolean r105 = true;
        L10:
            r101.f365679k = r105;
            if (r100.readByte() == 0) goto L13;
            boolean r106 = true;
        L14:
            r101.f365690v = r106;
            if (r100.readByte() == 0) goto L17;
            boolean r107 = true;
        L18:
            r101.f365691w = r107;
            r101.f365692x = r100.readString();
            r101.f365693y = r100.readString();
            r101.f365677i = r100.readString();
            if (r100.readByte() == 0) goto L21;
            boolean r108 = true;
        L22:
            r101.f365687s = r108;
            if (r100.readByte() == 0) goto L25;
            boolean r109 = true;
        L26:
            r101.f365688t = r109;
            if (r100.readByte() == 0) goto L29;
            boolean r110 = true;
        L30:
            r101.f365689u = r110;
            String r111 = r100.readString();
            String r112 = "";
            if (r111 != null) goto L33;
            r111 = "";
        L33:
            r101.f365672d = new JSONObject(r111);
            String r113 = r100.readString();
            if (r113 == null) goto L37;
            r112 = r113;
        L37:
            r101.f365673e = new JSONObject(r112);
            if (r100.readByte() == 0) goto L40;
            boolean r114 = true;
        L41:
            r101.f365680l = r114;
            r101.f365694z = r100.readInt();
            r101.f365669a = r100.readInt();
            r101.f365686r = r100.readString();
            r101.f365681m = r100.readFloat();
            r101.f365685q = r100.readLong();
            r101.f365683o = r100.readInt();
            r101.f365682n = r100.readInt();
            r101.f365684p = r100.readInt();
            r101.A = r100.readLong();
            if (r100.readByte() == 0) goto L44;
            boolean r115 = true;
        L45:
            r101.f365670b = r115;
            if (r100.readByte() != 0) goto L49;
            r103 = false;
        L49:
            r101.f365671c = r103;
            r101.B = r100.readLong();
            return r101;
        L44:
            r115 = false;
            goto L45
        L40:
            r114 = false;
            goto L41
        L29:
            r110 = false;
            goto L30
        L25:
            r109 = false;
            goto L26
        L21:
            r108 = false;
            goto L22
        L17:
            r107 = false;
            goto L18
        L13:
            r106 = false;
            goto L14
        L9:
            r105 = false;
            goto L10
        L5:
            r104 = false;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final VideoFeedConfigure[] newArray(int r100) {
            return new VideoFeedConfigure[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public VideoFeedConfigure() {
        this.f365669a = -1;
        this.f365670b = true;
        this.f365672d = new JSONObject();
        this.f365673e = new JSONObject();
        this.f365674f = EnterVideoMethod.MAIN_DOUBLE_TAG;
        this.f365675g = new JSONObject();
        this.f365676h = CollectionsKt.emptyList();
        this.f365677i = "";
        this.f365678j = true;
        this.f365679k = true;
        this.f365680l = true;
        this.f365685q = 300;
        this.f365688t = true;
        this.f365690v = true;
        this.f365691w = true;
        this.f365692x = "";
        this.f365693y = "";
        this.A = -1;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeParcelable(this.f365674f, r101);
        r100.writeStringList(this.f365676h);
        r100.writeByte(this.f365678j ? 1 : 0);
        r100.writeByte(this.f365679k ? 1 : 0);
        r100.writeByte(this.f365690v ? 1 : 0);
        r100.writeByte(this.f365691w ? 1 : 0);
        r100.writeString(this.f365692x);
        r100.writeString(this.f365693y);
        r100.writeString(this.f365677i);
        r100.writeByte(this.f365687s ? 1 : 0);
        r100.writeByte(this.f365688t ? 1 : 0);
        r100.writeByte(this.f365689u ? 1 : 0);
        r100.writeString(this.f365672d.toString());
        r100.writeString(this.f365673e.toString());
        r100.writeByte(this.f365680l ? 1 : 0);
        r100.writeInt(this.f365694z);
        r100.writeInt(this.f365669a);
        r100.writeString(this.f365686r);
        r100.writeFloat(this.f365681m);
        r100.writeLong(this.f365685q);
        r100.writeInt(this.f365683o);
        r100.writeInt(this.f365682n);
        r100.writeInt(this.f365684p);
        r100.writeLong(this.A);
        r100.writeByte(this.f365670b ? 1 : 0);
        r100.writeByte(this.f365671c ? 1 : 0);
        r100.writeLong(this.B);
    }
}
