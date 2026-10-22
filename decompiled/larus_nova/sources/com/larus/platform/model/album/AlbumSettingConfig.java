package com.larus.platform.model.album;

import com.larus.platform.model.preview.InputDraftSnapshot;
import com.larus.platform.model.preview.MediaEntry;
import com.larus.platform.service.z2;
import dr9.g;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 p2\u00020\u0001:\u0002pqB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010k\u001a\u00020\u0005H\u0016J\b\u0010l\u001a\u00020\u0013H\u0016J\u0013\u0010m\u001a\u00020\u000e2\b\u0010n\u001a\u0004\u0018\u00010oH\u0096\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\u001a\u0010\u001b\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011R\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010$\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0007\"\u0004\b&\u0010\tR\u001a\u0010'\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u000f\"\u0004\b)\u0010\u0011R\u001a\u0010*\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0015\"\u0004\b,\u0010\u0017R\u001a\u0010-\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u000f\"\u0004\b/\u0010\u0011R\u001c\u00100\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0007\"\u0004\b2\u0010\tR\u001c\u00103\u001a\u0004\u0018\u000104X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001a\u00109\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u000f\"\u0004\b;\u0010\u0011R\u001a\u0010<\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u000f\"\u0004\b>\u0010\u0011R\u001e\u0010?\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u0010\n\u0002\u0010D\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u001c\u0010E\u001a\u0004\u0018\u00010FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001a\u0010K\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\u000f\"\u0004\bM\u0010\u0011R\u001a\u0010N\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\u000f\"\u0004\bP\u0010\u0011R\u001e\u0010Q\u001a\u0004\u0018\u00010RX\u0086\u000e¢\u0006\u0010\n\u0002\u0010W\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\u001c\u0010X\u001a\u0004\u0018\u00010YX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\u001a\u0010^\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010\u000f\"\u0004\b_\u0010\u0011R\u001e\u0010`\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\ba\u0010 \"\u0004\bb\u0010\"R\u001a\u0010c\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010\u000f\"\u0004\be\u0010\u0011R\u001a\u0010f\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010\u000f\"\u0004\bh\u0010\u0011R\u001a\u0010i\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010\u000f\"\u0004\bj\u0010\u0011¨\u0006r"}, d2 = {"Lcom/larus/platform/model/album/AlbumSettingConfig;", "Ljava/io/Serializable;", "<init>", "()V", "albumNodeId", "", "getAlbumNodeId", "()Ljava/lang/String;", "setAlbumNodeId", "(Ljava/lang/String;)V", "upstreamAlbumNodeId", "getUpstreamAlbumNodeId", "setUpstreamAlbumNodeId", "isMultiPick", "", "()Z", "setMultiPick", "(Z)V", "maxSelectCount", "", "getMaxSelectCount", "()I", "setMaxSelectCount", "(I)V", "spanCount", "getSpanCount", "setSpanCount", "supportVideo", "getSupportVideo", "setSupportVideo", "landingTabIndex", "getLandingTabIndex", "()Ljava/lang/Integer;", "setLandingTabIndex", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "clickFrom", "getClickFrom", "setClickFrom", "onlyDisplayVideo", "getOnlyDisplayVideo", "setOnlyDisplayVideo", "maxSelectVideoCount", "getMaxSelectVideoCount", "setMaxSelectVideoCount", "enableInjectInput", "getEnableInjectInput", "setEnableInjectInput", "suggestedActionProvider", "getSuggestedActionProvider", "setSuggestedActionProvider", "initialInputState", "Lcom/larus/platform/model/album/AlbumInputState;", "getInitialInputState", "()Lcom/larus/platform/model/album/AlbumInputState;", "setInitialInputState", "(Lcom/larus/platform/model/album/AlbumInputState;)V", "allowUnifiedPreview", "getAllowUnifiedPreview", "setAllowUnifiedPreview", "mobilePreviewHostEnabled", "getMobilePreviewHostEnabled", "setMobilePreviewHostEnabled", "useUnifiedMediaCanvas", "getUseUnifiedMediaCanvas", "()Ljava/lang/Boolean;", "setUseUnifiedMediaCanvas", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "unifiedPreviewEntry", "Lcom/larus/platform/model/preview/MediaEntry;", "getUnifiedPreviewEntry", "()Lcom/larus/platform/model/preview/MediaEntry;", "setUnifiedPreviewEntry", "(Lcom/larus/platform/model/preview/MediaEntry;)V", "hideAlbumEntranceInInjectedInput", "getHideAlbumEntranceInInjectedInput", "setHideAlbumEntranceInInjectedInput", "enableSeparateMediaSelection", "getEnableSeparateMediaSelection", "setEnableSeparateMediaSelection", "maxVideoDuration", "", "getMaxVideoDuration", "()Ljava/lang/Long;", "setMaxVideoDuration", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "creationReferenceConfig", "Lcom/larus/platform/model/album/CreationReferenceAlbumConfig;", "getCreationReferenceConfig", "()Lcom/larus/platform/model/album/CreationReferenceAlbumConfig;", "setCreationReferenceConfig", "(Lcom/larus/platform/model/album/CreationReferenceAlbumConfig;)V", "isUseSingleDefault", "setUseSingleDefault", "startNavigationBarColor", "getStartNavigationBarColor", "setStartNavigationBarColor", "enableMultiSelectConfirmed", "getEnableMultiSelectConfirmed", "setEnableMultiSelectConfirmed", "supportOriginalImage", "getSupportOriginalImage", "setSupportOriginalImage", "isCreationScene", "setCreationScene", "toString", "hashCode", "equals", "other", "", "Companion", "Builder", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AlbumSettingConfig implements Serializable {
    public static final b Companion = null;
    private String albumNodeId;
    private boolean allowUnifiedPreview;
    private String clickFrom;
    private CreationReferenceAlbumConfig creationReferenceConfig;
    private boolean enableInjectInput;
    private boolean enableMultiSelectConfirmed;
    private boolean enableSeparateMediaSelection;
    private boolean hideAlbumEntranceInInjectedInput;
    private AlbumInputState initialInputState;
    private boolean isCreationScene;
    private boolean isMultiPick;
    private boolean isUseSingleDefault;
    private Integer landingTabIndex;
    private int maxSelectCount;
    private int maxSelectVideoCount;
    private Long maxVideoDuration;
    private boolean mobilePreviewHostEnabled;
    private boolean onlyDisplayVideo;
    private int spanCount;
    private Integer startNavigationBarColor;
    private String suggestedActionProvider;
    private boolean supportOriginalImage;
    private boolean supportVideo;
    private MediaEntry unifiedPreviewEntry;
    private String upstreamAlbumNodeId;
    private Boolean useUnifiedMediaCanvas;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f365515a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f365516b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f365517c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f365518d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f365519e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f365520f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Integer f365521g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f365522h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f365523i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Integer f365524j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f365525k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public AlbumInputState f365526l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f365527m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f365528n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public Boolean f365529o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public MediaEntry f365530p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public boolean f365531q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public boolean f365532r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public boolean f365533s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public int f365534t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public boolean f365535u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public long f365536v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public CreationReferenceAlbumConfig f365537w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public boolean f365538x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public boolean f365539y;

        public final AlbumSettingConfig a() {
            AlbumSettingConfig r100 = new AlbumSettingConfig(null);
            r100.setAlbumNodeId(this.f365515a);
            r100.setUpstreamAlbumNodeId(this.f365516b);
            r100.setMaxSelectCount(this.f365518d);
            r100.setUseSingleDefault(this.f365519e);
            r100.setClickFrom(this.f365520f);
            r100.setStartNavigationBarColor(this.f365521g);
            r100.setSpanCount(this.f365522h);
            r100.setSupportVideo(this.f365523i);
            r100.setLandingTabIndex(this.f365524j);
            r100.setEnableInjectInput(this.f365525k);
            r100.setSuggestedActionProvider(null);
            r100.setInitialInputState(this.f365526l);
            r100.setAllowUnifiedPreview(this.f365527m);
            r100.setMobilePreviewHostEnabled(this.f365528n);
            r100.setUseUnifiedMediaCanvas(this.f365529o);
            r100.setUnifiedPreviewEntry(this.f365530p);
            r100.setHideAlbumEntranceInInjectedInput(this.f365531q);
            r100.setOnlyDisplayVideo(this.f365532r);
            r100.setEnableSeparateMediaSelection(this.f365533s);
            r100.setMaxSelectVideoCount(this.f365534t);
            r100.setMultiPick(this.f365517c);
            r100.setEnableMultiSelectConfirmed(this.f365535u);
            r100.setMaxVideoDuration(Long.valueOf(this.f365536v));
            r100.setCreationReferenceConfig(this.f365537w);
            r100.setSupportOriginalImage(this.f365538x);
            r100.setCreationScene(this.f365539y);
            return r100;
        }

        public a() {
            Map<String, Integer> r100 = kq9.b.f505614a;
            this.f365515a = g.e("album-node");
            this.f365516b = "";
            this.f365518d = 1;
            this.f365522h = z2.f365865a.n1().f505656c;
            this.f365524j = 0;
            this.f365534t = -1;
        }

        public final void b(AlbumInputState r110) {
            AlbumInputState r100 = null;
            String r101 = null;
            if (r110 != null) goto L5;
        L27:
            this.f365526l = r100;
            return;
        L5:
            if (r110.getAttachments().isEmpty() == true) goto L26;
            String r102 = r110.getInputSnapshotId();
            if (r102 == null) goto L24;
            g r103 = g.f469794a;
            InputDraftSnapshot r104 = g.d(r102);
            boolean r105 = false;
            if (r104 != null) goto L12;
        L21:
            if (r105 == false) goto L23;
            r101 = r102;
        L23:
            if (r101 == null) goto L24;
        L25:
            List r106 = CollectionsKt.emptyList();
            r110 = AlbumInputState.copy$default(r110, null, r106, null, r101, null, 21, null);
            goto L26
        L12:
            if (Intrinsics.areEqual(r104.getText(), r110.getText()) == true) goto L14;
        L18:
            boolean r107 = false;
        L19:
            if (r107 != true) goto L21;
            r105 = true;
            goto L21
        L14:
            if (Intrinsics.areEqual(r104.getSourceNodeId(), r110.getSourceNodeId()) == false) goto L18;
            if (Intrinsics.areEqual(r104.getAttachments(), r110.getAttachments()) == false) goto L18;
            r107 = true;
        L24:
            r101 = g.f469794a.b(new InputDraftSnapshot(r110.getText(), r110.getAttachments(), r110.getSourceNodeId(), 0, 8, null));
        L26:
            r100 = r110;
            goto L27
        }

        public final void c(MediaEntry r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            this.f365530p = r100;
        }
    }

    public static final class b {
        public static AlbumSettingConfig a() {
            return new a().a();
        }

        public b() {
        }
    }

    static {
        Companion = new b();
    }

    public /* synthetic */ AlbumSettingConfig(DefaultConstructorMarker r100) {
        this();
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("isMultiPick=");
        r100.append(this.isMultiPick);
        r100.append(", maxSelectCount=");
        r100.append(this.maxSelectCount);
        r100.append(", isUseSingleDefault=");
        r100.append(this.isUseSingleDefault);
        r100.append(", clickFrom=");
        r100.append(this.clickFrom);
        r100.append(", startNavigationBarColor=");
        r100.append(this.startNavigationBarColor);
        r100.append(", spanCount=");
        r100.append(this.spanCount);
        r100.append(", supportVideo=");
        r100.append(this.supportVideo);
        r100.append(", landingTabIndex=");
        r100.append(this.landingTabIndex);
        r100.append(", enableInput=");
        r100.append(this.enableInjectInput);
        r100.append(", suggestedActionProvider=");
        r100.append(this.suggestedActionProvider);
        r100.append(", initialInputStateHash=");
        AlbumInputState r101 = this.initialInputState;
        if (r101 == null) goto L5;
        Integer r102 = Integer.valueOf(r101.hashCode());
    L6:
        r100.append(r102);
        r100.append(", allowUnifiedPreview=");
        r100.append(this.allowUnifiedPreview);
        r100.append(", hideAlbumEntranceInInjectedInput=");
        r100.append(this.hideAlbumEntranceInInjectedInput);
        r100.append(", onlyDisplayVideo=");
        r100.append(this.onlyDisplayVideo);
        r100.append(", enableSeparateMediaSelection=");
        r100.append(this.enableSeparateMediaSelection);
        r100.append(", maxSelectVideoCount=");
        r100.append(this.maxSelectVideoCount);
        r100.append(", maxVideoDuration=");
        r100.append(this.maxVideoDuration);
        r100.append(", isCreationScene=");
        r100.append(this.isCreationScene);
        return r100.toString();
    L5:
        r102 = null;
        goto L6
    }

    private AlbumSettingConfig() {
        Map<String, Integer> r100 = kq9.b.f505614a;
        this.albumNodeId = g.e("album-node");
        this.upstreamAlbumNodeId = "";
        this.maxSelectCount = 1;
        this.spanCount = 4;
        this.landingTabIndex = 0;
        this.maxSelectVideoCount = -1;
        this.maxVideoDuration = 0L;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public final String getAlbumNodeId() {
        return this.albumNodeId;
    }

    public final boolean getAllowUnifiedPreview() {
        return this.allowUnifiedPreview;
    }

    public final String getClickFrom() {
        return this.clickFrom;
    }

    public final CreationReferenceAlbumConfig getCreationReferenceConfig() {
        return this.creationReferenceConfig;
    }

    public final boolean getEnableInjectInput() {
        return this.enableInjectInput;
    }

    public final boolean getEnableMultiSelectConfirmed() {
        return this.enableMultiSelectConfirmed;
    }

    public final boolean getEnableSeparateMediaSelection() {
        return this.enableSeparateMediaSelection;
    }

    public final boolean getHideAlbumEntranceInInjectedInput() {
        return this.hideAlbumEntranceInInjectedInput;
    }

    public final AlbumInputState getInitialInputState() {
        return this.initialInputState;
    }

    public final Integer getLandingTabIndex() {
        return this.landingTabIndex;
    }

    public final int getMaxSelectCount() {
        return this.maxSelectCount;
    }

    public final int getMaxSelectVideoCount() {
        return this.maxSelectVideoCount;
    }

    public final Long getMaxVideoDuration() {
        return this.maxVideoDuration;
    }

    public final boolean getMobilePreviewHostEnabled() {
        return this.mobilePreviewHostEnabled;
    }

    public final boolean getOnlyDisplayVideo() {
        return this.onlyDisplayVideo;
    }

    public final int getSpanCount() {
        return this.spanCount;
    }

    public final Integer getStartNavigationBarColor() {
        return this.startNavigationBarColor;
    }

    public final String getSuggestedActionProvider() {
        return this.suggestedActionProvider;
    }

    public final boolean getSupportOriginalImage() {
        return this.supportOriginalImage;
    }

    public final boolean getSupportVideo() {
        return this.supportVideo;
    }

    public final MediaEntry getUnifiedPreviewEntry() {
        return this.unifiedPreviewEntry;
    }

    public final String getUpstreamAlbumNodeId() {
        return this.upstreamAlbumNodeId;
    }

    public final Boolean getUseUnifiedMediaCanvas() {
        return this.useUnifiedMediaCanvas;
    }

    public final boolean isCreationScene() {
        return this.isCreationScene;
    }

    public final boolean isMultiPick() {
        return this.isMultiPick;
    }

    public final boolean isUseSingleDefault() {
        return this.isUseSingleDefault;
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof AlbumSettingConfig) == true) goto L7;
        return false;
    L7:
        return Intrinsics.areEqual(toString(), ((AlbumSettingConfig) r100).toString());
    }

    public final void setAlbumNodeId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.albumNodeId = r100;
    }

    public final void setAllowUnifiedPreview(boolean r100) {
        this.allowUnifiedPreview = r100;
    }

    public final void setClickFrom(String r100) {
        this.clickFrom = r100;
    }

    public final void setCreationReferenceConfig(CreationReferenceAlbumConfig r100) {
        this.creationReferenceConfig = r100;
    }

    public final void setCreationScene(boolean r100) {
        this.isCreationScene = r100;
    }

    public final void setEnableInjectInput(boolean r100) {
        this.enableInjectInput = r100;
    }

    public final void setEnableMultiSelectConfirmed(boolean r100) {
        this.enableMultiSelectConfirmed = r100;
    }

    public final void setEnableSeparateMediaSelection(boolean r100) {
        this.enableSeparateMediaSelection = r100;
    }

    public final void setHideAlbumEntranceInInjectedInput(boolean r100) {
        this.hideAlbumEntranceInInjectedInput = r100;
    }

    public final void setInitialInputState(AlbumInputState r100) {
        this.initialInputState = r100;
    }

    public final void setLandingTabIndex(Integer r100) {
        this.landingTabIndex = r100;
    }

    public final void setMaxSelectCount(int r100) {
        this.maxSelectCount = r100;
    }

    public final void setMaxSelectVideoCount(int r100) {
        this.maxSelectVideoCount = r100;
    }

    public final void setMaxVideoDuration(Long r100) {
        this.maxVideoDuration = r100;
    }

    public final void setMobilePreviewHostEnabled(boolean r100) {
        this.mobilePreviewHostEnabled = r100;
    }

    public final void setMultiPick(boolean r100) {
        this.isMultiPick = r100;
    }

    public final void setOnlyDisplayVideo(boolean r100) {
        this.onlyDisplayVideo = r100;
    }

    public final void setSpanCount(int r100) {
        this.spanCount = r100;
    }

    public final void setStartNavigationBarColor(Integer r100) {
        this.startNavigationBarColor = r100;
    }

    public final void setSuggestedActionProvider(String r100) {
        this.suggestedActionProvider = r100;
    }

    public final void setSupportOriginalImage(boolean r100) {
        this.supportOriginalImage = r100;
    }

    public final void setSupportVideo(boolean r100) {
        this.supportVideo = r100;
    }

    public final void setUnifiedPreviewEntry(MediaEntry r100) {
        this.unifiedPreviewEntry = r100;
    }

    public final void setUpstreamAlbumNodeId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.upstreamAlbumNodeId = r100;
    }

    public final void setUseSingleDefault(boolean r100) {
        this.isUseSingleDefault = r100;
    }

    public final void setUseUnifiedMediaCanvas(Boolean r100) {
        this.useUnifiedMediaCanvas = r100;
    }
}
