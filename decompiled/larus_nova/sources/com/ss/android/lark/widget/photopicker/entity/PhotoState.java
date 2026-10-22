package com.ss.android.lark.widget.photopicker.entity;

import android.graphics.Bitmap;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import androidx.lifecycle.MutableLiveData;
import com.lynx.serval.svg.SVGRenderEngine;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.io.File;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0002ABB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010/\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u001eJ\f\u00100\u001a\b\u0012\u0004\u0012\u00020 0\u001eJ\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00050\u001eJ\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00050\u001eJ\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00050\u001eJ\u000e\u00104\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010'0\u001eJ\u000e\u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010#0\u001eJ\u000e\u00106\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010)0\u001eJ\u0010\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010+J\b\u0010:\u001a\u0004\u0018\u00010+J\u000e\u0010;\u001a\u0002082\u0006\u0010<\u001a\u00020-J\u0006\u0010=\u001a\u00020-J\u000e\u0010>\u001a\u0002082\u0006\u0010?\u001a\u00020-J\u0006\u0010@\u001a\u00020-R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0006\"\u0004\b\n\u0010\bR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R \u0010\u0017\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00050\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010#0\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00050\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00050\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010'0\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010)0\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Lcom/ss/android/lark/widget/photopicker/entity/PhotoState;", "Ljava/io/Serializable;", "<init>", "()V", "isLoadOrigin", "", "()Z", "setLoadOrigin", "(Z)V", "isFromMe", "setFromMe", "originFile", "Ljava/io/File;", "getOriginFile", "()Ljava/io/File;", "setOriginFile", "(Ljava/io/File;)V", "middleFile", "getMiddleFile", "setMiddleFile", "thumbnailFile", "getThumbnailFile", "setThumbnailFile", "inlinePreviewDrawable", "Landroid/graphics/drawable/Drawable;", "getInlinePreviewDrawable", "()Landroid/graphics/drawable/Drawable;", "setInlinePreviewDrawable", "(Landroid/graphics/drawable/Drawable;)V", "showFile", "Landroidx/lifecycle/MutableLiveData;", "uiState", "Lcom/ss/android/lark/widget/photopicker/entity/PhotoState$UIState;", "clickLookOrigin", "downloadOriginProgress", "", "showTranslate", "showOCR", "ocrState", "Lcom/ss/android/lark/widget/photopicker/entity/PhotoOCRState;", "qrCodeState", "Lcom/ss/android/lark/widget/photopicker/entity/PhotoQRCodeState;", "screenShotProvider", "Lcom/ss/android/lark/widget/photopicker/entity/PhotoState$IScreenShotProvider;", "visibleRectBaseView", "Landroid/graphics/RectF;", "visibleRatioRectBaseContent", "getShowFile", "getUIState", "getClickLookOrigin", "getShowTranslate", "getShowOCR", "getOcrState", "getDownloadOriginProgress", "getQrCodeState", "setScreenShotProvider", "", ShortVideoSegments.KEY_PROP_PROVIDER, "getScreenShotProvider", "setVisibleRectBaseView", SVGRenderEngine.RECT, "getVisibleRectBaseView", "setVisibleRatioRectBaseContent", "ratioRect", "getVisibleRatioRectBaseContent", "UIState", "IScreenShotProvider", "photo-picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PhotoState implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient MutableLiveData<File> f447498a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient MutableLiveData<UIState> f447499b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient MutableLiveData<Boolean> f447500c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public transient MutableLiveData<Integer> f447501d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public transient MutableLiveData<Boolean> f447502e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public transient MutableLiveData<Boolean> f447503f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public transient MutableLiveData<b> f447504g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public transient MutableLiveData<c> f447505h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public transient a f447506i;
    private Drawable inlinePreviewDrawable;
    private boolean isFromMe;
    private boolean isLoadOrigin;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public transient RectF f447507j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public transient RectF f447508k;
    private File middleFile;
    private File originFile;
    private File thumbnailFile;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/widget/photopicker/entity/PhotoState$UIState;", "", "<init>", "(Ljava/lang/String;I)V", "HIDE_LOOK", "SHOW_LOOK", "LOADING", "DONE", "photo-picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum UIState extends Enum<UIState> {
        public static final UIState DONE = null;
        public static final UIState HIDE_LOOK = null;
        public static final UIState LOADING = null;
        public static final UIState SHOW_LOOK = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ UIState[] f447509a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f447510b = null;

        public static EnumEntries<UIState> getEntries() {
            return f447510b;
        }

        static {
            UIState r100 = new UIState("HIDE_LOOK", 0);
            HIDE_LOOK = r100;
            UIState r101 = new UIState("SHOW_LOOK", 1);
            SHOW_LOOK = r101;
            UIState r102 = new UIState("LOADING", 2);
            LOADING = r102;
            UIState r103 = new UIState("DONE", 3);
            DONE = r103;
            UIState[] r104 = {r100, r101, r102, r103};
            f447509a = r104;
            f447510b = EnumEntriesKt.enumEntries(r104);
        }

        public static UIState[] values() {
            return (UIState[]) f447509a.clone();
        }

        public static UIState valueOf(String r100) {
            return (UIState) r27.a.a(UIState.class, r100);
        }

        public UIState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public interface a {
        Bitmap a(boolean r100);
    }

    public final MutableLiveData<Boolean> getClickLookOrigin() {
        MutableLiveData<Boolean> r100 = this.f447500c;
        if (r100 != null) goto L5;
        r100 = new MutableLiveData();
    L5:
        this.f447500c = r100;
        return r100;
    }

    public final MutableLiveData<Integer> getDownloadOriginProgress() {
        MutableLiveData<Integer> r100 = this.f447501d;
        if (r100 != null) goto L5;
        r100 = new MutableLiveData();
    L5:
        this.f447501d = r100;
        return r100;
    }

    public final MutableLiveData<b> getOcrState() {
        MutableLiveData<b> r100 = this.f447504g;
        if (r100 != null) goto L5;
        r100 = new MutableLiveData();
    L5:
        this.f447504g = r100;
        return r100;
    }

    public final MutableLiveData<c> getQrCodeState() {
        MutableLiveData<c> r100 = this.f447505h;
        if (r100 != null) goto L5;
        r100 = new MutableLiveData();
    L5:
        this.f447505h = r100;
        return r100;
    }

    public final MutableLiveData<File> getShowFile() {
        MutableLiveData<File> r100 = this.f447498a;
        if (r100 != null) goto L5;
        r100 = new MutableLiveData();
    L5:
        this.f447498a = r100;
        return r100;
    }

    public final MutableLiveData<Boolean> getShowOCR() {
        MutableLiveData<Boolean> r100 = this.f447503f;
        if (r100 != null) goto L5;
        r100 = new MutableLiveData();
    L5:
        this.f447503f = r100;
        return r100;
    }

    public final MutableLiveData<Boolean> getShowTranslate() {
        MutableLiveData<Boolean> r100 = this.f447502e;
        if (r100 != null) goto L5;
        r100 = new MutableLiveData();
    L5:
        this.f447502e = r100;
        return r100;
    }

    public final MutableLiveData<UIState> getUIState() {
        MutableLiveData<UIState> r100 = this.f447499b;
        if (r100 != null) goto L5;
        r100 = new MutableLiveData();
    L5:
        this.f447499b = r100;
        return r100;
    }

    public PhotoState() {
        this.f447498a = new MutableLiveData();
        this.f447499b = new MutableLiveData();
        this.f447500c = new MutableLiveData();
        this.f447501d = new MutableLiveData();
        this.f447502e = new MutableLiveData();
        this.f447503f = new MutableLiveData();
        this.f447504g = new MutableLiveData();
        this.f447505h = new MutableLiveData();
        this.f447507j = new RectF();
        this.f447508k = new RectF(0.0f, 0.0f, 1.0f, 1.0f);
    }

    public final Drawable getInlinePreviewDrawable() {
        return this.inlinePreviewDrawable;
    }

    public final File getMiddleFile() {
        return this.middleFile;
    }

    public final File getOriginFile() {
        return this.originFile;
    }

    public final a getScreenShotProvider() {
        return this.f447506i;
    }

    public final File getThumbnailFile() {
        return this.thumbnailFile;
    }

    public final RectF getVisibleRatioRectBaseContent() {
        return this.f447508k;
    }

    public final RectF getVisibleRectBaseView() {
        return this.f447507j;
    }

    public final boolean isFromMe() {
        return this.isFromMe;
    }

    public final boolean isLoadOrigin() {
        return this.isLoadOrigin;
    }

    public final void setFromMe(boolean r100) {
        this.isFromMe = r100;
    }

    public final void setInlinePreviewDrawable(Drawable r100) {
        this.inlinePreviewDrawable = r100;
    }

    public final void setLoadOrigin(boolean r100) {
        this.isLoadOrigin = r100;
    }

    public final void setMiddleFile(File r100) {
        this.middleFile = r100;
    }

    public final void setOriginFile(File r100) {
        this.originFile = r100;
    }

    public final void setScreenShotProvider(a r100) {
        this.f447506i = r100;
    }

    public final void setThumbnailFile(File r100) {
        this.thumbnailFile = r100;
    }

    public final void setVisibleRatioRectBaseContent(RectF r100) {
        Intrinsics.checkNotNullParameter(r100, "ratioRect");
        this.f447508k = r100;
    }

    public final void setVisibleRectBaseView(RectF r100) {
        Intrinsics.checkNotNullParameter(r100, SVGRenderEngine.RECT);
        this.f447507j = r100;
    }
}
