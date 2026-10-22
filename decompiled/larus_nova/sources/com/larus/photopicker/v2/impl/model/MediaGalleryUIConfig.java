package com.larus.photopicker.v2.impl.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.larus.platform.model.MediaPickerUIMode;
import com.larus.platform.model.preview.MediaEntry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\bT\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u0080\u00012\u00020\u0001:\u0004\u0080\u0001\u0081\u0001BÇ\u0002\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\u0006\u0010\u0010\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0006\u0012\u0006\u0010\u0012\u001a\u00020\u0006\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0015\u001a\u00020\u0006\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0017\u001a\u00020\t\u0012\b\b\u0002\u0010\u0018\u001a\u00020\t\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u001c\u001a\u00020\r\u0012\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u0003\u0012\b\b\u0002\u0010\u001e\u001a\u00020\r\u0012\b\b\u0002\u0010\u001f\u001a\u00020\r\u0012\b\b\u0002\u0010 \u001a\u00020\t\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\"\u001a\u00020\t\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$\u0012\b\b\u0002\u0010%\u001a\u00020\t\u0012\b\b\u0002\u0010&\u001a\u00020\t\u0012\b\b\u0002\u0010'\u001a\u00020\t\u0012\b\b\u0002\u0010(\u001a\u00020\u0006¢\u0006\u0004\b)\u0010*J\b\u0010S\u001a\u00020\rH\u0016J\u000f\u0010T\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010U\u001a\u00020\u0006HÆ\u0003J\t\u0010V\u001a\u00020\u0006HÆ\u0003J\t\u0010W\u001a\u00020\tHÆ\u0003J\t\u0010X\u001a\u00020\u000bHÆ\u0003J\t\u0010Y\u001a\u00020\rHÆ\u0003J\t\u0010Z\u001a\u00020\tHÆ\u0003J\t\u0010[\u001a\u00020\u0006HÆ\u0003J\t\u0010\\\u001a\u00020\u0006HÆ\u0003J\t\u0010]\u001a\u00020\u0006HÆ\u0003J\t\u0010^\u001a\u00020\u0006HÆ\u0003J\u0010\u0010_\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010:J\u0010\u0010`\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010:J\t\u0010a\u001a\u00020\u0006HÆ\u0003J\u0010\u0010b\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010:J\t\u0010c\u001a\u00020\tHÆ\u0003J\t\u0010d\u001a\u00020\tHÆ\u0003J\u000b\u0010e\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010f\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010g\u001a\u0004\u0018\u00010\rHÆ\u0003J\t\u0010h\u001a\u00020\rHÆ\u0003J\u000f\u0010i\u001a\b\u0012\u0004\u0012\u00020\r0\u0003HÆ\u0003J\t\u0010j\u001a\u00020\rHÆ\u0003J\t\u0010k\u001a\u00020\rHÆ\u0003J\t\u0010l\u001a\u00020\tHÆ\u0003J\u0010\u0010m\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010JJ\t\u0010n\u001a\u00020\tHÆ\u0003J\u000b\u0010o\u001a\u0004\u0018\u00010$HÆ\u0003J\t\u0010p\u001a\u00020\tHÆ\u0003J\t\u0010q\u001a\u00020\tHÆ\u0003J\t\u0010r\u001a\u00020\tHÆ\u0003J\t\u0010s\u001a\u00020\u0006HÆ\u0003Jê\u0002\u0010t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u00062\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u00062\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0017\u001a\u00020\t2\b\b\u0002\u0010\u0018\u001a\u00020\t2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u001c\u001a\u00020\r2\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\b\b\u0002\u0010\u001e\u001a\u00020\r2\b\b\u0002\u0010\u001f\u001a\u00020\r2\b\b\u0002\u0010 \u001a\u00020\t2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\"\u001a\u00020\t2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\b\b\u0002\u0010%\u001a\u00020\t2\b\b\u0002\u0010&\u001a\u00020\t2\b\b\u0002\u0010'\u001a\u00020\t2\b\b\u0002\u0010(\u001a\u00020\u0006HÆ\u0001¢\u0006\u0002\u0010uJ\u0006\u0010v\u001a\u00020\u0006J\u0013\u0010w\u001a\u00020\t2\b\u0010x\u001a\u0004\u0018\u00010yHÖ\u0003J\t\u0010z\u001a\u00020\u0006HÖ\u0001J\u0016\u0010{\u001a\u00020|2\u0006\u0010}\u001a\u00020~2\u0006\u0010\u007f\u001a\u00020\u0006R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b/\u0010.R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u00100R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0011\u0010\u000e\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u00100R\u0011\u0010\u000f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b5\u0010.R\u0011\u0010\u0010\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b6\u0010.R\u0011\u0010\u0011\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b7\u0010.R\u0011\u0010\u0012\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b8\u0010.R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010;\u001a\u0004\b9\u0010:R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010;\u001a\u0004\b<\u0010:R\u0011\u0010\u0015\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b=\u0010.R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010;\u001a\u0004\b>\u0010:R\u0011\u0010\u0017\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b?\u00100R\u0011\u0010\u0018\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b@\u00100R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\bA\u00104R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\bB\u00104R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\bC\u00104R\u0011\u0010\u001c\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\bD\u00104R\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u0003¢\u0006\b\n\u0000\u001a\u0004\bE\u0010,R\u0011\u0010\u001e\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\bF\u00104R\u0011\u0010\u001f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\bG\u00104R\u0011\u0010 \u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\bH\u00100R\u0015\u0010!\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010K\u001a\u0004\bI\u0010JR\u0011\u0010\"\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\bL\u00100R\u0013\u0010#\u001a\u0004\u0018\u00010$¢\u0006\b\n\u0000\u001a\u0004\bM\u0010NR\u0011\u0010%\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\bO\u00100R\u0011\u0010&\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\bP\u00100R\u0011\u0010'\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\bQ\u00100R\u0011\u0010(\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\bR\u0010.¨\u0006\u0082\u0001"}, d2 = {"Lcom/larus/photopicker/v2/impl/model/MediaGalleryUIConfig;", "Landroid/os/Parcelable;", "tabs", "", "Lcom/larus/photopicker/v2/impl/model/MediaTab;", "spanCount", "", "maxSelectedCount", "isSingleSelectionMode", "", "mode", "Lcom/larus/platform/model/MediaPickerUIMode;", "displayType", "", "isSupportVideo", "bottomMenuInitHeight", "bottomMenuTotalHeight", "startNavigationBarColor", "defaultItemDecorationSpacing", "slideBottomItemDecorationSpacing", "slideUpItemDecorationSpacing", "defaultPaddingSpacing", "slideUpPaddingSpacing", "multiSelectConfirmed", "supportInput", "suggestedActionProvider", "initialInputText", "initialInputSnapshotId", "initialInputSourceNodeId", "initialAttachmentUris", "albumNodeId", "upstreamAlbumNodeId", "allowUnifiedPreview", "useUnifiedMediaCanvas", "mobilePreviewHostEnabled", "unifiedPreviewEntry", "Lcom/larus/platform/model/preview/MediaEntry;", "hideAlbumEntranceInInjectedInput", "onlyDisplayVideo", "supportOriginalImage", "landingTabIndex", "<init>", "(Ljava/util/List;IIZLcom/larus/platform/model/MediaPickerUIMode;Ljava/lang/String;ZIIIILjava/lang/Integer;Ljava/lang/Integer;ILjava/lang/Integer;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Boolean;ZLcom/larus/platform/model/preview/MediaEntry;ZZZI)V", "getTabs", "()Ljava/util/List;", "getSpanCount", "()I", "getMaxSelectedCount", "()Z", "getMode", "()Lcom/larus/platform/model/MediaPickerUIMode;", "getDisplayType", "()Ljava/lang/String;", "getBottomMenuInitHeight", "getBottomMenuTotalHeight", "getStartNavigationBarColor", "getDefaultItemDecorationSpacing", "getSlideBottomItemDecorationSpacing", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSlideUpItemDecorationSpacing", "getDefaultPaddingSpacing", "getSlideUpPaddingSpacing", "getMultiSelectConfirmed", "getSupportInput", "getSuggestedActionProvider", "getInitialInputText", "getInitialInputSnapshotId", "getInitialInputSourceNodeId", "getInitialAttachmentUris", "getAlbumNodeId", "getUpstreamAlbumNodeId", "getAllowUnifiedPreview", "getUseUnifiedMediaCanvas", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getMobilePreviewHostEnabled", "getUnifiedPreviewEntry", "()Lcom/larus/platform/model/preview/MediaEntry;", "getHideAlbumEntranceInInjectedInput", "getOnlyDisplayVideo", "getSupportOriginalImage", "getLandingTabIndex", "toString", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "copy", "(Ljava/util/List;IIZLcom/larus/platform/model/MediaPickerUIMode;Ljava/lang/String;ZIIIILjava/lang/Integer;Ljava/lang/Integer;ILjava/lang/Integer;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Boolean;ZLcom/larus/platform/model/preview/MediaEntry;ZZZI)Lcom/larus/photopicker/v2/impl/model/MediaGalleryUIConfig;", "describeContents", "equals", "other", "", "hashCode", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "Builder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MediaGalleryUIConfig implements Parcelable {
    public static final Parcelable.Creator<MediaGalleryUIConfig> CREATOR = null;
    public static final a G = null;
    public final boolean A;
    public final MediaEntry B;
    public final boolean C;
    public final boolean D;
    public final boolean E;
    public final int F;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<MediaTab> f364484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f364485b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f364486c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f364487d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MediaPickerUIMode f364488e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f364489f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f364490g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f364491h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f364492i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f364493j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f364494k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Integer f364495l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Integer f364496m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f364497n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Integer f364498o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f364499p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final boolean f364500q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final String f364501r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f364502s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final String f364503t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final String f364504u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final List<String> f364505v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final String f364506w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final String f364507x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final boolean f364508y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Boolean f364509z;

    public static final class a {
        public MediaEntry A;
        public boolean B;
        public boolean C;
        public int D;
        public boolean E;
        public int F;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List<? extends MediaTab> f364510a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f364511b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f364512c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f364513d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public MediaPickerUIMode f364514e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f364515f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f364516g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f364517h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f364518i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f364519j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f364520k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Integer f364521l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public Integer f364522m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public Integer f364523n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f364524o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public boolean f364525p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public String f364526q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public String f364527r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public String f364528s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public String f364529t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public List<String> f364530u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public String f364531v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public String f364532w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public boolean f364533x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public Boolean f364534y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public boolean f364535z;

        public final MediaGalleryUIConfig a() {
            List<? extends MediaTab> r100 = this.f364510a;
            int r101 = this.f364511b;
            int r102 = this.f364513d;
            boolean r103 = this.f364512c;
            MediaPickerUIMode r104 = this.f364514e;
            String r105 = this.f364515f;
            boolean r106 = this.f364516g;
            int r110 = this.f364517h;
            int r111 = this.f364518i;
            int r112 = this.f364519j;
            Integer r113 = this.f364521l;
            Integer r114 = this.f364522m;
            int r115 = this.f364520k;
            Integer r107 = this.f364523n;
            boolean r108 = this.f364524o;
            boolean r109 = this.f364525p;
            String r116 = this.f364526q;
            String r117 = this.f364527r;
            String r118 = this.f364528s;
            String r119 = this.f364529t;
            List<String> r120 = this.f364530u;
            String r121 = this.f364531v;
            String r122 = this.f364532w;
            boolean r123 = this.f364533x;
            Boolean r124 = this.f364534y;
            boolean r125 = this.f364535z;
            MediaEntry r126 = this.A;
            boolean r127 = this.B;
            boolean r128 = this.C;
            return new MediaGalleryUIConfig(r100, r101, r102, r103, r104, r105, r106, this.D, r110, r111, r112, r113, r114, r115, r107, r108, r109, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, this.E, this.F);
        }

        public a() {
            MediaTab r100 = MediaTab.ALL;
            this.f364510a = CollectionsKt.listOf(r100);
            this.f364511b = 4;
            this.f364513d = 1;
            this.f364514e = MediaPickerUIMode.NORMAL;
            this.f364515f = "album_display";
            this.f364529t = "";
            this.f364530u = CollectionsKt.emptyList();
            this.f364531v = "";
            this.f364532w = "";
            this.F = r100.getId();
        }
    }

    public static final class b {
    }

    public static final class c implements Parcelable.Creator<MediaGalleryUIConfig> {
        public c() {
        }

        @Override // android.os.Parcelable.Creator
        public final MediaGalleryUIConfig createFromParcel(Parcel r310) {
            Intrinsics.checkNotNullParameter(r310, "parcel");
            int r100 = r310.readInt();
            ArrayList r101 = new ArrayList(r100);
            int r102 = 0;
        L3:
            if (r102 == r100) goto L5;
            r101.add(MediaTab.valueOf(r310.readString()));
            r102 = r102 + 1;
            goto L3
        L5:
            int r103 = r310.readInt();
            int r104 = r310.readInt();
            if (r310.readInt() == 0) goto L8;
            boolean r105 = true;
        L9:
            MediaPickerUIMode r106 = MediaPickerUIMode.valueOf(r310.readString());
            String r107 = r310.readString();
            if (r310.readInt() == 0) goto L12;
            boolean r108 = true;
        L13:
            int r110 = r310.readInt();
            int r111 = r310.readInt();
            int r112 = r310.readInt();
            int r113 = r310.readInt();
            MediaEntry r114 = null;
            if (r310.readInt() != 0) goto L16;
            Integer r115 = null;
        L18:
            if (r310.readInt() != 0) goto L20;
            Integer r116 = null;
        L21:
            int r117 = r310.readInt();
            if (r310.readInt() != 0) goto L24;
            Integer r118 = null;
        L26:
            if (r310.readInt() == 0) goto L28;
            boolean r119 = true;
        L30:
            if (r310.readInt() == 0) goto L32;
            boolean r210 = true;
        L33:
            String r211 = r310.readString();
            String r212 = r310.readString();
            String r213 = r310.readString();
            String r214 = r310.readString();
            ArrayList<String> r215 = r310.createStringArrayList();
            String r216 = r310.readString();
            String r217 = r310.readString();
            if (r310.readInt() == 0) goto L36;
            boolean r218 = true;
        L38:
            if (r310.readInt() != 0) goto L41;
            Boolean r219 = null;
        L46:
            if (r310.readInt() == 0) goto L48;
            boolean r311 = true;
        L50:
            if (r310.readInt() == 0) goto L53;
            r114 = MediaEntry.valueOf(r310.readString());
        L53:
            MediaEntry r312 = r114;
            if (r310.readInt() == 0) goto L56;
            boolean r313 = true;
        L58:
            if (r310.readInt() == 0) goto L60;
            boolean r314 = true;
        L62:
            if (r310.readInt() == 0) goto L64;
            boolean r315 = true;
        L66:
            return new MediaGalleryUIConfig(r101, r103, r104, r105, r106, r107, r108, r110, r111, r112, r113, r115, r116, r117, r118, r119, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r311, r312, r313, r314, r315, r310.readInt());
        L64:
            r315 = false;
            goto L66
        L60:
            r314 = false;
            goto L62
        L56:
            r313 = false;
            goto L58
        L48:
            r311 = false;
            goto L50
        L41:
            if (r310.readInt() == 0) goto L43;
            boolean r220 = true;
        L44:
            r219 = Boolean.valueOf(r220);
            goto L46
        L43:
            r220 = false;
            goto L44
        L36:
            r218 = false;
            goto L38
        L32:
            r210 = false;
            goto L33
        L28:
            r119 = false;
            goto L30
        L24:
            r118 = Integer.valueOf(r310.readInt());
            goto L26
        L20:
            r116 = Integer.valueOf(r310.readInt());
            goto L21
        L16:
            r115 = Integer.valueOf(r310.readInt());
            goto L18
        L12:
            r108 = false;
            goto L13
        L8:
            r105 = false;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public final MediaGalleryUIConfig[] newArray(int r100) {
            return new MediaGalleryUIConfig[r100];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MediaGalleryUIConfig) == true) goto L8;
        return false;
    L8:
        MediaGalleryUIConfig r101 = (MediaGalleryUIConfig) r100;
        if (Intrinsics.areEqual(this.f364484a, r101.f364484a) == true) goto L12;
        return false;
    L12:
        if (this.f364485b == r101.f364485b) goto L15;
        return false;
    L15:
        if (this.f364486c == r101.f364486c) goto L18;
        return false;
    L18:
        if (this.f364487d == r101.f364487d) goto L21;
        return false;
    L21:
        if (this.f364488e == r101.f364488e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f364489f, r101.f364489f) == true) goto L27;
        return false;
    L27:
        if (this.f364490g == r101.f364490g) goto L30;
        return false;
    L30:
        if (this.f364491h == r101.f364491h) goto L33;
        return false;
    L33:
        if (this.f364492i == r101.f364492i) goto L36;
        return false;
    L36:
        if (this.f364493j == r101.f364493j) goto L39;
        return false;
    L39:
        if (this.f364494k == r101.f364494k) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f364495l, r101.f364495l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f364496m, r101.f364496m) == true) goto L48;
        return false;
    L48:
        if (this.f364497n == r101.f364497n) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f364498o, r101.f364498o) == true) goto L54;
        return false;
    L54:
        if (this.f364499p == r101.f364499p) goto L57;
        return false;
    L57:
        if (this.f364500q == r101.f364500q) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.f364501r, r101.f364501r) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.f364502s, r101.f364502s) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.f364503t, r101.f364503t) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.f364504u, r101.f364504u) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.f364505v, r101.f364505v) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.f364506w, r101.f364506w) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.f364507x, r101.f364507x) == true) goto L81;
        return false;
    L81:
        if (this.f364508y == r101.f364508y) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.f364509z, r101.f364509z) == true) goto L87;
        return false;
    L87:
        if (this.A == r101.A) goto L90;
        return false;
    L90:
        if (this.B == r101.B) goto L93;
        return false;
    L93:
        if (this.C == r101.C) goto L96;
        return false;
    L96:
        if (this.D == r101.D) goto L99;
        return false;
    L99:
        if (this.E == r101.E) goto L102;
        return false;
    L102:
        if (this.F == r101.F) goto L104;
        return false;
    L104:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f364484a.hashCode() * 31) + this.f364485b) * 31) + this.f364486c) * 31;
        int r101 = 1231;
        if (this.f364487d == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (((((r100 + r102) * 31) + this.f364488e.hashCode()) * 31) + this.f364489f.hashCode()) * 31;
        if (this.f364490g == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (((((((((r103 + r104) * 31) + this.f364491h) * 31) + this.f364492i) * 31) + this.f364493j) * 31) + this.f364494k) * 31;
        Integer r106 = this.f364495l;
        int r107 = 0;
        if (r106 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r105 + r108) * 31;
        Integer r110 = this.f364496m;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (((r109 + r111) * 31) + this.f364497n) * 31;
        Integer r113 = this.f364498o;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        if (this.f364499p == false) goto L25;
        int r116 = 1231;
    L26:
        int r117 = (r115 + r116) * 31;
        if (this.f364500q == false) goto L29;
        int r118 = 1231;
    L30:
        int r119 = (r117 + r118) * 31;
        String r120 = this.f364501r;
        if (r120 != null) goto L33;
        int r121 = 0;
    L34:
        int r122 = (r119 + r121) * 31;
        String r123 = this.f364502s;
        if (r123 != null) goto L37;
        int r124 = 0;
    L38:
        int r125 = (r122 + r124) * 31;
        String r126 = this.f364503t;
        if (r126 != null) goto L41;
        int r127 = 0;
    L42:
        int r128 = (((((((((r125 + r127) * 31) + this.f364504u.hashCode()) * 31) + this.f364505v.hashCode()) * 31) + this.f364506w.hashCode()) * 31) + this.f364507x.hashCode()) * 31;
        if (this.f364508y == false) goto L45;
        int r129 = 1231;
    L46:
        int r130 = (r128 + r129) * 31;
        Boolean r131 = this.f364509z;
        if (r131 != null) goto L49;
        int r132 = 0;
    L50:
        int r133 = (r130 + r132) * 31;
        if (this.A == false) goto L53;
        int r134 = 1231;
    L54:
        int r135 = (r133 + r134) * 31;
        MediaEntry r136 = this.B;
        if (r136 == null) goto L58;
        r107 = r136.hashCode();
    L58:
        int r137 = (r135 + r107) * 31;
        if (this.C == false) goto L61;
        int r138 = 1231;
    L62:
        int r139 = (r137 + r138) * 31;
        if (this.D == false) goto L65;
        int r140 = 1231;
    L66:
        int r141 = (r139 + r140) * 31;
        if (this.E == true) goto L71;
        r101 = 1237;
    L71:
        return ((r141 + r101) * 31) + this.F;
    L65:
        r140 = 1237;
        goto L66
    L61:
        r138 = 1237;
        goto L62
    L53:
        r134 = 1237;
        goto L54
    L49:
        r132 = r131.hashCode();
        goto L50
    L45:
        r129 = 1237;
        goto L46
    L41:
        r127 = r126.hashCode();
        goto L42
    L37:
        r124 = r123.hashCode();
        goto L38
    L33:
        r121 = r120.hashCode();
        goto L34
    L29:
        r118 = 1237;
        goto L30
    L25:
        r116 = 1237;
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r106.hashCode();
        goto L14
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        List<MediaTab> r102 = this.f364484a;
        r100.writeInt(r102.size());
        Iterator<MediaTab> r103 = r102.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r100.writeString(r103.next().name());
        goto L4
    L6:
        r100.writeInt(this.f364485b);
        r100.writeInt(this.f364486c);
        r100.writeInt(this.f364487d ? 1 : 0);
        r100.writeString(this.f364488e.name());
        r100.writeString(this.f364489f);
        r100.writeInt(this.f364490g ? 1 : 0);
        r100.writeInt(this.f364491h);
        r100.writeInt(this.f364492i);
        r100.writeInt(this.f364493j);
        r100.writeInt(this.f364494k);
        Integer r104 = this.f364495l;
        if (r104 != null) goto L9;
        r100.writeInt(0);
    L10:
        Integer r105 = this.f364496m;
        if (r105 != null) goto L13;
        r100.writeInt(0);
    L14:
        r100.writeInt(this.f364497n);
        Integer r106 = this.f364498o;
        if (r106 != null) goto L17;
        r100.writeInt(0);
    L18:
        r100.writeInt(this.f364499p ? 1 : 0);
        r100.writeInt(this.f364500q ? 1 : 0);
        r100.writeString(this.f364501r);
        r100.writeString(this.f364502s);
        r100.writeString(this.f364503t);
        r100.writeString(this.f364504u);
        r100.writeStringList(this.f364505v);
        r100.writeString(this.f364506w);
        r100.writeString(this.f364507x);
        r100.writeInt(this.f364508y ? 1 : 0);
        Boolean r107 = this.f364509z;
        if (r107 != null) goto L21;
        r100.writeInt(0);
    L22:
        r100.writeInt(this.A ? 1 : 0);
        MediaEntry r108 = this.B;
        if (r108 != null) goto L25;
        r100.writeInt(0);
    L26:
        r100.writeInt(this.C ? 1 : 0);
        r100.writeInt(this.D ? 1 : 0);
        r100.writeInt(this.E ? 1 : 0);
        r100.writeInt(this.F);
        return;
    L25:
        r100.writeInt(1);
        r100.writeString(r108.name());
        goto L26
    L21:
        r100.writeInt(1);
        r100.writeInt(r107.booleanValue() ? 1 : 0);
        goto L22
    L17:
        r100.writeInt(1);
        r100.writeInt(r106.intValue());
        goto L18
    L13:
        r100.writeInt(1);
        r100.writeInt(r105.intValue());
        goto L14
    L9:
        r100.writeInt(1);
        r100.writeInt(r104.intValue());
        goto L10
    }

    static {
        CREATOR = new c();
        a r100 = new a();
        List<? extends MediaTab> r101 = CollectionsKt.listOf(MediaTab.ALL);
        Intrinsics.checkNotNullParameter(r101, "tabs");
        r100.f364510a = r101;
        r100.f364511b = 4;
        r100.f364519j = i5.b();
        G = r100;
    }

    public final String toString() {
        return "tabs:" + this.f364484a + " spanCount:" + this.f364485b + " maxSelectedCount:" + this.f364486c + " isSingleSelectionMode:" + this.f364487d + " mode:" + this.f364488e + " displayType:" + this.f364489f + " isSupportVideo:" + this.f364490g + " bottomMenuInitHeight:" + this.f364491h + " bottomMenuTotalHeight:" + this.f364492i + " multiSelectConfirmed:" + this.f364499p + " supportInput:" + this.f364500q + " suggestedActionProvider:" + this.f364501r + " onlyDisplayVideo:" + this.D + " supportOriginalImage:" + this.E + " landingTabIndex:" + this.F;
    }

    public static MediaGalleryUIConfig a(MediaGalleryUIConfig r310, int r311, boolean r312, String r410, int r411) {
        if ((r411 & 1) == 0) goto L5;
        List<MediaTab> r100 = r310.f364484a;
    L7:
        if ((r411 & 2) == 0) goto L9;
        int r101 = r310.f364485b;
    L11:
        if ((r411 & 4) == 0) goto L13;
        int r102 = r310.f364486c;
    L15:
        if ((r411 & 8) == 0) goto L17;
        boolean r103 = r310.f364487d;
    L19:
        if ((r411 & 16) == 0) goto L21;
        MediaPickerUIMode r104 = r310.f364488e;
    L23:
        if ((r411 & 32) == 0) goto L25;
        String r110 = r310.f364489f;
    L27:
        if ((r411 & 64) == 0) goto L29;
        boolean r111 = r310.f364490g;
    L31:
        if ((r411 & 128) == 0) goto L33;
        int r112 = r310.f364491h;
    L35:
        if ((r411 & 256) == 0) goto L37;
        int r113 = r310.f364492i;
    L39:
        if ((r411 & 512) == 0) goto L41;
        int r114 = r310.f364493j;
    L43:
        if ((r411 & 1024) == 0) goto L45;
        int r115 = r310.f364494k;
    L47:
        if ((r411 & 2048) == 0) goto L49;
        Integer r116 = r310.f364495l;
    L51:
        if ((r411 & 4096) == 0) goto L53;
        Integer r117 = r310.f364496m;
    L55:
        if ((r411 & 8192) == 0) goto L57;
        int r118 = r310.f364497n;
    L59:
        if ((r411 & 16384) == 0) goto L61;
        Integer r119 = r310.f364498o;
    L63:
        if ((32768 & r411) == 0) goto L65;
        boolean r210 = r310.f364499p;
    L67:
        if ((65536 & r411) == 0) goto L69;
        boolean r211 = r310.f364500q;
    L71:
        if ((131072 & r411) == 0) goto L73;
        String r212 = r310.f364501r;
    L75:
        if ((262144 & r411) == 0) goto L77;
        String r213 = r310.f364502s;
    L79:
        if ((524288 & r411) == 0) goto L81;
        String r214 = r310.f364503t;
    L83:
        if ((1048576 & r411) == 0) goto L85;
        String r105 = r310.f364504u;
    L87:
        if ((r411 & 2097152) == 0) goto L89;
        List<String> r106 = r310.f364505v;
    L91:
        if ((r411 & 4194304) == 0) goto L93;
        String r107 = r310.f364506w;
    L94:
        int r313 = r115;
        if ((r411 & 8388608) == 0) goto L97;
        String r120 = r310.f364507x;
    L98:
        int r314 = r114;
        if ((r411 & 16777216) == 0) goto L101;
        boolean r215 = r310.f364508y;
    L103:
        if ((33554432 & r411) == 0) goto L105;
        Boolean r315 = r310.f364509z;
    L107:
        if ((67108864 & r411) == 0) goto L109;
        boolean r316 = r310.A;
    L111:
        if ((134217728 & r411) == 0) goto L113;
        MediaEntry r317 = r310.B;
    L115:
        if ((268435456 & r411) == 0) goto L117;
        boolean r318 = r310.C;
    L119:
        if ((536870912 & r411) == 0) goto L121;
        boolean r319 = r310.D;
    L123:
        if ((1073741824 & r411) == 0) goto L125;
        boolean r320 = r310.E;
    L127:
        if ((r411 & Integer.MIN_VALUE) == 0) goto L129;
        int r321 = r310.F;
    L130:
        r310.getClass();
        Intrinsics.checkNotNullParameter(r100, "tabs");
        Intrinsics.checkNotNullParameter(r104, "mode");
        Intrinsics.checkNotNullParameter(r110, "displayType");
        Intrinsics.checkNotNullParameter(r105, "initialInputSourceNodeId");
        Intrinsics.checkNotNullParameter(r106, "initialAttachmentUris");
        Intrinsics.checkNotNullParameter(r107, "albumNodeId");
        Intrinsics.checkNotNullParameter(r120, "upstreamAlbumNodeId");
        String r216 = r105;
        List<String> r217 = r106;
        return new MediaGalleryUIConfig(r100, r101, r102, r103, r104, r110, r111, r112, r113, r314, r313, r116, r117, r118, r119, r210, r211, r212, r213, r214, r216, r217, r107, r120, r215, r315, r316, r317, r318, r319, r320, r321);
    L129:
        r321 = 0;
        goto L130
    L125:
        r320 = false;
        goto L127
    L121:
        r319 = false;
        goto L123
    L117:
        r318 = false;
        goto L119
    L113:
        r317 = null;
        goto L115
    L109:
        r316 = false;
        goto L111
    L105:
        r315 = null;
        goto L107
    L101:
        r215 = false;
        goto L103
    L97:
        r120 = null;
        goto L98
    L93:
        r107 = null;
        goto L94
    L89:
        r106 = null;
        goto L91
    L85:
        r105 = null;
        goto L87
    L81:
        r214 = null;
        goto L83
    L77:
        r213 = null;
        goto L79
    L73:
        r212 = null;
        goto L75
    L69:
        r211 = false;
        goto L71
    L65:
        r210 = false;
        goto L67
    L61:
        r119 = null;
        goto L63
    L57:
        r118 = 0;
        goto L59
    L53:
        r117 = null;
        goto L55
    L49:
        r116 = null;
        goto L51
    L45:
        r115 = 0;
        goto L47
    L41:
        r114 = 0;
        goto L43
    L37:
        r113 = 0;
        goto L39
    L33:
        r112 = 0;
        goto L35
    L29:
        r111 = false;
        goto L31
    L25:
        r110 = r410;
        goto L27
    L21:
        r104 = null;
        goto L23
    L17:
        r103 = r312;
        goto L19
    L13:
        r102 = r311;
        goto L15
    L9:
        r101 = 0;
        goto L11
    L5:
        r100 = null;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MediaGalleryUIConfig(List<? extends MediaTab> r110, int r111, int r112, boolean r113, MediaPickerUIMode r114, String r115, boolean r116, int r117, int r118, int r119, int r210, Integer r211, Integer r212, int r213, Integer r214, boolean r215, boolean r216, String r217, String r218, String r219, String r310, List<String> r311, String r312, String r313, boolean r314, Boolean r315, boolean r316, MediaEntry r317, boolean r318, boolean r319, boolean r410, int r411) {
        Intrinsics.checkNotNullParameter(r110, "tabs");
        Intrinsics.checkNotNullParameter(r114, "mode");
        Intrinsics.checkNotNullParameter(r115, "displayType");
        Intrinsics.checkNotNullParameter(r310, "initialInputSourceNodeId");
        Intrinsics.checkNotNullParameter(r311, "initialAttachmentUris");
        Intrinsics.checkNotNullParameter(r312, "albumNodeId");
        Intrinsics.checkNotNullParameter(r313, "upstreamAlbumNodeId");
        this.f364484a = r110;
        this.f364485b = r111;
        this.f364486c = r112;
        this.f364487d = r113;
        this.f364488e = r114;
        this.f364489f = r115;
        this.f364490g = r116;
        this.f364491h = r117;
        this.f364492i = r118;
        this.f364493j = r119;
        this.f364494k = r210;
        this.f364495l = r211;
        this.f364496m = r212;
        this.f364497n = r213;
        this.f364498o = r214;
        this.f364499p = r215;
        this.f364500q = r216;
        this.f364501r = r217;
        this.f364502s = r218;
        this.f364503t = r219;
        this.f364504u = r310;
        this.f364505v = r311;
        this.f364506w = r312;
        this.f364507x = r313;
        this.f364508y = r314;
        this.f364509z = r315;
        this.A = r316;
        this.B = r317;
        this.C = r318;
        this.D = r319;
        this.E = r410;
        this.F = r411;
    }
}
